package com.github.anastr.speedviewlib;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, mo66933d2 = {"<anonymous>", "", "<anonymous parameter 0>", "", "speed", "", "invoke"}, mo66934k = 3, mo66935mv = {1, 1, 16})
/* compiled from: Speedometer.kt */
final class Speedometer$initAttributeSet$2 extends Lambda implements Function2<Integer, Float, String> {
    final /* synthetic */ Speedometer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Speedometer$initAttributeSet$2(Speedometer speedometer) {
        super(2);
        this.this$0 = speedometer;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), ((Number) obj2).floatValue());
    }

    @NotNull
    public final String invoke(int i, float f) {
        Locale locale = this.this$0.getLocale();
        Object[] objArr = {Float.valueOf(f)};
        String format = String.format(locale, "%.1f", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, this, *args)");
        return format;
    }
}
