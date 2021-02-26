package com.iaai.android.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import com.google.android.exoplayer2.extractor.p008ts.TsExtractor;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.feature.productDetail.ProductDetailViewModel;
import com.iaai.android.bdt.model.productDetail.biddingInfo.BiddingInformation;
import repack.org.bouncycastle.crypto.tls.CipherSuite;

public class FragmentProductDetailBindingImpl extends FragmentProductDetailBinding {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    @Nullable
    private static final SparseIntArray sViewsWithIds = new SparseIntArray();
    private long mDirtyFlags;
    @NonNull
    private final LinearLayout mboundView0;
    @NonNull
    private final FrameLayout mboundView1;

    /* access modifiers changed from: protected */
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    static {
        sViewsWithIds.put(C2723R.C2726id.layout_ukcan, 4);
        sViewsWithIds.put(C2723R.C2726id.layoutBidLive, 5);
        sViewsWithIds.put(C2723R.C2726id.svDataContainer, 6);
        sViewsWithIds.put(C2723R.C2726id.layout_US_product_detail_container, 7);
        sViewsWithIds.put(C2723R.C2726id.tv_auction_completed_stock_not_available, 8);
        sViewsWithIds.put(C2723R.C2726id.product_dtl_header, 9);
        sViewsWithIds.put(C2723R.C2726id.section_vehicle_image_icon, 10);
        sViewsWithIds.put(C2723R.C2726id.cvVehicleImages, 11);
        sViewsWithIds.put(C2723R.C2726id.ivEnginePlayOverlay, 12);
        sViewsWithIds.put(C2723R.C2726id.horizontal_scrollview_refiners, 13);
        sViewsWithIds.put(C2723R.C2726id.llImages, 14);
        sViewsWithIds.put(C2723R.C2726id.iv360Image, 15);
        sViewsWithIds.put(C2723R.C2726id.tv_360, 16);
        sViewsWithIds.put(C2723R.C2726id.ivHdImage, 17);
        sViewsWithIds.put(C2723R.C2726id.ivEngineVideo, 18);
        sViewsWithIds.put(C2723R.C2726id.ivKey, 19);
        sViewsWithIds.put(C2723R.C2726id.ivTireTread, 20);
        sViewsWithIds.put(C2723R.C2726id.vehicleImageListView, 21);
        sViewsWithIds.put(C2723R.C2726id.llImageDownload, 22);
        sViewsWithIds.put(C2723R.C2726id.vehicleImageDownload, 23);
        sViewsWithIds.put(C2723R.C2726id.vehicle_detail_img_layout, 24);
        sViewsWithIds.put(C2723R.C2726id.tvVehicleMakeModel, 25);
        sViewsWithIds.put(C2723R.C2726id.tvStockNo, 26);
        sViewsWithIds.put(C2723R.C2726id.tvStockValue, 27);
        sViewsWithIds.put(C2723R.C2726id.tvVinNo, 28);
        sViewsWithIds.put(C2723R.C2726id.tvVinValue, 29);
        sViewsWithIds.put(C2723R.C2726id.tvState, 30);
        sViewsWithIds.put(C2723R.C2726id.tvTitleNotAvailable, 31);
        sViewsWithIds.put(C2723R.C2726id.ymmViewMoreLayout, 32);
        sViewsWithIds.put(C2723R.C2726id.ymmViewMore, 33);
        sViewsWithIds.put(C2723R.C2726id.ic_ymm_view_more, 34);
        sViewsWithIds.put(C2723R.C2726id.cvAuctionCmplete, 35);
        sViewsWithIds.put(C2723R.C2726id.tvTimedAuctionClosed, 36);
        sViewsWithIds.put(C2723R.C2726id.tvTimedAuctionClosedDate, 37);
        sViewsWithIds.put(C2723R.C2726id.cvPreBidBuy, 38);
        sViewsWithIds.put(C2723R.C2726id.rlSection, 39);
        sViewsWithIds.put(C2723R.C2726id.llBuyNowSold, 40);
        sViewsWithIds.put(C2723R.C2726id.tvBuyNowSold, 41);
        sViewsWithIds.put(C2723R.C2726id.tvBuyNowSoldMessage, 42);
        sViewsWithIds.put(C2723R.C2726id.tvAuctionNotAssigned, 43);
        sViewsWithIds.put(C2723R.C2726id.auctionNotAssignSeparator, 44);
        sViewsWithIds.put(C2723R.C2726id.llBidSection, 45);
        sViewsWithIds.put(C2723R.C2726id.rlYouCanBuy, 46);
        sViewsWithIds.put(C2723R.C2726id.ivColorIcon, 47);
        sViewsWithIds.put(C2723R.C2726id.tvBidStatusTitle, 48);
        sViewsWithIds.put(C2723R.C2726id.bidding_ViewMore, 49);
        sViewsWithIds.put(C2723R.C2726id.txtbiddingInfoViewMore, 50);
        sViewsWithIds.put(C2723R.C2726id.ic_bidding_view_more, 51);
        sViewsWithIds.put(C2723R.C2726id.tvBidStatusSubTitle, 52);
        sViewsWithIds.put(C2723R.C2726id.whocanbid, 53);
        sViewsWithIds.put(C2723R.C2726id.tvStatusWarning, 54);
        sViewsWithIds.put(C2723R.C2726id.empty_view, 55);
        sViewsWithIds.put(C2723R.C2726id.pre_bid_closed, 56);
        sViewsWithIds.put(C2723R.C2726id.join_now, 57);
        sViewsWithIds.put(C2723R.C2726id.tv_can_bid, 58);
        sViewsWithIds.put(C2723R.C2726id.img_public, 59);
        sViewsWithIds.put(C2723R.C2726id.tv_public, 60);
        sViewsWithIds.put(C2723R.C2726id.img_dealer, 61);
        sViewsWithIds.put(C2723R.C2726id.tv_dealer, 62);
        sViewsWithIds.put(C2723R.C2726id.img_dismantler, 63);
        sViewsWithIds.put(C2723R.C2726id.tv_dismantler, 64);
        sViewsWithIds.put(C2723R.C2726id.img_rebuilder, 65);
        sViewsWithIds.put(C2723R.C2726id.tv_rebuilder, 66);
        sViewsWithIds.put(C2723R.C2726id.img_scrapper, 67);
        sViewsWithIds.put(C2723R.C2726id.tv_scrapper, 68);
        sViewsWithIds.put(C2723R.C2726id.img_exporter, 69);
        sViewsWithIds.put(C2723R.C2726id.tv_exporter, 70);
        sViewsWithIds.put(C2723R.C2726id.img_other_licensed, 71);
        sViewsWithIds.put(C2723R.C2726id.tv_other_licensed, 72);
        sViewsWithIds.put(C2723R.C2726id.img_non_auto, 73);
        sViewsWithIds.put(C2723R.C2726id.tv_non_auto, 74);
        sViewsWithIds.put(C2723R.C2726id.bidding_notes_pre_bid, 75);
        sViewsWithIds.put(C2723R.C2726id.llBidBuyInd, 76);
        sViewsWithIds.put(C2723R.C2726id.bidBuyInd, 77);
        sViewsWithIds.put(C2723R.C2726id.bidBuyWarning, 78);
        sViewsWithIds.put(C2723R.C2726id.llSalesTaxInd, 79);
        sViewsWithIds.put(C2723R.C2726id.salesTaxInd, 80);
        sViewsWithIds.put(C2723R.C2726id.SalesTextWarning, 81);
        sViewsWithIds.put(C2723R.C2726id.preBidSeparator, 82);
        sViewsWithIds.put(C2723R.C2726id.llPreBidSection, 83);
        sViewsWithIds.put(C2723R.C2726id.llCurrentBid, 84);
        sViewsWithIds.put(C2723R.C2726id.tvCurrentBidAmount, 85);
        sViewsWithIds.put(C2723R.C2726id.tvBiddingStatus, 86);
        sViewsWithIds.put(C2723R.C2726id.btnPreBid, 87);
        sViewsWithIds.put(C2723R.C2726id.llMaxBid, 88);
        sViewsWithIds.put(C2723R.C2726id.tvMaxBidValue, 89);
        sViewsWithIds.put(C2723R.C2726id.llBuyNowSection, 90);
        sViewsWithIds.put(C2723R.C2726id.llBuyPrice, 91);
        sViewsWithIds.put(C2723R.C2726id.tvBuyPriceValue, 92);
        sViewsWithIds.put(C2723R.C2726id.btnBuyNow, 93);
        sViewsWithIds.put(C2723R.C2726id.llTimedAuctionSection, 94);
        sViewsWithIds.put(C2723R.C2726id.tvLiveSaleValue, 95);
        sViewsWithIds.put(C2723R.C2726id.tvClosingTimeValue, 96);
        sViewsWithIds.put(C2723R.C2726id.btnTimedBid, 97);
        sViewsWithIds.put(C2723R.C2726id.tvTimedCurrentBidValue, 98);
        sViewsWithIds.put(C2723R.C2726id.llTimedAuctionStartBid, 99);
        sViewsWithIds.put(C2723R.C2726id.tvTimedStartingBidValue, 100);
        sViewsWithIds.put(C2723R.C2726id.llTimedBidStatus, 101);
        sViewsWithIds.put(C2723R.C2726id.tvTimedBiddingStatus, 102);
        sViewsWithIds.put(C2723R.C2726id.tvReserveMetStatus, 103);
        sViewsWithIds.put(C2723R.C2726id.llTimedMaxBid, 104);
        sViewsWithIds.put(C2723R.C2726id.tvTimedMaxBidValue, 105);
        sViewsWithIds.put(C2723R.C2726id.watchSeparator, 106);
        sViewsWithIds.put(C2723R.C2726id.rlWatchUnWatch, 107);
        sViewsWithIds.put(C2723R.C2726id.llWatchLayout, 108);
        sViewsWithIds.put(C2723R.C2726id.ic_watch, 109);
        sViewsWithIds.put(C2723R.C2726id.llUnWatchLayout, 110);
        sViewsWithIds.put(C2723R.C2726id.ic_unwatch, 111);
        sViewsWithIds.put(C2723R.C2726id.costSeparator, 112);
        sViewsWithIds.put(C2723R.C2726id.llCostCalculator, 113);
        sViewsWithIds.put(C2723R.C2726id.llEstimatedCostValue, 114);
        sViewsWithIds.put(C2723R.C2726id.estimateFinalCost, 115);
        sViewsWithIds.put(C2723R.C2726id.estimateBid, 116);
        sViewsWithIds.put(C2723R.C2726id.btnEdit, 117);
        sViewsWithIds.put(C2723R.C2726id.tv_warning, 118);
        sViewsWithIds.put(C2723R.C2726id.cvIaaInteractInfo, 119);
        sViewsWithIds.put(C2723R.C2726id.tvLabelIaaInteract, 120);
        sViewsWithIds.put(C2723R.C2726id.iaa_interact_learn_more, 121);
        sViewsWithIds.put(C2723R.C2726id.tvIaaInteractLearn, 122);
        sViewsWithIds.put(C2723R.C2726id.iv_arrow_iaa_interact, 123);
        sViewsWithIds.put(C2723R.C2726id.cvConditionInfo, 124);
        sViewsWithIds.put(C2723R.C2726id.conditionInfo, 125);
        sViewsWithIds.put(C2723R.C2726id.condition_info_ic, 126);
        sViewsWithIds.put(C2723R.C2726id.tvConditionInfoHeader, 127);
        sViewsWithIds.put(C2723R.C2726id.ivConditionToolTip, 128);
        sViewsWithIds.put(C2723R.C2726id.rlGradeContainer, 129);
        sViewsWithIds.put(C2723R.C2726id.llGradeContainer, TsExtractor.TS_STREAM_TYPE_HDMV_DTS);
        sViewsWithIds.put(C2723R.C2726id.tvGradeLbl, 131);
        sViewsWithIds.put(C2723R.C2726id.tvGradeLearn, 132);
        sViewsWithIds.put(C2723R.C2726id.iv_arrowMore, 133);
        sViewsWithIds.put(C2723R.C2726id.flTubeSpeed, TsExtractor.TS_STREAM_TYPE_SPLICE_INFO);
        sViewsWithIds.put(C2723R.C2726id.tubeSpeedometer, 135);
        sViewsWithIds.put(C2723R.C2726id.f476tv, 136);
        sViewsWithIds.put(C2723R.C2726id.separatorGrade, 137);
        sViewsWithIds.put(C2723R.C2726id.rvCondition, 138);
        sViewsWithIds.put(C2723R.C2726id.rvConditionInfo, CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA);
        sViewsWithIds.put(C2723R.C2726id.separator, CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA);
        sViewsWithIds.put(C2723R.C2726id.rl_vehicle_report, CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA);
        sViewsWithIds.put(C2723R.C2726id.rl_premium_vehicle_report, CipherSuite.TLS_DHE_PSK_WITH_RC4_128_SHA);
        sViewsWithIds.put(C2723R.C2726id.premium_vehicle_ic, CipherSuite.TLS_DHE_PSK_WITH_3DES_EDE_CBC_SHA);
        sViewsWithIds.put(C2723R.C2726id.tv_vehicle_report, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA);
        sViewsWithIds.put(C2723R.C2726id.llPremiumVehicleReport, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA);
        sViewsWithIds.put(C2723R.C2726id.tvPremiumVehicleReport, CipherSuite.TLS_RSA_PSK_WITH_RC4_128_SHA);
        sViewsWithIds.put(C2723R.C2726id.ic_arrow, CipherSuite.TLS_RSA_PSK_WITH_3DES_EDE_CBC_SHA);
        sViewsWithIds.put(C2723R.C2726id.tvIAAConditionReport, CipherSuite.TLS_RSA_PSK_WITH_AES_128_CBC_SHA);
        sViewsWithIds.put(C2723R.C2726id.tvCostOfRepairReport, CipherSuite.TLS_RSA_PSK_WITH_AES_256_CBC_SHA);
        sViewsWithIds.put(C2723R.C2726id.tvFindPartReport, 150);
        sViewsWithIds.put(C2723R.C2726id.condition_viewMore, 151);
        sViewsWithIds.put(C2723R.C2726id.txtVCCondiViewMore, 152);
        sViewsWithIds.put(C2723R.C2726id.ic_VCcondition_view_more, 153);
        sViewsWithIds.put(C2723R.C2726id.card_view_sale_info, 154);
        sViewsWithIds.put(C2723R.C2726id.saleInfo, 155);
        sViewsWithIds.put(C2723R.C2726id.sales_info_ic, 156);
        sViewsWithIds.put(C2723R.C2726id.tv_sale_info_label, 157);
        sViewsWithIds.put(C2723R.C2726id.iv_sale_info_tip, 158);
        sViewsWithIds.put(C2723R.C2726id.llSalesInfo, 159);
        sViewsWithIds.put(C2723R.C2726id.salesSeparator, 160);
        sViewsWithIds.put(C2723R.C2726id.salesInfoViewMore, 161);
        sViewsWithIds.put(C2723R.C2726id.txtSalesInfoViewMore, 162);
        sViewsWithIds.put(C2723R.C2726id.ic_sales_view_more, 163);
        sViewsWithIds.put(C2723R.C2726id.llParts, 164);
        sViewsWithIds.put(C2723R.C2726id.card_view_vin_detail, 165);
        sViewsWithIds.put(C2723R.C2726id.vinPartsInfo, 166);
        sViewsWithIds.put(C2723R.C2726id.vin_info_ic, 167);
        sViewsWithIds.put(C2723R.C2726id.tv_vin_detail_label, 168);
        sViewsWithIds.put(C2723R.C2726id.iv_vin_tool_tip, 169);
        sViewsWithIds.put(C2723R.C2726id.vin_parts_layout, 170);
        sViewsWithIds.put(C2723R.C2726id.btn_Vehicle, 171);
        sViewsWithIds.put(C2723R.C2726id.tv_parts, TsExtractor.TS_STREAM_TYPE_AC4);
        sViewsWithIds.put(C2723R.C2726id.vinPartsSeparator, 173);
        sViewsWithIds.put(C2723R.C2726id.rl_vinParts, 174);
        sViewsWithIds.put(C2723R.C2726id.rvVinDetails, 175);
        sViewsWithIds.put(C2723R.C2726id.rvVinDetailsInfo, 176);
        sViewsWithIds.put(C2723R.C2726id.rvPartsDetails, 177);
        sViewsWithIds.put(C2723R.C2726id.tv_parts_error, 178);
        sViewsWithIds.put(C2723R.C2726id.ll_part_header, 179);
        sViewsWithIds.put(C2723R.C2726id.tvPartsID, 180);
        sViewsWithIds.put(C2723R.C2726id.tvICChangeID, 181);
        sViewsWithIds.put(C2723R.C2726id.tvICDescriptionID, 182);
        sViewsWithIds.put(C2723R.C2726id.Separator, 183);
        sViewsWithIds.put(C2723R.C2726id.rvPartDetails, 184);
        sViewsWithIds.put(C2723R.C2726id.rvPartsDetailsInfo, 185);
        sViewsWithIds.put(C2723R.C2726id.btnChromeData, 186);
        sViewsWithIds.put(C2723R.C2726id.vinSeparator, 187);
        sViewsWithIds.put(C2723R.C2726id.VinViewMore, 188);
        sViewsWithIds.put(C2723R.C2726id.txtVinViewMore, PsExtractor.PRIVATE_STREAM_1);
        sViewsWithIds.put(C2723R.C2726id.ic_vin_view_more, 190);
        sViewsWithIds.put(C2723R.C2726id.rvPartsLogin, 191);
        sViewsWithIds.put(C2723R.C2726id.tv_parts_login, PsExtractor.AUDIO_STREAM);
        sViewsWithIds.put(C2723R.C2726id.pbLoading, 193);
    }

    public FragmentProductDetailBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 194, sIncludes, sViewsWithIds));
    }

    private FragmentProductDetailBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, objArr[81], objArr[183], objArr[188], objArr[44], objArr[77], objArr[78], objArr[75], objArr[49], objArr[93], objArr[186], objArr[117], objArr[87], objArr[97], objArr[171], objArr[154], objArr[165], objArr[125], objArr[126], objArr[151], objArr[112], objArr[35], objArr[124], objArr[119], objArr[38], objArr[11], objArr[55], objArr[116], objArr[115], objArr[134], objArr[13], objArr[121], objArr[147], objArr[51], objArr[163], objArr[111], objArr[153], objArr[190], objArr[109], objArr[34], objArr[61], objArr[63], objArr[69], objArr[73], objArr[71], objArr[59], objArr[65], objArr[67], objArr[15], objArr[123], objArr[133], objArr[47], objArr[128], objArr[12], objArr[18], objArr[17], objArr[19], objArr[158], objArr[20], objArr[169], objArr[57], objArr[5], objArr[2], objArr[7], objArr[4], objArr[76], objArr[45], objArr[90], objArr[40], objArr[91], objArr[113], objArr[84], objArr[114], objArr[130], objArr[22], objArr[14], objArr[88], objArr[179], objArr[164], objArr[83], objArr[145], objArr[159], objArr[79], objArr[94], objArr[99], objArr[101], objArr[104], objArr[110], objArr[108], objArr[193], objArr[56], objArr[82], objArr[3], objArr[143], objArr[9], objArr[129], objArr[142], objArr[39], objArr[141], objArr[174], objArr[107], objArr[46], objArr[138], objArr[139], objArr[184], objArr[177], objArr[185], objArr[191], objArr[175], objArr[176], objArr[155], objArr[156], objArr[161], objArr[160], objArr[80], objArr[10], objArr[140], objArr[137], objArr[6], objArr[135], objArr[136], objArr[16], objArr[8], objArr[43], objArr[52], objArr[48], objArr[86], objArr[41], objArr[42], objArr[92], objArr[58], objArr[96], objArr[127], objArr[149], objArr[85], objArr[62], objArr[64], objArr[70], objArr[150], objArr[131], objArr[132], objArr[148], objArr[181], objArr[182], objArr[122], objArr[120], objArr[95], objArr[89], objArr[74], objArr[72], objArr[172], objArr[178], objArr[180], objArr[192], objArr[146], objArr[60], objArr[66], objArr[103], objArr[157], objArr[68], objArr[30], objArr[54], objArr[26], objArr[27], objArr[36], objArr[37], objArr[102], objArr[98], objArr[105], objArr[100], objArr[31], objArr[25], objArr[144], objArr[168], objArr[28], objArr[29], objArr[118], objArr[162], objArr[152], objArr[189], objArr[50], objArr[24], objArr[23], objArr[21], objArr[167], objArr[166], objArr[170], objArr[173], objArr[187], objArr[106], objArr[53], objArr[33], objArr[32]);
        this.mDirtyFlags = -1;
        this.layoutNonUSProductDetailContainer.setTag((Object) null);
        this.mboundView0 = objArr[0];
        this.mboundView0.setTag((Object) null);
        this.mboundView1 = objArr[1];
        this.mboundView1.setTag((Object) null);
        this.preBidlayout.setTag((Object) null);
        setRootTag(view);
        invalidateAll();
    }

    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 4;
        }
        requestRebind();
    }

    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.mDirtyFlags != 0) {
                return true;
            }
            return false;
        }
    }

    public boolean setVariable(int i, @Nullable Object obj) {
        if (5 == i) {
            setBiddingInfo((BiddingInformation) obj);
        } else if (6 != i) {
            return false;
        } else {
            setViewModel((ProductDetailViewModel) obj);
        }
        return true;
    }

    public void setBiddingInfo(@Nullable BiddingInformation biddingInformation) {
        this.mBiddingInfo = biddingInformation;
    }

    public void setViewModel(@Nullable ProductDetailViewModel productDetailViewModel) {
        this.mViewModel = productDetailViewModel;
    }

    /* access modifiers changed from: protected */
    public void executeBindings() {
        synchronized (this) {
            long j = this.mDirtyFlags;
            this.mDirtyFlags = 0;
        }
    }
}
