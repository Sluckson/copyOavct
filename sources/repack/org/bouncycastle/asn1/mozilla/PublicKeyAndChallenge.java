package repack.org.bouncycastle.asn1.mozilla;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERIA5String;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class PublicKeyAndChallenge extends ASN1Encodable {
    private DERIA5String challenge;
    private ASN1Sequence pkacSeq;
    private SubjectPublicKeyInfo spki;

    public static PublicKeyAndChallenge getInstance(Object obj) {
        if (obj instanceof PublicKeyAndChallenge) {
            return (PublicKeyAndChallenge) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new PublicKeyAndChallenge((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("unkown object in factory: " + obj.getClass().getName());
    }

    public PublicKeyAndChallenge(ASN1Sequence aSN1Sequence) {
        this.pkacSeq = aSN1Sequence;
        this.spki = SubjectPublicKeyInfo.getInstance(aSN1Sequence.getObjectAt(0));
        this.challenge = DERIA5String.getInstance(aSN1Sequence.getObjectAt(1));
    }

    public DERObject toASN1Object() {
        return this.pkacSeq;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.spki;
    }

    public DERIA5String getChallenge() {
        return this.challenge;
    }
}
