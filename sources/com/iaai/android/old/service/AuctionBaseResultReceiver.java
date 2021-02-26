package com.iaai.android.old.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.ActivityHelper;

public abstract class AuctionBaseResultReceiver<TActivity extends Activity, TResult> extends ContextBaseResultReceiver<TActivity, TResult> {
    /* access modifiers changed from: protected */
    public abstract boolean showLoadingDialog();

    protected AuctionBaseResultReceiver(TActivity tactivity, Handler handler) {
        super(tactivity, handler);
    }

    /* access modifiers changed from: protected */
    public void onPreExecute(TActivity tactivity) {
        if (showLoadingDialog()) {
            Log.d("tag1", "loadingDialog...............");
            ActivityHelper.showLoadingDialog(tactivity);
        }
    }

    /* access modifiers changed from: protected */
    public void beforeResultHandled(TActivity tactivity) {
        if (showLoadingDialog()) {
            ActivityHelper.dismissDialog(tactivity);
            Log.d("tag2", "dismissDialog...............");
        }
    }

    /* access modifiers changed from: protected */
    public void onInvalidCredential(TActivity tactivity) {
        tactivity.sendBroadcast(new Intent(Constants.INTENT_CLEAR_CREDENTIAL));
    }
}
