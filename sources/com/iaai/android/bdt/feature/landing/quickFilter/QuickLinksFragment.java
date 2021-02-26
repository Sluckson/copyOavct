package com.iaai.android.bdt.feature.landing.quickFilter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.base.CustomViewPager;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.model.fastSearch.FastSearchResponse;
import com.iaai.android.bdt.model.fastSearch.Refiner;
import com.iaai.android.bdt.model.fastSearch.RefinerX;
import com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner;
import com.iaai.android.bdt.model.fastSearch.SearchInputV2;
import com.iaai.android.bdt.model.fastSearchFilter2.Facet;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchResponse2;
import com.iaai.android.bdt.model.fastSearchFilter2.LatLong;
import com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes;
import com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData;
import com.iaai.android.bdt.model.fastSearchFilter2.SavedSearch;
import com.iaai.android.bdt.model.fastSearchFilter2.Searche;
import com.iaai.android.bdt.model.fastSearchFilter2.Sort;
import com.iaai.android.bdt.model.quickFilter.QuickFilterResponse;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0016\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\b\u0010%\u001a\u00020&H\u0002J\u000e\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020 J\u0012\u0010)\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020\u001c2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u0001052\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u00106\u001a\u00020\u001cH\u0016J\u0016\u00107\u001a\u00020\u001c2\f\u00108\u001a\b\u0012\u0004\u0012\u0002090\u001fH\u0002J\u0010\u0010:\u001a\u00020\u001c2\u0006\u0010;\u001a\u00020<H\u0002J\u000e\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>J\u0010\u0010@\u001a\u00020\u001c2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020BH\u0002J\b\u0010E\u001a\u00020\u001cH\u0002J\b\u0010F\u001a\u00020\u001cH\u0002J\b\u0010G\u001a\u00020\u001cH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006H"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickLinksFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "bdtLandingPageActivity", "Lcom/iaai/android/bdt/feature/landing/BDTLandingPageActivity;", "mBinding", "Landroidx/databinding/ViewDataBinding;", "popularRefinerCategories", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/fastSearch/RefinerX;", "Lkotlin/collections/ArrayList;", "getPopularRefinerCategories", "()Ljava/util/ArrayList;", "searchByAuctionFragment", "Lcom/iaai/android/bdt/feature/landing/quickFilter/SearchByAuctionFragment;", "searchByVehicleAdapter", "Lcom/iaai/android/bdt/feature/landing/quickFilter/SearchByVehicleAdapter;", "searchByVehicleFragment", "Lcom/iaai/android/bdt/feature/landing/quickFilter/SearchByVehicleFragment;", "viewModel", "Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "checkNetworkConnection", "", "displayQuickFilters", "quickFilterList", "", "Lcom/iaai/android/bdt/model/quickFilter/QuickFilterResponse;", "getFacets", "loadQuickLinkAndFacets", "loadQuickLinkAndRefinerInfo", "loadRefinerData", "makeRefinerRequestBody", "Lcom/iaai/android/bdt/model/fastSearch/SearchInputV2;", "mapSelectedRefiner", "selectedFilter", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "setFilterRefinersValues", "refinerList", "Lcom/iaai/android/bdt/model/fastSearch/Refiner;", "setupViewPager", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "showDisplayNameForPopularRefiner", "", "displayValue", "showEmptyState", "isShowEmptyState", "", "showLoadingIndicator", "loading", "subscribeToViewForFacets", "subscribeToViewModel", "subscribeToViewModelRefiner", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: QuickLinksFragment.kt */
public final class QuickLinksFragment extends BaseFragment {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public BDTLandingPageActivity bdtLandingPageActivity;
    private ViewDataBinding mBinding;
    @NotNull
    private final ArrayList<RefinerX> popularRefinerCategories = new ArrayList<>();
    private SearchByAuctionFragment searchByAuctionFragment;
    private SearchByVehicleAdapter searchByVehicleAdapter;
    private SearchByVehicleFragment searchByVehicleFragment;
    /* access modifiers changed from: private */
    public QuickFilterViewModel viewModel;
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

    public static final /* synthetic */ BDTLandingPageActivity access$getBdtLandingPageActivity$p(QuickLinksFragment quickLinksFragment) {
        BDTLandingPageActivity bDTLandingPageActivity = quickLinksFragment.bdtLandingPageActivity;
        if (bDTLandingPageActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        return bDTLandingPageActivity;
    }

    public static final /* synthetic */ QuickFilterViewModel access$getViewModel$p(QuickLinksFragment quickLinksFragment) {
        QuickFilterViewModel quickFilterViewModel = quickLinksFragment.viewModel;
        if (quickFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return quickFilterViewModel;
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
    public final ArrayList<RefinerX> getPopularRefinerCategories() {
        return this.popularRefinerCategories;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.bdtLandingPageActivity = (BDTLandingPageActivity) activity;
            if (context instanceof BDTLandingPageActivity) {
                this.bdtLandingPageActivity = (BDTLandingPageActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.landing.BDTLandingPageActivity");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragment = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m16of(fragment, factory).get(QuickFilterViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…terViewModel::class.java)");
        this.viewModel = (QuickFilterViewModel) viewModel2;
        subscribeToViewModel();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_bdt_find_vehicle_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate(…        container, false)");
        this.mBinding = inflate;
        ViewDataBinding viewDataBinding = this.mBinding;
        if (viewDataBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        return viewDataBinding.getRoot();
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        CustomViewPager customViewPager = (CustomViewPager) _$_findCachedViewById(C2723R.C2726id.vehicle_search_pager);
        Intrinsics.checkExpressionValueIsNotNull(customViewPager, "vehicle_search_pager");
        setupViewPager(customViewPager);
        ((TabLayout) _$_findCachedViewById(C2723R.C2726id.tl_find_vehicle)).setupWithViewPager((CustomViewPager) _$_findCachedViewById(C2723R.C2726id.vehicle_search_pager));
        checkNetworkConnection();
    }

    private final void setupViewPager(ViewPager viewPager) {
        this.searchByVehicleAdapter = new SearchByVehicleAdapter(getChildFragmentManager());
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkExpressionValueIsNotNull(childFragmentManager, "childFragmentManager");
        if (childFragmentManager.getFragments().isEmpty()) {
            this.searchByVehicleFragment = SearchByVehicleFragment.Companion.newInstance();
            this.searchByAuctionFragment = SearchByAuctionFragment.Companion.newInstance();
        } else {
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkExpressionValueIsNotNull(childFragmentManager2, "childFragmentManager");
            Fragment fragment = childFragmentManager2.getFragments().get(0);
            if (fragment != null) {
                this.searchByVehicleFragment = (SearchByVehicleFragment) fragment;
                FragmentManager childFragmentManager3 = getChildFragmentManager();
                Intrinsics.checkExpressionValueIsNotNull(childFragmentManager3, "childFragmentManager");
                Fragment fragment2 = childFragmentManager3.getFragments().get(1);
                if (fragment2 != null) {
                    this.searchByAuctionFragment = (SearchByAuctionFragment) fragment2;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.landing.quickFilter.SearchByAuctionFragment");
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.landing.quickFilter.SearchByVehicleFragment");
            }
        }
        SearchByVehicleAdapter searchByVehicleAdapter2 = this.searchByVehicleAdapter;
        if (searchByVehicleAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchByVehicleAdapter");
        }
        SearchByVehicleFragment searchByVehicleFragment2 = this.searchByVehicleFragment;
        if (searchByVehicleFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchByVehicleFragment");
        }
        searchByVehicleAdapter2.addFragment(searchByVehicleFragment2, getResources().getString(C2723R.string.lbl_bdt_search_by_vehicle_title));
        SearchByVehicleAdapter searchByVehicleAdapter3 = this.searchByVehicleAdapter;
        if (searchByVehicleAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchByVehicleAdapter");
        }
        SearchByAuctionFragment searchByAuctionFragment2 = this.searchByAuctionFragment;
        if (searchByAuctionFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchByAuctionFragment");
        }
        searchByVehicleAdapter3.addFragment(searchByAuctionFragment2, getResources().getString(C2723R.string.lbl_bdt_search_by_auction_title));
        SearchByVehicleAdapter searchByVehicleAdapter4 = this.searchByVehicleAdapter;
        if (searchByVehicleAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchByVehicleAdapter");
        }
        viewPager.setAdapter(searchByVehicleAdapter4);
        viewPager.addOnPageChangeListener(new QuickLinksFragment$setupViewPager$1(this));
    }

    private final void subscribeToViewModel() {
        QuickFilterViewModel quickFilterViewModel = this.viewModel;
        if (quickFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<Boolean> showLoading = quickFilterViewModel.getShowLoading();
        BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        showLoading.observe(bDTLandingPageActivity, new QuickLinksFragment$subscribeToViewModel$1(this));
        QuickFilterViewModel quickFilterViewModel2 = this.viewModel;
        if (quickFilterViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<List<QuickFilterResponse>> quickFilterResponse = quickFilterViewModel2.getQuickFilterResponse();
        BDTLandingPageActivity bDTLandingPageActivity2 = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        quickFilterResponse.observe(bDTLandingPageActivity2, new QuickLinksFragment$subscribeToViewModel$2(this));
        QuickFilterViewModel quickFilterViewModel3 = this.viewModel;
        if (quickFilterViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> quickFilterError = quickFilterViewModel3.getQuickFilterError();
        BDTLandingPageActivity bDTLandingPageActivity3 = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        quickFilterError.observe(bDTLandingPageActivity3, new QuickLinksFragment$subscribeToViewModel$3(this));
    }

    public void onResume() {
        super.onResume();
        CustomViewPager customViewPager = (CustomViewPager) _$_findCachedViewById(C2723R.C2726id.vehicle_search_pager);
        Intrinsics.checkExpressionValueIsNotNull(customViewPager, "vehicle_search_pager");
        setupViewPager(customViewPager);
        ((TabLayout) _$_findCachedViewById(C2723R.C2726id.tl_find_vehicle)).setupWithViewPager((CustomViewPager) _$_findCachedViewById(C2723R.C2726id.vehicle_search_pager));
        checkNetworkConnection();
    }

    /* access modifiers changed from: private */
    public final void displayQuickFilters(List<QuickFilterResponse> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (QuickFilterResponse quickFilterResponse : list) {
            if (StringsKt.equals(quickFilterResponse.getType(), "quicklinks", true) || StringsKt.equals(quickFilterResponse.getType(), "sellertype", true) || StringsKt.equals(quickFilterResponse.getType(), "QuickLinkCategories", true)) {
                quickFilterResponse.setDisplayValue(showDisplayNameForPopularRefiner(quickFilterResponse.getDisplayValue()));
                arrayList.add(quickFilterResponse);
            } else {
                quickFilterResponse.setDisplayValue(showDisplayNameForPopularRefiner(quickFilterResponse.getDisplayValue()));
                arrayList2.add(quickFilterResponse);
            }
        }
        SearchByVehicleFragment searchByVehicleFragment2 = this.searchByVehicleFragment;
        if (searchByVehicleFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchByVehicleFragment");
        }
        searchByVehicleFragment2.setData(arrayList);
        SearchByAuctionFragment searchByAuctionFragment2 = this.searchByAuctionFragment;
        if (searchByAuctionFragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchByAuctionFragment");
        }
        searchByAuctionFragment2.setData(arrayList2);
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbFilter);
            if (progressBar != null) {
                progressBar.setVisibility(0);
                return;
            }
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbFilter);
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
    }

    private final void checkNetworkConnection() {
        if (!InternetUtil.INSTANCE.isInternetOn()) {
            showEmptyState(true);
            displayError(BaseFragment.ErrorType.NO_INTERNET, "");
            InternetUtil internetUtil = InternetUtil.INSTANCE;
            BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
            if (bDTLandingPageActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
            }
            internetUtil.observe(bDTLandingPageActivity, new QuickLinksFragment$checkNetworkConnection$1(this));
        } else if (IaaiApplication.is_new_fast_Search) {
            loadQuickLinkAndFacets();
        } else {
            loadQuickLinkAndRefinerInfo();
        }
    }

    /* access modifiers changed from: private */
    public final void loadQuickLinkAndRefinerInfo() {
        if (!IaaiApplication.loadRefinerFirstTime) {
            BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
            if (bDTLandingPageActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
            }
            if (!Activity_ExtensionKt.isHourOverForRefiner(bDTLandingPageActivity)) {
                BDTLandingPageActivity bDTLandingPageActivity2 = this.bdtLandingPageActivity;
                if (bDTLandingPageActivity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
                }
                String refinerJson = IAASharedPreference.getRefinerJson(bDTLandingPageActivity2);
                Intrinsics.checkExpressionValueIsNotNull(refinerJson, "refinerJSON");
                if (refinerJson.length() > 0) {
                    Object fromJson = new Gson().fromJson(refinerJson, new QuickLinksFragment$loadQuickLinkAndRefinerInfo$refinerList$1().getType());
                    if (fromJson != null) {
                        setFilterRefinersValues((List) fromJson);
                        QuickFilterViewModel quickFilterViewModel = this.viewModel;
                        if (quickFilterViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        }
                        quickFilterViewModel.getQuickFilter();
                        return;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<com.iaai.android.bdt.model.fastSearch.Refiner>");
                }
                return;
            }
        }
        loadRefinerData();
        subscribeToViewModelRefiner();
    }

    /* access modifiers changed from: private */
    public final void loadQuickLinkAndFacets() {
        if (!IaaiApplication.loadNewRefinerFirstTime) {
            BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
            if (bDTLandingPageActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
            }
            if (!Activity_ExtensionKt.isHourOverForFacets(bDTLandingPageActivity)) {
                QuickFilterViewModel quickFilterViewModel = this.viewModel;
                if (quickFilterViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                quickFilterViewModel.getQuickFilter();
                return;
            }
        }
        getFacets();
    }

    /* access modifiers changed from: private */
    public final void showEmptyState(boolean z) {
        if (!isAdded()) {
            return;
        }
        if (z) {
            CustomViewPager customViewPager = (CustomViewPager) _$_findCachedViewById(C2723R.C2726id.vehicle_search_pager);
            Intrinsics.checkExpressionValueIsNotNull(customViewPager, "vehicle_search_pager");
            customViewPager.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "emptyRecyclerView");
            linearLayout.setVisibility(0);
            return;
        }
        CustomViewPager customViewPager2 = (CustomViewPager) _$_findCachedViewById(C2723R.C2726id.vehicle_search_pager);
        Intrinsics.checkExpressionValueIsNotNull(customViewPager2, "vehicle_search_pager");
        customViewPager2.setVisibility(0);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "emptyRecyclerView");
        linearLayout2.setVisibility(8);
    }

    private final void loadRefinerData() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        objArr[0] = bDTLandingPageActivity.getSessionManager().getCurrentSessionUsername();
        BDTLandingPageActivity bDTLandingPageActivity2 = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        objArr[1] = bDTLandingPageActivity2.getSessionManager().getCurrentSessionPassword();
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        QuickFilterViewModel quickFilterViewModel = this.viewModel;
        if (quickFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        BDTLandingPageActivity bDTLandingPageActivity3 = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        String deviceId = AppUtils.getDeviceId(bDTLandingPageActivity3);
        Intrinsics.checkExpressionValueIsNotNull(deviceId, "AppUtils.getDeviceId(bdtLandingPageActivity)");
        quickFilterViewModel.loadFastSearchListV2(format, deviceId, makeRefinerRequestBody());
    }

    private final void getFacets() {
        Searche searche = new Searche("", CollectionsKt.arrayListOf(new Facet("Default", "True")), "", (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null);
        Searche[] searcheArr = {searche};
        Sort[] sortArr = {new Sort(true, false, "Year")};
        SavedSearch savedSearch = r1;
        SavedSearch savedSearch2 = new SavedSearch("", 0, 0, "");
        FastSearchRequestBody fastSearchRequestBody = new FastSearchRequestBody("", 1, true, true, false, (List<String>) null, 0, 1, (LatLong) null, CollectionsKt.arrayListOf(searcheArr), CollectionsKt.arrayListOf(sortArr), new ArrayList(), false, false, false, 0, "", savedSearch);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        objArr[0] = bDTLandingPageActivity.getSessionManager().getCurrentSessionUsername();
        BDTLandingPageActivity bDTLandingPageActivity2 = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        objArr[1] = bDTLandingPageActivity2.getSessionManager().getCurrentSessionPassword();
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        QuickFilterViewModel quickFilterViewModel = this.viewModel;
        if (quickFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        quickFilterViewModel.getFacets(fastSearchRequestBody, format);
        subscribeToViewForFacets();
    }

    private final SearchInputV2 makeRefinerRequestBody() {
        RequestSelectedRefiner requestSelectedRefiner = new RequestSelectedRefiner("readyforbid", CollectionsKt.arrayListOf(""));
        ArrayList arrayList = new ArrayList();
        arrayList.add(requestSelectedRefiner);
        return new SearchInputV2(1, "", "", "", true, arrayList, new ArrayList(), 1);
    }

    private final void subscribeToViewModelRefiner() {
        QuickFilterViewModel quickFilterViewModel = this.viewModel;
        if (quickFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<FastSearchResponse> fastSearchListResult = quickFilterViewModel.getFastSearchListResult();
        BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        fastSearchListResult.observe(bDTLandingPageActivity, new QuickLinksFragment$subscribeToViewModelRefiner$1(this));
        QuickFilterViewModel quickFilterViewModel2 = this.viewModel;
        if (quickFilterViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> fastSearchListError = quickFilterViewModel2.getFastSearchListError();
        BDTLandingPageActivity bDTLandingPageActivity2 = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        fastSearchListError.observe(bDTLandingPageActivity2, new QuickLinksFragment$subscribeToViewModelRefiner$2(this));
    }

    private final void subscribeToViewForFacets() {
        QuickFilterViewModel quickFilterViewModel = this.viewModel;
        if (quickFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<FastSearchResponse2> facetsResult = quickFilterViewModel.getFacetsResult();
        BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        facetsResult.observe(bDTLandingPageActivity, new QuickLinksFragment$subscribeToViewForFacets$1(this));
        QuickFilterViewModel quickFilterViewModel2 = this.viewModel;
        if (quickFilterViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> facetsError = quickFilterViewModel2.getFacetsError();
        BDTLandingPageActivity bDTLandingPageActivity2 = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        facetsError.observe(bDTLandingPageActivity2, new QuickLinksFragment$subscribeToViewForFacets$2(this));
    }

    /* access modifiers changed from: private */
    public final void setFilterRefinersValues(List<Refiner> list) {
        for (Refiner refiner : list) {
            if (StringsKt.equals(refiner.getDisplayName(), "Popular Categories", true)) {
                for (RefinerX refinerX : refiner.getRefiners()) {
                    if (!refinerX.getRefinerValue().equals("Vrd")) {
                        this.popularRefinerCategories.add(new RefinerX(showDisplayNameForPopularRefiner(refinerX.getDisplayName()), refinerX.getRefinerCount(), refinerX.getRefinerValue(), false));
                    }
                }
            }
        }
    }

    @NotNull
    public final String showDisplayNameForPopularRefiner(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "displayValue");
        if (StringsKt.equals(str, "Buy Now", true)) {
            String string = getResources().getString(C2723R.string.bdt_lbl_buy_now);
            Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.bdt_lbl_buy_now)");
            return string;
        } else if (StringsKt.equals(str, "Run & Drive", true)) {
            String string2 = getResources().getString(C2723R.string.bdt_product_dtl_run_drive);
            Intrinsics.checkExpressionValueIsNotNull(string2, "resources.getString(R.st…dt_product_dtl_run_drive)");
            return string2;
        } else if (StringsKt.equals(str, "Buy Now Vehicles", true)) {
            String string3 = getResources().getString(C2723R.string.bdt_lbl_buy_now_vehicles);
            Intrinsics.checkExpressionValueIsNotNull(string3, "resources.getString(R.st…bdt_lbl_buy_now_vehicles)");
            return string3;
        } else if (StringsKt.equals(str, "Run & Drive Vehicles", true)) {
            String string4 = getResources().getString(C2723R.string.bdt_product_dtl_run_drive_vehicles);
            Intrinsics.checkExpressionValueIsNotNull(string4, "resources.getString(R.st…t_dtl_run_drive_vehicles)");
            return string4;
        } else if (StringsKt.equals(str, "Browse All Vehicles", true)) {
            String string5 = getResources().getString(C2723R.string.bdt_lbl_quick_browse_all_vehicles);
            Intrinsics.checkExpressionValueIsNotNull(string5, "resources.getString(R.st…uick_browse_all_vehicles)");
            return string5;
        } else if (StringsKt.equals(str, "Browse Public Vehicles", true)) {
            String string6 = getResources().getString(C2723R.string.bdt_lbl_quick_browse_public_vehicles);
            Intrinsics.checkExpressionValueIsNotNull(string6, "resources.getString(R.st…k_browse_public_vehicles)");
            return string6;
        } else if (StringsKt.equals(str, "Clear Title", true)) {
            String string7 = getResources().getString(C2723R.string.bdt_refiner_clean_title);
            Intrinsics.checkExpressionValueIsNotNull(string7, "resources.getString(R.st….bdt_refiner_clean_title)");
            return string7;
        } else if (StringsKt.equals(str, "Available to the Public", true)) {
            String string8 = getResources().getString(C2723R.string.bdt_lbl_available_for_public);
            Intrinsics.checkExpressionValueIsNotNull(string8, "resources.getString(R.st…lbl_available_for_public)");
            return string8;
        } else if (StringsKt.equals(str, "Flood/Water", true)) {
            String string9 = getResources().getString(C2723R.string.bdt_lbl_flood_water);
            Intrinsics.checkExpressionValueIsNotNull(string9, "resources.getString(R.string.bdt_lbl_flood_water)");
            return string9;
        } else if (StringsKt.equals(str, "Repossession", true)) {
            String string10 = getResources().getString(C2723R.string.bdt_lbl_repossession);
            Intrinsics.checkExpressionValueIsNotNull(string10, "resources.getString(R.string.bdt_lbl_repossession)");
            return string10;
        } else if (StringsKt.equals(str, "Recovered Theft", true)) {
            String string11 = getResources().getString(C2723R.string.bdt_lbl_recovered_theft);
            Intrinsics.checkExpressionValueIsNotNull(string11, "resources.getString(R.st….bdt_lbl_recovered_theft)");
            return string11;
        } else if (StringsKt.equals(str, "Remarketing", true)) {
            String string12 = getResources().getString(C2723R.string.bdt_lbl_marketing);
            Intrinsics.checkExpressionValueIsNotNull(string12, "resources.getString(R.string.bdt_lbl_marketing)");
            return string12;
        } else if (StringsKt.equals(str, "Today", true)) {
            String string13 = getResources().getString(C2723R.string.bdt_lbl_today);
            Intrinsics.checkExpressionValueIsNotNull(string13, "resources.getString(R.string.bdt_lbl_today)");
            return string13;
        } else if (StringsKt.equals(str, "Monday", true)) {
            String string14 = getResources().getString(C2723R.string.bdt_lbl_monday);
            Intrinsics.checkExpressionValueIsNotNull(string14, "resources.getString(R.string.bdt_lbl_monday)");
            return string14;
        } else if (StringsKt.equals(str, "Specialty", true)) {
            String string15 = getResources().getString(C2723R.string.bdt_lbl_speciality);
            Intrinsics.checkExpressionValueIsNotNull(string15, "resources.getString(R.string.bdt_lbl_speciality)");
            return string15;
        } else if (StringsKt.equals(str, "Tomorrow", true)) {
            String string16 = getResources().getString(C2723R.string.bdt_lbl_tomorrow);
            Intrinsics.checkExpressionValueIsNotNull(string16, "resources.getString(R.string.bdt_lbl_tomorrow)");
            return string16;
        } else if (StringsKt.equals(str, "This Week", true)) {
            String string17 = getResources().getString(C2723R.string.bdt_lbl_this_week);
            Intrinsics.checkExpressionValueIsNotNull(string17, "resources.getString(R.string.bdt_lbl_this_week)");
            return string17;
        } else if (StringsKt.equals(str, "Next Week", true)) {
            String string18 = getResources().getString(C2723R.string.bdt_lbl_next_week);
            Intrinsics.checkExpressionValueIsNotNull(string18, "resources.getString(R.string.bdt_lbl_next_week)");
            return string18;
        } else if (StringsKt.equals(str, "Timed Auctions", true)) {
            String string19 = getResources().getString(C2723R.string.bdt_lbl_timed_auction);
            Intrinsics.checkExpressionValueIsNotNull(string19, "resources.getString(R.st…ng.bdt_lbl_timed_auction)");
            return string19;
        } else if (!StringsKt.equals(str, "ACE CA Vehicles", true)) {
            return str;
        } else {
            String string20 = getResources().getString(C2723R.string.bdt_lbl_ace_ca_vehicles);
            Intrinsics.checkExpressionValueIsNotNull(string20, "resources.getString(R.st….bdt_lbl_ace_ca_vehicles)");
            return string20;
        }
    }

    @NotNull
    public final QuickFilterResponse mapSelectedRefiner(@NotNull QuickFilterResponse quickFilterResponse) {
        Intrinsics.checkParameterIsNotNull(quickFilterResponse, "selectedFilter");
        Iterator it = this.popularRefinerCategories.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            RefinerX refinerX = (RefinerX) it.next();
            if (StringsKt.equals(quickFilterResponse.getActualValue(), refinerX.getRefinerValue(), true)) {
                quickFilterResponse.setDisplayValue(refinerX.getDisplayName());
                break;
            }
        }
        return quickFilterResponse;
    }
}
