package com.iaai.android.bdt.model.productDetail;

import com.google.android.exoplayer2.C1119C;
import com.lowagie.text.pdf.PdfFormField;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0003\b\u0001\b\b\u0018\u00002\u00020\u0001BÅ\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010%J\u000b\u0010p\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010s\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010v\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010w\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010y\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010z\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010{\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010}\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010~\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010/J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010/J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u00104J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0001\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010/J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\f\u0010\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0003\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0003\u0010\u0001J\u0015\u0010\u0001\u001a\u00020\t2\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0001\u001a\u00020\u0007HÖ\u0001J\n\u0010\u0001\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010'\"\u0004\b+\u0010)R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010'\"\u0004\b-\u0010)R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010'\"\u0004\b9\u0010)R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\b:\u0010/\"\u0004\b;\u00101R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010'\"\u0004\b=\u0010)R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010'\"\u0004\b?\u0010)R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010'\"\u0004\bA\u0010)R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010'\"\u0004\bC\u0010)R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010'\"\u0004\bE\u0010)R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010'\"\u0004\bG\u0010)R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010'\"\u0004\bI\u0010)R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010'\"\u0004\bK\u0010)R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010'\"\u0004\bM\u0010)R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010'\"\u0004\bO\u0010)R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010'\"\u0004\bQ\u0010)R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010'\"\u0004\bS\u0010)R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010'\"\u0004\bU\u0010)R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0010\n\u0002\u00107\u001a\u0004\bV\u00104\"\u0004\bW\u00106R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010'\"\u0004\bY\u0010)R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010[\"\u0004\b\\\u0010]R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010'\"\u0004\b_\u0010)R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010'\"\u0004\ba\u0010)R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010[\"\u0004\bc\u0010]R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010'\"\u0004\be\u0010)R\u001c\u0010 \u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010'\"\u0004\bg\u0010)R\u001c\u0010!\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010'\"\u0004\bi\u0010)R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010'\"\u0004\bk\u0010)R\u001c\u0010#\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010'\"\u0004\bm\u0010)R\u001e\u0010$\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0010\n\u0002\u00102\u001a\u0004\bn\u0010/\"\u0004\bo\u00101¨\u0006\u0001"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/VehicledetailsNonUS;", "", "AlertMessage", "", "AuctionLane", "BranchName", "BranchNumber", "", "DisplaySeller", "", "ImageUrl", "ItemId", "ItemNumber", "Key", "LaneAndItemNumber", "LiveDateTime", "LossType", "Make", "MaskedSeller", "MaskedVIN", "Model", "OdoBrand", "Odometer", "OdometerUOM", "PrimaryDamage", "RunAndDrive", "SaleDocument", "SalvageId", "SecondaryDamage", "SellerName", "Series", "StartDesc", "Stockno", "Tenant", "Title", "VIN", "Year", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getAlertMessage", "()Ljava/lang/String;", "setAlertMessage", "(Ljava/lang/String;)V", "getAuctionLane", "setAuctionLane", "getBranchName", "setBranchName", "getBranchNumber", "()Ljava/lang/Integer;", "setBranchNumber", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getDisplaySeller", "()Ljava/lang/Boolean;", "setDisplaySeller", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getImageUrl", "setImageUrl", "getItemId", "setItemId", "getItemNumber", "setItemNumber", "getKey", "setKey", "getLaneAndItemNumber", "setLaneAndItemNumber", "getLiveDateTime", "setLiveDateTime", "getLossType", "setLossType", "getMake", "setMake", "getMaskedSeller", "setMaskedSeller", "getMaskedVIN", "setMaskedVIN", "getModel", "setModel", "getOdoBrand", "setOdoBrand", "getOdometer", "setOdometer", "getOdometerUOM", "setOdometerUOM", "getPrimaryDamage", "setPrimaryDamage", "getRunAndDrive", "setRunAndDrive", "getSaleDocument", "setSaleDocument", "getSalvageId", "()Ljava/lang/Object;", "setSalvageId", "(Ljava/lang/Object;)V", "getSecondaryDamage", "setSecondaryDamage", "getSellerName", "setSellerName", "getSeries", "setSeries", "getStartDesc", "setStartDesc", "getStockno", "setStockno", "getTenant", "setTenant", "getTitle", "setTitle", "getVIN", "setVIN", "getYear", "setYear", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component32", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/iaai/android/bdt/model/productDetail/VehicledetailsNonUS;", "equals", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: VehicledetailsNonUS.kt */
public final class VehicledetailsNonUS {
    @Nullable
    private String AlertMessage;
    @Nullable
    private String AuctionLane;
    @Nullable
    private String BranchName;
    @Nullable
    private Integer BranchNumber;
    @Nullable
    private Boolean DisplaySeller;
    @Nullable
    private String ImageUrl;
    @Nullable
    private Integer ItemId;
    @Nullable
    private String ItemNumber;
    @Nullable
    private String Key;
    @Nullable
    private String LaneAndItemNumber;
    @Nullable
    private String LiveDateTime;
    @Nullable
    private String LossType;
    @Nullable
    private String Make;
    @Nullable
    private String MaskedSeller;
    @Nullable
    private String MaskedVIN;
    @Nullable
    private String Model;
    @Nullable
    private String OdoBrand;
    @Nullable
    private String Odometer;
    @Nullable
    private String OdometerUOM;
    @Nullable
    private String PrimaryDamage;
    @Nullable
    private Boolean RunAndDrive;
    @Nullable
    private String SaleDocument;
    @Nullable
    private Object SalvageId;
    @Nullable
    private String SecondaryDamage;
    @Nullable
    private String SellerName;
    @Nullable
    private Object Series;
    @Nullable
    private String StartDesc;
    @Nullable
    private String Stockno;
    @Nullable
    private String Tenant;
    @Nullable
    private String Title;
    @Nullable
    private String VIN;
    @Nullable
    private Integer Year;

    @NotNull
    public static /* synthetic */ VehicledetailsNonUS copy$default(VehicledetailsNonUS vehicledetailsNonUS, String str, String str2, String str3, Integer num, Boolean bool, String str4, Integer num2, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, Boolean bool2, String str18, Object obj, String str19, String str20, Object obj2, String str21, String str22, String str23, String str24, String str25, Integer num3, int i, Object obj3) {
        String str26;
        String str27;
        String str28;
        String str29;
        String str30;
        String str31;
        String str32;
        String str33;
        String str34;
        String str35;
        String str36;
        Boolean bool3;
        Boolean bool4;
        String str37;
        String str38;
        Object obj4;
        Object obj5;
        String str39;
        String str40;
        String str41;
        String str42;
        Object obj6;
        Object obj7;
        String str43;
        String str44;
        String str45;
        String str46;
        String str47;
        String str48;
        String str49;
        String str50;
        String str51;
        VehicledetailsNonUS vehicledetailsNonUS2 = vehicledetailsNonUS;
        int i2 = i;
        String str52 = (i2 & 1) != 0 ? vehicledetailsNonUS2.AlertMessage : str;
        String str53 = (i2 & 2) != 0 ? vehicledetailsNonUS2.AuctionLane : str2;
        String str54 = (i2 & 4) != 0 ? vehicledetailsNonUS2.BranchName : str3;
        Integer num4 = (i2 & 8) != 0 ? vehicledetailsNonUS2.BranchNumber : num;
        Boolean bool5 = (i2 & 16) != 0 ? vehicledetailsNonUS2.DisplaySeller : bool;
        String str55 = (i2 & 32) != 0 ? vehicledetailsNonUS2.ImageUrl : str4;
        Integer num5 = (i2 & 64) != 0 ? vehicledetailsNonUS2.ItemId : num2;
        String str56 = (i2 & 128) != 0 ? vehicledetailsNonUS2.ItemNumber : str5;
        String str57 = (i2 & 256) != 0 ? vehicledetailsNonUS2.Key : str6;
        String str58 = (i2 & 512) != 0 ? vehicledetailsNonUS2.LaneAndItemNumber : str7;
        String str59 = (i2 & 1024) != 0 ? vehicledetailsNonUS2.LiveDateTime : str8;
        String str60 = (i2 & 2048) != 0 ? vehicledetailsNonUS2.LossType : str9;
        String str61 = (i2 & 4096) != 0 ? vehicledetailsNonUS2.Make : str10;
        String str62 = (i2 & 8192) != 0 ? vehicledetailsNonUS2.MaskedSeller : str11;
        String str63 = (i2 & 16384) != 0 ? vehicledetailsNonUS2.MaskedVIN : str12;
        if ((i2 & 32768) != 0) {
            str26 = str63;
            str27 = vehicledetailsNonUS2.Model;
        } else {
            str26 = str63;
            str27 = str13;
        }
        if ((i2 & 65536) != 0) {
            str28 = str27;
            str29 = vehicledetailsNonUS2.OdoBrand;
        } else {
            str28 = str27;
            str29 = str14;
        }
        if ((i2 & 131072) != 0) {
            str30 = str29;
            str31 = vehicledetailsNonUS2.Odometer;
        } else {
            str30 = str29;
            str31 = str15;
        }
        if ((i2 & 262144) != 0) {
            str32 = str31;
            str33 = vehicledetailsNonUS2.OdometerUOM;
        } else {
            str32 = str31;
            str33 = str16;
        }
        if ((i2 & 524288) != 0) {
            str34 = str33;
            str35 = vehicledetailsNonUS2.PrimaryDamage;
        } else {
            str34 = str33;
            str35 = str17;
        }
        if ((i2 & 1048576) != 0) {
            str36 = str35;
            bool3 = vehicledetailsNonUS2.RunAndDrive;
        } else {
            str36 = str35;
            bool3 = bool2;
        }
        if ((i2 & 2097152) != 0) {
            bool4 = bool3;
            str37 = vehicledetailsNonUS2.SaleDocument;
        } else {
            bool4 = bool3;
            str37 = str18;
        }
        if ((i2 & 4194304) != 0) {
            str38 = str37;
            obj4 = vehicledetailsNonUS2.SalvageId;
        } else {
            str38 = str37;
            obj4 = obj;
        }
        if ((i2 & 8388608) != 0) {
            obj5 = obj4;
            str39 = vehicledetailsNonUS2.SecondaryDamage;
        } else {
            obj5 = obj4;
            str39 = str19;
        }
        if ((i2 & 16777216) != 0) {
            str40 = str39;
            str41 = vehicledetailsNonUS2.SellerName;
        } else {
            str40 = str39;
            str41 = str20;
        }
        if ((i2 & PdfFormField.FF_RADIOSINUNISON) != 0) {
            str42 = str41;
            obj6 = vehicledetailsNonUS2.Series;
        } else {
            str42 = str41;
            obj6 = obj2;
        }
        if ((i2 & 67108864) != 0) {
            obj7 = obj6;
            str43 = vehicledetailsNonUS2.StartDesc;
        } else {
            obj7 = obj6;
            str43 = str21;
        }
        if ((i2 & 134217728) != 0) {
            str44 = str43;
            str45 = vehicledetailsNonUS2.Stockno;
        } else {
            str44 = str43;
            str45 = str22;
        }
        if ((i2 & C1119C.ENCODING_PCM_MU_LAW) != 0) {
            str46 = str45;
            str47 = vehicledetailsNonUS2.Tenant;
        } else {
            str46 = str45;
            str47 = str23;
        }
        if ((i2 & 536870912) != 0) {
            str48 = str47;
            str49 = vehicledetailsNonUS2.Title;
        } else {
            str48 = str47;
            str49 = str24;
        }
        if ((i2 & 1073741824) != 0) {
            str50 = str49;
            str51 = vehicledetailsNonUS2.VIN;
        } else {
            str50 = str49;
            str51 = str25;
        }
        return vehicledetailsNonUS.copy(str52, str53, str54, num4, bool5, str55, num5, str56, str57, str58, str59, str60, str61, str62, str26, str28, str30, str32, str34, str36, bool4, str38, obj5, str40, str42, obj7, str44, str46, str48, str50, str51, (i2 & Integer.MIN_VALUE) != 0 ? vehicledetailsNonUS2.Year : num3);
    }

    @Nullable
    public final String component1() {
        return this.AlertMessage;
    }

    @Nullable
    public final String component10() {
        return this.LaneAndItemNumber;
    }

    @Nullable
    public final String component11() {
        return this.LiveDateTime;
    }

    @Nullable
    public final String component12() {
        return this.LossType;
    }

    @Nullable
    public final String component13() {
        return this.Make;
    }

    @Nullable
    public final String component14() {
        return this.MaskedSeller;
    }

    @Nullable
    public final String component15() {
        return this.MaskedVIN;
    }

    @Nullable
    public final String component16() {
        return this.Model;
    }

    @Nullable
    public final String component17() {
        return this.OdoBrand;
    }

    @Nullable
    public final String component18() {
        return this.Odometer;
    }

    @Nullable
    public final String component19() {
        return this.OdometerUOM;
    }

    @Nullable
    public final String component2() {
        return this.AuctionLane;
    }

    @Nullable
    public final String component20() {
        return this.PrimaryDamage;
    }

    @Nullable
    public final Boolean component21() {
        return this.RunAndDrive;
    }

    @Nullable
    public final String component22() {
        return this.SaleDocument;
    }

    @Nullable
    public final Object component23() {
        return this.SalvageId;
    }

    @Nullable
    public final String component24() {
        return this.SecondaryDamage;
    }

    @Nullable
    public final String component25() {
        return this.SellerName;
    }

    @Nullable
    public final Object component26() {
        return this.Series;
    }

    @Nullable
    public final String component27() {
        return this.StartDesc;
    }

    @Nullable
    public final String component28() {
        return this.Stockno;
    }

    @Nullable
    public final String component29() {
        return this.Tenant;
    }

    @Nullable
    public final String component3() {
        return this.BranchName;
    }

    @Nullable
    public final String component30() {
        return this.Title;
    }

    @Nullable
    public final String component31() {
        return this.VIN;
    }

    @Nullable
    public final Integer component32() {
        return this.Year;
    }

    @Nullable
    public final Integer component4() {
        return this.BranchNumber;
    }

    @Nullable
    public final Boolean component5() {
        return this.DisplaySeller;
    }

    @Nullable
    public final String component6() {
        return this.ImageUrl;
    }

    @Nullable
    public final Integer component7() {
        return this.ItemId;
    }

    @Nullable
    public final String component8() {
        return this.ItemNumber;
    }

    @Nullable
    public final String component9() {
        return this.Key;
    }

    @NotNull
    public final VehicledetailsNonUS copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable Boolean bool, @Nullable String str4, @Nullable Integer num2, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable String str17, @Nullable Boolean bool2, @Nullable String str18, @Nullable Object obj, @Nullable String str19, @Nullable String str20, @Nullable Object obj2, @Nullable String str21, @Nullable String str22, @Nullable String str23, @Nullable String str24, @Nullable String str25, @Nullable Integer num3) {
        return new VehicledetailsNonUS(str, str2, str3, num, bool, str4, num2, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, bool2, str18, obj, str19, str20, obj2, str21, str22, str23, str24, str25, num3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VehicledetailsNonUS)) {
            return false;
        }
        VehicledetailsNonUS vehicledetailsNonUS = (VehicledetailsNonUS) obj;
        return Intrinsics.areEqual((Object) this.AlertMessage, (Object) vehicledetailsNonUS.AlertMessage) && Intrinsics.areEqual((Object) this.AuctionLane, (Object) vehicledetailsNonUS.AuctionLane) && Intrinsics.areEqual((Object) this.BranchName, (Object) vehicledetailsNonUS.BranchName) && Intrinsics.areEqual((Object) this.BranchNumber, (Object) vehicledetailsNonUS.BranchNumber) && Intrinsics.areEqual((Object) this.DisplaySeller, (Object) vehicledetailsNonUS.DisplaySeller) && Intrinsics.areEqual((Object) this.ImageUrl, (Object) vehicledetailsNonUS.ImageUrl) && Intrinsics.areEqual((Object) this.ItemId, (Object) vehicledetailsNonUS.ItemId) && Intrinsics.areEqual((Object) this.ItemNumber, (Object) vehicledetailsNonUS.ItemNumber) && Intrinsics.areEqual((Object) this.Key, (Object) vehicledetailsNonUS.Key) && Intrinsics.areEqual((Object) this.LaneAndItemNumber, (Object) vehicledetailsNonUS.LaneAndItemNumber) && Intrinsics.areEqual((Object) this.LiveDateTime, (Object) vehicledetailsNonUS.LiveDateTime) && Intrinsics.areEqual((Object) this.LossType, (Object) vehicledetailsNonUS.LossType) && Intrinsics.areEqual((Object) this.Make, (Object) vehicledetailsNonUS.Make) && Intrinsics.areEqual((Object) this.MaskedSeller, (Object) vehicledetailsNonUS.MaskedSeller) && Intrinsics.areEqual((Object) this.MaskedVIN, (Object) vehicledetailsNonUS.MaskedVIN) && Intrinsics.areEqual((Object) this.Model, (Object) vehicledetailsNonUS.Model) && Intrinsics.areEqual((Object) this.OdoBrand, (Object) vehicledetailsNonUS.OdoBrand) && Intrinsics.areEqual((Object) this.Odometer, (Object) vehicledetailsNonUS.Odometer) && Intrinsics.areEqual((Object) this.OdometerUOM, (Object) vehicledetailsNonUS.OdometerUOM) && Intrinsics.areEqual((Object) this.PrimaryDamage, (Object) vehicledetailsNonUS.PrimaryDamage) && Intrinsics.areEqual((Object) this.RunAndDrive, (Object) vehicledetailsNonUS.RunAndDrive) && Intrinsics.areEqual((Object) this.SaleDocument, (Object) vehicledetailsNonUS.SaleDocument) && Intrinsics.areEqual(this.SalvageId, vehicledetailsNonUS.SalvageId) && Intrinsics.areEqual((Object) this.SecondaryDamage, (Object) vehicledetailsNonUS.SecondaryDamage) && Intrinsics.areEqual((Object) this.SellerName, (Object) vehicledetailsNonUS.SellerName) && Intrinsics.areEqual(this.Series, vehicledetailsNonUS.Series) && Intrinsics.areEqual((Object) this.StartDesc, (Object) vehicledetailsNonUS.StartDesc) && Intrinsics.areEqual((Object) this.Stockno, (Object) vehicledetailsNonUS.Stockno) && Intrinsics.areEqual((Object) this.Tenant, (Object) vehicledetailsNonUS.Tenant) && Intrinsics.areEqual((Object) this.Title, (Object) vehicledetailsNonUS.Title) && Intrinsics.areEqual((Object) this.VIN, (Object) vehicledetailsNonUS.VIN) && Intrinsics.areEqual((Object) this.Year, (Object) vehicledetailsNonUS.Year);
    }

    public int hashCode() {
        String str = this.AlertMessage;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.AuctionLane;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.BranchName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Integer num = this.BranchNumber;
        int hashCode4 = (hashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        Boolean bool = this.DisplaySeller;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        String str4 = this.ImageUrl;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        Integer num2 = this.ItemId;
        int hashCode7 = (hashCode6 + (num2 != null ? num2.hashCode() : 0)) * 31;
        String str5 = this.ItemNumber;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.Key;
        int hashCode9 = (hashCode8 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.LaneAndItemNumber;
        int hashCode10 = (hashCode9 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.LiveDateTime;
        int hashCode11 = (hashCode10 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.LossType;
        int hashCode12 = (hashCode11 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.Make;
        int hashCode13 = (hashCode12 + (str10 != null ? str10.hashCode() : 0)) * 31;
        String str11 = this.MaskedSeller;
        int hashCode14 = (hashCode13 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.MaskedVIN;
        int hashCode15 = (hashCode14 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.Model;
        int hashCode16 = (hashCode15 + (str13 != null ? str13.hashCode() : 0)) * 31;
        String str14 = this.OdoBrand;
        int hashCode17 = (hashCode16 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.Odometer;
        int hashCode18 = (hashCode17 + (str15 != null ? str15.hashCode() : 0)) * 31;
        String str16 = this.OdometerUOM;
        int hashCode19 = (hashCode18 + (str16 != null ? str16.hashCode() : 0)) * 31;
        String str17 = this.PrimaryDamage;
        int hashCode20 = (hashCode19 + (str17 != null ? str17.hashCode() : 0)) * 31;
        Boolean bool2 = this.RunAndDrive;
        int hashCode21 = (hashCode20 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        String str18 = this.SaleDocument;
        int hashCode22 = (hashCode21 + (str18 != null ? str18.hashCode() : 0)) * 31;
        Object obj = this.SalvageId;
        int hashCode23 = (hashCode22 + (obj != null ? obj.hashCode() : 0)) * 31;
        String str19 = this.SecondaryDamage;
        int hashCode24 = (hashCode23 + (str19 != null ? str19.hashCode() : 0)) * 31;
        String str20 = this.SellerName;
        int hashCode25 = (hashCode24 + (str20 != null ? str20.hashCode() : 0)) * 31;
        Object obj2 = this.Series;
        int hashCode26 = (hashCode25 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        String str21 = this.StartDesc;
        int hashCode27 = (hashCode26 + (str21 != null ? str21.hashCode() : 0)) * 31;
        String str22 = this.Stockno;
        int hashCode28 = (hashCode27 + (str22 != null ? str22.hashCode() : 0)) * 31;
        String str23 = this.Tenant;
        int hashCode29 = (hashCode28 + (str23 != null ? str23.hashCode() : 0)) * 31;
        String str24 = this.Title;
        int hashCode30 = (hashCode29 + (str24 != null ? str24.hashCode() : 0)) * 31;
        String str25 = this.VIN;
        int hashCode31 = (hashCode30 + (str25 != null ? str25.hashCode() : 0)) * 31;
        Integer num3 = this.Year;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return hashCode31 + i;
    }

    @NotNull
    public String toString() {
        return "VehicledetailsNonUS(AlertMessage=" + this.AlertMessage + ", AuctionLane=" + this.AuctionLane + ", BranchName=" + this.BranchName + ", BranchNumber=" + this.BranchNumber + ", DisplaySeller=" + this.DisplaySeller + ", ImageUrl=" + this.ImageUrl + ", ItemId=" + this.ItemId + ", ItemNumber=" + this.ItemNumber + ", Key=" + this.Key + ", LaneAndItemNumber=" + this.LaneAndItemNumber + ", LiveDateTime=" + this.LiveDateTime + ", LossType=" + this.LossType + ", Make=" + this.Make + ", MaskedSeller=" + this.MaskedSeller + ", MaskedVIN=" + this.MaskedVIN + ", Model=" + this.Model + ", OdoBrand=" + this.OdoBrand + ", Odometer=" + this.Odometer + ", OdometerUOM=" + this.OdometerUOM + ", PrimaryDamage=" + this.PrimaryDamage + ", RunAndDrive=" + this.RunAndDrive + ", SaleDocument=" + this.SaleDocument + ", SalvageId=" + this.SalvageId + ", SecondaryDamage=" + this.SecondaryDamage + ", SellerName=" + this.SellerName + ", Series=" + this.Series + ", StartDesc=" + this.StartDesc + ", Stockno=" + this.Stockno + ", Tenant=" + this.Tenant + ", Title=" + this.Title + ", VIN=" + this.VIN + ", Year=" + this.Year + ")";
    }

    public VehicledetailsNonUS(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable Integer num, @Nullable Boolean bool, @Nullable String str4, @Nullable Integer num2, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable String str16, @Nullable String str17, @Nullable Boolean bool2, @Nullable String str18, @Nullable Object obj, @Nullable String str19, @Nullable String str20, @Nullable Object obj2, @Nullable String str21, @Nullable String str22, @Nullable String str23, @Nullable String str24, @Nullable String str25, @Nullable Integer num3) {
        this.AlertMessage = str;
        this.AuctionLane = str2;
        this.BranchName = str3;
        this.BranchNumber = num;
        this.DisplaySeller = bool;
        this.ImageUrl = str4;
        this.ItemId = num2;
        this.ItemNumber = str5;
        this.Key = str6;
        this.LaneAndItemNumber = str7;
        this.LiveDateTime = str8;
        this.LossType = str9;
        this.Make = str10;
        this.MaskedSeller = str11;
        this.MaskedVIN = str12;
        this.Model = str13;
        this.OdoBrand = str14;
        this.Odometer = str15;
        this.OdometerUOM = str16;
        this.PrimaryDamage = str17;
        this.RunAndDrive = bool2;
        this.SaleDocument = str18;
        this.SalvageId = obj;
        this.SecondaryDamage = str19;
        this.SellerName = str20;
        this.Series = obj2;
        this.StartDesc = str21;
        this.Stockno = str22;
        this.Tenant = str23;
        this.Title = str24;
        this.VIN = str25;
        this.Year = num3;
    }

    @Nullable
    public final String getAlertMessage() {
        return this.AlertMessage;
    }

    public final void setAlertMessage(@Nullable String str) {
        this.AlertMessage = str;
    }

    @Nullable
    public final String getAuctionLane() {
        return this.AuctionLane;
    }

    public final void setAuctionLane(@Nullable String str) {
        this.AuctionLane = str;
    }

    @Nullable
    public final String getBranchName() {
        return this.BranchName;
    }

    public final void setBranchName(@Nullable String str) {
        this.BranchName = str;
    }

    @Nullable
    public final Integer getBranchNumber() {
        return this.BranchNumber;
    }

    public final void setBranchNumber(@Nullable Integer num) {
        this.BranchNumber = num;
    }

    @Nullable
    public final Boolean getDisplaySeller() {
        return this.DisplaySeller;
    }

    public final void setDisplaySeller(@Nullable Boolean bool) {
        this.DisplaySeller = bool;
    }

    @Nullable
    public final String getImageUrl() {
        return this.ImageUrl;
    }

    public final void setImageUrl(@Nullable String str) {
        this.ImageUrl = str;
    }

    @Nullable
    public final Integer getItemId() {
        return this.ItemId;
    }

    public final void setItemId(@Nullable Integer num) {
        this.ItemId = num;
    }

    @Nullable
    public final String getItemNumber() {
        return this.ItemNumber;
    }

    public final void setItemNumber(@Nullable String str) {
        this.ItemNumber = str;
    }

    @Nullable
    public final String getKey() {
        return this.Key;
    }

    public final void setKey(@Nullable String str) {
        this.Key = str;
    }

    @Nullable
    public final String getLaneAndItemNumber() {
        return this.LaneAndItemNumber;
    }

    public final void setLaneAndItemNumber(@Nullable String str) {
        this.LaneAndItemNumber = str;
    }

    @Nullable
    public final String getLiveDateTime() {
        return this.LiveDateTime;
    }

    public final void setLiveDateTime(@Nullable String str) {
        this.LiveDateTime = str;
    }

    @Nullable
    public final String getLossType() {
        return this.LossType;
    }

    public final void setLossType(@Nullable String str) {
        this.LossType = str;
    }

    @Nullable
    public final String getMake() {
        return this.Make;
    }

    public final void setMake(@Nullable String str) {
        this.Make = str;
    }

    @Nullable
    public final String getMaskedSeller() {
        return this.MaskedSeller;
    }

    public final void setMaskedSeller(@Nullable String str) {
        this.MaskedSeller = str;
    }

    @Nullable
    public final String getMaskedVIN() {
        return this.MaskedVIN;
    }

    public final void setMaskedVIN(@Nullable String str) {
        this.MaskedVIN = str;
    }

    @Nullable
    public final String getModel() {
        return this.Model;
    }

    public final void setModel(@Nullable String str) {
        this.Model = str;
    }

    @Nullable
    public final String getOdoBrand() {
        return this.OdoBrand;
    }

    public final void setOdoBrand(@Nullable String str) {
        this.OdoBrand = str;
    }

    @Nullable
    public final String getOdometer() {
        return this.Odometer;
    }

    public final void setOdometer(@Nullable String str) {
        this.Odometer = str;
    }

    @Nullable
    public final String getOdometerUOM() {
        return this.OdometerUOM;
    }

    public final void setOdometerUOM(@Nullable String str) {
        this.OdometerUOM = str;
    }

    @Nullable
    public final String getPrimaryDamage() {
        return this.PrimaryDamage;
    }

    public final void setPrimaryDamage(@Nullable String str) {
        this.PrimaryDamage = str;
    }

    @Nullable
    public final Boolean getRunAndDrive() {
        return this.RunAndDrive;
    }

    public final void setRunAndDrive(@Nullable Boolean bool) {
        this.RunAndDrive = bool;
    }

    @Nullable
    public final String getSaleDocument() {
        return this.SaleDocument;
    }

    public final void setSaleDocument(@Nullable String str) {
        this.SaleDocument = str;
    }

    @Nullable
    public final Object getSalvageId() {
        return this.SalvageId;
    }

    public final void setSalvageId(@Nullable Object obj) {
        this.SalvageId = obj;
    }

    @Nullable
    public final String getSecondaryDamage() {
        return this.SecondaryDamage;
    }

    public final void setSecondaryDamage(@Nullable String str) {
        this.SecondaryDamage = str;
    }

    @Nullable
    public final String getSellerName() {
        return this.SellerName;
    }

    public final void setSellerName(@Nullable String str) {
        this.SellerName = str;
    }

    @Nullable
    public final Object getSeries() {
        return this.Series;
    }

    public final void setSeries(@Nullable Object obj) {
        this.Series = obj;
    }

    @Nullable
    public final String getStartDesc() {
        return this.StartDesc;
    }

    public final void setStartDesc(@Nullable String str) {
        this.StartDesc = str;
    }

    @Nullable
    public final String getStockno() {
        return this.Stockno;
    }

    public final void setStockno(@Nullable String str) {
        this.Stockno = str;
    }

    @Nullable
    public final String getTenant() {
        return this.Tenant;
    }

    public final void setTenant(@Nullable String str) {
        this.Tenant = str;
    }

    @Nullable
    public final String getTitle() {
        return this.Title;
    }

    public final void setTitle(@Nullable String str) {
        this.Title = str;
    }

    @Nullable
    public final String getVIN() {
        return this.VIN;
    }

    public final void setVIN(@Nullable String str) {
        this.VIN = str;
    }

    @Nullable
    public final Integer getYear() {
        return this.Year;
    }

    public final void setYear(@Nullable Integer num) {
        this.Year = num;
    }
}
