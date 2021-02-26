package com.salesforce.marketingcloud.proximity;

import android.annotation.SuppressLint;
import android.os.Parcelable;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.messages.Region;

@AutoValue
@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.proximity.e */
public abstract class C4122e implements Parcelable {
    /* renamed from: a */
    public static C4122e m3337a(Region region) {
        try {
            return m3338a(region.mo56647id(), region.proximityUuid(), region.major(), region.minor());
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static C4122e m3338a(String str, String str2, int i, int i2) {
        return new C4120d(str, str2, i, i2);
    }

    /* renamed from: a */
    public abstract String mo56901a();

    /* renamed from: b */
    public abstract String mo56902b();

    /* renamed from: c */
    public abstract int mo56903c();

    /* renamed from: d */
    public abstract int mo56904d();
}
