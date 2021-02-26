package com.iaai.android;

import androidx.lifecycle.GeneratedAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MethodCallsLogger;

public class IaaiApplication_LifecycleAdapter implements GeneratedAdapter {
    final IaaiApplication mReceiver;

    IaaiApplication_LifecycleAdapter(IaaiApplication iaaiApplication) {
        this.mReceiver = iaaiApplication;
    }

    public void callMethods(LifecycleOwner lifecycleOwner, Lifecycle.Event event, boolean z, MethodCallsLogger methodCallsLogger) {
        boolean z2 = methodCallsLogger != null;
        if (!z) {
            if (event == Lifecycle.Event.ON_STOP) {
                if (!z2 || methodCallsLogger.approveCall("onAppBackgrounded", 1)) {
                    this.mReceiver.onAppBackgrounded();
                }
            } else if (event != Lifecycle.Event.ON_START) {
            } else {
                if (!z2 || methodCallsLogger.approveCall("onAppForegrounded", 1)) {
                    this.mReceiver.onAppForegrounded();
                }
            }
        }
    }
}
