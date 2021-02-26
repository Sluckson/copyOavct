package lib.android.paypal.com.magnessdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import java.util.HashMap;
import lib.android.paypal.com.magnessdk.MagnesSettings;
import lib.android.paypal.com.magnessdk.network.C4833a;
import lib.android.paypal.com.magnessdk.network.C4834b;
import lib.android.paypal.com.magnessdk.network.C4843h;
import lib.android.paypal.com.magnessdk.network.C4844i;
import lib.android.paypal.com.magnessdk.p059b.C4823a;
import org.json.JSONException;
import org.json.JSONObject;

public final class MagnesSDK {

    /* renamed from: c */
    private static final int f5500c = 32;

    /* renamed from: d */
    private static JSONObject f5501d;

    /* renamed from: e */
    private static MagnesSDK f5502e;

    /* renamed from: a */
    C4844i f5503a;

    /* renamed from: b */
    MagnesSettings f5504b;

    /* renamed from: f */
    private Handler f5505f;

    /* renamed from: g */
    private HandlerThread f5506g;

    private MagnesSDK() {
    }

    /* renamed from: a */
    private void m4640a() {
        if (this.f5506g == null) {
            this.f5506g = new HandlerThread("MagnesHandlerThread");
            this.f5506g.start();
            this.f5505f = C4843h.m4734a(this.f5506g.getLooper(), this);
        }
    }

    /* renamed from: a */
    private void m4641a(JSONObject jSONObject) {
        C4834b bVar = new C4834b(jSONObject, this.f5504b, this.f5505f);
        C4833a aVar = new C4833a(jSONObject, this.f5504b, this.f5505f);
        if (m4642b()) {
            aVar.mo68923b();
        }
        bVar.mo68923b();
    }

    /* renamed from: b */
    private boolean m4642b() {
        return !this.f5504b.isDisableBeacon() && this.f5504b.getEnvironment() == Environment.LIVE;
    }

    public static synchronized MagnesSDK getInstance() {
        MagnesSDK magnesSDK;
        synchronized (MagnesSDK.class) {
            if (f5502e == null) {
                f5502e = new MagnesSDK();
            }
            magnesSDK = f5502e;
        }
        return magnesSDK;
    }

    public MagnesResult collect(@NonNull Context context) {
        return collect(context, (String) null, (HashMap<String, String>) null);
    }

    public MagnesResult collect(@NonNull Context context, @Size(max = 32) @Nullable String str, @Nullable HashMap<String, String> hashMap) {
        Class<?> cls = getClass();
        StringBuilder sb = new StringBuilder();
        sb.append("COLLECT method called with paypalClientMetaDataId : ");
        sb.append(str);
        sb.append(" , Is pass in additionalData null? : ");
        sb.append(Boolean.toString(hashMap == null));
        C4823a.m4653a(cls, 0, sb.toString());
        if (this.f5504b == null) {
            C4823a.m4653a(getClass(), 2, "No MagnesSettings specified, using platform default.");
            this.f5504b = new MagnesSettings.Builder(context).build();
            setUp(this.f5504b);
        }
        C4832f b = C4832f.m4704b();
        b.mo68920a(context, str, hashMap);
        JSONObject a = b.mo68915a(f5501d);
        String str2 = null;
        try {
            Class<?> cls2 = getClass();
            C4823a.m4653a(cls2, 0, "Device Info JSONObject : " + a.toString(2));
            str2 = a.getString("pairing_id");
        } catch (JSONException e) {
            C4823a.m4654a(getClass(), 3, (Throwable) e);
        }
        return new MagnesResult().setDeviceInfo(a).setPaypalClientMetaDataId(str2);
    }

    public MagnesResult collectAndSubmit(@NonNull Context context) {
        return collectAndSubmit(context, (String) null, (HashMap<String, String>) null);
    }

    public MagnesResult collectAndSubmit(@NonNull Context context, @Size(max = 32) @Nullable String str, @Nullable HashMap<String, String> hashMap) {
        Class<?> cls = getClass();
        StringBuilder sb = new StringBuilder();
        sb.append("SUBMIT method called with paypalClientMetaDataId : ");
        sb.append(str);
        sb.append(" , Is pass in additionalData null? : ");
        sb.append(Boolean.toString(hashMap == null));
        C4823a.m4653a(cls, 0, sb.toString());
        MagnesResult collect = collect(context, str, hashMap);
        m4641a(collect.getDeviceInfo());
        return collect;
    }

    public MagnesSettings setUp(@NonNull MagnesSettings magnesSettings) {
        this.f5504b = magnesSettings;
        m4640a();
        this.f5503a = new C4844i(magnesSettings.getContext(), this.f5505f, magnesSettings.isDisableRemoteConfig());
        f5501d = C4829e.m4668b().mo68914a(magnesSettings.getContext());
        return magnesSettings;
    }
}
