package com.salesforce.marketingcloud.analytics;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.salesforce.marketingcloud.messages.Region;
import com.salesforce.marketingcloud.messages.inbox.InboxMessage;
import com.salesforce.marketingcloud.notifications.NotificationMessage;

@RestrictTo({RestrictTo.Scope.LIBRARY})
/* renamed from: com.salesforce.marketingcloud.analytics.k */
public abstract class C3923k implements AnalyticsManager, C3920i, C3924l, C3925m {
    /* renamed from: a */
    public void mo56255a(long j) {
    }

    /* renamed from: a */
    public void mo56256a(@NonNull Region region) {
    }

    /* renamed from: a */
    public void mo56252a(@NonNull InboxMessage inboxMessage) {
    }

    /* renamed from: a */
    public void mo56253a(@NonNull NotificationMessage notificationMessage) {
    }

    /* renamed from: a */
    public abstract void mo56254a(boolean z);

    /* renamed from: b */
    public void mo56257b(long j) {
    }

    /* renamed from: b */
    public void mo56258b(@NonNull Region region) {
    }

    /* renamed from: b */
    public void mo56259b(@NonNull NotificationMessage notificationMessage) {
    }

    /* renamed from: c */
    public void mo56260c(long j) {
    }

    public void trackCartContents(@NonNull PiCart piCart) {
    }

    public void trackCartConversion(@NonNull PiOrder piOrder) {
    }

    public void trackInboxOpenEvent(@NonNull InboxMessage inboxMessage) {
    }

    public final void trackPageView(@NonNull String str) {
        trackPageView(str, (String) null, (String) null, (String) null);
    }

    public final void trackPageView(@NonNull String str, @Nullable String str2) {
        trackPageView(str, str2, (String) null, (String) null);
    }

    public final void trackPageView(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        trackPageView(str, str2, str3, (String) null);
    }

    public void trackPageView(@NonNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
    }
}
