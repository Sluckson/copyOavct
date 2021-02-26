package com.medallia.digital.mobilesdk;

import android.app.ActivityManager;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import java.util.Calendar;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.n0 */
class C3643n0 {
    C3643n0() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public ApplicationInfo mo55600a() {
        return C3595k3.m1060d().mo55513b().getApplicationInfo();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public Calendar mo55601b() {
        return Calendar.getInstance();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public ConnectivityManager mo55602c() {
        return (ConnectivityManager) C3595k3.m1060d().mo55513b().getSystemService("connectivity");
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public StatFs mo55603d() {
        return new StatFs(Environment.getDataDirectory().getPath());
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public Point mo55604e() {
        Display defaultDisplay;
        Point point = new Point();
        WindowManager windowManager = (WindowManager) C3595k3.m1060d().mo55513b().getSystemService("window");
        if (!(windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null)) {
            defaultDisplay.getSize(point);
        }
        return point;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public StatFs mo55605f() {
        return new StatFs(Environment.getExternalStorageDirectory().getPath());
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public Locale mo55606g() {
        return Locale.getDefault();
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public ActivityManager.MemoryInfo mo55607h() {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ActivityManager activityManager = (ActivityManager) C3595k3.m1060d().mo55513b().getSystemService("activity");
        if (activityManager != null) {
            activityManager.getMemoryInfo(memoryInfo);
        }
        return memoryInfo;
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public PackageManager mo55608i() {
        return C3595k3.m1060d().mo55513b().getPackageManager();
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public C3815z4 mo55609j() {
        return C3815z4.m2010d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public TelephonyManager mo55610k() {
        return (TelephonyManager) C3595k3.m1060d().mo55513b().getSystemService("phone");
    }
}
