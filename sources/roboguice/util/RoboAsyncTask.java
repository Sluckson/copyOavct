package roboguice.util;

import android.content.Context;
import android.os.Handler;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.concurrent.Executor;
import roboguice.inject.ContextScope;
import roboguice.util.SafeAsyncTask;

public abstract class RoboAsyncTask<ResultT> extends SafeAsyncTask<ResultT> {
    @Inject
    protected static Provider<Context> contextProvider;
    @Inject
    protected static Provider<ContextScope> scopeProvider;
    protected Context context = contextProvider.get();
    protected ContextScope scope = scopeProvider.get();

    protected RoboAsyncTask() {
    }

    protected RoboAsyncTask(Handler handler) {
        super(handler);
    }

    protected RoboAsyncTask(Handler handler, Executor executor) {
        super(handler, executor);
    }

    protected RoboAsyncTask(Executor executor) {
        super(executor);
    }

    /* access modifiers changed from: protected */
    public SafeAsyncTask.Task<ResultT> newTask() {
        return new RoboTask(this);
    }

    protected class RoboTask<ResultT> extends SafeAsyncTask.Task<ResultT> {
        public RoboTask(SafeAsyncTask safeAsyncTask) {
            super(safeAsyncTask);
        }

        /* access modifiers changed from: protected */
        public ResultT doCall() throws Exception {
            try {
                RoboAsyncTask.this.scope.enter(RoboAsyncTask.this.context);
                return super.doCall();
            } finally {
                RoboAsyncTask.this.scope.exit(RoboAsyncTask.this.context);
            }
        }
    }
}
