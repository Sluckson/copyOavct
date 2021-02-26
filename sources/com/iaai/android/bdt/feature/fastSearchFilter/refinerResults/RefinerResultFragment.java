package com.iaai.android.bdt.feature.fastSearchFilter.refinerResults;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
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
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterViewModel;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.RefinerHeaderAdapter;
import com.iaai.android.bdt.feature.findVehiclePage.SearchPanelFindVehicleActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.productDetail.ProductDetailActivity;
import com.iaai.android.bdt.model.fastSearchFilter2.Facet;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;
import com.iaai.android.bdt.model.fastSearchFilter2.LatLong;
import com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes;
import com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData;
import com.iaai.android.bdt.model.fastSearchFilter2.SavedSearch;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray;
import com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup;
import com.iaai.android.bdt.model.fastSearchFilter2.Searche;
import com.iaai.android.bdt.model.fastSearchFilter2.Sort;
import com.iaai.android.bdt.model.profile.UpdateWatchListResponse;
import com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse;
import com.iaai.android.bdt.model.sort.SortOptionData;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.bdt.utils.NetworkState;
import com.iaai.android.old.managers.CurrentLocationManager;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 \u00012\u00020\u0001:\u0004\u0001\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010S\u001a\u00020TH\u0002J\u0018\u0010U\u001a\u00020T2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010V\u001a\u00020T2\u0006\u0010W\u001a\u00020\u0010H\u0002J\b\u0010X\u001a\u00020TH\u0002J \u0010Y\u001a\u00020F2\u0006\u0010Z\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\b2\u0006\u0010\\\u001a\u00020\u001dH\u0002J\u0018\u0010]\u001a\u00020T2\u0006\u0010^\u001a\u00020\b2\u0006\u0010_\u001a\u00020\bH\u0002J*\u0010`\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0a2\u0006\u0010b\u001a\u00020\u00062\u0006\u0010c\u001a\u00020\u0006H\u0002J\u0015\u0010d\u001a\u00020T2\u0006\u0010e\u001a\u00020fH\u0000¢\u0006\u0002\bgJ\r\u0010h\u001a\u00020TH\u0000¢\u0006\u0002\biJ\b\u0010j\u001a\u00020TH\u0002J\b\u0010k\u001a\u00020TH\u0002J \u0010l\u001a\u00020T2\u0006\u0010m\u001a\u00020\u00062\u0006\u0010n\u001a\u00020\u00042\u0006\u0010o\u001a\u00020\u001dH\u0002J\b\u0010p\u001a\u00020TH\u0002J\u001a\u0010q\u001a\u00020T2\b\u0010r\u001a\u0004\u0018\u00010s2\u0006\u0010[\u001a\u00020\bH\u0002J\u001a\u0010t\u001a\u00020T2\b\u0010r\u001a\u0004\u0018\u00010s2\u0006\u0010[\u001a\u00020\bH\u0002J\u0012\u0010u\u001a\u00020T2\b\u0010v\u001a\u0004\u0018\u00010wH\u0016J\"\u0010x\u001a\u00020T2\u0006\u0010y\u001a\u00020\b2\u0006\u0010z\u001a\u00020\b2\b\u0010r\u001a\u0004\u0018\u00010{H\u0016J\u0010\u0010|\u001a\u00020T2\u0006\u0010}\u001a\u00020~H\u0016J\u0012\u0010\u001a\u00020T2\b\u0010v\u001a\u0004\u0018\u00010wH\u0016J+\u0010\u0001\u001a\u0004\u0018\u0001032\b\u0010\u0001\u001a\u00030\u00012\n\u0010\u0001\u001a\u0005\u0018\u00010\u00012\b\u0010v\u001a\u0004\u0018\u00010wH\u0016J\t\u0010\u0001\u001a\u00020TH\u0016J\t\u0010\u0001\u001a\u00020TH\u0016J\t\u0010\u0001\u001a\u00020TH\u0002J\u0007\u0010\u0001\u001a\u00020TJ\u0012\u0010\u0001\u001a\u00020T2\u0007\u0010\u0001\u001a\u00020\u001dH\u0002J\t\u0010\u0001\u001a\u00020TH\u0002J$\u0010\u0001\u001a\u00020T2\u0019\u0010\u0001\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0aH\u0002J\t\u0010\u0001\u001a\u00020TH\u0002J\u0012\u0010\u0001\u001a\u00020T2\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\t\u0010\u0001\u001a\u00020TH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001f\"\u0004\b(\u0010!R\u000e\u0010)\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X.¢\u0006\u0002\n\u0000R\u001c\u00102\u001a\u0004\u0018\u000103X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00108\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010:09j\n\u0012\u0006\u0012\u0004\u0018\u00010:`;X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010<\u001a\u0012\u0012\u0004\u0012\u00020=09j\b\u0012\u0004\u0012\u00020=`;X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010>\u001a\u00020?8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u000e\u0010D\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020KX.¢\u0006\u0002\n\u0000R\u001e\u0010L\u001a\u00020M8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR\u000e\u0010R\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "EPOCH_TICKS", "", "action", "", "currentCount", "", "currentLocationBroadcastReceiver", "Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultFragment$CurrentLocationBroadcastReceiver;", "currentLocationManager", "Lcom/iaai/android/old/managers/CurrentLocationManager;", "errorType", "Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "fastSearchRequestBody", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "getFastSearchRequestBody", "()Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;", "setFastSearchRequestBody", "(Lcom/iaai/android/bdt/model/fastSearchFilter2/FastSearchRequestBody;)V", "headerClickListener", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter$OnRefinerHeaderItemClickListener;", "getHeaderClickListener", "()Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter$OnRefinerHeaderItemClickListener;", "setHeaderClickListener", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/RefinerHeaderAdapter$OnRefinerHeaderItemClickListener;)V", "indexToUpdate", "isError", "", "isFirstTime", "()Z", "setFirstTime", "(Z)V", "isFromLandingPageSearch", "isFromSavedSearchList", "isGeoSort", "isLoggedIn", "isSingleSearchProductDeatil", "isTablet", "setTablet", "itemIdWatch", "lastSelectedSort", "latitude", "", "longitude", "refinerResultActivity", "Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultActivity;", "refinerResultListAdapter", "Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultListAdapter;", "searchResultView", "Landroid/view/View;", "getSearchResultView", "()Landroid/view/View;", "setSearchResultView", "(Landroid/view/View;)V", "selectedFacets", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FacetXX;", "Lkotlin/collections/ArrayList;", "selectedIndices", "Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/SelectedRefinerIndicesModel;", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "sortField", "sortOptionData", "Lcom/iaai/android/bdt/model/sort/SortOptionData;", "sortValue", "totalCount", "userId", "viewModel", "Lcom/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/FastSearchFilterViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "zipCode", "addHeaderForSavedSearchFacet", "", "addHeaderOnResultList", "addSelectedFacetForSavedSearch", "refinerListResponse", "checkNetworkConnection", "createSortOptionData", "displayText", "position", "isSelected", "enableBuyNowPrice", "tabPos", "parentPosition", "getTriple", "Lkotlin/Triple;", "groupKey", "childKey", "handleCurrentLocationBroadcastResult", "location", "Landroid/location/Location;", "handleCurrentLocationBroadcastResult$app_productionRelease", "handleCurrentLocationNotAvailable", "handleCurrentLocationNotAvailable$app_productionRelease", "initializeRecycler", "loadRefinerResult", "loadRefinerResultForSavedSearch", "searchURI", "savedSearchLogid", "IsaNewSearch", "navigateToKeyWordSearchPanel", "navigateToProductDetailsPage", "data", "Lcom/iaai/android/bdt/model/fastSearchFilter2/FormattedResult;", "navigateToProductDetailsPageForSingle", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onStart", "requestCurrentLocationData", "setToolBarTitle", "showLoadingIndicator", "loading", "subscribeToViewModel", "updateBuyNowPrice", "indices", "updateGlobalArrayForSelectedFacet", "updateKeywordSearch", "keywordSearch", "updateWatchStatus", "Companion", "CurrentLocationBroadcastReceiver", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RefinerResultFragment.kt */
public final class RefinerResultFragment extends BaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SAMPLE = "sample";
    private final long EPOCH_TICKS = 621355968000000000L;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public String action = "";
    /* access modifiers changed from: private */
    public int currentCount;
    private CurrentLocationBroadcastReceiver currentLocationBroadcastReceiver;
    private CurrentLocationManager currentLocationManager;
    private BaseFragment.ErrorType errorType;
    @NotNull
    public FastSearchRequestBody fastSearchRequestBody;
    @NotNull
    private RefinerHeaderAdapter.OnRefinerHeaderItemClickListener headerClickListener = new RefinerResultFragment$headerClickListener$1(this);
    /* access modifiers changed from: private */
    public int indexToUpdate;
    /* access modifiers changed from: private */
    public boolean isError;
    private boolean isFirstTime = true;
    /* access modifiers changed from: private */
    public boolean isFromLandingPageSearch;
    /* access modifiers changed from: private */
    public boolean isFromSavedSearchList;
    private boolean isGeoSort;
    /* access modifiers changed from: private */
    public boolean isLoggedIn;
    /* access modifiers changed from: private */
    public boolean isSingleSearchProductDeatil;
    private boolean isTablet;
    /* access modifiers changed from: private */
    public int itemIdWatch;
    /* access modifiers changed from: private */
    public int lastSelectedSort = 1;
    private double latitude;
    private double longitude;
    /* access modifiers changed from: private */
    public RefinerResultActivity refinerResultActivity;
    /* access modifiers changed from: private */
    public RefinerResultListAdapter refinerResultListAdapter;
    @Nullable
    private View searchResultView;
    /* access modifiers changed from: private */
    public ArrayList<FacetXX> selectedFacets = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<SelectedRefinerIndicesModel> selectedIndices = new ArrayList<>();
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private String sortField = "LiveDateTime";
    /* access modifiers changed from: private */
    public SortOptionData sortOptionData;
    private boolean sortValue;
    /* access modifiers changed from: private */
    public int totalCount;
    private String userId = "";
    private FastSearchFilterViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;
    private int zipCode;

    @JvmStatic
    @NotNull
    public static final RefinerResultFragment newInstance(@NotNull String str) {
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

    public static final /* synthetic */ RefinerResultActivity access$getRefinerResultActivity$p(RefinerResultFragment refinerResultFragment) {
        RefinerResultActivity refinerResultActivity2 = refinerResultFragment.refinerResultActivity;
        if (refinerResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        return refinerResultActivity2;
    }

    public static final /* synthetic */ RefinerResultListAdapter access$getRefinerResultListAdapter$p(RefinerResultFragment refinerResultFragment) {
        RefinerResultListAdapter refinerResultListAdapter2 = refinerResultFragment.refinerResultListAdapter;
        if (refinerResultListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultListAdapter");
        }
        return refinerResultListAdapter2;
    }

    public final boolean isFirstTime() {
        return this.isFirstTime;
    }

    public final void setFirstTime(boolean z) {
        this.isFirstTime = z;
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
    public final FastSearchRequestBody getFastSearchRequestBody() {
        FastSearchRequestBody fastSearchRequestBody2 = this.fastSearchRequestBody;
        if (fastSearchRequestBody2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchRequestBody");
        }
        return fastSearchRequestBody2;
    }

    public final void setFastSearchRequestBody(@NotNull FastSearchRequestBody fastSearchRequestBody2) {
        Intrinsics.checkParameterIsNotNull(fastSearchRequestBody2, "<set-?>");
        this.fastSearchRequestBody = fastSearchRequestBody2;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultFragment$Companion;", "", "()V", "KEY_SAMPLE", "", "newInstance", "Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultFragment;", "url", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RefinerResultFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final RefinerResultFragment newInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            RefinerResultFragment refinerResultFragment = new RefinerResultFragment();
            Bundle bundle = new Bundle();
            bundle.putString(RefinerResultFragment.KEY_SAMPLE, str);
            refinerResultFragment.setArguments(bundle);
            return refinerResultFragment;
        }
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.refinerResultActivity = (RefinerResultActivity) activity;
            if (context instanceof RefinerResultActivity) {
                this.refinerResultActivity = (RefinerResultActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        RefinerResultActivity refinerResultActivity2 = this.refinerResultActivity;
        if (refinerResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        FragmentActivity fragmentActivity = refinerResultActivity2;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(FastSearchFilterViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(re…terViewModel::class.java)");
        this.viewModel = (FastSearchFilterViewModel) viewModel2;
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
        RefinerResultActivity refinerResultActivity2 = this.refinerResultActivity;
        if (refinerResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        this.isTablet = refinerResultActivity2.getResources().getBoolean(C2723R.bool.isTabletPhone);
        if (this.searchResultView == null) {
            if (this.isTablet) {
                ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_refiner_result_land, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "mBinding");
                this.searchResultView = inflate.getRoot();
            } else {
                ViewDataBinding inflate2 = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_refiner_result, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate2, "mBinding");
                this.searchResultView = inflate2.getRoot();
            }
        }
        return this.searchResultView;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        boolean z = false;
        this.isFromSavedSearchList = arguments != null ? arguments.getBoolean(Constants_MVVM.EXTRA_IS_FROM_SAVED_SEARCH, false) : false;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            z = arguments2.getBoolean(Constants_MVVM.EXTRA_IS_FROM_LANDING_PAGE_SEARCH, false);
        }
        this.isFromLandingPageSearch = z;
        if (!this.isFromSavedSearchList) {
            Bundle arguments3 = getArguments();
            ArrayList<SelectedRefinerIndicesModel> arrayList = null;
            ArrayList<FacetXX> parcelableArrayList = arguments3 != null ? arguments3.getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_FACETS) : null;
            if (parcelableArrayList == null) {
                Intrinsics.throwNpe();
            }
            this.selectedFacets = parcelableArrayList;
            Bundle arguments4 = getArguments();
            if (arguments4 != null) {
                arrayList = arguments4.getParcelableArrayList(Constants_MVVM.EXTRA_SELECTED_INDICES);
            }
            if (arrayList == null) {
                Intrinsics.throwNpe();
            }
            this.selectedIndices = arrayList;
        }
        RefinerResultActivity refinerResultActivity2 = this.refinerResultActivity;
        if (refinerResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        ImageView imageView = (ImageView) refinerResultActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "refinerResultActivity.arrow_left");
        imageView.setVisibility(8);
        RefinerResultActivity refinerResultActivity3 = this.refinerResultActivity;
        if (refinerResultActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        ImageView imageView2 = (ImageView) refinerResultActivity3._$_findCachedViewById(C2723R.C2726id.arrow_right);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "refinerResultActivity.arrow_right");
        imageView2.setVisibility(8);
        RefinerResultActivity refinerResultActivity4 = this.refinerResultActivity;
        if (refinerResultActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        RelativeLayout relativeLayout = (RelativeLayout) refinerResultActivity4._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "refinerResultActivity.toolbar_relativelayout");
        relativeLayout.setGravity(GravityCompat.START);
        RefinerResultActivity refinerResultActivity5 = this.refinerResultActivity;
        if (refinerResultActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) refinerResultActivity5._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "refinerResultActivity.toolbar_relativelayout");
        relativeLayout2.setGravity(3);
        if (this.isTablet) {
            RefinerResultActivity refinerResultActivity6 = this.refinerResultActivity;
            if (refinerResultActivity6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
            }
            NavController findNavController = Navigation.findNavController(refinerResultActivity6, C2723R.C2726id.auction_sales_nav_container);
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
        if (this.isFirstTime) {
            initializeRecycler();
            checkNetworkConnection();
        }
        setToolBarTitle();
    }

    private final void initializeRecycler() {
        this.isFirstTime = false;
        FastSearchFilterViewModel fastSearchFilterViewModel = this.viewModel;
        if (fastSearchFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        RefinerResultActivity refinerResultActivity2 = this.refinerResultActivity;
        if (refinerResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        this.refinerResultListAdapter = new RefinerResultListAdapter(fastSearchFilterViewModel, refinerResultActivity2, new RefinerResultFragment$initializeRecycler$1(this));
        RefinerResultActivity refinerResultActivity3 = this.refinerResultActivity;
        if (refinerResultActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvResultList)).addItemDecoration(new DividerItemDecoration(refinerResultActivity3, 1));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvResultList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvResultList");
        RefinerResultListAdapter refinerResultListAdapter2 = this.refinerResultListAdapter;
        if (refinerResultListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultListAdapter");
        }
        recyclerView.setAdapter(refinerResultListAdapter2);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvResultList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvResultList");
        RefinerResultActivity refinerResultActivity4 = this.refinerResultActivity;
        if (refinerResultActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(refinerResultActivity4));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvResultList)).addOnScrollListener(new RefinerResultFragment$initializeRecycler$2(this));
        ((FloatingActionButton) _$_findCachedViewById(C2723R.C2726id.fab)).setOnClickListener(new RefinerResultFragment$initializeRecycler$3(this));
        RefinerResultActivity refinerResultActivity5 = this.refinerResultActivity;
        if (refinerResultActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        TextView textView = (TextView) refinerResultActivity5._$_findCachedViewById(C2723R.C2726id.tvSavedSearch);
        Intrinsics.checkExpressionValueIsNotNull(textView, "refinerResultActivity.tvSavedSearch");
        textView.setPaintFlags(8);
        RefinerResultActivity refinerResultActivity6 = this.refinerResultActivity;
        if (refinerResultActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        ((TextView) refinerResultActivity6._$_findCachedViewById(C2723R.C2726id.tvSavedSearch)).setOnClickListener(new RefinerResultFragment$initializeRecycler$4(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.ed_search_result)).setOnClickListener(new RefinerResultFragment$initializeRecycler$5(this));
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.img_voice_text)).setOnClickListener(new RefinerResultFragment$initializeRecycler$6(this));
    }

    /* access modifiers changed from: private */
    public final void navigateToKeyWordSearchPanel() {
        Intent intent = new Intent(getActivity(), SearchPanelFindVehicleActivity.class);
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_BY_VEHICLE, true);
        intent.putExtra(Constants_MVVM.EXTRA_IS_FILTERPAGE, true);
        intent.putExtra(Constants_MVVM.EXTRA_IS_FROM_FIND_VEHICLE_PAGE, true);
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.ed_search_result);
        Intrinsics.checkExpressionValueIsNotNull(textView, "ed_search_result");
        intent.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, textView.getText().toString());
        startActivityForResult(intent, 104);
    }

    /* access modifiers changed from: private */
    public final void loadRefinerResult() {
        String str;
        Integer first;
        String str2;
        if (this.isFromSavedSearchList) {
            Bundle arguments = getArguments();
            if (arguments == null || (str2 = arguments.getString(Constants_MVVM.EXTRA_SAVED_SEARCH_PARAM)) == null) {
                str2 = "";
            }
            SavedSearchListResponse savedSearchListResponse = (SavedSearchListResponse) new Gson().fromJson(str2, SavedSearchListResponse.class);
            String valueOf = String.valueOf(savedSearchListResponse.getSearchUrl());
            Long savedSearchLogId = savedSearchListResponse.getSavedSearchLogId();
            loadRefinerResultForSavedSearch(valueOf, savedSearchLogId != null ? savedSearchLogId.longValue() : 0, savedSearchListResponse.getIsaNewSearch());
            return;
        }
        showLoadingIndicator(true);
        updateGlobalArrayForSelectedFacet();
        Sort sort = new Sort(this.sortValue, this.isGeoSort, this.sortField);
        LatLong latLong = new LatLong(this.latitude, this.longitude);
        Log.d("sortField ", this.sortField + " sortValue " + this.sortValue);
        ArrayList arrayList = new ArrayList();
        Integer num = null;
        Pair<Integer, Integer> pair = null;
        Iterator it = this.selectedFacets.iterator();
        while (true) {
            int i = 0;
            if (it.hasNext()) {
                FacetXX facetXX = (FacetXX) it.next();
                if (facetXX == null || (str = facetXX.getRefinerValue()) == null) {
                    str = "";
                }
                CharSequence charSequence = str;
                if (!StringsKt.isBlank(charSequence)) {
                    if (StringsKt.startsWith(str, "Distance", true)) {
                        pair = BDTUtils.INSTANCE.getDistance(facetXX);
                        if (!(pair == null || (first = pair.getFirst()) == null)) {
                            i = first.intValue();
                        }
                        this.zipCode = i;
                    } else if (StringsKt.startsWith(str, "Make & Model", true)) {
                        ArrayList arrayList2 = new ArrayList();
                        String str3 = (String) StringsKt.split$default(charSequence, new String[]{"~"}, false, 0, 6, (Object) null).get(1);
                        if (str3 != null) {
                            String obj = StringsKt.trim((CharSequence) str3).toString();
                            String str4 = "null cannot be cast to non-null type kotlin.CharSequence";
                            String str5 = (String) StringsKt.split$default(charSequence, new String[]{"~"}, false, 0, 6, (Object) null).get(2);
                            if (str5 != null) {
                                String obj2 = StringsKt.trim((CharSequence) str5).toString();
                                arrayList2.add(new Facet(ExifInterface.TAG_MAKE, obj));
                                arrayList.add(new Searche("", arrayList2, "", (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null));
                                if (!StringsKt.startsWith$default(obj2, "All", false, 2, (Object) null)) {
                                    ArrayList arrayList3 = new ArrayList();
                                    arrayList3.add(new Facet(ExifInterface.TAG_MODEL, obj2));
                                    arrayList.add(new Searche("", arrayList3, "", (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null));
                                }
                            } else {
                                throw new TypeCastException(str4);
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                    } else {
                        arrayList.add(BDTUtils.INSTANCE.getSearchesObj(facetXX));
                    }
                }
            } else {
                if (pair != null) {
                    num = pair.getSecond();
                }
                this.fastSearchRequestBody = new FastSearchRequestBody("", 1, true, true, false, (List<String>) null, num, 100, latLong, arrayList, CollectionsKt.arrayListOf(sort), new ArrayList(), false, false, false, 0, String.valueOf(this.zipCode), (SavedSearch) null);
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
                FastSearchRequestBody fastSearchRequestBody2 = this.fastSearchRequestBody;
                if (fastSearchRequestBody2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fastSearchRequestBody");
                }
                fastSearchFilterViewModel.fetchRefinerResultList(fastSearchRequestBody2, format);
                StringBuilder sb = new StringBuilder();
                sb.append("RequestBody: ");
                FastSearchRequestBody fastSearchRequestBody3 = this.fastSearchRequestBody;
                if (fastSearchRequestBody3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fastSearchRequestBody");
                }
                sb.append(fastSearchRequestBody3);
                Log.e("TEST", sb.toString());
                subscribeToViewModel();
                return;
            }
        }
    }

    private final void loadRefinerResultForSavedSearch(String str, long j, boolean z) {
        String str2;
        String str3;
        SavedSearch savedSearch;
        showLoadingIndicator(true);
        Sort sort = new Sort(this.sortValue, this.isGeoSort, this.sortField);
        LatLong latLong = new LatLong(this.latitude, this.longitude);
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            List split$default = StringsKt.split$default(charSequence, new String[]{"="}, false, 0, 6, (Object) null);
            if (split$default.size() > 2) {
                str2 = (String) split$default.get(2);
                str3 = ((String) split$default.get(1)) + '=' + ((String) split$default.get(2));
            } else {
                str3 = (String) split$default.get(1);
                str2 = "";
            }
        } else {
            str3 = "";
            str2 = str3;
        }
        if (z) {
            savedSearch = new SavedSearch(str3, 120, 0, str2);
        } else {
            savedSearch = new SavedSearch(str3, 120, j, str2);
        }
        ArrayList arrayList = new ArrayList();
        Pair pair = null;
        arrayList.add(new Searche("", new ArrayList(), "", (ArrayList<LongDiscretes>) null, (ArrayList<LongRangesData>) null));
        this.fastSearchRequestBody = new FastSearchRequestBody("", 1, true, true, false, (List<String>) null, (Integer) null, 100, latLong, arrayList, CollectionsKt.arrayListOf(sort), new ArrayList(), false, false, false, 0, String.valueOf(this.zipCode), savedSearch);
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
        FastSearchRequestBody fastSearchRequestBody2 = this.fastSearchRequestBody;
        if (fastSearchRequestBody2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchRequestBody");
        }
        fastSearchFilterViewModel.fetchRefinerResultList(fastSearchRequestBody2, format);
        StringBuilder sb = new StringBuilder();
        sb.append("RequestBody: ");
        FastSearchRequestBody fastSearchRequestBody3 = this.fastSearchRequestBody;
        if (fastSearchRequestBody3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchRequestBody");
        }
        sb.append(fastSearchRequestBody3);
        Log.e("TEST", sb.toString());
        subscribeToViewModel();
    }

    private final void subscribeToViewModel() {
        FastSearchFilterViewModel fastSearchFilterViewModel = this.viewModel;
        if (fastSearchFilterViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LiveData<PagedList<FormattedResult>> vehicleLiveData = fastSearchFilterViewModel.getVehicleLiveData();
        RefinerResultActivity refinerResultActivity2 = this.refinerResultActivity;
        if (refinerResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        vehicleLiveData.observe(refinerResultActivity2, new RefinerResultFragment$subscribeToViewModel$1(this));
        FastSearchFilterViewModel fastSearchFilterViewModel2 = this.viewModel;
        if (fastSearchFilterViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LiveData<Integer> vehicleTotalCount = fastSearchFilterViewModel2.getVehicleTotalCount();
        RefinerResultActivity refinerResultActivity3 = this.refinerResultActivity;
        if (refinerResultActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        vehicleTotalCount.observe(refinerResultActivity3, new RefinerResultFragment$subscribeToViewModel$2(this));
        FastSearchFilterViewModel fastSearchFilterViewModel3 = this.viewModel;
        if (fastSearchFilterViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LiveData<NetworkState> networkState = fastSearchFilterViewModel3.getNetworkState();
        RefinerResultActivity refinerResultActivity4 = this.refinerResultActivity;
        if (refinerResultActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        networkState.observe(refinerResultActivity4, new RefinerResultFragment$subscribeToViewModel$3(this));
        FastSearchFilterViewModel fastSearchFilterViewModel4 = this.viewModel;
        if (fastSearchFilterViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LiveData<FastSearchRequestBody> selectedFacets2 = fastSearchFilterViewModel4.getSelectedFacets();
        RefinerResultActivity refinerResultActivity5 = this.refinerResultActivity;
        if (refinerResultActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        selectedFacets2.observe(refinerResultActivity5, new RefinerResultFragment$subscribeToViewModel$4(this));
        FastSearchFilterViewModel fastSearchFilterViewModel5 = this.viewModel;
        if (fastSearchFilterViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<UpdateWatchListResponse> watchStatusResponse = fastSearchFilterViewModel5.getWatchStatusResponse();
        RefinerResultActivity refinerResultActivity6 = this.refinerResultActivity;
        if (refinerResultActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        watchStatusResponse.observe(refinerResultActivity6, new RefinerResultFragment$subscribeToViewModel$5(this));
        FastSearchFilterViewModel fastSearchFilterViewModel6 = this.viewModel;
        if (fastSearchFilterViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> watchStatusError = fastSearchFilterViewModel6.getWatchStatusError();
        RefinerResultActivity refinerResultActivity7 = this.refinerResultActivity;
        if (refinerResultActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        watchStatusError.observe(refinerResultActivity7, new RefinerResultFragment$subscribeToViewModel$6(this));
    }

    @NotNull
    public final RefinerHeaderAdapter.OnRefinerHeaderItemClickListener getHeaderClickListener() {
        return this.headerClickListener;
    }

    public final void setHeaderClickListener(@NotNull RefinerHeaderAdapter.OnRefinerHeaderItemClickListener onRefinerHeaderItemClickListener) {
        Intrinsics.checkParameterIsNotNull(onRefinerHeaderItemClickListener, "<set-?>");
        this.headerClickListener = onRefinerHeaderItemClickListener;
    }

    /* access modifiers changed from: private */
    public final void updateGlobalArrayForSelectedFacet() {
        BDTUtils.INSTANCE.getGlobalItemList().clear();
        BDTUtils.INSTANCE.getGlobalItemList().addAll(this.selectedFacets);
        ArrayList arrayList = new ArrayList();
        for (SelectedRefinerIndicesModel selectedRefinerIndicesModel : this.selectedIndices) {
            arrayList.add(new Triple(Integer.valueOf(selectedRefinerIndicesModel.getTabPosition()), Integer.valueOf(selectedRefinerIndicesModel.getParentPosition()), Integer.valueOf(selectedRefinerIndicesModel.getChildPosition())));
        }
        BDTUtils.INSTANCE.getGlobalIndicesList().clear();
        BDTUtils.INSTANCE.getGlobalIndicesList().addAll(arrayList);
    }

    /* access modifiers changed from: private */
    public final SortOptionData createSortOptionData(String str, int i, boolean z) {
        String str2 = str;
        boolean z2 = z;
        String str3 = "LiveDateTime";
        switch (i) {
            case 0:
                return new SortOptionData(str2, str3, "0", z2);
            case 1:
                return new SortOptionData(str2, str3, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 2:
                return new SortOptionData(str2, "BranchName", "0", z2);
            case 3:
                return new SortOptionData(str2, "BranchName", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 4:
                return new SortOptionData(str2, "Year", "0", z2);
            case 5:
                return new SortOptionData(str2, "Year", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 6:
                return new SortOptionData(str2, ExifInterface.TAG_MAKE, "0", z2);
            case 7:
                return new SortOptionData(str2, ExifInterface.TAG_MAKE, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 8:
                return new SortOptionData(str2, ExifInterface.TAG_MODEL, "0", z2);
            case 9:
                return new SortOptionData(str2, ExifInterface.TAG_MODEL, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 10:
                return new SortOptionData(str2, "Series", "0", z2);
            case 11:
                return new SortOptionData(str2, "Series", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 12:
                return new SortOptionData(str2, "Stockno", "0", z2);
            case 13:
                return new SortOptionData(str2, "Stockno", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 14:
                return new SortOptionData(str2, "VIN", "0", z2);
            case 15:
                return new SortOptionData(str2, "VIN", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 16:
                return new SortOptionData(str2, "Odometer", "0", z2);
            case 17:
                return new SortOptionData(str2, "Odometer", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 18:
                return new SortOptionData(str2, "AuctionLane", "0", z2);
            case 19:
                return new SortOptionData(str2, "AuctionLane", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 20:
                return new SortOptionData(str2, "RunAndDrive", "0", z2);
            case 21:
                return new SortOptionData(str2, "RunAndDrive", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 22:
                return new SortOptionData(str2, "Vehicletitle", "0", z2);
            case 23:
                return new SortOptionData(str2, "Vehicletitle", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 24:
                return new SortOptionData(str2, "LossType", "0", z2);
            case 25:
                return new SortOptionData(str2, "LossType", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 26:
                return new SortOptionData(str2, "PrimaryDamage", "0", z2);
            case 27:
                return new SortOptionData(str2, "PrimaryDamage", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            case 28:
                return new SortOptionData(str2, "TenantDesc", "0", z2);
            case 29:
                return new SortOptionData(str2, "TenantDesc", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
            default:
                return new SortOptionData(str2, str3, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z2);
        }
    }

    /* access modifiers changed from: private */
    public final void addHeaderOnResultList(boolean z, BaseFragment.ErrorType errorType2) {
        String str;
        ArrayList arrayList = new ArrayList();
        for (SelectedRefinerIndicesModel selectedRefinerIndicesModel : this.selectedIndices) {
            arrayList.add(new Triple(Integer.valueOf(selectedRefinerIndicesModel.getTabPosition()), Integer.valueOf(selectedRefinerIndicesModel.getParentPosition()), Integer.valueOf(selectedRefinerIndicesModel.getChildPosition())));
        }
        if (z) {
            BDTUtils bDTUtils = BDTUtils.INSTANCE;
            RefinerResultActivity refinerResultActivity2 = this.refinerResultActivity;
            if (refinerResultActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
            }
            str = bDTUtils.getErrorType(refinerResultActivity2, BaseFragment.ErrorType.NO_STOCKS);
        } else {
            str = "";
        }
        ArrayList<FacetXX> arrayList2 = this.selectedFacets;
        RefinerResultHeaderModel refinerResultHeaderModel = new RefinerResultHeaderModel(arrayList2, arrayList, arrayList2.size(), str, z);
        RefinerResultListAdapter refinerResultListAdapter2 = this.refinerResultListAdapter;
        if (refinerResultListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultListAdapter");
        }
        refinerResultListAdapter2.setHeaderItem(refinerResultHeaderModel, this);
        RefinerResultListAdapter refinerResultListAdapter3 = this.refinerResultListAdapter;
        if (refinerResultListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultListAdapter");
        }
        refinerResultListAdapter3.submitList((PagedList) null);
        RefinerResultListAdapter refinerResultListAdapter4 = this.refinerResultListAdapter;
        if (refinerResultListAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultListAdapter");
        }
        refinerResultListAdapter4.notifyDataSetChanged();
    }

    public final void setToolBarTitle() {
        RefinerResultActivity refinerResultActivity2 = this.refinerResultActivity;
        if (refinerResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        refinerResultActivity2.getToolbarTitle().setText(getResources().getString(C2723R.string.lbl_search));
        RefinerResultActivity refinerResultActivity3 = this.refinerResultActivity;
        if (refinerResultActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        refinerResultActivity3.getToolbarSubTitle().setVisibility(0);
        RefinerResultActivity refinerResultActivity4 = this.refinerResultActivity;
        if (refinerResultActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        TextView toolbarSubTitle = refinerResultActivity4.getToolbarSubTitle();
        toolbarSubTitle.setText(BDTUtils.INSTANCE.getCountDisplay(this.totalCount) + ' ' + getResources().getString(C2723R.string.lbl_results));
        RefinerResultActivity refinerResultActivity5 = this.refinerResultActivity;
        if (refinerResultActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        refinerResultActivity5.getIvStockShare().setVisibility(8);
        RefinerResultActivity refinerResultActivity6 = this.refinerResultActivity;
        if (refinerResultActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        TextView textView = (TextView) refinerResultActivity6._$_findCachedViewById(C2723R.C2726id.tvSavedSearch);
        Intrinsics.checkExpressionValueIsNotNull(textView, "refinerResultActivity.tvSavedSearch");
        textView.setVisibility(0);
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            loadRefinerResult();
            return;
        }
        this.errorType = BaseFragment.ErrorType.NO_INTERNET;
        this.isError = true;
        boolean z = this.isError;
        BaseFragment.ErrorType errorType2 = this.errorType;
        if (errorType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorType");
        }
        addHeaderOnResultList(z, errorType2);
        InternetUtil internetUtil = InternetUtil.INSTANCE;
        RefinerResultActivity refinerResultActivity2 = this.refinerResultActivity;
        if (refinerResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        internetUtil.observe(refinerResultActivity2, new RefinerResultFragment$checkNetworkConnection$1(this));
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbRefinerResult);
            if (progressBar != null) {
                progressBar.setVisibility(0);
                return;
            }
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbRefinerResult);
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r0v6, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r5, int r6, @org.jetbrains.annotations.Nullable android.content.Intent r7) {
        /*
            r4 = this;
            super.onActivityResult(r5, r6, r7)
            r6 = 26
            if (r5 == r6) goto L_0x01cf
            r6 = 44
            if (r5 == r6) goto L_0x01ad
            r6 = 100
            r0 = 0
            if (r5 == r6) goto L_0x017f
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L_0x01d2
            java.lang.String r6 = ""
            r1 = 1
            r2 = 0
            switch(r5) {
                case 104: goto L_0x0131;
                case 105: goto L_0x005e;
                case 106: goto L_0x001d;
                default: goto L_0x001b;
            }
        L_0x001b:
            goto L_0x01d2
        L_0x001d:
            if (r7 == 0) goto L_0x01d2
            r4.zipCode = r2
            android.os.Bundle r5 = r7.getExtras()
            if (r5 == 0) goto L_0x0030
            java.lang.String r7 = "saved_Search_Param"
            java.lang.String r5 = r5.getString(r7)
            if (r5 == 0) goto L_0x0030
            goto L_0x0031
        L_0x0030:
            r5 = r6
        L_0x0031:
            com.google.gson.Gson r6 = new com.google.gson.Gson
            r6.<init>()
            java.lang.Class<com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse> r7 = com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse.class
            java.lang.Object r5 = r6.fromJson((java.lang.String) r5, r7)
            com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse r5 = (com.iaai.android.bdt.model.savedSearchList.SavedSearchListResponse) r5
            java.lang.String r6 = r5.getSearchUrl()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            java.lang.Long r7 = r5.getSavedSearchLogId()
            if (r7 == 0) goto L_0x0051
            long r2 = r7.longValue()
            goto L_0x0053
        L_0x0051:
            r2 = 0
        L_0x0053:
            boolean r5 = r5.getIsaNewSearch()
            r4.loadRefinerResultForSavedSearch(r6, r2, r5)
            r4.isFromSavedSearchList = r1
            goto L_0x01d2
        L_0x005e:
            if (r7 == 0) goto L_0x01d2
            android.os.Bundle r5 = r7.getExtras()
            if (r5 == 0) goto L_0x006d
            java.lang.String r6 = "search_selected_sort_position"
            int r5 = r5.getInt(r6)
            goto L_0x006e
        L_0x006d:
            r5 = 0
        L_0x006e:
            r4.lastSelectedSort = r5
            android.os.Bundle r5 = r7.getExtras()
            if (r5 == 0) goto L_0x0081
            java.lang.String r6 = "search_selected_sort"
            android.os.Parcelable r5 = r5.getParcelable(r6)
            com.iaai.android.bdt.model.sort.SortOptionData r5 = (com.iaai.android.bdt.model.sort.SortOptionData) r5
            if (r5 == 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r5 = r0
        L_0x0082:
            r4.sortOptionData = r5
            r5 = 0
            r4.latitude = r5
            r4.longitude = r5
            r4.isGeoSort = r2
            com.iaai.android.bdt.model.sort.SortOptionData r5 = r4.sortOptionData
            if (r5 == 0) goto L_0x0095
            java.lang.String r5 = r5.getDisplayText()
            goto L_0x0096
        L_0x0095:
            r5 = r0
        L_0x0096:
            java.lang.String r6 = "my_location"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x00a7
            r4.isGeoSort = r1
            r4.requestCurrentLocationData()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            goto L_0x01d2
        L_0x00a7:
            com.iaai.android.bdt.model.sort.SortOptionData r5 = r4.sortOptionData
            if (r5 == 0) goto L_0x00b0
            java.lang.String r5 = r5.getDisplayText()
            goto L_0x00b1
        L_0x00b0:
            r5 = r0
        L_0x00b1:
            java.lang.String r6 = "zip_code"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x00fa
            com.iaai.android.bdt.model.sort.SortOptionData r5 = r4.sortOptionData
            if (r5 == 0) goto L_0x01d2
            if (r5 == 0) goto L_0x00c4
            java.lang.String r5 = r5.getSortKey()
            goto L_0x00c5
        L_0x00c4:
            r5 = r0
        L_0x00c5:
            if (r5 == 0) goto L_0x01d2
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r5 = r4.refinerResultActivity
            if (r5 != 0) goto L_0x00d0
            java.lang.String r6 = "refinerResultActivity"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x00d0:
            android.content.Context r5 = (android.content.Context) r5
            com.iaai.android.bdt.model.sort.SortOptionData r6 = r4.sortOptionData
            if (r6 == 0) goto L_0x00db
            java.lang.String r6 = r6.getSortKey()
            goto L_0x00dc
        L_0x00db:
            r6 = r0
        L_0x00dc:
            java.lang.String r6 = java.lang.String.valueOf(r6)
            com.iaai.android.bdt.extensions.Context_ExtensionKt.getLatLng(r5, r6)
            com.iaai.android.bdt.model.sort.SortOptionData r5 = r4.sortOptionData
            if (r5 == 0) goto L_0x00eb
            java.lang.String r0 = r5.getSortKey()
        L_0x00eb:
            java.lang.String r5 = java.lang.String.valueOf(r0)
            int r5 = java.lang.Integer.parseInt(r5)
            r4.zipCode = r5
            r4.loadRefinerResult()
            goto L_0x01d2
        L_0x00fa:
            com.iaai.android.bdt.model.sort.SortOptionData r5 = r4.sortOptionData
            if (r5 == 0) goto L_0x01d2
            if (r5 == 0) goto L_0x0105
            java.lang.String r5 = r5.getSortKey()
            goto L_0x0106
        L_0x0105:
            r5 = r0
        L_0x0106:
            if (r5 == 0) goto L_0x01d2
            r4.zipCode = r2
            com.iaai.android.bdt.model.sort.SortOptionData r5 = r4.sortOptionData
            if (r5 == 0) goto L_0x0112
            java.lang.String r0 = r5.getSortKey()
        L_0x0112:
            java.lang.String r5 = java.lang.String.valueOf(r0)
            r4.sortField = r5
            com.iaai.android.bdt.model.sort.SortOptionData r5 = r4.sortOptionData
            if (r5 == 0) goto L_0x012a
            java.lang.String r5 = r5.getSortDirection()
            if (r5 == 0) goto L_0x012a
            int r5 = java.lang.Integer.parseInt(r5)
            if (r5 == 0) goto L_0x0129
            goto L_0x012a
        L_0x0129:
            r1 = 0
        L_0x012a:
            r4.sortValue = r1
            r4.loadRefinerResult()
            goto L_0x01d2
        L_0x0131:
            if (r7 == 0) goto L_0x01d2
            android.os.Bundle r5 = r7.getExtras()
            if (r5 == 0) goto L_0x0142
            java.lang.String r7 = "searchinput"
            java.lang.String r5 = r5.getString(r7, r6)
            if (r5 == 0) goto L_0x0142
            goto L_0x0143
        L_0x0142:
            r5 = r6
        L_0x0143:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Sending Event: "
            r6.append(r7)
            com.iaai.android.bdt.analytics.IAAAnalytics$IAAEvents r7 = com.iaai.android.bdt.analytics.IAAAnalytics.IAAEvents.FIND_VEHICLE_KEYWORD_USAGE
            java.lang.String r7 = r7.getId()
            r6.append(r7)
            java.lang.String r7 = " :"
            r6.append(r7)
            r6.append(r5)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "FIRE_BASE_ANALYTICS"
            android.util.Log.e(r7, r6)
            com.iaai.android.bdt.analytics.IAAAnalytics r6 = com.iaai.android.bdt.analytics.IAAAnalytics.INSTANCE
            com.iaai.android.bdt.analytics.IAAAnalytics$IAAEvents r7 = com.iaai.android.bdt.analytics.IAAAnalytics.IAAEvents.FIND_VEHICLE_KEYWORD_USAGE
            r6.logIAAEvent(r7, r0)
            r6 = r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = kotlin.text.StringsKt.isBlank(r6)
            r6 = r6 ^ r1
            if (r6 == 0) goto L_0x01d2
            r4.updateKeywordSearch(r5)
            r4.loadRefinerResult()
            goto L_0x01d2
        L_0x017f:
            if (r7 == 0) goto L_0x01d2
            android.os.Bundle r5 = r7.getExtras()
            if (r5 == 0) goto L_0x018e
            java.lang.String r6 = "extra_selected_facets"
            java.util.ArrayList r5 = r5.getParcelableArrayList(r6)
            goto L_0x018f
        L_0x018e:
            r5 = r0
        L_0x018f:
            if (r5 != 0) goto L_0x0194
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0194:
            r4.selectedFacets = r5
            android.os.Bundle r5 = r7.getExtras()
            if (r5 == 0) goto L_0x01a2
            java.lang.String r6 = "extra_selected_indices"
            java.util.ArrayList r0 = r5.getParcelableArrayList(r6)
        L_0x01a2:
            if (r0 != 0) goto L_0x01a7
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x01a7:
            r4.selectedIndices = r0
            r4.loadRefinerResult()
            goto L_0x01d2
        L_0x01ad:
            com.iaai.android.bdt.feature.login.SessionManager r5 = r4.sessionManager
            if (r5 != 0) goto L_0x01b6
            java.lang.String r6 = "sessionManager"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x01b6:
            boolean r5 = r5.isLoggedIn()
            if (r5 == 0) goto L_0x01d2
            android.content.Intent r5 = new android.content.Intent
            androidx.fragment.app.FragmentActivity r6 = r4.getActivity()
            android.content.Context r6 = (android.content.Context) r6
            java.lang.Class<com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchActivity> r7 = com.iaai.android.bdt.feature.fastSearchFilter.savedSearch.SavedSearchActivity.class
            r5.<init>(r6, r7)
            r6 = 106(0x6a, float:1.49E-43)
            r4.startActivityForResult(r5, r6)
            goto L_0x01d2
        L_0x01cf:
            r4.updateWatchStatus()
        L_0x01d2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    private final void updateKeywordSearch(String str) {
        int size = this.selectedFacets.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            FacetXX facetXX = this.selectedFacets.get(i);
            if (Intrinsics.areEqual((Object) facetXX != null ? facetXX.getRefinerValue() : null, (Object) "keyword")) {
                break;
            }
            i++;
        }
        if (i != -1) {
            this.selectedFacets.remove(i);
            this.selectedIndices.remove(i);
        }
        int size2 = BDTUtils.INSTANCE.getGlobalItemList().size();
        int i2 = 0;
        while (true) {
            if (i2 >= size2) {
                i2 = -1;
                break;
            }
            FacetXX facetXX2 = BDTUtils.INSTANCE.getGlobalItemList().get(i2);
            if (Intrinsics.areEqual((Object) facetXX2 != null ? facetXX2.getRefinerValue() : null, (Object) "keyword")) {
                break;
            }
            i2++;
        }
        if (i2 != -1) {
            BDTUtils.INSTANCE.getGlobalItemList().remove(i2);
            BDTUtils.INSTANCE.getGlobalIndicesList().remove(i2);
        }
        FacetXX facetXX3 = new FacetXX(0, str, "keyword", true);
        this.selectedFacets.add(facetXX3);
        BDTUtils.INSTANCE.getGlobalItemList().add(facetXX3);
        SelectedRefinerIndicesModel selectedRefinerIndicesModel = new SelectedRefinerIndicesModel(4, 0, "keyword".hashCode());
        Triple triple = new Triple(4, 0, Integer.valueOf("keyword".hashCode()));
        this.selectedIndices.add(selectedRefinerIndicesModel);
        BDTUtils.INSTANCE.getGlobalIndicesList().add(triple);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: java.lang.Integer} */
    /* JADX WARNING: type inference failed for: r0v3 */
    /* JADX WARNING: type inference failed for: r0v13 */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void navigateToProductDetailsPage(com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult r11, int r12) {
        /*
            r10 = this;
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r0 = r10.refinerResultActivity
            java.lang.String r1 = "refinerResultActivity"
            if (r0 != 0) goto L_0x0009
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0009:
            int r2 = com.iaai.android.C2723R.C2726id.tvSavedSearch
            android.view.View r0 = r0._$_findCachedViewById(r2)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r2 = "refinerResultActivity.tvSavedSearch"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            r2 = 8
            r0.setVisibility(r2)
            r0 = 0
            if (r11 == 0) goto L_0x0023
            java.lang.Integer r3 = r11.getItemId()
            goto L_0x0024
        L_0x0023:
            r3 = r0
        L_0x0024:
            java.lang.String r3 = java.lang.String.valueOf(r3)
            if (r11 == 0) goto L_0x002f
            java.lang.String r4 = r11.getTenant()
            goto L_0x0030
        L_0x002f:
            r4 = r0
        L_0x0030:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>()
            java.lang.String r6 = "itemId"
            r5.putString(r6, r3)
            boolean r7 = r10.isTablet
            java.lang.String r8 = "refinerResultListAdapter"
            if (r7 == 0) goto L_0x0088
            if (r11 == 0) goto L_0x004a
            java.lang.Integer r0 = r11.getItemId()
        L_0x004a:
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r11 = r10.refinerResultListAdapter
            if (r11 != 0) goto L_0x0051
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
        L_0x0051:
            r11.setSelectedItemForTablet(r0)
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r11 = r10.refinerResultListAdapter
            if (r11 != 0) goto L_0x005b
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
        L_0x005b:
            r11.notifyDataSetChanged()
            androidx.fragment.app.FragmentManager r11 = r10.getChildFragmentManager()
            r12 = 2131296449(0x7f0900c1, float:1.8210815E38)
            androidx.fragment.app.Fragment r11 = r11.findFragmentById(r12)
            if (r11 == 0) goto L_0x0080
            androidx.navigation.fragment.NavHostFragment r11 = (androidx.navigation.fragment.NavHostFragment) r11
            androidx.navigation.NavController r12 = r11.getNavController()
            r12.popBackStack()
            androidx.navigation.NavController r11 = r11.getNavController()
            r12 = 2131296297(0x7f090029, float:1.8210507E38)
            r11.navigate((int) r12, (android.os.Bundle) r5)
            goto L_0x0248
        L_0x0080:
            kotlin.TypeCastException r11 = new kotlin.TypeCastException
            java.lang.String r12 = "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment"
            r11.<init>(r12)
            throw r11
        L_0x0088:
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            boolean r9 = r10.isSingleSearchProductDeatil
            if (r9 == 0) goto L_0x009d
            r5.add(r3)
            r7.add(r4)
            goto L_0x00d5
        L_0x009d:
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultListAdapter r3 = r10.refinerResultListAdapter
            if (r3 != 0) goto L_0x00a4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
        L_0x00a4:
            if (r3 == 0) goto L_0x00d5
            androidx.paging.PagedList r3 = r3.getCurrentList()
            if (r3 == 0) goto L_0x00d5
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x00b2:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x00d5
            java.lang.Object r4 = r3.next()
            com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult r4 = (com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult) r4
            java.lang.Integer r8 = r4.getItemId()
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r5.add(r8)
            java.lang.String r4 = r4.getTenant()
            java.lang.String r4 = r4.toString()
            r7.add(r4)
            goto L_0x00b2
        L_0x00d5:
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            if (r11 == 0) goto L_0x00e1
            java.lang.Integer r4 = r11.getItemId()
            goto L_0x00e2
        L_0x00e1:
            r4 = r0
        L_0x00e2:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r3.putString(r6, r4)
            java.lang.String r4 = "item_ids_list"
            r3.putStringArrayList(r4, r5)
            java.lang.String r4 = "position"
            r3.putInt(r4, r12)
            if (r11 == 0) goto L_0x00fa
            java.lang.String r5 = r11.getLiveDate()
            goto L_0x00fb
        L_0x00fa:
            r5 = r0
        L_0x00fb:
            java.lang.String r6 = "AuctionDate"
            r3.putString(r6, r5)
            if (r11 == 0) goto L_0x0107
            java.lang.Integer r5 = r11.getBranchNumber()
            goto L_0x0108
        L_0x0107:
            r5 = r0
        L_0x0108:
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r6 = "branchId"
            r3.putString(r6, r5)
            int r5 = r10.currentCount
            java.lang.String r6 = "currentCount"
            r3.putInt(r6, r5)
            int r5 = r10.totalCount
            java.lang.String r6 = "totalCount"
            r3.putInt(r6, r5)
            r3.putInt(r4, r12)
            com.google.gson.Gson r4 = new com.google.gson.Gson
            r4.<init>()
            com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody r5 = r10.fastSearchRequestBody
            if (r5 != 0) goto L_0x0130
            java.lang.String r6 = "fastSearchRequestBody"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
        L_0x0130:
            java.lang.String r4 = r4.toJson((java.lang.Object) r5)
            java.lang.String r5 = "fastSearchParam"
            r3.putString(r5, r4)
            java.lang.String r4 = "countryCode"
            r3.putStringArrayList(r4, r7)
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r4 = r10.refinerResultActivity
            if (r4 != 0) goto L_0x0145
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0145:
            android.app.Activity r4 = (android.app.Activity) r4
            r5 = 2131297604(0x7f090544, float:1.8213158E38)
            androidx.navigation.NavController r4 = androidx.navigation.Navigation.findNavController(r4, r5)
            java.lang.String r5 = "Navigation.findNavContro…d.main_nav_host_fragment)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            androidx.navigation.NavDestination r5 = r4.getCurrentDestination()
            if (r5 == 0) goto L_0x0168
            int r5 = r5.getId()
            r6 = 2131296302(0x7f09002e, float:1.8210517E38)
            if (r5 != r6) goto L_0x0168
            r5 = 2131296365(0x7f09006d, float:1.8210645E38)
            r4.navigate((int) r5, (android.os.Bundle) r3)
        L_0x0168:
            int r3 = r10.totalCount
            r4 = 1
            if (r3 <= r4) goto L_0x01f6
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r11 = r10.refinerResultActivity
            if (r11 != 0) goto L_0x0174
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0174:
            int r0 = com.iaai.android.C2723R.C2726id.toolbar_relativelayout
            android.view.View r11 = r11._$_findCachedViewById(r0)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            java.lang.String r0 = "refinerResultActivity.toolbar_relativelayout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r11, r0)
            r3 = 8388613(0x800005, float:1.175495E-38)
            r11.setGravity(r3)
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r11 = r10.refinerResultActivity
            if (r11 != 0) goto L_0x018e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x018e:
            int r3 = com.iaai.android.C2723R.C2726id.toolbar_relativelayout
            android.view.View r11 = r11._$_findCachedViewById(r3)
            android.widget.RelativeLayout r11 = (android.widget.RelativeLayout) r11
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r11, r0)
            r0 = 5
            r11.setGravity(r0)
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r11 = r10.refinerResultActivity
            if (r11 != 0) goto L_0x01a4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x01a4:
            android.widget.TextView r11 = r11.getToolbarTitle()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            int r12 = r12 + r4
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r0.append(r12)
            java.lang.String r12 = " of "
            r0.append(r12)
            com.iaai.android.bdt.utils.BDTUtils r12 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            int r3 = r10.totalCount
            java.lang.String r12 = r12.getCountDisplay(r3)
            r0.append(r12)
            java.lang.String r12 = r0.toString()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r11.setText(r12)
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r11 = r10.refinerResultActivity
            if (r11 != 0) goto L_0x01d5
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x01d5:
            android.widget.TextView r11 = r11.getToolbarTitle()
            android.content.res.Resources r12 = r10.getResources()
            r0 = 2131099697(0x7f060031, float:1.7811755E38)
            int r12 = r12.getColor(r0)
            r11.setTextColor(r12)
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r11 = r10.refinerResultActivity
            if (r11 != 0) goto L_0x01ee
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x01ee:
            android.widget.TextView r11 = r11.getToolbarSubTitle()
            r11.setVisibility(r2)
            goto L_0x0248
        L_0x01f6:
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r12 = r10.refinerResultActivity
            if (r12 != 0) goto L_0x01fd
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x01fd:
            android.widget.TextView r12 = r12.getToolbarTitle()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            if (r11 == 0) goto L_0x020d
            java.lang.Integer r4 = r11.getYear()
            goto L_0x020e
        L_0x020d:
            r4 = r0
        L_0x020e:
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r3.append(r4)
            java.lang.String r4 = " "
            r3.append(r4)
            if (r11 == 0) goto L_0x0221
            java.lang.String r5 = r11.getMake()
            goto L_0x0222
        L_0x0221:
            r5 = r0
        L_0x0222:
            r3.append(r5)
            r3.append(r4)
            if (r11 == 0) goto L_0x022e
            java.lang.String r0 = r11.getModel()
        L_0x022e:
            r3.append(r0)
            java.lang.String r11 = r3.toString()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r12.setText(r11)
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r11 = r10.refinerResultActivity
            if (r11 != 0) goto L_0x0241
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0241:
            android.widget.TextView r11 = r11.getToolbarSubTitle()
            r11.setVisibility(r2)
        L_0x0248:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment.navigateToProductDetailsPage(com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult, int):void");
    }

    /* access modifiers changed from: private */
    public final void navigateToProductDetailsPageForSingle(FormattedResult formattedResult, int i) {
        String str;
        PagedList<FormattedResult> currentList;
        String str2 = null;
        if (this.isTablet) {
            String valueOf = String.valueOf(formattedResult != null ? formattedResult.getItemId() : null);
            StringBuilder sb = new StringBuilder();
            sb.append(formattedResult != null ? formattedResult.getYear() : null);
            sb.append(' ');
            sb.append(formattedResult != null ? formattedResult.getMake() : null);
            sb.append(' ');
            if (formattedResult != null) {
                str2 = formattedResult.getModel();
            }
            sb.append(str2);
            sb.append(' ');
            String sb2 = sb.toString();
            RefinerResultActivity refinerResultActivity2 = this.refinerResultActivity;
            if (refinerResultActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
            }
            Intent intent = new Intent(refinerResultActivity2, ProductDetailActivity.class);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.putExtra(Constants.EXTRA_ITEM_ID, valueOf);
            intent.putExtra("isFromSearchVehicle", false);
            intent.putExtra(Constants.EXTRA_YEAR_MAKE_MODEL, sb2);
            startActivity(intent);
            return;
        }
        String valueOf2 = String.valueOf(formattedResult != null ? formattedResult.getItemId() : null);
        if ((formattedResult != null ? formattedResult.getTenant() : null) != null) {
            str = (formattedResult != null ? formattedResult.getTenant() : null).toString();
        } else {
            str = "";
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (this.isSingleSearchProductDeatil) {
            arrayList.add(valueOf2);
            arrayList2.add(str);
        } else {
            RefinerResultListAdapter refinerResultListAdapter2 = this.refinerResultListAdapter;
            if (refinerResultListAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerResultListAdapter");
            }
            if (!(refinerResultListAdapter2 == null || (currentList = refinerResultListAdapter2.getCurrentList()) == null)) {
                for (FormattedResult itemId : currentList) {
                    arrayList.add(String.valueOf(itemId.getItemId()));
                }
            }
        }
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EXTRA_ITEM_ID, String.valueOf(formattedResult != null ? formattedResult.getItemId() : null));
        bundle.putStringArrayList(Constants_MVVM.EXTRA_ITEM_IDS_LIST, arrayList);
        bundle.putInt(Constants_MVVM.EXTRA_ITEM_POSITION, i);
        bundle.putString(Constants_MVVM.EXTRA_AUCTION_DATE, formattedResult != null ? formattedResult.getLiveDate() : null);
        bundle.putString(Constants_MVVM.EXTRA_BRANCH_ID, String.valueOf(formattedResult != null ? formattedResult.getBranchNumber() : null));
        bundle.putInt(Constants_MVVM.EXTRA_CURRENT_COUNT, this.currentCount);
        bundle.putInt(Constants_MVVM.EXTRA_TOTAL_COUNT, this.totalCount);
        bundle.putInt(Constants_MVVM.EXTRA_ITEM_POSITION, i);
        Gson gson = new Gson();
        FastSearchRequestBody fastSearchRequestBody2 = this.fastSearchRequestBody;
        if (fastSearchRequestBody2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fastSearchRequestBody");
        }
        bundle.putString(Constants_MVVM.EXTRA_FAST_SEARCH_PARAM, gson.toJson((Object) fastSearchRequestBody2));
        bundle.putStringArrayList("countryCode", arrayList2);
        RefinerResultActivity refinerResultActivity3 = this.refinerResultActivity;
        if (refinerResultActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        NavController findNavController = Navigation.findNavController(refinerResultActivity3, C2723R.C2726id.main_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
        NavDestination currentDestination = findNavController.getCurrentDestination();
        if (currentDestination != null && currentDestination.getId() == C2723R.C2726id.RefinerResultFragment) {
            findNavController.navigate((int) C2723R.C2726id.action_ACFragment_to_View_Pager_PDFragment, bundle);
        }
        if (this.totalCount > 1) {
            RefinerResultActivity refinerResultActivity4 = this.refinerResultActivity;
            if (refinerResultActivity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
            }
            RelativeLayout relativeLayout = (RelativeLayout) refinerResultActivity4._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "refinerResultActivity.toolbar_relativelayout");
            relativeLayout.setGravity(GravityCompat.END);
            RefinerResultActivity refinerResultActivity5 = this.refinerResultActivity;
            if (refinerResultActivity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) refinerResultActivity5._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "refinerResultActivity.toolbar_relativelayout");
            relativeLayout2.setGravity(5);
            RefinerResultActivity refinerResultActivity6 = this.refinerResultActivity;
            if (refinerResultActivity6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
            }
            TextView toolbarTitle = refinerResultActivity6.getToolbarTitle();
            toolbarTitle.setText(String.valueOf(i + 1) + " of " + BDTUtils.INSTANCE.getCountDisplay(this.totalCount));
            RefinerResultActivity refinerResultActivity7 = this.refinerResultActivity;
            if (refinerResultActivity7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
            }
            refinerResultActivity7.getToolbarTitle().setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darker));
            RefinerResultActivity refinerResultActivity8 = this.refinerResultActivity;
            if (refinerResultActivity8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
            }
            refinerResultActivity8.getToolbarSubTitle().setVisibility(8);
            return;
        }
        RefinerResultActivity refinerResultActivity9 = this.refinerResultActivity;
        if (refinerResultActivity9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        TextView toolbarTitle2 = refinerResultActivity9.getToolbarTitle();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(String.valueOf(formattedResult != null ? formattedResult.getYear() : null));
        sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb3.append(formattedResult != null ? formattedResult.getMake() : null);
        sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        if (formattedResult != null) {
            str2 = formattedResult.getModel();
        }
        sb3.append(str2);
        toolbarTitle2.setText(sb3.toString());
        RefinerResultActivity refinerResultActivity10 = this.refinerResultActivity;
        if (refinerResultActivity10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        refinerResultActivity10.getToolbarSubTitle().setVisibility(8);
    }

    private final void requestCurrentLocationData() {
        RefinerResultActivity refinerResultActivity2 = this.refinerResultActivity;
        if (refinerResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
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
        refinerResultActivity2.registerReceiver(broadcastReceiver, currentLocationManager2.getBroadcastIntentFilter());
        CurrentLocationManager currentLocationManager3 = this.currentLocationManager;
        if (currentLocationManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentLocationManager");
        }
        RefinerResultActivity refinerResultActivity3 = this.refinerResultActivity;
        if (refinerResultActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        currentLocationManager3.refreshCurrentLocation(refinerResultActivity3, true);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultFragment$CurrentLocationBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "(Lcom/iaai/android/bdt/feature/fastSearchFilter/refinerResults/RefinerResultFragment;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: RefinerResultFragment.kt */
    public final class CurrentLocationBroadcastReceiver extends BroadcastReceiver {
        public CurrentLocationBroadcastReceiver() {
        }

        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            Intrinsics.checkParameterIsNotNull(intent, "intent");
            if (Intrinsics.areEqual((Object) Constants.INTENT_CURRENT_LOCATION_UPDATE, (Object) intent.getAction())) {
                Location location = (Location) intent.getParcelableExtra("location");
                RefinerResultFragment refinerResultFragment = RefinerResultFragment.this;
                Intrinsics.checkExpressionValueIsNotNull(location, "currentLocation");
                refinerResultFragment.handleCurrentLocationBroadcastResult$app_productionRelease(location);
            } else if (Intrinsics.areEqual((Object) Constants.INTENT_CURRENT_LOCATION_NOT_AVAILABLE, (Object) intent.getAction())) {
                RefinerResultFragment.this.handleCurrentLocationNotAvailable$app_productionRelease();
            }
        }
    }

    public final void handleCurrentLocationNotAvailable$app_productionRelease() {
        RefinerResultActivity refinerResultActivity2 = this.refinerResultActivity;
        if (refinerResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        Toast.makeText(refinerResultActivity2, C2723R.string.msg_location_na_use_search, 1).show();
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
            RefinerResultActivity refinerResultActivity2 = this.refinerResultActivity;
            if (refinerResultActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
            }
            NavController findNavController = Navigation.findNavController(refinerResultActivity2, C2723R.C2726id.main_nav_host_fragment);
            Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
            boolean popBackStack = findNavController.popBackStack();
            Log.e("On Resume", "isSingleSearchProductDeatil true");
            if (!popBackStack) {
                Intent intent = new Intent();
                intent.putExtra(Constants_MVVM.EXTRA_IS_LANDING_PAGE, true);
                RefinerResultActivity refinerResultActivity3 = this.refinerResultActivity;
                if (refinerResultActivity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
                }
                intent.putExtra(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, IAASharedPreference.getRefinerSearch(refinerResultActivity3.getApplicationContext()));
                RefinerResultActivity refinerResultActivity4 = this.refinerResultActivity;
                if (refinerResultActivity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
                }
                refinerResultActivity4.setResult(103, intent);
                RefinerResultActivity refinerResultActivity5 = this.refinerResultActivity;
                if (refinerResultActivity5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
                }
                refinerResultActivity5.finish();
            }
        }
        setToolBarTitle();
    }

    public final void handleCurrentLocationBroadcastResult$app_productionRelease(@NotNull Location location) {
        Intrinsics.checkParameterIsNotNull(location, "location");
        try {
            RefinerResultActivity refinerResultActivity2 = this.refinerResultActivity;
            if (refinerResultActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
            }
            CurrentLocationBroadcastReceiver currentLocationBroadcastReceiver2 = this.currentLocationBroadcastReceiver;
            if (currentLocationBroadcastReceiver2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("currentLocationBroadcastReceiver");
            }
            refinerResultActivity2.unregisterReceiver(currentLocationBroadcastReceiver2);
        } catch (Exception unused) {
        }
        this.latitude = location.getLatitude() * ((double) 1000000);
        this.longitude = location.getLongitude() * ((double) -1000000);
        SortOptionData sortOptionData2 = this.sortOptionData;
        if (sortOptionData2 != null) {
            sortOptionData2.setSortKey("");
        }
        loadRefinerResult();
        Log.e("TEST", "LOCATION: " + this.latitude + ' ' + this.longitude);
    }

    /* access modifiers changed from: private */
    public final void updateBuyNowPrice(Triple<Integer, Integer, Integer> triple) {
        RefinerHeaderAdapter refinerHeaderAdapter;
        boolean z = true;
        if (StringsKt.equals(BDTUtils.INSTANCE.getSearchMappingArray().get(triple.getFirst().intValue()).getGroups().get(triple.getSecond().intValue()).getGroup(), "AuctionType", true)) {
            int i = -1;
            int i2 = 0;
            for (Object next : BDTUtils.INSTANCE.getSearchMappingArray().get(triple.getFirst().intValue()).getGroups()) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SearchMappingGroup searchMappingGroup = (SearchMappingGroup) next;
                if (StringsKt.equals(searchMappingGroup.getGroup(), "BuynowRange", true)) {
                    searchMappingGroup.setEnabled(false);
                    i = i2;
                }
                i2 = i3;
            }
            if (i != -1) {
                for (FacetXX selected : BDTUtils.INSTANCE.getSearchMappingArray().get(triple.getFirst().intValue()).getGroups().get(i).getListFacet()) {
                    selected.setSelected(false);
                }
                int i4 = 0;
                int i5 = -1;
                for (Object next2 : this.selectedFacets) {
                    int i6 = i4 + 1;
                    if (i4 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    FacetXX facetXX = (FacetXX) next2;
                    if (StringsKt.equals$default(facetXX != null ? facetXX.getRefinerValue() : null, "BuynowRange", false, 2, (Object) null)) {
                        i5 = i4;
                    }
                    i4 = i6;
                }
                Collection collection = this.selectedFacets;
                if (!(collection == null || collection.isEmpty()) && i5 != -1) {
                    this.selectedFacets.remove(i5);
                }
                Collection collection2 = this.selectedIndices;
                if (collection2 != null && !collection2.isEmpty()) {
                    z = false;
                }
                if (!z && i5 != -1) {
                    this.selectedIndices.remove(i5);
                }
                RefinerResultListAdapter refinerResultListAdapter2 = this.refinerResultListAdapter;
                if (refinerResultListAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refinerResultListAdapter");
                }
                if (!(refinerResultListAdapter2 == null || (refinerHeaderAdapter = refinerResultListAdapter2.getRefinerHeaderAdapter()) == null)) {
                    refinerHeaderAdapter.removeGroupFromHeaderData(i, triple.getFirst().intValue());
                }
                RefinerResultListAdapter refinerResultListAdapter3 = this.refinerResultListAdapter;
                if (refinerResultListAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("refinerResultListAdapter");
                }
                refinerResultListAdapter3.notifyDataSetChanged();
                BDTUtils.INSTANCE.getFilterData(triple.getFirst().intValue());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateWatchStatus() {
        RefinerResultActivity refinerResultActivity2 = this.refinerResultActivity;
        if (refinerResultActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultActivity");
        }
        Application application = refinerResultActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "refinerResultActivity.application");
        String userIdPreferencesMVVM = IAASharedPreference.getUserIdPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM, "IAASharedPreference.getU…ation.applicationContext)");
        this.userId = userIdPreferencesMVVM;
        FastSearchFilterViewModel fastSearchFilterViewModel = this.viewModel;
        if (fastSearchFilterViewModel == null) {
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
        fastSearchFilterViewModel.updateWatchStatus(format, String.valueOf(this.itemIdWatch), this.userId, this.action);
    }

    public void onStart() {
        super.onStart();
        if (isAdded()) {
            Boolean watchStatus = IAASharedPreference.getWatchStatus(getActivity());
            Intrinsics.checkExpressionValueIsNotNull(watchStatus, "IAASharedPreference.getWatchStatus(activity)");
            if (watchStatus.booleanValue()) {
                initializeRecycler();
                checkNetworkConnection();
                IAASharedPreference.setWatchStatus(getActivity(), false);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v38, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v25, resolved type: com.iaai.android.bdt.model.fastSearchFilter2.FacetXX} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:265:0x0ba2, code lost:
        if (r5 != 4) goto L_0x0ba4;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addSelectedFacetForSavedSearch(com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody r30) {
        /*
            r29 = this;
            r0 = r29
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody r4 = r0.fastSearchRequestBody
            if (r4 != 0) goto L_0x001a
            java.lang.String r5 = "fastSearchRequestBody"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
        L_0x001a:
            java.util.List r4 = r4.getSearches()
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.Iterator r4 = r4.iterator()
            r5 = 0
            r6 = 0
        L_0x0026:
            boolean r7 = r4.hasNext()
            if (r7 == 0) goto L_0x004a
            java.lang.Object r7 = r4.next()
            int r8 = r6 + 1
            if (r6 >= 0) goto L_0x0037
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0037:
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r7 = (com.iaai.android.bdt.model.fastSearchFilter2.Searche) r7
            java.util.ArrayList r6 = r7.getFacets()
            if (r6 == 0) goto L_0x0048
            java.util.Collection r6 = (java.util.Collection) r6
            boolean r6 = r3.addAll(r6)
            java.lang.Boolean.valueOf(r6)
        L_0x0048:
            r6 = r8
            goto L_0x0026
        L_0x004a:
            java.lang.Integer r3 = r30.getMiles()
            java.lang.String r4 = " mi"
            r6 = 1
            if (r3 != 0) goto L_0x0054
            goto L_0x005a
        L_0x0054:
            int r3 = r3.intValue()
            if (r3 == 0) goto L_0x00f7
        L_0x005a:
            java.lang.String r3 = r30.getZipCode()
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x006b
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r3 = 0
            goto L_0x006c
        L_0x006b:
            r3 = 1
        L_0x006c:
            if (r3 != 0) goto L_0x00f7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r7 = "Distance~"
            r3.append(r7)
            java.lang.String r7 = r30.getZipCode()
            r3.append(r7)
            r7 = 126(0x7e, float:1.77E-43)
            r3.append(r7)
            java.lang.Integer r7 = r30.getMiles()
            r3.append(r7)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r30.getZipCode()
            r7.append(r8)
            java.lang.String r8 = " < "
            r7.append(r8)
            java.lang.Integer r8 = r30.getMiles()
            r7.append(r8)
            r7.append(r4)
            java.lang.String r7 = r7.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.Integer r9 = r30.getMiles()
            r8.append(r9)
            java.lang.String r9 = " miles"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            java.lang.String r9 = "Zip_Miles"
            kotlin.Triple r8 = r0.getTriple(r9, r8)
            java.lang.Object r9 = r8.getFirst()
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            java.lang.Object r10 = r8.getSecond()
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            java.lang.Object r8 = r8.getThird()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r11 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX
            r11.<init>(r5, r7, r3, r6)
            r1.add(r11)
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel r3 = new com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel
            r3.<init>(r9, r10, r8)
            r2.add(r3)
        L_0x00f7:
            java.util.List r3 = r30.getSearches()
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
            r7 = 0
        L_0x0102:
            boolean r8 = r3.hasNext()
            java.lang.String r10 = ""
            r11 = 2
            if (r8 == 0) goto L_0x0aec
            java.lang.Object r8 = r3.next()
            int r13 = r7 + 1
            if (r7 >= 0) goto L_0x0116
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0116:
            com.iaai.android.bdt.model.fastSearchFilter2.Searche r8 = (com.iaai.android.bdt.model.fastSearchFilter2.Searche) r8
            java.lang.String r7 = r8.getFullSearch()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x0129
            boolean r7 = kotlin.text.StringsKt.isBlank(r7)
            if (r7 == 0) goto L_0x0127
            goto L_0x0129
        L_0x0127:
            r7 = 0
            goto L_0x012a
        L_0x0129:
            r7 = 1
        L_0x012a:
            if (r7 != 0) goto L_0x013d
            java.lang.String r7 = r8.getFullSearch()
            java.lang.String r8 = "keyword"
            int r10 = r8.hashCode()
            r9 = r7
            r15 = r10
            r7 = r13
            r10 = 4
            r11 = 0
            goto L_0x0abe
        L_0x013d:
            java.util.ArrayList r7 = r8.getLongDiscretes()
            java.util.Collection r7 = (java.util.Collection) r7
            if (r7 == 0) goto L_0x014e
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x014c
            goto L_0x014e
        L_0x014c:
            r7 = 0
            goto L_0x014f
        L_0x014e:
            r7 = 1
        L_0x014f:
            java.lang.String r14 = "test"
            r15 = 45
            if (r7 != 0) goto L_0x035a
            java.util.ArrayList r7 = r8.getLongDiscretes()
            java.lang.Object r7 = r7.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r7 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r7
            java.lang.String r7 = r7.getName()
            java.lang.String r9 = "ACV"
            boolean r7 = kotlin.text.StringsKt.equals(r7, r9, r6)
            if (r7 == 0) goto L_0x0203
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.util.ArrayList r9 = r8.getLongDiscretes()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r9
            java.lang.String r9 = r9.getName()
            r7.append(r9)
            java.lang.String r9 = " $"
            r7.append(r9)
            com.iaai.android.bdt.utils.BDTUtils r9 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r10 = r8.getLongDiscretes()
            java.lang.Object r10 = r10.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r10 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r10
            long r10 = r10.getValue()
            int r11 = (int) r10
            java.lang.String r9 = r9.getFormattedNumber(r11)
            r7.append(r9)
            java.lang.String r9 = "-$"
            r7.append(r9)
            com.iaai.android.bdt.utils.BDTUtils r9 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r10 = r8.getLongDiscretes()
            java.lang.Object r10 = r10.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r10 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r10
            long r10 = r10.getValue()
            int r11 = (int) r10
            java.lang.String r9 = r9.getFormattedNumber(r11)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            java.util.ArrayList r9 = r8.getLongDiscretes()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r9
            java.lang.String r9 = r9.getName()
            java.util.ArrayList r8 = r8.getLongDiscretes()
            java.lang.Object r8 = r8.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r8 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r8
            java.lang.String r8 = r8.getName()
            kotlin.Triple r8 = r0.getTriple(r8, r14)
            java.lang.Object r10 = r8.getFirst()
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            java.lang.Object r11 = r8.getSecond()
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            java.lang.Object r8 = r8.getThird()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
        L_0x01fd:
            r15 = r8
            r8 = r9
            r9 = r7
            r7 = r13
            goto L_0x0abe
        L_0x0203:
            java.util.ArrayList r7 = r8.getLongDiscretes()
            java.lang.Object r7 = r7.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r7 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r7
            java.lang.String r7 = r7.getName()
            java.lang.String r9 = "Odometer"
            boolean r7 = kotlin.text.StringsKt.equals(r7, r9, r6)
            if (r7 == 0) goto L_0x0292
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.util.ArrayList r9 = r8.getLongDiscretes()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r9
            long r9 = r9.getValue()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r7.append(r9)
            r7.append(r15)
            java.util.ArrayList r9 = r8.getLongDiscretes()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r9
            long r9 = r9.getValue()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r7.append(r9)
            r7.append(r4)
            java.lang.String r7 = r7.toString()
            java.util.ArrayList r9 = r8.getLongDiscretes()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r9
            java.lang.String r9 = r9.getName()
            java.util.ArrayList r8 = r8.getLongDiscretes()
            java.lang.Object r8 = r8.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r8 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r8
            java.lang.String r8 = r8.getName()
            kotlin.Triple r8 = r0.getTriple(r8, r14)
            java.lang.Object r10 = r8.getFirst()
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            java.lang.Object r11 = r8.getSecond()
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            java.lang.Object r8 = r8.getThird()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            goto L_0x01fd
        L_0x0292:
            java.util.ArrayList r7 = r8.getLongDiscretes()
            java.lang.Object r7 = r7.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r7 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r7
            java.lang.String r7 = r7.getName()
            java.lang.String r9 = "Year"
            boolean r7 = kotlin.text.StringsKt.equals(r7, r9, r6)
            if (r7 == 0) goto L_0x02e4
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r9 = "Year:"
            r7.append(r9)
            java.util.ArrayList r9 = r8.getLongDiscretes()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r9
            long r9 = r9.getValue()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r7.append(r9)
            r7.append(r15)
            java.util.ArrayList r9 = r8.getLongDiscretes()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r9
            long r9 = r9.getValue()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
            goto L_0x031a
        L_0x02e4:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.util.ArrayList r9 = r8.getLongDiscretes()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r9
            long r9 = r9.getValue()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r7.append(r9)
            r7.append(r15)
            java.util.ArrayList r9 = r8.getLongDiscretes()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r9
            long r9 = r9.getValue()
            java.lang.String r9 = java.lang.String.valueOf(r9)
            r7.append(r9)
            java.lang.String r7 = r7.toString()
        L_0x031a:
            java.util.ArrayList r9 = r8.getLongDiscretes()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r9
            java.lang.String r9 = r9.getName()
            java.util.ArrayList r8 = r8.getLongDiscretes()
            java.lang.Object r8 = r8.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes r8 = (com.iaai.android.bdt.model.fastSearchFilter2.LongDiscretes) r8
            java.lang.String r8 = r8.getName()
            kotlin.Triple r8 = r0.getTriple(r8, r14)
            java.lang.Object r10 = r8.getFirst()
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            java.lang.Object r11 = r8.getSecond()
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            java.lang.Object r8 = r8.getThird()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            goto L_0x01fd
        L_0x035a:
            java.util.ArrayList r7 = r8.getLongRanges()
            java.util.Collection r7 = (java.util.Collection) r7
            if (r7 == 0) goto L_0x036b
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x0369
            goto L_0x036b
        L_0x0369:
            r7 = 0
            goto L_0x036c
        L_0x036b:
            r7 = 1
        L_0x036c:
            if (r7 != 0) goto L_0x070a
            java.util.ArrayList r7 = r8.getLongRanges()
            java.lang.Object r7 = r7.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r7 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r7
            java.lang.String r7 = r7.getName()
            java.lang.String r10 = "Cddate"
            boolean r7 = kotlin.text.StringsKt.equals(r7, r10, r6)
            if (r7 == 0) goto L_0x04e6
            java.util.ArrayList r7 = r8.getLongRanges()
            java.lang.Object r7 = r7.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r7 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r7
            long r14 = r7.getFrom()
            r7 = r13
            long r12 = r0.EPOCH_TICKS
            long r14 = r14 - r12
            r10 = 10000(0x2710, float:1.4013E-41)
            long r12 = (long) r10
            long r14 = r14 / r12
            java.util.ArrayList r10 = r8.getLongRanges()
            java.lang.Object r10 = r10.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r10 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r10
            long r17 = r10.getTo()
            long r9 = r0.EPOCH_TICKS
            long r17 = r17 - r9
            long r17 = r17 / r12
            long r9 = r17 - r14
            java.util.concurrent.TimeUnit r12 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r12 = r12.toDays(r9)
            int r13 = (int) r12
            if (r13 == r6) goto L_0x0416
            if (r13 == r11) goto L_0x0401
            r12 = 7
            if (r13 == r12) goto L_0x03ec
            r12 = 14
            if (r13 == r12) goto L_0x03d7
            java.util.ArrayList r12 = r8.getLongRanges()
            java.lang.Object r12 = r12.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r12 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r12
            java.lang.String r12 = r12.getName()
            java.lang.String r13 = "All"
            kotlin.Triple r12 = r0.getTriple(r12, r13)
            goto L_0x042a
        L_0x03d7:
            java.util.ArrayList r12 = r8.getLongRanges()
            java.lang.Object r12 = r12.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r12 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r12
            java.lang.String r12 = r12.getName()
            java.lang.String r13 = "Last 14 days"
            kotlin.Triple r12 = r0.getTriple(r12, r13)
            goto L_0x042a
        L_0x03ec:
            java.util.ArrayList r12 = r8.getLongRanges()
            java.lang.Object r12 = r12.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r12 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r12
            java.lang.String r12 = r12.getName()
            java.lang.String r13 = "Last 7 days"
            kotlin.Triple r12 = r0.getTriple(r12, r13)
            goto L_0x042a
        L_0x0401:
            java.util.ArrayList r12 = r8.getLongRanges()
            java.lang.Object r12 = r12.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r12 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r12
            java.lang.String r12 = r12.getName()
            java.lang.String r13 = "Last 48 hrs"
            kotlin.Triple r12 = r0.getTriple(r12, r13)
            goto L_0x042a
        L_0x0416:
            java.util.ArrayList r12 = r8.getLongRanges()
            java.lang.Object r12 = r12.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r12 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r12
            java.lang.String r12 = r12.getName()
            java.lang.String r13 = "Last 24 hrs"
            kotlin.Triple r12 = r0.getTriple(r12, r13)
        L_0x042a:
            java.lang.Object r13 = r12.getFirst()
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            java.lang.Object r14 = r12.getSecond()
            java.lang.Number r14 = (java.lang.Number) r14
            int r14 = r14.intValue()
            java.lang.Object r12 = r12.getThird()
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            java.util.concurrent.TimeUnit r15 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r9 = r15.toDays(r9)
            int r10 = (int) r9
            java.lang.String r9 = "refinerResultActivity"
            r15 = 2130903057(0x7f030011, float:1.7412921E38)
            if (r10 == r6) goto L_0x04bd
            if (r10 == r11) goto L_0x04a6
            r11 = 7
            if (r10 == r11) goto L_0x048e
            r11 = 14
            if (r10 == r11) goto L_0x0476
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r10 = r0.refinerResultActivity
            if (r10 != 0) goto L_0x0466
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x0466:
            android.content.res.Resources r9 = r10.getResources()
            java.lang.String[] r9 = r9.getStringArray(r15)
            r9 = r9[r5]
            java.lang.String r10 = "refinerResultActivity.re…new_inventory_refiner)[0]"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r10)
            goto L_0x04d3
        L_0x0476:
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r10 = r0.refinerResultActivity
            if (r10 != 0) goto L_0x047d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x047d:
            android.content.res.Resources r9 = r10.getResources()
            java.lang.String[] r9 = r9.getStringArray(r15)
            r10 = 4
            r9 = r9[r10]
            java.lang.String r10 = "refinerResultActivity.re…new_inventory_refiner)[4]"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r10)
            goto L_0x04d3
        L_0x048e:
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r10 = r0.refinerResultActivity
            if (r10 != 0) goto L_0x0495
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x0495:
            android.content.res.Resources r9 = r10.getResources()
            java.lang.String[] r9 = r9.getStringArray(r15)
            r10 = 3
            r9 = r9[r10]
            java.lang.String r10 = "refinerResultActivity.re…new_inventory_refiner)[3]"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r10)
            goto L_0x04d3
        L_0x04a6:
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r10 = r0.refinerResultActivity
            if (r10 != 0) goto L_0x04ad
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x04ad:
            android.content.res.Resources r9 = r10.getResources()
            java.lang.String[] r9 = r9.getStringArray(r15)
            r9 = r9[r11]
            java.lang.String r10 = "refinerResultActivity.re…new_inventory_refiner)[2]"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r10)
            goto L_0x04d3
        L_0x04bd:
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity r10 = r0.refinerResultActivity
            if (r10 != 0) goto L_0x04c4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r9)
        L_0x04c4:
            android.content.res.Resources r9 = r10.getResources()
            java.lang.String[] r9 = r9.getStringArray(r15)
            r9 = r9[r6]
            java.lang.String r10 = "refinerResultActivity.re…new_inventory_refiner)[1]"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r9, r10)
        L_0x04d3:
            java.util.ArrayList r8 = r8.getLongRanges()
            java.lang.Object r8 = r8.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r8 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r8
            java.lang.String r8 = r8.getName()
            r15 = r12
            r10 = r13
            r11 = r14
            goto L_0x0abe
        L_0x04e6:
            r7 = r13
            java.util.ArrayList r9 = r8.getLongRanges()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r9
            java.lang.String r9 = r9.getName()
            java.lang.String r10 = "ACV"
            boolean r9 = kotlin.text.StringsKt.equals(r9, r10, r6)
            if (r9 == 0) goto L_0x05cb
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.util.ArrayList r10 = r8.getLongRanges()
            java.lang.Object r10 = r10.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r10 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r10
            java.lang.String r10 = r10.getName()
            r9.append(r10)
            java.lang.String r10 = " $"
            r9.append(r10)
            com.iaai.android.bdt.utils.BDTUtils r10 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r11 = r8.getLongRanges()
            java.lang.Object r11 = r11.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r11 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r11
            long r11 = r11.getFrom()
            int r12 = (int) r11
            java.lang.String r10 = r10.getFormattedNumber(r12)
            r9.append(r10)
            java.lang.String r10 = "-$"
            r9.append(r10)
            com.iaai.android.bdt.utils.BDTUtils r10 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r11 = r8.getLongRanges()
            java.lang.Object r11 = r11.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r11 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r11
            long r11 = r11.getTo()
            int r12 = (int) r11
            java.lang.String r10 = r10.getFormattedNumber(r12)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.util.ArrayList r11 = r8.getLongRanges()
            java.lang.Object r11 = r11.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r11 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r11
            java.lang.String r11 = r11.getName()
            r10.append(r11)
            r11 = 126(0x7e, float:1.77E-43)
            r10.append(r11)
            java.util.ArrayList r11 = r8.getLongRanges()
            java.lang.Object r11 = r11.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r11 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r11
            long r11 = r11.getFrom()
            r10.append(r11)
            r10.append(r15)
            java.util.ArrayList r11 = r8.getLongRanges()
            java.lang.Object r11 = r11.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r11 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r11
            long r11 = r11.getTo()
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            java.util.ArrayList r8 = r8.getLongRanges()
            java.lang.Object r8 = r8.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r8 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r8
            java.lang.String r8 = r8.getName()
            kotlin.Triple r8 = r0.getTriple(r8, r14)
            java.lang.Object r11 = r8.getFirst()
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            java.lang.Object r12 = r8.getSecond()
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            java.lang.Object r8 = r8.getThird()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
        L_0x05c5:
            r15 = r8
            r8 = r10
            r10 = r11
            r11 = r12
            goto L_0x0abe
        L_0x05cb:
            java.util.ArrayList r9 = r8.getLongRanges()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r9
            java.lang.String r9 = r9.getName()
            java.lang.String r10 = "Odometer"
            boolean r9 = kotlin.text.StringsKt.equals(r9, r10, r6)
            if (r9 == 0) goto L_0x0652
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.util.ArrayList r10 = r8.getLongRanges()
            java.lang.Object r10 = r10.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r10 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r10
            long r10 = r10.getFrom()
            r9.append(r10)
            r9.append(r15)
            java.util.ArrayList r10 = r8.getLongRanges()
            java.lang.Object r10 = r10.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r10 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r10
            long r10 = r10.getTo()
            r9.append(r10)
            r9.append(r4)
            java.lang.String r9 = r9.toString()
            java.util.ArrayList r10 = r8.getLongRanges()
            java.lang.Object r10 = r10.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r10 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r10
            java.lang.String r10 = r10.getName()
            java.util.ArrayList r8 = r8.getLongRanges()
            java.lang.Object r8 = r8.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r8 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r8
            java.lang.String r8 = r8.getName()
            kotlin.Triple r8 = r0.getTriple(r8, r14)
            java.lang.Object r11 = r8.getFirst()
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            java.lang.Object r12 = r8.getSecond()
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            java.lang.Object r8 = r8.getThird()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            goto L_0x05c5
        L_0x0652:
            java.util.ArrayList r9 = r8.getLongRanges()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r9 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r9
            java.lang.String r9 = r9.getName()
            java.lang.String r10 = "Year"
            boolean r9 = kotlin.text.StringsKt.equals(r9, r10, r6)
            if (r9 == 0) goto L_0x069c
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "Year:"
            r9.append(r10)
            java.util.ArrayList r10 = r8.getLongRanges()
            java.lang.Object r10 = r10.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r10 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r10
            long r10 = r10.getFrom()
            r9.append(r10)
            r9.append(r15)
            java.util.ArrayList r10 = r8.getLongRanges()
            java.lang.Object r10 = r10.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r10 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r10
            long r10 = r10.getTo()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            goto L_0x06ca
        L_0x069c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.util.ArrayList r10 = r8.getLongRanges()
            java.lang.Object r10 = r10.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r10 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r10
            long r10 = r10.getFrom()
            r9.append(r10)
            r9.append(r15)
            java.util.ArrayList r10 = r8.getLongRanges()
            java.lang.Object r10 = r10.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r10 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r10
            long r10 = r10.getTo()
            r9.append(r10)
            java.lang.String r9 = r9.toString()
        L_0x06ca:
            java.util.ArrayList r10 = r8.getLongRanges()
            java.lang.Object r10 = r10.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r10 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r10
            java.lang.String r10 = r10.getName()
            java.util.ArrayList r8 = r8.getLongRanges()
            java.lang.Object r8 = r8.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData r8 = (com.iaai.android.bdt.model.fastSearchFilter2.LongRangesData) r8
            java.lang.String r8 = r8.getName()
            kotlin.Triple r8 = r0.getTriple(r8, r14)
            java.lang.Object r11 = r8.getFirst()
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            java.lang.Object r12 = r8.getSecond()
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            java.lang.Object r8 = r8.getThird()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            goto L_0x05c5
        L_0x070a:
            r7 = r13
            java.util.ArrayList r8 = r8.getFacets()
            if (r8 == 0) goto L_0x0ab4
            java.lang.Object r9 = r8.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r9 = (com.iaai.android.bdt.model.fastSearchFilter2.Facet) r9
            java.lang.String r9 = r9.getGroup()
            java.lang.String r12 = "QuickLinkCategories"
            boolean r9 = kotlin.text.StringsKt.equals(r9, r12, r6)
            r12 = 6
            if (r9 == 0) goto L_0x0a57
            java.lang.Object r9 = r8.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r9 = (com.iaai.android.bdt.model.fastSearchFilter2.Facet) r9
            java.lang.String r9 = r9.getValue()
            com.iaai.android.bdt.utils.BDTUtils r13 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r13 = r13.getAuctionDateFromQL()
            java.lang.Object r13 = r13.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r13 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r13
            java.lang.String r13 = r13.getRefinerValue()
            java.lang.String r14 = "~"
            if (r13 == 0) goto L_0x075f
            r17 = r13
            java.lang.CharSequence r17 = (java.lang.CharSequence) r17
            java.lang.String[] r18 = new java.lang.String[]{r14}
            r19 = 0
            r20 = 0
            r21 = 6
            r22 = 0
            java.util.List r13 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r17, (java.lang.String[]) r18, (boolean) r19, (int) r20, (int) r21, (java.lang.Object) r22)
            if (r13 == 0) goto L_0x075f
            java.lang.Object r13 = r13.get(r6)
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x0760
        L_0x075f:
            r13 = 0
        L_0x0760:
            boolean r9 = kotlin.text.StringsKt.equals(r9, r13, r6)
            java.lang.String r13 = ", "
            if (r9 == 0) goto L_0x0818
            com.iaai.android.bdt.utils.BDTUtils r8 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r8 = r8.getAuctionDateFromQL()
            java.lang.Object r8 = r8.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r8 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r8
            java.lang.String r8 = r8.getValue()
            r14 = r8
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.String r8 = " "
            java.lang.String[] r15 = new java.lang.String[]{r8}
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            java.util.List r8 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r14, (java.lang.String[]) r15, (boolean) r16, (int) r17, (int) r18, (java.lang.Object) r19)
            com.iaai.android.bdt.utils.BDTUtils r9 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r9 = r9.getAuctionDateFromQL()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r9 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r9
            java.lang.String r9 = r9.getRefinerValue()
            if (r9 == 0) goto L_0x07b3
            r14 = r9
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.String[] r15 = new java.lang.String[]{r13}
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            java.util.List r9 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r14, (java.lang.String[]) r15, (boolean) r16, (int) r17, (int) r18, (java.lang.Object) r19)
            goto L_0x07b4
        L_0x07b3:
            r9 = 0
        L_0x07b4:
            int r11 = r8.size()
            if (r11 != r6) goto L_0x07dd
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.Object r8 = r8.get(r5)
            java.lang.String r8 = (java.lang.String) r8
            r11.append(r8)
            r11.append(r13)
            if (r9 == 0) goto L_0x07d4
            java.lang.Object r8 = r9.get(r6)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x07d5
        L_0x07d4:
            r8 = 0
        L_0x07d5:
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            goto L_0x07ff
        L_0x07dd:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.Object r8 = r8.get(r6)
            java.lang.String r8 = (java.lang.String) r8
            r11.append(r8)
            r11.append(r13)
            if (r9 == 0) goto L_0x07f7
            java.lang.Object r8 = r9.get(r6)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x07f8
        L_0x07f7:
            r8 = 0
        L_0x07f8:
            r11.append(r8)
            java.lang.String r8 = r11.toString()
        L_0x07ff:
            com.iaai.android.bdt.utils.BDTUtils r9 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r9 = r9.getAuctionDateFromQL()
            java.lang.Object r9 = r9.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r9 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r9
            java.lang.String r9 = r9.getRefinerValue()
            if (r9 == 0) goto L_0x0812
            goto L_0x0813
        L_0x0812:
            r9 = r10
        L_0x0813:
            r10 = r8
            r5 = 6
            r15 = 0
            goto L_0x096e
        L_0x0818:
            java.lang.Object r9 = r8.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r9 = (com.iaai.android.bdt.model.fastSearchFilter2.Facet) r9
            java.lang.String r9 = r9.getValue()
            com.iaai.android.bdt.utils.BDTUtils r15 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r15 = r15.getAuctionDateFromQL()
            java.lang.Object r15 = r15.get(r6)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r15 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r15
            java.lang.String r15 = r15.getRefinerValue()
            if (r15 == 0) goto L_0x0851
            r17 = r15
            java.lang.CharSequence r17 = (java.lang.CharSequence) r17
            java.lang.String[] r18 = new java.lang.String[]{r14}
            r19 = 0
            r20 = 0
            r21 = 6
            r22 = 0
            java.util.List r15 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r17, (java.lang.String[]) r18, (boolean) r19, (int) r20, (int) r21, (java.lang.Object) r22)
            if (r15 == 0) goto L_0x0851
            java.lang.Object r15 = r15.get(r6)
            java.lang.String r15 = (java.lang.String) r15
            goto L_0x0852
        L_0x0851:
            r15 = 0
        L_0x0852:
            boolean r9 = kotlin.text.StringsKt.equals(r9, r15, r6)
            if (r9 == 0) goto L_0x0907
            com.iaai.android.bdt.utils.BDTUtils r8 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r8 = r8.getAuctionDateFromQL()
            java.lang.Object r8 = r8.get(r6)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r8 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r8
            java.lang.String r8 = r8.getValue()
            r14 = r8
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.String r8 = " "
            java.lang.String[] r15 = new java.lang.String[]{r8}
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            java.util.List r8 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r14, (java.lang.String[]) r15, (boolean) r16, (int) r17, (int) r18, (java.lang.Object) r19)
            com.iaai.android.bdt.utils.BDTUtils r9 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r9 = r9.getAuctionDateFromQL()
            java.lang.Object r9 = r9.get(r6)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r9 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r9
            java.lang.String r9 = r9.getRefinerValue()
            if (r9 == 0) goto L_0x08a3
            r14 = r9
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            java.lang.String[] r15 = new java.lang.String[]{r13}
            r16 = 0
            r17 = 0
            r18 = 6
            r19 = 0
            java.util.List r9 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r14, (java.lang.String[]) r15, (boolean) r16, (int) r17, (int) r18, (java.lang.Object) r19)
            goto L_0x08a4
        L_0x08a3:
            r9 = 0
        L_0x08a4:
            int r11 = r8.size()
            if (r11 != r6) goto L_0x08cd
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.Object r8 = r8.get(r5)
            java.lang.String r8 = (java.lang.String) r8
            r11.append(r8)
            r11.append(r13)
            if (r9 == 0) goto L_0x08c4
            java.lang.Object r8 = r9.get(r6)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x08c5
        L_0x08c4:
            r8 = 0
        L_0x08c5:
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            goto L_0x08ef
        L_0x08cd:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.Object r8 = r8.get(r6)
            java.lang.String r8 = (java.lang.String) r8
            r11.append(r8)
            r11.append(r13)
            if (r9 == 0) goto L_0x08e7
            java.lang.Object r8 = r9.get(r6)
            java.lang.String r8 = (java.lang.String) r8
            goto L_0x08e8
        L_0x08e7:
            r8 = 0
        L_0x08e8:
            r11.append(r8)
            java.lang.String r8 = r11.toString()
        L_0x08ef:
            com.iaai.android.bdt.utils.BDTUtils r9 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r9 = r9.getAuctionDateFromQL()
            java.lang.Object r9 = r9.get(r6)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r9 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r9
            java.lang.String r9 = r9.getRefinerValue()
            if (r9 == 0) goto L_0x0902
            goto L_0x0903
        L_0x0902:
            r9 = r10
        L_0x0903:
            r10 = r8
            r5 = 6
            r15 = 1
            goto L_0x096e
        L_0x0907:
            java.lang.Object r9 = r8.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r9 = (com.iaai.android.bdt.model.fastSearchFilter2.Facet) r9
            java.lang.String r9 = r9.getValue()
            com.iaai.android.bdt.utils.BDTUtils r13 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r13 = r13.getAuctionDateFromQL()
            java.lang.Object r13 = r13.get(r11)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r13 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r13
            java.lang.String r13 = r13.getRefinerValue()
            if (r13 == 0) goto L_0x0940
            r17 = r13
            java.lang.CharSequence r17 = (java.lang.CharSequence) r17
            java.lang.String[] r18 = new java.lang.String[]{r14}
            r19 = 0
            r20 = 0
            r21 = 6
            r22 = 0
            java.util.List r13 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r17, (java.lang.String[]) r18, (boolean) r19, (int) r20, (int) r21, (java.lang.Object) r22)
            if (r13 == 0) goto L_0x0940
            java.lang.Object r13 = r13.get(r6)
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x0941
        L_0x0940:
            r13 = 0
        L_0x0941:
            boolean r9 = kotlin.text.StringsKt.equals(r9, r13, r6)
            if (r9 == 0) goto L_0x0972
            com.iaai.android.bdt.utils.BDTUtils r8 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r8 = r8.getAuctionDateFromQL()
            java.lang.Object r8 = r8.get(r11)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r8 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r8
            java.lang.String r8 = r8.getValue()
            com.iaai.android.bdt.utils.BDTUtils r9 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r9 = r9.getAuctionDateFromQL()
            java.lang.Object r9 = r9.get(r11)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r9 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r9
            java.lang.String r9 = r9.getRefinerValue()
            if (r9 == 0) goto L_0x096a
            goto L_0x096b
        L_0x096a:
            r9 = r10
        L_0x096b:
            r10 = r8
            r5 = 6
            r15 = 2
        L_0x096e:
            r17 = 1
            goto L_0x0aae
        L_0x0972:
            java.lang.Object r9 = r8.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r9 = (com.iaai.android.bdt.model.fastSearchFilter2.Facet) r9
            java.lang.String r9 = r9.getValue()
            com.iaai.android.bdt.utils.BDTUtils r13 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r13 = r13.getAuctionDateFromQL()
            r15 = 3
            java.lang.Object r13 = r13.get(r15)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r13 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r13
            java.lang.String r13 = r13.getRefinerValue()
            if (r13 == 0) goto L_0x09ac
            r17 = r13
            java.lang.CharSequence r17 = (java.lang.CharSequence) r17
            java.lang.String[] r18 = new java.lang.String[]{r14}
            r19 = 0
            r20 = 0
            r21 = 6
            r22 = 0
            java.util.List r13 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r17, (java.lang.String[]) r18, (boolean) r19, (int) r20, (int) r21, (java.lang.Object) r22)
            if (r13 == 0) goto L_0x09ac
            java.lang.Object r13 = r13.get(r6)
            java.lang.String r13 = (java.lang.String) r13
            goto L_0x09ad
        L_0x09ac:
            r13 = 0
        L_0x09ad:
            boolean r9 = kotlin.text.StringsKt.equals(r9, r13, r6)
            if (r9 == 0) goto L_0x09df
            com.iaai.android.bdt.utils.BDTUtils r8 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r8 = r8.getAuctionDateFromQL()
            r9 = 3
            java.lang.Object r8 = r8.get(r9)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r8 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r8
            java.lang.String r8 = r8.getValue()
            com.iaai.android.bdt.utils.BDTUtils r11 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r11 = r11.getAuctionDateFromQL()
            java.lang.Object r11 = r11.get(r9)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r11 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r11
            java.lang.String r11 = r11.getRefinerValue()
            if (r11 == 0) goto L_0x09d7
            r10 = r11
        L_0x09d7:
            r9 = r10
            r5 = 6
            r15 = 3
            r17 = 1
            r10 = r8
            goto L_0x0aae
        L_0x09df:
            com.iaai.android.bdt.utils.BDTUtils r9 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r9 = r9.getPopularCategories()
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            java.util.Iterator r9 = r9.iterator()
            r13 = r10
            r16 = r13
            r12 = 0
            r15 = 0
            r17 = 0
        L_0x09f2:
            boolean r18 = r9.hasNext()
            if (r18 == 0) goto L_0x0a52
            java.lang.Object r18 = r9.next()
            int r19 = r12 + 1
            if (r12 >= 0) goto L_0x0a03
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0a03:
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r18 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r18
            java.lang.Object r20 = r8.get(r5)
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r20 = (com.iaai.android.bdt.model.fastSearchFilter2.Facet) r20
            java.lang.String r11 = r20.getValue()
            java.lang.String r20 = r18.getRefinerValue()
            if (r20 == 0) goto L_0x0a34
            r22 = r20
            java.lang.CharSequence r22 = (java.lang.CharSequence) r22
            java.lang.String[] r23 = new java.lang.String[]{r14}
            r24 = 0
            r25 = 0
            r26 = 6
            r27 = 0
            java.util.List r5 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r22, (java.lang.String[]) r23, (boolean) r24, (int) r25, (int) r26, (java.lang.Object) r27)
            if (r5 == 0) goto L_0x0a34
            java.lang.Object r5 = r5.get(r6)
            java.lang.String r5 = (java.lang.String) r5
            if (r5 == 0) goto L_0x0a34
            goto L_0x0a35
        L_0x0a34:
            r5 = r10
        L_0x0a35:
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r5)
            if (r5 == 0) goto L_0x0a4d
            java.lang.String r5 = r18.getValue()
            java.lang.String r11 = r18.getRefinerValue()
            if (r11 == 0) goto L_0x0a46
            goto L_0x0a47
        L_0x0a46:
            r11 = r10
        L_0x0a47:
            r13 = r5
            r16 = r11
            r15 = r12
            r17 = 2
        L_0x0a4d:
            r12 = r19
            r5 = 0
            r11 = 2
            goto L_0x09f2
        L_0x0a52:
            r10 = r13
            r9 = r16
            r5 = 0
            goto L_0x0aae
        L_0x0a57:
            com.iaai.android.bdt.utils.BDTUtils r5 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            r9 = 0
            java.lang.Object r10 = r8.get(r9)
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r10 = (com.iaai.android.bdt.model.fastSearchFilter2.Facet) r10
            java.lang.String r10 = r10.getValue()
            java.lang.String r5 = r5.getActualValue(r10)
            java.lang.Object r10 = r8.get(r9)
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r10 = (com.iaai.android.bdt.model.fastSearchFilter2.Facet) r10
            java.lang.String r10 = r10.getGroup()
            java.lang.Object r11 = r8.get(r9)
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r11 = (com.iaai.android.bdt.model.fastSearchFilter2.Facet) r11
            java.lang.String r11 = r11.getGroup()
            java.lang.Object r8 = r8.get(r9)
            com.iaai.android.bdt.model.fastSearchFilter2.Facet r8 = (com.iaai.android.bdt.model.fastSearchFilter2.Facet) r8
            java.lang.String r8 = r8.getValue()
            kotlin.Triple r8 = r0.getTriple(r11, r8)
            java.lang.Object r9 = r8.getFirst()
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            java.lang.Object r11 = r8.getSecond()
            java.lang.Number r11 = (java.lang.Number) r11
            int r11 = r11.intValue()
            java.lang.Object r8 = r8.getThird()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r15 = r8
            r17 = r9
            r9 = r10
            r10 = r5
            r5 = r11
        L_0x0aae:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            r8 = r9
            r9 = r17
            goto L_0x0ab8
        L_0x0ab4:
            r8 = r10
            r5 = 0
            r9 = 0
            r15 = 0
        L_0x0ab8:
            r11 = r5
            r28 = r10
            r10 = r9
            r9 = r28
        L_0x0abe:
            java.lang.String r5 = "Default"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r5)
            r5 = r5 ^ r6
            if (r5 == 0) goto L_0x0ae9
            r5 = r8
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0ad5
            int r5 = r5.length()
            if (r5 != 0) goto L_0x0ad3
            goto L_0x0ad5
        L_0x0ad3:
            r5 = 0
            goto L_0x0ad6
        L_0x0ad5:
            r5 = 1
        L_0x0ad6:
            if (r5 != 0) goto L_0x0ae9
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r5 = new com.iaai.android.bdt.model.fastSearchFilter2.FacetXX
            r12 = 0
            r5.<init>(r12, r9, r8, r6)
            r1.add(r5)
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel r5 = new com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel
            r5.<init>(r10, r11, r15)
            r2.add(r5)
        L_0x0ae9:
            r5 = 0
            goto L_0x0102
        L_0x0aec:
            com.iaai.android.bdt.utils.BDTUtils r3 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r3 = r3.getSearchMappingArray()
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r6
            if (r3 == 0) goto L_0x0d33
            com.iaai.android.bdt.utils.BDTUtils r3 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r3 = r3.getSearchMappingArray()
            int r3 = r3.size()
            r4 = 0
        L_0x0b06:
            if (r4 >= r3) goto L_0x0b4d
            com.iaai.android.bdt.utils.BDTUtils r5 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r5 = r5.getSearchMappingArray()
            java.lang.Object r5 = r5.get(r4)
            java.lang.String r7 = "BDTUtils.searchMappingArray[index]"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r7)
            com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray r5 = (com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray) r5
            java.util.ArrayList r5 = r5.getGroups()
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0b23:
            boolean r7 = r5.hasNext()
            if (r7 == 0) goto L_0x0b4a
            java.lang.Object r7 = r5.next()
            com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup r7 = (com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingGroup) r7
            java.util.ArrayList r7 = r7.getListFacet()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0b39:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0b23
            java.lang.Object r8 = r7.next()
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r8 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r8
            r9 = 0
            r8.setSelected(r9)
            goto L_0x0b39
        L_0x0b4a:
            int r4 = r4 + 1
            goto L_0x0b06
        L_0x0b4d:
            r3 = r2
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
            r4 = 0
        L_0x0b55:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0d33
            java.lang.Object r5 = r3.next()
            int r7 = r4 + 1
            if (r4 >= 0) goto L_0x0b66
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0b66:
            com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel r5 = (com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel) r5
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r8 = "itemList[index]"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r8)
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r4 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r4
            kotlin.Triple r8 = new kotlin.Triple
            int r9 = r5.getTabPosition()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            int r11 = r5.getParentPosition()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            int r5 = r5.getChildPosition()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r8.<init>(r9, r11, r5)
            java.lang.Object r5 = r8.getFirst()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r5 == 0) goto L_0x0be6
            if (r5 == r6) goto L_0x0be6
            r9 = 2
            if (r5 == r9) goto L_0x0ba9
            r11 = 4
            if (r5 == r11) goto L_0x0be7
        L_0x0ba4:
            r12 = 2
            r13 = 0
            r14 = 0
            goto L_0x0d30
        L_0x0ba9:
            r11 = 4
            com.iaai.android.bdt.utils.BDTUtils r4 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            com.iaai.android.bdt.utils.BDTUtils r5 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.LinkedHashMap r5 = r5.getExpandableListDetailPC()
            com.iaai.android.bdt.utils.BDTUtils r12 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.util.ArrayList r12 = r12.getSearchMappingArray()
            java.lang.Object r12 = r12.get(r9)
            com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray r12 = (com.iaai.android.bdt.model.fastSearchFilter2.SearchMappingArray) r12
            java.util.ArrayList r9 = r12.getGroups()
            r12 = 0
            java.lang.Object r9 = r9.get(r12)
            java.lang.Object r5 = r5.get(r9)
            java.util.List r5 = (java.util.List) r5
            if (r5 == 0) goto L_0x0be1
            java.lang.Object r8 = r8.getThird()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            java.lang.Object r5 = r5.get(r8)
            r12 = r5
            com.iaai.android.bdt.model.fastSearchFilter2.FacetXX r12 = (com.iaai.android.bdt.model.fastSearchFilter2.FacetXX) r12
            goto L_0x0be2
        L_0x0be1:
            r12 = 0
        L_0x0be2:
            r4.updateGlobalPopularCategoryMapping(r12)
            goto L_0x0ba4
        L_0x0be6:
            r11 = 4
        L_0x0be7:
            if (r4 == 0) goto L_0x0d1a
            java.lang.String r5 = r4.getRefinerValue()
            if (r5 == 0) goto L_0x0d1a
            java.lang.String r9 = "keyword"
            r12 = 2
            r13 = 0
            r14 = 0
            boolean r5 = kotlin.text.StringsKt.startsWith$default(r5, r9, r14, r12, r13)
            if (r5 != 0) goto L_0x0d1a
            java.lang.String r5 = r4.getRefinerValue()
            if (r5 == 0) goto L_0x0c2d
            java.lang.String r9 = "Odometer"
            boolean r5 = kotlin.text.StringsKt.startsWith(r5, r9, r6)
            if (r5 != r6) goto L_0x0c2d
            com.iaai.android.bdt.utils.BDTUtils r5 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.lang.Object r9 = r8.getFirst()
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            java.lang.Object r12 = r8.getSecond()
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            java.lang.Object r13 = r8.getThird()
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            r5.updateGlobalFilterFromSS(r9, r12, r13, r4)
            goto L_0x0ce7
        L_0x0c2d:
            java.lang.String r5 = r4.getRefinerValue()
            if (r5 == 0) goto L_0x0c60
            java.lang.String r9 = "ACV"
            boolean r5 = kotlin.text.StringsKt.startsWith(r5, r9, r6)
            if (r5 != r6) goto L_0x0c60
            com.iaai.android.bdt.utils.BDTUtils r5 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.lang.Object r9 = r8.getFirst()
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            java.lang.Object r12 = r8.getSecond()
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            java.lang.Object r13 = r8.getThird()
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            r5.updateGlobalFilterFromSS(r9, r12, r13, r4)
            goto L_0x0ce7
        L_0x0c60:
            java.lang.String r5 = r4.getRefinerValue()
            if (r5 == 0) goto L_0x0c92
            java.lang.String r9 = "Year"
            boolean r5 = kotlin.text.StringsKt.startsWith(r5, r9, r6)
            if (r5 != r6) goto L_0x0c92
            com.iaai.android.bdt.utils.BDTUtils r5 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.lang.Object r9 = r8.getFirst()
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            java.lang.Object r12 = r8.getSecond()
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            java.lang.Object r13 = r8.getThird()
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            r5.updateGlobalFilterFromSS(r9, r12, r13, r4)
            goto L_0x0ce7
        L_0x0c92:
            java.lang.String r5 = r4.getRefinerValue()
            if (r5 == 0) goto L_0x0cc4
            java.lang.String r9 = "Distance"
            boolean r5 = kotlin.text.StringsKt.startsWith(r5, r9, r6)
            if (r5 != r6) goto L_0x0cc4
            com.iaai.android.bdt.utils.BDTUtils r5 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.lang.Object r9 = r8.getFirst()
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            java.lang.Object r12 = r8.getSecond()
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            java.lang.Object r13 = r8.getThird()
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            r5.updateGlobalFilterMappingForDistance(r9, r12, r13, r4)
            goto L_0x0ce7
        L_0x0cc4:
            com.iaai.android.bdt.utils.BDTUtils r5 = com.iaai.android.bdt.utils.BDTUtils.INSTANCE
            java.lang.Object r9 = r8.getFirst()
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            java.lang.Object r12 = r8.getSecond()
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            java.lang.Object r13 = r8.getThird()
            java.lang.Number r13 = (java.lang.Number) r13
            int r13 = r13.intValue()
            r5.updateGlobalFilterMapping(r9, r12, r13, r4)
        L_0x0ce7:
            java.lang.String r5 = r4.getRefinerValue()
            java.lang.String r9 = "AuctionType"
            r12 = 2
            r13 = 0
            r14 = 0
            boolean r5 = kotlin.text.StringsKt.equals$default(r5, r9, r14, r12, r13)
            if (r5 == 0) goto L_0x0d30
            java.lang.String r4 = r4.getValue()
            java.lang.String r5 = "Buy Now"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 == 0) goto L_0x0d30
            java.lang.Object r4 = r8.getFirst()
            java.lang.Number r4 = (java.lang.Number) r4
            int r4 = r4.intValue()
            java.lang.Object r5 = r8.getSecond()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            r0.enableBuyNowPrice(r4, r5)
            goto L_0x0d30
        L_0x0d1a:
            r12 = 2
            r13 = 0
            r14 = 0
            int r4 = com.iaai.android.C2723R.C2726id.ed_search_result
            android.view.View r4 = r0._$_findCachedViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String r5 = "ed_search_result"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)
            r5 = r10
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r4.setText(r5)
        L_0x0d30:
            r4 = r7
            goto L_0x0b55
        L_0x0d33:
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearchFilter2.FacetXX> r3 = r0.selectedFacets
            r3.clear()
            java.util.ArrayList<com.iaai.android.bdt.model.fastSearchFilter2.FacetXX> r3 = r0.selectedFacets
            java.util.Collection r1 = (java.util.Collection) r1
            r3.addAll(r1)
            java.util.ArrayList<com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel> r1 = r0.selectedIndices
            r1.clear()
            java.util.ArrayList<com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.SelectedRefinerIndicesModel> r1 = r0.selectedIndices
            java.util.Collection r2 = (java.util.Collection) r2
            r1.addAll(r2)
            r29.updateGlobalArrayForSelectedFacet()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultFragment.addSelectedFacetForSavedSearch(com.iaai.android.bdt.model.fastSearchFilter2.FastSearchRequestBody):void");
    }

    private final void enableBuyNowPrice(int i, int i2) {
        int i3;
        boolean z;
        if (StringsKt.equals(BDTUtils.INSTANCE.getSearchMappingArray().get(i).getGroups().get(i2).getGroup(), "AuctionType", true)) {
            List<FacetXX> list = BDTUtils.INSTANCE.getExpandableListDetail().get(BDTUtils.INSTANCE.getSearchMappingArray().get(i).getGroups().get(i2));
            if (list != null) {
                z = false;
                for (FacetXX facetXX : list) {
                    if (StringsKt.equals(facetXX.getValue(), "Buy Now", true) && facetXX.isSelected()) {
                        z = true;
                    }
                }
            } else {
                z = false;
            }
            i3 = -1;
            int i4 = 0;
            for (Object next : BDTUtils.INSTANCE.getSearchMappingArray().get(i).getGroups()) {
                int i5 = i4 + 1;
                if (i4 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SearchMappingGroup searchMappingGroup = (SearchMappingGroup) next;
                if (StringsKt.equals(searchMappingGroup.getGroup(), "BuynowRange", true)) {
                    searchMappingGroup.setEnabled(z);
                    i3 = i4;
                }
                i4 = i5;
            }
        } else {
            z = false;
            i3 = -1;
        }
        if (!z && i3 != -1) {
            for (FacetXX selected : BDTUtils.INSTANCE.getSearchMappingArray().get(i).getGroups().get(i3).getListFacet()) {
                selected.setSelected(false);
            }
        }
        BDTUtils.INSTANCE.getFilterData(i);
    }

    private final Triple<Integer, Integer, Integer> getTriple(String str, String str2) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (Object next : BDTUtils.INSTANCE.getSearchMappingArray()) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int i6 = 0;
            for (Object next2 : ((SearchMappingArray) next).getGroups()) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                SearchMappingGroup searchMappingGroup = (SearchMappingGroup) next2;
                if (Intrinsics.areEqual((Object) searchMappingGroup.getGroup(), (Object) str)) {
                    int i8 = 0;
                    for (Object next3 : searchMappingGroup.getListFacet()) {
                        int i9 = i8 + 1;
                        if (i8 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        if (Intrinsics.areEqual((Object) ((FacetXX) next3).getValue(), (Object) str2)) {
                            i3 = i8;
                        }
                        i8 = i9;
                    }
                    i = i4;
                    i2 = i6;
                }
                i6 = i7;
            }
            i4 = i5;
        }
        return new Triple<>(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    private final void addHeaderForSavedSearchFacet() {
        ArrayList arrayList = new ArrayList();
        for (SelectedRefinerIndicesModel selectedRefinerIndicesModel : this.selectedIndices) {
            arrayList.add(new Triple(Integer.valueOf(selectedRefinerIndicesModel.getTabPosition()), Integer.valueOf(selectedRefinerIndicesModel.getParentPosition()), Integer.valueOf(selectedRefinerIndicesModel.getChildPosition())));
        }
        ArrayList<FacetXX> arrayList2 = this.selectedFacets;
        RefinerResultHeaderModel refinerResultHeaderModel = new RefinerResultHeaderModel(arrayList2, arrayList, arrayList2.size(), "", false);
        RefinerResultListAdapter refinerResultListAdapter2 = this.refinerResultListAdapter;
        if (refinerResultListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultListAdapter");
        }
        refinerResultListAdapter2.setHeaderItem(refinerResultHeaderModel, this);
        RefinerResultListAdapter refinerResultListAdapter3 = this.refinerResultListAdapter;
        if (refinerResultListAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refinerResultListAdapter");
        }
        refinerResultListAdapter3.notifyItemChanged(0);
    }
}
