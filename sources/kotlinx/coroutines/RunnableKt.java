package kotlinx.coroutines;

import com.lowagie.text.html.Markup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u000e\b\u0004\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\b*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0006"}, mo66933d2 = {"Runnable", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "block", "Lkotlin/Function0;", "", "kotlinx-coroutines-core"}, mo66934k = 2, mo66935mv = {1, 1, 15})
/* compiled from: Runnable.kt */
public final class RunnableKt {
    @NotNull
    public static final Runnable Runnable(@NotNull Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(function0, Markup.CSS_VALUE_BLOCK);
        return new RunnableKt$Runnable$1(function0);
    }
}