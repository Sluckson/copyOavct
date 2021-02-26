package com.iaai.android.bdt.feature.digitalNegotiation;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
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
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.digitalNegotiation.ManageOfferSendActionResponse;
import com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList;
import com.iaai.android.bdt.model.digitalNegotiation.NegotiationsBidHistory;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.support.AndroidSupportInjection;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 `2\u00020\u0001:\u0001`B\u0005¢\u0006\u0002\u0010\u0002J\b\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u000204H\u0002J\u0018\u00106\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\t2\u0006\u00107\u001a\u000208H\u0002J\u0006\u00109\u001a\u00020\u0004J\"\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001b2\b\u0010=\u001a\u0004\u0018\u00010\u001d2\u0006\u0010>\u001a\u00020?H\u0002J\u0018\u0010@\u001a\u00020\r2\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\tH\u0002J\b\u0010A\u001a\u000204H\u0002J\u0012\u0010B\u001a\u0002042\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\"\u0010E\u001a\u0002042\u0006\u0010F\u001a\u00020\r2\u0006\u0010G\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010HH\u0016J\u0010\u0010I\u001a\u0002042\u0006\u0010J\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u0002042\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J&\u0010M\u001a\u0004\u0018\u00010/2\u0006\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010Q2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\b\u0010R\u001a\u000204H\u0016J\b\u0010S\u001a\u000204H\u0016J \u0010T\u001a\u0002042\b\u0010=\u001a\u0004\u0018\u00010\u001d2\u0006\u0010U\u001a\u00020\r2\u0006\u0010<\u001a\u00020\u001bJ\u0010\u0010V\u001a\u0002042\u0006\u0010W\u001a\u00020\u000fH\u0002J\u0010\u0010X\u001a\u0002042\u0006\u0010Y\u001a\u00020\u000fH\u0002J\b\u0010Z\u001a\u000204H\u0002J \u0010[\u001a\u0002042\u0006\u00107\u001a\u0002082\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\tH\u0002J\u0010\u0010\\\u001a\u0002042\u0006\u0010]\u001a\u00020^H\u0002J\b\u0010_\u001a\u000204H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0007*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020%8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "CONTENT_TYPE", "", "DN_API_KEY", "TAG", "kotlin.jvm.PlatformType", "bidHistory", "", "Lcom/iaai/android/bdt/model/digitalNegotiation/NegotiationsBidHistory;", "branchId", "currentCount", "", "isFirstTime", "", "isLoggedIn", "isTablet", "()Z", "setTablet", "(Z)V", "live_date", "manageOfferListActivity", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListActivity;", "manageOfferListAdapter", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListAdapterMain;", "negotiationActionEnum", "Lcom/iaai/android/bdt/feature/digitalNegotiation/NegotiationActionEnum;", "offersList", "Lcom/iaai/android/bdt/model/digitalNegotiation/MobileNegotiationsList;", "requireAction", "getRequireAction", "()I", "setRequireAction", "(I)V", "selectedNegotiation", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "timer", "Ljava/util/Timer;", "totalCount", "userId", "viewManageList", "Landroid/view/View;", "viewModel", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListViewModel;", "year_make_model", "checkNetworkConnection", "", "fetchManageOfferList", "filterListBasedOnSelection", "filterSelect", "Lcom/iaai/android/bdt/feature/digitalNegotiation/FilterSelected;", "getAuthString", "getOfferActionRequestBody", "Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferSendActionRequestBody;", "action", "data", "amount", "", "getRequireActionCount", "initializeRecycler", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onResume", "showDialog", "position", "showEmptyState", "isShowEmptyState", "showLoadingIndicator", "loading", "subscribeToViewModel", "updateRecyclerUI", "updateUIAfterSubmit", "manageOfferSendActionResponse", "Lcom/iaai/android/bdt/model/digitalNegotiation/ManageOfferSendActionResponse;", "updateUIOnSelection", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferListFragment.kt */
public final class ManageOfferListFragment extends BaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SAMPLE = "sample";
    /* access modifiers changed from: private */
    public final String CONTENT_TYPE = "application/json";
    /* access modifiers changed from: private */
    public final String DN_API_KEY = Constants_MVVM.SEARCH_API_KEY;
    private final String TAG = ManageOfferListFragment.class.getSimpleName();
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public List<NegotiationsBidHistory> bidHistory;
    /* access modifiers changed from: private */
    public String branchId = "";
    /* access modifiers changed from: private */
    public int currentCount;
    private boolean isFirstTime = true;
    private boolean isLoggedIn;
    private boolean isTablet;
    /* access modifiers changed from: private */
    public String live_date = "";
    /* access modifiers changed from: private */
    public ManageOfferListActivity manageOfferListActivity;
    /* access modifiers changed from: private */
    public ManageOfferListAdapterMain manageOfferListAdapter;
    /* access modifiers changed from: private */
    public NegotiationActionEnum negotiationActionEnum;
    /* access modifiers changed from: private */
    public List<MobileNegotiationsList> offersList;
    private int requireAction;
    private MobileNegotiationsList selectedNegotiation;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private Timer timer;
    /* access modifiers changed from: private */
    public int totalCount;
    private String userId = "";
    private View viewManageList;
    /* access modifiers changed from: private */
    public ManageOfferListViewModel viewModel;
    /* access modifiers changed from: private */
    public String year_make_model = "";

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[FilterSelected.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = new int[NegotiationActionEnum.values().length];
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = new int[NegotiationActionEnum.values().length];

        static {
            $EnumSwitchMapping$0[FilterSelected.ALL.ordinal()] = 1;
            $EnumSwitchMapping$0[FilterSelected.PENDING_BIDDER.ordinal()] = 2;
            $EnumSwitchMapping$0[FilterSelected.PENDING_SELLER.ordinal()] = 3;
            $EnumSwitchMapping$0[FilterSelected.CLOSED.ordinal()] = 4;
            $EnumSwitchMapping$0[FilterSelected.EXPIRED.ordinal()] = 5;
            $EnumSwitchMapping$1[NegotiationActionEnum.BUY_IT.ordinal()] = 1;
            $EnumSwitchMapping$1[NegotiationActionEnum.KEEP_MY_BID.ordinal()] = 2;
            $EnumSwitchMapping$1[NegotiationActionEnum.RAISE_MY_BID.ordinal()] = 3;
            $EnumSwitchMapping$1[NegotiationActionEnum.BID_HISTORY.ordinal()] = 4;
            $EnumSwitchMapping$2[NegotiationActionEnum.BUY_IT.ordinal()] = 1;
            $EnumSwitchMapping$2[NegotiationActionEnum.KEEP_MY_BID.ordinal()] = 2;
            $EnumSwitchMapping$2[NegotiationActionEnum.RAISE_MY_BID.ordinal()] = 3;
            $EnumSwitchMapping$2[NegotiationActionEnum.RAISE_MY_BID_DISABLED_MSG.ordinal()] = 4;
            $EnumSwitchMapping$2[NegotiationActionEnum.BID_HISTORY.ordinal()] = 5;
        }
    }

    @JvmStatic
    @NotNull
    public static final ManageOfferListFragment newInstance(@NotNull String str) {
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

    public static final /* synthetic */ ManageOfferListActivity access$getManageOfferListActivity$p(ManageOfferListFragment manageOfferListFragment) {
        ManageOfferListActivity manageOfferListActivity2 = manageOfferListFragment.manageOfferListActivity;
        if (manageOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        return manageOfferListActivity2;
    }

    public static final /* synthetic */ ManageOfferListAdapterMain access$getManageOfferListAdapter$p(ManageOfferListFragment manageOfferListFragment) {
        ManageOfferListAdapterMain manageOfferListAdapterMain = manageOfferListFragment.manageOfferListAdapter;
        if (manageOfferListAdapterMain == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListAdapter");
        }
        return manageOfferListAdapterMain;
    }

    public static final /* synthetic */ ManageOfferListViewModel access$getViewModel$p(ManageOfferListFragment manageOfferListFragment) {
        ManageOfferListViewModel manageOfferListViewModel = manageOfferListFragment.viewModel;
        if (manageOfferListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return manageOfferListViewModel;
    }

    public final boolean isTablet() {
        return this.isTablet;
    }

    public final void setTablet(boolean z) {
        this.isTablet = z;
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
            this.manageOfferListActivity = (ManageOfferListActivity) activity;
            if (context instanceof ManageOfferListActivity) {
                this.manageOfferListActivity = (ManageOfferListActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity");
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListFragment$Companion;", "", "()V", "KEY_SAMPLE", "", "newInstance", "Lcom/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListFragment;", "url", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: ManageOfferListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final ManageOfferListFragment newInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            ManageOfferListFragment manageOfferListFragment = new ManageOfferListFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ManageOfferListFragment.KEY_SAMPLE, str);
            manageOfferListFragment.setArguments(bundle);
            return manageOfferListFragment;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        String property = System.getProperty("http.agent");
        Intrinsics.checkExpressionValueIsNotNull(property, "System.getProperty(\"http.agent\")");
        Log.d("UserAgent", property);
        ManageOfferListActivity manageOfferListActivity2 = this.manageOfferListActivity;
        if (manageOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        FragmentActivity fragmentActivity = manageOfferListActivity2;
        ManageOfferListActivity manageOfferListActivity3 = this.manageOfferListActivity;
        if (manageOfferListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, manageOfferListActivity3.getViewModelFactory()).get(ManageOfferListViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(ma…istViewModel::class.java)");
        this.viewModel = (ManageOfferListViewModel) viewModel2;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        ManageOfferListActivity manageOfferListActivity2 = this.manageOfferListActivity;
        if (manageOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        this.isTablet = manageOfferListActivity2.getResources().getBoolean(C2723R.bool.isTabletPhone);
        if (this.viewManageList == null) {
            if (this.isTablet) {
                ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.activity_auction_sales_list_land, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate, "mBinding");
                this.viewManageList = inflate.getRoot();
            } else {
                ViewDataBinding inflate2 = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.activity_auction_sales_list, viewGroup, false);
                Intrinsics.checkExpressionValueIsNotNull(inflate2, "mBinding");
                this.viewManageList = inflate2.getRoot();
            }
        }
        return this.viewManageList;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        ManageOfferListActivity manageOfferListActivity2 = this.manageOfferListActivity;
        if (manageOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        Application application = manageOfferListActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "manageOfferListActivity.application");
        String userIdPreferencesMVVM = IAASharedPreference.getUserIdPreferencesMVVM(application.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(userIdPreferencesMVVM, "IAASharedPreference.getU…ation.applicationContext)");
        this.userId = userIdPreferencesMVVM;
        ManageOfferListActivity manageOfferListActivity3 = this.manageOfferListActivity;
        if (manageOfferListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        Application application2 = manageOfferListActivity3.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application2, "manageOfferListActivity.application");
        Boolean isLoggedInPreferencesMVVM = IAASharedPreference.getIsLoggedInPreferencesMVVM(application2.getApplicationContext());
        Intrinsics.checkExpressionValueIsNotNull(isLoggedInPreferencesMVVM, "IAASharedPreference.getI…ation.applicationContext)");
        this.isLoggedIn = isLoggedInPreferencesMVVM.booleanValue();
        ManageOfferListActivity manageOfferListActivity4 = this.manageOfferListActivity;
        if (manageOfferListActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        ImageView imageView = (ImageView) manageOfferListActivity4._$_findCachedViewById(C2723R.C2726id.arrow_left);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "manageOfferListActivity.arrow_left");
        imageView.setVisibility(8);
        ManageOfferListActivity manageOfferListActivity5 = this.manageOfferListActivity;
        if (manageOfferListActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        ImageView imageView2 = (ImageView) manageOfferListActivity5._$_findCachedViewById(C2723R.C2726id.arrow_right);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "manageOfferListActivity.arrow_right");
        imageView2.setVisibility(8);
        ManageOfferListActivity manageOfferListActivity6 = this.manageOfferListActivity;
        if (manageOfferListActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        RelativeLayout relativeLayout = (RelativeLayout) manageOfferListActivity6._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "manageOfferListActivity.toolbar_relativelayout");
        relativeLayout.setGravity(GravityCompat.START);
        ManageOfferListActivity manageOfferListActivity7 = this.manageOfferListActivity;
        if (manageOfferListActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) manageOfferListActivity7._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "manageOfferListActivity.toolbar_relativelayout");
        relativeLayout2.setGravity(3);
        ManageOfferListActivity manageOfferListActivity8 = this.manageOfferListActivity;
        if (manageOfferListActivity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        manageOfferListActivity8.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_manage_offers));
        ManageOfferListActivity manageOfferListActivity9 = this.manageOfferListActivity;
        if (manageOfferListActivity9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        manageOfferListActivity9.getToolbar_sub_title().setVisibility(8);
        ManageOfferListActivity manageOfferListActivity10 = this.manageOfferListActivity;
        if (manageOfferListActivity10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        ActionBar supportActionBar = manageOfferListActivity10.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeButtonEnabled(true);
        }
        if (this.isTablet) {
            ManageOfferListActivity manageOfferListActivity11 = this.manageOfferListActivity;
            if (manageOfferListActivity11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
            }
            NavController findNavController = Navigation.findNavController(manageOfferListActivity11, C2723R.C2726id.auction_sales_nav_container);
            Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…tion_sales_nav_container)");
            NavInflater navInflater = findNavController.getNavInflater();
            Intrinsics.checkExpressionValueIsNotNull(navInflater, "navController.navInflater");
            NavGraph inflate = navInflater.inflate(C2723R.C2730navigation.navigation_graph_auction_saleslist);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "navInflater.inflate(R.na…_graph_auction_saleslist)");
            NavArgument build = new NavArgument.Builder().setDefaultValue("").build();
            Intrinsics.checkExpressionValueIsNotNull(build, "NavArgument.Builder().se…aultValue(itemId).build()");
            inflate.addArgument(Constants.EXTRA_ITEM_ID, build);
            findNavController.setGraph(inflate);
        }
        if (this.isFirstTime) {
            initializeRecycler();
            checkNetworkConnection();
        }
    }

    public void onResume() {
        super.onResume();
        ManageOfferListActivity manageOfferListActivity2 = this.manageOfferListActivity;
        if (manageOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        manageOfferListActivity2.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_manage_offers));
        ManageOfferListActivity manageOfferListActivity3 = this.manageOfferListActivity;
        if (manageOfferListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        manageOfferListActivity3.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_black));
        ManageOfferListActivity manageOfferListActivity4 = this.manageOfferListActivity;
        if (manageOfferListActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        manageOfferListActivity4.getIvStockShare().setVisibility(8);
        ManageOfferListActivity manageOfferListActivity5 = this.manageOfferListActivity;
        if (manageOfferListActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        List<MobileNegotiationsList> filterListBasedOnSelection = filterListBasedOnSelection(manageOfferListActivity5.getFilterSelected());
        ManageOfferListActivity manageOfferListActivity6 = this.manageOfferListActivity;
        if (manageOfferListActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        updateRecyclerUI(manageOfferListActivity6.getFilterSelected(), filterListBasedOnSelection);
    }

    public void onDestroy() {
        super.onDestroy();
        ManageOfferListViewModel manageOfferListViewModel = this.viewModel;
        if (manageOfferListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        manageOfferListViewModel.disposeElements();
    }

    private final void initializeRecycler() {
        this.isFirstTime = false;
        ManageOfferListActivity manageOfferListActivity2 = this.manageOfferListActivity;
        if (manageOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionSales)).addItemDecoration(new DividerItemDecoration(manageOfferListActivity2, 1));
        ManageOfferListViewModel manageOfferListViewModel = this.viewModel;
        if (manageOfferListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        Context applicationContext = activity.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "activity!!.applicationContext");
        this.manageOfferListAdapter = new ManageOfferListAdapterMain(manageOfferListViewModel, applicationContext, new ManageOfferListFragment$initializeRecycler$1(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionSales);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvAuctionSales");
        ManageOfferListAdapterMain manageOfferListAdapterMain = this.manageOfferListAdapter;
        if (manageOfferListAdapterMain == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListAdapter");
        }
        recyclerView.setAdapter(manageOfferListAdapterMain);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionSales);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvAuctionSales");
        ManageOfferListActivity manageOfferListActivity3 = this.manageOfferListActivity;
        if (manageOfferListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(manageOfferListActivity3));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionSales)).addOnScrollListener(new ManageOfferListFragment$initializeRecycler$2(this));
        ((FloatingActionButton) _$_findCachedViewById(C2723R.C2726id.fab)).setOnClickListener(new ManageOfferListFragment$initializeRecycler$3(this));
    }

    /* access modifiers changed from: private */
    public final List<MobileNegotiationsList> filterListBasedOnSelection(FilterSelected filterSelected) {
        int i = WhenMappings.$EnumSwitchMapping$0[filterSelected.ordinal()];
        if (i == 1) {
            return this.offersList;
        }
        if (i == 2) {
            List<MobileNegotiationsList> list = this.offersList;
            if (list == null) {
                return null;
            }
            Collection arrayList = new ArrayList();
            for (Object next : list) {
                if (Intrinsics.areEqual((Object) ((MobileNegotiationsList) next).getStatus(), (Object) "PendingBidder")) {
                    arrayList.add(next);
                }
            }
            return (List) arrayList;
        } else if (i == 3) {
            List<MobileNegotiationsList> list2 = this.offersList;
            if (list2 == null) {
                return null;
            }
            Collection arrayList2 = new ArrayList();
            for (Object next2 : list2) {
                if (Intrinsics.areEqual((Object) ((MobileNegotiationsList) next2).getStatus(), (Object) "PendingSeller")) {
                    arrayList2.add(next2);
                }
            }
            return (List) arrayList2;
        } else if (i == 4) {
            List<MobileNegotiationsList> list3 = this.offersList;
            if (list3 == null) {
                return null;
            }
            Collection arrayList3 = new ArrayList();
            for (Object next3 : list3) {
                if (Intrinsics.areEqual((Object) ((MobileNegotiationsList) next3).getStatus(), (Object) "Closed")) {
                    arrayList3.add(next3);
                }
            }
            return (List) arrayList3;
        } else if (i == 5) {
            List<MobileNegotiationsList> list4 = this.offersList;
            if (list4 == null) {
                return null;
            }
            Collection arrayList4 = new ArrayList();
            for (Object next4 : list4) {
                if (Intrinsics.areEqual((Object) ((MobileNegotiationsList) next4).getStatus(), (Object) "Expired")) {
                    arrayList4.add(next4);
                }
            }
            return (List) arrayList4;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void subscribeToViewModel() {
        ManageOfferListViewModel manageOfferListViewModel = this.viewModel;
        if (manageOfferListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        manageOfferListViewModel.getManageOfferResult().observe(lifecycleOwner, new ManageOfferListFragment$subscribeToViewModel$1(this));
        ManageOfferListViewModel manageOfferListViewModel2 = this.viewModel;
        if (manageOfferListViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        manageOfferListViewModel2.getManageOfferError().observe(lifecycleOwner, new ManageOfferListFragment$subscribeToViewModel$2(this));
        ManageOfferListViewModel manageOfferListViewModel3 = this.viewModel;
        if (manageOfferListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<Boolean> showLoading = manageOfferListViewModel3.getShowLoading();
        ManageOfferListActivity manageOfferListActivity2 = this.manageOfferListActivity;
        if (manageOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        showLoading.observe(manageOfferListActivity2, new ManageOfferListFragment$subscribeToViewModel$3(this));
        ManageOfferListViewModel manageOfferListViewModel4 = this.viewModel;
        if (manageOfferListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<ManageOfferSendActionResponse> sendActionResult = manageOfferListViewModel4.getSendActionResult();
        ManageOfferListActivity manageOfferListActivity3 = this.manageOfferListActivity;
        if (manageOfferListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        sendActionResult.observe(manageOfferListActivity3, new ManageOfferListFragment$subscribeToViewModel$4(this));
        ManageOfferListViewModel manageOfferListViewModel5 = this.viewModel;
        if (manageOfferListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> sendActionError = manageOfferListViewModel5.getSendActionError();
        ManageOfferListActivity manageOfferListActivity4 = this.manageOfferListActivity;
        if (manageOfferListActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        sendActionError.observe(manageOfferListActivity4, new ManageOfferListFragment$subscribeToViewModel$5(this));
    }

    /* access modifiers changed from: private */
    public final void updateUIAfterSubmit(ManageOfferSendActionResponse manageOfferSendActionResponse) {
        ManageOfferListAdapterMain manageOfferListAdapterMain = this.manageOfferListAdapter;
        if (manageOfferListAdapterMain == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListAdapter");
        }
        List<MobileNegotiationsList> mobileNegotiationList = manageOfferListAdapterMain.getMobileNegotiationList();
        if (mobileNegotiationList != null) {
            int i = 0;
            for (Object next : mobileNegotiationList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                MobileNegotiationsList mobileNegotiationsList = (MobileNegotiationsList) next;
                String str = null;
                if (Intrinsics.areEqual((Object) manageOfferSendActionResponse != null ? manageOfferSendActionResponse.getExternalAuctionId() : null, (Object) mobileNegotiationsList.getExternalAuctionId())) {
                    if (Intrinsics.areEqual((Object) manageOfferSendActionResponse != null ? manageOfferSendActionResponse.getExternalAuctionItemid() : null, (Object) mobileNegotiationsList.getExternalAuctionItemId())) {
                        if (Intrinsics.areEqual((Object) manageOfferSendActionResponse != null ? manageOfferSendActionResponse.getNegotiationid() : null, (Object) mobileNegotiationsList.getNegotiationId())) {
                            if (manageOfferSendActionResponse != null) {
                                str = manageOfferSendActionResponse.getAction();
                            }
                            if (Intrinsics.areEqual((Object) str, (Object) NegotiationActionEnum.BUY_IT.getValue())) {
                                mobileNegotiationsList.setEventtype("Accept");
                                mobileNegotiationsList.setStatus("Closed");
                            } else if (Intrinsics.areEqual((Object) str, (Object) NegotiationActionEnum.KEEP_MY_BID.getValue())) {
                                mobileNegotiationsList.setEventtype("Reject");
                                mobileNegotiationsList.setStatus("PendingSeller");
                            } else if (Intrinsics.areEqual((Object) str, (Object) NegotiationActionEnum.RAISE_MY_BID.getValue())) {
                                mobileNegotiationsList.setEventtype("CounterOffer");
                                mobileNegotiationsList.setStatus("PendingSeller");
                                StringBuilder sb = new StringBuilder();
                                sb.append(Typography.dollar);
                                sb.append(manageOfferSendActionResponse.getAmount());
                                mobileNegotiationsList.setFormattedNegotiationAmount(sb.toString());
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(Typography.dollar);
                                sb2.append(manageOfferSendActionResponse.getAmount());
                                mobileNegotiationsList.setFormattedCurrentBidAmount(sb2.toString());
                            }
                            ManageOfferListAdapterMain manageOfferListAdapterMain2 = this.manageOfferListAdapter;
                            if (manageOfferListAdapterMain2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("manageOfferListAdapter");
                            }
                            this.requireAction = getRequireActionCount(manageOfferListAdapterMain2.getMobileNegotiationList());
                            updateUIOnSelection();
                        }
                    }
                }
                i = i2;
            }
        }
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
            fetchManageOfferList();
            return;
        }
        showEmptyState(true);
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvEmptyMessage);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvEmptyMessage");
        textView.setText(getResources().getString(C2723R.string.bdt_lbl_error_no_internet_title));
        InternetUtil.INSTANCE.observe(this, new ManageOfferListFragment$checkNetworkConnection$1(this));
    }

    /* access modifiers changed from: private */
    public final void fetchManageOfferList() {
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
        ManageOfferListViewModel manageOfferListViewModel = this.viewModel;
        if (manageOfferListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        manageOfferListViewModel.loadManageOfferList(format, language, "");
        subscribeToViewModel();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0058, code lost:
        r2 = r21.getSellerOfferAmount();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showDialog(@org.jetbrains.annotations.Nullable com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList r21, int r22, @org.jetbrains.annotations.NotNull com.iaai.android.bdt.feature.digitalNegotiation.NegotiationActionEnum r23) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r23
            java.lang.String r3 = "action"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r3)
            r0.negotiationActionEnum = r2
            r0.selectedNegotiation = r1
            kotlin.jvm.internal.Ref$LongRef r3 = new kotlin.jvm.internal.Ref$LongRef
            r3.<init>()
            r4 = 0
            r3.element = r4
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment$showDialog$onAlertButtonClick$1 r6 = new com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment$showDialog$onAlertButtonClick$1
            r6.<init>(r0, r2, r1, r3)
            int[] r7 = com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.WhenMappings.$EnumSwitchMapping$2
            int r2 = r23.ordinal()
            r2 = r7[r2]
            r7 = 0
            r8 = 0
            r9 = 1
            java.lang.String r10 = "manageOfferListActivity"
            if (r2 == r9) goto L_0x00eb
            r11 = 2
            if (r2 == r11) goto L_0x00a0
            r7 = 3
            if (r2 == r7) goto L_0x0056
            r1 = 4
            if (r2 == r1) goto L_0x0037
            goto L_0x0135
        L_0x0037:
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r1 = r0.manageOfferListActivity
            if (r1 != 0) goto L_0x003e
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
        L_0x003e:
            androidx.appcompat.app.AppCompatActivity r1 = (androidx.appcompat.app.AppCompatActivity) r1
            android.content.res.Resources r2 = r20.getResources()
            r3 = 2131821533(0x7f1103dd, float:1.9275812E38)
            java.lang.String r2 = r2.getString(r3)
            android.app.Dialog r1 = com.iaai.android.bdt.extensions.Activity_ExtensionKt.showToolTip(r1, r2)
            if (r1 == 0) goto L_0x0135
            r1.show()
            goto L_0x0135
        L_0x0056:
            if (r1 == 0) goto L_0x0064
            java.lang.Long r2 = r21.getSellerOfferAmount()
            if (r2 == 0) goto L_0x0064
            long r11 = r2.longValue()
            r14 = r11
            goto L_0x0065
        L_0x0064:
            r14 = r4
        L_0x0065:
            if (r1 == 0) goto L_0x0071
            java.lang.Long r1 = r21.getBidAmount()
            if (r1 == 0) goto L_0x0071
            long r4 = r1.longValue()
        L_0x0071:
            r16 = r4
            com.iaai.android.bdt.feature.digitalNegotiation.CustomRaiseBidDialog r1 = new com.iaai.android.bdt.feature.digitalNegotiation.CustomRaiseBidDialog
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r2 = r0.manageOfferListActivity
            if (r2 != 0) goto L_0x007c
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
        L_0x007c:
            r18 = r2
            android.app.Activity r18 = (android.app.Activity) r18
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment$showDialog$customDialog$1 r2 = new com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment$showDialog$customDialog$1
            r2.<init>(r0, r3, r6)
            r19 = r2
            com.iaai.android.bdt.feature.digitalNegotiation.RaiseBidCallback r19 = (com.iaai.android.bdt.feature.digitalNegotiation.RaiseBidCallback) r19
            r13 = r1
            r13.<init>(r14, r16, r18, r19)
            android.view.Window r2 = r1.getWindow()
            if (r2 == 0) goto L_0x0098
            r3 = 17
            r2.setGravity(r3)
        L_0x0098:
            r1.show()
            r1.setCanceledOnTouchOutside(r8)
            goto L_0x0135
        L_0x00a0:
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r2 = r0.manageOfferListActivity
            if (r2 != 0) goto L_0x00a7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
        L_0x00a7:
            r11 = r2
            androidx.appcompat.app.AppCompatActivity r11 = (androidx.appcompat.app.AppCompatActivity) r11
            android.content.res.Resources r2 = r20.getResources()
            r3 = 2131821494(0x7f1103b6, float:1.9275733E38)
            java.lang.String r12 = r2.getString(r3)
            java.lang.String r2 = "resources.getString(R.string.lbl_keep_my_bid)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r2)
            android.content.res.Resources r2 = r20.getResources()
            r3 = 2131821495(0x7f1103b7, float:1.9275735E38)
            java.lang.Object[] r4 = new java.lang.Object[r9]
            if (r1 == 0) goto L_0x00c9
            java.lang.String r7 = r21.getFormattedCurrentBidAmount()
        L_0x00c9:
            java.lang.String r1 = java.lang.String.valueOf(r7)
            r4[r8] = r1
            java.lang.String r13 = r2.getString(r3, r4)
            java.lang.String r1 = "resources.getString(R.st…mattedCurrentBidAmount}\")"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r1)
            r14 = 2131821493(0x7f1103b5, float:1.927573E38)
            r15 = 17039360(0x1040000, float:2.424457E-38)
            r16 = r6
            com.iaai.android.bdt.extensions.OnAlertButtonClick r16 = (com.iaai.android.bdt.extensions.OnAlertButtonClick) r16
            android.app.Dialog r1 = com.iaai.android.bdt.extensions.Activity_ExtensionKt.showAlertWithTitle(r11, r12, r13, r14, r15, r16)
            if (r1 == 0) goto L_0x0135
            r1.show()
            goto L_0x0135
        L_0x00eb:
            com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity r2 = r0.manageOfferListActivity
            if (r2 != 0) goto L_0x00f2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r10)
        L_0x00f2:
            r11 = r2
            androidx.appcompat.app.AppCompatActivity r11 = (androidx.appcompat.app.AppCompatActivity) r11
            android.content.res.Resources r2 = r20.getResources()
            r3 = 2131821319(0x7f110307, float:1.9275378E38)
            java.lang.String r12 = r2.getString(r3)
            java.lang.String r2 = "resources.getString(R.string.lbl_buy_vehicle)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r2)
            android.content.res.Resources r2 = r20.getResources()
            r3 = 2131821320(0x7f110308, float:1.927538E38)
            java.lang.Object[] r4 = new java.lang.Object[r9]
            if (r1 == 0) goto L_0x0114
            java.lang.String r7 = r21.getFormattedSellerOfferAmount()
        L_0x0114:
            java.lang.String r1 = java.lang.String.valueOf(r7)
            r4[r8] = r1
            java.lang.String r13 = r2.getString(r3, r4)
            java.lang.String r1 = "resources.getString(R.st…attedSellerOfferAmount}\")"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r13, r1)
            r14 = 2131821307(0x7f1102fb, float:1.9275353E38)
            r15 = 17039360(0x1040000, float:2.424457E-38)
            r16 = r6
            com.iaai.android.bdt.extensions.OnAlertButtonClick r16 = (com.iaai.android.bdt.extensions.OnAlertButtonClick) r16
            android.app.Dialog r1 = com.iaai.android.bdt.extensions.Activity_ExtensionKt.showAlertWithTitle(r11, r12, r13, r14, r15, r16)
            if (r1 == 0) goto L_0x0135
            r1.show()
        L_0x0135:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.showDialog(com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList, int, com.iaai.android.bdt.feature.digitalNegotiation.NegotiationActionEnum):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r12.getNegotiationId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.iaai.android.bdt.model.digitalNegotiation.ManageOfferSendActionRequestBody getOfferActionRequestBody(com.iaai.android.bdt.feature.digitalNegotiation.NegotiationActionEnum r11, com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList r12, long r13) {
        /*
            r10 = this;
            com.iaai.android.bdt.model.digitalNegotiation.ManageOfferSendActionRequestBody r9 = new com.iaai.android.bdt.model.digitalNegotiation.ManageOfferSendActionRequestBody
            java.lang.String r1 = r11.getValue()
            java.lang.String r11 = ""
            if (r12 == 0) goto L_0x0012
            java.lang.String r0 = r12.getNegotiationId()
            if (r0 == 0) goto L_0x0012
            r2 = r0
            goto L_0x0013
        L_0x0012:
            r2 = r11
        L_0x0013:
            if (r12 == 0) goto L_0x001d
            java.lang.String r0 = r12.getExternalAuctionId()
            if (r0 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r11
        L_0x001e:
            if (r12 == 0) goto L_0x0028
            java.lang.String r0 = r12.getExternalAuctionItemId()
            if (r0 == 0) goto L_0x0028
            r4 = r0
            goto L_0x0029
        L_0x0028:
            r4 = r11
        L_0x0029:
            if (r12 == 0) goto L_0x0033
            java.lang.String r0 = r12.getStockNumber()
            if (r0 == 0) goto L_0x0033
            r7 = r0
            goto L_0x0034
        L_0x0033:
            r7 = r11
        L_0x0034:
            if (r12 == 0) goto L_0x003b
            java.lang.Integer r11 = r12.getBranchCode()
            goto L_0x003c
        L_0x003b:
            r11 = 0
        L_0x003c:
            r8 = r11
            r0 = r9
            r5 = r13
            r0.<init>(r1, r2, r3, r4, r5, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment.getOfferActionRequestBody(com.iaai.android.bdt.feature.digitalNegotiation.NegotiationActionEnum, com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList, long):com.iaai.android.bdt.model.digitalNegotiation.ManageOfferSendActionRequestBody");
    }

    @NotNull
    public final String getAuthString() {
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
        return format;
    }

    /* access modifiers changed from: private */
    public final void showEmptyState(boolean z) {
        if (z) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvEmptyMessage);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvEmptyMessage");
            textView.setVisibility(0);
            return;
        }
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvEmptyMessage);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvEmptyMessage");
        textView2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void updateRecyclerUI(FilterSelected filterSelected, List<MobileNegotiationsList> list) {
        ManageOfferListAdapterMain manageOfferListAdapterMain = this.manageOfferListAdapter;
        if (manageOfferListAdapterMain == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListAdapter");
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        manageOfferListAdapterMain.setNegotiationList(list);
        ManageOfferListAdapterMain manageOfferListAdapterMain2 = this.manageOfferListAdapter;
        if (manageOfferListAdapterMain2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListAdapter");
        }
        List<NegotiationsBidHistory> list2 = this.bidHistory;
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        manageOfferListAdapterMain2.setNegotiationsBidHistory(list2);
        ManageOfferListAdapterMain manageOfferListAdapterMain3 = this.manageOfferListAdapter;
        if (manageOfferListAdapterMain3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListAdapter");
        }
        manageOfferListAdapterMain3.setRequireActionCount(this.requireAction);
        ManageOfferListAdapterMain manageOfferListAdapterMain4 = this.manageOfferListAdapter;
        if (manageOfferListAdapterMain4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListAdapter");
        }
        manageOfferListAdapterMain4.setFilterSelected(filterSelected);
        ManageOfferListAdapterMain manageOfferListAdapterMain5 = this.manageOfferListAdapter;
        if (manageOfferListAdapterMain5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListAdapter");
        }
        manageOfferListAdapterMain5.notifyDataSetChanged();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvAuctionSales);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvAuctionSales");
        ManageOfferListAdapterMain manageOfferListAdapterMain6 = this.manageOfferListAdapter;
        if (manageOfferListAdapterMain6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListAdapter");
        }
        recyclerView.setAdapter(manageOfferListAdapterMain6);
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100 && i2 == -1) {
            ManageOfferListActivity manageOfferListActivity2 = this.manageOfferListActivity;
            if (manageOfferListActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
            }
            Serializable serializableExtra = intent != null ? intent.getSerializableExtra(Constants_MVVM.SELECTED_MANAGE_OFFER_FILTER) : null;
            if (serializableExtra != null) {
                manageOfferListActivity2.setFilterSelected((FilterSelected) serializableExtra);
                updateUIOnSelection();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.digitalNegotiation.FilterSelected");
        }
    }

    private final void updateUIOnSelection() {
        String str;
        MobileNegotiationsList mobileNegotiationsList;
        ManageOfferListActivity manageOfferListActivity2 = this.manageOfferListActivity;
        if (manageOfferListActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        List<MobileNegotiationsList> filterListBasedOnSelection = filterListBasedOnSelection(manageOfferListActivity2.getFilterSelected());
        ManageOfferListActivity manageOfferListActivity3 = this.manageOfferListActivity;
        if (manageOfferListActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        updateRecyclerUI(manageOfferListActivity3.getFilterSelected(), filterListBasedOnSelection);
        ManageOfferListActivity manageOfferListActivity4 = this.manageOfferListActivity;
        if (manageOfferListActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("manageOfferListActivity");
        }
        TextView toolbar_sub_title = manageOfferListActivity4.getToolbar_sub_title();
        Resources resources = getResources();
        Object[] objArr = new Object[1];
        objArr[0] = filterListBasedOnSelection != null ? Integer.valueOf(filterListBasedOnSelection.size()) : 0;
        toolbar_sub_title.setText(resources.getString(C2723R.string.lbl_total_results, objArr));
        if (filterListBasedOnSelection == null || filterListBasedOnSelection.size() != 0) {
            str = String.valueOf((filterListBasedOnSelection == null || (mobileNegotiationsList = filterListBasedOnSelection.get(0)) == null) ? null : mobileNegotiationsList.getItemId());
            showEmptyState(false);
        } else {
            showEmptyState(true);
            str = "";
        }
        if (this.isTablet) {
            Bundle bundle = new Bundle();
            bundle.putString(Constants.EXTRA_ITEM_ID, str);
            Fragment findFragmentById = getChildFragmentManager().findFragmentById(C2723R.C2726id.auction_sales_nav_container);
            if (findFragmentById != null) {
                NavHostFragment navHostFragment = (NavHostFragment) findFragmentById;
                navHostFragment.getNavController().popBackStack();
                navHostFragment.getNavController().navigate((int) C2723R.C2726id.PDFragment, bundle);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        }
    }

    public final int getRequireAction() {
        return this.requireAction;
    }

    public final void setRequireAction(int i) {
        this.requireAction = i;
    }

    /* access modifiers changed from: private */
    public final int getRequireActionCount(List<MobileNegotiationsList> list) {
        if (list == null) {
            return 0;
        }
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (Intrinsics.areEqual((Object) ((MobileNegotiationsList) next).getStatus(), (Object) "PendingBidder")) {
                arrayList.add(next);
            }
        }
        return ((List) arrayList).size();
    }
}
