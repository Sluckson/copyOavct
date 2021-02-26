package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class ItemBdtPaymentMethodsLayoutBinding extends ViewDataBinding {
    @NonNull
    public final CheckBox cbSetAsDefault;
    @NonNull
    public final ImageView ivAFCInfo1;
    @NonNull
    public final ImageView ivAFCInfo2;
    @NonNull
    public final RadioButton rbAFCInfo;
    @NonNull
    public final RadioButton rbAccountInfo;
    @NonNull
    public final LinearLayout rlAFCInfoLayout;
    @NonNull
    public final TextView tvDailyAllowanceLimit;
    @NonNull
    public final TextView tvErrorMessage;
    @NonNull
    public final TextView tvLinkPayPalAccountInfo;
    @NonNull
    public final TextView tvLinkPaymentMethod;
    @NonNull
    public final TextView tvPayPalFee;
    @NonNull
    public final TextView tvPaymentName;

    protected ItemBdtPaymentMethodsLayoutBinding(Object obj, View view, int i, CheckBox checkBox, ImageView imageView, ImageView imageView2, RadioButton radioButton, RadioButton radioButton2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.cbSetAsDefault = checkBox;
        this.ivAFCInfo1 = imageView;
        this.ivAFCInfo2 = imageView2;
        this.rbAFCInfo = radioButton;
        this.rbAccountInfo = radioButton2;
        this.rlAFCInfoLayout = linearLayout;
        this.tvDailyAllowanceLimit = textView;
        this.tvErrorMessage = textView2;
        this.tvLinkPayPalAccountInfo = textView3;
        this.tvLinkPaymentMethod = textView4;
        this.tvPayPalFee = textView5;
        this.tvPaymentName = textView6;
    }

    @NonNull
    public static ItemBdtPaymentMethodsLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemBdtPaymentMethodsLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemBdtPaymentMethodsLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_bdt_payment_methods_layout, viewGroup, z, obj);
    }

    @NonNull
    public static ItemBdtPaymentMethodsLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemBdtPaymentMethodsLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemBdtPaymentMethodsLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_bdt_payment_methods_layout, (ViewGroup) null, false, obj);
    }

    public static ItemBdtPaymentMethodsLayoutBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBdtPaymentMethodsLayoutBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ItemBdtPaymentMethodsLayoutBinding) bind(obj, view, C2723R.C2728layout.item_bdt_payment_methods_layout);
    }
}
