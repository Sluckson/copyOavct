package com.iaai.android.bdt.base;

import android.os.Build;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.google.android.material.navigation.NavigationView;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: MVVMNavDrawerActivity.kt */
final class MVVMNavDrawerActivity$setUserNameAndBuyerID$1 implements View.OnClickListener {
    final /* synthetic */ SessionManager $loginManager;
    final /* synthetic */ MVVMNavDrawerActivity this$0;

    MVVMNavDrawerActivity$setUserNameAndBuyerID$1(MVVMNavDrawerActivity mVVMNavDrawerActivity, SessionManager sessionManager) {
        this.this$0 = mVVMNavDrawerActivity;
        this.$loginManager = sessionManager;
    }

    public final void onClick(View view) {
        Intrinsics.checkExpressionValueIsNotNull(view, "v");
        Object tag = view.getTag();
        if (tag == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        } else if (((Integer) tag).intValue() == 1) {
            NavigationView navigationView = (NavigationView) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_view);
            Intrinsics.checkExpressionValueIsNotNull(navigationView, "nav_view");
            navigationView.getMenu().clear();
            ((NavigationView) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_view)).inflateMenu(C2723R.C2729menu.drawer);
            NavigationView navigationView2 = (NavigationView) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_view);
            Intrinsics.checkExpressionValueIsNotNull(navigationView2, "nav_view");
            Menu menu = navigationView2.getMenu();
            Intrinsics.checkExpressionValueIsNotNull(menu, "nav_view.menu");
            if (IaaiApplication.selected_navigation_drawer_optionid != -1) {
                MenuItem findItem = menu.findItem(IaaiApplication.selected_navigation_drawer_optionid);
                Intrinsics.checkExpressionValueIsNotNull(findItem, "menuItem");
                findItem.setChecked(true);
            }
            view.setTag(0);
            if (Build.VERSION.SDK_INT >= 21) {
                MVVMNavDrawerActivity.access$getMMenuNavigationBtn$p(this.this$0).setImageDrawable(this.this$0.getDrawable(C2723R.C2725drawable.ic_drawer_down_arrow));
            }
        } else {
            NavigationView navigationView3 = (NavigationView) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_view);
            Intrinsics.checkExpressionValueIsNotNull(navigationView3, "nav_view");
            navigationView3.getMenu().clear();
            ((NavigationView) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_view)).inflateMenu(C2723R.C2729menu.login_drawer);
            NavigationView navigationView4 = (NavigationView) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_view);
            Intrinsics.checkExpressionValueIsNotNull(navigationView4, "nav_view");
            Menu menu2 = navigationView4.getMenu();
            Intrinsics.checkExpressionValueIsNotNull(menu2, "nav_view.menu");
            MenuItem findItem2 = menu2.findItem(C2723R.C2726id.drawer_menu_login);
            MenuItem findItem3 = menu2.findItem(C2723R.C2726id.drawer_menu_logout);
            MenuItem findItem4 = menu2.findItem(C2723R.C2726id.drawer_menu_register_now);
            if (this.$loginManager.isLoggedIn()) {
                Intrinsics.checkExpressionValueIsNotNull(findItem2, "login");
                findItem2.setVisible(false);
                Intrinsics.checkExpressionValueIsNotNull(findItem4, "register");
                findItem4.setVisible(false);
                Intrinsics.checkExpressionValueIsNotNull(findItem3, "logout");
                findItem3.setVisible(true);
            } else {
                Intrinsics.checkExpressionValueIsNotNull(findItem2, "login");
                findItem2.setVisible(true);
                Intrinsics.checkExpressionValueIsNotNull(findItem4, "register");
                findItem4.setVisible(true);
                Intrinsics.checkExpressionValueIsNotNull(findItem3, "logout");
                findItem3.setVisible(false);
            }
            view.setTag(1);
            if (Build.VERSION.SDK_INT >= 21) {
                MVVMNavDrawerActivity.access$getMMenuNavigationBtn$p(this.this$0).setImageDrawable(this.this$0.getDrawable(C2723R.C2725drawable.ic_drawer_up_arrow));
            }
        }
    }
}
