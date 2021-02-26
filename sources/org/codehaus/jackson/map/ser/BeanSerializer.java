package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.BeanProperty;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ResolvableSerializer;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.schema.JsonSchema;
import org.codehaus.jackson.schema.SchemaAware;
import org.codehaus.jackson.type.JavaType;

public class BeanSerializer extends SerializerBase<Object> implements ResolvableSerializer, SchemaAware {
    protected static final BeanPropertyWriter[] NO_PROPS = new BeanPropertyWriter[0];
    protected final AnyGetterWriter _anyGetterWriter;
    protected final BeanPropertyWriter[] _filteredProps;
    protected final Object _propertyFilterId;
    protected final BeanPropertyWriter[] _props;

    public BeanSerializer(JavaType javaType, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2, AnyGetterWriter anyGetterWriter, Object obj) {
        super(javaType);
        this._props = beanPropertyWriterArr;
        this._filteredProps = beanPropertyWriterArr2;
        this._anyGetterWriter = anyGetterWriter;
        this._propertyFilterId = obj;
    }

    public BeanSerializer(Class<?> cls, BeanPropertyWriter[] beanPropertyWriterArr, BeanPropertyWriter[] beanPropertyWriterArr2, AnyGetterWriter anyGetterWriter, Object obj) {
        super(cls);
        this._props = beanPropertyWriterArr;
        this._filteredProps = beanPropertyWriterArr2;
        this._anyGetterWriter = anyGetterWriter;
        this._propertyFilterId = obj;
    }

    protected BeanSerializer(BeanSerializer beanSerializer) {
        this((Class<?>) beanSerializer._handledType, beanSerializer._props, beanSerializer._filteredProps, beanSerializer._anyGetterWriter, beanSerializer._propertyFilterId);
    }

    public static BeanSerializer createDummy(Class<?> cls) {
        return new BeanSerializer(cls, NO_PROPS, (BeanPropertyWriter[]) null, (AnyGetterWriter) null, (Object) null);
    }

    public final void serialize(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        jsonGenerator.writeStartObject();
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, serializerProvider);
        } else {
            serializeFields(obj, jsonGenerator, serializerProvider);
        }
        jsonGenerator.writeEndObject();
    }

    public void serializeWithType(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonGenerationException {
        typeSerializer.writeTypePrefixForObject(obj, jsonGenerator);
        if (this._propertyFilterId != null) {
            serializeFieldsFiltered(obj, jsonGenerator, serializerProvider);
        } else {
            serializeFields(obj, jsonGenerator, serializerProvider);
        }
        typeSerializer.writeTypeSuffixForObject(obj, jsonGenerator);
    }

    /* access modifiers changed from: protected */
    public void serializeFields(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        BeanPropertyWriter[] beanPropertyWriterArr;
        String str = "[anySetter]";
        if (this._filteredProps == null || serializerProvider.getSerializationView() == null) {
            beanPropertyWriterArr = this._props;
        } else {
            beanPropertyWriterArr = this._filteredProps;
        }
        try {
            for (BeanPropertyWriter beanPropertyWriter : beanPropertyWriterArr) {
                if (beanPropertyWriter != null) {
                    beanPropertyWriter.serializeAsField(obj, jsonGenerator, serializerProvider);
                }
            }
            if (this._anyGetterWriter != null) {
                this._anyGetterWriter.getAndSerialize(obj, jsonGenerator, serializerProvider);
            }
        } catch (Exception e) {
            if (0 != beanPropertyWriterArr.length) {
                str = beanPropertyWriterArr[0].getName();
            }
            wrapAndThrow(serializerProvider, (Throwable) e, obj, str);
        } catch (StackOverflowError unused) {
            JsonMappingException jsonMappingException = new JsonMappingException("Infinite recursion (StackOverflowError)");
            if (0 != beanPropertyWriterArr.length) {
                str = beanPropertyWriterArr[0].getName();
            }
            jsonMappingException.prependPath(new JsonMappingException.Reference(obj, str));
            throw jsonMappingException;
        }
    }

    /* access modifiers changed from: protected */
    public void serializeFieldsFiltered(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        BeanPropertyWriter[] beanPropertyWriterArr;
        String str = "[anySetter]";
        if (this._filteredProps == null || serializerProvider.getSerializationView() == null) {
            beanPropertyWriterArr = this._props;
        } else {
            beanPropertyWriterArr = this._filteredProps;
        }
        BeanPropertyFilter findFilter = findFilter(serializerProvider);
        try {
            for (BeanPropertyWriter beanPropertyWriter : beanPropertyWriterArr) {
                if (beanPropertyWriter != null) {
                    findFilter.serializeAsField(obj, jsonGenerator, serializerProvider, beanPropertyWriter);
                }
            }
            if (this._anyGetterWriter != null) {
                this._anyGetterWriter.getAndSerialize(obj, jsonGenerator, serializerProvider);
            }
        } catch (Exception e) {
            if (0 != beanPropertyWriterArr.length) {
                str = beanPropertyWriterArr[0].getName();
            }
            wrapAndThrow(serializerProvider, (Throwable) e, obj, str);
        } catch (StackOverflowError unused) {
            JsonMappingException jsonMappingException = new JsonMappingException("Infinite recursion (StackOverflowError)");
            if (0 != beanPropertyWriterArr.length) {
                str = beanPropertyWriterArr[0].getName();
            }
            jsonMappingException.prependPath(new JsonMappingException.Reference(obj, str));
            throw jsonMappingException;
        }
    }

    /* access modifiers changed from: protected */
    public BeanPropertyFilter findFilter(SerializerProvider serializerProvider) throws JsonMappingException {
        Object obj = this._propertyFilterId;
        FilterProvider filterProvider = serializerProvider.getFilterProvider();
        if (filterProvider != null) {
            BeanPropertyFilter findFilter = filterProvider.findFilter(obj);
            if (findFilter != null) {
                return findFilter;
            }
            throw new JsonMappingException("No filter configured with id '" + obj + "' (type " + obj.getClass().getName() + ")");
        }
        throw new JsonMappingException("Can not resolve BeanPropertyFilter with id '" + obj + "'; no FilterProvider configured");
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) throws JsonMappingException {
        ObjectNode createSchemaNode = createSchemaNode("object", true);
        ObjectNode objectNode = createSchemaNode.objectNode();
        int i = 0;
        while (true) {
            BeanPropertyWriter[] beanPropertyWriterArr = this._props;
            if (i < beanPropertyWriterArr.length) {
                BeanPropertyWriter beanPropertyWriter = beanPropertyWriterArr[i];
                JavaType serializationType = beanPropertyWriter.getSerializationType();
                Type genericPropertyType = serializationType == null ? beanPropertyWriter.getGenericPropertyType() : serializationType.getRawClass();
                JsonSerializer<Object> serializer = beanPropertyWriter.getSerializer();
                if (serializer == null) {
                    Class<?> rawSerializationType = beanPropertyWriter.getRawSerializationType();
                    if (rawSerializationType == null) {
                        rawSerializationType = beanPropertyWriter.getPropertyType();
                    }
                    serializer = serializerProvider.findValueSerializer(rawSerializationType, (BeanProperty) beanPropertyWriter);
                }
                objectNode.put(beanPropertyWriter.getName(), serializer instanceof SchemaAware ? ((SchemaAware) serializer).getSchema(serializerProvider, genericPropertyType) : JsonSchema.getDefaultSchemaNode());
                i++;
            } else {
                createSchemaNode.put("properties", (JsonNode) objectNode);
                return createSchemaNode;
            }
        }
    }

    public void resolve(SerializerProvider serializerProvider) throws JsonMappingException {
        BeanPropertyWriter[] beanPropertyWriterArr;
        BeanPropertyWriter beanPropertyWriter;
        TypeSerializer typeSerializer;
        BeanPropertyWriter[] beanPropertyWriterArr2 = this._filteredProps;
        int length = beanPropertyWriterArr2 == null ? 0 : beanPropertyWriterArr2.length;
        int length2 = this._props.length;
        for (int i = 0; i < length2; i++) {
            BeanPropertyWriter beanPropertyWriter2 = this._props[i];
            if (!beanPropertyWriter2.hasSerializer()) {
                JavaType serializationType = beanPropertyWriter2.getSerializationType();
                if (serializationType == null) {
                    serializationType = serializerProvider.constructType(beanPropertyWriter2.getGenericPropertyType());
                    if (!serializationType.isFinal()) {
                        if (serializationType.isContainerType() || serializationType.containedTypeCount() > 0) {
                            beanPropertyWriter2.setNonTrivialBaseType(serializationType);
                        }
                    }
                }
                JsonSerializer findValueSerializer = serializerProvider.findValueSerializer(serializationType, (BeanProperty) beanPropertyWriter2);
                if (serializationType.isContainerType() && (typeSerializer = (TypeSerializer) serializationType.getContentType().getTypeHandler()) != null && (findValueSerializer instanceof ContainerSerializerBase)) {
                    findValueSerializer = ((ContainerSerializerBase) findValueSerializer).withValueTypeSerializer(typeSerializer);
                }
                this._props[i] = beanPropertyWriter2.withSerializer(findValueSerializer);
                if (i < length && (beanPropertyWriter = beanPropertyWriterArr[i]) != null) {
                    (beanPropertyWriterArr = this._filteredProps)[i] = beanPropertyWriter.withSerializer(findValueSerializer);
                }
            }
        }
        AnyGetterWriter anyGetterWriter = this._anyGetterWriter;
        if (anyGetterWriter != null) {
            anyGetterWriter.resolve(serializerProvider);
        }
    }

    public String toString() {
        return "BeanSerializer for " + handledType().getName();
    }
}
