package org.codehaus.jackson.util;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.impl.JsonParserMinimalBase;
import org.codehaus.jackson.impl.JsonReadContext;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.p063io.SerializedString;

public class TokenBuffer extends JsonGenerator {
    protected static final int DEFAULT_PARSER_FEATURES = JsonParser.Feature.collectDefaults();
    protected int _appendOffset;
    protected boolean _closed;
    protected Segment _first;
    protected int _generatorFeatures = DEFAULT_PARSER_FEATURES;
    protected Segment _last;
    protected ObjectCodec _objectCodec;
    protected JsonWriteContext _writeContext = JsonWriteContext.createRootContext();

    public void flush() throws IOException {
    }

    public JsonGenerator useDefaultPrettyPrinter() {
        return this;
    }

    public TokenBuffer(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
        Segment segment = new Segment();
        this._last = segment;
        this._first = segment;
        this._appendOffset = 0;
    }

    public JsonParser asParser() {
        return asParser(this._objectCodec);
    }

    public JsonParser asParser(ObjectCodec objectCodec) {
        return new Parser(this._first, objectCodec);
    }

    public JsonParser asParser(JsonParser jsonParser) {
        Parser parser = new Parser(this._first, jsonParser.getCodec());
        parser.setLocation(jsonParser.getTokenLocation());
        return parser;
    }

    public void serialize(JsonGenerator jsonGenerator) throws IOException, JsonGenerationException {
        Segment segment = this._first;
        int i = -1;
        while (true) {
            i++;
            if (i >= 16) {
                segment = segment.next();
                if (segment != null) {
                    i = 0;
                } else {
                    return;
                }
            }
            JsonToken type = segment.type(i);
            if (type != null) {
                switch (type) {
                    case START_OBJECT:
                        jsonGenerator.writeStartObject();
                        break;
                    case END_OBJECT:
                        jsonGenerator.writeEndObject();
                        break;
                    case START_ARRAY:
                        jsonGenerator.writeStartArray();
                        break;
                    case END_ARRAY:
                        jsonGenerator.writeEndArray();
                        break;
                    case FIELD_NAME:
                        Object obj = segment.get(i);
                        if (!(obj instanceof SerializableString)) {
                            jsonGenerator.writeFieldName((String) obj);
                            break;
                        } else {
                            jsonGenerator.writeFieldName((SerializableString) obj);
                            break;
                        }
                    case VALUE_STRING:
                        Object obj2 = segment.get(i);
                        if (!(obj2 instanceof SerializableString)) {
                            jsonGenerator.writeString((String) obj2);
                            break;
                        } else {
                            jsonGenerator.writeString((SerializableString) obj2);
                            break;
                        }
                    case VALUE_NUMBER_INT:
                        Number number = (Number) segment.get(i);
                        if (!(number instanceof BigInteger)) {
                            if (!(number instanceof Long)) {
                                jsonGenerator.writeNumber(number.intValue());
                                break;
                            } else {
                                jsonGenerator.writeNumber(number.longValue());
                                break;
                            }
                        } else {
                            jsonGenerator.writeNumber((BigInteger) number);
                            break;
                        }
                    case VALUE_NUMBER_FLOAT:
                        Object obj3 = segment.get(i);
                        if (obj3 instanceof BigDecimal) {
                            jsonGenerator.writeNumber((BigDecimal) obj3);
                            break;
                        } else if (obj3 instanceof Float) {
                            jsonGenerator.writeNumber(((Float) obj3).floatValue());
                            break;
                        } else if (obj3 instanceof Double) {
                            jsonGenerator.writeNumber(((Double) obj3).doubleValue());
                            break;
                        } else if (obj3 == null) {
                            jsonGenerator.writeNull();
                            break;
                        } else if (obj3 instanceof String) {
                            jsonGenerator.writeNumber((String) obj3);
                            break;
                        } else {
                            throw new JsonGenerationException("Unrecognized value type for VALUE_NUMBER_FLOAT: " + obj3.getClass().getName() + ", can not serialize");
                        }
                    case VALUE_TRUE:
                        jsonGenerator.writeBoolean(true);
                        break;
                    case VALUE_FALSE:
                        jsonGenerator.writeBoolean(false);
                        break;
                    case VALUE_NULL:
                        jsonGenerator.writeNull();
                        break;
                    case VALUE_EMBEDDED_OBJECT:
                        jsonGenerator.writeObject(segment.get(i));
                        break;
                    default:
                        throw new RuntimeException("Internal error: should never end up through this code path");
                }
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[TokenBuffer: ");
        JsonParser asParser = asParser();
        int i = 0;
        while (true) {
            try {
                JsonToken nextToken = asParser.nextToken();
                if (nextToken == null) {
                    break;
                }
                if (i < 100) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(nextToken.toString());
                }
                i++;
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
        if (i >= 100) {
            sb.append(" ... (truncated ");
            sb.append(i - 100);
            sb.append(" entries)");
        }
        sb.append(']');
        return sb.toString();
    }

    public JsonGenerator enable(JsonGenerator.Feature feature) {
        this._generatorFeatures = feature.getMask() | this._generatorFeatures;
        return this;
    }

    public JsonGenerator disable(JsonGenerator.Feature feature) {
        this._generatorFeatures = (~feature.getMask()) & this._generatorFeatures;
        return this;
    }

    public boolean isEnabled(JsonGenerator.Feature feature) {
        return (feature.getMask() & this._generatorFeatures) != 0;
    }

    public JsonGenerator setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
        return this;
    }

    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    public final JsonWriteContext getOutputContext() {
        return this._writeContext;
    }

    public void close() throws IOException {
        this._closed = true;
    }

    public boolean isClosed() {
        return this._closed;
    }

    public final void writeStartArray() throws IOException, JsonGenerationException {
        _append(JsonToken.START_ARRAY);
        this._writeContext = this._writeContext.createChildArrayContext();
    }

    public final void writeEndArray() throws IOException, JsonGenerationException {
        _append(JsonToken.END_ARRAY);
        JsonWriteContext parent = this._writeContext.getParent();
        if (parent != null) {
            this._writeContext = parent;
        }
    }

    public final void writeStartObject() throws IOException, JsonGenerationException {
        _append(JsonToken.START_OBJECT);
        this._writeContext = this._writeContext.createChildObjectContext();
    }

    public final void writeEndObject() throws IOException, JsonGenerationException {
        _append(JsonToken.END_OBJECT);
        JsonWriteContext parent = this._writeContext.getParent();
        if (parent != null) {
            this._writeContext = parent;
        }
    }

    public final void writeFieldName(String str) throws IOException, JsonGenerationException {
        _append(JsonToken.FIELD_NAME, str);
        this._writeContext.writeFieldName(str);
    }

    public void writeFieldName(SerializableString serializableString) throws IOException, JsonGenerationException {
        _append(JsonToken.FIELD_NAME, serializableString);
        this._writeContext.writeFieldName(serializableString.getValue());
    }

    public void writeFieldName(SerializedString serializedString) throws IOException, JsonGenerationException {
        _append(JsonToken.FIELD_NAME, serializedString);
        this._writeContext.writeFieldName(serializedString.getValue());
    }

    public void writeString(String str) throws IOException, JsonGenerationException {
        if (str == null) {
            writeNull();
        } else {
            _append(JsonToken.VALUE_STRING, str);
        }
    }

    public void writeString(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        writeString(new String(cArr, i, i2));
    }

    public void writeString(SerializableString serializableString) throws IOException, JsonGenerationException {
        if (serializableString == null) {
            writeNull();
        } else {
            _append(JsonToken.VALUE_STRING, serializableString);
        }
    }

    public void writeRawUTF8String(byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        _reportUnsupportedOperation();
    }

    public void writeUTF8String(byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        _reportUnsupportedOperation();
    }

    public void writeRaw(String str) throws IOException, JsonGenerationException {
        _reportUnsupportedOperation();
    }

    public void writeRaw(String str, int i, int i2) throws IOException, JsonGenerationException {
        _reportUnsupportedOperation();
    }

    public void writeRaw(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        _reportUnsupportedOperation();
    }

    public void writeRaw(char c) throws IOException, JsonGenerationException {
        _reportUnsupportedOperation();
    }

    public void writeRawValue(String str) throws IOException, JsonGenerationException {
        _reportUnsupportedOperation();
    }

    public void writeRawValue(String str, int i, int i2) throws IOException, JsonGenerationException {
        _reportUnsupportedOperation();
    }

    public void writeRawValue(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        _reportUnsupportedOperation();
    }

    public void writeNumber(int i) throws IOException, JsonGenerationException {
        _append(JsonToken.VALUE_NUMBER_INT, Integer.valueOf(i));
    }

    public void writeNumber(long j) throws IOException, JsonGenerationException {
        _append(JsonToken.VALUE_NUMBER_INT, Long.valueOf(j));
    }

    public void writeNumber(double d) throws IOException, JsonGenerationException {
        _append(JsonToken.VALUE_NUMBER_FLOAT, Double.valueOf(d));
    }

    public void writeNumber(float f) throws IOException, JsonGenerationException {
        _append(JsonToken.VALUE_NUMBER_FLOAT, Float.valueOf(f));
    }

    public void writeNumber(BigDecimal bigDecimal) throws IOException, JsonGenerationException {
        if (bigDecimal == null) {
            writeNull();
        } else {
            _append(JsonToken.VALUE_NUMBER_FLOAT, bigDecimal);
        }
    }

    public void writeNumber(BigInteger bigInteger) throws IOException, JsonGenerationException {
        if (bigInteger == null) {
            writeNull();
        } else {
            _append(JsonToken.VALUE_NUMBER_INT, bigInteger);
        }
    }

    public void writeNumber(String str) throws IOException, JsonGenerationException {
        _append(JsonToken.VALUE_NUMBER_FLOAT, str);
    }

    public void writeBoolean(boolean z) throws IOException, JsonGenerationException {
        _append(z ? JsonToken.VALUE_TRUE : JsonToken.VALUE_FALSE);
    }

    public void writeNull() throws IOException, JsonGenerationException {
        _append(JsonToken.VALUE_NULL);
    }

    public void writeObject(Object obj) throws IOException, JsonProcessingException {
        _append(JsonToken.VALUE_EMBEDDED_OBJECT, obj);
    }

    public void writeTree(JsonNode jsonNode) throws IOException, JsonProcessingException {
        _append(JsonToken.VALUE_EMBEDDED_OBJECT, jsonNode);
    }

    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        writeObject(bArr2);
    }

    public void copyCurrentEvent(JsonParser jsonParser) throws IOException, JsonProcessingException {
        switch (jsonParser.getCurrentToken()) {
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
                int i = C49241.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[jsonParser.getNumberType().ordinal()];
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
                int i2 = C49241.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[jsonParser.getNumberType().ordinal()];
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
                throw new RuntimeException("Internal error: should never end up through this code path");
        }
    }

    /* renamed from: org.codehaus.jackson.util.TokenBuffer$1 */
    static /* synthetic */ class C49241 {
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$JsonParser$NumberType = new int[JsonParser.NumberType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|(2:1|2)|3|5|6|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|46) */
        /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0067 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0071 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0091 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x009d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00a9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00b5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00c1 */
        static {
            /*
                org.codehaus.jackson.JsonParser$NumberType[] r0 = org.codehaus.jackson.JsonParser.NumberType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$codehaus$jackson$JsonParser$NumberType = r0
                r0 = 1
                int[] r1 = $SwitchMap$org$codehaus$jackson$JsonParser$NumberType     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.codehaus.jackson.JsonParser$NumberType r2 = org.codehaus.jackson.JsonParser.NumberType.INT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$org$codehaus$jackson$JsonParser$NumberType     // Catch:{ NoSuchFieldError -> 0x001f }
                org.codehaus.jackson.JsonParser$NumberType r3 = org.codehaus.jackson.JsonParser.NumberType.BIG_INTEGER     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = $SwitchMap$org$codehaus$jackson$JsonParser$NumberType     // Catch:{ NoSuchFieldError -> 0x002a }
                org.codehaus.jackson.JsonParser$NumberType r4 = org.codehaus.jackson.JsonParser.NumberType.BIG_DECIMAL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = $SwitchMap$org$codehaus$jackson$JsonParser$NumberType     // Catch:{ NoSuchFieldError -> 0x0035 }
                org.codehaus.jackson.JsonParser$NumberType r5 = org.codehaus.jackson.JsonParser.NumberType.FLOAT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                r4 = 5
                int[] r5 = $SwitchMap$org$codehaus$jackson$JsonParser$NumberType     // Catch:{ NoSuchFieldError -> 0x0040 }
                org.codehaus.jackson.JsonParser$NumberType r6 = org.codehaus.jackson.JsonParser.NumberType.LONG     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                org.codehaus.jackson.JsonToken[] r5 = org.codehaus.jackson.JsonToken.values()
                int r5 = r5.length
                int[] r5 = new int[r5]
                $SwitchMap$org$codehaus$jackson$JsonToken = r5
                int[] r5 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0053 }
                org.codehaus.jackson.JsonToken r6 = org.codehaus.jackson.JsonToken.START_OBJECT     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r5[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x005d }
                org.codehaus.jackson.JsonToken r5 = org.codehaus.jackson.JsonToken.END_OBJECT     // Catch:{ NoSuchFieldError -> 0x005d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0067 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.START_ARRAY     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0071 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.END_ARRAY     // Catch:{ NoSuchFieldError -> 0x0071 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0071 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0071 }
            L_0x0071:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x007b }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.FIELD_NAME     // Catch:{ NoSuchFieldError -> 0x007b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0086 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_STRING     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0091 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x0091 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0091 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0091 }
            L_0x0091:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x009d }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_NUMBER_FLOAT     // Catch:{ NoSuchFieldError -> 0x009d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009d }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009d }
            L_0x009d:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x00a9 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_TRUE     // Catch:{ NoSuchFieldError -> 0x00a9 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a9 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a9 }
            L_0x00a9:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x00b5 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_FALSE     // Catch:{ NoSuchFieldError -> 0x00b5 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b5 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b5 }
            L_0x00b5:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x00c1 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_NULL     // Catch:{ NoSuchFieldError -> 0x00c1 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c1 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c1 }
            L_0x00c1:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x00cd }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_EMBEDDED_OBJECT     // Catch:{ NoSuchFieldError -> 0x00cd }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cd }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cd }
            L_0x00cd:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.util.TokenBuffer.C49241.<clinit>():void");
        }
    }

    public void copyCurrentStructure(JsonParser jsonParser) throws IOException, JsonProcessingException {
        JsonToken currentToken = jsonParser.getCurrentToken();
        if (currentToken == JsonToken.FIELD_NAME) {
            writeFieldName(jsonParser.getCurrentName());
            currentToken = jsonParser.nextToken();
        }
        int i = C49241.$SwitchMap$org$codehaus$jackson$JsonToken[currentToken.ordinal()];
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
    public final void _append(JsonToken jsonToken) {
        Segment append = this._last.append(this._appendOffset, jsonToken);
        if (append == null) {
            this._appendOffset++;
            return;
        }
        this._last = append;
        this._appendOffset = 1;
    }

    /* access modifiers changed from: protected */
    public final void _append(JsonToken jsonToken, Object obj) {
        Segment append = this._last.append(this._appendOffset, jsonToken, obj);
        if (append == null) {
            this._appendOffset++;
            return;
        }
        this._last = append;
        this._appendOffset = 1;
    }

    /* access modifiers changed from: protected */
    public void _reportUnsupportedOperation() {
        throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
    }

    protected static final class Parser extends JsonParserMinimalBase {
        protected transient ByteArrayBuilder _byteBuilder;
        protected boolean _closed;
        protected ObjectCodec _codec;
        protected JsonLocation _location = null;
        protected JsonReadContext _parsingContext;
        protected Segment _segment;
        protected int _segmentPtr;

        public int getTextOffset() {
            return 0;
        }

        public boolean hasTextCharacters() {
            return false;
        }

        public Parser(Segment segment, ObjectCodec objectCodec) {
            super(0);
            this._segment = segment;
            this._segmentPtr = -1;
            this._codec = objectCodec;
            this._parsingContext = JsonReadContext.createRootContext(-1, -1);
        }

        public void setLocation(JsonLocation jsonLocation) {
            this._location = jsonLocation;
        }

        public ObjectCodec getCodec() {
            return this._codec;
        }

        public void setCodec(ObjectCodec objectCodec) {
            this._codec = objectCodec;
        }

        public JsonToken peekNextToken() throws IOException, JsonParseException {
            if (this._closed) {
                return null;
            }
            Segment segment = this._segment;
            int i = this._segmentPtr + 1;
            if (i >= 16) {
                i = 0;
                if (segment == null) {
                    segment = null;
                } else {
                    segment = segment.next();
                }
            }
            if (segment == null) {
                return null;
            }
            return segment.type(i);
        }

        public void close() throws IOException {
            if (!this._closed) {
                this._closed = true;
            }
        }

        public JsonToken nextToken() throws IOException, JsonParseException {
            Segment segment;
            if (this._closed || (segment = this._segment) == null) {
                return null;
            }
            int i = this._segmentPtr + 1;
            this._segmentPtr = i;
            if (i >= 16) {
                this._segmentPtr = 0;
                this._segment = segment.next();
                if (this._segment == null) {
                    return null;
                }
            }
            this._currToken = this._segment.type(this._segmentPtr);
            if (this._currToken == JsonToken.FIELD_NAME) {
                Object _currentObject = _currentObject();
                this._parsingContext.setCurrentName(_currentObject instanceof String ? (String) _currentObject : _currentObject.toString());
            } else if (this._currToken == JsonToken.START_OBJECT) {
                this._parsingContext = this._parsingContext.createChildObjectContext(-1, -1);
            } else if (this._currToken == JsonToken.START_ARRAY) {
                this._parsingContext = this._parsingContext.createChildArrayContext(-1, -1);
            } else if (this._currToken == JsonToken.END_OBJECT || this._currToken == JsonToken.END_ARRAY) {
                this._parsingContext = this._parsingContext.getParent();
                if (this._parsingContext == null) {
                    this._parsingContext = JsonReadContext.createRootContext(-1, -1);
                }
            }
            return this._currToken;
        }

        public boolean isClosed() {
            return this._closed;
        }

        public JsonStreamContext getParsingContext() {
            return this._parsingContext;
        }

        public JsonLocation getTokenLocation() {
            return getCurrentLocation();
        }

        public JsonLocation getCurrentLocation() {
            JsonLocation jsonLocation = this._location;
            return jsonLocation == null ? JsonLocation.f5825NA : jsonLocation;
        }

        public String getCurrentName() {
            return this._parsingContext.getCurrentName();
        }

        public String getText() {
            if (this._currToken == JsonToken.VALUE_STRING || this._currToken == JsonToken.FIELD_NAME) {
                Object _currentObject = _currentObject();
                if (_currentObject instanceof String) {
                    return (String) _currentObject;
                }
                if (_currentObject == null) {
                    return null;
                }
                return _currentObject.toString();
            } else if (this._currToken == null) {
                return null;
            } else {
                int i = C49241.$SwitchMap$org$codehaus$jackson$JsonToken[this._currToken.ordinal()];
                if (i != 7 && i != 8) {
                    return this._currToken.asString();
                }
                Object _currentObject2 = _currentObject();
                if (_currentObject2 == null) {
                    return null;
                }
                return _currentObject2.toString();
            }
        }

        public char[] getTextCharacters() {
            String text = getText();
            if (text == null) {
                return null;
            }
            return text.toCharArray();
        }

        public int getTextLength() {
            String text = getText();
            if (text == null) {
                return 0;
            }
            return text.length();
        }

        public BigInteger getBigIntegerValue() throws IOException, JsonParseException {
            Number numberValue = getNumberValue();
            if (numberValue instanceof BigInteger) {
                return (BigInteger) numberValue;
            }
            if (C49241.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[getNumberType().ordinal()] != 3) {
                return BigInteger.valueOf(numberValue.longValue());
            }
            return ((BigDecimal) numberValue).toBigInteger();
        }

        public BigDecimal getDecimalValue() throws IOException, JsonParseException {
            Number numberValue = getNumberValue();
            if (numberValue instanceof BigDecimal) {
                return (BigDecimal) numberValue;
            }
            int i = C49241.$SwitchMap$org$codehaus$jackson$JsonParser$NumberType[getNumberType().ordinal()];
            if (i != 1) {
                if (i == 2) {
                    return new BigDecimal((BigInteger) numberValue);
                }
                if (i != 5) {
                    return BigDecimal.valueOf(numberValue.doubleValue());
                }
            }
            return BigDecimal.valueOf(numberValue.longValue());
        }

        public double getDoubleValue() throws IOException, JsonParseException {
            return getNumberValue().doubleValue();
        }

        public float getFloatValue() throws IOException, JsonParseException {
            return getNumberValue().floatValue();
        }

        public int getIntValue() throws IOException, JsonParseException {
            if (this._currToken == JsonToken.VALUE_NUMBER_INT) {
                return ((Number) _currentObject()).intValue();
            }
            return getNumberValue().intValue();
        }

        public long getLongValue() throws IOException, JsonParseException {
            return getNumberValue().longValue();
        }

        public JsonParser.NumberType getNumberType() throws IOException, JsonParseException {
            Number numberValue = getNumberValue();
            if (numberValue instanceof Integer) {
                return JsonParser.NumberType.INT;
            }
            if (numberValue instanceof Long) {
                return JsonParser.NumberType.LONG;
            }
            if (numberValue instanceof Double) {
                return JsonParser.NumberType.DOUBLE;
            }
            if (numberValue instanceof BigDecimal) {
                return JsonParser.NumberType.BIG_DECIMAL;
            }
            if (numberValue instanceof Float) {
                return JsonParser.NumberType.FLOAT;
            }
            if (numberValue instanceof BigInteger) {
                return JsonParser.NumberType.BIG_INTEGER;
            }
            return null;
        }

        public final Number getNumberValue() throws IOException, JsonParseException {
            _checkIsNumber();
            return (Number) _currentObject();
        }

        public Object getEmbeddedObject() {
            if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
                return _currentObject();
            }
            return null;
        }

        public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException, JsonParseException {
            if (this._currToken == JsonToken.VALUE_EMBEDDED_OBJECT) {
                Object _currentObject = _currentObject();
                if (_currentObject instanceof byte[]) {
                    return (byte[]) _currentObject;
                }
            }
            if (this._currToken == JsonToken.VALUE_STRING) {
                String text = getText();
                if (text == null) {
                    return null;
                }
                ByteArrayBuilder byteArrayBuilder = this._byteBuilder;
                if (byteArrayBuilder == null) {
                    byteArrayBuilder = new ByteArrayBuilder(100);
                    this._byteBuilder = byteArrayBuilder;
                }
                _decodeBase64(text, byteArrayBuilder, base64Variant);
                return byteArrayBuilder.toByteArray();
            }
            throw _constructError("Current token (" + this._currToken + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), can not access as binary");
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
            _reportBase64EOF();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
            r2 = r3 + 1;
            r3 = r11.charAt(r3);
            r6 = r13.decodeBase64Char(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
            if (r6 >= 0) goto L_0x0035;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
            _reportInvalidBase64(r13, r3, 1, (java.lang.String) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0035, code lost:
            r3 = (r4 << 6) | r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
            if (r2 < r0) goto L_0x004a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
            if (r13.usesPadding() != false) goto L_0x0047;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0040, code lost:
            r12.append(r3 >> 4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0047, code lost:
            _reportBase64EOF();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
            r4 = r2 + 1;
            r2 = r11.charAt(r2);
            r6 = r13.decodeBase64Char(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
            if (r6 >= 0) goto L_0x0093;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
            if (r6 == -2) goto L_0x005e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x005b, code lost:
            _reportInvalidBase64(r13, r2, 2, (java.lang.String) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x005e, code lost:
            if (r4 < r0) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0060, code lost:
            _reportBase64EOF();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
            r2 = r4 + 1;
            r4 = r11.charAt(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x006d, code lost:
            if (r13.usesPaddingChar(r4) != false) goto L_0x008c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x006f, code lost:
            _reportInvalidBase64(r13, r4, 3, "expected padding character '" + r13.getPaddingChar() + "'");
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x008c, code lost:
            r12.append(r3 >> 4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0093, code lost:
            r2 = (r3 << 6) | r6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x0096, code lost:
            if (r4 < r0) goto L_0x00a7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x009c, code lost:
            if (r13.usesPadding() != false) goto L_0x00a4;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x009e, code lost:
            r12.appendTwoBytes(r2 >> 2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a4, code lost:
            _reportBase64EOF();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a7, code lost:
            r3 = r4 + 1;
            r4 = r11.charAt(r4);
            r6 = r13.decodeBase64Char(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b1, code lost:
            if (r6 >= 0) goto L_0x00be;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b3, code lost:
            if (r6 == -2) goto L_0x00b8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b5, code lost:
            _reportInvalidBase64(r13, r4, 3, (java.lang.String) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b8, code lost:
            r12.appendTwoBytes(r2 >> 2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:0x00be, code lost:
            r12.appendThreeBytes((r2 << 6) | r6);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c4, code lost:
            r2 = r3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0016, code lost:
            r4 = r13.decodeBase64Char(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001b, code lost:
            if (r4 >= 0) goto L_0x0020;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001d, code lost:
            _reportInvalidBase64(r13, r2, 0, (java.lang.String) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
            if (r3 < r0) goto L_0x0025;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void _decodeBase64(java.lang.String r11, org.codehaus.jackson.util.ByteArrayBuilder r12, org.codehaus.jackson.Base64Variant r13) throws java.io.IOException, org.codehaus.jackson.JsonParseException {
            /*
                r10 = this;
                int r0 = r11.length()
                r1 = 0
                r2 = 0
            L_0x0006:
                if (r2 >= r0) goto L_0x00ca
            L_0x0008:
                int r3 = r2 + 1
                char r2 = r11.charAt(r2)
                if (r3 < r0) goto L_0x0012
                goto L_0x00ca
            L_0x0012:
                r4 = 32
                if (r2 <= r4) goto L_0x00c7
                int r4 = r13.decodeBase64Char((char) r2)
                r5 = 0
                if (r4 >= 0) goto L_0x0020
                r10._reportInvalidBase64(r13, r2, r1, r5)
            L_0x0020:
                if (r3 < r0) goto L_0x0025
                r10._reportBase64EOF()
            L_0x0025:
                int r2 = r3 + 1
                char r3 = r11.charAt(r3)
                int r6 = r13.decodeBase64Char((char) r3)
                if (r6 >= 0) goto L_0x0035
                r7 = 1
                r10._reportInvalidBase64(r13, r3, r7, r5)
            L_0x0035:
                int r3 = r4 << 6
                r3 = r3 | r6
                if (r2 < r0) goto L_0x004a
                boolean r4 = r13.usesPadding()
                if (r4 != 0) goto L_0x0047
                int r11 = r3 >> 4
                r12.append(r11)
                goto L_0x00ca
            L_0x0047:
                r10._reportBase64EOF()
            L_0x004a:
                int r4 = r2 + 1
                char r2 = r11.charAt(r2)
                int r6 = r13.decodeBase64Char((char) r2)
                r7 = 3
                r8 = -2
                r9 = 2
                if (r6 >= 0) goto L_0x0093
                if (r6 == r8) goto L_0x005e
                r10._reportInvalidBase64(r13, r2, r9, r5)
            L_0x005e:
                if (r4 < r0) goto L_0x0063
                r10._reportBase64EOF()
            L_0x0063:
                int r2 = r4 + 1
                char r4 = r11.charAt(r4)
                boolean r5 = r13.usesPaddingChar((char) r4)
                if (r5 != 0) goto L_0x008c
                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                r5.<init>()
                java.lang.String r6 = "expected padding character '"
                r5.append(r6)
                char r6 = r13.getPaddingChar()
                r5.append(r6)
                java.lang.String r6 = "'"
                r5.append(r6)
                java.lang.String r5 = r5.toString()
                r10._reportInvalidBase64(r13, r4, r7, r5)
            L_0x008c:
                int r3 = r3 >> 4
                r12.append(r3)
                goto L_0x0006
            L_0x0093:
                int r2 = r3 << 6
                r2 = r2 | r6
                if (r4 < r0) goto L_0x00a7
                boolean r3 = r13.usesPadding()
                if (r3 != 0) goto L_0x00a4
                int r11 = r2 >> 2
                r12.appendTwoBytes(r11)
                goto L_0x00ca
            L_0x00a4:
                r10._reportBase64EOF()
            L_0x00a7:
                int r3 = r4 + 1
                char r4 = r11.charAt(r4)
                int r6 = r13.decodeBase64Char((char) r4)
                if (r6 >= 0) goto L_0x00be
                if (r6 == r8) goto L_0x00b8
                r10._reportInvalidBase64(r13, r4, r7, r5)
            L_0x00b8:
                int r2 = r2 >> 2
                r12.appendTwoBytes(r2)
                goto L_0x00c4
            L_0x00be:
                int r2 = r2 << 6
                r2 = r2 | r6
                r12.appendThreeBytes(r2)
            L_0x00c4:
                r2 = r3
                goto L_0x0006
            L_0x00c7:
                r2 = r3
                goto L_0x0008
            L_0x00ca:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.util.TokenBuffer.Parser._decodeBase64(java.lang.String, org.codehaus.jackson.util.ByteArrayBuilder, org.codehaus.jackson.Base64Variant):void");
        }

        /* access modifiers changed from: protected */
        public final Object _currentObject() {
            return this._segment.get(this._segmentPtr);
        }

        /* access modifiers changed from: protected */
        public final void _checkIsNumber() throws JsonParseException {
            if (this._currToken == null || !this._currToken.isNumeric()) {
                throw _constructError("Current token (" + this._currToken + ") not numeric, can not use numeric value accessors");
            }
        }

        /* access modifiers changed from: protected */
        public void _reportInvalidBase64(Base64Variant base64Variant, char c, int i, String str) throws JsonParseException {
            String str2;
            if (c <= ' ') {
                str2 = "Illegal white space character (code 0x" + Integer.toHexString(c) + ") as character #" + (i + 1) + " of 4-char base64 unit: can only used between units";
            } else if (base64Variant.usesPaddingChar(c)) {
                str2 = "Unexpected padding character ('" + base64Variant.getPaddingChar() + "') as character #" + (i + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
            } else if (!Character.isDefined(c) || Character.isISOControl(c)) {
                str2 = "Illegal character (code 0x" + Integer.toHexString(c) + ") in base64 content";
            } else {
                str2 = "Illegal character '" + c + "' (code 0x" + Integer.toHexString(c) + ") in base64 content";
            }
            if (str != null) {
                str2 = str2 + ": " + str;
            }
            throw _constructError(str2);
        }

        /* access modifiers changed from: protected */
        public void _reportBase64EOF() throws JsonParseException {
            throw _constructError("Unexpected end-of-String in base64 content");
        }

        /* access modifiers changed from: protected */
        public void _handleEOF() throws JsonParseException {
            _throwInternal();
        }
    }

    protected static final class Segment {
        public static final int TOKENS_PER_SEGMENT = 16;
        private static final JsonToken[] TOKEN_TYPES_BY_INDEX = new JsonToken[16];
        protected Segment _next;
        protected long _tokenTypes;
        protected final Object[] _tokens = new Object[16];

        static {
            JsonToken[] values = JsonToken.values();
            System.arraycopy(values, 1, TOKEN_TYPES_BY_INDEX, 1, Math.min(15, values.length - 1));
        }

        public JsonToken type(int i) {
            long j = this._tokenTypes;
            if (i > 0) {
                j >>= i << 2;
            }
            return TOKEN_TYPES_BY_INDEX[((int) j) & 15];
        }

        public Object get(int i) {
            return this._tokens[i];
        }

        public Segment next() {
            return this._next;
        }

        public Segment append(int i, JsonToken jsonToken) {
            if (i < 16) {
                set(i, jsonToken);
                return null;
            }
            this._next = new Segment();
            this._next.set(0, jsonToken);
            return this._next;
        }

        public Segment append(int i, JsonToken jsonToken, Object obj) {
            if (i < 16) {
                set(i, jsonToken, obj);
                return null;
            }
            this._next = new Segment();
            this._next.set(0, jsonToken, obj);
            return this._next;
        }

        public void set(int i, JsonToken jsonToken) {
            long ordinal = (long) jsonToken.ordinal();
            if (i > 0) {
                ordinal <<= i << 2;
            }
            this._tokenTypes |= ordinal;
        }

        public void set(int i, JsonToken jsonToken, Object obj) {
            this._tokens[i] = obj;
            long ordinal = (long) jsonToken.ordinal();
            if (i > 0) {
                ordinal <<= i << 2;
            }
            this._tokenTypes |= ordinal;
        }
    }
}
