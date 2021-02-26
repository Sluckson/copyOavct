package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowItemFastSearchFilterGroupBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivArrow;
    @NonNull
    public final TextView tvClear;
    @NonNull
    public final TextView tvGroupName;
    @NonNull
    public final TextView tvSubText;
    @NonNull
    public final View viewHeader;

    protected RowItemFastSearchFilterGroupBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3, View view2) {
        super(obj, view, i);
        this.ivArrow = imageView;
        this.tvClear = textView;
        this.tvGroupName = textView2;
        this.tvSubText = textView3;
        this.viewHeader = view2;
    }

    @NonNull
    public static RowItemFastSearchFilterGroupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemFastSearchFilterGroupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemFastSearchFilterGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_fast_search_filter_group, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemFastSearchFilterGroupBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemFastSearchFilterGroupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemFastSearchFilterGroupBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_fast_search_filter_group, (ViewGroup) null, false, obj);
    }

    public static RowItemFastSearchFilterGroupBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemFastSearchFilterGroupBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemFastSearchFilterGroupBinding) bind(obj, view, C2723R.C2728layout.row_item_fast_search_filter_group);
    }
}
