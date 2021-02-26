package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.account.MyAccountViewModel;

public abstract class ActivityMyaccountBinding extends ViewDataBinding {
    @NonNull
    public final RelativeLayout LicenseAndDocumentLayout;
    @NonNull
    public final TextView alertCount;
    @NonNull
    public final ImageView alertIcon;
    @NonNull
    public final RelativeLayout alertLayout;
    @NonNull
    public final TextView awardPendingCount;
    @NonNull
    public final RelativeLayout awardPendingLayout;
    @NonNull
    public final TextView awardPendingNewCount;
    @NonNull
    public final RelativeLayout btnLeaveFeedbackMyccount;
    @NonNull
    public final TextView btnLogout;
    @NonNull
    public final TextView buyNowOfferCount;
    @NonNull
    public final RelativeLayout buyNowOfferLayout;
    @NonNull
    public final TextView buyNowOfferNewCount;
    @NonNull
    public final TextView buyerIdInfo;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final CardView cardView2;
    @NonNull
    public final CardView cardView3;
    @NonNull
    public final CardView cardView4;
    @NonNull
    public final CardView cardView5;
    @NonNull
    public final RelativeLayout historyLayout;
    @NonNull
    public final ImageView iconAwardpending;
    @NonNull
    public final ImageView iconBuyNowOffer;
    @NonNull
    public final ImageView iconLostPrebids;
    @NonNull
    public final ImageView iconManageoffer;
    @NonNull
    public final ImageView iconPrebid;
    @NonNull
    public final ImageView iconPrebids;
    @NonNull
    public final ImageView iconTobepickedup;
    @NonNull
    public final ImageView iconWatching;
    @NonNull
    public final ImageView iconWonHistory;
    @NonNull
    public final TextView lblAwardpending;
    @NonNull
    public final TextView lblBuyNowOffer;
    @NonNull
    public final TextView lblBuyerId;
    @NonNull
    public final TextView lblHistory;
    @NonNull
    public final TextView lblLostorebid;
    @NonNull
    public final TextView lblManageoffer;
    @NonNull
    public final TextView lblPrebid;
    @NonNull
    public final TextView lblPresale;
    @NonNull
    public final TextView lblShowVehicle;
    @NonNull
    public final TextView lblTobepaid;
    @NonNull
    public final TextView lblTobepickedup;
    @NonNull
    public final TextView lblWatching;
    @NonNull
    public final TextView lblWonhistory;
    @NonNull
    public final TextView licenseAndDocumentId;
    @NonNull
    public final TextView lostPrebidsnewCount;
    @NonNull
    public final RelativeLayout lostprebidLayout;
    @Bindable
    protected MyAccountViewModel mViewModel;
    @NonNull
    public final TextView manageofferCount;
    @NonNull
    public final TextView manageofferNewCount;
    @NonNull
    public final ScrollView myAccountScrollView;
    @NonNull
    public final RelativeLayout postSaleLayout;
    @NonNull
    public final RelativeLayout preSaleLayout;
    @NonNull
    public final RelativeLayout prebidLayout;
    @NonNull
    public final TextView prebidNewCount;
    @NonNull
    public final TextView prebidsCount;
    @NonNull
    public final TextView profileId;
    @NonNull
    public final RelativeLayout profileLayout;
    @NonNull
    public final ProgressBar progressBarMyAccount;
    @NonNull
    public final CardView registrationCardView;
    @NonNull
    public final RelativeLayout relativeLayoutUser;
    @NonNull
    public final TextView renewalId;
    @NonNull
    public final RelativeLayout renewalLayout;
    @NonNull
    public final RelativeLayout rlManageOfferLayout;
    @NonNull
    public final RelativeLayout showMYVehicleRelativeLayout;
    @NonNull
    public final Switch showVehicleSwitch;
    @NonNull
    public final SwipeRefreshLayout swipeContainer;
    @NonNull
    public final TextView tobePickedupCount;
    @NonNull
    public final TextView tobePickedupNewCount;
    @NonNull
    public final TextView tobepaidCount;
    @NonNull
    public final RelativeLayout tobepaidLayout;
    @NonNull
    public final TextView tobepaidNewCount;
    @NonNull
    public final RelativeLayout tobepickedupLayout;
    @NonNull
    public final TextView upgradeAccountId;
    @NonNull
    public final RelativeLayout upgradeAccountLayout;
    @NonNull
    public final TextView userName;
    @NonNull
    public final ImageView userPicture;
    @NonNull
    public final RelativeLayout watchingLayout;
    @NonNull
    public final RelativeLayout wonHistoryLayout;

    public abstract void setViewModel(@Nullable MyAccountViewModel myAccountViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected ActivityMyaccountBinding(Object obj, View view, int i, RelativeLayout relativeLayout, TextView textView, ImageView imageView, RelativeLayout relativeLayout2, TextView textView2, RelativeLayout relativeLayout3, TextView textView3, RelativeLayout relativeLayout4, TextView textView4, TextView textView5, RelativeLayout relativeLayout5, TextView textView6, TextView textView7, CardView cardView6, CardView cardView7, CardView cardView8, CardView cardView9, CardView cardView10, RelativeLayout relativeLayout6, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, RelativeLayout relativeLayout7, TextView textView23, TextView textView24, ScrollView scrollView, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, RelativeLayout relativeLayout10, TextView textView25, TextView textView26, TextView textView27, RelativeLayout relativeLayout11, ProgressBar progressBar, CardView cardView11, RelativeLayout relativeLayout12, TextView textView28, RelativeLayout relativeLayout13, RelativeLayout relativeLayout14, RelativeLayout relativeLayout15, Switch switchR, SwipeRefreshLayout swipeRefreshLayout, TextView textView29, TextView textView30, TextView textView31, RelativeLayout relativeLayout16, TextView textView32, RelativeLayout relativeLayout17, TextView textView33, RelativeLayout relativeLayout18, TextView textView34, ImageView imageView11, RelativeLayout relativeLayout19, RelativeLayout relativeLayout20) {
        super(obj, view, i);
        this.LicenseAndDocumentLayout = relativeLayout;
        this.alertCount = textView;
        this.alertIcon = imageView;
        this.alertLayout = relativeLayout2;
        this.awardPendingCount = textView2;
        this.awardPendingLayout = relativeLayout3;
        this.awardPendingNewCount = textView3;
        this.btnLeaveFeedbackMyccount = relativeLayout4;
        this.btnLogout = textView4;
        this.buyNowOfferCount = textView5;
        this.buyNowOfferLayout = relativeLayout5;
        this.buyNowOfferNewCount = textView6;
        this.buyerIdInfo = textView7;
        this.cardView = cardView6;
        this.cardView2 = cardView7;
        this.cardView3 = cardView8;
        this.cardView4 = cardView9;
        this.cardView5 = cardView10;
        this.historyLayout = relativeLayout6;
        this.iconAwardpending = imageView2;
        this.iconBuyNowOffer = imageView3;
        this.iconLostPrebids = imageView4;
        this.iconManageoffer = imageView5;
        this.iconPrebid = imageView6;
        this.iconPrebids = imageView7;
        this.iconTobepickedup = imageView8;
        this.iconWatching = imageView9;
        this.iconWonHistory = imageView10;
        this.lblAwardpending = textView8;
        this.lblBuyNowOffer = textView9;
        this.lblBuyerId = textView10;
        this.lblHistory = textView11;
        this.lblLostorebid = textView12;
        this.lblManageoffer = textView13;
        this.lblPrebid = textView14;
        this.lblPresale = textView15;
        this.lblShowVehicle = textView16;
        this.lblTobepaid = textView17;
        this.lblTobepickedup = textView18;
        this.lblWatching = textView19;
        this.lblWonhistory = textView20;
        this.licenseAndDocumentId = textView21;
        this.lostPrebidsnewCount = textView22;
        this.lostprebidLayout = relativeLayout7;
        this.manageofferCount = textView23;
        this.manageofferNewCount = textView24;
        this.myAccountScrollView = scrollView;
        this.postSaleLayout = relativeLayout8;
        this.preSaleLayout = relativeLayout9;
        this.prebidLayout = relativeLayout10;
        this.prebidNewCount = textView25;
        this.prebidsCount = textView26;
        this.profileId = textView27;
        this.profileLayout = relativeLayout11;
        this.progressBarMyAccount = progressBar;
        this.registrationCardView = cardView11;
        this.relativeLayoutUser = relativeLayout12;
        this.renewalId = textView28;
        this.renewalLayout = relativeLayout13;
        this.rlManageOfferLayout = relativeLayout14;
        this.showMYVehicleRelativeLayout = relativeLayout15;
        this.showVehicleSwitch = switchR;
        this.swipeContainer = swipeRefreshLayout;
        this.tobePickedupCount = textView29;
        this.tobePickedupNewCount = textView30;
        this.tobepaidCount = textView31;
        this.tobepaidLayout = relativeLayout16;
        this.tobepaidNewCount = textView32;
        this.tobepickedupLayout = relativeLayout17;
        this.upgradeAccountId = textView33;
        this.upgradeAccountLayout = relativeLayout18;
        this.userName = textView34;
        this.userPicture = imageView11;
        this.watchingLayout = relativeLayout19;
        this.wonHistoryLayout = relativeLayout20;
    }

    @Nullable
    public MyAccountViewModel getViewModel() {
        return this.mViewModel;
    }

    @NonNull
    public static ActivityMyaccountBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityMyaccountBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ActivityMyaccountBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_myaccount, viewGroup, z, obj);
    }

    @NonNull
    public static ActivityMyaccountBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ActivityMyaccountBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ActivityMyaccountBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.activity_myaccount, (ViewGroup) null, false, obj);
    }

    public static ActivityMyaccountBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMyaccountBinding bind(@NonNull View view, @Nullable Object obj) {
        return (ActivityMyaccountBinding) bind(obj, view, C2723R.C2728layout.activity_myaccount);
    }
}
