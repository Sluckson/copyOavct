package com.wowza.gocoder.sdk.api.mp4;

import android.content.Context;
import android.net.Uri;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;

/* compiled from: GoCoderSDK */
public class WOWZMP4Broadcaster implements WOWZBroadcastAPI.AudioBroadcaster, WOWZBroadcastAPI.VideoBroadcaster {

    /* renamed from: a */
    private static final String f3821a = "WOWZMP4Broadcaster";

    /* renamed from: b */
    private static final int f3822b = 1024;

    /* renamed from: c */
    private static final int f3823c = 8;

    /* renamed from: d */
    private static final int f3824d = 4;

    /* renamed from: e */
    private boolean f3825e = false;

    /* renamed from: f */
    private long f3826f = 0;

    /* renamed from: g */
    private boolean f3827g = true;

    /* renamed from: h */
    private boolean f3828h = false;

    /* renamed from: i */
    private WOWZStatus f3829i = new WOWZStatus(0);

    /* renamed from: j */
    private boolean f3830j = true;

    /* renamed from: k */
    private boolean f3831k = false;

    /* renamed from: l */
    private WOWZStatus f3832l = new WOWZStatus(0);

    /* renamed from: m */
    private WOWZMediaConfig f3833m = new WOWZMediaConfig();
    protected WOWZBroadcastConfig mBroadcastConfig = new WOWZBroadcastConfig();
    protected WOWZStatus mBroadcasterStatus = new WOWZStatus();
    protected Context mContext;
    protected Uri mFileUri = null;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public long f3834n = 0;

    public WOWZMP4Broadcaster(Context context) {
        this.mContext = context;
    }

    public long getOffset() {
        return this.f3826f;
    }

    public void setOffset(long j) {
        this.f3826f = j;
    }

    public Uri getFileUri() {
        return this.mFileUri;
    }

    public void setFileUri(Uri uri) {
        this.mFileUri = uri;
    }

    public WOWZMediaConfig getMP4Config() {
        Uri uri = this.mFileUri;
        if (uri != null) {
            return WOWZMP4Util.getFileConfig(this.mContext, uri);
        }
        WOWZLog.error(f3821a, "Attempt to open an MP4 before a URI has been specified.");
        return null;
    }

    public boolean getLooping() {
        return this.f3825e;
    }

    public void setLooping(boolean z) {
        this.f3825e = z;
    }

    public WOWZBroadcastConfig getBroadcastConfig() {
        return this.mBroadcastConfig;
    }

    public WOWZStatus getBroadcasterStatus() {
        return this.mBroadcasterStatus;
    }

    public WOWZStatus getStatus() {
        return getBroadcasterStatus();
    }

    public WOWZStatus prepareForBroadcast(WOWZBroadcastConfig wOWZBroadcastConfig) {
        Uri uri = this.mFileUri;
        if (uri == null) {
            WOWZLog.error(f3821a, "Attempt to stream an MP4 file before a URI has been specified.");
            return null;
        }
        this.f3833m = WOWZMP4Util.getFileConfig(this.mContext, uri);
        if (this.f3833m == null) {
            WOWZLog.error(f3821a, "The format of the specified MP4 file could not be determined.");
            this.mBroadcasterStatus.setError(new WOWZError("The format of the specified MP4 file could not be determined."));
            return this.mBroadcasterStatus;
        }
        this.mBroadcastConfig.set(wOWZBroadcastConfig);
        this.mBroadcastConfig.setVideoSourceConfig(this.f3833m);
        this.mBroadcastConfig.setVideoFrameSize(this.f3833m.getVideoFrameSize());
        this.mBroadcastConfig.setVideoFramerate(this.f3833m.getVideoFramerate());
        this.mBroadcastConfig.setVideoKeyFrameInterval(this.f3833m.getVideoKeyFrameInterval());
        this.mBroadcastConfig.setVideoRotation(this.f3833m.getVideoRotation());
        this.mBroadcasterStatus.setState(1);
        this.f3834n = WOWZMP4Util.maxTrackDuration(this.mContext, this.mFileUri, this.mBroadcastConfig.isVideoEnabled(), this.mBroadcastConfig.isAudioEnabled());
        this.mBroadcasterStatus.setState(2);
        return this.mBroadcasterStatus;
    }

    public WOWZStatus startBroadcasting() {
        if (this.mBroadcastConfig.isVideoEnabled()) {
            C42381 r1 = new Runnable() {
                public void run() {
                    WOWZMP4Broadcaster wOWZMP4Broadcaster = WOWZMP4Broadcaster.this;
                    WOWZError a = wOWZMP4Broadcaster.m3641a(wOWZMP4Broadcaster.mContext, WOWZMP4Broadcaster.this.mFileUri, WOWZMP4Broadcaster.this.mBroadcastConfig.getVideoSinks(), WOWZMP4Broadcaster.this.f3834n);
                    if (a == null) {
                        return;
                    }
                    if (WOWZMP4Broadcaster.this.mBroadcasterStatus.isReady() || WOWZMP4Broadcaster.this.mBroadcasterStatus.isRunning()) {
                        WOWZMP4Broadcaster.this.mBroadcastConfig.getErrorCallback().onBroadcastError(a);
                    }
                }
            };
            new Thread(r1, f3821a + "(MP4VideoTrackExtractor)").start();
        }
        if (this.mBroadcastConfig.isAudioEnabled()) {
            C42392 r12 = new Runnable() {
                public void run() {
                    WOWZMP4Broadcaster wOWZMP4Broadcaster = WOWZMP4Broadcaster.this;
                    WOWZError a = wOWZMP4Broadcaster.m3640a(wOWZMP4Broadcaster.mContext, WOWZMP4Broadcaster.this.mFileUri, WOWZMP4Broadcaster.this.mBroadcastConfig.getAudioSinks(), WOWZMP4Broadcaster.this.f3834n);
                    if (a == null) {
                        return;
                    }
                    if (WOWZMP4Broadcaster.this.mBroadcasterStatus.isReady() || WOWZMP4Broadcaster.this.mBroadcasterStatus.isRunning()) {
                        WOWZMP4Broadcaster.this.mBroadcastConfig.getErrorCallback().onBroadcastError(a);
                    }
                }
            };
            new Thread(r12, f3821a + "(MP4AudioTrackExtractor)").start();
        }
        this.mBroadcasterStatus.setState(3);
        return this.mBroadcasterStatus;
    }

    public WOWZStatus stopBroadcasting() {
        this.mBroadcasterStatus.setState(4);
        this.f3829i.waitForState(0);
        this.f3832l.waitForState(0);
        this.mBroadcasterStatus.setState(0);
        return this.mBroadcasterStatus;
    }

    public WOWZMediaConfig getVideoSourceConfig() {
        return this.f3833m;
    }

    public boolean isVideoEnabled() {
        return this.f3827g;
    }

    public void setVideoEnabled(boolean z) {
        this.f3827g = z;
    }

    public boolean isVideoPaused() {
        return this.f3828h;
    }

    public void setVideoPaused(boolean z) {
        this.f3828h = z;
    }

    public boolean isAudioEnabled() {
        return this.f3830j;
    }

    public void setAudioEnabled(boolean z) {
        this.f3830j = z;
    }

    public boolean isAudioPaused() {
        return this.f3831k;
    }

    public void setAudioPaused(boolean z) {
        this.f3831k = z;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00f7 A[LOOP:2: B:23:0x00f7->B:26:0x0107, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x016f A[LOOP:4: B:50:0x016f->B:53:0x017d, LOOP_START] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.wowza.gocoder.sdk.api.errors.WOWZError m3641a(android.content.Context r28, android.net.Uri r29, com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.VideoSink[] r30, long r31) {
        /*
            r27 = this;
            r1 = r27
            r0 = r30
            r2 = 1000(0x3e8, double:4.94E-321)
            long r4 = r31 / r2
            com.wowza.gocoder.sdk.api.status.WOWZStatus r6 = r1.f3829i
            r7 = 1
            r6.setState(r7)
            android.media.MediaExtractor r6 = new android.media.MediaExtractor
            r6.<init>()
            r8 = 0
            r9 = 0
            r10 = r28
            r11 = r29
            r6.setDataSource(r10, r11, r8)     // Catch:{ Exception -> 0x01c1 }
            java.lang.String r10 = "video/"
            int r10 = com.wowza.gocoder.sdk.api.mp4.WOWZMP4Util.findTrackIndexByMimeType(r6, r10)
            r11 = -1
            r12 = 4
            if (r10 != r11) goto L_0x003b
            java.lang.String r0 = f3821a
            java.lang.String r2 = "No video track found in MP4 file"
            com.wowza.gocoder.sdk.api.logging.WOWZLog.warn((java.lang.String) r0, (java.lang.String) r2)
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3829i
            r0.setState(r12)
            r6.release()
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3829i
            r0.setState(r9)
            return r8
        L_0x003b:
            android.media.MediaFormat r11 = r6.getTrackFormat(r10)
            java.lang.String r13 = "max-input-size"
            int r13 = r11.getInteger(r13)
            java.nio.ByteBuffer r13 = java.nio.ByteBuffer.allocate(r13)
            java.lang.String r14 = "csd-0"
            java.nio.ByteBuffer r14 = r11.getByteBuffer(r14)
            java.lang.String r15 = "csd-1"
            java.nio.ByteBuffer r15 = r11.getByteBuffer(r15)
            int r8 = r0.length
            r7 = 0
            r12 = 0
        L_0x0058:
            if (r12 >= r8) goto L_0x0084
            r9 = r0[r12]
            boolean r2 = r9 instanceof com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.StreamingVideoSink
            if (r2 == 0) goto L_0x006e
            com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI$StreamingVideoSink r9 = (com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.StreamingVideoSink) r9
            byte[] r2 = r14.array()
            byte[] r3 = r15.array()
            r9.onParameterSets(r2, r3)
            goto L_0x007e
        L_0x006e:
            boolean r2 = r9 instanceof com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.MediaCodecVideoSink
            if (r2 == 0) goto L_0x007e
            if (r7 != 0) goto L_0x0079
            android.media.MediaCodec$BufferInfo r7 = new android.media.MediaCodec$BufferInfo
            r7.<init>()
        L_0x0079:
            com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI$MediaCodecVideoSink r9 = (com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.MediaCodecVideoSink) r9
            r9.onVideoFormat(r11)
        L_0x007e:
            int r12 = r12 + 1
            r2 = 1000(0x3e8, double:4.94E-321)
            r9 = 0
            goto L_0x0058
        L_0x0084:
            r6.selectTrack(r10)
            long r2 = r6.getSampleTime()
            long r8 = r1.f3826f
            r11 = 1000(0x3e8, double:4.94E-321)
            long r8 = r8 * r11
            long r8 = r8 + r2
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "[broadcastVideoTrack] Start Time: "
            r11.append(r12)
            r11.append(r2)
            java.lang.String r2 = r11.toString()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "[broadcastVideoTrack] End Time: "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            com.wowza.gocoder.sdk.api.logging.WOWZLog.debug(r2)
            r2 = 2
            r6.seekTo(r8, r2)
            com.wowza.gocoder.sdk.api.status.WOWZStatus r3 = r1.f3829i
            r3.setState(r2)
            com.wowza.gocoder.sdk.api.status.WOWZStatus r3 = r1.f3829i
            r8 = 3
            r3.setState(r8)
            long r8 = java.lang.System.currentTimeMillis()
            long r11 = r8 + r4
            r14 = r11
            r2 = 0
            r18 = 0
            r11 = r8
        L_0x00d4:
            int r3 = r6.readSampleData(r13, r2)
            if (r3 >= 0) goto L_0x00e7
            r19 = r4
            r21 = r8
            r25 = r11
            r9 = 1
            r16 = 1000(0x3e8, double:4.94E-321)
            r23 = 1
            goto L_0x0169
        L_0x00e7:
            r19 = r4
            long r4 = r6.getSampleTime()
            r16 = 1000(0x3e8, double:4.94E-321)
            long r21 = r4 / r16
            long r23 = r11 - r8
            r25 = r11
            long r11 = r23 + r21
        L_0x00f7:
            long r21 = java.lang.System.currentTimeMillis()
            long r21 = r21 - r8
            int r2 = (r21 > r11 ? 1 : (r21 == r11 ? 0 : -1))
            if (r2 >= 0) goto L_0x0109
            com.wowza.gocoder.sdk.api.status.WOWZStatus r2 = r1.mBroadcasterStatus
            boolean r2 = r2.isRunning()
            if (r2 != 0) goto L_0x00f7
        L_0x0109:
            com.wowza.gocoder.sdk.api.status.WOWZStatus r2 = r1.mBroadcasterStatus
            boolean r2 = r2.isRunning()
            if (r2 != 0) goto L_0x0113
            goto L_0x019c
        L_0x0113:
            int r2 = r0.length
            r21 = r8
            r8 = 0
        L_0x0117:
            if (r8 >= r2) goto L_0x0156
            r9 = r0[r8]
            boolean r0 = r9 instanceof com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.StreamingVideoSink
            if (r0 == 0) goto L_0x012a
            byte[] r0 = new byte[r3]
            r13.get(r0)
            com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI$StreamingVideoSink r9 = (com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.StreamingVideoSink) r9
            r9.onVideoFrame(r11, r0, r3)
            goto L_0x014d
        L_0x012a:
            if (r7 == 0) goto L_0x014d
            boolean r0 = r9 instanceof com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.MediaCodecVideoSink
            if (r0 == 0) goto L_0x014d
            int r0 = r6.getSampleFlags()
            r23 = 1
            r0 = r0 & 1
            if (r0 == 0) goto L_0x013c
            r0 = 1
            goto L_0x013d
        L_0x013c:
            r0 = 0
        L_0x013d:
            r7.presentationTimeUs = r4
            r7.size = r3
            r7.flags = r0
            r0 = r2
            r2 = 0
            r7.offset = r2
            com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI$MediaCodecVideoSink r9 = (com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.MediaCodecVideoSink) r9
            r9.onVideoFrame(r11, r13, r7)
            goto L_0x0150
        L_0x014d:
            r0 = r2
            r23 = 1
        L_0x0150:
            int r8 = r8 + 1
            r2 = r0
            r0 = r30
            goto L_0x0117
        L_0x0156:
            r23 = 1
            r13.clear()
            r6.advance()
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.mBroadcasterStatus
            boolean r0 = r0.isRunning()
            if (r0 != 0) goto L_0x0167
            goto L_0x019c
        L_0x0167:
            r9 = r18
        L_0x0169:
            if (r9 == 0) goto L_0x01b0
            boolean r0 = r1.f3825e
            if (r0 == 0) goto L_0x019c
        L_0x016f:
            long r2 = java.lang.System.currentTimeMillis()
            int r0 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r0 >= 0) goto L_0x017f
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.mBroadcasterStatus
            boolean r0 = r0.isRunning()
            if (r0 != 0) goto L_0x016f
        L_0x017f:
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.mBroadcasterStatus
            boolean r0 = r0.isRunning()
            if (r0 != 0) goto L_0x0188
            goto L_0x019c
        L_0x0188:
            r2 = 0
            r0 = 2
            r6.seekTo(r2, r0)
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r2 + r19
            r11 = r2
            r14 = r4
            r2 = 4
            r3 = 0
            r4 = 0
            r18 = 0
            goto L_0x01b8
        L_0x019c:
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3829i
            r2 = 4
            r0.setState(r2)
            r6.unselectTrack(r10)
            r6.release()
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3829i
            r3 = 0
            r0.setState(r3)
            r4 = 0
            return r4
        L_0x01b0:
            r0 = 2
            r2 = 4
            r3 = 0
            r4 = 0
            r18 = r9
            r11 = r25
        L_0x01b8:
            r0 = r30
            r4 = r19
            r8 = r21
            r2 = 0
            goto L_0x00d4
        L_0x01c1:
            r0 = move-exception
            r3 = 0
            r2 = r0
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3829i
            r0.setState(r3)
            r6.release()
            com.wowza.gocoder.sdk.api.errors.WOWZError r0 = new com.wowza.gocoder.sdk.api.errors.WOWZError
            java.lang.String r3 = f3821a
            r0.<init>((java.lang.String) r3, (java.lang.Exception) r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.mp4.WOWZMP4Broadcaster.m3641a(android.content.Context, android.net.Uri, com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI$VideoSink[], long):com.wowza.gocoder.sdk.api.errors.WOWZError");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0110 A[LOOP:4: B:44:0x0110->B:47:0x011e, LOOP_START] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.wowza.gocoder.sdk.api.errors.WOWZError m3640a(android.content.Context r29, android.net.Uri r30, com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.AudioSink[] r31, long r32) {
        /*
            r28 = this;
            r1 = r28
            r0 = r31
            r2 = 1000(0x3e8, double:4.94E-321)
            long r4 = r32 / r2
            com.wowza.gocoder.sdk.api.status.WOWZStatus r6 = r1.f3832l
            r7 = 1
            r6.setState(r7)
            android.media.MediaExtractor r6 = new android.media.MediaExtractor
            r6.<init>()
            r8 = 0
            r9 = 0
            r10 = r29
            r11 = r30
            r6.setDataSource(r10, r11, r8)     // Catch:{ Exception -> 0x0164 }
            java.lang.String r10 = "audio/"
            int r10 = com.wowza.gocoder.sdk.api.mp4.WOWZMP4Util.findTrackIndexByMimeType(r6, r10)
            r11 = -1
            r12 = 4
            if (r10 != r11) goto L_0x003b
            java.lang.String r0 = f3821a
            java.lang.String r2 = "No audio track found in MP4 file."
            com.wowza.gocoder.sdk.api.logging.WOWZLog.warn((java.lang.String) r0, (java.lang.String) r2)
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3832l
            r0.setState(r12)
            r6.release()
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3832l
            r0.setState(r9)
            return r8
        L_0x003b:
            android.media.MediaFormat r11 = r6.getTrackFormat(r10)
            java.lang.String r13 = "sample-rate"
            int r13 = r11.getInteger(r13)
            java.lang.String r14 = "max-input-size"
            int r14 = r11.getInteger(r14)
            java.nio.ByteBuffer r14 = java.nio.ByteBuffer.allocate(r14)
            int r15 = r0.length
            r7 = 0
        L_0x0051:
            if (r7 >= r15) goto L_0x006b
            r12 = r0[r7]
            boolean r2 = r12 instanceof com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.MediaCodecAudioSink
            if (r2 == 0) goto L_0x0065
            if (r8 != 0) goto L_0x0060
            android.media.MediaCodec$BufferInfo r8 = new android.media.MediaCodec$BufferInfo
            r8.<init>()
        L_0x0060:
            com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI$MediaCodecAudioSink r12 = (com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.MediaCodecAudioSink) r12
            r12.onAudioFormat(r11)
        L_0x0065:
            int r7 = r7 + 1
            r2 = 1000(0x3e8, double:4.94E-321)
            r12 = 4
            goto L_0x0051
        L_0x006b:
            r6.selectTrack(r10)
            r2 = 2
            r11 = 0
            r6.seekTo(r11, r2)
            com.wowza.gocoder.sdk.api.status.WOWZStatus r3 = r1.f3832l
            r3.setState(r2)
            com.wowza.gocoder.sdk.api.status.WOWZStatus r3 = r1.f3832l
            r7 = 3
            r3.setState(r7)
            long r18 = java.lang.System.currentTimeMillis()
            long r20 = r18 + r4
            r22 = r20
            r7 = 0
            r20 = r11
        L_0x008a:
            int r3 = r6.readSampleData(r14, r9)
            if (r3 >= 0) goto L_0x0095
            r26 = r4
            r9 = 1
            goto L_0x010a
        L_0x0095:
            r15 = 1000(0x3e8, double:4.94E-321)
            long r24 = r20 * r15
            long r11 = (long) r13
            long r11 = r24 / r11
        L_0x009c:
            long r24 = java.lang.System.currentTimeMillis()
            long r24 = r24 - r18
            int r17 = (r24 > r11 ? 1 : (r24 == r11 ? 0 : -1))
            if (r17 >= 0) goto L_0x00b2
            com.wowza.gocoder.sdk.api.status.WOWZStatus r15 = r1.mBroadcasterStatus
            boolean r15 = r15.isRunning()
            if (r15 != 0) goto L_0x00af
            goto L_0x00b2
        L_0x00af:
            r15 = 1000(0x3e8, double:4.94E-321)
            goto L_0x009c
        L_0x00b2:
            com.wowza.gocoder.sdk.api.status.WOWZStatus r15 = r1.mBroadcasterStatus
            boolean r15 = r15.isRunning()
            if (r15 != 0) goto L_0x00bc
            goto L_0x013d
        L_0x00bc:
            int r15 = r0.length
            r2 = 0
        L_0x00be:
            if (r2 >= r15) goto L_0x00f4
            r9 = r0[r2]
            boolean r0 = r9 instanceof com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.StreamingAudioSink
            if (r0 == 0) goto L_0x00d1
            byte[] r0 = new byte[r3]
            r14.get(r0)
            com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI$StreamingAudioSink r9 = (com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.StreamingAudioSink) r9
            r9.onAudioFrame(r11, r0, r3)
            goto L_0x00ea
        L_0x00d1:
            if (r8 == 0) goto L_0x00ea
            boolean r0 = r9 instanceof com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.MediaCodecAudioSink
            if (r0 == 0) goto L_0x00ea
            r26 = r4
            long r4 = r6.getSampleTime()
            r8.presentationTimeUs = r4
            r8.size = r3
            r4 = 0
            r8.offset = r4
            com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI$MediaCodecAudioSink r9 = (com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI.MediaCodecAudioSink) r9
            r9.onAudioSample(r11, r14, r8)
            goto L_0x00ec
        L_0x00ea:
            r26 = r4
        L_0x00ec:
            int r2 = r2 + 1
            r0 = r31
            r4 = r26
            r9 = 0
            goto L_0x00be
        L_0x00f4:
            r26 = r4
            r2 = 1024(0x400, double:5.06E-321)
            long r20 = r20 + r2
            r14.clear()
            r6.advance()
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.mBroadcasterStatus
            boolean r0 = r0.isRunning()
            if (r0 != 0) goto L_0x0109
            goto L_0x013d
        L_0x0109:
            r9 = r7
        L_0x010a:
            if (r9 == 0) goto L_0x0151
            boolean r0 = r1.f3825e
            if (r0 == 0) goto L_0x013d
        L_0x0110:
            long r2 = java.lang.System.currentTimeMillis()
            int r0 = (r2 > r22 ? 1 : (r2 == r22 ? 0 : -1))
            if (r0 >= 0) goto L_0x0120
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.mBroadcasterStatus
            boolean r0 = r0.isRunning()
            if (r0 != 0) goto L_0x0110
        L_0x0120:
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.mBroadcasterStatus
            boolean r0 = r0.isRunning()
            if (r0 != 0) goto L_0x0129
            goto L_0x013d
        L_0x0129:
            r0 = 2
            r2 = 0
            r6.seekTo(r2, r0)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 + r26
            r22 = r4
            r4 = 4
            r5 = 0
            r7 = 0
            r16 = 0
            goto L_0x0159
        L_0x013d:
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3832l
            r4 = 4
            r0.setState(r4)
            r6.unselectTrack(r10)
            r6.release()
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3832l
            r5 = 0
            r0.setState(r5)
            r7 = 0
            return r7
        L_0x0151:
            r0 = 2
            r2 = 0
            r4 = 4
            r5 = 0
            r7 = 0
            r16 = r9
        L_0x0159:
            r0 = r31
            r11 = r2
            r7 = r16
            r4 = r26
            r2 = 2
            r9 = 0
            goto L_0x008a
        L_0x0164:
            r0 = move-exception
            r5 = 0
            r2 = r0
            com.wowza.gocoder.sdk.api.status.WOWZStatus r0 = r1.f3832l
            r0.setState(r5)
            r6.release()
            com.wowza.gocoder.sdk.api.errors.WOWZError r0 = new com.wowza.gocoder.sdk.api.errors.WOWZError
            java.lang.String r3 = f3821a
            r0.<init>((java.lang.String) r3, (java.lang.Exception) r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wowza.gocoder.sdk.api.mp4.WOWZMP4Broadcaster.m3640a(android.content.Context, android.net.Uri, com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI$AudioSink[], long):com.wowza.gocoder.sdk.api.errors.WOWZError");
    }
}
