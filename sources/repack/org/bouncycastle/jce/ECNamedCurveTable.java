package repack.org.bouncycastle.jce;

import java.util.Enumeration;
import java.util.Vector;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.nist.NISTNamedCurves;
import repack.org.bouncycastle.asn1.p065x9.X962NamedCurves;
import repack.org.bouncycastle.asn1.p065x9.X9ECParameters;
import repack.org.bouncycastle.asn1.sec.SECNamedCurves;
import repack.org.bouncycastle.asn1.teletrust.TeleTrusTNamedCurves;
import repack.org.bouncycastle.jce.spec.ECNamedCurveParameterSpec;

public class ECNamedCurveTable {
    public static ECNamedCurveParameterSpec getParameterSpec(String str) {
        X9ECParameters byName = X962NamedCurves.getByName(str);
        if (byName == null) {
            try {
                byName = X962NamedCurves.getByOID(new DERObjectIdentifier(str));
            } catch (IllegalArgumentException unused) {
            }
        }
        if (byName == null && (byName = SECNamedCurves.getByName(str)) == null) {
            try {
                byName = SECNamedCurves.getByOID(new DERObjectIdentifier(str));
            } catch (IllegalArgumentException unused2) {
            }
        }
        if (byName == null && (byName = TeleTrusTNamedCurves.getByName(str)) == null) {
            try {
                byName = TeleTrusTNamedCurves.getByOID(new DERObjectIdentifier(str));
            } catch (IllegalArgumentException unused3) {
            }
        }
        if (byName == null) {
            byName = NISTNamedCurves.getByName(str);
        }
        if (byName == null) {
            return null;
        }
        return new ECNamedCurveParameterSpec(str, byName.getCurve(), byName.getG(), byName.getN(), byName.getH(), byName.getSeed());
    }

    public static Enumeration getNames() {
        Vector vector = new Vector();
        addEnumeration(vector, X962NamedCurves.getNames());
        addEnumeration(vector, SECNamedCurves.getNames());
        addEnumeration(vector, NISTNamedCurves.getNames());
        addEnumeration(vector, TeleTrusTNamedCurves.getNames());
        return vector.elements();
    }

    private static void addEnumeration(Vector vector, Enumeration enumeration) {
        while (enumeration.hasMoreElements()) {
            vector.addElement(enumeration.nextElement());
        }
    }
}
