package com.iaai.android.old.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import butterknife.ButterKnife;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.old.fragments.ContactUsFragment;
import com.iaai.android.old.models.LoginState;
import com.squareup.otto.Subscribe;

public class ContactUsNavDrawerActivity extends MainNavDrawerActivity {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_contact_us_nav_drawer_layout);
        super.onCreateDrawer(bundle);
        ButterKnife.bind((Activity) this);
        IaaiApplication.getBus().register(this);
        IaaiApplication iaaiApplication = (IaaiApplication) getApplication();
        super.setUserNameAndBuyerID(this.sessionManager);
        this.mNavigationView.getMenu().findItem(C2723R.C2726id.drawer_menu_contact_us).setChecked(true);
        getFragmentManager().beginTransaction().replace(C2723R.C2726id.framelayout_container, new ContactUsFragment()).commit();
        getWindow().setSoftInputMode(2);
    }

    @Subscribe
    public void onLoginEventChanged(LoginState loginState) {
        super.updateNavigationHeader(loginState.isLogin());
        super.updateLoginNavigationMenu();
        super.handleLogOnNavigation(loginState.isLogin());
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
