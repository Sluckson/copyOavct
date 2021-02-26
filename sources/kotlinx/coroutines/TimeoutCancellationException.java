package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0019\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo66933d2 = {"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "(Ljava/lang/String;)V", "coroutine", "Lkotlinx/coroutines/Job;", "(Ljava/lang/String;Lkotlinx/coroutines/Job;)V", "kotlinx-coroutines-core"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: Timeout.kt */
public final class TimeoutCancellationException extends CancellationException {
    @Nullable
    @JvmField
    public final Job coroutine;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TimeoutCancellationException(@NotNull String str, @Nullable Job job) {
        super(str);
        Intrinsics.checkParameterIsNotNull(str, "message");
        this.coroutine = job;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TimeoutCancellationException(@NotNull String str) {
        this(str, (Job) null);
        Intrinsics.checkParameterIsNotNull(str, "message");
    }
}
