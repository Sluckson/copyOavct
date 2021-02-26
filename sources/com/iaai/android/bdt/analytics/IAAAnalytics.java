package com.iaai.android.bdt.analytics;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.old.utils.constants.Constants;
import com.salesforce.marketingcloud.p022d.p023a.C4002i;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\u001d\u001e\u0005\u001f B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bJ\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\rJ\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u0004J\u0016\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\r¨\u0006!"}, mo66933d2 = {"Lcom/iaai/android/bdt/analytics/IAAAnalytics;", "", "()V", "logIAAEvent", "", "IAAEvents", "Lcom/iaai/android/bdt/analytics/IAAAnalytics$IAAEvents;", "bundle", "Landroid/os/Bundle;", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "logNetworkEvent", "method", "", "success", "", "query", "error", "logScreenName", "screenName", "context", "Landroid/app/Activity;", "Landroidx/fragment/app/FragmentActivity;", "fragment", "Lcom/iaai/android/bdt/base/BaseFragment;", "registerAppVersionUserProperty", "registerUserProperties", "userId", "isGuest", "FireBaseKeyNames", "FireBaseValueNames", "IAAScreenName", "UserProperty", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: IAAAnalytics.kt */
public final class IAAAnalytics {
    public static final IAAAnalytics INSTANCE = new IAAAnalytics();

    private IAAAnalytics() {
    }

    public final void logNetworkEvent(@NotNull String str, boolean z, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkParameterIsNotNull(str, FirebaseAnalytics.Param.METHOD);
        Intrinsics.checkParameterIsNotNull(str2, "query");
        FireBaseAnalytics.INSTANCE.logFireBaseNetworkEvent(str, z, str2, str3);
    }

    public final void logScreenName(@NotNull String str, @NotNull Activity activity) {
        Intrinsics.checkParameterIsNotNull(str, "screenName");
        Intrinsics.checkParameterIsNotNull(activity, "context");
        FireBaseAnalytics.INSTANCE.logFireBaseScreenName(str, activity);
    }

    public final void logScreenName(@NotNull String str, @NotNull FragmentActivity fragmentActivity, @NotNull BaseFragment baseFragment) {
        Intrinsics.checkParameterIsNotNull(str, "screenName");
        Intrinsics.checkParameterIsNotNull(fragmentActivity, "context");
        Intrinsics.checkParameterIsNotNull(baseFragment, "fragment");
        FireBaseAnalytics.INSTANCE.logFireBaseScreenName(str, fragmentActivity, baseFragment);
    }

    public final void registerUserProperties(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkParameterIsNotNull(str, "userId");
        Intrinsics.checkParameterIsNotNull(str2, "isGuest");
        FireBaseAnalytics.INSTANCE.registerFireBaseUserProperties(str, str2);
    }

    public final void registerAppVersionUserProperty() {
        FireBaseAnalytics.INSTANCE.registerFireAppVersionUserProperty();
    }

    public final void logIAAEvent(@NotNull IAAEvents iAAEvents, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(iAAEvents, "IAAEvents");
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        if (instance.getIAARemoteConfig().getMedalliaEvents().contains(iAAEvents.getId())) {
            MedalliaAnalytics.INSTANCE.logMedalliaIntercept(iAAEvents, bundle, (SessionManager) null);
        }
        FireBaseAnalytics.INSTANCE.logFireBaseEvent(iAAEvents, bundle);
    }

    public final void logIAAEvent(@NotNull IAAEvents iAAEvents, @Nullable Bundle bundle, @Nullable SessionManager sessionManager) {
        Intrinsics.checkParameterIsNotNull(iAAEvents, "IAAEvents");
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        if (instance.getIAARemoteConfig().getMedalliaEvents().contains(iAAEvents.getId())) {
            MedalliaAnalytics.INSTANCE.logMedalliaIntercept(iAAEvents, bundle, sessionManager);
        }
        FireBaseAnalytics.INSTANCE.logFireBaseEvent(iAAEvents, bundle);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/analytics/IAAAnalytics$UserProperty;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "USER_ID", "IS_GUEST", "APP_VERSION", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: IAAAnalytics.kt */
    public enum UserProperty {
        USER_ID("user_id"),
        IS_GUEST("is_guest"),
        APP_VERSION(C4002i.C4003a.f2856q);
        
        @NotNull

        /* renamed from: id */
        private final String f501id;

        private UserProperty(String str) {
            this.f501id = str;
        }

        @NotNull
        public final String getId() {
            return this.f501id;
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001d¨\u0006\u001e"}, mo66933d2 = {"Lcom/iaai/android/bdt/analytics/IAAAnalytics$IAAScreenName;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "HOME", "AUCTION_LIST", "SALE_LIST", "VEHICLE_DETAIL", "COST_CALCULATOR", "PRE_BID", "PRE_BID_CONFIRMATION", "PRE_BID_COMPLETED", "TIME_AUCTION_BID", "TIME_AUCTION_BID_CONFIRMATION", "TIME_AUCTION_BID_COMPLETED", "CHROME_DATA", "BID_LIVE", "FIND_VEHICLE", "SALE_LIST_SORT", "WATCH_LIST_SORT", "SALE_LIST_FILTER", "SEARCH_RESULT_LIST_SORT", "SEARCH_RESULT_LIST_FILTER", "SEARCH_RESULT_LIST", "IMAGE_360_VIEW", "IMAGE_HD_VIEW", "IMAGE_VIEW", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: IAAAnalytics.kt */
    public enum IAAScreenName {
        HOME("home"),
        AUCTION_LIST("auction_list"),
        SALE_LIST("sale_list"),
        VEHICLE_DETAIL("vehicle_detail"),
        COST_CALCULATOR("cost_calculator"),
        PRE_BID("pre_bid"),
        PRE_BID_CONFIRMATION("pre_bid_confirmation"),
        PRE_BID_COMPLETED("pre_bid_completed"),
        TIME_AUCTION_BID("time_auction_bid"),
        TIME_AUCTION_BID_CONFIRMATION("time_auction_bid_confirmation"),
        TIME_AUCTION_BID_COMPLETED("time_auction_bid_completed"),
        CHROME_DATA("chrome_data"),
        BID_LIVE("bid_live"),
        FIND_VEHICLE("find_vehicle"),
        SALE_LIST_SORT("sale_list_sort"),
        WATCH_LIST_SORT("watch_list_sort"),
        SALE_LIST_FILTER("sale_list_filter"),
        SEARCH_RESULT_LIST_SORT("search_result_list_sort"),
        SEARCH_RESULT_LIST_FILTER("search_result_list_filter"),
        SEARCH_RESULT_LIST("search_result_list"),
        IMAGE_360_VIEW("image_360_view"),
        IMAGE_HD_VIEW("image_hd_view"),
        IMAGE_VIEW("image_view");
        
        @NotNull
        private final String value;

        private IAAScreenName(String str) {
            this.value = str;
        }

        @NotNull
        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006\""}, mo66933d2 = {"Lcom/iaai/android/bdt/analytics/IAAAnalytics$IAAEvents;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "JOIN_AUCTION", "BID_LIVE", "PRE_BID", "TIMED_AUCTION", "BUY_NOW", "BUY_NOW_OFFER_ACCEPT", "BUY_NOW_OFFER_DECLINE", "VIEW_360", "ENGINE_VIDEO", "KEY_IMAGE", "HD_IMAGE", "GRID_IMAGE", "FIND_VEHICLE_FILTER_USAGE", "SEARCH_RESULT_FILTER_USAGE", "FIND_VEHICLE_KEYWORD_USAGE", "SEARCH_RESULT_KEYWORD_USAGE", "MAKE_AND_MODEL_FILTER_USAGE", "AUCTION_SALES_LIST", "FEATURE_AUCTION_SALES_LIST", "ADD_TO_CART", "ECOMMERCE_PURCHASE", "PAYMENT", "DOWNLOAD_IMAGES", "SHARE_VEHICLE", "SEARCH_SUCCESS", "CLOSE_AUCTION_NOW", "TIRE_TREAD_IMAGE", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: IAAAnalytics.kt */
    public enum IAAEvents {
        JOIN_AUCTION("join_auction"),
        BID_LIVE("bid_live"),
        PRE_BID("pre_bid"),
        TIMED_AUCTION("timed_auction"),
        BUY_NOW("buy_now"),
        BUY_NOW_OFFER_ACCEPT("buy_now_offer_accept"),
        BUY_NOW_OFFER_DECLINE("buy_now_offer_decline"),
        VIEW_360("360_view"),
        ENGINE_VIDEO("engine_video"),
        KEY_IMAGE("key_image"),
        HD_IMAGE("hd_image"),
        GRID_IMAGE("grid_image"),
        FIND_VEHICLE_FILTER_USAGE("find_vehicle_filter_usage"),
        SEARCH_RESULT_FILTER_USAGE("search_result_filter_usage"),
        FIND_VEHICLE_KEYWORD_USAGE("find_vehicle_keyword_usage"),
        SEARCH_RESULT_KEYWORD_USAGE("search_result_keyword_usage"),
        MAKE_AND_MODEL_FILTER_USAGE("make_and_model_filter_usage"),
        AUCTION_SALES_LIST("auction_sales_list"),
        FEATURE_AUCTION_SALES_LIST("feature_auction_sales_list"),
        ADD_TO_CART(FirebaseAnalytics.Event.ADD_TO_CART),
        ECOMMERCE_PURCHASE(FirebaseAnalytics.Event.ECOMMERCE_PURCHASE),
        PAYMENT("payment"),
        DOWNLOAD_IMAGES("download_images"),
        SHARE_VEHICLE("share_vehicle"),
        SEARCH_SUCCESS("search_result_page_load"),
        CLOSE_AUCTION_NOW("close_auction_now"),
        TIRE_TREAD_IMAGE("Tire_Tread_image");
        
        @NotNull

        /* renamed from: id */
        private final String f500id;

        private IAAEvents(String str) {
            this.f500id = str;
        }

        @NotNull
        public final String getId() {
            return this.f500id;
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/analytics/IAAAnalytics$FireBaseKeyNames;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "COUNT", "VALUE", "CURRENCY", "ITEM_ID", "ORIGIN", "SOURCE", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: IAAAnalytics.kt */
    public enum FireBaseKeyNames {
        COUNT("count"),
        VALUE("value"),
        CURRENCY(FirebaseAnalytics.Param.CURRENCY),
        ITEM_ID("item_id"),
        ORIGIN("origin"),
        SOURCE(FirebaseAnalytics.Param.SOURCE);
        
        @NotNull

        /* renamed from: id */
        private final String f498id;

        private FireBaseKeyNames(String str) {
            this.f498id = str;
        }

        @NotNull
        public final String getId() {
            return this.f498id;
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/analytics/IAAAnalytics$FireBaseValueNames;", "", "id", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "PRE_BID", "TIMED_AUCTION", "BUY_NOW", "BUY_NOW_OFFER", "IPay", "AFC", "USD", "PAY_PAL", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: IAAAnalytics.kt */
    public enum FireBaseValueNames {
        PRE_BID("PRE_BID"),
        TIMED_AUCTION("TIMED_AUCTION"),
        BUY_NOW("BUY_NOW"),
        BUY_NOW_OFFER("BUY_NOW_OFFER"),
        IPay("iPay"),
        AFC(Constants.PAYMENT_OPTION_AFC),
        USD("USD"),
        PAY_PAL("PayPal");
        
        @NotNull

        /* renamed from: id */
        private final String f499id;

        private FireBaseValueNames(String str) {
            this.f499id = str;
        }

        @NotNull
        public final String getId() {
            return this.f499id;
        }
    }
}
