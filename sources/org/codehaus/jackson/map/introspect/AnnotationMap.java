package org.codehaus.jackson.map.introspect;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import org.codehaus.jackson.map.util.Annotations;

public final class AnnotationMap implements Annotations {
    protected HashMap<Class<? extends Annotation>, Annotation> _annotations;

    public <A extends Annotation> A get(Class<A> cls) {
        HashMap<Class<? extends Annotation>, Annotation> hashMap = this._annotations;
        if (hashMap == null) {
            return null;
        }
        return (Annotation) hashMap.get(cls);
    }

    public int size() {
        HashMap<Class<? extends Annotation>, Annotation> hashMap = this._annotations;
        if (hashMap == null) {
            return 0;
        }
        return hashMap.size();
    }

    public void addIfNotPresent(Annotation annotation) {
        HashMap<Class<? extends Annotation>, Annotation> hashMap = this._annotations;
        if (hashMap == null || !hashMap.containsKey(annotation.annotationType())) {
            _add(annotation);
        }
    }

    public void add(Annotation annotation) {
        _add(annotation);
    }

    public String toString() {
        HashMap<Class<? extends Annotation>, Annotation> hashMap = this._annotations;
        if (hashMap == null) {
            return "[null]";
        }
        return hashMap.toString();
    }

    /* access modifiers changed from: protected */
    public final void _add(Annotation annotation) {
        if (this._annotations == null) {
            this._annotations = new HashMap<>();
        }
        this._annotations.put(annotation.annotationType(), annotation);
    }
}
