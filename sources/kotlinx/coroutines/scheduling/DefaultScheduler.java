package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.DispatchersKt;
import kotlinx.coroutines.InternalCoroutinesApi;
import kotlinx.coroutines.internal.SystemPropsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, mo66933d2 = {"Lkotlinx/coroutines/scheduling/DefaultScheduler;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "()V", "IO", "Lkotlinx/coroutines/CoroutineDispatcher;", "getIO", "()Lkotlinx/coroutines/CoroutineDispatcher;", "close", "", "toDebugString", "", "toString", "kotlinx-coroutines-core"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: Dispatcher.kt */
public final class DefaultScheduler extends ExperimentalCoroutineDispatcher {
    public static final DefaultScheduler INSTANCE;
    @NotNull

    /* renamed from: IO */
    private static final CoroutineDispatcher f5498IO;

    @NotNull
    public String toString() {
        return TasksKt.DEFAULT_SCHEDULER_NAME;
    }

    static {
        DefaultScheduler defaultScheduler = new DefaultScheduler();
        INSTANCE = defaultScheduler;
        f5498IO = defaultScheduler.blocking(SystemPropsKt__SystemProps_commonKt.systemProp$default(DispatchersKt.IO_PARALLELISM_PROPERTY_NAME, RangesKt.coerceAtLeast(64, SystemPropsKt.getAVAILABLE_PROCESSORS()), 0, 0, 12, (Object) null));
    }

    private DefaultScheduler() {
        super(0, 0, (String) null, 7, (DefaultConstructorMarker) null);
    }

    @NotNull
    public final CoroutineDispatcher getIO() {
        return f5498IO;
    }

    public void close() {
        throw new UnsupportedOperationException("DefaultDispatcher cannot be closed");
    }

    @NotNull
    @InternalCoroutinesApi
    public final String toDebugString() {
        return super.toString();
    }
}