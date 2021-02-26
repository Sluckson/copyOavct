package com.iaai.android.bdt.model.MyAccount;

import android.util.Base64;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0012\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0017"}, mo66933d2 = {"Lcom/iaai/android/bdt/model/MyAccount/VehicleReceiptPDFResponse;", "", "()V", "cdfReceipt", "", "getCdfReceipt", "()Ljava/lang/String;", "setCdfReceipt", "(Ljava/lang/String;)V", "errorMessage", "getErrorMessage", "setErrorMessage", "orderReceipt", "getOrderReceipt", "setOrderReceipt", "stockReceipt", "getStockReceipt", "setStockReceipt", "getCDFReceipt", "getCDFReceiptImage", "", "getOrderReceiptImage", "getStockReceiptImage", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: VehicleReceiptPDFResponse.kt */
public final class VehicleReceiptPDFResponse {
    @SerializedName("CDFReceipt")
    @Nullable
    private String cdfReceipt;
    @SerializedName("ErrorMessage")
    @Nullable
    private String errorMessage;
    @SerializedName("OrderReceipt")
    @Nullable
    private String orderReceipt;
    @SerializedName("StockReceipt")
    @Nullable
    private String stockReceipt;

    @Nullable
    public final String getCdfReceipt() {
        return this.cdfReceipt;
    }

    public final void setCdfReceipt(@Nullable String str) {
        this.cdfReceipt = str;
    }

    @Nullable
    public final String getOrderReceipt() {
        return this.orderReceipt;
    }

    public final void setOrderReceipt(@Nullable String str) {
        this.orderReceipt = str;
    }

    @Nullable
    public final String getStockReceipt() {
        return this.stockReceipt;
    }

    public final void setStockReceipt(@Nullable String str) {
        this.stockReceipt = str;
    }

    @Nullable
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final void setErrorMessage(@Nullable String str) {
        this.errorMessage = str;
    }

    @Nullable
    public final String getCDFReceipt() {
        return this.cdfReceipt;
    }

    @Nullable
    public final byte[] getCDFReceiptImage() {
        String str = this.cdfReceipt;
        if (str != null) {
            return Base64.decode(str, 0);
        }
        return null;
    }

    @Nullable
    public final byte[] getOrderReceiptImage() {
        String str = this.orderReceipt;
        if (str != null) {
            return Base64.decode(str, 0);
        }
        return null;
    }

    @Nullable
    public final byte[] getStockReceiptImage() {
        String str = this.stockReceipt;
        if (str != null) {
            return Base64.decode(str, 0);
        }
        return null;
    }
}
