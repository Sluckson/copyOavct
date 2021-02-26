package com.google.android.exoplayer2.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.C1119C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.TimedValueQueue;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final byte[] ADAPTATION_WORKAROUND_BUFFER = Util.getBytesFromHexString("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private static final int ADAPTATION_WORKAROUND_MODE_ALWAYS = 2;
    private static final int ADAPTATION_WORKAROUND_MODE_NEVER = 0;
    private static final int ADAPTATION_WORKAROUND_MODE_SAME_RESOLUTION = 1;
    private static final int ADAPTATION_WORKAROUND_SLICE_WIDTH_HEIGHT = 32;
    protected static final float CODEC_OPERATING_RATE_UNSET = -1.0f;
    private static final int DRAIN_ACTION_FLUSH = 1;
    private static final int DRAIN_ACTION_NONE = 0;
    private static final int DRAIN_ACTION_REINITIALIZE = 3;
    private static final int DRAIN_ACTION_UPDATE_DRM_SESSION = 2;
    private static final int DRAIN_STATE_NONE = 0;
    private static final int DRAIN_STATE_SIGNAL_END_OF_STREAM = 1;
    private static final int DRAIN_STATE_WAIT_END_OF_STREAM = 2;
    protected static final int KEEP_CODEC_RESULT_NO = 0;
    protected static final int KEEP_CODEC_RESULT_YES_WITHOUT_RECONFIGURATION = 3;
    protected static final int KEEP_CODEC_RESULT_YES_WITH_FLUSH = 1;
    protected static final int KEEP_CODEC_RESULT_YES_WITH_RECONFIGURATION = 2;
    private static final long MAX_CODEC_HOTSWAP_TIME_MS = 1000;
    private static final int RECONFIGURATION_STATE_NONE = 0;
    private static final int RECONFIGURATION_STATE_QUEUE_PENDING = 2;
    private static final int RECONFIGURATION_STATE_WRITE_PENDING = 1;
    private static final String TAG = "MediaCodecRenderer";
    private final float assumedMinimumCodecOperatingRate;
    @Nullable
    private ArrayDeque<MediaCodecInfo> availableCodecInfos;
    private final DecoderInputBuffer buffer = new DecoderInputBuffer(0);
    @Nullable
    private MediaCodec codec;
    private int codecAdaptationWorkaroundMode;
    private int codecDrainAction = 0;
    private int codecDrainState = 0;
    @Nullable
    private DrmSession<FrameworkMediaCrypto> codecDrmSession;
    @Nullable
    private Format codecFormat;
    private long codecHotswapDeadlineMs;
    @Nullable
    private MediaCodecInfo codecInfo;
    private boolean codecNeedsAdaptationWorkaroundBuffer;
    private boolean codecNeedsDiscardToSpsWorkaround;
    private boolean codecNeedsEosFlushWorkaround;
    private boolean codecNeedsEosOutputExceptionWorkaround;
    private boolean codecNeedsEosPropagation;
    private boolean codecNeedsFlushWorkaround;
    private boolean codecNeedsMonoChannelCountWorkaround;
    private boolean codecNeedsReconfigureWorkaround;
    private float codecOperatingRate = -1.0f;
    private boolean codecReceivedBuffers;
    private boolean codecReceivedEos;
    private int codecReconfigurationState = 0;
    private boolean codecReconfigured;
    private final ArrayList<Long> decodeOnlyPresentationTimestamps = new ArrayList<>();
    protected DecoderCounters decoderCounters;
    @Nullable
    private final DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
    private final boolean enableDecoderFallback;
    private final DecoderInputBuffer flagsOnlyBuffer = DecoderInputBuffer.newFlagsOnlyInstance();
    private final FormatHolder formatHolder = new FormatHolder();
    private final TimedValueQueue<Format> formatQueue = new TimedValueQueue<>();
    private ByteBuffer[] inputBuffers;
    @Nullable
    private Format inputFormat;
    private int inputIndex;
    private boolean inputStreamEnded;
    private boolean isDecodeOnlyOutputBuffer;
    private boolean isLastOutputBuffer;
    private long largestQueuedPresentationTimeUs;
    private long lastBufferInStreamPresentationTimeUs;
    private final MediaCodecSelector mediaCodecSelector;
    @Nullable
    private MediaCrypto mediaCrypto;
    private boolean mediaCryptoRequiresSecureDecoder;
    private ByteBuffer outputBuffer;
    private final MediaCodec.BufferInfo outputBufferInfo = new MediaCodec.BufferInfo();
    private ByteBuffer[] outputBuffers;
    private Format outputFormat;
    private int outputIndex;
    private boolean outputStreamEnded;
    private final boolean playClearSamplesWithoutKeys;
    @Nullable
    private DecoderInitializationException preferredDecoderInitializationException;
    private long renderTimeLimitMs = C1119C.TIME_UNSET;
    private float rendererOperatingRate = 1.0f;
    private boolean shouldSkipAdaptationWorkaroundOutputBuffer;
    @Nullable
    private DrmSession<FrameworkMediaCrypto> sourceDrmSession;
    private boolean waitingForFirstSampleInFormat;
    private boolean waitingForFirstSyncSample;
    private boolean waitingForKeys;

    /* access modifiers changed from: protected */
    public int canKeepCodec(MediaCodec mediaCodec, MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract void configureCodec(MediaCodecInfo mediaCodecInfo, MediaCodec mediaCodec, Format format, MediaCrypto mediaCrypto2, float f);

    /* access modifiers changed from: protected */
    public boolean getCodecNeedsEosPropagation() {
        return false;
    }

    /* access modifiers changed from: protected */
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        return -1.0f;
    }

    /* access modifiers changed from: protected */
    public abstract List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector2, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException;

    /* access modifiers changed from: protected */
    public long getDequeueOutputBufferTimeoutUs() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onCodecInitialized(String str, long j, long j2) {
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void onProcessedOutputBuffer(long j) {
    }

    /* access modifiers changed from: protected */
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) {
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean processOutputBuffer(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public void renderToEndOfStream() throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract int supportsFormat(MediaCodecSelector mediaCodecSelector2, DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, Format format) throws MediaCodecUtil.DecoderQueryException;

    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    public static class DecoderInitializationException extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;
        public final String decoderName;
        public final String diagnosticInfo;
        @Nullable
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(Format format, Throwable th, boolean z, int i) {
            this("Decoder init failed: [" + i + "], " + format, th, format.sampleMimeType, z, (String) null, buildCustomDiagnosticInfo(i), (DecoderInitializationException) null);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public DecoderInitializationException(com.google.android.exoplayer2.Format r11, java.lang.Throwable r12, boolean r13, java.lang.String r14) {
            /*
                r10 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Decoder init failed: "
                r0.append(r1)
                r0.append(r14)
                java.lang.String r1 = ", "
                r0.append(r1)
                r0.append(r11)
                java.lang.String r3 = r0.toString()
                java.lang.String r5 = r11.sampleMimeType
                int r11 = com.google.android.exoplayer2.util.Util.SDK_INT
                r0 = 21
                if (r11 < r0) goto L_0x0026
                java.lang.String r11 = getDiagnosticInfoV21(r12)
                goto L_0x0027
            L_0x0026:
                r11 = 0
            L_0x0027:
                r8 = r11
                r9 = 0
                r2 = r10
                r4 = r12
                r6 = r13
                r7 = r14
                r2.<init>(r3, r4, r5, r6, r7, r8, r9)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException.<init>(com.google.android.exoplayer2.Format, java.lang.Throwable, boolean, java.lang.String):void");
        }

        private DecoderInitializationException(String str, Throwable th, String str2, boolean z, @Nullable String str3, @Nullable String str4, @Nullable DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.mimeType = str2;
            this.secureDecoderRequired = z;
            this.decoderName = str3;
            this.diagnosticInfo = str4;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }

        /* access modifiers changed from: private */
        @CheckResult
        public DecoderInitializationException copyWithFallbackException(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.decoderName, this.diagnosticInfo, decoderInitializationException);
        }

        @TargetApi(21)
        private static String getDiagnosticInfoV21(Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        private static String buildCustomDiagnosticInfo(int i) {
            String str = i < 0 ? "neg_" : "";
            return "com.google.android.exoplayer.MediaCodecTrackRenderer_" + str + Math.abs(i);
        }
    }

    public MediaCodecRenderer(int i, MediaCodecSelector mediaCodecSelector2, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2, boolean z, boolean z2, float f) {
        super(i);
        this.mediaCodecSelector = (MediaCodecSelector) Assertions.checkNotNull(mediaCodecSelector2);
        this.drmSessionManager = drmSessionManager2;
        this.playClearSamplesWithoutKeys = z;
        this.enableDecoderFallback = z2;
        this.assumedMinimumCodecOperatingRate = f;
    }

    public void experimental_setRenderTimeLimitMs(long j) {
        this.renderTimeLimitMs = j;
    }

    public final int supportsFormat(Format format) throws ExoPlaybackException {
        try {
            return supportsFormat(this.mediaCodecSelector, this.drmSessionManager, format);
        } catch (MediaCodecUtil.DecoderQueryException e) {
            throw ExoPlaybackException.createForRenderer(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public final void maybeInitCodec() throws ExoPlaybackException {
        if (this.codec == null && this.inputFormat != null) {
            setCodecDrmSession(this.sourceDrmSession);
            String str = this.inputFormat.sampleMimeType;
            DrmSession<FrameworkMediaCrypto> drmSession = this.codecDrmSession;
            if (drmSession != null) {
                if (this.mediaCrypto == null) {
                    FrameworkMediaCrypto mediaCrypto2 = drmSession.getMediaCrypto();
                    if (mediaCrypto2 != null) {
                        try {
                            this.mediaCrypto = new MediaCrypto(mediaCrypto2.uuid, mediaCrypto2.sessionId);
                            this.mediaCryptoRequiresSecureDecoder = !mediaCrypto2.forceAllowInsecureDecoderComponents && this.mediaCrypto.requiresSecureDecoderComponent(str);
                        } catch (MediaCryptoException e) {
                            throw ExoPlaybackException.createForRenderer(e, getIndex());
                        }
                    } else if (this.codecDrmSession.getError() == null) {
                        return;
                    }
                }
                if (deviceNeedsDrmKeysToConfigureCodecWorkaround()) {
                    int state = this.codecDrmSession.getState();
                    if (state == 1) {
                        throw ExoPlaybackException.createForRenderer(this.codecDrmSession.getError(), getIndex());
                    } else if (state != 4) {
                        return;
                    }
                }
            }
            try {
                maybeInitCodecWithFallback(this.mediaCrypto, this.mediaCryptoRequiresSecureDecoder);
            } catch (DecoderInitializationException e2) {
                throw ExoPlaybackException.createForRenderer(e2, getIndex());
            }
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final Format updateOutputFormatForTime(long j) {
        Format pollFloor = this.formatQueue.pollFloor(j);
        if (pollFloor != null) {
            this.outputFormat = pollFloor;
        }
        return pollFloor;
    }

    /* access modifiers changed from: protected */
    public final MediaCodec getCodec() {
        return this.codec;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final MediaCodecInfo getCodecInfo() {
        return this.codecInfo;
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z) throws ExoPlaybackException {
        this.decoderCounters = new DecoderCounters();
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
        flushOrReinitializeCodec();
        this.formatQueue.clear();
    }

    public final void setOperatingRate(float f) throws ExoPlaybackException {
        this.rendererOperatingRate = f;
        if (this.codec != null && this.codecDrainAction != 3 && getState() != 0) {
            updateCodecOperatingRate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        this.inputFormat = null;
        if (this.sourceDrmSession == null && this.codecDrmSession == null) {
            flushOrReleaseCodec();
        } else {
            onReset();
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        try {
            releaseCodec();
        } finally {
            setSourceDrmSession((DrmSession<FrameworkMediaCrypto>) null);
        }
    }

    /* access modifiers changed from: protected */
    public void releaseCodec() {
        this.availableCodecInfos = null;
        this.codecInfo = null;
        this.codecFormat = null;
        resetInputBuffer();
        resetOutputBuffer();
        resetCodecBuffers();
        this.waitingForKeys = false;
        this.codecHotswapDeadlineMs = C1119C.TIME_UNSET;
        this.decodeOnlyPresentationTimestamps.clear();
        this.largestQueuedPresentationTimeUs = C1119C.TIME_UNSET;
        this.lastBufferInStreamPresentationTimeUs = C1119C.TIME_UNSET;
        try {
            if (this.codec != null) {
                this.decoderCounters.decoderReleaseCount++;
                this.codec.stop();
                this.codec.release();
            }
            this.codec = null;
            try {
                if (this.mediaCrypto != null) {
                    this.mediaCrypto.release();
                }
            } finally {
                this.mediaCrypto = null;
                this.mediaCryptoRequiresSecureDecoder = false;
                setCodecDrmSession((DrmSession<FrameworkMediaCrypto>) null);
            }
        } catch (Throwable th) {
            this.codec = null;
            try {
                if (this.mediaCrypto != null) {
                    this.mediaCrypto.release();
                }
                throw th;
            } finally {
                this.mediaCrypto = null;
                this.mediaCryptoRequiresSecureDecoder = false;
                setCodecDrmSession((DrmSession<FrameworkMediaCrypto>) null);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b A[LOOP:1: B:14:0x002b->B:17:0x0035, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void render(long r4, long r6) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r3 = this;
            boolean r0 = r3.outputStreamEnded
            if (r0 == 0) goto L_0x0008
            r3.renderToEndOfStream()
            return
        L_0x0008:
            com.google.android.exoplayer2.Format r0 = r3.inputFormat
            if (r0 != 0) goto L_0x0014
            r0 = 1
            boolean r0 = r3.readToFlagsOnlyBuffer(r0)
            if (r0 != 0) goto L_0x0014
            return
        L_0x0014:
            r3.maybeInitCodec()
            android.media.MediaCodec r0 = r3.codec
            if (r0 == 0) goto L_0x003c
            long r0 = android.os.SystemClock.elapsedRealtime()
            java.lang.String r2 = "drainAndFeed"
            com.google.android.exoplayer2.util.TraceUtil.beginSection(r2)
        L_0x0024:
            boolean r2 = r3.drainOutputBuffer(r4, r6)
            if (r2 == 0) goto L_0x002b
            goto L_0x0024
        L_0x002b:
            boolean r4 = r3.feedInputBuffer()
            if (r4 == 0) goto L_0x0038
            boolean r4 = r3.shouldContinueFeeding(r0)
            if (r4 == 0) goto L_0x0038
            goto L_0x002b
        L_0x0038:
            com.google.android.exoplayer2.util.TraceUtil.endSection()
            goto L_0x004b
        L_0x003c:
            com.google.android.exoplayer2.decoder.DecoderCounters r6 = r3.decoderCounters
            int r7 = r6.skippedInputBufferCount
            int r4 = r3.skipSource(r4)
            int r7 = r7 + r4
            r6.skippedInputBufferCount = r7
            r4 = 0
            r3.readToFlagsOnlyBuffer(r4)
        L_0x004b:
            com.google.android.exoplayer2.decoder.DecoderCounters r4 = r3.decoderCounters
            r4.ensureUpdated()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.render(long, long):void");
    }

    /* access modifiers changed from: protected */
    public final boolean flushOrReinitializeCodec() throws ExoPlaybackException {
        boolean flushOrReleaseCodec = flushOrReleaseCodec();
        if (flushOrReleaseCodec) {
            maybeInitCodec();
        }
        return flushOrReleaseCodec;
    }

    /* access modifiers changed from: protected */
    public boolean flushOrReleaseCodec() {
        if (this.codec == null) {
            return false;
        }
        if (this.codecDrainAction == 3 || this.codecNeedsFlushWorkaround || (this.codecNeedsEosFlushWorkaround && this.codecReceivedEos)) {
            releaseCodec();
            return true;
        }
        this.codec.flush();
        resetInputBuffer();
        resetOutputBuffer();
        this.codecHotswapDeadlineMs = C1119C.TIME_UNSET;
        this.codecReceivedEos = false;
        this.codecReceivedBuffers = false;
        this.waitingForFirstSyncSample = true;
        this.codecNeedsAdaptationWorkaroundBuffer = false;
        this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
        this.isDecodeOnlyOutputBuffer = false;
        this.isLastOutputBuffer = false;
        this.waitingForKeys = false;
        this.decodeOnlyPresentationTimestamps.clear();
        this.largestQueuedPresentationTimeUs = C1119C.TIME_UNSET;
        this.lastBufferInStreamPresentationTimeUs = C1119C.TIME_UNSET;
        this.codecDrainState = 0;
        this.codecDrainAction = 0;
        this.codecReconfigurationState = this.codecReconfigured ? 1 : 0;
        return false;
    }

    private boolean readToFlagsOnlyBuffer(boolean z) throws ExoPlaybackException {
        this.flagsOnlyBuffer.clear();
        int readSource = readSource(this.formatHolder, this.flagsOnlyBuffer, z);
        if (readSource == -5) {
            onInputFormatChanged(this.formatHolder.format);
            return true;
        } else if (readSource != -4 || !this.flagsOnlyBuffer.isEndOfStream()) {
            return false;
        } else {
            this.inputStreamEnded = true;
            processEndOfStream();
            return false;
        }
    }

    private void maybeInitCodecWithFallback(MediaCrypto mediaCrypto2, boolean z) throws DecoderInitializationException {
        if (this.availableCodecInfos == null) {
            try {
                List<MediaCodecInfo> availableCodecInfos2 = getAvailableCodecInfos(z);
                this.availableCodecInfos = new ArrayDeque<>();
                if (this.enableDecoderFallback) {
                    this.availableCodecInfos.addAll(availableCodecInfos2);
                } else if (!availableCodecInfos2.isEmpty()) {
                    this.availableCodecInfos.add(availableCodecInfos2.get(0));
                }
                this.preferredDecoderInitializationException = null;
            } catch (MediaCodecUtil.DecoderQueryException e) {
                throw new DecoderInitializationException(this.inputFormat, (Throwable) e, z, -49998);
            }
        }
        if (!this.availableCodecInfos.isEmpty()) {
            while (this.codec == null) {
                MediaCodecInfo peekFirst = this.availableCodecInfos.peekFirst();
                if (shouldInitCodec(peekFirst)) {
                    try {
                        initCodec(peekFirst, mediaCrypto2);
                    } catch (Exception e2) {
                        Log.m55w(TAG, "Failed to initialize decoder: " + peekFirst, e2);
                        this.availableCodecInfos.removeFirst();
                        DecoderInitializationException decoderInitializationException = new DecoderInitializationException(this.inputFormat, (Throwable) e2, z, peekFirst.name);
                        DecoderInitializationException decoderInitializationException2 = this.preferredDecoderInitializationException;
                        if (decoderInitializationException2 == null) {
                            this.preferredDecoderInitializationException = decoderInitializationException;
                        } else {
                            this.preferredDecoderInitializationException = decoderInitializationException2.copyWithFallbackException(decoderInitializationException);
                        }
                        if (this.availableCodecInfos.isEmpty()) {
                            throw this.preferredDecoderInitializationException;
                        }
                    }
                } else {
                    return;
                }
            }
            this.availableCodecInfos = null;
            return;
        }
        throw new DecoderInitializationException(this.inputFormat, (Throwable) null, z, -49999);
    }

    private List<MediaCodecInfo> getAvailableCodecInfos(boolean z) throws MediaCodecUtil.DecoderQueryException {
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(this.mediaCodecSelector, this.inputFormat, z);
        if (decoderInfos.isEmpty() && z) {
            decoderInfos = getDecoderInfos(this.mediaCodecSelector, this.inputFormat, false);
            if (!decoderInfos.isEmpty()) {
                Log.m54w(TAG, "Drm session requires secure decoder for " + this.inputFormat.sampleMimeType + ", but no secure decoder available. Trying to proceed with " + decoderInfos + ".");
            }
        }
        return decoderInfos;
    }

    private void initCodec(MediaCodecInfo mediaCodecInfo, MediaCrypto mediaCrypto2) throws Exception {
        float f;
        String str = mediaCodecInfo.name;
        if (Util.SDK_INT < 23) {
            f = -1.0f;
        } else {
            f = getCodecOperatingRateV23(this.rendererOperatingRate, this.inputFormat, getStreamFormats());
        }
        if (f <= this.assumedMinimumCodecOperatingRate) {
            f = -1.0f;
        }
        MediaCodec mediaCodec = null;
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            TraceUtil.beginSection("createCodec:" + str);
            mediaCodec = MediaCodec.createByCodecName(str);
            TraceUtil.endSection();
            TraceUtil.beginSection("configureCodec");
            configureCodec(mediaCodecInfo, mediaCodec, this.inputFormat, mediaCrypto2, f);
            TraceUtil.endSection();
            TraceUtil.beginSection("startCodec");
            mediaCodec.start();
            TraceUtil.endSection();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            getCodecBuffers(mediaCodec);
            this.codec = mediaCodec;
            this.codecInfo = mediaCodecInfo;
            this.codecOperatingRate = f;
            this.codecFormat = this.inputFormat;
            this.codecAdaptationWorkaroundMode = codecAdaptationWorkaroundMode(str);
            this.codecNeedsReconfigureWorkaround = codecNeedsReconfigureWorkaround(str);
            this.codecNeedsDiscardToSpsWorkaround = codecNeedsDiscardToSpsWorkaround(str, this.codecFormat);
            this.codecNeedsFlushWorkaround = codecNeedsFlushWorkaround(str);
            this.codecNeedsEosFlushWorkaround = codecNeedsEosFlushWorkaround(str);
            this.codecNeedsEosOutputExceptionWorkaround = codecNeedsEosOutputExceptionWorkaround(str);
            this.codecNeedsMonoChannelCountWorkaround = codecNeedsMonoChannelCountWorkaround(str, this.codecFormat);
            this.codecNeedsEosPropagation = codecNeedsEosPropagationWorkaround(mediaCodecInfo) || getCodecNeedsEosPropagation();
            resetInputBuffer();
            resetOutputBuffer();
            this.codecHotswapDeadlineMs = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : C1119C.TIME_UNSET;
            this.codecReconfigured = false;
            this.codecReconfigurationState = 0;
            this.codecReceivedEos = false;
            this.codecReceivedBuffers = false;
            this.codecDrainState = 0;
            this.codecDrainAction = 0;
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            this.shouldSkipAdaptationWorkaroundOutputBuffer = false;
            this.isDecodeOnlyOutputBuffer = false;
            this.isLastOutputBuffer = false;
            this.waitingForFirstSyncSample = true;
            this.decoderCounters.decoderInitCount++;
            onCodecInitialized(str, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
        } catch (Exception e) {
            if (mediaCodec != null) {
                resetCodecBuffers();
                mediaCodec.release();
            }
            throw e;
        }
    }

    private boolean shouldContinueFeeding(long j) {
        return this.renderTimeLimitMs == C1119C.TIME_UNSET || SystemClock.elapsedRealtime() - j < this.renderTimeLimitMs;
    }

    private void getCodecBuffers(MediaCodec mediaCodec) {
        if (Util.SDK_INT < 21) {
            this.inputBuffers = mediaCodec.getInputBuffers();
            this.outputBuffers = mediaCodec.getOutputBuffers();
        }
    }

    private void resetCodecBuffers() {
        if (Util.SDK_INT < 21) {
            this.inputBuffers = null;
            this.outputBuffers = null;
        }
    }

    private ByteBuffer getInputBuffer(int i) {
        if (Util.SDK_INT >= 21) {
            return this.codec.getInputBuffer(i);
        }
        return this.inputBuffers[i];
    }

    private ByteBuffer getOutputBuffer(int i) {
        if (Util.SDK_INT >= 21) {
            return this.codec.getOutputBuffer(i);
        }
        return this.outputBuffers[i];
    }

    private boolean hasOutputBuffer() {
        return this.outputIndex >= 0;
    }

    private void resetInputBuffer() {
        this.inputIndex = -1;
        this.buffer.data = null;
    }

    private void resetOutputBuffer() {
        this.outputIndex = -1;
        this.outputBuffer = null;
    }

    private void setSourceDrmSession(@Nullable DrmSession<FrameworkMediaCrypto> drmSession) {
        DrmSession<FrameworkMediaCrypto> drmSession2 = this.sourceDrmSession;
        this.sourceDrmSession = drmSession;
        releaseDrmSessionIfUnused(drmSession2);
    }

    private void setCodecDrmSession(@Nullable DrmSession<FrameworkMediaCrypto> drmSession) {
        DrmSession<FrameworkMediaCrypto> drmSession2 = this.codecDrmSession;
        this.codecDrmSession = drmSession;
        releaseDrmSessionIfUnused(drmSession2);
    }

    private void releaseDrmSessionIfUnused(@Nullable DrmSession<FrameworkMediaCrypto> drmSession) {
        if (drmSession != null && drmSession != this.sourceDrmSession && drmSession != this.codecDrmSession) {
            this.drmSessionManager.releaseSession(drmSession);
        }
    }

    private boolean feedInputBuffer() throws ExoPlaybackException {
        int i;
        int i2;
        MediaCodec mediaCodec = this.codec;
        if (mediaCodec == null || this.codecDrainState == 2 || this.inputStreamEnded) {
            return false;
        }
        if (this.inputIndex < 0) {
            this.inputIndex = mediaCodec.dequeueInputBuffer(0);
            int i3 = this.inputIndex;
            if (i3 < 0) {
                return false;
            }
            this.buffer.data = getInputBuffer(i3);
            this.buffer.clear();
        }
        if (this.codecDrainState == 1) {
            if (!this.codecNeedsEosPropagation) {
                this.codecReceivedEos = true;
                this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0, 4);
                resetInputBuffer();
            }
            this.codecDrainState = 2;
            return false;
        } else if (this.codecNeedsAdaptationWorkaroundBuffer) {
            this.codecNeedsAdaptationWorkaroundBuffer = false;
            this.buffer.data.put(ADAPTATION_WORKAROUND_BUFFER);
            this.codec.queueInputBuffer(this.inputIndex, 0, ADAPTATION_WORKAROUND_BUFFER.length, 0, 0);
            resetInputBuffer();
            this.codecReceivedBuffers = true;
            return true;
        } else {
            if (this.waitingForKeys) {
                i2 = -4;
                i = 0;
            } else {
                if (this.codecReconfigurationState == 1) {
                    for (int i4 = 0; i4 < this.codecFormat.initializationData.size(); i4++) {
                        this.buffer.data.put(this.codecFormat.initializationData.get(i4));
                    }
                    this.codecReconfigurationState = 2;
                }
                i = this.buffer.data.position();
                i2 = readSource(this.formatHolder, this.buffer, false);
            }
            if (hasReadStreamToEnd()) {
                this.lastBufferInStreamPresentationTimeUs = this.largestQueuedPresentationTimeUs;
            }
            if (i2 == -3) {
                return false;
            }
            if (i2 == -5) {
                if (this.codecReconfigurationState == 2) {
                    this.buffer.clear();
                    this.codecReconfigurationState = 1;
                }
                onInputFormatChanged(this.formatHolder.format);
                return true;
            } else if (this.buffer.isEndOfStream()) {
                if (this.codecReconfigurationState == 2) {
                    this.buffer.clear();
                    this.codecReconfigurationState = 1;
                }
                this.inputStreamEnded = true;
                if (!this.codecReceivedBuffers) {
                    processEndOfStream();
                    return false;
                }
                try {
                    if (!this.codecNeedsEosPropagation) {
                        this.codecReceivedEos = true;
                        this.codec.queueInputBuffer(this.inputIndex, 0, 0, 0, 4);
                        resetInputBuffer();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e) {
                    throw ExoPlaybackException.createForRenderer(e, getIndex());
                }
            } else if (!this.waitingForFirstSyncSample || this.buffer.isKeyFrame()) {
                this.waitingForFirstSyncSample = false;
                boolean isEncrypted = this.buffer.isEncrypted();
                this.waitingForKeys = shouldWaitForKeys(isEncrypted);
                if (this.waitingForKeys) {
                    return false;
                }
                if (this.codecNeedsDiscardToSpsWorkaround && !isEncrypted) {
                    NalUnitUtil.discardToSps(this.buffer.data);
                    if (this.buffer.data.position() == 0) {
                        return true;
                    }
                    this.codecNeedsDiscardToSpsWorkaround = false;
                }
                try {
                    long j = this.buffer.timeUs;
                    if (this.buffer.isDecodeOnly()) {
                        this.decodeOnlyPresentationTimestamps.add(Long.valueOf(j));
                    }
                    if (this.waitingForFirstSampleInFormat) {
                        this.formatQueue.add(j, this.inputFormat);
                        this.waitingForFirstSampleInFormat = false;
                    }
                    this.largestQueuedPresentationTimeUs = Math.max(this.largestQueuedPresentationTimeUs, j);
                    this.buffer.flip();
                    onQueueInputBuffer(this.buffer);
                    if (isEncrypted) {
                        this.codec.queueSecureInputBuffer(this.inputIndex, 0, getFrameworkCryptoInfo(this.buffer, i), j, 0);
                    } else {
                        this.codec.queueInputBuffer(this.inputIndex, 0, this.buffer.data.limit(), j, 0);
                    }
                    resetInputBuffer();
                    this.codecReceivedBuffers = true;
                    this.codecReconfigurationState = 0;
                    this.decoderCounters.inputBufferCount++;
                    return true;
                } catch (MediaCodec.CryptoException e2) {
                    throw ExoPlaybackException.createForRenderer(e2, getIndex());
                }
            } else {
                this.buffer.clear();
                if (this.codecReconfigurationState == 2) {
                    this.codecReconfigurationState = 1;
                }
                return true;
            }
        }
    }

    private boolean shouldWaitForKeys(boolean z) throws ExoPlaybackException {
        if (this.codecDrmSession == null || (!z && this.playClearSamplesWithoutKeys)) {
            return false;
        }
        int state = this.codecDrmSession.getState();
        if (state != 1) {
            return state != 4;
        }
        throw ExoPlaybackException.createForRenderer(this.codecDrmSession.getError(), getIndex());
    }

    /* access modifiers changed from: protected */
    public void onInputFormatChanged(Format format) throws ExoPlaybackException {
        Format format2 = this.inputFormat;
        this.inputFormat = format;
        boolean z = true;
        this.waitingForFirstSampleInFormat = true;
        if (!Util.areEqual(format.drmInitData, format2 == null ? null : format2.drmInitData)) {
            if (format.drmInitData != null) {
                DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2 = this.drmSessionManager;
                if (drmSessionManager2 != null) {
                    DrmSession<FrameworkMediaCrypto> acquireSession = drmSessionManager2.acquireSession(Looper.myLooper(), format.drmInitData);
                    if (acquireSession == this.sourceDrmSession || acquireSession == this.codecDrmSession) {
                        this.drmSessionManager.releaseSession(acquireSession);
                    }
                    setSourceDrmSession(acquireSession);
                } else {
                    throw ExoPlaybackException.createForRenderer(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
            } else {
                setSourceDrmSession((DrmSession<FrameworkMediaCrypto>) null);
            }
        }
        if (this.codec == null) {
            maybeInitCodec();
        } else if ((this.sourceDrmSession != null || this.codecDrmSession == null) && ((this.sourceDrmSession == null || this.codecDrmSession != null) && ((this.sourceDrmSession == null || this.codecInfo.secure) && (Util.SDK_INT >= 23 || this.sourceDrmSession == this.codecDrmSession)))) {
            int canKeepCodec = canKeepCodec(this.codec, this.codecInfo, this.codecFormat, format);
            if (canKeepCodec == 0) {
                drainAndReinitializeCodec();
            } else if (canKeepCodec == 1) {
                this.codecFormat = format;
                updateCodecOperatingRate();
                if (this.sourceDrmSession != this.codecDrmSession) {
                    drainAndUpdateCodecDrmSession();
                } else {
                    drainAndFlushCodec();
                }
            } else if (canKeepCodec != 2) {
                if (canKeepCodec == 3) {
                    this.codecFormat = format;
                    updateCodecOperatingRate();
                    if (this.sourceDrmSession != this.codecDrmSession) {
                        drainAndUpdateCodecDrmSession();
                        return;
                    }
                    return;
                }
                throw new IllegalStateException();
            } else if (this.codecNeedsReconfigureWorkaround) {
                drainAndReinitializeCodec();
            } else {
                this.codecReconfigured = true;
                this.codecReconfigurationState = 1;
                int i = this.codecAdaptationWorkaroundMode;
                if (!(i == 2 || (i == 1 && format.width == this.codecFormat.width && format.height == this.codecFormat.height))) {
                    z = false;
                }
                this.codecNeedsAdaptationWorkaroundBuffer = z;
                this.codecFormat = format;
                updateCodecOperatingRate();
                if (this.sourceDrmSession != this.codecDrmSession) {
                    drainAndUpdateCodecDrmSession();
                }
            }
        } else {
            drainAndReinitializeCodec();
        }
    }

    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    public boolean isReady() {
        return this.inputFormat != null && !this.waitingForKeys && (isSourceReady() || hasOutputBuffer() || (this.codecHotswapDeadlineMs != C1119C.TIME_UNSET && SystemClock.elapsedRealtime() < this.codecHotswapDeadlineMs));
    }

    private void updateCodecOperatingRate() throws ExoPlaybackException {
        if (Util.SDK_INT >= 23) {
            float codecOperatingRateV23 = getCodecOperatingRateV23(this.rendererOperatingRate, this.codecFormat, getStreamFormats());
            float f = this.codecOperatingRate;
            if (f != codecOperatingRateV23) {
                if (codecOperatingRateV23 == -1.0f) {
                    drainAndReinitializeCodec();
                } else if (f != -1.0f || codecOperatingRateV23 > this.assumedMinimumCodecOperatingRate) {
                    Bundle bundle = new Bundle();
                    bundle.putFloat("operating-rate", codecOperatingRateV23);
                    this.codec.setParameters(bundle);
                    this.codecOperatingRate = codecOperatingRateV23;
                }
            }
        }
    }

    private void drainAndFlushCodec() {
        if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 1;
        }
    }

    private void drainAndUpdateCodecDrmSession() throws ExoPlaybackException {
        if (Util.SDK_INT < 23) {
            drainAndReinitializeCodec();
        } else if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 2;
        } else {
            updateDrmSessionOrReinitializeCodecV23();
        }
    }

    private void drainAndReinitializeCodec() throws ExoPlaybackException {
        if (this.codecReceivedBuffers) {
            this.codecDrainState = 1;
            this.codecDrainAction = 3;
            return;
        }
        reinitializeCodec();
    }

    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ef  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean drainOutputBuffer(long r19, long r21) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r18 = this;
            r14 = r18
            boolean r0 = r18.hasOutputBuffer()
            r15 = 1
            r13 = 0
            if (r0 != 0) goto L_0x00b7
            boolean r0 = r14.codecNeedsEosOutputExceptionWorkaround
            if (r0 == 0) goto L_0x002b
            boolean r0 = r14.codecReceivedEos
            if (r0 == 0) goto L_0x002b
            android.media.MediaCodec r0 = r14.codec     // Catch:{ IllegalStateException -> 0x001f }
            android.media.MediaCodec$BufferInfo r1 = r14.outputBufferInfo     // Catch:{ IllegalStateException -> 0x001f }
            long r2 = r18.getDequeueOutputBufferTimeoutUs()     // Catch:{ IllegalStateException -> 0x001f }
            int r0 = r0.dequeueOutputBuffer(r1, r2)     // Catch:{ IllegalStateException -> 0x001f }
            goto L_0x0037
        L_0x001f:
            r18.processEndOfStream()
            boolean r0 = r14.outputStreamEnded
            if (r0 == 0) goto L_0x002a
            r18.releaseCodec()
        L_0x002a:
            return r13
        L_0x002b:
            android.media.MediaCodec r0 = r14.codec
            android.media.MediaCodec$BufferInfo r1 = r14.outputBufferInfo
            long r2 = r18.getDequeueOutputBufferTimeoutUs()
            int r0 = r0.dequeueOutputBuffer(r1, r2)
        L_0x0037:
            if (r0 >= 0) goto L_0x0058
            r1 = -2
            if (r0 != r1) goto L_0x0040
            r18.processOutputFormat()
            return r15
        L_0x0040:
            r1 = -3
            if (r0 != r1) goto L_0x0047
            r18.processOutputBuffersChanged()
            return r15
        L_0x0047:
            boolean r0 = r14.codecNeedsEosPropagation
            if (r0 == 0) goto L_0x0057
            boolean r0 = r14.inputStreamEnded
            if (r0 != 0) goto L_0x0054
            int r0 = r14.codecDrainState
            r1 = 2
            if (r0 != r1) goto L_0x0057
        L_0x0054:
            r18.processEndOfStream()
        L_0x0057:
            return r13
        L_0x0058:
            boolean r1 = r14.shouldSkipAdaptationWorkaroundOutputBuffer
            if (r1 == 0) goto L_0x0064
            r14.shouldSkipAdaptationWorkaroundOutputBuffer = r13
            android.media.MediaCodec r1 = r14.codec
            r1.releaseOutputBuffer(r0, r13)
            return r15
        L_0x0064:
            android.media.MediaCodec$BufferInfo r1 = r14.outputBufferInfo
            int r1 = r1.size
            if (r1 != 0) goto L_0x0076
            android.media.MediaCodec$BufferInfo r1 = r14.outputBufferInfo
            int r1 = r1.flags
            r1 = r1 & 4
            if (r1 == 0) goto L_0x0076
            r18.processEndOfStream()
            return r13
        L_0x0076:
            r14.outputIndex = r0
            java.nio.ByteBuffer r0 = r14.getOutputBuffer(r0)
            r14.outputBuffer = r0
            java.nio.ByteBuffer r0 = r14.outputBuffer
            if (r0 == 0) goto L_0x0097
            android.media.MediaCodec$BufferInfo r1 = r14.outputBufferInfo
            int r1 = r1.offset
            r0.position(r1)
            java.nio.ByteBuffer r0 = r14.outputBuffer
            android.media.MediaCodec$BufferInfo r1 = r14.outputBufferInfo
            int r1 = r1.offset
            android.media.MediaCodec$BufferInfo r2 = r14.outputBufferInfo
            int r2 = r2.size
            int r1 = r1 + r2
            r0.limit(r1)
        L_0x0097:
            android.media.MediaCodec$BufferInfo r0 = r14.outputBufferInfo
            long r0 = r0.presentationTimeUs
            boolean r0 = r14.isDecodeOnlyBuffer(r0)
            r14.isDecodeOnlyOutputBuffer = r0
            long r0 = r14.lastBufferInStreamPresentationTimeUs
            android.media.MediaCodec$BufferInfo r2 = r14.outputBufferInfo
            long r2 = r2.presentationTimeUs
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00ad
            r0 = 1
            goto L_0x00ae
        L_0x00ad:
            r0 = 0
        L_0x00ae:
            r14.isLastOutputBuffer = r0
            android.media.MediaCodec$BufferInfo r0 = r14.outputBufferInfo
            long r0 = r0.presentationTimeUs
            r14.updateOutputFormatForTime(r0)
        L_0x00b7:
            boolean r0 = r14.codecNeedsEosOutputExceptionWorkaround
            if (r0 == 0) goto L_0x00f3
            boolean r0 = r14.codecReceivedEos
            if (r0 == 0) goto L_0x00f3
            android.media.MediaCodec r5 = r14.codec     // Catch:{ IllegalStateException -> 0x00e6 }
            java.nio.ByteBuffer r6 = r14.outputBuffer     // Catch:{ IllegalStateException -> 0x00e6 }
            int r7 = r14.outputIndex     // Catch:{ IllegalStateException -> 0x00e6 }
            android.media.MediaCodec$BufferInfo r0 = r14.outputBufferInfo     // Catch:{ IllegalStateException -> 0x00e6 }
            int r8 = r0.flags     // Catch:{ IllegalStateException -> 0x00e6 }
            android.media.MediaCodec$BufferInfo r0 = r14.outputBufferInfo     // Catch:{ IllegalStateException -> 0x00e6 }
            long r9 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x00e6 }
            boolean r11 = r14.isDecodeOnlyOutputBuffer     // Catch:{ IllegalStateException -> 0x00e6 }
            boolean r12 = r14.isLastOutputBuffer     // Catch:{ IllegalStateException -> 0x00e6 }
            com.google.android.exoplayer2.Format r3 = r14.outputFormat     // Catch:{ IllegalStateException -> 0x00e6 }
            r0 = r18
            r1 = r19
            r16 = r3
            r3 = r21
            r17 = 0
            r13 = r16
            boolean r0 = r0.processOutputBuffer(r1, r3, r5, r6, r7, r8, r9, r11, r12, r13)     // Catch:{ IllegalStateException -> 0x00e4 }
            goto L_0x0113
        L_0x00e4:
            goto L_0x00e8
        L_0x00e6:
            r17 = 0
        L_0x00e8:
            r18.processEndOfStream()
            boolean r0 = r14.outputStreamEnded
            if (r0 == 0) goto L_0x00f2
            r18.releaseCodec()
        L_0x00f2:
            return r17
        L_0x00f3:
            r17 = 0
            android.media.MediaCodec r5 = r14.codec
            java.nio.ByteBuffer r6 = r14.outputBuffer
            int r7 = r14.outputIndex
            android.media.MediaCodec$BufferInfo r0 = r14.outputBufferInfo
            int r8 = r0.flags
            android.media.MediaCodec$BufferInfo r0 = r14.outputBufferInfo
            long r9 = r0.presentationTimeUs
            boolean r11 = r14.isDecodeOnlyOutputBuffer
            boolean r12 = r14.isLastOutputBuffer
            com.google.android.exoplayer2.Format r13 = r14.outputFormat
            r0 = r18
            r1 = r19
            r3 = r21
            boolean r0 = r0.processOutputBuffer(r1, r3, r5, r6, r7, r8, r9, r11, r12, r13)
        L_0x0113:
            if (r0 == 0) goto L_0x0130
            android.media.MediaCodec$BufferInfo r0 = r14.outputBufferInfo
            long r0 = r0.presentationTimeUs
            r14.onProcessedOutputBuffer(r0)
            android.media.MediaCodec$BufferInfo r0 = r14.outputBufferInfo
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x0126
            r0 = 1
            goto L_0x0127
        L_0x0126:
            r0 = 0
        L_0x0127:
            r18.resetOutputBuffer()
            if (r0 != 0) goto L_0x012d
            return r15
        L_0x012d:
            r18.processEndOfStream()
        L_0x0130:
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.drainOutputBuffer(long, long):boolean");
    }

    private void processOutputFormat() throws ExoPlaybackException {
        MediaFormat outputFormat2 = this.codec.getOutputFormat();
        if (this.codecAdaptationWorkaroundMode != 0 && outputFormat2.getInteger("width") == 32 && outputFormat2.getInteger("height") == 32) {
            this.shouldSkipAdaptationWorkaroundOutputBuffer = true;
            return;
        }
        if (this.codecNeedsMonoChannelCountWorkaround) {
            outputFormat2.setInteger("channel-count", 1);
        }
        onOutputFormatChanged(this.codec, outputFormat2);
    }

    private void processOutputBuffersChanged() {
        if (Util.SDK_INT < 21) {
            this.outputBuffers = this.codec.getOutputBuffers();
        }
    }

    private void processEndOfStream() throws ExoPlaybackException {
        int i = this.codecDrainAction;
        if (i == 1) {
            flushOrReinitializeCodec();
        } else if (i == 2) {
            updateDrmSessionOrReinitializeCodecV23();
        } else if (i != 3) {
            this.outputStreamEnded = true;
            renderToEndOfStream();
        } else {
            reinitializeCodec();
        }
    }

    private void reinitializeCodec() throws ExoPlaybackException {
        releaseCodec();
        maybeInitCodec();
    }

    @TargetApi(23)
    private void updateDrmSessionOrReinitializeCodecV23() throws ExoPlaybackException {
        FrameworkMediaCrypto mediaCrypto2 = this.sourceDrmSession.getMediaCrypto();
        if (mediaCrypto2 == null) {
            reinitializeCodec();
        } else if (C1119C.PLAYREADY_UUID.equals(mediaCrypto2.uuid)) {
            reinitializeCodec();
        } else if (!flushOrReinitializeCodec()) {
            try {
                this.mediaCrypto.setMediaDrmSession(mediaCrypto2.sessionId);
                setCodecDrmSession(this.sourceDrmSession);
                this.codecDrainState = 0;
                this.codecDrainAction = 0;
            } catch (MediaCryptoException e) {
                throw ExoPlaybackException.createForRenderer(e, getIndex());
            }
        }
    }

    private boolean isDecodeOnlyBuffer(long j) {
        int size = this.decodeOnlyPresentationTimestamps.size();
        for (int i = 0; i < size; i++) {
            if (this.decodeOnlyPresentationTimestamps.get(i).longValue() == j) {
                this.decodeOnlyPresentationTimestamps.remove(i);
                return true;
            }
        }
        return false;
    }

    private static MediaCodec.CryptoInfo getFrameworkCryptoInfo(DecoderInputBuffer decoderInputBuffer, int i) {
        MediaCodec.CryptoInfo frameworkCryptoInfo = decoderInputBuffer.cryptoInfo.getFrameworkCryptoInfo();
        if (i == 0) {
            return frameworkCryptoInfo;
        }
        if (frameworkCryptoInfo.numBytesOfClearData == null) {
            frameworkCryptoInfo.numBytesOfClearData = new int[1];
        }
        int[] iArr = frameworkCryptoInfo.numBytesOfClearData;
        iArr[0] = iArr[0] + i;
        return frameworkCryptoInfo;
    }

    private boolean deviceNeedsDrmKeysToConfigureCodecWorkaround() {
        return "Amazon".equals(Util.MANUFACTURER) && ("AFTM".equals(Util.MODEL) || "AFTB".equals(Util.MODEL));
    }

    private static boolean codecNeedsFlushWorkaround(String str) {
        return Util.SDK_INT < 18 || (Util.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (Util.SDK_INT == 19 && Util.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private int codecAdaptationWorkaroundMode(String str) {
        if (Util.SDK_INT <= 25 && "OMX.Exynos.avc.dec.secure".equals(str) && (Util.MODEL.startsWith("SM-T585") || Util.MODEL.startsWith("SM-A510") || Util.MODEL.startsWith("SM-A520") || Util.MODEL.startsWith("SM-J700"))) {
            return 2;
        }
        if (Util.SDK_INT >= 24) {
            return 0;
        }
        if ("OMX.Nvidia.h264.decode".equals(str) || "OMX.Nvidia.h264.decode.secure".equals(str)) {
            return ("flounder".equals(Util.DEVICE) || "flounder_lte".equals(Util.DEVICE) || "grouper".equals(Util.DEVICE) || "tilapia".equals(Util.DEVICE)) ? 1 : 0;
        }
        return 0;
    }

    private static boolean codecNeedsReconfigureWorkaround(String str) {
        return Util.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    private static boolean codecNeedsDiscardToSpsWorkaround(String str, Format format) {
        return Util.SDK_INT < 21 && format.initializationData.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean codecNeedsEosPropagationWorkaround(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.name;
        return (Util.SDK_INT <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (Util.SDK_INT <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ("Amazon".equals(Util.MANUFACTURER) && "AFTS".equals(Util.MODEL) && mediaCodecInfo.secure);
    }

    private static boolean codecNeedsEosFlushWorkaround(String str) {
        return (Util.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str)) || (Util.SDK_INT <= 19 && (("hb2000".equals(Util.DEVICE) || "stvm8".equals(Util.DEVICE)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))));
    }

    private static boolean codecNeedsEosOutputExceptionWorkaround(String str) {
        return Util.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean codecNeedsMonoChannelCountWorkaround(String str, Format format) {
        if (Util.SDK_INT > 18 || format.channelCount != 1 || !"OMX.MTK.AUDIO.DECODER.MP3".equals(str)) {
            return false;
        }
        return true;
    }
}
