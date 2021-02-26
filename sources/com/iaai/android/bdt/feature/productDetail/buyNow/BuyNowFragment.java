package com.iaai.android.bdt.feature.productDetail.buyNow;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.extensions.OnAlertButtonClick;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.productDetail.buyNow.BuyNowResult;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.databinding.FragmentBuyNowBinding;
import com.iaai.android.old.utils.DateHelper;
import dagger.android.support.AndroidSupportInjection;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u0007H\u0002J\b\u0010*\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020(H\u0002J\u0012\u0010,\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\u0010\u0010/\u001a\u00020(2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020(H\u0016J\u0012\u00103\u001a\u00020(2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J&\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u0001092\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010:\u001a\u00020(H\u0016J\b\u0010;\u001a\u00020(H\u0016J\u0010\u0010<\u001a\u00020(2\u0006\u0010=\u001a\u00020\u0007H\u0002J\u0010\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020\u0005H\u0002J\b\u0010@\u001a\u00020(H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/buyNow/BuyNowFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "Lcom/iaai/android/bdt/extensions/OnAlertButtonClick;", "()V", "IsUpstreamBranchStock", "", "TAG", "", "kotlin.jvm.PlatformType", "animFadeIn", "Landroid/view/animation/Animation;", "animFadeOut", "auctionId", "awardMessage", "baseActivity", "Lcom/iaai/android/bdt/base/BaseActivity;", "branchName", "buyPrice", "itemId", "paymentDueDate", "pickUpDate", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "stockNumber", "timeToBuy", "vehicleLocation", "viewModel", "Lcom/iaai/android/bdt/feature/productDetail/buyNow/BuyNowViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "yearModel", "buyNow", "", "calculateTimeLeftToBuy", "checkNetworkConnection", "handleBuyNowResult", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCancelClick", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onOKClick", "sendFireBaseEventBuyNowSuccess", "amount", "showLoadingIndicator", "loading", "subscribeToViewModel", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowFragment.kt */
public final class BuyNowFragment extends BaseFragment implements OnAlertButtonClick {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SAMPLE = "sample";
    private boolean IsUpstreamBranchStock;
    private final String TAG = BuyNowFragment.class.getSimpleName();
    private HashMap _$_findViewCache;
    private Animation animFadeIn;
    private Animation animFadeOut;
    private String auctionId = "";
    private String awardMessage = "";
    /* access modifiers changed from: private */
    public BaseActivity baseActivity;
    private String branchName = "";
    private String buyPrice = "";
    private String itemId = "";
    private String paymentDueDate = "";
    private String pickUpDate = "";
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private String stockNumber = "";
    private String timeToBuy = "";
    private String vehicleLocation = "";
    private BuyNowViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;
    private String yearModel = "";

    @JvmStatic
    @NotNull
    public static final BuyNowFragment newInstance(@NotNull String str) {
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

    public void onCancelClick() {
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public static final /* synthetic */ BaseActivity access$getBaseActivity$p(BuyNowFragment buyNowFragment) {
        BaseActivity baseActivity2 = buyNowFragment.baseActivity;
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/buyNow/BuyNowFragment$Companion;", "", "()V", "KEY_SAMPLE", "", "newInstance", "Lcom/iaai/android/bdt/feature/productDetail/buyNow/BuyNowFragment;", "url", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: BuyNowFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final BuyNowFragment newInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            BuyNowFragment buyNowFragment = new BuyNowFragment();
            Bundle bundle = new Bundle();
            bundle.putString(BuyNowFragment.KEY_SAMPLE, str);
            buyNowFragment.setArguments(bundle);
            return buyNowFragment;
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
        ViewModel viewModel2 = ViewModelProviders.m16of(fragment, factory).get(BuyNowViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…NowViewModel::class.java)");
        this.viewModel = (BuyNowViewModel) viewModel2;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        FragmentBuyNowBinding fragmentBuyNowBinding = (FragmentBuyNowBinding) DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_buy_now, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(fragmentBuyNowBinding, "mBinding");
        return fragmentBuyNowBinding.getRoot();
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbLoading);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbLoading");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbLoading);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbLoading");
        progressBar2.setVisibility(8);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        String string = arguments.getString(Constants_MVVM.EXTRA_ITEM_ID);
        if (string == null) {
            string = "";
        }
        this.itemId = string;
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            Intrinsics.throwNpe();
        }
        String string2 = arguments2.getString(Constants_MVVM.EXTRA_STOCK_NUMBER);
        if (string2 == null) {
            string2 = "";
        }
        this.stockNumber = string2;
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            Intrinsics.throwNpe();
        }
        String string3 = arguments3.getString("branchName");
        if (string3 == null) {
            string3 = "";
        }
        this.branchName = string3;
        Bundle arguments4 = getArguments();
        if (arguments4 == null) {
            Intrinsics.throwNpe();
        }
        String string4 = arguments4.getString(Constants_MVVM.EXTRA_VEHICLE_LOCATION);
        if (string4 == null) {
            string4 = "";
        }
        this.vehicleLocation = string4;
        Bundle arguments5 = getArguments();
        if (arguments5 == null) {
            Intrinsics.throwNpe();
        }
        String string5 = arguments5.getString(Constants_MVVM.EXTRA_YEAR_MAKE_MODEL);
        if (string5 == null) {
            string5 = "";
        }
        this.yearModel = string5;
        Bundle arguments6 = getArguments();
        if (arguments6 == null) {
            Intrinsics.throwNpe();
        }
        String string6 = arguments6.getString(Constants_MVVM.EXTRA_BUY_PRICE);
        if (string6 == null) {
            string6 = "";
        }
        this.buyPrice = string6;
        Bundle arguments7 = getArguments();
        if (arguments7 == null) {
            Intrinsics.throwNpe();
        }
        String string7 = arguments7.getString(Constants_MVVM.EXTRA_TIME_LEFT_TO_BUY);
        if (string7 == null) {
            string7 = "";
        }
        this.timeToBuy = string7;
        Bundle arguments8 = getArguments();
        if (arguments8 == null) {
            Intrinsics.throwNpe();
        }
        String string8 = arguments8.getString(Constants_MVVM.EXTRA_AUCTION_ID);
        if (string8 == null) {
            string8 = "";
        }
        this.auctionId = string8;
        Bundle arguments9 = getArguments();
        if (arguments9 == null) {
            Intrinsics.throwNpe();
        }
        String string9 = arguments9.getString(Constants_MVVM.EXTRA_BUY_NOW_PICK_UP_BY);
        if (string9 == null) {
            string9 = "";
        }
        this.pickUpDate = string9;
        Bundle arguments10 = getArguments();
        if (arguments10 == null) {
            Intrinsics.throwNpe();
        }
        String string10 = arguments10.getString(Constants_MVVM.EXTRA_BUY_NOW_PAYMENT_DUE_BY);
        if (string10 == null) {
            string10 = "";
        }
        this.paymentDueDate = string10;
        Bundle arguments11 = getArguments();
        if (arguments11 == null) {
            Intrinsics.throwNpe();
        }
        String string11 = arguments11.getString(Constants_MVVM.EXTRA_BUY_NOW_AWARD_MESSAGE);
        if (string11 == null) {
            string11 = "";
        }
        this.awardMessage = string11;
        Bundle arguments12 = getArguments();
        if (arguments12 == null) {
            Intrinsics.throwNpe();
        }
        this.IsUpstreamBranchStock = arguments12.getBoolean(Constants_MVVM.EXTRA_BUY_NOW_IS_UPSTREAM_BRANCH);
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvYearModel);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvYearModel");
        textView.setText(this.yearModel);
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvStockNumber);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvStockNumber");
        textView2.setText(this.stockNumber);
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBranchName);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvBranchName");
        textView3.setText(this.branchName);
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvVehicleLocation);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "tvVehicleLocation");
        textView4.setText(this.vehicleLocation);
        TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvBuyPrice);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "tvBuyPrice");
        textView5.setText(this.buyPrice + 10 + getResources().getString(C2723R.string.lbl_bdt_applicable_fees));
        TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvPaymentDue);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "tvPaymentDue");
        textView6.setText(this.paymentDueDate);
        TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvPickUpBy);
        Intrinsics.checkExpressionValueIsNotNull(textView7, "tvPickUpBy");
        textView7.setText(this.pickUpDate);
        TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvAwardMessage);
        Intrinsics.checkExpressionValueIsNotNull(textView8, "tvAwardMessage");
        textView8.setText(this.awardMessage);
        TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvTimeLeftToBuy);
        Intrinsics.checkExpressionValueIsNotNull(textView9, "tvTimeLeftToBuy");
        textView9.setText(calculateTimeLeftToBuy());
        subscribeToViewModel();
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnSubmit)).setOnClickListener(new BuyNowFragment$onActivityCreated$1(this));
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnClose)).setOnClickListener(new BuyNowFragment$onActivityCreated$2(this));
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C2723R.anim.fade_in);
        Intrinsics.checkExpressionValueIsNotNull(loadAnimation, "AnimationUtils.loadAnima…          R.anim.fade_in)");
        this.animFadeIn = loadAnimation;
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), C2723R.anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(loadAnimation2, "AnimationUtils.loadAnima…         R.anim.fade_out)");
        this.animFadeOut = loadAnimation2;
    }

    private final void subscribeToViewModel() {
        BuyNowViewModel buyNowViewModel = this.viewModel;
        if (buyNowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<Boolean> showLoading = buyNowViewModel.getShowLoading();
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        showLoading.observe(baseActivity2, new BuyNowFragment$subscribeToViewModel$1(this));
        BuyNowViewModel buyNowViewModel2 = this.viewModel;
        if (buyNowViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<BuyNowResult> buyNowResponse = buyNowViewModel2.getBuyNowResponse();
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        buyNowResponse.observe(baseActivity3, new BuyNowFragment$subscribeToViewModel$2(this));
        BuyNowViewModel buyNowViewModel3 = this.viewModel;
        if (buyNowViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> buyNowError = buyNowViewModel3.getBuyNowError();
        BaseActivity baseActivity4 = this.baseActivity;
        if (baseActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        buyNowError.observe(baseActivity4, new BuyNowFragment$subscribeToViewModel$3(this));
    }

    private final void buyNow() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        if (sessionManager2.getCurrentSessionUserId() != null) {
            BuyNowViewModel buyNowViewModel = this.viewModel;
            if (buyNowViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            Object[] objArr = new Object[2];
            SessionManager sessionManager3 = this.sessionManager;
            if (sessionManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            objArr[0] = sessionManager3.getCurrentSessionUsername();
            SessionManager sessionManager4 = this.sessionManager;
            if (sessionManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            objArr[1] = sessionManager4.getCurrentSessionPassword();
            String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
            Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
            String str = this.itemId;
            SessionManager sessionManager5 = this.sessionManager;
            if (sessionManager5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            String currentSessionUserId = sessionManager5.getCurrentSessionUserId();
            if (currentSessionUserId == null) {
                currentSessionUserId = "";
            }
            buyNowViewModel.buyNow(format, str, currentSessionUserId, this.auctionId, this.IsUpstreamBranchStock);
        }
    }

    /* access modifiers changed from: private */
    public final void handleBuyNowResult() {
        String str = new Regex("\\s").split(this.buyPrice, 0).get(0);
        if (str != null) {
            String substring = str.substring(1);
            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.String).substring(startIndex)");
            sendFireBaseEventBuyNowSuccess(StringsKt.replace$default(substring, ",", "", false, 4, (Object) null));
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rvCongratulationsContainer);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "rvCongratulationsContainer");
            relativeLayout.setVisibility(0);
            RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rvCongratulationsContainer);
            Animation animation = this.animFadeIn;
            if (animation == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animFadeIn");
            }
            relativeLayout2.startAnimation(animation);
            ScrollView scrollView = (ScrollView) _$_findCachedViewById(C2723R.C2726id.svBuyNowContainer);
            Animation animation2 = this.animFadeOut;
            if (animation2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("animFadeOut");
            }
            scrollView.startAnimation(animation2);
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvCongratsMessage);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tvCongratsMessage");
            textView.setText(getResources().getString(C2723R.string.lbl_bdt_buy_now_congratulations, new Object[]{this.yearModel, this.buyPrice}));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    /* access modifiers changed from: private */
    public final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            buyNow();
            return;
        }
        Context context = getContext();
        if (context != null) {
            String string = getResources().getString(C2723R.string.lbl_msg_no_internet_connection);
            Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st…g_no_internet_connection)");
            Context_ExtensionKt.showToast(context, string);
        }
    }

    private final String calculateTimeLeftToBuy() {
        DateHelper.TimeDiff calculateDateTimeDiff = DateHelper.calculateDateTimeDiff(new Date(), DateHelper.parseDateInServerTimezone(this.timeToBuy));
        Intrinsics.checkExpressionValueIsNotNull(calculateDateTimeDiff, "timeDiff");
        String preBidTimeString = calculateDateTimeDiff.getPreBidTimeString();
        Intrinsics.checkExpressionValueIsNotNull(preBidTimeString, "timeDiff.preBidTimeString");
        return preBidTimeString;
    }

    public void onDestroy() {
        super.onDestroy();
        BuyNowViewModel buyNowViewModel = this.viewModel;
        if (buyNowViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        buyNowViewModel.disposeElements();
    }

    public void onOKClick() {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity2 instanceof AuctionSalesListActivity) {
            BaseActivity baseActivity3 = this.baseActivity;
            if (baseActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            if (baseActivity3 != null) {
                ((AuctionSalesListActivity) baseActivity3).onBackPressed();
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity");
        }
    }

    private final void sendFireBaseEventBuyNowSuccess(String str) {
        Bundle bundle = new Bundle();
        bundle.putDouble(IAAAnalytics.FireBaseKeyNames.VALUE.getId(), Double.parseDouble(str));
        bundle.putString(IAAAnalytics.FireBaseKeyNames.CURRENCY.getId(), IAAAnalytics.FireBaseValueNames.USD.getId());
        bundle.putString(IAAAnalytics.FireBaseKeyNames.ITEM_ID.getId(), this.itemId);
        bundle.putString(IAAAnalytics.FireBaseKeyNames.ORIGIN.getId(), IAAAnalytics.FireBaseValueNames.BUY_NOW.getId());
        Log.e("FIRE_BASE_ANALYTICS", "Sending Event: " + IAAAnalytics.IAAEvents.ECOMMERCE_PURCHASE.getId() + " :" + bundle);
        IAAAnalytics.INSTANCE.logIAAEvent(IAAAnalytics.IAAEvents.ECOMMERCE_PURCHASE, bundle);
    }
}
