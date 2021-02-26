package repack.org.bouncycastle.tsp;

import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.Date;
import repack.org.bouncycastle.asn1.tsp.Accuracy;
import repack.org.bouncycastle.asn1.tsp.TSTInfo;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.asn1.x509.GeneralName;

public class TimeStampTokenInfo {
    Date genTime;
    TSTInfo tstInfo;

    TimeStampTokenInfo(TSTInfo tSTInfo) throws TSPException, IOException {
        this.tstInfo = tSTInfo;
        try {
            this.genTime = tSTInfo.getGenTime().getDate();
        } catch (ParseException unused) {
            throw new TSPException("unable to parse genTime field");
        }
    }

    public boolean isOrdered() {
        return this.tstInfo.getOrdering().isTrue();
    }

    public Accuracy getAccuracy() {
        return this.tstInfo.getAccuracy();
    }

    public Date getGenTime() {
        return this.genTime;
    }

    public GenTimeAccuracy getGenTimeAccuracy() {
        if (getAccuracy() != null) {
            return new GenTimeAccuracy(getAccuracy());
        }
        return null;
    }

    public String getPolicy() {
        return this.tstInfo.getPolicy().getId();
    }

    public BigInteger getSerialNumber() {
        return this.tstInfo.getSerialNumber().getValue();
    }

    public GeneralName getTsa() {
        return this.tstInfo.getTsa();
    }

    public BigInteger getNonce() {
        if (this.tstInfo.getNonce() != null) {
            return this.tstInfo.getNonce().getValue();
        }
        return null;
    }

    public AlgorithmIdentifier getHashAlgorithm() {
        return this.tstInfo.getMessageImprint().getHashAlgorithm();
    }

    public String getMessageImprintAlgOID() {
        return this.tstInfo.getMessageImprint().getHashAlgorithm().getObjectId().getId();
    }

    public byte[] getMessageImprintDigest() {
        return this.tstInfo.getMessageImprint().getHashedMessage();
    }

    public byte[] getEncoded() throws IOException {
        return this.tstInfo.getEncoded();
    }

    public TSTInfo toTSTInfo() {
        return this.tstInfo;
    }
}
