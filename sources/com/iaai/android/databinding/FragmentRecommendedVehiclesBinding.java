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
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;

public abstract class FragmentRecommendedVehiclesBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivSeparator;
    @NonNull
    public final RecyclerView rvRecommendedVehicles;
    @NonNull
    public final TextView tvRecommended;

    protected FragmentRecommendedVehiclesBinding(Object obj, View view, int i, ImageView imageView, RecyclerView recyclerView, TextView textView) {
        super(obj, view, i);
        this.ivSeparator = imageView;
        this.rvRecommendedVehicles = recyclerView;
        this.tvRecommended = textView;
    }

    @NonNull
    public static FragmentRecommendedVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentRecommendedVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentRecommendedVehiclesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_recommended_vehicles, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentRecommendedVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentRecommendedVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentRecommendedVehiclesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_recommended_vehicles, (ViewGroup) null, false, obj);
    }

    public static FragmentRecommendedVehiclesBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentRecommendedVehiclesBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentRecommendedVehiclesBinding) bind(obj, view, C2723R.C2728layout.fragment_recommended_vehicles);
    }
}
