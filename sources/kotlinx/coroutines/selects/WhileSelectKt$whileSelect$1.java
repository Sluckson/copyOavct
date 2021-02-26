package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0002\b\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\tHH"}, mo66933d2 = {"whileSelect", "", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "", "Lkotlin/ExtensionFunctionType;", "continuation", "Lkotlin/coroutines/Continuation;"}, mo66934k = 3, mo66935mv = {1, 1, 15})
@DebugMetadata(mo67566c = "kotlinx.coroutines.selects.WhileSelectKt", mo67567f = "WhileSelect.kt", mo67568i = {0}, mo67569l = {34}, mo67570m = "whileSelect", mo67571n = {"builder"}, mo67572s = {"L$0"})
/* compiled from: WhileSelect.kt */
public final class WhileSelectKt$whileSelect$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public WhileSelectKt$whileSelect$1(Continuation continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return WhileSelectKt.whileSelect((Function1<? super SelectBuilder<? super Boolean>, Unit>) null, this);
    }
}
