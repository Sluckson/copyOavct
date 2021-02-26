package com.iaai.android.old.managers;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.activities.IBidLiveActivity;
import com.iaai.android.old.utils.constants.Constants;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class FetchIBidLiveAuctionURLManager {
    /* access modifiers changed from: private */
    public static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;
    FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
    /* access modifiers changed from: private */
    public SessionManager sessionManager;

    @Inject
    private FetchIBidLiveAuctionURLManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
    }

    public void loadIBidAuctionURLs(AsyncHttpResponseHandler asyncHttpResponseHandler, String str, String str2, boolean z, final IBidLiveActivity iBidLiveActivity) {
        boolean z2 = this.firebaseRemoteConfig.getBoolean(this.application.getResources().getString(C2723R.string.captcha_parameter_name));
        boolean z3 = this.firebaseRemoteConfig.getBoolean(this.application.getApplicationContext().getString(C2723R.string.captcha_parameter_all_user));
        if (!z2 || (!z3 && !this.sessionManager.getCurrentSessionBuyerId().equalsIgnoreCase("0"))) {
            client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
            client.addHeader("User-Agent", Utils.getUserAgent());
            client.get(this.application.getResources().getString(C2723R.string.base_https_url) + getIBidLiveURL(str, str2, z), asyncHttpResponseHandler);
            return;
        }
        final String str3 = str;
        final String str4 = str2;
        final boolean z4 = z;
        final AsyncHttpResponseHandler asyncHttpResponseHandler2 = asyncHttpResponseHandler;
        SafetyNet.getClient(this.application.getApplicationContext()).verifyWithRecaptcha(this.application.getResources().getString(C2723R.string.captcha_google_client_key)).addOnSuccessListener((Activity) iBidLiveActivity, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
            public void onSuccess(SafetyNetApi.RecaptchaTokenResponse recaptchaTokenResponse) {
                Log.d("BidManager", "onSuccess");
                if (!recaptchaTokenResponse.getTokenResult().isEmpty()) {
                    FetchIBidLiveAuctionURLManager.client.addHeader("Authorization", FetchIBidLiveAuctionURLManager.this.sessionManager.getCurrentSessionUsername() + ":" + FetchIBidLiveAuctionURLManager.this.sessionManager.getCurrentSessionPassword());
                    FetchIBidLiveAuctionURLManager.client.addHeader("User-Agent", Utils.getUserAgent());
                    FetchIBidLiveAuctionURLManager.client.get((FetchIBidLiveAuctionURLManager.this.application.getResources().getString(C2723R.string.base_https_url) + FetchIBidLiveAuctionURLManager.this.getIBidLiveURL(str3, str4, z4)) + "&token=" + recaptchaTokenResponse.getTokenResult(), asyncHttpResponseHandler2);
                }
            }
        }).addOnFailureListener((Activity) iBidLiveActivity, (OnFailureListener) new OnFailureListener() {
            public void onFailure(@NonNull Exception exc) {
                if (exc instanceof ApiException) {
                    ApiException apiException = (ApiException) exc;
                    IBidLiveActivity iBidLiveActivity = iBidLiveActivity;
                    Toast.makeText(iBidLiveActivity, "" + CommonStatusCodes.getStatusCodeString(apiException.getStatusCode()), 0).show();
                    Log.d("BidManager", "Error message: " + CommonStatusCodes.getStatusCodeString(apiException.getStatusCode()));
                    return;
                }
                Log.d("BidManager", "Unknown type of error: " + exc.getMessage());
            }
        });
    }

    /* access modifiers changed from: private */
    public String getIBidLiveURL(String str, String str2, boolean z) {
        String string = this.application.getResources().getString(C2723R.string.service_path_ibidlive_url, new Object[]{str, this.sessionManager.getCurrentSessionUserId(), str2});
        if (!z) {
            return string;
        }
        return this.application.getResources().getString(C2723R.string.service_path_ibidlive_url, new Object[]{str, "0", str2}) + Constants.VISITOR_TRUE;
    }
}
