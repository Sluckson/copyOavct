package kotlinx.coroutines;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u00032\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00070\u0006H@"}, mo66933d2 = {"awaitAll", "", "T", "", "Lkotlinx/coroutines/Deferred;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.AwaitKt", mo67567f = "Await.kt", mo67568i = {0}, mo67569l = {39}, mo67570m = "awaitAll", mo67571n = {"$this$awaitAll"}, mo67572s = {"L$0"})
/* compiled from: Await.kt */
final class AwaitKt$awaitAll$2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    AwaitKt$awaitAll$2(Continuation continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.awaitAll((Collection) null, this);
    }
}
