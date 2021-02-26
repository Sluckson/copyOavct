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

public abstract class RowItemConditionInfoBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivEngineLink;
    @NonNull
    public final LinearLayout llInfo;
    @NonNull
    public final TextView tvLabelCondition;
    @NonNull
    public final TextView tvValueCondition;

    protected RowItemConditionInfoBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.ivEngineLink = imageView;
        this.llInfo = linearLayout;
        this.tvLabelCondition = textView;
        this.tvValueCondition = textView2;
    }

    @NonNull
    public static RowItemConditionInfoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemConditionInfoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemConditionInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_condition_info, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemConditionInfoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemConditionInfoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemConditionInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_condition_info, (ViewGroup) null, false, obj);
    }

    public static RowItemConditionInfoBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemConditionInfoBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemConditionInfoBinding) bind(obj, view, C2723R.C2728layout.row_item_condition_info);
    }
}
