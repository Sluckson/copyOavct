package org.codehaus.jackson.node;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;

public final class DecimalNode extends NumericNode {
    protected final BigDecimal _value;

    public boolean isBigDecimal() {
        return true;
    }

    public boolean isFloatingPointNumber() {
        return true;
    }

    public DecimalNode(BigDecimal bigDecimal) {
        this._value = bigDecimal;
    }

    public static DecimalNode valueOf(BigDecimal bigDecimal) {
        return new DecimalNode(bigDecimal);
    }

    public JsonToken asToken() {
        return JsonToken.VALUE_NUMBER_FLOAT;
    }

    public JsonParser.NumberType getNumberType() {
        return JsonParser.NumberType.BIG_DECIMAL;
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
        return this._value.toBigInteger();
    }

    public double getDoubleValue() {
        return this._value.doubleValue();
    }

    public BigDecimal getDecimalValue() {
        return this._value;
    }

    public String getValueAsText() {
        return this._value.toString();
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeNumber(this._value);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            return ((DecimalNode) obj)._value.equals(this._value);
        }
        return false;
    }

    public int hashCode() {
        return this._value.hashCode();
    }
}
