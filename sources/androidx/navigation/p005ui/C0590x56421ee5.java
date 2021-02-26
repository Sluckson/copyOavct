package androidx.navigation.p005ui;

import androidx.navigation.p005ui.AppBarConfiguration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66934k = 3, mo66935mv = {1, 1, 16})
/* renamed from: androidx.navigation.ui.AppBarConfigurationKt$sam$i$androidx_navigation_ui_AppBarConfiguration_OnNavigateUpListener$0 */
/* compiled from: AppBarConfiguration.kt */
public final class C0590x56421ee5 implements AppBarConfiguration.OnNavigateUpListener {
    private final /* synthetic */ Function0 function;

    public C0590x56421ee5(Function0 function0) {
        this.function = function0;
    }

    public final /* synthetic */ boolean onNavigateUp() {
        Object invoke = this.function.invoke();
        Intrinsics.checkExpressionValueIsNotNull(invoke, "invoke(...)");
        return ((Boolean) invoke).booleanValue();
    }
}
