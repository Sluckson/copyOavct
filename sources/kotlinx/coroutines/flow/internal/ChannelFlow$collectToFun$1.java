package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo66933d2 = {"<anonymous>", "", "T", "it", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.flow.internal.ChannelFlow$collectToFun$1", mo67567f = "ChannelFlow.kt", mo67568i = {0}, mo67569l = {62}, mo67570m = "invokeSuspend", mo67571n = {"it"}, mo67572s = {"L$0"})
/* compiled from: ChannelFlow.kt */
final class ChannelFlow$collectToFun$1 extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    private ProducerScope p$0;
    final /* synthetic */ ChannelFlow this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelFlow$collectToFun$1(ChannelFlow channelFlow, Continuation continuation) {
        super(2, continuation);
        this.this$0 = channelFlow;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelFlow$collectToFun$1 channelFlow$collectToFun$1 = new ChannelFlow$collectToFun$1(this.this$0, continuation);
        channelFlow$collectToFun$1.p$0 = (ProducerScope) obj;
        return channelFlow$collectToFun$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelFlow$collectToFun$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = this.p$0;
            ChannelFlow channelFlow = this.this$0;
            this.L$0 = producerScope;
            this.label = 1;
            if (channelFlow.collectTo(producerScope, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ProducerScope producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
