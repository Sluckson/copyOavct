package roboguice.event;

import android.app.Application;
import android.content.Context;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import roboguice.event.javaassist.RuntimeSupport;
import roboguice.util.C5058Ln;

@Singleton
public class EventManager {
    @Inject
    protected Provider<Context> contextProvider;
    protected Map<Context, Map<Class<?>, Set<EventListener<?>>>> registrations = new WeakHashMap();

    public static class NullEventManager extends EventManager {
        public boolean isEnabled() {
            return false;
        }
    }

    public boolean isEnabled() {
        return true;
    }

    public <T> void registerObserver(Class<T> cls, EventListener eventListener) {
        registerObserver(this.contextProvider.get(), cls, eventListener);
    }

    public <T> void registerObserver(Object obj, Method method, Class<T> cls) {
        registerObserver(this.contextProvider.get(), obj, method, cls);
    }

    public <T> void unregisterObserver(Class<T> cls, EventListener<T> eventListener) {
        unregisterObserver(this.contextProvider.get(), cls, eventListener);
    }

    public <T> void unregisterObserver(Object obj, Class<T> cls) {
        unregisterObserver(this.contextProvider.get(), obj, cls);
    }

    public void fire(Object obj) {
        fire(this.contextProvider.get(), obj);
    }

    public <T> void registerObserver(Context context, Class<T> cls, EventListener eventListener) {
        if (!(context instanceof Application)) {
            Map map = this.registrations.get(context);
            if (map == null) {
                map = new HashMap();
                this.registrations.put(context, map);
            }
            Set set = (Set) map.get(cls);
            if (set == null) {
                set = new HashSet();
                map.put(cls, set);
            }
            set.add(eventListener);
            return;
        }
        throw new RuntimeException("You may not register event handlers on the Application context");
    }

    public <T> void registerObserver(Context context, Object obj, Method method, Class<T> cls) {
        registerObserver(context, cls, (EventListener) new ObserverMethodListener(obj, method));
    }

    public <T> void unregisterObserver(Context context, Class<T> cls, EventListener<T> eventListener) {
        Map map;
        Set set;
        if (isEnabled() && (map = this.registrations.get(context)) != null && (set = (Set) map.get(cls)) != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (((EventListener) it.next()) == eventListener) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public <T> void unregisterObserver(Context context, Object obj, Class<T> cls) {
        Map map;
        Set set;
        if (isEnabled() && (map = this.registrations.get(context)) != null && (set = (Set) map.get(cls)) != null) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                EventListener eventListener = (EventListener) it.next();
                if ((eventListener instanceof ObserverMethodListener) && ((ObserverMethodListener) eventListener).instanceReference.get() == obj) {
                    it.remove();
                    return;
                }
            }
        }
    }

    public void clear(Context context) {
        Map map = this.registrations.get(context);
        if (map != null) {
            this.registrations.remove(context);
            map.clear();
        }
    }

    public void fire(Context context, Object obj) {
        Map map;
        Set<EventListener> set;
        if (isEnabled() && (map = this.registrations.get(context)) != null && (set = (Set) map.get(obj.getClass())) != null) {
            for (EventListener onEvent : set) {
                onEvent.onEvent(obj);
            }
        }
    }

    public static class ObserverMethodListener<T> implements EventListener<T> {
        protected String descriptor;
        protected WeakReference<Object> instanceReference;
        protected Method method;

        public ObserverMethodListener(Object obj, Method method2) {
            this.instanceReference = new WeakReference<>(obj);
            this.method = method2;
            this.descriptor = method2.getName() + ':' + RuntimeSupport.makeDescriptor(method2);
            method2.setAccessible(true);
        }

        public void onEvent(T t) {
            try {
                Object obj = this.instanceReference.get();
                if (obj != null) {
                    this.method.invoke(obj, new Object[]{t});
                    return;
                }
                C5058Ln.m4841w("trying to observe event %1$s on disposed context, consider explicitly calling EventManager.unregisterObserver", this.method.getName());
            } catch (InvocationTargetException e) {
                C5058Ln.m4833e(e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ObserverMethodListener observerMethodListener = (ObserverMethodListener) obj;
            String str = this.descriptor;
            if (str == null ? observerMethodListener.descriptor != null : !str.equals(observerMethodListener.descriptor)) {
                return false;
            }
            Object obj2 = this.instanceReference.get();
            Object obj3 = observerMethodListener.instanceReference.get();
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
                return true;
            } else if (obj3 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.descriptor;
            int i = 0;
            int hashCode = str != null ? str.hashCode() : 0;
            Object obj = this.instanceReference.get();
            int i2 = hashCode * 31;
            if (obj != null) {
                i = obj.hashCode();
            }
            return i2 + i;
        }
    }
}
