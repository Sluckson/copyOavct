package com.salesforce.marketingcloud.p022d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.p022d.p023a.p024a.C3964a;
import com.salesforce.marketingcloud.p027e.C4022a;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.security.GeneralSecurityException;
import java.util.Locale;

@SuppressLint({"UnknownNullness"})
/* renamed from: com.salesforce.marketingcloud.d.c */
public interface C4007c {

    /* renamed from: a */
    public static final String f2874a = "mcsdk_custprefs_%s";

    /* renamed from: b */
    public static final String f2875b = "et_attributes_cache";

    /* renamed from: c */
    public static final String f2876c = "et_tags_cache";

    /* renamed from: d */
    public static final String f2877d = "et_subscriber_cache";

    /* renamed from: e */
    public static final String f2878e = "gcm_reg_id_key";

    /* renamed from: f */
    public static final String f2879f = "et_session_id_cache";

    /* renamed from: g */
    public static final String f2880g = "et_user_id_cache";

    /* renamed from: h */
    public static final String f2881h = "mc_last_sent_registration";

    /* renamed from: i */
    public static final String f2882i = "sender_id";

    /* renamed from: com.salesforce.marketingcloud.d.c$a */
    public static class C4008a implements C4007c {

        /* renamed from: j */
        private static final String f2883j = C4039h.m2810a((Class<?>) C4007c.class);

        /* renamed from: k */
        private final SharedPreferences f2884k;

        /* renamed from: l */
        private final C4022a f2885l;

        C4008a(@NonNull Context context, @NonNull C4022a aVar, @NonNull String str) {
            this.f2884k = context.getSharedPreferences(m2655b(str), 0);
            this.f2885l = aVar;
            m2656b();
        }

        /* renamed from: b */
        static String m2655b(String str) {
            return String.format(Locale.ENGLISH, C4007c.f2874a, new Object[]{str});
        }

        /* renamed from: b */
        private void m2656b() {
            if (this.f2884k.contains(C3964a.C3977g.C3978a.f2727q)) {
                this.f2884k.edit().remove(C3964a.C3977g.C3978a.f2727q).apply();
            }
        }

        /* renamed from: c */
        private void m2657c(@Size(min = 1) @NonNull String str, @NonNull String str2) {
            this.f2884k.edit().putString(str, this.f2885l.mo56544a(str2)).apply();
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
        @androidx.annotation.Nullable
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.lang.String m2658d(@androidx.annotation.Size(min = 1) @androidx.annotation.NonNull java.lang.String r6, java.lang.String r7) {
            /*
                r5 = this;
                android.content.SharedPreferences r0 = r5.f2884k
                r1 = 0
                java.lang.String r0 = r0.getString(r6, r1)
                if (r0 == 0) goto L_0x001e
                com.salesforce.marketingcloud.e.a r2 = r5.f2885l     // Catch:{ Exception -> 0x0010 }
                java.lang.String r6 = r2.mo56545b(r0)     // Catch:{ Exception -> 0x0010 }
                goto L_0x001f
            L_0x0010:
                r0 = move-exception
                java.lang.String r2 = f2883j
                r3 = 1
                java.lang.Object[] r3 = new java.lang.Object[r3]
                r4 = 0
                r3[r4] = r6
                java.lang.String r6 = "Failed to encrypt %s"
                com.salesforce.marketingcloud.C4039h.m2827d(r2, r0, r6, r3)
            L_0x001e:
                r6 = r1
            L_0x001f:
                if (r6 != 0) goto L_0x0022
                r6 = r7
            L_0x0022:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.p022d.C4007c.C4008a.m2658d(java.lang.String, java.lang.String):java.lang.String");
        }

        /* renamed from: a */
        public final void mo56520a() {
            this.f2884k.edit().clear().apply();
        }

        /* renamed from: a */
        public final void mo56521a(@Size(min = 1) @NonNull String str) {
            this.f2884k.edit().remove(str).apply();
        }

        /* renamed from: a */
        public final void mo56522a(String str, @NonNull String str2) {
            try {
                m2657c(str, str2);
            } catch (UnsupportedEncodingException | GeneralSecurityException e) {
                C4039h.m2826d(f2883j, String.format(Locale.ENGLISH, "Value for key %s not stored.", new Object[]{str}), e);
            }
        }

        @Nullable
        /* renamed from: b */
        public final String mo56523b(String str, String str2) {
            return m2658d(str, str2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.salesforce.marketingcloud.d.c$b */
    public @interface C4009b {
    }

    /* renamed from: a */
    void mo56520a();

    /* renamed from: a */
    void mo56521a(String str);

    /* renamed from: a */
    void mo56522a(String str, @NonNull String str2);

    @Nullable
    /* renamed from: b */
    String mo56523b(String str, String str2);
}
