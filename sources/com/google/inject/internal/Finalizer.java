package com.google.inject.internal;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Finalizer extends Thread {
    private static final String FINALIZABLE_REFERENCE = "com.google.inject.internal.FinalizableReference";
    private static final Logger logger = Logger.getLogger(Finalizer.class.getName());
    private final WeakReference<Class<?>> finalizableReferenceClassReference;
    private final PhantomReference<Object> frqReference;
    private final ReferenceQueue<Object> queue = new ReferenceQueue<>();

    public static ReferenceQueue<Object> startFinalizer(Class<?> cls, Object obj) {
        if (cls.getName().equals(FINALIZABLE_REFERENCE)) {
            Finalizer finalizer = new Finalizer(cls, obj);
            finalizer.start();
            return finalizer.queue;
        }
        throw new IllegalArgumentException("Expected com.google.inject.internal.FinalizableReference.");
    }

    private Finalizer(Class<?> cls, Object obj) {
        super(Finalizer.class.getName());
        this.finalizableReferenceClassReference = new WeakReference<>(cls);
        this.frqReference = new PhantomReference<>(obj, this.queue);
        setDaemon(true);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:0|1) */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:1:?, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.ref.ReferenceQueue<java.lang.Object> r0 = r1.queue     // Catch:{ InterruptedException -> 0x0000, ShutDown -> 0x000a }
            java.lang.ref.Reference r0 = r0.remove()     // Catch:{ InterruptedException -> 0x0000, ShutDown -> 0x000a }
            r1.cleanUp(r0)     // Catch:{ InterruptedException -> 0x0000, ShutDown -> 0x000a }
            goto L_0x0000
        L_0x000a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.inject.internal.Finalizer.run():void");
    }

    private void cleanUp(Reference<?> reference) throws ShutDown {
        Method finalizeReferentMethod = getFinalizeReferentMethod();
        do {
            reference.clear();
            if (reference != this.frqReference) {
                try {
                    finalizeReferentMethod.invoke(reference, new Object[0]);
                } catch (Throwable th) {
                    logger.log(Level.SEVERE, "Error cleaning up after reference.", th);
                }
                reference = this.queue.poll();
            } else {
                throw new ShutDown();
            }
        } while (reference != null);
    }

    private Method getFinalizeReferentMethod() throws ShutDown {
        Class cls = (Class) this.finalizableReferenceClassReference.get();
        if (cls != null) {
            try {
                return cls.getMethod("finalizeReferent", new Class[0]);
            } catch (NoSuchMethodException e) {
                throw new AssertionError(e);
            }
        } else {
            throw new ShutDown();
        }
    }

    private static class ShutDown extends Exception {
        private ShutDown() {
        }
    }
}
