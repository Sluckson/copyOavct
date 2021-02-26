package org.codehaus.jackson.node;

import java.util.Iterator;
import java.util.Map;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonStreamContext;
import org.codehaus.jackson.JsonToken;

abstract class NodeCursor extends JsonStreamContext {
    final NodeCursor _parent;

    public abstract boolean currentHasChildren();

    public abstract JsonNode currentNode();

    public abstract JsonToken endToken();

    public abstract String getCurrentName();

    public abstract JsonToken nextToken();

    public abstract JsonToken nextValue();

    public NodeCursor(int i, NodeCursor nodeCursor) {
        this._type = i;
        this._index = -1;
        this._parent = nodeCursor;
    }

    public final NodeCursor getParent() {
        return this._parent;
    }

    public final NodeCursor iterateChildren() {
        JsonNode currentNode = currentNode();
        if (currentNode == null) {
            throw new IllegalStateException("No current node");
        } else if (currentNode.isArray()) {
            return new Array(currentNode, this);
        } else {
            if (currentNode.isObject()) {
                return new Object(currentNode, this);
            }
            throw new IllegalStateException("Current node of type " + currentNode.getClass().getName());
        }
    }

    protected static final class RootValue extends NodeCursor {
        protected boolean _done = false;
        JsonNode _node;

        public boolean currentHasChildren() {
            return false;
        }

        public JsonToken endToken() {
            return null;
        }

        public String getCurrentName() {
            return null;
        }

        public /* bridge */ /* synthetic */ JsonStreamContext getParent() {
            return NodeCursor.super.getParent();
        }

        public RootValue(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(0, nodeCursor);
            this._node = jsonNode;
        }

        public JsonToken nextToken() {
            if (!this._done) {
                this._done = true;
                return this._node.asToken();
            }
            this._node = null;
            return null;
        }

        public JsonToken nextValue() {
            return nextToken();
        }

        public JsonNode currentNode() {
            return this._node;
        }
    }

    protected static final class Array extends NodeCursor {
        Iterator<JsonNode> _contents;
        JsonNode _currentNode;

        public String getCurrentName() {
            return null;
        }

        public /* bridge */ /* synthetic */ JsonStreamContext getParent() {
            return NodeCursor.super.getParent();
        }

        public Array(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(1, nodeCursor);
            this._contents = jsonNode.getElements();
        }

        public JsonToken nextToken() {
            if (!this._contents.hasNext()) {
                this._currentNode = null;
                return null;
            }
            this._currentNode = this._contents.next();
            return this._currentNode.asToken();
        }

        public JsonToken nextValue() {
            return nextToken();
        }

        public JsonToken endToken() {
            return JsonToken.END_ARRAY;
        }

        public JsonNode currentNode() {
            return this._currentNode;
        }

        public boolean currentHasChildren() {
            return ((ContainerNode) currentNode()).size() > 0;
        }
    }

    protected static final class Object extends NodeCursor {
        Iterator<Map.Entry<String, JsonNode>> _contents;
        Map.Entry<String, JsonNode> _current;
        boolean _needEntry = true;

        public /* bridge */ /* synthetic */ JsonStreamContext getParent() {
            return NodeCursor.super.getParent();
        }

        public Object(JsonNode jsonNode, NodeCursor nodeCursor) {
            super(2, nodeCursor);
            this._contents = ((ObjectNode) jsonNode).getFields();
        }

        public String getCurrentName() {
            Map.Entry<String, JsonNode> entry = this._current;
            if (entry == null) {
                return null;
            }
            return entry.getKey();
        }

        public JsonToken nextToken() {
            if (!this._needEntry) {
                this._needEntry = true;
                return this._current.getValue().asToken();
            } else if (!this._contents.hasNext()) {
                this._current = null;
                return null;
            } else {
                this._needEntry = false;
                this._current = this._contents.next();
                return JsonToken.FIELD_NAME;
            }
        }

        public JsonToken nextValue() {
            JsonToken nextToken = nextToken();
            return nextToken == JsonToken.FIELD_NAME ? nextToken() : nextToken;
        }

        public JsonToken endToken() {
            return JsonToken.END_OBJECT;
        }

        public JsonNode currentNode() {
            Map.Entry<String, JsonNode> entry = this._current;
            if (entry == null) {
                return null;
            }
            return entry.getValue();
        }

        public boolean currentHasChildren() {
            return ((ContainerNode) currentNode()).size() > 0;
        }
    }
}
