package com.bumptech.glide.load.engine;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.p003os.TraceCompat;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.pool.FactoryPools;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DecodeJob<R> implements DataFetcherGenerator.FetcherReadyCallback, Runnable, Comparable<DecodeJob<?>>, FactoryPools.Poolable {
    private static final String TAG = "DecodeJob";
    private Callback<R> callback;
    private Key currentAttemptingKey;
    private Object currentData;
    private DataSource currentDataSource;
    private DataFetcher<?> currentFetcher;
    private volatile DataFetcherGenerator currentGenerator;
    Key currentSourceKey;
    private Thread currentThread;
    final DecodeHelper<R> decodeHelper = new DecodeHelper<>();
    final DeferredEncodeManager<?> deferredEncodeManager = new DeferredEncodeManager<>();
    private final DiskCacheProvider diskCacheProvider;
    DiskCacheStrategy diskCacheStrategy;
    /* access modifiers changed from: private */
    public GlideContext glideContext;
    int height;
    private volatile boolean isCallbackNotified;
    private volatile boolean isCancelled;
    private EngineKey loadKey;
    private boolean onlyRetrieveFromCache;
    Options options;
    private int order;
    private final Pools.Pool<DecodeJob<?>> pool;
    private Priority priority;
    private final ReleaseManager releaseManager = new ReleaseManager();
    private RunReason runReason;
    Key signature;
    private Stage stage;
    private long startFetchTime;
    private final StateVerifier stateVerifier = StateVerifier.newInstance();
    private final List<Throwable> throwables = new ArrayList();
    int width;

    interface Callback<R> {
        void onLoadFailed(GlideException glideException);

        void onResourceReady(Resource<R> resource, DataSource dataSource);

        void reschedule(DecodeJob<?> decodeJob);
    }

    interface DiskCacheProvider {
        DiskCache getDiskCache();
    }

    private enum RunReason {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    private enum Stage {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    DecodeJob(DiskCacheProvider diskCacheProvider2, Pools.Pool<DecodeJob<?>> pool2) {
        this.diskCacheProvider = diskCacheProvider2;
        this.pool = pool2;
    }

    /* access modifiers changed from: package-private */
    public DecodeJob<R> init(GlideContext glideContext2, Object obj, EngineKey engineKey, Key key, int i, int i2, Class<?> cls, Class<R> cls2, Priority priority2, DiskCacheStrategy diskCacheStrategy2, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options2, Callback<R> callback2, int i3) {
        this.decodeHelper.init(glideContext2, obj, key, i, i2, diskCacheStrategy2, cls, cls2, priority2, options2, map, z, z2, this.diskCacheProvider);
        this.glideContext = glideContext2;
        this.signature = key;
        this.priority = priority2;
        this.loadKey = engineKey;
        this.width = i;
        this.height = i2;
        this.diskCacheStrategy = diskCacheStrategy2;
        this.onlyRetrieveFromCache = z3;
        this.options = options2;
        this.callback = callback2;
        this.order = i3;
        this.runReason = RunReason.INITIALIZE;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean willDecodeFromCache() {
        Stage nextStage = getNextStage(Stage.INITIALIZE);
        return nextStage == Stage.RESOURCE_CACHE || nextStage == Stage.DATA_CACHE;
    }

    /* access modifiers changed from: package-private */
    public void release(boolean z) {
        if (this.releaseManager.release(z)) {
            releaseInternal();
        }
    }

    private void onEncodeComplete() {
        if (this.releaseManager.onEncodeComplete()) {
            releaseInternal();
        }
    }

    private void onLoadFailed() {
        if (this.releaseManager.onFailed()) {
            releaseInternal();
        }
    }

    private void releaseInternal() {
        this.releaseManager.reset();
        this.deferredEncodeManager.clear();
        this.decodeHelper.clear();
        this.isCallbackNotified = false;
        this.glideContext = null;
        this.signature = null;
        this.options = null;
        this.priority = null;
        this.loadKey = null;
        this.callback = null;
        this.stage = null;
        this.currentGenerator = null;
        this.currentThread = null;
        this.currentSourceKey = null;
        this.currentData = null;
        this.currentDataSource = null;
        this.currentFetcher = null;
        this.startFetchTime = 0;
        this.isCancelled = false;
        this.throwables.clear();
        this.pool.release(this);
    }

    public int compareTo(@NonNull DecodeJob<?> decodeJob) {
        int priority2 = getPriority() - decodeJob.getPriority();
        return priority2 == 0 ? this.order - decodeJob.order : priority2;
    }

    private int getPriority() {
        return this.priority.ordinal();
    }

    public void cancel() {
        this.isCancelled = true;
        DataFetcherGenerator dataFetcherGenerator = this.currentGenerator;
        if (dataFetcherGenerator != null) {
            dataFetcherGenerator.cancel();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001c, code lost:
        if (r1 != null) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r5 = this;
            java.lang.String r0 = "DecodeJob"
            java.lang.String r1 = "DecodeJob#run"
            androidx.core.p003os.TraceCompat.beginSection(r1)
            com.bumptech.glide.load.data.DataFetcher<?> r1 = r5.currentFetcher
            boolean r2 = r5.isCancelled     // Catch:{ Throwable -> 0x0027 }
            if (r2 == 0) goto L_0x0019
            r5.notifyFailed()     // Catch:{ Throwable -> 0x0027 }
            if (r1 == 0) goto L_0x0015
            r1.cleanup()
        L_0x0015:
            androidx.core.p003os.TraceCompat.endSection()
            return
        L_0x0019:
            r5.runWrapped()     // Catch:{ Throwable -> 0x0027 }
            if (r1 == 0) goto L_0x0021
        L_0x001e:
            r1.cleanup()
        L_0x0021:
            androidx.core.p003os.TraceCompat.endSection()
            goto L_0x0064
        L_0x0025:
            r0 = move-exception
            goto L_0x0066
        L_0x0027:
            r2 = move-exception
            r3 = 3
            boolean r3 = android.util.Log.isLoggable(r0, r3)     // Catch:{ all -> 0x0025 }
            if (r3 == 0) goto L_0x004f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0025 }
            r3.<init>()     // Catch:{ all -> 0x0025 }
            java.lang.String r4 = "DecodeJob threw unexpectedly, isCancelled: "
            r3.append(r4)     // Catch:{ all -> 0x0025 }
            boolean r4 = r5.isCancelled     // Catch:{ all -> 0x0025 }
            r3.append(r4)     // Catch:{ all -> 0x0025 }
            java.lang.String r4 = ", stage: "
            r3.append(r4)     // Catch:{ all -> 0x0025 }
            com.bumptech.glide.load.engine.DecodeJob$Stage r4 = r5.stage     // Catch:{ all -> 0x0025 }
            r3.append(r4)     // Catch:{ all -> 0x0025 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0025 }
            android.util.Log.d(r0, r3, r2)     // Catch:{ all -> 0x0025 }
        L_0x004f:
            com.bumptech.glide.load.engine.DecodeJob$Stage r0 = r5.stage     // Catch:{ all -> 0x0025 }
            com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.ENCODE     // Catch:{ all -> 0x0025 }
            if (r0 == r3) goto L_0x005d
            java.util.List<java.lang.Throwable> r0 = r5.throwables     // Catch:{ all -> 0x0025 }
            r0.add(r2)     // Catch:{ all -> 0x0025 }
            r5.notifyFailed()     // Catch:{ all -> 0x0025 }
        L_0x005d:
            boolean r0 = r5.isCancelled     // Catch:{ all -> 0x0025 }
            if (r0 == 0) goto L_0x0065
            if (r1 == 0) goto L_0x0021
            goto L_0x001e
        L_0x0064:
            return
        L_0x0065:
            throw r2     // Catch:{ all -> 0x0025 }
        L_0x0066:
            if (r1 == 0) goto L_0x006b
            r1.cleanup()
        L_0x006b:
            androidx.core.p003os.TraceCompat.endSection()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.run():void");
    }

    private void runWrapped() {
        int i = C10351.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason[this.runReason.ordinal()];
        if (i == 1) {
            this.stage = getNextStage(Stage.INITIALIZE);
            this.currentGenerator = getNextGenerator();
            runGenerators();
        } else if (i == 2) {
            runGenerators();
        } else if (i == 3) {
            decodeFromRetrievedData();
        } else {
            throw new IllegalStateException("Unrecognized run reason: " + this.runReason);
        }
    }

    /* renamed from: com.bumptech.glide.load.engine.DecodeJob$1 */
    static /* synthetic */ class C10351 {
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason = new int[RunReason.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage = new int[Stage.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|5|6|7|9|10|11|12|13|14|15|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0053 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005d */
        static {
            /*
                com.bumptech.glide.load.engine.DecodeJob$Stage[] r0 = com.bumptech.glide.load.engine.DecodeJob.Stage.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage = r0
                r0 = 1
                int[] r1 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r2 = com.bumptech.glide.load.engine.DecodeJob.Stage.RESOURCE_CACHE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage     // Catch:{ NoSuchFieldError -> 0x001f }
                com.bumptech.glide.load.engine.DecodeJob$Stage r3 = com.bumptech.glide.load.engine.DecodeJob.Stage.DATA_CACHE     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage     // Catch:{ NoSuchFieldError -> 0x002a }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.SOURCE     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r3 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.FINISHED     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r3 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.bumptech.glide.load.engine.DecodeJob$Stage r4 = com.bumptech.glide.load.engine.DecodeJob.Stage.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                com.bumptech.glide.load.engine.DecodeJob$RunReason[] r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason = r3
                int[] r3 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason     // Catch:{ NoSuchFieldError -> 0x0053 }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r4 = com.bumptech.glide.load.engine.DecodeJob.RunReason.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0053 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0053 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0053 }
            L_0x0053:
                int[] r0 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason     // Catch:{ NoSuchFieldError -> 0x005d }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r3 = com.bumptech.glide.load.engine.DecodeJob.RunReason.SWITCH_TO_SOURCE_SERVICE     // Catch:{ NoSuchFieldError -> 0x005d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                int[] r0 = $SwitchMap$com$bumptech$glide$load$engine$DecodeJob$RunReason     // Catch:{ NoSuchFieldError -> 0x0067 }
                com.bumptech.glide.load.engine.DecodeJob$RunReason r1 = com.bumptech.glide.load.engine.DecodeJob.RunReason.DECODE_DATA     // Catch:{ NoSuchFieldError -> 0x0067 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0067 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0067 }
            L_0x0067:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.C10351.<clinit>():void");
        }
    }

    private DataFetcherGenerator getNextGenerator() {
        int i = C10351.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[this.stage.ordinal()];
        if (i == 1) {
            return new ResourceCacheGenerator(this.decodeHelper, this);
        }
        if (i == 2) {
            return new DataCacheGenerator(this.decodeHelper, this);
        }
        if (i == 3) {
            return new SourceGenerator(this.decodeHelper, this);
        }
        if (i == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.stage);
    }

    private void runGenerators() {
        this.currentThread = Thread.currentThread();
        this.startFetchTime = LogTime.getLogTime();
        boolean z = false;
        while (!this.isCancelled && this.currentGenerator != null && !(z = this.currentGenerator.startNext())) {
            this.stage = getNextStage(this.stage);
            this.currentGenerator = getNextGenerator();
            if (this.stage == Stage.SOURCE) {
                reschedule();
                return;
            }
        }
        if ((this.stage == Stage.FINISHED || this.isCancelled) && !z) {
            notifyFailed();
        }
    }

    private void notifyFailed() {
        setNotifiedOrThrow();
        this.callback.onLoadFailed(new GlideException("Failed to load resource", (List<Throwable>) new ArrayList(this.throwables)));
        onLoadFailed();
    }

    private void notifyComplete(Resource<R> resource, DataSource dataSource) {
        setNotifiedOrThrow();
        this.callback.onResourceReady(resource, dataSource);
    }

    private void setNotifiedOrThrow() {
        this.stateVerifier.throwIfRecycled();
        if (!this.isCallbackNotified) {
            this.isCallbackNotified = true;
            return;
        }
        throw new IllegalStateException("Already notified");
    }

    private Stage getNextStage(Stage stage2) {
        int i = C10351.$SwitchMap$com$bumptech$glide$load$engine$DecodeJob$Stage[stage2.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return this.onlyRetrieveFromCache ? Stage.FINISHED : Stage.SOURCE;
            }
            if (i == 3 || i == 4) {
                return Stage.FINISHED;
            }
            if (i != 5) {
                throw new IllegalArgumentException("Unrecognized stage: " + stage2);
            } else if (this.diskCacheStrategy.decodeCachedResource()) {
                return Stage.RESOURCE_CACHE;
            } else {
                return getNextStage(Stage.RESOURCE_CACHE);
            }
        } else if (this.diskCacheStrategy.decodeCachedData()) {
            return Stage.DATA_CACHE;
        } else {
            return getNextStage(Stage.DATA_CACHE);
        }
    }

    public void reschedule() {
        this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
        this.callback.reschedule(this);
    }

    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.currentSourceKey = key;
        this.currentData = obj;
        this.currentFetcher = dataFetcher;
        this.currentDataSource = dataSource;
        this.currentAttemptingKey = key2;
        if (Thread.currentThread() != this.currentThread) {
            this.runReason = RunReason.DECODE_DATA;
            this.callback.reschedule(this);
            return;
        }
        TraceCompat.beginSection("DecodeJob.decodeFromRetrievedData");
        try {
            decodeFromRetrievedData();
        } finally {
            TraceCompat.endSection();
        }
    }

    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        dataFetcher.cleanup();
        GlideException glideException = new GlideException("Fetching data failed", (Throwable) exc);
        glideException.setLoggingDetails(key, dataSource, dataFetcher.getDataClass());
        this.throwables.add(glideException);
        if (Thread.currentThread() != this.currentThread) {
            this.runReason = RunReason.SWITCH_TO_SOURCE_SERVICE;
            this.callback.reschedule(this);
            return;
        }
        runGenerators();
    }

    private void decodeFromRetrievedData() {
        if (Log.isLoggable(TAG, 2)) {
            long j = this.startFetchTime;
            logWithTimeAndKey("Retrieved data", j, "data: " + this.currentData + ", cache key: " + this.currentSourceKey + ", fetcher: " + this.currentFetcher);
        }
        Resource<R> resource = null;
        try {
            resource = decodeFromData(this.currentFetcher, this.currentData, this.currentDataSource);
        } catch (GlideException e) {
            e.setLoggingDetails(this.currentAttemptingKey, this.currentDataSource);
            this.throwables.add(e);
        }
        if (resource != null) {
            notifyEncodeAndRelease(resource, this.currentDataSource);
        } else {
            runGenerators();
        }
    }

    private void notifyEncodeAndRelease(Resource<R> resource, DataSource dataSource) {
        if (resource instanceof Initializable) {
            ((Initializable) resource).initialize();
        }
        LockedResource<R> lockedResource = null;
        LockedResource<R> lockedResource2 = resource;
        if (this.deferredEncodeManager.hasResourceToEncode()) {
            LockedResource<R> obtain = LockedResource.obtain(resource);
            lockedResource = obtain;
            lockedResource2 = obtain;
        }
        notifyComplete(lockedResource2, dataSource);
        this.stage = Stage.ENCODE;
        try {
            if (this.deferredEncodeManager.hasResourceToEncode()) {
                this.deferredEncodeManager.encode(this.diskCacheProvider, this.options);
            }
        } finally {
            if (lockedResource != null) {
                lockedResource.unlock();
            }
            onEncodeComplete();
        }
    }

    private <Data> Resource<R> decodeFromData(DataFetcher<?> dataFetcher, Data data, DataSource dataSource) throws GlideException {
        if (data == null) {
            dataFetcher.cleanup();
            return null;
        }
        try {
            long logTime = LogTime.getLogTime();
            Resource<R> decodeFromFetcher = decodeFromFetcher(data, dataSource);
            if (Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Decoded result " + decodeFromFetcher, logTime);
            }
            return decodeFromFetcher;
        } finally {
            dataFetcher.cleanup();
        }
    }

    private <Data> Resource<R> decodeFromFetcher(Data data, DataSource dataSource) throws GlideException {
        return runLoadPath(data, dataSource, this.decodeHelper.getLoadPath(data.getClass()));
    }

    private Options getOptionsWithHardwareConfig(DataSource dataSource) {
        Options options2 = this.options;
        if (Build.VERSION.SDK_INT < 26 || options2.get(Downsampler.ALLOW_HARDWARE_CONFIG) != null) {
            return options2;
        }
        if (dataSource != DataSource.RESOURCE_DISK_CACHE && !this.decodeHelper.isScaleOnlyOrNoTransform()) {
            return options2;
        }
        Options options3 = new Options();
        options3.putAll(this.options);
        options3.set(Downsampler.ALLOW_HARDWARE_CONFIG, true);
        return options3;
    }

    private <Data, ResourceType> Resource<R> runLoadPath(Data data, DataSource dataSource, LoadPath<Data, ResourceType, R> loadPath) throws GlideException {
        Options optionsWithHardwareConfig = getOptionsWithHardwareConfig(dataSource);
        DataRewinder rewinder = this.glideContext.getRegistry().getRewinder(data);
        try {
            return loadPath.load(rewinder, optionsWithHardwareConfig, this.width, this.height, new DecodeCallback(dataSource));
        } finally {
            rewinder.cleanup();
        }
    }

    private void logWithTimeAndKey(String str, long j) {
        logWithTimeAndKey(str, j, (String) null);
    }

    private void logWithTimeAndKey(String str, long j, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(LogTime.getElapsedMillis(j));
        sb.append(", load key: ");
        sb.append(this.loadKey);
        if (str2 != null) {
            str3 = ", " + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
        Log.v(TAG, sb.toString());
    }

    public StateVerifier getVerifier() {
        return this.stateVerifier;
    }

    private final class DecodeCallback<Z> implements DecodePath.DecodeCallback<Z> {
        private final DataSource dataSource;

        DecodeCallback(DataSource dataSource2) {
            this.dataSource = dataSource2;
        }

        /* JADX WARNING: type inference failed for: r12v9, types: [com.bumptech.glide.load.engine.DataCacheKey] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.bumptech.glide.load.engine.Resource<Z> onResourceDecoded(com.bumptech.glide.load.engine.Resource<Z> r12) {
            /*
                r11 = this;
                java.lang.Class r7 = r11.getResourceClass(r12)
                com.bumptech.glide.load.DataSource r0 = r11.dataSource
                com.bumptech.glide.load.DataSource r1 = com.bumptech.glide.load.DataSource.RESOURCE_DISK_CACHE
                r2 = 0
                if (r0 == r1) goto L_0x0028
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.engine.DecodeHelper<R> r0 = r0.decodeHelper
                com.bumptech.glide.load.Transformation r0 = r0.getTransformation(r7)
                com.bumptech.glide.load.engine.DecodeJob r1 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.GlideContext r1 = r1.glideContext
                com.bumptech.glide.load.engine.DecodeJob r3 = com.bumptech.glide.load.engine.DecodeJob.this
                int r3 = r3.width
                com.bumptech.glide.load.engine.DecodeJob r4 = com.bumptech.glide.load.engine.DecodeJob.this
                int r4 = r4.height
                com.bumptech.glide.load.engine.Resource r1 = r0.transform(r1, r12, r3, r4)
                r6 = r0
                r9 = r1
                goto L_0x002a
            L_0x0028:
                r9 = r12
                r6 = r2
            L_0x002a:
                boolean r0 = r12.equals(r9)
                if (r0 != 0) goto L_0x0033
                r12.recycle()
            L_0x0033:
                com.bumptech.glide.load.engine.DecodeJob r12 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.engine.DecodeHelper<R> r12 = r12.decodeHelper
                boolean r12 = r12.isResourceEncoderAvailable(r9)
                if (r12 == 0) goto L_0x004e
                com.bumptech.glide.load.engine.DecodeJob r12 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.engine.DecodeHelper<R> r12 = r12.decodeHelper
                com.bumptech.glide.load.ResourceEncoder r2 = r12.getResultEncoder(r9)
                com.bumptech.glide.load.engine.DecodeJob r12 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.Options r12 = r12.options
                com.bumptech.glide.load.EncodeStrategy r12 = r2.getEncodeStrategy(r12)
                goto L_0x0050
            L_0x004e:
                com.bumptech.glide.load.EncodeStrategy r12 = com.bumptech.glide.load.EncodeStrategy.NONE
            L_0x0050:
                r10 = r2
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.engine.DecodeHelper<R> r0 = r0.decodeHelper
                com.bumptech.glide.load.engine.DecodeJob r1 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.Key r1 = r1.currentSourceKey
                boolean r0 = r0.isSourceKey(r1)
                r0 = r0 ^ 1
                com.bumptech.glide.load.engine.DecodeJob r1 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.engine.DiskCacheStrategy r1 = r1.diskCacheStrategy
                com.bumptech.glide.load.DataSource r2 = r11.dataSource
                boolean r0 = r1.isResourceCacheable(r0, r2, r12)
                if (r0 == 0) goto L_0x00d6
                if (r10 == 0) goto L_0x00c8
                com.bumptech.glide.load.EncodeStrategy r0 = com.bumptech.glide.load.EncodeStrategy.SOURCE
                if (r12 != r0) goto L_0x007f
                com.bumptech.glide.load.engine.DataCacheKey r12 = new com.bumptech.glide.load.engine.DataCacheKey
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.Key r0 = r0.currentSourceKey
                com.bumptech.glide.load.engine.DecodeJob r1 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.Key r1 = r1.signature
                r12.<init>(r0, r1)
                goto L_0x00a5
            L_0x007f:
                com.bumptech.glide.load.EncodeStrategy r0 = com.bumptech.glide.load.EncodeStrategy.TRANSFORMED
                if (r12 != r0) goto L_0x00b1
                com.bumptech.glide.load.engine.ResourceCacheKey r12 = new com.bumptech.glide.load.engine.ResourceCacheKey
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.engine.DecodeHelper<R> r0 = r0.decodeHelper
                com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool r1 = r0.getArrayPool()
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.Key r2 = r0.currentSourceKey
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.Key r3 = r0.signature
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                int r4 = r0.width
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                int r5 = r0.height
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.Options r8 = r0.options
                r0 = r12
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            L_0x00a5:
                com.bumptech.glide.load.engine.LockedResource r9 = com.bumptech.glide.load.engine.LockedResource.obtain(r9)
                com.bumptech.glide.load.engine.DecodeJob r0 = com.bumptech.glide.load.engine.DecodeJob.this
                com.bumptech.glide.load.engine.DecodeJob$DeferredEncodeManager<?> r0 = r0.deferredEncodeManager
                r0.init(r12, r10, r9)
                goto L_0x00d6
            L_0x00b1:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Unknown strategy: "
                r1.append(r2)
                r1.append(r12)
                java.lang.String r12 = r1.toString()
                r0.<init>(r12)
                throw r0
            L_0x00c8:
                com.bumptech.glide.Registry$NoResultEncoderAvailableException r12 = new com.bumptech.glide.Registry$NoResultEncoderAvailableException
                java.lang.Object r0 = r9.get()
                java.lang.Class r0 = r0.getClass()
                r12.<init>(r0)
                throw r12
            L_0x00d6:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodeJob.DecodeCallback.onResourceDecoded(com.bumptech.glide.load.engine.Resource):com.bumptech.glide.load.engine.Resource");
        }

        private Class<Z> getResourceClass(Resource<Z> resource) {
            return resource.get().getClass();
        }
    }

    private static class ReleaseManager {
        private boolean isEncodeComplete;
        private boolean isFailed;
        private boolean isReleased;

        ReleaseManager() {
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean release(boolean z) {
            this.isReleased = true;
            return isComplete(z);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean onEncodeComplete() {
            this.isEncodeComplete = true;
            return isComplete(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized boolean onFailed() {
            this.isFailed = true;
            return isComplete(false);
        }

        /* access modifiers changed from: package-private */
        public synchronized void reset() {
            this.isEncodeComplete = false;
            this.isReleased = false;
            this.isFailed = false;
        }

        private boolean isComplete(boolean z) {
            return (this.isFailed || z || this.isEncodeComplete) && this.isReleased;
        }
    }

    private static class DeferredEncodeManager<Z> {
        private ResourceEncoder<Z> encoder;
        private Key key;
        private LockedResource<Z> toEncode;

        DeferredEncodeManager() {
        }

        /* access modifiers changed from: package-private */
        public <X> void init(Key key2, ResourceEncoder<X> resourceEncoder, LockedResource<X> lockedResource) {
            this.key = key2;
            this.encoder = resourceEncoder;
            this.toEncode = lockedResource;
        }

        /* access modifiers changed from: package-private */
        public void encode(DiskCacheProvider diskCacheProvider, Options options) {
            TraceCompat.beginSection("DecodeJob.encode");
            try {
                diskCacheProvider.getDiskCache().put(this.key, new DataCacheWriter(this.encoder, this.toEncode, options));
            } finally {
                this.toEncode.unlock();
                TraceCompat.endSection();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean hasResourceToEncode() {
            return this.toEncode != null;
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.key = null;
            this.encoder = null;
            this.toEncode = null;
        }
    }
}
