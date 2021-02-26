package org.codehaus.jackson.node;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.TypeSerializer;
import org.codehaus.jackson.node.ContainerNode;

public class ObjectNode extends ContainerNode {
    protected LinkedHashMap<String, JsonNode> _children = null;

    public JsonNode get(int i) {
        return null;
    }

    public boolean isObject() {
        return true;
    }

    public ObjectNode(JsonNodeFactory jsonNodeFactory) {
        super(jsonNodeFactory);
    }

    public JsonToken asToken() {
        return JsonToken.START_OBJECT;
    }

    public int size() {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap == null) {
            return 0;
        }
        return linkedHashMap.size();
    }

    public Iterator<JsonNode> getElements() {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        return linkedHashMap == null ? ContainerNode.NoNodesIterator.instance() : linkedHashMap.values().iterator();
    }

    public JsonNode get(String str) {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap != null) {
            return linkedHashMap.get(str);
        }
        return null;
    }

    public Iterator<String> getFieldNames() {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        return linkedHashMap == null ? ContainerNode.NoStringsIterator.instance() : linkedHashMap.keySet().iterator();
    }

    public JsonNode path(int i) {
        return MissingNode.getInstance();
    }

    public JsonNode path(String str) {
        JsonNode jsonNode;
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap == null || (jsonNode = linkedHashMap.get(str)) == null) {
            return MissingNode.getInstance();
        }
        return jsonNode;
    }

    public Iterator<Map.Entry<String, JsonNode>> getFields() {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap == null) {
            return NoFieldsIterator.instance;
        }
        return linkedHashMap.entrySet().iterator();
    }

    public ObjectNode with(String str) {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap == null) {
            this._children = new LinkedHashMap<>();
        } else {
            JsonNode jsonNode = linkedHashMap.get(str);
            if (jsonNode != null) {
                if (jsonNode instanceof ObjectNode) {
                    return (ObjectNode) jsonNode;
                }
                throw new UnsupportedOperationException("Property '" + str + "' has value that is not of type ObjectNode (but " + jsonNode.getClass().getName() + ")");
            }
        }
        ObjectNode objectNode = objectNode();
        this._children.put(str, objectNode);
        return objectNode;
    }

    public JsonNode findValue(String str) {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap == null) {
            return null;
        }
        for (Map.Entry next : linkedHashMap.entrySet()) {
            if (str.equals(next.getKey())) {
                return (JsonNode) next.getValue();
            }
            JsonNode findValue = ((JsonNode) next.getValue()).findValue(str);
            if (findValue != null) {
                return findValue;
            }
        }
        return null;
    }

    public List<JsonNode> findValues(String str, List<JsonNode> list) {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap != null) {
            for (Map.Entry next : linkedHashMap.entrySet()) {
                if (str.equals(next.getKey())) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(next.getValue());
                } else {
                    list = ((JsonNode) next.getValue()).findValues(str, list);
                }
            }
        }
        return list;
    }

    public List<String> findValuesAsText(String str, List<String> list) {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap != null) {
            for (Map.Entry next : linkedHashMap.entrySet()) {
                if (str.equals(next.getKey())) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(((JsonNode) next.getValue()).getValueAsText());
                } else {
                    list = ((JsonNode) next.getValue()).findValuesAsText(str, list);
                }
            }
        }
        return list;
    }

    public ObjectNode findParent(String str) {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap == null) {
            return null;
        }
        for (Map.Entry next : linkedHashMap.entrySet()) {
            if (str.equals(next.getKey())) {
                return this;
            }
            JsonNode findParent = ((JsonNode) next.getValue()).findParent(str);
            if (findParent != null) {
                return (ObjectNode) findParent;
            }
        }
        return null;
    }

    public List<JsonNode> findParents(String str, List<JsonNode> list) {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap != null) {
            for (Map.Entry next : linkedHashMap.entrySet()) {
                if (str.equals(next.getKey())) {
                    if (list == null) {
                        list = new ArrayList<>();
                    }
                    list.add(this);
                } else {
                    list = ((JsonNode) next.getValue()).findParents(str, list);
                }
            }
        }
        return list;
    }

    public final void serialize(JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap != null) {
            for (Map.Entry next : linkedHashMap.entrySet()) {
                jsonGenerator.writeFieldName((String) next.getKey());
                ((BaseJsonNode) next.getValue()).serialize(jsonGenerator, serializerProvider);
            }
        }
        jsonGenerator.writeEndObject();
    }

    public void serializeWithType(JsonGenerator jsonGenerator, SerializerProvider serializerProvider, TypeSerializer typeSerializer) throws IOException, JsonProcessingException {
        typeSerializer.writeTypePrefixForObject(this, jsonGenerator);
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap != null) {
            for (Map.Entry next : linkedHashMap.entrySet()) {
                jsonGenerator.writeFieldName((String) next.getKey());
                ((BaseJsonNode) next.getValue()).serialize(jsonGenerator, serializerProvider);
            }
        }
        typeSerializer.writeTypeSuffixForObject(this, jsonGenerator);
    }

    public JsonNode put(String str, JsonNode jsonNode) {
        if (jsonNode == null) {
            jsonNode = nullNode();
        }
        return _put(str, jsonNode);
    }

    public JsonNode remove(String str) {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap != null) {
            return (JsonNode) linkedHashMap.remove(str);
        }
        return null;
    }

    public ObjectNode remove(Collection<String> collection) {
        if (this._children != null) {
            for (String remove : collection) {
                this._children.remove(remove);
            }
        }
        return this;
    }

    public ObjectNode removeAll() {
        this._children = null;
        return this;
    }

    public JsonNode putAll(Map<String, JsonNode> map) {
        if (this._children == null) {
            this._children = new LinkedHashMap<>(map);
        } else {
            for (Map.Entry next : map.entrySet()) {
                Object obj = (JsonNode) next.getValue();
                if (obj == null) {
                    obj = nullNode();
                }
                this._children.put(next.getKey(), obj);
            }
        }
        return this;
    }

    public JsonNode putAll(ObjectNode objectNode) {
        int size = objectNode.size();
        if (size > 0) {
            if (this._children == null) {
                this._children = new LinkedHashMap<>(size);
            }
            objectNode.putContentsTo(this._children);
        }
        return this;
    }

    public ObjectNode retain(Collection<String> collection) {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap != null) {
            Iterator<Map.Entry<String, JsonNode>> it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next().getKey())) {
                    it.remove();
                }
            }
        }
        return this;
    }

    public ObjectNode retain(String... strArr) {
        return retain((Collection<String>) Arrays.asList(strArr));
    }

    public ArrayNode putArray(String str) {
        ArrayNode arrayNode = arrayNode();
        _put(str, arrayNode);
        return arrayNode;
    }

    public ObjectNode putObject(String str) {
        ObjectNode objectNode = objectNode();
        _put(str, objectNode);
        return objectNode;
    }

    public void putPOJO(String str, Object obj) {
        _put(str, POJONode(obj));
    }

    public void putNull(String str) {
        _put(str, nullNode());
    }

    public void put(String str, int i) {
        _put(str, numberNode(i));
    }

    public void put(String str, long j) {
        _put(str, numberNode(j));
    }

    public void put(String str, float f) {
        _put(str, numberNode(f));
    }

    public void put(String str, double d) {
        _put(str, numberNode(d));
    }

    public void put(String str, BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            putNull(str);
        } else {
            _put(str, numberNode(bigDecimal));
        }
    }

    public void put(String str, String str2) {
        if (str2 == null) {
            putNull(str);
        } else {
            _put(str, textNode(str2));
        }
    }

    public void put(String str, boolean z) {
        _put(str, booleanNode(z));
    }

    public void put(String str, byte[] bArr) {
        if (bArr == null) {
            putNull(str);
        } else {
            _put(str, binaryNode(bArr));
        }
    }

    /* access modifiers changed from: protected */
    public void putContentsTo(Map<String, JsonNode> map) {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap != null) {
            for (Map.Entry next : linkedHashMap.entrySet()) {
                map.put(next.getKey(), next.getValue());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            r0 = 1
            if (r6 != r5) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            if (r6 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.lang.Class r2 = r6.getClass()
            java.lang.Class r3 = r5.getClass()
            if (r2 == r3) goto L_0x0013
            return r1
        L_0x0013:
            org.codehaus.jackson.node.ObjectNode r6 = (org.codehaus.jackson.node.ObjectNode) r6
            int r2 = r6.size()
            int r3 = r5.size()
            if (r2 == r3) goto L_0x0020
            return r1
        L_0x0020:
            java.util.LinkedHashMap<java.lang.String, org.codehaus.jackson.JsonNode> r2 = r5._children
            if (r2 == 0) goto L_0x0051
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x002c:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0051
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r3 = r3.getValue()
            org.codehaus.jackson.JsonNode r3 = (org.codehaus.jackson.JsonNode) r3
            org.codehaus.jackson.JsonNode r4 = r6.get((java.lang.String) r4)
            if (r4 == 0) goto L_0x0050
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x002c
        L_0x0050:
            return r1
        L_0x0051:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.codehaus.jackson.node.ObjectNode.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap == null) {
            return -1;
        }
        return linkedHashMap.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() << 4) + 32);
        sb.append("{");
        LinkedHashMap<String, JsonNode> linkedHashMap = this._children;
        if (linkedHashMap != null) {
            int i = 0;
            for (Map.Entry next : linkedHashMap.entrySet()) {
                if (i > 0) {
                    sb.append(",");
                }
                i++;
                TextNode.appendQuoted(sb, (String) next.getKey());
                sb.append(':');
                sb.append(((JsonNode) next.getValue()).toString());
            }
        }
        sb.append("}");
        return sb.toString();
    }

    private final JsonNode _put(String str, JsonNode jsonNode) {
        if (this._children == null) {
            this._children = new LinkedHashMap<>();
        }
        return (JsonNode) this._children.put(str, jsonNode);
    }

    protected static class NoFieldsIterator implements Iterator<Map.Entry<String, JsonNode>> {
        static final NoFieldsIterator instance = new NoFieldsIterator();

        public boolean hasNext() {
            return false;
        }

        private NoFieldsIterator() {
        }

        public Map.Entry<String, JsonNode> next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new IllegalStateException();
        }
    }
}
