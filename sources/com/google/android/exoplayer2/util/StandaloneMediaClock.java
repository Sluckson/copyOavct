package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.C1119C;
import com.google.android.exoplayer2.PlaybackParameters;

public final class StandaloneMediaClock implements MediaClock {
    private long baseElapsedMs;
    private long baseUs;
    private final Clock clock;
    private PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
    private boolean started;

    public StandaloneMediaClock(Clock clock2) {
        this.clock = clock2;
    }

    public void start() {
        if (!this.started) {
            this.baseElapsedMs = this.clock.elapsedRealtime();
            this.started = true;
        }
    }

    public void stop() {
        if (this.started) {
            resetPosition(getPositionUs());
            this.started = false;
        }
    }

    public void resetPosition(long j) {
        this.baseUs = j;
        if (this.started) {
            this.baseElapsedMs = this.clock.elapsedRealtime();
        }
    }

    public long getPositionUs() {
        long j;
        long j2 = this.baseUs;
        if (!this.started) {
            return j2;
        }
        long elapsedRealtime = this.clock.elapsedRealtime() - this.baseElapsedMs;
        if (this.playbackParameters.speed == 1.0f) {
            j = C1119C.msToUs(elapsedRealtime);
        } else {
            j = this.playbackParameters.getMediaTimeUsForPlayoutTimeMs(elapsedRealtime);
        }
        return j2 + j;
    }

    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters2) {
        if (this.started) {
            resetPosition(getPositionUs());
        }
        this.playbackParameters = playbackParameters2;
        return playbackParameters2;
    }

    public PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }
}
