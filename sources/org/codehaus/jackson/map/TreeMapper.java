package org.codehaus.jackson.map;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.node.NullNode;

@Deprecated
public class TreeMapper extends JsonNodeFactory {
    protected ObjectMapper _objectMapper;

    public TreeMapper() {
        this((ObjectMapper) null);
    }

    public TreeMapper(ObjectMapper objectMapper) {
        this._objectMapper = objectMapper;
    }

    public JsonFactory getJsonFactory() {
        return objectMapper().getJsonFactory();
    }

    public JsonNode readTree(JsonParser jsonParser) throws IOException, JsonParseException {
        if (jsonParser.getCurrentToken() == null && jsonParser.nextToken() == null) {
            return null;
        }
        return objectMapper().readTree(jsonParser);
    }

    public JsonNode readTree(File file) throws IOException, JsonParseException {
        JsonNode jsonNode = (JsonNode) objectMapper().readValue(file, JsonNode.class);
        return jsonNode == null ? NullNode.instance : jsonNode;
    }

    public JsonNode readTree(URL url) throws IOException, JsonParseException {
        JsonNode jsonNode = (JsonNode) objectMapper().readValue(url, JsonNode.class);
        return jsonNode == null ? NullNode.instance : jsonNode;
    }

    public JsonNode readTree(InputStream inputStream) throws IOException, JsonParseException {
        JsonNode jsonNode = (JsonNode) objectMapper().readValue(inputStream, JsonNode.class);
        return jsonNode == null ? NullNode.instance : jsonNode;
    }

    public JsonNode readTree(Reader reader) throws IOException, JsonParseException {
        JsonNode jsonNode = (JsonNode) objectMapper().readValue(reader, JsonNode.class);
        return jsonNode == null ? NullNode.instance : jsonNode;
    }

    public JsonNode readTree(String str) throws IOException, JsonParseException {
        JsonNode jsonNode = (JsonNode) objectMapper().readValue(str, JsonNode.class);
        return jsonNode == null ? NullNode.instance : jsonNode;
    }

    public JsonNode readTree(byte[] bArr) throws IOException, JsonParseException {
        JsonNode jsonNode = (JsonNode) objectMapper().readValue(bArr, 0, bArr.length, JsonNode.class);
        return jsonNode == null ? NullNode.instance : jsonNode;
    }

    public void writeTree(JsonNode jsonNode, File file) throws IOException, JsonParseException {
        objectMapper().writeValue(file, (Object) jsonNode);
    }

    public void writeTree(JsonNode jsonNode, Writer writer) throws IOException, JsonParseException {
        objectMapper().writeValue(writer, (Object) jsonNode);
    }

    public void writeTree(JsonNode jsonNode, OutputStream outputStream) throws IOException, JsonParseException {
        objectMapper().writeValue(outputStream, (Object) jsonNode);
    }

    /* access modifiers changed from: protected */
    public synchronized ObjectMapper objectMapper() {
        if (this._objectMapper == null) {
            this._objectMapper = new ObjectMapper();
        }
        return this._objectMapper;
    }
}
