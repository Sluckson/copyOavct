package org.codehaus.jackson.map.ser;

import org.codehaus.jackson.map.TypeSerializer;

public abstract class ContainerSerializerBase<T> extends SerializerBase<T> {
    public abstract ContainerSerializerBase<?> _withValueTypeSerializer(TypeSerializer typeSerializer);

    protected ContainerSerializerBase(Class<T> cls) {
        super(cls);
    }

    protected ContainerSerializerBase(Class<?> cls, boolean z) {
        super(cls, z);
    }

    public ContainerSerializerBase<?> withValueTypeSerializer(TypeSerializer typeSerializer) {
        return typeSerializer == null ? this : _withValueTypeSerializer(typeSerializer);
    }
}
