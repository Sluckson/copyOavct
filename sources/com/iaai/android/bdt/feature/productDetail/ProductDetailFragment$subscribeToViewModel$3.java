package com.iaai.android.bdt.feature.productDetail;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity;
import com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity;
import com.iaai.android.bdt.feature.landing.LandingBRESectionActivity;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingEnum;
import com.iaai.android.bdt.model.productDetail.biddingInfo.BiddingInformation;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ImageInformation;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ProductDetailResponse;
import com.iaai.android.bdt.model.productDetail.biddingInfo.SaleInfo;
import com.iaai.android.bdt.model.productDetail.biddingInfo.SaleInformation;
import com.iaai.android.bdt.model.productDetail.biddingInfo.VinDetails;
import com.iaai.android.bdt.model.productDetail.prebid.PrebidInformation;
import com.iaai.android.bdt.utils.NewDateHelper;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.IAASharedPreference;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ProductDetailResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$subscribeToViewModel$3<T> implements Observer<ProductDetailResponse> {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$subscribeToViewModel$3(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onChanged(ProductDetailResponse productDetailResponse) {
        Context context;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        SaleInformation saleInformation;
        SaleInfo saleInfo;
        SaleInformation saleInformation2;
        SaleInfo saleInfo2;
        PrebidInformation prebidInformation;
        String adjustedCloseDate;
        SaleInformation saleInformation3;
        VinDetails vinDetails;
        SaleInformation saleInformation4;
        SaleInfo saleInfo3;
        VinDetails vinDetails2;
        ImageInformation imageInformation;
        String engineVideo;
        ImageInformation imageInformation2;
        String tireTreadUrl;
        ImageInformation imageInformation3;
        String keyImage;
        VinDetails vinDetails3;
        VinDetails vinDetails4;
        PrebidInformation prebidInformation2;
        PrebidInformation prebidInformation3;
        PrebidInformation prebidInformation4;
        PrebidInformation prebidInformation5;
        String myCurrent;
        PrebidInformation prebidInformation6;
        SaleInformation saleInformation5;
        SaleInformation saleInformation6;
        SaleInformation saleInformation7;
        SaleInfo saleInfo4;
        SaleInformation saleInformation8;
        SaleInformation saleInformation9;
        BiddingInformation biddingInformation;
        BiddingInformation biddingInformation2;
        BiddingInformation biddingInformation3;
        VinDetails vinDetails5;
        SaleInformation saleInformation10;
        if (this.this$0.isAdded() && this.this$0.isViewAvalibale) {
            String str9 = "";
            if (this.this$0.getResources().getBoolean(C2723R.bool.isTabletPhone)) {
                if (!Intrinsics.areEqual((Object) this.this$0.itemId, (Object) str9)) {
                    this.this$0.initializeShareForTablet(true);
                } else {
                    this.this$0.initializeShareForTablet(false);
                }
            }
            Integer num = null;
            if (!this.this$0.checkUserValidAndBidBuyClick(productDetailResponse != null ? productDetailResponse.getPrebidInformation() : null)) {
                this.this$0.tboInd = (productDetailResponse == null || (saleInformation10 = productDetailResponse.getSaleInformation()) == null) ? false : saleInformation10.getTBOInd();
                if (this.this$0.tboInd) {
                    TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvTitleNotAvailable);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "tvTitleNotAvailable");
                    textView.setVisibility(0);
                } else {
                    TextView textView2 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvTitleNotAvailable);
                    Intrinsics.checkExpressionValueIsNotNull(textView2, "tvTitleNotAvailable");
                    textView2.setVisibility(8);
                }
                ProductDetailFragment productDetailFragment = this.this$0;
                BiddingInformation biddingInformation4 = productDetailResponse != null ? productDetailResponse.getBiddingInformation() : null;
                if (productDetailResponse == null || (vinDetails5 = productDetailResponse.getVinDetails()) == null || (str = vinDetails5.getSeries()) == null) {
                    str = str9;
                }
                productDetailFragment.updateBiddingInfo(biddingInformation4, str);
                ProductDetailFragment productDetailFragment2 = this.this$0;
                if (productDetailResponse == null || (biddingInformation3 = productDetailResponse.getBiddingInformation()) == null || (str2 = biddingInformation3.getYear()) == null) {
                    str2 = str9;
                }
                productDetailFragment2.year = str2;
                ProductDetailFragment productDetailFragment3 = this.this$0;
                if (productDetailResponse == null || (biddingInformation2 = productDetailResponse.getBiddingInformation()) == null || (str3 = biddingInformation2.getMake()) == null) {
                    str3 = str9;
                }
                productDetailFragment3.make = str3;
                ProductDetailFragment productDetailFragment4 = this.this$0;
                if (productDetailResponse == null || (biddingInformation = productDetailResponse.getBiddingInformation()) == null || (str4 = biddingInformation.getModel()) == null) {
                    str4 = str9;
                }
                productDetailFragment4.model = str4;
                this.this$0.saleInformation = productDetailResponse != null ? productDetailResponse.getSaleInformation() : null;
                this.this$0.branchCode = String.valueOf((productDetailResponse == null || (saleInformation9 = productDetailResponse.getSaleInformation()) == null) ? null : Integer.valueOf(saleInformation9.getBranchCode()));
                this.this$0.zip = String.valueOf((productDetailResponse == null || (saleInformation8 = productDetailResponse.getSaleInformation()) == null) ? null : saleInformation8.getZip());
                ProductDetailFragment productDetailFragment5 = this.this$0;
                if (productDetailResponse == null || (saleInformation7 = productDetailResponse.getSaleInformation()) == null || (saleInfo4 = saleInformation7.getSaleInfo()) == null || (str5 = saleInfo4.getConditionReport()) == null) {
                    str5 = str9;
                }
                productDetailFragment5.conditionReport = str5;
                ProductDetailFragment productDetailFragment6 = this.this$0;
                if (productDetailResponse == null || (saleInformation6 = productDetailResponse.getSaleInformation()) == null || (str6 = saleInformation6.getLiveDateString()) == null) {
                    str6 = str9;
                }
                productDetailFragment6.liveDateString = str6;
                ProductDetailFragment productDetailFragment7 = this.this$0;
                if (productDetailResponse == null || (saleInformation5 = productDetailResponse.getSaleInformation()) == null || (str7 = saleInformation5.getUserTimezoneAbb()) == null) {
                    str7 = str9;
                }
                productDetailFragment7.userTimezoneAbb = str7;
                this.this$0.startingBid = (productDetailResponse == null || (prebidInformation6 = productDetailResponse.getPrebidInformation()) == null) ? null : Integer.valueOf(prebidInformation6.getStartBid());
                this.this$0.currentBid = (productDetailResponse == null || (prebidInformation5 = productDetailResponse.getPrebidInformation()) == null || (myCurrent = prebidInformation5.getMyCurrent()) == null) ? 0.0f : Float.parseFloat(myCurrent);
                this.this$0.isTransportationQuotesAvailable = (productDetailResponse == null || (prebidInformation4 = productDetailResponse.getPrebidInformation()) == null) ? false : prebidInformation4.isTransportationQuotesAvailable();
                this.this$0.preBidErrorMsg = (productDetailResponse == null || (prebidInformation3 = productDetailResponse.getPrebidInformation()) == null) ? null : prebidInformation3.getPrebidPopupErrorMessage();
                ProductDetailFragment productDetailFragment8 = this.this$0;
                if (productDetailResponse == null || (prebidInformation2 = productDetailResponse.getPrebidInformation()) == null || (str8 = prebidInformation2.getVehicleStatus()) == null) {
                    str8 = str9;
                }
                productDetailFragment8.vehicleStatus = str8;
                if (this.this$0.totalCount == 1) {
                    BaseActivity access$getBaseActivity$p = this.this$0.baseActivity;
                    if (access$getBaseActivity$p instanceof SearchResultActivity) {
                        BaseActivity access$getBaseActivity$p2 = this.this$0.baseActivity;
                        if (access$getBaseActivity$p2 != null) {
                            TextView toolbar_title = ((SearchResultActivity) access$getBaseActivity$p2).getToolbar_title();
                            toolbar_title.setText(this.this$0.year + ' ' + this.this$0.make + ' ' + this.this$0.model);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.findVehiclePage.searchResult.SearchResultActivity");
                        }
                    } else if (access$getBaseActivity$p instanceof RefinerResultActivity) {
                        BaseActivity access$getBaseActivity$p3 = this.this$0.baseActivity;
                        if (access$getBaseActivity$p3 != null) {
                            TextView toolbarTitle = ((RefinerResultActivity) access$getBaseActivity$p3).getToolbarTitle();
                            toolbarTitle.setText(this.this$0.year + ' ' + this.this$0.make + ' ' + this.this$0.model);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.fastSearchFilter.refinerResults.RefinerResultActivity");
                        }
                    } else if (access$getBaseActivity$p instanceof LandingBRESectionActivity) {
                        BaseActivity access$getBaseActivity$p4 = this.this$0.baseActivity;
                        if (access$getBaseActivity$p4 != null) {
                            TextView toolbarTitle2 = ((LandingBRESectionActivity) access$getBaseActivity$p4).getToolbarTitle();
                            toolbarTitle2.setText(this.this$0.year + ' ' + this.this$0.make + ' ' + this.this$0.model);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.bdt.feature.landing.LandingBRESectionActivity");
                        }
                    }
                }
                BaseActivity access$getBaseActivity$p5 = this.this$0.baseActivity;
                if (access$getBaseActivity$p5 == null) {
                    Intrinsics.throwNpe();
                }
                Application application = access$getBaseActivity$p5.getApplication();
                Intrinsics.checkExpressionValueIsNotNull(application, "baseActivity!!.application");
                Boolean salesInfoViewLessPreferencesMVVM = IAASharedPreference.getSalesInfoViewLessPreferencesMVVM(application.getApplicationContext());
                Intrinsics.checkExpressionValueIsNotNull(salesInfoViewLessPreferencesMVVM, "IAASharedPreference.getS…ation.applicationContext)");
                if (salesInfoViewLessPreferencesMVVM.booleanValue()) {
                    TextView textView3 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.txtSalesInfoViewMore);
                    Intrinsics.checkExpressionValueIsNotNull(textView3, "txtSalesInfoViewMore");
                    textView3.setText(this.this$0.getString(C2723R.string.lbl_view_less));
                    ((ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ic_sales_view_more)).setImageDrawable(this.this$0.getResources().getDrawable(C2723R.C2725drawable.ic_view_up));
                    this.this$0.updateSaleInfo(0);
                } else {
                    TextView textView4 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.txtSalesInfoViewMore);
                    Intrinsics.checkExpressionValueIsNotNull(textView4, "txtSalesInfoViewMore");
                    textView4.setText(this.this$0.getString(C2723R.string.lbl_view_more));
                    ((ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ic_sales_view_more)).setImageDrawable(this.this$0.getResources().getDrawable(C2723R.C2725drawable.ic_view_down));
                    this.this$0.updateSaleInfo(8);
                }
                this.this$0.isPartsIndicator = (productDetailResponse == null || (vinDetails4 = productDetailResponse.getVinDetails()) == null) ? false : vinDetails4.getPartsIndicator();
                this.this$0.chromeIndicator = (productDetailResponse == null || (vinDetails3 = productDetailResponse.getVinDetails()) == null) ? false : vinDetails3.getChromeIndicator();
                if (this.this$0.isPartsIndicator) {
                    LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.vin_parts_layout);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout, "vin_parts_layout");
                    linearLayout.setVisibility(0);
                    View _$_findCachedViewById = this.this$0._$_findCachedViewById(C2723R.C2726id.vinPartsSeparator);
                    Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "vinPartsSeparator");
                    _$_findCachedViewById.setVisibility(0);
                } else {
                    LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.vin_parts_layout);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "vin_parts_layout");
                    linearLayout2.setVisibility(8);
                    View _$_findCachedViewById2 = this.this$0._$_findCachedViewById(C2723R.C2726id.vinPartsSeparator);
                    Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "vinPartsSeparator");
                    _$_findCachedViewById2.setVisibility(8);
                }
                if (!(productDetailResponse == null || (imageInformation3 = productDetailResponse.getImageInformation()) == null || (keyImage = imageInformation3.getKeyImage()) == null)) {
                    if (keyImage.length() > 0) {
                        this.this$0.keyIndex = Utils.getKeyIndex(productDetailResponse.getImageInformation().getKeyImage(), productDetailResponse.getImageInformation().getImages());
                        this.this$0.isKeyImagePresent = true;
                    }
                }
                if (!(productDetailResponse == null || (imageInformation2 = productDetailResponse.getImageInformation()) == null || (tireTreadUrl = imageInformation2.getTireTreadUrl()) == null)) {
                    if (tireTreadUrl.length() > 0) {
                        this.this$0.tireIndex = Utils.getKeyIndex(productDetailResponse.getImageInformation().getTireTreadUrl(), productDetailResponse.getImageInformation().getImages());
                    }
                }
                if (!(productDetailResponse == null || (imageInformation = productDetailResponse.getImageInformation()) == null || (engineVideo = imageInformation.getEngineVideo()) == null)) {
                    if (engineVideo.length() > 0) {
                        this.this$0.engineURL = productDetailResponse.getImageInformation().getEngineVideo();
                        this.this$0.isEngineVideoPresent = true;
                    }
                }
                this.this$0.loadVehicleGradeInformation(productDetailResponse != null ? productDetailResponse.getVehicleGradeInformation() : null);
                this.this$0.updateVINInfo(productDetailResponse != null ? productDetailResponse.getVinDetails() : null);
                this.this$0.vin = String.valueOf((productDetailResponse == null || (vinDetails2 = productDetailResponse.getVinDetails()) == null) ? null : vinDetails2.getVIN());
                this.this$0.updateStockAndVinNumber((productDetailResponse == null || (saleInformation4 = productDetailResponse.getSaleInformation()) == null || (saleInfo3 = saleInformation4.getSaleInfo()) == null) ? null : saleInfo3.getStockNumber(), (productDetailResponse == null || (vinDetails = productDetailResponse.getVinDetails()) == null) ? null : vinDetails.getVIN());
                TextView textView5 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvState);
                Intrinsics.checkExpressionValueIsNotNull(textView5, "tvState");
                textView5.setText((productDetailResponse == null || (saleInformation3 = productDetailResponse.getSaleInformation()) == null) ? null : saleInformation3.getBranchLink());
                this.this$0.loadConditionInfo(productDetailResponse != null ? productDetailResponse.getConditionInformation() : null, productDetailResponse != null ? productDetailResponse.getConditionReports() : null);
                if (this.this$0.isAuctionCompleted(productDetailResponse != null ? productDetailResponse.getPrebidInformation() : null)) {
                    LinearLayout linearLayout3 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llWatchLayout);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llWatchLayout");
                    linearLayout3.setVisibility(8);
                    LinearLayout linearLayout4 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llUnWatchLayout);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "llUnWatchLayout");
                    linearLayout4.setVisibility(8);
                    View _$_findCachedViewById3 = this.this$0._$_findCachedViewById(C2723R.C2726id.watchSeparator);
                    Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById3, "watchSeparator");
                    _$_findCachedViewById3.setVisibility(8);
                    View _$_findCachedViewById4 = this.this$0._$_findCachedViewById(C2723R.C2726id.costSeparator);
                    Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById4, "costSeparator");
                    _$_findCachedViewById4.setVisibility(8);
                    LinearLayout linearLayout5 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llCostCalculator);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout5, "llCostCalculator");
                    linearLayout5.setVisibility(8);
                    View _$_findCachedViewById5 = this.this$0._$_findCachedViewById(C2723R.C2726id.preBidSeparator);
                    Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById5, "preBidSeparator");
                    _$_findCachedViewById5.setVisibility(8);
                    CardView cardView = (CardView) this.this$0._$_findCachedViewById(C2723R.C2726id.cvAuctionCmplete);
                    Intrinsics.checkExpressionValueIsNotNull(cardView, "cvAuctionCmplete");
                    cardView.setVisibility(0);
                    TextView textView6 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvTimedAuctionClosedDate);
                    Intrinsics.checkExpressionValueIsNotNull(textView6, "tvTimedAuctionClosedDate");
                    NewDateHelper newDateHelper = NewDateHelper.INSTANCE;
                    if (!(productDetailResponse == null || (prebidInformation = productDetailResponse.getPrebidInformation()) == null || (adjustedCloseDate = prebidInformation.getAdjustedCloseDate()) == null)) {
                        str9 = adjustedCloseDate;
                    }
                    textView6.setText(newDateHelper.getAuctionCompleteTime(str9));
                    TextView textView7 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_auction_completed_stock_not_available);
                    Intrinsics.checkExpressionValueIsNotNull(textView7, "tv_auction_completed_stock_not_available");
                    textView7.setVisibility(0);
                    TextView textView8 = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_auction_completed_stock_not_available);
                    Intrinsics.checkExpressionValueIsNotNull(textView8, "tv_auction_completed_stock_not_available");
                    ProductDetailFragment productDetailFragment9 = this.this$0;
                    Object[] objArr = new Object[1];
                    objArr[0] = (productDetailResponse == null || (saleInformation2 = productDetailResponse.getSaleInformation()) == null || (saleInfo2 = saleInformation2.getSaleInfo()) == null) ? null : saleInfo2.getStockNumber();
                    textView8.setText(productDetailFragment9.getString(C2723R.string.bdt_auction_completed_stock_message, objArr));
                } else {
                    CardView cardView2 = (CardView) this.this$0._$_findCachedViewById(C2723R.C2726id.cvAuctionCmplete);
                    Intrinsics.checkExpressionValueIsNotNull(cardView2, "cvAuctionCmplete");
                    cardView2.setVisibility(8);
                    this.this$0.updatePreBidActionArea(productDetailResponse != null ? productDetailResponse.getPrebidInformation() : null);
                }
                ProductDetailFragment productDetailFragment10 = this.this$0;
                if (!(productDetailResponse == null || (saleInformation = productDetailResponse.getSaleInformation()) == null || (saleInfo = saleInformation.getSaleInfo()) == null)) {
                    num = Integer.valueOf(saleInfo.getSalvageID());
                }
                productDetailFragment10.salvageId = num;
                if (this.this$0.getUserVisibleHint()) {
                    this.this$0.setUpShareButtonClick();
                }
            } else {
                return;
            }
        }
        Boolean isFirstLaunchForProductDetail = IAASharedPreference.getIsFirstLaunchForProductDetail(this.this$0.baseActivity);
        Boolean isFirstLaunchForEngineVideoProductDetail = IAASharedPreference.getIsFirstLaunchForEngineVideoProductDetail(this.this$0.baseActivity);
        if (this.this$0.isEngineVideoPresent) {
            Intrinsics.checkExpressionValueIsNotNull(isFirstLaunchForEngineVideoProductDetail, "isFirstLaunchEngineVideo");
            if (!isFirstLaunchForEngineVideoProductDetail.booleanValue()) {
                return;
            }
            if (!isFirstLaunchForProductDetail.booleanValue()) {
                Context context2 = this.this$0.getContext();
                if (context2 != null) {
                    Context_ExtensionKt.launchOnBoardingScreen(context2, OnBoardingEnum.ENGINE_VIDEO_ONLY);
                    return;
                }
                return;
            }
            Context context3 = this.this$0.getContext();
            if (context3 != null) {
                Context_ExtensionKt.launchOnBoardingScreen(context3, OnBoardingEnum.ENGINE_VIDEO_WITH_ALL_SCREEN);
                return;
            }
            return;
        }
        Intrinsics.checkExpressionValueIsNotNull(isFirstLaunchForProductDetail, "isFirstLaunch");
        if (isFirstLaunchForProductDetail.booleanValue() && (context = this.this$0.getContext()) != null) {
            Context_ExtensionKt.launchOnBoardingScreen(context, OnBoardingEnum.PRODUCT_DETAIL);
        }
    }
}
