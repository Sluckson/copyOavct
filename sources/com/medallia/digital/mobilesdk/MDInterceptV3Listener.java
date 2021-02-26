package com.medallia.digital.mobilesdk;

public interface MDInterceptV3Listener {
    void onInterceptAccepted(long j, String str, MDEngagementType mDEngagementType);

    void onInterceptDeclined(long j, String str, MDEngagementType mDEngagementType);

    void onInterceptDeferred(long j, String str, String str2, MDEngagementType mDEngagementType);

    void onInterceptDisplayed(long j, String str, MDEngagementType mDEngagementType);
}
