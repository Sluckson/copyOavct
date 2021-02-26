package com.iaai.android.bdt.extensions;

import android.widget.EditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001e\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\u0005¨\u0006\u0007"}, mo66933d2 = {"disableCopyPaste", "", "Landroid/widget/EditText;", "onChange", "cb", "Lkotlin/Function1;", "", "app_productionRelease"}, mo66934k = 2, mo66935mv = {1, 1, 13})
/* compiled from: EditText+Extension.kt */
public final class EditText_ExtensionKt {
    public static final void onChange(@NotNull EditText editText, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(editText, "receiver$0");
        Intrinsics.checkParameterIsNotNull(function1, "cb");
        editText.addTextChangedListener(new EditText_ExtensionKt$onChange$1(function1));
    }

    public static final void disableCopyPaste(@NotNull EditText editText) {
        Intrinsics.checkParameterIsNotNull(editText, "receiver$0");
        editText.setCustomSelectionActionModeCallback(new EditText_ExtensionKt$disableCopyPaste$1());
    }
}
