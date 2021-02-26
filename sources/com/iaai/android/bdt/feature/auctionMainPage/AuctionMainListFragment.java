package com.iaai.android.bdt.feature.auctionMainPage;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.inject.Injector;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.database.RecentViewContract;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.auctionmainlist.AuctionCalendarInfo;
import com.iaai.android.bdt.model.auctionmainlist.AuctionCalender;
import com.iaai.android.bdt.model.auctionmainlist.AuctionLocations;
import com.iaai.android.bdt.model.auctionmainlist.AuctionMainListResponse;
import com.iaai.android.bdt.model.auctionmainlist.RecentlyViewedInfo;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.managers.BidManager;
import com.iaai.android.old.managers.CurrentLocationManager;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020,H\u0002J\b\u0010.\u001a\u00020,H\u0002J(\u0010/\u001a\u00020,2\u0006\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u00162\u0006\u00103\u001a\u00020\u0016H\u0002J\u0010\u00104\u001a\u00020,2\u0006\u00101\u001a\u00020\u0016H\u0002J\u0010\u00105\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\u0012\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u00109\u001a\u00020\u0016H\u0002J\u0018\u0010:\u001a\u00020\u00162\u0006\u0010;\u001a\u00020\u00162\u0006\u0010<\u001a\u00020\u0016H\u0002J\u0012\u0010=\u001a\u0002072\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\u0012\u0010@\u001a\u0002072\b\u0010>\u001a\u0004\u0018\u00010?H\u0002J\b\u0010A\u001a\u00020,H\u0002J\b\u0010B\u001a\u00020,H\u0002J\b\u0010C\u001a\u00020,H\u0002J\u0018\u0010D\u001a\u00020,2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\b\u0010E\u001a\u00020,H\u0002J\b\u0010F\u001a\u00020,H\u0002J\u0012\u0010G\u001a\u00020,2\b\u0010!\u001a\u0004\u0018\u00010\u0005H\u0002J\u0012\u0010H\u001a\u00020,2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\"\u0010K\u001a\u00020,2\u0006\u0010L\u001a\u0002072\u0006\u0010M\u001a\u0002072\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\u0010\u0010P\u001a\u00020,2\u0006\u0010Q\u001a\u00020RH\u0016J\u0012\u0010S\u001a\u00020,2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J&\u0010T\u001a\u0004\u0018\u00010U2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010Y2\b\u0010I\u001a\u0004\u0018\u00010JH\u0016J\b\u0010Z\u001a\u00020,H\u0016J\b\u0010[\u001a\u00020,H\u0002J\u0018\u0010\\\u001a\u00020,2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0002J\u0010\u0010]\u001a\u00020,2\u0006\u0010^\u001a\u00020\u001aH\u0002J\u0010\u0010_\u001a\u00020,2\u0006\u0010`\u001a\u00020\u001aH\u0002J\b\u0010a\u001a\u00020,H\u0002J\u0018\u0010b\u001a\u00020\u00162\u0006\u0010c\u001a\u00020\u00162\u0006\u0010d\u001a\u00020\u0016H\u0002J\b\u0010e\u001a\u00020,H\u0002J\u001a\u0010f\u001a\u00020,2\u0006\u0010Q\u001a\u00020R2\b\u00108\u001a\u0004\u0018\u00010\u0016H\u0002R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u00020$8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020*X.¢\u0006\u0002\n\u0000¨\u0006g"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionMainListFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "auctionList", "", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionLocations;", "auctionLocations", "auctionMainListActivity", "Lcom/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListActivity;", "auctionMainListAdapter", "Lcom/iaai/android/bdt/feature/auctionMainPage/BDTAuctionMainListAdapter;", "auctionMainListResponse", "Lcom/iaai/android/bdt/model/auctionmainlist/AuctionMainListResponse;", "getAuctionMainListResponse", "()Lcom/iaai/android/bdt/model/auctionmainlist/AuctionMainListResponse;", "setAuctionMainListResponse", "(Lcom/iaai/android/bdt/model/auctionmainlist/AuctionMainListResponse;)V", "bidManager", "Lcom/iaai/android/old/managers/BidManager;", "currentLocationManager", "Lcom/iaai/android/old/managers/CurrentLocationManager;", "currentSelectedAuctionDate", "", "filteredList", "Ljava/util/ArrayList;", "isCalederDateSelect", "", "isFromSearchKeyword", "mBinding", "Landroidx/databinding/ViewDataBinding;", "recentList", "searchDate", "searchInputKey", "selectedAuction", "selectedDate", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "viewModel", "Lcom/iaai/android/bdt/feature/auctionMainPage/AuctionMainListViewModel;", "checkNetworkConnection", "", "clearFilter", "deleteAuctionSuggestionDBWithPriorityZero", "fetchAuctionMainList", "query", "nextAuction", "lat", "long", "fetchAuctionMainListFirstTime", "getAuctionDataList", "getLocationBranchidIndex", "", "branchID", "getNetPublicAuctionDate", "getServerFormatDate", "dateString", "pattern", "getSuggestionsFrequencyFromCursor", "cursor", "Landroid/database/Cursor;", "getSuggestionsPriorityFromCursor", "handleKeywordSearch", "handleSearchKeyword", "hideSoftKeyboard", "initialisePriorityInSuggestionDB", "initializeCalendarView", "initializeRecycler", "launchIBidLive", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "openAuctionCalender", "resetAuctionSuggestionDB", "showEmptyState", "isShowEmptyState", "showLoadingIndicator", "loading", "subscribeToViewModel", "updateAuctionDateLabel", "label", "auction", "updateAuctionSegments", "updateSuggestions", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AuctionMainListFragment.kt */
public final class AuctionMainListFragment extends BaseFragment {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public List<AuctionLocations> auctionList = CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    public List<AuctionLocations> auctionLocations = CollectionsKt.emptyList();
    /* access modifiers changed from: private */
    public BDTAuctionMainListActivity auctionMainListActivity;
    /* access modifiers changed from: private */
    public BDTAuctionMainListAdapter auctionMainListAdapter;
    @Nullable
    private AuctionMainListResponse auctionMainListResponse;
    private BidManager bidManager;
    private CurrentLocationManager currentLocationManager;
    /* access modifiers changed from: private */
    public String currentSelectedAuctionDate = "";
    private ArrayList<AuctionLocations> filteredList;
    /* access modifiers changed from: private */
    public boolean isCalederDateSelect;
    /* access modifiers changed from: private */
    public boolean isFromSearchKeyword;
    /* access modifiers changed from: private */
    public ViewDataBinding mBinding;
    private ArrayList<AuctionLocations> recentList;
    /* access modifiers changed from: private */
    public String searchDate = "";
    private String searchInputKey = "";
    /* access modifiers changed from: private */
    public AuctionLocations selectedAuction;
    private String selectedDate = "";
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private AuctionMainListViewModel viewModel;

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

    public static final /* synthetic */ BDTAuctionMainListActivity access$getAuctionMainListActivity$p(AuctionMainListFragment auctionMainListFragment) {
        BDTAuctionMainListActivity bDTAuctionMainListActivity = auctionMainListFragment.auctionMainListActivity;
        if (bDTAuctionMainListActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
        }
        return bDTAuctionMainListActivity;
    }

    public static final /* synthetic */ BDTAuctionMainListAdapter access$getAuctionMainListAdapter$p(AuctionMainListFragment auctionMainListFragment) {
        BDTAuctionMainListAdapter bDTAuctionMainListAdapter = auctionMainListFragment.auctionMainListAdapter;
        if (bDTAuctionMainListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionMainListAdapter");
        }
        return bDTAuctionMainListAdapter;
    }

    public static final /* synthetic */ ViewDataBinding access$getMBinding$p(AuctionMainListFragment auctionMainListFragment) {
        ViewDataBinding viewDataBinding = auctionMainListFragment.mBinding;
        if (viewDataBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        return viewDataBinding;
    }

    @Nullable
    public final AuctionMainListResponse getAuctionMainListResponse() {
        return this.auctionMainListResponse;
    }

    public final void setAuctionMainListResponse(@Nullable AuctionMainListResponse auctionMainListResponse2) {
        this.auctionMainListResponse = auctionMainListResponse2;
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
            this.auctionMainListActivity = (BDTAuctionMainListActivity) activity;
            if (context instanceof AuctionSalesListActivity) {
                this.auctionMainListActivity = (BDTAuctionMainListActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        BDTAuctionMainListActivity bDTAuctionMainListActivity = this.auctionMainListActivity;
        if (bDTAuctionMainListActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
        }
        FragmentActivity fragmentActivity = bDTAuctionMainListActivity;
        BDTAuctionMainListActivity bDTAuctionMainListActivity2 = this.auctionMainListActivity;
        if (bDTAuctionMainListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, bDTAuctionMainListActivity2.getViewModelFactory()).get(AuctionMainListViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(au…istViewModel::class.java)");
        this.viewModel = (AuctionMainListViewModel) viewModel2;
        FragmentActivity activity = getActivity();
        Application application = activity != null ? activity.getApplication() : null;
        if (application != null) {
            Injector injector = ((IaaiApplication) application).getInjector();
            Object instance = injector.getInstance(BidManager.class);
            Intrinsics.checkExpressionValueIsNotNull(instance, "injector.getInstance(BidManager::class.java)");
            this.bidManager = (BidManager) instance;
            Object instance2 = injector.getInstance(CurrentLocationManager.class);
            Intrinsics.checkExpressionValueIsNotNull(instance2, "injector.getInstance(Cur…ationManager::class.java)");
            this.currentLocationManager = (CurrentLocationManager) instance2;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.IaaiApplication");
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_bdt_auction_main_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(inflate, "DataBindingUtil.inflate<…        container, false)");
        this.mBinding = inflate;
        ViewDataBinding viewDataBinding = this.mBinding;
        if (viewDataBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBinding");
        }
        return viewDataBinding.getRoot();
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            if (arguments == null) {
                Intrinsics.throwNpe();
            }
            this.searchInputKey = arguments.getString(Constants_MVVM.EXTRA_SEARCH_INPUT_KEY, "").toString();
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                Intrinsics.throwNpe();
            }
            String string = arguments2.getString(Constants_MVVM.EXTRA_QUICK_FILTER_SELECTED_DATE, "");
            Intrinsics.checkExpressionValueIsNotNull(string, "arguments!!.getString(Co…_FILTER_SELECTED_DATE,\"\")");
            this.searchDate = string;
        }
        initializeCalendarView();
        initializeRecycler();
        subscribeToViewModel();
        openAuctionCalender();
        handleKeywordSearch();
        ((CheckBox) _$_findCachedViewById(C2723R.C2726id.cvPublicAuction)).setOnCheckedChangeListener(new AuctionMainListFragment$onActivityCreated$1(this));
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvLearnMore);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvLearnMore");
        textView.setPaintFlags(8);
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvLearnMore)).setOnClickListener(new AuctionMainListFragment$onActivityCreated$2(this));
    }

    /* access modifiers changed from: private */
    public final String getNetPublicAuctionDate() {
        AuctionCalender auctionCalender;
        List<AuctionCalendarInfo> auctionCalendarInfo;
        AuctionMainListResponse auctionMainListResponse2 = this.auctionMainListResponse;
        if (auctionMainListResponse2 == null || (auctionCalender = auctionMainListResponse2.getAuctionCalender()) == null || (auctionCalendarInfo = auctionCalender.getAuctionCalendarInfo()) == null) {
            return "";
        }
        Iterator it = auctionCalendarInfo.iterator();
        while (true) {
            String str = "";
            while (true) {
                if (!it.hasNext()) {
                    return str;
                }
                AuctionCalendarInfo auctionCalendarInfo2 = (AuctionCalendarInfo) it.next();
                if (!Intrinsics.areEqual((Object) auctionCalendarInfo2.getHasPublicAuction(), (Object) true) || (str = auctionCalendarInfo2.getAuctionDate()) != null) {
                }
            }
        }
    }

    private final void openAuctionCalender() {
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llAuctionMainDate)).setOnClickListener(new AuctionMainListFragment$openAuctionCalender$1(this));
    }

    /* access modifiers changed from: private */
    public final String updateAuctionDateLabel(String str, String str2) {
        CharSequence charSequence = str2;
        if (StringsKt.indexOf$default(charSequence, ',', 0, false, 6, (Object) null) == -1) {
            return str2;
        }
        int indexOf$default = StringsKt.indexOf$default(charSequence, ',', 0, false, 6, (Object) null);
        int length = str2.length();
        if (str2 != null) {
            String substring = str2.substring(indexOf$default, length);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return str + substring;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    private final void handleKeywordSearch() {
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etSearch)).setOnClickListener(new AuctionMainListFragment$handleKeywordSearch$1(this));
    }

    private final void hideSoftKeyboard() {
        BDTAuctionMainListActivity bDTAuctionMainListActivity = this.auctionMainListActivity;
        if (bDTAuctionMainListActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
        }
        if (bDTAuctionMainListActivity.getCurrentFocus() != null) {
            BDTAuctionMainListActivity bDTAuctionMainListActivity2 = this.auctionMainListActivity;
            if (bDTAuctionMainListActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
            }
            Object systemService = bDTAuctionMainListActivity2.getSystemService("input_method");
            if (systemService != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) systemService;
                BDTAuctionMainListActivity bDTAuctionMainListActivity3 = this.auctionMainListActivity;
                if (bDTAuctionMainListActivity3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
                }
                View currentFocus = bDTAuctionMainListActivity3.getCurrentFocus();
                Intrinsics.checkExpressionValueIsNotNull(currentFocus, "auctionMainListActivity.currentFocus");
                inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    private final void checkNetworkConnection() {
        boolean z = false;
        if (InternetUtil.INSTANCE.isInternetOn()) {
            CharSequence charSequence = this.searchInputKey;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                z = true;
            }
            if (!z) {
                handleSearchKeyword();
                subscribeToViewModel();
                return;
            }
            fetchAuctionMainListFirstTime(this.searchDate);
            return;
        }
        showEmptyState(true);
        displayError(BaseFragment.ErrorType.NO_INTERNET, "");
        IAAAnalytics.INSTANCE.logNetworkEvent("AuctionSaleListV2.svc/auctionlocations", false, "", BaseActivity.ErrorType.NO_INTERNET.getValue());
        InternetUtil.INSTANCE.observe(this, new AuctionMainListFragment$checkNetworkConnection$1(this));
    }

    private final void handleSearchKeyword() {
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etSearch)).setText(this.searchInputKey);
        String str = this.searchInputKey;
        if (str == null) {
            str = "";
        }
        fetchAuctionMainList(str, "", "", "");
    }

    /* access modifiers changed from: private */
    public final void fetchAuctionMainList(String str, String str2, String str3, String str4) {
        AuctionMainListViewModel auctionMainListViewModel = this.viewModel;
        if (auctionMainListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionMainListViewModel.getAuctionMainList(str, str2, str3, str4);
    }

    /* access modifiers changed from: private */
    public final void fetchAuctionMainListFirstTime(String str) {
        AuctionMainListViewModel auctionMainListViewModel = this.viewModel;
        if (auctionMainListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionMainListViewModel.getAuctionMainList("", str, "", "");
    }

    private final void subscribeToViewModel() {
        AuctionMainListViewModel auctionMainListViewModel = this.viewModel;
        if (auctionMainListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        auctionMainListViewModel.getAuctionMainListResult().observe(lifecycleOwner, new AuctionMainListFragment$subscribeToViewModel$1(this));
        AuctionMainListViewModel auctionMainListViewModel2 = this.viewModel;
        if (auctionMainListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionMainListViewModel2.getAuctionMainListError().observe(lifecycleOwner, new AuctionMainListFragment$subscribeToViewModel$2(this));
        AuctionMainListViewModel auctionMainListViewModel3 = this.viewModel;
        if (auctionMainListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionMainListViewModel3.getShowLoading().observe(lifecycleOwner, new AuctionMainListFragment$subscribeToViewModel$3(this));
        AuctionMainListViewModel auctionMainListViewModel4 = this.viewModel;
        if (auctionMainListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionMainListViewModel4.getShowEmptyState().observe(lifecycleOwner, new AuctionMainListFragment$subscribeToViewModel$4(this));
        AuctionMainListViewModel auctionMainListViewModel5 = this.viewModel;
        if (auctionMainListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionMainListViewModel5.getAuctionNowIndicatorError().observe(lifecycleOwner, new AuctionMainListFragment$subscribeToViewModel$5(this));
    }

    private final void initializeRecycler() {
        BDTAuctionMainListActivity bDTAuctionMainListActivity = this.auctionMainListActivity;
        if (bDTAuctionMainListActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
        }
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionList)).addItemDecoration(new DividerItemDecoration(bDTAuctionMainListActivity, 1));
        BDTAuctionMainListActivity bDTAuctionMainListActivity2 = this.auctionMainListActivity;
        if (bDTAuctionMainListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
        }
        Context context = bDTAuctionMainListActivity2;
        AuctionMainListViewModel auctionMainListViewModel = this.viewModel;
        if (auctionMainListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        this.auctionMainListAdapter = new BDTAuctionMainListAdapter(context, auctionMainListViewModel, new AuctionMainListFragment$initializeRecycler$1(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvAuctionList");
        BDTAuctionMainListAdapter bDTAuctionMainListAdapter = this.auctionMainListAdapter;
        if (bDTAuctionMainListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionMainListAdapter");
        }
        recyclerView.setAdapter(bDTAuctionMainListAdapter);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvAuctionList");
        BDTAuctionMainListActivity bDTAuctionMainListActivity3 = this.auctionMainListActivity;
        if (bDTAuctionMainListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(bDTAuctionMainListActivity3));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionList)).addOnScrollListener(new AuctionMainListFragment$initializeRecycler$2(this));
        ((FloatingActionButton) _$_findCachedViewById(C2723R.C2726id.faAuctionMainUpScroll)).setOnClickListener(new AuctionMainListFragment$initializeRecycler$3(this));
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbAuctionMain);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbAuctionMain");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbAuctionMain);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbAuctionMain");
        progressBar2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void showEmptyState(boolean z) {
        if (z) {
            RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionList);
            Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvAuctionList");
            recyclerView.setVisibility(8);
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "emptyRecyclerView");
            linearLayout.setVisibility(0);
            displayError(BaseFragment.ErrorType.NO_AUCTION, "");
            return;
        }
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvAuctionList");
        recyclerView2.setVisibility(0);
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "emptyRecyclerView");
        linearLayout2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void launchIBidLive(AuctionLocations auctionLocations2) {
        NewDateHelper newDateHelper = NewDateHelper.INSTANCE;
        NewDateHelper newDateHelper2 = NewDateHelper.INSTANCE;
        String str = null;
        String liveDate = auctionLocations2 != null ? auctionLocations2.getLiveDate() : null;
        if (liveDate == null) {
            Intrinsics.throwNpe();
        }
        String format = newDateHelper.format(newDateHelper2.getDateFromString(liveDate), Constants.DATE_PATTERN_WEBSERVICE_PARAM);
        BidManager bidManager2 = this.bidManager;
        if (bidManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bidManager");
        }
        BDTAuctionMainListActivity bDTAuctionMainListActivity = this.auctionMainListActivity;
        if (bDTAuctionMainListActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
        }
        Activity activity = bDTAuctionMainListActivity;
        if (auctionLocations2 != null) {
            str = auctionLocations2.getBranchid();
        }
        bidManager2.launchIBidLiveFromProductDetail(activity, str, format, false, false);
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r3, int r4, @org.jetbrains.annotations.Nullable android.content.Intent r5) {
        /*
            r2 = this;
            r0 = -1
            if (r4 != r0) goto L_0x000e
            r4 = 29
            if (r3 != r4) goto L_0x00a1
            com.iaai.android.bdt.model.auctionmainlist.AuctionLocations r3 = r2.selectedAuction
            r2.launchIBidLive(r3)
            goto L_0x00a1
        L_0x000e:
            r3 = 3
            r0 = 1
            r1 = 0
            if (r4 != r3) goto L_0x008a
            r3 = 0
            if (r5 == 0) goto L_0x0021
            java.lang.String r4 = "auction_date_pos"
            int r4 = r5.getIntExtra(r4, r3)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x0022
        L_0x0021:
            r4 = r1
        L_0x0022:
            com.iaai.android.bdt.model.auctionmainlist.AuctionMainListResponse r5 = r2.auctionMainListResponse
            if (r5 == 0) goto L_0x002a
            com.iaai.android.bdt.model.auctionmainlist.AuctionCalender r1 = r5.getAuctionCalender()
        L_0x002a:
            if (r1 != 0) goto L_0x002f
            kotlin.jvm.internal.Intrinsics.throwNpe()
        L_0x002f:
            java.util.List r5 = r1.getAuctionCalendarInfo()
            if (r4 == 0) goto L_0x0039
            int r3 = r4.intValue()
        L_0x0039:
            java.lang.Object r3 = r5.get(r3)
            com.iaai.android.bdt.model.auctionmainlist.AuctionCalendarInfo r3 = (com.iaai.android.bdt.model.auctionmainlist.AuctionCalendarInfo) r3
            java.lang.String r3 = r3.getAuctionDate()
            java.lang.String r4 = ""
            if (r3 == 0) goto L_0x0049
            r5 = r3
            goto L_0x004a
        L_0x0049:
            r5 = r4
        L_0x004a:
            r2.selectedDate = r3
            r2.isCalederDateSelect = r0
            java.lang.String r3 = r2.searchDate
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
            r3 = r3 ^ r0
            if (r3 == 0) goto L_0x0059
            r2.searchDate = r5
        L_0x0059:
            int r3 = com.iaai.android.C2723R.C2726id.etSearch
            android.view.View r3 = r2._$_findCachedViewById(r3)
            android.widget.EditText r3 = (android.widget.EditText) r3
            java.lang.String r0 = "etSearch"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)
            android.text.Editable r3 = r3.getText()
            java.lang.String r3 = r3.toString()
            r2.fetchAuctionMainList(r3, r5, r4, r4)
            int r3 = com.iaai.android.C2723R.C2726id.tvAuctionDate
            android.view.View r3 = r2._$_findCachedViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            java.lang.String r4 = "tvAuctionDate"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            java.lang.String r4 = "EEE, MMM d"
            java.lang.String r4 = r2.getServerFormatDate(r5, r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
            goto L_0x00a1
        L_0x008a:
            r3 = 104(0x68, float:1.46E-43)
            if (r4 != r3) goto L_0x00a1
            if (r5 == 0) goto L_0x0096
            java.lang.String r3 = "searchinput"
            java.lang.String r1 = r5.getStringExtra(r3)
        L_0x0096:
            java.lang.String r3 = java.lang.String.valueOf(r1)
            r2.searchInputKey = r3
            r2.isFromSearchKeyword = r0
            r2.handleSearchKeyword()
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.auctionMainPage.AuctionMainListFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    private final void initializeCalendarView() {
        Calendar instance = Calendar.getInstance();
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvAuctionDate);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvAuctionDate");
        NewDateHelper newDateHelper = NewDateHelper.INSTANCE;
        Intrinsics.checkExpressionValueIsNotNull(instance, "c");
        textView.setText(newDateHelper.format(instance.getTime(), Constants.DATE_PATTERN_NEXT_AUCTION_DATE_SHORT));
    }

    private final void clearFilter() {
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etSearch)).setText("");
        this.selectedDate = "";
        hideSoftKeyboard();
        initializeCalendarView();
        fetchAuctionMainList("", "", "", "");
    }

    /* access modifiers changed from: private */
    public final List<AuctionLocations> getAuctionDataList() {
        List<AuctionLocations> list;
        CheckBox checkBox = (CheckBox) _$_findCachedViewById(C2723R.C2726id.cvPublicAuction);
        Intrinsics.checkExpressionValueIsNotNull(checkBox, "cvPublicAuction");
        if (checkBox.isChecked()) {
            List<AuctionLocations> list2 = this.auctionLocations;
            if (list2 != null) {
                Collection arrayList = new ArrayList();
                for (Object next : list2) {
                    Boolean publicAuction = ((AuctionLocations) next).getPublicAuction();
                    if (publicAuction != null ? publicAuction.booleanValue() : false) {
                        arrayList.add(next);
                    }
                }
                list = (List) arrayList;
            } else {
                list = null;
            }
        } else {
            list = this.auctionLocations;
        }
        this.auctionList = list;
        return this.auctionList;
    }

    /* access modifiers changed from: private */
    public final void updateSuggestions(Context context, String str) {
        if (str != null) {
            String str2 = RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_BRANCH_NO() + "=?";
            String[] strArr = {str};
            Cursor query = context.getContentResolver().query(RecentViewContract.Suggestions.Companion.getCONTENT_URI(), new String[]{RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_FREQUENCY()}, str2, strArr, (String) null);
            if (query == null) {
                Intrinsics.throwNpe();
            }
            if (query.getCount() > 0) {
                int suggestionsFrequencyFromCursor = getSuggestionsFrequencyFromCursor(query);
                int suggestionsPriorityFromCursor = getSuggestionsPriorityFromCursor(query);
                Integer num = 10001;
                if (!StringsKt.equals(IAASharedPreference.getUserIdPreferencesMVVM(context), "", false)) {
                    String userIdPreferencesMVVM = IAASharedPreference.getUserIdPreferencesMVVM(context);
                    Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM, "IAASharedPreference.getU…dPreferencesMVVM(context)");
                    num = StringsKt.toIntOrNull(userIdPreferencesMVVM);
                }
                NewDateHelper newDateHelper = NewDateHelper.INSTANCE;
                NewDateHelper newDateHelper2 = NewDateHelper.INSTANCE;
                String str3 = this.selectedDate;
                if (str3 == null) {
                    Intrinsics.throwNpe();
                }
                String format = newDateHelper.format(newDateHelper2.parse(str3, Constants.DATE_PATTERN_CONFIRMATION_PAGE), Constants.DATE_PATTERN_CONFIRMATION_PAGE);
                if (num == null) {
                    Intrinsics.throwNpe();
                }
                context.getContentResolver().update(RecentViewContract.Suggestions.Companion.getCONTENT_URI(), new RecentlyViewedInfo(num.intValue(), Integer.parseInt(str), suggestionsFrequencyFromCursor + 1, suggestionsPriorityFromCursor + 5, System.currentTimeMillis(), format).getContentValues(), str2, strArr);
                return;
            }
            Integer num2 = 10001;
            if (!StringsKt.equals(IAASharedPreference.getUserIdPreferencesMVVM(context), "", false)) {
                String userIdPreferencesMVVM2 = IAASharedPreference.getUserIdPreferencesMVVM(context);
                Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM2, "IAASharedPreference.getU…dPreferencesMVVM(context)");
                num2 = StringsKt.toIntOrNull(userIdPreferencesMVVM2);
            }
            NewDateHelper newDateHelper3 = NewDateHelper.INSTANCE;
            NewDateHelper newDateHelper4 = NewDateHelper.INSTANCE;
            String str4 = this.selectedDate;
            if (str4 == null) {
                Intrinsics.throwNpe();
            }
            String format2 = newDateHelper3.format(newDateHelper4.parse(str4, Constants.DATE_PATTERN_CONFIRMATION_PAGE), Constants.DATE_PATTERN_CONFIRMATION_PAGE);
            if (num2 == null) {
                Intrinsics.throwNpe();
            }
            RecentlyViewedInfo recentlyViewedInfo = new RecentlyViewedInfo(num2.intValue(), Integer.parseInt(str), 1, 5, System.currentTimeMillis(), format2);
            ContentResolver contentResolver = context.getContentResolver();
            Uri content_uri = RecentViewContract.Suggestions.Companion.getCONTENT_URI();
            Cursor query2 = contentResolver.query(content_uri, (String[]) null, RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_AUCTION_DATE() + "=?", new String[]{format2}, RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_UTC_DATE() + " DESC");
            if (query2 == null) {
                Intrinsics.throwNpe();
            }
            if (query2.getCount() > 2) {
                query2.moveToLast();
                String string = query2.getString(query2.getColumnIndex(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_BRANCH_NO()));
                String str5 = RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_BRANCH_NO() + "=?";
                String[] strArr2 = {string};
                getLocationBranchidIndex(string);
                if (context.getContentResolver().delete(RecentViewContract.Suggestions.Companion.getCONTENT_URI(), str5, strArr2) > 0) {
                    context.getContentResolver().insert(RecentViewContract.Suggestions.Companion.getCONTENT_URI(), recentlyViewedInfo.getContentValues());
                    return;
                }
                return;
            }
            context.getContentResolver().insert(RecentViewContract.Suggestions.Companion.getCONTENT_URI(), recentlyViewedInfo.getContentValues());
            return;
        }
        throw new NullPointerException("Branch ID should not be null");
    }

    private final int getSuggestionsFrequencyFromCursor(Cursor cursor) {
        int i = 0;
        if (cursor != null) {
            try {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    i = cursor.getInt(cursor.getColumnIndex(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_FREQUENCY()));
                    cursor.moveToNext();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    private final int getSuggestionsPriorityFromCursor(Cursor cursor) {
        int i = 0;
        if (cursor != null) {
            try {
                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {
                    i = cursor.getInt(cursor.getColumnIndex(RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_PRIORITY()));
                    cursor.moveToNext();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    private final void resetAuctionSuggestionDB(List<AuctionLocations> list) {
        if (list != null) {
            BDTAuctionMainListActivity bDTAuctionMainListActivity = this.auctionMainListActivity;
            if (bDTAuctionMainListActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
            }
            if (IAASharedPreference.isDayOver(bDTAuctionMainListActivity)) {
                Log.e("AuctionSuggestionDB", "called");
                deleteAuctionSuggestionDBWithPriorityZero();
                initialisePriorityInSuggestionDB(list);
            }
        }
    }

    private final void deleteAuctionSuggestionDBWithPriorityZero() {
        String str = RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_PRIORITY() + "=?";
        String[] strArr = {"0"};
        BDTAuctionMainListActivity bDTAuctionMainListActivity = this.auctionMainListActivity;
        if (bDTAuctionMainListActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
        }
        Log.e("AuctionDeleteCount", String.valueOf(bDTAuctionMainListActivity.getContentResolver().delete(RecentViewContract.Suggestions.Companion.getCONTENT_URI(), str, strArr)));
    }

    private final void initialisePriorityInSuggestionDB(List<AuctionLocations> list) {
        NewDateHelper newDateHelper = NewDateHelper.INSTANCE;
        NewDateHelper newDateHelper2 = NewDateHelper.INSTANCE;
        String str = this.selectedDate;
        if (str == null) {
            Intrinsics.throwNpe();
        }
        String format = newDateHelper.format(newDateHelper2.parse(str, Constants.DATE_PATTERN_CONFIRMATION_PAGE), Constants.DATE_PATTERN_CONFIRMATION_PAGE);
        BDTAuctionMainListActivity bDTAuctionMainListActivity = this.auctionMainListActivity;
        if (bDTAuctionMainListActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
        }
        ArrayList<Integer> recentAuctionsBranchIDList = Utils.getRecentAuctionsBranchIDList(bDTAuctionMainListActivity, list, format);
        if (recentAuctionsBranchIDList != null && recentAuctionsBranchIDList.size() > 0) {
            Log.e("initPriInSuggestion", "" + recentAuctionsBranchIDList.size());
            int size = recentAuctionsBranchIDList.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                String str2 = RecentViewContract.Suggestions.Companion.getCOLUMN_NAME_BRANCH_NO() + "=?";
                String[] strArr = {"" + recentAuctionsBranchIDList.get(i2)};
                Log.e("BranchIDNeedUpdate->", "" + recentAuctionsBranchIDList.get(i2));
                BDTAuctionMainListActivity bDTAuctionMainListActivity2 = this.auctionMainListActivity;
                if (bDTAuctionMainListActivity2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
                }
                Cursor query = bDTAuctionMainListActivity2.getContentResolver().query(RecentViewContract.Suggestions.Companion.getCONTENT_URI(), (String[]) null, str2, strArr, (String) null);
                if (query == null) {
                    Intrinsics.throwNpe();
                }
                if (query.getCount() > 0) {
                    query.moveToFirst();
                    RecentlyViewedInfo recentlyViewedInfo = new RecentlyViewedInfo(query);
                    recentlyViewedInfo.setPriority(0);
                    BDTAuctionMainListActivity bDTAuctionMainListActivity3 = this.auctionMainListActivity;
                    if (bDTAuctionMainListActivity3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
                    }
                    i += bDTAuctionMainListActivity3.getContentResolver().update(RecentViewContract.Suggestions.Companion.getCONTENT_URI(), recentlyViewedInfo.getContentValues(), str2, strArr);
                }
                query.close();
            }
            Log.e("rowsUpdated-count", String.valueOf(i));
            if (i > 0) {
                BDTAuctionMainListActivity bDTAuctionMainListActivity4 = this.auctionMainListActivity;
                if (bDTAuctionMainListActivity4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
                }
                IAASharedPreference.saveDayComplete(bDTAuctionMainListActivity4, false);
            }
        }
    }

    private final int getLocationBranchidIndex(String str) {
        List<AuctionLocations> list = this.auctionList;
        if (list == null) {
            Intrinsics.throwNpe();
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            List<AuctionLocations> list2 = this.auctionList;
            if (list2 == null) {
                Intrinsics.throwNpe();
            }
            if (Intrinsics.areEqual((Object) str, (Object) list2.get(i).getBranchid())) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    public final void updateAuctionSegments() {
        AuctionMainListResponse auctionMainListResponse2 = this.auctionMainListResponse;
        Boolean bool = null;
        int i = 0;
        if (auctionMainListResponse2 != null) {
            resetAuctionSuggestionDB(auctionMainListResponse2 != null ? auctionMainListResponse2.getAuctionLocations() : null);
            this.filteredList = new ArrayList<>();
            this.recentList = new ArrayList<>();
            NewDateHelper newDateHelper = NewDateHelper.INSTANCE;
            NewDateHelper newDateHelper2 = NewDateHelper.INSTANCE;
            String str = this.selectedDate;
            if (str == null) {
                Intrinsics.throwNpe();
            }
            String format = newDateHelper.format(newDateHelper2.parse(str, Constants.DATE_PATTERN_CONFIRMATION_PAGE), Constants.DATE_PATTERN_CONFIRMATION_PAGE);
            BDTAuctionMainListActivity bDTAuctionMainListActivity = this.auctionMainListActivity;
            if (bDTAuctionMainListActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("auctionMainListActivity");
            }
            Context context = bDTAuctionMainListActivity;
            AuctionMainListResponse auctionMainListResponse3 = this.auctionMainListResponse;
            ArrayList<Integer> recentAuctionsBranchIDList = Utils.getRecentAuctionsBranchIDList(context, auctionMainListResponse3 != null ? auctionMainListResponse3.getAuctionLocations() : null, format);
            if (recentAuctionsBranchIDList.size() > 0) {
                List<AuctionLocations> list = this.auctionList;
                IntRange indices = list != null ? CollectionsKt.getIndices(list) : null;
                if (indices == null) {
                    Intrinsics.throwNpe();
                }
                int first = indices.getFirst();
                int last = indices.getLast();
                if (first <= last) {
                    while (true) {
                        List<AuctionLocations> list2 = this.auctionList;
                        if (list2 == null) {
                            Intrinsics.throwNpe();
                        }
                        if (!recentAuctionsBranchIDList.contains(Integer.valueOf(Integer.parseInt(list2.get(first).getBranchid())))) {
                            ArrayList<AuctionLocations> arrayList = this.filteredList;
                            if (arrayList == null) {
                                Intrinsics.throwNpe();
                            }
                            List<AuctionLocations> list3 = this.auctionList;
                            if (list3 == null) {
                                Intrinsics.throwNpe();
                            }
                            arrayList.add(list3.get(first));
                        }
                        if (first == last) {
                            break;
                        }
                        first++;
                    }
                }
                Intrinsics.checkExpressionValueIsNotNull(recentAuctionsBranchIDList, "recentBranchIDs");
                int size = recentAuctionsBranchIDList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    int locationBranchidIndex = getLocationBranchidIndex(String.valueOf(recentAuctionsBranchIDList.get(i2).intValue()));
                    if (locationBranchidIndex != -1) {
                        ArrayList<AuctionLocations> arrayList2 = this.recentList;
                        if (arrayList2 == null) {
                            Intrinsics.throwNpe();
                        }
                        List<AuctionLocations> list4 = this.auctionList;
                        if (list4 == null) {
                            Intrinsics.throwNpe();
                        }
                        arrayList2.add(list4.get(locationBranchidIndex));
                    }
                }
            } else {
                List<AuctionLocations> list5 = this.auctionList;
                if (list5 == null) {
                    Intrinsics.throwNpe();
                }
                for (AuctionLocations next : list5) {
                    ArrayList<AuctionLocations> arrayList3 = this.filteredList;
                    if (arrayList3 == null) {
                        Intrinsics.throwNpe();
                    }
                    arrayList3.add(next);
                }
            }
        }
        ArrayList arrayList4 = new ArrayList();
        ArrayList<AuctionLocations> arrayList5 = this.recentList;
        if (arrayList5 != null && arrayList5.size() == 0) {
            ArrayList<AuctionLocations> arrayList6 = this.filteredList;
            if (arrayList6 != null) {
                if (arrayList6 != null) {
                    bool = Boolean.valueOf(!arrayList6.isEmpty());
                }
                if (bool == null) {
                    Intrinsics.throwNpe();
                }
                if (bool.booleanValue()) {
                    showEmptyState(false);
                    AuctionLocations auctionLocations2 = new AuctionLocations();
                    auctionLocations2.setBranchid("DummyAuction");
                    arrayList4.add(auctionLocations2);
                    ArrayList<AuctionLocations> arrayList7 = this.filteredList;
                    if (arrayList7 == null) {
                        Intrinsics.throwNpe();
                    }
                    int size2 = arrayList7.size();
                    while (i < size2) {
                        ArrayList<AuctionLocations> arrayList8 = this.filteredList;
                        if (arrayList8 == null) {
                            Intrinsics.throwNpe();
                        }
                        arrayList4.add(arrayList8.get(i));
                        i++;
                    }
                }
            }
            showEmptyState(true);
        } else if (!(this.filteredList == null || this.recentList == null)) {
            showEmptyState(false);
            ArrayList<AuctionLocations> arrayList9 = this.recentList;
            if (arrayList9 != null) {
                if (arrayList9 == null) {
                    Intrinsics.throwNpe();
                }
                if (arrayList9.size() > 0) {
                    arrayList4.add(new AuctionLocations());
                }
            }
            ArrayList<AuctionLocations> arrayList10 = this.recentList;
            if (arrayList10 == null) {
                Intrinsics.throwNpe();
            }
            int size3 = arrayList10.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ArrayList<AuctionLocations> arrayList11 = this.recentList;
                if (arrayList11 == null) {
                    Intrinsics.throwNpe();
                }
                arrayList4.add(arrayList11.get(i3));
            }
            ArrayList<AuctionLocations> arrayList12 = this.filteredList;
            if (arrayList12 == null || arrayList12.size() != 0) {
                ArrayList<AuctionLocations> arrayList13 = this.recentList;
                if (arrayList13 != null) {
                    if (arrayList13 == null) {
                        Intrinsics.throwNpe();
                    }
                    if (arrayList13.size() > 0) {
                        arrayList4.add(new AuctionLocations());
                    }
                }
                ArrayList<AuctionLocations> arrayList14 = this.filteredList;
                if (arrayList14 == null) {
                    Intrinsics.throwNpe();
                }
                int size4 = arrayList14.size();
                while (i < size4) {
                    ArrayList<AuctionLocations> arrayList15 = this.filteredList;
                    if (arrayList15 == null) {
                        Intrinsics.throwNpe();
                    }
                    arrayList4.add(arrayList15.get(i));
                    i++;
                }
            }
        }
        BDTAuctionMainListAdapter bDTAuctionMainListAdapter = this.auctionMainListAdapter;
        if (bDTAuctionMainListAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("auctionMainListAdapter");
        }
        bDTAuctionMainListAdapter.setData(arrayList4);
    }

    public void onResume() {
        super.onResume();
        if (!this.isCalederDateSelect && !this.isFromSearchKeyword) {
            checkNetworkConnection();
        }
    }

    /* access modifiers changed from: private */
    public final String getServerFormatDate(String str, String str2) {
        String format = DateHelper.format(NewDateHelper.INSTANCE.parse(str, Constants.DATE_PATTERN_DATE_TIME), str2);
        Intrinsics.checkExpressionValueIsNotNull(format, "DateHelper.format(temp,\n                pattern)");
        return format;
    }
}
