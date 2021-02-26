package com.google.android.exoplayer2.offline;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaCrypto;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class DownloadHelper {
    private static final MediaSourceFactory DASH_FACTORY = getMediaSourceFactory("com.google.android.exoplayer2.source.dash.DashMediaSource$Factory");
    public static final DefaultTrackSelector.Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS = new DefaultTrackSelector.ParametersBuilder().setForceHighestSupportedBitrate(true).build();
    private static final MediaSourceFactory HLS_FACTORY = getMediaSourceFactory("com.google.android.exoplayer2.source.hls.HlsMediaSource$Factory");
    private static final MediaSourceFactory SS_FACTORY = getMediaSourceFactory("com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$Factory");
    @Nullable
    private final String cacheKey;
    private Callback callback;
    private final Handler callbackHandler;
    private final String downloadType;
    private List<TrackSelection>[][] immutableTrackSelectionsByPeriodAndRenderer;
    private boolean isPreparedWithMedia;
    private MappingTrackSelector.MappedTrackInfo[] mappedTrackInfos;
    private MediaPreparer mediaPreparer;
    @Nullable
    private final MediaSource mediaSource;
    private final RendererCapabilities[] rendererCapabilities;
    private final SparseIntArray scratchSet;
    private TrackGroupArray[] trackGroupArrays;
    private List<TrackSelection>[][] trackSelectionsByPeriodAndRenderer;
    private final DefaultTrackSelector trackSelector = new DefaultTrackSelector((TrackSelection.Factory) new DownloadTrackSelection.Factory());
    private final Uri uri;

    public interface Callback {
        void onPrepareError(DownloadHelper downloadHelper, IOException iOException);

        void onPrepared(DownloadHelper downloadHelper);
    }

    static /* synthetic */ void lambda$new$0() {
    }

    public static DownloadHelper forProgressive(Uri uri2) {
        return forProgressive(uri2, (String) null);
    }

    public static DownloadHelper forProgressive(Uri uri2, @Nullable String str) {
        return new DownloadHelper(DownloadRequest.TYPE_PROGRESSIVE, uri2, str, (MediaSource) null, DEFAULT_TRACK_SELECTOR_PARAMETERS, new RendererCapabilities[0]);
    }

    public static DownloadHelper forDash(Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forDash(uri2, factory, renderersFactory, (DrmSessionManager<FrameworkMediaCrypto>) null, DEFAULT_TRACK_SELECTOR_PARAMETERS);
    }

    public static DownloadHelper forDash(Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, DefaultTrackSelector.Parameters parameters) {
        return new DownloadHelper(DownloadRequest.TYPE_DASH, uri2, (String) null, DASH_FACTORY.createMediaSource(uri2, factory, (List<StreamKey>) null), parameters, Util.getRendererCapabilities(renderersFactory, drmSessionManager));
    }

    public static DownloadHelper forHls(Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forHls(uri2, factory, renderersFactory, (DrmSessionManager<FrameworkMediaCrypto>) null, DEFAULT_TRACK_SELECTOR_PARAMETERS);
    }

    public static DownloadHelper forHls(Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, DefaultTrackSelector.Parameters parameters) {
        return new DownloadHelper(DownloadRequest.TYPE_HLS, uri2, (String) null, HLS_FACTORY.createMediaSource(uri2, factory, (List<StreamKey>) null), parameters, Util.getRendererCapabilities(renderersFactory, drmSessionManager));
    }

    public static DownloadHelper forSmoothStreaming(Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory) {
        return forSmoothStreaming(uri2, factory, renderersFactory, (DrmSessionManager<FrameworkMediaCrypto>) null, DEFAULT_TRACK_SELECTOR_PARAMETERS);
    }

    public static DownloadHelper forSmoothStreaming(Uri uri2, DataSource.Factory factory, RenderersFactory renderersFactory, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, DefaultTrackSelector.Parameters parameters) {
        return new DownloadHelper(DownloadRequest.TYPE_SS, uri2, (String) null, SS_FACTORY.createMediaSource(uri2, factory, (List<StreamKey>) null), parameters, Util.getRendererCapabilities(renderersFactory, drmSessionManager));
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0079  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.source.MediaSource createMediaSource(com.google.android.exoplayer2.offline.DownloadRequest r6, com.google.android.exoplayer2.upstream.DataSource.Factory r7) {
        /*
            java.lang.String r0 = r6.type
            int r1 = r0.hashCode()
            r2 = 3680(0xe60, float:5.157E-42)
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == r2) goto L_0x003b
            r2 = 103407(0x193ef, float:1.44904E-40)
            if (r1 == r2) goto L_0x0031
            r2 = 3075986(0x2eef92, float:4.310374E-39)
            if (r1 == r2) goto L_0x0027
            r2 = 1131547531(0x43720b8b, float:242.04509)
            if (r1 == r2) goto L_0x001d
            goto L_0x0045
        L_0x001d:
            java.lang.String r1 = "progressive"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0045
            r0 = 3
            goto L_0x0046
        L_0x0027:
            java.lang.String r1 = "dash"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0045
            r0 = 0
            goto L_0x0046
        L_0x0031:
            java.lang.String r1 = "hls"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0045
            r0 = 2
            goto L_0x0046
        L_0x003b:
            java.lang.String r1 = "ss"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0045
            r0 = 1
            goto L_0x0046
        L_0x0045:
            r0 = -1
        L_0x0046:
            if (r0 == 0) goto L_0x0079
            if (r0 == r5) goto L_0x0076
            if (r0 == r4) goto L_0x0073
            if (r0 != r3) goto L_0x005a
            com.google.android.exoplayer2.source.ProgressiveMediaSource$Factory r0 = new com.google.android.exoplayer2.source.ProgressiveMediaSource$Factory
            r0.<init>(r7)
            android.net.Uri r6 = r6.uri
            com.google.android.exoplayer2.source.ProgressiveMediaSource r6 = r0.createMediaSource((android.net.Uri) r6)
            return r6
        L_0x005a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Unsupported type: "
            r0.append(r1)
            java.lang.String r6 = r6.type
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            r7.<init>(r6)
            throw r7
        L_0x0073:
            com.google.android.exoplayer2.offline.DownloadHelper$MediaSourceFactory r0 = HLS_FACTORY
            goto L_0x007b
        L_0x0076:
            com.google.android.exoplayer2.offline.DownloadHelper$MediaSourceFactory r0 = SS_FACTORY
            goto L_0x007b
        L_0x0079:
            com.google.android.exoplayer2.offline.DownloadHelper$MediaSourceFactory r0 = DASH_FACTORY
        L_0x007b:
            android.net.Uri r1 = r6.uri
            java.util.List<com.google.android.exoplayer2.offline.StreamKey> r6 = r6.streamKeys
            com.google.android.exoplayer2.source.MediaSource r6 = r0.createMediaSource(r1, r7, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.DownloadHelper.createMediaSource(com.google.android.exoplayer2.offline.DownloadRequest, com.google.android.exoplayer2.upstream.DataSource$Factory):com.google.android.exoplayer2.source.MediaSource");
    }

    public DownloadHelper(String str, Uri uri2, @Nullable String str2, @Nullable MediaSource mediaSource2, DefaultTrackSelector.Parameters parameters, RendererCapabilities[] rendererCapabilitiesArr) {
        this.downloadType = str;
        this.uri = uri2;
        this.cacheKey = str2;
        this.mediaSource = mediaSource2;
        this.rendererCapabilities = rendererCapabilitiesArr;
        this.scratchSet = new SparseIntArray();
        this.trackSelector.setParameters(parameters);
        this.trackSelector.init($$Lambda$DownloadHelper$7Zk9CqspX3ZiYWCChYkf8AiTY.INSTANCE, new DummyBandwidthMeter());
        this.callbackHandler = new Handler(Util.getLooper());
    }

    public void prepare(Callback callback2) {
        Assertions.checkState(this.callback == null);
        this.callback = callback2;
        MediaSource mediaSource2 = this.mediaSource;
        if (mediaSource2 != null) {
            this.mediaPreparer = new MediaPreparer(mediaSource2, this);
        } else {
            this.callbackHandler.post(new Runnable(callback2) {
                private final /* synthetic */ DownloadHelper.Callback f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    DownloadHelper.this.lambda$prepare$1$DownloadHelper(this.f$1);
                }
            });
        }
    }

    public /* synthetic */ void lambda$prepare$1$DownloadHelper(Callback callback2) {
        callback2.onPrepared(this);
    }

    public void release() {
        MediaPreparer mediaPreparer2 = this.mediaPreparer;
        if (mediaPreparer2 != null) {
            mediaPreparer2.release();
        }
    }

    @Nullable
    public Object getManifest() {
        if (this.mediaSource == null) {
            return null;
        }
        assertPreparedWithMedia();
        return this.mediaPreparer.manifest;
    }

    public int getPeriodCount() {
        if (this.mediaSource == null) {
            return 0;
        }
        assertPreparedWithMedia();
        return this.trackGroupArrays.length;
    }

    public TrackGroupArray getTrackGroups(int i) {
        assertPreparedWithMedia();
        return this.trackGroupArrays[i];
    }

    public MappingTrackSelector.MappedTrackInfo getMappedTrackInfo(int i) {
        assertPreparedWithMedia();
        return this.mappedTrackInfos[i];
    }

    public List<TrackSelection> getTrackSelections(int i, int i2) {
        assertPreparedWithMedia();
        return this.immutableTrackSelectionsByPeriodAndRenderer[i][i2];
    }

    public void clearTrackSelections(int i) {
        assertPreparedWithMedia();
        for (int i2 = 0; i2 < this.rendererCapabilities.length; i2++) {
            this.trackSelectionsByPeriodAndRenderer[i][i2].clear();
        }
    }

    public void replaceTrackSelections(int i, DefaultTrackSelector.Parameters parameters) {
        clearTrackSelections(i);
        addTrackSelection(i, parameters);
    }

    public void addTrackSelection(int i, DefaultTrackSelector.Parameters parameters) {
        assertPreparedWithMedia();
        this.trackSelector.setParameters(parameters);
        runTrackSelection(i);
    }

    public void addAudioLanguagesToSelection(String... strArr) {
        assertPreparedWithMedia();
        for (int i = 0; i < this.mappedTrackInfos.length; i++) {
            DefaultTrackSelector.ParametersBuilder buildUpon = DEFAULT_TRACK_SELECTOR_PARAMETERS.buildUpon();
            MappingTrackSelector.MappedTrackInfo mappedTrackInfo = this.mappedTrackInfos[i];
            int rendererCount = mappedTrackInfo.getRendererCount();
            for (int i2 = 0; i2 < rendererCount; i2++) {
                if (mappedTrackInfo.getRendererType(i2) != 1) {
                    buildUpon.setRendererDisabled(i2, true);
                }
            }
            for (String preferredAudioLanguage : strArr) {
                buildUpon.setPreferredAudioLanguage(preferredAudioLanguage);
                addTrackSelection(i, buildUpon.build());
            }
        }
    }

    public void addTextLanguagesToSelection(boolean z, String... strArr) {
        assertPreparedWithMedia();
        for (int i = 0; i < this.mappedTrackInfos.length; i++) {
            DefaultTrackSelector.ParametersBuilder buildUpon = DEFAULT_TRACK_SELECTOR_PARAMETERS.buildUpon();
            MappingTrackSelector.MappedTrackInfo mappedTrackInfo = this.mappedTrackInfos[i];
            int rendererCount = mappedTrackInfo.getRendererCount();
            for (int i2 = 0; i2 < rendererCount; i2++) {
                if (mappedTrackInfo.getRendererType(i2) != 3) {
                    buildUpon.setRendererDisabled(i2, true);
                }
            }
            buildUpon.setSelectUndeterminedTextLanguage(z);
            for (String preferredTextLanguage : strArr) {
                buildUpon.setPreferredTextLanguage(preferredTextLanguage);
                addTrackSelection(i, buildUpon.build());
            }
        }
    }

    public void addTrackSelectionForSingleRenderer(int i, int i2, DefaultTrackSelector.Parameters parameters, List<DefaultTrackSelector.SelectionOverride> list) {
        assertPreparedWithMedia();
        DefaultTrackSelector.ParametersBuilder buildUpon = parameters.buildUpon();
        int i3 = 0;
        while (i3 < this.mappedTrackInfos[i].getRendererCount()) {
            buildUpon.setRendererDisabled(i3, i3 != i2);
            i3++;
        }
        if (list.isEmpty()) {
            addTrackSelection(i, buildUpon.build());
            return;
        }
        TrackGroupArray trackGroups = this.mappedTrackInfos[i].getTrackGroups(i2);
        for (int i4 = 0; i4 < list.size(); i4++) {
            buildUpon.setSelectionOverride(i2, trackGroups, list.get(i4));
            addTrackSelection(i, buildUpon.build());
        }
    }

    public DownloadRequest getDownloadRequest(@Nullable byte[] bArr) {
        return getDownloadRequest(this.uri.toString(), bArr);
    }

    public DownloadRequest getDownloadRequest(String str, @Nullable byte[] bArr) {
        if (this.mediaSource == null) {
            return new DownloadRequest(str, this.downloadType, this.uri, Collections.emptyList(), this.cacheKey, bArr);
        }
        assertPreparedWithMedia();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int length = this.trackSelectionsByPeriodAndRenderer.length;
        for (int i = 0; i < length; i++) {
            arrayList2.clear();
            for (List<TrackSelection> addAll : this.trackSelectionsByPeriodAndRenderer[i]) {
                arrayList2.addAll(addAll);
            }
            arrayList.addAll(this.mediaPreparer.mediaPeriods[i].getStreamKeys(arrayList2));
        }
        return new DownloadRequest(str, this.downloadType, this.uri, arrayList, this.cacheKey, bArr);
    }

    /* access modifiers changed from: private */
    public void onMediaPrepared() {
        Assertions.checkNotNull(this.mediaPreparer);
        Assertions.checkNotNull(this.mediaPreparer.mediaPeriods);
        Assertions.checkNotNull(this.mediaPreparer.timeline);
        int length = this.mediaPreparer.mediaPeriods.length;
        int length2 = this.rendererCapabilities.length;
        this.trackSelectionsByPeriodAndRenderer = (List[][]) Array.newInstance(List.class, new int[]{length, length2});
        this.immutableTrackSelectionsByPeriodAndRenderer = (List[][]) Array.newInstance(List.class, new int[]{length, length2});
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length2; i2++) {
                this.trackSelectionsByPeriodAndRenderer[i][i2] = new ArrayList();
                this.immutableTrackSelectionsByPeriodAndRenderer[i][i2] = Collections.unmodifiableList(this.trackSelectionsByPeriodAndRenderer[i][i2]);
            }
        }
        this.trackGroupArrays = new TrackGroupArray[length];
        this.mappedTrackInfos = new MappingTrackSelector.MappedTrackInfo[length];
        for (int i3 = 0; i3 < length; i3++) {
            this.trackGroupArrays[i3] = this.mediaPreparer.mediaPeriods[i3].getTrackGroups();
            this.trackSelector.onSelectionActivated(runTrackSelection(i3).info);
            this.mappedTrackInfos[i3] = (MappingTrackSelector.MappedTrackInfo) Assertions.checkNotNull(this.trackSelector.getCurrentMappedTrackInfo());
        }
        setPreparedWithMedia();
        ((Handler) Assertions.checkNotNull(this.callbackHandler)).post(new Runnable() {
            public final void run() {
                DownloadHelper.this.lambda$onMediaPrepared$2$DownloadHelper();
            }
        });
    }

    public /* synthetic */ void lambda$onMediaPrepared$2$DownloadHelper() {
        ((Callback) Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    /* access modifiers changed from: private */
    public void onMediaPreparationFailed(IOException iOException) {
        ((Handler) Assertions.checkNotNull(this.callbackHandler)).post(new Runnable(iOException) {
            private final /* synthetic */ IOException f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                DownloadHelper.this.lambda$onMediaPreparationFailed$3$DownloadHelper(this.f$1);
            }
        });
    }

    public /* synthetic */ void lambda$onMediaPreparationFailed$3$DownloadHelper(IOException iOException) {
        ((Callback) Assertions.checkNotNull(this.callback)).onPrepareError(this, iOException);
    }

    @RequiresNonNull({"trackGroupArrays", "mappedTrackInfos", "trackSelectionsByPeriodAndRenderer", "immutableTrackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline", "mediaPreparer.mediaPeriods"})
    private void setPreparedWithMedia() {
        this.isPreparedWithMedia = true;
    }

    @EnsuresNonNull({"trackGroupArrays", "mappedTrackInfos", "trackSelectionsByPeriodAndRenderer", "immutableTrackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline", "mediaPreparer.mediaPeriods"})
    private void assertPreparedWithMedia() {
        Assertions.checkState(this.isPreparedWithMedia);
    }

    @RequiresNonNull({"trackGroupArrays", "trackSelectionsByPeriodAndRenderer", "mediaPreparer", "mediaPreparer.timeline"})
    private TrackSelectorResult runTrackSelection(int i) {
        boolean z;
        try {
            TrackSelectorResult selectTracks = this.trackSelector.selectTracks(this.rendererCapabilities, this.trackGroupArrays[i], new MediaSource.MediaPeriodId(this.mediaPreparer.timeline.getUidOfPeriod(i)), this.mediaPreparer.timeline);
            for (int i2 = 0; i2 < selectTracks.length; i2++) {
                TrackSelection trackSelection = selectTracks.selections.get(i2);
                if (trackSelection != null) {
                    List<TrackSelection> list = this.trackSelectionsByPeriodAndRenderer[i][i2];
                    int i3 = 0;
                    while (true) {
                        if (i3 >= list.size()) {
                            z = false;
                            break;
                        }
                        TrackSelection trackSelection2 = list.get(i3);
                        if (trackSelection2.getTrackGroup() == trackSelection.getTrackGroup()) {
                            this.scratchSet.clear();
                            for (int i4 = 0; i4 < trackSelection2.length(); i4++) {
                                this.scratchSet.put(trackSelection2.getIndexInTrackGroup(i4), 0);
                            }
                            for (int i5 = 0; i5 < trackSelection.length(); i5++) {
                                this.scratchSet.put(trackSelection.getIndexInTrackGroup(i5), 0);
                            }
                            int[] iArr = new int[this.scratchSet.size()];
                            for (int i6 = 0; i6 < this.scratchSet.size(); i6++) {
                                iArr[i6] = this.scratchSet.keyAt(i6);
                            }
                            list.set(i3, new DownloadTrackSelection(trackSelection2.getTrackGroup(), iArr));
                            z = true;
                        } else {
                            i3++;
                        }
                    }
                    if (!z) {
                        list.add(trackSelection);
                    }
                }
            }
            return selectTracks;
        } catch (ExoPlaybackException e) {
            throw new UnsupportedOperationException(e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        throw new java.lang.IllegalStateException(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        r3 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002c A[ExcHandler: NoSuchMethodException | SecurityException (r7v2 'e' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0001] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.offline.DownloadHelper.MediaSourceFactory getMediaSourceFactory(java.lang.String r7) {
        /*
            r0 = 0
            java.lang.Class r7 = java.lang.Class.forName(r7)     // Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, SecurityException -> 0x002c }
            r1 = 1
            java.lang.Class[] r2 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, SecurityException -> 0x002c }
            java.lang.Class<com.google.android.exoplayer2.upstream.DataSource$Factory> r3 = com.google.android.exoplayer2.upstream.DataSource.Factory.class
            r4 = 0
            r2[r4] = r3     // Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, SecurityException -> 0x002c }
            java.lang.reflect.Constructor r2 = r7.getConstructor(r2)     // Catch:{ ClassNotFoundException -> 0x0035, NoSuchMethodException -> 0x002e, SecurityException -> 0x002c }
            java.lang.String r3 = "setStreamKeys"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x002a, NoSuchMethodException -> 0x002e, SecurityException -> 0x002c }
            java.lang.Class<java.util.List> r6 = java.util.List.class
            r5[r4] = r6     // Catch:{ ClassNotFoundException -> 0x002a, NoSuchMethodException -> 0x002e, SecurityException -> 0x002c }
            java.lang.reflect.Method r3 = r7.getMethod(r3, r5)     // Catch:{ ClassNotFoundException -> 0x002a, NoSuchMethodException -> 0x002e, SecurityException -> 0x002c }
            java.lang.String r5 = "createMediaSource"
            java.lang.Class[] r1 = new java.lang.Class[r1]     // Catch:{ ClassNotFoundException -> 0x0037, NoSuchMethodException -> 0x002e, SecurityException -> 0x002c }
            java.lang.Class<android.net.Uri> r6 = android.net.Uri.class
            r1[r4] = r6     // Catch:{ ClassNotFoundException -> 0x0037, NoSuchMethodException -> 0x002e, SecurityException -> 0x002c }
            java.lang.reflect.Method r0 = r7.getMethod(r5, r1)     // Catch:{ ClassNotFoundException -> 0x0037, NoSuchMethodException -> 0x002e, SecurityException -> 0x002c }
            goto L_0x0037
        L_0x002a:
            r3 = r0
            goto L_0x0037
        L_0x002c:
            r7 = move-exception
            goto L_0x002f
        L_0x002e:
            r7 = move-exception
        L_0x002f:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>(r7)
            throw r0
        L_0x0035:
            r2 = r0
            r3 = r2
        L_0x0037:
            com.google.android.exoplayer2.offline.DownloadHelper$MediaSourceFactory r7 = new com.google.android.exoplayer2.offline.DownloadHelper$MediaSourceFactory
            r7.<init>(r2, r3, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.DownloadHelper.getMediaSourceFactory(java.lang.String):com.google.android.exoplayer2.offline.DownloadHelper$MediaSourceFactory");
    }

    private static final class MediaSourceFactory {
        @Nullable
        private final Constructor<?> constructor;
        @Nullable
        private final Method createMethod;
        @Nullable
        private final Method setStreamKeysMethod;

        public MediaSourceFactory(@Nullable Constructor<?> constructor2, @Nullable Method method, @Nullable Method method2) {
            this.constructor = constructor2;
            this.setStreamKeysMethod = method;
            this.createMethod = method2;
        }

        /* access modifiers changed from: private */
        public MediaSource createMediaSource(Uri uri, DataSource.Factory factory, @Nullable List<StreamKey> list) {
            Constructor<?> constructor2 = this.constructor;
            if (constructor2 == null || this.setStreamKeysMethod == null || this.createMethod == null) {
                throw new IllegalStateException("Module missing to create media source.");
            }
            try {
                Object newInstance = constructor2.newInstance(new Object[]{factory});
                if (list != null) {
                    this.setStreamKeysMethod.invoke(newInstance, new Object[]{list});
                }
                return (MediaSource) Assertions.checkNotNull(this.createMethod.invoke(newInstance, new Object[]{uri}));
            } catch (Exception e) {
                throw new IllegalStateException("Failed to instantiate media source.", e);
            }
        }
    }

    private static final class MediaPreparer implements MediaSource.SourceInfoRefreshListener, MediaPeriod.Callback, Handler.Callback {
        private static final int DOWNLOAD_HELPER_CALLBACK_MESSAGE_FAILED = 1;
        private static final int DOWNLOAD_HELPER_CALLBACK_MESSAGE_PREPARED = 0;
        private static final int MESSAGE_CHECK_FOR_FAILURE = 1;
        private static final int MESSAGE_CONTINUE_LOADING = 2;
        private static final int MESSAGE_PREPARE_SOURCE = 0;
        private static final int MESSAGE_RELEASE = 3;
        private final Allocator allocator = new DefaultAllocator(true, 65536);
        private final DownloadHelper downloadHelper;
        private final Handler downloadHelperHandler = Util.createHandler(new Handler.Callback() {
            public final boolean handleMessage(Message message) {
                return DownloadHelper.MediaPreparer.this.handleDownloadHelperCallbackMessage(message);
            }
        });
        @Nullable
        public Object manifest;
        public MediaPeriod[] mediaPeriods;
        private final MediaSource mediaSource;
        private final Handler mediaSourceHandler;
        private final HandlerThread mediaSourceThread = new HandlerThread("DownloadHelper");
        private final ArrayList<MediaPeriod> pendingMediaPeriods = new ArrayList<>();
        private boolean released;
        public Timeline timeline;

        public MediaPreparer(MediaSource mediaSource2, DownloadHelper downloadHelper2) {
            this.mediaSource = mediaSource2;
            this.downloadHelper = downloadHelper2;
            this.mediaSourceThread.start();
            this.mediaSourceHandler = Util.createHandler(this.mediaSourceThread.getLooper(), this);
            this.mediaSourceHandler.sendEmptyMessage(0);
        }

        public void release() {
            if (!this.released) {
                this.released = true;
                this.mediaSourceHandler.sendEmptyMessage(3);
            }
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i != 0) {
                int i2 = 0;
                if (i == 1) {
                    try {
                        if (this.mediaPeriods == null) {
                            this.mediaSource.maybeThrowSourceInfoRefreshError();
                        } else {
                            while (i2 < this.pendingMediaPeriods.size()) {
                                this.pendingMediaPeriods.get(i2).maybeThrowPrepareError();
                                i2++;
                            }
                        }
                        this.mediaSourceHandler.sendEmptyMessageDelayed(1, 100);
                    } catch (IOException e) {
                        this.downloadHelperHandler.obtainMessage(1, e).sendToTarget();
                    }
                    return true;
                } else if (i == 2) {
                    MediaPeriod mediaPeriod = (MediaPeriod) message.obj;
                    if (this.pendingMediaPeriods.contains(mediaPeriod)) {
                        mediaPeriod.continueLoading(0);
                    }
                    return true;
                } else if (i != 3) {
                    return false;
                } else {
                    MediaPeriod[] mediaPeriodArr = this.mediaPeriods;
                    if (mediaPeriodArr != null) {
                        int length = mediaPeriodArr.length;
                        while (i2 < length) {
                            this.mediaSource.releasePeriod(mediaPeriodArr[i2]);
                            i2++;
                        }
                    }
                    this.mediaSource.releaseSource(this);
                    this.mediaSourceHandler.removeCallbacksAndMessages((Object) null);
                    this.mediaSourceThread.quit();
                    return true;
                }
            } else {
                this.mediaSource.prepareSource(this, (TransferListener) null);
                this.mediaSourceHandler.sendEmptyMessage(1);
                return true;
            }
        }

        public void onSourceInfoRefreshed(MediaSource mediaSource2, Timeline timeline2, @Nullable Object obj) {
            MediaPeriod[] mediaPeriodArr;
            if (this.timeline == null) {
                this.timeline = timeline2;
                this.manifest = obj;
                this.mediaPeriods = new MediaPeriod[timeline2.getPeriodCount()];
                int i = 0;
                while (true) {
                    mediaPeriodArr = this.mediaPeriods;
                    if (i >= mediaPeriodArr.length) {
                        break;
                    }
                    MediaPeriod createPeriod = this.mediaSource.createPeriod(new MediaSource.MediaPeriodId(timeline2.getUidOfPeriod(i)), this.allocator, 0);
                    this.mediaPeriods[i] = createPeriod;
                    this.pendingMediaPeriods.add(createPeriod);
                    i++;
                }
                for (MediaPeriod prepare : mediaPeriodArr) {
                    prepare.prepare(this, 0);
                }
            }
        }

        public void onPrepared(MediaPeriod mediaPeriod) {
            this.pendingMediaPeriods.remove(mediaPeriod);
            if (this.pendingMediaPeriods.isEmpty()) {
                this.mediaSourceHandler.removeMessages(1);
                this.downloadHelperHandler.sendEmptyMessage(0);
            }
        }

        public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
            if (this.pendingMediaPeriods.contains(mediaPeriod)) {
                this.mediaSourceHandler.obtainMessage(2, mediaPeriod).sendToTarget();
            }
        }

        /* access modifiers changed from: private */
        public boolean handleDownloadHelperCallbackMessage(Message message) {
            if (this.released) {
                return false;
            }
            int i = message.what;
            if (i == 0) {
                this.downloadHelper.onMediaPrepared();
                return true;
            } else if (i != 1) {
                return false;
            } else {
                release();
                this.downloadHelper.onMediaPreparationFailed((IOException) Util.castNonNull(message.obj));
                return true;
            }
        }
    }

    private static final class DownloadTrackSelection extends BaseTrackSelection {
        public int getSelectedIndex() {
            return 0;
        }

        @Nullable
        public Object getSelectionData() {
            return null;
        }

        public int getSelectionReason() {
            return 0;
        }

        private static final class Factory implements TrackSelection.Factory {
            @Deprecated
            public /* synthetic */ TrackSelection createTrackSelection(TrackGroup trackGroup, BandwidthMeter bandwidthMeter, int... iArr) {
                return TrackSelection.Factory.CC.$default$createTrackSelection(this, trackGroup, bandwidthMeter, iArr);
            }

            private Factory() {
            }

            public TrackSelection[] createTrackSelections(TrackSelection.Definition[] definitionArr, BandwidthMeter bandwidthMeter) {
                TrackSelection[] trackSelectionArr = new TrackSelection[definitionArr.length];
                for (int i = 0; i < definitionArr.length; i++) {
                    trackSelectionArr[i] = definitionArr[i] == null ? null : new DownloadTrackSelection(definitionArr[i].group, definitionArr[i].tracks);
                }
                return trackSelectionArr;
            }
        }

        public DownloadTrackSelection(TrackGroup trackGroup, int[] iArr) {
            super(trackGroup, iArr);
        }
    }

    private static final class DummyBandwidthMeter implements BandwidthMeter {
        public void addEventListener(Handler handler, BandwidthMeter.EventListener eventListener) {
        }

        public long getBitrateEstimate() {
            return 0;
        }

        @Nullable
        public TransferListener getTransferListener() {
            return null;
        }

        public void removeEventListener(BandwidthMeter.EventListener eventListener) {
        }

        private DummyBandwidthMeter() {
        }
    }
}
