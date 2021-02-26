package com.iaai.android.bdt.feature.landing.quickFilter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.feature.landing.quickFilter.QuickFilterAdapter;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.model.quickFilter.QuickFilterResponse;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.databinding.FragmentSearchByVehicleBinding;
import com.iaai.android.old.utils.AppUtils;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010&\u001a\u00020'H\u0002J\u0006\u0010(\u001a\u00020'J\b\u0010)\u001a\u00020'H\u0002J\u0012\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\"\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u00103\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0016J\u0012\u00106\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J&\u00107\u001a\u0004\u0018\u0001082\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0010\u0010=\u001a\u00020'2\u0006\u0010>\u001a\u00020\u0012H\u0016J\u001e\u0010?\u001a\u00020'2\u0016\u0010@\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013J\u0010\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020\u000bH\u0002J\u0010\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020/H\u0002J\b\u0010E\u001a\u00020'H\u0002R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0011j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0015`\u0013X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0011j\b\u0012\u0004\u0012\u00020\u0017`\u0013X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006G"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/quickFilter/SearchByVehicleFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterAdapter$OnQuickFilterClickListener;", "()V", "CONTENT_TYPE", "", "getCONTENT_TYPE", "()Ljava/lang/String;", "bdtLandingPageActivity", "Lcom/iaai/android/bdt/feature/landing/BDTLandingPageActivity;", "isFromLandingPageSearch", "", "mBinding", "Lcom/iaai/android/databinding/FragmentSearchByVehicleBinding;", "quickFilterAdapter", "Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterAdapter;", "quickFilterList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/quickFilter/QuickFilterResponse;", "Lkotlin/collections/ArrayList;", "selectedFacets", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "selectedIndices", "Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/SelectedRefinerIndicesModel;", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "viewModel", "Lcom/iaai/android/bdt/feature/landing/quickFilter/QuickFilterViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "fetchSavedSearchListCount", "", "init", "initializeRecycler", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onItemClick", "selectedFilter", "setData", "filterList", "showLoadingIndicator", "loading", "showSavedSearchedUI", "savedSearchCount", "subscribeToViewModel", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchByVehicleFragment.kt */
public final class SearchByVehicleFragment extends BaseFragment implements QuickFilterAdapter.OnQuickFilterClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private final String CONTENT_TYPE = "application/json";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public BDTLandingPageActivity bdtLandingPageActivity;
    private boolean isFromLandingPageSearch;
    private FragmentSearchByVehicleBinding mBinding;
    private QuickFilterAdapter quickFilterAdapter;
    private ArrayList<QuickFilterResponse> quickFilterList = new ArrayList<>();
    private ArrayList<FacetXX> selectedFacets;
    private ArrayList<SelectedRefinerIndicesModel> selectedIndices;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private QuickFilterViewModel viewModel;
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

    public static final /* synthetic */ BDTLandingPageActivity access$getBdtLandingPageActivity$p(SearchByVehicleFragment searchByVehicleFragment) {
        BDTLandingPageActivity bDTLandingPageActivity = searchByVehicleFragment.bdtLandingPageActivity;
        if (bDTLandingPageActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        return bDTLandingPageActivity;
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
    public final String getCONTENT_TYPE() {
        return this.CONTENT_TYPE;
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
        editText.setHint(getString(C2723R.string.hint_search_vehicle));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.new_keyword_search)).setOnClickListener(new SearchByVehicleFragment$init$1(this));
        ((ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.clSavedSearch)).setOnClickListener(new SearchByVehicleFragment$init$2(this));
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        init();
        fetchSavedSearchListCount();
    }

    private final void fetchSavedSearchListCount() {
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
        QuickFilterViewModel quickFilterViewModel = this.viewModel;
        if (quickFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        String deviceId = AppUtils.getDeviceId(bDTLandingPageActivity);
        if (deviceId == null) {
            deviceId = "";
        }
        quickFilterViewModel.getSavedSearchList(format, deviceId, "android", Constants_MVVM.SEARCH_API_KEY, this.CONTENT_TYPE, String.valueOf(1));
        subscribeToViewModel();
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

    private final void subscribeToViewModel() {
        QuickFilterViewModel quickFilterViewModel = this.viewModel;
        if (quickFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<ArrayList<SavedSearchListResponse>> savedSearchListResponse = quickFilterViewModel.getSavedSearchListResponse();
        BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        savedSearchListResponse.observe(bDTLandingPageActivity, new SearchByVehicleFragment$subscribeToViewModel$1(this));
        QuickFilterViewModel quickFilterViewModel2 = this.viewModel;
        if (quickFilterViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> savedSearchListError = quickFilterViewModel2.getSavedSearchListError();
        BDTLandingPageActivity bDTLandingPageActivity2 = this.bdtLandingPageActivity;
        if (bDTLandingPageActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
        }
        savedSearchListError.observe(bDTLandingPageActivity2, new SearchByVehicleFragment$subscribeToViewModel$2(this));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c3, code lost:
        if (r1.equals("I-Buy Fast") != false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ca, code lost:
        if (r1.equals("I-buy Fast") != false) goto L_0x00cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00cc, code lost:
        r1 = "Buy Now";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e2, code lost:
        r1 = r11.getActualValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e6, code lost:
        r11 = r11.getActualValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ef, code lost:
        switch(r11.hashCode()) {
            case 488295483: goto L_0x0105;
            case 1790133918: goto L_0x00fd;
            case 2059642586: goto L_0x00f8;
            case 2124286714: goto L_0x00f3;
            default: goto L_0x00f2;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f3, code lost:
        r11 = r11.equals("I-Buy Fast");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f8, code lost:
        r11 = r11.equals("I-buy Fast");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0101, code lost:
        if (r11.equals("Public Vehicles") == false) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0103, code lost:
        r11 = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0109, code lost:
        if (r11.equals("Run & Drive") == false) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x010b, code lost:
        r11 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010d, code lost:
        r11 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x010e, code lost:
        r5 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE;
        r6 = r10.bdtLandingPageActivity;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0114, code lost:
        if (r6 != null) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0116, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0119, code lost:
        r6 = r6.getResources();
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, "bdtLandingPageActivity.resources");
        r4 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX(0, r5.showDisplayNameForPopularRefiner(r1, r6), r0, true);
        r0 = new java.util.ArrayList();
        r0.add(r4);
        r1 = new java.util.ArrayList();
        r1.add(new com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel(2, 0, r11));
        r4 = r10.bdtLandingPageActivity;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0143, code lost:
        if (r4 != null) goto L_0x0148;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0145, code lost:
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0148, code lost:
        r11 = new android.content.Intent(r4, com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity.class);
        r11.putParcelableArrayListExtra(com.iaai.android.bdt.utils.Constants_MVVM.EXTRA_SELECTED_FACETS, r0);
        r11.putParcelableArrayListExtra(com.iaai.android.bdt.utils.Constants_MVVM.EXTRA_SELECTED_INDICES, r1);
        r11.putExtra(com.iaai.android.bdt.utils.Constants_MVVM.EXTRA_IS_FROM_LANDING_PAGE_SEARCH, true);
        startActivity(r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClick(@org.jetbrains.annotations.NotNull com.iaai.android.bdt.model.quickFilter.QuickFilterResponse r11) {
        /*
            r10 = this;
            java.lang.String r0 = "selectedFilter"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r11, r0)
            r0 = 0
            com.iaai.android.bdt.feature.landing.quickFilter.QuickLinksFragment r0 = (com.iaai.android.bdt.feature.landing.quickFilter.QuickLinksFragment) r0
            androidx.fragment.app.Fragment r1 = r10.getParentFragment()
            boolean r1 = r1 instanceof com.iaai.android.bdt.feature.landing.quickFilter.QuickLinksFragment
            if (r1 == 0) goto L_0x0021
            androidx.fragment.app.Fragment r0 = r10.getParentFragment()
            if (r0 == 0) goto L_0x0019
            com.iaai.android.bdt.feature.landing.quickFilter.QuickLinksFragment r0 = (com.iaai.android.bdt.feature.landing.quickFilter.QuickLinksFragment) r0
            goto L_0x0021
        L_0x0019:
            kotlin.TypeCastException r11 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type com.iaai.android.bdt.feature.landing.quickFilter.QuickLinksFragment"
            r11.<init>(r0)
            throw r11
        L_0x0021:
            java.lang.String r1 = r11.getType()
            r2 = 1
            java.lang.String r3 = "quicklinks"
            boolean r1 = kotlin.text.StringsKt.equals(r1, r3, r2)
            java.lang.String r3 = "bdtLandingPageActivity"
            if (r1 != 0) goto L_0x008b
            java.lang.String r1 = r11.getType()
            java.lang.String r4 = "sellertype"
            boolean r1 = kotlin.text.StringsKt.equals(r1, r4, r2)
            if (r1 != 0) goto L_0x008b
            java.lang.String r1 = r11.getType()
            java.lang.String r4 = "quicklinks-auction"
            boolean r1 = kotlin.text.StringsKt.equals(r1, r4, r2)
            if (r1 != 0) goto L_0x008b
            java.lang.String r1 = r11.getType()
            java.lang.String r4 = "QuickLinkCategories"
            boolean r1 = kotlin.text.StringsKt.equals(r1, r4, r2)
            if (r1 == 0) goto L_0x0055
            goto L_0x008b
        L_0x0055:
            java.lang.String r0 = r11.getType()
            java.lang.String r1 = "auction"
            boolean r0 = kotlin.text.StringsKt.equals(r0, r1, r2)
            if (r0 != 0) goto L_0x006d
            java.lang.String r0 = r11.getType()
            java.lang.String r1 = "QuickLinkCategories-auction"
            boolean r0 = kotlin.text.StringsKt.equals(r0, r1, r2)
            if (r0 == 0) goto L_0x0185
        L_0x006d:
            android.content.Intent r0 = new android.content.Intent
            com.iaai.android.bdt.feature.landing.BDTLandingPageActivity r1 = r10.bdtLandingPageActivity
            if (r1 != 0) goto L_0x0076
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x0076:
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity> r2 = com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity.class
            r0.<init>(r1, r2)
            java.lang.String r11 = r11.getActualValue()
            java.lang.String r1 = "quick_filter_selected_date"
            r0.putExtra(r1, r11)
            r10.startActivity(r0)
            goto L_0x0185
        L_0x008b:
            boolean r1 = com.iaai.android.IaaiApplication.is_new_fast_Search
            if (r1 == 0) goto L_0x0162
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r11.getType()
            r0.append(r1)
            r1 = 126(0x7e, float:1.77E-43)
            r0.append(r1)
            java.lang.String r1 = r11.getActualValue()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = r11.getActualValue()
            int r4 = r1.hashCode()
            java.lang.String r5 = "Run & Drive"
            java.lang.String r6 = "I-Buy Fast"
            java.lang.String r7 = "I-buy Fast"
            java.lang.String r8 = "Public Vehicles"
            switch(r4) {
                case -676437716: goto L_0x00d8;
                case 1790133918: goto L_0x00cf;
                case 2059642586: goto L_0x00c6;
                case 2124286714: goto L_0x00bf;
                default: goto L_0x00be;
            }
        L_0x00be:
            goto L_0x00e2
        L_0x00bf:
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x00e2
            goto L_0x00cc
        L_0x00c6:
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x00e2
        L_0x00cc:
            java.lang.String r1 = "Buy Now"
            goto L_0x00e6
        L_0x00cf:
            boolean r1 = r1.equals(r8)
            if (r1 == 0) goto L_0x00e2
            java.lang.String r1 = "Available to Public"
            goto L_0x00e6
        L_0x00d8:
            java.lang.String r4 = "Run & Drive Vehicles"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x00e2
            r1 = r5
            goto L_0x00e6
        L_0x00e2:
            java.lang.String r1 = r11.getActualValue()
        L_0x00e6:
            java.lang.String r11 = r11.getActualValue()
            int r4 = r11.hashCode()
            r9 = 0
            switch(r4) {
                case 488295483: goto L_0x0105;
                case 1790133918: goto L_0x00fd;
                case 2059642586: goto L_0x00f8;
                case 2124286714: goto L_0x00f3;
                default: goto L_0x00f2;
            }
        L_0x00f2:
            goto L_0x010d
        L_0x00f3:
            boolean r11 = r11.equals(r6)
            goto L_0x010d
        L_0x00f8:
            boolean r11 = r11.equals(r7)
            goto L_0x010d
        L_0x00fd:
            boolean r11 = r11.equals(r8)
            if (r11 == 0) goto L_0x010d
            r11 = 6
            goto L_0x010e
        L_0x0105:
            boolean r11 = r11.equals(r5)
            if (r11 == 0) goto L_0x010d
            r11 = 1
            goto L_0x010e
        L_0x010d:
            r11 = 0
        L_0x010e:
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r4 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX
            com.iaai.android.bdt.utils.BDTUtils r5 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            com.iaai.android.bdt.feature.landing.BDTLandingPageActivity r6 = r10.bdtLandingPageActivity
            if (r6 != 0) goto L_0x0119
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x0119:
            android.content.res.Resources r6 = r6.getResources()
            java.lang.String r7 = "bdtLandingPageActivity.resources"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r7)
            java.lang.String r1 = r5.showDisplayNameForPopularRefiner(r1, r6)
            r4.<init>(r9, r1, r0, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r0.add(r4)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel r4 = new com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel
            r5 = 2
            r4.<init>(r5, r9, r11)
            r1.add(r4)
            android.content.Intent r11 = new android.content.Intent
            com.iaai.android.bdt.feature.landing.BDTLandingPageActivity r4 = r10.bdtLandingPageActivity
            if (r4 != 0) goto L_0x0148
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x0148:
            android.content.Context r4 = (android.content.Context) r4
            java.lang.Class<com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity> r3 = com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity.class
            r11.<init>(r4, r3)
            java.lang.String r3 = "extra_selected_facets"
            r11.putParcelableArrayListExtra(r3, r0)
            java.lang.String r0 = "extra_selected_indices"
            r11.putParcelableArrayListExtra(r0, r1)
            java.lang.String r0 = "landing_page_search"
            r11.putExtra(r0, r2)
            r10.startActivity(r11)
            goto L_0x0185
        L_0x0162:
            if (r0 == 0) goto L_0x016b
            com.iaai.android.bdt.model.quickFilter.QuickFilterResponse r0 = r0.mapSelectedRefiner(r11)
            if (r0 == 0) goto L_0x016b
            r11 = r0
        L_0x016b:
            android.content.Intent r0 = new android.content.Intent
            com.iaai.android.bdt.feature.landing.BDTLandingPageActivity r1 = r10.bdtLandingPageActivity
            if (r1 != 0) goto L_0x0174
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x0174:
            android.content.Context r1 = (android.content.Context) r1
            java.lang.Class<com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity> r2 = com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity.class
            r0.<init>(r1, r2)
            android.os.Parcelable r11 = (android.os.Parcelable) r11
            java.lang.String r1 = "quick_filter_selected_value"
            r0.putExtra(r1, r11)
            r10.startActivity(r0)
        L_0x0185:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.landing.quickFilter.SearchByVehicleFragment.onItemClick(com.iaai.android.bdt.model.quickFilter.QuickFilterResponse):void");
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
            quickFilterAdapter3.setQuickFilterType(QuickFilterAdapter.Companion.QuickFilterType.VEHICLE_QUICK_FILTER);
            QuickFilterAdapter quickFilterAdapter4 = this.quickFilterAdapter;
            if (quickFilterAdapter4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quickFilterAdapter");
            }
            quickFilterAdapter4.setClickListener(this);
            QuickFilterAdapter quickFilterAdapter5 = this.quickFilterAdapter;
            if (quickFilterAdapter5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("quickFilterAdapter");
            }
            quickFilterAdapter5.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void showSavedSearchedUI(int i) {
        if (i > 0) {
            SessionManager sessionManager2 = this.sessionManager;
            if (sessionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            if (sessionManager2.isLoggedIn()) {
                ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.clSavedSearch);
                Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "clSavedSearch");
                constraintLayout.setVisibility(0);
                return;
            }
        }
        ConstraintLayout constraintLayout2 = (ConstraintLayout) _$_findCachedViewById(C2723R.C2726id.clSavedSearch);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout2, "clSavedSearch");
        constraintLayout2.setVisibility(8);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/landing/quickFilter/SearchByVehicleFragment$Companion;", "", "()V", "newInstance", "Lcom/iaai/android/bdt/feature/landing/quickFilter/SearchByVehicleFragment;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SearchByVehicleFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SearchByVehicleFragment newInstance() {
            return new SearchByVehicleFragment();
        }
    }

    private final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbSearchByVF);
            if (progressBar != null) {
                progressBar.setVisibility(0);
                return;
            }
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbSearchByVF);
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 106 && intent != null) {
            Bundle extras = intent.getExtras();
            String string = extras != null ? extras.getString(Constants_MVVM.EXTRA_SAVED_SEARCH_PARAM) : null;
            BDTLandingPageActivity bDTLandingPageActivity = this.bdtLandingPageActivity;
            if (bDTLandingPageActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtLandingPageActivity");
            }
            Intent intent2 = new Intent(bDTLandingPageActivity, RefinerResultActivity.class);
            intent2.putExtra(Constants_MVVM.EXTRA_SAVED_SEARCH_PARAM, string);
            intent2.putExtra(Constants_MVVM.EXTRA_IS_FROM_SAVED_SEARCH, true);
            intent2.putExtra(Constants_MVVM.EXTRA_IS_FROM_LANDING_PAGE_SEARCH, true);
            startActivity(intent2);
        }
    }
}
