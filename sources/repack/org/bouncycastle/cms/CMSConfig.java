package repack.org.bouncycastle.cms;

import repack.org.bouncycastle.asn1.DERObjectIdentifier;

public class CMSConfig {
    public static void setSigningEncryptionAlgorithmMapping(String str, String str2) {
        CMSSignedHelper.INSTANCE.setSigningEncryptionAlgorithmMapping(new DERObjectIdentifier(str), str2);
    }

    public static void setSigningDigestAlgorithmMapping(String str, String str2) {
        CMSSignedHelper.INSTANCE.setSigningDigestAlgorithmMapping(new DERObjectIdentifier(str), str2);
    }
}
