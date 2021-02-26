package p052cz.msebera.android.httpclient.client.entity;

import java.io.IOException;
import java.io.InputStream;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.client.entity.LazyDecompressingInputStream */
class LazyDecompressingInputStream extends InputStream {
    private final DecompressingEntity decompressingEntity;
    private final InputStream wrappedStream;
    private InputStream wrapperStream;

    public boolean markSupported() {
        return false;
    }

    public LazyDecompressingInputStream(InputStream inputStream, DecompressingEntity decompressingEntity2) {
        this.wrappedStream = inputStream;
        this.decompressingEntity = decompressingEntity2;
    }

    private void initWrapper() throws IOException {
        if (this.wrapperStream == null) {
            this.wrapperStream = this.decompressingEntity.decorate(this.wrappedStream);
        }
    }

    public int read() throws IOException {
        initWrapper();
        return this.wrapperStream.read();
    }

    public int read(byte[] bArr) throws IOException {
        initWrapper();
        return this.wrapperStream.read(bArr);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        initWrapper();
        return this.wrapperStream.read(bArr, i, i2);
    }

    public long skip(long j) throws IOException {
        initWrapper();
        return this.wrapperStream.skip(j);
    }

    public int available() throws IOException {
        initWrapper();
        return this.wrapperStream.available();
    }

    public void close() throws IOException {
        try {
            if (this.wrapperStream != null) {
                this.wrapperStream.close();
            }
        } finally {
            this.wrappedStream.close();
        }
    }
}
