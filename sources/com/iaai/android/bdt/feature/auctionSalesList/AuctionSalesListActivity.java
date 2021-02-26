package com.iaai.android.bdt.feature.auctionSalesList;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSaleList;
import com.iaai.android.bdt.model.auctionSalesList.RequestBody;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import com.iaai.android.bdt.model.auctionmainlist.AuctionLocations;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.DateHelper;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002092\u0006\u0010E\u001a\u000209H\u0002J\b\u0010F\u001a\u00020GH\u0002J\u0016\u0010H\u001a\u00020G2\u0006\u0010D\u001a\u0002092\u0006\u0010E\u001a\u000209J\"\u0010I\u001a\u00020G2\u0006\u0010J\u001a\u0002092\u0006\u0010K\u001a\u0002092\b\u0010L\u001a\u0004\u0018\u00010MH\u0014J\b\u0010N\u001a\u00020GH\u0016J\u0012\u0010O\u001a\u00020G2\b\u0010P\u001a\u0004\u0018\u00010QH\u0014J\b\u0010R\u001a\u00020GH\u0014J\u0010\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020VH\u0016J\b\u0010W\u001a\u00020GH\u0014J\u0010\u0010X\u001a\u00020G2\u0006\u0010Y\u001a\u00020QH\u0014J\u000e\u0010Z\u001a\u00020G2\u0006\u0010\u001d\u001a\u00020\u001eJ\b\u0010[\u001a\u00020GH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\rj\b\u0012\u0004\u0012\u00020\u0004`\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020 0\rj\b\u0012\u0004\u0012\u00020 `\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020*X.¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X.¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001a\u00105\u001a\u000200X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00102\"\u0004\b7\u00104R\u000e\u00108\u001a\u000209X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X.¢\u0006\u0002\n\u0000R\u001e\u0010<\u001a\u00020=8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010A¨\u0006\\"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "auctionLocations", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations;", "auctionNowCloseReceiver", "Landroid/content/BroadcastReceiver;", "branchId", "branchName", "itemIdList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getItemIdList", "()Ljava/util/ArrayList;", "setItemIdList", "(Ljava/util/ArrayList;)V", "ivStockShare", "Landroid/widget/ImageView;", "getIvStockShare", "()Landroid/widget/ImageView;", "setIvStockShare", "(Landroid/widget/ImageView;)V", "live_date", "livedate", "Ljava/util/Date;", "name", "onNextPageLoad", "Lcom/iaai/android/bdt/feature/auctionSalesList/OnNextPageLoad;", "resultData", "Lcom/iaai/android/bdt/model/auctionSalesList/ResultData;", "getResultData", "setResultData", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar_sub_title", "Landroid/widget/TextView;", "getToolbar_sub_title", "()Landroid/widget/TextView;", "setToolbar_sub_title", "(Landroid/widget/TextView;)V", "toolbar_title", "getToolbar_title", "setToolbar_title", "vehiclecount", "", "viewModel", "Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "getRequestBody", "Lcom/iaai/android/bdt/model/auctionSalesList/RequestBody;", "start", "end", "initializeUI", "", "loadSwipedProductList", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onResume", "onSaveInstanceState", "outState", "setOnNextPageLoad", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionSalesListActivity.kt */
public final class AuctionSalesListActivity extends BaseActivity {
    private final String TAG = AuctionSalesListActivity.class.getSimpleName();
    private HashMap _$_findViewCache;
    private AuctionLocations auctionLocations;
    private final BroadcastReceiver auctionNowCloseReceiver = new AuctionSalesListActivity$auctionNowCloseReceiver$1(this);
    private String branchId = "";
    private String branchName = "";
    @NotNull
    private ArrayList<String> itemIdList = new ArrayList<>();
    @NotNull
    public ImageView ivStockShare;
    private String live_date = "";
    private Date livedate;
    private String name = "";
    /* access modifiers changed from: private */
    public OnNextPageLoad onNextPageLoad;
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
    private AuctionSalesListViewModel viewModel;
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

    public static final /* synthetic */ OnNextPageLoad access$getOnNextPageLoad$p(AuctionSalesListActivity auctionSalesListActivity) {
        OnNextPageLoad onNextPageLoad2 = auctionSalesListActivity.onNextPageLoad;
        if (onNextPageLoad2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onNextPageLoad");
        }
        return onNextPageLoad2;
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
    public final ArrayList<String> getItemIdList() {
        return this.itemIdList;
    }

    public final void setItemIdList(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.itemIdList = arrayList;
    }

    @NotNull
    public final ArrayList<ResultData> getResultData() {
        return this.resultData;
    }

    public final void setResultData(@NotNull ArrayList<ResultData> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.resultData = arrayList;
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
                        String stringExtra = getIntent().getStringExtra(Constants.EXTRA_BRANCH);
                        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "intent.getStringExtra(Constants.EXTRA_BRANCH)");
                        this.branchId = stringExtra;
                        this.name = getIntent().getStringExtra(Constants.EXTRA_NAME);
                        String stringExtra2 = getIntent().getStringExtra(Constants.EXTRA_DATE);
                        Intrinsics.checkExpressionValueIsNotNull(stringExtra2, "intent.getStringExtra(Constants.EXTRA_DATE)");
                        this.live_date = stringExtra2;
                        Date parseDateInServerTimezone = DateHelper.parseDateInServerTimezone(this.live_date);
                        Intrinsics.checkExpressionValueIsNotNull(parseDateInServerTimezone, "DateHelper.parseDateInServerTimezone(live_date)");
                        this.livedate = parseDateInServerTimezone;
                        this.vehiclecount = getIntent().getIntExtra(Constants.EXTRA_AUCTION_VEHICLE_COUNT, 0);
                        String stringExtra3 = getIntent().getStringExtra(Constants.EXTRA_BRANCH_NAME_TITLE);
                        Intrinsics.checkExpressionValueIsNotNull(stringExtra3, "intent.getStringExtra(Co….EXTRA_BRANCH_NAME_TITLE)");
                        this.branchName = stringExtra3;
                        registerReceiver(this.auctionNowCloseReceiver, new IntentFilter(Constants_MVVM.ACTION_AUCTION_NOW_EXIT));
                        FragmentActivity fragmentActivity = this;
                        ViewModelProvider.Factory factory = this.viewModelFactory;
                        if (factory == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
                        }
                        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(AuctionSalesListViewModel.class);
                        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…istViewModel::class.java)");
                        this.viewModel = (AuctionSalesListViewModel) viewModel2;
                        subscribeToViewModel();
                        initializeUI();
                        NavController findNavController = Navigation.findNavController(activity, C2723R.C2726id.main_nav_host_fragment);
                        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
                        NavInflater navInflater = findNavController.getNavInflater();
                        Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
                        NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.navigation_graph);
                        Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.navigation.navigation_graph)");
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
                        ((ImageView) _$_findCachedViewById(C2723R.C2726id.im_pre_bid_close)).setOnClickListener(new AuctionSalesListActivity$onCreate$1(this));
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
        textView.setText(getResources().getString(C2723R.string.lbl_bdt_sales_list));
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

    public final void loadSwipedProductList(int i, int i2) {
        AuctionSalesListViewModel auctionSalesListViewModel = this.viewModel;
        if (auctionSalesListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionSalesListViewModel.loadSwipedProductList(getRequestBody(i, i2));
    }

    private final RequestBody getRequestBody(int i, int i2) {
        Date date = this.livedate;
        if (date == null) {
            Intrinsics.throwUninitializedPropertyAccessException("livedate");
        }
        String format = DateHelper.format(date, Constants.DATE_PATTERN_WEBSERVICE_PARAM);
        String str = format;
        Intrinsics.checkExpressionValueIsNotNull(format, "wsDateString");
        int parseInt = Integer.parseInt(this.branchId);
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        return new RequestBody(new AuctionSaleList(str, parseInt, language, "android", "", "0", i2, "", "", 30, "", i, "", "", "", ""));
    }

    private final void subscribeToViewModel() {
        AuctionSalesListViewModel auctionSalesListViewModel = this.viewModel;
        if (auctionSalesListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        auctionSalesListViewModel.getSwipedProductListResult().removeObservers(lifecycleOwner);
        AuctionSalesListViewModel auctionSalesListViewModel2 = this.viewModel;
        if (auctionSalesListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionSalesListViewModel2.getSwipedProductListResult().observe(lifecycleOwner, new AuctionSalesListActivity$subscribeToViewModel$1(this));
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

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(this.auctionNowCloseReceiver);
    }
}
