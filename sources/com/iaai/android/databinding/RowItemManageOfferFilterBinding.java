package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowItemManageOfferFilterBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivCheck;
    @NonNull
    public final RelativeLayout rlContainer;
    @NonNull
    public final TextView tvCount;
    @NonNull
    public final TextView tvFilterName;

    protected RowItemManageOfferFilterBinding(Object obj, View view, int i, ImageView imageView, RelativeLayout relativeLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.ivCheck = imageView;
        this.rlContainer = relativeLayout;
        this.tvCount = textView;
        this.tvFilterName = textView2;
    }

    @NonNull
    public static RowItemManageOfferFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemManageOfferFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemManageOfferFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_manage_offer_filter, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemManageOfferFilterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemManageOfferFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemManageOfferFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_manage_offer_filter, (ViewGroup) null, false, obj);
    }

    public static RowItemManageOfferFilterBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemManageOfferFilterBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemManageOfferFilterBinding) bind(obj, view, C2723R.C2728layout.row_item_manage_offer_filter);
    }
}
