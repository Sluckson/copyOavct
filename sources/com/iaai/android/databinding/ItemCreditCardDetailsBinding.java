package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class ItemCreditCardDetailsBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivSelect;
    @NonNull
    public final ImageView ivVisa;
    @NonNull
    public final LinearLayout llContainer;
    @NonNull
    public final TextView tvCardNumber;
    @NonNull
    public final TextView tvExpiry;
    @NonNull
    public final TextView tvExpiryValue;

    protected ItemCreditCardDetailsBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.ivSelect = imageView;
        this.ivVisa = imageView2;
        this.llContainer = linearLayout;
        this.tvCardNumber = textView;
        this.tvExpiry = textView2;
        this.tvExpiryValue = textView3;
    }

    @NonNull
    public static ItemCreditCardDetailsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemCreditCardDetailsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemCreditCardDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_credit_card_details, viewGroup, z, obj);
    }

    @NonNull
    public static ItemCreditCardDetailsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemCreditCardDetailsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemCreditCardDetailsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_credit_card_details, (ViewGroup) null, false, obj);
    }

    public static ItemCreditCardDetailsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemCreditCardDetailsBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ItemCreditCardDetailsBinding) bind(obj, view, C2723R.C2728layout.item_credit_card_details);
    }
}
