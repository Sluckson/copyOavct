package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "T", "it", "", "invoke"}, mo66934k = 3, mo66935mv = {1, 1, 15})
/* compiled from: Migration.kt */
final class FlowKt__MigrationKt$onErrorReturn$1 extends Lambda implements Function1<Throwable, Boolean> {
    public static final FlowKt__MigrationKt$onErrorReturn$1 INSTANCE = new FlowKt__MigrationKt$onErrorReturn$1();

    FlowKt__MigrationKt$onErrorReturn$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((Throwable) obj));
    }

    public final boolean invoke(@NotNull Throwable th) {
        Intrinsics.checkParameterIsNotNull(th, "it");
        return true;
    }
}
