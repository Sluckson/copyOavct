package repack.org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import repack.org.bouncycastle.asn1.cryptopro.GOST3410NamedParameters;
import repack.org.bouncycastle.asn1.cryptopro.GOST3410ParamSetParameters;
import repack.org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import repack.org.bouncycastle.jce.interfaces.GOST3410Params;

public class GOST3410ParameterSpec implements AlgorithmParameterSpec, GOST3410Params {
    private String digestParamSetOID;
    private String encryptionParamSetOID;
    private String keyParamSetOID;
    private GOST3410PublicKeyParameterSetSpec keyParameters;

    public GOST3410ParameterSpec(String str, String str2, String str3) {
        GOST3410ParamSetParameters gOST3410ParamSetParameters;
        try {
            gOST3410ParamSetParameters = GOST3410NamedParameters.getByOID(new DERObjectIdentifier(str));
        } catch (IllegalArgumentException unused) {
            DERObjectIdentifier oid = GOST3410NamedParameters.getOID(str);
            if (oid != null) {
                str = oid.getId();
                gOST3410ParamSetParameters = GOST3410NamedParameters.getByOID(oid);
            } else {
                gOST3410ParamSetParameters = null;
            }
        }
        if (gOST3410ParamSetParameters != null) {
            this.keyParameters = new GOST3410PublicKeyParameterSetSpec(gOST3410ParamSetParameters.getP(), gOST3410ParamSetParameters.getQ(), gOST3410ParamSetParameters.getA());
            this.keyParamSetOID = str;
            this.digestParamSetOID = str2;
            this.encryptionParamSetOID = str3;
            return;
        }
        throw new IllegalArgumentException("no key parameter set for passed in name/OID.");
    }

    public GOST3410ParameterSpec(String str, String str2) {
        this(str, str2, (String) null);
    }

    public GOST3410ParameterSpec(String str) {
        this(str, CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet.getId(), (String) null);
    }

    public GOST3410ParameterSpec(GOST3410PublicKeyParameterSetSpec gOST3410PublicKeyParameterSetSpec) {
        this.keyParameters = gOST3410PublicKeyParameterSetSpec;
        this.digestParamSetOID = CryptoProObjectIdentifiers.gostR3411_94_CryptoProParamSet.getId();
        this.encryptionParamSetOID = null;
    }

    public String getPublicKeyParamSetOID() {
        return this.keyParamSetOID;
    }

    public GOST3410PublicKeyParameterSetSpec getPublicKeyParameters() {
        return this.keyParameters;
    }

    public String getDigestParamSetOID() {
        return this.digestParamSetOID;
    }

    public String getEncryptionParamSetOID() {
        return this.encryptionParamSetOID;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GOST3410ParameterSpec) {
            GOST3410ParameterSpec gOST3410ParameterSpec = (GOST3410ParameterSpec) obj;
            if (this.keyParameters.equals(gOST3410ParameterSpec.keyParameters) && this.digestParamSetOID.equals(gOST3410ParameterSpec.digestParamSetOID)) {
                String str = this.encryptionParamSetOID;
                String str2 = gOST3410ParameterSpec.encryptionParamSetOID;
                if (str == str2) {
                    return true;
                }
                if (str == null || !str.equals(str2)) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.keyParameters.hashCode() ^ this.digestParamSetOID.hashCode();
        String str = this.encryptionParamSetOID;
        return hashCode ^ (str != null ? str.hashCode() : 0);
    }

    public static GOST3410ParameterSpec fromPublicKeyAlg(GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters) {
        if (gOST3410PublicKeyAlgParameters.getEncryptionParamSet() != null) {
            return new GOST3410ParameterSpec(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet().getId(), gOST3410PublicKeyAlgParameters.getDigestParamSet().getId(), gOST3410PublicKeyAlgParameters.getEncryptionParamSet().getId());
        }
        return new GOST3410ParameterSpec(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet().getId(), gOST3410PublicKeyAlgParameters.getDigestParamSet().getId());
    }
}
