package com.medallia.digital.mobilesdk;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* renamed from: com.medallia.digital.mobilesdk.s2 */
class C3717s2 implements Parcelable {
    public static final Parcelable.Creator<C3717s2> CREATOR = new C3718a();

    /* renamed from: a */
    private String f1827a;

    /* renamed from: b */
    private String f1828b;

    /* renamed from: c */
    private boolean f1829c;

    /* renamed from: d */
    private boolean f1830d;

    /* renamed from: com.medallia.digital.mobilesdk.s2$a */
    static class C3718a implements Parcelable.Creator<C3717s2> {
        C3718a() {
        }

        public C3717s2 createFromParcel(Parcel parcel) {
            return new C3717s2(parcel);
        }

        public C3717s2[] newArray(int i) {
            return new C3717s2[i];
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.s2$b */
    enum C3719b {
        swipeUp,
        swipeDown,
        swipeLeft,
        swipeRight,
        buttonClicked
    }

    /* renamed from: com.medallia.digital.mobilesdk.s2$c */
    enum C3720c {
        maybeLater,
        androidBackButton,
        timeoutPassed,
        refreshSession,
        disableIntercept,
        stopApi,
        showForm,
        handleNotification
    }

    /* renamed from: com.medallia.digital.mobilesdk.s2$d */
    enum C3721d {
        f1846a,
        StickyByConfiguration,
        StickyByGesture
    }

    C3717s2(Parcel parcel) {
        this.f1827a = parcel.readString();
        this.f1828b = parcel.readString();
    }

    C3717s2(C3721d dVar, C3719b bVar, boolean z) {
        this.f1828b = bVar.toString();
        this.f1827a = dVar != null ? dVar.toString() : null;
        this.f1829c = z;
    }

    C3717s2(C3721d dVar, C3720c cVar, boolean z) {
        this.f1828b = cVar.toString();
        this.f1827a = dVar != null ? dVar.toString() : null;
        this.f1829c = z;
        this.f1830d = true;
    }

    C3717s2(C3721d dVar, boolean z) {
        this.f1827a = dVar != null ? dVar.toString() : null;
        this.f1829c = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo55797a() {
        return this.f1828b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo55798b() {
        return this.f1827a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo55799c() {
        return this.f1829c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo55800d() {
        return this.f1830d;
    }

    public int describeContents() {
        return 0;
    }

    @NonNull
    public String toString() {
        return "InvitationReason{stickyMode='" + this.f1827a + '\'' + ", reason='" + this.f1828b + '\'' + ", actionButtonsEnabled='" + this.f1829c + '\'' + ", isDeferred='" + this.f1830d + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1827a);
        parcel.writeString(this.f1828b);
        parcel.writeByte(this.f1829c ? (byte) 1 : 0);
        parcel.writeByte(this.f1830d ? (byte) 1 : 0);
    }
}
