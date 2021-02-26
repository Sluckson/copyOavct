package com.iaai.android.bdt.feature.login.emailValidation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
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
import com.iaai.android.bdt.utils.ActivityRequestCode;
import com.iaai.android.bdt.utils.Constants_MVVM;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\"\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006)"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/login/emailValidation/EmailConfirmationActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "confirmID", "email", "newID", "userId", "viewModel", "Lcom/iaai/android/bdt/feature/login/emailValidation/EmailConfirmationViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/login/emailValidation/EmailConfirmationViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/login/emailValidation/EmailConfirmationViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "initializeUI", "", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "showLoadingIndicator", "loading", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: EmailConfirmationActivity.kt */
public final class EmailConfirmationActivity extends BaseActivity {
    @NotNull
    private final String TAG;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public String confirmID = "";
    /* access modifiers changed from: private */
    public String email = "";
    /* access modifiers changed from: private */
    public String newID = "";
    /* access modifiers changed from: private */
    public String userId = "";
    @NotNull
    public EmailConfirmationViewModel viewModel;
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

    public EmailConfirmationActivity() {
        String simpleName = EmailConfirmationActivity.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "EmailConfirmationActivity::class.java.simpleName");
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
    public final EmailConfirmationViewModel getViewModel() {
        EmailConfirmationViewModel emailConfirmationViewModel = this.viewModel;
        if (emailConfirmationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return emailConfirmationViewModel;
    }

    public final void setViewModel(@NotNull EmailConfirmationViewModel emailConfirmationViewModel) {
        Intrinsics.checkParameterIsNotNull(emailConfirmationViewModel, "<set-?>");
        this.viewModel = emailConfirmationViewModel;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_email_confirmation);
        AndroidInjection.inject((Activity) this);
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(EmailConfirmationViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…ionViewModel::class.java)");
        this.viewModel = (EmailConfirmationViewModel) viewModel2;
        String stringExtra = getIntent().getStringExtra("userID");
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "intent.getStringExtra(Co…tants_MVVM.EXTRA_USER_ID)");
        this.userId = stringExtra;
        String stringExtra2 = getIntent().getStringExtra(Constants_MVVM.EXTRA_EMAIL_ID);
        Intrinsics.checkExpressionValueIsNotNull(stringExtra2, "intent.getStringExtra(Co…ants_MVVM.EXTRA_EMAIL_ID)");
        this.email = stringExtra2;
        initializeUI();
        subscribeToViewModel();
    }

    private final void initializeUI() {
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.toolbar));
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setTitle((CharSequence) getResources().getString(C2723R.string.lbl_change_login_id));
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
        TextView textView = (TextView) _$_findCachedViewById(C2723R.C2726id.tvCurrentLoginID);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvCurrentLoginID");
        textView.setText(getResources().getString(C2723R.string.lbl_current_login_id) + ' ' + this.email);
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etLoginID);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etLoginID");
        EditText_ExtensionKt.disableCopyPaste(editText);
        EditText editText2 = (EditText) _$_findCachedViewById(C2723R.C2726id.etConfirmID);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "etConfirmID");
        EditText_ExtensionKt.disableCopyPaste(editText2);
        EditText editText3 = (EditText) _$_findCachedViewById(C2723R.C2726id.etLoginID);
        Intrinsics.checkExpressionValueIsNotNull(editText3, "etLoginID");
        EditText_ExtensionKt.onChange(editText3, new EmailConfirmationActivity$initializeUI$1(this));
        EditText editText4 = (EditText) _$_findCachedViewById(C2723R.C2726id.etConfirmID);
        Intrinsics.checkExpressionValueIsNotNull(editText4, "etConfirmID");
        EditText_ExtensionKt.onChange(editText4, new EmailConfirmationActivity$initializeUI$2(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvContinue)).setOnClickListener(new EmailConfirmationActivity$initializeUI$3(this));
    }

    private final void subscribeToViewModel() {
        EmailConfirmationViewModel emailConfirmationViewModel = this.viewModel;
        if (emailConfirmationViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        emailConfirmationViewModel.getGenerateOTPResponse().observe(lifecycleOwner, new EmailConfirmationActivity$subscribeToViewModel$1(this));
        EmailConfirmationViewModel emailConfirmationViewModel2 = this.viewModel;
        if (emailConfirmationViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        emailConfirmationViewModel2.getGenerateOTPError().observe(lifecycleOwner, new EmailConfirmationActivity$subscribeToViewModel$2(this));
        EmailConfirmationViewModel emailConfirmationViewModel3 = this.viewModel;
        if (emailConfirmationViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        emailConfirmationViewModel3.getShowLoading().observe(lifecycleOwner, new EmailConfirmationActivity$subscribeToViewModel$3(this));
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbEmailConfirmation);
            if (progressBar != null) {
                progressBar.setVisibility(0);
                return;
            }
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbEmailConfirmation);
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

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == ActivityRequestCode.FROM_EMAIL_CONFIRMATION_TO_VALIDATE_OTP.getValue()) {
            setResult(-1);
            finish();
        }
    }
}
