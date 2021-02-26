package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.flow.internal.CombineKt$onReceive$1", mo67567f = "Combine.kt", mo67568i = {0, 1}, mo67569l = {90, 90}, mo67570m = "invokeSuspend", mo67571n = {"it", "it"}, mo67572s = {"L$0", "L$0"})
/* compiled from: Combine.kt */
public final class CombineKt$onReceive$1 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $onClosed;
    final /* synthetic */ Function2 $onReceive;
    Object L$0;
    int label;
    private Object p$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombineKt$onReceive$1(Function0 function0, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$onClosed = function0;
        this.$onReceive = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        CombineKt$onReceive$1 combineKt$onReceive$1 = new CombineKt$onReceive$1(this.$onClosed, this.$onReceive, continuation);
        combineKt$onReceive$1.p$0 = obj;
        return combineKt$onReceive$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CombineKt$onReceive$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.p$0;
            if (obj2 == null) {
                this.$onClosed.invoke();
                return Unit.INSTANCE;
            }
            Function2 function2 = this.$onReceive;
            this.L$0 = obj2;
            this.label = 2;
            this.L$0 = obj2;
            this.label = 1;
            obj = function2.invoke(obj2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            Object obj3 = this.L$0;
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            Object obj4 = this.L$0;
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object invokeSuspend$$forInline(@NotNull Object obj) {
        Object obj2 = this.p$0;
        if (obj2 == null) {
            this.$onClosed.invoke();
        } else {
            Function2 function2 = this.$onReceive;
            InlineMarker.mark(0);
            function2.invoke(obj2, this);
            InlineMarker.mark(2);
            InlineMarker.mark(1);
        }
        return Unit.INSTANCE;
    }
}
