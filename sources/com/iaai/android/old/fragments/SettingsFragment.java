package com.iaai.android.old.fragments;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.auctionMainPage.BDTAuctionMainListActivity;
import com.iaai.android.bdt.feature.landing.BDTLandingPageActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.old.activities.MainNavDrawerActivity;
import com.iaai.android.old.activities.NotificationPreferenceActivity;
import com.iaai.android.old.activities.TermsOfUseActivity;
import com.iaai.android.old.providers.IaaContent;
import com.iaai.android.old.utils.AppUtils;

public class SettingsFragment extends PreferenceFragment {
    private ContentResolver contentResolver;
    private String prefCategoryNameHiddenSettings;
    private String prefKeyChangeNotification;
    private String prefKeyLogout;
    private String prefKeyNotificationSound;
    private String prefKeyTermsOfUse;
    private String prefKeyTxtVersion;
    SessionManager sessionManager;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(C2723R.C2732xml.main_preferences);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
    }

    public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        this.prefCategoryNameHiddenSettings = getString(C2723R.string.pref_cat_hidden_settings);
        this.prefKeyLogout = getString(C2723R.string.pref_key_logout);
        this.prefKeyChangeNotification = getString(C2723R.string.pref_key_change_notification);
        this.prefKeyTxtVersion = getString(C2723R.string.pref_key_txt_version);
        this.prefKeyNotificationSound = getString(C2723R.string.pref_key_notification_ring_tone);
        this.prefKeyTermsOfUse = getString(C2723R.string.pref_key_terms_of_use);
        this.contentResolver = (ContentResolver) ((IaaiApplication) getActivity().getApplication()).getInjector().getInstance(ContentResolver.class);
        findPreference(this.prefKeyLogout).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                SettingsFragment.this.performLogout();
                return true;
            }
        });
        findPreference(this.prefKeyTermsOfUse).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                SettingsFragment.this.startActivity(new Intent(SettingsFragment.this.getActivity(), TermsOfUseActivity.class));
                return true;
            }
        });
        setDefaultRingToneIfEmpty();
        ((RingtonePreference) findPreference(this.prefKeyNotificationSound)).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            public boolean onPreferenceChange(Preference preference, Object obj) {
                SettingsFragment.this.refreshNotificationSoundSummary((String) obj);
                return true;
            }
        });
        findPreference(this.prefKeyChangeNotification).setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            public boolean onPreferenceClick(Preference preference) {
                SettingsFragment.this.getActivity().startActivity(new Intent(SettingsFragment.this.getActivity(), NotificationPreferenceActivity.class));
                return true;
            }
        });
        String packageName = getActivity().getPackageName();
        try {
            findPreference(this.prefKeyTxtVersion).setSummary(getActivity().getPackageManager().getPackageInfo(packageName, 0).versionName);
        } catch (PackageManager.NameNotFoundException e) {
            String message = e.getMessage();
            Log.d(message, "Unknown package name [%s]" + packageName);
        }
        refreshNotificationSoundSummary();
    }

    /* access modifiers changed from: package-private */
    public void refreshNotificationSoundSummary() {
        refreshNotificationSoundSummary((String) null);
    }

    /* access modifiers changed from: package-private */
    public void refreshNotificationSoundSummary(String str) {
        RingtonePreference ringtonePreference = (RingtonePreference) findPreference(this.prefKeyNotificationSound);
        String str2 = "";
        if (str == null) {
            str = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext()).getString(this.prefKeyNotificationSound, str2);
        }
        Log.d("prefNotificationSoundValue[%s]", str);
        Ringtone ringtone = RingtoneManager.getRingtone(getActivity(), Uri.parse(str));
        if (ringtone != null) {
            str2 = ringtone.getTitle(getActivity());
        }
        ringtonePreference.setSummary(getActivity().getString(C2723R.string.lbl_currently, new Object[]{str2}));
    }

    private void setDefaultRingToneIfEmpty() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getBaseContext());
        String string = defaultSharedPreferences.getString(this.prefKeyNotificationSound, "");
        Log.d("prefNotificationSoundValue[%s]", string);
        if (TextUtils.isEmpty(string)) {
            Uri defaultUri = RingtoneManager.getDefaultUri(2);
            SharedPreferences.Editor edit = defaultSharedPreferences.edit();
            edit.putString(this.prefKeyNotificationSound, defaultUri.toString());
            edit.commit();
        }
    }

    public void onResume() {
        super.onResume();
        refreshOnLoginStateChange();
    }

    /* access modifiers changed from: package-private */
    public void performLogout() {
        this.sessionManager.logout(getActivity());
        this.sessionManager.clearLoginResponseObject();
        refreshOnLoginStateChange();
        IaaiApplication.isMyAccountScreenShowing = false;
        AppUtils.resetNewCountPrefsOnLogout(getActivity());
        this.contentResolver.delete(IaaContent.Alert.CONTENT_URI, (String) null, (String[]) null);
        Toast.makeText(getActivity(), C2723R.string.msg_logout, 1).show();
        IaaiApplication.selected_navigation_drawer_optionid = C2723R.C2726id.drawer_menu_auction;
        if (getActivity() instanceof MainNavDrawerActivity) {
            ((MainNavDrawerActivity) getActivity()).mDrawerLayout.closeDrawer((int) GravityCompat.START);
        }
        if (IaaiApplication.is_new_landing) {
            startActivity(new Intent(getActivity(), BDTLandingPageActivity.class));
        } else {
            startActivity(new Intent(getActivity(), BDTAuctionMainListActivity.class));
        }
        getActivity().finish();
    }

    private void refreshOnLoginStateChange() {
        findPreference(this.prefKeyLogout).setEnabled(this.sessionManager.isLoggedIn());
    }
}
