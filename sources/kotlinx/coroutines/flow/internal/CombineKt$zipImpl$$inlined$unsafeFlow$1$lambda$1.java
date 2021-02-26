package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo66933d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$zipImpl$1$1"}, mo66934k = 3, mo66935mv = {1, 1, 15})
/* compiled from: Combine.kt */
final class CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FlowCollector $this_unsafeFlow;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f5487p$;
    final /* synthetic */ CombineKt$zipImpl$$inlined$unsafeFlow$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(FlowCollector flowCollector, Continuation continuation, CombineKt$zipImpl$$inlined$unsafeFlow$1 combineKt$zipImpl$$inlined$unsafeFlow$1) {
        super(2, continuation);
        this.$this_unsafeFlow = flowCollector;
        this.this$0 = combineKt$zipImpl$$inlined$unsafeFlow$1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 = new CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1(this.$this_unsafeFlow, continuation, this.this$0);
        combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.f5487p$ = (CoroutineScope) obj;
        return combineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v15, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v13, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v14, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v15, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v17, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v11, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v15, resolved type: kotlinx.coroutines.channels.ReceiveChannel} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x017a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0190 A[Catch:{ Throwable -> 0x0122 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01d7 A[Catch:{ Throwable -> 0x0122 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01da A[Catch:{ Throwable -> 0x0122 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01e6 A[Catch:{ Throwable -> 0x0122 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0215 A[Catch:{ Throwable -> 0x0122 }] */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0266  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r22) {
        /*
            r21 = this;
            r1 = r21
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r1.label
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0126
            if (r2 == r6) goto L_0x00e4
            if (r2 == r5) goto L_0x00a7
            if (r2 == r4) goto L_0x0051
            if (r2 != r3) goto L_0x0049
            java.lang.Object r2 = r1.L$11
            java.lang.Object r2 = r1.L$10
            java.lang.Object r2 = r1.L$9
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r8 = r1.L$8
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r9 = r1.L$7
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            java.lang.Object r10 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r11 = r1.L$5
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r11 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) r11
            java.lang.Object r12 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r12 = (kotlinx.coroutines.channels.ReceiveChannel) r12
            java.lang.Object r13 = r1.L$3
            kotlinx.coroutines.channels.ChannelIterator r13 = (kotlinx.coroutines.channels.ChannelIterator) r13
            java.lang.Object r14 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r14 = (kotlinx.coroutines.channels.ReceiveChannel) r14
            java.lang.Object r15 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r15 = (kotlinx.coroutines.channels.ReceiveChannel) r15
            java.lang.Object r3 = r1.L$0
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ Throwable -> 0x0122 }
            r5 = 4
            goto L_0x024b
        L_0x0049:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0051:
            java.lang.Object r2 = r1.L$12
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r3 = r1.L$11
            java.lang.Object r8 = r1.L$10
            java.lang.Object r9 = r1.L$9
            kotlinx.coroutines.channels.ChannelIterator r9 = (kotlinx.coroutines.channels.ChannelIterator) r9
            java.lang.Object r10 = r1.L$8
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r11 = r1.L$7
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            java.lang.Object r12 = r1.L$6
            kotlinx.coroutines.channels.ReceiveChannel r12 = (kotlinx.coroutines.channels.ReceiveChannel) r12
            java.lang.Object r13 = r1.L$5
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r13 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) r13
            java.lang.Object r14 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r14 = (kotlinx.coroutines.channels.ReceiveChannel) r14
            java.lang.Object r15 = r1.L$3
            kotlinx.coroutines.channels.ChannelIterator r15 = (kotlinx.coroutines.channels.ChannelIterator) r15
            java.lang.Object r4 = r1.L$2
            kotlinx.coroutines.channels.ReceiveChannel r4 = (kotlinx.coroutines.channels.ReceiveChannel) r4
            java.lang.Object r5 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r1.L$0
            kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ Throwable -> 0x00a1, all -> 0x009b }
            r7 = r0
            r0 = r22
            r19 = r6
            r6 = r3
            r3 = r19
            r20 = r14
            r14 = r4
            r4 = r9
            r9 = r11
            r11 = r13
            r13 = r15
            r15 = r5
            r5 = r8
            r8 = r10
            r10 = r12
        L_0x0097:
            r12 = r20
            goto L_0x0227
        L_0x009b:
            r0 = move-exception
            r14 = r4
            r9 = r11
            r10 = r12
            goto L_0x0278
        L_0x00a1:
            r0 = move-exception
            r9 = r0
            r14 = r4
            r10 = r12
            goto L_0x0277
        L_0x00a7:
            java.lang.Object r2 = r1.L$11
            java.lang.Object r3 = r1.L$10
            java.lang.Object r4 = r1.L$9
            kotlinx.coroutines.channels.ChannelIterator r4 = (kotlinx.coroutines.channels.ChannelIterator) r4
            java.lang.Object r5 = r1.L$8
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r1.L$7
            r9 = r6
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            java.lang.Object r6 = r1.L$6
            r10 = r6
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r6 = r1.L$5
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r6 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) r6
            java.lang.Object r8 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r11 = r1.L$3
            kotlinx.coroutines.channels.ChannelIterator r11 = (kotlinx.coroutines.channels.ChannelIterator) r11
            java.lang.Object r12 = r1.L$2
            r14 = r12
            kotlinx.coroutines.channels.ReceiveChannel r14 = (kotlinx.coroutines.channels.ReceiveChannel) r14
            java.lang.Object r12 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r12 = (kotlinx.coroutines.channels.ReceiveChannel) r12
            java.lang.Object r13 = r1.L$0
            kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ Throwable -> 0x0122 }
            r7 = r22
            r15 = r2
            r2 = r1
            r19 = r13
            r13 = r3
            r3 = r19
            goto L_0x01b7
        L_0x00e4:
            java.lang.Object r2 = r1.L$9
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r3 = r1.L$8
            kotlinx.coroutines.channels.ReceiveChannel r3 = (kotlinx.coroutines.channels.ReceiveChannel) r3
            java.lang.Object r4 = r1.L$7
            r9 = r4
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            java.lang.Object r4 = r1.L$6
            r10 = r4
            kotlinx.coroutines.channels.ReceiveChannel r10 = (kotlinx.coroutines.channels.ReceiveChannel) r10
            java.lang.Object r4 = r1.L$5
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1 r4 = (kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1) r4
            java.lang.Object r5 = r1.L$4
            kotlinx.coroutines.channels.ReceiveChannel r5 = (kotlinx.coroutines.channels.ReceiveChannel) r5
            java.lang.Object r6 = r1.L$3
            kotlinx.coroutines.channels.ChannelIterator r6 = (kotlinx.coroutines.channels.ChannelIterator) r6
            java.lang.Object r8 = r1.L$2
            r14 = r8
            kotlinx.coroutines.channels.ReceiveChannel r14 = (kotlinx.coroutines.channels.ReceiveChannel) r14
            java.lang.Object r8 = r1.L$1
            kotlinx.coroutines.channels.ReceiveChannel r8 = (kotlinx.coroutines.channels.ReceiveChannel) r8
            java.lang.Object r11 = r1.L$0
            kotlinx.coroutines.CoroutineScope r11 = (kotlinx.coroutines.CoroutineScope) r11
            kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ Throwable -> 0x0122 }
            r15 = r22
            r12 = r8
            r13 = 1
            r8 = r5
            r5 = r3
            r3 = r11
            r11 = r6
            r6 = r4
            r4 = r2
            r2 = r1
            goto L_0x0188
        L_0x011f:
            r0 = move-exception
            goto L_0x0278
        L_0x0122:
            r0 = move-exception
            r9 = r0
            goto L_0x0277
        L_0x0126:
            kotlin.ResultKt.throwOnFailure(r22)
            kotlinx.coroutines.CoroutineScope r2 = r1.f5487p$
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1 r3 = r1.this$0
            kotlinx.coroutines.flow.Flow r3 = r3.$flow$inlined
            kotlinx.coroutines.channels.ReceiveChannel r10 = kotlinx.coroutines.flow.internal.CombineKt.asChannel(r2, r3)
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1 r3 = r1.this$0
            kotlinx.coroutines.flow.Flow r3 = r3.$flow2$inlined
            kotlinx.coroutines.channels.ReceiveChannel r14 = kotlinx.coroutines.flow.internal.CombineKt.asChannel(r2, r3)
            if (r14 == 0) goto L_0x029e
            r3 = r14
            kotlinx.coroutines.channels.SendChannel r3 = (kotlinx.coroutines.channels.SendChannel) r3
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1 r4 = new kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1$1
            r4.<init>(r10)
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            r3.invokeOnClose(r4)
            kotlinx.coroutines.channels.ChannelIterator r3 = r14.iterator()
            r9 = r7
            java.lang.Throwable r9 = (java.lang.Throwable) r9     // Catch:{ AbortFlowException -> 0x028e, all -> 0x027c }
            kotlinx.coroutines.channels.ChannelIterator r4 = r10.iterator()     // Catch:{ Throwable -> 0x0122 }
            r12 = r0
            r0 = r1
            r5 = r3
            r6 = r10
            r8 = r6
            r11 = r8
            r3 = r2
            r2 = r0
        L_0x015d:
            r2.L$0 = r3     // Catch:{ Throwable -> 0x0274, all -> 0x0271 }
            r2.L$1 = r10     // Catch:{ Throwable -> 0x0274, all -> 0x0271 }
            r2.L$2 = r14     // Catch:{ Throwable -> 0x0274, all -> 0x0271 }
            r2.L$3 = r5     // Catch:{ Throwable -> 0x0274, all -> 0x0271 }
            r2.L$4 = r6     // Catch:{ Throwable -> 0x0274, all -> 0x0271 }
            r2.L$5 = r0     // Catch:{ Throwable -> 0x0274, all -> 0x0271 }
            r2.L$6 = r8     // Catch:{ Throwable -> 0x0274, all -> 0x0271 }
            r2.L$7 = r9     // Catch:{ Throwable -> 0x0274, all -> 0x0271 }
            r2.L$8 = r11     // Catch:{ Throwable -> 0x0274, all -> 0x0271 }
            r2.L$9 = r4     // Catch:{ Throwable -> 0x0274, all -> 0x0271 }
            r13 = 1
            r2.label = r13     // Catch:{ Throwable -> 0x0274, all -> 0x0271 }
            java.lang.Object r15 = r4.hasNext(r0)     // Catch:{ Throwable -> 0x0274, all -> 0x0271 }
            if (r15 != r12) goto L_0x017b
            return r12
        L_0x017b:
            r19 = r6
            r6 = r0
            r0 = r12
            r12 = r10
            r10 = r8
            r8 = r19
            r20 = r11
            r11 = r5
            r5 = r20
        L_0x0188:
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ Throwable -> 0x0122 }
            boolean r15 = r15.booleanValue()     // Catch:{ Throwable -> 0x0122 }
            if (r15 == 0) goto L_0x025b
            java.lang.Object r15 = r4.next()     // Catch:{ Throwable -> 0x0122 }
            r2.L$0 = r3     // Catch:{ Throwable -> 0x0122 }
            r2.L$1 = r12     // Catch:{ Throwable -> 0x0122 }
            r2.L$2 = r14     // Catch:{ Throwable -> 0x0122 }
            r2.L$3 = r11     // Catch:{ Throwable -> 0x0122 }
            r2.L$4 = r8     // Catch:{ Throwable -> 0x0122 }
            r2.L$5 = r6     // Catch:{ Throwable -> 0x0122 }
            r2.L$6 = r10     // Catch:{ Throwable -> 0x0122 }
            r2.L$7 = r9     // Catch:{ Throwable -> 0x0122 }
            r2.L$8 = r5     // Catch:{ Throwable -> 0x0122 }
            r2.L$9 = r4     // Catch:{ Throwable -> 0x0122 }
            r2.L$10 = r15     // Catch:{ Throwable -> 0x0122 }
            r2.L$11 = r15     // Catch:{ Throwable -> 0x0122 }
            r7 = 2
            r2.label = r7     // Catch:{ Throwable -> 0x0122 }
            java.lang.Object r7 = r11.hasNext(r2)     // Catch:{ Throwable -> 0x0122 }
            if (r7 != r0) goto L_0x01b6
            return r0
        L_0x01b6:
            r13 = r15
        L_0x01b7:
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ Throwable -> 0x0122 }
            boolean r7 = r7.booleanValue()     // Catch:{ Throwable -> 0x0122 }
            if (r7 != 0) goto L_0x01cb
            r1 = r5
            r5 = 4
            r19 = r12
            r12 = r0
            r0 = r6
            r6 = r8
            r8 = r10
            r10 = r19
            goto L_0x0254
        L_0x01cb:
            kotlinx.coroutines.flow.FlowCollector r7 = r2.$this_unsafeFlow     // Catch:{ Throwable -> 0x0122 }
            kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1 r1 = r2.this$0     // Catch:{ Throwable -> 0x0122 }
            kotlin.jvm.functions.Function3 r1 = r1.$transform$inlined     // Catch:{ Throwable -> 0x0122 }
            r16 = r0
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL     // Catch:{ Throwable -> 0x0122 }
            if (r15 != r0) goto L_0x01da
            r17 = 0
            goto L_0x01dc
        L_0x01da:
            r17 = r15
        L_0x01dc:
            kotlinx.coroutines.internal.Symbol r0 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL     // Catch:{ Throwable -> 0x0122 }
            r18 = r1
            java.lang.Object r1 = r11.next()     // Catch:{ Throwable -> 0x0122 }
            if (r1 != r0) goto L_0x01e7
            r1 = 0
        L_0x01e7:
            r2.L$0 = r3     // Catch:{ Throwable -> 0x0122 }
            r2.L$1 = r12     // Catch:{ Throwable -> 0x0122 }
            r2.L$2 = r14     // Catch:{ Throwable -> 0x0122 }
            r2.L$3 = r11     // Catch:{ Throwable -> 0x0122 }
            r2.L$4 = r8     // Catch:{ Throwable -> 0x0122 }
            r2.L$5 = r6     // Catch:{ Throwable -> 0x0122 }
            r2.L$6 = r10     // Catch:{ Throwable -> 0x0122 }
            r2.L$7 = r9     // Catch:{ Throwable -> 0x0122 }
            r2.L$8 = r5     // Catch:{ Throwable -> 0x0122 }
            r2.L$9 = r4     // Catch:{ Throwable -> 0x0122 }
            r2.L$10 = r13     // Catch:{ Throwable -> 0x0122 }
            r2.L$11 = r15     // Catch:{ Throwable -> 0x0122 }
            r2.L$12 = r7     // Catch:{ Throwable -> 0x0122 }
            r0 = 3
            r2.label = r0     // Catch:{ Throwable -> 0x0122 }
            r0 = r18
            r19 = r17
            r17 = r3
            r3 = r19
            java.lang.Object r0 = r0.invoke(r3, r1, r2)     // Catch:{ Throwable -> 0x0122 }
            r1 = r16
            if (r0 != r1) goto L_0x0215
            return r1
        L_0x0215:
            r3 = r17
            r19 = r7
            r7 = r1
            r1 = r2
            r2 = r19
            r20 = r8
            r8 = r5
            r5 = r13
            r13 = r11
            r11 = r6
            r6 = r15
            r15 = r12
            goto L_0x0097
        L_0x0227:
            r1.L$0 = r3     // Catch:{ Throwable -> 0x0122 }
            r1.L$1 = r15     // Catch:{ Throwable -> 0x0122 }
            r1.L$2 = r14     // Catch:{ Throwable -> 0x0122 }
            r1.L$3 = r13     // Catch:{ Throwable -> 0x0122 }
            r1.L$4 = r12     // Catch:{ Throwable -> 0x0122 }
            r1.L$5 = r11     // Catch:{ Throwable -> 0x0122 }
            r1.L$6 = r10     // Catch:{ Throwable -> 0x0122 }
            r1.L$7 = r9     // Catch:{ Throwable -> 0x0122 }
            r1.L$8 = r8     // Catch:{ Throwable -> 0x0122 }
            r1.L$9 = r4     // Catch:{ Throwable -> 0x0122 }
            r1.L$10 = r5     // Catch:{ Throwable -> 0x0122 }
            r1.L$11 = r6     // Catch:{ Throwable -> 0x0122 }
            r5 = 4
            r1.label = r5     // Catch:{ Throwable -> 0x0122 }
            java.lang.Object r0 = r2.emit(r0, r1)     // Catch:{ Throwable -> 0x0122 }
            if (r0 != r7) goto L_0x0249
            return r7
        L_0x0249:
            r2 = r4
            r0 = r7
        L_0x024b:
            r4 = r2
            r6 = r12
            r12 = r0
            r2 = r1
            r1 = r8
            r8 = r10
            r0 = r11
            r11 = r13
            r10 = r15
        L_0x0254:
            r7 = 0
            r5 = r11
            r11 = r1
            r1 = r21
            goto L_0x015d
        L_0x025b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ Throwable -> 0x0122 }
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r10, r9)     // Catch:{ AbortFlowException -> 0x028e, all -> 0x027c }
            boolean r0 = r14.isClosedForReceive()
            if (r0 != 0) goto L_0x029b
            kotlinx.coroutines.flow.internal.AbortFlowException r0 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r0.<init>()
        L_0x026b:
            java.util.concurrent.CancellationException r0 = (java.util.concurrent.CancellationException) r0
            r14.cancel((java.util.concurrent.CancellationException) r0)
            goto L_0x029b
        L_0x0271:
            r0 = move-exception
            r10 = r8
            goto L_0x0278
        L_0x0274:
            r0 = move-exception
            r9 = r0
            r10 = r8
        L_0x0277:
            throw r9     // Catch:{ all -> 0x011f }
        L_0x0278:
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r10, r9)     // Catch:{ AbortFlowException -> 0x028e, all -> 0x027c }
            throw r0     // Catch:{ AbortFlowException -> 0x028e, all -> 0x027c }
        L_0x027c:
            r0 = move-exception
            boolean r1 = r14.isClosedForReceive()
            if (r1 != 0) goto L_0x028d
            kotlinx.coroutines.flow.internal.AbortFlowException r1 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r1.<init>()
            java.util.concurrent.CancellationException r1 = (java.util.concurrent.CancellationException) r1
            r14.cancel((java.util.concurrent.CancellationException) r1)
        L_0x028d:
            throw r0
        L_0x028e:
            boolean r0 = r14.isClosedForReceive()
            if (r0 != 0) goto L_0x029b
            kotlinx.coroutines.flow.internal.AbortFlowException r0 = new kotlinx.coroutines.flow.internal.AbortFlowException
            r0.<init>()
            goto L_0x026b
        L_0x029b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x029e:
            kotlin.TypeCastException r0 = new kotlin.TypeCastException
            java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.channels.SendChannel<*>"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$$inlined$unsafeFlow$1$lambda$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
