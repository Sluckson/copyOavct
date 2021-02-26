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

public abstract class RowItemChromeDataLayoutBinding extends ViewDataBinding {
    @NonNull
    public final TextView tvAttributeName;
    @NonNull
    public final TextView tvAttributeValue;

    protected RowItemChromeDataLayoutBinding(Object obj, View view, int i, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.tvAttributeName = textView;
        this.tvAttributeValue = textView2;
    }

    @NonNull
    public static RowItemChromeDataLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemChromeDataLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemChromeDataLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_chrome_data_layout, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemChromeDataLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemChromeDataLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemChromeDataLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_chrome_data_layout, (ViewGroup) null, false, obj);
    }

    public static RowItemChromeDataLayoutBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemChromeDataLayoutBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemChromeDataLayoutBinding) bind(obj, view, C2723R.C2728layout.row_item_chrome_data_layout);
    }
}
