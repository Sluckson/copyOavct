package org.codehaus.jackson.node;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.lowagie.text.pdf.PdfBoolean;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;

public final class BooleanNode extends ValueNode {
    public static final BooleanNode FALSE = new BooleanNode();
    public static final BooleanNode TRUE = new BooleanNode();

    public boolean equals(Object obj) {
        return obj == this;
    }

    public boolean isBoolean() {
        return true;
    }

    private BooleanNode() {
    }

    public static BooleanNode getTrue() {
        return TRUE;
    }

    public static BooleanNode getFalse() {
        return FALSE;
    }

    public static BooleanNode valueOf(boolean z) {
        return z ? TRUE : FALSE;
    }

    public JsonToken asToken() {
        return this == TRUE ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE;
    }

    public boolean getBooleanValue() {
        return this == TRUE;
    }

    public String getValueAsText() {
        return this == TRUE ? "true" : PdfBoolean.FALSE;
    }

    public boolean getValueAsBoolean() {
        return this == TRUE;
    }

    public boolean getValueAsBoolean(boolean z) {
        return this == TRUE;
    }

    public int getValueAsInt(int i) {
        return this == TRUE ? 1 : 0;
    }

    public long getValueAsLong(long j) {
        return this == TRUE ? 1 : 0;
    }

    public double getValueAsDouble(double d) {
        if (this == TRUE) {
            return 1.0d;
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeBoolean(this == TRUE);
    }
}
