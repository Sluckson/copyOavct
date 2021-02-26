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

public abstract class RowItemSortLayoutBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout layoutSortContainer;
    @NonNull
    public final TextView tvSort;

    protected RowItemSortLayoutBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.layoutSortContainer = linearLayout;
        this.tvSort = textView;
    }

    @NonNull
    public static RowItemSortLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemSortLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemSortLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_sort_layout, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemSortLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemSortLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemSortLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_sort_layout, (ViewGroup) null, false, obj);
    }

    public static RowItemSortLayoutBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemSortLayoutBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemSortLayoutBinding) bind(obj, view, C2723R.C2728layout.row_item_sort_layout);
    }
}
