package com.iaai.android.old.managers;

import android.content.Context;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.utils.Utils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.ResponseHandlerInterface;
import java.io.UnsupportedEncodingException;

public class AuctionNowManager {
    private static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;

    @Inject
    private AuctionNowManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
        this.application.getInjector();
    }

    public void getAuctionNowURL(Context context, String str, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) throws UnsupportedEncodingException {
        client.get(context, geURLForAuctionNow(context, str, str2), (ResponseHandlerInterface) asyncHttpResponseHandler);
        client.setTimeout(60000);
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.setEnableRedirects(true, true, true);
    }

    private static String geURLForAuctionNow(Context context, String str, String str2) {
        return context.getResources().getString(C2723R.string.base_https_url) + context.getResources().getString(C2723R.string.auction_now_url, new Object[]{str, str2});
    }

    public void getAuctionNowIndicator(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String string = this.application.getResources().getString(C2723R.string.auction_now_indicator_url);
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + string, asyncHttpResponseHandler);
        client.addHeader("User-Agent", Utils.getUserAgent());
    }
}
