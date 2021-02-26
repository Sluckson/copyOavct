package com.iaai.android.old.managers;

import android.content.Context;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.constants.SortOption;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.io.UnsupportedEncodingException;
import p052cz.msebera.android.httpclient.entity.ByteArrayEntity;

public class ToBePickedUpManager {
    private static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;
    private SessionManager sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();

    @Inject
    private ToBePickedUpManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
        client.addHeader("User-Agent", Utils.getUserAgent());
    }

    public void loadToBePickedUpInfo(boolean z, int i, int i2, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_tobe_pickup, new Object[]{this.sessionManager.getCurrentSessionUserId(), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}), asyncHttpResponseHandler);
        client.setTimeout(60000);
    }

    public void loadToBePickedUpInfoWithSort(boolean z, int i, int i2, SortOption sortOption, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        if (i <= 0) {
            i = 1;
        }
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_tobe_pickup, new Object[]{this.sessionManager.getCurrentSessionUserId(), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2)}) + sortOption.toWsParamString(), asyncHttpResponseHandler);
        client.setTimeout(60000);
    }

    public void loadMyPulloutList(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_tobe_pickedup_mypullout), asyncHttpResponseHandler);
        client.setTimeout(60000);
    }

    public void loadPulloutDetailBasedOnPulloutID(int i, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_tobe_pickedup_mypullout_deatils, new Object[]{Integer.valueOf(i)}), asyncHttpResponseHandler);
        client.setTimeout(60000);
    }

    public void loadReviewPullOutList(Context context, String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        ByteArrayEntity byteArrayEntity;
        String str2 = this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_tobe_pickup_review_pullout);
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        try {
            byteArrayEntity = new ByteArrayEntity(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            byteArrayEntity = null;
        }
        client.post(context, str2, byteArrayEntity, "application/json", asyncHttpResponseHandler);
    }

    public void loadBrachPulloutList(Context context, String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        ByteArrayEntity byteArrayEntity;
        String str2 = this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_tobe_pickup_confirm_branch_pullout);
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        try {
            byteArrayEntity = new ByteArrayEntity(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            byteArrayEntity = null;
        }
        client.post(context, str2, byteArrayEntity, "application/json", asyncHttpResponseHandler);
    }

    public void sendAuctionFeedback(int i, String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        if (i == -1) {
            i = 1;
        }
        String str2 = this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_send_auction_feedback, new Object[]{"" + i, str, AppUtils.getDeviceIPAddress(true)});
        if (this.sessionManager.getCurrentSessionUserId() != null) {
            str2 = str2 + "&userid=" + this.sessionManager.getCurrentSessionUserId();
        }
        client.get(str2, asyncHttpResponseHandler);
        client.setTimeout(60000);
    }
}
