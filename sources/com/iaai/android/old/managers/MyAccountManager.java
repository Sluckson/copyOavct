package com.iaai.android.old.managers;

import android.content.res.Resources;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Utils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class MyAccountManager {
    private static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;
    private SessionManager sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();

    @Inject
    private MyAccountManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
        client.addHeader("User-Agent", Utils.getUserAgent());
    }

    public void loadDashboardData(boolean z, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        Resources resources = this.application.getResources();
        Object[] objArr = new Object[2];
        objArr[0] = this.sessionManager.getCurrentSessionUserId();
        objArr[1] = z ? IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE : "0";
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + resources.getString(C2723R.string.service_path_dashboard, objArr), asyncHttpResponseHandler);
        client.setTimeout(60000);
    }

    public void getBuyNowOfferCount(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String string = this.application.getResources().getString(C2723R.string.service_path_dashboard_buy_now_offer_count, new Object[]{this.sessionManager.getCurrentSessionUserId()});
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + string, asyncHttpResponseHandler);
        client.setTimeout(60000);
    }
}
