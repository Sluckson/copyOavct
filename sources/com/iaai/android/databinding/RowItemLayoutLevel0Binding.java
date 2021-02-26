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

public abstract class RowItemLayoutLevel0Binding extends ViewDataBinding {
    @NonNull
    public final TextView tvBranchName;
    @NonNull
    public final TextView tvChange;

    protected RowItemLayoutLevel0Binding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvBranchName = textView;
        this.tvChange = textView2;
    }

    @NonNull
    public static RowItemLayoutLevel0Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemLayoutLevel0Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemLayoutLevel0Binding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_layout_level_0, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemLayoutLevel0Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemLayoutLevel0Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemLayoutLevel0Binding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_layout_level_0, (ViewGroup) null, false, obj);
    }

    public static RowItemLayoutLevel0Binding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemLayoutLevel0Binding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemLayoutLevel0Binding) bind(obj, view, C2723R.C2728layout.row_item_layout_level_0);
    }
}
