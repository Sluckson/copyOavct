package p052cz.msebera.android.httpclient.client.entity;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpEntity;

/* renamed from: cz.msebera.android.httpclient.client.entity.DeflateDecompressingEntity */
public class DeflateDecompressingEntity extends DecompressingEntity {
    public Header getContentEncoding() {
        return null;
    }

    public long getContentLength() {
        return -1;
    }

    public /* bridge */ /* synthetic */ InputStream getContent() throws IOException {
        return super.getContent();
    }

    public /* bridge */ /* synthetic */ void writeTo(OutputStream outputStream) throws IOException {
        super.writeTo(outputStream);
    }

    public DeflateDecompressingEntity(HttpEntity httpEntity) {
        super(httpEntity);
    }

    /* access modifiers changed from: package-private */
    public InputStream decorate(InputStream inputStream) throws IOException {
        return new DeflateInputStream(inputStream);
    }
}
