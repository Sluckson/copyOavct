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

public abstract class RowListItemSelectVehiclesBinding extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout clToBePaidContainer;
    @NonNull
    public final ImageView ivArrowRight;
    @NonNull
    public final ImageView ivTotalDueArrow;
    @NonNull
    public final LinearLayout llFeeCreditCardLayout;
    @Bindable
    protected PaymentDue mPaymentDue;
    @NonNull
    public final ImageView rowItemRadioBtn;
    @NonNull
    public final TextView tvBidWonMethod;
    @NonNull
    public final TextView tvBranchInfo;
    @NonNull
    public final TextView tvCCStockNo;
    @NonNull
    public final TextView tvDueDate;
    @NonNull
    public final TextView tvPartialPaid;
    @NonNull
    public final TextView tvReviewFees;
    @NonNull
    public final TextView tvStockLabel;
    @NonNull
    public final TextView tvStockNumber;
    @NonNull
    public final TextView tvTotalDue;
    @NonNull
    public final TextView tvUsername;
    @NonNull
    public final ImageView vehicleImage;
    @NonNull
    public final TextView vehicleTitle;
    @NonNull
    public final View viewSeparator2;

    public abstract void setPaymentDue(@Nullable PaymentDue paymentDue);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected RowListItemSelectVehiclesBinding(Object obj, View view, int i, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, ImageView imageView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, ImageView imageView4, TextView textView11, View view2) {
        super(obj, view, i);
        this.clToBePaidContainer = constraintLayout;
        this.ivArrowRight = imageView;
        this.ivTotalDueArrow = imageView2;
        this.llFeeCreditCardLayout = linearLayout;
        this.rowItemRadioBtn = imageView3;
        this.tvBidWonMethod = textView;
        this.tvBranchInfo = textView2;
        this.tvCCStockNo = textView3;
        this.tvDueDate = textView4;
        this.tvPartialPaid = textView5;
        this.tvReviewFees = textView6;
        this.tvStockLabel = textView7;
        this.tvStockNumber = textView8;
        this.tvTotalDue = textView9;
        this.tvUsername = textView10;
        this.vehicleImage = imageView4;
        this.vehicleTitle = textView11;
        this.viewSeparator2 = view2;
    }

    @Nullable
    public PaymentDue getPaymentDue() {
        return this.mPaymentDue;
    }

    @NonNull
    public static RowListItemSelectVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowListItemSelectVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (RowListItemSelectVehiclesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_list_item_select_vehicles, viewGroup, z, obj);
    }

    @NonNull
    public static RowListItemSelectVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static RowListItemSelectVehiclesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (RowListItemSelectVehiclesBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.row_list_item_select_vehicles, (ViewGroup) null, false, obj);
    }

    public static RowListItemSelectVehiclesBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static RowListItemSelectVehiclesBinding bind(@NonNull View view, @Nullable Object obj) {
        return (RowListItemSelectVehiclesBinding) bind(obj, view, C2723R.C2728layout.row_list_item_select_vehicles);
    }
}
