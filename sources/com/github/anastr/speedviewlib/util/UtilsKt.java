package com.github.anastr.speedviewlib.util;

import com.github.anastr.speedviewlib.Gauge;
import com.github.anastr.speedviewlib.components.Section;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001\u001a-\u0010\u0004\u001a\u00020\u0005*\u00020\u00062!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00050\b*n\u0010\r\"4\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e24\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e*r\u0010\u0013\"6\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00050\u000e26\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0014\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00050\u000e*\u0001\u0010\u0016\"G\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00050\u00172G\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00050\u0017¨\u0006\u001c"}, mo66933d2 = {"getRoundAngle", "", "a", "d", "doOnSections", "", "Lcom/github/anastr/speedviewlib/Gauge;", "action", "Lkotlin/Function1;", "Lcom/github/anastr/speedviewlib/components/Section;", "Lkotlin/ParameterName;", "name", "section", "OnPrintTickLabelListener", "Lkotlin/Function2;", "", "tickPosition", "tick", "", "OnSectionChangeListener", "previousSection", "newSection", "OnSpeedChangeListener", "Lkotlin/Function3;", "gauge", "", "isSpeedUp", "isByTremble", "speedviewlib_release"}, mo66934k = 2, mo66935mv = {1, 1, 16})
/* compiled from: Utils.kt */
public final class UtilsKt {
    public static final float getRoundAngle(float f, float f2) {
        return (float) (((double) ((f * 0.5f) * ((float) 360))) / (((double) f2) * 3.141592653589793d));
    }

    public static final void doOnSections(@NotNull Gauge gauge, @NotNull Function1<? super Section, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(gauge, "$this$doOnSections");
        Intrinsics.checkParameterIsNotNull(function1, "action");
        ArrayList<Section> arrayList = new ArrayList<>(gauge.getSections());
        gauge.clearSections();
        for (Section section : arrayList) {
            Intrinsics.checkExpressionValueIsNotNull(section, "it");
            function1.invoke(section);
        }
        gauge.addSections((List<Section>) arrayList);
    }
}
