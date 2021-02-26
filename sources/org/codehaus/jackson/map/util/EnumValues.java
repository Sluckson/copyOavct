package org.codehaus.jackson.map.util;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.p063io.SerializedString;

public final class EnumValues {
    private final EnumMap<?, SerializedString> _values;

    private EnumValues(Map<Enum<?>, SerializedString> map) {
        this._values = new EnumMap<>(map);
    }

    public static EnumValues construct(Class<Enum<?>> cls, AnnotationIntrospector annotationIntrospector) {
        return constructFromName(cls, annotationIntrospector);
    }

    public static EnumValues constructFromName(Class<Enum<?>> cls, AnnotationIntrospector annotationIntrospector) {
        Enum[] enumArr = (Enum[]) ClassUtil.findEnumType((Class<?>) cls).getEnumConstants();
        if (enumArr != null) {
            HashMap hashMap = new HashMap();
            for (Enum enumR : enumArr) {
                hashMap.put(enumR, new SerializedString(annotationIntrospector.findEnumValue(enumR)));
            }
            return new EnumValues(hashMap);
        }
        throw new IllegalArgumentException("Can not determine enum constants for Class " + cls.getName());
    }

    public static EnumValues constructFromToString(Class<Enum<?>> cls, AnnotationIntrospector annotationIntrospector) {
        Enum[] enumArr = (Enum[]) ClassUtil.findEnumType((Class<?>) cls).getEnumConstants();
        if (enumArr != null) {
            HashMap hashMap = new HashMap();
            for (Enum enumR : enumArr) {
                hashMap.put(enumR, new SerializedString(enumR.toString()));
            }
            return new EnumValues(hashMap);
        }
        throw new IllegalArgumentException("Can not determine enum constants for Class " + cls.getName());
    }

    @Deprecated
    public String valueFor(Enum<?> enumR) {
        SerializedString serializedString = this._values.get(enumR);
        if (serializedString == null) {
            return null;
        }
        return serializedString.getValue();
    }

    public SerializedString serializedValueFor(Enum<?> enumR) {
        return this._values.get(enumR);
    }

    public Collection<SerializedString> values() {
        return this._values.values();
    }
}
