package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;

public interface DataFetcher<T> {

    public interface DataCallback<T> {
        void onDataReady(@Nullable T t);

        void onLoadFailed(Exception exc);
    }

    void cancel();

    void cleanup();

    @NonNull
    Class<T> getDataClass();

    @NonNull
    DataSource getDataSource();

    void loadData(Priority priority, DataCallback<? super T> dataCallback);
}
