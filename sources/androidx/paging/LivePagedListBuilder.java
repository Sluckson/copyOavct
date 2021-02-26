package androidx.paging;

import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.lifecycle.ComputableLiveData;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.PagedList;
import java.util.concurrent.Executor;

public final class LivePagedListBuilder<Key, Value> {
    private PagedList.BoundaryCallback mBoundaryCallback;
    private PagedList.Config mConfig;
    private DataSource.Factory<Key, Value> mDataSourceFactory;
    private Executor mFetchExecutor;
    private Key mInitialLoadKey;

    public LivePagedListBuilder(@NonNull DataSource.Factory<Key, Value> factory, @NonNull PagedList.Config config) {
        this.mFetchExecutor = ArchTaskExecutor.getIOThreadExecutor();
        if (config == null) {
            throw new IllegalArgumentException("PagedList.Config must be provided");
        } else if (factory != null) {
            this.mDataSourceFactory = factory;
            this.mConfig = config;
        } else {
            throw new IllegalArgumentException("DataSource.Factory must be provided");
        }
    }

    public LivePagedListBuilder(@NonNull DataSource.Factory<Key, Value> factory, int i) {
        this(factory, new PagedList.Config.Builder().setPageSize(i).build());
    }

    @NonNull
    public LivePagedListBuilder<Key, Value> setInitialLoadKey(@Nullable Key key) {
        this.mInitialLoadKey = key;
        return this;
    }

    @NonNull
    public LivePagedListBuilder<Key, Value> setBoundaryCallback(@Nullable PagedList.BoundaryCallback<Value> boundaryCallback) {
        this.mBoundaryCallback = boundaryCallback;
        return this;
    }

    @NonNull
    public LivePagedListBuilder<Key, Value> setFetchExecutor(@NonNull Executor executor) {
        this.mFetchExecutor = executor;
        return this;
    }

    @NonNull
    public LiveData<PagedList<Value>> build() {
        return create(this.mInitialLoadKey, this.mConfig, this.mBoundaryCallback, this.mDataSourceFactory, ArchTaskExecutor.getMainThreadExecutor(), this.mFetchExecutor);
    }

    @NonNull
    @AnyThread
    private static <Key, Value> LiveData<PagedList<Value>> create(@Nullable Key key, @NonNull PagedList.Config config, @Nullable PagedList.BoundaryCallback boundaryCallback, @NonNull DataSource.Factory<Key, Value> factory, @NonNull Executor executor, @NonNull Executor executor2) {
        final Key key2 = key;
        final DataSource.Factory<Key, Value> factory2 = factory;
        final PagedList.Config config2 = config;
        final Executor executor3 = executor;
        final Executor executor4 = executor2;
        final PagedList.BoundaryCallback boundaryCallback2 = boundaryCallback;
        return new ComputableLiveData<PagedList<Value>>(executor2) {
            private final DataSource.InvalidatedCallback mCallback = new DataSource.InvalidatedCallback() {
                public void onInvalidated() {
                    C06201.this.invalidate();
                }
            };
            @Nullable
            private DataSource<Key, Value> mDataSource;
            @Nullable
            private PagedList<Value> mList;

            /* access modifiers changed from: protected */
            public PagedList<Value> compute() {
                Object obj = key2;
                PagedList<Value> pagedList = this.mList;
                if (pagedList != null) {
                    obj = pagedList.getLastKey();
                }
                do {
                    DataSource<Key, Value> dataSource = this.mDataSource;
                    if (dataSource != null) {
                        dataSource.removeInvalidatedCallback(this.mCallback);
                    }
                    this.mDataSource = factory2.create();
                    this.mDataSource.addInvalidatedCallback(this.mCallback);
                    this.mList = new PagedList.Builder(this.mDataSource, config2).setNotifyExecutor(executor3).setFetchExecutor(executor4).setBoundaryCallback(boundaryCallback2).setInitialKey(obj).build();
                } while (this.mList.isDetached());
                return this.mList;
            }
        }.getLiveData();
    }
}
