package p052cz.msebera.android.httpclient.impl.client.cache;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.cache.ExponentialBackOffSchedulingStrategy */
public class ExponentialBackOffSchedulingStrategy implements SchedulingStrategy {
    public static final long DEFAULT_BACK_OFF_RATE = 10;
    public static final long DEFAULT_INITIAL_EXPIRY_IN_MILLIS = TimeUnit.SECONDS.toMillis(6);
    public static final long DEFAULT_MAX_EXPIRY_IN_MILLIS = TimeUnit.SECONDS.toMillis(86400);
    private final long backOffRate;
    private final ScheduledExecutorService executor;
    private final long initialExpiryInMillis;
    private final long maxExpiryInMillis;

    public ExponentialBackOffSchedulingStrategy(CacheConfig cacheConfig) {
        this(cacheConfig, 10, DEFAULT_INITIAL_EXPIRY_IN_MILLIS, DEFAULT_MAX_EXPIRY_IN_MILLIS);
    }

    public ExponentialBackOffSchedulingStrategy(CacheConfig cacheConfig, long j, long j2, long j3) {
        this((ScheduledExecutorService) createThreadPoolFromCacheConfig(cacheConfig), j, j2, j3);
    }

    private static ScheduledThreadPoolExecutor createThreadPoolFromCacheConfig(CacheConfig cacheConfig) {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(cacheConfig.getAsynchronousWorkersMax());
        scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
        return scheduledThreadPoolExecutor;
    }

    ExponentialBackOffSchedulingStrategy(ScheduledExecutorService scheduledExecutorService, long j, long j2, long j3) {
        this.executor = (ScheduledExecutorService) checkNotNull("executor", scheduledExecutorService);
        this.backOffRate = checkNotNegative("backOffRate", j);
        this.initialExpiryInMillis = checkNotNegative("initialExpiryInMillis", j2);
        this.maxExpiryInMillis = checkNotNegative("maxExpiryInMillis", j3);
    }

    public void schedule(AsynchronousValidationRequest asynchronousValidationRequest) {
        checkNotNull("revalidationRequest", asynchronousValidationRequest);
        this.executor.schedule(asynchronousValidationRequest, calculateDelayInMillis(asynchronousValidationRequest.getConsecutiveFailedAttempts()), TimeUnit.MILLISECONDS);
    }

    public void close() {
        this.executor.shutdown();
    }

    public long getBackOffRate() {
        return this.backOffRate;
    }

    public long getInitialExpiryInMillis() {
        return this.initialExpiryInMillis;
    }

    public long getMaxExpiryInMillis() {
        return this.maxExpiryInMillis;
    }

    /* access modifiers changed from: protected */
    public long calculateDelayInMillis(int i) {
        if (i > 0) {
            return Math.min((long) (((double) this.initialExpiryInMillis) * Math.pow((double) this.backOffRate, (double) (i - 1))), this.maxExpiryInMillis);
        }
        return 0;
    }

    protected static <T> T checkNotNull(String str, T t) {
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException(str + " may not be null");
    }

    protected static long checkNotNegative(String str, long j) {
        if (j >= 0) {
            return j;
        }
        throw new IllegalArgumentException(str + " may not be negative");
    }
}
