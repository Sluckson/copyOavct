package androidx.fragment.app;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo66933d2 = {"findFragment", "F", "Landroidx/fragment/app/Fragment;", "Landroid/view/View;", "(Landroid/view/View;)Landroidx/fragment/app/Fragment;", "fragment-ktx_release"}, mo66934k = 2, mo66935mv = {1, 1, 15})
/* compiled from: View.kt */
public final class ViewKt {
    @NotNull
    public static final <F extends Fragment> F findFragment(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "$this$findFragment");
        F findFragment = FragmentManager.findFragment(view);
        Intrinsics.checkExpressionValueIsNotNull(findFragment, "FragmentManager.findFragment(this)");
        return findFragment;
    }
}
