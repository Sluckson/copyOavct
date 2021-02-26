package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowItemFastSearchMoreFacetRadioButtonBinding extends ViewDataBinding {
    @NonNull
    public final RadioButton rlRadioButton;

    protected RowItemFastSearchMoreFacetRadioButtonBinding(Object obj, View view, int i, RadioButton radioButton) {
        super(obj, view, i);
        this.rlRadioButton = radioButton;
    }

    @NonNull
    public static RowItemFastSearchMoreFacetRadioButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemFastSearchMoreFacetRadioButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemFastSearchMoreFacetRadioButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_fast_search_more_facet_radio_button, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemFastSearchMoreFacetRadioButtonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemFastSearchMoreFacetRadioButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemFastSearchMoreFacetRadioButtonBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_fast_search_more_facet_radio_button, (ViewGroup) null, false, obj);
    }

    public static RowItemFastSearchMoreFacetRadioButtonBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemFastSearchMoreFacetRadioButtonBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemFastSearchMoreFacetRadioButtonBinding) bind(obj, view, C2723R.C2728layout.row_item_fast_search_more_facet_radio_button);
    }
}
