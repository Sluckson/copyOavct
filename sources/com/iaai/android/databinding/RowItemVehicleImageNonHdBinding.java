package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowItemVehicleImageNonHdBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout llGrid;
    @NonNull
    public final LinearLayout llList;
    @NonNull
    public final ImageView vehicleImagesGrid;
    @NonNull
    public final ImageView vehicleImagesList;

    protected RowItemVehicleImageNonHdBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView, ImageView imageView2) {
        super(obj, view, i);
        this.llGrid = linearLayout;
        this.llList = linearLayout2;
        this.vehicleImagesGrid = imageView;
        this.vehicleImagesList = imageView2;
    }

    @NonNull
    public static RowItemVehicleImageNonHdBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemVehicleImageNonHdBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemVehicleImageNonHdBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_vehicle_image_non_hd, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemVehicleImageNonHdBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemVehicleImageNonHdBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemVehicleImageNonHdBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_vehicle_image_non_hd, (ViewGroup) null, false, obj);
    }

    public static RowItemVehicleImageNonHdBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemVehicleImageNonHdBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemVehicleImageNonHdBinding) bind(obj, view, C2723R.C2728layout.row_item_vehicle_image_non_hd);
    }
}
