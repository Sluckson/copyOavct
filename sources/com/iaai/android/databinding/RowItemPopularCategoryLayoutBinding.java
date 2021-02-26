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

public abstract class RowItemPopularCategoryLayoutBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout llPopularCategory;
    @NonNull
    public final TextView tvPopularCategory;

    protected RowItemPopularCategoryLayoutBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.llPopularCategory = linearLayout;
        this.tvPopularCategory = textView;
    }

    @NonNull
    public static RowItemPopularCategoryLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemPopularCategoryLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemPopularCategoryLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_popular_category_layout, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemPopularCategoryLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemPopularCategoryLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemPopularCategoryLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_popular_category_layout, (ViewGroup) null, false, obj);
    }

    public static RowItemPopularCategoryLayoutBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemPopularCategoryLayoutBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemPopularCategoryLayoutBinding) bind(obj, view, C2723R.C2728layout.row_item_popular_category_layout);
    }
}
