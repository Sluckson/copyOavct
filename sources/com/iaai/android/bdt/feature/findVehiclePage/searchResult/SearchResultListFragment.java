package com.iaai.android.bdt.feature.findVehiclePage.searchResult;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.findVehiclePage.SearchPanelFindVehicleActivity;
import com.iaai.android.bdt.feature.findVehiclePage.filter.HeaderListAdapter;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.productDetail.ProductDetailActivity;
import com.iaai.android.bdt.feature.viewPager.FastSearchViewModel;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader;
import com.iaai.android.bdt.model.fastSearch.RequestSelectedRefiner;
import com.iaai.android.bdt.model.fastSearch.SearchInputV2;
import com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2;
import com.iaai.android.bdt.model.fastSearch.SortRule;
import com.iaai.android.bdt.model.fastSearch.Vehicle;
import com.iaai.android.bdt.model.profile.UpdateWatchListResponse;
import com.iaai.android.bdt.model.quickFilter.QuickFilterResponse;
import com.iaai.android.bdt.model.sort.SortOptionData;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.old.managers.CurrentLocationManager;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.pdf.PdfBoolean;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0004\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010W\u001a\u00020X2\u0006\u0010Y\u001a\u00020\u0005H\u0002J\b\u0010Z\u001a\u00020XH\u0002J\u0010\u0010[\u001a\u00020X2\u0006\u0010\\\u001a\u00020\u0007H\u0002J\b\u0010]\u001a\u00020XH\u0002J \u0010^\u001a\u00020K2\u0006\u0010_\u001a\u00020\u00052\u0006\u0010`\u001a\u00020\u00072\u0006\u0010a\u001a\u00020\u0019H\u0002J\u0010\u0010b\u001a\u00020X2\u0006\u0010c\u001a\u00020\u0011H\u0002J\u0015\u0010d\u001a\u00020X2\u0006\u0010e\u001a\u00020fH\u0000¢\u0006\u0002\bgJ\r\u0010h\u001a\u00020XH\u0000¢\u0006\u0002\biJ\b\u0010j\u001a\u00020XH\u0002J\u0010\u0010k\u001a\u00020X2\u0006\u00100\u001a\u000201H\u0002J\b\u0010l\u001a\u000201H\u0002J\u001a\u0010m\u001a\u00020X2\b\u0010n\u001a\u0004\u0018\u00010o2\u0006\u0010`\u001a\u00020\u0007H\u0002J\u001a\u0010p\u001a\u00020X2\b\u0010n\u001a\u0004\u0018\u00010o2\u0006\u0010`\u001a\u00020\u0007H\u0002J\b\u0010q\u001a\u00020XH\u0002J\u0012\u0010r\u001a\u00020X2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\"\u0010u\u001a\u00020X2\u0006\u0010v\u001a\u00020\u00072\u0006\u0010w\u001a\u00020\u00072\b\u0010n\u001a\u0004\u0018\u00010xH\u0016J\u0010\u0010y\u001a\u00020X2\u0006\u0010z\u001a\u00020{H\u0016J\u0012\u0010|\u001a\u00020X2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J(\u0010}\u001a\u0004\u0018\u00010:2\u0006\u0010~\u001a\u000202\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\u0019\u0010\u0001\u001a\u00020X2\u0006\u0010c\u001a\u00020\u00112\u0006\u0010`\u001a\u00020\u0007H\u0016J\t\u0010\u0001\u001a\u00020XH\u0016J\t\u0010\u0001\u001a\u00020XH\u0016J\u0011\u0010\u0001\u001a\u00020X2\u0006\u0010\\\u001a\u00020\u0007H\u0002J\t\u0010\u0001\u001a\u00020XH\u0002J\t\u0010\u0001\u001a\u00020XH\u0002J\t\u0010\u0001\u001a\u00020XH\u0002J\t\u0010\u0001\u001a\u00020XH\u0002J\u0012\u0010\u0001\u001a\u00020X2\u0007\u0010\u0001\u001a\u00020\u0019H\u0002J\t\u0010\u0001\u001a\u00020XH\u0002J0\u0010\u0001\u001a\u00020X2%\u0010\u0001\u001a \u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u0001j\u000f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0011`\u0001H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00060\tR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001b\"\u0004\b\"\u0010\u001dR\u000e\u0010#\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u00100\u001a\u000201X.¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u000e\u00106\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X.¢\u0006\u0002\n\u0000R\u001c\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u000e\u0010?\u001a\u00020@X.¢\u0006\u0002\n\u0000R*\u0010A\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0014\"\u0004\bC\u0010\u0016R\u001e\u0010D\u001a\u00020E8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u0010\u0010J\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX.¢\u0006\u0002\n\u0000R\u001e\u0010Q\u001a\u00020R8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010T\"\u0004\bU\u0010V¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultListFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "Lcom/iaai/android/bdt/feature/findVehiclePage/filter/HeaderListAdapter$OnHeaderItemClickListener;", "()V", "action", "", "currentCount", "", "currentLocationBroadcastReceiver", "Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultListFragment$CurrentLocationBroadcastReceiver;", "currentLocationManager", "Lcom/iaai/android/old/managers/CurrentLocationManager;", "errorType", "Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "groupPostion", "hashMapMakeModelArray", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/fastSearch/SelectedRefinerV2;", "Lkotlin/collections/ArrayList;", "getHashMapMakeModelArray", "()Ljava/util/ArrayList;", "setHashMapMakeModelArray", "(Ljava/util/ArrayList;)V", "indexToUpdate", "isError", "", "isFristTime", "()Z", "setFristTime", "(Z)V", "isFromFindVehiclePage", "isLoggedIn", "isSingleSearchProductDeatil", "isTablet", "setTablet", "itemIdWatch", "lastSelectedSort", "latitude", "longitude", "makeModelGroupPosition", "getMakeModelGroupPosition", "()I", "setMakeModelGroupPosition", "(I)V", "nextWeek", "quickFilter", "Lcom/iaai/android/bdt/model/quickFilter/QuickFilterResponse;", "refinerJSON", "searchInput", "Lcom/iaai/android/bdt/model/fastSearch/SearchInputV2;", "getSearchInput", "()Lcom/iaai/android/bdt/model/fastSearch/SearchInputV2;", "setSearchInput", "(Lcom/iaai/android/bdt/model/fastSearch/SearchInputV2;)V", "searchInputKey", "searchResultActivity", "Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultActivity;", "searchResultView", "Landroid/view/View;", "getSearchResultView", "()Landroid/view/View;", "setSearchResultView", "(Landroid/view/View;)V", "searchReultListAdapter", "Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchReultListAdapter;", "selectedRefinerList", "getSelectedRefinerList", "setSelectedRefinerList", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "sortOptionData", "Lcom/iaai/android/bdt/model/sort/SortOptionData;", "thisWeek", "totalCount", "userId", "viewModel", "Lcom/iaai/android/bdt/feature/viewPager/FastSearchViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "addHeaderToAuctionSalesList", "", "errorMessage", "addSearchRefiner", "addToWatchList", "itemId", "checkNetworkConnection", "createSortOptionData", "displayText", "position", "isSelected", "findMakeModelAndRemove", "clickedItem", "handleCurrentLocationBroadcastResult", "location", "Landroid/location/Location;", "handleCurrentLocationBroadcastResult$app_productionRelease", "handleCurrentLocationNotAvailable", "handleCurrentLocationNotAvailable$app_productionRelease", "initializeRecycler", "loadFastSearchListV2", "makeRequestBody", "navigateToProductDetailsPage", "data", "Lcom/iaai/android/bdt/model/fastSearch/Vehicle;", "navigateToProductDetailsPageForSingle", "navigateToSearchPanelActivity", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onItemClick", "onResume", "onStart", "removeFromWatchList", "removeRefinerSearch", "requestCurrentLocationData", "setSelectedRefinerPreference", "setToolBarTitle", "showLoadingIndicator", "loading", "subscribeToViewModel", "updateSelectedRefinerHashMap", "selectedRefinerHashMap", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "Companion", "CurrentLocationBroadcastReceiver", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchResultListFragment.kt */
public final class SearchResultListFragment extends BaseFragment implements HeaderListAdapter.OnHeaderItemClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SAMPLE = "sample";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public String action = "";
    /* access modifiers changed from: private */
    public int currentCount;
    private CurrentLocationBroadcastReceiver currentLocationBroadcastReceiver;
    private CurrentLocationManager currentLocationManager;
    /* access modifiers changed from: private */
    public BaseFragment.ErrorType errorType;
    /* access modifiers changed from: private */
    public int groupPostion;
    @NotNull
    private ArrayList<SelectedRefinerV2> hashMapMakeModelArray = new ArrayList<>();
    /* access modifiers changed from: private */
    public int indexToUpdate;
    /* access modifiers changed from: private */
    public boolean isError;
    private boolean isFristTime = true;
    /* access modifiers changed from: private */
    public boolean isFromFindVehiclePage;
    /* access modifiers changed from: private */
    public boolean isLoggedIn;
    /* access modifiers changed from: private */
    public boolean isSingleSearchProductDeatil;
    private boolean isTablet;
    /* access modifiers changed from: private */
    public int itemIdWatch;
    /* access modifiers changed from: private */
    public int lastSelectedSort = 1;
    private int latitude;
    private int longitude;
    private int makeModelGroupPosition = -1;
    private String nextWeek = "";
    private QuickFilterResponse quickFilter;
    private String refinerJSON = "";
    @NotNull
    public SearchInputV2 searchInput;
    /* access modifiers changed from: private */
    public String searchInputKey = "";
    /* access modifiers changed from: private */
    public SearchResultActivity searchResultActivity;
    @Nullable
    private View searchResultView;
    /* access modifiers changed from: private */
    public SearchReultListAdapter searchReultListAdapter;
    @NotNull
    private ArrayList<SelectedRefinerV2> selectedRefinerList = new ArrayList<>();
    @Inject
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public SortOptionData sortOptionData;
    private String thisWeek = "";
    /* access modifiers changed from: private */
    public int totalCount;
    private String userId = "";
    /* access modifiers changed from: private */
    public FastSearchViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;

    @JvmStatic
    @NotNull
    public static final SearchResultListFragment newInstance(@NotNull String str) {
        return Companion.newInstance(str);
    }

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

    public static final /* synthetic */ BaseFragment.ErrorType access$getErrorType$p(SearchResultListFragment searchResultListFragment) {
        BaseFragment.ErrorType errorType2 = searchResultListFragment.errorType;
        if (errorType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorType");
        }
        return errorType2;
    }

    public static final /* synthetic */ SearchResultActivity access$getSearchResultActivity$p(SearchResultListFragment searchResultListFragment) {
        SearchResultActivity searchResultActivity2 = searchResultListFragment.searchResultActivity;
        if (searchResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        return searchResultActivity2;
    }

    public static final /* synthetic */ SearchReultListAdapter access$getSearchReultListAdapter$p(SearchResultListFragment searchResultListFragment) {
        SearchReultListAdapter searchReultListAdapter2 = searchResultListFragment.searchReultListAdapter;
        if (searchReultListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchReultListAdapter");
        }
        return searchReultListAdapter2;
    }

    public static final /* synthetic */ FastSearchViewModel access$getViewModel$p(SearchResultListFragment searchResultListFragment) {
        FastSearchViewModel fastSearchViewModel = searchResultListFragment.viewModel;
        if (fastSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return fastSearchViewModel;
    }

    public final boolean isFristTime() {
        return this.isFristTime;
    }

    public final void setFristTime(boolean z) {
        this.isFristTime = z;
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

    public final boolean isTablet() {
        return this.isTablet;
    }

    public final void setTablet(boolean z) {
        this.isTablet = z;
    }

    @Nullable
    public final View getSearchResultView() {
        return this.searchResultView;
    }

    public final void setSearchResultView(@Nullable View view) {
        this.searchResultView = view;
    }

    @NotNull
    public final SearchInputV2 getSearchInput() {
        SearchInputV2 searchInputV2 = this.searchInput;
        if (searchInputV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchInput");
        }
        return searchInputV2;
    }

    public final void setSearchInput(@NotNull SearchInputV2 searchInputV2) {
        Intrinsics.checkParameterIsNotNull(searchInputV2, "<set-?>");
        this.searchInput = searchInputV2;
    }

    @NotNull
    public final ArrayList<SelectedRefinerV2> getSelectedRefinerList() {
        return this.selectedRefinerList;
    }

    public final void setSelectedRefinerList(@NotNull ArrayList<SelectedRefinerV2> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.selectedRefinerList = arrayList;
    }

    @NotNull
    public final ArrayList<SelectedRefinerV2> getHashMapMakeModelArray() {
        return this.hashMapMakeModelArray;
    }

    public final void setHashMapMakeModelArray(@NotNull ArrayList<SelectedRefinerV2> arrayList) {
        Intrinsics.checkParameterIsNotNull(arrayList, "<set-?>");
        this.hashMapMakeModelArray = arrayList;
    }

    public final int getMakeModelGroupPosition() {
        return this.makeModelGroupPosition;
    }

    public final void setMakeModelGroupPosition(int i) {
        this.makeModelGroupPosition = i;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultListFragment$Companion;", "", "()V", "KEY_SAMPLE", "", "newInstance", "Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultListFragment;", "url", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SearchResultListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final SearchResultListFragment newInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            SearchResultListFragment searchResultListFragment = new SearchResultListFragment();
            Bundle bundle = new Bundle();
            bundle.putString(SearchResultListFragment.KEY_SAMPLE, str);
            searchResultListFragment.setArguments(bundle);
            return searchResultListFragment;
        }
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.searchResultActivity = (SearchResultActivity) activity;
            if (context instanceof SearchResultActivity) {
                this.searchResultActivity = (SearchResultActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        SearchResultActivity searchResultActivity2 = this.searchResultActivity;
        if (searchResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        FragmentActivity fragmentActivity = searchResultActivity2;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(FastSearchViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(se…rchViewModel::class.java)");
        this.viewModel = (FastSearchViewModel) viewModel2;
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application != null) {
            Object instance = ((IaaiApplication) application).getInjector().getInstance(CurrentLocationManager.class);
            Intrinsics.checkExpressionValueIsNotNull(instance, "injector.getInstance(Cur…ationManager::class.java)");
            this.currentLocationManager = (CurrentLocationManager) instance;
            this.currentLocationBroadcastReceiver = new CurrentLocationBroadcastReceiver();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.IaaiApplication");
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        SearchResultActivity searchResultActivity2 = this.searchResultActivity;
        if (searchResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        this.isTablet = searchResultActivity2.getResources().getBoolean(C2723R.bool.isTabletPhone);
        if (this.searchResultView == null) {
            if (this.isTablet) {
                ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.activity_auction_sales_list_land, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "mBinding");
                this.searchResultView = inflate.getRoot();
            } else {
                ViewDataBinding inflate2 = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.activity_auction_sales_list, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate2, "mBinding");
                this.searchResultView = inflate2.getRoot();
            }
        }
        return this.searchResultView;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        String str;
        String displayValue;
        QuickFilterResponse quickFilterResponse;
        super.onActivityCreated(bundle);
        SearchResultActivity searchResultActivity2 = this.searchResultActivity;
        if (searchResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        ImageView imageView = (ImageView) searchResultActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "searchResultActivity.arrow_left");
        imageView.setVisibility(8);
        SearchResultActivity searchResultActivity3 = this.searchResultActivity;
        if (searchResultActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        ImageView imageView2 = (ImageView) searchResultActivity3._$_findCachedViewById(C2723R.C2726id.arrow_right);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "searchResultActivity.arrow_right");
        imageView2.setVisibility(8);
        SearchResultActivity searchResultActivity4 = this.searchResultActivity;
        if (searchResultActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        RelativeLayout relativeLayout = (RelativeLayout) searchResultActivity4._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "searchResultActivity.toolbar_relativelayout");
        relativeLayout.setGravity(GravityCompat.START);
        SearchResultActivity searchResultActivity5 = this.searchResultActivity;
        if (searchResultActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) searchResultActivity5._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "searchResultActivity.toolbar_relativelayout");
        relativeLayout2.setGravity(3);
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        String string = arguments.getString(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY);
        String str2 = "";
        if (string == null) {
            string = str2;
        }
        this.searchInputKey = string;
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            Intrinsics.throwNpe();
        }
        this.isFromFindVehiclePage = arguments2.getBoolean(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE);
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            Intrinsics.throwNpe();
        }
        this.quickFilter = (QuickFilterResponse) arguments3.getParcelable(Constants_MVVM.EXTRA_QUICK_FILTER_SELECTED_VALUE);
        SearchResultActivity searchResultActivity6 = this.searchResultActivity;
        if (searchResultActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        Application application = searchResultActivity6.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "searchResultActivity.application");
        Boolean isLoggedInPreferencesMVVM = IAASharedPreference.getIsLoggedInPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(isLoggedInPreferencesMVVM, "IAASharedPreference.getI…ation.applicationContext)");
        this.isLoggedIn = isLoggedInPreferencesMVVM.booleanValue();
        SearchResultActivity searchResultActivity7 = this.searchResultActivity;
        if (searchResultActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        Application application2 = searchResultActivity7.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application2, "searchResultActivity.application");
        String userIdPreferencesMVVM = IAASharedPreference.getUserIdPreferencesMVVM(application2.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM, "IAASharedPreference.getU…ation.applicationContext)");
        this.userId = userIdPreferencesMVVM;
        Bundle arguments4 = getArguments();
        if (arguments4 == null) {
            Intrinsics.throwNpe();
        }
        if (arguments4.containsKey(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA)) {
            Collection collection = this.selectedRefinerList;
            if (collection == null || collection.isEmpty()) {
                Bundle arguments5 = getArguments();
                if (arguments5 == null) {
                    Intrinsics.throwNpe();
                }
                ArrayList<SelectedRefinerV2> parcelableArrayList = arguments5.getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA);
                if (parcelableArrayList != null) {
                    this.selectedRefinerList = parcelableArrayList;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> /* = java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> */");
                }
            }
        }
        Bundle arguments6 = getArguments();
        if (arguments6 == null) {
            Intrinsics.throwNpe();
        }
        if (arguments6.containsKey(Constants_MVVM.EXTRA_SELECTED_MAKE_MODEL_DATA)) {
            Bundle arguments7 = getArguments();
            if (arguments7 == null) {
                Intrinsics.throwNpe();
            }
            ArrayList<SelectedRefinerV2> parcelableArrayList2 = arguments7.getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_MAKE_MODEL_DATA);
            if (parcelableArrayList2 != null) {
                this.hashMapMakeModelArray = parcelableArrayList2;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> /* = java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> */");
            }
        }
        Bundle arguments8 = getArguments();
        if (arguments8 == null) {
            Intrinsics.throwNpe();
        }
        if (arguments8.containsKey(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION)) {
            Bundle arguments9 = getArguments();
            if (arguments9 == null) {
                Intrinsics.throwNpe();
            }
            this.groupPostion = arguments9.getInt(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION);
        }
        Bundle arguments10 = getArguments();
        if (arguments10 == null) {
            Intrinsics.throwNpe();
        }
        if (arguments10.containsKey(Constants_MVVM.EXTRA_THIS_WEEK)) {
            Bundle arguments11 = getArguments();
            if (arguments11 == null) {
                Intrinsics.throwNpe();
            }
            String string2 = arguments11.getString(Constants_MVVM.EXTRA_THIS_WEEK);
            if (string2 == null) {
                string2 = str2;
            }
            this.thisWeek = string2;
        }
        Bundle arguments12 = getArguments();
        if (arguments12 == null) {
            Intrinsics.throwNpe();
        }
        if (arguments12.containsKey(Constants_MVVM.EXTRA_NEXT_WEEK)) {
            Bundle arguments13 = getArguments();
            if (arguments13 == null) {
                Intrinsics.throwNpe();
            }
            String string3 = arguments13.getString(Constants_MVVM.EXTRA_NEXT_WEEK);
            if (string3 == null) {
                string3 = str2;
            }
            this.nextWeek = string3;
        }
        QuickFilterResponse quickFilterResponse2 = this.quickFilter;
        if (quickFilterResponse2 != null) {
            String str3 = null;
            if (!StringsKt.equals(quickFilterResponse2 != null ? quickFilterResponse2.getType() : null, "quicklinks-auction", true) && (quickFilterResponse = this.quickFilter) != null) {
                String type = quickFilterResponse.getType();
            }
            ArrayList arrayList = new ArrayList();
            QuickFilterResponse quickFilterResponse3 = this.quickFilter;
            if (quickFilterResponse3 != null) {
                str3 = quickFilterResponse3.getActualValue();
            }
            if (!StringsKt.equals(str3, getString(C2723R.string.bdt_lbl_quick_browse_all_vehicles), true)) {
                QuickFilterResponse quickFilterResponse4 = this.quickFilter;
                if (quickFilterResponse4 == null || (str = quickFilterResponse4.getActualValue()) == null) {
                    str = str2;
                }
                arrayList.add(str);
                QuickFilterResponse quickFilterResponse5 = this.quickFilter;
                if (!(quickFilterResponse5 == null || (displayValue = quickFilterResponse5.getDisplayValue()) == null)) {
                    str2 = displayValue;
                }
                this.selectedRefinerList.add(new SelectedRefinerV2(str2, arrayList, true));
            }
        }
        if (this.isTablet) {
            SearchResultActivity searchResultActivity8 = this.searchResultActivity;
            if (searchResultActivity8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
            }
            NavController findNavController = Navigation.findNavController(searchResultActivity8, C2723R.C2726id.auction_sales_nav_container);
            Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…tion_sales_nav_container)");
            NavInflater navInflater = findNavController.getNavInflater();
            Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
            NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.navigation_graph_auction_saleslist);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.na…_graph_auction_saleslist)");
            NavArgument build = new NavArgument.Builder().setDefaultValue("34567845").build();
            Intrinsics.checkExpressionValueIsNotNull(build, "NavArgument.Builder().se…aultValue(itemId).build()");
            inflate.addArgument(Constants.EXTRA_ITEM_ID, build);
            findNavController.setGraph(inflate);
        }
        if (this.isFristTime) {
            initializeRecycler();
            checkNetworkConnection();
        }
    }

    public void onStart() {
        super.onStart();
        if (isAdded() && !this.isSingleSearchProductDeatil) {
            Boolean watchStatus = IAASharedPreference.getWatchStatus(getActivity());
            Intrinsics.checkExpressionValueIsNotNull(watchStatus, "IAASharedPreference.getWatchStatus(activity)");
            if (watchStatus.booleanValue()) {
                initializeRecycler();
                checkNetworkConnection();
                IAASharedPreference.setWatchStatus(getActivity(), false);
            }
        }
    }

    private final void updateSelectedRefinerHashMap(LinkedHashMap<String, SelectedRefinerV2> linkedHashMap) {
        linkedHashMap.clear();
        for (SelectedRefinerV2 selectedRefinerV2 : this.selectedRefinerList) {
            if (!StringsKt.equals(selectedRefinerV2.getRefinerTypeValue(), "make", true) && !StringsKt.equals(selectedRefinerV2.getRefinerTypeValue(), "model", true)) {
                linkedHashMap.put(selectedRefinerV2.getRefinerTypeValue(), selectedRefinerV2);
            }
        }
        if (!this.hashMapMakeModelArray.isEmpty()) {
            for (SelectedRefinerV2 selectedRefinerV22 : this.hashMapMakeModelArray) {
                linkedHashMap.put(selectedRefinerV22.getRefinerTypeValue(), selectedRefinerV22);
            }
        }
    }

    private final void initializeRecycler() {
        this.isFristTime = false;
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.ed_search_result);
        Intrinsics.checkExpressionValueIsNotNull(textView, "ed_search_result");
        textView.setText(this.searchInputKey);
        if (this.searchInputKey.length() > 0) {
            ImageButton imageButton = (ImageButton) _$_findCachedViewById(C2723R.C2726id.img_voice_text);
            Intrinsics.checkExpressionValueIsNotNull(imageButton, "img_voice_text");
            imageButton.setVisibility(8);
            ImageButton imageButton2 = (ImageButton) _$_findCachedViewById(C2723R.C2726id.img_clear_text);
            Intrinsics.checkExpressionValueIsNotNull(imageButton2, "img_clear_text");
            imageButton2.setVisibility(0);
        } else {
            ImageButton imageButton3 = (ImageButton) _$_findCachedViewById(C2723R.C2726id.img_voice_text);
            Intrinsics.checkExpressionValueIsNotNull(imageButton3, "img_voice_text");
            imageButton3.setVisibility(0);
            ImageButton imageButton4 = (ImageButton) _$_findCachedViewById(C2723R.C2726id.img_clear_text);
            Intrinsics.checkExpressionValueIsNotNull(imageButton4, "img_clear_text");
            imageButton4.setVisibility(8);
        }
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.cl_search_container);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "cl_search_container");
        relativeLayout.setVisibility(0);
        View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.vw_separtor_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "vw_separtor_toolbar");
        _$_findCachedViewById.setVisibility(8);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.cl_search_container)).setOnClickListener(new SearchResultListFragment$initializeRecycler$1(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.img_clear_text)).setOnClickListener(new SearchResultListFragment$initializeRecycler$2(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.img_voice_text)).setOnClickListener(new SearchResultListFragment$initializeRecycler$3(this));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        SearchResultActivity searchResultActivity2 = this.searchResultActivity;
        if (searchResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        WindowManager windowManager = searchResultActivity2.getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(windowManager, "searchResultActivity.windowManager");
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        SearchResultActivity searchResultActivity3 = this.searchResultActivity;
        if (searchResultActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionSales)).addItemDecoration(new DividerItemDecoration(searchResultActivity3, 1));
        FastSearchViewModel fastSearchViewModel = this.viewModel;
        if (fastSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "activity!!.applicationContext");
        this.searchReultListAdapter = new SearchReultListAdapter(fastSearchViewModel, applicationContext, new SearchResultListFragment$initializeRecycler$4(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionSales);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvAuctionSales");
        SearchReultListAdapter searchReultListAdapter2 = this.searchReultListAdapter;
        if (searchReultListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchReultListAdapter");
        }
        recyclerView.setAdapter(searchReultListAdapter2);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionSales);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvAuctionSales");
        SearchResultActivity searchResultActivity4 = this.searchResultActivity;
        if (searchResultActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(searchResultActivity4));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionSales)).addOnScrollListener(new SearchResultListFragment$initializeRecycler$5(this));
        ((FloatingActionButton) _$_findCachedViewById(C2723R.C2726id.fab)).setOnClickListener(new SearchResultListFragment$initializeRecycler$6(this));
        SearchReultListAdapter searchReultListAdapter3 = this.searchReultListAdapter;
        if (searchReultListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchReultListAdapter");
        }
        searchReultListAdapter3.setDeviceWidth(i);
    }

    /* access modifiers changed from: private */
    public final void navigateToSearchPanelActivity() {
        Intent intent = new Intent(getActivity(), SearchPanelFindVehicleActivity.class);
        intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SELECTED_FILTER_DATA, this.selectedRefinerList);
        intent.putExtra(Constants_MVVM.EXTRA_MAKE_MODEL_GROUP_POSITION, this.makeModelGroupPosition);
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_BY_VEHICLE, true);
        intent.putExtra(Constants_MVVM.EXTRA_IS_FILTERPAGE, true);
        intent.putExtra(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE, this.isFromFindVehiclePage);
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, this.searchInputKey);
        startActivityForResult(intent, 104);
    }

    /* access modifiers changed from: private */
    public final void addToWatchList(int i) {
        SearchResultActivity searchResultActivity2 = this.searchResultActivity;
        if (searchResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        Application application = searchResultActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "searchResultActivity.application");
        String userIdPreferencesMVVM = IAASharedPreference.getUserIdPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM, "IAASharedPreference.getU…ation.applicationContext)");
        this.userId = userIdPreferencesMVVM;
        String string = getResources().getString(C2723R.string.lbl_watch_action_add);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.lbl_watch_action_add)");
        this.action = string;
        FastSearchViewModel fastSearchViewModel = this.viewModel;
        if (fastSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
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
        fastSearchViewModel.updateWatchStatus(format, String.valueOf(i), this.userId, this.action);
    }

    /* access modifiers changed from: private */
    public final void removeFromWatchList(int i) {
        String string = getResources().getString(C2723R.string.lbl_watch_action_delete);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st….lbl_watch_action_delete)");
        this.action = string;
        FastSearchViewModel fastSearchViewModel = this.viewModel;
        if (fastSearchViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
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
        fastSearchViewModel.updateWatchStatus(format, String.valueOf(i), this.userId, this.action);
    }

    /* access modifiers changed from: private */
    public final void navigateToProductDetailsPageForSingle(Vehicle vehicle, int i) {
        PagedList<Vehicle> currentList;
        String str = null;
        if (this.isTablet) {
            String valueOf = String.valueOf(vehicle != null ? Integer.valueOf(vehicle.getItemId()) : null);
            StringBuilder sb = new StringBuilder();
            sb.append(vehicle != null ? vehicle.getYear() : null);
            sb.append(' ');
            sb.append(vehicle != null ? vehicle.getMake() : null);
            sb.append(' ');
            if (vehicle != null) {
                str = vehicle.getModel();
            }
            sb.append(str);
            sb.append(' ');
            String sb2 = sb.toString();
            SearchResultActivity searchResultActivity2 = this.searchResultActivity;
            if (searchResultActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
            }
            Intent intent = new Intent(searchResultActivity2, ProductDetailActivity.class);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra(Constants.EXTRA_ITEM_ID, valueOf);
            intent.putExtra("isFromSearchVehicle", false);
            intent.putExtra(Constants.EXTRA_YEAR_MAKE_MODEL, sb2);
            startActivity(intent);
            return;
        }
        String valueOf2 = String.valueOf(vehicle != null ? Integer.valueOf(vehicle.getItemId()) : null);
        ArrayList arrayList = new ArrayList();
        if (this.isSingleSearchProductDeatil) {
            arrayList.add(valueOf2);
        } else {
            SearchReultListAdapter searchReultListAdapter2 = this.searchReultListAdapter;
            if (searchReultListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchReultListAdapter");
            }
            if (!(searchReultListAdapter2 == null || (currentList = searchReultListAdapter2.getCurrentList()) == null)) {
                for (Vehicle itemId : currentList) {
                    arrayList.add(String.valueOf(itemId.getItemId()));
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_ITEM_ID, String.valueOf(vehicle != null ? Integer.valueOf(vehicle.getItemId()) : null));
        bundle.putStringArrayList(Constants_MVVM.EXTRA_ITEM_IDS_LIST, arrayList);
        bundle.putInt(Constants_MVVM.EXTRA_ITEM_POSITION, i);
        bundle.putString(Constants_MVVM.EXTRA_AUCTION_DATE, vehicle != null ? vehicle.getLiveDate() : null);
        bundle.putString(Constants_MVVM.EXTRA_BRANCH_ID, vehicle != null ? vehicle.getBranchnumber() : null);
        bundle.putInt(Constants_MVVM.EXTRA_CURRENT_COUNT, this.currentCount);
        bundle.putInt(Constants_MVVM.EXTRA_TOTAL_COUNT, this.totalCount);
        bundle.putInt(Constants_MVVM.EXTRA_ITEM_POSITION, i);
        Gson gson = new Gson();
        SearchInputV2 searchInputV2 = this.searchInput;
        if (searchInputV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchInput");
        }
        bundle.putString(Constants_MVVM.EXTRA_FAST_SEARCH_PARAM, gson.toJson((Object) searchInputV2));
        SearchResultActivity searchResultActivity3 = this.searchResultActivity;
        if (searchResultActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        NavController findNavController = Navigation.findNavController(searchResultActivity3, C2723R.C2726id.main_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
        NavDestination currentDestination = findNavController.getCurrentDestination();
        if (currentDestination != null && currentDestination.getId() == C2723R.C2726id.SearchResultListFragment) {
            findNavController.navigate((int) C2723R.C2726id.action_ACFragment_to_View_Pager_PDFragment, bundle);
        }
        if (this.totalCount > 1) {
            SearchResultActivity searchResultActivity4 = this.searchResultActivity;
            if (searchResultActivity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
            }
            RelativeLayout relativeLayout = (RelativeLayout) searchResultActivity4._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "searchResultActivity.toolbar_relativelayout");
            relativeLayout.setGravity(GravityCompat.END);
            SearchResultActivity searchResultActivity5 = this.searchResultActivity;
            if (searchResultActivity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) searchResultActivity5._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "searchResultActivity.toolbar_relativelayout");
            relativeLayout2.setGravity(5);
            SearchResultActivity searchResultActivity6 = this.searchResultActivity;
            if (searchResultActivity6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
            }
            TextView toolbar_title = searchResultActivity6.getToolbar_title();
            toolbar_title.setText(String.valueOf(i + 1) + " of " + NewDateHelper.INSTANCE.formattedVehicleCount(this.totalCount));
            SearchResultActivity searchResultActivity7 = this.searchResultActivity;
            if (searchResultActivity7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
            }
            searchResultActivity7.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darker));
            SearchResultActivity searchResultActivity8 = this.searchResultActivity;
            if (searchResultActivity8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
            }
            searchResultActivity8.getToolbar_sub_title().setVisibility(8);
            return;
        }
        SearchResultActivity searchResultActivity9 = this.searchResultActivity;
        if (searchResultActivity9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        TextView toolbar_title2 = searchResultActivity9.getToolbar_title();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(vehicle != null ? vehicle.getYear() : null);
        sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb3.append(vehicle != null ? vehicle.getMake() : null);
        sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        if (vehicle != null) {
            str = vehicle.getModel();
        }
        sb3.append(str);
        toolbar_title2.setText(sb3.toString());
        SearchResultActivity searchResultActivity10 = this.searchResultActivity;
        if (searchResultActivity10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        searchResultActivity10.getToolbar_sub_title().setVisibility(8);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void navigateToProductDetailsPage(com.iaai.android.bdt.model.fastSearch.Vehicle r7, int r8) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L_0x000c
            int r1 = r7.getItemId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x000d
        L_0x000c:
            r1 = r0
        L_0x000d:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            java.lang.String r3 = "itemId"
            r2.putString(r3, r1)
            boolean r4 = r6.isTablet
            java.lang.String r5 = "searchReultListAdapter"
            if (r4 == 0) goto L_0x0069
            if (r7 == 0) goto L_0x002b
            int r7 = r7.getItemId()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r7)
        L_0x002b:
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r7 = r6.searchReultListAdapter
            if (r7 != 0) goto L_0x0032
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x0032:
            r7.setSelectedItemForTablet(r0)
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r7 = r6.searchReultListAdapter
            if (r7 != 0) goto L_0x003c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x003c:
            r7.notifyDataSetChanged()
            androidx.fragment.app.FragmentManager r7 = r6.getChildFragmentManager()
            r8 = 2131296449(0x7f0900c1, float:1.8210815E38)
            androidx.fragment.app.Fragment r7 = r7.findFragmentById(r8)
            if (r7 == 0) goto L_0x0061
            androidx.navigation.fragment.NavHostFragment r7 = (androidx.navigation.fragment.NavHostFragment) r7
            androidx.navigation.NavController r8 = r7.getNavController()
            r8.popBackStack()
            androidx.navigation.NavController r7 = r7.getNavController()
            r8 = 2131296297(0x7f090029, float:1.8210507E38)
            r7.navigate((int) r8, (android.os.Bundle) r2)
            goto L_0x0211
        L_0x0061:
            kotlin.TypeCastException r7 = new kotlin.TypeCastException
            java.lang.String r8 = "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment"
            r7.<init>(r8)
            throw r7
        L_0x0069:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            boolean r4 = r6.isSingleSearchProductDeatil
            if (r4 == 0) goto L_0x0076
            r2.add(r1)
            goto L_0x00a3
        L_0x0076:
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchReultListAdapter r1 = r6.searchReultListAdapter
            if (r1 != 0) goto L_0x007d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x007d:
            if (r1 == 0) goto L_0x00a3
            androidx.paging.PagedList r1 = r1.getCurrentList()
            if (r1 == 0) goto L_0x00a3
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x008b:
            boolean r4 = r1.hasNext()
            if (r4 == 0) goto L_0x00a3
            java.lang.Object r4 = r1.next()
            com.iaai.android.bdt.model.fastSearch.Vehicle r4 = (com.iaai.android.bdt.model.fastSearch.Vehicle) r4
            int r4 = r4.getItemId()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r2.add(r4)
            goto L_0x008b
        L_0x00a3:
            android.os.Bundle r1 = new android.os.Bundle
            r1.<init>()
            if (r7 == 0) goto L_0x00b3
            int r4 = r7.getItemId()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x00b4
        L_0x00b3:
            r4 = r0
        L_0x00b4:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r1.putString(r3, r4)
            java.lang.String r3 = "item_ids_list"
            r1.putStringArrayList(r3, r2)
            java.lang.String r2 = "position"
            r1.putInt(r2, r8)
            if (r7 == 0) goto L_0x00cc
            java.lang.String r3 = r7.getLiveDate()
            goto L_0x00cd
        L_0x00cc:
            r3 = r0
        L_0x00cd:
            java.lang.String r4 = "AuctionDate"
            r1.putString(r4, r3)
            if (r7 == 0) goto L_0x00d9
            java.lang.String r3 = r7.getBranchnumber()
            goto L_0x00da
        L_0x00d9:
            r3 = r0
        L_0x00da:
            java.lang.String r4 = "branchId"
            r1.putString(r4, r3)
            int r3 = r6.currentCount
            java.lang.String r4 = "currentCount"
            r1.putInt(r4, r3)
            int r3 = r6.totalCount
            java.lang.String r4 = "totalCount"
            r1.putInt(r4, r3)
            r1.putInt(r2, r8)
            com.google.gson.Gson r2 = new com.google.gson.Gson
            r2.<init>()
            com.iaai.android.bdt.model.fastSearch.SearchInputV2 r3 = r6.searchInput
            if (r3 != 0) goto L_0x00fe
            java.lang.String r4 = "searchInput"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x00fe:
            java.lang.String r2 = r2.toJson((java.lang.Object) r3)
            java.lang.String r3 = "fastSearchParam"
            r1.putString(r3, r2)
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity r2 = r6.searchResultActivity
            java.lang.String r3 = "searchResultActivity"
            if (r2 != 0) goto L_0x0110
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x0110:
            android.app.Activity r2 = (android.app.Activity) r2
            r4 = 2131297604(0x7f090544, float:1.8213158E38)
            androidx.navigation.NavController r2 = androidx.navigation.Navigation.findNavController(r2, r4)
            java.lang.String r4 = "Navigation.findNavContro…d.main_nav_host_fragment)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            androidx.navigation.NavDestination r4 = r2.getCurrentDestination()
            if (r4 == 0) goto L_0x0133
            int r4 = r4.getId()
            r5 = 2131296310(0x7f090036, float:1.8210533E38)
            if (r4 != r5) goto L_0x0133
            r4 = 2131296365(0x7f09006d, float:1.8210645E38)
            r2.navigate((int) r4, (android.os.Bundle) r1)
        L_0x0133:
            int r1 = r6.totalCount
            r2 = 8
            r4 = 1
            if (r1 <= r4) goto L_0x01c3
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity r7 = r6.searchResultActivity
            if (r7 != 0) goto L_0x0141
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x0141:
            int r0 = com.iaai.android.C2723R.C2726id.toolbar_relativelayout
            android.view.View r7 = r7._$_findCachedViewById(r0)
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            java.lang.String r0 = "searchResultActivity.toolbar_relativelayout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r0)
            r1 = 8388613(0x800005, float:1.175495E-38)
            r7.setGravity(r1)
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity r7 = r6.searchResultActivity
            if (r7 != 0) goto L_0x015b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x015b:
            int r1 = com.iaai.android.C2723R.C2726id.toolbar_relativelayout
            android.view.View r7 = r7._$_findCachedViewById(r1)
            android.widget.RelativeLayout r7 = (android.widget.RelativeLayout) r7
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r7, r0)
            r0 = 5
            r7.setGravity(r0)
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity r7 = r6.searchResultActivity
            if (r7 != 0) goto L_0x0171
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x0171:
            android.widget.TextView r7 = r7.getToolbar_title()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r8 = r8 + r4
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r0.append(r8)
            java.lang.String r8 = " of "
            r0.append(r8)
            com.iaai.android.bdt.utils.NewDateHelper r8 = com.iaai.android.bdt.utils.NewDateHelper.INSTANCE
            int r1 = r6.totalCount
            java.lang.String r8 = r8.formattedVehicleCount(r1)
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity r7 = r6.searchResultActivity
            if (r7 != 0) goto L_0x01a2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x01a2:
            android.widget.TextView r7 = r7.getToolbar_title()
            android.content.res.Resources r8 = r6.getResources()
            r0 = 2131099697(0x7f060031, float:1.7811755E38)
            int r8 = r8.getColor(r0)
            r7.setTextColor(r8)
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity r7 = r6.searchResultActivity
            if (r7 != 0) goto L_0x01bb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x01bb:
            android.widget.TextView r7 = r7.getToolbar_sub_title()
            r7.setVisibility(r2)
            goto L_0x0211
        L_0x01c3:
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity r8 = r6.searchResultActivity
            if (r8 != 0) goto L_0x01ca
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x01ca:
            android.widget.TextView r8 = r8.getToolbar_title()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            if (r7 == 0) goto L_0x01da
            java.lang.String r4 = r7.getYear()
            goto L_0x01db
        L_0x01da:
            r4 = r0
        L_0x01db:
            r1.append(r4)
            java.lang.String r4 = " "
            r1.append(r4)
            if (r7 == 0) goto L_0x01ea
            java.lang.String r5 = r7.getMake()
            goto L_0x01eb
        L_0x01ea:
            r5 = r0
        L_0x01eb:
            r1.append(r5)
            r1.append(r4)
            if (r7 == 0) goto L_0x01f7
            java.lang.String r0 = r7.getModel()
        L_0x01f7:
            r1.append(r0)
            java.lang.String r7 = r1.toString()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r8.setText(r7)
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity r7 = r6.searchResultActivity
            if (r7 != 0) goto L_0x020a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x020a:
            android.widget.TextView r7 = r7.getToolbar_sub_title()
            r7.setVisibility(r2)
        L_0x0211:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultListFragment.navigateToProductDetailsPage(com.iaai.android.bdt.model.fastSearch.Vehicle, int):void");
    }

    /* access modifiers changed from: private */
    public final SortOptionData createSortOptionData(String str, int i, boolean z) {
        String str2 = str;
        boolean z2 = z;
        String str3 = "livedatetime";
        switch (i) {
            case 0:
                return new SortOptionData(str2, str3, "0", z2);
            case 1:
                return new SortOptionData(str2, str3, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 2:
                return new SortOptionData(str2, Constants.EXTRA_BRANCH, "0", z2);
            case 3:
                return new SortOptionData(str2, Constants.EXTRA_BRANCH, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 4:
                return new SortOptionData(str2, "year", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 5:
                return new SortOptionData(str2, "year", "0", z2);
            case 6:
                return new SortOptionData(str2, "make", "0", z2);
            case 7:
                return new SortOptionData(str2, "make", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 8:
                return new SortOptionData(str2, "model", "0", z2);
            case 9:
                return new SortOptionData(str2, "model", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 10:
                return new SortOptionData(str2, "series", "0", z2);
            case 11:
                return new SortOptionData(str2, "series", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 12:
                return new SortOptionData(str2, "stockno", "0", z2);
            case 13:
                return new SortOptionData(str2, "stockno", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 14:
                return new SortOptionData(str2, Constants_MVVM.EXTRA_VIN, "0", z2);
            case 15:
                return new SortOptionData(str2, Constants_MVVM.EXTRA_VIN, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 16:
                return new SortOptionData(str2, "odometerfast", "0", z2);
            case 17:
                return new SortOptionData(str2, "odometerfast", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 18:
                return new SortOptionData(str2, "auctionlane", "0", z2);
            case 19:
                return new SortOptionData(str2, "auctionlane", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 20:
                return new SortOptionData(str2, "slotorder", "0", z2);
            case 21:
                return new SortOptionData(str2, "slotorder", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 22:
                return new SortOptionData(str2, "vehicletitle", "0", z2);
            case 23:
                return new SortOptionData(str2, "vehicletitle", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 24:
                return new SortOptionData(str2, "losstype", "0", z2);
            case 25:
                return new SortOptionData(str2, "losstype", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 26:
                return new SortOptionData(str2, "primarydamage", "0", z2);
            case 27:
                return new SortOptionData(str2, "primarydamage", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            default:
                return new SortOptionData(str2, str3, "0", z2);
        }
    }

    private final SearchInputV2 makeRequestBody() {
        String str;
        boolean z;
        String sortKey;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator it = this.selectedRefinerList.iterator();
        while (true) {
            str = "";
            z = false;
            if (!it.hasNext()) {
                break;
            }
            SelectedRefinerV2 selectedRefinerV2 = (SelectedRefinerV2) it.next();
            if (StringsKt.equals(selectedRefinerV2.getRefinerTypeValue(), "Assigned Vehicles", true)) {
                ArrayList arrayList5 = new ArrayList();
                if (StringsKt.equals(selectedRefinerV2.getRefinerValue().get(0), "All Vehicles", true)) {
                    arrayList5.add(str);
                }
                if (StringsKt.equals(selectedRefinerV2.getRefinerValue().get(0), "All Unassigned Vehicles", true)) {
                    arrayList5.add(PdfBoolean.FALSE);
                }
                arrayList.add(new RequestSelectedRefiner("readyforbid", arrayList5));
            } else if (StringsKt.equals(selectedRefinerV2.getRefinerTypeValue(), "Vehicle Assignment", true)) {
                ArrayList arrayList6 = new ArrayList();
                if (Intrinsics.areEqual((Object) selectedRefinerV2.getRefinerValue().get(0), (Object) "Assigned Vehicles")) {
                    arrayList6.add("true");
                } else {
                    arrayList6.add(PdfBoolean.FALSE);
                }
                arrayList.add(new RequestSelectedRefiner("readyforbid", arrayList6));
            } else if (StringsKt.equals(selectedRefinerV2.getRefinerTypeValue(), "Auction Week", true)) {
                ArrayList arrayList7 = new ArrayList();
                if (StringsKt.equals(selectedRefinerV2.getRefinerValue().get(0), "This Week", true)) {
                    arrayList7.add(this.thisWeek);
                } else if (StringsKt.equals(selectedRefinerV2.getRefinerValue().get(0), "Next Week", true)) {
                    arrayList7.add(this.nextWeek);
                } else {
                    arrayList7.add(selectedRefinerV2.getRefinerValue().get(0));
                }
                arrayList.add(new RequestSelectedRefiner(selectedRefinerV2.getRefinerTypeValue(), arrayList7));
            } else if (StringsKt.equals(selectedRefinerV2.getRefinerTypeValue(), "Remarketing Seller", true)) {
                arrayList.add(new RequestSelectedRefiner("vrdprovider", selectedRefinerV2.getRefinerValue()));
            } else if (StringsKt.equals(selectedRefinerV2.getRefinerTypeValue(), "Title Status", true)) {
                ArrayList arrayList8 = new ArrayList();
                if (Intrinsics.areEqual((Object) selectedRefinerV2.getRefinerValue().get(0), (Object) "Title Available")) {
                    arrayList8.add("true");
                }
                arrayList.add(new RequestSelectedRefiner("tboindicator", arrayList8));
            } else if (selectedRefinerV2.getQuickLink()) {
                arrayList2.add(selectedRefinerV2.getRefinerValue().get(0));
            } else if (StringsKt.startsWith(selectedRefinerV2.getRefinerTypeValue(), "make", true)) {
                arrayList3.add(selectedRefinerV2.getRefinerValue().get(0));
            } else if (StringsKt.startsWith(selectedRefinerV2.getRefinerTypeValue(), "model", true)) {
                arrayList4.add(selectedRefinerV2.getRefinerValue().get(0));
            } else if (!StringsKt.equals(selectedRefinerV2.getRefinerTypeValue(), "RefinerSearch", true)) {
                arrayList.add(new RequestSelectedRefiner(selectedRefinerV2.getRefinerTypeValue(), selectedRefinerV2.getRefinerValue()));
            }
        }
        if (!arrayList2.isEmpty()) {
            arrayList.add(new RequestSelectedRefiner("quicklinks", arrayList2));
        }
        if (!arrayList3.isEmpty()) {
            arrayList.add(new RequestSelectedRefiner("make", arrayList3));
        }
        if (!arrayList4.isEmpty()) {
            arrayList.add(new RequestSelectedRefiner("model", arrayList4));
        }
        ArrayList arrayList9 = new ArrayList();
        SortOptionData sortOptionData2 = this.sortOptionData;
        String str2 = "livedatetime";
        if (sortOptionData2 != null) {
            String str3 = null;
            String sortKey2 = sortOptionData2 != null ? sortOptionData2.getSortKey() : null;
            if (sortKey2 == null) {
                Intrinsics.throwNpe();
            }
            if (sortKey2.length() > 0) {
                z = true;
            }
            if (z) {
                SortOptionData sortOptionData3 = this.sortOptionData;
                if (sortOptionData3 != null) {
                    str3 = sortOptionData3.getSortDirection();
                }
                boolean areEqual = Intrinsics.areEqual((Object) str3, (Object) "0");
                SortOptionData sortOptionData4 = this.sortOptionData;
                if (!(sortOptionData4 == null || (sortKey = sortOptionData4.getSortKey()) == null)) {
                    str2 = sortKey;
                }
                arrayList9.add(new SortRule(areEqual, str2));
            }
        } else {
            arrayList9.add(new SortRule(true, str2));
        }
        int i = this.latitude;
        String valueOf = i != 0 ? String.valueOf(i) : str;
        int i2 = this.longitude;
        if (i2 != 0) {
            str = String.valueOf(i2);
        }
        this.searchInput = new SearchInputV2(100, this.searchInputKey, valueOf, str, false, arrayList, arrayList9, 1);
        SearchInputV2 searchInputV2 = this.searchInput;
        if (searchInputV2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchInput");
        }
        searchInputV2.setStartIndex(1);
        SearchInputV2 searchInputV22 = this.searchInput;
        if (searchInputV22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchInput");
        }
        searchInputV22.setCountOfVehicles(100);
        SearchInputV2 searchInputV23 = this.searchInput;
        if (searchInputV23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchInput");
        }
        return searchInputV23;
    }

    private final void loadFastSearchListV2(SearchInputV2 searchInputV2) {
        showLoadingIndicator(true);
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
        SearchResultActivity searchResultActivity2 = this.searchResultActivity;
        if (searchResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        String deviceId = AppUtils.getDeviceId(searchResultActivity2);
        Intrinsics.checkExpressionValueIsNotNull(deviceId, "AppUtils.getDeviceId(searchResultActivity)");
        fastSearchViewModel.fetchSearchResultListV2(searchInputV2, format, deviceId, true);
        subscribeToViewModel();
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
        fastSearchViewModel2.getVehicleLiveData().observe(lifecycleOwner, new SearchResultListFragment$subscribeToViewModel$1(this));
        FastSearchViewModel fastSearchViewModel3 = this.viewModel;
        if (fastSearchViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        fastSearchViewModel3.getVehicleTotalCount().observe(lifecycleOwner, new SearchResultListFragment$subscribeToViewModel$2(this));
        FastSearchViewModel fastSearchViewModel4 = this.viewModel;
        if (fastSearchViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        fastSearchViewModel4.getScrollSearchListToTop().observe(lifecycleOwner, new SearchResultListFragment$subscribeToViewModel$3(this));
        FastSearchViewModel fastSearchViewModel5 = this.viewModel;
        if (fastSearchViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<UpdateWatchListResponse> watchStatusResponse = fastSearchViewModel5.getWatchStatusResponse();
        SearchResultActivity searchResultActivity2 = this.searchResultActivity;
        if (searchResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        watchStatusResponse.observe(searchResultActivity2, new SearchResultListFragment$subscribeToViewModel$4(this));
        FastSearchViewModel fastSearchViewModel6 = this.viewModel;
        if (fastSearchViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> watchStatusError = fastSearchViewModel6.getWatchStatusError();
        SearchResultActivity searchResultActivity3 = this.searchResultActivity;
        if (searchResultActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        watchStatusError.observe(searchResultActivity3, new SearchResultListFragment$subscribeToViewModel$5(this));
    }

    /* access modifiers changed from: private */
    public final void setToolBarTitle() {
        SearchResultActivity searchResultActivity2 = this.searchResultActivity;
        if (searchResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        searchResultActivity2.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_search));
        SearchResultActivity searchResultActivity3 = this.searchResultActivity;
        if (searchResultActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        TextView toolbar_sub_title = searchResultActivity3.getToolbar_sub_title();
        toolbar_sub_title.setText(BDTUtils.INSTANCE.getCountDisplay(this.totalCount) + ' ' + getResources().getString(C2723R.string.lbl_results));
        SearchResultActivity searchResultActivity4 = this.searchResultActivity;
        if (searchResultActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        searchResultActivity4.getToolbar_sub_title().setVisibility(0);
        SearchResultActivity searchResultActivity5 = this.searchResultActivity;
        if (searchResultActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        searchResultActivity5.getIvStockShare().setVisibility(8);
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            loadFastSearchListV2(makeRequestBody());
            return;
        }
        this.errorType = BaseFragment.ErrorType.NO_INTERNET;
        this.isError = true;
        addHeaderToAuctionSalesList("");
        IAAAnalytics.INSTANCE.logNetworkEvent("acserviceswebapi/api/GetSearchResults/?getlatest=1", false, "", BaseFragment.ErrorType.NO_INTERNET.getValue());
        InternetUtil.INSTANCE.observe(this, SearchResultListFragment$checkNetworkConnection$1.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbLoadingAuctionSaleList);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbLoadingAuctionSaleList");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbLoadingAuctionSaleList);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbLoadingAuctionSaleList");
        progressBar2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void addHeaderToAuctionSalesList(String str) {
        AuctionSalesListHeader auctionSalesListHeader = new AuctionSalesListHeader();
        auctionSalesListHeader.setError(this.isError);
        auctionSalesListHeader.setVehicalCount(String.valueOf(this.currentCount));
        if (this.isError) {
            BaseFragment.ErrorType errorType2 = this.errorType;
            if (errorType2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorType");
            }
            switch (errorType2) {
                case NO_INTERNET:
                    str = getString(C2723R.string.lbl_msg_no_internet_connection);
                    Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.lbl_msg_no_internet_connection)");
                    break;
                case NETWORK_ERROR:
                    str = getString(C2723R.string.msg_prd_network_error);
                    Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.msg_prd_network_error)");
                    break;
                case NO_STOCKS:
                    str = getString(C2723R.string.bdt_auction_error_type_no_stock);
                    Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.bdt_a…tion_error_type_no_stock)");
                    break;
                case NO_AUCTION:
                    str = getString(C2723R.string.bdt_auction_error_type_no_auction);
                    Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.bdt_a…on_error_type_no_auction)");
                    break;
                case NO_VEHICLE_INFO:
                    str = getString(C2723R.string.bdt_auction_error_type_no_auction);
                    Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.bdt_a…on_error_type_no_auction)");
                    break;
                case NO_SEARCH_RESULT:
                    str = getString(C2723R.string.bdt_lbl_error_msg_no_item_found);
                    Intrinsics.checkExpressionValueIsNotNull(str, "getString(R.string.bdt_l…_error_msg_no_item_found)");
                    break;
                case NO_QUICK_FILTER:
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            auctionSalesListHeader.setErrorMessage(str);
            BaseFragment.ErrorType errorType3 = this.errorType;
            if (errorType3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("errorType");
            }
            auctionSalesListHeader.setErrorType(errorType3);
        }
        auctionSalesListHeader.setSelectedRefinerHashMap(new LinkedHashMap());
        LinkedHashMap<String, SelectedRefinerV2> selectedRefinerHashMap = auctionSalesListHeader.getSelectedRefinerHashMap();
        if (selectedRefinerHashMap == null) {
            Intrinsics.throwNpe();
        }
        updateSelectedRefinerHashMap(selectedRefinerHashMap);
        LinkedHashMap<String, SelectedRefinerV2> selectedRefinerHashMap2 = auctionSalesListHeader.getSelectedRefinerHashMap();
        auctionSalesListHeader.setFilterCount(selectedRefinerHashMap2 != null ? selectedRefinerHashMap2.size() : 0);
        SearchReultListAdapter searchReultListAdapter2 = this.searchReultListAdapter;
        if (searchReultListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchReultListAdapter");
        }
        searchReultListAdapter2.setHeaderItem(auctionSalesListHeader, this);
        SearchReultListAdapter searchReultListAdapter3 = this.searchReultListAdapter;
        if (searchReultListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchReultListAdapter");
        }
        searchReultListAdapter3.notifyDataSetChanged();
    }

    /* JADX WARNING: type inference failed for: r6v5, types: [java.lang.String] */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        r9 = r11.getExtras();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r9, int r10, @org.jetbrains.annotations.Nullable android.content.Intent r11) {
        /*
            r8 = this;
            super.onActivityResult(r9, r10, r11)
            r10 = 101(0x65, float:1.42E-43)
            r0 = 2131821012(0x7f1101d4, float:1.9274755E38)
            r1 = 1
            java.lang.String r2 = "searchinput"
            java.lang.String r3 = "searchResultActivity"
            java.lang.String r4 = "ed_search_result"
            java.lang.String r5 = ""
            r6 = 0
            r7 = 0
            if (r9 == r10) goto L_0x01b4
            r10 = 104(0x68, float:1.46E-43)
            if (r9 == r10) goto L_0x00f1
            r10 = 105(0x69, float:1.47E-43)
            if (r9 == r10) goto L_0x001f
            goto L_0x0272
        L_0x001f:
            if (r11 == 0) goto L_0x002e
            android.os.Bundle r9 = r11.getExtras()
            if (r9 == 0) goto L_0x002e
            java.lang.String r10 = "search_selected_sort_position"
            int r9 = r9.getInt(r10)
            goto L_0x002f
        L_0x002e:
            r9 = 0
        L_0x002f:
            r8.lastSelectedSort = r9
            if (r11 == 0) goto L_0x0044
            android.os.Bundle r9 = r11.getExtras()
            if (r9 == 0) goto L_0x0044
            java.lang.String r10 = "search_selected_sort"
            android.os.Parcelable r9 = r9.getParcelable(r10)
            com.iaai.android.bdt.model.sort.SortOptionData r9 = (com.iaai.android.bdt.model.sort.SortOptionData) r9
            if (r9 == 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r9 = r6
        L_0x0045:
            r8.sortOptionData = r9
            r8.latitude = r7
            r8.longitude = r7
            com.iaai.android.bdt.model.sort.SortOptionData r9 = r8.sortOptionData
            if (r9 == 0) goto L_0x0054
            java.lang.String r9 = r9.getDisplayText()
            goto L_0x0055
        L_0x0054:
            r9 = r6
        L_0x0055:
            java.lang.String r10 = "my_location"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x0064
            r8.requestCurrentLocationData()
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            goto L_0x0272
        L_0x0064:
            com.iaai.android.bdt.model.sort.SortOptionData r9 = r8.sortOptionData
            if (r9 == 0) goto L_0x006d
            java.lang.String r9 = r9.getDisplayText()
            goto L_0x006e
        L_0x006d:
            r9 = r6
        L_0x006e:
            java.lang.String r10 = "zip_code"
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r10)
            if (r9 == 0) goto L_0x00e8
            com.iaai.android.bdt.model.sort.SortOptionData r9 = r8.sortOptionData
            if (r9 == 0) goto L_0x0272
            if (r9 == 0) goto L_0x0080
            java.lang.String r6 = r9.getSortKey()
        L_0x0080:
            if (r6 == 0) goto L_0x0272
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity r9 = r8.searchResultActivity
            if (r9 != 0) goto L_0x0089
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x0089:
            android.content.Context r9 = (android.content.Context) r9
            com.iaai.android.bdt.model.sort.SortOptionData r10 = r8.sortOptionData
            if (r10 != 0) goto L_0x0092
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0092:
            java.lang.String r10 = r10.getSortKey()
            com.google.android.gms.maps.model.LatLng r9 = com.iaai.android.bdt.extensions.Context_ExtensionKt.getLatLng(r9, r10)
            if (r9 == 0) goto L_0x00a6
            double r10 = r9.latitude
            r0 = 1000000(0xf4240, float:1.401298E-39)
            double r0 = (double) r0
            double r10 = r10 * r0
            int r10 = (int) r10
            goto L_0x00a7
        L_0x00a6:
            r10 = 0
        L_0x00a7:
            r8.latitude = r10
            if (r9 == 0) goto L_0x00b4
            double r9 = r9.longitude
            r11 = -1000000(0xfffffffffff0bdc0, float:NaN)
            double r0 = (double) r11
            double r9 = r9 * r0
            int r7 = (int) r9
        L_0x00b4:
            r8.longitude = r7
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "ZIP: "
            r9.append(r10)
            int r10 = r8.latitude
            r9.append(r10)
            r10 = 32
            r9.append(r10)
            int r10 = r8.longitude
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "TEST"
            android.util.Log.e(r10, r9)
            com.iaai.android.bdt.model.sort.SortOptionData r9 = r8.sortOptionData
            if (r9 == 0) goto L_0x00df
            r9.setSortKey(r5)
        L_0x00df:
            com.iaai.android.bdt.model.fastSearch.SearchInputV2 r9 = r8.makeRequestBody()
            r8.loadFastSearchListV2(r9)
            goto L_0x0272
        L_0x00e8:
            com.iaai.android.bdt.model.fastSearch.SearchInputV2 r9 = r8.makeRequestBody()
            r8.loadFastSearchListV2(r9)
            goto L_0x0272
        L_0x00f1:
            if (r11 == 0) goto L_0x0100
            android.os.Bundle r9 = r11.getExtras()
            if (r9 == 0) goto L_0x0100
            java.lang.String r9 = r9.getString(r2)
            if (r9 == 0) goto L_0x0100
            goto L_0x0101
        L_0x0100:
            r9 = r5
        L_0x0101:
            r8.searchInputKey = r9
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Sending Event: "
            r9.append(r10)
            com.iaai.android.bdt.analytics.IAAAnalytics$IAAEvents r10 = com.iaai.android.bdt.analytics.IAAAnalytics.IAAEvents.SEARCH_RESULT_KEYWORD_USAGE
            java.lang.String r10 = r10.getId()
            r9.append(r10)
            java.lang.String r10 = " :"
            r9.append(r10)
            java.lang.String r10 = r8.searchInputKey
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.String r10 = "FIRE_BASE_ANALYTICS"
            android.util.Log.e(r10, r9)
            com.iaai.android.bdt.analytics.IAAAnalytics r9 = com.iaai.android.bdt.analytics.IAAAnalytics.INSTANCE
            com.iaai.android.bdt.analytics.IAAAnalytics$IAAEvents r10 = com.iaai.android.bdt.analytics.IAAAnalytics.IAAEvents.SEARCH_RESULT_KEYWORD_USAGE
            r9.logIAAEvent(r10, r6)
            java.lang.String r9 = r8.searchInputKey
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            int r9 = r9.length()
            if (r9 <= 0) goto L_0x013b
            goto L_0x013c
        L_0x013b:
            r1 = 0
        L_0x013c:
            if (r1 == 0) goto L_0x0169
            int r9 = com.iaai.android.C2723R.C2726id.ed_search_result
            android.view.View r9 = r8._$_findCachedViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r4)
            java.lang.String r10 = r8.searchInputKey
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r9.setText(r10)
            r8.addSearchRefiner()
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity r9 = r8.searchResultActivity
            if (r9 != 0) goto L_0x015a
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x015a:
            android.content.Context r9 = (android.content.Context) r9
            java.lang.String r10 = r8.searchInputKey
            com.iaai.android.old.utils.IAASharedPreference.setRefinerSearch(r9, r10)
            com.iaai.android.bdt.model.fastSearch.SearchInputV2 r9 = r8.makeRequestBody()
            r8.loadFastSearchListV2(r9)
            goto L_0x01af
        L_0x0169:
            int r9 = com.iaai.android.C2723R.C2726id.ed_search_result
            android.view.View r9 = r8._$_findCachedViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r4)
            r10 = r5
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r9.setText(r10)
            int r9 = com.iaai.android.C2723R.C2726id.ed_search_result
            android.view.View r9 = r8._$_findCachedViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r4)
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity r10 = r8.searchResultActivity
            if (r10 != 0) goto L_0x018c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x018c:
            android.content.res.Resources r10 = r10.getResources()
            java.lang.String r10 = r10.getString(r0)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r9.setHint(r10)
            r8.removeRefinerSearch()
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity r9 = r8.searchResultActivity
            if (r9 != 0) goto L_0x01a3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x01a3:
            android.content.Context r9 = (android.content.Context) r9
            com.iaai.android.old.utils.IAASharedPreference.setRefinerSearch(r9, r5)
            com.iaai.android.bdt.model.fastSearch.SearchInputV2 r9 = r8.makeRequestBody()
            r8.loadFastSearchListV2(r9)
        L_0x01af:
            r8.setSelectedRefinerPreference()
            goto L_0x0272
        L_0x01b4:
            if (r11 == 0) goto L_0x0272
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> r9 = r8.selectedRefinerList
            r9.clear()
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> r9 = r8.hashMapMakeModelArray
            r9.clear()
            r9 = r6
            com.iaai.android.bdt.model.quickFilter.QuickFilterResponse r9 = (com.iaai.android.bdt.model.quickFilter.QuickFilterResponse) r9
            r8.quickFilter = r9
            android.os.Bundle r9 = r11.getExtras()
            if (r9 == 0) goto L_0x01d2
            java.lang.String r10 = "extra_selected_filter_data"
            java.util.ArrayList r9 = r9.getParcelableArrayList(r10)
            goto L_0x01d3
        L_0x01d2:
            r9 = r6
        L_0x01d3:
            java.lang.String r10 = "null cannot be cast to non-null type kotlin.collections.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> /* = java.util.ArrayList<com.iaai.android.bdt.model.fastSearch.SelectedRefinerV2> */"
            if (r9 == 0) goto L_0x026c
            r8.selectedRefinerList = r9
            android.os.Bundle r9 = r11.getExtras()
            if (r9 == 0) goto L_0x01e5
            java.lang.String r6 = "extra_selected_make_model_data"
            java.util.ArrayList r6 = r9.getParcelableArrayList(r6)
        L_0x01e5:
            if (r6 == 0) goto L_0x0266
            r8.hashMapMakeModelArray = r6
            android.os.Bundle r9 = r11.getExtras()
            if (r9 == 0) goto L_0x01f6
            java.lang.String r10 = "make_model_group_position"
            int r9 = r9.getInt(r10)
            goto L_0x01f7
        L_0x01f6:
            r9 = 0
        L_0x01f7:
            r8.groupPostion = r9
            r8.currentCount = r7
            android.os.Bundle r9 = r11.getExtras()
            if (r9 == 0) goto L_0x0208
            java.lang.String r9 = r9.getString(r2, r5)
            if (r9 == 0) goto L_0x0208
            goto L_0x0209
        L_0x0208:
            r9 = r5
        L_0x0209:
            r8.searchInputKey = r9
            java.lang.String r9 = r8.searchInputKey
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x0219
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0218
            goto L_0x0219
        L_0x0218:
            r1 = 0
        L_0x0219:
            if (r1 == 0) goto L_0x023f
            int r9 = com.iaai.android.C2723R.C2726id.ed_search_result
            android.view.View r9 = r8._$_findCachedViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r4)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r9.setText(r5)
            int r9 = com.iaai.android.C2723R.C2726id.ed_search_result
            android.view.View r9 = r8._$_findCachedViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r4)
            java.lang.String r10 = r8.getString(r0)
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r9.setHint(r10)
        L_0x023f:
            com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity r9 = r8.searchResultActivity
            if (r9 != 0) goto L_0x0246
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x0246:
            android.content.Context r9 = (android.content.Context) r9
            int r10 = com.iaai.android.C2723R.C2726id.ed_search_result
            android.view.View r10 = r8._$_findCachedViewById(r10)
            android.widget.TextView r10 = (android.widget.TextView) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r4)
            java.lang.CharSequence r10 = r10.getText()
            java.lang.String r10 = r10.toString()
            com.iaai.android.old.utils.IAASharedPreference.setRefinerSearch(r9, r10)
            com.iaai.android.bdt.model.fastSearch.SearchInputV2 r9 = r8.makeRequestBody()
            r8.loadFastSearchListV2(r9)
            goto L_0x0272
        L_0x0266:
            kotlin.TypeCastException r9 = new kotlin.TypeCastException
            r9.<init>(r10)
            throw r9
        L_0x026c:
            kotlin.TypeCastException r9 = new kotlin.TypeCastException
            r9.<init>(r10)
            throw r9
        L_0x0272:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultListFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    private final void setSelectedRefinerPreference() {
        String json = new Gson().toJson((Object) this.selectedRefinerList);
        SearchResultActivity searchResultActivity2 = this.searchResultActivity;
        if (searchResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        IAASharedPreference.setSelectedFilter(searchResultActivity2, json);
    }

    private final void addSearchRefiner() {
        if (!StringsKt.isBlank(this.searchInputKey)) {
            if (this.selectedRefinerList.size() > 0) {
                removeRefinerSearch();
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.searchInputKey);
            this.selectedRefinerList.add(new SelectedRefinerV2("RefinerSearch", arrayList, false, 4, (DefaultConstructorMarker) null));
        }
    }

    private final void removeRefinerSearch() {
        Iterator it = this.selectedRefinerList.iterator();
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            } else if (StringsKt.equals(((SelectedRefinerV2) it.next()).getRefinerTypeValue(), "RefinerSearch", true)) {
                break;
            } else {
                i++;
            }
        }
        if (i != -1) {
            this.selectedRefinerList.remove(i);
        }
    }

    public void onResume() {
        super.onResume();
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        String value = IAAAnalytics.IAAScreenName.SEARCH_RESULT_LIST.getValue();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        iAAAnalytics.logScreenName(value, activity, this);
        if (this.isSingleSearchProductDeatil) {
            SearchResultActivity searchResultActivity2 = this.searchResultActivity;
            if (searchResultActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
            }
            NavController findNavController = Navigation.findNavController(searchResultActivity2, C2723R.C2726id.main_nav_host_fragment);
            Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
            boolean popBackStack = findNavController.popBackStack();
            Log.e("On Resume", "isSingleSearchProductDeatil true");
            if (!popBackStack) {
                Intent intent = new Intent();
                intent.putExtra(Constants_MVVM.EXTRA_IS_LANDING_PAGE, true);
                SearchResultActivity searchResultActivity3 = this.searchResultActivity;
                if (searchResultActivity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
                }
                intent.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, IAASharedPreference.getRefinerSearch(searchResultActivity3.getApplicationContext()));
                SearchResultActivity searchResultActivity4 = this.searchResultActivity;
                if (searchResultActivity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
                }
                searchResultActivity4.setResult(103, intent);
                SearchResultActivity searchResultActivity5 = this.searchResultActivity;
                if (searchResultActivity5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
                }
                searchResultActivity5.finish();
            }
        }
        setToolBarTitle();
    }

    private final void requestCurrentLocationData() {
        SearchResultActivity searchResultActivity2 = this.searchResultActivity;
        if (searchResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        CurrentLocationBroadcastReceiver currentLocationBroadcastReceiver2 = this.currentLocationBroadcastReceiver;
        if (currentLocationBroadcastReceiver2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentLocationBroadcastReceiver");
        }
        BroadcastReceiver broadcastReceiver = currentLocationBroadcastReceiver2;
        CurrentLocationManager currentLocationManager2 = this.currentLocationManager;
        if (currentLocationManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentLocationManager");
        }
        searchResultActivity2.registerReceiver(broadcastReceiver, currentLocationManager2.getBroadcastIntentFilter());
        CurrentLocationManager currentLocationManager3 = this.currentLocationManager;
        if (currentLocationManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentLocationManager");
        }
        SearchResultActivity searchResultActivity3 = this.searchResultActivity;
        if (searchResultActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        currentLocationManager3.refreshCurrentLocation(searchResultActivity3, true);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultListFragment$CurrentLocationBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/iaai/android/bdt/feature/findVehiclePage/searchResult/SearchResultListFragment;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: SearchResultListFragment.kt */
    public final class CurrentLocationBroadcastReceiver extends BroadcastReceiver {
        public CurrentLocationBroadcastReceiver() {
        }

        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(intent, "intent");
            if (Intrinsics.areEqual((Object) Constants.INTENT_CURRENT_LOCATION_UPDATE, (Object) intent.getAction())) {
                Location location = (Location) intent.getParcelableExtra("location");
                SearchResultListFragment searchResultListFragment = SearchResultListFragment.this;
                Intrinsics.checkExpressionValueIsNotNull(location, "currentLocation");
                searchResultListFragment.handleCurrentLocationBroadcastResult$app_productionRelease(location);
            } else if (Intrinsics.areEqual((Object) Constants.INTENT_CURRENT_LOCATION_NOT_AVAILABLE, (Object) intent.getAction())) {
                SearchResultListFragment.this.handleCurrentLocationNotAvailable$app_productionRelease();
            }
        }
    }

    public final void handleCurrentLocationBroadcastResult$app_productionRelease(@NotNull Location location) {
        Intrinsics.checkParameterIsNotNull(location, "location");
        try {
            SearchResultActivity searchResultActivity2 = this.searchResultActivity;
            if (searchResultActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
            }
            CurrentLocationBroadcastReceiver currentLocationBroadcastReceiver2 = this.currentLocationBroadcastReceiver;
            if (currentLocationBroadcastReceiver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentLocationBroadcastReceiver");
            }
            searchResultActivity2.unregisterReceiver(currentLocationBroadcastReceiver2);
        } catch (Exception unused) {
        }
        this.latitude = (int) (location.getLatitude() * ((double) 1000000));
        this.longitude = (int) (location.getLongitude() * ((double) -1000000));
        SortOptionData sortOptionData2 = this.sortOptionData;
        if (sortOptionData2 != null) {
            sortOptionData2.setSortKey("");
        }
        loadFastSearchListV2(makeRequestBody());
        Log.e("TEST", "LOCATION: " + this.latitude + ' ' + this.longitude);
    }

    public final void handleCurrentLocationNotAvailable$app_productionRelease() {
        SearchResultActivity searchResultActivity2 = this.searchResultActivity;
        if (searchResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        Toast.makeText(searchResultActivity2, C2723R.string.msg_location_na_use_search, 1).show();
    }

    private final void findMakeModelAndRemove(SelectedRefinerV2 selectedRefinerV2) {
        String str;
        String str2;
        List split$default = StringsKt.split$default((CharSequence) selectedRefinerV2.getRefinerTypeValue(), new char[]{'~'}, false, 0, 6, (Object) null);
        if (split$default.size() == 3) {
            String str3 = (String) split$default.get(1);
            str = (String) split$default.get(2);
            str2 = str3;
        } else if (split$default.size() == 2) {
            str2 = (String) split$default.get(1);
            str = "";
        } else {
            str2 = "";
            str = str2;
        }
        this.hashMapMakeModelArray.remove(selectedRefinerV2);
        SelectedRefinerV2 selectedRefinerV22 = new SelectedRefinerV2("", new ArrayList(), false);
        SelectedRefinerV2 selectedRefinerV23 = new SelectedRefinerV2("", new ArrayList(), false);
        SelectedRefinerV2 selectedRefinerV24 = selectedRefinerV23;
        boolean z = false;
        SelectedRefinerV2 selectedRefinerV25 = selectedRefinerV22;
        boolean z2 = false;
        for (SelectedRefinerV2 selectedRefinerV26 : this.selectedRefinerList) {
            if (StringsKt.equals(selectedRefinerV26.getRefinerValue().get(0), str2, true)) {
                selectedRefinerV25 = selectedRefinerV26;
                z2 = true;
            } else {
                if ((str.length() > 0) && StringsKt.equals(selectedRefinerV26.getRefinerTypeValue(), "model", true)) {
                    selectedRefinerV24 = selectedRefinerV26;
                    z = true;
                }
            }
        }
        if (z2 && z) {
            this.selectedRefinerList.remove(selectedRefinerV25);
            this.selectedRefinerList.remove(selectedRefinerV24);
        } else if (z2) {
            this.selectedRefinerList.remove(selectedRefinerV25);
        }
    }

    public void onItemClick(@NotNull SelectedRefinerV2 selectedRefinerV2, int i) {
        Intrinsics.checkParameterIsNotNull(selectedRefinerV2, "clickedItem");
        if (this.selectedRefinerList.size() > 0) {
            this.selectedRefinerList.remove(selectedRefinerV2);
        }
        if (StringsKt.equals(selectedRefinerV2.getRefinerTypeValue(), "RefinerSearch", true)) {
            this.searchInputKey = "";
            SearchResultActivity searchResultActivity2 = this.searchResultActivity;
            if (searchResultActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
            }
            IAASharedPreference.setRefinerSearch(searchResultActivity2, "");
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.ed_search_result);
            Intrinsics.checkExpressionValueIsNotNull(textView, "ed_search_result");
            textView.setText("");
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.ed_search_result);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "ed_search_result");
            textView2.setHint(getString(C2723R.string.hint_search_vehicle));
        }
        if (StringsKt.startsWith(selectedRefinerV2.getRefinerTypeValue(), "Make & Model", true)) {
            findMakeModelAndRemove(selectedRefinerV2);
        }
        Gson gson = new Gson();
        String json = gson.toJson((Object) this.selectedRefinerList);
        String json2 = gson.toJson((Object) this.hashMapMakeModelArray);
        SearchResultActivity searchResultActivity3 = this.searchResultActivity;
        if (searchResultActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        IAASharedPreference.setSelectedFilter(searchResultActivity3, json);
        SearchResultActivity searchResultActivity4 = this.searchResultActivity;
        if (searchResultActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchResultActivity");
        }
        IAASharedPreference.setSelectedMakeModelFilter(searchResultActivity4, json2);
        loadFastSearchListV2(makeRequestBody());
    }
}
