package com.iaai.android.old.managers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.constants.Constants;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class TermsOfUseManager {
    private static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;
    private SessionManager sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();

    @Inject
    private TermsOfUseManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
        this.application.getInjector();
        client.addHeader("User-Agent", Utils.getUserAgent());
    }

    public void getTermsOfUseAuctionRule(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.terms_of_use_auction_rule), asyncHttpResponseHandler);
    }

    public void saveTermsOfUse(String str, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String string = this.application.getResources().getString(C2723R.string.save_terms_of_use_url, new Object[]{str});
        if (this.sessionManager.getCurrentSessionUserId() != null) {
            string = string + "&userid=" + this.sessionManager.getCurrentSessionUserId();
        }
        client.addHeader(Constants.DEVICEID_HEADER, str2);
        client.addHeader(Constants.DEVICETYPE_HEADER, "Android");
        client.setTimeout(60000);
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + string, asyncHttpResponseHandler);
    }
}
