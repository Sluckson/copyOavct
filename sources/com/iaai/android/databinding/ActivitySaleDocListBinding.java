package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
import com.iaai.android.C2723R;

public abstract class ActivitySaleDocListBinding extends ViewDataBinding {
    @NonNull
    public final AppBarLayout appBar;
    @NonNull
    public final ImageView arrowLeft;
    @NonNull
    public final ImageView arrowRight;
    @NonNull
    public final Button btnReviewPayment;
    @NonNull
    public final LinearLayout llNotSet;
    @NonNull
    public final LinearLayout llSet;
    @NonNull
    public final ProgressBar pbReviewPayment;
    @NonNull
    public final RecyclerView rvNotSetInstructions;
    @NonNull
    public final RecyclerView rvSetInstructions;
    @NonNull
    public final View separatorSet;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final RelativeLayout toolbarRelativelayout;
    @NonNull
    public final TextView toolbarSubTitle;
    @NonNull
    public final TextView toolbarTitle;
    @NonNull
    public final View viewSeparator1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ActivitySaleDocListBinding(Object obj, View view, int i, AppBarLayout appBarLayout, ImageView imageView, ImageView imageView2, Button button, LinearLayout linearLayout, LinearLayout linearLayout2, ProgressBar progressBar, RecyclerView recyclerView, RecyclerView recyclerView2, View view2, Toolbar toolbar2, RelativeLayout relativeLayout, TextView textView, TextView textView2, View view3) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.arrowLeft = imageView;
        this.arrowRight = imageView2;
        this.btnReviewPayment = button;
        this.llNotSet = linearLayout;
        this.llSet = linearLayout2;
        this.pbReviewPayment = progressBar;
        this.rvNotSetInstructions = recyclerView;
        this.rvSetInstructions = recyclerView2;
        this.separatorSet = view2;
        this.toolbar = toolbar2;
        this.toolbarRelativelayout = relativeLayout;
        this.toolbarSubTitle = textView;
        this.toolbarTitle = textView2;
        this.viewSeparator1 = view3;
    }

    @NonNull
    public static ActivitySaleDocListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySaleDocListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivitySaleDocListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_sale_doc_list, viewGroup, z, obj);
    }

    @NonNull
    public static ActivitySaleDocListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivitySaleDocListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivitySaleDocListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_sale_doc_list, (ViewGroup) null, false, obj);
    }

    public static ActivitySaleDocListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivitySaleDocListBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivitySaleDocListBinding) bind(obj, view, C2723R.C2728layout.activity_sale_doc_list);
    }
}
