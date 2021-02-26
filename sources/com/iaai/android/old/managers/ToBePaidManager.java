package com.iaai.android.old.managers;

import android.text.TextUtils;
import android.util.Log;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.constants.ToBePaidSortOptions;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import roboguice.util.C5058Ln;

public class ToBePaidManager {
    private static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;
    private SessionManager sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();

    @Inject
    private ToBePaidManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
        client.addHeader("User-Agent", Utils.getUserAgent());
    }

    public void loadToBePaidInfo(String str, ToBePaidSortOptions toBePaidSortOptions, String str2, String str3, AsyncHttpResponseHandler asyncHttpResponseHandler, Boolean bool) {
        String string = this.application.getResources().getString(C2723R.string.service_path_get_tobePaid_info, new Object[]{this.sessionManager.getCurrentSessionUserId(), str, str2, toBePaidSortOptions.toWsParamString()});
        if (!TextUtils.isEmpty(str3) && !str3.equals("0")) {
            string = string + "&branchcode=" + str3;
        }
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + (string + "&getafcfee=" + bool), asyncHttpResponseHandler);
        client.setTimeout(60000);
    }

    public void loadToBePaidInfoWithPagination(String str, String str2, String str3, ToBePaidSortOptions toBePaidSortOptions, String str4, String str5, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String string = this.application.getResources().getString(C2723R.string.service_path_get_tobePaid_info_pagination, new Object[]{this.sessionManager.getCurrentSessionUserId(), str, str2, str3, str4, toBePaidSortOptions.toWsParamString()});
        if (!TextUtils.isEmpty(str5) && !str5.equals("0")) {
            string = string + "&branchcode=" + str5;
        }
        if (str4.equals(Constants.PAYMENT_OPTION_AFC)) {
            string = string + "&getafcfee=true";
        }
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + string, asyncHttpResponseHandler);
    }

    public void loadToBePaidFeesInfo(String str, int i, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String str3 = this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_path_get_tobePaid_fees_info, new Object[]{this.sessionManager.getCurrentSessionUserId(), str2, str, Integer.valueOf(i)});
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        StringBuilder sb = new StringBuilder();
        sb.append("servicePath-->");
        sb.append(str3);
        Log.d("servicePath--->", sb.toString());
        client.get(str3, asyncHttpResponseHandler);
    }

    public void getIpayInfoSpecificTerm(String str, String str2, String str3, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        if (str3.equals(Constants.PAYMENT_OPTION_AFC) || str3.equals(Constants.PAYMENT_OPTION_AFB)) {
            str2 = String.format("requestid=%s", new Object[]{str2});
        } else if (str3.equals(Constants.PAYMENT_OPTION_ACH)) {
            str2 = String.format("guididentifier=%s", new Object[]{str2});
        }
        String str4 = this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_path_get_tobePaid_review, new Object[]{this.sessionManager.getCurrentSessionUserId(), str2, str, str3});
        C5058Ln.m4829d("servicePath[%s]", str4);
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.get(str4, asyncHttpResponseHandler);
    }

    public void getIpayConfirmation(String str, String str2, String str3, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        if (str3.equals(Constants.PAYMENT_OPTION_AFC) || str3.equals(Constants.PAYMENT_OPTION_AFB)) {
            str2 = String.format("requestid=%s", new Object[]{str2});
        } else if (str3.equals(Constants.PAYMENT_OPTION_ACH)) {
            str2 = String.format("guididentifier=%s", new Object[]{str2});
        }
        String str4 = this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_path_get_tobePaid_confirmation, new Object[]{this.sessionManager.getCurrentSessionUserId(), str2, str, str3});
        C5058Ln.m4829d("servicePath[%s]", str4);
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.get(str4, asyncHttpResponseHandler);
    }

    public void getBranch(String str, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_path_get_branch_list, new Object[]{this.sessionManager.getCurrentSessionUserId(), str, str2}), asyncHttpResponseHandler);
    }

    public void login(String str, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        client.addHeader("Authorization", str + ":" + str2);
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_path_login), asyncHttpResponseHandler);
    }
}
