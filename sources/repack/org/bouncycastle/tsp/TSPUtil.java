package repack.org.bouncycastle.tsp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.cms.Attribute;
import repack.org.bouncycastle.asn1.cms.AttributeTable;
import repack.org.bouncycastle.asn1.cms.ContentInfo;
import repack.org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import repack.org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import repack.org.bouncycastle.asn1.x509.KeyPurposeId;
import repack.org.bouncycastle.asn1.x509.X509Extension;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.cms.SignerInformation;
import repack.org.bouncycastle.operator.DigestCalculator;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.util.Arrays;

public class TSPUtil {
    private static List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
    private static Set EMPTY_SET = Collections.unmodifiableSet(new HashSet());
    private static final Map digestLengths = new HashMap();
    private static final Map digestNames = new HashMap();

    static {
        digestLengths.put(PKCSObjectIdentifiers.md5.getId(), new Integer(16));
        digestLengths.put(OIWObjectIdentifiers.idSHA1.getId(), new Integer(20));
        digestLengths.put(NISTObjectIdentifiers.id_sha224.getId(), new Integer(28));
        digestLengths.put(NISTObjectIdentifiers.id_sha256.getId(), new Integer(32));
        digestLengths.put(NISTObjectIdentifiers.id_sha384.getId(), new Integer(48));
        digestLengths.put(NISTObjectIdentifiers.id_sha512.getId(), new Integer(64));
        digestLengths.put(TeleTrusTObjectIdentifiers.ripemd128.getId(), new Integer(16));
        digestLengths.put(TeleTrusTObjectIdentifiers.ripemd160.getId(), new Integer(20));
        digestLengths.put(TeleTrusTObjectIdentifiers.ripemd256.getId(), new Integer(32));
        digestLengths.put(CryptoProObjectIdentifiers.gostR3411.getId(), new Integer(32));
        digestNames.put(PKCSObjectIdentifiers.md5.getId(), "MD5");
        digestNames.put(OIWObjectIdentifiers.idSHA1.getId(), "SHA1");
        digestNames.put(NISTObjectIdentifiers.id_sha224.getId(), "SHA224");
        digestNames.put(NISTObjectIdentifiers.id_sha256.getId(), "SHA256");
        digestNames.put(NISTObjectIdentifiers.id_sha384.getId(), "SHA384");
        digestNames.put(NISTObjectIdentifiers.id_sha512.getId(), "SHA512");
        digestNames.put(PKCSObjectIdentifiers.sha1WithRSAEncryption.getId(), "SHA1");
        digestNames.put(PKCSObjectIdentifiers.sha224WithRSAEncryption.getId(), "SHA224");
        digestNames.put(PKCSObjectIdentifiers.sha256WithRSAEncryption.getId(), "SHA256");
        digestNames.put(PKCSObjectIdentifiers.sha384WithRSAEncryption.getId(), "SHA384");
        digestNames.put(PKCSObjectIdentifiers.sha512WithRSAEncryption.getId(), "SHA512");
        digestNames.put(TeleTrusTObjectIdentifiers.ripemd128.getId(), "RIPEMD128");
        digestNames.put(TeleTrusTObjectIdentifiers.ripemd160.getId(), "RIPEMD160");
        digestNames.put(TeleTrusTObjectIdentifiers.ripemd256.getId(), "RIPEMD256");
        digestNames.put(CryptoProObjectIdentifiers.gostR3411.getId(), "GOST3411");
    }

    public static Collection getSignatureTimestamps(SignerInformation signerInformation, Provider provider) throws TSPValidationException {
        ArrayList arrayList = new ArrayList();
        AttributeTable unsignedAttributes = signerInformation.getUnsignedAttributes();
        if (unsignedAttributes != null) {
            ASN1EncodableVector all = unsignedAttributes.getAll(PKCSObjectIdentifiers.id_aa_signatureTimeStampToken);
            for (int i = 0; i < all.size(); i++) {
                ASN1Set attrValues = ((Attribute) all.get(i)).getAttrValues();
                int i2 = 0;
                while (i2 < attrValues.size()) {
                    try {
                        TimeStampToken timeStampToken = new TimeStampToken(ContentInfo.getInstance(attrValues.getObjectAt(i2).getDERObject()));
                        TimeStampTokenInfo timeStampInfo = timeStampToken.getTimeStampInfo();
                        if (Arrays.constantTimeAreEqual(createDigestInstance(timeStampInfo.getMessageImprintAlgOID(), provider).digest(signerInformation.getSignature()), timeStampInfo.getMessageImprintDigest())) {
                            arrayList.add(timeStampToken);
                            i2++;
                        } else {
                            throw new TSPValidationException("Incorrect digest in message imprint");
                        }
                    } catch (NoSuchAlgorithmException unused) {
                        throw new TSPValidationException("Unknown hash algorithm specified in timestamp");
                    } catch (Exception unused2) {
                        throw new TSPValidationException("Timestamp could not be parsed");
                    }
                }
            }
        }
        return arrayList;
    }

    public static Collection getSignatureTimestamps(SignerInformation signerInformation, DigestCalculatorProvider digestCalculatorProvider) throws TSPValidationException {
        ArrayList arrayList = new ArrayList();
        AttributeTable unsignedAttributes = signerInformation.getUnsignedAttributes();
        if (unsignedAttributes != null) {
            ASN1EncodableVector all = unsignedAttributes.getAll(PKCSObjectIdentifiers.id_aa_signatureTimeStampToken);
            for (int i = 0; i < all.size(); i++) {
                ASN1Set attrValues = ((Attribute) all.get(i)).getAttrValues();
                int i2 = 0;
                while (i2 < attrValues.size()) {
                    try {
                        TimeStampToken timeStampToken = new TimeStampToken(ContentInfo.getInstance(attrValues.getObjectAt(i2).getDERObject()));
                        TimeStampTokenInfo timeStampInfo = timeStampToken.getTimeStampInfo();
                        DigestCalculator digestCalculator = digestCalculatorProvider.get(timeStampInfo.getHashAlgorithm());
                        OutputStream outputStream = digestCalculator.getOutputStream();
                        outputStream.write(signerInformation.getSignature());
                        outputStream.close();
                        if (Arrays.constantTimeAreEqual(digestCalculator.getDigest(), timeStampInfo.getMessageImprintDigest())) {
                            arrayList.add(timeStampToken);
                            i2++;
                        } else {
                            throw new TSPValidationException("Incorrect digest in message imprint");
                        }
                    } catch (OperatorCreationException unused) {
                        throw new TSPValidationException("Unknown hash algorithm specified in timestamp");
                    } catch (Exception unused2) {
                        throw new TSPValidationException("Timestamp could not be parsed");
                    }
                }
            }
        }
        return arrayList;
    }

    public static void validateCertificate(X509Certificate x509Certificate) throws TSPValidationException {
        if (x509Certificate.getVersion() == 3) {
            byte[] extensionValue = x509Certificate.getExtensionValue(X509Extensions.ExtendedKeyUsage.getId());
            if (extensionValue == null) {
                throw new TSPValidationException("Certificate must have an ExtendedKeyUsage extension.");
            } else if (x509Certificate.getCriticalExtensionOIDs().contains(X509Extensions.ExtendedKeyUsage.getId())) {
                try {
                    ExtendedKeyUsage instance = ExtendedKeyUsage.getInstance(new ASN1InputStream((InputStream) new ByteArrayInputStream(((ASN1OctetString) new ASN1InputStream((InputStream) new ByteArrayInputStream(extensionValue)).readObject()).getOctets())).readObject());
                    if (!instance.hasKeyPurposeId(KeyPurposeId.id_kp_timeStamping) || instance.size() != 1) {
                        throw new TSPValidationException("ExtendedKeyUsage not solely time stamping.");
                    }
                } catch (IOException unused) {
                    throw new TSPValidationException("cannot process ExtendedKeyUsage extension");
                }
            } else {
                throw new TSPValidationException("Certificate must have an ExtendedKeyUsage extension marked as critical.");
            }
        } else {
            throw new IllegalArgumentException("Certificate must have an ExtendedKeyUsage extension.");
        }
    }

    public static void validateCertificate(X509CertificateHolder x509CertificateHolder) throws TSPValidationException {
        if (x509CertificateHolder.toASN1Structure().getVersion() == 3) {
            X509Extension extension = x509CertificateHolder.getExtension(X509Extension.extendedKeyUsage);
            if (extension == null) {
                throw new TSPValidationException("Certificate must have an ExtendedKeyUsage extension.");
            } else if (extension.isCritical()) {
                ExtendedKeyUsage instance = ExtendedKeyUsage.getInstance(X509Extension.convertValueToObject(extension));
                if (!instance.hasKeyPurposeId(KeyPurposeId.id_kp_timeStamping) || instance.size() != 1) {
                    throw new TSPValidationException("ExtendedKeyUsage not solely time stamping.");
                }
            } else {
                throw new TSPValidationException("Certificate must have an ExtendedKeyUsage extension marked as critical.");
            }
        } else {
            throw new IllegalArgumentException("Certificate must have an ExtendedKeyUsage extension.");
        }
    }

    static String getDigestAlgName(String str) {
        String str2 = (String) digestNames.get(str);
        return str2 != null ? str2 : str;
    }

    static int getDigestLength(String str) throws TSPException {
        Integer num = (Integer) digestLengths.get(str);
        if (num != null) {
            return num.intValue();
        }
        throw new TSPException("digest algorithm cannot be found.");
    }

    static MessageDigest createDigestInstance(String str, Provider provider) throws NoSuchAlgorithmException {
        String digestAlgName = getDigestAlgName(str);
        if (provider != null) {
            try {
                return MessageDigest.getInstance(digestAlgName, provider);
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return MessageDigest.getInstance(digestAlgName);
    }

    static Set getCriticalExtensionOIDs(X509Extensions x509Extensions) {
        if (x509Extensions == null) {
            return EMPTY_SET;
        }
        return Collections.unmodifiableSet(new HashSet(java.util.Arrays.asList(x509Extensions.getCriticalExtensionOIDs())));
    }

    static Set getNonCriticalExtensionOIDs(X509Extensions x509Extensions) {
        if (x509Extensions == null) {
            return EMPTY_SET;
        }
        return Collections.unmodifiableSet(new HashSet(java.util.Arrays.asList(x509Extensions.getNonCriticalExtensionOIDs())));
    }

    static List getExtensionOIDs(X509Extensions x509Extensions) {
        if (x509Extensions == null) {
            return EMPTY_LIST;
        }
        return Collections.unmodifiableList(java.util.Arrays.asList(x509Extensions.getExtensionOIDs()));
    }
}
