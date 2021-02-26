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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u0001H\u0001H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo66933d2 = {"<anonymous>", "E", "", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$requireNoNulls$1", mo67567f = "Channels.common.kt", mo67568i = {}, mo67569l = {}, mo67570m = "invokeSuspend", mo67571n = {}, mo67572s = {})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$requireNoNulls$1 extends SuspendLambda implements Function2<E, Continuation<? super E>, Object> {
    final /* synthetic */ ReceiveChannel $this_requireNoNulls;
    int label;
    private Object p$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$requireNoNulls$1(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.$this_requireNoNulls = receiveChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$requireNoNulls$1 channelsKt__Channels_commonKt$requireNoNulls$1 = new ChannelsKt__Channels_commonKt$requireNoNulls$1(this.$this_requireNoNulls, continuation);
        channelsKt__Channels_commonKt$requireNoNulls$1.p$0 = obj;
        return channelsKt__Channels_commonKt$requireNoNulls$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$requireNoNulls$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.p$0;
            if (obj2 != null) {
                return obj2;
            }
            throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + '.');
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
