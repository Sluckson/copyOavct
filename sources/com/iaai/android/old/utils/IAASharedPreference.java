package com.iaai.android.old.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.constants.Constants;

public class IAASharedPreference {
    public static void saveTncInPrefs(Context context) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tnc", 0).edit();
        edit.putBoolean("tnc_flag", true);
        edit.commit();
    }

    public static boolean getTncFlagFromPrefs(Context context) {
        return context.getSharedPreferences("tnc", 0).getBoolean("tnc_flag", false);
    }

    public static void saveTncTimeStampFromPrefs(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tnc", 0).edit();
        edit.putString("tnc_timestamp", str);
        edit.commit();
    }

    public static String getTncTimeStampFromPrefs(Context context) {
        return context.getSharedPreferences("tnc", 0).getString("tnc_timestamp", "");
    }

    public static void saveDayComplete(Context context, boolean z) {
        Log.e("saveDayComplete to ->", "" + z);
        SharedPreferences.Editor edit = context.getSharedPreferences("recent_auction", 0).edit();
        edit.putBoolean("recent_auction_list", z);
        edit.commit();
    }

    public static boolean isDayOver(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = context.getSharedPreferences("recent_auction", 0);
        long j = sharedPreferences.getLong("suggestion_last_update", currentTimeMillis);
        long j2 = (currentTimeMillis - j) / 1000;
        if (j == currentTimeMillis) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong("suggestion_last_update", currentTimeMillis);
            edit.commit();
        }
        if (j2 <= ((long) Constants.SUGGSATION_DB_REFRESH_INTREVAL)) {
            return false;
        }
        SharedPreferences.Editor edit2 = sharedPreferences.edit();
        edit2.putLong("suggestion_last_update", currentTimeMillis);
        edit2.commit();
        return true;
    }

    public static void saveDayCompleteForFastSearch(Context context, boolean z) {
        Log.e("saveDayComplete to ->", "" + z);
        SharedPreferences.Editor edit = context.getSharedPreferences("fast_search_recent_auction", 0).edit();
        edit.putBoolean("recent_auction_list", z);
        edit.commit();
    }

    public static boolean isDayOverForFastSearch(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences sharedPreferences = context.getSharedPreferences("fast_search_recent_auction", 0);
        long j = sharedPreferences.getLong("fast_search_suggestion_last_update", currentTimeMillis);
        long j2 = (currentTimeMillis - j) / 1000;
        if (j == currentTimeMillis) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong("fast_search_suggestion_last_update", currentTimeMillis);
            edit.commit();
        }
        if (j2 <= ((long) Constants.SUGGSATION_DB_REFRESH_INTREVAL)) {
            return false;
        }
        SharedPreferences.Editor edit2 = sharedPreferences.edit();
        edit2.putLong("fast_search_suggestion_last_update", currentTimeMillis);
        edit2.commit();
        return true;
    }

    public static void setAlarmForRecentAuction(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("recent_auction", 0).edit();
        edit.putBoolean("recent_auction_alarm", z);
        edit.commit();
    }

    public static boolean isAlarmSetForRecentAuction(Context context) {
        return context.getSharedPreferences("recent_auction", 0).getBoolean("recent_auction_alarm", false);
    }

    public static void setLoginTimeInMillis(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("login_timeout", 0).edit();
        edit.putLong("login_timeout_alarm", j);
        edit.commit();
    }

    public static long getLoginTimeInMillis(Context context) {
        return context.getSharedPreferences("login_timeout", 0).getLong("login_timeout_alarm", 0);
    }

    public static void setSoftLoginUsername(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("soft_login", 0).edit();
        edit.putString("soft_login_user", str);
        edit.commit();
    }

    public static String getSoftLoginUsername(Context context) {
        return context.getSharedPreferences("soft_login", 0).getString("soft_login_user", "");
    }

    public static void setSoftLoginPassword(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("soft_login", 0).edit();
        edit.putString("soft_login_pwd", str);
        edit.commit();
    }

    public static String getSoftLoginPassword(Context context) {
        return context.getSharedPreferences("soft_login", 0).getString("soft_login_pwd", "");
    }

    public static void setPrefForTips(Context context, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences("tips_pref", 0).edit();
        edit.putBoolean("tips_shown", z);
        edit.commit();
    }

    public static boolean getPrefForTips(Context context) {
        return context.getSharedPreferences("tips_pref", 0).getBoolean("tips_shown", false);
    }

    public static void setMyAccountCount(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putInt(str + "count", i);
        edit.commit();
    }

    public static int getDashBoardCount(Context context, String str) {
        return context.getSharedPreferences(str, 0).getInt(str, 0);
    }

    public static void setDashBoardCount(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putInt(str, i);
        edit.commit();
    }

    public static int getMyAccountCount(Context context, String str) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        return sharedPreferences.getInt(str + "count", 0);
    }

    public static void setEnteredZIPCode(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("entered_zipcode", 0).edit();
        edit.putString("entered_zipcode", str);
        edit.commit();
    }

    public static String getEnteredZIPCode(Context context) {
        return context.getSharedPreferences("entered_zipcode", 0).getString("entered_zipcode", "");
    }

    public static void setUserIdPreferencesMVVM(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putString("USER_ID", str);
        edit.apply();
    }

    public static void setIsLoggedInPreferencesMVVM(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("IS_USER_LOGGED_IN", bool.booleanValue());
        edit.apply();
    }

    public static String getUserIdPreferencesMVVM(Context context) {
        return context.getSharedPreferences("preferences_mvvm", 0).getString("USER_ID", "");
    }

    public static Boolean getIsLoggedInPreferencesMVVM(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("IS_USER_LOGGED_IN", false));
    }

    public static void setSalesInfoViewLessPreferencesMVVM(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("SALESINFO_VIEW_LESS", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getSalesInfoViewLessPreferencesMVVM(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("SALESINFO_VIEW_LESS", true));
    }

    public static void setVCconditionViewLessPreferencesMVVM(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("CONDITION_VIEW_LESS", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getVCConditionViewLessPreferencesMVVM(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("CONDITION_VIEW_LESS", true));
    }

    public static void setVinDetailsViewLessPreferencesMVVM(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("VINDETAILS_VIEW_LESS", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getVinDetailsViewLessPreferencesMVVM(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("VINDETAILS_VIEW_LESS", true));
    }

    public static void setBiddingInfoViewLessPreferencesMVVM(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("BIDDING_INFO_VIEW_LESS", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getBiddingInfoViewLessPreferencesMVVM(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("BIDDING_INFO_VIEW_LESS", false));
    }

    public static void setPartsViewLessPreferencesMVVM(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("PART_VIEW_LESS", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getPartsViewLessPreferencesMVVM(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("PART_VIEW_LESS", false));
    }

    public static void setEstimateCostValue(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("estimate_cost_preferences_mvvm", 0).edit();
        edit.putString(str2, str);
        edit.apply();
    }

    public static String getEstimateCostValue(Context context, String str) {
        return context.getSharedPreferences("estimate_cost_preferences_mvvm", 0).getString(str, "");
    }

    public static void setZipCodeValue(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("zip_cost_preferences_mvvm", 0).edit();
        edit.putString(str2 + "_key", str);
        edit.apply();
    }

    public static String getZipCodeValue(Context context, String str) {
        return context.getSharedPreferences("zip_cost_preferences_mvvm", 0).getString(str + "_key", "");
    }

    public static void setEstimateFinalCostValue(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("estimate_cost_preferences_mvvm", 0).edit();
        edit.putString(str2 + "_key1", str);
        edit.apply();
    }

    public static String getEstimateFinalCostValue(Context context, String str) {
        return context.getSharedPreferences("estimate_cost_preferences_mvvm", 0).getString(str + "_key1", "");
    }

    public static void setYearFilterPreferencesMVVM(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putString("year_filter", str);
        edit.apply();
    }

    public static String getYearFilterPreferencesMVVM(Context context) {
        return context.getSharedPreferences("preferences_mvvm", 0).getString("year_filter", "");
    }

    public static void setLaneFilterPreferencesMVVM(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putString("lane_filter", str);
        edit.apply();
    }

    public static String getLaneFilterPreferencesMVVM(Context context) {
        return context.getSharedPreferences("preferences_mvvm", 0).getString("lane_filter", "");
    }

    public static void setLossTypeFilterPreferencesMVVM(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putString("losstype_filter", str);
        edit.apply();
    }

    public static String getLossLypeFilterPreferencesMVVM(Context context) {
        return context.getSharedPreferences("preferences_mvvm", 0).getString("losstype_filter", "");
    }

    public static void setLossTypeItemPosPreferencesMVVM(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putInt("loss_type_position", i);
        edit.apply();
    }

    public static int getLossTypeItemPosFilterPreferencesMVVM(Context context) {
        return context.getSharedPreferences("preferences_mvvm", 0).getInt("loss_type_position", 0);
    }

    public static void setLastUpdateSortPreferencesMVVM(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putString("last_updated", str);
        edit.apply();
    }

    public static String getlastUpdatSortFilterPreferencesMVVM(Context context) {
        return context.getSharedPreferences("preferences_mvvm", 0).getString("last_updated", "");
    }

    public static void setSortItemPositionPreferencesMVVM(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putInt("sort_item_position", i);
        edit.apply();
    }

    public static int getSortItemPositionFilterPreferencesMVVM(Context context) {
        return context.getSharedPreferences("preferences_mvvm", 0).getInt("sort_item_position", 0);
    }

    public static void setSortDirectionPreferencesMVVM(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putString(Constants_MVVM.EXTRA_SORT_DIRECTION, str);
        edit.apply();
    }

    public static String getSortDirectionPositionFilterPreferencesMVVM(Context context) {
        return context.getSharedPreferences("preferences_mvvm", 0).getString(Constants_MVVM.EXTRA_SORT_DIRECTION, "");
    }

    public static void setSortItemPreferencesMVVM(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putString(Constants_MVVM.EXTRA_SORT_BY, str);
        edit.apply();
    }

    public static String getSortItemFilterPreferencesMVVM(Context context) {
        return context.getSharedPreferences("preferences_mvvm", 0).getString(Constants_MVVM.EXTRA_SORT_BY, "");
    }

    public static void setStartYearFilterPreferencesMVVM(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putString("year_start_filter", str);
        edit.apply();
    }

    public static String getStartYearFilterPreferencesMVVM(Context context) {
        return context.getSharedPreferences("preferences_mvvm", 0).getString("year_start_filter", "");
    }

    public static void setEndYearFilterPreferencesMVVM(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putString("year_end_filter", str);
        edit.apply();
    }

    public static String getEndYearFilterPreferencesMVVM(Context context) {
        return context.getSharedPreferences("preferences_mvvm", 0).getString("year_end_filter", "");
    }

    public static void setIsFirstRun(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("is_first_run", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getIsFirstRun(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("is_first_run", true));
    }

    public static void setVehicleQuickFilterViewLess(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("QUICK_FILTER_VIEW_LESS", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getVehicleQuickFilterViewLess(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("QUICK_FILTER_VIEW_LESS", false));
    }

    public static void setWatchStatus(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("is_watching", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getWatchStatus(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("is_watching", false));
    }

    public static void setRecentalyUsedModel(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_makemodel", 0).edit();
        edit.putString("makemodel_json", str);
        edit.apply();
    }

    public static String getRecentalyUsedModel(Context context) {
        return context.getSharedPreferences("preferences_makemodel", 0).getString("makemodel_json", "");
    }

    public static void setRecentlyUsedFacetModel(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("facet_makemodel", 0).edit();
        edit.putString("facet_json", str);
        edit.apply();
    }

    public static String getRecentlyUsedFacetModel(Context context) {
        return context.getSharedPreferences("facet_makemodel", 0).getString("facet_json", "");
    }

    public static void setMakeModelMasterData(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_make_model_master", 0).edit();
        edit.putString("make_model_master_json", str);
        edit.apply();
    }

    public static String getMakeModelMasterData(Context context) {
        return context.getSharedPreferences("preferences_make_model_master", 0).getString("make_model_master_json", "");
    }

    public static void setMakeModelMasterDataTimeStamp(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_make_model_master_time_stamp", 0).edit();
        edit.putLong("make_model_master_time_stamp", j);
        edit.apply();
    }

    public static long getMakeModelMasterDataTimeStamp(Context context) {
        return context.getSharedPreferences("preferences_make_model_master_time_stamp", 0).getLong("make_model_master_time_stamp", 0);
    }

    public static void setRefinerTimeStamp(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_refiner_time_stamp", 0).edit();
        edit.putLong("refiner_time_stamp", j);
        edit.apply();
    }

    public static long getRefinerTimeStamp(Context context) {
        return context.getSharedPreferences("preferences_refiner_time_stamp", 0).getLong("refiner_time_stamp", 0);
    }

    public static void setNewFacetTimeStamp(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_facets_time_stamp", 0).edit();
        edit.putLong("facets_time_stamp", j);
        edit.apply();
    }

    public static long getNewFacetTimeStamp(Context context) {
        return context.getSharedPreferences("preferences_facets_time_stamp", 0).getLong("facets_time_stamp", 0);
    }

    public static void setRefinerJson(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_refiner", 0).edit();
        edit.putString("refiner_json", str);
        edit.apply();
    }

    public static String getRefinerJson(Context context) {
        return context.getSharedPreferences("preferences_refiner", 0).getString("refiner_json", "");
    }

    public static void setFacetJson(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_facets", 0).edit();
        edit.putString("facets_json", str);
        edit.apply();
    }

    public static String getFacetJson(Context context) {
        return context.getSharedPreferences("preferences_facets", 0).getString("facets_json", "");
    }

    public static void setLastUsedZipCode(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_zip_code", 0).edit();
        edit.putString(Constants_MVVM.SORT_ZIPCODE_KEY, str);
        edit.apply();
    }

    public static String getLastUsedZipCode(Context context) {
        return context.getSharedPreferences("preferences_zip_code", 0).getString(Constants_MVVM.SORT_ZIPCODE_KEY, "");
    }

    public static void setSelectedFilter(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_selected_selected_filter", 0).edit();
        edit.putString("selected_filter", str);
        edit.apply();
    }

    public static String getSelectedFilter(Context context) {
        return context.getSharedPreferences("preferences_selected_selected_filter", 0).getString("selected_filter", "");
    }

    public static void setSelectedMakeModelFilter(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_selected_selected_make_model_filter", 0).edit();
        edit.putString("selected_make_model_filter", str);
        edit.apply();
    }

    public static String getSelectedMakeModelFilter(Context context) {
        return context.getSharedPreferences("preferences_selected_selected_make_model_filter", 0).getString("selected_make_model_filter", "");
    }

    public static void setRefinerSearch(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_selected_selected_filter", 0).edit();
        edit.putString("selected_refiner_search", str);
        edit.apply();
    }

    public static String getRefinerSearch(Context context) {
        return context.getSharedPreferences("preferences_selected_selected_filter", 0).getString("selected_refiner_search", "");
    }

    public static void setIsFirstLaunchForProductDetail(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("is_first_launch_product_detail", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getIsFirstLaunchForProductDetail(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("is_first_launch_product_detail", true));
    }

    public static void setIsFirstLaunchFindVehicles(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("is_first_launch_find_vehicles", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getIsFirstLaunchFindVehicles(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("is_first_launch_find_vehicles", true));
    }

    public static void setIsFirstLaunchForEngineVideoProductDetail(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("is_first_launch_engine_video_product_detail", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getIsFirstLaunchForEngineVideoProductDetail(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("is_first_launch_engine_video_product_detail", true));
    }

    public static void setLastDownloadID(Context context, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_last_download_id", 0).edit();
        edit.putLong("last_download_id", j);
        edit.apply();
    }

    public static Long getLastDownloadID(Context context) {
        return Long.valueOf(context.getSharedPreferences("preferences_last_download_id", 0).getLong("last_download_id", -1));
    }

    public static void setRecentSearchDataAuction(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_recent_search_auction", 0).edit();
        edit.putString("recent_search_json", str);
        edit.apply();
    }

    public static String getRecentSearchDataAuction(Context context) {
        return context.getSharedPreferences("preferences_recent_search_auction", 0).getString("recent_search_json", "");
    }

    public static void setRecentSearchDataVehicles(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_recent_search_vehicles", 0).edit();
        edit.putString("recent_search_json", str);
        edit.apply();
    }

    public static String getRecentSearchDataVehicles(Context context) {
        return context.getSharedPreferences("preferences_recent_search_vehicles", 0).getString("recent_search_json", "");
    }

    public static void setCreditCard(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_last_selected_cc", 0).edit();
        edit.putString("last_selected_cc", str);
        edit.apply();
    }

    public static String getCreditCard(Context context) {
        return context.getSharedPreferences("preferences_last_selected_cc", 0).getString("last_selected_cc", "");
    }

    public static void setIsFirstLaunchForManageofferHome(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("is_first_launch_manage_offer_home", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getIsFirstLaunchForManageofferHome(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("is_first_launch_manage_offer_home", true));
    }

    public static void setIsFirstLaunchForManageofferMyAccount(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("is_first_launch_manage_offer_my_account", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getIsFirstLaunchForManageofferMyAccount(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("is_first_launch_manage_offer_my_account", true));
    }

    public static void setShowMyVehicle(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_show_my_vehicle", 0).edit();
        edit.putBoolean(Constants_MVVM.BDT_SHOW_MY_VEHICLE, bool.booleanValue());
        edit.apply();
    }

    public static boolean getShowMyVehicle(Context context) {
        return context.getSharedPreferences("preferences_show_my_vehicle", 0).getBoolean(Constants_MVVM.BDT_SHOW_MY_VEHICLE, true);
    }

    public static void setToBePaidSortSelction(Context context, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putInt("to_be_paid_sort_selection", i);
        edit.apply();
    }

    public static int getToBePaidSortSelection(Context context) {
        return context.getSharedPreferences("preferences_mvvm", 0).getInt("to_be_paid_sort_selection", 2);
    }

    public static void setIsFirstLaunchForPaymentMethodPayPal(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("is_first_launch_payment_method_payPal", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getIsFirstLaunchForPaymentMethodPayPal(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("is_first_launch_payment_method_payPal", true));
    }

    public static void setSearchMappingData(Context context, String str) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_search_mapping_master", 0).edit();
        edit.putString("search_mapping_json", str);
        edit.apply();
    }

    public static String getSearchMappingData(Context context) {
        return context.getSharedPreferences("preferences_search_mapping_master", 0).getString("search_mapping_json", "");
    }

    public static void setIsFirstLaunchForFastSearch(Context context, Boolean bool) {
        SharedPreferences.Editor edit = context.getSharedPreferences("preferences_mvvm", 0).edit();
        edit.putBoolean("is_first_launch_fast_search", bool.booleanValue());
        edit.apply();
    }

    public static Boolean getIsFirstLaunchForFastSearch(Context context) {
        return Boolean.valueOf(context.getSharedPreferences("preferences_mvvm", 0).getBoolean("is_first_launch_fast_search", true));
    }
}
