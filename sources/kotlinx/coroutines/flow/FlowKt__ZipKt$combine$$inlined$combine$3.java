package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\b"}, mo66933d2 = {"kotlinx/coroutines/flow/internal/SafeCollectorKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$4"}, mo66934k = 1, mo66935mv = {1, 1, 15})
/* compiled from: SafeCollector.kt */
public final class FlowKt__ZipKt$combine$$inlined$combine$3 implements Flow<R> {
    final /* synthetic */ Flow[] $flows$inlined;
    final /* synthetic */ Function6 $transform$inlined$1;

    public FlowKt__ZipKt$combine$$inlined$combine$3(Flow[] flowArr, Function6 function6) {
        this.$flows$inlined = flowArr;
        this.$transform$inlined$1 = function6;
    }

    @Nullable
    public Object collect(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        return CombineKt.combineInternal(flowCollector, this.$flows$inlined, new Function0<Object[]>(this) {
            final /* synthetic */ FlowKt__ZipKt$combine$$inlined$combine$3 this$0;

            {
                this.this$0 = r1;
            }

            @NotNull
            public final Object[] invoke() {
                return new Object[this.this$0.$flows$inlined.length];
            }
        }, new C47843((Continuation) null), continuation);
    }

    @Nullable
    public Object collect$$forInline(@NotNull FlowCollector flowCollector, @NotNull Continuation continuation) {
        InlineMarker.mark(4);
        new ContinuationImpl(this, continuation) {
            Object L$0;
            Object L$1;
            int label;
            /* synthetic */ Object result;
            final /* synthetic */ FlowKt__ZipKt$combine$$inlined$combine$3 this$0;

            {
                this.this$0 = r1;
            }

            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return this.this$0.collect((FlowCollector) null, this);
            }
        };
        InlineMarker.mark(5);
        InlineMarker.mark(0);
        CombineKt.combineInternal(flowCollector, this.$flows$inlined, new Function0<Object[]>(this) {
            final /* synthetic */ FlowKt__ZipKt$combine$$inlined$combine$3 this$0;

            {
                this.this$0 = r1;
            }

            @NotNull
            public final Object[] invoke() {
                return new Object[this.this$0.$flows$inlined.length];
            }
        }, new C47843((Continuation) null), continuation);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, mo66933d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$2", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$2"}, mo66934k = 3, mo66935mv = {1, 1, 15})
    @DebugMetadata(mo67566c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$3$3", mo67567f = "Zip.kt", mo67568i = {0, 0}, mo67569l = {320}, mo67570m = "invokeSuspend", mo67571n = {"$receiver", "it"}, mo67572s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combine$3$3 */
    /* compiled from: Zip.kt */
    public static final class C47843 extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* renamed from: p$ */
        private FlowCollector f5463p$;
        private Object[] p$0;

        @NotNull
        public final Continuation<Unit> create(@NotNull FlowCollector<? super R> flowCollector, @NotNull Object[] objArr, @NotNull Continuation<? super Unit> continuation) {
            Intrinsics.checkParameterIsNotNull(flowCollector, "$this$create");
            Intrinsics.checkParameterIsNotNull(objArr, "it");
            Intrinsics.checkParameterIsNotNull(continuation, "continuation");
            C47843 r0 = new C47843(continuation, this);
            r0.f5463p$ = flowCollector;
            r0.p$0 = objArr;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ((C47843) create((FlowCollector) obj, (Object[]) obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = this.f5463p$;
                Object[] objArr = this.p$0;
                Continuation continuation = this;
                Object invoke = this.$transform$inlined$1.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], this);
                this.L$0 = flowCollector;
                this.L$1 = objArr;
                this.label = 1;
                if (flowCollector.emit(invoke, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                Object[] objArr2 = (Object[]) this.L$1;
                FlowCollector flowCollector2 = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }

        @Nullable
        public final Object invokeSuspend$$forInline(@NotNull Object obj) {
            FlowCollector flowCollector = this.f5463p$;
            Object[] objArr = this.p$0;
            Continuation continuation = this;
            Object invoke = this.$transform$inlined$1.invoke(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], this);
            InlineMarker.mark(0);
            flowCollector.emit(invoke, this);
            InlineMarker.mark(2);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        }
    }
}
