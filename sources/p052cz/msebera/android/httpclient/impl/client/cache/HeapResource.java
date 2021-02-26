package p052cz.msebera.android.httpclient.impl.client.cache;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.cache.Resource;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.HeapResource */
public class HeapResource implements Resource {
    private static final long serialVersionUID = -2078599905620463394L;

    /* renamed from: b */
    private final byte[] f4886b;

    public void dispose() {
    }

    public HeapResource(byte[] bArr) {
        this.f4886b = bArr;
    }

    /* access modifiers changed from: package-private */
    public byte[] getByteArray() {
        return this.f4886b;
    }

    public InputStream getInputStream() {
        return new ByteArrayInputStream(this.f4886b);
    }

    public long length() {
        return (long) this.f4886b.length;
    }
}
