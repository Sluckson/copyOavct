package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ranges.LongRange;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, mo66933d2 = {"kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: SafeCollector.kt */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 implements Flow<Long> {
    final /* synthetic */ LongRange $this_asFlow$inlined;

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(LongRange longRange) {
        this.$this_asFlow$inlined = longRange;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r13) {
        /*
            r11 = this;
            boolean r0 = r13 instanceof kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10.C46431
            if (r0 == 0) goto L_0x0014
            r0 = r13
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1 r0 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10.C46431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1 r0 = new kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1
            r0.<init>(r11, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0053
            if (r2 != r3) goto L_0x004b
            long r4 = r0.J$0
            java.lang.Object r12 = r0.L$6
            java.lang.Object r12 = r0.L$5
            java.util.Iterator r12 = (java.util.Iterator) r12
            java.lang.Object r2 = r0.L$4
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.lang.Object r4 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
            java.lang.Object r5 = r0.L$2
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            java.lang.Object r6 = r0.L$1
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            java.lang.Object r7 = r0.L$0
            kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 r7 = (kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10) r7
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r4
            r4 = r2
            r2 = r6
            r6 = r1
            r1 = r7
            goto L_0x0068
        L_0x004b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r13)
            r13 = r0
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            kotlin.ranges.LongRange r2 = r11.$this_asFlow$inlined
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r4 = r2.iterator()
            r5 = r13
            r6 = r1
            r1 = r11
            r13 = r12
            r12 = r4
            r4 = r2
            r2 = r13
        L_0x0068:
            boolean r7 = r12.hasNext()
            if (r7 == 0) goto L_0x0096
            java.lang.Object r7 = r12.next()
            r8 = r7
            java.lang.Number r8 = (java.lang.Number) r8
            long r8 = r8.longValue()
            java.lang.Long r10 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)
            r0.L$0 = r1
            r0.L$1 = r2
            r0.L$2 = r5
            r0.L$3 = r13
            r0.L$4 = r4
            r0.L$5 = r12
            r0.L$6 = r7
            r0.J$0 = r8
            r0.label = r3
            java.lang.Object r7 = r13.emit(r10, r0)
            if (r7 != r6) goto L_0x0068
            return r6
        L_0x0096:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
