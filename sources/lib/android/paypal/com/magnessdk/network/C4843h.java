package lib.android.paypal.com.magnessdk.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
import lib.android.paypal.com.magnessdk.MagnesSDK;
import lib.android.paypal.com.magnessdk.p059b.C4823a;

/* renamed from: lib.android.paypal.com.magnessdk.network.h */
public final class C4843h extends Handler {

    /* renamed from: a */
    private static C4843h f5776a;

    /* renamed from: b */
    private WeakReference<MagnesSDK> f5777b;

    private C4843h(Looper looper, MagnesSDK magnesSDK) {
        super(looper);
        this.f5777b = new WeakReference<>(magnesSDK);
    }

    /* renamed from: a */
    public static synchronized C4843h m4734a(Looper looper, MagnesSDK magnesSDK) {
        C4843h hVar;
        synchronized (C4843h.class) {
            if (f5776a == null) {
                f5776a = new C4843h(looper, magnesSDK);
            }
            hVar = f5776a;
        }
        return hVar;
    }

    public void handleMessage(Message message) {
        String str;
        StringBuilder sb;
        Class<?> cls;
        String str2;
        StringBuilder sb2;
        Class<?> cls2;
        if (((MagnesSDK) this.f5777b.get()) != null) {
            int i = message.what;
            if (i != 0) {
                if (i == 1) {
                    cls2 = getClass();
                    sb2 = new StringBuilder();
                    str2 = "device info payload error. ";
                } else if (i != 2) {
                    switch (i) {
                        case 10:
                            cls = getClass();
                            sb = new StringBuilder();
                            str = "remote config started. fetching ";
                            break;
                        case 11:
                            cls2 = getClass();
                            sb2 = new StringBuilder();
                            str2 = "remote config error. ";
                            break;
                        case 12:
                            cls = getClass();
                            sb = new StringBuilder();
                            str = "remote config successed. ";
                            break;
                        default:
                            switch (i) {
                                case 20:
                                    cls = getClass();
                                    sb = new StringBuilder();
                                    str = "beacon started. ";
                                    break;
                                case 21:
                                    cls2 = getClass();
                                    sb2 = new StringBuilder();
                                    str2 = "beacon error. ";
                                    break;
                                case 22:
                                    cls = getClass();
                                    sb = new StringBuilder();
                                    str = "beacon successed. ";
                                    break;
                                default:
                                    return;
                            }
                    }
                } else {
                    cls = getClass();
                    sb = new StringBuilder();
                    str = "device info payload successed. ";
                }
                sb2.append(str2);
                sb2.append(message.obj);
                C4823a.m4653a(cls2, 3, sb2.toString());
                return;
            }
            cls = getClass();
            sb = new StringBuilder();
            str = "device info payload started. ";
            sb.append(str);
            sb.append(message.obj);
            C4823a.m4653a(cls, 0, sb.toString());
        }
    }
}
