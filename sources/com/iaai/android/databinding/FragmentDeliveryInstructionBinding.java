package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;

public abstract class FragmentDeliveryInstructionBinding extends ViewDataBinding {
    @NonNull
    public final Button btnReviewPayment;
    @NonNull
    public final Button btnSetDelivery;
    @NonNull
    public final LinearLayout llActionContainer;
    @NonNull
    public final ProgressBar pbGetDeliveryMethod;
    @NonNull
    public final RecyclerView rvStockList;

    protected FragmentDeliveryInstructionBinding(Object obj, View view, int i, Button button, Button button2, LinearLayout linearLayout, ProgressBar progressBar, RecyclerView recyclerView) {
        super(obj, view, i);
        this.btnReviewPayment = button;
        this.btnSetDelivery = button2;
        this.llActionContainer = linearLayout;
        this.pbGetDeliveryMethod = progressBar;
        this.rvStockList = recyclerView;
    }

    @NonNull
    public static FragmentDeliveryInstructionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentDeliveryInstructionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentDeliveryInstructionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_delivery_instruction, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentDeliveryInstructionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentDeliveryInstructionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentDeliveryInstructionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_delivery_instruction, (ViewGroup) null, false, obj);
    }

    public static FragmentDeliveryInstructionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDeliveryInstructionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentDeliveryInstructionBinding) bind(obj, view, C2723R.C2728layout.fragment_delivery_instruction);
    }
}
