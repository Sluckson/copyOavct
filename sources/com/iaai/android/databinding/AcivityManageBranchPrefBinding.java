package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;

public abstract class AcivityManageBranchPrefBinding extends ViewDataBinding {
    @NonNull
    public final AppBarLayout appBar;
    @NonNull
    public final Button btnCheckOut;
    @NonNull
    public final FloatingActionButton fab;
    @NonNull
    public final ImageView ivToolTip;
    @NonNull
    public final LinearLayout llSetDeliveryLayout;
    @NonNull
    public final FrameLayout main;
    @NonNull
    public final ProgressBar pbLoadingManageBranchList;
    @NonNull
    public final RecyclerView rvManageBranchList;
    @NonNull
    public final RelativeLayout saleDocToolbarRelativelayout;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final TextView toolbarTitle;
    @NonNull
    public final View viewHeader;

    protected AcivityManageBranchPrefBinding(Object obj, View view, int i, AppBarLayout appBarLayout, Button button, FloatingActionButton floatingActionButton, ImageView imageView, LinearLayout linearLayout, FrameLayout frameLayout, ProgressBar progressBar, RecyclerView recyclerView, RelativeLayout relativeLayout, Toolbar toolbar2, TextView textView, View view2) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.btnCheckOut = button;
        this.fab = floatingActionButton;
        this.ivToolTip = imageView;
        this.llSetDeliveryLayout = linearLayout;
        this.main = frameLayout;
        this.pbLoadingManageBranchList = progressBar;
        this.rvManageBranchList = recyclerView;
        this.saleDocToolbarRelativelayout = relativeLayout;
        this.toolbar = toolbar2;
        this.toolbarTitle = textView;
        this.viewHeader = view2;
    }

    @NonNull
    public static AcivityManageBranchPrefBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcivityManageBranchPrefBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AcivityManageBranchPrefBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.acivity_manage_branch_pref, viewGroup, z, obj);
    }

    @NonNull
    public static AcivityManageBranchPrefBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcivityManageBranchPrefBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AcivityManageBranchPrefBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.acivity_manage_branch_pref, (ViewGroup) null, false, obj);
    }

    public static AcivityManageBranchPrefBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AcivityManageBranchPrefBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AcivityManageBranchPrefBinding) bind(obj, view, C2723R.C2728layout.acivity_manage_branch_pref);
    }
}
