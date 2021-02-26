package com.iaai.android.bdt.feature.account;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.base.MVVMNavDrawerActivity;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingActivity;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingEnum;
import com.iaai.android.bdt.model.MyAccount.BDTDashboardResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.providers.IaaContent;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u000f\u0018\u0000 E2\u00020\u0001:\u0001EB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002J\b\u0010,\u001a\u00020)H\u0002J\b\u0010-\u001a\u00020)H\u0002J\b\u0010.\u001a\u00020)H\u0002J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u00020)H\u0002J\"\u00101\u001a\u00020)2\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\b\u00104\u001a\u0004\u0018\u00010+H\u0014J\u0012\u00105\u001a\u00020)2\b\u00106\u001a\u0004\u0018\u000107H\u0014J\b\u00108\u001a\u00020)H\u0014J\b\u00109\u001a\u00020)H\u0014J\b\u0010:\u001a\u00020)H\u0002J\u0010\u0010;\u001a\u00020)2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u00020)2\u0006\u0010?\u001a\u00020\fH\u0002J\b\u0010@\u001a\u00020)H\u0002J\u0010\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020\bH\u0002J\u0010\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020\nH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006F"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/BDTMyAccountActivity;", "Lcom/iaai/android/bdt/base/MVVMNavDrawerActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "bdtDashboardResponse", "Lcom/iaai/android/bdt/model/MyAccount/BDTDashboardResponse;", "buyNowOfferCount", "", "isPullToRefresh", "", "isShowMyVehicle", "mMessageReceiver", "com/iaai/android/bdt/feature/account/BDTMyAccountActivity$mMessageReceiver$1", "Lcom/iaai/android/bdt/feature/account/BDTMyAccountActivity$mMessageReceiver$1;", "myAccountPagerAdapter", "Lcom/iaai/android/bdt/feature/account/MyAccountPagerAdapter;", "getMyAccountPagerAdapter", "()Lcom/iaai/android/bdt/feature/account/MyAccountPagerAdapter;", "setMyAccountPagerAdapter", "(Lcom/iaai/android/bdt/feature/account/MyAccountPagerAdapter;)V", "setCurrentTab", "getSetCurrentTab", "()I", "setSetCurrentTab", "(I)V", "viewModel", "Lcom/iaai/android/bdt/feature/account/MyAccountViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/account/MyAccountViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/account/MyAccountViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "handleSwitchCheckChanged", "", "intent", "Landroid/content/Intent;", "initializeUI", "loadDashboardData", "navigateToBuyNowOffer", "navigateToManageOffer", "navigateToSettingPage", "onActivityResult", "requestCode", "resultCode", "data", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "performLogout", "setupViewPager", "myAccountPager", "Landroidx/viewpager/widget/ViewPager;", "showLoadingIndicator", "loading", "subscribeToViewModel", "updateNewCountFirstTime", "dashboardData", "updateNewCountForBNOFirstTime", "int_buyNowOfferCount", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTMyAccountActivity.kt */
public final class BDTMyAccountActivity extends MVVMNavDrawerActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String TAG;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public BDTDashboardResponse bdtDashboardResponse;
    /* access modifiers changed from: private */
    public int buyNowOfferCount;
    /* access modifiers changed from: private */
    public boolean isPullToRefresh;
    private boolean isShowMyVehicle;
    private final BDTMyAccountActivity$mMessageReceiver$1 mMessageReceiver = new BDTMyAccountActivity$mMessageReceiver$1(this);
    @NotNull
    public MyAccountPagerAdapter myAccountPagerAdapter;
    private int setCurrentTab;
    @NotNull
    public MyAccountViewModel viewModel;
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

    public BDTMyAccountActivity() {
        String simpleName = BDTMyAccountActivity.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "BDTMyAccountActivity::class.java.simpleName");
        this.TAG = simpleName;
    }

    public static final /* synthetic */ BDTDashboardResponse access$getBdtDashboardResponse$p(BDTMyAccountActivity bDTMyAccountActivity) {
        BDTDashboardResponse bDTDashboardResponse = bDTMyAccountActivity.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        return bDTDashboardResponse;
    }

    @NotNull
    public final MyAccountPagerAdapter getMyAccountPagerAdapter() {
        MyAccountPagerAdapter myAccountPagerAdapter2 = this.myAccountPagerAdapter;
        if (myAccountPagerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myAccountPagerAdapter");
        }
        return myAccountPagerAdapter2;
    }

    public final void setMyAccountPagerAdapter(@NotNull MyAccountPagerAdapter myAccountPagerAdapter2) {
        Intrinsics.checkParameterIsNotNull(myAccountPagerAdapter2, "<set-?>");
        this.myAccountPagerAdapter = myAccountPagerAdapter2;
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
    public final MyAccountViewModel getViewModel() {
        MyAccountViewModel myAccountViewModel = this.viewModel;
        if (myAccountViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return myAccountViewModel;
    }

    public final void setViewModel(@NotNull MyAccountViewModel myAccountViewModel) {
        Intrinsics.checkParameterIsNotNull(myAccountViewModel, "<set-?>");
        this.viewModel = myAccountViewModel;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    public final int getSetCurrentTab() {
        return this.setCurrentTab;
    }

    public final void setSetCurrentTab(int i) {
        this.setCurrentTab = i;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_bdt_my_account_layout);
        super.onCreateDrawer(bundle);
        IaaiApplication.getBus().register(this);
        IaaiApplication.getBus().register(this);
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(MyAccountViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…untViewModel::class.java)");
        this.viewModel = (MyAccountViewModel) viewModel2;
        initializeUI();
        Context context = this;
        LocalBroadcastManager.getInstance(context).registerReceiver(this.mMessageReceiver, new IntentFilter(Constants_MVVM.BROADCAST_VEHICLE_SWITCH_CHANGED));
        super.setUserNameAndBuyerID(getSessionManager());
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        if (instance.getIAARemoteConfig().getManageOfferHintFlag() && getSessionManager().isLoggedIn() && (!Intrinsics.areEqual((Object) getSessionManager().getCurrentSessionBuyerId(), (Object) "0"))) {
            Boolean isFirstLaunchForManageofferMyAccount = IAASharedPreference.getIsFirstLaunchForManageofferMyAccount(getApplicationContext());
            Intrinsics.checkExpressionValueIsNotNull(isFirstLaunchForManageofferMyAccount, "IAASharedPreference.getI…count(applicationContext)");
            if (isFirstLaunchForManageofferMyAccount.booleanValue()) {
                IAASharedPreference.setIsFirstLaunchForManageofferMyAccount(context, false);
                Intent intent = new Intent(context, OnBoardingActivity.class);
                intent.putExtra(Constants_MVVM.ON_BOARDING_ENUM_VALUE, OnBoardingEnum.MANAGE_OFFER_MYACCOUNT);
                startActivity(intent);
            }
        }
        if (getSessionManager().getCurrentSessionBuyerId() == null || !Intrinsics.areEqual((Object) getSessionManager().getCurrentSessionBuyerId(), (Object) "0")) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.ll_buyer_id_info);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "ll_buyer_id_info");
            linearLayout.setVisibility(0);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.ll_buyer_id_info);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "ll_buyer_id_info");
            linearLayout2.setVisibility(8);
        }
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_user_name);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_user_name");
        textView.setText(getSessionManager().getCurrentSessionFName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getSessionManager().getCurrentSessionLName());
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_buyer_id_info);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_buyer_id_info");
        textView2.setText(getSessionManager().getCurrentSessionBuyerId());
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_logout);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tv_logout");
        textView3.setPaintFlags(8);
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tv_logout)).setOnClickListener(new BDTMyAccountActivity$onCreate$1(this));
        ((SwipeRefreshLayout) _$_findCachedViewById(C2723R.C2726id.swipe_container)).setColorSchemeResources(C2723R.C2724color.refresh_progress_1, C2723R.C2724color.refresh_progress_2, C2723R.C2724color.refresh_progress_3);
        ((SwipeRefreshLayout) _$_findCachedViewById(C2723R.C2726id.swipe_container)).setOnRefreshListener(new BDTMyAccountActivity$onCreate$2(this));
        subscribeToViewModel();
    }

    /* access modifiers changed from: private */
    public final void loadDashboardData() {
        MyAccountViewModel myAccountViewModel = this.viewModel;
        if (myAccountViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        myAccountViewModel.loadDashboardData(String.valueOf(getSessionManager().getCurrentSessionUsername()), String.valueOf(getSessionManager().getCurrentSessionPassword()), String.valueOf(getSessionManager().getCurrentSessionUserId()), this.isShowMyVehicle);
        MyAccountViewModel myAccountViewModel2 = this.viewModel;
        if (myAccountViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        myAccountViewModel2.getBuyNowOfferCount(String.valueOf(getSessionManager().getCurrentSessionUserId()));
    }

    /* access modifiers changed from: private */
    public final void setupViewPager(ViewPager viewPager) {
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(supportFragmentManager, "supportFragmentManager");
        this.myAccountPagerAdapter = new MyAccountPagerAdapter(supportFragmentManager, this);
        MyAccountPagerAdapter myAccountPagerAdapter2 = this.myAccountPagerAdapter;
        if (myAccountPagerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myAccountPagerAdapter");
        }
        BDTDashboardResponse bDTDashboardResponse = this.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        myAccountPagerAdapter2.setDashBoardData(bDTDashboardResponse, this.isShowMyVehicle);
        MyAccountPagerAdapter myAccountPagerAdapter3 = this.myAccountPagerAdapter;
        if (myAccountPagerAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myAccountPagerAdapter");
        }
        myAccountPagerAdapter3.setBuyNowOfferData(this.buyNowOfferCount);
        MyAccountPagerAdapter myAccountPagerAdapter4 = this.myAccountPagerAdapter;
        if (myAccountPagerAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("myAccountPagerAdapter");
        }
        viewPager.setAdapter(myAccountPagerAdapter4);
        viewPager.setCurrentItem(this.setCurrentTab);
        ((TabLayout) _$_findCachedViewById(C2723R.C2726id.tl_my_account)).setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new BDTMyAccountActivity$setupViewPager$1(this));
    }

    private final void initializeUI() {
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar));
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar, "auction_toolbar");
        toolbar.setTitle((CharSequence) getResources().getString(C2723R.string.lbl_bdt_my_account));
        getWindow().setSoftInputMode(2);
        NavigationView navigationView = (NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view);
        Intrinsics.checkExpressionValueIsNotNull(navigationView, "nav_view");
        Menu menu = navigationView.getMenu();
        Intrinsics.checkExpressionValueIsNotNull(menu, "nav_view.menu");
        MenuItem findItem = menu.findItem(C2723R.C2726id.drawer_menu_myaccount);
        Intrinsics.checkExpressionValueIsNotNull(findItem, "menuItem");
        findItem.setChecked(true);
    }

    private final void subscribeToViewModel() {
        MyAccountViewModel myAccountViewModel = this.viewModel;
        if (myAccountViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        myAccountViewModel.getBDTDashboardResponse().observe(lifecycleOwner, new BDTMyAccountActivity$subscribeToViewModel$1(this));
        MyAccountViewModel myAccountViewModel2 = this.viewModel;
        if (myAccountViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        myAccountViewModel2.getDashboardError().observe(lifecycleOwner, new BDTMyAccountActivity$subscribeToViewModel$2(this));
        MyAccountViewModel myAccountViewModel3 = this.viewModel;
        if (myAccountViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        myAccountViewModel3.getBuyNowOfferResponse().observe(lifecycleOwner, new BDTMyAccountActivity$subscribeToViewModel$3(this));
        MyAccountViewModel myAccountViewModel4 = this.viewModel;
        if (myAccountViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        myAccountViewModel4.getOfferError().observe(lifecycleOwner, new BDTMyAccountActivity$subscribeToViewModel$4(this));
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pb_my_account);
            if (progressBar != null) {
                progressBar.setVisibility(0);
                return;
            }
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pb_my_account);
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void updateNewCountForBNOFirstTime(int i) {
        if (IaaiApplication.isUserLoginForBuyNowOffer) {
            IAASharedPreference.setDashBoardCount(this, Constants_MVVM.KEY_FOR_BUY_NOW_OFFER_COUNT_MYACCOUNT, i);
            IaaiApplication.isUserLoginForBuyNowOffer = false;
        }
    }

    /* access modifiers changed from: private */
    public final void performLogout() {
        Intent intent;
        Context context = this;
        getSessionManager().logout(context);
        getSessionManager().clearLoginResponseObject();
        IaaiApplication.isMyAccountScreenShowing = false;
        ContentResolver contentResolver = getContentResolver();
        if (contentResolver == null) {
            Intrinsics.throwNpe();
        }
        contentResolver.delete(IaaContent.Alert.CONTENT_URI, (String) null, (String[]) null);
        Toast.makeText(context, C2723R.string.msg_logout, 1).show();
        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_auction;
        ((DrawerLayout) _$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
        Intent intent2 = null;
        if (IaaiApplication.isBDTEnabled) {
            if (IaaiApplication.is_new_landing) {
                intent = new Intent(context, BDTLandingPageActivity.class);
            } else {
                intent = new Intent(context, BDTAuctionMainListActivity.class);
            }
            intent2 = intent;
        }
        startActivity(intent2);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IaaiApplication.isMyAccountScreenShowing = true;
        showLoadingIndicator(true);
        loadDashboardData();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 35) {
            navigateToManageOffer();
        } else if (i == 36) {
            navigateToBuyNowOffer();
        } else if (i == 40) {
            navigateToSettingPage();
        }
    }

    private final void navigateToSettingPage() {
        startActivity(new Intent(this, BDTSettingsActivity.class));
    }

    private final void navigateToManageOffer() {
        Intent intent = new Intent(this, ManageOfferListActivity.class);
        BDTDashboardResponse bDTDashboardResponse = this.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        if (bDTDashboardResponse != null) {
            BDTDashboardResponse bDTDashboardResponse2 = this.bdtDashboardResponse;
            if (bDTDashboardResponse2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
            }
            intent.putExtra(Constants_MVVM.EXTRA_MANAGE_OFFERS, bDTDashboardResponse2.getNegotiationOffers());
        }
        startActivity(intent);
    }

    private final void navigateToBuyNowOffer() {
        Intent intent = new Intent(this, BuyNowOfferListActivity.class);
        intent.putExtra(Constants.KEY_FOR_BUY_NOW_OFFER_COUNT_MYACCOUNT, this.buyNowOfferCount);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void handleSwitchCheckChanged(Intent intent) {
        boolean z = false;
        if (intent != null) {
            z = intent.getBooleanExtra("isShowMyVehicle", false);
        }
        this.isShowMyVehicle = z;
        showLoadingIndicator(true);
        loadDashboardData();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        MyAccountViewModel myAccountViewModel = this.viewModel;
        if (myAccountViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        myAccountViewModel.disposeElements();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(this.mMessageReceiver);
    }

    /* access modifiers changed from: private */
    public final void updateNewCountFirstTime(BDTDashboardResponse bDTDashboardResponse) {
        if (IaaiApplication.isUserLogin) {
            Context context = this;
            Integer winningPrebids = bDTDashboardResponse.getWinningPrebids();
            IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_PREBID_COUNT_MYACCOUNT, winningPrebids != null ? winningPrebids.intValue() : 0);
            Integer awardPending = bDTDashboardResponse.getAwardPending();
            IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_AWARD_PENDING_COUNT_MYACCOUNT, awardPending != null ? awardPending.intValue() : 0);
            Integer countofvehicles = bDTDashboardResponse.getCountofvehicles();
            IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_TOBEPAID_COUNT_MYACCOUNT, countofvehicles != null ? countofvehicles.intValue() : 0);
            Integer pickup = bDTDashboardResponse.getPickup();
            IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_TBPU_COUNT_MYACCOUNT, pickup != null ? pickup.intValue() : 0);
            Integer negotiationOffers = bDTDashboardResponse.getNegotiationOffers();
            IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_MANAGE_OFFERS_MYACCOUNT, negotiationOffers != null ? negotiationOffers.intValue() : 0);
            Integer watching = bDTDashboardResponse.getWatching();
            IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_WATCHING_COUNT_MYACCOUNT, watching != null ? watching.intValue() : 0);
            Integer alerts = bDTDashboardResponse.getAlerts();
            IAASharedPreference.setDashBoardCount(context, Constants_MVVM.KEY_FOR_NOTIFICATION_MYACCOUNT, alerts != null ? alerts.intValue() : 0);
            IaaiApplication.isUserLogin = false;
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/BDTMyAccountActivity$Companion;", "", "()V", "isTablet", "", "context", "Landroid/content/Context;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BDTMyAccountActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isTablet(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Resources resources = context.getResources();
            Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
            return (resources.getConfiguration().screenLayout & 15) >= 3;
        }
    }
}
