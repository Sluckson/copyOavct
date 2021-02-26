package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListViewModel;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;

public abstract class RowItemAuctinSalesListHeaderBinding extends ViewDataBinding {
    @NonNull
    public final Button btnBidAuctionSales;
    @NonNull
    public final ConstraintLayout clEmptyView;
    @NonNull
    public final ConstraintLayout clHeader;
    @NonNull
    public final View emptyView;
    @NonNull
    public final TextView headerMdlostPrebid;
    @NonNull
    public final ImageView imgFilter;
    @NonNull
    public final ImageView ivSort;
    @NonNull
    public final ConstraintLayout layoutSortContainer;
    @NonNull
    public final LinearLayout linearLayout4;
    @Bindable
    protected ResultData mResultData;
    @Bindable
    protected AuctionSalesListViewModel mViewModel;
    @NonNull
    public final RelativeLayout rlSearchSelectedRefiner;
    @NonNull
    public final RecyclerView rvSearchSelectedRefiner;
    @NonNull
    public final TextView tvAuctionDateTime;
    @NonNull
    public final TextView tvBranchNameLabel;
    @NonNull
    public final TextView tvFilterCount;
    @NonNull
    public final TextView tvFilterLabel;
    @NonNull
    public final TextView tvSortLabel;
    @NonNull
    public final TextView tvTodaysDate;
    @NonNull
    public final TextView tvTodaysDay;
    @NonNull
    public final TextView tvVehicleCountSalesList;
    @NonNull
    public final View viewHeader;

    public abstract void setResultData(@Nullable ResultData resultData);

    public abstract void setViewModel(@Nullable AuctionSalesListViewModel auctionSalesListViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected RowItemAuctinSalesListHeaderBinding(Object obj, View view, int i, Button button, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, View view2, TextView textView, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout3, LinearLayout linearLayout, RelativeLayout relativeLayout, RecyclerView recyclerView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, View view3) {
        super(obj, view, i);
        this.btnBidAuctionSales = button;
        this.clEmptyView = constraintLayout;
        this.clHeader = constraintLayout2;
        this.emptyView = view2;
        this.headerMdlostPrebid = textView;
        this.imgFilter = imageView;
        this.ivSort = imageView2;
        this.layoutSortContainer = constraintLayout3;
        this.linearLayout4 = linearLayout;
        this.rlSearchSelectedRefiner = relativeLayout;
        this.rvSearchSelectedRefiner = recyclerView;
        this.tvAuctionDateTime = textView2;
        this.tvBranchNameLabel = textView3;
        this.tvFilterCount = textView4;
        this.tvFilterLabel = textView5;
        this.tvSortLabel = textView6;
        this.tvTodaysDate = textView7;
        this.tvTodaysDay = textView8;
        this.tvVehicleCountSalesList = textView9;
        this.viewHeader = view3;
    }

    @Nullable
    public ResultData getResultData() {
        return this.mResultData;
    }

    @Nullable
    public AuctionSalesListViewModel getViewModel() {
        return this.mViewModel;
    }

    @NonNull
    public static RowItemAuctinSalesListHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemAuctinSalesListHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemAuctinSalesListHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_auctin_sales_list_header, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemAuctinSalesListHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemAuctinSalesListHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemAuctinSalesListHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_auctin_sales_list_header, (ViewGroup) null, false, obj);
    }

    public static RowItemAuctinSalesListHeaderBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemAuctinSalesListHeaderBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemAuctinSalesListHeaderBinding) bind(obj, view, C2723R.C2728layout.row_item_auctin_sales_list_header);
    }
}
