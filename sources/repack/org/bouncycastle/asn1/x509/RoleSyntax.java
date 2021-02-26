package repack.org.bouncycastle.asn1.x509;

import com.iaai.android.old.utils.constants.Constants;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.ASN1String;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.DERTaggedObject;

public class RoleSyntax extends ASN1Encodable {
    private GeneralNames roleAuthority;
    private GeneralName roleName;

    public static RoleSyntax getInstance(Object obj) {
        if (obj instanceof RoleSyntax) {
            return (RoleSyntax) obj;
        }
        if (obj != null) {
            return new RoleSyntax(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public RoleSyntax(GeneralNames generalNames, GeneralName generalName) {
        if (generalName == null || generalName.getTagNo() != 6 || ((ASN1String) generalName.getName()).getString().equals("")) {
            throw new IllegalArgumentException("the role name MUST be non empty and MUST use the URI option of GeneralName");
        }
        this.roleAuthority = generalNames;
        this.roleName = generalName;
    }

    public RoleSyntax(GeneralName generalName) {
        this((GeneralNames) null, generalName);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RoleSyntax(String str) {
        this(new GeneralName(6, str == null ? "" : str));
    }

    private RoleSyntax(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 2) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
        }
        for (int i = 0; i != aSN1Sequence.size(); i++) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i));
            int tagNo = instance.getTagNo();
            if (tagNo == 0) {
                this.roleAuthority = GeneralNames.getInstance(instance, false);
            } else if (tagNo == 1) {
                this.roleName = GeneralName.getInstance(instance, true);
            } else {
                throw new IllegalArgumentException("Unknown tag in RoleSyntax");
            }
        }
    }

    public GeneralNames getRoleAuthority() {
        return this.roleAuthority;
    }

    public GeneralName getRoleName() {
        return this.roleName;
    }

    public String getRoleNameAsString() {
        return ((ASN1String) this.roleName.getName()).getString();
    }

    public String[] getRoleAuthorityAsString() {
        GeneralNames generalNames = this.roleAuthority;
        if (generalNames == null) {
            return new String[0];
        }
        GeneralName[] names = generalNames.getNames();
        String[] strArr = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            DEREncodable name = names[i].getName();
            if (name instanceof ASN1String) {
                strArr[i] = ((ASN1String) name).getString();
            } else {
                strArr[i] = name.toString();
            }
        }
        return strArr;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        GeneralNames generalNames = this.roleAuthority;
        if (generalNames != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, generalNames));
        }
        aSN1EncodableVector.add(new DERTaggedObject(true, 1, this.roleName));
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Name: " + getRoleNameAsString() + " - Auth: ");
        GeneralNames generalNames = this.roleAuthority;
        if (generalNames == null || generalNames.getNames().length == 0) {
            stringBuffer.append(Constants.STR_NA);
        } else {
            String[] roleAuthorityAsString = getRoleAuthorityAsString();
            stringBuffer.append('[');
            stringBuffer.append(roleAuthorityAsString[0]);
            for (int i = 1; i < roleAuthorityAsString.length; i++) {
                stringBuffer.append(", ");
                stringBuffer.append(roleAuthorityAsString[i]);
            }
            stringBuffer.append(']');
        }
        return stringBuffer.toString();
    }
}
