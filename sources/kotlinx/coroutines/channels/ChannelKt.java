package kotlinx.coroutines.channels;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo66933d2 = {"Channel", "Lkotlinx/coroutines/channels/Channel;", "E", "capacity", "", "kotlinx-coroutines-core"}, mo66934k = 2, mo66935mv = {1, 1, 15})
/* compiled from: Channel.kt */
public final class ChannelKt {
    public static /* synthetic */ Channel Channel$default(int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return Channel(i);
    }

    @NotNull
    public static final <E> Channel<E> Channel(int i) {
        if (i == -2) {
            return new ArrayChannel<>(Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core());
        }
        if (i == -1) {
            return new ConflatedChannel<>();
        }
        if (i == 0) {
            return new RendezvousChannel<>();
        }
        if (i != Integer.MAX_VALUE) {
            return new ArrayChannel<>(i);
        }
        return new LinkedListChannel<>();
    }
}
