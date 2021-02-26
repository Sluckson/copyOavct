package com.iaai.android;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.analytics.MedalliaCustomParameters;
import com.iaai.android.bdt.injection.component.AppComponent;
import com.iaai.android.bdt.injection.component.DaggerAppComponent;
import com.iaai.android.bdt.injection.module.ApplicationModule;
import com.iaai.android.bdt.injection.module.CustomInterceptor;
import com.iaai.android.bdt.remoteconfig.IAARemoteConfig;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.ContentResolverUtil;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.old.utils.p016ui.touchgallery.LruBitmapCache;
import com.medallia.digital.mobilesdk.MDExternalError;
import com.medallia.digital.mobilesdk.MDResultCallback;
import com.medallia.digital.mobilesdk.MedalliaDigital;
import com.squareup.otto.Bus;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import roboguice.application.RoboApplication;

public class IaaiApplication extends RoboApplication implements HasActivityInjector, HasSupportFragmentInjector, LifecycleObserver {
    public static final boolean ANALYTICS_ENABLED = true;
    public static final String APP_ID = "056f4964-54a9-4728-b93f-549c06997b96";
    public static final boolean CLOUD_PAGES_ENABLED = true;
    public static final String DEVICE_ID = "a4fa1812-0a0a-43e1-a136-453389d1afd7";
    public static final boolean LOCATION_ENABLED = false;
    private static String MEDALLIA_TOKEN = "eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhcGlUb2tlblYyIiwiYXV0aFVybCI6Imh0dHBzOi8vbW9iaWxlc2RrLXVzLmthbXB5bGUuY29tL2FwaS92MS9hY2Nlc3NUb2tlbiIsImNyZWF0ZVRpbWUiOjE1Nzc5ODc4NjQwNTYsImFwaVRva2VuVjJWZXJzaW9uIjoyLCJwcm9wZXJ0eUlkIjo2NTM2MDN9.nZ1KOuebJkS56QlOQ9EnUpAI46-DoMM7Bb5A94WC67c_jGqDdaruVKhIXWqGEmHrD8tvRHHdZI9F_5ado5MoDhRf5MsP8xQyG5HT00Grs8RfSuYkAiMrETf5zvmFtCaqedbfl7WhJwQxMxGIxoxSZ6oR5472n-6i_NdGfJg9a0kJ87YlwfnLpKuILvyDfhzLPx2rMBSkjOawJf5Ujg_-rGJVMK_i2rhksHtgAF_fNO-l1H3s7qq3i1njwJJChTEocvJa4rD02w_tq3L9jPmrkxBJyzI-Ha_sLhJBCityFU7XUSjjzah1Z8-JOGG5YnO4FX7c2uJCMvEXJaAiUDJJSA";
    public static final boolean PI_ENABLED = false;
    public static final String PROPERTY_APP_VERSION = "appVersion";
    public static final String PROPERTY_REG_ID = "registration_id";
    public static final boolean PROXIMITY_ENABLED = true;
    private static final String TAG = "~#LearningApp";
    private static boolean activityVisible = false;
    private static Bundle bundle_auction_salelist = null;
    private static Bundle bundle_prepost_sale = null;
    private static Bundle bundle_search_vehicle = null;
    private static Bundle bundle_tobe_paid = null;
    private static Bundle bundle_tobe_pickedup = null;
    private static Bus bus = null;
    public static boolean isBDTEnabled = true;
    public static boolean isBackPressedFromRefinerResult = false;
    public static boolean isBranchFilterSelected = false;
    public static boolean isDateFragmentSelected = false;
    public static boolean isDateModified = false;
    public static boolean isFirstTimeForFilterDone = false;
    public static boolean isGooglePlayServiceAvailable = false;
    public static boolean isLaneFilterSelected = false;
    public static boolean isLaneFragmentSelected = false;
    public static boolean isMyAccountScreenShowing = false;
    public static boolean isResetApplied = false;
    public static boolean isSavedSearch = false;
    public static boolean isSortFilterSelected = false;
    public static boolean isToBePaidBranchFragmentSelected = false;
    public static boolean isToDateSelected = false;
    public static boolean isUserLogin = false;
    public static boolean isUserLoginForBuyNowOffer = false;
    public static boolean is_app_in_bg = false;
    public static boolean is_credit_card_enable = false;
    public static boolean is_new_fast_Search = true;
    public static boolean is_new_landing = true;
    public static boolean is_new_select_payment_enabled = true;
    public static boolean is_pay_pal_enabled = false;
    public static boolean isfromDateSelected = false;
    public static boolean loadNewRefinerFirstTime = true;
    public static boolean loadRefinerFirstTime = true;
    public static Context mContext;
    private static IaaiApplication mInstance;
    public static HashMap<String, String> selectedFilters = new HashMap<>();
    public static int selectedLanePosition;
    public static int selectedSortPosition;
    public static int selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_auction;
    public static int selectedtobepaidbranchfilterPosition;
    public static final SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
    public String analyticsEndDateTime;
    public String analyticsStartDateTime;
    AppComponent appComponent;
    @Inject
    private ContentResolver contentResolver;
    @javax.inject.Inject
    CustomInterceptor customInterceptor;
    @javax.inject.Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    @javax.inject.Inject
    DispatchingAndroidInjector<Fragment> dispatchingFragmentInjector;
    private String lastBeaconReceivedEventDatetime = "";
    private FirebaseAnalytics mFirebaseAnalytics;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;
    private IAARemoteConfig mIAARemoteConfig;
    private ImageLoader mImageLoader;
    private RequestQueue mRequestQueue;
    private SharedPreferences sharedPreferences;

    public FirebaseAnalytics getmFirebaseAnalytics() {
        return this.mFirebaseAnalytics;
    }

    public void setmFirebaseAnalytics(FirebaseAnalytics firebaseAnalytics) {
        this.mFirebaseAnalytics = firebaseAnalytics;
    }

    public boolean isInitialized() {
        return this.guiceInjector != null;
    }

    public String getLastBeaconReceivedEventDatetime() {
        if (TextUtils.isEmpty(this.lastBeaconReceivedEventDatetime)) {
            this.lastBeaconReceivedEventDatetime = this.sharedPreferences.getString("lastBeaconReceivedEventDatetime", "Last Event Datetime Not Available");
        }
        return this.lastBeaconReceivedEventDatetime;
    }

    /* access modifiers changed from: protected */
    public void addApplicationModules(List<Module> list) {
        list.add(new IaaiModule());
    }

    public static synchronized IaaiApplication getInstance() {
        IaaiApplication iaaiApplication;
        synchronized (IaaiApplication.class) {
            iaaiApplication = mInstance;
        }
        return iaaiApplication;
    }

    public RequestQueue getRequestQueue() {
        if (this.mRequestQueue == null) {
            this.mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        return this.mRequestQueue;
    }

    public static Bus getBus() {
        if (bus == null) {
            bus = new Bus();
        }
        return bus;
    }

    public static void putSavedInstance(int i, Bundle bundle) {
        if (i == 1) {
            bundle_prepost_sale = bundle;
        } else if (i == 2) {
            bundle_tobe_paid = bundle;
        } else if (i == 3) {
            bundle_tobe_pickedup = bundle;
        } else if (i == 4) {
            bundle_auction_salelist = bundle;
        } else if (i == 5) {
            bundle_search_vehicle = bundle;
        }
    }

    public static Bundle getSavedInstance(int i) {
        if (i == 1) {
            return bundle_prepost_sale;
        }
        if (i == 2) {
            return bundle_tobe_paid;
        }
        if (i == 3) {
            return bundle_tobe_pickedup;
        }
        if (i == 4) {
            return bundle_auction_salelist;
        }
        if (i != 5) {
            return null;
        }
        return bundle_search_vehicle;
    }

    public ImageLoader getImageLoader() {
        getRequestQueue();
        if (this.mImageLoader == null) {
            this.mImageLoader = new ImageLoader(this.mRequestQueue, new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    public void onCreate() {
        super.onCreate();
        mContext = this;
        mInstance = this;
        setFCMRemoteConfig();
        initializeMedalliaSDK();
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
        this.sharedPreferences = getSharedPreferences("AndroidLearningApp", 0);
        this.mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        this.appComponent = DaggerAppComponent.builder().applicationModule(new ApplicationModule(this)).build();
        this.appComponent.inject(this);
        InternetUtil.INSTANCE.init(this);
        this.customInterceptor.setInterceptor(getResources().getString(C2723R.string.base_url));
        IAAAnalytics.INSTANCE.registerAppVersionUserProperty();
        String fCMRegistrationId = ContentResolverUtil.INSTANCE.getFCMRegistrationId(getApplicationContext());
        if (fCMRegistrationId != null && !fCMRegistrationId.isEmpty()) {
            getComponent().getPreferenceHelper().put(Constants_MVVM.FCM_REGISTERED_TOKEN, fCMRegistrationId);
        }
    }

    public void onTerminate() {
        super.onTerminate();
    }

    public void onLowMemory() {
        super.onLowMemory();
    }

    public static int convertDPToPixel(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    public static IaaiApplication get(Context context) {
        return (IaaiApplication) context.getApplicationContext();
    }

    public DispatchingAndroidInjector<Activity> activityInjector() {
        return this.dispatchingAndroidInjector;
    }

    public AppComponent getComponent() {
        return this.appComponent;
    }

    public AndroidInjector<Fragment> supportFragmentInjector() {
        return this.dispatchingFragmentInjector;
    }

    /* access modifiers changed from: protected */
    public void setFCMRemoteConfig() {
        this.mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        this.mFirebaseRemoteConfig.setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds((long) Integer.parseInt(getString(C2723R.string.firebase_remote_config_time_interval))).build());
        this.mFirebaseRemoteConfig.setDefaultsAsync((int) C2723R.C2732xml.remote_config_defaults);
    }

    public FirebaseRemoteConfig getmFirebaseRemoteConfig() {
        return this.mFirebaseRemoteConfig;
    }

    public IAARemoteConfig getIAARemoteConfig() {
        if (this.mIAARemoteConfig == null) {
            this.mIAARemoteConfig = new IAARemoteConfig();
        }
        return this.mIAARemoteConfig;
    }

    private void initializeMedalliaSDK() {
        MedalliaDigital.init(this, MEDALLIA_TOKEN, new MDResultCallback() {
            public void onSuccess() {
                Log.d("Medallia", "Medallia SDK initialized");
                MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.IS_PROD.getId(), Boolean.valueOf(IaaiApplication.this.getResources().getBoolean(C2723R.bool.is_prod)));
                MedalliaDigital.enableIntercept();
            }

            public void onError(MDExternalError mDExternalError) {
                Log.d("Medallia", "ERROR in SDK initialized");
            }
        });
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onAppBackgrounded() {
        is_app_in_bg = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onAppForegrounded() {
        is_app_in_bg = false;
    }
}
