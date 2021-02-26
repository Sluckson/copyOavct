package com.iaai.android.bdt.model.productDetail.biddingInfo;

import com.iaai.android.old.analytics.AnalyticsContract;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b.\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\u0002\u0010\u0019J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u000eHÆ\u0003J\t\u00104\u001a\u00020\u0010HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u000eHÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0003HÆ\u0003JÍ\u0001\u0010D\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018HÆ\u0001J\u0013\u0010E\u001a\u00020\u000e2\b\u0010F\u001a\u0004\u0018\u00010GHÖ\u0003J\t\u0010H\u001a\u00020\u0010HÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001bR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001bR\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0011\u0010\u0014\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b,\u0010&R\u0011\u0010\u0015\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u0011\u0010\u0016\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018¢\u0006\b\n\u0000\u001a\u0004\b/\u00100¨\u0006J"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/biddingInfo/SaleInfo;", "Ljava/io/Serializable;", "ACV", "", "AsapMake", "AsapModel", "Brand", "ConditionReport", "CostOfRepairDoc", "EstimatedRepairCost", "Lane", "ModifiedDate", "Notes", "OhioForeignBuyer", "", "SalvageID", "", "Seller", "Slot", "StockNumber", "TexasForeignBuyer", "TitleDocument", "TitleState", "WhoCanBuy", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getACV", "()Ljava/lang/String;", "getAsapMake", "getAsapModel", "getBrand", "getConditionReport", "getCostOfRepairDoc", "getEstimatedRepairCost", "getLane", "getModifiedDate", "getNotes", "getOhioForeignBuyer", "()Z", "getSalvageID", "()I", "getSeller", "getSlot", "getStockNumber", "getTexasForeignBuyer", "getTitleDocument", "getTitleState", "getWhoCanBuy", "()Ljava/util/List;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SaleInfo.kt */
public final class SaleInfo implements Serializable {
    @NotNull
    private final String ACV;
    @NotNull
    private final String AsapMake;
    @NotNull
    private final String AsapModel;
    @NotNull
    private final String Brand;
    @NotNull
    private final String ConditionReport;
    @NotNull
    private final String CostOfRepairDoc;
    @NotNull
    private final String EstimatedRepairCost;
    @NotNull
    private final String Lane;
    @NotNull
    private final String ModifiedDate;
    @NotNull
    private final String Notes;
    private final boolean OhioForeignBuyer;
    private final int SalvageID;
    @NotNull
    private final String Seller;
    @NotNull
    private final String Slot;
    @NotNull
    private final String StockNumber;
    private final boolean TexasForeignBuyer;
    @NotNull
    private final String TitleDocument;
    @NotNull
    private final String TitleState;
    @NotNull
    private final List<String> WhoCanBuy;

    @NotNull
    public static /* synthetic */ SaleInfo copy$default(SaleInfo saleInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, int i, String str11, String str12, String str13, boolean z2, String str14, String str15, List list, int i2, Object obj) {
        String str16;
        boolean z3;
        boolean z4;
        String str17;
        String str18;
        String str19;
        SaleInfo saleInfo2 = saleInfo;
        int i3 = i2;
        String str20 = (i3 & 1) != 0 ? saleInfo2.ACV : str;
        String str21 = (i3 & 2) != 0 ? saleInfo2.AsapMake : str2;
        String str22 = (i3 & 4) != 0 ? saleInfo2.AsapModel : str3;
        String str23 = (i3 & 8) != 0 ? saleInfo2.Brand : str4;
        String str24 = (i3 & 16) != 0 ? saleInfo2.ConditionReport : str5;
        String str25 = (i3 & 32) != 0 ? saleInfo2.CostOfRepairDoc : str6;
        String str26 = (i3 & 64) != 0 ? saleInfo2.EstimatedRepairCost : str7;
        String str27 = (i3 & 128) != 0 ? saleInfo2.Lane : str8;
        String str28 = (i3 & 256) != 0 ? saleInfo2.ModifiedDate : str9;
        String str29 = (i3 & 512) != 0 ? saleInfo2.Notes : str10;
        boolean z5 = (i3 & 1024) != 0 ? saleInfo2.OhioForeignBuyer : z;
        int i4 = (i3 & 2048) != 0 ? saleInfo2.SalvageID : i;
        String str30 = (i3 & 4096) != 0 ? saleInfo2.Seller : str11;
        String str31 = (i3 & 8192) != 0 ? saleInfo2.Slot : str12;
        String str32 = (i3 & 16384) != 0 ? saleInfo2.StockNumber : str13;
        if ((i3 & 32768) != 0) {
            str16 = str32;
            z3 = saleInfo2.TexasForeignBuyer;
        } else {
            str16 = str32;
            z3 = z2;
        }
        if ((i3 & 65536) != 0) {
            z4 = z3;
            str17 = saleInfo2.TitleDocument;
        } else {
            z4 = z3;
            str17 = str14;
        }
        if ((i3 & 131072) != 0) {
            str18 = str17;
            str19 = saleInfo2.TitleState;
        } else {
            str18 = str17;
            str19 = str15;
        }
        return saleInfo.copy(str20, str21, str22, str23, str24, str25, str26, str27, str28, str29, z5, i4, str30, str31, str16, z4, str18, str19, (i3 & 262144) != 0 ? saleInfo2.WhoCanBuy : list);
    }

    @NotNull
    public final String component1() {
        return this.ACV;
    }

    @NotNull
    public final String component10() {
        return this.Notes;
    }

    public final boolean component11() {
        return this.OhioForeignBuyer;
    }

    public final int component12() {
        return this.SalvageID;
    }

    @NotNull
    public final String component13() {
        return this.Seller;
    }

    @NotNull
    public final String component14() {
        return this.Slot;
    }

    @NotNull
    public final String component15() {
        return this.StockNumber;
    }

    public final boolean component16() {
        return this.TexasForeignBuyer;
    }

    @NotNull
    public final String component17() {
        return this.TitleDocument;
    }

    @NotNull
    public final String component18() {
        return this.TitleState;
    }

    @NotNull
    public final List<String> component19() {
        return this.WhoCanBuy;
    }

    @NotNull
    public final String component2() {
        return this.AsapMake;
    }

    @NotNull
    public final String component3() {
        return this.AsapModel;
    }

    @NotNull
    public final String component4() {
        return this.Brand;
    }

    @NotNull
    public final String component5() {
        return this.ConditionReport;
    }

    @NotNull
    public final String component6() {
        return this.CostOfRepairDoc;
    }

    @NotNull
    public final String component7() {
        return this.EstimatedRepairCost;
    }

    @NotNull
    public final String component8() {
        return this.Lane;
    }

    @NotNull
    public final String component9() {
        return this.ModifiedDate;
    }

    @NotNull
    public final SaleInfo copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, boolean z, int i, @NotNull String str11, @NotNull String str12, @NotNull String str13, boolean z2, @NotNull String str14, @NotNull String str15, @NotNull List<String> list) {
        String str16 = str;
        Intrinsics.checkParameterIsNotNull(str16, "ACV");
        Intrinsics.checkParameterIsNotNull(str2, "AsapMake");
        Intrinsics.checkParameterIsNotNull(str3, "AsapModel");
        Intrinsics.checkParameterIsNotNull(str4, "Brand");
        Intrinsics.checkParameterIsNotNull(str5, "ConditionReport");
        Intrinsics.checkParameterIsNotNull(str6, "CostOfRepairDoc");
        Intrinsics.checkParameterIsNotNull(str7, "EstimatedRepairCost");
        Intrinsics.checkParameterIsNotNull(str8, "Lane");
        Intrinsics.checkParameterIsNotNull(str9, "ModifiedDate");
        Intrinsics.checkParameterIsNotNull(str10, "Notes");
        Intrinsics.checkParameterIsNotNull(str11, "Seller");
        Intrinsics.checkParameterIsNotNull(str12, "Slot");
        Intrinsics.checkParameterIsNotNull(str13, AnalyticsContract.Analytics.COLUMN_NAME_STOCK_NO);
        Intrinsics.checkParameterIsNotNull(str14, "TitleDocument");
        Intrinsics.checkParameterIsNotNull(str15, "TitleState");
        Intrinsics.checkParameterIsNotNull(list, "WhoCanBuy");
        return new SaleInfo(str16, str2, str3, str4, str5, str6, str7, str8, str9, str10, z, i, str11, str12, str13, z2, str14, str15, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof SaleInfo) {
                SaleInfo saleInfo = (SaleInfo) obj;
                if (Intrinsics.areEqual((Object) this.ACV, (Object) saleInfo.ACV) && Intrinsics.areEqual((Object) this.AsapMake, (Object) saleInfo.AsapMake) && Intrinsics.areEqual((Object) this.AsapModel, (Object) saleInfo.AsapModel) && Intrinsics.areEqual((Object) this.Brand, (Object) saleInfo.Brand) && Intrinsics.areEqual((Object) this.ConditionReport, (Object) saleInfo.ConditionReport) && Intrinsics.areEqual((Object) this.CostOfRepairDoc, (Object) saleInfo.CostOfRepairDoc) && Intrinsics.areEqual((Object) this.EstimatedRepairCost, (Object) saleInfo.EstimatedRepairCost) && Intrinsics.areEqual((Object) this.Lane, (Object) saleInfo.Lane) && Intrinsics.areEqual((Object) this.ModifiedDate, (Object) saleInfo.ModifiedDate) && Intrinsics.areEqual((Object) this.Notes, (Object) saleInfo.Notes)) {
                    if (this.OhioForeignBuyer == saleInfo.OhioForeignBuyer) {
                        if ((this.SalvageID == saleInfo.SalvageID) && Intrinsics.areEqual((Object) this.Seller, (Object) saleInfo.Seller) && Intrinsics.areEqual((Object) this.Slot, (Object) saleInfo.Slot) && Intrinsics.areEqual((Object) this.StockNumber, (Object) saleInfo.StockNumber)) {
                            if (!(this.TexasForeignBuyer == saleInfo.TexasForeignBuyer) || !Intrinsics.areEqual((Object) this.TitleDocument, (Object) saleInfo.TitleDocument) || !Intrinsics.areEqual((Object) this.TitleState, (Object) saleInfo.TitleState) || !Intrinsics.areEqual((Object) this.WhoCanBuy, (Object) saleInfo.WhoCanBuy)) {
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
        String str = this.ACV;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.AsapMake;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.AsapModel;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.Brand;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.ConditionReport;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.CostOfRepairDoc;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.EstimatedRepairCost;
        int hashCode7 = (hashCode6 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.Lane;
        int hashCode8 = (hashCode7 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.ModifiedDate;
        int hashCode9 = (hashCode8 + (str9 != null ? str9.hashCode() : 0)) * 31;
        String str10 = this.Notes;
        int hashCode10 = (hashCode9 + (str10 != null ? str10.hashCode() : 0)) * 31;
        boolean z = this.OhioForeignBuyer;
        if (z) {
            z = true;
        }
        int hashCode11 = (((hashCode10 + (z ? 1 : 0)) * 31) + Integer.valueOf(this.SalvageID).hashCode()) * 31;
        String str11 = this.Seller;
        int hashCode12 = (hashCode11 + (str11 != null ? str11.hashCode() : 0)) * 31;
        String str12 = this.Slot;
        int hashCode13 = (hashCode12 + (str12 != null ? str12.hashCode() : 0)) * 31;
        String str13 = this.StockNumber;
        int hashCode14 = (hashCode13 + (str13 != null ? str13.hashCode() : 0)) * 31;
        boolean z2 = this.TexasForeignBuyer;
        if (z2) {
            z2 = true;
        }
        int i2 = (hashCode14 + (z2 ? 1 : 0)) * 31;
        String str14 = this.TitleDocument;
        int hashCode15 = (i2 + (str14 != null ? str14.hashCode() : 0)) * 31;
        String str15 = this.TitleState;
        int hashCode16 = (hashCode15 + (str15 != null ? str15.hashCode() : 0)) * 31;
        List<String> list = this.WhoCanBuy;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode16 + i;
    }

    @NotNull
    public String toString() {
        return "SaleInfo(ACV=" + this.ACV + ", AsapMake=" + this.AsapMake + ", AsapModel=" + this.AsapModel + ", Brand=" + this.Brand + ", ConditionReport=" + this.ConditionReport + ", CostOfRepairDoc=" + this.CostOfRepairDoc + ", EstimatedRepairCost=" + this.EstimatedRepairCost + ", Lane=" + this.Lane + ", ModifiedDate=" + this.ModifiedDate + ", Notes=" + this.Notes + ", OhioForeignBuyer=" + this.OhioForeignBuyer + ", SalvageID=" + this.SalvageID + ", Seller=" + this.Seller + ", Slot=" + this.Slot + ", StockNumber=" + this.StockNumber + ", TexasForeignBuyer=" + this.TexasForeignBuyer + ", TitleDocument=" + this.TitleDocument + ", TitleState=" + this.TitleState + ", WhoCanBuy=" + this.WhoCanBuy + ")";
    }

    public SaleInfo(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, boolean z, int i, @NotNull String str11, @NotNull String str12, @NotNull String str13, boolean z2, @NotNull String str14, @NotNull String str15, @NotNull List<String> list) {
        String str16 = str;
        String str17 = str2;
        String str18 = str3;
        String str19 = str4;
        String str20 = str5;
        String str21 = str6;
        String str22 = str7;
        String str23 = str8;
        String str24 = str9;
        String str25 = str10;
        String str26 = str11;
        String str27 = str12;
        String str28 = str13;
        String str29 = str14;
        Intrinsics.checkParameterIsNotNull(str16, "ACV");
        Intrinsics.checkParameterIsNotNull(str17, "AsapMake");
        Intrinsics.checkParameterIsNotNull(str18, "AsapModel");
        Intrinsics.checkParameterIsNotNull(str19, "Brand");
        Intrinsics.checkParameterIsNotNull(str20, "ConditionReport");
        Intrinsics.checkParameterIsNotNull(str21, "CostOfRepairDoc");
        Intrinsics.checkParameterIsNotNull(str22, "EstimatedRepairCost");
        Intrinsics.checkParameterIsNotNull(str23, "Lane");
        Intrinsics.checkParameterIsNotNull(str24, "ModifiedDate");
        Intrinsics.checkParameterIsNotNull(str25, "Notes");
        Intrinsics.checkParameterIsNotNull(str26, "Seller");
        Intrinsics.checkParameterIsNotNull(str27, "Slot");
        Intrinsics.checkParameterIsNotNull(str28, AnalyticsContract.Analytics.COLUMN_NAME_STOCK_NO);
        Intrinsics.checkParameterIsNotNull(str29, "TitleDocument");
        Intrinsics.checkParameterIsNotNull(str15, "TitleState");
        List<String> list2 = list;
        Intrinsics.checkParameterIsNotNull(list2, "WhoCanBuy");
        this.ACV = str16;
        this.AsapMake = str17;
        this.AsapModel = str18;
        this.Brand = str19;
        this.ConditionReport = str20;
        this.CostOfRepairDoc = str21;
        this.EstimatedRepairCost = str22;
        this.Lane = str23;
        this.ModifiedDate = str24;
        this.Notes = str25;
        this.OhioForeignBuyer = z;
        this.SalvageID = i;
        this.Seller = str26;
        this.Slot = str27;
        this.StockNumber = str28;
        this.TexasForeignBuyer = z2;
        this.TitleDocument = str29;
        this.TitleState = str15;
        this.WhoCanBuy = list2;
    }

    @NotNull
    public final String getACV() {
        return this.ACV;
    }

    @NotNull
    public final String getAsapMake() {
        return this.AsapMake;
    }

    @NotNull
    public final String getAsapModel() {
        return this.AsapModel;
    }

    @NotNull
    public final String getBrand() {
        return this.Brand;
    }

    @NotNull
    public final String getConditionReport() {
        return this.ConditionReport;
    }

    @NotNull
    public final String getCostOfRepairDoc() {
        return this.CostOfRepairDoc;
    }

    @NotNull
    public final String getEstimatedRepairCost() {
        return this.EstimatedRepairCost;
    }

    @NotNull
    public final String getLane() {
        return this.Lane;
    }

    @NotNull
    public final String getModifiedDate() {
        return this.ModifiedDate;
    }

    @NotNull
    public final String getNotes() {
        return this.Notes;
    }

    public final boolean getOhioForeignBuyer() {
        return this.OhioForeignBuyer;
    }

    public final int getSalvageID() {
        return this.SalvageID;
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
    public final String getStockNumber() {
        return this.StockNumber;
    }

    public final boolean getTexasForeignBuyer() {
        return this.TexasForeignBuyer;
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
    public final List<String> getWhoCanBuy() {
        return this.WhoCanBuy;
    }
}
