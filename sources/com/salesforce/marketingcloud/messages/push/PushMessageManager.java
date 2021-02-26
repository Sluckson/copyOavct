package com.salesforce.marketingcloud.messages.push;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.firebase.messaging.RemoteMessage;
import com.salesforce.marketingcloud.MCKeep;
import java.util.Map;
import org.json.JSONObject;

public abstract class PushMessageManager {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: b */
    public static final String f3231b = "com.salesforce.marketingcloud.messages.push.TOKEN_REFRESHED";
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: c */
    public static final String f3232c = "com.salesforce.marketingcloud.push.TOKEN_REFRESH_SUCCESSFUL";
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: d */
    public static final String f3233d = "com.salesforce.marketingcloud.push.TOKEN_SENDER_ID";
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: e */
    public static final String f3234e = "com.salesforce.marketingcloud.notifications.PUSH_ENABLED";
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: f */
    public static final String f3235f = "com.salesforce.marketingcloud.push.TOKEN";

    @MCKeep
    public interface PushTokenRefreshListener {
        void onTokenRefreshed(@Nullable String str);
    }

    @MCKeep
    public interface SilentPushListener {
        void silentPushReceived(@NonNull Map<String, String> map);
    }

    @MCKeep
    public static boolean isMarketingCloudPush(@NonNull RemoteMessage remoteMessage) {
        return remoteMessage != null && isMarketingCloudPush(remoteMessage.getData());
    }

    @MCKeep
    public static boolean isMarketingCloudPush(@NonNull Map<String, String> map) {
        return map != null && "SFMC".equalsIgnoreCase(map.get("_sid"));
    }

    @MCKeep
    public abstract void disablePush();

    @MCKeep
    public abstract void enablePush();

    @NonNull
    @MCKeep
    public abstract JSONObject getPushDebugInfo();

    @Nullable
    @MCKeep
    public abstract String getPushToken();

    @MCKeep
    public abstract boolean handleMessage(@NonNull RemoteMessage remoteMessage);

    @MCKeep
    public abstract boolean handleMessage(@NonNull Map<String, String> map);

    @MCKeep
    public abstract boolean isPushEnabled();

    @MCKeep
    public abstract void registerSilentPushListener(@NonNull SilentPushListener silentPushListener);

    @MCKeep
    public abstract void registerTokenRefreshListener(@NonNull PushTokenRefreshListener pushTokenRefreshListener);

    @MCKeep
    public abstract void setPushToken(@NonNull String str);

    @MCKeep
    public abstract void unregisterSilentPushListener(@NonNull SilentPushListener silentPushListener);

    @MCKeep
    public abstract void unregisterTokenRefreshListener(@NonNull PushTokenRefreshListener pushTokenRefreshListener);
}
