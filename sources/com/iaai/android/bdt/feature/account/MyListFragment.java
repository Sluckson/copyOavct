package com.iaai.android.bdt.feature.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.MedalliaCustomParameters;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListActivity;
import com.iaai.android.bdt.feature.account.salesdocument.SalesDocumentActivity;
import com.iaai.android.bdt.feature.account.tobepickedup.ToPickedUpAccountActivity;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListActivity;
import com.iaai.android.bdt.feature.account.watchlist.PreSaleListStatus;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.MyAccount.BDTDashboardResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.databinding.AcivityMyAccountListBinding;
import com.iaai.android.old.activities.AlertListActivity;
import com.iaai.android.old.activities.MDToBePaidListActivity;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.UiUtils;
import com.medallia.digital.mobilesdk.MedalliaDigital;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u000267B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0018H\u0002J\b\u0010\u001f\u001a\u00020\u0018H\u0002J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0012\u0010%\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020*H\u0016J\u0012\u0010+\u001a\u00020\u00182\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J&\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u00102\u001a\u00020\u0018H\u0016J\b\u00103\u001a\u00020\u0018H\u0002J\b\u00104\u001a\u00020\u0018H\u0002J\u0010\u00105\u001a\u00020\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000¨\u00068"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/MyListFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "baseActivity", "Lcom/iaai/android/bdt/base/BaseActivity;", "bdtDashboardResponse", "Lcom/iaai/android/bdt/model/MyAccount/BDTDashboardResponse;", "getBdtDashboardResponse", "()Lcom/iaai/android/bdt/model/MyAccount/BDTDashboardResponse;", "setBdtDashboardResponse", "(Lcom/iaai/android/bdt/model/MyAccount/BDTDashboardResponse;)V", "buyNowOfferCount", "", "jsonDashBoardString", "", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "showMyVehicle", "", "handleRowSelection", "", "navigateToAwardPendingList", "myItemOnly", "navigateToBePaidList", "navigateToBuyNowOffer", "navigateToLostPreBidList", "navigateToManageOffer", "navigateToNotificationList", "navigateToPreBidList", "navigateToPurchaseHistory", "navigateToSalesDocumentList", "navigateToTBPickUpList", "navigateToWatchingList", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onResume", "setCustomParameterForMedallia", "updateMYAccountNewCount", "updateView", "Companion", "OnRowClickListener", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MyListFragment.kt */
public final class MyListFragment extends BaseFragment {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String KEY_SAMPLE = "sample";
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public BaseActivity baseActivity;
    @NotNull
    public BDTDashboardResponse bdtDashboardResponse;
    private int buyNowOfferCount;
    private String jsonDashBoardString = "";
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private boolean showMyVehicle;

    @JvmStatic
    @NotNull
    public static final MyListFragment newInstance(@NotNull String str) {
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

    public static final /* synthetic */ BaseActivity access$getBaseActivity$p(MyListFragment myListFragment) {
        BaseActivity baseActivity2 = myListFragment.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        return baseActivity2;
    }

    @NotNull
    public final BDTDashboardResponse getBdtDashboardResponse() {
        BDTDashboardResponse bDTDashboardResponse = this.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        return bDTDashboardResponse;
    }

    public final void setBdtDashboardResponse(@NotNull BDTDashboardResponse bDTDashboardResponse) {
        Intrinsics.checkParameterIsNotNull(bDTDashboardResponse, "<set-?>");
        this.bdtDashboardResponse = bDTDashboardResponse;
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/MyListFragment$Companion;", "", "()V", "KEY_SAMPLE", "", "newInstance", "Lcom/iaai/android/bdt/feature/account/MyListFragment;", "url", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: MyListFragment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final MyListFragment newInstance(@NotNull String str) {
            Intrinsics.checkParameterIsNotNull(str, "url");
            MyListFragment myListFragment = new MyListFragment();
            Bundle bundle = new Bundle();
            bundle.putString(MyListFragment.KEY_SAMPLE, str);
            myListFragment.setArguments(bundle);
            return myListFragment;
        }
    }

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        AcivityMyAccountListBinding acivityMyAccountListBinding = (AcivityMyAccountListBinding) DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.acivity_my_account_list, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(acivityMyAccountListBinding, "mBinding");
        return acivityMyAccountListBinding.getRoot();
    }

    public void onAttach(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.baseActivity = (BaseActivity) activity;
            if (context instanceof BDTMyAccountActivity) {
                this.baseActivity = (BaseActivity) context;
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.base.BaseActivity");
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        Bundle arguments = getArguments();
        if (arguments == null) {
            Intrinsics.throwNpe();
        }
        this.jsonDashBoardString = arguments.getString(Constants_MVVM.BDT_DASHBOARD_RESPONSE);
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            Intrinsics.throwNpe();
        }
        this.buyNowOfferCount = arguments2.getInt(Constants_MVVM.BDT_BUY_NOW_OFFER_COUNT);
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            Intrinsics.throwNpe();
        }
        this.showMyVehicle = arguments3.getBoolean(Constants_MVVM.BDT_SHOW_MY_VEHICLE);
        Object fromJson = new Gson().fromJson(this.jsonDashBoardString, BDTDashboardResponse.class);
        Intrinsics.checkExpressionValueIsNotNull(fromJson, "gson.fromJson<BDTDashboa…oardResponse::class.java)");
        this.bdtDashboardResponse = (BDTDashboardResponse) fromJson;
        BDTDashboardResponse bDTDashboardResponse = this.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        updateView(bDTDashboardResponse);
        handleRowSelection();
        if (this.showMyVehicle) {
            Switch switchR = (Switch) _$_findCachedViewById(C2723R.C2726id.show_vehicle_switch);
            Intrinsics.checkExpressionValueIsNotNull(switchR, Constants_MVVM.BROADCAST_VEHICLE_SWITCH_CHANGED);
            switchR.setChecked(true);
        }
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.rl_feedback)).setOnClickListener(new MyListFragment$onActivityCreated$1(this));
    }

    /* access modifiers changed from: private */
    public final void setCustomParameterForMedallia() {
        int i;
        int i2;
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.PAGE_NAME.getId(), "My Account");
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        CharSequence currentSessionUserId = sessionManager2.getCurrentSessionUserId();
        boolean z = true;
        int i3 = 0;
        if (!(currentSessionUserId == null || currentSessionUserId.length() == 0)) {
            SessionManager sessionManager3 = this.sessionManager;
            if (sessionManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            i = Integer.parseInt(sessionManager3.getCurrentSessionUserId());
        } else {
            i = 0;
        }
        SessionManager sessionManager4 = this.sessionManager;
        if (sessionManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        if (sessionManager4.getCurrentSessionBuyerId() != null) {
            SessionManager sessionManager5 = this.sessionManager;
            if (sessionManager5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            if (Intrinsics.areEqual((Object) sessionManager5.getCurrentSessionBuyerId(), (Object) "0")) {
                MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.EMPLOYER_ID.getId(), 0);
                MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.BUYER_ID.getId(), 0);
                MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.USER_ID.getId(), Integer.valueOf(i));
                return;
            }
        }
        SessionManager sessionManager6 = this.sessionManager;
        if (sessionManager6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        CharSequence currentSessionBuyerId = sessionManager6.getCurrentSessionBuyerId();
        if (!(currentSessionBuyerId == null || currentSessionBuyerId.length() == 0)) {
            SessionManager sessionManager7 = this.sessionManager;
            if (sessionManager7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            i2 = Integer.parseInt(sessionManager7.getCurrentSessionBuyerId());
        } else {
            i2 = 0;
        }
        SessionManager sessionManager8 = this.sessionManager;
        if (sessionManager8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        CharSequence buyerEmployeeId = sessionManager8.getBuyerEmployeeId();
        if (!(buyerEmployeeId == null || buyerEmployeeId.length() == 0)) {
            z = false;
        }
        if (!z) {
            SessionManager sessionManager9 = this.sessionManager;
            if (sessionManager9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            i3 = Integer.parseInt(sessionManager9.getBuyerEmployeeId());
        }
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.EMPLOYER_ID.getId(), Integer.valueOf(i3));
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.BUYER_ID.getId(), Integer.valueOf(i2));
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.USER_ID.getId(), Integer.valueOf(i));
    }

    private final void handleRowSelection() {
        View.OnClickListener onRowClickListener = new OnRowClickListener();
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_watching)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_pre_bid)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_purchase_history)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_award_pending)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_manage_offer)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_tobe_paid)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_tobe_pickedup)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_lost_pre_bid)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_notification)).setOnClickListener(onRowClickListener);
        if (this.buyNowOfferCount > 0) {
            ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_buy_now_offer)).setOnClickListener(onRowClickListener);
        }
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_sale_document)).setOnClickListener(onRowClickListener);
        ((Switch) _$_findCachedViewById(C2723R.C2726id.show_vehicle_switch)).setOnClickListener(new MyListFragment$handleRowSelection$1(this));
        ((Button) _$_findCachedViewById(C2723R.C2726id.btn_upgrade_now)).setOnClickListener(new MyListFragment$handleRowSelection$2(this));
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/MyListFragment$OnRowClickListener;", "Landroid/view/View$OnClickListener;", "(Lcom/iaai/android/bdt/feature/account/MyListFragment;)V", "onClick", "", "view", "Landroid/view/View;", "showMyVehicles", "viewId", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: MyListFragment.kt */
    private final class OnRowClickListener implements View.OnClickListener {
        public OnRowClickListener() {
        }

        public void onClick(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            showMyVehicles(view.getId());
        }

        private final void showMyVehicles(int i) {
            boolean z;
            boolean z2;
            if (MyListFragment.this.getSessionManager().isCurrentSessionUserOwner()) {
                Switch switchR = (Switch) MyListFragment.this._$_findCachedViewById(C2723R.C2726id.show_vehicle_switch);
                Intrinsics.checkExpressionValueIsNotNull(switchR, Constants_MVVM.BROADCAST_VEHICLE_SWITCH_CHANGED);
                z = switchR.isChecked();
            } else {
                z = true;
            }
            int i2 = 0;
            switch (i) {
                case C2723R.C2726id.rl_award_pending:
                    Integer awardPending = MyListFragment.this.getBdtDashboardResponse().getAwardPending();
                    if (awardPending != null) {
                        i2 = awardPending.intValue();
                    }
                    if (i2 > 0) {
                        MyListFragment.this.navigateToAwardPendingList(z);
                        return;
                    }
                    return;
                case C2723R.C2726id.rl_buy_now_offer:
                    if (!MyListFragment.this.getSessionManager().promptForLoginIfNeedFromActivity(MyListFragment.access$getBaseActivity$p(MyListFragment.this), MyListFragment.access$getBaseActivity$p(MyListFragment.this), 36)) {
                        MyListFragment.this.navigateToBuyNowOffer();
                        return;
                    }
                    return;
                case C2723R.C2726id.rl_lost_pre_bid:
                    MyListFragment.this.navigateToLostPreBidList(z);
                    return;
                case C2723R.C2726id.rl_manage_offer:
                    Integer negotiationOffers = MyListFragment.this.getBdtDashboardResponse().getNegotiationOffers();
                    if (negotiationOffers != null) {
                        i2 = negotiationOffers.intValue();
                    }
                    if (i2 > 0 && !MyListFragment.this.getSessionManager().promptForLoginIfNeedFromActivity(MyListFragment.access$getBaseActivity$p(MyListFragment.this), MyListFragment.access$getBaseActivity$p(MyListFragment.this), 35)) {
                        MyListFragment.this.navigateToManageOffer();
                        return;
                    }
                    return;
                case C2723R.C2726id.rl_notification:
                    MyListFragment.this.navigateToNotificationList();
                    return;
                case C2723R.C2726id.rl_pre_bid:
                    Integer winningPrebids = MyListFragment.this.getBdtDashboardResponse().getWinningPrebids();
                    if (winningPrebids != null) {
                        i2 = winningPrebids.intValue();
                    }
                    if (i2 > 0) {
                        MyListFragment.this.navigateToPreBidList(z);
                        return;
                    }
                    return;
                case C2723R.C2726id.rl_purchase_history:
                    MyListFragment.this.navigateToPurchaseHistory(z);
                    return;
                case C2723R.C2726id.rl_sale_document:
                    MyListFragment.this.navigateToSalesDocumentList();
                    return;
                case C2723R.C2726id.rl_tobe_paid:
                    if (MyListFragment.this.getSessionManager().isCurrentSessionUserOwner()) {
                        Switch switchR2 = (Switch) MyListFragment.this._$_findCachedViewById(C2723R.C2726id.show_vehicle_switch);
                        Intrinsics.checkExpressionValueIsNotNull(switchR2, Constants_MVVM.BROADCAST_VEHICLE_SWITCH_CHANGED);
                        z2 = switchR2.isChecked();
                    } else {
                        z2 = true;
                    }
                    String str = z2 ? IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE : "0";
                    Integer countofvehicles = MyListFragment.this.getBdtDashboardResponse().getCountofvehicles();
                    if (countofvehicles != null) {
                        i2 = countofvehicles.intValue();
                    }
                    if (i2 > 0) {
                        MyListFragment.this.navigateToBePaidList(str);
                        return;
                    }
                    return;
                case C2723R.C2726id.rl_tobe_pickedup:
                    Integer pickup = MyListFragment.this.getBdtDashboardResponse().getPickup();
                    if (pickup != null) {
                        i2 = pickup.intValue();
                    }
                    if (i2 > 0) {
                        MyListFragment.this.navigateToTBPickUpList(z);
                        return;
                    }
                    return;
                case C2723R.C2726id.rl_watching:
                    Integer watching = MyListFragment.this.getBdtDashboardResponse().getWatching();
                    if (watching != null) {
                        i2 = watching.intValue();
                    }
                    if (i2 > 0) {
                        MyListFragment.this.navigateToWatchingList(z);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: private */
    public final void navigateToNotificationList() {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        Intent intent = new Intent(baseActivity2, AlertListActivity.class);
        String str = Constants.WATCHING_SIZE;
        BDTDashboardResponse bDTDashboardResponse = this.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        intent.putExtra(str, bDTDashboardResponse.getAlerts());
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void navigateToSalesDocumentList() {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        startActivity(new Intent(baseActivity2, SalesDocumentActivity.class));
    }

    /* access modifiers changed from: private */
    public final void navigateToManageOffer() {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        Intent intent = new Intent(baseActivity2, ManageOfferListActivity.class);
        BDTDashboardResponse bDTDashboardResponse = this.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        if (bDTDashboardResponse != null) {
            BDTDashboardResponse bDTDashboardResponse2 = this.bdtDashboardResponse;
            if (bDTDashboardResponse2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
            }
            intent.putExtra(Constants_MVVM.EXTRA_MANAGE_OFFERS, bDTDashboardResponse2.getNegotiationOffers());
        }
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void navigateToWatchingList(boolean z) {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        Intent intent = new Intent(baseActivity2, PreSaleListActivity.class);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("status", PreSaleListStatus.WATCHING_LIST.getValue());
        intent.putExtra("isMyItemOnly", z);
        String str = Constants.WATCHING_SIZE;
        BDTDashboardResponse bDTDashboardResponse = this.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        intent.putExtra(str, bDTDashboardResponse.getWatching());
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void navigateToPreBidList(boolean z) {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        Intent intent = new Intent(baseActivity2, PreSaleListActivity.class);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("status", PreSaleListStatus.PRE_BID.getValue());
        intent.putExtra("isMyItemOnly", z);
        String str = Constants.WATCHING_SIZE;
        BDTDashboardResponse bDTDashboardResponse = this.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        intent.putExtra(str, bDTDashboardResponse.getWinningPrebids());
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void navigateToAwardPendingList(boolean z) {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        Intent intent = new Intent(baseActivity2, PreSaleListActivity.class);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("status", PreSaleListStatus.AWARD_PENDING.getValue());
        intent.putExtra("isMyItemOnly", z);
        String str = Constants.WATCHING_SIZE;
        BDTDashboardResponse bDTDashboardResponse = this.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        intent.putExtra(str, bDTDashboardResponse.getAwardPending());
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void navigateToBuyNowOffer() {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        Intent intent = new Intent(baseActivity2, BuyNowOfferListActivity.class);
        intent.putExtra(Constants.KEY_FOR_BUY_NOW_OFFER_COUNT_MYACCOUNT, this.buyNowOfferCount);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void navigateToTBPickUpList(boolean z) {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        Intent intent = new Intent(baseActivity2, ToPickedUpAccountActivity.class);
        intent.putExtra("isMyItemOnly", z);
        BDTDashboardResponse bDTDashboardResponse = this.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        if (bDTDashboardResponse != null) {
            String str = Constants.WATCHING_SIZE;
            BDTDashboardResponse bDTDashboardResponse2 = this.bdtDashboardResponse;
            if (bDTDashboardResponse2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
            }
            intent.putExtra(str, bDTDashboardResponse2.getPickup());
        }
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void navigateToPurchaseHistory(boolean z) {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        Intent intent = new Intent(baseActivity2, PreSaleListActivity.class);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("status", PreSaleListStatus.PURCHASE_HISTORY.getValue());
        String str = Constants.WATCHING_SIZE;
        BDTDashboardResponse bDTDashboardResponse = this.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        intent.putExtra(str, bDTDashboardResponse.getWon());
        intent.putExtra("isMyItemOnly", z);
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void navigateToLostPreBidList(boolean z) {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        Intent intent = new Intent(baseActivity2, PreSaleListActivity.class);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.putExtra("status", PreSaleListStatus.LOST_PREBID.getValue());
        intent.putExtra("isMyItemOnly", z);
        String str = Constants.WATCHING_SIZE;
        BDTDashboardResponse bDTDashboardResponse = this.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        intent.putExtra(str, bDTDashboardResponse.getLost());
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public final void navigateToBePaidList(String str) {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        Intent intent = new Intent(baseActivity2, MDToBePaidListActivity.class);
        BDTDashboardResponse bDTDashboardResponse = this.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        if (bDTDashboardResponse != null) {
            String str2 = Constants.WATCHING_SIZE;
            BDTDashboardResponse bDTDashboardResponse2 = this.bdtDashboardResponse;
            if (bDTDashboardResponse2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
            }
            intent.putExtra(str2, bDTDashboardResponse2.getCountofvehicles());
            BDTDashboardResponse bDTDashboardResponse3 = this.bdtDashboardResponse;
            if (bDTDashboardResponse3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
            }
            intent.putExtra(Constants.EXTRA_AWARD_PENDING_COUNT, bDTDashboardResponse3.getAwardPending());
            BDTDashboardResponse bDTDashboardResponse4 = this.bdtDashboardResponse;
            if (bDTDashboardResponse4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
            }
            intent.putExtra(Constants.EXTRA_TOBPAID_TOTAL_DUE, UiUtils.formatCurrency(bDTDashboardResponse4.getTotaltobePaid(), true));
            BDTDashboardResponse bDTDashboardResponse5 = this.bdtDashboardResponse;
            if (bDTDashboardResponse5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
            }
            intent.putExtra(Constants.EXTRA_TOBPAID_AW_AMOUNT, UiUtils.formatCurrency(bDTDashboardResponse5.getTotalAwardPending(), false));
        }
        intent.putExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY, str);
        startActivity(intent);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0162  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0182  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0187  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01a4  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x01ed  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x020f  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x022c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateView(com.iaai.android.bdt.model.MyAccount.BDTDashboardResponse r12) {
        /*
            r11 = this;
            com.iaai.android.bdt.feature.login.SessionManager r0 = r11.sessionManager
            java.lang.String r1 = "sessionManager"
            if (r0 != 0) goto L_0x0009
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0009:
            java.lang.String r0 = r0.getCurrentSessionBuyerId()
            java.lang.String r2 = "rl_pre_bid"
            java.lang.String r3 = "ll_guest_user"
            java.lang.String r4 = "ll_post_sale_container"
            java.lang.String r5 = "ll_notification_container"
            java.lang.String r6 = "ll_history_container"
            java.lang.String r7 = "rl_manage_offer"
            r8 = 8
            r9 = 0
            if (r0 == 0) goto L_0x0086
            com.iaai.android.bdt.feature.login.SessionManager r0 = r11.sessionManager
            if (r0 != 0) goto L_0x0025
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x0025:
            java.lang.String r0 = r0.getCurrentSessionBuyerId()
            java.lang.String r10 = "0"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r10)
            if (r0 == 0) goto L_0x0086
            int r0 = com.iaai.android.C2723R.C2726id.rl_manage_offer
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
            r0.setVisibility(r8)
            int r0 = com.iaai.android.C2723R.C2726id.rl_pre_bid
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            r0.setVisibility(r8)
            int r0 = com.iaai.android.C2723R.C2726id.ll_history_container
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            r0.setVisibility(r8)
            int r0 = com.iaai.android.C2723R.C2726id.ll_notification_container
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
            r0.setVisibility(r8)
            int r0 = com.iaai.android.C2723R.C2726id.ll_post_sale_container
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
            r0.setVisibility(r8)
            int r0 = com.iaai.android.C2723R.C2726id.ll_guest_user
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r0.setVisibility(r9)
            goto L_0x00da
        L_0x0086:
            int r0 = com.iaai.android.C2723R.C2726id.rl_manage_offer
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r7)
            r0.setVisibility(r9)
            int r0 = com.iaai.android.C2723R.C2726id.ll_history_container
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r6)
            r0.setVisibility(r9)
            int r0 = com.iaai.android.C2723R.C2726id.ll_notification_container
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r5)
            r0.setVisibility(r9)
            int r0 = com.iaai.android.C2723R.C2726id.ll_post_sale_container
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r4)
            r0.setVisibility(r9)
            int r0 = com.iaai.android.C2723R.C2726id.ll_guest_user
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r0.setVisibility(r8)
            int r0 = com.iaai.android.C2723R.C2726id.rl_pre_bid
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            r0.setVisibility(r9)
        L_0x00da:
            com.iaai.android.bdt.feature.login.SessionManager r0 = r11.sessionManager
            if (r0 != 0) goto L_0x00e1
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x00e1:
            boolean r0 = r0.isCurrentSessionUserOwner()
            java.lang.String r2 = "view_switch"
            java.lang.String r3 = "showMYVehicleRelativeLayout"
            if (r0 == 0) goto L_0x0113
            com.iaai.android.bdt.feature.login.SessionManager r0 = r11.sessionManager
            if (r0 != 0) goto L_0x00f2
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
        L_0x00f2:
            boolean r0 = r0.isCurrentSessionUserIsPublic()
            if (r0 != 0) goto L_0x0113
            int r0 = com.iaai.android.C2723R.C2726id.showMYVehicleRelativeLayout
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r0.setVisibility(r9)
            int r0 = com.iaai.android.C2723R.C2726id.view_switch
            android.view.View r0 = r11._$_findCachedViewById(r0)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            r0.setVisibility(r9)
            goto L_0x012d
        L_0x0113:
            int r0 = com.iaai.android.C2723R.C2726id.showMYVehicleRelativeLayout
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.RelativeLayout r0 = (android.widget.RelativeLayout) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r3)
            r0.setVisibility(r8)
            int r0 = com.iaai.android.C2723R.C2726id.view_switch
            android.view.View r0 = r11._$_findCachedViewById(r0)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r2)
            r0.setVisibility(r8)
        L_0x012d:
            int r0 = com.iaai.android.C2723R.C2726id.tv_watching_count
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_watching_count"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.Integer r1 = r12.getWatching()
            if (r1 == 0) goto L_0x0145
            int r1 = r1.intValue()
            goto L_0x0146
        L_0x0145:
            r1 = 0
        L_0x0146:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = com.iaai.android.C2723R.C2726id.tv_pre_bid_count
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_pre_bid_count"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.Integer r2 = r12.getWinningPrebids()
            if (r2 == 0) goto L_0x0167
            int r2 = r2.intValue()
            goto L_0x0168
        L_0x0167:
            r2 = 0
        L_0x0168:
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
            int r0 = com.iaai.android.C2723R.C2726id.tv_pre_bid_count
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.Integer r1 = r12.getWinningPrebids()
            if (r1 == 0) goto L_0x0187
            int r1 = r1.intValue()
            goto L_0x0188
        L_0x0187:
            r1 = 0
        L_0x0188:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = com.iaai.android.C2723R.C2726id.tv_award_pending_count
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_award_pending_count"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.Integer r1 = r12.getAwardPending()
            if (r1 == 0) goto L_0x01a9
            int r1 = r1.intValue()
            goto L_0x01aa
        L_0x01a9:
            r1 = 0
        L_0x01aa:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = com.iaai.android.C2723R.C2726id.tv_tobe_paid_count
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_tobe_paid_count"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.Integer r1 = r12.getCountofvehicles()
            if (r1 == 0) goto L_0x01cb
            int r1 = r1.intValue()
            goto L_0x01cc
        L_0x01cb:
            r1 = 0
        L_0x01cc:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = com.iaai.android.C2723R.C2726id.tv_tobe_picked_up_count
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_tobe_picked_up_count"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.Integer r1 = r12.getPickup()
            if (r1 == 0) goto L_0x01ed
            int r1 = r1.intValue()
            goto L_0x01ee
        L_0x01ed:
            r1 = 0
        L_0x01ee:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = com.iaai.android.C2723R.C2726id.tv_notification_count
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_notification_count"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.Integer r1 = r12.getAlerts()
            if (r1 == 0) goto L_0x020f
            int r1 = r1.intValue()
            goto L_0x0210
        L_0x020f:
            r1 = 0
        L_0x0210:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            int r0 = com.iaai.android.C2723R.C2726id.tv_manager_offer_count
            android.view.View r0 = r11._$_findCachedViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.lang.String r1 = "tv_manager_offer_count"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.lang.Integer r12 = r12.getNegotiationOffers()
            if (r12 == 0) goto L_0x0230
            int r9 = r12.intValue()
        L_0x0230:
            java.lang.String r12 = java.lang.String.valueOf(r9)
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r0.setText(r12)
            int r12 = com.iaai.android.C2723R.C2726id.tv_buy_now_count
            android.view.View r12 = r11._$_findCachedViewById(r12)
            android.widget.TextView r12 = (android.widget.TextView) r12
            java.lang.String r0 = "tv_buy_now_count"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r0)
            int r0 = r11.buyNowOfferCount
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r12.setText(r0)
            r11.updateMYAccountNewCount()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.MyListFragment.updateView(com.iaai.android.bdt.model.MyAccount.BDTDashboardResponse):void");
    }

    private final void updateMYAccountNewCount() {
        BaseActivity baseActivity2 = this.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        int dashBoardCount = IAASharedPreference.getDashBoardCount(baseActivity2, Constants_MVVM.KEY_FOR_WATCHING_COUNT_MYACCOUNT);
        BDTDashboardResponse bDTDashboardResponse = this.bdtDashboardResponse;
        if (bDTDashboardResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        Integer watching = bDTDashboardResponse.getWatching();
        Integer num = null;
        if ((watching != null ? watching.intValue() : 0) > dashBoardCount) {
            TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_watching_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView, "tv_watching_new_count");
            textView.setVisibility(0);
            TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_watching_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView2, "tv_watching_new_count");
            StringBuilder sb = new StringBuilder();
            BDTDashboardResponse bDTDashboardResponse2 = this.bdtDashboardResponse;
            if (bDTDashboardResponse2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
            }
            Integer watching2 = bDTDashboardResponse2.getWatching();
            sb.append(String.valueOf(watching2 != null ? Integer.valueOf(watching2.intValue() - dashBoardCount) : null));
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            BaseActivity baseActivity3 = this.baseActivity;
            if (baseActivity3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            sb.append(baseActivity3.getResources().getString(C2723R.string.bdt_new_my_account));
            textView2.setText(sb.toString());
        } else {
            TextView textView3 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_watching_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView3, "tv_watching_new_count");
            textView3.setVisibility(8);
        }
        BaseActivity baseActivity4 = this.baseActivity;
        if (baseActivity4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        int dashBoardCount2 = IAASharedPreference.getDashBoardCount(baseActivity4, Constants_MVVM.KEY_FOR_PREBID_COUNT_MYACCOUNT);
        BDTDashboardResponse bDTDashboardResponse3 = this.bdtDashboardResponse;
        if (bDTDashboardResponse3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        Integer winningPrebids = bDTDashboardResponse3.getWinningPrebids();
        if ((winningPrebids != null ? winningPrebids.intValue() : 0) > dashBoardCount2) {
            TextView textView4 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_pre_bid_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView4, "tv_pre_bid_new_count");
            textView4.setVisibility(0);
            TextView textView5 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_pre_bid_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView5, "tv_pre_bid_new_count");
            StringBuilder sb2 = new StringBuilder();
            BDTDashboardResponse bDTDashboardResponse4 = this.bdtDashboardResponse;
            if (bDTDashboardResponse4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
            }
            Integer winningPrebids2 = bDTDashboardResponse4.getWinningPrebids();
            sb2.append(String.valueOf(winningPrebids2 != null ? Integer.valueOf(winningPrebids2.intValue() - dashBoardCount2) : null));
            sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            BaseActivity baseActivity5 = this.baseActivity;
            if (baseActivity5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            sb2.append(baseActivity5.getResources().getString(C2723R.string.bdt_new_my_account));
            textView5.setText(sb2.toString());
        } else {
            TextView textView6 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_pre_bid_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView6, "tv_pre_bid_new_count");
            textView6.setVisibility(8);
        }
        BaseActivity baseActivity6 = this.baseActivity;
        if (baseActivity6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        int dashBoardCount3 = IAASharedPreference.getDashBoardCount(baseActivity6, Constants_MVVM.KEY_FOR_AWARD_PENDING_COUNT_MYACCOUNT);
        BDTDashboardResponse bDTDashboardResponse5 = this.bdtDashboardResponse;
        if (bDTDashboardResponse5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        Integer awardPending = bDTDashboardResponse5.getAwardPending();
        if ((awardPending != null ? awardPending.intValue() : 0) > dashBoardCount3) {
            TextView textView7 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_award_pending_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView7, "tv_award_pending_new_count");
            textView7.setVisibility(0);
            TextView textView8 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_award_pending_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView8, "tv_award_pending_new_count");
            StringBuilder sb3 = new StringBuilder();
            BDTDashboardResponse bDTDashboardResponse6 = this.bdtDashboardResponse;
            if (bDTDashboardResponse6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
            }
            Integer awardPending2 = bDTDashboardResponse6.getAwardPending();
            sb3.append(String.valueOf(awardPending2 != null ? Integer.valueOf(awardPending2.intValue() - dashBoardCount3) : null));
            sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            BaseActivity baseActivity7 = this.baseActivity;
            if (baseActivity7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            sb3.append(baseActivity7.getResources().getString(C2723R.string.bdt_new_my_account));
            textView8.setText(sb3.toString());
        } else {
            TextView textView9 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_award_pending_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView9, "tv_award_pending_new_count");
            textView9.setVisibility(8);
        }
        BaseActivity baseActivity8 = this.baseActivity;
        if (baseActivity8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        int dashBoardCount4 = IAASharedPreference.getDashBoardCount(baseActivity8, Constants_MVVM.KEY_FOR_TOBEPAID_COUNT_MYACCOUNT);
        BDTDashboardResponse bDTDashboardResponse7 = this.bdtDashboardResponse;
        if (bDTDashboardResponse7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        Integer countofvehicles = bDTDashboardResponse7.getCountofvehicles();
        if ((countofvehicles != null ? countofvehicles.intValue() : 0) > dashBoardCount4) {
            TextView textView10 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_tobe_paid_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView10, "tv_tobe_paid_new_count");
            textView10.setVisibility(0);
            TextView textView11 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_tobe_paid_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView11, "tv_tobe_paid_new_count");
            StringBuilder sb4 = new StringBuilder();
            BDTDashboardResponse bDTDashboardResponse8 = this.bdtDashboardResponse;
            if (bDTDashboardResponse8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
            }
            Integer countofvehicles2 = bDTDashboardResponse8.getCountofvehicles();
            sb4.append(String.valueOf(countofvehicles2 != null ? Integer.valueOf(countofvehicles2.intValue() - dashBoardCount4) : null));
            sb4.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            BaseActivity baseActivity9 = this.baseActivity;
            if (baseActivity9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            sb4.append(baseActivity9.getResources().getString(C2723R.string.bdt_new_my_account));
            textView11.setText(sb4.toString());
        } else {
            TextView textView12 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_tobe_paid_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView12, "tv_tobe_paid_new_count");
            textView12.setVisibility(8);
        }
        BaseActivity baseActivity10 = this.baseActivity;
        if (baseActivity10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        int dashBoardCount5 = IAASharedPreference.getDashBoardCount(baseActivity10, Constants_MVVM.KEY_FOR_TBPU_COUNT_MYACCOUNT);
        BDTDashboardResponse bDTDashboardResponse9 = this.bdtDashboardResponse;
        if (bDTDashboardResponse9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        Integer pickup = bDTDashboardResponse9.getPickup();
        if ((pickup != null ? pickup.intValue() : 0) > dashBoardCount5) {
            TextView textView13 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_tobe_picked_up_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView13, "tv_tobe_picked_up_new_count");
            textView13.setVisibility(0);
            TextView textView14 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_tobe_picked_up_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView14, "tv_tobe_picked_up_new_count");
            StringBuilder sb5 = new StringBuilder();
            BDTDashboardResponse bDTDashboardResponse10 = this.bdtDashboardResponse;
            if (bDTDashboardResponse10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
            }
            Integer pickup2 = bDTDashboardResponse10.getPickup();
            sb5.append(String.valueOf(pickup2 != null ? Integer.valueOf(pickup2.intValue() - dashBoardCount5) : null));
            sb5.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            BaseActivity baseActivity11 = this.baseActivity;
            if (baseActivity11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            sb5.append(baseActivity11.getResources().getString(C2723R.string.bdt_new_my_account));
            textView14.setText(sb5.toString());
        } else {
            TextView textView15 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_tobe_picked_up_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView15, "tv_tobe_picked_up_new_count");
            textView15.setVisibility(8);
        }
        BaseActivity baseActivity12 = this.baseActivity;
        if (baseActivity12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        int dashBoardCount6 = IAASharedPreference.getDashBoardCount(baseActivity12, Constants_MVVM.KEY_FOR_MANAGE_OFFERS_MYACCOUNT);
        BDTDashboardResponse bDTDashboardResponse11 = this.bdtDashboardResponse;
        if (bDTDashboardResponse11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        Integer negotiationOffers = bDTDashboardResponse11.getNegotiationOffers();
        if ((negotiationOffers != null ? negotiationOffers.intValue() : 0) > dashBoardCount6) {
            TextView textView16 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_manage_offer_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView16, "tv_manage_offer_new_count");
            textView16.setVisibility(0);
            TextView textView17 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_manage_offer_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView17, "tv_manage_offer_new_count");
            StringBuilder sb6 = new StringBuilder();
            BDTDashboardResponse bDTDashboardResponse12 = this.bdtDashboardResponse;
            if (bDTDashboardResponse12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
            }
            Integer negotiationOffers2 = bDTDashboardResponse12.getNegotiationOffers();
            sb6.append(String.valueOf(negotiationOffers2 != null ? Integer.valueOf(negotiationOffers2.intValue() - dashBoardCount6) : null));
            sb6.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            BaseActivity baseActivity13 = this.baseActivity;
            if (baseActivity13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            sb6.append(baseActivity13.getResources().getString(C2723R.string.bdt_new_my_account));
            textView17.setText(sb6.toString());
        } else {
            TextView textView18 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_manage_offer_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView18, "tv_manage_offer_new_count");
            textView18.setVisibility(8);
        }
        BaseActivity baseActivity14 = this.baseActivity;
        if (baseActivity14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        int dashBoardCount7 = IAASharedPreference.getDashBoardCount(baseActivity14, Constants_MVVM.KEY_FOR_BUY_NOW_OFFER_COUNT_MYACCOUNT);
        if (this.buyNowOfferCount > dashBoardCount7) {
            TextView textView19 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_buy_now_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView19, "tv_buy_now_new_count");
            textView19.setVisibility(0);
            TextView textView20 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_buy_now_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView20, "tv_buy_now_new_count");
            StringBuilder sb7 = new StringBuilder();
            sb7.append(String.valueOf(this.buyNowOfferCount - dashBoardCount7));
            sb7.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            BaseActivity baseActivity15 = this.baseActivity;
            if (baseActivity15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            sb7.append(baseActivity15.getResources().getString(C2723R.string.bdt_new_my_account));
            textView20.setText(sb7.toString());
        } else {
            TextView textView21 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_buy_now_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView21, "tv_buy_now_new_count");
            textView21.setVisibility(8);
        }
        BaseActivity baseActivity16 = this.baseActivity;
        if (baseActivity16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        int dashBoardCount8 = IAASharedPreference.getDashBoardCount(baseActivity16, Constants_MVVM.KEY_FOR_NOTIFICATION_MYACCOUNT);
        BDTDashboardResponse bDTDashboardResponse13 = this.bdtDashboardResponse;
        if (bDTDashboardResponse13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
        }
        Integer alerts = bDTDashboardResponse13.getAlerts();
        if ((alerts != null ? alerts.intValue() : 0) > dashBoardCount8) {
            TextView textView22 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_notification_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView22, "tv_notification_new_count");
            textView22.setVisibility(0);
            TextView textView23 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_notification_new_count);
            Intrinsics.checkExpressionValueIsNotNull(textView23, "tv_notification_new_count");
            StringBuilder sb8 = new StringBuilder();
            BDTDashboardResponse bDTDashboardResponse14 = this.bdtDashboardResponse;
            if (bDTDashboardResponse14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bdtDashboardResponse");
            }
            Integer alerts2 = bDTDashboardResponse14.getAlerts();
            if (alerts2 != null) {
                num = Integer.valueOf(alerts2.intValue() - dashBoardCount8);
            }
            sb8.append(String.valueOf(num));
            sb8.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            BaseActivity baseActivity17 = this.baseActivity;
            if (baseActivity17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
            }
            sb8.append(baseActivity17.getResources().getString(C2723R.string.bdt_new_my_account));
            textView23.setText(sb8.toString());
            return;
        }
        TextView textView24 = (TextView) _$_findCachedViewById(C2723R.C2726id.tv_notification_new_count);
        Intrinsics.checkExpressionValueIsNotNull(textView24, "tv_notification_new_count");
        textView24.setVisibility(8);
    }

    public void onResume() {
        super.onResume();
    }
}
