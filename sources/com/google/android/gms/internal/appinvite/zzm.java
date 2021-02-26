package com.google.android.gms.internal.appinvite;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

@Deprecated
public final class zzm extends GmsClient<zzq> {
    private final String zzp;

    public zzm(Context context, Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, ClientSettings clientSettings) {
        super(context, looper, 77, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzp = clientSettings.getRealClientPackageName();
    }

    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* access modifiers changed from: protected */
    public final String getServiceDescriptor() {
        return "com.google.android.gms.appinvite.internal.IAppInviteService";
    }

    /* access modifiers changed from: protected */
    public final String getStartServiceAction() {
        return "com.google.android.gms.appinvite.service.START";
    }

    /* access modifiers changed from: protected */
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle = new Bundle();
        bundle.putString("authPackage", this.zzp);
        return bundle;
    }

    public final void zza(zzo zzo) {
        try {
            ((zzq) getService()).zza(zzo);
        } catch (RemoteException unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.appinvite.internal.IAppInviteService");
        if (queryLocalInterface instanceof zzq) {
            return (zzq) queryLocalInterface;
        }
        return new zzs(iBinder);
    }
}
