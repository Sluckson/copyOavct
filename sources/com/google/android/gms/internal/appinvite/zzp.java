package com.google.android.gms.internal.appinvite;

import android.content.Intent;
import com.google.android.gms.appinvite.AppInviteInvitationResult;
import com.google.android.gms.common.api.Status;

@Deprecated
public final class zzp implements AppInviteInvitationResult {
    private final Status zzr;
    private final Intent zzs;

    public zzp(Status status, Intent intent) {
        this.zzr = status;
        this.zzs = intent;
    }

    public final Status getStatus() {
        return this.zzr;
    }

    public final Intent getInvitationIntent() {
        return this.zzs;
    }
}
