package lib.android.paypal.com.magnessdk.network;

import android.content.Context;
import android.os.Handler;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import lib.android.paypal.com.magnessdk.C4825c;
import lib.android.paypal.com.magnessdk.p058a.C4821c;
import lib.android.paypal.com.magnessdk.p059b.C4823a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: lib.android.paypal.com.magnessdk.network.i */
public final class C4844i {

    /* renamed from: a */
    private static final String f5778a = "CONFIG_TIME";

    /* renamed from: b */
    private static final String f5779b = "4.0";

    /* renamed from: c */
    private static final int f5780c = 1000;

    /* renamed from: d */
    private static final String f5781d = "CONFIG_DATA";

    /* renamed from: e */
    private static final String f5782e = "QW5kcm9pZE1hZ25lcw==";

    /* renamed from: f */
    private static final int f5783f = 3600;

    /* renamed from: g */
    private static final int f5784g = 1800;

    /* renamed from: h */
    private static final int f5785h = 86400;

    /* renamed from: i */
    private static final int f5786i = 500;

    /* renamed from: j */
    private static final int f5787j = 1800;

    /* renamed from: k */
    private static final String f5788k = "https://c.paypal.com/r/v1/device/client-metadata";

    /* renamed from: l */
    private Context f5789l;

    /* renamed from: m */
    private JSONObject f5790m;

    /* renamed from: n */
    private Handler f5791n;

    /* renamed from: o */
    private boolean f5792o = false;

    public C4844i(Context context) {
        this.f5789l = context;
        String f = m4739f();
        if (!f.isEmpty()) {
            mo68938a(f);
            this.f5790m = new JSONObject(f);
            return;
        }
        throw new IOException("no valid remote config found!");
    }

    public C4844i(Context context, Handler handler, boolean z) {
        this.f5789l = context;
        this.f5791n = handler;
        this.f5792o = z;
        this.f5790m = m4737d();
        try {
            C4823a.m4653a(getClass(), 0, this.f5790m.toString(2));
        } catch (JSONException unused) {
        }
    }

    /* renamed from: a */
    private boolean m4735a(String str, String str2) {
        C4823a.m4653a(getClass(), 0, "entering shouldUseCachedConfiguration");
        String[] split = str.split("\\.");
        String[] split2 = str2.split("\\.");
        Class<?> cls = getClass();
        C4823a.m4653a(cls, 0, "Comparing Cached version is " + str + " default version is " + str2);
        int i = 0;
        while (i < split.length && i < split2.length && split[i].equals(split2[i])) {
            i++;
        }
        return Integer.valueOf(Integer.signum((i >= split.length || i >= split2.length) ? split.length - split2.length : Integer.valueOf(split[i]).compareTo(Integer.valueOf(split2[i])))).intValue() >= 0;
    }

    /* renamed from: a */
    private boolean m4736a(JSONObject jSONObject) {
        return System.currentTimeMillis() > Long.parseLong(m4744k()) + (jSONObject.optLong("conf_refresh_time_interval", 0) * 1000);
    }

    /* renamed from: d */
    private JSONObject m4737d() {
        try {
            JSONObject g = m4740g();
            if (g == null) {
                m4738e();
            } else if (m4735a(g.optString("conf_version", ""), f5779b)) {
                boolean a = m4736a(g);
                if (!this.f5792o && a) {
                    m4738e();
                }
                Class<?> cls = getClass();
                C4823a.m4653a(cls, 0, "Using cached config due to isDisableRemoteConfig : " + this.f5792o + " or isConfigExpried : " + a);
                return g;
            } else {
                m4743j();
            }
        } catch (Exception e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
        }
        return m4741h();
    }

    /* renamed from: e */
    private void m4738e() {
        C4823a.m4653a(getClass(), 0, "entering fetchRemoteConfig");
        new C4845j(this.f5789l, this.f5791n).mo68934d();
    }

    /* renamed from: f */
    private String m4739f() {
        InputStream inputStream;
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            inputStream = FirebasePerfUrlConnection.openStream(new URL("https://www.paypalobjects.com/digitalassets/c/rda-magnes/magnes_config_android_v4.json"));
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            C4825c.m4658a(getClass(), (Closeable) inputStream);
                            C4825c.m4658a(getClass(), (Closeable) bufferedReader2);
                            C4823a.m4653a(getClass(), 0, "leaving getRemoteConfig successfully");
                            return sb.toString();
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        C4825c.m4658a(getClass(), (Closeable) inputStream);
                        C4825c.m4658a(getClass(), (Closeable) bufferedReader);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                C4825c.m4658a(getClass(), (Closeable) inputStream);
                C4825c.m4658a(getClass(), (Closeable) bufferedReader);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            C4825c.m4658a(getClass(), (Closeable) inputStream);
            C4825c.m4658a(getClass(), (Closeable) bufferedReader);
            throw th;
        }
    }

    /* renamed from: g */
    private JSONObject m4740g() {
        C4823a.m4653a(getClass(), 0, "entering getCachedConfiguration");
        try {
            String i = m4742i();
            if (!i.isEmpty()) {
                C4823a.m4653a(getClass(), 0, "leaving getCachedConfiguration,cached config load successfully");
                return new JSONObject(i);
            }
        } catch (Exception e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
        }
        C4823a.m4653a(getClass(), 0, "leaving getCachedConfiguration,cached config load failed");
        return null;
    }

    /* renamed from: h */
    private JSONObject m4741h() {
        C4823a.m4653a(getClass(), 0, "entering getDefaultRemoteConfig");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("conf_version", f5779b);
            jSONObject.put("async_update_time_interval", f5783f);
            jSONObject.put("forced_full_update_time_interval", 1800);
            jSONObject.put("conf_refresh_time_interval", f5785h);
            jSONObject.put("location_min_accuracy", 500);
            jSONObject.put("location_max_cache_age", 1800);
            jSONObject.put("endpoint_url", "https://c.paypal.com/r/v1/device/client-metadata");
        } catch (JSONException e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
        }
        return jSONObject;
    }

    /* renamed from: i */
    private String m4742i() {
        C4823a.m4653a(getClass(), 0, "Loading loadCachedConfigDataFromDisk");
        return C4821c.m4648a(new File(this.f5789l.getFilesDir(), f5781d));
    }

    /* renamed from: j */
    private boolean m4743j() {
        C4823a.m4653a(getClass(), 0, "entering deleteCachedConfigDataFromDisk");
        return C4821c.m4650b(new File(this.f5789l.getFilesDir(), f5781d)) && C4821c.m4650b(new File(this.f5789l.getFilesDir(), f5778a));
    }

    /* renamed from: k */
    private String m4744k() {
        return C4821c.m4648a(new File(this.f5789l.getFilesDir(), f5778a));
    }

    /* renamed from: a */
    public String mo68937a() {
        return this.f5790m.optString("conf_version", "");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo68938a(String str) {
        C4823a.m4653a(getClass(), 0, "entering saveConfigDataToDisk");
        File file = new File(this.f5789l.getFilesDir(), f5781d);
        File file2 = new File(this.f5789l.getFilesDir(), f5778a);
        C4821c.m4649a(file, str);
        C4821c.m4649a(file2, String.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: b */
    public List<String> mo68939b() {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = this.f5790m.optJSONArray("android_apps_to_check");
        int i = 0;
        while (optJSONArray != null && i < optJSONArray.length()) {
            arrayList.add(optJSONArray.getString(i));
            i++;
        }
        return arrayList;
    }

    /* renamed from: c */
    public String mo68940c() {
        return this.f5790m.optString("m", f5782e);
    }
}
