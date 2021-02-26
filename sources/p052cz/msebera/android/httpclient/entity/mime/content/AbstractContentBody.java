package p052cz.msebera.android.httpclient.entity.mime.content;

import java.nio.charset.Charset;
import p052cz.msebera.android.httpclient.entity.ContentType;
import p052cz.msebera.android.httpclient.util.Args;

/* renamed from: cz.msebera.android.httpclient.entity.mime.content.AbstractContentBody */
public abstract class AbstractContentBody implements ContentBody {
    private final ContentType contentType;

    public AbstractContentBody(ContentType contentType2) {
        Args.notNull(contentType2, "Content type");
        this.contentType = contentType2;
    }

    @Deprecated
    public AbstractContentBody(String str) {
        this(ContentType.parse(str));
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public String getMimeType() {
        return this.contentType.getMimeType();
    }

    public String getMediaType() {
        String mimeType = this.contentType.getMimeType();
        int indexOf = mimeType.indexOf(47);
        return indexOf != -1 ? mimeType.substring(0, indexOf) : mimeType;
    }

    public String getSubType() {
        String mimeType = this.contentType.getMimeType();
        int indexOf = mimeType.indexOf(47);
        if (indexOf != -1) {
            return mimeType.substring(indexOf + 1);
        }
        return null;
    }

    public String getCharset() {
        Charset charset = this.contentType.getCharset();
        if (charset != null) {
            return charset.name();
        }
        return null;
    }
}
