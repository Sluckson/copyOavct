package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowItemFastSearchFilterFacetLocationBinding extends ViewDataBinding {
    @NonNull
    public final RadioGroup rgContainer;
    @NonNull
    public final TextView tvPostalCode;
    @NonNull
    public final TextView tvPostalValue;
    @NonNull
    public final TextView tvRadius;

    protected RowItemFastSearchFilterFacetLocationBinding(Object obj, View view, int i, RadioGroup radioGroup, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.rgContainer = radioGroup;
        this.tvPostalCode = textView;
        this.tvPostalValue = textView2;
        this.tvRadius = textView3;
    }

    @NonNull
    public static RowItemFastSearchFilterFacetLocationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemFastSearchFilterFacetLocationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemFastSearchFilterFacetLocationBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_fast_search_filter_facet_location, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemFastSearchFilterFacetLocationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemFastSearchFilterFacetLocationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemFastSearchFilterFacetLocationBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_fast_search_filter_facet_location, (ViewGroup) null, false, obj);
    }

    public static RowItemFastSearchFilterFacetLocationBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemFastSearchFilterFacetLocationBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemFastSearchFilterFacetLocationBinding) bind(obj, view, C2723R.C2728layout.row_item_fast_search_filter_facet_location);
    }
}
