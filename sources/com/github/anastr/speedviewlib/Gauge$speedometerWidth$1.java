package com.github.anastr.speedviewlib;

import com.github.anastr.speedviewlib.components.Section;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/github/anastr/speedviewlib/components/Section;", "invoke"}, mo66934k = 3, mo66935mv = {1, 1, 16})
/* compiled from: Gauge.kt */
final class Gauge$speedometerWidth$1 extends Lambda implements Function1<Section, Unit> {
    final /* synthetic */ float $speedometerWidth;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Gauge$speedometerWidth$1(float f) {
        super(1);
        this.$speedometerWidth = f;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Section) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Section section) {
        Intrinsics.checkParameterIsNotNull(section, "it");
        section.setWidth(this.$speedometerWidth);
    }
}
