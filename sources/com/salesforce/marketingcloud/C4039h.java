package com.salesforce.marketingcloud;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.gms.common.GoogleApiAvailability;
import com.salesforce.marketingcloud.p027e.C4036i;
import java.util.Locale;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.h */
public final class C4039h {

    /* renamed from: a */
    static final int f2934a = 23;

    /* renamed from: b */
    private static final String f2935b = m2811a("NULL");

    /* renamed from: c */
    private static final String f2936c = "████████-████-████-████-████████████";

    /* renamed from: d */
    private static final String f2937d = "███████████████████████";

    /* renamed from: e */
    private static final String f2938e = "████████";

    /* renamed from: f */
    private static String f2939f;

    /* renamed from: g */
    private static String f2940g;

    /* renamed from: h */
    private static String f2941h;

    /* renamed from: i */
    private static int f2942i = 6;

    /* renamed from: j */
    private static MCLogListener f2943j;

    private C4039h() {
    }

    /* renamed from: a */
    static int m2809a() {
        return f2942i;
    }

    /* renamed from: a */
    public static String m2810a(Class<?> cls) {
        return m2811a(cls.getSimpleName());
    }

    /* renamed from: a */
    public static String m2811a(String str) {
        return m2819b(m2812a("~!%s", str));
    }

    /* renamed from: a */
    private static String m2812a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    /* renamed from: a */
    static void m2813a(int i) {
        if (i < 2) {
            i = 2;
        }
        if (i > 6) {
            i = 6;
        }
        f2942i = i;
    }

    /* renamed from: a */
    private static void m2814a(int i, String str, Throwable th, String str2, Object... objArr) {
        MCLogListener mCLogListener = f2943j;
        if (mCLogListener != null && i >= f2942i) {
            try {
                String b = m2819b(str);
                if (objArr != null) {
                    if (objArr.length != 0) {
                        str2 = String.format(Locale.ENGLISH, str2, objArr);
                    }
                }
                mCLogListener.out(i, b, m2825d(str2), th);
            } catch (Exception e) {
                Log.e("~!Logger", String.format(Locale.ENGLISH, "Exception was thrown by %s", new Object[]{f2943j.getClass().getName()}), e);
            }
        }
    }

    /* renamed from: a */
    static void m2815a(MCLogListener mCLogListener) {
        f2943j = mCLogListener;
    }

    /* renamed from: a */
    static void m2816a(String str, String str2, String str3) {
        f2939f = str;
        f2940g = str2;
        f2941h = str3;
    }

    /* renamed from: a */
    public static void m2817a(@NonNull String str, @NonNull String str2, Object... objArr) {
        m2814a(2, str, (Throwable) null, str2, objArr);
    }

    /* renamed from: a */
    public static void m2818a(@NonNull String str, Throwable th, @NonNull String str2, Object... objArr) {
        m2814a(2, str, th, str2, objArr);
    }

    /* renamed from: b */
    private static String m2819b(String str) {
        return str == null ? f2935b : str.length() <= 23 ? str : str.substring(0, 23);
    }

    /* renamed from: b */
    public static void m2820b(@NonNull String str, @NonNull String str2, Object... objArr) {
        m2814a(3, str, (Throwable) null, str2, objArr);
    }

    /* renamed from: b */
    public static void m2821b(@NonNull String str, Throwable th, @NonNull String str2, Object... objArr) {
        m2814a(3, str, th, str2, objArr);
    }

    /* renamed from: c */
    private static String m2822c(String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder(str);
        sb.append("\nSdk Version: ");
        sb.append(C4036i.m2803a());
        try {
            sb.append("\nGoogle Play Services Version: ");
            sb.append(GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    /* renamed from: c */
    public static void m2823c(@NonNull String str, @NonNull String str2, Object... objArr) {
        m2814a(4, str, (Throwable) null, str2, objArr);
    }

    /* renamed from: c */
    public static void m2824c(@NonNull String str, Throwable th, @NonNull String str2, Object... objArr) {
        m2814a(4, str, th, str2, objArr);
    }

    /* renamed from: d */
    private static String m2825d(String str) {
        if (TextUtils.isEmpty(str)) {
            return m2828e(str);
        }
        String str2 = f2939f;
        if (str2 != null) {
            str = str.replaceAll(str2, f2936c);
        }
        String str3 = f2940g;
        if (str3 != null) {
            str = str.replaceAll(str3, f2937d);
        }
        String str4 = f2941h;
        return str4 != null ? str.replaceAll(str4, f2938e) : str;
    }

    /* renamed from: d */
    public static void m2826d(@NonNull String str, @NonNull String str2, Object... objArr) {
        m2814a(5, str, (Throwable) null, str2, objArr);
    }

    /* renamed from: d */
    public static void m2827d(@NonNull String str, Throwable th, @NonNull String str2, Object... objArr) {
        m2814a(5, str, th, str2, objArr);
    }

    /* renamed from: e */
    private static String m2828e(String str) {
        return str == null ? "Log message was `null`" : str.trim().length() == 0 ? "Log message was empty" : str;
    }

    /* renamed from: e */
    public static void m2829e(@NonNull String str, @NonNull String str2, Object... objArr) {
        m2814a(6, str, (Throwable) null, m2822c(str2), objArr);
    }

    /* renamed from: e */
    public static void m2830e(@NonNull String str, Throwable th, @NonNull String str2, Object... objArr) {
        m2814a(6, str, th, m2822c(str2), objArr);
    }
}
