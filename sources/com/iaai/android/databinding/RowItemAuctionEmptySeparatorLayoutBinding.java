package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.auctionmainlist.AuctionLocations;

public abstract class RowItemAuctionEmptySeparatorLayoutBinding extends ViewDataBinding {
    @NonNull
    public final TextView emptySeparator;
    @Bindable
    protected AuctionLocations mLocation;

    public abstract void setLocation(@Nullable AuctionLocations auctionLocations);

    protected RowItemAuctionEmptySeparatorLayoutBinding(Object obj, View view, int i, TextView textView) {
        super(obj, view, i);
        this.emptySeparator = textView;
    }

    @Nullable
    public AuctionLocations getLocation() {
        return this.mLocation;
    }

    @NonNull
    public static RowItemAuctionEmptySeparatorLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemAuctionEmptySeparatorLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemAuctionEmptySeparatorLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_auction_empty_separator_layout, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemAuctionEmptySeparatorLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemAuctionEmptySeparatorLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemAuctionEmptySeparatorLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_auction_empty_separator_layout, (ViewGroup) null, false, obj);
    }

    public static RowItemAuctionEmptySeparatorLayoutBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemAuctionEmptySeparatorLayoutBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemAuctionEmptySeparatorLayoutBinding) bind(obj, view, C2723R.C2728layout.row_item_auction_empty_separator_layout);
    }
}
