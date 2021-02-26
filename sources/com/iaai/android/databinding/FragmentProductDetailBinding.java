package com.iaai.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.github.anastr.speedviewlib.TubeSpeedometer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.productDetail.ProductDetailViewModel;
import com.iaai.android.bdt.model.productDetail.biddingInfo.BiddingInformation;
import com.synnapps.carouselview.CarouselView;

public abstract class FragmentProductDetailBinding extends ViewDataBinding {
    @NonNull
    public final TextView SalesTextWarning;
    @NonNull
    public final View Separator;
    @NonNull
    public final LinearLayout VinViewMore;
    @NonNull
    public final View auctionNotAssignSeparator;
    @NonNull
    public final ImageView bidBuyInd;
    @NonNull
    public final TextView bidBuyWarning;
    @NonNull
    public final TextView biddingNotesPreBid;
    @NonNull
    public final LinearLayout biddingViewMore;
    @NonNull
    public final Button btnBuyNow;
    @NonNull
    public final Button btnChromeData;
    @NonNull
    public final Button btnEdit;
    @NonNull
    public final Button btnPreBid;
    @NonNull
    public final Button btnTimedBid;
    @NonNull
    public final TextView btnVehicle;
    @NonNull
    public final CardView cardViewSaleInfo;
    @NonNull
    public final CardView cardViewVinDetail;
    @NonNull
    public final RelativeLayout conditionInfo;
    @NonNull
    public final ImageView conditionInfoIc;
    @NonNull
    public final LinearLayout conditionViewMore;
    @NonNull
    public final View costSeparator;
    @NonNull
    public final CardView cvAuctionCmplete;
    @NonNull
    public final CardView cvConditionInfo;
    @NonNull
    public final CardView cvIaaInteractInfo;
    @NonNull
    public final CardView cvPreBidBuy;
    @NonNull
    public final CarouselView cvVehicleImages;
    @NonNull
    public final TextView emptyView;
    @NonNull
    public final TextView estimateBid;
    @NonNull
    public final TextView estimateFinalCost;
    @NonNull
    public final RelativeLayout flTubeSpeed;
    @NonNull
    public final HorizontalScrollView horizontalScrollviewRefiners;
    @NonNull
    public final LinearLayout iaaInteractLearnMore;
    @NonNull
    public final ImageView icArrow;
    @NonNull
    public final ImageView icBiddingViewMore;
    @NonNull
    public final ImageView icSalesViewMore;
    @NonNull
    public final ImageView icUnwatch;
    @NonNull
    public final ImageView icVCconditionViewMore;
    @NonNull
    public final ImageView icVinViewMore;
    @NonNull
    public final ImageView icWatch;
    @NonNull
    public final ImageView icYmmViewMore;
    @NonNull
    public final ImageView imgDealer;
    @NonNull
    public final ImageView imgDismantler;
    @NonNull
    public final ImageView imgExporter;
    @NonNull
    public final ImageView imgNonAuto;
    @NonNull
    public final ImageView imgOtherLicensed;
    @NonNull
    public final ImageView imgPublic;
    @NonNull
    public final ImageView imgRebuilder;
    @NonNull
    public final ImageView imgScrapper;
    @NonNull
    public final LinearLayout iv360Image;
    @NonNull
    public final ImageView ivArrowIaaInteract;
    @NonNull
    public final ImageView ivArrowMore;
    @NonNull
    public final ImageView ivColorIcon;
    @NonNull
    public final ImageView ivConditionToolTip;
    @NonNull
    public final ImageView ivEnginePlayOverlay;
    @NonNull
    public final LinearLayout ivEngineVideo;
    @NonNull
    public final LinearLayout ivHdImage;
    @NonNull
    public final LinearLayout ivKey;
    @NonNull
    public final ImageView ivSaleInfoTip;
    @NonNull
    public final LinearLayout ivTireTread;
    @NonNull
    public final ImageView ivVinToolTip;
    @NonNull
    public final TextView joinNow;
    @NonNull
    public final View layoutBidLive;
    @NonNull
    public final LinearLayout layoutNonUSProductDetailContainer;
    @NonNull
    public final LinearLayout layoutUSProductDetailContainer;
    @NonNull
    public final View layoutUkcan;
    @NonNull
    public final LinearLayout llBidBuyInd;
    @NonNull
    public final LinearLayout llBidSection;
    @NonNull
    public final LinearLayout llBuyNowSection;
    @NonNull
    public final LinearLayout llBuyNowSold;
    @NonNull
    public final LinearLayout llBuyPrice;
    @NonNull
    public final LinearLayout llCostCalculator;
    @NonNull
    public final LinearLayout llCurrentBid;
    @NonNull
    public final LinearLayout llEstimatedCostValue;
    @NonNull
    public final RelativeLayout llGradeContainer;
    @NonNull
    public final LinearLayout llImageDownload;
    @NonNull
    public final LinearLayout llImages;
    @NonNull
    public final LinearLayout llMaxBid;
    @NonNull
    public final LinearLayout llPartHeader;
    @NonNull
    public final LinearLayout llParts;
    @NonNull
    public final LinearLayout llPreBidSection;
    @NonNull
    public final LinearLayout llPremiumVehicleReport;
    @NonNull
    public final LinearLayout llSalesInfo;
    @NonNull
    public final LinearLayout llSalesTaxInd;
    @NonNull
    public final LinearLayout llTimedAuctionSection;
    @NonNull
    public final LinearLayout llTimedAuctionStartBid;
    @NonNull
    public final LinearLayout llTimedBidStatus;
    @NonNull
    public final LinearLayout llTimedMaxBid;
    @NonNull
    public final LinearLayout llUnWatchLayout;
    @NonNull
    public final LinearLayout llWatchLayout;
    @Bindable
    protected BiddingInformation mBiddingInfo;
    @Bindable
    protected ProductDetailViewModel mViewModel;
    @NonNull
    public final ProgressBar pbLoading;
    @NonNull
    public final TextView preBidClosed;
    @NonNull
    public final View preBidSeparator;
    @NonNull
    public final LinearLayout preBidlayout;
    @NonNull
    public final ImageView premiumVehicleIc;
    @NonNull
    public final TextView productDtlHeader;
    @NonNull
    public final LinearLayout rlGradeContainer;
    @NonNull
    public final RelativeLayout rlPremiumVehicleReport;
    @NonNull
    public final RelativeLayout rlSection;
    @NonNull
    public final RelativeLayout rlVehicleReport;
    @NonNull
    public final RelativeLayout rlVinParts;
    @NonNull
    public final RelativeLayout rlWatchUnWatch;
    @NonNull
    public final RelativeLayout rlYouCanBuy;
    @NonNull
    public final LinearLayout rvCondition;
    @NonNull
    public final RecyclerView rvConditionInfo;
    @NonNull
    public final LinearLayout rvPartDetails;
    @NonNull
    public final LinearLayout rvPartsDetails;
    @NonNull
    public final RecyclerView rvPartsDetailsInfo;
    @NonNull
    public final LinearLayout rvPartsLogin;
    @NonNull
    public final LinearLayout rvVinDetails;
    @NonNull
    public final RecyclerView rvVinDetailsInfo;
    @NonNull
    public final RelativeLayout saleInfo;
    @NonNull
    public final ImageView salesInfoIc;
    @NonNull
    public final LinearLayout salesInfoViewMore;
    @NonNull
    public final View salesSeparator;
    @NonNull
    public final ImageView salesTaxInd;
    @NonNull
    public final LinearLayout sectionVehicleImageIcon;
    @NonNull
    public final View separator;
    @NonNull
    public final View separatorGrade;
    @NonNull
    public final ScrollView svDataContainer;
    @NonNull
    public final TubeSpeedometer tubeSpeedometer;
    @NonNull

    /* renamed from: tv */
    public final TextView f507tv;
    @NonNull
    public final TextView tv360;
    @NonNull
    public final TextView tvAuctionCompletedStockNotAvailable;
    @NonNull
    public final TextView tvAuctionNotAssigned;
    @NonNull
    public final TextView tvBidStatusSubTitle;
    @NonNull
    public final TextView tvBidStatusTitle;
    @NonNull
    public final TextView tvBiddingStatus;
    @NonNull
    public final TextView tvBuyNowSold;
    @NonNull
    public final TextView tvBuyNowSoldMessage;
    @NonNull
    public final TextView tvBuyPriceValue;
    @NonNull
    public final TextView tvCanBid;
    @NonNull
    public final TextView tvClosingTimeValue;
    @NonNull
    public final TextView tvConditionInfoHeader;
    @NonNull
    public final TextView tvCostOfRepairReport;
    @NonNull
    public final TextView tvCurrentBidAmount;
    @NonNull
    public final TextView tvDealer;
    @NonNull
    public final TextView tvDismantler;
    @NonNull
    public final TextView tvExporter;
    @NonNull
    public final TextView tvFindPartReport;
    @NonNull
    public final TextView tvGradeLbl;
    @NonNull
    public final TextView tvGradeLearn;
    @NonNull
    public final TextView tvIAAConditionReport;
    @NonNull
    public final TextView tvICChangeID;
    @NonNull
    public final TextView tvICDescriptionID;
    @NonNull
    public final TextView tvIaaInteractLearn;
    @NonNull
    public final TextView tvLabelIaaInteract;
    @NonNull
    public final TextView tvLiveSaleValue;
    @NonNull
    public final TextView tvMaxBidValue;
    @NonNull
    public final TextView tvNonAuto;
    @NonNull
    public final TextView tvOtherLicensed;
    @NonNull
    public final TextView tvParts;
    @NonNull
    public final TextView tvPartsError;
    @NonNull
    public final TextView tvPartsID;
    @NonNull
    public final TextView tvPartsLogin;
    @NonNull
    public final TextView tvPremiumVehicleReport;
    @NonNull
    public final TextView tvPublic;
    @NonNull
    public final TextView tvRebuilder;
    @NonNull
    public final TextView tvReserveMetStatus;
    @NonNull
    public final TextView tvSaleInfoLabel;
    @NonNull
    public final TextView tvScrapper;
    @NonNull
    public final TextView tvState;
    @NonNull
    public final TextView tvStatusWarning;
    @NonNull
    public final TextView tvStockNo;
    @NonNull
    public final TextView tvStockValue;
    @NonNull
    public final TextView tvTimedAuctionClosed;
    @NonNull
    public final TextView tvTimedAuctionClosedDate;
    @NonNull
    public final TextView tvTimedBiddingStatus;
    @NonNull
    public final TextView tvTimedCurrentBidValue;
    @NonNull
    public final TextView tvTimedMaxBidValue;
    @NonNull
    public final TextView tvTimedStartingBidValue;
    @NonNull
    public final TextView tvTitleNotAvailable;
    @NonNull
    public final TextView tvVehicleMakeModel;
    @NonNull
    public final TextView tvVehicleReport;
    @NonNull
    public final TextView tvVinDetailLabel;
    @NonNull
    public final TextView tvVinNo;
    @NonNull
    public final TextView tvVinValue;
    @NonNull
    public final TextView tvWarning;
    @NonNull
    public final TextView txtSalesInfoViewMore;
    @NonNull
    public final TextView txtVCCondiViewMore;
    @NonNull
    public final TextView txtVinViewMore;
    @NonNull
    public final TextView txtbiddingInfoViewMore;
    @NonNull
    public final RelativeLayout vehicleDetailImgLayout;
    @NonNull
    public final ImageView vehicleImageDownload;
    @NonNull
    public final LinearLayout vehicleImageListView;
    @NonNull
    public final ImageView vinInfoIc;
    @NonNull
    public final RelativeLayout vinPartsInfo;
    @NonNull
    public final LinearLayout vinPartsLayout;
    @NonNull
    public final View vinPartsSeparator;
    @NonNull
    public final View vinSeparator;
    @NonNull
    public final View watchSeparator;
    @NonNull
    public final LinearLayout whocanbid;
    @NonNull
    public final TextView ymmViewMore;
    @NonNull
    public final LinearLayout ymmViewMoreLayout;

    public abstract void setBiddingInfo(@Nullable BiddingInformation biddingInformation);

    public abstract void setViewModel(@Nullable ProductDetailViewModel productDetailViewModel);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected FragmentProductDetailBinding(Object obj, View view, int i, TextView textView, View view2, LinearLayout linearLayout, View view3, ImageView imageView, TextView textView2, TextView textView3, LinearLayout linearLayout2, Button button, Button button2, Button button3, Button button4, Button button5, TextView textView4, CardView cardView, CardView cardView2, RelativeLayout relativeLayout, ImageView imageView2, LinearLayout linearLayout3, View view4, CardView cardView3, CardView cardView4, CardView cardView5, CardView cardView6, CarouselView carouselView, TextView textView5, TextView textView6, TextView textView7, RelativeLayout relativeLayout2, HorizontalScrollView horizontalScrollView, LinearLayout linearLayout4, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, ImageView imageView11, ImageView imageView12, ImageView imageView13, ImageView imageView14, ImageView imageView15, ImageView imageView16, ImageView imageView17, ImageView imageView18, LinearLayout linearLayout5, ImageView imageView19, ImageView imageView20, ImageView imageView21, ImageView imageView22, ImageView imageView23, LinearLayout linearLayout6, LinearLayout linearLayout7, LinearLayout linearLayout8, ImageView imageView24, LinearLayout linearLayout9, ImageView imageView25, TextView textView8, View view5, LinearLayout linearLayout10, LinearLayout linearLayout11, View view6, LinearLayout linearLayout12, LinearLayout linearLayout13, LinearLayout linearLayout14, LinearLayout linearLayout15, LinearLayout linearLayout16, LinearLayout linearLayout17, LinearLayout linearLayout18, LinearLayout linearLayout19, RelativeLayout relativeLayout3, LinearLayout linearLayout20, LinearLayout linearLayout21, LinearLayout linearLayout22, LinearLayout linearLayout23, LinearLayout linearLayout24, LinearLayout linearLayout25, LinearLayout linearLayout26, LinearLayout linearLayout27, LinearLayout linearLayout28, LinearLayout linearLayout29, LinearLayout linearLayout30, LinearLayout linearLayout31, LinearLayout linearLayout32, LinearLayout linearLayout33, LinearLayout linearLayout34, ProgressBar progressBar, TextView textView9, View view7, LinearLayout linearLayout35, ImageView imageView26, TextView textView10, LinearLayout linearLayout36, RelativeLayout relativeLayout4, RelativeLayout relativeLayout5, RelativeLayout relativeLayout6, RelativeLayout relativeLayout7, RelativeLayout relativeLayout8, RelativeLayout relativeLayout9, LinearLayout linearLayout37, RecyclerView recyclerView, LinearLayout linearLayout38, LinearLayout linearLayout39, RecyclerView recyclerView2, LinearLayout linearLayout40, LinearLayout linearLayout41, RecyclerView recyclerView3, RelativeLayout relativeLayout10, ImageView imageView27, LinearLayout linearLayout42, View view8, ImageView imageView28, LinearLayout linearLayout43, View view9, View view10, ScrollView scrollView, TubeSpeedometer tubeSpeedometer2, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28, TextView textView29, TextView textView30, TextView textView31, TextView textView32, TextView textView33, TextView textView34, TextView textView35, TextView textView36, TextView textView37, TextView textView38, TextView textView39, TextView textView40, TextView textView41, TextView textView42, TextView textView43, TextView textView44, TextView textView45, TextView textView46, TextView textView47, TextView textView48, TextView textView49, TextView textView50, TextView textView51, TextView textView52, TextView textView53, TextView textView54, TextView textView55, TextView textView56, TextView textView57, TextView textView58, TextView textView59, TextView textView60, TextView textView61, TextView textView62, TextView textView63, TextView textView64, TextView textView65, TextView textView66, TextView textView67, TextView textView68, TextView textView69, TextView textView70, TextView textView71, RelativeLayout relativeLayout11, ImageView imageView29, LinearLayout linearLayout44, ImageView imageView30, RelativeLayout relativeLayout12, LinearLayout linearLayout45, View view11, View view12, View view13, LinearLayout linearLayout46, TextView textView72, LinearLayout linearLayout47) {
        super(obj, view, i);
        this.SalesTextWarning = textView;
        this.Separator = view2;
        this.VinViewMore = linearLayout;
        this.auctionNotAssignSeparator = view3;
        this.bidBuyInd = imageView;
        this.bidBuyWarning = textView2;
        this.biddingNotesPreBid = textView3;
        this.biddingViewMore = linearLayout2;
        this.btnBuyNow = button;
        this.btnChromeData = button2;
        this.btnEdit = button3;
        this.btnPreBid = button4;
        this.btnTimedBid = button5;
        this.btnVehicle = textView4;
        this.cardViewSaleInfo = cardView;
        this.cardViewVinDetail = cardView2;
        this.conditionInfo = relativeLayout;
        this.conditionInfoIc = imageView2;
        this.conditionViewMore = linearLayout3;
        this.costSeparator = view4;
        this.cvAuctionCmplete = cardView3;
        this.cvConditionInfo = cardView4;
        this.cvIaaInteractInfo = cardView5;
        this.cvPreBidBuy = cardView6;
        this.cvVehicleImages = carouselView;
        this.emptyView = textView5;
        this.estimateBid = textView6;
        this.estimateFinalCost = textView7;
        this.flTubeSpeed = relativeLayout2;
        this.horizontalScrollviewRefiners = horizontalScrollView;
        this.iaaInteractLearnMore = linearLayout4;
        this.icArrow = imageView3;
        this.icBiddingViewMore = imageView4;
        this.icSalesViewMore = imageView5;
        this.icUnwatch = imageView6;
        this.icVCconditionViewMore = imageView7;
        this.icVinViewMore = imageView8;
        this.icWatch = imageView9;
        this.icYmmViewMore = imageView10;
        this.imgDealer = imageView11;
        this.imgDismantler = imageView12;
        this.imgExporter = imageView13;
        this.imgNonAuto = imageView14;
        this.imgOtherLicensed = imageView15;
        this.imgPublic = imageView16;
        this.imgRebuilder = imageView17;
        this.imgScrapper = imageView18;
        this.iv360Image = linearLayout5;
        this.ivArrowIaaInteract = imageView19;
        this.ivArrowMore = imageView20;
        this.ivColorIcon = imageView21;
        this.ivConditionToolTip = imageView22;
        this.ivEnginePlayOverlay = imageView23;
        this.ivEngineVideo = linearLayout6;
        this.ivHdImage = linearLayout7;
        this.ivKey = linearLayout8;
        this.ivSaleInfoTip = imageView24;
        this.ivTireTread = linearLayout9;
        this.ivVinToolTip = imageView25;
        this.joinNow = textView8;
        this.layoutBidLive = view5;
        this.layoutNonUSProductDetailContainer = linearLayout10;
        this.layoutUSProductDetailContainer = linearLayout11;
        this.layoutUkcan = view6;
        this.llBidBuyInd = linearLayout12;
        this.llBidSection = linearLayout13;
        this.llBuyNowSection = linearLayout14;
        this.llBuyNowSold = linearLayout15;
        this.llBuyPrice = linearLayout16;
        this.llCostCalculator = linearLayout17;
        this.llCurrentBid = linearLayout18;
        this.llEstimatedCostValue = linearLayout19;
        this.llGradeContainer = relativeLayout3;
        this.llImageDownload = linearLayout20;
        this.llImages = linearLayout21;
        this.llMaxBid = linearLayout22;
        this.llPartHeader = linearLayout23;
        this.llParts = linearLayout24;
        this.llPreBidSection = linearLayout25;
        this.llPremiumVehicleReport = linearLayout26;
        this.llSalesInfo = linearLayout27;
        this.llSalesTaxInd = linearLayout28;
        this.llTimedAuctionSection = linearLayout29;
        this.llTimedAuctionStartBid = linearLayout30;
        this.llTimedBidStatus = linearLayout31;
        this.llTimedMaxBid = linearLayout32;
        this.llUnWatchLayout = linearLayout33;
        this.llWatchLayout = linearLayout34;
        this.pbLoading = progressBar;
        this.preBidClosed = textView9;
        this.preBidSeparator = view7;
        this.preBidlayout = linearLayout35;
        this.premiumVehicleIc = imageView26;
        this.productDtlHeader = textView10;
        this.rlGradeContainer = linearLayout36;
        this.rlPremiumVehicleReport = relativeLayout4;
        this.rlSection = relativeLayout5;
        this.rlVehicleReport = relativeLayout6;
        this.rlVinParts = relativeLayout7;
        this.rlWatchUnWatch = relativeLayout8;
        this.rlYouCanBuy = relativeLayout9;
        this.rvCondition = linearLayout37;
        this.rvConditionInfo = recyclerView;
        this.rvPartDetails = linearLayout38;
        this.rvPartsDetails = linearLayout39;
        this.rvPartsDetailsInfo = recyclerView2;
        this.rvPartsLogin = linearLayout40;
        this.rvVinDetails = linearLayout41;
        this.rvVinDetailsInfo = recyclerView3;
        this.saleInfo = relativeLayout10;
        this.salesInfoIc = imageView27;
        this.salesInfoViewMore = linearLayout42;
        this.salesSeparator = view8;
        this.salesTaxInd = imageView28;
        this.sectionVehicleImageIcon = linearLayout43;
        this.separator = view9;
        this.separatorGrade = view10;
        this.svDataContainer = scrollView;
        this.tubeSpeedometer = tubeSpeedometer2;
        this.f507tv = textView11;
        this.tv360 = textView12;
        this.tvAuctionCompletedStockNotAvailable = textView13;
        this.tvAuctionNotAssigned = textView14;
        this.tvBidStatusSubTitle = textView15;
        this.tvBidStatusTitle = textView16;
        this.tvBiddingStatus = textView17;
        this.tvBuyNowSold = textView18;
        this.tvBuyNowSoldMessage = textView19;
        this.tvBuyPriceValue = textView20;
        this.tvCanBid = textView21;
        this.tvClosingTimeValue = textView22;
        this.tvConditionInfoHeader = textView23;
        this.tvCostOfRepairReport = textView24;
        this.tvCurrentBidAmount = textView25;
        this.tvDealer = textView26;
        this.tvDismantler = textView27;
        this.tvExporter = textView28;
        this.tvFindPartReport = textView29;
        this.tvGradeLbl = textView30;
        this.tvGradeLearn = textView31;
        this.tvIAAConditionReport = textView32;
        this.tvICChangeID = textView33;
        this.tvICDescriptionID = textView34;
        this.tvIaaInteractLearn = textView35;
        this.tvLabelIaaInteract = textView36;
        this.tvLiveSaleValue = textView37;
        this.tvMaxBidValue = textView38;
        this.tvNonAuto = textView39;
        this.tvOtherLicensed = textView40;
        this.tvParts = textView41;
        this.tvPartsError = textView42;
        this.tvPartsID = textView43;
        this.tvPartsLogin = textView44;
        this.tvPremiumVehicleReport = textView45;
        this.tvPublic = textView46;
        this.tvRebuilder = textView47;
        this.tvReserveMetStatus = textView48;
        this.tvSaleInfoLabel = textView49;
        this.tvScrapper = textView50;
        this.tvState = textView51;
        this.tvStatusWarning = textView52;
        this.tvStockNo = textView53;
        this.tvStockValue = textView54;
        this.tvTimedAuctionClosed = textView55;
        this.tvTimedAuctionClosedDate = textView56;
        this.tvTimedBiddingStatus = textView57;
        this.tvTimedCurrentBidValue = textView58;
        this.tvTimedMaxBidValue = textView59;
        this.tvTimedStartingBidValue = textView60;
        this.tvTitleNotAvailable = textView61;
        this.tvVehicleMakeModel = textView62;
        this.tvVehicleReport = textView63;
        this.tvVinDetailLabel = textView64;
        this.tvVinNo = textView65;
        this.tvVinValue = textView66;
        this.tvWarning = textView67;
        this.txtSalesInfoViewMore = textView68;
        this.txtVCCondiViewMore = textView69;
        this.txtVinViewMore = textView70;
        this.txtbiddingInfoViewMore = textView71;
        this.vehicleDetailImgLayout = relativeLayout11;
        this.vehicleImageDownload = imageView29;
        this.vehicleImageListView = linearLayout44;
        this.vinInfoIc = imageView30;
        this.vinPartsInfo = relativeLayout12;
        this.vinPartsLayout = linearLayout45;
        this.vinPartsSeparator = view11;
        this.vinSeparator = view12;
        this.watchSeparator = view13;
        this.whocanbid = linearLayout46;
        this.ymmViewMore = textView72;
        this.ymmViewMoreLayout = linearLayout47;
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
    public static FragmentProductDetailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentProductDetailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (FragmentProductDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_product_detail, viewGroup, z, obj);
    }

    @NonNull
    public static FragmentProductDetailBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static FragmentProductDetailBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (FragmentProductDetailBinding) ViewDataBinding.inflateInternal(layoutInflater, C2723R.C2728layout.fragment_product_detail, (ViewGroup) null, false, obj);
    }

    public static FragmentProductDetailBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentProductDetailBinding bind(@NonNull View view, @Nullable Object obj) {
        return (FragmentProductDetailBinding) bind(obj, view, C2723R.C2728layout.fragment_product_detail);
    }
}
