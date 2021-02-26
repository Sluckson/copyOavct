package com.iaai.android.old.managers;

import android.app.Application;
import android.content.SharedPreferences;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

@Singleton
public class SimpleRepository {
    private static final String PREF_FAILED_PIN_ENTRY_COUNT = "failedPinEntryCount";
    private static final String PREF_LAST_ACTION_MILLIS = "lastActionMillis";
    private static final String PREF_LAST_ALERT_ID = "lastAlertId";
    private static final String PREF_LAST_BIDDING_BENCHMARK_DATE = "biddingBenchMarkDate";
    private static final String PREF_LAST_LOGIN_USER = "lastLoginUser";
    private static final String PREF_LAST_LOGIN_USER_INFO = "lastLoginUserInfo";
    private static final String PREF_LAST_SEARCH_SCOPE = "lasrSearchScope";
    private static final String PREF_LAST_SEARCH_SORT = "lasrSearchSort";
    private static final String PREF_LAST_USED_ZIPCODE = "lastUsedZip";
    private static final String PREF_MY_VEHICLES_SORT = "myVehiclesSort";
    private static final String PREF_RUN_LIST_SORT = "runListSort";
    private static final String PREF_SAVED_PASSWORD = "savedPassword";
    private static final String PREF_SAVED_PIN = "savedPin";
    private static final String PREF_SAVED_USERNAME = "savedUserName";
    private static final String PREF_SENDER_ID = "sendId";
    private final Application app;
    private volatile String biddingBenchMarkDate;
    private volatile String c2mdSenderId = null;
    private volatile int failedPinEntryCount = -1;
    private volatile long lastActionMillis = -1;
    private volatile int lastAlertId = -1;
    private volatile String lastLoginUser;
    private volatile String lastSearchScope;
    private volatile String lastSearchSort;
    private volatile String lastUsedZip;
    private volatile String loginresponse_str = null;
    private volatile String myVehiclesSort;
    final SharedPreferences prefs;
    private volatile String runListSort;
    private volatile String savedPassword;
    private volatile String savedPin;
    private volatile String savedUsername;

    @Inject
    private SimpleRepository(Provider<Application> provider, Provider<SharedPreferences> provider2) {
        this.app = provider.get();
        this.prefs = provider2.get();
    }

    public String getC2mdSenderId() {
        if (this.c2mdSenderId == null) {
            this.c2mdSenderId = this.prefs.getString("sendId", "");
        }
        return this.c2mdSenderId;
    }

    public void setC2mdSenderId(String str) {
        this.c2mdSenderId = str;
        persist("sendId", str);
    }

    public int getLastAlertId() {
        if (this.lastAlertId == -1) {
            this.lastAlertId = this.prefs.getInt(PREF_LAST_ALERT_ID, 0);
        }
        return this.lastAlertId;
    }

    public void setLastAlertId(int i) {
        this.lastAlertId = i;
        persist(PREF_LAST_ALERT_ID, i);
    }

    public long getLastActionMillis() {
        if (this.lastActionMillis == -1) {
            this.lastActionMillis = this.prefs.getLong(PREF_LAST_ACTION_MILLIS, 0);
        }
        return this.lastActionMillis;
    }

    public void setLastActionMillis(long j) {
        this.lastActionMillis = j;
        persist(PREF_LAST_ACTION_MILLIS, j);
    }

    public String getSavedPin() {
        this.savedPin = this.prefs.getString(PREF_SAVED_PIN, "");
        return this.savedPin;
    }

    public void setSavedPin(String str) {
        this.savedPin = str;
        persist(PREF_SAVED_PIN, str);
    }

    public String getSavedUsername() {
        this.savedUsername = this.prefs.getString(PREF_SAVED_USERNAME, "");
        return this.savedUsername;
    }

    public void setSavedUsername(String str) {
        this.savedUsername = str;
        persist(PREF_SAVED_USERNAME, str);
    }

    public String getSavedPassword() {
        this.savedPassword = this.prefs.getString(PREF_SAVED_PASSWORD, "");
        return this.savedPassword;
    }

    public void setSavedPassword(String str) {
        this.savedPassword = str;
        persist(PREF_SAVED_PASSWORD, str);
    }

    public int getFailedPinEntryCount() {
        this.failedPinEntryCount = this.prefs.getInt(PREF_FAILED_PIN_ENTRY_COUNT, 0);
        return this.failedPinEntryCount;
    }

    public void setFailedPinEntryCount(int i) {
        this.failedPinEntryCount = i;
        persist(PREF_FAILED_PIN_ENTRY_COUNT, this.failedPinEntryCount);
    }

    public String getLastLoginUser() {
        this.lastLoginUser = this.prefs.getString(PREF_LAST_LOGIN_USER, "");
        return this.lastLoginUser;
    }

    public void setLastLoginUser(String str) {
        this.lastLoginUser = str;
        persist(PREF_LAST_LOGIN_USER, str);
    }

    public String getLoginResponseObjectString() {
        this.loginresponse_str = this.prefs.getString(PREF_LAST_LOGIN_USER_INFO, "");
        return this.loginresponse_str;
    }

    public void setLoginResponseObject(String str) {
        this.lastLoginUser = str;
        persist(PREF_LAST_LOGIN_USER_INFO, str);
    }

    public String getLastUsedZip() {
        this.lastUsedZip = this.prefs.getString(PREF_LAST_USED_ZIPCODE, "");
        return this.lastUsedZip;
    }

    public void setLastUsedZip(String str) {
        this.lastUsedZip = str;
        persist(PREF_LAST_USED_ZIPCODE, str);
    }

    public void setVehicleSearchSort(String str) {
        this.lastSearchSort = str;
        persist(PREF_LAST_SEARCH_SORT, str);
    }

    public String getLastSearchSort() {
        if (this.lastSearchSort == null) {
            this.lastSearchSort = this.prefs.getString(PREF_LAST_SEARCH_SORT, "");
        }
        return this.lastSearchSort;
    }

    public void setVehicleSearchScope(String str) {
        this.lastSearchSort = str;
        persist(PREF_LAST_SEARCH_SCOPE, str);
    }

    public String getLastSearchScope() {
        this.lastSearchScope = this.prefs.getString(PREF_LAST_SEARCH_SCOPE, "");
        return this.lastSearchScope;
    }

    public void setRunListSort(String str) {
        this.runListSort = str;
        persist(PREF_RUN_LIST_SORT, str);
    }

    public String getRunListSort() {
        this.runListSort = this.prefs.getString(PREF_RUN_LIST_SORT, "");
        return this.runListSort;
    }

    public void setMyVehiclesSort(String str) {
        this.myVehiclesSort = str;
        persist(PREF_MY_VEHICLES_SORT, str);
    }

    public String getMyVehiclesSort() {
        this.myVehiclesSort = this.prefs.getString(PREF_MY_VEHICLES_SORT, "");
        return this.myVehiclesSort;
    }

    public void setbiddingBenchMarkDate(String str) {
        this.biddingBenchMarkDate = str;
        persist(PREF_LAST_BIDDING_BENCHMARK_DATE, str);
    }

    public String getbiddingBenchMarkDate() {
        if (this.biddingBenchMarkDate == null) {
            this.biddingBenchMarkDate = this.prefs.getString(PREF_LAST_BIDDING_BENCHMARK_DATE, "");
        }
        return this.biddingBenchMarkDate;
    }

    private void persist(String str, String str2) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putString(str, str2);
        edit.commit();
    }

    private void persist(String str, int i) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putInt(str, i);
        edit.commit();
    }

    private void persist(String str, long j) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putLong(str, j);
        edit.commit();
    }
}
