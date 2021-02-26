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

public abstract class RowItemClearfilterLayoutBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivCancelClear;
    @NonNull
    public final LinearLayout layoutClearfilterContainer;
    @NonNull
    public final TextView tvClearfilter;

    protected RowItemClearfilterLayoutBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.ivCancelClear = imageView;
        this.layoutClearfilterContainer = linearLayout;
        this.tvClearfilter = textView;
    }

    @NonNull
    public static RowItemClearfilterLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemClearfilterLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemClearfilterLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_clearfilter_layout, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemClearfilterLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemClearfilterLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemClearfilterLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_clearfilter_layout, (ViewGroup) null, false, obj);
    }

    public static RowItemClearfilterLayoutBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemClearfilterLayoutBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemClearfilterLayoutBinding) bind(obj, view, C2723R.C2728layout.row_item_clearfilter_layout);
    }
}
