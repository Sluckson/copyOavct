package com.iaai.android.bdt.model.digitalNegotiation;

import com.google.android.exoplayer2.C1119C;
import com.lowagie.text.pdf.PdfFormField;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b_\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001Bá\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010$\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010'\u001a\u00020$\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010)J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010^\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010g\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010h\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010i\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010j\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010k\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010l\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010.J\u0010\u0010m\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010n\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u0010\u0010o\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u00101J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010u\u001a\u0004\u0018\u00010$HÆ\u0003¢\u0006\u0002\u0010WJ\u0010\u0010v\u001a\u0004\u0018\u00010$HÆ\u0003¢\u0006\u0002\u0010WJ\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010x\u001a\u00020$HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010~\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J²\u0003\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010'\u001a\u00020$2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u0001J\u0016\u0010\u0001\u001a\u00020$2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\u000eHÖ\u0001J\n\u0010\u0001\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010/\u001a\u0004\b-\u0010.R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00102\u001a\u0004\b0\u00101R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010+R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010+R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00102\u001a\u0004\b5\u00101R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010+\"\u0004\b8\u00109R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010+R\u0013\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010+R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010+\"\u0004\b@\u00109R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010+\"\u0004\bB\u00109R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010+R\u0011\u0010'\u001a\u00020$¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00102\u001a\u0004\bF\u00101R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010+R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bH\u0010+R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00102\u001a\u0004\bI\u00101R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010+R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\bK\u00101\"\u0004\bL\u0010MR\u0015\u0010\u0018\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00102\u001a\u0004\bN\u00101R\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00102\u001a\u0004\bO\u00101R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010/\u001a\u0004\bP\u0010.R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010+R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010+\"\u0004\bS\u00109R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u0010+R\u0013\u0010(\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u0010+R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u00102\u001a\u0004\bV\u00101R\u0015\u0010#\u001a\u0004\u0018\u00010$¢\u0006\n\n\u0002\u0010X\u001a\u0004\b#\u0010WR\u001e\u0010%\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0010\n\u0002\u0010X\u001a\u0004\b%\u0010W\"\u0004\bY\u0010ZR\u001c\u0010&\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010+\"\u0004\b\\\u00109¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/digitalNegotiation/MobileNegotiationsList;", "Ljava/io/Serializable;", "EventDateTime", "", "ExpiryDatetime", "Eventtype", "FormattedBidAmount", "FormattedNegotiationAmount", "FormattedSellerOfferAmount", "SellerOfferAmount", "", "FormattedCurrentBidAmount", "AuctionDatetime", "Year", "", "Make", "Model", "Status", "AuctionLane", "BranchName", "BranchState", "FormattedBidIncrementAmount", "StockNumber", "SellerLiveRepAmount", "SalvageID", "ItemId", "CurrentBidAmount", "BidAmount", "BranchCode", "RemainingBidderCounters", "NegotiationAmount", "NegotiationId", "Slot", "ExternalAuctionId", "ExternalAuctionItemId", "isActionDone", "", "isBidHistoryVisible", "remainingTime", "IsCounterInitiated", "ThumbnailImage", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;ZLjava/lang/String;)V", "getAuctionDatetime", "()Ljava/lang/String;", "getAuctionLane", "getBidAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBranchCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBranchName", "getBranchState", "getCurrentBidAmount", "getEventDateTime", "getEventtype", "setEventtype", "(Ljava/lang/String;)V", "getExpiryDatetime", "getExternalAuctionId", "getExternalAuctionItemId", "getFormattedBidAmount", "getFormattedBidIncrementAmount", "getFormattedCurrentBidAmount", "setFormattedCurrentBidAmount", "getFormattedNegotiationAmount", "setFormattedNegotiationAmount", "getFormattedSellerOfferAmount", "getIsCounterInitiated", "()Z", "getItemId", "getMake", "getModel", "getNegotiationAmount", "getNegotiationId", "getRemainingBidderCounters", "setRemainingBidderCounters", "(Ljava/lang/Integer;)V", "getSalvageID", "getSellerLiveRepAmount", "getSellerOfferAmount", "getSlot", "getStatus", "setStatus", "getStockNumber", "getThumbnailImage", "getYear", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "setBidHistoryVisible", "(Ljava/lang/Boolean;)V", "getRemainingTime", "setRemainingTime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;ZLjava/lang/String;)Lcom/iaai/android/bdt/model/digitalNegotiation/MobileNegotiationsList;", "equals", "other", "", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MobileNegotiationsList.kt */
public final class MobileNegotiationsList implements Serializable {
    @Nullable
    private final String AuctionDatetime;
    @Nullable
    private final String AuctionLane;
    @Nullable
    private final Long BidAmount;
    @Nullable
    private final Integer BranchCode;
    @Nullable
    private final String BranchName;
    @Nullable
    private final String BranchState;
    @Nullable
    private final Integer CurrentBidAmount;
    @Nullable
    private final String EventDateTime;
    @Nullable
    private String Eventtype;
    @Nullable
    private final String ExpiryDatetime;
    @Nullable
    private final String ExternalAuctionId;
    @Nullable
    private final String ExternalAuctionItemId;
    @Nullable
    private final String FormattedBidAmount;
    @Nullable
    private final String FormattedBidIncrementAmount;
    @Nullable
    private String FormattedCurrentBidAmount;
    @Nullable
    private String FormattedNegotiationAmount;
    @Nullable
    private final String FormattedSellerOfferAmount;
    private final boolean IsCounterInitiated;
    @Nullable
    private final Integer ItemId;
    @Nullable
    private final String Make;
    @Nullable
    private final String Model;
    @Nullable
    private final Integer NegotiationAmount;
    @Nullable
    private final String NegotiationId;
    @Nullable
    private Integer RemainingBidderCounters;
    @Nullable
    private final Integer SalvageID;
    @Nullable
    private final Integer SellerLiveRepAmount;
    @Nullable
    private final Long SellerOfferAmount;
    @Nullable
    private final String Slot;
    @Nullable
    private String Status;
    @Nullable
    private final String StockNumber;
    @Nullable
    private final String ThumbnailImage;
    @Nullable
    private final Integer Year;
    @Nullable
    private final Boolean isActionDone;
    @Nullable
    private Boolean isBidHistoryVisible;
    @Nullable
    private String remainingTime;

    @NotNull
    public static /* synthetic */ MobileNegotiationsList copy$default(MobileNegotiationsList mobileNegotiationsList, String str, String str2, String str3, String str4, String str5, String str6, Long l, String str7, String str8, Integer num, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, Integer num2, Integer num3, Integer num4, Integer num5, Long l2, Integer num6, Integer num7, Integer num8, String str17, String str18, String str19, String str20, Boolean bool, Boolean bool2, String str21, boolean z, String str22, int i, int i2, Object obj) {
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        Integer num9;
        Integer num10;
        Integer num11;
        Integer num12;
        Integer num13;
        Integer num14;
        Integer num15;
        Integer num16;
        Long l3;
        Long l4;
        Integer num17;
        Integer num18;
        Integer num19;
        Integer num20;
        Integer num21;
        Integer num22;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        String str37;
        Boolean bool3;
        Boolean bool4;
        String str38;
        String str39;
        boolean z2;
        boolean z3;
        String str40;
        MobileNegotiationsList mobileNegotiationsList2 = mobileNegotiationsList;
        int i3 = i;
        String str41 = (i3 & 1) != 0 ? mobileNegotiationsList2.EventDateTime : str;
        String str42 = (i3 & 2) != 0 ? mobileNegotiationsList2.ExpiryDatetime : str2;
        String str43 = (i3 & 4) != 0 ? mobileNegotiationsList2.Eventtype : str3;
        String str44 = (i3 & 8) != 0 ? mobileNegotiationsList2.FormattedBidAmount : str4;
        String str45 = (i3 & 16) != 0 ? mobileNegotiationsList2.FormattedNegotiationAmount : str5;
        String str46 = (i3 & 32) != 0 ? mobileNegotiationsList2.FormattedSellerOfferAmount : str6;
        Long l5 = (i3 & 64) != 0 ? mobileNegotiationsList2.SellerOfferAmount : l;
        String str47 = (i3 & 128) != 0 ? mobileNegotiationsList2.FormattedCurrentBidAmount : str7;
        String str48 = (i3 & 256) != 0 ? mobileNegotiationsList2.AuctionDatetime : str8;
        Integer num23 = (i3 & 512) != 0 ? mobileNegotiationsList2.Year : num;
        String str49 = (i3 & 1024) != 0 ? mobileNegotiationsList2.Make : str9;
        String str50 = (i3 & 2048) != 0 ? mobileNegotiationsList2.Model : str10;
        String str51 = (i3 & 4096) != 0 ? mobileNegotiationsList2.Status : str11;
        String str52 = (i3 & 8192) != 0 ? mobileNegotiationsList2.AuctionLane : str12;
        String str53 = (i3 & 16384) != 0 ? mobileNegotiationsList2.BranchName : str13;
        if ((i3 & 32768) != 0) {
            str23 = str53;
            str24 = mobileNegotiationsList2.BranchState;
        } else {
            str23 = str53;
            str24 = str14;
        }
        if ((i3 & 65536) != 0) {
            str25 = str24;
            str26 = mobileNegotiationsList2.FormattedBidIncrementAmount;
        } else {
            str25 = str24;
            str26 = str15;
        }
        if ((i3 & 131072) != 0) {
            str27 = str26;
            str28 = mobileNegotiationsList2.StockNumber;
        } else {
            str27 = str26;
            str28 = str16;
        }
        if ((i3 & 262144) != 0) {
            str29 = str28;
            num9 = mobileNegotiationsList2.SellerLiveRepAmount;
        } else {
            str29 = str28;
            num9 = num2;
        }
        if ((i3 & 524288) != 0) {
            num10 = num9;
            num11 = mobileNegotiationsList2.SalvageID;
        } else {
            num10 = num9;
            num11 = num3;
        }
        if ((i3 & 1048576) != 0) {
            num12 = num11;
            num13 = mobileNegotiationsList2.ItemId;
        } else {
            num12 = num11;
            num13 = num4;
        }
        if ((i3 & 2097152) != 0) {
            num14 = num13;
            num15 = mobileNegotiationsList2.CurrentBidAmount;
        } else {
            num14 = num13;
            num15 = num5;
        }
        if ((i3 & 4194304) != 0) {
            num16 = num15;
            l3 = mobileNegotiationsList2.BidAmount;
        } else {
            num16 = num15;
            l3 = l2;
        }
        if ((i3 & 8388608) != 0) {
            l4 = l3;
            num17 = mobileNegotiationsList2.BranchCode;
        } else {
            l4 = l3;
            num17 = num6;
        }
        if ((i3 & 16777216) != 0) {
            num18 = num17;
            num19 = mobileNegotiationsList2.RemainingBidderCounters;
        } else {
            num18 = num17;
            num19 = num7;
        }
        if ((i3 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            num20 = num19;
            num21 = mobileNegotiationsList2.NegotiationAmount;
        } else {
            num20 = num19;
            num21 = num8;
        }
        if ((i3 & 67108864) != 0) {
            num22 = num21;
            str30 = mobileNegotiationsList2.NegotiationId;
        } else {
            num22 = num21;
            str30 = str17;
        }
        if ((i3 & 134217728) != 0) {
            str31 = str30;
            str32 = mobileNegotiationsList2.Slot;
        } else {
            str31 = str30;
            str32 = str18;
        }
        if ((i3 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            str33 = str32;
            str34 = mobileNegotiationsList2.ExternalAuctionId;
        } else {
            str33 = str32;
            str34 = str19;
        }
        if ((i3 & 536870912) != 0) {
            str35 = str34;
            str36 = mobileNegotiationsList2.ExternalAuctionItemId;
        } else {
            str35 = str34;
            str36 = str20;
        }
        if ((i3 & 1073741824) != 0) {
            str37 = str36;
            bool3 = mobileNegotiationsList2.isActionDone;
        } else {
            str37 = str36;
            bool3 = bool;
        }
        Boolean bool5 = (i3 & Integer.MIN_VALUE) != 0 ? mobileNegotiationsList2.isBidHistoryVisible : bool2;
        if ((i2 & 1) != 0) {
            bool4 = bool5;
            str38 = mobileNegotiationsList2.remainingTime;
        } else {
            bool4 = bool5;
            str38 = str21;
        }
        if ((i2 & 2) != 0) {
            str39 = str38;
            z2 = mobileNegotiationsList2.IsCounterInitiated;
        } else {
            str39 = str38;
            z2 = z;
        }
        if ((i2 & 4) != 0) {
            z3 = z2;
            str40 = mobileNegotiationsList2.ThumbnailImage;
        } else {
            z3 = z2;
            str40 = str22;
        }
        return mobileNegotiationsList.copy(str41, str42, str43, str44, str45, str46, l5, str47, str48, num23, str49, str50, str51, str52, str23, str25, str27, str29, num10, num12, num14, num16, l4, num18, num20, num22, str31, str33, str35, str37, bool3, bool4, str39, z3, str40);
    }

    @Nullable
    public final String component1() {
        return this.EventDateTime;
    }

    @Nullable
    public final Integer component10() {
        return this.Year;
    }

    @Nullable
    public final String component11() {
        return this.Make;
    }

    @Nullable
    public final String component12() {
        return this.Model;
    }

    @Nullable
    public final String component13() {
        return this.Status;
    }

    @Nullable
    public final String component14() {
        return this.AuctionLane;
    }

    @Nullable
    public final String component15() {
        return this.BranchName;
    }

    @Nullable
    public final String component16() {
        return this.BranchState;
    }

    @Nullable
    public final String component17() {
        return this.FormattedBidIncrementAmount;
    }

    @Nullable
    public final String component18() {
        return this.StockNumber;
    }

    @Nullable
    public final Integer component19() {
        return this.SellerLiveRepAmount;
    }

    @Nullable
    public final String component2() {
        return this.ExpiryDatetime;
    }

    @Nullable
    public final Integer component20() {
        return this.SalvageID;
    }

    @Nullable
    public final Integer component21() {
        return this.ItemId;
    }

    @Nullable
    public final Integer component22() {
        return this.CurrentBidAmount;
    }

    @Nullable
    public final Long component23() {
        return this.BidAmount;
    }

    @Nullable
    public final Integer component24() {
        return this.BranchCode;
    }

    @Nullable
    public final Integer component25() {
        return this.RemainingBidderCounters;
    }

    @Nullable
    public final Integer component26() {
        return this.NegotiationAmount;
    }

    @Nullable
    public final String component27() {
        return this.NegotiationId;
    }

    @Nullable
    public final String component28() {
        return this.Slot;
    }

    @Nullable
    public final String component29() {
        return this.ExternalAuctionId;
    }

    @Nullable
    public final String component3() {
        return this.Eventtype;
    }

    @Nullable
    public final String component30() {
        return this.ExternalAuctionItemId;
    }

    @Nullable
    public final Boolean component31() {
        return this.isActionDone;
    }

    @Nullable
    public final Boolean component32() {
        return this.isBidHistoryVisible;
    }

    @Nullable
    public final String component33() {
        return this.remainingTime;
    }

    public final boolean component34() {
        return this.IsCounterInitiated;
    }

    @Nullable
    public final String component35() {
        return this.ThumbnailImage;
    }

    @Nullable
    public final String component4() {
        return this.FormattedBidAmount;
    }

    @Nullable
    public final String component5() {
        return this.FormattedNegotiationAmount;
    }

    @Nullable
    public final String component6() {
        return this.FormattedSellerOfferAmount;
    }

    @Nullable
    public final Long component7() {
        return this.SellerOfferAmount;
    }

    @Nullable
    public final String component8() {
        return this.FormattedCurrentBidAmount;
    }

    @Nullable
    public final String component9() {
        return this.AuctionDatetime;
    }

    @NotNull
    public final MobileNegotiationsList copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Long l, @Nullable String str7, @Nullable String str8, @Nullable Integer num, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Long l2, @Nullable Integer num6, @Nullable Integer num7, @Nullable Integer num8, @Nullable String str17, @Nullable String str18, @Nullable String str19, @Nullable String str20, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str21, boolean z, @Nullable String str22) {
        return new MobileNegotiationsList(str, str2, str3, str4, str5, str6, l, str7, str8, num, str9, str10, str11, str12, str13, str14, str15, str16, num2, num3, num4, num5, l2, num6, num7, num8, str17, str18, str19, str20, bool, bool2, str21, z, str22);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof MobileNegotiationsList) {
                MobileNegotiationsList mobileNegotiationsList = (MobileNegotiationsList) obj;
                if (Intrinsics.areEqual((Object) this.EventDateTime, (Object) mobileNegotiationsList.EventDateTime) && Intrinsics.areEqual((Object) this.ExpiryDatetime, (Object) mobileNegotiationsList.ExpiryDatetime) && Intrinsics.areEqual((Object) this.Eventtype, (Object) mobileNegotiationsList.Eventtype) && Intrinsics.areEqual((Object) this.FormattedBidAmount, (Object) mobileNegotiationsList.FormattedBidAmount) && Intrinsics.areEqual((Object) this.FormattedNegotiationAmount, (Object) mobileNegotiationsList.FormattedNegotiationAmount) && Intrinsics.areEqual((Object) this.FormattedSellerOfferAmount, (Object) mobileNegotiationsList.FormattedSellerOfferAmount) && Intrinsics.areEqual((Object) this.SellerOfferAmount, (Object) mobileNegotiationsList.SellerOfferAmount) && Intrinsics.areEqual((Object) this.FormattedCurrentBidAmount, (Object) mobileNegotiationsList.FormattedCurrentBidAmount) && Intrinsics.areEqual((Object) this.AuctionDatetime, (Object) mobileNegotiationsList.AuctionDatetime) && Intrinsics.areEqual((Object) this.Year, (Object) mobileNegotiationsList.Year) && Intrinsics.areEqual((Object) this.Make, (Object) mobileNegotiationsList.Make) && Intrinsics.areEqual((Object) this.Model, (Object) mobileNegotiationsList.Model) && Intrinsics.areEqual((Object) this.Status, (Object) mobileNegotiationsList.Status) && Intrinsics.areEqual((Object) this.AuctionLane, (Object) mobileNegotiationsList.AuctionLane) && Intrinsics.areEqual((Object) this.BranchName, (Object) mobileNegotiationsList.BranchName) && Intrinsics.areEqual((Object) this.BranchState, (Object) mobileNegotiationsList.BranchState) && Intrinsics.areEqual((Object) this.FormattedBidIncrementAmount, (Object) mobileNegotiationsList.FormattedBidIncrementAmount) && Intrinsics.areEqual((Object) this.StockNumber, (Object) mobileNegotiationsList.StockNumber) && Intrinsics.areEqual((Object) this.SellerLiveRepAmount, (Object) mobileNegotiationsList.SellerLiveRepAmount) && Intrinsics.areEqual((Object) this.SalvageID, (Object) mobileNegotiationsList.SalvageID) && Intrinsics.areEqual((Object) this.ItemId, (Object) mobileNegotiationsList.ItemId) && Intrinsics.areEqual((Object) this.CurrentBidAmount, (Object) mobileNegotiationsList.CurrentBidAmount) && Intrinsics.areEqual((Object) this.BidAmount, (Object) mobileNegotiationsList.BidAmount) && Intrinsics.areEqual((Object) this.BranchCode, (Object) mobileNegotiationsList.BranchCode) && Intrinsics.areEqual((Object) this.RemainingBidderCounters, (Object) mobileNegotiationsList.RemainingBidderCounters) && Intrinsics.areEqual((Object) this.NegotiationAmount, (Object) mobileNegotiationsList.NegotiationAmount) && Intrinsics.areEqual((Object) this.NegotiationId, (Object) mobileNegotiationsList.NegotiationId) && Intrinsics.areEqual((Object) this.Slot, (Object) mobileNegotiationsList.Slot) && Intrinsics.areEqual((Object) this.ExternalAuctionId, (Object) mobileNegotiationsList.ExternalAuctionId) && Intrinsics.areEqual((Object) this.ExternalAuctionItemId, (Object) mobileNegotiationsList.ExternalAuctionItemId) && Intrinsics.areEqual((Object) this.isActionDone, (Object) mobileNegotiationsList.isActionDone) && Intrinsics.areEqual((Object) this.isBidHistoryVisible, (Object) mobileNegotiationsList.isBidHistoryVisible) && Intrinsics.areEqual((Object) this.remainingTime, (Object) mobileNegotiationsList.remainingTime)) {
                    if (!(this.IsCounterInitiated == mobileNegotiationsList.IsCounterInitiated) || !Intrinsics.areEqual((Object) this.ThumbnailImage, (Object) mobileNegotiationsList.ThumbnailImage)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.EventDateTime;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.ExpiryDatetime;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Eventtype;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.FormattedBidAmount;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.FormattedNegotiationAmount;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.FormattedSellerOfferAmount;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Long l = this.SellerOfferAmount;
        int hashCode7 = (hashCode6 + (l != null ? l.hashCode() : 0)) * 31;
        String str7 = this.FormattedCurrentBidAmount;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.AuctionDatetime;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        Integer num = this.Year;
        int hashCode10 = (hashCode9 + (num != null ? num.hashCode() : 0)) * 31;
        String str9 = this.Make;
        int hashCode11 = (hashCode10 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.Model;
        int hashCode12 = (hashCode11 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.Status;
        int hashCode13 = (hashCode12 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.AuctionLane;
        int hashCode14 = (hashCode13 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.BranchName;
        int hashCode15 = (hashCode14 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.BranchState;
        int hashCode16 = (hashCode15 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.FormattedBidIncrementAmount;
        int hashCode17 = (hashCode16 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.StockNumber;
        int hashCode18 = (hashCode17 + (str16 != null ? str16.hashCode() : 0)) * 31;
        Integer num2 = this.SellerLiveRepAmount;
        int hashCode19 = (hashCode18 + (num2 != null ? num2.hashCode() : 0)) * 31;
        Integer num3 = this.SalvageID;
        int hashCode20 = (hashCode19 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.ItemId;
        int hashCode21 = (hashCode20 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.CurrentBidAmount;
        int hashCode22 = (hashCode21 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Long l2 = this.BidAmount;
        int hashCode23 = (hashCode22 + (l2 != null ? l2.hashCode() : 0)) * 31;
        Integer num6 = this.BranchCode;
        int hashCode24 = (hashCode23 + (num6 != null ? num6.hashCode() : 0)) * 31;
        Integer num7 = this.RemainingBidderCounters;
        int hashCode25 = (hashCode24 + (num7 != null ? num7.hashCode() : 0)) * 31;
        Integer num8 = this.NegotiationAmount;
        int hashCode26 = (hashCode25 + (num8 != null ? num8.hashCode() : 0)) * 31;
        String str17 = this.NegotiationId;
        int hashCode27 = (hashCode26 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.Slot;
        int hashCode28 = (hashCode27 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.ExternalAuctionId;
        int hashCode29 = (hashCode28 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.ExternalAuctionItemId;
        int hashCode30 = (hashCode29 + (str20 != null ? str20.hashCode() : 0)) * 31;
        Boolean bool = this.isActionDone;
        int hashCode31 = (hashCode30 + (bool != null ? bool.hashCode() : 0)) * 31;
        Boolean bool2 = this.isBidHistoryVisible;
        int hashCode32 = (hashCode31 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        String str21 = this.remainingTime;
        int hashCode33 = (hashCode32 + (str21 != null ? str21.hashCode() : 0)) * 31;
        boolean z = this.IsCounterInitiated;
        if (z) {
            z = true;
        }
        int i2 = (hashCode33 + (z ? 1 : 0)) * 31;
        String str22 = this.ThumbnailImage;
        if (str22 != null) {
            i = str22.hashCode();
        }
        return i2 + i;
    }

    @NotNull
    public String toString() {
        return "MobileNegotiationsList(EventDateTime=" + this.EventDateTime + ", ExpiryDatetime=" + this.ExpiryDatetime + ", Eventtype=" + this.Eventtype + ", FormattedBidAmount=" + this.FormattedBidAmount + ", FormattedNegotiationAmount=" + this.FormattedNegotiationAmount + ", FormattedSellerOfferAmount=" + this.FormattedSellerOfferAmount + ", SellerOfferAmount=" + this.SellerOfferAmount + ", FormattedCurrentBidAmount=" + this.FormattedCurrentBidAmount + ", AuctionDatetime=" + this.AuctionDatetime + ", Year=" + this.Year + ", Make=" + this.Make + ", Model=" + this.Model + ", Status=" + this.Status + ", AuctionLane=" + this.AuctionLane + ", BranchName=" + this.BranchName + ", BranchState=" + this.BranchState + ", FormattedBidIncrementAmount=" + this.FormattedBidIncrementAmount + ", StockNumber=" + this.StockNumber + ", SellerLiveRepAmount=" + this.SellerLiveRepAmount + ", SalvageID=" + this.SalvageID + ", ItemId=" + this.ItemId + ", CurrentBidAmount=" + this.CurrentBidAmount + ", BidAmount=" + this.BidAmount + ", BranchCode=" + this.BranchCode + ", RemainingBidderCounters=" + this.RemainingBidderCounters + ", NegotiationAmount=" + this.NegotiationAmount + ", NegotiationId=" + this.NegotiationId + ", Slot=" + this.Slot + ", ExternalAuctionId=" + this.ExternalAuctionId + ", ExternalAuctionItemId=" + this.ExternalAuctionItemId + ", isActionDone=" + this.isActionDone + ", isBidHistoryVisible=" + this.isBidHistoryVisible + ", remainingTime=" + this.remainingTime + ", IsCounterInitiated=" + this.IsCounterInitiated + ", ThumbnailImage=" + this.ThumbnailImage + ")";
    }

    public MobileNegotiationsList(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Long l, @Nullable String str7, @Nullable String str8, @Nullable Integer num, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable Long l2, @Nullable Integer num6, @Nullable Integer num7, @Nullable Integer num8, @Nullable String str17, @Nullable String str18, @Nullable String str19, @Nullable String str20, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str21, boolean z, @Nullable String str22) {
        this.EventDateTime = str;
        this.ExpiryDatetime = str2;
        this.Eventtype = str3;
        this.FormattedBidAmount = str4;
        this.FormattedNegotiationAmount = str5;
        this.FormattedSellerOfferAmount = str6;
        this.SellerOfferAmount = l;
        this.FormattedCurrentBidAmount = str7;
        this.AuctionDatetime = str8;
        this.Year = num;
        this.Make = str9;
        this.Model = str10;
        this.Status = str11;
        this.AuctionLane = str12;
        this.BranchName = str13;
        this.BranchState = str14;
        this.FormattedBidIncrementAmount = str15;
        this.StockNumber = str16;
        this.SellerLiveRepAmount = num2;
        this.SalvageID = num3;
        this.ItemId = num4;
        this.CurrentBidAmount = num5;
        this.BidAmount = l2;
        this.BranchCode = num6;
        this.RemainingBidderCounters = num7;
        this.NegotiationAmount = num8;
        this.NegotiationId = str17;
        this.Slot = str18;
        this.ExternalAuctionId = str19;
        this.ExternalAuctionItemId = str20;
        this.isActionDone = bool;
        this.isBidHistoryVisible = bool2;
        this.remainingTime = str21;
        this.IsCounterInitiated = z;
        this.ThumbnailImage = str22;
    }

    @Nullable
    public final String getEventDateTime() {
        return this.EventDateTime;
    }

    @Nullable
    public final String getExpiryDatetime() {
        return this.ExpiryDatetime;
    }

    @Nullable
    public final String getEventtype() {
        return this.Eventtype;
    }

    public final void setEventtype(@Nullable String str) {
        this.Eventtype = str;
    }

    @Nullable
    public final String getFormattedBidAmount() {
        return this.FormattedBidAmount;
    }

    @Nullable
    public final String getFormattedNegotiationAmount() {
        return this.FormattedNegotiationAmount;
    }

    public final void setFormattedNegotiationAmount(@Nullable String str) {
        this.FormattedNegotiationAmount = str;
    }

    @Nullable
    public final String getFormattedSellerOfferAmount() {
        return this.FormattedSellerOfferAmount;
    }

    @Nullable
    public final Long getSellerOfferAmount() {
        return this.SellerOfferAmount;
    }

    @Nullable
    public final String getFormattedCurrentBidAmount() {
        return this.FormattedCurrentBidAmount;
    }

    public final void setFormattedCurrentBidAmount(@Nullable String str) {
        this.FormattedCurrentBidAmount = str;
    }

    @Nullable
    public final String getAuctionDatetime() {
        return this.AuctionDatetime;
    }

    @Nullable
    public final Integer getYear() {
        return this.Year;
    }

    @Nullable
    public final String getMake() {
        return this.Make;
    }

    @Nullable
    public final String getModel() {
        return this.Model;
    }

    @Nullable
    public final String getStatus() {
        return this.Status;
    }

    public final void setStatus(@Nullable String str) {
        this.Status = str;
    }

    @Nullable
    public final String getAuctionLane() {
        return this.AuctionLane;
    }

    @Nullable
    public final String getBranchName() {
        return this.BranchName;
    }

    @Nullable
    public final String getBranchState() {
        return this.BranchState;
    }

    @Nullable
    public final String getFormattedBidIncrementAmount() {
        return this.FormattedBidIncrementAmount;
    }

    @Nullable
    public final String getStockNumber() {
        return this.StockNumber;
    }

    @Nullable
    public final Integer getSellerLiveRepAmount() {
        return this.SellerLiveRepAmount;
    }

    @Nullable
    public final Integer getSalvageID() {
        return this.SalvageID;
    }

    @Nullable
    public final Integer getItemId() {
        return this.ItemId;
    }

    @Nullable
    public final Integer getCurrentBidAmount() {
        return this.CurrentBidAmount;
    }

    @Nullable
    public final Long getBidAmount() {
        return this.BidAmount;
    }

    @Nullable
    public final Integer getBranchCode() {
        return this.BranchCode;
    }

    @Nullable
    public final Integer getRemainingBidderCounters() {
        return this.RemainingBidderCounters;
    }

    public final void setRemainingBidderCounters(@Nullable Integer num) {
        this.RemainingBidderCounters = num;
    }

    @Nullable
    public final Integer getNegotiationAmount() {
        return this.NegotiationAmount;
    }

    @Nullable
    public final String getNegotiationId() {
        return this.NegotiationId;
    }

    @Nullable
    public final String getSlot() {
        return this.Slot;
    }

    @Nullable
    public final String getExternalAuctionId() {
        return this.ExternalAuctionId;
    }

    @Nullable
    public final String getExternalAuctionItemId() {
        return this.ExternalAuctionItemId;
    }

    @Nullable
    public final Boolean isActionDone() {
        return this.isActionDone;
    }

    @Nullable
    public final Boolean isBidHistoryVisible() {
        return this.isBidHistoryVisible;
    }

    public final void setBidHistoryVisible(@Nullable Boolean bool) {
        this.isBidHistoryVisible = bool;
    }

    @Nullable
    public final String getRemainingTime() {
        return this.remainingTime;
    }

    public final void setRemainingTime(@Nullable String str) {
        this.remainingTime = str;
    }

    public final boolean getIsCounterInitiated() {
        return this.IsCounterInitiated;
    }

    @Nullable
    public final String getThumbnailImage() {
        return this.ThumbnailImage;
    }
}
