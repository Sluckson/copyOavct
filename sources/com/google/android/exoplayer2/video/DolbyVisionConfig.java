package com.google.android.exoplayer2.video;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.wowza.gocoder.sdk.support.wmstransport.wms.p042a.p045c.C4318a;

public final class DolbyVisionConfig {
    public final String codecs;
    public final int level;
    public final int profile;

    @Nullable
    public static DolbyVisionConfig parse(ParsableByteArray parsableByteArray) {
        String str;
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte >> 1;
        int readUnsignedByte2 = ((parsableByteArray.readUnsignedByte() >> 3) & 31) | ((readUnsignedByte & 1) << 5);
        if (i == 4 || i == 5) {
            str = "dvhe";
        } else if (i == 8) {
            str = C4318a.f4571g;
        } else if (i != 9) {
            return null;
        } else {
            str = "avc3";
        }
        return new DolbyVisionConfig(i, readUnsignedByte2, str + ".0" + i + ".0" + readUnsignedByte2);
    }

    private DolbyVisionConfig(int i, int i2, String str) {
        this.profile = i;
        this.level = i2;
        this.codecs = str;
    }
}
