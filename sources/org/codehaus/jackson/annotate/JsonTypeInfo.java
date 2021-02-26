package org.codehaus.jackson.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@JacksonAnnotation
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonTypeInfo {

    /* renamed from: org.codehaus.jackson.annotate.JsonTypeInfo$As */
    public enum C4903As {
        PROPERTY,
        WRAPPER_OBJECT,
        WRAPPER_ARRAY
    }

    C4903As include() default C4903As.PROPERTY;

    String property() default "";

    C4904Id use();

    /* renamed from: org.codehaus.jackson.annotate.JsonTypeInfo$Id */
    public enum C4904Id {
        NONE((String) null),
        CLASS("@class"),
        MINIMAL_CLASS("@c"),
        NAME("@type"),
        CUSTOM((String) null);
        
        private final String _defaultPropertyName;

        private C4904Id(String str) {
            this._defaultPropertyName = str;
        }

        public String getDefaultPropertyName() {
            return this._defaultPropertyName;
        }
    }
}
