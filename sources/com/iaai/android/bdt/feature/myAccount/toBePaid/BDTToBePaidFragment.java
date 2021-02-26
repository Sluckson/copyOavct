package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.feature.auctionSalesList.SortListActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.logIAAError.LogIAAErrorRequest;
import com.iaai.android.bdt.model.sort.SortOptionData;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.UiUtils;
import com.lowagie.text.html.HtmlTags;
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
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010U\u001a\u00020VH\u0002J\b\u0010W\u001a\u00020VH\u0002J\b\u0010X\u001a\u00020VH\u0002J\b\u0010Y\u001a\u00020VH\u0002J\u0016\u0010Z\u001a\u00020!2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020;0\\H\u0002J2\u0010]\u001a\u00020V2\b\u0010^\u001a\u0004\u0018\u00010)2\u0006\u0010_\u001a\u00020)2\u0006\u0010`\u001a\u00020)2\u0006\u0010a\u001a\u00020)2\u0006\u0010b\u001a\u00020)H\u0002J\u0012\u0010c\u001a\u00020V2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\"\u0010f\u001a\u00020V2\u0006\u0010g\u001a\u00020\u00162\u0006\u0010h\u001a\u00020\u00162\b\u0010i\u001a\u0004\u0018\u00010jH\u0016J\u0010\u0010k\u001a\u00020V2\u0006\u0010l\u001a\u00020mH\u0016J\b\u0010n\u001a\u00020VH\u0016J\u0012\u0010o\u001a\u00020V2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J&\u0010p\u001a\u0004\u0018\u00010C2\u0006\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010t2\b\u0010d\u001a\u0004\u0018\u00010eH\u0016J\b\u0010u\u001a\u00020VH\u0016J\b\u0010v\u001a\u00020VH\u0016J\b\u0010w\u001a\u00020VH\u0016J\b\u0010x\u001a\u00020VH\u0016J\u0012\u0010y\u001a\u00020V2\b\u0010z\u001a\u0004\u0018\u00010;H\u0016J\u0018\u0010{\u001a\u00020V2\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:H\u0016J\u0010\u0010|\u001a\u00020V2\u0006\u0010}\u001a\u00020!H\u0016J\b\u0010~\u001a\u00020VH\u0002J\u0011\u0010\u001a\u00020V2\u0007\u0010\u0001\u001a\u00020!H\u0002J\u0012\u0010\u0001\u001a\u00020V2\u0007\u0010\u0001\u001a\u00020!H\u0002J\t\u0010\u0001\u001a\u00020VH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR\u001a\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u000e\u0010'\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020)X.¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u00020-8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X.¢\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR\u000e\u00107\u001a\u00020)X\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R \u00109\u001a\b\u0012\u0004\u0012\u00020;0:X.¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020AX.¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010D\u001a\u00020EX.¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001e\u0010J\u001a\u00020K8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001c\u0010P\u001a\u0004\u0018\u00010CX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTToBePaidFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidClickListener;", "()V", "allowanceUsed", "", "getAllowanceUsed", "()D", "setAllowanceUsed", "(D)V", "amtIncludingCDF", "Lkotlin/Pair;", "getAmtIncludingCDF", "()Lkotlin/Pair;", "setAmtIncludingCDF", "(Lkotlin/Pair;)V", "bdtPaymentActivity", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentActivity;", "cdfFee", "getCdfFee", "setCdfFee", "currentCount", "", "dailyAllowance", "getDailyAllowance", "setDailyAllowance", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "setGson", "(Lcom/google/gson/Gson;)V", "isFirstTime", "", "()Z", "setFirstTime", "(Z)V", "isTablet", "setTablet", "lastSelectedSort", "onlyMyItem", "", "payPalAccountDetailID", "paymentMode", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "sortItem", "Lcom/iaai/android/bdt/model/sort/SortOptionData;", "totalAmountForSelected", "getTotalAmountForSelected", "setTotalAmountForSelected", "totalDueAmount", "totalItemCount", "vehicleList", "Landroidx/paging/PagedList;", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "getVehicleList", "()Landroidx/paging/PagedList;", "setVehicleList", "(Landroidx/paging/PagedList;)V", "vehicleRecyclerViewAdapter", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/SelectVehiclesAdapter;", "viewList", "Landroid/view/View;", "viewModel", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "viewSaleList", "getViewSaleList", "()Landroid/view/View;", "setViewSaleList", "(Landroid/view/View;)V", "checkNetworkConnection", "", "getToBePaidList", "initializeRecycler", "initializeUI", "isSaleDocCheckRequired", "selectedList", "", "logIAAError", "userID", "methodName", "request", "response", "httpstatus", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onChangePaymentClick", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onSelectPaymentClick", "onSelectPaymentInfoClick", "onSortClick", "onVehicleClick", "vehicle", "onVehicleSelect", "onVehicleSelectAll", "isSelected", "resetUI", "showEmptyState", "isShowEmptyState", "showLoadingIndicator", "loading", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTToBePaidFragment.kt */
public final class BDTToBePaidFragment extends BaseFragment implements ToBePaidClickListener {
    private HashMap _$_findViewCache;
    private double allowanceUsed;
    @NotNull
    private Pair<Double, Double> amtIncludingCDF;
    /* access modifiers changed from: private */
    public BDTPaymentActivity bdtPaymentActivity;
    private double cdfFee;
    /* access modifiers changed from: private */
    public int currentCount;
    private double dailyAllowance;
    @NotNull
    public Gson gson;
    private boolean isFirstTime = true;
    private boolean isTablet;
    /* access modifiers changed from: private */
    public int lastSelectedSort = 2;
    /* access modifiers changed from: private */
    public String onlyMyItem;
    /* access modifiers changed from: private */
    public int payPalAccountDetailID;
    /* access modifiers changed from: private */
    public String paymentMode;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public SortOptionData sortItem;
    private double totalAmountForSelected;
    /* access modifiers changed from: private */
    public String totalDueAmount = "";
    /* access modifiers changed from: private */
    public int totalItemCount;
    @NotNull
    public PagedList<PaymentDue> vehicleList;
    /* access modifiers changed from: private */
    public SelectVehiclesAdapter vehicleRecyclerViewAdapter;
    private View viewList;
    @NotNull
    public ToBePaidViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;
    @Nullable
    private View viewSaleList;

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

    public void onSelectPaymentClick() {
    }

    public void onSelectPaymentInfoClick() {
    }

    public BDTToBePaidFragment() {
        Double valueOf = Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.amtIncludingCDF = new Pair<>(valueOf, valueOf);
    }

    public static final /* synthetic */ BDTPaymentActivity access$getBdtPaymentActivity$p(BDTToBePaidFragment bDTToBePaidFragment) {
        BDTPaymentActivity bDTPaymentActivity = bDTToBePaidFragment.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        return bDTPaymentActivity;
    }

    public static final /* synthetic */ String access$getOnlyMyItem$p(BDTToBePaidFragment bDTToBePaidFragment) {
        String str = bDTToBePaidFragment.onlyMyItem;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlyMyItem");
        }
        return str;
    }

    public static final /* synthetic */ String access$getPaymentMode$p(BDTToBePaidFragment bDTToBePaidFragment) {
        String str = bDTToBePaidFragment.paymentMode;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentMode");
        }
        return str;
    }

    public static final /* synthetic */ SortOptionData access$getSortItem$p(BDTToBePaidFragment bDTToBePaidFragment) {
        SortOptionData sortOptionData = bDTToBePaidFragment.sortItem;
        if (sortOptionData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortItem");
        }
        return sortOptionData;
    }

    public static final /* synthetic */ SelectVehiclesAdapter access$getVehicleRecyclerViewAdapter$p(BDTToBePaidFragment bDTToBePaidFragment) {
        SelectVehiclesAdapter selectVehiclesAdapter = bDTToBePaidFragment.vehicleRecyclerViewAdapter;
        if (selectVehiclesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleRecyclerViewAdapter");
        }
        return selectVehiclesAdapter;
    }

    @NotNull
    public final Gson getGson() {
        Gson gson2 = this.gson;
        if (gson2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gson");
        }
        return gson2;
    }

    public final void setGson(@NotNull Gson gson2) {
        Intrinsics.checkParameterIsNotNull(gson2, "<set-?>");
        this.gson = gson2;
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
    public final ToBePaidViewModel getViewModel() {
        ToBePaidViewModel toBePaidViewModel = this.viewModel;
        if (toBePaidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return toBePaidViewModel;
    }

    public final void setViewModel(@NotNull ToBePaidViewModel toBePaidViewModel) {
        Intrinsics.checkParameterIsNotNull(toBePaidViewModel, "<set-?>");
        this.viewModel = toBePaidViewModel;
    }

    @NotNull
    public final PagedList<PaymentDue> getVehicleList() {
        PagedList<PaymentDue> pagedList = this.vehicleList;
        if (pagedList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleList");
        }
        return pagedList;
    }

    public final void setVehicleList(@NotNull PagedList<PaymentDue> pagedList) {
        Intrinsics.checkParameterIsNotNull(pagedList, "<set-?>");
        this.vehicleList = pagedList;
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
    public final View getViewSaleList() {
        return this.viewSaleList;
    }

    public final void setViewSaleList(@Nullable View view) {
        this.viewSaleList = view;
    }

    public final boolean isFirstTime() {
        return this.isFirstTime;
    }

    public final void setFirstTime(boolean z) {
        this.isFirstTime = z;
    }

    public final double getDailyAllowance() {
        return this.dailyAllowance;
    }

    public final void setDailyAllowance(double d) {
        this.dailyAllowance = d;
    }

    public final double getAllowanceUsed() {
        return this.allowanceUsed;
    }

    public final void setAllowanceUsed(double d) {
        this.allowanceUsed = d;
    }

    public final double getCdfFee() {
        return this.cdfFee;
    }

    public final void setCdfFee(double d) {
        this.cdfFee = d;
    }

    public final double getTotalAmountForSelected() {
        return this.totalAmountForSelected;
    }

    public final void setTotalAmountForSelected(double d) {
        this.totalAmountForSelected = d;
    }

    @NotNull
    public final Pair<Double, Double> getAmtIncludingCDF() {
        return this.amtIncludingCDF;
    }

    public final void setAmtIncludingCDF(@NotNull Pair<Double, Double> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "<set-?>");
        this.amtIncludingCDF = pair;
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.bdtPaymentActivity = (BDTPaymentActivity) activity;
            if (context instanceof BDTPaymentActivity) {
                this.bdtPaymentActivity = (BDTPaymentActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragment = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m16of(fragment, factory).get(ToBePaidViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…aidViewModel::class.java)");
        this.viewModel = (ToBePaidViewModel) viewModel2;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        this.isTablet = bDTPaymentActivity.getResources().getBoolean(C2723R.bool.isTabletPhone);
        if (this.viewSaleList == null) {
            ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_select_vehicles, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "mBinding");
            this.viewSaleList = inflate.getRoot();
        }
        View view = this.viewSaleList;
        return this.viewSaleList;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        String str;
        String str2;
        super.onActivityCreated(bundle);
        BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ImageView imageView = (ImageView) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.arrow_left);
        Intrinsics.checkExpressionValueIsNotNull(imageView, "bdtPaymentActivity.arrow_left");
        imageView.setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity2 = this.bdtPaymentActivity;
        if (bDTPaymentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ImageView imageView2 = (ImageView) bDTPaymentActivity2._$_findCachedViewById(C2723R.C2726id.arrow_right);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "bdtPaymentActivity.arrow_right");
        imageView2.setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity3 = this.bdtPaymentActivity;
        if (bDTPaymentActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        RelativeLayout relativeLayout = (RelativeLayout) bDTPaymentActivity3._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "bdtPaymentActivity.toolbar_relativelayout");
        relativeLayout.setGravity(GravityCompat.START);
        BDTPaymentActivity bDTPaymentActivity4 = this.bdtPaymentActivity;
        if (bDTPaymentActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) bDTPaymentActivity4._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "bdtPaymentActivity.toolbar_relativelayout");
        relativeLayout2.setGravity(3);
        if (this.totalItemCount > 0) {
            BDTPaymentActivity bDTPaymentActivity5 = this.bdtPaymentActivity;
            if (bDTPaymentActivity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
            }
            TextView toolbar_title = bDTPaymentActivity5.getToolbar_title();
            toolbar_title.setText(getResources().getString(C2723R.string.lbl_to_be_paid) + " (" + this.totalItemCount + ')');
        } else {
            BDTPaymentActivity bDTPaymentActivity6 = this.bdtPaymentActivity;
            if (bDTPaymentActivity6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
            }
            bDTPaymentActivity6.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_to_be_paid));
        }
        BDTPaymentActivity bDTPaymentActivity7 = this.bdtPaymentActivity;
        if (bDTPaymentActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity7.getToolbar_sub_title().setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity8 = this.bdtPaymentActivity;
        if (bDTPaymentActivity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ActionBar supportActionBar = bDTPaymentActivity8.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeButtonEnabled(true);
        }
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString(Constants_MVVM.EXTRA_PAYMENT_METHOD)) == null) {
            str = "ABCD";
        }
        this.paymentMode = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString(Constants_MVVM.EXTRA_TOBPAID_MY_VEHICLES_ONLY)) == null) {
            str2 = "0";
        }
        this.onlyMyItem = str2;
        Bundle arguments3 = getArguments();
        this.payPalAccountDetailID = arguments3 != null ? arguments3.getInt(Constants_MVVM.EXTRA_PAYMENT_PAYPAL_ACCOUNT_DETAIL_ID) : 0;
        BDTPaymentActivity bDTPaymentActivity9 = this.bdtPaymentActivity;
        if (bDTPaymentActivity9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        this.lastSelectedSort = IAASharedPreference.getToBePaidSortSelection(bDTPaymentActivity9);
        BDTUtils bDTUtils = BDTUtils.INSTANCE;
        String str3 = getResources().getStringArray(C2723R.array.to_paid_sort_item_list)[this.lastSelectedSort];
        Intrinsics.checkExpressionValueIsNotNull(str3, "resources.getStringArray…m_list)[lastSelectedSort]");
        this.sortItem = bDTUtils.createToBePaidSortOptions(str3, this.lastSelectedSort, false);
        if (this.isFirstTime) {
            initializeRecycler();
            initializeUI();
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnCheckOut");
            button.setClickable(false);
            Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
            Intrinsics.checkExpressionValueIsNotNull(button2, "btnCheckOut");
            button2.setAlpha(0.5f);
            checkNetworkConnection();
        }
    }

    private final void initializeUI() {
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut)).setOnClickListener(new BDTToBePaidFragment$initializeUI$1(this));
    }

    private final void initializeRecycler() {
        this.isFirstTime = false;
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        this.vehicleRecyclerViewAdapter = new SelectVehiclesAdapter(context, this);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSelectedVehicle);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvSelectedVehicle");
        SelectVehiclesAdapter selectVehiclesAdapter = this.vehicleRecyclerViewAdapter;
        if (selectVehiclesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleRecyclerViewAdapter");
        }
        recyclerView.setAdapter(selectVehiclesAdapter);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSelectedVehicle);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvSelectedVehicle");
        Context context2 = getContext();
        if (context2 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(context2));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSelectedVehicle)).setHasFixedSize(true);
        BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        new DividerItemDecoration(bDTPaymentActivity, 1);
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            showEmptyState(false);
            getToBePaidList();
            return;
        }
        showEmptyState(true);
        displayError(BaseFragment.ErrorType.NO_INTERNET, "");
        InternetUtil.INSTANCE.observe(this, new BDTToBePaidFragment$checkNetworkConnection$1(this));
    }

    /* access modifiers changed from: private */
    public final void getToBePaidList() {
        showLoadingIndicator(true);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        String currentSessionUsername = sessionManager2.getCurrentSessionUsername();
        if (currentSessionUsername == null) {
            Intrinsics.throwNpe();
        }
        objArr[0] = currentSessionUsername;
        SessionManager sessionManager3 = this.sessionManager;
        if (sessionManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        String currentSessionPassword = sessionManager3.getCurrentSessionPassword();
        if (currentSessionPassword == null) {
            Intrinsics.throwNpe();
        }
        objArr[1] = currentSessionPassword;
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        ToBePaidViewModel toBePaidViewModel = this.viewModel;
        if (toBePaidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel.getPayPalInfo(format);
        ToBePaidViewModel toBePaidViewModel2 = this.viewModel;
        if (toBePaidViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String str = this.paymentMode;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paymentMode");
        }
        SortOptionData sortOptionData = this.sortItem;
        if (sortOptionData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortItem");
        }
        String sortKey = sortOptionData.getSortKey();
        SortOptionData sortOptionData2 = this.sortItem;
        if (sortOptionData2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortItem");
        }
        String sortDirection = sortOptionData2.getSortDirection();
        String str2 = this.onlyMyItem;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onlyMyItem");
        }
        toBePaidViewModel2.getPaymentDueList(format, 1, 25, str, sortKey, sortDirection, str2);
        subscribeToViewModel();
    }

    private final void subscribeToViewModel() {
        ToBePaidViewModel toBePaidViewModel = this.viewModel;
        if (toBePaidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        toBePaidViewModel.getGetPayPalInfo().observe(lifecycleOwner, new BDTToBePaidFragment$subscribeToViewModel$1(this));
        ToBePaidViewModel toBePaidViewModel2 = this.viewModel;
        if (toBePaidViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel2.getGetPayPalInfoError().observe(lifecycleOwner, new BDTToBePaidFragment$subscribeToViewModel$2(this));
        ToBePaidViewModel toBePaidViewModel3 = this.viewModel;
        if (toBePaidViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel3.getResultLiveData().observe(lifecycleOwner, new BDTToBePaidFragment$subscribeToViewModel$3(this));
        ToBePaidViewModel toBePaidViewModel4 = this.viewModel;
        if (toBePaidViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel4.getPaymentDueListResponse().observe(lifecycleOwner, new BDTToBePaidFragment$subscribeToViewModel$4(this));
        ToBePaidViewModel toBePaidViewModel5 = this.viewModel;
        if (toBePaidViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel5.getNetworkState().observe(lifecycleOwner, new BDTToBePaidFragment$subscribeToViewModel$5(this));
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbToBePaid);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbToBePaid");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbToBePaid);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbToBePaid");
        progressBar2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void showEmptyState(boolean z) {
        if (z) {
            LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
            Intrinsics.checkExpressionValueIsNotNull(linearLayout, "emptyRecyclerView");
            linearLayout.setVisibility(0);
            return;
        }
        LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.emptyRecyclerView);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "emptyRecyclerView");
        linearLayout2.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final void logIAAError(String str, String str2, String str3, String str4, String str5) {
        LogIAAErrorRequest logIAAErrorRequest = new LogIAAErrorRequest(str, str2, str3, str4, "DeviceType:Android,SDK Version:" + Build.VERSION.SDK_INT + ",App Version Code:1376,Device:" + Build.DEVICE + ",Device Model:" + Build.MODEL, str5);
        ToBePaidViewModel toBePaidViewModel = this.viewModel;
        if (toBePaidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel.logIAAError("application/json", logIAAErrorRequest);
    }

    public void onVehicleSelect(@Nullable PagedList<PaymentDue> pagedList) {
        this.totalAmountForSelected = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        Collection collection = pagedList;
        if (!(collection == null || collection.isEmpty())) {
            this.vehicleList = pagedList;
            int size = collection.size();
            boolean z = false;
            boolean z2 = false;
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                PaymentDue paymentDue = pagedList.get(i2);
                Boolean valueOf = paymentDue != null ? Boolean.valueOf(paymentDue.isSelected()) : null;
                if (valueOf == null) {
                    Intrinsics.throwNpe();
                }
                if (valueOf.booleanValue()) {
                    i++;
                    double d = this.totalAmountForSelected;
                    PaymentDue paymentDue2 = pagedList.get(i2);
                    this.totalAmountForSelected = d + (paymentDue2 != null ? paymentDue2.getTotalDue() : 0.0d);
                    z2 = true;
                } else {
                    z = true;
                }
            }
            if (z) {
                SelectVehiclesAdapter selectVehiclesAdapter = this.vehicleRecyclerViewAdapter;
                if (selectVehiclesAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vehicleRecyclerViewAdapter");
                }
                selectVehiclesAdapter.setAllVehicleSelected(false);
                SelectVehiclesAdapter selectVehiclesAdapter2 = this.vehicleRecyclerViewAdapter;
                if (selectVehiclesAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vehicleRecyclerViewAdapter");
                }
                selectVehiclesAdapter2.notifyItemChanged(0);
            }
            if (!z2) {
                Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
                Intrinsics.checkExpressionValueIsNotNull(button, "btnCheckOut");
                button.setClickable(false);
                Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
                Intrinsics.checkExpressionValueIsNotNull(button2, "btnCheckOut");
                button2.setAlpha(0.5f);
                RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rlTotalInfo);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "rlTotalInfo");
                relativeLayout.setVisibility(8);
            } else if (this.cdfFee == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                resetUI();
                BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
                if (bDTPaymentActivity == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
                }
                String string = getString(C2723R.string.lbl_cdf_zero_issue);
                Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.lbl_cdf_zero_issue)");
                Context_ExtensionKt.showToastLong(bDTPaymentActivity, string);
            } else {
                Button button3 = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
                Intrinsics.checkExpressionValueIsNotNull(button3, "btnCheckOut");
                button3.setClickable(true);
                Button button4 = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
                Intrinsics.checkExpressionValueIsNotNull(button4, "btnCheckOut");
                button4.setAlpha(1.0f);
                RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rlTotalInfo);
                Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "rlTotalInfo");
                relativeLayout2.setVisibility(0);
                TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSelectedVehicle);
                Intrinsics.checkExpressionValueIsNotNull(textView, "tvSelectedVehicle");
                textView.setText(i + ' ' + getResources().getString(C2723R.string.lbl_bdt_credit_card_selected));
                this.amtIncludingCDF = BDTUtils.INSTANCE.getTotalInclusiveOfCDF(this.totalAmountForSelected, this.cdfFee);
                TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvTotalSelectedAmount);
                Intrinsics.checkExpressionValueIsNotNull(textView2, "tvTotalSelectedAmount");
                textView2.setText(UiUtils.formatCurrencyFromString(String.valueOf(this.amtIncludingCDF.getFirst().doubleValue()), true));
                TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvCDFAmount);
                Intrinsics.checkExpressionValueIsNotNull(textView3, "tvCDFAmount");
                textView3.setText(getResources().getString(C2723R.string.lbl_bdt_amount_includes_cash_discount, new Object[]{UiUtils.formatCurrencyFromString(String.valueOf(this.amtIncludingCDF.getSecond().doubleValue()), true)}));
                if (!z) {
                    SelectVehiclesAdapter selectVehiclesAdapter3 = this.vehicleRecyclerViewAdapter;
                    if (selectVehiclesAdapter3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vehicleRecyclerViewAdapter");
                    }
                    selectVehiclesAdapter3.setAllVehicleSelected(true);
                    SelectVehiclesAdapter selectVehiclesAdapter4 = this.vehicleRecyclerViewAdapter;
                    if (selectVehiclesAdapter4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vehicleRecyclerViewAdapter");
                    }
                    selectVehiclesAdapter4.notifyItemChanged(0);
                }
            }
        }
    }

    public void onChangePaymentClick() {
        BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity.finish();
    }

    public void onSortClick() {
        BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        Intent intent = new Intent(bDTPaymentActivity, SortListActivity.class);
        ArrayList arrayList = new ArrayList();
        String[] stringArray = getResources().getStringArray(C2723R.array.to_paid_sort_item_list);
        Intrinsics.checkExpressionValueIsNotNull(stringArray, "resources.getStringArray…y.to_paid_sort_item_list)");
        int length = stringArray.length;
        for (int i = 0; i < length; i++) {
            String str = stringArray[i];
            if (i == this.lastSelectedSort) {
                BDTUtils bDTUtils = BDTUtils.INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(str, HtmlTags.f607S);
                arrayList.add(bDTUtils.createToBePaidSortOptions(str, i, true));
            } else {
                BDTUtils bDTUtils2 = BDTUtils.INSTANCE;
                Intrinsics.checkExpressionValueIsNotNull(str, HtmlTags.f607S);
                arrayList.add(bDTUtils2.createToBePaidSortOptions(str, i, false));
            }
        }
        intent.putParcelableArrayListExtra(Constants_MVVM.EXTRA_SORT_LIST, arrayList);
        intent.putExtra(Constants_MVVM.EXTRA_SORT_LIST_POSTION, this.lastSelectedSort);
        intent.putExtra(Constants_MVVM.EXTRA_SORT_FROM, 15);
        startActivityForResult(intent, 105);
    }

    public void onVehicleClick(@Nullable PaymentDue paymentDue) {
        Object obj;
        Integer oAAuctionItemId;
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        PagedList<PaymentDue> pagedList = this.vehicleList;
        if (pagedList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleList");
        }
        Iterator it = pagedList.iterator();
        String str = "";
        int i = 0;
        int i2 = 0;
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            PaymentDue paymentDue2 = (PaymentDue) next;
            if (paymentDue2.getOAAuctionItemId() != null && ((oAAuctionItemId = paymentDue2.getOAAuctionItemId()) == null || oAAuctionItemId.intValue() != -1)) {
                arrayList.add(String.valueOf(paymentDue2.getOAAuctionItemId().intValue()));
                i++;
                if (paymentDue != null) {
                    obj = paymentDue.getOAAuctionItemId();
                }
                if (Intrinsics.areEqual((Object) String.valueOf(obj), (Object) String.valueOf(paymentDue2.getOAAuctionItemId().intValue()))) {
                    str = String.valueOf(paymentDue2.getOAAuctionItemId().intValue());
                }
            }
            i2 = i3;
        }
        int indexOf = arrayList.indexOf(str);
        bundle.putString(Constants.EXTRA_ITEM_ID, str);
        bundle.putStringArrayList(Constants_MVVM.EXTRA_ITEM_IDS_LIST, arrayList);
        bundle.putString(Constants_MVVM.EXTRA_AUCTION_DATE, "");
        bundle.putString(Constants_MVVM.EXTRA_BRANCH_ID, "");
        bundle.putInt(Constants_MVVM.EXTRA_CURRENT_COUNT, i);
        bundle.putInt(Constants_MVVM.EXTRA_TOTAL_COUNT, i);
        bundle.putInt(Constants_MVVM.EXTRA_ITEM_POSITION, indexOf);
        bundle.putString(Constants_MVVM.EXTRA_FAST_SEARCH_PARAM, paymentDue != null ? paymentDue.getDescription() : null);
        BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        NavController findNavController = Navigation.findNavController(bDTPaymentActivity, C2723R.C2726id.main_nav_host_fragment);
        Intrinsics.checkExpressionValueIsNotNull(findNavController, "Navigation.findNavContro…d.main_nav_host_fragment)");
        findNavController.navigate((int) C2723R.C2726id.action_ACFragment_to_View_Pager_PDFragment, bundle);
        if (i > 1) {
            BDTPaymentActivity bDTPaymentActivity2 = this.bdtPaymentActivity;
            if (bDTPaymentActivity2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
            }
            RelativeLayout relativeLayout = (RelativeLayout) bDTPaymentActivity2._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "bdtPaymentActivity.toolbar_relativelayout");
            relativeLayout.setGravity(GravityCompat.END);
            BDTPaymentActivity bDTPaymentActivity3 = this.bdtPaymentActivity;
            if (bDTPaymentActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
            }
            TextView toolbar_title = bDTPaymentActivity3.getToolbar_title();
            toolbar_title.setText(String.valueOf(indexOf + 1) + " of " + NewDateHelper.INSTANCE.formattedVehicleCount(i));
            BDTPaymentActivity bDTPaymentActivity4 = this.bdtPaymentActivity;
            if (bDTPaymentActivity4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
            }
            bDTPaymentActivity4.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray_darker));
            BDTPaymentActivity bDTPaymentActivity5 = this.bdtPaymentActivity;
            if (bDTPaymentActivity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
            }
            bDTPaymentActivity5.getToolbar_sub_title().setVisibility(8);
            return;
        }
        BDTPaymentActivity bDTPaymentActivity6 = this.bdtPaymentActivity;
        if (bDTPaymentActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        TextView toolbar_title2 = bDTPaymentActivity6.getToolbar_title();
        if (paymentDue != null) {
            obj = paymentDue.getDescription();
        }
        toolbar_title2.setText((CharSequence) obj);
        BDTPaymentActivity bDTPaymentActivity7 = this.bdtPaymentActivity;
        if (bDTPaymentActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity7.getToolbar_sub_title().setVisibility(8);
    }

    public void onVehicleSelectAll(boolean z) {
        this.totalAmountForSelected = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        PagedList<PaymentDue> pagedList = this.vehicleList;
        if (pagedList == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleList");
        }
        int i = 0;
        for (PaymentDue paymentDue : pagedList) {
            if (paymentDue.getEnableRow()) {
                paymentDue.setSelected(z);
                this.totalAmountForSelected += paymentDue != null ? paymentDue.getTotalDue() : 0.0d;
                i++;
            }
        }
        if (!z || i == 0) {
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnCheckOut");
            button.setClickable(false);
            Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
            Intrinsics.checkExpressionValueIsNotNull(button2, "btnCheckOut");
            button2.setAlpha(0.5f);
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rlTotalInfo);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "rlTotalInfo");
            relativeLayout.setVisibility(8);
        } else if (this.cdfFee == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            resetUI();
            BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
            if (bDTPaymentActivity == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
            }
            String string = getString(C2723R.string.lbl_cdf_zero_issue);
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.lbl_cdf_zero_issue)");
            Context_ExtensionKt.showToastLong(bDTPaymentActivity, string);
        } else {
            Button button3 = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
            Intrinsics.checkExpressionValueIsNotNull(button3, "btnCheckOut");
            button3.setClickable(true);
            Button button4 = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
            Intrinsics.checkExpressionValueIsNotNull(button4, "btnCheckOut");
            button4.setAlpha(1.0f);
            RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rlTotalInfo);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "rlTotalInfo");
            relativeLayout2.setVisibility(0);
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSelectedVehicle);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvSelectedVehicle");
            textView.setText(i + ' ' + getResources().getString(C2723R.string.lbl_bdt_credit_card_selected));
            this.amtIncludingCDF = BDTUtils.INSTANCE.getTotalInclusiveOfCDF(this.totalAmountForSelected, this.cdfFee);
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvTotalSelectedAmount);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvTotalSelectedAmount");
            textView2.setText(UiUtils.formatCurrencyFromString(String.valueOf(this.amtIncludingCDF.getFirst().doubleValue()), true));
            TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvCDFAmount);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "tvCDFAmount");
            textView3.setText(getResources().getString(C2723R.string.lbl_bdt_amount_includes_cash_discount, new Object[]{UiUtils.formatCurrencyFromString(String.valueOf(this.amtIncludingCDF.getSecond().doubleValue()), true)}));
        }
        SelectVehiclesAdapter selectVehiclesAdapter = this.vehicleRecyclerViewAdapter;
        if (selectVehiclesAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleRecyclerViewAdapter");
        }
        PagedList<PaymentDue> pagedList2 = this.vehicleList;
        if (pagedList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleList");
        }
        selectVehiclesAdapter.submitList(pagedList2);
        SelectVehiclesAdapter selectVehiclesAdapter2 = this.vehicleRecyclerViewAdapter;
        if (selectVehiclesAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleRecyclerViewAdapter");
        }
        selectVehiclesAdapter2.notifyDataSetChanged();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSelectedVehicle);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvSelectedVehicle");
        SelectVehiclesAdapter selectVehiclesAdapter3 = this.vehicleRecyclerViewAdapter;
        if (selectVehiclesAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vehicleRecyclerViewAdapter");
        }
        recyclerView.setAdapter(selectVehiclesAdapter3);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        r3 = r4.getExtras();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r2, int r3, @org.jetbrains.annotations.Nullable android.content.Intent r4) {
        /*
            r1 = this;
            super.onActivityResult(r2, r3, r4)
            r0 = 105(0x69, float:1.47E-43)
            if (r2 == r0) goto L_0x0008
            goto L_0x0041
        L_0x0008:
            r2 = -1
            if (r3 != r2) goto L_0x0041
            r2 = 0
            if (r4 == 0) goto L_0x001d
            android.os.Bundle r3 = r4.getExtras()
            if (r3 == 0) goto L_0x001d
            java.lang.String r0 = "search_selected_sort"
            android.os.Parcelable r3 = r3.getParcelable(r0)
            com.iaai.android.bdt.model.sort.SortOptionData r3 = (com.iaai.android.bdt.model.sort.SortOptionData) r3
            goto L_0x001e
        L_0x001d:
            r3 = r2
        L_0x001e:
            if (r3 == 0) goto L_0x0039
            r1.sortItem = r3
            if (r4 == 0) goto L_0x002f
            r2 = 0
            java.lang.String r3 = "search_selected_sort_position"
            int r2 = r4.getIntExtra(r3, r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x002f:
            int r2 = r2.intValue()
            r1.lastSelectedSort = r2
            r1.checkNetworkConnection()
            goto L_0x0041
        L_0x0039:
            kotlin.TypeCastException r2 = new kotlin.TypeCastException
            java.lang.String r3 = "null cannot be cast to non-null type com.iaai.android.bdt.model.sort.SortOptionData"
            r2.<init>(r3)
            throw r2
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.myAccount.toBePaid.BDTToBePaidFragment.onActivityResult(int, int, android.content.Intent):void");
    }

    /* access modifiers changed from: private */
    public final void resetUI() {
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rlTotalInfo);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "rlTotalInfo");
        relativeLayout.setVisibility(8);
        Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
        Intrinsics.checkExpressionValueIsNotNull(button, "btnCheckOut");
        button.setClickable(false);
        Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnCheckOut);
        Intrinsics.checkExpressionValueIsNotNull(button2, "btnCheckOut");
        button2.setAlpha(0.5f);
    }

    public void onResume() {
        super.onResume();
        BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        RelativeLayout relativeLayout = (RelativeLayout) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "bdtPaymentActivity.toolbar_relativelayout");
        relativeLayout.setVisibility(0);
        BDTPaymentActivity bDTPaymentActivity2 = this.bdtPaymentActivity;
        if (bDTPaymentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ActionBar supportActionBar = bDTPaymentActivity2.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        BDTPaymentActivity bDTPaymentActivity3 = this.bdtPaymentActivity;
        if (bDTPaymentActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ActionBar supportActionBar2 = bDTPaymentActivity3.getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setHomeButtonEnabled(true);
        }
        BDTPaymentActivity bDTPaymentActivity4 = this.bdtPaymentActivity;
        if (bDTPaymentActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) bDTPaymentActivity4._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "bdtPaymentActivity.prebid_title_layout");
        constraintLayout.setVisibility(8);
        if (this.totalItemCount > 0) {
            BDTPaymentActivity bDTPaymentActivity5 = this.bdtPaymentActivity;
            if (bDTPaymentActivity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
            }
            TextView toolbar_title = bDTPaymentActivity5.getToolbar_title();
            toolbar_title.setText(getResources().getString(C2723R.string.lbl_to_be_paid) + " (" + this.totalItemCount + ')');
        } else {
            BDTPaymentActivity bDTPaymentActivity6 = this.bdtPaymentActivity;
            if (bDTPaymentActivity6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
            }
            bDTPaymentActivity6.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_to_be_paid));
        }
        BDTPaymentActivity bDTPaymentActivity7 = this.bdtPaymentActivity;
        if (bDTPaymentActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity7.getToolbar_sub_title().setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity8 = this.bdtPaymentActivity;
        if (bDTPaymentActivity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity8.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_black));
        BDTPaymentActivity bDTPaymentActivity9 = this.bdtPaymentActivity;
        if (bDTPaymentActivity9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity9.getIvStockShare().setVisibility(8);
    }

    /* access modifiers changed from: private */
    public final boolean isSaleDocCheckRequired(List<PaymentDue> list) {
        for (PaymentDue salvageSaleId : list) {
            if (salvageSaleId.getSalvageSaleId() != 0) {
                return true;
            }
        }
        return false;
    }
}
