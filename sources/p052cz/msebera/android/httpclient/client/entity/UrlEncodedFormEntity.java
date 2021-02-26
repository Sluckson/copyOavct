package p052cz.msebera.android.httpclient.client.entity;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.List;
import p052cz.msebera.android.httpclient.NameValuePair;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.client.utils.URLEncodedUtils;
import p052cz.msebera.android.httpclient.entity.ContentType;
import p052cz.msebera.android.httpclient.entity.StringEntity;
import p052cz.msebera.android.httpclient.protocol.HTTP;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity */
public class UrlEncodedFormEntity extends StringEntity {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public UrlEncodedFormEntity(java.util.List<? extends p052cz.msebera.android.httpclient.NameValuePair> r2, java.lang.String r3) throws java.io.UnsupportedEncodingException {
        /*
            r1 = this;
            if (r3 == 0) goto L_0x0004
            r0 = r3
            goto L_0x000a
        L_0x0004:
            java.nio.charset.Charset r0 = p052cz.msebera.android.httpclient.protocol.HTTP.DEF_CONTENT_CHARSET
            java.lang.String r0 = r0.name()
        L_0x000a:
            java.lang.String r2 = p052cz.msebera.android.httpclient.client.utils.URLEncodedUtils.format((java.util.List<? extends p052cz.msebera.android.httpclient.NameValuePair>) r2, (java.lang.String) r0)
            java.lang.String r0 = "application/x-www-form-urlencoded"
            cz.msebera.android.httpclient.entity.ContentType r3 = p052cz.msebera.android.httpclient.entity.ContentType.create((java.lang.String) r0, (java.lang.String) r3)
            r1.<init>((java.lang.String) r2, (p052cz.msebera.android.httpclient.entity.ContentType) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.client.entity.UrlEncodedFormEntity.<init>(java.util.List, java.lang.String):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UrlEncodedFormEntity(Iterable<? extends NameValuePair> iterable, Charset charset) {
        super(URLEncodedUtils.format(iterable, charset != null ? charset : HTTP.DEF_CONTENT_CHARSET), ContentType.create(URLEncodedUtils.CONTENT_TYPE, charset));
    }

    public UrlEncodedFormEntity(List<? extends NameValuePair> list) throws UnsupportedEncodingException {
        this((Iterable<? extends NameValuePair>) list, (Charset) null);
    }

    public UrlEncodedFormEntity(Iterable<? extends NameValuePair> iterable) {
        this(iterable, (Charset) null);
    }
}
