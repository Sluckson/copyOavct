package com.iaai.android.bdt.feature.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.model.login.BDTLoginResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import com.iaai.android.old.providers.IaaContent;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Singleton
@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b)\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 m2\u00020\u0001:\u0001mB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010P\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0002J\u0006\u0010Q\u001a\u00020MJ\u0006\u0010R\u001a\u00020MJ\u0006\u0010S\u001a\u00020MJ\b\u0010T\u001a\u0004\u0018\u00010\bJ\u000e\u0010U\u001a\u00020C2\u0006\u0010B\u001a\u00020CJ\u0006\u0010V\u001a\u000202J\u000e\u0010W\u001a\u0002022\u0006\u0010N\u001a\u00020OJ\u0006\u0010X\u001a\u000202J\u000e\u0010Y\u001a\u00020M2\u0006\u0010N\u001a\u00020OJ\"\u0010Z\u001a\u0002022\b\u0010[\u001a\u0004\u0018\u00010O2\b\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010^\u001a\u00020\u0004J\"\u0010_\u001a\u0002022\b\u0010[\u001a\u0004\u0018\u00010O2\b\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010^\u001a\u00020\u0004J\u0018\u0010b\u001a\u0002022\b\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010^\u001a\u00020\u0004J\"\u0010c\u001a\u0002022\b\u0010\\\u001a\u0004\u0018\u00010O2\b\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010^\u001a\u00020\u0004J\"\u0010d\u001a\u0002022\b\u0010\\\u001a\u0004\u0018\u00010O2\b\u0010`\u001a\u0004\u0018\u00010a2\u0006\u0010^\u001a\u00020\u0004J\u001e\u0010e\u001a\u00020M2\u0006\u0010f\u001a\u00020\b2\u0006\u0010g\u001a\u00020\b2\u0006\u0010h\u001a\u00020\bJ\u000e\u0010i\u001a\u00020M2\u0006\u0010j\u001a\u00020kJ&\u0010l\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010j\u001a\u00020k2\u0006\u0010g\u001a\u00020\b2\u0006\u0010h\u001a\u00020\bR\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0014\u0010\u000e\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\nR\u000e\u0010\u0010\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u0014\u0010\u0013\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\nR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\n\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\u0018R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\u0018R\u001c\u0010\"\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\u0018R\u001c\u0010%\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\u0018R\u001c\u0010(\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\u0018R\u001c\u0010+\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\u0018R\u001c\u0010.\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\u0018R\u001a\u00101\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00103\"\u0004\b7\u00105R\u001a\u00108\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00103\"\u0004\b9\u00105R\u001a\u0010:\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u00103\"\u0004\b;\u00105R\u001a\u0010<\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00103\"\u0004\b=\u00105R\u001a\u0010>\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00103\"\u0004\b?\u00105R\u001a\u0010@\u001a\u000202X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u00103\"\u0004\bA\u00105R\u001a\u0010B\u001a\u00020CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u0011\u0010H\u001a\u00020I¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010K¨\u0006n"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/login/SessionManager;", "", "()V", "MAX_NUMBER_OF_PIN_ATTEMPTS", "", "getMAX_NUMBER_OF_PIN_ATTEMPTS", "()I", "PREF_LAST_ALERT_ID", "", "getPREF_LAST_ALERT_ID", "()Ljava/lang/String;", "PREF_LAST_LOGIN_USER", "PREF_LAST_LOGIN_USER_INFO", "getPREF_LAST_LOGIN_USER_INFO", "PREF_SAVED_PASSWORD", "getPREF_SAVED_PASSWORD", "PREF_SAVED_PIN", "PREF_SAVED_USERNAME", "getPREF_SAVED_USERNAME", "PREF_SAVE_LOGIN_TIME_STAMP", "getPREF_SAVE_LOGIN_TIME_STAMP", "buyerEmployeeId", "getBuyerEmployeeId", "setBuyerEmployeeId", "(Ljava/lang/String;)V", "currentSessionBuyerId", "getCurrentSessionBuyerId", "setCurrentSessionBuyerId", "currentSessionFName", "getCurrentSessionFName", "setCurrentSessionFName", "currentSessionLName", "getCurrentSessionLName", "setCurrentSessionLName", "currentSessionPassword", "getCurrentSessionPassword", "setCurrentSessionPassword", "currentSessionStatusCode", "getCurrentSessionStatusCode", "setCurrentSessionStatusCode", "currentSessionUserId", "getCurrentSessionUserId", "setCurrentSessionUserId", "currentSessionUserZipCode", "getCurrentSessionUserZipCode", "setCurrentSessionUserZipCode", "currentSessionUsername", "getCurrentSessionUsername", "setCurrentSessionUsername", "isCurrentSessionUserAFCEligiable", "", "()Z", "setCurrentSessionUserAFCEligiable", "(Z)V", "isCurrentSessionUserIsLicensedBusinessAccount", "setCurrentSessionUserIsLicensedBusinessAccount", "isCurrentSessionUserIsPublic", "setCurrentSessionUserIsPublic", "isCurrentSessionUserOwner", "setCurrentSessionUserOwner", "isCurrentSessionUserlbsParentIndicator", "setCurrentSessionUserlbsParentIndicator", "isCurrentlbsBrokerBidderIndicator", "setCurrentlbsBrokerBidderIndicator", "isEnableInteract", "setEnableInteract", "loginTimeoutLimitMillis", "", "getLoginTimeoutLimitMillis", "()J", "setLoginTimeoutLimitMillis", "(J)V", "sharedPrefsHelper", "Lcom/iaai/android/bdt/utils/SharedPrefsHelper;", "getSharedPrefsHelper", "()Lcom/iaai/android/bdt/utils/SharedPrefsHelper;", "clearAll", "", "mContext", "Landroid/content/Context;", "clearDashboardCount", "clearLoginResponseObject", "clearSavedUserCredential", "clearSession", "getLastLoginUserId", "getTimeLeftTillLoginTimeout", "isLoggedIn", "isLoginTimeout", "isSoftLoginTimeout", "logout", "promptForLoginIfNeedFromActivity", "context", "activity", "Landroid/app/Activity;", "initiatedCode", "promptForLoginIfNeedFromFragment", "fragment", "Lcom/iaai/android/bdt/base/BaseFragment;", "promptForLoginIfNeededBDT", "promptForLoginIfNeededTabletBDT", "promptForSoftLogin", "saveUserCredential", "pin", "username", "password", "setLoginResponse", "result", "Lcom/iaai/android/bdt/model/login/BDTLoginResponse;", "setLoginResponseOnSuccess", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SessionManager.kt */
public final class SessionManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static SessionManager sessionManager;
    private final int MAX_NUMBER_OF_PIN_ATTEMPTS;
    @NotNull
    private final String PREF_LAST_ALERT_ID;
    private final String PREF_LAST_LOGIN_USER;
    @NotNull
    private final String PREF_LAST_LOGIN_USER_INFO;
    @NotNull
    private final String PREF_SAVED_PASSWORD;
    private final String PREF_SAVED_PIN;
    @NotNull
    private final String PREF_SAVED_USERNAME;
    @NotNull
    private final String PREF_SAVE_LOGIN_TIME_STAMP;
    @Nullable
    private volatile String buyerEmployeeId;
    @Nullable
    private volatile String currentSessionBuyerId;
    @Nullable
    private volatile String currentSessionFName;
    @Nullable
    private volatile String currentSessionLName;
    @Nullable
    private volatile String currentSessionPassword;
    @Nullable
    private volatile String currentSessionStatusCode;
    @Nullable
    private volatile String currentSessionUserId;
    @Nullable
    private volatile String currentSessionUserZipCode;
    @Nullable
    private volatile String currentSessionUsername;
    private volatile boolean isCurrentSessionUserAFCEligiable;
    private volatile boolean isCurrentSessionUserIsLicensedBusinessAccount;
    private volatile boolean isCurrentSessionUserIsPublic;
    private volatile boolean isCurrentSessionUserOwner;
    private volatile boolean isCurrentSessionUserlbsParentIndicator;
    private volatile boolean isCurrentlbsBrokerBidderIndicator;
    private volatile boolean isEnableInteract;
    private long loginTimeoutLimitMillis;
    @NotNull
    private final SharedPrefsHelper sharedPrefsHelper;

    private SessionManager() {
        this.MAX_NUMBER_OF_PIN_ATTEMPTS = 5;
        this.PREF_SAVED_PIN = "bdt_savedPin";
        this.PREF_SAVED_USERNAME = "bdt_savedUserName";
        this.PREF_SAVED_PASSWORD = "bdt_savedPassword";
        this.PREF_LAST_LOGIN_USER_INFO = "bdt_lastLoginUserInfo";
        this.PREF_LAST_LOGIN_USER = "bdt_lastLoginUser";
        this.PREF_SAVE_LOGIN_TIME_STAMP = "bdt_login_timeout_alarm";
        this.PREF_LAST_ALERT_ID = "bdt_lastAlertId";
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        this.sharedPrefsHelper = instance.getComponent().getPreferenceHelper();
    }

    public /* synthetic */ SessionManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int getMAX_NUMBER_OF_PIN_ATTEMPTS() {
        return this.MAX_NUMBER_OF_PIN_ATTEMPTS;
    }

    @NotNull
    public final String getPREF_SAVED_USERNAME() {
        return this.PREF_SAVED_USERNAME;
    }

    @NotNull
    public final String getPREF_SAVED_PASSWORD() {
        return this.PREF_SAVED_PASSWORD;
    }

    @NotNull
    public final String getPREF_LAST_LOGIN_USER_INFO() {
        return this.PREF_LAST_LOGIN_USER_INFO;
    }

    @NotNull
    public final String getPREF_SAVE_LOGIN_TIME_STAMP() {
        return this.PREF_SAVE_LOGIN_TIME_STAMP;
    }

    @NotNull
    public final String getPREF_LAST_ALERT_ID() {
        return this.PREF_LAST_ALERT_ID;
    }

    public final long getLoginTimeoutLimitMillis() {
        return this.loginTimeoutLimitMillis;
    }

    public final void setLoginTimeoutLimitMillis(long j) {
        this.loginTimeoutLimitMillis = j;
    }

    @NotNull
    public final SharedPrefsHelper getSharedPrefsHelper() {
        return this.sharedPrefsHelper;
    }

    @Nullable
    public final String getCurrentSessionUserId() {
        return this.currentSessionUserId;
    }

    public final void setCurrentSessionUserId(@Nullable String str) {
        this.currentSessionUserId = str;
    }

    @Nullable
    public final String getCurrentSessionUsername() {
        return this.currentSessionUsername;
    }

    public final void setCurrentSessionUsername(@Nullable String str) {
        this.currentSessionUsername = str;
    }

    @Nullable
    public final String getCurrentSessionPassword() {
        return this.currentSessionPassword;
    }

    public final void setCurrentSessionPassword(@Nullable String str) {
        this.currentSessionPassword = str;
    }

    @Nullable
    public final String getCurrentSessionUserZipCode() {
        return this.currentSessionUserZipCode;
    }

    public final void setCurrentSessionUserZipCode(@Nullable String str) {
        this.currentSessionUserZipCode = str;
    }

    public final boolean isCurrentSessionUserOwner() {
        return this.isCurrentSessionUserOwner;
    }

    public final void setCurrentSessionUserOwner(boolean z) {
        this.isCurrentSessionUserOwner = z;
    }

    public final boolean isCurrentSessionUserAFCEligiable() {
        return this.isCurrentSessionUserAFCEligiable;
    }

    public final void setCurrentSessionUserAFCEligiable(boolean z) {
        this.isCurrentSessionUserAFCEligiable = z;
    }

    public final boolean isCurrentSessionUserIsLicensedBusinessAccount() {
        return this.isCurrentSessionUserIsLicensedBusinessAccount;
    }

    public final void setCurrentSessionUserIsLicensedBusinessAccount(boolean z) {
        this.isCurrentSessionUserIsLicensedBusinessAccount = z;
    }

    public final boolean isCurrentSessionUserIsPublic() {
        return this.isCurrentSessionUserIsPublic;
    }

    public final void setCurrentSessionUserIsPublic(boolean z) {
        this.isCurrentSessionUserIsPublic = z;
    }

    public final boolean isCurrentSessionUserlbsParentIndicator() {
        return this.isCurrentSessionUserlbsParentIndicator;
    }

    public final void setCurrentSessionUserlbsParentIndicator(boolean z) {
        this.isCurrentSessionUserlbsParentIndicator = z;
    }

    @Nullable
    public final String getCurrentSessionBuyerId() {
        return this.currentSessionBuyerId;
    }

    public final void setCurrentSessionBuyerId(@Nullable String str) {
        this.currentSessionBuyerId = str;
    }

    @Nullable
    public final String getCurrentSessionFName() {
        return this.currentSessionFName;
    }

    public final void setCurrentSessionFName(@Nullable String str) {
        this.currentSessionFName = str;
    }

    @Nullable
    public final String getCurrentSessionLName() {
        return this.currentSessionLName;
    }

    public final void setCurrentSessionLName(@Nullable String str) {
        this.currentSessionLName = str;
    }

    @Nullable
    public final String getBuyerEmployeeId() {
        return this.buyerEmployeeId;
    }

    public final void setBuyerEmployeeId(@Nullable String str) {
        this.buyerEmployeeId = str;
    }

    @Nullable
    public final String getCurrentSessionStatusCode() {
        return this.currentSessionStatusCode;
    }

    public final void setCurrentSessionStatusCode(@Nullable String str) {
        this.currentSessionStatusCode = str;
    }

    public final boolean isCurrentlbsBrokerBidderIndicator() {
        return this.isCurrentlbsBrokerBidderIndicator;
    }

    public final void setCurrentlbsBrokerBidderIndicator(boolean z) {
        this.isCurrentlbsBrokerBidderIndicator = z;
    }

    public final boolean isEnableInteract() {
        return this.isEnableInteract;
    }

    public final void setEnableInteract(boolean z) {
        this.isEnableInteract = z;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/login/SessionManager$Companion;", "", "()V", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "get", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SessionManager.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Inject
        @NotNull
        public final SessionManager get() {
            if (SessionManager.sessionManager == null) {
                SessionManager.sessionManager = new SessionManager((DefaultConstructorMarker) null);
            }
            SessionManager access$getSessionManager$cp = SessionManager.sessionManager;
            if (access$getSessionManager$cp != null) {
                return access$getSessionManager$cp;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.login.SessionManager");
        }
    }

    public final void setLoginResponse(@NotNull BDTLoginResponse bDTLoginResponse) {
        Intrinsics.checkParameterIsNotNull(bDTLoginResponse, Constants.EXTRA_RESULT);
        this.currentSessionUserId = String.valueOf(bDTLoginResponse.getUserID());
        this.currentSessionUsername = this.sharedPrefsHelper.get(this.PREF_SAVED_USERNAME, "");
        this.currentSessionPassword = this.sharedPrefsHelper.get(this.PREF_SAVED_PASSWORD, "");
        this.currentSessionUserZipCode = bDTLoginResponse.getZipCode();
        Boolean owner = bDTLoginResponse.getOwner();
        boolean z = false;
        this.isCurrentSessionUserOwner = owner != null ? owner.booleanValue() : false;
        Boolean isAFC = bDTLoginResponse.isAFC();
        this.isCurrentSessionUserAFCEligiable = isAFC != null ? isAFC.booleanValue() : false;
        this.isCurrentSessionUserIsLicensedBusinessAccount = bDTLoginResponse.getIsLicensedBusinessAccount();
        this.isCurrentSessionUserIsPublic = bDTLoginResponse.getIsPublic();
        this.isEnableInteract = bDTLoginResponse.getEnableInteract();
        Boolean lbsParentIndicator = bDTLoginResponse.getLbsParentIndicator();
        this.isCurrentSessionUserlbsParentIndicator = lbsParentIndicator != null ? lbsParentIndicator.booleanValue() : false;
        Boolean lbsBrokerBidderIndicator = bDTLoginResponse.getLbsBrokerBidderIndicator();
        if (lbsBrokerBidderIndicator != null) {
            z = lbsBrokerBidderIndicator.booleanValue();
        }
        this.isCurrentlbsBrokerBidderIndicator = z;
        this.currentSessionBuyerId = String.valueOf(bDTLoginResponse.getBuyerId());
        this.currentSessionFName = bDTLoginResponse.getFName();
        this.currentSessionLName = bDTLoginResponse.getLName();
        this.buyerEmployeeId = String.valueOf(bDTLoginResponse.getBuyerEmployeeId());
    }

    public final void setLoginResponseOnSuccess(@NotNull Context context, @NotNull BDTLoginResponse bDTLoginResponse, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        Intrinsics.checkParameterIsNotNull(bDTLoginResponse, Constants.EXTRA_RESULT);
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        if (Intrinsics.areEqual((Object) bDTLoginResponse.getUserID(), (Object) "0")) {
            clearSession();
            return;
        }
        boolean z = false;
        try {
            String str3 = this.sharedPrefsHelper.get(this.PREF_SAVED_USERNAME, "");
            if (str3 != null && !str3.equals(str)) {
                context.getContentResolver().delete(IaaContent.Alert.CONTENT_URI, (String) null, (String[]) null);
                this.sharedPrefsHelper.put(this.PREF_LAST_ALERT_ID, 0);
                IAASharedPreference.setToBePaidSortSelction(context, 2);
                IaaiApplication.isUserLogin = true;
                IaaiApplication.isUserLoginForBuyNowOffer = true;
                AppUtils.resetNewCountPrefsOnLogout(context);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.sharedPrefsHelper.put(this.PREF_LAST_LOGIN_USER, String.valueOf(bDTLoginResponse.getUserID()));
        this.sharedPrefsHelper.put(this.PREF_SAVED_USERNAME, str);
        this.sharedPrefsHelper.put(this.PREF_SAVED_PASSWORD, str2);
        String json = new Gson().toJson((Object) bDTLoginResponse);
        SharedPrefsHelper sharedPrefsHelper2 = this.sharedPrefsHelper;
        String str4 = this.PREF_LAST_LOGIN_USER_INFO;
        Intrinsics.checkExpressionValueIsNotNull(json, "login_res");
        sharedPrefsHelper2.put(str4, json);
        this.sharedPrefsHelper.put(this.PREF_SAVE_LOGIN_TIME_STAMP, System.currentTimeMillis());
        this.currentSessionUserId = String.valueOf(bDTLoginResponse.getUserID());
        this.currentSessionUsername = str;
        this.currentSessionPassword = str2;
        this.currentSessionUserZipCode = bDTLoginResponse.getZipCode();
        Boolean owner = bDTLoginResponse.getOwner();
        this.isCurrentSessionUserOwner = owner != null ? owner.booleanValue() : false;
        Boolean isAFC = bDTLoginResponse.isAFC();
        this.isCurrentSessionUserAFCEligiable = isAFC != null ? isAFC.booleanValue() : false;
        this.isCurrentSessionUserIsLicensedBusinessAccount = bDTLoginResponse.getIsLicensedBusinessAccount();
        this.isCurrentSessionUserIsPublic = bDTLoginResponse.getIsPublic();
        this.isEnableInteract = bDTLoginResponse.getEnableInteract();
        Boolean lbsParentIndicator = bDTLoginResponse.getLbsParentIndicator();
        this.isCurrentSessionUserlbsParentIndicator = lbsParentIndicator != null ? lbsParentIndicator.booleanValue() : false;
        Boolean lbsBrokerBidderIndicator = bDTLoginResponse.getLbsBrokerBidderIndicator();
        if (lbsBrokerBidderIndicator != null) {
            z = lbsBrokerBidderIndicator.booleanValue();
        }
        this.isCurrentlbsBrokerBidderIndicator = z;
        this.currentSessionBuyerId = String.valueOf(bDTLoginResponse.getBuyerId());
        this.currentSessionFName = bDTLoginResponse.getFName();
        this.currentSessionLName = bDTLoginResponse.getLName();
        this.buyerEmployeeId = String.valueOf(bDTLoginResponse.getBuyerEmployeeId());
        this.currentSessionStatusCode = bDTLoginResponse.getStatusCode();
        IAASharedPreference.setUserIdPreferencesMVVM(context, String.valueOf(bDTLoginResponse.getUserID()));
        IAASharedPreference.setIsLoggedInPreferencesMVVM(context, true);
        Integer buyerId = bDTLoginResponse.getBuyerId();
        if (buyerId != null && buyerId.intValue() == 0) {
            IAAAnalytics.INSTANCE.registerUserProperties(String.valueOf(bDTLoginResponse.getUserID()), IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
        } else {
            IAAAnalytics.INSTANCE.registerUserProperties(String.valueOf(bDTLoginResponse.getUserID()), "0");
        }
    }

    public final long getTimeLeftTillLoginTimeout(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = 0;
        Long l = this.sharedPrefsHelper.get(this.PREF_SAVE_LOGIN_TIME_STAMP, 0);
        if (l != null) {
            j2 = l.longValue();
        }
        return j - (currentTimeMillis - j2);
    }

    public final boolean isLoginTimeout(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        String string = context.getString(C2723R.string.login_timeout_limit);
        Intrinsics.checkExpressionValueIsNotNull(string, "mContext.getString(R.string.login_timeout_limit)");
        return getTimeLeftTillLoginTimeout((long) ((((Integer.parseInt(string) * 24) * 60) * 60) * 1000)) <= 0;
    }

    public final boolean isSoftLoginTimeout() {
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        return getTimeLeftTillLoginTimeout((instance.getIAARemoteConfig().getSoftLoginTimeoutInMinutes() * ((long) 60)) * ((long) 1000)) <= 0;
    }

    public final boolean isLoggedIn() {
        String str = this.sharedPrefsHelper.get(this.PREF_LAST_LOGIN_USER_INFO, "");
        if (str != null) {
            if (str.length() > 0) {
                BDTLoginResponse bDTLoginResponse = (BDTLoginResponse) new Gson().fromJson(str, BDTLoginResponse.class);
                Intrinsics.checkExpressionValueIsNotNull(bDTLoginResponse, "loginResponse");
                setLoginResponse(bDTLoginResponse);
            }
        }
        return !TextUtils.isEmpty(this.currentSessionUsername);
    }

    public final void logout(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "mContext");
        clearAll(context);
        this.sharedPrefsHelper.put(this.PREF_SAVE_LOGIN_TIME_STAMP, 0);
        this.sharedPrefsHelper.put(Constants_MVVM.KEY_LAST_USED_PAYMENT_METHOD, "");
        IAASharedPreference.setEnteredZIPCode(context, "");
        IAASharedPreference.setIsLoggedInPreferencesMVVM(context, false);
        IAASharedPreference.setUserIdPreferencesMVVM(context, "");
    }

    private final void clearDashboardCount(Context context) {
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_MANAGE_OFFERS_MYACCOUNT, 0);
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_WATCHING_COUNT_MYACCOUNT, 0);
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_AWARD_PENDING_COUNT_MYACCOUNT, 0);
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_TOBEPAID_COUNT_MYACCOUNT, 0);
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_BUY_NOW_OFFER_COUNT_MYACCOUNT, 0);
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_TBPU_COUNT_MYACCOUNT, 0);
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_PREBID_COUNT_MYACCOUNT, 0);
        IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_NOTIFICATION_MYACCOUNT, 0);
    }

    private final void clearAll(Context context) {
        clearSession();
        this.sharedPrefsHelper.put(this.PREF_LAST_LOGIN_USER, "");
        this.sharedPrefsHelper.put(this.PREF_LAST_LOGIN_USER_INFO, "");
    }

    public final void clearSession() {
        String str = null;
        this.currentSessionUserId = str;
        this.currentSessionUsername = str;
        this.currentSessionPassword = str;
        this.currentSessionUserZipCode = str;
        this.isCurrentSessionUserOwner = false;
        this.isCurrentSessionUserAFCEligiable = false;
        this.isCurrentSessionUserIsLicensedBusinessAccount = false;
        this.isCurrentSessionUserIsPublic = false;
        this.isEnableInteract = false;
        this.isCurrentSessionUserlbsParentIndicator = false;
        this.isCurrentlbsBrokerBidderIndicator = false;
        this.currentSessionBuyerId = str;
        this.currentSessionFName = str;
        this.currentSessionLName = str;
        this.buyerEmployeeId = str;
        this.currentSessionStatusCode = str;
        this.sharedPrefsHelper.put(this.PREF_SAVE_LOGIN_TIME_STAMP, 0);
    }

    public final void clearLoginResponseObject() {
        this.sharedPrefsHelper.put(this.PREF_LAST_LOGIN_USER_INFO, "");
    }

    @Nullable
    public final String getLastLoginUserId() {
        return this.sharedPrefsHelper.get(this.PREF_LAST_LOGIN_USER, "");
    }

    public final boolean promptForLoginIfNeededBDT(@Nullable Activity activity, int i) {
        if (activity == null) {
            return true;
        }
        Intent intent = new Intent(activity, BDTLoginActivity.class);
        intent.putExtra(Constants.EXTRA_INITIATED_FOR, i);
        activity.startActivityForResult(intent, i);
        return true;
    }

    public final boolean promptForSoftLogin(@Nullable Context context, @Nullable BaseFragment baseFragment, int i) {
        if (context == null) {
            return true;
        }
        Intent intent = new Intent(context, BDTPromptPasswordDialogActivity.class);
        intent.putExtra(Constants.EXTRA_INITIATED_FOR, i);
        if (baseFragment == null) {
            return true;
        }
        baseFragment.startActivityForResult(intent, i);
        return true;
    }

    public final boolean promptForLoginIfNeededTabletBDT(@Nullable Context context, @Nullable BaseFragment baseFragment, int i) {
        if (context == null) {
            return true;
        }
        Intent intent = new Intent(context, BDTLoginActivity.class);
        intent.putExtra(Constants.EXTRA_INITIATED_FOR, i);
        if (baseFragment == null) {
            return true;
        }
        baseFragment.startActivityForResult(intent, i);
        return true;
    }

    public final boolean promptForLoginIfNeedFromFragment(@Nullable Context context, @Nullable BaseFragment baseFragment, int i) {
        if (!isLoggedIn()) {
            Intent intent = new Intent(context, BDTLoginActivity.class);
            intent.putExtra(Constants.EXTRA_INITIATED_FOR, i);
            if (baseFragment == null) {
                return true;
            }
            baseFragment.startActivityForResult(intent, i);
            return true;
        } else if (!isSoftLoginTimeout()) {
            return false;
        } else {
            Intent intent2 = new Intent(context, BDTPromptPasswordDialogActivity.class);
            intent2.putExtra(Constants.EXTRA_INITIATED_FOR, i);
            if (baseFragment == null) {
                return true;
            }
            baseFragment.startActivityForResult(intent2, i);
            return true;
        }
    }

    public final boolean promptForLoginIfNeedFromActivity(@Nullable Context context, @Nullable Activity activity, int i) {
        if (!isLoggedIn()) {
            Intent intent = new Intent(context, BDTLoginActivity.class);
            intent.putExtra(Constants.EXTRA_INITIATED_FOR, i);
            if (activity == null) {
                return true;
            }
            activity.startActivityForResult(intent, i);
            return true;
        } else if (!isSoftLoginTimeout()) {
            return false;
        } else {
            Intent intent2 = new Intent(context, BDTPromptPasswordDialogActivity.class);
            intent2.putExtra(Constants.EXTRA_INITIATED_FOR, i);
            if (activity == null) {
                return true;
            }
            activity.startActivityForResult(intent2, i);
            return true;
        }
    }

    public final void saveUserCredential(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, Constants.EXTRA_PIN);
        Intrinsics.checkParameterIsNotNull(str2, "username");
        Intrinsics.checkParameterIsNotNull(str3, "password");
        this.sharedPrefsHelper.put(this.PREF_SAVED_USERNAME, str2);
        this.sharedPrefsHelper.put(this.PREF_SAVED_PASSWORD, str3);
    }

    public final void clearSavedUserCredential() {
        saveUserCredential("", "", "");
    }
}
