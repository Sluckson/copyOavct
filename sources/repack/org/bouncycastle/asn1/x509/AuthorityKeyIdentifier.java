package repack.org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;

public class AuthorityKeyIdentifier extends ASN1Encodable {
    GeneralNames certissuer;
    DERInteger certserno;
    ASN1OctetString keyidentifier;

    public static AuthorityKeyIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static AuthorityKeyIdentifier getInstance(Object obj) {
        if (obj instanceof AuthorityKeyIdentifier) {
            return (AuthorityKeyIdentifier) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new AuthorityKeyIdentifier((ASN1Sequence) obj);
        }
        if (obj instanceof X509Extension) {
            return getInstance(X509Extension.convertValueToObject((X509Extension) obj));
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    public AuthorityKeyIdentifier(ASN1Sequence aSN1Sequence) {
        this.keyidentifier = null;
        this.certissuer = null;
        this.certserno = null;
        Enumeration objects = aSN1Sequence.getObjects();
        while (objects.hasMoreElements()) {
            ASN1TaggedObject instance = DERTaggedObject.getInstance(objects.nextElement());
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.keyidentifier = ASN1OctetString.getInstance(instance, false);
            } else if (tagNo == 1) {
                this.certissuer = GeneralNames.getInstance(instance, false);
            } else if (tagNo == 2) {
                this.certserno = DERInteger.getInstance(instance, false);
            } else {
                throw new IllegalArgumentException("illegal tag");
            }
        }
    }

    public AuthorityKeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.keyidentifier = null;
        this.certissuer = null;
        this.certserno = null;
        SHA1Digest sHA1Digest = new SHA1Digest();
        byte[] bArr = new byte[sHA1Digest.getDigestSize()];
        byte[] bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
        sHA1Digest.update(bytes, 0, bytes.length);
        sHA1Digest.doFinal(bArr, 0);
        this.keyidentifier = new DEROctetString(bArr);
    }

    public AuthorityKeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo, GeneralNames generalNames, BigInteger bigInteger) {
        this.keyidentifier = null;
        this.certissuer = null;
        this.certserno = null;
        SHA1Digest sHA1Digest = new SHA1Digest();
        byte[] bArr = new byte[sHA1Digest.getDigestSize()];
        byte[] bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
        sHA1Digest.update(bytes, 0, bytes.length);
        sHA1Digest.doFinal(bArr, 0);
        this.keyidentifier = new DEROctetString(bArr);
        this.certissuer = GeneralNames.getInstance(generalNames.toASN1Object());
        this.certserno = new DERInteger(bigInteger);
    }

    public AuthorityKeyIdentifier(GeneralNames generalNames, BigInteger bigInteger) {
        this.keyidentifier = null;
        this.certissuer = null;
        this.certserno = null;
        this.keyidentifier = null;
        this.certissuer = GeneralNames.getInstance(generalNames.toASN1Object());
        this.certserno = new DERInteger(bigInteger);
    }

    public AuthorityKeyIdentifier(byte[] bArr) {
        this.keyidentifier = null;
        this.certissuer = null;
        this.certserno = null;
        this.keyidentifier = new DEROctetString(bArr);
        this.certissuer = null;
        this.certserno = null;
    }

    public AuthorityKeyIdentifier(byte[] bArr, GeneralNames generalNames, BigInteger bigInteger) {
        this.keyidentifier = null;
        this.certissuer = null;
        this.certserno = null;
        this.keyidentifier = new DEROctetString(bArr);
        this.certissuer = GeneralNames.getInstance(generalNames.toASN1Object());
        this.certserno = new DERInteger(bigInteger);
    }

    public byte[] getKeyIdentifier() {
        ASN1OctetString aSN1OctetString = this.keyidentifier;
        if (aSN1OctetString != null) {
            return aSN1OctetString.getOctets();
        }
        return null;
    }

    public GeneralNames getAuthorityCertIssuer() {
        return this.certissuer;
    }

    public BigInteger getAuthorityCertSerialNumber() {
        DERInteger dERInteger = this.certserno;
        if (dERInteger != null) {
            return dERInteger.getValue();
        }
        return null;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1OctetString aSN1OctetString = this.keyidentifier;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, aSN1OctetString));
        }
        GeneralNames generalNames = this.certissuer;
        if (generalNames != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, generalNames));
        }
        DERInteger dERInteger = this.certserno;
        if (dERInteger != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 2, dERInteger));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        return "AuthorityKeyIdentifier: KeyID(" + this.keyidentifier.getOctets() + ")";
    }
}
