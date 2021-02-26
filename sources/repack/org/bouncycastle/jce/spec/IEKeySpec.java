package repack.org.bouncycastle.jce.spec;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import repack.org.bouncycastle.jce.interfaces.IESKey;

public class IEKeySpec implements KeySpec, IESKey {
    private PrivateKey privKey;
    private PublicKey pubKey;

    public String getAlgorithm() {
        return "IES";
    }

    public byte[] getEncoded() {
        return null;
    }

    public String getFormat() {
        return null;
    }

    public IEKeySpec(PrivateKey privateKey, PublicKey publicKey) {
        this.privKey = privateKey;
        this.pubKey = publicKey;
    }

    public PublicKey getPublic() {
        return this.pubKey;
    }

    public PrivateKey getPrivate() {
        return this.privKey;
    }
}
