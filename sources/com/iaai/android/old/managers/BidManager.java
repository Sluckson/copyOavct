package com.iaai.android.old.managers;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.safetynet.SafetyNet;
import com.google.android.gms.safetynet.SafetyNetApi;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.old.activities.IBidLiveActivity;
import com.iaai.android.old.activities.WowzaBidLiveFrameworkActivity;
import com.iaai.android.old.models.Bid;
import com.iaai.android.old.models.BidHistory;
import com.iaai.android.old.models.BidResult;
import com.iaai.android.old.models.IBidLiveAuthenticationResult;
import com.iaai.android.old.models.IBidLiveGetUrlResult;
import com.iaai.android.old.models.MDVehicle;
import com.iaai.android.old.models.Vehicle;
import com.iaai.android.old.models.WatchVehicleResult;
import com.iaai.android.old.service.ActivityBaseResultReceiver;
import com.iaai.android.old.service.CommandService;
import com.iaai.android.old.utils.ICommand;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.constants.ErrorType;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import com.iaai.android.old.utils.p016ui.MDActivityHelper;
import java.math.BigDecimal;
import java.util.ArrayList;

@Singleton
public class BidManager {
    private static final Bid BID_FOR_DELETION = new Bid(BigDecimal.valueOf(50), BigDecimal.valueOf(50));
    private static final int BID_MODE_DELETE = 2;
    private static final int BID_MODE_PLACE = 1;
    public static final String CAPTCHA_GOOGLE_CLIENT_KEY = "6LdV6agUAAAAACJZk--9Kx95uQ1f6PnqRCSUDu3N";
    private final Application application;
    FirebaseRemoteConfig firebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
    /* access modifiers changed from: private */
    public SessionManager sessionManager;

    @Inject
    BidManager(Provider<Application> provider) {
        this.application = provider.get();
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
    }

    /* access modifiers changed from: package-private */
    public void authenticateIbidLive(String str, String str2, ActivityBaseResultReceiver activityBaseResultReceiver, Boolean bool) {
        if (!this.sessionManager.isLoggedIn() && !bool.booleanValue()) {
            sendLoginRequiredViaResultReceiver(activityBaseResultReceiver);
        } else if (this.sessionManager.isLoggedIn() || !bool.booleanValue()) {
            CommandService.start((Context) this.application, this.application.getResources().getString(C2723R.string.service_path_ibidlive_authentication, new Object[]{str, str2}), (ResultReceiver) activityBaseResultReceiver, (Class<?>) IBidLiveAuthenticationResult.class, true);
        } else {
            String string = this.application.getResources().getString(C2723R.string.service_path_ibidlive_authentication, new Object[]{str, str2});
            CommandService.start((Context) this.application, string + Constants.VISITOR_TRUE, (ResultReceiver) activityBaseResultReceiver, (Class<?>) IBidLiveAuthenticationResult.class, false);
        }
    }

    /* access modifiers changed from: package-private */
    public void authenticateIbidLiveFromProductDetail(String str, String str2, ActivityBaseResultReceiver activityBaseResultReceiver, Boolean bool, Boolean bool2) {
        if (!this.sessionManager.isLoggedIn() && !bool.booleanValue()) {
            sendLoginRequiredViaResultReceiver(activityBaseResultReceiver);
        } else if (this.sessionManager.isLoggedIn() || !bool.booleanValue()) {
            String string = this.application.getResources().getString(C2723R.string.service_path_ibidlive_authentication, new Object[]{str, str2});
            if (bool2.booleanValue()) {
                string = string + "tablet";
            }
            CommandService.start((Context) this.application, string, (ResultReceiver) activityBaseResultReceiver, (Class<?>) IBidLiveAuthenticationResult.class, true);
        } else {
            String string2 = this.application.getResources().getString(C2723R.string.service_path_ibidlive_authentication, new Object[]{str, str2});
            if (bool2.booleanValue()) {
                string2 = string2 + "tablet";
            }
            CommandService.start((Context) this.application, string2 + Constants.VISITOR_TRUE, (ResultReceiver) activityBaseResultReceiver, (Class<?>) IBidLiveAuthenticationResult.class, false);
        }
    }

    /* access modifiers changed from: private */
    public void retrieveIBidLiveUrl(String str, String str2, ResultReceiver resultReceiver, Boolean bool, String str3) {
        String num = Integer.toString(Character.getNumericValue(str2.charAt(0)) - 9);
        String string = this.application.getResources().getString(C2723R.string.service_path_ibidlive_url, new Object[]{str, this.sessionManager.getCurrentSessionUserId(), num});
        if (str3.length() > 0) {
            string = string + "&token=" + str3;
        }
        if (bool.booleanValue()) {
            if (str3.length() > 0) {
                string = (this.application.getResources().getString(C2723R.string.service_path_ibidlive_url, new Object[]{str, "0", num}) + Constants.VISITOR_TRUE) + "&token=" + str3;
            } else {
                string = this.application.getResources().getString(C2723R.string.service_path_ibidlive_url, new Object[]{str, "0", num}) + Constants.VISITOR_TRUE;
            }
        }
        CommandService.start((Context) this.application, string, resultReceiver, (Class<?>) IBidLiveGetUrlResult.class, true);
    }

    /* access modifiers changed from: private */
    public void retrieveIBidLiveUrlFromProductDetail(String str, String str2, ResultReceiver resultReceiver, Boolean bool, Boolean bool2, String str3) {
        String num = Integer.toString(Character.getNumericValue(str2.charAt(0)) - 9);
        String string = this.application.getResources().getString(C2723R.string.service_path_ibidlive_url, new Object[]{str, this.sessionManager.getCurrentSessionUserId(), num});
        if (str3.length() > 0) {
            string = this.application.getResources().getString(C2723R.string.service_path_ibidlive_url, new Object[]{str, this.sessionManager.getCurrentSessionUserId(), num}) + "&token=" + str3;
        }
        if (bool.booleanValue()) {
            if (str3.length() > 0) {
                string = (this.application.getResources().getString(C2723R.string.service_path_ibidlive_url, new Object[]{str, "0", num}) + Constants.VISITOR_TRUE) + "&token=" + str3;
            } else {
                string = this.application.getResources().getString(C2723R.string.service_path_ibidlive_url, new Object[]{str, "0", num}) + Constants.VISITOR_TRUE;
            }
        }
        if (bool2.booleanValue()) {
            if (str3.length() > 0) {
                string = (string + "Tablet") + "&token=" + str3;
            } else {
                string = string + "Tablet";
            }
        }
        CommandService.start((Context) this.application, string, resultReceiver, (Class<?>) IBidLiveGetUrlResult.class, true);
    }

    public void placeBid(String str, String str2, Bid bid, ResultReceiver resultReceiver) {
        performBidAction(str, str2, bid, 1, resultReceiver);
    }

    public void deleteBid(String str, String str2, ResultReceiver resultReceiver) {
        performBidAction(str, str2, BID_FOR_DELETION, 2, resultReceiver);
    }

    private void sendLoginRequiredViaResultReceiver(ResultReceiver resultReceiver) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("errorType", ErrorType.LOGIN_REQUIRED);
        resultReceiver.send(2, bundle);
    }

    private void performBidAction(String str, String str2, Parcelable parcelable, int i, ResultReceiver resultReceiver) {
        if (!this.sessionManager.isLoggedIn()) {
            sendLoginRequiredViaResultReceiver(resultReceiver);
            return;
        }
        CommandService.start(this.application, this.application.getResources().getString(C2723R.string.service_path_prebid_place_bid, new Object[]{this.sessionManager.getCurrentSessionUserId(), str, str2, Integer.valueOf(i)}), parcelable, resultReceiver, BidResult.class, true);
    }

    public void loadBidHistory(String str, String str2, ResultReceiver resultReceiver) {
        if (!this.sessionManager.isLoggedIn()) {
            sendLoginRequiredViaResultReceiver(resultReceiver);
            return;
        }
        CommandService.start((Context) this.application, this.application.getResources().getString(C2723R.string.service_path_prebid_history, new Object[]{this.sessionManager.getCurrentSessionUserId(), str, str2}), resultReceiver, (Class<?>) BidHistory[].class, true);
    }

    public void launchIBidLive(Activity activity, String str, String str2, Boolean bool, boolean z) {
        authenticateIbidLive(str, str2, new IBidLiveResultReceiver(this, str, activity, new Handler(), bool, false, false), bool);
    }

    public void launchIBidLiveFromProductDetail(Activity activity, String str, String str2, Boolean bool, Boolean bool2) {
        authenticateIbidLiveFromProductDetail(str, str2, new IBidLiveResultReceiver(this, str, activity, new Handler(), bool, true, bool2.booleanValue()), bool, bool2);
    }

    public void addToWatchList(Vehicle vehicle, ResultReceiver resultReceiver) {
        CommandService.start((Context) this.application, this.application.getResources().getString(C2723R.string.service_path_watch_list_change, new Object[]{vehicle.itemId, this.sessionManager.getCurrentSessionUserId(), "add"}), resultReceiver, (Class<?>) WatchVehicleResult.class, true);
    }

    public void removeFromWatchList(Vehicle vehicle, ResultReceiver resultReceiver) {
        CommandService.start((Context) this.application, this.application.getResources().getString(C2723R.string.service_path_watch_list_change, new Object[]{vehicle.itemId, this.sessionManager.getCurrentSessionUserId(), "delete"}), resultReceiver, (Class<?>) WatchVehicleResult.class, true);
    }

    public void addToWatchList(MDVehicle mDVehicle, ResultReceiver resultReceiver) {
        CommandService.start((Context) this.application, this.application.getResources().getString(C2723R.string.service_path_watch_list_change, new Object[]{mDVehicle.itemId, this.sessionManager.getCurrentSessionUserId(), "add"}), resultReceiver, (Class<?>) WatchVehicleResult.class, true);
    }

    public void removeFromWatchList(MDVehicle mDVehicle, ResultReceiver resultReceiver) {
        CommandService.start((Context) this.application, this.application.getResources().getString(C2723R.string.service_path_watch_list_change, new Object[]{mDVehicle.itemId, this.sessionManager.getCurrentSessionUserId(), "delete"}), resultReceiver, (Class<?>) WatchVehicleResult.class, true);
    }

    public static class IBidLiveResultReceiver extends ActivityBaseResultReceiver<Activity, IBidLiveAuthenticationResult> {
        /* access modifiers changed from: private */
        public final BidManager bidManager;
        /* access modifiers changed from: private */
        public final String branchCode;
        /* access modifiers changed from: private */
        public final IBidLiveUrlResultReceiver iBidLiveUrlResultReceiver;
        /* access modifiers changed from: private */
        public final Boolean isNewProductDetail;
        /* access modifiers changed from: private */
        public final Boolean isTablet;
        /* access modifiers changed from: private */
        public final Boolean visitor;

        public IBidLiveResultReceiver(BidManager bidManager2, String str, Activity activity, Handler handler, Boolean bool, boolean z, boolean z2) {
            super(activity, handler);
            this.bidManager = bidManager2;
            this.branchCode = str;
            this.visitor = bool;
            this.isNewProductDetail = Boolean.valueOf(z);
            this.isTablet = Boolean.valueOf(z2);
            this.iBidLiveUrlResultReceiver = new IBidLiveUrlResultReceiver(activity, handler, bool.booleanValue(), str, z);
        }

        /* access modifiers changed from: protected */
        public void onSuccess(final Activity activity, IBidLiveAuthenticationResult iBidLiveAuthenticationResult) {
            if (iBidLiveAuthenticationResult.laneCount == 0) {
                if (this.isNewProductDetail.booleanValue()) {
                    MDActivityHelper.showAlert(activity, activity.getString(C2723R.string.dial_title_cannot_view_ibid_live), activity.getString(C2723R.string.msg_ibid_live_no_lane), (ICommand<DialogInterface>) null);
                } else {
                    ActivityHelper.showAlert(activity, activity.getString(C2723R.string.dial_title_cannot_view_ibid_live), activity.getString(C2723R.string.msg_ibid_live_no_lane), (ICommand<DialogInterface>) null);
                }
            } else if (iBidLiveAuthenticationResult.laneCount > 1) {
                C32301 r0 = new ICommand<String>() {
                    public void execute(final String str) {
                        IBidLiveResultReceiver.this.iBidLiveUrlResultReceiver.setLane(str);
                        boolean z = IBidLiveResultReceiver.this.bidManager.firebaseRemoteConfig.getBoolean(activity.getApplicationContext().getString(C2723R.string.captcha_parameter_name));
                        boolean z2 = IBidLiveResultReceiver.this.bidManager.firebaseRemoteConfig.getBoolean(activity.getApplicationContext().getString(C2723R.string.captcha_parameter_all_user));
                        if (IBidLiveResultReceiver.this.isNewProductDetail.booleanValue()) {
                            if (!z || (!z2 && !IBidLiveResultReceiver.this.bidManager.sessionManager.getCurrentSessionBuyerId().equalsIgnoreCase("0"))) {
                                IBidLiveResultReceiver.this.bidManager.retrieveIBidLiveUrlFromProductDetail(IBidLiveResultReceiver.this.branchCode, str, IBidLiveResultReceiver.this.iBidLiveUrlResultReceiver, IBidLiveResultReceiver.this.visitor, IBidLiveResultReceiver.this.isTablet, "");
                                return;
                            }
                            SafetyNet.getClient(activity.getApplicationContext()).verifyWithRecaptcha(activity.getApplicationContext().getString(C2723R.string.captcha_google_client_key)).addOnSuccessListener(activity, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                                public void onSuccess(SafetyNetApi.RecaptchaTokenResponse recaptchaTokenResponse) {
                                    Log.d("BidManager", "onSuccess");
                                    if (!recaptchaTokenResponse.getTokenResult().isEmpty()) {
                                        IBidLiveResultReceiver.this.bidManager.retrieveIBidLiveUrlFromProductDetail(IBidLiveResultReceiver.this.branchCode, str, IBidLiveResultReceiver.this.iBidLiveUrlResultReceiver, IBidLiveResultReceiver.this.visitor, IBidLiveResultReceiver.this.isTablet, recaptchaTokenResponse.getTokenResult());
                                    }
                                }
                            }).addOnFailureListener(activity, (OnFailureListener) new OnFailureListener() {
                                public void onFailure(@NonNull Exception exc) {
                                    if (exc instanceof ApiException) {
                                        Log.d("BidManager", "Error message: " + CommonStatusCodes.getStatusCodeString(((ApiException) exc).getStatusCode()));
                                        return;
                                    }
                                    Log.d("BidManager", "Unknown type of error: " + exc.getMessage());
                                }
                            });
                        } else if (!z || (!z2 && !IBidLiveResultReceiver.this.bidManager.sessionManager.getCurrentSessionBuyerId().equalsIgnoreCase("0"))) {
                            IBidLiveResultReceiver.this.bidManager.retrieveIBidLiveUrl(IBidLiveResultReceiver.this.branchCode, str, IBidLiveResultReceiver.this.iBidLiveUrlResultReceiver, IBidLiveResultReceiver.this.visitor, "");
                        } else {
                            SafetyNet.getClient(activity.getApplicationContext()).verifyWithRecaptcha(activity.getResources().getString(C2723R.string.captcha_google_client_key)).addOnSuccessListener(activity, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                                public void onSuccess(SafetyNetApi.RecaptchaTokenResponse recaptchaTokenResponse) {
                                    Log.d("BidManager", "onSuccess");
                                    if (!recaptchaTokenResponse.getTokenResult().isEmpty()) {
                                        IBidLiveResultReceiver.this.bidManager.retrieveIBidLiveUrl(IBidLiveResultReceiver.this.branchCode, str, IBidLiveResultReceiver.this.iBidLiveUrlResultReceiver, IBidLiveResultReceiver.this.visitor, recaptchaTokenResponse.getTokenResult());
                                    }
                                }
                            }).addOnFailureListener(activity, (OnFailureListener) new OnFailureListener() {
                                public void onFailure(@NonNull Exception exc) {
                                    if (exc instanceof ApiException) {
                                        Log.d("BidManager", "Error message: " + CommonStatusCodes.getStatusCodeString(((ApiException) exc).getStatusCode()));
                                        return;
                                    }
                                    Log.d("BidManager", "Unknown type of error: " + exc.getMessage());
                                }
                            });
                        }
                    }
                };
                ArrayList arrayList = new ArrayList();
                for (int i = 65; i < iBidLiveAuthenticationResult.laneCount + 65; i++) {
                    arrayList.add(Character.toString((char) i));
                }
                if (this.isNewProductDetail.booleanValue()) {
                    MDActivityHelper.promptSelection(activity, IaaiApplication.mContext.getString(C2723R.string.lbl_lane), arrayList, r0);
                } else {
                    ActivityHelper.promptSelection(activity, IaaiApplication.mContext.getString(C2723R.string.lbl_lane), arrayList, r0);
                }
            } else {
                boolean z = this.bidManager.firebaseRemoteConfig.getBoolean(activity.getApplicationContext().getString(C2723R.string.captcha_parameter_name));
                boolean z2 = this.bidManager.firebaseRemoteConfig.getBoolean(activity.getApplicationContext().getString(C2723R.string.captcha_parameter_all_user));
                if (!z || (!z2 && !this.bidManager.sessionManager.getCurrentSessionBuyerId().equalsIgnoreCase("0"))) {
                    this.iBidLiveUrlResultReceiver.setLane(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
                    this.bidManager.retrieveIBidLiveUrl(this.branchCode, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, this.iBidLiveUrlResultReceiver, this.visitor, "");
                    return;
                }
                SafetyNet.getClient(activity.getApplicationContext()).verifyWithRecaptcha(activity.getString(C2723R.string.captcha_google_client_key)).addOnSuccessListener(activity, new OnSuccessListener<SafetyNetApi.RecaptchaTokenResponse>() {
                    public void onSuccess(SafetyNetApi.RecaptchaTokenResponse recaptchaTokenResponse) {
                        Log.d("BidManager", "onSuccess");
                        if (!recaptchaTokenResponse.getTokenResult().isEmpty()) {
                            IBidLiveResultReceiver.this.iBidLiveUrlResultReceiver.setLane(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
                            IBidLiveResultReceiver.this.bidManager.retrieveIBidLiveUrl(IBidLiveResultReceiver.this.branchCode, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, IBidLiveResultReceiver.this.iBidLiveUrlResultReceiver, IBidLiveResultReceiver.this.visitor, recaptchaTokenResponse.getTokenResult());
                        }
                    }
                }).addOnFailureListener(activity, (OnFailureListener) new OnFailureListener() {
                    public void onFailure(@NonNull Exception exc) {
                        if (exc instanceof ApiException) {
                            ApiException apiException = (ApiException) exc;
                            Context applicationContext = activity.getApplicationContext();
                            Toast.makeText(applicationContext, "" + CommonStatusCodes.getStatusCodeString(apiException.getStatusCode()), 0).show();
                            Log.d("BidManager", "Error message: " + CommonStatusCodes.getStatusCodeString(apiException.getStatusCode()));
                            return;
                        }
                        Log.d("BidManager", "Unknown type of error: " + exc.getMessage());
                    }
                });
            }
        }
    }

    public static class IBidLiveUrlResultReceiver extends ActivityBaseResultReceiver<Activity, IBidLiveGetUrlResult> {
        String branchCode;
        boolean isNewProductDetail = false;
        String lane;
        boolean visitor = false;

        public IBidLiveUrlResultReceiver(Activity activity, Handler handler, boolean z, String str, boolean z2) {
            super(activity, handler);
            this.visitor = z;
            this.isNewProductDetail = z2;
            this.branchCode = str;
        }

        public void setLane(String str) {
            this.lane = Integer.toString(Character.getNumericValue(str.charAt(0)) - 9);
        }

        /* access modifiers changed from: protected */
        public void onSuccess(Activity activity, IBidLiveGetUrlResult iBidLiveGetUrlResult) {
            String str;
            String str2 = iBidLiveGetUrlResult.url;
            if (str2 == null) {
                str = null;
            } else {
                str = str2.replaceAll("[\"\\\\]", "");
            }
            if (TextUtils.isEmpty(str)) {
                if (this.isNewProductDetail) {
                    MDActivityHelper.showAlert(activity, activity.getString(C2723R.string.dial_title_cannot_view_ibid_live), iBidLiveGetUrlResult.message, (ICommand<DialogInterface>) null);
                } else {
                    ActivityHelper.showAlert(activity, activity.getString(C2723R.string.dial_title_cannot_view_ibid_live), iBidLiveGetUrlResult.message, (ICommand<DialogInterface>) null);
                }
            } else if (iBidLiveGetUrlResult.NFInd) {
                Intent intent = new Intent(activity, WowzaBidLiveFrameworkActivity.class);
                intent.putExtra("auction_now_url", str);
                activity.startActivity(intent);
            } else {
                Intent intent2 = new Intent(activity, IBidLiveActivity.class);
                intent2.putExtra("url", str);
                intent2.putExtra(Constants.EXTRA_IBIDLIVE_VISITOR, this.visitor);
                intent2.putExtra(Constants.EXTRA_IBIDLIVE_VISITOR_BRANCHCODE, this.branchCode);
                intent2.putExtra(Constants.EXTRA_IBIDLIVE_VISITOR_LANE, this.lane);
                activity.startActivity(intent2);
            }
        }
    }
}
