package com.iaai.android.bdt.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo66933d2 = {"filterSearch", "", "Lkotlin/text/Regex;", "inputText", "", "app_productionRelease"}, mo66934k = 2, mo66935mv = {1, 1, 13})
/* compiled from: Regex+Extension.kt */
public final class Regex_ExtensionKt {
    public static final boolean filterSearch(@NotNull Regex regex, @NotNull String str) {
        Intrinsics.checkParameterIsNotNull(regex, "receiver$0");
        Intrinsics.checkParameterIsNotNull(str, "inputText");
        return regex.containsMatchIn(str);
    }
}
