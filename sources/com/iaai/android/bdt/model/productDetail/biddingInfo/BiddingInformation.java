package com.iaai.android.bdt.model.productDetail.biddingInfo;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.C1119C;
import com.lowagie.text.pdf.PdfFormField;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\bO\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0006\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020 \u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010$\u001a\u00020\u0006\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010&J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0006HÆ\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0006HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\t\u0010T\u001a\u00020\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u0003HÆ\u0003J\t\u0010V\u001a\u00020\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0006HÆ\u0003J\u000f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010Y\u001a\u00020\u0006HÆ\u0003J\t\u0010Z\u001a\u00020\u0006HÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020 HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\u000f\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000f\u0010c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010d\u001a\u00020\u0006HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010=J\u000f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010g\u001a\u00020\u0006HÆ\u0003J\t\u0010h\u001a\u00020\u000bHÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u000bHÆ\u0003J\t\u0010k\u001a\u00020\u0006HÆ\u0003JÞ\u0002\u0010l\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\u00032\b\b\u0002\u0010\"\u001a\u00020\u00032\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010$\u001a\u00020\u00062\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010mJ\u0013\u0010n\u001a\u00020\u00032\b\u0010o\u001a\u0004\u0018\u00010pHÖ\u0003J\t\u0010q\u001a\u00020 HÖ\u0001J\t\u0010r\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b.\u0010,R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010(R\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b2\u00100R\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b3\u0010*R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u0010*R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010(R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010(R\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u0010*R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010(R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010(R\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010(R\u0015\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010>\u001a\u0004\b<\u0010=R\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010(R\u0011\u0010\u0018\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b@\u0010*R\u0011\u0010\u0019\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bA\u0010*R\u0011\u0010\u001a\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bB\u0010*R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010(R\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010(R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010(R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010(R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010(R\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010(R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u0010,R\u0011\u0010$\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bL\u0010*¨\u0006s"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/biddingInfo/BiddingInformation;", "Ljava/io/Serializable;", "BidBuyInd", "", "BiddingNotes", "", "", "BiddingWarnings", "BidStatusWarnings", "BidStatusIcon", "BuyNowAmount", "", "BuyNowInd", "BuyNowOfferAmount", "BuyNowPrice", "DecimalHighBidAmount", "DisplayHighPrebid", "DisplaySalesTaxWarning", "DisplaySalesTaxWarningLinks", "HighBidAmount", "IsHighPrebidder", "IsPreBidVisible", "IsPrebiddingDone", "IsWatching", "Make", "Model", "MyCurrent", "PrebidAllowed", "PrebidClosed", "SalesTaxInd", "ShowCurrentBid", "TimedAuctionBuyNowOfferstatus", "", "TimedAuctionInd", "WatchingAllowed", "WhoCanBuy", "Year", "IsUpstreamBranchStock", "(ZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;DZDLjava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZIZZLjava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)V", "getBidBuyInd", "()Z", "getBidStatusIcon", "()Ljava/lang/String;", "getBidStatusWarnings", "()Ljava/util/List;", "getBiddingNotes", "getBiddingWarnings", "getBuyNowAmount", "()D", "getBuyNowInd", "getBuyNowOfferAmount", "getBuyNowPrice", "getDecimalHighBidAmount", "getDisplayHighPrebid", "getDisplaySalesTaxWarning", "getDisplaySalesTaxWarningLinks", "getHighBidAmount", "getIsHighPrebidder", "getIsPreBidVisible", "getIsPrebiddingDone", "getIsUpstreamBranchStock", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getIsWatching", "getMake", "getModel", "getMyCurrent", "getPrebidAllowed", "getPrebidClosed", "getSalesTaxInd", "getShowCurrentBid", "getTimedAuctionBuyNowOfferstatus", "()I", "getTimedAuctionInd", "getWatchingAllowed", "getWhoCanBuy", "getYear", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;DZDLjava/lang/String;Ljava/lang/String;ZZZLjava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZIZZLjava/util/List;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/iaai/android/bdt/model/productDetail/biddingInfo/BiddingInformation;", "equals", "other", "", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BiddingInformation.kt */
public final class BiddingInformation implements Serializable {
    private final boolean BidBuyInd;
    @NotNull
    private final String BidStatusIcon;
    @NotNull
    private final List<String> BidStatusWarnings;
    @NotNull
    private final List<String> BiddingNotes;
    @NotNull
    private final List<String> BiddingWarnings;
    private final double BuyNowAmount;
    private final boolean BuyNowInd;
    private final double BuyNowOfferAmount;
    @NotNull
    private final String BuyNowPrice;
    @NotNull
    private final String DecimalHighBidAmount;
    private final boolean DisplayHighPrebid;
    private final boolean DisplaySalesTaxWarning;
    private final boolean DisplaySalesTaxWarningLinks;
    @NotNull
    private final String HighBidAmount;
    private final boolean IsHighPrebidder;
    private final boolean IsPreBidVisible;
    private final boolean IsPrebiddingDone;
    @Nullable
    private final Boolean IsUpstreamBranchStock;
    private final boolean IsWatching;
    @NotNull
    private final String Make;
    @NotNull
    private final String Model;
    @NotNull
    private final String MyCurrent;
    private final boolean PrebidAllowed;
    private final boolean PrebidClosed;
    private final boolean SalesTaxInd;
    private final boolean ShowCurrentBid;
    private final int TimedAuctionBuyNowOfferstatus;
    private final boolean TimedAuctionInd;
    private final boolean WatchingAllowed;
    @NotNull
    private final List<String> WhoCanBuy;
    @NotNull
    private final String Year;

    @NotNull
    public static /* synthetic */ BiddingInformation copy$default(BiddingInformation biddingInformation, boolean z, List list, List list2, List list3, String str, double d, boolean z2, double d2, String str2, String str3, boolean z3, boolean z4, boolean z5, String str4, boolean z6, boolean z7, boolean z8, boolean z9, String str5, String str6, String str7, boolean z10, boolean z11, boolean z12, boolean z13, int i, boolean z14, boolean z15, List list4, String str8, Boolean bool, int i2, Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z30;
        int i3;
        int i4;
        boolean z31;
        boolean z32;
        boolean z33;
        boolean z34;
        List list5;
        List list6;
        String str15;
        BiddingInformation biddingInformation2 = biddingInformation;
        int i5 = i2;
        boolean z35 = (i5 & 1) != 0 ? biddingInformation2.BidBuyInd : z;
        List list7 = (i5 & 2) != 0 ? biddingInformation2.BiddingNotes : list;
        List list8 = (i5 & 4) != 0 ? biddingInformation2.BiddingWarnings : list2;
        List list9 = (i5 & 8) != 0 ? biddingInformation2.BidStatusWarnings : list3;
        String str16 = (i5 & 16) != 0 ? biddingInformation2.BidStatusIcon : str;
        double d3 = (i5 & 32) != 0 ? biddingInformation2.BuyNowAmount : d;
        boolean z36 = (i5 & 64) != 0 ? biddingInformation2.BuyNowInd : z2;
        double d4 = (i5 & 128) != 0 ? biddingInformation2.BuyNowOfferAmount : d2;
        String str17 = (i5 & 256) != 0 ? biddingInformation2.BuyNowPrice : str2;
        String str18 = (i5 & 512) != 0 ? biddingInformation2.DecimalHighBidAmount : str3;
        boolean z37 = (i5 & 1024) != 0 ? biddingInformation2.DisplayHighPrebid : z3;
        boolean z38 = (i5 & 2048) != 0 ? biddingInformation2.DisplaySalesTaxWarning : z4;
        boolean z39 = (i5 & 4096) != 0 ? biddingInformation2.DisplaySalesTaxWarningLinks : z5;
        String str19 = (i5 & 8192) != 0 ? biddingInformation2.HighBidAmount : str4;
        boolean z40 = (i5 & 16384) != 0 ? biddingInformation2.IsHighPrebidder : z6;
        if ((i5 & 32768) != 0) {
            z16 = z40;
            z17 = biddingInformation2.IsPreBidVisible;
        } else {
            z16 = z40;
            z17 = z7;
        }
        if ((i5 & 65536) != 0) {
            z18 = z17;
            z19 = biddingInformation2.IsPrebiddingDone;
        } else {
            z18 = z17;
            z19 = z8;
        }
        if ((i5 & 131072) != 0) {
            z20 = z19;
            z21 = biddingInformation2.IsWatching;
        } else {
            z20 = z19;
            z21 = z9;
        }
        if ((i5 & 262144) != 0) {
            z22 = z21;
            str9 = biddingInformation2.Make;
        } else {
            z22 = z21;
            str9 = str5;
        }
        if ((i5 & 524288) != 0) {
            str10 = str9;
            str11 = biddingInformation2.Model;
        } else {
            str10 = str9;
            str11 = str6;
        }
        if ((i5 & 1048576) != 0) {
            str12 = str11;
            str13 = biddingInformation2.MyCurrent;
        } else {
            str12 = str11;
            str13 = str7;
        }
        if ((i5 & 2097152) != 0) {
            str14 = str13;
            z23 = biddingInformation2.PrebidAllowed;
        } else {
            str14 = str13;
            z23 = z10;
        }
        if ((i5 & 4194304) != 0) {
            z24 = z23;
            z25 = biddingInformation2.PrebidClosed;
        } else {
            z24 = z23;
            z25 = z11;
        }
        if ((i5 & 8388608) != 0) {
            z26 = z25;
            z27 = biddingInformation2.SalesTaxInd;
        } else {
            z26 = z25;
            z27 = z12;
        }
        if ((i5 & 16777216) != 0) {
            z28 = z27;
            z29 = biddingInformation2.ShowCurrentBid;
        } else {
            z28 = z27;
            z29 = z13;
        }
        if ((i5 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            z30 = z29;
            i3 = biddingInformation2.TimedAuctionBuyNowOfferstatus;
        } else {
            z30 = z29;
            i3 = i;
        }
        if ((i5 & 67108864) != 0) {
            i4 = i3;
            z31 = biddingInformation2.TimedAuctionInd;
        } else {
            i4 = i3;
            z31 = z14;
        }
        if ((i5 & 134217728) != 0) {
            z32 = z31;
            z33 = biddingInformation2.WatchingAllowed;
        } else {
            z32 = z31;
            z33 = z15;
        }
        if ((i5 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            z34 = z33;
            list5 = biddingInformation2.WhoCanBuy;
        } else {
            z34 = z33;
            list5 = list4;
        }
        if ((i5 & 536870912) != 0) {
            list6 = list5;
            str15 = biddingInformation2.Year;
        } else {
            list6 = list5;
            str15 = str8;
        }
        return biddingInformation.copy(z35, list7, list8, list9, str16, d3, z36, d4, str17, str18, z37, z38, z39, str19, z16, z18, z20, z22, str10, str12, str14, z24, z26, z28, z30, i4, z32, z34, list6, str15, (i5 & 1073741824) != 0 ? biddingInformation2.IsUpstreamBranchStock : bool);
    }

    public final boolean component1() {
        return this.BidBuyInd;
    }

    @NotNull
    public final String component10() {
        return this.DecimalHighBidAmount;
    }

    public final boolean component11() {
        return this.DisplayHighPrebid;
    }

    public final boolean component12() {
        return this.DisplaySalesTaxWarning;
    }

    public final boolean component13() {
        return this.DisplaySalesTaxWarningLinks;
    }

    @NotNull
    public final String component14() {
        return this.HighBidAmount;
    }

    public final boolean component15() {
        return this.IsHighPrebidder;
    }

    public final boolean component16() {
        return this.IsPreBidVisible;
    }

    public final boolean component17() {
        return this.IsPrebiddingDone;
    }

    public final boolean component18() {
        return this.IsWatching;
    }

    @NotNull
    public final String component19() {
        return this.Make;
    }

    @NotNull
    public final List<String> component2() {
        return this.BiddingNotes;
    }

    @NotNull
    public final String component20() {
        return this.Model;
    }

    @NotNull
    public final String component21() {
        return this.MyCurrent;
    }

    public final boolean component22() {
        return this.PrebidAllowed;
    }

    public final boolean component23() {
        return this.PrebidClosed;
    }

    public final boolean component24() {
        return this.SalesTaxInd;
    }

    public final boolean component25() {
        return this.ShowCurrentBid;
    }

    public final int component26() {
        return this.TimedAuctionBuyNowOfferstatus;
    }

    public final boolean component27() {
        return this.TimedAuctionInd;
    }

    public final boolean component28() {
        return this.WatchingAllowed;
    }

    @NotNull
    public final List<String> component29() {
        return this.WhoCanBuy;
    }

    @NotNull
    public final List<String> component3() {
        return this.BiddingWarnings;
    }

    @NotNull
    public final String component30() {
        return this.Year;
    }

    @Nullable
    public final Boolean component31() {
        return this.IsUpstreamBranchStock;
    }

    @NotNull
    public final List<String> component4() {
        return this.BidStatusWarnings;
    }

    @NotNull
    public final String component5() {
        return this.BidStatusIcon;
    }

    public final double component6() {
        return this.BuyNowAmount;
    }

    public final boolean component7() {
        return this.BuyNowInd;
    }

    public final double component8() {
        return this.BuyNowOfferAmount;
    }

    @NotNull
    public final String component9() {
        return this.BuyNowPrice;
    }

    @NotNull
    public final BiddingInformation copy(boolean z, @NotNull List<String> list, @NotNull List<String> list2, @NotNull List<String> list3, @NotNull String str, double d, boolean z2, double d2, @NotNull String str2, @NotNull String str3, boolean z3, boolean z4, boolean z5, @NotNull String str4, boolean z6, boolean z7, boolean z8, boolean z9, @NotNull String str5, @NotNull String str6, @NotNull String str7, boolean z10, boolean z11, boolean z12, boolean z13, int i, boolean z14, boolean z15, @NotNull List<String> list4, @NotNull String str8, @Nullable Boolean bool) {
        boolean z16 = z;
        Intrinsics.checkParameterIsNotNull(list, "BiddingNotes");
        Intrinsics.checkParameterIsNotNull(list2, "BiddingWarnings");
        Intrinsics.checkParameterIsNotNull(list3, "BidStatusWarnings");
        Intrinsics.checkParameterIsNotNull(str, "BidStatusIcon");
        Intrinsics.checkParameterIsNotNull(str2, "BuyNowPrice");
        Intrinsics.checkParameterIsNotNull(str3, "DecimalHighBidAmount");
        Intrinsics.checkParameterIsNotNull(str4, "HighBidAmount");
        Intrinsics.checkParameterIsNotNull(str5, ExifInterface.TAG_MAKE);
        Intrinsics.checkParameterIsNotNull(str6, ExifInterface.TAG_MODEL);
        Intrinsics.checkParameterIsNotNull(str7, "MyCurrent");
        Intrinsics.checkParameterIsNotNull(list4, "WhoCanBuy");
        Intrinsics.checkParameterIsNotNull(str8, "Year");
        return new BiddingInformation(z, list, list2, list3, str, d, z2, d2, str2, str3, z3, z4, z5, str4, z6, z7, z8, z9, str5, str6, str7, z10, z11, z12, z13, i, z14, z15, list4, str8, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof BiddingInformation) {
                BiddingInformation biddingInformation = (BiddingInformation) obj;
                if ((this.BidBuyInd == biddingInformation.BidBuyInd) && Intrinsics.areEqual((Object) this.BiddingNotes, (Object) biddingInformation.BiddingNotes) && Intrinsics.areEqual((Object) this.BiddingWarnings, (Object) biddingInformation.BiddingWarnings) && Intrinsics.areEqual((Object) this.BidStatusWarnings, (Object) biddingInformation.BidStatusWarnings) && Intrinsics.areEqual((Object) this.BidStatusIcon, (Object) biddingInformation.BidStatusIcon) && Double.compare(this.BuyNowAmount, biddingInformation.BuyNowAmount) == 0) {
                    if ((this.BuyNowInd == biddingInformation.BuyNowInd) && Double.compare(this.BuyNowOfferAmount, biddingInformation.BuyNowOfferAmount) == 0 && Intrinsics.areEqual((Object) this.BuyNowPrice, (Object) biddingInformation.BuyNowPrice) && Intrinsics.areEqual((Object) this.DecimalHighBidAmount, (Object) biddingInformation.DecimalHighBidAmount)) {
                        if (this.DisplayHighPrebid == biddingInformation.DisplayHighPrebid) {
                            if (this.DisplaySalesTaxWarning == biddingInformation.DisplaySalesTaxWarning) {
                                if ((this.DisplaySalesTaxWarningLinks == biddingInformation.DisplaySalesTaxWarningLinks) && Intrinsics.areEqual((Object) this.HighBidAmount, (Object) biddingInformation.HighBidAmount)) {
                                    if (this.IsHighPrebidder == biddingInformation.IsHighPrebidder) {
                                        if (this.IsPreBidVisible == biddingInformation.IsPreBidVisible) {
                                            if (this.IsPrebiddingDone == biddingInformation.IsPrebiddingDone) {
                                                if ((this.IsWatching == biddingInformation.IsWatching) && Intrinsics.areEqual((Object) this.Make, (Object) biddingInformation.Make) && Intrinsics.areEqual((Object) this.Model, (Object) biddingInformation.Model) && Intrinsics.areEqual((Object) this.MyCurrent, (Object) biddingInformation.MyCurrent)) {
                                                    if (this.PrebidAllowed == biddingInformation.PrebidAllowed) {
                                                        if (this.PrebidClosed == biddingInformation.PrebidClosed) {
                                                            if (this.SalesTaxInd == biddingInformation.SalesTaxInd) {
                                                                if (this.ShowCurrentBid == biddingInformation.ShowCurrentBid) {
                                                                    if (this.TimedAuctionBuyNowOfferstatus == biddingInformation.TimedAuctionBuyNowOfferstatus) {
                                                                        if (this.TimedAuctionInd == biddingInformation.TimedAuctionInd) {
                                                                            if (!(this.WatchingAllowed == biddingInformation.WatchingAllowed) || !Intrinsics.areEqual((Object) this.WhoCanBuy, (Object) biddingInformation.WhoCanBuy) || !Intrinsics.areEqual((Object) this.Year, (Object) biddingInformation.Year) || !Intrinsics.areEqual((Object) this.IsUpstreamBranchStock, (Object) biddingInformation.IsUpstreamBranchStock)) {
                                                                                return false;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.BidBuyInd;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        List<String> list = this.BiddingNotes;
        int i2 = 0;
        int hashCode = (i + (list != null ? list.hashCode() : 0)) * 31;
        List<String> list2 = this.BiddingWarnings;
        int hashCode2 = (hashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<String> list3 = this.BidStatusWarnings;
        int hashCode3 = (hashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str = this.BidStatusIcon;
        int hashCode4 = (((hashCode3 + (str != null ? str.hashCode() : 0)) * 31) + Double.valueOf(this.BuyNowAmount).hashCode()) * 31;
        boolean z3 = this.BuyNowInd;
        if (z3) {
            z3 = true;
        }
        int hashCode5 = (((hashCode4 + (z3 ? 1 : 0)) * 31) + Double.valueOf(this.BuyNowOfferAmount).hashCode()) * 31;
        String str2 = this.BuyNowPrice;
        int hashCode6 = (hashCode5 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.DecimalHighBidAmount;
        int hashCode7 = (hashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z4 = this.DisplayHighPrebid;
        if (z4) {
            z4 = true;
        }
        int i3 = (hashCode7 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.DisplaySalesTaxWarning;
        if (z5) {
            z5 = true;
        }
        int i4 = (i3 + (z5 ? 1 : 0)) * 31;
        boolean z6 = this.DisplaySalesTaxWarningLinks;
        if (z6) {
            z6 = true;
        }
        int i5 = (i4 + (z6 ? 1 : 0)) * 31;
        String str4 = this.HighBidAmount;
        int hashCode8 = (i5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        boolean z7 = this.IsHighPrebidder;
        if (z7) {
            z7 = true;
        }
        int i6 = (hashCode8 + (z7 ? 1 : 0)) * 31;
        boolean z8 = this.IsPreBidVisible;
        if (z8) {
            z8 = true;
        }
        int i7 = (i6 + (z8 ? 1 : 0)) * 31;
        boolean z9 = this.IsPrebiddingDone;
        if (z9) {
            z9 = true;
        }
        int i8 = (i7 + (z9 ? 1 : 0)) * 31;
        boolean z10 = this.IsWatching;
        if (z10) {
            z10 = true;
        }
        int i9 = (i8 + (z10 ? 1 : 0)) * 31;
        String str5 = this.Make;
        int hashCode9 = (i9 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.Model;
        int hashCode10 = (hashCode9 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.MyCurrent;
        int hashCode11 = (hashCode10 + (str7 != null ? str7.hashCode() : 0)) * 31;
        boolean z11 = this.PrebidAllowed;
        if (z11) {
            z11 = true;
        }
        int i10 = (hashCode11 + (z11 ? 1 : 0)) * 31;
        boolean z12 = this.PrebidClosed;
        if (z12) {
            z12 = true;
        }
        int i11 = (i10 + (z12 ? 1 : 0)) * 31;
        boolean z13 = this.SalesTaxInd;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        boolean z14 = this.ShowCurrentBid;
        if (z14) {
            z14 = true;
        }
        int hashCode12 = (((i12 + (z14 ? 1 : 0)) * 31) + Integer.valueOf(this.TimedAuctionBuyNowOfferstatus).hashCode()) * 31;
        boolean z15 = this.TimedAuctionInd;
        if (z15) {
            z15 = true;
        }
        int i13 = (hashCode12 + (z15 ? 1 : 0)) * 31;
        boolean z16 = this.WatchingAllowed;
        if (!z16) {
            z2 = z16;
        }
        int i14 = (i13 + (z2 ? 1 : 0)) * 31;
        List<String> list4 = this.WhoCanBuy;
        int hashCode13 = (i14 + (list4 != null ? list4.hashCode() : 0)) * 31;
        String str8 = this.Year;
        int hashCode14 = (hashCode13 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Boolean bool = this.IsUpstreamBranchStock;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode14 + i2;
    }

    @NotNull
    public String toString() {
        return "BiddingInformation(BidBuyInd=" + this.BidBuyInd + ", BiddingNotes=" + this.BiddingNotes + ", BiddingWarnings=" + this.BiddingWarnings + ", BidStatusWarnings=" + this.BidStatusWarnings + ", BidStatusIcon=" + this.BidStatusIcon + ", BuyNowAmount=" + this.BuyNowAmount + ", BuyNowInd=" + this.BuyNowInd + ", BuyNowOfferAmount=" + this.BuyNowOfferAmount + ", BuyNowPrice=" + this.BuyNowPrice + ", DecimalHighBidAmount=" + this.DecimalHighBidAmount + ", DisplayHighPrebid=" + this.DisplayHighPrebid + ", DisplaySalesTaxWarning=" + this.DisplaySalesTaxWarning + ", DisplaySalesTaxWarningLinks=" + this.DisplaySalesTaxWarningLinks + ", HighBidAmount=" + this.HighBidAmount + ", IsHighPrebidder=" + this.IsHighPrebidder + ", IsPreBidVisible=" + this.IsPreBidVisible + ", IsPrebiddingDone=" + this.IsPrebiddingDone + ", IsWatching=" + this.IsWatching + ", Make=" + this.Make + ", Model=" + this.Model + ", MyCurrent=" + this.MyCurrent + ", PrebidAllowed=" + this.PrebidAllowed + ", PrebidClosed=" + this.PrebidClosed + ", SalesTaxInd=" + this.SalesTaxInd + ", ShowCurrentBid=" + this.ShowCurrentBid + ", TimedAuctionBuyNowOfferstatus=" + this.TimedAuctionBuyNowOfferstatus + ", TimedAuctionInd=" + this.TimedAuctionInd + ", WatchingAllowed=" + this.WatchingAllowed + ", WhoCanBuy=" + this.WhoCanBuy + ", Year=" + this.Year + ", IsUpstreamBranchStock=" + this.IsUpstreamBranchStock + ")";
    }

    public BiddingInformation(boolean z, @NotNull List<String> list, @NotNull List<String> list2, @NotNull List<String> list3, @NotNull String str, double d, boolean z2, double d2, @NotNull String str2, @NotNull String str3, boolean z3, boolean z4, boolean z5, @NotNull String str4, boolean z6, boolean z7, boolean z8, boolean z9, @NotNull String str5, @NotNull String str6, @NotNull String str7, boolean z10, boolean z11, boolean z12, boolean z13, int i, boolean z14, boolean z15, @NotNull List<String> list4, @NotNull String str8, @Nullable Boolean bool) {
        List<String> list5 = list;
        List<String> list6 = list2;
        List<String> list7 = list3;
        String str9 = str;
        String str10 = str2;
        String str11 = str3;
        String str12 = str4;
        String str13 = str5;
        String str14 = str6;
        String str15 = str7;
        List<String> list8 = list4;
        String str16 = str8;
        Intrinsics.checkParameterIsNotNull(list5, "BiddingNotes");
        Intrinsics.checkParameterIsNotNull(list6, "BiddingWarnings");
        Intrinsics.checkParameterIsNotNull(list7, "BidStatusWarnings");
        Intrinsics.checkParameterIsNotNull(str9, "BidStatusIcon");
        Intrinsics.checkParameterIsNotNull(str10, "BuyNowPrice");
        Intrinsics.checkParameterIsNotNull(str11, "DecimalHighBidAmount");
        Intrinsics.checkParameterIsNotNull(str12, "HighBidAmount");
        Intrinsics.checkParameterIsNotNull(str13, ExifInterface.TAG_MAKE);
        Intrinsics.checkParameterIsNotNull(str14, ExifInterface.TAG_MODEL);
        Intrinsics.checkParameterIsNotNull(str15, "MyCurrent");
        Intrinsics.checkParameterIsNotNull(list8, "WhoCanBuy");
        Intrinsics.checkParameterIsNotNull(str16, "Year");
        this.BidBuyInd = z;
        this.BiddingNotes = list5;
        this.BiddingWarnings = list6;
        this.BidStatusWarnings = list7;
        this.BidStatusIcon = str9;
        this.BuyNowAmount = d;
        this.BuyNowInd = z2;
        this.BuyNowOfferAmount = d2;
        this.BuyNowPrice = str10;
        this.DecimalHighBidAmount = str11;
        this.DisplayHighPrebid = z3;
        this.DisplaySalesTaxWarning = z4;
        this.DisplaySalesTaxWarningLinks = z5;
        this.HighBidAmount = str12;
        this.IsHighPrebidder = z6;
        this.IsPreBidVisible = z7;
        this.IsPrebiddingDone = z8;
        this.IsWatching = z9;
        this.Make = str13;
        this.Model = str14;
        this.MyCurrent = str15;
        this.PrebidAllowed = z10;
        this.PrebidClosed = z11;
        this.SalesTaxInd = z12;
        this.ShowCurrentBid = z13;
        this.TimedAuctionBuyNowOfferstatus = i;
        this.TimedAuctionInd = z14;
        this.WatchingAllowed = z15;
        this.WhoCanBuy = list8;
        this.Year = str16;
        this.IsUpstreamBranchStock = bool;
    }

    public final boolean getBidBuyInd() {
        return this.BidBuyInd;
    }

    @NotNull
    public final List<String> getBiddingNotes() {
        return this.BiddingNotes;
    }

    @NotNull
    public final List<String> getBiddingWarnings() {
        return this.BiddingWarnings;
    }

    @NotNull
    public final List<String> getBidStatusWarnings() {
        return this.BidStatusWarnings;
    }

    @NotNull
    public final String getBidStatusIcon() {
        return this.BidStatusIcon;
    }

    public final double getBuyNowAmount() {
        return this.BuyNowAmount;
    }

    public final boolean getBuyNowInd() {
        return this.BuyNowInd;
    }

    public final double getBuyNowOfferAmount() {
        return this.BuyNowOfferAmount;
    }

    @NotNull
    public final String getBuyNowPrice() {
        return this.BuyNowPrice;
    }

    @NotNull
    public final String getDecimalHighBidAmount() {
        return this.DecimalHighBidAmount;
    }

    public final boolean getDisplayHighPrebid() {
        return this.DisplayHighPrebid;
    }

    public final boolean getDisplaySalesTaxWarning() {
        return this.DisplaySalesTaxWarning;
    }

    public final boolean getDisplaySalesTaxWarningLinks() {
        return this.DisplaySalesTaxWarningLinks;
    }

    @NotNull
    public final String getHighBidAmount() {
        return this.HighBidAmount;
    }

    public final boolean getIsHighPrebidder() {
        return this.IsHighPrebidder;
    }

    public final boolean getIsPreBidVisible() {
        return this.IsPreBidVisible;
    }

    public final boolean getIsPrebiddingDone() {
        return this.IsPrebiddingDone;
    }

    public final boolean getIsWatching() {
        return this.IsWatching;
    }

    @NotNull
    public final String getMake() {
        return this.Make;
    }

    @NotNull
    public final String getModel() {
        return this.Model;
    }

    @NotNull
    public final String getMyCurrent() {
        return this.MyCurrent;
    }

    public final boolean getPrebidAllowed() {
        return this.PrebidAllowed;
    }

    public final boolean getPrebidClosed() {
        return this.PrebidClosed;
    }

    public final boolean getSalesTaxInd() {
        return this.SalesTaxInd;
    }

    public final boolean getShowCurrentBid() {
        return this.ShowCurrentBid;
    }

    public final int getTimedAuctionBuyNowOfferstatus() {
        return this.TimedAuctionBuyNowOfferstatus;
    }

    public final boolean getTimedAuctionInd() {
        return this.TimedAuctionInd;
    }

    public final boolean getWatchingAllowed() {
        return this.WatchingAllowed;
    }

    @NotNull
    public final List<String> getWhoCanBuy() {
        return this.WhoCanBuy;
    }

    @NotNull
    public final String getYear() {
        return this.Year;
    }

    @Nullable
    public final Boolean getIsUpstreamBranchStock() {
        return this.IsUpstreamBranchStock;
    }
}
