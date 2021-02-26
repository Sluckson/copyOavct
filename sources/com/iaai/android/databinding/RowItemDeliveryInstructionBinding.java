package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowItemDeliveryInstructionBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout clStockContainer;
    @NonNull
    public final FrameLayout imgLayout;
    @NonNull
    public final ImageView ivIsSet;
    @NonNull
    public final ImageView ivSelectItem;
    @NonNull
    public final TextView tvBranchInfo;
    @NonNull
    public final TextView tvDeliveryMode;
    @NonNull
    public final TextView tvStockLabel;
    @NonNull
    public final TextView tvStockNumber;
    @NonNull
    public final ImageView vehicleImage;
    @NonNull
    public final TextView vehicleTitle;
    @NonNull
    public final View viewSeparator2;

    protected RowItemDeliveryInstructionBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView3, TextView textView5, View view2) {
        super(obj, view, i);
        this.clStockContainer = constraintLayout;
        this.imgLayout = frameLayout;
        this.ivIsSet = imageView;
        this.ivSelectItem = imageView2;
        this.tvBranchInfo = textView;
        this.tvDeliveryMode = textView2;
        this.tvStockLabel = textView3;
        this.tvStockNumber = textView4;
        this.vehicleImage = imageView3;
        this.vehicleTitle = textView5;
        this.viewSeparator2 = view2;
    }

    @NonNull
    public static RowItemDeliveryInstructionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemDeliveryInstructionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemDeliveryInstructionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_delivery_instruction, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemDeliveryInstructionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemDeliveryInstructionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemDeliveryInstructionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_delivery_instruction, (ViewGroup) null, false, obj);
    }

    public static RowItemDeliveryInstructionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemDeliveryInstructionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemDeliveryInstructionBinding) bind(obj, view, C2723R.C2728layout.row_item_delivery_instruction);
    }
}
