package p052cz.msebera.android.httpclient.entity.mime.content;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p052cz.msebera.android.httpclient.entity.ContentType;
import p052cz.msebera.android.httpclient.entity.mime.MIME;
import p052cz.msebera.android.httpclient.util.Args;

/* renamed from: cz.msebera.android.httpclient.entity.mime.content.FileBody */
public class FileBody extends AbstractContentBody {
    private final File file;
    private final String filename;

    public String getTransferEncoding() {
        return MIME.ENC_BINARY;
    }

    @Deprecated
    public FileBody(File file2, String str, String str2, String str3) {
        this(file2, ContentType.create(str2, str3), str);
    }

    @Deprecated
    public FileBody(File file2, String str, String str2) {
        this(file2, (String) null, str, str2);
    }

    @Deprecated
    public FileBody(File file2, String str) {
        this(file2, ContentType.create(str), (String) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FileBody(File file2) {
        this(file2, ContentType.DEFAULT_BINARY, file2 != null ? file2.getName() : null);
    }

    public FileBody(File file2, ContentType contentType, String str) {
        super(contentType);
        Args.notNull(file2, "File");
        this.file = file2;
        this.filename = str;
    }

    public FileBody(File file2, ContentType contentType) {
        this(file2, contentType, (String) null);
    }

    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        Args.notNull(outputStream, "Output stream");
        FileInputStream fileInputStream = new FileInputStream(this.file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    outputStream.write(bArr, 0, read);
                } else {
                    outputStream.flush();
                    return;
                }
            }
        } finally {
            fileInputStream.close();
        }
    }

    public long getContentLength() {
        return this.file.length();
    }

    public String getFilename() {
        return this.filename;
    }

    public File getFile() {
        return this.file;
    }
}
