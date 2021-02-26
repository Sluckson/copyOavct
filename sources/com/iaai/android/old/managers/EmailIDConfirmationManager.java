package com.iaai.android.old.managers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.utils.Utils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class EmailIDConfirmationManager {
    private static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;

    @Inject
    private EmailIDConfirmationManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
        this.application.getInjector();
    }

    public void validateOTP(String str, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String string = this.application.getResources().getString(C2723R.string.validate_otp_url, new Object[]{str, str2});
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + string, asyncHttpResponseHandler);
        client.setTimeout(60000);
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.setEnableRedirects(true, true, true);
    }

    public void generateOTP(String str, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String string = this.application.getResources().getString(C2723R.string.generate_otp_url, new Object[]{str, str2});
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + string, asyncHttpResponseHandler);
        client.setTimeout(60000);
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.setEnableRedirects(true, true, true);
    }

    public void isValidEmail(String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String string = this.application.getResources().getString(C2723R.string.valid_email_url, new Object[]{str});
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + string, asyncHttpResponseHandler);
        client.setTimeout(60000);
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.setEnableRedirects(true, true, true);
    }
}
