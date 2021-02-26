package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo66933d2 = {"Lkotlinx/coroutines/PoolThread;", "Ljava/lang/Thread;", "dispatcher", "Lkotlinx/coroutines/ThreadPoolDispatcher;", "target", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "name", "", "(Lkotlinx/coroutines/ThreadPoolDispatcher;Ljava/lang/Runnable;Ljava/lang/String;)V", "kotlinx-coroutines-core"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: ThreadPoolDispatcher.kt */
public final class PoolThread extends Thread {
    @NotNull
    @JvmField
    public final ThreadPoolDispatcher dispatcher;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PoolThread(@NotNull ThreadPoolDispatcher threadPoolDispatcher, @NotNull Runnable runnable, @NotNull String str) {
        super(runnable, str);
        Intrinsics.checkParameterIsNotNull(threadPoolDispatcher, "dispatcher");
        Intrinsics.checkParameterIsNotNull(runnable, "target");
        Intrinsics.checkParameterIsNotNull(str, "name");
        this.dispatcher = threadPoolDispatcher;
        setDaemon(true);
    }
}