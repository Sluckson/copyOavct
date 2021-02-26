package org.codehaus.jackson.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.util.DefaultPrettyPrinter;
import org.codehaus.jackson.util.VersionUtil;

public abstract class JsonGeneratorBase extends JsonGenerator {
    protected boolean _cfgNumbersAsStrings;
    protected boolean _closed;
    protected int _features;
    protected ObjectCodec _objectCodec;
    protected JsonWriteContext _writeContext = JsonWriteContext.createRootContext();

    /* access modifiers changed from: protected */
    public abstract void _releaseBuffers();

    /* access modifiers changed from: protected */
    public abstract void _verifyValueWrite(String str) throws IOException, JsonGenerationException;

    /* access modifiers changed from: protected */
    @Deprecated
    public void _writeEndArray() throws IOException, JsonGenerationException {
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void _writeEndObject() throws IOException, JsonGenerationException {
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void _writeStartArray() throws IOException, JsonGenerationException {
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void _writeStartObject() throws IOException, JsonGenerationException {
    }

    public abstract void flush() throws IOException;

    protected JsonGeneratorBase(int i, ObjectCodec objectCodec) {
        this._features = i;
        this._objectCodec = objectCodec;
        this._cfgNumbersAsStrings = isEnabled(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS);
    }

    public Version version() {
        return VersionUtil.versionFor(getClass());
    }

    public JsonGenerator enable(JsonGenerator.Feature feature) {
        this._features |= feature.getMask();
        if (feature == JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS) {
            this._cfgNumbersAsStrings = true;
        } else if (feature == JsonGenerator.Feature.ESCAPE_NON_ASCII) {
            setHighestNonEscapedChar(127);
        }
        return this;
    }

    public JsonGenerator disable(JsonGenerator.Feature feature) {
        this._features &= ~feature.getMask();
        if (feature == JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS) {
            this._cfgNumbersAsStrings = false;
        } else if (feature == JsonGenerator.Feature.ESCAPE_NON_ASCII) {
            setHighestNonEscapedChar(0);
        }
        return this;
    }

    public final boolean isEnabled(JsonGenerator.Feature feature) {
        return (feature.getMask() & this._features) != 0;
    }

    public JsonGenerator useDefaultPrettyPrinter() {
        return setPrettyPrinter(new DefaultPrettyPrinter());
    }

    public JsonGenerator setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
        return this;
    }

    public final ObjectCodec getCodec() {
        return this._objectCodec;
    }

    public final JsonWriteContext getOutputContext() {
        return this._writeContext;
    }

    public void writeStartArray() throws IOException, JsonGenerationException {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartArray(this);
        } else {
            _writeStartArray();
        }
    }

    public void writeEndArray() throws IOException, JsonGenerationException {
        if (!this._writeContext.inArray()) {
            _reportError("Current context not an ARRAY but " + this._writeContext.getTypeDesc());
        }
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeEndArray(this, this._writeContext.getEntryCount());
        } else {
            _writeEndArray();
        }
        this._writeContext = this._writeContext.getParent();
    }

    public void writeStartObject() throws IOException, JsonGenerationException {
        _verifyValueWrite("start an object");
        this._writeContext = this._writeContext.createChildObjectContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartObject(this);
        } else {
            _writeStartObject();
        }
    }

    public void writeEndObject() throws IOException, JsonGenerationException {
        if (!this._writeContext.inObject()) {
            _reportError("Current context not an object but " + this._writeContext.getTypeDesc());
        }
        this._writeContext = this._writeContext.getParent();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeEndObject(this, this._writeContext.getEntryCount());
        } else {
            _writeEndObject();
        }
    }

    public void writeRawValue(String str) throws IOException, JsonGenerationException {
        _verifyValueWrite("write raw value");
        writeRaw(str);
    }

    public void writeRawValue(String str, int i, int i2) throws IOException, JsonGenerationException {
        _verifyValueWrite("write raw value");
        writeRaw(str, i, i2);
    }

    public void writeRawValue(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        _verifyValueWrite("write raw value");
        writeRaw(cArr, i, i2);
    }

    public void writeObject(Object obj) throws IOException, JsonProcessingException {
        if (obj == null) {
            writeNull();
            return;
        }
        ObjectCodec objectCodec = this._objectCodec;
        if (objectCodec != null) {
            objectCodec.writeValue(this, obj);
        } else {
            _writeSimpleObject(obj);
        }
    }

    public void writeTree(JsonNode jsonNode) throws IOException, JsonProcessingException {
        if (jsonNode == null) {
            writeNull();
            return;
        }
        ObjectCodec objectCodec = this._objectCodec;
        if (objectCodec != null) {
            objectCodec.writeTree(this, jsonNode);
            return;
        }
        throw new IllegalStateException("No ObjectCodec defined for the generator, can not serialize JsonNode-based trees");
    }

    public void close() throws IOException {
        this._closed = true;
    }

    public boolean isClosed() {
        return this._closed;
    }

    public final void copyCurrentEvent(JsonParser jsonParser) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == null) {
            _reportError("No current event to copy");
        }
        switch (currentToken) {
            case START_OBJECT:
                writeStartObject();
                return;
            case END_OBJECT:
                writeEndObject();
                return;
            case START_ARRAY:
                writeStartArray();
                return;
            case END_ARRAY:
                writeEndArray();
                return;
            case FIELD_NAME:
                writeFieldName(jsonParser.getCurrentName());
                return;
            case VALUE_STRING:
                if (jsonParser.hasTextCharacters()) {
                    writeString(jsonParser.getTextCharacters(), jsonParser.getTextOffset(), jsonParser.getTextLength());
                    return;
                } else {
                    writeString(jsonParser.getText());
                    return;
                }
            case VALUE_NUMBER_INT:
                int i = C49061.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[jsonParser.getNumberType().ordinal()];
                if (i == 1) {
                    writeNumber(jsonParser.getIntValue());
                    return;
                } else if (i != 2) {
                    writeNumber(jsonParser.getLongValue());
                    return;
                } else {
                    writeNumber(jsonParser.getBigIntegerValue());
                    return;
                }
            case VALUE_NUMBER_FLOAT:
                int i2 = C49061.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[jsonParser.getNumberType().ordinal()];
                if (i2 == 3) {
                    writeNumber(jsonParser.getDecimalValue());
                    return;
                } else if (i2 != 4) {
                    writeNumber(jsonParser.getDoubleValue());
                    return;
                } else {
                    writeNumber(jsonParser.getFloatValue());
                    return;
                }
            case VALUE_TRUE:
                writeBoolean(true);
                return;
            case VALUE_FALSE:
                writeBoolean(false);
                return;
            case VALUE_NULL:
                writeNull();
                return;
            case VALUE_EMBEDDED_OBJECT:
                writeObject(jsonParser.getEmbeddedObject());
                return;
            default:
                _cantHappen();
                return;
        }
    }

    /* renamed from: org.codehaus.jackson.impl.JsonGeneratorBase$1 */
    static /* synthetic */ class C49061 {
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$JsonParser$NumberType = new int[JsonParser.NumberType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(33:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|(3:39|40|42)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|(2:1|2)|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|33|34|35|36|37|38|39|40|42) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00a5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00af */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00b9 */
        static {
            /*
                org.codehaus.jackson.JsonToken[] r0 = org.codehaus.jackson.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$codehaus$jackson$JsonToken = r0
                r0 = 1
                int[] r1 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.codehaus.jackson.JsonToken r2 = org.codehaus.jackson.JsonToken.START_OBJECT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x001f }
                org.codehaus.jackson.JsonToken r3 = org.codehaus.jackson.JsonToken.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x002a }
                org.codehaus.jackson.JsonToken r4 = org.codehaus.jackson.JsonToken.START_ARRAY     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0035 }
                org.codehaus.jackson.JsonToken r5 = org.codehaus.jackson.JsonToken.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r4 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0040 }
                org.codehaus.jackson.JsonToken r5 = org.codehaus.jackson.JsonToken.FIELD_NAME     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r6 = 5
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r4 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x004b }
                org.codehaus.jackson.JsonToken r5 = org.codehaus.jackson.JsonToken.VALUE_STRING     // Catch:{ NoSuchFieldError -> 0x004b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r6 = 6
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r4 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0056 }
                org.codehaus.jackson.JsonToken r5 = org.codehaus.jackson.JsonToken.VALUE_NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r6 = 7
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r4 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0062 }
                org.codehaus.jackson.JsonToken r5 = org.codehaus.jackson.JsonToken.VALUE_NUMBER_FLOAT     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r6 = 8
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r4 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x006e }
                org.codehaus.jackson.JsonToken r5 = org.codehaus.jackson.JsonToken.VALUE_TRUE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r6 = 9
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r4 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x007a }
                org.codehaus.jackson.JsonToken r5 = org.codehaus.jackson.JsonToken.VALUE_FALSE     // Catch:{ NoSuchFieldError -> 0x007a }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r6 = 10
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r4 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0086 }
                org.codehaus.jackson.JsonToken r5 = org.codehaus.jackson.JsonToken.VALUE_NULL     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r6 = 11
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r4 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0092 }
                org.codehaus.jackson.JsonToken r5 = org.codehaus.jackson.JsonToken.VALUE_EMBEDDED_OBJECT     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r6 = 12
                r4[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                org.codehaus.jackson.JsonParser$NumberType[] r4 = org.codehaus.jackson.JsonParser.NumberType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                $SwitchMap$org$codehaus$jackson$JsonParser$NumberType = r4
                int[] r4 = $SwitchMap$org$codehaus$jackson$JsonParser$NumberType     // Catch:{ NoSuchFieldError -> 0x00a5 }
                org.codehaus.jackson.JsonParser$NumberType r5 = org.codehaus.jackson.JsonParser.NumberType.INT     // Catch:{ NoSuchFieldError -> 0x00a5 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a5 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x00a5 }
            L_0x00a5:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonParser$NumberType     // Catch:{ NoSuchFieldError -> 0x00af }
                org.codehaus.jackson.JsonParser$NumberType r4 = org.codehaus.jackson.JsonParser.NumberType.BIG_INTEGER     // Catch:{ NoSuchFieldError -> 0x00af }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00af }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00af }
            L_0x00af:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonParser$NumberType     // Catch:{ NoSuchFieldError -> 0x00b9 }
                org.codehaus.jackson.JsonParser$NumberType r1 = org.codehaus.jackson.JsonParser.NumberType.BIG_DECIMAL     // Catch:{ NoSuchFieldError -> 0x00b9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b9 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b9 }
            L_0x00b9:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonParser$NumberType     // Catch:{ NoSuchFieldError -> 0x00c3 }
                org.codehaus.jackson.JsonParser$NumberType r1 = org.codehaus.jackson.JsonParser.NumberType.FLOAT     // Catch:{ NoSuchFieldError -> 0x00c3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c3 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00c3 }
            L_0x00c3:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.impl.JsonGeneratorBase.C49061.<clinit>():void");
        }
    }

    public final void copyCurrentStructure(JsonParser jsonParser) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.FIELD_NAME) {
            writeFieldName(jsonParser.getCurrentName());
            currentToken = jsonParser.nextToken();
        }
        int i = C49061.$SwitchMap$org$codehaus$jackson$JsonToken[currentToken.ordinal()];
        if (i == 1) {
            writeStartObject();
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                copyCurrentStructure(jsonParser);
            }
            writeEndObject();
        } else if (i != 3) {
            copyCurrentEvent(jsonParser);
        } else {
            writeStartArray();
            while (jsonParser.nextToken() != JsonToken.END_ARRAY) {
                copyCurrentStructure(jsonParser);
            }
            writeEndArray();
        }
    }

    /* access modifiers changed from: protected */
    public void _reportError(String str) throws JsonGenerationException {
        throw new JsonGenerationException(str);
    }

    /* access modifiers changed from: protected */
    public void _cantHappen() {
        throw new RuntimeException("Internal error: should never end up through this code path");
    }

    /* access modifiers changed from: protected */
    public void _writeSimpleObject(Object obj) throws IOException, JsonGenerationException {
        if (obj == null) {
            writeNull();
        } else if (obj instanceof String) {
            writeString((String) obj);
        } else {
            if (obj instanceof Number) {
                Number number = (Number) obj;
                if (number instanceof Integer) {
                    writeNumber(number.intValue());
                    return;
                } else if (number instanceof Long) {
                    writeNumber(number.longValue());
                    return;
                } else if (number instanceof Double) {
                    writeNumber(number.doubleValue());
                    return;
                } else if (number instanceof Float) {
                    writeNumber(number.floatValue());
                    return;
                } else if (number instanceof Short) {
                    writeNumber((int) number.shortValue());
                    return;
                } else if (number instanceof Byte) {
                    writeNumber((int) number.byteValue());
                    return;
                } else if (number instanceof BigInteger) {
                    writeNumber((BigInteger) number);
                    return;
                } else if (number instanceof BigDecimal) {
                    writeNumber((BigDecimal) number);
                    return;
                } else if (number instanceof AtomicInteger) {
                    writeNumber(((AtomicInteger) number).get());
                    return;
                } else if (number instanceof AtomicLong) {
                    writeNumber(((AtomicLong) number).get());
                    return;
                }
            } else if (obj instanceof byte[]) {
                writeBinary((byte[]) obj);
                return;
            } else if (obj instanceof Boolean) {
                writeBoolean(((Boolean) obj).booleanValue());
                return;
            } else if (obj instanceof AtomicBoolean) {
                writeBoolean(((AtomicBoolean) obj).get());
                return;
            }
            throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + obj.getClass().getName() + ")");
        }
    }

    /* access modifiers changed from: protected */
    public final void _throwInternal() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }

    /* access modifiers changed from: protected */
    public void _reportUnsupportedOperation() {
        throw new UnsupportedOperationException("Operation not supported by generator of type " + getClass().getName());
    }
}
