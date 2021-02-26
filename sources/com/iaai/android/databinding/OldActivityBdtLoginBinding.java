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
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.iaai.android.C2723R;

public abstract class OldActivityBdtLoginBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CardView cardView1;
    @NonNull
    public final RelativeLayout contactUsLayout;
    @NonNull
    public final EditText etPassword;
    @NonNull
    public final EditText etUserName;
    @NonNull
    public final ImageView ivClear;
    @NonNull
    public final LinearLayout linearLayout;
    @NonNull
    public final LinearLayout loginLayout;
    @NonNull
    public final ProgressBar pbLogin;
    @NonNull
    public final RelativeLayout registerNowLayout;
    @NonNull
    public final RelativeLayout relativelayout;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final TextView tvContactUs;
    @NonNull
    public final TextView tvForgotPassword;
    @NonNull
    public final TextView tvLogin;
    @NonNull
    public final TextView tvRegisterNow;
    @NonNull
    public final TextView tvTerms;
    @NonNull
    public final TextInputLayout txtInputLayoutPassword;
    @NonNull
    public final TextInputLayout txtInputLayoutUsername;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected OldActivityBdtLoginBinding(Object obj, View view, int i, CardView cardView2, CardView cardView3, RelativeLayout relativeLayout, EditText editText, EditText editText2, ImageView imageView, LinearLayout linearLayout2, LinearLayout linearLayout3, ProgressBar progressBar, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, Toolbar toolbar2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.cardView1 = cardView3;
        this.contactUsLayout = relativeLayout;
        this.etPassword = editText;
        this.etUserName = editText2;
        this.ivClear = imageView;
        this.linearLayout = linearLayout2;
        this.loginLayout = linearLayout3;
        this.pbLogin = progressBar;
        this.registerNowLayout = relativeLayout2;
        this.relativelayout = relativeLayout3;
        this.toolbar = toolbar2;
        this.tvContactUs = textView;
        this.tvForgotPassword = textView2;
        this.tvLogin = textView3;
        this.tvRegisterNow = textView4;
        this.tvTerms = textView5;
        this.txtInputLayoutPassword = textInputLayout;
        this.txtInputLayoutUsername = textInputLayout2;
    }

    @NonNull
    public static OldActivityBdtLoginBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OldActivityBdtLoginBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (OldActivityBdtLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.old_activity_bdt_login, viewGroup, z, obj);
    }

    @NonNull
    public static OldActivityBdtLoginBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static OldActivityBdtLoginBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (OldActivityBdtLoginBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.old_activity_bdt_login, (ViewGroup) null, false, obj);
    }

    public static OldActivityBdtLoginBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static OldActivityBdtLoginBinding bind(@NonNull View view, @Nullable Object obj) {
        return (OldActivityBdtLoginBinding) bind(obj, view, C2723R.C2728layout.old_activity_bdt_login);
    }
}
