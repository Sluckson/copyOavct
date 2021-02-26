package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import kotlinx.coroutines.selects.SelectBuilder;
import kotlinx.coroutines.selects.SelectBuilderImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, mo66933d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounce$2", mo67567f = "Delay.kt", mo67568i = {0, 0, 0, 0}, mo67569l = {137}, mo67570m = "invokeSuspend", mo67571n = {"$this$scopedFlow", "downstream", "values", "lastValue"}, mo67572s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: Delay.kt */
final class FlowKt__DelayKt$debounce$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $this_debounce;
    final /* synthetic */ long $timeoutMillis;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f5437p$;
    private FlowCollector p$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$debounce$2(Flow flow, long j, Continuation continuation) {
        super(3, continuation);
        this.$this_debounce = flow;
        this.$timeoutMillis = j;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull CoroutineScope coroutineScope, @NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "$this$create");
        Intrinsics.checkParameterIsNotNull(flowCollector, "downstream");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$2 = new FlowKt__DelayKt$debounce$2(this.$this_debounce, this.$timeoutMillis, continuation);
        flowKt__DelayKt$debounce$2.f5437p$ = coroutineScope;
        flowKt__DelayKt$debounce$2.p$0 = flowCollector;
        return flowKt__DelayKt$debounce$2;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((FlowKt__DelayKt$debounce$2) create((CoroutineScope) obj, (FlowCollector) obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowCollector flowCollector;
        Object obj2;
        CoroutineScope coroutineScope;
        Ref.ObjectRef objectRef;
        ReceiveChannel receiveChannel;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = this.f5437p$;
            flowCollector = this.p$0;
            receiveChannel = ProduceKt.produce$default(coroutineScope2, (CoroutineContext) null, -1, new FlowKt__DelayKt$debounce$2$values$1(this, (Continuation) null), 1, (Object) null);
            objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            obj2 = coroutine_suspended;
            coroutineScope = coroutineScope2;
        } else if (i == 1) {
            FlowKt__DelayKt$debounce$2 flowKt__DelayKt$debounce$2 = (FlowKt__DelayKt$debounce$2) this.L$4;
            receiveChannel = (ReceiveChannel) this.L$2;
            coroutineScope = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            obj2 = coroutine_suspended;
            flowCollector = (FlowCollector) this.L$1;
            objectRef = (Ref.ObjectRef) this.L$3;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (objectRef.element != NullSurrogateKt.DONE) {
            this.L$0 = coroutineScope;
            this.L$1 = flowCollector;
            this.L$2 = receiveChannel;
            this.L$3 = objectRef;
            this.L$4 = this;
            this.label = 1;
            Continuation continuation = this;
            SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(continuation);
            try {
                SelectBuilder selectBuilder = selectBuilderImpl;
                selectBuilder.invoke(receiveChannel.getOnReceiveOrNull(), new C4654x5d4af17d((Continuation) null, this, receiveChannel, objectRef, flowCollector));
                T t = objectRef.element;
                if (t != null) {
                    selectBuilder.onTimeout(this.$timeoutMillis, new C4655x5d4af17e(t, (Continuation) null, selectBuilder, this, receiveChannel, objectRef, flowCollector));
                }
            } catch (Throwable th) {
                selectBuilderImpl.handleBuilderException(th);
            }
            Object result = selectBuilderImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
                continue;
            }
            if (result == obj2) {
                return obj2;
            }
        }
        return Unit.INSTANCE;
    }
}
