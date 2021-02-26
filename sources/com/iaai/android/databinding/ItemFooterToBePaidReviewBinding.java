package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class ItemFooterToBePaidReviewBinding extends ViewDataBinding {
    @NonNull
    public final RelativeLayout rlPaymentMethods;
    @NonNull
    public final TextView tvChangePayment;
    @NonNull
    public final TextView tvPaymentMethod;
    @NonNull
    public final TextView tvPaymentMode;
    @NonNull
    public final View viewSeparator2;

    protected ItemFooterToBePaidReviewBinding(Object obj, View view, int i, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i);
        this.rlPaymentMethods = relativeLayout;
        this.tvChangePayment = textView;
        this.tvPaymentMethod = textView2;
        this.tvPaymentMode = textView3;
        this.viewSeparator2 = view2;
    }

    @NonNull
    public static ItemFooterToBePaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemFooterToBePaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemFooterToBePaidReviewBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_footer_to_be_paid_review, viewGroup, z, obj);
    }

    @NonNull
    public static ItemFooterToBePaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemFooterToBePaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemFooterToBePaidReviewBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_footer_to_be_paid_review, (ViewGroup) null, false, obj);
    }

    public static ItemFooterToBePaidReviewBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemFooterToBePaidReviewBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ItemFooterToBePaidReviewBinding) bind(obj, view, C2723R.C2728layout.item_footer_to_be_paid_review);
    }
}
