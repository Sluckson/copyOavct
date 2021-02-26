package com.iaai.android.bdt.base;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
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
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.model.login.BDTLoginResponse;
import com.iaai.android.bdt.model.medalliainfo.MedalliaFBRemoteConfigModel;
import com.iaai.android.bdt.utils.SharedPrefsHelper;
import com.iaai.android.old.activities.AlertListNavDrawerActivity;
import com.iaai.android.old.activities.SettingsActivity;
import com.iaai.android.old.utils.AppUtils;
import com.iaai.android.old.utils.constants.Constants;
import com.medallia.digital.mobilesdk.MDExternalError;
import com.medallia.digital.mobilesdk.MDResultCallback;
import com.medallia.digital.mobilesdk.MedalliaDigital;
import java.util.HashMap;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 B2\u00020\u0001:\u0002BCB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\fJ\u000e\u0010*\u001a\u00020(2\u0006\u0010+\u001a\u00020\fJ\b\u0010,\u001a\u00020(H\u0002J\"\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u000101H\u0014J\b\u00102\u001a\u00020(H\u0016J\u0012\u00103\u001a\u00020(2\b\u00104\u001a\u0004\u0018\u000105H\u0004J\u0010\u00106\u001a\u00020\f2\u0006\u00107\u001a\u000208H\u0016J\u0010\u00109\u001a\u00020(2\u0006\u0010)\u001a\u00020\fH\u0016J\u0006\u0010:\u001a\u00020(J\b\u0010;\u001a\u00020(H\u0002J\b\u0010<\u001a\u00020(H\u0002J\b\u0010=\u001a\u00020(H\u0002J\u000e\u0010>\u001a\u00020(2\u0006\u0010?\u001a\u00020\u001cJ\u000e\u0010@\u001a\u00020(2\u0006\u0010?\u001a\u00020\u001cJ\u000e\u0010A\u001a\u00020(2\u0006\u0010)\u001a\u00020\fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006D"}, mo66933d2 = {"Lcom/iaai/android/bdt/base/MVVMNavDrawerActivity;", "Lcom/iaai/android/bdt/base/BaseActivity;", "()V", "fabMargin", "", "getFabMargin", "()I", "setFabMargin", "(I)V", "mBuyerID", "Landroid/widget/TextView;", "mIsUserPressedBack", "", "getMIsUserPressedBack", "()Z", "setMIsUserPressedBack", "(Z)V", "mMenuNavigationBtn", "Landroid/widget/ImageView;", "mToolbar", "Landroidx/appcompat/widget/Toolbar;", "getMToolbar", "()Landroidx/appcompat/widget/Toolbar;", "setMToolbar", "(Landroidx/appcompat/widget/Toolbar;)V", "mUserLearnedDrawer", "mUserName", "sessionManager", "Lcom/iaai/android/bdt/feature/login/SessionManager;", "getSessionManager", "()Lcom/iaai/android/bdt/feature/login/SessionManager;", "setSessionManager", "(Lcom/iaai/android/bdt/feature/login/SessionManager;)V", "sharedPrefsHelper", "Lcom/iaai/android/bdt/utils/SharedPrefsHelper;", "getSharedPrefsHelper", "()Lcom/iaai/android/bdt/utils/SharedPrefsHelper;", "setSharedPrefsHelper", "(Lcom/iaai/android/bdt/utils/SharedPrefsHelper;)V", "handleLogOnNavigation", "", "isLogin", "hideNavDrawer", "isVisible", "launchFeedback", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreateDrawer", "savedInstanceState", "Landroid/os/Bundle;", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "refreshViewBasedOnLoginStatus", "setBrokerCommunityHelpLink", "setCustomParameterForMedallia", "setUpNavDrawer", "setUpToolbar", "setUserNameAndBuyerID", "loginManager", "updateLoginNavigationMenu", "updateNavigationHeader", "Companion", "mdResultCallback", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MVVMNavDrawerActivity.kt */
public class MVVMNavDrawerActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DRAWER_MENU_TYPE_LOGIN_MENU = 1;
    public static final int DRAWER_MENU_TYPE_MAIN_MENU = 0;
    private static final float ROTATE_FROM = 0.0f;
    private static final float ROTATE_TO = ROTATE_TO;
    private static final String TAB_ID_DASHBOARD = "DashboardTab";
    private static final String TAB_ID_LOGIN = "LoginTab";
    private static final String TAB_ID_PIN = "PinTab";
    private HashMap _$_findViewCache;
    private int fabMargin;
    private TextView mBuyerID;
    private boolean mIsUserPressedBack;
    /* access modifiers changed from: private */
    public ImageView mMenuNavigationBtn;
    @NotNull
    public Toolbar mToolbar;
    private boolean mUserLearnedDrawer;
    private TextView mUserName;
    @Inject
    @NotNull
    public SessionManager sessionManager;
    @Inject
    @NotNull
    public SharedPrefsHelper sharedPrefsHelper;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public static final /* synthetic */ ImageView access$getMMenuNavigationBtn$p(MVVMNavDrawerActivity mVVMNavDrawerActivity) {
        ImageView imageView = mVVMNavDrawerActivity.mMenuNavigationBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMenuNavigationBtn");
        }
        return imageView;
    }

    @NotNull
    public final Toolbar getMToolbar() {
        Toolbar toolbar = this.mToolbar;
        if (toolbar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mToolbar");
        }
        return toolbar;
    }

    public final void setMToolbar(@NotNull Toolbar toolbar) {
        Intrinsics.checkParameterIsNotNull(toolbar, "<set-?>");
        this.mToolbar = toolbar;
    }

    public final int getFabMargin() {
        return this.fabMargin;
    }

    public final void setFabMargin(int i) {
        this.fabMargin = i;
    }

    public final boolean getMIsUserPressedBack() {
        return this.mIsUserPressedBack;
    }

    public final void setMIsUserPressedBack(boolean z) {
        this.mIsUserPressedBack = z;
    }

    @NotNull
    public final SessionManager getSessionManager() {
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        return sessionManager2;
    }

    public final void setSessionManager(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "<set-?>");
        this.sessionManager = sessionManager2;
    }

    @NotNull
    public final SharedPrefsHelper getSharedPrefsHelper() {
        SharedPrefsHelper sharedPrefsHelper2 = this.sharedPrefsHelper;
        if (sharedPrefsHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sharedPrefsHelper");
        }
        return sharedPrefsHelper2;
    }

    public final void setSharedPrefsHelper(@NotNull SharedPrefsHelper sharedPrefsHelper2) {
        Intrinsics.checkParameterIsNotNull(sharedPrefsHelper2, "<set-?>");
        this.sharedPrefsHelper = sharedPrefsHelper2;
    }

    /* access modifiers changed from: protected */
    public final void onCreateDrawer(@Nullable Bundle bundle) {
        setUpToolbar();
        setUpNavDrawer();
        View headerView = ((NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view)).getHeaderView(0);
        View findViewById = headerView.findViewById(C2723R.C2726id.user_name);
        if (findViewById != null) {
            this.mUserName = (TextView) findViewById;
            View findViewById2 = headerView.findViewById(C2723R.C2726id.buyer_id);
            if (findViewById2 != null) {
                this.mBuyerID = (TextView) findViewById2;
                View findViewById3 = headerView.findViewById(C2723R.C2726id.drawer_menu_navigation_button);
                if (findViewById3 != null) {
                    this.mMenuNavigationBtn = (ImageView) findViewById3;
                    ImageView imageView = this.mMenuNavigationBtn;
                    if (imageView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMenuNavigationBtn");
                    }
                    imageView.setTag(0);
                    setBrokerCommunityHelpLink();
                    ((NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view)).setNavigationItemSelectedListener(new MVVMNavDrawerActivity$onCreateDrawer$1(this));
                    ((DrawerLayout) _$_findCachedViewById(C2723R.C2726id.nav_drawer)).addDrawerListener(new MVVMNavDrawerActivity$onCreateDrawer$2(this));
                    ((DrawerLayout) _$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.TextView");
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016¨\u0006\b"}, mo66933d2 = {"Lcom/iaai/android/bdt/base/MVVMNavDrawerActivity$mdResultCallback;", "Lcom/medallia/digital/mobilesdk/MDResultCallback;", "()V", "onError", "", "error", "Lcom/medallia/digital/mobilesdk/MDExternalError;", "onSuccess", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: MVVMNavDrawerActivity.kt */
    public static final class mdResultCallback implements MDResultCallback {
        public static final mdResultCallback INSTANCE = new mdResultCallback();

        private mdResultCallback() {
        }

        public void onSuccess() {
            Log.d("Show Form", "Displayed");
        }

        public void onError(@Nullable MDExternalError mDExternalError) {
            StringBuilder sb = new StringBuilder();
            sb.append(" show ");
            sb.append(mDExternalError != null ? mDExternalError.getMessage() : null);
            Log.d("Show Form", sb.toString());
        }
    }

    public final void setBrokerCommunityHelpLink() {
        NavigationView navigationView = (NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view);
        Intrinsics.checkExpressionValueIsNotNull(navigationView, "nav_view");
        Menu menu = navigationView.getMenu();
        Intrinsics.checkExpressionValueIsNotNull(menu, "nav_view.menu");
        MenuItem findItem = menu.findItem(C2723R.C2726id.drawer_menu_help);
        if (findItem != null) {
            IaaiApplication instance = IaaiApplication.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
            findItem.setVisible(instance.getIAARemoteConfig().getBorkerCommunityFlag());
        }
    }

    public void onBackPressed() {
        if (this.mIsUserPressedBack) {
            finish();
            return;
        }
        this.mIsUserPressedBack = true;
        Snackbar make = Snackbar.make((View) (DrawerLayout) _$_findCachedViewById(C2723R.C2726id.nav_drawer), (CharSequence) getString(C2723R.string.press_back_again_to_exit_text), 0);
        Intrinsics.checkExpressionValueIsNotNull(make, "Snackbar\n               …t), Snackbar.LENGTH_LONG)");
        make.show();
    }

    private final void setUpToolbar() {
        setSupportActionBar((Toolbar) _$_findCachedViewById(C2723R.C2726id.auction_toolbar));
        this.fabMargin = getResources().getDimensionPixelSize(C2723R.dimen.fab_margin);
    }

    /* access modifiers changed from: private */
    public final void launchFeedback() {
        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_feedback;
        IaaiApplication instance = IaaiApplication.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(instance, "IaaiApplication.getInstance()");
        MedalliaFBRemoteConfigModel medalliaFBRemoteConfigModel = instance.getIAARemoteConfig().getMedalliaFBRemoteConfigModel();
        if (medalliaFBRemoteConfigModel == null) {
            Context context = this;
            Application application = getApplication();
            if (application != null) {
                AppUtils.showFeedBackDialog(context, (IaaiApplication) application, (DrawerLayout) _$_findCachedViewById(C2723R.C2726id.nav_drawer), Constants.LIST_NAVIGATION_DRAWER_MENU);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.IaaiApplication");
        } else if (medalliaFBRemoteConfigModel.is_medallia_enabled()) {
            setCustomParameterForMedallia();
            MedalliaDigital.showForm(medalliaFBRemoteConfigModel.getFeedback_form_id(), mdResultCallback.INSTANCE);
        } else {
            Context context2 = this;
            Application application2 = getApplication();
            if (application2 != null) {
                AppUtils.showFeedBackDialog(context2, (IaaiApplication) application2, (DrawerLayout) _$_findCachedViewById(C2723R.C2726id.nav_drawer), Constants.LIST_NAVIGATION_DRAWER_MENU);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.iaai.android.IaaiApplication");
        }
    }

    private final void setCustomParameterForMedallia() {
        int i;
        int i2;
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.PAGE_NAME.getId(), "Navigation Drawer");
        SessionManager sessionManager2 = this.sessionManager;
        if (sessionManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        CharSequence currentSessionUserId = sessionManager2.getCurrentSessionUserId();
        boolean z = true;
        int i3 = 0;
        if (!(currentSessionUserId == null || currentSessionUserId.length() == 0)) {
            SessionManager sessionManager3 = this.sessionManager;
            if (sessionManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            i = Integer.parseInt(sessionManager3.getCurrentSessionUserId());
        } else {
            i = 0;
        }
        SessionManager sessionManager4 = this.sessionManager;
        if (sessionManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        CharSequence currentSessionUserId2 = sessionManager4.getCurrentSessionUserId();
        if (!(currentSessionUserId2 == null || currentSessionUserId2.length() == 0)) {
            SessionManager sessionManager5 = this.sessionManager;
            if (sessionManager5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            if (Intrinsics.areEqual((Object) sessionManager5.getCurrentSessionBuyerId(), (Object) "0")) {
                MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.EMPLOYER_ID.getId(), 0);
                MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.BUYER_ID.getId(), 0);
                MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.USER_ID.getId(), Integer.valueOf(i));
                return;
            }
        }
        SessionManager sessionManager6 = this.sessionManager;
        if (sessionManager6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        CharSequence currentSessionBuyerId = sessionManager6.getCurrentSessionBuyerId();
        if (!(currentSessionBuyerId == null || currentSessionBuyerId.length() == 0)) {
            SessionManager sessionManager7 = this.sessionManager;
            if (sessionManager7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            i2 = Integer.parseInt(sessionManager7.getCurrentSessionBuyerId());
        } else {
            i2 = 0;
        }
        SessionManager sessionManager8 = this.sessionManager;
        if (sessionManager8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        CharSequence buyerEmployeeId = sessionManager8.getBuyerEmployeeId();
        if (!(buyerEmployeeId == null || buyerEmployeeId.length() == 0)) {
            z = false;
        }
        if (!z) {
            SessionManager sessionManager9 = this.sessionManager;
            if (sessionManager9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            i3 = Integer.parseInt(sessionManager9.getBuyerEmployeeId());
        }
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.EMPLOYER_ID.getId(), Integer.valueOf(i3));
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.BUYER_ID.getId(), Integer.valueOf(i2));
        MedalliaDigital.setCustomParameter(MedalliaCustomParameters.MedalliaCustomParametersKeyNames.USER_ID.getId(), Integer.valueOf(i));
    }

    private final void setUpNavDrawer() {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            Intrinsics.throwNpe();
        }
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(2);
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayHomeAsUpEnabled(true);
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setHomeButtonEnabled(true);
        }
        ActionBar supportActionBar4 = getSupportActionBar();
        if (supportActionBar4 != null) {
            supportActionBar4.setDisplayShowTitleEnabled(true);
        }
        if (IaaiApplication.isBDTEnabled) {
            ActionBar supportActionBar5 = getSupportActionBar();
            if (supportActionBar5 != null) {
                supportActionBar5.setHomeAsUpIndicator((int) C2723R.C2725drawable.ic_menu_bdt);
            }
        } else {
            ActionBar supportActionBar6 = getSupportActionBar();
            if (supportActionBar6 != null) {
                supportActionBar6.setHomeAsUpIndicator((int) C2723R.C2725drawable.ic_drawer);
            }
        }
        if (!this.mUserLearnedDrawer) {
            ((DrawerLayout) _$_findCachedViewById(C2723R.C2726id.nav_drawer)).openDrawer((int) GravityCompat.START);
            this.mUserLearnedDrawer = true;
        }
    }

    public final void hideNavDrawer(boolean z) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            Intrinsics.throwNpe();
        }
        supportActionBar.setDisplayHomeAsUpEnabled(z);
        getWindow().setSoftInputMode(2);
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            supportActionBar2.setDisplayHomeAsUpEnabled(z);
        }
        ActionBar supportActionBar3 = getSupportActionBar();
        if (supportActionBar3 != null) {
            supportActionBar3.setHomeButtonEnabled(z);
        }
        ActionBar supportActionBar4 = getSupportActionBar();
        if (supportActionBar4 != null) {
            supportActionBar4.setDisplayShowTitleEnabled(z);
        }
        if (IaaiApplication.isBDTEnabled) {
            ActionBar supportActionBar5 = getSupportActionBar();
            if (supportActionBar5 != null) {
                supportActionBar5.setHomeAsUpIndicator((int) C2723R.C2725drawable.ic_menu_bdt);
            }
        } else {
            ActionBar supportActionBar6 = getSupportActionBar();
            if (supportActionBar6 != null) {
                supportActionBar6.setHomeAsUpIndicator((int) C2723R.C2725drawable.ic_drawer);
            }
        }
        if (!this.mUserLearnedDrawer) {
            ((DrawerLayout) _$_findCachedViewById(C2723R.C2726id.nav_drawer)).openDrawer((int) GravityCompat.START);
            this.mUserLearnedDrawer = true;
        }
    }

    public final void setUserNameAndBuyerID(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "loginManager");
        updateNavigationHeader(sessionManager2.isLoggedIn());
        ImageView imageView = this.mMenuNavigationBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMenuNavigationBtn");
        }
        imageView.setOnClickListener(new MVVMNavDrawerActivity$setUserNameAndBuyerID$1(this, sessionManager2));
    }

    public final void updateNavigationHeader(boolean z) {
        if (z) {
            TextView textView = this.mUserName;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mUserName");
            }
            StringBuilder sb = new StringBuilder();
            SessionManager sessionManager2 = this.sessionManager;
            if (sessionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            sb.append(sessionManager2.getCurrentSessionFName());
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            SessionManager sessionManager3 = this.sessionManager;
            if (sessionManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            sb.append(sessionManager3.getCurrentSessionLName());
            textView.setText(sb.toString());
            TextView textView2 = this.mBuyerID;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBuyerID");
            }
            textView2.setVisibility(0);
            TextView textView3 = this.mBuyerID;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mBuyerID");
            }
            SessionManager sessionManager4 = this.sessionManager;
            if (sessionManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            textView3.setText(sessionManager4.getCurrentSessionBuyerId());
            return;
        }
        TextView textView4 = this.mUserName;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mUserName");
        }
        textView4.setText("Guest user");
        TextView textView5 = this.mBuyerID;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBuyerID");
        }
        textView5.setVisibility(8);
    }

    public final void handleLogOnNavigation(boolean z) {
        if (!z) {
            return;
        }
        if (IaaiApplication.selected_navigation_drawer_optionid == C2723R.C2726id.drawer_menu_notifications) {
            ((DrawerLayout) _$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
            startActivity(new Intent(this, AlertListNavDrawerActivity.class));
            finish();
        } else if (IaaiApplication.selected_navigation_drawer_optionid == C2723R.C2726id.drawer_menu_myaccount) {
            ((DrawerLayout) _$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
            startActivity(new Intent(this, BDTMyAccountActivity.class));
            finish();
        }
    }

    public final void updateLoginNavigationMenu(@NotNull SessionManager sessionManager2) {
        Intrinsics.checkParameterIsNotNull(sessionManager2, "loginManager");
        ImageView imageView = this.mMenuNavigationBtn;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMenuNavigationBtn");
        }
        Object tag = imageView.getTag();
        if (tag == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
        } else if (((Integer) tag).intValue() != 1) {
        } else {
            if (sessionManager2.isLoggedIn()) {
                NavigationView navigationView = (NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view);
                Intrinsics.checkExpressionValueIsNotNull(navigationView, "nav_view");
                navigationView.getMenu().clear();
                ((NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view)).inflateMenu(C2723R.C2729menu.drawer);
                NavigationView navigationView2 = (NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view);
                Intrinsics.checkExpressionValueIsNotNull(navigationView2, "nav_view");
                Menu menu = navigationView2.getMenu();
                Intrinsics.checkExpressionValueIsNotNull(menu, "nav_view.menu");
                if (IaaiApplication.selected_navigation_drawer_optionid != -1) {
                    MenuItem findItem = menu.findItem(IaaiApplication.selected_navigation_drawer_optionid);
                    Intrinsics.checkExpressionValueIsNotNull(findItem, "menuItem");
                    findItem.setChecked(true);
                }
                ImageView imageView2 = this.mMenuNavigationBtn;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMenuNavigationBtn");
                }
                imageView2.setTag(0);
                if (Build.VERSION.SDK_INT >= 21) {
                    ImageView imageView3 = this.mMenuNavigationBtn;
                    if (imageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mMenuNavigationBtn");
                    }
                    imageView3.setImageDrawable(getDrawable(C2723R.C2725drawable.ic_drawer_down_arrow));
                }
                ((NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view)).invalidate();
                return;
            }
            NavigationView navigationView3 = (NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view);
            Intrinsics.checkExpressionValueIsNotNull(navigationView3, "nav_view");
            navigationView3.getMenu().clear();
            ((NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view)).inflateMenu(C2723R.C2729menu.login_drawer);
            NavigationView navigationView4 = (NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view);
            Intrinsics.checkExpressionValueIsNotNull(navigationView4, "nav_view");
            Menu menu2 = navigationView4.getMenu();
            Intrinsics.checkExpressionValueIsNotNull(menu2, "nav_view.menu");
            MenuItem findItem2 = menu2.findItem(C2723R.C2726id.drawer_menu_login);
            MenuItem findItem3 = menu2.findItem(C2723R.C2726id.drawer_menu_logout);
            MenuItem findItem4 = menu2.findItem(C2723R.C2726id.drawer_menu_register_now);
            Intrinsics.checkExpressionValueIsNotNull(findItem2, "login");
            findItem2.setVisible(true);
            Intrinsics.checkExpressionValueIsNotNull(findItem4, "register");
            findItem4.setVisible(true);
            Intrinsics.checkExpressionValueIsNotNull(findItem3, "logout");
            findItem3.setVisible(false);
            ((NavigationView) _$_findCachedViewById(C2723R.C2726id.nav_view)).invalidate();
            if (Build.VERSION.SDK_INT >= 21) {
                ImageView imageView4 = this.mMenuNavigationBtn;
                if (imageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMenuNavigationBtn");
                }
                imageView4.setImageDrawable(getDrawable(C2723R.C2725drawable.ic_drawer_up_arrow));
            }
        }
    }

    public void refreshViewBasedOnLoginStatus(boolean z) {
        if (z) {
            SharedPrefsHelper sharedPrefsHelper2 = this.sharedPrefsHelper;
            if (sharedPrefsHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sharedPrefsHelper");
            }
            SessionManager sessionManager2 = this.sessionManager;
            if (sessionManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            String str = sharedPrefsHelper2.get(sessionManager2.getPREF_LAST_LOGIN_USER_INFO(), "");
            if (str == null || str.length() <= 0) {
                IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_myaccount;
                SessionManager sessionManager3 = this.sessionManager;
                if (sessionManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
                }
                sessionManager3.promptForLoginIfNeededBDT(this, 33);
                return;
            }
            BDTLoginResponse bDTLoginResponse = (BDTLoginResponse) new Gson().fromJson(str, BDTLoginResponse.class);
            SessionManager sessionManager4 = this.sessionManager;
            if (sessionManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
            }
            Intrinsics.checkExpressionValueIsNotNull(bDTLoginResponse, "loginResponse");
            sessionManager4.setLoginResponse(bDTLoginResponse);
            ((DrawerLayout) _$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
            startActivity(new Intent(this, BDTMyAccountActivity.class));
            finish();
            return;
        }
        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_myaccount;
        SessionManager sessionManager5 = this.sessionManager;
        if (sessionManager5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sessionManager");
        }
        sessionManager5.promptForLoginIfNeededBDT(this, 33);
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nXT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/base/MVVMNavDrawerActivity$Companion;", "", "()V", "DRAWER_MENU_TYPE_LOGIN_MENU", "", "DRAWER_MENU_TYPE_MAIN_MENU", "ROTATE_FROM", "", "ROTATE_TO", "TAB_ID_DASHBOARD", "", "TAB_ID_LOGIN", "TAB_ID_PIN", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: MVVMNavDrawerActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public boolean onOptionsItemSelected(@NotNull MenuItem menuItem) {
        Intrinsics.checkParameterIsNotNull(menuItem, "item");
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        ((DrawerLayout) _$_findCachedViewById(C2723R.C2726id.nav_drawer)).openDrawer((int) GravityCompat.START);
        return true;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        if (i2 == -1) {
            if (i == 33) {
                ((DrawerLayout) _$_findCachedViewById(C2723R.C2726id.nav_drawer)).closeDrawer((int) GravityCompat.START);
                startActivity(new Intent(this, BDTMyAccountActivity.class));
                finish();
            } else if (i == 34) {
                setIntent(new Intent(this, AlertListNavDrawerActivity.class));
                startActivity(getIntent());
                finish();
            } else if (i == 37) {
                setIntent(new Intent(this, SettingsActivity.class));
                startActivity(getIntent());
                finish();
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
