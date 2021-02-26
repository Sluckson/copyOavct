package org.codehaus.jackson.node;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.p063io.NumberOutput;

public final class IntNode extends NumericNode {
    private static final IntNode[] CANONICALS = new IntNode[12];
    static final int MAX_CANONICAL = 10;
    static final int MIN_CANONICAL = -1;
    final int _value;

    public boolean isInt() {
        return true;
    }

    public boolean isIntegralNumber() {
        return true;
    }

    static {
        for (int i = 0; i < 12; i++) {
            CANONICALS[i] = new IntNode(i - 1);
        }
    }

    public IntNode(int i) {
        this._value = i;
    }

    public static IntNode valueOf(int i) {
        if (i > 10 || i < -1) {
            return new IntNode(i);
        }
        return CANONICALS[i - -1];
    }

    public JsonToken asToken() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public JsonParser.NumberType getNumberType() {
        return JsonParser.NumberType.INT;
    }

    public Number getNumberValue() {
        return Integer.valueOf(this._value);
    }

    public int getIntValue() {
        return this._value;
    }

    public long getLongValue() {
        return (long) this._value;
    }

    public double getDoubleValue() {
        return (double) this._value;
    }

    public BigDecimal getDecimalValue() {
        return BigDecimal.valueOf((long) this._value);
    }

    public BigInteger getBigIntegerValue() {
        return BigInteger.valueOf((long) this._value);
    }

    public String getValueAsText() {
        return NumberOutput.toString(this._value);
    }

    public boolean getValueAsBoolean(boolean z) {
        return this._value != 0;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeNumber(this._value);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass() && ((IntNode) obj)._value == this._value) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this._value;
    }
}
