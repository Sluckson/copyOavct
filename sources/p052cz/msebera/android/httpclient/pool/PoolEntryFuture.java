package p052cz.msebera.android.httpclient.pool;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.concurrent.FutureCallback;
import p052cz.msebera.android.httpclient.util.Args;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.pool.PoolEntryFuture */
abstract class PoolEntryFuture<T> implements Future<T> {
    private final FutureCallback<T> callback;
    private volatile boolean cancelled;
    private volatile boolean completed;
    private final Condition condition;
    private final Lock lock;
    private T result;

    /* access modifiers changed from: protected */
    public abstract T getPoolEntry(long j, TimeUnit timeUnit) throws IOException, InterruptedException, TimeoutException;

    PoolEntryFuture(Lock lock2, FutureCallback<T> futureCallback) {
        this.lock = lock2;
        this.condition = lock2.newCondition();
        this.callback = futureCallback;
    }

    public boolean cancel(boolean z) {
        boolean z2;
        this.lock.lock();
        try {
            if (this.completed) {
                z2 = false;
            } else {
                z2 = true;
                this.completed = true;
                this.cancelled = true;
                if (this.callback != null) {
                    this.callback.cancelled();
                }
                this.condition.signalAll();
            }
            return z2;
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    public boolean isDone() {
        return this.completed;
    }

    public T get() throws InterruptedException, ExecutionException {
        try {
            return get(0, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            throw new ExecutionException(e);
        }
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        T t;
        Args.notNull(timeUnit, "Time unit");
        this.lock.lock();
        try {
            if (this.completed) {
                t = this.result;
            } else {
                this.result = getPoolEntry(j, timeUnit);
                this.completed = true;
                if (this.callback != null) {
                    this.callback.completed(this.result);
                }
                t = this.result;
            }
            this.lock.unlock();
            return t;
        } catch (IOException e) {
            this.completed = true;
            this.result = null;
            if (this.callback != null) {
                this.callback.failed(e);
            }
            throw new ExecutionException(e);
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public boolean await(Date date) throws InterruptedException {
        boolean z;
        this.lock.lock();
        try {
            if (!this.cancelled) {
                if (date != null) {
                    z = this.condition.awaitUntil(date);
                } else {
                    this.condition.await();
                    z = true;
                }
                if (!this.cancelled) {
                    return z;
                }
                throw new InterruptedException("Operation interrupted");
            }
            throw new InterruptedException("Operation interrupted");
        } finally {
            this.lock.unlock();
        }
    }

    public void wakeup() {
        this.lock.lock();
        try {
            this.condition.signalAll();
        } finally {
            this.lock.unlock();
        }
    }
}
