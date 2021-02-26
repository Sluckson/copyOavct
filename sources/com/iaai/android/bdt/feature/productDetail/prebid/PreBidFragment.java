package com.iaai.android.bdt.feature.productDetail.prebid;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailErrorModel;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailResponse;
import com.iaai.android.bdt.model.productDetail.prebid.PreBidPlacedResult;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.databinding.FragmentPrebidLayoutBinding;
import com.iaai.android.old.utils.p016ui.UiUtils;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 X2\u00020\u0001:\u0001XB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u0004H\u0002J\b\u00106\u001a\u000204H\u0002J\b\u00107\u001a\u000204H\u0002J\u0012\u00108\u001a\u0002042\b\u00109\u001a\u0004\u0018\u00010:H\u0002J\u0012\u0010;\u001a\u0002042\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\u0012\u0010>\u001a\u0002042\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\u0010\u0010A\u001a\u0002042\u0006\u0010B\u001a\u00020CH\u0016J\u0012\u0010D\u001a\u0002042\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J&\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010J2\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010K\u001a\u000204H\u0016J\u0010\u0010L\u001a\u0002042\u0006\u0010M\u001a\u00020\u0010H\u0002J\b\u0010N\u001a\u000204H\u0002J\b\u0010O\u001a\u000204H\u0002J\b\u0010P\u001a\u000204H\u0002J\b\u0010Q\u001a\u000204H\u0002J\b\u0010R\u001a\u000204H\u0002J\b\u0010S\u001a\u000204H\u0002J\b\u0010T\u001a\u000204H\u0002J\b\u0010U\u001a\u000204H\u0002J\u0010\u0010V\u001a\u0002042\u0006\u0010W\u001a\u00020FH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X.¢\u0006\u0002\n\u0000R\u001e\u0010,\u001a\u00020-8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006Y"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/prebid/PreBidFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "action", "", "animFadeIn", "Landroid/view/animation/Animation;", "animFadeOut", "auctionDate", "auctionId", "awardMessage", "baseActivity", "Lcom/iaai/android/bdt/base/BaseActivity;", "branchName", "currentBid", "displaySaleTaxWarning", "", "displaySaleTextMessage", "formattedMyMax", "incrementBid", "isTimedAuction", "itemId", "maxBidString", "minBidInt", "", "myMax", "paymentDueDate", "pickUpDate", "preBidPopErrorMessage", "preBidTimeRemaining", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "startingBid", "", "stockNumber", "timeToBuy", "userId", "vehicleLocation", "viewModel", "Lcom/iaai/android/bdt/feature/productDetail/prebid/PreBidViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "yearModel", "createHTMLString", "", "html", "displayUI", "fetchProductDetail", "handlePlaceBidResult", "result", "Lcom/iaai/android/bdt/model/productDetail/prebid/PreBidPlacedResult;", "initializeDataPoints", "productDetailResponse", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailResponse;", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "showLoadingIndicator", "loading", "subscribeToViewModel", "updateBidSubmittedUI", "updateBundleDataPoints", "updatePreBidMainLayoutUI", "updatePreBidSubmittedLayoutUI", "updateReviewConfirmPage", "updateReviewConfrimLayoutUI", "updateUI", "validateMaxBidAmount", "v", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: PreBidFragment.kt */
public final class PreBidFragment extends BaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SAMPLE = "sample";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public String action = "";
    private Animation animFadeIn;
    private Animation animFadeOut;
    private String auctionDate = "";
    /* access modifiers changed from: private */
    public String auctionId = "";
    private String awardMessage = "";
    /* access modifiers changed from: private */
    public BaseActivity baseActivity;
    private String branchName = "";
    private String currentBid = "";
    private boolean displaySaleTaxWarning;
    private String displaySaleTextMessage = "";
    private String formattedMyMax = "";
    private String incrementBid = "";
    /* access modifiers changed from: private */
    public boolean isTimedAuction;
    /* access modifiers changed from: private */
    public String itemId = "";
    /* access modifiers changed from: private */
    public String maxBidString = "";
    /* access modifiers changed from: private */
    public double minBidInt;
    private String myMax = "";
    private String paymentDueDate = "";
    private String pickUpDate = "";
    private String preBidPopErrorMessage = "";
    private String preBidTimeRemaining = "";
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private int startingBid;
    private String stockNumber = "";
    private String timeToBuy = "";
    private String userId = "";
    private String vehicleLocation = "";
    /* access modifiers changed from: private */
    public PreBidViewModel viewModel;
    @Inject
    @NotNull
    public ViewModelProvider.Factory viewModelFactory;
    private String yearModel = "";

    @JvmStatic
    @NotNull
    public static final PreBidFragment newInstance(@NotNull String str) {
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

    public static final /* synthetic */ BaseActivity access$getBaseActivity$p(PreBidFragment preBidFragment) {
        BaseActivity baseActivity2 = preBidFragment.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        return baseActivity2;
    }

    public static final /* synthetic */ PreBidViewModel access$getViewModel$p(PreBidFragment preBidFragment) {
        PreBidViewModel preBidViewModel = preBidFragment.viewModel;
        if (preBidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return preBidViewModel;
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/prebid/PreBidFragment$Companion;", "", "()V", "KEY_SAMPLE", "", "newInstance", "Lcom/iaai/android/bdt/feature/productDetail/prebid/PreBidFragment;", "url", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: PreBidFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final PreBidFragment newInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            PreBidFragment preBidFragment = new PreBidFragment();
            Bundle bundle = new Bundle();
            bundle.putString(PreBidFragment.KEY_SAMPLE, str);
            preBidFragment.setArguments(bundle);
            return preBidFragment;
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
        ViewModel viewModel2 = ViewModelProviders.m16of(fragment, factory).get(PreBidViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…BidViewModel::class.java)");
        this.viewModel = (PreBidViewModel) viewModel2;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        FragmentPrebidLayoutBinding fragmentPrebidLayoutBinding = (FragmentPrebidLayoutBinding) DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.fragment_prebid_layout, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(fragmentPrebidLayoutBinding, "mBinding");
        return fragmentPrebidLayoutBinding.getRoot();
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pre_bid_pbLoading);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pre_bid_pbLoading");
            progressBar.setVisibility(0);
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pre_bid_pbLoading);
        Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pre_bid_pbLoading");
        progressBar2.setVisibility(8);
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        updateBundleDataPoints();
        if (InternetUtil.INSTANCE.isInternetOn()) {
            fetchProductDetail();
        } else {
            displayUI();
            subscribeToViewModel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), C2723R.anim.fade_in);
        Intrinsics.checkExpressionValueIsNotNull(loadAnimation, "AnimationUtils.loadAnima…          R.anim.fade_in)");
        this.animFadeIn = loadAnimation;
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), C2723R.anim.fade_out);
        Intrinsics.checkExpressionValueIsNotNull(loadAnimation2, "AnimationUtils.loadAnima…         R.anim.fade_out)");
        this.animFadeOut = loadAnimation2;
    }

    private final void updateBundleDataPoints() {
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
        String string2 = arguments2.getString("userID");
        if (string2 == null) {
            string2 = "";
        }
        this.userId = string2;
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            Intrinsics.throwNpe();
        }
        String string3 = arguments3.getString(Constants_MVVM.EXTRA_STOCK_NUMBER);
        if (string3 == null) {
            string3 = "";
        }
        this.stockNumber = string3;
        Bundle arguments4 = getArguments();
        if (arguments4 == null) {
            Intrinsics.throwNpe();
        }
        String string4 = arguments4.getString("branchName");
        if (string4 == null) {
            string4 = "";
        }
        this.branchName = string4;
        Bundle arguments5 = getArguments();
        if (arguments5 == null) {
            Intrinsics.throwNpe();
        }
        String string5 = arguments5.getString(Constants_MVVM.EXTRA_AUCTION_DATE);
        if (string5 == null) {
            string5 = "";
        }
        this.auctionDate = string5;
        Bundle arguments6 = getArguments();
        if (arguments6 == null) {
            Intrinsics.throwNpe();
        }
        String string6 = arguments6.getString(Constants_MVVM.EXTRA_YEAR_MAKE_MODEL);
        if (string6 == null) {
            string6 = "";
        }
        this.yearModel = string6;
        Bundle arguments7 = getArguments();
        if (arguments7 == null) {
            Intrinsics.throwNpe();
        }
        String string7 = arguments7.getString(Constants_MVVM.EXTRA_VEHICLE_LOCATION);
        if (string7 == null) {
            string7 = "";
        }
        this.vehicleLocation = string7;
        Bundle arguments8 = getArguments();
        if (arguments8 == null) {
            Intrinsics.throwNpe();
        }
        String string8 = arguments8.getString(Constants_MVVM.EXTRA_YEAR_MAKE_MODEL);
        if (string8 == null) {
            string8 = "";
        }
        this.yearModel = string8;
        Bundle arguments9 = getArguments();
        if (arguments9 == null) {
            Intrinsics.throwNpe();
        }
        String string9 = arguments9.getString(Constants_MVVM.EXTRA_PRE_BID_MYMAX);
        if (string9 == null) {
            string9 = "";
        }
        this.myMax = string9;
        Bundle arguments10 = getArguments();
        if (arguments10 == null) {
            Intrinsics.throwNpe();
        }
        String string10 = arguments10.getString(Constants_MVVM.EXTRA_TIME_LEFT_TO_BUY);
        if (string10 == null) {
            string10 = "";
        }
        this.timeToBuy = string10;
        Bundle arguments11 = getArguments();
        if (arguments11 == null) {
            Intrinsics.throwNpe();
        }
        String string11 = arguments11.getString(Constants_MVVM.EXTRA_AUCTION_ID);
        if (string11 == null) {
            string11 = "";
        }
        this.auctionId = string11;
        Bundle arguments12 = getArguments();
        if (arguments12 == null) {
            Intrinsics.throwNpe();
        }
        String string12 = arguments12.getString(Constants_MVVM.EXTRA_BUY_NOW_PICK_UP_BY);
        if (string12 == null) {
            string12 = "";
        }
        this.pickUpDate = string12;
        Bundle arguments13 = getArguments();
        if (arguments13 == null) {
            Intrinsics.throwNpe();
        }
        String string13 = arguments13.getString(Constants_MVVM.EXTRA_BUY_NOW_PAYMENT_DUE_BY);
        if (string13 == null) {
            string13 = "";
        }
        this.paymentDueDate = string13;
        Bundle arguments14 = getArguments();
        if (arguments14 == null) {
            Intrinsics.throwNpe();
        }
        String string14 = arguments14.getString(Constants_MVVM.EXTRA_BUY_NOW_AWARD_MESSAGE);
        if (string14 == null) {
            string14 = "";
        }
        this.awardMessage = string14;
        Bundle arguments15 = getArguments();
        if (arguments15 == null) {
            Intrinsics.throwNpe();
        }
        String string15 = arguments15.getString(Constants_MVVM.EXTRA_PRE_BID_INCREMENT);
        if (string15 == null) {
            string15 = "";
        }
        this.incrementBid = string15;
        Bundle arguments16 = getArguments();
        if (arguments16 == null) {
            Intrinsics.throwNpe();
        }
        String string16 = arguments16.getString(Constants_MVVM.EXTRA_PRE_BID_FORMATTED_MYMAX);
        if (string16 == null) {
            string16 = "";
        }
        this.formattedMyMax = string16;
        Bundle arguments17 = getArguments();
        if (arguments17 == null) {
            Intrinsics.throwNpe();
        }
        String string17 = arguments17.getString(Constants_MVVM.EXTRA_PRE_BID_CURRENT_BID);
        if (string17 == null) {
            string17 = "";
        }
        this.currentBid = string17;
        Bundle arguments18 = getArguments();
        if (arguments18 == null) {
            Intrinsics.throwNpe();
        }
        String string18 = arguments18.getString(Constants_MVVM.EXTRA_PRE_BID_DISPLAY_SALES_TAX_MASG);
        if (string18 == null) {
            string18 = "";
        }
        this.displaySaleTextMessage = string18;
        Bundle arguments19 = getArguments();
        if (arguments19 == null) {
            Intrinsics.throwNpe();
        }
        String string19 = arguments19.getString(Constants_MVVM.EXTRA_PRE_BID_TIME_REMAINING);
        if (string19 == null) {
            string19 = "";
        }
        this.preBidTimeRemaining = string19;
        Bundle arguments20 = getArguments();
        if (arguments20 == null) {
            Intrinsics.throwNpe();
        }
        this.displaySaleTaxWarning = arguments20.getBoolean(Constants_MVVM.EXTRA_PRE_BID_DISPLAY_SALES_TAX);
        Bundle arguments21 = getArguments();
        if (arguments21 == null) {
            Intrinsics.throwNpe();
        }
        this.isTimedAuction = arguments21.getBoolean(Constants_MVVM.EXTRA_IS_TIMED_AUCTION);
        Bundle arguments22 = getArguments();
        if (arguments22 == null) {
            Intrinsics.throwNpe();
        }
        this.startingBid = arguments22.getInt(Constants_MVVM.EXTRA_PRE_BID_STARTING_BID);
        if (this.isTimedAuction) {
            IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
            String value = IAAAnalytics.IAAScreenName.TIME_AUCTION_BID.getValue();
            FragmentActivity activity = getActivity();
            if (activity == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
            iAAAnalytics.logScreenName(value, activity, this);
            return;
        }
        IAAAnalytics iAAAnalytics2 = IAAAnalytics.INSTANCE;
        String value2 = IAAAnalytics.IAAScreenName.PRE_BID.getValue();
        FragmentActivity activity2 = getActivity();
        if (activity2 == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(activity2, "activity!!");
        iAAAnalytics2.logScreenName(value2, activity2, this);
    }

    private final void updatePreBidMainLayoutUI() {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.place_bid_year_make_model);
        Intrinsics.checkExpressionValueIsNotNull(textView, "place_bid_year_make_model");
        textView.setText(this.yearModel);
        updateUI();
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.value_stock);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "value_stock");
        textView2.setText(this.stockNumber);
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.value_prebid_branch);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "value_prebid_branch");
        textView3.setText(this.branchName);
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.value_vehicle_location);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "value_vehicle_location");
        textView4.setText(this.vehicleLocation);
        TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_award_label);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "prebid_award_label");
        textView5.setText(this.awardMessage);
        TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_payment_due_value);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "prebid_payment_due_value");
        textView6.setText(this.paymentDueDate);
        TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_pickup_value);
        Intrinsics.checkExpressionValueIsNotNull(textView7, "prebid_pickup_value");
        textView7.setText(this.pickUpDate);
        TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.txt_increment_bid);
        Intrinsics.checkExpressionValueIsNotNull(textView8, "txt_increment_bid");
        textView8.setText(this.incrementBid);
        TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_starting_bid);
        Intrinsics.checkExpressionValueIsNotNull(textView9, "prebid_starting_bid");
        textView9.setText(UiUtils.formatCurrencyFromString("" + this.startingBid, false));
        if (this.isTimedAuction) {
            TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.pre_bid_starting_label);
            Intrinsics.checkExpressionValueIsNotNull(textView10, "pre_bid_starting_label");
            textView10.setVisibility(0);
            TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_starting_bid);
            Intrinsics.checkExpressionValueIsNotNull(textView11, "prebid_starting_bid");
            textView11.setVisibility(0);
        } else {
            TextView textView12 = (TextView) _$_findCachedViewById(C2723R.C2726id.pre_bid_starting_label);
            Intrinsics.checkExpressionValueIsNotNull(textView12, "pre_bid_starting_label");
            textView12.setVisibility(8);
            TextView textView13 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_starting_bid);
            Intrinsics.checkExpressionValueIsNotNull(textView13, "prebid_starting_bid");
            textView13.setVisibility(8);
        }
        TextView textView14 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_current_bid);
        Intrinsics.checkExpressionValueIsNotNull(textView14, "prebid_current_bid");
        textView14.setText(UiUtils.formatCurrencyFromString(this.currentBid, false));
        TextView textView15 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_time_remaining);
        Intrinsics.checkExpressionValueIsNotNull(textView15, "prebid_time_remaining");
        textView15.setText(this.preBidTimeRemaining);
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.txt_max_bid);
        Intrinsics.checkExpressionValueIsNotNull(editText, "txt_max_bid");
        boolean z = true;
        editText.setFocusableInTouchMode(true);
        CharSequence charSequence = this.preBidPopErrorMessage;
        if (!(charSequence == null || charSequence.length() == 0)) {
            z = false;
        }
        if (!z) {
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.prebid_submit_button);
            Intrinsics.checkExpressionValueIsNotNull(button, "prebid_submit_button");
            button.setClickable(false);
            Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.prebid_submit_button);
            Intrinsics.checkExpressionValueIsNotNull(button2, "prebid_submit_button");
            button2.setAlpha(0.5f);
            createHTMLString(this.preBidPopErrorMessage);
        }
        ((Button) _$_findCachedViewById(C2723R.C2726id.prebid_submit_button)).setOnClickListener(new PreBidFragment$updatePreBidMainLayoutUI$1(this));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.txt_max_bid)).setText(this.myMax);
        ((EditText) _$_findCachedViewById(C2723R.C2726id.txt_max_bid)).setOnEditorActionListener(new PreBidFragment$updatePreBidMainLayoutUI$2(this));
    }

    private final void createHTMLString(String str) {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned fromHtml = Html.fromHtml(str, 0);
            Intrinsics.checkExpressionValueIsNotNull(fromHtml, "Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)");
            charSequence = fromHtml;
        } else {
            Spanned fromHtml2 = Html.fromHtml(str);
            Intrinsics.checkExpressionValueIsNotNull(fromHtml2, "Html.fromHtml(html)");
            charSequence = fromHtml2;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_prebid_sales_text_msg);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tv_prebid_sales_text_msg");
        textView.setVisibility(0);
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_prebid_sales_text_msg);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_prebid_sales_text_msg");
        textView2.setText(spannableStringBuilder);
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_prebid_sales_text_msg);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tv_prebid_sales_text_msg");
        textView3.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void updateReviewConfrimLayoutUI() {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_review_currentbid);
        Intrinsics.checkExpressionValueIsNotNull(textView, "prebid_review_currentbid");
        textView.setText(UiUtils.formatCurrencyFromString(this.currentBid, false));
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_review_my_max_bid);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "prebid_review_my_max_bid");
        textView2.setText(this.formattedMyMax);
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_review_branch);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "prebid_review_branch");
        textView3.setText(this.branchName);
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_review_stock);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "prebid_review_stock");
        textView4.setText(this.stockNumber);
        TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_review_vehicle);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "prebid_review_vehicle");
        textView5.setText(this.yearModel);
        TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_review_vehicle_location);
        Intrinsics.checkExpressionValueIsNotNull(textView6, "prebid_review_vehicle_location");
        textView6.setText(this.vehicleLocation);
        String str = this.currentBid;
        float parseFloat = str != null ? Float.parseFloat(str) : 0.0f;
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        if (parseFloat > 0.0f) {
            String str2 = this.currentBid;
            if (str2 != null) {
                d = Double.parseDouble(str2);
            }
        } else {
            int i = this.startingBid;
            if (i != 0) {
                d = (double) i;
            } else {
                String str3 = this.currentBid;
                if (str3 != null) {
                    d = Double.parseDouble(str3);
                }
            }
        }
        this.minBidInt = d;
        ((Button) _$_findCachedViewById(C2723R.C2726id.btn_pre_bid_confirm)).setOnClickListener(new PreBidFragment$updateReviewConfrimLayoutUI$1(this));
        ((Button) _$_findCachedViewById(C2723R.C2726id.btn_pre_bid_review_edit)).setOnClickListener(new PreBidFragment$updateReviewConfrimLayoutUI$2(this));
    }

    private final void updatePreBidSubmittedLayoutUI() {
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.pre_bid_submitted_current_bid);
        Intrinsics.checkExpressionValueIsNotNull(textView, "pre_bid_submitted_current_bid");
        textView.setText(UiUtils.formatCurrencyFromString(this.currentBid, false));
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.pre_bid_submitted_my_max);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "pre_bid_submitted_my_max");
        textView2.setText(this.formattedMyMax);
        TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.pre_bid_submitted_stock);
        Intrinsics.checkExpressionValueIsNotNull(textView3, "pre_bid_submitted_stock");
        textView3.setText(this.stockNumber);
        TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.pre_bid_submitted_branch);
        Intrinsics.checkExpressionValueIsNotNull(textView4, "pre_bid_submitted_branch");
        textView4.setText(this.branchName);
        TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.pre_bid_submitted_vehicle_location);
        Intrinsics.checkExpressionValueIsNotNull(textView5, "pre_bid_submitted_vehicle_location");
        textView5.setText(this.vehicleLocation);
        ((Button) _$_findCachedViewById(C2723R.C2726id.pre_bid_submitted_close_button)).setOnClickListener(new PreBidFragment$updatePreBidSubmittedLayoutUI$1(this));
    }

    private final void subscribeToViewModel() {
        PreBidViewModel preBidViewModel = this.viewModel;
        if (preBidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<Boolean> showLoading = preBidViewModel.getShowLoading();
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        showLoading.observe(baseActivity2, new PreBidFragment$subscribeToViewModel$1(this));
        PreBidViewModel preBidViewModel2 = this.viewModel;
        if (preBidViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<PreBidPlacedResult> preBidResultResponse = preBidViewModel2.getPreBidResultResponse();
        BaseActivity baseActivity3 = this.baseActivity;
        if (baseActivity3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        preBidResultResponse.observe(baseActivity3, new PreBidFragment$subscribeToViewModel$2(this));
        PreBidViewModel preBidViewModel3 = this.viewModel;
        if (preBidViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<String> preBidResultError = preBidViewModel3.getPreBidResultError();
        BaseActivity baseActivity4 = this.baseActivity;
        if (baseActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        preBidResultError.observe(baseActivity4, new PreBidFragment$subscribeToViewModel$3(this));
        PreBidViewModel preBidViewModel4 = this.viewModel;
        if (preBidViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<ProductDetailResponse> productDetailResponse = preBidViewModel4.getProductDetailResponse();
        BaseActivity baseActivity5 = this.baseActivity;
        if (baseActivity5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity5 == null) {
            Intrinsics.throwNpe();
        }
        productDetailResponse.observe(baseActivity5, new PreBidFragment$subscribeToViewModel$4(this));
        PreBidViewModel preBidViewModel5 = this.viewModel;
        if (preBidViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        MutableLiveData<ProductDetailErrorModel> productDetailError = preBidViewModel5.getProductDetailError();
        BaseActivity baseActivity6 = this.baseActivity;
        if (baseActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        if (baseActivity6 == null) {
            Intrinsics.throwNpe();
        }
        productDetailError.observe(baseActivity6, new PreBidFragment$subscribeToViewModel$5(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void validateMaxBidAmount(android.view.View r18) {
        /*
            r17 = this;
            r1 = r17
            com.iaai.android.bdt.base.BaseActivity r0 = r1.baseActivity
            if (r0 != 0) goto L_0x000b
            java.lang.String r2 = "baseActivity"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
        L_0x000b:
            android.content.Context r0 = (android.content.Context) r0
            r2 = r18
            com.iaai.android.old.utils.AppUtils.hideSoftkeyBoard(r0, r2)
            int r0 = com.iaai.android.C2723R.C2726id.txt_max_bid
            android.view.View r0 = r1._$_findCachedViewById(r0)
            android.widget.EditText r0 = (android.widget.EditText) r0
            java.lang.String r2 = "txt_max_bid"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            r1.maxBidString = r0
            r2 = 0
            java.lang.String r0 = r1.maxBidString     // Catch:{ Exception -> 0x003b }
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0     // Catch:{ Exception -> 0x003b }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x003b }
            if (r0 != 0) goto L_0x004a
            java.lang.String r0 = r1.maxBidString     // Catch:{ Exception -> 0x003b }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x003b }
            goto L_0x004b
        L_0x003b:
            r0 = move-exception
            r0.printStackTrace()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r3 = "TEST"
            android.util.Log.e(r3, r0)
        L_0x004a:
            r0 = 0
        L_0x004b:
            int r3 = com.iaai.android.C2723R.C2726id.txt_max_bid_layout
            android.view.View r3 = r1._$_findCachedViewById(r3)
            com.google.android.material.textfield.TextInputLayout r3 = (com.google.android.material.textfield.TextInputLayout) r3
            java.lang.String r4 = "txt_max_bid_layout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r4)
            r3.setErrorEnabled(r2)
            double r5 = r1.minBidInt
            int r3 = (int) r5
            java.lang.String r5 = r1.currentBid
            r6 = 0
            if (r5 == 0) goto L_0x0068
            float r5 = java.lang.Float.parseFloat(r5)
            goto L_0x0069
        L_0x0068:
            r5 = 0
        L_0x0069:
            r7 = 1
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0070
        L_0x006e:
            r5 = 1
            goto L_0x0076
        L_0x0070:
            int r5 = r1.startingBid
            if (r5 != 0) goto L_0x0075
            goto L_0x006e
        L_0x0075:
            r5 = 0
        L_0x0076:
            java.lang.String r8 = "getString(R.string.msg_c….string.lbl_pre_bid_max))"
            r9 = 2131821658(0x7f11045a, float:1.9276065E38)
            r10 = 2131821954(0x7f110582, float:1.9276666E38)
            java.lang.String r11 = "$"
            java.lang.String r12 = "current"
            java.lang.String r13 = ""
            r15 = 25
            r16 = 2
            if (r5 == 0) goto L_0x01f9
            java.lang.String r5 = r1.maxBidString
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 == 0) goto L_0x00c2
            java.lang.Object[] r0 = new java.lang.Object[r7]
            java.lang.String r3 = r1.getString(r9)
            r0[r2] = r3
            java.lang.String r0 = r1.getString(r10, r0)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r8)
            int r2 = com.iaai.android.C2723R.C2726id.txt_max_bid_layout
            android.view.View r2 = r1._$_findCachedViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            r2.setErrorEnabled(r7)
            int r2 = com.iaai.android.C2723R.C2726id.txt_max_bid_layout
            android.view.View r2 = r1._$_findCachedViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setError(r0)
            return
        L_0x00c2:
            int r5 = r0 % 25
            if (r5 == 0) goto L_0x00f1
            r0 = 2131821227(0x7f1102ab, float:1.9275191E38)
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r2 = "getString(R.string.lbl_bdt_pre_bid_increment_msg)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            int r2 = com.iaai.android.C2723R.C2726id.txt_max_bid_layout
            android.view.View r2 = r1._$_findCachedViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            r2.setErrorEnabled(r7)
            int r2 = com.iaai.android.C2723R.C2726id.txt_max_bid_layout
            android.view.View r2 = r1._$_findCachedViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setError(r0)
            return
        L_0x00f1:
            if (r3 < r0) goto L_0x01aa
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r13)
            double r8 = r1.minBidInt
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = com.iaai.android.old.utils.p016ui.UiUtils.formatCurrencyFromString(r0, r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r13)
            double r8 = r1.minBidInt
            double r14 = (double) r15
            double r8 = r8 + r14
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = com.iaai.android.old.utils.p016ui.UiUtils.formatCurrencyFromString(r3, r2)
            java.lang.String r8 = r1.currentBid
            if (r8 == 0) goto L_0x0128
            float r8 = java.lang.Float.parseFloat(r8)
            goto L_0x0129
        L_0x0128:
            r8 = 0
        L_0x0129:
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x013e
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r2] = r12
            r6[r7] = r0
            r6[r16] = r3
            r0 = 2131821228(0x7f1102ac, float:1.9275193E38)
            java.lang.String r0 = r1.getString(r0, r6)
            goto L_0x0186
        L_0x013e:
            r6 = 3
            int r8 = r1.startingBid
            if (r8 == 0) goto L_0x0177
            java.lang.Object[] r0 = new java.lang.Object[r6]
            java.lang.String r3 = "starting"
            r0[r2] = r3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            int r3 = r1.startingBid
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0[r7] = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            int r3 = r1.startingBid
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0[r16] = r2
            r5 = 2131821228(0x7f1102ac, float:1.9275193E38)
            java.lang.String r0 = r1.getString(r5, r0)
            goto L_0x0186
        L_0x0177:
            r5 = 2131821228(0x7f1102ac, float:1.9275193E38)
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r2] = r12
            r6[r7] = r0
            r6[r16] = r3
            java.lang.String r0 = r1.getString(r5, r6)
        L_0x0186:
            java.lang.String r2 = "if (amount > 0.0F) {\n   …  }\n                    }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            int r2 = com.iaai.android.C2723R.C2726id.txt_max_bid_layout
            android.view.View r2 = r1._$_findCachedViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            r2.setErrorEnabled(r7)
            int r2 = com.iaai.android.C2723R.C2726id.txt_max_bid_layout
            android.view.View r2 = r1._$_findCachedViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setError(r0)
            return
        L_0x01aa:
            int r0 = com.iaai.android.C2723R.C2726id.place_pre_bid_main_layout
            android.view.View r0 = r1._$_findCachedViewById(r0)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            java.lang.String r3 = "place_pre_bid_main_layout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r3 = 8
            r0.setVisibility(r3)
            int r0 = com.iaai.android.C2723R.C2726id.pre_bid_submitted_layout
            android.view.View r0 = r1._$_findCachedViewById(r0)
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            java.lang.String r4 = "pre_bid_submitted_layout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
            r0.setVisibility(r3)
            int r0 = com.iaai.android.C2723R.C2726id.pre_bid_review_and_confirm_layout
            android.view.View r0 = r1._$_findCachedViewById(r0)
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            java.lang.String r3 = "pre_bid_review_and_confirm_layout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r0.setVisibility(r2)
            int r0 = com.iaai.android.C2723R.C2726id.prebid_review_my_max_bid
            android.view.View r0 = r1._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r3 = "prebid_review_my_max_bid"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.String r3 = r1.maxBidString
            java.lang.String r2 = com.iaai.android.old.utils.p016ui.UiUtils.formatCurrencyFromString(r3, r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            r17.updateReviewConfirmPage()
            goto L_0x0366
        L_0x01f9:
            java.lang.String r14 = r1.maxBidString
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            boolean r14 = android.text.TextUtils.isEmpty(r14)
            if (r14 == 0) goto L_0x0231
            java.lang.Object[] r0 = new java.lang.Object[r7]
            java.lang.String r3 = r1.getString(r9)
            r0[r2] = r3
            java.lang.String r0 = r1.getString(r10, r0)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r8)
            int r2 = com.iaai.android.C2723R.C2726id.txt_max_bid_layout
            android.view.View r2 = r1._$_findCachedViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            r2.setErrorEnabled(r7)
            int r2 = com.iaai.android.C2723R.C2726id.txt_max_bid_layout
            android.view.View r2 = r1._$_findCachedViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setError(r0)
            return
        L_0x0231:
            int r8 = r0 % 25
            if (r8 == 0) goto L_0x0260
            r0 = 2131821227(0x7f1102ab, float:1.9275191E38)
            java.lang.String r0 = r1.getString(r0)
            java.lang.String r2 = "getString(R.string.lbl_bdt_pre_bid_increment_msg)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            int r2 = com.iaai.android.C2723R.C2726id.txt_max_bid_layout
            android.view.View r2 = r1._$_findCachedViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            r2.setErrorEnabled(r7)
            int r2 = com.iaai.android.C2723R.C2726id.txt_max_bid_layout
            android.view.View r2 = r1._$_findCachedViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setError(r0)
            return
        L_0x0260:
            if (r3 <= r0) goto L_0x0319
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r13)
            double r8 = r1.minBidInt
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.String r0 = com.iaai.android.old.utils.p016ui.UiUtils.formatCurrencyFromString(r0, r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r13)
            double r8 = r1.minBidInt
            double r13 = (double) r15
            double r8 = r8 + r13
            r3.append(r8)
            java.lang.String r3 = r3.toString()
            java.lang.String r3 = com.iaai.android.old.utils.p016ui.UiUtils.formatCurrencyFromString(r3, r2)
            java.lang.String r8 = r1.currentBid
            if (r8 == 0) goto L_0x0297
            float r8 = java.lang.Float.parseFloat(r8)
            goto L_0x0298
        L_0x0297:
            r8 = 0
        L_0x0298:
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x02ad
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r2] = r12
            r6[r7] = r0
            r6[r16] = r3
            r0 = 2131821228(0x7f1102ac, float:1.9275193E38)
            java.lang.String r0 = r1.getString(r0, r6)
            goto L_0x02f5
        L_0x02ad:
            r6 = 3
            int r8 = r1.startingBid
            if (r8 == 0) goto L_0x02e6
            java.lang.Object[] r0 = new java.lang.Object[r6]
            java.lang.String r3 = "starting"
            r0[r2] = r3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            int r3 = r1.startingBid
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0[r7] = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r11)
            int r3 = r1.startingBid
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0[r16] = r2
            r5 = 2131821228(0x7f1102ac, float:1.9275193E38)
            java.lang.String r0 = r1.getString(r5, r0)
            goto L_0x02f5
        L_0x02e6:
            r5 = 2131821228(0x7f1102ac, float:1.9275193E38)
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r2] = r12
            r6[r7] = r0
            r6[r16] = r3
            java.lang.String r0 = r1.getString(r5, r6)
        L_0x02f5:
            java.lang.String r2 = "if (amount > 0.0F) {\n   …  }\n                    }"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            int r2 = com.iaai.android.C2723R.C2726id.txt_max_bid_layout
            android.view.View r2 = r1._$_findCachedViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            r2.setErrorEnabled(r7)
            int r2 = com.iaai.android.C2723R.C2726id.txt_max_bid_layout
            android.view.View r2 = r1._$_findCachedViewById(r2)
            com.google.android.material.textfield.TextInputLayout r2 = (com.google.android.material.textfield.TextInputLayout) r2
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r2, r4)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r2.setError(r0)
            return
        L_0x0319:
            int r0 = com.iaai.android.C2723R.C2726id.place_pre_bid_main_layout
            android.view.View r0 = r1._$_findCachedViewById(r0)
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            java.lang.String r3 = "place_pre_bid_main_layout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r3 = 8
            r0.setVisibility(r3)
            int r0 = com.iaai.android.C2723R.C2726id.pre_bid_submitted_layout
            android.view.View r0 = r1._$_findCachedViewById(r0)
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            java.lang.String r4 = "pre_bid_submitted_layout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
            r0.setVisibility(r3)
            int r0 = com.iaai.android.C2723R.C2726id.pre_bid_review_and_confirm_layout
            android.view.View r0 = r1._$_findCachedViewById(r0)
            android.widget.ScrollView r0 = (android.widget.ScrollView) r0
            java.lang.String r3 = "pre_bid_review_and_confirm_layout"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r0.setVisibility(r2)
            int r0 = com.iaai.android.C2723R.C2726id.prebid_review_my_max_bid
            android.view.View r0 = r1._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r3 = "prebid_review_my_max_bid"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            java.lang.String r3 = r1.maxBidString
            java.lang.String r2 = com.iaai.android.old.utils.p016ui.UiUtils.formatCurrencyFromString(r3, r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            r17.updateReviewConfirmPage()
        L_0x0366:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.productDetail.prebid.PreBidFragment.validateMaxBidAmount(android.view.View):void");
    }

    private final void updateReviewConfirmPage() {
        String str;
        if (this.isTimedAuction) {
            str = getResources().getString(C2723R.string.lbl_bid_bdt);
        } else {
            str = getResources().getString(C2723R.string.lbl_pre_bid_bdt);
        }
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.textView5);
        Intrinsics.checkExpressionValueIsNotNull(textView, "textView5");
        Resources resources = getResources();
        Object[] objArr = new Object[2];
        Intrinsics.checkExpressionValueIsNotNull(str, "buttonText");
        if (str != null) {
            String lowerCase = str.toLowerCase();
            Intrinsics.checkExpressionValueIsNotNull(lowerCase, "(this as java.lang.String).toLowerCase()");
            objArr[0] = lowerCase;
            objArr[1] = str;
            textView.setText(resources.getString(C2723R.string.lbl_bdt_pre_bid_confirm_text, objArr));
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btn_pre_bid_confirm);
            Intrinsics.checkExpressionValueIsNotNull(button, "btn_pre_bid_confirm");
            button.setText(getResources().getString(C2723R.string.lbl_bdt_pre_bid_confirm_pre_bid, new Object[]{str}));
            if (this.isTimedAuction) {
                IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
                String value = IAAAnalytics.IAAScreenName.TIME_AUCTION_BID_CONFIRMATION.getValue();
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
                iAAAnalytics.logScreenName(value, activity, this);
                return;
            }
            IAAAnalytics iAAAnalytics2 = IAAAnalytics.INSTANCE;
            String value2 = IAAAnalytics.IAAScreenName.PRE_BID_CONFIRMATION.getValue();
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(activity2, "activity!!");
            iAAAnalytics2.logScreenName(value2, activity2, this);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    /* access modifiers changed from: private */
    public final void handlePlaceBidResult(PreBidPlacedResult preBidPlacedResult) {
        Boolean valueOf = preBidPlacedResult != null ? Boolean.valueOf(preBidPlacedResult.getIsSuccessful()) : null;
        if (valueOf == null) {
            Intrinsics.throwNpe();
        }
        if (valueOf.booleanValue()) {
            EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.txt_max_bid);
            Intrinsics.checkExpressionValueIsNotNull(editText, "txt_max_bid");
            String obj = editText.getText().toString();
            ScrollView scrollView = (ScrollView) _$_findCachedViewById(C2723R.C2726id.pre_bid_review_and_confirm_layout);
            Intrinsics.checkExpressionValueIsNotNull(scrollView, "pre_bid_review_and_confirm_layout");
            scrollView.setVisibility(8);
            FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C2723R.C2726id.place_pre_bid_main_layout);
            Intrinsics.checkExpressionValueIsNotNull(frameLayout, "place_pre_bid_main_layout");
            frameLayout.setVisibility(8);
            ScrollView scrollView2 = (ScrollView) _$_findCachedViewById(C2723R.C2726id.pre_bid_submitted_layout);
            Intrinsics.checkExpressionValueIsNotNull(scrollView2, "pre_bid_submitted_layout");
            scrollView2.setVisibility(0);
            updateBidSubmittedUI();
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.pre_bid_submitted_my_max);
            Intrinsics.checkExpressionValueIsNotNull(textView, "pre_bid_submitted_my_max");
            textView.setText(UiUtils.formatCurrencyFromString(obj, false));
            if (this.isTimedAuction) {
                IAAAnalytics iAAAnalytics = IAAAnalytics.INSTANCE;
                String value = IAAAnalytics.IAAScreenName.TIME_AUCTION_BID_COMPLETED.getValue();
                FragmentActivity activity = getActivity();
                if (activity == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(activity, "activity!!");
                iAAAnalytics.logScreenName(value, activity, this);
                return;
            }
            IAAAnalytics iAAAnalytics2 = IAAAnalytics.INSTANCE;
            String value2 = IAAAnalytics.IAAScreenName.PRE_BID_COMPLETED.getValue();
            FragmentActivity activity2 = getActivity();
            if (activity2 == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(activity2, "activity!!");
            iAAAnalytics2.logScreenName(value2, activity2, this);
            return;
        }
        ScrollView scrollView3 = (ScrollView) _$_findCachedViewById(C2723R.C2726id.pre_bid_review_and_confirm_layout);
        Intrinsics.checkExpressionValueIsNotNull(scrollView3, "pre_bid_review_and_confirm_layout");
        scrollView3.setVisibility(8);
        ScrollView scrollView4 = (ScrollView) _$_findCachedViewById(C2723R.C2726id.pre_bid_submitted_layout);
        Intrinsics.checkExpressionValueIsNotNull(scrollView4, "pre_bid_submitted_layout");
        scrollView4.setVisibility(8);
        FrameLayout frameLayout2 = (FrameLayout) _$_findCachedViewById(C2723R.C2726id.place_pre_bid_main_layout);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout2, "place_pre_bid_main_layout");
        frameLayout2.setVisibility(0);
        TextInputLayout textInputLayout = (TextInputLayout) _$_findCachedViewById(C2723R.C2726id.txt_max_bid_layout);
        Intrinsics.checkExpressionValueIsNotNull(textInputLayout, "txt_max_bid_layout");
        textInputLayout.setErrorEnabled(true);
        TextInputLayout textInputLayout2 = (TextInputLayout) _$_findCachedViewById(C2723R.C2726id.txt_max_bid_layout);
        Intrinsics.checkExpressionValueIsNotNull(textInputLayout2, "txt_max_bid_layout");
        textInputLayout2.setError(preBidPlacedResult.getBidding());
    }

    private final void updateBidSubmittedUI() {
        String str;
        if (this.isTimedAuction) {
            str = getResources().getString(C2723R.string.lbl_bid_bdt);
        } else {
            str = getResources().getString(C2723R.string.lbl_pre_bid_bdt);
        }
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvSubmitted);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvSubmitted");
        Resources resources = getResources();
        Object[] objArr = new Object[1];
        Intrinsics.checkExpressionValueIsNotNull(str, "submittedText");
        if (str != null) {
            String upperCase = str.toUpperCase();
            Intrinsics.checkExpressionValueIsNotNull(upperCase, "(this as java.lang.String).toUpperCase()");
            objArr[0] = upperCase;
            textView.setText(resources.getString(C2723R.string.lbl_bdt_pre_bid_submitted_title, objArr));
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.textView18);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "textView18");
            textView2.setText(getResources().getString(C2723R.string.lbl_bdt_pre_bid_submitted_msg, new Object[]{str}));
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    public void onDestroy() {
        super.onDestroy();
        PreBidViewModel preBidViewModel = this.viewModel;
        if (preBidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        preBidViewModel.disposeElements();
    }

    private final void updateUI() {
        if (this.isTimedAuction) {
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.prebid_submit_button);
            Intrinsics.checkExpressionValueIsNotNull(button, "prebid_submit_button");
            button.setText(getResources().getString(C2723R.string.lbl_bdt_submit_bid));
        } else {
            Button button2 = (Button) _$_findCachedViewById(C2723R.C2726id.prebid_submit_button);
            Intrinsics.checkExpressionValueIsNotNull(button2, "prebid_submit_button");
            button2.setText(getResources().getString(C2723R.string.lbl_bdt_submit_pre_bid));
        }
        if (this.displaySaleTaxWarning) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.textView2);
            Intrinsics.checkExpressionValueIsNotNull(textView, "textView2");
            textView.setVisibility(0);
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_go_to_tax_form);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "prebid_go_to_tax_form");
            textView2.setVisibility(0);
            SpannableString spannableString = new SpannableString("Go to Tax Forms");
            spannableString.setSpan(new UnderlineSpan(), 0, 15, 0);
            TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.prebid_go_to_tax_form);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "prebid_go_to_tax_form");
            textView3.setText(spannableString);
            TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_prebid_sales_text_msg);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "tv_prebid_sales_text_msg");
            textView4.setVisibility(0);
            TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_prebid_sales_text_msg);
            Intrinsics.checkExpressionValueIsNotNull(textView5, "tv_prebid_sales_text_msg");
            textView5.setText(this.displaySaleTextMessage);
        }
    }

    private final void fetchProductDetail() {
        PreBidViewModel preBidViewModel = this.viewModel;
        if (preBidViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        preBidViewModel.getProductDetail(this.itemId, this.userId);
        subscribeToViewModel();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003a, code lost:
        r1 = r4.getPrebidInformation();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initializeDataPoints(com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailResponse r4) {
        /*
            r3 = this;
            java.lang.String r0 = ""
            if (r4 == 0) goto L_0x0011
            com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation r1 = r4.getPrebidInformation()
            if (r1 == 0) goto L_0x0011
            java.lang.String r1 = r1.getMyMax()
            if (r1 == 0) goto L_0x0011
            goto L_0x0012
        L_0x0011:
            r1 = r0
        L_0x0012:
            r3.myMax = r1
            if (r4 == 0) goto L_0x0023
            com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation r1 = r4.getPrebidInformation()
            if (r1 == 0) goto L_0x0023
            java.lang.String r1 = r1.getFormattedMyMax()
            if (r1 == 0) goto L_0x0023
            goto L_0x0024
        L_0x0023:
            r1 = r0
        L_0x0024:
            r3.formattedMyMax = r1
            if (r4 == 0) goto L_0x0035
            com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation r1 = r4.getPrebidInformation()
            if (r1 == 0) goto L_0x0035
            java.lang.String r1 = r1.getPrebidPopupErrorMessage()
            if (r1 == 0) goto L_0x0035
            goto L_0x0036
        L_0x0035:
            r1 = r0
        L_0x0036:
            r3.preBidPopErrorMessage = r1
            if (r4 == 0) goto L_0x0045
            com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation r1 = r4.getPrebidInformation()
            if (r1 == 0) goto L_0x0045
            int r1 = r1.getStartBid()
            goto L_0x0046
        L_0x0045:
            r1 = 0
        L_0x0046:
            r3.startingBid = r1
            if (r4 == 0) goto L_0x0057
            com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation r1 = r4.getPrebidInformation()
            if (r1 == 0) goto L_0x0057
            java.lang.String r1 = r1.getDecimalHighBidAmount()
            if (r1 == 0) goto L_0x0057
            r0 = r1
        L_0x0057:
            r3.currentBid = r0
            r0 = 0
            if (r4 == 0) goto L_0x006d
            com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation r1 = r4.getPrebidInformation()
            if (r1 == 0) goto L_0x006d
            java.lang.String r1 = r1.getDecimalHighBidAmount()
            if (r1 == 0) goto L_0x006d
            float r1 = java.lang.Float.parseFloat(r1)
            goto L_0x006e
        L_0x006d:
            r1 = 0
        L_0x006e:
            r2 = 0
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0080
            if (r4 == 0) goto L_0x009d
            com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation r4 = r4.getPrebidInformation()
            if (r4 == 0) goto L_0x009d
            java.lang.String r2 = r4.getOutBidAmountNeededText()
            goto L_0x009d
        L_0x0080:
            int r0 = r3.startingBid
            if (r0 == 0) goto L_0x0091
            if (r4 == 0) goto L_0x009d
            com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation r4 = r4.getPrebidInformation()
            if (r4 == 0) goto L_0x009d
            java.lang.String r2 = r4.getStartingBidAmountNeededText()
            goto L_0x009d
        L_0x0091:
            if (r4 == 0) goto L_0x009d
            com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation r4 = r4.getPrebidInformation()
            if (r4 == 0) goto L_0x009d
            java.lang.String r2 = r4.getOutBidAmountNeededText()
        L_0x009d:
            r3.incrementBid = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.productDetail.prebid.PreBidFragment.initializeDataPoints(com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailResponse):void");
    }

    /* access modifiers changed from: private */
    public final void displayUI() {
        FrameLayout frameLayout = (FrameLayout) _$_findCachedViewById(C2723R.C2726id.place_pre_bid_main_layout);
        Intrinsics.checkExpressionValueIsNotNull(frameLayout, "place_pre_bid_main_layout");
        frameLayout.setVisibility(0);
        updatePreBidMainLayoutUI();
        updateReviewConfrimLayoutUI();
        updatePreBidSubmittedLayoutUI();
    }
}
