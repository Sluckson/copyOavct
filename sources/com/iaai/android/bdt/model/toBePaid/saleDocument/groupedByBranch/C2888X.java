package com.iaai.android.bdt.model.toBePaid.saleDocument.groupedByBranch;

import com.google.android.exoplayer2.C1119C;
import com.iaai.android.old.analytics.AnalyticsContract;
import com.lowagie.text.pdf.PdfFormField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\bm\b\b\u0018\u00002\u00020\u0001Bµ\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0001\u0012\u0006\u0010\r\u001a\u00020\u0001\u0012\u0006\u0010\u000e\u001a\u00020\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0001\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0001\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\b\u0012\u0006\u0010\u0019\u001a\u00020\u0001\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0001\u0012\u0006\u0010\u001c\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\u0006\u0010\u001e\u001a\u00020\u0006\u0012\u0006\u0010\u001f\u001a\u00020\u0013\u0012\u0006\u0010 \u001a\u00020\u0001\u0012\u0006\u0010!\u001a\u00020\b\u0012\u0006\u0010\"\u001a\u00020\u0001\u0012\u0006\u0010#\u001a\u00020\b\u0012\u0006\u0010$\u001a\u00020\u0001\u0012\u0006\u0010%\u001a\u00020\u0001\u0012\u0006\u0010&\u001a\u00020\u0001\u0012\u0006\u0010'\u001a\u00020\b\u0012\u0006\u0010(\u001a\u00020\b\u0012\u0006\u0010)\u001a\u00020\u0001\u0012\u0006\u0010*\u001a\u00020\b¢\u0006\u0002\u0010+J\t\u0010U\u001a\u00020\u0001HÆ\u0003J\t\u0010V\u001a\u00020\u0001HÆ\u0003J\t\u0010W\u001a\u00020\u0001HÆ\u0003J\t\u0010X\u001a\u00020\u0001HÆ\u0003J\t\u0010Y\u001a\u00020\u0006HÆ\u0003J\t\u0010Z\u001a\u00020\u0001HÆ\u0003J\t\u0010[\u001a\u00020\u0013HÆ\u0003J\t\u0010\\\u001a\u00020\u0013HÆ\u0003J\t\u0010]\u001a\u00020\u0013HÆ\u0003J\t\u0010^\u001a\u00020\u0006HÆ\u0003J\t\u0010_\u001a\u00020\u0013HÆ\u0003J\t\u0010`\u001a\u00020\u0001HÆ\u0003J\t\u0010a\u001a\u00020\bHÆ\u0003J\t\u0010b\u001a\u00020\u0001HÆ\u0003J\t\u0010c\u001a\u00020\u0013HÆ\u0003J\t\u0010d\u001a\u00020\u0001HÆ\u0003J\t\u0010e\u001a\u00020\u0006HÆ\u0003J\t\u0010f\u001a\u00020\u0006HÆ\u0003J\t\u0010g\u001a\u00020\u0006HÆ\u0003J\t\u0010h\u001a\u00020\u0013HÆ\u0003J\t\u0010i\u001a\u00020\u0001HÆ\u0003J\t\u0010j\u001a\u00020\bHÆ\u0003J\t\u0010k\u001a\u00020\u0001HÆ\u0003J\t\u0010l\u001a\u00020\u0001HÆ\u0003J\t\u0010m\u001a\u00020\bHÆ\u0003J\t\u0010n\u001a\u00020\u0001HÆ\u0003J\t\u0010o\u001a\u00020\u0001HÆ\u0003J\t\u0010p\u001a\u00020\u0001HÆ\u0003J\t\u0010q\u001a\u00020\bHÆ\u0003J\t\u0010r\u001a\u00020\bHÆ\u0003J\t\u0010s\u001a\u00020\u0001HÆ\u0003J\t\u0010t\u001a\u00020\bHÆ\u0003J\t\u0010u\u001a\u00020\u0006HÆ\u0003J\t\u0010v\u001a\u00020\bHÆ\u0003J\t\u0010w\u001a\u00020\u0006HÆ\u0003J\t\u0010x\u001a\u00020\u0001HÆ\u0003J\t\u0010y\u001a\u00020\u0006HÆ\u0003J\t\u0010z\u001a\u00020\u0001HÆ\u0003J\u0003\u0010{\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00012\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00012\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u00012\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\b\b\u0002\u0010\u001e\u001a\u00020\u00062\b\b\u0002\u0010\u001f\u001a\u00020\u00132\b\b\u0002\u0010 \u001a\u00020\u00012\b\b\u0002\u0010!\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\u00012\b\b\u0002\u0010#\u001a\u00020\b2\b\b\u0002\u0010$\u001a\u00020\u00012\b\b\u0002\u0010%\u001a\u00020\u00012\b\b\u0002\u0010&\u001a\u00020\u00012\b\b\u0002\u0010'\u001a\u00020\b2\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\u00012\b\b\u0002\u0010*\u001a\u00020\bHÆ\u0001J\u0013\u0010|\u001a\u00020\u00132\b\u0010}\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010~\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0011\u0010\u0004\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b/\u0010-R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u00101R\u0011\u0010\n\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b5\u0010-R\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u00101R\u0011\u0010\f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b7\u0010-R\u0011\u0010\r\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b8\u0010-R\u0011\u0010\u000e\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b9\u0010-R\u0011\u0010\u000f\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b:\u0010-R\u0011\u0010\u0010\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b;\u00101R\u0011\u0010\u0011\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b<\u0010-R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b?\u0010>R\u0011\u0010\u0015\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b@\u0010>R\u0011\u0010\u0016\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bA\u00101R\u0011\u0010\u0017\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bB\u0010>R\u0011\u0010\u0018\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bC\u00103R\u0011\u0010\u0019\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bD\u0010-R\u0011\u0010\u001a\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bE\u0010>R\u0011\u0010\u001b\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bF\u0010-R\u0011\u0010\u001c\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bG\u00101R\u0011\u0010\u001d\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bH\u00101R\u0011\u0010\u001e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bI\u00101R\u0011\u0010\u001f\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010>R\u0011\u0010 \u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bK\u0010-R\u0011\u0010!\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bL\u00103R\u0011\u0010\"\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bM\u0010-R\u0011\u0010#\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bN\u00103R\u0011\u0010$\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bO\u0010-R\u0011\u0010%\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bP\u0010-R\u0011\u0010&\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010-R\u0011\u0010'\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bR\u00103R\u0011\u0010(\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bS\u00103R\u0011\u0010)\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\bT\u0010-R\u0011\u0010*\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\bK\u00103¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/saleDocument/groupedByBranch/X;", "", "AdditionalNotes", "Address1", "Address2", "BranchCode", "", "BranchName", "", "BuyerId", "BuyerNotes", "BuyerTitleHandlingInstructionID", "City", "CompanyName", "Country", "DtPickedUp", "EmployeeId", "FedexAccountNumber", "InstructionOverrideInd", "", "IsStockFinance", "IsTitleMailingAddressChanged", "OAAuctionItemId", "OffsiteSaleInd", "OwnerName", "PhoneNumber", "PublicBuyerRestrictionStateInd", "RepresentativeName", "RowNumber", "SalvageID", "SalvageSaleID", "ShowStockNoUrl", "State", "StockNumber", "TitleDeliveryMethodCode", "TitleStatus", "TrackingNumber", "TransportationShippingFee", "UseMailingInd", "VIN", "VehicleDescription", "ZipCode", "state", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/String;ILjava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;ZZZIZLjava/lang/String;Ljava/lang/Object;ZLjava/lang/Object;IIIZLjava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;)V", "getAdditionalNotes", "()Ljava/lang/Object;", "getAddress1", "getAddress2", "getBranchCode", "()I", "getBranchName", "()Ljava/lang/String;", "getBuyerId", "getBuyerNotes", "getBuyerTitleHandlingInstructionID", "getCity", "getCompanyName", "getCountry", "getDtPickedUp", "getEmployeeId", "getFedexAccountNumber", "getInstructionOverrideInd", "()Z", "getIsStockFinance", "getIsTitleMailingAddressChanged", "getOAAuctionItemId", "getOffsiteSaleInd", "getOwnerName", "getPhoneNumber", "getPublicBuyerRestrictionStateInd", "getRepresentativeName", "getRowNumber", "getSalvageID", "getSalvageSaleID", "getShowStockNoUrl", "getState", "getStockNumber", "getTitleDeliveryMethodCode", "getTitleStatus", "getTrackingNumber", "getTransportationShippingFee", "getUseMailingInd", "getVIN", "getVehicleDescription", "getZipCode", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* renamed from: com.iaai.android.bdt.model.toBePaid.saleDocument.groupedByBranch.X */
/* compiled from: X.kt */
public final class C2888X {
    @NotNull
    private final Object AdditionalNotes;
    @NotNull
    private final Object Address1;
    @NotNull
    private final Object Address2;
    private final int BranchCode;
    @NotNull
    private final String BranchName;
    private final int BuyerId;
    @NotNull
    private final Object BuyerNotes;
    private final int BuyerTitleHandlingInstructionID;
    @NotNull
    private final Object City;
    @NotNull
    private final Object CompanyName;
    @NotNull
    private final Object Country;
    @NotNull
    private final Object DtPickedUp;
    private final int EmployeeId;
    @NotNull
    private final Object FedexAccountNumber;
    private final boolean InstructionOverrideInd;
    private final boolean IsStockFinance;
    private final boolean IsTitleMailingAddressChanged;
    private final int OAAuctionItemId;
    private final boolean OffsiteSaleInd;
    @NotNull
    private final String OwnerName;
    @NotNull
    private final Object PhoneNumber;
    private final boolean PublicBuyerRestrictionStateInd;
    @NotNull
    private final Object RepresentativeName;
    private final int RowNumber;
    private final int SalvageID;
    private final int SalvageSaleID;
    private final boolean ShowStockNoUrl;
    @NotNull
    private final Object State;
    @NotNull
    private final String StockNumber;
    @NotNull
    private final Object TitleDeliveryMethodCode;
    @NotNull
    private final String TitleStatus;
    @NotNull
    private final Object TrackingNumber;
    @NotNull
    private final Object TransportationShippingFee;
    @NotNull
    private final Object UseMailingInd;
    @NotNull
    private final String VIN;
    @NotNull
    private final String VehicleDescription;
    @NotNull
    private final Object ZipCode;
    @NotNull
    private final String state;

    @NotNull
    public static /* synthetic */ C2888X copy$default(C2888X x, Object obj, Object obj2, Object obj3, int i, String str, int i2, Object obj4, int i3, Object obj5, Object obj6, Object obj7, Object obj8, int i4, Object obj9, boolean z, boolean z2, boolean z3, int i5, boolean z4, String str2, Object obj10, boolean z5, Object obj11, int i6, int i7, int i8, boolean z6, Object obj12, String str3, Object obj13, String str4, Object obj14, Object obj15, Object obj16, String str5, String str6, Object obj17, String str7, int i9, int i10, Object obj18) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        int i11;
        int i12;
        boolean z12;
        boolean z13;
        String str8;
        String str9;
        Object obj19;
        Object obj20;
        boolean z14;
        boolean z15;
        Object obj21;
        Object obj22;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z16;
        boolean z17;
        Object obj23;
        Object obj24;
        String str10;
        String str11;
        Object obj25;
        Object obj26;
        String str12;
        Object obj27;
        Object obj28;
        Object obj29;
        Object obj30;
        Object obj31;
        String str13;
        String str14;
        String str15;
        String str16;
        Object obj32;
        Object obj33;
        String str17;
        C2888X x2 = x;
        int i19 = i9;
        Object obj34 = (i19 & 1) != 0 ? x2.AdditionalNotes : obj;
        Object obj35 = (i19 & 2) != 0 ? x2.Address1 : obj2;
        Object obj36 = (i19 & 4) != 0 ? x2.Address2 : obj3;
        int i20 = (i19 & 8) != 0 ? x2.BranchCode : i;
        String str18 = (i19 & 16) != 0 ? x2.BranchName : str;
        int i21 = (i19 & 32) != 0 ? x2.BuyerId : i2;
        Object obj37 = (i19 & 64) != 0 ? x2.BuyerNotes : obj4;
        int i22 = (i19 & 128) != 0 ? x2.BuyerTitleHandlingInstructionID : i3;
        Object obj38 = (i19 & 256) != 0 ? x2.City : obj5;
        Object obj39 = (i19 & 512) != 0 ? x2.CompanyName : obj6;
        Object obj40 = (i19 & 1024) != 0 ? x2.Country : obj7;
        Object obj41 = (i19 & 2048) != 0 ? x2.DtPickedUp : obj8;
        int i23 = (i19 & 4096) != 0 ? x2.EmployeeId : i4;
        Object obj42 = (i19 & 8192) != 0 ? x2.FedexAccountNumber : obj9;
        boolean z18 = (i19 & 16384) != 0 ? x2.InstructionOverrideInd : z;
        if ((i19 & 32768) != 0) {
            z7 = z18;
            z8 = x2.IsStockFinance;
        } else {
            z7 = z18;
            z8 = z2;
        }
        if ((i19 & 65536) != 0) {
            z9 = z8;
            z10 = x2.IsTitleMailingAddressChanged;
        } else {
            z9 = z8;
            z10 = z3;
        }
        if ((i19 & 131072) != 0) {
            z11 = z10;
            i11 = x2.OAAuctionItemId;
        } else {
            z11 = z10;
            i11 = i5;
        }
        if ((i19 & 262144) != 0) {
            i12 = i11;
            z12 = x2.OffsiteSaleInd;
        } else {
            i12 = i11;
            z12 = z4;
        }
        if ((i19 & 524288) != 0) {
            z13 = z12;
            str8 = x2.OwnerName;
        } else {
            z13 = z12;
            str8 = str2;
        }
        if ((i19 & 1048576) != 0) {
            str9 = str8;
            obj19 = x2.PhoneNumber;
        } else {
            str9 = str8;
            obj19 = obj10;
        }
        if ((i19 & 2097152) != 0) {
            obj20 = obj19;
            z14 = x2.PublicBuyerRestrictionStateInd;
        } else {
            obj20 = obj19;
            z14 = z5;
        }
        if ((i19 & 4194304) != 0) {
            z15 = z14;
            obj21 = x2.RepresentativeName;
        } else {
            z15 = z14;
            obj21 = obj11;
        }
        if ((i19 & 8388608) != 0) {
            obj22 = obj21;
            i13 = x2.RowNumber;
        } else {
            obj22 = obj21;
            i13 = i6;
        }
        if ((i19 & 16777216) != 0) {
            i14 = i13;
            i15 = x2.SalvageID;
        } else {
            i14 = i13;
            i15 = i7;
        }
        if ((i19 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            i16 = i15;
            i17 = x2.SalvageSaleID;
        } else {
            i16 = i15;
            i17 = i8;
        }
        if ((i19 & 67108864) != 0) {
            i18 = i17;
            z16 = x2.ShowStockNoUrl;
        } else {
            i18 = i17;
            z16 = z6;
        }
        if ((i19 & 134217728) != 0) {
            z17 = z16;
            obj23 = x2.State;
        } else {
            z17 = z16;
            obj23 = obj12;
        }
        if ((i19 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            obj24 = obj23;
            str10 = x2.StockNumber;
        } else {
            obj24 = obj23;
            str10 = str3;
        }
        if ((i19 & 536870912) != 0) {
            str11 = str10;
            obj25 = x2.TitleDeliveryMethodCode;
        } else {
            str11 = str10;
            obj25 = obj13;
        }
        if ((i19 & 1073741824) != 0) {
            obj26 = obj25;
            str12 = x2.TitleStatus;
        } else {
            obj26 = obj25;
            str12 = str4;
        }
        Object obj43 = (i19 & Integer.MIN_VALUE) != 0 ? x2.TrackingNumber : obj14;
        if ((i10 & 1) != 0) {
            obj27 = obj43;
            obj28 = x2.TransportationShippingFee;
        } else {
            obj27 = obj43;
            obj28 = obj15;
        }
        if ((i10 & 2) != 0) {
            obj29 = obj28;
            obj30 = x2.UseMailingInd;
        } else {
            obj29 = obj28;
            obj30 = obj16;
        }
        if ((i10 & 4) != 0) {
            obj31 = obj30;
            str13 = x2.VIN;
        } else {
            obj31 = obj30;
            str13 = str5;
        }
        if ((i10 & 8) != 0) {
            str14 = str13;
            str15 = x2.VehicleDescription;
        } else {
            str14 = str13;
            str15 = str6;
        }
        if ((i10 & 16) != 0) {
            str16 = str15;
            obj32 = x2.ZipCode;
        } else {
            str16 = str15;
            obj32 = obj17;
        }
        if ((i10 & 32) != 0) {
            obj33 = obj32;
            str17 = x2.state;
        } else {
            obj33 = obj32;
            str17 = str7;
        }
        return x.copy(obj34, obj35, obj36, i20, str18, i21, obj37, i22, obj38, obj39, obj40, obj41, i23, obj42, z7, z9, z11, i12, z13, str9, obj20, z15, obj22, i14, i16, i18, z17, obj24, str11, obj26, str12, obj27, obj29, obj31, str14, str16, obj33, str17);
    }

    @NotNull
    public final Object component1() {
        return this.AdditionalNotes;
    }

    @NotNull
    public final Object component10() {
        return this.CompanyName;
    }

    @NotNull
    public final Object component11() {
        return this.Country;
    }

    @NotNull
    public final Object component12() {
        return this.DtPickedUp;
    }

    public final int component13() {
        return this.EmployeeId;
    }

    @NotNull
    public final Object component14() {
        return this.FedexAccountNumber;
    }

    public final boolean component15() {
        return this.InstructionOverrideInd;
    }

    public final boolean component16() {
        return this.IsStockFinance;
    }

    public final boolean component17() {
        return this.IsTitleMailingAddressChanged;
    }

    public final int component18() {
        return this.OAAuctionItemId;
    }

    public final boolean component19() {
        return this.OffsiteSaleInd;
    }

    @NotNull
    public final Object component2() {
        return this.Address1;
    }

    @NotNull
    public final String component20() {
        return this.OwnerName;
    }

    @NotNull
    public final Object component21() {
        return this.PhoneNumber;
    }

    public final boolean component22() {
        return this.PublicBuyerRestrictionStateInd;
    }

    @NotNull
    public final Object component23() {
        return this.RepresentativeName;
    }

    public final int component24() {
        return this.RowNumber;
    }

    public final int component25() {
        return this.SalvageID;
    }

    public final int component26() {
        return this.SalvageSaleID;
    }

    public final boolean component27() {
        return this.ShowStockNoUrl;
    }

    @NotNull
    public final Object component28() {
        return this.State;
    }

    @NotNull
    public final String component29() {
        return this.StockNumber;
    }

    @NotNull
    public final Object component3() {
        return this.Address2;
    }

    @NotNull
    public final Object component30() {
        return this.TitleDeliveryMethodCode;
    }

    @NotNull
    public final String component31() {
        return this.TitleStatus;
    }

    @NotNull
    public final Object component32() {
        return this.TrackingNumber;
    }

    @NotNull
    public final Object component33() {
        return this.TransportationShippingFee;
    }

    @NotNull
    public final Object component34() {
        return this.UseMailingInd;
    }

    @NotNull
    public final String component35() {
        return this.VIN;
    }

    @NotNull
    public final String component36() {
        return this.VehicleDescription;
    }

    @NotNull
    public final Object component37() {
        return this.ZipCode;
    }

    @NotNull
    public final String component38() {
        return this.state;
    }

    public final int component4() {
        return this.BranchCode;
    }

    @NotNull
    public final String component5() {
        return this.BranchName;
    }

    public final int component6() {
        return this.BuyerId;
    }

    @NotNull
    public final Object component7() {
        return this.BuyerNotes;
    }

    public final int component8() {
        return this.BuyerTitleHandlingInstructionID;
    }

    @NotNull
    public final Object component9() {
        return this.City;
    }

    @NotNull
    public final C2888X copy(@NotNull Object obj, @NotNull Object obj2, @NotNull Object obj3, int i, @NotNull String str, int i2, @NotNull Object obj4, int i3, @NotNull Object obj5, @NotNull Object obj6, @NotNull Object obj7, @NotNull Object obj8, int i4, @NotNull Object obj9, boolean z, boolean z2, boolean z3, int i5, boolean z4, @NotNull String str2, @NotNull Object obj10, boolean z5, @NotNull Object obj11, int i6, int i7, int i8, boolean z6, @NotNull Object obj12, @NotNull String str3, @NotNull Object obj13, @NotNull String str4, @NotNull Object obj14, @NotNull Object obj15, @NotNull Object obj16, @NotNull String str5, @NotNull String str6, @NotNull Object obj17, @NotNull String str7) {
        Object obj18 = obj;
        Intrinsics.checkParameterIsNotNull(obj18, "AdditionalNotes");
        Intrinsics.checkParameterIsNotNull(obj2, "Address1");
        Intrinsics.checkParameterIsNotNull(obj3, "Address2");
        Intrinsics.checkParameterIsNotNull(str, "BranchName");
        Intrinsics.checkParameterIsNotNull(obj4, "BuyerNotes");
        Intrinsics.checkParameterIsNotNull(obj5, "City");
        Intrinsics.checkParameterIsNotNull(obj6, "CompanyName");
        Intrinsics.checkParameterIsNotNull(obj7, "Country");
        Intrinsics.checkParameterIsNotNull(obj8, "DtPickedUp");
        Intrinsics.checkParameterIsNotNull(obj9, "FedexAccountNumber");
        Intrinsics.checkParameterIsNotNull(str2, "OwnerName");
        Intrinsics.checkParameterIsNotNull(obj10, "PhoneNumber");
        Intrinsics.checkParameterIsNotNull(obj11, "RepresentativeName");
        Intrinsics.checkParameterIsNotNull(obj12, "State");
        Intrinsics.checkParameterIsNotNull(str3, AnalyticsContract.Analytics.COLUMN_NAME_STOCK_NO);
        Intrinsics.checkParameterIsNotNull(obj13, "TitleDeliveryMethodCode");
        Intrinsics.checkParameterIsNotNull(str4, "TitleStatus");
        Intrinsics.checkParameterIsNotNull(obj14, "TrackingNumber");
        Intrinsics.checkParameterIsNotNull(obj15, "TransportationShippingFee");
        Intrinsics.checkParameterIsNotNull(obj16, "UseMailingInd");
        Intrinsics.checkParameterIsNotNull(str5, "VIN");
        Intrinsics.checkParameterIsNotNull(str6, "VehicleDescription");
        Intrinsics.checkParameterIsNotNull(obj17, "ZipCode");
        Intrinsics.checkParameterIsNotNull(str7, "state");
        return new C2888X(obj18, obj2, obj3, i, str, i2, obj4, i3, obj5, obj6, obj7, obj8, i4, obj9, z, z2, z3, i5, z4, str2, obj10, z5, obj11, i6, i7, i8, z6, obj12, str3, obj13, str4, obj14, obj15, obj16, str5, str6, obj17, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof C2888X) {
                C2888X x = (C2888X) obj;
                if (Intrinsics.areEqual(this.AdditionalNotes, x.AdditionalNotes) && Intrinsics.areEqual(this.Address1, x.Address1) && Intrinsics.areEqual(this.Address2, x.Address2)) {
                    if ((this.BranchCode == x.BranchCode) && Intrinsics.areEqual((Object) this.BranchName, (Object) x.BranchName)) {
                        if ((this.BuyerId == x.BuyerId) && Intrinsics.areEqual(this.BuyerNotes, x.BuyerNotes)) {
                            if ((this.BuyerTitleHandlingInstructionID == x.BuyerTitleHandlingInstructionID) && Intrinsics.areEqual(this.City, x.City) && Intrinsics.areEqual(this.CompanyName, x.CompanyName) && Intrinsics.areEqual(this.Country, x.Country) && Intrinsics.areEqual(this.DtPickedUp, x.DtPickedUp)) {
                                if ((this.EmployeeId == x.EmployeeId) && Intrinsics.areEqual(this.FedexAccountNumber, x.FedexAccountNumber)) {
                                    if (this.InstructionOverrideInd == x.InstructionOverrideInd) {
                                        if (this.IsStockFinance == x.IsStockFinance) {
                                            if (this.IsTitleMailingAddressChanged == x.IsTitleMailingAddressChanged) {
                                                if (this.OAAuctionItemId == x.OAAuctionItemId) {
                                                    if ((this.OffsiteSaleInd == x.OffsiteSaleInd) && Intrinsics.areEqual((Object) this.OwnerName, (Object) x.OwnerName) && Intrinsics.areEqual(this.PhoneNumber, x.PhoneNumber)) {
                                                        if ((this.PublicBuyerRestrictionStateInd == x.PublicBuyerRestrictionStateInd) && Intrinsics.areEqual(this.RepresentativeName, x.RepresentativeName)) {
                                                            if (this.RowNumber == x.RowNumber) {
                                                                if (this.SalvageID == x.SalvageID) {
                                                                    if (this.SalvageSaleID == x.SalvageSaleID) {
                                                                        if (!(this.ShowStockNoUrl == x.ShowStockNoUrl) || !Intrinsics.areEqual(this.State, x.State) || !Intrinsics.areEqual((Object) this.StockNumber, (Object) x.StockNumber) || !Intrinsics.areEqual(this.TitleDeliveryMethodCode, x.TitleDeliveryMethodCode) || !Intrinsics.areEqual((Object) this.TitleStatus, (Object) x.TitleStatus) || !Intrinsics.areEqual(this.TrackingNumber, x.TrackingNumber) || !Intrinsics.areEqual(this.TransportationShippingFee, x.TransportationShippingFee) || !Intrinsics.areEqual(this.UseMailingInd, x.UseMailingInd) || !Intrinsics.areEqual((Object) this.VIN, (Object) x.VIN) || !Intrinsics.areEqual((Object) this.VehicleDescription, (Object) x.VehicleDescription) || !Intrinsics.areEqual(this.ZipCode, x.ZipCode) || !Intrinsics.areEqual((Object) this.state, (Object) x.state)) {
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
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object obj = this.AdditionalNotes;
        int i = 0;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.Address1;
        int hashCode2 = (hashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Object obj3 = this.Address2;
        int hashCode3 = (((hashCode2 + (obj3 != null ? obj3.hashCode() : 0)) * 31) + Integer.valueOf(this.BranchCode).hashCode()) * 31;
        String str = this.BranchName;
        int hashCode4 = (((hashCode3 + (str != null ? str.hashCode() : 0)) * 31) + Integer.valueOf(this.BuyerId).hashCode()) * 31;
        Object obj4 = this.BuyerNotes;
        int hashCode5 = (((hashCode4 + (obj4 != null ? obj4.hashCode() : 0)) * 31) + Integer.valueOf(this.BuyerTitleHandlingInstructionID).hashCode()) * 31;
        Object obj5 = this.City;
        int hashCode6 = (hashCode5 + (obj5 != null ? obj5.hashCode() : 0)) * 31;
        Object obj6 = this.CompanyName;
        int hashCode7 = (hashCode6 + (obj6 != null ? obj6.hashCode() : 0)) * 31;
        Object obj7 = this.Country;
        int hashCode8 = (hashCode7 + (obj7 != null ? obj7.hashCode() : 0)) * 31;
        Object obj8 = this.DtPickedUp;
        int hashCode9 = (((hashCode8 + (obj8 != null ? obj8.hashCode() : 0)) * 31) + Integer.valueOf(this.EmployeeId).hashCode()) * 31;
        Object obj9 = this.FedexAccountNumber;
        int hashCode10 = (hashCode9 + (obj9 != null ? obj9.hashCode() : 0)) * 31;
        boolean z = this.InstructionOverrideInd;
        if (z) {
            z = true;
        }
        int i2 = (hashCode10 + (z ? 1 : 0)) * 31;
        boolean z2 = this.IsStockFinance;
        if (z2) {
            z2 = true;
        }
        int i3 = (i2 + (z2 ? 1 : 0)) * 31;
        boolean z3 = this.IsTitleMailingAddressChanged;
        if (z3) {
            z3 = true;
        }
        int hashCode11 = (((i3 + (z3 ? 1 : 0)) * 31) + Integer.valueOf(this.OAAuctionItemId).hashCode()) * 31;
        boolean z4 = this.OffsiteSaleInd;
        if (z4) {
            z4 = true;
        }
        int i4 = (hashCode11 + (z4 ? 1 : 0)) * 31;
        String str2 = this.OwnerName;
        int hashCode12 = (i4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Object obj10 = this.PhoneNumber;
        int hashCode13 = (hashCode12 + (obj10 != null ? obj10.hashCode() : 0)) * 31;
        boolean z5 = this.PublicBuyerRestrictionStateInd;
        if (z5) {
            z5 = true;
        }
        int i5 = (hashCode13 + (z5 ? 1 : 0)) * 31;
        Object obj11 = this.RepresentativeName;
        int hashCode14 = (((((((i5 + (obj11 != null ? obj11.hashCode() : 0)) * 31) + Integer.valueOf(this.RowNumber).hashCode()) * 31) + Integer.valueOf(this.SalvageID).hashCode()) * 31) + Integer.valueOf(this.SalvageSaleID).hashCode()) * 31;
        boolean z6 = this.ShowStockNoUrl;
        if (z6) {
            z6 = true;
        }
        int i6 = (hashCode14 + (z6 ? 1 : 0)) * 31;
        Object obj12 = this.State;
        int hashCode15 = (i6 + (obj12 != null ? obj12.hashCode() : 0)) * 31;
        String str3 = this.StockNumber;
        int hashCode16 = (hashCode15 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Object obj13 = this.TitleDeliveryMethodCode;
        int hashCode17 = (hashCode16 + (obj13 != null ? obj13.hashCode() : 0)) * 31;
        String str4 = this.TitleStatus;
        int hashCode18 = (hashCode17 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Object obj14 = this.TrackingNumber;
        int hashCode19 = (hashCode18 + (obj14 != null ? obj14.hashCode() : 0)) * 31;
        Object obj15 = this.TransportationShippingFee;
        int hashCode20 = (hashCode19 + (obj15 != null ? obj15.hashCode() : 0)) * 31;
        Object obj16 = this.UseMailingInd;
        int hashCode21 = (hashCode20 + (obj16 != null ? obj16.hashCode() : 0)) * 31;
        String str5 = this.VIN;
        int hashCode22 = (hashCode21 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.VehicleDescription;
        int hashCode23 = (hashCode22 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Object obj17 = this.ZipCode;
        int hashCode24 = (hashCode23 + (obj17 != null ? obj17.hashCode() : 0)) * 31;
        String str7 = this.state;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode24 + i;
    }

    @NotNull
    public String toString() {
        return "X(AdditionalNotes=" + this.AdditionalNotes + ", Address1=" + this.Address1 + ", Address2=" + this.Address2 + ", BranchCode=" + this.BranchCode + ", BranchName=" + this.BranchName + ", BuyerId=" + this.BuyerId + ", BuyerNotes=" + this.BuyerNotes + ", BuyerTitleHandlingInstructionID=" + this.BuyerTitleHandlingInstructionID + ", City=" + this.City + ", CompanyName=" + this.CompanyName + ", Country=" + this.Country + ", DtPickedUp=" + this.DtPickedUp + ", EmployeeId=" + this.EmployeeId + ", FedexAccountNumber=" + this.FedexAccountNumber + ", InstructionOverrideInd=" + this.InstructionOverrideInd + ", IsStockFinance=" + this.IsStockFinance + ", IsTitleMailingAddressChanged=" + this.IsTitleMailingAddressChanged + ", OAAuctionItemId=" + this.OAAuctionItemId + ", OffsiteSaleInd=" + this.OffsiteSaleInd + ", OwnerName=" + this.OwnerName + ", PhoneNumber=" + this.PhoneNumber + ", PublicBuyerRestrictionStateInd=" + this.PublicBuyerRestrictionStateInd + ", RepresentativeName=" + this.RepresentativeName + ", RowNumber=" + this.RowNumber + ", SalvageID=" + this.SalvageID + ", SalvageSaleID=" + this.SalvageSaleID + ", ShowStockNoUrl=" + this.ShowStockNoUrl + ", State=" + this.State + ", StockNumber=" + this.StockNumber + ", TitleDeliveryMethodCode=" + this.TitleDeliveryMethodCode + ", TitleStatus=" + this.TitleStatus + ", TrackingNumber=" + this.TrackingNumber + ", TransportationShippingFee=" + this.TransportationShippingFee + ", UseMailingInd=" + this.UseMailingInd + ", VIN=" + this.VIN + ", VehicleDescription=" + this.VehicleDescription + ", ZipCode=" + this.ZipCode + ", state=" + this.state + ")";
    }

    public C2888X(@NotNull Object obj, @NotNull Object obj2, @NotNull Object obj3, int i, @NotNull String str, int i2, @NotNull Object obj4, int i3, @NotNull Object obj5, @NotNull Object obj6, @NotNull Object obj7, @NotNull Object obj8, int i4, @NotNull Object obj9, boolean z, boolean z2, boolean z3, int i5, boolean z4, @NotNull String str2, @NotNull Object obj10, boolean z5, @NotNull Object obj11, int i6, int i7, int i8, boolean z6, @NotNull Object obj12, @NotNull String str3, @NotNull Object obj13, @NotNull String str4, @NotNull Object obj14, @NotNull Object obj15, @NotNull Object obj16, @NotNull String str5, @NotNull String str6, @NotNull Object obj17, @NotNull String str7) {
        Object obj18 = obj;
        Object obj19 = obj2;
        Object obj20 = obj3;
        String str8 = str;
        Object obj21 = obj4;
        Object obj22 = obj5;
        Object obj23 = obj6;
        Object obj24 = obj7;
        Object obj25 = obj8;
        Object obj26 = obj9;
        String str9 = str2;
        Object obj27 = obj10;
        Object obj28 = obj11;
        Object obj29 = obj12;
        Object obj30 = obj13;
        Intrinsics.checkParameterIsNotNull(obj18, "AdditionalNotes");
        Intrinsics.checkParameterIsNotNull(obj19, "Address1");
        Intrinsics.checkParameterIsNotNull(obj20, "Address2");
        Intrinsics.checkParameterIsNotNull(str8, "BranchName");
        Intrinsics.checkParameterIsNotNull(obj21, "BuyerNotes");
        Intrinsics.checkParameterIsNotNull(obj22, "City");
        Intrinsics.checkParameterIsNotNull(obj23, "CompanyName");
        Intrinsics.checkParameterIsNotNull(obj24, "Country");
        Intrinsics.checkParameterIsNotNull(obj25, "DtPickedUp");
        Intrinsics.checkParameterIsNotNull(obj26, "FedexAccountNumber");
        Intrinsics.checkParameterIsNotNull(str9, "OwnerName");
        Intrinsics.checkParameterIsNotNull(obj27, "PhoneNumber");
        Intrinsics.checkParameterIsNotNull(obj28, "RepresentativeName");
        Intrinsics.checkParameterIsNotNull(obj29, "State");
        Intrinsics.checkParameterIsNotNull(str3, AnalyticsContract.Analytics.COLUMN_NAME_STOCK_NO);
        Intrinsics.checkParameterIsNotNull(obj13, "TitleDeliveryMethodCode");
        Intrinsics.checkParameterIsNotNull(str4, "TitleStatus");
        Intrinsics.checkParameterIsNotNull(obj14, "TrackingNumber");
        Intrinsics.checkParameterIsNotNull(obj15, "TransportationShippingFee");
        Intrinsics.checkParameterIsNotNull(obj16, "UseMailingInd");
        Intrinsics.checkParameterIsNotNull(str5, "VIN");
        Intrinsics.checkParameterIsNotNull(str6, "VehicleDescription");
        Intrinsics.checkParameterIsNotNull(obj17, "ZipCode");
        Intrinsics.checkParameterIsNotNull(str7, "state");
        this.AdditionalNotes = obj18;
        this.Address1 = obj19;
        this.Address2 = obj20;
        this.BranchCode = i;
        this.BranchName = str8;
        this.BuyerId = i2;
        this.BuyerNotes = obj21;
        this.BuyerTitleHandlingInstructionID = i3;
        this.City = obj22;
        this.CompanyName = obj23;
        this.Country = obj24;
        this.DtPickedUp = obj25;
        this.EmployeeId = i4;
        this.FedexAccountNumber = obj26;
        this.InstructionOverrideInd = z;
        this.IsStockFinance = z2;
        this.IsTitleMailingAddressChanged = z3;
        this.OAAuctionItemId = i5;
        this.OffsiteSaleInd = z4;
        this.OwnerName = str9;
        this.PhoneNumber = obj27;
        this.PublicBuyerRestrictionStateInd = z5;
        this.RepresentativeName = obj28;
        this.RowNumber = i6;
        this.SalvageID = i7;
        this.SalvageSaleID = i8;
        this.ShowStockNoUrl = z6;
        this.State = obj29;
        this.StockNumber = str3;
        this.TitleDeliveryMethodCode = obj13;
        this.TitleStatus = str4;
        this.TrackingNumber = obj14;
        this.TransportationShippingFee = obj15;
        this.UseMailingInd = obj16;
        this.VIN = str5;
        this.VehicleDescription = str6;
        this.ZipCode = obj17;
        this.state = str7;
    }

    @NotNull
    public final Object getAdditionalNotes() {
        return this.AdditionalNotes;
    }

    @NotNull
    public final Object getAddress1() {
        return this.Address1;
    }

    @NotNull
    public final Object getAddress2() {
        return this.Address2;
    }

    public final int getBranchCode() {
        return this.BranchCode;
    }

    @NotNull
    public final String getBranchName() {
        return this.BranchName;
    }

    public final int getBuyerId() {
        return this.BuyerId;
    }

    @NotNull
    public final Object getBuyerNotes() {
        return this.BuyerNotes;
    }

    public final int getBuyerTitleHandlingInstructionID() {
        return this.BuyerTitleHandlingInstructionID;
    }

    @NotNull
    public final Object getCity() {
        return this.City;
    }

    @NotNull
    public final Object getCompanyName() {
        return this.CompanyName;
    }

    @NotNull
    public final Object getCountry() {
        return this.Country;
    }

    @NotNull
    public final Object getDtPickedUp() {
        return this.DtPickedUp;
    }

    public final int getEmployeeId() {
        return this.EmployeeId;
    }

    @NotNull
    public final Object getFedexAccountNumber() {
        return this.FedexAccountNumber;
    }

    public final boolean getInstructionOverrideInd() {
        return this.InstructionOverrideInd;
    }

    public final boolean getIsStockFinance() {
        return this.IsStockFinance;
    }

    public final boolean getIsTitleMailingAddressChanged() {
        return this.IsTitleMailingAddressChanged;
    }

    public final int getOAAuctionItemId() {
        return this.OAAuctionItemId;
    }

    public final boolean getOffsiteSaleInd() {
        return this.OffsiteSaleInd;
    }

    @NotNull
    public final String getOwnerName() {
        return this.OwnerName;
    }

    @NotNull
    public final Object getPhoneNumber() {
        return this.PhoneNumber;
    }

    public final boolean getPublicBuyerRestrictionStateInd() {
        return this.PublicBuyerRestrictionStateInd;
    }

    @NotNull
    public final Object getRepresentativeName() {
        return this.RepresentativeName;
    }

    public final int getRowNumber() {
        return this.RowNumber;
    }

    public final int getSalvageID() {
        return this.SalvageID;
    }

    public final int getSalvageSaleID() {
        return this.SalvageSaleID;
    }

    public final boolean getShowStockNoUrl() {
        return this.ShowStockNoUrl;
    }

    @NotNull
    public final Object getState() {
        return this.State;
    }

    @NotNull
    public final String getStockNumber() {
        return this.StockNumber;
    }

    @NotNull
    public final Object getTitleDeliveryMethodCode() {
        return this.TitleDeliveryMethodCode;
    }

    @NotNull
    public final String getTitleStatus() {
        return this.TitleStatus;
    }

    @NotNull
    public final Object getTrackingNumber() {
        return this.TrackingNumber;
    }

    @NotNull
    public final Object getTransportationShippingFee() {
        return this.TransportationShippingFee;
    }

    @NotNull
    public final Object getUseMailingInd() {
        return this.UseMailingInd;
    }

    @NotNull
    public final String getVIN() {
        return this.VIN;
    }

    @NotNull
    public final String getVehicleDescription() {
        return this.VehicleDescription;
    }

    @NotNull
    public final Object getZipCode() {
        return this.ZipCode;
    }

    @NotNull
    /* renamed from: getState  reason: collision with other method in class */
    public final String m4849getState() {
        return this.state;
    }
}
