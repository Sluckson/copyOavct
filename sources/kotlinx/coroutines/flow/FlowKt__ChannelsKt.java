package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.FlowPreview;
import kotlinx.coroutines.channels.BroadcastChannel;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.internal.ChannelFlowKt;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007\u001a0\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\u001a\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\nH\u0007\u001a/\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a&\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\n\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, mo66933d2 = {"asFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "Lkotlinx/coroutines/channels/BroadcastChannel;", "broadcastIn", "scope", "Lkotlinx/coroutines/CoroutineScope;", "start", "Lkotlinx/coroutines/CoroutineStart;", "consumeAsFlow", "Lkotlinx/coroutines/channels/ReceiveChannel;", "emitAll", "", "Lkotlinx/coroutines/flow/FlowCollector;", "channel", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "produceIn", "kotlinx-coroutines-core"}, mo66934k = 5, mo66935mv = {1, 1, 15}, mo66938xs = "kotlinx/coroutines/flow/FlowKt")
/* compiled from: Channels.kt */
final /* synthetic */ class FlowKt__ChannelsKt {
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
        r8 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a3, code lost:
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a6, code lost:
        throw r8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073 A[Catch:{ all -> 0x0057 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0080 A[Catch:{ all -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008c A[SYNTHETIC, Splitter:B:31:0x008c] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x008d A[Catch:{ all -> 0x0057 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    @org.jetbrains.annotations.Nullable
    @kotlinx.coroutines.ExperimentalCoroutinesApi
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> java.lang.Object emitAll(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r6, @org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.ReceiveChannel<? extends T> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAll$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAll$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAll$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAll$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAll$1
            r0.<init>(r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x005b
            if (r2 == r4) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r6 = r0.L$3
            java.lang.Object r6 = r0.L$2
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ Throwable -> 0x0059 }
            goto L_0x0063
        L_0x003b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0043:
            java.lang.Object r6 = r0.L$3
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            java.lang.Object r6 = r0.L$2
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            java.lang.Object r7 = r0.L$1
            kotlinx.coroutines.channels.ReceiveChannel r7 = (kotlinx.coroutines.channels.ReceiveChannel) r7
            java.lang.Object r2 = r0.L$0
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ Throwable -> 0x0059 }
            goto L_0x0074
        L_0x0057:
            r8 = move-exception
            goto L_0x00a3
        L_0x0059:
            r6 = move-exception
            goto L_0x00a2
        L_0x005b:
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = 0
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            r2 = r6
            r6 = r8
        L_0x0063:
            r0.L$0 = r2     // Catch:{ Throwable -> 0x0059 }
            r0.L$1 = r7     // Catch:{ Throwable -> 0x0059 }
            r0.L$2 = r6     // Catch:{ Throwable -> 0x0059 }
            r0.L$3 = r2     // Catch:{ Throwable -> 0x0059 }
            r0.label = r4     // Catch:{ Throwable -> 0x0059 }
            java.lang.Object r8 = r7.receiveOrClosed(r0)     // Catch:{ Throwable -> 0x0059 }
            if (r8 != r1) goto L_0x0074
            return r1
        L_0x0074:
            kotlinx.coroutines.channels.ValueOrClosed r8 = (kotlinx.coroutines.channels.ValueOrClosed) r8     // Catch:{ Throwable -> 0x0059 }
            java.lang.Object r8 = r8.m5871unboximpl()     // Catch:{ Throwable -> 0x0059 }
            boolean r5 = kotlinx.coroutines.channels.ValueOrClosed.m5869isClosedimpl(r8)     // Catch:{ Throwable -> 0x0059 }
            if (r5 == 0) goto L_0x008d
            java.lang.Throwable r8 = kotlinx.coroutines.channels.ValueOrClosed.m5865getCloseCauseimpl(r8)     // Catch:{ Throwable -> 0x0059 }
            if (r8 != 0) goto L_0x008c
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r6)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x008c:
            throw r8     // Catch:{ Throwable -> 0x0059 }
        L_0x008d:
            java.lang.Object r5 = kotlinx.coroutines.channels.ValueOrClosed.m5866getValueimpl(r8)     // Catch:{ Throwable -> 0x0059 }
            r0.L$0 = r2     // Catch:{ Throwable -> 0x0059 }
            r0.L$1 = r7     // Catch:{ Throwable -> 0x0059 }
            r0.L$2 = r6     // Catch:{ Throwable -> 0x0059 }
            r0.L$3 = r8     // Catch:{ Throwable -> 0x0059 }
            r0.label = r3     // Catch:{ Throwable -> 0x0059 }
            java.lang.Object r8 = r2.emit(r5, r0)     // Catch:{ Throwable -> 0x0059 }
            if (r8 != r1) goto L_0x0063
            return r1
        L_0x00a2:
            throw r6     // Catch:{ all -> 0x0057 }
        L_0x00a3:
            kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r7, r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.emitAll(kotlinx.coroutines.flow.FlowCollector, kotlinx.coroutines.channels.ReceiveChannel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> consumeAsFlow(@NotNull ReceiveChannel<? extends T> receiveChannel) {
        Intrinsics.checkParameterIsNotNull(receiveChannel, "$this$consumeAsFlow");
        return new ConsumeAsFlow<>(receiveChannel, (CoroutineContext) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ BroadcastChannel broadcastIn$default(Flow flow, CoroutineScope coroutineScope, CoroutineStart coroutineStart, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineStart = CoroutineStart.LAZY;
        }
        return FlowKt.broadcastIn(flow, coroutineScope, coroutineStart);
    }

    @NotNull
    @FlowPreview
    public static final <T> BroadcastChannel<T> broadcastIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope, @NotNull CoroutineStart coroutineStart) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$broadcastIn");
        Intrinsics.checkParameterIsNotNull(coroutineScope, "scope");
        Intrinsics.checkParameterIsNotNull(coroutineStart, TtmlNode.START);
        return ChannelFlowKt.asChannelFlow(flow).broadcastImpl(coroutineScope, coroutineStart);
    }

    @NotNull
    @FlowPreview
    public static final <T> ReceiveChannel<T> produceIn(@NotNull Flow<? extends T> flow, @NotNull CoroutineScope coroutineScope) {
        Intrinsics.checkParameterIsNotNull(flow, "$this$produceIn");
        Intrinsics.checkParameterIsNotNull(coroutineScope, "scope");
        return ChannelFlowKt.asChannelFlow(flow).produceImpl(coroutineScope);
    }

    @NotNull
    @FlowPreview
    public static final <T> Flow<T> asFlow(@NotNull BroadcastChannel<T> broadcastChannel) {
        Intrinsics.checkParameterIsNotNull(broadcastChannel, "$this$asFlow");
        return new FlowKt__ChannelsKt$asFlow$$inlined$unsafeFlow$1(broadcastChannel);
    }
}
