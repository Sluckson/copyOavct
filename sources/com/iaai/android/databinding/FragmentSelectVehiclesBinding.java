package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;

public abstract class FragmentSelectVehiclesBinding extends ViewDataBinding {
    @NonNull
    public final Button btnCheckOut;
    @NonNull
    public final LinearLayout llCheckOutLayout;
    @NonNull
    public final ProgressBar pbToBePaid;
    @NonNull
    public final RelativeLayout rlTotalInfo;
    @NonNull
    public final RecyclerView rvSelectedVehicle;
    @NonNull
    public final TextView tvCDFAmount;
    @NonNull
    public final TextView tvSelectedVehicle;
    @NonNull
    public final TextView tvTotal;
    @NonNull
    public final TextView tvTotalSelectedAmount;

    protected FragmentSelectVehiclesBinding(Object obj, View view, int i, Button button, LinearLayout linearLayout, ProgressBar progressBar, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i);
        this.btnCheckOut = button;
        this.llCheckOutLayout = linearLayout;
        this.pbToBePaid = progressBar;
        this.rlTotalInfo = relativeLayout;
        this.rvSelectedVehicle = recyclerView;
        this.tvCDFAmount = textView;
        this.tvSelectedVehicle = textView2;
        this.tvTotal = textView3;
        this.tvTotalSelectedAmount = textView4;
    }

    @NonNull
    public static FragmentSelectVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSelectVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentSelectVehiclesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_select_vehicles, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentSelectVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSelectVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentSelectVehiclesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_select_vehicles, (ViewGroup) null, false, obj);
    }

    public static FragmentSelectVehiclesBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSelectVehiclesBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentSelectVehiclesBinding) bind(obj, view, C2723R.C2728layout.fragment_select_vehicles);
    }
}
