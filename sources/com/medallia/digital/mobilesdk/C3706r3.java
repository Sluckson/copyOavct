package com.medallia.digital.mobilesdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.medallia.digital.mobilesdk.C3805z1;
import java.net.URLEncoder;
import java.util.ArrayList;

/* renamed from: com.medallia.digital.mobilesdk.r3 */
class C3706r3 extends WebView implements C3805z1.C3812g {

    /* renamed from: n */
    protected static final String f1794n = "NebulaAndroid";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public C3710d f1795a;

    /* renamed from: b */
    private C3805z1.C3812g f1796b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C3433a2 f1797c;

    /* renamed from: d */
    private boolean f1798d = true;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f1799e = false;

    /* renamed from: f */
    private C3711e f1800f;

    /* renamed from: g */
    private long f1801g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f1802h;

    /* renamed from: i */
    private String f1803i;

    /* renamed from: j */
    private String f1804j;

    /* renamed from: k */
    private String f1805k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f1806l = 1;

    /* renamed from: m */
    private ArrayList<String> f1807m = new ArrayList<>();

    /* renamed from: com.medallia.digital.mobilesdk.r3$a */
    class C3707a extends C3722s3 {
        C3707a(C3433a2 a2Var, boolean z, ArrayList arrayList) {
            super(a2Var, z, arrayList);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (str != null) {
                try {
                    if (!str.equals("about:blank")) {
                        if (C3706r3.this.f1795a != null) {
                            C3706r3.this.f1795a.mo55095b();
                        }
                        C3706r3.this.setVisibility(0);
                        boolean unused = C3706r3.this.f1799e = true;
                        long unused2 = C3706r3.this.f1802h = System.currentTimeMillis() - C3706r3.this.f1802h;
                        AnalyticsBridge.getInstance().reportFormLoadedEvent(C3706r3.this.f1797c.getFormId(), C3706r3.this.f1797c.getFormType(), C3706r3.this.f1802h, C3706r3.this.f1797c.getFormViewType(), C3706r3.this.mo55780h(), C3706r3.this.f1806l);
                        C3706r3.m1588e(C3706r3.this);
                    }
                } catch (Exception e) {
                    C3490e3.m663c(e.getMessage());
                }
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.r3$b */
    class C3708b extends WebChromeClient {
        C3708b() {
        }

        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return true;
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.r3$c */
    class C3709c extends C3666p3 {
        C3709c() {
        }

        /* renamed from: a */
        public void mo55177a() {
            if (C3706r3.this.f1797c != null) {
                String str = "(function(){NebulaForm.show({\"triggerType\": \"" + C3706r3.this.f1797c.getFormType() + "\"}); })();";
                if (Build.VERSION.SDK_INT >= 19) {
                    C3706r3.this.evaluateJavascript(str, (ValueCallback) null);
                    return;
                }
                C3706r3.this.loadUrl("javascript:" + str);
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.r3$d */
    protected interface C3710d {
        /* renamed from: a */
        void mo55094a();

        /* renamed from: b */
        void mo55095b();
    }

    /* renamed from: com.medallia.digital.mobilesdk.r3$e */
    enum C3711e {
        showForm,
        invitationProducer,
        preload
    }

    protected C3706r3(Context context, C3711e eVar, C3433a2 a2Var, long j) {
        super(context);
        this.f1800f = eVar;
        this.f1801g = j;
        this.f1797c = a2Var;
    }

    /* renamed from: a */
    private String m1583a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.contains("?")) {
            try {
                sb.append(str2);
                sb.append("=");
                sb.append(URLEncoder.encode("../" + str3, "UTF-8"));
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
            }
        } else {
            sb.append("?");
            sb.append(str2);
            sb.append("=");
            sb.append(URLEncoder.encode("../" + str3, "UTF-8"));
        }
        return sb.toString();
    }

    /* renamed from: e */
    static /* synthetic */ int m1588e(C3706r3 r3Var) {
        int i = r3Var.f1806l;
        r3Var.f1806l = i + 1;
        return i;
    }

    /* renamed from: k */
    private void m1589k() {
        C3709c cVar = new C3709c();
        try {
            ((Activity) C3595k3.m1060d().mo55514c().getBaseContext()).runOnUiThread(cVar);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
            new Handler(Looper.getMainLooper()).post(cVar);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3433a2 mo55771a() {
        return this.f1797c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55772a(ConfigurationContract configurationContract) {
        if (configurationContract != null && configurationContract.getPropertyConfiguration() != null && configurationContract.getSdkConfiguration() != null) {
            this.f1803i = configurationContract.getPropertyConfiguration().getFormFileLocationQueryParam();
            this.f1804j = configurationContract.getPropertyConfiguration().getPreloadFormJsonFileLocalUrl();
            this.f1805k = configurationContract.getPropertyConfiguration().getFormJsonFileLocalUrl();
            FormConfigurations formConfigurations = configurationContract.getSdkConfiguration().getFormConfigurations();
            if (!(formConfigurations == null || formConfigurations.getRedirectLinks() == null)) {
                this.f1807m = formConfigurations.getRedirectLinks();
            }
            MedalliaDigitalClientConfigurationContract medalliaDigitalClientConfig = configurationContract.getSdkConfiguration().getMedalliaDigitalClientConfig();
            if (medalliaDigitalClientConfig != null && medalliaDigitalClientConfig.getBlockNetworkInForm() != null) {
                this.f1798d = medalliaDigitalClientConfig.getBlockNetworkInForm().booleanValue();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55773a(C3710d dVar) {
        this.f1795a = dVar;
        if (this.f1797c != null) {
            this.f1799e = false;
            setVisibility(8);
            clearCache(false);
            setWebChromeClient(new WebChromeClient());
            getSettings().setJavaScriptEnabled(true);
            getSettings().setNeedInitialFocus(false);
            getSettings().setAppCacheEnabled(false);
            getSettings().setCacheMode(2);
            getSettings().setDomStorageEnabled(true);
            getSettings().setSupportZoom(false);
            getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            getSettings().setAllowUniversalAccessFromFileURLs(true);
            setWebViewClient(new C3707a(this.f1797c, this.f1798d, this.f1807m));
            setWebChromeClient(new C3708b());
            addJavascriptInterface(new C3805z1(this.f1797c.getFormId(), this, this.f1797c.getFormType(), this.f1797c.getFormViewType()), f1794n);
            String format = String.format("file:///%s", new Object[]{this.f1797c.mo55189c()});
            if (!TextUtils.isEmpty(this.f1803i)) {
                format = m1583a(format, this.f1803i, this.f1797c.mo55193f() ? this.f1804j : this.f1805k);
            }
            loadUrl(format);
            this.f1802h = System.currentTimeMillis();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55774a(C3805z1.C3812g gVar) {
        this.f1796b = gVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public String mo55775b() {
        C3433a2 a2Var = this.f1797c;
        if (a2Var == null) {
            return null;
        }
        return a2Var.getFormId();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55776b(C3710d dVar) {
        this.f1795a = dVar;
    }

    /* renamed from: c */
    public void mo55096c() {
        m1589k();
        C3805z1.C3812g gVar = this.f1796b;
        if (gVar != null) {
            gVar.mo55096c();
        }
        C3710d dVar = this.f1795a;
        if (dVar != null) {
            dVar.mo55094a();
        }
    }

    /* renamed from: d */
    public void mo55097d() {
        if (!mo55780h()) {
            this.f1797c = null;
        }
        C3805z1.C3812g gVar = this.f1796b;
        if (gVar != null) {
            gVar.mo55097d();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public long mo55777e() {
        return this.f1802h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public long mo55778f() {
        return this.f1801g;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public C3711e mo55779g() {
        return this.f1800f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public boolean mo55780h() {
        C3433a2 a2Var = this.f1797c;
        return a2Var != null && a2Var.mo55193f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public boolean mo55781i() {
        return this.f1799e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public void mo55782j() {
        if (mo55780h()) {
            this.f1802h = System.currentTimeMillis();
            setVisibility(8);
            clearCache(false);
            reload();
        }
    }
}
