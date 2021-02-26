package lib.android.paypal.com.magnessdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings;
import com.salesforce.marketingcloud.p022d.p023a.C4002i;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Properties;
import lib.android.paypal.com.magnessdk.p058a.C4820b;
import lib.android.paypal.com.magnessdk.p059b.C4823a;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: lib.android.paypal.com.magnessdk.e */
final class C4829e extends C4826d {

    /* renamed from: aL */
    private static C4829e f5624aL;

    /* renamed from: aJ */
    String f5625aJ;

    /* renamed from: aK */
    String f5626aK;

    /* renamed from: aM */
    private String f5627aM;

    /* renamed from: aN */
    private String f5628aN;

    /* renamed from: aO */
    private String f5629aO;

    /* renamed from: aP */
    private String f5630aP;

    /* renamed from: aQ */
    private String f5631aQ;

    /* renamed from: aR */
    private String f5632aR;

    /* renamed from: aS */
    private String f5633aS;

    /* renamed from: aT */
    private String f5634aT;

    /* renamed from: aU */
    private String f5635aU;

    /* renamed from: aV */
    private String f5636aV;

    /* renamed from: aW */
    private String f5637aW;

    /* renamed from: aX */
    private String f5638aX;

    /* renamed from: aY */
    private String f5639aY = "Android";

    /* renamed from: aZ */
    private int f5640aZ = -1;

    /* renamed from: ba */
    private boolean f5641ba;

    /* renamed from: bb */
    private boolean f5642bb;

    /* renamed from: bc */
    private boolean f5643bc;

    /* renamed from: bd */
    private boolean f5644bd;

    /* renamed from: be */
    private long f5645be;

    /* renamed from: bf */
    private long f5646bf;

    /* renamed from: bg */
    private long f5647bg;

    /* renamed from: bh */
    private JSONObject f5648bh;

    /* renamed from: lib.android.paypal.com.magnessdk.e$a */
    static final class C4830a {
        private C4830a() {
        }

        /* renamed from: a */
        static boolean m4681a() {
            return m4682b() || m4683c() || m4684d() || m4685e() || m4686f() || m4687g() || m4688h() || m4689i();
        }

        /* renamed from: b */
        private static boolean m4682b() {
            return Build.MANUFACTURER.equals("unknown") || Build.MANUFACTURER.equals("Genymotion") || Build.MANUFACTURER.contains("AndyOS");
        }

        /* renamed from: c */
        private static boolean m4683c() {
            return Build.BRAND.equals("generic") || Build.BRAND.equals("generic_x86") || Build.BRAND.equals("Android") || Build.BRAND.equals("AndyOS");
        }

        /* renamed from: d */
        private static boolean m4684d() {
            return Build.DEVICE.equals("AndyOSX") || Build.DEVICE.equals("Droid4X") || Build.DEVICE.equals("generic") || Build.DEVICE.equals("generic_x86") || Build.DEVICE.equals("vbox86p");
        }

        /* renamed from: e */
        private static boolean m4685e() {
            return Build.HARDWARE.equals("goldfish") || Build.HARDWARE.equals("vbox86") || Build.HARDWARE.equals("andy");
        }

        /* renamed from: f */
        private static boolean m4686f() {
            return Build.MODEL.equals("sdk") || Build.MODEL.equals("google_sdk") || Build.MODEL.equals("Android SDK built for x86");
        }

        /* renamed from: g */
        private static boolean m4687g() {
            return Build.FINGERPRINT.startsWith("generic");
        }

        /* renamed from: h */
        private static boolean m4688h() {
            return Build.PRODUCT.matches(".*_?sdk_?.*") || Build.PRODUCT.equals("vbox86p") || Build.PRODUCT.equals("Genymotion") || Build.PRODUCT.equals("Driod4X") || Build.PRODUCT.equals("AndyOSX");
        }

        /* renamed from: i */
        private static boolean m4689i() {
            return new File(Environment.getExternalStorageDirectory().toString() + File.separatorChar + "windows" + File.separatorChar + "BstSharedFolder").exists();
        }
    }

    /* renamed from: lib.android.paypal.com.magnessdk.e$b */
    static final class C4831b {
        private C4831b() {
        }

        /* renamed from: a */
        private static String m4690a(String str) {
            Properties properties = new Properties();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(C4820b.f5528h.getBytes("UTF-8"));
            try {
                properties.load(byteArrayInputStream);
            } catch (Exception e) {
                C4823a.m4654a((Class<?>) C4831b.class, 3, (Throwable) e);
            } catch (Throwable th) {
                byteArrayInputStream.close();
                throw th;
            }
            byteArrayInputStream.close();
            return properties.getProperty(str);
        }

        /* renamed from: a */
        static boolean m4691a() {
            return m4693c() || m4692b() || m4694d();
        }

        /* renamed from: b */
        private static boolean m4692b() {
            try {
                return new File(m4690a("suFileName")).exists();
            } catch (Exception e) {
                C4823a.m4654a((Class<?>) C4831b.class, 3, (Throwable) e);
                return false;
            }
        }

        /* renamed from: c */
        private static boolean m4693c() {
            return Build.TAGS != null && Build.TAGS.contains("test-keys");
        }

        /* renamed from: d */
        private static boolean m4694d() {
            try {
                return new File(m4690a("superUserApk")).exists();
            } catch (Exception e) {
                C4823a.m4654a((Class<?>) C4831b.class, 3, (Throwable) e);
                return false;
            }
        }
    }

    private C4829e() {
    }

    @SuppressLint({"HardwareIds"})
    /* renamed from: b */
    private String m4666b(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), C4820b.f5526f);
    }

    /* renamed from: b */
    private String m4667b(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(C4820b.f5523c, 0);
        String string = sharedPreferences.getString(C4820b.f5523c, "");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        if (str == null || str.equals(string)) {
            if (!string.equals("")) {
                return string;
            }
            str = C4825c.m4657a(Boolean.TRUE.booleanValue());
        }
        edit.putString(C4820b.f5523c, str);
        edit.apply();
        return str;
    }

    /* renamed from: b */
    static C4829e m4668b() {
        if (f5624aL == null) {
            f5624aL = new C4829e();
            C4823a.m4653a((Class<?>) C4829e.class, 0, "creating RiskBlobCoreData instance");
        }
        return f5624aL;
    }

    /* renamed from: c */
    private long m4669c() {
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
    }

    /* renamed from: c */
    private String m4670c(Context context) {
        Uri uri;
        Cursor query;
        try {
            uri = Uri.parse("content://com.google.android.gsf.gservices");
        } catch (Exception unused) {
            uri = null;
        }
        if (uri == null || !mo68917a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") || (query = context.getContentResolver().query(uri, (String[]) null, (String) null, new String[]{C4820b.f5526f}, (String) null)) == null) {
            return null;
        }
        try {
            if (query.moveToFirst()) {
                if (query.getColumnCount() >= 2) {
                    String hexString = Long.toHexString(Long.parseLong(query.getString(1)));
                    query.close();
                    return hexString;
                }
            }
            return null;
        } catch (NumberFormatException e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
            return null;
        } finally {
            query.close();
        }
    }

    @SuppressLint({"MissingPermission,HardwareIds"})
    /* renamed from: d */
    private String m4671d(Context context) {
        WifiInfo connectionInfo = mo68917a(context, "android.permission.ACCESS_WIFI_STATE") ? ((WifiManager) context.getApplicationContext().getSystemService("wifi")).getConnectionInfo() : null;
        if (connectionInfo == null) {
            return null;
        }
        return connectionInfo.getMacAddress();
    }

    /* renamed from: e */
    private JSONObject m4672e(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(C4820b.f5524d, 0);
        String string = sharedPreferences.getString(C4820b.f5524d, "");
        long j = sharedPreferences.getLong(C4820b.f5525e, 0);
        if (string.equals("") && j == 0) {
            string = C4825c.m4657a(Boolean.TRUE.booleanValue());
            j = System.currentTimeMillis();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(C4820b.f5524d, string);
            edit.putLong(C4820b.f5525e, j);
            edit.apply();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("id", string);
        hashMap.put("created_at", j + "");
        return mo68919a((HashMap<String, String>) hashMap);
    }

    /* renamed from: f */
    private String m4673f(Context context) {
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
    }

    /* renamed from: g */
    private long m4674g(Context context) {
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    /* renamed from: h */
    private long m4675h(Context context) {
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
    }

    /* renamed from: a */
    public JSONObject mo68913a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_guid", this.f5625aJ);
            jSONObject.put("app_id", this.f5626aK);
            jSONObject.put(C4820b.f5526f, this.f5631aQ);
            jSONObject.put(C4002i.C4003a.f2856q, this.f5627aM);
            jSONObject.put("app_first_install_time", this.f5646bf);
            jSONObject.put("app_last_update_time", this.f5647bg);
            jSONObject.put("conf_url", this.f5637aW);
            jSONObject.put("comp_version", this.f5638aX);
            jSONObject.put("device_model", this.f5628aN);
            jSONObject.put("device_name", this.f5629aO);
            jSONObject.put("gsf_id", this.f5632aR);
            jSONObject.put("is_emulator", this.f5643bc);
            jSONObject.put("is_rooted", this.f5644bd);
            jSONObject.put("os_type", this.f5639aY);
            jSONObject.put("os_version", this.f5630aP);
            jSONObject.put("payload_type", this.f5634aT);
            jSONObject.put("sms_enabled", this.f5642bb);
            jSONObject.put("mac_addrs", this.f5633aS);
            jSONObject.put("magnes_guid", this.f5648bh);
            jSONObject.put("magnes_source", this.f5640aZ);
            jSONObject.put("notif_token", this.f5636aV);
            jSONObject.put("source_app_version", this.f5635aU);
            jSONObject.put("total_storage_space", this.f5645be);
            return jSONObject;
        } catch (JSONException e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
            return jSONObject;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo68914a(Context context) {
        return mo68918a(context, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo68918a(Context context, boolean z) {
        if (!this.f5641ba) {
            C4823a.m4653a(getClass(), 0, "collecting RiskBlobCoreData");
            mo68916a(1, context);
            mo68916a(2, context);
            mo68916a(3, context);
            mo68916a(65, context);
            mo68916a(66, context);
            mo68916a(69, context);
            mo68916a(8, context);
            mo68916a(9, context);
            mo68916a(14, context);
            mo68916a(15, context);
            mo68916a(70, context);
            mo68916a(59, context);
            mo68916a(60, context);
            mo68916a(32, context);
            mo68916a(86, context);
            mo68916a(62, context);
            mo68916a(34, context);
            mo68916a(37, context);
            mo68916a(38, context);
            mo68916a(63, context);
            mo68916a(47, context);
            mo68916a(52, context);
            this.f5641ba = !z;
        }
        return mo68913a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public JSONObject mo68919a(HashMap<String, String> hashMap) {
        try {
            return new JSONObject("{\"id\":" + hashMap.get("id") + ",\"created_at\":" + hashMap.get("created_at") + "}");
        } catch (JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo68916a(int i, Context context) {
        if (i == 1) {
            this.f5625aJ = m4667b(context, MagnesSDK.getInstance().f5504b.getAppGuid());
        } else if (i == 2) {
            this.f5626aK = context.getPackageName();
        } else if (i == 3) {
            this.f5627aM = m4673f(context);
        } else if (i == 8) {
            this.f5638aX = C4818a.f5512f;
        } else if (i == 9) {
            this.f5637aW = "https://www.paypalobjects.com/digitalassets/c/rda-magnes/magnes_config_android_v4.json";
        } else if (i == 14) {
            this.f5628aN = Build.MODEL;
        } else if (i == 15) {
            this.f5629aO = Build.DEVICE;
        } else if (i == 32) {
            this.f5633aS = m4671d(context);
        } else if (i == 34) {
            this.f5636aV = MagnesSDK.getInstance().f5504b.getNotificationToken();
        } else if (i == 47) {
            this.f5642bb = context.getPackageManager().hasSystemFeature("android.hardware.telephony");
        } else if (i == 52) {
            this.f5645be = m4669c();
        } else if (i == 86) {
            this.f5648bh = m4672e(context);
        } else if (i == 37) {
            this.f5630aP = Build.VERSION.RELEASE;
        } else if (i == 38) {
            this.f5634aT = C4820b.f5527g;
        } else if (i == 59) {
            this.f5643bc = C4830a.m4681a();
        } else if (i == 60) {
            this.f5644bd = C4831b.m4691a();
        } else if (i == 62) {
            this.f5640aZ = MagnesSDK.getInstance().f5504b.getMagnesSource();
        } else if (i == 63) {
            this.f5635aU = m4673f(context);
        } else if (i == 65) {
            this.f5646bf = m4675h(context);
        } else if (i == 66) {
            this.f5647bg = m4674g(context);
        } else if (i == 69) {
            this.f5631aQ = m4666b(context);
        } else if (i == 70) {
            try {
                this.f5632aR = m4670c(context);
            } catch (Exception e) {
                C4823a.m4654a(getClass(), 3, (Throwable) e);
            }
        }
    }
}
