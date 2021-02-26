package repack.org.bouncycastle.cert.crmf;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.DERUTF8String;
import repack.org.bouncycastle.asn1.crmf.CRMFObjectIdentifiers;

public class AuthenticatorControl implements Control {
    private static final ASN1ObjectIdentifier type = CRMFObjectIdentifiers.id_regCtrl_authenticator;
    private final DERUTF8String token;

    public AuthenticatorControl(DERUTF8String dERUTF8String) {
        this.token = dERUTF8String;
    }

    public AuthenticatorControl(String str) {
        this.token = new DERUTF8String(str);
    }

    public ASN1ObjectIdentifier getType() {
        return type;
    }

    public ASN1Encodable getValue() {
        return this.token;
    }
}
