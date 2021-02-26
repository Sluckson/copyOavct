package roboguice.util;

import android.os.Handler;
import android.util.Log;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public abstract class SafeAsyncTask<ResultT> implements Callable<ResultT> {
    protected static final Executor DEFAULT_EXECUTOR = Executors.newFixedThreadPool(25);
    public static final int DEFAULT_POOL_SIZE = 25;
    protected Executor executor;
    protected FutureTask<Void> future;
    protected Handler handler;
    protected StackTraceElement[] launchLocation;

    /* access modifiers changed from: protected */
    public void onFinally() throws RuntimeException {
    }

    /* access modifiers changed from: protected */
    public void onPreExecute() throws Exception {
    }

    /* access modifiers changed from: protected */
    public void onSuccess(ResultT resultt) throws Exception {
    }

    public SafeAsyncTask() {
        this.executor = DEFAULT_EXECUTOR;
    }

    public SafeAsyncTask(Handler handler2) {
        this.handler = handler2;
        this.executor = DEFAULT_EXECUTOR;
    }

    public SafeAsyncTask(Executor executor2) {
        this.executor = executor2;
    }

    public SafeAsyncTask(Handler handler2, Executor executor2) {
        this.handler = handler2;
        this.executor = executor2;
    }

    public FutureTask<Void> future() {
        this.future = new FutureTask<>(newTask());
        return this.future;
    }

    public SafeAsyncTask<ResultT> executor(Executor executor2) {
        this.executor = executor2;
        return this;
    }

    public Executor executor() {
        return this.executor;
    }

    public SafeAsyncTask<ResultT> handler(Handler handler2) {
        this.handler = handler2;
        return this;
    }

    public Handler handler() {
        return this.handler;
    }

    public void execute() {
        execute(Thread.currentThread().getStackTrace());
    }

    /* access modifiers changed from: protected */
    public void execute(StackTraceElement[] stackTraceElementArr) {
        this.launchLocation = stackTraceElementArr;
        this.executor.execute(future());
    }

    public boolean cancel(boolean z) {
        FutureTask<Void> futureTask = this.future;
        if (futureTask != null) {
            return futureTask.cancel(z);
        }
        throw new UnsupportedOperationException("You cannot cancel this task before calling future()");
    }

    /* access modifiers changed from: protected */
    public void onInterrupted(Exception exc) {
        onException(exc);
    }

    /* access modifiers changed from: protected */
    public void onException(Exception exc) throws RuntimeException {
        Log.e("roboguice", "Exception caught during background processing", exc);
    }

    /* access modifiers changed from: protected */
    public Task<ResultT> newTask() {
        return new Task<>(this);
    }

    public static class Task<ResultT> implements Callable<Void> {
        protected Handler handler;
        protected SafeAsyncTask<ResultT> parent;

        public Task(SafeAsyncTask safeAsyncTask) {
            this.parent = safeAsyncTask;
            this.handler = safeAsyncTask.handler != null ? safeAsyncTask.handler : new Handler();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
            doFinally();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
            throw r0;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:4:0x000e A[ExcHandler: all (r0v1 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void call() throws java.lang.Exception {
            /*
                r1 = this;
                r1.doPreExecute()     // Catch:{ Exception -> 0x0010, all -> 0x000e }
                java.lang.Object r0 = r1.doCall()     // Catch:{ Exception -> 0x0010, all -> 0x000e }
                r1.doSuccess(r0)     // Catch:{ Exception -> 0x0010, all -> 0x000e }
            L_0x000a:
                r1.doFinally()
                goto L_0x0019
            L_0x000e:
                r0 = move-exception
                goto L_0x0015
            L_0x0010:
                r0 = move-exception
                r1.doException(r0)     // Catch:{ Exception -> 0x000a, all -> 0x000e }
                goto L_0x000a
            L_0x0015:
                r1.doFinally()
                throw r0
            L_0x0019:
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: roboguice.util.SafeAsyncTask.Task.call():java.lang.Void");
        }

        /* access modifiers changed from: protected */
        public void doPreExecute() throws Exception {
            postToUiThreadAndWait(new Callable<Object>() {
                public Object call() throws Exception {
                    Task.this.parent.onPreExecute();
                    return null;
                }
            });
        }

        /* access modifiers changed from: protected */
        public ResultT doCall() throws Exception {
            return this.parent.call();
        }

        /* access modifiers changed from: protected */
        public void doSuccess(final ResultT resultt) throws Exception {
            postToUiThreadAndWait(new Callable<Object>() {
                public Object call() throws Exception {
                    Task.this.parent.onSuccess(resultt);
                    return null;
                }
            });
        }

        /* access modifiers changed from: protected */
        public void doException(final Exception exc) throws Exception {
            if (this.parent.launchLocation != null) {
                ArrayList arrayList = new ArrayList(Arrays.asList(exc.getStackTrace()));
                arrayList.addAll(Arrays.asList(this.parent.launchLocation));
                exc.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[arrayList.size()]));
            }
            postToUiThreadAndWait(new Callable<Object>() {
                public Object call() throws Exception {
                    Exception exc = exc;
                    if ((exc instanceof InterruptedException) || (exc instanceof InterruptedIOException)) {
                        Task.this.parent.onInterrupted(exc);
                        return null;
                    }
                    Task.this.parent.onException(exc);
                    return null;
                }
            });
        }

        /* access modifiers changed from: protected */
        public void doFinally() throws Exception {
            postToUiThreadAndWait(new Callable<Object>() {
                public Object call() throws Exception {
                    Task.this.parent.onFinally();
                    return null;
                }
            });
        }

        /* access modifiers changed from: protected */
        public void postToUiThreadAndWait(final Callable callable) throws Exception {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final Exception[] excArr = new Exception[1];
            this.handler.post(new Runnable() {
                public void run() {
                    try {
                        callable.call();
                    } catch (Exception e) {
                        excArr[0] = e;
                    } catch (Throwable th) {
                        countDownLatch.countDown();
                        throw th;
                    }
                    countDownLatch.countDown();
                }
            });
            countDownLatch.await();
            if (excArr[0] != null) {
                throw excArr[0];
            }
        }
    }
}
