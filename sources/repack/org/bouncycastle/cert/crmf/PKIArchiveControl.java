package repack.org.bouncycastle.cert.crmf;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import repack.org.bouncycastle.asn1.cms.ContentInfo;
import repack.org.bouncycastle.asn1.cms.EnvelopedData;
import repack.org.bouncycastle.asn1.crmf.CRMFObjectIdentifiers;
import repack.org.bouncycastle.asn1.crmf.EncryptedKey;
import repack.org.bouncycastle.asn1.crmf.PKIArchiveOptions;
import repack.org.bouncycastle.cms.CMSEnvelopedData;

public class PKIArchiveControl implements Control {
    public static final int archiveRemGenPrivKey = 2;
    public static final int encryptedPrivKey = 0;
    public static final int keyGenParameters = 1;
    private static final ASN1ObjectIdentifier type = CRMFObjectIdentifiers.id_regCtrl_pkiArchiveOptions;
    private final PKIArchiveOptions pkiArchiveOptions;

    public PKIArchiveControl(PKIArchiveOptions pKIArchiveOptions) {
        this.pkiArchiveOptions = pKIArchiveOptions;
    }

    public ASN1ObjectIdentifier getType() {
        return type;
    }

    public ASN1Encodable getValue() {
        return this.pkiArchiveOptions;
    }

    public int getArchiveType() {
        return this.pkiArchiveOptions.getType();
    }

    public boolean isEnvelopedData() {
        return !EncryptedKey.getInstance(this.pkiArchiveOptions.getValue()).isEncryptedValue();
    }

    public CMSEnvelopedData getEnvelopedData() {
        return new CMSEnvelopedData(new ContentInfo(CMSObjectIdentifiers.envelopedData, EnvelopedData.getInstance(EncryptedKey.getInstance(this.pkiArchiveOptions.getValue()).getValue())));
    }
}
