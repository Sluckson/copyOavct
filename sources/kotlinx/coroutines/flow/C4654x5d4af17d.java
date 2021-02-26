package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo66933d2 = {"<anonymous>", "", "T", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__DelayKt$debounce$2$1$1"}, mo66934k = 3, mo66935mv = {1, 1, 15})
/* renamed from: kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1 */
/* compiled from: Delay.kt */
final class C4654x5d4af17d extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector $downstream$inlined;
    final /* synthetic */ Ref.ObjectRef $lastValue$inlined;
    final /* synthetic */ ReceiveChannel $values$inlined;
    Object L$0;
    int label;
    private Object p$0;
    final /* synthetic */ FlowKt__DelayKt$debounce$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C4654x5d4af17d(Continuation continuation, FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$2, ReceiveChannel receiveChannel, Ref.ObjectRef objectRef, FlowCollector flowCollector) {
        super(2, continuation);
        this.this$0 = flowKt__DelayKt$debounce$2;
        this.$values$inlined = receiveChannel;
        this.$lastValue$inlined = objectRef;
        this.$downstream$inlined = flowCollector;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        C4654x5d4af17d flowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1 = new C4654x5d4af17d(continuation, this.this$0, this.$values$inlined, this.$lastValue$inlined, this.$downstream$inlined);
        flowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1.p$0 = obj;
        return flowKt__DelayKt$debounce$2$invokeSuspend$$inlined$select$lambda$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((C4654x5d4af17d) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            T t = this.p$0;
            if (t != null) {
                this.$lastValue$inlined.element = t;
                return Unit.INSTANCE;
            } else if (this.$lastValue$inlined.element != null) {
                FlowCollector flowCollector = this.$downstream$inlined;
                T t2 = NullSurrogateKt.NULL;
                T t3 = this.$lastValue$inlined.element;
                if (t3 == t2) {
                    t3 = null;
                }
                this.L$0 = t;
                this.label = 1;
                if (flowCollector.emit(t3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1) {
            Object obj2 = this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.$lastValue$inlined.element = NullSurrogateKt.DONE;
        return Unit.INSTANCE;
    }
}
