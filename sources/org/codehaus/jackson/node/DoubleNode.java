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

public final class DoubleNode extends NumericNode {
    protected final double _value;

    public boolean isDouble() {
        return true;
    }

    public boolean isFloatingPointNumber() {
        return true;
    }

    public DoubleNode(double d) {
        this._value = d;
    }

    public static DoubleNode valueOf(double d) {
        return new DoubleNode(d);
    }

    public JsonToken asToken() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public JsonParser.NumberType getNumberType() {
        return JsonParser.NumberType.DOUBLE;
    }

    public Number getNumberValue() {
        return Double.valueOf(this._value);
    }

    public int getIntValue() {
        return (int) this._value;
    }

    public long getLongValue() {
        return (long) this._value;
    }

    public double getDoubleValue() {
        return this._value;
    }

    public BigDecimal getDecimalValue() {
        return BigDecimal.valueOf(this._value);
    }

    public BigInteger getBigIntegerValue() {
        return getDecimalValue().toBigInteger();
    }

    public String getValueAsText() {
        return NumberOutput.toString(this._value);
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeNumber(this._value);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass() && ((DoubleNode) obj)._value == this._value) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this._value);
        return ((int) doubleToLongBits) ^ ((int) (doubleToLongBits >> 32));
    }
}
