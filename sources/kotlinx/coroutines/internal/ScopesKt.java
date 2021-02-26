package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, mo66933d2 = {"tryRecover", "", "Lkotlinx/coroutines/AbstractCoroutine;", "exception", "kotlinx-coroutines-core"}, mo66934k = 2, mo66935mv = {1, 1, 15})
/* compiled from: Scopes.kt */
public final class ScopesKt {
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        r1 = r1.uCont;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Throwable tryRecover(@org.jetbrains.annotations.NotNull kotlinx.coroutines.AbstractCoroutine<?> r1, @org.jetbrains.annotations.NotNull java.lang.Throwable r2) {
        /*
            java.lang.String r0 = "$this$tryRecover"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r1, r0)
            java.lang.String r0 = "exception"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            boolean r0 = r1 instanceof kotlinx.coroutines.internal.ScopeCoroutine
            if (r0 != 0) goto L_0x000f
            r1 = 0
        L_0x000f:
            kotlinx.coroutines.internal.ScopeCoroutine r1 = (kotlinx.coroutines.internal.ScopeCoroutine) r1
            if (r1 == 0) goto L_0x001c
            kotlin.coroutines.Continuation<T> r1 = r1.uCont
            if (r1 == 0) goto L_0x001c
            java.lang.Throwable r1 = kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverStackTrace(r2, r1)
            return r1
        L_0x001c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.ScopesKt.tryRecover(kotlinx.coroutines.AbstractCoroutine, java.lang.Throwable):java.lang.Throwable");
    }
}
