package org.codehaus.jackson.map.jsontype.impl;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonTypeInfo;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.jsontype.TypeIdResolver;

public class AsPropertyTypeSerializer extends AsArrayTypeSerializer {
    protected final String _typePropertyName;

    public AsPropertyTypeSerializer(TypeIdResolver typeIdResolver, BeanProperty beanProperty, String str) {
        super(typeIdResolver, beanProperty);
        this._typePropertyName = str;
    }

    public String getPropertyName() {
        return this._typePropertyName;
    }

    public JsonTypeInfo.C4903As getTypeInclusion() {
        return JsonTypeInfo.C4903As.PROPERTY;
    }

    public void writeTypePrefixForObject(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField(this._typePropertyName, this._idResolver.idFromValue(obj));
    }

    public void writeTypePrefixForObject(Object obj, JsonGenerator jsonGenerator, Class<?> cls) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField(this._typePropertyName, this._idResolver.idFromValueAndType(obj, cls));
    }

    public void writeTypeSuffixForObject(Object obj, JsonGenerator jsonGenerator) throws IOException, JsonProcessingException {
        jsonGenerator.writeEndObject();
    }
}
