package p052cz.msebera.android.httpclient.impl.client.cache;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.ImmediateSchedulingStrategy */
public class ImmediateSchedulingStrategy implements SchedulingStrategy {
    private final ExecutorService executor;

    public ImmediateSchedulingStrategy(CacheConfig cacheConfig) {
        this((ExecutorService) new ThreadPoolExecutor(cacheConfig.getAsynchronousWorkersCore(), cacheConfig.getAsynchronousWorkersMax(), (long) cacheConfig.getAsynchronousWorkerIdleLifetimeSecs(), TimeUnit.SECONDS, new ArrayBlockingQueue(cacheConfig.getRevalidationQueueSize())));
    }

    ImmediateSchedulingStrategy(ExecutorService executorService) {
        this.executor = executorService;
    }

    public void schedule(AsynchronousValidationRequest asynchronousValidationRequest) {
        if (asynchronousValidationRequest != null) {
            this.executor.execute(asynchronousValidationRequest);
            return;
        }
        throw new IllegalArgumentException("AsynchronousValidationRequest may not be null");
    }

    public void close() {
        this.executor.shutdown();
    }

    /* access modifiers changed from: package-private */
    public void awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        this.executor.awaitTermination(j, timeUnit);
    }
}
