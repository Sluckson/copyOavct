package com.iaai.android.old.managers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.utils.Utils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class ForgotPasswordManager {
    private static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;

    @Inject
    private ForgotPasswordManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
    }

    public void getForgotPasswordLink(String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String str2 = this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.forgot_password_url, new Object[]{str});
        try {
            str2 = URLEncoder.encode(str2, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.get(str2, asyncHttpResponseHandler);
    }
}
