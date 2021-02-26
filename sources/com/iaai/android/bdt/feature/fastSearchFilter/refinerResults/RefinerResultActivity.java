package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
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
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.auctionSalesList.OnNextPageLoad;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterViewModel;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody;
import com.iaai.android.bdt.utils.Constants_MVVM;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020)H\u0002J\u000e\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020,J\"\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\b\u00103\u001a\u00020)H\u0016J\u0012\u00104\u001a\u00020)2\b\u00105\u001a\u0004\u0018\u000106H\u0014J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u000e\u0010;\u001a\u00020)2\u0006\u0010\t\u001a\u00020\nJ\b\u0010<\u001a\u00020)H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u000e\u0010 \u001a\u00020!X.¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006="}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "ivStockShare", "Landroid/widget/ImageView;", "getIvStockShare", "()Landroid/widget/ImageView;", "setIvStockShare", "(Landroid/widget/ImageView;)V", "onNextPageLoad", "Lcom/iaai/android/bdt/feature/auctionSalesList/OnNextPageLoad;", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbarSubTitle", "Landroid/widget/TextView;", "getToolbarSubTitle", "()Landroid/widget/TextView;", "setToolbarSubTitle", "(Landroid/widget/TextView;)V", "toolbarTitle", "getToolbarTitle", "setToolbarTitle", "viewModel", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "initializeUI", "", "loadSwipedProductList", "requestBody", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "setOnNextPageLoad", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RefinerResultActivity.kt */
public final class RefinerResultActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    @NotNull
    public ImageView ivStockShare;
    /* access modifiers changed from: private */
    public OnNextPageLoad onNextPageLoad;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    public Toolbar toolbar;
    @NotNull
    public TextView toolbarSubTitle;
    @NotNull
    public TextView toolbarTitle;
    private FastSearchFilterViewModel viewModel;
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

    public static final /* synthetic */ OnNextPageLoad access$getOnNextPageLoad$p(RefinerResultActivity refinerResultActivity) {
        OnNextPageLoad onNextPageLoad2 = refinerResultActivity.onNextPageLoad;
        if (onNextPageLoad2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onNextPageLoad");
        }
        return onNextPageLoad2;
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
    public final TextView getToolbarTitle() {
        TextView textView = this.toolbarTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarTitle");
        }
        return textView;
    }

    public final void setToolbarTitle(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.toolbarTitle = textView;
    }

    @NotNull
    public final TextView getToolbarSubTitle() {
        TextView textView = this.toolbarSubTitle;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarSubTitle");
        }
        return textView;
    }

    public final void setToolbarSubTitle(@NotNull TextView textView) {
        Intrinsics.checkParameterIsNotNull(textView, "<set-?>");
        this.toolbarSubTitle = textView;
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        Activity activity = this;
        AndroidInjection.inject(activity);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_refiner_result);
        View findViewById = findViewById(C2723R.C2726id.toolbar);
        if (findViewById != null) {
            this.toolbar = (Toolbar) findViewById;
            View findViewById2 = findViewById(C2723R.C2726id.toolbar_title);
            if (findViewById2 != null) {
                this.toolbarTitle = (TextView) findViewById2;
                View findViewById3 = findViewById(C2723R.C2726id.toolbar_sub_title);
                if (findViewById3 != null) {
                    this.toolbarSubTitle = (TextView) findViewById3;
                    View findViewById4 = findViewById(C2723R.C2726id.ivShareAS);
                    if (findViewById4 != null) {
                        this.ivStockShare = (ImageView) findViewById4;
                        FragmentActivity fragmentActivity = this;
                        ViewModelProvider.Factory factory = this.viewModelFactory;
                        if (factory == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
                        }
                        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(FastSearchFilterViewModel.class);
                        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…terViewModel::class.java)");
                        this.viewModel = (FastSearchFilterViewModel) viewModel2;
                        subscribeToViewModel();
                        initializeUI();
                        NavController findNavController = Navigation.findNavController(activity, C2723R.C2726id.main_nav_host_fragment);
                        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
                        NavInflater navInflater = findNavController.getNavInflater();
                        Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
                        NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.navigation_refiner_result_graph);
                        Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.na…ion_refiner_result_graph)");
                        boolean booleanExtra = getIntent().getBooleanExtra(Constants_MVVM.EXTRA_IS_FROM_SAVED_SEARCH, false);
                        if (booleanExtra) {
                            NavArgument build = new NavArgument.Builder().setDefaultValue(getIntent().getStringExtra(Constants_MVVM.EXTRA_SAVED_SEARCH_PARAM)).build();
                            Intrinsics.checkExpressionValueIsNotNull(build, "NavArgument.Builder().se…ED_SEARCH_PARAM)).build()");
                            inflate.addArgument(Constants_MVVM.EXTRA_SAVED_SEARCH_PARAM, build);
                            NavArgument build2 = new NavArgument.Builder().setDefaultValue(Boolean.valueOf(booleanExtra)).build();
                            Intrinsics.checkExpressionValueIsNotNull(build2, "NavArgument.Builder().se…sFromSavedSearch).build()");
                            inflate.addArgument(Constants_MVVM.EXTRA_IS_FROM_SAVED_SEARCH, build2);
                        } else {
                            NavArgument build3 = new NavArgument.Builder().setDefaultValue(getIntent().getParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FACETS)).build();
                            Intrinsics.checkExpressionValueIsNotNull(build3, "NavArgument.Builder().se…SELECTED_FACETS)).build()");
                            inflate.addArgument(Constants_MVVM.EXTRA_SELECTED_FACETS, build3);
                            NavArgument build4 = new NavArgument.Builder().setDefaultValue(getIntent().getParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_INDICES)).build();
                            Intrinsics.checkExpressionValueIsNotNull(build4, "NavArgument.Builder().se…ELECTED_INDICES)).build()");
                            inflate.addArgument(Constants_MVVM.EXTRA_SELECTED_INDICES, build4);
                        }
                        NavArgument build5 = new NavArgument.Builder().setDefaultValue(Boolean.valueOf(getIntent().getBooleanExtra(Constants_MVVM.EXTRA_IS_FROM_LANDING_PAGE_SEARCH, false))).build();
                        Intrinsics.checkExpressionValueIsNotNull(build5, "NavArgument.Builder().se…GE_SEARCH,false)).build()");
                        inflate.addArgument(Constants_MVVM.EXTRA_IS_FROM_LANDING_PAGE_SEARCH, build5);
                        findNavController.setGraph(inflate);
                        ((ImageView) _$_findCachedViewById(C2723R.C2726id.im_pre_bid_close)).setOnClickListener(new RefinerResultActivity$onCreate$1(this));
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
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "toolbar_relativelayout");
        relativeLayout.setVisibility(0);
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "prebid_title_layout");
        constraintLayout.setVisibility(8);
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.toolbar_title);
        Intrinsics.checkExpressionValueIsNotNull(textView, Constants_MVVM.EXTRA_TOOLBAR_TITLE);
        textView.setText(getResources().getString(C2723R.string.lbl_search));
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.toolbar_sub_title);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "toolbar_sub_title");
        textView2.setVisibility(8);
        ImageView imageView = this.ivStockShare;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivStockShare");
        }
        imageView.setVisibility(8);
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSavedSearch);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvSavedSearch");
        textView3.setVisibility(0);
    }

    public final void setOnNextPageLoad(@NotNull OnNextPageLoad onNextPageLoad2) {
        Intrinsics.checkParameterIsNotNull(onNextPageLoad2, "onNextPageLoad");
        this.onNextPageLoad = onNextPageLoad2;
    }

    public final void loadSwipedProductList(@NotNull FastSearchRequestBody fastSearchRequestBody) {
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody, "requestBody");
        Log.e("TEST", "RequestBody: " + fastSearchRequestBody);
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
        FastSearchFilterViewModel fastSearchFilterViewModel = this.viewModel;
        if (fastSearchFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        fastSearchFilterViewModel.loadSwipedProductList("application/json", fastSearchRequestBody, format);
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        NavController findNavController = Navigation.findNavController(this, C2723R.C2726id.main_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
        if (!findNavController.popBackStack()) {
            IaaiApplication.isBackPressedFromRefinerResult = true;
            finish();
        }
        return true;
    }

    private final void subscribeToViewModel() {
        FastSearchFilterViewModel fastSearchFilterViewModel = this.viewModel;
        if (fastSearchFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        fastSearchFilterViewModel.getSwipedProductListResult().removeObservers(lifecycleOwner);
        FastSearchFilterViewModel fastSearchFilterViewModel2 = this.viewModel;
        if (fastSearchFilterViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        fastSearchFilterViewModel2.getSwipedProductListResult().observe(lifecycleOwner, new RefinerResultActivity$subscribeToViewModel$1(this));
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
}
