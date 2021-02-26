package kotlin.sequences;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo66933d2 = {"<anonymous>", "", "T", "R", "Lkotlin/sequences/SequenceScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 16})
@DebugMetadata(mo67566c = "kotlin.sequences.SequencesKt___SequencesKt$scanIndexed$1", mo67567f = "_Sequences.kt", mo67568i = {0, 1, 1, 1, 1}, mo67569l = {1456, 1461}, mo67570m = "invokeSuspend", mo67571n = {"$this$sequence", "$this$sequence", "index", "accumulator", "element"}, mo67572s = {"L$0", "L$0", "I$0", "L$1", "L$2"})
/* compiled from: _Sequences.kt */
final class SequencesKt___SequencesKt$scanIndexed$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $initial;
    final /* synthetic */ Function3 $operation;
    final /* synthetic */ Sequence $this_scanIndexed;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* renamed from: p$ */
    private SequenceScope f5410p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SequencesKt___SequencesKt$scanIndexed$1(Sequence sequence, Object obj, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_scanIndexed = sequence;
        this.$initial = obj;
        this.$operation = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        SequencesKt___SequencesKt$scanIndexed$1 sequencesKt___SequencesKt$scanIndexed$1 = new SequencesKt___SequencesKt$scanIndexed$1(this.$this_scanIndexed, this.$initial, this.$operation, continuation);
        sequencesKt___SequencesKt$scanIndexed$1.f5410p$ = (SequenceScope) obj;
        return sequencesKt___SequencesKt$scanIndexed$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SequencesKt___SequencesKt$scanIndexed$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x005c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r11) {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r10.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0035
            if (r1 == r3) goto L_0x002d
            if (r1 != r2) goto L_0x0025
            java.lang.Object r1 = r10.L$3
            java.util.Iterator r1 = (java.util.Iterator) r1
            java.lang.Object r3 = r10.L$2
            java.lang.Object r3 = r10.L$1
            int r4 = r10.I$0
            java.lang.Object r5 = r10.L$0
            kotlin.sequences.SequenceScope r5 = (kotlin.sequences.SequenceScope) r5
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = r10
            r9 = r3
            r3 = r0
            r0 = r4
            r4 = r9
            goto L_0x0056
        L_0x0025:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x002d:
            java.lang.Object r1 = r10.L$0
            kotlin.sequences.SequenceScope r1 = (kotlin.sequences.SequenceScope) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0047
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r11)
            kotlin.sequences.SequenceScope r1 = r10.f5410p$
            java.lang.Object r11 = r10.$initial
            r10.L$0 = r1
            r10.label = r3
            java.lang.Object r11 = r1.yield(r11, r10)
            if (r11 != r0) goto L_0x0047
            return r0
        L_0x0047:
            r11 = 0
            java.lang.Object r3 = r10.$initial
            kotlin.sequences.Sequence r4 = r10.$this_scanIndexed
            java.util.Iterator r4 = r4.iterator()
            r11 = r10
            r5 = r1
            r1 = r4
            r4 = r3
            r3 = r0
            r0 = 0
        L_0x0056:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x0087
            java.lang.Object r6 = r1.next()
            kotlin.jvm.functions.Function3 r7 = r11.$operation
            int r8 = r0 + 1
            if (r0 >= 0) goto L_0x0069
            kotlin.collections.CollectionsKt.throwIndexOverflow()
        L_0x0069:
            java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r0)
            java.lang.Object r0 = r7.invoke(r0, r4, r6)
            r11.L$0 = r5
            r11.I$0 = r8
            r11.L$1 = r0
            r11.L$2 = r6
            r11.L$3 = r1
            r11.label = r2
            java.lang.Object r4 = r5.yield(r0, r11)
            if (r4 != r3) goto L_0x0084
            return r3
        L_0x0084:
            r4 = r0
            r0 = r8
            goto L_0x0056
        L_0x0087:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.sequences.SequencesKt___SequencesKt$scanIndexed$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
