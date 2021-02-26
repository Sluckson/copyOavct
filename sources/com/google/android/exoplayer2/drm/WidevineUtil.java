package com.google.android.exoplayer2.drm;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C1119C;
import java.util.Map;

public final class WidevineUtil {
    public static final String PROPERTY_LICENSE_DURATION_REMAINING = "LicenseDurationRemaining";
    public static final String PROPERTY_PLAYBACK_DURATION_REMAINING = "PlaybackDurationRemaining";

    private WidevineUtil() {
    }

    @Nullable
    public static Pair<Long, Long> getLicenseDurationRemainingSec(DrmSession<?> drmSession) {
        Map<String, String> queryKeyStatus = drmSession.queryKeyStatus();
        if (queryKeyStatus == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(getDurationRemainingSec(queryKeyStatus, PROPERTY_LICENSE_DURATION_REMAINING)), Long.valueOf(getDurationRemainingSec(queryKeyStatus, PROPERTY_PLAYBACK_DURATION_REMAINING)));
    }

    private static long getDurationRemainingSec(Map<String, String> map, String str) {
        if (map == null) {
            return C1119C.TIME_UNSET;
        }
        try {
            String str2 = map.get(str);
            return str2 != null ? Long.parseLong(str2) : C1119C.TIME_UNSET;
        } catch (NumberFormatException unused) {
            return C1119C.TIME_UNSET;
        }
    }
}
