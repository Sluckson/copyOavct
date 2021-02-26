package com.iaai.android.bdt.model.productDetail.costCalculator;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR \u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR \u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f¨\u0006\u0019"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/productDetail/costCalculator/CostList;", "", "()V", "amount", "", "getAmount", "()Ljava/lang/Float;", "setAmount", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "strAmount", "", "getStrAmount", "()Ljava/lang/String;", "setStrAmount", "(Ljava/lang/String;)V", "tax", "getTax", "setTax", "typeCode", "getTypeCode", "setTypeCode", "typeDesc", "getTypeDesc", "setTypeDesc", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: CostList.kt */
public final class CostList {
    @SerializedName("amount")
    @Nullable
    private Float amount;
    @SerializedName("strAmount")
    @Nullable
    private String strAmount;
    @SerializedName("tax")
    @Nullable
    private Float tax;
    @SerializedName("typeCode")
    @Nullable
    private String typeCode;
    @SerializedName("typeDesc")
    @Nullable
    private String typeDesc;

    @Nullable
    public final Float getAmount() {
        return this.amount;
    }

    public final void setAmount(@Nullable Float f) {
        this.amount = f;
    }

    @Nullable
    public final String getStrAmount() {
        return this.strAmount;
    }

    public final void setStrAmount(@Nullable String str) {
        this.strAmount = str;
    }

    @Nullable
    public final String getTypeCode() {
        return this.typeCode;
    }

    public final void setTypeCode(@Nullable String str) {
        this.typeCode = str;
    }

    @Nullable
    public final String getTypeDesc() {
        return this.typeDesc;
    }

    public final void setTypeDesc(@Nullable String str) {
        this.typeDesc = str;
    }

    @Nullable
    public final Float getTax() {
        return this.tax;
    }

    public final void setTax(@Nullable Float f) {
        this.tax = f;
    }
}
