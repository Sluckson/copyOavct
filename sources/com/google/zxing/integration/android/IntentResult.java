package com.google.zxing.integration.android;

public final class IntentResult {
    private final String barcodeImagePath;
    private final String contents;
    private final String errorCorrectionLevel;
    private final String formatName;
    private final Integer orientation;
    private final byte[] rawBytes;

    IntentResult() {
        this((String) null, (String) null, (byte[]) null, (Integer) null, (String) null, (String) null);
    }

    IntentResult(String str, String str2, byte[] bArr, Integer num, String str3, String str4) {
        this.contents = str;
        this.formatName = str2;
        this.rawBytes = bArr;
        this.orientation = num;
        this.errorCorrectionLevel = str3;
        this.barcodeImagePath = str4;
    }

    public String getContents() {
        return this.contents;
    }

    public String getFormatName() {
        return this.formatName;
    }

    public byte[] getRawBytes() {
        return this.rawBytes;
    }

    public Integer getOrientation() {
        return this.orientation;
    }

    public String getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    public String getBarcodeImagePath() {
        return this.barcodeImagePath;
    }

    public String toString() {
        byte[] bArr = this.rawBytes;
        int length = bArr == null ? 0 : bArr.length;
        return "Format: " + this.formatName + 10 + "Contents: " + this.contents + 10 + "Raw bytes: (" + length + " bytes)\nOrientation: " + this.orientation + 10 + "EC level: " + this.errorCorrectionLevel + 10 + "Barcode image: " + this.barcodeImagePath + 10;
    }
}
