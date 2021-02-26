package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;

public abstract class FragmentSelectVehiclesLandBinding extends ViewDataBinding {
    @NonNull
    public final Button btnCheckOut;
    @NonNull
    public final FrameLayout flContainer;
    @NonNull
    public final LinearLayout llCheckOutLayout;
    @NonNull
    public final ProgressBar pbToBePaid;
    @NonNull
    public final RecyclerView rvSelectedVehicle;
    @NonNull
    public final View selectVehiclesToolbar;

    protected FragmentSelectVehiclesLandBinding(Object obj, View view, int i, Button button, FrameLayout frameLayout, LinearLayout linearLayout, ProgressBar progressBar, RecyclerView recyclerView, View view2) {
        super(obj, view, i);
        this.btnCheckOut = button;
        this.flContainer = frameLayout;
        this.llCheckOutLayout = linearLayout;
        this.pbToBePaid = progressBar;
        this.rvSelectedVehicle = recyclerView;
        this.selectVehiclesToolbar = view2;
    }

    @NonNull
    public static FragmentSelectVehiclesLandBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSelectVehiclesLandBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentSelectVehiclesLandBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_select_vehicles_land, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentSelectVehiclesLandBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSelectVehiclesLandBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentSelectVehiclesLandBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_select_vehicles_land, (ViewGroup) null, false, obj);
    }

    public static FragmentSelectVehiclesLandBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSelectVehiclesLandBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentSelectVehiclesLandBinding) bind(obj, view, C2723R.C2728layout.fragment_select_vehicles_land);
    }
}
