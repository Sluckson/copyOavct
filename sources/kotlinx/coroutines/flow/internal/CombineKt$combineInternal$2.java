package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo66933d2 = {"<anonymous>", "", "R", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", mo67567f = "Combine.kt", mo67568i = {0, 0, 0, 0, 0}, mo67569l = {146}, mo67570m = "invokeSuspend", mo67571n = {"$this$coroutineScope", "size", "channels", "latestValues", "isClosed"}, mo67572s = {"L$0", "I$0", "L$1", "L$2", "L$3"})
/* compiled from: Combine.kt */
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $arrayFactory;
    final /* synthetic */ Flow[] $flows;
    final /* synthetic */ FlowCollector $this_combineInternal;
    final /* synthetic */ Function3 $transform;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f5490p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$combineInternal$2(FlowCollector flowCollector, Flow[] flowArr, Function0 function0, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_combineInternal = flowCollector;
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$this_combineInternal, this.$flows, this.$arrayFactory, this.$transform, continuation);
        combineKt$combineInternal$2.f5490p$ = (CoroutineScope) obj;
        return combineKt$combineInternal$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$combineInternal$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0097 A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r26) {
        /*
            r25 = this;
            r1 = r25
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r4) goto L_0x0033
            java.lang.Object r2 = r1.L$4
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2 r2 = (kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2) r2
            java.lang.Object r2 = r1.L$3
            java.lang.Boolean[] r2 = (java.lang.Boolean[]) r2
            java.lang.Object r5 = r1.L$2
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            java.lang.Object r6 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel[] r6 = (kotlinx.coroutines.channels.ReceiveChannel[]) r6
            int r7 = r1.I$0
            java.lang.Object r8 = r1.L$0
            kotlinx.coroutines.CoroutineScope r8 = (kotlinx.coroutines.CoroutineScope) r8
            kotlin.ResultKt.throwOnFailure(r26)
            r15 = r0
            r9 = r5
            r5 = r8
            r8 = r2
            r2 = r1
            r24 = r7
            r7 = r6
            r6 = r24
            goto L_0x0128
        L_0x0033:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r26)
            kotlinx.coroutines.CoroutineScope r2 = r1.f5490p$
            kotlinx.coroutines.flow.Flow[] r5 = r1.$flows
            int r5 = r5.length
            kotlinx.coroutines.channels.ReceiveChannel[] r6 = new kotlinx.coroutines.channels.ReceiveChannel[r5]
            r7 = 0
        L_0x0046:
            if (r7 >= r5) goto L_0x005f
            java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r7)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            kotlinx.coroutines.flow.Flow[] r9 = r1.$flows
            r8 = r9[r8]
            kotlinx.coroutines.channels.ReceiveChannel r8 = kotlinx.coroutines.flow.internal.CombineKt.asFairChannel(r2, r8)
            r6[r7] = r8
            int r7 = r7 + 1
            goto L_0x0046
        L_0x005f:
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.Boolean[] r8 = new java.lang.Boolean[r5]
            r9 = 0
        L_0x0064:
            if (r9 >= r5) goto L_0x0078
            java.lang.Integer r10 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r9)
            java.lang.Number r10 = (java.lang.Number) r10
            r10.intValue()
            java.lang.Boolean r10 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r8[r9] = r10
            int r9 = r9 + 1
            goto L_0x0064
        L_0x0078:
            r15 = r0
            r9 = r7
            r7 = r6
            r6 = r5
            r5 = r2
            r2 = r1
        L_0x007e:
            int r0 = r8.length
            r10 = 0
        L_0x0080:
            if (r10 >= r0) goto L_0x0097
            r11 = r8[r10]
            boolean r11 = r11.booleanValue()
            java.lang.Boolean r11 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r11)
            boolean r11 = r11.booleanValue()
            if (r11 != 0) goto L_0x0094
            r0 = 0
            goto L_0x0098
        L_0x0094:
            int r10 = r10 + 1
            goto L_0x0080
        L_0x0097:
            r0 = 1
        L_0x0098:
            if (r0 != 0) goto L_0x012c
            r2.L$0 = r5
            r2.I$0 = r6
            r2.L$1 = r7
            r2.L$2 = r9
            r2.L$3 = r8
            r2.L$4 = r2
            r2.label = r4
            r14 = r2
            kotlin.coroutines.Continuation r14 = (kotlin.coroutines.Continuation) r14
            kotlinx.coroutines.selects.SelectBuilderImpl r13 = new kotlinx.coroutines.selects.SelectBuilderImpl
            r13.<init>(r14)
            r0 = r13
            kotlinx.coroutines.selects.SelectBuilder r0 = (kotlinx.coroutines.selects.SelectBuilder) r0     // Catch:{ Throwable -> 0x010f }
            r12 = 0
        L_0x00b4:
            if (r12 >= r6) goto L_0x010a
            r10 = r8[r12]     // Catch:{ Throwable -> 0x010f }
            boolean r18 = r10.booleanValue()     // Catch:{ Throwable -> 0x010f }
            r19 = r7[r12]     // Catch:{ Throwable -> 0x010f }
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1 r20 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1     // Catch:{ Throwable -> 0x010f }
            r16 = 0
            r10 = r20
            r11 = r12
            r21 = r12
            r12 = r16
            r3 = r13
            r13 = r2
            r22 = r14
            r14 = r6
            r4 = r15
            r15 = r8
            r16 = r7
            r17 = r9
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ Throwable -> 0x0108 }
            r11 = r20
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11     // Catch:{ Throwable -> 0x0108 }
            if (r18 == 0) goto L_0x00de
            goto L_0x00ff
        L_0x00de:
            kotlinx.coroutines.selects.SelectClause1 r15 = r19.getOnReceiveOrNull()     // Catch:{ Throwable -> 0x0108 }
            kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2 r19 = new kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2     // Catch:{ Throwable -> 0x0108 }
            r12 = 0
            r10 = r19
            r13 = r21
            r14 = r2
            r23 = r15
            r15 = r6
            r16 = r8
            r17 = r7
            r18 = r9
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ Throwable -> 0x0108 }
            r10 = r19
            kotlin.jvm.functions.Function2 r10 = (kotlin.jvm.functions.Function2) r10     // Catch:{ Throwable -> 0x0108 }
            r11 = r23
            r0.invoke(r11, r10)     // Catch:{ Throwable -> 0x0108 }
        L_0x00ff:
            int r12 = r21 + 1
            r13 = r3
            r15 = r4
            r14 = r22
            r3 = 0
            r4 = 1
            goto L_0x00b4
        L_0x0108:
            r0 = move-exception
            goto L_0x0114
        L_0x010a:
            r3 = r13
            r22 = r14
            r4 = r15
            goto L_0x0117
        L_0x010f:
            r0 = move-exception
            r3 = r13
            r22 = r14
            r4 = r15
        L_0x0114:
            r3.handleBuilderException(r0)
        L_0x0117:
            java.lang.Object r0 = r3.getResult()
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            if (r0 != r3) goto L_0x0124
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r22)
        L_0x0124:
            if (r0 != r4) goto L_0x0127
            return r4
        L_0x0127:
            r15 = r4
        L_0x0128:
            r3 = 0
            r4 = 1
            goto L_0x007e
        L_0x012c:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
