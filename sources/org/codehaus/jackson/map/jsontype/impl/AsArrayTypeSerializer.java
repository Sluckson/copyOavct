package org.codehaus.jackson.map.jsontype.impl;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;

public class AsArrayTypeSerializer extends TypeSerializerBase {
    public AsArrayTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        super(typeIdResolver, beanProperty);
    }

    public JsonTypeInfo.C4903As getTypeInclusion() {
        return JsonTypeInfo.C4903As.WRAPPER_ARRAY;
    }

    public void writeTypePrefixForObject(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartArray();
        jsonGenerator.writeString(this._idResolver.idFromValue(obj));
        jsonGenerator.writeStartObject();
    }

    public void writeTypePrefixForObject(Object obj, JsonGenerator jsonGenerator, Class<?> cls) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartArray();
        jsonGenerator.writeString(this._idResolver.idFromValueAndType(obj, cls));
        jsonGenerator.writeStartObject();
    }

    public void writeTypePrefixForArray(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartArray();
        jsonGenerator.writeString(this._idResolver.idFromValue(obj));
        jsonGenerator.writeStartArray();
    }

    public void writeTypePrefixForArray(Object obj, JsonGenerator jsonGenerator, Class<?> cls) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartArray();
        jsonGenerator.writeString(this._idResolver.idFromValueAndType(obj, cls));
        jsonGenerator.writeStartArray();
    }

    public void writeTypePrefixForScalar(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartArray();
        jsonGenerator.writeString(this._idResolver.idFromValue(obj));
    }

    public void writeTypePrefixForScalar(Object obj, JsonGenerator jsonGenerator, Class<?> cls) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartArray();
        jsonGenerator.writeString(this._idResolver.idFromValueAndType(obj, cls));
    }

    public void writeTypeSuffixForObject(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndArray();
    }

    public void writeTypeSuffixForArray(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndArray();
    }

    public void writeTypeSuffixForScalar(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeEndArray();
    }
}
