package com.iaai.android.old.managers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.inject.Inject;
import com.iaai.android.old.utils.constants.Constants;
import roboguice.activity.event.OnCreateEvent;
import roboguice.activity.event.OnDestroyEvent;
import roboguice.event.EventManager;
import roboguice.event.Observes;
import roboguice.util.C5058Ln;

public class LoginStateChangeEventListener {
    @Inject
    Context context;
    @Inject
    EventManager eventManager;
    private final IntentFilter intentFilterLoginStatusChange = new IntentFilter();
    private final BroadcastReceiver loginStateBroadcastReceiver;

    LoginStateChangeEventListener() {
        this.intentFilterLoginStatusChange.addAction(Constants.INTENT_LOGIN);
        this.intentFilterLoginStatusChange.addAction(Constants.INTENT_LOGOUT);
        this.intentFilterLoginStatusChange.addAction(Constants.INTENT_TIMEOUT);
        this.loginStateBroadcastReceiver = new LoginStateBroadcastReceiver();
    }

    /* access modifiers changed from: package-private */
    public void registerReceiver(@Observes OnCreateEvent onCreateEvent) {
        C5058Ln.m4829d("LoginStateChangeEventListener.registerReceiver context[%s]", this.context.getClass().getSimpleName());
        this.context.registerReceiver(this.loginStateBroadcastReceiver, this.intentFilterLoginStatusChange);
    }

    /* access modifiers changed from: package-private */
    public void unregisterReceiver(@Observes OnDestroyEvent onDestroyEvent) {
        C5058Ln.m4829d("LoginStateChangeEventListener.unregisterReceiver context[%s]", this.context.getClass().getSimpleName());
        this.context.unregisterReceiver(this.loginStateBroadcastReceiver);
    }

    private class LoginStateBroadcastReceiver extends BroadcastReceiver {
        private LoginStateBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            LoginStateChangeEventListener.this.eventManager.fire(context, new OnLoginStateChangeEvent(Constants.INTENT_LOGIN.equals(intent.getAction()), intent));
        }
    }
}
