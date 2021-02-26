package com.google.android.apps.analytics.easytracking;

import android.content.Context;
import com.google.android.apps.analytics.GoogleAnalyticsTracker;
import com.google.android.apps.analytics.Item;
import com.google.android.apps.analytics.Transaction;

public class GoogleAnalyticsTrackerDelegateImpl implements GoogleAnalyticsTrackerDelegate {
    private GoogleAnalyticsTracker tracker = GoogleAnalyticsTracker.getInstance();

    public void addItem(Item item) {
        this.tracker.addItem(item);
    }

    public void addTransaction(Transaction transaction) {
        this.tracker.addTransaction(transaction);
    }

    public void clearTransactions() {
        this.tracker.clearTransactions();
    }

    public boolean dispatch() {
        return this.tracker.dispatch();
    }

    public void setAnonymizeIp(boolean z) {
        this.tracker.setAnonymizeIp(z);
    }

    public boolean setCustomVar(int i, String str, String str2) {
        return this.tracker.setCustomVar(i, str, str2);
    }

    public boolean setCustomVar(int i, String str, String str2, int i2) {
        return this.tracker.setCustomVar(i, str, str2, i2);
    }

    public void setDebug(boolean z) {
        this.tracker.setDebug(z);
    }

    public void setDryRun(boolean z) {
        this.tracker.setDryRun(z);
    }

    public boolean setReferrer(String str) {
        return this.tracker.setReferrer(str);
    }

    public void setSampleRate(int i) {
        this.tracker.setSampleRate(i);
    }

    public void startNewSession(String str, int i, Context context) {
        this.tracker.startNewSession(str, i, context);
    }

    public void stopSession() {
        this.tracker.stopSession();
    }

    public void trackEvent(String str, String str2, String str3, int i) {
        this.tracker.trackEvent(str, str2, str3, i);
    }

    public void trackPageView(String str) {
        this.tracker.trackPageView(str);
    }

    public void trackTransactions() {
        this.tracker.trackTransactions();
    }
}
