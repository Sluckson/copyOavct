package kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, mo66933d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, mo66934k = 3, mo66935mv = {1, 1, 15})
/* renamed from: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1 */
/* compiled from: Comparisons.kt */
public final class C4813x9323e642<T> implements Comparator<T> {
    public final int compare(T t, T t2) {
        Constructor constructor = (Constructor) t2;
        Intrinsics.checkExpressionValueIsNotNull(constructor, "it");
        Constructor constructor2 = (Constructor) t;
        Intrinsics.checkExpressionValueIsNotNull(constructor2, "it");
        return ComparisonsKt.compareValues(Integer.valueOf(constructor.getParameterTypes().length), Integer.valueOf(constructor2.getParameterTypes().length));
    }
}
