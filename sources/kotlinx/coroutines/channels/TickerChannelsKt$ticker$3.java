package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.TickerChannelsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo66933d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.channels.TickerChannelsKt$ticker$3", mo67567f = "TickerChannels.kt", mo67568i = {0, 1}, mo67569l = {72, 73}, mo67570m = "invokeSuspend", mo67571n = {"$this$produce", "$this$produce"}, mo67572s = {"L$0", "L$0"})
/* compiled from: TickerChannels.kt */
final class TickerChannelsKt$ticker$3 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMillis;
    final /* synthetic */ long $initialDelayMillis;
    final /* synthetic */ TickerMode $mode;
    Object L$0;
    int label;

    /* renamed from: p$ */
    private ProducerScope f5434p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TickerChannelsKt$ticker$3(TickerMode tickerMode, long j, long j2, Continuation continuation) {
        super(2, continuation);
        this.$mode = tickerMode;
        this.$delayMillis = j;
        this.$initialDelayMillis = j2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        TickerChannelsKt$ticker$3 tickerChannelsKt$ticker$3 = new TickerChannelsKt$ticker$3(this.$mode, this.$delayMillis, this.$initialDelayMillis, continuation);
        tickerChannelsKt$ticker$3.f5434p$ = (ProducerScope) obj;
        return tickerChannelsKt$ticker$3;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((TickerChannelsKt$ticker$3) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = this.f5434p$;
            int i2 = TickerChannelsKt.WhenMappings.$EnumSwitchMapping$0[this.$mode.ordinal()];
            if (i2 == 1) {
                long j = this.$delayMillis;
                long j2 = this.$initialDelayMillis;
                SendChannel channel = producerScope.getChannel();
                this.L$0 = producerScope;
                this.label = 1;
                if (TickerChannelsKt.fixedPeriodTicker(j, j2, channel, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i2 == 2) {
                long j3 = this.$delayMillis;
                long j4 = this.$initialDelayMillis;
                SendChannel channel2 = producerScope.getChannel();
                this.L$0 = producerScope;
                this.label = 2;
                if (TickerChannelsKt.fixedDelayTicker(j3, j4, channel2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1 || i == 2) {
            ProducerScope producerScope2 = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
