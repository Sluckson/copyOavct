package com.medallia.digital.mobilesdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;

/* renamed from: com.medallia.digital.mobilesdk.l3 */
class C3605l3 {

    /* renamed from: f */
    private static final int f1409f = 128;

    /* renamed from: g */
    private static final String f1410g = "LocalBroadcastManager";

    /* renamed from: h */
    private static final boolean f1411h = false;

    /* renamed from: i */
    static final int f1412i = 1;

    /* renamed from: j */
    private static final Object f1413j = new Object();

    /* renamed from: k */
    private static C3605l3 f1414k;

    /* renamed from: a */
    private final Context f1415a;

    /* renamed from: b */
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> f1416b = new HashMap<>();

    /* renamed from: c */
    private final HashMap<String, ArrayList<C3608c>> f1417c = new HashMap<>();

    /* renamed from: d */
    private final ArrayList<C3607b> f1418d = new ArrayList<>();

    /* renamed from: e */
    private final Handler f1419e;

    /* renamed from: com.medallia.digital.mobilesdk.l3$a */
    class C3606a extends Handler {
        C3606a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            if (message.what != 1) {
                super.handleMessage(message);
            } else {
                C3605l3.this.m1122a();
            }
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.l3$b */
    private static class C3607b {

        /* renamed from: a */
        final Intent f1421a;

        /* renamed from: b */
        final ArrayList<C3608c> f1422b;

        C3607b(Intent intent, ArrayList<C3608c> arrayList) {
            this.f1421a = intent;
            this.f1422b = arrayList;
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.l3$c */
    private static class C3608c {

        /* renamed from: a */
        final IntentFilter f1423a;

        /* renamed from: b */
        final BroadcastReceiver f1424b;

        /* renamed from: c */
        boolean f1425c;

        C3608c(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.f1423a = intentFilter;
            this.f1424b = broadcastReceiver;
        }

        public String toString() {
            return "Receiver{" + this.f1424b + " filter=" + this.f1423a + "}";
        }
    }

    private C3605l3(Context context) {
        this.f1415a = context;
        this.f1419e = new C3606a(context.getMainLooper());
    }

    /* renamed from: a */
    public static C3605l3 m1121a(Context context) {
        C3605l3 l3Var;
        synchronized (f1413j) {
            if (f1414k == null) {
                f1414k = new C3605l3(context.getApplicationContext());
            }
            l3Var = f1414k;
        }
        return l3Var;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r2 >= r1.length) goto L_0x0000;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r3 = r1[r2];
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        if (r4 >= r3.f1422b.size()) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002a, code lost:
        r3.f1422b.get(r4).f1424b.onReceive(r8.f1415a, r3.f1421a);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003e, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        r2 = 0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1122a() {
        /*
            r8 = this;
        L_0x0000:
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<android.content.IntentFilter>> r0 = r8.f1416b
            monitor-enter(r0)
            java.util.ArrayList<com.medallia.digital.mobilesdk.l3$b> r1 = r8.f1418d     // Catch:{ all -> 0x0041 }
            int r1 = r1.size()     // Catch:{ all -> 0x0041 }
            if (r1 > 0) goto L_0x000d
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            return
        L_0x000d:
            com.medallia.digital.mobilesdk.l3$b[] r1 = new com.medallia.digital.mobilesdk.C3605l3.C3607b[r1]     // Catch:{ all -> 0x0041 }
            java.util.ArrayList<com.medallia.digital.mobilesdk.l3$b> r2 = r8.f1418d     // Catch:{ all -> 0x0041 }
            r2.toArray(r1)     // Catch:{ all -> 0x0041 }
            java.util.ArrayList<com.medallia.digital.mobilesdk.l3$b> r2 = r8.f1418d     // Catch:{ all -> 0x0041 }
            r2.clear()     // Catch:{ all -> 0x0041 }
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            r0 = 0
            r2 = 0
        L_0x001c:
            int r3 = r1.length
            if (r2 >= r3) goto L_0x0000
            r3 = r1[r2]
            r4 = 0
        L_0x0022:
            java.util.ArrayList<com.medallia.digital.mobilesdk.l3$c> r5 = r3.f1422b
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x003e
            java.util.ArrayList<com.medallia.digital.mobilesdk.l3$c> r5 = r3.f1422b
            java.lang.Object r5 = r5.get(r4)
            com.medallia.digital.mobilesdk.l3$c r5 = (com.medallia.digital.mobilesdk.C3605l3.C3608c) r5
            android.content.BroadcastReceiver r5 = r5.f1424b
            android.content.Context r6 = r8.f1415a
            android.content.Intent r7 = r3.f1421a
            r5.onReceive(r6, r7)
            int r4 = r4 + 1
            goto L_0x0022
        L_0x003e:
            int r2 = r2 + 1
            goto L_0x001c
        L_0x0041:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0041 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3605l3.m1122a():void");
    }

    /* renamed from: a */
    public void mo55539a(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f1416b) {
            ArrayList remove = this.f1416b.remove(broadcastReceiver);
            if (remove != null) {
                for (int i = 0; i < remove.size(); i++) {
                    IntentFilter intentFilter = (IntentFilter) remove.get(i);
                    for (int i2 = 0; i2 < intentFilter.countActions(); i2++) {
                        String action = intentFilter.getAction(i2);
                        ArrayList arrayList = this.f1417c.get(action);
                        if (arrayList != null) {
                            int i3 = 0;
                            while (i3 < arrayList.size()) {
                                if (((C3608c) arrayList.get(i3)).f1424b == broadcastReceiver) {
                                    arrayList.remove(i3);
                                    i3--;
                                }
                                i3++;
                            }
                            if (arrayList.size() <= 0) {
                                this.f1417c.remove(action);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void mo55540a(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f1416b) {
            C3608c cVar = new C3608c(intentFilter, broadcastReceiver);
            ArrayList arrayList = this.f1416b.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                this.f1416b.put(broadcastReceiver, arrayList);
            }
            arrayList.add(intentFilter);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList arrayList2 = this.f1417c.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList(1);
                    this.f1417c.put(action, arrayList2);
                }
                arrayList2.add(cVar);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0171, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0173, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo55541a(android.content.Intent r22) {
        /*
            r21 = this;
            r1 = r21
            r0 = r22
            java.util.HashMap<android.content.BroadcastReceiver, java.util.ArrayList<android.content.IntentFilter>> r2 = r1.f1416b
            monitor-enter(r2)
            java.lang.String r10 = r22.getAction()     // Catch:{ all -> 0x0175 }
            android.content.Context r3 = r1.f1415a     // Catch:{ all -> 0x0175 }
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch:{ all -> 0x0175 }
            java.lang.String r11 = r0.resolveTypeIfNeeded(r3)     // Catch:{ all -> 0x0175 }
            android.net.Uri r12 = r22.getData()     // Catch:{ all -> 0x0175 }
            java.lang.String r13 = r22.getScheme()     // Catch:{ all -> 0x0175 }
            java.util.Set r14 = r22.getCategories()     // Catch:{ all -> 0x0175 }
            int r3 = r22.getFlags()     // Catch:{ all -> 0x0175 }
            r3 = r3 & 8
            if (r3 == 0) goto L_0x002c
            r16 = 1
            goto L_0x002e
        L_0x002c:
            r16 = 0
        L_0x002e:
            if (r16 == 0) goto L_0x0056
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r4.<init>()     // Catch:{ all -> 0x0175 }
            java.lang.String r5 = "Resolving type "
            r4.append(r5)     // Catch:{ all -> 0x0175 }
            r4.append(r11)     // Catch:{ all -> 0x0175 }
            java.lang.String r5 = " scheme "
            r4.append(r5)     // Catch:{ all -> 0x0175 }
            r4.append(r13)     // Catch:{ all -> 0x0175 }
            java.lang.String r5 = " of intent "
            r4.append(r5)     // Catch:{ all -> 0x0175 }
            r4.append(r0)     // Catch:{ all -> 0x0175 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0175 }
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x0175 }
        L_0x0056:
            java.util.HashMap<java.lang.String, java.util.ArrayList<com.medallia.digital.mobilesdk.l3$c>> r3 = r1.f1417c     // Catch:{ all -> 0x0175 }
            java.lang.String r4 = r22.getAction()     // Catch:{ all -> 0x0175 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0175 }
            r8 = r3
            java.util.ArrayList r8 = (java.util.ArrayList) r8     // Catch:{ all -> 0x0175 }
            if (r8 == 0) goto L_0x0172
            if (r16 == 0) goto L_0x007d
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r4.<init>()     // Catch:{ all -> 0x0175 }
            java.lang.String r5 = "Action list: "
            r4.append(r5)     // Catch:{ all -> 0x0175 }
            r4.append(r8)     // Catch:{ all -> 0x0175 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0175 }
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x0175 }
        L_0x007d:
            r3 = 0
            r6 = r3
            r7 = 0
        L_0x0080:
            int r3 = r8.size()     // Catch:{ all -> 0x0175 }
            if (r7 >= r3) goto L_0x0142
            java.lang.Object r3 = r8.get(r7)     // Catch:{ all -> 0x0175 }
            r5 = r3
            com.medallia.digital.mobilesdk.l3$c r5 = (com.medallia.digital.mobilesdk.C3605l3.C3608c) r5     // Catch:{ all -> 0x0175 }
            if (r16 == 0) goto L_0x00a7
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r4.<init>()     // Catch:{ all -> 0x0175 }
            java.lang.String r9 = "Matching against filter "
            r4.append(r9)     // Catch:{ all -> 0x0175 }
            android.content.IntentFilter r9 = r5.f1423a     // Catch:{ all -> 0x0175 }
            r4.append(r9)     // Catch:{ all -> 0x0175 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0175 }
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x0175 }
        L_0x00a7:
            boolean r3 = r5.f1425c     // Catch:{ all -> 0x0175 }
            if (r3 == 0) goto L_0x00c0
            if (r16 == 0) goto L_0x00b4
            java.lang.String r3 = "LocalBroadcastManager"
            java.lang.String r4 = "Filter's target already added"
            android.util.Log.v(r3, r4)     // Catch:{ all -> 0x0175 }
        L_0x00b4:
            r18 = r7
            r19 = r8
            r17 = r10
            r20 = r11
            r11 = 1
            r10 = r6
            goto L_0x0137
        L_0x00c0:
            android.content.IntentFilter r3 = r5.f1423a     // Catch:{ all -> 0x0175 }
            java.lang.String r9 = "LocalBroadcastManager"
            r4 = r10
            r15 = r5
            r5 = r11
            r17 = r10
            r10 = r6
            r6 = r13
            r18 = r7
            r7 = r12
            r19 = r8
            r8 = r14
            r20 = r11
            r11 = 1
            int r3 = r3.match(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0175 }
            if (r3 < 0) goto L_0x0105
            if (r16 == 0) goto L_0x00f6
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r5.<init>()     // Catch:{ all -> 0x0175 }
            java.lang.String r6 = "Filter matched! match=0x"
            r5.append(r6)     // Catch:{ all -> 0x0175 }
            java.lang.String r3 = java.lang.Integer.toHexString(r3)     // Catch:{ all -> 0x0175 }
            r5.append(r3)     // Catch:{ all -> 0x0175 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0175 }
            android.util.Log.v(r4, r3)     // Catch:{ all -> 0x0175 }
        L_0x00f6:
            if (r10 != 0) goto L_0x00fe
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ all -> 0x0175 }
            r6.<init>()     // Catch:{ all -> 0x0175 }
            goto L_0x00ff
        L_0x00fe:
            r6 = r10
        L_0x00ff:
            r6.add(r15)     // Catch:{ all -> 0x0175 }
            r15.f1425c = r11     // Catch:{ all -> 0x0175 }
            goto L_0x0138
        L_0x0105:
            if (r16 == 0) goto L_0x0137
            r4 = -4
            if (r3 == r4) goto L_0x011f
            r4 = -3
            if (r3 == r4) goto L_0x011c
            r4 = -2
            if (r3 == r4) goto L_0x0119
            r4 = -1
            if (r3 == r4) goto L_0x0116
            java.lang.String r3 = "unknown reason"
            goto L_0x0121
        L_0x0116:
            java.lang.String r3 = "type"
            goto L_0x0121
        L_0x0119:
            java.lang.String r3 = "data"
            goto L_0x0121
        L_0x011c:
            java.lang.String r3 = "action"
            goto L_0x0121
        L_0x011f:
            java.lang.String r3 = "category"
        L_0x0121:
            java.lang.String r4 = "LocalBroadcastManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0175 }
            r5.<init>()     // Catch:{ all -> 0x0175 }
            java.lang.String r6 = "Filter did not match: "
            r5.append(r6)     // Catch:{ all -> 0x0175 }
            r5.append(r3)     // Catch:{ all -> 0x0175 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0175 }
            android.util.Log.v(r4, r3)     // Catch:{ all -> 0x0175 }
        L_0x0137:
            r6 = r10
        L_0x0138:
            int r7 = r18 + 1
            r10 = r17
            r8 = r19
            r11 = r20
            goto L_0x0080
        L_0x0142:
            r10 = r6
            r11 = 1
            if (r10 == 0) goto L_0x0172
            r3 = 0
        L_0x0147:
            int r4 = r10.size()     // Catch:{ all -> 0x0175 }
            if (r3 >= r4) goto L_0x0159
            java.lang.Object r4 = r10.get(r3)     // Catch:{ all -> 0x0175 }
            com.medallia.digital.mobilesdk.l3$c r4 = (com.medallia.digital.mobilesdk.C3605l3.C3608c) r4     // Catch:{ all -> 0x0175 }
            r5 = 0
            r4.f1425c = r5     // Catch:{ all -> 0x0175 }
            int r3 = r3 + 1
            goto L_0x0147
        L_0x0159:
            java.util.ArrayList<com.medallia.digital.mobilesdk.l3$b> r3 = r1.f1418d     // Catch:{ all -> 0x0175 }
            com.medallia.digital.mobilesdk.l3$b r4 = new com.medallia.digital.mobilesdk.l3$b     // Catch:{ all -> 0x0175 }
            r4.<init>(r0, r10)     // Catch:{ all -> 0x0175 }
            r3.add(r4)     // Catch:{ all -> 0x0175 }
            android.os.Handler r0 = r1.f1419e     // Catch:{ all -> 0x0175 }
            boolean r0 = r0.hasMessages(r11)     // Catch:{ all -> 0x0175 }
            if (r0 != 0) goto L_0x0170
            android.os.Handler r0 = r1.f1419e     // Catch:{ all -> 0x0175 }
            r0.sendEmptyMessage(r11)     // Catch:{ all -> 0x0175 }
        L_0x0170:
            monitor-exit(r2)     // Catch:{ all -> 0x0175 }
            return r11
        L_0x0172:
            monitor-exit(r2)     // Catch:{ all -> 0x0175 }
            r0 = 0
            return r0
        L_0x0175:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0175 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.medallia.digital.mobilesdk.C3605l3.mo55541a(android.content.Intent):boolean");
    }

    /* renamed from: b */
    public void mo55542b(Intent intent) {
        if (mo55541a(intent)) {
            m1122a();
        }
    }
}
