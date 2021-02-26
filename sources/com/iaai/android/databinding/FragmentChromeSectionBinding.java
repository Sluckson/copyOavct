package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;

public abstract class FragmentChromeSectionBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout llFactOptionsData;
    @NonNull
    public final LinearLayout llGenEquipmentData;
    @NonNull
    public final LinearLayout llStanEquipmentData;
    @NonNull
    public final LinearLayout llTechSpecsData;
    @NonNull
    public final ProgressBar pbChromeLoading;
    @NonNull
    public final RecyclerView rvFactEquipment;
    @NonNull
    public final RecyclerView rvGenEquipment;
    @NonNull
    public final RecyclerView rvStanEquipment;
    @NonNull
    public final RecyclerView rvTechEquipment;
    @NonNull
    public final NestedScrollView svBuyNowContainer;
    @NonNull
    public final TextView tvFactSectionHeader;
    @NonNull
    public final TextView tvGenSectionHeader;
    @NonNull
    public final TextView tvStanSectionHeader;
    @NonNull
    public final TextView tvTechSectionHeader;
    @NonNull
    public final TextView tvYearModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected FragmentChromeSectionBinding(Object obj, View view, int i, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ProgressBar progressBar, RecyclerView recyclerView, RecyclerView recyclerView2, RecyclerView recyclerView3, RecyclerView recyclerView4, NestedScrollView nestedScrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5) {
        super(obj, view, i);
        this.llFactOptionsData = linearLayout;
        this.llGenEquipmentData = linearLayout2;
        this.llStanEquipmentData = linearLayout3;
        this.llTechSpecsData = linearLayout4;
        this.pbChromeLoading = progressBar;
        this.rvFactEquipment = recyclerView;
        this.rvGenEquipment = recyclerView2;
        this.rvStanEquipment = recyclerView3;
        this.rvTechEquipment = recyclerView4;
        this.svBuyNowContainer = nestedScrollView;
        this.tvFactSectionHeader = textView;
        this.tvGenSectionHeader = textView2;
        this.tvStanSectionHeader = textView3;
        this.tvTechSectionHeader = textView4;
        this.tvYearModel = textView5;
    }

    @NonNull
    public static FragmentChromeSectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentChromeSectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentChromeSectionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_chrome_section, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentChromeSectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentChromeSectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentChromeSectionBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_chrome_section, (ViewGroup) null, false, obj);
    }

    public static FragmentChromeSectionBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentChromeSectionBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentChromeSectionBinding) bind(obj, view, C2723R.C2728layout.fragment_chrome_section);
    }
}
