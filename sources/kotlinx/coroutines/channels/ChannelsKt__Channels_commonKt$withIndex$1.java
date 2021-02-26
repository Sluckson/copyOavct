package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo66933d2 = {"<anonymous>", "", "E", "Lkotlinx/coroutines/channels/ProducerScope;", "Lkotlin/collections/IndexedValue;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$withIndex$1", mo67567f = "Channels.common.kt", mo67568i = {0, 0, 1, 1, 1}, mo67569l = {1658, 1659}, mo67570m = "invokeSuspend", mo67571n = {"$this$produce", "index", "$this$produce", "index", "e"}, mo67572s = {"L$0", "I$0", "L$0", "I$0", "L$1"})
/* compiled from: Channels.common.kt */
final class ChannelsKt__Channels_commonKt$withIndex$1 extends SuspendLambda implements Function2<ProducerScope<? super IndexedValue<? extends E>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel $this_withIndex;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* renamed from: p$ */
    private ProducerScope f5432p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelsKt__Channels_commonKt$withIndex$1(ReceiveChannel receiveChannel, Continuation continuation) {
        super(2, continuation);
        this.$this_withIndex = receiveChannel;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        ChannelsKt__Channels_commonKt$withIndex$1 channelsKt__Channels_commonKt$withIndex$1 = new ChannelsKt__Channels_commonKt$withIndex$1(this.$this_withIndex, continuation);
        channelsKt__Channels_commonKt$withIndex$1.f5432p$ = (ProducerScope) obj;
        return channelsKt__Channels_commonKt$withIndex$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$withIndex$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x006b  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003d
            if (r1 == r3) goto L_0x002d
            if (r1 != r2) goto L_0x0025
            java.lang.Object r1 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r11.L$1
            int r4 = r11.I$0
            java.lang.Object r5 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r12)
            r12 = r11
            r9 = r5
            r5 = r0
            r0 = r9
            r10 = r4
            r4 = r1
            r1 = r10
            goto L_0x004c
        L_0x0025:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x002d:
            java.lang.Object r1 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r4 = r11.I$0
            java.lang.Object r5 = r11.L$0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            kotlin.ResultKt.throwOnFailure(r12)
            r6 = r0
            r0 = r11
            goto L_0x0063
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r12)
            kotlinx.coroutines.channels.ProducerScope r12 = r11.f5432p$
            r1 = 0
            kotlinx.coroutines.channels.ReceiveChannel r4 = r11.$this_withIndex
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
            r5 = r0
            r0 = r12
            r12 = r11
        L_0x004c:
            r12.L$0 = r0
            r12.I$0 = r1
            r12.L$1 = r4
            r12.label = r3
            java.lang.Object r6 = r4.hasNext(r12)
            if (r6 != r5) goto L_0x005b
            return r5
        L_0x005b:
            r9 = r0
            r0 = r12
            r12 = r6
            r6 = r5
            r5 = r9
            r10 = r4
            r4 = r1
            r1 = r10
        L_0x0063:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L_0x008d
            java.lang.Object r12 = r1.next()
            kotlin.collections.IndexedValue r7 = new kotlin.collections.IndexedValue
            int r8 = r4 + 1
            r7.<init>(r4, r12)
            r0.L$0 = r5
            r0.I$0 = r8
            r0.L$1 = r12
            r0.L$2 = r1
            r0.label = r2
            java.lang.Object r12 = r5.send(r7, r0)
            if (r12 != r6) goto L_0x0087
            return r6
        L_0x0087:
            r12 = r0
            r4 = r1
            r0 = r5
            r5 = r6
            r1 = r8
            goto L_0x004c
        L_0x008d:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$withIndex$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
