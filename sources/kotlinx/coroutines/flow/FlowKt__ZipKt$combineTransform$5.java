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
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.internal.CombineKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, mo66933d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$5", mo67567f = "Zip.kt", mo67568i = {0}, mo67569l = {260}, mo67570m = "invokeSuspend", mo67571n = {"$this$flow"}, mo67572s = {"L$0"})
/* compiled from: Zip.kt */
public final class FlowKt__ZipKt$combineTransform$5 extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow[] $flows;
    final /* synthetic */ Function3 $transform;
    Object L$0;
    int label;

    /* renamed from: p$ */
    private FlowCollector f5478p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combineTransform$5(Flow[] flowArr, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$flows = flowArr;
        this.$transform = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        FlowKt__ZipKt$combineTransform$5 flowKt__ZipKt$combineTransform$5 = new FlowKt__ZipKt$combineTransform$5(this.$flows, this.$transform, continuation);
        flowKt__ZipKt$combineTransform$5.f5478p$ = (FlowCollector) obj;
        return flowKt__ZipKt$combineTransform$5;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FlowKt__ZipKt$combineTransform$5) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H@¢\u0006\u0004\b\u0007\u0010\b"}, mo66933d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
    @DebugMetadata(mo67566c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$5$2", mo67567f = "Zip.kt", mo67568i = {0, 0}, mo67569l = {260}, mo67570m = "invokeSuspend", mo67571n = {"$receiver", "it"}, mo67572s = {"L$0", "L$1"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$5$2 */
    /* compiled from: Zip.kt */
    public static final class C47982 extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        /* renamed from: p$ */
        private FlowCollector f5479p$;
        private Object[] p$0;
        final /* synthetic */ FlowKt__ZipKt$combineTransform$5 this$0;

        {
            this.this$0 = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@NotNull FlowCollector<? super R> flowCollector, @NotNull T[] tArr, @NotNull Continuation<? super Unit> continuation) {
            Intrinsics.checkParameterIsNotNull(flowCollector, "$this$create");
            Intrinsics.checkParameterIsNotNull(tArr, "it");
            Intrinsics.checkParameterIsNotNull(continuation, "continuation");
            C47982 r0 = new C47982(this.this$0, continuation);
            r0.f5479p$ = flowCollector;
            r0.p$0 = tArr;
            return r0;
        }

        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ((C47982) create((FlowCollector) obj, (Object[]) obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = this.f5479p$;
                Object[] objArr = this.p$0;
                Function3 function3 = this.this$0.$transform;
                this.L$0 = flowCollector;
                this.L$1 = objArr;
                this.label = 1;
                if (function3.invoke(flowCollector, objArr, this) == coroutine_suspended) {
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
            this.this$0.$transform.invoke(this.f5479p$, this.p$0, this);
            return Unit.INSTANCE;
        }
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.f5478p$;
            Flow[] flowArr = this.$flows;
            Intrinsics.needClassReification();
            this.L$0 = flowCollector;
            this.label = 1;
            if (CombineKt.combineInternal(flowCollector, flowArr, new Function0<T[]>(this) {
                final /* synthetic */ FlowKt__ZipKt$combineTransform$5 this$0;

                {
                    this.this$0 = r1;
                }

                @NotNull
                public final T[] invoke() {
                    int length = this.this$0.$flows.length;
                    Intrinsics.reifiedOperationMarker(0, "T?");
                    return new Object[length];
                }
            }, new C47982(this, (Continuation) null), this) == coroutine_suspended) {
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
        FlowCollector flowCollector = this.f5478p$;
        Flow[] flowArr = this.$flows;
        Intrinsics.needClassReification();
        InlineMarker.mark(0);
        CombineKt.combineInternal(flowCollector, flowArr, new Function0<T[]>(this) {
            final /* synthetic */ FlowKt__ZipKt$combineTransform$5 this$0;

            {
                this.this$0 = r1;
            }

            @NotNull
            public final T[] invoke() {
                int length = this.this$0.$flows.length;
                Intrinsics.reifiedOperationMarker(0, "T?");
                return new Object[length];
            }
        }, new C47982(this, (Continuation) null), this);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
