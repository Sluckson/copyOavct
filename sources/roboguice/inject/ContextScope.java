package roboguice.inject;

import android.content.Context;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.Scope;
import com.google.inject.internal.Maps;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import roboguice.application.RoboApplication;
import roboguice.util.C5058Ln;
import roboguice.util.Strings;

public class ContextScope implements Scope {
    protected ThreadLocal<WeakActiveStack<Context>> contextStack = new ThreadLocal<>();
    protected ArrayList<PreferenceMembersInjector<?>> preferencesForInjection = new ArrayList<>();
    protected WeakHashMap<Context, Map<Key<?>, Object>> values = new WeakHashMap<>();
    protected ArrayList<ViewMembersInjector<?>> viewsForInjection = new ArrayList<>();

    public ContextScope(RoboApplication roboApplication) {
        enter(roboApplication);
    }

    public void registerViewForInjection(ViewMembersInjector<?> viewMembersInjector) {
        this.viewsForInjection.add(viewMembersInjector);
    }

    public void registerPreferenceForInjection(PreferenceMembersInjector<?> preferenceMembersInjector) {
        this.preferencesForInjection.add(preferenceMembersInjector);
    }

    public void injectViews() {
        for (int size = this.viewsForInjection.size() - 1; size >= 0; size--) {
            this.viewsForInjection.remove(size).reallyInjectMembers();
        }
    }

    public void injectPreferenceViews() {
        for (int size = this.preferencesForInjection.size() - 1; size >= 0; size--) {
            this.preferencesForInjection.remove(size).reallyInjectMembers();
        }
    }

    public void enter(Context context) {
        WeakHashMap<Context, Map<Key<?>, Object>> weakHashMap;
        ensureContextStack();
        this.contextStack.get().push(context);
        Key<Context> key = Key.get(Context.class);
        getScopedObjectMap(key).put(key, context);
        if (C5058Ln.isVerboseEnabled() && (weakHashMap = this.values) != null) {
            C5058Ln.m4838v("Contexts in the %s scope map after inserting %s: %s", Thread.currentThread().getName(), context, Strings.join(", ", weakHashMap.keySet()));
        }
    }

    public void exit(Context context) {
        ensureContextStack();
        this.contextStack.get().remove(context);
    }

    public void dispose(Context context) {
        WeakHashMap<Context, Map<Key<?>, Object>> weakHashMap = this.values;
        if (weakHashMap != null) {
            Map remove = weakHashMap.remove(context);
            if (remove != null) {
                remove.clear();
            }
            if (C5058Ln.isVerboseEnabled()) {
                C5058Ln.m4838v("Contexts in the %s scope map after removing %s: %s", Thread.currentThread().getName(), context, Strings.join(", ", weakHashMap.keySet()));
            }
        }
    }

    public <T> Provider<T> scope(final Key<T> key, final Provider<T> provider) {
        return new Provider<T>() {
            public T get() {
                Map<Key<?>, Object> scopedObjectMap = ContextScope.this.getScopedObjectMap(key);
                T t = scopedObjectMap.get(key);
                if (t != null || scopedObjectMap.containsKey(key)) {
                    return t;
                }
                T t2 = provider.get();
                scopedObjectMap.put(key, t2);
                return t2;
            }
        };
    }

    /* access modifiers changed from: protected */
    public void ensureContextStack() {
        if (this.contextStack.get() == null) {
            this.contextStack.set(new WeakActiveStack());
        }
    }

    /* access modifiers changed from: protected */
    public <T> Map<Key<?>, Object> getScopedObjectMap(Key<T> key) {
        Context context = (Context) this.contextStack.get().peek();
        Map<Key<?>, Object> map = this.values.get(context);
        if (map != null) {
            return map;
        }
        HashMap newHashMap = Maps.newHashMap();
        this.values.put(context, newHashMap);
        return newHashMap;
    }

    public static class WeakActiveStack<T> {
        private Node<T> head;
        private Node<T> tail;

        static class Node<T> {
            Node<T> next;
            Node<T> previous;
            WeakReference<T> value;

            public Node(T t) {
                this.value = new WeakReference<>(t);
            }
        }

        public void push(T t) {
            if (this.head == null) {
                this.head = new Node<>(t);
                this.tail = this.head;
                return;
            }
            Node<T> findNode = findNode(t);
            if (findNode == null) {
                Node<T> node = new Node<>(t);
                Node<T> node2 = this.head;
                node.next = node2;
                node2.previous = node;
                this.head = node;
            } else if (findNode != this.head) {
                if (findNode == this.tail) {
                    this.tail = findNode.previous;
                    this.tail.next = null;
                }
                if (findNode.previous != null) {
                    findNode.previous.next = findNode.next;
                }
                if (findNode.next != null) {
                    findNode.next.previous = findNode.previous;
                }
                Node<T> node3 = this.head;
                findNode.next = node3;
                node3.previous = findNode;
                this.head = findNode;
                this.head.previous = null;
            }
        }

        public T pop() {
            Node<T> node = this.head;
            while (node != null) {
                T t = node.value.get();
                if (t == null) {
                    node = disposeOfNode(node);
                } else {
                    if (node.next != null) {
                        this.head = node.next;
                        Node<T> node2 = this.tail;
                        node.previous = node2;
                        node2.next = node;
                        node.next = null;
                        this.head.previous = null;
                        this.tail = node;
                    }
                    return t;
                }
            }
            return null;
        }

        public T peek() {
            Node<T> node = this.head;
            while (node != null) {
                T t = node.value.get();
                if (t != null) {
                    return t;
                }
                node = disposeOfNode(node);
            }
            return null;
        }

        public void remove(T t) {
            disposeOfNode(findNode(t));
        }

        /* access modifiers changed from: protected */
        public Node<T> disposeOfNode(Node<T> node) {
            if (node == this.head) {
                this.head = node.next;
                Node<T> node2 = this.head;
                if (node2 == null) {
                    this.tail = null;
                } else {
                    node2.previous = null;
                }
            }
            if (node.previous != null) {
                node.previous.next = node.next;
            }
            if (node.next != null) {
                node.next.previous = node.previous;
            }
            if (node == this.tail) {
                this.tail = node.previous;
                this.tail.next = null;
            }
            return node.next;
        }

        /* access modifiers changed from: protected */
        public Node<T> findNode(T t) {
            Node<T> node = this.head;
            while (node != null) {
                Object obj = node.value.get();
                if (obj == null) {
                    node = disposeOfNode(node);
                } else if (obj.equals(t)) {
                    return node;
                } else {
                    node = node.next;
                }
            }
            return null;
        }
    }
}
