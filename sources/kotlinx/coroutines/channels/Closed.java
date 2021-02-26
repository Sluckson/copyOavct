package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0016\u001a\u00020\u00122\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J!\u0010\u001a\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00028\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001f"}, mo66933d2 = {"Lkotlinx/coroutines/channels/Closed;", "E", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "closeCause", "", "(Ljava/lang/Throwable;)V", "offerResult", "getOfferResult", "()Lkotlinx/coroutines/channels/Closed;", "pollResult", "getPollResult", "receiveException", "getReceiveException", "()Ljava/lang/Throwable;", "sendException", "getSendException", "completeResumeReceive", "", "token", "", "completeResumeSend", "resumeSendClosed", "closed", "toString", "", "tryResumeReceive", "value", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryResumeSend", "kotlinx-coroutines-core"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: AbstractChannel.kt */
public final class Closed<E> extends Send implements ReceiveOrClosed<E> {
    @Nullable
    @JvmField
    public final Throwable closeCause;

    @NotNull
    public Closed<E> getOfferResult() {
        return this;
    }

    @NotNull
    public Closed<E> getPollResult() {
        return this;
    }

    public Closed(@Nullable Throwable th) {
        this.closeCause = th;
    }

    @NotNull
    public final Throwable getSendException() {
        Throwable th = this.closeCause;
        return th != null ? th : new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
    }

    @NotNull
    public final Throwable getReceiveException() {
        Throwable th = this.closeCause;
        return th != null ? th : new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
    }

    @Nullable
    public Object tryResumeSend(@Nullable Object obj) {
        return AbstractChannelKt.CLOSE_RESUMED;
    }

    public void completeResumeSend(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "token");
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(obj == AbstractChannelKt.CLOSE_RESUMED)) {
                throw new AssertionError();
            }
        }
    }

    @Nullable
    public Object tryResumeReceive(E e, @Nullable Object obj) {
        return AbstractChannelKt.CLOSE_RESUMED;
    }

    public void completeResumeReceive(@NotNull Object obj) {
        Intrinsics.checkParameterIsNotNull(obj, "token");
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(obj == AbstractChannelKt.CLOSE_RESUMED)) {
                throw new AssertionError();
            }
        }
    }

    public void resumeSendClosed(@NotNull Closed<?> closed) {
        Intrinsics.checkParameterIsNotNull(closed, "closed");
        if (DebugKt.getASSERTIONS_ENABLED()) {
            throw new AssertionError();
        }
    }

    @NotNull
    public String toString() {
        return "Closed[" + this.closeCause + ']';
    }
}
