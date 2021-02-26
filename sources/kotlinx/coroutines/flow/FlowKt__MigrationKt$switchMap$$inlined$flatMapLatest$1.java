package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo66933d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1", mo67567f = "Migration.kt", mo67568i = {0, 0, 1, 1, 1, 1}, mo67569l = {154, 180}, mo67570m = "invokeSuspend", mo67571n = {"$this$transformLatest", "it", "$this$transformLatest", "it", "$this$emitAll$iv", "flow$iv"}, mo67572s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3"})
/* compiled from: Merge.kt */
public final class FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<FlowCollector<? super R>, T, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2 $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* renamed from: p$ */
    private FlowCollector f5458p$;
    private Object p$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(Function2 function2, Continuation continuation) {
        super(3, continuation);
        this.$transform = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull FlowCollector<? super R> flowCollector, T t, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(flowCollector, "$this$create");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1 = new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(this.$transform, continuation);
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.f5458p$ = flowCollector;
        flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1.p$0 = t;
        return flowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1) create((FlowCollector) obj, obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        FlowCollector flowCollector;
        Object obj2;
        FlowCollector flowCollector2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            flowCollector2 = this.f5458p$;
            Object obj3 = this.p$0;
            Function2 function2 = this.$transform;
            this.L$0 = flowCollector2;
            this.L$1 = obj3;
            this.L$2 = flowCollector2;
            this.label = 1;
            Object invoke = function2.invoke(obj3, this);
            if (invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector = flowCollector2;
            Object obj4 = invoke;
            obj2 = obj3;
            obj = obj4;
        } else if (i == 1) {
            flowCollector2 = (FlowCollector) this.L$2;
            obj2 = this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            Flow flow = (Flow) this.L$3;
            FlowCollector flowCollector3 = (FlowCollector) this.L$2;
            Object obj5 = this.L$1;
            FlowCollector flowCollector4 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Flow flow2 = (Flow) obj;
        this.L$0 = flowCollector;
        this.L$1 = obj2;
        this.L$2 = flowCollector2;
        this.L$3 = flow2;
        this.label = 2;
        if (flow2.collect(flowCollector2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
