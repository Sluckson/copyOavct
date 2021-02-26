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

public final class LongNode extends NumericNode {
    final long _value;

    public boolean isIntegralNumber() {
        return true;
    }

    public boolean isLong() {
        return true;
    }

    public LongNode(long j) {
        this._value = j;
    }

    public static LongNode valueOf(long j) {
        return new LongNode(j);
    }

    public JsonToken asToken() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public JsonParser.NumberType getNumberType() {
        return JsonParser.NumberType.LONG;
    }

    public Number getNumberValue() {
        return Long.valueOf(this._value);
    }

    public int getIntValue() {
        return (int) this._value;
    }

    public long getLongValue() {
        return this._value;
    }

    public double getDoubleValue() {
        return (double) this._value;
    }

    public BigDecimal getDecimalValue() {
        return BigDecimal.valueOf(this._value);
    }

    public BigInteger getBigIntegerValue() {
        return BigInteger.valueOf(this._value);
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
        if (obj != null && obj.getClass() == getClass() && ((LongNode) obj)._value == this._value) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this._value;
        return ((int) j) ^ ((int) (j >> 32));
    }
}
