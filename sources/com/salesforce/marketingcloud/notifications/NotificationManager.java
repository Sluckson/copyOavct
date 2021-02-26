package com.salesforce.marketingcloud.notifications;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.C1119C;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.MCService;

public abstract class NotificationManager {
    @NonNull
    @MCKeep
    public static final String DEFAULT_CHANNEL_ID = "com.salesforce.marketingcloud.DEFAULT_CHANNEL";
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: h */
    public static final String f3287h = "com.salesforce.marketingcloud.notifications.EXTRA_MESSAGE";

    /* renamed from: i */
    static int f3288i = 3000;

    @MCKeep
    public interface NotificationBuilder {
        @NonNull
        NotificationCompat.Builder setupNotificationBuilder(@NonNull Context context, @NonNull NotificationMessage notificationMessage);
    }

    @MCKeep
    public interface NotificationChannelIdProvider {
        @NonNull
        String getNotificationChannelId(@NonNull Context context, @NonNull NotificationMessage notificationMessage);
    }

    @MCKeep
    public interface NotificationLaunchIntentProvider {
        @Nullable
        PendingIntent getNotificationPendingIntent(@NonNull Context context, @NonNull NotificationMessage notificationMessage);
    }

    @MCKeep
    public interface NotificationMessageDisplayedListener {
        void onNotificationMessageDisplayed(@NonNull NotificationMessage notificationMessage);
    }

    @MCKeep
    public interface ShouldShowNotificationListener {
        boolean shouldShowNotification(@NonNull NotificationMessage notificationMessage);
    }

    @MCKeep
    public static void cancelNotificationMessage(@NonNull Context context, @NonNull NotificationMessage notificationMessage) {
        if (notificationMessage.notificationId() >= 0) {
            ((android.app.NotificationManager) context.getSystemService("notification")).cancel("com.marketingcloud.salesforce.notifications.TAG", notificationMessage.notificationId());
        }
    }

    @NonNull
    @MCKeep
    public static String createDefaultNotificationChannel(@NonNull Context context) {
        return C4112d.m3295a(context, false);
    }

    @NonNull
    @MCKeep
    public static String createDefaultNotificationChannel(@NonNull Context context, boolean z) {
        return C4112d.m3295a(context, z);
    }

    @Nullable
    @MCKeep
    public static NotificationMessage extractMessage(@NonNull Intent intent) {
        if (intent == null) {
            return null;
        }
        return (NotificationMessage) intent.getParcelableExtra(f3287h);
    }

    @NonNull
    @MCKeep
    public static NotificationCompat.Builder getDefaultNotificationBuilder(@NonNull Context context, @NonNull NotificationMessage notificationMessage, @NonNull String str, @DrawableRes int i) {
        return C4112d.m3294a(context, notificationMessage, str, i);
    }

    @NonNull
    @MCKeep
    public static PendingIntent redirectIntentForAnalytics(@NonNull Context context, @NonNull PendingIntent pendingIntent, @NonNull NotificationMessage notificationMessage, boolean z) {
        Bundle bundle = new Bundle(3);
        bundle.putParcelable(f3287h, notificationMessage);
        bundle.putParcelable(C4108c.f3302b, pendingIntent);
        bundle.putBoolean(C4108c.f3303c, z);
        int i = f3288i;
        f3288i = i + 1;
        return PendingIntent.getService(context, i, MCService.m2065a(context, bundle), C1119C.ENCODING_PCM_MU_LAW);
    }

    @MCKeep
    public abstract boolean areNotificationsEnabled();

    @MCKeep
    public abstract void disableNotifications();

    @MCKeep
    public abstract void enableNotifications();

    @MCKeep
    public abstract void registerNotificationMessageDisplayedListener(@NonNull NotificationMessageDisplayedListener notificationMessageDisplayedListener);

    @MCKeep
    public abstract void setShouldShowNotificationListener(@Nullable ShouldShowNotificationListener shouldShowNotificationListener);

    @MCKeep
    public abstract void unregisterNotificationMessageDisplayedListener(@NonNull NotificationMessageDisplayedListener notificationMessageDisplayedListener);
}
