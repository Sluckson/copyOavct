package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;

public abstract class FragmentWatchListBinding extends ViewDataBinding {
    @NonNull
    public final EditText etVinSearch;
    @NonNull
    public final FloatingActionButton fab;
    @NonNull
    public final ImageView ivSearchClear;
    @NonNull
    public final FrameLayout main;
    @NonNull
    public final ProgressBar pbLoadingAuctionSaleList;
    @NonNull
    public final RelativeLayout rlStockVinSearch;
    @NonNull
    public final RecyclerView rvWatchList;
    @NonNull
    public final TextView tvEmptyMessage;
    @NonNull
    public final View vwSepartor;
    @NonNull
    public final View vwSepartorToolbar;

    protected FragmentWatchListBinding(Object obj, View view, int i, EditText editText, FloatingActionButton floatingActionButton, ImageView imageView, FrameLayout frameLayout, ProgressBar progressBar, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView, View view2, View view3) {
        super(obj, view, i);
        this.etVinSearch = editText;
        this.fab = floatingActionButton;
        this.ivSearchClear = imageView;
        this.main = frameLayout;
        this.pbLoadingAuctionSaleList = progressBar;
        this.rlStockVinSearch = relativeLayout;
        this.rvWatchList = recyclerView;
        this.tvEmptyMessage = textView;
        this.vwSepartor = view2;
        this.vwSepartorToolbar = view3;
    }

    @NonNull
    public static FragmentWatchListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentWatchListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentWatchListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_watch_list, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentWatchListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentWatchListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentWatchListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_watch_list, (ViewGroup) null, false, obj);
    }

    public static FragmentWatchListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentWatchListBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentWatchListBinding) bind(obj, view, C2723R.C2728layout.fragment_watch_list);
    }
}
