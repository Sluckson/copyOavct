package com.salesforce.marketingcloud.notifications;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationManagerCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.salesforce.marketingcloud.C4037f;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.InitializationStatus;
import com.salesforce.marketingcloud.analytics.C3924l;
import com.salesforce.marketingcloud.notifications.NotificationManager;
import com.salesforce.marketingcloud.p020b.C3929a;
import com.salesforce.marketingcloud.p020b.C3931c;
import com.salesforce.marketingcloud.p022d.C4016h;
import com.salesforce.marketingcloud.p027e.C4028g;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.notifications.c */
public class C4108c extends NotificationManager implements C4037f {
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: a */
    public static final String f3301a = "com.salesforce.marketingcloud.notifications.OPENED";
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: b */
    public static final String f3302b = "com.salesforce.marketingcloud.notifications.EXTRA_OPEN_INTENT";
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: c */
    public static final String f3303c = "com.salesforce.marketingcloud.notifications.EXTRA_AUTO_CANCEL";
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: d */
    public static final int f3304d = -1;
    @VisibleForTesting

    /* renamed from: e */
    static final String f3305e = "com.marketingcloud.salesforce.notifications.TAG";
    @VisibleForTesting

    /* renamed from: f */
    static final String f3306f = "com.marketingcloud.salesforce.notifications.ENABLED";
    @VisibleForTesting

    /* renamed from: g */
    static final String f3307g = "notification_id_key";
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final String f3308j = C4039h.m2810a((Class<?>) C4108c.class);
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C4112d f3309k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Context f3310l;

    /* renamed from: m */
    private final C4016h f3311m;

    /* renamed from: n */
    private final Set<NotificationManager.NotificationMessageDisplayedListener> f3312n;

    /* renamed from: o */
    private final C3924l f3313o;

    /* renamed from: p */
    private NotificationManager.ShouldShowNotificationListener f3314p;

    /* renamed from: q */
    private BroadcastReceiver f3315q;

    /* renamed from: r */
    private boolean f3316r = true;

    /* renamed from: com.salesforce.marketingcloud.notifications.c$a */
    public interface C4110a {
        /* renamed from: a */
        void mo56730a(int i);
    }

    /* renamed from: com.salesforce.marketingcloud.notifications.c$b */
    private class C4111b extends BroadcastReceiver {
        private C4111b() {
        }

        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                C4039h.m2820b(C4108c.f3308j, "Received null intent", new Object[0]);
                return;
            }
            String action = intent.getAction();
            if (action == null) {
                C4039h.m2820b(C4108c.f3308j, "Received null action", new Object[0]);
                return;
            }
            char c = 65535;
            if (action.hashCode() == 441866220 && action.equals(C4108c.f3301a)) {
                c = 0;
            }
            if (c != 0) {
                C4039h.m2820b(C4108c.f3308j, "Received unknown action: %s", action);
                return;
            }
            C4108c.this.m3279a(context, (NotificationMessage) intent.getParcelableExtra(NotificationManager.f3287h), (PendingIntent) intent.getParcelableExtra(C4108c.f3302b), intent.getBooleanExtra(C4108c.f3303c, true));
        }
    }

    @VisibleForTesting
    C4108c(Context context, C4016h hVar, C4112d dVar, C3924l lVar) {
        this.f3310l = context;
        this.f3311m = hVar;
        this.f3309k = dVar;
        this.f3313o = (C3924l) C4028g.m2762a(lVar, "MessageAnalyticEventListener is null.");
        this.f3312n = new ArraySet();
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    public static C4108c m3277a(@NonNull Context context, @NonNull C4016h hVar, @NonNull NotificationCustomizationOptions notificationCustomizationOptions, @NonNull C3924l lVar) {
        return new C4108c(context, hVar, new C4112d(notificationCustomizationOptions.smallIconResId, notificationCustomizationOptions.launchIntentProvider, notificationCustomizationOptions.notificationBuilder, notificationCustomizationOptions.channelIdProvider), lVar);
    }

    /* renamed from: a */
    private void m3278a(@NonNull Context context) {
        if (this.f3311m != null) {
            NotificationManagerCompat from = NotificationManagerCompat.from(context);
            int i = this.f3311m.mo56532e().getInt(f3307g, -1);
            int i2 = 0;
            while (i >= 0 && i2 < 100) {
                from.cancel(f3305e, i);
                i--;
                i2++;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3279a(Context context, NotificationMessage notificationMessage, PendingIntent pendingIntent, boolean z) {
        this.f3313o.mo56259b(notificationMessage);
        if (pendingIntent != null) {
            try {
                pendingIntent.send();
            } catch (PendingIntent.CanceledException e) {
                C4039h.m2830e(f3308j, e, "Failed to send notification's open action PendingIntent.", new Object[0]);
            }
        }
        if (z) {
            NotificationManager.cancelNotificationMessage(context, notificationMessage);
        }
        context.sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
        Bundle bundle = new Bundle();
        bundle.putParcelable(NotificationManager.f3287h, notificationMessage);
        C3931c.m2333a(context, C3929a.BEHAVIOR_SDK_NOTIFICATION_OPENED, bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m3280a(NotificationMessage notificationMessage) {
        synchronized (this.f3312n) {
            if (!this.f3312n.isEmpty()) {
                for (NotificationManager.NotificationMessageDisplayedListener next : this.f3312n) {
                    if (next != null) {
                        try {
                            next.onNotificationMessageDisplayed(notificationMessage);
                        } catch (Exception e) {
                            C4039h.m2830e(f3308j, e, "%s threw an exception while processing notification message (%s)", next.getClass().getName(), notificationMessage.mo56835id());
                        }
                    }
                }
            }
        }
        try {
            this.f3313o.mo56253a(notificationMessage);
        } catch (Exception e2) {
            C4039h.m2830e(f3308j, e2, "Failed to log analytics for message displayed.", new Object[0]);
        }
    }

    /* renamed from: d */
    private void m3285d() {
        C4016h hVar = this.f3311m;
        if (hVar != null) {
            hVar.mo56532e().edit().putBoolean(f3306f, this.f3316r).apply();
        }
    }

    @Nullable
    /* renamed from: a */
    public final JSONObject mo56200a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("notificationsEnabled", areNotificationsEnabled());
            if (!this.f3312n.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (NotificationManager.NotificationMessageDisplayedListener next : this.f3312n) {
                    if (next != null) {
                        jSONArray.put(next.getClass().getName());
                    }
                }
                jSONObject.put("messageDisplayedListeners", jSONArray);
            }
            if (this.f3314p != null) {
                jSONObject.put("shouldShowNotificationListener", this.f3314p.getClass().getName());
            }
        } catch (JSONException e) {
            C4039h.m2830e(f3308j, e, "Unable to create component state for %s", mo56210b());
        }
        return jSONObject;
    }

    /* renamed from: a */
    public void mo56338a(int i) {
    }

    /* renamed from: a */
    public final void mo56339a(@NonNull InitializationStatus.C3832a aVar, int i) {
        this.f3316r = this.f3311m.mo56532e().getBoolean(f3306f, true);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(f3301a);
        this.f3315q = new C4111b();
        LocalBroadcastManager.getInstance(this.f3310l).registerReceiver(this.f3315q, intentFilter);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003d, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        return;
     */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo56887a(@androidx.annotation.NonNull com.salesforce.marketingcloud.notifications.NotificationMessage r9, @androidx.annotation.Nullable final com.salesforce.marketingcloud.notifications.C4108c.C4110a r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.areNotificationsEnabled()     // Catch:{ all -> 0x00cb }
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0020
            java.lang.String r0 = f3308j     // Catch:{ all -> 0x00cb }
            java.lang.String r4 = "Notifications are not enabled.  Message %s will not be displayed"
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x00cb }
            java.lang.String r9 = r9.mo56835id()     // Catch:{ all -> 0x00cb }
            r2[r3] = r9     // Catch:{ all -> 0x00cb }
            com.salesforce.marketingcloud.C4039h.m2820b(r0, r4, r2)     // Catch:{ all -> 0x00cb }
            if (r10 == 0) goto L_0x001e
            r10.mo56730a(r1)     // Catch:{ all -> 0x00cb }
        L_0x001e:
            monitor-exit(r8)
            return
        L_0x0020:
            java.lang.String r0 = r9.alert()     // Catch:{ all -> 0x00cb }
            java.lang.String r0 = r0.trim()     // Catch:{ all -> 0x00cb }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x003e
            java.lang.String r9 = f3308j     // Catch:{ all -> 0x00cb }
            java.lang.String r0 = "Notifications with not alert message are not shown."
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ all -> 0x00cb }
            com.salesforce.marketingcloud.C4039h.m2820b(r9, r0, r2)     // Catch:{ all -> 0x00cb }
            if (r10 == 0) goto L_0x003c
            r10.mo56730a(r1)     // Catch:{ all -> 0x00cb }
        L_0x003c:
            monitor-exit(r8)
            return
        L_0x003e:
            int r0 = r9.notificationId()     // Catch:{ all -> 0x00cb }
            if (r0 < 0) goto L_0x004b
            if (r10 == 0) goto L_0x0049
            r10.mo56730a(r1)     // Catch:{ all -> 0x00cb }
        L_0x0049:
            monitor-exit(r8)
            return
        L_0x004b:
            com.salesforce.marketingcloud.notifications.NotificationManager$ShouldShowNotificationListener r0 = r8.f3314p     // Catch:{ all -> 0x00cb }
            if (r0 == 0) goto L_0x0096
            r0 = 2
            com.salesforce.marketingcloud.notifications.NotificationManager$ShouldShowNotificationListener r4 = r8.f3314p     // Catch:{ Exception -> 0x007a }
            boolean r4 = r4.shouldShowNotification(r9)     // Catch:{ Exception -> 0x007a }
            if (r4 != 0) goto L_0x0096
            java.lang.String r4 = f3308j     // Catch:{ Exception -> 0x007a }
            java.lang.String r5 = "%s responded false to shouldShowNotification() for messageId: %s"
            java.lang.Object[] r6 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x007a }
            com.salesforce.marketingcloud.notifications.NotificationManager$ShouldShowNotificationListener r7 = r8.f3314p     // Catch:{ Exception -> 0x007a }
            java.lang.Class r7 = r7.getClass()     // Catch:{ Exception -> 0x007a }
            java.lang.String r7 = r7.getName()     // Catch:{ Exception -> 0x007a }
            r6[r3] = r7     // Catch:{ Exception -> 0x007a }
            java.lang.String r7 = r9.mo56835id()     // Catch:{ Exception -> 0x007a }
            r6[r2] = r7     // Catch:{ Exception -> 0x007a }
            com.salesforce.marketingcloud.C4039h.m2820b(r4, r5, r6)     // Catch:{ Exception -> 0x007a }
            if (r10 == 0) goto L_0x0078
            r10.mo56730a(r1)     // Catch:{ Exception -> 0x007a }
        L_0x0078:
            monitor-exit(r8)
            return
        L_0x007a:
            r1 = move-exception
            java.lang.String r4 = f3308j     // Catch:{ all -> 0x00cb }
            java.lang.String r5 = "%s threw an exception while processing shouldShowNotification() for messageId: %s"
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x00cb }
            com.salesforce.marketingcloud.notifications.NotificationManager$ShouldShowNotificationListener r6 = r8.f3314p     // Catch:{ all -> 0x00cb }
            java.lang.Class r6 = r6.getClass()     // Catch:{ all -> 0x00cb }
            java.lang.String r6 = r6.getName()     // Catch:{ all -> 0x00cb }
            r0[r3] = r6     // Catch:{ all -> 0x00cb }
            java.lang.String r6 = r9.mo56835id()     // Catch:{ all -> 0x00cb }
            r0[r2] = r6     // Catch:{ all -> 0x00cb }
            com.salesforce.marketingcloud.C4039h.m2830e(r4, r1, r5, r0)     // Catch:{ all -> 0x00cb }
        L_0x0096:
            com.salesforce.marketingcloud.d.h r0 = r8.f3311m     // Catch:{ all -> 0x00cb }
            android.content.SharedPreferences r0 = r0.mo56532e()     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = "notification_id_key"
            int r1 = r0.getInt(r1, r3)     // Catch:{ all -> 0x00cb }
            com.salesforce.marketingcloud.notifications.NotificationMessage r9 = r9.mo56879a((int) r1)     // Catch:{ all -> 0x00cb }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x00cb }
            java.lang.String r1 = "notification_id_key"
            int r4 = r9.notificationId()     // Catch:{ all -> 0x00cb }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 >= r5) goto L_0x00ba
            int r3 = r9.notificationId()     // Catch:{ all -> 0x00cb }
            int r3 = r3 + r2
        L_0x00ba:
            android.content.SharedPreferences$Editor r0 = r0.putInt(r1, r3)     // Catch:{ all -> 0x00cb }
            r0.apply()     // Catch:{ all -> 0x00cb }
            com.salesforce.marketingcloud.notifications.c$1 r0 = new com.salesforce.marketingcloud.notifications.c$1     // Catch:{ all -> 0x00cb }
            r0.<init>(r9, r10)     // Catch:{ all -> 0x00cb }
            r0.start()     // Catch:{ all -> 0x00cb }
            monitor-exit(r8)
            return
        L_0x00cb:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.salesforce.marketingcloud.notifications.C4108c.mo56887a(com.salesforce.marketingcloud.notifications.NotificationMessage, com.salesforce.marketingcloud.notifications.c$a):void");
    }

    /* renamed from: a */
    public final void mo56205a(boolean z) {
        if (z) {
            m3278a(this.f3310l);
        }
        Context context = this.f3310l;
        if (context != null) {
            LocalBroadcastManager.getInstance(context).unregisterReceiver(this.f3315q);
        }
    }

    public final synchronized boolean areNotificationsEnabled() {
        return this.f3316r;
    }

    @NonNull
    /* renamed from: b */
    public final String mo56210b() {
        return "NotificationManager";
    }

    public final synchronized void disableNotifications() {
        if (this.f3316r) {
            this.f3316r = false;
            m3285d();
        }
    }

    public final synchronized void enableNotifications() {
        if (!this.f3316r) {
            this.f3316r = true;
            m3285d();
        }
    }

    public final void registerNotificationMessageDisplayedListener(@NonNull NotificationManager.NotificationMessageDisplayedListener notificationMessageDisplayedListener) {
        if (notificationMessageDisplayedListener != null) {
            synchronized (this.f3312n) {
                this.f3312n.add(notificationMessageDisplayedListener);
            }
        }
    }

    public void setShouldShowNotificationListener(@Nullable NotificationManager.ShouldShowNotificationListener shouldShowNotificationListener) {
        this.f3314p = shouldShowNotificationListener;
    }

    public final void unregisterNotificationMessageDisplayedListener(@NonNull NotificationManager.NotificationMessageDisplayedListener notificationMessageDisplayedListener) {
        synchronized (this.f3312n) {
            this.f3312n.remove(notificationMessageDisplayedListener);
        }
    }
}
