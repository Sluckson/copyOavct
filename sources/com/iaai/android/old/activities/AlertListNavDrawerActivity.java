package com.iaai.android.old.activities;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.google.inject.Injector;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListActivity;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.old.managers.AlertManager;
import com.iaai.android.old.models.Alert;
import com.iaai.android.old.models.LoadAlertsResult;
import com.iaai.android.old.providers.IaaContent;
import com.iaai.android.old.service.ActivityBaseResultReceiver;
import com.iaai.android.old.utils.DateHelper;
import com.iaai.android.old.utils.constants.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import roboguice.util.C5058Ln;

public class AlertListNavDrawerActivity extends MainNavDrawerActivity {
    private AlertsAdapter adapter;
    private AlertManager alertManager;
    @BindView(2131296418)
    ListView alert_list;
    private ContentResolver contentResolver;
    private LoadAlertsResultReceiver loadAlertsResultReceiver;
    @BindView(2131296913)
    TextView textViewEmpty;

    interface OnNotificationClick {
        void onNotificationItemClick();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.activity_notification_nav_drawer_layout);
        super.onCreateDrawer(bundle);
        ButterKnife.bind((Activity) this);
        this.mNavigationView.getMenu().findItem(C2723R.C2726id.drawer_menu_notifications).setChecked(true);
        Injector injector = ((IaaiApplication) getApplication()).getInjector();
        this.alertManager = (AlertManager) injector.getInstance(AlertManager.class);
        this.contentResolver = (ContentResolver) injector.getInstance(ContentResolver.class);
        super.setUserNameAndBuyerID(this.sessionManager);
        this.textViewEmpty.setText(C2723R.string.no_notification_found);
        ListView listView = this.alert_list;
        this.adapter = new AlertsAdapter(this, new OnNotificationClick() {
            public void onNotificationItemClick() {
                SessionManager sessionManager = AlertListNavDrawerActivity.this.sessionManager;
                AlertListNavDrawerActivity alertListNavDrawerActivity = AlertListNavDrawerActivity.this;
                if (!sessionManager.promptForLoginIfNeedFromActivity(alertListNavDrawerActivity, alertListNavDrawerActivity, 35)) {
                    AlertListNavDrawerActivity alertListNavDrawerActivity2 = AlertListNavDrawerActivity.this;
                    alertListNavDrawerActivity2.startActivity(new Intent(alertListNavDrawerActivity2, ManageOfferListActivity.class));
                }
            }
        });
        listView.setAdapter(this.adapter);
        listView.setItemsCanFocus(false);
        listView.setChoiceMode(2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                C5058Ln.m4829d("On onItemClick position[%d] id[%d]", Integer.valueOf(i), Long.valueOf(j));
                ((AlertsAdapter) adapterView.getAdapter()).setCheckedItem(i);
            }
        });
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                C5058Ln.m4829d("On onItemSelected position[%d] id[%d]", Integer.valueOf(i), Long.valueOf(j));
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                C5058Ln.m4829d("On onNothingSelected", new Object[0]);
            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                return false;
            }
        });
        this.loadAlertsResultReceiver = new LoadAlertsResultReceiver(this, new Handler());
        applyIntentData(getIntent());
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, @Nullable Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 35) {
            startActivity(new Intent(this, ManageOfferListActivity.class));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C2723R.C2729menu.menu_alerts, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            overridePendingTransition(C2723R.anim.none, C2723R.anim.push_right_out);
        } else if (itemId == C2723R.C2726id.alert_delete) {
            deleteCheckedAlerts();
        } else if (itemId == C2723R.C2726id.alert_mark) {
            ListView listView = this.alert_list;
            Collection<String> values = this.adapter.getCheckedItems().values();
            checkAll(values == null || values.size() == 0);
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    /* access modifiers changed from: package-private */
    public void checkAll(boolean z) {
        ListView listView = this.alert_list;
        int count = listView.getCount();
        for (int i = 0; i < count; i++) {
            listView.setItemChecked(i, z);
            this.adapter.setCheckedItem(i, z);
        }
    }

    /* access modifiers changed from: package-private */
    public void deleteCheckedAlerts() {
        ListView listView = this.alert_list;
        listView.refreshDrawableState();
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.adapter.getCheckedItems().values().iterator();
        for (int i = 0; i < this.adapter.getCheckedItems().size(); i++) {
            arrayList.add(Integer.valueOf(((Alert) this.adapter.getItem(Integer.parseInt(it.next()))).f511pk));
        }
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder("_id");
            sb.append(" in (");
            Iterator it2 = arrayList.iterator();
            boolean z = true;
            while (it2.hasNext()) {
                long intValue = (long) ((Integer) it2.next()).intValue();
                if (z) {
                    z = false;
                } else {
                    sb.append(",");
                }
                sb.append(intValue);
            }
            sb.append(")");
            if (this.contentResolver.delete(IaaContent.Alert.CONTENT_URI, sb.toString(), (String[]) null) == listView.getAdapter().getCount()) {
                this.sharedPrefsHelper.put(this.sessionManager.getPREF_LAST_ALERT_ID(), 0);
            }
            this.adapter.refreshHashMap();
            refreshList();
        }
    }

    private void applyIntentData(Intent intent) {
        this.alertManager.loadAlerts(this.sharedPrefsHelper.get(this.sessionManager.getPREF_LAST_ALERT_ID(), 0).intValue(), this.loadAlertsResultReceiver);
    }

    /* access modifiers changed from: package-private */
    public void handleLoadAlertsResult(List<Alert> list) {
        int i = 0;
        for (Alert next : list) {
            i = Math.max(i, next.alertId);
            this.contentResolver.insert(IaaContent.Alert.CONTENT_URI, next.toContentValues());
        }
        refreshList();
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x007d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void refreshList() {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            android.content.ContentResolver r2 = r8.contentResolver     // Catch:{ all -> 0x0077 }
            android.net.Uri r3 = com.iaai.android.old.providers.IaaContent.Alert.CONTENT_URI     // Catch:{ all -> 0x0077 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0077 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0073 }
            r3.<init>()     // Catch:{ all -> 0x0073 }
            boolean r4 = r2.moveToFirst()     // Catch:{ all -> 0x0073 }
            if (r4 == 0) goto L_0x0031
            r4 = 0
        L_0x001a:
            com.iaai.android.old.models.Alert r5 = new com.iaai.android.old.models.Alert     // Catch:{ all -> 0x002f }
            r5.<init>((android.database.Cursor) r2)     // Catch:{ all -> 0x002f }
            int r6 = r5.alertId     // Catch:{ all -> 0x002f }
            int r4 = java.lang.Math.max(r4, r6)     // Catch:{ all -> 0x002f }
            r3.add(r5)     // Catch:{ all -> 0x002f }
            boolean r5 = r2.moveToNext()     // Catch:{ all -> 0x002f }
            if (r5 != 0) goto L_0x001a
            goto L_0x0032
        L_0x002f:
            r0 = move-exception
            goto L_0x007b
        L_0x0031:
            r4 = 0
        L_0x0032:
            int r5 = r2.getCount()     // Catch:{ all -> 0x002f }
            if (r5 != 0) goto L_0x0044
            android.widget.ListView r5 = r8.alert_list     // Catch:{ all -> 0x002f }
            r6 = 8
            r5.setVisibility(r6)     // Catch:{ all -> 0x002f }
            android.widget.TextView r5 = r8.textViewEmpty     // Catch:{ all -> 0x002f }
            r5.setVisibility(r0)     // Catch:{ all -> 0x002f }
        L_0x0044:
            com.iaai.android.old.activities.AlertListNavDrawerActivity$AlertsAdapter r5 = r8.adapter     // Catch:{ all -> 0x002f }
            r5.setData(r3)     // Catch:{ all -> 0x002f }
            if (r2 == 0) goto L_0x004e
            r2.close()
        L_0x004e:
            com.iaai.android.bdt.utils.SharedPrefsHelper r2 = r8.sharedPrefsHelper
            com.iaai.android.bdt.feature.login.SessionManager r3 = r8.sessionManager
            java.lang.String r3 = r3.getPREF_LAST_ALERT_ID()
            r2.put((java.lang.String) r3, (int) r4)
            r8.checkAll(r0)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            r2 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "isRead"
            r0.put(r3, r2)
            android.content.ContentResolver r2 = r8.contentResolver
            android.net.Uri r3 = com.iaai.android.old.providers.IaaContent.Alert.CONTENT_URI
            r2.update(r3, r0, r1, r1)
            return
        L_0x0073:
            r1 = move-exception
            r0 = r1
            r4 = 0
            goto L_0x007b
        L_0x0077:
            r2 = move-exception
            r0 = r2
            r4 = 0
            r2 = r1
        L_0x007b:
            if (r2 == 0) goto L_0x0080
            r2.close()
        L_0x0080:
            com.iaai.android.bdt.utils.SharedPrefsHelper r1 = r8.sharedPrefsHelper
            com.iaai.android.bdt.feature.login.SessionManager r2 = r8.sessionManager
            java.lang.String r2 = r2.getPREF_LAST_ALERT_ID()
            r1.put((java.lang.String) r2, (int) r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.activities.AlertListNavDrawerActivity.refreshList():void");
    }

    static class AlertsAdapter extends ArrayAdapter<Alert> {
        public HashMap<String, String> checked = new HashMap<>();
        private final int colorRead;
        private final int colorUnread;
        OnNotificationClick onNotificationClick;
        public List<Alert> p_alerts;

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public void navigationToMyAccountSection(int i) {
        }

        static class ViewHolder {
            public LinearLayout llInfoContainer;
            public TextView txtDate;
            public TextView txtDetail;
            public TextView txtTitle;

            public ViewHolder(View view) {
                this.txtTitle = (TextView) view.findViewById(C2723R.C2726id.txt_title);
                this.txtDetail = (TextView) view.findViewById(C2723R.C2726id.txt_detail);
                this.txtDate = (TextView) view.findViewById(C2723R.C2726id.txt_date);
                this.llInfoContainer = (LinearLayout) view.findViewById(C2723R.C2726id.contact_info_container);
            }
        }

        public AlertsAdapter(Context context, OnNotificationClick onNotificationClick2) {
            super(context, 0);
            this.onNotificationClick = onNotificationClick2;
            this.colorRead = context.getResources().getColor(C2723R.C2724color.iaa_black);
            this.colorUnread = context.getResources().getColor(C2723R.C2724color.iaa_red_dark);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            final Alert alert = (Alert) getItem(i);
            if (view == null || view.getTag() == null) {
                view = View.inflate(viewGroup.getContext(), C2723R.C2728layout.alert_list_item_checkable, (ViewGroup) null);
                viewHolder = new ViewHolder(view);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.txtTitle.setText(alert.title);
            viewHolder.txtDetail.setText(alert.detail);
            viewHolder.llInfoContainer.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (alert.eventID == 20) {
                        AlertsAdapter.this.onNotificationClick.onNotificationItemClick();
                    }
                }
            });
            viewHolder.txtDate.setText(DateHelper.format(alert.datetime, Constants.DATE_PATTERN_ALERT_DATETIME));
            if (alert.isRead) {
                viewHolder.txtTitle.setTextColor(this.colorRead);
                viewHolder.txtDetail.setTextColor(this.colorRead);
                viewHolder.txtDate.setTextColor(this.colorRead);
            } else {
                viewHolder.txtTitle.setTextColor(this.colorUnread);
                viewHolder.txtDetail.setTextColor(this.colorUnread);
                viewHolder.txtDate.setTextColor(this.colorUnread);
            }
            return view;
        }

        public void setData(List<Alert> list) {
            setNotifyOnChange(false);
            clear();
            this.p_alerts = list;
            for (Alert add : list) {
                add(add);
            }
            notifyDataSetChanged();
        }

        public void refreshHashMap() {
            this.checked.clear();
        }

        public void setCheckedItem(int i) {
            if (this.checked.containsKey(String.valueOf(i))) {
                this.checked.remove(String.valueOf(i));
            } else {
                this.checked.put(String.valueOf(i), String.valueOf(i));
            }
        }

        public void setCheckedItem(int i, boolean z) {
            if (z) {
                this.checked.put(String.valueOf(i), String.valueOf(i));
            } else {
                this.checked.remove(String.valueOf(i));
            }
        }

        public HashMap<String, String> getCheckedItems() {
            return this.checked;
        }
    }

    static class LoadAlertsResultReceiver extends ActivityBaseResultReceiver<AlertListNavDrawerActivity, LoadAlertsResult> {
        LoadAlertsResultReceiver(AlertListNavDrawerActivity alertListNavDrawerActivity, Handler handler) {
            super(alertListNavDrawerActivity, handler);
        }

        /* access modifiers changed from: protected */
        public void onSuccess(AlertListNavDrawerActivity alertListNavDrawerActivity, LoadAlertsResult loadAlertsResult) {
            if (loadAlertsResult.isSuccessful) {
                alertListNavDrawerActivity.handleLoadAlertsResult(loadAlertsResult.alerts);
            } else {
                Toast.makeText(alertListNavDrawerActivity, loadAlertsResult.message, 0).show();
            }
        }
    }
}
