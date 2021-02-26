package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.textfield.TextInputLayout;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.productDetail.ProductDetailViewModel;
import com.iaai.android.bdt.model.productDetail.biddingInfo.BiddingInformation;

public abstract class FragmentPrebidLayoutBinding extends ViewDataBinding {
    @NonNull
    public final TextView branchLabel;
    @NonNull
    public final Button btnPreBidConfirm;
    @NonNull
    public final Button btnPreBidReviewEdit;
    @NonNull
    public final Group group;
    @NonNull
    public final ImageView imageView;
    @NonNull
    public final ImageView imageView2;
    @NonNull
    public final TextView labelVehicleLocation;
    @NonNull
    public final LinearLayout linearLayout2;
    @Bindable
    protected BiddingInformation mBiddingInfo;
    @Bindable
    protected ProductDetailViewModel mViewModel;
    @NonNull
    public final TextView placeBidYearMakeModel;
    @NonNull
    public final FrameLayout placePreBidMainLayout;
    @NonNull
    public final ProgressBar preBidPbLoading;
    @NonNull
    public final ScrollView preBidReviewAndConfirmLayout;
    @NonNull
    public final TextView preBidStartingLabel;
    @NonNull
    public final TextView preBidSubmittedBranch;
    @NonNull
    public final Button preBidSubmittedCloseButton;
    @NonNull
    public final TextView preBidSubmittedCurrentBid;
    @NonNull
    public final ScrollView preBidSubmittedLayout;
    @NonNull
    public final TextView preBidSubmittedMyMax;
    @NonNull
    public final TextView preBidSubmittedStock;
    @NonNull
    public final TextView preBidSubmittedVehicleLocation;
    @NonNull
    public final TextView prebidAwardLabel;
    @NonNull
    public final TextView prebidCurrentBid;
    @NonNull
    public final TextView prebidGoToTaxForm;
    @NonNull
    public final TextView prebidPaymentDueLabel;
    @NonNull
    public final TextView prebidPaymentDueValue;
    @NonNull
    public final TextView prebidPickupDue;
    @NonNull
    public final TextView prebidPickupValue;
    @NonNull
    public final TextView prebidReviewBranch;
    @NonNull
    public final TextView prebidReviewCurrentbid;
    @NonNull
    public final TextView prebidReviewMyMaxBid;
    @NonNull
    public final TextView prebidReviewStock;
    @NonNull
    public final TextView prebidReviewVehicle;
    @NonNull
    public final TextView prebidReviewVehicleLocation;
    @NonNull
    public final LinearLayout prebidSalesTextLayout;
    @NonNull
    public final TextView prebidStartingBid;
    @NonNull
    public final Button prebidSubmitButton;
    @NonNull
    public final TextView prebidTimeRemaining;
    @NonNull
    public final TextView stockLabel;
    @NonNull
    public final TextView textView10;
    @NonNull
    public final TextView textView11;
    @NonNull
    public final TextView textView12;
    @NonNull
    public final TextView textView14;
    @NonNull
    public final TextView textView15;
    @NonNull
    public final TextView textView16;
    @NonNull
    public final TextView textView18;
    @NonNull
    public final TextView textView19;
    @NonNull
    public final TextView textView2;
    @NonNull
    public final TextView textView20;
    @NonNull
    public final TextView textView21;
    @NonNull
    public final TextView textView22;
    @NonNull
    public final TextView textView23;
    @NonNull
    public final TextView textView4;
    @NonNull
    public final TextView textView5;
    @NonNull
    public final TextView textView7;
    @NonNull
    public final TextView textView8;
    @NonNull
    public final TextView tvPrebidSalesTextMsg;
    @NonNull
    public final TextView tvSubmitted;
    @NonNull
    public final TextView txtIncrementBid;
    @NonNull
    public final EditText txtMaxBid;
    @NonNull
    public final TextInputLayout txtMaxBidLayout;
    @NonNull
    public final TextView valuePrebidBranch;
    @NonNull
    public final TextView valueStock;
    @NonNull
    public final TextView valueVehicleLocation;
    @NonNull
    public final View view;
    @NonNull
    public final View view1;
    @NonNull
    public final View view3;
    @NonNull
    public final View view4;
    @NonNull
    public final View view5;

    public abstract void setBiddingInfo(@Nullable BiddingInformation biddingInformation);

    public abstract void setViewModel(@Nullable ProductDetailViewModel productDetailViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected FragmentPrebidLayoutBinding(Object obj, View view2, int i, TextView textView, Button button, Button button2, Group group2, ImageView imageView3, ImageView imageView4, TextView textView3, LinearLayout linearLayout, TextView textView6, FrameLayout frameLayout, ProgressBar progressBar, ScrollView scrollView, TextView textView9, TextView textView13, Button button3, TextView textView17, ScrollView scrollView2, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28, TextView textView29, TextView textView30, TextView textView31, TextView textView32, TextView textView33, TextView textView34, TextView textView35, TextView textView36, TextView textView37, TextView textView38, TextView textView39, LinearLayout linearLayout3, TextView textView40, Button button4, TextView textView41, TextView textView42, TextView textView43, TextView textView44, TextView textView45, TextView textView46, TextView textView47, TextView textView48, TextView textView49, TextView textView50, TextView textView51, TextView textView52, TextView textView53, TextView textView54, TextView textView55, TextView textView56, TextView textView57, TextView textView58, TextView textView59, TextView textView60, TextView textView61, TextView textView62, EditText editText, TextInputLayout textInputLayout, TextView textView63, TextView textView64, TextView textView65, View view6, View view7, View view8, View view9, View view10) {
        super(obj, view2, i);
        this.branchLabel = textView;
        this.btnPreBidConfirm = button;
        this.btnPreBidReviewEdit = button2;
        this.group = group2;
        this.imageView = imageView3;
        this.imageView2 = imageView4;
        this.labelVehicleLocation = textView3;
        this.linearLayout2 = linearLayout;
        this.placeBidYearMakeModel = textView6;
        this.placePreBidMainLayout = frameLayout;
        this.preBidPbLoading = progressBar;
        this.preBidReviewAndConfirmLayout = scrollView;
        this.preBidStartingLabel = textView9;
        this.preBidSubmittedBranch = textView13;
        this.preBidSubmittedCloseButton = button3;
        this.preBidSubmittedCurrentBid = textView17;
        this.preBidSubmittedLayout = scrollView2;
        this.preBidSubmittedMyMax = textView24;
        this.preBidSubmittedStock = textView25;
        this.preBidSubmittedVehicleLocation = textView26;
        this.prebidAwardLabel = textView27;
        this.prebidCurrentBid = textView28;
        this.prebidGoToTaxForm = textView29;
        this.prebidPaymentDueLabel = textView30;
        this.prebidPaymentDueValue = textView31;
        this.prebidPickupDue = textView32;
        this.prebidPickupValue = textView33;
        this.prebidReviewBranch = textView34;
        this.prebidReviewCurrentbid = textView35;
        this.prebidReviewMyMaxBid = textView36;
        this.prebidReviewStock = textView37;
        this.prebidReviewVehicle = textView38;
        this.prebidReviewVehicleLocation = textView39;
        this.prebidSalesTextLayout = linearLayout3;
        this.prebidStartingBid = textView40;
        this.prebidSubmitButton = button4;
        this.prebidTimeRemaining = textView41;
        this.stockLabel = textView42;
        this.textView10 = textView43;
        this.textView11 = textView44;
        this.textView12 = textView45;
        this.textView14 = textView46;
        this.textView15 = textView47;
        this.textView16 = textView48;
        this.textView18 = textView49;
        this.textView19 = textView50;
        this.textView2 = textView51;
        this.textView20 = textView52;
        this.textView21 = textView53;
        this.textView22 = textView54;
        this.textView23 = textView55;
        this.textView4 = textView56;
        this.textView5 = textView57;
        this.textView7 = textView58;
        this.textView8 = textView59;
        this.tvPrebidSalesTextMsg = textView60;
        this.tvSubmitted = textView61;
        this.txtIncrementBid = textView62;
        this.txtMaxBid = editText;
        this.txtMaxBidLayout = textInputLayout;
        this.valuePrebidBranch = textView63;
        this.valueStock = textView64;
        this.valueVehicleLocation = textView65;
        this.view = view6;
        this.view1 = view7;
        this.view3 = view8;
        this.view4 = view9;
        this.view5 = view10;
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
    public static FragmentPrebidLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentPrebidLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentPrebidLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_prebid_layout, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentPrebidLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentPrebidLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentPrebidLayoutBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_prebid_layout, (ViewGroup) null, false, obj);
    }

    public static FragmentPrebidLayoutBinding bind(@NonNull View view2) {
        return bind(view2, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentPrebidLayoutBinding bind(@NonNull View view2, @Nullable Object obj) {
        return (FragmentPrebidLayoutBinding) bind(obj, view2, C2723R.C2728layout.fragment_prebid_layout);
    }
}
