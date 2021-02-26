package repack.org.bouncycastle.cert;

import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.DERBitString;
import repack.org.bouncycastle.asn1.DERGeneralizedTime;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.AttributeCertificate;
import repack.org.bouncycastle.asn1.x509.AttributeCertificateInfo;
import repack.org.bouncycastle.asn1.x509.CertificateList;
import repack.org.bouncycastle.asn1.x509.TBSCertList;
import repack.org.bouncycastle.asn1.x509.TBSCertificateStructure;
import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.operator.ContentSigner;

class CertUtils {
    private static List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
    private static Set EMPTY_SET = Collections.unmodifiableSet(new HashSet());

    CertUtils() {
    }

    static X509CertificateHolder generateFullCert(ContentSigner contentSigner, TBSCertificateStructure tBSCertificateStructure) {
        try {
            return new X509CertificateHolder(generateStructure(tBSCertificateStructure, contentSigner.getAlgorithmIdentifier(), generateSig(contentSigner, tBSCertificateStructure)));
        } catch (IOException unused) {
            throw new IllegalStateException("cannot produce certificate signature");
        }
    }

    static X509AttributeCertificateHolder generateFullAttrCert(ContentSigner contentSigner, AttributeCertificateInfo attributeCertificateInfo) {
        try {
            return new X509AttributeCertificateHolder(generateAttrStructure(attributeCertificateInfo, contentSigner.getAlgorithmIdentifier(), generateSig(contentSigner, attributeCertificateInfo)));
        } catch (IOException unused) {
            throw new IllegalStateException("cannot produce attribute certificate signature");
        }
    }

    static X509CRLHolder generateFullCRL(ContentSigner contentSigner, TBSCertList tBSCertList) {
        try {
            return new X509CRLHolder(generateCRLStructure(tBSCertList, contentSigner.getAlgorithmIdentifier(), generateSig(contentSigner, tBSCertList)));
        } catch (IOException unused) {
            throw new IllegalStateException("cannot produce certificate signature");
        }
    }

    private static byte[] generateSig(ContentSigner contentSigner, ASN1Encodable aSN1Encodable) throws IOException {
        OutputStream outputStream = contentSigner.getOutputStream();
        outputStream.write(aSN1Encodable.getDEREncoded());
        outputStream.close();
        return contentSigner.getSignature();
    }

    private static X509CertificateStructure generateStructure(TBSCertificateStructure tBSCertificateStructure, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(tBSCertificateStructure);
        aSN1EncodableVector.add(algorithmIdentifier);
        aSN1EncodableVector.add(new DERBitString(bArr));
        return X509CertificateStructure.getInstance(new DERSequence(aSN1EncodableVector));
    }

    private static AttributeCertificate generateAttrStructure(AttributeCertificateInfo attributeCertificateInfo, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(attributeCertificateInfo);
        aSN1EncodableVector.add(algorithmIdentifier);
        aSN1EncodableVector.add(new DERBitString(bArr));
        return AttributeCertificate.getInstance(new DERSequence(aSN1EncodableVector));
    }

    private static CertificateList generateCRLStructure(TBSCertList tBSCertList, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(tBSCertList);
        aSN1EncodableVector.add(algorithmIdentifier);
        aSN1EncodableVector.add(new DERBitString(bArr));
        return CertificateList.getInstance(new DERSequence(aSN1EncodableVector));
    }

    static Set getCriticalExtensionOIDs(X509Extensions x509Extensions) {
        if (x509Extensions == null) {
            return EMPTY_SET;
        }
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(x509Extensions.getCriticalExtensionOIDs())));
    }

    static Set getNonCriticalExtensionOIDs(X509Extensions x509Extensions) {
        if (x509Extensions == null) {
            return EMPTY_SET;
        }
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(x509Extensions.getNonCriticalExtensionOIDs())));
    }

    static List getExtensionOIDs(X509Extensions x509Extensions) {
        if (x509Extensions == null) {
            return EMPTY_LIST;
        }
        return Collections.unmodifiableList(Arrays.asList(x509Extensions.getExtensionOIDs()));
    }

    static DERBitString booleanToBitString(boolean[] zArr) {
        byte[] bArr = new byte[((zArr.length + 7) / 8)];
        for (int i = 0; i != zArr.length; i++) {
            int i2 = i / 8;
            bArr[i2] = (byte) (bArr[i2] | (zArr[i] ? 1 << (7 - (i % 8)) : 0));
        }
        int length = zArr.length % 8;
        if (length == 0) {
            return new DERBitString(bArr);
        }
        return new DERBitString(bArr, 8 - length);
    }

    static boolean[] bitStringToBoolean(DERBitString dERBitString) {
        if (dERBitString == null) {
            return null;
        }
        byte[] bytes = dERBitString.getBytes();
        boolean[] zArr = new boolean[((bytes.length * 8) - dERBitString.getPadBits())];
        for (int i = 0; i != zArr.length; i++) {
            zArr[i] = (bytes[i / 8] & (128 >>> (i % 8))) != 0;
        }
        return zArr;
    }

    static Date recoverDate(DERGeneralizedTime dERGeneralizedTime) {
        try {
            return dERGeneralizedTime.getDate();
        } catch (ParseException e) {
            throw new IllegalStateException("unable to recover date: " + e.getMessage());
        }
    }
}
