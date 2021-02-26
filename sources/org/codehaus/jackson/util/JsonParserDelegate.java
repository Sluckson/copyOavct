package org.codehaus.jackson.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.FormatSchema;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.Version;

public class JsonParserDelegate extends JsonParser {
    protected JsonParser delegate;

    public JsonParserDelegate(JsonParser jsonParser) {
        this.delegate = jsonParser;
    }

    public void setCodec(ObjectCodec objectCodec) {
        this.delegate.setCodec(objectCodec);
    }

    public ObjectCodec getCodec() {
        return this.delegate.getCodec();
    }

    public JsonParser enable(JsonParser.Feature feature) {
        this.delegate.enable(feature);
        return this;
    }

    public JsonParser disable(JsonParser.Feature feature) {
        this.delegate.disable(feature);
        return this;
    }

    public boolean isEnabled(JsonParser.Feature feature) {
        return this.delegate.isEnabled(feature);
    }

    public void setSchema(FormatSchema formatSchema) {
        this.delegate.setSchema(formatSchema);
    }

    public boolean canUseSchema(FormatSchema formatSchema) {
        return this.delegate.canUseSchema(formatSchema);
    }

    public Version version() {
        return this.delegate.version();
    }

    public Object getInputSource() {
        return this.delegate.getInputSource();
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public boolean isClosed() {
        return this.delegate.isClosed();
    }

    public JsonToken getCurrentToken() {
        return this.delegate.getCurrentToken();
    }

    public boolean hasCurrentToken() {
        return this.delegate.hasCurrentToken();
    }

    public void clearCurrentToken() {
        this.delegate.clearCurrentToken();
    }

    public String getCurrentName() throws IOException, JsonParseException {
        return this.delegate.getCurrentName();
    }

    public JsonLocation getCurrentLocation() {
        return this.delegate.getCurrentLocation();
    }

    public JsonToken getLastClearedToken() {
        return this.delegate.getLastClearedToken();
    }

    public JsonStreamContext getParsingContext() {
        return this.delegate.getParsingContext();
    }

    public String getText() throws IOException, JsonParseException {
        return this.delegate.getText();
    }

    public char[] getTextCharacters() throws IOException, JsonParseException {
        return this.delegate.getTextCharacters();
    }

    public int getTextLength() throws IOException, JsonParseException {
        return this.delegate.getTextLength();
    }

    public int getTextOffset() throws IOException, JsonParseException {
        return this.delegate.getTextOffset();
    }

    public BigInteger getBigIntegerValue() throws IOException, JsonParseException {
        return this.delegate.getBigIntegerValue();
    }

    public byte getByteValue() throws IOException, JsonParseException {
        return this.delegate.getByteValue();
    }

    public short getShortValue() throws IOException, JsonParseException {
        return this.delegate.getShortValue();
    }

    public BigDecimal getDecimalValue() throws IOException, JsonParseException {
        return this.delegate.getDecimalValue();
    }

    public double getDoubleValue() throws IOException, JsonParseException {
        return this.delegate.getDoubleValue();
    }

    public float getFloatValue() throws IOException, JsonParseException {
        return this.delegate.getFloatValue();
    }

    public int getIntValue() throws IOException, JsonParseException {
        return this.delegate.getIntValue();
    }

    public long getLongValue() throws IOException, JsonParseException {
        return this.delegate.getLongValue();
    }

    public JsonParser.NumberType getNumberType() throws IOException, JsonParseException {
        return this.delegate.getNumberType();
    }

    public Number getNumberValue() throws IOException, JsonParseException {
        return this.delegate.getNumberValue();
    }

    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException, JsonParseException {
        return this.delegate.getBinaryValue(base64Variant);
    }

    public JsonLocation getTokenLocation() {
        return this.delegate.getTokenLocation();
    }

    public JsonToken nextToken() throws IOException, JsonParseException {
        return this.delegate.nextToken();
    }

    public JsonParser skipChildren() throws IOException, JsonParseException {
        this.delegate.skipChildren();
        return this;
    }
}
