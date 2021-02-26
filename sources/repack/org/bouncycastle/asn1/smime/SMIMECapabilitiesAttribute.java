package repack.org.bouncycastle.asn1.smime;

import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.cms.Attribute;

public class SMIMECapabilitiesAttribute extends Attribute {
    public SMIMECapabilitiesAttribute(SMIMECapabilityVector sMIMECapabilityVector) {
        super(SMIMEAttributes.smimeCapabilities, new DERSet((DEREncodable) new DERSequence(sMIMECapabilityVector.toASN1EncodableVector())));
    }
}
