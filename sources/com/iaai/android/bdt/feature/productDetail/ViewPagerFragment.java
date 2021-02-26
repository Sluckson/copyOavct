package com.iaai.android.bdt.feature.productDetail;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity;
import com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity;
import com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity;
import com.iaai.android.bdt.feature.auctionSalesList.OnNextPageLoad;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity;
import com.iaai.android.bdt.feature.viewPager.FastSearchViewModel;
import com.iaai.android.bdt.model.fastSearch.SearchInputV2;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.databinding.ViewPagerProductDetailBinding;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u001e\u001a\u00020\u001f2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u000b0!j\b\u0012\u0004\u0012\u00020\u000b`\"H\u0016J\b\u0010#\u001a\u00020\u001fH\u0002J\u000e\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020&J\u0012\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0017J\u0010\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020,H\u0016J\u0012\u0010-\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J&\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u00104\u001a\u00020\u001f2\u0006\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020\u001fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000¨\u00068"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/ViewPagerFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "Lcom/iaai/android/bdt/feature/auctionSalesList/OnNextPageLoad;", "()V", "adapter", "Lcom/iaai/android/bdt/feature/productDetail/ViewPagerAdapter;", "balance", "", "baseActivity", "Lcom/iaai/android/bdt/base/BaseActivity;", "branchId", "", "fastSearchParam", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "tenentCode", "viewModel", "Lcom/iaai/android/bdt/feature/viewPager/FastSearchViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "OnNextSlotOfItemID", "", "itemID", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "clearCostCalculatorSharedPreference", "loadFastSearchList", "searchInput", "Lcom/iaai/android/bdt/model/fastSearch/SearchInputV2;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "showLoadingIndicator", "loading", "", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ViewPagerFragment.kt */
public final class ViewPagerFragment extends BaseFragment implements OnNextPageLoad {
    private HashMap _$_findViewCache;
    private ViewPagerAdapter adapter;
    /* access modifiers changed from: private */
    public int balance;
    /* access modifiers changed from: private */
    public BaseActivity baseActivity;
    private String branchId = "";
    /* access modifiers changed from: private */
    public String fastSearchParam = "";
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private String tenentCode = "";
    private FastSearchViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;
    /* access modifiers changed from: private */
    public ViewPager viewPager;

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
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final /* synthetic */ BaseActivity access$getBaseActivity$p(ViewPagerFragment viewPagerFragment) {
        BaseActivity baseActivity2 = viewPagerFragment.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        return baseActivity2;
    }

    public static final /* synthetic */ ViewPager access$getViewPager$p(ViewPagerFragment viewPagerFragment) {
        ViewPager viewPager2 = viewPagerFragment.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return viewPager2;
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

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        super.onAttach(context);
        AndroidSupportInjection.inject(this);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.baseActivity = (BaseActivity) activity;
            if (context instanceof BaseActivity) {
                this.baseActivity = (BaseActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.base.BaseActivity");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        FragmentActivity fragmentActivity = baseActivity2;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(FastSearchViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(ba…rchViewModel::class.java)");
        this.viewModel = (FastSearchViewModel) viewModel2;
        if (IAASharedPreference.getIsLoggedInPreferencesMVVM(getContext()).booleanValue()) {
            SessionManager sessionManager2 = this.sessionManager;
            if (sessionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            if (!Intrinsics.areEqual((Object) sessionManager2.getCurrentSessionBuyerId(), (Object) "0")) {
                return;
            }
        }
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        Toast.makeText(baseActivity3, getString(C2723R.string.bdt_lbl_to_check_user), 1).show();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewPagerProductDetailBinding viewPagerProductDetailBinding = (ViewPagerProductDetailBinding) DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.view_pager_product_detail, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(viewPagerProductDetailBinding, "mBinding");
        return viewPagerProductDetailBinding.getRoot();
    }

    /* JADX WARNING: type inference failed for: r9v271, types: [boolean] */
    /* JADX WARNING: type inference failed for: r9v293 */
    /* JADX WARNING: type inference failed for: r9v294 */
    @RequiresApi(23)
    public void onActivityCreated(@Nullable Bundle bundle) {
        boolean z;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        int i3;
        boolean z4;
        int i4;
        boolean z5;
        int i5;
        boolean z6;
        int i6;
        boolean z7;
        int i7;
        boolean z8;
        int i8;
        ? r9;
        int i9;
        int i10;
        super.onActivityCreated(bundle);
        ArrayList<String> arrayList = new ArrayList<>();
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        ArrayList<String> stringArrayList = arguments.getStringArrayList(Constants_MVVM.EXTRA_ITEM_IDS_LIST);
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            Intrinsics.throwNpe();
        }
        int i11 = arguments2.getInt(Constants_MVVM.EXTRA_ITEM_POSITION);
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            Intrinsics.throwNpe();
        }
        int i12 = arguments3.getInt(Constants_MVVM.EXTRA_TOTAL_COUNT);
        int size = stringArrayList.size();
        Bundle arguments4 = getArguments();
        if (arguments4 == null) {
            Intrinsics.throwNpe();
        }
        String string = arguments4.getString(Constants_MVVM.EXTRA_FAST_SEARCH_PARAM);
        Intrinsics.checkExpressionValueIsNotNull(string, "arguments!!.getString(Co….EXTRA_FAST_SEARCH_PARAM)");
        this.fastSearchParam = string;
        Bundle arguments5 = getArguments();
        if (arguments5 == null) {
            Intrinsics.throwNpe();
        }
        if (arguments5.getStringArrayList("countryCode") != null) {
            Bundle arguments6 = getArguments();
            if (arguments6 == null) {
                Intrinsics.throwNpe();
            }
            arrayList = arguments6.getStringArrayList("countryCode");
            Intrinsics.checkExpressionValueIsNotNull(arrayList, "arguments!!.getStringArr…_MVVM.EXTRA_COUNTRY_CODE)");
        }
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity2 instanceof AuctionSalesListActivity) {
            BaseActivity baseActivity3 = this.baseActivity;
            if (baseActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            if (baseActivity3 != null) {
                AuctionSalesListActivity auctionSalesListActivity = (AuctionSalesListActivity) baseActivity3;
                auctionSalesListActivity.setOnNextPageLoad(this);
                RelativeLayout relativeLayout = (RelativeLayout) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "auctionSalesListActivity.toolbar_relativelayout");
                relativeLayout.setVisibility(0);
                ActionBar supportActionBar = auctionSalesListActivity.getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.setDisplayHomeAsUpEnabled(true);
                    Unit unit = Unit.INSTANCE;
                }
                ActionBar supportActionBar2 = auctionSalesListActivity.getSupportActionBar();
                if (supportActionBar2 != null) {
                    supportActionBar2.setHomeButtonEnabled(true);
                    Unit unit2 = Unit.INSTANCE;
                }
                ConstraintLayout constraintLayout = (ConstraintLayout) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "auctionSalesListActivity.prebid_title_layout");
                constraintLayout.setVisibility(8);
                auctionSalesListActivity.getIvStockShare().setVisibility(0);
                if (i12 > 1) {
                    TextView toolbar_title = auctionSalesListActivity.getToolbar_title();
                    toolbar_title.setText(String.valueOf(i11 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(i12));
                    auctionSalesListActivity.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darker));
                    auctionSalesListActivity.getToolbar_sub_title().setVisibility(8);
                    if (i11 == 0) {
                        ImageView imageView = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView, "auctionSalesListActivity.arrow_left");
                        imageView.setVisibility(0);
                        ImageView imageView2 = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView2, "auctionSalesListActivity.arrow_left");
                        imageView2.setEnabled(false);
                        ((ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                        i10 = 1;
                    } else {
                        ImageView imageView3 = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView3, "auctionSalesListActivity.arrow_left");
                        imageView3.setVisibility(0);
                        ImageView imageView4 = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                        Intrinsics.checkExpressionValueIsNotNull(imageView4, "auctionSalesListActivity.arrow_left");
                        i10 = 1;
                        imageView4.setEnabled(true);
                        ((ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                    }
                    if (i11 == stringArrayList.size() - i10) {
                        ImageView imageView5 = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView5, "auctionSalesListActivity.arrow_right");
                        imageView5.setVisibility(0);
                        ImageView imageView6 = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView6, "auctionSalesListActivity.arrow_right");
                        imageView6.setEnabled(false);
                        ((ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                    } else {
                        ImageView imageView7 = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView7, "auctionSalesListActivity.arrow_right");
                        imageView7.setVisibility(0);
                        ImageView imageView8 = (ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                        Intrinsics.checkExpressionValueIsNotNull(imageView8, "auctionSalesListActivity.arrow_right");
                        imageView8.setEnabled(true);
                        ((ImageView) auctionSalesListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                    }
                } else {
                    auctionSalesListActivity.getToolbar_sub_title().setVisibility(8);
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity");
            }
        } else {
            BaseActivity baseActivity4 = this.baseActivity;
            if (baseActivity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            if (baseActivity4 instanceof ProductDetailActivity) {
                BaseActivity baseActivity5 = this.baseActivity;
                if (baseActivity5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                }
                if (baseActivity5 != null) {
                    ProductDetailActivity productDetailActivity = (ProductDetailActivity) baseActivity5;
                    Toolbar toolbar = productDetailActivity.getToolbar();
                    if (toolbar != null) {
                        toolbar.setVisibility(0);
                    }
                    RelativeLayout relativeLayout2 = (RelativeLayout) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_fs);
                    Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "productDetailActivity.toolbar_relativelayout_fs");
                    relativeLayout2.setVisibility(0);
                    ActionBar supportActionBar3 = productDetailActivity.getSupportActionBar();
                    if (supportActionBar3 != null) {
                        r9 = 1;
                        supportActionBar3.setDisplayHomeAsUpEnabled(true);
                        Unit unit3 = Unit.INSTANCE;
                    } else {
                        r9 = 1;
                    }
                    ActionBar supportActionBar4 = productDetailActivity.getSupportActionBar();
                    if (supportActionBar4 != null) {
                        supportActionBar4.setHomeButtonEnabled(r9);
                        Unit unit4 = Unit.INSTANCE;
                    }
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) productDetailActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout_fs);
                    Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "productDetailActivity.prebid_title_layout_fs");
                    constraintLayout2.setVisibility(8);
                    if (i12 > r9) {
                        RelativeLayout relativeLayout3 = (RelativeLayout) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_fs);
                        Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, "productDetailActivity.toolbar_relativelayout_fs");
                        relativeLayout3.setGravity(GravityCompat.END);
                        RelativeLayout relativeLayout4 = (RelativeLayout) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_fs);
                        Intrinsics.checkExpressionValueIsNotNull(relativeLayout4, "productDetailActivity.toolbar_relativelayout_fs");
                        relativeLayout4.setGravity(5);
                        TextView textView = (TextView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_title_fs);
                        Intrinsics.checkExpressionValueIsNotNull(textView, "productDetailActivity.toolbar_title_fs");
                        textView.setText(String.valueOf(i11 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(i12));
                        TextView textView2 = (TextView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_sub_title_fs);
                        Intrinsics.checkExpressionValueIsNotNull(textView2, "productDetailActivity.toolbar_sub_title_fs");
                        textView2.setVisibility(8);
                        if (i11 == 0) {
                            ImageView imageView9 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_fs);
                            Intrinsics.checkExpressionValueIsNotNull(imageView9, "productDetailActivity.arrow_left_fs");
                            imageView9.setVisibility(0);
                            ImageView imageView10 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_fs);
                            Intrinsics.checkExpressionValueIsNotNull(imageView10, "productDetailActivity.arrow_left_fs");
                            imageView10.setEnabled(false);
                            ((ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_fs)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                            i9 = 1;
                        } else {
                            ImageView imageView11 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_fs);
                            Intrinsics.checkExpressionValueIsNotNull(imageView11, "productDetailActivity.arrow_left_fs");
                            imageView11.setVisibility(0);
                            ImageView imageView12 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_fs);
                            Intrinsics.checkExpressionValueIsNotNull(imageView12, "productDetailActivity.arrow_left_fs");
                            i9 = 1;
                            imageView12.setEnabled(true);
                            ((ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_fs)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                        }
                        if (i11 == stringArrayList.size() - i9) {
                            ImageView imageView13 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_fs);
                            Intrinsics.checkExpressionValueIsNotNull(imageView13, "productDetailActivity.arrow_right_fs");
                            imageView13.setVisibility(0);
                            ImageView imageView14 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_fs);
                            Intrinsics.checkExpressionValueIsNotNull(imageView14, "productDetailActivity.arrow_right_fs");
                            imageView14.setEnabled(false);
                            ((ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_fs)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                        } else {
                            ImageView imageView15 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_fs);
                            Intrinsics.checkExpressionValueIsNotNull(imageView15, "productDetailActivity.arrow_right_fs");
                            imageView15.setVisibility(0);
                            ImageView imageView16 = (ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_fs);
                            Intrinsics.checkExpressionValueIsNotNull(imageView16, "productDetailActivity.arrow_right_fs");
                            imageView16.setEnabled(true);
                            ((ImageView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_fs)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                        }
                    } else {
                        TextView textView3 = (TextView) productDetailActivity._$_findCachedViewById(C2723R.C2726id.toolbar_sub_title_fs);
                        Intrinsics.checkExpressionValueIsNotNull(textView3, "productDetailActivity.toolbar_sub_title_fs");
                        textView3.setVisibility(8);
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.productDetail.ProductDetailActivity");
                }
            } else {
                BaseActivity baseActivity6 = this.baseActivity;
                if (baseActivity6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                }
                if (baseActivity6 instanceof SearchResultActivity) {
                    BaseActivity baseActivity7 = this.baseActivity;
                    if (baseActivity7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                    }
                    if (baseActivity7 != null) {
                        SearchResultActivity searchResultActivity = (SearchResultActivity) baseActivity7;
                        searchResultActivity.setOnNextPageLoad(this);
                        RelativeLayout relativeLayout5 = (RelativeLayout) searchResultActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                        Intrinsics.checkExpressionValueIsNotNull(relativeLayout5, "searchResultActivity.toolbar_relativelayout");
                        relativeLayout5.setVisibility(0);
                        ActionBar supportActionBar5 = searchResultActivity.getSupportActionBar();
                        if (supportActionBar5 != null) {
                            z8 = true;
                            supportActionBar5.setDisplayHomeAsUpEnabled(true);
                            Unit unit5 = Unit.INSTANCE;
                        } else {
                            z8 = true;
                        }
                        ActionBar supportActionBar6 = searchResultActivity.getSupportActionBar();
                        if (supportActionBar6 != null) {
                            supportActionBar6.setHomeButtonEnabled(z8);
                            Unit unit6 = Unit.INSTANCE;
                        }
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) searchResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                        Intrinsics.checkExpressionValueIsNotNull(constraintLayout3, "searchResultActivity.prebid_title_layout");
                        constraintLayout3.setVisibility(8);
                        searchResultActivity.getIvStockShare().setVisibility(0);
                        if (i12 > 1) {
                            TextView toolbar_title2 = searchResultActivity.getToolbar_title();
                            toolbar_title2.setText(String.valueOf(i11 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(i12));
                            searchResultActivity.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darker));
                            searchResultActivity.getToolbar_sub_title().setVisibility(8);
                            if (i11 == 0) {
                                ImageView imageView17 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                Intrinsics.checkExpressionValueIsNotNull(imageView17, "searchResultActivity.arrow_left");
                                imageView17.setVisibility(0);
                                ImageView imageView18 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                Intrinsics.checkExpressionValueIsNotNull(imageView18, "searchResultActivity.arrow_left");
                                imageView18.setEnabled(false);
                                ((ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                                i8 = 1;
                            } else {
                                ImageView imageView19 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                Intrinsics.checkExpressionValueIsNotNull(imageView19, "searchResultActivity.arrow_left");
                                imageView19.setVisibility(0);
                                ImageView imageView20 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                Intrinsics.checkExpressionValueIsNotNull(imageView20, "searchResultActivity.arrow_left");
                                i8 = 1;
                                imageView20.setEnabled(true);
                                ((ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                            }
                            if (i11 == stringArrayList.size() - i8) {
                                ImageView imageView21 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                Intrinsics.checkExpressionValueIsNotNull(imageView21, "searchResultActivity.arrow_right");
                                imageView21.setVisibility(0);
                                ImageView imageView22 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                Intrinsics.checkExpressionValueIsNotNull(imageView22, "searchResultActivity.arrow_right");
                                imageView22.setEnabled(false);
                                ((ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                            } else {
                                ImageView imageView23 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                Intrinsics.checkExpressionValueIsNotNull(imageView23, "searchResultActivity.arrow_right");
                                imageView23.setVisibility(0);
                                ImageView imageView24 = (ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                Intrinsics.checkExpressionValueIsNotNull(imageView24, "searchResultActivity.arrow_right");
                                imageView24.setEnabled(true);
                                ((ImageView) searchResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                            }
                        } else {
                            searchResultActivity.getToolbar_sub_title().setVisibility(8);
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity");
                    }
                } else {
                    BaseActivity baseActivity8 = this.baseActivity;
                    if (baseActivity8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                    }
                    if (baseActivity8 instanceof RefinerResultActivity) {
                        BaseActivity baseActivity9 = this.baseActivity;
                        if (baseActivity9 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                        }
                        if (baseActivity9 != null) {
                            RefinerResultActivity refinerResultActivity = (RefinerResultActivity) baseActivity9;
                            refinerResultActivity.setOnNextPageLoad(this);
                            RelativeLayout relativeLayout6 = (RelativeLayout) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                            Intrinsics.checkExpressionValueIsNotNull(relativeLayout6, "refinerResultActivity.toolbar_relativelayout");
                            relativeLayout6.setVisibility(0);
                            ActionBar supportActionBar7 = refinerResultActivity.getSupportActionBar();
                            if (supportActionBar7 != null) {
                                z7 = true;
                                supportActionBar7.setDisplayHomeAsUpEnabled(true);
                                Unit unit7 = Unit.INSTANCE;
                            } else {
                                z7 = true;
                            }
                            ActionBar supportActionBar8 = refinerResultActivity.getSupportActionBar();
                            if (supportActionBar8 != null) {
                                supportActionBar8.setHomeButtonEnabled(z7);
                                Unit unit8 = Unit.INSTANCE;
                            }
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                            Intrinsics.checkExpressionValueIsNotNull(constraintLayout4, "refinerResultActivity.prebid_title_layout");
                            constraintLayout4.setVisibility(8);
                            TextView textView4 = (TextView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.tvSavedSearch);
                            Intrinsics.checkExpressionValueIsNotNull(textView4, "refinerResultActivity.tvSavedSearch");
                            textView4.setVisibility(8);
                            refinerResultActivity.getIvStockShare().setVisibility(0);
                            if (i12 > 1) {
                                TextView toolbarTitle = refinerResultActivity.getToolbarTitle();
                                toolbarTitle.setText(String.valueOf(i11 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(i12));
                                refinerResultActivity.getToolbarTitle().setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darker));
                                refinerResultActivity.getToolbarSubTitle().setVisibility(8);
                                if (i11 == 0) {
                                    ImageView imageView25 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                    Intrinsics.checkExpressionValueIsNotNull(imageView25, "refinerResultActivity.arrow_left");
                                    imageView25.setVisibility(0);
                                    ImageView imageView26 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                    Intrinsics.checkExpressionValueIsNotNull(imageView26, "refinerResultActivity.arrow_left");
                                    imageView26.setEnabled(false);
                                    ((ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                                    i7 = 1;
                                } else {
                                    ImageView imageView27 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                    Intrinsics.checkExpressionValueIsNotNull(imageView27, "refinerResultActivity.arrow_left");
                                    imageView27.setVisibility(0);
                                    ImageView imageView28 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                    Intrinsics.checkExpressionValueIsNotNull(imageView28, "refinerResultActivity.arrow_left");
                                    i7 = 1;
                                    imageView28.setEnabled(true);
                                    ((ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                                }
                                if (i11 == stringArrayList.size() - i7) {
                                    ImageView imageView29 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                    Intrinsics.checkExpressionValueIsNotNull(imageView29, "refinerResultActivity.arrow_right");
                                    imageView29.setVisibility(0);
                                    ImageView imageView30 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                    Intrinsics.checkExpressionValueIsNotNull(imageView30, "refinerResultActivity.arrow_right");
                                    imageView30.setEnabled(false);
                                    ((ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                                } else {
                                    ImageView imageView31 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                    Intrinsics.checkExpressionValueIsNotNull(imageView31, "refinerResultActivity.arrow_right");
                                    imageView31.setVisibility(0);
                                    ImageView imageView32 = (ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                    Intrinsics.checkExpressionValueIsNotNull(imageView32, "refinerResultActivity.arrow_right");
                                    imageView32.setEnabled(true);
                                    ((ImageView) refinerResultActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                                }
                            } else {
                                refinerResultActivity.getToolbarTitle().setVisibility(8);
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity");
                        }
                    } else {
                        BaseActivity baseActivity10 = this.baseActivity;
                        if (baseActivity10 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                        }
                        if (baseActivity10 instanceof ManageOfferListActivity) {
                            BaseActivity baseActivity11 = this.baseActivity;
                            if (baseActivity11 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                            }
                            if (baseActivity11 != null) {
                                ManageOfferListActivity manageOfferListActivity = (ManageOfferListActivity) baseActivity11;
                                manageOfferListActivity.setOnNextPageLoad(this);
                                RelativeLayout relativeLayout7 = (RelativeLayout) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                                Intrinsics.checkExpressionValueIsNotNull(relativeLayout7, "manageOfferListActivity.toolbar_relativelayout");
                                relativeLayout7.setVisibility(0);
                                ActionBar supportActionBar9 = manageOfferListActivity.getSupportActionBar();
                                if (supportActionBar9 != null) {
                                    z6 = true;
                                    supportActionBar9.setDisplayHomeAsUpEnabled(true);
                                    Unit unit9 = Unit.INSTANCE;
                                } else {
                                    z6 = true;
                                }
                                ActionBar supportActionBar10 = manageOfferListActivity.getSupportActionBar();
                                if (supportActionBar10 != null) {
                                    supportActionBar10.setHomeButtonEnabled(z6);
                                    Unit unit10 = Unit.INSTANCE;
                                }
                                ConstraintLayout constraintLayout5 = (ConstraintLayout) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                                Intrinsics.checkExpressionValueIsNotNull(constraintLayout5, "manageOfferListActivity.prebid_title_layout");
                                constraintLayout5.setVisibility(8);
                                manageOfferListActivity.getIvStockShare().setVisibility(0);
                                if (i12 > 1) {
                                    TextView toolbar_title3 = manageOfferListActivity.getToolbar_title();
                                    toolbar_title3.setText(String.valueOf(i11 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(i12));
                                    manageOfferListActivity.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darker));
                                    manageOfferListActivity.getToolbar_sub_title().setVisibility(8);
                                    if (i11 == 0) {
                                        ImageView imageView33 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                        Intrinsics.checkExpressionValueIsNotNull(imageView33, "manageOfferListActivity.arrow_left");
                                        imageView33.setVisibility(0);
                                        ImageView imageView34 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                        Intrinsics.checkExpressionValueIsNotNull(imageView34, "manageOfferListActivity.arrow_left");
                                        imageView34.setEnabled(false);
                                        ((ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                                        i6 = 1;
                                    } else {
                                        ImageView imageView35 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                        Intrinsics.checkExpressionValueIsNotNull(imageView35, "manageOfferListActivity.arrow_left");
                                        imageView35.setVisibility(0);
                                        ImageView imageView36 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                        Intrinsics.checkExpressionValueIsNotNull(imageView36, "manageOfferListActivity.arrow_left");
                                        i6 = 1;
                                        imageView36.setEnabled(true);
                                        ((ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                                    }
                                    if (i11 == stringArrayList.size() - i6) {
                                        ImageView imageView37 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                        Intrinsics.checkExpressionValueIsNotNull(imageView37, "manageOfferListActivity.arrow_right");
                                        imageView37.setVisibility(0);
                                        ImageView imageView38 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                        Intrinsics.checkExpressionValueIsNotNull(imageView38, "manageOfferListActivity.arrow_right");
                                        imageView38.setEnabled(false);
                                        ((ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                                    } else {
                                        ImageView imageView39 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                        Intrinsics.checkExpressionValueIsNotNull(imageView39, "manageOfferListActivity.arrow_right");
                                        imageView39.setVisibility(0);
                                        ImageView imageView40 = (ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                        Intrinsics.checkExpressionValueIsNotNull(imageView40, "manageOfferListActivity.arrow_right");
                                        imageView40.setEnabled(true);
                                        ((ImageView) manageOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                                    }
                                } else {
                                    manageOfferListActivity.getToolbar_sub_title().setVisibility(8);
                                }
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity");
                            }
                        } else {
                            BaseActivity baseActivity12 = this.baseActivity;
                            if (baseActivity12 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                            }
                            if (baseActivity12 instanceof PreSaleListActivity) {
                                BaseActivity baseActivity13 = this.baseActivity;
                                if (baseActivity13 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                                }
                                if (baseActivity13 != null) {
                                    PreSaleListActivity preSaleListActivity = (PreSaleListActivity) baseActivity13;
                                    preSaleListActivity.setOnNextPageLoad(this);
                                    RelativeLayout relativeLayout8 = (RelativeLayout) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                                    Intrinsics.checkExpressionValueIsNotNull(relativeLayout8, "preSaleListActivity.toolbar_relativelayout");
                                    relativeLayout8.setVisibility(0);
                                    ActionBar supportActionBar11 = preSaleListActivity.getSupportActionBar();
                                    if (supportActionBar11 != null) {
                                        z5 = true;
                                        supportActionBar11.setDisplayHomeAsUpEnabled(true);
                                        Unit unit11 = Unit.INSTANCE;
                                    } else {
                                        z5 = true;
                                    }
                                    ActionBar supportActionBar12 = preSaleListActivity.getSupportActionBar();
                                    if (supportActionBar12 != null) {
                                        supportActionBar12.setHomeButtonEnabled(z5);
                                        Unit unit12 = Unit.INSTANCE;
                                    }
                                    ConstraintLayout constraintLayout6 = (ConstraintLayout) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                                    Intrinsics.checkExpressionValueIsNotNull(constraintLayout6, "preSaleListActivity.prebid_title_layout");
                                    constraintLayout6.setVisibility(8);
                                    preSaleListActivity.getIvStockShare().setVisibility(0);
                                    preSaleListActivity.getIvToolTip().setVisibility(8);
                                    if (i12 > 1) {
                                        TextView toolbar_title4 = preSaleListActivity.getToolbar_title();
                                        toolbar_title4.setText(String.valueOf(i11 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(i12));
                                        preSaleListActivity.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darker));
                                        preSaleListActivity.getToolbar_sub_title().setVisibility(8);
                                        if (i11 == 0) {
                                            ImageView imageView41 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_watch);
                                            Intrinsics.checkExpressionValueIsNotNull(imageView41, "preSaleListActivity.arrow_left_watch");
                                            imageView41.setVisibility(0);
                                            ImageView imageView42 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_watch);
                                            Intrinsics.checkExpressionValueIsNotNull(imageView42, "preSaleListActivity.arrow_left_watch");
                                            imageView42.setEnabled(false);
                                            ((ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_watch)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                                            i5 = 1;
                                        } else {
                                            ImageView imageView43 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_watch);
                                            Intrinsics.checkExpressionValueIsNotNull(imageView43, "preSaleListActivity.arrow_left_watch");
                                            imageView43.setVisibility(0);
                                            ImageView imageView44 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_watch);
                                            Intrinsics.checkExpressionValueIsNotNull(imageView44, "preSaleListActivity.arrow_left_watch");
                                            i5 = 1;
                                            imageView44.setEnabled(true);
                                            ((ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_watch)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                                        }
                                        if (i11 == stringArrayList.size() - i5) {
                                            ImageView imageView45 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_watch);
                                            Intrinsics.checkExpressionValueIsNotNull(imageView45, "preSaleListActivity.arrow_right_watch");
                                            imageView45.setVisibility(0);
                                            ImageView imageView46 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_watch);
                                            Intrinsics.checkExpressionValueIsNotNull(imageView46, "preSaleListActivity.arrow_right_watch");
                                            imageView46.setEnabled(false);
                                            ((ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_watch)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                                        } else {
                                            ImageView imageView47 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_watch);
                                            Intrinsics.checkExpressionValueIsNotNull(imageView47, "preSaleListActivity.arrow_right_watch");
                                            imageView47.setVisibility(0);
                                            ImageView imageView48 = (ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_watch);
                                            Intrinsics.checkExpressionValueIsNotNull(imageView48, "preSaleListActivity.arrow_right_watch");
                                            imageView48.setEnabled(true);
                                            ((ImageView) preSaleListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_watch)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                                        }
                                    } else {
                                        preSaleListActivity.getToolbar_sub_title().setVisibility(8);
                                    }
                                } else {
                                    throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity");
                                }
                            } else {
                                BaseActivity baseActivity14 = this.baseActivity;
                                if (baseActivity14 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                                }
                                if (baseActivity14 instanceof BDTPaymentActivity) {
                                    BaseActivity baseActivity15 = this.baseActivity;
                                    if (baseActivity15 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                                    }
                                    if (baseActivity15 != null) {
                                        BDTPaymentActivity bDTPaymentActivity = (BDTPaymentActivity) baseActivity15;
                                        bDTPaymentActivity.setOnNextPageLoad(this);
                                        RelativeLayout relativeLayout9 = (RelativeLayout) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
                                        Intrinsics.checkExpressionValueIsNotNull(relativeLayout9, "bdtPaymentActivity.toolbar_relativelayout");
                                        relativeLayout9.setVisibility(0);
                                        ActionBar supportActionBar13 = bDTPaymentActivity.getSupportActionBar();
                                        if (supportActionBar13 != null) {
                                            z4 = true;
                                            supportActionBar13.setDisplayHomeAsUpEnabled(true);
                                            Unit unit13 = Unit.INSTANCE;
                                        } else {
                                            z4 = true;
                                        }
                                        ActionBar supportActionBar14 = bDTPaymentActivity.getSupportActionBar();
                                        if (supportActionBar14 != null) {
                                            supportActionBar14.setHomeButtonEnabled(z4);
                                            Unit unit14 = Unit.INSTANCE;
                                        }
                                        ConstraintLayout constraintLayout7 = (ConstraintLayout) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                                        Intrinsics.checkExpressionValueIsNotNull(constraintLayout7, "bdtPaymentActivity.prebid_title_layout");
                                        constraintLayout7.setVisibility(8);
                                        bDTPaymentActivity.getIvStockShare().setVisibility(0);
                                        if (i12 > 1) {
                                            TextView toolbar_title5 = bDTPaymentActivity.getToolbar_title();
                                            toolbar_title5.setText(String.valueOf(i11 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(i12));
                                            bDTPaymentActivity.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darker));
                                            bDTPaymentActivity.getToolbar_sub_title().setVisibility(8);
                                            if (i11 == 0) {
                                                ImageView imageView49 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                                Intrinsics.checkExpressionValueIsNotNull(imageView49, "bdtPaymentActivity.arrow_left");
                                                imageView49.setVisibility(0);
                                                ImageView imageView50 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                                Intrinsics.checkExpressionValueIsNotNull(imageView50, "bdtPaymentActivity.arrow_left");
                                                imageView50.setEnabled(false);
                                                ((ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                                                i4 = 1;
                                            } else {
                                                ImageView imageView51 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                                Intrinsics.checkExpressionValueIsNotNull(imageView51, "bdtPaymentActivity.arrow_left");
                                                imageView51.setVisibility(0);
                                                ImageView imageView52 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                                Intrinsics.checkExpressionValueIsNotNull(imageView52, "bdtPaymentActivity.arrow_left");
                                                i4 = 1;
                                                imageView52.setEnabled(true);
                                                ((ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                                            }
                                            if (i11 == stringArrayList.size() - i4) {
                                                ImageView imageView53 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                                Intrinsics.checkExpressionValueIsNotNull(imageView53, "bdtPaymentActivity.arrow_right");
                                                imageView53.setVisibility(0);
                                                ImageView imageView54 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                                Intrinsics.checkExpressionValueIsNotNull(imageView54, "bdtPaymentActivity.arrow_right");
                                                imageView54.setEnabled(false);
                                                ((ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                                            } else {
                                                ImageView imageView55 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                                Intrinsics.checkExpressionValueIsNotNull(imageView55, "bdtPaymentActivity.arrow_right");
                                                imageView55.setVisibility(0);
                                                ImageView imageView56 = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                                Intrinsics.checkExpressionValueIsNotNull(imageView56, "bdtPaymentActivity.arrow_right");
                                                imageView56.setEnabled(true);
                                                ((ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                                            }
                                        } else {
                                            bDTPaymentActivity.getToolbar_sub_title().setVisibility(8);
                                        }
                                    } else {
                                        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity");
                                    }
                                } else {
                                    BaseActivity baseActivity16 = this.baseActivity;
                                    if (baseActivity16 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                                    }
                                    if (baseActivity16 instanceof ToPickedUpAccountActivity) {
                                        BaseActivity baseActivity17 = this.baseActivity;
                                        if (baseActivity17 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                                        }
                                        if (baseActivity17 != null) {
                                            ToPickedUpAccountActivity toPickedUpAccountActivity = (ToPickedUpAccountActivity) baseActivity17;
                                            toPickedUpAccountActivity.setOnNextPageLoad(this);
                                            RelativeLayout relativeLayout10 = (RelativeLayout) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout_toPickUp);
                                            Intrinsics.checkExpressionValueIsNotNull(relativeLayout10, "toPickedUpAccountActivit…r_relativelayout_toPickUp");
                                            relativeLayout10.setVisibility(0);
                                            ActionBar supportActionBar15 = toPickedUpAccountActivity.getSupportActionBar();
                                            if (supportActionBar15 != null) {
                                                z3 = true;
                                                supportActionBar15.setDisplayHomeAsUpEnabled(true);
                                                Unit unit15 = Unit.INSTANCE;
                                            } else {
                                                z3 = true;
                                            }
                                            ActionBar supportActionBar16 = toPickedUpAccountActivity.getSupportActionBar();
                                            if (supportActionBar16 != null) {
                                                supportActionBar16.setHomeButtonEnabled(z3);
                                                Unit unit16 = Unit.INSTANCE;
                                            }
                                            ConstraintLayout constraintLayout8 = (ConstraintLayout) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                                            Intrinsics.checkExpressionValueIsNotNull(constraintLayout8, "toPickedUpAccountActivity.prebid_title_layout");
                                            constraintLayout8.setVisibility(8);
                                            toPickedUpAccountActivity.getIvStockShare().setVisibility(0);
                                            ImageView imageView57 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.ivToolTipPickUp);
                                            Intrinsics.checkExpressionValueIsNotNull(imageView57, "toPickedUpAccountActivity.ivToolTipPickUp");
                                            imageView57.setVisibility(8);
                                            if (i12 > 1) {
                                                TextView toolbar_title6 = toPickedUpAccountActivity.getToolbar_title();
                                                toolbar_title6.setText(String.valueOf(i11 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(i12));
                                                toPickedUpAccountActivity.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darker));
                                                toPickedUpAccountActivity.getToolbar_sub_title().setVisibility(8);
                                                if (i11 == 0) {
                                                    ImageView imageView58 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_tobePickUp);
                                                    Intrinsics.checkExpressionValueIsNotNull(imageView58, "toPickedUpAccountActivity.arrow_left_tobePickUp");
                                                    imageView58.setVisibility(0);
                                                    ImageView imageView59 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_tobePickUp);
                                                    Intrinsics.checkExpressionValueIsNotNull(imageView59, "toPickedUpAccountActivity.arrow_left_tobePickUp");
                                                    imageView59.setEnabled(false);
                                                    ((ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_tobePickUp)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                                                    i3 = 1;
                                                } else {
                                                    ImageView imageView60 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_tobePickUp);
                                                    Intrinsics.checkExpressionValueIsNotNull(imageView60, "toPickedUpAccountActivity.arrow_left_tobePickUp");
                                                    imageView60.setVisibility(0);
                                                    ImageView imageView61 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_tobePickUp);
                                                    Intrinsics.checkExpressionValueIsNotNull(imageView61, "toPickedUpAccountActivity.arrow_left_tobePickUp");
                                                    i3 = 1;
                                                    imageView61.setEnabled(true);
                                                    ((ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_tobePickUp)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                                                }
                                                if (i11 == stringArrayList.size() - i3) {
                                                    ImageView imageView62 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_tobePickUp);
                                                    Intrinsics.checkExpressionValueIsNotNull(imageView62, "toPickedUpAccountActivity.arrow_right_tobePickUp");
                                                    imageView62.setVisibility(0);
                                                    ImageView imageView63 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_tobePickUp);
                                                    Intrinsics.checkExpressionValueIsNotNull(imageView63, "toPickedUpAccountActivity.arrow_right_tobePickUp");
                                                    imageView63.setEnabled(false);
                                                    ((ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_tobePickUp)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                                                } else {
                                                    ImageView imageView64 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_tobePickUp);
                                                    Intrinsics.checkExpressionValueIsNotNull(imageView64, "toPickedUpAccountActivity.arrow_right_tobePickUp");
                                                    imageView64.setVisibility(0);
                                                    ImageView imageView65 = (ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_tobePickUp);
                                                    Intrinsics.checkExpressionValueIsNotNull(imageView65, "toPickedUpAccountActivity.arrow_right_tobePickUp");
                                                    imageView65.setEnabled(true);
                                                    ((ImageView) toPickedUpAccountActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_tobePickUp)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                                                }
                                            } else {
                                                toPickedUpAccountActivity.getToolbar_sub_title().setVisibility(8);
                                            }
                                        } else {
                                            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity");
                                        }
                                    } else {
                                        BaseActivity baseActivity18 = this.baseActivity;
                                        if (baseActivity18 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                                        }
                                        if (baseActivity18 instanceof BuyNowOfferListActivity) {
                                            BaseActivity baseActivity19 = this.baseActivity;
                                            if (baseActivity19 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                                            }
                                            if (baseActivity19 != null) {
                                                BuyNowOfferListActivity buyNowOfferListActivity = (BuyNowOfferListActivity) baseActivity19;
                                                buyNowOfferListActivity.setOnNextPageLoad(this);
                                                RelativeLayout relativeLayout11 = (RelativeLayout) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.buynow_toolbar_relativelayout);
                                                Intrinsics.checkExpressionValueIsNotNull(relativeLayout11, "buyNowOfferListActivity.…ow_toolbar_relativelayout");
                                                relativeLayout11.setVisibility(0);
                                                ActionBar supportActionBar17 = buyNowOfferListActivity.getSupportActionBar();
                                                if (supportActionBar17 != null) {
                                                    z2 = true;
                                                    supportActionBar17.setDisplayHomeAsUpEnabled(true);
                                                    Unit unit17 = Unit.INSTANCE;
                                                } else {
                                                    z2 = true;
                                                }
                                                ActionBar supportActionBar18 = buyNowOfferListActivity.getSupportActionBar();
                                                if (supportActionBar18 != null) {
                                                    supportActionBar18.setHomeButtonEnabled(z2);
                                                    Unit unit18 = Unit.INSTANCE;
                                                }
                                                ConstraintLayout constraintLayout9 = (ConstraintLayout) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                                                Intrinsics.checkExpressionValueIsNotNull(constraintLayout9, "buyNowOfferListActivity.prebid_title_layout");
                                                constraintLayout9.setVisibility(8);
                                                buyNowOfferListActivity.getIvStockShare().setVisibility(0);
                                                buyNowOfferListActivity.getIvToolTip().setVisibility(8);
                                                if (i12 > 1) {
                                                    TextView toolbar_title7 = buyNowOfferListActivity.getToolbar_title();
                                                    toolbar_title7.setText(String.valueOf(i11 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(i12));
                                                    buyNowOfferListActivity.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darker));
                                                    buyNowOfferListActivity.getToolbar_sub_title().setVisibility(8);
                                                    if (i11 == 0) {
                                                        ImageView imageView66 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_buy_now);
                                                        Intrinsics.checkExpressionValueIsNotNull(imageView66, "buyNowOfferListActivity.arrow_left_buy_now");
                                                        imageView66.setVisibility(0);
                                                        ImageView imageView67 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_buy_now);
                                                        Intrinsics.checkExpressionValueIsNotNull(imageView67, "buyNowOfferListActivity.arrow_left_buy_now");
                                                        imageView67.setEnabled(false);
                                                        ((ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_buy_now)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                                                        i2 = 1;
                                                    } else {
                                                        ImageView imageView68 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_buy_now);
                                                        Intrinsics.checkExpressionValueIsNotNull(imageView68, "buyNowOfferListActivity.arrow_left_buy_now");
                                                        imageView68.setVisibility(0);
                                                        ImageView imageView69 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_buy_now);
                                                        Intrinsics.checkExpressionValueIsNotNull(imageView69, "buyNowOfferListActivity.arrow_left_buy_now");
                                                        i2 = 1;
                                                        imageView69.setEnabled(true);
                                                        ((ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_left_buy_now)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                                                    }
                                                    if (i11 == stringArrayList.size() - i2) {
                                                        ImageView imageView70 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_buy_now);
                                                        Intrinsics.checkExpressionValueIsNotNull(imageView70, "buyNowOfferListActivity.arrow_right_buy_now");
                                                        imageView70.setVisibility(0);
                                                        ImageView imageView71 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_buy_now);
                                                        Intrinsics.checkExpressionValueIsNotNull(imageView71, "buyNowOfferListActivity.arrow_right_buy_now");
                                                        imageView71.setEnabled(false);
                                                        ((ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_buy_now)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                                                    } else {
                                                        ImageView imageView72 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_buy_now);
                                                        Intrinsics.checkExpressionValueIsNotNull(imageView72, "buyNowOfferListActivity.arrow_right_buy_now");
                                                        imageView72.setVisibility(0);
                                                        ImageView imageView73 = (ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_buy_now);
                                                        Intrinsics.checkExpressionValueIsNotNull(imageView73, "buyNowOfferListActivity.arrow_right_buy_now");
                                                        imageView73.setEnabled(true);
                                                        ((ImageView) buyNowOfferListActivity._$_findCachedViewById(C2723R.C2726id.arrow_right_buy_now)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                                                    }
                                                } else {
                                                    buyNowOfferListActivity.getToolbar_sub_title().setVisibility(8);
                                                }
                                            } else {
                                                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity");
                                            }
                                        } else {
                                            BaseActivity baseActivity20 = this.baseActivity;
                                            if (baseActivity20 == null) {
                                                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                                            }
                                            if (baseActivity20 instanceof SalesDocumentActivity) {
                                                BaseActivity baseActivity21 = this.baseActivity;
                                                if (baseActivity21 == null) {
                                                    Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
                                                }
                                                if (baseActivity21 != null) {
                                                    SalesDocumentActivity salesDocumentActivity = (SalesDocumentActivity) baseActivity21;
                                                    salesDocumentActivity.setOnNextPageLoad(this);
                                                    RelativeLayout relativeLayout12 = (RelativeLayout) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.sale_doc_toolbar_relativelayout);
                                                    Intrinsics.checkExpressionValueIsNotNull(relativeLayout12, "salesDocumentActivity.sa…oc_toolbar_relativelayout");
                                                    relativeLayout12.setVisibility(0);
                                                    ActionBar supportActionBar19 = salesDocumentActivity.getSupportActionBar();
                                                    if (supportActionBar19 != null) {
                                                        z = true;
                                                        supportActionBar19.setDisplayHomeAsUpEnabled(true);
                                                        Unit unit19 = Unit.INSTANCE;
                                                    } else {
                                                        z = true;
                                                    }
                                                    ActionBar supportActionBar20 = salesDocumentActivity.getSupportActionBar();
                                                    if (supportActionBar20 != null) {
                                                        supportActionBar20.setHomeButtonEnabled(z);
                                                        Unit unit20 = Unit.INSTANCE;
                                                    }
                                                    ConstraintLayout constraintLayout10 = (ConstraintLayout) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
                                                    Intrinsics.checkExpressionValueIsNotNull(constraintLayout10, "salesDocumentActivity.prebid_title_layout");
                                                    constraintLayout10.setVisibility(8);
                                                    salesDocumentActivity.getIvStockShare().setVisibility(0);
                                                    salesDocumentActivity.getIvToolTip().setVisibility(8);
                                                    if (i12 > 1) {
                                                        RelativeLayout relativeLayout13 = (RelativeLayout) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.sale_doc_toolbar_relativelayout);
                                                        Intrinsics.checkExpressionValueIsNotNull(relativeLayout13, "salesDocumentActivity.sa…oc_toolbar_relativelayout");
                                                        relativeLayout13.setGravity(GravityCompat.END);
                                                        RelativeLayout relativeLayout14 = (RelativeLayout) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.sale_doc_toolbar_relativelayout);
                                                        Intrinsics.checkExpressionValueIsNotNull(relativeLayout14, "salesDocumentActivity.sa…oc_toolbar_relativelayout");
                                                        relativeLayout14.setGravity(5);
                                                        TextView toolbar_title8 = salesDocumentActivity.getToolbar_title();
                                                        toolbar_title8.setText(String.valueOf(i11 + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(i12));
                                                        salesDocumentActivity.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darker));
                                                        salesDocumentActivity.getToolbar_sub_title().setVisibility(8);
                                                        if (i11 == 0) {
                                                            ImageView imageView74 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                                            Intrinsics.checkExpressionValueIsNotNull(imageView74, "salesDocumentActivity.arrow_right");
                                                            imageView74.setVisibility(0);
                                                            ImageView imageView75 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                                            Intrinsics.checkExpressionValueIsNotNull(imageView75, "salesDocumentActivity.arrow_right");
                                                            imageView75.setEnabled(false);
                                                            ((ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_left_arrow_disable);
                                                            i = 1;
                                                        } else {
                                                            ImageView imageView76 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                                            Intrinsics.checkExpressionValueIsNotNull(imageView76, "salesDocumentActivity.arrow_left");
                                                            imageView76.setVisibility(0);
                                                            ImageView imageView77 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
                                                            Intrinsics.checkExpressionValueIsNotNull(imageView77, "salesDocumentActivity.arrow_left");
                                                            i = 1;
                                                            imageView77.setEnabled(true);
                                                            ((ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left)).setImageResource(C2723R.C2725drawable.icon_left_arrow);
                                                        }
                                                        if (stringArrayList == null) {
                                                            Intrinsics.throwNpe();
                                                        }
                                                        if (i11 == stringArrayList.size() - i) {
                                                            ImageView imageView78 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                                            Intrinsics.checkExpressionValueIsNotNull(imageView78, "salesDocumentActivity.arrow_right");
                                                            imageView78.setVisibility(0);
                                                            ImageView imageView79 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                                            Intrinsics.checkExpressionValueIsNotNull(imageView79, "salesDocumentActivity.arrow_right");
                                                            imageView79.setEnabled(false);
                                                            ((ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow_disable);
                                                        } else {
                                                            ImageView imageView80 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                                            Intrinsics.checkExpressionValueIsNotNull(imageView80, "salesDocumentActivity.arrow_right");
                                                            imageView80.setVisibility(0);
                                                            ImageView imageView81 = (ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right);
                                                            Intrinsics.checkExpressionValueIsNotNull(imageView81, "salesDocumentActivity.arrow_right");
                                                            imageView81.setEnabled(true);
                                                            ((ImageView) salesDocumentActivity._$_findCachedViewById(C2723R.C2726id.arrow_right)).setImageResource(C2723R.C2725drawable.icon_right_arrow);
                                                        }
                                                    } else {
                                                        salesDocumentActivity.getToolbar_sub_title().setVisibility(8);
                                                    }
                                                } else {
                                                    throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.balance = i12 - size;
        BaseActivity baseActivity22 = this.baseActivity;
        if (baseActivity22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        View findViewById = baseActivity22.findViewById(C2723R.C2726id.viewPager2);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "baseActivity.findViewByI…ewPager>(R.id.viewPager2)");
        this.viewPager = (ViewPager) findViewById;
        ViewPager viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        if (viewPager2 != null) {
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkExpressionValueIsNotNull(childFragmentManager, "childFragmentManager");
            if (stringArrayList == null) {
                Intrinsics.throwNpe();
            }
            this.adapter = new ViewPagerAdapter(childFragmentManager, stringArrayList, arrayList);
            ViewPager viewPager3 = this.viewPager;
            if (viewPager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            }
            PagerAdapter pagerAdapter = this.adapter;
            if (pagerAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            viewPager3.setAdapter(pagerAdapter);
            ViewPager viewPager4 = this.viewPager;
            if (viewPager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            }
            viewPager4.setCurrentItem(i11, true);
            ViewPager viewPager5 = this.viewPager;
            if (viewPager5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            }
            viewPager5.setOffscreenPageLimit(0);
        }
        ViewPager viewPager6 = this.viewPager;
        if (viewPager6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager6.addOnPageChangeListener(new ViewPagerFragment$onActivityCreated$1(this, i12, stringArrayList));
        BaseActivity baseActivity23 = this.baseActivity;
        if (baseActivity23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity23 instanceof AuctionSalesListActivity) {
            BaseActivity baseActivity24 = this.baseActivity;
            if (baseActivity24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            if (baseActivity24 != null) {
                AuctionSalesListActivity auctionSalesListActivity2 = (AuctionSalesListActivity) baseActivity24;
                ((ImageView) auctionSalesListActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left)).setOnClickListener(new ViewPagerFragment$onActivityCreated$2(this));
                ((ImageView) auctionSalesListActivity2._$_findCachedViewById(C2723R.C2726id.arrow_right)).setOnClickListener(new ViewPagerFragment$onActivityCreated$3(this));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity");
        }
        BaseActivity baseActivity25 = this.baseActivity;
        if (baseActivity25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity25 instanceof ProductDetailActivity) {
            BaseActivity baseActivity26 = this.baseActivity;
            if (baseActivity26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            if (baseActivity26 != null) {
                ProductDetailActivity productDetailActivity2 = (ProductDetailActivity) baseActivity26;
                ((ImageView) productDetailActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left_fs)).setOnClickListener(new ViewPagerFragment$onActivityCreated$4(this));
                ((ImageView) productDetailActivity2._$_findCachedViewById(C2723R.C2726id.arrow_right_fs)).setOnClickListener(new ViewPagerFragment$onActivityCreated$5(this));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.productDetail.ProductDetailActivity");
        }
        BaseActivity baseActivity27 = this.baseActivity;
        if (baseActivity27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity27 instanceof SearchResultActivity) {
            BaseActivity baseActivity28 = this.baseActivity;
            if (baseActivity28 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            if (baseActivity28 != null) {
                SearchResultActivity searchResultActivity2 = (SearchResultActivity) baseActivity28;
                ((ImageView) searchResultActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left)).setOnClickListener(new ViewPagerFragment$onActivityCreated$6(this));
                ((ImageView) searchResultActivity2._$_findCachedViewById(C2723R.C2726id.arrow_right)).setOnClickListener(new ViewPagerFragment$onActivityCreated$7(this));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity");
        }
        BaseActivity baseActivity29 = this.baseActivity;
        if (baseActivity29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity29 instanceof RefinerResultActivity) {
            BaseActivity baseActivity30 = this.baseActivity;
            if (baseActivity30 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            if (baseActivity30 != null) {
                RefinerResultActivity refinerResultActivity2 = (RefinerResultActivity) baseActivity30;
                ((ImageView) refinerResultActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left)).setOnClickListener(new ViewPagerFragment$onActivityCreated$8(this));
                ((ImageView) refinerResultActivity2._$_findCachedViewById(C2723R.C2726id.arrow_right)).setOnClickListener(new ViewPagerFragment$onActivityCreated$9(this));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity");
        }
        BaseActivity baseActivity31 = this.baseActivity;
        if (baseActivity31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity31 instanceof ManageOfferListActivity) {
            BaseActivity baseActivity32 = this.baseActivity;
            if (baseActivity32 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            if (baseActivity32 != null) {
                ManageOfferListActivity manageOfferListActivity2 = (ManageOfferListActivity) baseActivity32;
                ((ImageView) manageOfferListActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left)).setOnClickListener(new ViewPagerFragment$onActivityCreated$10(this));
                ((ImageView) manageOfferListActivity2._$_findCachedViewById(C2723R.C2726id.arrow_right)).setOnClickListener(new ViewPagerFragment$onActivityCreated$11(this));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity");
        }
        BaseActivity baseActivity33 = this.baseActivity;
        if (baseActivity33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity33 instanceof PreSaleListActivity) {
            BaseActivity baseActivity34 = this.baseActivity;
            if (baseActivity34 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            if (baseActivity34 != null) {
                PreSaleListActivity preSaleListActivity2 = (PreSaleListActivity) baseActivity34;
                ((ImageView) preSaleListActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left_watch)).setOnClickListener(new ViewPagerFragment$onActivityCreated$12(this));
                ((ImageView) preSaleListActivity2._$_findCachedViewById(C2723R.C2726id.arrow_right_watch)).setOnClickListener(new ViewPagerFragment$onActivityCreated$13(this));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity");
        }
        BaseActivity baseActivity35 = this.baseActivity;
        if (baseActivity35 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity35 instanceof BDTPaymentActivity) {
            BaseActivity baseActivity36 = this.baseActivity;
            if (baseActivity36 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            if (baseActivity36 != null) {
                BDTPaymentActivity bDTPaymentActivity2 = (BDTPaymentActivity) baseActivity36;
                ((ImageView) bDTPaymentActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left)).setOnClickListener(new ViewPagerFragment$onActivityCreated$14(this));
                ((ImageView) bDTPaymentActivity2._$_findCachedViewById(C2723R.C2726id.arrow_right)).setOnClickListener(new ViewPagerFragment$onActivityCreated$15(this));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity");
        }
        BaseActivity baseActivity37 = this.baseActivity;
        if (baseActivity37 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity37 instanceof ToPickedUpAccountActivity) {
            BaseActivity baseActivity38 = this.baseActivity;
            if (baseActivity38 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            if (baseActivity38 != null) {
                ToPickedUpAccountActivity toPickedUpAccountActivity2 = (ToPickedUpAccountActivity) baseActivity38;
                ((ImageView) toPickedUpAccountActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left_tobePickUp)).setOnClickListener(new ViewPagerFragment$onActivityCreated$16(this));
                ((ImageView) toPickedUpAccountActivity2._$_findCachedViewById(C2723R.C2726id.arrow_right_tobePickUp)).setOnClickListener(new ViewPagerFragment$onActivityCreated$17(this));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity");
        }
        BaseActivity baseActivity39 = this.baseActivity;
        if (baseActivity39 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity39 instanceof BuyNowOfferListActivity) {
            BaseActivity baseActivity40 = this.baseActivity;
            if (baseActivity40 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            if (baseActivity40 != null) {
                BuyNowOfferListActivity buyNowOfferListActivity2 = (BuyNowOfferListActivity) baseActivity40;
                ((ImageView) buyNowOfferListActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left_buy_now)).setOnClickListener(new ViewPagerFragment$onActivityCreated$18(this));
                ((ImageView) buyNowOfferListActivity2._$_findCachedViewById(C2723R.C2726id.arrow_right_buy_now)).setOnClickListener(new ViewPagerFragment$onActivityCreated$19(this));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity");
        }
        BaseActivity baseActivity41 = this.baseActivity;
        if (baseActivity41 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity41 instanceof SalesDocumentActivity) {
            BaseActivity baseActivity42 = this.baseActivity;
            if (baseActivity42 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            if (baseActivity42 != null) {
                SalesDocumentActivity salesDocumentActivity2 = (SalesDocumentActivity) baseActivity42;
                ((ImageView) salesDocumentActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left)).setOnClickListener(new ViewPagerFragment$onActivityCreated$20(this));
                ((ImageView) salesDocumentActivity2._$_findCachedViewById(C2723R.C2726id.arrow_right)).setOnClickListener(new ViewPagerFragment$onActivityCreated$21(this));
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity");
        }
    }

    public final void loadFastSearchList(@NotNull SearchInputV2 searchInputV2) {
        Intrinsics.checkParameterIsNotNull(searchInputV2, "searchInput");
        subscribeToViewModel();
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
        FastSearchViewModel fastSearchViewModel = this.viewModel;
        if (fastSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        String deviceId = AppUtils.getDeviceId(baseActivity2);
        Intrinsics.checkExpressionValueIsNotNull(deviceId, "AppUtils.getDeviceId(baseActivity)");
        fastSearchViewModel.loadFastSearchListV2(format, deviceId, searchInputV2, false);
    }

    private final void subscribeToViewModel() {
        FastSearchViewModel fastSearchViewModel = this.viewModel;
        if (fastSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        fastSearchViewModel.getFastSearchListResult().removeObservers(lifecycleOwner);
        FastSearchViewModel fastSearchViewModel2 = this.viewModel;
        if (fastSearchViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<Boolean> showLoading = fastSearchViewModel2.getShowLoading();
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        showLoading.observe(baseActivity2, new ViewPagerFragment$subscribeToViewModel$1(this));
        FastSearchViewModel fastSearchViewModel3 = this.viewModel;
        if (fastSearchViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        fastSearchViewModel3.getFastSearchListResult().observe(lifecycleOwner, new ViewPagerFragment$subscribeToViewModel$2(this));
    }

    /* access modifiers changed from: private */
    public final void clearCostCalculatorSharedPreference() {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        Application application = baseActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
        SharedPreferences sharedPreferences = application.getApplicationContext().getSharedPreferences("cost_preferences_mvvm", 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "baseActivity!!.applicati…m\", Context.MODE_PRIVATE)");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit, "sharedPref.edit()");
        edit.clear();
        edit.commit();
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity3 == null) {
            Intrinsics.throwNpe();
        }
        Application application2 = baseActivity3.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application2, "baseActivity!!.application");
        SharedPreferences sharedPreferences2 = application2.getApplicationContext().getSharedPreferences("zip_cost_preferences_mvvm", 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences2, "baseActivity!!.applicati…m\", Context.MODE_PRIVATE)");
        SharedPreferences.Editor edit2 = sharedPreferences2.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit2, "sharedPrefZip.edit()");
        edit2.clear();
        edit2.commit();
        BaseActivity baseActivity4 = this.baseActivity;
        if (baseActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity4 == null) {
            Intrinsics.throwNpe();
        }
        Application application3 = baseActivity4.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application3, "baseActivity!!.application");
        SharedPreferences sharedPreferences3 = application3.getApplicationContext().getSharedPreferences("estimate_cost_preferences_mvvm", 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences3, "baseActivity!!.applicati…m\", Context.MODE_PRIVATE)");
        SharedPreferences.Editor edit3 = sharedPreferences3.edit();
        Intrinsics.checkExpressionValueIsNotNull(edit3, "sharedPrefEstimateBid.edit()");
        edit3.clear();
        edit3.commit();
    }

    public void OnNextSlotOfItemID(@NotNull ArrayList<String> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, Constants_MVVM.EXTRA_ITEM_ID);
        this.balance -= arrayList.size();
        ViewPagerAdapter viewPagerAdapter = this.adapter;
        if (viewPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        viewPagerAdapter.setItemIdList(arrayList);
        ViewPagerAdapter viewPagerAdapter2 = this.adapter;
        if (viewPagerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        viewPagerAdapter2.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (((ProgressBar) _$_findCachedViewById(C2723R.C2726id.view_pager_pbLoading)) == null) {
            return;
        }
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.view_pager_pbLoading);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "view_pager_pbLoading");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.view_pager_pbLoading);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "view_pager_pbLoading");
        progressBar2.setVisibility(8);
    }
}
