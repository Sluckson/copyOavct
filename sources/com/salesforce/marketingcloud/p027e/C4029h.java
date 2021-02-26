package com.salesforce.marketingcloud.p027e;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.C4039h;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p011io.sethclark.auto.value.json.JsonTypeAdapter;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.e.h */
public final class C4029h {

    /* renamed from: a */
    public static final Locale f2926a = Locale.US;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f2927b = C4039h.m2810a((Class<?>) C4029h.class);

    /* renamed from: c */
    private static final String f2928c = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /* renamed from: d */
    private static final String f2929d = "^|^";

    /* renamed from: e */
    private static final String f2930e = "\\^\\|\\^";

    /* renamed from: f */
    private static final char[] f2931f = "0123456789ABCDEF".toCharArray();

    /* renamed from: g */
    private static final TimeZone f2932g = TimeZone.getTimeZone("UTC");

    /* renamed from: h */
    private static Boolean f2933h;

    /* renamed from: com.salesforce.marketingcloud.e.h$a */
    public static final class C4030a implements JsonTypeAdapter<Date> {
        /* renamed from: a */
        public Date mo56247b(JSONObject jSONObject, String str) {
            try {
                return C4029h.m2770a(jSONObject.getString(str));
            } catch (Exception e) {
                C4039h.m2830e(C4029h.f2927b, e, "Unable to parse date from json payload", new Object[0]);
                return null;
            }
        }

        /* renamed from: a */
        public void mo56245a(JSONObject jSONObject, String str, Date date) {
            try {
                jSONObject.put(str, C4029h.m2766a(date));
            } catch (JSONException e) {
                C4039h.m2830e(C4029h.f2927b, e, "Unable to put date in json payload", new Object[0]);
            }
        }
    }

    /* renamed from: com.salesforce.marketingcloud.e.h$b */
    public static class C4031b implements JsonTypeAdapter<Map<String, String>> {
        /* renamed from: a */
        public Map<String, String> mo56247b(JSONObject jSONObject, String str) {
            Map<String, String> emptyMap = Collections.emptyMap();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                int length = jSONArray.length();
                if (length <= 0) {
                    return emptyMap;
                }
                HashMap hashMap = new HashMap(length);
                for (int i = 0; i < length; i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        hashMap.put(jSONObject2.getString("key"), jSONObject2.getString("value"));
                    } catch (JSONException e) {
                        try {
                            C4039h.m2830e(C4029h.f2927b, e, "Unable parse entry in list [%s]", str);
                        } catch (JSONException e2) {
                            e = e2;
                            emptyMap = hashMap;
                        }
                    }
                }
                return hashMap;
            } catch (JSONException e3) {
                e = e3;
                C4039h.m2830e(C4029h.f2927b, e, "Unable to read %s from json", str);
                return emptyMap;
            }
        }

        /* renamed from: a */
        public void mo56245a(JSONObject jSONObject, String str, Map<String, String> map) {
            if (map != null) {
                JSONArray jSONArray = new JSONArray();
                try {
                    if (!map.isEmpty()) {
                        for (Map.Entry next : map.entrySet()) {
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("key", next.getKey());
                                jSONObject2.put("value", next.getValue());
                                jSONArray.put(jSONObject2);
                            } catch (JSONException e) {
                                C4039h.m2830e(C4029h.f2927b, e, "Unable to add entry from %s map", str);
                            }
                        }
                    }
                    jSONObject.put(str, jSONArray);
                } catch (JSONException e2) {
                    C4039h.m2830e(C4029h.f2927b, e2, "Unable to add %s to json structure", str);
                }
            }
        }
    }

    /* renamed from: com.salesforce.marketingcloud.e.h$c */
    public static final class C4032c extends C4031b {
        /* renamed from: a */
        public void mo56245a(JSONObject jSONObject, String str, Map<String, String> map) {
            if (map != null) {
                super.mo56245a(jSONObject, str, (Map<String, String>) new TreeMap(map));
            }
        }
    }

    /* renamed from: com.salesforce.marketingcloud.e.h$d */
    public static class C4033d extends C4035f {
        /* renamed from: a */
        public void mo56245a(JSONObject jSONObject, String str, Set<String> set) {
            if (set != null) {
                super.mo56245a(jSONObject, str, (Set<String>) new TreeSet(set));
            }
        }
    }

    /* renamed from: com.salesforce.marketingcloud.e.h$e */
    public static final class C4034e implements JsonTypeAdapter<List<String>> {
        /* renamed from: a */
        public List<String> mo56247b(JSONObject jSONObject, String str) {
            ArrayList arrayList = new ArrayList();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    if (!TextUtils.isEmpty(string)) {
                        arrayList.add(string);
                    }
                }
            } catch (JSONException e) {
                C4039h.m2830e(C4029h.f2927b, e, "Failed to get Tags from JSON.", new Object[0]);
            }
            return arrayList;
        }

        /* renamed from: a */
        public void mo56245a(JSONObject jSONObject, String str, List<String> list) {
            try {
                if (!list.isEmpty()) {
                    jSONObject.put(str, new JSONArray(list));
                }
            } catch (JSONException e) {
                C4039h.m2830e(C4029h.f2927b, e, "Failed to convert Tags into JSONArray for Registration payload.", new Object[0]);
            }
        }
    }

    /* renamed from: com.salesforce.marketingcloud.e.h$f */
    public static class C4035f implements JsonTypeAdapter<Set<String>> {
        /* renamed from: a */
        public Set<String> mo56247b(JSONObject jSONObject, String str) {
            TreeSet treeSet = new TreeSet();
            try {
                JSONArray jSONArray = jSONObject.getJSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    String string = jSONArray.getString(i);
                    if (!TextUtils.isEmpty(string)) {
                        treeSet.add(string);
                    }
                }
            } catch (JSONException e) {
                C4039h.m2830e(C4029h.f2927b, e, "Failed to get Tags from JSON.", new Object[0]);
            }
            return treeSet;
        }

        /* renamed from: a */
        public void mo56245a(JSONObject jSONObject, String str, Set<String> set) {
            try {
                jSONObject.put(str, new JSONArray(set));
            } catch (JSONException e) {
                C4039h.m2830e(C4029h.f2927b, e, "Failed to convert Tags into JSONArray for Registration payload.", new Object[0]);
            }
        }
    }

    private C4029h() {
    }

    /* renamed from: a */
    private static String m2765a(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        try {
            MessageDigest instance = MessageDigest.getInstance(str2);
            byte[] bytes = str.getBytes(str3);
            instance.update(bytes, 0, bytes.length);
            return m2769a(instance.digest());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static String m2766a(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f2928c, f2926a);
        simpleDateFormat.setTimeZone(f2932g);
        return simpleDateFormat.format(date);
    }

    /* renamed from: a */
    public static String m2767a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return "";
        }
        HashMap hashMap = new HashMap(map);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : hashMap.entrySet()) {
            m2771a(sb, (String) entry.getKey(), (String) entry.getValue());
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static synchronized String m2768a(Set<String> set) {
        synchronized (C4029h.class) {
            if (set == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            for (String append : set) {
                sb.append(append);
                sb.append(f2929d);
            }
            String sb2 = sb.toString();
            return sb2;
        }
    }

    /* renamed from: a */
    private static String m2769a(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i] & 255;
            int i2 = i * 2;
            char[] cArr2 = f2931f;
            cArr[i2] = cArr2[b >>> 4];
            cArr[i2 + 1] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    /* renamed from: a */
    public static Date m2770a(String str) {
        if (str == null) {
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f2928c, f2926a);
        simpleDateFormat.setTimeZone(f2932g);
        return simpleDateFormat.parse(str);
    }

    /* renamed from: a */
    private static void m2771a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(f2929d);
        sb.append(str2);
        sb.append(f2929d);
    }

    /* renamed from: a */
    public static boolean m2772a() {
        return Build.VERSION.SDK_INT > 25 || "O".equals(Build.VERSION.CODENAME) || Build.VERSION.CODENAME.startsWith("OMR");
    }

    /* renamed from: a */
    public static boolean m2773a(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).targetSdkVersion >= 26;
        } catch (PackageManager.NameNotFoundException | NullPointerException e) {
            C4039h.m2830e(f2927b, e, "Unable to get application info to verify target SDK.", new Object[0]);
            return false;
        }
    }

    /* renamed from: b */
    public static int m2774b() {
        return TimeZone.getDefault().getOffset(new Date().getTime()) / 1000;
    }

    /* renamed from: b */
    public static String m2775b(String str) {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes();
            instance.update(bytes, 0, bytes.length);
            return new BigInteger(1, instance.digest()).toString(16);
        } catch (Throwable th) {
            C4039h.m2830e(f2927b, th, "md5 failed", new Object[0]);
            return "";
        }
    }

    /* renamed from: b */
    public static boolean m2776b(Context context) {
        if (f2933h == null) {
            try {
                Class.forName("android.app.ActivityThread").getMethod("currentPackageName", new Class[0]);
                String name = context.getApplicationContext().getClass().getName();
                String replace = name.replace("." + context.getApplicationContext().getClass().getSimpleName(), "");
                Field field = Class.forName(replace + ".BuildConfig").getField("DEBUG");
                field.setAccessible(true);
                f2933h = Boolean.valueOf(field.getBoolean((Object) null));
                C4039h.m2820b(f2927b, "Debug determined through reflection: %s", f2933h);
            } catch (Throwable th) {
                f2933h = Boolean.valueOf(m2779c(context));
                C4039h.m2820b(f2927b, "Debug determination failed with Exception [%s] and so set to: %s", th.getMessage(), f2933h);
            }
        }
        return f2933h.booleanValue();
    }

    /* renamed from: c */
    public static Map<String, String> m2778c(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(f2930e);
            for (int i = 0; i < split.length; i += 2) {
                int i2 = i + 1;
                hashMap.put(split[i], i2 < split.length ? split[i2] : "");
            }
        }
        return hashMap;
    }

    /* renamed from: c */
    private static boolean m2779c(Context context) {
        try {
            return (context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.flags & 2) != 0;
        } catch (PackageManager.NameNotFoundException unused) {
            C4039h.m2826d(f2927b, "Failed to determine if app was in debug mode.", new Object[0]);
        }
    }

    /* renamed from: d */
    public static Set<String> m2780d(String str) {
        TreeSet treeSet = new TreeSet();
        if (str != null && !TextUtils.isEmpty(str)) {
            for (String str2 : str.split(f2930e)) {
                if (str2 != null && !str2.isEmpty()) {
                    treeSet.add(str2);
                }
            }
        }
        return treeSet;
    }

    /* renamed from: e */
    static String m2781e(String str) {
        return m2765a(str, "SHA-256", "UTF-8");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: f */
    public static String m2782f(String str) {
        return m2765a(str, "MD5", "UTF-8");
    }
}
