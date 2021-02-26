package com.iaai.android.old.managers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Utils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class VehicleReceiptManager {
    private static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;
    private SessionManager sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();

    @Inject
    private VehicleReceiptManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
        client.addHeader("User-Agent", Utils.getUserAgent());
    }

    public void loadReceiptData(String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + str, asyncHttpResponseHandler);
    }
}
