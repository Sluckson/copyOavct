package repack.org.bouncycastle.cert.cmp;

import java.math.BigInteger;
import repack.org.bouncycastle.asn1.cmp.CertStatus;
import repack.org.bouncycastle.asn1.cmp.PKIStatusInfo;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.cert.X509CertificateHolder;
import repack.org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import repack.org.bouncycastle.operator.DigestCalculator;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.util.Arrays;

public class CertificateStatus {
    private CertStatus certStatus;
    private DigestAlgorithmIdentifierFinder digestAlgFinder;

    CertificateStatus(DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder, CertStatus certStatus2) {
        this.digestAlgFinder = digestAlgorithmIdentifierFinder;
        this.certStatus = certStatus2;
    }

    public PKIStatusInfo getStatusInfo() {
        return this.certStatus.getStatusInfo();
    }

    public BigInteger getCertRequestID() {
        return this.certStatus.getCertReqId().getValue();
    }

    public boolean isVerified(X509CertificateHolder x509CertificateHolder, DigestCalculatorProvider digestCalculatorProvider) throws CMPException {
        AlgorithmIdentifier find = this.digestAlgFinder.find(x509CertificateHolder.toASN1Structure().getSignatureAlgorithm());
        if (find != null) {
            try {
                DigestCalculator digestCalculator = digestCalculatorProvider.get(find);
                CMPUtil.derEncodeToStream(x509CertificateHolder.toASN1Structure(), digestCalculator.getOutputStream());
                return Arrays.areEqual(this.certStatus.getCertHash().getOctets(), digestCalculator.getDigest());
            } catch (OperatorCreationException e) {
                throw new CMPException("unable to create digester: " + e.getMessage(), e);
            }
        } else {
            throw new CMPException("cannot find algorithm for digest from signature");
        }
    }
}
