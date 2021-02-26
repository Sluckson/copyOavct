package com.salesforce.marketingcloud.messages;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.auto.value.AutoValue;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.messages.C$AutoValue_Message;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p011io.sethclark.auto.value.json.JsonTypeAdapter;

@AutoValue
public abstract class Message {
    @MCKeep
    public static final int CONTENT_TYPE_ALERT = 1;
    @MCKeep
    public static final int MESSAGE_TYPE_FENCE_ENTRY = 3;
    @MCKeep
    public static final int MESSAGE_TYPE_FENCE_EXIT = 4;
    @MCKeep
    public static final int MESSAGE_TYPE_PROXIMITY = 5;
    @MCKeep
    public static final int PERIOD_TYPE_UNIT_DAY = 4;
    @MCKeep
    public static final int PERIOD_TYPE_UNIT_HOUR = 5;
    @MCKeep
    public static final int PERIOD_TYPE_UNIT_MONTH = 2;
    @MCKeep
    public static final int PERIOD_TYPE_UNIT_NONE = 0;
    @MCKeep
    public static final int PERIOD_TYPE_UNIT_WEEK = 3;
    @MCKeep
    public static final int PERIOD_TYPE_UNIT_YEAR = 1;
    @MCKeep
    public static final int PROXIMITY_FAR = 3;
    @MCKeep
    public static final int PROXIMITY_IMMEDIATE = 1;
    @MCKeep
    public static final int PROXIMITY_NEAR = 2;
    @MCKeep
    public static final int PROXIMITY_UNKNOWN = 0;

    /* renamed from: a */
    public static final int f3075a = 0;

    /* renamed from: b */
    public static final int f3076b = 1;

    /* renamed from: c */
    public static final int f3077c = 6;

    /* renamed from: d */
    public static final int f3078d = 0;

    /* renamed from: e */
    public static final int f3079e = 2;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static final String f3080f = C4039h.m2810a((Class<?>) Message.class);

    /* renamed from: g */
    private int f3081g;

    /* renamed from: h */
    private Date f3082h;

    /* renamed from: i */
    private int f3083i;

    /* renamed from: j */
    private int f3084j;

    /* renamed from: k */
    private Date f3085k;

    @MCKeep
    @Retention(RetentionPolicy.SOURCE)
    public @interface ContentType {
    }

    @AutoValue
    @SuppressLint({"UnknownNullness"})
    @MCKeep
    public static abstract class Media {
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Media create(String str, String str2) {
            if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                return new C4076b(str, str2);
            }
            throw new IllegalStateException("Invalid media provided.");
        }

        @Nullable
        public abstract String altText();

        @Nullable
        public abstract String url();
    }

    @MCKeep
    @Retention(RetentionPolicy.SOURCE)
    public @interface MessageType {
    }

    @MCKeep
    @Retention(RetentionPolicy.SOURCE)
    public @interface PeriodType {
    }

    @MCKeep
    @Retention(RetentionPolicy.SOURCE)
    public @interface Proximity {
    }

    @SuppressLint({"UnknownNullness"})
    @AutoValue.Builder
    /* renamed from: com.salesforce.marketingcloud.messages.Message$a */
    public static abstract class C4068a {
        /* renamed from: a */
        public abstract C4068a mo56623a(int i);

        /* renamed from: a */
        public abstract C4068a mo56624a(Media media);

        /* renamed from: a */
        public abstract C4068a mo56625a(String str);

        /* renamed from: a */
        public abstract C4068a mo56626a(Date date);

        /* renamed from: a */
        public abstract C4068a mo56627a(Map<String, String> map);

        /* renamed from: a */
        public abstract C4068a mo56628a(boolean z);

        /* renamed from: a */
        public abstract Message mo56629a();

        /* renamed from: b */
        public abstract C4068a mo56630b(int i);

        /* renamed from: b */
        public abstract C4068a mo56631b(String str);

        /* renamed from: b */
        public abstract C4068a mo56632b(Date date);

        /* renamed from: c */
        public abstract C4068a mo56633c(int i);

        /* renamed from: c */
        public abstract C4068a mo56634c(String str);

        /* renamed from: d */
        public abstract C4068a mo56635d(int i);

        /* renamed from: d */
        public abstract C4068a mo56636d(String str);

        /* renamed from: e */
        public abstract C4068a mo56637e(int i);

        /* renamed from: e */
        public abstract C4068a mo56638e(String str);

        /* renamed from: f */
        public abstract C4068a mo56639f(int i);

        /* renamed from: f */
        public abstract C4068a mo56640f(String str);

        /* renamed from: g */
        public abstract C4068a mo56641g(int i);

        /* renamed from: g */
        public abstract C4068a mo56642g(String str);
    }

    /* renamed from: com.salesforce.marketingcloud.messages.Message$b */
    static class C4069b implements JsonTypeAdapter<Media> {
        C4069b() {
        }

        /* renamed from: a */
        public Media mo56247b(JSONObject jSONObject, String str) {
            JSONObject optJSONObject = jSONObject.optJSONObject(str);
            if (optJSONObject == null) {
                return null;
            }
            try {
                return Media.create(optJSONObject.optString("androidUrl"), optJSONObject.optString("alt"));
            } catch (Exception e) {
                C4039h.m2830e(Message.f3080f, e, "Unable to create media object from json: ", optJSONObject);
                return null;
            }
        }

        /* renamed from: a */
        public void mo56245a(JSONObject jSONObject, String str, Media media) {
        }
    }

    /* renamed from: com.salesforce.marketingcloud.messages.Message$c */
    static class C4070c implements JsonTypeAdapter<List<Message>> {
        C4070c() {
        }

        /* renamed from: a */
        public final List<Message> mo56247b(JSONObject jSONObject, String str) {
            List<Message> emptyList = Collections.emptyList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int length = jSONArray.length();
                if (length <= 0) {
                    return emptyList;
                }
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < length; i++) {
                    try {
                        arrayList.add(Message.m2975b(jSONArray.getJSONObject(i)));
                    } catch (Exception e) {
                        try {
                            C4039h.m2827d(Message.f3080f, e, "Unable to create message", new Object[0]);
                        } catch (JSONException e2) {
                            e = e2;
                            emptyList = arrayList;
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e3) {
                e = e3;
                C4039h.m2830e(Message.f3080f, e, "Unable to read messages from json payload", new Object[0]);
                return emptyList;
            }
        }

        /* renamed from: a */
        public final void mo56245a(JSONObject jSONObject, String str, List<Message> list) {
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public static C4068a m2974a() {
        return new C$AutoValue_Message.C4066a();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: b */
    public static Message m2975b(@NonNull JSONObject jSONObject) {
        return C4075a.m3038a(jSONObject);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public final void mo56667a(int i) {
        this.f3081g = i;
    }

    @SuppressLint({"UnknownNullness"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public final void mo56668a(Date date) {
        this.f3082h = date;
    }

    @NonNull
    @MCKeep
    public abstract String alert();

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: b */
    public final void mo56669b(int i) {
        this.f3083i = i;
    }

    @SuppressLint({"UnknownNullness"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: b */
    public final void mo56670b(Date date) {
        this.f3085k = date;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: c */
    public final void mo56671c(int i) {
        this.f3084j = i;
    }

    @MCKeep
    public abstract int contentType();

    @Nullable
    @MCKeep
    public abstract String custom();

    @Nullable
    @MCKeep
    public abstract Map<String, String> customKeys();

    @Nullable
    @MCKeep
    public abstract Date endDateUtc();

    @Nullable
    @MCKeep
    public final Date getLastShownDate() {
        return this.f3085k;
    }

    @Nullable
    @MCKeep
    public final Date getNextAllowedShow() {
        return this.f3082h;
    }

    @MCKeep
    public final int getNotifyId() {
        return this.f3081g;
    }

    @MCKeep
    public final int getPeriodShowCount() {
        return this.f3084j;
    }

    @MCKeep
    public final int getShowCount() {
        return this.f3083i;
    }

    @NonNull
    @MCKeep
    /* renamed from: id */
    public abstract String mo56608id();

    @MCKeep
    public abstract boolean isRollingPeriod();

    @Nullable
    @MCKeep
    public abstract Media media();

    @MCKeep
    public abstract int messageLimit();

    @MCKeep
    public abstract int messageType();

    @MCKeep
    public abstract int messagesPerPeriod();

    @MCKeep
    public abstract int numberOfPeriods();

    @Nullable
    @MCKeep
    public abstract String openDirect();

    @MCKeep
    public abstract int periodType();

    @MCKeep
    public abstract int proximity();

    @Nullable
    @MCKeep
    public abstract String sound();

    @Nullable
    @MCKeep
    public abstract Date startDateUtc();

    @Nullable
    @MCKeep
    public abstract String title();

    @Nullable
    @MCKeep
    public abstract String url();
}
