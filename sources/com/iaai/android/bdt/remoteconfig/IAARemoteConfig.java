package com.iaai.android.bdt.remoteconfig;

import android.util.Log;
import com.google.gson.Gson;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.model.ads.AdsUrl;
import com.iaai.android.bdt.model.announcement.AnnouncementMessage;
import com.iaai.android.bdt.model.deeplink.DeepLinkInfo;
import com.iaai.android.bdt.model.medalliainfo.MedalliaEvents;
import com.iaai.android.bdt.model.medalliainfo.MedalliaFBRemoteConfigModel;
import com.iaai.android.bdt.remoteconfig.FireBaseRemoteConfigKey;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u00103\u001a\u000204R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\u001a\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0011\"\u0004\b \u0010\u0013R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\u001a\u0010$\u001a\u00020%X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR\u001a\u0010-\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR\u001a\u00100\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0011\"\u0004\b2\u0010\u0013¨\u00065"}, mo66933d2 = {"Lcom/iaai/android/bdt/remoteconfig/IAARemoteConfig;", "", "()V", "adsURL", "Ljava/util/ArrayList;", "", "getAdsURL", "()Ljava/util/ArrayList;", "setAdsURL", "(Ljava/util/ArrayList;)V", "announcementMessage", "Lcom/iaai/android/bdt/model/announcement/AnnouncementMessage;", "getAnnouncementMessage", "setAnnouncementMessage", "borkerCommunityFlag", "", "getBorkerCommunityFlag", "()Z", "setBorkerCommunityFlag", "(Z)V", "deepLinkInfoList", "Lcom/iaai/android/bdt/model/deeplink/DeepLinkInfo;", "getDeepLinkInfoList", "setDeepLinkInfoList", "googlePlayBuyerAppVersion", "", "getGooglePlayBuyerAppVersion", "()J", "setGooglePlayBuyerAppVersion", "(J)V", "manageOfferHintFlag", "getManageOfferHintFlag", "setManageOfferHintFlag", "medalliaEvents", "getMedalliaEvents", "setMedalliaEvents", "medalliaFBRemoteConfigModel", "Lcom/iaai/android/bdt/model/medalliainfo/MedalliaFBRemoteConfigModel;", "getMedalliaFBRemoteConfigModel", "()Lcom/iaai/android/bdt/model/medalliainfo/MedalliaFBRemoteConfigModel;", "setMedalliaFBRemoteConfigModel", "(Lcom/iaai/android/bdt/model/medalliainfo/MedalliaFBRemoteConfigModel;)V", "minimumBuyerAppVersion", "getMinimumBuyerAppVersion", "setMinimumBuyerAppVersion", "softLoginTimeoutInMinutes", "getSoftLoginTimeoutInMinutes", "setSoftLoginTimeoutInMinutes", "vehicleGradeInformationFlag", "getVehicleGradeInformationFlag", "setVehicleGradeInformationFlag", "fetchAndActivateRemoteConfigValues", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: IAARemoteConfig.kt */
public final class IAARemoteConfig {
    @NotNull
    private ArrayList<String> adsURL = new ArrayList<>();
    @NotNull
    private ArrayList<AnnouncementMessage> announcementMessage = new ArrayList<>();
    private boolean borkerCommunityFlag;
    @NotNull
    private ArrayList<DeepLinkInfo> deepLinkInfoList = new ArrayList<>();
    private long googlePlayBuyerAppVersion = 1125;
    private boolean manageOfferHintFlag;
    @NotNull
    private ArrayList<String> medalliaEvents = new ArrayList<>();
    @NotNull
    public MedalliaFBRemoteConfigModel medalliaFBRemoteConfigModel;
    private long minimumBuyerAppVersion = 1125;
    private long softLoginTimeoutInMinutes = 240;
    private boolean vehicleGradeInformationFlag;

    @NotNull
    public final ArrayList<DeepLinkInfo> getDeepLinkInfoList() {
        return this.deepLinkInfoList;
    }

    public final void setDeepLinkInfoList(@NotNull ArrayList<DeepLinkInfo> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.deepLinkInfoList = arrayList;
    }

    @NotNull
    public final ArrayList<String> getMedalliaEvents() {
        return this.medalliaEvents;
    }

    public final void setMedalliaEvents(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.medalliaEvents = arrayList;
    }

    public final boolean getManageOfferHintFlag() {
        return this.manageOfferHintFlag;
    }

    public final void setManageOfferHintFlag(boolean z) {
        this.manageOfferHintFlag = z;
    }

    public final boolean getBorkerCommunityFlag() {
        return this.borkerCommunityFlag;
    }

    public final void setBorkerCommunityFlag(boolean z) {
        this.borkerCommunityFlag = z;
    }

    public final boolean getVehicleGradeInformationFlag() {
        return this.vehicleGradeInformationFlag;
    }

    public final void setVehicleGradeInformationFlag(boolean z) {
        this.vehicleGradeInformationFlag = z;
    }

    public final long getGooglePlayBuyerAppVersion() {
        return this.googlePlayBuyerAppVersion;
    }

    public final void setGooglePlayBuyerAppVersion(long j) {
        this.googlePlayBuyerAppVersion = j;
    }

    public final long getMinimumBuyerAppVersion() {
        return this.minimumBuyerAppVersion;
    }

    public final void setMinimumBuyerAppVersion(long j) {
        this.minimumBuyerAppVersion = j;
    }

    @NotNull
    public final ArrayList<AnnouncementMessage> getAnnouncementMessage() {
        return this.announcementMessage;
    }

    public final void setAnnouncementMessage(@NotNull ArrayList<AnnouncementMessage> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.announcementMessage = arrayList;
    }

    @NotNull
    public final ArrayList<String> getAdsURL() {
        return this.adsURL;
    }

    public final void setAdsURL(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.adsURL = arrayList;
    }

    @NotNull
    public final MedalliaFBRemoteConfigModel getMedalliaFBRemoteConfigModel() {
        MedalliaFBRemoteConfigModel medalliaFBRemoteConfigModel2 = this.medalliaFBRemoteConfigModel;
        if (medalliaFBRemoteConfigModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("medalliaFBRemoteConfigModel");
        }
        return medalliaFBRemoteConfigModel2;
    }

    public final void setMedalliaFBRemoteConfigModel(@NotNull MedalliaFBRemoteConfigModel medalliaFBRemoteConfigModel2) {
        Intrinsics.checkParameterIsNotNull(medalliaFBRemoteConfigModel2, "<set-?>");
        this.medalliaFBRemoteConfigModel = medalliaFBRemoteConfigModel2;
    }

    public final long getSoftLoginTimeoutInMinutes() {
        return this.softLoginTimeoutInMinutes;
    }

    public final void setSoftLoginTimeoutInMinutes(long j) {
        this.softLoginTimeoutInMinutes = j;
    }

    public final void fetchAndActivateRemoteConfigValues() {
        try {
            String string = IaaiApplication.getInstance().getmFirebaseRemoteConfig().getString(FireBaseRemoteConfigKey.FirebaseConfigKey.ANNOUNCEMENT.getValue());
            Intrinsics.checkExpressionValueIsNotNull(string, "IaaiApplication.getInsta…igKey.ANNOUNCEMENT.value)");
            String string2 = IaaiApplication.getInstance().getmFirebaseRemoteConfig().getString(FireBaseRemoteConfigKey.FirebaseConfigKey.DEEP_LINK.getValue());
            Intrinsics.checkExpressionValueIsNotNull(string2, "IaaiApplication.getInsta…onfigKey.DEEP_LINK.value)");
            String string3 = IaaiApplication.getInstance().getmFirebaseRemoteConfig().getString(FireBaseRemoteConfigKey.FirebaseConfigKey.MEDALLIA_CUSTOM_PARAMETER.getValue());
            Intrinsics.checkExpressionValueIsNotNull(string3, "IaaiApplication.getInsta…A_CUSTOM_PARAMETER.value)");
            String string4 = IaaiApplication.getInstance().getmFirebaseRemoteConfig().getString(FireBaseRemoteConfigKey.FirebaseConfigKey.MEDALLIA_INFO.getValue());
            Intrinsics.checkExpressionValueIsNotNull(string4, "IaaiApplication.getInsta…gKey.MEDALLIA_INFO.value)");
            long j = IaaiApplication.getInstance().getmFirebaseRemoteConfig().getLong(FireBaseRemoteConfigKey.FirebaseConfigKey.GOOGLE_PLAY_BUYER_APP_VERSION.getValue());
            long j2 = IaaiApplication.getInstance().getmFirebaseRemoteConfig().getLong(FireBaseRemoteConfigKey.FirebaseConfigKey.MINIMUM_BUYER_APP_VERSION.getValue());
            String string5 = IaaiApplication.getInstance().getmFirebaseRemoteConfig().getString(FireBaseRemoteConfigKey.FirebaseConfigKey.ADS_URL.getValue());
            Intrinsics.checkExpressionValueIsNotNull(string5, "IaaiApplication.getInsta…eConfigKey.ADS_URL.value)");
            if (!StringsKt.equals(string5, "", true)) {
                this.adsURL = ((AdsUrl) new Gson().fromJson(string5, AdsUrl.class)).getAdsUrl();
                this.adsURL.add(Constants_MVVM.LOCAL_TOW_BUYER_APP_ADV);
            } else {
                this.adsURL.clear();
            }
            this.manageOfferHintFlag = IaaiApplication.getInstance().getmFirebaseRemoteConfig().getBoolean(FireBaseRemoteConfigKey.FirebaseConfigKey.MANAGE_OFFER_HINT_SCREEN_FLAG.getValue());
            this.vehicleGradeInformationFlag = IaaiApplication.getInstance().getmFirebaseRemoteConfig().getBoolean(FireBaseRemoteConfigKey.FirebaseConfigKey.VEHICLE_GRADE_INFORMATION_FLAG.getValue());
            this.borkerCommunityFlag = IaaiApplication.getInstance().getmFirebaseRemoteConfig().getBoolean(FireBaseRemoteConfigKey.FirebaseConfigKey.BROKER_COMMUNITY_FLAG.getValue());
            Object fromJson = new Gson().fromJson(string, new IAARemoteConfig$fetchAndActivateRemoteConfigValues$1().getType());
            Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson(announce…ementMessage>>() {}.type)");
            this.announcementMessage = (ArrayList) fromJson;
            Object fromJson2 = new Gson().fromJson(string2, new IAARemoteConfig$fetchAndActivateRemoteConfigValues$2().getType());
            Intrinsics.checkExpressionValueIsNotNull(fromJson2, "Gson().fromJson(deepLink…DeepLinkInfo>>() {}.type)");
            this.deepLinkInfoList = (ArrayList) fromJson2;
            this.medalliaEvents = ((MedalliaEvents) new Gson().fromJson(string3, MedalliaEvents.class)).getEvents();
            Object fromJson3 = new Gson().fromJson(string4, MedalliaFBRemoteConfigModel.class);
            Intrinsics.checkExpressionValueIsNotNull(fromJson3, "Gson().fromJson(medallia…eConfigModel::class.java)");
            this.medalliaFBRemoteConfigModel = (MedalliaFBRemoteConfigModel) fromJson3;
            this.googlePlayBuyerAppVersion = j;
            this.minimumBuyerAppVersion = j2;
            this.softLoginTimeoutInMinutes = IaaiApplication.getInstance().getmFirebaseRemoteConfig().getLong(FireBaseRemoteConfigKey.FirebaseConfigKey.SOFT_LOGIN_TIMEOUT.getValue());
            Intrinsics.checkExpressionValueIsNotNull(IaaiApplication.getInstance().getmFirebaseRemoteConfig().getString("bdd_screen_flag"), "IaaiApplication.getInsta…String(\"bdd_screen_flag\")");
        } catch (Exception e) {
            Log.e("Exception", e.getMessage());
        }
    }
}
