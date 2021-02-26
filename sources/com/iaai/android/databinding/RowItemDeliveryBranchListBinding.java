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

public abstract class RowItemDeliveryBranchListBinding extends ViewDataBinding {
    @NonNull
    public final TextView branchName;
    @NonNull
    public final LinearLayout llBranchNameInfo;

    protected RowItemDeliveryBranchListBinding(Object obj, View view, int i, TextView textView, LinearLayout linearLayout) {
        super(obj, view, i);
        this.branchName = textView;
        this.llBranchNameInfo = linearLayout;
    }

    @NonNull
    public static RowItemDeliveryBranchListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemDeliveryBranchListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemDeliveryBranchListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_delivery_branch_list, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemDeliveryBranchListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemDeliveryBranchListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemDeliveryBranchListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_delivery_branch_list, (ViewGroup) null, false, obj);
    }

    public static RowItemDeliveryBranchListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemDeliveryBranchListBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemDeliveryBranchListBinding) bind(obj, view, C2723R.C2728layout.row_item_delivery_branch_list);
    }
}
