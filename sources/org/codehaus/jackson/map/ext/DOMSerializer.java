package org.codehaus.jackson.map.ext;

import java.io.IOException;
import java.lang.reflect.Type;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.SerializerBase;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;

public class DOMSerializer extends SerializerBase<Node> {
    protected final DOMImplementationLS _domImpl;

    public DOMSerializer() {
        super(Node.class);
        try {
            this._domImpl = (DOMImplementationLS) DOMImplementationRegistry.newInstance().getDOMImplementation("LS");
        } catch (Exception e) {
            throw new IllegalStateException("Could not instantiate DOMImplementationRegistry: " + e.getMessage(), e);
        }
    }

    public void serialize(Node node, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonGenerationException {
        DOMImplementationLS dOMImplementationLS = this._domImpl;
        if (dOMImplementationLS != null) {
            jsonGenerator.writeString(dOMImplementationLS.createLSSerializer().writeToString(node));
            return;
        }
        throw new IllegalStateException("Could not find DOM LS");
    }

    public JsonNode getSchema(SerializerProvider serializerProvider, Type type) {
        return createSchemaNode("string", true);
    }
}
