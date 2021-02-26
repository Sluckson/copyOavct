package com.google.android.apps.analytics;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.util.Log;
import com.google.android.apps.analytics.Dispatcher;
import com.google.android.apps.analytics.Transaction;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.HashMap;
import java.util.Map;

public class GoogleAnalyticsTracker {
    public static final String LOG_TAG = "GoogleAnalyticsTracker";
    public static final String PRODUCT = "GoogleAnalytics";
    public static final String VERSION = "1.4.2";
    public static final String WIRE_VERSION = "4.8.1ma";
    private static GoogleAnalyticsTracker instance = new GoogleAnalyticsTracker();
    private String accountId;
    private AdHitIdGenerator adHitIdGenerator;
    private boolean anonymizeIp = false;
    private ConnectivityManager connectivityManager;
    private CustomVariableBuffer customVariableBuffer;
    private boolean debug = false;
    private int dispatchPeriod;
    private Runnable dispatchRunner = new Runnable() {
        public void run() {
            GoogleAnalyticsTracker.this.dispatch();
        }
    };
    private Dispatcher dispatcher;
    private boolean dispatcherIsBusy;
    private boolean dryRun = false;
    /* access modifiers changed from: private */
    public Handler handler;
    /* access modifiers changed from: private */
    public HitStore hitStore;
    private Map<String, Map<String, Item>> itemMap = new HashMap();
    private Context parent;
    private boolean powerSaveMode;
    private int sampleRate = 100;
    private Map<String, Transaction> transactionMap = new HashMap();
    private boolean useServerTime = false;
    private String userAgentProduct = PRODUCT;
    private String userAgentVersion = VERSION;

    final class DispatcherCallbacks implements Dispatcher.Callbacks {
        DispatcherCallbacks() {
        }

        public void dispatchFinished() {
            GoogleAnalyticsTracker.this.handler.post(new Runnable() {
                public void run() {
                    GoogleAnalyticsTracker.this.dispatchFinished();
                }
            });
        }

        public void hitDispatched(long j) {
            GoogleAnalyticsTracker.this.hitStore.deleteHit(j);
        }
    }

    private GoogleAnalyticsTracker() {
    }

    private void cancelPendingDispatches() {
        Handler handler2 = this.handler;
        if (handler2 != null) {
            handler2.removeCallbacks(this.dispatchRunner);
        }
    }

    private void createEvent(String str, String str2, String str3, String str4, int i) {
        Event event = new Event(str, str2, str3, str4, i, this.parent.getResources().getDisplayMetrics().widthPixels, this.parent.getResources().getDisplayMetrics().heightPixels);
        event.setCustomVariableBuffer(this.customVariableBuffer);
        event.setAdHitId(this.adHitIdGenerator.getAdHitId());
        event.setUseServerTime(this.useServerTime);
        this.customVariableBuffer = new CustomVariableBuffer();
        this.hitStore.putEvent(event);
        resetPowerSaveMode();
    }

    public static GoogleAnalyticsTracker getInstance() {
        return instance;
    }

    private void maybeScheduleNextDispatch() {
        int i = this.dispatchPeriod;
        if (i >= 0 && this.handler.postDelayed(this.dispatchRunner, (long) (i * 1000)) && this.debug) {
            Log.v(LOG_TAG, "Scheduled next dispatch");
        }
    }

    private void resetPowerSaveMode() {
        if (this.powerSaveMode) {
            this.powerSaveMode = false;
            maybeScheduleNextDispatch();
        }
    }

    public void addItem(Item item) {
        if (this.transactionMap.get(item.getOrderId()) == null) {
            Log.i(LOG_TAG, "No transaction with orderId " + item.getOrderId() + " found, creating one");
            this.transactionMap.put(item.getOrderId(), new Transaction.Builder(item.getOrderId(), FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE).build());
        }
        Map map = this.itemMap.get(item.getOrderId());
        if (map == null) {
            map = new HashMap();
            this.itemMap.put(item.getOrderId(), map);
        }
        map.put(item.getItemSKU(), item);
    }

    public void addTransaction(Transaction transaction) {
        this.transactionMap.put(transaction.getOrderId(), transaction);
    }

    public void clearTransactions() {
        this.transactionMap.clear();
        this.itemMap.clear();
    }

    public boolean dispatch() {
        if (this.debug) {
            Log.v(LOG_TAG, "Called dispatch");
        }
        if (this.dispatcherIsBusy) {
            if (this.debug) {
                Log.v(LOG_TAG, "...but dispatcher was busy");
            }
            maybeScheduleNextDispatch();
            return false;
        }
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            if (this.debug) {
                Log.v(LOG_TAG, "...but there was no network available");
            }
            maybeScheduleNextDispatch();
            return false;
        } else if (this.hitStore.getNumStoredHits() != 0) {
            Hit[] peekHits = this.hitStore.peekHits();
            this.dispatcher.dispatchHits(peekHits);
            this.dispatcherIsBusy = true;
            maybeScheduleNextDispatch();
            if (this.debug) {
                Log.v(LOG_TAG, "Sending " + peekHits.length + " hits to dispatcher");
            }
            return true;
        } else {
            this.powerSaveMode = true;
            if (this.debug) {
                Log.v(LOG_TAG, "...but there was nothing to dispatch");
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchFinished() {
        this.dispatcherIsBusy = false;
    }

    public boolean getAnonymizeIp() {
        return this.anonymizeIp;
    }

    public boolean getDebug() {
        return this.debug;
    }

    /* access modifiers changed from: package-private */
    public Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    /* access modifiers changed from: package-private */
    public HitStore getHitStore() {
        return this.hitStore;
    }

    public int getSampleRate() {
        return this.sampleRate;
    }

    /* access modifiers changed from: package-private */
    public String getSessionIdForAds() {
        HitStore hitStore2 = this.hitStore;
        if (hitStore2 == null) {
            return null;
        }
        return hitStore2.getSessionId();
    }

    public String getVisitorCustomVar(int i) {
        if (i >= 1 && i <= 5) {
            return this.hitStore.getVisitorCustomVar(i);
        }
        throw new IllegalArgumentException(CustomVariable.INDEX_ERROR_MSG);
    }

    /* access modifiers changed from: package-private */
    public String getVisitorIdForAds() {
        HitStore hitStore2 = this.hitStore;
        if (hitStore2 == null) {
            return null;
        }
        return hitStore2.getVisitorId();
    }

    public boolean isDryRun() {
        return this.dryRun;
    }

    /* access modifiers changed from: package-private */
    public void returnToInitialState() {
        instance = new GoogleAnalyticsTracker();
    }

    /* access modifiers changed from: package-private */
    public void setAdHitIdGenerator(AdHitIdGenerator adHitIdGenerator2) {
        this.adHitIdGenerator = adHitIdGenerator2;
    }

    public void setAnonymizeIp(boolean z) {
        this.anonymizeIp = z;
        HitStore hitStore2 = this.hitStore;
        if (hitStore2 != null) {
            hitStore2.setAnonymizeIp(this.anonymizeIp);
        }
    }

    public boolean setCustomVar(int i, String str, String str2) {
        return setCustomVar(i, str, str2, 3);
    }

    public boolean setCustomVar(int i, String str, String str2, int i2) {
        try {
            CustomVariable customVariable = new CustomVariable(i, str, str2, i2);
            if (this.customVariableBuffer == null) {
                this.customVariableBuffer = new CustomVariableBuffer();
            }
            this.customVariableBuffer.setCustomVariable(customVariable);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public void setDispatchPeriod(int i) {
        int i2 = this.dispatchPeriod;
        this.dispatchPeriod = i;
        if (i2 > 0) {
            if (i2 > 0) {
                cancelPendingDispatches();
            } else {
                return;
            }
        }
        maybeScheduleNextDispatch();
    }

    public boolean setDispatcher(Dispatcher dispatcher2) {
        if (this.dispatcherIsBusy) {
            return false;
        }
        Dispatcher dispatcher3 = this.dispatcher;
        if (dispatcher3 != null) {
            dispatcher3.stop();
        }
        this.dispatcher = dispatcher2;
        this.dispatcher.init(new DispatcherCallbacks());
        this.dispatcher.setDryRun(this.dryRun);
        return true;
    }

    public void setDryRun(boolean z) {
        this.dryRun = z;
        Dispatcher dispatcher2 = this.dispatcher;
        if (dispatcher2 != null) {
            dispatcher2.setDryRun(z);
        }
    }

    public void setProductVersion(String str, String str2) {
        this.userAgentProduct = str;
        this.userAgentVersion = str2;
    }

    public boolean setReferrer(String str) {
        HitStore hitStore2 = this.hitStore;
        if (hitStore2 != null) {
            return hitStore2.setReferrer(str);
        }
        throw new IllegalStateException("Can't set a referrer before starting the tracker");
    }

    public void setSampleRate(int i) {
        if (i < 0 || i > 100) {
            Log.w(LOG_TAG, "Invalid sample rate: " + i + " (should be between 0 and 100");
            return;
        }
        this.sampleRate = i;
        HitStore hitStore2 = this.hitStore;
        if (hitStore2 != null) {
            hitStore2.setSampleRate(this.sampleRate);
        }
    }

    public void setUseServerTime(boolean z) {
        this.useServerTime = z;
    }

    @Deprecated
    public void start(String str, int i, Context context) {
        startNewSession(str, i, context);
    }

    /* access modifiers changed from: package-private */
    public void start(String str, int i, Context context, HitStore hitStore2, Dispatcher dispatcher2, boolean z) {
        start(str, i, context, hitStore2, dispatcher2, z, new DispatcherCallbacks());
    }

    /* access modifiers changed from: package-private */
    public void start(String str, int i, Context context, HitStore hitStore2, Dispatcher dispatcher2, boolean z, Dispatcher.Callbacks callbacks) {
        this.accountId = str;
        if (context != null) {
            this.parent = context.getApplicationContext();
            this.hitStore = hitStore2;
            this.adHitIdGenerator = new AdHitIdGenerator();
            if (z) {
                this.hitStore.startNewVisit();
            }
            this.dispatcher = dispatcher2;
            this.dispatcher.init(callbacks);
            this.dispatcherIsBusy = false;
            if (this.connectivityManager == null) {
                this.connectivityManager = (ConnectivityManager) this.parent.getSystemService("connectivity");
            }
            if (this.handler == null) {
                this.handler = new Handler(context.getMainLooper());
            } else {
                cancelPendingDispatches();
            }
            setDispatchPeriod(i);
            return;
        }
        throw new NullPointerException("Context cannot be null");
    }

    /* access modifiers changed from: package-private */
    public void start(String str, int i, Context context, boolean z) {
        if (context != null) {
            HitStore hitStore2 = this.hitStore;
            if (hitStore2 == null) {
                hitStore2 = new PersistentHitStore(context);
                hitStore2.setAnonymizeIp(this.anonymizeIp);
                hitStore2.setSampleRate(this.sampleRate);
            }
            HitStore hitStore3 = hitStore2;
            Dispatcher dispatcher2 = this.dispatcher;
            if (dispatcher2 == null) {
                dispatcher2 = new NetworkDispatcher(this.userAgentProduct, this.userAgentVersion);
                dispatcher2.setDryRun(this.dryRun);
            }
            start(str, i, context, hitStore3, dispatcher2, z);
            return;
        }
        throw new NullPointerException("Context cannot be null");
    }

    @Deprecated
    public void start(String str, Context context) {
        start(str, -1, context);
    }

    public void startNewSession(String str, int i, Context context) {
        start(str, i, context, true);
    }

    public void startNewSession(String str, Context context) {
        startNewSession(str, -1, context);
    }

    @Deprecated
    public void stop() {
        Dispatcher dispatcher2 = this.dispatcher;
        if (dispatcher2 != null) {
            dispatcher2.stop();
        }
        cancelPendingDispatches();
    }

    public void stopSession() {
        stop();
    }

    public void trackEvent(String str, String str2, String str3, int i) {
        if (str == null) {
            throw new IllegalArgumentException("category cannot be null");
        } else if (str2 != null) {
            createEvent(this.accountId, str, str2, str3, i);
        } else {
            throw new IllegalArgumentException("action cannot be null");
        }
    }

    public void trackPageView(String str) {
        createEvent(this.accountId, "__##GOOGLEPAGEVIEW##__", str, (String) null, -1);
    }

    public void trackTransactions() {
        for (Transaction next : this.transactionMap.values()) {
            Event event = new Event(this.accountId, "__##GOOGLETRANSACTION##__", "", "", 0, this.parent.getResources().getDisplayMetrics().widthPixels, this.parent.getResources().getDisplayMetrics().heightPixels);
            event.setTransaction(next);
            this.hitStore.putEvent(event);
            Map map = this.itemMap.get(next.getOrderId());
            if (map != null) {
                for (Item item : map.values()) {
                    Event event2 = new Event(this.accountId, "__##GOOGLEITEM##__", "", "", 0, this.parent.getResources().getDisplayMetrics().widthPixels, this.parent.getResources().getDisplayMetrics().heightPixels);
                    event2.setItem(item);
                    this.hitStore.putEvent(event2);
                }
            }
        }
        clearTransactions();
        resetPowerSaveMode();
    }
}
