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
import com.iaai.android.bdt.feature.auctionSalesList.AuctionSalesListViewModel;
import com.iaai.android.bdt.model.auctionSalesList.ResultData;

public abstract class RowItemSalesLdocumentHeaderBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout clDocumentStatusContainer;
    @NonNull
    public final ConstraintLayout clEmptyView;
    @NonNull
    public final ConstraintLayout clTitleContainer;
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
    public final LinearLayout llDocumentStatus;
    @Bindable
    protected ResultData mResultData;
    @Bindable
    protected AuctionSalesListViewModel mViewModel;
    @NonNull
    public final TextView tvAllStatus;
    @NonNull
    public final TextView tvCloseStatus;
    @NonNull
    public final TextView tvDocumentStatus;
    @NonNull
    public final TextView tvFilterCount;
    @NonNull
    public final TextView tvFilterLabel;
    @NonNull
    public final TextView tvOpenStatus;
    @NonNull
    public final TextView tvSalesDocManageBranch;
    @NonNull
    public final TextView tvSalesDocTitle1;
    @NonNull
    public final TextView tvSalesDocTitle2;
    @NonNull
    public final TextView tvSortLabel;
    @NonNull
    public final View viewHeader;

    public abstract void setResultData(@Nullable ResultData resultData);

    public abstract void setViewModel(@Nullable AuctionSalesListViewModel auctionSalesListViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected RowItemSalesLdocumentHeaderBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, View view2, TextView textView, ImageView imageView, ImageView imageView2, ConstraintLayout constraintLayout4, LinearLayout linearLayout, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, View view3) {
        super(obj, view, i);
        this.clDocumentStatusContainer = constraintLayout;
        this.clEmptyView = constraintLayout2;
        this.clTitleContainer = constraintLayout3;
        this.emptyView = view2;
        this.headerMdlostPrebid = textView;
        this.imgFilter = imageView;
        this.ivSort = imageView2;
        this.layoutSortContainer = constraintLayout4;
        this.llDocumentStatus = linearLayout;
        this.tvAllStatus = textView2;
        this.tvCloseStatus = textView3;
        this.tvDocumentStatus = textView4;
        this.tvFilterCount = textView5;
        this.tvFilterLabel = textView6;
        this.tvOpenStatus = textView7;
        this.tvSalesDocManageBranch = textView8;
        this.tvSalesDocTitle1 = textView9;
        this.tvSalesDocTitle2 = textView10;
        this.tvSortLabel = textView11;
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
    public static RowItemSalesLdocumentHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemSalesLdocumentHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowItemSalesLdocumentHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_sales_ldocument_header, viewGroup, z, obj);
    }

    @NonNull
    public static RowItemSalesLdocumentHeaderBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowItemSalesLdocumentHeaderBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowItemSalesLdocumentHeaderBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_item_sales_ldocument_header, (ViewGroup) null, false, obj);
    }

    public static RowItemSalesLdocumentHeaderBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowItemSalesLdocumentHeaderBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowItemSalesLdocumentHeaderBinding) bind(obj, view, C2723R.C2728layout.row_item_sales_ldocument_header);
    }
}
