package com.iaai.android.bdt.feature.auctionMainPage;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import com.google.android.material.navigation.NavigationView;
import com.google.inject.Injector;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.MVVMNavDrawerActivity;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.databinding.ActivityAuctionMainBinding;
import com.iaai.android.old.managers.BidManager;
import com.iaai.android.old.managers.CurrentLocationManager;
import com.iaai.android.old.managers.TermsOfUseBlendedSaleManager;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H\u0002J\u0012\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0014J\b\u0010(\u001a\u00020$H\u0014J\b\u0010)\u001a\u00020$H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000R\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006*"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListActivity;", "Lcom/iaai/android/bdt/base/MVVMNavDrawerActivity;", "()V", "auctionNowCloseReceiver", "Landroid/content/BroadcastReceiver;", "bidManager", "Lcom/iaai/android/old/managers/BidManager;", "getBidManager", "()Lcom/iaai/android/old/managers/BidManager;", "setBidManager", "(Lcom/iaai/android/old/managers/BidManager;)V", "currentLocationManager", "Lcom/iaai/android/old/managers/CurrentLocationManager;", "getCurrentLocationManager", "()Lcom/iaai/android/old/managers/CurrentLocationManager;", "setCurrentLocationManager", "(Lcom/iaai/android/old/managers/CurrentLocationManager;)V", "mBinding", "Lcom/iaai/android/databinding/ActivityAuctionMainBinding;", "searchDate", "", "termsOfUseManager", "Lcom/iaai/android/old/managers/TermsOfUseBlendedSaleManager;", "getTermsOfUseManager", "()Lcom/iaai/android/old/managers/TermsOfUseBlendedSaleManager;", "setTermsOfUseManager", "(Lcom/iaai/android/old/managers/TermsOfUseBlendedSaleManager;)V", "viewModel", "Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionMainListViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "initializeUI", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTAuctionMainListActivity.kt */
public final class BDTAuctionMainListActivity extends MVVMNavDrawerActivity {
    private HashMap _$_findViewCache;
    private final BroadcastReceiver auctionNowCloseReceiver = new BDTAuctionMainListActivity$auctionNowCloseReceiver$1(this);
    @NotNull
    public BidManager bidManager;
    @NotNull
    public CurrentLocationManager currentLocationManager;
    private ActivityAuctionMainBinding mBinding;
    private String searchDate = "";
    @NotNull
    public TermsOfUseBlendedSaleManager termsOfUseManager;
    private AuctionMainListViewModel viewModel;
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
    public final TermsOfUseBlendedSaleManager getTermsOfUseManager() {
        TermsOfUseBlendedSaleManager termsOfUseBlendedSaleManager = this.termsOfUseManager;
        if (termsOfUseBlendedSaleManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("termsOfUseManager");
        }
        return termsOfUseBlendedSaleManager;
    }

    public final void setTermsOfUseManager(@NotNull TermsOfUseBlendedSaleManager termsOfUseBlendedSaleManager) {
        Intrinsics.checkParameterIsNotNull(termsOfUseBlendedSaleManager, "<set-?>");
        this.termsOfUseManager = termsOfUseBlendedSaleManager;
    }

    @NotNull
    public final BidManager getBidManager() {
        BidManager bidManager2 = this.bidManager;
        if (bidManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bidManager");
        }
        return bidManager2;
    }

    public final void setBidManager(@NotNull BidManager bidManager2) {
        Intrinsics.checkParameterIsNotNull(bidManager2, "<set-?>");
        this.bidManager = bidManager2;
    }

    @NotNull
    public final CurrentLocationManager getCurrentLocationManager() {
        CurrentLocationManager currentLocationManager2 = this.currentLocationManager;
        if (currentLocationManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentLocationManager");
        }
        return currentLocationManager2;
    }

    public final void setCurrentLocationManager(@NotNull CurrentLocationManager currentLocationManager2) {
        Intrinsics.checkParameterIsNotNull(currentLocationManager2, "<set-?>");
        this.currentLocationManager = currentLocationManager2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Activity activity = this;
        AndroidInjection.inject(activity);
        setContentView((int) C2723R.C2728layout.activity_bdt_auction_main);
        super.onCreateDrawer(bundle);
        initializeUI();
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(AuctionMainListViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…istViewModel::class.java)");
        this.viewModel = (AuctionMainListViewModel) viewModel2;
        Application application = getApplication();
        if (application != null) {
            Injector injector = ((IaaiApplication) application).getInjector();
            Object instance = injector.getInstance(TermsOfUseBlendedSaleManager.class);
            Intrinsics.checkExpressionValueIsNotNull(instance, "injector.getInstance(Ter…dSaleManager::class.java)");
            this.termsOfUseManager = (TermsOfUseBlendedSaleManager) instance;
            Object instance2 = injector.getInstance(BidManager.class);
            Intrinsics.checkExpressionValueIsNotNull(instance2, "injector.getInstance(BidManager::class.java)");
            this.bidManager = (BidManager) instance2;
            Object instance3 = injector.getInstance(CurrentLocationManager.class);
            Intrinsics.checkExpressionValueIsNotNull(instance3, "injector.getInstance(Cur…ationManager::class.java)");
            this.currentLocationManager = (CurrentLocationManager) instance3;
            registerReceiver(this.auctionNowCloseReceiver, new IntentFilter(Constants_MVVM.ACTION_AUCTION_NOW_EXIT));
            super.setUserNameAndBuyerID(getSessionManager());
            NavController findNavController = Navigation.findNavController(activity, C2723R.C2726id.bdt_auction_main_nav_host_fragment);
            Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…n_main_nav_host_fragment)");
            NavInflater navInflater = findNavController.getNavInflater();
            Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
            NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.auction_main_navigation_graph);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.na…on_main_navigation_graph)");
            if (getIntent().hasExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY)) {
                NavArgument build = new NavArgument.Builder().setDefaultValue(getIntent().getStringExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY)).build();
                Intrinsics.checkExpressionValueIsNotNull(build, "NavArgument.Builder().se…EARCH_INPUT_KEY)).build()");
                inflate.addArgument(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, build);
                setMIsUserPressedBack(true);
            }
            if (getIntent().hasExtra(Constants_MVVM.EXTRA_QUICK_FILTER_SELECTED_DATE)) {
                setMIsUserPressedBack(true);
                NavArgument build2 = new NavArgument.Builder().setDefaultValue(getIntent().getStringExtra(Constants_MVVM.EXTRA_QUICK_FILTER_SELECTED_DATE)).build();
                Intrinsics.checkExpressionValueIsNotNull(build2, "NavArgument.Builder().se…R_SELECTED_DATE)).build()");
                inflate.addArgument(Constants_MVVM.EXTRA_QUICK_FILTER_SELECTED_DATE, build2);
            }
            findNavController.setGraph(inflate);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.IaaiApplication");
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IAAAnalytics.INSTANCE.logScreenName(IAAAnalytics.IAAScreenName.AUCTION_LIST.getValue(), this);
    }

    private final void initializeUI() {
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar));
        Toolbar toolbar = (Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(toolbar, "auction_toolbar");
        toolbar.setTitle((CharSequence) getString(C2723R.string.lbl_bdt_live_Auction_calendar));
        getWindow().setSoftInputMode(2);
        NavigationView navigationView = (NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view);
        Intrinsics.checkExpressionValueIsNotNull(navigationView, "nav_view");
        Menu menu = navigationView.getMenu();
        Intrinsics.checkExpressionValueIsNotNull(menu, "nav_view.menu");
        MenuItem findItem = menu.findItem(C2723R.C2726id.drawer_menu_auction);
        Intrinsics.checkExpressionValueIsNotNull(findItem, "menuItem");
        findItem.setChecked(true);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.auctionNowCloseReceiver);
    }
}
