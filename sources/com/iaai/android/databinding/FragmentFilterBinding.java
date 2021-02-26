package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class FragmentFilterBinding extends ViewDataBinding {
    @NonNull
    public final CoordinatorLayout coordinatorLayoutParent;
    @NonNull
    public final ExpandableListView expandableListView;
    @NonNull
    public final ImageButton imgBack;
    @NonNull
    public final View layoutBorderLineClearfilterTop;
    @NonNull
    public final LinearLayout llApplyFilterContainer;
    @NonNull
    public final FrameLayout main;
    @NonNull
    public final ProgressBar pbLoadingFilterList;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final TextView toolbarHeader;
    @NonNull
    public final TextView tvApplyfilter;
    @NonNull
    public final TextView tvClearFilter;

    protected FragmentFilterBinding(Object obj, View view, int i, CoordinatorLayout coordinatorLayout, ExpandableListView expandableListView2, ImageButton imageButton, View view2, LinearLayout linearLayout, FrameLayout frameLayout, ProgressBar progressBar, Toolbar toolbar2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i);
        this.coordinatorLayoutParent = coordinatorLayout;
        this.expandableListView = expandableListView2;
        this.imgBack = imageButton;
        this.layoutBorderLineClearfilterTop = view2;
        this.llApplyFilterContainer = linearLayout;
        this.main = frameLayout;
        this.pbLoadingFilterList = progressBar;
        this.toolbar = toolbar2;
        this.toolbarHeader = textView;
        this.tvApplyfilter = textView2;
        this.tvClearFilter = textView3;
    }

    @NonNull
    public static FragmentFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_filter, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentFilterBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentFilterBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentFilterBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_filter, (ViewGroup) null, false, obj);
    }

    public static FragmentFilterBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentFilterBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentFilterBinding) bind(obj, view, C2723R.C2728layout.fragment_filter);
    }
}
