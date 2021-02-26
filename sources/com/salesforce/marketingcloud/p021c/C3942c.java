package com.salesforce.marketingcloud.p021c;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import java.util.List;
import java.util.Map;

/* renamed from: com.salesforce.marketingcloud.c.c */
final class C3942c extends C3937a {
    public static final Parcelable.Creator<C3942c> CREATOR = new Parcelable.Creator<C3942c>() {
        /* renamed from: a */
        public C3942c createFromParcel(Parcel parcel) {
            return new C3942c(parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt() == 0 ? parcel.readString() : null, parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readHashMap(C3953g.class.getClassLoader()));
        }

        /* renamed from: a */
        public C3942c[] newArray(int i) {
            return new C3942c[i];
        }
    };

    C3942c(@Nullable String str, @Nullable String str2, int i, long j, long j2, @Nullable Map<String, List<String>> map) {
        super(str, str2, i, j, j2, map);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (mo56359a() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(mo56359a());
        }
        if (mo56360b() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(mo56360b());
        }
        parcel.writeInt(mo56361c());
        parcel.writeLong(mo56362d());
        parcel.writeLong(mo56363e());
        parcel.writeMap(mo56365f());
    }
}
