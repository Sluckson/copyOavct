package com.wowza.gocoder.sdk.api.sink;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI;
import java.nio.ByteBuffer;

/* compiled from: GoCoderSDK */
public final class WOWZSinkAPI {

    /* compiled from: GoCoderSDK */
    public interface AudioSink extends WOWZBroadcastAPI.Broadcaster {
        boolean isAudioEnabled();

        boolean isAudioPaused();

        void setAudioEnabled(boolean z);

        void setAudioPaused(boolean z);
    }

    /* compiled from: GoCoderSDK */
    public interface MediaCodecAudioSink extends AudioSink {
        void onAudioFormat(MediaFormat mediaFormat);

        void onAudioSample(long j, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);
    }

    /* compiled from: GoCoderSDK */
    public interface MediaCodecVideoSink extends VideoSink {
        void onVideoFormat(MediaFormat mediaFormat);

        void onVideoFrame(long j, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);
    }

    /* compiled from: GoCoderSDK */
    public interface StreamingAudioSink extends AudioSink {
        Handler getAudioSinkHandler();

        void onAudioFrame(long j, byte[] bArr, int i);
    }

    /* compiled from: GoCoderSDK */
    public interface StreamingVideoSink extends VideoSink {
        Handler getVideoSinkHandler();

        void onParameterSets(byte[] bArr, byte[] bArr2);

        void onVideoConfigFrame(byte[] bArr, int i);

        void onVideoFrame(long j, byte[] bArr, int i);
    }

    /* compiled from: GoCoderSDK */
    public interface VideoSink extends WOWZBroadcastAPI.Broadcaster {
        boolean isVideoEnabled();

        boolean isVideoPaused();

        void setVideoEnabled(boolean z);

        void setVideoPaused(boolean z);
    }
}
