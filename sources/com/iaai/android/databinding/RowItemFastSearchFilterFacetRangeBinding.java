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

public abstract class RowItemFastSearchFilterFacetRangeBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout llContainer;
    @NonNull
    public final TextView tvEnd;
    @NonNull
    public final TextView tvStart;

    protected RowItemFastSearchFilterFacetRangeBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.llContainer = linearLayout;
        this.tvEnd = textView;
        this.tvStart = textView2;
    }

    @NonNull
    public static RowItemFastSearchFilterFacetRangeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemFastSearchFilterFacetRangeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemFastSearchFilterFacetRangeBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_fast_search_filter_facet_range, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemFastSearchFilterFacetRangeBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemFastSearchFilterFacetRangeBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemFastSearchFilterFacetRangeBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_fast_search_filter_facet_range, (ViewGroup) null, false, obj);
    }

    public static RowItemFastSearchFilterFacetRangeBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemFastSearchFilterFacetRangeBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemFastSearchFilterFacetRangeBinding) bind(obj, view, C2723R.C2728layout.row_item_fast_search_filter_facet_range);
    }
}
