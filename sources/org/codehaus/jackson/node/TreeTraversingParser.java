package org.codehaus.jackson.node;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.impl.JsonParserMinimalBase;
import org.codehaus.jackson.node.NodeCursor;

public class TreeTraversingParser extends JsonParserMinimalBase {
    protected boolean _closed;
    protected JsonToken _nextToken;
    protected NodeCursor _nodeCursor;
    protected ObjectCodec _objectCodec;
    protected boolean _startContainer;

    public int getTextOffset() throws IOException, JsonParseException {
        return 0;
    }

    public boolean hasTextCharacters() {
        return false;
    }

    public TreeTraversingParser(JsonNode jsonNode) {
        this(jsonNode, (ObjectCodec) null);
    }

    public TreeTraversingParser(JsonNode jsonNode, ObjectCodec objectCodec) {
        super(0);
        this._objectCodec = objectCodec;
        if (jsonNode.isArray()) {
            this._nextToken = JsonToken.START_ARRAY;
            this._nodeCursor = new NodeCursor.Array(jsonNode, (NodeCursor) null);
        } else if (jsonNode.isObject()) {
            this._nextToken = JsonToken.START_OBJECT;
            this._nodeCursor = new NodeCursor.Object(jsonNode, (NodeCursor) null);
        } else {
            this._nodeCursor = new NodeCursor.RootValue(jsonNode, (NodeCursor) null);
        }
    }

    public void setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
    }

    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    public void close() throws IOException {
        if (!this._closed) {
            this._closed = true;
            this._nodeCursor = null;
            this._currToken = null;
        }
    }

    public JsonToken nextToken() throws IOException, JsonParseException {
        JsonToken jsonToken = this._nextToken;
        if (jsonToken != null) {
            this._currToken = jsonToken;
            this._nextToken = null;
            return this._currToken;
        } else if (this._startContainer) {
            this._startContainer = false;
            if (!this._nodeCursor.currentHasChildren()) {
                this._currToken = this._currToken == JsonToken.START_OBJECT ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
                return this._currToken;
            }
            this._nodeCursor = this._nodeCursor.iterateChildren();
            this._currToken = this._nodeCursor.nextToken();
            if (this._currToken == JsonToken.START_OBJECT || this._currToken == JsonToken.START_ARRAY) {
                this._startContainer = true;
            }
            return this._currToken;
        } else {
            NodeCursor nodeCursor = this._nodeCursor;
            if (nodeCursor == null) {
                this._closed = true;
                return null;
            }
            this._currToken = nodeCursor.nextToken();
            if (this._currToken != null) {
                if (this._currToken == JsonToken.START_OBJECT || this._currToken == JsonToken.START_ARRAY) {
                    this._startContainer = true;
                }
                return this._currToken;
            }
            this._currToken = this._nodeCursor.endToken();
            this._nodeCursor = this._nodeCursor.getParent();
            return this._currToken;
        }
    }

    public JsonParser skipChildren() throws IOException, JsonParseException {
        if (this._currToken == JsonToken.START_OBJECT) {
            this._startContainer = false;
            this._currToken = JsonToken.END_OBJECT;
        } else if (this._currToken == JsonToken.START_ARRAY) {
            this._startContainer = false;
            this._currToken = JsonToken.END_ARRAY;
        }
        return this;
    }

    public boolean isClosed() {
        return this._closed;
    }

    public String getCurrentName() {
        NodeCursor nodeCursor = this._nodeCursor;
        if (nodeCursor == null) {
            return null;
        }
        return nodeCursor.getCurrentName();
    }

    public JsonStreamContext getParsingContext() {
        return this._nodeCursor;
    }

    public JsonLocation getTokenLocation() {
        return JsonLocation.f5825NA;
    }

    public JsonLocation getCurrentLocation() {
        return JsonLocation.f5825NA;
    }

    public String getText() {
        JsonNode currentNode;
        if (this._closed) {
            return null;
        }
        int i = C49231.$SwitchMap$org$codehaus$jackson$JsonToken[this._currToken.ordinal()];
        if (i == 1) {
            return this._nodeCursor.getCurrentName();
        }
        if (i == 2) {
            return currentNode().getTextValue();
        }
        if (i == 3 || i == 4) {
            return String.valueOf(currentNode().getNumberValue());
        }
        if (i == 5 && (currentNode = currentNode()) != null && currentNode.isBinary()) {
            return currentNode.getValueAsText();
        }
        if (this._currToken == null) {
            return null;
        }
        return this._currToken.asString();
    }

    /* renamed from: org.codehaus.jackson.node.TreeTraversingParser$1 */
    static /* synthetic */ class C49231 {
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$JsonToken = new int[JsonToken.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                org.codehaus.jackson.JsonToken[] r0 = org.codehaus.jackson.JsonToken.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$org$codehaus$jackson$JsonToken = r0
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0014 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.FIELD_NAME     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x001f }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_STRING     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x002a }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_NUMBER_INT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0035 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_NUMBER_FLOAT     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = $SwitchMap$org$codehaus$jackson$JsonToken     // Catch:{ NoSuchFieldError -> 0x0040 }
                org.codehaus.jackson.JsonToken r1 = org.codehaus.jackson.JsonToken.VALUE_EMBEDDED_OBJECT     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.node.TreeTraversingParser.C49231.<clinit>():void");
        }
    }

    public char[] getTextCharacters() throws IOException, JsonParseException {
        return getText().toCharArray();
    }

    public int getTextLength() throws IOException, JsonParseException {
        return getText().length();
    }

    public JsonParser.NumberType getNumberType() throws IOException, JsonParseException {
        JsonNode currentNumericNode = currentNumericNode();
        if (currentNumericNode == null) {
            return null;
        }
        return currentNumericNode.getNumberType();
    }

    public BigInteger getBigIntegerValue() throws IOException, JsonParseException {
        return currentNumericNode().getBigIntegerValue();
    }

    public BigDecimal getDecimalValue() throws IOException, JsonParseException {
        return currentNumericNode().getDecimalValue();
    }

    public double getDoubleValue() throws IOException, JsonParseException {
        return currentNumericNode().getDoubleValue();
    }

    public float getFloatValue() throws IOException, JsonParseException {
        return (float) currentNumericNode().getDoubleValue();
    }

    public long getLongValue() throws IOException, JsonParseException {
        return currentNumericNode().getLongValue();
    }

    public int getIntValue() throws IOException, JsonParseException {
        return currentNumericNode().getIntValue();
    }

    public Number getNumberValue() throws IOException, JsonParseException {
        return currentNumericNode().getNumberValue();
    }

    public Object getEmbeddedObject() {
        JsonNode currentNode;
        if (this._closed || (currentNode = currentNode()) == null || !currentNode.isPojo()) {
            return null;
        }
        return ((POJONode) currentNode).getPojo();
    }

    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException, JsonParseException {
        JsonNode currentNode = currentNode();
        if (currentNode == null) {
            return null;
        }
        byte[] binaryValue = currentNode.getBinaryValue();
        if (binaryValue != null) {
            return binaryValue;
        }
        if (!currentNode.isPojo()) {
            return null;
        }
        Object pojo = ((POJONode) currentNode).getPojo();
        if (pojo instanceof byte[]) {
            return (byte[]) pojo;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public JsonNode currentNode() {
        NodeCursor nodeCursor;
        if (this._closed || (nodeCursor = this._nodeCursor) == null) {
            return null;
        }
        return nodeCursor.currentNode();
    }

    /* access modifiers changed from: protected */
    public JsonNode currentNumericNode() throws JsonParseException {
        JsonToken jsonToken;
        JsonNode currentNode = currentNode();
        if (currentNode != null && currentNode.isNumber()) {
            return currentNode;
        }
        if (currentNode == null) {
            jsonToken = null;
        } else {
            jsonToken = currentNode.asToken();
        }
        throw _constructError("Current token (" + jsonToken + ") not numeric, can not use numeric value accessors");
    }

    /* access modifiers changed from: protected */
    public void _handleEOF() throws JsonParseException {
        _throwInternal();
    }
}
