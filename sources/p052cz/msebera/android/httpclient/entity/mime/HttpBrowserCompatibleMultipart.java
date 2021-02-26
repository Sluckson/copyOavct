package p052cz.msebera.android.httpclient.entity.mime;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

/* renamed from: cz.msebera.android.httpclient.entity.mime.HttpBrowserCompatibleMultipart */
class HttpBrowserCompatibleMultipart extends AbstractMultipartForm {
    private final List<FormBodyPart> parts;

    public HttpBrowserCompatibleMultipart(String str, Charset charset, String str2, List<FormBodyPart> list) {
        super(str, charset, str2);
        this.parts = list;
    }

    public List<FormBodyPart> getBodyParts() {
        return this.parts;
    }

    /* access modifiers changed from: protected */
    public void formatMultipartHeader(FormBodyPart formBodyPart, OutputStream outputStream) throws IOException {
        Header header = formBodyPart.getHeader();
        writeField(header.getField("Content-Disposition"), this.charset, outputStream);
        if (formBodyPart.getBody().getFilename() != null) {
            writeField(header.getField("Content-Type"), this.charset, outputStream);
        }
    }
}
