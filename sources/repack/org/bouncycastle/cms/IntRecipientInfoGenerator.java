package repack.org.bouncycastle.cms;

import java.security.GeneralSecurityException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import repack.org.bouncycastle.asn1.cms.RecipientInfo;

interface IntRecipientInfoGenerator {
    RecipientInfo generate(SecretKey secretKey, SecureRandom secureRandom, Provider provider) throws GeneralSecurityException;
}
