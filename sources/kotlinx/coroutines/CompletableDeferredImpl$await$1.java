package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H@"}, mo66933d2 = {"await", "", "T", "continuation", "Lkotlin/coroutines/Continuation;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.CompletableDeferredImpl", mo67567f = "CompletableDeferred.kt", mo67568i = {0}, mo67569l = {71}, mo67570m = "await", mo67571n = {"this"}, mo67572s = {"L$0"})
/* compiled from: CompletableDeferred.kt */
final class CompletableDeferredImpl$await$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CompletableDeferredImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CompletableDeferredImpl$await$1(CompletableDeferredImpl completableDeferredImpl, Continuation continuation) {
        super(continuation);
        this.this$0 = completableDeferredImpl;
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.await(this);
    }
}
