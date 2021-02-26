package repack.org.bouncycastle.operator.p071bc;

import repack.org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import repack.org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import repack.org.bouncycastle.crypto.Digest;
import repack.org.bouncycastle.crypto.digests.MD4Digest;
import repack.org.bouncycastle.crypto.digests.MD5Digest;
import repack.org.bouncycastle.crypto.digests.SHA1Digest;
import repack.org.bouncycastle.crypto.digests.SHA224Digest;
import repack.org.bouncycastle.crypto.digests.SHA256Digest;
import repack.org.bouncycastle.crypto.digests.SHA384Digest;
import repack.org.bouncycastle.operator.OperatorCreationException;

/* renamed from: repack.org.bouncycastle.operator.bc.BcUtil */
class BcUtil {
    BcUtil() {
    }

    static Digest createDigest(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
        if (algorithmIdentifier.getAlgorithm().equals(OIWObjectIdentifiers.idSHA1)) {
            return new SHA1Digest();
        }
        if (algorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha224)) {
            return new SHA224Digest();
        }
        if (algorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha256)) {
            return new SHA256Digest();
        }
        if (algorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha384)) {
            return new SHA384Digest();
        }
        if (algorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_sha512)) {
            return new SHA384Digest();
        }
        if (algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.md5)) {
            return new MD5Digest();
        }
        if (algorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.md4)) {
            return new MD4Digest();
        }
        throw new OperatorCreationException("cannot recognise digest");
    }
}
