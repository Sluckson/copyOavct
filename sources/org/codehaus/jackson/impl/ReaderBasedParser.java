package org.codehaus.jackson.impl;

import java.io.IOException;
import java.io.Reader;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.p063io.IOContext;
import org.codehaus.jackson.sym.CharsToNameCanonicalizer;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.CharTypes;
import org.codehaus.jackson.util.TextBuffer;

public final class ReaderBasedParser extends ReaderBasedNumericParser {
    protected ObjectCodec _objectCodec;
    protected final CharsToNameCanonicalizer _symbols;
    protected boolean _tokenIncomplete = false;

    public ReaderBasedParser(IOContext iOContext, int i, Reader reader, ObjectCodec objectCodec, CharsToNameCanonicalizer charsToNameCanonicalizer) {
        super(iOContext, i, reader);
        this._objectCodec = objectCodec;
        this._symbols = charsToNameCanonicalizer;
    }

    public ObjectCodec getCodec() {
        return this._objectCodec;
    }

    public void setCodec(ObjectCodec objectCodec) {
        this._objectCodec = objectCodec;
    }

    public final String getText() throws IOException, JsonParseException {
        JsonToken jsonToken = this._currToken;
        if (jsonToken != JsonToken.VALUE_STRING) {
            return _getText2(jsonToken);
        }
        if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.contentsAsString();
    }

    /* renamed from: org.codehaus.jackson.impl.ReaderBasedParser$1 */
    static /* synthetic */ class C49091 {
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$JsonToken = new int[JsonToken.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
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
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.impl.ReaderBasedParser.C49091.<clinit>():void");
        }
    }

    /* access modifiers changed from: protected */
    public final String _getText2(JsonToken jsonToken) {
        if (jsonToken == null) {
            return null;
        }
        int i = C49091.$SwitchMap$org$codehaus$jackson$JsonToken[jsonToken.ordinal()];
        if (i == 1) {
            return this._parsingContext.getCurrentName();
        }
        if (i == 2 || i == 3 || i == 4) {
            return this._textBuffer.contentsAsString();
        }
        return jsonToken.asString();
    }

    public char[] getTextCharacters() throws IOException, JsonParseException {
        if (this._currToken == null) {
            return null;
        }
        int i = C49091.$SwitchMap$org$codehaus$jackson$JsonToken[this._currToken.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (!(i == 3 || i == 4)) {
                    return this._currToken.asCharArray();
                }
            } else if (this._tokenIncomplete) {
                this._tokenIncomplete = false;
                _finishString();
            }
            return this._textBuffer.getTextBuffer();
        }
        if (!this._nameCopied) {
            String currentName = this._parsingContext.getCurrentName();
            int length = currentName.length();
            if (this._nameCopyBuffer == null) {
                this._nameCopyBuffer = this._ioContext.allocNameCopyBuffer(length);
            } else if (this._nameCopyBuffer.length < length) {
                this._nameCopyBuffer = new char[length];
            }
            currentName.getChars(0, length, this._nameCopyBuffer, 0);
            this._nameCopied = true;
        }
        return this._nameCopyBuffer;
    }

    public int getTextLength() throws IOException, JsonParseException {
        if (this._currToken == null) {
            return 0;
        }
        int i = C49091.$SwitchMap$org$codehaus$jackson$JsonToken[this._currToken.ordinal()];
        if (i == 1) {
            return this._parsingContext.getCurrentName().length();
        }
        if (i != 2) {
            if (!(i == 3 || i == 4)) {
                return this._currToken.asCharArray().length;
            }
        } else if (this._tokenIncomplete) {
            this._tokenIncomplete = false;
            _finishString();
        }
        return this._textBuffer.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        if (r0 != 4) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getTextOffset() throws java.io.IOException, org.codehaus.jackson.JsonParseException {
        /*
            r3 = this;
            org.codehaus.jackson.JsonToken r0 = r3._currToken
            r1 = 0
            if (r0 == 0) goto L_0x002c
            int[] r0 = org.codehaus.jackson.impl.ReaderBasedParser.C49091.$SwitchMap$org$codehaus$jackson$JsonToken
            org.codehaus.jackson.JsonToken r2 = r3._currToken
            int r2 = r2.ordinal()
            r0 = r0[r2]
            r2 = 1
            if (r0 == r2) goto L_0x002c
            r2 = 2
            if (r0 == r2) goto L_0x001c
            r2 = 3
            if (r0 == r2) goto L_0x0025
            r2 = 4
            if (r0 == r2) goto L_0x0025
            goto L_0x002c
        L_0x001c:
            boolean r0 = r3._tokenIncomplete
            if (r0 == 0) goto L_0x0025
            r3._tokenIncomplete = r1
            r3._finishString()
        L_0x0025:
            org.codehaus.jackson.util.TextBuffer r0 = r3._textBuffer
            int r0 = r0.getTextOffset()
            return r0
        L_0x002c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.impl.ReaderBasedParser.getTextOffset():int");
    }

    public byte[] getBinaryValue(Base64Variant base64Variant) throws IOException, JsonParseException {
        if (this._currToken != JsonToken.VALUE_STRING && (this._currToken != JsonToken.VALUE_EMBEDDED_OBJECT || this._binaryValue == null)) {
            _reportError("Current token (" + this._currToken + ") not VALUE_STRING or VALUE_EMBEDDED_OBJECT, can not access as binary");
        }
        if (this._tokenIncomplete) {
            try {
                this._binaryValue = _decodeBase64(base64Variant);
                this._tokenIncomplete = false;
            } catch (IllegalArgumentException e) {
                throw _constructError("Failed to decode VALUE_STRING as base64 (" + base64Variant + "): " + e.getMessage());
            }
        }
        return this._binaryValue;
    }

    public JsonToken nextToken() throws IOException, JsonParseException {
        JsonToken jsonToken;
        if (this._currToken == JsonToken.FIELD_NAME) {
            return _nextAfterName();
        }
        if (this._tokenIncomplete) {
            _skipString();
        }
        int _skipWSOrEnd = _skipWSOrEnd();
        if (_skipWSOrEnd < 0) {
            close();
            this._currToken = null;
            return null;
        }
        this._tokenInputTotal = (this._currInputProcessed + ((long) this._inputPtr)) - 1;
        this._tokenInputRow = this._currInputRow;
        this._tokenInputCol = (this._inputPtr - this._currInputRowStart) - 1;
        this._binaryValue = null;
        if (_skipWSOrEnd == 93) {
            if (!this._parsingContext.inArray()) {
                _reportMismatchedEndMarker(_skipWSOrEnd, '}');
            }
            this._parsingContext = this._parsingContext.getParent();
            JsonToken jsonToken2 = JsonToken.END_ARRAY;
            this._currToken = jsonToken2;
            return jsonToken2;
        } else if (_skipWSOrEnd == 125) {
            if (!this._parsingContext.inObject()) {
                _reportMismatchedEndMarker(_skipWSOrEnd, ']');
            }
            this._parsingContext = this._parsingContext.getParent();
            JsonToken jsonToken3 = JsonToken.END_OBJECT;
            this._currToken = jsonToken3;
            return jsonToken3;
        } else {
            if (this._parsingContext.expectComma()) {
                if (_skipWSOrEnd != 44) {
                    _reportUnexpectedChar(_skipWSOrEnd, "was expecting comma to separate " + this._parsingContext.getTypeDesc() + " entries");
                }
                _skipWSOrEnd = _skipWS();
            }
            boolean inObject = this._parsingContext.inObject();
            if (inObject) {
                this._parsingContext.setCurrentName(_parseFieldName(_skipWSOrEnd));
                this._currToken = JsonToken.FIELD_NAME;
                int _skipWS = _skipWS();
                if (_skipWS != 58) {
                    _reportUnexpectedChar(_skipWS, "was expecting a colon to separate field name and value");
                }
                _skipWSOrEnd = _skipWS();
            }
            if (_skipWSOrEnd != 34) {
                if (_skipWSOrEnd != 45) {
                    if (_skipWSOrEnd != 91) {
                        if (_skipWSOrEnd != 93) {
                            if (_skipWSOrEnd == 102) {
                                _matchToken(JsonToken.VALUE_FALSE);
                                jsonToken = JsonToken.VALUE_FALSE;
                            } else if (_skipWSOrEnd != 110) {
                                if (_skipWSOrEnd != 116) {
                                    if (_skipWSOrEnd != 123) {
                                        if (_skipWSOrEnd != 125) {
                                            switch (_skipWSOrEnd) {
                                                case 48:
                                                case 49:
                                                case 50:
                                                case 51:
                                                case 52:
                                                case 53:
                                                case 54:
                                                case 55:
                                                case 56:
                                                case 57:
                                                    break;
                                                default:
                                                    jsonToken = _handleUnexpectedValue(_skipWSOrEnd);
                                                    break;
                                            }
                                        }
                                    } else {
                                        if (!inObject) {
                                            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
                                        }
                                        jsonToken = JsonToken.START_OBJECT;
                                    }
                                }
                                _matchToken(JsonToken.VALUE_TRUE);
                                jsonToken = JsonToken.VALUE_TRUE;
                            } else {
                                _matchToken(JsonToken.VALUE_NULL);
                                jsonToken = JsonToken.VALUE_NULL;
                            }
                        }
                        _reportUnexpectedChar(_skipWSOrEnd, "expected a value");
                        _matchToken(JsonToken.VALUE_TRUE);
                        jsonToken = JsonToken.VALUE_TRUE;
                    } else {
                        if (!inObject) {
                            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
                        }
                        jsonToken = JsonToken.START_ARRAY;
                    }
                }
                jsonToken = parseNumberText(_skipWSOrEnd);
            } else {
                this._tokenIncomplete = true;
                jsonToken = JsonToken.VALUE_STRING;
            }
            if (inObject) {
                this._nextToken = jsonToken;
                return this._currToken;
            }
            this._currToken = jsonToken;
            return jsonToken;
        }
    }

    private final JsonToken _nextAfterName() {
        this._nameCopied = false;
        JsonToken jsonToken = this._nextToken;
        this._nextToken = null;
        if (jsonToken == JsonToken.START_ARRAY) {
            this._parsingContext = this._parsingContext.createChildArrayContext(this._tokenInputRow, this._tokenInputCol);
        } else if (jsonToken == JsonToken.START_OBJECT) {
            this._parsingContext = this._parsingContext.createChildObjectContext(this._tokenInputRow, this._tokenInputCol);
        }
        this._currToken = jsonToken;
        return jsonToken;
    }

    public void close() throws IOException {
        super.close();
        this._symbols.release();
    }

    /* access modifiers changed from: protected */
    public final String _parseFieldName(int i) throws IOException, JsonParseException {
        if (i != 34) {
            return _handleUnusualFieldName(i);
        }
        int i2 = this._inputPtr;
        int i3 = 0;
        int i4 = this._inputEnd;
        if (i2 < i4) {
            int[] inputCodeLatin1 = CharTypes.getInputCodeLatin1();
            int length = inputCodeLatin1.length;
            while (true) {
                char c = this._inputBuffer[i2];
                if (c >= length || inputCodeLatin1[c] == 0) {
                    i3 = (i3 * 31) + c;
                    i2++;
                    if (i2 >= i4) {
                        break;
                    }
                } else if (c == '\"') {
                    int i5 = this._inputPtr;
                    this._inputPtr = i2 + 1;
                    return this._symbols.findSymbol(this._inputBuffer, i5, i2 - i5, i3);
                }
            }
        }
        int i6 = this._inputPtr;
        this._inputPtr = i2;
        return _parseFieldName2(i6, i3, 34);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String _parseFieldName2(int r5, int r6, int r7) throws java.io.IOException, org.codehaus.jackson.JsonParseException {
        /*
            r4 = this;
            org.codehaus.jackson.util.TextBuffer r0 = r4._textBuffer
            char[] r1 = r4._inputBuffer
            int r2 = r4._inputPtr
            int r2 = r2 - r5
            r0.resetWithShared(r1, r5, r2)
            org.codehaus.jackson.util.TextBuffer r5 = r4._textBuffer
            char[] r5 = r5.getCurrentSegment()
            org.codehaus.jackson.util.TextBuffer r0 = r4._textBuffer
            int r0 = r0.getCurrentSegmentSize()
        L_0x0016:
            int r1 = r4._inputPtr
            int r2 = r4._inputEnd
            if (r1 < r2) goto L_0x003c
            boolean r1 = r4.loadMore()
            if (r1 != 0) goto L_0x003c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = ": was expecting closing '"
            r1.append(r2)
            char r2 = (char) r7
            r1.append(r2)
            java.lang.String r2 = "' for name"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r4._reportInvalidEOF(r1)
        L_0x003c:
            char[] r1 = r4._inputBuffer
            int r2 = r4._inputPtr
            int r3 = r2 + 1
            r4._inputPtr = r3
            char r1 = r1[r2]
            r2 = 92
            if (r1 > r2) goto L_0x0078
            if (r1 != r2) goto L_0x0051
            char r2 = r4._decodeEscaped()
            goto L_0x0079
        L_0x0051:
            if (r1 > r7) goto L_0x0078
            if (r1 != r7) goto L_0x006f
            org.codehaus.jackson.util.TextBuffer r5 = r4._textBuffer
            r5.setCurrentLength(r0)
            org.codehaus.jackson.util.TextBuffer r5 = r4._textBuffer
            char[] r7 = r5.getTextBuffer()
            int r0 = r5.getTextOffset()
            int r5 = r5.size()
            org.codehaus.jackson.sym.CharsToNameCanonicalizer r1 = r4._symbols
            java.lang.String r5 = r1.findSymbol(r7, r0, r5, r6)
            return r5
        L_0x006f:
            r2 = 32
            if (r1 >= r2) goto L_0x0078
            java.lang.String r2 = "name"
            r4._throwUnquotedSpace(r1, r2)
        L_0x0078:
            r2 = r1
        L_0x0079:
            int r6 = r6 * 31
            int r6 = r6 + r1
            int r1 = r0 + 1
            r5[r0] = r2
            int r0 = r5.length
            if (r1 < r0) goto L_0x008b
            org.codehaus.jackson.util.TextBuffer r5 = r4._textBuffer
            char[] r5 = r5.finishCurrentSegment()
            r0 = 0
            goto L_0x0016
        L_0x008b:
            r0 = r1
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.impl.ReaderBasedParser._parseFieldName2(int, int, int):java.lang.String");
    }

    /* access modifiers changed from: protected */
    public final String _handleUnusualFieldName(int i) throws IOException, JsonParseException {
        boolean z;
        if (i == 39 && isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return _parseApostropheFieldName();
        }
        if (!isEnabled(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)) {
            _reportUnexpectedChar(i, "was expecting double-quote to start field name");
        }
        int[] inputCodeLatin1JsNames = CharTypes.getInputCodeLatin1JsNames();
        int length = inputCodeLatin1JsNames.length;
        int i2 = 0;
        if (i < length) {
            z = inputCodeLatin1JsNames[i] == 0 && (i < 48 || i > 57);
        } else {
            z = Character.isJavaIdentifierPart((char) i);
        }
        if (!z) {
            _reportUnexpectedChar(i, "was expecting either valid name character (for unquoted name) or double-quote (for quoted) to start field name");
        }
        int i3 = this._inputPtr;
        int i4 = this._inputEnd;
        if (i3 < i4) {
            do {
                char c = this._inputBuffer[i3];
                if (c < length) {
                    if (inputCodeLatin1JsNames[c] != 0) {
                        int i5 = this._inputPtr - 1;
                        this._inputPtr = i3;
                        return this._symbols.findSymbol(this._inputBuffer, i5, i3 - i5, i2);
                    }
                } else if (!Character.isJavaIdentifierPart((char) c)) {
                    int i6 = this._inputPtr - 1;
                    this._inputPtr = i3;
                    return this._symbols.findSymbol(this._inputBuffer, i6, i3 - i6, i2);
                }
                i2 = (i2 * 31) + c;
                i3++;
            } while (i3 < i4);
        }
        this._inputPtr = i3;
        return _parseUnusualFieldName2(this._inputPtr - 1, i2, inputCodeLatin1JsNames);
    }

    /* access modifiers changed from: protected */
    public final String _parseApostropheFieldName() throws IOException, JsonParseException {
        int i = this._inputPtr;
        int i2 = this._inputEnd;
        int i3 = 0;
        if (i < i2) {
            int[] inputCodeLatin1 = CharTypes.getInputCodeLatin1();
            int length = inputCodeLatin1.length;
            do {
                char c = this._inputBuffer[i];
                if (c != '\'') {
                    if (c < length && inputCodeLatin1[c] != 0) {
                        break;
                    }
                    i3 = (i3 * 31) + c;
                    i++;
                } else {
                    int i4 = this._inputPtr;
                    this._inputPtr = i + 1;
                    return this._symbols.findSymbol(this._inputBuffer, i4, i - i4, i3);
                }
            } while (i < i2);
        }
        int i5 = this._inputPtr;
        this._inputPtr = i;
        return _parseFieldName2(i5, i3, 39);
    }

    /* access modifiers changed from: protected */
    public final JsonToken _handleUnexpectedValue(int i) throws IOException, JsonParseException {
        if (i != 39) {
            if (i == 43) {
                if (this._inputPtr >= this._inputEnd && !loadMore()) {
                    _reportInvalidEOFInValue();
                }
                char[] cArr = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                return _handleInvalidNumberStart(cArr[i2], false);
            } else if (i == 78) {
                if (_matchToken("NaN", 1)) {
                    if (isEnabled(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)) {
                        return resetAsNaN("NaN", Double.NaN);
                    }
                    _reportError("Non-standard token 'NaN': enable JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS to allow");
                }
                char[] cArr2 = this._inputBuffer;
                int i3 = this._inputPtr;
                this._inputPtr = i3 + 1;
                _reportUnexpectedChar(cArr2[i3], "expected 'NaN' or a valid value");
            }
        } else if (isEnabled(JsonParser.Feature.ALLOW_SINGLE_QUOTES)) {
            return _handleApostropheValue();
        }
        _reportUnexpectedChar(i, "expected a valid value (number, String, array, object, 'true', 'false' or 'null')");
        return null;
    }

    /* access modifiers changed from: protected */
    public final JsonToken _handleApostropheValue() throws IOException, JsonParseException {
        char[] emptyAndGetCurrentSegment = this._textBuffer.emptyAndGetCurrentSegment();
        int currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(": was expecting closing quote for a string value");
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    c = _decodeEscaped();
                } else if (c <= '\'') {
                    if (c == '\'') {
                        this._textBuffer.setCurrentLength(currentSegmentSize);
                        return JsonToken.VALUE_STRING;
                    } else if (c < ' ') {
                        _throwUnquotedSpace(c, "string value");
                    }
                }
            }
            if (currentSegmentSize >= emptyAndGetCurrentSegment.length) {
                emptyAndGetCurrentSegment = this._textBuffer.finishCurrentSegment();
                currentSegmentSize = 0;
            }
            emptyAndGetCurrentSegment[currentSegmentSize] = c;
            currentSegmentSize++;
        }
    }

    private String _parseUnusualFieldName2(int i, int i2, int[] iArr) throws IOException, JsonParseException {
        this._textBuffer.resetWithShared(this._inputBuffer, i, this._inputPtr - i);
        char[] currentSegment = this._textBuffer.getCurrentSegment();
        int currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
        int length = iArr.length;
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                break;
            }
            char c = this._inputBuffer[this._inputPtr];
            if (c > length) {
                if (!Character.isJavaIdentifierPart(c)) {
                    break;
                }
            } else if (iArr[c] != 0) {
                break;
            }
            this._inputPtr++;
            i2 = (i2 * 31) + c;
            int i3 = currentSegmentSize + 1;
            currentSegment[currentSegmentSize] = c;
            if (i3 >= currentSegment.length) {
                currentSegment = this._textBuffer.finishCurrentSegment();
                currentSegmentSize = 0;
            } else {
                currentSegmentSize = i3;
            }
        }
        this._textBuffer.setCurrentLength(currentSegmentSize);
        TextBuffer textBuffer = this._textBuffer;
        return this._symbols.findSymbol(textBuffer.getTextBuffer(), textBuffer.getTextOffset(), textBuffer.size(), i2);
    }

    /* access modifiers changed from: protected */
    public void _finishString() throws IOException, JsonParseException {
        int i = this._inputPtr;
        int i2 = this._inputEnd;
        if (i < i2) {
            int[] inputCodeLatin1 = CharTypes.getInputCodeLatin1();
            int length = inputCodeLatin1.length;
            while (true) {
                char c = this._inputBuffer[i];
                if (c >= length || inputCodeLatin1[c] == 0) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                } else if (c == '\"') {
                    this._textBuffer.resetWithShared(this._inputBuffer, this._inputPtr, i - this._inputPtr);
                    this._inputPtr = i + 1;
                    return;
                }
            }
        }
        this._textBuffer.resetWithCopy(this._inputBuffer, this._inputPtr, i - this._inputPtr);
        this._inputPtr = i;
        _finishString2();
    }

    /* access modifiers changed from: protected */
    public void _finishString2() throws IOException, JsonParseException {
        char[] currentSegment = this._textBuffer.getCurrentSegment();
        int currentSegmentSize = this._textBuffer.getCurrentSegmentSize();
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(": was expecting closing quote for a string value");
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    c = _decodeEscaped();
                } else if (c <= '\"') {
                    if (c == '\"') {
                        this._textBuffer.setCurrentLength(currentSegmentSize);
                        return;
                    } else if (c < ' ') {
                        _throwUnquotedSpace(c, "string value");
                    }
                }
            }
            if (currentSegmentSize >= currentSegment.length) {
                currentSegment = this._textBuffer.finishCurrentSegment();
                currentSegmentSize = 0;
            }
            currentSegment[currentSegmentSize] = c;
            currentSegmentSize++;
        }
    }

    /* access modifiers changed from: protected */
    public void _skipString() throws IOException, JsonParseException {
        this._tokenIncomplete = false;
        int i = this._inputPtr;
        int i2 = this._inputEnd;
        char[] cArr = this._inputBuffer;
        while (true) {
            if (i >= i2) {
                this._inputPtr = i;
                if (!loadMore()) {
                    _reportInvalidEOF(": was expecting closing quote for a string value");
                }
                i = this._inputPtr;
                i2 = this._inputEnd;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c <= '\\') {
                if (c == '\\') {
                    this._inputPtr = i3;
                    _decodeEscaped();
                    i = this._inputPtr;
                    i2 = this._inputEnd;
                } else if (c <= '\"') {
                    if (c == '\"') {
                        this._inputPtr = i3;
                        return;
                    } else if (c < ' ') {
                        this._inputPtr = i3;
                        _throwUnquotedSpace(c, "string value");
                    }
                }
            }
            i = i3;
        }
    }

    /* access modifiers changed from: protected */
    public void _matchToken(JsonToken jsonToken) throws IOException, JsonParseException {
        String asString = jsonToken.asString();
        int length = asString.length();
        for (int i = 1; i < length; i++) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(" in a value");
            }
            if (this._inputBuffer[this._inputPtr] != asString.charAt(i)) {
                _reportInvalidToken(asString.substring(0, i), "'null', 'true' or 'false'");
            }
            this._inputPtr++;
        }
    }

    /* access modifiers changed from: protected */
    public final void _skipCR() throws IOException {
        if ((this._inputPtr < this._inputEnd || loadMore()) && this._inputBuffer[this._inputPtr] == 10) {
            this._inputPtr++;
        }
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    /* access modifiers changed from: protected */
    public final void _skipLF() throws IOException {
        this._currInputRow++;
        this._currInputRowStart = this._inputPtr;
    }

    private final int _skipWS() throws IOException, JsonParseException {
        while (true) {
            if (this._inputPtr < this._inputEnd || loadMore()) {
                char[] cArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                char c = cArr[i];
                if (c > ' ') {
                    if (c != '/') {
                        return c;
                    }
                    _skipComment();
                } else if (c != ' ') {
                    if (c == 10) {
                        _skipLF();
                    } else if (c == 13) {
                        _skipCR();
                    } else if (c != 9) {
                        _throwInvalidSpace(c);
                    }
                }
            } else {
                throw _constructError("Unexpected end-of-input within/between " + this._parsingContext.getTypeDesc() + " entries");
            }
        }
    }

    private final int _skipWSOrEnd() throws IOException, JsonParseException {
        while (true) {
            if (this._inputPtr < this._inputEnd || loadMore()) {
                char[] cArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                char c = cArr[i];
                if (c > ' ') {
                    if (c != '/') {
                        return c;
                    }
                    _skipComment();
                } else if (c != ' ') {
                    if (c == 10) {
                        _skipLF();
                    } else if (c == 13) {
                        _skipCR();
                    } else if (c != 9) {
                        _throwInvalidSpace(c);
                    }
                }
            } else {
                _handleEOF();
                return -1;
            }
        }
    }

    private final void _skipComment() throws IOException, JsonParseException {
        if (!isEnabled(JsonParser.Feature.ALLOW_COMMENTS)) {
            _reportUnexpectedChar(47, "maybe a (non-standard) comment? (not recognized as one since Feature 'ALLOW_COMMENTS' not enabled for parser)");
        }
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(" in a comment");
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        char c = cArr[i];
        if (c == '/') {
            _skipCppComment();
        } else if (c == '*') {
            _skipCComment();
        } else {
            _reportUnexpectedChar(c, "was expecting either '*' or '/' for a comment");
        }
    }

    private final void _skipCComment() throws IOException, JsonParseException {
        while (true) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                break;
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = cArr[i];
            if (c <= '*') {
                if (c == '*') {
                    if (this._inputPtr >= this._inputEnd && !loadMore()) {
                        break;
                    } else if (this._inputBuffer[this._inputPtr] == '/') {
                        this._inputPtr++;
                        return;
                    }
                } else if (c < ' ') {
                    if (c == 10) {
                        _skipLF();
                    } else if (c == 13) {
                        _skipCR();
                    } else if (c != 9) {
                        _throwInvalidSpace(c);
                    }
                }
            }
        }
        _reportInvalidEOF(" in a comment");
    }

    private final void _skipCppComment() throws IOException, JsonParseException {
        while (true) {
            if (this._inputPtr < this._inputEnd || loadMore()) {
                char[] cArr = this._inputBuffer;
                int i = this._inputPtr;
                this._inputPtr = i + 1;
                char c = cArr[i];
                if (c < ' ') {
                    if (c == 10) {
                        _skipLF();
                        return;
                    } else if (c == 13) {
                        _skipCR();
                        return;
                    } else if (c != 9) {
                        _throwInvalidSpace(c);
                    }
                }
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final char _decodeEscaped() throws IOException, JsonParseException {
        if (this._inputPtr >= this._inputEnd && !loadMore()) {
            _reportInvalidEOF(" in character escape sequence");
        }
        char[] cArr = this._inputBuffer;
        int i = this._inputPtr;
        this._inputPtr = i + 1;
        char c = cArr[i];
        if (c == '\"' || c == '/' || c == '\\') {
            return c;
        }
        if (c == 'b') {
            return 8;
        }
        if (c == 'f') {
            return 12;
        }
        if (c == 'n') {
            return 10;
        }
        if (c == 'r') {
            return 13;
        }
        if (c == 't') {
            return 9;
        }
        if (c != 'u') {
            return _handleUnrecognizedCharacterEscape(c);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            if (this._inputPtr >= this._inputEnd && !loadMore()) {
                _reportInvalidEOF(" in character escape sequence");
            }
            char[] cArr2 = this._inputBuffer;
            int i4 = this._inputPtr;
            this._inputPtr = i4 + 1;
            char c2 = cArr2[i4];
            int charToHex = CharTypes.charToHex(c2);
            if (charToHex < 0) {
                _reportUnexpectedChar(c2, "expected a hex-digit for character escape sequence");
            }
            i2 = (i2 << 4) | charToHex;
        }
        return (char) i2;
    }

    /* access modifiers changed from: protected */
    public byte[] _decodeBase64(Base64Variant base64Variant) throws IOException, JsonParseException {
        ByteArrayBuilder _getByteArrayBuilder = _getByteArrayBuilder();
        while (true) {
            if (this._inputPtr >= this._inputEnd) {
                loadMoreGuaranteed();
            }
            char[] cArr = this._inputBuffer;
            int i = this._inputPtr;
            this._inputPtr = i + 1;
            char c = cArr[i];
            if (c > ' ') {
                int decodeBase64Char = base64Variant.decodeBase64Char(c);
                if (decodeBase64Char < 0) {
                    if (c == '\"') {
                        return _getByteArrayBuilder.toByteArray();
                    }
                    decodeBase64Char = _decodeBase64Escape(base64Variant, c, 0);
                    if (decodeBase64Char < 0) {
                        continue;
                    }
                }
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr2 = this._inputBuffer;
                int i2 = this._inputPtr;
                this._inputPtr = i2 + 1;
                char c2 = cArr2[i2];
                int decodeBase64Char2 = base64Variant.decodeBase64Char(c2);
                if (decodeBase64Char2 < 0) {
                    decodeBase64Char2 = _decodeBase64Escape(base64Variant, c2, 1);
                }
                int i3 = (decodeBase64Char << 6) | decodeBase64Char2;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr3 = this._inputBuffer;
                int i4 = this._inputPtr;
                this._inputPtr = i4 + 1;
                char c3 = cArr3[i4];
                int decodeBase64Char3 = base64Variant.decodeBase64Char(c3);
                if (decodeBase64Char3 < 0) {
                    if (decodeBase64Char3 != -2) {
                        if (c3 != '\"' || base64Variant.usesPadding()) {
                            decodeBase64Char3 = _decodeBase64Escape(base64Variant, c3, 2);
                        } else {
                            _getByteArrayBuilder.append(i3 >> 4);
                            return _getByteArrayBuilder.toByteArray();
                        }
                    }
                    if (decodeBase64Char3 == -2) {
                        if (this._inputPtr >= this._inputEnd) {
                            loadMoreGuaranteed();
                        }
                        char[] cArr4 = this._inputBuffer;
                        int i5 = this._inputPtr;
                        this._inputPtr = i5 + 1;
                        char c4 = cArr4[i5];
                        if (base64Variant.usesPaddingChar(c4)) {
                            _getByteArrayBuilder.append(i3 >> 4);
                        } else {
                            throw reportInvalidChar(base64Variant, c4, 3, "expected padding character '" + base64Variant.getPaddingChar() + "'");
                        }
                    }
                }
                int i6 = (i3 << 6) | decodeBase64Char3;
                if (this._inputPtr >= this._inputEnd) {
                    loadMoreGuaranteed();
                }
                char[] cArr5 = this._inputBuffer;
                int i7 = this._inputPtr;
                this._inputPtr = i7 + 1;
                char c5 = cArr5[i7];
                int decodeBase64Char4 = base64Variant.decodeBase64Char(c5);
                if (decodeBase64Char4 < 0) {
                    if (decodeBase64Char4 != -2) {
                        if (c5 != '\"' || base64Variant.usesPadding()) {
                            decodeBase64Char4 = _decodeBase64Escape(base64Variant, c5, 3);
                        } else {
                            _getByteArrayBuilder.appendTwoBytes(i6 >> 2);
                            return _getByteArrayBuilder.toByteArray();
                        }
                    }
                    if (decodeBase64Char4 == -2) {
                        _getByteArrayBuilder.appendTwoBytes(i6 >> 2);
                    }
                }
                _getByteArrayBuilder.appendThreeBytes((i6 << 6) | decodeBase64Char4);
            }
        }
    }

    private final int _decodeBase64Escape(Base64Variant base64Variant, char c, int i) throws IOException, JsonParseException {
        if (c == '\\') {
            char _decodeEscaped = _decodeEscaped();
            if (_decodeEscaped <= ' ' && i == 0) {
                return -1;
            }
            int decodeBase64Char = base64Variant.decodeBase64Char(_decodeEscaped);
            if (decodeBase64Char >= 0) {
                return decodeBase64Char;
            }
            throw reportInvalidChar(base64Variant, _decodeEscaped, i);
        }
        throw reportInvalidChar(base64Variant, c, i);
    }

    /* access modifiers changed from: protected */
    public IllegalArgumentException reportInvalidChar(Base64Variant base64Variant, char c, int i) throws IllegalArgumentException {
        return reportInvalidChar(base64Variant, c, i, (String) null);
    }

    /* access modifiers changed from: protected */
    public IllegalArgumentException reportInvalidChar(Base64Variant base64Variant, char c, int i, String str) throws IllegalArgumentException {
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
        return new IllegalArgumentException(str2);
    }
}
