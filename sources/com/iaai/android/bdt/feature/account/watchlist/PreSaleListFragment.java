package com.iaai.android.bdt.feature.account.watchlist;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.braintreepayments.api.models.PayPalRequest;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.profile.UpdateWatchListResponse;
import com.iaai.android.bdt.model.sort.SortOptionData;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.support.AndroidSupportInjection;
import java.util.Arrays;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 |2\u00020\u0001:\u0001|B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u0004H\u0002J\u0010\u0010L\u001a\u00020J2\u0006\u0010M\u001a\u00020\u001cH\u0002J\b\u0010N\u001a\u00020JH\u0002J(\u0010O\u001a\u00020J2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004H\u0002J \u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\b2\u0006\u0010X\u001a\u00020\u0013H\u0002J \u0010Y\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\b2\u0006\u0010X\u001a\u00020\u0013H\u0002J \u0010Z\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\b2\u0006\u0010X\u001a\u00020\u0013H\u0002J \u0010[\u001a\u00020U2\u0006\u0010V\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\b2\u0006\u0010X\u001a\u00020\u0013H\u0002J\b\u0010\\\u001a\u00020JH\u0002J\b\u0010]\u001a\u00020JH\u0002J\u0006\u0010^\u001a\u00020JJ\b\u0010_\u001a\u00020JH\u0002J(\u0010`\u001a\u00020J2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010a\u001a\u00020\u00132\u0006\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u0004H\u0002J\u0012\u0010b\u001a\u00020J2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J\"\u0010e\u001a\u00020J2\u0006\u0010f\u001a\u00020\b2\u0006\u0010g\u001a\u00020\b2\b\u0010h\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010i\u001a\u00020J2\u0006\u0010j\u001a\u00020kH\u0016J\u0012\u0010l\u001a\u00020J2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J&\u0010m\u001a\u0004\u0018\u00010C2\u0006\u0010n\u001a\u00020o2\b\u0010p\u001a\u0004\u0018\u00010q2\b\u0010c\u001a\u0004\u0018\u00010dH\u0016J\b\u0010r\u001a\u00020JH\u0016J\b\u0010s\u001a\u00020JH\u0016J\u0010\u0010t\u001a\u00020J2\u0006\u0010M\u001a\u00020\u001cH\u0002J\u0010\u0010u\u001a\u00020J2\u0006\u00107\u001a\u00020\bH\u0002J\u0006\u0010v\u001a\u00020JJ\u000e\u0010w\u001a\u00020J2\u0006\u00107\u001a\u00020\bJ\u0010\u0010x\u001a\u00020J2\u0006\u0010y\u001a\u00020\u0013H\u0002J\b\u0010z\u001a\u00020JH\u0002J\b\u0010{\u001a\u00020JH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X.¢\u0006\u0002\n\u0000R\u001e\u0010'\u001a\u00020(8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u00107\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X.¢\u0006\u0002\n\u0000R\u001e\u0010<\u001a\u00020=8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001c\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u000e\u0010H\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006}"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "action", "currentCount", "", "errorType", "Lcom/iaai/android/bdt/base/BaseFragment$ErrorType;", "indexToUpdate", "intent", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "isError", "", "isFristTime", "isLoggedIn", "isMyItemsOnly", "isTablet", "()Z", "setTablet", "(Z)V", "itemIdWatch", "", "lastSelectedPurchaseSort", "lastSelectedSort", "mKeywordSearch", "myAccountStatus", "param1", "param2", "preSaleAdapter", "Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListAdapter;", "preSaleListActivity", "Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListActivity;", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "sortBy", "getSortBy", "()Ljava/lang/String;", "setSortBy", "(Ljava/lang/String;)V", "sortDirection", "getSortDirection", "()I", "setSortDirection", "(I)V", "totalCount", "totalCountWatchDashBoard", "userId", "viewModel", "Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "viewWatchList", "Landroid/view/View;", "getViewWatchList", "()Landroid/view/View;", "setViewWatchList", "(Landroid/view/View;)V", "year_make_model", "addHeaderToAuctionSalesList", "", "errorMessage", "addToWatchList", "itemId", "checkNetworkConnection", "checkWriteStoragePermission", "receiptNo", "receipt", "receiptSubjectLine", "salvageID", "createSortOptionAwardData", "Lcom/iaai/android/bdt/model/sort/SortOptionData;", "displayText", "position", "isSelected", "createSortOptionData", "createSortOptionLostPreBidData", "createSortOptionPurchaseHistoryData", "fetchWatchList", "handleStockSearch", "hideSoftKeyboard", "initializeRecycler", "navigateToReceiptPage", "isReceipt", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onStart", "removeFromWatchList", "setDashBoardCountAtSharePreference", "setToolBarTitle", "setToolbarCount", "showLoadingIndicator", "loading", "showSoftKeyboard", "subscribeToViewModel", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListFragment.kt */
public final class PreSaleListFragment extends BaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final String TAG = PreSaleListFragment.class.getSimpleName();
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public String action = "";
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
    private boolean isMyItemsOnly;
    private boolean isTablet;
    /* access modifiers changed from: private */
    public long itemIdWatch;
    /* access modifiers changed from: private */
    public int lastSelectedPurchaseSort = 3;
    /* access modifiers changed from: private */
    public int lastSelectedSort;
    /* access modifiers changed from: private */
    public String mKeywordSearch = "";
    /* access modifiers changed from: private */
    public String myAccountStatus = "";
    private String param1;
    private String param2;
    /* access modifiers changed from: private */
    public PreSaleListAdapter preSaleAdapter;
    /* access modifiers changed from: private */
    public PreSaleListActivity preSaleListActivity;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    @Nullable
    private String sortBy;
    private int sortDirection;
    /* access modifiers changed from: private */
    public int totalCount;
    /* access modifiers changed from: private */
    public int totalCountWatchDashBoard;
    private String userId = "";
    /* access modifiers changed from: private */
    public PreSaleListViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;
    @Nullable
    private View viewWatchList;
    /* access modifiers changed from: private */
    public String year_make_model = "";

    @JvmStatic
    @NotNull
    public static final PreSaleListFragment newInstance(@NotNull String str, @NotNull String str2) {
        return Companion.newInstance(str, str2);
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

    public static final /* synthetic */ BaseFragment.ErrorType access$getErrorType$p(PreSaleListFragment preSaleListFragment) {
        BaseFragment.ErrorType errorType2 = preSaleListFragment.errorType;
        if (errorType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("errorType");
        }
        return errorType2;
    }

    public static final /* synthetic */ PreSaleListAdapter access$getPreSaleAdapter$p(PreSaleListFragment preSaleListFragment) {
        PreSaleListAdapter preSaleListAdapter = preSaleListFragment.preSaleAdapter;
        if (preSaleListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleAdapter");
        }
        return preSaleListAdapter;
    }

    public static final /* synthetic */ PreSaleListActivity access$getPreSaleListActivity$p(PreSaleListFragment preSaleListFragment) {
        PreSaleListActivity preSaleListActivity2 = preSaleListFragment.preSaleListActivity;
        if (preSaleListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        return preSaleListActivity2;
    }

    public static final /* synthetic */ PreSaleListViewModel access$getViewModel$p(PreSaleListFragment preSaleListFragment) {
        PreSaleListViewModel preSaleListViewModel = preSaleListFragment.viewModel;
        if (preSaleListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return preSaleListViewModel;
    }

    @Nullable
    public final String getSortBy() {
        return this.sortBy;
    }

    public final void setSortBy(@Nullable String str) {
        this.sortBy = str;
    }

    public final int getSortDirection() {
        return this.sortDirection;
    }

    public final void setSortDirection(int i) {
        this.sortDirection = i;
    }

    public final boolean isTablet() {
        return this.isTablet;
    }

    public final void setTablet(boolean z) {
        this.isTablet = z;
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

    @Nullable
    public final View getViewWatchList() {
        return this.viewWatchList;
    }

    public final void setViewWatchList(@Nullable View view) {
        this.viewWatchList = view;
    }

    @Nullable
    public final Intent getIntent() {
        return this.intent;
    }

    public final void setIntent(@Nullable Intent intent2) {
        this.intent = intent2;
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        PreSaleListActivity preSaleListActivity2 = this.preSaleListActivity;
        if (preSaleListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        FragmentActivity fragmentActivity = preSaleListActivity2;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(PreSaleListViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(pr…istViewModel::class.java)");
        this.viewModel = (PreSaleListViewModel) viewModel2;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.preSaleListActivity = (PreSaleListActivity) activity;
            if (context instanceof PreSaleListActivity) {
                this.preSaleListActivity = (PreSaleListActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity");
    }

    public void onStart() {
        super.onStart();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        PreSaleListActivity preSaleListActivity2 = this.preSaleListActivity;
        if (preSaleListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        this.isTablet = preSaleListActivity2.getResources().getBoolean(C2723R.bool.isTabletPhone);
        if (this.viewWatchList == null) {
            if (this.isTablet) {
                ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.activity_watch_list_land, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "mBinding");
                this.viewWatchList = inflate.getRoot();
            } else {
                ViewDataBinding inflate2 = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_watch_list, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate2, "mBinding");
                this.viewWatchList = inflate2.getRoot();
            }
        }
        return this.viewWatchList;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        PreSaleListActivity preSaleListActivity2 = this.preSaleListActivity;
        if (preSaleListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        ImageView imageView = (ImageView) preSaleListActivity2._$_findCachedViewById(C2723R.C2726id.arrow_left_watch);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "preSaleListActivity.arrow_left_watch");
        imageView.setVisibility(8);
        PreSaleListActivity preSaleListActivity3 = this.preSaleListActivity;
        if (preSaleListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        ImageView imageView2 = (ImageView) preSaleListActivity3._$_findCachedViewById(C2723R.C2726id.arrow_right_watch);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "preSaleListActivity.arrow_right_watch");
        imageView2.setVisibility(8);
        PreSaleListActivity preSaleListActivity4 = this.preSaleListActivity;
        if (preSaleListActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        RelativeLayout relativeLayout = (RelativeLayout) preSaleListActivity4._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "preSaleListActivity.toolbar_relativelayout");
        relativeLayout.setGravity(GravityCompat.START);
        PreSaleListActivity preSaleListActivity5 = this.preSaleListActivity;
        if (preSaleListActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) preSaleListActivity5._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "preSaleListActivity.toolbar_relativelayout");
        relativeLayout2.setGravity(3);
        PreSaleListActivity preSaleListActivity6 = this.preSaleListActivity;
        if (preSaleListActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        preSaleListActivity6.getIvStockShare().setVisibility(8);
        if (this.isTablet) {
            PreSaleListActivity preSaleListActivity7 = this.preSaleListActivity;
            if (preSaleListActivity7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
            }
            NavController findNavController = Navigation.findNavController(preSaleListActivity7, C2723R.C2726id.auction_sales_nav_container);
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
        PreSaleListActivity preSaleListActivity8 = this.preSaleListActivity;
        if (preSaleListActivity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        Application application = preSaleListActivity8.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "preSaleListActivity.application");
        String userIdPreferencesMVVM = IAASharedPreference.getUserIdPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM, "IAASharedPreference.getU…ation.applicationContext)");
        this.userId = userIdPreferencesMVVM;
        if (this.isFristTime) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                Intrinsics.throwNpe();
            }
            this.totalCount = arguments.getInt(Constants.WATCHING_SIZE);
            this.totalCountWatchDashBoard = this.totalCount;
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                Intrinsics.throwNpe();
            }
            if (arguments2.containsKey("status")) {
                Bundle arguments3 = getArguments();
                if (arguments3 == null) {
                    Intrinsics.throwNpe();
                }
                this.myAccountStatus = String.valueOf(arguments3.getInt("status", 0));
            }
            Bundle arguments4 = getArguments();
            if (arguments4 == null) {
                Intrinsics.throwNpe();
            }
            if (arguments4.containsKey("isMyItemOnly")) {
                Bundle arguments5 = getArguments();
                if (arguments5 == null) {
                    Intrinsics.throwNpe();
                }
                this.isMyItemsOnly = arguments5.getBoolean("isMyItemOnly", false);
            }
            initializeRecycler();
            checkNetworkConnection();
        } else if (Intrinsics.areEqual((Object) this.myAccountStatus, (Object) String.valueOf(PreSaleListStatus.WATCHING_LIST.getValue()))) {
            initializeRecycler();
            checkNetworkConnection();
        }
        setToolBarTitle();
        if (Intrinsics.areEqual((Object) this.myAccountStatus, (Object) String.valueOf(PreSaleListStatus.PURCHASE_HISTORY.getValue()))) {
            handleStockSearch();
        } else {
            RelativeLayout relativeLayout3 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_stock_vin_search);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, "rl_stock_vin_search");
            relativeLayout3.setVisibility(8);
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.vw_separtor);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "vw_separtor");
            _$_findCachedViewById.setVisibility(8);
            View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.vw_separtor_toolbar);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "vw_separtor_toolbar");
            _$_findCachedViewById2.setVisibility(0);
        }
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivSearchClear)).setOnClickListener(new PreSaleListFragment$onActivityCreated$1(this));
        Regex regex = new Regex("[a-zA-Z0-9-' ]+", RegexOption.IGNORE_CASE);
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etVinSearch);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etVinSearch");
        editText.setFilters(new InputFilter[]{new PreSaleListFragment$onActivityCreated$2(regex)});
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etVinSearch)).addTextChangedListener(new PreSaleListFragment$onActivityCreated$3(this));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etVinSearch)).setOnEditorActionListener(new PreSaleListFragment$onActivityCreated$4(this));
    }

    private final void handleStockSearch() {
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_stock_vin_search);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "rl_stock_vin_search");
        relativeLayout.setVisibility(0);
        View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.vw_separtor);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "vw_separtor");
        _$_findCachedViewById.setVisibility(0);
        View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.vw_separtor_toolbar);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "vw_separtor_toolbar");
        _$_findCachedViewById2.setVisibility(8);
    }

    public final void setToolBarTitle() {
        String str = this.myAccountStatus;
        if (Intrinsics.areEqual((Object) str, (Object) String.valueOf(PreSaleListStatus.WATCHING_LIST.getValue()))) {
            PreSaleListActivity preSaleListActivity2 = this.preSaleListActivity;
            if (preSaleListActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
            }
            preSaleListActivity2.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_watching));
        } else if (Intrinsics.areEqual((Object) str, (Object) String.valueOf(PreSaleListStatus.AWARD_PENDING.getValue()))) {
            PreSaleListActivity preSaleListActivity3 = this.preSaleListActivity;
            if (preSaleListActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
            }
            preSaleListActivity3.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_award_pending));
        } else if (Intrinsics.areEqual((Object) str, (Object) String.valueOf(PreSaleListStatus.PRE_BID.getValue()))) {
            PreSaleListActivity preSaleListActivity4 = this.preSaleListActivity;
            if (preSaleListActivity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
            }
            preSaleListActivity4.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_title_pre_bid));
        } else if (Intrinsics.areEqual((Object) str, (Object) String.valueOf(PreSaleListStatus.LOST_PREBID.getValue()))) {
            PreSaleListActivity preSaleListActivity5 = this.preSaleListActivity;
            if (preSaleListActivity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
            }
            preSaleListActivity5.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_lost_Prebids));
        } else if (Intrinsics.areEqual((Object) str, (Object) String.valueOf(PreSaleListStatus.PURCHASE_HISTORY.getValue()))) {
            PreSaleListActivity preSaleListActivity6 = this.preSaleListActivity;
            if (preSaleListActivity6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
            }
            preSaleListActivity6.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_purchase_History));
        }
        setToolbarCount(this.totalCount);
    }

    public final void setToolbarCount(int i) {
        this.totalCount = i;
        PreSaleListActivity preSaleListActivity2 = this.preSaleListActivity;
        if (preSaleListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        preSaleListActivity2.getToolbar_sub_title().setVisibility(0);
        PreSaleListActivity preSaleListActivity3 = this.preSaleListActivity;
        if (preSaleListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        TextView toolbar_sub_title = preSaleListActivity3.getToolbar_sub_title();
        toolbar_sub_title.setText(i + " Results");
    }

    /* access modifiers changed from: private */
    public final void setDashBoardCountAtSharePreference(int i) {
        int parseInt = Integer.parseInt(this.myAccountStatus);
        if (parseInt == PreSaleListStatus.WATCHING_LIST.getValue()) {
            PreSaleListActivity preSaleListActivity2 = this.preSaleListActivity;
            if (preSaleListActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
            }
            IAASharedPreference.setDashBoardCount(preSaleListActivity2, Constants_MVVM.KEY_FOR_WATCHING_COUNT_MYACCOUNT, i);
        } else if (parseInt == PreSaleListStatus.PRE_BID.getValue()) {
            PreSaleListActivity preSaleListActivity3 = this.preSaleListActivity;
            if (preSaleListActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
            }
            IAASharedPreference.setDashBoardCount(preSaleListActivity3, Constants_MVVM.KEY_FOR_PREBID_COUNT_MYACCOUNT, i);
        } else if (parseInt == PreSaleListStatus.AWARD_PENDING.getValue()) {
            PreSaleListActivity preSaleListActivity4 = this.preSaleListActivity;
            if (preSaleListActivity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
            }
            IAASharedPreference.setDashBoardCount(preSaleListActivity4, Constants_MVVM.KEY_FOR_AWARD_PENDING_COUNT_MYACCOUNT, i);
        } else if (parseInt == PreSaleListStatus.LOST_PREBID.getValue()) {
            PreSaleListActivity preSaleListActivity5 = this.preSaleListActivity;
            if (preSaleListActivity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
            }
            IAASharedPreference.setDashBoardCount(preSaleListActivity5, Constants_MVVM.KEY_FOR_LOST_PREBID_COUNT_MYACCOUNT, i);
        } else if (parseInt == PreSaleListStatus.PURCHASE_HISTORY.getValue()) {
            PreSaleListActivity preSaleListActivity6 = this.preSaleListActivity;
            if (preSaleListActivity6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
            }
            IAASharedPreference.setDashBoardCount(preSaleListActivity6, Constants_MVVM.KEY_FOR_PURCHASE_HISTORY_COUNT_MYACCOUNT, i);
        }
    }

    /* access modifiers changed from: private */
    public final void fetchWatchList() {
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
        String str3 = this.myAccountStatus;
        boolean z = this.isMyItemsOnly;
        String str4 = this.sortBy;
        if (str4 != null) {
            str = str4;
        } else {
            str = "";
        }
        preSaleListViewModel.fetchWatchingList(format, str2, str3, 1, z, str, this.sortDirection, this.mKeywordSearch);
        showLoadingIndicator(true);
        subscribeToViewModel();
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            fetchWatchList();
            return;
        }
        this.errorType = BaseFragment.ErrorType.NO_INTERNET;
        this.isError = true;
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        StringBuilder sb = new StringBuilder();
        sb.append("dashboard.svc/myvehicles/userid/");
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        sb.append(sessionManager2.getCurrentSessionUserId());
        sb.append("/");
        iAAAnalytics.logNetworkEvent(sb.toString(), false, "", BaseFragment.ErrorType.NO_INTERNET.getValue());
        InternetUtil.INSTANCE.observe(this, new PreSaleListFragment$checkNetworkConnection$1(this));
    }

    /* access modifiers changed from: private */
    public final void initializeRecycler() {
        this.isFristTime = false;
        PreSaleListActivity preSaleListActivity2 = this.preSaleListActivity;
        if (preSaleListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(preSaleListActivity2, 1);
        PreSaleListActivity preSaleListActivity3 = this.preSaleListActivity;
        if (preSaleListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        Application application = preSaleListActivity3.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "preSaleListActivity.application");
        Drawable drawable = ContextCompat.getDrawable(application.getApplicationContext(), C2723R.C2725drawable.line_decoration);
        if (drawable == null) {
            Intrinsics.throwNpe();
        }
        dividerItemDecoration.setDrawable(drawable);
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvWatchList)).addItemDecoration(dividerItemDecoration);
        PreSaleListViewModel preSaleListViewModel = this.viewModel;
        if (preSaleListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        PreSaleListActivity preSaleListActivity4 = this.preSaleListActivity;
        if (preSaleListActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        this.preSaleAdapter = new PreSaleListAdapter(preSaleListViewModel, preSaleListActivity4, new PreSaleListFragment$initializeRecycler$1(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvWatchList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvWatchList");
        PreSaleListAdapter preSaleListAdapter = this.preSaleAdapter;
        if (preSaleListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleAdapter");
        }
        recyclerView.setAdapter(preSaleListAdapter);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvWatchList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvWatchList");
        PreSaleListActivity preSaleListActivity5 = this.preSaleListActivity;
        if (preSaleListActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(preSaleListActivity5));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvWatchList)).addOnScrollListener(new PreSaleListFragment$initializeRecycler$2(this));
        ((FloatingActionButton) _$_findCachedViewById(C2723R.C2726id.fab)).setOnClickListener(new PreSaleListFragment$initializeRecycler$3(this));
    }

    private final void subscribeToViewModel() {
        PreSaleListViewModel preSaleListViewModel = this.viewModel;
        if (preSaleListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        preSaleListViewModel.getWatchListError().observe(lifecycleOwner, new PreSaleListFragment$subscribeToViewModel$1(this));
        PreSaleListViewModel preSaleListViewModel2 = this.viewModel;
        if (preSaleListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        preSaleListViewModel2.getResultLiveData().observe(lifecycleOwner, new PreSaleListFragment$subscribeToViewModel$2(this));
        PreSaleListViewModel preSaleListViewModel3 = this.viewModel;
        if (preSaleListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        preSaleListViewModel3.getNetworkState().observe(lifecycleOwner, PreSaleListFragment$subscribeToViewModel$3.INSTANCE);
        PreSaleListViewModel preSaleListViewModel4 = this.viewModel;
        if (preSaleListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        preSaleListViewModel4.getScrollSearchListToTop().observe(lifecycleOwner, new PreSaleListFragment$subscribeToViewModel$4(this));
        PreSaleListViewModel preSaleListViewModel5 = this.viewModel;
        if (preSaleListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        preSaleListViewModel5.getPreSalesListResponse().observe(lifecycleOwner, new PreSaleListFragment$subscribeToViewModel$5(this));
        PreSaleListViewModel preSaleListViewModel6 = this.viewModel;
        if (preSaleListViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<UpdateWatchListResponse> watchStatusResponse = preSaleListViewModel6.getWatchStatusResponse();
        PreSaleListActivity preSaleListActivity2 = this.preSaleListActivity;
        if (preSaleListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        watchStatusResponse.observe(preSaleListActivity2, new PreSaleListFragment$subscribeToViewModel$6(this));
        PreSaleListViewModel preSaleListViewModel7 = this.viewModel;
        if (preSaleListViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> watchStatusError = preSaleListViewModel7.getWatchStatusError();
        PreSaleListActivity preSaleListActivity3 = this.preSaleListActivity;
        if (preSaleListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        watchStatusError.observe(preSaleListActivity3, new PreSaleListFragment$subscribeToViewModel$7(this));
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListFragment$Companion;", "", "()V", "newInstance", "Lcom/iaai/android/bdt/feature/account/watchlist/PreSaleListFragment;", "param1", "", "param2", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: PreSaleListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final PreSaleListFragment newInstance(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkParameterIsNotNull(str, "param1");
            Intrinsics.checkParameterIsNotNull(str2, "param2");
            PreSaleListFragment preSaleListFragment = new PreSaleListFragment();
            Bundle bundle = new Bundle();
            bundle.putString("param1", str);
            bundle.putString("param2", str2);
            preSaleListFragment.setArguments(bundle);
            return preSaleListFragment;
        }
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
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0056, code lost:
        r0 = com.iaai.android.old.utils.IAASharedPreference.getLaneFilterPreferencesMVVM(getActivity());
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, "IAASharedPreference.getL…PreferencesMVVM(activity)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x006b, code lost:
        if (r0.length() <= 0) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0070, code lost:
        r0 = com.iaai.android.old.utils.IAASharedPreference.getLossLypeFilterPreferencesMVVM(getActivity());
        kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, "IAASharedPreference.getL…PreferencesMVVM(activity)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0083, code lost:
        if (r0.length() <= 0) goto L_0x0086;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void addHeaderToAuctionSalesList(java.lang.String r6) {
        /*
            r5 = this;
            android.content.Intent r0 = r5.intent
            if (r0 == 0) goto L_0x0087
            if (r0 != 0) goto L_0x0009
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0009:
            java.lang.String r1 = "isFilterApplied"
            boolean r0 = r0.hasExtra(r1)
            r2 = 0
            if (r0 == 0) goto L_0x001f
            android.content.Intent r0 = r5.intent
            if (r0 != 0) goto L_0x0019
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0019:
            boolean r0 = r0.getBooleanExtra(r1, r2)
            if (r0 != 0) goto L_0x003b
        L_0x001f:
            android.content.Intent r0 = r5.intent
            if (r0 != 0) goto L_0x0026
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0026:
            java.lang.String r1 = "isSortApplied"
            boolean r0 = r0.hasExtra(r1)
            if (r0 == 0) goto L_0x0087
            android.content.Intent r0 = r5.intent
            if (r0 != 0) goto L_0x0035
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0035:
            boolean r0 = r0.getBooleanExtra(r1, r2)
            if (r0 == 0) goto L_0x0087
        L_0x003b:
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r0 = com.iaai.android.old.utils.IAASharedPreference.getYearFilterPreferencesMVVM(r0)
            java.lang.String r1 = "IAASharedPreference.getY…PreferencesMVVM(activity)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            r1 = 1
            if (r0 <= 0) goto L_0x0055
            r0 = 1
            goto L_0x0056
        L_0x0055:
            r0 = 0
        L_0x0056:
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r0 = com.iaai.android.old.utils.IAASharedPreference.getLaneFilterPreferencesMVVM(r0)
            java.lang.String r3 = "IAASharedPreference.getL…PreferencesMVVM(activity)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x006f
            r0 = 1
            goto L_0x0070
        L_0x006f:
            r0 = 0
        L_0x0070:
            androidx.fragment.app.FragmentActivity r0 = r5.getActivity()
            android.content.Context r0 = (android.content.Context) r0
            java.lang.String r0 = com.iaai.android.old.utils.IAASharedPreference.getLossLypeFilterPreferencesMVVM(r0)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 <= 0) goto L_0x0086
            goto L_0x0087
        L_0x0086:
            r1 = 0
        L_0x0087:
            com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader r0 = new com.iaai.android.bdt.model.auctionSalesList.AuctionSalesListHeader
            r0.<init>()
            boolean r1 = r5.isError
            r0.setError(r1)
            boolean r1 = r5.isError
            if (r1 == 0) goto L_0x0104
            com.iaai.android.bdt.base.BaseFragment$ErrorType r1 = r5.errorType
            java.lang.String r2 = "errorType"
            if (r1 != 0) goto L_0x009e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x009e:
            int[] r3 = com.iaai.android.bdt.feature.account.watchlist.PreSaleListFragment.WhenMappings.$EnumSwitchMapping$0
            int r1 = r1.ordinal()
            r1 = r3[r1]
            java.lang.String r3 = "getString(R.string.bdt_a…on_error_type_no_auction)"
            r4 = 2131820628(0x7f110054, float:1.9273976E38)
            switch(r1) {
                case 1: goto L_0x00eb;
                case 2: goto L_0x00de;
                case 3: goto L_0x00d1;
                case 4: goto L_0x00c9;
                case 5: goto L_0x00c1;
                case 6: goto L_0x00b4;
                case 7: goto L_0x00f7;
                default: goto L_0x00ae;
            }
        L_0x00ae:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x00b4:
            r6 = 2131820640(0x7f110060, float:1.9274E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.bdt_l…_error_msg_no_item_found)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
            goto L_0x00f7
        L_0x00c1:
            java.lang.String r6 = r5.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r3)
            goto L_0x00f7
        L_0x00c9:
            java.lang.String r6 = r5.getString(r4)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r3)
            goto L_0x00f7
        L_0x00d1:
            r6 = 2131820629(0x7f110055, float:1.9273978E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.bdt_a…tion_error_type_no_stock)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
            goto L_0x00f7
        L_0x00de:
            r6 = 2131820656(0x7f110070, float:1.9274033E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.bdt_lbl_msg_prd_network_error)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
            goto L_0x00f7
        L_0x00eb:
            r6 = 2131821566(0x7f1103fe, float:1.9275879E38)
            java.lang.String r6 = r5.getString(r6)
            java.lang.String r1 = "getString(R.string.lbl_msg_no_internet_connection)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r1)
        L_0x00f7:
            r0.setErrorMessage(r6)
            com.iaai.android.bdt.base.BaseFragment$ErrorType r6 = r5.errorType
            if (r6 != 0) goto L_0x0101
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x0101:
            r0.setErrorType(r6)
        L_0x0104:
            com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter r6 = r5.preSaleAdapter
            java.lang.String r1 = "preSaleAdapter"
            if (r6 != 0) goto L_0x010d
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x010d:
            java.lang.String r2 = r5.myAccountStatus
            r6.setHeaderItem(r0, r2)
            com.iaai.android.bdt.feature.account.watchlist.PreSaleListAdapter r6 = r5.preSaleAdapter
            if (r6 != 0) goto L_0x0119
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0119:
            r6.notifyDataSetChanged()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.watchlist.PreSaleListFragment.addHeaderToAuctionSalesList(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        r3 = r3.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r3, int r4, @org.jetbrains.annotations.Nullable android.content.Intent r5) {
        /*
            r2 = this;
            r0 = -1
            if (r4 != r0) goto L_0x000d
            r0 = 26
            if (r3 == r0) goto L_0x0008
            goto L_0x000d
        L_0x0008:
            long r0 = r2.itemIdWatch
            r2.addToWatchList(r0)
        L_0x000d:
            r3 = 1
            if (r4 == r3) goto L_0x0013
            r3 = 2
            if (r4 != r3) goto L_0x009c
        L_0x0013:
            if (r5 == 0) goto L_0x009c
            r2.intent = r5
            java.lang.String r3 = r2.myAccountStatus
            int r3 = java.lang.Integer.parseInt(r3)
            com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus r4 = com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus.PURCHASE_HISTORY
            int r4 = r4.getValue()
            r5 = 0
            java.lang.String r0 = "search_selected_sort_position"
            r1 = 0
            if (r3 != r4) goto L_0x0049
            android.content.Intent r3 = r2.intent
            if (r3 == 0) goto L_0x003c
            android.os.Bundle r3 = r3.getExtras()
            if (r3 == 0) goto L_0x003c
            int r3 = r3.getInt(r0, r5)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x003d
        L_0x003c:
            r3 = r1
        L_0x003d:
            if (r3 != 0) goto L_0x0042
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0042:
            int r3 = r3.intValue()
            r2.lastSelectedPurchaseSort = r3
            goto L_0x0068
        L_0x0049:
            android.content.Intent r3 = r2.intent
            if (r3 == 0) goto L_0x005c
            android.os.Bundle r3 = r3.getExtras()
            if (r3 == 0) goto L_0x005c
            int r3 = r3.getInt(r0, r5)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            goto L_0x005d
        L_0x005c:
            r3 = r1
        L_0x005d:
            if (r3 != 0) goto L_0x0062
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x0062:
            int r3 = r3.intValue()
            r2.lastSelectedSort = r3
        L_0x0068:
            android.content.Intent r3 = r2.intent
            if (r3 == 0) goto L_0x0079
            android.os.Bundle r3 = r3.getExtras()
            if (r3 == 0) goto L_0x0079
            java.lang.String r4 = "sortDirection"
            java.lang.String r3 = r3.getString(r4)
            goto L_0x007a
        L_0x0079:
            r3 = r1
        L_0x007a:
            if (r3 != 0) goto L_0x007f
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x007f:
            int r3 = java.lang.Integer.parseInt(r3)
            r2.sortDirection = r3
            android.content.Intent r3 = r2.intent
            if (r3 == 0) goto L_0x0097
            android.os.Bundle r3 = r3.getExtras()
            if (r3 == 0) goto L_0x0097
            java.lang.String r4 = "sortBy"
            java.lang.String r5 = ""
            java.lang.String r1 = r3.getString(r4, r5)
        L_0x0097:
            r2.sortBy = r1
            r2.fetchWatchList()
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.watchlist.PreSaleListFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: private */
    public final SortOptionData createSortOptionData(String str, int i, boolean z) {
        switch (i) {
            case 0:
                return new SortOptionData(str, "Auction Date", "0", z);
            case 1:
                return new SortOptionData(str, "Auction Date", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 2:
                return new SortOptionData(str, ExifInterface.TAG_MAKE, "0", z);
            case 3:
                return new SortOptionData(str, ExifInterface.TAG_MAKE, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 4:
                return new SortOptionData(str, "Odometer", "0", z);
            case 5:
                return new SortOptionData(str, "Odometer", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 6:
                return new SortOptionData(str, "Year", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 7:
                return new SortOptionData(str, "Year", "0", z);
            default:
                return new SortOptionData(str, "Year", "0", z);
        }
    }

    /* access modifiers changed from: private */
    public final SortOptionData createSortOptionLostPreBidData(String str, int i, boolean z) {
        switch (i) {
            case 0:
                return new SortOptionData(str, "BidAmount", "0", z);
            case 1:
                return new SortOptionData(str, "BidAmount", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 2:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BIDDER, "0", z);
            case 3:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BIDDER, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 4:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BRANCH, "0", z);
            case 5:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BRANCH, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 6:
                return new SortOptionData(str, ExifInterface.TAG_MAKE, "0", z);
            case 7:
                return new SortOptionData(str, ExifInterface.TAG_MAKE, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 8:
                return new SortOptionData(str, "Year", "0", z);
            case 9:
                return new SortOptionData(str, "Year", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            default:
                return new SortOptionData(str, "Year", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
        }
    }

    /* access modifiers changed from: private */
    public final SortOptionData createSortOptionPurchaseHistoryData(String str, int i, boolean z) {
        switch (i) {
            case 0:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BRANCH, "0", z);
            case 1:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BRANCH, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 2:
                return new SortOptionData(str, "DatePaid", "0", z);
            case 3:
                return new SortOptionData(str, "DatePaid", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 4:
                return new SortOptionData(str, ExifInterface.TAG_MAKE, "0", z);
            case 5:
                return new SortOptionData(str, ExifInterface.TAG_MAKE, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 6:
                return new SortOptionData(str, "Year", "0", z);
            case 7:
                return new SortOptionData(str, "Year", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            default:
                return new SortOptionData(str, "Year", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
        }
    }

    /* access modifiers changed from: private */
    public final SortOptionData createSortOptionAwardData(String str, int i, boolean z) {
        switch (i) {
            case 0:
                return new SortOptionData(str, "BidAmount", "0", z);
            case 1:
                return new SortOptionData(str, "BidAmount", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 2:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BIDDER, "0", z);
            case 3:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BIDDER, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 4:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BRANCH, "0", z);
            case 5:
                return new SortOptionData(str, Constants.TO_BE_PAID_SRT_BRANCH, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 6:
                return new SortOptionData(str, "AuctionItem", "0", z);
            case 7:
                return new SortOptionData(str, "AuctionItem", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
            case 8:
                return new SortOptionData(str, "Description", "0", z);
            default:
                return new SortOptionData(str, "Description", IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, z);
        }
    }

    /* access modifiers changed from: private */
    public final void addToWatchList(long j) {
        PreSaleListActivity preSaleListActivity2 = this.preSaleListActivity;
        if (preSaleListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        Application application = preSaleListActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "preSaleListActivity.application");
        String userIdPreferencesMVVM = IAASharedPreference.getUserIdPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM, "IAASharedPreference.getU…ation.applicationContext)");
        this.userId = userIdPreferencesMVVM;
        String string = getResources().getString(C2723R.string.lbl_watch_action_add);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.string.lbl_watch_action_add)");
        this.action = string;
        PreSaleListViewModel preSaleListViewModel = this.viewModel;
        if (preSaleListViewModel == null) {
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
        preSaleListViewModel.updateWatchStatus(format, String.valueOf(j), this.userId, this.action);
    }

    /* access modifiers changed from: private */
    public final void removeFromWatchList(long j) {
        String string = getResources().getString(C2723R.string.lbl_watch_action_delete);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st….lbl_watch_action_delete)");
        this.action = string;
        PreSaleListViewModel preSaleListViewModel = this.viewModel;
        if (preSaleListViewModel == null) {
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
        preSaleListViewModel.updateWatchStatus(format, String.valueOf(j), this.userId, this.action);
    }

    public void onDestroy() {
        super.onDestroy();
        PreSaleListViewModel preSaleListViewModel = this.viewModel;
        if (preSaleListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        preSaleListViewModel.disposeElements();
    }

    /* access modifiers changed from: private */
    public final void checkWriteStoragePermission(String str, boolean z, String str2, String str3) {
        PreSaleListActivity preSaleListActivity2 = this.preSaleListActivity;
        if (preSaleListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        if (ContextCompat.checkSelfPermission(preSaleListActivity2, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            PreSaleListActivity preSaleListActivity3 = this.preSaleListActivity;
            if (preSaleListActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
            }
            ActivityCompat.requestPermissions(preSaleListActivity3, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 3);
            return;
        }
        navigateToReceiptPage(str, z, str2, str3);
    }

    private final void navigateToReceiptPage(String str, boolean z, String str2, String str3) {
        PreSaleListActivity preSaleListActivity2 = this.preSaleListActivity;
        if (preSaleListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        Intent intent2 = new Intent(preSaleListActivity2, ReceiptDPFActivity.class);
        String str4 = z ? PayPalRequest.INTENT_ORDER : "stock";
        String string = getString(C2723R.string.service_path_get_vehicle__new_receipt, str, str4, str3);
        Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.servi…, receipttype, salvageID)");
        intent2.putExtra("receipt_url", string);
        intent2.putExtra("receipt_email_subject_line", str2);
        intent2.putExtra("pdf_receipt", true);
        intent2.putExtra("report_title", str);
        intent2.putExtra("asap_salvage_id", str3);
        intent2.putExtra(Constants_MVVM.IS_RECEIPT, z);
        intent2.putExtra("receipt_type", str4);
        startActivity(intent2);
    }

    public final void hideSoftKeyboard() {
        PreSaleListActivity preSaleListActivity2 = this.preSaleListActivity;
        if (preSaleListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        if (preSaleListActivity2.getCurrentFocus() != null) {
            PreSaleListActivity preSaleListActivity3 = this.preSaleListActivity;
            if (preSaleListActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
            }
            Object systemService = preSaleListActivity3.getSystemService("input_method");
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                PreSaleListActivity preSaleListActivity4 = this.preSaleListActivity;
                if (preSaleListActivity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
                }
                View currentFocus = preSaleListActivity4.getCurrentFocus();
                Intrinsics.checkExpressionValueIsNotNull(currentFocus, "preSaleListActivity.currentFocus");
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    /* access modifiers changed from: private */
    public final void showSoftKeyboard() {
        PreSaleListActivity preSaleListActivity2 = this.preSaleListActivity;
        if (preSaleListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
        }
        if (preSaleListActivity2.getCurrentFocus() != null) {
            PreSaleListActivity preSaleListActivity3 = this.preSaleListActivity;
            if (preSaleListActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
            }
            Object systemService = preSaleListActivity3.getSystemService("input_method");
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                PreSaleListActivity preSaleListActivity4 = this.preSaleListActivity;
                if (preSaleListActivity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preSaleListActivity");
                }
                inputMethodManager.showSoftInput(preSaleListActivity4.getCurrentFocus(), 1);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }
}
