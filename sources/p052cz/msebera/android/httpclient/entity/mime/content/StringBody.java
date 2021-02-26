package p052cz.msebera.android.httpclient.entity.mime.content;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import p052cz.msebera.android.httpclient.Consts;
import p052cz.msebera.android.httpclient.entity.ContentType;
import p052cz.msebera.android.httpclient.entity.mime.MIME;
import p052cz.msebera.android.httpclient.protocol.HTTP;
import p052cz.msebera.android.httpclient.util.Args;

/* renamed from: cz.msebera.android.httpclient.entity.mime.content.StringBody */
public class StringBody extends AbstractContentBody {
    private final byte[] content;

    public String getFilename() {
        return null;
    }

    public String getTransferEncoding() {
        return MIME.ENC_8BIT;
    }

    @Deprecated
    public static StringBody create(String str, String str2, Charset charset) throws IllegalArgumentException {
        try {
            return new StringBody(str, str2, charset);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Charset " + charset + " is not supported", e);
        }
    }

    @Deprecated
    public static StringBody create(String str, Charset charset) throws IllegalArgumentException {
        return create(str, (String) null, charset);
    }

    @Deprecated
    public static StringBody create(String str) throws IllegalArgumentException {
        return create(str, (String) null, (Charset) null);
    }

    @Deprecated
    public StringBody(String str, String str2, Charset charset) throws UnsupportedEncodingException {
        this(str, ContentType.create(str2, charset));
    }

    @Deprecated
    public StringBody(String str, Charset charset) throws UnsupportedEncodingException {
        this(str, HTTP.PLAIN_TEXT_TYPE, charset);
    }

    @Deprecated
    public StringBody(String str) throws UnsupportedEncodingException {
        this(str, HTTP.PLAIN_TEXT_TYPE, Consts.ASCII);
    }

    public StringBody(String str, ContentType contentType) {
        super(contentType);
        Args.notNull(str, "Text");
        Charset charset = contentType.getCharset();
        String name = (charset == null ? Consts.ASCII : charset).name();
        try {
            this.content = str.getBytes(name);
        } catch (UnsupportedEncodingException unused) {
            throw new UnsupportedCharsetException(name);
        }
    }

    public Reader getReader() {
        Charset charset = getContentType().getCharset();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.content);
        if (charset == null) {
            charset = Consts.ASCII;
        }
        return new InputStreamReader(byteArrayInputStream, charset);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.content);
        byte[] bArr = new byte[4096];
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                outputStream.flush();
                return;
            }
        }
    }

    public long getContentLength() {
        return (long) this.content.length;
    }
}
