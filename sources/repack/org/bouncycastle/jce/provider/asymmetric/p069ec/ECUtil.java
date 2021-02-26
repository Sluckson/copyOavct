package repack.org.bouncycastle.jce.provider.asymmetric.p069ec;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import repack.org.bouncycastle.asn1.nist.NISTNamedCurves;
import repack.org.bouncycastle.asn1.p065x9.X962NamedCurves;
import repack.org.bouncycastle.asn1.p065x9.X9ECParameters;
import repack.org.bouncycastle.asn1.sec.SECNamedCurves;
import repack.org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;
import repack.org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import repack.org.bouncycastle.crypto.params.ECDomainParameters;
import repack.org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import repack.org.bouncycastle.crypto.params.ECPublicKeyParameters;
import repack.org.bouncycastle.jce.interfaces.ECPrivateKey;
import repack.org.bouncycastle.jce.interfaces.ECPublicKey;
import repack.org.bouncycastle.jce.provider.JCEECPublicKey;
import repack.org.bouncycastle.jce.provider.ProviderUtil;
import repack.org.bouncycastle.jce.spec.ECParameterSpec;

/* renamed from: repack.org.bouncycastle.jce.provider.asymmetric.ec.ECUtil */
public class ECUtil {
    static int[] convertMidTerms(int[] iArr) {
        int[] iArr2 = new int[3];
        if (iArr.length == 1) {
            iArr2[0] = iArr[0];
        } else if (iArr.length != 3) {
            throw new IllegalArgumentException("Only Trinomials and pentanomials supported");
        } else if (iArr[0] < iArr[1] && iArr[0] < iArr[2]) {
            iArr2[0] = iArr[0];
            if (iArr[1] < iArr[2]) {
                iArr2[1] = iArr[1];
                iArr2[2] = iArr[2];
            } else {
                iArr2[1] = iArr[2];
                iArr2[2] = iArr[1];
            }
        } else if (iArr[1] < iArr[2]) {
            iArr2[0] = iArr[1];
            if (iArr[0] < iArr[2]) {
                iArr2[1] = iArr[0];
                iArr2[2] = iArr[2];
            } else {
                iArr2[1] = iArr[2];
                iArr2[2] = iArr[0];
            }
        } else {
            iArr2[0] = iArr[2];
            if (iArr[0] < iArr[1]) {
                iArr2[1] = iArr[0];
                iArr2[2] = iArr[1];
            } else {
                iArr2[1] = iArr[1];
                iArr2[2] = iArr[0];
            }
        }
        return iArr2;
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof ECPublicKey) {
            ECPublicKey eCPublicKey = (ECPublicKey) publicKey;
            ECParameterSpec parameters = eCPublicKey.getParameters();
            if (parameters != null) {
                return new ECPublicKeyParameters(eCPublicKey.getQ(), new ECDomainParameters(parameters.getCurve(), parameters.getG(), parameters.getN(), parameters.getH(), parameters.getSeed()));
            }
            ECParameterSpec ecImplicitlyCa = ProviderUtil.getEcImplicitlyCa();
            return new ECPublicKeyParameters(((JCEECPublicKey) eCPublicKey).engineGetQ(), new ECDomainParameters(ecImplicitlyCa.getCurve(), ecImplicitlyCa.getG(), ecImplicitlyCa.getN(), ecImplicitlyCa.getH(), ecImplicitlyCa.getSeed()));
        }
        throw new InvalidKeyException("cannot identify EC public key.");
    }

    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof ECPrivateKey) {
            ECPrivateKey eCPrivateKey = (ECPrivateKey) privateKey;
            ECParameterSpec parameters = eCPrivateKey.getParameters();
            if (parameters == null) {
                parameters = ProviderUtil.getEcImplicitlyCa();
            }
            return new ECPrivateKeyParameters(eCPrivateKey.getD(), new ECDomainParameters(parameters.getCurve(), parameters.getG(), parameters.getN(), parameters.getH(), parameters.getSeed()));
        }
        throw new InvalidKeyException("can't identify EC private key.");
    }

    public static DERObjectIdentifier getNamedCurveOid(String str) {
        DERObjectIdentifier oid = X962NamedCurves.getOID(str);
        if (oid != null) {
            return oid;
        }
        DERObjectIdentifier oid2 = SECNamedCurves.getOID(str);
        if (oid2 == null) {
            oid2 = NISTNamedCurves.getOID(str);
        }
        if (oid2 == null) {
            oid2 = TeleTrusTNamedCurves.getOID(str);
        }
        return oid2 == null ? ECGOST3410NamedCurves.getOID(str) : oid2;
    }

    public static X9ECParameters getNamedCurveByOid(DERObjectIdentifier dERObjectIdentifier) {
        X9ECParameters byOID = X962NamedCurves.getByOID(dERObjectIdentifier);
        if (byOID != null) {
            return byOID;
        }
        X9ECParameters byOID2 = SECNamedCurves.getByOID(dERObjectIdentifier);
        if (byOID2 == null) {
            byOID2 = NISTNamedCurves.getByOID(dERObjectIdentifier);
        }
        return byOID2 == null ? TeleTrusTNamedCurves.getByOID(dERObjectIdentifier) : byOID2;
    }

    public static String getCurveName(DERObjectIdentifier dERObjectIdentifier) {
        String name = X962NamedCurves.getName(dERObjectIdentifier);
        if (name != null) {
            return name;
        }
        String name2 = SECNamedCurves.getName(dERObjectIdentifier);
        if (name2 == null) {
            name2 = NISTNamedCurves.getName(dERObjectIdentifier);
        }
        return name2 == null ? TeleTrusTNamedCurves.getName(dERObjectIdentifier) : name2;
    }
}
