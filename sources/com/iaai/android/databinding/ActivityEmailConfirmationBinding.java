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

public abstract class ActivityEmailConfirmationBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final EditText etConfirmID;
    @NonNull
    public final EditText etLoginID;
    @NonNull
    public final LinearLayout llConfirmLogin;
    @NonNull
    public final LinearLayout llContinue;
    @NonNull
    public final LinearLayout llNewLogin;
    @NonNull
    public final ProgressBar pbEmailConfirmation;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final TextView tvConfirmEmail;
    @NonNull
    public final TextView tvContinue;
    @NonNull
    public final TextView tvCurrentLoginID;
    @NonNull
    public final TextView tvLoginID;
    @NonNull
    public final TextView tvUpdate;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ActivityEmailConfirmationBinding(Object obj, View view, int i, CardView cardView2, EditText editText, EditText editText2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ProgressBar progressBar, Toolbar toolbar2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.etConfirmID = editText;
        this.etLoginID = editText2;
        this.llConfirmLogin = linearLayout;
        this.llContinue = linearLayout2;
        this.llNewLogin = linearLayout3;
        this.pbEmailConfirmation = progressBar;
        this.toolbar = toolbar2;
        this.tvConfirmEmail = textView;
        this.tvContinue = textView2;
        this.tvCurrentLoginID = textView3;
        this.tvLoginID = textView4;
        this.tvUpdate = textView5;
    }

    @NonNull
    public static ActivityEmailConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityEmailConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityEmailConfirmationBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_email_confirmation, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityEmailConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityEmailConfirmationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityEmailConfirmationBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_email_confirmation, (ViewGroup) null, false, obj);
    }

    public static ActivityEmailConfirmationBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityEmailConfirmationBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityEmailConfirmationBinding) bind(obj, view, C2723R.C2728layout.activity_email_confirmation);
    }
}
