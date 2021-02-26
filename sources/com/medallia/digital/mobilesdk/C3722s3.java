package com.medallia.digital.mobilesdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.URLUtil;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.C1119C;
import com.medallia.digital.mobilesdk.C3527g0;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import p052cz.msebera.android.httpclient.protocol.HTTP;

/* renamed from: com.medallia.digital.mobilesdk.s3 */
class C3722s3 extends WebViewClient {

    /* renamed from: d */
    private static final String f1850d = "file://";

    /* renamed from: e */
    private static final int f1851e = 4;

    /* renamed from: a */
    private C3433a2 f1852a;

    /* renamed from: b */
    private boolean f1853b;

    /* renamed from: c */
    private ArrayList<String> f1854c;

    protected C3722s3(C3433a2 a2Var, boolean z, ArrayList<String> arrayList) {
        this.f1852a = a2Var;
        this.f1853b = z;
        this.f1854c = arrayList;
    }

    /* renamed from: a */
    private void m1622a(Context context, String str) {
        if (str != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.setFlags(C1119C.ENCODING_PCM_MU_LAW);
                context.startActivity(intent);
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
            }
        }
    }

    /* renamed from: c */
    private WebResourceResponse m1623c(String str) {
        return new WebResourceResponse(HTTP.PLAIN_TEXT_TYPE, "UTF-8", (InputStream) null);
    }

    /* renamed from: d */
    private void m1624d(String str) {
        C3527g0.C3531c.m845a(C3527g0.C3531c.C3532a.formLinkSelected, this.f1852a.getFormId(), this.f1852a.getFormType(), str);
    }

    /* renamed from: e */
    private void m1625e(String str) {
        C3527g0.C3531c.m845a(C3527g0.C3531c.C3532a.formBlockedUrl, this.f1852a.getFormId(), this.f1852a.getFormType(), str);
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    /* renamed from: a */
    public String mo55806a(String str) {
        String host;
        try {
            if (URLUtil.isValidUrl(str) && (host = new URL(str).getHost()) != null) {
                return host.startsWith("www.") ? host.substring(4) : host;
            }
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c  */
    @androidx.annotation.VisibleForTesting
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo55807b(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "file://"
            boolean r0 = r7.startsWith(r0)
            r1 = 0
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            boolean r0 = r6.f1853b
            r2 = 1
            if (r0 == 0) goto L_0x0010
            return r2
        L_0x0010:
            java.util.ArrayList<java.lang.String> r0 = r6.f1854c
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001c
            r6.m1624d(r7)
            return r1
        L_0x001c:
            java.lang.String r0 = r6.mo55806a(r7)
            java.util.ArrayList<java.lang.String> r3 = r6.f1854c
            java.util.Iterator r3 = r3.iterator()
        L_0x0026:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0042
            java.lang.Object r4 = r3.next()
            java.lang.String r4 = (java.lang.String) r4
            boolean r5 = r7.equals(r4)
            if (r5 != 0) goto L_0x003e
            boolean r4 = r0.endsWith(r4)
            if (r4 == 0) goto L_0x0026
        L_0x003e:
            r6.m1624d(r7)
            return r1
        L_0x0042:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3722s3.mo55807b(java.lang.String):boolean");
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        C3490e3.m661b("Form showed onPageFinished");
    }

    @RequiresApi(api = 21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return (webResourceRequest == null || webResourceRequest.getUrl() == null || !mo55807b(webResourceRequest.getUrl().toString())) ? super.shouldInterceptRequest(webView, webResourceRequest) : m1623c(webResourceRequest.getUrl().toString());
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return mo55807b(str) ? m1623c(str) : super.shouldInterceptRequest(webView, str);
    }

    @RequiresApi(api = 21)
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
        if (mo55807b(webResourceRequest.getUrl().toString())) {
            m1625e(webResourceRequest.getUrl().toString());
            return true;
        }
        m1622a(webView.getContext(), webResourceRequest.getUrl().toString());
        return true;
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (mo55807b(str)) {
            m1625e(str);
            return true;
        }
        m1622a(webView.getContext(), str);
        return true;
    }
}
