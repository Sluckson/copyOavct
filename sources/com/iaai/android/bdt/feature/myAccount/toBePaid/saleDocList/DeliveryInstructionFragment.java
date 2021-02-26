package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.BuildConfig;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;
import com.iaai.android.bdt.model.toBePaid.saleDocument.GetSaleDocListRequest;
import com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse.TitleInstructionItem;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.old.utils.AppUtils;
import dagger.android.support.AndroidSupportInjection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u000206H\u0002J\b\u0010<\u001a\u000206H\u0002J\b\u0010=\u001a\u000206H\u0002J\b\u0010>\u001a\u000206H\u0002J\u0012\u0010?\u001a\u0002062\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\"\u0010B\u001a\u0002062\u0006\u0010C\u001a\u00020\u00132\u0006\u0010D\u001a\u00020\u00132\b\u0010E\u001a\u0004\u0018\u00010FH\u0016J\u0010\u0010G\u001a\u0002062\u0006\u0010H\u001a\u00020IH\u0016J\u0012\u0010J\u001a\u0002062\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J&\u0010K\u001a\u0004\u0018\u0001042\u0006\u0010L\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u00010O2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\b\u0010P\u001a\u000206H\u0016J\b\u0010Q\u001a\u000206H\u0016J\u0010\u0010R\u001a\u0002062\u0006\u0010S\u001a\u00020\u000eH\u0002J\u0010\u0010T\u001a\u0002062\u0006\u0010U\u001a\u00020\u000eH\u0002J\b\u0010V\u001a\u000206H\u0002J\u0016\u0010W\u001a\u0002062\f\u0010X\u001a\b\u0012\u0004\u0012\u00020%0YH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001a\u0010\u001bR\u001e\u0010\u001d\u001a\u00020\u001e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001e\u0010#\u001a\u0012\u0012\u0004\u0012\u00020%0$j\b\u0012\u0004\u0012\u00020%`&X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u00020(X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010-\u001a\u00020.8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u000104X\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "bdtPaymentActivity", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentActivity;", "cdfFee", "", "getCdfFee", "()D", "cdfFee$delegate", "Lkotlin/Lazy;", "deliveryInstructionAdapter", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionAdapter;", "isFirstTime", "", "()Z", "setFirstTime", "(Z)V", "payPalAccountDetailID", "", "getPayPalAccountDetailID", "()I", "payPalAccountDetailID$delegate", "selectedItemsList", "", "Lcom/iaai/android/bdt/model/toBePaid/paymentDueList/PaymentDue;", "getSelectedItemsList", "()Ljava/util/List;", "selectedItemsList$delegate", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "stockList", "Ljava/util/ArrayList;", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "Lkotlin/collections/ArrayList;", "viewModel", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/saleDocList/DeliveryInstructionViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "viewSaleList", "Landroid/view/View;", "checkNetworkConnection", "", "getAuthString", "", "getRequestBody", "Lcom/iaai/android/bdt/model/toBePaid/saleDocument/GetSaleDocListRequest;", "getSaleDocList", "initializeRecycler", "initializeToolbar", "initializeUI", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "onStop", "showEmptyState", "isShowEmptyState", "showLoadingIndicator", "loading", "subscribeToViewModel", "updateUI", "titleInstructionItemList", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryInstructionFragment.kt */
public final class DeliveryInstructionFragment extends BaseFragment {
    static final /* synthetic */ KProperty[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeliveryInstructionFragment.class), "selectedItemsList", "getSelectedItemsList()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeliveryInstructionFragment.class), "cdfFee", "getCdfFee()D")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(DeliveryInstructionFragment.class), "payPalAccountDetailID", "getPayPalAccountDetailID()I"))};
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public BDTPaymentActivity bdtPaymentActivity;
    private final Lazy cdfFee$delegate = LazyKt.lazy(new DeliveryInstructionFragment$cdfFee$2(this));
    /* access modifiers changed from: private */
    public DeliveryInstructionAdapter deliveryInstructionAdapter;
    private boolean isFirstTime = true;
    private final Lazy payPalAccountDetailID$delegate = LazyKt.lazy(new DeliveryInstructionFragment$payPalAccountDetailID$2(this));
    private final Lazy selectedItemsList$delegate = LazyKt.lazy(new DeliveryInstructionFragment$selectedItemsList$2(this));
    @Inject
    @NotNull
    public SessionManager sessionManager;
    /* access modifiers changed from: private */
    public ArrayList<TitleInstructionItem> stockList = new ArrayList<>();
    @NotNull
    public DeliveryInstructionViewModel viewModel;
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

    /* access modifiers changed from: private */
    public final int getPayPalAccountDetailID() {
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

    public static final /* synthetic */ BDTPaymentActivity access$getBdtPaymentActivity$p(DeliveryInstructionFragment deliveryInstructionFragment) {
        BDTPaymentActivity bDTPaymentActivity = deliveryInstructionFragment.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        return bDTPaymentActivity;
    }

    public static final /* synthetic */ DeliveryInstructionAdapter access$getDeliveryInstructionAdapter$p(DeliveryInstructionFragment deliveryInstructionFragment) {
        DeliveryInstructionAdapter deliveryInstructionAdapter2 = deliveryInstructionFragment.deliveryInstructionAdapter;
        if (deliveryInstructionAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryInstructionAdapter");
        }
        return deliveryInstructionAdapter2;
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
    public final DeliveryInstructionViewModel getViewModel() {
        DeliveryInstructionViewModel deliveryInstructionViewModel = this.viewModel;
        if (deliveryInstructionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return deliveryInstructionViewModel;
    }

    public final void setViewModel(@NotNull DeliveryInstructionViewModel deliveryInstructionViewModel) {
        Intrinsics.checkParameterIsNotNull(deliveryInstructionViewModel, "<set-?>");
        this.viewModel = deliveryInstructionViewModel;
    }

    public final boolean isFirstTime() {
        return this.isFirstTime;
    }

    public final void setFirstTime(boolean z) {
        this.isFirstTime = z;
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
        ViewModel viewModel2 = ViewModelProviders.m16of(fragment, factory).get(DeliveryInstructionViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…ionViewModel::class.java)");
        this.viewModel = (DeliveryInstructionViewModel) viewModel2;
        subscribeToViewModel();
    }

    public void onStop() {
        super.onStop();
        DeliveryInstructionViewModel deliveryInstructionViewModel = this.viewModel;
        if (deliveryInstructionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryInstructionViewModel.disposeElements();
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        if (this.viewSaleList == null) {
            ViewDataBinding inflate = DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_delivery_instruction, viewGroup, false);
            Intrinsics.checkExpressionValueIsNotNull(inflate, "mBinding");
            this.viewSaleList = inflate.getRoot();
        }
        return this.viewSaleList;
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        initializeToolbar();
        if (this.isFirstTime) {
            initializeRecycler();
            initializeUI();
            checkNetworkConnection();
        }
    }

    private final void initializeToolbar() {
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
        BDTPaymentActivity bDTPaymentActivity5 = this.bdtPaymentActivity;
        if (bDTPaymentActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity5.getToolbar_title().setText(getResources().getString(C2723R.string.lbl_set_delivery_instructions));
        BDTPaymentActivity bDTPaymentActivity6 = this.bdtPaymentActivity;
        if (bDTPaymentActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity6.getToolbar_sub_title().setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity7 = this.bdtPaymentActivity;
        if (bDTPaymentActivity7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ActionBar supportActionBar = bDTPaymentActivity7.getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setHomeButtonEnabled(true);
        }
        BDTPaymentActivity bDTPaymentActivity8 = this.bdtPaymentActivity;
        if (bDTPaymentActivity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        RelativeLayout relativeLayout3 = (RelativeLayout) bDTPaymentActivity8._$_findCachedViewById(C2723R.C2726id.toolbar_relativelayout);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout3, "bdtPaymentActivity.toolbar_relativelayout");
        relativeLayout3.setVisibility(0);
        BDTPaymentActivity bDTPaymentActivity9 = this.bdtPaymentActivity;
        if (bDTPaymentActivity9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ActionBar supportActionBar2 = bDTPaymentActivity9.getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayHomeAsUpEnabled(true);
        }
        BDTPaymentActivity bDTPaymentActivity10 = this.bdtPaymentActivity;
        if (bDTPaymentActivity10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) bDTPaymentActivity10._$_findCachedViewById(C2723R.C2726id.prebid_title_layout);
        Intrinsics.checkExpressionValueIsNotNull(constraintLayout, "bdtPaymentActivity.prebid_title_layout");
        constraintLayout.setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity11 = this.bdtPaymentActivity;
        if (bDTPaymentActivity11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity11.getToolbar_sub_title().setVisibility(8);
        BDTPaymentActivity bDTPaymentActivity12 = this.bdtPaymentActivity;
        if (bDTPaymentActivity12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity12.getToolbar_title().setTextColor(getResources().getColor(C2723R.C2724color.bdt_black));
        BDTPaymentActivity bDTPaymentActivity13 = this.bdtPaymentActivity;
        if (bDTPaymentActivity13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        bDTPaymentActivity13.getIvStockShare().setVisibility(8);
    }

    private final void initializeUI() {
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnReviewPayment)).setOnClickListener(new DeliveryInstructionFragment$initializeUI$1(this));
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnSetDelivery)).setOnClickListener(new DeliveryInstructionFragment$initializeUI$2(this));
        Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnSetDelivery);
        Intrinsics.checkExpressionValueIsNotNull(button, "btnSetDelivery");
        button.setClickable(false);
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnSetDelivery)).setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray));
        Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSetDelivery);
        Intrinsics.checkExpressionValueIsNotNull(button2, "btnSetDelivery");
        button2.setBackground(getResources().getDrawable(C2723R.C2725drawable.rectangle_red_border_disabled));
    }

    private final void initializeRecycler() {
        this.isFirstTime = false;
        Context context = getContext();
        if (context == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(context, "context!!");
        this.deliveryInstructionAdapter = new DeliveryInstructionAdapter(context, new DeliveryInstructionFragment$initializeRecycler$1(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvStockList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvStockList");
        DeliveryInstructionAdapter deliveryInstructionAdapter2 = this.deliveryInstructionAdapter;
        if (deliveryInstructionAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryInstructionAdapter");
        }
        recyclerView.setAdapter(deliveryInstructionAdapter2);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvStockList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvStockList");
        Context context2 = getContext();
        if (context2 == null) {
            Intrinsics.throwNpe();
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(context2));
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvStockList)).setHasFixedSize(true);
    }

    /* access modifiers changed from: private */
    public final void getSaleDocList() {
        showLoadingIndicator(true);
        DeliveryInstructionViewModel deliveryInstructionViewModel = this.viewModel;
        if (deliveryInstructionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String authString = getAuthString();
        BDTPaymentActivity bDTPaymentActivity = this.bdtPaymentActivity;
        if (bDTPaymentActivity == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentActivity");
        }
        String deviceId = AppUtils.getDeviceId(bDTPaymentActivity);
        Intrinsics.checkExpressionValueIsNotNull(deviceId, "AppUtils.getDeviceId(bdtPaymentActivity)");
        deliveryInstructionViewModel.getSaleDocList(authString, deviceId, "android", String.valueOf(BuildConfig.VERSION_CODE), getRequestBody());
    }

    private final String getAuthString() {
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

    private final void subscribeToViewModel() {
        DeliveryInstructionViewModel deliveryInstructionViewModel = this.viewModel;
        if (deliveryInstructionViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        deliveryInstructionViewModel.getGetSaleDocListResponse().observe(lifecycleOwner, new DeliveryInstructionFragment$subscribeToViewModel$1(this));
        DeliveryInstructionViewModel deliveryInstructionViewModel2 = this.viewModel;
        if (deliveryInstructionViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        deliveryInstructionViewModel2.getGetSaleDocListGroupError().observe(lifecycleOwner, new DeliveryInstructionFragment$subscribeToViewModel$2(this));
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbGetDeliveryMethod);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbGetDeliveryMethod");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbGetDeliveryMethod);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbGetDeliveryMethod");
        progressBar2.setVisibility(8);
    }

    private final GetSaleDocListRequest getRequestBody() {
        ArrayList arrayList = new ArrayList();
        List<PaymentDue> selectedItemsList = getSelectedItemsList();
        if (selectedItemsList != null) {
            for (PaymentDue salvageSaleId : selectedItemsList) {
                arrayList.add(String.valueOf(salvageSaleId.getSalvageSaleId()));
            }
        }
        return new GetSaleDocListRequest(arrayList, "All", 1, arrayList.size(), "TitleDeliveryMethodCode", true, 0);
    }

    private final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            showEmptyState(false);
            getSaleDocList();
            return;
        }
        showEmptyState(true);
        displayError(BaseFragment.ErrorType.NO_INTERNET, "");
        InternetUtil.INSTANCE.observe(this, new DeliveryInstructionFragment$checkNetworkConnection$1(this));
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
    public final void updateUI(List<TitleInstructionItem> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (TitleInstructionItem titleInstructionItem : new ArrayList(CollectionsKt.sortedWith(list, new DeliveryInstructionFragment$updateUI$$inlined$compareBy$1()))) {
            if (titleInstructionItem.getTitleDeliveryMethodCode() == null) {
                arrayList2.add(titleInstructionItem);
            } else {
                arrayList.add(titleInstructionItem);
            }
        }
        if (arrayList2.isEmpty()) {
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnReviewPayment);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnReviewPayment");
            button.setClickable(true);
            Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnReviewPayment);
            Intrinsics.checkExpressionValueIsNotNull(button2, "btnReviewPayment");
            button2.setAlpha(1.0f);
        } else {
            Button button3 = (Button) _$_findCachedViewById(C2723R.C2726id.btnReviewPayment);
            Intrinsics.checkExpressionValueIsNotNull(button3, "btnReviewPayment");
            button3.setClickable(false);
            Button button4 = (Button) _$_findCachedViewById(C2723R.C2726id.btnReviewPayment);
            Intrinsics.checkExpressionValueIsNotNull(button4, "btnReviewPayment");
            button4.setAlpha(0.5f);
        }
        this.stockList.clear();
        this.stockList.addAll(arrayList);
        this.stockList.addAll(arrayList2);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvStockList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvStockList");
        DeliveryInstructionAdapter deliveryInstructionAdapter2 = this.deliveryInstructionAdapter;
        if (deliveryInstructionAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryInstructionAdapter");
        }
        recyclerView.setAdapter(deliveryInstructionAdapter2);
        DeliveryInstructionAdapter deliveryInstructionAdapter3 = this.deliveryInstructionAdapter;
        if (deliveryInstructionAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryInstructionAdapter");
        }
        deliveryInstructionAdapter3.setDataList(this.stockList);
        DeliveryInstructionAdapter deliveryInstructionAdapter4 = this.deliveryInstructionAdapter;
        if (deliveryInstructionAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryInstructionAdapter");
        }
        deliveryInstructionAdapter4.setAllSelected(false);
        DeliveryInstructionAdapter deliveryInstructionAdapter5 = this.deliveryInstructionAdapter;
        if (deliveryInstructionAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryInstructionAdapter");
        }
        deliveryInstructionAdapter5.notifyItemChanged(0);
        DeliveryInstructionAdapter deliveryInstructionAdapter6 = this.deliveryInstructionAdapter;
        if (deliveryInstructionAdapter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("deliveryInstructionAdapter");
        }
        deliveryInstructionAdapter6.notifyDataSetChanged();
    }

    public void onResume() {
        super.onResume();
        initializeToolbar();
    }

    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 41 && i2 == -1) {
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnSetDelivery);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnSetDelivery");
            button.setClickable(false);
            ((Button) _$_findCachedViewById(C2723R.C2726id.btnSetDelivery)).setTextColor(getResources().getColor(C2723R.C2724color.bdt_gray));
            Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnSetDelivery);
            Intrinsics.checkExpressionValueIsNotNull(button2, "btnSetDelivery");
            button2.setBackground(getResources().getDrawable(C2723R.C2725drawable.rectangle_red_border_disabled));
            checkNetworkConnection();
        }
    }
}
