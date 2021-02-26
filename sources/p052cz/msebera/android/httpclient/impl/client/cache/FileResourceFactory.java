package p052cz.msebera.android.httpclient.impl.client.cache;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.cache.InputLimit;
import p052cz.msebera.android.httpclient.client.cache.Resource;
import p052cz.msebera.android.httpclient.client.cache.ResourceFactory;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.FileResourceFactory */
public class FileResourceFactory implements ResourceFactory {
    private final File cacheDir;
    private final BasicIdGenerator idgen = new BasicIdGenerator();

    public FileResourceFactory(File file) {
        this.cacheDir = file;
    }

    private File generateUniqueCacheFile(String str) {
        StringBuilder sb = new StringBuilder();
        this.idgen.generate(sb);
        sb.append('.');
        int min = Math.min(str.length(), 100);
        for (int i = 0; i < min; i++) {
            char charAt = str.charAt(i);
            if (Character.isLetterOrDigit(charAt) || charAt == '.') {
                sb.append(charAt);
            } else {
                sb.append('-');
            }
        }
        return new File(this.cacheDir, sb.toString());
    }

    /* JADX INFO: finally extract failed */
    public Resource generate(String str, InputStream inputStream, InputLimit inputLimit) throws IOException {
        File generateUniqueCacheFile = generateUniqueCacheFile(str);
        FileOutputStream fileOutputStream = new FileOutputStream(generateUniqueCacheFile);
        try {
            byte[] bArr = new byte[2048];
            long j = 0;
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
                j += (long) read;
                if (inputLimit != null && j > inputLimit.getValue()) {
                    inputLimit.reached();
                    break;
                }
            }
            fileOutputStream.close();
            return new FileResource(generateUniqueCacheFile);
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    public Resource copy(String str, Resource resource) throws IOException {
        File generateUniqueCacheFile = generateUniqueCacheFile(str);
        if (resource instanceof FileResource) {
            IOUtils.copyFile(((FileResource) resource).getFile(), generateUniqueCacheFile);
        } else {
            IOUtils.copyAndClose(resource.getInputStream(), new FileOutputStream(generateUniqueCacheFile));
        }
        return new FileResource(generateUniqueCacheFile);
    }
}
