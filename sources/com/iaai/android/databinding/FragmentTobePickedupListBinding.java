package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;

public abstract class FragmentTobePickedupListBinding extends ViewDataBinding {
    @NonNull
    public final FloatingActionButton fab;
    @NonNull
    public final FrameLayout main;
    @NonNull
    public final ProgressBar pbLoadingAuctionSaleList;
    @NonNull
    public final RecyclerView rvToBePickedUpList;
    @NonNull
    public final TextView tvEmptyMessage;
    @NonNull
    public final View vwSepartorToolbar;

    protected FragmentTobePickedupListBinding(Object obj, View view, int i, FloatingActionButton floatingActionButton, FrameLayout frameLayout, ProgressBar progressBar, RecyclerView recyclerView, TextView textView, View view2) {
        super(obj, view, i);
        this.fab = floatingActionButton;
        this.main = frameLayout;
        this.pbLoadingAuctionSaleList = progressBar;
        this.rvToBePickedUpList = recyclerView;
        this.tvEmptyMessage = textView;
        this.vwSepartorToolbar = view2;
    }

    @NonNull
    public static FragmentTobePickedupListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentTobePickedupListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentTobePickedupListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_tobe_pickedup_list, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentTobePickedupListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentTobePickedupListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentTobePickedupListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_tobe_pickedup_list, (ViewGroup) null, false, obj);
    }

    public static FragmentTobePickedupListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentTobePickedupListBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentTobePickedupListBinding) bind(obj, view, C2723R.C2728layout.fragment_tobe_pickedup_list);
    }
}
