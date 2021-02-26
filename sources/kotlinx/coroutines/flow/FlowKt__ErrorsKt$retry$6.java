package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H@¢\u0006\u0004\b\b\u0010\t"}, mo66933d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "cause", "", "attempt", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$6", mo67567f = "Errors.kt", mo67568i = {}, mo67569l = {}, mo67570m = "invokeSuspend", mo67571n = {}, mo67572s = {})
/* compiled from: Errors.kt */
final class FlowKt__ErrorsKt$retry$6 extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function1 $predicate;
    final /* synthetic */ int $retries;
    int label;

    /* renamed from: p$ */
    private FlowCollector f5446p$;
    private Throwable p$0;
    private long p$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__ErrorsKt$retry$6(int i, Function1 function1, Continuation continuation) {
        super(4, continuation);
        this.$retries = i;
        this.$predicate = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th, long j, @NotNull Continuation<? super Boolean> continuation) {
        Intrinsics.checkParameterIsNotNull(flowCollector, "$this$create");
        Intrinsics.checkParameterIsNotNull(th, "cause");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        FlowKt__ErrorsKt$retry$6 flowKt__ErrorsKt$retry$6 = new FlowKt__ErrorsKt$retry$6(this.$retries, this.$predicate, continuation);
        flowKt__ErrorsKt$retry$6.f5446p$ = flowCollector;
        flowKt__ErrorsKt$retry$6.p$0 = th;
        flowKt__ErrorsKt$retry$6.p$1 = j;
        return flowKt__ErrorsKt$retry$6;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return ((FlowKt__ErrorsKt$retry$6) create((FlowCollector) obj, (Throwable) obj2, ((Number) obj3).longValue(), (Continuation) obj4)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.f5446p$;
            return Boxing.boxBoolean(((Boolean) this.$predicate.invoke(this.p$0)).booleanValue() && this.p$1 < ((long) this.$retries));
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
