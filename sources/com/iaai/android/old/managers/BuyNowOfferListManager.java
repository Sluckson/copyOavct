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

public class BuyNowOfferListManager {
    private static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;

    @Inject
    private BuyNowOfferListManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
        this.application.getInjector();
    }

    public void getBuyNowOfferList(Context context, String str, int i, int i2, AsyncHttpResponseHandler asyncHttpResponseHandler) throws UnsupportedEncodingException {
        client.get(context, geURLForBuyNowOffer(context, str, i, i2), (ResponseHandlerInterface) asyncHttpResponseHandler);
        client.setTimeout(60000);
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.setEnableRedirects(true, true, true);
    }

    public void getBuyNowOfferTime(Context context, AsyncHttpResponseHandler asyncHttpResponseHandler) throws UnsupportedEncodingException {
        client.get(context, geURLForBuyNowOfferTime(context), (ResponseHandlerInterface) asyncHttpResponseHandler);
        client.setTimeout(60000);
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.setEnableRedirects(true, true, true);
    }

    private static String geURLForBuyNowOffer(Context context, String str, int i, int i2) {
        return context.getResources().getString(C2723R.string.base_https_url) + context.getResources().getString(C2723R.string.buy_now_offer_list_url, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    private static String geURLForBuyNowOfferTime(Context context) {
        return context.getResources().getString(C2723R.string.base_https_url) + context.getResources().getString(C2723R.string.buy_now_offer_close_time_url);
    }

    public void getBuyNowOfferStatus(Context context, String str, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) throws UnsupportedEncodingException {
        client.get(context, geURLForBuyNowOfferStatus(context, str, str2), (ResponseHandlerInterface) asyncHttpResponseHandler);
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.setTimeout(60000);
        client.setEnableRedirects(true, true, true);
    }

    private static String geURLForBuyNowOfferStatus(Context context, String str, String str2) {
        return context.getResources().getString(C2723R.string.base_https_url) + context.getResources().getString(C2723R.string.buy_now_offer_status_url, new Object[]{str, str2});
    }

    public void acceptBuyNowOffer(Context context, String str, String str2, String str3, String str4, String str5, AsyncHttpResponseHandler asyncHttpResponseHandler) throws UnsupportedEncodingException {
        client.get(context, geURLForAcceptBuyNowOffer(context, str, str2, str3, str4, str5), (ResponseHandlerInterface) asyncHttpResponseHandler);
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.setTimeout(60000);
        client.setEnableRedirects(true, true, true);
    }

    private static String geURLForAcceptBuyNowOffer(Context context, String str, String str2, String str3, String str4, String str5) {
        return context.getResources().getString(C2723R.string.base_https_url) + context.getResources().getString(C2723R.string.buy_now_offer_accept_url, new Object[]{str, str2, str3, str4, str5});
    }

    public void declineBuyNowOffer(Context context, String str, String str2, String str3, String str4, String str5, AsyncHttpResponseHandler asyncHttpResponseHandler) throws UnsupportedEncodingException {
        client.get(context, geURLForDeclineBuyNowOffer(context, str, str2, str3, str4, str5), (ResponseHandlerInterface) asyncHttpResponseHandler);
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.setTimeout(60000);
        client.setEnableRedirects(true, true, true);
    }

    private static String geURLForDeclineBuyNowOffer(Context context, String str, String str2, String str3, String str4, String str5) {
        return context.getResources().getString(C2723R.string.base_https_url) + context.getResources().getString(C2723R.string.buy_now_offer_decline_url, new Object[]{str, str2, str3, str4, str5});
    }

    public void getBuyNowOfferBidDetails(Context context, String str, String str2, String str3, String str4, AsyncHttpResponseHandler asyncHttpResponseHandler) throws UnsupportedEncodingException {
        client.get(context, geURLForBuyNowOfferDetail(context, str, str2, str3, str4), (ResponseHandlerInterface) asyncHttpResponseHandler);
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.setTimeout(60000);
        client.setEnableRedirects(true, true, true);
    }

    private String geURLForBuyNowOfferDetail(Context context, String str, String str2, String str3, String str4) {
        return context.getResources().getString(C2723R.string.base_https_url) + context.getResources().getString(C2723R.string.buy_now_offer_detail_url, new Object[]{str, str2, str3, str4});
    }
}
