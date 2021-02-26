package com.iaai.android.bdt.feature.applaunch;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.inject.Injector;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterViewModel;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.feature.login.BDTTermsOfUseActivity;
import com.iaai.android.bdt.feature.login.TermsOfUseOrigin;
import com.iaai.android.old.managers.MarketingCloudManager;
import com.iaai.android.old.managers.TermsOfUseManager;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.http.RestClient;
import com.salesforce.marketingcloud.registration.RegistrationManager;
import dagger.android.AndroidInjection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 62\u00020\u0001:\u00016B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0002J\b\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020/H\u0002J\b\u00101\u001a\u00020/H\u0002J\u0012\u00102\u001a\u00020/2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020/H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u00067"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/applaunch/SplashActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "getTAG$app_productionRelease", "()Ljava/lang/String;", "setTAG$app_productionRelease", "(Ljava/lang/String;)V", "client", "Lcom/iaai/android/old/utils/http/RestClient;", "getClient$app_productionRelease", "()Lcom/iaai/android/old/utils/http/RestClient;", "setClient$app_productionRelease", "(Lcom/iaai/android/old/utils/http/RestClient;)V", "fastSearchViewModel", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterViewModel;", "marketingCloudManager", "Lcom/iaai/android/old/managers/MarketingCloudManager;", "getMarketingCloudManager$app_productionRelease", "()Lcom/iaai/android/old/managers/MarketingCloudManager;", "setMarketingCloudManager$app_productionRelease", "(Lcom/iaai/android/old/managers/MarketingCloudManager;)V", "registrationManager", "Lcom/salesforce/marketingcloud/registration/RegistrationManager;", "getRegistrationManager$app_productionRelease", "()Lcom/salesforce/marketingcloud/registration/RegistrationManager;", "setRegistrationManager$app_productionRelease", "(Lcom/salesforce/marketingcloud/registration/RegistrationManager;)V", "termsOfUseManager", "Lcom/iaai/android/old/managers/TermsOfUseManager;", "getTermsOfUseManager$app_productionRelease", "()Lcom/iaai/android/old/managers/TermsOfUseManager;", "setTermsOfUseManager$app_productionRelease", "(Lcom/iaai/android/old/managers/TermsOfUseManager;)V", "viewModel", "Lcom/iaai/android/bdt/feature/applaunch/MakeModelViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "checkPlayServices", "", "checkTermsOfUseCallSevanDaysOld", "checkTermsOfUseNeedToDisplay", "", "fetchMakeModelMasterData", "fetchSearchMapping", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "subscribeToViewModel", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SplashActivity.kt */
public final class SplashActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static boolean CreateBuyer = false;
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = PLAY_SERVICES_RESOLUTION_REQUEST;
    /* access modifiers changed from: private */
    public static boolean UpdateBuyer;
    /* access modifiers changed from: private */
    @Nullable
    public static String imei_no;
    @NotNull
    private String TAG = "SPLASH ACTIVITY";
    private HashMap _$_findViewCache;
    @NotNull
    public RestClient client;
    private FastSearchFilterViewModel fastSearchViewModel;
    @NotNull
    public MarketingCloudManager marketingCloudManager;
    @Nullable
    private RegistrationManager registrationManager;
    @NotNull
    public TermsOfUseManager termsOfUseManager;
    private MakeModelViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    @NotNull
    public final String getTAG$app_productionRelease() {
        return this.TAG;
    }

    public final void setTAG$app_productionRelease(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.TAG = str;
    }

    @NotNull
    public final TermsOfUseManager getTermsOfUseManager$app_productionRelease() {
        TermsOfUseManager termsOfUseManager2 = this.termsOfUseManager;
        if (termsOfUseManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("termsOfUseManager");
        }
        return termsOfUseManager2;
    }

    public final void setTermsOfUseManager$app_productionRelease(@NotNull TermsOfUseManager termsOfUseManager2) {
        Intrinsics.checkParameterIsNotNull(termsOfUseManager2, "<set-?>");
        this.termsOfUseManager = termsOfUseManager2;
    }

    @NotNull
    public final RestClient getClient$app_productionRelease() {
        RestClient restClient = this.client;
        if (restClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("client");
        }
        return restClient;
    }

    public final void setClient$app_productionRelease(@NotNull RestClient restClient) {
        Intrinsics.checkParameterIsNotNull(restClient, "<set-?>");
        this.client = restClient;
    }

    @NotNull
    public final ViewModelProvider.Factory getViewModelFactory() {
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        return factory;
    }

    public final void setViewModelFactory(@NotNull ViewModelProvider.Factory factory) {
        Intrinsics.checkParameterIsNotNull(factory, "<set-?>");
        this.viewModelFactory = factory;
    }

    @NotNull
    public final MarketingCloudManager getMarketingCloudManager$app_productionRelease() {
        MarketingCloudManager marketingCloudManager2 = this.marketingCloudManager;
        if (marketingCloudManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("marketingCloudManager");
        }
        return marketingCloudManager2;
    }

    public final void setMarketingCloudManager$app_productionRelease(@NotNull MarketingCloudManager marketingCloudManager2) {
        Intrinsics.checkParameterIsNotNull(marketingCloudManager2, "<set-?>");
        this.marketingCloudManager = marketingCloudManager2;
    }

    @Nullable
    public final RegistrationManager getRegistrationManager$app_productionRelease() {
        return this.registrationManager;
    }

    public final void setRegistrationManager$app_productionRelease(@Nullable RegistrationManager registrationManager2) {
        this.registrationManager = registrationManager2;
    }

    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.splash);
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(MakeModelViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…delViewModel::class.java)");
        this.viewModel = (MakeModelViewModel) viewModel2;
        ViewModelProvider.Factory factory2 = this.viewModelFactory;
        if (factory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel3 = ViewModelProviders.m18of(fragmentActivity, factory2).get(FastSearchFilterViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel3, "ViewModelProviders.of(th…terViewModel::class.java)");
        this.fastSearchViewModel = (FastSearchFilterViewModel) viewModel3;
        Context context = this;
        PreferenceManager.setDefaultValues(context, C2723R.C2732xml.main_preferences, true);
        PreferenceManager.setDefaultValues(context, C2723R.C2732xml.notification_preferences, true);
        Application application = getApplication();
        if (application != null) {
            Injector injector = ((IaaiApplication) application).getInjector();
            Object instance = injector.getInstance(TermsOfUseManager.class);
            Intrinsics.checkExpressionValueIsNotNull(instance, "injector.getInstance(Ter…OfUseManager::class.java)");
            this.termsOfUseManager = (TermsOfUseManager) instance;
            Object instance2 = injector.getInstance(MarketingCloudManager.class);
            Intrinsics.checkExpressionValueIsNotNull(instance2, "injector.getInstance(Mar…CloudManager::class.java)");
            this.marketingCloudManager = (MarketingCloudManager) instance2;
            Object instance3 = injector.getInstance(RestClient.class);
            Intrinsics.checkExpressionValueIsNotNull(instance3, "injector.getInstance(RestClient::class.java)");
            this.client = (RestClient) instance3;
            IaaiApplication.isGooglePlayServiceAvailable = checkPlayServices();
            fetchMakeModelMasterData();
            fetchSearchMapping();
            subscribeToViewModel();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.IaaiApplication");
    }

    private final void fetchMakeModelMasterData() {
        if (Activity_ExtensionKt.isDayOverForRefiner(this)) {
            MakeModelViewModel makeModelViewModel = this.viewModel;
            if (makeModelViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            makeModelViewModel.getMakeModelMasterData();
            return;
        }
        new SplashActivity$fetchMakeModelMasterData$timerThread$1(this).start();
    }

    private final void fetchSearchMapping() {
        FastSearchFilterViewModel fastSearchFilterViewModel = this.fastSearchViewModel;
        if (fastSearchFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchViewModel");
        }
        fastSearchFilterViewModel.getSearchMapping();
    }

    private final void subscribeToViewModel() {
        MakeModelViewModel makeModelViewModel = this.viewModel;
        if (makeModelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        makeModelViewModel.getMakeModelListResult().observe(lifecycleOwner, new SplashActivity$subscribeToViewModel$1(this));
        MakeModelViewModel makeModelViewModel2 = this.viewModel;
        if (makeModelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        makeModelViewModel2.getMakeModelListError().observe(lifecycleOwner, new SplashActivity$subscribeToViewModel$2(this));
        FastSearchFilterViewModel fastSearchFilterViewModel = this.fastSearchViewModel;
        if (fastSearchFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchViewModel");
        }
        fastSearchFilterViewModel.getSearchMappingResult().observe(lifecycleOwner, new SplashActivity$subscribeToViewModel$3(this));
        FastSearchFilterViewModel fastSearchFilterViewModel2 = this.fastSearchViewModel;
        if (fastSearchFilterViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchViewModel");
        }
        fastSearchFilterViewModel2.getSearchMappingError().observe(lifecycleOwner, SplashActivity$subscribeToViewModel$4.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void checkTermsOfUseNeedToDisplay() {
        String str;
        Context context = this;
        if (!IAASharedPreference.getTncFlagFromPrefs(context)) {
            Intent intent = new Intent(context, BDTTermsOfUseActivity.class);
            intent.putExtra("come_from", TermsOfUseOrigin.FROM_SPLASH.getValue());
            startActivity(intent);
            Log.d("isTncAccepted--", "false--");
        } else if (checkTermsOfUseCallSevanDaysOld()) {
            String string = getResources().getString(C2723R.string.terms_of_use_changed_url);
            try {
                RestClient restClient = this.client;
                if (restClient == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("client");
                }
                str = (String) restClient.execute(string, String.class, false);
            } catch (Exception e) {
                e.printStackTrace();
                str = "";
            }
            if (str != null && StringsKt.equals(str, "true", true)) {
                Intent intent2 = new Intent(context, BDTTermsOfUseActivity.class);
                intent2.putExtra("come_from", TermsOfUseOrigin.FROM_SPLASH.getValue());
                startActivity(intent2);
            } else if (IaaiApplication.is_new_landing) {
                Intent intent3 = new Intent(context, BDTLandingPageActivity.class);
                intent3.addFlags(536870912);
                startActivity(intent3);
            } else {
                Intent intent4 = new Intent(context, BDTAuctionMainListActivity.class);
                intent4.addFlags(536870912);
                startActivity(intent4);
            }
            AppUtils.saveTermsOfUseTimeStamp(context);
        } else if (IaaiApplication.is_new_landing) {
            Intent intent5 = new Intent(context, BDTLandingPageActivity.class);
            intent5.addFlags(536870912);
            startActivity(intent5);
        } else {
            Intent intent6 = new Intent(context, BDTAuctionMainListActivity.class);
            intent6.addFlags(536870912);
            startActivity(intent6);
        }
        finish();
    }

    private final boolean checkTermsOfUseCallSevanDaysOld() {
        String tncTimeStampFromPrefs = IAASharedPreference.getTncTimeStampFromPrefs(this);
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIMEZONE_OFFER);
        String format = simpleDateFormat.format(date);
        Date date2 = null;
        try {
            Date parse = simpleDateFormat.parse(tncTimeStampFromPrefs);
            Date parse2 = simpleDateFormat.parse(format);
            if (parse2 == null) {
                Intrinsics.throwNpe();
            }
            long time = parse2.getTime();
            if (parse == null) {
                Intrinsics.throwNpe();
            }
            long time2 = (time - parse.getTime()) / ((long) 86400000);
            System.out.print(time2 + " days, ");
            if (time2 > ((long) 7)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private final boolean checkPlayServices() {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if (isGooglePlayServicesAvailable == 0) {
            return true;
        }
        if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
            GooglePlayServicesUtil.getErrorDialog(isGooglePlayServicesAvailable, this, PLAY_SERVICES_RESOLUTION_REQUEST).show();
            return false;
        }
        Log.i(this.TAG, "This device is not supported.");
        return false;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\bR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/applaunch/SplashActivity$Companion;", "", "()V", "CreateBuyer", "", "getCreateBuyer", "()Z", "setCreateBuyer", "(Z)V", "PLAY_SERVICES_RESOLUTION_REQUEST", "", "UpdateBuyer", "getUpdateBuyer", "setUpdateBuyer", "imei_no", "", "getImei_no", "()Ljava/lang/String;", "setImei_no", "(Ljava/lang/String;)V", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SplashActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final String getImei_no() {
            return SplashActivity.imei_no;
        }

        public final void setImei_no(@Nullable String str) {
            SplashActivity.imei_no = str;
        }

        public final boolean getCreateBuyer() {
            return SplashActivity.CreateBuyer;
        }

        public final void setCreateBuyer(boolean z) {
            SplashActivity.CreateBuyer = z;
        }

        public final boolean getUpdateBuyer() {
            return SplashActivity.UpdateBuyer;
        }

        public final void setUpdateBuyer(boolean z) {
            SplashActivity.UpdateBuyer = z;
        }
    }
}
