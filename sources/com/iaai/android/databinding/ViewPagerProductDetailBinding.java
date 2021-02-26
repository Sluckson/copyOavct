package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.iaai.android.C2723R;

public abstract class ViewPagerProductDetailBinding extends ViewDataBinding {
    @NonNull
    public final ViewPager viewPager2;
    @NonNull
    public final ProgressBar viewPagerPbLoading;

    protected ViewPagerProductDetailBinding(Object obj, View view, int i, ViewPager viewPager, ProgressBar progressBar) {
        super(obj, view, i);
        this.viewPager2 = viewPager;
        this.viewPagerPbLoading = progressBar;
    }

    @NonNull
    public static ViewPagerProductDetailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ViewPagerProductDetailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ViewPagerProductDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.view_pager_product_detail, viewGroup, z, obj);
    }

    @NonNull
    public static ViewPagerProductDetailBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ViewPagerProductDetailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ViewPagerProductDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.view_pager_product_detail, (ViewGroup) null, false, obj);
    }

    public static ViewPagerProductDetailBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ViewPagerProductDetailBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ViewPagerProductDetailBinding) bind(obj, view, C2723R.C2728layout.view_pager_product_detail);
    }
}
