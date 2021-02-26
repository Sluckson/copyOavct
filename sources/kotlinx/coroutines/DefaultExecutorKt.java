package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, mo66933d2 = {"DefaultDelay", "Lkotlinx/coroutines/Delay;", "getDefaultDelay", "()Lkotlinx/coroutines/Delay;", "kotlinx-coroutines-core"}, mo66934k = 2, mo66935mv = {1, 1, 15})
/* compiled from: DefaultExecutor.kt */
public final class DefaultExecutorKt {
    @NotNull
    private static final Delay DefaultDelay = DefaultExecutor.INSTANCE;

    @NotNull
    public static final Delay getDefaultDelay() {
        return DefaultDelay;
    }
}
