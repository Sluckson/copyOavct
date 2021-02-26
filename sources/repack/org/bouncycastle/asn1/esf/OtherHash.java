package repack.org.bouncycastle.asn1.esf;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class OtherHash extends ASN1Encodable implements ASN1Choice {
    private OtherHashAlgAndValue otherHash;
    private ASN1OctetString sha1Hash;

    public static OtherHash getInstance(Object obj) {
        if (obj instanceof OtherHash) {
            return (OtherHash) obj;
        }
        if (obj instanceof ASN1OctetString) {
            return new OtherHash((ASN1OctetString) obj);
        }
        return new OtherHash(OtherHashAlgAndValue.getInstance(obj));
    }

    private OtherHash(ASN1OctetString aSN1OctetString) {
        this.sha1Hash = aSN1OctetString;
    }

    public OtherHash(OtherHashAlgAndValue otherHashAlgAndValue) {
        this.otherHash = otherHashAlgAndValue;
    }

    public OtherHash(byte[] bArr) {
        this.sha1Hash = new DEROctetString(bArr);
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        OtherHashAlgAndValue otherHashAlgAndValue = this.otherHash;
        if (otherHashAlgAndValue == null) {
            return new AlgorithmIdentifier((DERObjectIdentifier) OIWObjectIdentifiers.idSHA1);
        }
        return otherHashAlgAndValue.getHashAlgorithm();
    }

    public byte[] getHashValue() {
        OtherHashAlgAndValue otherHashAlgAndValue = this.otherHash;
        if (otherHashAlgAndValue == null) {
            return this.sha1Hash.getOctets();
        }
        return otherHashAlgAndValue.getHashValue().getOctets();
    }

    public DERObject toASN1Object() {
        OtherHashAlgAndValue otherHashAlgAndValue = this.otherHash;
        if (otherHashAlgAndValue == null) {
            return this.sha1Hash;
        }
        return otherHashAlgAndValue.toASN1Object();
    }
}
