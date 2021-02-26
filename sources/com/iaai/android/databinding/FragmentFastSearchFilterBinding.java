package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.tabs.TabLayout;
import com.iaai.android.C2723R;

public abstract class FragmentFastSearchFilterBinding extends ViewDataBinding {
    @NonNull
    public final View emptyRecyclerView;
    @NonNull
    public final ExpandableListView expandableFilter;
    @NonNull
    public final View headerContainer;
    @NonNull
    public final LinearLayout llApplyContainer;
    @NonNull
    public final NestedScrollView nsvContainer;
    @NonNull
    public final ProgressBar pbFilter;
    @NonNull
    public final TabLayout tlFilter;
    @NonNull
    public final TextView tvSaveSearch;
    @NonNull
    public final TextView tvSeeResult;

    protected FragmentFastSearchFilterBinding(Object obj, View view, int i, View view2, ExpandableListView expandableListView, View view3, LinearLayout linearLayout, NestedScrollView nestedScrollView, ProgressBar progressBar, TabLayout tabLayout, TextView textView, TextView textView2) {
        super(obj, view, i);
        this.emptyRecyclerView = view2;
        this.expandableFilter = expandableListView;
        this.headerContainer = view3;
        this.llApplyContainer = linearLayout;
        this.nsvContainer = nestedScrollView;
        this.pbFilter = progressBar;
        this.tlFilter = tabLayout;
        this.tvSaveSearch = textView;
        this.tvSeeResult = textView2;
    }

    @NonNull
    public static FragmentFastSearchFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentFastSearchFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentFastSearchFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_fast_search_filter, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentFastSearchFilterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentFastSearchFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentFastSearchFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_fast_search_filter, (ViewGroup) null, false, obj);
    }

    public static FragmentFastSearchFilterBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFastSearchFilterBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentFastSearchFilterBinding) bind(obj, view, C2723R.C2728layout.fragment_fast_search_filter);
    }
}
