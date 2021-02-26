package com.iaai.android.old.service;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;

public class ResultReceiverWrapper extends ResultReceiver {
    private WeakReference<Receiver> receiverRef;

    public ResultReceiverWrapper(Handler handler) {
        super(handler);
    }

    public void setReceiver(Receiver receiver) {
        if (receiver == null) {
            WeakReference<Receiver> weakReference = this.receiverRef;
            if (weakReference != null) {
                weakReference.clear();
                this.receiverRef = null;
                return;
            }
            return;
        }
        this.receiverRef = new WeakReference<>(receiver);
    }

    public boolean isReceiverNull() {
        WeakReference<Receiver> weakReference = this.receiverRef;
        return weakReference == null || weakReference.get() == null;
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        WeakReference<Receiver> weakReference = this.receiverRef;
        Receiver receiver = weakReference == null ? null : (Receiver) weakReference.get();
        if (receiver != null) {
            receiver.onReceiveResult(i, bundle);
        }
    }
}
