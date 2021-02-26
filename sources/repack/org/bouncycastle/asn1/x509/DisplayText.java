package repack.org.bouncycastle.asn1.x509;

import repack.org.bouncycastle.asn1.ASN1Choice;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1String;
import repack.org.bouncycastle.asn1.ASN1TaggedObject;
import repack.org.bouncycastle.asn1.DERBMPString;
import repack.org.bouncycastle.asn1.DERIA5String;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERUTF8String;
import repack.org.bouncycastle.asn1.DERVisibleString;

public class DisplayText extends ASN1Encodable implements ASN1Choice {
    public static final int CONTENT_TYPE_BMPSTRING = 1;
    public static final int CONTENT_TYPE_IA5STRING = 0;
    public static final int CONTENT_TYPE_UTF8STRING = 2;
    public static final int CONTENT_TYPE_VISIBLESTRING = 3;
    public static final int DISPLAY_TEXT_MAXIMUM_SIZE = 200;
    int contentType;
    ASN1String contents;

    public DisplayText(int i, String str) {
        str = str.length() > 200 ? str.substring(0, 200) : str;
        this.contentType = i;
        if (i == 0) {
            this.contents = new DERIA5String(str);
        } else if (i == 1) {
            this.contents = new DERBMPString(str);
        } else if (i == 2) {
            this.contents = new DERUTF8String(str);
        } else if (i != 3) {
            this.contents = new DERUTF8String(str);
        } else {
            this.contents = new DERVisibleString(str);
        }
    }

    public DisplayText(String str) {
        str = str.length() > 200 ? str.substring(0, 200) : str;
        this.contentType = 2;
        this.contents = new DERUTF8String(str);
    }

    private DisplayText(ASN1String aSN1String) {
        this.contents = aSN1String;
    }

    public static DisplayText getInstance(Object obj) {
        if (obj instanceof ASN1String) {
            return new DisplayText((ASN1String) obj);
        }
        if (obj instanceof DisplayText) {
            return (DisplayText) obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static DisplayText getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(aSN1TaggedObject.getObject());
    }

    public DERObject toASN1Object() {
        return (DERObject) this.contents;
    }

    public String getString() {
        return this.contents.getString();
    }
}
