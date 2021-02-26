package org.codehaus.jackson.impl;

import com.lowagie.text.pdf.Barcode128;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.text.Typography;
import org.codehaus.jackson.Base64Variant;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.ObjectCodec;
import org.codehaus.jackson.SerializableString;
import org.codehaus.jackson.p063io.CharacterEscapes;
import org.codehaus.jackson.p063io.IOContext;
import org.codehaus.jackson.p063io.NumberOutput;
import org.codehaus.jackson.p063io.SerializedString;
import org.codehaus.jackson.util.CharTypes;

public final class WriterBasedGenerator extends JsonGeneratorBase {
    protected static final char[] HEX_CHARS = CharTypes.copyHexChars();
    protected static final int SHORT_WRITE = 32;
    protected static final int[] sOutputEscapes = CharTypes.get7BitOutputEscapes();
    protected CharacterEscapes _characterEscapes;
    protected SerializableString _currentEscape;
    protected char[] _entityBuffer;
    protected final IOContext _ioContext;
    protected int _maximumNonEscapedChar;
    protected char[] _outputBuffer;
    protected int _outputEnd;
    protected int[] _outputEscapes = sOutputEscapes;
    protected int _outputHead = 0;
    protected int _outputTail = 0;
    protected final Writer _writer;

    public WriterBasedGenerator(IOContext iOContext, int i, ObjectCodec objectCodec, Writer writer) {
        super(i, objectCodec);
        this._ioContext = iOContext;
        this._writer = writer;
        this._outputBuffer = iOContext.allocConcatBuffer();
        this._outputEnd = this._outputBuffer.length;
        if (isEnabled(JsonGenerator.Feature.ESCAPE_NON_ASCII)) {
            setHighestNonEscapedChar(127);
        }
    }

    public JsonGenerator setHighestNonEscapedChar(int i) {
        if (i < 0) {
            i = 0;
        }
        this._maximumNonEscapedChar = i;
        return this;
    }

    public int getHighestEscapedChar() {
        return this._maximumNonEscapedChar;
    }

    public JsonGenerator setCharacterEscapes(CharacterEscapes characterEscapes) {
        this._characterEscapes = characterEscapes;
        if (characterEscapes == null) {
            this._outputEscapes = sOutputEscapes;
        } else {
            this._outputEscapes = characterEscapes.getEscapeCodesForAscii();
        }
        return this;
    }

    public CharacterEscapes getCharacterEscapes() {
        return this._characterEscapes;
    }

    public Object getOutputTarget() {
        return this._writer;
    }

    public final void writeFieldName(String str) throws IOException, JsonGenerationException {
        int writeFieldName = this._writeContext.writeFieldName(str);
        if (writeFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        boolean z = true;
        if (writeFieldName != 1) {
            z = false;
        }
        _writeFieldName(str, z);
    }

    public final void writeStringField(String str, String str2) throws IOException, JsonGenerationException {
        writeFieldName(str);
        writeString(str2);
    }

    public final void writeFieldName(SerializedString serializedString) throws IOException, JsonGenerationException {
        int writeFieldName = this._writeContext.writeFieldName(serializedString.getValue());
        if (writeFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        boolean z = true;
        if (writeFieldName != 1) {
            z = false;
        }
        _writeFieldName((SerializableString) serializedString, z);
    }

    public final void writeFieldName(SerializableString serializableString) throws IOException, JsonGenerationException {
        int writeFieldName = this._writeContext.writeFieldName(serializableString.getValue());
        if (writeFieldName == 4) {
            _reportError("Can not write a field name, expecting a value");
        }
        boolean z = true;
        if (writeFieldName != 1) {
            z = false;
        }
        _writeFieldName(serializableString, z);
    }

    public final void writeStartArray() throws IOException, JsonGenerationException {
        _verifyValueWrite("start an array");
        this._writeContext = this._writeContext.createChildArrayContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartArray(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = '[';
    }

    public final void writeEndArray() throws IOException, JsonGenerationException {
        if (!this._writeContext.inArray()) {
            _reportError("Current context not an ARRAY but " + this._writeContext.getTypeDesc());
        }
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeEndArray(this, this._writeContext.getEntryCount());
        } else {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            cArr[i] = ']';
        }
        this._writeContext = this._writeContext.getParent();
    }

    public final void writeStartObject() throws IOException, JsonGenerationException {
        _verifyValueWrite("start an object");
        this._writeContext = this._writeContext.createChildObjectContext();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeStartObject(this);
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = '{';
    }

    public final void writeEndObject() throws IOException, JsonGenerationException {
        if (!this._writeContext.inObject()) {
            _reportError("Current context not an object but " + this._writeContext.getTypeDesc());
        }
        this._writeContext = this._writeContext.getParent();
        if (this._cfgPrettyPrinter != null) {
            this._cfgPrettyPrinter.writeEndObject(this, this._writeContext.getEntryCount());
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = '}';
    }

    /* access modifiers changed from: protected */
    public void _writeFieldName(String str, boolean z) throws IOException, JsonGenerationException {
        if (this._cfgPrettyPrinter != null) {
            _writePPFieldName(str, z);
            return;
        }
        if (this._outputTail + 1 >= this._outputEnd) {
            _flushBuffer();
        }
        if (z) {
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            cArr[i] = ',';
        }
        if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            _writeString(str);
            return;
        }
        char[] cArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        cArr2[i2] = Typography.quote;
        _writeString(str);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr3 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        cArr3[i3] = Typography.quote;
    }

    public void _writeFieldName(SerializableString serializableString, boolean z) throws IOException, JsonGenerationException {
        if (this._cfgPrettyPrinter != null) {
            _writePPFieldName(serializableString, z);
            return;
        }
        if (this._outputTail + 1 >= this._outputEnd) {
            _flushBuffer();
        }
        if (z) {
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            cArr[i] = ',';
        }
        char[] asQuotedChars = serializableString.asQuotedChars();
        if (!isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            writeRaw(asQuotedChars, 0, asQuotedChars.length);
            return;
        }
        char[] cArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        cArr2[i2] = Typography.quote;
        int length = asQuotedChars.length;
        int i3 = this._outputTail;
        if (i3 + length + 1 >= this._outputEnd) {
            writeRaw(asQuotedChars, 0, length);
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr3 = this._outputBuffer;
            int i4 = this._outputTail;
            this._outputTail = i4 + 1;
            cArr3[i4] = Typography.quote;
            return;
        }
        System.arraycopy(asQuotedChars, 0, cArr2, i3, length);
        this._outputTail += length;
        char[] cArr4 = this._outputBuffer;
        int i5 = this._outputTail;
        this._outputTail = i5 + 1;
        cArr4[i5] = Typography.quote;
    }

    /* access modifiers changed from: protected */
    public final void _writePPFieldName(String str, boolean z) throws IOException, JsonGenerationException {
        if (z) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        if (isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            cArr[i] = Typography.quote;
            _writeString(str);
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr2 = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            cArr2[i2] = Typography.quote;
            return;
        }
        _writeString(str);
    }

    /* access modifiers changed from: protected */
    public final void _writePPFieldName(SerializableString serializableString, boolean z) throws IOException, JsonGenerationException {
        if (z) {
            this._cfgPrettyPrinter.writeObjectEntrySeparator(this);
        } else {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
        char[] asQuotedChars = serializableString.asQuotedChars();
        if (isEnabled(JsonGenerator.Feature.QUOTE_FIELD_NAMES)) {
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            this._outputTail = i + 1;
            cArr[i] = Typography.quote;
            writeRaw(asQuotedChars, 0, asQuotedChars.length);
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr2 = this._outputBuffer;
            int i2 = this._outputTail;
            this._outputTail = i2 + 1;
            cArr2[i2] = Typography.quote;
            return;
        }
        writeRaw(asQuotedChars, 0, asQuotedChars.length);
    }

    public void writeString(String str) throws IOException, JsonGenerationException {
        _verifyValueWrite("write text value");
        if (str == null) {
            _writeNull();
            return;
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = Typography.quote;
        _writeString(str);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        cArr2[i2] = Typography.quote;
    }

    public void writeString(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        cArr2[i3] = Typography.quote;
        _writeString(cArr, i, i2);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr3 = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        cArr3[i4] = Typography.quote;
    }

    public final void writeString(SerializableString serializableString) throws IOException, JsonGenerationException {
        _verifyValueWrite("write text value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = Typography.quote;
        char[] asQuotedChars = serializableString.asQuotedChars();
        int length = asQuotedChars.length;
        if (length < 32) {
            if (length > this._outputEnd - this._outputTail) {
                _flushBuffer();
            }
            System.arraycopy(asQuotedChars, 0, this._outputBuffer, this._outputTail, length);
            this._outputTail += length;
        } else {
            _flushBuffer();
            this._writer.write(asQuotedChars, 0, length);
        }
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        cArr2[i2] = Typography.quote;
    }

    public void writeRawUTF8String(byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        _reportUnsupportedOperation();
    }

    public void writeUTF8String(byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        _reportUnsupportedOperation();
    }

    public void writeRaw(String str) throws IOException, JsonGenerationException {
        int length = str.length();
        int i = this._outputEnd - this._outputTail;
        if (i == 0) {
            _flushBuffer();
            i = this._outputEnd - this._outputTail;
        }
        if (i >= length) {
            str.getChars(0, length, this._outputBuffer, this._outputTail);
            this._outputTail += length;
            return;
        }
        writeRawLong(str);
    }

    public void writeRaw(String str, int i, int i2) throws IOException, JsonGenerationException {
        int i3 = this._outputEnd - this._outputTail;
        if (i3 < i2) {
            _flushBuffer();
            i3 = this._outputEnd - this._outputTail;
        }
        if (i3 >= i2) {
            str.getChars(i, i + i2, this._outputBuffer, this._outputTail);
            this._outputTail += i2;
            return;
        }
        writeRawLong(str.substring(i, i2 + i));
    }

    public void writeRaw(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        if (i2 < 32) {
            if (i2 > this._outputEnd - this._outputTail) {
                _flushBuffer();
            }
            System.arraycopy(cArr, i, this._outputBuffer, this._outputTail, i2);
            this._outputTail += i2;
            return;
        }
        _flushBuffer();
        this._writer.write(cArr, i, i2);
    }

    public void writeRaw(char c) throws IOException, JsonGenerationException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = c;
    }

    private void writeRawLong(String str) throws IOException, JsonGenerationException {
        int i = this._outputEnd;
        int i2 = this._outputTail;
        int i3 = i - i2;
        str.getChars(0, i3, this._outputBuffer, i2);
        this._outputTail += i3;
        _flushBuffer();
        int length = str.length() - i3;
        while (true) {
            int i4 = this._outputEnd;
            if (length > i4) {
                int i5 = i3 + i4;
                str.getChars(i3, i5, this._outputBuffer, 0);
                this._outputHead = 0;
                this._outputTail = i4;
                _flushBuffer();
                length -= i4;
                i3 = i5;
            } else {
                str.getChars(i3, i3 + length, this._outputBuffer, 0);
                this._outputHead = 0;
                this._outputTail = length;
                return;
            }
        }
    }

    public void writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        _verifyValueWrite("write binary value");
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        cArr[i3] = Typography.quote;
        _writeBinary(base64Variant, bArr, i, i2 + i);
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i4 = this._outputTail;
        this._outputTail = i4 + 1;
        cArr2[i4] = Typography.quote;
    }

    public void writeNumber(int i) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (this._outputTail + 11 >= this._outputEnd) {
            _flushBuffer();
        }
        if (this._cfgNumbersAsStrings) {
            _writeQuotedInt(i);
        } else {
            this._outputTail = NumberOutput.outputInt(i, this._outputBuffer, this._outputTail);
        }
    }

    private final void _writeQuotedInt(int i) throws IOException {
        if (this._outputTail + 13 >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        cArr[i2] = Typography.quote;
        this._outputTail = NumberOutput.outputInt(i, cArr, this._outputTail);
        char[] cArr2 = this._outputBuffer;
        int i3 = this._outputTail;
        this._outputTail = i3 + 1;
        cArr2[i3] = Typography.quote;
    }

    public void writeNumber(long j) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedLong(j);
            return;
        }
        if (this._outputTail + 21 >= this._outputEnd) {
            _flushBuffer();
        }
        this._outputTail = NumberOutput.outputLong(j, this._outputBuffer, this._outputTail);
    }

    private final void _writeQuotedLong(long j) throws IOException {
        if (this._outputTail + 23 >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = Typography.quote;
        this._outputTail = NumberOutput.outputLong(j, cArr, this._outputTail);
        char[] cArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        cArr2[i2] = Typography.quote;
    }

    public void writeNumber(BigInteger bigInteger) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (bigInteger == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(bigInteger);
        } else {
            writeRaw(bigInteger.toString());
        }
    }

    public void writeNumber(double d) throws IOException, JsonGenerationException {
        if (this._cfgNumbersAsStrings || ((Double.isNaN(d) || Double.isInfinite(d)) && isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            writeString(String.valueOf(d));
            return;
        }
        _verifyValueWrite("write number");
        writeRaw(String.valueOf(d));
    }

    public void writeNumber(float f) throws IOException, JsonGenerationException {
        if (this._cfgNumbersAsStrings || ((Float.isNaN(f) || Float.isInfinite(f)) && isEnabled(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS))) {
            writeString(String.valueOf(f));
            return;
        }
        _verifyValueWrite("write number");
        writeRaw(String.valueOf(f));
    }

    public void writeNumber(BigDecimal bigDecimal) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (bigDecimal == null) {
            _writeNull();
        } else if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(bigDecimal);
        } else {
            writeRaw(bigDecimal.toString());
        }
    }

    public void writeNumber(String str) throws IOException, JsonGenerationException {
        _verifyValueWrite("write number");
        if (this._cfgNumbersAsStrings) {
            _writeQuotedRaw(str);
        } else {
            writeRaw(str);
        }
    }

    private final void _writeQuotedRaw(Object obj) throws IOException {
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr = this._outputBuffer;
        int i = this._outputTail;
        this._outputTail = i + 1;
        cArr[i] = Typography.quote;
        writeRaw(obj.toString());
        if (this._outputTail >= this._outputEnd) {
            _flushBuffer();
        }
        char[] cArr2 = this._outputBuffer;
        int i2 = this._outputTail;
        this._outputTail = i2 + 1;
        cArr2[i2] = Typography.quote;
    }

    public void writeBoolean(boolean z) throws IOException, JsonGenerationException {
        int i;
        _verifyValueWrite("write boolean value");
        if (this._outputTail + 5 >= this._outputEnd) {
            _flushBuffer();
        }
        int i2 = this._outputTail;
        char[] cArr = this._outputBuffer;
        if (z) {
            cArr[i2] = 't';
            int i3 = i2 + 1;
            cArr[i3] = 'r';
            int i4 = i3 + 1;
            cArr[i4] = 'u';
            i = i4 + 1;
            cArr[i] = Barcode128.CODE_BC_TO_A;
        } else {
            cArr[i2] = Barcode128.FNC1_INDEX;
            int i5 = i2 + 1;
            cArr[i5] = 'a';
            int i6 = i5 + 1;
            cArr[i6] = 'l';
            int i7 = i6 + 1;
            cArr[i7] = 's';
            i = i7 + 1;
            cArr[i] = Barcode128.CODE_BC_TO_A;
        }
        this._outputTail = i + 1;
    }

    public void writeNull() throws IOException, JsonGenerationException {
        _verifyValueWrite("write null value");
        _writeNull();
    }

    /* access modifiers changed from: protected */
    public final void _verifyValueWrite(String str) throws IOException, JsonGenerationException {
        char c;
        int writeValue = this._writeContext.writeValue();
        if (writeValue == 5) {
            _reportError("Can not " + str + ", expecting field name");
        }
        if (this._cfgPrettyPrinter == null) {
            if (writeValue == 1) {
                c = ',';
            } else if (writeValue == 2) {
                c = ':';
            } else if (writeValue == 3) {
                c = ' ';
            } else {
                return;
            }
            if (this._outputTail >= this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr = this._outputBuffer;
            int i = this._outputTail;
            cArr[i] = c;
            this._outputTail = i + 1;
            return;
        }
        _verifyPrettyValueWrite(str, writeValue);
    }

    /* access modifiers changed from: protected */
    public final void _verifyPrettyValueWrite(String str, int i) throws IOException, JsonGenerationException {
        if (i != 0) {
            if (i == 1) {
                this._cfgPrettyPrinter.writeArrayValueSeparator(this);
            } else if (i == 2) {
                this._cfgPrettyPrinter.writeObjectFieldValueSeparator(this);
            } else if (i != 3) {
                _cantHappen();
            } else {
                this._cfgPrettyPrinter.writeRootValueSeparator(this);
            }
        } else if (this._writeContext.inArray()) {
            this._cfgPrettyPrinter.beforeArrayValues(this);
        } else if (this._writeContext.inObject()) {
            this._cfgPrettyPrinter.beforeObjectEntries(this);
        }
    }

    public final void flush() throws IOException {
        _flushBuffer();
        if (this._writer != null && isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
            this._writer.flush();
        }
    }

    public void close() throws IOException {
        super.close();
        if (this._outputBuffer != null && isEnabled(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT)) {
            while (true) {
                JsonWriteContext outputContext = getOutputContext();
                if (!outputContext.inArray()) {
                    if (!outputContext.inObject()) {
                        break;
                    }
                    writeEndObject();
                } else {
                    writeEndArray();
                }
            }
        }
        _flushBuffer();
        if (this._writer != null) {
            if (this._ioContext.isResourceManaged() || isEnabled(JsonGenerator.Feature.AUTO_CLOSE_TARGET)) {
                this._writer.close();
            } else if (isEnabled(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM)) {
                this._writer.flush();
            }
        }
        _releaseBuffers();
    }

    /* access modifiers changed from: protected */
    public void _releaseBuffers() {
        char[] cArr = this._outputBuffer;
        if (cArr != null) {
            this._outputBuffer = null;
            this._ioContext.releaseConcatBuffer(cArr);
        }
    }

    private void _writeString(String str) throws IOException, JsonGenerationException {
        int length = str.length();
        int i = this._outputEnd;
        if (length > i) {
            _writeLongString(str);
            return;
        }
        if (this._outputTail + length > i) {
            _flushBuffer();
        }
        str.getChars(0, length, this._outputBuffer, this._outputTail);
        if (this._characterEscapes != null) {
            _writeStringCustom(length);
            return;
        }
        int i2 = this._maximumNonEscapedChar;
        if (i2 != 0) {
            _writeStringASCII(length, i2);
        } else {
            _writeString2(length);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r2 = r6._outputBuffer;
        r3 = r6._outputTail;
        r6._outputTail = r3 + 1;
        r2 = r2[r3];
        _prependOrWriteCharacterEscape(r2, r7[r2]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0016, code lost:
        r4 = r6._outputHead;
        r3 = r3 - r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if (r3 <= 0) goto L_0x0020;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r6._writer.write(r2, r4, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void _writeString2(int r7) throws java.io.IOException, org.codehaus.jackson.JsonGenerationException {
        /*
            r6 = this;
            int r0 = r6._outputTail
            int r0 = r0 + r7
            int[] r7 = r6._outputEscapes
            int r1 = r7.length
        L_0x0006:
            int r2 = r6._outputTail
            if (r2 >= r0) goto L_0x0038
        L_0x000a:
            char[] r2 = r6._outputBuffer
            int r3 = r6._outputTail
            char r4 = r2[r3]
            if (r4 >= r1) goto L_0x0030
            r4 = r7[r4]
            if (r4 == 0) goto L_0x0030
            int r4 = r6._outputHead
            int r3 = r3 - r4
            if (r3 <= 0) goto L_0x0020
            java.io.Writer r5 = r6._writer
            r5.write(r2, r4, r3)
        L_0x0020:
            char[] r2 = r6._outputBuffer
            int r3 = r6._outputTail
            int r4 = r3 + 1
            r6._outputTail = r4
            char r2 = r2[r3]
            r3 = r7[r2]
            r6._prependOrWriteCharacterEscape(r2, r3)
            goto L_0x0006
        L_0x0030:
            int r2 = r6._outputTail
            int r2 = r2 + 1
            r6._outputTail = r2
            if (r2 < r0) goto L_0x000a
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.impl.WriterBasedGenerator._writeString2(int):void");
    }

    private void _writeLongString(String str) throws IOException, JsonGenerationException {
        _flushBuffer();
        int length = str.length();
        int i = 0;
        while (true) {
            int i2 = this._outputEnd;
            if (i + i2 > length) {
                i2 = length - i;
            }
            int i3 = i + i2;
            str.getChars(i, i3, this._outputBuffer, 0);
            if (this._characterEscapes != null) {
                _writeSegmentCustom(i2);
            } else {
                int i4 = this._maximumNonEscapedChar;
                if (i4 != 0) {
                    _writeSegmentASCII(i2, i4);
                } else {
                    _writeSegment(i2);
                }
            }
            if (i3 < length) {
                i = i3;
            } else {
                return;
            }
        }
    }

    private final void _writeSegment(int i) throws IOException, JsonGenerationException {
        char c;
        int[] iArr = this._outputEscapes;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < i) {
            do {
                c = this._outputBuffer[i2];
                if ((c < length && iArr[c] != 0) || (i2 = i2 + 1) >= i) {
                    int i4 = i2 - i3;
                }
                c = this._outputBuffer[i2];
                break;
            } while ((i2 = i2 + 1) >= i);
            int i42 = i2 - i3;
            if (i42 > 0) {
                this._writer.write(this._outputBuffer, i3, i42);
                if (i2 >= i) {
                    return;
                }
            }
            i2++;
            i3 = _prependOrWriteCharacterEscape(this._outputBuffer, i2, i, c, iArr[c]);
        }
    }

    private final void _writeString(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        if (this._characterEscapes != null) {
            _writeStringCustom(cArr, i, i2);
            return;
        }
        int i3 = this._maximumNonEscapedChar;
        if (i3 != 0) {
            _writeStringASCII(cArr, i, i2, i3);
            return;
        }
        int i4 = i2 + i;
        int[] iArr = this._outputEscapes;
        int length = iArr.length;
        while (i < i4) {
            int i5 = i;
            do {
                char c = cArr[i5];
                if ((c < length && iArr[c] != 0) || (i5 = i5 + 1) >= i4) {
                    int i6 = i5 - i;
                }
                char c2 = cArr[i5];
                break;
            } while ((i5 = i5 + 1) >= i4);
            int i62 = i5 - i;
            if (i62 < 32) {
                if (this._outputTail + i62 > this._outputEnd) {
                    _flushBuffer();
                }
                if (i62 > 0) {
                    System.arraycopy(cArr, i, this._outputBuffer, this._outputTail, i62);
                    this._outputTail += i62;
                }
            } else {
                _flushBuffer();
                this._writer.write(cArr, i, i62);
            }
            if (i5 < i4) {
                i = i5 + 1;
                char c3 = cArr[i5];
                _appendCharacterEscape(c3, iArr[c3]);
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0042 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void _writeStringASCII(int r9, int r10) throws java.io.IOException, org.codehaus.jackson.JsonGenerationException {
        /*
            r8 = this;
            int r0 = r8._outputTail
            int r0 = r0 + r9
            int[] r9 = r8._outputEscapes
            int r1 = r9.length
            int r2 = r8._maximumNonEscapedChar
            int r2 = r2 + 1
            int r1 = java.lang.Math.min(r1, r2)
        L_0x000e:
            int r2 = r8._outputTail
            if (r2 >= r0) goto L_0x0042
        L_0x0012:
            char[] r2 = r8._outputBuffer
            int r3 = r8._outputTail
            char r2 = r2[r3]
            if (r2 >= r1) goto L_0x001f
            r3 = r9[r2]
            if (r3 == 0) goto L_0x003a
            goto L_0x0022
        L_0x001f:
            if (r2 <= r10) goto L_0x003a
            r3 = -1
        L_0x0022:
            int r4 = r8._outputTail
            int r5 = r8._outputHead
            int r4 = r4 - r5
            if (r4 <= 0) goto L_0x0030
            java.io.Writer r6 = r8._writer
            char[] r7 = r8._outputBuffer
            r6.write(r7, r5, r4)
        L_0x0030:
            int r4 = r8._outputTail
            int r4 = r4 + 1
            r8._outputTail = r4
            r8._prependOrWriteCharacterEscape(r2, r3)
            goto L_0x000e
        L_0x003a:
            int r2 = r8._outputTail
            int r2 = r2 + 1
            r8._outputTail = r2
            if (r2 < r0) goto L_0x0012
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.impl.WriterBasedGenerator._writeStringASCII(int, int):void");
    }

    private final void _writeSegmentASCII(int i, int i2) throws IOException, JsonGenerationException {
        char c;
        int[] iArr = this._outputEscapes;
        int min = Math.min(iArr.length, this._maximumNonEscapedChar + 1);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            while (true) {
                c = this._outputBuffer[i3];
                if (c >= min) {
                    if (c > i2) {
                        i5 = -1;
                        break;
                    }
                } else {
                    i5 = iArr[c];
                    if (i5 != 0) {
                        break;
                    }
                }
                i3++;
                if (i3 >= i) {
                    break;
                }
            }
            int i6 = i3 - i4;
            if (i6 > 0) {
                this._writer.write(this._outputBuffer, i4, i6);
                if (i3 >= i) {
                    return;
                }
            }
            i3++;
            i4 = _prependOrWriteCharacterEscape(this._outputBuffer, i3, i, c, i5);
        }
    }

    private final void _writeStringASCII(char[] cArr, int i, int i2, int i3) throws IOException, JsonGenerationException {
        char c;
        int i4 = i2 + i;
        int[] iArr = this._outputEscapes;
        int min = Math.min(iArr.length, i3 + 1);
        int i5 = 0;
        while (i < i4) {
            int i6 = i5;
            int i7 = i;
            while (true) {
                c = cArr[i7];
                if (c >= min) {
                    if (c > i3) {
                        i6 = -1;
                        break;
                    }
                } else {
                    i6 = iArr[c];
                    if (i6 != 0) {
                        break;
                    }
                }
                i7++;
                if (i7 >= i4) {
                    break;
                }
            }
            int i8 = i7 - i;
            if (i8 < 32) {
                if (this._outputTail + i8 > this._outputEnd) {
                    _flushBuffer();
                }
                if (i8 > 0) {
                    System.arraycopy(cArr, i, this._outputBuffer, this._outputTail, i8);
                    this._outputTail += i8;
                }
            } else {
                _flushBuffer();
                this._writer.write(cArr, i, i8);
            }
            if (i7 < i4) {
                i = i7 + 1;
                _appendCharacterEscape(c, i6);
                i5 = i6;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void _writeStringCustom(int r12) throws java.io.IOException, org.codehaus.jackson.JsonGenerationException {
        /*
            r11 = this;
            int r0 = r11._outputTail
            int r0 = r0 + r12
            int[] r12 = r11._outputEscapes
            int r1 = r11._maximumNonEscapedChar
            r2 = 1
            if (r1 >= r2) goto L_0x000d
            r1 = 65535(0xffff, float:9.1834E-41)
        L_0x000d:
            int r3 = r12.length
            int r4 = r1 + 1
            int r3 = java.lang.Math.min(r3, r4)
            org.codehaus.jackson.io.CharacterEscapes r4 = r11._characterEscapes
        L_0x0016:
            int r5 = r11._outputTail
            if (r5 >= r0) goto L_0x0052
        L_0x001a:
            char[] r5 = r11._outputBuffer
            int r6 = r11._outputTail
            char r5 = r5[r6]
            if (r5 >= r3) goto L_0x0027
            r6 = r12[r5]
            if (r6 == 0) goto L_0x004b
            goto L_0x0034
        L_0x0027:
            if (r5 <= r1) goto L_0x002b
            r6 = -1
            goto L_0x0034
        L_0x002b:
            org.codehaus.jackson.SerializableString r6 = r4.getEscapeSequence(r5)
            r11._currentEscape = r6
            if (r6 == 0) goto L_0x004b
            r6 = -2
        L_0x0034:
            int r7 = r11._outputTail
            int r8 = r11._outputHead
            int r7 = r7 - r8
            if (r7 <= 0) goto L_0x0042
            java.io.Writer r9 = r11._writer
            char[] r10 = r11._outputBuffer
            r9.write(r10, r8, r7)
        L_0x0042:
            int r7 = r11._outputTail
            int r7 = r7 + r2
            r11._outputTail = r7
            r11._prependOrWriteCharacterEscape(r5, r6)
            goto L_0x0016
        L_0x004b:
            int r5 = r11._outputTail
            int r5 = r5 + r2
            r11._outputTail = r5
            if (r5 < r0) goto L_0x001a
        L_0x0052:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.impl.WriterBasedGenerator._writeStringCustom(int):void");
    }

    private final void _writeSegmentCustom(int i) throws IOException, JsonGenerationException {
        char c;
        int[] iArr = this._outputEscapes;
        int i2 = this._maximumNonEscapedChar;
        if (i2 < 1) {
            i2 = 65535;
        }
        int min = Math.min(iArr.length, this._maximumNonEscapedChar + 1);
        CharacterEscapes characterEscapes = this._characterEscapes;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < i) {
            while (true) {
                c = this._outputBuffer[i3];
                if (c >= min) {
                    if (c <= i2) {
                        SerializableString escapeSequence = characterEscapes.getEscapeSequence(c);
                        this._currentEscape = escapeSequence;
                        if (escapeSequence != null) {
                            i5 = -2;
                            break;
                        }
                    } else {
                        i5 = -1;
                        break;
                    }
                } else {
                    i5 = iArr[c];
                    if (i5 != 0) {
                        break;
                    }
                }
                i3++;
                if (i3 >= i) {
                    break;
                }
            }
            int i6 = i3 - i4;
            if (i6 > 0) {
                this._writer.write(this._outputBuffer, i4, i6);
                if (i3 >= i) {
                    return;
                }
            }
            i3++;
            i4 = _prependOrWriteCharacterEscape(this._outputBuffer, i3, i, c, i5);
        }
    }

    private final void _writeStringCustom(char[] cArr, int i, int i2) throws IOException, JsonGenerationException {
        char c;
        int i3 = i2 + i;
        int[] iArr = this._outputEscapes;
        int i4 = this._maximumNonEscapedChar;
        if (i4 < 1) {
            i4 = 65535;
        }
        int min = Math.min(iArr.length, i4 + 1);
        CharacterEscapes characterEscapes = this._characterEscapes;
        int i5 = 0;
        while (i < i3) {
            int i6 = i5;
            int i7 = i;
            while (true) {
                c = cArr[i7];
                if (c >= min) {
                    if (c <= i4) {
                        SerializableString escapeSequence = characterEscapes.getEscapeSequence(c);
                        this._currentEscape = escapeSequence;
                        if (escapeSequence != null) {
                            i6 = -2;
                            break;
                        }
                    } else {
                        i6 = -1;
                        break;
                    }
                } else {
                    i6 = iArr[c];
                    if (i6 != 0) {
                        break;
                    }
                }
                i7++;
                if (i7 >= i3) {
                    break;
                }
            }
            int i8 = i7 - i;
            if (i8 < 32) {
                if (this._outputTail + i8 > this._outputEnd) {
                    _flushBuffer();
                }
                if (i8 > 0) {
                    System.arraycopy(cArr, i, this._outputBuffer, this._outputTail, i8);
                    this._outputTail += i8;
                }
            } else {
                _flushBuffer();
                this._writer.write(cArr, i, i8);
            }
            if (i7 < i3) {
                i = i7 + 1;
                _appendCharacterEscape(c, i6);
                i5 = i6;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void _writeBinary(Base64Variant base64Variant, byte[] bArr, int i, int i2) throws IOException, JsonGenerationException {
        int i3 = i2 - 3;
        int i4 = this._outputEnd - 6;
        int maxLineLength = base64Variant.getMaxLineLength() >> 2;
        while (i <= i3) {
            if (this._outputTail > i4) {
                _flushBuffer();
            }
            int i5 = i + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            this._outputTail = base64Variant.encodeBase64Chunk((int) (((bArr[i] << 8) | (bArr[i5] & 255)) << 8) | (bArr[i6] & 255), this._outputBuffer, this._outputTail);
            maxLineLength--;
            if (maxLineLength <= 0) {
                char[] cArr = this._outputBuffer;
                int i8 = this._outputTail;
                this._outputTail = i8 + 1;
                cArr[i8] = '\\';
                int i9 = this._outputTail;
                this._outputTail = i9 + 1;
                cArr[i9] = 'n';
                maxLineLength = base64Variant.getMaxLineLength() >> 2;
            }
            i = i7;
        }
        int i10 = i2 - i;
        if (i10 > 0) {
            if (this._outputTail > i4) {
                _flushBuffer();
            }
            int i11 = i + 1;
            int i12 = bArr[i] << 16;
            if (i10 == 2) {
                i12 |= (bArr[i11] & 255) << 8;
            }
            this._outputTail = base64Variant.encodeBase64Partial(i12, i10, this._outputBuffer, this._outputTail);
        }
    }

    private final void _writeNull() throws IOException {
        if (this._outputTail + 4 >= this._outputEnd) {
            _flushBuffer();
        }
        int i = this._outputTail;
        char[] cArr = this._outputBuffer;
        cArr[i] = 'n';
        int i2 = i + 1;
        cArr[i2] = 'u';
        int i3 = i2 + 1;
        cArr[i3] = 'l';
        int i4 = i3 + 1;
        cArr[i4] = 'l';
        this._outputTail = i4 + 1;
    }

    private final void _prependOrWriteCharacterEscape(char c, int i) throws IOException, JsonGenerationException {
        String str;
        int i2;
        if (i >= 0) {
            int i3 = this._outputTail;
            if (i3 >= 2) {
                int i4 = i3 - 2;
                this._outputHead = i4;
                char[] cArr = this._outputBuffer;
                cArr[i4] = '\\';
                cArr[i4 + 1] = (char) i;
                return;
            }
            char[] cArr2 = this._entityBuffer;
            if (cArr2 == null) {
                cArr2 = _allocateEntityBuffer();
            }
            this._outputHead = this._outputTail;
            cArr2[1] = (char) i;
            this._writer.write(cArr2, 0, 2);
        } else if (i != -2) {
            int i5 = this._outputTail;
            if (i5 >= 6) {
                char[] cArr3 = this._outputBuffer;
                int i6 = i5 - 6;
                this._outputHead = i6;
                cArr3[i6] = '\\';
                int i7 = i6 + 1;
                cArr3[i7] = 'u';
                if (c > 255) {
                    int i8 = (c >> 8) & 255;
                    int i9 = i7 + 1;
                    char[] cArr4 = HEX_CHARS;
                    cArr3[i9] = cArr4[i8 >> 4];
                    i2 = i9 + 1;
                    cArr3[i2] = cArr4[i8 & 15];
                    c = (char) (c & 255);
                } else {
                    int i10 = i7 + 1;
                    cArr3[i10] = '0';
                    i2 = i10 + 1;
                    cArr3[i2] = '0';
                }
                int i11 = i2 + 1;
                char[] cArr5 = HEX_CHARS;
                cArr3[i11] = cArr5[c >> 4];
                cArr3[i11 + 1] = cArr5[c & 15];
                return;
            }
            char[] cArr6 = this._entityBuffer;
            if (cArr6 == null) {
                cArr6 = _allocateEntityBuffer();
            }
            this._outputHead = this._outputTail;
            if (c > 255) {
                int i12 = (c >> 8) & 255;
                char c2 = c & 255;
                char[] cArr7 = HEX_CHARS;
                cArr6[10] = cArr7[i12 >> 4];
                cArr6[11] = cArr7[i12 & 15];
                cArr6[12] = cArr7[c2 >> 4];
                cArr6[13] = cArr7[c2 & 15];
                this._writer.write(cArr6, 8, 6);
                return;
            }
            char[] cArr8 = HEX_CHARS;
            cArr6[6] = cArr8[c >> 4];
            cArr6[7] = cArr8[c & 15];
            this._writer.write(cArr6, 2, 6);
        } else {
            SerializableString serializableString = this._currentEscape;
            if (serializableString == null) {
                str = this._characterEscapes.getEscapeSequence(c).getValue();
            } else {
                str = serializableString.getValue();
                this._currentEscape = null;
            }
            int length = str.length();
            int i13 = this._outputTail;
            if (i13 >= length) {
                int i14 = i13 - length;
                this._outputHead = i14;
                str.getChars(0, length, this._outputBuffer, i14);
                return;
            }
            this._outputHead = i13;
            this._writer.write(str);
        }
    }

    private final int _prependOrWriteCharacterEscape(char[] cArr, int i, int i2, char c, int i3) throws IOException, JsonGenerationException {
        String str;
        int i4;
        if (i3 >= 0) {
            if (i <= 1 || i >= i2) {
                char[] cArr2 = this._entityBuffer;
                if (cArr2 == null) {
                    cArr2 = _allocateEntityBuffer();
                }
                cArr2[1] = (char) i3;
                this._writer.write(cArr2, 0, 2);
                return i;
            }
            int i5 = i - 2;
            cArr[i5] = '\\';
            cArr[i5 + 1] = (char) i3;
            return i5;
        } else if (i3 == -2) {
            SerializableString serializableString = this._currentEscape;
            if (serializableString == null) {
                str = this._characterEscapes.getEscapeSequence(c).getValue();
            } else {
                str = serializableString.getValue();
                this._currentEscape = null;
            }
            int length = str.length();
            if (i < length || i >= i2) {
                this._writer.write(str);
                return i;
            }
            int i6 = i - length;
            str.getChars(0, length, cArr, i6);
            return i6;
        } else if (i <= 5 || i >= i2) {
            char[] cArr3 = this._entityBuffer;
            if (cArr3 == null) {
                cArr3 = _allocateEntityBuffer();
            }
            this._outputHead = this._outputTail;
            if (c > 255) {
                int i7 = (c >> 8) & 255;
                char c2 = c & 255;
                char[] cArr4 = HEX_CHARS;
                cArr3[10] = cArr4[i7 >> 4];
                cArr3[11] = cArr4[i7 & 15];
                cArr3[12] = cArr4[c2 >> 4];
                cArr3[13] = cArr4[c2 & 15];
                this._writer.write(cArr3, 8, 6);
                return i;
            }
            char[] cArr5 = HEX_CHARS;
            cArr3[6] = cArr5[c >> 4];
            cArr3[7] = cArr5[c & 15];
            this._writer.write(cArr3, 2, 6);
            return i;
        } else {
            int i8 = i - 6;
            int i9 = i8 + 1;
            cArr[i8] = '\\';
            int i10 = i9 + 1;
            cArr[i9] = 'u';
            if (c > 255) {
                int i11 = (c >> 8) & 255;
                int i12 = i10 + 1;
                char[] cArr6 = HEX_CHARS;
                cArr[i10] = cArr6[i11 >> 4];
                i4 = i12 + 1;
                cArr[i12] = cArr6[i11 & 15];
                c = (char) (c & 255);
            } else {
                int i13 = i10 + 1;
                cArr[i10] = '0';
                i4 = i13 + 1;
                cArr[i13] = '0';
            }
            int i14 = i4 + 1;
            char[] cArr7 = HEX_CHARS;
            cArr[i4] = cArr7[c >> 4];
            cArr[i14] = cArr7[c & 15];
            return i14 - 5;
        }
    }

    private final void _appendCharacterEscape(char c, int i) throws IOException, JsonGenerationException {
        String str;
        int i2;
        if (i >= 0) {
            if (this._outputTail + 2 > this._outputEnd) {
                _flushBuffer();
            }
            char[] cArr = this._outputBuffer;
            int i3 = this._outputTail;
            this._outputTail = i3 + 1;
            cArr[i3] = '\\';
            int i4 = this._outputTail;
            this._outputTail = i4 + 1;
            cArr[i4] = (char) i;
        } else if (i != -2) {
            if (this._outputTail + 2 > this._outputEnd) {
                _flushBuffer();
            }
            int i5 = this._outputTail;
            char[] cArr2 = this._outputBuffer;
            int i6 = i5 + 1;
            cArr2[i5] = '\\';
            int i7 = i6 + 1;
            cArr2[i6] = 'u';
            if (c > 255) {
                int i8 = 255 & (c >> 8);
                int i9 = i7 + 1;
                char[] cArr3 = HEX_CHARS;
                cArr2[i7] = cArr3[i8 >> 4];
                i2 = i9 + 1;
                cArr2[i9] = cArr3[i8 & 15];
                c = (char) (c & 255);
            } else {
                int i10 = i7 + 1;
                cArr2[i7] = '0';
                i2 = i10 + 1;
                cArr2[i10] = '0';
            }
            int i11 = i2 + 1;
            char[] cArr4 = HEX_CHARS;
            cArr2[i2] = cArr4[c >> 4];
            cArr2[i11] = cArr4[c & 15];
            this._outputTail = i11;
        } else {
            SerializableString serializableString = this._currentEscape;
            if (serializableString == null) {
                str = this._characterEscapes.getEscapeSequence(c).getValue();
            } else {
                str = serializableString.getValue();
                this._currentEscape = null;
            }
            int length = str.length();
            if (this._outputTail + length > this._outputEnd) {
                _flushBuffer();
                if (length > this._outputEnd) {
                    this._writer.write(str);
                    return;
                }
            }
            str.getChars(0, length, this._outputBuffer, this._outputTail);
            this._outputTail += length;
        }
    }

    private char[] _allocateEntityBuffer() {
        char[] cArr = new char[14];
        cArr[0] = '\\';
        cArr[2] = '\\';
        cArr[3] = 'u';
        cArr[4] = '0';
        cArr[5] = '0';
        cArr[8] = '\\';
        cArr[9] = 'u';
        this._entityBuffer = cArr;
        return cArr;
    }

    /* access modifiers changed from: protected */
    public final void _flushBuffer() throws IOException {
        int i = this._outputTail;
        int i2 = this._outputHead;
        int i3 = i - i2;
        if (i3 > 0) {
            this._outputHead = 0;
            this._outputTail = 0;
            this._writer.write(this._outputBuffer, i2, i3);
        }
    }
}
