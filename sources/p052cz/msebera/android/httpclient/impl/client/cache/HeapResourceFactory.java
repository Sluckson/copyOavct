package p052cz.msebera.android.httpclient.impl.client.cache;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.cache.InputLimit;
import p052cz.msebera.android.httpclient.client.cache.Resource;
import p052cz.msebera.android.httpclient.client.cache.ResourceFactory;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.HeapResourceFactory */
public class HeapResourceFactory implements ResourceFactory {
    public Resource generate(String str, InputStream inputStream, InputLimit inputLimit) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2048];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                break;
            }
            byteArrayOutputStream.write(bArr, 0, read);
            j += (long) read;
            if (inputLimit != null && j > inputLimit.getValue()) {
                inputLimit.reached();
                break;
            }
        }
        return createResource(byteArrayOutputStream.toByteArray());
    }

    public Resource copy(String str, Resource resource) throws IOException {
        byte[] bArr;
        if (resource instanceof HeapResource) {
            bArr = ((HeapResource) resource).getByteArray();
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            IOUtils.copyAndClose(resource.getInputStream(), byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
        }
        return createResource(bArr);
    }

    /* access modifiers changed from: package-private */
    public Resource createResource(byte[] bArr) {
        return new HeapResource(bArr);
    }
}
