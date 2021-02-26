package repack.org.bouncycastle.asn1.isismtt.x509;

import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1String;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.x500.DirectoryString;

public class AdditionalInformationSyntax extends ASN1Encodable {
    private DirectoryString information;

    public static AdditionalInformationSyntax getInstance(Object obj) {
        if (obj instanceof AdditionalInformationSyntax) {
            return (AdditionalInformationSyntax) obj;
        }
        if (obj instanceof ASN1String) {
            return new AdditionalInformationSyntax(DirectoryString.getInstance(obj));
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    private AdditionalInformationSyntax(DirectoryString directoryString) {
        this.information = directoryString;
    }

    public AdditionalInformationSyntax(String str) {
        this(new DirectoryString(str));
    }

    public DirectoryString getInformation() {
        return this.information;
    }

    public DERObject toASN1Object() {
        return this.information.toASN1Object();
    }
}
