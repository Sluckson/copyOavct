package p052cz.msebera.android.httpclient.impl.client.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.DefaultFailureCache */
public class DefaultFailureCache implements FailureCache {
    static final int DEFAULT_MAX_SIZE = 1000;
    static final int MAX_UPDATE_TRIES = 10;
    private final int maxSize;
    private final ConcurrentMap<String, FailureCacheValue> storage;

    public DefaultFailureCache() {
        this(1000);
    }

    public DefaultFailureCache(int i) {
        this.maxSize = i;
        this.storage = new ConcurrentHashMap();
    }

    public int getErrorCount(String str) {
        if (str != null) {
            FailureCacheValue failureCacheValue = (FailureCacheValue) this.storage.get(str);
            if (failureCacheValue != null) {
                return failureCacheValue.getErrorCount();
            }
            return 0;
        }
        throw new IllegalArgumentException("identifier may not be null");
    }

    public void resetErrorCount(String str) {
        if (str != null) {
            this.storage.remove(str);
            return;
        }
        throw new IllegalArgumentException("identifier may not be null");
    }

    public void increaseErrorCount(String str) {
        if (str != null) {
            updateValue(str);
            removeOldestEntryIfMapSizeExceeded();
            return;
        }
        throw new IllegalArgumentException("identifier may not be null");
    }

    private void updateValue(String str) {
        for (int i = 0; i < 10; i++) {
            FailureCacheValue failureCacheValue = (FailureCacheValue) this.storage.get(str);
            if (failureCacheValue == null) {
                if (this.storage.putIfAbsent(str, new FailureCacheValue(str, 1)) == null) {
                    return;
                }
            } else {
                int errorCount = failureCacheValue.getErrorCount();
                if (errorCount != Integer.MAX_VALUE) {
                    if (this.storage.replace(str, failureCacheValue, new FailureCacheValue(str, errorCount + 1))) {
                        return;
                    }
                } else {
                    return;
                }
            }
        }
    }

    private void removeOldestEntryIfMapSizeExceeded() {
        FailureCacheValue findValueWithOldestTimestamp;
        if (this.storage.size() > this.maxSize && (findValueWithOldestTimestamp = findValueWithOldestTimestamp()) != null) {
            this.storage.remove(findValueWithOldestTimestamp.getKey(), findValueWithOldestTimestamp);
        }
    }

    private FailureCacheValue findValueWithOldestTimestamp() {
        long j = Long.MAX_VALUE;
        FailureCacheValue failureCacheValue = null;
        for (Map.Entry entry : this.storage.entrySet()) {
            long creationTimeInNanos = ((FailureCacheValue) entry.getValue()).getCreationTimeInNanos();
            if (creationTimeInNanos < j) {
                failureCacheValue = (FailureCacheValue) entry.getValue();
                j = creationTimeInNanos;
            }
        }
        return failureCacheValue;
    }
}
