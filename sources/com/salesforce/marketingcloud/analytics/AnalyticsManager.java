package com.salesforce.marketingcloud.analytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import com.salesforce.marketingcloud.MCKeep;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;

@MCKeep
public interface AnalyticsManager {
    void trackCartContents(@NonNull PiCart piCart);

    void trackCartConversion(@NonNull PiOrder piOrder);

    void trackInboxOpenEvent(@NonNull InboxMessage inboxMessage);

    void trackPageView(@Size(min = 1) @NonNull String str);

    void trackPageView(@Size(min = 1) @NonNull String str, @Nullable String str2);

    void trackPageView(@Size(min = 1) @NonNull String str, @Nullable String str2, @Nullable String str3);

    void trackPageView(@Size(min = 1) @NonNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4);
}
