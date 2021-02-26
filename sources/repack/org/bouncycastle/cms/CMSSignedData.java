package repack.org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.cert.CertStore;
import java.security.cert.CertStoreException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1Set;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.BERSequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.cms.ContentInfo;
import repack.org.bouncycastle.asn1.cms.SignedData;
import repack.org.bouncycastle.asn1.cms.SignerInfo;
import repack.org.bouncycastle.asn1.x509.AttributeCertificate;
import repack.org.bouncycastle.asn1.x509.CertificateList;
import repack.org.bouncycastle.asn1.x509.X509CertificateStructure;
import repack.org.bouncycastle.cert.X509AttributeCertificateHolder;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.operator.DefaultSignatureAlgorithmIdentifierFinder;
import repack.org.bouncycastle.util.CollectionStore;
import repack.org.bouncycastle.util.Store;
import repack.org.bouncycastle.x509.NoSuchStoreException;
import repack.org.bouncycastle.x509.X509Store;

public class CMSSignedData {
    private static final CMSSignedHelper HELPER = CMSSignedHelper.INSTANCE;
    X509Store attributeStore;
    X509Store certificateStore;
    ContentInfo contentInfo;
    X509Store crlStore;
    private Map hashes;
    CMSProcessable signedContent;
    SignedData signedData;
    SignerInformationStore signerInfoStore;

    private CMSSignedData(CMSSignedData cMSSignedData) {
        this.signedData = cMSSignedData.signedData;
        this.contentInfo = cMSSignedData.contentInfo;
        this.signedContent = cMSSignedData.signedContent;
        this.signerInfoStore = cMSSignedData.signerInfoStore;
    }

    public CMSSignedData(byte[] bArr) throws CMSException {
        this(CMSUtils.readContentInfo(bArr));
    }

    public CMSSignedData(CMSProcessable cMSProcessable, byte[] bArr) throws CMSException {
        this(cMSProcessable, CMSUtils.readContentInfo(bArr));
    }

    public CMSSignedData(Map map, byte[] bArr) throws CMSException {
        this(map, CMSUtils.readContentInfo(bArr));
    }

    public CMSSignedData(CMSProcessable cMSProcessable, InputStream inputStream) throws CMSException {
        this(cMSProcessable, CMSUtils.readContentInfo((InputStream) new ASN1InputStream(inputStream)));
    }

    public CMSSignedData(InputStream inputStream) throws CMSException {
        this(CMSUtils.readContentInfo(inputStream));
    }

    public CMSSignedData(CMSProcessable cMSProcessable, ContentInfo contentInfo2) {
        this.signedContent = cMSProcessable;
        this.contentInfo = contentInfo2;
        this.signedData = SignedData.getInstance(this.contentInfo.getContent());
    }

    public CMSSignedData(Map map, ContentInfo contentInfo2) {
        this.hashes = map;
        this.contentInfo = contentInfo2;
        this.signedData = SignedData.getInstance(this.contentInfo.getContent());
    }

    public CMSSignedData(ContentInfo contentInfo2) {
        this.contentInfo = contentInfo2;
        this.signedData = SignedData.getInstance(this.contentInfo.getContent());
        if (this.signedData.getEncapContentInfo().getContent() != null) {
            this.signedContent = new CMSProcessableByteArray(((ASN1OctetString) this.signedData.getEncapContentInfo().getContent()).getOctets());
        } else {
            this.signedContent = null;
        }
    }

    public int getVersion() {
        return this.signedData.getVersion().getValue().intValue();
    }

    public SignerInformationStore getSignerInfos() {
        if (this.signerInfoStore == null) {
            ASN1Set signerInfos = this.signedData.getSignerInfos();
            ArrayList arrayList = new ArrayList();
            DefaultSignatureAlgorithmIdentifierFinder defaultSignatureAlgorithmIdentifierFinder = new DefaultSignatureAlgorithmIdentifierFinder();
            for (int i = 0; i != signerInfos.size(); i++) {
                SignerInfo instance = SignerInfo.getInstance(signerInfos.getObjectAt(i));
                ASN1ObjectIdentifier contentType = this.signedData.getEncapContentInfo().getContentType();
                Map map = this.hashes;
                if (map == null) {
                    arrayList.add(new SignerInformation(instance, contentType, this.signedContent, (IntDigestCalculator) null, defaultSignatureAlgorithmIdentifierFinder));
                } else {
                    arrayList.add(new SignerInformation(instance, contentType, (CMSProcessable) null, new BaseDigestCalculator((byte[]) map.get(instance.getDigestAlgorithm().getAlgorithm().getId())), defaultSignatureAlgorithmIdentifierFinder));
                }
            }
            this.signerInfoStore = new SignerInformationStore(arrayList);
        }
        return this.signerInfoStore;
    }

    public X509Store getAttributeCertificates(String str, String str2) throws NoSuchStoreException, NoSuchProviderException, CMSException {
        return getAttributeCertificates(str, CMSUtils.getProvider(str2));
    }

    public X509Store getAttributeCertificates(String str, Provider provider) throws NoSuchStoreException, CMSException {
        if (this.attributeStore == null) {
            this.attributeStore = HELPER.createAttributeStore(str, provider, this.signedData.getCertificates());
        }
        return this.attributeStore;
    }

    public X509Store getCertificates(String str, String str2) throws NoSuchStoreException, NoSuchProviderException, CMSException {
        return getCertificates(str, CMSUtils.getProvider(str2));
    }

    public X509Store getCertificates(String str, Provider provider) throws NoSuchStoreException, CMSException {
        if (this.certificateStore == null) {
            this.certificateStore = HELPER.createCertificateStore(str, provider, this.signedData.getCertificates());
        }
        return this.certificateStore;
    }

    public X509Store getCRLs(String str, String str2) throws NoSuchStoreException, NoSuchProviderException, CMSException {
        return getCRLs(str, CMSUtils.getProvider(str2));
    }

    public X509Store getCRLs(String str, Provider provider) throws NoSuchStoreException, CMSException {
        if (this.crlStore == null) {
            this.crlStore = HELPER.createCRLsStore(str, provider, this.signedData.getCRLs());
        }
        return this.crlStore;
    }

    public CertStore getCertificatesAndCRLs(String str, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, CMSException {
        return getCertificatesAndCRLs(str, CMSUtils.getProvider(str2));
    }

    public CertStore getCertificatesAndCRLs(String str, Provider provider) throws NoSuchAlgorithmException, CMSException {
        return HELPER.createCertStore(str, provider, this.signedData.getCertificates(), this.signedData.getCRLs());
    }

    public Store getCertificates() {
        ASN1Set certificates = this.signedData.getCertificates();
        if (certificates == null) {
            return new CollectionStore(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(certificates.size());
        Enumeration objects = certificates.getObjects();
        while (objects.hasMoreElements()) {
            DERObject dERObject = ((DEREncodable) objects.nextElement()).getDERObject();
            if (dERObject instanceof ASN1Sequence) {
                arrayList.add(new X509CertificateHolder(X509CertificateStructure.getInstance(dERObject)));
            }
        }
        return new CollectionStore(arrayList);
    }

    public Store getCRLs() {
        ASN1Set cRLs = this.signedData.getCRLs();
        if (cRLs == null) {
            return new CollectionStore(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(cRLs.size());
        Enumeration objects = cRLs.getObjects();
        while (objects.hasMoreElements()) {
            DERObject dERObject = ((DEREncodable) objects.nextElement()).getDERObject();
            if (dERObject instanceof ASN1Sequence) {
                arrayList.add(CertificateList.getInstance(dERObject));
            }
        }
        return new CollectionStore(arrayList);
    }

    public Store getAttributeCertificates() {
        ASN1Set certificates = this.signedData.getCertificates();
        if (certificates == null) {
            return new CollectionStore(new ArrayList());
        }
        ArrayList arrayList = new ArrayList(certificates.size());
        Enumeration objects = certificates.getObjects();
        while (objects.hasMoreElements()) {
            DERObject dERObject = ((DEREncodable) objects.nextElement()).getDERObject();
            if (dERObject instanceof ASN1TaggedObject) {
                arrayList.add(new X509AttributeCertificateHolder(AttributeCertificate.getInstance(((ASN1TaggedObject) dERObject).getObject())));
            }
        }
        return new CollectionStore(arrayList);
    }

    public String getSignedContentTypeOID() {
        return this.signedData.getEncapContentInfo().getContentType().getId();
    }

    public CMSProcessable getSignedContent() {
        return this.signedContent;
    }

    public ContentInfo getContentInfo() {
        return this.contentInfo;
    }

    public byte[] getEncoded() throws IOException {
        return this.contentInfo.getEncoded();
    }

    public static CMSSignedData replaceSigners(CMSSignedData cMSSignedData, SignerInformationStore signerInformationStore) {
        CMSSignedData cMSSignedData2 = new CMSSignedData(cMSSignedData);
        cMSSignedData2.signerInfoStore = signerInformationStore;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        for (SignerInformation signerInformation : signerInformationStore.getSigners()) {
            aSN1EncodableVector.add(CMSSignedHelper.INSTANCE.fixAlgID(signerInformation.getDigestAlgorithmID()));
            aSN1EncodableVector2.add(signerInformation.toSignerInfo());
        }
        DERSet dERSet = new DERSet(aSN1EncodableVector);
        DERSet dERSet2 = new DERSet(aSN1EncodableVector2);
        ASN1Sequence aSN1Sequence = (ASN1Sequence) cMSSignedData.signedData.getDERObject();
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        aSN1EncodableVector3.add(aSN1Sequence.getObjectAt(0));
        aSN1EncodableVector3.add(dERSet);
        for (int i = 2; i != aSN1Sequence.size() - 1; i++) {
            aSN1EncodableVector3.add(aSN1Sequence.getObjectAt(i));
        }
        aSN1EncodableVector3.add(dERSet2);
        cMSSignedData2.signedData = SignedData.getInstance(new BERSequence(aSN1EncodableVector3));
        cMSSignedData2.contentInfo = new ContentInfo(cMSSignedData2.contentInfo.getContentType(), cMSSignedData2.signedData);
        return cMSSignedData2;
    }

    public static CMSSignedData replaceCertificatesAndCRLs(CMSSignedData cMSSignedData, CertStore certStore) throws CMSException {
        CMSSignedData cMSSignedData2 = new CMSSignedData(cMSSignedData);
        try {
            ASN1Set createBerSetFromList = CMSUtils.createBerSetFromList(CMSUtils.getCertificatesFromStore(certStore));
            ASN1Set aSN1Set = createBerSetFromList.size() != 0 ? createBerSetFromList : null;
            try {
                ASN1Set createBerSetFromList2 = CMSUtils.createBerSetFromList(CMSUtils.getCRLsFromStore(certStore));
                cMSSignedData2.signedData = new SignedData(cMSSignedData.signedData.getDigestAlgorithms(), cMSSignedData.signedData.getEncapContentInfo(), aSN1Set, createBerSetFromList2.size() != 0 ? createBerSetFromList2 : null, cMSSignedData.signedData.getSignerInfos());
                cMSSignedData2.contentInfo = new ContentInfo(cMSSignedData2.contentInfo.getContentType(), cMSSignedData2.signedData);
                return cMSSignedData2;
            } catch (CertStoreException e) {
                throw new CMSException("error getting crls from certStore", e);
            }
        } catch (CertStoreException e2) {
            throw new CMSException("error getting certs from certStore", e2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static repack.org.bouncycastle.cms.CMSSignedData replaceCertificatesAndCRLs(repack.org.bouncycastle.cms.CMSSignedData r8, repack.org.bouncycastle.util.Store r9, repack.org.bouncycastle.util.Store r10, repack.org.bouncycastle.util.Store r11) throws repack.org.bouncycastle.cms.CMSException {
        /*
            repack.org.bouncycastle.cms.CMSSignedData r0 = new repack.org.bouncycastle.cms.CMSSignedData
            r0.<init>((repack.org.bouncycastle.cms.CMSSignedData) r8)
            r1 = 0
            if (r9 != 0) goto L_0x000a
            if (r10 == 0) goto L_0x002d
        L_0x000a:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            if (r9 == 0) goto L_0x0018
            java.util.List r9 = repack.org.bouncycastle.cms.CMSUtils.getCertificatesFromStore((repack.org.bouncycastle.util.Store) r9)
            r2.addAll(r9)
        L_0x0018:
            if (r10 == 0) goto L_0x0021
            java.util.List r9 = repack.org.bouncycastle.cms.CMSUtils.getAttributeCertificatesFromStore(r10)
            r2.addAll(r9)
        L_0x0021:
            repack.org.bouncycastle.asn1.ASN1Set r9 = repack.org.bouncycastle.cms.CMSUtils.createBerSetFromList(r2)
            int r10 = r9.size()
            if (r10 == 0) goto L_0x002d
            r5 = r9
            goto L_0x002e
        L_0x002d:
            r5 = r1
        L_0x002e:
            if (r11 == 0) goto L_0x0040
            java.util.List r9 = repack.org.bouncycastle.cms.CMSUtils.getCRLsFromStore((repack.org.bouncycastle.util.Store) r11)
            repack.org.bouncycastle.asn1.ASN1Set r9 = repack.org.bouncycastle.cms.CMSUtils.createBerSetFromList(r9)
            int r10 = r9.size()
            if (r10 == 0) goto L_0x0040
            r6 = r9
            goto L_0x0041
        L_0x0040:
            r6 = r1
        L_0x0041:
            repack.org.bouncycastle.asn1.cms.SignedData r9 = new repack.org.bouncycastle.asn1.cms.SignedData
            repack.org.bouncycastle.asn1.cms.SignedData r10 = r8.signedData
            repack.org.bouncycastle.asn1.ASN1Set r3 = r10.getDigestAlgorithms()
            repack.org.bouncycastle.asn1.cms.SignedData r10 = r8.signedData
            repack.org.bouncycastle.asn1.cms.ContentInfo r4 = r10.getEncapContentInfo()
            repack.org.bouncycastle.asn1.cms.SignedData r8 = r8.signedData
            repack.org.bouncycastle.asn1.ASN1Set r7 = r8.getSignerInfos()
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            r0.signedData = r9
            repack.org.bouncycastle.asn1.cms.ContentInfo r8 = new repack.org.bouncycastle.asn1.cms.ContentInfo
            repack.org.bouncycastle.asn1.cms.ContentInfo r9 = r0.contentInfo
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r9 = r9.getContentType()
            repack.org.bouncycastle.asn1.cms.SignedData r10 = r0.signedData
            r8.<init>(r9, r10)
            r0.contentInfo = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.cms.CMSSignedData.replaceCertificatesAndCRLs(repack.org.bouncycastle.cms.CMSSignedData, repack.org.bouncycastle.util.Store, repack.org.bouncycastle.util.Store, repack.org.bouncycastle.util.Store):repack.org.bouncycastle.cms.CMSSignedData");
    }
}
