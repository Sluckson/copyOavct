package repack.org.bouncycastle.cert;

import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x500.X500Name;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.GeneralNames;
import repack.org.bouncycastle.asn1.x509.Holder;
import repack.org.bouncycastle.asn1.x509.IssuerSerial;
import repack.org.bouncycastle.asn1.x509.ObjectDigestInfo;
import repack.org.bouncycastle.operator.DigestCalculator;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.util.Arrays;
import repack.org.bouncycastle.util.Selector;

public class AttributeCertificateHolder implements Selector {
    private static DigestCalculatorProvider digestCalculatorProvider;
    final Holder holder;

    AttributeCertificateHolder(ASN1Sequence aSN1Sequence) {
        this.holder = Holder.getInstance(aSN1Sequence);
    }

    public AttributeCertificateHolder(X500Name x500Name, BigInteger bigInteger) {
        this.holder = new Holder(new IssuerSerial(new GeneralNames((ASN1Sequence) new DERSequence((DEREncodable) new GeneralName(x500Name))), new DERInteger(bigInteger)));
    }

    public AttributeCertificateHolder(X509CertificateHolder x509CertificateHolder) {
        this.holder = new Holder(new IssuerSerial(generateGeneralNames(x509CertificateHolder.getIssuer()), new DERInteger(x509CertificateHolder.getSerialNumber())));
    }

    public AttributeCertificateHolder(X500Name x500Name) {
        this.holder = new Holder(generateGeneralNames(x500Name));
    }

    public AttributeCertificateHolder(int i, String str, String str2, byte[] bArr) {
        this.holder = new Holder(new ObjectDigestInfo(i, str2, new AlgorithmIdentifier(str), Arrays.clone(bArr)));
    }

    public int getDigestedObjectType() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getDigestedObjectType().getValue().intValue();
        }
        return -1;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getDigestAlgorithm();
        }
        return null;
    }

    public byte[] getObjectDigest() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getObjectDigest().getBytes();
        }
        return null;
    }

    public ASN1ObjectIdentifier getOtherObjectTypeID() {
        if (this.holder.getObjectDigestInfo() == null) {
            return null;
        }
        new ASN1ObjectIdentifier(this.holder.getObjectDigestInfo().getOtherObjectTypeID().getId());
        return null;
    }

    private GeneralNames generateGeneralNames(X500Name x500Name) {
        return new GeneralNames((ASN1Sequence) new DERSequence((DEREncodable) new GeneralName(x500Name)));
    }

    private boolean matchesDN(X500Name x500Name, GeneralNames generalNames) {
        GeneralName[] names = generalNames.getNames();
        for (int i = 0; i != names.length; i++) {
            GeneralName generalName = names[i];
            if (generalName.getTagNo() == 4 && X500Name.getInstance(generalName.getName()).equals(x500Name)) {
                return true;
            }
        }
        return false;
    }

    private X500Name[] getPrincipals(GeneralName[] generalNameArr) {
        ArrayList arrayList = new ArrayList(generalNameArr.length);
        for (int i = 0; i != generalNameArr.length; i++) {
            if (generalNameArr[i].getTagNo() == 4) {
                arrayList.add(X500Name.getInstance(generalNameArr[i].getName()));
            }
        }
        return (X500Name[]) arrayList.toArray(new X500Name[arrayList.size()]);
    }

    public X500Name[] getEntityNames() {
        if (this.holder.getEntityName() != null) {
            return getPrincipals(this.holder.getEntityName().getNames());
        }
        return null;
    }

    public X500Name[] getIssuer() {
        if (this.holder.getBaseCertificateID() != null) {
            return getPrincipals(this.holder.getBaseCertificateID().getIssuer().getNames());
        }
        return null;
    }

    public BigInteger getSerialNumber() {
        if (this.holder.getBaseCertificateID() != null) {
            return this.holder.getBaseCertificateID().getSerial().getValue();
        }
        return null;
    }

    public Object clone() {
        return new AttributeCertificateHolder((ASN1Sequence) this.holder.toASN1Object());
    }

    public boolean match(Object obj) {
        if (!(obj instanceof X509CertificateHolder)) {
            return false;
        }
        X509CertificateHolder x509CertificateHolder = (X509CertificateHolder) obj;
        if (this.holder.getBaseCertificateID() != null) {
            if (!this.holder.getBaseCertificateID().getSerial().getValue().equals(x509CertificateHolder.getSerialNumber()) || !matchesDN(x509CertificateHolder.getIssuer(), this.holder.getBaseCertificateID().getIssuer())) {
                return false;
            }
            return true;
        } else if (this.holder.getEntityName() != null && matchesDN(x509CertificateHolder.getSubject(), this.holder.getEntityName())) {
            return true;
        } else {
            if (this.holder.getObjectDigestInfo() != null) {
                try {
                    DigestCalculator digestCalculator = digestCalculatorProvider.get(this.holder.getObjectDigestInfo().getDigestAlgorithm());
                    OutputStream outputStream = digestCalculator.getOutputStream();
                    int digestedObjectType = getDigestedObjectType();
                    if (digestedObjectType == 0) {
                        outputStream.write(x509CertificateHolder.getSubjectPublicKeyInfo().getEncoded());
                    } else if (digestedObjectType == 1) {
                        outputStream.write(x509CertificateHolder.getEncoded());
                    }
                    outputStream.close();
                    if (!Arrays.areEqual(digestCalculator.getDigest(), getObjectDigest())) {
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeCertificateHolder)) {
            return false;
        }
        return this.holder.equals(((AttributeCertificateHolder) obj).holder);
    }

    public int hashCode() {
        return this.holder.hashCode();
    }

    public static void setDigestCalculatorProvider(DigestCalculatorProvider digestCalculatorProvider2) {
        digestCalculatorProvider = digestCalculatorProvider2;
    }
}
