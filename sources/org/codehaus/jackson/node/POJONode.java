package org.codehaus.jackson.node;

import java.io.IOException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;

public final class POJONode extends ValueNode {
    protected final Object _value;

    public boolean isPojo() {
        return true;
    }

    public POJONode(Object obj) {
        this._value = obj;
    }

    public JsonToken asToken() {
        return JsonToken.VALUE_EMBEDDED_OBJECT;
    }

    public String getValueAsText() {
        Object obj = this._value;
        return obj == null ? "null" : obj.toString();
    }

    public boolean getValueAsBoolean(boolean z) {
        Object obj = this._value;
        return (obj == null || !(obj instanceof Boolean)) ? z : ((Boolean) obj).booleanValue();
    }

    public int getValueAsInt(int i) {
        Object obj = this._value;
        return obj instanceof Number ? ((Number) obj).intValue() : i;
    }

    public long getValueAsLong(long j) {
        Object obj = this._value;
        return obj instanceof Number ? ((Number) obj).longValue() : j;
    }

    public double getValueAsDouble(double d) {
        Object obj = this._value;
        return obj instanceof Number ? ((Number) obj).doubleValue() : d;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        Object obj = this._value;
        if (obj == null) {
            jsonGenerator.writeNull();
        } else {
            jsonGenerator.writeObject(obj);
        }
    }

    public Object getPojo() {
        return this._value;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        POJONode pOJONode = (POJONode) obj;
        Object obj2 = this._value;
        if (obj2 != null) {
            return obj2.equals(pOJONode._value);
        }
        if (pOJONode._value == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this._value.hashCode();
    }

    public String toString() {
        return String.valueOf(this._value);
    }
}
