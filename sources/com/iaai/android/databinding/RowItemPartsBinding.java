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

public abstract class RowItemPartsBinding extends ViewDataBinding {
    @NonNull
    public final View Separator1;
    @NonNull
    public final LinearLayout llInfo;
    @NonNull
    public final TextView tvICChangeValue;
    @NonNull
    public final TextView tvICDescriptionValue;
    @NonNull
    public final TextView tvPartsValue;

    protected RowItemPartsBinding(Object obj, View view, int i, View view2, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.Separator1 = view2;
        this.llInfo = linearLayout;
        this.tvICChangeValue = textView;
        this.tvICDescriptionValue = textView2;
        this.tvPartsValue = textView3;
    }

    @NonNull
    public static RowItemPartsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemPartsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemPartsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_parts, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemPartsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemPartsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemPartsBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_parts, (ViewGroup) null, false, obj);
    }

    public static RowItemPartsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemPartsBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemPartsBinding) bind(obj, view, C2723R.C2728layout.row_item_parts);
    }
}
