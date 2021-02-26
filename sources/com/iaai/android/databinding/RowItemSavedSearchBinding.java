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

public abstract class RowItemSavedSearchBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivArrowRight;
    @NonNull
    public final TextView tvDate;
    @NonNull
    public final TextView tvRemove;
    @NonNull
    public final TextView tvSearchText;
    @NonNull
    public final TextView tvSearchTitle;

    protected RowItemSavedSearchBinding(Object obj, View view, int i, ImageView imageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.ivArrowRight = imageView;
        this.tvDate = textView;
        this.tvRemove = textView2;
        this.tvSearchText = textView3;
        this.tvSearchTitle = textView4;
    }

    @NonNull
    public static RowItemSavedSearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemSavedSearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemSavedSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_saved_search, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemSavedSearchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemSavedSearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemSavedSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_saved_search, (ViewGroup) null, false, obj);
    }

    public static RowItemSavedSearchBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemSavedSearchBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemSavedSearchBinding) bind(obj, view, C2723R.C2728layout.row_item_saved_search);
    }
}
