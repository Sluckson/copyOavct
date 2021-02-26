package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public abstract class ItemManageOfferListBinding extends ViewDataBinding {
    @NonNull
    public final Button btnBuyIt;
    @NonNull
    public final Button btnKeepMyBid;
    @NonNull
    public final Button btnRaiseMyBid;
    @NonNull
    public final ConstraintLayout clActionAreaLayout;
    @NonNull
    public final ImageView ivArrowDown;
    @NonNull
    public final ImageView ivInfo;
    @NonNull
    public final ImageView ivVehicleThumbnail;
    @NonNull
    public final LinearLayout linearLayout5;
    @NonNull
    public final LinearLayout llBidHistory;
    @NonNull
    public final LinearLayout llBidHistoryDetails;
    @Bindable
    protected MobileNegotiationsList mMobileNegotiation;
    @Bindable
    protected ManageOfferListViewModel mViewModel;
    @NonNull
    public final LinearLayout mainRowLayout;
    @NonNull
    public final ConstraintLayout parentItem;
    @NonNull
    public final TextView tvBidHistory;
    @NonNull
    public final TextView tvBranchNameLane;
    @NonNull
    public final TextView tvDigitalNegotiationDateTime;
    @NonNull
    public final TextView tvSellerCounterOffer;
    @NonNull
    public final TextView tvSellerOfferAmount;
    @NonNull
    public final TextView tvStockNo;
    @NonNull
    public final TextView tvStockNoValue;
    @NonNull
    public final TextView tvWhyThisIs;
    @NonNull
    public final TextView tvYearMakeModel;
    @NonNull
    public final TextView tvYourHighBid;
    @NonNull
    public final TextView tvYourHighestBidLable;
    @NonNull
    public final TextView tvYourHighestBidLable2;

    public abstract void setMobileNegotiation(@Nullable MobileNegotiationsList mobileNegotiationsList);

    public abstract void setViewModel(@Nullable ManageOfferListViewModel manageOfferListViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ItemManageOfferListBinding(Object obj, View view, int i, Button button, Button button2, Button button3, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        super(obj, view, i);
        this.btnBuyIt = button;
        this.btnKeepMyBid = button2;
        this.btnRaiseMyBid = button3;
        this.clActionAreaLayout = constraintLayout;
        this.ivArrowDown = imageView;
        this.ivInfo = imageView2;
        this.ivVehicleThumbnail = imageView3;
        this.linearLayout5 = linearLayout;
        this.llBidHistory = linearLayout2;
        this.llBidHistoryDetails = linearLayout3;
        this.mainRowLayout = linearLayout4;
        this.parentItem = constraintLayout2;
        this.tvBidHistory = textView;
        this.tvBranchNameLane = textView2;
        this.tvDigitalNegotiationDateTime = textView3;
        this.tvSellerCounterOffer = textView4;
        this.tvSellerOfferAmount = textView5;
        this.tvStockNo = textView6;
        this.tvStockNoValue = textView7;
        this.tvWhyThisIs = textView8;
        this.tvYearMakeModel = textView9;
        this.tvYourHighBid = textView10;
        this.tvYourHighestBidLable = textView11;
        this.tvYourHighestBidLable2 = textView12;
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
    public static ItemManageOfferListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemManageOfferListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemManageOfferListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_manage_offer_list, viewGroup, z, obj);
    }

    @NonNull
    public static ItemManageOfferListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemManageOfferListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemManageOfferListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_manage_offer_list, (ViewGroup) null, false, obj);
    }

    public static ItemManageOfferListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemManageOfferListBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ItemManageOfferListBinding) bind(obj, view, C2723R.C2728layout.item_manage_offer_list);
    }
}
