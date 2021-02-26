package com.iaai.android.bdt.base;

import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, mo66933d2 = {"com/iaai/android/bdt/base/MVVMNavDrawerActivity$onCreateDrawer$2", "Landroidx/drawerlayout/widget/DrawerLayout$DrawerListener;", "onDrawerClosed", "", "drawerView", "Landroid/view/View;", "onDrawerOpened", "onDrawerSlide", "slideOffset", "", "onDrawerStateChanged", "newState", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MVVMNavDrawerActivity.kt */
public final class MVVMNavDrawerActivity$onCreateDrawer$2 implements DrawerLayout.DrawerListener {
    final /* synthetic */ MVVMNavDrawerActivity this$0;

    public void onDrawerClosed(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "drawerView");
    }

    public void onDrawerOpened(@NotNull View view) {
        Intrinsics.checkParameterIsNotNull(view, "drawerView");
    }

    public void onDrawerStateChanged(int i) {
    }

    MVVMNavDrawerActivity$onCreateDrawer$2(MVVMNavDrawerActivity mVVMNavDrawerActivity) {
        this.this$0 = mVVMNavDrawerActivity;
    }

    public void onDrawerSlide(@NotNull View view, float f) {
        Intrinsics.checkParameterIsNotNull(view, "drawerView");
        MVVMNavDrawerActivity mVVMNavDrawerActivity = this.this$0;
        mVVMNavDrawerActivity.setUserNameAndBuyerID(mVVMNavDrawerActivity.getSessionManager());
        MVVMNavDrawerActivity mVVMNavDrawerActivity2 = this.this$0;
        mVVMNavDrawerActivity2.updateLoginNavigationMenu(mVVMNavDrawerActivity2.getSessionManager());
    }
}
