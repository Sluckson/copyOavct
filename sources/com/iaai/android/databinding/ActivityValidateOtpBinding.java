package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class ActivityValidateOtpBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final EditText etPIN;
    @NonNull
    public final LinearLayout layoutEditEmail;
    @NonNull
    public final LinearLayout llConfirmPIN;
    @NonNull
    public final LinearLayout llPIN;
    @NonNull
    public final LinearLayout llResendPIN;
    @NonNull
    public final ProgressBar pbConfirmPIN;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final TextView tvConfirmPIN;
    @NonNull
    public final TextView tvEditEmail;
    @NonNull
    public final TextView tvEmail;
    @NonNull
    public final TextView tvEnterPIN;
    @NonNull
    public final TextView tvResend;
    @NonNull
    public final TextView tvVerificationMsg;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ActivityValidateOtpBinding(Object obj, View view, int i, CardView cardView2, EditText editText, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ProgressBar progressBar, Toolbar toolbar2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.etPIN = editText;
        this.layoutEditEmail = linearLayout;
        this.llConfirmPIN = linearLayout2;
        this.llPIN = linearLayout3;
        this.llResendPIN = linearLayout4;
        this.pbConfirmPIN = progressBar;
        this.toolbar = toolbar2;
        this.tvConfirmPIN = textView;
        this.tvEditEmail = textView2;
        this.tvEmail = textView3;
        this.tvEnterPIN = textView4;
        this.tvResend = textView5;
        this.tvVerificationMsg = textView6;
    }

    @NonNull
    public static ActivityValidateOtpBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityValidateOtpBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityValidateOtpBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_validate_otp, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityValidateOtpBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityValidateOtpBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityValidateOtpBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_validate_otp, (ViewGroup) null, false, obj);
    }

    public static ActivityValidateOtpBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityValidateOtpBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityValidateOtpBinding) bind(obj, view, C2723R.C2728layout.activity_validate_otp);
    }
}
