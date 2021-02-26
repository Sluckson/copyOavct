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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListViewModel;
import com.iaai.android.bdt.feature.viewPager.FastSearchViewModel;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;
import com.iaai.android.bdt.model.fastSearch.Vehicle;
import com.iaai.android.bdt.model.fastSearchFilter2.FormattedResult;

public abstract class ItemAuctionSalesListBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout constraintLayout;
    @NonNull
    public final TextView estimateTimeOnBlock;
    @NonNull
    public final FrameLayout flUnwatch;
    @NonNull
    public final FrameLayout flWatch;
    @NonNull
    public final FrameLayout frameLayout1;
    @NonNull
    public final ImageView imgArrowRight;
    @NonNull
    public final ImageView imgCircle;
    @NonNull
    public final LinearLayout llBadgeConatiner;
    @NonNull
    public final LinearLayout llCAFlag;
    @NonNull
    public final ConstraintLayout llReceiptConatiner;
    @NonNull
    public final LinearLayout llUKFlag;
    @NonNull
    public final LinearLayout llUnWatch;
    @NonNull
    public final LinearLayout llWatch;
    @Bindable
    protected FormattedResult mFormattedResult;
    @Bindable
    protected ResultData mResultData;
    @Bindable
    protected Vehicle mVehicleData;
    @Bindable
    protected FastSearchViewModel mVehicleSearchModel;
    @Bindable
    protected AuctionSalesListViewModel mViewModel;
    @NonNull
    public final LinearLayout mainRowLayout;
    @NonNull
    public final ConstraintLayout parentItem;
    @NonNull
    public final TextView preSaleRow3Right;
    @NonNull
    public final TextView preSaleRow4Right;
    @NonNull
    public final TextView tvAisleValue;
    @NonNull
    public final TextView tvAuctionTime;
    @NonNull
    public final TextView tvBranchName;
    @NonNull
    public final TextView tvBundledReceipt;
    @NonNull
    public final TextView tvIsPublic;
    @NonNull
    public final TextView tvLaneSalesValue;
    @NonNull
    public final TextView tvLongDataLane;
    @NonNull
    public final TextView tvOffsite;
    @NonNull
    public final TextView tvOffsiteRelease;
    @NonNull
    public final TextView tvPrimaryDamageValue;
    @NonNull
    public final TextView tvProviderName;
    @NonNull
    public final TextView tvRunDrive;
    @NonNull
    public final TextView tvSeparator;
    @NonNull
    public final TextView tvStockReceipt;
    @NonNull
    public final TextView tvTitleNotAvailable;
    @NonNull
    public final ImageView vehicleImage1;
    @NonNull
    public final ImageView vehicleImage2;
    @NonNull
    public final TextView yearMakeModel;

    public abstract void setFormattedResult(@Nullable FormattedResult formattedResult);

    public abstract void setResultData(@Nullable ResultData resultData);

    public abstract void setVehicleData(@Nullable Vehicle vehicle);

    public abstract void setVehicleSearchModel(@Nullable FastSearchViewModel fastSearchViewModel);

    public abstract void setViewModel(@Nullable AuctionSalesListViewModel auctionSalesListViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ItemAuctionSalesListBinding(Object obj, View view, int i, ConstraintLayout constraintLayout2, TextView textView, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, ConstraintLayout constraintLayout4, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, ImageView imageView3, ImageView imageView4, TextView textView19) {
        super(obj, view, i);
        this.constraintLayout = constraintLayout2;
        this.estimateTimeOnBlock = textView;
        this.flUnwatch = frameLayout;
        this.flWatch = frameLayout2;
        this.frameLayout1 = frameLayout3;
        this.imgArrowRight = imageView;
        this.imgCircle = imageView2;
        this.llBadgeConatiner = linearLayout;
        this.llCAFlag = linearLayout2;
        this.llReceiptConatiner = constraintLayout3;
        this.llUKFlag = linearLayout3;
        this.llUnWatch = linearLayout4;
        this.llWatch = linearLayout5;
        this.mainRowLayout = linearLayout6;
        this.parentItem = constraintLayout4;
        this.preSaleRow3Right = textView2;
        this.preSaleRow4Right = textView3;
        this.tvAisleValue = textView4;
        this.tvAuctionTime = textView5;
        this.tvBranchName = textView6;
        this.tvBundledReceipt = textView7;
        this.tvIsPublic = textView8;
        this.tvLaneSalesValue = textView9;
        this.tvLongDataLane = textView10;
        this.tvOffsite = textView11;
        this.tvOffsiteRelease = textView12;
        this.tvPrimaryDamageValue = textView13;
        this.tvProviderName = textView14;
        this.tvRunDrive = textView15;
        this.tvSeparator = textView16;
        this.tvStockReceipt = textView17;
        this.tvTitleNotAvailable = textView18;
        this.vehicleImage1 = imageView3;
        this.vehicleImage2 = imageView4;
        this.yearMakeModel = textView19;
    }

    @Nullable
    public ResultData getResultData() {
        return this.mResultData;
    }

    @Nullable
    public AuctionSalesListViewModel getViewModel() {
        return this.mViewModel;
    }

    @Nullable
    public Vehicle getVehicleData() {
        return this.mVehicleData;
    }

    @Nullable
    public FormattedResult getFormattedResult() {
        return this.mFormattedResult;
    }

    @Nullable
    public FastSearchViewModel getVehicleSearchModel() {
        return this.mVehicleSearchModel;
    }

    @NonNull
    public static ItemAuctionSalesListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemAuctionSalesListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ItemAuctionSalesListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_auction_sales_list, viewGroup, z, obj);
    }

    @NonNull
    public static ItemAuctionSalesListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemAuctionSalesListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ItemAuctionSalesListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.item_auction_sales_list, (ViewGroup) null, false, obj);
    }

    public static ItemAuctionSalesListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemAuctionSalesListBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ItemAuctionSalesListBinding) bind(obj, view, C2723R.C2728layout.item_auction_sales_list);
    }
}
