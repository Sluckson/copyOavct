package com.google.android.gms.internal.appinvite;

import android.content.Intent;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public interface zzo extends IInterface {
    void zza(Status status) throws RemoteException;

    void zza(Status status, Intent intent) throws RemoteException;
}
