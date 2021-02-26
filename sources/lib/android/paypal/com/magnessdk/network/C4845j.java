package lib.android.paypal.com.magnessdk.network;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import lib.android.paypal.com.magnessdk.p059b.C4823a;

/* renamed from: lib.android.paypal.com.magnessdk.network.j */
public final class C4845j extends C4841f {

    /* renamed from: b */
    private Context f5793b;

    /* renamed from: c */
    private Handler f5794c;

    public C4845j(Context context, Handler handler) {
        this.f5793b = context;
        this.f5794c = handler;
    }

    public void run() {
        C4823a.m4653a(getClass(), 0, "entering LoadRemoteConfigRequest.");
        Handler handler = this.f5794c;
        if (handler != null) {
            try {
                handler.sendMessage(Message.obtain(handler, 10, "https://www.paypalobjects.com/digitalassets/c/rda-magnes/magnes_config_android_v4.json"));
                this.f5794c.sendMessage(Message.obtain(this.f5794c, 12, new C4844i(this.f5793b)));
            } catch (Exception e) {
                C4823a.m4654a(getClass(), 3, (Throwable) e);
                Handler handler2 = this.f5794c;
                handler2.sendMessage(Message.obtain(handler2, 11, e));
            }
            C4823a.m4653a(getClass(), 0, "leaving LoadRemoteConfigRequest.");
        }
    }
}
