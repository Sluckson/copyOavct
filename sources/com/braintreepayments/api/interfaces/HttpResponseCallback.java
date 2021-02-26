package com.braintreepayments.api.interfaces;

import androidx.annotation.MainThread;

public interface HttpResponseCallback {
    @MainThread
    void failure(Exception exc);

    @MainThread
    void success(String str);
}
