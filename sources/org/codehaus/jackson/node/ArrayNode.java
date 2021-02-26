package org.codehaus.jackson.node;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.node.ContainerNode;

public final class ArrayNode extends ContainerNode {
    protected ArrayList<JsonNode> _children;

    public JsonNode get(String str) {
        return null;
    }

    public boolean isArray() {
        return true;
    }

    public ArrayNode(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
    }

    public JsonToken asToken() {
        return JsonToken.START_ARRAY;
    }

    public int size() {
        ArrayList<JsonNode> arrayList = this._children;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public Iterator<JsonNode> getElements() {
        ArrayList<JsonNode> arrayList = this._children;
        return arrayList == null ? ContainerNode.NoNodesIterator.instance() : arrayList.iterator();
    }

    public JsonNode get(int i) {
        ArrayList<JsonNode> arrayList;
        if (i < 0 || (arrayList = this._children) == null || i >= arrayList.size()) {
            return null;
        }
        return this._children.get(i);
    }

    public JsonNode path(String str) {
        return MissingNode.getInstance();
    }

    public JsonNode path(int i) {
        ArrayList<JsonNode> arrayList;
        if (i < 0 || (arrayList = this._children) == null || i >= arrayList.size()) {
            return MissingNode.getInstance();
        }
        return this._children.get(i);
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartArray();
        ArrayList<JsonNode> arrayList = this._children;
        if (arrayList != null) {
            Iterator<JsonNode> it = arrayList.iterator();
            while (it.hasNext()) {
                ((BaseJsonNode) it.next()).writeTo(jsonGenerator);
            }
        }
        jsonGenerator.writeEndArray();
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonProcessingException {
        typeSerializer.writeTypePrefixForArray(this, jsonGenerator);
        ArrayList<JsonNode> arrayList = this._children;
        if (arrayList != null) {
            Iterator<JsonNode> it = arrayList.iterator();
            while (it.hasNext()) {
                ((BaseJsonNode) it.next()).writeTo(jsonGenerator);
            }
        }
        typeSerializer.writeTypeSuffixForArray(this, jsonGenerator);
    }

    public JsonNode findValue(String str) {
        ArrayList<JsonNode> arrayList = this._children;
        if (arrayList == null) {
            return null;
        }
        Iterator<JsonNode> it = arrayList.iterator();
        while (it.hasNext()) {
            JsonNode findValue = it.next().findValue(str);
            if (findValue != null) {
                return findValue;
            }
        }
        return null;
    }

    public List<JsonNode> findValues(String str, List<JsonNode> list) {
        ArrayList<JsonNode> arrayList = this._children;
        if (arrayList != null) {
            Iterator<JsonNode> it = arrayList.iterator();
            while (it.hasNext()) {
                list = it.next().findValues(str, list);
            }
        }
        return list;
    }

    public List<String> findValuesAsText(String str, List<String> list) {
        ArrayList<JsonNode> arrayList = this._children;
        if (arrayList != null) {
            Iterator<JsonNode> it = arrayList.iterator();
            while (it.hasNext()) {
                list = it.next().findValuesAsText(str, list);
            }
        }
        return list;
    }

    public ObjectNode findParent(String str) {
        ArrayList<JsonNode> arrayList = this._children;
        if (arrayList == null) {
            return null;
        }
        Iterator<JsonNode> it = arrayList.iterator();
        while (it.hasNext()) {
            JsonNode findParent = it.next().findParent(str);
            if (findParent != null) {
                return (ObjectNode) findParent;
            }
        }
        return null;
    }

    public List<JsonNode> findParents(String str, List<JsonNode> list) {
        ArrayList<JsonNode> arrayList = this._children;
        if (arrayList != null) {
            Iterator<JsonNode> it = arrayList.iterator();
            while (it.hasNext()) {
                list = it.next().findParents(str, list);
            }
        }
        return list;
    }

    public JsonNode set(int i, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        return _set(i, jsonNode);
    }

    public void add(JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        _add(jsonNode);
    }

    public JsonNode addAll(ArrayNode arrayNode) {
        int size = arrayNode.size();
        if (size > 0) {
            if (this._children == null) {
                this._children = new ArrayList<>(size + 2);
            }
            arrayNode.addContentsTo(this._children);
        }
        return this;
    }

    public JsonNode addAll(Collection<JsonNode> collection) {
        if (collection.size() > 0) {
            ArrayList<JsonNode> arrayList = this._children;
            if (arrayList == null) {
                this._children = new ArrayList<>(collection);
            } else {
                arrayList.addAll(collection);
            }
        }
        return this;
    }

    public void insert(int i, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        _insert(i, jsonNode);
    }

    public JsonNode remove(int i) {
        ArrayList<JsonNode> arrayList;
        if (i < 0 || (arrayList = this._children) == null || i >= arrayList.size()) {
            return null;
        }
        return this._children.remove(i);
    }

    public ArrayNode removeAll() {
        this._children = null;
        return this;
    }

    public ArrayNode addArray() {
        ArrayNode arrayNode = arrayNode();
        _add(arrayNode);
        return arrayNode;
    }

    public ObjectNode addObject() {
        ObjectNode objectNode = objectNode();
        _add(objectNode);
        return objectNode;
    }

    public void addPOJO(Object obj) {
        if (obj == null) {
            addNull();
        } else {
            _add(POJONode(obj));
        }
    }

    public void addNull() {
        _add(nullNode());
    }

    public void add(int i) {
        _add(numberNode(i));
    }

    public void add(long j) {
        _add(numberNode(j));
    }

    public void add(float f) {
        _add(numberNode(f));
    }

    public void add(double d) {
        _add(numberNode(d));
    }

    public void add(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            addNull();
        } else {
            _add(numberNode(bigDecimal));
        }
    }

    public void add(String str) {
        if (str == null) {
            addNull();
        } else {
            _add(textNode(str));
        }
    }

    public void add(boolean z) {
        _add(booleanNode(z));
    }

    public void add(byte[] bArr) {
        if (bArr == null) {
            addNull();
        } else {
            _add(binaryNode(bArr));
        }
    }

    public ArrayNode insertArray(int i) {
        ArrayNode arrayNode = arrayNode();
        _insert(i, arrayNode);
        return arrayNode;
    }

    public ObjectNode insertObject(int i) {
        ObjectNode objectNode = objectNode();
        _insert(i, objectNode);
        return objectNode;
    }

    public void insertPOJO(int i, Object obj) {
        if (obj == null) {
            insertNull(i);
        } else {
            _insert(i, POJONode(obj));
        }
    }

    public void insertNull(int i) {
        _insert(i, nullNode());
    }

    public void insert(int i, int i2) {
        _insert(i, numberNode(i2));
    }

    public void insert(int i, long j) {
        _insert(i, numberNode(j));
    }

    public void insert(int i, float f) {
        _insert(i, numberNode(f));
    }

    public void insert(int i, double d) {
        _insert(i, numberNode(d));
    }

    public void insert(int i, BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            insertNull(i);
        } else {
            _insert(i, numberNode(bigDecimal));
        }
    }

    public void insert(int i, String str) {
        if (str == null) {
            insertNull(i);
        } else {
            _insert(i, textNode(str));
        }
    }

    public void insert(int i, boolean z) {
        _insert(i, booleanNode(z));
    }

    public void insert(int i, byte[] bArr) {
        if (bArr == null) {
            insertNull(i);
        } else {
            _insert(i, binaryNode(bArr));
        }
    }

    /* access modifiers changed from: protected */
    public void addContentsTo(List<JsonNode> list) {
        ArrayList<JsonNode> arrayList = this._children;
        if (arrayList != null) {
            Iterator<JsonNode> it = arrayList.iterator();
            while (it.hasNext()) {
                list.add(it.next());
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        ArrayNode arrayNode = (ArrayNode) obj;
        ArrayList<JsonNode> arrayList = this._children;
        if (arrayList != null && arrayList.size() != 0) {
            return arrayNode._sameChildren(this._children);
        }
        if (arrayNode.size() == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        ArrayList<JsonNode> arrayList = this._children;
        if (arrayList == null) {
            return 1;
        }
        int size = arrayList.size();
        Iterator<JsonNode> it = this._children.iterator();
        while (it.hasNext()) {
            JsonNode next = it.next();
            if (next != null) {
                size ^= next.hashCode();
            }
        }
        return size;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() << 4) + 16);
        sb.append('[');
        ArrayList<JsonNode> arrayList = this._children;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    sb.append(',');
                }
                sb.append(this._children.get(i).toString());
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public JsonNode _set(int i, JsonNode jsonNode) {
        ArrayList<JsonNode> arrayList = this._children;
        if (arrayList != null && i >= 0 && i < arrayList.size()) {
            return this._children.set(i, jsonNode);
        }
        throw new IndexOutOfBoundsException("Illegal index " + i + ", array size " + size());
    }

    private void _add(JsonNode jsonNode) {
        if (this._children == null) {
            this._children = new ArrayList<>();
        }
        this._children.add(jsonNode);
    }

    private void _insert(int i, JsonNode jsonNode) {
        ArrayList<JsonNode> arrayList = this._children;
        if (arrayList == null) {
            this._children = new ArrayList<>();
            this._children.add(jsonNode);
        } else if (i < 0) {
            arrayList.add(0, jsonNode);
        } else if (i >= arrayList.size()) {
            this._children.add(jsonNode);
        } else {
            this._children.add(i, jsonNode);
        }
    }

    private boolean _sameChildren(ArrayList<JsonNode> arrayList) {
        int size = arrayList.size();
        if (size() != size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this._children.get(i).equals(arrayList.get(i))) {
                return false;
            }
        }
        return true;
    }
}
