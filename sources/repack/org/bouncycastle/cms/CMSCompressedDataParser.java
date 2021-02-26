package repack.org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.InflaterInputStream;
import repack.org.bouncycastle.asn1.ASN1OctetStringParser;
import repack.org.bouncycastle.asn1.ASN1SequenceParser;
import repack.org.bouncycastle.asn1.cms.CompressedDataParser;
import repack.org.bouncycastle.asn1.cms.ContentInfoParser;
import repack.org.bouncycastle.operator.InputExpanderProvider;

public class CMSCompressedDataParser extends CMSContentInfoParser {
    public CMSCompressedDataParser(byte[] bArr) throws CMSException {
        this((InputStream) new ByteArrayInputStream(bArr));
    }

    public CMSCompressedDataParser(InputStream inputStream) throws CMSException {
        super(inputStream);
    }

    public CMSTypedStream getContent() throws CMSException {
        try {
            ContentInfoParser encapContentInfo = new CompressedDataParser((ASN1SequenceParser) this._contentInfo.getContent(16)).getEncapContentInfo();
            return new CMSTypedStream(encapContentInfo.getContentType().toString(), (InputStream) new InflaterInputStream(((ASN1OctetStringParser) encapContentInfo.getContent(4)).getOctetStream()));
        } catch (IOException e) {
            throw new CMSException("IOException reading compressed content.", e);
        }
    }

    public CMSTypedStream getContent(InputExpanderProvider inputExpanderProvider) throws CMSException {
        try {
            CompressedDataParser compressedDataParser = new CompressedDataParser((ASN1SequenceParser) this._contentInfo.getContent(16));
            ContentInfoParser encapContentInfo = compressedDataParser.getEncapContentInfo();
            return new CMSTypedStream(encapContentInfo.getContentType().getId(), inputExpanderProvider.get(compressedDataParser.getCompressionAlgorithmIdentifier()).getInputStream(((ASN1OctetStringParser) encapContentInfo.getContent(4)).getOctetStream()));
        } catch (IOException e) {
            throw new CMSException("IOException reading compressed content.", e);
        }
    }
}
