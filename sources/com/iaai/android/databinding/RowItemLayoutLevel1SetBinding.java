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

public abstract class RowItemLayoutLevel1SetBinding extends ViewDataBinding {
    @NonNull
    public final TextView tvAddress;
    @NonNull
    public final TextView tvMakeModel;
    @NonNull
    public final TextView tvMode;
    @NonNull
    public final TextView tvPickUpBy;
    @NonNull
    public final TextView tvPickUpRole;
    @NonNull
    public final TextView tvStockLabel;
    @NonNull
    public final TextView tvStockNo;

    protected RowItemLayoutLevel1SetBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.tvAddress = textView;
        this.tvMakeModel = textView2;
        this.tvMode = textView3;
        this.tvPickUpBy = textView4;
        this.tvPickUpRole = textView5;
        this.tvStockLabel = textView6;
        this.tvStockNo = textView7;
    }

    @NonNull
    public static RowItemLayoutLevel1SetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemLayoutLevel1SetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemLayoutLevel1SetBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_layout_level_1_set, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemLayoutLevel1SetBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemLayoutLevel1SetBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemLayoutLevel1SetBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_layout_level_1_set, (ViewGroup) null, false, obj);
    }

    public static RowItemLayoutLevel1SetBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemLayoutLevel1SetBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemLayoutLevel1SetBinding) bind(obj, view, C2723R.C2728layout.row_item_layout_level_1_set);
    }
}
