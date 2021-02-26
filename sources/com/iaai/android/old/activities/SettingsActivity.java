package com.iaai.android.old.activities;

import android.os.Bundle;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.fragments.SettingsFragment;
import com.iaai.android.old.models.LoginState;
import com.squareup.otto.Subscribe;

public class SettingsActivity extends MainNavDrawerActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.setting_navigation_drawer_layout);
        super.onCreateDrawer(bundle);
        IaaiApplication.getBus().register(this);
        ((IaaiApplication) getApplication()).getInjector();
        super.setUserNameAndBuyerID(this.sessionManager);
        this.mNavigationView.getMenu().findItem(C2723R.C2726id.drawer_menu_settings).setChecked(true);
        getFragmentManager().beginTransaction().replace(C2723R.C2726id.setting_container, new SettingsFragment()).commit();
    }

    @Subscribe
    public void onLoginEventChanged(LoginState loginState) {
        super.updateNavigationHeader(loginState.isLogin());
        super.updateLoginNavigationMenu();
        super.handleLogOnNavigation(loginState.isLogin());
    }
}
