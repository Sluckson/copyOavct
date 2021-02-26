package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, mo66933d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2", mo67567f = "Combine.kt", mo67568i = {0, 0, 0, 0, 0, 0, 0}, mo67569l = {144}, mo67570m = "invokeSuspend", mo67571n = {"$this$coroutineScope", "firstChannel", "secondChannel", "firstValue", "secondValue", "firstIsClosed", "secondIsClosed"}, mo67572s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
/* compiled from: Combine.kt */
final class CombineKt$combineTransformInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow $first;
    final /* synthetic */ Flow $second;
    final /* synthetic */ FlowCollector $this_combineTransformInternal;
    final /* synthetic */ Function4 $transform;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f5491p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$combineTransformInternal$2(FlowCollector flowCollector, Flow flow, Flow flow2, Function4 function4, Continuation continuation) {
        super(2, continuation);
        this.$this_combineTransformInternal = flowCollector;
        this.$first = flow;
        this.$second = flow2;
        this.$transform = function4;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        CombineKt$combineTransformInternal$2 combineKt$combineTransformInternal$2 = new CombineKt$combineTransformInternal$2(this.$this_combineTransformInternal, this.$first, this.$second, this.$transform, continuation);
        combineKt$combineTransformInternal$2.f5491p$ = (CoroutineScope) obj;
        return combineKt$combineTransformInternal$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$combineTransformInternal$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(1:(2:3|37)(2:4|5))(1:6)|7|(14:13|14|15|16|17|18|(1:20)(1:21)|22|(1:24)(1:25)|30|(1:32)|33|(1:35)(4:36|37|7|(0)(2:11|12))|35)(0)|9|13|14|15|16|17|18|(0)(0)|22|(0)(0)|30|(0)|33|(0)|35) */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x012a, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x012c, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x012d, code lost:
        r3 = r13;
        r22 = r14;
        r23 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0132, code lost:
        r3.handleBuilderException(r0);
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c4 A[Catch:{ Throwable -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c5 A[Catch:{ Throwable -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0105 A[Catch:{ Throwable -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0106 A[Catch:{ Throwable -> 0x012a }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x013f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0146 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0147  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r28) {
        /*
            r27 = this;
            r1 = r27
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 1
            if (r2 == 0) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r2 = r1.L$7
            kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2 r2 = (kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2) r2
            java.lang.Object r2 = r1.L$6
            kotlin.jvm.internal.Ref$BooleanRef r2 = (kotlin.jvm.internal.Ref.BooleanRef) r2
            java.lang.Object r4 = r1.L$5
            kotlin.jvm.internal.Ref$BooleanRef r4 = (kotlin.jvm.internal.Ref.BooleanRef) r4
            java.lang.Object r5 = r1.L$4
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r6 = r1.L$3
            kotlin.jvm.internal.Ref$ObjectRef r6 = (kotlin.jvm.internal.Ref.ObjectRef) r6
            java.lang.Object r7 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r8 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r9 = r1.L$0
            kotlinx.coroutines.CoroutineScope r9 = (kotlinx.coroutines.CoroutineScope) r9
            kotlin.ResultKt.throwOnFailure(r28)
            r15 = r0
            r10 = r2
            r2 = r1
            r26 = r7
            r7 = r4
            r4 = r8
            r8 = r5
            r5 = r26
            goto L_0x0148
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r28)
            kotlinx.coroutines.CoroutineScope r2 = r1.f5491p$
            kotlinx.coroutines.flow.Flow r4 = r1.$first
            kotlinx.coroutines.channels.ReceiveChannel r4 = kotlinx.coroutines.flow.internal.CombineKt.asFairChannel(r2, r4)
            kotlinx.coroutines.flow.Flow r5 = r1.$second
            kotlinx.coroutines.channels.ReceiveChannel r5 = kotlinx.coroutines.flow.internal.CombineKt.asFairChannel(r2, r5)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            r7 = 0
            r6.element = r7
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef
            r8.<init>()
            r8.element = r7
            kotlin.jvm.internal.Ref$BooleanRef r7 = new kotlin.jvm.internal.Ref$BooleanRef
            r7.<init>()
            r9 = 0
            r7.element = r9
            kotlin.jvm.internal.Ref$BooleanRef r10 = new kotlin.jvm.internal.Ref$BooleanRef
            r10.<init>()
            r10.element = r9
            r15 = r0
            r9 = r2
            r2 = r1
        L_0x0076:
            boolean r0 = r7.element
            if (r0 == 0) goto L_0x0082
            boolean r0 = r10.element
            if (r0 != 0) goto L_0x007f
            goto L_0x0082
        L_0x007f:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0082:
            r2.L$0 = r9
            r2.L$1 = r4
            r2.L$2 = r5
            r2.L$3 = r6
            r2.L$4 = r8
            r2.L$5 = r7
            r2.L$6 = r10
            r2.L$7 = r2
            r2.label = r3
            r14 = r2
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
            kotlinx.coroutines.selects.SelectBuilderImpl r13 = new kotlinx.coroutines.selects.SelectBuilderImpl
            r13.<init>(r14)
            r0 = r13
            kotlinx.coroutines.selects.SelectBuilder r0 = (kotlinx.coroutines.selects.SelectBuilder) r0     // Catch:{ Throwable -> 0x012c }
            boolean r12 = r7.element     // Catch:{ Throwable -> 0x012c }
            kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1 r20 = new kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$1     // Catch:{ Throwable -> 0x012c }
            r16 = 0
            r11 = r20
            r21 = r12
            r12 = r16
            r3 = r13
            r13 = r2
            r22 = r14
            r14 = r7
            r23 = r15
            r15 = r4
            r16 = r6
            r17 = r8
            r18 = r10
            r19 = r5
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Throwable -> 0x012a }
            r12 = r20
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12     // Catch:{ Throwable -> 0x012a }
            if (r21 == 0) goto L_0x00c5
            goto L_0x00e8
        L_0x00c5:
            kotlinx.coroutines.selects.SelectClause1 r15 = r4.getOnReceiveOrNull()     // Catch:{ Throwable -> 0x012a }
            kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$2 r21 = new kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$2     // Catch:{ Throwable -> 0x012a }
            r13 = 0
            r11 = r21
            r14 = r2
            r24 = r15
            r15 = r7
            r16 = r4
            r17 = r6
            r18 = r8
            r19 = r10
            r20 = r5
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ Throwable -> 0x012a }
            r11 = r21
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11     // Catch:{ Throwable -> 0x012a }
            r12 = r24
            r0.invoke(r12, r11)     // Catch:{ Throwable -> 0x012a }
        L_0x00e8:
            boolean r15 = r10.element     // Catch:{ Throwable -> 0x012a }
            kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3 r20 = new kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$3     // Catch:{ Throwable -> 0x012a }
            r12 = 0
            r11 = r20
            r13 = r2
            r14 = r7
            r21 = r15
            r15 = r4
            r16 = r6
            r17 = r8
            r18 = r10
            r19 = r5
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)     // Catch:{ Throwable -> 0x012a }
            r12 = r20
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12     // Catch:{ Throwable -> 0x012a }
            if (r21 == 0) goto L_0x0106
            goto L_0x0135
        L_0x0106:
            kotlinx.coroutines.selects.SelectClause1 r15 = r5.getOnReceiveOrNull()     // Catch:{ Throwable -> 0x012a }
            kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4 r21 = new kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2$invokeSuspend$$inlined$select$lambda$4     // Catch:{ Throwable -> 0x012a }
            r13 = 0
            r11 = r21
            r14 = r2
            r25 = r15
            r15 = r7
            r16 = r4
            r17 = r6
            r18 = r8
            r19 = r10
            r20 = r5
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ Throwable -> 0x012a }
            r11 = r21
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11     // Catch:{ Throwable -> 0x012a }
            r12 = r25
            r0.invoke(r12, r11)     // Catch:{ Throwable -> 0x012a }
            goto L_0x0135
        L_0x012a:
            r0 = move-exception
            goto L_0x0132
        L_0x012c:
            r0 = move-exception
            r3 = r13
            r22 = r14
            r23 = r15
        L_0x0132:
            r3.handleBuilderException(r0)
        L_0x0135:
            java.lang.Object r0 = r3.getResult()
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r3) goto L_0x0142
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r22)
        L_0x0142:
            r3 = r23
            if (r0 != r3) goto L_0x0147
            return r3
        L_0x0147:
            r15 = r3
        L_0x0148:
            r3 = 1
            goto L_0x0076
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineTransformInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
