package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowHeaderDeliveryInstructionBinding extends ViewDataBinding {
    @NonNull
    public final TextView tvHeaderMsg;
    @NonNull
    public final TextView tvSetForAll;
    @NonNull
    public final View viewSeparator2;

    protected RowHeaderDeliveryInstructionBinding(Object obj, View view, int i, TextView textView, TextView textView2, View view2) {
        super(obj, view, i);
        this.tvHeaderMsg = textView;
        this.tvSetForAll = textView2;
        this.viewSeparator2 = view2;
    }

    @NonNull
    public static RowHeaderDeliveryInstructionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowHeaderDeliveryInstructionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowHeaderDeliveryInstructionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_header_delivery_instruction, viewGroup, z, obj);
    }

    @NonNull
    public static RowHeaderDeliveryInstructionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowHeaderDeliveryInstructionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowHeaderDeliveryInstructionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_header_delivery_instruction, (ViewGroup) null, false, obj);
    }

    public static RowHeaderDeliveryInstructionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowHeaderDeliveryInstructionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowHeaderDeliveryInstructionBinding) bind(obj, view, C2723R.C2728layout.row_header_delivery_instruction);
    }
}
