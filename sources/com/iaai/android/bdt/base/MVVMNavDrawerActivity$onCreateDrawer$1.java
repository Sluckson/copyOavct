package com.iaai.android.bdt.base;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.extensions.Activity_ExtensionKt;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterActivity;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.feature.login.BDTLoginActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.old.activities.AlertListNavDrawerActivity;
import com.iaai.android.old.activities.MDLocationListActivity;
import com.iaai.android.old.activities.SettingsActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo66933d2 = {"<anonymous>", "", "menuItem", "Landroid/view/MenuItem;", "onNavigationItemSelected"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: MVVMNavDrawerActivity.kt */
final class MVVMNavDrawerActivity$onCreateDrawer$1 implements NavigationView.OnNavigationItemSelectedListener {
    final /* synthetic */ MVVMNavDrawerActivity this$0;

    MVVMNavDrawerActivity$onCreateDrawer$1(MVVMNavDrawerActivity mVVMNavDrawerActivity) {
        this.this$0 = mVVMNavDrawerActivity;
    }

    public final boolean onNavigationItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "menuItem");
        menuItem.setChecked(true);
        switch (menuItem.getItemId()) {
            case C2723R.C2726id.drawer_menu_auction:
                IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_auction;
                ((DrawerLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
                this.this$0.startActivity(new Intent(this.this$0, BDTAuctionMainListActivity.class));
                this.this$0.finish();
                break;
            case C2723R.C2726id.drawer_menu_contact_us:
                MVVMNavDrawerActivity mVVMNavDrawerActivity = this.this$0;
                Activity_ExtensionKt.navigateToContactUsPage(mVVMNavDrawerActivity, mVVMNavDrawerActivity);
                break;
            case C2723R.C2726id.drawer_menu_dashboard:
                IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_dashboard;
                ((DrawerLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
                Intent intent = new Intent(this.this$0, BDTLandingPageActivity.class);
                intent.addFlags(335544320);
                this.this$0.startActivity(intent);
                MVVMNavDrawerActivity mVVMNavDrawerActivity2 = this.this$0;
                if (!(mVVMNavDrawerActivity2 instanceof BDTLandingPageActivity)) {
                    mVVMNavDrawerActivity2.finish();
                    break;
                }
                break;
            case C2723R.C2726id.drawer_menu_fast_search:
                IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_fast_search;
                ((DrawerLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
                this.this$0.startActivity(new Intent(this.this$0, FastSearchFilterActivity.class));
                MVVMNavDrawerActivity mVVMNavDrawerActivity3 = this.this$0;
                if (!(mVVMNavDrawerActivity3 instanceof FastSearchFilterActivity)) {
                    mVVMNavDrawerActivity3.finish();
                    break;
                }
                break;
            case C2723R.C2726id.drawer_menu_feedback:
                this.this$0.launchFeedback();
                break;
            case C2723R.C2726id.drawer_menu_help:
                MVVMNavDrawerActivity mVVMNavDrawerActivity4 = this.this$0;
                Activity_ExtensionKt.navigateToHelpPage(mVVMNavDrawerActivity4, mVVMNavDrawerActivity4);
                break;
            case C2723R.C2726id.drawer_menu_location:
                IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_location;
                ((DrawerLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
                this.this$0.startActivity(new Intent(this.this$0, MDLocationListActivity.class));
                this.this$0.finish();
                break;
            case C2723R.C2726id.drawer_menu_login:
                MVVMNavDrawerActivity mVVMNavDrawerActivity5 = this.this$0;
                if (mVVMNavDrawerActivity5 instanceof BDTLandingPageActivity) {
                    mVVMNavDrawerActivity5.getSessionManager().promptForLoginIfNeededBDT(this.this$0, 31);
                } else {
                    this.this$0.startActivity(new Intent(mVVMNavDrawerActivity5, BDTLoginActivity.class));
                }
                ((DrawerLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
                break;
            case C2723R.C2726id.drawer_menu_logout:
                this.this$0.getSessionManager().clearLoginResponseObject();
                this.this$0.getSessionManager().logout(this.this$0);
                Toast.makeText(this.this$0, C2723R.string.msg_logout, 1).show();
                ((DrawerLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
                if (!IaaiApplication.is_new_landing) {
                    MVVMNavDrawerActivity mVVMNavDrawerActivity6 = this.this$0;
                    mVVMNavDrawerActivity6.startActivity(new Intent(mVVMNavDrawerActivity6, BDTAuctionMainListActivity.class));
                    IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_auction;
                    this.this$0.finish();
                    break;
                } else {
                    Intent intent2 = new Intent(this.this$0, BDTLandingPageActivity.class);
                    intent2.addFlags(335544320);
                    this.this$0.startActivity(intent2);
                    IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_dashboard;
                    break;
                }
            case C2723R.C2726id.drawer_menu_myaccount:
                ((DrawerLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
                IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_myaccount;
                MVVMNavDrawerActivity mVVMNavDrawerActivity7 = this.this$0;
                mVVMNavDrawerActivity7.refreshViewBasedOnLoginStatus(mVVMNavDrawerActivity7.getSessionManager().isLoggedIn());
                break;
            case C2723R.C2726id.drawer_menu_notifications:
                IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_notifications;
                ((DrawerLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
                if (!this.this$0.getSessionManager().isLoggedIn()) {
                    this.this$0.getSessionManager().promptForLoginIfNeededBDT(this.this$0, 34);
                    break;
                } else {
                    this.this$0.startActivity(new Intent(this.this$0, AlertListNavDrawerActivity.class));
                    this.this$0.finish();
                    break;
                }
            case C2723R.C2726id.drawer_menu_register_now:
                Intent intent3 = new Intent("android.intent.action.VIEW");
                intent3.setData(Uri.parse("https://www.iaai.com/Registration/Free"));
                intent3.setPackage("com.android.chrome");
                try {
                    this.this$0.startActivity(intent3);
                    break;
                } catch (ActivityNotFoundException unused) {
                    Intent intent4 = new Intent("android.intent.action.VIEW");
                    intent4.setData(Uri.parse("https://www.iaai.com/Registration/Free"));
                    this.this$0.startActivity(intent4);
                    break;
                }
            case C2723R.C2726id.drawer_menu_settings:
                IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_settings;
                ((DrawerLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
                SessionManager sessionManager = this.this$0.getSessionManager();
                MVVMNavDrawerActivity mVVMNavDrawerActivity8 = this.this$0;
                if (!sessionManager.promptForLoginIfNeedFromActivity(mVVMNavDrawerActivity8, mVVMNavDrawerActivity8, 37)) {
                    this.this$0.startActivity(new Intent(this.this$0, SettingsActivity.class));
                    this.this$0.finish();
                    break;
                }
                break;
        }
        return true;
    }
}
