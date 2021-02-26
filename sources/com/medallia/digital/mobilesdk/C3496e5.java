package com.medallia.digital.mobilesdk;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.VisibleForTesting;
import com.medallia.digital.mobilesdk.C3461c3;
import com.medallia.digital.mobilesdk.C3576i5;
import com.medallia.digital.mobilesdk.C3815z4;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.e5 */
class C3496e5 implements C3461c3.C3469h, C3713r5, C3576i5.C3579b<C3505e> {

    /* renamed from: A */
    private static C3496e5 f1047A = null;

    /* renamed from: q */
    protected static final String f1048q = "2.0.0";

    /* renamed from: r */
    private static final String f1049r = "targetRuleEngine/tre-%s.js";

    /* renamed from: s */
    private static final String f1050s = "targetRuleEngine/index.html";

    /* renamed from: t */
    private static final String f1051t = "targetRuleEngine";

    /* renamed from: u */
    private static final String f1052u = "getFormToTrigger";

    /* renamed from: v */
    private static final String f1053v = "getFormToTriggerWithPath";

    /* renamed from: w */
    private static final String f1054w = "<html lang=\"en\"><body><script src=\"TRE_NAME_TEMP\"></script></body></html>";

    /* renamed from: x */
    private static final String f1055x = "targetRuleEngine";

    /* renamed from: y */
    private static final String f1056y = "TRE_NAME_TEMP";

    /* renamed from: z */
    private static final int f1057z = 2;

    /* renamed from: a */
    private long f1058a;

    /* renamed from: b */
    protected C3576i5 f1059b = new C3576i5(500, this);

    /* renamed from: c */
    protected boolean f1060c = false;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f1061d;

    /* renamed from: e */
    private Long f1062e;

    /* renamed from: f */
    protected String f1063f;

    /* renamed from: g */
    protected File f1064g;

    /* renamed from: h */
    private ArrayList<C3506f> f1065h = new ArrayList<>();

    /* renamed from: i */
    protected boolean f1066i = true;

    /* renamed from: j */
    private C3505e f1067j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public WebView f1068k;

    /* renamed from: l */
    private boolean f1069l = C3815z4.m2010d().mo55979a(C3815z4.C3816a.SDK_STOPPED, false);

    /* renamed from: m */
    protected boolean f1070m;

    /* renamed from: n */
    private boolean f1071n;

    /* renamed from: o */
    private Handler f1072o = new Handler(Looper.getMainLooper());

    /* renamed from: p */
    private C3666p3 f1073p = new C3497a();

    /* renamed from: com.medallia.digital.mobilesdk.e5$a */
    class C3497a extends C3666p3 {

        /* renamed from: com.medallia.digital.mobilesdk.e5$a$a */
        class C3498a extends C3666p3 {
            C3498a() {
            }

            /* renamed from: a */
            public void mo55177a() {
                C3496e5.this.mo55346a(C3505e.evaluationTimer);
            }
        }

        C3497a() {
        }

        /* renamed from: a */
        public void mo55177a() {
            C3561h5.m954c().mo55465a().execute(new C3498a());
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.e5$b */
    class C3499b extends C3666p3 {

        /* renamed from: a */
        final /* synthetic */ File f1076a;

        /* renamed from: com.medallia.digital.mobilesdk.e5$b$a */
        class C3500a extends WebViewClient {

            /* renamed from: com.medallia.digital.mobilesdk.e5$b$a$a */
            class C3501a implements ValueCallback<String> {

                /* renamed from: com.medallia.digital.mobilesdk.e5$b$a$a$a */
                class C3502a extends C3666p3 {

                    /* renamed from: a */
                    final /* synthetic */ String f1080a;

                    C3502a(String str) {
                        this.f1080a = str;
                    }

                    /* renamed from: a */
                    public void mo55177a() {
                        C3496e5.this.m691a(this.f1080a);
                    }
                }

                C3501a() {
                }

                /* renamed from: a */
                public void onReceiveValue(String str) {
                    C3561h5.m954c().mo55465a().execute(new C3502a(str));
                }
            }

            C3500a() {
            }

            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                if (C3496e5.this.f1068k == null && webView != null) {
                    WebView unused = C3496e5.this.f1068k = webView;
                }
                if (C3496e5.this.f1068k != null) {
                    if (Build.VERSION.SDK_INT >= 19) {
                        C3496e5.this.f1068k.evaluateJavascript(C3496e5.this.f1061d, new C3501a());
                    } else {
                        C3496e5.this.f1068k.addJavascriptInterface(new C3507g(C3496e5.this, (C3497a) null), "targetRuleEngine");
                        WebView a = C3496e5.this.f1068k;
                        a.loadUrl("javascript:" + C3496e5.this.f1061d);
                    }
                    String unused2 = C3496e5.this.f1061d = null;
                    return;
                }
                C3490e3.m663c("targetEngineWebView is null");
            }
        }

        C3499b(File file) {
            this.f1076a = file;
        }

        /* renamed from: a */
        public void mo55177a() {
            C3496e5 e5Var = C3496e5.this;
            WebView unused = e5Var.f1068k = e5Var.m700i();
            if (this.f1076a != null) {
                C3496e5.this.f1068k.loadUrl(String.format("file://%s", new Object[]{this.f1076a.getPath()}));
                C3496e5.this.f1068k.setWebViewClient(new C3500a());
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.e5$c */
    class C3503c extends C3666p3 {
        C3503c() {
        }

        /* renamed from: a */
        public void mo55177a() {
            if (C3496e5.this.f1068k != null) {
                C3496e5.this.f1068k.removeJavascriptInterface("targetRuleEngine");
                C3496e5.this.f1068k.setWebChromeClient((WebChromeClient) null);
                C3496e5.this.f1068k.setWebViewClient((WebViewClient) null);
                C3496e5.this.f1068k.stopLoading();
                if (Build.VERSION.SDK_INT < 19) {
                    C3496e5.this.f1068k.freeMemory();
                }
                C3496e5.this.f1068k.clearHistory();
                C3496e5.this.f1068k.removeAllViews();
                C3496e5.this.f1068k.destroyDrawingCache();
                C3496e5.this.f1068k.destroy();
                WebView unused = C3496e5.this.f1068k = null;
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.e5$d */
    class C3504d implements C3660o4<File> {

        /* renamed from: a */
        final /* synthetic */ TargetRuleEngineContract f1083a;

        C3504d(TargetRuleEngineContract targetRuleEngineContract) {
            this.f1083a = targetRuleEngineContract;
        }

        /* renamed from: a */
        public void mo55254a() {
        }

        /* renamed from: a */
        public void mo55256a(C3586j3 j3Var) {
            C3490e3.m663c(j3Var.getMessage());
            if (C3785x1.m1898d(C3496e5.this.f1064g)) {
                C3490e3.m666f("Using previous TRE " + C3496e5.this.f1064g.getName());
                C3496e5.this.mo55346a(C3505e.sdkInit);
            }
        }

        /* renamed from: a */
        public void mo55257a(File file) {
            C3496e5.this.m690a(file);
            C3496e5 e5Var = C3496e5.this;
            e5Var.f1064g = file;
            e5Var.mo55346a(C3505e.sdkInit);
            C3496e5 e5Var2 = C3496e5.this;
            e5Var2.mo55347a(e5Var2.f1064g, this.f1083a);
            C3496e5.this.m698g();
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.e5$e */
    protected enum C3505e {
        sdkInit,
        updateConfiguration,
        enableIntercept,
        backToForeground,
        customParameters,
        evaluationTimer
    }

    /* renamed from: com.medallia.digital.mobilesdk.e5$f */
    class C3506f {

        /* renamed from: a */
        long f1092a;

        /* renamed from: b */
        long f1093b;

        /* renamed from: c */
        String f1094c;

        /* renamed from: d */
        String f1095d;

        C3506f(Long l, String str) {
            this.f1092a = l.longValue();
            this.f1094c = str;
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.e5$g */
    private class C3507g {

        /* renamed from: com.medallia.digital.mobilesdk.e5$g$a */
        class C3508a extends C3666p3 {

            /* renamed from: a */
            final /* synthetic */ String f1098a;

            C3508a(String str) {
                this.f1098a = str;
            }

            /* renamed from: a */
            public void mo55177a() {
                C3496e5.this.m691a(this.f1098a);
            }
        }

        private C3507g() {
        }

        /* synthetic */ C3507g(C3496e5 e5Var, C3497a aVar) {
            this();
        }

        @JavascriptInterface
        public void getFormToTrigger(String str) {
            C3561h5.m954c().mo55465a().execute(new C3508a(str));
        }
    }

    private C3496e5() {
    }

    /* renamed from: a */
    private String m688a(String str, String str2) {
        return String.format("%s.%s(%s,%s,%s)", new Object[]{"targetRuleEngine", str, C3754u5.m1743f().mo55862b(), str2, String.valueOf(System.currentTimeMillis())});
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m690a(File file) {
        ArrayList<Pair<String, Boolean>> a = C3785x1.m1888a("targetRuleEngine", file);
        if (a != null) {
            Iterator<Pair<String, Boolean>> it = a.iterator();
            while (it.hasNext()) {
                Pair next = it.next();
                if (next != null) {
                    AnalyticsBridge.getInstance().reportDeleteStorageEvent((String) next.first, ((Boolean) next.second).booleanValue());
                }
            }
        }
        C3815z4.m2010d().mo55984b(C3815z4.C3816a.TARGET_ENGINE, (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m691a(String str) {
        C3490e3.m661b(str);
        C3506f fVar = new C3506f(Long.valueOf(System.currentTimeMillis()), new Throwable().getStackTrace()[2].getMethodName());
        try {
            EvaluationResult createEvaluationResult = ModelFactory.getInstance().createEvaluationResult(str);
            if (createEvaluationResult != null) {
                fVar.f1093b = System.currentTimeMillis();
                fVar.f1095d = str;
                this.f1062e = createEvaluationResult.getNextEvaluationTime();
                if (createEvaluationResult.getEngagementId() != null) {
                    Locale locale = Locale.US;
                    C3490e3.m661b(String.format(locale, "[%d] - [%d] success: Calling InterceptProducer - with engagement id: %s", new Object[]{Long.valueOf(fVar.f1092a), Long.valueOf(fVar.f1093b), createEvaluationResult.getEngagementId()}));
                    this.f1060c = true;
                    C3702r2.m1571c().mo55770a(createEvaluationResult.getEngagementId(), createEvaluationResult.getEngagementType());
                } else if (this.f1062e != null) {
                    Locale locale2 = Locale.US;
                    C3490e3.m661b(String.format(locale2, "[%d] - [%d] success: Calling evaluate with timestamp %d", new Object[]{Long.valueOf(fVar.f1092a), Long.valueOf(fVar.f1093b), this.f1062e}));
                    m702k();
                }
                m692a(createEvaluationResult.getEngagementId(), str, this.f1067j);
                this.f1065h.add(fVar);
                m697f();
                return;
            }
            throw new Exception("Parsing result failed");
        } catch (Exception e) {
            fVar.f1093b = System.currentTimeMillis();
            fVar.f1095d = e.getMessage();
            Locale locale3 = Locale.US;
            C3490e3.m663c(String.format(locale3, "[%d] - [%d] failure: Evaluate crashed with exception. Message : %s", new Object[]{Long.valueOf(fVar.f1092a), Long.valueOf(fVar.f1093b), fVar.f1095d}));
        } catch (Throwable th) {
            this.f1065h.add(fVar);
            m697f();
            throw th;
        }
    }

    /* renamed from: a */
    private void m692a(String str, String str2, C3505e eVar) {
        C3433a2 b = C3552h2.m914h().mo55450b(str);
        AnalyticsBridge instance = AnalyticsBridge.getInstance();
        long j = this.f1058a;
        long currentTimeMillis = System.currentTimeMillis();
        if (b == null) {
            str = null;
        }
        instance.reportTargetEvaluatorEvent(j, currentTimeMillis, str, b != null ? b.mo55182a() : null, str2, eVar.name());
    }

    /* renamed from: f */
    private void m697f() {
        try {
            ((Activity) C3595k3.m1060d().mo55514c().getBaseContext()).runOnUiThread(new C3503c());
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m698g() {
        AnalyticsBridge.getInstance().setTreResourceReady(true);
        AnalyticsBridge.getInstance().reportResourcesSizeEvent();
    }

    /* renamed from: h */
    protected static C3496e5 m699h() {
        if (f1047A == null) {
            f1047A = new C3496e5();
        }
        return f1047A;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public WebView m700i() {
        WebView webView = new WebView(C3595k3.m1060d().mo55511a().getApplicationContext());
        webView.setWillNotDraw(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkLoads(true);
        webView.getSettings().setAppCacheEnabled(false);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.getSettings().setCacheMode(2);
        return webView;
    }

    /* renamed from: j */
    private TargetRuleEngineContract m701j() {
        String a = C3815z4.m2010d().mo55975a(C3815z4.C3816a.TARGET_ENGINE, (String) null);
        if (a == null) {
            return null;
        }
        return ModelFactory.getInstance().createTargetRuleEngine(a);
    }

    /* renamed from: k */
    private void m702k() {
        m704m();
        m703l();
    }

    /* renamed from: l */
    private void m703l() {
        Long l = this.f1062e;
        if (l != null) {
            this.f1072o.postDelayed(this.f1073p, l.longValue());
        }
    }

    /* renamed from: m */
    private void m704m() {
        this.f1072o.removeCallbacks(this.f1073p);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ArrayList<C3506f> mo55343a() {
        return this.f1065h;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55344a(ConfigurationContract configurationContract) {
        if (configurationContract != null && configurationContract.getTargetRuleEngine() != null) {
            if (configurationContract.getTargetRuleEngine().getUrl() != null || configurationContract.getTargetRuleEngine().getVersion() != null) {
                this.f1060c = false;
                if (!(configurationContract.getSdkConfiguration() == null || configurationContract.getSdkConfiguration().getMedalliaDigitalBrain() == null)) {
                    this.f1070m = configurationContract.getSdkConfiguration().getMedalliaDigitalBrain().isCanBlockAfterOneSuccess();
                    this.f1071n = configurationContract.getSdkConfiguration().getMedalliaDigitalBrain().isEvaluateWithConfigurationFile();
                }
                if (!this.f1071n) {
                    this.f1063f = configurationContract.toJsonString();
                }
                if (mo55355c(configurationContract.getTargetRuleEngine())) {
                    mo55346a(C3505e.updateConfiguration);
                    m698g();
                    return;
                }
                this.f1064g = mo55357e();
                if (!mo55355c(configurationContract.getTargetRuleEngine())) {
                    mo55345a(configurationContract.getTargetRuleEngine());
                    return;
                }
                m698g();
                mo55346a(C3505e.updateConfiguration);
            }
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55345a(TargetRuleEngineContract targetRuleEngineContract) {
        if (targetRuleEngineContract != null) {
            C3646n3.m1337m().mo55669a(true, targetRuleEngineContract.getUrl(), mo55351b(targetRuleEngineContract), new C3504d(targetRuleEngineContract));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo55346a(C3505e eVar) {
        if (!this.f1066i) {
            C3490e3.m661b("Intercept is not enabled, evaluate won't run");
        } else if (this.f1070m && this.f1060c) {
            C3490e3.m661b("Skip evaluation intercept was already shown in session");
        } else if (!C3785x1.m1898d(this.f1064g)) {
            C3490e3.m663c("Target engine is missing");
        } else {
            this.f1059b.mo55488a(eVar);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55347a(File file, TargetRuleEngineContract targetRuleEngineContract) {
        if (targetRuleEngineContract != null && C3785x1.m1898d(file)) {
            C3815z4.m2010d().mo55984b(C3815z4.C3816a.TARGET_ENGINE, targetRuleEngineContract.toJsonString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55349a(boolean z) {
        this.f1069l = z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55350a(boolean z, boolean z2) {
        boolean z3 = this.f1066i;
        this.f1066i = z;
        if (!z2) {
            return;
        }
        if (!z3 || this.f1066i) {
            mo55346a(C3505e.enableIntercept);
        } else {
            m704m();
        }
    }

    @VisibleForTesting
    /* renamed from: b */
    public String mo55351b(TargetRuleEngineContract targetRuleEngineContract) {
        return String.format(f1049r, new Object[]{targetRuleEngineContract.getVersion()});
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55352b() {
        C3461c3.m562g().mo55265a((C3461c3.C3469h) this);
    }

    /* renamed from: b */
    public void mo55348a(C3505e eVar) {
        String str;
        String str2;
        if (this.f1069l) {
            C3490e3.m665e("Evaluate can’t be trigger because of stop sdk");
        } else if (this.f1066i) {
            this.f1067j = eVar;
            C3754u5.m1743f().mo55857a(CollectorsInfrastructure.getInstance().timeInForegroundCollector.mo55521n());
            this.f1058a = System.currentTimeMillis();
            C3490e3.m665e("Evaluate with TRE " + this.f1064g.getName());
            File a = C3785x1.m1885a(f1050s, f1054w.replace(f1056y, this.f1064g.getName()));
            this.f1061d = "";
            if (this.f1071n) {
                str2 = C3770w2.m1830b(C3729t0.m1647b().getPath());
                str = f1053v;
            } else {
                str2 = this.f1063f;
                str = f1052u;
            }
            this.f1061d = m688a(str, str2);
            try {
                ((Activity) C3595k3.m1060d().mo55514c().getBaseContext()).runOnUiThread(new C3499b(a));
            } catch (Exception e) {
                C3490e3.m663c(e.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo55354c() {
        return this.f1066i;
    }

    @VisibleForTesting
    /* renamed from: c */
    public boolean mo55355c(TargetRuleEngineContract targetRuleEngineContract) {
        TargetRuleEngineContract j;
        if (!C3785x1.m1898d(this.f1064g) || (j = m701j()) == null || j.getVersion() == null) {
            return false;
        }
        return j.getVersion().equals(targetRuleEngineContract.getVersion());
    }

    public void clearAndDisconnect() {
        C3490e3.m659a("TargetEvaluator");
        m704m();
        f1047A = null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo55356d() {
        return this.f1066i;
    }

    @VisibleForTesting
    /* renamed from: e */
    public File mo55357e() {
        TargetRuleEngineContract j = m701j();
        if (j != null) {
            return C3785x1.m1895c(mo55351b(j));
        }
        return null;
    }

    public void onBackground() {
        m704m();
    }

    public void onForeground() {
        if (this.f1062e != null) {
            this.f1062e = Long.valueOf((CollectorsInfrastructure.getInstance() == null || CollectorsInfrastructure.getInstance().getTimeInBackground() == null || this.f1062e.longValue() <= CollectorsInfrastructure.getInstance().getTimeInBackground().longValue()) ? 1000 : this.f1062e.longValue() - CollectorsInfrastructure.getInstance().getTimeInBackground().longValue());
        }
        m702k();
    }
}
