package com.salesforce.marketingcloud.notifications;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.salesforce.marketingcloud.notifications.b */
final class C4106b extends C4105a {
    public static final Parcelable.Creator<C4106b> CREATOR = new Parcelable.Creator<C4106b>() {
        /* renamed from: a */
        public C4106b createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            String readString = parcel.readString();
            String str = null;
            String readString2 = parcel.readInt() == 0 ? parcel.readString() : null;
            int readInt = parcel.readInt();
            String readString3 = parcel.readString();
            NotificationMessage.Sound sound = (NotificationMessage.Sound) Enum.valueOf(NotificationMessage.Sound.class, parcel.readString());
            String readString4 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString5 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString6 = parcel.readInt() == 0 ? parcel.readString() : null;
            NotificationMessage.Type type = (NotificationMessage.Type) Enum.valueOf(NotificationMessage.Type.class, parcel.readString());
            NotificationMessage.Trigger trigger = (NotificationMessage.Trigger) Enum.valueOf(NotificationMessage.Trigger.class, parcel.readString());
            String readString7 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString8 = parcel.readInt() == 0 ? parcel.readString() : null;
            String readString9 = parcel.readInt() == 0 ? parcel.readString() : null;
            HashMap readHashMap = parcel2.readHashMap(NotificationMessage.class.getClassLoader());
            if (parcel.readInt() == 0) {
                str = parcel.readString();
            }
            return new C4106b(readString, readString2, readInt, readString3, sound, readString4, readString5, readString6, type, trigger, readString7, readString8, readString9, readHashMap, str, parcel2.readHashMap(NotificationMessage.class.getClassLoader()));
        }

        /* renamed from: a */
        public C4106b[] newArray(int i) {
            return new C4106b[i];
        }
    };

    C4106b(String str, @Nullable String str2, int i, String str3, NotificationMessage.Sound sound, @Nullable String str4, @Nullable String str5, @Nullable String str6, NotificationMessage.Type type, NotificationMessage.Trigger trigger, @Nullable String str7, @Nullable String str8, @Nullable String str9, Map<String, String> map, @Nullable String str10, @Nullable Map<String, String> map2) {
        super(str, str2, i, str3, sound, str4, str5, str6, type, trigger, str7, str8, str9, map, str10, map2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mo56835id());
        if (regionId() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(regionId());
        }
        parcel.writeInt(notificationId());
        parcel.writeString(alert());
        parcel.writeString(sound().name());
        if (soundName() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(soundName());
        }
        if (title() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(title());
        }
        if (subTitle() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(subTitle());
        }
        parcel.writeString(type().name());
        parcel.writeString(trigger().name());
        if (url() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(url());
        }
        if (mediaUrl() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(mediaUrl());
        }
        if (mediaAltText() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(mediaAltText());
        }
        parcel.writeMap(customKeys());
        if (custom() == null) {
            parcel.writeInt(1);
        } else {
            parcel.writeInt(0);
            parcel.writeString(custom());
        }
        parcel.writeMap(payload());
    }
}
