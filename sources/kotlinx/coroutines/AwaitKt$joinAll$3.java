package kotlinx.coroutines;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H@"}, mo66933d2 = {"joinAll", "", "", "Lkotlinx/coroutines/Job;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.AwaitKt", mo67567f = "Await.kt", mo67568i = {0, 0, 0, 0}, mo67569l = {57}, mo67570m = "joinAll", mo67571n = {"$this$joinAll", "$this$forEach$iv", "element$iv", "it"}, mo67572s = {"L$0", "L$1", "L$3", "L$4"})
/* compiled from: Await.kt */
final class AwaitKt$joinAll$3 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;

    AwaitKt$joinAll$3(Continuation continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return AwaitKt.joinAll((Collection<? extends Job>) null, (Continuation<? super Unit>) this);
    }
}
