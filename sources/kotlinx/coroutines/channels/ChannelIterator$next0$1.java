package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.channels.ChannelIterator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, mo66933d2 = {"next0", "", "E", "continuation", "Lkotlin/coroutines/Continuation;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", mo67567f = "Channel.kt", mo67568i = {0}, mo67569l = {461}, mo67570m = "next", mo67571n = {"$this"}, mo67572s = {"L$0"})
/* compiled from: Channel.kt */
final class ChannelIterator$next0$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChannelIterator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelIterator$next0$1(ChannelIterator channelIterator, Continuation continuation) {
        super(continuation);
        this.this$0 = channelIterator;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        ChannelIterator channelIterator = this.this$0;
        return ChannelIterator.DefaultImpls.next((ChannelIterator) null, this);
    }
}
