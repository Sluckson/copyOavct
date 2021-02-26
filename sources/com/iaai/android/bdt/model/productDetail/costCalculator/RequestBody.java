package com.iaai.android.bdt.model.productDetail.costCalculator;

import com.iaai.android.bdt.utils.Constants_MVVM;
import java.math.BigDecimal;
import java.math.BigInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u000bHÆ\u0003J\t\u0010#\u001a\u00020\u000bHÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0006HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\bHÆ\u0003J\t\u0010(\u001a\u00020\u000bHÆ\u0003J\t\u0010)\u001a\u00020\u000bHÆ\u0003J\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003Jw\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u000bHÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\bHÖ\u0001J\t\u00101\u001a\u00020\u000bHÖ\u0001R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\r\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017¨\u00062"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/costCalculator/RequestBody;", "", "salvageID", "Ljava/math/BigDecimal;", "stockNumber", "bidAmount", "Ljava/math/BigInteger;", "buyerID", "", "UserID", "pickupZip", "", "dropOffZip", "vin", "runAndDrive", "employeeID", "branchCode", "(Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigInteger;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUserID", "()I", "getBidAmount", "()Ljava/math/BigInteger;", "getBranchCode", "()Ljava/lang/String;", "getBuyerID", "getDropOffZip", "getEmployeeID", "getPickupZip", "getRunAndDrive", "getSalvageID", "()Ljava/math/BigDecimal;", "getStockNumber", "getVin", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: RequestBody.kt */
public final class RequestBody {
    private final int UserID;
    @NotNull
    private final BigInteger bidAmount;
    @NotNull
    private final String branchCode;
    private final int buyerID;
    @NotNull
    private final String dropOffZip;
    @NotNull
    private final String employeeID;
    @NotNull
    private final String pickupZip;
    @NotNull
    private final String runAndDrive;
    @NotNull
    private final BigDecimal salvageID;
    @NotNull
    private final BigDecimal stockNumber;
    @NotNull
    private final String vin;

    @NotNull
    public static /* synthetic */ RequestBody copy$default(RequestBody requestBody, BigDecimal bigDecimal, BigDecimal bigDecimal2, BigInteger bigInteger, int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3, Object obj) {
        RequestBody requestBody2 = requestBody;
        int i4 = i3;
        return requestBody.copy((i4 & 1) != 0 ? requestBody2.salvageID : bigDecimal, (i4 & 2) != 0 ? requestBody2.stockNumber : bigDecimal2, (i4 & 4) != 0 ? requestBody2.bidAmount : bigInteger, (i4 & 8) != 0 ? requestBody2.buyerID : i, (i4 & 16) != 0 ? requestBody2.UserID : i2, (i4 & 32) != 0 ? requestBody2.pickupZip : str, (i4 & 64) != 0 ? requestBody2.dropOffZip : str2, (i4 & 128) != 0 ? requestBody2.vin : str3, (i4 & 256) != 0 ? requestBody2.runAndDrive : str4, (i4 & 512) != 0 ? requestBody2.employeeID : str5, (i4 & 1024) != 0 ? requestBody2.branchCode : str6);
    }

    @NotNull
    public final BigDecimal component1() {
        return this.salvageID;
    }

    @NotNull
    public final String component10() {
        return this.employeeID;
    }

    @NotNull
    public final String component11() {
        return this.branchCode;
    }

    @NotNull
    public final BigDecimal component2() {
        return this.stockNumber;
    }

    @NotNull
    public final BigInteger component3() {
        return this.bidAmount;
    }

    public final int component4() {
        return this.buyerID;
    }

    public final int component5() {
        return this.UserID;
    }

    @NotNull
    public final String component6() {
        return this.pickupZip;
    }

    @NotNull
    public final String component7() {
        return this.dropOffZip;
    }

    @NotNull
    public final String component8() {
        return this.vin;
    }

    @NotNull
    public final String component9() {
        return this.runAndDrive;
    }

    @NotNull
    public final RequestBody copy(@NotNull BigDecimal bigDecimal, @NotNull BigDecimal bigDecimal2, @NotNull BigInteger bigInteger, int i, int i2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, Constants_MVVM.EXTRA_SALVAGE_ID);
        Intrinsics.checkParameterIsNotNull(bigDecimal2, "stockNumber");
        BigInteger bigInteger2 = bigInteger;
        Intrinsics.checkParameterIsNotNull(bigInteger2, "bidAmount");
        String str7 = str;
        Intrinsics.checkParameterIsNotNull(str7, "pickupZip");
        String str8 = str2;
        Intrinsics.checkParameterIsNotNull(str8, "dropOffZip");
        String str9 = str3;
        Intrinsics.checkParameterIsNotNull(str9, Constants_MVVM.EXTRA_VIN);
        String str10 = str4;
        Intrinsics.checkParameterIsNotNull(str10, "runAndDrive");
        String str11 = str5;
        Intrinsics.checkParameterIsNotNull(str11, Constants_MVVM.EXTRA_EMPLOYEE_ID);
        String str12 = str6;
        Intrinsics.checkParameterIsNotNull(str12, Constants_MVVM.EXTRA_BRANCH_CODE);
        return new RequestBody(bigDecimal, bigDecimal2, bigInteger2, i, i2, str7, str8, str9, str10, str11, str12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof RequestBody) {
                RequestBody requestBody = (RequestBody) obj;
                if (Intrinsics.areEqual((Object) this.salvageID, (Object) requestBody.salvageID) && Intrinsics.areEqual((Object) this.stockNumber, (Object) requestBody.stockNumber) && Intrinsics.areEqual((Object) this.bidAmount, (Object) requestBody.bidAmount)) {
                    if (this.buyerID == requestBody.buyerID) {
                        if (!(this.UserID == requestBody.UserID) || !Intrinsics.areEqual((Object) this.pickupZip, (Object) requestBody.pickupZip) || !Intrinsics.areEqual((Object) this.dropOffZip, (Object) requestBody.dropOffZip) || !Intrinsics.areEqual((Object) this.vin, (Object) requestBody.vin) || !Intrinsics.areEqual((Object) this.runAndDrive, (Object) requestBody.runAndDrive) || !Intrinsics.areEqual((Object) this.employeeID, (Object) requestBody.employeeID) || !Intrinsics.areEqual((Object) this.branchCode, (Object) requestBody.branchCode)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        BigDecimal bigDecimal = this.salvageID;
        int i = 0;
        int hashCode = (bigDecimal != null ? bigDecimal.hashCode() : 0) * 31;
        BigDecimal bigDecimal2 = this.stockNumber;
        int hashCode2 = (hashCode + (bigDecimal2 != null ? bigDecimal2.hashCode() : 0)) * 31;
        BigInteger bigInteger = this.bidAmount;
        int hashCode3 = (((((hashCode2 + (bigInteger != null ? bigInteger.hashCode() : 0)) * 31) + Integer.valueOf(this.buyerID).hashCode()) * 31) + Integer.valueOf(this.UserID).hashCode()) * 31;
        String str = this.pickupZip;
        int hashCode4 = (hashCode3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.dropOffZip;
        int hashCode5 = (hashCode4 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.vin;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.runAndDrive;
        int hashCode7 = (hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.employeeID;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.branchCode;
        if (str6 != null) {
            i = str6.hashCode();
        }
        return hashCode8 + i;
    }

    @NotNull
    public String toString() {
        return "RequestBody(salvageID=" + this.salvageID + ", stockNumber=" + this.stockNumber + ", bidAmount=" + this.bidAmount + ", buyerID=" + this.buyerID + ", UserID=" + this.UserID + ", pickupZip=" + this.pickupZip + ", dropOffZip=" + this.dropOffZip + ", vin=" + this.vin + ", runAndDrive=" + this.runAndDrive + ", employeeID=" + this.employeeID + ", branchCode=" + this.branchCode + ")";
    }

    public RequestBody(@NotNull BigDecimal bigDecimal, @NotNull BigDecimal bigDecimal2, @NotNull BigInteger bigInteger, int i, int i2, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkParameterIsNotNull(bigDecimal, Constants_MVVM.EXTRA_SALVAGE_ID);
        Intrinsics.checkParameterIsNotNull(bigDecimal2, "stockNumber");
        Intrinsics.checkParameterIsNotNull(bigInteger, "bidAmount");
        Intrinsics.checkParameterIsNotNull(str, "pickupZip");
        Intrinsics.checkParameterIsNotNull(str2, "dropOffZip");
        Intrinsics.checkParameterIsNotNull(str3, Constants_MVVM.EXTRA_VIN);
        Intrinsics.checkParameterIsNotNull(str4, "runAndDrive");
        Intrinsics.checkParameterIsNotNull(str5, Constants_MVVM.EXTRA_EMPLOYEE_ID);
        Intrinsics.checkParameterIsNotNull(str6, Constants_MVVM.EXTRA_BRANCH_CODE);
        this.salvageID = bigDecimal;
        this.stockNumber = bigDecimal2;
        this.bidAmount = bigInteger;
        this.buyerID = i;
        this.UserID = i2;
        this.pickupZip = str;
        this.dropOffZip = str2;
        this.vin = str3;
        this.runAndDrive = str4;
        this.employeeID = str5;
        this.branchCode = str6;
    }

    @NotNull
    public final BigDecimal getSalvageID() {
        return this.salvageID;
    }

    @NotNull
    public final BigDecimal getStockNumber() {
        return this.stockNumber;
    }

    @NotNull
    public final BigInteger getBidAmount() {
        return this.bidAmount;
    }

    public final int getBuyerID() {
        return this.buyerID;
    }

    public final int getUserID() {
        return this.UserID;
    }

    @NotNull
    public final String getPickupZip() {
        return this.pickupZip;
    }

    @NotNull
    public final String getDropOffZip() {
        return this.dropOffZip;
    }

    @NotNull
    public final String getVin() {
        return this.vin;
    }

    @NotNull
    public final String getRunAndDrive() {
        return this.runAndDrive;
    }

    @NotNull
    public final String getEmployeeID() {
        return this.employeeID;
    }

    @NotNull
    public final String getBranchCode() {
        return this.branchCode;
    }
}
