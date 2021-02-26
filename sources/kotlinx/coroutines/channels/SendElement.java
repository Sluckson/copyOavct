package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0014\u0010\f\u001a\u00020\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, mo66933d2 = {"Lkotlinx/coroutines/channels/SendElement;", "Lkotlinx/coroutines/channels/Send;", "pollResult", "", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "getPollResult", "()Ljava/lang/Object;", "completeResumeSend", "token", "resumeSendClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeSend", "idempotent", "kotlinx-coroutines-core"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: AbstractChannel.kt */
public final class SendElement extends Send {
    @NotNull
    @JvmField
    public final CancellableContinuation<Unit> cont;
    @Nullable
    private final Object pollResult;

    @Nullable
    public Object getPollResult() {
        return this.pollResult;
    }

    public SendElement(@Nullable Object obj, @NotNull CancellableContinuation<? super Unit> cancellableContinuation) {
        Intrinsics.checkParameterIsNotNull(cancellableContinuation, "cont");
        this.pollResult = obj;
        this.cont = cancellableContinuation;
    }

    @Nullable
    public Object tryResumeSend(@Nullable Object obj) {
        return this.cont.tryResume(Unit.INSTANCE, obj);
    }

    public void completeResumeSend(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "token");
        this.cont.completeResume(obj);
    }

    public void resumeSendClosed(@NotNull Closed<?> closed) {
        Intrinsics.checkParameterIsNotNull(closed, "closed");
        Throwable sendException = closed.getSendException();
        Result.Companion companion = Result.Companion;
        this.cont.resumeWith(Result.m4853constructorimpl(ResultKt.createFailure(sendException)));
    }

    @NotNull
    public String toString() {
        return "SendElement(" + getPollResult() + ')';
    }
}
