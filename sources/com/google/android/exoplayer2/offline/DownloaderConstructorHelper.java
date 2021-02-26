package com.google.android.exoplayer2.offline;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.upstream.DataSink;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DummyDataSource;
import com.google.android.exoplayer2.upstream.FileDataSourceFactory;
import com.google.android.exoplayer2.upstream.PriorityDataSourceFactory;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.exoplayer2.upstream.cache.CacheDataSinkFactory;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheUtil;
import com.google.android.exoplayer2.util.PriorityTaskManager;

public final class DownloaderConstructorHelper {
    private final Cache cache;
    @Nullable
    private final CacheKeyFactory cacheKeyFactory;
    private final CacheDataSourceFactory offlineCacheDataSourceFactory;
    private final CacheDataSourceFactory onlineCacheDataSourceFactory;
    @Nullable
    private final PriorityTaskManager priorityTaskManager;

    public DownloaderConstructorHelper(Cache cache2, DataSource.Factory factory) {
        this(cache2, factory, (DataSource.Factory) null, (DataSink.Factory) null, (PriorityTaskManager) null);
    }

    public DownloaderConstructorHelper(Cache cache2, DataSource.Factory factory, @Nullable DataSource.Factory factory2, @Nullable DataSink.Factory factory3, @Nullable PriorityTaskManager priorityTaskManager2) {
        this(cache2, factory, factory2, factory3, priorityTaskManager2, (CacheKeyFactory) null);
    }

    public DownloaderConstructorHelper(Cache cache2, DataSource.Factory factory, @Nullable DataSource.Factory factory2, @Nullable DataSink.Factory factory3, @Nullable PriorityTaskManager priorityTaskManager2, @Nullable CacheKeyFactory cacheKeyFactory2) {
        PriorityDataSourceFactory priorityDataSourceFactory;
        FileDataSourceFactory fileDataSourceFactory;
        Cache cache3 = cache2;
        PriorityTaskManager priorityTaskManager3 = priorityTaskManager2;
        if (priorityTaskManager3 != null) {
            DataSource.Factory factory4 = factory;
            priorityDataSourceFactory = new PriorityDataSourceFactory(factory, priorityTaskManager3, -1000);
        } else {
            priorityDataSourceFactory = factory;
        }
        if (factory2 != null) {
            fileDataSourceFactory = factory2;
        } else {
            fileDataSourceFactory = new FileDataSourceFactory();
        }
        Cache cache4 = cache2;
        DataSource.Factory factory5 = fileDataSourceFactory;
        CacheKeyFactory cacheKeyFactory3 = cacheKeyFactory2;
        this.onlineCacheDataSourceFactory = new CacheDataSourceFactory(cache4, priorityDataSourceFactory, factory5, factory3 == null ? new CacheDataSinkFactory(cache2, CacheDataSink.DEFAULT_FRAGMENT_SIZE) : factory3, 1, (CacheDataSource.EventListener) null, cacheKeyFactory3);
        this.offlineCacheDataSourceFactory = new CacheDataSourceFactory(cache4, DummyDataSource.FACTORY, factory5, (DataSink.Factory) null, 1, (CacheDataSource.EventListener) null, cacheKeyFactory3);
        this.cache = cache3;
        this.priorityTaskManager = priorityTaskManager3;
        this.cacheKeyFactory = cacheKeyFactory2;
    }

    public Cache getCache() {
        return this.cache;
    }

    public CacheKeyFactory getCacheKeyFactory() {
        CacheKeyFactory cacheKeyFactory2 = this.cacheKeyFactory;
        return cacheKeyFactory2 != null ? cacheKeyFactory2 : CacheUtil.DEFAULT_CACHE_KEY_FACTORY;
    }

    public PriorityTaskManager getPriorityTaskManager() {
        PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
        return priorityTaskManager2 != null ? priorityTaskManager2 : new PriorityTaskManager();
    }

    public CacheDataSource createCacheDataSource() {
        return this.onlineCacheDataSourceFactory.createDataSource();
    }

    public CacheDataSource createOfflineCacheDataSource() {
        return this.offlineCacheDataSourceFactory.createDataSource();
    }
}
