package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iaai.android.C2723R;

public abstract class ActivityAuctionSalesListLandBinding extends ViewDataBinding {
    @NonNull
    public final RelativeLayout clSearchContainer;
    @NonNull
    public final TextView edSearchResult;
    @NonNull
    public final FloatingActionButton fab;
    @NonNull
    public final ImageButton imgClearText;
    @NonNull
    public final ImageButton imgVoiceText;
    @NonNull
    public final LinearLayout llMicClr;
    @NonNull
    public final FrameLayout main;
    @NonNull
    public final ProgressBar pbLoadingAuctionSaleList;
    @NonNull
    public final RecyclerView rvAuctionSales;
    @NonNull
    public final TextView tvEmptyMessage;
    @NonNull
    public final View vwSepartorToolbar;

    protected ActivityAuctionSalesListLandBinding(Object obj, View view, int i, RelativeLayout relativeLayout, TextView textView, FloatingActionButton floatingActionButton, ImageButton imageButton, ImageButton imageButton2, LinearLayout linearLayout, FrameLayout frameLayout, ProgressBar progressBar, RecyclerView recyclerView, TextView textView2, View view2) {
        super(obj, view, i);
        this.clSearchContainer = relativeLayout;
        this.edSearchResult = textView;
        this.fab = floatingActionButton;
        this.imgClearText = imageButton;
        this.imgVoiceText = imageButton2;
        this.llMicClr = linearLayout;
        this.main = frameLayout;
        this.pbLoadingAuctionSaleList = progressBar;
        this.rvAuctionSales = recyclerView;
        this.tvEmptyMessage = textView2;
        this.vwSepartorToolbar = view2;
    }

    @NonNull
    public static ActivityAuctionSalesListLandBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAuctionSalesListLandBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityAuctionSalesListLandBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_auction_sales_list_land, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityAuctionSalesListLandBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityAuctionSalesListLandBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityAuctionSalesListLandBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_auction_sales_list_land, (ViewGroup) null, false, obj);
    }

    public static ActivityAuctionSalesListLandBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityAuctionSalesListLandBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityAuctionSalesListLandBinding) bind(obj, view, C2723R.C2728layout.activity_auction_sales_list_land);
    }
}
