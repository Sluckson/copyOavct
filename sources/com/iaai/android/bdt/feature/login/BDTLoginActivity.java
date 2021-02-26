package com.iaai.android.bdt.feature.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.extensions.EditText_ExtensionKt;
import com.iaai.android.bdt.feature.termsofuse.TermsOfUseAuctionRuleActivity;
import com.iaai.android.bdt.model.login.BDTLoginResponse;
import com.iaai.android.bdt.utils.ActivityRequestCode;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.InternetUtil;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import dagger.android.AndroidInjection;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010+\u001a\u00020,H\u0002J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020,H\u0002J\u0010\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u0004H\u0002J\b\u00102\u001a\u00020,H\u0002J\b\u00103\u001a\u00020,H\u0002J\"\u00104\u001a\u00020,2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0014J\u0012\u0010:\u001a\u00020,2\b\u0010;\u001a\u0004\u0018\u00010<H\u0014J\u0010\u0010=\u001a\u00020.2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020.H\u0002J\b\u0010B\u001a\u00020,H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\fR\u001a\u0010\u001f\u001a\u00020 X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010%\u001a\u00020&8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006C"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/login/BDTLoginActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "loginResponse", "Lcom/iaai/android/bdt/model/login/BDTLoginResponse;", "password", "getPassword", "setPassword", "(Ljava/lang/String;)V", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "sharedPrefsHelper", "Lcom/iaai/android/bdt/utils/SharedPrefsHelper;", "getSharedPrefsHelper", "()Lcom/iaai/android/bdt/utils/SharedPrefsHelper;", "setSharedPrefsHelper", "(Lcom/iaai/android/bdt/utils/SharedPrefsHelper;)V", "userId", "getUserId", "setUserId", "username", "getUsername", "setUsername", "viewModel", "Lcom/iaai/android/bdt/feature/login/LoginViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/login/LoginViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/login/LoginViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "checkNetworkConnection", "", "hasAllRequiredField", "", "initializeUI", "launchAuctionRuleActivity", "auctionRule", "login", "navigateFromLogin", "onActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "showLoadingIndicator", "loading", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTLoginActivity.kt */
public final class BDTLoginActivity extends BaseActivity {
    @NotNull
    private final String TAG;
    private HashMap _$_findViewCache;
    /* access modifiers changed from: private */
    public BDTLoginResponse loginResponse;
    @NotNull
    private String password = "";
    @Inject
    @NotNull
    public SessionManager sessionManager;
    @Inject
    @NotNull
    public SharedPrefsHelper sharedPrefsHelper;
    @NotNull
    private String userId = "";
    @NotNull
    private String username = "";
    @NotNull
    public LoginViewModel viewModel;
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

    public BDTLoginActivity() {
        String simpleName = BDTLoginActivity.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "BDTLoginActivity::class.java.simpleName");
        this.TAG = simpleName;
    }

    public static final /* synthetic */ BDTLoginResponse access$getLoginResponse$p(BDTLoginActivity bDTLoginActivity) {
        BDTLoginResponse bDTLoginResponse = bDTLoginActivity.loginResponse;
        if (bDTLoginResponse == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loginResponse");
        }
        return bDTLoginResponse;
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
    public final LoginViewModel getViewModel() {
        LoginViewModel loginViewModel = this.viewModel;
        if (loginViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return loginViewModel;
    }

    public final void setViewModel(@NotNull LoginViewModel loginViewModel) {
        Intrinsics.checkParameterIsNotNull(loginViewModel, "<set-?>");
        this.viewModel = loginViewModel;
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
    public final SharedPrefsHelper getSharedPrefsHelper() {
        SharedPrefsHelper sharedPrefsHelper2 = this.sharedPrefsHelper;
        if (sharedPrefsHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPrefsHelper");
        }
        return sharedPrefsHelper2;
    }

    public final void setSharedPrefsHelper(@NotNull SharedPrefsHelper sharedPrefsHelper2) {
        Intrinsics.checkParameterIsNotNull(sharedPrefsHelper2, "<set-?>");
        this.sharedPrefsHelper = sharedPrefsHelper2;
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

    @NotNull
    public final String getPassword() {
        return this.password;
    }

    public final void setPassword(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.password = str;
    }

    @NotNull
    public final String getUserId() {
        return this.userId;
    }

    public final void setUserId(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.userId = str;
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AndroidInjection.inject((Activity) this);
        setContentView((int) C2723R.C2728layout.activity_bdt_login);
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(LoginViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…ginViewModel::class.java)");
        this.viewModel = (LoginViewModel) viewModel2;
        initializeUI();
        subscribeToViewModel();
    }

    private final void initializeUI() {
        SharedPrefsHelper sharedPrefsHelper2 = this.sharedPrefsHelper;
        if (sharedPrefsHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPrefsHelper");
        }
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        CharSequence charSequence = sharedPrefsHelper2.get(sessionManager2.getPREF_SAVED_USERNAME(), "");
        if (charSequence.length() > 0) {
            ImageView imageView = (ImageView) _$_findCachedViewById(C2723R.C2726id.ivClear);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "ivClear");
            imageView.setVisibility(0);
            ((EditText) _$_findCachedViewById(C2723R.C2726id.etUserName)).setText(charSequence);
        }
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etUserName);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etUserName");
        EditText_ExtensionKt.onChange(editText, new BDTLoginActivity$initializeUI$1(this));
        EditText editText2 = (EditText) _$_findCachedViewById(C2723R.C2726id.etPassword);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "etPassword");
        EditText_ExtensionKt.onChange(editText2, new BDTLoginActivity$initializeUI$2(this));
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivCloseLogin)).setOnClickListener(new BDTLoginActivity$initializeUI$3(this));
        ((ImageView) _$_findCachedViewById(C2723R.C2726id.ivClear)).setOnClickListener(new BDTLoginActivity$initializeUI$4(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvRegisterNow)).setOnClickListener(new BDTLoginActivity$initializeUI$5(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvForgotPassword)).setOnClickListener(new BDTLoginActivity$initializeUI$6(this));
        ((EditText) _$_findCachedViewById(C2723R.C2726id.etPassword)).setOnEditorActionListener(new BDTLoginActivity$initializeUI$7(this));
        ((TextView) _$_findCachedViewById(C2723R.C2726id.tvLogin)).setOnClickListener(new BDTLoginActivity$initializeUI$8(this));
    }

    private final void subscribeToViewModel() {
        LoginViewModel loginViewModel = this.viewModel;
        if (loginViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        loginViewModel.getLoginResponse().observe(lifecycleOwner, new BDTLoginActivity$subscribeToViewModel$1(this));
        LoginViewModel loginViewModel2 = this.viewModel;
        if (loginViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        loginViewModel2.getLoginError().observe(lifecycleOwner, new BDTLoginActivity$subscribeToViewModel$2(this));
        LoginViewModel loginViewModel3 = this.viewModel;
        if (loginViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        loginViewModel3.getShowLoading().observe(lifecycleOwner, new BDTLoginActivity$subscribeToViewModel$3(this));
        LoginViewModel loginViewModel4 = this.viewModel;
        if (loginViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        loginViewModel4.getAuctionRuleResponse().observe(lifecycleOwner, new BDTLoginActivity$subscribeToViewModel$4(this));
        LoginViewModel loginViewModel5 = this.viewModel;
        if (loginViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        loginViewModel5.getAuctionRuleError().observe(lifecycleOwner, new BDTLoginActivity$subscribeToViewModel$5(this));
        LoginViewModel loginViewModel6 = this.viewModel;
        if (loginViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        loginViewModel6.isValidEmail().observe(lifecycleOwner, new BDTLoginActivity$subscribeToViewModel$6(this));
        LoginViewModel loginViewModel7 = this.viewModel;
        if (loginViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        loginViewModel7.isValidEmailError().observe(lifecycleOwner, new BDTLoginActivity$subscribeToViewModel$7(this));
    }

    /* access modifiers changed from: private */
    public final void login() {
        Activity_ExtensionKt.hideSoftKeyboard(this);
        if (hasAllRequiredField()) {
            EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etUserName);
            Intrinsics.checkExpressionValueIsNotNull(editText, "etUserName");
            String obj = editText.getText().toString();
            if (obj != null) {
                this.username = StringsKt.trim((CharSequence) obj).toString();
                EditText editText2 = (EditText) _$_findCachedViewById(C2723R.C2726id.etPassword);
                Intrinsics.checkExpressionValueIsNotNull(editText2, "etPassword");
                String obj2 = editText2.getText().toString();
                if (obj2 != null) {
                    this.password = StringsKt.trim((CharSequence) obj2).toString();
                    LoginViewModel loginViewModel = this.viewModel;
                    if (loginViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    }
                    EditText editText3 = (EditText) _$_findCachedViewById(C2723R.C2726id.etUserName);
                    Intrinsics.checkExpressionValueIsNotNull(editText3, "etUserName");
                    String obj3 = editText3.getText().toString();
                    EditText editText4 = (EditText) _$_findCachedViewById(C2723R.C2726id.etPassword);
                    Intrinsics.checkExpressionValueIsNotNull(editText4, "etPassword");
                    loginViewModel.login(obj3, editText4.getText().toString());
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
        }
    }

    /* access modifiers changed from: private */
    public final boolean hasAllRequiredField() {
        EditText editText = (EditText) _$_findCachedViewById(C2723R.C2726id.etUserName);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etUserName");
        CharSequence obj = editText.getText().toString();
        int length = obj.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = obj.charAt(!z ? i : length) <= ' ';
            if (!z) {
                if (!z2) {
                    z = true;
                } else {
                    i++;
                }
            } else if (!z2) {
                break;
            } else {
                length--;
            }
        }
        String obj2 = obj.subSequence(i, length + 1).toString();
        EditText editText2 = (EditText) _$_findCachedViewById(C2723R.C2726id.etPassword);
        Intrinsics.checkExpressionValueIsNotNull(editText2, "etPassword");
        CharSequence obj3 = editText2.getText().toString();
        int length2 = obj3.length() - 1;
        int i2 = 0;
        boolean z3 = false;
        while (i2 <= length2) {
            boolean z4 = obj3.charAt(!z3 ? i2 : length2) <= ' ';
            if (!z3) {
                if (!z4) {
                    z3 = true;
                } else {
                    i2++;
                }
            } else if (!z4) {
                break;
            } else {
                length2--;
            }
        }
        String obj4 = obj3.subSequence(i2, length2 + 1).toString();
        if (TextUtils.isEmpty(obj2) || TextUtils.isEmpty(obj4)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        if (z) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbLogin);
            if (progressBar != null) {
                progressBar.setVisibility(0);
                return;
            }
            return;
        }
        ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbLogin);
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

    /* access modifiers changed from: private */
    public final void navigateFromLogin() {
        SharedPrefsHelper sharedPrefsHelper2 = this.sharedPrefsHelper;
        if (sharedPrefsHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPrefsHelper");
        }
        String str = sharedPrefsHelper2.get(Constants_MVVM.FCM_REGISTERED_TOKEN, "");
        if (str.length() > 0) {
            LoginViewModel loginViewModel = this.viewModel;
            if (loginViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            }
            loginViewModel.registerFCMToken(this.username, this.password, str);
        }
        setResult(-1);
        finish();
    }

    /* access modifiers changed from: private */
    public final void launchAuctionRuleActivity(String str) {
        Intent intent = new Intent(this, TermsOfUseAuctionRuleActivity.class);
        intent.putExtra(Constants_MVVM.EXTRA_AUCTION_RULE_URL, str);
        startActivityForResult(intent, ActivityRequestCode.FROM_LOGIN_TO_AUCTION_RULE.getValue());
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i != ActivityRequestCode.FROM_LOGIN_TO_EMAIL_CONFIRMATION.getValue()) {
            if (i == ActivityRequestCode.FROM_LOGIN_TO_AUCTION_RULE.getValue() || i == ActivityRequestCode.FROM_LOGIN_TO_TERMS_AND_CONDITIONS.getValue()) {
                setResult(-1);
                finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void checkNetworkConnection() {
        if (InternetUtil.INSTANCE.isInternetOn()) {
            login();
            return;
        }
        String string = getResources().getString(C2723R.string.bdt_lbl_msg_prd_network_error);
        Intrinsics.checkExpressionValueIsNotNull(string, "resources.getString(R.st…bl_msg_prd_network_error)");
        Context_ExtensionKt.showToast(this, string);
        InternetUtil.INSTANCE.observe(this, new BDTLoginActivity$checkNetworkConnection$1(this));
    }
}
