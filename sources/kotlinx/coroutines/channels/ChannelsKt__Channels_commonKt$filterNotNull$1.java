package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo66933d2 = {"<anonymous>", "", "E", "", "it", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$filterNotNull$1", mo67567f = "Channels.common.kt", mo67568i = {}, mo67569l = {}, mo67570m = "invokeSuspend", mo67571n = {}, mo67572s = {})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$filterNotNull$1 extends SuspendLambda implements Function2<E, Continuation<? super Boolean>, Object> {
    int label;
    private Object p$0;

    ChannelsKt__Channels_commonKt$filterNotNull$1(Continuation continuation) {
        super(2, continuation);
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$filterNotNull$1 channelsKt__Channels_commonKt$filterNotNull$1 = new ChannelsKt__Channels_commonKt$filterNotNull$1(continuation);
        channelsKt__Channels_commonKt$filterNotNull$1.p$0 = obj;
        return channelsKt__Channels_commonKt$filterNotNull$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$filterNotNull$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Boxing.boxBoolean(this.p$0 != null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
