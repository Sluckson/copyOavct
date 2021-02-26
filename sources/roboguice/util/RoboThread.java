package roboguice.util;

import android.content.Context;
import com.google.inject.Inject;
import com.google.inject.Provider;
import roboguice.inject.ContextScope;

public class RoboThread extends Thread {
    @Inject
    protected static Provider<Context> contextProvider;
    @Inject
    protected static Provider<ContextScope> scopeProvider;

    public RoboThread() {
    }

    public RoboThread(Runnable runnable) {
        super(runnable);
    }

    public void start() {
        final ContextScope contextScope = scopeProvider.get();
        final Context context = contextProvider.get();
        new Thread() {
            public void run() {
                try {
                    contextScope.enter(context);
                    RoboThread.this.run();
                } finally {
                    contextScope.exit(context);
                }
            }
        }.start();
    }
}
