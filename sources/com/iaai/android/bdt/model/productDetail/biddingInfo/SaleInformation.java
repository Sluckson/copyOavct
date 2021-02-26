package com.iaai.android.bdt.model.productDetail.biddingInfo;

import com.google.android.exoplayer2.C1119C;
import com.lowagie.text.pdf.PdfFormField;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\be\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B¡\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\u0006\u0010!\u001a\u00020\t\u0012\u0006\u0010\"\u001a\u00020\u0003\u0012\u0006\u0010#\u001a\u00020\u0018\u0012\u0006\u0010$\u001a\u00020\t\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010(J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Y\u001a\u00020\u0003HÆ\u0003J\t\u0010Z\u001a\u00020\u000fHÆ\u0003J\t\u0010[\u001a\u00020\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0003HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\t\u0010`\u001a\u00020\u0003HÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\t\u0010b\u001a\u00020\u0018HÆ\u0003J\t\u0010c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010e\u001a\u00020\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0003HÆ\u0003J\t\u0010g\u001a\u00020\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0003HÆ\u0003J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\tHÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\tHÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\t\u0010n\u001a\u00020\u0003HÆ\u0003J\t\u0010o\u001a\u00020\u0018HÆ\u0003J\t\u0010p\u001a\u00020\tHÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u0010IJ\t\u0010t\u001a\u00020\u0003HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010v\u001a\u00020\tHÆ\u0003J\t\u0010w\u001a\u00020\u0003HÆ\u0003J\t\u0010x\u001a\u00020\u0003HÆ\u0003J\t\u0010y\u001a\u00020\u0003HÆ\u0003Jî\u0002\u0010z\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\t2\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\t2\b\b\u0002\u0010\"\u001a\u00020\u00032\b\b\u0002\u0010#\u001a\u00020\u00182\b\b\u0002\u0010$\u001a\u00020\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010{J\u0013\u0010|\u001a\u00020\t2\b\u0010}\u001a\u0004\u0018\u00010~HÖ\u0003J\t\u0010\u001a\u00020\u0018HÖ\u0001J\n\u0010\u0001\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0011\u0010\u001b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010*R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010*R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u0011\u0010\u001f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010*R\u0011\u0010#\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b5\u0010-R\u0011\u0010\"\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010*R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u0011\u0010!\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b8\u00103R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010*R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010*R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010*R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010*R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010*R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010*R\u001c\u0010&\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010*\"\u0004\b@\u0010AR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010*R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bE\u0010*R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010*R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bG\u0010*R\u001e\u0010'\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0010\n\u0002\u0010L\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0011\u0010\u001c\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u0010*R\u001a\u0010$\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u00103\"\u0004\bO\u0010PR\u001c\u0010%\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010*\"\u0004\bR\u0010AR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010*R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u0010*R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u0010*R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u0010*R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bW\u0010*¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/biddingInfo/SaleInformation;", "Ljava/io/Serializable;", "ACV", "", "BranchLink", "Date", "Day", "EstimatedRepairCost", "IsVehicleAtBranch", "", "Lane", "LiveDateString", "Month", "SaleDoc", "SaleInfo", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/SaleInfo;", "Seller", "Slot", "Time", "TitleDocument", "TitleState", "UserTimezoneAbb", "SaleInfoToolTip", "BranchCode", "", "LocationName", "Address", "City", "State", "Zip", "Phone", "DisplayMoreLinkForRemote", "RemoteSaleInfo", "IsVehicleAtIAABranchForVirualBranch", "IaaBranchLocationForVirtualBranch", "IaaBranchCodeForVirtualBranch", "TBOInd", "TBONotes", "Row", "StallNumber", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iaai/android/bdt/model/productDetail/biddingInfo/SaleInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getACV", "()Ljava/lang/String;", "getAddress", "getBranchCode", "()I", "getBranchLink", "getCity", "getDate", "getDay", "getDisplayMoreLinkForRemote", "()Z", "getEstimatedRepairCost", "getIaaBranchCodeForVirtualBranch", "getIaaBranchLocationForVirtualBranch", "getIsVehicleAtBranch", "getIsVehicleAtIAABranchForVirualBranch", "getLane", "getLiveDateString", "getLocationName", "getMonth", "getPhone", "getRemoteSaleInfo", "getRow", "setRow", "(Ljava/lang/String;)V", "getSaleDoc", "getSaleInfo", "()Lcom/iaai/android/bdt/model/productDetail/biddingInfo/SaleInfo;", "getSaleInfoToolTip", "getSeller", "getSlot", "getStallNumber", "()Ljava/lang/Integer;", "setStallNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getState", "getTBOInd", "setTBOInd", "(Z)V", "getTBONotes", "setTBONotes", "getTime", "getTitleDocument", "getTitleState", "getUserTimezoneAbb", "getZip", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/iaai/android/bdt/model/productDetail/biddingInfo/SaleInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;IZLjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/iaai/android/bdt/model/productDetail/biddingInfo/SaleInformation;", "equals", "other", "", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SaleInformation.kt */
public final class SaleInformation implements Serializable {
    @Nullable
    private final String ACV;
    @NotNull
    private final String Address;
    private final int BranchCode;
    @NotNull
    private final String BranchLink;
    @NotNull
    private final String City;
    @NotNull
    private final String Date;
    @NotNull
    private final String Day;
    private final boolean DisplayMoreLinkForRemote;
    @Nullable
    private final String EstimatedRepairCost;
    private final int IaaBranchCodeForVirtualBranch;
    @NotNull
    private final String IaaBranchLocationForVirtualBranch;
    private final boolean IsVehicleAtBranch;
    private final boolean IsVehicleAtIAABranchForVirualBranch;
    @NotNull
    private final String Lane;
    @NotNull
    private final String LiveDateString;
    @Nullable
    private final String LocationName;
    @NotNull
    private final String Month;
    @NotNull
    private final String Phone;
    @NotNull
    private final String RemoteSaleInfo;
    @Nullable
    private String Row;
    @NotNull
    private final String SaleDoc;
    @NotNull
    private final SaleInfo SaleInfo;
    @NotNull
    private final String SaleInfoToolTip;
    @NotNull
    private final String Seller;
    @NotNull
    private final String Slot;
    @Nullable
    private Integer StallNumber;
    @NotNull
    private final String State;
    private boolean TBOInd;
    @Nullable
    private String TBONotes;
    @NotNull
    private final String Time;
    @NotNull
    private final String TitleDocument;
    @NotNull
    private final String TitleState;
    @NotNull
    private final String UserTimezoneAbb;
    @NotNull
    private final String Zip;

    @NotNull
    public static /* synthetic */ SaleInformation copy$default(SaleInformation saleInformation, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, String str8, String str9, SaleInfo saleInfo, String str10, String str11, String str12, String str13, String str14, String str15, String str16, int i, String str17, String str18, String str19, String str20, String str21, String str22, boolean z2, String str23, boolean z3, String str24, int i2, boolean z4, String str25, String str26, Integer num, int i3, int i4, Object obj) {
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        int i5;
        int i6;
        String str34;
        String str35;
        String str36;
        String str37;
        String str38;
        String str39;
        String str40;
        String str41;
        String str42;
        String str43;
        String str44;
        String str45;
        boolean z5;
        boolean z6;
        String str46;
        String str47;
        boolean z7;
        boolean z8;
        String str48;
        String str49;
        int i7;
        int i8;
        boolean z9;
        String str50;
        String str51;
        String str52;
        Integer num2;
        SaleInformation saleInformation2 = saleInformation;
        int i9 = i3;
        String str53 = (i9 & 1) != 0 ? saleInformation2.ACV : str;
        String str54 = (i9 & 2) != 0 ? saleInformation2.BranchLink : str2;
        String str55 = (i9 & 4) != 0 ? saleInformation2.Date : str3;
        String str56 = (i9 & 8) != 0 ? saleInformation2.Day : str4;
        String str57 = (i9 & 16) != 0 ? saleInformation2.EstimatedRepairCost : str5;
        boolean z10 = (i9 & 32) != 0 ? saleInformation2.IsVehicleAtBranch : z;
        String str58 = (i9 & 64) != 0 ? saleInformation2.Lane : str6;
        String str59 = (i9 & 128) != 0 ? saleInformation2.LiveDateString : str7;
        String str60 = (i9 & 256) != 0 ? saleInformation2.Month : str8;
        String str61 = (i9 & 512) != 0 ? saleInformation2.SaleDoc : str9;
        SaleInfo saleInfo2 = (i9 & 1024) != 0 ? saleInformation2.SaleInfo : saleInfo;
        String str62 = (i9 & 2048) != 0 ? saleInformation2.Seller : str10;
        String str63 = (i9 & 4096) != 0 ? saleInformation2.Slot : str11;
        String str64 = (i9 & 8192) != 0 ? saleInformation2.Time : str12;
        String str65 = (i9 & 16384) != 0 ? saleInformation2.TitleDocument : str13;
        if ((i9 & 32768) != 0) {
            str27 = str65;
            str28 = saleInformation2.TitleState;
        } else {
            str27 = str65;
            str28 = str14;
        }
        if ((i9 & 65536) != 0) {
            str29 = str28;
            str30 = saleInformation2.UserTimezoneAbb;
        } else {
            str29 = str28;
            str30 = str15;
        }
        if ((i9 & 131072) != 0) {
            str31 = str30;
            str32 = saleInformation2.SaleInfoToolTip;
        } else {
            str31 = str30;
            str32 = str16;
        }
        if ((i9 & 262144) != 0) {
            str33 = str32;
            i5 = saleInformation2.BranchCode;
        } else {
            str33 = str32;
            i5 = i;
        }
        if ((i9 & 524288) != 0) {
            i6 = i5;
            str34 = saleInformation2.LocationName;
        } else {
            i6 = i5;
            str34 = str17;
        }
        if ((i9 & 1048576) != 0) {
            str35 = str34;
            str36 = saleInformation2.Address;
        } else {
            str35 = str34;
            str36 = str18;
        }
        if ((i9 & 2097152) != 0) {
            str37 = str36;
            str38 = saleInformation2.City;
        } else {
            str37 = str36;
            str38 = str19;
        }
        if ((i9 & 4194304) != 0) {
            str39 = str38;
            str40 = saleInformation2.State;
        } else {
            str39 = str38;
            str40 = str20;
        }
        if ((i9 & 8388608) != 0) {
            str41 = str40;
            str42 = saleInformation2.Zip;
        } else {
            str41 = str40;
            str42 = str21;
        }
        if ((i9 & 16777216) != 0) {
            str43 = str42;
            str44 = saleInformation2.Phone;
        } else {
            str43 = str42;
            str44 = str22;
        }
        if ((i9 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            str45 = str44;
            z5 = saleInformation2.DisplayMoreLinkForRemote;
        } else {
            str45 = str44;
            z5 = z2;
        }
        if ((i9 & 67108864) != 0) {
            z6 = z5;
            str46 = saleInformation2.RemoteSaleInfo;
        } else {
            z6 = z5;
            str46 = str23;
        }
        if ((i9 & 134217728) != 0) {
            str47 = str46;
            z7 = saleInformation2.IsVehicleAtIAABranchForVirualBranch;
        } else {
            str47 = str46;
            z7 = z3;
        }
        if ((i9 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            z8 = z7;
            str48 = saleInformation2.IaaBranchLocationForVirtualBranch;
        } else {
            z8 = z7;
            str48 = str24;
        }
        if ((i9 & 536870912) != 0) {
            str49 = str48;
            i7 = saleInformation2.IaaBranchCodeForVirtualBranch;
        } else {
            str49 = str48;
            i7 = i2;
        }
        if ((i9 & 1073741824) != 0) {
            i8 = i7;
            z9 = saleInformation2.TBOInd;
        } else {
            i8 = i7;
            z9 = z4;
        }
        String str66 = (i9 & Integer.MIN_VALUE) != 0 ? saleInformation2.TBONotes : str25;
        if ((i4 & 1) != 0) {
            str50 = str66;
            str51 = saleInformation2.Row;
        } else {
            str50 = str66;
            str51 = str26;
        }
        if ((i4 & 2) != 0) {
            str52 = str51;
            num2 = saleInformation2.StallNumber;
        } else {
            str52 = str51;
            num2 = num;
        }
        return saleInformation.copy(str53, str54, str55, str56, str57, z10, str58, str59, str60, str61, saleInfo2, str62, str63, str64, str27, str29, str31, str33, i6, str35, str37, str39, str41, str43, str45, z6, str47, z8, str49, i8, z9, str50, str52, num2);
    }

    @Nullable
    public final String component1() {
        return this.ACV;
    }

    @NotNull
    public final String component10() {
        return this.SaleDoc;
    }

    @NotNull
    public final SaleInfo component11() {
        return this.SaleInfo;
    }

    @NotNull
    public final String component12() {
        return this.Seller;
    }

    @NotNull
    public final String component13() {
        return this.Slot;
    }

    @NotNull
    public final String component14() {
        return this.Time;
    }

    @NotNull
    public final String component15() {
        return this.TitleDocument;
    }

    @NotNull
    public final String component16() {
        return this.TitleState;
    }

    @NotNull
    public final String component17() {
        return this.UserTimezoneAbb;
    }

    @NotNull
    public final String component18() {
        return this.SaleInfoToolTip;
    }

    public final int component19() {
        return this.BranchCode;
    }

    @NotNull
    public final String component2() {
        return this.BranchLink;
    }

    @Nullable
    public final String component20() {
        return this.LocationName;
    }

    @NotNull
    public final String component21() {
        return this.Address;
    }

    @NotNull
    public final String component22() {
        return this.City;
    }

    @NotNull
    public final String component23() {
        return this.State;
    }

    @NotNull
    public final String component24() {
        return this.Zip;
    }

    @NotNull
    public final String component25() {
        return this.Phone;
    }

    public final boolean component26() {
        return this.DisplayMoreLinkForRemote;
    }

    @NotNull
    public final String component27() {
        return this.RemoteSaleInfo;
    }

    public final boolean component28() {
        return this.IsVehicleAtIAABranchForVirualBranch;
    }

    @NotNull
    public final String component29() {
        return this.IaaBranchLocationForVirtualBranch;
    }

    @NotNull
    public final String component3() {
        return this.Date;
    }

    public final int component30() {
        return this.IaaBranchCodeForVirtualBranch;
    }

    public final boolean component31() {
        return this.TBOInd;
    }

    @Nullable
    public final String component32() {
        return this.TBONotes;
    }

    @Nullable
    public final String component33() {
        return this.Row;
    }

    @Nullable
    public final Integer component34() {
        return this.StallNumber;
    }

    @NotNull
    public final String component4() {
        return this.Day;
    }

    @Nullable
    public final String component5() {
        return this.EstimatedRepairCost;
    }

    public final boolean component6() {
        return this.IsVehicleAtBranch;
    }

    @NotNull
    public final String component7() {
        return this.Lane;
    }

    @NotNull
    public final String component8() {
        return this.LiveDateString;
    }

    @NotNull
    public final String component9() {
        return this.Month;
    }

    @NotNull
    public final SaleInformation copy(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, boolean z, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull SaleInfo saleInfo, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull String str15, @NotNull String str16, int i, @Nullable String str17, @NotNull String str18, @NotNull String str19, @NotNull String str20, @NotNull String str21, @NotNull String str22, boolean z2, @NotNull String str23, boolean z3, @NotNull String str24, int i2, boolean z4, @Nullable String str25, @Nullable String str26, @Nullable Integer num) {
        String str27 = str;
        Intrinsics.checkParameterIsNotNull(str2, "BranchLink");
        Intrinsics.checkParameterIsNotNull(str3, "Date");
        Intrinsics.checkParameterIsNotNull(str4, "Day");
        Intrinsics.checkParameterIsNotNull(str6, "Lane");
        Intrinsics.checkParameterIsNotNull(str7, "LiveDateString");
        Intrinsics.checkParameterIsNotNull(str8, "Month");
        Intrinsics.checkParameterIsNotNull(str9, "SaleDoc");
        Intrinsics.checkParameterIsNotNull(saleInfo, "SaleInfo");
        Intrinsics.checkParameterIsNotNull(str10, "Seller");
        Intrinsics.checkParameterIsNotNull(str11, "Slot");
        Intrinsics.checkParameterIsNotNull(str12, "Time");
        Intrinsics.checkParameterIsNotNull(str13, "TitleDocument");
        Intrinsics.checkParameterIsNotNull(str14, "TitleState");
        Intrinsics.checkParameterIsNotNull(str15, "UserTimezoneAbb");
        Intrinsics.checkParameterIsNotNull(str16, "SaleInfoToolTip");
        Intrinsics.checkParameterIsNotNull(str18, "Address");
        Intrinsics.checkParameterIsNotNull(str19, "City");
        Intrinsics.checkParameterIsNotNull(str20, "State");
        Intrinsics.checkParameterIsNotNull(str21, "Zip");
        Intrinsics.checkParameterIsNotNull(str22, "Phone");
        Intrinsics.checkParameterIsNotNull(str23, "RemoteSaleInfo");
        Intrinsics.checkParameterIsNotNull(str24, "IaaBranchLocationForVirtualBranch");
        return new SaleInformation(str, str2, str3, str4, str5, z, str6, str7, str8, str9, saleInfo, str10, str11, str12, str13, str14, str15, str16, i, str17, str18, str19, str20, str21, str22, z2, str23, z3, str24, i2, z4, str25, str26, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SaleInformation) {
                SaleInformation saleInformation = (SaleInformation) obj;
                if (Intrinsics.areEqual((Object) this.ACV, (Object) saleInformation.ACV) && Intrinsics.areEqual((Object) this.BranchLink, (Object) saleInformation.BranchLink) && Intrinsics.areEqual((Object) this.Date, (Object) saleInformation.Date) && Intrinsics.areEqual((Object) this.Day, (Object) saleInformation.Day) && Intrinsics.areEqual((Object) this.EstimatedRepairCost, (Object) saleInformation.EstimatedRepairCost)) {
                    if ((this.IsVehicleAtBranch == saleInformation.IsVehicleAtBranch) && Intrinsics.areEqual((Object) this.Lane, (Object) saleInformation.Lane) && Intrinsics.areEqual((Object) this.LiveDateString, (Object) saleInformation.LiveDateString) && Intrinsics.areEqual((Object) this.Month, (Object) saleInformation.Month) && Intrinsics.areEqual((Object) this.SaleDoc, (Object) saleInformation.SaleDoc) && Intrinsics.areEqual((Object) this.SaleInfo, (Object) saleInformation.SaleInfo) && Intrinsics.areEqual((Object) this.Seller, (Object) saleInformation.Seller) && Intrinsics.areEqual((Object) this.Slot, (Object) saleInformation.Slot) && Intrinsics.areEqual((Object) this.Time, (Object) saleInformation.Time) && Intrinsics.areEqual((Object) this.TitleDocument, (Object) saleInformation.TitleDocument) && Intrinsics.areEqual((Object) this.TitleState, (Object) saleInformation.TitleState) && Intrinsics.areEqual((Object) this.UserTimezoneAbb, (Object) saleInformation.UserTimezoneAbb) && Intrinsics.areEqual((Object) this.SaleInfoToolTip, (Object) saleInformation.SaleInfoToolTip)) {
                        if ((this.BranchCode == saleInformation.BranchCode) && Intrinsics.areEqual((Object) this.LocationName, (Object) saleInformation.LocationName) && Intrinsics.areEqual((Object) this.Address, (Object) saleInformation.Address) && Intrinsics.areEqual((Object) this.City, (Object) saleInformation.City) && Intrinsics.areEqual((Object) this.State, (Object) saleInformation.State) && Intrinsics.areEqual((Object) this.Zip, (Object) saleInformation.Zip) && Intrinsics.areEqual((Object) this.Phone, (Object) saleInformation.Phone)) {
                            if ((this.DisplayMoreLinkForRemote == saleInformation.DisplayMoreLinkForRemote) && Intrinsics.areEqual((Object) this.RemoteSaleInfo, (Object) saleInformation.RemoteSaleInfo)) {
                                if ((this.IsVehicleAtIAABranchForVirualBranch == saleInformation.IsVehicleAtIAABranchForVirualBranch) && Intrinsics.areEqual((Object) this.IaaBranchLocationForVirtualBranch, (Object) saleInformation.IaaBranchLocationForVirtualBranch)) {
                                    if (this.IaaBranchCodeForVirtualBranch == saleInformation.IaaBranchCodeForVirtualBranch) {
                                        if (!(this.TBOInd == saleInformation.TBOInd) || !Intrinsics.areEqual((Object) this.TBONotes, (Object) saleInformation.TBONotes) || !Intrinsics.areEqual((Object) this.Row, (Object) saleInformation.Row) || !Intrinsics.areEqual((Object) this.StallNumber, (Object) saleInformation.StallNumber)) {
                                            return false;
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
        String str = this.ACV;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.BranchLink;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Date;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.Day;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.EstimatedRepairCost;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z = this.IsVehicleAtBranch;
        if (z) {
            z = true;
        }
        int i2 = (hashCode5 + (z ? 1 : 0)) * 31;
        String str6 = this.Lane;
        int hashCode6 = (i2 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.LiveDateString;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.Month;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.SaleDoc;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        SaleInfo saleInfo = this.SaleInfo;
        int hashCode10 = (hashCode9 + (saleInfo != null ? saleInfo.hashCode() : 0)) * 31;
        String str10 = this.Seller;
        int hashCode11 = (hashCode10 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.Slot;
        int hashCode12 = (hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.Time;
        int hashCode13 = (hashCode12 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.TitleDocument;
        int hashCode14 = (hashCode13 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.TitleState;
        int hashCode15 = (hashCode14 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.UserTimezoneAbb;
        int hashCode16 = (hashCode15 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.SaleInfoToolTip;
        int hashCode17 = (((hashCode16 + (str16 != null ? str16.hashCode() : 0)) * 31) + Integer.valueOf(this.BranchCode).hashCode()) * 31;
        String str17 = this.LocationName;
        int hashCode18 = (hashCode17 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.Address;
        int hashCode19 = (hashCode18 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.City;
        int hashCode20 = (hashCode19 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.State;
        int hashCode21 = (hashCode20 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.Zip;
        int hashCode22 = (hashCode21 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.Phone;
        int hashCode23 = (hashCode22 + (str22 != null ? str22.hashCode() : 0)) * 31;
        boolean z2 = this.DisplayMoreLinkForRemote;
        if (z2) {
            z2 = true;
        }
        int i3 = (hashCode23 + (z2 ? 1 : 0)) * 31;
        String str23 = this.RemoteSaleInfo;
        int hashCode24 = (i3 + (str23 != null ? str23.hashCode() : 0)) * 31;
        boolean z3 = this.IsVehicleAtIAABranchForVirualBranch;
        if (z3) {
            z3 = true;
        }
        int i4 = (hashCode24 + (z3 ? 1 : 0)) * 31;
        String str24 = this.IaaBranchLocationForVirtualBranch;
        int hashCode25 = (((i4 + (str24 != null ? str24.hashCode() : 0)) * 31) + Integer.valueOf(this.IaaBranchCodeForVirtualBranch).hashCode()) * 31;
        boolean z4 = this.TBOInd;
        if (z4) {
            z4 = true;
        }
        int i5 = (hashCode25 + (z4 ? 1 : 0)) * 31;
        String str25 = this.TBONotes;
        int hashCode26 = (i5 + (str25 != null ? str25.hashCode() : 0)) * 31;
        String str26 = this.Row;
        int hashCode27 = (hashCode26 + (str26 != null ? str26.hashCode() : 0)) * 31;
        Integer num = this.StallNumber;
        if (num != null) {
            i = num.hashCode();
        }
        return hashCode27 + i;
    }

    @NotNull
    public String toString() {
        return "SaleInformation(ACV=" + this.ACV + ", BranchLink=" + this.BranchLink + ", Date=" + this.Date + ", Day=" + this.Day + ", EstimatedRepairCost=" + this.EstimatedRepairCost + ", IsVehicleAtBranch=" + this.IsVehicleAtBranch + ", Lane=" + this.Lane + ", LiveDateString=" + this.LiveDateString + ", Month=" + this.Month + ", SaleDoc=" + this.SaleDoc + ", SaleInfo=" + this.SaleInfo + ", Seller=" + this.Seller + ", Slot=" + this.Slot + ", Time=" + this.Time + ", TitleDocument=" + this.TitleDocument + ", TitleState=" + this.TitleState + ", UserTimezoneAbb=" + this.UserTimezoneAbb + ", SaleInfoToolTip=" + this.SaleInfoToolTip + ", BranchCode=" + this.BranchCode + ", LocationName=" + this.LocationName + ", Address=" + this.Address + ", City=" + this.City + ", State=" + this.State + ", Zip=" + this.Zip + ", Phone=" + this.Phone + ", DisplayMoreLinkForRemote=" + this.DisplayMoreLinkForRemote + ", RemoteSaleInfo=" + this.RemoteSaleInfo + ", IsVehicleAtIAABranchForVirualBranch=" + this.IsVehicleAtIAABranchForVirualBranch + ", IaaBranchLocationForVirtualBranch=" + this.IaaBranchLocationForVirtualBranch + ", IaaBranchCodeForVirtualBranch=" + this.IaaBranchCodeForVirtualBranch + ", TBOInd=" + this.TBOInd + ", TBONotes=" + this.TBONotes + ", Row=" + this.Row + ", StallNumber=" + this.StallNumber + ")";
    }

    public SaleInformation(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @Nullable String str5, boolean z, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull SaleInfo saleInfo, @NotNull String str10, @NotNull String str11, @NotNull String str12, @NotNull String str13, @NotNull String str14, @NotNull String str15, @NotNull String str16, int i, @Nullable String str17, @NotNull String str18, @NotNull String str19, @NotNull String str20, @NotNull String str21, @NotNull String str22, boolean z2, @NotNull String str23, boolean z3, @NotNull String str24, int i2, boolean z4, @Nullable String str25, @Nullable String str26, @Nullable Integer num) {
        String str27 = str2;
        String str28 = str3;
        String str29 = str4;
        String str30 = str6;
        String str31 = str7;
        String str32 = str8;
        String str33 = str9;
        SaleInfo saleInfo2 = saleInfo;
        String str34 = str10;
        String str35 = str11;
        String str36 = str12;
        String str37 = str13;
        String str38 = str14;
        String str39 = str15;
        String str40 = str18;
        Intrinsics.checkParameterIsNotNull(str27, "BranchLink");
        Intrinsics.checkParameterIsNotNull(str28, "Date");
        Intrinsics.checkParameterIsNotNull(str29, "Day");
        Intrinsics.checkParameterIsNotNull(str30, "Lane");
        Intrinsics.checkParameterIsNotNull(str31, "LiveDateString");
        Intrinsics.checkParameterIsNotNull(str32, "Month");
        Intrinsics.checkParameterIsNotNull(str33, "SaleDoc");
        Intrinsics.checkParameterIsNotNull(saleInfo2, "SaleInfo");
        Intrinsics.checkParameterIsNotNull(str34, "Seller");
        Intrinsics.checkParameterIsNotNull(str35, "Slot");
        Intrinsics.checkParameterIsNotNull(str36, "Time");
        Intrinsics.checkParameterIsNotNull(str37, "TitleDocument");
        Intrinsics.checkParameterIsNotNull(str38, "TitleState");
        Intrinsics.checkParameterIsNotNull(str39, "UserTimezoneAbb");
        Intrinsics.checkParameterIsNotNull(str16, "SaleInfoToolTip");
        Intrinsics.checkParameterIsNotNull(str18, "Address");
        Intrinsics.checkParameterIsNotNull(str19, "City");
        Intrinsics.checkParameterIsNotNull(str20, "State");
        Intrinsics.checkParameterIsNotNull(str21, "Zip");
        Intrinsics.checkParameterIsNotNull(str22, "Phone");
        Intrinsics.checkParameterIsNotNull(str23, "RemoteSaleInfo");
        Intrinsics.checkParameterIsNotNull(str24, "IaaBranchLocationForVirtualBranch");
        this.ACV = str;
        this.BranchLink = str27;
        this.Date = str28;
        this.Day = str29;
        this.EstimatedRepairCost = str5;
        this.IsVehicleAtBranch = z;
        this.Lane = str30;
        this.LiveDateString = str31;
        this.Month = str32;
        this.SaleDoc = str33;
        this.SaleInfo = saleInfo2;
        this.Seller = str34;
        this.Slot = str35;
        this.Time = str36;
        this.TitleDocument = str37;
        this.TitleState = str38;
        this.UserTimezoneAbb = str39;
        this.SaleInfoToolTip = str16;
        this.BranchCode = i;
        this.LocationName = str17;
        this.Address = str18;
        this.City = str19;
        this.State = str20;
        this.Zip = str21;
        this.Phone = str22;
        this.DisplayMoreLinkForRemote = z2;
        this.RemoteSaleInfo = str23;
        this.IsVehicleAtIAABranchForVirualBranch = z3;
        this.IaaBranchLocationForVirtualBranch = str24;
        this.IaaBranchCodeForVirtualBranch = i2;
        this.TBOInd = z4;
        this.TBONotes = str25;
        this.Row = str26;
        this.StallNumber = num;
    }

    @Nullable
    public final String getACV() {
        return this.ACV;
    }

    @NotNull
    public final String getBranchLink() {
        return this.BranchLink;
    }

    @NotNull
    public final String getDate() {
        return this.Date;
    }

    @NotNull
    public final String getDay() {
        return this.Day;
    }

    @Nullable
    public final String getEstimatedRepairCost() {
        return this.EstimatedRepairCost;
    }

    public final boolean getIsVehicleAtBranch() {
        return this.IsVehicleAtBranch;
    }

    @NotNull
    public final String getLane() {
        return this.Lane;
    }

    @NotNull
    public final String getLiveDateString() {
        return this.LiveDateString;
    }

    @NotNull
    public final String getMonth() {
        return this.Month;
    }

    @NotNull
    public final String getSaleDoc() {
        return this.SaleDoc;
    }

    @NotNull
    public final SaleInfo getSaleInfo() {
        return this.SaleInfo;
    }

    @NotNull
    public final String getSeller() {
        return this.Seller;
    }

    @NotNull
    public final String getSlot() {
        return this.Slot;
    }

    @NotNull
    public final String getTime() {
        return this.Time;
    }

    @NotNull
    public final String getTitleDocument() {
        return this.TitleDocument;
    }

    @NotNull
    public final String getTitleState() {
        return this.TitleState;
    }

    @NotNull
    public final String getUserTimezoneAbb() {
        return this.UserTimezoneAbb;
    }

    @NotNull
    public final String getSaleInfoToolTip() {
        return this.SaleInfoToolTip;
    }

    public final int getBranchCode() {
        return this.BranchCode;
    }

    @Nullable
    public final String getLocationName() {
        return this.LocationName;
    }

    @NotNull
    public final String getAddress() {
        return this.Address;
    }

    @NotNull
    public final String getCity() {
        return this.City;
    }

    @NotNull
    public final String getState() {
        return this.State;
    }

    @NotNull
    public final String getZip() {
        return this.Zip;
    }

    @NotNull
    public final String getPhone() {
        return this.Phone;
    }

    public final boolean getDisplayMoreLinkForRemote() {
        return this.DisplayMoreLinkForRemote;
    }

    @NotNull
    public final String getRemoteSaleInfo() {
        return this.RemoteSaleInfo;
    }

    public final boolean getIsVehicleAtIAABranchForVirualBranch() {
        return this.IsVehicleAtIAABranchForVirualBranch;
    }

    @NotNull
    public final String getIaaBranchLocationForVirtualBranch() {
        return this.IaaBranchLocationForVirtualBranch;
    }

    public final int getIaaBranchCodeForVirtualBranch() {
        return this.IaaBranchCodeForVirtualBranch;
    }

    public final boolean getTBOInd() {
        return this.TBOInd;
    }

    public final void setTBOInd(boolean z) {
        this.TBOInd = z;
    }

    @Nullable
    public final String getTBONotes() {
        return this.TBONotes;
    }

    public final void setTBONotes(@Nullable String str) {
        this.TBONotes = str;
    }

    @Nullable
    public final String getRow() {
        return this.Row;
    }

    public final void setRow(@Nullable String str) {
        this.Row = str;
    }

    @Nullable
    public final Integer getStallNumber() {
        return this.StallNumber;
    }

    public final void setStallNumber(@Nullable Integer num) {
        this.StallNumber = num;
    }
}
