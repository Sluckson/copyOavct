package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.iaai.android.C2723R;

public abstract class ActivityBdtLoginBinding extends ViewDataBinding {
    @NonNull
    public final EditText etPassword;
    @NonNull
    public final EditText etUserName;
    @NonNull
    public final ImageView ivClear;
    @NonNull
    public final ImageView ivCloseLogin;
    @NonNull
    public final ImageView ivIAALogo;
    @NonNull
    public final LinearLayout loginLayout;
    @NonNull
    public final ProgressBar pbLogin;
    @NonNull
    public final RelativeLayout relativelayout;
    @NonNull
    public final RelativeLayout rlLoginContainer;
    @NonNull
    public final TextView tvForgotPassword;
    @NonNull
    public final TextView tvLabelSignIn;
    @NonNull
    public final TextView tvLogin;
    @NonNull
    public final TextView tvRegisterNow;
    @NonNull
    public final TextInputLayout txtInputLayoutPassword;
    @NonNull
    public final TextInputLayout txtInputLayoutUsername;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ActivityBdtLoginBinding(Object obj, View view, int i, EditText editText, EditText editText2, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, ProgressBar progressBar, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        super(obj, view, i);
        this.etPassword = editText;
        this.etUserName = editText2;
        this.ivClear = imageView;
        this.ivCloseLogin = imageView2;
        this.ivIAALogo = imageView3;
        this.loginLayout = linearLayout;
        this.pbLogin = progressBar;
        this.relativelayout = relativeLayout;
        this.rlLoginContainer = relativeLayout2;
        this.tvForgotPassword = textView;
        this.tvLabelSignIn = textView2;
        this.tvLogin = textView3;
        this.tvRegisterNow = textView4;
        this.txtInputLayoutPassword = textInputLayout;
        this.txtInputLayoutUsername = textInputLayout2;
    }

    @NonNull
    public static ActivityBdtLoginBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityBdtLoginBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityBdtLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_bdt_login, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityBdtLoginBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityBdtLoginBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityBdtLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_bdt_login, (ViewGroup) null, false, obj);
    }

    public static ActivityBdtLoginBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityBdtLoginBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityBdtLoginBinding) bind(obj, view, C2723R.C2728layout.activity_bdt_login);
    }
}
