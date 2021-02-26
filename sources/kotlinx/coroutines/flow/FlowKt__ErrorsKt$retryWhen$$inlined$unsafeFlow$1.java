package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function4;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, mo66933d2 = {"kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: SafeCollector.kt */
public final class FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 implements Flow<T> {
    final /* synthetic */ Function4 $predicate$inlined;
    final /* synthetic */ Flow $this_retryWhen$inlined;

    public FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1(Flow flow, Function4 function4) {
        this.$this_retryWhen$inlined = flow;
        this.$predicate$inlined = function4;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e9  */
    @org.jetbrains.annotations.Nullable
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.C46831
            if (r0 == 0) goto L_0x0014
            r0 = r15
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.C46831) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1$1
            r0.<init>(r13, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0082
            if (r2 == r5) goto L_0x006a
            if (r2 == r4) goto L_0x004f
            if (r2 != r3) goto L_0x0047
            java.lang.Object r14 = r0.L$4
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            long r6 = r0.J$0
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r8 = r0.L$2
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 r10 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) r10
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00d9
        L_0x0047:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x004f:
            java.lang.Object r14 = r0.L$4
            java.lang.Throwable r14 = (java.lang.Throwable) r14
            long r6 = r0.J$0
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r8 = r0.L$2
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 r10 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) r10
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00d6
        L_0x006a:
            int r14 = r0.I$0
            long r6 = r0.J$0
            java.lang.Object r2 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r8 = r0.L$2
            kotlin.coroutines.Continuation r8 = (kotlin.coroutines.Continuation) r8
            java.lang.Object r9 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r10 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1 r10 = (kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1) r10
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00a6
        L_0x0082:
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r0
            kotlin.coroutines.Continuation r15 = (kotlin.coroutines.Continuation) r15
            r6 = 0
            r10 = r13
            r2 = r14
            r9 = r2
            r8 = r15
        L_0x008e:
            r14 = 0
            kotlinx.coroutines.flow.Flow r15 = r10.$this_retryWhen$inlined
            r0.L$0 = r10
            r0.L$1 = r9
            r0.L$2 = r8
            r0.L$3 = r2
            r0.J$0 = r6
            r0.I$0 = r14
            r0.label = r5
            java.lang.Object r15 = kotlinx.coroutines.flow.FlowKt.catchImpl(r15, r2, r0)
            if (r15 != r1) goto L_0x00a6
            return r1
        L_0x00a6:
            java.lang.Throwable r15 = (java.lang.Throwable) r15
            if (r15 == 0) goto L_0x00e7
            kotlin.jvm.functions.Function4 r14 = r10.$predicate$inlined
            java.lang.Long r11 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            r0.L$0 = r10
            r0.L$1 = r9
            r0.L$2 = r8
            r0.L$3 = r2
            r0.J$0 = r6
            r0.L$4 = r15
            r0.label = r3
            r0.L$0 = r10
            r0.L$1 = r9
            r0.L$2 = r8
            r0.L$3 = r2
            r0.J$0 = r6
            r0.L$4 = r15
            r0.label = r4
            java.lang.Object r14 = r14.invoke(r2, r15, r11, r0)
            if (r14 != r1) goto L_0x00d3
            return r1
        L_0x00d3:
            r12 = r15
            r15 = r14
            r14 = r12
        L_0x00d6:
            if (r15 != r1) goto L_0x00d9
            return r1
        L_0x00d9:
            java.lang.Boolean r15 = (java.lang.Boolean) r15
            boolean r15 = r15.booleanValue()
            if (r15 == 0) goto L_0x00e6
            r14 = 1
            long r6 = r6 + r14
            r14 = 1
            goto L_0x00e7
        L_0x00e6:
            throw r14
        L_0x00e7:
            if (r14 != 0) goto L_0x008e
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retryWhen$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
