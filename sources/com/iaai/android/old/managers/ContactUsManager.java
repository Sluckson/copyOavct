package com.iaai.android.old.managers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.utils.Utils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class ContactUsManager {
    private static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;

    @Inject
    private ContactUsManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
    }

    public void getContactUsBranch(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String string = this.application.getResources().getString(C2723R.string.service_path_location_search_all);
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + string, asyncHttpResponseHandler);
        client.setTimeout(60000);
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.setEnableRedirects(true, true, true);
    }
}
