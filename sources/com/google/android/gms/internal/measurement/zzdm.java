package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final /* synthetic */ class zzdm implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzdn zza;

    zzdm(zzdn zzdn) {
        this.zza = zzdn;
    }

    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        this.zza.zza(sharedPreferences, str);
    }
}
