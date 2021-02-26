package com.wowza.gocoder.sdk.api.mp4;

import android.content.Context;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.net.Uri;
import com.lowagie.text.Annotation;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Map;

/* compiled from: GoCoderSDK */
public class WOWZMP4Util {

    /* renamed from: a */
    private static final String f3837a = "WOWZMP4Util";

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        if (r1 != null) goto L_0x000d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0026 A[SYNTHETIC, Splitter:B:19:0x0026] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig getFileConfig(android.content.Context r3, android.net.Uri r4) {
        /*
            r0 = 0
            android.media.MediaExtractor r1 = new android.media.MediaExtractor     // Catch:{ Exception -> 0x0016, all -> 0x0013 }
            r1.<init>()     // Catch:{ Exception -> 0x0016, all -> 0x0013 }
            r1.setDataSource(r3, r4, r0)     // Catch:{ Exception -> 0x0011 }
            com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig r0 = m3644a(r1)     // Catch:{ Exception -> 0x0011 }
        L_0x000d:
            r1.release()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0022
        L_0x0011:
            r3 = move-exception
            goto L_0x0018
        L_0x0013:
            r3 = move-exception
            r1 = r0
            goto L_0x0024
        L_0x0016:
            r3 = move-exception
            r1 = r0
        L_0x0018:
            java.lang.String r4 = f3837a     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = "An exception occurred querying the MP4 file format."
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r4, (java.lang.String) r2, (java.lang.Throwable) r3)     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0022
            goto L_0x000d
        L_0x0022:
            return r0
        L_0x0023:
            r3 = move-exception
        L_0x0024:
            if (r1 == 0) goto L_0x0029
            r1.release()     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.mp4.WOWZMP4Util.getFileConfig(android.content.Context, android.net.Uri):com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        if (r1 != null) goto L_0x000d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0026 A[SYNTHETIC, Splitter:B:19:0x0026] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig getFileConfig(java.lang.String r4) {
        /*
            r0 = 0
            android.media.MediaExtractor r1 = new android.media.MediaExtractor     // Catch:{ Exception -> 0x0016, all -> 0x0013 }
            r1.<init>()     // Catch:{ Exception -> 0x0016, all -> 0x0013 }
            r1.setDataSource(r4)     // Catch:{ Exception -> 0x0011 }
            com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig r0 = m3644a(r1)     // Catch:{ Exception -> 0x0011 }
        L_0x000d:
            r1.release()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0022
        L_0x0011:
            r4 = move-exception
            goto L_0x0018
        L_0x0013:
            r4 = move-exception
            r1 = r0
            goto L_0x0024
        L_0x0016:
            r4 = move-exception
            r1 = r0
        L_0x0018:
            java.lang.String r2 = f3837a     // Catch:{ all -> 0x0023 }
            java.lang.String r3 = "An exception occurred querying the MP4 file format."
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r2, (java.lang.String) r3, (java.lang.Throwable) r4)     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0022
            goto L_0x000d
        L_0x0022:
            return r0
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            if (r1 == 0) goto L_0x0029
            r1.release()     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.mp4.WOWZMP4Util.getFileConfig(java.lang.String):com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        if (r1 != null) goto L_0x000d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0026 A[SYNTHETIC, Splitter:B:19:0x0026] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig getFileConfig(java.io.FileDescriptor r4) {
        /*
            r0 = 0
            android.media.MediaExtractor r1 = new android.media.MediaExtractor     // Catch:{ Exception -> 0x0016, all -> 0x0013 }
            r1.<init>()     // Catch:{ Exception -> 0x0016, all -> 0x0013 }
            r1.setDataSource(r4)     // Catch:{ Exception -> 0x0011 }
            com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig r0 = m3644a(r1)     // Catch:{ Exception -> 0x0011 }
        L_0x000d:
            r1.release()     // Catch:{ Exception -> 0x0022 }
            goto L_0x0022
        L_0x0011:
            r4 = move-exception
            goto L_0x0018
        L_0x0013:
            r4 = move-exception
            r1 = r0
            goto L_0x0024
        L_0x0016:
            r4 = move-exception
            r1 = r0
        L_0x0018:
            java.lang.String r2 = f3837a     // Catch:{ all -> 0x0023 }
            java.lang.String r3 = "An exception occurred querying the MP4 file format."
            com.wowza.gocoder.sdk.api.logging.WOWZLog.error((java.lang.String) r2, (java.lang.String) r3, (java.lang.Throwable) r4)     // Catch:{ all -> 0x0023 }
            if (r1 == 0) goto L_0x0022
            goto L_0x000d
        L_0x0022:
            return r0
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            if (r1 == 0) goto L_0x0029
            r1.release()     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.mp4.WOWZMP4Util.getFileConfig(java.io.FileDescriptor):com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig");
    }

    /* renamed from: a */
    private static WOWZMediaConfig m3644a(MediaExtractor mediaExtractor) {
        WOWZMediaConfig wOWZMediaConfig = new WOWZMediaConfig();
        wOWZMediaConfig.setVideoEnabled(false);
        wOWZMediaConfig.setAudioEnabled(false);
        try {
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                String string = trackFormat.getString(Annotation.MIMETYPE);
                if (string.startsWith("video/")) {
                    mediaExtractor.selectTrack(i);
                    if (trackFormat.containsKey("width")) {
                        wOWZMediaConfig.setVideoFrameWidth(trackFormat.getInteger("width"));
                        if (trackFormat.containsKey("height")) {
                            wOWZMediaConfig.setVideoFrameHeight(trackFormat.getInteger("height"));
                            wOWZMediaConfig.setVideoEnabled(true);
                            if (trackFormat.containsKey("frame-rate")) {
                                int integer = trackFormat.getInteger("frame-rate");
                                wOWZMediaConfig.setVideoFramerate(integer);
                                if (trackFormat.containsKey("i-frame-interval")) {
                                    wOWZMediaConfig.setVideoKeyFrameInterval(trackFormat.getInteger("i-frame-interval") * integer);
                                } else {
                                    int b = m3645b(mediaExtractor);
                                    if (b > 0) {
                                        wOWZMediaConfig.setVideoKeyFrameInterval(b * integer);
                                    } else {
                                        wOWZMediaConfig.setVideoKeyFrameInterval(integer);
                                        String str = f3837a;
                                        WOWZLog.warn(str, "Couldn't establish MP4 keyframe interval, using framerate (" + integer + ") ");
                                    }
                                }
                            }
                        }
                    }
                    mediaExtractor.unselectTrack(i);
                } else if (string.startsWith("audio/")) {
                    mediaExtractor.selectTrack(i);
                    if (trackFormat.containsKey("sample-rate")) {
                        wOWZMediaConfig.setAudioSampleRate(trackFormat.getInteger("sample-rate"));
                        wOWZMediaConfig.setAudioEnabled(true);
                        if (trackFormat.containsKey("channel-count")) {
                            wOWZMediaConfig.setAudioChannels(trackFormat.getInteger("channel-count"));
                        }
                    }
                    mediaExtractor.unselectTrack(i);
                }
            }
            if (wOWZMediaConfig.isVideoEnabled() || wOWZMediaConfig.isAudioEnabled()) {
                return wOWZMediaConfig;
            }
            return null;
        } catch (Exception e) {
            WOWZLog.error(f3837a, "An exception occurred querying the MP4 file format.", (Throwable) e);
            return null;
        } catch (Throwable th) {
            if (!wOWZMediaConfig.isVideoEnabled()) {
                boolean isAudioEnabled = wOWZMediaConfig.isAudioEnabled();
            }
            throw th;
        }
    }

    /* renamed from: b */
    private static int m3645b(MediaExtractor mediaExtractor) {
        ByteBuffer allocate = ByteBuffer.allocate(1048576);
        long j = 0;
        boolean z = false;
        while (mediaExtractor.readSampleData(allocate, 0) >= 0) {
            if ((mediaExtractor.getSampleFlags() & 1) != 0) {
                long sampleTime = mediaExtractor.getSampleTime();
                if (z) {
                    return Double.valueOf(Math.ceil(((double) (sampleTime - j)) / 1000000.0d)).intValue();
                }
                j = sampleTime;
                z = true;
            }
            mediaExtractor.advance();
        }
        return 0;
    }

    public static int findTrackIndexByMimeType(MediaExtractor mediaExtractor, String str) {
        int trackCount = mediaExtractor.getTrackCount();
        for (int i = 0; i < trackCount; i++) {
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
            String string = trackFormat.getString(Annotation.MIMETYPE);
            if (string.startsWith(str)) {
                String str2 = f3837a;
                WOWZLog.debug(str2, "Extractor selected track " + i + " (" + string + "): " + trackFormat);
                return i;
            }
        }
        return -1;
    }

    public static long maxTrackDuration(Context context, Uri uri, boolean z, boolean z2) {
        MediaExtractor mediaExtractor = new MediaExtractor();
        long j = 0;
        try {
            mediaExtractor.setDataSource(context, uri, (Map) null);
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                String string = trackFormat.getString(Annotation.MIMETYPE);
                if ((z && string.startsWith("video/")) || (z2 && string.startsWith("audio/"))) {
                    j = Math.max(j, trackFormat.getLong("durationUs"));
                }
            }
            mediaExtractor.release();
            return j;
        } catch (IOException e) {
            mediaExtractor.release();
            WOWZLog.error(f3837a, "A MediaExtractor exception occurred.", (Throwable) e);
            return 0;
        }
    }

    public static long maxTrackDuration(String str, boolean z, boolean z2) {
        FileDescriptor fileDescriptor;
        try {
            fileDescriptor = new FileInputStream(new File(str)).getFD();
        } catch (Exception e) {
            WOWZLog.error(f3837a, "An exception occurred attempting to open the MP4 file.", (Throwable) e);
            fileDescriptor = null;
        }
        if (fileDescriptor != null) {
            return maxTrackDuration(fileDescriptor, z, z2);
        }
        return 0;
    }

    public static long maxTrackDuration(FileDescriptor fileDescriptor, boolean z, boolean z2) {
        long j = 0;
        if (!fileDescriptor.valid()) {
            WOWZLog.error(f3837a, "Invalid MP4 file descriptor.");
            return 0;
        }
        MediaExtractor mediaExtractor = new MediaExtractor();
        try {
            mediaExtractor.setDataSource(fileDescriptor);
            int trackCount = mediaExtractor.getTrackCount();
            for (int i = 0; i < trackCount; i++) {
                MediaFormat trackFormat = mediaExtractor.getTrackFormat(i);
                String string = trackFormat.getString(Annotation.MIMETYPE);
                if ((z && string.startsWith("video/")) || (z2 && string.startsWith("audio/"))) {
                    j = Math.max(j, trackFormat.getLong("durationUs"));
                }
            }
            mediaExtractor.release();
            return j;
        } catch (IOException e) {
            mediaExtractor.release();
            WOWZLog.error(f3837a, "A MediaExtractor exception occurred,", (Throwable) e);
            return 0;
        }
    }
}
