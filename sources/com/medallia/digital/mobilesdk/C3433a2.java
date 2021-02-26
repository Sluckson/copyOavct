package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3792y;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.medallia.digital.mobilesdk.a2 */
class C3433a2 extends C3792y implements Serializable {

    /* renamed from: o */
    private static final int f877o = 31;

    /* renamed from: a */
    private String f878a;

    /* renamed from: b */
    private String f879b;

    /* renamed from: c */
    private String f880c;

    /* renamed from: d */
    private String f881d;

    /* renamed from: e */
    private List<ResourceContract> f882e;

    /* renamed from: f */
    private String f883f;

    /* renamed from: g */
    private String f884g;

    /* renamed from: h */
    private String f885h;

    /* renamed from: i */
    private FormTriggerType f886i;

    /* renamed from: j */
    private C3434a f887j;

    /* renamed from: k */
    private C3640m5 f888k;

    /* renamed from: l */
    private InviteData f889l;

    /* renamed from: m */
    private FormViewType f890m;

    /* renamed from: n */
    private boolean f891n;

    /* renamed from: com.medallia.digital.mobilesdk.a2$a */
    protected enum C3434a {
        NOT_EXISTS(0),
        NOT_STARTED(1),
        IN_PROGRESS(2),
        AVAILABLE(3),
        FAILED(4);
        

        /* renamed from: a */
        private int f898a;

        private C3434a(int i) {
            this.f898a = i;
        }

        /* renamed from: a */
        protected static C3434a m457a(int i) {
            for (C3434a aVar : values()) {
                if (aVar.mo55203a() == i) {
                    return aVar;
                }
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo55203a() {
            return this.f898a;
        }
    }

    protected C3433a2(SDKConfigurationFormContract sDKConfigurationFormContract) {
        this.f878a = sDKConfigurationFormContract.getFormId();
        this.f879b = sDKConfigurationFormContract.getFormJson().toString();
        this.f880c = sDKConfigurationFormContract.getTemplateLocalUrl();
        this.f881d = sDKConfigurationFormContract.getTemplateRemoteUrl();
        this.f883f = sDKConfigurationFormContract.getTitle();
        this.f884g = sDKConfigurationFormContract.getTitleTextColor();
        this.f885h = sDKConfigurationFormContract.getTitleBackgroundColor();
        this.f886i = sDKConfigurationFormContract.getFormType();
        this.f887j = C3434a.NOT_STARTED;
        this.f888k = ModelFactory.getInstance().createTransitionType(this.f879b);
        this.f889l = sDKConfigurationFormContract.getInviteData();
        this.f890m = sDKConfigurationFormContract.getFormViewType() != null ? sDKConfigurationFormContract.getFormViewType() : FormViewType.none;
        this.f891n = sDKConfigurationFormContract.isPreloaded();
        mo55186a(sDKConfigurationFormContract.getResources());
        m445g();
    }

    protected C3433a2(String str, String str2, String str3, String str4, List<ResourceContract> list, String str5, String str6, String str7, FormTriggerType formTriggerType, C3434a aVar, C3640m5 m5Var, InviteData inviteData, FormViewType formViewType, boolean z) {
        this.f878a = str;
        this.f879b = str2;
        this.f880c = str3;
        this.f881d = str4;
        this.f883f = str5;
        this.f884g = str6;
        this.f885h = str7;
        this.f886i = formTriggerType;
        this.f887j = aVar;
        this.f888k = m5Var;
        this.f889l = inviteData;
        this.f890m = formViewType == null ? FormViewType.none : formViewType;
        this.f891n = z;
        mo55186a(list);
        m445g();
    }

    /* renamed from: g */
    private void m445g() {
        if (this.f887j != null) {
            C3490e3.m661b("FormId: " + this.f878a + ", FormStatus : " + this.f887j.name());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C3434a mo55182a() {
        if (this.f887j == null) {
            this.f887j = C3434a.NOT_STARTED;
        }
        return this.f887j;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55183a(SDKConfigurationFormContract sDKConfigurationFormContract) {
        if (sDKConfigurationFormContract != null) {
            this.f883f = sDKConfigurationFormContract.getTitle();
            this.f885h = sDKConfigurationFormContract.getTitleBackgroundColor();
            this.f884g = sDKConfigurationFormContract.getTitleTextColor();
            this.f879b = sDKConfigurationFormContract.getFormJson().toString();
            this.f886i = sDKConfigurationFormContract.getFormType();
            this.f890m = sDKConfigurationFormContract.getFormViewType() != null ? sDKConfigurationFormContract.getFormViewType() : FormViewType.none;
            this.f888k = ModelFactory.getInstance().createTransitionType(this.f879b);
            this.f889l = sDKConfigurationFormContract.getInviteData();
            this.f891n = sDKConfigurationFormContract.isPreloaded();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55184a(C3434a aVar) {
        this.f887j = aVar;
        m445g();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55185a(String str) {
        this.f880c = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55186a(List<ResourceContract> list) {
        this.f882e = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (ResourceContract next : list) {
                next.setFormId(this.f878a);
                this.f882e.add(next);
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public List<ResourceContract> mo55187b() {
        return this.f882e;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo55188b(String str) {
        this.f881d = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public String mo55189c() {
        if (this.f880c == null) {
            this.f880c = "";
        }
        return this.f880c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo55190d() {
        if (this.f881d == null) {
            this.f881d = "";
        }
        return this.f881d;
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public C3640m5 mo55191e() {
        C3640m5 m5Var = this.f888k;
        return m5Var == null ? C3640m5.Fade : m5Var;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3433a2.class != obj.getClass()) {
            return false;
        }
        C3433a2 a2Var = (C3433a2) obj;
        String str = this.f878a;
        if (str == null ? a2Var.f878a != null : !str.equals(a2Var.f878a)) {
            return false;
        }
        String str2 = this.f879b;
        if (str2 == null ? a2Var.f879b != null : !str2.equals(a2Var.f879b)) {
            return false;
        }
        String str3 = this.f880c;
        if (str3 == null ? a2Var.f880c != null : !str3.equals(a2Var.f880c)) {
            return false;
        }
        String str4 = this.f881d;
        if (str4 == null ? a2Var.f881d != null : !str4.equals(a2Var.f881d)) {
            return false;
        }
        List<ResourceContract> list = this.f882e;
        if (list == null ? a2Var.f882e != null : !list.equals(a2Var.f882e)) {
            return false;
        }
        String str5 = this.f883f;
        if (str5 == null ? a2Var.f883f != null : !str5.equals(a2Var.f883f)) {
            return false;
        }
        String str6 = this.f884g;
        if (str6 == null ? a2Var.f884g != null : !str6.equals(a2Var.f884g)) {
            return false;
        }
        String str7 = this.f885h;
        if (str7 == null ? a2Var.f885h != null : !str7.equals(a2Var.f885h)) {
            return false;
        }
        FormTriggerType formTriggerType = this.f886i;
        if (formTriggerType == null ? a2Var.f886i == null : formTriggerType.equals(a2Var.f886i)) {
            return this.f891n == a2Var.f891n && this.f888k == a2Var.f888k && this.f887j == a2Var.f887j;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo55193f() {
        return this.f891n;
    }

    /* access modifiers changed from: protected */
    public C3792y.C3793a getDataTableObjectType() {
        return C3792y.C3793a.FormData;
    }

    /* access modifiers changed from: protected */
    public String getFormId() {
        return this.f878a;
    }

    /* access modifiers changed from: protected */
    public String getFormJson() {
        return this.f879b;
    }

    /* access modifiers changed from: protected */
    public FormTriggerType getFormType() {
        return this.f886i;
    }

    /* access modifiers changed from: protected */
    public FormViewType getFormViewType() {
        return this.f890m;
    }

    /* access modifiers changed from: protected */
    public InviteData getInviteData() {
        return this.f889l;
    }

    /* access modifiers changed from: protected */
    public String getTitle() {
        return this.f883f;
    }

    /* access modifiers changed from: protected */
    public String getTitleBackgroundColor() {
        return this.f885h;
    }

    /* access modifiers changed from: protected */
    public String getTitleTextColor() {
        return this.f884g;
    }

    public int hashCode() {
        String str = this.f878a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f879b;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f880c;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f881d;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        List<ResourceContract> list = this.f882e;
        int hashCode5 = (hashCode4 + (list != null ? list.hashCode() : 0)) * 31;
        String str5 = this.f883f;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.f884g;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.f885h;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        FormTriggerType formTriggerType = this.f886i;
        int hashCode9 = (hashCode8 + (formTriggerType != null ? formTriggerType.hashCode() : 0)) * 31;
        C3434a aVar = this.f887j;
        int hashCode10 = (hashCode9 + (aVar != null ? aVar.hashCode() : 0)) * 31;
        C3640m5 m5Var = this.f888k;
        int hashCode11 = (hashCode10 + (m5Var != null ? m5Var.hashCode() : 0)) * 31;
        FormViewType formViewType = this.f890m;
        if (formViewType != null) {
            i = formViewType.hashCode();
        }
        return ((hashCode11 + i) * 31) + Boolean.valueOf(this.f891n).hashCode();
    }
}
