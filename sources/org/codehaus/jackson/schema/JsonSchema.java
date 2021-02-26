package org.codehaus.jackson.schema;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.ObjectNode;

public class JsonSchema {
    private final ObjectNode schema;

    @JsonCreator
    public JsonSchema(ObjectNode objectNode) {
        this.schema = objectNode;
    }

    @JsonValue
    public ObjectNode getSchemaNode() {
        return this.schema;
    }

    public String toString() {
        return this.schema.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof JsonSchema)) {
            return false;
        }
        JsonSchema jsonSchema = (JsonSchema) obj;
        ObjectNode objectNode = this.schema;
        if (objectNode != null) {
            return objectNode.equals(jsonSchema.schema);
        }
        if (jsonSchema.schema == null) {
            return true;
        }
        return false;
    }

    public static JsonNode getDefaultSchemaNode() {
        ObjectNode objectNode = JsonNodeFactory.instance.objectNode();
        objectNode.put("type", "any");
        return objectNode;
    }
}
