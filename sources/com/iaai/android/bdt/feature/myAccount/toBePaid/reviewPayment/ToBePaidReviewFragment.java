package com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.gson.Gson;
import com.iaai.android.BuildConfig;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity;
import com.iaai.android.bdt.feature.myAccount.toBePaid.ToBePaidViewModel;
import com.iaai.android.bdt.model.logIAAError.LogIAAErrorRequest;
import com.iaai.android.bdt.model.toBePaid.MakePayPalPaymentRequest;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.VehicleFees;
import com.iaai.android.bdt.utils.BDTUtils;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.p016ui.UiUtils;
import dagger.android.support.AndroidSupportInjection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010?\u001a\u00020@H\u0002J\b\u0010A\u001a\u00020@H\u0002J\b\u0010B\u001a\u00020\u0004H\u0002J%\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010\n2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002¢\u0006\u0002\u0010GJ\b\u0010H\u001a\u00020@H\u0002J\b\u0010I\u001a\u00020@H\u0002J\b\u0010J\u001a\u00020@H\u0002J\b\u0010K\u001a\u00020\u001eH\u0002J2\u0010L\u001a\u00020@2\b\u0010M\u001a\u0004\u0018\u00010\u00042\u0006\u0010N\u001a\u00020\u00042\u0006\u0010O\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u0004H\u0002J\u0018\u0010R\u001a\u00020@2\u0006\u0010S\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020\u0004H\u0002J\b\u0010T\u001a\u00020@H\u0002J\b\u0010U\u001a\u00020@H\u0002J\u0012\u0010V\u001a\u00020@2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\"\u0010Y\u001a\u00020@2\u0006\u0010Z\u001a\u00020\n2\u0006\u0010[\u001a\u00020\n2\b\u0010\\\u001a\u0004\u0018\u00010]H\u0016J\u0010\u0010^\u001a\u00020@2\u0006\u0010_\u001a\u00020`H\u0016J\u0012\u0010a\u001a\u00020@2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J&\u0010b\u001a\u0004\u0018\u00010>2\u0006\u0010c\u001a\u00020d2\b\u0010e\u001a\u0004\u0018\u00010f2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010g\u001a\u00020@H\u0016J\u0010\u0010h\u001a\u00020@2\u0006\u0010i\u001a\u00020\u001eH\u0002J\b\u0010j\u001a\u00020@H\u0002J\b\u0010k\u001a\u00020@H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R*\u0010\u0014\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0015j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016`\u0018X\u000e¢\u0006\u0002\n\u0000RB\u0010\u0019\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00070\u0015j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u0007`\u0018X\u000e¢\u0006\u0002\n\u0000R:\u0010\u001a\u001a.\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u00010\u001bj\u0016\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u0016\u0018\u0001`\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0011\u001a\u0004\b \u0010!R\u000e\u0010#\u001a\u00020$X.¢\u0006\u0002\n\u0000R#\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010&8BX\u0002¢\u0006\f\n\u0004\b)\u0010\u0011\u001a\u0004\b'\u0010(R\u001e\u0010*\u001a\u00020+8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u00101\u001a\u000202X.¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0002088\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u000e¢\u0006\u0002\n\u0000¨\u0006l"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ToBePaidReviewFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "CONTENT_TYPE", "", "PAYPAL_API_KEY", "amtIncludingCDF", "Lkotlin/Pair;", "", "apiCount", "", "bdtPaymentActivity", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentActivity;", "cdfFee", "getCdfFee", "()D", "cdfFee$delegate", "Lkotlin/Lazy;", "counter", "currentBuyerId", "filterListForOtherUsers", "Ljava/util/ArrayList;", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "Lkotlin/collections/ArrayList;", "filterListLBS", "filterMapLBS", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "isAllFailed", "", "payPalAccountDetailID", "getPayPalAccountDetailID", "()I", "payPalAccountDetailID$delegate", "reviewPaymentAdapter", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/reviewPayment/ReviewPaymentAdapter;", "selectedItemsList", "", "getSelectedItemsList", "()Ljava/util/List;", "selectedItemsList$delegate", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "totalAmountDue", "viewModel", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "viewSaleList", "Landroid/view/View;", "getApiCountForLBS", "", "getApiCountForOtherUsers", "getAuthString", "getMakePayPalCheckOutRequestBodyFinal", "Lcom/iaai/android/bdt/model/toBePaid/MakePayPalPaymentRequest;", "subsidiaryBuyerId", "paymentDueList", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/iaai/android/bdt/model/toBePaid/MakePayPalPaymentRequest;", "getTotalAmountDue", "initializeRecycler", "initializeUI", "isAllTransactionFailed", "logIAAError", "userID", "methodName", "request", "response", "httpstatus", "logIAAErrorOnFailure", "responseString", "logIAAPaymentEvents", "makePayPalCheckOut", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStop", "showLoadingIndicator", "loading", "subscribeToViewModel", "updateUI", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidReviewFragment.kt */
public final class ToBePaidReviewFragment extends BaseFragment {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ToBePaidReviewFragment.class), "selectedItemsList", "getSelectedItemsList()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ToBePaidReviewFragment.class), "cdfFee", "getCdfFee()D")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ToBePaidReviewFragment.class), "payPalAccountDetailID", "getPayPalAccountDetailID()I"))};
    /* access modifiers changed from: private */
    public final String CONTENT_TYPE = "application/json";
    /* access modifiers changed from: private */
    public final String PAYPAL_API_KEY = Constants_MVVM.SEARCH_API_KEY;
    private HashMap _$_findViewCache;
    private Pair<Double, Double> amtIncludingCDF;
    /* access modifiers changed from: private */
    public int apiCount;
    /* access modifiers changed from: private */
    public BDTPaymentActivity bdtPaymentActivity;
    private final Lazy cdfFee$delegate = LazyKt.lazy(new ToBePaidReviewFragment$cdfFee$2(this));
    /* access modifiers changed from: private */
    public int counter;
    /* access modifiers changed from: private */
    public int currentBuyerId;
    /* access modifiers changed from: private */
    public ArrayList<List<PaymentDue>> filterListForOtherUsers;
    /* access modifiers changed from: private */
    public ArrayList<Pair<Integer, List<PaymentDue>>> filterListLBS;
    private LinkedHashMap<Integer, List<PaymentDue>> filterMapLBS;
    /* access modifiers changed from: private */
    public boolean isAllFailed;
    private final Lazy payPalAccountDetailID$delegate = LazyKt.lazy(new ToBePaidReviewFragment$payPalAccountDetailID$2(this));
    /* access modifiers changed from: private */
    public ReviewPaymentAdapter reviewPaymentAdapter;
    private final Lazy selectedItemsList$delegate = LazyKt.lazy(new ToBePaidReviewFragment$selectedItemsList$2(this));
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private double totalAmountDue;
    @NotNull
    public ToBePaidViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;
    private View viewSaleList;

    /* access modifiers changed from: private */
    public final double getCdfFee() {
        Lazy lazy = this.cdfFee$delegate;
        KProperty kProperty = $$delegatedProperties[1];
        return ((Number) lazy.getValue()).doubleValue();
    }

    private final int getPayPalAccountDetailID() {
        Lazy lazy = this.payPalAccountDetailID$delegate;
        KProperty kProperty = $$delegatedProperties[2];
        return ((Number) lazy.getValue()).intValue();
    }

    /* access modifiers changed from: private */
    public final List<PaymentDue> getSelectedItemsList() {
        Lazy lazy = this.selectedItemsList$delegate;
        KProperty kProperty = $$delegatedProperties[0];
        return (List) lazy.getValue();
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

    public ToBePaidReviewFragment() {
        Double valueOf = Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
        this.amtIncludingCDF = new Pair<>(valueOf, valueOf);
        this.filterListLBS = new ArrayList<>();
        this.filterListForOtherUsers = new ArrayList<>();
    }

    public static final /* synthetic */ BDTPaymentActivity access$getBdtPaymentActivity$p(ToBePaidReviewFragment toBePaidReviewFragment) {
        BDTPaymentActivity bDTPaymentActivity = toBePaidReviewFragment.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        return bDTPaymentActivity;
    }

    public static final /* synthetic */ ReviewPaymentAdapter access$getReviewPaymentAdapter$p(ToBePaidReviewFragment toBePaidReviewFragment) {
        ReviewPaymentAdapter reviewPaymentAdapter2 = toBePaidReviewFragment.reviewPaymentAdapter;
        if (reviewPaymentAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewPaymentAdapter");
        }
        return reviewPaymentAdapter2;
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
        subscribeToViewModel();
    }

    public void onStop() {
        super.onStop();
        ToBePaidViewModel toBePaidViewModel = this.viewModel;
        if (toBePaidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel.disposeElements();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        if (this.viewSaleList == null) {
            ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_to_be_paid_review, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "mBinding");
            this.viewSaleList = inflate.getRoot();
        }
        return this.viewSaleList;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
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
        relativeLayout.setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity4 = this.bdtPaymentActivity;
        if (bDTPaymentActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity4.getToolbar_sub_title().setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity5 = this.bdtPaymentActivity;
        if (bDTPaymentActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ActionBar supportActionBar = bDTPaymentActivity5.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
        BDTPaymentActivity bDTPaymentActivity6 = this.bdtPaymentActivity;
        if (bDTPaymentActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ActionBar supportActionBar2 = bDTPaymentActivity6.getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setHomeButtonEnabled(false);
        }
        getTotalAmountDue();
        initializeRecycler();
        initializeUI();
    }

    private final void initializeUI() {
        BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        RelativeLayout relativeLayout = (RelativeLayout) bDTPaymentActivity._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "bdtPaymentActivity.toolbar_relativelayout");
        relativeLayout.setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity2 = this.bdtPaymentActivity;
        if (bDTPaymentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ActionBar supportActionBar = bDTPaymentActivity2.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(false);
        }
        BDTPaymentActivity bDTPaymentActivity3 = this.bdtPaymentActivity;
        if (bDTPaymentActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ActionBar supportActionBar2 = bDTPaymentActivity3.getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setHomeButtonEnabled(false);
        }
        BDTPaymentActivity bDTPaymentActivity4 = this.bdtPaymentActivity;
        if (bDTPaymentActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity4.getToolbar().setBackgroundColor(-1);
        BDTPaymentActivity bDTPaymentActivity5 = this.bdtPaymentActivity;
        if (bDTPaymentActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) bDTPaymentActivity5._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "bdtPaymentActivity.prebid_title_layout");
        constraintLayout.setVisibility(0);
        BDTPaymentActivity bDTPaymentActivity6 = this.bdtPaymentActivity;
        if (bDTPaymentActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity6.getIvStockShare().setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity7 = this.bdtPaymentActivity;
        if (bDTPaymentActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        TextView textView = (TextView) bDTPaymentActivity7._$_findCachedViewById(C2723R.C2726id.prebid_page_title);
        Intrinsics.checkExpressionValueIsNotNull(textView, "bdtPaymentActivity.prebid_page_title");
        textView.setText(getResources().getString(C2723R.string.lbl_review_payment));
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnSubmit)).setOnClickListener(new ToBePaidReviewFragment$initializeUI$1(this));
        updateUI();
    }

    private final void initializeRecycler() {
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        this.reviewPaymentAdapter = new ReviewPaymentAdapter(context, new ToBePaidReviewFragment$initializeRecycler$1(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSelectedVehicle);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvSelectedVehicle");
        ReviewPaymentAdapter reviewPaymentAdapter2 = this.reviewPaymentAdapter;
        if (reviewPaymentAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewPaymentAdapter");
        }
        recyclerView.setAdapter(reviewPaymentAdapter2);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSelectedVehicle);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvSelectedVehicle");
        Context context2 = getContext();
        if (context2 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(context2));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvSelectedVehicle)).setHasFixedSize(true);
        ReviewPaymentAdapter reviewPaymentAdapter3 = this.reviewPaymentAdapter;
        if (reviewPaymentAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewPaymentAdapter");
        }
        List<PaymentDue> selectedItemsList = getSelectedItemsList();
        if (selectedItemsList == null) {
            selectedItemsList = CollectionsKt.emptyList();
        }
        reviewPaymentAdapter3.setItemsList(selectedItemsList);
        ReviewPaymentAdapter reviewPaymentAdapter4 = this.reviewPaymentAdapter;
        if (reviewPaymentAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reviewPaymentAdapter");
        }
        reviewPaymentAdapter4.notifyDataSetChanged();
    }

    /* access modifiers changed from: private */
    public final void getTotalAmountDue() {
        this.totalAmountDue = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        List<PaymentDue> selectedItemsList = getSelectedItemsList();
        if (selectedItemsList != null) {
            for (PaymentDue totalDue : selectedItemsList) {
                this.totalAmountDue += totalDue.getTotalDue();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateUI() {
        this.amtIncludingCDF = BDTUtils.INSTANCE.getTotalInclusiveOfCDF(this.totalAmountDue, getCdfFee());
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvAmount);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvAmount");
        textView.setText(UiUtils.formatCurrencyFromString(String.valueOf(this.amtIncludingCDF.getFirst().doubleValue()), true));
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvCount);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvCount");
        Resources resources = getResources();
        Object[] objArr = new Object[1];
        List<PaymentDue> selectedItemsList = getSelectedItemsList();
        objArr[0] = String.valueOf(selectedItemsList != null ? Integer.valueOf(selectedItemsList.size()) : null);
        textView2.setText(resources.getString(C2723R.string.lbl_items_selected, objArr));
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvCDFAmount);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvCDFAmount");
        textView3.setText(getResources().getString(C2723R.string.lbl_bdt_amount_includes_cash_discount, new Object[]{UiUtils.formatCurrencyFromString(String.valueOf(this.amtIncludingCDF.getSecond().doubleValue()), true)}));
    }

    private final void makePayPalCheckOut() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        if (sessionManager2.isCurrentSessionUserlbsParentIndicator()) {
            getApiCountForLBS();
            if (this.apiCount > 0) {
                showLoadingIndicator(true);
                this.currentBuyerId = ((Number) this.filterListLBS.get(0).getFirst()).intValue();
                ToBePaidViewModel toBePaidViewModel = this.viewModel;
                if (toBePaidViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                }
                String authString = getAuthString();
                BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
                if (bDTPaymentActivity == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
                }
                String deviceId = AppUtils.getDeviceId(bDTPaymentActivity);
                Intrinsics.checkExpressionValueIsNotNull(deviceId, "AppUtils.getDeviceId(bdtPaymentActivity)");
                toBePaidViewModel.makePayPalCheckOut(authString, deviceId, "android", this.PAYPAL_API_KEY, this.CONTENT_TYPE, String.valueOf(BuildConfig.VERSION_CODE), getMakePayPalCheckOutRequestBodyFinal((Integer) this.filterListLBS.get(0).getFirst(), (List) this.filterListLBS.get(0).getSecond()));
                return;
            }
            return;
        }
        getApiCountForOtherUsers();
        showLoadingIndicator(true);
        this.currentBuyerId = 0;
        ToBePaidViewModel toBePaidViewModel2 = this.viewModel;
        if (toBePaidViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String authString2 = getAuthString();
        BDTPaymentActivity bDTPaymentActivity2 = this.bdtPaymentActivity;
        if (bDTPaymentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        String deviceId2 = AppUtils.getDeviceId(bDTPaymentActivity2);
        Intrinsics.checkExpressionValueIsNotNull(deviceId2, "AppUtils.getDeviceId(bdtPaymentActivity)");
        String str = this.PAYPAL_API_KEY;
        String str2 = this.CONTENT_TYPE;
        String valueOf = String.valueOf(BuildConfig.VERSION_CODE);
        List<PaymentDue> list = this.filterListForOtherUsers.get(0);
        Intrinsics.checkExpressionValueIsNotNull(list, "filterListForOtherUsers[0]");
        toBePaidViewModel2.makePayPalCheckOut(authString2, deviceId2, "android", str, str2, valueOf, getMakePayPalCheckOutRequestBodyFinal((Integer) null, list));
    }

    /* access modifiers changed from: private */
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
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbToBePaidReview);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbToBePaidReview");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbToBePaidReview);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbToBePaidReview");
        progressBar2.setVisibility(8);
    }

    private final void subscribeToViewModel() {
        ToBePaidViewModel toBePaidViewModel = this.viewModel;
        if (toBePaidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        toBePaidViewModel.getPayPalMakePayment().observe(lifecycleOwner, new ToBePaidReviewFragment$subscribeToViewModel$1(this));
        ToBePaidViewModel toBePaidViewModel2 = this.viewModel;
        if (toBePaidViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel2.getPayPalMakePaymentError().observe(lifecycleOwner, new ToBePaidReviewFragment$subscribeToViewModel$2(this));
        ToBePaidViewModel toBePaidViewModel3 = this.viewModel;
        if (toBePaidViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel3.getShowLoading().observe(lifecycleOwner, new ToBePaidReviewFragment$subscribeToViewModel$3(this));
        ToBePaidViewModel toBePaidViewModel4 = this.viewModel;
        if (toBePaidViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel4.getPayPalMakePaymentSalvageIds().observe(lifecycleOwner, new ToBePaidReviewFragment$subscribeToViewModel$4(this));
    }

    private final void logIAAError(String str, String str2, String str3, String str4, String str5) {
        LogIAAErrorRequest logIAAErrorRequest = new LogIAAErrorRequest(str, str2, str3, str4, "DeviceType:Android,SDK Version:" + Build.VERSION.SDK_INT + ",App Version Code:1376,Device:" + Build.DEVICE + ",Device Model:" + Build.MODEL, str5);
        ToBePaidViewModel toBePaidViewModel = this.viewModel;
        if (toBePaidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel.logIAAError("application/json", logIAAErrorRequest);
    }

    /* access modifiers changed from: private */
    public final void logIAAErrorOnFailure(String str, String str2) {
        String str3;
        try {
            SessionManager sessionManager2 = this.sessionManager;
            if (sessionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            if (sessionManager2.isCurrentSessionUserlbsParentIndicator()) {
                str3 = new Gson().toJson((Object) getMakePayPalCheckOutRequestBodyFinal((Integer) this.filterListLBS.get(this.counter).getFirst(), (List) this.filterListLBS.get(this.counter).getSecond()));
                Intrinsics.checkExpressionValueIsNotNull(str3, "Gson().toJson(getMakePay…ListLBS[counter].second))");
            } else {
                Gson gson = new Gson();
                List<PaymentDue> list = this.filterListForOtherUsers.get(this.counter);
                Intrinsics.checkExpressionValueIsNotNull(list, "filterListForOtherUsers[counter]");
                str3 = gson.toJson((Object) getMakePayPalCheckOutRequestBodyFinal((Integer) null, list));
                Intrinsics.checkExpressionValueIsNotNull(str3, "Gson().toJson(getMakePay…tForOtherUsers[counter]))");
            }
            String str4 = str3;
            SessionManager sessionManager3 = this.sessionManager;
            if (sessionManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            logIAAError(sessionManager3.getCurrentSessionUserId(), "acserviceswebapi/api/makepaypalpayment/", str4, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 40) {
            makePayPalCheckOut();
        }
    }

    /* access modifiers changed from: private */
    public final void logIAAPaymentEvents() {
        Bundle bundle = new Bundle();
        bundle.putDouble(IAAAnalytics.FireBaseKeyNames.VALUE.getId(), this.amtIncludingCDF.getFirst().doubleValue());
        bundle.putString(IAAAnalytics.FireBaseKeyNames.CURRENCY.getId(), IAAAnalytics.FireBaseValueNames.USD.getId());
        bundle.putString(IAAAnalytics.FireBaseKeyNames.SOURCE.getId(), IAAAnalytics.FireBaseValueNames.PAY_PAL.getId());
        Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.PAYMENT.getId() + " :" + bundle);
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        IAAAnalytics.IAAEvents iAAEvents = IAAAnalytics.IAAEvents.PAYMENT;
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        iAAAnalytics.logIAAEvent(iAAEvents, bundle, sessionManager2);
    }

    private final void getApiCountForLBS() {
        Map map;
        List<PaymentDue> selectedItemsList = getSelectedItemsList();
        if (selectedItemsList != null) {
            map = new LinkedHashMap();
            for (Object next : selectedItemsList) {
                Integer valueOf = Integer.valueOf(((PaymentDue) next).getBuyer_ID());
                Object obj = map.get(valueOf);
                if (obj == null) {
                    obj = new ArrayList();
                    map.put(valueOf, obj);
                }
                ((List) obj).add(next);
            }
        } else {
            map = null;
        }
        this.filterMapLBS = new LinkedHashMap<>(map);
        LinkedHashMap<Integer, List<PaymentDue>> linkedHashMap = this.filterMapLBS;
        if (linkedHashMap != null) {
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                int intValue = ((Number) entry.getKey()).intValue();
                ArrayList arrayList = new ArrayList();
                ArrayList<PaymentDue> arrayList2 = new ArrayList<>();
                for (PaymentDue paymentDue : (List) entry.getValue()) {
                    if (paymentDue.getPartial_Payment_Ind()) {
                        arrayList2.add(paymentDue);
                    } else {
                        arrayList.add(paymentDue);
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.filterListLBS.add(new Pair(Integer.valueOf(intValue), arrayList));
                }
                for (PaymentDue paymentDue2 : arrayList2) {
                    this.filterListLBS.add(new Pair(Integer.valueOf(intValue), CollectionsKt.arrayListOf(paymentDue2)));
                }
            }
        }
        this.apiCount = this.filterListLBS.size();
    }

    private final void getApiCountForOtherUsers() {
        ArrayList arrayList = new ArrayList();
        ArrayList<PaymentDue> arrayList2 = new ArrayList<>();
        List<PaymentDue> selectedItemsList = getSelectedItemsList();
        if (selectedItemsList != null) {
            for (PaymentDue paymentDue : selectedItemsList) {
                if (paymentDue.getPartial_Payment_Ind()) {
                    arrayList2.add(paymentDue);
                } else {
                    arrayList.add(paymentDue);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.filterListForOtherUsers.add(arrayList);
        }
        for (PaymentDue paymentDue2 : arrayList2) {
            this.filterListForOtherUsers.add(CollectionsKt.arrayListOf(paymentDue2));
        }
        this.apiCount = this.filterListForOtherUsers.size();
    }

    /* access modifiers changed from: private */
    public final boolean isAllTransactionFailed() {
        List<PaymentDue> selectedItemsList = getSelectedItemsList();
        if (selectedItemsList == null) {
            return true;
        }
        for (PaymentDue isPaymentSuccess : selectedItemsList) {
            if (isPaymentSuccess.isPaymentSuccess()) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final MakePayPalPaymentRequest getMakePayPalCheckOutRequestBodyFinal(Integer num, List<PaymentDue> list) {
        String joinToString$default;
        String joinToString$default2;
        String joinToString$default3;
        Iterator it;
        double d;
        double d2;
        double d3;
        double d4;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it2 = list.iterator();
        double d5 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        while (it2.hasNext()) {
            PaymentDue paymentDue = (PaymentDue) it2.next();
            if (paymentDue.getSalvageId() != 0) {
                double totalDue = paymentDue.getTotalDue();
                List<VehicleFees> vehicleFees = paymentDue.getVehicleFees();
                if (vehicleFees != null) {
                    Iterator it3 = vehicleFees.iterator();
                    while (true) {
                        d4 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        while (true) {
                            if (!it3.hasNext()) {
                                break;
                            }
                            VehicleFees vehicleFees2 = (VehicleFees) it3.next();
                            if (Intrinsics.areEqual((Object) vehicleFees2.getDisplayText(), (Object) "Sales Tax")) {
                                Double amount = vehicleFees2.getAmount();
                                if (amount != null) {
                                    d4 = amount.doubleValue();
                                }
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    d3 = d4;
                } else {
                    d3 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                }
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                arrayList.add(paymentDue.getSalvageId() + '~' + decimalFormat.format(totalDue - d3) + '~' + decimalFormat.format(d3));
            } else if (paymentDue.getSalvageBuyerChargeId() != 0) {
                double totalDue2 = paymentDue.getTotalDue();
                List<VehicleFees> vehicleFees3 = paymentDue.getVehicleFees();
                if (vehicleFees3 != null) {
                    d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    for (VehicleFees vehicleFees4 : vehicleFees3) {
                        if (Intrinsics.areEqual((Object) vehicleFees4.getDisplayText(), (Object) "Sales Tax")) {
                            Double amount2 = vehicleFees4.getAmount();
                            d2 = amount2 != null ? amount2.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        }
                    }
                    Unit unit2 = Unit.INSTANCE;
                } else {
                    d2 = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                }
                DecimalFormat decimalFormat2 = new DecimalFormat("0.00");
                arrayList2.add(paymentDue.getSalvageBuyerChargeId() + '~' + decimalFormat2.format(totalDue2 - d2) + '~' + decimalFormat2.format(d2));
            } else if (paymentDue.getBuyerChargeId() != 0) {
                double totalDue3 = paymentDue.getTotalDue();
                List<VehicleFees> vehicleFees5 = paymentDue.getVehicleFees();
                if (vehicleFees5 != null) {
                    d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                    for (VehicleFees vehicleFees6 : vehicleFees5) {
                        Iterator it4 = it2;
                        if (Intrinsics.areEqual((Object) vehicleFees6.getDisplayText(), (Object) "Sales Tax")) {
                            Double amount3 = vehicleFees6.getAmount();
                            d = amount3 != null ? amount3.doubleValue() : FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                        }
                        it2 = it4;
                    }
                    it = it2;
                    Unit unit3 = Unit.INSTANCE;
                } else {
                    it = it2;
                    d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                }
                DecimalFormat decimalFormat3 = new DecimalFormat("0.00");
                arrayList3.add(paymentDue.getBuyerChargeId() + '~' + decimalFormat3.format(totalDue3 - d) + '~' + decimalFormat3.format(d));
                d5 += paymentDue.getTotalDue();
                it2 = it;
            }
            it = it2;
            d5 += paymentDue.getTotalDue();
            it2 = it;
        }
        String str = null;
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        if (arrayList2.isEmpty()) {
            arrayList2 = null;
        }
        if (arrayList3.isEmpty()) {
            arrayList3 = null;
        }
        Pair<Double, Double> totalInclusiveOfCDF = BDTUtils.INSTANCE.getTotalInclusiveOfCDF(d5, getCdfFee());
        BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity.getPalPaymentRequest().setAmount(totalInclusiveOfCDF.getFirst());
        Double first = totalInclusiveOfCDF.getFirst();
        Double second = totalInclusiveOfCDF.getSecond();
        BDTPaymentActivity bDTPaymentActivity2 = this.bdtPaymentActivity;
        if (bDTPaymentActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        String payPalCustomerID = bDTPaymentActivity2.getPalPaymentRequest().getPayPalCustomerID();
        Double first2 = totalInclusiveOfCDF.getFirst();
        BDTPaymentActivity bDTPaymentActivity3 = this.bdtPaymentActivity;
        if (bDTPaymentActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        String paymentCode = bDTPaymentActivity3.getPalPaymentRequest().getPaymentCode();
        BDTPaymentActivity bDTPaymentActivity4 = this.bdtPaymentActivity;
        if (bDTPaymentActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        String paymentMethodNonce = bDTPaymentActivity4.getPalPaymentRequest().getPaymentMethodNonce();
        String replace = (arrayList3 == null || (joinToString$default3 = CollectionsKt.joinToString$default(arrayList3, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)) == null) ? null : new Regex("\\s+").replace((CharSequence) joinToString$default3, "");
        String replace2 = (arrayList2 == null || (joinToString$default2 = CollectionsKt.joinToString$default(arrayList2, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)) == null) ? null : new Regex("\\s+").replace((CharSequence) joinToString$default2, "");
        if (!(arrayList == null || (joinToString$default = CollectionsKt.joinToString$default(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)) == null)) {
            str = new Regex("\\s+").replace((CharSequence) joinToString$default, "");
        }
        MakePayPalPaymentRequest makePayPalPaymentRequest = new MakePayPalPaymentRequest(first, second, payPalCustomerID, first2, paymentCode, paymentMethodNonce, replace, replace2, str, getPayPalAccountDetailID(), num);
        Log.e("TEST", "PAYMENT REQUEST FINAL: " + new Gson().toJson((Object) makePayPalPaymentRequest));
        return makePayPalPaymentRequest;
    }
}
