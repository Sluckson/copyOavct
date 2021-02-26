package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.braintreepayments.api.models.BinData;
import com.iaai.android.old.utils.constants.Constants;
import com.medallia.digital.mobilesdk.C3697r0;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.w3 */
class C3771w3 extends C3603l1<String> {

    /* renamed from: g */
    private BroadcastReceiver f1981g = new C3772a();

    /* renamed from: com.medallia.digital.mobilesdk.w3$a */
    class C3772a extends BroadcastReceiver {
        C3772a() {
        }

        public void onReceive(Context context, Intent intent) {
            C3771w3.this.mo55330j();
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.w3$b */
    static /* synthetic */ class C3773b {

        /* renamed from: a */
        static final /* synthetic */ int[] f1983a = new int[C3774c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            /*
                com.medallia.digital.mobilesdk.w3$c[] r0 = com.medallia.digital.mobilesdk.C3771w3.C3774c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f1983a = r0
                int[] r0 = f1983a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.medallia.digital.mobilesdk.w3$c r1 = com.medallia.digital.mobilesdk.C3771w3.C3774c.TYPE_2G     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f1983a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.medallia.digital.mobilesdk.w3$c r1 = com.medallia.digital.mobilesdk.C3771w3.C3774c.TYPE_3G     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f1983a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.medallia.digital.mobilesdk.w3$c r1 = com.medallia.digital.mobilesdk.C3771w3.C3774c.TYPE_4G     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f1983a     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.medallia.digital.mobilesdk.w3$c r1 = com.medallia.digital.mobilesdk.C3771w3.C3774c.EDGE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r0 = f1983a     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.medallia.digital.mobilesdk.w3$c r1 = com.medallia.digital.mobilesdk.C3771w3.C3774c.Wifi     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r0 = f1983a     // Catch:{ NoSuchFieldError -> 0x004b }
                com.medallia.digital.mobilesdk.w3$c r1 = com.medallia.digital.mobilesdk.C3771w3.C3774c.f1989f     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r0 = f1983a     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.medallia.digital.mobilesdk.w3$c r1 = com.medallia.digital.mobilesdk.C3771w3.C3774c.f1990g     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3771w3.C3773b.<clinit>():void");
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.w3$c */
    protected enum C3774c {
        TYPE_2G,
        TYPE_3G,
        TYPE_4G,
        EDGE,
        Wifi,
        f1989f,
        f1990g;

        public String toString() {
            switch (C3773b.f1983a[ordinal()]) {
                case 1:
                    return "2G";
                case 2:
                    return "3G";
                case 3:
                    return "4G";
                case 4:
                    return "EDGE";
                case 5:
                    return "Wifi";
                case 6:
                    return Constants.STR_NONE;
                case 7:
                    return BinData.UNKNOWN;
                default:
                    return super.toString();
            }
        }
    }

    protected C3771w3(C3612m0 m0Var) {
        super(m0Var);
    }

    /* renamed from: a */
    private C3774c m1833a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return C3774c.TYPE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return C3774c.TYPE_3G;
            case 13:
                return C3774c.TYPE_4G;
            default:
                return C3774c.f1989f;
        }
    }

    /* renamed from: n */
    private boolean m1834n() {
        return C3595k3.m1060d().mo55513b().checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0;
    }

    /* renamed from: o */
    private C3774c m1835o() {
        ConnectivityManager c;
        if (!m1834n() || (c = this.f1405f.mo55602c()) == null) {
            return C3774c.f1990g;
        }
        NetworkInfo activeNetworkInfo = c.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                return C3774c.Wifi;
            }
            if (activeNetworkInfo.getType() == 0) {
                return m1836p();
            }
        }
        return C3774c.f1989f;
    }

    /* renamed from: p */
    private C3774c m1836p() {
        TelephonyManager k = this.f1405f.mo55610k();
        return k != null ? m1833a(k.getNetworkType()) : C3774c.f1989f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1772z;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public String m1839j() {
        C3774c o = m1835o();
        C3490e3.m661b(String.format(Locale.US, "Collectors > Network type : %s", new Object[]{o}));
        return o.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo55205l() {
        super.mo55205l();
        if (mo55530h()) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            C3595k3.m1060d().mo55513b().registerReceiver(this.f1981g, intentFilter);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public void mo55206m() {
        super.mo55206m();
        try {
            C3595k3.m1060d().mo55513b().unregisterReceiver(this.f1981g);
        } catch (Exception e) {
            C3490e3.m663c(e.getMessage());
        }
    }
}
