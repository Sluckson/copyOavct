package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\bH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\t"}, mo66933d2 = {"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, mo66934k = 2, mo66935mv = {1, 1, 15})
/* compiled from: DebugStrings.kt */
public final class DebugStringsKt {
    @NotNull
    public static final String getHexAddress(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$this$hexAddress");
        String hexString = Integer.toHexString(System.identityHashCode(obj));
        Intrinsics.checkExpressionValueIsNotNull(hexString, "Integer.toHexString(System.identityHashCode(this))");
        return hexString;
    }

    @NotNull
    public static final String toDebugString(@NotNull Continuation<?> continuation) {
        Object obj;
        Intrinsics.checkParameterIsNotNull(continuation, "$this$toDebugString");
        if (continuation instanceof DispatchedContinuation) {
            return continuation.toString();
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m4853constructorimpl(continuation + '@' + getHexAddress(continuation));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m4853constructorimpl(ResultKt.createFailure(th));
        }
        Throwable r2 = Result.m4856exceptionOrNullimpl(obj);
        String str = obj;
        if (r2 != null) {
            str = continuation.getClass().getName() + '@' + getHexAddress(continuation);
        }
        return (String) str;
    }

    @NotNull
    public static final String getClassSimpleName(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "$this$classSimpleName");
        String simpleName = obj.getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this::class.java.simpleName");
        return simpleName;
    }
}
