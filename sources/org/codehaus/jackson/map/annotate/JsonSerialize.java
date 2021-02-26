package org.codehaus.jackson.map.annotate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.codehaus.jackson.annotate.JacksonAnnotation;
import org.codehaus.jackson.map.JsonSerializer;

@JacksonAnnotation
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JsonSerialize {

    public enum Inclusion {
        ALWAYS,
        NON_NULL,
        NON_DEFAULT
    }

    public enum Typing {
        DYNAMIC,
        STATIC
    }

    /* renamed from: as */
    Class<?> mo71188as() default NoClass.class;

    Class<?> contentAs() default NoClass.class;

    Class<? extends JsonSerializer<?>> contentUsing() default JsonSerializer.None.class;

    Inclusion include() default Inclusion.ALWAYS;

    Class<?> keyAs() default NoClass.class;

    Class<? extends JsonSerializer<?>> keyUsing() default JsonSerializer.None.class;

    Typing typing() default Typing.DYNAMIC;

    Class<? extends JsonSerializer<?>> using() default JsonSerializer.None.class;
}
