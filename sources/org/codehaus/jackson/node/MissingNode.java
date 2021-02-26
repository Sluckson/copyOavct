package org.codehaus.jackson.node;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;

public final class MissingNode extends BaseJsonNode {
    private static final MissingNode instance = new MissingNode();

    public boolean equals(Object obj) {
        return obj == this;
    }

    public double getValueAsDouble(double d) {
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public int getValueAsInt(int i) {
        return 0;
    }

    public long getValueAsLong(long j) {
        return 0;
    }

    public String getValueAsText() {
        return null;
    }

    public boolean isMissingNode() {
        return true;
    }

    public JsonNode path(int i) {
        return this;
    }

    public JsonNode path(String str) {
        return this;
    }

    public String toString() {
        return "";
    }

    private MissingNode() {
    }

    public static MissingNode getInstance() {
        return instance;
    }

    public JsonToken asToken() {
        return JsonToken.NOT_AVAILABLE;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeNull();
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonProcessingException {
        jsonGenerator.writeNull();
    }
}
