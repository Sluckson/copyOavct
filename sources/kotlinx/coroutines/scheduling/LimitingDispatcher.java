package kotlinx.coroutines.scheduling;

import com.iaai.android.old.utils.constants.Constants;
import com.lowagie.text.html.Markup;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ#\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u0015\u001a\u00020\f2\n\u0010\u0014\u001a\u00060\u0012j\u0002`\u00132\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0015\u0010\u0019J\u001b\u0010\u001b\u001a\u00020\f2\n\u0010\u001a\u001a\u00060\u0012j\u0002`\u0013H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0005\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0019\u0010\u0007\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010(R \u0010*\u001a\f\u0012\b\u0012\u00060\u0012j\u0002`\u00130)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001c\u0010\t\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010,\u001a\u0004\b-\u0010.¨\u0006/"}, mo66933d2 = {"Lkotlinx/coroutines/scheduling/LimitingDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/scheduling/TaskContext;", "Ljava/util/concurrent/Executor;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "dispatcher", "", "parallelism", "Lkotlinx/coroutines/scheduling/TaskMode;", "taskMode", "<init>", "(Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;ILkotlinx/coroutines/scheduling/TaskMode;)V", "", "afterTask", "()V", "close", "Lkotlin/coroutines/CoroutineContext;", "context", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "", "fair", "(Ljava/lang/Runnable;Z)V", "command", "execute", "(Ljava/lang/Runnable;)V", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/scheduling/ExperimentalCoroutineDispatcher;", "getExecutor", "()Ljava/util/concurrent/Executor;", "executor", "I", "getParallelism", "()I", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "queue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlinx/coroutines/scheduling/TaskMode;", "getTaskMode", "()Lkotlinx/coroutines/scheduling/TaskMode;", "kotlinx-coroutines-core"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: Dispatcher.kt */
final class LimitingDispatcher extends ExecutorCoroutineDispatcher implements TaskContext, Executor {
    private static final AtomicIntegerFieldUpdater inFlightTasks$FU = AtomicIntegerFieldUpdater.newUpdater(LimitingDispatcher.class, "inFlightTasks");
    @NotNull
    private final ExperimentalCoroutineDispatcher dispatcher;
    private volatile int inFlightTasks = 0;
    private final int parallelism;
    private final ConcurrentLinkedQueue<Runnable> queue = new ConcurrentLinkedQueue<>();
    @NotNull
    private final TaskMode taskMode;

    @NotNull
    public final ExperimentalCoroutineDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final int getParallelism() {
        return this.parallelism;
    }

    @NotNull
    public TaskMode getTaskMode() {
        return this.taskMode;
    }

    public LimitingDispatcher(@NotNull ExperimentalCoroutineDispatcher experimentalCoroutineDispatcher, int i, @NotNull TaskMode taskMode2) {
        Intrinsics.checkParameterIsNotNull(experimentalCoroutineDispatcher, "dispatcher");
        Intrinsics.checkParameterIsNotNull(taskMode2, "taskMode");
        this.dispatcher = experimentalCoroutineDispatcher;
        this.parallelism = i;
        this.taskMode = taskMode2;
    }

    @NotNull
    public Executor getExecutor() {
        return this;
    }

    public void execute(@NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, Constants.EXTRA_COMMAND);
        dispatch(runnable, false);
    }

    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher".toString());
    }

    public void dispatch(@NotNull CoroutineContext coroutineContext, @NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(coroutineContext, "context");
        Intrinsics.checkParameterIsNotNull(runnable, Markup.CSS_VALUE_BLOCK);
        dispatch(runnable, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0013  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void dispatch(java.lang.Runnable r3, boolean r4) {
        /*
            r2 = this;
        L_0x0000:
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = inFlightTasks$FU
            int r0 = r0.incrementAndGet(r2)
            int r1 = r2.parallelism
            if (r0 > r1) goto L_0x0013
            kotlinx.coroutines.scheduling.ExperimentalCoroutineDispatcher r0 = r2.dispatcher
            r1 = r2
            kotlinx.coroutines.scheduling.TaskContext r1 = (kotlinx.coroutines.scheduling.TaskContext) r1
            r0.dispatchWithContext$kotlinx_coroutines_core(r3, r1, r4)
            return
        L_0x0013:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r0 = r2.queue
            r0.add(r3)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r3 = inFlightTasks$FU
            int r3 = r3.decrementAndGet(r2)
            int r0 = r2.parallelism
            if (r3 < r0) goto L_0x0023
            return
        L_0x0023:
            java.util.concurrent.ConcurrentLinkedQueue<java.lang.Runnable> r3 = r2.queue
            java.lang.Object r3 = r3.poll()
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            if (r3 == 0) goto L_0x002e
            goto L_0x0000
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.scheduling.LimitingDispatcher.dispatch(java.lang.Runnable, boolean):void");
    }

    @NotNull
    public String toString() {
        return super.toString() + "[dispatcher = " + this.dispatcher + ']';
    }

    public void afterTask() {
        Runnable poll = this.queue.poll();
        if (poll != null) {
            this.dispatcher.dispatchWithContext$kotlinx_coroutines_core(poll, this, true);
            return;
        }
        inFlightTasks$FU.decrementAndGet(this);
        Runnable poll2 = this.queue.poll();
        if (poll2 != null) {
            dispatch(poll2, true);
        }
    }
}
