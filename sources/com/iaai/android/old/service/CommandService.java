package com.iaai.android.old.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import androidx.core.app.NotificationCompat;
import com.google.inject.Inject;
import com.iaai.android.old.utils.IAAException;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.http.RestClient;
import roboguice.service.RoboIntentService;
import roboguice.util.C5058Ln;

public class CommandService extends RoboIntentService {
    @Inject
    private RestClient client;

    public CommandService() {
        super("CommandService");
    }

    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("iaa_channel_02", "Channel human readable title", 3));
            startForeground(2, new NotificationCompat.Builder(this, "iaa_channel_02").setContentTitle("").setContentText("").build());
        }
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (C5058Ln.isDebugEnabled()) {
            C5058Ln.m4829d("onHandleIntent intent[%s]", intent);
        }
        Bundle extras = intent.getExtras();
        ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra(Constants.EXTRA_RECEIVER);
        String stringExtra = intent.getStringExtra(Constants.EXTRA_COMMAND);
        resultReceiver.send(0, Bundle.EMPTY);
        try {
            boolean booleanExtra = intent.getBooleanExtra(Constants.EXTRA_IS_LOGIN_REQUIRED, false);
            Parcelable parcelableExtra = intent.getParcelableExtra(Constants.EXTRA_POST_DATA);
            C5058Ln.m4829d("executing command[%s]", stringExtra);
            resultReceiver.send(1, execute(stringExtra, parcelableExtra, (Class) intent.getSerializableExtra(Constants.EXTRA_RESULT_TYPE), booleanExtra, extras));
        } catch (Exception e) {
            extras.putString("android.intent.extra.TEXT", e.toString());
            if (e instanceof IAAException) {
                extras.putSerializable("errorType", ((IAAException) e).errorType);
            }
            resultReceiver.send(2, extras);
        } catch (Throwable th) {
            stopSelf();
            throw th;
        }
        stopSelf();
    }

    private <T> Bundle execute(String str, Parcelable parcelable, Class<? extends T> cls, boolean z, Bundle bundle) throws Exception {
        Object execute = this.client.execute(str, parcelable, cls, z);
        if (Parcelable.class.isAssignableFrom(cls)) {
            bundle.putParcelable(Constants.EXTRA_RESULT, (Parcelable) execute);
        } else if (Parcelable[].class.isAssignableFrom(cls)) {
            bundle.putParcelableArray(Constants.EXTRA_RESULT, (Parcelable[]) execute);
        } else if (String.class.isAssignableFrom(cls)) {
            bundle.putString(Constants.EXTRA_RESULT, (String) execute);
        } else {
            throw new RuntimeException("Result type must be parcelable");
        }
        return bundle;
    }

    public static void start(String str, ActivityBaseResultReceiver activityBaseResultReceiver, Class<?> cls, boolean z) {
        start(activityBaseResultReceiver.getContext(), str, (Parcelable) null, activityBaseResultReceiver, cls, z);
    }

    public static void start(Context context, String str, ResultReceiver resultReceiver, Class<?> cls, boolean z) {
        start(context, str, (Parcelable) null, resultReceiver, cls, z);
    }

    public static void start(String str, Parcelable parcelable, ActivityBaseResultReceiver activityBaseResultReceiver, Class<?> cls, boolean z) {
        start(activityBaseResultReceiver.getContext(), str, parcelable, activityBaseResultReceiver, cls, z);
    }

    public static void start(Context context, String str, Parcelable parcelable, ResultReceiver resultReceiver, Class<?> cls, boolean z) {
        if (context != null) {
            if (str.contains(Constants.VISITOR_TRUE)) {
                z = false;
            }
            Intent intent = new Intent("android.intent.action.SYNC", (Uri) null, context, CommandService.class);
            intent.putExtra(Constants.EXTRA_RECEIVER, resultReceiver);
            intent.putExtra(Constants.EXTRA_COMMAND, str);
            intent.putExtra(Constants.EXTRA_RESULT_TYPE, cls);
            if (parcelable != null) {
                intent.putExtra(Constants.EXTRA_POST_DATA, parcelable);
            }
            if (z) {
                intent.putExtra(Constants.EXTRA_IS_LOGIN_REQUIRED, z);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                context.startForegroundService(intent);
            } else {
                context.startService(intent);
            }
        }
    }
}
