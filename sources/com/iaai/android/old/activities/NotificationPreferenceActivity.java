package com.iaai.android.old.activities;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.view.View;
import android.widget.ImageButton;
import com.google.inject.Inject;
import com.iaai.android.C2723R;
import com.iaai.android.old.managers.AlertManager;
import com.iaai.android.old.managers.LoginStateChangeEventListener;
import com.iaai.android.old.managers.OnLoginStateChangeEvent;
import com.iaai.android.old.utils.constants.NotificationSettingKey;
import com.iaai.android.old.utils.constants.NotificationSettingType;
import java.lang.ref.WeakReference;
import roboguice.activity.RoboPreferenceActivity;
import roboguice.event.Observes;

public class NotificationPreferenceActivity extends RoboPreferenceActivity {
    @Inject
    private AlertManager alertManager;
    @Inject
    LoginStateChangeEventListener loginStateChaneEventListener;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(C2723R.C2732xml.notification_preferences);
        setContentView((int) C2723R.C2728layout.congfigure_alert_layout);
        overridePendingTransition(C2723R.anim.push_left_in, C2723R.anim.no_change);
        ((ImageButton) findViewById(C2723R.C2726id.back_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NotificationPreferenceActivity.this.finish();
                NotificationPreferenceActivity.this.overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
            }
        });
        for (NotificationSettingKey notificationSettingKey : NotificationSettingKey.values()) {
            ((CheckBoxPreference) findPreference(notificationSettingKey.getPreferenceKey(NotificationSettingType.ALERT))).setOnPreferenceChangeListener(new OnAlertPreferenceChangeListener(this, notificationSettingKey));
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.alertManager.postNotificationSettings();
    }

    private void handleLoginStateChange(@Observes OnLoginStateChangeEvent onLoginStateChangeEvent) {
        finish();
    }

    static class OnAlertPreferenceChangeListener implements Preference.OnPreferenceChangeListener {
        private final String childPrefKey;
        private final WeakReference<NotificationPreferenceActivity> contextRef;

        public OnAlertPreferenceChangeListener(NotificationPreferenceActivity notificationPreferenceActivity, NotificationSettingKey notificationSettingKey) {
            this.contextRef = new WeakReference<>(notificationPreferenceActivity);
            this.childPrefKey = notificationSettingKey.getPreferenceKey(NotificationSettingType.NOTIFICATION);
        }

        public boolean onPreferenceChange(Preference preference, Object obj) {
            NotificationPreferenceActivity notificationPreferenceActivity;
            if (((Boolean) obj).booleanValue() || (notificationPreferenceActivity = (NotificationPreferenceActivity) this.contextRef.get()) == null) {
                return true;
            }
            ((CheckBoxPreference) notificationPreferenceActivity.findPreference(this.childPrefKey)).setChecked(false);
            return true;
        }
    }
}
