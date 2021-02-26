package com.iaai.android.old.managers;

import android.app.Application;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Handler;
import android.os.ResultReceiver;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.models.LoadAlertsResult;
import com.iaai.android.old.models.PostSettingsRequest;
import com.iaai.android.old.models.PrefSetting;
import com.iaai.android.old.models.SimpleResponse;
import com.iaai.android.old.providers.IaaContent;
import com.iaai.android.old.service.CommandService;
import com.iaai.android.old.service.ContextBaseResultReceiver;
import com.iaai.android.old.utils.constants.NotificationSettingKey;
import com.iaai.android.old.utils.constants.NotificationSettingType;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.entity.ByteArrayEntity;
import roboguice.inject.InjectResource;
import roboguice.util.C5058Ln;

@Singleton
public class AlertManager {
    public static final String KEY_COUNT = "count";
    public static final String KEY_HEADER = "header";
    public static final String KEY_MESSAGE = "message";
    public static final String SENDER_ID = "sendId";
    private static AsyncHttpClient client = new AsyncHttpClient();
    String SENDER_ID_GCM = "483894526844";
    String TAG = "ALERT MANAGER";
    final Application app;
    final ContentResolver contentResolver;
    Context gcmContext;
    @Inject
    NotificationManager notificationManager;
    @InjectResource(2131822066)
    private String prefKeyNotificationSound;
    @InjectResource(2131822067)
    private String prefKeyNotificationVibrate;
    String regid;
    @InjectResource(2131822163)
    private String servicePathLoadSenderId;
    @InjectResource(2131822174)
    private String servicePathPostToken;
    @InjectResource(2131822175)
    private String servicePathPostUserPreferences;
    SessionManager sessionManager;
    @Inject
    SimpleRepository simpleRepository;

    @Inject
    private AlertManager(ContentResolver contentResolver2, Provider<Application> provider) {
        this.contentResolver = contentResolver2;
        this.app = provider.get();
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
    }

    public void loadAlerts(int i, ResultReceiver resultReceiver) {
        String string = this.app.getResources().getString(C2723R.string.service_path_load_alerts, new Object[]{this.sessionManager.getCurrentSessionUserId()});
        if (i > 0) {
            string = string + String.format("&alertid=%d", new Object[]{Integer.valueOf(i)});
        }
        CommandService.start((Context) this.app, string, resultReceiver, (Class<?>) LoadAlertsResult.class, true);
    }

    public void clearAllAlerts() {
        this.contentResolver.delete(IaaContent.Alert.CONTENT_URI, (String) null, (String[]) null);
    }

    public void persistFCMRegistrationId(String str) {
        Cursor cursor = null;
        try {
            boolean z = true;
            cursor = this.contentResolver.query(IaaContent.C2dmRegistration.CONTENT_URI, (String[]) null, "registrationId = ?", new String[]{str}, (String) null);
            if (cursor.getCount() <= 0) {
                z = false;
            }
            if (!z) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(IaaContent.C2dmRegistration.REGISTRATION_ID, str);
                contentValues.put(IaaContent.C2dmRegistration.SENDER_ID, this.SENDER_ID_GCM);
                contentValues.put(IaaContent.C2dmRegistration.IS_SYNC, 0);
                this.contentResolver.insert(IaaContent.C2dmRegistration.CONTENT_URI, contentValues);
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public String getFCMRegistrationId() {
        return getFCMRegistrationId(-1);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String getFCMRegistrationId(int r9) {
        /*
            r8 = this;
            r0 = -1
            r1 = 0
            if (r9 != r0) goto L_0x0006
            r5 = r1
            goto L_0x0018
        L_0x0006:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0042 }
            r0.<init>()     // Catch:{ all -> 0x0042 }
            java.lang.String r2 = "isSync = "
            r0.append(r2)     // Catch:{ all -> 0x0042 }
            r0.append(r9)     // Catch:{ all -> 0x0042 }
            java.lang.String r9 = r0.toString()     // Catch:{ all -> 0x0042 }
            r5 = r9
        L_0x0018:
            android.content.ContentResolver r2 = r8.contentResolver     // Catch:{ all -> 0x0042 }
            android.net.Uri r3 = com.iaai.android.old.providers.IaaContent.C2dmRegistration.CONTENT_URI     // Catch:{ all -> 0x0042 }
            r4 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0042 }
            boolean r0 = r9.moveToFirst()     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x0039
            java.lang.String r0 = "registrationId"
            int r0 = r9.getColumnIndex(r0)     // Catch:{ all -> 0x003f }
            java.lang.String r0 = r9.getString(r0)     // Catch:{ all -> 0x003f }
            if (r9 == 0) goto L_0x0038
            r9.close()
        L_0x0038:
            return r0
        L_0x0039:
            if (r9 == 0) goto L_0x003e
            r9.close()
        L_0x003e:
            return r1
        L_0x003f:
            r0 = move-exception
            r1 = r9
            goto L_0x0043
        L_0x0042:
            r0 = move-exception
        L_0x0043:
            if (r1 == 0) goto L_0x0048
            r1.close()
        L_0x0048:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.old.managers.AlertManager.getFCMRegistrationId(int):java.lang.String");
    }

    public void postNotificationSettings() {
        if (this.sessionManager.isLoggedIn()) {
            String currentSessionUserId = this.sessionManager.getCurrentSessionUserId();
            String fCMRegistrationId = getFCMRegistrationId();
            if (!TextUtils.isEmpty(fCMRegistrationId)) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.getBaseContext());
                ArrayList arrayList = new ArrayList();
                NotificationSettingKey[] values = NotificationSettingKey.values();
                int length = values.length;
                boolean z = false;
                int i = 0;
                while (i < length) {
                    NotificationSettingKey notificationSettingKey = values[i];
                    NotificationSettingType[] values2 = NotificationSettingType.values();
                    int length2 = values2.length;
                    int i2 = 0;
                    while (i2 < length2) {
                        NotificationSettingType notificationSettingType = values2[i2];
                        arrayList.add(new PrefSetting(notificationSettingKey.toString(), notificationSettingType.toString(), defaultSharedPreferences.getBoolean(notificationSettingKey.getPreferenceKey(notificationSettingType), z)));
                        i2++;
                        z = false;
                    }
                    i++;
                    z = false;
                }
                if (!arrayList.isEmpty()) {
                    CommandService.start(this.app, this.servicePathPostUserPreferences, new PostSettingsRequest(currentSessionUserId, fCMRegistrationId, arrayList), new PostNotificationSettingsResultReceiver(this.app, new Handler()), SimpleResponse.class, true);
                }
            }
        }
    }

    class PostNotificationSettingsResultReceiver extends ContextBaseResultReceiver<Application, SimpleResponse> {
        PostNotificationSettingsResultReceiver(Application application, Handler handler) {
            super(application, handler);
        }

        /* access modifiers changed from: protected */
        public void onSuccess(Application application, SimpleResponse simpleResponse) {
            if (simpleResponse.isSuccessful) {
                C5058Ln.m4829d("Notification settings posted", new Object[0]);
            } else {
                C5058Ln.m4829d("Unable to post Notification settings", new Object[0]);
            }
        }
    }

    public void sendFCMRegistrationIdToBackend(Context context) {
        try {
            postTokendata(new JSONObject(createMethodParamsForFCM()).toString(), new AsyncHttpResponseHandler() {
                public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    Log.v("Params", "statusCode-" + i);
                }

                public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                    Log.v("Params", "onFailure statusCode-" + i);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void postTokendata(String str, AsyncHttpResponseHandler asyncHttpResponseHandler) throws UnsupportedEncodingException {
        client.addHeader("Authorization", this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword());
        client.addHeader("User-Agent", Utils.getUserAgent());
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(str.getBytes("UTF-8"));
        client.post(this.gcmContext, this.app.getResources().getString(C2723R.string.base_https_url) + this.servicePathPostToken, byteArrayEntity, "application/json", asyncHttpResponseHandler);
    }

    public String createMethodParamsForFCM() throws JSONException {
        String str = "{\"TokenID\": \"" + getFCMRegistrationId() + "\",\"DeviceType\": \"Android\" }";
        Log.v("Params", "" + str);
        return str;
    }
}
