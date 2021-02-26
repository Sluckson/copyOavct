package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.CustomViewPager;

public abstract class FragmentFindVehicleSearchLayoutBinding extends ViewDataBinding {
    @NonNull
    public final TabLayout tlFindVehicle;
    @NonNull
    public final TextView tvFindVehicle;
    @NonNull
    public final CustomViewPager vehicleSearchPager;

    protected FragmentFindVehicleSearchLayoutBinding(Object obj, View view, int i, TabLayout tabLayout, TextView textView, CustomViewPager customViewPager) {
        super(obj, view, i);
        this.tlFindVehicle = tabLayout;
        this.tvFindVehicle = textView;
        this.vehicleSearchPager = customViewPager;
    }

    @NonNull
    public static FragmentFindVehicleSearchLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentFindVehicleSearchLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentFindVehicleSearchLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_find_vehicle_search_layout, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentFindVehicleSearchLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentFindVehicleSearchLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentFindVehicleSearchLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_find_vehicle_search_layout, (ViewGroup) null, false, obj);
    }

    public static FragmentFindVehicleSearchLayoutBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFindVehicleSearchLayoutBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentFindVehicleSearchLayoutBinding) bind(obj, view, C2723R.C2728layout.fragment_find_vehicle_search_layout);
    }
}
