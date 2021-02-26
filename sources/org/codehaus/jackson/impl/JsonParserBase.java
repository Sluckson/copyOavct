package org.codehaus.jackson.impl;

import java.io.IOException;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonLocation;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.Version;
import org.codehaus.jackson.p063io.IOContext;
import org.codehaus.jackson.util.ByteArrayBuilder;
import org.codehaus.jackson.util.TextBuffer;
import org.codehaus.jackson.util.VersionUtil;

public abstract class JsonParserBase extends JsonParserMinimalBase {
    protected byte[] _binaryValue;
    protected ByteArrayBuilder _byteArrayBuilder = null;
    protected boolean _closed;
    protected long _currInputProcessed = 0;
    protected int _currInputRow = 1;
    protected int _currInputRowStart = 0;
    protected int _inputEnd = 0;
    protected int _inputPtr = 0;
    protected final IOContext _ioContext;
    protected boolean _nameCopied = false;
    protected char[] _nameCopyBuffer = null;
    protected JsonToken _nextToken;
    protected JsonReadContext _parsingContext;
    protected final TextBuffer _textBuffer;
    protected int _tokenInputCol = 0;
    protected int _tokenInputRow = 1;
    protected long _tokenInputTotal = 0;

    /* access modifiers changed from: protected */
    public abstract void _closeInput() throws IOException;

    /* access modifiers changed from: protected */
    public abstract byte[] _decodeBase64(Base64Variant base64Variant) throws IOException, JsonParseException;

    /* access modifiers changed from: protected */
    public abstract void _finishString() throws IOException, JsonParseException;

    /* access modifiers changed from: protected */
    public abstract boolean loadMore() throws IOException;

    protected JsonParserBase(IOContext iOContext, int i) {
        this._features = i;
        this._ioContext = iOContext;
        this._textBuffer = iOContext.constructTextBuffer();
        this._parsingContext = JsonReadContext.createRootContext(this._tokenInputRow, this._tokenInputCol);
    }

    public Version version() {
        return VersionUtil.versionFor(getClass());
    }

    public String getCurrentName() throws IOException, JsonParseException {
        if (this._currToken == JsonToken.START_OBJECT || this._currToken == JsonToken.START_ARRAY) {
            return this._parsingContext.getParent().getCurrentName();
        }
        return this._parsingContext.getCurrentName();
    }

    public void close() throws IOException {
        if (!this._closed) {
            this._closed = true;
            try {
                _closeInput();
            } finally {
                _releaseBuffers();
            }
        }
    }

    public boolean isClosed() {
        return this._closed;
    }

    public JsonReadContext getParsingContext() {
        return this._parsingContext;
    }

    public JsonLocation getTokenLocation() {
        return new JsonLocation(this._ioContext.getSourceReference(), getTokenCharacterOffset(), getTokenLineNr(), getTokenColumnNr());
    }

    public JsonLocation getCurrentLocation() {
        return new JsonLocation(this._ioContext.getSourceReference(), (this._currInputProcessed + ((long) this._inputPtr)) - 1, this._currInputRow, (this._inputPtr - this._currInputRowStart) + 1);
    }

    /* renamed from: org.codehaus.jackson.impl.JsonParserBase$1 */
    static /* synthetic */ class C49071 {
        static final /* synthetic */ int[] $SwitchMap$org$codehaus$jackson$JsonToken = new int[JsonToken.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
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
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.impl.JsonParserBase.C49071.<clinit>():void");
        }
    }

    public boolean hasTextCharacters() {
        if (this._currToken == null) {
            return false;
        }
        int i = C49071.$SwitchMap$org$codehaus$jackson$JsonToken[this._currToken.ordinal()];
        if (i == 1) {
            return this._nameCopied;
        }
        if (i != 2) {
            return false;
        }
        return true;
    }

    public final long getTokenCharacterOffset() {
        return this._tokenInputTotal;
    }

    public final int getTokenLineNr() {
        return this._tokenInputRow;
    }

    public final int getTokenColumnNr() {
        return this._tokenInputCol + 1;
    }

    /* access modifiers changed from: protected */
    public final void loadMoreGuaranteed() throws IOException {
        if (!loadMore()) {
            _reportInvalidEOF();
        }
    }

    /* access modifiers changed from: protected */
    public void _releaseBuffers() throws IOException {
        this._textBuffer.releaseBuffers();
        char[] cArr = this._nameCopyBuffer;
        if (cArr != null) {
            this._nameCopyBuffer = null;
            this._ioContext.releaseNameCopyBuffer(cArr);
        }
    }

    /* access modifiers changed from: protected */
    public void _handleEOF() throws JsonParseException {
        if (!this._parsingContext.inRoot()) {
            _reportInvalidEOF(": expected close marker for " + this._parsingContext.getTypeDesc() + " (from " + this._parsingContext.getStartLocation(this._ioContext.getSourceReference()) + ")");
        }
    }

    /* access modifiers changed from: protected */
    public void _reportMismatchedEndMarker(int i, char c) throws JsonParseException {
        _reportError("Unexpected close marker '" + ((char) i) + "': expected '" + c + "' (for " + this._parsingContext.getTypeDesc() + " starting at " + ("" + this._parsingContext.getStartLocation(this._ioContext.getSourceReference())) + ")");
    }

    public ByteArrayBuilder _getByteArrayBuilder() {
        ByteArrayBuilder byteArrayBuilder = this._byteArrayBuilder;
        if (byteArrayBuilder == null) {
            this._byteArrayBuilder = new ByteArrayBuilder();
        } else {
            byteArrayBuilder.reset();
        }
        return this._byteArrayBuilder;
    }
}
