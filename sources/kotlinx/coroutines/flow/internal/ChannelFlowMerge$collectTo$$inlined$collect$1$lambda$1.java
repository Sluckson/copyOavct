package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, mo66933d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/ChannelFlowMerge$collectTo$2$1"}, mo66934k = 3, mo66935mv = {1, 1, 15})
/* compiled from: Merge.kt */
final class ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $inner;
    Object L$0;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f5483p$;
    final /* synthetic */ ChannelFlowMerge$collectTo$$inlined$collect$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1(Flow flow, Continuation continuation, ChannelFlowMerge$collectTo$$inlined$collect$1 channelFlowMerge$collectTo$$inlined$collect$1) {
        super(2, continuation);
        this.$inner = flow;
        this.this$0 = channelFlowMerge$collectTo$$inlined$collect$1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1 channelFlowMerge$collectTo$$inlined$collect$1$lambda$1 = new ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1(this.$inner, continuation, this.this$0);
        channelFlowMerge$collectTo$$inlined$collect$1$lambda$1.f5483p$ = (CoroutineScope) obj;
        return channelFlowMerge$collectTo$$inlined$collect$1$lambda$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelFlowMerge$collectTo$$inlined$collect$1$lambda$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = this.f5483p$;
            this.label = 1;
            if (this.$inner.collect(this.this$0.$collector$inlined, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th) {
                this.this$0.$semaphore$inlined.release();
                throw th;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.$semaphore$inlined.release();
        return Unit.INSTANCE;
    }
}
