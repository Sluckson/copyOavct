package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhi;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
abstract class zzht<T extends zzhi> {
    private static final Logger zza = Logger.getLogger(zzhf.class.getName());
    private static String zzb = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    zzht() {
    }

    /* access modifiers changed from: protected */
    public abstract T zza();

    static <T extends zzhi> T zza(Class<T> cls) {
        String str;
        ClassLoader classLoader = zzht.class.getClassLoader();
        if (cls.equals(zzhi.class)) {
            str = zzb;
        } else if (cls.getPackage().equals(zzht.class.getPackage())) {
            str = String.format("%s.BlazeGenerated%sLoader", new Object[]{cls.getPackage().getName(), cls.getSimpleName()});
        } else {
            throw new IllegalArgumentException(cls.getName());
        }
        try {
            return (zzhi) cls.cast(((zzht) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zza());
        } catch (NoSuchMethodException e) {
            throw new IllegalStateException(e);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException(e3);
        } catch (InvocationTargetException e4) {
            throw new IllegalStateException(e4);
        } catch (ClassNotFoundException unused) {
            Iterator<S> it = ServiceLoader.load(zzht.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add(cls.cast(((zzht) it.next()).zza()));
                } catch (ServiceConfigurationError e5) {
                    ServiceConfigurationError serviceConfigurationError = e5;
                    Logger logger = zza;
                    Level level = Level.SEVERE;
                    String valueOf = String.valueOf(cls.getSimpleName());
                    logger.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", valueOf.length() != 0 ? "Unable to load ".concat(valueOf) : new String("Unable to load "), serviceConfigurationError);
                }
            }
            if (arrayList.size() == 1) {
                return (zzhi) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzhi) cls.getMethod("combine", new Class[]{Collection.class}).invoke((Object) null, new Object[]{arrayList});
            } catch (NoSuchMethodException e6) {
                throw new IllegalStateException(e6);
            } catch (IllegalAccessException e7) {
                throw new IllegalStateException(e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }
}
