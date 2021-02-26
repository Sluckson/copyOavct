package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowMakeItemFilterBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout clContainer;
    @NonNull
    public final ImageView ivItemSelected;
    @NonNull
    public final TextView tvFilterText;
    @NonNull
    public final TextView tvMakeLabel;

    protected RowMakeItemFilterBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.clContainer = constraintLayout;
        this.ivItemSelected = imageView;
        this.tvFilterText = textView;
        this.tvMakeLabel = textView2;
    }

    @NonNull
    public static RowMakeItemFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowMakeItemFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowMakeItemFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_make_item_filter, viewGroup, z, obj);
    }

    @NonNull
    public static RowMakeItemFilterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowMakeItemFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowMakeItemFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_make_item_filter, (ViewGroup) null, false, obj);
    }

    public static RowMakeItemFilterBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowMakeItemFilterBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowMakeItemFilterBinding) bind(obj, view, C2723R.C2728layout.row_make_item_filter);
    }
}
