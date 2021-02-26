package lib.android.paypal.com.magnessdk.network;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import com.salesforce.marketingcloud.p022d.p023a.C4002i;
import java.util.HashMap;
import java.util.Map;
import lib.android.paypal.com.magnessdk.C4818a;
import lib.android.paypal.com.magnessdk.MagnesSettings;
import lib.android.paypal.com.magnessdk.network.httpclient.MagnesNetworking;
import lib.android.paypal.com.magnessdk.p059b.C4823a;
import org.json.JSONObject;

/* renamed from: lib.android.paypal.com.magnessdk.network.a */
public final class C4833a extends C4841f {

    /* renamed from: b */
    private static final String f5714b = "pairing_id";

    /* renamed from: c */
    private static final String f5715c = "ip_addrs";

    /* renamed from: d */
    private static final int f5716d = 0;

    /* renamed from: e */
    private static final long f5717e = 1000;

    /* renamed from: f */
    private JSONObject f5718f;

    /* renamed from: g */
    private int f5719g;

    /* renamed from: h */
    private Map<String, String> f5720h = new HashMap();

    /* renamed from: i */
    private Handler f5721i;

    /* renamed from: j */
    private MagnesNetworkingFactoryImpl f5722j;

    /* renamed from: k */
    private MagnesSettings f5723k;

    public C4833a(JSONObject jSONObject, MagnesSettings magnesSettings, Handler handler) {
        this.f5719g = magnesSettings.getMagnesSource();
        this.f5718f = jSONObject;
        this.f5721i = handler;
        this.f5723k = magnesSettings;
        this.f5722j = magnesSettings.getMagnesNetworkingFactoryImpl() == null ? new MagnesNetworkingFactoryImpl() : magnesSettings.getMagnesNetworkingFactoryImpl();
    }

    /* renamed from: a */
    public void mo68922a() {
        this.f5720h.put("User-Agent", String.format("%s/%s/%s/%s/Android", new Object[]{this.f5718f.optString("app_id"), this.f5718f.optString(C4002i.C4003a.f2856q), this.f5718f.optString(C4002i.C4003a.f2856q), this.f5718f.optString("app_guid")}));
        this.f5720h.put("Accept-Language", "en-us");
    }

    /* renamed from: b */
    public void mo68923b() {
        if (this.f5723k.isEnableNetworkOnCallerThread()) {
            mo68924c();
        } else {
            mo68934d();
        }
    }

    /* renamed from: c */
    public void mo68924c() {
        try {
            mo68922a();
            StringBuilder sb = new StringBuilder(C4818a.f5513g);
            sb.append("?p=");
            sb.append(this.f5718f.optString(f5714b));
            sb.append("&i=");
            sb.append(this.f5718f.optString(f5715c));
            sb.append("&t=");
            sb.append(String.valueOf(System.currentTimeMillis() / 1000));
            if (this.f5719g == 0) {
                sb.append("&s=");
                sb.append(this.f5718f.optString("app_id"));
            } else {
                sb.append("&a=");
                sb.append(this.f5719g);
            }
            if (this.f5721i != null) {
                this.f5721i.sendMessage(Message.obtain(this.f5721i, 20, sb));
            }
            MagnesNetworking createHttpClient = this.f5722j.createHttpClient("GET");
            createHttpClient.setHeader(this.f5720h);
            createHttpClient.setUri(Uri.parse(sb.toString()));
            Class<?> cls = getClass();
            C4823a.m4653a(cls, 0, "Sending BeaconRequest : " + sb.toString());
            int execute = createHttpClient.execute((byte[]) null);
            if (execute == 200) {
                String str = new String(createHttpClient.getResponseContent(), "UTF-8");
                Class<?> cls2 = getClass();
                C4823a.m4653a(cls2, 0, "BeaconRequest returned HTTP" + execute + " ,responseString: " + str);
                if (this.f5721i != null) {
                    this.f5721i.sendMessage(Message.obtain(this.f5721i, 22, str));
                    return;
                }
                return;
            }
            if (this.f5721i != null) {
                Handler handler = this.f5721i;
                Handler handler2 = this.f5721i;
                handler.sendMessage(Message.obtain(handler2, 21, "Beacon return non-200 status code : " + execute));
            }
            Class<?> cls3 = getClass();
            C4823a.m4653a(cls3, 3, "BeaconRequest returned HTTP" + execute);
        } catch (Exception e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
            Handler handler3 = this.f5721i;
            if (handler3 != null) {
                handler3.sendMessage(Message.obtain(handler3, 21, "Beacon return non-200 status code : " + e));
            }
        }
    }

    public void run() {
        if (this.f5721i != null) {
            mo68924c();
        }
    }
}
