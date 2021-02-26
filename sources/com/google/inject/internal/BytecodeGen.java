package com.google.inject.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Map;
import java.util.logging.Logger;

public final class BytecodeGen {
    private static final String CGLIB_PACKAGE = " ";
    private static final Map<ClassLoader, ClassLoader> CLASS_LOADER_CACHE = new MapMaker().weakKeys().weakValues().makeComputingMap(new Function<ClassLoader, ClassLoader>() {
        public ClassLoader apply(@Nullable final ClassLoader classLoader) {
            Logger access$000 = BytecodeGen.logger;
            access$000.fine("Creating a bridge ClassLoader for " + classLoader);
            return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() {
                public ClassLoader run() {
                    return new BridgeClassLoader(classLoader);
                }
            });
        }
    });
    static final ClassLoader GUICE_CLASS_LOADER = BytecodeGen.class.getClassLoader();
    /* access modifiers changed from: private */
    public static final String GUICE_INTERNAL_PACKAGE = BytecodeGen.class.getName().replaceFirst("\\.internal\\..*$", ".internal");
    static final boolean HOOK_ENABLED = "true".equals(System.getProperty("guice.custom.loader", "true"));
    /* access modifiers changed from: private */
    public static final Logger logger = Logger.getLogger(BytecodeGen.class.getName());

    private static ClassLoader canonicalize(ClassLoader classLoader) {
        return classLoader != null ? classLoader : (ClassLoader) Preconditions.checkNotNull(getSystemClassLoaderOrNull(), "Couldn't get a ClassLoader");
    }

    private static ClassLoader getSystemClassLoaderOrNull() {
        try {
            return ClassLoader.getSystemClassLoader();
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static ClassLoader getClassLoader(Class<?> cls) {
        return getClassLoader(cls, cls.getClassLoader());
    }

    private static ClassLoader getClassLoader(Class<?> cls, ClassLoader classLoader) {
        ClassLoader canonicalize = canonicalize(classLoader);
        return (canonicalize != getSystemClassLoaderOrNull() && !(canonicalize instanceof BridgeClassLoader) && HOOK_ENABLED && Visibility.forType(cls) == Visibility.PUBLIC) ? CLASS_LOADER_CACHE.get(canonicalize) : canonicalize;
    }

    public enum Visibility {
        PUBLIC {
            public Visibility and(Visibility visibility) {
                return visibility;
            }
        },
        SAME_PACKAGE {
            public Visibility and(Visibility visibility) {
                return this;
            }
        };

        public abstract Visibility and(Visibility visibility);

        public static Visibility forMember(Member member) {
            if ((member.getModifiers() & 5) == 0) {
                return SAME_PACKAGE;
            }
            for (Class forType : member instanceof Constructor ? ((Constructor) member).getParameterTypes() : ((Method) member).getParameterTypes()) {
                Visibility forType2 = forType(forType);
                Visibility visibility = SAME_PACKAGE;
                if (forType2 == visibility) {
                    return visibility;
                }
            }
            return PUBLIC;
        }

        public static Visibility forType(Class<?> cls) {
            return (cls.getModifiers() & 5) != 0 ? PUBLIC : SAME_PACKAGE;
        }
    }

    private static class BridgeClassLoader extends ClassLoader {
        public BridgeClassLoader(ClassLoader classLoader) {
            super(classLoader);
        }

        /* access modifiers changed from: protected */
        public Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if (str.startsWith(BytecodeGen.GUICE_INTERNAL_PACKAGE) || str.startsWith(" ")) {
                try {
                    Class<?> loadClass = BytecodeGen.GUICE_CLASS_LOADER.loadClass(str);
                    if (z) {
                        resolveClass(loadClass);
                    }
                    return loadClass;
                } catch (Exception unused) {
                }
            }
            return super.loadClass(str, z);
        }
    }
}
