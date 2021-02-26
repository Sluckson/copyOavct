package p052cz.msebera.android.httpclient.client.entity;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.NameValuePair;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.entity.AbstractHttpEntity;
import p052cz.msebera.android.httpclient.entity.BasicHttpEntity;
import p052cz.msebera.android.httpclient.entity.ByteArrayEntity;
import p052cz.msebera.android.httpclient.entity.ContentType;
import p052cz.msebera.android.httpclient.entity.FileEntity;
import p052cz.msebera.android.httpclient.entity.InputStreamEntity;
import p052cz.msebera.android.httpclient.entity.SerializableEntity;
import p052cz.msebera.android.httpclient.entity.StringEntity;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.client.entity.EntityBuilder */
public class EntityBuilder {
    private byte[] binary;
    private boolean chunked;
    private String contentEncoding;
    private ContentType contentType;
    private File file;
    private boolean gzipCompress;
    private List<NameValuePair> parameters;
    private Serializable serializable;
    private InputStream stream;
    private String text;

    EntityBuilder() {
    }

    public static EntityBuilder create() {
        return new EntityBuilder();
    }

    private void clearContent() {
        this.text = null;
        this.binary = null;
        this.stream = null;
        this.parameters = null;
        this.serializable = null;
        this.file = null;
    }

    public String getText() {
        return this.text;
    }

    public EntityBuilder setText(String str) {
        clearContent();
        this.text = str;
        return this;
    }

    public byte[] getBinary() {
        return this.binary;
    }

    public EntityBuilder setBinary(byte[] bArr) {
        clearContent();
        this.binary = bArr;
        return this;
    }

    public InputStream getStream() {
        return this.stream;
    }

    public EntityBuilder setStream(InputStream inputStream) {
        clearContent();
        this.stream = inputStream;
        return this;
    }

    public List<NameValuePair> getParameters() {
        return this.parameters;
    }

    public EntityBuilder setParameters(List<NameValuePair> list) {
        clearContent();
        this.parameters = list;
        return this;
    }

    public EntityBuilder setParameters(NameValuePair... nameValuePairArr) {
        return setParameters((List<NameValuePair>) Arrays.asList(nameValuePairArr));
    }

    public Serializable getSerializable() {
        return this.serializable;
    }

    public EntityBuilder setSerializable(Serializable serializable2) {
        clearContent();
        this.serializable = serializable2;
        return this;
    }

    public File getFile() {
        return this.file;
    }

    public EntityBuilder setFile(File file2) {
        clearContent();
        this.file = file2;
        return this;
    }

    public ContentType getContentType() {
        return this.contentType;
    }

    public EntityBuilder setContentType(ContentType contentType2) {
        this.contentType = contentType2;
        return this;
    }

    public String getContentEncoding() {
        return this.contentEncoding;
    }

    public EntityBuilder setContentEncoding(String str) {
        this.contentEncoding = str;
        return this;
    }

    public boolean isChunked() {
        return this.chunked;
    }

    public EntityBuilder chunked() {
        this.chunked = true;
        return this;
    }

    public boolean isGzipCompress() {
        return this.gzipCompress;
    }

    public EntityBuilder gzipCompress() {
        this.gzipCompress = true;
        return this;
    }

    private ContentType getContentOrDefault(ContentType contentType2) {
        ContentType contentType3 = this.contentType;
        return contentType3 != null ? contentType3 : contentType2;
    }

    public HttpEntity build() {
        AbstractHttpEntity abstractHttpEntity;
        ContentType contentType2;
        String str = this.text;
        if (str != null) {
            abstractHttpEntity = new StringEntity(str, getContentOrDefault(ContentType.DEFAULT_TEXT));
        } else {
            byte[] bArr = this.binary;
            if (bArr != null) {
                abstractHttpEntity = new ByteArrayEntity(bArr, getContentOrDefault(ContentType.DEFAULT_BINARY));
            } else {
                InputStream inputStream = this.stream;
                if (inputStream != null) {
                    abstractHttpEntity = new InputStreamEntity(inputStream, 1, getContentOrDefault(ContentType.DEFAULT_BINARY));
                } else {
                    List<NameValuePair> list = this.parameters;
                    if (list != null) {
                        ContentType contentType3 = this.contentType;
                        abstractHttpEntity = new UrlEncodedFormEntity((Iterable<? extends NameValuePair>) list, contentType3 != null ? contentType3.getCharset() : null);
                    } else {
                        Serializable serializable2 = this.serializable;
                        if (serializable2 != null) {
                            abstractHttpEntity = new SerializableEntity(serializable2);
                            abstractHttpEntity.setContentType(ContentType.DEFAULT_BINARY.toString());
                        } else {
                            File file2 = this.file;
                            if (file2 != null) {
                                abstractHttpEntity = new FileEntity(file2, getContentOrDefault(ContentType.DEFAULT_BINARY));
                            } else {
                                abstractHttpEntity = new BasicHttpEntity();
                            }
                        }
                    }
                }
            }
        }
        if (!(abstractHttpEntity.getContentType() == null || (contentType2 = this.contentType) == null)) {
            abstractHttpEntity.setContentType(contentType2.toString());
        }
        abstractHttpEntity.setContentEncoding(this.contentEncoding);
        abstractHttpEntity.setChunked(this.chunked);
        return this.gzipCompress ? new GzipCompressingEntity(abstractHttpEntity) : abstractHttpEntity;
    }
}
