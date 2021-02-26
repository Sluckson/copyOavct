package roboguice.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.inject.Injector;
import roboguice.application.RoboApplication;
import roboguice.inject.ContextScope;

public abstract class RoboBroadcastReceiver extends BroadcastReceiver {
    protected ContextScope scope;

    /* access modifiers changed from: protected */
    public void handleReceive(Context context, Intent intent) {
    }

    public final void onReceive(Context context, Intent intent) {
        Injector injector = ((RoboApplication) context.getApplicationContext()).getInjector();
        Context context2 = (Context) injector.getInstance(Context.class);
        this.scope = (ContextScope) injector.getInstance(ContextScope.class);
        this.scope.enter(context);
        try {
            injector.injectMembers(this);
            handleReceive(context, intent);
        } finally {
            this.scope.exit(context);
            this.scope.enter(context2);
        }
    }
}
