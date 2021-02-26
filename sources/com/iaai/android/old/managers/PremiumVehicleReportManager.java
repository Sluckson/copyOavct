package com.iaai.android.old.managers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Utils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class PremiumVehicleReportManager {
    private static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;
    private SessionManager sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();

    @Inject
    private PremiumVehicleReportManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
        client.addHeader("User-Agent", Utils.getUserAgent());
    }

    public void loadAutoVINHtml(String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + str, asyncHttpResponseHandler);
    }

    public void loadInstaVINPDF(String str, String str2, String str3, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_pvr_insta_vin_url, new Object[]{str, str2, str3}), asyncHttpResponseHandler);
    }
}
