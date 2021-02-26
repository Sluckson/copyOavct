package repack.org.bouncycastle.tsp.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.DERIA5String;
import repack.org.bouncycastle.asn1.cms.AttributeTable;
import repack.org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import repack.org.bouncycastle.asn1.cms.ContentInfo;
import repack.org.bouncycastle.asn1.cms.Evidence;
import repack.org.bouncycastle.asn1.cms.TimeStampAndCRL;
import repack.org.bouncycastle.asn1.cms.TimeStampTokenEvidence;
import repack.org.bouncycastle.asn1.cms.TimeStampedData;
import repack.org.bouncycastle.cms.CMSException;
import repack.org.bouncycastle.operator.DigestCalculator;
import repack.org.bouncycastle.operator.DigestCalculatorProvider;
import repack.org.bouncycastle.operator.OperatorCreationException;
import repack.org.bouncycastle.tsp.TimeStampToken;

public class CMSTimeStampedData {
    private ContentInfo contentInfo;
    private TimeStampedData timeStampedData;
    private TimeStampDataUtil util;

    public CMSTimeStampedData(ContentInfo contentInfo2) {
        initialize(contentInfo2);
    }

    public CMSTimeStampedData(InputStream inputStream) throws IOException {
        try {
            initialize(ContentInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
        } catch (ClassCastException e) {
            throw new IOException("Malformed content: " + e);
        } catch (IllegalArgumentException e2) {
            throw new IOException("Malformed content: " + e2);
        }
    }

    public CMSTimeStampedData(byte[] bArr) throws IOException {
        this((InputStream) new ByteArrayInputStream(bArr));
    }

    private void initialize(ContentInfo contentInfo2) {
        this.contentInfo = contentInfo2;
        if (CMSObjectIdentifiers.timestampedData.equals(contentInfo2.getContentType())) {
            this.timeStampedData = TimeStampedData.getInstance(contentInfo2.getContent());
            this.util = new TimeStampDataUtil(this.timeStampedData);
            return;
        }
        throw new IllegalArgumentException("Malformed content - type must be " + CMSObjectIdentifiers.timestampedData.getId());
    }

    public byte[] calculateNextHash(DigestCalculator digestCalculator) throws CMSException {
        return this.util.calculateNextHash(digestCalculator);
    }

    public CMSTimeStampedData addTimeStamp(TimeStampToken timeStampToken) throws CMSException {
        TimeStampAndCRL[] timeStamps = this.util.getTimeStamps();
        TimeStampAndCRL[] timeStampAndCRLArr = new TimeStampAndCRL[(timeStamps.length + 1)];
        System.arraycopy(timeStamps, 0, timeStampAndCRLArr, 0, timeStamps.length);
        timeStampAndCRLArr[timeStamps.length] = new TimeStampAndCRL(timeStampToken.toCMSSignedData().getContentInfo());
        return new CMSTimeStampedData(new ContentInfo(CMSObjectIdentifiers.timestampedData, new TimeStampedData(this.timeStampedData.getDataUri(), this.timeStampedData.getMetaData(), this.timeStampedData.getContent(), new Evidence(new TimeStampTokenEvidence(timeStampAndCRLArr)))));
    }

    public byte[] getContent() {
        if (this.timeStampedData.getContent() != null) {
            return this.timeStampedData.getContent().getOctets();
        }
        return null;
    }

    public URI getDataUri() throws URISyntaxException {
        DERIA5String dataUri = this.timeStampedData.getDataUri();
        if (dataUri != null) {
            return new URI(dataUri.getString());
        }
        return null;
    }

    public String getFileName() {
        return this.util.getFileName();
    }

    public String getMediaType() {
        return this.util.getMediaType();
    }

    public AttributeTable getOtherMetaData() {
        return this.util.getOtherMetaData();
    }

    public TimeStampToken[] getTimeStampTokens() throws CMSException {
        return this.util.getTimeStampTokens();
    }

    public void initialiseMessageImprintDigestCalculator(DigestCalculator digestCalculator) throws CMSException {
        this.util.initialiseMessageImprintDigestCalculator(digestCalculator);
    }

    public DigestCalculator getMessageImprintDigestCalculator(DigestCalculatorProvider digestCalculatorProvider) throws OperatorCreationException {
        return this.util.getMessageImprintDigestCalculator(digestCalculatorProvider);
    }

    public void validate(DigestCalculatorProvider digestCalculatorProvider, byte[] bArr) throws ImprintDigestInvalidException, CMSException {
        this.util.validate(digestCalculatorProvider, bArr);
    }

    public void validate(DigestCalculatorProvider digestCalculatorProvider, byte[] bArr, TimeStampToken timeStampToken) throws ImprintDigestInvalidException, CMSException {
        this.util.validate(digestCalculatorProvider, bArr, timeStampToken);
    }

    public byte[] getEncoded() throws IOException {
        return this.contentInfo.getEncoded();
    }
}
