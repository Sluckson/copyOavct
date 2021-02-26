package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class FragmentBuyNowBinding extends ViewDataBinding {
    @NonNull
    public final Button btnClose;
    @NonNull
    public final Button btnSubmit;
    @NonNull
    public final ImageView ivCongratulations;
    @NonNull
    public final ProgressBar pbLoading;
    @NonNull
    public final RelativeLayout rvCongratulationsContainer;
    @NonNull
    public final ScrollView svBuyNowContainer;
    @NonNull
    public final TextView tvAwardMessage;
    @NonNull
    public final TextView tvBranchName;
    @NonNull
    public final TextView tvBuyPrice;
    @NonNull
    public final TextView tvCongratsMessage;
    @NonNull
    public final TextView tvCongratulations;
    @NonNull
    public final TextView tvPaymentDue;
    @NonNull
    public final TextView tvPickUpBy;
    @NonNull
    public final TextView tvStockNumber;
    @NonNull
    public final TextView tvTimeLeftToBuy;
    @NonNull
    public final TextView tvVehicleLocation;
    @NonNull
    public final TextView tvYearModel;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected FragmentBuyNowBinding(Object obj, View view, int i, Button button, Button button2, ImageView imageView, ProgressBar progressBar, RelativeLayout relativeLayout, ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11) {
        super(obj, view, i);
        this.btnClose = button;
        this.btnSubmit = button2;
        this.ivCongratulations = imageView;
        this.pbLoading = progressBar;
        this.rvCongratulationsContainer = relativeLayout;
        this.svBuyNowContainer = scrollView;
        this.tvAwardMessage = textView;
        this.tvBranchName = textView2;
        this.tvBuyPrice = textView3;
        this.tvCongratsMessage = textView4;
        this.tvCongratulations = textView5;
        this.tvPaymentDue = textView6;
        this.tvPickUpBy = textView7;
        this.tvStockNumber = textView8;
        this.tvTimeLeftToBuy = textView9;
        this.tvVehicleLocation = textView10;
        this.tvYearModel = textView11;
    }

    @NonNull
    public static FragmentBuyNowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentBuyNowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentBuyNowBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_buy_now, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentBuyNowBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentBuyNowBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentBuyNowBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_buy_now, (ViewGroup) null, false, obj);
    }

    public static FragmentBuyNowBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentBuyNowBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentBuyNowBinding) bind(obj, view, C2723R.C2728layout.fragment_buy_now);
    }
}
