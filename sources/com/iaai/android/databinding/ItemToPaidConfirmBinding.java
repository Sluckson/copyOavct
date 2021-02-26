package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;

public abstract class ItemToPaidConfirmBinding extends ViewDataBinding {
    @Bindable
    protected PaymentDue mPaymentDue;
    @NonNull
    public final TextView tvConfirmAmount;
    @NonNull
    public final TextView tvConfirmYearMakeModel;

    public abstract void setPaymentDue(@Nullable PaymentDue paymentDue);

    protected ItemToPaidConfirmBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvConfirmAmount = textView;
        this.tvConfirmYearMakeModel = textView2;
    }

    @Nullable
    public PaymentDue getPaymentDue() {
        return this.mPaymentDue;
    }

    @NonNull
    public static ItemToPaidConfirmBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemToPaidConfirmBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemToPaidConfirmBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_to_paid_confirm, viewGroup, z, obj);
    }

    @NonNull
    public static ItemToPaidConfirmBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemToPaidConfirmBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemToPaidConfirmBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_to_paid_confirm, (ViewGroup) null, false, obj);
    }

    public static ItemToPaidConfirmBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemToPaidConfirmBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ItemToPaidConfirmBinding) bind(obj, view, C2723R.C2728layout.item_to_paid_confirm);
    }
}
