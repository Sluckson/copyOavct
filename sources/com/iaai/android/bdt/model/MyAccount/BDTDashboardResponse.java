package com.iaai.android.bdt.model.MyAccount;

import com.lowagie.text.pdf.PdfFormField;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\bQ\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0017\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0017\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\"J\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010H\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\u0010\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010N\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010O\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010R\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010S\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010T\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010(J\u0010\u0010U\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u0010(J\u000b\u0010V\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u0010\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010$JÜ\u0002\u0010b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010cJ\u0013\u0010d\u001a\u00020\u00152\b\u0010e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010f\u001a\u00020\u0003HÖ\u0001J\t\u0010g\u001a\u00020\u0017HÖ\u0001R\u0015\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0015\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b&\u0010$R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b,\u0010$R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b2\u00100R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010)\u001a\u0004\b3\u0010(R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b4\u0010$R\u0015\u0010!\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b5\u0010$R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b6\u0010$R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\b7\u0010$R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b8\u00100R\u0015\u0010\u001b\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010)\u001a\u0004\b9\u0010(R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b:\u00100R\u0015\u0010\u0019\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010)\u001a\u0004\b;\u0010(R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b<\u0010.R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u0010.R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b>\u0010.R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u0010.R\u0013\u0010 \u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b@\u00100R\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0015¢\u0006\n\n\u0002\u0010)\u001a\u0004\bA\u0010(R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bB\u0010.R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\bC\u0010$R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\bD\u0010$R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010%\u001a\u0004\bE\u0010$¨\u0006h"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/BDTDashboardResponse;", "", "Outbid", "", "Pickup", "TotalCurrentBids", "Ljava/math/BigDecimal;", "TotalMaxBids", "TotaltobePaid", "TotalAwardPending", "VehiclesOnly", "WinningPrebids", "Alerts", "AwardPending", "FeeOnly", "Lost", "Watching", "Won", "CountofFeeItems", "Countofvehicles", "BiddingBenchMark", "", "InfographicPeriod", "", "InfographicMonth", "RenewalLinkInd", "LincenseLinkInd", "ProfileLinkInd", "UpgradeLinkInd", "RenewalLink", "LicenseLink", "ProfileLink", "UpgradeLink", "NegotiationOffers", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAlerts", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getAwardPending", "getBiddingBenchMark", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCountofFeeItems", "()I", "getCountofvehicles", "getFeeOnly", "()Ljava/math/BigDecimal;", "getInfographicMonth", "()Ljava/lang/String;", "getInfographicPeriod", "getLicenseLink", "getLincenseLinkInd", "getLost", "getNegotiationOffers", "getOutbid", "getPickup", "getProfileLink", "getProfileLinkInd", "getRenewalLink", "getRenewalLinkInd", "getTotalAwardPending", "getTotalCurrentBids", "getTotalMaxBids", "getTotaltobePaid", "getUpgradeLink", "getUpgradeLinkInd", "getVehiclesOnly", "getWatching", "getWinningPrebids", "getWon", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/iaai/android/bdt/model/MyAccount/BDTDashboardResponse;", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BDTDashboardResponse.kt */
public final class BDTDashboardResponse {
    @Nullable
    private final Integer Alerts;
    @Nullable
    private final Integer AwardPending;
    @Nullable
    private final Boolean BiddingBenchMark;
    private final int CountofFeeItems;
    @Nullable
    private final Integer Countofvehicles;
    @Nullable
    private final BigDecimal FeeOnly;
    @Nullable
    private final String InfographicMonth;
    @Nullable
    private final String InfographicPeriod;
    @Nullable
    private final String LicenseLink;
    @Nullable
    private final Boolean LincenseLinkInd;
    @Nullable
    private final Integer Lost;
    @Nullable
    private final Integer NegotiationOffers;
    @Nullable
    private final Integer Outbid;
    @Nullable
    private final Integer Pickup;
    @Nullable
    private final String ProfileLink;
    @Nullable
    private final Boolean ProfileLinkInd;
    @Nullable
    private final String RenewalLink;
    @Nullable
    private final Boolean RenewalLinkInd;
    @Nullable
    private final BigDecimal TotalAwardPending;
    @Nullable
    private final BigDecimal TotalCurrentBids;
    @Nullable
    private final BigDecimal TotalMaxBids;
    @Nullable
    private final BigDecimal TotaltobePaid;
    @Nullable
    private final String UpgradeLink;
    @Nullable
    private final Boolean UpgradeLinkInd;
    @Nullable
    private final BigDecimal VehiclesOnly;
    @Nullable
    private final Integer Watching;
    @Nullable
    private final Integer WinningPrebids;
    @Nullable
    private final Integer Won;

    @NotNull
    public static /* synthetic */ BDTDashboardResponse copy$default(BDTDashboardResponse bDTDashboardResponse, Integer num, Integer num2, BigDecimal bigDecimal, BigDecimal bigDecimal2, BigDecimal bigDecimal3, BigDecimal bigDecimal4, BigDecimal bigDecimal5, Integer num3, Integer num4, Integer num5, BigDecimal bigDecimal6, Integer num6, Integer num7, Integer num8, int i, Integer num9, Boolean bool, String str, String str2, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str3, String str4, String str5, String str6, Integer num10, int i2, Object obj) {
        int i3;
        Integer num11;
        Integer num12;
        Boolean bool6;
        Boolean bool7;
        String str7;
        String str8;
        String str9;
        String str10;
        Boolean bool8;
        Boolean bool9;
        Boolean bool10;
        Boolean bool11;
        Boolean bool12;
        Boolean bool13;
        Boolean bool14;
        Boolean bool15;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        BDTDashboardResponse bDTDashboardResponse2 = bDTDashboardResponse;
        int i4 = i2;
        Integer num13 = (i4 & 1) != 0 ? bDTDashboardResponse2.Outbid : num;
        Integer num14 = (i4 & 2) != 0 ? bDTDashboardResponse2.Pickup : num2;
        BigDecimal bigDecimal7 = (i4 & 4) != 0 ? bDTDashboardResponse2.TotalCurrentBids : bigDecimal;
        BigDecimal bigDecimal8 = (i4 & 8) != 0 ? bDTDashboardResponse2.TotalMaxBids : bigDecimal2;
        BigDecimal bigDecimal9 = (i4 & 16) != 0 ? bDTDashboardResponse2.TotaltobePaid : bigDecimal3;
        BigDecimal bigDecimal10 = (i4 & 32) != 0 ? bDTDashboardResponse2.TotalAwardPending : bigDecimal4;
        BigDecimal bigDecimal11 = (i4 & 64) != 0 ? bDTDashboardResponse2.VehiclesOnly : bigDecimal5;
        Integer num15 = (i4 & 128) != 0 ? bDTDashboardResponse2.WinningPrebids : num3;
        Integer num16 = (i4 & 256) != 0 ? bDTDashboardResponse2.Alerts : num4;
        Integer num17 = (i4 & 512) != 0 ? bDTDashboardResponse2.AwardPending : num5;
        BigDecimal bigDecimal12 = (i4 & 1024) != 0 ? bDTDashboardResponse2.FeeOnly : bigDecimal6;
        Integer num18 = (i4 & 2048) != 0 ? bDTDashboardResponse2.Lost : num6;
        Integer num19 = (i4 & 4096) != 0 ? bDTDashboardResponse2.Watching : num7;
        Integer num20 = (i4 & 8192) != 0 ? bDTDashboardResponse2.Won : num8;
        int i5 = (i4 & 16384) != 0 ? bDTDashboardResponse2.CountofFeeItems : i;
        if ((i4 & 32768) != 0) {
            i3 = i5;
            num11 = bDTDashboardResponse2.Countofvehicles;
        } else {
            i3 = i5;
            num11 = num9;
        }
        if ((i4 & 65536) != 0) {
            num12 = num11;
            bool6 = bDTDashboardResponse2.BiddingBenchMark;
        } else {
            num12 = num11;
            bool6 = bool;
        }
        if ((i4 & 131072) != 0) {
            bool7 = bool6;
            str7 = bDTDashboardResponse2.InfographicPeriod;
        } else {
            bool7 = bool6;
            str7 = str;
        }
        if ((i4 & 262144) != 0) {
            str8 = str7;
            str9 = bDTDashboardResponse2.InfographicMonth;
        } else {
            str8 = str7;
            str9 = str2;
        }
        if ((i4 & 524288) != 0) {
            str10 = str9;
            bool8 = bDTDashboardResponse2.RenewalLinkInd;
        } else {
            str10 = str9;
            bool8 = bool2;
        }
        if ((i4 & 1048576) != 0) {
            bool9 = bool8;
            bool10 = bDTDashboardResponse2.LincenseLinkInd;
        } else {
            bool9 = bool8;
            bool10 = bool3;
        }
        if ((i4 & 2097152) != 0) {
            bool11 = bool10;
            bool12 = bDTDashboardResponse2.ProfileLinkInd;
        } else {
            bool11 = bool10;
            bool12 = bool4;
        }
        if ((i4 & 4194304) != 0) {
            bool13 = bool12;
            bool14 = bDTDashboardResponse2.UpgradeLinkInd;
        } else {
            bool13 = bool12;
            bool14 = bool5;
        }
        if ((i4 & 8388608) != 0) {
            bool15 = bool14;
            str11 = bDTDashboardResponse2.RenewalLink;
        } else {
            bool15 = bool14;
            str11 = str3;
        }
        if ((i4 & 16777216) != 0) {
            str12 = str11;
            str13 = bDTDashboardResponse2.LicenseLink;
        } else {
            str12 = str11;
            str13 = str4;
        }
        if ((i4 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            str14 = str13;
            str15 = bDTDashboardResponse2.ProfileLink;
        } else {
            str14 = str13;
            str15 = str5;
        }
        if ((i4 & 67108864) != 0) {
            str16 = str15;
            str17 = bDTDashboardResponse2.UpgradeLink;
        } else {
            str16 = str15;
            str17 = str6;
        }
        return bDTDashboardResponse.copy(num13, num14, bigDecimal7, bigDecimal8, bigDecimal9, bigDecimal10, bigDecimal11, num15, num16, num17, bigDecimal12, num18, num19, num20, i3, num12, bool7, str8, str10, bool9, bool11, bool13, bool15, str12, str14, str16, str17, (i4 & 134217728) != 0 ? bDTDashboardResponse2.NegotiationOffers : num10);
    }

    @Nullable
    public final Integer component1() {
        return this.Outbid;
    }

    @Nullable
    public final Integer component10() {
        return this.AwardPending;
    }

    @Nullable
    public final BigDecimal component11() {
        return this.FeeOnly;
    }

    @Nullable
    public final Integer component12() {
        return this.Lost;
    }

    @Nullable
    public final Integer component13() {
        return this.Watching;
    }

    @Nullable
    public final Integer component14() {
        return this.Won;
    }

    public final int component15() {
        return this.CountofFeeItems;
    }

    @Nullable
    public final Integer component16() {
        return this.Countofvehicles;
    }

    @Nullable
    public final Boolean component17() {
        return this.BiddingBenchMark;
    }

    @Nullable
    public final String component18() {
        return this.InfographicPeriod;
    }

    @Nullable
    public final String component19() {
        return this.InfographicMonth;
    }

    @Nullable
    public final Integer component2() {
        return this.Pickup;
    }

    @Nullable
    public final Boolean component20() {
        return this.RenewalLinkInd;
    }

    @Nullable
    public final Boolean component21() {
        return this.LincenseLinkInd;
    }

    @Nullable
    public final Boolean component22() {
        return this.ProfileLinkInd;
    }

    @Nullable
    public final Boolean component23() {
        return this.UpgradeLinkInd;
    }

    @Nullable
    public final String component24() {
        return this.RenewalLink;
    }

    @Nullable
    public final String component25() {
        return this.LicenseLink;
    }

    @Nullable
    public final String component26() {
        return this.ProfileLink;
    }

    @Nullable
    public final String component27() {
        return this.UpgradeLink;
    }

    @Nullable
    public final Integer component28() {
        return this.NegotiationOffers;
    }

    @Nullable
    public final BigDecimal component3() {
        return this.TotalCurrentBids;
    }

    @Nullable
    public final BigDecimal component4() {
        return this.TotalMaxBids;
    }

    @Nullable
    public final BigDecimal component5() {
        return this.TotaltobePaid;
    }

    @Nullable
    public final BigDecimal component6() {
        return this.TotalAwardPending;
    }

    @Nullable
    public final BigDecimal component7() {
        return this.VehiclesOnly;
    }

    @Nullable
    public final Integer component8() {
        return this.WinningPrebids;
    }

    @Nullable
    public final Integer component9() {
        return this.Alerts;
    }

    @NotNull
    public final BDTDashboardResponse copy(@Nullable Integer num, @Nullable Integer num2, @Nullable BigDecimal bigDecimal, @Nullable BigDecimal bigDecimal2, @Nullable BigDecimal bigDecimal3, @Nullable BigDecimal bigDecimal4, @Nullable BigDecimal bigDecimal5, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable BigDecimal bigDecimal6, @Nullable Integer num6, @Nullable Integer num7, @Nullable Integer num8, int i, @Nullable Integer num9, @Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Integer num10) {
        return new BDTDashboardResponse(num, num2, bigDecimal, bigDecimal2, bigDecimal3, bigDecimal4, bigDecimal5, num3, num4, num5, bigDecimal6, num6, num7, num8, i, num9, bool, str, str2, bool2, bool3, bool4, bool5, str3, str4, str5, str6, num10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof BDTDashboardResponse) {
                BDTDashboardResponse bDTDashboardResponse = (BDTDashboardResponse) obj;
                if (Intrinsics.areEqual((Object) this.Outbid, (Object) bDTDashboardResponse.Outbid) && Intrinsics.areEqual((Object) this.Pickup, (Object) bDTDashboardResponse.Pickup) && Intrinsics.areEqual((Object) this.TotalCurrentBids, (Object) bDTDashboardResponse.TotalCurrentBids) && Intrinsics.areEqual((Object) this.TotalMaxBids, (Object) bDTDashboardResponse.TotalMaxBids) && Intrinsics.areEqual((Object) this.TotaltobePaid, (Object) bDTDashboardResponse.TotaltobePaid) && Intrinsics.areEqual((Object) this.TotalAwardPending, (Object) bDTDashboardResponse.TotalAwardPending) && Intrinsics.areEqual((Object) this.VehiclesOnly, (Object) bDTDashboardResponse.VehiclesOnly) && Intrinsics.areEqual((Object) this.WinningPrebids, (Object) bDTDashboardResponse.WinningPrebids) && Intrinsics.areEqual((Object) this.Alerts, (Object) bDTDashboardResponse.Alerts) && Intrinsics.areEqual((Object) this.AwardPending, (Object) bDTDashboardResponse.AwardPending) && Intrinsics.areEqual((Object) this.FeeOnly, (Object) bDTDashboardResponse.FeeOnly) && Intrinsics.areEqual((Object) this.Lost, (Object) bDTDashboardResponse.Lost) && Intrinsics.areEqual((Object) this.Watching, (Object) bDTDashboardResponse.Watching) && Intrinsics.areEqual((Object) this.Won, (Object) bDTDashboardResponse.Won)) {
                    if (!(this.CountofFeeItems == bDTDashboardResponse.CountofFeeItems) || !Intrinsics.areEqual((Object) this.Countofvehicles, (Object) bDTDashboardResponse.Countofvehicles) || !Intrinsics.areEqual((Object) this.BiddingBenchMark, (Object) bDTDashboardResponse.BiddingBenchMark) || !Intrinsics.areEqual((Object) this.InfographicPeriod, (Object) bDTDashboardResponse.InfographicPeriod) || !Intrinsics.areEqual((Object) this.InfographicMonth, (Object) bDTDashboardResponse.InfographicMonth) || !Intrinsics.areEqual((Object) this.RenewalLinkInd, (Object) bDTDashboardResponse.RenewalLinkInd) || !Intrinsics.areEqual((Object) this.LincenseLinkInd, (Object) bDTDashboardResponse.LincenseLinkInd) || !Intrinsics.areEqual((Object) this.ProfileLinkInd, (Object) bDTDashboardResponse.ProfileLinkInd) || !Intrinsics.areEqual((Object) this.UpgradeLinkInd, (Object) bDTDashboardResponse.UpgradeLinkInd) || !Intrinsics.areEqual((Object) this.RenewalLink, (Object) bDTDashboardResponse.RenewalLink) || !Intrinsics.areEqual((Object) this.LicenseLink, (Object) bDTDashboardResponse.LicenseLink) || !Intrinsics.areEqual((Object) this.ProfileLink, (Object) bDTDashboardResponse.ProfileLink) || !Intrinsics.areEqual((Object) this.UpgradeLink, (Object) bDTDashboardResponse.UpgradeLink) || !Intrinsics.areEqual((Object) this.NegotiationOffers, (Object) bDTDashboardResponse.NegotiationOffers)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        Integer num = this.Outbid;
        int i = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        Integer num2 = this.Pickup;
        int hashCode2 = (hashCode + (num2 != null ? num2.hashCode() : 0)) * 31;
        BigDecimal bigDecimal = this.TotalCurrentBids;
        int hashCode3 = (hashCode2 + (bigDecimal != null ? bigDecimal.hashCode() : 0)) * 31;
        BigDecimal bigDecimal2 = this.TotalMaxBids;
        int hashCode4 = (hashCode3 + (bigDecimal2 != null ? bigDecimal2.hashCode() : 0)) * 31;
        BigDecimal bigDecimal3 = this.TotaltobePaid;
        int hashCode5 = (hashCode4 + (bigDecimal3 != null ? bigDecimal3.hashCode() : 0)) * 31;
        BigDecimal bigDecimal4 = this.TotalAwardPending;
        int hashCode6 = (hashCode5 + (bigDecimal4 != null ? bigDecimal4.hashCode() : 0)) * 31;
        BigDecimal bigDecimal5 = this.VehiclesOnly;
        int hashCode7 = (hashCode6 + (bigDecimal5 != null ? bigDecimal5.hashCode() : 0)) * 31;
        Integer num3 = this.WinningPrebids;
        int hashCode8 = (hashCode7 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.Alerts;
        int hashCode9 = (hashCode8 + (num4 != null ? num4.hashCode() : 0)) * 31;
        Integer num5 = this.AwardPending;
        int hashCode10 = (hashCode9 + (num5 != null ? num5.hashCode() : 0)) * 31;
        BigDecimal bigDecimal6 = this.FeeOnly;
        int hashCode11 = (hashCode10 + (bigDecimal6 != null ? bigDecimal6.hashCode() : 0)) * 31;
        Integer num6 = this.Lost;
        int hashCode12 = (hashCode11 + (num6 != null ? num6.hashCode() : 0)) * 31;
        Integer num7 = this.Watching;
        int hashCode13 = (hashCode12 + (num7 != null ? num7.hashCode() : 0)) * 31;
        Integer num8 = this.Won;
        int hashCode14 = (((hashCode13 + (num8 != null ? num8.hashCode() : 0)) * 31) + Integer.valueOf(this.CountofFeeItems).hashCode()) * 31;
        Integer num9 = this.Countofvehicles;
        int hashCode15 = (hashCode14 + (num9 != null ? num9.hashCode() : 0)) * 31;
        Boolean bool = this.BiddingBenchMark;
        int hashCode16 = (hashCode15 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str = this.InfographicPeriod;
        int hashCode17 = (hashCode16 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.InfographicMonth;
        int hashCode18 = (hashCode17 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Boolean bool2 = this.RenewalLinkInd;
        int hashCode19 = (hashCode18 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        Boolean bool3 = this.LincenseLinkInd;
        int hashCode20 = (hashCode19 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        Boolean bool4 = this.ProfileLinkInd;
        int hashCode21 = (hashCode20 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        Boolean bool5 = this.UpgradeLinkInd;
        int hashCode22 = (hashCode21 + (bool5 != null ? bool5.hashCode() : 0)) * 31;
        String str3 = this.RenewalLink;
        int hashCode23 = (hashCode22 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.LicenseLink;
        int hashCode24 = (hashCode23 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.ProfileLink;
        int hashCode25 = (hashCode24 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.UpgradeLink;
        int hashCode26 = (hashCode25 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Integer num10 = this.NegotiationOffers;
        if (num10 != null) {
            i = num10.hashCode();
        }
        return hashCode26 + i;
    }

    @NotNull
    public String toString() {
        return "BDTDashboardResponse(Outbid=" + this.Outbid + ", Pickup=" + this.Pickup + ", TotalCurrentBids=" + this.TotalCurrentBids + ", TotalMaxBids=" + this.TotalMaxBids + ", TotaltobePaid=" + this.TotaltobePaid + ", TotalAwardPending=" + this.TotalAwardPending + ", VehiclesOnly=" + this.VehiclesOnly + ", WinningPrebids=" + this.WinningPrebids + ", Alerts=" + this.Alerts + ", AwardPending=" + this.AwardPending + ", FeeOnly=" + this.FeeOnly + ", Lost=" + this.Lost + ", Watching=" + this.Watching + ", Won=" + this.Won + ", CountofFeeItems=" + this.CountofFeeItems + ", Countofvehicles=" + this.Countofvehicles + ", BiddingBenchMark=" + this.BiddingBenchMark + ", InfographicPeriod=" + this.InfographicPeriod + ", InfographicMonth=" + this.InfographicMonth + ", RenewalLinkInd=" + this.RenewalLinkInd + ", LincenseLinkInd=" + this.LincenseLinkInd + ", ProfileLinkInd=" + this.ProfileLinkInd + ", UpgradeLinkInd=" + this.UpgradeLinkInd + ", RenewalLink=" + this.RenewalLink + ", LicenseLink=" + this.LicenseLink + ", ProfileLink=" + this.ProfileLink + ", UpgradeLink=" + this.UpgradeLink + ", NegotiationOffers=" + this.NegotiationOffers + ")";
    }

    public BDTDashboardResponse(@Nullable Integer num, @Nullable Integer num2, @Nullable BigDecimal bigDecimal, @Nullable BigDecimal bigDecimal2, @Nullable BigDecimal bigDecimal3, @Nullable BigDecimal bigDecimal4, @Nullable BigDecimal bigDecimal5, @Nullable Integer num3, @Nullable Integer num4, @Nullable Integer num5, @Nullable BigDecimal bigDecimal6, @Nullable Integer num6, @Nullable Integer num7, @Nullable Integer num8, int i, @Nullable Integer num9, @Nullable Boolean bool, @Nullable String str, @Nullable String str2, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Integer num10) {
        this.Outbid = num;
        this.Pickup = num2;
        this.TotalCurrentBids = bigDecimal;
        this.TotalMaxBids = bigDecimal2;
        this.TotaltobePaid = bigDecimal3;
        this.TotalAwardPending = bigDecimal4;
        this.VehiclesOnly = bigDecimal5;
        this.WinningPrebids = num3;
        this.Alerts = num4;
        this.AwardPending = num5;
        this.FeeOnly = bigDecimal6;
        this.Lost = num6;
        this.Watching = num7;
        this.Won = num8;
        this.CountofFeeItems = i;
        this.Countofvehicles = num9;
        this.BiddingBenchMark = bool;
        this.InfographicPeriod = str;
        this.InfographicMonth = str2;
        this.RenewalLinkInd = bool2;
        this.LincenseLinkInd = bool3;
        this.ProfileLinkInd = bool4;
        this.UpgradeLinkInd = bool5;
        this.RenewalLink = str3;
        this.LicenseLink = str4;
        this.ProfileLink = str5;
        this.UpgradeLink = str6;
        this.NegotiationOffers = num10;
    }

    @Nullable
    public final Integer getOutbid() {
        return this.Outbid;
    }

    @Nullable
    public final Integer getPickup() {
        return this.Pickup;
    }

    @Nullable
    public final BigDecimal getTotalCurrentBids() {
        return this.TotalCurrentBids;
    }

    @Nullable
    public final BigDecimal getTotalMaxBids() {
        return this.TotalMaxBids;
    }

    @Nullable
    public final BigDecimal getTotaltobePaid() {
        return this.TotaltobePaid;
    }

    @Nullable
    public final BigDecimal getTotalAwardPending() {
        return this.TotalAwardPending;
    }

    @Nullable
    public final BigDecimal getVehiclesOnly() {
        return this.VehiclesOnly;
    }

    @Nullable
    public final Integer getWinningPrebids() {
        return this.WinningPrebids;
    }

    @Nullable
    public final Integer getAlerts() {
        return this.Alerts;
    }

    @Nullable
    public final Integer getAwardPending() {
        return this.AwardPending;
    }

    @Nullable
    public final BigDecimal getFeeOnly() {
        return this.FeeOnly;
    }

    @Nullable
    public final Integer getLost() {
        return this.Lost;
    }

    @Nullable
    public final Integer getWatching() {
        return this.Watching;
    }

    @Nullable
    public final Integer getWon() {
        return this.Won;
    }

    public final int getCountofFeeItems() {
        return this.CountofFeeItems;
    }

    @Nullable
    public final Integer getCountofvehicles() {
        return this.Countofvehicles;
    }

    @Nullable
    public final Boolean getBiddingBenchMark() {
        return this.BiddingBenchMark;
    }

    @Nullable
    public final String getInfographicPeriod() {
        return this.InfographicPeriod;
    }

    @Nullable
    public final String getInfographicMonth() {
        return this.InfographicMonth;
    }

    @Nullable
    public final Boolean getRenewalLinkInd() {
        return this.RenewalLinkInd;
    }

    @Nullable
    public final Boolean getLincenseLinkInd() {
        return this.LincenseLinkInd;
    }

    @Nullable
    public final Boolean getProfileLinkInd() {
        return this.ProfileLinkInd;
    }

    @Nullable
    public final Boolean getUpgradeLinkInd() {
        return this.UpgradeLinkInd;
    }

    @Nullable
    public final String getRenewalLink() {
        return this.RenewalLink;
    }

    @Nullable
    public final String getLicenseLink() {
        return this.LicenseLink;
    }

    @Nullable
    public final String getProfileLink() {
        return this.ProfileLink;
    }

    @Nullable
    public final String getUpgradeLink() {
        return this.UpgradeLink;
    }

    @Nullable
    public final Integer getNegotiationOffers() {
        return this.NegotiationOffers;
    }
}
