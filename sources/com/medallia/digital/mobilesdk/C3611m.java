package com.medallia.digital.mobilesdk;

import java.io.Serializable;

/* renamed from: com.medallia.digital.mobilesdk.m */
class C3611m implements Serializable {

    /* renamed from: d */
    private static final int f1429d = 31;

    /* renamed from: a */
    private String f1430a;

    /* renamed from: b */
    private InviteData f1431b;

    /* renamed from: c */
    private String f1432c;

    C3611m(AppRatingContract appRatingContract) {
        this.f1430a = appRatingContract.getAppRatingId();
        this.f1431b = appRatingContract.getInviteData();
        this.f1432c = appRatingContract.getAppRatingUrl();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo55548a() {
        return this.f1430a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55549a(AppRatingContract appRatingContract) {
        if (appRatingContract != null) {
            this.f1430a = appRatingContract.getAppRatingId();
            this.f1431b = appRatingContract.getInviteData();
            this.f1432c = appRatingContract.getAppRatingUrl();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo55550b() {
        return this.f1432c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public InviteData mo55551c() {
        return this.f1431b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3611m.class != obj.getClass()) {
            return false;
        }
        C3611m mVar = (C3611m) obj;
        String str = this.f1430a;
        if (str == null ? mVar.f1430a != null : !str.equals(mVar.f1430a)) {
            return false;
        }
        InviteData inviteData = this.f1431b;
        if (inviteData == null ? mVar.f1431b != null : !inviteData.equals(mVar.f1431b)) {
            return false;
        }
        String str2 = this.f1432c;
        return str2 != null ? str2.equals(mVar.f1432c) : mVar.f1432c == null;
    }

    public int hashCode() {
        String str = this.f1430a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        InviteData inviteData = this.f1431b;
        int hashCode2 = (hashCode + (inviteData != null ? inviteData.hashCode() : 0)) * 31;
        String str2 = this.f1432c;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }
}
