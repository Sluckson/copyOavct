package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowItemLayoutLevel1Binding extends ViewDataBinding {
    @NonNull
    public final TextView tvMakeModel;
    @NonNull
    public final TextView tvStockLabel;
    @NonNull
    public final TextView tvStockNo;

    protected RowItemLayoutLevel1Binding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.tvMakeModel = textView;
        this.tvStockLabel = textView2;
        this.tvStockNo = textView3;
    }

    @NonNull
    public static RowItemLayoutLevel1Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemLayoutLevel1Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemLayoutLevel1Binding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_layout_level_1, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemLayoutLevel1Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemLayoutLevel1Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemLayoutLevel1Binding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_layout_level_1, (ViewGroup) null, false, obj);
    }

    public static RowItemLayoutLevel1Binding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemLayoutLevel1Binding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemLayoutLevel1Binding) bind(obj, view, C2723R.C2728layout.row_item_layout_level_1);
    }
}
