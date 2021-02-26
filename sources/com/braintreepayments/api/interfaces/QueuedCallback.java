package com.braintreepayments.api.interfaces;

import androidx.annotation.MainThread;

public interface QueuedCallback {
    @MainThread
    void run();

    boolean shouldRun();
}
