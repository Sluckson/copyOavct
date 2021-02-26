package com.google.inject.matcher;

import com.google.inject.internal.Preconditions;
import com.lowagie.text.ElementTags;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class Matchers {
    private static final Matcher<Object> ANY = new Any();

    private Matchers() {
    }

    public static Matcher<Object> any() {
        return ANY;
    }

    private static class Any extends AbstractMatcher<Object> implements Serializable {
        private static final long serialVersionUID = 0;

        public boolean matches(Object obj) {
            return true;
        }

        public String toString() {
            return "any()";
        }

        private Any() {
        }

        public Object readResolve() {
            return Matchers.any();
        }
    }

    public static <T> Matcher<T> not(Matcher<? super T> matcher) {
        return new Not(matcher);
    }

    private static class Not<T> extends AbstractMatcher<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final Matcher<? super T> delegate;

        private Not(Matcher<? super T> matcher) {
            this.delegate = (Matcher) Preconditions.checkNotNull(matcher, "delegate");
        }

        public boolean matches(T t) {
            return !this.delegate.matches(t);
        }

        public boolean equals(Object obj) {
            return (obj instanceof Not) && ((Not) obj).delegate.equals(this.delegate);
        }

        public int hashCode() {
            return -this.delegate.hashCode();
        }

        public String toString() {
            return "not(" + this.delegate + ")";
        }
    }

    /* access modifiers changed from: private */
    public static void checkForRuntimeRetention(Class<? extends Annotation> cls) {
        Retention retention = (Retention) cls.getAnnotation(Retention.class);
        boolean z = retention != null && retention.value() == RetentionPolicy.RUNTIME;
        Preconditions.checkArgument(z, "Annotation " + cls.getSimpleName() + " is missing RUNTIME retention");
    }

    public static Matcher<AnnotatedElement> annotatedWith(Class<? extends Annotation> cls) {
        return new AnnotatedWithType(cls);
    }

    private static class AnnotatedWithType extends AbstractMatcher<AnnotatedElement> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Class<? extends Annotation> annotationType;

        public AnnotatedWithType(Class<? extends Annotation> cls) {
            this.annotationType = (Class) Preconditions.checkNotNull(cls, "annotation type");
            Matchers.checkForRuntimeRetention(cls);
        }

        public boolean matches(AnnotatedElement annotatedElement) {
            return annotatedElement.getAnnotation(this.annotationType) != null;
        }

        public boolean equals(Object obj) {
            return (obj instanceof AnnotatedWithType) && ((AnnotatedWithType) obj).annotationType.equals(this.annotationType);
        }

        public int hashCode() {
            return this.annotationType.hashCode() * 37;
        }

        public String toString() {
            return "annotatedWith(" + this.annotationType.getSimpleName() + ".class)";
        }
    }

    public static Matcher<AnnotatedElement> annotatedWith(Annotation annotation) {
        return new AnnotatedWith(annotation);
    }

    private static class AnnotatedWith extends AbstractMatcher<AnnotatedElement> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Annotation annotation;

        public AnnotatedWith(Annotation annotation2) {
            this.annotation = (Annotation) Preconditions.checkNotNull(annotation2, ElementTags.ANNOTATION);
            Matchers.checkForRuntimeRetention(annotation2.annotationType());
        }

        public boolean matches(AnnotatedElement annotatedElement) {
            Annotation annotation2 = annotatedElement.getAnnotation(this.annotation.annotationType());
            return annotation2 != null && this.annotation.equals(annotation2);
        }

        public boolean equals(Object obj) {
            return (obj instanceof AnnotatedWith) && ((AnnotatedWith) obj).annotation.equals(this.annotation);
        }

        public int hashCode() {
            return this.annotation.hashCode() * 37;
        }

        public String toString() {
            return "annotatedWith(" + this.annotation + ")";
        }
    }

    public static Matcher<Class> subclassesOf(Class<?> cls) {
        return new SubclassesOf(cls);
    }

    private static class SubclassesOf extends AbstractMatcher<Class> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> superclass;

        public SubclassesOf(Class<?> cls) {
            this.superclass = (Class) Preconditions.checkNotNull(cls, "superclass");
        }

        public boolean matches(Class cls) {
            return this.superclass.isAssignableFrom(cls);
        }

        public boolean equals(Object obj) {
            return (obj instanceof SubclassesOf) && ((SubclassesOf) obj).superclass.equals(this.superclass);
        }

        public int hashCode() {
            return this.superclass.hashCode() * 37;
        }

        public String toString() {
            return "subclassesOf(" + this.superclass.getSimpleName() + ".class)";
        }
    }

    public static Matcher<Object> only(Object obj) {
        return new Only(obj);
    }

    private static class Only extends AbstractMatcher<Object> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object value;

        public Only(Object obj) {
            this.value = Preconditions.checkNotNull(obj, "value");
        }

        public boolean matches(Object obj) {
            return this.value.equals(obj);
        }

        public boolean equals(Object obj) {
            return (obj instanceof Only) && ((Only) obj).value.equals(this.value);
        }

        public int hashCode() {
            return this.value.hashCode() * 37;
        }

        public String toString() {
            return "only(" + this.value + ")";
        }
    }

    public static Matcher<Object> identicalTo(Object obj) {
        return new IdenticalTo(obj);
    }

    private static class IdenticalTo extends AbstractMatcher<Object> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Object value;

        public IdenticalTo(Object obj) {
            this.value = Preconditions.checkNotNull(obj, "value");
        }

        public boolean matches(Object obj) {
            return this.value == obj;
        }

        public boolean equals(Object obj) {
            return (obj instanceof IdenticalTo) && ((IdenticalTo) obj).value == this.value;
        }

        public int hashCode() {
            return System.identityHashCode(this.value) * 37;
        }

        public String toString() {
            return "identicalTo(" + this.value + ")";
        }
    }

    public static Matcher<Class> inPackage(Package packageR) {
        return new InPackage(packageR);
    }

    private static class InPackage extends AbstractMatcher<Class> implements Serializable {
        private static final long serialVersionUID = 0;
        private final String packageName;
        private final transient Package targetPackage;

        public InPackage(Package packageR) {
            this.targetPackage = (Package) Preconditions.checkNotNull(packageR, "package");
            this.packageName = packageR.getName();
        }

        public boolean matches(Class cls) {
            return cls.getPackage().equals(this.targetPackage);
        }

        public boolean equals(Object obj) {
            return (obj instanceof InPackage) && ((InPackage) obj).targetPackage.equals(this.targetPackage);
        }

        public int hashCode() {
            return this.targetPackage.hashCode() * 37;
        }

        public String toString() {
            return "inPackage(" + this.targetPackage.getName() + ")";
        }

        public Object readResolve() {
            return Matchers.inPackage(Package.getPackage(this.packageName));
        }
    }

    public static Matcher<Class> inSubpackage(String str) {
        return new InSubpackage(str);
    }

    private static class InSubpackage extends AbstractMatcher<Class> implements Serializable {
        private static final long serialVersionUID = 0;
        private final String targetPackageName;

        public InSubpackage(String str) {
            this.targetPackageName = str;
        }

        public boolean matches(Class cls) {
            String name = cls.getPackage().getName();
            if (!name.equals(this.targetPackageName)) {
                StringBuilder sb = new StringBuilder();
                sb.append(this.targetPackageName);
                sb.append(".");
                return name.startsWith(sb.toString());
            }
        }

        public boolean equals(Object obj) {
            return (obj instanceof InSubpackage) && ((InSubpackage) obj).targetPackageName.equals(this.targetPackageName);
        }

        public int hashCode() {
            return this.targetPackageName.hashCode() * 37;
        }

        public String toString() {
            return "inSubpackage(" + this.targetPackageName + ")";
        }
    }

    public static Matcher<Method> returns(Matcher<? super Class<?>> matcher) {
        return new Returns(matcher);
    }

    private static class Returns extends AbstractMatcher<Method> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Matcher<? super Class<?>> returnType;

        public Returns(Matcher<? super Class<?>> matcher) {
            this.returnType = (Matcher) Preconditions.checkNotNull(matcher, "return type matcher");
        }

        public boolean matches(Method method) {
            return this.returnType.matches(method.getReturnType());
        }

        public boolean equals(Object obj) {
            return (obj instanceof Returns) && ((Returns) obj).returnType.equals(this.returnType);
        }

        public int hashCode() {
            return this.returnType.hashCode() * 37;
        }

        public String toString() {
            return "returns(" + this.returnType + ")";
        }
    }
}
