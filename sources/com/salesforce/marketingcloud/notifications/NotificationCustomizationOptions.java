package com.salesforce.marketingcloud.notifications;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.notifications.NotificationManager;

@MCKeep
public class NotificationCustomizationOptions {
    final NotificationManager.NotificationChannelIdProvider channelIdProvider;
    final NotificationManager.NotificationLaunchIntentProvider launchIntentProvider;
    final NotificationManager.NotificationBuilder notificationBuilder;
    final int smallIconResId;

    private NotificationCustomizationOptions(int i, NotificationManager.NotificationLaunchIntentProvider notificationLaunchIntentProvider, NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider, NotificationManager.NotificationBuilder notificationBuilder2) {
        this.smallIconResId = i;
        this.launchIntentProvider = notificationLaunchIntentProvider;
        this.channelIdProvider = notificationChannelIdProvider;
        this.notificationBuilder = notificationBuilder2;
    }

    public static NotificationCustomizationOptions create(@DrawableRes int i) {
        return new NotificationCustomizationOptions(i, (NotificationManager.NotificationLaunchIntentProvider) null, (NotificationManager.NotificationChannelIdProvider) null, (NotificationManager.NotificationBuilder) null);
    }

    public static NotificationCustomizationOptions create(@DrawableRes int i, @Nullable NotificationManager.NotificationLaunchIntentProvider notificationLaunchIntentProvider, @Nullable NotificationManager.NotificationChannelIdProvider notificationChannelIdProvider) {
        return new NotificationCustomizationOptions(i, notificationLaunchIntentProvider, notificationChannelIdProvider, (NotificationManager.NotificationBuilder) null);
    }

    public static NotificationCustomizationOptions create(@NonNull NotificationManager.NotificationBuilder notificationBuilder2) {
        if (notificationBuilder2 != null) {
            return new NotificationCustomizationOptions(0, (NotificationManager.NotificationLaunchIntentProvider) null, (NotificationManager.NotificationChannelIdProvider) null, notificationBuilder2);
        }
        throw new IllegalArgumentException("The provided NotificationManager.NotificationBuilder cannot be null.");
    }
}
