package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.iaai.android.C2723R;

public abstract class ActivityBdtForgotPasswordBinding extends ViewDataBinding {
    @NonNull
    public final AppBarLayout appBar;
    @NonNull
    public final Button btnClose;
    @NonNull
    public final ProgressBar pbForgotPassword;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final WebView wvForgotPassword;

    protected ActivityBdtForgotPasswordBinding(Object obj, View view, int i, AppBarLayout appBarLayout, Button button, ProgressBar progressBar, Toolbar toolbar2, WebView webView) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.btnClose = button;
        this.pbForgotPassword = progressBar;
        this.toolbar = toolbar2;
        this.wvForgotPassword = webView;
    }

    @NonNull
    public static ActivityBdtForgotPasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityBdtForgotPasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityBdtForgotPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_bdt_forgot_password, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityBdtForgotPasswordBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityBdtForgotPasswordBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityBdtForgotPasswordBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_bdt_forgot_password, (ViewGroup) null, false, obj);
    }

    public static ActivityBdtForgotPasswordBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBdtForgotPasswordBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityBdtForgotPasswordBinding) bind(obj, view, C2723R.C2728layout.activity_bdt_forgot_password);
    }
}
