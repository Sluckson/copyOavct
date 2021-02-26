package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class ItemAuctionDateLayoutBinding extends ViewDataBinding {
    @NonNull
    public final LinearLayout llAuctionDateContainer;
    @NonNull
    public final TextView tvAuctionDate;

    protected ItemAuctionDateLayoutBinding(Object obj, View view, int i, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i);
        this.llAuctionDateContainer = linearLayout;
        this.tvAuctionDate = textView;
    }

    @NonNull
    public static ItemAuctionDateLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemAuctionDateLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemAuctionDateLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_auction_date_layout, viewGroup, z, obj);
    }

    @NonNull
    public static ItemAuctionDateLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemAuctionDateLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemAuctionDateLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_auction_date_layout, (ViewGroup) null, false, obj);
    }

    public static ItemAuctionDateLayoutBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAuctionDateLayoutBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ItemAuctionDateLayoutBinding) bind(obj, view, C2723R.C2728layout.item_auction_date_layout);
    }
}
