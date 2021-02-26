package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;

public abstract class FragmentSavedSearchBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout llEmptySearchResult;
    @NonNull
    public final ProgressBar pbSavedSearch;
    @NonNull
    public final RecyclerView rvSavedSearch;
    @NonNull
    public final FloatingActionButton savedFab;
    @NonNull
    public final View viewSeparator1;

    protected FragmentSavedSearchBinding(Object obj, View view, int i, LinearLayout linearLayout, ProgressBar progressBar, RecyclerView recyclerView, FloatingActionButton floatingActionButton, View view2) {
        super(obj, view, i);
        this.llEmptySearchResult = linearLayout;
        this.pbSavedSearch = progressBar;
        this.rvSavedSearch = recyclerView;
        this.savedFab = floatingActionButton;
        this.viewSeparator1 = view2;
    }

    @NonNull
    public static FragmentSavedSearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSavedSearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentSavedSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_saved_search, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentSavedSearchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSavedSearchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentSavedSearchBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_saved_search, (ViewGroup) null, false, obj);
    }

    public static FragmentSavedSearchBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSavedSearchBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentSavedSearchBinding) bind(obj, view, C2723R.C2728layout.fragment_saved_search);
    }
}
