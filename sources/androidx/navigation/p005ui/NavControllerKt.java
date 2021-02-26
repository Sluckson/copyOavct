package androidx.navigation.p005ui;

import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import androidx.navigation.NavGraph;
import androidx.navigation.p005ui.AppBarConfiguration;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo66933d2 = {"navigateUp", "", "Landroidx/navigation/NavController;", "drawerLayout", "Landroidx/customview/widget/Openable;", "appBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "navigation-ui-ktx_release"}, mo66934k = 2, mo66935mv = {1, 1, 16})
/* renamed from: androidx.navigation.ui.NavControllerKt */
/* compiled from: NavController.kt */
public final class NavControllerKt {
    public static final boolean navigateUp(@NotNull NavController navController, @Nullable Openable openable) {
        Intrinsics.checkParameterIsNotNull(navController, "$this$navigateUp");
        NavGraph graph = navController.getGraph();
        Intrinsics.checkExpressionValueIsNotNull(graph, "graph");
        Function0 function0 = AppBarConfigurationKt$AppBarConfiguration$1.INSTANCE;
        AppBarConfiguration build = new AppBarConfiguration.Builder(graph).setOpenableLayout(openable).setFallbackOnNavigateUpListener((AppBarConfiguration.OnNavigateUpListener) (function0 != null ? new C0590x56421ee5(function0) : function0)).build();
        Intrinsics.checkExpressionValueIsNotNull(build, "AppBarConfiguration.Buil…eUpListener)\n    .build()");
        return NavigationUI.navigateUp(navController, build);
    }

    public static final boolean navigateUp(@NotNull NavController navController, @NotNull AppBarConfiguration appBarConfiguration) {
        Intrinsics.checkParameterIsNotNull(navController, "$this$navigateUp");
        Intrinsics.checkParameterIsNotNull(appBarConfiguration, "appBarConfiguration");
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }
}
