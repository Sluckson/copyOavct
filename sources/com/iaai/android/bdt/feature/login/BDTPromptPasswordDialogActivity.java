package com.iaai.android.bdt.feature.login;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.constants.Constants;
import dagger.android.AndroidInjection;
import java.util.Date;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\b\u00100\u001a\u00020-H\u0002J\u0010\u00101\u001a\u00020-2\u0006\u00102\u001a\u000203H\u0002J\b\u00104\u001a\u00020-H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0006\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\u00020\u00188\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\nR\u001a\u0010 \u001a\u00020!X.¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020'8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+¨\u00065"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/login/BDTPromptPasswordDialogActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "password", "getPassword", "setPassword", "(Ljava/lang/String;)V", "promptPasswordDialog", "Lcom/iaai/android/bdt/feature/login/PromptPasswordDialog;", "getPromptPasswordDialog", "()Lcom/iaai/android/bdt/feature/login/PromptPasswordDialog;", "setPromptPasswordDialog", "(Lcom/iaai/android/bdt/feature/login/PromptPasswordDialog;)V", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "sharedPrefsHelper", "Lcom/iaai/android/bdt/utils/SharedPrefsHelper;", "getSharedPrefsHelper", "()Lcom/iaai/android/bdt/utils/SharedPrefsHelper;", "setSharedPrefsHelper", "(Lcom/iaai/android/bdt/utils/SharedPrefsHelper;)V", "username", "getUsername", "setUsername", "viewModel", "Lcom/iaai/android/bdt/feature/login/LoginViewModel;", "getViewModel", "()Lcom/iaai/android/bdt/feature/login/LoginViewModel;", "setViewModel", "(Lcom/iaai/android/bdt/feature/login/LoginViewModel;)V", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "getViewModelFactory", "()Landroidx/lifecycle/ViewModelProvider$Factory;", "setViewModelFactory", "(Landroidx/lifecycle/ViewModelProvider$Factory;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "showAlert", "showLoadingIndicator", "loading", "", "subscribeToViewModel", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTPromptPasswordDialogActivity.kt */
public final class BDTPromptPasswordDialogActivity extends AppCompatActivity {
    @NotNull
    private final String TAG;
    private HashMap _$_findViewCache;
    @NotNull
    private String password = "";
    @NotNull
    public PromptPasswordDialog promptPasswordDialog;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    @Inject
    @NotNull
    public SharedPrefsHelper sharedPrefsHelper;
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

    public BDTPromptPasswordDialogActivity() {
        String simpleName = BDTPromptPasswordDialogActivity.class.getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "BDTPromptPasswordDialogA…ty::class.java.simpleName");
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
    public final PromptPasswordDialog getPromptPasswordDialog() {
        PromptPasswordDialog promptPasswordDialog2 = this.promptPasswordDialog;
        if (promptPasswordDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptPasswordDialog");
        }
        return promptPasswordDialog2;
    }

    public final void setPromptPasswordDialog(@NotNull PromptPasswordDialog promptPasswordDialog2) {
        Intrinsics.checkParameterIsNotNull(promptPasswordDialog2, "<set-?>");
        this.promptPasswordDialog = promptPasswordDialog2;
    }

    @NotNull
    public final String getTAG() {
        return this.TAG;
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
        requestWindowFeature(1);
        setTitle("");
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        FragmentActivity fragmentActivity = this;
        ViewModelProvider.Factory factory = this.viewModelFactory;
        if (factory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModelFactory");
        }
        ViewModel viewModel2 = ViewModelProviders.m18of(fragmentActivity, factory).get(LoginViewModel.class);
        Intrinsics.checkExpressionValueIsNotNull(viewModel2, "ViewModelProviders.of(th…ginViewModel::class.java)");
        this.viewModel = (LoginViewModel) viewModel2;
        subscribeToViewModel();
        SharedPrefsHelper sharedPrefsHelper2 = this.sharedPrefsHelper;
        if (sharedPrefsHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPrefsHelper");
        }
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        this.username = sharedPrefsHelper2.get(sessionManager2.getPREF_SAVED_USERNAME(), "");
        showAlert();
    }

    private final void subscribeToViewModel() {
        LoginViewModel loginViewModel = this.viewModel;
        if (loginViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        LifecycleOwner lifecycleOwner = this;
        loginViewModel.getLoginResponse().observe(lifecycleOwner, new BDTPromptPasswordDialogActivity$subscribeToViewModel$1(this));
        LoginViewModel loginViewModel2 = this.viewModel;
        if (loginViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        loginViewModel2.getLoginError().observe(lifecycleOwner, new BDTPromptPasswordDialogActivity$subscribeToViewModel$2(this));
        LoginViewModel loginViewModel3 = this.viewModel;
        if (loginViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        loginViewModel3.getShowLoading().observe(lifecycleOwner, new BDTPromptPasswordDialogActivity$subscribeToViewModel$3(this));
    }

    /* access modifiers changed from: private */
    public final void showLoadingIndicator(boolean z) {
        PromptPasswordDialog promptPasswordDialog2 = this.promptPasswordDialog;
        if (promptPasswordDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptPasswordDialog");
        }
        promptPasswordDialog2.showLoadingIndicator(z);
    }

    private final void showAlert() {
        this.promptPasswordDialog = new PromptPasswordDialog(this, new BDTPromptPasswordDialogActivity$showAlert$1(this));
        SharedPrefsHelper sharedPrefsHelper2 = this.sharedPrefsHelper;
        if (sharedPrefsHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPrefsHelper");
        }
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        long j = 0;
        Long l = sharedPrefsHelper2.get(sessionManager2.getPREF_SAVE_LOGIN_TIME_STAMP(), 0);
        Date date = new Date();
        if (l != null) {
            j = l.longValue();
        }
        date.setTime(j);
        String format = DateHelper.format(date, Constants.DATE_PATTERN_LAST_LOGIN_TIME);
        PromptPasswordDialog promptPasswordDialog2 = this.promptPasswordDialog;
        if (promptPasswordDialog2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptPasswordDialog");
        }
        Window window = promptPasswordDialog2.getWindow();
        if (window != null) {
            window.setGravity(48);
        }
        PromptPasswordDialog promptPasswordDialog3 = this.promptPasswordDialog;
        if (promptPasswordDialog3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptPasswordDialog");
        }
        promptPasswordDialog3.show();
        PromptPasswordDialog promptPasswordDialog4 = this.promptPasswordDialog;
        if (promptPasswordDialog4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptPasswordDialog");
        }
        promptPasswordDialog4.setCanceledOnTouchOutside(false);
        PromptPasswordDialog promptPasswordDialog5 = this.promptPasswordDialog;
        if (promptPasswordDialog5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptPasswordDialog");
        }
        promptPasswordDialog5.setOnCancelListener(new BDTPromptPasswordDialogActivity$showAlert$2(this));
        PromptPasswordDialog promptPasswordDialog6 = this.promptPasswordDialog;
        if (promptPasswordDialog6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promptPasswordDialog");
        }
        String str = this.username;
        Intrinsics.checkExpressionValueIsNotNull(format, "lastLoginTimeString");
        promptPasswordDialog6.updateLoginNameAndTimeStamp(str, format);
    }
}
