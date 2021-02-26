package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo66933d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$5"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2", mo67567f = "Zip.kt", mo67568i = {0}, mo67569l = {260}, mo67570m = "invokeSuspend", mo67571n = {"$this$flow"}, mo67572s = {"L$0"})
/* compiled from: Zip.kt */
public final class FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2 extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow[] $flows;
    final /* synthetic */ Function6 $transform$inlined;
    Object L$0;
    int label;

    /* renamed from: p$ */
    private FlowCollector f5472p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2(Flow[] flowArr, Continuation continuation, Function6 function6) {
        super(2, continuation);
        this.$flows = flowArr;
        this.$transform$inlined = function6;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2 flowKt__ZipKt$combineTransform$$inlined$combineTransform$2 = new FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2(this.$flows, continuation, this.$transform$inlined);
        flowKt__ZipKt$combineTransform$$inlined$combineTransform$2.f5472p$ = (FlowCollector) obj;
        return flowKt__ZipKt$combineTransform$$inlined$combineTransform$2;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, mo66933d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$5$2"}, mo66934k = 3, mo66935mv = {1, 1, 15})
    @DebugMetadata(mo67566c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2$2", mo67567f = "Zip.kt", mo67568i = {}, mo67569l = {}, mo67570m = "invokeSuspend", mo67571n = {}, mo67572s = {})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2$2 */
    /* compiled from: Zip.kt */
    public static final class C47932 extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        /* renamed from: p$ */
        private FlowCollector f5473p$;
        private Object[] p$0;
        final /* synthetic */ FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2 this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@NotNull FlowCollector<? super R> flowCollector, @NotNull Object[] objArr, @NotNull Continuation<? super Unit> continuation) {
            Intrinsics.checkParameterIsNotNull(flowCollector, "$this$create");
            Intrinsics.checkParameterIsNotNull(objArr, "it");
            Intrinsics.checkParameterIsNotNull(continuation, "continuation");
            C47932 r0 = new C47932(this.this$0, continuation);
            r0.f5473p$ = flowCollector;
            r0.p$0 = objArr;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ((C47932) create((FlowCollector) obj, (Object[]) obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = this.f5473p$;
                Object[] objArr = this.p$0;
                Continuation continuation = this;
                this.this$0.$transform$inlined.invoke(flowCollector, objArr[0], objArr[1], objArr[2], objArr[3], this);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Nullable
        public final Object invokeSuspend$$forInline(@NotNull Object obj) {
            FlowCollector flowCollector = this.f5473p$;
            Object[] objArr = this.p$0;
            Continuation continuation = this;
            this.this$0.$transform$inlined.invoke(flowCollector, objArr[0], objArr[1], objArr[2], objArr[3], this);
            return Unit.INSTANCE;
        }
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.f5472p$;
            this.L$0 = flowCollector;
            this.label = 1;
            if (CombineKt.combineInternal(flowCollector, this.$flows, new Function0<Object[]>(this) {
                final /* synthetic */ FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2 this$0;

                {
                    this.this$0 = r1;
                }

                @NotNull
                public final Object[] invoke() {
                    return new Object[this.this$0.$flows.length];
                }
            }, new C47932(this, (Continuation) null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        InlineMarker.mark(0);
        CombineKt.combineInternal(this.f5472p$, this.$flows, new Function0<Object[]>(this) {
            final /* synthetic */ FlowKt__ZipKt$combineTransform$$inlined$combineTransform$2 this$0;

            {
                this.this$0 = r1;
            }

            @NotNull
            public final Object[] invoke() {
                return new Object[this.this$0.$flows.length];
            }
        }, new C47932(this, (Continuation) null), this);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
