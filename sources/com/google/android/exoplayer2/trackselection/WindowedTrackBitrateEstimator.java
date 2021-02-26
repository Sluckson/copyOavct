package com.google.android.exoplayer2.trackselection;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C1119C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.chunk.MediaChunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import java.util.List;

public final class WindowedTrackBitrateEstimator implements TrackBitrateEstimator {
    private final long maxFutureDurationUs;
    private final long maxPastDurationUs;
    private final boolean useFormatBitrateAsLowerBound;

    public WindowedTrackBitrateEstimator(long j, long j2, boolean z) {
        this.maxPastDurationUs = C1119C.msToUs(j);
        this.maxFutureDurationUs = C1119C.msToUs(j2);
        this.useFormatBitrateAsLowerBound = z;
    }

    public int[] getBitrates(Format[] formatArr, List<? extends MediaChunk> list, MediaChunkIterator[] mediaChunkIteratorArr, @Nullable int[] iArr) {
        if (this.maxFutureDurationUs <= 0 && this.maxPastDurationUs <= 0) {
            return TrackSelectionUtil.getFormatBitrates(formatArr, iArr);
        }
        return TrackSelectionUtil.getBitratesUsingPastAndFutureInfo(formatArr, list, this.maxPastDurationUs, mediaChunkIteratorArr, this.maxFutureDurationUs, this.useFormatBitrateAsLowerBound, iArr);
    }
}
