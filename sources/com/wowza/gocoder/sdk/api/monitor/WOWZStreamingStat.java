package com.wowza.gocoder.sdk.api.monitor;

import java.util.Locale;

/* compiled from: GoCoderSDK */
public class WOWZStreamingStat {
    public long audioBytesBuffered;
    public long audioBytesTransmitted;
    public long avgChunkSize;
    public int avgEncodedVideoFrameSize;
    public long avgVideoFrameLatency;
    public int bps;
    public long bytesBuffered;
    public long bytesTransmitted;
    public long sampleInterval;
    public long timeElapsed;
    public long totalAudioBytesTransmitted;
    public long totalBytesTransmitted;
    public long totalVideoBytesTransmitted;
    public long videoBytesBuffered;
    public long videoBytesTransmitted;
    public int videoFramesBuffered;
    public int videoFramesDropped;
    public int videoFramesTransmitted;

    public static String getCSVHeader() {
        return "elapsed_time,frames_transmitted,frames_buffered,frames_dropped,avg_latency_ms,avg_frame_size_bytes,bytes_transmitted,bytes_buffered,avg_chunk_size_bytes,bandwidth_bps,total_video_bytes_transmitted,total_audio_bytes_transmitted,total_bytes_transmitted";
    }

    public static String getStatSeparator() {
        return "---------------------------------------------------------------------------------------------------------------------------------------------------------------------\n";
    }

    public WOWZStreamingStat() {
        this.sampleInterval = 0;
        this.timeElapsed = 0;
        this.bytesTransmitted = 0;
        this.videoBytesTransmitted = 0;
        this.audioBytesTransmitted = 0;
        this.bytesBuffered = 0;
        this.videoBytesBuffered = 0;
        this.audioBytesBuffered = 0;
        this.avgChunkSize = 0;
        this.videoFramesTransmitted = 0;
        this.videoFramesBuffered = 0;
        this.avgVideoFrameLatency = 0;
        this.avgEncodedVideoFrameSize = 0;
        this.bps = 0;
        this.totalBytesTransmitted = 0;
        this.totalVideoBytesTransmitted = 0;
        this.totalAudioBytesTransmitted = 0;
    }

    public WOWZStreamingStat(WOWZStreamingStat wOWZStreamingStat) {
        this();
        set(wOWZStreamingStat);
    }

    public void set(WOWZStreamingStat wOWZStreamingStat) {
        this.sampleInterval = wOWZStreamingStat.sampleInterval;
        this.timeElapsed = wOWZStreamingStat.timeElapsed;
        this.bytesTransmitted = wOWZStreamingStat.bytesTransmitted;
        this.videoBytesTransmitted = wOWZStreamingStat.videoBytesTransmitted;
        this.audioBytesTransmitted = wOWZStreamingStat.audioBytesTransmitted;
        this.bytesBuffered = wOWZStreamingStat.bytesBuffered;
        this.videoBytesBuffered = wOWZStreamingStat.videoBytesBuffered;
        this.audioBytesBuffered = wOWZStreamingStat.audioBytesBuffered;
        this.avgChunkSize = wOWZStreamingStat.avgChunkSize;
        this.videoFramesTransmitted = wOWZStreamingStat.videoFramesTransmitted;
        this.videoFramesBuffered = wOWZStreamingStat.videoFramesBuffered;
        this.videoFramesDropped = wOWZStreamingStat.videoFramesDropped;
        this.avgVideoFrameLatency = wOWZStreamingStat.avgVideoFrameLatency;
        this.avgEncodedVideoFrameSize = wOWZStreamingStat.avgEncodedVideoFrameSize;
        this.bps = wOWZStreamingStat.bps;
        this.totalBytesTransmitted = wOWZStreamingStat.totalBytesTransmitted;
        this.totalVideoBytesTransmitted = wOWZStreamingStat.totalVideoBytesTransmitted;
        this.totalAudioBytesTransmitted = wOWZStreamingStat.totalAudioBytesTransmitted;
    }

    public String toString() {
        return "sample interval : " + m3638a(this.sampleInterval) + "\nelapsed time    : " + m3638a(this.timeElapsed) + "\n\nframes transmitted : " + this.videoFramesTransmitted + "\nframes buffered    : " + this.videoFramesBuffered + "\nframes dropped     : " + this.videoFramesDropped + "\navg. frame latency : " + m3638a(this.avgVideoFrameLatency) + "\navg. frame size    : " + this.avgEncodedVideoFrameSize + "\n\nbytes transmitted       : " + this.bytesTransmitted + "\nvideo bytes transmitted : " + this.videoBytesTransmitted + "\naudio bytes transmitted : " + this.audioBytesTransmitted + "\nbytes buffered          : " + this.bytesBuffered + "\nvideo bytes buffered    : " + this.videoBytesBuffered + "\naudio bytes buffered    : " + this.audioBytesBuffered + "\navg. chunk size         : " + this.avgChunkSize + "\n\nbandwidth : " + m3637a(this.bps) + "\n\ntotal bytes transmitted : " + this.totalBytesTransmitted + "\ntotal video bytes       : " + this.totalVideoBytesTransmitted + "\ntotal audio bytes       : " + this.totalAudioBytesTransmitted;
    }

    public static String getStatHeader() {
        return "\n" + getStatSeparator() + "   Elapsed          Frames        Frames    Frames        Avg.             Avg.         Bytes      Bytes       Avg.                       Session Byte Totals\n    Time           Transmitted   Buffered   Dropped     Latency         Frame Size   Transmitted  Buffered  Chunk Size  Bandwidth      Video       Audio       Total\n" + getStatSeparator();
    }

    public String toRow(boolean z) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append(getStatHeader());
        }
        sb.append(String.format(Locale.US, "%s |       %04d     |   %04d  |   %04d  | %s |      %5d       | %7d | %7d |   %5d   | %s | %9d | %9d | %9d", new Object[]{m3638a(this.timeElapsed), Integer.valueOf(this.videoFramesTransmitted), Integer.valueOf(this.videoFramesBuffered), Integer.valueOf(this.videoFramesDropped), m3638a(this.avgVideoFrameLatency), Integer.valueOf(this.avgEncodedVideoFrameSize), Long.valueOf(this.bytesTransmitted), Long.valueOf(this.bytesBuffered), Long.valueOf(this.avgChunkSize), m3637a(this.bps), Long.valueOf(this.totalVideoBytesTransmitted), Long.valueOf(this.totalAudioBytesTransmitted), Long.valueOf(this.totalBytesTransmitted)}));
        if (z) {
            sb.append("\n" + getStatSeparator());
        }
        return sb.toString();
    }

    public String toCSV() {
        return String.format(Locale.US, "%d,%d,%d,%d,%s,%d,%d,%d,%d,%d,%d,%d,%d", new Object[]{Long.valueOf(this.timeElapsed), Integer.valueOf(this.videoFramesTransmitted), Integer.valueOf(this.videoFramesBuffered), Integer.valueOf(this.videoFramesDropped), m3638a(this.avgVideoFrameLatency), Integer.valueOf(this.avgEncodedVideoFrameSize), Long.valueOf(this.bytesTransmitted), Long.valueOf(this.bytesBuffered), Long.valueOf(this.avgChunkSize), Integer.valueOf(this.bps), Long.valueOf(this.totalVideoBytesTransmitted), Long.valueOf(this.totalAudioBytesTransmitted), Long.valueOf(this.totalBytesTransmitted)});
    }

    /* renamed from: a */
    private static String m3637a(int i) {
        if (i > 1024) {
            return String.format(Locale.US, "%4d kbps", new Object[]{Integer.valueOf(Math.round(((float) i) / 1024.0f))});
        }
        return String.format(Locale.US, "%4d bps ", new Object[]{Integer.valueOf(i)});
    }

    /* renamed from: a */
    private static String m3638a(long j) {
        return String.format(Locale.US, "%02dm %02ds %03dms", new Object[]{Long.valueOf(j / 60000), Long.valueOf((j / 1000) % 60), Long.valueOf(j % 1000)});
    }
}
