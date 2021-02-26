package com.iaai.android.old.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.ActivityHelper;

public abstract class ActivityBaseResultReceiver<TActivity extends Activity, TResult> extends ContextBaseResultReceiver<TActivity, TResult> {
    protected ActivityBaseResultReceiver(TActivity tactivity, Handler handler) {
        super(tactivity, handler);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute(TActivity tactivity) {
        ActivityHelper.showLoadingDialog(tactivity);
    }

    /* access modifiers changed from: protected */
    public void beforeResultHandled(TActivity tactivity) {
        ActivityHelper.dismissDialog(tactivity);
    }

    /* access modifiers changed from: protected */
    public void onInvalidCredential(TActivity tactivity) {
        tactivity.sendBroadcast(new Intent(Constants.INTENT_CLEAR_CREDENTIAL));
    }
}
