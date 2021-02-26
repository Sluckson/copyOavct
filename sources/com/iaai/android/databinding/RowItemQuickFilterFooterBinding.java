package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowItemQuickFilterFooterBinding extends ViewDataBinding {
    @NonNull
    public final ImageView icQuickFilterViewMore;
    @NonNull
    public final LinearLayout quickFilterViewMore;
    @NonNull
    public final TextView txtQuickFilterViewMore;

    protected RowItemQuickFilterFooterBinding(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.icQuickFilterViewMore = imageView;
        this.quickFilterViewMore = linearLayout;
        this.txtQuickFilterViewMore = textView;
    }

    @NonNull
    public static RowItemQuickFilterFooterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemQuickFilterFooterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemQuickFilterFooterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_quick_filter_footer, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemQuickFilterFooterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemQuickFilterFooterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemQuickFilterFooterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_quick_filter_footer, (ViewGroup) null, false, obj);
    }

    public static RowItemQuickFilterFooterBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemQuickFilterFooterBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemQuickFilterFooterBinding) bind(obj, view, C2723R.C2728layout.row_item_quick_filter_footer);
    }
}
