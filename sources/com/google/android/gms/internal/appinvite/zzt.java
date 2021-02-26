package com.google.android.gms.internal.appinvite;

import android.os.Bundle;
import com.google.firebase.appinvite.FirebaseAppInvite;

@Deprecated
public final class zzt extends FirebaseAppInvite {
    private final Bundle zzt;

    public zzt(Bundle bundle) {
        this.zzt = bundle;
    }

    public final String getInvitationId() {
        return this.zzt.getString("com.google.firebase.appinvite.fdl.extension.InvitationId", (String) null);
    }
}
