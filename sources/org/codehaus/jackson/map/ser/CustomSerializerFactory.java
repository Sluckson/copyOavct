package org.codehaus.jackson.map.ser;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerFactory;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.type.JavaType;

public class CustomSerializerFactory extends BeanSerializerFactory {
    protected HashMap<ClassKey, JsonSerializer<?>> _directClassMappings;
    protected JsonSerializer<?> _enumSerializerOverride;
    protected HashMap<ClassKey, JsonSerializer<?>> _interfaceMappings;
    protected HashMap<ClassKey, JsonSerializer<?>> _transitiveClassMappings;

    public CustomSerializerFactory() {
        this((SerializerFactory.Config) null);
    }

    public CustomSerializerFactory(SerializerFactory.Config config) {
        super(config);
        this._directClassMappings = null;
        this._transitiveClassMappings = null;
        this._interfaceMappings = null;
    }

    public SerializerFactory withConfig(SerializerFactory.Config config) {
        if (getClass() == CustomSerializerFactory.class) {
            return new CustomSerializerFactory(config);
        }
        throw new IllegalStateException("Subtype of CustomSerializerFactory (" + getClass().getName() + ") has not properly overridden method 'withAdditionalSerializers': can not instantiate subtype with " + "additional serializer definitions");
    }

    public <T> void addGenericMapping(Class<? extends T> cls, JsonSerializer<T> jsonSerializer) {
        ClassKey classKey = new ClassKey(cls);
        if (cls.isInterface()) {
            if (this._interfaceMappings == null) {
                this._interfaceMappings = new HashMap<>();
            }
            this._interfaceMappings.put(classKey, jsonSerializer);
            return;
        }
        if (this._transitiveClassMappings == null) {
            this._transitiveClassMappings = new HashMap<>();
        }
        this._transitiveClassMappings.put(classKey, jsonSerializer);
    }

    public <T> void addSpecificMapping(Class<? extends T> cls, JsonSerializer<T> jsonSerializer) {
        ClassKey classKey = new ClassKey(cls);
        if (cls.isInterface()) {
            throw new IllegalArgumentException("Can not add specific mapping for an interface (" + cls.getName() + ")");
        } else if (!Modifier.isAbstract(cls.getModifiers())) {
            if (this._directClassMappings == null) {
                this._directClassMappings = new HashMap<>();
            }
            this._directClassMappings.put(classKey, jsonSerializer);
        } else {
            throw new IllegalArgumentException("Can not add specific mapping for an abstract class (" + cls.getName() + ")");
        }
    }

    public void setEnumSerializer(JsonSerializer<?> jsonSerializer) {
        this._enumSerializerOverride = jsonSerializer;
    }

    public JsonSerializer<Object> createSerializer(SerializationConfig serializationConfig, JavaType javaType, BeanProperty beanProperty) throws JsonMappingException {
        JsonSerializer<?> findCustomSerializer = findCustomSerializer(javaType.getRawClass(), serializationConfig);
        if (findCustomSerializer != null) {
            return findCustomSerializer;
        }
        return super.createSerializer(serializationConfig, javaType, beanProperty);
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> findCustomSerializer(Class<?> cls, SerializationConfig serializationConfig) {
        JsonSerializer<?> jsonSerializer;
        JsonSerializer<?> jsonSerializer2;
        ClassKey classKey = new ClassKey(cls);
        HashMap<ClassKey, JsonSerializer<?>> hashMap = this._directClassMappings;
        if (hashMap != null && (jsonSerializer2 = hashMap.get(classKey)) != null) {
            return jsonSerializer2;
        }
        if (cls.isEnum() && (jsonSerializer = this._enumSerializerOverride) != null) {
            return jsonSerializer;
        }
        if (this._transitiveClassMappings != null) {
            for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                classKey.reset(cls2);
                JsonSerializer<?> jsonSerializer3 = this._transitiveClassMappings.get(classKey);
                if (jsonSerializer3 != null) {
                    return jsonSerializer3;
                }
            }
        }
        if (this._interfaceMappings == null) {
            return null;
        }
        classKey.reset(cls);
        JsonSerializer<?> jsonSerializer4 = this._interfaceMappings.get(classKey);
        if (jsonSerializer4 != null) {
            return jsonSerializer4;
        }
        for (Class<? super Object> cls3 = cls; cls3 != null; cls3 = cls3.getSuperclass()) {
            JsonSerializer<?> _findInterfaceMapping = _findInterfaceMapping(cls3, classKey);
            if (_findInterfaceMapping != null) {
                return _findInterfaceMapping;
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonSerializer<?> _findInterfaceMapping(Class<?> cls, ClassKey classKey) {
        for (Class cls2 : cls.getInterfaces()) {
            classKey.reset(cls2);
            JsonSerializer<?> jsonSerializer = this._interfaceMappings.get(classKey);
            if (jsonSerializer != null) {
                return jsonSerializer;
            }
            JsonSerializer<?> _findInterfaceMapping = _findInterfaceMapping(cls2, classKey);
            if (_findInterfaceMapping != null) {
                return _findInterfaceMapping;
            }
        }
        return null;
    }
}
