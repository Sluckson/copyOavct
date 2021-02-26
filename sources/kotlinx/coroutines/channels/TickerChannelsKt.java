package kotlinx.coroutines.channels;

import com.iaai.android.old.utils.constants.Constants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.ObsoleteCoroutinesApi;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a/\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, mo66933d2 = {"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, mo66934k = 2, mo66935mv = {1, 1, 15})
/* compiled from: TickerChannels.kt */
public final class TickerChannelsKt {

    @Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 15})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = new int[TickerMode.values().length];

        static {
            $EnumSwitchMapping$0[TickerMode.FIXED_PERIOD.ordinal()] = 1;
            $EnumSwitchMapping$0[TickerMode.FIXED_DELAY.ordinal()] = 2;
        }
    }

    public static /* synthetic */ ReceiveChannel ticker$default(long j, long j2, CoroutineContext coroutineContext, TickerMode tickerMode, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = j;
        }
        if ((i & 4) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 8) != 0) {
            tickerMode = TickerMode.FIXED_PERIOD;
        }
        return ticker(j, j2, coroutineContext, tickerMode);
    }

    @NotNull
    @ObsoleteCoroutinesApi
    public static final ReceiveChannel<Unit> ticker(long j, long j2, @NotNull CoroutineContext coroutineContext, @NotNull TickerMode tickerMode) {
        long j3 = j2;
        CoroutineContext coroutineContext2 = coroutineContext;
        Intrinsics.checkParameterIsNotNull(coroutineContext2, "context");
        Intrinsics.checkParameterIsNotNull(tickerMode, Constants.EXTRA_MODE);
        boolean z = true;
        if (j >= 0) {
            if (j3 < 0) {
                z = false;
            }
            if (z) {
                return ProduceKt.produce(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext2), 0, new TickerChannelsKt$ticker$3(tickerMode, j, j2, (Continuation) null));
            }
            throw new IllegalArgumentException(("Expected non-negative initial delay, but has " + j2 + " ms").toString());
        }
        throw new IllegalArgumentException(("Expected non-negative delay, but has " + j + " ms").toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ef, code lost:
        r2 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r2.nanoTime());
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0177 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ java.lang.Object fixedPeriodTicker(long r21, long r23, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> r25, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r26) {
        /*
            r0 = r23
            r2 = r26
            boolean r3 = r2 instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 r3 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1 r3 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedPeriodTicker$1
            r3.<init>(r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            if (r5 == 0) goto L_0x008c
            if (r5 == r9) goto L_0x007e
            if (r5 == r8) goto L_0x006d
            if (r5 == r7) goto L_0x0055
            if (r5 != r6) goto L_0x004d
            long r0 = r3.J$5
            long r0 = r3.J$4
            long r0 = r3.J$3
            long r9 = r3.J$2
            java.lang.Object r5 = r3.L$0
            kotlinx.coroutines.channels.SendChannel r5 = (kotlinx.coroutines.channels.SendChannel) r5
            long r11 = r3.J$1
            long r13 = r3.J$0
            kotlin.ResultKt.throwOnFailure(r2)
            r17 = r11
            r2 = 4
            r11 = r9
            r10 = r3
            goto L_0x0178
        L_0x004d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0055:
            long r0 = r3.J$6
            long r0 = r3.J$5
            long r0 = r3.J$4
            long r0 = r3.J$3
            long r9 = r3.J$2
            java.lang.Object r5 = r3.L$0
            kotlinx.coroutines.channels.SendChannel r5 = (kotlinx.coroutines.channels.SendChannel) r5
            long r11 = r3.J$1
            long r13 = r3.J$0
            kotlin.ResultKt.throwOnFailure(r2)
            r8 = 3
            goto L_0x0149
        L_0x006d:
            long r0 = r3.J$3
            long r9 = r3.J$2
            java.lang.Object r5 = r3.L$0
            kotlinx.coroutines.channels.SendChannel r5 = (kotlinx.coroutines.channels.SendChannel) r5
            long r11 = r3.J$1
            long r13 = r3.J$0
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00e9
        L_0x007e:
            long r0 = r3.J$2
            java.lang.Object r5 = r3.L$0
            kotlinx.coroutines.channels.SendChannel r5 = (kotlinx.coroutines.channels.SendChannel) r5
            long r9 = r3.J$1
            long r11 = r3.J$0
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00c8
        L_0x008c:
            kotlin.ResultKt.throwOnFailure(r2)
            kotlinx.coroutines.TimeSource r2 = kotlinx.coroutines.TimeSourceKt.getTimeSource()
            if (r2 == 0) goto L_0x00a4
            long r10 = r2.nanoTime()
            java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r10)
            if (r2 == 0) goto L_0x00a4
            long r10 = r2.longValue()
            goto L_0x00a8
        L_0x00a4:
            long r10 = java.lang.System.nanoTime()
        L_0x00a8:
            long r12 = kotlinx.coroutines.EventLoop_commonKt.delayToNanos(r23)
            long r10 = r10 + r12
            r12 = r21
            r3.J$0 = r12
            r3.J$1 = r0
            r5 = r25
            r3.L$0 = r5
            r3.J$2 = r10
            r3.label = r9
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r0, r3)
            if (r2 != r4) goto L_0x00c2
            return r4
        L_0x00c2:
            r19 = r10
            r11 = r12
            r9 = r0
            r0 = r19
        L_0x00c8:
            long r13 = kotlinx.coroutines.EventLoop_commonKt.delayToNanos(r11)
        L_0x00cc:
            long r0 = r0 + r13
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r3.J$0 = r11
            r3.J$1 = r9
            r3.L$0 = r5
            r3.J$2 = r0
            r3.J$3 = r13
            r3.label = r8
            java.lang.Object r2 = r5.send(r2, r3)
            if (r2 != r4) goto L_0x00e2
            return r4
        L_0x00e2:
            r19 = r0
            r0 = r13
            r13 = r11
            r11 = r9
            r9 = r19
        L_0x00e9:
            kotlinx.coroutines.TimeSource r2 = kotlinx.coroutines.TimeSourceKt.getTimeSource()
            if (r2 == 0) goto L_0x00fe
            long r15 = r2.nanoTime()
            java.lang.Long r2 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r15)
            if (r2 == 0) goto L_0x00fe
            long r15 = r2.longValue()
            goto L_0x0102
        L_0x00fe:
            long r15 = java.lang.System.nanoTime()
        L_0x0102:
            r6 = r15
            r15 = r3
            long r2 = r9 - r6
            r22 = r9
            r8 = 0
            long r2 = kotlin.ranges.RangesKt.coerceAtLeast((long) r2, (long) r8)
            int r10 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r10 != 0) goto L_0x0152
            int r10 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0152
            long r8 = r6 - r22
            long r8 = r8 % r0
            long r8 = r0 - r8
            r24 = r2
            long r2 = r6 + r8
            r17 = r6
            long r6 = kotlinx.coroutines.EventLoop_commonKt.delayNanosToMillis(r8)
            r10 = r15
            r10.J$0 = r13
            r10.J$1 = r11
            r10.L$0 = r5
            r10.J$2 = r2
            r10.J$3 = r0
            r22 = r2
            r2 = r17
            r10.J$4 = r2
            r2 = r24
            r10.J$5 = r2
            r10.J$6 = r8
            r8 = 3
            r10.label = r8
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r6, r10)
            if (r2 != r4) goto L_0x0146
            return r4
        L_0x0146:
            r3 = r10
            r9 = r22
        L_0x0149:
            r2 = 4
            r19 = r11
            r11 = r13
            r13 = r0
            r0 = r9
            r9 = r19
            goto L_0x0181
        L_0x0152:
            r10 = r15
            r19 = r2
            r2 = r6
            r6 = r19
            long r8 = kotlinx.coroutines.EventLoop_commonKt.delayNanosToMillis(r6)
            r10.J$0 = r13
            r10.J$1 = r11
            r10.L$0 = r5
            r17 = r11
            r11 = r22
            r10.J$2 = r11
            r10.J$3 = r0
            r10.J$4 = r2
            r10.J$5 = r6
            r2 = 4
            r10.label = r2
            java.lang.Object r3 = kotlinx.coroutines.DelayKt.delay(r8, r10)
            if (r3 != r4) goto L_0x0178
            return r4
        L_0x0178:
            r3 = r10
            r9 = r17
            r19 = r11
            r11 = r13
            r13 = r0
            r0 = r19
        L_0x0181:
            r6 = 4
            r7 = 3
            r8 = 2
            goto L_0x00cc
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.fixedPeriodTicker(long, long, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit>} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0092 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static final /* synthetic */ java.lang.Object fixedDelayTicker(long r8, long r10, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.SendChannel<? super kotlin.Unit> r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            boolean r0 = r13 instanceof kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = (kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1 r0 = new kotlinx.coroutines.channels.TickerChannelsKt$fixedDelayTicker$1
            r0.<init>(r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x005d
            if (r2 == r5) goto L_0x0050
            if (r2 == r4) goto L_0x0044
            if (r2 != r3) goto L_0x003c
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.channels.SendChannel r8 = (kotlinx.coroutines.channels.SendChannel) r8
            long r9 = r0.J$1
            long r11 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r13)
        L_0x0037:
            r6 = r11
            r12 = r8
            r10 = r9
            r8 = r6
            goto L_0x006f
        L_0x003c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0044:
            java.lang.Object r8 = r0.L$0
            kotlinx.coroutines.channels.SendChannel r8 = (kotlinx.coroutines.channels.SendChannel) r8
            long r9 = r0.J$1
            long r11 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0084
        L_0x0050:
            java.lang.Object r8 = r0.L$0
            r12 = r8
            kotlinx.coroutines.channels.SendChannel r12 = (kotlinx.coroutines.channels.SendChannel) r12
            long r10 = r0.J$1
            long r8 = r0.J$0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x006f
        L_0x005d:
            kotlin.ResultKt.throwOnFailure(r13)
            r0.J$0 = r8
            r0.J$1 = r10
            r0.L$0 = r12
            r0.label = r5
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r10, r0)
            if (r13 != r1) goto L_0x006f
            return r1
        L_0x006f:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            r0.J$0 = r8
            r0.J$1 = r10
            r0.L$0 = r12
            r0.label = r4
            java.lang.Object r13 = r12.send(r13, r0)
            if (r13 != r1) goto L_0x0080
            return r1
        L_0x0080:
            r6 = r8
            r8 = r12
            r9 = r10
            r11 = r6
        L_0x0084:
            r0.J$0 = r11
            r0.J$1 = r9
            r0.L$0 = r8
            r0.label = r3
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r11, r0)
            if (r13 != r1) goto L_0x0037
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.TickerChannelsKt.fixedDelayTicker(long, long, kotlinx.coroutines.channels.SendChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
