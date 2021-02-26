package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;

public abstract class ItemToPaidReviewBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout llFeeLayout;
    @Bindable
    protected PaymentDue mPaymentDue;
    @NonNull
    public final TextView tvAmount;
    @NonNull
    public final TextView tvBranch;
    @NonNull
    public final TextView tvIndicator;
    @NonNull
    public final TextView tvMakeModel;
    @NonNull
    public final TextView tvRemove;

    public abstract void setPaymentDue(@Nullable PaymentDue paymentDue);

    protected ItemToPaidReviewBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.llFeeLayout = linearLayout;
        this.tvAmount = textView;
        this.tvBranch = textView2;
        this.tvIndicator = textView3;
        this.tvMakeModel = textView4;
        this.tvRemove = textView5;
    }

    @Nullable
    public PaymentDue getPaymentDue() {
        return this.mPaymentDue;
    }

    @NonNull
    public static ItemToPaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemToPaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemToPaidReviewBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_to_paid_review, viewGroup, z, obj);
    }

    @NonNull
    public static ItemToPaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemToPaidReviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemToPaidReviewBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_to_paid_review, (ViewGroup) null, false, obj);
    }

    public static ItemToPaidReviewBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemToPaidReviewBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ItemToPaidReviewBinding) bind(obj, view, C2723R.C2728layout.item_to_paid_review);
    }
}
