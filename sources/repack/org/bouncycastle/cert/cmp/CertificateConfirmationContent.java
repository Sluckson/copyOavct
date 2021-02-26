package repack.org.bouncycastle.cert.cmp;

import repack.org.bouncycastle.asn1.cmp.CertConfirmContent;
import repack.org.bouncycastle.asn1.cmp.CertStatus;
import repack.org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import repack.org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;

public class CertificateConfirmationContent {
    private CertConfirmContent content;
    private DigestAlgorithmIdentifierFinder digestAlgFinder;

    public CertificateConfirmationContent(CertConfirmContent certConfirmContent) {
        this(certConfirmContent, new DefaultDigestAlgorithmIdentifierFinder());
    }

    public CertificateConfirmationContent(CertConfirmContent certConfirmContent, DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) {
        this.digestAlgFinder = digestAlgorithmIdentifierFinder;
        this.content = certConfirmContent;
    }

    public CertConfirmContent toASN1Structure() {
        return this.content;
    }

    public CertificateStatus[] getStatusMessages() {
        CertStatus[] certStatusArray = this.content.toCertStatusArray();
        CertificateStatus[] certificateStatusArr = new CertificateStatus[certStatusArray.length];
        for (int i = 0; i != certificateStatusArr.length; i++) {
            certificateStatusArr[i] = new CertificateStatus(this.digestAlgFinder, certStatusArray[i]);
        }
        return certificateStatusArr;
    }
}
