package com.iaai.android.bdt.feature.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.MedalliaCustomParameters;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.base.BaseFragment;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.MyAccount.BDTDashboardResponse;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.databinding.AcivityAccountSettingListBinding;
import com.iaai.android.old.activities.SSORegistrationActivity;
import com.iaai.android.old.utils.constants.Constants;
import com.medallia.digital.mobilesdk.MedalliaDigital;
import dagger.android.support.AndroidSupportInjection;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001 B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0010H\u0002J\u0012\u0010\u001f\u001a\u00020\u00102\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006!"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/AccountSettingFragment;", "Lcom/iaai/android/bdt/base/BaseFragment;", "()V", "baseActivity", "Lcom/iaai/android/bdt/base/BaseActivity;", "bdtDashboardResponse", "Lcom/iaai/android/bdt/model/MyAccount/BDTDashboardResponse;", "jsonDashBoardString", "", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "handleRowSelection", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setCustomParameterForMedallia", "updateView", "OnRowClickListener", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: AccountSettingFragment.kt */
public final class AccountSettingFragment extends BaseFragment {
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public BaseActivity baseActivity;
    /* access modifiers changed from: private */
    public BDTDashboardResponse bdtDashboardResponse;
    private String jsonDashBoardString = "";
    @Inject
    @NotNull
    public SessionManager sessionManager;

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

    public static final /* synthetic */ BaseActivity access$getBaseActivity$p(AccountSettingFragment accountSettingFragment) {
        BaseActivity baseActivity2 = accountSettingFragment.baseActivity;
        if (baseActivity2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("baseActivity");
        }
        return baseActivity2;
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

    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkParameterIsNotNull(layoutInflater, "inflater");
        AcivityAccountSettingListBinding acivityAccountSettingListBinding = (AcivityAccountSettingListBinding) DataBindingUtil.inflate(layoutInflater, C2723R.C2728layout.acivity_account_setting_list, viewGroup, false);
        Intrinsics.checkExpressionValueIsNotNull(acivityAccountSettingListBinding, "mBinding");
        return acivityAccountSettingListBinding.getRoot();
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
        this.bdtDashboardResponse = (BDTDashboardResponse) new Gson().fromJson(this.jsonDashBoardString, BDTDashboardResponse.class);
        updateView(this.bdtDashboardResponse);
        handleRowSelection();
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.rl_feedback)).setOnClickListener(new AccountSettingFragment$onActivityCreated$1(this));
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        if (instance.getIAARemoteConfig().getBorkerCommunityFlag()) {
            RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_help);
            Intrinsics.checkExpressionValueIsNotNull(relativeLayout, "rl_help");
            relativeLayout.setVisibility(0);
            View _$_findCachedViewById = _$_findCachedViewById(C2723R.C2726id.viewHelpLineSeparator);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "viewHelpLineSeparator");
            int visibility = _$_findCachedViewById.getVisibility();
            return;
        }
        RelativeLayout relativeLayout2 = (RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_help);
        Intrinsics.checkExpressionValueIsNotNull(relativeLayout2, "rl_help");
        relativeLayout2.setVisibility(8);
        View _$_findCachedViewById2 = _$_findCachedViewById(C2723R.C2726id.viewHelpLineSeparator);
        Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "viewHelpLineSeparator");
        int visibility2 = _$_findCachedViewById2.getVisibility();
    }

    private final void handleRowSelection() {
        View.OnClickListener onRowClickListener = new OnRowClickListener();
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_profile)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_upgrade_account)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_renewal)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_license_document)).setOnClickListener(onRowClickListener);
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.rl_feedback)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_help)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_setting)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_contact_us)).setOnClickListener(onRowClickListener);
        ((RelativeLayout) _$_findCachedViewById(C2723R.C2726id.rl_my_subscriptions)).setOnClickListener(onRowClickListener);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x0114  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateView(com.iaai.android.bdt.model.MyAccount.BDTDashboardResponse r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto L_0x0008
            java.lang.Boolean r1 = r10.getProfileLinkInd()
            goto L_0x0009
        L_0x0008:
            r1 = r0
        L_0x0009:
            r2 = 1
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            java.lang.String r3 = "profile_view"
            java.lang.String r4 = "rl_profile"
            r5 = 8
            r6 = 0
            if (r1 == 0) goto L_0x0036
            int r1 = com.iaai.android.C2723R.C2726id.rl_profile
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            r1.setVisibility(r6)
            int r1 = com.iaai.android.C2723R.C2726id.profile_view
            android.view.View r1 = r9._$_findCachedViewById(r1)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
            r1.setVisibility(r6)
            goto L_0x0050
        L_0x0036:
            int r1 = com.iaai.android.C2723R.C2726id.rl_profile
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            r1.setVisibility(r5)
            int r1 = com.iaai.android.C2723R.C2726id.profile_view
            android.view.View r1 = r9._$_findCachedViewById(r1)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
            r1.setVisibility(r5)
        L_0x0050:
            if (r10 == 0) goto L_0x0057
            java.lang.Boolean r1 = r10.getLincenseLinkInd()
            goto L_0x0058
        L_0x0057:
            r1 = r0
        L_0x0058:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r2)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            java.lang.String r3 = "license_and_document_view"
            java.lang.String r4 = "rl_license_document"
            if (r1 == 0) goto L_0x0081
            int r1 = com.iaai.android.C2723R.C2726id.rl_license_document
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            r1.setVisibility(r6)
            int r1 = com.iaai.android.C2723R.C2726id.license_and_document_view
            android.view.View r1 = r9._$_findCachedViewById(r1)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
            r1.setVisibility(r6)
            goto L_0x009b
        L_0x0081:
            int r1 = com.iaai.android.C2723R.C2726id.rl_license_document
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            r1.setVisibility(r5)
            int r1 = com.iaai.android.C2723R.C2726id.license_and_document_view
            android.view.View r1 = r9._$_findCachedViewById(r1)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r3)
            r1.setVisibility(r5)
        L_0x009b:
            com.iaai.android.bdt.feature.login.SessionManager r1 = r9.sessionManager
            java.lang.String r3 = "sessionManager"
            if (r1 != 0) goto L_0x00a4
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x00a4:
            java.lang.String r1 = r1.getCurrentSessionBuyerId()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x00b5
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00b3
            goto L_0x00b5
        L_0x00b3:
            r1 = 0
            goto L_0x00b6
        L_0x00b5:
            r1 = 1
        L_0x00b6:
            java.lang.String r4 = "my_subscriptions_view"
            java.lang.String r7 = "rl_my_subscriptions"
            if (r1 != 0) goto L_0x00f8
            com.iaai.android.bdt.feature.login.SessionManager r1 = r9.sessionManager
            if (r1 != 0) goto L_0x00c3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x00c3:
            java.lang.String r1 = r1.getCurrentSessionBuyerId()
            java.lang.String r8 = "0"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r8)
            r1 = r1 ^ r2
            if (r1 == 0) goto L_0x00f8
            com.iaai.android.bdt.feature.login.SessionManager r1 = r9.sessionManager
            if (r1 != 0) goto L_0x00d7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
        L_0x00d7:
            boolean r1 = r1.isEnableInteract()
            if (r1 == 0) goto L_0x00f8
            int r1 = com.iaai.android.C2723R.C2726id.rl_my_subscriptions
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
            r1.setVisibility(r6)
            int r1 = com.iaai.android.C2723R.C2726id.my_subscriptions_view
            android.view.View r1 = r9._$_findCachedViewById(r1)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            r1.setVisibility(r6)
            goto L_0x0112
        L_0x00f8:
            int r1 = com.iaai.android.C2723R.C2726id.rl_my_subscriptions
            android.view.View r1 = r9._$_findCachedViewById(r1)
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r7)
            r1.setVisibility(r5)
            int r1 = com.iaai.android.C2723R.C2726id.my_subscriptions_view
            android.view.View r1 = r9._$_findCachedViewById(r1)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r1, r4)
            r1.setVisibility(r5)
        L_0x0112:
            if (r10 == 0) goto L_0x0118
            java.lang.Boolean r0 = r10.getRenewalLinkInd()
        L_0x0118:
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r2)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r10)
            java.lang.String r0 = "renewal_view"
            java.lang.String r1 = "rl_renewal"
            if (r10 == 0) goto L_0x0141
            int r10 = com.iaai.android.C2723R.C2726id.rl_renewal
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r1)
            r10.setVisibility(r6)
            int r10 = com.iaai.android.C2723R.C2726id.renewal_view
            android.view.View r10 = r9._$_findCachedViewById(r10)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r0)
            r10.setVisibility(r6)
            goto L_0x015b
        L_0x0141:
            int r10 = com.iaai.android.C2723R.C2726id.rl_renewal
            android.view.View r10 = r9._$_findCachedViewById(r10)
            android.widget.RelativeLayout r10 = (android.widget.RelativeLayout) r10
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r1)
            r10.setVisibility(r5)
            int r10 = com.iaai.android.C2723R.C2726id.renewal_view
            android.view.View r10 = r9._$_findCachedViewById(r10)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r10, r0)
            r10.setVisibility(r5)
        L_0x015b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.account.AccountSettingFragment.updateView(com.iaai.android.bdt.model.MyAccount.BDTDashboardResponse):void");
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

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002¨\u0006\n"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/account/AccountSettingFragment$OnRowClickListener;", "Landroid/view/View$OnClickListener;", "(Lcom/iaai/android/bdt/feature/account/AccountSettingFragment;)V", "onClick", "", "view", "Landroid/view/View;", "showMyAccountSetting", "viewId", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: AccountSettingFragment.kt */
    private final class OnRowClickListener implements View.OnClickListener {
        public OnRowClickListener() {
        }

        public void onClick(@NotNull View view) {
            Intrinsics.checkParameterIsNotNull(view, "view");
            showMyAccountSetting(view.getId());
        }

        private final void showMyAccountSetting(int i) {
            String str = null;
            switch (i) {
                case C2723R.C2726id.rl_contact_us:
                    Activity_ExtensionKt.navigateToContactUsPage(AccountSettingFragment.access$getBaseActivity$p(AccountSettingFragment.this), AccountSettingFragment.access$getBaseActivity$p(AccountSettingFragment.this));
                    return;
                case C2723R.C2726id.rl_help:
                    Activity_ExtensionKt.navigateToHelpPage(AccountSettingFragment.access$getBaseActivity$p(AccountSettingFragment.this), AccountSettingFragment.access$getBaseActivity$p(AccountSettingFragment.this));
                    return;
                case C2723R.C2726id.rl_license_document:
                    Intent intent = new Intent(AccountSettingFragment.access$getBaseActivity$p(AccountSettingFragment.this), SSORegistrationActivity.class);
                    intent.addCategory("android.intent.category.DEFAULT");
                    BDTDashboardResponse access$getBdtDashboardResponse$p = AccountSettingFragment.this.bdtDashboardResponse;
                    if (access$getBdtDashboardResponse$p != null) {
                        str = access$getBdtDashboardResponse$p.getLicenseLink();
                    }
                    intent.putExtra(Constants.EXTRA_SSO_URL, str);
                    AccountSettingFragment.this.startActivity(intent);
                    return;
                case C2723R.C2726id.rl_my_subscriptions:
                    Intent intent2 = new Intent(AccountSettingFragment.access$getBaseActivity$p(AccountSettingFragment.this), SSORegistrationActivity.class);
                    intent2.addCategory("android.intent.category.DEFAULT");
                    intent2.putExtra(Constants.EXTRA_SSO_URL, Constants_MVVM.MY_SUBSCRIPTION_URL);
                    AccountSettingFragment.this.startActivity(intent2);
                    return;
                case C2723R.C2726id.rl_profile:
                    Intent intent3 = new Intent(AccountSettingFragment.access$getBaseActivity$p(AccountSettingFragment.this), SSORegistrationActivity.class);
                    intent3.addCategory("android.intent.category.DEFAULT");
                    BDTDashboardResponse access$getBdtDashboardResponse$p2 = AccountSettingFragment.this.bdtDashboardResponse;
                    if (access$getBdtDashboardResponse$p2 != null) {
                        str = access$getBdtDashboardResponse$p2.getProfileLink();
                    }
                    intent3.putExtra(Constants.EXTRA_SSO_URL, str);
                    AccountSettingFragment.this.startActivity(intent3);
                    return;
                case C2723R.C2726id.rl_renewal:
                    Intent intent4 = new Intent(AccountSettingFragment.access$getBaseActivity$p(AccountSettingFragment.this), SSORegistrationActivity.class);
                    intent4.addCategory("android.intent.category.DEFAULT");
                    BDTDashboardResponse access$getBdtDashboardResponse$p3 = AccountSettingFragment.this.bdtDashboardResponse;
                    if (access$getBdtDashboardResponse$p3 != null) {
                        str = access$getBdtDashboardResponse$p3.getRenewalLink();
                    }
                    intent4.putExtra(Constants.EXTRA_SSO_URL, str);
                    AccountSettingFragment.this.startActivity(intent4);
                    return;
                case C2723R.C2726id.rl_setting:
                    if (!AccountSettingFragment.this.getSessionManager().promptForLoginIfNeedFromActivity(AccountSettingFragment.access$getBaseActivity$p(AccountSettingFragment.this), AccountSettingFragment.access$getBaseActivity$p(AccountSettingFragment.this), 40)) {
                        AccountSettingFragment.this.startActivity(new Intent(AccountSettingFragment.access$getBaseActivity$p(AccountSettingFragment.this), BDTSettingsActivity.class));
                        return;
                    }
                    return;
                case C2723R.C2726id.rl_upgrade_account:
                    Intent intent5 = new Intent(AccountSettingFragment.access$getBaseActivity$p(AccountSettingFragment.this), SSORegistrationActivity.class);
                    intent5.addCategory("android.intent.category.DEFAULT");
                    BDTDashboardResponse access$getBdtDashboardResponse$p4 = AccountSettingFragment.this.bdtDashboardResponse;
                    if (access$getBdtDashboardResponse$p4 != null) {
                        str = access$getBdtDashboardResponse$p4.getUpgradeLink();
                    }
                    intent5.putExtra(Constants.EXTRA_SSO_URL, str);
                    AccountSettingFragment.this.startActivity(intent5);
                    return;
                default:
                    return;
            }
        }
    }
}
