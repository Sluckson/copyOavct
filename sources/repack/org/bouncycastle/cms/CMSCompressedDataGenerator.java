package repack.org.bouncycastle.cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import repack.org.bouncycastle.asn1.BERConstructedOctetString;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import repack.org.bouncycastle.asn1.cms.CompressedData;
import repack.org.bouncycastle.asn1.cms.ContentInfo;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.operator.OutputCompressor;

public class CMSCompressedDataGenerator {
    public static final String ZLIB = "1.2.840.113549.1.9.16.3.8";

    public CMSCompressedData generate(CMSProcessable cMSProcessable, String str) throws CMSException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
            cMSProcessable.write(deflaterOutputStream);
            deflaterOutputStream.close();
            return new CMSCompressedData(new ContentInfo(CMSObjectIdentifiers.compressedData, new CompressedData(new AlgorithmIdentifier(new DERObjectIdentifier(str)), new ContentInfo(CMSObjectIdentifiers.data, new BERConstructedOctetString(byteArrayOutputStream.toByteArray())))));
        } catch (IOException e) {
            throw new CMSException("exception encoding data.", e);
        }
    }

    public CMSCompressedData generate(CMSTypedData cMSTypedData, OutputCompressor outputCompressor) throws CMSException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream outputStream = outputCompressor.getOutputStream(byteArrayOutputStream);
            cMSTypedData.write(outputStream);
            outputStream.close();
            return new CMSCompressedData(new ContentInfo(CMSObjectIdentifiers.compressedData, new CompressedData(outputCompressor.getAlgorithmIdentifier(), new ContentInfo(cMSTypedData.getContentType(), new BERConstructedOctetString(byteArrayOutputStream.toByteArray())))));
        } catch (IOException e) {
            throw new CMSException("exception encoding data.", e);
        }
    }
}
