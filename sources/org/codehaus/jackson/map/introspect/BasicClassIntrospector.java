package org.codehaus.jackson.map.introspect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ClassIntrospector;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.util.ClassUtil;
import org.codehaus.jackson.type.JavaType;

public class BasicClassIntrospector extends ClassIntrospector<BasicBeanDescription> {
    public static final GetterMethodFilter DEFAULT_GETTER_FILTER = new GetterMethodFilter();
    public static final SetterAndGetterMethodFilter DEFAULT_SETTER_AND_GETTER_FILTER = new SetterAndGetterMethodFilter();
    public static final SetterMethodFilter DEFAULT_SETTER_FILTER = new SetterMethodFilter();
    public static final BasicClassIntrospector instance = new BasicClassIntrospector();

    public static class GetterMethodFilter implements MethodFilter {
        private GetterMethodFilter() {
        }

        public boolean includeMethod(Method method) {
            return ClassUtil.hasGetterSignature(method);
        }
    }

    public static class SetterMethodFilter implements MethodFilter {
        public boolean includeMethod(Method method) {
            if (Modifier.isStatic(method.getModifiers())) {
                return false;
            }
            int length = method.getParameterTypes().length;
            if (length == 1 || length == 2) {
                return true;
            }
            return false;
        }
    }

    public static final class SetterAndGetterMethodFilter extends SetterMethodFilter {
        public boolean includeMethod(Method method) {
            if (super.includeMethod(method)) {
                return true;
            }
            if (!ClassUtil.hasGetterSignature(method)) {
                return false;
            }
            Class<?> returnType = method.getReturnType();
            if (Collection.class.isAssignableFrom(returnType) || Map.class.isAssignableFrom(returnType)) {
                return true;
            }
            return false;
        }
    }

    public BasicBeanDescription forSerialization(SerializationConfig serializationConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        AnnotatedClass construct = AnnotatedClass.construct(javaType.getRawClass(), serializationConfig.getAnnotationIntrospector(), mixInResolver);
        construct.resolveMemberMethods(getSerializationMethodFilter(serializationConfig), false);
        construct.resolveCreators(true);
        construct.resolveFields(false);
        return new BasicBeanDescription(serializationConfig, javaType, construct);
    }

    public BasicBeanDescription forDeserialization(DeserializationConfig deserializationConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        boolean isAnnotationProcessingEnabled = deserializationConfig.isAnnotationProcessingEnabled();
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        Class<?> rawClass = javaType.getRawClass();
        if (!isAnnotationProcessingEnabled) {
            annotationIntrospector = null;
        }
        AnnotatedClass construct = AnnotatedClass.construct(rawClass, annotationIntrospector, mixInResolver);
        construct.resolveMemberMethods(getDeserializationMethodFilter(deserializationConfig), true);
        construct.resolveCreators(true);
        construct.resolveFields(true);
        return new BasicBeanDescription(deserializationConfig, javaType, construct);
    }

    public BasicBeanDescription forCreation(DeserializationConfig deserializationConfig, JavaType javaType, ClassIntrospector.MixInResolver mixInResolver) {
        boolean isAnnotationProcessingEnabled = deserializationConfig.isAnnotationProcessingEnabled();
        AnnotationIntrospector annotationIntrospector = deserializationConfig.getAnnotationIntrospector();
        Class<?> rawClass = javaType.getRawClass();
        if (!isAnnotationProcessingEnabled) {
            annotationIntrospector = null;
        }
        AnnotatedClass construct = AnnotatedClass.construct(rawClass, annotationIntrospector, mixInResolver);
        construct.resolveCreators(true);
        return new BasicBeanDescription(deserializationConfig, javaType, construct);
    }

    public BasicBeanDescription forClassAnnotations(MapperConfig<?> mapperConfig, Class<?> cls, ClassIntrospector.MixInResolver mixInResolver) {
        boolean isAnnotationProcessingEnabled = mapperConfig.isAnnotationProcessingEnabled();
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        if (!isAnnotationProcessingEnabled) {
            annotationIntrospector = null;
        }
        return new BasicBeanDescription(mapperConfig, mapperConfig.constructType(cls), AnnotatedClass.construct(cls, annotationIntrospector, mixInResolver));
    }

    public BasicBeanDescription forDirectClassAnnotations(MapperConfig<?> mapperConfig, Class<?> cls, ClassIntrospector.MixInResolver mixInResolver) {
        boolean isAnnotationProcessingEnabled = mapperConfig.isAnnotationProcessingEnabled();
        AnnotationIntrospector annotationIntrospector = mapperConfig.getAnnotationIntrospector();
        if (!isAnnotationProcessingEnabled) {
            annotationIntrospector = null;
        }
        return new BasicBeanDescription(mapperConfig, mapperConfig.constructType(cls), AnnotatedClass.constructWithoutSuperTypes(cls, annotationIntrospector, mixInResolver));
    }

    /* access modifiers changed from: protected */
    public MethodFilter getSerializationMethodFilter(SerializationConfig serializationConfig) {
        return DEFAULT_GETTER_FILTER;
    }

    /* access modifiers changed from: protected */
    public MethodFilter getDeserializationMethodFilter(DeserializationConfig deserializationConfig) {
        if (deserializationConfig.isEnabled(DeserializationConfig.Feature.USE_GETTERS_AS_SETTERS)) {
            return DEFAULT_SETTER_AND_GETTER_FILTER;
        }
        return DEFAULT_SETTER_FILTER;
    }
}
