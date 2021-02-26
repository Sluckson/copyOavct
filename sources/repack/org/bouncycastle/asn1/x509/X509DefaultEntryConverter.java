package repack.org.bouncycastle.asn1.x509;

import java.io.IOException;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERIA5String;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DERPrintableString;
import repack.org.bouncycastle.asn1.DERUTF8String;

public class X509DefaultEntryConverter extends X509NameEntryConverter {
    public DERObject getConvertedValue(DERObjectIdentifier dERObjectIdentifier, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            if (dERObjectIdentifier.equals(X509Name.EmailAddress) || dERObjectIdentifier.equals(X509Name.f5880DC)) {
                return new DERIA5String(str);
            }
            if (dERObjectIdentifier.equals(X509Name.DATE_OF_BIRTH)) {
                return new DERGeneralizedTime(str);
            }
            if (dERObjectIdentifier.equals(X509Name.f5878C) || dERObjectIdentifier.equals(X509Name.f5885SN) || dERObjectIdentifier.equals(X509Name.DN_QUALIFIER) || dERObjectIdentifier.equals(X509Name.TELEPHONE_NUMBER)) {
                return new DERPrintableString(str);
            }
            return new DERUTF8String(str);
        }
        try {
            return convertHexEncoded(str, 1);
        } catch (IOException unused) {
            throw new RuntimeException("can't recode value for oid " + dERObjectIdentifier.getId());
        }
    }
}
