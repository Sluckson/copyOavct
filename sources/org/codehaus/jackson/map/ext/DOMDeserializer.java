package org.codehaus.jackson.map.ext;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilderFactory;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.FromStringDeserializer;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;

public abstract class DOMDeserializer<T> extends FromStringDeserializer<T> {
    static final DocumentBuilderFactory _parserFactory = DocumentBuilderFactory.newInstance();

    public abstract T _deserialize(String str, DeserializationContext deserializationContext);

    static {
        _parserFactory.setNamespaceAware(true);
    }

    protected DOMDeserializer(Class<T> cls) {
        super(cls);
    }

    /* access modifiers changed from: protected */
    public final Document parse(String str) throws IllegalArgumentException {
        try {
            return _parserFactory.newDocumentBuilder().parse(new InputSource(new StringReader(str)));
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse JSON String as XML: " + e.getMessage(), e);
        }
    }

    public static class NodeDeserializer extends DOMDeserializer<Node> {
        public NodeDeserializer() {
            super(Node.class);
        }

        public Node _deserialize(String str, DeserializationContext deserializationContext) throws IllegalArgumentException {
            return parse(str);
        }
    }

    public static class DocumentDeserializer extends DOMDeserializer<Document> {
        public DocumentDeserializer() {
            super(Document.class);
        }

        public Document _deserialize(String str, DeserializationContext deserializationContext) throws IllegalArgumentException {
            return parse(str);
        }
    }
}
