package org.codehaus.jackson.node;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;

public final class BigIntegerNode extends NumericNode {
    protected final BigInteger _value;

    public boolean isBigInteger() {
        return true;
    }

    public boolean isIntegralNumber() {
        return true;
    }

    public BigIntegerNode(BigInteger bigInteger) {
        this._value = bigInteger;
    }

    public static BigIntegerNode valueOf(BigInteger bigInteger) {
        return new BigIntegerNode(bigInteger);
    }

    public JsonToken asToken() {
        return JsonToken.VALUE_NUMBER_INT;
    }

    public JsonParser.NumberType getNumberType() {
        return JsonParser.NumberType.BIG_INTEGER;
    }

    public Number getNumberValue() {
        return this._value;
    }

    public int getIntValue() {
        return this._value.intValue();
    }

    public long getLongValue() {
        return this._value.longValue();
    }

    public BigInteger getBigIntegerValue() {
        return this._value;
    }

    public double getDoubleValue() {
        return this._value.doubleValue();
    }

    public BigDecimal getDecimalValue() {
        return new BigDecimal(this._value);
    }

    public String getValueAsText() {
        return this._value.toString();
    }

    public boolean getValueAsBoolean(boolean z) {
        return !BigInteger.ZERO.equals(this._value);
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeNumber(this._value);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass() && ((BigIntegerNode) obj)._value == this._value) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this._value.hashCode();
    }
}
