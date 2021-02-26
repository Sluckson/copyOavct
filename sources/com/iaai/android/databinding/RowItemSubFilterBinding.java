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

public abstract class RowItemSubFilterBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout clContainer;
    @NonNull
    public final ImageView ivItemSelected;
    @NonNull
    public final TextView tvFilterText;

    protected RowItemSubFilterBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.clContainer = constraintLayout;
        this.ivItemSelected = imageView;
        this.tvFilterText = textView;
    }

    @NonNull
    public static RowItemSubFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemSubFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemSubFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_sub_filter, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemSubFilterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemSubFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemSubFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_sub_filter, (ViewGroup) null, false, obj);
    }

    public static RowItemSubFilterBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemSubFilterBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemSubFilterBinding) bind(obj, view, C2723R.C2728layout.row_item_sub_filter);
    }
}
