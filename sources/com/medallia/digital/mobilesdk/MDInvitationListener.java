package com.medallia.digital.mobilesdk;

public interface MDInvitationListener {
    void onInvitationAccepted(long j, String str);

    void onInvitationDeclined(long j, String str);

    void onInvitationDeferred(long j, String str, String str2);

    void onInvitationDisplayed(long j, String str);
}
