package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowItemCostCalculatorBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout llCostInfo;
    @NonNull
    public final TextView tvLabelCost;
    @NonNull
    public final TextView tvValueCost;
    @NonNull
    public final View view;

    protected RowItemCostCalculatorBinding(Object obj, View view2, int i, LinearLayout linearLayout, TextView textView, TextView textView2, View view3) {
        super(obj, view2, i);
        this.llCostInfo = linearLayout;
        this.tvLabelCost = textView;
        this.tvValueCost = textView2;
        this.view = view3;
    }

    @NonNull
    public static RowItemCostCalculatorBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemCostCalculatorBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemCostCalculatorBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_cost_calculator, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemCostCalculatorBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemCostCalculatorBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemCostCalculatorBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_cost_calculator, (ViewGroup) null, false, obj);
    }

    public static RowItemCostCalculatorBinding bind(@NonNull View view2) {
        return bind(view2, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemCostCalculatorBinding bind(@NonNull View view2, @Nullable Object obj) {
        return (RowItemCostCalculatorBinding) bind(obj, view2, C2723R.C2728layout.row_item_cost_calculator);
    }
}
