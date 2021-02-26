package org.codehaus.jackson.map;

import java.lang.annotation.Annotation;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.type.JavaType;

public interface BeanProperty {
    <A extends Annotation> A getAnnotation(Class<A> cls);

    <A extends Annotation> A getContextAnnotation(Class<A> cls);

    AnnotatedMember getMember();

    String getName();

    JavaType getType();

    public static class Std implements BeanProperty {
        protected final Annotations _contextAnnotations;
        protected final AnnotatedMember _member;
        protected final String _name;
        protected final JavaType _type;

        public Std(String str, JavaType javaType, Annotations annotations, AnnotatedMember annotatedMember) {
            this._name = str;
            this._type = javaType;
            this._member = annotatedMember;
            this._contextAnnotations = annotations;
        }

        public Std withType(JavaType javaType) {
            return new Std(this._name, javaType, this._contextAnnotations, this._member);
        }

        public <A extends Annotation> A getAnnotation(Class<A> cls) {
            return this._member.getAnnotation(cls);
        }

        public <A extends Annotation> A getContextAnnotation(Class<A> cls) {
            Annotations annotations = this._contextAnnotations;
            if (annotations == null) {
                return null;
            }
            return annotations.get(cls);
        }

        public String getName() {
            return this._name;
        }

        public JavaType getType() {
            return this._type;
        }

        public AnnotatedMember getMember() {
            return this._member;
        }
    }
}
