package p052cz.msebera.android.httpclient.entity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.entity.ByteArrayEntity */
public class ByteArrayEntity extends AbstractHttpEntity implements Cloneable {

    /* renamed from: b */
    private final byte[] f4876b;
    @Deprecated
    protected final byte[] content;
    private final int len;
    private final int off;

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public ByteArrayEntity(byte[] bArr, ContentType contentType) {
        Args.notNull(bArr, "Source byte array");
        this.content = bArr;
        this.f4876b = bArr;
        this.off = 0;
        this.len = this.f4876b.length;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    public ByteArrayEntity(byte[] bArr, int i, int i2, ContentType contentType) {
        int i3;
        Args.notNull(bArr, "Source byte array");
        if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) < 0 || i3 > bArr.length) {
            throw new IndexOutOfBoundsException("off: " + i + " len: " + i2 + " b.length: " + bArr.length);
        }
        this.content = bArr;
        this.f4876b = bArr;
        this.off = i;
        this.len = i2;
        if (contentType != null) {
            setContentType(contentType.toString());
        }
    }

    public ByteArrayEntity(byte[] bArr) {
        this(bArr, (ContentType) null);
    }

    public ByteArrayEntity(byte[] bArr, int i, int i2) {
        this(bArr, i, i2, (ContentType) null);
    }

    public long getContentLength() {
        return (long) this.len;
    }

    public InputStream getContent() {
        return new ByteArrayInputStream(this.f4876b, this.off, this.len);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        outputStream.write(this.f4876b, this.off, this.len);
        outputStream.flush();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
