package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.iaai.android.C2723R;

public abstract class ActivityDocumentMethodBinding extends ViewDataBinding {
    @NonNull
    public final AppBarLayout appBar;
    @NonNull
    public final Button btnApply;
    @NonNull
    public final ImageView ivClose;
    @NonNull
    public final ImageView ivToolTip;
    @NonNull
    public final LinearLayout llBranchList;
    @NonNull
    public final View optionsLayout;
    @NonNull
    public final ProgressBar pbGetDelivery;
    @NonNull
    public final ConstraintLayout prebidTitleLayout;
    @NonNull
    public final RecyclerView rvBranchList;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final TextView tvTitle;
    @NonNull
    public final View viewSeparator;
    @NonNull
    public final View viewSeparator1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ActivityDocumentMethodBinding(Object obj, View view, int i, AppBarLayout appBarLayout, Button button, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, View view2, ProgressBar progressBar, ConstraintLayout constraintLayout, RecyclerView recyclerView, Toolbar toolbar2, TextView textView, View view3, View view4) {
        super(obj, view, i);
        this.appBar = appBarLayout;
        this.btnApply = button;
        this.ivClose = imageView;
        this.ivToolTip = imageView2;
        this.llBranchList = linearLayout;
        this.optionsLayout = view2;
        this.pbGetDelivery = progressBar;
        this.prebidTitleLayout = constraintLayout;
        this.rvBranchList = recyclerView;
        this.toolbar = toolbar2;
        this.tvTitle = textView;
        this.viewSeparator = view3;
        this.viewSeparator1 = view4;
    }

    @NonNull
    public static ActivityDocumentMethodBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityDocumentMethodBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityDocumentMethodBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_document_method, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityDocumentMethodBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityDocumentMethodBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityDocumentMethodBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_document_method, (ViewGroup) null, false, obj);
    }

    public static ActivityDocumentMethodBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityDocumentMethodBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityDocumentMethodBinding) bind(obj, view, C2723R.C2728layout.activity_document_method);
    }
}
