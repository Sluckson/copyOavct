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

public abstract class RowItemQuickFilterBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout clQuickFilter;
    @NonNull
    public final ImageView imgArrowRight;
    @NonNull
    public final TextView tvFilterTitle;

    protected RowItemQuickFilterBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.clQuickFilter = constraintLayout;
        this.imgArrowRight = imageView;
        this.tvFilterTitle = textView;
    }

    @NonNull
    public static RowItemQuickFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemQuickFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemQuickFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_quick_filter, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemQuickFilterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemQuickFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemQuickFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_quick_filter, (ViewGroup) null, false, obj);
    }

    public static RowItemQuickFilterBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemQuickFilterBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemQuickFilterBinding) bind(obj, view, C2723R.C2728layout.row_item_quick_filter);
    }
}
