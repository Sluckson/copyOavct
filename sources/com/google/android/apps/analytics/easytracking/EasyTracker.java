package com.google.android.apps.analytics.easytracking;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.google.android.apps.analytics.Item;
import com.google.android.apps.analytics.Transaction;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class EasyTracker {
    public static final String LOG_TAG = "EZTracker";
    private static EasyTracker instance;
    private int activitiesActive = 0;
    private Map<String, String> activityNameMap = new HashMap();
    /* access modifiers changed from: private */
    public boolean autoActivityTracking = false;
    /* access modifiers changed from: private */
    public String gaAccountId;
    /* access modifiers changed from: private */
    public boolean gaAnonymizeIp;
    /* access modifiers changed from: private */
    public Context gaContext;
    /* access modifiers changed from: private */
    public boolean gaDebug;
    /* access modifiers changed from: private */
    public int gaDispatchPeriod = 60;
    /* access modifiers changed from: private */
    public boolean gaDryRun;
    private boolean gaEnabled = false;
    /* access modifiers changed from: private */
    public int gaSampleRate = 100;
    private Object lock = new Object();
    private ParameterLoader parameterFetcher;
    private boolean sessionNeeded = true;
    /* access modifiers changed from: private */
    public GoogleAnalyticsTrackerDelegate tracker = null;
    /* access modifiers changed from: private */
    public final LinkedBlockingQueue<Runnable> trackerQueue = new LinkedBlockingQueue<>();
    private TrackerThread trackerThread;

    private class TrackerThread extends Thread {
        TrackerThread() {
            super("TrackerThread");
        }

        public void run() {
            while (true) {
                try {
                    ((Runnable) EasyTracker.this.trackerQueue.take()).run();
                } catch (InterruptedException e) {
                    Log.i(EasyTracker.LOG_TAG, e.toString());
                }
            }
        }
    }

    private EasyTracker() {
    }

    static void clearTracker() {
        instance = null;
    }

    /* access modifiers changed from: private */
    public String getActivityName(Activity activity) {
        String canonicalName = activity.getClass().getCanonicalName();
        if (this.activityNameMap.containsKey(canonicalName)) {
            return this.activityNameMap.get(canonicalName);
        }
        String string = this.parameterFetcher.getString(canonicalName);
        if (string == null) {
            string = canonicalName;
        }
        this.activityNameMap.put(canonicalName, string);
        return string;
    }

    /* access modifiers changed from: private */
    public GoogleAnalyticsTrackerDelegate getGoogleAnalyticsTracker() {
        if (this.tracker == null && this.gaEnabled) {
            this.tracker = new GoogleAnalyticsTrackerDelegateImpl();
            initializeTracker();
        }
        return this.tracker;
    }

    public static EasyTracker getTracker() {
        if (instance == null) {
            instance = new EasyTracker();
        }
        return instance;
    }

    private void initializeTracker() {
        queueToTrackerThreadIfEnabled(new Runnable() {
            public void run() {
                EasyTracker.this.tracker.setDebug(EasyTracker.this.gaDebug);
                EasyTracker.this.tracker.setDryRun(EasyTracker.this.gaDryRun);
                EasyTracker.this.tracker.setSampleRate(EasyTracker.this.gaSampleRate);
                EasyTracker.this.tracker.setAnonymizeIp(EasyTracker.this.gaAnonymizeIp);
            }
        });
    }

    private void loadParameters() {
        this.gaAccountId = this.parameterFetcher.getString("ga_api_key");
        if (this.gaAccountId != null) {
            this.gaEnabled = true;
            this.gaDebug = this.parameterFetcher.getBoolean("ga_debug");
            this.gaDryRun = this.parameterFetcher.getBoolean("ga_dryRun");
            this.gaSampleRate = this.parameterFetcher.getInt("ga_sampleRate", 100);
            this.gaDispatchPeriod = this.parameterFetcher.getInt("ga_dispatchPeriod", 20);
            this.autoActivityTracking = this.parameterFetcher.getBoolean("ga_auto_activity_tracking");
            this.gaAnonymizeIp = this.parameterFetcher.getBoolean("ga_anonymizeIp");
            if (this.trackerThread == null) {
                this.trackerThread = new TrackerThread();
                this.trackerThread.start();
            }
        }
    }

    private void queueToTrackerThreadIfEnabled(Runnable runnable) {
        if (this.gaEnabled) {
            synchronized (this.lock) {
                this.trackerQueue.add(runnable);
            }
        }
    }

    public void addItem(final Item item) {
        queueToTrackerThreadIfEnabled(new Runnable() {
            public void run() {
                EasyTracker.this.getGoogleAnalyticsTracker().addItem(item);
            }
        });
    }

    public void addTransaction(final Transaction transaction) {
        queueToTrackerThreadIfEnabled(new Runnable() {
            public void run() {
                EasyTracker.this.getGoogleAnalyticsTracker().addTransaction(transaction);
            }
        });
    }

    public void clearTransactions() {
        queueToTrackerThreadIfEnabled(new Runnable() {
            public void run() {
                EasyTracker.this.getGoogleAnalyticsTracker().clearTransactions();
            }
        });
    }

    public void dispatch() {
        queueToTrackerThreadIfEnabled(new Runnable() {
            public void run() {
                EasyTracker.this.getGoogleAnalyticsTracker().dispatch();
            }
        });
    }

    public void setContext(Context context) {
        if (context == null) {
            Log.e(LOG_TAG, "Context cannot be null");
        }
        if (this.gaContext == null) {
            this.gaContext = context.getApplicationContext();
            this.parameterFetcher = new ParameterLoaderImpl(this.gaContext);
            loadParameters();
        }
    }

    /* access modifiers changed from: package-private */
    public void setContext(Context context, ParameterLoader parameterLoader) {
        if (context == null) {
            Log.e(LOG_TAG, "Context cannot be null");
        }
        if (this.gaContext == null) {
            this.gaContext = context.getApplicationContext();
            this.parameterFetcher = parameterLoader;
            loadParameters();
        }
    }

    public void setReferrer(final String str) {
        queueToTrackerThreadIfEnabled(new Runnable() {
            public void run() {
                EasyTracker.this.getGoogleAnalyticsTracker().setReferrer(str);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void setTrackerDelegate(GoogleAnalyticsTrackerDelegate googleAnalyticsTrackerDelegate) {
        if (this.gaEnabled) {
            this.tracker = googleAnalyticsTrackerDelegate;
            initializeTracker();
        }
    }

    public void startNewSession() {
        queueToTrackerThreadIfEnabled(new Runnable() {
            public void run() {
                EasyTracker.this.getGoogleAnalyticsTracker().startNewSession(EasyTracker.this.gaAccountId, EasyTracker.this.gaDispatchPeriod, EasyTracker.this.gaContext);
            }
        });
    }

    public void stopSession() {
        queueToTrackerThreadIfEnabled(new Runnable() {
            public void run() {
                EasyTracker.this.getGoogleAnalyticsTracker().stopSession();
            }
        });
    }

    public void trackActivityRetainNonConfigurationInstance() {
        this.sessionNeeded = false;
    }

    public void trackActivityStart(final Activity activity) {
        this.activitiesActive++;
        final boolean z = this.sessionNeeded;
        this.sessionNeeded = false;
        queueToTrackerThreadIfEnabled(new Runnable() {
            public void run() {
                if (z) {
                    EasyTracker.this.getGoogleAnalyticsTracker().startNewSession(EasyTracker.this.gaAccountId, EasyTracker.this.gaDispatchPeriod, EasyTracker.this.gaContext);
                    if (!EasyTracker.this.autoActivityTracking) {
                        EasyTracker.this.getGoogleAnalyticsTracker().trackEvent("", "", "", 0);
                    }
                }
                if (EasyTracker.this.autoActivityTracking) {
                    EasyTracker.this.getGoogleAnalyticsTracker().trackPageView(EasyTracker.this.getActivityName(activity));
                }
            }
        });
    }

    public void trackActivityStop(Activity activity) {
        boolean z = true;
        this.activitiesActive--;
        if (this.activitiesActive != 0) {
            z = false;
        }
        this.sessionNeeded = z;
        final boolean z2 = this.sessionNeeded;
        queueToTrackerThreadIfEnabled(new Runnable() {
            public void run() {
                if (z2) {
                    EasyTracker.this.getGoogleAnalyticsTracker().trackEvent("", "", "", 0);
                }
            }
        });
    }

    public void trackEvent(String str, String str2, String str3, int i) {
        final String str4 = str;
        final String str5 = str2;
        final String str6 = str3;
        final int i2 = i;
        queueToTrackerThreadIfEnabled(new Runnable() {
            public void run() {
                EasyTracker.this.getGoogleAnalyticsTracker().trackEvent(str4, str5, str6, i2);
            }
        });
    }

    public void trackPageView(final String str) {
        queueToTrackerThreadIfEnabled(new Runnable() {
            public void run() {
                EasyTracker.this.getGoogleAnalyticsTracker().trackPageView(str);
            }
        });
    }

    public void trackTransactions() {
        queueToTrackerThreadIfEnabled(new Runnable() {
            public void run() {
                EasyTracker.this.getGoogleAnalyticsTracker().trackTransactions();
            }
        });
    }
}
