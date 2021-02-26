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

public abstract class RowItemRecommendedVehiclesBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivBadgeInd;
    @NonNull
    public final ImageView ivVehicle;
    @NonNull
    public final TextView tvHeaderVehicles;
    @NonNull
    public final TextView tvMessageVehicles;

    protected RowItemRecommendedVehiclesBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.ivBadgeInd = imageView;
        this.ivVehicle = imageView2;
        this.tvHeaderVehicles = textView;
        this.tvMessageVehicles = textView2;
    }

    @NonNull
    public static RowItemRecommendedVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemRecommendedVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemRecommendedVehiclesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_recommended_vehicles, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemRecommendedVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemRecommendedVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemRecommendedVehiclesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_recommended_vehicles, (ViewGroup) null, false, obj);
    }

    public static RowItemRecommendedVehiclesBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemRecommendedVehiclesBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemRecommendedVehiclesBinding) bind(obj, view, C2723R.C2728layout.row_item_recommended_vehicles);
    }
}
