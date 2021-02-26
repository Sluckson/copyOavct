package com.iaai.android.bdt.feature.account.watchlist;

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
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.auctionSalesList.OnNextPageLoad;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.ToolTipActvityStatus;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.AndroidInjection;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00109\u001a\u00020:H\u0002J\u0016\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u000fJ\"\u0010>\u001a\u00020:2\u0006\u0010?\u001a\u00020\u000f2\u0006\u0010@\u001a\u00020\u000f2\b\u0010A\u001a\u0004\u0018\u00010BH\u0014J\b\u0010C\u001a\u00020:H\u0016J\u0012\u0010D\u001a\u00020:2\b\u0010E\u001a\u0004\u0018\u00010FH\u0014J\u0010\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020IH\u0016J\u0010\u0010J\u001a\u00020:2\u0006\u0010K\u001a\u00020FH\u0014J\u000e\u0010L\u001a\u00020:2\u0006\u0010\u0010\u001a\u00020\u0011J\b\u0010M\u001a\u00020:H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\"X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020(X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020(X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010*\"\u0004\b/\u0010,R\u000e\u00100\u001a\u000201X.¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0002038\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u000e\u00108\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "isMyItemsOnly", "", "ivStockShare", "Landroid/widget/ImageView;", "getIvStockShare", "()Landroid/widget/ImageView;", "setIvStockShare", "(Landroid/widget/ImageView;)V", "ivToolTip", "getIvToolTip", "setIvToolTip", "myAccountStatus", "", "onNextPageLoad", "Lcom/iaai/android/bdt/feature/auctionSalesList/OnNextPageLoad;", "preSaleListFragment", "Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListFragment;", "getPreSaleListFragment", "()Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListFragment;", "setPreSaleListFragment", "(Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListFragment;)V", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "toolTipStatus", "toolTipTitle", "", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar_sub_title", "Landroid/widget/TextView;", "getToolbar_sub_title", "()Landroid/widget/TextView;", "setToolbar_sub_title", "(Landroid/widget/TextView;)V", "toolbar_title", "getToolbar_title", "setToolbar_title", "viewModel", "Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "watchingCount", "initializeUI", "", "loadSwipedProductList", "start", "end", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onSaveInstanceState", "outState", "setOnNextPageLoad", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListActivity.kt */
public final class PreSaleListActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    private boolean isMyItemsOnly;
    @NotNull
    public ImageView ivStockShare;
    @NotNull
    public ImageView ivToolTip;
    private int myAccountStatus;
    /* access modifiers changed from: private */
    public OnNextPageLoad onNextPageLoad;
    @NotNull
    public PreSaleListFragment preSaleListFragment;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public int toolTipStatus;
    /* access modifiers changed from: private */
    public String toolTipTitle = "";
    @NotNull
    public Toolbar toolbar;
    @NotNull
    public TextView toolbar_sub_title;
    @NotNull
    public TextView toolbar_title;
    private PreSaleListViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;
    private int watchingCount;

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

    public static final /* synthetic */ OnNextPageLoad access$getOnNextPageLoad$p(PreSaleListActivity preSaleListActivity) {
        OnNextPageLoad onNextPageLoad2 = preSaleListActivity.onNextPageLoad;
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
    public final ImageView getIvToolTip() {
        ImageView imageView = this.ivToolTip;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivToolTip");
        }
        return imageView;
    }

    public final void setIvToolTip(@NotNull ImageView imageView) {
        Intrinsics.checkParameterIsNotNull(imageView, "<set-?>");
        this.ivToolTip = imageView;
    }

    @NotNull
    public final PreSaleListFragment getPreSaleListFragment() {
        PreSaleListFragment preSaleListFragment2 = this.preSaleListFragment;
        if (preSaleListFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListFragment");
        }
        return preSaleListFragment2;
    }

    public final void setPreSaleListFragment(@NotNull PreSaleListFragment preSaleListFragment2) {
        Intrinsics.checkParameterIsNotNull(preSaleListFragment2, "<set-?>");
        this.preSaleListFragment = preSaleListFragment2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        Activity activity = this;
        AndroidInjection.inject(activity);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_watch_list);
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
                        View findViewById5 = findViewById(C2723R.C2726id.ivToolTip);
                        if (findViewById5 != null) {
                            this.ivToolTip = (ImageView) findViewById5;
                            FragmentActivity fragmentActivity = this;
                            ViewModelProvider.Factory factory = this.viewModelFactory;
                            if (factory == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
                            }
                            ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(PreSaleListViewModel.class);
                            Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…istViewModel::class.java)");
                            this.viewModel = (PreSaleListViewModel) viewModel2;
                            this.watchingCount = getIntent().getIntExtra(Constants.WATCHING_SIZE, 0);
                            this.myAccountStatus = getIntent().getIntExtra("status", 0);
                            this.isMyItemsOnly = getIntent().getBooleanExtra("isMyItemOnly", false);
                            initializeUI();
                            this.preSaleListFragment = new PreSaleListFragment();
                            subscribeToViewModel();
                            NavController findNavController = Navigation.findNavController(activity, C2723R.C2726id.watch_main_nav_host_fragment);
                            Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…h_main_nav_host_fragment)");
                            NavInflater navInflater = findNavController.getNavInflater();
                            Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
                            NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.watch_list_navigation_graph);
                            Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.na…ch_list_navigation_graph)");
                            NavArgument build = new NavArgument.Builder().setDefaultValue(Integer.valueOf(this.watchingCount)).build();
                            Intrinsics.checkExpressionValueIsNotNull(build, "NavArgument.Builder().se…ue(watchingCount).build()");
                            NavArgument build2 = new NavArgument.Builder().setDefaultValue(Integer.valueOf(this.myAccountStatus)).build();
                            Intrinsics.checkExpressionValueIsNotNull(build2, "NavArgument.Builder().se…(myAccountStatus).build()");
                            NavArgument build3 = new NavArgument.Builder().setDefaultValue(Boolean.valueOf(this.isMyItemsOnly)).build();
                            Intrinsics.checkExpressionValueIsNotNull(build3, "NavArgument.Builder().se…ue(isMyItemsOnly).build()");
                            inflate.addArgument(Constants.WATCHING_SIZE, build);
                            inflate.addArgument("status", build2);
                            inflate.addArgument("isMyItemOnly", build3);
                            findNavController.setGraph(inflate);
                            ((ImageView) _$_findCachedViewById(C2723R.C2726id.im_pre_bid_close)).setOnClickListener(new PreSaleListActivity$onCreate$1(this));
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
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
        textView.setText("Watching");
        TextView textView2 = this.toolbar_sub_title;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar_sub_title");
        }
        textView2.setVisibility(0);
        int i = this.myAccountStatus;
        if (i == PreSaleListStatus.AWARD_PENDING.getValue()) {
            ImageView imageView = this.ivToolTip;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivToolTip");
            }
            imageView.setVisibility(0);
            this.toolTipStatus = ToolTipActvityStatus.Awawrd_Pending.getValue();
            String string = getString(C2723R.string.lbl_award_pending_tooltip);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.lbl_award_pending_tooltip)");
            this.toolTipTitle = string;
        } else if (i == PreSaleListStatus.PURCHASE_HISTORY.getValue()) {
            ImageView imageView2 = this.ivToolTip;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivToolTip");
            }
            imageView2.setVisibility(0);
            this.toolTipStatus = ToolTipActvityStatus.Purchase_History.getValue();
            String string2 = getString(C2723R.string.lbl_purchase_history_title);
            Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.lbl_purchase_history_title)");
            this.toolTipTitle = string2;
        } else {
            ImageView imageView3 = this.ivToolTip;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivToolTip");
            }
            imageView3.setVisibility(8);
        }
        ImageView imageView4 = (ImageView) _$_findCachedViewById(C2723R.C2726id.ivShareAS);
        Intrinsics.checkExpressionValueIsNotNull(imageView4, "ivShareAS");
        imageView4.setVisibility(8);
        ImageView imageView5 = this.ivToolTip;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivToolTip");
        }
        imageView5.setOnClickListener(new PreSaleListActivity$initializeUI$1(this));
    }

    public final void loadSwipedProductList(int i, int i2) {
        String str;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        objArr[0] = sessionManager2.getCurrentSessionUsername();
        SessionManager sessionManager3 = this.sessionManager;
        if (sessionManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        objArr[1] = sessionManager3.getCurrentSessionPassword();
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        PreSaleListViewModel preSaleListViewModel = this.viewModel;
        if (preSaleListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        SessionManager sessionManager4 = this.sessionManager;
        if (sessionManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        String currentSessionUserId = sessionManager4.getCurrentSessionUserId();
        String str2 = currentSessionUserId != null ? currentSessionUserId : "";
        String valueOf = String.valueOf(this.myAccountStatus);
        PreSaleListFragment preSaleListFragment2 = this.preSaleListFragment;
        if (preSaleListFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListFragment");
        }
        String sortBy = preSaleListFragment2.getSortBy();
        if (sortBy != null) {
            str = sortBy;
        } else {
            str = "";
        }
        PreSaleListFragment preSaleListFragment3 = this.preSaleListFragment;
        if (preSaleListFragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListFragment");
        }
        preSaleListViewModel.loadSwipedProductList(format, str2, false, 1, i, valueOf, str, preSaleListFragment3.getSortDirection(), "");
    }

    private final void subscribeToViewModel() {
        PreSaleListViewModel preSaleListViewModel = this.viewModel;
        if (preSaleListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        preSaleListViewModel.getSwipedProductListResult().removeObservers(lifecycleOwner);
        PreSaleListViewModel preSaleListViewModel2 = this.viewModel;
        if (preSaleListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        preSaleListViewModel2.getSwipedProductListResult().observe(lifecycleOwner, new PreSaleListActivity$subscribeToViewModel$1(this));
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        FragmentManager childFragmentManager;
        List<Fragment> fragments;
        Fragment fragment;
        super.onActivityResult(i, i2, intent);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(C2723R.C2726id.watch_main_nav_host_fragment);
        if (findFragmentById != null && (childFragmentManager = findFragmentById.getChildFragmentManager()) != null && (fragments = childFragmentManager.getFragments()) != null && (fragment = fragments.get(0)) != null) {
            fragment.onActivityResult(i, i2, intent);
        }
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
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
        if (this.myAccountStatus == PreSaleListStatus.AWARD_PENDING.getValue()) {
            ImageView imageView = this.ivToolTip;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivToolTip");
            }
            imageView.setVisibility(0);
        } else if (this.myAccountStatus == PreSaleListStatus.PURCHASE_HISTORY.getValue()) {
            ImageView imageView2 = this.ivToolTip;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivToolTip");
            }
            imageView2.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.clear();
    }
}
