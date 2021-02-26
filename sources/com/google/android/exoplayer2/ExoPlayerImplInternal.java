package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.DefaultMediaClock;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSource.SourceInfoRefreshListener, DefaultMediaClock.PlaybackParameterListener, PlayerMessage.Sender {
    private static final int IDLE_INTERVAL_MS = 1000;
    private static final int MSG_DO_SOME_WORK = 2;
    public static final int MSG_ERROR = 2;
    private static final int MSG_PERIOD_PREPARED = 9;
    public static final int MSG_PLAYBACK_INFO_CHANGED = 0;
    public static final int MSG_PLAYBACK_PARAMETERS_CHANGED = 1;
    private static final int MSG_PLAYBACK_PARAMETERS_CHANGED_INTERNAL = 17;
    private static final int MSG_PREPARE = 0;
    private static final int MSG_REFRESH_SOURCE_INFO = 8;
    private static final int MSG_RELEASE = 7;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SEND_MESSAGE = 15;
    private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 16;
    private static final int MSG_SET_FOREGROUND_MODE = 14;
    private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SET_REPEAT_MODE = 12;
    private static final int MSG_SET_SEEK_PARAMETERS = 5;
    private static final int MSG_SET_SHUFFLE_ENABLED = 13;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 10;
    private static final int MSG_STOP = 6;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 11;
    private static final int PREPARING_SOURCE_INTERVAL_MS = 10;
    private static final int RENDERING_INTERVAL_MS = 10;
    private static final String TAG = "ExoPlayerImplInternal";
    private final long backBufferDurationUs;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private Renderer[] enabledRenderers;
    private final Handler eventHandler;
    private boolean foregroundMode;
    private final HandlerWrapper handler;
    private final HandlerThread internalPlaybackThread;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private MediaSource mediaSource;
    private int nextPendingMessageIndex;
    private SeekPosition pendingInitialSeekPosition;
    private final ArrayList<PendingMessageInfo> pendingMessages;
    private int pendingPrepareCount;
    private final Timeline.Period period;
    private boolean playWhenReady;
    private PlaybackInfo playbackInfo;
    private final PlaybackInfoUpdate playbackInfoUpdate;
    private final MediaPeriodQueue queue = new MediaPeriodQueue();
    private boolean rebuffering;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private int repeatMode;
    private final boolean retainBackBufferFromKeyframe;
    private SeekParameters seekParameters;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline.Window window;

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector2, TrackSelectorResult trackSelectorResult, LoadControl loadControl2, BandwidthMeter bandwidthMeter2, boolean z, int i, boolean z2, Handler handler2, Clock clock2) {
        this.renderers = rendererArr;
        this.trackSelector = trackSelector2;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl2;
        this.bandwidthMeter = bandwidthMeter2;
        this.playWhenReady = z;
        this.repeatMode = i;
        this.shuffleModeEnabled = z2;
        this.eventHandler = handler2;
        this.clock = clock2;
        this.backBufferDurationUs = loadControl2.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = loadControl2.retainBackBufferFromKeyframe();
        this.seekParameters = SeekParameters.DEFAULT;
        this.playbackInfo = PlaybackInfo.createDummy(C1119C.TIME_UNSET, trackSelectorResult);
        this.playbackInfoUpdate = new PlaybackInfoUpdate();
        this.rendererCapabilities = new RendererCapabilities[rendererArr.length];
        for (int i2 = 0; i2 < rendererArr.length; i2++) {
            rendererArr[i2].setIndex(i2);
            this.rendererCapabilities[i2] = rendererArr[i2].getCapabilities();
        }
        this.mediaClock = new DefaultMediaClock(this, clock2);
        this.pendingMessages = new ArrayList<>();
        this.enabledRenderers = new Renderer[0];
        this.window = new Timeline.Window();
        this.period = new Timeline.Period();
        trackSelector2.init(this, bandwidthMeter2);
        this.internalPlaybackThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.internalPlaybackThread.start();
        this.handler = clock2.createHandler(this.internalPlaybackThread.getLooper(), this);
    }

    public void prepare(MediaSource mediaSource2, boolean z, boolean z2) {
        this.handler.obtainMessage(0, z ? 1 : 0, z2 ? 1 : 0, mediaSource2).sendToTarget();
    }

    public void setPlayWhenReady(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public void setRepeatMode(int i) {
        this.handler.obtainMessage(12, i, 0).sendToTarget();
    }

    public void setShuffleModeEnabled(boolean z) {
        this.handler.obtainMessage(13, z ? 1 : 0, 0).sendToTarget();
    }

    public void seekTo(Timeline timeline, int i, long j) {
        this.handler.obtainMessage(3, new SeekPosition(timeline, i, j)).sendToTarget();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public void setSeekParameters(SeekParameters seekParameters2) {
        this.handler.obtainMessage(5, seekParameters2).sendToTarget();
    }

    public void stop(boolean z) {
        this.handler.obtainMessage(6, z ? 1 : 0, 0).sendToTarget();
    }

    public synchronized void sendMessage(PlayerMessage playerMessage) {
        if (this.released) {
            Log.m54w(TAG, "Ignoring messages sent after release.");
            playerMessage.markAsProcessed(false);
            return;
        }
        this.handler.obtainMessage(15, playerMessage).sendToTarget();
    }

    public synchronized void setForegroundMode(boolean z) {
        boolean z2 = false;
        if (z) {
            this.handler.obtainMessage(14, 1, 0).sendToTarget();
        } else {
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            this.handler.obtainMessage(14, 0, 0, atomicBoolean).sendToTarget();
            while (!atomicBoolean.get() && !this.released) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
            if (z2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0022, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void release() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.released     // Catch:{ all -> 0x0023 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            com.google.android.exoplayer2.util.HandlerWrapper r0 = r2.handler     // Catch:{ all -> 0x0023 }
            r1 = 7
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0023 }
            r0 = 0
        L_0x000e:
            boolean r1 = r2.released     // Catch:{ all -> 0x0023 }
            if (r1 != 0) goto L_0x0018
            r2.wait()     // Catch:{ InterruptedException -> 0x0016 }
            goto L_0x000e
        L_0x0016:
            r0 = 1
            goto L_0x000e
        L_0x0018:
            if (r0 == 0) goto L_0x0021
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0023 }
            r0.interrupt()     // Catch:{ all -> 0x0023 }
        L_0x0021:
            monitor-exit(r2)
            return
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.release():void");
    }

    public Looper getPlaybackLooper() {
        return this.internalPlaybackThread.getLooper();
    }

    public void onSourceInfoRefreshed(MediaSource mediaSource2, Timeline timeline, Object obj) {
        this.handler.obtainMessage(8, new MediaSourceRefreshInfo(mediaSource2, timeline, obj)).sendToTarget();
    }

    public void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(10, mediaPeriod).sendToTarget();
    }

    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(11);
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(17, playbackParameters).sendToTarget();
    }

    public boolean handleMessage(Message message) {
        ExoPlaybackException exoPlaybackException;
        try {
            switch (message.what) {
                case 0:
                    prepareInternal((MediaSource) message.obj, message.arg1 != 0, message.arg2 != 0);
                    break;
                case 1:
                    setPlayWhenReadyInternal(message.arg1 != 0);
                    break;
                case 2:
                    doSomeWork();
                    break;
                case 3:
                    seekToInternal((SeekPosition) message.obj);
                    break;
                case 4:
                    setPlaybackParametersInternal((PlaybackParameters) message.obj);
                    break;
                case 5:
                    setSeekParametersInternal((SeekParameters) message.obj);
                    break;
                case 6:
                    stopInternal(false, message.arg1 != 0, true);
                    break;
                case 7:
                    releaseInternal();
                    return true;
                case 8:
                    handleSourceInfoRefreshed((MediaSourceRefreshInfo) message.obj);
                    break;
                case 9:
                    handlePeriodPrepared((MediaPeriod) message.obj);
                    break;
                case 10:
                    handleContinueLoadingRequested((MediaPeriod) message.obj);
                    break;
                case 11:
                    reselectTracksInternal();
                    break;
                case 12:
                    setRepeatModeInternal(message.arg1);
                    break;
                case 13:
                    setShuffleModeEnabledInternal(message.arg1 != 0);
                    break;
                case 14:
                    setForegroundModeInternal(message.arg1 != 0, (AtomicBoolean) message.obj);
                    break;
                case 15:
                    sendMessageInternal((PlayerMessage) message.obj);
                    break;
                case 16:
                    sendMessageToTargetThread((PlayerMessage) message.obj);
                    break;
                case 17:
                    handlePlaybackParameters((PlaybackParameters) message.obj);
                    break;
                default:
                    return false;
            }
            maybeNotifyPlaybackInfoChanged();
        } catch (ExoPlaybackException e) {
            Log.m51e(TAG, "Playback error.", e);
            this.eventHandler.obtainMessage(2, e).sendToTarget();
            stopInternal(true, false, false);
            maybeNotifyPlaybackInfoChanged();
        } catch (IOException e2) {
            Log.m51e(TAG, "Source error.", e2);
            this.eventHandler.obtainMessage(2, ExoPlaybackException.createForSource(e2)).sendToTarget();
            stopInternal(false, false, false);
            maybeNotifyPlaybackInfoChanged();
        } catch (OutOfMemoryError | RuntimeException e3) {
            Log.m51e(TAG, "Internal runtime error.", e3);
            if (e3 instanceof OutOfMemoryError) {
                exoPlaybackException = ExoPlaybackException.createForOutOfMemoryError((OutOfMemoryError) e3);
            } else {
                exoPlaybackException = ExoPlaybackException.createForUnexpected((RuntimeException) e3);
            }
            this.eventHandler.obtainMessage(2, exoPlaybackException).sendToTarget();
            stopInternal(true, false, false);
            maybeNotifyPlaybackInfoChanged();
        }
        return true;
    }

    private void setState(int i) {
        if (this.playbackInfo.playbackState != i) {
            this.playbackInfo = this.playbackInfo.copyWithPlaybackState(i);
        }
    }

    private void setIsLoading(boolean z) {
        if (this.playbackInfo.isLoading != z) {
            this.playbackInfo = this.playbackInfo.copyWithIsLoading(z);
        }
    }

    private void maybeNotifyPlaybackInfoChanged() {
        if (this.playbackInfoUpdate.hasPendingUpdate(this.playbackInfo)) {
            this.eventHandler.obtainMessage(0, this.playbackInfoUpdate.operationAcks, this.playbackInfoUpdate.positionDiscontinuity ? this.playbackInfoUpdate.discontinuityReason : -1, this.playbackInfo).sendToTarget();
            this.playbackInfoUpdate.reset(this.playbackInfo);
        }
    }

    private void prepareInternal(MediaSource mediaSource2, boolean z, boolean z2) {
        this.pendingPrepareCount++;
        resetInternal(false, true, z, z2);
        this.loadControl.onPrepared();
        this.mediaSource = mediaSource2;
        setState(2);
        mediaSource2.prepareSource(this, this.bandwidthMeter.getTransferListener());
        this.handler.sendEmptyMessage(2);
    }

    private void setPlayWhenReadyInternal(boolean z) throws ExoPlaybackException {
        this.rebuffering = false;
        this.playWhenReady = z;
        if (!z) {
            stopRenderers();
            updatePlaybackPositions();
        } else if (this.playbackInfo.playbackState == 3) {
            startRenderers();
            this.handler.sendEmptyMessage(2);
        } else if (this.playbackInfo.playbackState == 2) {
            this.handler.sendEmptyMessage(2);
        }
    }

    private void setRepeatModeInternal(int i) throws ExoPlaybackException {
        this.repeatMode = i;
        if (!this.queue.updateRepeatMode(i)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void setShuffleModeEnabledInternal(boolean z) throws ExoPlaybackException {
        this.shuffleModeEnabled = z;
        if (!this.queue.updateShuffleModeEnabled(z)) {
            seekToCurrentPosition(true);
        }
        handleLoadingMediaPeriodChanged(false);
    }

    private void seekToCurrentPosition(boolean z) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.queue.getPlayingPeriod().info.f121id;
        long seekToPeriodPosition = seekToPeriodPosition(mediaPeriodId, this.playbackInfo.positionUs, true);
        if (seekToPeriodPosition != this.playbackInfo.positionUs) {
            PlaybackInfo playbackInfo2 = this.playbackInfo;
            this.playbackInfo = playbackInfo2.copyWithNewPosition(mediaPeriodId, seekToPeriodPosition, playbackInfo2.contentPositionUs, getTotalBufferedDurationUs());
            if (z) {
                this.playbackInfoUpdate.setPositionDiscontinuity(4);
            }
        }
    }

    private void startRenderers() throws ExoPlaybackException {
        this.rebuffering = false;
        this.mediaClock.start();
        for (Renderer start : this.enabledRenderers) {
            start.start();
        }
    }

    private void stopRenderers() throws ExoPlaybackException {
        this.mediaClock.stop();
        for (Renderer ensureStopped : this.enabledRenderers) {
            ensureStopped(ensureStopped);
        }
    }

    private void updatePlaybackPositions() throws ExoPlaybackException {
        if (this.queue.hasPlayingPeriod()) {
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            long readDiscontinuity = playingPeriod.mediaPeriod.readDiscontinuity();
            if (readDiscontinuity != C1119C.TIME_UNSET) {
                resetRendererPosition(readDiscontinuity);
                if (readDiscontinuity != this.playbackInfo.positionUs) {
                    PlaybackInfo playbackInfo2 = this.playbackInfo;
                    this.playbackInfo = playbackInfo2.copyWithNewPosition(playbackInfo2.periodId, readDiscontinuity, this.playbackInfo.contentPositionUs, getTotalBufferedDurationUs());
                    this.playbackInfoUpdate.setPositionDiscontinuity(4);
                }
            } else {
                this.rendererPositionUs = this.mediaClock.syncAndGetPositionUs();
                long periodTime = playingPeriod.toPeriodTime(this.rendererPositionUs);
                maybeTriggerPendingMessages(this.playbackInfo.positionUs, periodTime);
                this.playbackInfo.positionUs = periodTime;
            }
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            this.playbackInfo.bufferedPositionUs = loadingPeriod.getBufferedPositionUs();
            this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        }
    }

    private void doSomeWork() throws ExoPlaybackException, IOException {
        long uptimeMillis = this.clock.uptimeMillis();
        updatePeriods();
        if (!this.queue.hasPlayingPeriod()) {
            maybeThrowPeriodPrepareError();
            scheduleNextWork(uptimeMillis, 10);
            return;
        }
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        TraceUtil.beginSection("doSomeWork");
        updatePlaybackPositions();
        long elapsedRealtime = SystemClock.elapsedRealtime() * 1000;
        playingPeriod.mediaPeriod.discardBuffer(this.playbackInfo.positionUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
        boolean z = true;
        boolean z2 = true;
        for (Renderer renderer : this.enabledRenderers) {
            renderer.render(this.rendererPositionUs, elapsedRealtime);
            z2 = z2 && renderer.isEnded();
            boolean z3 = renderer.isReady() || renderer.isEnded() || rendererWaitingForNextStream(renderer);
            if (!z3) {
                renderer.maybeThrowStreamError();
            }
            z = z && z3;
        }
        if (!z) {
            maybeThrowPeriodPrepareError();
        }
        long j = playingPeriod.info.durationUs;
        if (z2 && ((j == C1119C.TIME_UNSET || j <= this.playbackInfo.positionUs) && playingPeriod.info.isFinal)) {
            setState(4);
            stopRenderers();
        } else if (this.playbackInfo.playbackState == 2 && shouldTransitionToReadyState(z)) {
            setState(3);
            if (this.playWhenReady) {
                startRenderers();
            }
        } else if (this.playbackInfo.playbackState == 3 && (this.enabledRenderers.length != 0 ? !z : !isTimelineReady())) {
            this.rebuffering = this.playWhenReady;
            setState(2);
            stopRenderers();
        }
        if (this.playbackInfo.playbackState == 2) {
            for (Renderer maybeThrowStreamError : this.enabledRenderers) {
                maybeThrowStreamError.maybeThrowStreamError();
            }
        }
        if ((this.playWhenReady && this.playbackInfo.playbackState == 3) || this.playbackInfo.playbackState == 2) {
            scheduleNextWork(uptimeMillis, 10);
        } else if (this.enabledRenderers.length == 0 || this.playbackInfo.playbackState == 4) {
            this.handler.removeMessages(2);
        } else {
            scheduleNextWork(uptimeMillis, 1000);
        }
        TraceUtil.endSection();
    }

    private void scheduleNextWork(long j, long j2) {
        this.handler.removeMessages(2);
        this.handler.sendEmptyMessageAtTime(2, j + j2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005c A[Catch:{ all -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void seekToInternal(com.google.android.exoplayer2.ExoPlayerImplInternal.SeekPosition r23) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r22 = this;
            r1 = r22
            r0 = r23
            com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate r2 = r1.playbackInfoUpdate
            r3 = 1
            r2.incrementPendingOperationAcks(r3)
            android.util.Pair r2 = r1.resolveSeekPosition(r0, r3)
            r4 = 0
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = 0
            if (r2 != 0) goto L_0x0028
            com.google.android.exoplayer2.PlaybackInfo r2 = r1.playbackInfo
            boolean r9 = r1.shuffleModeEnabled
            com.google.android.exoplayer2.Timeline$Window r10 = r1.window
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r2.getDummyFirstMediaPeriodId(r9, r10)
            r15 = r2
            r12 = r6
            r18 = r12
        L_0x0026:
            r2 = 1
            goto L_0x0057
        L_0x0028:
            java.lang.Object r9 = r2.first
            java.lang.Object r10 = r2.second
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            com.google.android.exoplayer2.MediaPeriodQueue r12 = r1.queue
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r9 = r12.resolveMediaPeriodIdForAds(r9, r10)
            boolean r12 = r9.isAd()
            if (r12 == 0) goto L_0x0043
            r12 = r4
            r15 = r9
            r18 = r10
            goto L_0x0026
        L_0x0043:
            java.lang.Object r2 = r2.second
            java.lang.Long r2 = (java.lang.Long) r2
            long r12 = r2.longValue()
            long r14 = r0.windowPositionUs
            int r2 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x0053
            r2 = 1
            goto L_0x0054
        L_0x0053:
            r2 = 0
        L_0x0054:
            r15 = r9
            r18 = r10
        L_0x0057:
            r9 = 2
            com.google.android.exoplayer2.source.MediaSource r10 = r1.mediaSource     // Catch:{ all -> 0x00de }
            if (r10 == 0) goto L_0x00c6
            int r10 = r1.pendingPrepareCount     // Catch:{ all -> 0x00de }
            if (r10 <= 0) goto L_0x0061
            goto L_0x00c6
        L_0x0061:
            int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x006d
            r0 = 4
            r1.setState(r0)     // Catch:{ all -> 0x00de }
            r1.resetInternal(r8, r8, r3, r8)     // Catch:{ all -> 0x00de }
            goto L_0x00c8
        L_0x006d:
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo     // Catch:{ all -> 0x00de }
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.periodId     // Catch:{ all -> 0x00de }
            boolean r0 = r15.equals(r0)     // Catch:{ all -> 0x00de }
            if (r0 == 0) goto L_0x00b7
            com.google.android.exoplayer2.MediaPeriodQueue r0 = r1.queue     // Catch:{ all -> 0x00de }
            com.google.android.exoplayer2.MediaPeriodHolder r0 = r0.getPlayingPeriod()     // Catch:{ all -> 0x00de }
            if (r0 == 0) goto L_0x008c
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x008c
            com.google.android.exoplayer2.source.MediaPeriod r0 = r0.mediaPeriod     // Catch:{ all -> 0x00de }
            com.google.android.exoplayer2.SeekParameters r4 = r1.seekParameters     // Catch:{ all -> 0x00de }
            long r4 = r0.getAdjustedSeekPositionUs(r12, r4)     // Catch:{ all -> 0x00de }
            goto L_0x008d
        L_0x008c:
            r4 = r12
        L_0x008d:
            long r6 = com.google.android.exoplayer2.C1119C.usToMs(r4)     // Catch:{ all -> 0x00de }
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo     // Catch:{ all -> 0x00de }
            long r10 = r0.positionUs     // Catch:{ all -> 0x00de }
            long r10 = com.google.android.exoplayer2.C1119C.usToMs(r10)     // Catch:{ all -> 0x00de }
            int r0 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x00b8
            com.google.android.exoplayer2.PlaybackInfo r0 = r1.playbackInfo     // Catch:{ all -> 0x00de }
            long r3 = r0.positionUs     // Catch:{ all -> 0x00de }
            com.google.android.exoplayer2.PlaybackInfo r14 = r1.playbackInfo
            long r20 = r22.getTotalBufferedDurationUs()
            r16 = r3
            com.google.android.exoplayer2.PlaybackInfo r0 = r14.copyWithNewPosition(r15, r16, r18, r20)
            r1.playbackInfo = r0
            if (r2 == 0) goto L_0x00b6
            com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate r0 = r1.playbackInfoUpdate
            r0.setPositionDiscontinuity(r9)
        L_0x00b6:
            return
        L_0x00b7:
            r4 = r12
        L_0x00b8:
            long r4 = r1.seekToPeriodPosition(r15, r4)     // Catch:{ all -> 0x00de }
            int r0 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00c1
            goto L_0x00c2
        L_0x00c1:
            r3 = 0
        L_0x00c2:
            r2 = r2 | r3
            r16 = r4
            goto L_0x00ca
        L_0x00c6:
            r1.pendingInitialSeekPosition = r0     // Catch:{ all -> 0x00de }
        L_0x00c8:
            r16 = r12
        L_0x00ca:
            com.google.android.exoplayer2.PlaybackInfo r14 = r1.playbackInfo
            long r20 = r22.getTotalBufferedDurationUs()
            com.google.android.exoplayer2.PlaybackInfo r0 = r14.copyWithNewPosition(r15, r16, r18, r20)
            r1.playbackInfo = r0
            if (r2 == 0) goto L_0x00dd
            com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate r0 = r1.playbackInfoUpdate
            r0.setPositionDiscontinuity(r9)
        L_0x00dd:
            return
        L_0x00de:
            r0 = move-exception
            com.google.android.exoplayer2.PlaybackInfo r14 = r1.playbackInfo
            long r20 = r22.getTotalBufferedDurationUs()
            r16 = r12
            com.google.android.exoplayer2.PlaybackInfo r3 = r14.copyWithNewPosition(r15, r16, r18, r20)
            r1.playbackInfo = r3
            if (r2 == 0) goto L_0x00f4
            com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate r2 = r1.playbackInfoUpdate
            r2.setPositionDiscontinuity(r9)
        L_0x00f4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.seekToInternal(com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition):void");
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j) throws ExoPlaybackException {
        return seekToPeriodPosition(mediaPeriodId, j, this.queue.getPlayingPeriod() != this.queue.getReadingPeriod());
    }

    private long seekToPeriodPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, boolean z) throws ExoPlaybackException {
        stopRenderers();
        this.rebuffering = false;
        setState(2);
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder mediaPeriodHolder = playingPeriod;
        while (true) {
            if (mediaPeriodHolder != null) {
                if (mediaPeriodId.equals(mediaPeriodHolder.info.f121id) && mediaPeriodHolder.prepared) {
                    this.queue.removeAfter(mediaPeriodHolder);
                    break;
                }
                mediaPeriodHolder = this.queue.advancePlayingPeriod();
            } else {
                break;
            }
        }
        if (z || playingPeriod != mediaPeriodHolder || (mediaPeriodHolder != null && mediaPeriodHolder.toRendererTime(j) < 0)) {
            for (Renderer disableRenderer : this.enabledRenderers) {
                disableRenderer(disableRenderer);
            }
            this.enabledRenderers = new Renderer[0];
            playingPeriod = null;
            if (mediaPeriodHolder != null) {
                mediaPeriodHolder.setRendererOffset(0);
            }
        }
        if (mediaPeriodHolder != null) {
            updatePlayingPeriodRenderers(playingPeriod);
            if (mediaPeriodHolder.hasEnabledTracks) {
                long seekToUs = mediaPeriodHolder.mediaPeriod.seekToUs(j);
                mediaPeriodHolder.mediaPeriod.discardBuffer(seekToUs - this.backBufferDurationUs, this.retainBackBufferFromKeyframe);
                j = seekToUs;
            }
            resetRendererPosition(j);
            maybeContinueLoading();
        } else {
            this.queue.clear(true);
            this.playbackInfo = this.playbackInfo.copyWithTrackInfo(TrackGroupArray.EMPTY, this.emptyTrackSelectorResult);
            resetRendererPosition(j);
        }
        handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private void resetRendererPosition(long j) throws ExoPlaybackException {
        if (this.queue.hasPlayingPeriod()) {
            j = this.queue.getPlayingPeriod().toRendererTime(j);
        }
        this.rendererPositionUs = j;
        this.mediaClock.resetPosition(this.rendererPositionUs);
        for (Renderer resetPosition : this.enabledRenderers) {
            resetPosition.resetPosition(this.rendererPositionUs);
        }
        notifyTrackSelectionDiscontinuity();
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters) {
        this.mediaClock.setPlaybackParameters(playbackParameters);
    }

    private void setSeekParametersInternal(SeekParameters seekParameters2) {
        this.seekParameters = seekParameters2;
    }

    private void setForegroundModeInternal(boolean z, @Nullable AtomicBoolean atomicBoolean) {
        if (this.foregroundMode != z) {
            this.foregroundMode = z;
            if (!z) {
                for (Renderer renderer : this.renderers) {
                    if (renderer.getState() == 0) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private void stopInternal(boolean z, boolean z2, boolean z3) {
        resetInternal(z || !this.foregroundMode, true, z2, z2);
        this.playbackInfoUpdate.incrementPendingOperationAcks(this.pendingPrepareCount + (z3 ? 1 : 0));
        this.pendingPrepareCount = 0;
        this.loadControl.onStopped();
        setState(1);
    }

    private void releaseInternal() {
        resetInternal(true, true, true, true);
        this.loadControl.onReleased();
        setState(1);
        this.internalPlaybackThread.quit();
        synchronized (this) {
            this.released = true;
            notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void resetInternal(boolean r25, boolean r26, boolean r27, boolean r28) {
        /*
            r24 = this;
            r1 = r24
            com.google.android.exoplayer2.util.HandlerWrapper r0 = r1.handler
            r2 = 2
            r0.removeMessages(r2)
            r2 = 0
            r1.rebuffering = r2
            com.google.android.exoplayer2.DefaultMediaClock r0 = r1.mediaClock
            r0.stop()
            r3 = 0
            r1.rendererPositionUs = r3
            com.google.android.exoplayer2.Renderer[] r3 = r1.enabledRenderers
            int r4 = r3.length
            r5 = 0
        L_0x0018:
            java.lang.String r6 = "ExoPlayerImplInternal"
            if (r5 >= r4) goto L_0x002d
            r0 = r3[r5]
            r1.disableRenderer(r0)     // Catch:{ ExoPlaybackException -> 0x0024, RuntimeException -> 0x0022 }
            goto L_0x002a
        L_0x0022:
            r0 = move-exception
            goto L_0x0025
        L_0x0024:
            r0 = move-exception
        L_0x0025:
            java.lang.String r7 = "Disable failed."
            com.google.android.exoplayer2.util.Log.m51e(r6, r7, r0)
        L_0x002a:
            int r5 = r5 + 1
            goto L_0x0018
        L_0x002d:
            if (r25 == 0) goto L_0x0045
            com.google.android.exoplayer2.Renderer[] r3 = r1.renderers
            int r4 = r3.length
            r5 = 0
        L_0x0033:
            if (r5 >= r4) goto L_0x0045
            r0 = r3[r5]
            r0.reset()     // Catch:{ RuntimeException -> 0x003b }
            goto L_0x0042
        L_0x003b:
            r0 = move-exception
            r7 = r0
            java.lang.String r0 = "Reset failed."
            com.google.android.exoplayer2.util.Log.m51e(r6, r0, r7)
        L_0x0042:
            int r5 = r5 + 1
            goto L_0x0033
        L_0x0045:
            com.google.android.exoplayer2.Renderer[] r0 = new com.google.android.exoplayer2.Renderer[r2]
            r1.enabledRenderers = r0
            r0 = 0
            r3 = 1
            if (r27 == 0) goto L_0x0050
            r1.pendingInitialSeekPosition = r0
            goto L_0x0089
        L_0x0050:
            if (r28 == 0) goto L_0x0089
            com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition r4 = r1.pendingInitialSeekPosition
            if (r4 != 0) goto L_0x0087
            com.google.android.exoplayer2.PlaybackInfo r4 = r1.playbackInfo
            com.google.android.exoplayer2.Timeline r4 = r4.timeline
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x0087
            com.google.android.exoplayer2.PlaybackInfo r4 = r1.playbackInfo
            com.google.android.exoplayer2.Timeline r4 = r4.timeline
            com.google.android.exoplayer2.PlaybackInfo r5 = r1.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r5 = r5.periodId
            java.lang.Object r5 = r5.periodUid
            com.google.android.exoplayer2.Timeline$Period r6 = r1.period
            r4.getPeriodByUid(r5, r6)
            com.google.android.exoplayer2.PlaybackInfo r4 = r1.playbackInfo
            long r4 = r4.positionUs
            com.google.android.exoplayer2.Timeline$Period r6 = r1.period
            long r6 = r6.getPositionInWindowUs()
            long r4 = r4 + r6
            com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition r6 = new com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition
            com.google.android.exoplayer2.Timeline r7 = com.google.android.exoplayer2.Timeline.EMPTY
            com.google.android.exoplayer2.Timeline$Period r8 = r1.period
            int r8 = r8.windowIndex
            r6.<init>(r7, r8, r4)
            r1.pendingInitialSeekPosition = r6
        L_0x0087:
            r4 = 1
            goto L_0x008b
        L_0x0089:
            r4 = r27
        L_0x008b:
            com.google.android.exoplayer2.MediaPeriodQueue r5 = r1.queue
            if (r4 != 0) goto L_0x0090
            goto L_0x0091
        L_0x0090:
            r3 = 0
        L_0x0091:
            r5.clear(r3)
            r1.setIsLoading(r2)
            if (r28 == 0) goto L_0x00bf
            com.google.android.exoplayer2.MediaPeriodQueue r3 = r1.queue
            com.google.android.exoplayer2.Timeline r5 = com.google.android.exoplayer2.Timeline.EMPTY
            r3.setTimeline(r5)
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r1.pendingMessages
            java.util.Iterator r3 = r3.iterator()
        L_0x00a6:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x00b8
            java.lang.Object r5 = r3.next()
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r5 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r5
            com.google.android.exoplayer2.PlayerMessage r5 = r5.message
            r5.markAsProcessed(r2)
            goto L_0x00a6
        L_0x00b8:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r1.pendingMessages
            r3.clear()
            r1.nextPendingMessageIndex = r2
        L_0x00bf:
            if (r4 == 0) goto L_0x00cc
            com.google.android.exoplayer2.PlaybackInfo r2 = r1.playbackInfo
            boolean r3 = r1.shuffleModeEnabled
            com.google.android.exoplayer2.Timeline$Window r5 = r1.window
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r2.getDummyFirstMediaPeriodId(r3, r5)
            goto L_0x00d0
        L_0x00cc:
            com.google.android.exoplayer2.PlaybackInfo r2 = r1.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r2 = r2.periodId
        L_0x00d0:
            r17 = r2
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x00dc
            r22 = r2
            goto L_0x00e2
        L_0x00dc:
            com.google.android.exoplayer2.PlaybackInfo r5 = r1.playbackInfo
            long r5 = r5.positionUs
            r22 = r5
        L_0x00e2:
            if (r4 == 0) goto L_0x00e5
            goto L_0x00e9
        L_0x00e5:
            com.google.android.exoplayer2.PlaybackInfo r2 = r1.playbackInfo
            long r2 = r2.contentPositionUs
        L_0x00e9:
            r11 = r2
            com.google.android.exoplayer2.PlaybackInfo r2 = new com.google.android.exoplayer2.PlaybackInfo
            if (r28 == 0) goto L_0x00f1
            com.google.android.exoplayer2.Timeline r3 = com.google.android.exoplayer2.Timeline.EMPTY
            goto L_0x00f5
        L_0x00f1:
            com.google.android.exoplayer2.PlaybackInfo r3 = r1.playbackInfo
            com.google.android.exoplayer2.Timeline r3 = r3.timeline
        L_0x00f5:
            r6 = r3
            if (r28 == 0) goto L_0x00fa
            r7 = r0
            goto L_0x00ff
        L_0x00fa:
            com.google.android.exoplayer2.PlaybackInfo r3 = r1.playbackInfo
            java.lang.Object r3 = r3.manifest
            r7 = r3
        L_0x00ff:
            com.google.android.exoplayer2.PlaybackInfo r3 = r1.playbackInfo
            int r13 = r3.playbackState
            r14 = 0
            if (r28 == 0) goto L_0x0109
            com.google.android.exoplayer2.source.TrackGroupArray r3 = com.google.android.exoplayer2.source.TrackGroupArray.EMPTY
            goto L_0x010d
        L_0x0109:
            com.google.android.exoplayer2.PlaybackInfo r3 = r1.playbackInfo
            com.google.android.exoplayer2.source.TrackGroupArray r3 = r3.trackGroups
        L_0x010d:
            r15 = r3
            if (r28 == 0) goto L_0x0113
            com.google.android.exoplayer2.trackselection.TrackSelectorResult r3 = r1.emptyTrackSelectorResult
            goto L_0x0117
        L_0x0113:
            com.google.android.exoplayer2.PlaybackInfo r3 = r1.playbackInfo
            com.google.android.exoplayer2.trackselection.TrackSelectorResult r3 = r3.trackSelectorResult
        L_0x0117:
            r16 = r3
            r20 = 0
            r5 = r2
            r8 = r17
            r9 = r22
            r18 = r22
            r5.<init>(r6, r7, r8, r9, r11, r13, r14, r15, r16, r17, r18, r20, r22)
            r1.playbackInfo = r2
            if (r26 == 0) goto L_0x0132
            com.google.android.exoplayer2.source.MediaSource r2 = r1.mediaSource
            if (r2 == 0) goto L_0x0132
            r2.releaseSource(r1)
            r1.mediaSource = r0
        L_0x0132:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.resetInternal(boolean, boolean, boolean, boolean):void");
    }

    private void sendMessageInternal(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getPositionMs() == C1119C.TIME_UNSET) {
            sendMessageToTarget(playerMessage);
        } else if (this.mediaSource == null || this.pendingPrepareCount > 0) {
            this.pendingMessages.add(new PendingMessageInfo(playerMessage));
        } else {
            PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
            if (resolvePendingMessagePosition(pendingMessageInfo)) {
                this.pendingMessages.add(pendingMessageInfo);
                Collections.sort(this.pendingMessages);
                return;
            }
            playerMessage.markAsProcessed(false);
        }
    }

    private void sendMessageToTarget(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.getHandler().getLooper() == this.handler.getLooper()) {
            deliverMessage(playerMessage);
            if (this.playbackInfo.playbackState == 3 || this.playbackInfo.playbackState == 2) {
                this.handler.sendEmptyMessage(2);
                return;
            }
            return;
        }
        this.handler.obtainMessage(16, playerMessage).sendToTarget();
    }

    private void sendMessageToTargetThread(PlayerMessage playerMessage) {
        playerMessage.getHandler().post(new Runnable(playerMessage) {
            private final /* synthetic */ PlayerMessage f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                ExoPlayerImplInternal.this.lambda$sendMessageToTargetThread$0$ExoPlayerImplInternal(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$sendMessageToTargetThread$0$ExoPlayerImplInternal(PlayerMessage playerMessage) {
        try {
            deliverMessage(playerMessage);
        } catch (ExoPlaybackException e) {
            Log.m51e(TAG, "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    private void deliverMessage(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (!playerMessage.isCanceled()) {
            try {
                playerMessage.getTarget().handleMessage(playerMessage.getType(), playerMessage.getPayload());
            } finally {
                playerMessage.markAsProcessed(true);
            }
        }
    }

    private void resolvePendingMessagePositions() {
        for (int size = this.pendingMessages.size() - 1; size >= 0; size--) {
            if (!resolvePendingMessagePosition(this.pendingMessages.get(size))) {
                this.pendingMessages.get(size).message.markAsProcessed(false);
                this.pendingMessages.remove(size);
            }
        }
        Collections.sort(this.pendingMessages);
    }

    private boolean resolvePendingMessagePosition(PendingMessageInfo pendingMessageInfo) {
        if (pendingMessageInfo.resolvedPeriodUid == null) {
            Pair<Object, Long> resolveSeekPosition = resolveSeekPosition(new SeekPosition(pendingMessageInfo.message.getTimeline(), pendingMessageInfo.message.getWindowIndex(), C1119C.msToUs(pendingMessageInfo.message.getPositionMs())), false);
            if (resolveSeekPosition == null) {
                return false;
            }
            pendingMessageInfo.setResolvedPosition(this.playbackInfo.timeline.getIndexOfPeriod(resolveSeekPosition.first), ((Long) resolveSeekPosition.second).longValue(), resolveSeekPosition.first);
            return true;
        }
        int indexOfPeriod = this.playbackInfo.timeline.getIndexOfPeriod(pendingMessageInfo.resolvedPeriodUid);
        if (indexOfPeriod == -1) {
            return false;
        }
        pendingMessageInfo.resolvedPeriodIndex = indexOfPeriod;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063 A[EDGE_INSN: B:67:0x0063->B:21:0x0063 ?: BREAK  
    EDGE_INSN: B:68:0x0063->B:21:0x0063 ?: BREAK  
    EDGE_INSN: B:69:0x0063->B:21:0x0063 ?: BREAK  ] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00be A[SYNTHETIC, Splitter:B:46:0x00be] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x00a8 A[EDGE_INSN: B:71:0x00a8->B:85:0x00a8 ?: BREAK  
    EDGE_INSN: B:72:0x00a8->B:85:0x00a8 ?: BREAK  
    EDGE_INSN: B:74:0x00a8->B:85:0x00a8 ?: BREAK  
    EDGE_INSN: B:75:0x00a8->B:85:0x00a8 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void maybeTriggerPendingMessages(long r7, long r9) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r6 = this;
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r0 = r6.pendingMessages
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x011a
            com.google.android.exoplayer2.PlaybackInfo r0 = r6.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r0 = r0.periodId
            boolean r0 = r0.isAd()
            if (r0 == 0) goto L_0x0014
            goto L_0x011a
        L_0x0014:
            com.google.android.exoplayer2.PlaybackInfo r0 = r6.playbackInfo
            long r0 = r0.startPositionUs
            int r2 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r2 != 0) goto L_0x001f
            r0 = 1
            long r7 = r7 - r0
        L_0x001f:
            com.google.android.exoplayer2.PlaybackInfo r0 = r6.playbackInfo
            com.google.android.exoplayer2.Timeline r0 = r0.timeline
            com.google.android.exoplayer2.PlaybackInfo r1 = r6.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r1.periodId
            java.lang.Object r1 = r1.periodUid
            int r0 = r0.getIndexOfPeriod(r1)
            int r1 = r6.nextPendingMessageIndex
            r2 = 0
            if (r1 <= 0) goto L_0x003d
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r6.pendingMessages
            int r1 = r1 + -1
            java.lang.Object r1 = r3.get(r1)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r1 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r1
            goto L_0x003e
        L_0x003d:
            r1 = r2
        L_0x003e:
            if (r1 == 0) goto L_0x0063
            int r3 = r1.resolvedPeriodIndex
            if (r3 > r0) goto L_0x004e
            int r3 = r1.resolvedPeriodIndex
            if (r3 != r0) goto L_0x0063
            long r3 = r1.resolvedPeriodTimeUs
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 <= 0) goto L_0x0063
        L_0x004e:
            int r1 = r6.nextPendingMessageIndex
            int r1 = r1 + -1
            r6.nextPendingMessageIndex = r1
            int r1 = r6.nextPendingMessageIndex
            if (r1 <= 0) goto L_0x003d
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r6.pendingMessages
            int r1 = r1 + -1
            java.lang.Object r1 = r3.get(r1)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r1 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r1
            goto L_0x003e
        L_0x0063:
            int r1 = r6.nextPendingMessageIndex
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r6.pendingMessages
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0078
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r1 = r6.pendingMessages
            int r3 = r6.nextPendingMessageIndex
            java.lang.Object r1 = r1.get(r3)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r1 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r1
            goto L_0x0079
        L_0x0078:
            r1 = r2
        L_0x0079:
            if (r1 == 0) goto L_0x00a8
            java.lang.Object r3 = r1.resolvedPeriodUid
            if (r3 == 0) goto L_0x00a8
            int r3 = r1.resolvedPeriodIndex
            if (r3 < r0) goto L_0x008d
            int r3 = r1.resolvedPeriodIndex
            if (r3 != r0) goto L_0x00a8
            long r3 = r1.resolvedPeriodTimeUs
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 > 0) goto L_0x00a8
        L_0x008d:
            int r1 = r6.nextPendingMessageIndex
            int r1 = r1 + 1
            r6.nextPendingMessageIndex = r1
            int r1 = r6.nextPendingMessageIndex
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r6.pendingMessages
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0078
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r1 = r6.pendingMessages
            int r3 = r6.nextPendingMessageIndex
            java.lang.Object r1 = r1.get(r3)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r1 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r1
            goto L_0x0079
        L_0x00a8:
            if (r1 == 0) goto L_0x011a
            java.lang.Object r3 = r1.resolvedPeriodUid
            if (r3 == 0) goto L_0x011a
            int r3 = r1.resolvedPeriodIndex
            if (r3 != r0) goto L_0x011a
            long r3 = r1.resolvedPeriodTimeUs
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x011a
            long r3 = r1.resolvedPeriodTimeUs
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x011a
            com.google.android.exoplayer2.PlayerMessage r3 = r1.message     // Catch:{ all -> 0x00f9 }
            r6.sendMessageToTarget(r3)     // Catch:{ all -> 0x00f9 }
            com.google.android.exoplayer2.PlayerMessage r3 = r1.message
            boolean r3 = r3.getDeleteAfterDelivery()
            if (r3 != 0) goto L_0x00db
            com.google.android.exoplayer2.PlayerMessage r1 = r1.message
            boolean r1 = r1.isCanceled()
            if (r1 == 0) goto L_0x00d4
            goto L_0x00db
        L_0x00d4:
            int r1 = r6.nextPendingMessageIndex
            int r1 = r1 + 1
            r6.nextPendingMessageIndex = r1
            goto L_0x00e2
        L_0x00db:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r1 = r6.pendingMessages
            int r3 = r6.nextPendingMessageIndex
            r1.remove(r3)
        L_0x00e2:
            int r1 = r6.nextPendingMessageIndex
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r3 = r6.pendingMessages
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x00f7
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r1 = r6.pendingMessages
            int r3 = r6.nextPendingMessageIndex
            java.lang.Object r1 = r1.get(r3)
            com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo r1 = (com.google.android.exoplayer2.ExoPlayerImplInternal.PendingMessageInfo) r1
            goto L_0x00a8
        L_0x00f7:
            r1 = r2
            goto L_0x00a8
        L_0x00f9:
            r7 = move-exception
            com.google.android.exoplayer2.PlayerMessage r8 = r1.message
            boolean r8 = r8.getDeleteAfterDelivery()
            if (r8 != 0) goto L_0x0112
            com.google.android.exoplayer2.PlayerMessage r8 = r1.message
            boolean r8 = r8.isCanceled()
            if (r8 == 0) goto L_0x010b
            goto L_0x0112
        L_0x010b:
            int r8 = r6.nextPendingMessageIndex
            int r8 = r8 + 1
            r6.nextPendingMessageIndex = r8
            goto L_0x0119
        L_0x0112:
            java.util.ArrayList<com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo> r8 = r6.pendingMessages
            int r9 = r6.nextPendingMessageIndex
            r8.remove(r9)
        L_0x0119:
            throw r7
        L_0x011a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.maybeTriggerPendingMessages(long, long):void");
    }

    private void ensureStopped(Renderer renderer) throws ExoPlaybackException {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private void disableRenderer(Renderer renderer) throws ExoPlaybackException {
        this.mediaClock.onRendererDisabled(renderer);
        ensureStopped(renderer);
        renderer.disable();
    }

    private void reselectTracksInternal() throws ExoPlaybackException {
        if (this.queue.hasPlayingPeriod()) {
            float f = this.mediaClock.getPlaybackParameters().speed;
            MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
            MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
            boolean z = true;
            while (playingPeriod != null && playingPeriod.prepared) {
                TrackSelectorResult selectTracks = playingPeriod.selectTracks(f, this.playbackInfo.timeline);
                if (selectTracks != null) {
                    if (z) {
                        MediaPeriodHolder playingPeriod2 = this.queue.getPlayingPeriod();
                        boolean removeAfter = this.queue.removeAfter(playingPeriod2);
                        boolean[] zArr = new boolean[this.renderers.length];
                        long applyTrackSelection = playingPeriod2.applyTrackSelection(selectTracks, this.playbackInfo.positionUs, removeAfter, zArr);
                        if (!(this.playbackInfo.playbackState == 4 || applyTrackSelection == this.playbackInfo.positionUs)) {
                            PlaybackInfo playbackInfo2 = this.playbackInfo;
                            this.playbackInfo = playbackInfo2.copyWithNewPosition(playbackInfo2.periodId, applyTrackSelection, this.playbackInfo.contentPositionUs, getTotalBufferedDurationUs());
                            this.playbackInfoUpdate.setPositionDiscontinuity(4);
                            resetRendererPosition(applyTrackSelection);
                        }
                        boolean[] zArr2 = new boolean[this.renderers.length];
                        int i = 0;
                        int i2 = 0;
                        while (true) {
                            Renderer[] rendererArr = this.renderers;
                            if (i >= rendererArr.length) {
                                break;
                            }
                            Renderer renderer = rendererArr[i];
                            zArr2[i] = renderer.getState() != 0;
                            SampleStream sampleStream = playingPeriod2.sampleStreams[i];
                            if (sampleStream != null) {
                                i2++;
                            }
                            if (zArr2[i]) {
                                if (sampleStream != renderer.getStream()) {
                                    disableRenderer(renderer);
                                } else if (zArr[i]) {
                                    renderer.resetPosition(this.rendererPositionUs);
                                }
                            }
                            i++;
                        }
                        this.playbackInfo = this.playbackInfo.copyWithTrackInfo(playingPeriod2.getTrackGroups(), playingPeriod2.getTrackSelectorResult());
                        enableRenderers(zArr2, i2);
                    } else {
                        this.queue.removeAfter(playingPeriod);
                        if (playingPeriod.prepared) {
                            playingPeriod.applyTrackSelection(selectTracks, Math.max(playingPeriod.info.startPositionUs, playingPeriod.toPeriodTime(this.rendererPositionUs)), false);
                        }
                    }
                    handleLoadingMediaPeriodChanged(true);
                    if (this.playbackInfo.playbackState != 4) {
                        maybeContinueLoading();
                        updatePlaybackPositions();
                        this.handler.sendEmptyMessage(2);
                        return;
                    }
                    return;
                }
                if (playingPeriod == readingPeriod) {
                    z = false;
                }
                playingPeriod = playingPeriod.getNext();
            }
        }
    }

    private void updateTrackSelectionPlaybackSpeed(float f) {
        MediaPeriodHolder frontPeriod = this.queue.getFrontPeriod();
        while (frontPeriod != null && frontPeriod.prepared) {
            for (TrackSelection trackSelection : frontPeriod.getTrackSelectorResult().selections.getAll()) {
                if (trackSelection != null) {
                    trackSelection.onPlaybackSpeed(f);
                }
            }
            frontPeriod = frontPeriod.getNext();
        }
    }

    private void notifyTrackSelectionDiscontinuity() {
        for (MediaPeriodHolder frontPeriod = this.queue.getFrontPeriod(); frontPeriod != null; frontPeriod = frontPeriod.getNext()) {
            TrackSelectorResult trackSelectorResult = frontPeriod.getTrackSelectorResult();
            if (trackSelectorResult != null) {
                for (TrackSelection trackSelection : trackSelectorResult.selections.getAll()) {
                    if (trackSelection != null) {
                        trackSelection.onDiscontinuity();
                    }
                }
            }
        }
    }

    private boolean shouldTransitionToReadyState(boolean z) {
        if (this.enabledRenderers.length == 0) {
            return isTimelineReady();
        }
        if (!z) {
            return false;
        }
        if (!this.playbackInfo.isLoading) {
            return true;
        }
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if ((loadingPeriod.isFullyBuffered() && loadingPeriod.info.isFinal) || this.loadControl.shouldStartPlayback(getTotalBufferedDurationUs(), this.mediaClock.getPlaybackParameters().speed, this.rebuffering)) {
            return true;
        }
        return false;
    }

    private boolean isTimelineReady() {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        MediaPeriodHolder next = playingPeriod.getNext();
        long j = playingPeriod.info.durationUs;
        return j == C1119C.TIME_UNSET || this.playbackInfo.positionUs < j || (next != null && (next.prepared || next.info.f121id.isAd()));
    }

    private void maybeThrowSourceInfoRefreshError() throws IOException {
        if (this.queue.getLoadingPeriod() != null) {
            Renderer[] rendererArr = this.enabledRenderers;
            int length = rendererArr.length;
            int i = 0;
            while (i < length) {
                if (rendererArr[i].hasReadStreamToEnd()) {
                    i++;
                } else {
                    return;
                }
            }
        }
        this.mediaSource.maybeThrowSourceInfoRefreshError();
    }

    private void maybeThrowPeriodPrepareError() throws IOException {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (loadingPeriod != null && !loadingPeriod.prepared) {
            if (readingPeriod == null || readingPeriod.getNext() == loadingPeriod) {
                Renderer[] rendererArr = this.enabledRenderers;
                int length = rendererArr.length;
                int i = 0;
                while (i < length) {
                    if (rendererArr[i].hasReadStreamToEnd()) {
                        i++;
                    } else {
                        return;
                    }
                }
                loadingPeriod.mediaPeriod.maybeThrowPrepareError();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleSourceInfoRefreshed(com.google.android.exoplayer2.ExoPlayerImplInternal.MediaSourceRefreshInfo r14) throws com.google.android.exoplayer2.ExoPlaybackException {
        /*
            r13 = this;
            com.google.android.exoplayer2.source.MediaSource r0 = r14.source
            com.google.android.exoplayer2.source.MediaSource r1 = r13.mediaSource
            if (r0 == r1) goto L_0x0007
            return
        L_0x0007:
            com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate r0 = r13.playbackInfoUpdate
            int r1 = r13.pendingPrepareCount
            r0.incrementPendingOperationAcks(r1)
            r0 = 0
            r13.pendingPrepareCount = r0
            com.google.android.exoplayer2.PlaybackInfo r1 = r13.playbackInfo
            com.google.android.exoplayer2.Timeline r1 = r1.timeline
            com.google.android.exoplayer2.Timeline r2 = r14.timeline
            java.lang.Object r14 = r14.manifest
            com.google.android.exoplayer2.MediaPeriodQueue r3 = r13.queue
            r3.setTimeline(r2)
            com.google.android.exoplayer2.PlaybackInfo r3 = r13.playbackInfo
            com.google.android.exoplayer2.PlaybackInfo r14 = r3.copyWithTimeline(r2, r14)
            r13.playbackInfo = r14
            r13.resolvePendingMessagePositions()
            com.google.android.exoplayer2.PlaybackInfo r14 = r13.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r14 = r14.periodId
            com.google.android.exoplayer2.PlaybackInfo r3 = r13.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r3 = r3.periodId
            boolean r3 = r3.isAd()
            if (r3 == 0) goto L_0x003c
            com.google.android.exoplayer2.PlaybackInfo r3 = r13.playbackInfo
            long r3 = r3.contentPositionUs
            goto L_0x0040
        L_0x003c:
            com.google.android.exoplayer2.PlaybackInfo r3 = r13.playbackInfo
            long r3 = r3.positionUs
        L_0x0040:
            com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition r5 = r13.pendingInitialSeekPosition
            if (r5 == 0) goto L_0x0066
            r14 = 1
            android.util.Pair r14 = r13.resolveSeekPosition(r5, r14)
            r1 = 0
            r13.pendingInitialSeekPosition = r1
            if (r14 != 0) goto L_0x0052
            r13.handleSourceInfoRefreshEndedPlayback()
            return
        L_0x0052:
            java.lang.Object r1 = r14.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            com.google.android.exoplayer2.MediaPeriodQueue r5 = r13.queue
            java.lang.Object r14 = r14.first
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r14 = r5.resolveMediaPeriodIdForAds(r14, r1)
        L_0x0062:
            r6 = r14
            r9 = r1
            goto L_0x00e4
        L_0x0066:
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x00a2
            boolean r7 = r2.isEmpty()
            if (r7 != 0) goto L_0x00a2
            boolean r14 = r13.shuffleModeEnabled
            int r14 = r2.getFirstWindowIndex(r14)
            android.util.Pair r14 = r13.getPeriodPosition(r2, r14, r5)
            com.google.android.exoplayer2.MediaPeriodQueue r1 = r13.queue
            java.lang.Object r2 = r14.first
            java.lang.Object r5 = r14.second
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r1.resolveMediaPeriodIdForAds(r2, r5)
            boolean r2 = r1.isAd()
            if (r2 != 0) goto L_0x009e
            java.lang.Object r14 = r14.second
            java.lang.Long r14 = (java.lang.Long) r14
            long r5 = r14.longValue()
            goto L_0x009f
        L_0x009e:
            r5 = r3
        L_0x009f:
            r9 = r5
            r6 = r1
            goto L_0x00e4
        L_0x00a2:
            java.lang.Object r7 = r14.periodUid
            int r7 = r2.getIndexOfPeriod(r7)
            r8 = -1
            if (r7 != r8) goto L_0x00d4
            java.lang.Object r14 = r14.periodUid
            java.lang.Object r14 = r13.resolveSubsequentPeriod(r14, r1, r2)
            if (r14 != 0) goto L_0x00b7
            r13.handleSourceInfoRefreshEndedPlayback()
            return
        L_0x00b7:
            com.google.android.exoplayer2.Timeline$Period r1 = r13.period
            com.google.android.exoplayer2.Timeline$Period r14 = r2.getPeriodByUid(r14, r1)
            int r14 = r14.windowIndex
            android.util.Pair r14 = r13.getPeriodPosition(r2, r14, r5)
            java.lang.Object r1 = r14.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            com.google.android.exoplayer2.MediaPeriodQueue r5 = r13.queue
            java.lang.Object r14 = r14.first
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r14 = r5.resolveMediaPeriodIdForAds(r14, r1)
            goto L_0x0062
        L_0x00d4:
            boolean r1 = r14.isAd()
            if (r1 == 0) goto L_0x00e2
            com.google.android.exoplayer2.MediaPeriodQueue r1 = r13.queue
            java.lang.Object r14 = r14.periodUid
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r14 = r1.resolveMediaPeriodIdForAds(r14, r3)
        L_0x00e2:
            r6 = r14
            r9 = r3
        L_0x00e4:
            com.google.android.exoplayer2.PlaybackInfo r14 = r13.playbackInfo
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r14 = r14.periodId
            boolean r14 = r14.equals(r6)
            if (r14 == 0) goto L_0x0104
            int r14 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r14 != 0) goto L_0x0104
            com.google.android.exoplayer2.MediaPeriodQueue r14 = r13.queue
            long r1 = r13.rendererPositionUs
            long r3 = r13.getMaxRendererReadPositionUs()
            boolean r14 = r14.updateQueuedPeriods(r1, r3)
            if (r14 != 0) goto L_0x0145
            r13.seekToCurrentPosition(r0)
            goto L_0x0145
        L_0x0104:
            com.google.android.exoplayer2.MediaPeriodQueue r14 = r13.queue
            com.google.android.exoplayer2.MediaPeriodHolder r14 = r14.getFrontPeriod()
            if (r14 == 0) goto L_0x012b
        L_0x010c:
            com.google.android.exoplayer2.MediaPeriodHolder r1 = r14.getNext()
            if (r1 == 0) goto L_0x012b
            com.google.android.exoplayer2.MediaPeriodHolder r14 = r14.getNext()
            com.google.android.exoplayer2.MediaPeriodInfo r1 = r14.info
            com.google.android.exoplayer2.source.MediaSource$MediaPeriodId r1 = r1.f121id
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x010c
            com.google.android.exoplayer2.MediaPeriodQueue r1 = r13.queue
            com.google.android.exoplayer2.MediaPeriodInfo r2 = r14.info
            com.google.android.exoplayer2.MediaPeriodInfo r1 = r1.getUpdatedMediaPeriodInfo(r2)
            r14.info = r1
            goto L_0x010c
        L_0x012b:
            boolean r14 = r6.isAd()
            if (r14 == 0) goto L_0x0134
            r1 = 0
            goto L_0x0135
        L_0x0134:
            r1 = r9
        L_0x0135:
            long r7 = r13.seekToPeriodPosition(r6, r1)
            com.google.android.exoplayer2.PlaybackInfo r5 = r13.playbackInfo
            long r11 = r13.getTotalBufferedDurationUs()
            com.google.android.exoplayer2.PlaybackInfo r14 = r5.copyWithNewPosition(r6, r7, r9, r11)
            r13.playbackInfo = r14
        L_0x0145:
            r13.handleLoadingMediaPeriodChanged(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ExoPlayerImplInternal.handleSourceInfoRefreshed(com.google.android.exoplayer2.ExoPlayerImplInternal$MediaSourceRefreshInfo):void");
    }

    private long getMaxRendererReadPositionUs() {
        MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
        if (readingPeriod == null) {
            return 0;
        }
        long rendererOffset = readingPeriod.getRendererOffset();
        int i = 0;
        while (true) {
            Renderer[] rendererArr = this.renderers;
            if (i >= rendererArr.length) {
                return rendererOffset;
            }
            if (rendererArr[i].getState() != 0 && this.renderers[i].getStream() == readingPeriod.sampleStreams[i]) {
                long readingPositionUs = this.renderers[i].getReadingPositionUs();
                if (readingPositionUs == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                rendererOffset = Math.max(readingPositionUs, rendererOffset);
            }
            i++;
        }
    }

    private void handleSourceInfoRefreshEndedPlayback() {
        setState(4);
        resetInternal(false, false, true, false);
    }

    @Nullable
    private Object resolveSubsequentPeriod(Object obj, Timeline timeline, Timeline timeline2) {
        int indexOfPeriod = timeline.getIndexOfPeriod(obj);
        int periodCount = timeline.getPeriodCount();
        int i = indexOfPeriod;
        int i2 = -1;
        for (int i3 = 0; i3 < periodCount && i2 == -1; i3++) {
            i = timeline.getNextPeriodIndex(i, this.period, this.window, this.repeatMode, this.shuffleModeEnabled);
            if (i == -1) {
                break;
            }
            i2 = timeline2.getIndexOfPeriod(timeline.getUidOfPeriod(i));
        }
        if (i2 == -1) {
            return null;
        }
        return timeline2.getUidOfPeriod(i2);
    }

    private Pair<Object, Long> resolveSeekPosition(SeekPosition seekPosition, boolean z) {
        int indexOfPeriod;
        Timeline timeline = this.playbackInfo.timeline;
        Timeline timeline2 = seekPosition.timeline;
        if (timeline.isEmpty()) {
            return null;
        }
        if (timeline2.isEmpty()) {
            timeline2 = timeline;
        }
        try {
            Pair<Object, Long> periodPosition = timeline2.getPeriodPosition(this.window, this.period, seekPosition.windowIndex, seekPosition.windowPositionUs);
            if (timeline == timeline2 || (indexOfPeriod = timeline.getIndexOfPeriod(periodPosition.first)) != -1) {
                return periodPosition;
            }
            if (z && resolveSubsequentPeriod(periodPosition.first, timeline2, timeline) != null) {
                return getPeriodPosition(timeline, timeline.getPeriod(indexOfPeriod, this.period).windowIndex, C1119C.TIME_UNSET);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    private Pair<Object, Long> getPeriodPosition(Timeline timeline, int i, long j) {
        return timeline.getPeriodPosition(this.window, this.period, i, j);
    }

    private void updatePeriods() throws ExoPlaybackException, IOException {
        MediaSource mediaSource2 = this.mediaSource;
        if (mediaSource2 != null) {
            if (this.pendingPrepareCount > 0) {
                mediaSource2.maybeThrowSourceInfoRefreshError();
                return;
            }
            maybeUpdateLoadingPeriod();
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            int i = 0;
            if (loadingPeriod == null || loadingPeriod.isFullyBuffered()) {
                setIsLoading(false);
            } else if (!this.playbackInfo.isLoading) {
                maybeContinueLoading();
            }
            if (this.queue.hasPlayingPeriod()) {
                MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
                MediaPeriodHolder readingPeriod = this.queue.getReadingPeriod();
                boolean z = false;
                while (this.playWhenReady && playingPeriod != readingPeriod && this.rendererPositionUs >= playingPeriod.getNext().getStartPositionRendererTime()) {
                    if (z) {
                        maybeNotifyPlaybackInfoChanged();
                    }
                    int i2 = playingPeriod.info.isLastInTimelinePeriod ? 0 : 3;
                    MediaPeriodHolder advancePlayingPeriod = this.queue.advancePlayingPeriod();
                    updatePlayingPeriodRenderers(playingPeriod);
                    this.playbackInfo = this.playbackInfo.copyWithNewPosition(advancePlayingPeriod.info.f121id, advancePlayingPeriod.info.startPositionUs, advancePlayingPeriod.info.contentPositionUs, getTotalBufferedDurationUs());
                    this.playbackInfoUpdate.setPositionDiscontinuity(i2);
                    updatePlaybackPositions();
                    playingPeriod = advancePlayingPeriod;
                    z = true;
                }
                if (readingPeriod.info.isFinal) {
                    while (true) {
                        Renderer[] rendererArr = this.renderers;
                        if (i < rendererArr.length) {
                            Renderer renderer = rendererArr[i];
                            SampleStream sampleStream = readingPeriod.sampleStreams[i];
                            if (sampleStream != null && renderer.getStream() == sampleStream && renderer.hasReadStreamToEnd()) {
                                renderer.setCurrentStreamFinal();
                            }
                            i++;
                        } else {
                            return;
                        }
                    }
                } else if (readingPeriod.getNext() != null) {
                    int i3 = 0;
                    while (true) {
                        Renderer[] rendererArr2 = this.renderers;
                        if (i3 < rendererArr2.length) {
                            Renderer renderer2 = rendererArr2[i3];
                            SampleStream sampleStream2 = readingPeriod.sampleStreams[i3];
                            if (renderer2.getStream() != sampleStream2) {
                                return;
                            }
                            if (sampleStream2 == null || renderer2.hasReadStreamToEnd()) {
                                i3++;
                            } else {
                                return;
                            }
                        } else if (!readingPeriod.getNext().prepared) {
                            maybeThrowPeriodPrepareError();
                            return;
                        } else {
                            TrackSelectorResult trackSelectorResult = readingPeriod.getTrackSelectorResult();
                            MediaPeriodHolder advanceReadingPeriod = this.queue.advanceReadingPeriod();
                            TrackSelectorResult trackSelectorResult2 = advanceReadingPeriod.getTrackSelectorResult();
                            boolean z2 = advanceReadingPeriod.mediaPeriod.readDiscontinuity() != C1119C.TIME_UNSET;
                            int i4 = 0;
                            while (true) {
                                Renderer[] rendererArr3 = this.renderers;
                                if (i4 < rendererArr3.length) {
                                    Renderer renderer3 = rendererArr3[i4];
                                    if (trackSelectorResult.isRendererEnabled(i4)) {
                                        if (z2) {
                                            renderer3.setCurrentStreamFinal();
                                        } else if (!renderer3.isCurrentStreamFinal()) {
                                            TrackSelection trackSelection = trackSelectorResult2.selections.get(i4);
                                            boolean isRendererEnabled = trackSelectorResult2.isRendererEnabled(i4);
                                            boolean z3 = this.rendererCapabilities[i4].getTrackType() == 6;
                                            RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i4];
                                            RendererConfiguration rendererConfiguration2 = trackSelectorResult2.rendererConfigurations[i4];
                                            if (!isRendererEnabled || !rendererConfiguration2.equals(rendererConfiguration) || z3) {
                                                renderer3.setCurrentStreamFinal();
                                            } else {
                                                renderer3.replaceStream(getFormats(trackSelection), advanceReadingPeriod.sampleStreams[i4], advanceReadingPeriod.getRendererOffset());
                                            }
                                        }
                                    }
                                    i4++;
                                } else {
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private void maybeUpdateLoadingPeriod() throws IOException {
        this.queue.reevaluateBuffer(this.rendererPositionUs);
        if (this.queue.shouldLoadNextMediaPeriod()) {
            MediaPeriodInfo nextMediaPeriodInfo = this.queue.getNextMediaPeriodInfo(this.rendererPositionUs, this.playbackInfo);
            if (nextMediaPeriodInfo == null) {
                maybeThrowSourceInfoRefreshError();
                return;
            }
            this.queue.enqueueNextMediaPeriod(this.rendererCapabilities, this.trackSelector, this.loadControl.getAllocator(), this.mediaSource, nextMediaPeriodInfo).prepare(this, nextMediaPeriodInfo.startPositionUs);
            setIsLoading(true);
            handleLoadingMediaPeriodChanged(false);
        }
    }

    private void handlePeriodPrepared(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.queue.isLoading(mediaPeriod)) {
            MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
            loadingPeriod.handlePrepared(this.mediaClock.getPlaybackParameters().speed, this.playbackInfo.timeline);
            updateLoadControlTrackSelection(loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
            if (!this.queue.hasPlayingPeriod()) {
                resetRendererPosition(this.queue.advancePlayingPeriod().info.startPositionUs);
                updatePlayingPeriodRenderers((MediaPeriodHolder) null);
            }
            maybeContinueLoading();
        }
    }

    private void handleContinueLoadingRequested(MediaPeriod mediaPeriod) {
        if (this.queue.isLoading(mediaPeriod)) {
            this.queue.reevaluateBuffer(this.rendererPositionUs);
            maybeContinueLoading();
        }
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters) throws ExoPlaybackException {
        this.eventHandler.obtainMessage(1, playbackParameters).sendToTarget();
        updateTrackSelectionPlaybackSpeed(playbackParameters.speed);
        for (Renderer renderer : this.renderers) {
            if (renderer != null) {
                renderer.setOperatingRate(playbackParameters.speed);
            }
        }
    }

    private void maybeContinueLoading() {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        long nextLoadPositionUs = loadingPeriod.getNextLoadPositionUs();
        if (nextLoadPositionUs == Long.MIN_VALUE) {
            setIsLoading(false);
            return;
        }
        boolean shouldContinueLoading = this.loadControl.shouldContinueLoading(getTotalBufferedDurationUs(nextLoadPositionUs), this.mediaClock.getPlaybackParameters().speed);
        setIsLoading(shouldContinueLoading);
        if (shouldContinueLoading) {
            loadingPeriod.continueLoading(this.rendererPositionUs);
        }
    }

    private void updatePlayingPeriodRenderers(@Nullable MediaPeriodHolder mediaPeriodHolder) throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        if (playingPeriod != null && mediaPeriodHolder != playingPeriod) {
            boolean[] zArr = new boolean[this.renderers.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                Renderer[] rendererArr = this.renderers;
                if (i < rendererArr.length) {
                    Renderer renderer = rendererArr[i];
                    zArr[i] = renderer.getState() != 0;
                    if (playingPeriod.getTrackSelectorResult().isRendererEnabled(i)) {
                        i2++;
                    }
                    if (zArr[i] && (!playingPeriod.getTrackSelectorResult().isRendererEnabled(i) || (renderer.isCurrentStreamFinal() && renderer.getStream() == mediaPeriodHolder.sampleStreams[i]))) {
                        disableRenderer(renderer);
                    }
                    i++;
                } else {
                    this.playbackInfo = this.playbackInfo.copyWithTrackInfo(playingPeriod.getTrackGroups(), playingPeriod.getTrackSelectorResult());
                    enableRenderers(zArr, i2);
                    return;
                }
            }
        }
    }

    private void enableRenderers(boolean[] zArr, int i) throws ExoPlaybackException {
        this.enabledRenderers = new Renderer[i];
        TrackSelectorResult trackSelectorResult = this.queue.getPlayingPeriod().getTrackSelectorResult();
        for (int i2 = 0; i2 < this.renderers.length; i2++) {
            if (!trackSelectorResult.isRendererEnabled(i2)) {
                this.renderers[i2].reset();
            }
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.renderers.length; i4++) {
            if (trackSelectorResult.isRendererEnabled(i4)) {
                enableRenderer(i4, zArr[i4], i3);
                i3++;
            }
        }
    }

    private void enableRenderer(int i, boolean z, int i2) throws ExoPlaybackException {
        MediaPeriodHolder playingPeriod = this.queue.getPlayingPeriod();
        Renderer renderer = this.renderers[i];
        this.enabledRenderers[i2] = renderer;
        if (renderer.getState() == 0) {
            TrackSelectorResult trackSelectorResult = playingPeriod.getTrackSelectorResult();
            RendererConfiguration rendererConfiguration = trackSelectorResult.rendererConfigurations[i];
            Format[] formats = getFormats(trackSelectorResult.selections.get(i));
            boolean z2 = this.playWhenReady && this.playbackInfo.playbackState == 3;
            renderer.enable(rendererConfiguration, formats, playingPeriod.sampleStreams[i], this.rendererPositionUs, !z && z2, playingPeriod.getRendererOffset());
            this.mediaClock.onRendererEnabled(renderer);
            if (z2) {
                renderer.start();
            }
        }
    }

    private boolean rendererWaitingForNextStream(Renderer renderer) {
        MediaPeriodHolder next = this.queue.getReadingPeriod().getNext();
        return next != null && next.prepared && renderer.hasReadStreamToEnd();
    }

    private void handleLoadingMediaPeriodChanged(boolean z) {
        long j;
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        MediaSource.MediaPeriodId mediaPeriodId = loadingPeriod == null ? this.playbackInfo.periodId : loadingPeriod.info.f121id;
        boolean z2 = !this.playbackInfo.loadingMediaPeriodId.equals(mediaPeriodId);
        if (z2) {
            this.playbackInfo = this.playbackInfo.copyWithLoadingMediaPeriodId(mediaPeriodId);
        }
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        if (loadingPeriod == null) {
            j = playbackInfo2.positionUs;
        } else {
            j = loadingPeriod.getBufferedPositionUs();
        }
        playbackInfo2.bufferedPositionUs = j;
        this.playbackInfo.totalBufferedDurationUs = getTotalBufferedDurationUs();
        if ((z2 || z) && loadingPeriod != null && loadingPeriod.prepared) {
            updateLoadControlTrackSelection(loadingPeriod.getTrackGroups(), loadingPeriod.getTrackSelectorResult());
        }
    }

    private long getTotalBufferedDurationUs() {
        return getTotalBufferedDurationUs(this.playbackInfo.bufferedPositionUs);
    }

    private long getTotalBufferedDurationUs(long j) {
        MediaPeriodHolder loadingPeriod = this.queue.getLoadingPeriod();
        if (loadingPeriod == null) {
            return 0;
        }
        return Math.max(0, j - loadingPeriod.toPeriodTime(this.rendererPositionUs));
    }

    private void updateLoadControlTrackSelection(TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        this.loadControl.onTracksSelected(this.renderers, trackGroupArray, trackSelectorResult.selections);
    }

    private static Format[] getFormats(TrackSelection trackSelection) {
        int length = trackSelection != null ? trackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i = 0; i < length; i++) {
            formatArr[i] = trackSelection.getFormat(i);
        }
        return formatArr;
    }

    private static final class SeekPosition {
        public final Timeline timeline;
        public final int windowIndex;
        public final long windowPositionUs;

        public SeekPosition(Timeline timeline2, int i, long j) {
            this.timeline = timeline2;
            this.windowIndex = i;
            this.windowPositionUs = j;
        }
    }

    private static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public final PlayerMessage message;
        public int resolvedPeriodIndex;
        public long resolvedPeriodTimeUs;
        @Nullable
        public Object resolvedPeriodUid;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.message = playerMessage;
        }

        public void setResolvedPosition(int i, long j, Object obj) {
            this.resolvedPeriodIndex = i;
            this.resolvedPeriodTimeUs = j;
            this.resolvedPeriodUid = obj;
        }

        public int compareTo(@NonNull PendingMessageInfo pendingMessageInfo) {
            if ((this.resolvedPeriodUid == null) != (pendingMessageInfo.resolvedPeriodUid == null)) {
                if (this.resolvedPeriodUid != null) {
                    return -1;
                }
                return 1;
            } else if (this.resolvedPeriodUid == null) {
                return 0;
            } else {
                int i = this.resolvedPeriodIndex - pendingMessageInfo.resolvedPeriodIndex;
                if (i != 0) {
                    return i;
                }
                return Util.compareLong(this.resolvedPeriodTimeUs, pendingMessageInfo.resolvedPeriodTimeUs);
            }
        }
    }

    private static final class MediaSourceRefreshInfo {
        public final Object manifest;
        public final MediaSource source;
        public final Timeline timeline;

        public MediaSourceRefreshInfo(MediaSource mediaSource, Timeline timeline2, Object obj) {
            this.source = mediaSource;
            this.timeline = timeline2;
            this.manifest = obj;
        }
    }

    private static final class PlaybackInfoUpdate {
        /* access modifiers changed from: private */
        public int discontinuityReason;
        private PlaybackInfo lastPlaybackInfo;
        /* access modifiers changed from: private */
        public int operationAcks;
        /* access modifiers changed from: private */
        public boolean positionDiscontinuity;

        private PlaybackInfoUpdate() {
        }

        public boolean hasPendingUpdate(PlaybackInfo playbackInfo) {
            return playbackInfo != this.lastPlaybackInfo || this.operationAcks > 0 || this.positionDiscontinuity;
        }

        public void reset(PlaybackInfo playbackInfo) {
            this.lastPlaybackInfo = playbackInfo;
            this.operationAcks = 0;
            this.positionDiscontinuity = false;
        }

        public void incrementPendingOperationAcks(int i) {
            this.operationAcks += i;
        }

        public void setPositionDiscontinuity(int i) {
            boolean z = true;
            if (!this.positionDiscontinuity || this.discontinuityReason == 4) {
                this.positionDiscontinuity = true;
                this.discontinuityReason = i;
                return;
            }
            if (i != 4) {
                z = false;
            }
            Assertions.checkArgument(z);
        }
    }
}
