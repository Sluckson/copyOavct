package com.iaai.android.bdt.feature.login;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
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
import dagger.android.AndroidInjection;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u0004H\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0003R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006#"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/login/BDTForgotPasswordActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "username", "getUsername", "setUsername", "(Ljava/lang/String;)V", "viewModel", "Lcom/iaai/android/bdt/feature/login/ForgotPasswordViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/login/ForgotPasswordViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/login/ForgotPasswordViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "initializeUI", "", "loadForgotPasswordURL", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "showErrorMessageDialog", "error", "showLoadingIndicator", "loading", "", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTForgotPasswordActivity.kt */
public final class BDTForgotPasswordActivity extends AppCompatActivity {
    @NotNull
    private final String TAG;
    private HashMap _$_findViewCache;
    @NotNull
    private String username = "";
    @NotNull
    public ForgotPasswordViewModel viewModel;
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

    public BDTForgotPasswordActivity() {
        String simpleName = BDTForgotPasswordActivity.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "BDTForgotPasswordActivity::class.java.simpleName");
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
    public final ForgotPasswordViewModel getViewModel() {
        ForgotPasswordViewModel forgotPasswordViewModel = this.viewModel;
        if (forgotPasswordViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return forgotPasswordViewModel;
    }

    public final void setViewModel(@NotNull ForgotPasswordViewModel forgotPasswordViewModel) {
        Intrinsics.checkParameterIsNotNull(forgotPasswordViewModel, "<set-?>");
        this.viewModel = forgotPasswordViewModel;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    @NotNull
    public final String getUsername() {
        return this.username;
    }

    public final void setUsername(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.username = str;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AndroidInjection.inject((Activity) this);
        setContentView((int) C2723R.C2728layout.activity_bdt_forgot_password);
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(ForgotPasswordViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…ordViewModel::class.java)");
        this.viewModel = (ForgotPasswordViewModel) viewModel2;
        String stringExtra = getIntent().getStringExtra("username");
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "intent.getStringExtra(Co…ants_MVVM.EXTRA_USERNAME)");
        this.username = stringExtra;
        initializeUI();
        subscribeToViewModel();
        loadForgotPasswordURL();
    }

    private final void initializeUI() {
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle((CharSequence) getResources().getString(C2723R.string.lbl_forgot_password));
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 == null) {
            Intrinsics.throwNpe();
        }
        supportActionBar2.setDisplayHomeAsUpEnabled(false);
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 == null) {
            Intrinsics.throwNpe();
        }
        supportActionBar3.setDisplayShowTitleEnabled(true);
        ((Button) _$_findCachedViewById(C2723R.C2726id.btnClose)).setOnClickListener(new BDTForgotPasswordActivity$initializeUI$1(this));
    }

    private final void loadForgotPasswordURL() {
        ForgotPasswordViewModel forgotPasswordViewModel = this.viewModel;
        if (forgotPasswordViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        forgotPasswordViewModel.forgotPassword(this.username);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    private final void subscribeToViewModel() {
        ForgotPasswordViewModel forgotPasswordViewModel = this.viewModel;
        if (forgotPasswordViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        forgotPasswordViewModel.getForgotPasswordResponse().observe(lifecycleOwner, new BDTForgotPasswordActivity$subscribeToViewModel$1(this));
        ForgotPasswordViewModel forgotPasswordViewModel2 = this.viewModel;
        if (forgotPasswordViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        forgotPasswordViewModel2.getForgotPasswordError().observe(lifecycleOwner, new BDTForgotPasswordActivity$subscribeToViewModel$2(this));
        ForgotPasswordViewModel forgotPasswordViewModel3 = this.viewModel;
        if (forgotPasswordViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        forgotPasswordViewModel3.getShowLoading().observe(lifecycleOwner, new BDTForgotPasswordActivity$subscribeToViewModel$3(this));
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbForgotPassword);
            if (progressBar != null) {
                progressBar.setVisibility(0);
                return;
            }
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbForgotPassword);
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void showErrorMessageDialog(String str) {
        Dialog showAlert = Activity_ExtensionKt.showAlert(this, "", str);
        if (showAlert != null) {
            showAlert.show();
        }
    }
}
