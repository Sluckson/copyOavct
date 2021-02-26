package kotlinx.coroutines;

import com.lowagie.text.html.Markup;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\bj\u0002`\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo66933d2 = {"Lkotlinx/coroutines/DispatcherExecutor;", "Ljava/util/concurrent/Executor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "execute", "", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "toString", "", "kotlinx-coroutines-core"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: Executors.kt */
final class DispatcherExecutor implements Executor {
    @NotNull
    @JvmField
    public final CoroutineDispatcher dispatcher;

    public DispatcherExecutor(@NotNull CoroutineDispatcher coroutineDispatcher) {
        Intrinsics.checkParameterIsNotNull(coroutineDispatcher, "dispatcher");
        this.dispatcher = coroutineDispatcher;
    }

    public void execute(@NotNull Runnable runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, Markup.CSS_VALUE_BLOCK);
        this.dispatcher.dispatch(EmptyCoroutineContext.INSTANCE, runnable);
    }

    @NotNull
    public String toString() {
        return this.dispatcher.toString();
    }
}
