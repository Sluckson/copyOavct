package org.codehaus.jackson.node;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonToken;

public abstract class ContainerNode extends BaseJsonNode {
    JsonNodeFactory _nodeFactory;

    public abstract JsonToken asToken();

    public abstract ObjectNode findParent(String str);

    public abstract List<JsonNode> findParents(String str, List<JsonNode> list);

    public abstract JsonNode findValue(String str);

    public abstract List<JsonNode> findValues(String str, List<JsonNode> list);

    public abstract List<String> findValuesAsText(String str, List<String> list);

    public abstract JsonNode get(int i);

    public abstract JsonNode get(String str);

    public String getValueAsText() {
        return null;
    }

    public boolean isContainerNode() {
        return true;
    }

    public abstract ContainerNode removeAll();

    public abstract int size();

    protected ContainerNode(JsonNodeFactory jsonNodeFactory) {
        this._nodeFactory = jsonNodeFactory;
    }

    public final ArrayNode arrayNode() {
        return this._nodeFactory.arrayNode();
    }

    public final ObjectNode objectNode() {
        return this._nodeFactory.objectNode();
    }

    public final NullNode nullNode() {
        return this._nodeFactory.nullNode();
    }

    public final BooleanNode booleanNode(boolean z) {
        return this._nodeFactory.booleanNode(z);
    }

    public final NumericNode numberNode(byte b) {
        return this._nodeFactory.numberNode(b);
    }

    public final NumericNode numberNode(short s) {
        return this._nodeFactory.numberNode(s);
    }

    public final NumericNode numberNode(int i) {
        return this._nodeFactory.numberNode(i);
    }

    public final NumericNode numberNode(long j) {
        return this._nodeFactory.numberNode(j);
    }

    public final NumericNode numberNode(float f) {
        return this._nodeFactory.numberNode(f);
    }

    public final NumericNode numberNode(double d) {
        return this._nodeFactory.numberNode(d);
    }

    public final NumericNode numberNode(BigDecimal bigDecimal) {
        return this._nodeFactory.numberNode(bigDecimal);
    }

    public final TextNode textNode(String str) {
        return this._nodeFactory.textNode(str);
    }

    public final BinaryNode binaryNode(byte[] bArr) {
        return this._nodeFactory.binaryNode(bArr);
    }

    public final BinaryNode binaryNode(byte[] bArr, int i, int i2) {
        return this._nodeFactory.binaryNode(bArr, i, i2);
    }

    public final POJONode POJONode(Object obj) {
        return this._nodeFactory.POJONode(obj);
    }

    protected static class NoNodesIterator implements Iterator<JsonNode> {
        static final NoNodesIterator instance = new NoNodesIterator();

        public boolean hasNext() {
            return false;
        }

        private NoNodesIterator() {
        }

        public static NoNodesIterator instance() {
            return instance;
        }

        public JsonNode next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }

    protected static class NoStringsIterator implements Iterator<String> {
        static final NoStringsIterator instance = new NoStringsIterator();

        public boolean hasNext() {
            return false;
        }

        private NoStringsIterator() {
        }

        public static NoStringsIterator instance() {
            return instance;
        }

        public String next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }
}
