package com.iaai.android.old.models;

import android.util.Base64;
import com.google.gson.annotations.SerializedName;

public class VehicleReceipt {
    @SerializedName("CDFReceipt")
    public String cdfReceipt;
    @SerializedName("ErrorMessage")
    public String errorMessage;
    @SerializedName("OrderReceipt")
    public String orderReceipt;
    @SerializedName("StockReceipt")
    public String stockReceipt;

    public String getCDFReceipt() {
        return this.cdfReceipt;
    }

    public byte[] getCDFReceiptImage() {
        String str = this.cdfReceipt;
        if (str != null) {
            return Base64.decode(str, 0);
        }
        return null;
    }

    public String getOrderReceipt() {
        return this.orderReceipt;
    }

    public byte[] getOrderReceiptImage() {
        String str = this.orderReceipt;
        if (str != null) {
            return Base64.decode(str, 0);
        }
        return null;
    }

    public String getStockReceipt() {
        return this.stockReceipt;
    }

    public byte[] getStockReceiptImage() {
        String str = this.stockReceipt;
        if (str != null) {
            return Base64.decode(str, 0);
        }
        return null;
    }
}
