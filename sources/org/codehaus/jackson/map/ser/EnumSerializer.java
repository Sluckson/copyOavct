package org.codehaus.jackson.map.ser;

import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.annotate.JacksonStdImpl;
import org.codehaus.jackson.map.introspect.BasicBeanDescription;
import org.codehaus.jackson.map.util.EnumValues;
import org.codehaus.jackson.node.ArrayNode;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.p063io.SerializedString;

@JacksonStdImpl
public class EnumSerializer extends ScalarSerializerBase<Enum<?>> {
    protected final EnumValues _values;

    public EnumSerializer(EnumValues enumValues) {
        super(Enum.class, false);
        this._values = enumValues;
    }

    public static EnumSerializer construct(Class<Enum<?>> cls, SerializationConfig serializationConfig, BasicBeanDescription basicBeanDescription) {
        AnnotationIntrospector annotationIntrospector = serializationConfig.getAnnotationIntrospector();
        return new EnumSerializer(serializationConfig.isEnabled(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING) ? EnumValues.constructFromToString(cls, annotationIntrospector) : EnumValues.constructFromName(cls, annotationIntrospector));
    }

    public final void serialize(Enum<?> enumR, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        jsonGenerator.writeString((SerializableString) this._values.serializedValueFor(enumR));
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        ObjectNode createSchemaNode = createSchemaNode("string", true);
        if (type != null && serializerProvider.constructType(type).isEnumType()) {
            ArrayNode putArray = createSchemaNode.putArray("enum");
            for (SerializedString value : this._values.values()) {
                putArray.add(value.getValue());
            }
        }
        return createSchemaNode;
    }

    public EnumValues getEnumValues() {
        return this._values;
    }
}
