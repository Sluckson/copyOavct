package com.github.anastr.speedviewlib;

import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo66933d2 = {"<anonymous>", "", "speed", "", "invoke"}, mo66934k = 3, mo66935mv = {1, 1, 16})
/* compiled from: Gauge.kt */
final class Gauge$speedTextListener$1 extends Lambda implements Function1<Float, String> {
    final /* synthetic */ Gauge this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Gauge$speedTextListener$1(Gauge gauge) {
        super(1);
        this.this$0 = gauge;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).floatValue());
    }

    @NotNull
    public final String invoke(float f) {
        Locale locale = this.this$0.getLocale();
        Object[] objArr = {Float.valueOf(f)};
        String format = String.format(locale, "%.1f", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(locale, this, *args)");
        return format;
    }
}
