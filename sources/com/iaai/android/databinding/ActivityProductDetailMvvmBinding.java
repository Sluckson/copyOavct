package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class ActivityProductDetailMvvmBinding extends ViewDataBinding {
    protected ActivityProductDetailMvvmBinding(Object obj, View view, int i) {
        super(obj, view, i);
    }

    @NonNull
    public static ActivityProductDetailMvvmBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityProductDetailMvvmBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityProductDetailMvvmBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_product_detail_mvvm, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityProductDetailMvvmBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityProductDetailMvvmBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityProductDetailMvvmBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_product_detail_mvvm, (ViewGroup) null, false, obj);
    }

    public static ActivityProductDetailMvvmBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityProductDetailMvvmBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityProductDetailMvvmBinding) bind(obj, view, C2723R.C2728layout.activity_product_detail_mvvm);
    }
}
