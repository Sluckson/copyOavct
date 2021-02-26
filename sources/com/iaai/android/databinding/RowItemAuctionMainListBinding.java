package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class RowItemAuctionMainListBinding extends ViewDataBinding {
    @NonNull
    public final Button btnBidAuction;
    @NonNull
    public final LinearLayout llBidButtonAuction;
    @NonNull
    public final LinearLayout llStateInfo;
    @NonNull
    public final TextView tvAuctionBranch;
    @NonNull
    public final TextView tvAuctionStateName;
    @NonNull
    public final TextView tvAuctionStatus;
    @NonNull
    public final TextView tvAuctionTime;
    @NonNull
    public final TextView tvPreBidCloseTime;
    @NonNull
    public final TextView tvPublicAuction;
    @NonNull
    public final TextView tvVehicleCount;

    protected RowItemAuctionMainListBinding(Object obj, View view, int i, Button button, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        super(obj, view, i);
        this.btnBidAuction = button;
        this.llBidButtonAuction = linearLayout;
        this.llStateInfo = linearLayout2;
        this.tvAuctionBranch = textView;
        this.tvAuctionStateName = textView2;
        this.tvAuctionStatus = textView3;
        this.tvAuctionTime = textView4;
        this.tvPreBidCloseTime = textView5;
        this.tvPublicAuction = textView6;
        this.tvVehicleCount = textView7;
    }

    @NonNull
    public static RowItemAuctionMainListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemAuctionMainListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemAuctionMainListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_auction_main_list, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemAuctionMainListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemAuctionMainListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemAuctionMainListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_auction_main_list, (ViewGroup) null, false, obj);
    }

    public static RowItemAuctionMainListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemAuctionMainListBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemAuctionMainListBinding) bind(obj, view, C2723R.C2728layout.row_item_auction_main_list);
    }
}
