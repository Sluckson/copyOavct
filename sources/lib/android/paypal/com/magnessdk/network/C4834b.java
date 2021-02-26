package lib.android.paypal.com.magnessdk.network;

import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import lib.android.paypal.com.magnessdk.C4818a;
import lib.android.paypal.com.magnessdk.Environment;
import lib.android.paypal.com.magnessdk.MagnesSettings;
import lib.android.paypal.com.magnessdk.network.httpclient.MagnesNetworking;
import lib.android.paypal.com.magnessdk.p059b.C4823a;
import org.json.JSONObject;
import p052cz.msebera.android.httpclient.client.utils.URLEncodedUtils;

/* renamed from: lib.android.paypal.com.magnessdk.network.b */
public final class C4834b extends C4841f {

    /* renamed from: b */
    private static final String f5724b = "Dyson/%S (%S %S)";

    /* renamed from: c */
    private HashMap<String, String> f5725c;

    /* renamed from: d */
    private Map<String, String> f5726d;

    /* renamed from: e */
    private Handler f5727e;

    /* renamed from: f */
    private MagnesNetworkingFactoryImpl f5728f;

    /* renamed from: g */
    private MagnesSettings f5729g;

    /* renamed from: h */
    private String f5730h = "****MAGNES DEBUGGING MESSAGE****";

    public C4834b(JSONObject jSONObject, MagnesSettings magnesSettings, Handler handler) {
        this.f5728f = magnesSettings.getMagnesNetworkingFactoryImpl() == null ? new MagnesNetworkingFactoryImpl() : magnesSettings.getMagnesNetworkingFactoryImpl();
        this.f5725c = new HashMap<>();
        this.f5726d = new HashMap();
        this.f5727e = handler;
        this.f5729g = magnesSettings;
        this.f5725c.put("appGuid", jSONObject.optString("app_guid"));
        this.f5725c.put("libraryVersion", m4720a(jSONObject));
        this.f5725c.put("additionalData", jSONObject.toString());
    }

    /* renamed from: a */
    private String m4719a(HashMap<String, String> hashMap) {
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry next : hashMap.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode((String) next.getKey(), "UTF-8"));
            sb.append("=");
            sb.append(URLEncoder.encode((String) next.getValue(), "UTF-8"));
        }
        Class<?> cls = getClass();
        C4823a.m4653a(cls, 0, "encoded device info payload : " + sb.toString());
        return sb.toString();
    }

    /* renamed from: a */
    private String m4720a(JSONObject jSONObject) {
        return String.format(Locale.US, f5724b, new Object[]{jSONObject.optString("comp_version"), jSONObject.optString("os_type"), Build.VERSION.RELEASE});
    }

    /* renamed from: a */
    public void mo68922a() {
        this.f5726d.put("X-PAYPAL-RESPONSE-DATA-FORMAT", "NV");
        this.f5726d.put("X-PAYPAL-REQUEST-DATA-FORMAT", "NV");
        this.f5726d.put("X-PAYPAL-SERVICE-VERSION", "1.0.0");
        this.f5726d.put("Content-Type", URLEncodedUtils.CONTENT_TYPE);
    }

    /* renamed from: b */
    public void mo68923b() {
        if (this.f5729g.isEnableNetworkOnCallerThread()) {
            mo68924c();
        } else {
            mo68934d();
        }
    }

    /* renamed from: c */
    public void mo68924c() {
        mo68922a();
        try {
            MagnesNetworking createHttpClient = this.f5728f.createHttpClient("POST");
            Handler handler = this.f5727e;
            String str = C4818a.f5514h;
            if (handler != null) {
                if (this.f5729g.getEnvironment() == Environment.LIVE) {
                    this.f5727e.sendMessage(Message.obtain(this.f5727e, 0, str));
                } else {
                    this.f5727e.sendMessage(Message.obtain(this.f5727e, 0, C4818a.f5516j));
                    str = C4818a.f5516j;
                }
            }
            createHttpClient.setUri(Uri.parse(str));
            createHttpClient.setHeader(this.f5726d);
            int execute = createHttpClient.execute(m4719a(this.f5725c).getBytes("UTF-8"));
            String str2 = this.f5730h;
            Log.d(str2, "DeviceInfoRequest returned PayPal-Debug-Id: " + createHttpClient.getPayPalDebugId());
            if (execute == 200) {
                String str3 = new String(createHttpClient.getResponseContent(), "UTF-8");
                if (this.f5727e != null) {
                    this.f5727e.sendMessage(Message.obtain(this.f5727e, 2, str3));
                }
                Class<?> cls = getClass();
                C4823a.m4653a(cls, 0, "DeviceInfoRequest returned HTTP" + execute + " ,responseString: " + str3);
                return;
            }
            if (this.f5727e != null) {
                this.f5727e.sendMessage(Message.obtain(this.f5727e, 1, Integer.valueOf(execute)));
            }
            Class<?> cls2 = getClass();
            C4823a.m4653a(cls2, 3, "DeviceInfoRequest returned HTTP" + execute);
        } catch (Exception e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
            Handler handler2 = this.f5727e;
            if (handler2 != null) {
                handler2.sendMessage(Message.obtain(handler2, 1, e));
            }
        }
    }

    public void run() {
        if (this.f5727e != null) {
            mo68924c();
        }
    }
}
