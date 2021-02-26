package com.iaai.android.bdt.feature.login.emailValidation;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.extensions.EditText_ExtensionKt;
import com.iaai.android.bdt.utils.Constants_MVVM;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u0017H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/login/emailValidation/ValidateOTPActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "email", "newID", "userId", "viewModel", "Lcom/iaai/android/bdt/feature/login/emailValidation/ValidateOTPViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/login/emailValidation/ValidateOTPViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/login/emailValidation/ValidateOTPViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "initializeUI", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "showLoadingIndicator", "loading", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ValidateOTPActivity.kt */
public final class ValidateOTPActivity extends BaseActivity {
    @NotNull
    private final String TAG;
    private HashMap _$_findViewCache;
    private String email = "";
    /* access modifiers changed from: private */
    public String newID = "";
    /* access modifiers changed from: private */
    public String userId = "";
    @NotNull
    public ValidateOTPViewModel viewModel;
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

    public ValidateOTPActivity() {
        String simpleName = ValidateOTPActivity.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "ValidateOTPActivity::class.java.simpleName");
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
    public final ValidateOTPViewModel getViewModel() {
        ValidateOTPViewModel validateOTPViewModel = this.viewModel;
        if (validateOTPViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return validateOTPViewModel;
    }

    public final void setViewModel(@NotNull ValidateOTPViewModel validateOTPViewModel) {
        Intrinsics.checkParameterIsNotNull(validateOTPViewModel, "<set-?>");
        this.viewModel = validateOTPViewModel;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_validate_otp);
        AndroidInjection.inject((Activity) this);
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(ValidateOTPViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…OTPViewModel::class.java)");
        this.viewModel = (ValidateOTPViewModel) viewModel2;
        String stringExtra = getIntent().getStringExtra("userID");
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "intent.getStringExtra(Co…tants_MVVM.EXTRA_USER_ID)");
        this.userId = stringExtra;
        String stringExtra2 = getIntent().getStringExtra(Constants_MVVM.EXTRA_EMAIL_ID);
        Intrinsics.checkExpressionValueIsNotNull(stringExtra2, "intent.getStringExtra(Co…ants_MVVM.EXTRA_EMAIL_ID)");
        this.email = stringExtra2;
        String stringExtra3 = getIntent().getStringExtra(Constants_MVVM.EXTRA_NEW_LOGIN_ID);
        Intrinsics.checkExpressionValueIsNotNull(stringExtra3, "intent.getStringExtra(Co…_MVVM.EXTRA_NEW_LOGIN_ID)");
        this.newID = stringExtra3;
        initializeUI();
        subscribeToViewModel();
    }

    private final void initializeUI() {
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle((CharSequence) getResources().getString(C2723R.string.lbl_verify_account));
        }
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 == null) {
            Intrinsics.throwNpe();
        }
        supportActionBar2.setDisplayHomeAsUpEnabled(true);
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 == null) {
            Intrinsics.throwNpe();
        }
        supportActionBar3.setDisplayShowTitleEnabled(true);
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvVerificationMsg);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvVerificationMsg");
        textView.setText(getString(C2723R.string.verification_text, new Object[]{this.newID}));
        TextView textView2 = (TextView) _$_findCachedViewById(C2723R.C2726id.tvEmail);
        Intrinsics.checkExpressionValueIsNotNull(textView2, "tvEmail");
        textView2.setText(this.newID);
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvConfirmPIN)).setOnClickListener(new ValidateOTPActivity$initializeUI$1(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvEditEmail)).setOnClickListener(new ValidateOTPActivity$initializeUI$2(this));
        ((LinearLayout) _$_findCachedViewById(C2723R.C2726id.llResendPIN)).setOnClickListener(new ValidateOTPActivity$initializeUI$3(this));
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etPIN);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etPIN");
        EditText_ExtensionKt.onChange(editText, new ValidateOTPActivity$initializeUI$4(this));
    }

    private final void subscribeToViewModel() {
        ValidateOTPViewModel validateOTPViewModel = this.viewModel;
        if (validateOTPViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        validateOTPViewModel.getValidateOTPResponse().observe(lifecycleOwner, new ValidateOTPActivity$subscribeToViewModel$1(this));
        ValidateOTPViewModel validateOTPViewModel2 = this.viewModel;
        if (validateOTPViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        validateOTPViewModel2.getValidateOTPError().observe(lifecycleOwner, new ValidateOTPActivity$subscribeToViewModel$2(this));
        ValidateOTPViewModel validateOTPViewModel3 = this.viewModel;
        if (validateOTPViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        validateOTPViewModel3.getShowLoading().observe(lifecycleOwner, new ValidateOTPActivity$subscribeToViewModel$3(this));
        ValidateOTPViewModel validateOTPViewModel4 = this.viewModel;
        if (validateOTPViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        validateOTPViewModel4.getGenerateOTPResponse().observe(lifecycleOwner, new ValidateOTPActivity$subscribeToViewModel$4(this));
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbConfirmPIN);
            if (progressBar != null) {
                progressBar.setVisibility(0);
                return;
            }
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbConfirmPIN);
        if (progressBar2 != null) {
            progressBar2.setVisibility(8);
        }
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        finish();
        return true;
    }
}
