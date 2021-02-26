package com.iaai.android.bdt.feature.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.old.utils.AppUtils;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\u0012\u0010 \u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u001cH\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006("}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/login/BDTTermsOfUseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "comeFrom", "", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "viewModel", "Lcom/iaai/android/bdt/feature/login/TermsOfUseViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/login/TermsOfUseViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/login/TermsOfUseViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "acceptTermsOfUse", "", "deviceId", "initializeUI", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTTermsOfUseActivity.kt */
public final class BDTTermsOfUseActivity extends AppCompatActivity {
    @NotNull
    private final String TAG;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public int comeFrom = TermsOfUseOrigin.DEFAULT.getValue();
    @Inject
    @NotNull
    public SessionManager sessionManager;
    @NotNull
    public TermsOfUseViewModel viewModel;
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

    public BDTTermsOfUseActivity() {
        String simpleName = BDTTermsOfUseActivity.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "BDTTermsOfUseActivity::class.java.simpleName");
        this.TAG = simpleName;
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
    public final TermsOfUseViewModel getViewModel() {
        TermsOfUseViewModel termsOfUseViewModel = this.viewModel;
        if (termsOfUseViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return termsOfUseViewModel;
    }

    public final void setViewModel(@NotNull TermsOfUseViewModel termsOfUseViewModel) {
        Intrinsics.checkParameterIsNotNull(termsOfUseViewModel, "<set-?>");
        this.viewModel = termsOfUseViewModel;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_bdt_terms_of_use);
        AndroidInjection.inject((Activity) this);
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(TermsOfUseViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…UseViewModel::class.java)");
        this.viewModel = (TermsOfUseViewModel) viewModel2;
        this.comeFrom = getIntent().getIntExtra("come_from", TermsOfUseOrigin.DEFAULT.getValue());
        initializeUI();
        Activity_ExtensionKt.isLatestAppInstalled(this);
        subscribeToViewModel();
    }

    private final void initializeUI() {
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle((CharSequence) getResources().getString(C2723R.string.terms_of_use));
        }
        if (this.comeFrom == TermsOfUseOrigin.FROM_SPLASH.getValue() || this.comeFrom == TermsOfUseOrigin.FROM_LOGIN.getValue()) {
            ActionBar supportActionBar2 = getSupportActionBar();
            if (supportActionBar2 == null) {
                Intrinsics.throwNpe();
            }
            supportActionBar2.setDisplayHomeAsUpEnabled(false);
        } else {
            ActionBar supportActionBar3 = getSupportActionBar();
            if (supportActionBar3 == null) {
                Intrinsics.throwNpe();
            }
            supportActionBar3.setDisplayHomeAsUpEnabled(true);
            ActionBar supportActionBar4 = getSupportActionBar();
            if (supportActionBar4 == null) {
                Intrinsics.throwNpe();
            }
            supportActionBar4.setHomeButtonEnabled(true);
        }
        ((WebView) _$_findCachedViewById(C2723R.C2726id.tvTermsNConditions)).loadUrl(getString(C2723R.string.terms_of_use_file_path));
        if (this.comeFrom == TermsOfUseOrigin.DEFAULT.getValue()) {
            Button button = (Button) _$_findCachedViewById(C2723R.C2726id.btnAccept);
            Intrinsics.checkExpressionValueIsNotNull(button, "btnAccept");
            button.setVisibility(8);
        }
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnAccept)).setOnClickListener(new BDTTermsOfUseActivity$initializeUI$1(this));
    }

    private final void subscribeToViewModel() {
        TermsOfUseViewModel termsOfUseViewModel = this.viewModel;
        if (termsOfUseViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        termsOfUseViewModel.getTermsOfUseResponse().observe(lifecycleOwner, new BDTTermsOfUseActivity$subscribeToViewModel$1(this));
        TermsOfUseViewModel termsOfUseViewModel2 = this.viewModel;
        if (termsOfUseViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        termsOfUseViewModel2.getError().observe(lifecycleOwner, new BDTTermsOfUseActivity$subscribeToViewModel$2(this));
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() == 16908332) {
            finish();
            overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onBackPressed() {
        if (this.comeFrom == TermsOfUseOrigin.FROM_LOGIN.getValue()) {
            moveTaskToBack(false);
            return;
        }
        finish();
        if (this.comeFrom == TermsOfUseOrigin.DEFAULT.getValue()) {
            finish();
        }
    }

    /* access modifiers changed from: private */
    public final void acceptTermsOfUse(String str) {
        AppUtils.saveTermsOfUseTimeStamp(this);
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        String currentSessionUserId = sessionManager2.getCurrentSessionUserId();
        TermsOfUseViewModel termsOfUseViewModel = this.viewModel;
        if (termsOfUseViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        termsOfUseViewModel.acceptTermsOfUse(str, currentSessionUserId);
    }
}
