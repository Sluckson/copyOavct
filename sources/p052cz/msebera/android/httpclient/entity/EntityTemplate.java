package p052cz.msebera.android.httpclient.entity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p052cz.msebera.android.httpclient.util.Args;

/* renamed from: cz.msebera.android.httpclient.entity.EntityTemplate */
public class EntityTemplate extends AbstractHttpEntity {
    private final ContentProducer contentproducer;

    public long getContentLength() {
        return -1;
    }

    public boolean isRepeatable() {
        return true;
    }

    public boolean isStreaming() {
        return false;
    }

    public EntityTemplate(ContentProducer contentProducer) {
        this.contentproducer = (ContentProducer) Args.notNull(contentProducer, "Content producer");
    }

    public InputStream getContent() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        writeTo(byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        this.contentproducer.writeTo(outputStream);
    }
}
