package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListViewModel;
import com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList;

public abstract class ItemHeaderManageOfferListBinding extends ViewDataBinding {
    @NonNull
    public final ImageView imgFilter;
    @NonNull
    public final ImageView ivSort;
    @NonNull
    public final ConstraintLayout layoutSortContainer;
    @NonNull
    public final LinearLayout llFilter;
    @Bindable
    protected MobileNegotiationsList mMobileNegotiation;
    @Bindable
    protected ManageOfferListViewModel mViewModel;
    @NonNull
    public final TextView tvFilter;
    @NonNull
    public final TextView tvManageOfferVehicleCount;
    @NonNull
    public final TextView tvSortLabel;
    @NonNull
    public final View vehicleCountSeparator;
    @NonNull
    public final View view13;

    public abstract void setMobileNegotiation(@Nullable MobileNegotiationsList mobileNegotiationsList);

    public abstract void setViewModel(@Nullable ManageOfferListViewModel manageOfferListViewModel);

    protected ItemHeaderManageOfferListBinding(Object obj, View view, int i, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, View view2, View view3) {
        super(obj, view, i);
        this.imgFilter = imageView;
        this.ivSort = imageView2;
        this.layoutSortContainer = constraintLayout;
        this.llFilter = linearLayout;
        this.tvFilter = textView;
        this.tvManageOfferVehicleCount = textView2;
        this.tvSortLabel = textView3;
        this.vehicleCountSeparator = view2;
        this.view13 = view3;
    }

    @Nullable
    public MobileNegotiationsList getMobileNegotiation() {
        return this.mMobileNegotiation;
    }

    @Nullable
    public ManageOfferListViewModel getViewModel() {
        return this.mViewModel;
    }

    @NonNull
    public static ItemHeaderManageOfferListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemHeaderManageOfferListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemHeaderManageOfferListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_header_manage_offer_list, viewGroup, z, obj);
    }

    @NonNull
    public static ItemHeaderManageOfferListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemHeaderManageOfferListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemHeaderManageOfferListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_header_manage_offer_list, (ViewGroup) null, false, obj);
    }

    public static ItemHeaderManageOfferListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemHeaderManageOfferListBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ItemHeaderManageOfferListBinding) bind(obj, view, C2723R.C2728layout.item_header_manage_offer_list);
    }
}
