package repack.org.bouncycastle.jce.provider;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import repack.org.bouncycastle.asn1.ASN1Null;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERNull;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import repack.org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import repack.org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

class X509SignatureUtil {
    private static final ASN1Null derNull = new DERNull();

    X509SignatureUtil() {
    }

    static void setSignatureParameters(Signature signature, DEREncodable dEREncodable) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (dEREncodable != null) {
            derNull.equals(dEREncodable);
        }
    }

    static String getSignatureName(AlgorithmIdentifier algorithmIdentifier) {
        DEREncodable parameters = algorithmIdentifier.getParameters();
        if (parameters == null || derNull.equals(parameters) || !algorithmIdentifier.getObjectId().equals(PKCSObjectIdentifiers.id_RSASSA_PSS)) {
            return algorithmIdentifier.getObjectId().getId();
        }
        return String.valueOf(getDigestAlgName(RSASSAPSSparams.getInstance(parameters).getHashAlgorithm().getObjectId())) + "withRSAandMGF1";
    }

    private static String getDigestAlgName(DERObjectIdentifier dERObjectIdentifier) {
        if (PKCSObjectIdentifiers.md5.equals(dERObjectIdentifier)) {
            return "MD5";
        }
        if (OIWObjectIdentifiers.idSHA1.equals(dERObjectIdentifier)) {
            return "SHA1";
        }
        if (NISTObjectIdentifiers.id_sha224.equals(dERObjectIdentifier)) {
            return "SHA224";
        }
        if (NISTObjectIdentifiers.id_sha256.equals(dERObjectIdentifier)) {
            return "SHA256";
        }
        if (NISTObjectIdentifiers.id_sha384.equals(dERObjectIdentifier)) {
            return "SHA384";
        }
        if (NISTObjectIdentifiers.id_sha512.equals(dERObjectIdentifier)) {
            return "SHA512";
        }
        if (TeleTrusTObjectIdentifiers.ripemd128.equals(dERObjectIdentifier)) {
            return "RIPEMD128";
        }
        if (TeleTrusTObjectIdentifiers.ripemd160.equals(dERObjectIdentifier)) {
            return "RIPEMD160";
        }
        if (TeleTrusTObjectIdentifiers.ripemd256.equals(dERObjectIdentifier)) {
            return "RIPEMD256";
        }
        if (CryptoProObjectIdentifiers.gostR3411.equals(dERObjectIdentifier)) {
            return "GOST3411";
        }
        return dERObjectIdentifier.getId();
    }
}
