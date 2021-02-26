package com.salesforce.marketingcloud.messages.push;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.salesforce.marketingcloud.C4039h;
import com.salesforce.marketingcloud.C4040i;
import com.salesforce.marketingcloud.MarketingCloudSdk;

@SuppressLint({"UnknownNullness"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class MCFirebaseMessagingService extends FirebaseMessagingService {

    /* renamed from: a */
    private static final String f3230a = C4039h.m2810a((Class<?>) MCFirebaseMessagingService.class);

    /* renamed from: a */
    private static MarketingCloudSdk m3199a() {
        if (MarketingCloudSdk.isReady() || MarketingCloudSdk.isInitializing()) {
            return MarketingCloudSdk.getInstance();
        }
        C4039h.m2826d(f3230a, "MarketingCloudSdk#init must be called in your application's onCreate", new Object[0]);
        return null;
    }

    @VisibleForTesting
    /* renamed from: a */
    static void m3200a(@NonNull Context context) {
        MarketingCloudSdk a = m3199a();
        if (a == null) {
            C4039h.m2826d(f3230a, "Marketing Cloud SDK init failed.  Unable to update push token.", new Object[0]);
            return;
        }
        String senderId = a.getMarketingCloudConfig().senderId();
        if (senderId != null) {
            C4040i.m2839b(context, senderId);
        } else {
            C4039h.m2820b(f3230a, "Received new token intent but senderId was not set.", new Object[0]);
        }
    }

    @VisibleForTesting
    /* renamed from: a */
    static void m3201a(RemoteMessage remoteMessage) {
        if (remoteMessage != null) {
            C4039h.m2817a(f3230a, "onMessageReceived - %s", remoteMessage.getFrom());
            MarketingCloudSdk a = m3199a();
            if (a == null) {
                C4039h.m2826d(f3230a, "Marketing Cloud SDK init failed.  Push message ignored.", new Object[0]);
            } else {
                a.getPushMessageManager().handleMessage(remoteMessage);
            }
        }
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        m3201a(remoteMessage);
    }

    public void onNewToken(String str) {
        m3200a((Context) this);
    }
}
