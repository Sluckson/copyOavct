package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H@¢\u0006\u0004\b\b\u0010\t"}, mo66933d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "cause", "", "attempt", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", mo67567f = "Errors.kt", mo67568i = {0, 0, 0}, mo67569l = {126}, mo67570m = "invokeSuspend", mo67571n = {"$this$retryWhen", "cause", "attempt"}, mo67572s = {"L$0", "L$1", "J$0"})
/* compiled from: Errors.kt */
final class FlowKt__ErrorsKt$retry$3 extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function2 $predicate;
    final /* synthetic */ long $retries;
    long J$0;
    Object L$0;
    Object L$1;
    int label;

    /* renamed from: p$ */
    private FlowCollector f5445p$;
    private Throwable p$0;
    private long p$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__ErrorsKt$retry$3(long j, Function2 function2, Continuation continuation) {
        super(4, continuation);
        this.$retries = j;
        this.$predicate = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th, long j, @NotNull Continuation<? super Boolean> continuation) {
        Intrinsics.checkParameterIsNotNull(flowCollector, "$this$create");
        Intrinsics.checkParameterIsNotNull(th, "cause");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        FlowKt__ErrorsKt$retry$3 flowKt__ErrorsKt$retry$3 = new FlowKt__ErrorsKt$retry$3(this.$retries, this.$predicate, continuation);
        flowKt__ErrorsKt$retry$3.f5445p$ = flowCollector;
        flowKt__ErrorsKt$retry$3.p$0 = th;
        flowKt__ErrorsKt$retry$3.p$1 = j;
        return flowKt__ErrorsKt$retry$3;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return ((FlowKt__ErrorsKt$retry$3) create((FlowCollector) obj, (Throwable) obj2, ((Number) obj3).longValue(), (Continuation) obj4)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        if (((java.lang.Boolean) r9).booleanValue() != false) goto L_0x004b;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 1
            if (r1 == 0) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            long r0 = r8.J$0
            java.lang.Object r0 = r8.L$1
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            java.lang.Object r0 = r8.L$0
            kotlinx.coroutines.flow.FlowCollector r0 = (kotlinx.coroutines.flow.FlowCollector) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0041
        L_0x0019:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.flow.FlowCollector r9 = r8.f5445p$
            java.lang.Throwable r1 = r8.p$0
            long r3 = r8.p$1
            long r5 = r8.$retries
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x004a
            kotlin.jvm.functions.Function2 r5 = r8.$predicate
            r8.L$0 = r9
            r8.L$1 = r1
            r8.J$0 = r3
            r8.label = r2
            java.lang.Object r9 = r5.invoke(r1, r8)
            if (r9 != r0) goto L_0x0041
            return r0
        L_0x0041:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L_0x004a
            goto L_0x004b
        L_0x004a:
            r2 = 0
        L_0x004b:
            java.lang.Boolean r9 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
