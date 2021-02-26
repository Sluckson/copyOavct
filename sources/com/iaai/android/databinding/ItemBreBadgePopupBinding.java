package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class ItemBreBadgePopupBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivBadge;
    @NonNull
    public final TextView tvBadgeText;

    protected ItemBreBadgePopupBinding(Object obj, View view, int i, ImageView imageView, TextView textView) {
        super(obj, view, i);
        this.ivBadge = imageView;
        this.tvBadgeText = textView;
    }

    @NonNull
    public static ItemBreBadgePopupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemBreBadgePopupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemBreBadgePopupBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_bre_badge_popup, viewGroup, z, obj);
    }

    @NonNull
    public static ItemBreBadgePopupBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemBreBadgePopupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemBreBadgePopupBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_bre_badge_popup, (ViewGroup) null, false, obj);
    }

    public static ItemBreBadgePopupBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemBreBadgePopupBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ItemBreBadgePopupBinding) bind(obj, view, C2723R.C2728layout.item_bre_badge_popup);
    }
}
