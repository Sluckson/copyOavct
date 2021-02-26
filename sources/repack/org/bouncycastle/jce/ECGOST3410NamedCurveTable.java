package repack.org.bouncycastle.jce;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import repack.org.bouncycastle.crypto.params.ECDomainParameters;
import repack.org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;

public class ECGOST3410NamedCurveTable {
    public static ECNamedCurveParameterSpec getParameterSpec(String str) {
        ECDomainParameters byName = ECGOST3410NamedCurves.getByName(str);
        if (byName == null) {
            try {
                byName = ECGOST3410NamedCurves.getByOID(new DERObjectIdentifier(str));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (byName == null) {
            return null;
        }
        return new ECNamedCurveParameterSpec(str, byName.getCurve(), byName.getG(), byName.getN(), byName.getH(), byName.getSeed());
    }

    public static Enumeration getNames() {
        return ECGOST3410NamedCurves.getNames();
    }
}
