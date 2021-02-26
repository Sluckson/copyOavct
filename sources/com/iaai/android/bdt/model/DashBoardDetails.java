package com.iaai.android.bdt.model;

import com.google.android.exoplayer2.C1119C;
import com.lowagie.text.pdf.PdfFormField;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000)\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0003\b\u0001\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010#J\t\u0010l\u001a\u00020\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0006HÆ\u0003J\t\u0010n\u001a\u00020\u0003HÆ\u0003J\u0010\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u000b\u0010q\u001a\u0004\u0018\u00010\fHÆ\u0003J\u0010\u0010r\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010+J\t\u0010s\u001a\u00020\fHÆ\u0003J\u0010\u0010t\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010u\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010{\u001a\u00020\fHÆ\u0003J\u0010\u0010|\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010}\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010~\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010+J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u00100J\n\u0010\u0001\u001a\u00020\nHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\fHÆ\u0003J\n\u0010\u0001\u001a\u00020\fHÆ\u0003JÜ\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0015\u001a\u00020\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001c\u001a\u00020\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0003\u0010\u0001J\u0015\u0010\u0001\u001a\u00020\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\u0003HÖ\u0001J\n\u0010\u0001\u001a\u00020\fHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\b4\u00100\"\u0004\b5\u00102R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001c\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010;\"\u0004\b?\u0010=R\u001a\u0010\u000e\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010;\"\u0004\bA\u0010=R\u001a\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010\u0010\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010%\"\u0004\bG\u0010'R\u001e\u0010\"\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\bH\u00100\"\u0004\bI\u00102R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\bJ\u00100\"\u0004\bK\u00102R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\bL\u00100\"\u0004\bM\u00102R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010;\"\u0004\bO\u0010=R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bP\u0010+\"\u0004\bQ\u0010-R\u001a\u0010\u0015\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010;\"\u0004\bS\u0010=R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bT\u0010+\"\u0004\bU\u0010-R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010;\"\u0004\bW\u0010=R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u00107\"\u0004\bY\u00109R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u00107\"\u0004\b[\u00109R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u00107\"\u0004\b]\u00109R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u00107\"\u0004\b_\u00109R\u001a\u0010\u001c\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010;\"\u0004\ba\u0010=R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\bb\u0010+\"\u0004\bc\u0010-R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u00107\"\u0004\be\u00109R\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\bf\u00100\"\u0004\bg\u00102R\u001e\u0010 \u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\bh\u00100\"\u0004\bi\u00102R\u001e\u0010!\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u00103\u001a\u0004\bj\u00100\"\u0004\bk\u00102¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/DashBoardDetails;", "", "Alerts", "", "AwardPending", "BiddingBenchMark", "", "CountofFeeItems", "Countofvehicles", "FeeOnly", "Ljava/math/BigDecimal;", "InfographicMonth", "", "InfographicPeriod", "LicenseLink", "LincenseLinkInd", "Lost", "Outbid", "Pickup", "ProfileLink", "ProfileLinkInd", "RenewalLink", "RenewalLinkInd", "RenewalMessage", "TotalAwardPending", "TotalCurrentBids", "TotalMaxBids", "TotaltobePaid", "UpgradeLink", "UpgradeLinkInd", "VehiclesOnly", "Watching", "WinningPrebids", "Won", "NegotiationOffers", "(IILjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/Boolean;Ljava/math/BigDecimal;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getAlerts", "()I", "setAlerts", "(I)V", "getAwardPending", "setAwardPending", "getBiddingBenchMark", "()Ljava/lang/Boolean;", "setBiddingBenchMark", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getCountofFeeItems", "()Ljava/lang/Integer;", "setCountofFeeItems", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getCountofvehicles", "setCountofvehicles", "getFeeOnly", "()Ljava/math/BigDecimal;", "setFeeOnly", "(Ljava/math/BigDecimal;)V", "getInfographicMonth", "()Ljava/lang/String;", "setInfographicMonth", "(Ljava/lang/String;)V", "getInfographicPeriod", "setInfographicPeriod", "getLicenseLink", "setLicenseLink", "getLincenseLinkInd", "()Z", "setLincenseLinkInd", "(Z)V", "getLost", "setLost", "getNegotiationOffers", "setNegotiationOffers", "getOutbid", "setOutbid", "getPickup", "setPickup", "getProfileLink", "setProfileLink", "getProfileLinkInd", "setProfileLinkInd", "getRenewalLink", "setRenewalLink", "getRenewalLinkInd", "setRenewalLinkInd", "getRenewalMessage", "setRenewalMessage", "getTotalAwardPending", "setTotalAwardPending", "getTotalCurrentBids", "setTotalCurrentBids", "getTotalMaxBids", "setTotalMaxBids", "getTotaltobePaid", "setTotaltobePaid", "getUpgradeLink", "setUpgradeLink", "getUpgradeLinkInd", "setUpgradeLinkInd", "getVehiclesOnly", "setVehiclesOnly", "getWatching", "setWatching", "getWinningPrebids", "setWinningPrebids", "getWon", "setWon", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(IILjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/lang/String;Ljava/lang/Boolean;Ljava/math/BigDecimal;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/iaai/android/bdt/model/DashBoardDetails;", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: DashBoardDetails.kt */
public final class DashBoardDetails {
    private int Alerts;
    private int AwardPending;
    @Nullable
    private Boolean BiddingBenchMark;
    @Nullable
    private Integer CountofFeeItems;
    @Nullable
    private Integer Countofvehicles;
    @NotNull
    private BigDecimal FeeOnly;
    @Nullable
    private String InfographicMonth;
    @Nullable
    private String InfographicPeriod;
    @NotNull
    private String LicenseLink;
    private boolean LincenseLinkInd;
    private int Lost;
    @Nullable
    private Integer NegotiationOffers;
    @Nullable
    private Integer Outbid;
    @Nullable
    private Integer Pickup;
    @Nullable
    private String ProfileLink;
    @Nullable
    private Boolean ProfileLinkInd;
    @NotNull
    private String RenewalLink;
    @Nullable
    private Boolean RenewalLinkInd;
    @Nullable
    private String RenewalMessage;
    @Nullable
    private BigDecimal TotalAwardPending;
    @Nullable
    private BigDecimal TotalCurrentBids;
    @Nullable
    private BigDecimal TotalMaxBids;
    @Nullable
    private BigDecimal TotaltobePaid;
    @NotNull
    private String UpgradeLink;
    @Nullable
    private Boolean UpgradeLinkInd;
    @Nullable
    private BigDecimal VehiclesOnly;
    @Nullable
    private Integer Watching;
    @Nullable
    private Integer WinningPrebids;
    @Nullable
    private Integer Won;

    @NotNull
    public static /* synthetic */ DashBoardDetails copy$default(DashBoardDetails dashBoardDetails, int i, int i2, Boolean bool, Integer num, Integer num2, BigDecimal bigDecimal, String str, String str2, String str3, boolean z, int i3, Integer num3, Integer num4, String str4, Boolean bool2, String str5, Boolean bool3, String str6, BigDecimal bigDecimal2, BigDecimal bigDecimal3, BigDecimal bigDecimal4, BigDecimal bigDecimal5, String str7, Boolean bool4, BigDecimal bigDecimal6, Integer num5, Integer num6, Integer num7, Integer num8, int i4, Object obj) {
        Boolean bool5;
        String str8;
        String str9;
        Boolean bool6;
        Boolean bool7;
        String str10;
        String str11;
        BigDecimal bigDecimal7;
        BigDecimal bigDecimal8;
        BigDecimal bigDecimal9;
        BigDecimal bigDecimal10;
        BigDecimal bigDecimal11;
        BigDecimal bigDecimal12;
        BigDecimal bigDecimal13;
        BigDecimal bigDecimal14;
        String str12;
        String str13;
        Boolean bool8;
        Boolean bool9;
        BigDecimal bigDecimal15;
        BigDecimal bigDecimal16;
        Integer num9;
        Integer num10;
        Integer num11;
        Integer num12;
        Integer num13;
        DashBoardDetails dashBoardDetails2 = dashBoardDetails;
        int i5 = i4;
        int i6 = (i5 & 1) != 0 ? dashBoardDetails2.Alerts : i;
        int i7 = (i5 & 2) != 0 ? dashBoardDetails2.AwardPending : i2;
        Boolean bool10 = (i5 & 4) != 0 ? dashBoardDetails2.BiddingBenchMark : bool;
        Integer num14 = (i5 & 8) != 0 ? dashBoardDetails2.CountofFeeItems : num;
        Integer num15 = (i5 & 16) != 0 ? dashBoardDetails2.Countofvehicles : num2;
        BigDecimal bigDecimal17 = (i5 & 32) != 0 ? dashBoardDetails2.FeeOnly : bigDecimal;
        String str14 = (i5 & 64) != 0 ? dashBoardDetails2.InfographicMonth : str;
        String str15 = (i5 & 128) != 0 ? dashBoardDetails2.InfographicPeriod : str2;
        String str16 = (i5 & 256) != 0 ? dashBoardDetails2.LicenseLink : str3;
        boolean z2 = (i5 & 512) != 0 ? dashBoardDetails2.LincenseLinkInd : z;
        int i8 = (i5 & 1024) != 0 ? dashBoardDetails2.Lost : i3;
        Integer num16 = (i5 & 2048) != 0 ? dashBoardDetails2.Outbid : num3;
        Integer num17 = (i5 & 4096) != 0 ? dashBoardDetails2.Pickup : num4;
        String str17 = (i5 & 8192) != 0 ? dashBoardDetails2.ProfileLink : str4;
        Boolean bool11 = (i5 & 16384) != 0 ? dashBoardDetails2.ProfileLinkInd : bool2;
        if ((i5 & 32768) != 0) {
            bool5 = bool11;
            str8 = dashBoardDetails2.RenewalLink;
        } else {
            bool5 = bool11;
            str8 = str5;
        }
        if ((i5 & 65536) != 0) {
            str9 = str8;
            bool6 = dashBoardDetails2.RenewalLinkInd;
        } else {
            str9 = str8;
            bool6 = bool3;
        }
        if ((i5 & 131072) != 0) {
            bool7 = bool6;
            str10 = dashBoardDetails2.RenewalMessage;
        } else {
            bool7 = bool6;
            str10 = str6;
        }
        if ((i5 & 262144) != 0) {
            str11 = str10;
            bigDecimal7 = dashBoardDetails2.TotalAwardPending;
        } else {
            str11 = str10;
            bigDecimal7 = bigDecimal2;
        }
        if ((i5 & 524288) != 0) {
            bigDecimal8 = bigDecimal7;
            bigDecimal9 = dashBoardDetails2.TotalCurrentBids;
        } else {
            bigDecimal8 = bigDecimal7;
            bigDecimal9 = bigDecimal3;
        }
        if ((i5 & 1048576) != 0) {
            bigDecimal10 = bigDecimal9;
            bigDecimal11 = dashBoardDetails2.TotalMaxBids;
        } else {
            bigDecimal10 = bigDecimal9;
            bigDecimal11 = bigDecimal4;
        }
        if ((i5 & 2097152) != 0) {
            bigDecimal12 = bigDecimal11;
            bigDecimal13 = dashBoardDetails2.TotaltobePaid;
        } else {
            bigDecimal12 = bigDecimal11;
            bigDecimal13 = bigDecimal5;
        }
        if ((i5 & 4194304) != 0) {
            bigDecimal14 = bigDecimal13;
            str12 = dashBoardDetails2.UpgradeLink;
        } else {
            bigDecimal14 = bigDecimal13;
            str12 = str7;
        }
        if ((i5 & 8388608) != 0) {
            str13 = str12;
            bool8 = dashBoardDetails2.UpgradeLinkInd;
        } else {
            str13 = str12;
            bool8 = bool4;
        }
        if ((i5 & 16777216) != 0) {
            bool9 = bool8;
            bigDecimal15 = dashBoardDetails2.VehiclesOnly;
        } else {
            bool9 = bool8;
            bigDecimal15 = bigDecimal6;
        }
        if ((i5 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            bigDecimal16 = bigDecimal15;
            num9 = dashBoardDetails2.Watching;
        } else {
            bigDecimal16 = bigDecimal15;
            num9 = num5;
        }
        if ((i5 & 67108864) != 0) {
            num10 = num9;
            num11 = dashBoardDetails2.WinningPrebids;
        } else {
            num10 = num9;
            num11 = num6;
        }
        if ((i5 & 134217728) != 0) {
            num12 = num11;
            num13 = dashBoardDetails2.Won;
        } else {
            num12 = num11;
            num13 = num7;
        }
        return dashBoardDetails.copy(i6, i7, bool10, num14, num15, bigDecimal17, str14, str15, str16, z2, i8, num16, num17, str17, bool5, str9, bool7, str11, bigDecimal8, bigDecimal10, bigDecimal12, bigDecimal14, str13, bool9, bigDecimal16, num10, num12, num13, (i5 & C1119C.ENCODING_PCM_MU_LAW) != 0 ? dashBoardDetails2.NegotiationOffers : num8);
    }

    public final int component1() {
        return this.Alerts;
    }

    public final boolean component10() {
        return this.LincenseLinkInd;
    }

    public final int component11() {
        return this.Lost;
    }

    @Nullable
    public final Integer component12() {
        return this.Outbid;
    }

    @Nullable
    public final Integer component13() {
        return this.Pickup;
    }

    @Nullable
    public final String component14() {
        return this.ProfileLink;
    }

    @Nullable
    public final Boolean component15() {
        return this.ProfileLinkInd;
    }

    @NotNull
    public final String component16() {
        return this.RenewalLink;
    }

    @Nullable
    public final Boolean component17() {
        return this.RenewalLinkInd;
    }

    @Nullable
    public final String component18() {
        return this.RenewalMessage;
    }

    @Nullable
    public final BigDecimal component19() {
        return this.TotalAwardPending;
    }

    public final int component2() {
        return this.AwardPending;
    }

    @Nullable
    public final BigDecimal component20() {
        return this.TotalCurrentBids;
    }

    @Nullable
    public final BigDecimal component21() {
        return this.TotalMaxBids;
    }

    @Nullable
    public final BigDecimal component22() {
        return this.TotaltobePaid;
    }

    @NotNull
    public final String component23() {
        return this.UpgradeLink;
    }

    @Nullable
    public final Boolean component24() {
        return this.UpgradeLinkInd;
    }

    @Nullable
    public final BigDecimal component25() {
        return this.VehiclesOnly;
    }

    @Nullable
    public final Integer component26() {
        return this.Watching;
    }

    @Nullable
    public final Integer component27() {
        return this.WinningPrebids;
    }

    @Nullable
    public final Integer component28() {
        return this.Won;
    }

    @Nullable
    public final Integer component29() {
        return this.NegotiationOffers;
    }

    @Nullable
    public final Boolean component3() {
        return this.BiddingBenchMark;
    }

    @Nullable
    public final Integer component4() {
        return this.CountofFeeItems;
    }

    @Nullable
    public final Integer component5() {
        return this.Countofvehicles;
    }

    @NotNull
    public final BigDecimal component6() {
        return this.FeeOnly;
    }

    @Nullable
    public final String component7() {
        return this.InfographicMonth;
    }

    @Nullable
    public final String component8() {
        return this.InfographicPeriod;
    }

    @NotNull
    public final String component9() {
        return this.LicenseLink;
    }

    @NotNull
    public final DashBoardDetails copy(int i, int i2, @Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2, @NotNull BigDecimal bigDecimal, @Nullable String str, @Nullable String str2, @NotNull String str3, boolean z, int i3, @Nullable Integer num3, @Nullable Integer num4, @Nullable String str4, @Nullable Boolean bool2, @NotNull String str5, @Nullable Boolean bool3, @Nullable String str6, @Nullable BigDecimal bigDecimal2, @Nullable BigDecimal bigDecimal3, @Nullable BigDecimal bigDecimal4, @Nullable BigDecimal bigDecimal5, @NotNull String str7, @Nullable Boolean bool4, @Nullable BigDecimal bigDecimal6, @Nullable Integer num5, @Nullable Integer num6, @Nullable Integer num7, @Nullable Integer num8) {
        int i4 = i;
        Intrinsics.checkParameterIsNotNull(bigDecimal, "FeeOnly");
        Intrinsics.checkParameterIsNotNull(str3, "LicenseLink");
        Intrinsics.checkParameterIsNotNull(str5, "RenewalLink");
        Intrinsics.checkParameterIsNotNull(str7, "UpgradeLink");
        return new DashBoardDetails(i, i2, bool, num, num2, bigDecimal, str, str2, str3, z, i3, num3, num4, str4, bool2, str5, bool3, str6, bigDecimal2, bigDecimal3, bigDecimal4, bigDecimal5, str7, bool4, bigDecimal6, num5, num6, num7, num8);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof DashBoardDetails) {
                DashBoardDetails dashBoardDetails = (DashBoardDetails) obj;
                if (this.Alerts == dashBoardDetails.Alerts) {
                    if ((this.AwardPending == dashBoardDetails.AwardPending) && Intrinsics.areEqual((Object) this.BiddingBenchMark, (Object) dashBoardDetails.BiddingBenchMark) && Intrinsics.areEqual((Object) this.CountofFeeItems, (Object) dashBoardDetails.CountofFeeItems) && Intrinsics.areEqual((Object) this.Countofvehicles, (Object) dashBoardDetails.Countofvehicles) && Intrinsics.areEqual((Object) this.FeeOnly, (Object) dashBoardDetails.FeeOnly) && Intrinsics.areEqual((Object) this.InfographicMonth, (Object) dashBoardDetails.InfographicMonth) && Intrinsics.areEqual((Object) this.InfographicPeriod, (Object) dashBoardDetails.InfographicPeriod) && Intrinsics.areEqual((Object) this.LicenseLink, (Object) dashBoardDetails.LicenseLink)) {
                        if (this.LincenseLinkInd == dashBoardDetails.LincenseLinkInd) {
                            if (!(this.Lost == dashBoardDetails.Lost) || !Intrinsics.areEqual((Object) this.Outbid, (Object) dashBoardDetails.Outbid) || !Intrinsics.areEqual((Object) this.Pickup, (Object) dashBoardDetails.Pickup) || !Intrinsics.areEqual((Object) this.ProfileLink, (Object) dashBoardDetails.ProfileLink) || !Intrinsics.areEqual((Object) this.ProfileLinkInd, (Object) dashBoardDetails.ProfileLinkInd) || !Intrinsics.areEqual((Object) this.RenewalLink, (Object) dashBoardDetails.RenewalLink) || !Intrinsics.areEqual((Object) this.RenewalLinkInd, (Object) dashBoardDetails.RenewalLinkInd) || !Intrinsics.areEqual((Object) this.RenewalMessage, (Object) dashBoardDetails.RenewalMessage) || !Intrinsics.areEqual((Object) this.TotalAwardPending, (Object) dashBoardDetails.TotalAwardPending) || !Intrinsics.areEqual((Object) this.TotalCurrentBids, (Object) dashBoardDetails.TotalCurrentBids) || !Intrinsics.areEqual((Object) this.TotalMaxBids, (Object) dashBoardDetails.TotalMaxBids) || !Intrinsics.areEqual((Object) this.TotaltobePaid, (Object) dashBoardDetails.TotaltobePaid) || !Intrinsics.areEqual((Object) this.UpgradeLink, (Object) dashBoardDetails.UpgradeLink) || !Intrinsics.areEqual((Object) this.UpgradeLinkInd, (Object) dashBoardDetails.UpgradeLinkInd) || !Intrinsics.areEqual((Object) this.VehiclesOnly, (Object) dashBoardDetails.VehiclesOnly) || !Intrinsics.areEqual((Object) this.Watching, (Object) dashBoardDetails.Watching) || !Intrinsics.areEqual((Object) this.WinningPrebids, (Object) dashBoardDetails.WinningPrebids) || !Intrinsics.areEqual((Object) this.Won, (Object) dashBoardDetails.Won) || !Intrinsics.areEqual((Object) this.NegotiationOffers, (Object) dashBoardDetails.NegotiationOffers)) {
                                return false;
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
        int hashCode = ((Integer.valueOf(this.Alerts).hashCode() * 31) + Integer.valueOf(this.AwardPending).hashCode()) * 31;
        Boolean bool = this.BiddingBenchMark;
        int i = 0;
        int hashCode2 = (hashCode + (bool != null ? bool.hashCode() : 0)) * 31;
        Integer num = this.CountofFeeItems;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.Countofvehicles;
        int hashCode4 = (hashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31;
        BigDecimal bigDecimal = this.FeeOnly;
        int hashCode5 = (hashCode4 + (bigDecimal != null ? bigDecimal.hashCode() : 0)) * 31;
        String str = this.InfographicMonth;
        int hashCode6 = (hashCode5 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.InfographicPeriod;
        int hashCode7 = (hashCode6 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.LicenseLink;
        int hashCode8 = (hashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z = this.LincenseLinkInd;
        if (z) {
            z = true;
        }
        int hashCode9 = (((hashCode8 + (z ? 1 : 0)) * 31) + Integer.valueOf(this.Lost).hashCode()) * 31;
        Integer num3 = this.Outbid;
        int hashCode10 = (hashCode9 + (num3 != null ? num3.hashCode() : 0)) * 31;
        Integer num4 = this.Pickup;
        int hashCode11 = (hashCode10 + (num4 != null ? num4.hashCode() : 0)) * 31;
        String str4 = this.ProfileLink;
        int hashCode12 = (hashCode11 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Boolean bool2 = this.ProfileLinkInd;
        int hashCode13 = (hashCode12 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        String str5 = this.RenewalLink;
        int hashCode14 = (hashCode13 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Boolean bool3 = this.RenewalLinkInd;
        int hashCode15 = (hashCode14 + (bool3 != null ? bool3.hashCode() : 0)) * 31;
        String str6 = this.RenewalMessage;
        int hashCode16 = (hashCode15 + (str6 != null ? str6.hashCode() : 0)) * 31;
        BigDecimal bigDecimal2 = this.TotalAwardPending;
        int hashCode17 = (hashCode16 + (bigDecimal2 != null ? bigDecimal2.hashCode() : 0)) * 31;
        BigDecimal bigDecimal3 = this.TotalCurrentBids;
        int hashCode18 = (hashCode17 + (bigDecimal3 != null ? bigDecimal3.hashCode() : 0)) * 31;
        BigDecimal bigDecimal4 = this.TotalMaxBids;
        int hashCode19 = (hashCode18 + (bigDecimal4 != null ? bigDecimal4.hashCode() : 0)) * 31;
        BigDecimal bigDecimal5 = this.TotaltobePaid;
        int hashCode20 = (hashCode19 + (bigDecimal5 != null ? bigDecimal5.hashCode() : 0)) * 31;
        String str7 = this.UpgradeLink;
        int hashCode21 = (hashCode20 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Boolean bool4 = this.UpgradeLinkInd;
        int hashCode22 = (hashCode21 + (bool4 != null ? bool4.hashCode() : 0)) * 31;
        BigDecimal bigDecimal6 = this.VehiclesOnly;
        int hashCode23 = (hashCode22 + (bigDecimal6 != null ? bigDecimal6.hashCode() : 0)) * 31;
        Integer num5 = this.Watching;
        int hashCode24 = (hashCode23 + (num5 != null ? num5.hashCode() : 0)) * 31;
        Integer num6 = this.WinningPrebids;
        int hashCode25 = (hashCode24 + (num6 != null ? num6.hashCode() : 0)) * 31;
        Integer num7 = this.Won;
        int hashCode26 = (hashCode25 + (num7 != null ? num7.hashCode() : 0)) * 31;
        Integer num8 = this.NegotiationOffers;
        if (num8 != null) {
            i = num8.hashCode();
        }
        return hashCode26 + i;
    }

    @NotNull
    public String toString() {
        return "DashBoardDetails(Alerts=" + this.Alerts + ", AwardPending=" + this.AwardPending + ", BiddingBenchMark=" + this.BiddingBenchMark + ", CountofFeeItems=" + this.CountofFeeItems + ", Countofvehicles=" + this.Countofvehicles + ", FeeOnly=" + this.FeeOnly + ", InfographicMonth=" + this.InfographicMonth + ", InfographicPeriod=" + this.InfographicPeriod + ", LicenseLink=" + this.LicenseLink + ", LincenseLinkInd=" + this.LincenseLinkInd + ", Lost=" + this.Lost + ", Outbid=" + this.Outbid + ", Pickup=" + this.Pickup + ", ProfileLink=" + this.ProfileLink + ", ProfileLinkInd=" + this.ProfileLinkInd + ", RenewalLink=" + this.RenewalLink + ", RenewalLinkInd=" + this.RenewalLinkInd + ", RenewalMessage=" + this.RenewalMessage + ", TotalAwardPending=" + this.TotalAwardPending + ", TotalCurrentBids=" + this.TotalCurrentBids + ", TotalMaxBids=" + this.TotalMaxBids + ", TotaltobePaid=" + this.TotaltobePaid + ", UpgradeLink=" + this.UpgradeLink + ", UpgradeLinkInd=" + this.UpgradeLinkInd + ", VehiclesOnly=" + this.VehiclesOnly + ", Watching=" + this.Watching + ", WinningPrebids=" + this.WinningPrebids + ", Won=" + this.Won + ", NegotiationOffers=" + this.NegotiationOffers + ")";
    }

    public DashBoardDetails(int i, int i2, @Nullable Boolean bool, @Nullable Integer num, @Nullable Integer num2, @NotNull BigDecimal bigDecimal, @Nullable String str, @Nullable String str2, @NotNull String str3, boolean z, int i3, @Nullable Integer num3, @Nullable Integer num4, @Nullable String str4, @Nullable Boolean bool2, @NotNull String str5, @Nullable Boolean bool3, @Nullable String str6, @Nullable BigDecimal bigDecimal2, @Nullable BigDecimal bigDecimal3, @Nullable BigDecimal bigDecimal4, @Nullable BigDecimal bigDecimal5, @NotNull String str7, @Nullable Boolean bool4, @Nullable BigDecimal bigDecimal6, @Nullable Integer num5, @Nullable Integer num6, @Nullable Integer num7, @Nullable Integer num8) {
        String str8 = str5;
        String str9 = str7;
        Intrinsics.checkParameterIsNotNull(bigDecimal, "FeeOnly");
        Intrinsics.checkParameterIsNotNull(str3, "LicenseLink");
        Intrinsics.checkParameterIsNotNull(str8, "RenewalLink");
        Intrinsics.checkParameterIsNotNull(str9, "UpgradeLink");
        this.Alerts = i;
        this.AwardPending = i2;
        this.BiddingBenchMark = bool;
        this.CountofFeeItems = num;
        this.Countofvehicles = num2;
        this.FeeOnly = bigDecimal;
        this.InfographicMonth = str;
        this.InfographicPeriod = str2;
        this.LicenseLink = str3;
        this.LincenseLinkInd = z;
        this.Lost = i3;
        this.Outbid = num3;
        this.Pickup = num4;
        this.ProfileLink = str4;
        this.ProfileLinkInd = bool2;
        this.RenewalLink = str8;
        this.RenewalLinkInd = bool3;
        this.RenewalMessage = str6;
        this.TotalAwardPending = bigDecimal2;
        this.TotalCurrentBids = bigDecimal3;
        this.TotalMaxBids = bigDecimal4;
        this.TotaltobePaid = bigDecimal5;
        this.UpgradeLink = str9;
        this.UpgradeLinkInd = bool4;
        this.VehiclesOnly = bigDecimal6;
        this.Watching = num5;
        this.WinningPrebids = num6;
        this.Won = num7;
        this.NegotiationOffers = num8;
    }

    public final int getAlerts() {
        return this.Alerts;
    }

    public final void setAlerts(int i) {
        this.Alerts = i;
    }

    public final int getAwardPending() {
        return this.AwardPending;
    }

    public final void setAwardPending(int i) {
        this.AwardPending = i;
    }

    @Nullable
    public final Boolean getBiddingBenchMark() {
        return this.BiddingBenchMark;
    }

    public final void setBiddingBenchMark(@Nullable Boolean bool) {
        this.BiddingBenchMark = bool;
    }

    @Nullable
    public final Integer getCountofFeeItems() {
        return this.CountofFeeItems;
    }

    public final void setCountofFeeItems(@Nullable Integer num) {
        this.CountofFeeItems = num;
    }

    @Nullable
    public final Integer getCountofvehicles() {
        return this.Countofvehicles;
    }

    public final void setCountofvehicles(@Nullable Integer num) {
        this.Countofvehicles = num;
    }

    @NotNull
    public final BigDecimal getFeeOnly() {
        return this.FeeOnly;
    }

    public final void setFeeOnly(@NotNull BigDecimal bigDecimal) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, "<set-?>");
        this.FeeOnly = bigDecimal;
    }

    @Nullable
    public final String getInfographicMonth() {
        return this.InfographicMonth;
    }

    public final void setInfographicMonth(@Nullable String str) {
        this.InfographicMonth = str;
    }

    @Nullable
    public final String getInfographicPeriod() {
        return this.InfographicPeriod;
    }

    public final void setInfographicPeriod(@Nullable String str) {
        this.InfographicPeriod = str;
    }

    @NotNull
    public final String getLicenseLink() {
        return this.LicenseLink;
    }

    public final void setLicenseLink(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.LicenseLink = str;
    }

    public final boolean getLincenseLinkInd() {
        return this.LincenseLinkInd;
    }

    public final void setLincenseLinkInd(boolean z) {
        this.LincenseLinkInd = z;
    }

    public final int getLost() {
        return this.Lost;
    }

    public final void setLost(int i) {
        this.Lost = i;
    }

    @Nullable
    public final Integer getOutbid() {
        return this.Outbid;
    }

    public final void setOutbid(@Nullable Integer num) {
        this.Outbid = num;
    }

    @Nullable
    public final Integer getPickup() {
        return this.Pickup;
    }

    public final void setPickup(@Nullable Integer num) {
        this.Pickup = num;
    }

    @Nullable
    public final String getProfileLink() {
        return this.ProfileLink;
    }

    public final void setProfileLink(@Nullable String str) {
        this.ProfileLink = str;
    }

    @Nullable
    public final Boolean getProfileLinkInd() {
        return this.ProfileLinkInd;
    }

    public final void setProfileLinkInd(@Nullable Boolean bool) {
        this.ProfileLinkInd = bool;
    }

    @NotNull
    public final String getRenewalLink() {
        return this.RenewalLink;
    }

    public final void setRenewalLink(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.RenewalLink = str;
    }

    @Nullable
    public final Boolean getRenewalLinkInd() {
        return this.RenewalLinkInd;
    }

    public final void setRenewalLinkInd(@Nullable Boolean bool) {
        this.RenewalLinkInd = bool;
    }

    @Nullable
    public final String getRenewalMessage() {
        return this.RenewalMessage;
    }

    public final void setRenewalMessage(@Nullable String str) {
        this.RenewalMessage = str;
    }

    @Nullable
    public final BigDecimal getTotalAwardPending() {
        return this.TotalAwardPending;
    }

    public final void setTotalAwardPending(@Nullable BigDecimal bigDecimal) {
        this.TotalAwardPending = bigDecimal;
    }

    @Nullable
    public final BigDecimal getTotalCurrentBids() {
        return this.TotalCurrentBids;
    }

    public final void setTotalCurrentBids(@Nullable BigDecimal bigDecimal) {
        this.TotalCurrentBids = bigDecimal;
    }

    @Nullable
    public final BigDecimal getTotalMaxBids() {
        return this.TotalMaxBids;
    }

    public final void setTotalMaxBids(@Nullable BigDecimal bigDecimal) {
        this.TotalMaxBids = bigDecimal;
    }

    @Nullable
    public final BigDecimal getTotaltobePaid() {
        return this.TotaltobePaid;
    }

    public final void setTotaltobePaid(@Nullable BigDecimal bigDecimal) {
        this.TotaltobePaid = bigDecimal;
    }

    @NotNull
    public final String getUpgradeLink() {
        return this.UpgradeLink;
    }

    public final void setUpgradeLink(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.UpgradeLink = str;
    }

    @Nullable
    public final Boolean getUpgradeLinkInd() {
        return this.UpgradeLinkInd;
    }

    public final void setUpgradeLinkInd(@Nullable Boolean bool) {
        this.UpgradeLinkInd = bool;
    }

    @Nullable
    public final BigDecimal getVehiclesOnly() {
        return this.VehiclesOnly;
    }

    public final void setVehiclesOnly(@Nullable BigDecimal bigDecimal) {
        this.VehiclesOnly = bigDecimal;
    }

    @Nullable
    public final Integer getWatching() {
        return this.Watching;
    }

    public final void setWatching(@Nullable Integer num) {
        this.Watching = num;
    }

    @Nullable
    public final Integer getWinningPrebids() {
        return this.WinningPrebids;
    }

    public final void setWinningPrebids(@Nullable Integer num) {
        this.WinningPrebids = num;
    }

    @Nullable
    public final Integer getWon() {
        return this.Won;
    }

    public final void setWon(@Nullable Integer num) {
        this.Won = num;
    }

    @Nullable
    public final Integer getNegotiationOffers() {
        return this.NegotiationOffers;
    }

    public final void setNegotiationOffers(@Nullable Integer num) {
        this.NegotiationOffers = num;
    }
}
