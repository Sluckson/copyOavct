package org.codehaus.jackson.node;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;

public final class NullNode extends ValueNode {
    public static final NullNode instance = new NullNode();

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
        return "null";
    }

    public boolean isNull() {
        return true;
    }

    private NullNode() {
    }

    public static NullNode getInstance() {
        return instance;
    }

    public JsonToken asToken() {
        return JsonToken.VALUE_NULL;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeNull();
    }
}
