package roboguice.activity;

import android.app.Activity;
import android.os.Bundle;
import roboguice.application.RoboApplication;

public abstract class RoboSplashActivity extends Activity {
    protected int minDisplayMs = 2500;

    /* access modifiers changed from: protected */
    public void doStuffInBackground(RoboApplication roboApplication) {
    }

    /* access modifiers changed from: protected */
    public abstract void startNextActivity();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final long currentTimeMillis = System.currentTimeMillis();
        new Thread(new Runnable() {
            /* JADX WARNING: Can't wrap try/catch for region: R(4:5|6|7|8) */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0036 */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void run() {
                /*
                    r7 = this;
                    roboguice.activity.RoboSplashActivity r0 = roboguice.activity.RoboSplashActivity.this
                    android.app.Application r0 = r0.getApplication()
                    roboguice.application.RoboApplication r0 = (roboguice.application.RoboApplication) r0
                    com.google.inject.Injector r1 = r0.getInjector()
                    java.lang.Class<roboguice.inject.ContextScope> r2 = roboguice.inject.ContextScope.class
                    java.lang.Object r1 = r1.getInstance(r2)
                    roboguice.inject.ContextScope r1 = (roboguice.inject.ContextScope) r1
                    r1.enter(r0)
                    roboguice.activity.RoboSplashActivity r2 = roboguice.activity.RoboSplashActivity.this     // Catch:{ all -> 0x0047 }
                    r2.doStuffInBackground(r0)     // Catch:{ all -> 0x0047 }
                    long r2 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0047 }
                    long r4 = r0     // Catch:{ all -> 0x0047 }
                    long r2 = r2 - r4
                    roboguice.activity.RoboSplashActivity r4 = roboguice.activity.RoboSplashActivity.this     // Catch:{ all -> 0x0047 }
                    int r4 = r4.minDisplayMs     // Catch:{ all -> 0x0047 }
                    long r4 = (long) r4
                    int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                    if (r6 >= 0) goto L_0x0039
                    roboguice.activity.RoboSplashActivity r4 = roboguice.activity.RoboSplashActivity.this     // Catch:{ InterruptedException -> 0x0036 }
                    int r4 = r4.minDisplayMs     // Catch:{ InterruptedException -> 0x0036 }
                    long r4 = (long) r4     // Catch:{ InterruptedException -> 0x0036 }
                    long r4 = r4 - r2
                    java.lang.Thread.sleep(r4)     // Catch:{ InterruptedException -> 0x0036 }
                    goto L_0x0039
                L_0x0036:
                    java.lang.Thread.interrupted()     // Catch:{ all -> 0x0047 }
                L_0x0039:
                    roboguice.activity.RoboSplashActivity r2 = roboguice.activity.RoboSplashActivity.this     // Catch:{ all -> 0x0047 }
                    r2.startNextActivity()     // Catch:{ all -> 0x0047 }
                    roboguice.activity.RoboSplashActivity r2 = roboguice.activity.RoboSplashActivity.this     // Catch:{ all -> 0x0047 }
                    r2.andFinishThisOne()     // Catch:{ all -> 0x0047 }
                    r1.exit(r0)
                    return
                L_0x0047:
                    r2 = move-exception
                    r1.exit(r0)
                    throw r2
                */
                throw new UnsupportedOperationException("Method not decompiled: roboguice.activity.RoboSplashActivity.C50551.run():void");
            }
        }).start();
    }

    /* access modifiers changed from: protected */
    public void andFinishThisOne() {
        finish();
    }
}
