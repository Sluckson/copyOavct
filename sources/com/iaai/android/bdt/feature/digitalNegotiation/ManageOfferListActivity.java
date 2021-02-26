package com.iaai.android.bdt.feature.digitalNegotiation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.auctionSalesList.OnNextPageLoad;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.ToolTipActvityStatus;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.AndroidInjection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010@\u001a\u00020AH\u0002J\"\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\u00182\u0006\u0010D\u001a\u00020\u00182\b\u0010E\u001a\u0004\u0018\u00010FH\u0014J\b\u0010G\u001a\u00020AH\u0016J\u0012\u0010H\u001a\u00020A2\b\u0010I\u001a\u0004\u0018\u00010JH\u0014J\u0010\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020AH\u0014J\u0010\u0010P\u001a\u00020A2\u0006\u0010Q\u001a\u00020JH\u0014J\u000e\u0010R\u001a\u00020A2\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010S\u001a\u00020AH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R*\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u000201X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u000201X.¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00103\"\u0004\b8\u00105R\u000e\u00109\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010:\u001a\u00020;8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?¨\u0006T"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "branchId", "branchName", "filterSelected", "Lcom/iaai/android/bdt/feature/digitalNegotiation/FilterSelected;", "getFilterSelected", "()Lcom/iaai/android/bdt/feature/digitalNegotiation/FilterSelected;", "setFilterSelected", "(Lcom/iaai/android/bdt/feature/digitalNegotiation/FilterSelected;)V", "ivStockShare", "Landroid/widget/ImageView;", "getIvStockShare", "()Landroid/widget/ImageView;", "setIvStockShare", "(Landroid/widget/ImageView;)V", "live_date", "livedate", "Ljava/util/Date;", "manageOffersCount", "", "name", "onNextPageLoad", "Lcom/iaai/android/bdt/feature/auctionSalesList/OnNextPageLoad;", "resultData", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "Lkotlin/collections/ArrayList;", "getResultData", "()Ljava/util/ArrayList;", "setResultData", "(Ljava/util/ArrayList;)V", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar_sub_title", "Landroid/widget/TextView;", "getToolbar_sub_title", "()Landroid/widget/TextView;", "setToolbar_sub_title", "(Landroid/widget/TextView;)V", "toolbar_title", "getToolbar_title", "setToolbar_title", "vehiclecount", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "initializeUI", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onResume", "onSaveInstanceState", "outState", "setOnNextPageLoad", "showDNToolTip", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferListActivity.kt */
public final class ManageOfferListActivity extends BaseActivity {
    private final String TAG = ManageOfferListActivity.class.getSimpleName();
    private HashMap _$_findViewCache;
    private String branchId = "";
    private String branchName = "";
    @NotNull
    private FilterSelected filterSelected = FilterSelected.ALL;
    @NotNull
    public ImageView ivStockShare;
    private String live_date = "";
    private Date livedate;
    private int manageOffersCount;
    private String name = "";
    private OnNextPageLoad onNextPageLoad;
    @NotNull
    private ArrayList<ResultData> resultData = new ArrayList<>();
    @Inject
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    public Toolbar toolbar;
    @NotNull
    public TextView toolbar_sub_title;
    @NotNull
    public TextView toolbar_title;
    private int vehiclecount;
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
    public final Toolbar getToolbar() {
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        return toolbar2;
    }

    public final void setToolbar(@NotNull Toolbar toolbar2) {
        Intrinsics.checkParameterIsNotNull(toolbar2, "<set-?>");
        this.toolbar = toolbar2;
    }

    @NotNull
    public final TextView getToolbar_title() {
        TextView textView = this.toolbar_title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Constants_MVVM.EXTRA_TOOLBAR_TITLE);
        }
        return textView;
    }

    public final void setToolbar_title(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.toolbar_title = textView;
    }

    @NotNull
    public final TextView getToolbar_sub_title() {
        TextView textView = this.toolbar_sub_title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar_sub_title");
        }
        return textView;
    }

    public final void setToolbar_sub_title(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.toolbar_sub_title = textView;
    }

    @NotNull
    public final ImageView getIvStockShare() {
        ImageView imageView = this.ivStockShare;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivStockShare");
        }
        return imageView;
    }

    public final void setIvStockShare(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.ivStockShare = imageView;
    }

    @NotNull
    public final ArrayList<ResultData> getResultData() {
        return this.resultData;
    }

    public final void setResultData(@NotNull ArrayList<ResultData> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.resultData = arrayList;
    }

    @NotNull
    public final FilterSelected getFilterSelected() {
        return this.filterSelected;
    }

    public final void setFilterSelected(@NotNull FilterSelected filterSelected2) {
        Intrinsics.checkParameterIsNotNull(filterSelected2, "<set-?>");
        this.filterSelected = filterSelected2;
    }

    @NotNull
    public final SessionManager getSessionManager() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        return sessionManager2;
    }

    public final void setSessionManager(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "<set-?>");
        this.sessionManager = sessionManager2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        Activity activity = this;
        AndroidInjection.inject(activity);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_auctionsales_list_fragment_container);
        View findViewById = findViewById(C2723R.C2726id.toolbar);
        if (findViewById != null) {
            this.toolbar = (Toolbar) findViewById;
            View findViewById2 = findViewById(C2723R.C2726id.toolbar_title);
            if (findViewById2 != null) {
                this.toolbar_title = (TextView) findViewById2;
                View findViewById3 = findViewById(C2723R.C2726id.toolbar_sub_title);
                if (findViewById3 != null) {
                    this.toolbar_sub_title = (TextView) findViewById3;
                    View findViewById4 = findViewById(C2723R.C2726id.ivShareAS);
                    if (findViewById4 != null) {
                        this.ivStockShare = (ImageView) findViewById4;
                        this.manageOffersCount = getIntent().getIntExtra(Constants_MVVM.EXTRA_MANAGE_OFFERS, 0);
                        this.branchId = "516";
                        this.name = "Detroit";
                        this.live_date = "2/11/2020 10:00:00 AM";
                        Date parseDateInServerTimezone = DateHelper.parseDateInServerTimezone(this.live_date);
                        Intrinsics.checkExpressionValueIsNotNull(parseDateInServerTimezone, "DateHelper.parseDateInServerTimezone(live_date)");
                        this.livedate = parseDateInServerTimezone;
                        this.vehiclecount = 151;
                        this.branchName = "Detroit";
                        IAASharedPreference.setDashBoardCount(this, Constants_MVVM.KEY_FOR_MANAGE_OFFERS_MYACCOUNT, this.manageOffersCount);
                        initializeUI();
                        NavController findNavController = Navigation.findNavController(activity, C2723R.C2726id.main_nav_host_fragment);
                        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
                        NavInflater navInflater = findNavController.getNavInflater();
                        Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
                        NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.manage_offer_navigation_graph);
                        Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.na…e_offer_navigation_graph)");
                        NavArgument build = new NavArgument.Builder().setDefaultValue(this.branchId).build();
                        Intrinsics.checkExpressionValueIsNotNull(build, "NavArgument.Builder().se…ltValue(branchId).build()");
                        inflate.addArgument(Constants.EXTRA_BRANCH, build);
                        NavArgument build2 = new NavArgument.Builder().setDefaultValue(this.live_date).build();
                        Intrinsics.checkExpressionValueIsNotNull(build2, "NavArgument.Builder().se…tValue(live_date).build()");
                        inflate.addArgument(Constants.EXTRA_DATE, build2);
                        NavArgument build3 = new NavArgument.Builder().setDefaultValue(this.name).build();
                        Intrinsics.checkExpressionValueIsNotNull(build3, "NavArgument.Builder().se…efaultValue(name).build()");
                        inflate.addArgument(Constants.EXTRA_NAME, build3);
                        NavArgument build4 = new NavArgument.Builder().setDefaultValue(this.branchName).build();
                        Intrinsics.checkExpressionValueIsNotNull(build4, "NavArgument.Builder().se…Value(branchName).build()");
                        inflate.addArgument(Constants.EXTRA_BRANCH_NAME_TITLE, build4);
                        NavArgument build5 = new NavArgument.Builder().setDefaultValue(Integer.valueOf(this.vehiclecount)).build();
                        Intrinsics.checkExpressionValueIsNotNull(build5, "NavArgument.Builder().se…lue(vehiclecount).build()");
                        inflate.addArgument(Constants.EXTRA_AUCTION_VEHICLE_COUNT, build5);
                        findNavController.setGraph(inflate);
                        ((ImageView) _$_findCachedViewById(C2723R.C2726id.im_pre_bid_close)).setOnClickListener(new ManageOfferListActivity$onCreate$1(this));
                        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivToolTip)).setOnClickListener(new ManageOfferListActivity$onCreate$2(this));
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
    }

    public final void setOnNextPageLoad(@NotNull OnNextPageLoad onNextPageLoad2) {
        Intrinsics.checkParameterIsNotNull(onNextPageLoad2, "onNextPageLoad");
        this.onNextPageLoad = onNextPageLoad2;
    }

    /* access modifiers changed from: private */
    public final void showDNToolTip() {
        Intent intent = new Intent(this, DNToolTipActivity.class);
        intent.putExtra(Constants_MVVM.EXTRA_TOOLBAR_TITLE, getString(C2723R.string.lbl_managing_offers));
        intent.putExtra(Constants_MVVM.EXTRA_TOOLTIP_STATUS, ToolTipActvityStatus.DN_ToolTip.getValue());
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IAAAnalytics.INSTANCE.logScreenName(IAAAnalytics.IAAScreenName.SALE_LIST.getValue(), this);
    }

    private final void initializeUI() {
        Toolbar toolbar2 = this.toolbar;
        if (toolbar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar");
        }
        setSupportActionBar(toolbar2);
        getWindow().setSoftInputMode(2);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setHomeButtonEnabled(true);
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setDisplayShowTitleEnabled(true);
        }
        TextView textView = this.toolbar_title;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException(Constants_MVVM.EXTRA_TOOLBAR_TITLE);
        }
        textView.setText(getResources().getString(C2723R.string.lbl_manage_offers));
        TextView textView2 = this.toolbar_sub_title;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar_sub_title");
        }
        textView2.setVisibility(8);
        ImageView imageView = this.ivStockShare;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivStockShare");
        }
        imageView.setVisibility(8);
        ImageView imageView2 = (ImageView) _$_findCachedViewById(C2723R.C2726id.ivToolTip);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "ivToolTip");
        imageView2.setVisibility(0);
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        FragmentManager childFragmentManager;
        List<Fragment> fragments;
        Fragment fragment;
        super.onActivityResult(i, i2, intent);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(C2723R.C2726id.main_nav_host_fragment);
        if (findFragmentById != null && (childFragmentManager = findFragmentById.getChildFragmentManager()) != null && (fragments = childFragmentManager.getFragments()) != null && (fragment = fragments.get(0)) != null) {
            fragment.onActivityResult(i, i2, intent);
        }
    }

    public void onBackPressed() {
        if (getResources().getBoolean(C2723R.bool.isTabletPhone)) {
            NavController findNavController = Navigation.findNavController(this, C2723R.C2726id.auction_sales_nav_container);
            Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…tion_sales_nav_container)");
            if (!findNavController.popBackStack()) {
                super.onBackPressed();
                return;
            }
            return;
        }
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.clear();
    }
}
