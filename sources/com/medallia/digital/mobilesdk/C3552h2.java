package com.medallia.digital.mobilesdk;

import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.C1119C;
import com.medallia.digital.mobilesdk.AnalyticsBridge;
import com.medallia.digital.mobilesdk.C3433a2;
import com.medallia.digital.mobilesdk.C3649n4;
import com.medallia.digital.mobilesdk.C3706r3;
import com.medallia.digital.mobilesdk.C3792y;
import com.medallia.digital.mobilesdk.InviteData;
import com.medallia.digital.mobilesdk.MDExternalError;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.medallia.digital.mobilesdk.h2 */
class C3552h2 implements C3713r5 {

    /* renamed from: q */
    private static C3552h2 f1238q;

    /* renamed from: a */
    protected C3568i2 f1239a = new C3568i2();

    /* renamed from: b */
    protected String f1240b;

    /* renamed from: c */
    private String f1241c;

    /* renamed from: d */
    private String f1242d;

    /* renamed from: e */
    private String f1243e;

    /* renamed from: f */
    private String f1244f;

    /* renamed from: g */
    private Long f1245g;

    /* renamed from: h */
    private boolean f1246h;

    /* renamed from: i */
    private boolean f1247i = false;

    /* renamed from: j */
    private boolean f1248j = false;

    /* renamed from: k */
    protected LinkedHashMap<String, C3433a2> f1249k = new LinkedHashMap<>();

    /* renamed from: l */
    protected List<ResourceContract> f1250l = new ArrayList();

    /* renamed from: m */
    private HashMap<String, Boolean> f1251m = new HashMap<>();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public HashMap<String, C3795y1> f1252n = new HashMap<>();

    /* renamed from: o */
    private C3555c f1253o;

    /* renamed from: p */
    protected LinkedHashMap<String, C3611m> f1254p = new LinkedHashMap<>();

    /* renamed from: com.medallia.digital.mobilesdk.h2$a */
    class C3553a implements C3649n4.C3651b {
        C3553a() {
        }

        /* renamed from: a */
        public void mo55259a(ResourceContract resourceContract) {
            C3552h2.this.f1250l.remove(resourceContract);
            if (C3552h2.this.mo55458e()) {
                C3552h2.this.m916i();
            }
        }

        /* renamed from: b */
        public void mo55260b(ResourceContract resourceContract) {
            if (C3552h2.this.f1252n != null) {
                for (Map.Entry entry : C3552h2.this.f1252n.entrySet()) {
                    if (entry.getValue() != null) {
                        ((C3795y1) entry.getValue()).mo55373a();
                        C3552h2.this.f1252n.put(entry.getKey(), (Object) null);
                    }
                }
                HashMap unused = C3552h2.this.f1252n = null;
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.h2$b */
    class C3554b implements C3519f2 {
        C3554b() {
        }

        /* renamed from: a */
        public void mo55375a(C3433a2 a2Var) {
            C3552h2.this.f1249k.put(a2Var.getFormId(), a2Var);
            if (C3552h2.this.f1252n != null && C3552h2.this.f1252n.get(a2Var.getFormId()) != null) {
                ((C3795y1) C3552h2.this.f1252n.get(a2Var.getFormId())).onSuccess();
                C3552h2.this.f1252n.put(a2Var.getFormId(), (Object) null);
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.h2$c */
    interface C3555c {
        /* renamed from: a */
        void mo55462a();
    }

    private C3552h2() {
    }

    /* renamed from: a */
    private boolean m903a(String str, String str2) {
        return (str == null && str2 == null) || (str != null && str.equals(str2));
    }

    /* renamed from: b */
    private C3433a2 m904b(SDKConfigurationFormContract sDKConfigurationFormContract) {
        C3433a2 d = mo55456d(sDKConfigurationFormContract.getFormId());
        if (d == null) {
            return new C3433a2(sDKConfigurationFormContract);
        }
        boolean a = mo55448a(d, sDKConfigurationFormContract);
        m915h(d, sDKConfigurationFormContract);
        boolean a2 = mo55449a(d.mo55187b(), sDKConfigurationFormContract.getResources());
        if (!mo55446a(sDKConfigurationFormContract) || !a2 || !a) {
            d.mo55184a(C3433a2.C3434a.IN_PROGRESS);
            if (!a2) {
                d.mo55186a(sDKConfigurationFormContract.getResources());
            }
            d.mo55188b(sDKConfigurationFormContract.getTemplateRemoteUrl());
            d.mo55185a(sDKConfigurationFormContract.getTemplateLocalUrl());
            return d;
        }
        d.mo55184a(C3433a2.C3434a.AVAILABLE);
        return d;
    }

    /* renamed from: b */
    private boolean m906b(C3433a2 a2Var, SDKConfigurationFormContract sDKConfigurationFormContract) {
        return (a2Var.getInviteData() == null && sDKConfigurationFormContract.getInviteData() == null) || !(a2Var.getInviteData() == null || sDKConfigurationFormContract.getInviteData() == null || !a2Var.getInviteData().equals(sDKConfigurationFormContract.getInviteData()));
    }

    /* renamed from: c */
    private void m907c(ConfigurationContract configurationContract) {
        List<AppRatingContract> appRatings;
        C3490e3.m661b("LoadAppRatings - start updating appRatings");
        if (configurationContract != null && configurationContract.getPropertyConfiguration() != null && (appRatings = configurationContract.getPropertyConfiguration().getAppRatings()) != null && appRatings.size() > 0) {
            for (AppRatingContract mVar : appRatings) {
                C3611m mVar2 = new C3611m(mVar);
                this.f1254p.put(mVar2.mo55548a(), mVar2);
            }
        }
    }

    /* renamed from: c */
    private boolean m908c(C3433a2 a2Var, SDKConfigurationFormContract sDKConfigurationFormContract) {
        return (a2Var.getFormJson() == null && sDKConfigurationFormContract.getFormJson() == null) || (TextUtils.isEmpty(a2Var.getFormJson()) && sDKConfigurationFormContract.getFormJson() != null && sDKConfigurationFormContract.getFormJson().length() == 0) || !(a2Var.getFormJson() == null || sDKConfigurationFormContract.getFormJson() == null || a2Var.getFormJson().compareTo(sDKConfigurationFormContract.getFormJson().toString()) != 0);
    }

    /* renamed from: d */
    private boolean m909d(C3433a2 a2Var, SDKConfigurationFormContract sDKConfigurationFormContract) {
        return (a2Var.getFormType() == null && sDKConfigurationFormContract.getFormType() == null) || (a2Var.getFormType() != null && a2Var.getFormType().equals(sDKConfigurationFormContract.getFormType()));
    }

    /* renamed from: e */
    private boolean m910e(C3433a2 a2Var, SDKConfigurationFormContract sDKConfigurationFormContract) {
        return ((a2Var.getFormViewType() == null || a2Var.getFormViewType() == FormViewType.none) && sDKConfigurationFormContract.getFormViewType() == null) || (a2Var.getFormViewType() != null && a2Var.getFormViewType().equals(sDKConfigurationFormContract.getFormViewType()));
    }

    /* renamed from: f */
    private void m911f(String str) {
        Boolean b = C3785x1.m1892b(str);
        if (b != null) {
            AnalyticsBridge.getInstance().reportDeleteStorageEvent(str, b.booleanValue());
        }
    }

    /* renamed from: f */
    private boolean m912f(C3433a2 a2Var, SDKConfigurationFormContract sDKConfigurationFormContract) {
        return a2Var.mo55193f() == sDKConfigurationFormContract.isPreloaded();
    }

    /* renamed from: g */
    private boolean m913g(C3433a2 a2Var, SDKConfigurationFormContract sDKConfigurationFormContract) {
        return (a2Var.mo55189c() == null && sDKConfigurationFormContract.getTemplateLocalUrl() == null) || (a2Var.mo55189c() != null && !TextUtils.isEmpty(sDKConfigurationFormContract.getTemplateLocalUrl()) && a2Var.mo55189c().contains(sDKConfigurationFormContract.getTemplateLocalUrl()));
    }

    /* renamed from: h */
    protected static C3552h2 m914h() {
        if (f1238q == null) {
            f1238q = new C3552h2();
        }
        return f1238q;
    }

    /* renamed from: h */
    private void m915h(C3433a2 a2Var, SDKConfigurationFormContract sDKConfigurationFormContract) {
        if (a2Var != null && sDKConfigurationFormContract != null) {
            a2Var.mo55183a(sDKConfigurationFormContract);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m916i() {
        this.f1239a.mo55482a(this.f1249k, (C3519f2) new C3554b());
        C3555c cVar = this.f1253o;
        if (cVar != null) {
            cVar.mo55462a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C3611m mo55440a(String str) {
        LinkedHashMap<String, C3611m> linkedHashMap = this.f1254p;
        if (linkedHashMap == null || str == null) {
            return null;
        }
        return linkedHashMap.get(str);
    }

    @VisibleForTesting
    /* renamed from: a */
    public void mo55441a() {
        List<ResourceContract> list = this.f1250l;
        if (list == null || list.size() == 0) {
            C3782x0.m1872d().mo55907a(C3792y.C3793a.Resource, true);
            return;
        }
        HashMap hashMap = new HashMap();
        for (ResourceContract next : this.f1250l) {
            hashMap.put(next.getRemoteUrl(), next);
        }
        ArrayList<? extends C3792y> c = C3782x0.m1872d().mo55913c(C3792y.C3793a.Resource, true);
        if (c != null) {
            Iterator<? extends C3792y> it = c.iterator();
            while (it.hasNext()) {
                ResourceContract resourceContract = (ResourceContract) it.next();
                if (hashMap.get(resourceContract.getRemoteUrl()) == null) {
                    C3782x0.m1872d().mo55908a((C3792y) resourceContract);
                    m911f(resourceContract.getLocalUrl());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55442a(ConfigurationContract configurationContract) {
        mo55443a(configurationContract, (C3555c) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55443a(ConfigurationContract configurationContract, C3555c cVar) {
        this.f1253o = cVar;
        mo55453b(configurationContract);
        m907c(configurationContract);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55444a(String str, MDResultCallback mDResultCallback) {
        LinkedHashMap<String, C3433a2> linkedHashMap = this.f1249k;
        MDExternalError mDExternalError = null;
        if (linkedHashMap == null || linkedHashMap.isEmpty()) {
            mDExternalError = new MDExternalError(MDExternalError.ExternalError.FORM_NOT_EXISTS_OR_NOT_PUBLISH);
        } else {
            C3433a2 a2Var = this.f1249k.get(str);
            if (a2Var == null || a2Var.mo55182a() == C3433a2.C3434a.NOT_EXISTS) {
                mDExternalError = new MDExternalError(MDExternalError.ExternalError.FORM_NOT_EXISTS_OR_NOT_PUBLISH);
            } else if (a2Var.mo55182a() == C3433a2.C3434a.NOT_STARTED) {
                mo55459e(str);
                mDExternalError = new MDExternalError(MDExternalError.ExternalError.FORM_IS_NOT_AVAILABLE);
            } else if (a2Var.mo55182a() == C3433a2.C3434a.IN_PROGRESS || a2Var.mo55182a() == C3433a2.C3434a.FAILED) {
                mDExternalError = new MDExternalError(MDExternalError.ExternalError.FORM_IS_NOT_AVAILABLE);
            } else if (a2Var.mo55182a() == C3433a2.C3434a.AVAILABLE) {
                if (mo55447a(a2Var) || !C3461c3.m562g().mo55271c()) {
                    mo55451b(a2Var);
                    if (a2Var.mo55193f() && C3817z5.m2029b().mo55992b(C3706r3.C3711e.preload) == null) {
                        C3490e3.m663c("Preload form wasn't loaded yet");
                    }
                    C3817z5.m2029b().mo55989a(a2Var, (C3706r3.C3710d) null, a2Var.mo55193f() ? C3706r3.C3711e.preload : C3706r3.C3711e.showForm);
                    Intent intent = new Intent(C3595k3.m1060d().mo55513b(), a2Var.getFormViewType() == FormViewType.modal ? MedalliaModalFormActivity.class : MedalliaFullFormActivity.class);
                    intent.addFlags(C1119C.ENCODING_PCM_MU_LAW);
                    intent.putExtra("com.medallia.digital.mobilesdk.form_data", a2Var);
                    intent.putExtra("com.medallia.digital.mobilesdk.is_show_form", true);
                    intent.putExtra("com.medallia.digital.mobilesdk.spinner_delay", this.f1245g);
                    intent.putExtra("com.medallia.digital.mobilesdk.vuln_enabled", this.f1246h);
                    intent.putExtra("com.medallia.digital.mobilesdk.inherit_orientation", this.f1248j);
                    C3595k3.m1060d().mo55513b().startActivity(intent);
                    C3490e3.m665e("Form shown successfully");
                    if (mDResultCallback != null) {
                        mDResultCallback.onSuccess();
                    }
                    AnalyticsBridge.getInstance().reportShowFormCallbackEvent(AnalyticsBridge.C3414c.f832a, (Integer) null, (String) null);
                } else {
                    mDExternalError = new MDExternalError(MDExternalError.ExternalError.FORM_IS_ALREADY_DISPLAYED);
                }
            }
        }
        if (mDExternalError != null) {
            C3490e3.m663c(mDExternalError.getMessage());
            if (mDResultCallback != null) {
                mDResultCallback.onError(mDExternalError);
            }
            AnalyticsBridge.getInstance().reportShowFormCallbackEvent(AnalyticsBridge.C3414c.failure, Integer.valueOf(mDExternalError.getErrorCode()), mDExternalError.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55445a(String str, C3795y1 y1Var) {
        if (mo55459e(str)) {
            this.f1252n.put(str, y1Var);
            C3490e3.m665e("Promoting form: " + str);
            return;
        }
        y1Var.onSuccess();
    }

    @VisibleForTesting
    /* renamed from: a */
    public boolean mo55446a(SDKConfigurationFormContract sDKConfigurationFormContract) {
        if (TextUtils.isEmpty(sDKConfigurationFormContract.getTemplateRemoteUrl()) || TextUtils.isEmpty(sDKConfigurationFormContract.getTemplateLocalUrl())) {
            return true;
        }
        C3525f5 f5Var = (C3525f5) C3782x0.m1872d().mo55911b(C3792y.C3793a.Template, sDKConfigurationFormContract.getTemplateRemoteUrl());
        return f5Var != null && f5Var.mo55380b().equals(sDKConfigurationFormContract.getTemplateRemoteUrl());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo55447a(C3433a2 a2Var) {
        return a2Var.getFormType() == FormTriggerType.mobileInvitation && a2Var.getInviteData() != null && a2Var.getInviteData().getType() == InviteData.C3415a.PUSH_NOTIFICATION;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    /* renamed from: a */
    public boolean mo55448a(C3433a2 a2Var, SDKConfigurationFormContract sDKConfigurationFormContract) {
        if (a2Var == null || sDKConfigurationFormContract == null) {
            return false;
        }
        return m913g(a2Var, sDKConfigurationFormContract) && m903a(a2Var.getTitle(), sDKConfigurationFormContract.getTitle()) && m903a(a2Var.getTitleBackgroundColor(), sDKConfigurationFormContract.getTitleBackgroundColor()) && m903a(a2Var.getTitleTextColor(), sDKConfigurationFormContract.getTitleTextColor()) && m908c(a2Var, sDKConfigurationFormContract) && m909d(a2Var, sDKConfigurationFormContract) && m910e(a2Var, sDKConfigurationFormContract) && m906b(a2Var, sDKConfigurationFormContract) && m912f(a2Var, sDKConfigurationFormContract);
    }

    @VisibleForTesting
    /* renamed from: a */
    public boolean mo55449a(List<ResourceContract> list, List<ResourceContract> list2) {
        if (list == null || list.isEmpty()) {
            return list2 == null || list2.isEmpty();
        }
        if (list2 == null) {
            for (ResourceContract next : list) {
                C3782x0.m1872d().mo55908a((C3792y) next);
                m911f(next.getLocalUrl());
            }
            return true;
        } else if (list2.size() > list.size()) {
            return false;
        } else {
            HashMap hashMap = new HashMap();
            for (ResourceContract next2 : list2) {
                hashMap.put(next2.getRemoteUrl(), next2);
            }
            for (ResourceContract next3 : list) {
                ResourceContract resourceContract = (ResourceContract) hashMap.get(next3.getRemoteUrl());
                if (resourceContract == null) {
                    C3782x0.m1872d().mo55908a((C3792y) next3);
                    m911f(next3.getLocalUrl());
                } else if (resourceContract.getChecksum().equals(next3.getChecksum())) {
                    hashMap.remove(next3.getRemoteUrl());
                }
            }
            return hashMap.isEmpty();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C3433a2 mo55450b(String str) {
        LinkedHashMap<String, C3433a2> linkedHashMap = this.f1249k;
        if (linkedHashMap == null || str == null) {
            return null;
        }
        return linkedHashMap.get(str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public File mo55451b(C3433a2 a2Var) {
        if (a2Var == null) {
            return null;
        }
        String str = "var formJson = " + a2Var.getFormJson() + "; var kpl_formJson = formJson;";
        C3785x1.m1885a(this.f1242d, "kplConfig.submitUrlPrefix = \"" + this.f1243e + "\";kplConfig.submitUrlSuffix = \"" + this.f1244f + "\";");
        C3490e3.m661b("Form data prepared");
        return C3785x1.m1885a(a2Var.mo55193f() ? this.f1241c : this.f1240b, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public ArrayList<ResourceContract> mo55452b() {
        ArrayList<? extends C3792y> c = C3782x0.m1872d().mo55913c(C3792y.C3793a.Resource, new Object[0]);
        ArrayList<ResourceContract> arrayList = new ArrayList<>();
        Iterator<? extends C3792y> it = c.iterator();
        while (it.hasNext()) {
            ResourceContract resourceContract = (ResourceContract) it.next();
            if (TextUtils.isEmpty(resourceContract.getFormId())) {
                arrayList.add(resourceContract);
            }
        }
        return arrayList;
    }

    @VisibleForTesting
    /* renamed from: b */
    public void mo55453b(ConfigurationContract configurationContract) {
        PropertyConfigurationContract propertyConfiguration;
        C3490e3.m661b("LoadForms - start updating forms");
        LinkedHashMap<String, C3433a2> linkedHashMap = this.f1249k;
        if (linkedHashMap != null) {
            linkedHashMap.clear();
        }
        LinkedHashMap<String, C3611m> linkedHashMap2 = this.f1254p;
        if (linkedHashMap2 != null) {
            linkedHashMap2.clear();
        }
        if (configurationContract != null && (propertyConfiguration = configurationContract.getPropertyConfiguration()) != null) {
            C3817z5.m2029b().mo55988a(configurationContract);
            this.f1250l = propertyConfiguration.getGlobalResources();
            this.f1242d = propertyConfiguration.getGlobalConfigurationFileLocalUrl();
            this.f1240b = propertyConfiguration.getFormJsonFileLocalUrl();
            this.f1241c = propertyConfiguration.getPreloadFormJsonFileLocalUrl();
            this.f1251m = propertyConfiguration.getProvisions();
            if (configurationContract.getSdkConfiguration() != null) {
                SDKConfigurationContract sdkConfiguration = configurationContract.getSdkConfiguration();
                if (sdkConfiguration.getFormConfigurations() != null) {
                    this.f1245g = sdkConfiguration.getFormConfigurations().getLoadFormIndicatorDelay();
                    this.f1246h = sdkConfiguration.getFormConfigurations().isVulnEnabled();
                    this.f1248j = sdkConfiguration.getFormConfigurations().isInheritOrientation();
                }
                if (sdkConfiguration.getMedalliaDigitalClientConfig() != null) {
                    MedalliaDigitalClientConfigurationContract medalliaDigitalClientConfig = sdkConfiguration.getMedalliaDigitalClientConfig();
                    this.f1244f = medalliaDigitalClientConfig.getSubmitUrlSuffix();
                    this.f1243e = medalliaDigitalClientConfig.getSubmitUrlPrefix();
                }
            }
            List<SDKConfigurationFormContract> forms = propertyConfiguration.getForms();
            if (forms == null || forms.size() <= 0) {
                ArrayList<? extends C3792y> c = C3782x0.m1872d().mo55913c(C3792y.C3793a.Template, new Object[0]);
                if (c != null) {
                    Iterator<? extends C3792y> it = c.iterator();
                    while (it.hasNext()) {
                        C3525f5 f5Var = (C3525f5) it.next();
                        C3782x0.m1872d().mo55908a((C3792y) f5Var);
                        m911f(f5Var.mo55378a());
                    }
                }
                ArrayList<? extends C3792y> c2 = C3782x0.m1872d().mo55913c(C3792y.C3793a.Resource, new Object[0]);
                if (c2 != null) {
                    Iterator<? extends C3792y> it2 = c2.iterator();
                    while (it2.hasNext()) {
                        ResourceContract resourceContract = (ResourceContract) it2.next();
                        C3782x0.m1872d().mo55908a((C3792y) resourceContract);
                        m911f(resourceContract.getLocalUrl());
                    }
                }
                ArrayList<? extends C3792y> c3 = C3782x0.m1872d().mo55913c(C3792y.C3793a.FormData, new Object[0]);
                if (c3 != null) {
                    Iterator<? extends C3792y> it3 = c3.iterator();
                    while (it3.hasNext()) {
                        C3782x0.m1872d().mo55908a((C3792y) (C3433a2) it3.next());
                    }
                }
            } else {
                for (SDKConfigurationFormContract b : forms) {
                    C3433a2 b2 = m904b(b);
                    this.f1249k.put(b2.getFormId(), b2);
                }
            }
            this.f1247i = true;
            mo55461g();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo55454c(String str) {
        C3525f5 f5Var = (C3525f5) C3782x0.m1872d().mo55911b(C3792y.C3793a.Template, str);
        if (f5Var == null) {
            return null;
        }
        return f5Var.mo55380b() + " : " + f5Var.mo55378a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public ArrayList<C3433a2> mo55455c() {
        if (this.f1249k == null) {
            return null;
        }
        ArrayList<C3433a2> arrayList = new ArrayList<>();
        for (Map.Entry<String, C3433a2> value : this.f1249k.entrySet()) {
            arrayList.add(value.getValue());
        }
        return arrayList;
    }

    public void clearAndDisconnect() {
        C3490e3.m659a("Forms");
        f1238q = null;
    }

    @VisibleForTesting
    /* renamed from: d */
    public C3433a2 mo55456d(String str) {
        if (str == null) {
            return null;
        }
        return (C3433a2) C3782x0.m1872d().mo55911b(C3792y.C3793a.FormData, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public HashMap<String, Boolean> mo55457d() {
        return this.f1251m;
    }

    @VisibleForTesting
    /* renamed from: e */
    public boolean mo55458e() {
        List<ResourceContract> list = this.f1250l;
        return list == null || list.size() == 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo55459e(String str) {
        C3433a2 a2Var = this.f1249k.get(str);
        if (a2Var != null && a2Var.mo55182a() == C3433a2.C3434a.AVAILABLE) {
            return false;
        }
        C3433a2 b = mo55450b(str);
        C3568i2 i2Var = this.f1239a;
        if (i2Var == null || b == null) {
            return false;
        }
        return i2Var.mo55483b(b);
    }

    /* renamed from: f */
    public boolean mo55460f() {
        return this.f1247i;
    }

    @VisibleForTesting
    /* renamed from: g */
    public void mo55461g() {
        mo55441a();
        List<ResourceContract> list = this.f1250l;
        if (list == null || list.isEmpty()) {
            m916i();
        } else {
            new C3649n4(this.f1250l, new C3553a());
        }
    }
}
