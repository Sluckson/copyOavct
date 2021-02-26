package p052cz.msebera.android.httpclient.entity.mime;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.entity.ContentType;
import p052cz.msebera.android.httpclient.entity.mime.content.ByteArrayBody;
import p052cz.msebera.android.httpclient.entity.mime.content.ContentBody;
import p052cz.msebera.android.httpclient.entity.mime.content.FileBody;
import p052cz.msebera.android.httpclient.entity.mime.content.InputStreamBody;
import p052cz.msebera.android.httpclient.entity.mime.content.StringBody;
import p052cz.msebera.android.httpclient.protocol.HTTP;
import p052cz.msebera.android.httpclient.util.Args;

/* renamed from: cz.msebera.android.httpclient.entity.mime.MultipartEntityBuilder */
public class MultipartEntityBuilder {
    private static final String DEFAULT_SUBTYPE = "form-data";
    private static final char[] MULTIPART_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private List<FormBodyPart> bodyParts = null;
    private String boundary = null;
    private Charset charset = null;
    private HttpMultipartMode mode = HttpMultipartMode.STRICT;
    private String subType = DEFAULT_SUBTYPE;

    public static MultipartEntityBuilder create() {
        return new MultipartEntityBuilder();
    }

    MultipartEntityBuilder() {
    }

    public MultipartEntityBuilder setMode(HttpMultipartMode httpMultipartMode) {
        this.mode = httpMultipartMode;
        return this;
    }

    public MultipartEntityBuilder setLaxMode() {
        this.mode = HttpMultipartMode.BROWSER_COMPATIBLE;
        return this;
    }

    public MultipartEntityBuilder setStrictMode() {
        this.mode = HttpMultipartMode.STRICT;
        return this;
    }

    public MultipartEntityBuilder setBoundary(String str) {
        this.boundary = str;
        return this;
    }

    public MultipartEntityBuilder setCharset(Charset charset2) {
        this.charset = charset2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public MultipartEntityBuilder addPart(FormBodyPart formBodyPart) {
        if (formBodyPart == null) {
            return this;
        }
        if (this.bodyParts == null) {
            this.bodyParts = new ArrayList();
        }
        this.bodyParts.add(formBodyPart);
        return this;
    }

    public MultipartEntityBuilder addPart(String str, ContentBody contentBody) {
        Args.notNull(str, "Name");
        Args.notNull(contentBody, "Content body");
        return addPart(new FormBodyPart(str, contentBody));
    }

    public MultipartEntityBuilder addTextBody(String str, String str2, ContentType contentType) {
        return addPart(str, new StringBody(str2, contentType));
    }

    public MultipartEntityBuilder addTextBody(String str, String str2) {
        return addTextBody(str, str2, ContentType.DEFAULT_TEXT);
    }

    public MultipartEntityBuilder addBinaryBody(String str, byte[] bArr, ContentType contentType, String str2) {
        return addPart(str, new ByteArrayBody(bArr, contentType, str2));
    }

    public MultipartEntityBuilder addBinaryBody(String str, byte[] bArr) {
        return addBinaryBody(str, bArr, ContentType.DEFAULT_BINARY, (String) null);
    }

    public MultipartEntityBuilder addBinaryBody(String str, File file, ContentType contentType, String str2) {
        return addPart(str, new FileBody(file, contentType, str2));
    }

    public MultipartEntityBuilder addBinaryBody(String str, File file) {
        return addBinaryBody(str, file, ContentType.DEFAULT_BINARY, file != null ? file.getName() : null);
    }

    public MultipartEntityBuilder addBinaryBody(String str, InputStream inputStream, ContentType contentType, String str2) {
        return addPart(str, new InputStreamBody(inputStream, contentType, str2));
    }

    public MultipartEntityBuilder addBinaryBody(String str, InputStream inputStream) {
        return addBinaryBody(str, inputStream, ContentType.DEFAULT_BINARY, (String) null);
    }

    private String generateContentType(String str, Charset charset2) {
        StringBuilder sb = new StringBuilder();
        sb.append("multipart/form-data; boundary=");
        sb.append(str);
        if (charset2 != null) {
            sb.append(HTTP.CHARSET_PARAM);
            sb.append(charset2.name());
        }
        return sb.toString();
    }

    private String generateBoundary() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        int nextInt = random.nextInt(11) + 30;
        for (int i = 0; i < nextInt; i++) {
            char[] cArr = MULTIPART_CHARS;
            sb.append(cArr[random.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public MultipartFormEntity buildEntity() {
        List list;
        AbstractMultipartForm abstractMultipartForm;
        String str = this.subType;
        if (str == null) {
            str = DEFAULT_SUBTYPE;
        }
        Charset charset2 = this.charset;
        String str2 = this.boundary;
        if (str2 == null) {
            str2 = generateBoundary();
        }
        List<FormBodyPart> list2 = this.bodyParts;
        if (list2 != null) {
            list = new ArrayList(list2);
        } else {
            list = Collections.emptyList();
        }
        HttpMultipartMode httpMultipartMode = this.mode;
        if (httpMultipartMode == null) {
            httpMultipartMode = HttpMultipartMode.STRICT;
        }
        int i = C43461.f4877xc867cd5c[httpMultipartMode.ordinal()];
        if (i == 1) {
            abstractMultipartForm = new HttpBrowserCompatibleMultipart(str, charset2, str2, list);
        } else if (i != 2) {
            abstractMultipartForm = new HttpStrictMultipart(str, charset2, str2, list);
        } else {
            abstractMultipartForm = new HttpRFC6532Multipart(str, charset2, str2, list);
        }
        return new MultipartFormEntity(abstractMultipartForm, generateContentType(str2, charset2), abstractMultipartForm.getTotalLength());
    }

    /* renamed from: cz.msebera.android.httpclient.entity.mime.MultipartEntityBuilder$1 */
    static /* synthetic */ class C43461 {

        /* renamed from: $SwitchMap$cz$msebera$android$httpclient$entity$mime$HttpMultipartMode */
        static final /* synthetic */ int[] f4877xc867cd5c = new int[HttpMultipartMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                cz.msebera.android.httpclient.entity.mime.HttpMultipartMode[] r0 = p052cz.msebera.android.httpclient.entity.mime.HttpMultipartMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4877xc867cd5c = r0
                int[] r0 = f4877xc867cd5c     // Catch:{ NoSuchFieldError -> 0x0014 }
                cz.msebera.android.httpclient.entity.mime.HttpMultipartMode r1 = p052cz.msebera.android.httpclient.entity.mime.HttpMultipartMode.BROWSER_COMPATIBLE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f4877xc867cd5c     // Catch:{ NoSuchFieldError -> 0x001f }
                cz.msebera.android.httpclient.entity.mime.HttpMultipartMode r1 = p052cz.msebera.android.httpclient.entity.mime.HttpMultipartMode.RFC6532     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.entity.mime.MultipartEntityBuilder.C43461.<clinit>():void");
        }
    }

    public HttpEntity build() {
        return buildEntity();
    }
}
