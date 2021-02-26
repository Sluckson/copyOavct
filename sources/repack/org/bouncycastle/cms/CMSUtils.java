package repack.org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CRLSelector;
import java.security.cert.CertSelector;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.BEROctetStringGenerator;
import repack.org.bouncycastle.asn1.BERSet;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.DERTaggedObject;
import repack.org.bouncycastle.asn1.cms.ContentInfo;
import repack.org.bouncycastle.asn1.cms.IssuerAndSerialNumber;
import repack.org.bouncycastle.asn1.x509.CertificateList;
import repack.org.bouncycastle.asn1.x509.TBSCertificateStructure;
import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;
import repack.org.bouncycastle.cert.X509AttributeCertificateHolder;
import repack.org.bouncycastle.cert.X509CRLHolder;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.util.Selector;
import repack.org.bouncycastle.util.Store;
import repack.org.bouncycastle.util.p072io.Streams;
import repack.org.bouncycastle.util.p072io.TeeInputStream;
import repack.org.bouncycastle.util.p072io.TeeOutputStream;

class CMSUtils {
    private static final Runtime RUNTIME = Runtime.getRuntime();

    CMSUtils() {
    }

    static int getMaximumMemory() {
        long maxMemory = RUNTIME.maxMemory();
        if (maxMemory > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) maxMemory;
    }

    static ContentInfo readContentInfo(byte[] bArr) throws CMSException {
        return readContentInfo(new ASN1InputStream(bArr));
    }

    static ContentInfo readContentInfo(InputStream inputStream) throws CMSException {
        return readContentInfo(new ASN1InputStream(inputStream, getMaximumMemory()));
    }

    static List getCertificatesFromStore(CertStore certStore) throws CertStoreException, CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<? extends Certificate> it = certStore.getCertificates((CertSelector) null).iterator();
            while (it.hasNext()) {
                arrayList.add(X509CertificateStructure.getInstance(ASN1Object.fromByteArray(((X509Certificate) it.next()).getEncoded())));
            }
            return arrayList;
        } catch (IllegalArgumentException e) {
            throw new CMSException("error processing certs", e);
        } catch (IOException e2) {
            throw new CMSException("error processing certs", e2);
        } catch (CertificateEncodingException e3) {
            throw new CMSException("error encoding certs", e3);
        }
    }

    static List getCertificatesFromStore(Store store) throws CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            for (X509CertificateHolder aSN1Structure : store.getMatches((Selector) null)) {
                arrayList.add(aSN1Structure.toASN1Structure());
            }
            return arrayList;
        } catch (ClassCastException e) {
            throw new CMSException("error processing certs", e);
        }
    }

    static List getAttributeCertificatesFromStore(Store store) throws CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            for (X509AttributeCertificateHolder aSN1Structure : store.getMatches((Selector) null)) {
                arrayList.add(new DERTaggedObject(false, 2, aSN1Structure.toASN1Structure()));
            }
            return arrayList;
        } catch (ClassCastException e) {
            throw new CMSException("error processing certs", e);
        }
    }

    static List getCRLsFromStore(CertStore certStore) throws CertStoreException, CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            Iterator<? extends CRL> it = certStore.getCRLs((CRLSelector) null).iterator();
            while (it.hasNext()) {
                arrayList.add(CertificateList.getInstance(ASN1Object.fromByteArray(((X509CRL) it.next()).getEncoded())));
            }
            return arrayList;
        } catch (IllegalArgumentException e) {
            throw new CMSException("error processing crls", e);
        } catch (IOException e2) {
            throw new CMSException("error processing crls", e2);
        } catch (CRLException e3) {
            throw new CMSException("error encoding crls", e3);
        }
    }

    static List getCRLsFromStore(Store store) throws CMSException {
        ArrayList arrayList = new ArrayList();
        try {
            for (X509CRLHolder aSN1Structure : store.getMatches((Selector) null)) {
                arrayList.add(aSN1Structure.toASN1Structure());
            }
            return arrayList;
        } catch (ClassCastException e) {
            throw new CMSException("error processing certs", e);
        }
    }

    static ASN1Set createBerSetFromList(List list) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            aSN1EncodableVector.add((DEREncodable) it.next());
        }
        return new BERSet(aSN1EncodableVector);
    }

    static ASN1Set createDerSetFromList(List list) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            aSN1EncodableVector.add((DEREncodable) it.next());
        }
        return new DERSet(aSN1EncodableVector);
    }

    static OutputStream createBEROctetOutputStream(OutputStream outputStream, int i, boolean z, int i2) throws IOException {
        BEROctetStringGenerator bEROctetStringGenerator = new BEROctetStringGenerator(outputStream, i, z);
        if (i2 != 0) {
            return bEROctetStringGenerator.getOctetOutputStream(new byte[i2]);
        }
        return bEROctetStringGenerator.getOctetOutputStream();
    }

    static TBSCertificateStructure getTBSCertificateStructure(X509Certificate x509Certificate) {
        try {
            return TBSCertificateStructure.getInstance(ASN1Object.fromByteArray(x509Certificate.getTBSCertificate()));
        } catch (Exception unused) {
            throw new IllegalArgumentException("can't extract TBS structure from this cert");
        }
    }

    static IssuerAndSerialNumber getIssuerAndSerialNumber(X509Certificate x509Certificate) {
        TBSCertificateStructure tBSCertificateStructure = getTBSCertificateStructure(x509Certificate);
        return new IssuerAndSerialNumber(tBSCertificateStructure.getIssuer(), tBSCertificateStructure.getSerialNumber().getValue());
    }

    private static ContentInfo readContentInfo(ASN1InputStream aSN1InputStream) throws CMSException {
        try {
            return ContentInfo.getInstance(aSN1InputStream.readObject());
        } catch (IOException e) {
            throw new CMSException("IOException reading content.", e);
        } catch (ClassCastException e2) {
            throw new CMSException("Malformed content.", e2);
        } catch (IllegalArgumentException e3) {
            throw new CMSException("Malformed content.", e3);
        }
    }

    public static byte[] streamToByteArray(InputStream inputStream) throws IOException {
        return Streams.readAll(inputStream);
    }

    public static byte[] streamToByteArray(InputStream inputStream, int i) throws IOException {
        return Streams.readAllLimited(inputStream, i);
    }

    public static Provider getProvider(String str) throws NoSuchProviderException {
        if (str == null) {
            return null;
        }
        Provider provider = Security.getProvider(str);
        if (provider != null) {
            return provider;
        }
        throw new NoSuchProviderException("provider " + str + " not found.");
    }

    static InputStream attachDigestsToInputStream(Collection collection, InputStream inputStream) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            inputStream = new TeeInputStream(inputStream, new DigOutputStream((MessageDigest) it.next()));
        }
        return inputStream;
    }

    static OutputStream attachDigestsToOutputStream(Collection collection, OutputStream outputStream) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            outputStream = getSafeTeeOutputStream(outputStream, new DigOutputStream((MessageDigest) it.next()));
        }
        return outputStream;
    }

    static OutputStream attachSignersToOutputStream(Collection collection, OutputStream outputStream) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            outputStream = getSafeTeeOutputStream(outputStream, ((SignerInfoGenerator) it.next()).getCalculatingOutputStream());
        }
        return outputStream;
    }

    static OutputStream getSafeOutputStream(OutputStream outputStream) {
        return outputStream == null ? new NullOutputStream() : outputStream;
    }

    static OutputStream getSafeTeeOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        if (outputStream == null) {
            return getSafeOutputStream(outputStream2);
        }
        if (outputStream2 == null) {
            return getSafeOutputStream(outputStream);
        }
        return new TeeOutputStream(outputStream, outputStream2);
    }
}
