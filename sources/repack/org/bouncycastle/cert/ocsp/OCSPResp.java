package repack.org.bouncycastle.cert.ocsp;

import java.io.IOException;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ocsp.BasicOCSPResponse;
import repack.org.bouncycastle.asn1.ocsp.OCSPObjectIdentifiers;
import repack.org.bouncycastle.asn1.ocsp.OCSPResponse;
import repack.org.bouncycastle.asn1.ocsp.ResponseBytes;
import repack.org.bouncycastle.cert.CertIOException;

public class OCSPResp {
    private OCSPResponse resp;

    public OCSPResp(OCSPResponse oCSPResponse) {
        this.resp = oCSPResponse;
    }

    public OCSPResp(byte[] bArr) throws IOException {
        this(new ASN1InputStream(bArr));
    }

    private OCSPResp(ASN1InputStream aSN1InputStream) throws IOException {
        try {
            this.resp = OCSPResponse.getInstance(aSN1InputStream.readObject());
        } catch (IllegalArgumentException e) {
            throw new CertIOException("malformed response: " + e.getMessage(), e);
        } catch (ClassCastException e2) {
            throw new CertIOException("malformed response: " + e2.getMessage(), e2);
        }
    }

    public int getStatus() {
        return this.resp.getResponseStatus().getValue().intValue();
    }

    public Object getResponseObject() throws OCSPException {
        ResponseBytes responseBytes = this.resp.getResponseBytes();
        if (responseBytes == null) {
            return null;
        }
        if (!responseBytes.getResponseType().equals(OCSPObjectIdentifiers.id_pkix_ocsp_basic)) {
            return responseBytes.getResponse();
        }
        try {
            return new BasicOCSPResp(BasicOCSPResponse.getInstance(ASN1Object.fromByteArray(responseBytes.getResponse().getOctets())));
        } catch (Exception e) {
            throw new OCSPException("problem decoding object: " + e, e);
        }
    }

    public byte[] getEncoded() throws IOException {
        return this.resp.getEncoded();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OCSPResp)) {
            return false;
        }
        return this.resp.equals(((OCSPResp) obj).resp);
    }

    public int hashCode() {
        return this.resp.hashCode();
    }
}
