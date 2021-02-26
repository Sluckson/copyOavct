package org.codehaus.jackson.map.ser;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.introspect.Annotated;
import org.codehaus.jackson.map.introspect.AnnotatedField;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.introspect.AnnotatedMethod;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.type.JavaType;

public class PropertyBuilder {
    protected final AnnotationIntrospector _annotationIntrospector = this._config.getAnnotationIntrospector();
    protected final BasicBeanDescription _beanDesc;
    protected final SerializationConfig _config;
    protected Object _defaultBean;
    protected final JsonSerialize.Inclusion _outputProps;

    public PropertyBuilder(SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription) {
        this._config = serializationConfig;
        this._beanDesc = basicBeanDescription;
        this._outputProps = basicBeanDescription.findSerializationInclusion(serializationConfig.getSerializationInclusion());
    }

    public Annotations getClassAnnotations() {
        return this._beanDesc.getClassAnnotations();
    }

    /* access modifiers changed from: protected */
    public BeanPropertyWriter buildWriter(String str, JavaType javaType, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, TypeSerializer typeSerializer2, AnnotatedMember annotatedMember, boolean z) {
        Field field;
        Method method;
        JavaType javaType2;
        JavaType javaType3;
        Object obj;
        boolean z2;
        Object obj2;
        String str2 = str;
        TypeSerializer typeSerializer3 = typeSerializer2;
        AnnotatedMember annotatedMember2 = annotatedMember;
        if (annotatedMember2 instanceof AnnotatedField) {
            javaType2 = javaType;
            field = ((AnnotatedField) annotatedMember2).getAnnotated();
            method = null;
        } else {
            javaType2 = javaType;
            method = ((AnnotatedMethod) annotatedMember2).getAnnotated();
            field = null;
        }
        JavaType findSerializationType = findSerializationType(annotatedMember2, z, javaType2);
        if (typeSerializer3 != null) {
            if (findSerializationType == null) {
                findSerializationType = javaType2;
            }
            if (findSerializationType.getContentType() != null) {
                JavaType withContentTypeHandler = findSerializationType.withContentTypeHandler(typeSerializer3);
                withContentTypeHandler.getContentType();
                javaType3 = withContentTypeHandler;
            } else {
                throw new IllegalStateException("Problem trying to create BeanPropertyWriter for property '" + str + "' (of type " + this._beanDesc.getType() + "); serialization type " + findSerializationType + " has no content");
            }
        } else {
            javaType3 = findSerializationType;
        }
        JsonSerialize.Inclusion findSerializationInclusion = this._annotationIntrospector.findSerializationInclusion(annotatedMember2, this._outputProps);
        if (findSerializationInclusion != null) {
            int i = C49211.f5827x1c046cf1[findSerializationInclusion.ordinal()];
            if (i == 1) {
                Object defaultValue = getDefaultValue(str, method, field);
                if (defaultValue == null) {
                    obj = defaultValue;
                } else {
                    obj2 = defaultValue;
                    z2 = false;
                    return new BeanPropertyWriter(annotatedMember, this._beanDesc.getClassAnnotations(), str, javaType, jsonSerializer, typeSerializer, javaType3, method, field, z2, obj);
                }
            } else if (i == 2) {
                obj = null;
            }
            z2 = true;
            return new BeanPropertyWriter(annotatedMember, this._beanDesc.getClassAnnotations(), str, javaType, jsonSerializer, typeSerializer, javaType3, method, field, z2, obj);
        }
        obj2 = null;
        z2 = false;
        return new BeanPropertyWriter(annotatedMember, this._beanDesc.getClassAnnotations(), str, javaType, jsonSerializer, typeSerializer, javaType3, method, field, z2, obj);
    }

    /* renamed from: org.codehaus.jackson.map.ser.PropertyBuilder$1 */
    static /* synthetic */ class C49211 {

        /* renamed from: $SwitchMap$org$codehaus$jackson$map$annotate$JsonSerialize$Inclusion */
        static final /* synthetic */ int[] f5827x1c046cf1 = new int[JsonSerialize.Inclusion.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                org.codehaus.jackson.map.annotate.JsonSerialize$Inclusion[] r0 = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5827x1c046cf1 = r0
                int[] r0 = f5827x1c046cf1     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.codehaus.jackson.map.annotate.JsonSerialize$Inclusion r1 = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f5827x1c046cf1     // Catch:{ NoSuchFieldError -> 0x001f }
                org.codehaus.jackson.map.annotate.JsonSerialize$Inclusion r1 = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.map.ser.PropertyBuilder.C49211.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public JavaType findSerializationType(Annotated annotated, boolean z, JavaType javaType) {
        JsonSerialize.Typing findSerializationTyping;
        JavaType forcedNarrowBy;
        Class<?> findSerializationType = this._annotationIntrospector.findSerializationType(annotated);
        if (findSerializationType != null) {
            Class<?> rawClass = javaType.getRawClass();
            if (findSerializationType.isAssignableFrom(rawClass)) {
                forcedNarrowBy = javaType.widenBy(findSerializationType);
            } else if (rawClass.isAssignableFrom(findSerializationType)) {
                forcedNarrowBy = javaType.forcedNarrowBy(findSerializationType);
            } else {
                throw new IllegalArgumentException("Illegal concrete-type annotation for method '" + annotated.getName() + "': class " + findSerializationType.getName() + " not a super-type of (declared) class " + rawClass.getName());
            }
            javaType = forcedNarrowBy;
            z = true;
        }
        JavaType modifySecondaryTypesByAnnotation = BeanSerializerFactory.modifySecondaryTypesByAnnotation(this._config, annotated, javaType);
        if (modifySecondaryTypesByAnnotation != javaType) {
            javaType = modifySecondaryTypesByAnnotation;
            z = true;
        }
        if (!z && (findSerializationTyping = this._annotationIntrospector.findSerializationTyping(annotated)) != null) {
            z = findSerializationTyping == JsonSerialize.Typing.STATIC;
        }
        if (z) {
            return javaType;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Object getDefaultBean() {
        if (this._defaultBean == null) {
            this._defaultBean = this._beanDesc.instantiateBean(this._config.isEnabled(SerializationConfig.Feature.CAN_OVERRIDE_ACCESS_MODIFIERS));
            if (this._defaultBean == null) {
                Class<?> annotated = this._beanDesc.getClassInfo().getAnnotated();
                throw new IllegalArgumentException("Class " + annotated.getName() + " has no default constructor; can not instantiate default bean value to support 'properties=JsonSerialize.Inclusion.NON_DEFAULT' annotation");
            }
        }
        return this._defaultBean;
    }

    /* access modifiers changed from: protected */
    public Object getDefaultValue(String str, Method method, Field field) {
        Object defaultBean = getDefaultBean();
        if (method == null) {
            return field.get(defaultBean);
        }
        try {
            return method.invoke(defaultBean, new Object[0]);
        } catch (Exception e) {
            return _throwWrapped(e, str, defaultBean);
        }
    }

    /* access modifiers changed from: protected */
    public Object _throwWrapped(Exception exc, String str, Object obj) {
        Throwable th;
        while (true) {
            Throwable cause = th.getCause();
            th = exc;
            if (cause == null) {
                break;
            }
            th = th.getCause();
        }
        if (th instanceof Error) {
            throw ((Error) th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw new IllegalArgumentException("Failed to get property '" + str + "' of default " + obj.getClass().getName() + " instance");
        }
    }
}
