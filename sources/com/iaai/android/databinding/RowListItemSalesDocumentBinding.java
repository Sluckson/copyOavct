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
import com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue;

public abstract class RowListItemSalesDocumentBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout ClReviewDetailsContainer;
    @NonNull
    public final ConstraintLayout clToBePaidContainer;
    @NonNull
    public final ImageView ivArrowRight;
    @NonNull
    public final ImageView ivTotalDueArrow;
    @NonNull
    public final LinearLayout llReviewFees;
    @NonNull
    public final LinearLayout llTrackingId;
    @Bindable
    protected PaymentDue mPaymentDue;
    @NonNull
    public final ImageView rowItemRadioBtn;
    @NonNull
    public final TextView tvBranchName;
    @NonNull
    public final TextView tvFedEx;
    @NonNull
    public final TextView tvNotesForBranch;
    @NonNull
    public final TextView tvNotesForBranchValue;
    @NonNull
    public final TextView tvNotesFromBranch;
    @NonNull
    public final TextView tvNotesFromBranchValue;
    @NonNull
    public final TextView tvOwnerName;
    @NonNull
    public final TextView tvReviewFees;
    @NonNull
    public final TextView tvStockNumber;
    @NonNull
    public final TextView tvTitleFedex;
    @NonNull
    public final TextView tvTitleStatus;
    @NonNull
    public final TextView tvTrackingId;
    @NonNull
    public final TextView tvVinNumber;
    @NonNull
    public final ImageView vehicleImage;
    @NonNull
    public final TextView vehicleTitle;
    @NonNull
    public final View viewSeparator2;

    public abstract void setPaymentDue(@Nullable PaymentDue paymentDue);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected RowListItemSalesDocumentBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, LinearLayout linearLayout2, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, ImageView imageView4, TextView textView14, View view2) {
        super(obj, view, i);
        this.ClReviewDetailsContainer = constraintLayout;
        this.clToBePaidContainer = constraintLayout2;
        this.ivArrowRight = imageView;
        this.ivTotalDueArrow = imageView2;
        this.llReviewFees = linearLayout;
        this.llTrackingId = linearLayout2;
        this.rowItemRadioBtn = imageView3;
        this.tvBranchName = textView;
        this.tvFedEx = textView2;
        this.tvNotesForBranch = textView3;
        this.tvNotesForBranchValue = textView4;
        this.tvNotesFromBranch = textView5;
        this.tvNotesFromBranchValue = textView6;
        this.tvOwnerName = textView7;
        this.tvReviewFees = textView8;
        this.tvStockNumber = textView9;
        this.tvTitleFedex = textView10;
        this.tvTitleStatus = textView11;
        this.tvTrackingId = textView12;
        this.tvVinNumber = textView13;
        this.vehicleImage = imageView4;
        this.vehicleTitle = textView14;
        this.viewSeparator2 = view2;
    }

    @Nullable
    public PaymentDue getPaymentDue() {
        return this.mPaymentDue;
    }

    @NonNull
    public static RowListItemSalesDocumentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowListItemSalesDocumentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowListItemSalesDocumentBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_list_item_sales_document, viewGroup, z, obj);
    }

    @NonNull
    public static RowListItemSalesDocumentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowListItemSalesDocumentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowListItemSalesDocumentBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_list_item_sales_document, (ViewGroup) null, false, obj);
    }

    public static RowListItemSalesDocumentBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowListItemSalesDocumentBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowListItemSalesDocumentBinding) bind(obj, view, C2723R.C2728layout.row_list_item_sales_document);
    }
}
