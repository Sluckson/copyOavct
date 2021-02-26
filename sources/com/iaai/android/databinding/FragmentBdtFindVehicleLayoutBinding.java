package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class FragmentBdtFindVehicleLayoutBinding extends ViewDataBinding {
    @NonNull
    public final ProgressBar pbFilter;

    protected FragmentBdtFindVehicleLayoutBinding(Object obj, View view, int i, ProgressBar progressBar) {
        super(obj, view, i);
        this.pbFilter = progressBar;
    }

    @NonNull
    public static FragmentBdtFindVehicleLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentBdtFindVehicleLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentBdtFindVehicleLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_bdt_find_vehicle_layout, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentBdtFindVehicleLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentBdtFindVehicleLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentBdtFindVehicleLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_bdt_find_vehicle_layout, (ViewGroup) null, false, obj);
    }

    public static FragmentBdtFindVehicleLayoutBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBdtFindVehicleLayoutBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentBdtFindVehicleLayoutBinding) bind(obj, view, C2723R.C2728layout.fragment_bdt_find_vehicle_layout);
    }
}
