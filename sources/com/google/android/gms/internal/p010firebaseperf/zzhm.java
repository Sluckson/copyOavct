package com.google.android.gms.internal.p010firebaseperf;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhm */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzhm extends zzhj<FieldDescriptorType, Object> {
    zzhm(int i) {
        super(i, (zzhm) null);
    }

    public final void zzgk() {
        if (!isImmutable()) {
            for (int i = 0; i < zzit(); i++) {
                Map.Entry zzau = zzau(i);
                if (((zzfc) zzau.getKey()).zzhf()) {
                    zzau.setValue(Collections.unmodifiableList((List) zzau.getValue()));
                }
            }
            for (Map.Entry entry : zziu()) {
                if (((zzfc) entry.getKey()).zzhf()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzgk();
    }
}
