package com.iaai.android.bdt.feature.login;

import androidx.core.app.NotificationCompat;
import com.iaai.android.bdt.model.login.AuctionRuleResponse;
import com.iaai.android.bdt.model.login.BDTForgotPasswordResponse;
import com.iaai.android.bdt.model.login.BDTLoginResponse;
import com.iaai.android.bdt.model.login.FCMTokenRequest;
import com.iaai.android.bdt.model.login.FCMTokenResponse;
import com.iaai.android.bdt.model.login.GenerateOTPResponse;
import com.iaai.android.bdt.model.termsofuse.TermsOfUseResponse;
import com.iaai.android.bdt.network.Repository;
import com.iaai.android.bdt.network.Service;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.constants.Constants;
import java.util.Arrays;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p011io.reactivex.Observable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\r\u001a\u00020\tJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0010\u001a\u00020\tJ\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tJ\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00062\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tJ\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tJ$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/login/LoginRepository;", "Lcom/iaai/android/bdt/network/Repository;", "service", "Lcom/iaai/android/bdt/network/Service;", "(Lcom/iaai/android/bdt/network/Service;)V", "acceptTermsOfUse", "Lio/reactivex/Observable;", "Lcom/iaai/android/bdt/model/termsofuse/TermsOfUseResponse;", "deviceId", "", "userId", "checkIsValidEmail", "", "email", "forgotPassword", "Lcom/iaai/android/bdt/model/login/BDTForgotPasswordResponse;", "username", "generateOTP", "Lcom/iaai/android/bdt/model/login/GenerateOTPResponse;", "getTermsOfUseAuctionRule", "Lcom/iaai/android/bdt/model/login/AuctionRuleResponse;", "password", "login", "Lcom/iaai/android/bdt/model/login/BDTLoginResponse;", "registerFCMToken", "Lcom/iaai/android/bdt/model/login/FCMTokenResponse;", "token", "saveTermsOfUseAuctionRule", "", "validateOTP", "otp", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: LoginRepository.kt */
public final class LoginRepository implements Repository {
    private final Service service;

    public final void saveTermsOfUseAuctionRule() {
    }

    @Inject
    public LoginRepository(@NotNull Service service2) {
        Intrinsics.checkParameterIsNotNull(service2, NotificationCompat.CATEGORY_SERVICE);
        this.service = service2;
    }

    @NotNull
    public final Observable<BDTLoginResponse> login(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = {str, str2};
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        Service service2 = this.service;
        String userAgent = Utils.getUserAgent();
        Intrinsics.checkExpressionValueIsNotNull(userAgent, "Utils.getUserAgent()");
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return service2.login(format, userAgent, language, "android");
    }

    @NotNull
    public final Observable<BDTForgotPasswordResponse> forgotPassword(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Service service2 = this.service;
        String userAgent = Utils.getUserAgent();
        Intrinsics.checkExpressionValueIsNotNull(userAgent, "Utils.getUserAgent()");
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return service2.forgotPassword(userAgent, str, language, "android");
    }

    @NotNull
    public final Observable<AuctionRuleResponse> getTermsOfUseAuctionRule(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = {str, str2};
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        Service service2 = this.service;
        String userAgent = Utils.getUserAgent();
        Intrinsics.checkExpressionValueIsNotNull(userAgent, "Utils.getUserAgent()");
        return service2.getTermsOfUseAuctionRule(format, userAgent);
    }

    @NotNull
    public final Observable<Boolean> checkIsValidEmail(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "email");
        Service service2 = this.service;
        String userAgent = Utils.getUserAgent();
        Intrinsics.checkExpressionValueIsNotNull(userAgent, "Utils.getUserAgent()");
        return service2.checkIsValidEmail(userAgent, str);
    }

    @NotNull
    public final Observable<GenerateOTPResponse> generateOTP(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        Intrinsics.checkParameterIsNotNull(str2, "email");
        Service service2 = this.service;
        String userAgent = Utils.getUserAgent();
        Intrinsics.checkExpressionValueIsNotNull(userAgent, "Utils.getUserAgent()");
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return service2.generateOTP(userAgent, str, str2, language, "android");
    }

    @NotNull
    public final Observable<GenerateOTPResponse> validateOTP(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        Intrinsics.checkParameterIsNotNull(str2, "otp");
        Service service2 = this.service;
        String userAgent = Utils.getUserAgent();
        Intrinsics.checkExpressionValueIsNotNull(userAgent, "Utils.getUserAgent()");
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return service2.validateOTP(userAgent, str, str2, language, "android");
    }

    @NotNull
    public final Observable<FCMTokenResponse> registerFCMToken(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkParameterIsNotNull(str, "username");
        Intrinsics.checkParameterIsNotNull(str2, "password");
        Intrinsics.checkParameterIsNotNull(str3, "token");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = {str, str2};
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        FCMTokenRequest fCMTokenRequest = new FCMTokenRequest("Android", str3);
        Service service2 = this.service;
        String userAgent = Utils.getUserAgent();
        Intrinsics.checkExpressionValueIsNotNull(userAgent, "Utils.getUserAgent()");
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return service2.registerFCMToken(format, userAgent, language, "android", fCMTokenRequest);
    }

    @NotNull
    public final Observable<TermsOfUseResponse> acceptTermsOfUse(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkParameterIsNotNull(str, Constants.DEVICEID_HEADER);
        Service service2 = this.service;
        String userAgent = Utils.getUserAgent();
        Intrinsics.checkExpressionValueIsNotNull(userAgent, "Utils.getUserAgent()");
        String deviceIPAddress = AppUtils.getDeviceIPAddress(true);
        Intrinsics.checkExpressionValueIsNotNull(deviceIPAddress, "AppUtils.getDeviceIPAddress(true)");
        return service2.acceptTermsOfUse(userAgent, str, "android", deviceIPAddress, "true", str2);
    }
}
