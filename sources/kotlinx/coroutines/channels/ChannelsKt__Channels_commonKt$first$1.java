package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H@"}, mo66933d2 = {"first", "", "E", "Lkotlinx/coroutines/channels/ReceiveChannel;", "continuation", "Lkotlin/coroutines/Continuation;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", mo67567f = "Channels.common.kt", mo67568i = {0, 0, 0, 0, 0}, mo67569l = {318}, mo67570m = "first", mo67571n = {"$this$first", "$this$consume$iv", "cause$iv", "$this$consume", "iterator"}, mo67572s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$first$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    ChannelsKt__Channels_commonKt$first$1(Continuation continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt.first((ReceiveChannel) null, this);
    }
}
