package com.wowza.gocoder.sdk.api.mp4;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig;
import com.wowza.gocoder.sdk.api.errors.WOWZPlatformError;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: GoCoderSDK */
public class WOWZMP4Writer implements WOWZSinkAPI.MediaCodecAudioSink, WOWZSinkAPI.MediaCodecVideoSink {

    /* renamed from: a */
    private static final String f3838a = "WOWZMP4Writer";

    /* renamed from: b */
    private long f3839b = 0;

    /* renamed from: c */
    private long f3840c = 0;

    /* renamed from: d */
    private long f3841d = 0;
    protected boolean mActive = false;
    protected boolean mAudioEnabled = true;
    protected boolean mAudioPaused = false;
    protected int mAudioTrackIndex = -1;
    protected String mFilePath = null;
    protected MediaMuxer mMediaMuxer = null;
    protected WOWZBroadcastConfig mMuxerConfig = new WOWZBroadcastConfig();
    protected WOWZStatus mMuxerStatus = new WOWZStatus(0);
    protected WOWZStatus mSinkStatus = new WOWZStatus(0);
    protected boolean mVideoEnabled = true;
    protected boolean mVideoPaused = false;
    protected int mVideoTrackIndex = -1;

    public String getFilePath() {
        return this.mFilePath;
    }

    public void setFilePath(String str) {
        this.mFilePath = str;
    }

    public WOWZStatus prepareForBroadcast(WOWZBroadcastConfig wOWZBroadcastConfig) {
        this.mSinkStatus.setState(1);
        this.mSinkStatus.clearLastError();
        this.mMuxerConfig.set(wOWZBroadcastConfig);
        String str = this.mFilePath;
        if (str != null) {
            try {
                this.mMediaMuxer = new MediaMuxer(str, 0);
                this.mSinkStatus.setState(2);
            } catch (IOException e) {
                this.mSinkStatus.set(0, new WOWZPlatformError(59, (Exception) e));
                WOWZLog.error(f3838a, this.mSinkStatus.getLastError());
            }
        } else {
            this.mSinkStatus.set(0, new WOWZPlatformError(60));
            WOWZLog.error(f3838a, this.mSinkStatus.getLastError());
        }
        return this.mSinkStatus;
    }

    public WOWZStatus startBroadcasting() {
        this.f3839b = 0;
        this.f3840c = 0;
        this.f3841d = 0;
        this.mSinkStatus.setState(3);
        return this.mSinkStatus;
    }

    public WOWZStatus stopBroadcasting() {
        this.mSinkStatus.setState(4);
        if (this.mMuxerStatus.isRunning()) {
            this.mMuxerStatus.setState(4);
            try {
                this.mMediaMuxer.stop();
            } catch (Exception e) {
                WOWZLog.error(f3838a, "An exception occurred stopping the MP4 MediaMuxer", (Throwable) e);
            }
            try {
                this.mMediaMuxer.release();
            } catch (Exception e2) {
                WOWZLog.error(f3838a, "An exception occurred releasing the MP4 MediaMuxer", (Throwable) e2);
            }
            this.mMuxerStatus.setState(0);
        }
        this.mMediaMuxer = null;
        this.mVideoTrackIndex = -1;
        this.mAudioTrackIndex = -1;
        this.mSinkStatus.setState(0);
        return this.mSinkStatus;
    }

    public WOWZBroadcastConfig getBroadcastConfig() {
        return this.mMuxerConfig;
    }

    public WOWZStatus getBroadcasterStatus() {
        return this.mSinkStatus;
    }

    public WOWZStatus getStatus() {
        return getBroadcasterStatus();
    }

    public boolean isVideoEnabled() {
        return this.mVideoEnabled;
    }

    public void setVideoEnabled(boolean z) {
        this.mVideoEnabled = z;
    }

    public boolean isVideoPaused() {
        return this.mVideoPaused;
    }

    public void setVideoPaused(boolean z) {
        this.mVideoPaused = z;
    }

    public void onVideoFormat(MediaFormat mediaFormat) {
        if (this.mVideoTrackIndex == -1) {
            this.mVideoTrackIndex = m3646a(mediaFormat);
        }
        m3648a();
    }

    public void onVideoFrame(long j, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        m3649a(this.mVideoTrackIndex, byteBuffer, bufferInfo);
    }

    public boolean isAudioEnabled() {
        return this.mAudioEnabled;
    }

    public void setAudioEnabled(boolean z) {
        this.mAudioEnabled = z;
    }

    public boolean isAudioPaused() {
        return this.mAudioPaused;
    }

    public void setAudioPaused(boolean z) {
        this.mAudioPaused = z;
    }

    public void onAudioFormat(MediaFormat mediaFormat) {
        if (this.mAudioTrackIndex == -1) {
            this.mAudioTrackIndex = m3646a(mediaFormat);
        }
        m3648a();
    }

    public void onAudioSample(long j, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        long a = m3647a(bufferInfo.presentationTimeUs, (long) (bufferInfo.size / 2), this.mMuxerConfig.getAudioSampleRate());
        if (this.f3840c == 0) {
            this.f3840c = a;
        }
        bufferInfo.presentationTimeUs = a - this.f3840c;
        if (bufferInfo.size != 0) {
            m3649a(this.mAudioTrackIndex, byteBuffer, bufferInfo);
        }
    }

    /* renamed from: a */
    private synchronized int m3646a(MediaFormat mediaFormat) {
        return this.mMediaMuxer.addTrack(mediaFormat);
    }

    /* renamed from: a */
    private synchronized void m3649a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.mMuxerStatus.isRunning()) {
            try {
                this.mMediaMuxer.writeSampleData(i, byteBuffer, bufferInfo);
            } catch (IllegalArgumentException e) {
                WOWZLog.debug("[IllegalArgumentException]WOWZMP4Writer Exception in MediaMuxer writeSampleData! Error: " + e.getMessage());
                WOWZLog.error(e.getMessage());
            } catch (IllegalStateException e2) {
                WOWZLog.debug("[IllegalStateException]WOWZMP4Writer Exception in MediaMuxer writeSampleData! Error: " + e2.getMessage());
                WOWZLog.error(e2.getMessage());
            }
        }
    }

    /* renamed from: a */
    private synchronized void m3648a() {
        boolean z;
        boolean z2 = false;
        if (this.mMuxerConfig.isVideoEnabled()) {
            if (this.mVideoTrackIndex == -1) {
                z = false;
                if (!this.mMuxerConfig.isAudioEnabled() || this.mAudioTrackIndex != -1) {
                    z2 = true;
                }
                if (z && z2) {
                    this.mMuxerStatus.setState(1);
                    this.mMediaMuxer.start();
                    this.mMuxerStatus.setState(3);
                }
            }
        }
        z = true;
        z2 = true;
        this.mMuxerStatus.setState(1);
        this.mMediaMuxer.start();
        this.mMuxerStatus.setState(3);
    }

    /* renamed from: a */
    private long m3647a(long j, long j2, int i) {
        long j3 = (long) i;
        long j4 = (j2 * 1000000) / j3;
        long j5 = j - j4;
        if (this.f3841d == 0) {
            this.f3839b = j5;
            this.f3841d = 0;
        }
        long j6 = this.f3839b + ((this.f3841d * 1000000) / j3);
        if (j5 - j6 >= j4 * 2) {
            this.f3839b = j5;
            this.f3841d = 0;
            j6 = this.f3839b;
        }
        this.f3841d += j2;
        return j6;
    }
}
