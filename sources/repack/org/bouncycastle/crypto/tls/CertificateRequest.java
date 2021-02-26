package repack.org.bouncycastle.crypto.tls;

import java.util.Vector;

public class CertificateRequest {
    private Vector certificateAuthorities;
    private short[] certificateTypes;

    public CertificateRequest(short[] sArr, Vector vector) {
        this.certificateTypes = sArr;
        this.certificateAuthorities = vector;
    }

    public short[] getCertificateTypes() {
        return this.certificateTypes;
    }

    public Vector getCertificateAuthorities() {
        return this.certificateAuthorities;
    }
}
