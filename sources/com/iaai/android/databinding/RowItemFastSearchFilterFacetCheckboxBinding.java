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

public abstract class RowItemFastSearchFilterFacetCheckboxBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivCheck;
    @NonNull
    public final ConstraintLayout llMultiSelect;
    @NonNull
    public final TextView tvMultiSelectValue;

    protected RowItemFastSearchFilterFacetCheckboxBinding(Object obj, View view, int i, ImageView imageView, ConstraintLayout constraintLayout, TextView textView) {
        super(obj, view, i);
        this.ivCheck = imageView;
        this.llMultiSelect = constraintLayout;
        this.tvMultiSelectValue = textView;
    }

    @NonNull
    public static RowItemFastSearchFilterFacetCheckboxBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemFastSearchFilterFacetCheckboxBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemFastSearchFilterFacetCheckboxBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_fast_search_filter_facet_checkbox, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemFastSearchFilterFacetCheckboxBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemFastSearchFilterFacetCheckboxBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemFastSearchFilterFacetCheckboxBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_fast_search_filter_facet_checkbox, (ViewGroup) null, false, obj);
    }

    public static RowItemFastSearchFilterFacetCheckboxBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemFastSearchFilterFacetCheckboxBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemFastSearchFilterFacetCheckboxBinding) bind(obj, view, C2723R.C2728layout.row_item_fast_search_filter_facet_checkbox);
    }
}
