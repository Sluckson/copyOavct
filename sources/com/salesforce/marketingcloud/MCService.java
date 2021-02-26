package com.salesforce.marketingcloud;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.legacy.content.WakefulBroadcastReceiver;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.salesforce.marketingcloud.notifications.C4108c;
import java.util.concurrent.TimeUnit;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class MCService extends IntentService {
    @VisibleForTesting

    /* renamed from: a */
    public static final String f2152a = "com.salesforce.marketingcloud.NOTIFICATION_CLICKED";

    /* renamed from: b */
    private static final String f2153b = C4039h.m2810a((Class<?>) MCService.class);

    public MCService() {
        super(f2153b);
    }

    /* renamed from: a */
    public static final Intent m2065a(@NonNull Context context, @NonNull Bundle bundle) {
        return new Intent(context, MCService.class).setAction(f2152a).putExtras(bundle);
    }

    /* renamed from: a */
    static final Intent m2066a(@NonNull Context context, String str, Bundle bundle) {
        return new Intent(context, MCService.class).setAction(str).putExtras(bundle);
    }

    /* renamed from: b */
    private static void m2067b(Context context, Bundle bundle) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent(C4108c.f3301a).putExtras(bundle));
    }

    /* access modifiers changed from: protected */
    public final void onHandleIntent(Intent intent) {
        if (intent != null && intent.getAction() != null) {
            if (MarketingCloudSdk.isReady() || MarketingCloudSdk.isInitializing()) {
                PowerManager.WakeLock wakeLock = null;
                try {
                    PowerManager.WakeLock newWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, f2153b);
                    newWakeLock.acquire(TimeUnit.SECONDS.toMillis(30));
                    if (MarketingCloudSdk.getInstance() != null) {
                        String action = intent.getAction();
                        char c = 65535;
                        if (action.hashCode() == -556369808) {
                            if (action.equals(f2152a)) {
                                c = 0;
                            }
                        }
                        if (c != 0) {
                            C4040i.m2831a((Context) this, intent);
                        } else {
                            m2067b(getApplicationContext(), intent.getExtras());
                        }
                    }
                    if (newWakeLock != null && newWakeLock.isHeld()) {
                        newWakeLock.release();
                    }
                    if (WakefulBroadcastReceiver.completeWakefulIntent(intent)) {
                        C4039h.m2817a(f2153b, "Completing wakeful intent: %s", intent);
                    }
                } catch (Exception e) {
                    C4039h.m2830e(f2153b, e, "Encountered exception while handling action: %s", intent.getAction());
                    if (wakeLock != null && wakeLock.isHeld()) {
                        wakeLock.release();
                    }
                    if (WakefulBroadcastReceiver.completeWakefulIntent(intent)) {
                        C4039h.m2817a(f2153b, "Completing wakeful intent: %s", intent);
                    }
                } catch (Throwable th) {
                    if (wakeLock != null && wakeLock.isHeld()) {
                        wakeLock.release();
                    }
                    if (WakefulBroadcastReceiver.completeWakefulIntent(intent)) {
                        C4039h.m2817a(f2153b, "Completing wakeful intent: %s", intent);
                    }
                    throw th;
                }
            } else {
                C4039h.m2826d(f2153b, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
            }
        }
    }
}
