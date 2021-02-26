package repack.org.bouncycastle.mozilla;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.mozilla.PublicKeyAndChallenge;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class SignedPublicKeyAndChallenge extends ASN1Encodable {
    private PublicKeyAndChallenge pkac = PublicKeyAndChallenge.getInstance(this.spkacSeq.getObjectAt(0));
    private DERBitString signature = ((DERBitString) this.spkacSeq.getObjectAt(2));
    private AlgorithmIdentifier signatureAlgorithm = AlgorithmIdentifier.getInstance(this.spkacSeq.getObjectAt(1));
    private ASN1Sequence spkacSeq;

    private static ASN1Sequence toDERSequence(byte[] bArr) {
        try {
            return (ASN1Sequence) new ASN1InputStream((InputStream) new ByteArrayInputStream(bArr)).readObject();
        } catch (Exception unused) {
            throw new IllegalArgumentException("badly encoded request");
        }
    }

    public SignedPublicKeyAndChallenge(byte[] bArr) {
        this.spkacSeq = toDERSequence(bArr);
    }

    public DERObject toASN1Object() {
        return this.spkacSeq;
    }

    public PublicKeyAndChallenge getPublicKeyAndChallenge() {
        return this.pkac;
    }

    public boolean verify() throws NoSuchAlgorithmException, SignatureException, NoSuchProviderException, InvalidKeyException {
        return verify((String) null);
    }

    public boolean verify(String str) throws NoSuchAlgorithmException, SignatureException, NoSuchProviderException, InvalidKeyException {
        Signature signature2;
        if (str == null) {
            signature2 = Signature.getInstance(this.signatureAlgorithm.getObjectId().getId());
        } else {
            signature2 = Signature.getInstance(this.signatureAlgorithm.getObjectId().getId(), str);
        }
        signature2.initVerify(getPublicKey(str));
        signature2.update(new DERBitString((DEREncodable) this.pkac).getBytes());
        return signature2.verify(this.signature.getBytes());
    }

    public PublicKey getPublicKey(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.pkac.getSubjectPublicKeyInfo();
        try {
            return KeyFactory.getInstance(subjectPublicKeyInfo.getAlgorithmId().getObjectId().getId(), str).generatePublic(new X509EncodedKeySpec(new DERBitString((DEREncodable) subjectPublicKeyInfo).getBytes()));
        } catch (InvalidKeySpecException unused) {
            throw new InvalidKeyException("error encoding public key");
        }
    }
}
