package org.codehaus.jackson.map.ser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.map.introspect.AnnotatedMember;
import org.codehaus.jackson.map.ser.impl.PropertySerializerMap;
import org.codehaus.jackson.map.util.Annotations;
import org.codehaus.jackson.p063io.SerializedString;
import org.codehaus.jackson.type.JavaType;

public class BeanPropertyWriter implements BeanProperty {
    protected final Method _accessorMethod;
    protected final JavaType _cfgSerializationType;
    protected final Annotations _contextAnnotations;
    protected final JavaType _declaredType;
    protected PropertySerializerMap _dynamicSerializers;
    protected final Field _field;
    protected Class<?>[] _includeInViews;
    protected HashMap<Object, Object> _internalSettings;
    protected final AnnotatedMember _member;
    protected final SerializedString _name;
    protected JavaType _nonTrivialBaseType;
    protected final JsonSerializer<Object> _serializer;
    protected final boolean _suppressNulls;
    protected final Object _suppressableValue;
    protected TypeSerializer _typeSerializer;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public BeanPropertyWriter(AnnotatedMember annotatedMember, Annotations annotations, String str, JavaType javaType, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JavaType javaType2, Method method, Field field, boolean z, Object obj) {
        this(annotatedMember, annotations, new SerializedString(str), javaType, jsonSerializer, typeSerializer, javaType2, method, field, z, obj);
        String str2 = str;
    }

    public BeanPropertyWriter(AnnotatedMember annotatedMember, Annotations annotations, SerializedString serializedString, JavaType javaType, JsonSerializer<Object> jsonSerializer, TypeSerializer typeSerializer, JavaType javaType2, Method method, Field field, boolean z, Object obj) {
        this._member = annotatedMember;
        this._contextAnnotations = annotations;
        this._name = serializedString;
        this._declaredType = javaType;
        this._serializer = jsonSerializer;
        this._dynamicSerializers = jsonSerializer == null ? PropertySerializerMap.emptyMap() : null;
        this._typeSerializer = typeSerializer;
        this._cfgSerializationType = javaType2;
        this._accessorMethod = method;
        this._field = field;
        this._suppressNulls = z;
        this._suppressableValue = obj;
    }

    protected BeanPropertyWriter(BeanPropertyWriter beanPropertyWriter) {
        this(beanPropertyWriter, beanPropertyWriter._serializer);
    }

    protected BeanPropertyWriter(BeanPropertyWriter beanPropertyWriter, JsonSerializer<Object> jsonSerializer) {
        this._serializer = jsonSerializer;
        this._member = beanPropertyWriter._member;
        this._contextAnnotations = beanPropertyWriter._contextAnnotations;
        this._declaredType = beanPropertyWriter._declaredType;
        this._accessorMethod = beanPropertyWriter._accessorMethod;
        this._field = beanPropertyWriter._field;
        HashMap<Object, Object> hashMap = beanPropertyWriter._internalSettings;
        if (hashMap != null) {
            this._internalSettings = new HashMap<>(hashMap);
        }
        this._name = beanPropertyWriter._name;
        this._cfgSerializationType = beanPropertyWriter._cfgSerializationType;
        this._dynamicSerializers = beanPropertyWriter._dynamicSerializers;
        this._suppressNulls = beanPropertyWriter._suppressNulls;
        this._suppressableValue = beanPropertyWriter._suppressableValue;
        this._includeInViews = beanPropertyWriter._includeInViews;
        this._typeSerializer = beanPropertyWriter._typeSerializer;
        this._nonTrivialBaseType = beanPropertyWriter._nonTrivialBaseType;
    }

    public BeanPropertyWriter withSerializer(JsonSerializer<Object> jsonSerializer) {
        if (getClass() == BeanPropertyWriter.class) {
            return new BeanPropertyWriter(this, jsonSerializer);
        }
        throw new IllegalStateException("BeanPropertyWriter sub-class does not override 'withSerializer()'; needs to!");
    }

    public void setViews(Class<?>[] clsArr) {
        this._includeInViews = clsArr;
    }

    public void setNonTrivialBaseType(JavaType javaType) {
        this._nonTrivialBaseType = javaType;
    }

    public String getName() {
        return this._name.getValue();
    }

    public JavaType getType() {
        return this._declaredType;
    }

    public <A extends Annotation> A getAnnotation(Class<A> cls) {
        return this._member.getAnnotation(cls);
    }

    public <A extends Annotation> A getContextAnnotation(Class<A> cls) {
        return this._contextAnnotations.get(cls);
    }

    public AnnotatedMember getMember() {
        return this._member;
    }

    public Object getInternalSetting(Object obj) {
        HashMap<Object, Object> hashMap = this._internalSettings;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(obj);
    }

    public Object setInternalSetting(Object obj, Object obj2) {
        if (this._internalSettings == null) {
            this._internalSettings = new HashMap<>();
        }
        return this._internalSettings.put(obj, obj2);
    }

    public Object removeInternalSetting(Object obj) {
        HashMap<Object, Object> hashMap = this._internalSettings;
        if (hashMap == null) {
            return null;
        }
        Object remove = hashMap.remove(obj);
        if (this._internalSettings.size() != 0) {
            return remove;
        }
        this._internalSettings = null;
        return remove;
    }

    public SerializedString getSerializedName() {
        return this._name;
    }

    public boolean hasSerializer() {
        return this._serializer != null;
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<Object> getSerializer() {
        return this._serializer;
    }

    public JavaType getSerializationType() {
        return this._cfgSerializationType;
    }

    public Class<?> getRawSerializationType() {
        JavaType javaType = this._cfgSerializationType;
        if (javaType == null) {
            return null;
        }
        return javaType.getRawClass();
    }

    public Class<?> getPropertyType() {
        Method method = this._accessorMethod;
        if (method != null) {
            return method.getReturnType();
        }
        return this._field.getType();
    }

    public Type getGenericPropertyType() {
        Method method = this._accessorMethod;
        if (method != null) {
            return method.getGenericReturnType();
        }
        return this._field.getGenericType();
    }

    public Class<?>[] getViews() {
        return this._includeInViews;
    }

    public void serializeAsField(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws Exception {
        Object obj2 = get(obj);
        if (obj2 != null) {
            if (obj2 == obj) {
                _reportSelfReference(obj);
            }
            Object obj3 = this._suppressableValue;
            if (obj3 == null || !obj3.equals(obj2)) {
                JsonSerializer<Object> jsonSerializer = this._serializer;
                if (jsonSerializer == null) {
                    Class<?> cls = obj2.getClass();
                    PropertySerializerMap propertySerializerMap = this._dynamicSerializers;
                    JsonSerializer<Object> serializerFor = propertySerializerMap.serializerFor(cls);
                    jsonSerializer = serializerFor == null ? _findAndAddDynamic(propertySerializerMap, cls, serializerProvider) : serializerFor;
                }
                jsonGenerator.writeFieldName(this._name);
                TypeSerializer typeSerializer = this._typeSerializer;
                if (typeSerializer == null) {
                    jsonSerializer.serialize(obj2, jsonGenerator, serializerProvider);
                } else {
                    jsonSerializer.serializeWithType(obj2, jsonGenerator, serializerProvider, typeSerializer);
                }
            }
        } else if (!this._suppressNulls) {
            jsonGenerator.writeFieldName(this._name);
            serializerProvider.defaultSerializeNull(jsonGenerator);
        }
    }

    /* access modifiers changed from: protected */
    public final JsonSerializer<Object> _findAndAddDynamic(PropertySerializerMap propertySerializerMap, Class<?> cls, SerializerProvider serializerProvider) throws JsonMappingException {
        PropertySerializerMap.SerializerAndMapResult serializerAndMapResult;
        JavaType javaType = this._nonTrivialBaseType;
        if (javaType != null) {
            serializerAndMapResult = propertySerializerMap.findAndAddSerializer(javaType.forcedNarrowBy(cls), serializerProvider, (BeanProperty) this);
        } else {
            serializerAndMapResult = propertySerializerMap.findAndAddSerializer(cls, serializerProvider, (BeanProperty) this);
        }
        if (propertySerializerMap != serializerAndMapResult.map) {
            this._dynamicSerializers = serializerAndMapResult.map;
        }
        return serializerAndMapResult.serializer;
    }

    public final Object get(Object obj) throws Exception {
        Method method = this._accessorMethod;
        if (method != null) {
            return method.invoke(obj, new Object[0]);
        }
        return this._field.get(obj);
    }

    /* access modifiers changed from: protected */
    public void _reportSelfReference(Object obj) throws JsonMappingException {
        throw new JsonMappingException("Direct self-reference leading to cycle");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(40);
        sb.append("property '");
        sb.append(getName());
        sb.append("' (");
        if (this._accessorMethod != null) {
            sb.append("via method ");
            sb.append(this._accessorMethod.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this._accessorMethod.getName());
        } else {
            sb.append("field \"");
            sb.append(this._field.getDeclaringClass().getName());
            sb.append("#");
            sb.append(this._field.getName());
        }
        if (this._serializer == null) {
            sb.append(", no static serializer");
        } else {
            sb.append(", static serializer of type " + this._serializer.getClass().getName());
        }
        sb.append(')');
        return sb.toString();
    }
}
