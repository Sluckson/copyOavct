package com.iaai.android.bdt.model.toBePaid.saleDocument.defaultResponse;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C1119C;
import com.iaai.android.old.analytics.AnalyticsContract;
import com.lowagie.text.pdf.PdfFormField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\bo\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bå\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0015\u001a\u00020\u0013\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0013\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u001c\u001a\u00020\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u0013\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010'\u001a\u00020\u0003\u0012\u0006\u0010(\u001a\u00020\u0003\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010+\u001a\u00020\u0013¢\u0006\u0002\u0010,J\u000b\u0010X\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\\\u001a\u00020\u0007HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0013HÆ\u0003J\t\u0010_\u001a\u00020\u0013HÆ\u0003J\t\u0010`\u001a\u00020\u0013HÆ\u0003J\t\u0010a\u001a\u00020\u0007HÆ\u0003J\t\u0010b\u001a\u00020\u0013HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u0013HÆ\u0003J\u000b\u0010g\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010h\u001a\u00020\u0007HÆ\u0003J\t\u0010i\u001a\u00020\u0007HÆ\u0003J\t\u0010j\u001a\u00020\u0007HÆ\u0003J\t\u0010k\u001a\u00020\u0013HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010m\u001a\u00020\u0003HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010t\u001a\u00020\u0003HÆ\u0003J\t\u0010u\u001a\u00020\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010x\u001a\u00020\u0013HÆ\u0003J\t\u0010y\u001a\u00020\u0007HÆ\u0003J\t\u0010z\u001a\u00020\u0003HÆ\u0003J\t\u0010{\u001a\u00020\u0007HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010}\u001a\u00020\u0007HÆ\u0003J\u000b\u0010~\u001a\u0004\u0018\u00010\u0003HÆ\u0003J·\u0003\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00072\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00132\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00072\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u0010\u001f\u001a\u00020\u00132\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010'\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\u00032\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010+\u001a\u00020\u0013HÆ\u0001J\n\u0010\u0001\u001a\u00020\u0007HÖ\u0001J\u0016\u0010\u0001\u001a\u00020\u00132\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\u0007HÖ\u0001J\n\u0010\u0001\u001a\u00020\u0003HÖ\u0001J\u001e\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0007HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b/\u0010.R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010.R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010.R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b4\u00102R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010.R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b6\u00102R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010.R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010.R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b9\u0010.R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b:\u0010.R\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b;\u00102R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010.R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0014\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b?\u0010>R\u0011\u0010\u0015\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b@\u0010>R\u0011\u0010\u0016\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u00102R\u0011\u0010\u0017\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bB\u0010>R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010.R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010.R\u0011\u0010\u001a\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bE\u0010>R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010.R\u0011\u0010\u001c\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bG\u00102R\u0011\u0010\u001d\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bH\u00102R\u0011\u0010\u001e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bI\u00102R\u0011\u0010\u001f\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010>R\u0013\u0010 \u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010.R\u0011\u0010!\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010.R\u0013\u0010*\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bM\u0010.R\u0013\u0010\"\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bN\u0010.R\u0013\u0010#\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bO\u0010.R\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bP\u0010.R\u0013\u0010%\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010.R\u0013\u0010&\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bR\u0010.R\u0011\u0010'\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010.R\u0011\u0010(\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bT\u0010.R\u0013\u0010)\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bU\u0010.R\u001a\u0010+\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010>\"\u0004\bV\u0010W¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/toBePaid/saleDocument/defaultResponse/TitleInstructionItem;", "Landroid/os/Parcelable;", "AdditionalNotes", "", "Address1", "Address2", "BranchCode", "", "BranchName", "BuyerId", "BuyerNotes", "BuyerTitleHandlingInstructionID", "City", "CompanyName", "Country", "DtPickedUp", "EmployeeId", "FedexAccountNumber", "InstructionOverrideInd", "", "IsStockFinance", "IsTitleMailingAddressChanged", "OAAuctionItemId", "OffsiteSaleInd", "OwnerName", "PhoneNumber", "PublicBuyerRestrictionStateInd", "RepresentativeName", "RowNumber", "SalvageID", "SalvageSaleID", "ShowStockNoUrl", "State", "StockNumber", "TitleDeliveryMethodCode", "TitleStatus", "TrackingNumber", "TransportationShippingFee", "UseMailingInd", "VIN", "VehicleDescription", "ZipCode", "ThumbnailUrl", "isSelected", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ILjava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZZZIZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;IIIZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAdditionalNotes", "()Ljava/lang/String;", "getAddress1", "getAddress2", "getBranchCode", "()I", "getBranchName", "getBuyerId", "getBuyerNotes", "getBuyerTitleHandlingInstructionID", "getCity", "getCompanyName", "getCountry", "getDtPickedUp", "getEmployeeId", "getFedexAccountNumber", "getInstructionOverrideInd", "()Z", "getIsStockFinance", "getIsTitleMailingAddressChanged", "getOAAuctionItemId", "getOffsiteSaleInd", "getOwnerName", "getPhoneNumber", "getPublicBuyerRestrictionStateInd", "getRepresentativeName", "getRowNumber", "getSalvageID", "getSalvageSaleID", "getShowStockNoUrl", "getState", "getStockNumber", "getThumbnailUrl", "getTitleDeliveryMethodCode", "getTitleStatus", "getTrackingNumber", "getTransportationShippingFee", "getUseMailingInd", "getVIN", "getVehicleDescription", "getZipCode", "setSelected", "(Z)V", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component33", "component34", "component35", "component36", "component37", "component38", "component39", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
@Parcelize
/* compiled from: TitleInstructionItem.kt */
public final class TitleInstructionItem implements Parcelable {
    public static final Parcelable.Creator CREATOR = new Creator();
    @Nullable
    private final String AdditionalNotes;
    @Nullable
    private final String Address1;
    @Nullable
    private final String Address2;
    private final int BranchCode;
    @NotNull
    private final String BranchName;
    private final int BuyerId;
    @Nullable
    private final String BuyerNotes;
    private final int BuyerTitleHandlingInstructionID;
    @Nullable
    private final String City;
    @Nullable
    private final String CompanyName;
    @Nullable
    private final String Country;
    @Nullable
    private final String DtPickedUp;
    private final int EmployeeId;
    @Nullable
    private final String FedexAccountNumber;
    private final boolean InstructionOverrideInd;
    private final boolean IsStockFinance;
    private final boolean IsTitleMailingAddressChanged;
    private final int OAAuctionItemId;
    private final boolean OffsiteSaleInd;
    @Nullable
    private final String OwnerName;
    @Nullable
    private final String PhoneNumber;
    private final boolean PublicBuyerRestrictionStateInd;
    @Nullable
    private final String RepresentativeName;
    private final int RowNumber;
    private final int SalvageID;
    private final int SalvageSaleID;
    private final boolean ShowStockNoUrl;
    @Nullable
    private final String State;
    @NotNull
    private final String StockNumber;
    @Nullable
    private final String ThumbnailUrl;
    @Nullable
    private final String TitleDeliveryMethodCode;
    @Nullable
    private final String TitleStatus;
    @Nullable
    private final String TrackingNumber;
    @Nullable
    private final String TransportationShippingFee;
    @Nullable
    private final String UseMailingInd;
    @NotNull
    private final String VIN;
    @NotNull
    private final String VehicleDescription;
    @Nullable
    private final String ZipCode;
    private boolean isSelected;

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 13})
    public static class Creator implements Parcelable.Creator {
        @NotNull
        public final Object createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkParameterIsNotNull(parcel, "in");
            return new TitleInstructionItem(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @NotNull
        public final Object[] newArray(int i) {
            return new TitleInstructionItem[i];
        }
    }

    @NotNull
    public static /* synthetic */ TitleInstructionItem copy$default(TitleInstructionItem titleInstructionItem, String str, String str2, String str3, int i, String str4, int i2, String str5, int i3, String str6, String str7, String str8, String str9, int i4, String str10, boolean z, boolean z2, boolean z3, int i5, boolean z4, String str11, String str12, boolean z5, String str13, int i6, int i7, int i8, boolean z6, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, String str24, boolean z7, int i9, int i10, Object obj) {
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        int i11;
        int i12;
        boolean z13;
        boolean z14;
        String str25;
        String str26;
        String str27;
        String str28;
        boolean z15;
        boolean z16;
        String str29;
        String str30;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z17;
        boolean z18;
        String str31;
        String str32;
        String str33;
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
        String str46;
        String str47;
        String str48;
        String str49;
        String str50;
        boolean z19;
        TitleInstructionItem titleInstructionItem2 = titleInstructionItem;
        int i19 = i9;
        String str51 = (i19 & 1) != 0 ? titleInstructionItem2.AdditionalNotes : str;
        String str52 = (i19 & 2) != 0 ? titleInstructionItem2.Address1 : str2;
        String str53 = (i19 & 4) != 0 ? titleInstructionItem2.Address2 : str3;
        int i20 = (i19 & 8) != 0 ? titleInstructionItem2.BranchCode : i;
        String str54 = (i19 & 16) != 0 ? titleInstructionItem2.BranchName : str4;
        int i21 = (i19 & 32) != 0 ? titleInstructionItem2.BuyerId : i2;
        String str55 = (i19 & 64) != 0 ? titleInstructionItem2.BuyerNotes : str5;
        int i22 = (i19 & 128) != 0 ? titleInstructionItem2.BuyerTitleHandlingInstructionID : i3;
        String str56 = (i19 & 256) != 0 ? titleInstructionItem2.City : str6;
        String str57 = (i19 & 512) != 0 ? titleInstructionItem2.CompanyName : str7;
        String str58 = (i19 & 1024) != 0 ? titleInstructionItem2.Country : str8;
        String str59 = (i19 & 2048) != 0 ? titleInstructionItem2.DtPickedUp : str9;
        int i23 = (i19 & 4096) != 0 ? titleInstructionItem2.EmployeeId : i4;
        String str60 = (i19 & 8192) != 0 ? titleInstructionItem2.FedexAccountNumber : str10;
        boolean z20 = (i19 & 16384) != 0 ? titleInstructionItem2.InstructionOverrideInd : z;
        if ((i19 & 32768) != 0) {
            z8 = z20;
            z9 = titleInstructionItem2.IsStockFinance;
        } else {
            z8 = z20;
            z9 = z2;
        }
        if ((i19 & 65536) != 0) {
            z10 = z9;
            z11 = titleInstructionItem2.IsTitleMailingAddressChanged;
        } else {
            z10 = z9;
            z11 = z3;
        }
        if ((i19 & 131072) != 0) {
            z12 = z11;
            i11 = titleInstructionItem2.OAAuctionItemId;
        } else {
            z12 = z11;
            i11 = i5;
        }
        if ((i19 & 262144) != 0) {
            i12 = i11;
            z13 = titleInstructionItem2.OffsiteSaleInd;
        } else {
            i12 = i11;
            z13 = z4;
        }
        if ((i19 & 524288) != 0) {
            z14 = z13;
            str25 = titleInstructionItem2.OwnerName;
        } else {
            z14 = z13;
            str25 = str11;
        }
        if ((i19 & 1048576) != 0) {
            str26 = str25;
            str27 = titleInstructionItem2.PhoneNumber;
        } else {
            str26 = str25;
            str27 = str12;
        }
        if ((i19 & 2097152) != 0) {
            str28 = str27;
            z15 = titleInstructionItem2.PublicBuyerRestrictionStateInd;
        } else {
            str28 = str27;
            z15 = z5;
        }
        if ((i19 & 4194304) != 0) {
            z16 = z15;
            str29 = titleInstructionItem2.RepresentativeName;
        } else {
            z16 = z15;
            str29 = str13;
        }
        if ((i19 & 8388608) != 0) {
            str30 = str29;
            i13 = titleInstructionItem2.RowNumber;
        } else {
            str30 = str29;
            i13 = i6;
        }
        if ((i19 & 16777216) != 0) {
            i14 = i13;
            i15 = titleInstructionItem2.SalvageID;
        } else {
            i14 = i13;
            i15 = i7;
        }
        if ((i19 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            i16 = i15;
            i17 = titleInstructionItem2.SalvageSaleID;
        } else {
            i16 = i15;
            i17 = i8;
        }
        if ((i19 & 67108864) != 0) {
            i18 = i17;
            z17 = titleInstructionItem2.ShowStockNoUrl;
        } else {
            i18 = i17;
            z17 = z6;
        }
        if ((i19 & 134217728) != 0) {
            z18 = z17;
            str31 = titleInstructionItem2.State;
        } else {
            z18 = z17;
            str31 = str14;
        }
        if ((i19 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            str32 = str31;
            str33 = titleInstructionItem2.StockNumber;
        } else {
            str32 = str31;
            str33 = str15;
        }
        if ((i19 & 536870912) != 0) {
            str34 = str33;
            str35 = titleInstructionItem2.TitleDeliveryMethodCode;
        } else {
            str34 = str33;
            str35 = str16;
        }
        if ((i19 & 1073741824) != 0) {
            str36 = str35;
            str37 = titleInstructionItem2.TitleStatus;
        } else {
            str36 = str35;
            str37 = str17;
        }
        String str61 = (i19 & Integer.MIN_VALUE) != 0 ? titleInstructionItem2.TrackingNumber : str18;
        if ((i10 & 1) != 0) {
            str38 = str61;
            str39 = titleInstructionItem2.TransportationShippingFee;
        } else {
            str38 = str61;
            str39 = str19;
        }
        if ((i10 & 2) != 0) {
            str40 = str39;
            str41 = titleInstructionItem2.UseMailingInd;
        } else {
            str40 = str39;
            str41 = str20;
        }
        if ((i10 & 4) != 0) {
            str42 = str41;
            str43 = titleInstructionItem2.VIN;
        } else {
            str42 = str41;
            str43 = str21;
        }
        if ((i10 & 8) != 0) {
            str44 = str43;
            str45 = titleInstructionItem2.VehicleDescription;
        } else {
            str44 = str43;
            str45 = str22;
        }
        if ((i10 & 16) != 0) {
            str46 = str45;
            str47 = titleInstructionItem2.ZipCode;
        } else {
            str46 = str45;
            str47 = str23;
        }
        if ((i10 & 32) != 0) {
            str48 = str47;
            str49 = titleInstructionItem2.ThumbnailUrl;
        } else {
            str48 = str47;
            str49 = str24;
        }
        if ((i10 & 64) != 0) {
            str50 = str49;
            z19 = titleInstructionItem2.isSelected;
        } else {
            str50 = str49;
            z19 = z7;
        }
        return titleInstructionItem.copy(str51, str52, str53, i20, str54, i21, str55, i22, str56, str57, str58, str59, i23, str60, z8, z10, z12, i12, z14, str26, str28, z16, str30, i14, i16, i18, z18, str32, str34, str36, str37, str38, str40, str42, str44, str46, str48, str50, z19);
    }

    @Nullable
    public final String component1() {
        return this.AdditionalNotes;
    }

    @Nullable
    public final String component10() {
        return this.CompanyName;
    }

    @Nullable
    public final String component11() {
        return this.Country;
    }

    @Nullable
    public final String component12() {
        return this.DtPickedUp;
    }

    public final int component13() {
        return this.EmployeeId;
    }

    @Nullable
    public final String component14() {
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

    @Nullable
    public final String component2() {
        return this.Address1;
    }

    @Nullable
    public final String component20() {
        return this.OwnerName;
    }

    @Nullable
    public final String component21() {
        return this.PhoneNumber;
    }

    public final boolean component22() {
        return this.PublicBuyerRestrictionStateInd;
    }

    @Nullable
    public final String component23() {
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

    @Nullable
    public final String component28() {
        return this.State;
    }

    @NotNull
    public final String component29() {
        return this.StockNumber;
    }

    @Nullable
    public final String component3() {
        return this.Address2;
    }

    @Nullable
    public final String component30() {
        return this.TitleDeliveryMethodCode;
    }

    @Nullable
    public final String component31() {
        return this.TitleStatus;
    }

    @Nullable
    public final String component32() {
        return this.TrackingNumber;
    }

    @Nullable
    public final String component33() {
        return this.TransportationShippingFee;
    }

    @Nullable
    public final String component34() {
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

    @Nullable
    public final String component37() {
        return this.ZipCode;
    }

    @Nullable
    public final String component38() {
        return this.ThumbnailUrl;
    }

    public final boolean component39() {
        return this.isSelected;
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

    @Nullable
    public final String component7() {
        return this.BuyerNotes;
    }

    public final int component8() {
        return this.BuyerTitleHandlingInstructionID;
    }

    @Nullable
    public final String component9() {
        return this.City;
    }

    @NotNull
    public final TitleInstructionItem copy(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, @NotNull String str4, int i2, @Nullable String str5, int i3, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, int i4, @Nullable String str10, boolean z, boolean z2, boolean z3, int i5, boolean z4, @Nullable String str11, @Nullable String str12, boolean z5, @Nullable String str13, int i6, int i7, int i8, boolean z6, @Nullable String str14, @NotNull String str15, @Nullable String str16, @Nullable String str17, @Nullable String str18, @Nullable String str19, @Nullable String str20, @NotNull String str21, @NotNull String str22, @Nullable String str23, @Nullable String str24, boolean z7) {
        String str25 = str;
        Intrinsics.checkParameterIsNotNull(str4, "BranchName");
        Intrinsics.checkParameterIsNotNull(str15, AnalyticsContract.Analytics.COLUMN_NAME_STOCK_NO);
        Intrinsics.checkParameterIsNotNull(str21, "VIN");
        Intrinsics.checkParameterIsNotNull(str22, "VehicleDescription");
        return new TitleInstructionItem(str, str2, str3, i, str4, i2, str5, i3, str6, str7, str8, str9, i4, str10, z, z2, z3, i5, z4, str11, str12, z5, str13, i6, i7, i8, z6, str14, str15, str16, str17, str18, str19, str20, str21, str22, str23, str24, z7);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof TitleInstructionItem) {
                TitleInstructionItem titleInstructionItem = (TitleInstructionItem) obj;
                if (Intrinsics.areEqual((Object) this.AdditionalNotes, (Object) titleInstructionItem.AdditionalNotes) && Intrinsics.areEqual((Object) this.Address1, (Object) titleInstructionItem.Address1) && Intrinsics.areEqual((Object) this.Address2, (Object) titleInstructionItem.Address2)) {
                    if ((this.BranchCode == titleInstructionItem.BranchCode) && Intrinsics.areEqual((Object) this.BranchName, (Object) titleInstructionItem.BranchName)) {
                        if ((this.BuyerId == titleInstructionItem.BuyerId) && Intrinsics.areEqual((Object) this.BuyerNotes, (Object) titleInstructionItem.BuyerNotes)) {
                            if ((this.BuyerTitleHandlingInstructionID == titleInstructionItem.BuyerTitleHandlingInstructionID) && Intrinsics.areEqual((Object) this.City, (Object) titleInstructionItem.City) && Intrinsics.areEqual((Object) this.CompanyName, (Object) titleInstructionItem.CompanyName) && Intrinsics.areEqual((Object) this.Country, (Object) titleInstructionItem.Country) && Intrinsics.areEqual((Object) this.DtPickedUp, (Object) titleInstructionItem.DtPickedUp)) {
                                if ((this.EmployeeId == titleInstructionItem.EmployeeId) && Intrinsics.areEqual((Object) this.FedexAccountNumber, (Object) titleInstructionItem.FedexAccountNumber)) {
                                    if (this.InstructionOverrideInd == titleInstructionItem.InstructionOverrideInd) {
                                        if (this.IsStockFinance == titleInstructionItem.IsStockFinance) {
                                            if (this.IsTitleMailingAddressChanged == titleInstructionItem.IsTitleMailingAddressChanged) {
                                                if (this.OAAuctionItemId == titleInstructionItem.OAAuctionItemId) {
                                                    if ((this.OffsiteSaleInd == titleInstructionItem.OffsiteSaleInd) && Intrinsics.areEqual((Object) this.OwnerName, (Object) titleInstructionItem.OwnerName) && Intrinsics.areEqual((Object) this.PhoneNumber, (Object) titleInstructionItem.PhoneNumber)) {
                                                        if ((this.PublicBuyerRestrictionStateInd == titleInstructionItem.PublicBuyerRestrictionStateInd) && Intrinsics.areEqual((Object) this.RepresentativeName, (Object) titleInstructionItem.RepresentativeName)) {
                                                            if (this.RowNumber == titleInstructionItem.RowNumber) {
                                                                if (this.SalvageID == titleInstructionItem.SalvageID) {
                                                                    if (this.SalvageSaleID == titleInstructionItem.SalvageSaleID) {
                                                                        if ((this.ShowStockNoUrl == titleInstructionItem.ShowStockNoUrl) && Intrinsics.areEqual((Object) this.State, (Object) titleInstructionItem.State) && Intrinsics.areEqual((Object) this.StockNumber, (Object) titleInstructionItem.StockNumber) && Intrinsics.areEqual((Object) this.TitleDeliveryMethodCode, (Object) titleInstructionItem.TitleDeliveryMethodCode) && Intrinsics.areEqual((Object) this.TitleStatus, (Object) titleInstructionItem.TitleStatus) && Intrinsics.areEqual((Object) this.TrackingNumber, (Object) titleInstructionItem.TrackingNumber) && Intrinsics.areEqual((Object) this.TransportationShippingFee, (Object) titleInstructionItem.TransportationShippingFee) && Intrinsics.areEqual((Object) this.UseMailingInd, (Object) titleInstructionItem.UseMailingInd) && Intrinsics.areEqual((Object) this.VIN, (Object) titleInstructionItem.VIN) && Intrinsics.areEqual((Object) this.VehicleDescription, (Object) titleInstructionItem.VehicleDescription) && Intrinsics.areEqual((Object) this.ZipCode, (Object) titleInstructionItem.ZipCode) && Intrinsics.areEqual((Object) this.ThumbnailUrl, (Object) titleInstructionItem.ThumbnailUrl)) {
                                                                            if (this.isSelected == titleInstructionItem.isSelected) {
                                                                                return true;
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
        String str = this.AdditionalNotes;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.Address1;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.Address2;
        int hashCode3 = (((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31) + Integer.valueOf(this.BranchCode).hashCode()) * 31;
        String str4 = this.BranchName;
        int hashCode4 = (((hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31) + Integer.valueOf(this.BuyerId).hashCode()) * 31;
        String str5 = this.BuyerNotes;
        int hashCode5 = (((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + Integer.valueOf(this.BuyerTitleHandlingInstructionID).hashCode()) * 31;
        String str6 = this.City;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.CompanyName;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.Country;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.DtPickedUp;
        int hashCode9 = (((hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31) + Integer.valueOf(this.EmployeeId).hashCode()) * 31;
        String str10 = this.FedexAccountNumber;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
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
        String str11 = this.OwnerName;
        int hashCode12 = (i4 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.PhoneNumber;
        int hashCode13 = (hashCode12 + (str12 != null ? str12.hashCode() : 0)) * 31;
        boolean z5 = this.PublicBuyerRestrictionStateInd;
        if (z5) {
            z5 = true;
        }
        int i5 = (hashCode13 + (z5 ? 1 : 0)) * 31;
        String str13 = this.RepresentativeName;
        int hashCode14 = (((((((i5 + (str13 != null ? str13.hashCode() : 0)) * 31) + Integer.valueOf(this.RowNumber).hashCode()) * 31) + Integer.valueOf(this.SalvageID).hashCode()) * 31) + Integer.valueOf(this.SalvageSaleID).hashCode()) * 31;
        boolean z6 = this.ShowStockNoUrl;
        if (z6) {
            z6 = true;
        }
        int i6 = (hashCode14 + (z6 ? 1 : 0)) * 31;
        String str14 = this.State;
        int hashCode15 = (i6 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.StockNumber;
        int hashCode16 = (hashCode15 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.TitleDeliveryMethodCode;
        int hashCode17 = (hashCode16 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.TitleStatus;
        int hashCode18 = (hashCode17 + (str17 != null ? str17.hashCode() : 0)) * 31;
        String str18 = this.TrackingNumber;
        int hashCode19 = (hashCode18 + (str18 != null ? str18.hashCode() : 0)) * 31;
        String str19 = this.TransportationShippingFee;
        int hashCode20 = (hashCode19 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.UseMailingInd;
        int hashCode21 = (hashCode20 + (str20 != null ? str20.hashCode() : 0)) * 31;
        String str21 = this.VIN;
        int hashCode22 = (hashCode21 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.VehicleDescription;
        int hashCode23 = (hashCode22 + (str22 != null ? str22.hashCode() : 0)) * 31;
        String str23 = this.ZipCode;
        int hashCode24 = (hashCode23 + (str23 != null ? str23.hashCode() : 0)) * 31;
        String str24 = this.ThumbnailUrl;
        if (str24 != null) {
            i = str24.hashCode();
        }
        int i7 = (hashCode24 + i) * 31;
        boolean z7 = this.isSelected;
        if (z7) {
            z7 = true;
        }
        return i7 + (z7 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "TitleInstructionItem(AdditionalNotes=" + this.AdditionalNotes + ", Address1=" + this.Address1 + ", Address2=" + this.Address2 + ", BranchCode=" + this.BranchCode + ", BranchName=" + this.BranchName + ", BuyerId=" + this.BuyerId + ", BuyerNotes=" + this.BuyerNotes + ", BuyerTitleHandlingInstructionID=" + this.BuyerTitleHandlingInstructionID + ", City=" + this.City + ", CompanyName=" + this.CompanyName + ", Country=" + this.Country + ", DtPickedUp=" + this.DtPickedUp + ", EmployeeId=" + this.EmployeeId + ", FedexAccountNumber=" + this.FedexAccountNumber + ", InstructionOverrideInd=" + this.InstructionOverrideInd + ", IsStockFinance=" + this.IsStockFinance + ", IsTitleMailingAddressChanged=" + this.IsTitleMailingAddressChanged + ", OAAuctionItemId=" + this.OAAuctionItemId + ", OffsiteSaleInd=" + this.OffsiteSaleInd + ", OwnerName=" + this.OwnerName + ", PhoneNumber=" + this.PhoneNumber + ", PublicBuyerRestrictionStateInd=" + this.PublicBuyerRestrictionStateInd + ", RepresentativeName=" + this.RepresentativeName + ", RowNumber=" + this.RowNumber + ", SalvageID=" + this.SalvageID + ", SalvageSaleID=" + this.SalvageSaleID + ", ShowStockNoUrl=" + this.ShowStockNoUrl + ", State=" + this.State + ", StockNumber=" + this.StockNumber + ", TitleDeliveryMethodCode=" + this.TitleDeliveryMethodCode + ", TitleStatus=" + this.TitleStatus + ", TrackingNumber=" + this.TrackingNumber + ", TransportationShippingFee=" + this.TransportationShippingFee + ", UseMailingInd=" + this.UseMailingInd + ", VIN=" + this.VIN + ", VehicleDescription=" + this.VehicleDescription + ", ZipCode=" + this.ZipCode + ", ThumbnailUrl=" + this.ThumbnailUrl + ", isSelected=" + this.isSelected + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        parcel.writeString(this.AdditionalNotes);
        parcel.writeString(this.Address1);
        parcel.writeString(this.Address2);
        parcel.writeInt(this.BranchCode);
        parcel.writeString(this.BranchName);
        parcel.writeInt(this.BuyerId);
        parcel.writeString(this.BuyerNotes);
        parcel.writeInt(this.BuyerTitleHandlingInstructionID);
        parcel.writeString(this.City);
        parcel.writeString(this.CompanyName);
        parcel.writeString(this.Country);
        parcel.writeString(this.DtPickedUp);
        parcel.writeInt(this.EmployeeId);
        parcel.writeString(this.FedexAccountNumber);
        parcel.writeInt(this.InstructionOverrideInd ? 1 : 0);
        parcel.writeInt(this.IsStockFinance ? 1 : 0);
        parcel.writeInt(this.IsTitleMailingAddressChanged ? 1 : 0);
        parcel.writeInt(this.OAAuctionItemId);
        parcel.writeInt(this.OffsiteSaleInd ? 1 : 0);
        parcel.writeString(this.OwnerName);
        parcel.writeString(this.PhoneNumber);
        parcel.writeInt(this.PublicBuyerRestrictionStateInd ? 1 : 0);
        parcel.writeString(this.RepresentativeName);
        parcel.writeInt(this.RowNumber);
        parcel.writeInt(this.SalvageID);
        parcel.writeInt(this.SalvageSaleID);
        parcel.writeInt(this.ShowStockNoUrl ? 1 : 0);
        parcel.writeString(this.State);
        parcel.writeString(this.StockNumber);
        parcel.writeString(this.TitleDeliveryMethodCode);
        parcel.writeString(this.TitleStatus);
        parcel.writeString(this.TrackingNumber);
        parcel.writeString(this.TransportationShippingFee);
        parcel.writeString(this.UseMailingInd);
        parcel.writeString(this.VIN);
        parcel.writeString(this.VehicleDescription);
        parcel.writeString(this.ZipCode);
        parcel.writeString(this.ThumbnailUrl);
        parcel.writeInt(this.isSelected ? 1 : 0);
    }

    public TitleInstructionItem(@Nullable String str, @Nullable String str2, @Nullable String str3, int i, @NotNull String str4, int i2, @Nullable String str5, int i3, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, int i4, @Nullable String str10, boolean z, boolean z2, boolean z3, int i5, boolean z4, @Nullable String str11, @Nullable String str12, boolean z5, @Nullable String str13, int i6, int i7, int i8, boolean z6, @Nullable String str14, @NotNull String str15, @Nullable String str16, @Nullable String str17, @Nullable String str18, @Nullable String str19, @Nullable String str20, @NotNull String str21, @NotNull String str22, @Nullable String str23, @Nullable String str24, boolean z7) {
        String str25 = str15;
        String str26 = str21;
        String str27 = str22;
        Intrinsics.checkParameterIsNotNull(str4, "BranchName");
        Intrinsics.checkParameterIsNotNull(str25, AnalyticsContract.Analytics.COLUMN_NAME_STOCK_NO);
        Intrinsics.checkParameterIsNotNull(str26, "VIN");
        Intrinsics.checkParameterIsNotNull(str27, "VehicleDescription");
        this.AdditionalNotes = str;
        this.Address1 = str2;
        this.Address2 = str3;
        this.BranchCode = i;
        this.BranchName = str4;
        this.BuyerId = i2;
        this.BuyerNotes = str5;
        this.BuyerTitleHandlingInstructionID = i3;
        this.City = str6;
        this.CompanyName = str7;
        this.Country = str8;
        this.DtPickedUp = str9;
        this.EmployeeId = i4;
        this.FedexAccountNumber = str10;
        this.InstructionOverrideInd = z;
        this.IsStockFinance = z2;
        this.IsTitleMailingAddressChanged = z3;
        this.OAAuctionItemId = i5;
        this.OffsiteSaleInd = z4;
        this.OwnerName = str11;
        this.PhoneNumber = str12;
        this.PublicBuyerRestrictionStateInd = z5;
        this.RepresentativeName = str13;
        this.RowNumber = i6;
        this.SalvageID = i7;
        this.SalvageSaleID = i8;
        this.ShowStockNoUrl = z6;
        this.State = str14;
        this.StockNumber = str25;
        this.TitleDeliveryMethodCode = str16;
        this.TitleStatus = str17;
        this.TrackingNumber = str18;
        this.TransportationShippingFee = str19;
        this.UseMailingInd = str20;
        this.VIN = str26;
        this.VehicleDescription = str27;
        this.ZipCode = str23;
        this.ThumbnailUrl = str24;
        this.isSelected = z7;
    }

    @Nullable
    public final String getAdditionalNotes() {
        return this.AdditionalNotes;
    }

    @Nullable
    public final String getAddress1() {
        return this.Address1;
    }

    @Nullable
    public final String getAddress2() {
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

    @Nullable
    public final String getBuyerNotes() {
        return this.BuyerNotes;
    }

    public final int getBuyerTitleHandlingInstructionID() {
        return this.BuyerTitleHandlingInstructionID;
    }

    @Nullable
    public final String getCity() {
        return this.City;
    }

    @Nullable
    public final String getCompanyName() {
        return this.CompanyName;
    }

    @Nullable
    public final String getCountry() {
        return this.Country;
    }

    @Nullable
    public final String getDtPickedUp() {
        return this.DtPickedUp;
    }

    public final int getEmployeeId() {
        return this.EmployeeId;
    }

    @Nullable
    public final String getFedexAccountNumber() {
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

    @Nullable
    public final String getOwnerName() {
        return this.OwnerName;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.PhoneNumber;
    }

    public final boolean getPublicBuyerRestrictionStateInd() {
        return this.PublicBuyerRestrictionStateInd;
    }

    @Nullable
    public final String getRepresentativeName() {
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

    @Nullable
    public final String getState() {
        return this.State;
    }

    @NotNull
    public final String getStockNumber() {
        return this.StockNumber;
    }

    @Nullable
    public final String getTitleDeliveryMethodCode() {
        return this.TitleDeliveryMethodCode;
    }

    @Nullable
    public final String getTitleStatus() {
        return this.TitleStatus;
    }

    @Nullable
    public final String getTrackingNumber() {
        return this.TrackingNumber;
    }

    @Nullable
    public final String getTransportationShippingFee() {
        return this.TransportationShippingFee;
    }

    @Nullable
    public final String getUseMailingInd() {
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

    @Nullable
    public final String getZipCode() {
        return this.ZipCode;
    }

    @Nullable
    public final String getThumbnailUrl() {
        return this.ThumbnailUrl;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z) {
        this.isSelected = z;
    }
}
