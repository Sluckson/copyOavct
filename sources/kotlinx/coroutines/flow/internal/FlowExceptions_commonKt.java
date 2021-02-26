package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.PublishedApi;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\b¨\u0006\u0003"}, mo66933d2 = {"checkIndexOverflow", "", "index", "kotlinx-coroutines-core"}, mo66934k = 2, mo66935mv = {1, 1, 15})
/* compiled from: FlowExceptions.common.kt */
public final class FlowExceptions_commonKt {
    @PublishedApi
    public static final int checkIndexOverflow(int i) {
        if (i >= 0) {
            return i;
        }
        throw new ArithmeticException("Index overflow has happened");
    }
}
