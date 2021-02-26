package repack.org.bouncycastle.asn1.x509;

import com.google.common.primitives.SignedBytes;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;

public class SubjectKeyIdentifier extends ASN1Encodable {
    private byte[] keyidentifier;

    public static SubjectKeyIdentifier getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1OctetString.getInstance(aSN1TaggedObject, z));
    }

    public static SubjectKeyIdentifier getInstance(Object obj) {
        if (obj instanceof SubjectKeyIdentifier) {
            return (SubjectKeyIdentifier) obj;
        }
        if (obj instanceof SubjectPublicKeyInfo) {
            return new SubjectKeyIdentifier((SubjectPublicKeyInfo) obj);
        }
        if (obj instanceof ASN1OctetString) {
            return new SubjectKeyIdentifier((ASN1OctetString) obj);
        }
        if (obj instanceof X509Extension) {
            return getInstance(X509Extension.convertValueToObject((X509Extension) obj));
        }
        throw new IllegalArgumentException("Invalid SubjectKeyIdentifier: " + obj.getClass().getName());
    }

    public SubjectKeyIdentifier(byte[] bArr) {
        this.keyidentifier = bArr;
    }

    public SubjectKeyIdentifier(ASN1OctetString aSN1OctetString) {
        this.keyidentifier = aSN1OctetString.getOctets();
    }

    public SubjectKeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.keyidentifier = getDigest(subjectPublicKeyInfo);
    }

    public byte[] getKeyIdentifier() {
        return this.keyidentifier;
    }

    public DERObject toASN1Object() {
        return new DEROctetString(this.keyidentifier);
    }

    public static SubjectKeyIdentifier createSHA1KeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        return new SubjectKeyIdentifier(subjectPublicKeyInfo);
    }

    public static SubjectKeyIdentifier createTruncatedSHA1KeyIdentifier(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        byte[] digest = getDigest(subjectPublicKeyInfo);
        byte[] bArr = new byte[8];
        System.arraycopy(digest, digest.length - 8, bArr, 0, bArr.length);
        bArr[0] = (byte) (bArr[0] & 15);
        bArr[0] = (byte) (bArr[0] | SignedBytes.MAX_POWER_OF_TWO);
        return new SubjectKeyIdentifier(bArr);
    }

    private static byte[] getDigest(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        SHA1Digest sHA1Digest = new SHA1Digest();
        byte[] bArr = new byte[sHA1Digest.getDigestSize()];
        byte[] bytes = subjectPublicKeyInfo.getPublicKeyData().getBytes();
        sHA1Digest.update(bytes, 0, bytes.length);
        sHA1Digest.doFinal(bArr, 0);
        return bArr;
    }
}
