package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, mo66933d2 = {"kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: SafeCollector.kt */
public final class FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$3 implements Flow<R> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ Function3 $transform$inlined;

    public FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$3(Flow flow, Function3 function3) {
        this.$this_unsafeTransform$inlined = flow;
        this.$transform$inlined = function3;
    }

    @Nullable
    public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        return this.$this_unsafeTransform$inlined.collect(new C4761xc1e60f5c(flowCollector, this), continuation);
    }

    @Nullable
    public Object collect$$forInline(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$3 this$0;

            {
                this.this$0 = r1;
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.collect((FlowCollector) null, this);
            }
        };
        InlineMarker.mark(5);
        InlineMarker.mark(0);
        this.$this_unsafeTransform$inlined.collect(new C4761xc1e60f5c(flowCollector, this), continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
