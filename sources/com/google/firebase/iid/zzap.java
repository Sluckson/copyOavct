package com.google.firebase.iid;

import android.os.Bundle;

/* compiled from: com.google.firebase:firebase-iid@@20.2.1 */
final class zzap extends zzan<Bundle> {
    zzap(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        zza(bundle2);
    }
}
