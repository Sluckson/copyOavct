package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u0011\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\b¨\u0006\u0007"}, mo66933d2 = {"assert", "", "value", "", "lazyMessage", "Lkotlin/Function0;", "", "kotlin-stdlib"}, mo66934k = 5, mo66935mv = {1, 1, 16}, mo66937xi = 1, mo66938xs = "kotlin/PreconditionsKt")
/* compiled from: AssertionsJVM.kt */
class PreconditionsKt__AssertionsJVMKt {
    @InlineOnly
    /* renamed from: assert  reason: not valid java name */
    private static final void m4850assert(boolean z) {
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError("Assertion failed");
        }
    }

    @InlineOnly
    /* renamed from: assert  reason: not valid java name */
    private static final void m4851assert(boolean z, Function0<? extends Object> function0) {
        if (_Assertions.ENABLED && !z) {
            throw new AssertionError(function0.invoke());
        }
    }
}
