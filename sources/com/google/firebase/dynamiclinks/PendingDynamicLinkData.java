package com.google.firebase.dynamiclinks;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.firebase.dynamiclinks.internal.DynamicLinkData;

public class PendingDynamicLinkData {
    private final DynamicLinkData zzi;

    @KeepForSdk
    @VisibleForTesting
    public PendingDynamicLinkData(DynamicLinkData dynamicLinkData) {
        if (dynamicLinkData == null) {
            this.zzi = null;
            return;
        }
        if (dynamicLinkData.getClickTimestamp() == 0) {
            dynamicLinkData.zza(DefaultClock.getInstance().currentTimeMillis());
        }
        this.zzi = dynamicLinkData;
    }

    protected PendingDynamicLinkData(String str, int i, long j, Uri uri) {
        this.zzi = new DynamicLinkData((String) null, str, i, j, (Bundle) null, uri);
    }

    @ShowFirstParty
    @KeepForSdk
    public Bundle getExtensions() {
        DynamicLinkData dynamicLinkData = this.zzi;
        if (dynamicLinkData == null) {
            return new Bundle();
        }
        return dynamicLinkData.zzf();
    }

    public Uri getLink() {
        String zzd;
        DynamicLinkData dynamicLinkData = this.zzi;
        if (dynamicLinkData == null || (zzd = dynamicLinkData.zzd()) == null) {
            return null;
        }
        return Uri.parse(zzd);
    }

    public int getMinimumAppVersion() {
        DynamicLinkData dynamicLinkData = this.zzi;
        if (dynamicLinkData == null) {
            return 0;
        }
        return dynamicLinkData.zze();
    }

    public long getClickTimestamp() {
        DynamicLinkData dynamicLinkData = this.zzi;
        if (dynamicLinkData == null) {
            return 0;
        }
        return dynamicLinkData.getClickTimestamp();
    }

    @VisibleForTesting
    private final Uri zzc() {
        DynamicLinkData dynamicLinkData = this.zzi;
        if (dynamicLinkData == null) {
            return null;
        }
        return dynamicLinkData.zzc();
    }

    public Intent getUpdateAppIntent(Context context) {
        if (getMinimumAppVersion() == 0) {
            return null;
        }
        try {
            if (context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0).versionCode < getMinimumAppVersion() && zzc() != null) {
                return new Intent("android.intent.action.VIEW").setData(zzc()).setPackage("com.android.vending");
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }
}
