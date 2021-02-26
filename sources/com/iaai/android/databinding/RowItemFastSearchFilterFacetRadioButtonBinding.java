package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowItemFastSearchFilterFacetRadioButtonBinding extends ViewDataBinding {
    @NonNull
    public final RadioGroup rgContainer;

    protected RowItemFastSearchFilterFacetRadioButtonBinding(Object obj, View view, int i, RadioGroup radioGroup) {
        super(obj, view, i);
        this.rgContainer = radioGroup;
    }

    @NonNull
    public static RowItemFastSearchFilterFacetRadioButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemFastSearchFilterFacetRadioButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemFastSearchFilterFacetRadioButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_fast_search_filter_facet_radio_button, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemFastSearchFilterFacetRadioButtonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemFastSearchFilterFacetRadioButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemFastSearchFilterFacetRadioButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_fast_search_filter_facet_radio_button, (ViewGroup) null, false, obj);
    }

    public static RowItemFastSearchFilterFacetRadioButtonBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemFastSearchFilterFacetRadioButtonBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemFastSearchFilterFacetRadioButtonBinding) bind(obj, view, C2723R.C2728layout.row_item_fast_search_filter_facet_radio_button);
    }
}
