package repack.org.bouncycastle.cms;

import java.util.Map;
import repack.org.bouncycastle.asn1.cms.AttributeTable;

public class SimpleAttributeTableGenerator implements CMSAttributeTableGenerator {
    private final AttributeTable attributes;

    public SimpleAttributeTableGenerator(AttributeTable attributeTable) {
        this.attributes = attributeTable;
    }

    public AttributeTable getAttributes(Map map) {
        return this.attributes;
    }
}
