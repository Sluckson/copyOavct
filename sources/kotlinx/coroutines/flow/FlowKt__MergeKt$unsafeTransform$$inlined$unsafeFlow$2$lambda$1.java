package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.InlineMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0007"}, mo66933d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__MergeKt$$special$$inlined$collect$2"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: Collect.kt */
public final class FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1 implements FlowCollector<T> {
    final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
    final /* synthetic */ FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2 this$0;

    public FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1(FlowCollector flowCollector, FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2 flowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2) {
        this.$this_unsafeFlow$inlined = flowCollector;
        this.this$0 = flowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2;
    }

    @Nullable
    public Object emit(Object obj, @NotNull Continuation continuation) {
        return this.this$0.$transform$inlined.invoke(this.$this_unsafeFlow$inlined, obj, continuation);
    }

    @Nullable
    public Object emit$$forInline(Object obj, @NotNull Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) {
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__MergeKt$unsafeTransform$$inlined$unsafeFlow$2$lambda$1 this$0;

            {
                this.this$0 = r1;
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.emit((Object) null, this);
            }
        };
        InlineMarker.mark(5);
        return this.this$0.$transform$inlined.invoke(this.$this_unsafeFlow$inlined, obj, continuation);
    }
}
