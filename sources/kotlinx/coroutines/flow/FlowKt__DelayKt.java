package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.FlowCoroutineKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a&\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006*\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u0004H\u0000\u001a&\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\f\u001a\u00020\u0004H\u0007¨\u0006\r"}, mo66933d2 = {"debounce", "Lkotlinx/coroutines/flow/Flow;", "T", "timeoutMillis", "", "fixedPeriodTicker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "", "Lkotlinx/coroutines/CoroutineScope;", "delayMillis", "initialDelayMillis", "sample", "periodMillis", "kotlinx-coroutines-core"}, mo66934k = 5, mo66935mv = {1, 1, 15}, mo66938xs = "kotlinx/coroutines/flow/FlowKt")
/* compiled from: Delay.kt */
final /* synthetic */ class FlowKt__DelayKt {
    @NotNull
    @FlowPreview
    public static final <T> Flow<T> debounce(@NotNull Flow<? extends T> flow, long j) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$debounce");
        if (j > 0) {
            return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$debounce$2(flow, j, (Continuation) null));
        }
        throw new IllegalArgumentException("Debounce timeout should be positive".toString());
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> sample(@NotNull Flow<? extends T> flow, long j) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$sample");
        if (j > 0) {
            return FlowCoroutineKt.scopedFlow(new FlowKt__DelayKt$sample$2(flow, j, (Continuation) null));
        }
        throw new IllegalArgumentException("Sample period should be positive".toString());
    }

    public static /* synthetic */ ReceiveChannel fixedPeriodTicker$default(CoroutineScope coroutineScope, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        return FlowKt.fixedPeriodTicker(coroutineScope, j, j2);
    }

    @NotNull
    public static final ReceiveChannel<Unit> fixedPeriodTicker(@NotNull CoroutineScope coroutineScope, long j, long j2) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "$this$fixedPeriodTicker");
        boolean z = true;
        if (j >= 0) {
            if (j2 < 0) {
                z = false;
            }
            if (z) {
                return ProduceKt.produce$default(coroutineScope, (CoroutineContext) null, 0, new FlowKt__DelayKt$fixedPeriodTicker$3(j2, j, (Continuation) null), 1, (Object) null);
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
    }
}
