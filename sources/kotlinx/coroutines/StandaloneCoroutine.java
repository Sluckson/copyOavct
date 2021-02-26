package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0014¨\u0006\u000b"}, mo66933d2 = {"Lkotlinx/coroutines/StandaloneCoroutine;", "Lkotlinx/coroutines/AbstractCoroutine;", "", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "handleJobException", "exception", "", "kotlinx-coroutines-core"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: Builders.common.kt */
class StandaloneCoroutine extends AbstractCoroutine<Unit> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StandaloneCoroutine(@NotNull CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, z);
        Intrinsics.checkParameterIsNotNull(coroutineContext, "parentContext");
    }

    /* access modifiers changed from: protected */
    public boolean handleJobException(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "exception");
        CoroutineExceptionHandlerKt.handleCoroutineException(getContext(), th);
        return true;
    }
}
