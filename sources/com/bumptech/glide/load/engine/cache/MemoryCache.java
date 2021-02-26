package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

public interface MemoryCache {

    public interface ResourceRemovedListener {
        void onResourceRemoved(@NonNull Resource<?> resource);
    }

    void clearMemory();

    long getCurrentSize();

    long getMaxSize();

    @Nullable
    Resource<?> put(Key key, Resource<?> resource);

    @Nullable
    Resource<?> remove(Key key);

    void setResourceRemovedListener(ResourceRemovedListener resourceRemovedListener);

    void setSizeMultiplier(float f);

    void trimMemory(int i);
}
