package repack.org.bouncycastle.x509;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.security.auth.x500.X500Principal;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x509.AttCertIssuer;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.GeneralNames;
import repack.org.bouncycastle.asn1.x509.V2Form;
import repack.org.bouncycastle.asn1.x509.X509Name;
import repack.org.bouncycastle.jce.X509Principal;
import repack.org.bouncycastle.util.Selector;

public class AttributeCertificateIssuer implements CertSelector, Selector {
    final ASN1Encodable form;

    public AttributeCertificateIssuer(AttCertIssuer attCertIssuer) {
        this.form = attCertIssuer.getIssuer();
    }

    public AttributeCertificateIssuer(X500Principal x500Principal) throws IOException {
        this(new X509Principal(x500Principal.getEncoded()));
    }

    public AttributeCertificateIssuer(X509Principal x509Principal) {
        this.form = new V2Form(new GeneralNames((ASN1Sequence) new DERSequence((DEREncodable) new GeneralName((X509Name) x509Principal))));
    }

    private Object[] getNames() {
        GeneralNames generalNames;
        ASN1Encodable aSN1Encodable = this.form;
        if (aSN1Encodable instanceof V2Form) {
            generalNames = ((V2Form) aSN1Encodable).getIssuerName();
        } else {
            generalNames = (GeneralNames) aSN1Encodable;
        }
        GeneralName[] names = generalNames.getNames();
        ArrayList arrayList = new ArrayList(names.length);
        for (int i = 0; i != names.length; i++) {
            if (names[i].getTagNo() == 4) {
                try {
                    arrayList.add(new X500Principal(((ASN1Encodable) names[i].getName()).getEncoded()));
                } catch (IOException unused) {
                    throw new RuntimeException("badly formed Name object");
                }
            }
        }
        return arrayList.toArray(new Object[arrayList.size()]);
    }

    public Principal[] getPrincipals() {
        Object[] names = getNames();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != names.length; i++) {
            if (names[i] instanceof Principal) {
                arrayList.add(names[i]);
            }
        }
        return (Principal[]) arrayList.toArray(new Principal[arrayList.size()]);
    }

    private boolean matchesDN(X500Principal x500Principal, GeneralNames generalNames) {
        GeneralName[] names = generalNames.getNames();
        for (int i = 0; i != names.length; i++) {
            GeneralName generalName = names[i];
            if (generalName.getTagNo() == 4) {
                try {
                    if (new X500Principal(((ASN1Encodable) generalName.getName()).getEncoded()).equals(x500Principal)) {
                        return true;
                    }
                } catch (IOException unused) {
                    continue;
                }
            }
        }
        return false;
    }

    public Object clone() {
        return new AttributeCertificateIssuer(AttCertIssuer.getInstance(this.form));
    }

    public boolean match(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            return false;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        ASN1Encodable aSN1Encodable = this.form;
        if (aSN1Encodable instanceof V2Form) {
            V2Form v2Form = (V2Form) aSN1Encodable;
            if (v2Form.getBaseCertificateID() == null) {
                if (matchesDN(x509Certificate.getSubjectX500Principal(), v2Form.getIssuerName())) {
                    return true;
                }
            } else if (!v2Form.getBaseCertificateID().getSerial().getValue().equals(x509Certificate.getSerialNumber()) || !matchesDN(x509Certificate.getIssuerX500Principal(), v2Form.getBaseCertificateID().getIssuer())) {
                return false;
            } else {
                return true;
            }
        } else {
            if (matchesDN(x509Certificate.getSubjectX500Principal(), (GeneralNames) aSN1Encodable)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeCertificateIssuer)) {
            return false;
        }
        return this.form.equals(((AttributeCertificateIssuer) obj).form);
    }

    public int hashCode() {
        return this.form.hashCode();
    }

    public boolean match(Object obj) {
        if (!(obj instanceof X509Certificate)) {
            return false;
        }
        return match((Certificate) obj);
    }
}
