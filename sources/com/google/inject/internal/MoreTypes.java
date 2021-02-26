package com.google.inject.internal;

import com.google.inject.ConfigurationException;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.ImmutableMap;
import com.google.inject.spi.Message;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Map;
import java.util.NoSuchElementException;

public class MoreTypes {
    public static final Type[] EMPTY_TYPE_ARRAY = new Type[0];
    private static final Map<TypeLiteral<?>, TypeLiteral<?>> PRIMITIVE_TO_WRAPPER = new ImmutableMap.Builder().put(TypeLiteral.get(Boolean.TYPE), TypeLiteral.get(Boolean.class)).put(TypeLiteral.get(Byte.TYPE), TypeLiteral.get(Byte.class)).put(TypeLiteral.get(Short.TYPE), TypeLiteral.get(Short.class)).put(TypeLiteral.get(Integer.TYPE), TypeLiteral.get(Integer.class)).put(TypeLiteral.get(Long.TYPE), TypeLiteral.get(Long.class)).put(TypeLiteral.get(Float.TYPE), TypeLiteral.get(Float.class)).put(TypeLiteral.get(Double.TYPE), TypeLiteral.get(Double.class)).put(TypeLiteral.get(Character.TYPE), TypeLiteral.get(Character.class)).put(TypeLiteral.get(Void.TYPE), TypeLiteral.get(Void.class)).build();

    private interface CompositeType {
        boolean isFullySpecified();
    }

    private MoreTypes() {
    }

    public static <T> TypeLiteral<T> makeKeySafe(TypeLiteral<T> typeLiteral) {
        if (isFullySpecified(typeLiteral.getType())) {
            TypeLiteral<T> typeLiteral2 = PRIMITIVE_TO_WRAPPER.get(typeLiteral);
            return typeLiteral2 != null ? typeLiteral2 : typeLiteral;
        }
        throw new ConfigurationException(ImmutableSet.m349of(new Message(typeLiteral + " cannot be used as a key; It is not fully specified.")));
    }

    /* access modifiers changed from: private */
    public static boolean isFullySpecified(Type type) {
        if (type instanceof Class) {
            return true;
        }
        if (type instanceof CompositeType) {
            return ((CompositeType) type).isFullySpecified();
        }
        if (type instanceof TypeVariable) {
            return false;
        }
        return ((CompositeType) canonicalize(type)).isFullySpecified();
    }

    public static Type canonicalize(Type type) {
        if (!(type instanceof ParameterizedTypeImpl) && !(type instanceof GenericArrayTypeImpl) && !(type instanceof WildcardTypeImpl)) {
            if (type instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) type;
                return new ParameterizedTypeImpl(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
            } else if (type instanceof GenericArrayType) {
                return new GenericArrayTypeImpl(((GenericArrayType) type).getGenericComponentType());
            } else {
                if (type instanceof Class) {
                    Class cls = (Class) type;
                    if (cls.isArray()) {
                        return new GenericArrayTypeImpl(cls.getComponentType());
                    }
                }
                if (type instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type;
                    return new WildcardTypeImpl(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
                }
            }
        }
        return type;
    }

    public static Member serializableCopy(Member member) {
        return member instanceof MemberImpl ? member : new MemberImpl(member);
    }

    public static Class<?> getRawType(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            Preconditions.checkArgument(rawType instanceof Class, "Expected a Class, but <%s> is of type %s", type, type.getClass().getName());
            return (Class) rawType;
        } else if (type instanceof GenericArrayType) {
            return Object[].class;
        } else {
            if (type instanceof TypeVariable) {
                return Object.class;
            }
            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + type.getClass().getName());
        }
    }

    public static boolean equals(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            if (!Objects.equal(parameterizedType.getOwnerType(), parameterizedType2.getOwnerType()) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                return false;
            }
            return true;
        } else if (type instanceof GenericArrayType) {
            if (!(type2 instanceof GenericArrayType)) {
                return false;
            }
            return equals(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
        } else if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                return false;
            }
            return true;
        } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        } else {
            TypeVariable typeVariable = (TypeVariable) type;
            TypeVariable typeVariable2 = (TypeVariable) type2;
            if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || !typeVariable.getName().equals(typeVariable2.getName())) {
                return false;
            }
            return true;
        }
    }

    public static int hashCode(Type type) {
        if (type instanceof Class) {
            return type.hashCode();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return hashCodeOrZero(parameterizedType.getOwnerType()) ^ (Arrays.hashCode(parameterizedType.getActualTypeArguments()) ^ parameterizedType.getRawType().hashCode());
        } else if (type instanceof GenericArrayType) {
            return hashCode(((GenericArrayType) type).getGenericComponentType());
        } else {
            if (!(type instanceof WildcardType)) {
                return hashCodeOrZero(type);
            }
            WildcardType wildcardType = (WildcardType) type;
            return Arrays.hashCode(wildcardType.getUpperBounds()) ^ Arrays.hashCode(wildcardType.getLowerBounds());
        }
    }

    private static int hashCodeOrZero(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static String toString(Type type) {
        if (type instanceof Class) {
            return ((Class) type).getName();
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            Type ownerType = parameterizedType.getOwnerType();
            StringBuilder sb = new StringBuilder();
            if (ownerType != null) {
                sb.append(toString(ownerType));
                sb.append(".");
            }
            sb.append(toString(parameterizedType.getRawType()));
            if (actualTypeArguments.length > 0) {
                sb.append("<");
                sb.append(toString(actualTypeArguments[0]));
                for (int i = 1; i < actualTypeArguments.length; i++) {
                    sb.append(", ");
                    sb.append(toString(actualTypeArguments[i]));
                }
            }
            sb.append(">");
            return sb.toString();
        } else if (type instanceof GenericArrayType) {
            return toString(((GenericArrayType) type).getGenericComponentType()) + "[]";
        } else if (!(type instanceof WildcardType)) {
            return type.toString();
        } else {
            WildcardType wildcardType = (WildcardType) type;
            Type[] lowerBounds = wildcardType.getLowerBounds();
            Type[] upperBounds = wildcardType.getUpperBounds();
            if (upperBounds.length != 1 || lowerBounds.length > 1) {
                throw new UnsupportedOperationException("Unsupported wildcard type " + type);
            } else if (lowerBounds.length == 1) {
                if (upperBounds[0] == Object.class) {
                    return "? super " + toString(lowerBounds[0]);
                }
                throw new UnsupportedOperationException("Unsupported wildcard type " + type);
            } else if (upperBounds[0] == Object.class) {
                return "?";
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("? extends ");
                sb2.append(toString(upperBounds[0]));
                return sb2.toString();
            }
        }
    }

    public static Class<? extends Member> memberType(Member member) {
        Preconditions.checkNotNull(member, "member");
        if (member instanceof MemberImpl) {
            return ((MemberImpl) member).memberType;
        }
        if (member instanceof Field) {
            return Field.class;
        }
        if (member instanceof Method) {
            return Method.class;
        }
        if (member instanceof Constructor) {
            return Constructor.class;
        }
        throw new IllegalArgumentException("Unsupported implementation class for Member, " + member.getClass());
    }

    public static String toString(Member member) {
        Class<? extends Member> memberType = memberType(member);
        if (memberType == Method.class) {
            return member.getDeclaringClass().getName() + "." + member.getName() + "()";
        } else if (memberType == Field.class) {
            return member.getDeclaringClass().getName() + "." + member.getName();
        } else if (memberType == Constructor.class) {
            return member.getDeclaringClass().getName() + ".<init>()";
        } else {
            throw new AssertionError();
        }
    }

    public static String memberKey(Member member) {
        Preconditions.checkNotNull(member, "member");
        return "<NO_MEMBER_KEY>";
    }

    public static Type getGenericSupertype(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 == cls) {
            return type;
        }
        if (cls2.isInterface()) {
            Class<?>[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            for (int i = 0; i < length; i++) {
                if (interfaces[i] == cls2) {
                    return cls.getGenericInterfaces()[i];
                }
                if (cls2.isAssignableFrom(interfaces[i])) {
                    return getGenericSupertype(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                }
            }
        }
        if (!cls.isInterface()) {
            while (cls != Object.class) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass == cls2) {
                    return cls.getGenericSuperclass();
                }
                if (cls2.isAssignableFrom(superclass)) {
                    return getGenericSupertype(cls.getGenericSuperclass(), superclass, cls2);
                }
                cls = superclass;
            }
        }
        return cls2;
    }

    public static Type resolveTypeVariable(Type type, Class<?> cls, TypeVariable typeVariable) {
        Class<?> declaringClassOf = declaringClassOf(typeVariable);
        if (declaringClassOf == null) {
            return typeVariable;
        }
        Type genericSupertype = getGenericSupertype(type, cls, declaringClassOf);
        if (!(genericSupertype instanceof ParameterizedType)) {
            return typeVariable;
        }
        return ((ParameterizedType) genericSupertype).getActualTypeArguments()[indexOf(declaringClassOf.getTypeParameters(), typeVariable)];
    }

    private static int indexOf(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    private static Class<?> declaringClassOf(TypeVariable typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    public static class ParameterizedTypeImpl implements ParameterizedType, Serializable, CompositeType {
        private static final long serialVersionUID = 0;
        private final Type ownerType;
        private final Type rawType;
        private final Type[] typeArguments;

        public ParameterizedTypeImpl(Type type, Type type2, Type... typeArr) {
            Type type3;
            int i = 0;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                Preconditions.checkArgument(type != null || cls.getEnclosingClass() == null, "No owner type for enclosed %s", type2);
                Preconditions.checkArgument(type == null || cls.getEnclosingClass() != null, "Owner type for unenclosed %s", type2);
            }
            if (type == null) {
                type3 = null;
            } else {
                type3 = MoreTypes.canonicalize(type);
            }
            this.ownerType = type3;
            this.rawType = MoreTypes.canonicalize(type2);
            this.typeArguments = (Type[]) typeArr.clone();
            while (true) {
                Type[] typeArr2 = this.typeArguments;
                if (i < typeArr2.length) {
                    Preconditions.checkNotNull(typeArr2[i], "type parameter");
                    MoreTypes.checkNotPrimitive(this.typeArguments[i], "type parameters");
                    Type[] typeArr3 = this.typeArguments;
                    typeArr3[i] = MoreTypes.canonicalize(typeArr3[i]);
                    i++;
                } else {
                    return;
                }
            }
        }

        public Type[] getActualTypeArguments() {
            return (Type[]) this.typeArguments.clone();
        }

        public Type getRawType() {
            return this.rawType;
        }

        public Type getOwnerType() {
            return this.ownerType;
        }

        public boolean isFullySpecified() {
            Type type = this.ownerType;
            if ((type != null && !MoreTypes.isFullySpecified(type)) || !MoreTypes.isFullySpecified(this.rawType)) {
                return false;
            }
            for (Type access$300 : this.typeArguments) {
                if (!MoreTypes.isFullySpecified(access$300)) {
                    return false;
                }
            }
            return true;
        }

        public boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && MoreTypes.equals(this, (ParameterizedType) obj);
        }

        public int hashCode() {
            return MoreTypes.hashCode(this);
        }

        public String toString() {
            return MoreTypes.toString((Type) this);
        }
    }

    public static class GenericArrayTypeImpl implements GenericArrayType, Serializable, CompositeType {
        private static final long serialVersionUID = 0;
        private final Type componentType;

        public GenericArrayTypeImpl(Type type) {
            this.componentType = MoreTypes.canonicalize(type);
        }

        public Type getGenericComponentType() {
            return this.componentType;
        }

        public boolean isFullySpecified() {
            return MoreTypes.isFullySpecified(this.componentType);
        }

        public boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && MoreTypes.equals(this, (GenericArrayType) obj);
        }

        public int hashCode() {
            return MoreTypes.hashCode(this);
        }

        public String toString() {
            return MoreTypes.toString((Type) this);
        }
    }

    public static class WildcardTypeImpl implements WildcardType, Serializable, CompositeType {
        private static final long serialVersionUID = 0;
        private final Type lowerBound;
        private final Type upperBound;

        public WildcardTypeImpl(Type[] typeArr, Type[] typeArr2) {
            boolean z = true;
            Preconditions.checkArgument(typeArr2.length <= 1, "Must have at most one lower bound.");
            Preconditions.checkArgument(typeArr.length == 1, "Must have exactly one upper bound.");
            if (typeArr2.length == 1) {
                Preconditions.checkNotNull(typeArr2[0], "lowerBound");
                MoreTypes.checkNotPrimitive(typeArr2[0], "wildcard bounds");
                Preconditions.checkArgument(typeArr[0] != Object.class ? false : z, "bounded both ways");
                this.lowerBound = MoreTypes.canonicalize(typeArr2[0]);
                this.upperBound = Object.class;
                return;
            }
            Preconditions.checkNotNull(typeArr[0], "upperBound");
            MoreTypes.checkNotPrimitive(typeArr[0], "wildcard bounds");
            this.lowerBound = null;
            this.upperBound = MoreTypes.canonicalize(typeArr[0]);
        }

        public Type[] getUpperBounds() {
            return new Type[]{this.upperBound};
        }

        public Type[] getLowerBounds() {
            Type type = this.lowerBound;
            if (type == null) {
                return MoreTypes.EMPTY_TYPE_ARRAY;
            }
            return new Type[]{type};
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r0 = r1.lowerBound;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isFullySpecified() {
            /*
                r1 = this;
                java.lang.reflect.Type r0 = r1.upperBound
                boolean r0 = com.google.inject.internal.MoreTypes.isFullySpecified(r0)
                if (r0 == 0) goto L_0x0014
                java.lang.reflect.Type r0 = r1.lowerBound
                if (r0 == 0) goto L_0x0012
                boolean r0 = com.google.inject.internal.MoreTypes.isFullySpecified(r0)
                if (r0 == 0) goto L_0x0014
            L_0x0012:
                r0 = 1
                goto L_0x0015
            L_0x0014:
                r0 = 0
            L_0x0015:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.inject.internal.MoreTypes.WildcardTypeImpl.isFullySpecified():boolean");
        }

        public boolean equals(Object obj) {
            return (obj instanceof WildcardType) && MoreTypes.equals(this, (WildcardType) obj);
        }

        public int hashCode() {
            return MoreTypes.hashCode(this);
        }

        public String toString() {
            return MoreTypes.toString((Type) this);
        }
    }

    /* access modifiers changed from: private */
    public static void checkNotPrimitive(Type type, String str) {
        Preconditions.checkArgument(!(type instanceof Class) || !((Class) type).isPrimitive(), "Primitive types are not allowed in %s: %s", str, type);
    }

    public static class MemberImpl implements Member, Serializable {
        private final Class<?> declaringClass;
        private final String memberKey;
        /* access modifiers changed from: private */
        public final Class<? extends Member> memberType;
        private final int modifiers;
        private final String name;
        private final boolean synthetic;

        private MemberImpl(Member member) {
            this.declaringClass = member.getDeclaringClass();
            this.name = member.getName();
            this.modifiers = member.getModifiers();
            this.synthetic = member.isSynthetic();
            this.memberType = MoreTypes.memberType(member);
            this.memberKey = MoreTypes.memberKey(member);
        }

        public Class getDeclaringClass() {
            return this.declaringClass;
        }

        public String getName() {
            return this.name;
        }

        public int getModifiers() {
            return this.modifiers;
        }

        public boolean isSynthetic() {
            return this.synthetic;
        }

        public String toString() {
            return MoreTypes.toString((Member) this);
        }
    }
}
