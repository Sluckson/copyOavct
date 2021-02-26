package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import com.lowagie.text.pdf.codec.wmf.MetaDo;

public final class AuxEffectInfo {
    public static final int NO_AUX_EFFECT_ID = 0;
    public final int effectId;
    public final float sendLevel;

    public AuxEffectInfo(int i, float f) {
        this.effectId = i;
        this.sendLevel = f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AuxEffectInfo auxEffectInfo = (AuxEffectInfo) obj;
        if (this.effectId == auxEffectInfo.effectId && Float.compare(auxEffectInfo.sendLevel, this.sendLevel) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((MetaDo.META_OFFSETWINDOWORG + this.effectId) * 31) + Float.floatToIntBits(this.sendLevel);
    }
}
