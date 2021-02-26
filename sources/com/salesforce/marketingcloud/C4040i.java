package com.salesforce.marketingcloud;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.app.job.JobWorkItem;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.salesforce.marketingcloud.messages.push.C4099a;
import com.salesforce.marketingcloud.p017a.C3872b;
import com.salesforce.marketingcloud.p020b.C3929a;
import com.salesforce.marketingcloud.p020b.C3931c;
import com.salesforce.marketingcloud.p021c.C3946e;
import com.salesforce.marketingcloud.p021c.C3949f;
import com.salesforce.marketingcloud.p021c.C3953g;
import com.salesforce.marketingcloud.p027e.C4029h;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.i */
public final class C4040i {

    /* renamed from: a */
    static final String f2944a = "com.salesforce.marketingcloud.HTTP_REQUEST";

    /* renamed from: b */
    static final String f2945b = "com.salesforce.marketingcloud.ALARM_WAKE";

    /* renamed from: c */
    static final String f2946c = "com.salesforce.marketingcloud.SYSTEM_BEHAVIOR";

    /* renamed from: d */
    static final String f2947d = "com.salesforce.marketingcloud.TOKEN_REQUEST";

    /* renamed from: e */
    private static final String f2948e = "behavior";

    /* renamed from: f */
    private static final String f2949f = "data";

    /* renamed from: g */
    private static final String f2950g = "alarmName";

    /* renamed from: h */
    private static final String f2951h = "senderId";

    /* renamed from: i */
    private static final int f2952i = 3000;

    /* renamed from: j */
    private static final String f2953j = C4039h.m2810a((Class<?>) C4040i.class);

    private C4040i() {
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        if (r0.equals(f2946c) != false) goto L_0x006c;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void m2831a(android.content.Context r7, android.content.Intent r8) {
        /*
            java.lang.String r0 = r8.getAction()
            r1 = 0
            if (r0 != 0) goto L_0x0011
            java.lang.String r7 = f2953j
            java.lang.Object[] r8 = new java.lang.Object[r1]
            java.lang.String r0 = "handleWorkFromJob - action was null"
            com.salesforce.marketingcloud.C4039h.m2820b(r7, r0, r8)
            return
        L_0x0011:
            java.lang.String r2 = f2953j
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r4[r1] = r0
            java.lang.String r5 = "handleWorkFromJob - %s"
            com.salesforce.marketingcloud.C4039h.m2820b(r2, r5, r4)
            boolean r2 = com.salesforce.marketingcloud.MarketingCloudSdk.isReady()
            if (r2 != 0) goto L_0x0033
            boolean r2 = com.salesforce.marketingcloud.MarketingCloudSdk.isInitializing()
            if (r2 != 0) goto L_0x0033
            java.lang.String r7 = f2953j
            java.lang.Object[] r8 = new java.lang.Object[r1]
            java.lang.String r0 = "MarketingCloudSdk#init must be called in your application's onCreate"
            com.salesforce.marketingcloud.C4039h.m2826d(r7, r0, r8)
            return
        L_0x0033:
            com.salesforce.marketingcloud.MarketingCloudSdk r2 = com.salesforce.marketingcloud.MarketingCloudSdk.getInstance()
            if (r2 == 0) goto L_0x00aa
            r2 = -1
            int r4 = r0.hashCode()
            r5 = 3
            r6 = 2
            switch(r4) {
                case -1341919505: goto L_0x0061;
                case -525195028: goto L_0x0057;
                case 352488053: goto L_0x004d;
                case 848031877: goto L_0x0044;
                default: goto L_0x0043;
            }
        L_0x0043:
            goto L_0x006b
        L_0x0044:
            java.lang.String r4 = "com.salesforce.marketingcloud.SYSTEM_BEHAVIOR"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L_0x006b
            goto L_0x006c
        L_0x004d:
            java.lang.String r1 = "com.salesforce.marketingcloud.HTTP_REQUEST"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r1 = 1
            goto L_0x006c
        L_0x0057:
            java.lang.String r1 = "com.salesforce.marketingcloud.TOKEN_REQUEST"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r1 = 3
            goto L_0x006c
        L_0x0061:
            java.lang.String r1 = "com.salesforce.marketingcloud.ALARM_WAKE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x006b
            r1 = 2
            goto L_0x006c
        L_0x006b:
            r1 = -1
        L_0x006c:
            if (r1 == 0) goto L_0x0097
            if (r1 == r3) goto L_0x0089
            if (r1 == r6) goto L_0x007f
            if (r1 == r5) goto L_0x0075
            goto L_0x00aa
        L_0x0075:
            java.lang.String r0 = "senderId"
            java.lang.String r8 = r8.getStringExtra(r0)
            m2840c(r7, r8)
            goto L_0x00aa
        L_0x007f:
            java.lang.String r0 = "alarmName"
            java.lang.String r8 = r8.getStringExtra(r0)
            m2841d(r7, r8)
            goto L_0x00aa
        L_0x0089:
            android.os.Bundle r8 = r8.getExtras()
            if (r8 == 0) goto L_0x00aa
            com.salesforce.marketingcloud.c.e r8 = com.salesforce.marketingcloud.p021c.C3946e.m2395a((android.os.Bundle) r8)
            m2838b((android.content.Context) r7, (com.salesforce.marketingcloud.p021c.C3946e) r8)
            goto L_0x00aa
        L_0x0097:
            java.lang.String r0 = "behavior"
            java.lang.String r0 = r8.getStringExtra(r0)
            com.salesforce.marketingcloud.b.a r0 = com.salesforce.marketingcloud.p020b.C3929a.m2331a(r0)
            java.lang.String r1 = "data"
            android.os.Bundle r8 = r8.getBundleExtra(r1)
            m2837b(r7, r0, r8)
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.C4040i.m2831a(android.content.Context, android.content.Intent):void");
    }

    /* renamed from: a */
    static void m2832a(@NonNull Context context, @NonNull C3929a aVar, @Nullable Bundle bundle) {
        C4039h.m2817a(f2953j, "enqueueSystemBehavior - %s", aVar);
        Bundle bundle2 = new Bundle();
        bundle2.putString(f2948e, aVar.f2465n);
        bundle2.putBundle("data", bundle);
        m2835a(context, f2946c, bundle2);
    }

    /* renamed from: a */
    public static void m2833a(@NonNull Context context, @NonNull C3946e eVar) {
        C4039h.m2817a(f2953j, "handleHttpRequest - %s", eVar.mo56381f());
        m2835a(context, f2944a, eVar.mo56410k());
    }

    /* renamed from: a */
    public static void m2834a(@NonNull Context context, String str) {
        C4039h.m2817a(f2953j, "enqueueAlarmWake - %s", str);
        Bundle bundle = new Bundle();
        bundle.putString(f2950g, str);
        m2835a(context, f2945b, bundle);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private static void m2835a(Context context, String str, Bundle bundle) {
        if (C4029h.m2772a()) {
            C4039h.m2820b(f2953j, "Handling %s with JobScheduler", str);
            ((JobScheduler) context.getApplicationContext().getSystemService("jobscheduler")).enqueue(new JobInfo.Builder(3000, new ComponentName(context, MCJobService.class)).setOverrideDeadline(0).build(), new JobWorkItem(new Intent(str).putExtras(bundle)));
            return;
        }
        Intent a = MCService.m2066a(context, str, bundle);
        if (a != null) {
            context.startService(a);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r1 = r1.getActiveNetworkInfo();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m2836a(android.content.Context r1) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r1 = r1.getSystemService(r0)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            if (r1 == 0) goto L_0x0018
            android.net.NetworkInfo r1 = r1.getActiveNetworkInfo()
            if (r1 == 0) goto L_0x0018
            boolean r1 = r1.isConnectedOrConnecting()
            if (r1 == 0) goto L_0x0018
            r1 = 1
            goto L_0x0019
        L_0x0018:
            r1 = 0
        L_0x0019:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.C4040i.m2836a(android.content.Context):boolean");
    }

    /* renamed from: b */
    private static void m2837b(Context context, C3929a aVar, Bundle bundle) {
        if (aVar == null) {
            C4039h.m2817a(f2953j, "Behavior was null", new Object[0]);
            return;
        }
        C4039h.m2817a(f2953j, "handleSystemBehavior - %s", aVar);
        C3931c.m2333a(context, aVar, bundle);
    }

    /* renamed from: b */
    private static void m2838b(Context context, C3946e eVar) {
        if (eVar == null) {
            C4039h.m2817a(f2953j, "request was null", new Object[0]);
            return;
        }
        C4039h.m2817a(f2953j, "handleHttpRequest - %s", eVar.mo56381f());
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(C3949f.f2545a).putExtra(C3949f.f2547c, eVar.mo56410k()).putExtra(C3949f.f2546b, m2836a(context) ? eVar.mo56411l() : C3953g.m2436a("No connectivity", -1)));
    }

    /* renamed from: b */
    public static void m2839b(@NonNull Context context, @NonNull String str) {
        C4039h.m2817a(f2953j, "enqueueTokenRequest", new Object[0]);
        Bundle bundle = new Bundle();
        bundle.putString("senderId", str);
        m2835a(context, f2947d, bundle);
    }

    @VisibleForTesting
    /* renamed from: c */
    static void m2840c(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            C4039h.m2820b(f2953j, "Unable to refresh system token.  SenderId was invalid", new Object[0]);
            return;
        }
        C4039h.m2817a(f2953j, "handlerTokenRequest", new Object[0]);
        String str2 = null;
        try {
            str2 = FirebaseInstanceId.getInstance().getToken(str, FirebaseMessaging.INSTANCE_ID_SCOPE);
        } catch (Exception e) {
            C4039h.m2830e(f2953j, e, "Failed to retrieve InstanceId from Firebase.", new Object[0]);
        } catch (Throwable th) {
            C4099a.m3203a(context, !TextUtils.isEmpty((CharSequence) null), str, (String) null);
            throw th;
        }
        C4099a.m3203a(context, !TextUtils.isEmpty(str2), str, str2);
    }

    /* renamed from: d */
    private static void m2841d(Context context, String str) {
        if (str == null) {
            C4039h.m2817a(f2953j, "alarm name not provided", new Object[0]);
            return;
        }
        C4039h.m2817a(f2953j, "handleAlarmWakeup - %s", str);
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(C3872b.f2241a).putExtra("com.salesforce.marketingcloud.WAKE_FOR_ALARM", str));
    }
}
