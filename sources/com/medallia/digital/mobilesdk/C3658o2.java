package com.medallia.digital.mobilesdk;

/* renamed from: com.medallia.digital.mobilesdk.o2 */
class C3658o2 implements MDInterceptListener {

    /* renamed from: a */
    private MDInterceptV3Listener f1597a;

    /* renamed from: b */
    private MDInvitationListener f1598b;

    C3658o2(MDInterceptV3Listener mDInterceptV3Listener) {
        this.f1597a = mDInterceptV3Listener;
    }

    C3658o2(MDInvitationListener mDInvitationListener) {
        this.f1598b = mDInvitationListener;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public MDInterceptListener mo55686a() {
        return this;
    }

    public void onInterceptAccepted(long j, String str, MDEngagementType mDEngagementType) {
        MDInvitationListener mDInvitationListener;
        if (MDEngagementType.form.equals(mDEngagementType) && (mDInvitationListener = this.f1598b) != null) {
            mDInvitationListener.onInvitationAccepted(j, str);
        }
        MDInterceptV3Listener mDInterceptV3Listener = this.f1597a;
        if (mDInterceptV3Listener != null) {
            mDInterceptV3Listener.onInterceptAccepted(j, str, mDEngagementType);
        }
    }

    public void onInterceptDeclined(long j, String str, MDEngagementType mDEngagementType) {
        MDInvitationListener mDInvitationListener;
        if (MDEngagementType.form.equals(mDEngagementType) && (mDInvitationListener = this.f1598b) != null) {
            mDInvitationListener.onInvitationDeclined(j, str);
        }
        MDInterceptV3Listener mDInterceptV3Listener = this.f1597a;
        if (mDInterceptV3Listener != null) {
            mDInterceptV3Listener.onInterceptDeclined(j, str, mDEngagementType);
        }
    }

    public void onInterceptDeferred(long j, String str, String str2, MDEngagementType mDEngagementType) {
        MDInvitationListener mDInvitationListener;
        if (MDEngagementType.form.equals(mDEngagementType) && (mDInvitationListener = this.f1598b) != null) {
            mDInvitationListener.onInvitationDeferred(j, str, str2);
        }
        MDInterceptV3Listener mDInterceptV3Listener = this.f1597a;
        if (mDInterceptV3Listener != null) {
            mDInterceptV3Listener.onInterceptDeferred(j, str, str2, mDEngagementType);
        }
    }

    public void onInterceptDisplayed(long j, String str, MDEngagementType mDEngagementType) {
        MDInvitationListener mDInvitationListener;
        if (MDEngagementType.form.equals(mDEngagementType) && (mDInvitationListener = this.f1598b) != null) {
            mDInvitationListener.onInvitationDisplayed(j, str);
        }
        MDInterceptV3Listener mDInterceptV3Listener = this.f1597a;
        if (mDInterceptV3Listener != null) {
            mDInterceptV3Listener.onInterceptDisplayed(j, str, mDEngagementType);
        }
    }
}
