package com.iaai.android.bdt.feature.landing.quickFilter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.feature.landing.quickFilter.QuickFilterAdapter;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.model.quickFilter.QuickFilterResponse;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.databinding.FragmentSearchByVehicleBinding;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 !2\u00020\u00012\u00020\u0002:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u001e\u0010\u001f\u001a\u00020\u000f2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rR\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/quickFilter/SearchByAuctionFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterAdapter$OnQuickFilterClickListener;", "()V", "bdtLandingPageActivity", "Lcom/iaai/android/bdt/feature/landing/BDTLandingPageActivity;", "mBinding", "Lcom/iaai/android/databinding/FragmentSearchByVehicleBinding;", "quickFilterAdapter", "Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterAdapter;", "quickFilterList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/quickFilter/QuickFilterResponse;", "Lkotlin/collections/ArrayList;", "init", "", "initializeRecycler", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onItemClick", "selectedFilter", "setData", "filterList", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchByAuctionFragment.kt */
public final class SearchByAuctionFragment extends BaseFragment implements QuickFilterAdapter.OnQuickFilterClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private HashMap _$_findViewCache;
    private BDTLandingPageActivity bdtLandingPageActivity;
    private FragmentSearchByVehicleBinding mBinding;
    private QuickFilterAdapter quickFilterAdapter;
    private ArrayList<QuickFilterResponse> quickFilterList = new ArrayList<>();

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

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_search_by_vehicle, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate<…        container, false)");
        this.mBinding = (FragmentSearchByVehicleBinding) inflate;
        FragmentSearchByVehicleBinding fragmentSearchByVehicleBinding = this.mBinding;
        if (fragmentSearchByVehicleBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        return fragmentSearchByVehicleBinding.getRoot();
    }

    public final void init() {
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search);
        Intrinsics.checkExpressionValueIsNotNull(editText, "new_keyword_search");
        editText.setHint(getString(C2723R.string.hint_search_auction));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search)).setOnClickListener(new SearchByAuctionFragment$init$1(this));
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        init();
    }

    private final void initializeRecycler() {
        BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        this.quickFilterAdapter = new QuickFilterAdapter(bDTLandingPageActivity);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rv_quickFilterList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rv_quickFilterList");
        QuickFilterAdapter quickFilterAdapter2 = this.quickFilterAdapter;
        if (quickFilterAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quickFilterAdapter");
        }
        recyclerView.setAdapter(quickFilterAdapter2);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rv_quickFilterList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rv_quickFilterList");
        BDTLandingPageActivity bDTLandingPageActivity2 = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(bDTLandingPageActivity2));
        QuickFilterAdapter quickFilterAdapter3 = this.quickFilterAdapter;
        if (quickFilterAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("quickFilterAdapter");
        }
        quickFilterAdapter3.setClickListener(this);
    }

    public void onItemClick(@NotNull QuickFilterResponse quickFilterResponse) {
        QuickFilterResponse mapSelectedRefiner;
        String str;
        Intrinsics.checkParameterIsNotNull(quickFilterResponse, "selectedFilter");
        if (StringsKt.equals(quickFilterResponse.getType(), "quicklinks", true) || StringsKt.equals(quickFilterResponse.getType(), "sellertype", true) || StringsKt.equals(quickFilterResponse.getType(), "QuickLinkCategories-auction", true) || StringsKt.equals(quickFilterResponse.getType(), "quicklinks-auction", true)) {
            QuickLinksFragment quickLinksFragment = null;
            if (getParentFragment() instanceof QuickLinksFragment) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment != null) {
                    quickLinksFragment = (QuickLinksFragment) parentFragment;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.landing.quickFilter.QuickLinksFragment");
                }
            }
            if (IaaiApplication.is_new_fast_Search) {
                if (StringsKt.equals(quickFilterResponse.getType(), "QuickLinkCategories-auction", true)) {
                    str = ((String) StringsKt.split$default((CharSequence) quickFilterResponse.getType(), new String[]{"-"}, false, 0, 6, (Object) null).get(0)) + '~' + quickFilterResponse.getActualValue();
                } else {
                    str = quickFilterResponse.getType() + '~' + quickFilterResponse.getActualValue();
                }
                BDTUtils bDTUtils = BDTUtils.INSTANCE;
                String actualValue = quickFilterResponse.getActualValue();
                BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
                if (bDTLandingPageActivity == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
                }
                Resources resources = bDTLandingPageActivity.getResources();
                Intrinsics.checkExpressionValueIsNotNull(resources, "bdtLandingPageActivity.resources");
                FacetXX facetXX = new FacetXX(0, bDTUtils.showDisplayNameForPopularRefiner(actualValue, resources), str, true);
                ArrayList arrayList = new ArrayList();
                arrayList.add(facetXX);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(new SelectedRefinerIndicesModel(2, 0, 5));
                BDTLandingPageActivity bDTLandingPageActivity2 = this.bdtLandingPageActivity;
                if (bDTLandingPageActivity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
                }
                Intent intent = new Intent(bDTLandingPageActivity2, RefinerResultActivity.class);
                intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FACETS, arrayList);
                intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_INDICES, arrayList2);
                intent.putExtra(Constants_MVVM.EXTRA_IS_FROM_LANDING_PAGE_SEARCH, true);
                startActivity(intent);
                return;
            }
            if (!(quickLinksFragment == null || (mapSelectedRefiner = quickLinksFragment.mapSelectedRefiner(quickFilterResponse)) == null)) {
                quickFilterResponse = mapSelectedRefiner;
            }
            BDTLandingPageActivity bDTLandingPageActivity3 = this.bdtLandingPageActivity;
            if (bDTLandingPageActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
            }
            Intent intent2 = new Intent(bDTLandingPageActivity3, SearchResultActivity.class);
            intent2.putExtra(Constants_MVVM.EXTRA_QUICK_FILTER_SELECTED_VALUE, quickFilterResponse);
            startActivity(intent2);
        } else if (StringsKt.equals(quickFilterResponse.getType(), Constants.EXTRA_AUCTION, true)) {
            BDTLandingPageActivity bDTLandingPageActivity4 = this.bdtLandingPageActivity;
            if (bDTLandingPageActivity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
            }
            Intent intent3 = new Intent(bDTLandingPageActivity4, BDTAuctionMainListActivity.class);
            intent3.putExtra(Constants_MVVM.EXTRA_QUICK_FILTER_SELECTED_DATE, quickFilterResponse.getActualValue());
            startActivity(intent3);
        }
    }

    public final void setData(@NotNull ArrayList<QuickFilterResponse> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "filterList");
        if (isAdded()) {
            this.quickFilterList = arrayList;
            initializeRecycler();
            QuickFilterAdapter quickFilterAdapter2 = this.quickFilterAdapter;
            if (quickFilterAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quickFilterAdapter");
            }
            quickFilterAdapter2.setQuickFilterData(this.quickFilterList);
            QuickFilterAdapter quickFilterAdapter3 = this.quickFilterAdapter;
            if (quickFilterAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quickFilterAdapter");
            }
            quickFilterAdapter3.setQuickFilterType(QuickFilterAdapter.Companion.QuickFilterType.AUCTION_QUICK_FILTER);
            QuickFilterAdapter quickFilterAdapter4 = this.quickFilterAdapter;
            if (quickFilterAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quickFilterAdapter");
            }
            quickFilterAdapter4.notifyDataSetChanged();
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/quickFilter/SearchByAuctionFragment$Companion;", "", "()V", "newInstance", "Lcom/iaai/android/bdt/feature/landing/quickFilter/SearchByAuctionFragment;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SearchByAuctionFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchByAuctionFragment newInstance() {
            return new SearchByAuctionFragment();
        }
    }
}
