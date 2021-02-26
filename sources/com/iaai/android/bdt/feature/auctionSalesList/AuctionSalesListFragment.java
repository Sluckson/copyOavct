package com.iaai.android.bdt.feature.auctionSalesList;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.auctionSalesList.AuctionDetails;
import com.iaai.android.bdt.model.auctionSalesList.AuctionSaleList;
import com.iaai.android.bdt.model.auctionSalesList.RequestBody;
import com.iaai.android.bdt.model.profile.UpdateWatchListResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.managers.BidManager;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 j2\u00020\u0001:\u0001jB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u0004H\u0002J\u0010\u0010H\u001a\u00020F2\u0006\u0010I\u001a\u00020'H\u0002J\b\u0010J\u001a\u00020FH\u0002J\u0006\u0010K\u001a\u00020FJ\u0010\u0010L\u001a\u00020F2\u0006\u0010M\u001a\u00020\u001dH\u0002J\b\u0010N\u001a\u00020OH\u0002J\b\u0010P\u001a\u00020FH\u0002J\b\u0010Q\u001a\u00020FH\u0002J\u0012\u0010R\u001a\u00020F2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\"\u0010U\u001a\u00020F2\u0006\u0010V\u001a\u00020\u00122\u0006\u0010W\u001a\u00020\u00122\b\u0010X\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010Y\u001a\u00020F2\u0006\u0010Z\u001a\u00020[H\u0016J\u0012\u0010\\\u001a\u00020F2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J&\u0010]\u001a\u0004\u0018\u00010?2\u0006\u0010^\u001a\u00020_2\b\u0010`\u001a\u0004\u0018\u00010a2\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\b\u0010b\u001a\u00020FH\u0016J\b\u0010c\u001a\u00020FH\u0016J\b\u0010d\u001a\u00020FH\u0016J\u0010\u0010e\u001a\u00020F2\u0006\u0010I\u001a\u00020'H\u0002J\u0010\u0010f\u001a\u00020F2\u0006\u0010g\u001a\u00020\u001dH\u0002J\b\u0010h\u001a\u00020FH\u0002J\u0010\u0010i\u001a\u00020F2\u0006\u0010%\u001a\u00020\u001dH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u000e\u0010%\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u000400j\b\u0012\u0004\u0012\u00020\u0004`1X\u000e¢\u0006\u0002\n\u0000R\u001e\u00102\u001a\u0012\u0012\u0004\u0012\u00020\u000400j\b\u0012\u0004\u0012\u00020\u0004`1X\u000e¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u0002048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X.¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u0004\u0018\u00010?X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u000e\u0010D\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006k"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "action", "auctionDetails", "Lcom/iaai/android/bdt/model/auctionSalesList/AuctionDetails;", "auctionSalesListActivity", "Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListActivity;", "auctionSalesListAdapter", "Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListAdapter;", "bidManager", "Lcom/iaai/android/old/managers/BidManager;", "branchId", "branchName", "currentCount", "", "errorType", "Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "indexToUpdate", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "isError", "", "isFristTime", "()Z", "setFristTime", "(Z)V", "isLoggedIn", "isTablet", "setTablet", "isWatching", "itemIdWatch", "", "laneFilter", "lastSelectedSort", "live_date", "livedate", "Ljava/util/Date;", "loseTypeFilter", "name", "scopeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "scopeListLaneCount", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "totalCount", "userId", "vehiclecount", "viewModel", "Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListViewModel;", "viewSaleList", "Landroid/view/View;", "getViewSaleList", "()Landroid/view/View;", "setViewSaleList", "(Landroid/view/View;)V", "year_make_model", "addHeaderToAuctionSalesList", "", "errorMessage", "addToWatchList", "itemId", "checkNetworkConnection", "clearFilterAndSortValues", "fetchAuctionSalesList", "isFilterApplied", "getRequestBody", "Lcom/iaai/android/bdt/model/auctionSalesList/RequestBody;", "initializeRecycler", "launchIBidLive", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onResume", "onStart", "removeFromWatchList", "showLoadingIndicator", "loading", "subscribeToViewModel", "updateWatchUI", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionSalesListFragment.kt */
public final class AuctionSalesListFragment extends BaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SAMPLE = "sample";
    /* access modifiers changed from: private */
    public final String TAG = AuctionSalesListFragment.class.getSimpleName();
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public String action = "";
    /* access modifiers changed from: private */
    public AuctionDetails auctionDetails;
    /* access modifiers changed from: private */
    public AuctionSalesListActivity auctionSalesListActivity;
    /* access modifiers changed from: private */
    public AuctionSalesListAdapter auctionSalesListAdapter;
    private BidManager bidManager;
    /* access modifiers changed from: private */
    public String branchId = "";
    private String branchName = "";
    /* access modifiers changed from: private */
    public int currentCount;
    /* access modifiers changed from: private */
    public BaseFragment.ErrorType errorType;
    /* access modifiers changed from: private */
    public int indexToUpdate;
    @Nullable
    private Intent intent;
    /* access modifiers changed from: private */
    public boolean isError;
    private boolean isFristTime = true;
    /* access modifiers changed from: private */
    public boolean isLoggedIn;
    private boolean isTablet;
    private boolean isWatching;
    /* access modifiers changed from: private */
    public long itemIdWatch;
    private String laneFilter = "";
    /* access modifiers changed from: private */
    public int lastSelectedSort;
    /* access modifiers changed from: private */
    public String live_date = "";
    private Date livedate;
    private String loseTypeFilter = "";
    private String name = "";
    /* access modifiers changed from: private */
    public ArrayList<String> scopeList = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<String> scopeListLaneCount = new ArrayList<>();
    @Inject
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public int totalCount;
    private String userId = "";
    /* access modifiers changed from: private */
    public int vehiclecount;
    /* access modifiers changed from: private */
    public AuctionSalesListViewModel viewModel;
    @Nullable
    private View viewSaleList;
    /* access modifiers changed from: private */
    public String year_make_model = "";

    @JvmStatic
    @NotNull
    public static final AuctionSalesListFragment newInstance(@NotNull String str) {
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

    public static final /* synthetic */ AuctionDetails access$getAuctionDetails$p(AuctionSalesListFragment auctionSalesListFragment) {
        AuctionDetails auctionDetails2 = auctionSalesListFragment.auctionDetails;
        if (auctionDetails2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionDetails");
        }
        return auctionDetails2;
    }

    public static final /* synthetic */ AuctionSalesListActivity access$getAuctionSalesListActivity$p(AuctionSalesListFragment auctionSalesListFragment) {
        AuctionSalesListActivity auctionSalesListActivity2 = auctionSalesListFragment.auctionSalesListActivity;
        if (auctionSalesListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        return auctionSalesListActivity2;
    }

    public static final /* synthetic */ AuctionSalesListAdapter access$getAuctionSalesListAdapter$p(AuctionSalesListFragment auctionSalesListFragment) {
        AuctionSalesListAdapter auctionSalesListAdapter2 = auctionSalesListFragment.auctionSalesListAdapter;
        if (auctionSalesListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListAdapter");
        }
        return auctionSalesListAdapter2;
    }

    public static final /* synthetic */ BaseFragment.ErrorType access$getErrorType$p(AuctionSalesListFragment auctionSalesListFragment) {
        BaseFragment.ErrorType errorType2 = auctionSalesListFragment.errorType;
        if (errorType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorType");
        }
        return errorType2;
    }

    public static final /* synthetic */ AuctionSalesListViewModel access$getViewModel$p(AuctionSalesListFragment auctionSalesListFragment) {
        AuctionSalesListViewModel auctionSalesListViewModel = auctionSalesListFragment.viewModel;
        if (auctionSalesListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return auctionSalesListViewModel;
    }

    public final boolean isTablet() {
        return this.isTablet;
    }

    public final void setTablet(boolean z) {
        this.isTablet = z;
    }

    @Nullable
    public final Intent getIntent() {
        return this.intent;
    }

    public final void setIntent(@Nullable Intent intent2) {
        this.intent = intent2;
    }

    public final boolean isFristTime() {
        return this.isFristTime;
    }

    public final void setFristTime(boolean z) {
        this.isFristTime = z;
    }

    @Nullable
    public final View getViewSaleList() {
        return this.viewSaleList;
    }

    public final void setViewSaleList(@Nullable View view) {
        this.viewSaleList = view;
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
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.auctionSalesListActivity = (AuctionSalesListActivity) activity;
            if (context instanceof AuctionSalesListActivity) {
                this.auctionSalesListActivity = (AuctionSalesListActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity");
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListFragment$Companion;", "", "()V", "KEY_SAMPLE", "", "newInstance", "Lcom/iaai/android/bdt/feature/auctionSalesList/AuctionSalesListFragment;", "url", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: AuctionSalesListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final AuctionSalesListFragment newInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            AuctionSalesListFragment auctionSalesListFragment = new AuctionSalesListFragment();
            Bundle bundle = new Bundle();
            bundle.putString(AuctionSalesListFragment.KEY_SAMPLE, str);
            auctionSalesListFragment.setArguments(bundle);
            return auctionSalesListFragment;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String property = System.getProperty("http.agent");
        Intrinsics.checkExpressionValueIsNotNull(property, "System.getProperty(\"http.agent\")");
        Log.d("UserAgent", property);
        AuctionSalesListActivity auctionSalesListActivity2 = this.auctionSalesListActivity;
        if (auctionSalesListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        FragmentActivity fragmentActivity = auctionSalesListActivity2;
        AuctionSalesListActivity auctionSalesListActivity3 = this.auctionSalesListActivity;
        if (auctionSalesListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, auctionSalesListActivity3.getViewModelFactory()).get(AuctionSalesListViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(au…istViewModel::class.java)");
        this.viewModel = (AuctionSalesListViewModel) viewModel2;
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application != null) {
            Object instance = ((IaaiApplication) application).getInjector().getInstance(BidManager.class);
            Intrinsics.checkExpressionValueIsNotNull(instance, "injector.getInstance(BidManager::class.java)");
            this.bidManager = (BidManager) instance;
            clearFilterAndSortValues();
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.IaaiApplication");
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        AuctionSalesListActivity auctionSalesListActivity2 = this.auctionSalesListActivity;
        if (auctionSalesListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        this.isTablet = auctionSalesListActivity2.getResources().getBoolean(C2723R.bool.isTabletPhone);
        if (this.viewSaleList == null) {
            if (this.isTablet) {
                ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.activity_auction_sales_list_land, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "mBinding");
                this.viewSaleList = inflate.getRoot();
            } else {
                ViewDataBinding inflate2 = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.activity_auction_sales_list, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate2, "mBinding");
                this.viewSaleList = inflate2.getRoot();
            }
        }
        View view = this.viewSaleList;
        return this.viewSaleList;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        this.branchId = arguments.getString(Constants.EXTRA_BRANCH).toString();
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            Intrinsics.throwNpe();
        }
        this.name = arguments2.getString(Constants.EXTRA_NAME).toString();
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            Intrinsics.throwNpe();
        }
        this.live_date = arguments3.getString(Constants.EXTRA_DATE).toString();
        Bundle arguments4 = getArguments();
        if (arguments4 == null) {
            Intrinsics.throwNpe();
        }
        this.branchName = arguments4.getString(Constants.EXTRA_BRANCH_NAME_TITLE).toString();
        Bundle arguments5 = getArguments();
        if (arguments5 == null) {
            Intrinsics.throwNpe();
        }
        this.vehiclecount = arguments5.getInt(Constants.EXTRA_AUCTION_VEHICLE_COUNT);
        this.livedate = NewDateHelper.INSTANCE.parseDateInServerTimezone(this.live_date);
        AuctionSalesListActivity auctionSalesListActivity2 = this.auctionSalesListActivity;
        if (auctionSalesListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        Application application = auctionSalesListActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "auctionSalesListActivity.application");
        String userIdPreferencesMVVM = IAASharedPreference.getUserIdPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM, "IAASharedPreference.getU…ation.applicationContext)");
        this.userId = userIdPreferencesMVVM;
        AuctionSalesListActivity auctionSalesListActivity3 = this.auctionSalesListActivity;
        if (auctionSalesListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        Application application2 = auctionSalesListActivity3.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application2, "auctionSalesListActivity.application");
        Boolean isLoggedInPreferencesMVVM = IAASharedPreference.getIsLoggedInPreferencesMVVM(application2.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(isLoggedInPreferencesMVVM, "IAASharedPreference.getI…ation.applicationContext)");
        this.isLoggedIn = isLoggedInPreferencesMVVM.booleanValue();
        AuctionSalesListActivity auctionSalesListActivity4 = this.auctionSalesListActivity;
        if (auctionSalesListActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        ImageView imageView = (ImageView) auctionSalesListActivity4._$_findCachedViewById(C2723R.C2726id.arrow_left);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "auctionSalesListActivity.arrow_left");
        imageView.setVisibility(8);
        AuctionSalesListActivity auctionSalesListActivity5 = this.auctionSalesListActivity;
        if (auctionSalesListActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        ImageView imageView2 = (ImageView) auctionSalesListActivity5._$_findCachedViewById(C2723R.C2726id.arrow_right);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "auctionSalesListActivity.arrow_right");
        imageView2.setVisibility(8);
        AuctionSalesListActivity auctionSalesListActivity6 = this.auctionSalesListActivity;
        if (auctionSalesListActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        RelativeLayout relativeLayout = (RelativeLayout) auctionSalesListActivity6._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "auctionSalesListActivity.toolbar_relativelayout");
        relativeLayout.setGravity(GravityCompat.START);
        AuctionSalesListActivity auctionSalesListActivity7 = this.auctionSalesListActivity;
        if (auctionSalesListActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) auctionSalesListActivity7._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "auctionSalesListActivity.toolbar_relativelayout");
        relativeLayout2.setGravity(3);
        AuctionSalesListActivity auctionSalesListActivity8 = this.auctionSalesListActivity;
        if (auctionSalesListActivity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        auctionSalesListActivity8.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_bdt_sales_list));
        AuctionSalesListActivity auctionSalesListActivity9 = this.auctionSalesListActivity;
        if (auctionSalesListActivity9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        auctionSalesListActivity9.getToolbar_sub_title().setVisibility(8);
        AuctionSalesListActivity auctionSalesListActivity10 = this.auctionSalesListActivity;
        if (auctionSalesListActivity10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        auctionSalesListActivity10.getToolbar_sub_title().setText(DateHelper.formatAuctionDate(this.livedate));
        if (this.isTablet) {
            AuctionSalesListActivity auctionSalesListActivity11 = this.auctionSalesListActivity;
            if (auctionSalesListActivity11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
            }
            NavController findNavController = Navigation.findNavController(auctionSalesListActivity11, C2723R.C2726id.auction_sales_nav_container);
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

    private final void initializeRecycler() {
        this.isFristTime = false;
        AuctionSalesListActivity auctionSalesListActivity2 = this.auctionSalesListActivity;
        if (auctionSalesListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionSales)).addItemDecoration(new DividerItemDecoration(auctionSalesListActivity2, 1));
        AuctionSalesListViewModel auctionSalesListViewModel = this.viewModel;
        if (auctionSalesListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "activity!!.applicationContext");
        this.auctionSalesListAdapter = new AuctionSalesListAdapter(auctionSalesListViewModel, applicationContext, new AuctionSalesListFragment$initializeRecycler$1(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionSales);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvAuctionSales");
        AuctionSalesListAdapter auctionSalesListAdapter2 = this.auctionSalesListAdapter;
        if (auctionSalesListAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListAdapter");
        }
        recyclerView.setAdapter(auctionSalesListAdapter2);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionSales);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvAuctionSales");
        AuctionSalesListActivity auctionSalesListActivity3 = this.auctionSalesListActivity;
        if (auctionSalesListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(auctionSalesListActivity3));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionSales)).addOnScrollListener(new AuctionSalesListFragment$initializeRecycler$2(this));
        ((FloatingActionButton) _$_findCachedViewById(C2723R.C2726id.fab)).setOnClickListener(new AuctionSalesListFragment$initializeRecycler$3(this));
    }

    private final void subscribeToViewModel() {
        AuctionSalesListViewModel auctionSalesListViewModel = this.viewModel;
        if (auctionSalesListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        auctionSalesListViewModel.getAuctionSalesResult().observe(lifecycleOwner, new AuctionSalesListFragment$subscribeToViewModel$1(this));
        AuctionSalesListViewModel auctionSalesListViewModel2 = this.viewModel;
        if (auctionSalesListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionSalesListViewModel2.getAuctionSalesError().observe(lifecycleOwner, new AuctionSalesListFragment$subscribeToViewModel$2(this));
        AuctionSalesListViewModel auctionSalesListViewModel3 = this.viewModel;
        if (auctionSalesListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionSalesListViewModel3.getResultLiveData().observe(lifecycleOwner, new AuctionSalesListFragment$subscribeToViewModel$3(this));
        AuctionSalesListViewModel auctionSalesListViewModel4 = this.viewModel;
        if (auctionSalesListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionSalesListViewModel4.getNetworkState().observe(lifecycleOwner, AuctionSalesListFragment$subscribeToViewModel$4.INSTANCE);
        AuctionSalesListViewModel auctionSalesListViewModel5 = this.viewModel;
        if (auctionSalesListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionSalesListViewModel5.getScrollSearchListToTop().observe(lifecycleOwner, new AuctionSalesListFragment$subscribeToViewModel$5(this));
        AuctionSalesListViewModel auctionSalesListViewModel6 = this.viewModel;
        if (auctionSalesListViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<UpdateWatchListResponse> watchStatusResponse = auctionSalesListViewModel6.getWatchStatusResponse();
        AuctionSalesListActivity auctionSalesListActivity2 = this.auctionSalesListActivity;
        if (auctionSalesListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        watchStatusResponse.observe(auctionSalesListActivity2, new AuctionSalesListFragment$subscribeToViewModel$6(this));
        AuctionSalesListViewModel auctionSalesListViewModel7 = this.viewModel;
        if (auctionSalesListViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> watchStatusError = auctionSalesListViewModel7.getWatchStatusError();
        AuctionSalesListActivity auctionSalesListActivity3 = this.auctionSalesListActivity;
        if (auctionSalesListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        watchStatusError.observe(auctionSalesListActivity3, new AuctionSalesListFragment$subscribeToViewModel$7(this));
    }

    /* access modifiers changed from: private */
    public final void launchIBidLive() {
        String format = NewDateHelper.INSTANCE.format(NewDateHelper.INSTANCE.getDateFromString(this.live_date), Constants.DATE_PATTERN_WEBSERVICE_PARAM);
        BidManager bidManager2 = this.bidManager;
        if (bidManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bidManager");
        }
        AuctionSalesListActivity auctionSalesListActivity2 = this.auctionSalesListActivity;
        if (auctionSalesListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        bidManager2.launchIBidLiveFromProductDetail(auctionSalesListActivity2, this.branchId, format, false, false);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r0.getBooleanExtra(com.iaai.android.bdt.utils.Constants_MVVM.EXTRA_IS_FILTER_APPLIED, false) == false) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        if (r0.getBooleanExtra(com.iaai.android.bdt.utils.Constants_MVVM.EXTRA_IS_SORT_APPLIED, false) != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003b, code lost:
        r0 = com.iaai.android.old.utils.IAASharedPreference.getYearFilterPreferencesMVVM(getActivity());
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, "IAASharedPreference.getY…PreferencesMVVM(activity)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0051, code lost:
        if (r0.length() <= 0) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0053, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0055, code lost:
        r0 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        if (r0 == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0058, code lost:
        r0 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005a, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005b, code lost:
        r3 = com.iaai.android.old.utils.IAASharedPreference.getLaneFilterPreferencesMVVM(getActivity());
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, "IAASharedPreference.getL…PreferencesMVVM(activity)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        if (r3.length() <= 0) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0072, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0074, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0075, code lost:
        if (r3 == false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0077, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0079, code lost:
        r3 = com.iaai.android.old.utils.IAASharedPreference.getLossLypeFilterPreferencesMVVM(getActivity());
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, "IAASharedPreference.getL…PreferencesMVVM(activity)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008c, code lost:
        if (r3.length() <= 0) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008e, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008f, code lost:
        if (r1 == 0) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0091, code lost:
        r1 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0094, code lost:
        r1 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addHeaderToAuctionSalesList(java.lang.String r6) {
        /*
            r5 = this;
            android.content.Intent r0 = r5.intent
            r1 = 0
            if (r0 == 0) goto L_0x0096
            if (r0 != 0) goto L_0x000a
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x000a:
            java.lang.String r2 = "isFilterApplied"
            boolean r0 = r0.hasExtra(r2)
            if (r0 == 0) goto L_0x001f
            android.content.Intent r0 = r5.intent
            if (r0 != 0) goto L_0x0019
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0019:
            boolean r0 = r0.getBooleanExtra(r2, r1)
            if (r0 != 0) goto L_0x003b
        L_0x001f:
            android.content.Intent r0 = r5.intent
            if (r0 != 0) goto L_0x0026
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0026:
            java.lang.String r2 = "isSortApplied"
            boolean r0 = r0.hasExtra(r2)
            if (r0 == 0) goto L_0x009a
            android.content.Intent r0 = r5.intent
            if (r0 != 0) goto L_0x0035
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0035:
            boolean r0 = r0.getBooleanExtra(r2, r1)
            if (r0 == 0) goto L_0x009a
        L_0x003b:
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r0 = com.iaai.android.old.utils.IAASharedPreference.getYearFilterPreferencesMVVM(r0)
            java.lang.String r2 = "IAASharedPreference.getY…PreferencesMVVM(activity)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r2 = 1
            if (r0 <= 0) goto L_0x0055
            r0 = 1
            goto L_0x0056
        L_0x0055:
            r0 = 0
        L_0x0056:
            if (r0 == 0) goto L_0x005a
            r0 = 1
            goto L_0x005b
        L_0x005a:
            r0 = 0
        L_0x005b:
            androidx.fragment.app.FragmentActivity r3 = r5.getActivity()
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r3 = com.iaai.android.old.utils.IAASharedPreference.getLaneFilterPreferencesMVVM(r3)
            java.lang.String r4 = "IAASharedPreference.getL…PreferencesMVVM(activity)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0074
            r3 = 1
            goto L_0x0075
        L_0x0074:
            r3 = 0
        L_0x0075:
            if (r3 == 0) goto L_0x0079
            int r0 = r0 + 1
        L_0x0079:
            androidx.fragment.app.FragmentActivity r3 = r5.getActivity()
            android.content.Context r3 = (android.content.Context) r3
            java.lang.String r3 = com.iaai.android.old.utils.IAASharedPreference.getLossLypeFilterPreferencesMVVM(r3)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x008f
            r1 = 1
        L_0x008f:
            if (r1 == 0) goto L_0x0094
            int r1 = r0 + 1
            goto L_0x009a
        L_0x0094:
            r1 = r0
            goto L_0x009a
        L_0x0096:
            int r0 = r5.currentCount
            r5.vehiclecount = r0
        L_0x009a:
            com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader r0 = new com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader
            r0.<init>()
            java.lang.String r2 = r5.branchName
            r0.setBranchName(r2)
            java.lang.String r2 = r5.live_date
            r0.setAuctionDate(r2)
            r0.setFilterCount(r1)
            boolean r1 = r5.isError
            r0.setError(r1)
            boolean r1 = r5.isError
            if (r1 == 0) goto L_0x0124
            com.iaai.android.bdt.base.BaseFragment$ErrorType r1 = r5.errorType
            java.lang.String r2 = "errorType"
            if (r1 != 0) goto L_0x00be
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x00be:
            int[] r3 = com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r3[r1]
            java.lang.String r3 = "getString(R.string.bdt_a…on_error_type_no_auction)"
            r4 = 2131820628(0x7f110054, float:1.9273976E38)
            switch(r1) {
                case 1: goto L_0x010b;
                case 2: goto L_0x00fe;
                case 3: goto L_0x00f1;
                case 4: goto L_0x00e9;
                case 5: goto L_0x00e1;
                case 6: goto L_0x00d4;
                case 7: goto L_0x0117;
                default: goto L_0x00ce;
            }
        L_0x00ce:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x00d4:
            r6 = 2131820640(0x7f110060, float:1.9274E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.bdt_l…_error_msg_no_item_found)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
            goto L_0x0117
        L_0x00e1:
            java.lang.String r6 = r5.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r3)
            goto L_0x0117
        L_0x00e9:
            java.lang.String r6 = r5.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r3)
            goto L_0x0117
        L_0x00f1:
            r6 = 2131820629(0x7f110055, float:1.9273978E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.bdt_a…tion_error_type_no_stock)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
            goto L_0x0117
        L_0x00fe:
            r6 = 2131820656(0x7f110070, float:1.9274033E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.bdt_lbl_msg_prd_network_error)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
            goto L_0x0117
        L_0x010b:
            r6 = 2131821566(0x7f1103fe, float:1.9275879E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.lbl_msg_no_internet_connection)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
        L_0x0117:
            r0.setErrorMessage(r6)
            com.iaai.android.bdt.base.BaseFragment$ErrorType r6 = r5.errorType
            if (r6 != 0) goto L_0x0121
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0121:
            r0.setErrorType(r6)
        L_0x0124:
            r6 = r5
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment r6 = (com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment) r6
            com.iaai.android.bdt.model.auctionSalesList.AuctionDetails r6 = r6.auctionDetails
            if (r6 == 0) goto L_0x0137
            com.iaai.android.bdt.model.auctionSalesList.AuctionDetails r6 = r5.auctionDetails
            if (r6 != 0) goto L_0x0134
            java.lang.String r1 = "auctionDetails"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0134:
            r0.setAuctionDetails(r6)
        L_0x0137:
            int r6 = r5.totalCount
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r0.setVehicalCount(r6)
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r6 = r5.auctionSalesListAdapter
            java.lang.String r1 = "auctionSalesListAdapter"
            if (r6 != 0) goto L_0x0149
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0149:
            r6.setHeaderItem(r0)
            com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListAdapter r6 = r5.auctionSalesListAdapter
            if (r6 != 0) goto L_0x0153
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0153:
            r6.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListFragment.addHeaderToAuctionSalesList(java.lang.String):void");
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

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
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
            AuctionSalesListViewModel auctionSalesListViewModel = this.viewModel;
            if (auctionSalesListViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            String str = this.branchId;
            Date date = this.livedate;
            if (date == null) {
                Intrinsics.throwNpe();
            }
            auctionSalesListViewModel.loadAuctionSalesList(format, str, date);
            fetchAuctionSalesList(false);
            return;
        }
        this.errorType = BaseFragment.ErrorType.NO_INTERNET;
        this.isError = true;
        addHeaderToAuctionSalesList("");
        IAAAnalytics.INSTANCE.logNetworkEvent("AuctionSaleListV2.svc/auctionsalelist", false, "", BaseFragment.ErrorType.NO_INTERNET.getValue());
        InternetUtil.INSTANCE.observe(this, new AuctionSalesListFragment$checkNetworkConnection$1(this));
    }

    /* access modifiers changed from: private */
    public final void fetchAuctionSalesList(boolean z) {
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
        AuctionSalesListViewModel auctionSalesListViewModel = this.viewModel;
        if (auctionSalesListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionSalesListViewModel.fetchAuctionSalesList(getRequestBody(), format, z);
        subscribeToViewModel();
    }

    private final RequestBody getRequestBody() {
        AuctionSaleList auctionSaleList;
        String str;
        int parseInt = Integer.parseInt(this.branchId);
        String format = DateHelper.format(NewDateHelper.INSTANCE.parse(this.live_date, Constants.DATE_PATTERN_DATE_TIME), Constants.DATE_PATTERN_WEBSERVICE_PARAM);
        Intent intent2 = this.intent;
        if (intent2 == null) {
            Intrinsics.checkExpressionValueIsNotNull(format, "wsDateString");
            String language = Utils.getLanguage();
            Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
            auctionSaleList = new AuctionSaleList(format, parseInt, language, "android", "", "0", 30, "", "", 30, "", 1, "", "", "", "");
        } else {
            if (intent2 == null) {
                Intrinsics.throwNpe();
            }
            if (intent2.hasExtra(Constants_MVVM.EXTRA_LANE)) {
                Intent intent3 = this.intent;
                if (intent3 == null) {
                    Intrinsics.throwNpe();
                }
                String stringExtra = intent3.getStringExtra(Constants_MVVM.EXTRA_LANE);
                Intrinsics.checkExpressionValueIsNotNull(stringExtra, "intent!!.getStringExtra(Constants_MVVM.EXTRA_LANE)");
                this.laneFilter = stringExtra;
            } else {
                String str2 = this.laneFilter;
            }
            Intent intent4 = this.intent;
            if (intent4 == null) {
                Intrinsics.throwNpe();
            }
            if (intent4.hasExtra(Constants_MVVM.EXTRA_LOSS_TYPE)) {
                Intent intent5 = this.intent;
                if (intent5 == null) {
                    Intrinsics.throwNpe();
                }
                String stringExtra2 = intent5.getStringExtra(Constants_MVVM.EXTRA_LOSS_TYPE);
                Intrinsics.checkExpressionValueIsNotNull(stringExtra2, "intent!!.getStringExtra(…nts_MVVM.EXTRA_LOSS_TYPE)");
                this.loseTypeFilter = stringExtra2;
            } else {
                String str3 = this.loseTypeFilter;
            }
            String sortDirectionPositionFilterPreferencesMVVM = IAASharedPreference.getSortDirectionPositionFilterPreferencesMVVM(getActivity());
            Intrinsics.checkExpressionValueIsNotNull(sortDirectionPositionFilterPreferencesMVVM, "IAASharedPreference.getS…PreferencesMVVM(activity)");
            boolean z = true;
            String str4 = "";
            if (!(sortDirectionPositionFilterPreferencesMVVM.length() > 0)) {
                str = str4;
            } else {
                str = IAASharedPreference.getSortDirectionPositionFilterPreferencesMVVM(getActivity());
            }
            Intrinsics.checkExpressionValueIsNotNull(format, "wsDateString");
            String language2 = Utils.getLanguage();
            Intrinsics.checkExpressionValueIsNotNull(language2, "Utils.getLanguage()");
            Intrinsics.checkExpressionValueIsNotNull(str, "sortColumn");
            String endYearFilterPreferencesMVVM = !IAASharedPreference.getEndYearFilterPreferencesMVVM(getActivity()).equals(str4) ? IAASharedPreference.getEndYearFilterPreferencesMVVM(getActivity()) : str4;
            Intrinsics.checkExpressionValueIsNotNull(endYearFilterPreferencesMVVM, "if (!IAASharedPreference…cesMVVM(activity) else \"\"");
            String str5 = this.laneFilter;
            String sortItemFilterPreferencesMVVM = IAASharedPreference.getSortItemFilterPreferencesMVVM(getActivity());
            Intrinsics.checkExpressionValueIsNotNull(sortItemFilterPreferencesMVVM, "IAASharedPreference.getS…PreferencesMVVM(activity)");
            if (sortItemFilterPreferencesMVVM.length() <= 0) {
                z = false;
            }
            String sortItemFilterPreferencesMVVM2 = z ? IAASharedPreference.getSortItemFilterPreferencesMVVM(getActivity()) : str4;
            Intrinsics.checkExpressionValueIsNotNull(sortItemFilterPreferencesMVVM2, "if(IAASharedPreference.g…cesMVVM(activity) else \"\"");
            if (!IAASharedPreference.getStartYearFilterPreferencesMVVM(getActivity()).equals(str4)) {
                str4 = IAASharedPreference.getStartYearFilterPreferencesMVVM(getActivity());
            }
            Intrinsics.checkExpressionValueIsNotNull(str4, "if (!IAASharedPreference…cesMVVM(activity) else \"\"");
            auctionSaleList = new AuctionSaleList(format, parseInt, language2, "android", "", str, 30, endYearFilterPreferencesMVVM, str5, 30, sortItemFilterPreferencesMVVM2, 1, str4, "", "", this.loseTypeFilter);
        }
        return new RequestBody(auctionSaleList);
    }

    private final void updateWatchUI(boolean z) {
        if (z) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llUnWatchLayout);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llUnWatchLayout");
            linearLayout.setVisibility(0);
            LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llWatchLayout);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "llWatchLayout");
            linearLayout2.setVisibility(8);
            return;
        }
        LinearLayout linearLayout3 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llUnWatchLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llUnWatchLayout");
        linearLayout3.setVisibility(8);
        LinearLayout linearLayout4 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.llWatchLayout);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "llWatchLayout");
        linearLayout4.setVisibility(0);
    }

    public void onDestroy() {
        super.onDestroy();
        AuctionSalesListViewModel auctionSalesListViewModel = this.viewModel;
        if (auctionSalesListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionSalesListViewModel.disposeElements();
    }

    public final void clearFilterAndSortValues() {
        if (isAdded()) {
            IAASharedPreference.setLossTypeItemPosPreferencesMVVM(getActivity(), 0);
            IAASharedPreference.setEndYearFilterPreferencesMVVM(getActivity(), "");
            IAASharedPreference.setStartYearFilterPreferencesMVVM(getActivity(), "");
            IAASharedPreference.setYearFilterPreferencesMVVM(getActivity(), "");
            IAASharedPreference.setLaneFilterPreferencesMVVM(getActivity(), "");
            IAASharedPreference.setLossTypeFilterPreferencesMVVM(getActivity(), "");
            IAASharedPreference.setSortDirectionPreferencesMVVM(getActivity(), "");
            IAASharedPreference.setSortItemPositionPreferencesMVVM(getActivity(), 0);
            IAASharedPreference.setSortItemPreferencesMVVM(getActivity(), "");
        }
    }

    /* access modifiers changed from: private */
    public final void addToWatchList(long j) {
        AuctionSalesListActivity auctionSalesListActivity2 = this.auctionSalesListActivity;
        if (auctionSalesListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        Application application = auctionSalesListActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "auctionSalesListActivity.application");
        String userIdPreferencesMVVM = IAASharedPreference.getUserIdPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM, "IAASharedPreference.getU…ation.applicationContext)");
        this.userId = userIdPreferencesMVVM;
        String string = getResources().getString(C2723R.string.lbl_watch_action_add);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.lbl_watch_action_add)");
        this.action = string;
        AuctionSalesListViewModel auctionSalesListViewModel = this.viewModel;
        if (auctionSalesListViewModel == null) {
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
        auctionSalesListViewModel.updateWatchStatus(format, String.valueOf(j), this.userId, this.action);
    }

    /* access modifiers changed from: private */
    public final void removeFromWatchList(long j) {
        String string = getResources().getString(C2723R.string.lbl_watch_action_delete);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st….lbl_watch_action_delete)");
        this.action = string;
        AuctionSalesListViewModel auctionSalesListViewModel = this.viewModel;
        if (auctionSalesListViewModel == null) {
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
        auctionSalesListViewModel.updateWatchStatus(format, String.valueOf(j), this.userId, this.action);
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent2) {
        if (i2 == -1) {
            if (i == 26) {
                addToWatchList(this.itemIdWatch);
            } else if (i == 29) {
                fetchAuctionSalesList(false);
                launchIBidLive();
            }
        }
        if ((i2 == 1 || i2 == 2) && intent2 != null) {
            this.intent = intent2;
            fetchAuctionSalesList(true);
        }
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

    public void onResume() {
        super.onResume();
        AuctionSalesListActivity auctionSalesListActivity2 = this.auctionSalesListActivity;
        if (auctionSalesListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        auctionSalesListActivity2.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_bdt_sales_list));
        AuctionSalesListActivity auctionSalesListActivity3 = this.auctionSalesListActivity;
        if (auctionSalesListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        auctionSalesListActivity3.getToolbar_sub_title().setVisibility(8);
        AuctionSalesListActivity auctionSalesListActivity4 = this.auctionSalesListActivity;
        if (auctionSalesListActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        auctionSalesListActivity4.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_black));
        AuctionSalesListActivity auctionSalesListActivity5 = this.auctionSalesListActivity;
        if (auctionSalesListActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionSalesListActivity");
        }
        auctionSalesListActivity5.getIvStockShare().setVisibility(8);
    }
}
