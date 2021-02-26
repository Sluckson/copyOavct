package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, mo66933d2 = {"Lkotlinx/coroutines/CoroutinesInternalError;", "Ljava/lang/Error;", "Lkotlin/Error;", "message", "", "cause", "", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: Exceptions.common.kt */
public final class CoroutinesInternalError extends Error {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CoroutinesInternalError(@NotNull String str, @NotNull Throwable th) {
        super(str, th);
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(th, "cause");
    }
}
