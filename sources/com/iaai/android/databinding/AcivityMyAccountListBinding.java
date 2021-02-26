package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.iaai.android.C2723R;

public abstract class AcivityMyAccountListBinding extends ViewDataBinding {
    @NonNull
    public final Button btnUpgradeNow;
    @NonNull
    public final LinearLayout frameLayout;
    @NonNull
    public final TextView lblAwardPending;
    @NonNull
    public final TextView lblBuyNowOffer;
    @NonNull
    public final TextView lblHistory;
    @NonNull
    public final TextView lblLostPrebid;
    @NonNull
    public final TextView lblManageOffer;
    @NonNull
    public final TextView lblNotification;
    @NonNull
    public final TextView lblPostSale;
    @NonNull
    public final TextView lblPreBid;
    @NonNull
    public final TextView lblPreSale;
    @NonNull
    public final TextView lblPurchaseHistory;
    @NonNull
    public final TextView lblSaleDocument;
    @NonNull
    public final TextView lblShowVehicle;
    @NonNull
    public final TextView lblToBePaid;
    @NonNull
    public final TextView lblToBePickedup;
    @NonNull
    public final TextView lblWatching;
    @NonNull
    public final LinearLayout llGuestUser;
    @NonNull
    public final LinearLayout llHistoryContainer;
    @NonNull
    public final LinearLayout llLostPreBid;
    @NonNull
    public final LinearLayout llNotificationContainer;
    @NonNull
    public final LinearLayout llPostSaleContainer;
    @NonNull
    public final LinearLayout llPurchaseHistory;
    @NonNull
    public final TextView notification;
    @NonNull
    public final RelativeLayout preSaleLayout;
    @NonNull
    public final RelativeLayout rlAwardPending;
    @NonNull
    public final RelativeLayout rlBuyNowOffer;
    @NonNull
    public final LinearLayout rlFeedback;
    @NonNull
    public final RelativeLayout rlHistoryLayout;
    @NonNull
    public final RelativeLayout rlLostPreBid;
    @NonNull
    public final RelativeLayout rlManageOffer;
    @NonNull
    public final RelativeLayout rlNotification;
    @NonNull
    public final RelativeLayout rlNotificationLayout;
    @NonNull
    public final RelativeLayout rlPostSaleLayout;
    @NonNull
    public final RelativeLayout rlPreBid;
    @NonNull
    public final RelativeLayout rlPurchaseHistory;
    @NonNull
    public final RelativeLayout rlSaleDocument;
    @NonNull
    public final RelativeLayout rlTobePaid;
    @NonNull
    public final RelativeLayout rlTobePickedup;
    @NonNull
    public final RelativeLayout rlWatching;
    @NonNull
    public final RelativeLayout showMYVehicleRelativeLayout;
    @NonNull
    public final Switch showVehicleSwitch;
    @NonNull
    public final NestedScrollView svDataContainer;
    @NonNull
    public final TextView tvAwardPendingCount;
    @NonNull
    public final TextView tvAwardPendingNewCount;
    @NonNull
    public final TextView tvBuyNowCount;
    @NonNull
    public final TextView tvBuyNowNewCount;
    @NonNull
    public final TextView tvLable;
    @NonNull
    public final TextView tvLostPreBidCount;
    @NonNull
    public final TextView tvLostPreBidNewCount;
    @NonNull
    public final TextView tvManageOfferNewCount;
    @NonNull
    public final TextView tvManagerOfferCount;
    @NonNull
    public final TextView tvNotificationCount;
    @NonNull
    public final TextView tvNotificationNewCount;
    @NonNull
    public final TextView tvPreBidCount;
    @NonNull
    public final TextView tvPreBidNewCount;
    @NonNull
    public final TextView tvPurchaseCount;
    @NonNull
    public final TextView tvSaleDocumentCount;
    @NonNull
    public final TextView tvSaleDocumentNewCount;
    @NonNull
    public final TextView tvSalePurchaseNewCount;
    @NonNull
    public final TextView tvTobePaidCount;
    @NonNull
    public final TextView tvTobePaidNewCount;
    @NonNull
    public final TextView tvTobePickedUpCount;
    @NonNull
    public final TextView tvTobePickedUpNewCount;
    @NonNull
    public final TextView tvWatchingCount;
    @NonNull
    public final TextView tvWatchingNewCount;
    @NonNull
    public final View viewManageOffer;
    @NonNull
    public final View viewSwitch;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected AcivityMyAccountListBinding(Object obj, View view, int i, Button button, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, LinearLayout linearLayout7, TextView textView16, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, LinearLayout linearLayout8, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, RelativeLayout relativeLayout11, RelativeLayout relativeLayout12, RelativeLayout relativeLayout13, RelativeLayout relativeLayout14, RelativeLayout relativeLayout15, RelativeLayout relativeLayout16, Switch switchR, NestedScrollView nestedScrollView, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28, TextView textView29, TextView textView30, TextView textView31, TextView textView32, TextView textView33, TextView textView34, TextView textView35, TextView textView36, TextView textView37, TextView textView38, TextView textView39, View view2, View view3) {
        super(obj, view, i);
        this.btnUpgradeNow = button;
        this.frameLayout = linearLayout;
        this.lblAwardPending = textView;
        this.lblBuyNowOffer = textView2;
        this.lblHistory = textView3;
        this.lblLostPrebid = textView4;
        this.lblManageOffer = textView5;
        this.lblNotification = textView6;
        this.lblPostSale = textView7;
        this.lblPreBid = textView8;
        this.lblPreSale = textView9;
        this.lblPurchaseHistory = textView10;
        this.lblSaleDocument = textView11;
        this.lblShowVehicle = textView12;
        this.lblToBePaid = textView13;
        this.lblToBePickedup = textView14;
        this.lblWatching = textView15;
        this.llGuestUser = linearLayout2;
        this.llHistoryContainer = linearLayout3;
        this.llLostPreBid = linearLayout4;
        this.llNotificationContainer = linearLayout5;
        this.llPostSaleContainer = linearLayout6;
        this.llPurchaseHistory = linearLayout7;
        this.notification = textView16;
        this.preSaleLayout = relativeLayout;
        this.rlAwardPending = relativeLayout2;
        this.rlBuyNowOffer = relativeLayout3;
        this.rlFeedback = linearLayout8;
        this.rlHistoryLayout = relativeLayout4;
        this.rlLostPreBid = relativeLayout5;
        this.rlManageOffer = relativeLayout6;
        this.rlNotification = relativeLayout7;
        this.rlNotificationLayout = relativeLayout8;
        this.rlPostSaleLayout = relativeLayout9;
        this.rlPreBid = relativeLayout10;
        this.rlPurchaseHistory = relativeLayout11;
        this.rlSaleDocument = relativeLayout12;
        this.rlTobePaid = relativeLayout13;
        this.rlTobePickedup = relativeLayout14;
        this.rlWatching = relativeLayout15;
        this.showMYVehicleRelativeLayout = relativeLayout16;
        this.showVehicleSwitch = switchR;
        this.svDataContainer = nestedScrollView;
        this.tvAwardPendingCount = textView17;
        this.tvAwardPendingNewCount = textView18;
        this.tvBuyNowCount = textView19;
        this.tvBuyNowNewCount = textView20;
        this.tvLable = textView21;
        this.tvLostPreBidCount = textView22;
        this.tvLostPreBidNewCount = textView23;
        this.tvManageOfferNewCount = textView24;
        this.tvManagerOfferCount = textView25;
        this.tvNotificationCount = textView26;
        this.tvNotificationNewCount = textView27;
        this.tvPreBidCount = textView28;
        this.tvPreBidNewCount = textView29;
        this.tvPurchaseCount = textView30;
        this.tvSaleDocumentCount = textView31;
        this.tvSaleDocumentNewCount = textView32;
        this.tvSalePurchaseNewCount = textView33;
        this.tvTobePaidCount = textView34;
        this.tvTobePaidNewCount = textView35;
        this.tvTobePickedUpCount = textView36;
        this.tvTobePickedUpNewCount = textView37;
        this.tvWatchingCount = textView38;
        this.tvWatchingNewCount = textView39;
        this.viewManageOffer = view2;
        this.viewSwitch = view3;
    }

    @NonNull
    public static AcivityMyAccountListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcivityMyAccountListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (AcivityMyAccountListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.acivity_my_account_list, viewGroup, z, obj);
    }

    @NonNull
    public static AcivityMyAccountListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcivityMyAccountListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (AcivityMyAccountListBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.acivity_my_account_list, (ViewGroup) null, false, obj);
    }

    public static AcivityMyAccountListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AcivityMyAccountListBinding bind(@NonNull View view, @Nullable Object obj) {
        return (AcivityMyAccountListBinding) bind(obj, view, C2723R.C2728layout.acivity_my_account_list);
    }
}
