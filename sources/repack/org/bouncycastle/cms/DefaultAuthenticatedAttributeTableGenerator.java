package repack.org.bouncycastle.cms;

import java.util.Hashtable;
import java.util.Map;
import repack.org.bouncycastle.asn1.DEREncodable;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.DERSet;
import repack.org.bouncycastle.asn1.cms.Attribute;
import repack.org.bouncycastle.asn1.cms.AttributeTable;
import repack.org.bouncycastle.asn1.cms.CMSAttributes;

public class DefaultAuthenticatedAttributeTableGenerator implements CMSAttributeTableGenerator {
    private final Hashtable table;

    public DefaultAuthenticatedAttributeTableGenerator() {
        this.table = new Hashtable();
    }

    public DefaultAuthenticatedAttributeTableGenerator(AttributeTable attributeTable) {
        if (attributeTable != null) {
            this.table = attributeTable.toHashtable();
        } else {
            this.table = new Hashtable();
        }
    }

    /* access modifiers changed from: protected */
    public Hashtable createStandardAttributeTable(Map map) {
        Hashtable hashtable = (Hashtable) this.table.clone();
        if (!hashtable.containsKey(CMSAttributes.contentType)) {
            Attribute attribute = new Attribute(CMSAttributes.contentType, new DERSet((DEREncodable) (DERObjectIdentifier) map.get(CMSAttributeTableGenerator.CONTENT_TYPE)));
            hashtable.put(attribute.getAttrType(), attribute);
        }
        if (!hashtable.containsKey(CMSAttributes.messageDigest)) {
            Attribute attribute2 = new Attribute(CMSAttributes.messageDigest, new DERSet((DEREncodable) new DEROctetString((byte[]) map.get(CMSAttributeTableGenerator.DIGEST))));
            hashtable.put(attribute2.getAttrType(), attribute2);
        }
        return hashtable;
    }

    public AttributeTable getAttributes(Map map) {
        return new AttributeTable(createStandardAttributeTable(map));
    }
}
