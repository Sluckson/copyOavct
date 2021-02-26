package com.iaai.android.bdt.feature.termsofuse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.AppUtils;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/termsofuse/TermsOfUseAuctionRuleActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "serviceIntent", "Landroid/content/Intent;", "getServiceIntent", "()Landroid/content/Intent;", "setServiceIntent", "(Landroid/content/Intent;)V", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "viewModel", "Lcom/iaai/android/bdt/feature/termsofuse/AuctionRuleViewModel;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "insertAcceptAuctionRule", "", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: TermsOfUseAuctionRuleActivity.kt */
public final class TermsOfUseAuctionRuleActivity extends AppCompatActivity {
    private HashMap _$_findViewCache;
    @NotNull
    public Intent serviceIntent;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    private AuctionRuleViewModel viewModel;
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

    @NotNull
    public final Intent getServiceIntent() {
        Intent intent = this.serviceIntent;
        if (intent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceIntent");
        }
        return intent;
    }

    public final void setServiceIntent(@NotNull Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "<set-?>");
        this.serviceIntent = intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        AndroidInjection.inject((Activity) this);
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_terms_of_use_auction_rule);
        this.serviceIntent = new Intent(this, OnClearFromRecentService.class);
        Intent intent = this.serviceIntent;
        if (intent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceIntent");
        }
        startService(intent);
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(AuctionRuleViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…uleViewModel::class.java)");
        this.viewModel = (AuctionRuleViewModel) viewModel2;
        Intent intent2 = getIntent();
        Intrinsics.checkExpressionValueIsNotNull(intent2, "intent");
        String string = intent2.getExtras().getString(Constants_MVVM.EXTRA_AUCTION_RULE_URL);
        Intrinsics.checkExpressionValueIsNotNull(string, "auctionRuleUrl");
        if (string.length() > 0) {
            string = getString(C2723R.string.auto_registration_url) + string;
        }
        ((WebView) _$_findCachedViewById(C2723R.C2726id.terms_and_conditions)).loadUrl(string);
        ((Button) _$_findCachedViewById(C2723R.C2726id.btn_accept)).setOnClickListener(new TermsOfUseAuctionRuleActivity$onCreate$1(this));
    }

    /* access modifiers changed from: private */
    public final void insertAcceptAuctionRule() {
        StringBuilder sb = new StringBuilder();
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        sb.append(sessionManager2.getCurrentSessionUsername());
        sb.append(":");
        SessionManager sessionManager3 = this.sessionManager;
        if (sessionManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        sb.append(sessionManager3.getCurrentSessionPassword());
        String sb2 = sb.toString();
        AuctionRuleViewModel auctionRuleViewModel = this.viewModel;
        if (auctionRuleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        String deviceIPAddress = AppUtils.getDeviceIPAddress(true);
        Intrinsics.checkExpressionValueIsNotNull(deviceIPAddress, "AppUtils.getDeviceIPAddress(true)");
        auctionRuleViewModel.insertAcceptAuctionRule(deviceIPAddress, sb2);
        subscribeToViewModel();
    }

    private final void subscribeToViewModel() {
        AuctionRuleViewModel auctionRuleViewModel = this.viewModel;
        if (auctionRuleViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        auctionRuleViewModel.getArAcceptResponse().observe(lifecycleOwner, new TermsOfUseAuctionRuleActivity$subscribeToViewModel$1(this));
        AuctionRuleViewModel auctionRuleViewModel2 = this.viewModel;
        if (auctionRuleViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        auctionRuleViewModel2.getArAcceptError().observe(lifecycleOwner, new TermsOfUseAuctionRuleActivity$subscribeToViewModel$2(this));
    }

    public void onBackPressed() {
        moveTaskToBack(false);
    }
}
