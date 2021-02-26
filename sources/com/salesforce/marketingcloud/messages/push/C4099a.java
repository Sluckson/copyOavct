package com.salesforce.marketingcloud.messages.push;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.google.firebase.messaging.RemoteMessage;
import com.salesforce.marketingcloud.C3956d;
import com.salesforce.marketingcloud.C4037f;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.C4040i;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.messages.inbox.C4094c;
import com.salesforce.marketingcloud.messages.push.PushMessageManager;
import com.salesforce.marketingcloud.notifications.C4108c;
import com.salesforce.marketingcloud.notifications.NotificationMessage;
import com.salesforce.marketingcloud.p017a.C3848a;
import com.salesforce.marketingcloud.p017a.C3872b;
import com.salesforce.marketingcloud.p020b.C3929a;
import com.salesforce.marketingcloud.p020b.C3931c;
import com.salesforce.marketingcloud.p022d.C4007c;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p027e.C4028g;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.messages.push.a */
public class C4099a extends PushMessageManager implements C3872b.C3874a, C4037f {
    @VisibleForTesting

    /* renamed from: a */
    static final String f3236a = "et_push_enabled";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static final String f3237g = C4039h.m2810a((Class<?>) C4099a.class);

    /* renamed from: h */
    private static final String f3238h = "content-available";

    /* renamed from: i */
    private static final String f3239i = "_c";

    /* renamed from: j */
    private static final String f3240j = "_p";

    /* renamed from: k */
    private final Context f3241k;

    /* renamed from: l */
    private final C4108c f3242l;

    /* renamed from: m */
    private final C3872b f3243m;

    /* renamed from: n */
    private final Set<PushMessageManager.SilentPushListener> f3244n;

    /* renamed from: o */
    private final C4016h f3245o;

    /* renamed from: p */
    private final String f3246p;

    /* renamed from: q */
    private final Set<PushMessageManager.PushTokenRefreshListener> f3247q;

    /* renamed from: r */
    private int f3248r;

    /* renamed from: s */
    private BroadcastReceiver f3249s;

    /* renamed from: t */
    private boolean f3250t = false;

    /* renamed from: com.salesforce.marketingcloud.messages.push.a$a */
    private class C4101a extends BroadcastReceiver {
        private C4101a() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C4039h.m2817a(C4099a.f3237g, "Received null intent", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                C4039h.m2817a(C4099a.f3237g, "Received null action", new Object[0]);
                return;
            }
            char c = 65535;
            if (action.hashCode() == -558520539 && action.equals(PushMessageManager.f3231b)) {
                c = 0;
            }
            if (c != 0) {
                C4039h.m2820b(C4099a.f3237g, "Received unknown action: %s", action);
                return;
            }
            C4099a.this.m3204a(intent.getExtras());
        }
    }

    public C4099a(@NonNull Context context, @NonNull C4016h hVar, @NonNull C4108c cVar, @NonNull C3872b bVar, @Nullable String str) {
        this.f3241k = (Context) C4028g.m2762a(context, "Content is null");
        this.f3245o = (C4016h) C4028g.m2762a(hVar, "Storage is null");
        this.f3242l = (C4108c) C4028g.m2762a(cVar, "NotificationManager is null");
        this.f3243m = (C3872b) C4028g.m2762a(bVar, "AlarmScheduler is null");
        this.f3246p = str;
        this.f3244n = new ArraySet();
        this.f3247q = new ArraySet();
    }

    /* renamed from: a */
    private static Bundle m3202a(@NonNull Map<String, String> map) {
        Bundle bundle = new Bundle();
        if (!map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
        }
        return bundle;
    }

    /* renamed from: a */
    public static void m3203a(@NonNull Context context, boolean z, String str, String str2) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(PushMessageManager.f3231b).putExtra(PushMessageManager.f3232c, z).putExtra(PushMessageManager.f3233d, str).putExtra(PushMessageManager.f3235f, str2));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3204a(Bundle bundle) {
        C4007c d = this.f3245o.mo56531d();
        if (bundle.getBoolean(PushMessageManager.f3232c, false)) {
            String string = bundle.getString(PushMessageManager.f3235f, "");
            d.mo56522a(C4007c.f2878e, string);
            d.mo56522a(C4007c.f2882i, bundle.getString(PushMessageManager.f3233d, ""));
            m3206a(string);
            this.f3243m.mo56213c(C3848a.C3850a.FETCH_PUSH_TOKEN);
            m3207b(string);
            return;
        }
        d.mo56521a(C4007c.f2882i);
        this.f3243m.mo56211b(C3848a.C3850a.FETCH_PUSH_TOKEN);
    }

    /* renamed from: a */
    private void m3206a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(PushMessageManager.f3235f, str);
        C3931c.m2333a(this.f3241k, C3929a.BEHAVIOR_SDK_TOKEN_REFRESHED, bundle);
    }

    /* renamed from: b */
    private void m3207b(String str) {
        synchronized (this.f3247q) {
            for (PushMessageManager.PushTokenRefreshListener next : this.f3247q) {
                if (next != null) {
                    try {
                        next.onTokenRefreshed(str);
                    } catch (Exception e) {
                        C4039h.m2830e(f3237g, e, "%s threw an exception while processing the token refresh", next.getClass().getName());
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private boolean m3208b(Map<String, String> map) {
        if (C3956d.m2459b(this.f3248r, 4)) {
            C4039h.m2820b(f3237g, "Blocking push message.  Received a push message when the push feature is blocked.", new Object[0]);
            return true;
        } else if (!C3956d.m2459b(this.f3248r, 128) || !C4094c.m3158a(map)) {
            return false;
        } else {
            C4039h.m2820b(f3237g, "Blocking push message.  Received an inbox message when the inbox feature is blocked.", new Object[0]);
            return true;
        }
    }

    /* renamed from: c */
    private void m3210c(Map<String, String> map) {
        if (map != null && !m3208b(map)) {
            C3931c.m2333a(this.f3241k, C3929a.BEHAVIOR_SDK_PUSH_RECEIVED, m3202a(map));
            if (C3956d.m2458a(map)) {
                C4039h.m2817a(f3237g, "Control channel push received.", new Object[0]);
            } else if (!isPushEnabled()) {
                C4039h.m2820b(f3237g, "Push Messaging is disabled.  Ignoring message.", new Object[0]);
            } else if (map.containsKey(f3238h)) {
                m3212d(map);
            } else if (map.containsKey(f3239i)) {
                m3214e(map);
            } else {
                try {
                    NotificationMessage a = NotificationMessage.m3250a(map);
                    if (TextUtils.isEmpty(a.alert().trim())) {
                        C4039h.m2820b(f3237g, "Message (%s) was received but does not have an alert message.", a.mo56835id());
                        return;
                    }
                    this.f3242l.mo56887a(a, (C4108c.C4110a) null);
                } catch (Exception e) {
                    C4039h.m2830e(f3237g, e, "Unable to show push notification", new Object[0]);
                }
            }
        }
    }

    /* renamed from: d */
    private void m3211d() {
        this.f3249s = new C4101a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushMessageManager.f3231b);
        LocalBroadcastManager.getInstance(this.f3241k).registerReceiver(this.f3249s, intentFilter);
    }

    /* renamed from: d */
    private void m3212d(Map<String, String> map) {
        String str = map.get(f3238h);
        int i = 0;
        if (str != null) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Exception e) {
                C4039h.m2830e(f3237g, e, "Unable to parse content available flag: %s", str);
            }
        }
        if (i == 1) {
            m3216f(map);
        }
    }

    /* renamed from: e */
    private void m3213e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean(PushMessageManager.f3234e, this.f3250t);
        C3931c.m2333a(this.f3241k, C3929a.BEHAVIOR_CUSTOMER_PUSH_MESSAGING_TOGGLED, bundle);
    }

    /* renamed from: e */
    private void m3214e(Map<String, String> map) {
        map.remove(f3239i);
        map.remove(f3240j);
        m3216f(map);
    }

    /* renamed from: f */
    private void m3215f() {
        C4016h hVar = this.f3245o;
        if (hVar != null) {
            hVar.mo56532e().edit().putBoolean(f3236a, this.f3250t).apply();
        }
    }

    /* renamed from: f */
    private void m3216f(Map<String, String> map) {
        synchronized (this.f3244n) {
            for (PushMessageManager.SilentPushListener next : this.f3244n) {
                if (next != null) {
                    try {
                        next.silentPushReceived(map);
                    } catch (Exception e) {
                        C4039h.m2830e(f3237g, e, "%s threw an exception while processing the silent push message", next.getClass().getName());
                    }
                }
            }
        }
    }

    @Nullable
    /* renamed from: a */
    public JSONObject mo56200a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("pushEnabled", this.f3250t);
            synchronized (this.f3244n) {
                if (!this.f3244n.isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    for (PushMessageManager.SilentPushListener next : this.f3244n) {
                        if (next != null) {
                            jSONArray.put(next.getClass().getName());
                        }
                    }
                    jSONObject.put("silentPushListeners", jSONArray);
                }
            }
            synchronized (this.f3247q) {
                if (!this.f3247q.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (PushMessageManager.PushTokenRefreshListener next2 : this.f3247q) {
                        if (next2 != null) {
                            jSONArray2.put(next2.getClass().getName());
                        }
                    }
                    jSONObject.put("tokenRefreshListeners", jSONArray2);
                }
            }
            jSONObject.put("debugInfo", getPushDebugInfo());
        } catch (JSONException e) {
            C4039h.m2830e(f3237g, e, "Unable to create component state for $s", mo56210b());
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void mo56338a(int i) {
        if (C3956d.m2459b(i, 4)) {
            disablePush();
            if (this.f3249s != null) {
                LocalBroadcastManager.getInstance(this.f3241k).unregisterReceiver(this.f3249s);
            }
            this.f3243m.mo56206a(C3848a.C3850a.FETCH_PUSH_TOKEN);
            this.f3243m.mo56213c(C3848a.C3850a.FETCH_PUSH_TOKEN);
            if (C3956d.m2460c(i, 4)) {
                C4007c d = this.f3245o.mo56531d();
                d.mo56521a(C4007c.f2882i);
                d.mo56521a(C4007c.f2878e);
            }
            this.f3248r = i;
        } else if (C3956d.m2459b(this.f3248r, 4)) {
            this.f3248r = i;
            m3211d();
            this.f3243m.mo56203a((C3872b.C3874a) this, C3848a.C3850a.FETCH_PUSH_TOKEN);
            enablePush();
            String str = this.f3246p;
            if (str != null) {
                C4040i.m2839b(this.f3241k, str);
            }
        }
    }

    /* renamed from: a */
    public void mo56339a(@NonNull InitializationStatus.C3832a aVar, int i) {
        this.f3248r = i;
        if (C3956d.m2457a(i, 4)) {
            this.f3250t = this.f3245o.mo56532e().getBoolean(f3236a, true);
            m3211d();
            this.f3243m.mo56203a((C3872b.C3874a) this, C3848a.C3850a.FETCH_PUSH_TOKEN);
            String str = this.f3246p;
            if (str == null) {
                C4039h.m2820b(f3237g, "No sender id was provided during initialization.  You will not receive push messages until a token is manually set.", new Object[0]);
                this.f3243m.mo56213c(C3848a.C3850a.FETCH_PUSH_TOKEN);
                this.f3245o.mo56531d().mo56521a(C4007c.f2882i);
            } else if (!str.equals(this.f3245o.mo56531d().mo56523b(C4007c.f2882i, (String) null))) {
                C4039h.m2817a(f3237g, "Sender Id has changed.  Refresh system token.", new Object[0]);
                C4040i.m2839b(this.f3241k, this.f3246p);
            }
        }
    }

    /* renamed from: a */
    public void mo56216a(@NonNull C3848a.C3850a aVar) {
        String str;
        if (aVar == C3848a.C3850a.FETCH_PUSH_TOKEN && (str = this.f3246p) != null) {
            C4040i.m2839b(this.f3241k, str);
        }
    }

    /* renamed from: a */
    public void mo56205a(boolean z) {
        if (this.f3249s != null) {
            LocalBroadcastManager.getInstance(this.f3241k).unregisterReceiver(this.f3249s);
        }
    }

    @NonNull
    /* renamed from: b */
    public String mo56210b() {
        return "PushMessageManager";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void disablePush() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f3250t     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a
            int r0 = r2.f3248r     // Catch:{ all -> 0x001c }
            r1 = 4
            boolean r0 = com.salesforce.marketingcloud.C3956d.m2459b(r0, r1)     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x000f
            goto L_0x001a
        L_0x000f:
            r0 = 0
            r2.f3250t = r0     // Catch:{ all -> 0x001c }
            r2.m3213e()     // Catch:{ all -> 0x001c }
            r2.m3215f()     // Catch:{ all -> 0x001c }
            monitor-exit(r2)
            return
        L_0x001a:
            monitor-exit(r2)
            return
        L_0x001c:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.push.C4099a.disablePush():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void enablePush() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f3250t     // Catch:{ all -> 0x001c }
            if (r0 != 0) goto L_0x001a
            int r0 = r2.f3248r     // Catch:{ all -> 0x001c }
            r1 = 4
            boolean r0 = com.salesforce.marketingcloud.C3956d.m2459b(r0, r1)     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x000f
            goto L_0x001a
        L_0x000f:
            r0 = 1
            r2.f3250t = r0     // Catch:{ all -> 0x001c }
            r2.m3213e()     // Catch:{ all -> 0x001c }
            r2.m3215f()     // Catch:{ all -> 0x001c }
            monitor-exit(r2)
            return
        L_0x001a:
            monitor-exit(r2)
            return
        L_0x001c:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.messages.push.C4099a.enablePush():void");
    }

    @NonNull
    public JSONObject getPushDebugInfo() {
        try {
            return C4102b.m3226a(this.f3241k, this.f3246p, this.f3245o.mo56531d().mo56523b(C4007c.f2878e, (String) null));
        } catch (Exception e) {
            C4039h.m2830e(f3237g, e, "Unable to acquire push debug info.", new Object[0]);
            return new JSONObject();
        }
    }

    @Nullable
    public String getPushToken() {
        return this.f3245o.mo56531d().mo56523b(C4007c.f2878e, (String) null);
    }

    public boolean handleMessage(@NonNull RemoteMessage remoteMessage) {
        if (!isMarketingCloudPush(remoteMessage)) {
            C4039h.m2820b(f3237g, "Message was not sent from the Marketing Cloud.  Message ignored.", new Object[0]);
            return false;
        }
        m3210c(remoteMessage.getData());
        return true;
    }

    public boolean handleMessage(@NonNull Map<String, String> map) {
        if (!isMarketingCloudPush(map)) {
            C4039h.m2820b(f3237g, "Message was not sent from the Marketing Cloud.  Message ignored.", new Object[0]);
            return false;
        }
        m3210c(map);
        return true;
    }

    public synchronized boolean isPushEnabled() {
        return this.f3250t;
    }

    public void registerSilentPushListener(@NonNull PushMessageManager.SilentPushListener silentPushListener) {
        if (silentPushListener != null) {
            synchronized (this.f3244n) {
                this.f3244n.add(silentPushListener);
            }
        }
    }

    public void registerTokenRefreshListener(@NonNull PushMessageManager.PushTokenRefreshListener pushTokenRefreshListener) {
        if (pushTokenRefreshListener != null) {
            synchronized (this.f3247q) {
                this.f3247q.add(pushTokenRefreshListener);
            }
        }
    }

    public void setPushToken(@NonNull String str) {
        if (!C3956d.m2457a(this.f3248r, 4)) {
            return;
        }
        if (str == null) {
            C4039h.m2829e(f3237g, "Provided pushToken was null", new Object[0]);
            return;
        }
        if (this.f3246p != null) {
            C4039h.m2820b(f3237g, "Setting the SenderId during SDK initialization and setting the push token will cause conflicts in the system and could prevent the device from receiving push messages.", new Object[0]);
        }
        C4007c d = this.f3245o.mo56531d();
        d.mo56521a(C4007c.f2882i);
        d.mo56522a(C4007c.f2878e, str);
        this.f3243m.mo56213c(C3848a.C3850a.FETCH_PUSH_TOKEN);
        m3206a(str);
    }

    public void unregisterSilentPushListener(@NonNull PushMessageManager.SilentPushListener silentPushListener) {
        synchronized (this.f3244n) {
            this.f3244n.remove(silentPushListener);
        }
    }

    public void unregisterTokenRefreshListener(@NonNull PushMessageManager.PushTokenRefreshListener pushTokenRefreshListener) {
        synchronized (this.f3247q) {
            this.f3247q.remove(pushTokenRefreshListener);
        }
    }
}
