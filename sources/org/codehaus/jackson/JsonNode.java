package org.codehaus.jackson;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.JsonParser;

public abstract class JsonNode implements Iterable<JsonNode> {
    protected static final List<JsonNode> NO_NODES = Collections.emptyList();
    protected static final List<String> NO_STRINGS = Collections.emptyList();

    public abstract JsonToken asToken();

    public abstract boolean equals(Object obj);

    public abstract JsonNode findParent(String str);

    public abstract List<JsonNode> findParents(String str, List<JsonNode> list);

    public abstract JsonNode findPath(String str);

    public abstract JsonNode findValue(String str);

    public abstract List<JsonNode> findValues(String str, List<JsonNode> list);

    public abstract List<String> findValuesAsText(String str, List<String> list);

    public JsonNode get(int i) {
        return null;
    }

    public JsonNode get(String str) {
        return null;
    }

    public byte[] getBinaryValue() throws IOException {
        return null;
    }

    public boolean getBooleanValue() {
        return false;
    }

    public double getDoubleValue() {
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    public int getIntValue() {
        return 0;
    }

    public long getLongValue() {
        return 0;
    }

    public abstract JsonParser.NumberType getNumberType();

    public Number getNumberValue() {
        return null;
    }

    public String getTextValue() {
        return null;
    }

    public boolean getValueAsBoolean(boolean z) {
        return z;
    }

    public double getValueAsDouble(double d) {
        return d;
    }

    public int getValueAsInt(int i) {
        return i;
    }

    public long getValueAsLong(long j) {
        return j;
    }

    public abstract String getValueAsText();

    public boolean isArray() {
        return false;
    }

    public boolean isBigDecimal() {
        return false;
    }

    public boolean isBigInteger() {
        return false;
    }

    public boolean isBinary() {
        return false;
    }

    public boolean isBoolean() {
        return false;
    }

    public boolean isContainerNode() {
        return false;
    }

    public boolean isDouble() {
        return false;
    }

    public boolean isFloatingPointNumber() {
        return false;
    }

    public boolean isInt() {
        return false;
    }

    public boolean isIntegralNumber() {
        return false;
    }

    public boolean isLong() {
        return false;
    }

    public boolean isMissingNode() {
        return false;
    }

    public boolean isNull() {
        return false;
    }

    public boolean isNumber() {
        return false;
    }

    public boolean isObject() {
        return false;
    }

    public boolean isPojo() {
        return false;
    }

    public boolean isTextual() {
        return false;
    }

    public boolean isValueNode() {
        return false;
    }

    public abstract JsonNode path(int i);

    public abstract JsonNode path(String str);

    public int size() {
        return 0;
    }

    public abstract String toString();

    public abstract JsonParser traverse();

    @Deprecated
    public abstract void writeTo(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException;

    protected JsonNode() {
    }

    public BigDecimal getDecimalValue() {
        return BigDecimal.ZERO;
    }

    public BigInteger getBigIntegerValue() {
        return BigInteger.ZERO;
    }

    public int getValueAsInt() {
        return getValueAsInt(0);
    }

    public long getValueAsLong() {
        return getValueAsLong(0);
    }

    public double getValueAsDouble() {
        return getValueAsDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
    }

    public boolean getValueAsBoolean() {
        return getValueAsBoolean(false);
    }

    public boolean has(String str) {
        return get(str) != null;
    }

    public boolean has(int i) {
        return get(i) != null;
    }

    public final List<JsonNode> findValues(String str) {
        List<JsonNode> findValues = findValues(str, (List<JsonNode>) null);
        return findValues == null ? Collections.emptyList() : findValues;
    }

    public final List<String> findValuesAsText(String str) {
        List<String> findValuesAsText = findValuesAsText(str, (List<String>) null);
        return findValuesAsText == null ? Collections.emptyList() : findValuesAsText;
    }

    public final List<JsonNode> findParents(String str) {
        List<JsonNode> findParents = findParents(str, (List<JsonNode>) null);
        return findParents == null ? Collections.emptyList() : findParents;
    }

    @Deprecated
    public final JsonNode getFieldValue(String str) {
        return get(str);
    }

    @Deprecated
    public final JsonNode getElementValue(int i) {
        return get(i);
    }

    public final Iterator<JsonNode> iterator() {
        return getElements();
    }

    public Iterator<JsonNode> getElements() {
        return NO_NODES.iterator();
    }

    public Iterator<String> getFieldNames() {
        return NO_STRINGS.iterator();
    }

    public Iterator<Map.Entry<String, JsonNode>> getFields() {
        return Collections.emptyList().iterator();
    }

    @Deprecated
    public final JsonNode getPath(String str) {
        return path(str);
    }

    @Deprecated
    public final JsonNode getPath(int i) {
        return path(i);
    }

    public JsonNode with(String str) {
        throw new UnsupportedOperationException("JsonNode not of type ObjectNode (but " + getClass().getName() + "), can not call with() on it");
    }
}
