package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.lang.reflect.InvocationTargetException;

public class ViewModelProvider {
    private static final String DEFAULT_KEY = "androidx.lifecycle.ViewModelProvider.DefaultKey";
    private final Factory mFactory;
    private final ViewModelStore mViewModelStore;

    public interface Factory {
        @NonNull
        <T extends ViewModel> T create(@NonNull Class<T> cls);
    }

    static class OnRequeryFactory {
        /* access modifiers changed from: package-private */
        public void onRequery(@NonNull ViewModel viewModel) {
        }

        OnRequeryFactory() {
        }
    }

    static abstract class KeyedFactory extends OnRequeryFactory implements Factory {
        @NonNull
        public abstract <T extends ViewModel> T create(@NonNull String str, @NonNull Class<T> cls);

        KeyedFactory() {
        }

        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ViewModelProvider(@androidx.annotation.NonNull androidx.lifecycle.ViewModelStoreOwner r3) {
        /*
            r2 = this;
            androidx.lifecycle.ViewModelStore r0 = r3.getViewModelStore()
            boolean r1 = r3 instanceof androidx.lifecycle.HasDefaultViewModelProviderFactory
            if (r1 == 0) goto L_0x000f
            androidx.lifecycle.HasDefaultViewModelProviderFactory r3 = (androidx.lifecycle.HasDefaultViewModelProviderFactory) r3
            androidx.lifecycle.ViewModelProvider$Factory r3 = r3.getDefaultViewModelProviderFactory()
            goto L_0x0013
        L_0x000f:
            androidx.lifecycle.ViewModelProvider$NewInstanceFactory r3 = androidx.lifecycle.ViewModelProvider.NewInstanceFactory.getInstance()
        L_0x0013:
            r2.<init>((androidx.lifecycle.ViewModelStore) r0, (androidx.lifecycle.ViewModelProvider.Factory) r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.ViewModelProvider.<init>(androidx.lifecycle.ViewModelStoreOwner):void");
    }

    public ViewModelProvider(@NonNull ViewModelStoreOwner viewModelStoreOwner, @NonNull Factory factory) {
        this(viewModelStoreOwner.getViewModelStore(), factory);
    }

    public ViewModelProvider(@NonNull ViewModelStore viewModelStore, @NonNull Factory factory) {
        this.mFactory = factory;
        this.mViewModelStore = viewModelStore;
    }

    @MainThread
    @NonNull
    public <T extends ViewModel> T get(@NonNull Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @MainThread
    @NonNull
    public <T extends ViewModel> T get(@NonNull String str, @NonNull Class<T> cls) {
        T t;
        T t2 = this.mViewModelStore.get(str);
        if (cls.isInstance(t2)) {
            Factory factory = this.mFactory;
            if (factory instanceof OnRequeryFactory) {
                ((OnRequeryFactory) factory).onRequery(t2);
            }
            return t2;
        }
        Factory factory2 = this.mFactory;
        if (factory2 instanceof KeyedFactory) {
            t = ((KeyedFactory) factory2).create(str, cls);
        } else {
            t = factory2.create(cls);
        }
        this.mViewModelStore.put(str, t);
        return t;
    }

    public static class NewInstanceFactory implements Factory {
        private static NewInstanceFactory sInstance;

        @NonNull
        static NewInstanceFactory getInstance() {
            if (sInstance == null) {
                sInstance = new NewInstanceFactory();
            }
            return sInstance;
        }

        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            try {
                return (ViewModel) cls.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            }
        }
    }

    public static class AndroidViewModelFactory extends NewInstanceFactory {
        private static AndroidViewModelFactory sInstance;
        private Application mApplication;

        @NonNull
        public static AndroidViewModelFactory getInstance(@NonNull Application application) {
            if (sInstance == null) {
                sInstance = new AndroidViewModelFactory(application);
            }
            return sInstance;
        }

        public AndroidViewModelFactory(@NonNull Application application) {
            this.mApplication = application;
        }

        @NonNull
        public <T extends ViewModel> T create(@NonNull Class<T> cls) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                return (ViewModel) cls.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this.mApplication});
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + cls, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            }
        }
    }
}
