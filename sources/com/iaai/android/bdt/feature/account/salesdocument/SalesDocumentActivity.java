package com.iaai.android.bdt.feature.account.salesdocument;

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
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import com.iaai.android.BuildConfig;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.feature.auctionSalesList.OnNextPageLoad;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.MyAccount.SaleDocumentRequestBody;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.AppUtils;
import dagger.android.AndroidInjection;
import java.util.ArrayList;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00101\u001a\u000202H\u0002J\u0016\u00103\u001a\u0002022\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000205J\u0010\u00107\u001a\u0002082\u0006\u00104\u001a\u000205H\u0002J\"\u00109\u001a\u0002022\u0006\u0010:\u001a\u0002052\u0006\u0010;\u001a\u0002052\b\u0010<\u001a\u0004\u0018\u00010=H\u0014J\b\u0010>\u001a\u000202H\u0016J\u0012\u0010?\u001a\u0002022\b\u0010@\u001a\u0004\u0018\u00010AH\u0014J\u0010\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020EH\u0016J\u000e\u0010F\u001a\u0002022\u0006\u0010\f\u001a\u00020\rJ\b\u0010G\u001a\u000202H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020!X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u000e\u0010)\u001a\u00020*X.¢\u0006\u0002\n\u0000R\u001e\u0010+\u001a\u00020,8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006H"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "ivStockShare", "Landroid/widget/ImageView;", "getIvStockShare", "()Landroid/widget/ImageView;", "setIvStockShare", "(Landroid/widget/ImageView;)V", "ivToolTip", "getIvToolTip", "setIvToolTip", "onNextPageLoad", "Lcom/iaai/android/bdt/feature/auctionSalesList/OnNextPageLoad;", "salesDocumentFragment", "Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentFragment;", "getSalesDocumentFragment", "()Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentFragment;", "setSalesDocumentFragment", "(Lcom/iaai/android/bdt/feature/account/salesdocument/SalesDocumentFragment;)V", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "toolbar_sub_title", "Landroid/widget/TextView;", "getToolbar_sub_title", "()Landroid/widget/TextView;", "setToolbar_sub_title", "(Landroid/widget/TextView;)V", "toolbar_title", "getToolbar_title", "setToolbar_title", "viewModel", "Lcom/iaai/android/bdt/feature/account/salesdocument/SaleDocumentViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "initializeUI", "", "loadSwipedProductList", "start", "", "end", "makeRequestBody", "Lcom/iaai/android/bdt/model/MyAccount/SaleDocumentRequestBody;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "setOnNextPageLoad", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SalesDocumentActivity.kt */
public final class SalesDocumentActivity extends BaseActivity {
    private HashMap _$_findViewCache;
    @NotNull
    public ImageView ivStockShare;
    @NotNull
    public ImageView ivToolTip;
    /* access modifiers changed from: private */
    public OnNextPageLoad onNextPageLoad;
    @NotNull
    public SalesDocumentFragment salesDocumentFragment;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    public Toolbar toolbar;
    @NotNull
    public TextView toolbar_sub_title;
    @NotNull
    public TextView toolbar_title;
    private SaleDocumentViewModel viewModel;
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

    public static final /* synthetic */ OnNextPageLoad access$getOnNextPageLoad$p(SalesDocumentActivity salesDocumentActivity) {
        OnNextPageLoad onNextPageLoad2 = salesDocumentActivity.onNextPageLoad;
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
    public final SalesDocumentFragment getSalesDocumentFragment() {
        SalesDocumentFragment salesDocumentFragment2 = this.salesDocumentFragment;
        if (salesDocumentFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentFragment");
        }
        return salesDocumentFragment2;
    }

    public final void setSalesDocumentFragment(@NotNull SalesDocumentFragment salesDocumentFragment2) {
        Intrinsics.checkParameterIsNotNull(salesDocumentFragment2, "<set-?>");
        this.salesDocumentFragment = salesDocumentFragment2;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        Activity activity = this;
        AndroidInjection.inject(activity);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_sales_document);
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
                            ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(SaleDocumentViewModel.class);
                            Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…entViewModel::class.java)");
                            this.viewModel = (SaleDocumentViewModel) viewModel2;
                            initializeUI();
                            this.salesDocumentFragment = new SalesDocumentFragment();
                            subscribeToViewModel();
                            NavController findNavController = Navigation.findNavController(activity, C2723R.C2726id.sales_document_nav_host_fragment);
                            Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…cument_nav_host_fragment)");
                            NavInflater navInflater = findNavController.getNavInflater();
                            Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
                            NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.sale_doc_list_navigation_graph);
                            Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.na…oc_list_navigation_graph)");
                            findNavController.setGraph(inflate);
                            ((ImageView) _$_findCachedViewById(C2723R.C2726id.im_pre_bid_close)).setOnClickListener(new SalesDocumentActivity$onCreate$1(this));
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

    private final void subscribeToViewModel() {
        SaleDocumentViewModel saleDocumentViewModel = this.viewModel;
        if (saleDocumentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        saleDocumentViewModel.getSwipedProductListResult().removeObservers(lifecycleOwner);
        SaleDocumentViewModel saleDocumentViewModel2 = this.viewModel;
        if (saleDocumentViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        saleDocumentViewModel2.getSwipedProductListResult().observe(lifecycleOwner, new SalesDocumentActivity$subscribeToViewModel$1(this));
    }

    public final void loadSwipedProductList(int i, int i2) {
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
        SaleDocumentViewModel saleDocumentViewModel = this.viewModel;
        if (saleDocumentViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String deviceId = AppUtils.getDeviceId(this);
        if (deviceId == null) {
            deviceId = "";
        }
        String str = deviceId;
        SalesDocumentFragment salesDocumentFragment2 = this.salesDocumentFragment;
        if (salesDocumentFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentFragment");
        }
        String paypal_api_key = salesDocumentFragment2.getPAYPAL_API_KEY();
        SalesDocumentFragment salesDocumentFragment3 = this.salesDocumentFragment;
        if (salesDocumentFragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentFragment");
        }
        saleDocumentViewModel.loadSwipedProductList(format, str, "android", paypal_api_key, salesDocumentFragment3.getCONTENT_TYPE(), String.valueOf(BuildConfig.VERSION_CODE), makeRequestBody(i));
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
        textView.setText(getString(C2723R.string.title_bdt_sale_document));
        TextView textView2 = this.toolbar_sub_title;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbar_sub_title");
        }
        textView2.setVisibility(0);
        ImageView imageView = this.ivToolTip;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivToolTip");
        }
        imageView.setVisibility(8);
        ImageView imageView2 = (ImageView) _$_findCachedViewById(C2723R.C2726id.ivShareAS);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "ivShareAS");
        imageView2.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        FragmentManager childFragmentManager;
        List<Fragment> fragments;
        Fragment fragment;
        super.onActivityResult(i, i2, intent);
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(C2723R.C2726id.sales_document_nav_host_fragment);
        if (findFragmentById != null && (childFragmentManager = findFragmentById.getChildFragmentManager()) != null && (fragments = childFragmentManager.getFragments()) != null && (fragment = fragments.get(0)) != null) {
            fragment.onActivityResult(i, i2, intent);
        }
    }

    public final void setOnNextPageLoad(@NotNull OnNextPageLoad onNextPageLoad2) {
        Intrinsics.checkParameterIsNotNull(onNextPageLoad2, "onNextPageLoad");
        this.onNextPageLoad = onNextPageLoad2;
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
        super.onBackPressed();
    }

    private final SaleDocumentRequestBody makeRequestBody(int i) {
        List arrayList = new ArrayList();
        SalesDocumentFragment salesDocumentFragment2 = this.salesDocumentFragment;
        if (salesDocumentFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentFragment");
        }
        String titleStatus = salesDocumentFragment2.getTitleStatus();
        SalesDocumentFragment salesDocumentFragment3 = this.salesDocumentFragment;
        if (salesDocumentFragment3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentFragment");
        }
        String sortBy = salesDocumentFragment3.getSortBy();
        if (sortBy == null) {
            sortBy = "";
        }
        String str = sortBy;
        SalesDocumentFragment salesDocumentFragment4 = this.salesDocumentFragment;
        if (salesDocumentFragment4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("salesDocumentFragment");
        }
        return new SaleDocumentRequestBody(arrayList, titleStatus, 1, i, str, salesDocumentFragment4.getSortDirection(), 0);
    }
}
