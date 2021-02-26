package com.iaai.android.old.activities;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.gson.Gson;
import com.google.inject.Injector;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.MedalliaCustomParameters;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingActivity;
import com.iaai.android.bdt.feature.onBoarding.OnBoardingEnum;
import com.iaai.android.bdt.model.medalliainfo.MedalliaFBRemoteConfigModel;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.managers.MyAccountManager;
import com.iaai.android.old.managers.SimpleRepository;
import com.iaai.android.old.models.Dashboard;
import com.iaai.android.old.models.LoginState;
import com.iaai.android.old.providers.IaaContent;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.IAASharedPreference;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.UiUtils;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.medallia.digital.mobilesdk.MDExternalError;
import com.medallia.digital.mobilesdk.MDResultCallback;
import com.medallia.digital.mobilesdk.MedalliaDigital;
import com.squareup.otto.Subscribe;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import p052cz.msebera.android.httpclient.Header;

public class MyAccountActivity extends MainNavDrawerActivity {
    @BindView(2131296287)
    RelativeLayout License_and_document_layout;
    @BindView(2131296417)
    RelativeLayout alertLayout;
    @BindView(2131296414)
    TextView alert_count;
    @BindView(2131296458)
    TextView awardPendingCount;
    @BindView(2131296459)
    RelativeLayout awardPendingLayout;
    @BindView(2131296460)
    TextView awardPendingNewCount;
    @BindView(2131296676)
    TextView buyNowOfferCount;
    @BindView(2131296677)
    RelativeLayout buyNowOfferLayout;
    @BindView(2131296678)
    TextView buy_now_offer_new_count;
    @BindView(2131296681)
    TextView buyerIdInfo;
    @BindView(2131298240)
    Switch chkMyVehiclesOnly;
    private ContentResolver contentResolver;
    /* access modifiers changed from: private */
    public Dashboard dashboardData;
    int int_buyNowOfferCount;
    @BindView(2131296630)
    RelativeLayout leave_feedback;
    @BindView(2131297414)
    TextView license_and_document_id;
    @BindView(2131296633)
    TextView logOut;
    @BindView(2131297591)
    RelativeLayout lostPreBidLayout;
    @BindView(2131297608)
    TextView manageOfferCount;
    @BindView(2131298030)
    RelativeLayout manageOfferLayout;
    @BindView(2131297609)
    TextView manageOfferNewCount;
    MyAccountManager myAccountManager;
    @BindView(2131297750)
    ScrollView myAccountScrollView;
    @BindView(2131297938)
    TextView preBidCount;
    @BindView(2131297918)
    RelativeLayout preBidLayout;
    @BindView(2131297919)
    TextView preBidNewCount;
    @BindView(2131297948)
    TextView profile_id;
    @BindView(2131297949)
    RelativeLayout profile_layout;
    @BindView(2131297954)
    ProgressBar progressBar;
    @BindView(2131298003)
    TextView renewal_id;
    @BindView(2131298004)
    RelativeLayout renewal_layout;
    @BindView(2131298236)
    RelativeLayout showMYVehicleRelativeLayout;
    SimpleRepository simpleRepository;
    @BindView(2131298298)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(2131298410)
    TextView toBePaidCount;
    @BindView(2131298411)
    RelativeLayout toBePaidLayout;
    @BindView(2131298412)
    TextView toBePaidNewCount;
    @BindView(2131298406)
    TextView toBePickedUpCount;
    @BindView(2131298419)
    RelativeLayout toBePickedUpLayout;
    @BindView(2131298409)
    TextView toBePickedUpNewCount;
    @BindView(2131299053)
    TextView upgrade_account_id;
    @BindView(2131299054)
    RelativeLayout upgrade_account_layout;
    @BindView(2131299060)
    ImageView userImage;
    @BindView(2131299059)
    TextView userName;
    @BindView(2131299146)
    RelativeLayout watchingLayout;
    @BindView(2131299157)
    RelativeLayout wonHistoryLayout;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_my_account_layout);
        super.onCreateDrawer(bundle);
        IaaiApplication.getBus().register(this);
        ButterKnife.bind((Activity) this);
        Injector injector = ((IaaiApplication) getApplication()).getInjector();
        this.simpleRepository = (SimpleRepository) injector.getInstance(SimpleRepository.class);
        this.myAccountManager = (MyAccountManager) injector.getInstance(MyAccountManager.class);
        this.contentResolver = (ContentResolver) injector.getInstance(ContentResolver.class);
        super.setUserNameAndBuyerID(this.sessionManager);
        if (this.sessionManager.isCurrentSessionUserOwner()) {
            this.showMYVehicleRelativeLayout.setVisibility(0);
        } else {
            this.showMYVehicleRelativeLayout.setVisibility(8);
        }
        if (IaaiApplication.getInstance().getIAARemoteConfig().getManageOfferHintFlag() && this.sessionManager.isLoggedIn() && !this.sessionManager.getCurrentSessionBuyerId().equals("0") && IAASharedPreference.getIsFirstLaunchForManageofferMyAccount(getApplicationContext()).booleanValue()) {
            IAASharedPreference.setIsFirstLaunchForManageofferMyAccount(this, false);
            Intent intent = new Intent(this, OnBoardingActivity.class);
            intent.putExtra(Constants_MVVM.ON_BOARDING_ENUM_VALUE, OnBoardingEnum.MANAGE_OFFER_MYACCOUNT);
            startActivity(intent);
        }
        OnRowClickListener onRowClickListener = new OnRowClickListener();
        this.mNavigationView.getMenu().findItem(C2723R.C2726id.drawer_menu_myaccount).setChecked(true);
        this.watchingLayout.setOnClickListener(onRowClickListener);
        this.preBidLayout.setOnClickListener(onRowClickListener);
        this.wonHistoryLayout.setOnClickListener(onRowClickListener);
        this.awardPendingLayout.setOnClickListener(onRowClickListener);
        this.manageOfferLayout.setOnClickListener(onRowClickListener);
        this.toBePaidLayout.setOnClickListener(onRowClickListener);
        this.toBePickedUpLayout.setOnClickListener(onRowClickListener);
        this.lostPreBidLayout.setOnClickListener(onRowClickListener);
        this.alertLayout.setOnClickListener(onRowClickListener);
        this.buyNowOfferLayout.setOnClickListener(onRowClickListener);
        this.profile_layout.setOnClickListener(onRowClickListener);
        this.upgrade_account_layout.setOnClickListener(onRowClickListener);
        this.renewal_layout.setOnClickListener(onRowClickListener);
        this.License_and_document_layout.setOnClickListener(onRowClickListener);
        TextView textView = this.userName;
        textView.setText(this.sessionManager.getCurrentSessionFName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.sessionManager.getCurrentSessionLName());
        this.buyerIdInfo.setText(this.sessionManager.getCurrentSessionBuyerId());
        this.leave_feedback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MedalliaFBRemoteConfigModel medalliaFBRemoteConfigModel = IaaiApplication.getInstance().getIAARemoteConfig().medalliaFBRemoteConfigModel;
                if (medalliaFBRemoteConfigModel == null) {
                    AppUtils.showFeedBackDialog(view.getContext(), (IaaiApplication) MyAccountActivity.this.getApplication(), MyAccountActivity.this.mDrawerLayout, Constants.LIST_MY_ACCOUNT);
                } else if (medalliaFBRemoteConfigModel.is_medallia_enabled()) {
                    MyAccountActivity.this.setCustomParameterForMedallia();
                    MedalliaDigital.showForm(medalliaFBRemoteConfigModel.getFeedback_form_id(), new MDResultCallback() {
                        public void onSuccess() {
                            Log.d("Show Form", "Displayed");
                        }

                        public void onError(MDExternalError mDExternalError) {
                            Log.d("Show Form", " show " + mDExternalError.getMessage());
                        }
                    });
                } else {
                    AppUtils.showFeedBackDialog(view.getContext(), (IaaiApplication) MyAccountActivity.this.getApplication(), MyAccountActivity.this.mDrawerLayout, Constants.LIST_MY_ACCOUNT);
                }
            }
        });
        this.logOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MyAccountActivity.this.performLogout();
            }
        });
        loadDashboardData(false);
        this.chkMyVehiclesOnly.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MyAccountActivity.this.loadDashboardData(false);
            }
        });
        this.swipeRefreshLayout.setColorSchemeResources(C2723R.C2724color.refresh_progress_1, C2723R.C2724color.refresh_progress_2, C2723R.C2724color.refresh_progress_3);
        this.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            public void onRefresh() {
                MyAccountActivity.this.loadDashboardData(true);
            }
        });
        this.alert_count.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void setCustomParameterForMedallia() {
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.PAGE_NAME.getId(), "My Account");
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

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        IaaiApplication.getBus().unregister(this);
    }

    @Subscribe
    public void onLoginEventChanged(LoginState loginState) {
        super.updateNavigationHeader(loginState.isLogin());
        super.updateLoginNavigationMenu();
        super.handleLogOnNavigation(loginState.isLogin());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IaaiApplication.isMyAccountScreenShowing = true;
        loadDashboardData(false);
    }

    /* access modifiers changed from: private */
    public void loadDashboardData(final boolean z) {
        if (!z) {
            this.progressBar.setVisibility(0);
        }
        this.myAccountManager.loadDashboardData(this.chkMyVehiclesOnly.isChecked(), new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                Dashboard dashboard;
                try {
                    dashboard = (Dashboard) new Gson().fromJson(new String(bArr), Dashboard.class);
                } catch (Exception e) {
                    e.printStackTrace();
                    dashboard = null;
                }
                if (dashboard != null) {
                    MyAccountActivity.this.updateNewCountFirstTime(dashboard);
                    MyAccountActivity.this.updateView(dashboard);
                }
                MyAccountActivity.this.myAccountScrollView.scrollTo(0, 0);
                MyAccountActivity.this.progressBar.setVisibility(8);
                if (z) {
                    MyAccountActivity.this.swipeRefreshLayout.setRefreshing(false);
                }
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                MyAccountActivity.this.progressBar.setVisibility(8);
                if (z) {
                    MyAccountActivity.this.swipeRefreshLayout.setRefreshing(false);
                }
            }
        });
        this.myAccountManager.getBuyNowOfferCount(new AsyncHttpResponseHandler() {
            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
            }

            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                String str = new String(bArr);
                if (str.length() > 0) {
                    try {
                        MyAccountActivity.this.int_buyNowOfferCount = Integer.parseInt(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    MyAccountActivity myAccountActivity = MyAccountActivity.this;
                    myAccountActivity.updateNewCountForBNOFirstTime(myAccountActivity.int_buyNowOfferCount);
                    if (MyAccountActivity.this.int_buyNowOfferCount > 0) {
                        MyAccountActivity.this.buyNowOfferCount.setTextColor(MyAccountActivity.this.getResources().getColor(C2723R.C2724color.productdtl_action_area_btn_select_color));
                    }
                    MyAccountActivity.this.buyNowOfferCount.setText(str);
                    MyAccountActivity.this.updateViewForBNO();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void updateViewForBNO() {
        int myAccountCount = IAASharedPreference.getMyAccountCount(this, Constants.KEY_FOR_BUY_NOW_OFFER_COUNT_MYACCOUNT);
        if (this.int_buyNowOfferCount > myAccountCount) {
            this.buy_now_offer_new_count.setVisibility(0);
            TextView textView = this.buy_now_offer_new_count;
            textView.setText((this.int_buyNowOfferCount - myAccountCount) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(C2723R.string.new_my_account));
            return;
        }
        this.buy_now_offer_new_count.setVisibility(8);
    }

    public String getSelectedDateLabel() {
        return IaaiApplication.mContext.getString(C2723R.string.lbl_all);
    }

    /* access modifiers changed from: package-private */
    public void updateView(Dashboard dashboard) {
        this.dashboardData = dashboard;
        if (this.sessionManager.getCurrentSessionBuyerId() == null || !this.sessionManager.getCurrentSessionBuyerId().equals("0")) {
            this.manageOfferLayout.setVisibility(0);
        } else {
            this.manageOfferLayout.setVisibility(8);
        }
        if (this.dashboardData.winningPrebidsCount > 0) {
            this.preBidCount.setTextColor(getResources().getColor(C2723R.C2724color.productdtl_action_area_btn_select_color));
        }
        this.preBidCount.setText(Integer.toString(this.dashboardData.winningPrebidsCount));
        if (this.dashboardData.awardPendingCount > 0) {
            this.awardPendingCount.setTextColor(getResources().getColor(C2723R.C2724color.productdtl_action_area_btn_select_color));
        }
        this.awardPendingCount.setText(Integer.toString(this.dashboardData.awardPendingCount));
        if (this.dashboardData.vehicleCount > 0) {
            this.toBePaidCount.setTextColor(getResources().getColor(C2723R.C2724color.productdtl_action_area_btn_select_color));
        }
        this.toBePaidCount.setText(Integer.toString(this.dashboardData.vehicleCount));
        if (this.dashboardData.pickupCount > 0) {
            this.toBePickedUpCount.setTextColor(getResources().getColor(C2723R.C2724color.productdtl_action_area_btn_select_color));
        }
        this.toBePickedUpCount.setText(Integer.toString(this.dashboardData.pickupCount));
        if (this.dashboardData.alertsCount > 0) {
            this.alert_count.setTextColor(getResources().getColor(C2723R.C2724color.dash_bg));
            int convertDpToPixels = AppUtils.convertDpToPixels(4.0f, this);
            int convertDpToPixels2 = AppUtils.convertDpToPixels(8.0f, this);
            this.alert_count.setPadding(convertDpToPixels2, convertDpToPixels, convertDpToPixels2, convertDpToPixels);
            this.alert_count.setBackgroundResource(C2723R.C2725drawable.pass_due_round_rect_bg);
        }
        this.alert_count.setText(Integer.toString(this.dashboardData.alertsCount));
        if (!this.dashboardData.ProfileLinkInd.booleanValue() || isTablet(getApplicationContext())) {
            this.profile_layout.setVisibility(8);
        } else {
            this.profile_layout.setVisibility(0);
        }
        if (!this.dashboardData.LincenseLinkInd.booleanValue() || isTablet(getApplicationContext())) {
            this.License_and_document_layout.setVisibility(8);
        } else {
            this.License_and_document_layout.setVisibility(0);
        }
        if (!this.dashboardData.UpgradeLinkInd.booleanValue() || isTablet(getApplicationContext())) {
            this.upgrade_account_layout.setVisibility(8);
        } else {
            this.upgrade_account_layout.setVisibility(0);
        }
        if (!this.dashboardData.RenewalLinkInd.booleanValue() || isTablet(getApplicationContext())) {
            this.renewal_layout.setVisibility(8);
        } else {
            this.renewal_layout.setVisibility(0);
        }
        if (this.dashboardData.NegotiationOffers > 0) {
            this.manageOfferCount.setTextColor(getResources().getColor(C2723R.C2724color.productdtl_action_area_btn_select_color));
        }
        this.manageOfferCount.setText(Integer.toString(this.dashboardData.NegotiationOffers));
        updateMYAccountNewCount();
    }

    public static boolean isTablet(Context context) {
        return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    private void updateMYAccountNewCount() {
        int myAccountCount = IAASharedPreference.getMyAccountCount(this, Constants.KEY_FOR_PREBID_COUNT_MYACCOUNT);
        if (this.dashboardData.winningPrebidsCount > myAccountCount) {
            this.preBidNewCount.setVisibility(0);
            TextView textView = this.preBidNewCount;
            textView.setText((this.dashboardData.winningPrebidsCount - myAccountCount) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(C2723R.string.new_my_account));
        } else {
            this.preBidNewCount.setVisibility(8);
        }
        int myAccountCount2 = IAASharedPreference.getMyAccountCount(this, Constants.KEY_FOR_AWARD_PENDING_COUNT_MYACCOUNT);
        if (this.dashboardData.awardPendingCount > myAccountCount2) {
            this.awardPendingNewCount.setVisibility(0);
            TextView textView2 = this.awardPendingNewCount;
            textView2.setText((this.dashboardData.awardPendingCount - myAccountCount2) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(C2723R.string.new_my_account));
        } else {
            this.awardPendingNewCount.setVisibility(8);
        }
        int myAccountCount3 = IAASharedPreference.getMyAccountCount(this, Constants.KEY_FOR_TOBEPAID_COUNT_MYACCOUNT);
        if (this.dashboardData.vehicleCount > myAccountCount3) {
            this.toBePaidNewCount.setVisibility(0);
            TextView textView3 = this.toBePaidNewCount;
            textView3.setText((this.dashboardData.vehicleCount - myAccountCount3) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(C2723R.string.new_my_account));
        } else {
            this.toBePaidNewCount.setVisibility(8);
        }
        int myAccountCount4 = IAASharedPreference.getMyAccountCount(this, Constants.KEY_FOR_TBPU_COUNT_MYACCOUNT);
        if (this.dashboardData.pickupCount > myAccountCount4) {
            this.toBePickedUpNewCount.setVisibility(0);
            TextView textView4 = this.toBePickedUpNewCount;
            textView4.setText((this.dashboardData.pickupCount - myAccountCount4) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(C2723R.string.new_my_account));
        } else {
            this.toBePickedUpNewCount.setVisibility(8);
        }
        int myAccountCount5 = IAASharedPreference.getMyAccountCount(this, Constants.KEY_FOR_MANAGE_OFFERS_MYACCOUNT);
        if (this.dashboardData.NegotiationOffers > myAccountCount5) {
            this.manageOfferNewCount.setVisibility(0);
            TextView textView5 = this.manageOfferNewCount;
            textView5.setText((this.dashboardData.NegotiationOffers - myAccountCount5) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getString(C2723R.string.new_my_account));
            return;
        }
        this.manageOfferNewCount.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void updateNewCountFirstTime(Dashboard dashboard) {
        if (IaaiApplication.isUserLogin) {
            IAASharedPreference.setMyAccountCount(this, Constants.KEY_FOR_PREBID_COUNT_MYACCOUNT, dashboard.winningPrebidsCount);
            IAASharedPreference.setMyAccountCount(this, Constants.KEY_FOR_AWARD_PENDING_COUNT_MYACCOUNT, dashboard.awardPendingCount);
            IAASharedPreference.setMyAccountCount(this, Constants.KEY_FOR_TOBEPAID_COUNT_MYACCOUNT, dashboard.vehicleCount);
            IAASharedPreference.setMyAccountCount(this, Constants.KEY_FOR_TBPU_COUNT_MYACCOUNT, dashboard.pickupCount);
            IAASharedPreference.setMyAccountCount(this, Constants.KEY_FOR_MANAGE_OFFERS_MYACCOUNT, dashboard.NegotiationOffers);
            IaaiApplication.isUserLogin = false;
        }
    }

    /* access modifiers changed from: private */
    public void updateNewCountForBNOFirstTime(int i) {
        if (IaaiApplication.isUserLoginForBuyNowOffer) {
            IAASharedPreference.setMyAccountCount(this, Constants.KEY_FOR_BUY_NOW_OFFER_COUNT_MYACCOUNT, i);
            IaaiApplication.isUserLoginForBuyNowOffer = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void performLogout() {
        this.sessionManager.logout(this);
        this.sessionManager.clearLoginResponseObject();
        AppUtils.resetNewCountPrefsOnLogout(this);
        IaaiApplication.isMyAccountScreenShowing = false;
        Intent intent = null;
        this.contentResolver.delete(IaaContent.Alert.CONTENT_URI, (String) null, (String[]) null);
        Toast.makeText(this, C2723R.string.msg_logout, 1).show();
        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_auction;
        this.mDrawerLayout.closeDrawer((int) GravityCompat.START);
        if (IaaiApplication.isBDTEnabled) {
            if (IaaiApplication.is_new_landing) {
                intent = new Intent(this, BDTLandingPageActivity.class);
            } else {
                intent = new Intent(this, BDTAuctionMainListActivity.class);
            }
        }
        startActivity(intent);
        finish();
    }

    /* access modifiers changed from: private */
    public void navigateToManageOffer() {
        Intent intent = new Intent(this, ManageOfferListActivity.class);
        Dashboard dashboard = this.dashboardData;
        if (dashboard != null) {
            intent.putExtra(Constants_MVVM.EXTRA_MANAGE_OFFERS, dashboard.NegotiationOffers);
        }
        startActivity(intent);
    }

    /* access modifiers changed from: private */
    public void navigateToBuyNowOffer() {
        Intent intent = new Intent(this, MDBuyNowOfferListActivity.class);
        intent.putExtra(Constants.KEY_FOR_BUY_NOW_OFFER_COUNT_MYACCOUNT, this.int_buyNowOfferCount);
        startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 35) {
            navigateToManageOffer();
        } else if (i == 36) {
            navigateToBuyNowOffer();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    private class OnRowClickListener implements View.OnClickListener {
        private OnRowClickListener() {
        }

        public void onClick(View view) {
            showMyVehicles(view.getId());
        }

        private void showMyVehicles(int i) {
            boolean isChecked = MyAccountActivity.this.sessionManager.isCurrentSessionUserOwner() ? MyAccountActivity.this.chkMyVehiclesOnly.isChecked() : true;
            switch (i) {
                case C2723R.C2726id.License_and_document_layout:
                    Intent intent = new Intent(MyAccountActivity.this, SSORegistrationActivity.class);
                    intent.addCategory("android.intent.category.DEFAULT");
                    intent.putExtra(Constants.EXTRA_SSO_URL, MyAccountActivity.this.dashboardData.LicenseLink);
                    MyAccountActivity.this.startActivity(intent);
                    return;
                case C2723R.C2726id.alert_layout:
                    MyAccountActivity.this.startActivity(new Intent(MyAccountActivity.this, AlertListActivity.class));
                    return;
                case C2723R.C2726id.award_pending_layout:
                    Intent intent2 = new Intent(MyAccountActivity.this, MDAwardPendingListActivity.class);
                    intent2.addCategory("android.intent.category.DEFAULT");
                    intent2.putExtra("status", 15);
                    intent2.putExtra("isMyItemOnly", isChecked);
                    if (MyAccountActivity.this.dashboardData != null) {
                        intent2.putExtra(Constants.WATCHING_SIZE, MyAccountActivity.this.dashboardData.awardPendingCount);
                    }
                    MyAccountActivity.this.startActivity(intent2);
                    return;
                case C2723R.C2726id.buy_now_offer_layout:
                    SessionManager sessionManager = MyAccountActivity.this.sessionManager;
                    MyAccountActivity myAccountActivity = MyAccountActivity.this;
                    if (!sessionManager.promptForLoginIfNeedFromActivity(myAccountActivity, myAccountActivity, 36)) {
                        MyAccountActivity.this.navigateToBuyNowOffer();
                        return;
                    }
                    return;
                case C2723R.C2726id.lostprebid_layout:
                    Intent intent3 = new Intent(MyAccountActivity.this, MDLostPreBidListActivity.class);
                    intent3.addCategory("android.intent.category.DEFAULT");
                    intent3.putExtra("status", 50);
                    intent3.putExtra("isMyItemOnly", isChecked);
                    MyAccountActivity.this.startActivity(intent3);
                    return;
                case C2723R.C2726id.prebid_layout:
                    Intent intent4 = new Intent(MyAccountActivity.this, MDPreBidListActivity.class);
                    intent4.addCategory("android.intent.category.DEFAULT");
                    intent4.putExtra("status", 60);
                    intent4.putExtra("isMyItemOnly", isChecked);
                    if (MyAccountActivity.this.dashboardData != null) {
                        intent4.putExtra(Constants.WATCHING_SIZE, MyAccountActivity.this.dashboardData.winningPrebidsCount);
                    }
                    MyAccountActivity.this.startActivity(intent4);
                    return;
                case C2723R.C2726id.profile_layout:
                    Intent intent5 = new Intent(MyAccountActivity.this, SSORegistrationActivity.class);
                    intent5.addCategory("android.intent.category.DEFAULT");
                    intent5.putExtra(Constants.EXTRA_SSO_URL, MyAccountActivity.this.dashboardData.ProfileLink);
                    MyAccountActivity.this.startActivity(intent5);
                    return;
                case C2723R.C2726id.renewal_layout:
                    Intent intent6 = new Intent(MyAccountActivity.this, SSORegistrationActivity.class);
                    intent6.addCategory("android.intent.category.DEFAULT");
                    intent6.putExtra(Constants.EXTRA_SSO_URL, MyAccountActivity.this.dashboardData.RenewalLink);
                    MyAccountActivity.this.startActivity(intent6);
                    return;
                case C2723R.C2726id.rlManageOfferLayout:
                    SessionManager sessionManager2 = MyAccountActivity.this.sessionManager;
                    MyAccountActivity myAccountActivity2 = MyAccountActivity.this;
                    if (!sessionManager2.promptForLoginIfNeedFromActivity(myAccountActivity2, myAccountActivity2, 35)) {
                        MyAccountActivity.this.navigateToManageOffer();
                        return;
                    }
                    return;
                case C2723R.C2726id.tobepaid_layout:
                    String str = MyAccountActivity.this.sessionManager.isCurrentSessionUserOwner() ? MyAccountActivity.this.chkMyVehiclesOnly.isChecked() : true ? IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE : "0";
                    Intent intent7 = new Intent(MyAccountActivity.this, MDToBePaidListActivity.class);
                    if (MyAccountActivity.this.dashboardData != null) {
                        intent7.putExtra(Constants.WATCHING_SIZE, MyAccountActivity.this.dashboardData.vehicleCount);
                        intent7.putExtra(Constants.EXTRA_AWARD_PENDING_COUNT, MyAccountActivity.this.dashboardData.awardPendingCount);
                        intent7.putExtra(Constants.EXTRA_TOBPAID_TOTAL_DUE, UiUtils.formatCurrency(MyAccountActivity.this.dashboardData.totalToBePaidAmount, true));
                        intent7.putExtra(Constants.EXTRA_TOBPAID_AW_AMOUNT, UiUtils.formatCurrency(MyAccountActivity.this.dashboardData.TotalAwardPending, false));
                    }
                    intent7.putExtra(Constants.EXTRA_TOBPAID_MY_VEHICLES_ONLY, str);
                    MyAccountActivity.this.startActivity(intent7);
                    return;
                case C2723R.C2726id.tobepickedup_layout:
                    Intent intent8 = new Intent(MyAccountActivity.this, MDToBePickedUpListActivity.class);
                    intent8.putExtra("isMyItemOnly", isChecked);
                    if (MyAccountActivity.this.dashboardData != null) {
                        intent8.putExtra(Constants.WATCHING_SIZE, MyAccountActivity.this.dashboardData.pickupCount);
                    }
                    MyAccountActivity.this.startActivity(intent8);
                    return;
                case C2723R.C2726id.upgrade_account_layout:
                    Intent intent9 = new Intent(MyAccountActivity.this, SSORegistrationActivity.class);
                    intent9.addCategory("android.intent.category.DEFAULT");
                    intent9.putExtra(Constants.EXTRA_SSO_URL, MyAccountActivity.this.dashboardData.UpgradeLink);
                    MyAccountActivity.this.startActivity(intent9);
                    return;
                case C2723R.C2726id.watching_layout:
                    Intent intent10 = new Intent(MyAccountActivity.this, MDWatchingListActivity.class);
                    intent10.addCategory("android.intent.category.DEFAULT");
                    intent10.putExtra("status", 1);
                    intent10.putExtra("isMyItemOnly", isChecked);
                    MyAccountActivity.this.startActivity(intent10);
                    return;
                case C2723R.C2726id.won_history_layout:
                    Intent intent11 = new Intent(MyAccountActivity.this, MDPurchaseHistoryListActivity.class);
                    intent11.addCategory("android.intent.category.DEFAULT");
                    intent11.putExtra("status", 55);
                    intent11.putExtra("isMyItemOnly", isChecked);
                    MyAccountActivity.this.startActivity(intent11);
                    return;
                default:
                    return;
            }
        }
    }
}
