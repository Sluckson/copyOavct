package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u0004H&ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u001b\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\f\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, mo66933d2 = {"Lkotlin/time/TimeMark;", "", "()V", "elapsedNow", "Lkotlin/time/Duration;", "()D", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(D)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, mo66934k = 1, mo66935mv = {1, 1, 16})
@SinceKotlin(version = "1.3")
@ExperimentalTime
/* compiled from: TimeSource.kt */
public abstract class TimeMark {
    public abstract double elapsedNow();

    @NotNull
    /* renamed from: plus-LRDsOJo  reason: not valid java name */
    public TimeMark m5857plusLRDsOJo(double d) {
        return new AdjustedTimeMark(this, d, (DefaultConstructorMarker) null);
    }

    @NotNull
    /* renamed from: minus-LRDsOJo  reason: not valid java name */
    public TimeMark m5856minusLRDsOJo(double d) {
        return m5857plusLRDsOJo(Duration.m5849unaryMinusimpl(d));
    }

    public final boolean hasPassedNow() {
        return !Duration.m5829isNegativeimpl(elapsedNow());
    }

    public final boolean hasNotPassedNow() {
        return Duration.m5829isNegativeimpl(elapsedNow());
    }
}
