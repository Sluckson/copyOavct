package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputLayout;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.productDetail.ProductDetailViewModel;
import com.iaai.android.bdt.model.productDetail.biddingInfo.BiddingInformation;

public abstract class FragmentCostCalculatorLayoutBinding extends ViewDataBinding {
    @NonNull
    public final TextView bidAmountLabel;
    @NonNull
    public final Button btnGetQuote;
    @NonNull
    public final Button btnRemoveEdit;
    @NonNull
    public final Button btnViewEstimate;
    @NonNull
    public final LinearLayout costBreakDown;
    @NonNull
    public final ProgressBar costCalPbLoading;
    @NonNull
    public final TextView estimateLabel;
    @NonNull
    public final TextView lblEstimatedBidAmount;
    @NonNull
    public final LinearLayout linearLayout2;
    @NonNull
    public final LinearLayout linearLayout3;
    @NonNull
    public final LinearLayout llCostInfo;
    @Bindable
    protected BiddingInformation mBiddingInfo;
    @Bindable
    protected ProductDetailViewModel mViewModel;
    @NonNull
    public final RecyclerView rvCostBreakDown;
    @NonNull
    public final TextView tvCostBreakDown;
    @NonNull
    public final TextView tvCostValue;
    @NonNull
    public final TextView tvDeliverTransportLable;
    @NonNull
    public final TextView tvEstimatedCost;
    @NonNull
    public final TextView tvLabelTotalCost;
    @NonNull
    public final TextView tvValueTotalCost;
    @NonNull
    public final TextInputLayout txtBidAmountLayout;
    @NonNull
    public final TextView txtIncrementBidAmount;
    @NonNull
    public final EditText txtMaxBid;
    @NonNull
    public final EditText txtZipCode;
    @NonNull
    public final TextInputLayout txtZipCodeLayout;
    @NonNull
    public final View view;
    @NonNull
    public final View view1;
    @NonNull
    public final View viewCostBreakDown;

    public abstract void setBiddingInfo(@Nullable BiddingInformation biddingInformation);

    public abstract void setViewModel(@Nullable ProductDetailViewModel productDetailViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected FragmentCostCalculatorLayoutBinding(Object obj, View view2, int i, TextView textView, Button button, Button button2, Button button3, LinearLayout linearLayout, ProgressBar progressBar, TextView textView2, TextView textView3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, RecyclerView recyclerView, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextInputLayout textInputLayout, TextView textView10, EditText editText, EditText editText2, TextInputLayout textInputLayout2, View view3, View view4, View view5) {
        super(obj, view2, i);
        this.bidAmountLabel = textView;
        this.btnGetQuote = button;
        this.btnRemoveEdit = button2;
        this.btnViewEstimate = button3;
        this.costBreakDown = linearLayout;
        this.costCalPbLoading = progressBar;
        this.estimateLabel = textView2;
        this.lblEstimatedBidAmount = textView3;
        this.linearLayout2 = linearLayout4;
        this.linearLayout3 = linearLayout5;
        this.llCostInfo = linearLayout6;
        this.rvCostBreakDown = recyclerView;
        this.tvCostBreakDown = textView4;
        this.tvCostValue = textView5;
        this.tvDeliverTransportLable = textView6;
        this.tvEstimatedCost = textView7;
        this.tvLabelTotalCost = textView8;
        this.tvValueTotalCost = textView9;
        this.txtBidAmountLayout = textInputLayout;
        this.txtIncrementBidAmount = textView10;
        this.txtMaxBid = editText;
        this.txtZipCode = editText2;
        this.txtZipCodeLayout = textInputLayout2;
        this.view = view3;
        this.view1 = view4;
        this.viewCostBreakDown = view5;
    }

    @Nullable
    public BiddingInformation getBiddingInfo() {
        return this.mBiddingInfo;
    }

    @Nullable
    public ProductDetailViewModel getViewModel() {
        return this.mViewModel;
    }

    @NonNull
    public static FragmentCostCalculatorLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentCostCalculatorLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentCostCalculatorLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_cost_calculator_layout, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentCostCalculatorLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentCostCalculatorLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentCostCalculatorLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_cost_calculator_layout, (ViewGroup) null, false, obj);
    }

    public static FragmentCostCalculatorLayoutBinding bind(@NonNull View view2) {
        return bind(view2, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentCostCalculatorLayoutBinding bind(@NonNull View view2, @Nullable Object obj) {
        return (FragmentCostCalculatorLayoutBinding) bind(obj, view2, C2723R.C2728layout.fragment_cost_calculator_layout);
    }
}
