package com.lowagie.text.pdf.interfaces;

import com.lowagie.text.DocumentException;
import java.security.cert.Certificate;

public interface PdfEncryptionSettings {
    void setEncryption(byte[] bArr, byte[] bArr2, int i, int i2) throws DocumentException;

    void setEncryption(Certificate[] certificateArr, int[] iArr, int i) throws DocumentException;
}
