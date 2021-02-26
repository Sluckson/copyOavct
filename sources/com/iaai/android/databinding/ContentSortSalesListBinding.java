package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class ContentSortSalesListBinding extends ViewDataBinding {
    @NonNull
    public final TextView tvAToZ;
    @NonNull
    public final TextView tvItemHighToLow;
    @NonNull
    public final TextView tvItemLowToHigh;
    @NonNull
    public final TextView tvMakeAToZ;
    @NonNull
    public final TextView tvMakeZToA;
    @NonNull
    public final TextView tvOdometerHighToLow;
    @NonNull
    public final TextView tvOdometerLowToHigh;
    @NonNull
    public final TextView tvYearHighToLow;
    @NonNull
    public final TextView tvYearLowToHigh;
    @NonNull
    public final TextView tvZToA;
    @NonNull
    public final View view1;
    @NonNull
    public final View view10;
    @NonNull
    public final View view2;
    @NonNull
    public final View view3;
    @NonNull
    public final View view4;
    @NonNull
    public final View view5;
    @NonNull
    public final View view6;
    @NonNull
    public final View view7;
    @NonNull
    public final View view8;
    @NonNull
    public final View viewLane;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ContentSortSalesListBinding(Object obj, View view, int i, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, View view9, View view11, View view12, View view13, View view14, View view15, View view16, View view17, View view18, View view19) {
        super(obj, view, i);
        this.tvAToZ = textView;
        this.tvItemHighToLow = textView2;
        this.tvItemLowToHigh = textView3;
        this.tvMakeAToZ = textView4;
        this.tvMakeZToA = textView5;
        this.tvOdometerHighToLow = textView6;
        this.tvOdometerLowToHigh = textView7;
        this.tvYearHighToLow = textView8;
        this.tvYearLowToHigh = textView9;
        this.tvZToA = textView10;
        this.view1 = view9;
        this.view10 = view11;
        this.view2 = view12;
        this.view3 = view13;
        this.view4 = view14;
        this.view5 = view15;
        this.view6 = view16;
        this.view7 = view17;
        this.view8 = view18;
        this.viewLane = view19;
    }

    @NonNull
    public static ContentSortSalesListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ContentSortSalesListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ContentSortSalesListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.content_sort_sales_list, viewGroup, z, obj);
    }

    @NonNull
    public static ContentSortSalesListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ContentSortSalesListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ContentSortSalesListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.content_sort_sales_list, (ViewGroup) null, false, obj);
    }

    public static ContentSortSalesListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ContentSortSalesListBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ContentSortSalesListBinding) bind(obj, view, C2723R.C2728layout.content_sort_sales_list);
    }
}
