package com.iaai.android.bdt.feature.findVehiclePage;

import android.view.KeyEvent;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\n"}, mo66933d2 = {"com/iaai/android/bdt/feature/findVehiclePage/SearchPanelFindVehicleActivity$init$1", "Landroid/widget/TextView$OnEditorActionListener;", "onEditorAction", "", "v", "Landroid/widget/TextView;", "actionId", "", "event", "Landroid/view/KeyEvent;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchPanelFindVehicleActivity.kt */
public final class SearchPanelFindVehicleActivity$init$1 implements TextView.OnEditorActionListener {
    final /* synthetic */ SearchPanelFindVehicleActivity this$0;

    SearchPanelFindVehicleActivity$init$1(SearchPanelFindVehicleActivity searchPanelFindVehicleActivity) {
        this.this$0 = searchPanelFindVehicleActivity;
    }

    public boolean onEditorAction(@NotNull TextView textView, int i, @Nullable KeyEvent keyEvent) {
        Intrinsics.checkParameterIsNotNull(textView, "v");
        if (i != 3) {
            return false;
        }
        this.this$0.performSearch();
        return true;
    }
}
