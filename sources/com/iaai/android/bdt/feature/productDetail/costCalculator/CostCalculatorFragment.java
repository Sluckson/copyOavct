package com.iaai.android.bdt.feature.productDetail.costCalculator;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity;
import com.iaai.android.bdt.model.productDetail.costCalculator.CostCalculatorResponse;
import com.iaai.android.bdt.model.productDetail.costCalculator.CostList;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.databinding.FragmentCostCalculatorLayoutBinding;
import com.iaai.android.old.utils.IAASharedPreference;
import com.lowagie.text.pdf.PdfBoolean;
import dagger.android.support.AndroidSupportInjection;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0002J\u0012\u0010&\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010)\u001a\u00020$2\u0006\u0010*\u001a\u00020+H\u0016J\u0012\u0010,\u001a\u00020$2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J&\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u00103\u001a\u00020$H\u0016J\u0010\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020\u0013H\u0002J\b\u00106\u001a\u00020$H\u0002J\b\u00107\u001a\u00020$H\u0002J\u0016\u00108\u001a\u00020$2\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:H\u0002J\b\u0010<\u001a\u00020$H\u0002J\b\u0010=\u001a\u00020$H\u0002J\b\u0010>\u001a\u00020$H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006@"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/costCalculator/CostCalculatorFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "TAG", "", "kotlin.jvm.PlatformType", "animFadeIn", "Landroid/view/animation/Animation;", "animFadeOut", "baseActivity", "Lcom/iaai/android/bdt/base/BaseActivity;", "bidAmount", "branchCode", "buyerID", "costCalculatorAdapter", "Lcom/iaai/android/bdt/feature/productDetail/costCalculator/CostCalculatorAdapter;", "dropOffzipCode", "employeeID", "isTransportationQuotesAvailable", "", "itemId", "pickUpzipCode", "salvageID", "", "stockNumber", "userID", "viewModel", "Lcom/iaai/android/bdt/feature/productDetail/costCalculator/CostCalculatorViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "vin", "checkNetworkConnection", "", "costCalculator", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "showLoadingIndicator", "loading", "subscribeToViewModel", "updateBundleDataPoints", "updateCostBreakDownUI", "costList", "", "Lcom/iaai/android/bdt/model/productDetail/costCalculator/CostList;", "updateCostCalculatorLayoutUI", "updateZipCodeUI", "validateEstimateBidAmount", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: CostCalculatorFragment.kt */
public final class CostCalculatorFragment extends BaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SAMPLE = "sample";
    /* access modifiers changed from: private */
    public final String TAG = CostCalculatorFragment.class.getSimpleName();
    private HashMap _$_findViewCache;
    private Animation animFadeIn;
    private Animation animFadeOut;
    /* access modifiers changed from: private */
    public BaseActivity baseActivity;
    /* access modifiers changed from: private */
    public String bidAmount = "";
    private String branchCode = "";
    private String buyerID = "";
    private CostCalculatorAdapter costCalculatorAdapter;
    /* access modifiers changed from: private */
    public String dropOffzipCode = "";
    private String employeeID = "";
    private boolean isTransportationQuotesAvailable;
    /* access modifiers changed from: private */
    public String itemId = "";
    private String pickUpzipCode = "";
    private int salvageID;
    private String stockNumber = "";
    private String userID = "";
    private CostCalculatorViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;
    private String vin = "";

    @JvmStatic
    @NotNull
    public static final CostCalculatorFragment newInstance(@NotNull String str) {
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

    public static final /* synthetic */ BaseActivity access$getBaseActivity$p(CostCalculatorFragment costCalculatorFragment) {
        BaseActivity baseActivity2 = costCalculatorFragment.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        return baseActivity2;
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/costCalculator/CostCalculatorFragment$Companion;", "", "()V", "KEY_SAMPLE", "", "newInstance", "Lcom/iaai/android/bdt/feature/productDetail/costCalculator/CostCalculatorFragment;", "url", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: CostCalculatorFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final CostCalculatorFragment newInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            CostCalculatorFragment costCalculatorFragment = new CostCalculatorFragment();
            Bundle bundle = new Bundle();
            bundle.putString(CostCalculatorFragment.KEY_SAMPLE, str);
            costCalculatorFragment.setArguments(bundle);
            return costCalculatorFragment;
        }
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.baseActivity = (BaseActivity) activity;
            if (context instanceof AuctionSalesListActivity) {
                this.baseActivity = (BaseActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.base.BaseActivity");
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        Fragment fragment = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m16of(fragment, factory).get(CostCalculatorViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…torViewModel::class.java)");
        this.viewModel = (CostCalculatorViewModel) viewModel2;
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        Application application = baseActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
        Context applicationContext = application.getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(applicationContext, "baseActivity!!.application.applicationContext");
        this.costCalculatorAdapter = new CostCalculatorAdapter(applicationContext);
        IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
        String value = IAAAnalytics.IAAScreenName.COST_CALCULATOR.getValue();
        FragmentActivity activity = getActivity();
        if (activity == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
        iAAAnalytics.logScreenName(value, activity, this);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        FragmentCostCalculatorLayoutBinding fragmentCostCalculatorLayoutBinding = (FragmentCostCalculatorLayoutBinding) DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_cost_calculator_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(fragmentCostCalculatorLayoutBinding, "mBinding");
        return fragmentCostCalculatorLayoutBinding.getRoot();
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.cost_cal_pbLoading);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "cost_cal_pbLoading");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.cost_cal_pbLoading);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "cost_cal_pbLoading");
        progressBar2.setVisibility(8);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        updateBundleDataPoints();
        Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnViewEstimate);
        Intrinsics.checkExpressionValueIsNotNull(button, "btnViewEstimate");
        button.setAlpha(0.5f);
        Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.btnGetQuote);
        Intrinsics.checkExpressionValueIsNotNull(button2, "btnGetQuote");
        button2.setAlpha(0.5f);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C2723R.anim.fade_in);
        Intrinsics.checkExpressionValueIsNotNull(loadAnimation, "AnimationUtils.loadAnima…          R.anim.fade_in)");
        this.animFadeIn = loadAnimation;
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), C2723R.anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(loadAnimation2, "AnimationUtils.loadAnima…         R.anim.fade_out)");
        this.animFadeOut = loadAnimation2;
        updateCostCalculatorLayoutUI();
        updateZipCodeUI();
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        Application application = baseActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
        String estimateCostValue = IAASharedPreference.getEstimateCostValue(application.getApplicationContext(), this.itemId);
        Intrinsics.checkExpressionValueIsNotNull(estimateCostValue, "IAASharedPreference.getE…pplicationContext,itemId)");
        this.bidAmount = estimateCostValue;
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity3 == null) {
            Intrinsics.throwNpe();
        }
        Application application2 = baseActivity3.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application2, "baseActivity!!.application");
        String zipCodeValue = IAASharedPreference.getZipCodeValue(application2.getApplicationContext(), this.itemId);
        Intrinsics.checkExpressionValueIsNotNull(zipCodeValue, "IAASharedPreference.getZ…pplicationContext,itemId)");
        this.dropOffzipCode = zipCodeValue;
        if (this.bidAmount.length() > 0) {
            ((EditText) _$_findCachedViewById(C2723R.C2726id.txt_max_bid)).setText(this.bidAmount);
            Button button3 = (Button) _$_findCachedViewById(C2723R.C2726id.btnViewEstimate);
            Intrinsics.checkExpressionValueIsNotNull(button3, "btnViewEstimate");
            button3.setEnabled(true);
            Button button4 = (Button) _$_findCachedViewById(C2723R.C2726id.btnViewEstimate);
            Intrinsics.checkExpressionValueIsNotNull(button4, "btnViewEstimate");
            button4.setAlpha(1.0f);
            costCalculator();
        }
        if (this.dropOffzipCode.length() > 0) {
            Button button5 = (Button) _$_findCachedViewById(C2723R.C2726id.btnRemoveEdit);
            Intrinsics.checkExpressionValueIsNotNull(button5, "btnRemoveEdit");
            button5.setVisibility(0);
            ((EditText) _$_findCachedViewById(C2723R.C2726id.txt_zip_code)).setText(this.dropOffzipCode);
            Button button6 = (Button) _$_findCachedViewById(C2723R.C2726id.btnGetQuote);
            Intrinsics.checkExpressionValueIsNotNull(button6, "btnGetQuote");
            button6.setEnabled(true);
            Button button7 = (Button) _$_findCachedViewById(C2723R.C2726id.btnGetQuote);
            Intrinsics.checkExpressionValueIsNotNull(button7, "btnGetQuote");
            button7.setAlpha(1.0f);
            costCalculator();
        } else {
            Button button8 = (Button) _$_findCachedViewById(C2723R.C2726id.btnRemoveEdit);
            Intrinsics.checkExpressionValueIsNotNull(button8, "btnRemoveEdit");
            button8.setVisibility(8);
        }
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnRemoveEdit)).setOnClickListener(new CostCalculatorFragment$onActivityCreated$1(this));
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnGetQuote)).setOnClickListener(new CostCalculatorFragment$onActivityCreated$2(this));
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnViewEstimate)).setOnClickListener(new CostCalculatorFragment$onActivityCreated$3(this));
        subscribeToViewModel();
    }

    private final void updateCostCalculatorLayoutUI() {
        ((EditText) _$_findCachedViewById(C2723R.C2726id.txt_max_bid)).addTextChangedListener(new CostCalculatorFragment$updateCostCalculatorLayoutUI$1(this));
    }

    private final void updateBundleDataPoints() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        String string = arguments.getString(Constants_MVVM.EXTRA_STOCK_NUMBER);
        if (string == null) {
            string = "";
        }
        this.stockNumber = string;
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            Intrinsics.throwNpe();
        }
        String string2 = arguments2.getString(Constants_MVVM.EXTRA_BUYER_ID);
        if (string2 == null) {
            string2 = "";
        }
        this.buyerID = string2;
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            Intrinsics.throwNpe();
        }
        String string3 = arguments3.getString("userID");
        if (string3 == null) {
            string3 = "";
        }
        this.userID = string3;
        Bundle arguments4 = getArguments();
        if (arguments4 == null) {
            Intrinsics.throwNpe();
        }
        String string4 = arguments4.getString(Constants_MVVM.EXTRA_EMPLOYEE_ID);
        if (string4 == null) {
            string4 = "";
        }
        this.employeeID = string4;
        Bundle arguments5 = getArguments();
        if (arguments5 == null) {
            Intrinsics.throwNpe();
        }
        String string5 = arguments5.getString(Constants_MVVM.EXTRA_VIN);
        if (string5 == null) {
            string5 = "";
        }
        this.vin = string5;
        Bundle arguments6 = getArguments();
        if (arguments6 == null) {
            Intrinsics.throwNpe();
        }
        String string6 = arguments6.getString(Constants_MVVM.EXTRA_BRANCH_CODE);
        if (string6 == null) {
            string6 = "";
        }
        this.branchCode = string6;
        Bundle arguments7 = getArguments();
        if (arguments7 == null) {
            Intrinsics.throwNpe();
        }
        String string7 = arguments7.getString("zipCode");
        if (string7 == null) {
            string7 = "";
        }
        this.pickUpzipCode = string7;
        Bundle arguments8 = getArguments();
        if (arguments8 == null) {
            Intrinsics.throwNpe();
        }
        String string8 = arguments8.getString(Constants_MVVM.EXTRA_ITEM_ID);
        if (string8 == null) {
            string8 = "";
        }
        this.itemId = string8;
        Bundle arguments9 = getArguments();
        if (arguments9 == null) {
            Intrinsics.throwNpe();
        }
        this.salvageID = arguments9.getInt(Constants_MVVM.EXTRA_SALVAGE_ID);
        Bundle arguments10 = getArguments();
        if (arguments10 == null) {
            Intrinsics.throwNpe();
        }
        this.isTransportationQuotesAvailable = arguments10.getBoolean(Constants_MVVM.EXTRA_IS_TRANSPORTATION_QUOTES);
    }

    /* access modifiers changed from: private */
    public final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            validateEstimateBidAmount();
            return;
        }
        Context context = getContext();
        if (context != null) {
            String string = getResources().getString(C2723R.string.lbl_msg_no_internet_connection);
            Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st…g_no_internet_connection)");
            Context_ExtensionKt.showToast(context, string);
        }
    }

    private final void validateEstimateBidAmount() {
        long j = (long) 0;
        BigInteger valueOf = BigInteger.valueOf(j);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "BigInteger.valueOf(this.toLong())");
        if (!TextUtils.isEmpty(this.bidAmount)) {
            valueOf = new BigInteger(this.bidAmount);
        }
        TextInputLayout textInputLayout = (TextInputLayout) _$_findCachedViewById(C2723R.C2726id.txt_bid_amount_layout);
        Intrinsics.checkExpressionValueIsNotNull(textInputLayout, "txt_bid_amount_layout");
        textInputLayout.setErrorEnabled(false);
        if (TextUtils.isEmpty(this.bidAmount)) {
            String string = getString(C2723R.string.msg_cannot_be_blank, getString(C2723R.string.lbl_pre_bid_max));
            Intrinsics.checkExpressionValueIsNotNull(string, "getString(R.string.msg_c….string.lbl_pre_bid_max))");
            TextInputLayout textInputLayout2 = (TextInputLayout) _$_findCachedViewById(C2723R.C2726id.txt_bid_amount_layout);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout2, "txt_bid_amount_layout");
            textInputLayout2.setErrorEnabled(true);
            TextInputLayout textInputLayout3 = (TextInputLayout) _$_findCachedViewById(C2723R.C2726id.txt_bid_amount_layout);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout3, "txt_bid_amount_layout");
            textInputLayout3.setError(string);
            return;
        }
        BigInteger valueOf2 = BigInteger.valueOf((long) 25);
        Intrinsics.checkExpressionValueIsNotNull(valueOf2, "BigInteger.valueOf(this.toLong())");
        BigInteger remainder = valueOf.remainder(valueOf2);
        Intrinsics.checkExpressionValueIsNotNull(remainder, "this.remainder(other)");
        BigInteger valueOf3 = BigInteger.valueOf(j);
        Intrinsics.checkExpressionValueIsNotNull(valueOf3, "BigInteger.valueOf(this.toLong())");
        if (!Intrinsics.areEqual((Object) remainder, (Object) valueOf3)) {
            String string2 = getString(C2723R.string.lbl_bdt_pre_bid_increment_msg);
            Intrinsics.checkExpressionValueIsNotNull(string2, "getString(R.string.lbl_bdt_pre_bid_increment_msg)");
            TextInputLayout textInputLayout4 = (TextInputLayout) _$_findCachedViewById(C2723R.C2726id.txt_bid_amount_layout);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout4, "txt_bid_amount_layout");
            textInputLayout4.setErrorEnabled(true);
            TextInputLayout textInputLayout5 = (TextInputLayout) _$_findCachedViewById(C2723R.C2726id.txt_bid_amount_layout);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout5, "txt_bid_amount_layout");
            textInputLayout5.setError(string2);
            return;
        }
        costCalculator();
    }

    /* access modifiers changed from: private */
    public final void costCalculator() {
        boolean z = false;
        BigInteger valueOf = BigInteger.valueOf((long) 0);
        Intrinsics.checkExpressionValueIsNotNull(valueOf, "BigInteger.valueOf(this.toLong())");
        int parseInt = this.buyerID.length() > 0 ? Integer.parseInt(this.buyerID) : 0;
        int parseInt2 = this.userID.length() > 0 ? Integer.parseInt(this.userID) : 0;
        if (this.bidAmount.length() > 0) {
            z = true;
        }
        if (z) {
            valueOf = new BigInteger(this.bidAmount);
        }
        BigInteger bigInteger = valueOf;
        CostCalculatorViewModel costCalculatorViewModel = this.viewModel;
        if (costCalculatorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        BigDecimal valueOf2 = BigDecimal.valueOf((long) this.salvageID);
        Intrinsics.checkExpressionValueIsNotNull(valueOf2, "BigDecimal.valueOf(this.toLong())");
        costCalculatorViewModel.costCalculator(valueOf2, new BigDecimal(this.stockNumber), bigInteger, parseInt, parseInt2, this.pickUpzipCode, this.dropOffzipCode, String.valueOf(this.vin), PdfBoolean.FALSE, String.valueOf(this.employeeID), String.valueOf(this.branchCode));
    }

    private final void subscribeToViewModel() {
        CostCalculatorViewModel costCalculatorViewModel = this.viewModel;
        if (costCalculatorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<Boolean> showLoading = costCalculatorViewModel.getShowLoading();
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        showLoading.observe(baseActivity2, new CostCalculatorFragment$subscribeToViewModel$1(this));
        CostCalculatorViewModel costCalculatorViewModel2 = this.viewModel;
        if (costCalculatorViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<CostCalculatorResponse> costCalculatorResultResponse = costCalculatorViewModel2.getCostCalculatorResultResponse();
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        costCalculatorResultResponse.observe(baseActivity3, new CostCalculatorFragment$subscribeToViewModel$2(this));
        CostCalculatorViewModel costCalculatorViewModel3 = this.viewModel;
        if (costCalculatorViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> costCalculatorResultError = costCalculatorViewModel3.getCostCalculatorResultError();
        BaseActivity baseActivity4 = this.baseActivity;
        if (baseActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        costCalculatorResultError.observe(baseActivity4, new CostCalculatorFragment$subscribeToViewModel$3(this));
    }

    /* access modifiers changed from: private */
    public final void updateCostBreakDownUI(List<CostList> list) {
        View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.viewCostBreakDown);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "viewCostBreakDown");
        _$_findCachedViewById.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.costBreakDown);
        Intrinsics.checkExpressionValueIsNotNull(linearLayout, "costBreakDown");
        linearLayout.setVisibility(0);
        if (this.isTransportationQuotesAvailable) {
            if (this.dropOffzipCode.length() == 0) {
                LinearLayout linearLayout2 = (LinearLayout) _$_findCachedViewById(C2723R.C2726id.linearLayout3);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "linearLayout3");
                linearLayout2.setVisibility(0);
                TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_deliver_transport_lable);
                Intrinsics.checkExpressionValueIsNotNull(textView, "tv_deliver_transport_lable");
                textView.setVisibility(0);
            }
        }
        CostCalculatorAdapter costCalculatorAdapter2 = this.costCalculatorAdapter;
        if (costCalculatorAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("costCalculatorAdapter");
        }
        costCalculatorAdapter2.setCostCalData(list);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvCostBreakDown);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView, "rvCostBreakDown");
        CostCalculatorAdapter costCalculatorAdapter3 = this.costCalculatorAdapter;
        if (costCalculatorAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("costCalculatorAdapter");
        }
        recyclerView.setAdapter(costCalculatorAdapter3);
        RecyclerView recyclerView2 = (RecyclerView) _$_findCachedViewById(C2723R.C2726id.rvCostBreakDown);
        Intrinsics.checkExpressionValueIsNotNull(recyclerView2, "rvCostBreakDown");
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity2 == null) {
            Intrinsics.throwNpe();
        }
        Application application = baseActivity2.getApplication();
        Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
        recyclerView2.setLayoutManager(new LinearLayoutManager(application.getApplicationContext()));
    }

    private final void updateZipCodeUI() {
        ((EditText) _$_findCachedViewById(C2723R.C2726id.txt_zip_code)).addTextChangedListener(new CostCalculatorFragment$updateZipCodeUI$1(this));
    }

    public void onDestroy() {
        super.onDestroy();
        CostCalculatorViewModel costCalculatorViewModel = this.viewModel;
        if (costCalculatorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        costCalculatorViewModel.disposeElements();
    }
}
