package repack.org.bouncycastle.crypto.tls;

public class SecurityParameters {
    byte[] clientRandom = null;
    byte[] masterSecret = null;
    byte[] serverRandom = null;

    public byte[] getClientRandom() {
        return this.clientRandom;
    }

    public byte[] getServerRandom() {
        return this.serverRandom;
    }

    public byte[] getMasterSecret() {
        return this.masterSecret;
    }
}
