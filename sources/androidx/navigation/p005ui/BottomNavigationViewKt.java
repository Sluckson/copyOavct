package androidx.navigation.p005ui;

import androidx.navigation.NavController;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, mo66933d2 = {"setupWithNavController", "", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "navController", "Landroidx/navigation/NavController;", "navigation-ui-ktx_release"}, mo66934k = 2, mo66935mv = {1, 1, 16})
/* renamed from: androidx.navigation.ui.BottomNavigationViewKt */
/* compiled from: BottomNavigationView.kt */
public final class BottomNavigationViewKt {
    public static final void setupWithNavController(@NotNull BottomNavigationView bottomNavigationView, @NotNull NavController navController) {
        Intrinsics.checkParameterIsNotNull(bottomNavigationView, "$this$setupWithNavController");
        Intrinsics.checkParameterIsNotNull(navController, "navController");
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }
}
