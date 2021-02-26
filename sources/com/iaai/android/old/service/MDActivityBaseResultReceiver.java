package com.iaai.android.old.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.iaai.android.old.utils.constants.Constants;

public abstract class MDActivityBaseResultReceiver<TActivity extends Activity, TResult> extends MDContextBaseResultReceiver<TActivity, TResult> {
    public abstract void onError(TActivity tactivity);

    public abstract void onNetworkErrorOnProductDetail(TActivity tactivity, String str);

    /* access modifiers changed from: protected */
    public void onPreExecute(TActivity tactivity) {
    }

    public abstract void onTimeOutErrorType(TActivity tactivity, String str);

    protected MDActivityBaseResultReceiver(TActivity tactivity, Handler handler) {
        super(tactivity, handler);
    }

    /* access modifiers changed from: protected */
    public void beforeResultHandled(TActivity tactivity) {
        onError(tactivity);
    }

    /* access modifiers changed from: protected */
    public void onNetworkError(TActivity tactivity, String str) {
        onNetworkErrorOnProductDetail(tactivity, str);
    }

    /* access modifiers changed from: protected */
    public void onTimeOutError(TActivity tactivity, String str) {
        onTimeOutErrorType(tactivity, str);
    }

    /* access modifiers changed from: protected */
    public void onInvalidCredential(TActivity tactivity) {
        tactivity.sendBroadcast(new Intent(Constants.INTENT_CLEAR_CREDENTIAL));
    }
}
