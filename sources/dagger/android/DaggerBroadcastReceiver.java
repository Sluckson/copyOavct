package dagger.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.CallSuper;

public abstract class DaggerBroadcastReceiver extends BroadcastReceiver {
    @CallSuper
    public void onReceive(Context context, Intent intent) {
        AndroidInjection.inject(this, context);
    }
}
