package repack.org.bouncycastle.asn1.x509;

import java.io.IOException;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERPrintableString;
import repack.org.bouncycastle.util.Strings;

public abstract class X509NameEntryConverter {
    public abstract DERObject getConvertedValue(DERObjectIdentifier dERObjectIdentifier, String str);

    /* access modifiers changed from: protected */
    public DERObject convertHexEncoded(String str, int i) throws IOException {
        String lowerCase = Strings.toLowerCase(str);
        byte[] bArr = new byte[((lowerCase.length() - i) / 2)];
        for (int i2 = 0; i2 != bArr.length; i2++) {
            int i3 = (i2 * 2) + i;
            char charAt = lowerCase.charAt(i3);
            char charAt2 = lowerCase.charAt(i3 + 1);
            if (charAt < 'a') {
                bArr[i2] = (byte) ((charAt - '0') << 4);
            } else {
                bArr[i2] = (byte) (((charAt - 'a') + 10) << 4);
            }
            if (charAt2 < 'a') {
                bArr[i2] = (byte) (((byte) (charAt2 - '0')) | bArr[i2]);
            } else {
                bArr[i2] = (byte) (((byte) ((charAt2 - 'a') + 10)) | bArr[i2]);
            }
        }
        return new ASN1InputStream(bArr).readObject();
    }

    /* access modifiers changed from: protected */
    public boolean canBePrintable(String str) {
        return DERPrintableString.isPrintableString(str);
    }
}
