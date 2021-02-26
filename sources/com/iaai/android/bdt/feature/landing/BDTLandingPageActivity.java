package com.iaai.android.bdt.feature.landing;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.text.Layout;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.AlignmentSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.MVVMNavDrawerActivity;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity;
import com.iaai.android.bdt.feature.landing.recommendedVehicles.RecommendedVehiclesFragment;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingEnum;
import com.iaai.android.bdt.feature.productDetail.ProductDetailActivity;
import com.iaai.android.bdt.model.BrokerHelpInfo;
import com.iaai.android.bdt.model.DashBoardDetails;
import com.iaai.android.bdt.model.announcement.AnnouncementMessage;
import com.iaai.android.bdt.model.deeplink.DeepLinkInfo;
import com.iaai.android.bdt.model.deeplink.DeepLinkKey;
import com.iaai.android.bdt.model.recommendedVehicles.RecommendedVehiclesResponse;
import com.iaai.android.bdt.remoteconfig.FetchRemoteConfigCallback;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.old.fcm.FcmListenerService;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.AndroidInjection;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.p055io.CloseableKt;
import kotlin.p055io.TextStreamsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000f\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u00020GH\u0002J\b\u0010I\u001a\u000200H\u0002J\b\u0010J\u001a\u00020GH\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010\u000b2\u0006\u0010L\u001a\u00020MH\u0002J\b\u0010N\u001a\u00020GH\u0002J\u0012\u0010O\u001a\u00020\u00052\b\u0010P\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010Q\u001a\u00020GH\u0002J\b\u0010R\u001a\u00020\u000bH\u0002J\u001c\u0010S\u001a\u00020G2\u0006\u0010T\u001a\u00020\u00052\f\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u001cJ\b\u0010W\u001a\u00020GH\u0002J\u0018\u0010X\u001a\u00020G2\u0006\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\\J\u0010\u0010]\u001a\u00020G2\b\u0010[\u001a\u0004\u0018\u00010\\J\u0014\u0010^\u001a\u00020G2\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010_\u001a\u00020GH\u0002J\b\u0010`\u001a\u00020GH\u0002J\b\u0010a\u001a\u00020GH\u0002J\b\u0010b\u001a\u00020GH\u0002J\b\u0010c\u001a\u00020GH\u0002J\b\u0010d\u001a\u00020GH\u0002J\"\u0010e\u001a\u00020G2\u0006\u0010f\u001a\u00020\u00052\u0006\u0010g\u001a\u00020\u00052\b\u0010h\u001a\u0004\u0018\u00010iH\u0014J\u0012\u0010j\u001a\u00020G2\b\u0010k\u001a\u0004\u0018\u00010lH\u0014J\u0012\u0010m\u001a\u00020G2\b\u0010n\u001a\u0004\u0018\u00010iH\u0014J+\u0010o\u001a\u00020G2\u0006\u0010f\u001a\u00020\u00052\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\u000b0q2\u0006\u0010r\u001a\u00020sH\u0016¢\u0006\u0002\u0010tJ\b\u0010u\u001a\u00020GH\u0014J\n\u0010v\u001a\u0004\u0018\u00010\u000bH\u0002J\b\u0010w\u001a\u00020GH\u0002J\b\u0010x\u001a\u00020GH\u0002J\u0010\u0010y\u001a\u00020G2\u0006\u0010z\u001a\u00020\u0005H\u0002J\b\u0010{\u001a\u00020GH\u0002J\b\u0010|\u001a\u00020GH\u0002J\b\u0010}\u001a\u00020GH\u0002J\b\u0010~\u001a\u00020GH\u0002J\b\u0010\u001a\u00020GH\u0002J\u0018\u0010\u0001\u001a\u00020G2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u000fH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u001cX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\u00020*X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010:\u001a\u00020;X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001e\u0010@\u001a\u00020A8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/BDTLandingPageActivity;", "Lcom/iaai/android/bdt/base/MVVMNavDrawerActivity;", "Lcom/iaai/android/bdt/remoteconfig/FetchRemoteConfigCallback;", "()V", "REQUEST_PERMISSIONS_LOCATION_REQUEST_CODE", "", "getREQUEST_PERMISSIONS_LOCATION_REQUEST_CODE", "()I", "setREQUEST_PERMISSIONS_LOCATION_REQUEST_CODE", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "addresses", "", "Landroid/location/Address;", "getAddresses", "()Ljava/util/List;", "setAddresses", "(Ljava/util/List;)V", "brokerHelpInfo", "Lcom/iaai/android/bdt/model/BrokerHelpInfo;", "getBrokerHelpInfo", "()Lcom/iaai/android/bdt/model/BrokerHelpInfo;", "setBrokerHelpInfo", "(Lcom/iaai/android/bdt/model/BrokerHelpInfo;)V", "brokerHelpInfoList", "Ljava/util/ArrayList;", "getBrokerHelpInfoList", "()Ljava/util/ArrayList;", "setBrokerHelpInfoList", "(Ljava/util/ArrayList;)V", "dashBoardDetails", "Lcom/iaai/android/bdt/model/DashBoardDetails;", "getDashBoardDetails", "()Lcom/iaai/android/bdt/model/DashBoardDetails;", "setDashBoardDetails", "(Lcom/iaai/android/bdt/model/DashBoardDetails;)V", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "geocoder", "Landroid/location/Geocoder;", "getGeocoder", "()Landroid/location/Geocoder;", "setGeocoder", "(Landroid/location/Geocoder;)V", "isPushNotificationOrigin", "", "()Z", "setPushNotificationOrigin", "(Z)V", "location", "Landroid/location/Location;", "getLocation", "()Landroid/location/Location;", "setLocation", "(Landroid/location/Location;)V", "viewModel", "Lcom/iaai/android/bdt/feature/landing/LandingPageViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/landing/LandingPageViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/landing/LandingPageViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "OnRemoteConfigAvailable", "", "checkIfPushNotificationClick", "checkPermissions", "fetchAnnouncementMessage", "getCountryCodeUsingNetwork", "context", "Landroid/content/Context;", "getDynamicLink", "getFlag", "countryCode", "getLastLocation", "getRandomAdsUrl", "getRecommendedVehicleClicked", "position", "vehiclesList", "Lcom/iaai/android/bdt/model/recommendedVehicles/RecommendedVehiclesResponse;", "getRecommendedVehicles", "handelDeepLinkKey", "deepLinkInfo", "Lcom/iaai/android/bdt/model/deeplink/DeepLinkInfo;", "deepLink", "Landroid/net/Uri;", "handleDeeplink", "handleFlagMSG", "initializeUI", "launchMangeOfferHintScreen", "launchPreSaleListActivity", "loadAds", "loadDashBoardDeatils", "navigateToManageOfferPage", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "intent", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "readJSONFromAsset", "refreshUIBasedOnLogin", "setDashBoardValues", "setFlagIcon", "drawableFlag", "showFlagMessagePopUp", "startLocationPermissionRequest", "subscribeToViewModel", "updateAnnouncementMessage", "updateDashBoardCount", "updateRecommendedVehiclesSection", "recommendedVehicles", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTLandingPageActivity.kt */
public final class BDTLandingPageActivity extends MVVMNavDrawerActivity implements FetchRemoteConfigCallback {
    private int REQUEST_PERMISSIONS_LOCATION_REQUEST_CODE = 101;
    @NotNull
    private final String TAG;
    private HashMap _$_findViewCache;
    @NotNull
    public List<? extends Address> addresses;
    @NotNull
    public BrokerHelpInfo brokerHelpInfo;
    @NotNull
    public ArrayList<BrokerHelpInfo> brokerHelpInfoList;
    @NotNull
    public DashBoardDetails dashBoardDetails;
    private FusedLocationProviderClient fusedLocationClient;
    @NotNull
    public Geocoder geocoder;
    private boolean isPushNotificationOrigin;
    @NotNull
    public Location location;
    @NotNull
    public LandingPageViewModel viewModel;
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

    public BDTLandingPageActivity() {
        String simpleName = BDTLandingPageActivity.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "BDTLandingPageActivity::class.java.simpleName");
        this.TAG = simpleName;
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
    public final LandingPageViewModel getViewModel() {
        LandingPageViewModel landingPageViewModel = this.viewModel;
        if (landingPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return landingPageViewModel;
    }

    public final void setViewModel(@NotNull LandingPageViewModel landingPageViewModel) {
        Intrinsics.checkParameterIsNotNull(landingPageViewModel, "<set-?>");
        this.viewModel = landingPageViewModel;
    }

    @NotNull
    public final DashBoardDetails getDashBoardDetails() {
        DashBoardDetails dashBoardDetails2 = this.dashBoardDetails;
        if (dashBoardDetails2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dashBoardDetails");
        }
        return dashBoardDetails2;
    }

    public final void setDashBoardDetails(@NotNull DashBoardDetails dashBoardDetails2) {
        Intrinsics.checkParameterIsNotNull(dashBoardDetails2, "<set-?>");
        this.dashBoardDetails = dashBoardDetails2;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    public final boolean isPushNotificationOrigin() {
        return this.isPushNotificationOrigin;
    }

    public final void setPushNotificationOrigin(boolean z) {
        this.isPushNotificationOrigin = z;
    }

    @NotNull
    public final ArrayList<BrokerHelpInfo> getBrokerHelpInfoList() {
        ArrayList<BrokerHelpInfo> arrayList = this.brokerHelpInfoList;
        if (arrayList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("brokerHelpInfoList");
        }
        return arrayList;
    }

    public final void setBrokerHelpInfoList(@NotNull ArrayList<BrokerHelpInfo> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.brokerHelpInfoList = arrayList;
    }

    @NotNull
    public final BrokerHelpInfo getBrokerHelpInfo() {
        BrokerHelpInfo brokerHelpInfo2 = this.brokerHelpInfo;
        if (brokerHelpInfo2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("brokerHelpInfo");
        }
        return brokerHelpInfo2;
    }

    public final void setBrokerHelpInfo(@NotNull BrokerHelpInfo brokerHelpInfo2) {
        Intrinsics.checkParameterIsNotNull(brokerHelpInfo2, "<set-?>");
        this.brokerHelpInfo = brokerHelpInfo2;
    }

    @NotNull
    public final Location getLocation() {
        Location location2 = this.location;
        if (location2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("location");
        }
        return location2;
    }

    public final void setLocation(@NotNull Location location2) {
        Intrinsics.checkParameterIsNotNull(location2, "<set-?>");
        this.location = location2;
    }

    @NotNull
    public final List<Address> getAddresses() {
        List<? extends Address> list = this.addresses;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addresses");
        }
        return list;
    }

    public final void setAddresses(@NotNull List<? extends Address> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.addresses = list;
    }

    @NotNull
    public final Geocoder getGeocoder() {
        Geocoder geocoder2 = this.geocoder;
        if (geocoder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("geocoder");
        }
        return geocoder2;
    }

    public final void setGeocoder(@NotNull Geocoder geocoder2) {
        Intrinsics.checkParameterIsNotNull(geocoder2, "<set-?>");
        this.geocoder = geocoder2;
    }

    public final int getREQUEST_PERMISSIONS_LOCATION_REQUEST_CODE() {
        return this.REQUEST_PERMISSIONS_LOCATION_REQUEST_CODE;
    }

    public final void setREQUEST_PERMISSIONS_LOCATION_REQUEST_CODE(int i) {
        this.REQUEST_PERMISSIONS_LOCATION_REQUEST_CODE = i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Activity activity = this;
        AndroidInjection.inject(activity);
        setContentView((int) C2723R.C2728layout.activity_bdt_find_vehicle);
        super.onCreateDrawer(bundle);
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(LandingPageViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…ageViewModel::class.java)");
        this.viewModel = (LandingPageViewModel) viewModel2;
        getSystemService("location");
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity);
        Intrinsics.checkExpressionValueIsNotNull(fusedLocationProviderClient, "LocationServices.getFuse…ationProviderClient(this)");
        this.fusedLocationClient = fusedLocationProviderClient;
        Context context = this;
        this.geocoder = new Geocoder(context);
        initializeUI();
        this.isPushNotificationOrigin = getIntent().getBooleanExtra(Constants_MVVM.EXTRA_ORIGIN_PUSH_NOTIFICATION, false);
        Activity_ExtensionKt.isLatestAppInstalled(this);
        if (Activity_ExtensionKt.isLoginExpire(this)) {
            getSessionManager().logout(context);
        }
        getDynamicLink();
        loadAds();
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnCreateOrSignIn)).setOnClickListener(new BDTLandingPageActivity$onCreate$1(this));
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivIaaAds)).setOnClickListener(new BDTLandingPageActivity$onCreate$2(this));
        getRecommendedVehicles();
        subscribeToViewModel();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IAAAnalytics.INSTANCE.logScreenName(IAAAnalytics.IAAScreenName.HOME.getValue(), this);
        fetchAnnouncementMessage();
        refreshUIBasedOnLogin();
    }

    private final void refreshUIBasedOnLogin() {
        if (getSessionManager().isLoggedIn()) {
            if (!Intrinsics.areEqual((Object) getSessionManager().getCurrentSessionBuyerId(), (Object) "0")) {
                launchMangeOfferHintScreen();
            }
            setDashBoardValues();
            loadDashBoardDeatils();
        } else {
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C2723R.C2726id.frSignInCreateAccount);
            Intrinsics.checkExpressionValueIsNotNull(frameLayout, "frSignInCreateAccount");
            frameLayout.setVisibility(0);
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.llDashBoardLayout);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "llDashBoardLayout");
            _$_findCachedViewById.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llRecommendedVehicleLayout);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llRecommendedVehicleLayout");
            linearLayout.setVisibility(8);
        }
        getRecommendedVehicles();
    }

    private final void launchMangeOfferHintScreen() {
        Boolean isFirstLaunchForManageofferHome = IAASharedPreference.getIsFirstLaunchForManageofferHome(getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(isFirstLaunchForManageofferHome, "IAASharedPreference.getI…rHome(applicationContext)");
        if (isFirstLaunchForManageofferHome.booleanValue()) {
            IaaiApplication instance = IaaiApplication.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
            if (instance.getIAARemoteConfig().getManageOfferHintFlag()) {
                Context_ExtensionKt.launchOnBoardingScreen(this, OnBoardingEnum.MANAGE_OFFER_HOME);
            }
        }
    }

    private final void setDashBoardValues() {
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C2723R.C2726id.frSignInCreateAccount);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout, "frSignInCreateAccount");
        frameLayout.setVisibility(8);
        View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.llDashBoardLayout);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "llDashBoardLayout");
        _$_findCachedViewById.setVisibility(0);
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvLoggedInUser);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvLoggedInUser");
        textView.setText(getString(C2723R.string.lbl_welcome) + ", " + getSessionManager().getCurrentSessionFName() + ' ' + getSessionManager().getCurrentSessionLName());
        if (!Intrinsics.areEqual((Object) getSessionManager().getCurrentSessionBuyerId(), (Object) "0")) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llMenuManageOffers);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llMenuManageOffers");
            linearLayout.setVisibility(0);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llMenuManageOffers);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llMenuManageOffers");
            linearLayout2.setVisibility(8);
        }
        updateDashBoardCount();
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llMenuWatch)).setOnClickListener(new BDTLandingPageActivity$setDashBoardValues$1(this));
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llMenuPayment)).setOnClickListener(new BDTLandingPageActivity$setDashBoardValues$2(this));
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llMenuPickUp)).setOnClickListener(new BDTLandingPageActivity$setDashBoardValues$3(this));
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llMenuManageOffers)).setOnClickListener(new BDTLandingPageActivity$setDashBoardValues$4(this));
    }

    /* access modifiers changed from: private */
    public final void navigateToManageOfferPage() {
        Intent intent = new Intent(this, ManageOfferListActivity.class);
        if (this.dashBoardDetails != null) {
            DashBoardDetails dashBoardDetails2 = this.dashBoardDetails;
            if (dashBoardDetails2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dashBoardDetails");
            }
            intent.putExtra(Constants_MVVM.EXTRA_MANAGE_OFFERS, dashBoardDetails2.getNegotiationOffers());
        }
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0168  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateDashBoardCount() {
        /*
            r9 = this;
            r0 = r9
            com.iaai.android.bdt.feature.landing.BDTLandingPageActivity r0 = (com.iaai.android.bdt.feature.landing.BDTLandingPageActivity) r0
            com.iaai.android.bdt.model.DashBoardDetails r1 = r0.dashBoardDetails
            java.lang.String r2 = "tvWatchCount"
            r3 = 41
            r4 = 40
            r5 = 8
            r6 = 0
            java.lang.String r7 = "dashBoardDetails"
            if (r1 == 0) goto L_0x0070
            com.iaai.android.bdt.model.DashBoardDetails r1 = r9.dashBoardDetails
            if (r1 != 0) goto L_0x0019
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x0019:
            java.lang.Integer r1 = r1.getWatching()
            if (r1 == 0) goto L_0x0070
            com.iaai.android.bdt.model.DashBoardDetails r1 = r9.dashBoardDetails
            if (r1 != 0) goto L_0x0026
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x0026:
            java.lang.Integer r1 = r1.getWatching()
            if (r1 == 0) goto L_0x0031
            int r1 = r1.intValue()
            goto L_0x0032
        L_0x0031:
            r1 = 0
        L_0x0032:
            if (r1 <= 0) goto L_0x0070
            int r1 = com.iaai.android.C2723R.C2726id.tvWatchCount
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r1.setVisibility(r6)
            int r1 = com.iaai.android.C2723R.C2726id.tvWatchCount
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            com.iaai.android.bdt.model.DashBoardDetails r8 = r9.dashBoardDetails
            if (r8 != 0) goto L_0x005c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x005c:
            java.lang.Integer r8 = r8.getWatching()
            r2.append(r8)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            goto L_0x007e
        L_0x0070:
            int r1 = com.iaai.android.C2723R.C2726id.tvWatchCount
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r1.setVisibility(r5)
        L_0x007e:
            com.iaai.android.bdt.model.DashBoardDetails r1 = r0.dashBoardDetails
            java.lang.String r2 = "tvToBePaidCount"
            if (r1 == 0) goto L_0x00e2
            com.iaai.android.bdt.model.DashBoardDetails r1 = r9.dashBoardDetails
            if (r1 != 0) goto L_0x008b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x008b:
            java.lang.Integer r1 = r1.getCountofvehicles()
            if (r1 == 0) goto L_0x00e2
            com.iaai.android.bdt.model.DashBoardDetails r1 = r9.dashBoardDetails
            if (r1 != 0) goto L_0x0098
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x0098:
            java.lang.Integer r1 = r1.getCountofvehicles()
            if (r1 == 0) goto L_0x00a3
            int r1 = r1.intValue()
            goto L_0x00a4
        L_0x00a3:
            r1 = 0
        L_0x00a4:
            if (r1 <= 0) goto L_0x00e2
            int r1 = com.iaai.android.C2723R.C2726id.tvToBePaidCount
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r1.setVisibility(r6)
            int r1 = com.iaai.android.C2723R.C2726id.tvToBePaidCount
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            com.iaai.android.bdt.model.DashBoardDetails r8 = r9.dashBoardDetails
            if (r8 != 0) goto L_0x00ce
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x00ce:
            java.lang.Integer r8 = r8.getCountofvehicles()
            r2.append(r8)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            goto L_0x00f0
        L_0x00e2:
            int r1 = com.iaai.android.C2723R.C2726id.tvToBePaidCount
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r1.setVisibility(r5)
        L_0x00f0:
            com.iaai.android.bdt.model.DashBoardDetails r1 = r0.dashBoardDetails
            java.lang.String r2 = "tvPickUpCount"
            if (r1 == 0) goto L_0x0154
            com.iaai.android.bdt.model.DashBoardDetails r1 = r9.dashBoardDetails
            if (r1 != 0) goto L_0x00fd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x00fd:
            java.lang.Integer r1 = r1.getPickup()
            if (r1 == 0) goto L_0x0154
            com.iaai.android.bdt.model.DashBoardDetails r1 = r9.dashBoardDetails
            if (r1 != 0) goto L_0x010a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x010a:
            java.lang.Integer r1 = r1.getPickup()
            if (r1 == 0) goto L_0x0115
            int r1 = r1.intValue()
            goto L_0x0116
        L_0x0115:
            r1 = 0
        L_0x0116:
            if (r1 <= 0) goto L_0x0154
            int r1 = com.iaai.android.C2723R.C2726id.tvPickUpCount
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r1.setVisibility(r6)
            int r1 = com.iaai.android.C2723R.C2726id.tvPickUpCount
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r4)
            com.iaai.android.bdt.model.DashBoardDetails r8 = r9.dashBoardDetails
            if (r8 != 0) goto L_0x0140
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x0140:
            java.lang.Integer r8 = r8.getPickup()
            r2.append(r8)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1.setText(r2)
            goto L_0x0162
        L_0x0154:
            int r1 = com.iaai.android.C2723R.C2726id.tvPickUpCount
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.TextView r1 = (android.widget.TextView) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r2)
            r1.setVisibility(r5)
        L_0x0162:
            com.iaai.android.bdt.model.DashBoardDetails r0 = r0.dashBoardDetails
            java.lang.String r1 = "tvMenuManageOffersCount"
            if (r0 == 0) goto L_0x01c6
            com.iaai.android.bdt.model.DashBoardDetails r0 = r9.dashBoardDetails
            if (r0 != 0) goto L_0x016f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x016f:
            java.lang.Integer r0 = r0.getNegotiationOffers()
            if (r0 == 0) goto L_0x01c6
            com.iaai.android.bdt.model.DashBoardDetails r0 = r9.dashBoardDetails
            if (r0 != 0) goto L_0x017c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x017c:
            java.lang.Integer r0 = r0.getNegotiationOffers()
            if (r0 == 0) goto L_0x0187
            int r0 = r0.intValue()
            goto L_0x0188
        L_0x0187:
            r0 = 0
        L_0x0188:
            if (r0 <= 0) goto L_0x01c6
            int r0 = com.iaai.android.C2723R.C2726id.tvMenuManageOffersCount
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r0.setVisibility(r6)
            int r0 = com.iaai.android.C2723R.C2726id.tvMenuManageOffersCount
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            com.iaai.android.bdt.model.DashBoardDetails r2 = r9.dashBoardDetails
            if (r2 != 0) goto L_0x01b2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
        L_0x01b2:
            java.lang.Integer r2 = r2.getNegotiationOffers()
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            goto L_0x01d4
        L_0x01c6:
            int r0 = com.iaai.android.C2723R.C2726id.tvMenuManageOffersCount
            android.view.View r0 = r9._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r0.setVisibility(r5)
        L_0x01d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.landing.BDTLandingPageActivity.updateDashBoardCount():void");
    }

    private final void initializeUI() {
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar));
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar, "auction_toolbar");
        toolbar.setTitle((CharSequence) "");
        getWindow().setSoftInputMode(2);
        NavigationView navigationView = (NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view);
        Intrinsics.checkExpressionValueIsNotNull(navigationView, "nav_view");
        Menu menu = navigationView.getMenu();
        Intrinsics.checkExpressionValueIsNotNull(menu, "nav_view.menu");
        MenuItem findItem = menu.findItem(C2723R.C2726id.drawer_menu_dashboard);
        Intrinsics.checkExpressionValueIsNotNull(findItem, "menuItem");
        findItem.setChecked(true);
        if (checkPermissions()) {
            getLastLocation();
        } else {
            startLocationPermissionRequest();
        }
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.img_flag)).setOnClickListener(new BDTLandingPageActivity$initializeUI$1(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tv_gethelp)).setOnClickListener(new BDTLandingPageActivity$initializeUI$2(this));
    }

    private final void fetchAnnouncementMessage() {
        Activity_ExtensionKt.fetchRemoteConfigValue(this, this);
    }

    private final void updateAnnouncementMessage() {
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        for (AnnouncementMessage announcementMessage : instance.getIAARemoteConfig().getAnnouncementMessage()) {
            if (StringsKt.equals(announcementMessage.getSubject(), "system", true)) {
                if (NewDateHelper.INSTANCE.getDateInRange(NewDateHelper.INSTANCE.getFormattedDate(announcementMessage.getStartdate()), NewDateHelper.INSTANCE.getFormattedDate(announcementMessage.getEnddate()))) {
                    TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvAnnouncementMessage);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "tvAnnouncementMessage");
                    textView.setVisibility(0);
                    TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvAnnouncementMessage);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, "tvAnnouncementMessage");
                    textView2.setMovementMethod(LinkMovementMethod.getInstance());
                    ((TextView) _$_findCachedViewById(C2723R.C2726id.tvAnnouncementMessage)).setLinkTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darkest));
                    if (Build.VERSION.SDK_INT >= 24) {
                        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvAnnouncementMessage);
                        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvAnnouncementMessage");
                        textView3.setText(Html.fromHtml(announcementMessage.getMessage(), 63));
                    } else {
                        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvAnnouncementMessage);
                        Intrinsics.checkExpressionValueIsNotNull(textView4, "tvAnnouncementMessage");
                        textView4.setText(Html.fromHtml(announcementMessage.getMessage()));
                    }
                }
            }
        }
    }

    private final void getDynamicLink() {
        Activity activity = this;
        FirebaseDynamicLinks.getInstance().getDynamicLink(getIntent()).addOnSuccessListener(activity, new BDTLandingPageActivity$getDynamicLink$1(this)).addOnFailureListener(activity, (OnFailureListener) new BDTLandingPageActivity$getDynamicLink$2(this));
    }

    public final void handleDeeplink(@Nullable Uri uri) {
        if (uri != null) {
            IaaiApplication instance = IaaiApplication.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
            Iterator<DeepLinkInfo> it = instance.getIAARemoteConfig().getDeepLinkInfoList().iterator();
            while (it.hasNext()) {
                DeepLinkInfo next = it.next();
                if (StringsKt.equals(next.getDeep_link_path(), uri.getPath(), true)) {
                    Intrinsics.checkExpressionValueIsNotNull(next, "deepLinkInfo");
                    handelDeepLinkKey(next, uri);
                    return;
                }
            }
        }
    }

    public final void handelDeepLinkKey(@NotNull DeepLinkInfo deepLinkInfo, @Nullable Uri uri) {
        Intrinsics.checkParameterIsNotNull(deepLinkInfo, "deepLinkInfo");
        String deep_link_name = deepLinkInfo.getDeep_link_name();
        if (Intrinsics.areEqual((Object) deep_link_name, (Object) DeepLinkKey.my_watchlist.getValue())) {
            if (getSessionManager().isLoggedIn()) {
                launchPreSaleListActivity();
            } else {
                getSessionManager().promptForLoginIfNeededBDT(this, 32);
            }
        } else if (Intrinsics.areEqual((Object) deep_link_name, (Object) DeepLinkKey.vehicle_details.getValue())) {
            String str = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("ITEM ID ");
            String str2 = null;
            sb.append(uri != null ? uri.getQueryParameter("itemid") : null);
            Log.e(str, sb.toString());
            String queryParameter = uri != null ? uri.getQueryParameter("itemid") : null;
            if (uri != null) {
                str2 = uri.getQueryParameter("tenant");
            }
            Intent intent = new Intent(this, ProductDetailActivity.class);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra(Constants.EXTRA_ITEM_ID, queryParameter);
            intent.putExtra("countryCode", str2);
            intent.putExtra("isFromSearchVehicle", false);
            intent.putExtra(Constants.EXTRA_YEAR_MAKE_MODEL, "");
            startActivity(intent);
            setMIsUserPressedBack(true);
        }
    }

    /* access modifiers changed from: private */
    public final void launchPreSaleListActivity() {
        Intent intent = new Intent(this, PreSaleListActivity.class);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("status", 1);
        intent.putExtra("isMyItemOnly", false);
        if (this.dashBoardDetails != null) {
            String str = Constants.WATCHING_SIZE;
            DashBoardDetails dashBoardDetails2 = this.dashBoardDetails;
            if (dashBoardDetails2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dashBoardDetails");
            }
            intent.putExtra(str, dashBoardDetails2.getWatching());
        }
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(@Nullable Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        getDynamicLink();
        refreshUIBasedOnLogin();
        boolean z = false;
        if (intent != null) {
            z = intent.getBooleanExtra(Constants_MVVM.EXTRA_ORIGIN_PUSH_NOTIFICATION, false);
        }
        this.isPushNotificationOrigin = z;
    }

    private final void checkIfPushNotificationClick() {
        if (this.isPushNotificationOrigin) {
            this.isPushNotificationOrigin = false;
            if (Intrinsics.areEqual((Object) getIntent().getStringExtra(Constants_MVVM.EXTRA_ORIGIN_PUSH_NOTIFICATION_TYPE), (Object) FcmListenerService.TAG_DIGITAL_NEGOTATION) && !getSessionManager().promptForLoginIfNeedFromActivity(this, this, 35)) {
                navigateToManageOfferPage();
            }
        }
    }

    private final void subscribeToViewModel() {
        LandingPageViewModel landingPageViewModel = this.viewModel;
        if (landingPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        landingPageViewModel.getDashBordDetailsResult().observe(lifecycleOwner, new BDTLandingPageActivity$subscribeToViewModel$1(this));
        LandingPageViewModel landingPageViewModel2 = this.viewModel;
        if (landingPageViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        landingPageViewModel2.getRecommendedVehiclesResponse().observe(lifecycleOwner, new BDTLandingPageActivity$subscribeToViewModel$2(this));
    }

    private final void loadDashBoardDeatils() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = {getSessionManager().getCurrentSessionUsername(), getSessionManager().getCurrentSessionPassword()};
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        LandingPageViewModel landingPageViewModel = this.viewModel;
        if (landingPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String currentSessionUserId = getSessionManager().getCurrentSessionUserId();
        if (currentSessionUserId == null) {
            Intrinsics.throwNpe();
        }
        landingPageViewModel.getDashBoardDeatils(Integer.parseInt(currentSessionUserId), format, 0);
    }

    private final void getRecommendedVehicles() {
        if (getSessionManager().isLoggedIn()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = {getSessionManager().getCurrentSessionUsername(), getSessionManager().getCurrentSessionPassword()};
            String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            LandingPageViewModel landingPageViewModel = this.viewModel;
            if (landingPageViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            landingPageViewModel.getRecommendedVehicles(format);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 31) {
            refreshUIBasedOnLogin();
            getRecommendedVehicles();
        } else if (i == 32) {
            launchPreSaleListActivity();
        } else if (i == 35) {
            navigateToManageOfferPage();
        }
    }

    /* access modifiers changed from: private */
    public final void updateRecommendedVehiclesSection(List<RecommendedVehiclesResponse> list) {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llRecommendedVehicleLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llRecommendedVehicleLayout");
        linearLayout.setVisibility(0);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(C2723R.C2726id.frRecommendedVehicles);
        if (findFragmentById != null) {
            ((RecommendedVehiclesFragment) findFragmentById).setData(list);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.landing.recommendedVehicles.RecommendedVehiclesFragment");
    }

    public final void getRecommendedVehicleClicked(int i, @NotNull ArrayList<RecommendedVehiclesResponse> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "vehiclesList");
        ArrayList arrayList2 = new ArrayList();
        for (RecommendedVehiclesResponse itemid : arrayList) {
            arrayList2.add(String.valueOf(itemid.getItemid()));
        }
        Intent intent = new Intent(this, LandingBRESectionActivity.class);
        intent.putExtra(Constants_MVVM.EXTRA_ITEM_POSITION, i);
        intent.putStringArrayListExtra(Constants_MVVM.EXTRA_ITEM_IDS_LIST, arrayList2);
        startActivity(intent);
    }

    public void OnRemoteConfigAvailable() {
        Activity_ExtensionKt.isLatestAppInstalled(this);
        updateAnnouncementMessage();
        loadAds();
        checkIfPushNotificationClick();
        setBrokerCommunityHelpLink();
    }

    private final String getRandomAdsUrl() {
        Random random = new Random();
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        ArrayList<String> adsURL = instance.getIAARemoteConfig().getAdsURL();
        IaaiApplication instance2 = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance2, "IaaiApplication.getInstance()");
        String str = adsURL.get(random.nextInt(instance2.getIAARemoteConfig().getAdsURL().size()));
        Intrinsics.checkExpressionValueIsNotNull(str, "IaaiApplication.getInsta…emoteConfig.adsURL.size)]");
        return str;
    }

    private final void loadAds() {
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        if (instance.getIAARemoteConfig().getAdsURL().size() > 0) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llAds);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llAds");
            linearLayout.setVisibility(0);
            WebView webView = (WebView) _$_findCachedViewById(C2723R.C2726id.webViewAds);
            Intrinsics.checkExpressionValueIsNotNull(webView, "webViewAds");
            WebSettings settings = webView.getSettings();
            Intrinsics.checkExpressionValueIsNotNull(settings, "webViewAds.settings");
            settings.setJavaScriptEnabled(true);
            String randomAdsUrl = getRandomAdsUrl();
            if (StringsKt.contains((CharSequence) randomAdsUrl, (CharSequence) Constants_MVVM.LOCAL_TOW_BUYER_APP_ADV, true)) {
                WebView webView2 = (WebView) _$_findCachedViewById(C2723R.C2726id.webViewAds);
                Intrinsics.checkExpressionValueIsNotNull(webView2, "webViewAds");
                webView2.setVisibility(8);
                ImageView imageView = (ImageView) _$_findCachedViewById(C2723R.C2726id.ivIaaAds);
                Intrinsics.checkExpressionValueIsNotNull(imageView, "ivIaaAds");
                imageView.setVisibility(0);
                return;
            }
            WebView webView3 = (WebView) _$_findCachedViewById(C2723R.C2726id.webViewAds);
            Intrinsics.checkExpressionValueIsNotNull(webView3, "webViewAds");
            webView3.setVisibility(0);
            ImageView imageView2 = (ImageView) _$_findCachedViewById(C2723R.C2726id.ivIaaAds);
            Intrinsics.checkExpressionValueIsNotNull(imageView2, "ivIaaAds");
            imageView2.setVisibility(8);
            ((WebView) _$_findCachedViewById(C2723R.C2726id.webViewAds)).loadUrl(randomAdsUrl);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llAds);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llAds");
        linearLayout2.setVisibility(8);
    }

    private final boolean checkPermissions() {
        return ContextCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    private final void startLocationPermissionRequest() {
        ActivityCompat.requestPermissions(this, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, this.REQUEST_PERMISSIONS_LOCATION_REQUEST_CODE);
    }

    public void onRequestPermissionsResult(int i, @NotNull String[] strArr, @NotNull int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "permissions");
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == this.REQUEST_PERMISSIONS_LOCATION_REQUEST_CODE) {
            if (!(!(iArr.length == 0)) || iArr[0] == 0) {
                getLastLocation();
                return;
            }
            Context applicationContext = getApplicationContext();
            Intrinsics.checkExpressionValueIsNotNull(applicationContext, "applicationContext");
            handleFlagMSG(getCountryCodeUsingNetwork(applicationContext));
        }
    }

    private final void getLastLocation() {
        FusedLocationProviderClient fusedLocationProviderClient = this.fusedLocationClient;
        if (fusedLocationProviderClient == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fusedLocationClient");
        }
        fusedLocationProviderClient.getLastLocation().addOnSuccessListener(new BDTLandingPageActivity$getLastLocation$1(this));
    }

    static /* synthetic */ void handleFlagMSG$default(BDTLandingPageActivity bDTLandingPageActivity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "";
        }
        bDTLandingPageActivity.handleFlagMSG(str);
    }

    /* access modifiers changed from: private */
    public final void handleFlagMSG(String str) {
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.cl_flagConatiner);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "cl_flagConatiner");
        constraintLayout.setVisibility(8);
        String readJSONFromAsset = readJSONFromAsset();
        if (readJSONFromAsset == null) {
            readJSONFromAsset = "";
        }
        if (!StringsKt.equals(readJSONFromAsset, "", false) && !StringsKt.equals(str, "", false)) {
            Object fromJson = new Gson().fromJson(readJSONFromAsset, new BDTLandingPageActivity$handleFlagMSG$1().getType());
            Intrinsics.checkExpressionValueIsNotNull(fromJson, "Gson().fromJson(countryJ…okerHelpInfo>>() {}.type)");
            this.brokerHelpInfoList = (ArrayList) fromJson;
            ArrayList<BrokerHelpInfo> arrayList = this.brokerHelpInfoList;
            if (arrayList == null) {
                Intrinsics.throwUninitializedPropertyAccessException("brokerHelpInfoList");
            }
            Iterator<BrokerHelpInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                BrokerHelpInfo next = it.next();
                if (StringsKt.equals(next.getCountryCode(), str, false)) {
                    Intrinsics.checkExpressionValueIsNotNull(next, "brokerHelpInfoItem");
                    this.brokerHelpInfo = next;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.cl_flagConatiner);
                    Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "cl_flagConatiner");
                    constraintLayout2.setVisibility(0);
                    setFlagIcon(getFlag(str));
                    TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_flaglabel);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "tv_flaglabel");
                    Resources resources = getResources();
                    Object[] objArr = new Object[1];
                    BrokerHelpInfo brokerHelpInfo2 = this.brokerHelpInfo;
                    if (brokerHelpInfo2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("brokerHelpInfo");
                    }
                    objArr[0] = brokerHelpInfo2.getCountryName();
                    textView.setText(resources.getString(C2723R.string.lbl_flaglabel, objArr));
                    return;
                }
            }
        }
    }

    private final int getFlag(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) CountryCode.Country_Azerbaijan.getValue())) {
            return C2723R.C2725drawable.ic_flag_az;
        }
        if (Intrinsics.areEqual((Object) str, (Object) CountryCode.Country_Georgia.getValue())) {
            return C2723R.C2725drawable.ic_flag_ge;
        }
        if (Intrinsics.areEqual((Object) str, (Object) CountryCode.Country_Armenia.getValue())) {
            return C2723R.C2725drawable.ic_flag_am;
        }
        if (Intrinsics.areEqual((Object) str, (Object) CountryCode.Country_Ukraine.getValue())) {
            return C2723R.C2725drawable.ic_flag_ua;
        }
        if (Intrinsics.areEqual((Object) str, (Object) CountryCode.Country_Lebanon.getValue())) {
            return C2723R.C2725drawable.ic_flag_lb;
        }
        if (Intrinsics.areEqual((Object) str, (Object) CountryCode.Country_Poland.getValue())) {
            return C2723R.C2725drawable.ic_flag_pl;
        }
        return 0;
    }

    private final void setFlagIcon(int i) {
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.img_flag)).setImageResource(i);
    }

    private final String getCountryCodeUsingNetwork(Context context) {
        Object systemService = context != null ? context.getSystemService("phone") : null;
        if (systemService != null) {
            String networkCountryIso = ((TelephonyManager) systemService).getNetworkCountryIso();
            if (!TextUtils.isEmpty(networkCountryIso)) {
                return Util.toUpperInvariant(networkCountryIso);
            }
            Locale locale = Locale.getDefault();
            Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
            return Util.toUpperInvariant(locale.getCountry());
        }
        throw new TypeCastException("null cannot be cast to non-null type android.telephony.TelephonyManager");
    }

    /* access modifiers changed from: private */
    public final void showFlagMessagePopUp() {
        AlertDialog alertDialog;
        try {
            SpannableString spannableString = new SpannableString(getResources().getString(C2723R.string.lbl_flag_title));
            spannableString.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, spannableString.length(), 0);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String str = "";
            if (this.brokerHelpInfo != null) {
                StringBuilder sb = new StringBuilder();
                BrokerHelpInfo brokerHelpInfo2 = this.brokerHelpInfo;
                if (brokerHelpInfo2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("brokerHelpInfo");
                }
                String nativeContent = brokerHelpInfo2.getNativeContent();
                if (nativeContent == null) {
                    nativeContent = str;
                }
                sb.append(nativeContent);
                sb.append(" \n\n");
                BrokerHelpInfo brokerHelpInfo3 = this.brokerHelpInfo;
                if (brokerHelpInfo3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("brokerHelpInfo");
                }
                String englishContent = brokerHelpInfo3.getEnglishContent();
                if (englishContent != null) {
                    str = englishContent;
                }
                sb.append(str);
                str = sb.toString();
            }
            builder.setMessage((CharSequence) str).setCancelable(false).setTitle((CharSequence) spannableString).setPositiveButton((int) C2723R.string.lbl_bdt_get_help, (DialogInterface.OnClickListener) new BDTLandingPageActivity$showFlagMessagePopUp$2(this));
            builder.setNegativeButton((CharSequence) getResources().getString(C2723R.string.lbl_bdt_close), (DialogInterface.OnClickListener) BDTLandingPageActivity$showFlagMessagePopUp$3.INSTANCE);
            alertDialog = builder.show();
            View findViewById = alertDialog.findViewById(16908299);
            if (findViewById != null) {
                ((TextView) findViewById).setGravity(3);
                if (alertDialog != null) {
                    alertDialog.show();
                    return;
                }
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        } catch (Exception unused) {
            alertDialog = null;
        }
    }

    private final String readJSONFromAsset() {
        Closeable bufferedReader;
        String str = null;
        try {
            InputStream open = getAssets().open("BrokerHelpInfo.json");
            Intrinsics.checkExpressionValueIsNotNull(open, "assets.open(\"BrokerHelpInfo.json\")");
            Reader inputStreamReader = new InputStreamReader(open, Charsets.UTF_8);
            bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            Throwable th = null;
            String readText = TextStreamsKt.readText((BufferedReader) bufferedReader);
            CloseableKt.closeFinally(bufferedReader, th);
            return readText;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th2) {
            CloseableKt.closeFinally(bufferedReader, r1);
            throw th2;
        }
    }
}
