package p052cz.msebera.android.httpclient.impl.client.cache;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.client.cache.Resource;
import p052cz.msebera.android.httpclient.entity.AbstractHttpEntity;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.CombinedEntity */
class CombinedEntity extends AbstractHttpEntity {
    private final InputStream combinedStream;
    private final Resource resource;

    public long getContentLength() {
        return -1;
    }

    public boolean isRepeatable() {
        return false;
    }

    public boolean isStreaming() {
        return true;
    }

    CombinedEntity(Resource resource2, InputStream inputStream) throws IOException {
        this.resource = resource2;
        this.combinedStream = new SequenceInputStream(new ResourceStream(resource2.getInputStream()), inputStream);
    }

    public InputStream getContent() throws IOException, IllegalStateException {
        return this.combinedStream;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        InputStream content = getContent();
        try {
            byte[] bArr = new byte[2048];
            while (true) {
                int read = content.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    return;
                }
            }
        } finally {
            content.close();
        }
    }

    /* access modifiers changed from: private */
    public void dispose() {
        this.resource.dispose();
    }

    /* renamed from: cz.msebera.android.httpclient.impl.client.cache.CombinedEntity$ResourceStream */
    class ResourceStream extends FilterInputStream {
        protected ResourceStream(InputStream inputStream) {
            super(inputStream);
        }

        public void close() throws IOException {
            try {
                super.close();
            } finally {
                CombinedEntity.this.dispose();
            }
        }
    }
}
