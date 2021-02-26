package org.codehaus.jackson.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.FormatSchema;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.p063io.SerializedString;

public class JsonGeneratorDelegate extends JsonGenerator {
    protected JsonGenerator delegate;

    public JsonGeneratorDelegate(JsonGenerator jsonGenerator) {
        this.delegate = jsonGenerator;
    }

    public void close() throws IOException {
        this.delegate.close();
    }

    public void copyCurrentEvent(JsonParser jsonParser) throws IOException, JsonProcessingException {
        this.delegate.copyCurrentEvent(jsonParser);
    }

    public void copyCurrentStructure(JsonParser jsonParser) throws IOException, JsonProcessingException {
        this.delegate.copyCurrentStructure(jsonParser);
    }

    public JsonGenerator disable(JsonGenerator.Feature feature) {
        return this.delegate.disable(feature);
    }

    public JsonGenerator enable(JsonGenerator.Feature feature) {
        return this.delegate.enable(feature);
    }

    public void flush() throws IOException {
        this.delegate.flush();
    }

    public ObjectCodec getCodec() {
        return this.delegate.getCodec();
    }

    public JsonStreamContext getOutputContext() {
        return this.delegate.getOutputContext();
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

    public Object getOutputTarget() {
        return this.delegate.getOutputTarget();
    }

    public boolean isClosed() {
        return this.delegate.isClosed();
    }

    public boolean isEnabled(JsonGenerator.Feature feature) {
        return this.delegate.isEnabled(feature);
    }

    public JsonGenerator setCodec(ObjectCodec objectCodec) {
        this.delegate.setCodec(objectCodec);
        return this;
    }

    public JsonGenerator useDefaultPrettyPrinter() {
        this.delegate.useDefaultPrettyPrinter();
        return this;
    }

    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        this.delegate.writeBinary(base64Variant, bArr, i, i2);
    }

    public void writeBoolean(boolean z) throws IOException, JsonGenerationException {
        this.delegate.writeBoolean(z);
    }

    public void writeEndArray() throws IOException, JsonGenerationException {
        this.delegate.writeEndArray();
    }

    public void writeEndObject() throws IOException, JsonGenerationException {
        this.delegate.writeEndObject();
    }

    public void writeFieldName(String str) throws IOException, JsonGenerationException {
        this.delegate.writeFieldName(str);
    }

    public void writeFieldName(SerializedString serializedString) throws IOException, JsonGenerationException {
        this.delegate.writeFieldName(serializedString);
    }

    public void writeFieldName(SerializableString serializableString) throws IOException, JsonGenerationException {
        this.delegate.writeFieldName(serializableString);
    }

    public void writeNull() throws IOException, JsonGenerationException {
        this.delegate.writeNull();
    }

    public void writeNumber(int i) throws IOException, JsonGenerationException {
        this.delegate.writeNumber(i);
    }

    public void writeNumber(long j) throws IOException, JsonGenerationException {
        this.delegate.writeNumber(j);
    }

    public void writeNumber(BigInteger bigInteger) throws IOException, JsonGenerationException {
        this.delegate.writeNumber(bigInteger);
    }

    public void writeNumber(double d) throws IOException, JsonGenerationException {
        this.delegate.writeNumber(d);
    }

    public void writeNumber(float f) throws IOException, JsonGenerationException {
        this.delegate.writeNumber(f);
    }

    public void writeNumber(BigDecimal bigDecimal) throws IOException, JsonGenerationException {
        this.delegate.writeNumber(bigDecimal);
    }

    public void writeNumber(String str) throws IOException, JsonGenerationException, UnsupportedOperationException {
        this.delegate.writeNumber(str);
    }

    public void writeObject(Object obj) throws IOException, JsonProcessingException {
        this.delegate.writeObject(obj);
    }

    public void writeRaw(String str) throws IOException, JsonGenerationException {
        this.delegate.writeRaw(str);
    }

    public void writeRaw(String str, int i, int i2) throws IOException, JsonGenerationException {
        this.delegate.writeRaw(str, i, i2);
    }

    public void writeRaw(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        this.delegate.writeRaw(cArr, i, i2);
    }

    public void writeRaw(char c) throws IOException, JsonGenerationException {
        this.delegate.writeRaw(c);
    }

    public void writeRawValue(String str) throws IOException, JsonGenerationException {
        this.delegate.writeRawValue(str);
    }

    public void writeRawValue(String str, int i, int i2) throws IOException, JsonGenerationException {
        this.delegate.writeRawValue(str, i, i2);
    }

    public void writeRawValue(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        this.delegate.writeRawValue(cArr, i, i2);
    }

    public void writeStartArray() throws IOException, JsonGenerationException {
        this.delegate.writeStartArray();
    }

    public void writeStartObject() throws IOException, JsonGenerationException {
        this.delegate.writeStartObject();
    }

    public void writeString(String str) throws IOException, JsonGenerationException {
        this.delegate.writeString(str);
    }

    public void writeString(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        this.delegate.writeString(cArr, i, i2);
    }

    public void writeString(SerializableString serializableString) throws IOException, JsonGenerationException {
        this.delegate.writeString(serializableString);
    }

    public void writeRawUTF8String(byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        this.delegate.writeRawUTF8String(bArr, i, i2);
    }

    public void writeUTF8String(byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        this.delegate.writeUTF8String(bArr, i, i2);
    }

    public void writeTree(JsonNode jsonNode) throws IOException, JsonProcessingException {
        this.delegate.writeTree(jsonNode);
    }
}
