package com.iaai.android.old.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.MedalliaCustomParameters;
import com.iaai.android.bdt.feature.account.BDTMyAccountActivity;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity;
import com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchFilterActivity;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.feature.login.BDTLoginActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.utilsActivity.WebViewActivity;
import com.iaai.android.bdt.model.login.BDTLoginResponse;
import com.iaai.android.bdt.model.medalliainfo.MedalliaFBRemoteConfigModel;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.managers.SimpleRepository;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.constants.Constants;
import com.medallia.digital.mobilesdk.MDExternalError;
import com.medallia.digital.mobilesdk.MDResultCallback;
import com.medallia.digital.mobilesdk.MedalliaDigital;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class MainNavDrawerActivity extends MDAbstractActivity {
    public static final int DRAWER_MENU_TYPE_LOGIN_MENU = 1;
    public static final int DRAWER_MENU_TYPE_MAIN_MENU = 0;
    private static final float ROTATE_FROM = 0.0f;
    private static final float ROTATE_TO = -180.0f;
    private static final String TAB_ID_DASHBOARD = "DashboardTab";
    private static final String TAB_ID_LOGIN = "LoginTab";
    private static final String TAB_ID_PIN = "PinTab";
    public int fabMargin;
    TextView mBuyerID;
    FrameLayout mContentFrame;
    public DrawerLayout mDrawerLayout;
    private boolean mIsUserPressedBack;
    ImageView mMenuNavigationBtn;
    public NavigationView mNavigationView;
    public Toolbar mToolbar;
    private boolean mUserLearnedDrawer;
    TextView mUserName;
    SessionManager sessionManager;
    SharedPrefsHelper sharedPrefsHelper;
    SimpleRepository simpleRepository;
    public LinearLayout toolbarContainer;

    /* access modifiers changed from: protected */
    public void onCreateDrawer(Bundle bundle) {
        this.sharedPrefsHelper = IaaiApplication.getInstance().getComponent().getPreferenceHelper();
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        setUpToolbar();
        this.mDrawerLayout = (DrawerLayout) findViewById(C2723R.C2726id.nav_drawer);
        setUpNavDrawer();
        this.simpleRepository = (SimpleRepository) ((IaaiApplication) getApplication()).getInjector().getInstance(SimpleRepository.class);
        this.mNavigationView = (NavigationView) findViewById(C2723R.C2726id.nav_view);
        View headerView = this.mNavigationView.getHeaderView(0);
        setBarkerCommunityHelpLink();
        this.mUserName = (TextView) headerView.findViewById(C2723R.C2726id.user_name);
        this.mBuyerID = (TextView) headerView.findViewById(C2723R.C2726id.buyer_id);
        this.mMenuNavigationBtn = (ImageView) headerView.findViewById(C2723R.C2726id.drawer_menu_navigation_button);
        this.mMenuNavigationBtn.setTag(0);
        this.mContentFrame = (FrameLayout) findViewById(C2723R.C2726id.nav_contentframe);
        this.mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                switch (menuItem.getItemId()) {
                    case C2723R.C2726id.drawer_menu_auction:
                        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_auction;
                        MainNavDrawerActivity.this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
                        MainNavDrawerActivity.this.startActivity(new Intent(MainNavDrawerActivity.this, BDTAuctionMainListActivity.class));
                        MainNavDrawerActivity.this.finish();
                        return true;
                    case C2723R.C2726id.drawer_menu_contact_us:
                        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_contact_us;
                        if (IaaiApplication.getInstance().getIAARemoteConfig().getBorkerCommunityFlag()) {
                            String string = MainNavDrawerActivity.this.getString(C2723R.string.url_broker_community_contact_us, new Object[]{Constants_MVVM.EXTRA_ENGLISH_CODE});
                            if (Utils.getLanguage() == Constants_MVVM.EXTRA_SPANISH_CODE) {
                                string = MainNavDrawerActivity.this.getString(C2723R.string.url_broker_community_contact_us, new Object[]{Constants_MVVM.EXTRA_SPANISH_CODE});
                            }
                            String concat = MainNavDrawerActivity.this.getString(C2723R.string.base_broker_community_url).concat(string);
                            Intent intent = new Intent(MainNavDrawerActivity.this, WebViewActivity.class);
                            intent.putExtra(Constants_MVVM.EXTRA_BROKER_HELP_LINK_URL, concat);
                            MainNavDrawerActivity.this.startActivity(intent);
                        } else {
                            MainNavDrawerActivity.this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
                            MainNavDrawerActivity.this.startActivity(new Intent(MainNavDrawerActivity.this, ContactUsNavDrawerActivity.class));
                            MainNavDrawerActivity.this.finish();
                        }
                        return true;
                    case C2723R.C2726id.drawer_menu_dashboard:
                        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_dashboard;
                        MainNavDrawerActivity.this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
                        MainNavDrawerActivity.this.startActivity(new Intent(MainNavDrawerActivity.this, BDTLandingPageActivity.class));
                        MainNavDrawerActivity.this.finish();
                        return true;
                    case C2723R.C2726id.drawer_menu_fast_search:
                        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_fast_search;
                        MainNavDrawerActivity.this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
                        MainNavDrawerActivity.this.startActivity(new Intent(MainNavDrawerActivity.this, FastSearchFilterActivity.class));
                        MainNavDrawerActivity.this.finish();
                        return true;
                    case C2723R.C2726id.drawer_menu_feedback:
                        MainNavDrawerActivity.this.launchFeedback();
                        return true;
                    case C2723R.C2726id.drawer_menu_help:
                        if (IaaiApplication.getInstance().getIAARemoteConfig().getBorkerCommunityFlag()) {
                            String string2 = MainNavDrawerActivity.this.getString(C2723R.string.url_broker_community_menu_help, new Object[]{Constants_MVVM.EXTRA_ENGLISH_CODE});
                            if (Utils.getLanguage() == Constants_MVVM.EXTRA_SPANISH_CODE) {
                                string2 = MainNavDrawerActivity.this.getString(C2723R.string.url_broker_community_menu_help, new Object[]{Constants_MVVM.EXTRA_SPANISH_CODE});
                            }
                            String concat2 = MainNavDrawerActivity.this.getString(C2723R.string.base_broker_community_url).concat(string2);
                            Intent intent2 = new Intent(MainNavDrawerActivity.this, WebViewActivity.class);
                            intent2.putExtra(Constants_MVVM.EXTRA_BROKER_HELP_LINK_URL, concat2);
                            MainNavDrawerActivity.this.startActivity(intent2);
                        } else {
                            Intent intent3 = new Intent(MainNavDrawerActivity.this, WebViewActivity.class);
                            intent3.putExtra(Constants_MVVM.EXTRA_BROKER_HELP_LINK_URL, "https://levbox-iaa.cs7.force.com/BrokerCommunity/s/i-need-a-broker?BrokerId=001M000001ClIFV&language=en_US");
                            MainNavDrawerActivity.this.startActivity(intent3);
                        }
                        return true;
                    case C2723R.C2726id.drawer_menu_location:
                        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_location;
                        MainNavDrawerActivity.this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
                        MainNavDrawerActivity.this.startActivity(new Intent(MainNavDrawerActivity.this, MDLocationListActivity.class));
                        MainNavDrawerActivity.this.finish();
                        return true;
                    case C2723R.C2726id.drawer_menu_login:
                        MainNavDrawerActivity.this.startActivity(new Intent(MainNavDrawerActivity.this, BDTLoginActivity.class));
                        return true;
                    case C2723R.C2726id.drawer_menu_logout:
                        MainNavDrawerActivity.this.sessionManager.clearLoginResponseObject();
                        MainNavDrawerActivity.this.sessionManager.logout(MainNavDrawerActivity.this);
                        Toast.makeText(MainNavDrawerActivity.this, C2723R.string.msg_logout, 1).show();
                        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_auction;
                        MainNavDrawerActivity.this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
                        if (IaaiApplication.is_new_landing) {
                            MainNavDrawerActivity mainNavDrawerActivity = MainNavDrawerActivity.this;
                            mainNavDrawerActivity.startActivity(new Intent(mainNavDrawerActivity, BDTLandingPageActivity.class));
                        } else {
                            MainNavDrawerActivity mainNavDrawerActivity2 = MainNavDrawerActivity.this;
                            mainNavDrawerActivity2.startActivity(new Intent(mainNavDrawerActivity2, BDTAuctionMainListActivity.class));
                        }
                        MainNavDrawerActivity.this.finish();
                        return true;
                    case C2723R.C2726id.drawer_menu_myaccount:
                        MainNavDrawerActivity.this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
                        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_myaccount;
                        MainNavDrawerActivity mainNavDrawerActivity3 = MainNavDrawerActivity.this;
                        mainNavDrawerActivity3.refreshViewBasedOnLoginStatus(mainNavDrawerActivity3.sessionManager.isLoggedIn());
                        return true;
                    case C2723R.C2726id.drawer_menu_notifications:
                        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_notifications;
                        MainNavDrawerActivity.this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
                        if (MainNavDrawerActivity.this.sessionManager.isLoggedIn()) {
                            MainNavDrawerActivity.this.startActivity(new Intent(MainNavDrawerActivity.this, AlertListNavDrawerActivity.class));
                            MainNavDrawerActivity.this.finish();
                        } else {
                            MainNavDrawerActivity.this.sessionManager.promptForLoginIfNeededBDT(MainNavDrawerActivity.this, 34);
                        }
                        return true;
                    case C2723R.C2726id.drawer_menu_register_now:
                        Intent intent4 = new Intent("android.intent.action.VIEW");
                        intent4.setData(Uri.parse("https://www.iaai.com/Registration/Free"));
                        intent4.setPackage("com.android.chrome");
                        try {
                            MainNavDrawerActivity.this.startActivity(intent4);
                        } catch (ActivityNotFoundException unused) {
                            Intent intent5 = new Intent("android.intent.action.VIEW");
                            intent5.setData(Uri.parse("https://www.iaai.com/Registration/Free"));
                            MainNavDrawerActivity.this.startActivity(intent5);
                        }
                        return true;
                    case C2723R.C2726id.drawer_menu_settings:
                        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_settings;
                        MainNavDrawerActivity.this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
                        SessionManager sessionManager = MainNavDrawerActivity.this.sessionManager;
                        MainNavDrawerActivity mainNavDrawerActivity4 = MainNavDrawerActivity.this;
                        if (!sessionManager.promptForLoginIfNeedFromActivity(mainNavDrawerActivity4, mainNavDrawerActivity4, 37)) {
                            MainNavDrawerActivity.this.startActivity(new Intent(MainNavDrawerActivity.this, SettingsActivity.class));
                            MainNavDrawerActivity.this.finish();
                        }
                        return true;
                    default:
                        return true;
                }
            }
        });
        this.mDrawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            public void onDrawerClosed(View view) {
            }

            public void onDrawerOpened(View view) {
            }

            public void onDrawerSlide(View view, float f) {
            }

            public void onDrawerStateChanged(int i) {
            }
        });
        this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
    }

    private void setBarkerCommunityHelpLink() {
        MenuItem findItem = this.mNavigationView.getMenu().findItem(C2723R.C2726id.drawer_menu_help);
        if (IaaiApplication.getInstance().getIAARemoteConfig().getBorkerCommunityFlag()) {
            findItem.setVisible(true);
        } else {
            findItem.setVisible(false);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: private */
    public void launchFeedback() {
        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_feedback;
        MedalliaFBRemoteConfigModel medalliaFBRemoteConfigModel = IaaiApplication.getInstance().getIAARemoteConfig().medalliaFBRemoteConfigModel;
        if (medalliaFBRemoteConfigModel == null) {
            AppUtils.showFeedBackDialog(this, (IaaiApplication) getApplication(), this.mDrawerLayout, Constants.LIST_NAVIGATION_DRAWER_MENU);
        } else if (medalliaFBRemoteConfigModel.is_medallia_enabled()) {
            setCustomParameterForMedallia();
            MedalliaDigital.showForm(medalliaFBRemoteConfigModel.getFeedback_form_id(), new MDResultCallback() {
                public void onError(MDExternalError mDExternalError) {
                }

                public void onSuccess() {
                }
            });
        } else {
            AppUtils.showFeedBackDialog(this, (IaaiApplication) getApplication(), this.mDrawerLayout, Constants.LIST_NAVIGATION_DRAWER_MENU);
        }
    }

    private void setCustomParameterForMedallia() {
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.PAGE_NAME.getId(), "Navigation Drawer");
        int i = 0;
        int parseInt = (this.sessionManager.getCurrentSessionUserId() == null || this.sessionManager.getCurrentSessionUserId().isEmpty()) ? 0 : Integer.parseInt(this.sessionManager.getCurrentSessionUserId());
        if (this.sessionManager.getCurrentSessionBuyerId() == null || !this.sessionManager.getCurrentSessionBuyerId().equals("0")) {
            int parseInt2 = (this.sessionManager.getCurrentSessionBuyerId() == null || this.sessionManager.getCurrentSessionBuyerId().isEmpty()) ? 0 : Integer.parseInt(this.sessionManager.getCurrentSessionBuyerId());
            if (this.sessionManager.getBuyerEmployeeId() != null && !this.sessionManager.getBuyerEmployeeId().isEmpty()) {
                i = Integer.parseInt(this.sessionManager.getBuyerEmployeeId());
            }
            MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.EMPLOYER_ID.getId(), Integer.valueOf(i));
            MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.BUYER_ID.getId(), Integer.valueOf(parseInt2));
            MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.USER_ID.getId(), Integer.valueOf(parseInt));
            return;
        }
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.EMPLOYER_ID.getId(), 0);
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.BUYER_ID.getId(), 0);
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.USER_ID.getId(), Integer.valueOf(parseInt));
    }

    public void onBackPressed() {
        if (this.mIsUserPressedBack) {
            finish();
            return;
        }
        this.mIsUserPressedBack = true;
        Snackbar.make((View) this.mDrawerLayout, (CharSequence) getString(C2723R.string.press_back_again_to_exit_text), 0).show();
    }

    private void setUpToolbar() {
        this.mToolbar = (Toolbar) findViewById(C2723R.C2726id.toolbar);
        Toolbar toolbar = this.mToolbar;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        this.fabMargin = getResources().getDimensionPixelSize(C2723R.dimen.fab_margin);
        this.toolbarContainer = (LinearLayout) findViewById(C2723R.C2726id.fabhide_toolbar_container);
    }

    private void setUpNavDrawer() {
        if (this.mToolbar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            this.mToolbar.setNavigationIcon((int) C2723R.C2725drawable.ic_menu_bdt);
            this.mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    MainNavDrawerActivity.this.mDrawerLayout.openDrawer((int) GravityCompat.START);
                }
            });
        }
        if (!this.mUserLearnedDrawer) {
            this.mDrawerLayout.openDrawer((int) GravityCompat.START);
            this.mUserLearnedDrawer = true;
        }
    }

    public void setUserNameAndBuyerID(final SessionManager sessionManager2) {
        updateNavigationHeader(sessionManager2.isLoggedIn());
        this.mMenuNavigationBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (((Integer) view.getTag()).intValue() == 1) {
                    MainNavDrawerActivity.this.mNavigationView.getMenu().clear();
                    MainNavDrawerActivity.this.mNavigationView.inflateMenu(C2723R.C2729menu.drawer);
                    Menu menu = MainNavDrawerActivity.this.mNavigationView.getMenu();
                    if (IaaiApplication.selected_navigation_drawer_optionid != -1) {
                        menu.findItem(IaaiApplication.selected_navigation_drawer_optionid).setChecked(true);
                    }
                    view.setTag(0);
                    if (Build.VERSION.SDK_INT >= 21) {
                        MainNavDrawerActivity.this.mMenuNavigationBtn.setImageDrawable(MainNavDrawerActivity.this.getDrawable(C2723R.C2725drawable.ic_drawer_down_arrow));
                        return;
                    }
                    return;
                }
                MainNavDrawerActivity.this.mNavigationView.getMenu().clear();
                MainNavDrawerActivity.this.mNavigationView.inflateMenu(C2723R.C2729menu.login_drawer);
                Menu menu2 = MainNavDrawerActivity.this.mNavigationView.getMenu();
                MenuItem findItem = menu2.findItem(C2723R.C2726id.drawer_menu_login);
                MenuItem findItem2 = menu2.findItem(C2723R.C2726id.drawer_menu_logout);
                MenuItem findItem3 = menu2.findItem(C2723R.C2726id.drawer_menu_register_now);
                if (sessionManager2.isLoggedIn()) {
                    findItem.setVisible(false);
                    findItem3.setVisible(false);
                    findItem2.setVisible(true);
                } else {
                    findItem.setVisible(true);
                    findItem3.setVisible(true);
                    findItem2.setVisible(false);
                }
                view.setTag(1);
                if (Build.VERSION.SDK_INT >= 21) {
                    MainNavDrawerActivity.this.mMenuNavigationBtn.setImageDrawable(MainNavDrawerActivity.this.getDrawable(C2723R.C2725drawable.ic_drawer_up_arrow));
                }
            }
        });
    }

    public void updateNavigationHeader(boolean z) {
        if (z) {
            TextView textView = this.mUserName;
            textView.setText(this.sessionManager.getCurrentSessionFName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.sessionManager.getCurrentSessionLName());
            this.mBuyerID.setVisibility(0);
            this.mBuyerID.setText(this.sessionManager.getCurrentSessionBuyerId());
            return;
        }
        this.mUserName.setText("Guest user");
        this.mBuyerID.setVisibility(8);
    }

    public void handleLogOnNavigation(boolean z) {
        if (!z) {
            return;
        }
        if (IaaiApplication.selected_navigation_drawer_optionid == C2723R.C2726id.drawer_menu_notifications) {
            this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
            startActivity(new Intent(this, AlertListNavDrawerActivity.class));
            finish();
        } else if (IaaiApplication.selected_navigation_drawer_optionid == C2723R.C2726id.drawer_menu_myaccount) {
            this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
            startActivity(new Intent(this, BDTMyAccountActivity.class));
            finish();
        }
    }

    public void updateLoginNavigationMenu() {
        if (((Integer) this.mMenuNavigationBtn.getTag()).intValue() != 1) {
            return;
        }
        if (this.sessionManager.isLoggedIn()) {
            this.mNavigationView.getMenu().clear();
            this.mNavigationView.inflateMenu(C2723R.C2729menu.drawer);
            Menu menu = this.mNavigationView.getMenu();
            if (IaaiApplication.selected_navigation_drawer_optionid != -1) {
                menu.findItem(IaaiApplication.selected_navigation_drawer_optionid).setChecked(true);
            }
            this.mMenuNavigationBtn.setTag(0);
            if (Build.VERSION.SDK_INT >= 21) {
                this.mMenuNavigationBtn.setImageDrawable(getDrawable(C2723R.C2725drawable.ic_drawer_down_arrow));
            }
            this.mNavigationView.invalidate();
            return;
        }
        this.mNavigationView.getMenu().clear();
        this.mNavigationView.inflateMenu(C2723R.C2729menu.login_drawer);
        Menu menu2 = this.mNavigationView.getMenu();
        MenuItem findItem = menu2.findItem(C2723R.C2726id.drawer_menu_login);
        MenuItem findItem2 = menu2.findItem(C2723R.C2726id.drawer_menu_logout);
        MenuItem findItem3 = menu2.findItem(C2723R.C2726id.drawer_menu_register_now);
        findItem.setVisible(true);
        findItem3.setVisible(true);
        findItem2.setVisible(false);
        this.mNavigationView.invalidate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.mMenuNavigationBtn.setImageDrawable(getDrawable(C2723R.C2725drawable.ic_drawer_up_arrow));
        }
    }

    /* access modifiers changed from: package-private */
    public void refreshViewBasedOnLoginStatus(boolean z) {
        if (z) {
            String str = this.sharedPrefsHelper.get(this.sessionManager.getPREF_LAST_LOGIN_USER_INFO(), "");
            if (str == null || str.length() <= 0) {
                IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_myaccount;
                this.sessionManager.promptForLoginIfNeededBDT(this, 33);
                return;
            }
            this.sessionManager.setLoginResponse((BDTLoginResponse) new Gson().fromJson(str, BDTLoginResponse.class));
            this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
            startActivity(new Intent(this, BDTMyAccountActivity.class));
            finish();
            return;
        }
        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_myaccount;
        this.sessionManager.promptForLoginIfNeededBDT(this, 33);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i2 == -1) {
            if (i == 33) {
                this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
                startActivity(new Intent(this, BDTMyAccountActivity.class));
                finish();
            } else if (i == 34) {
                startActivity(new Intent(this, AlertListNavDrawerActivity.class));
                finish();
            } else if (i == 37) {
                startActivity(new Intent(this, SettingsActivity.class));
                finish();
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
