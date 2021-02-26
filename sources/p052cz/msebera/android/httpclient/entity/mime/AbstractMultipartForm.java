package p052cz.msebera.android.httpclient.entity.mime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.ByteArrayBuffer;

/* renamed from: cz.msebera.android.httpclient.entity.mime.AbstractMultipartForm */
abstract class AbstractMultipartForm {
    private static final ByteArrayBuffer CR_LF = encode(MIME.DEFAULT_CHARSET, "\r\n");
    private static final ByteArrayBuffer FIELD_SEP = encode(MIME.DEFAULT_CHARSET, ": ");
    private static final ByteArrayBuffer TWO_DASHES = encode(MIME.DEFAULT_CHARSET, "--");
    private final String boundary;
    protected final Charset charset;
    private final String subType;

    /* access modifiers changed from: protected */
    public abstract void formatMultipartHeader(FormBodyPart formBodyPart, OutputStream outputStream) throws IOException;

    public abstract List<FormBodyPart> getBodyParts();

    private static ByteArrayBuffer encode(Charset charset2, String str) {
        ByteBuffer encode = charset2.encode(CharBuffer.wrap(str));
        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(encode.remaining());
        byteArrayBuffer.append(encode.array(), encode.position(), encode.remaining());
        return byteArrayBuffer;
    }

    private static void writeBytes(ByteArrayBuffer byteArrayBuffer, OutputStream outputStream) throws IOException {
        outputStream.write(byteArrayBuffer.buffer(), 0, byteArrayBuffer.length());
    }

    private static void writeBytes(String str, Charset charset2, OutputStream outputStream) throws IOException {
        writeBytes(encode(charset2, str), outputStream);
    }

    private static void writeBytes(String str, OutputStream outputStream) throws IOException {
        writeBytes(encode(MIME.DEFAULT_CHARSET, str), outputStream);
    }

    protected static void writeField(MinimalField minimalField, OutputStream outputStream) throws IOException {
        writeBytes(minimalField.getName(), outputStream);
        writeBytes(FIELD_SEP, outputStream);
        writeBytes(minimalField.getBody(), outputStream);
        writeBytes(CR_LF, outputStream);
    }

    protected static void writeField(MinimalField minimalField, Charset charset2, OutputStream outputStream) throws IOException {
        writeBytes(minimalField.getName(), charset2, outputStream);
        writeBytes(FIELD_SEP, outputStream);
        writeBytes(minimalField.getBody(), charset2, outputStream);
        writeBytes(CR_LF, outputStream);
    }

    public AbstractMultipartForm(String str, Charset charset2, String str2) {
        Args.notNull(str, "Multipart subtype");
        Args.notNull(str2, "Multipart boundary");
        this.subType = str;
        this.charset = charset2 == null ? MIME.DEFAULT_CHARSET : charset2;
        this.boundary = str2;
    }

    public AbstractMultipartForm(String str, String str2) {
        this(str, (Charset) null, str2);
    }

    public String getSubType() {
        return this.subType;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public String getBoundary() {
        return this.boundary;
    }

    /* access modifiers changed from: package-private */
    public void doWriteTo(OutputStream outputStream, boolean z) throws IOException {
        ByteArrayBuffer encode = encode(this.charset, getBoundary());
        for (FormBodyPart next : getBodyParts()) {
            writeBytes(TWO_DASHES, outputStream);
            writeBytes(encode, outputStream);
            writeBytes(CR_LF, outputStream);
            formatMultipartHeader(next, outputStream);
            writeBytes(CR_LF, outputStream);
            if (z) {
                next.getBody().writeTo(outputStream);
            }
            writeBytes(CR_LF, outputStream);
        }
        writeBytes(TWO_DASHES, outputStream);
        writeBytes(encode, outputStream);
        writeBytes(TWO_DASHES, outputStream);
        writeBytes(CR_LF, outputStream);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        doWriteTo(outputStream, true);
    }

    public long getTotalLength() {
        long j = 0;
        for (FormBodyPart body : getBodyParts()) {
            long contentLength = body.getBody().getContentLength();
            if (contentLength < 0) {
                return -1;
            }
            j += contentLength;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            doWriteTo(byteArrayOutputStream, false);
            return j + ((long) byteArrayOutputStream.toByteArray().length);
        } catch (IOException unused) {
            return -1;
        }
    }
}
