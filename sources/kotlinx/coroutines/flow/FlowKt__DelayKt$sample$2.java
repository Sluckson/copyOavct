package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, mo66933d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "downstream", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2", mo67567f = "Delay.kt", mo67568i = {0, 0, 0, 0, 0}, mo67569l = {137}, mo67570m = "invokeSuspend", mo67571n = {"$this$scopedFlow", "downstream", "values", "lastValue", "ticker"}, mo67572s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: Delay.kt */
final class FlowKt__DelayKt$sample$2 extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $periodMillis;
    final /* synthetic */ Flow $this_sample;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f5440p$;
    private FlowCollector p$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FlowKt__DelayKt$sample$2(Flow flow, long j, Continuation continuation) {
        super(3, continuation);
        this.$this_sample = flow;
        this.$periodMillis = j;
    }

    @NotNull
    public final Continuation<Unit> create(@NotNull CoroutineScope coroutineScope, @NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(coroutineScope, "$this$create");
        Intrinsics.checkParameterIsNotNull(flowCollector, "downstream");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        FlowKt__DelayKt$sample$2 flowKt__DelayKt$sample$2 = new FlowKt__DelayKt$sample$2(this.$this_sample, this.$periodMillis, continuation);
        flowKt__DelayKt$sample$2.f5440p$ = coroutineScope;
        flowKt__DelayKt$sample$2.p$0 = flowCollector;
        return flowKt__DelayKt$sample$2;
    }

    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return ((FlowKt__DelayKt$sample$2) create((CoroutineScope) obj, (FlowCollector) obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(12:9|(2:10|11)|12|13|14|15|21|(1:23)|(1:25)|26|7|(1:27)(0)) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00bb, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x00bc, code lost:
        r3 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00c3, code lost:
        r3.handleBuilderException(r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00d5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x006c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r20) {
        /*
            r19 = this;
            r1 = r19
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r2 = r1.L$5
            kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2 r2 = (kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2) r2
            java.lang.Object r2 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r2 = (kotlinx.coroutines.channels.ReceiveChannel) r2
            java.lang.Object r4 = r1.L$3
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r5 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r1.L$1
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            java.lang.Object r7 = r1.L$0
            kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
            kotlin.ResultKt.throwOnFailure(r20)
            r15 = r0
            r14 = r2
            r13 = r4
            r12 = r5
            r11 = r6
            r4 = r7
            r2 = r1
            goto L_0x00d6
        L_0x0031:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r20)
            kotlinx.coroutines.CoroutineScope r2 = r1.f5440p$
            kotlinx.coroutines.flow.FlowCollector r11 = r1.p$0
            r5 = 0
            r6 = -1
            kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1 r4 = new kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1
            r10 = 0
            r4.<init>(r1, r10)
            r7 = r4
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r8 = 1
            r9 = 0
            r4 = r2
            kotlinx.coroutines.channels.ReceiveChannel r12 = kotlinx.coroutines.channels.ProduceKt.produce$default(r4, r5, r6, r7, r8, r9)
            kotlin.jvm.internal.Ref$ObjectRef r13 = new kotlin.jvm.internal.Ref$ObjectRef
            r13.<init>()
            r13.element = r10
            long r5 = r1.$periodMillis
            r7 = 0
            r9 = 2
            kotlinx.coroutines.channels.ReceiveChannel r4 = kotlinx.coroutines.flow.FlowKt__DelayKt.fixedPeriodTicker$default(r4, r5, r7, r9, r10)
            r15 = r0
            r14 = r4
            r4 = r2
            r2 = r1
        L_0x0066:
            T r0 = r13.element
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.flow.internal.NullSurrogateKt.DONE
            if (r0 == r5) goto L_0x00d8
            r2.L$0 = r4
            r2.L$1 = r11
            r2.L$2 = r12
            r2.L$3 = r13
            r2.L$4 = r14
            r2.L$5 = r2
            r2.label = r3
            r10 = r2
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            kotlinx.coroutines.selects.SelectBuilderImpl r9 = new kotlinx.coroutines.selects.SelectBuilderImpl
            r9.<init>(r10)
            r0 = r9
            kotlinx.coroutines.selects.SelectBuilder r0 = (kotlinx.coroutines.selects.SelectBuilder) r0     // Catch:{ Throwable -> 0x00bf }
            kotlinx.coroutines.selects.SelectClause1 r8 = r12.getOnReceiveOrNull()     // Catch:{ Throwable -> 0x00bf }
            kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1 r16 = new kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$1     // Catch:{ Throwable -> 0x00bf }
            r6 = 0
            r5 = r16
            r7 = r12
            r3 = r8
            r8 = r14
            r17 = r9
            r9 = r13
            r18 = r10
            r10 = r11
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x00bb }
            r5 = r16
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ Throwable -> 0x00bb }
            r0.invoke(r3, r5)     // Catch:{ Throwable -> 0x00bb }
            kotlinx.coroutines.selects.SelectClause1 r3 = r14.getOnReceive()     // Catch:{ Throwable -> 0x00bb }
            kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2 r16 = new kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$invokeSuspend$$inlined$select$lambda$2     // Catch:{ Throwable -> 0x00bb }
            r6 = 0
            r5 = r16
            r7 = r12
            r8 = r14
            r9 = r13
            r10 = r11
            r5.<init>(r6, r7, r8, r9, r10)     // Catch:{ Throwable -> 0x00bb }
            r5 = r16
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ Throwable -> 0x00bb }
            r0.invoke(r3, r5)     // Catch:{ Throwable -> 0x00bb }
            r3 = r17
            goto L_0x00c6
        L_0x00bb:
            r0 = move-exception
            r3 = r17
            goto L_0x00c3
        L_0x00bf:
            r0 = move-exception
            r18 = r10
            r3 = r9
        L_0x00c3:
            r3.handleBuilderException(r0)
        L_0x00c6:
            java.lang.Object r0 = r3.getResult()
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r3) goto L_0x00d3
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r18)
        L_0x00d3:
            if (r0 != r15) goto L_0x00d6
            return r15
        L_0x00d6:
            r3 = 1
            goto L_0x0066
        L_0x00d8:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
