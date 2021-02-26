package org.codehaus.jackson.map.jsontype.impl;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;

public class AsWrapperTypeSerializer extends TypeSerializerBase {
    public AsWrapperTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty) {
        super(typeIdResolver, beanProperty);
    }

    public JsonTypeInfo.C4903As getTypeInclusion() {
        return JsonTypeInfo.C4903As.WRAPPER_OBJECT;
    }

    public void writeTypePrefixForObject(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectFieldStart(this._idResolver.idFromValue(obj));
    }

    public void writeTypePrefixForObject(Object obj, JsonGenerator jsonGenerator, Class<?> cls) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectFieldStart(this._idResolver.idFromValueAndType(obj, cls));
    }

    public void writeTypePrefixForArray(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeArrayFieldStart(this._idResolver.idFromValue(obj));
    }

    public void writeTypePrefixForArray(Object obj, JsonGenerator jsonGenerator, Class<?> cls) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeArrayFieldStart(this._idResolver.idFromValueAndType(obj, cls));
    }

    public void writeTypePrefixForScalar(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName(this._idResolver.idFromValue(obj));
    }

    public void writeTypePrefixForScalar(Object obj, JsonGenerator jsonGenerator, Class<?> cls) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeFieldName(this._idResolver.idFromValueAndType(obj, cls));
    }

    public void writeTypeSuffixForObject(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeEndObject();
        jsonGenerator.writeEndObject();
    }

    public void writeTypeSuffixForArray(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }

    public void writeTypeSuffixForScalar(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeEndObject();
    }
}
