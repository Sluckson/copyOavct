package com.iaai.android.bdt.feature.myAccount.toBePaid;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.iaai.android.BuildConfig;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingEnum;
import com.iaai.android.bdt.model.logIAAError.LogIAAErrorRequest;
import com.iaai.android.bdt.model.toBePaid.PayPalPaymentRequest;
import com.iaai.android.bdt.model.toBePaid.PaymentMethodInformation;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import com.iaai.android.old.models.ToBePaidBranchFilter;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.constants.ToBePaidSortOptions;
import com.iaai.android.old.utils.p016ui.UiUtils;
import dagger.android.AndroidInjection;
import java.io.Serializable;
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

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u00109\u001a\u00020:H\u0002J\u0018\u0010;\u001a\u0012\u0012\u0004\u0012\u00020\u001d0<j\b\u0012\u0004\u0012\u00020\u001d`=H\u0002J\b\u0010>\u001a\u00020:H\u0002J\b\u0010?\u001a\u00020:H\u0002J\b\u0010@\u001a\u00020\u0004H\u0002J\b\u0010A\u001a\u00020:H\u0002J\b\u0010B\u001a\u00020\u001bH\u0002J\b\u0010C\u001a\u00020\u001bH\u0002J\b\u0010D\u001a\u00020:H\u0002J\b\u0010E\u001a\u00020:H\u0002J\b\u0010F\u001a\u00020:H\u0002J\b\u0010G\u001a\u00020:H\u0002J2\u0010H\u001a\u00020:2\b\u0010I\u001a\u0004\u0018\u00010\u00042\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\u00042\u0006\u0010M\u001a\u00020\u0004H\u0002J\"\u0010N\u001a\u00020:2\u0006\u0010O\u001a\u00020\u00172\u0006\u0010P\u001a\u00020\u00172\b\u0010Q\u001a\u0004\u0018\u00010RH\u0014J\u0012\u0010S\u001a\u00020:2\b\u0010T\u001a\u0004\u0018\u00010UH\u0014J\u0010\u0010V\u001a\u00020\u00102\u0006\u0010W\u001a\u00020XH\u0016J\b\u0010Y\u001a\u00020:H\u0014J\u0010\u0010Z\u001a\u00020:2\u0006\u0010[\u001a\u00020\u0010H\u0002J\b\u0010\\\u001a\u00020:H\u0002J\b\u0010]\u001a\u00020:H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u00020.X.¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u0002048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006^"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentMethodActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "CONTENT_TYPE", "", "PAYPAL_API_KEY", "afcError", "afcLimit", "bdtPaymentMethodAdapter", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/BDTPaymentMethodAdapter;", "brainTreeToken", "branchSelected", "Lcom/iaai/android/old/models/ToBePaidBranchFilter;", "iPayDailyAllowance", "iPayLimit", "isAFCError", "", "isAfc", "isIpay", "isIpayError", "isMyItemOnlyString", "isPayPal", "payPalAccountDetailID", "", "payPalDailyAllowance", "payPalPaymentNonce", "payPalPaymentRequest", "Lcom/iaai/android/bdt/model/toBePaid/PayPalPaymentRequest;", "selectedPaymentMethod", "Lcom/iaai/android/bdt/model/toBePaid/PaymentMethodInformation;", "selectedSort", "Lcom/iaai/android/old/utils/constants/ToBePaidSortOptions;", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "sharedPrefsHelper", "Lcom/iaai/android/bdt/utils/SharedPrefsHelper;", "getSharedPrefsHelper", "()Lcom/iaai/android/bdt/utils/SharedPrefsHelper;", "setSharedPrefsHelper", "(Lcom/iaai/android/bdt/utils/SharedPrefsHelper;)V", "vehicleCount", "viewModel", "Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/myAccount/toBePaid/ToBePaidViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "createPayPalCustomerID", "", "createPaymentMethodData", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "fetchPayPalDailyAllowance", "fetchPayPalToken", "getAuthString", "getIntentData", "getPayPalCreateCustomerIDRequestBody", "getPayPalTokenRequestBody", "initializeButtonUI", "initializeRecycler", "initializeToolBar", "launchHintScreen", "logIAAError", "userID", "methodName", "request", "response", "httpstatus", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onStop", "showLoadingIndicator", "loading", "subscribeToViewModel", "updateButton", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTPaymentMethodActivity.kt */
public final class BDTPaymentMethodActivity extends BaseActivity {
    private final String CONTENT_TYPE = "application/json";
    private final String PAYPAL_API_KEY = "eHsbhMI5mYM:APA91bEhiEocB5DVIIhPf9iZr6-304k2ddaPayPalTokenResponseTAGdjbPNNESobfMqRG8gVz0x0v5L_WGxCw0meoMjlNu6MY5wR12sCRfOj_rbv2w0VZ0B4W-MlKuPsq1wHC_6ZqzRU2rNrdXgE87lmWk5c";
    private HashMap _$_findViewCache;
    private String afcError = "";
    private String afcLimit = "";
    /* access modifiers changed from: private */
    public BDTPaymentMethodAdapter bdtPaymentMethodAdapter;
    /* access modifiers changed from: private */
    public String brainTreeToken = "";
    /* access modifiers changed from: private */
    public ToBePaidBranchFilter branchSelected;
    private String iPayDailyAllowance = "";
    private String iPayLimit = "";
    private boolean isAFCError;
    private boolean isAfc;
    private boolean isIpay;
    private boolean isIpayError;
    /* access modifiers changed from: private */
    public String isMyItemOnlyString = "";
    /* access modifiers changed from: private */
    public boolean isPayPal;
    /* access modifiers changed from: private */
    public int payPalAccountDetailID;
    /* access modifiers changed from: private */
    public String payPalDailyAllowance = "";
    /* access modifiers changed from: private */
    public String payPalPaymentNonce = "";
    /* access modifiers changed from: private */
    public PayPalPaymentRequest payPalPaymentRequest;
    /* access modifiers changed from: private */
    public PaymentMethodInformation selectedPaymentMethod;
    /* access modifiers changed from: private */
    public ToBePaidSortOptions selectedSort;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    @Inject
    @NotNull
    public SharedPrefsHelper sharedPrefsHelper;
    private int vehicleCount;
    @NotNull
    public ToBePaidViewModel viewModel;
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
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ BDTPaymentMethodAdapter access$getBdtPaymentMethodAdapter$p(BDTPaymentMethodActivity bDTPaymentMethodActivity) {
        BDTPaymentMethodAdapter bDTPaymentMethodAdapter = bDTPaymentMethodActivity.bdtPaymentMethodAdapter;
        if (bDTPaymentMethodAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentMethodAdapter");
        }
        return bDTPaymentMethodAdapter;
    }

    public static final /* synthetic */ PayPalPaymentRequest access$getPayPalPaymentRequest$p(BDTPaymentMethodActivity bDTPaymentMethodActivity) {
        PayPalPaymentRequest payPalPaymentRequest2 = bDTPaymentMethodActivity.payPalPaymentRequest;
        if (payPalPaymentRequest2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("payPalPaymentRequest");
        }
        return payPalPaymentRequest2;
    }

    public static final /* synthetic */ PaymentMethodInformation access$getSelectedPaymentMethod$p(BDTPaymentMethodActivity bDTPaymentMethodActivity) {
        PaymentMethodInformation paymentMethodInformation = bDTPaymentMethodActivity.selectedPaymentMethod;
        if (paymentMethodInformation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectedPaymentMethod");
        }
        return paymentMethodInformation;
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
    public final SharedPrefsHelper getSharedPrefsHelper() {
        SharedPrefsHelper sharedPrefsHelper2 = this.sharedPrefsHelper;
        if (sharedPrefsHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPrefsHelper");
        }
        return sharedPrefsHelper2;
    }

    public final void setSharedPrefsHelper(@NotNull SharedPrefsHelper sharedPrefsHelper2) {
        Intrinsics.checkParameterIsNotNull(sharedPrefsHelper2, "<set-?>");
        this.sharedPrefsHelper = sharedPrefsHelper2;
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

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AndroidInjection.inject((Activity) this);
        setContentView((int) C2723R.C2728layout.activity_bdt_payment_methods_layout);
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(ToBePaidViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…aidViewModel::class.java)");
        this.viewModel = (ToBePaidViewModel) viewModel2;
        getIntentData();
        initializeToolBar();
        initializeButtonUI();
        fetchPayPalToken();
        subscribeToViewModel();
    }

    private final void initializeToolBar() {
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar));
        getWindow().setSoftInputMode(2);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setHomeButtonEnabled(true);
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setDisplayShowTitleEnabled(true);
        }
        ActionBar supportActionBar4 = getSupportActionBar();
        if (supportActionBar4 != null) {
            supportActionBar4.setHomeAsUpIndicator((int) C2723R.C2725drawable.ic_cross);
        }
        ActionBar supportActionBar5 = getSupportActionBar();
        if (supportActionBar5 != null) {
            supportActionBar5.setTitle((CharSequence) getString(C2723R.string.lbl_payment_methods));
        }
    }

    /* access modifiers changed from: private */
    public final void launchHintScreen() {
        Context context = this;
        Boolean isFirstLaunchForPaymentMethodPayPal = IAASharedPreference.getIsFirstLaunchForPaymentMethodPayPal(context);
        Intrinsics.checkExpressionValueIsNotNull(isFirstLaunchForPaymentMethodPayPal, "isFirstLaunch");
        if (isFirstLaunchForPaymentMethodPayPal.booleanValue()) {
            Context_ExtensionKt.launchOnBoardingScreen(context, OnBoardingEnum.PAYMENT_METHOD_PAYPAL);
        }
    }

    private final void getIntentData() {
        String stringExtra = getIntent().getStringExtra("ipay_balance");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.iPayLimit = stringExtra;
        String stringExtra2 = getIntent().getStringExtra("ipay_allowance");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        this.iPayDailyAllowance = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra("afc_allowance");
        if (stringExtra3 == null) {
            stringExtra3 = "";
        }
        this.afcLimit = stringExtra3;
        String stringExtra4 = getIntent().getStringExtra("is_afc_error_text");
        if (stringExtra4 == null) {
            stringExtra4 = "";
        }
        this.afcError = stringExtra4;
        this.isAFCError = getIntent().getBooleanExtra("is_afc_error", false);
        this.isIpayError = getIntent().getBooleanExtra("is_ipay_error", false);
        this.isAfc = getIntent().getBooleanExtra(Constants_MVVM.EXTRA_IS_AFC, false);
        this.isIpay = getIntent().getBooleanExtra(Constants_MVVM.EXTRA_IS_IPAY, false);
        String stringExtra5 = getIntent().getStringExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY);
        if (stringExtra5 == null) {
            stringExtra5 = "";
        }
        this.isMyItemOnlyString = stringExtra5;
        String stringExtra6 = getIntent().getStringExtra(Constants.MY_VEHICLES_ONLY_ARG);
        if (stringExtra6 == null) {
            stringExtra6 = "";
        }
        this.isMyItemOnlyString = stringExtra6;
        this.vehicleCount = getIntent().getIntExtra(Constants.INTENT_EXTRA_TOBEPAID_VEHICLE_COUNT, this.vehicleCount);
        ToBePaidBranchFilter toBePaidBranchFilter = (ToBePaidBranchFilter) getIntent().getParcelableExtra(Constants.BRANCH_FILTER_SELECTION);
        if (toBePaidBranchFilter == null) {
            toBePaidBranchFilter = null;
        }
        this.branchSelected = toBePaidBranchFilter;
        Serializable serializableExtra = getIntent().getSerializableExtra(Constants.SORTING_OPTION_SELECTION);
        if (serializableExtra != null) {
            ToBePaidSortOptions toBePaidSortOptions = (ToBePaidSortOptions) serializableExtra;
            if (toBePaidSortOptions == null) {
                toBePaidSortOptions = null;
            }
            this.selectedSort = toBePaidSortOptions;
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.old.utils.constants.ToBePaidSortOptions");
    }

    /* access modifiers changed from: private */
    public final void initializeRecycler() {
        Context context = this;
        ((RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvPaymentMethodList)).addItemDecoration(new DividerItemDecoration(context, 1));
        this.bdtPaymentMethodAdapter = new BDTPaymentMethodAdapter(context, new BDTPaymentMethodActivity$initializeRecycler$1(this));
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvPaymentMethodList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvPaymentMethodList");
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvPaymentMethodList);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvPaymentMethodList");
        BDTPaymentMethodAdapter bDTPaymentMethodAdapter = this.bdtPaymentMethodAdapter;
        if (bDTPaymentMethodAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentMethodAdapter");
        }
        recyclerView2.setAdapter(bDTPaymentMethodAdapter);
        BDTPaymentMethodAdapter bDTPaymentMethodAdapter2 = this.bdtPaymentMethodAdapter;
        if (bDTPaymentMethodAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtPaymentMethodAdapter");
        }
        bDTPaymentMethodAdapter2.setData(createPaymentMethodData());
    }

    private final void initializeButtonUI() {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvApplyPaymentMethod);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvApplyPaymentMethod");
        textView.setClickable(false);
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvApplyPaymentMethod);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvApplyPaymentMethod");
        textView2.setAlpha(0.5f);
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvApplyPaymentMethod)).setOnClickListener(new BDTPaymentMethodActivity$initializeButtonUI$1(this));
    }

    /* access modifiers changed from: private */
    public final void updateButton() {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvApplyPaymentMethod);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvApplyPaymentMethod");
        textView.setClickable(true);
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvApplyPaymentMethod);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvApplyPaymentMethod");
        textView2.setAlpha(1.0f);
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    /* access modifiers changed from: private */
    public final ArrayList<PaymentMethodInformation> createPaymentMethodData() {
        String str;
        boolean z;
        String str2;
        ArrayList<PaymentMethodInformation> arrayList = new ArrayList<>();
        if (this.isIpay) {
            String string = getString(C2723R.string.lbl_bdt_ipay_title);
            if (this.isIpayError) {
                str2 = "Error In IPay";
            } else {
                str2 = "";
            }
            Constants_MVVM.PaymentMethod paymentMethod = Constants_MVVM.PaymentMethod.ACH;
            Intrinsics.checkExpressionValueIsNotNull(string, "methodName");
            arrayList.add(new PaymentMethodInformation(paymentMethod, string, "IPay Info", getString(C2723R.string.lbl_daily_allowance) + ' ' + this.iPayDailyAllowance, "Account ending info not available", "", str2, false, false, false, false, ""));
        }
        if (this.isPayPal) {
            String string2 = getString(C2723R.string.lbl_pay_pal);
            String string3 = getString(C2723R.string.lbl_link_your_paypal_account);
            if (this.payPalPaymentRequest != null) {
                PayPalPaymentRequest payPalPaymentRequest2 = this.payPalPaymentRequest;
                if (payPalPaymentRequest2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("payPalPaymentRequest");
                }
                CharSequence payPalCustomerID = payPalPaymentRequest2.getPayPalCustomerID();
                if (!(payPalCustomerID == null || payPalCustomerID.length() == 0)) {
                    string3 = "";
                }
            }
            if (this.payPalPaymentNonce.length() > 0) {
                SharedPrefsHelper sharedPrefsHelper2 = this.sharedPrefsHelper;
                if (sharedPrefsHelper2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPrefsHelper");
                }
                sharedPrefsHelper2.put(Constants_MVVM.KEY_LAST_USED_PAYMENT_METHOD, Constants_MVVM.PaymentMethod.PAY_PAL.getValue());
                z = true;
            } else {
                z = false;
            }
            String formatCurrencyFromString = UiUtils.formatCurrencyFromString(this.payPalDailyAllowance, true);
            Constants_MVVM.PaymentMethod paymentMethod2 = Constants_MVVM.PaymentMethod.PAY_PAL;
            Intrinsics.checkExpressionValueIsNotNull(string2, "methodNamePaypal");
            Intrinsics.checkExpressionValueIsNotNull(string3, "linkPaymentmethodText");
            PaymentMethodInformation paymentMethodInformation = r11;
            PaymentMethodInformation paymentMethodInformation2 = new PaymentMethodInformation(paymentMethod2, string2, "PayPal Info", getString(C2723R.string.lbl_daily_allowance) + ' ' + formatCurrencyFromString, "", "", "", false, z, false, false, string3);
            arrayList.add(paymentMethodInformation);
        }
        if (this.isAfc) {
            String string4 = getString(C2723R.string.lbl_bdt_afc_title);
            if (this.isAFCError) {
                str = this.afcError;
            } else {
                str = "";
            }
            Constants_MVVM.PaymentMethod paymentMethod3 = Constants_MVVM.PaymentMethod.AFC;
            Intrinsics.checkExpressionValueIsNotNull(string4, "methodName");
            String string5 = getString(C2723R.string.lbl_bdt_title_standrad_slavage);
            Intrinsics.checkExpressionValueIsNotNull(string5, "getString(R.string.lbl_bdt_title_standrad_slavage)");
            String string6 = getString(C2723R.string.lbl_bdt_title_afc_buy_go_short);
            Intrinsics.checkExpressionValueIsNotNull(string6, "getString(R.string.lbl_bdt_title_afc_buy_go_short)");
            arrayList.add(new PaymentMethodInformation(paymentMethod3, string4, "AFC Info", getString(C2723R.string.lbl_daily_allowance) + ' ' + this.afcLimit, string5, string6, str, false, false, false, false, ""));
        }
        SharedPrefsHelper sharedPrefsHelper3 = this.sharedPrefsHelper;
        if (sharedPrefsHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPrefsHelper");
        }
        String str3 = sharedPrefsHelper3.get(Constants_MVVM.KEY_LAST_USED_PAYMENT_METHOD, "");
        if (str3.length() > 0) {
            for (PaymentMethodInformation paymentMethodInformation3 : arrayList) {
                if (Intrinsics.areEqual((Object) paymentMethodInformation3.getPaymentMethodType().getValue(), (Object) str3)) {
                    if (paymentMethodInformation3.getErrorText().length() == 0) {
                        paymentMethodInformation3.setSelected(true);
                        this.selectedPaymentMethod = paymentMethodInformation3;
                        updateButton();
                        this.selectedPaymentMethod = paymentMethodInformation3;
                    }
                }
            }
        }
        if (arrayList.isEmpty()) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvEmptyMessage);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvEmptyMessage");
            textView.setVisibility(0);
        } else {
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvEmptyMessage);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tvEmptyMessage");
            textView2.setVisibility(8);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final void fetchPayPalToken() {
        showLoadingIndicator(true);
        ToBePaidViewModel toBePaidViewModel = this.viewModel;
        if (toBePaidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String authString = getAuthString();
        String deviceId = AppUtils.getDeviceId(this);
        Intrinsics.checkExpressionValueIsNotNull(deviceId, "AppUtils.getDeviceId(this)");
        toBePaidViewModel.getPayPalToken(authString, deviceId, "android", this.PAYPAL_API_KEY, this.CONTENT_TYPE, String.valueOf(BuildConfig.VERSION_CODE), getPayPalTokenRequestBody());
    }

    /* access modifiers changed from: private */
    public final void fetchPayPalDailyAllowance() {
        ToBePaidViewModel toBePaidViewModel = this.viewModel;
        if (toBePaidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel.getPayPalInfo(getAuthString());
    }

    private final void createPayPalCustomerID() {
        showLoadingIndicator(true);
        ToBePaidViewModel toBePaidViewModel = this.viewModel;
        if (toBePaidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String authString = getAuthString();
        String deviceId = AppUtils.getDeviceId(this);
        Intrinsics.checkExpressionValueIsNotNull(deviceId, "AppUtils.getDeviceId(this)");
        toBePaidViewModel.createPayPalCustomer(authString, deviceId, "android", this.PAYPAL_API_KEY, this.CONTENT_TYPE, String.valueOf(BuildConfig.VERSION_CODE), getPayPalCreateCustomerIDRequestBody());
    }

    private final void subscribeToViewModel() {
        ToBePaidViewModel toBePaidViewModel = this.viewModel;
        if (toBePaidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        toBePaidViewModel.getPayPalTokenResponse().observe(lifecycleOwner, new BDTPaymentMethodActivity$subscribeToViewModel$1(this));
        ToBePaidViewModel toBePaidViewModel2 = this.viewModel;
        if (toBePaidViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel2.getPayPalTokenError().observe(lifecycleOwner, new BDTPaymentMethodActivity$subscribeToViewModel$2(this));
        ToBePaidViewModel toBePaidViewModel3 = this.viewModel;
        if (toBePaidViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel3.getPayPalCreateCustomer().observe(lifecycleOwner, new BDTPaymentMethodActivity$subscribeToViewModel$3(this));
        ToBePaidViewModel toBePaidViewModel4 = this.viewModel;
        if (toBePaidViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel4.getPayPalCreateCustomerError().observe(lifecycleOwner, new BDTPaymentMethodActivity$subscribeToViewModel$4(this));
        ToBePaidViewModel toBePaidViewModel5 = this.viewModel;
        if (toBePaidViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel5.getGetPayPalInfo().observe(lifecycleOwner, new BDTPaymentMethodActivity$subscribeToViewModel$5(this));
        ToBePaidViewModel toBePaidViewModel6 = this.viewModel;
        if (toBePaidViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel6.getGetPayPalInfoError().observe(lifecycleOwner, new BDTPaymentMethodActivity$subscribeToViewModel$6(this));
        ToBePaidViewModel toBePaidViewModel7 = this.viewModel;
        if (toBePaidViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel7.getShowLoading().observe(lifecycleOwner, new BDTPaymentMethodActivity$subscribeToViewModel$7(this));
        ToBePaidViewModel toBePaidViewModel8 = this.viewModel;
        if (toBePaidViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel8.getLogIAAErrorResponse().observe(lifecycleOwner, BDTPaymentMethodActivity$subscribeToViewModel$8.INSTANCE);
        ToBePaidViewModel toBePaidViewModel9 = this.viewModel;
        if (toBePaidViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel9.getLogIAAErrorFailure().observe(lifecycleOwner, BDTPaymentMethodActivity$subscribeToViewModel$9.INSTANCE);
    }

    /* access modifiers changed from: private */
    public final void logIAAError(String str, String str2, String str3, String str4, String str5) {
        LogIAAErrorRequest logIAAErrorRequest = new LogIAAErrorRequest(str, str2, str3, str4, "DeviceType:Android,SDK Version:" + Build.VERSION.SDK_INT + ",App Version Code:1376,Device:" + Build.DEVICE + ",Device Model:" + Build.MODEL, str5);
        ToBePaidViewModel toBePaidViewModel = this.viewModel;
        if (toBePaidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel.logIAAError(this.CONTENT_TYPE, logIAAErrorRequest);
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

    /* access modifiers changed from: private */
    public final PayPalPaymentRequest getPayPalTokenRequestBody() {
        return new PayPalPaymentRequest((String) null, (String) null, (String) null, (Double) null);
    }

    /* access modifiers changed from: private */
    public final PayPalPaymentRequest getPayPalCreateCustomerIDRequestBody() {
        return new PayPalPaymentRequest("", "", this.payPalPaymentNonce, Double.valueOf(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE));
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbPaymentMethodSelection);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbPaymentMethodSelection");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbPaymentMethodSelection);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbPaymentMethodSelection");
        progressBar2.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        ToBePaidViewModel toBePaidViewModel = this.viewModel;
        if (toBePaidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        toBePaidViewModel.disposeElements();
    }

    /* JADX WARNING: type inference failed for: r3v13, types: [java.io.Serializable] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r3, int r4, @org.jetbrains.annotations.Nullable android.content.Intent r5) {
        /*
            r2 = this;
            super.onActivityResult(r3, r4, r5)
            int r0 = com.google.zxing.integration.android.IntentIntegrator.REQUEST_CODE
            r1 = -1
            if (r3 != r0) goto L_0x0053
            r3 = 0
            if (r4 != r1) goto L_0x002c
            if (r5 == 0) goto L_0x0015
            java.lang.String r3 = "com.braintreepayments.api.dropin.EXTRA_DROP_IN_RESULT"
            android.os.Parcelable r3 = r5.getParcelableExtra(r3)
            com.braintreepayments.api.dropin.DropInResult r3 = (com.braintreepayments.api.dropin.DropInResult) r3
        L_0x0015:
            if (r3 == 0) goto L_0x0024
            com.braintreepayments.api.models.PaymentMethodNonce r3 = r3.getPaymentMethodNonce()
            if (r3 == 0) goto L_0x0024
            java.lang.String r3 = r3.getNonce()
            if (r3 == 0) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            java.lang.String r3 = ""
        L_0x0026:
            r2.payPalPaymentNonce = r3
            r2.createPayPalCustomerID()
            goto L_0x0073
        L_0x002c:
            if (r4 == 0) goto L_0x0073
            if (r5 == 0) goto L_0x0036
            java.lang.String r3 = "com.braintreepayments.api.dropin.EXTRA_ERROR"
            java.io.Serializable r3 = r5.getSerializableExtra(r3)
        L_0x0036:
            if (r3 == 0) goto L_0x004b
            java.lang.Exception r3 = (java.lang.Exception) r3
            if (r3 == 0) goto L_0x0043
            java.lang.String r3 = r3.getMessage()
            if (r3 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            java.lang.String r3 = "Error in PayPal DropIn UI"
        L_0x0045:
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            com.iaai.android.bdt.extensions.Context_ExtensionKt.showToast(r2, r3)
            goto L_0x0073
        L_0x004b:
            kotlin.TypeCastException r3 = new kotlin.TypeCastException
            java.lang.String r4 = "null cannot be cast to non-null type kotlin.Exception /* = java.lang.Exception */"
            r3.<init>(r4)
            throw r3
        L_0x0053:
            r0 = 105(0x69, float:1.47E-43)
            if (r3 != r0) goto L_0x0073
            if (r4 != r1) goto L_0x0073
            if (r5 == 0) goto L_0x0069
            r3 = 0
            java.lang.String r4 = "is_from_close_from_confirmation"
            boolean r3 = r5.getBooleanExtra(r4, r3)
            r4 = 1
            if (r3 != r4) goto L_0x0069
            r2.finish()
            goto L_0x0073
        L_0x0069:
            java.lang.String r3 = "TEST"
            java.lang.String r4 = "Daily Allowance update"
            android.util.Log.e(r3, r4)
            r2.fetchPayPalDailyAllowance()
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentMethodActivity.onActivityResult(int, int, android.content.Intent):void");
    }
}
