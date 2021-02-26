package com.google.android.apps.analytics.easytracking;

import android.content.Context;
import com.google.android.apps.analytics.Item;
import com.google.android.apps.analytics.Transaction;

public interface GoogleAnalyticsTrackerDelegate {
    void addItem(Item item);

    void addTransaction(Transaction transaction);

    void clearTransactions();

    boolean dispatch();

    void setAnonymizeIp(boolean z);

    boolean setCustomVar(int i, String str, String str2);

    boolean setCustomVar(int i, String str, String str2, int i2);

    void setDebug(boolean z);

    void setDryRun(boolean z);

    boolean setReferrer(String str);

    void setSampleRate(int i);

    void startNewSession(String str, int i, Context context);

    void stopSession();

    void trackEvent(String str, String str2, String str3, int i);

    void trackPageView(String str);

    void trackTransactions();
}
