package org.codehaus.jackson.map.util;

import org.codehaus.jackson.map.MapperConfig;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.type.ClassKey;
import org.codehaus.jackson.p063io.SerializedString;
import org.codehaus.jackson.type.JavaType;

public class RootNameLookup {
    protected LRUMap<ClassKey, SerializedString> _rootNames;

    public SerializedString findRootName(JavaType javaType, MapperConfig<?> mapperConfig) {
        return findRootName(javaType.getRawClass(), mapperConfig);
    }

    public synchronized SerializedString findRootName(Class<?> cls, MapperConfig<?> mapperConfig) {
        ClassKey classKey = new ClassKey(cls);
        if (this._rootNames == null) {
            this._rootNames = new LRUMap<>(20, 200);
        } else {
            SerializedString serializedString = (SerializedString) this._rootNames.get(classKey);
            if (serializedString != null) {
                return serializedString;
            }
        }
        String findRootName = mapperConfig.getAnnotationIntrospector().findRootName(((BasicBeanDescription) mapperConfig.introspectClassAnnotations(cls)).getClassInfo());
        if (findRootName == null) {
            findRootName = cls.getSimpleName();
        }
        SerializedString serializedString2 = new SerializedString(findRootName);
        this._rootNames.put(classKey, serializedString2);
        return serializedString2;
    }
}
