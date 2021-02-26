package com.google.inject.spi;

import com.google.inject.ConfigurationException;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.Annotations;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.ImmutableList;
import com.google.inject.internal.ImmutableSet;
import com.google.inject.internal.Lists;
import com.google.inject.internal.MoreTypes;
import com.google.inject.internal.Nullability;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class InjectionPoint {
    private final ImmutableList<Dependency<?>> dependencies;
    private final Member member;
    private final boolean optional;

    private interface Factory<M extends Member & AnnotatedElement> {
        public static final Factory<Field> FIELDS = new Factory<Field>() {
            public Field[] getMembers(Class<?> cls) {
                return cls.getDeclaredFields();
            }

            public InjectionPoint create(TypeLiteral<?> typeLiteral, Field field, Errors errors) {
                return new InjectionPoint(typeLiteral, field);
            }
        };
        public static final Factory<Method> METHODS = new Factory<Method>() {
            public Method[] getMembers(Class<?> cls) {
                return cls.getDeclaredMethods();
            }

            public InjectionPoint create(TypeLiteral<?> typeLiteral, Method method, Errors errors) {
                InjectionPoint.checkForMisplacedBindingAnnotations(method, errors);
                return new InjectionPoint(typeLiteral, method);
            }
        };

        InjectionPoint create(TypeLiteral<?> typeLiteral, M m, Errors errors);

        M[] getMembers(Class<?> cls);
    }

    private InjectionPoint(Member member2, ImmutableList<Dependency<?>> immutableList, boolean z) {
        this.member = member2;
        this.dependencies = immutableList;
        this.optional = z;
    }

    InjectionPoint(TypeLiteral<?> typeLiteral, Method method) {
        this.member = method;
        this.optional = ((Inject) method.getAnnotation(Inject.class)).optional();
        this.dependencies = forMember(method, typeLiteral, method.getParameterAnnotations());
    }

    InjectionPoint(TypeLiteral<?> typeLiteral, Constructor<?> constructor) {
        this.member = constructor;
        this.optional = false;
        this.dependencies = forMember(constructor, typeLiteral, constructor.getParameterAnnotations());
    }

    InjectionPoint(TypeLiteral<?> typeLiteral, Field field) {
        Key<?> key;
        this.member = field;
        this.optional = ((Inject) field.getAnnotation(Inject.class)).optional();
        Annotation[] annotations = field.getAnnotations();
        Errors errors = new Errors(field);
        try {
            key = Annotations.getKey(typeLiteral.getFieldType(field), field, annotations, errors);
        } catch (ErrorsException e) {
            errors.merge(e.getErrors());
            key = null;
        }
        errors.throwConfigurationExceptionIfErrorsExist();
        this.dependencies = ImmutableList.m336of(newDependency(key, Nullability.allowsNull(annotations), -1));
    }

    private ImmutableList<Dependency<?>> forMember(Member member2, TypeLiteral<?> typeLiteral, Annotation[][] annotationArr) {
        Errors errors = new Errors(member2);
        Iterator it = Arrays.asList(annotationArr).iterator();
        ArrayList newArrayList = Lists.newArrayList();
        int i = 0;
        for (TypeLiteral next : typeLiteral.getParameterTypes(member2)) {
            try {
                Annotation[] annotationArr2 = (Annotation[]) it.next();
                newArrayList.add(newDependency(Annotations.getKey(next, member2, annotationArr2, errors), Nullability.allowsNull(annotationArr2), i));
                i++;
            } catch (ErrorsException e) {
                errors.merge(e.getErrors());
            }
        }
        errors.throwConfigurationExceptionIfErrorsExist();
        return ImmutableList.copyOf(newArrayList);
    }

    private <T> Dependency<T> newDependency(Key<T> key, boolean z, int i) {
        return new Dependency<>(this, key, z, i);
    }

    public Member getMember() {
        return this.member;
    }

    public List<Dependency<?>> getDependencies() {
        return this.dependencies;
    }

    public boolean isOptional() {
        return this.optional;
    }

    public boolean equals(Object obj) {
        return (obj instanceof InjectionPoint) && this.member.equals(((InjectionPoint) obj).member);
    }

    public int hashCode() {
        return this.member.hashCode();
    }

    public String toString() {
        return MoreTypes.toString(this.member);
    }

    public static InjectionPoint forConstructorOf(TypeLiteral<?> typeLiteral) {
        Class<?> rawType = MoreTypes.getRawType(typeLiteral.getType());
        Errors errors = new Errors(rawType);
        Constructor constructor = null;
        for (Constructor constructor2 : rawType.getDeclaredConstructors()) {
            Inject inject = (Inject) constructor2.getAnnotation(Inject.class);
            if (inject != null) {
                if (inject.optional()) {
                    errors.optionalConstructor(constructor2);
                }
                if (constructor != null) {
                    errors.tooManyConstructors(rawType);
                }
                checkForMisplacedBindingAnnotations(constructor2, errors);
                constructor = constructor2;
            }
        }
        errors.throwConfigurationExceptionIfErrorsExist();
        if (constructor != null) {
            return new InjectionPoint(typeLiteral, (Constructor<?>) constructor);
        }
        try {
            Constructor<?> declaredConstructor = rawType.getDeclaredConstructor(new Class[0]);
            if (Modifier.isPrivate(declaredConstructor.getModifiers())) {
                if (!Modifier.isPrivate(rawType.getModifiers())) {
                    errors.missingConstructor(rawType);
                    throw new ConfigurationException(errors.getMessages());
                }
            }
            checkForMisplacedBindingAnnotations(declaredConstructor, errors);
            return new InjectionPoint(typeLiteral, declaredConstructor);
        } catch (NoSuchMethodException unused) {
            errors.missingConstructor(rawType);
            throw new ConfigurationException(errors.getMessages());
        }
    }

    public static InjectionPoint forConstructorOf(Class<?> cls) {
        return forConstructorOf(TypeLiteral.get(cls));
    }

    public static Set<InjectionPoint> forStaticMethodsAndFields(TypeLiteral typeLiteral) {
        ArrayList newArrayList = Lists.newArrayList();
        Errors errors = new Errors();
        addInjectionPoints(typeLiteral, Factory.FIELDS, true, newArrayList, errors);
        addInjectionPoints(typeLiteral, Factory.METHODS, true, newArrayList, errors);
        ImmutableSet copyOf = ImmutableSet.copyOf(newArrayList);
        if (!errors.hasErrors()) {
            return copyOf;
        }
        throw new ConfigurationException(errors.getMessages()).withPartialValue(copyOf);
    }

    public static Set<InjectionPoint> forStaticMethodsAndFields(Class<?> cls) {
        return forStaticMethodsAndFields((TypeLiteral) TypeLiteral.get(cls));
    }

    public static Set<InjectionPoint> forInstanceMethodsAndFields(TypeLiteral<?> typeLiteral) {
        ArrayList newArrayList = Lists.newArrayList();
        Errors errors = new Errors();
        addInjectionPoints(typeLiteral, Factory.FIELDS, false, newArrayList, errors);
        addInjectionPoints(typeLiteral, Factory.METHODS, false, newArrayList, errors);
        ImmutableSet copyOf = ImmutableSet.copyOf(newArrayList);
        if (!errors.hasErrors()) {
            return copyOf;
        }
        throw new ConfigurationException(errors.getMessages()).withPartialValue(copyOf);
    }

    public static Set<InjectionPoint> forInstanceMethodsAndFields(Class<?> cls) {
        return forInstanceMethodsAndFields(TypeLiteral.get(cls));
    }

    /* access modifiers changed from: private */
    public static void checkForMisplacedBindingAnnotations(Member member2, Errors errors) {
        Annotation findBindingAnnotation = Annotations.findBindingAnnotation(errors, member2, ((AnnotatedElement) member2).getAnnotations());
        if (findBindingAnnotation != null) {
            if (member2 instanceof Method) {
                try {
                    if (member2.getDeclaringClass().getDeclaredField(member2.getName()) != null) {
                        return;
                    }
                } catch (NoSuchFieldException unused) {
                }
            }
            errors.misplacedBindingAnnotation(member2, findBindingAnnotation);
        }
    }

    private static <M extends Member & AnnotatedElement> void addInjectionPoints(TypeLiteral<?> typeLiteral, Factory<M> factory, boolean z, Collection<InjectionPoint> collection, Errors errors) {
        if (typeLiteral.getType() != Object.class) {
            addInjectionPoints(typeLiteral.getSupertype(typeLiteral.getRawType().getSuperclass()), factory, z, collection, errors);
            addInjectorsForMembers(typeLiteral, factory, z, collection, errors);
        }
    }

    private static <M extends Member & AnnotatedElement> void addInjectorsForMembers(TypeLiteral<?> typeLiteral, Factory<M> factory, boolean z, Collection<InjectionPoint> collection, Errors errors) {
        Inject inject;
        for (Member member2 : factory.getMembers(MoreTypes.getRawType(typeLiteral.getType()))) {
            if (isStatic(member2) == z && (inject = (Inject) ((AnnotatedElement) member2).getAnnotation(Inject.class)) != null) {
                try {
                    collection.add(factory.create(typeLiteral, member2, errors));
                } catch (ConfigurationException e) {
                    if (!inject.optional()) {
                        errors.merge(e.getErrorMessages());
                    }
                }
            }
        }
    }

    private static boolean isStatic(Member member2) {
        return Modifier.isStatic(member2.getModifiers());
    }
}
