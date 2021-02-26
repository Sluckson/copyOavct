package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;

public abstract class FragmentSalesDocumentBinding extends ViewDataBinding {
    @NonNull
    public final Button btnCheckOut;
    @NonNull
    public final FloatingActionButton fab;
    @NonNull
    public final LinearLayout llCheckOutLayout;
    @NonNull
    public final FrameLayout main;
    @NonNull
    public final ProgressBar pbLoadingAuctionSaleList;
    @NonNull
    public final RecyclerView rvSalDocList;
    @NonNull
    public final TextView tvEmptyMessage;
    @NonNull
    public final View vwSepartorToolbar;

    protected FragmentSalesDocumentBinding(Object obj, View view, int i, Button button, FloatingActionButton floatingActionButton, LinearLayout linearLayout, FrameLayout frameLayout, ProgressBar progressBar, RecyclerView recyclerView, TextView textView, View view2) {
        super(obj, view, i);
        this.btnCheckOut = button;
        this.fab = floatingActionButton;
        this.llCheckOutLayout = linearLayout;
        this.main = frameLayout;
        this.pbLoadingAuctionSaleList = progressBar;
        this.rvSalDocList = recyclerView;
        this.tvEmptyMessage = textView;
        this.vwSepartorToolbar = view2;
    }

    @NonNull
    public static FragmentSalesDocumentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSalesDocumentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentSalesDocumentBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_sales_document, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentSalesDocumentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentSalesDocumentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentSalesDocumentBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_sales_document, (ViewGroup) null, false, obj);
    }

    public static FragmentSalesDocumentBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentSalesDocumentBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentSalesDocumentBinding) bind(obj, view, C2723R.C2728layout.fragment_sales_document);
    }
}
