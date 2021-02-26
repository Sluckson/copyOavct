package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.auctionmainlist.AuctionLocations;

public abstract class RowItemAuctionMainListViewBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardView;
    @NonNull
    public final FrameLayout frameLayout;
    @NonNull
    public final ImageView imgPublicAuction;
    @Bindable
    protected AuctionLocations mLocation;
    @NonNull
    public final ImageView nfIndicator;
    @NonNull
    public final LinearLayout sectionDetail;
    @NonNull
    public final LinearLayout sectionStatus;
    @NonNull
    public final TextView txtAuctionPhase;
    @NonNull
    public final TextView txtBidLive;
    @NonNull
    public final TextView txtLiveDate;
    @NonNull
    public final TextView txtName;
    @NonNull
    public final TextView txtVehicleCount;
    @NonNull
    public final TextView txtViewAuction;

    public abstract void setLocation(@Nullable AuctionLocations auctionLocations);

    protected RowItemAuctionMainListViewBinding(Object obj, View view, int i, CardView cardView2, FrameLayout frameLayout2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i);
        this.cardView = cardView2;
        this.frameLayout = frameLayout2;
        this.imgPublicAuction = imageView;
        this.nfIndicator = imageView2;
        this.sectionDetail = linearLayout;
        this.sectionStatus = linearLayout2;
        this.txtAuctionPhase = textView;
        this.txtBidLive = textView2;
        this.txtLiveDate = textView3;
        this.txtName = textView4;
        this.txtVehicleCount = textView5;
        this.txtViewAuction = textView6;
    }

    @Nullable
    public AuctionLocations getLocation() {
        return this.mLocation;
    }

    @NonNull
    public static RowItemAuctionMainListViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemAuctionMainListViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemAuctionMainListViewBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_auction_main_list_view, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemAuctionMainListViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemAuctionMainListViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemAuctionMainListViewBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_auction_main_list_view, (ViewGroup) null, false, obj);
    }

    public static RowItemAuctionMainListViewBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemAuctionMainListViewBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemAuctionMainListViewBinding) bind(obj, view, C2723R.C2728layout.row_item_auction_main_list_view);
    }
}
