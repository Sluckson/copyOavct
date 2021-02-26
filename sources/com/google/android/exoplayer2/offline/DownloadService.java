package com.google.android.exoplayer2.offline;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.google.android.exoplayer2.offline.DownloadManager;
import com.google.android.exoplayer2.offline.DownloadService;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.scheduler.Scheduler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.HashMap;
import java.util.List;

public abstract class DownloadService extends Service {
    public static final String ACTION_ADD_DOWNLOAD = "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD";
    public static final String ACTION_INIT = "com.google.android.exoplayer.downloadService.action.INIT";
    public static final String ACTION_PAUSE_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS";
    public static final String ACTION_REMOVE_ALL_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS";
    public static final String ACTION_REMOVE_DOWNLOAD = "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD";
    private static final String ACTION_RESTART = "com.google.android.exoplayer.downloadService.action.RESTART";
    public static final String ACTION_RESUME_DOWNLOADS = "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS";
    public static final String ACTION_SET_REQUIREMENTS = "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS";
    public static final String ACTION_SET_STOP_REASON = "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON";
    public static final long DEFAULT_FOREGROUND_NOTIFICATION_UPDATE_INTERVAL = 1000;
    public static final int FOREGROUND_NOTIFICATION_ID_NONE = 0;
    public static final String KEY_CONTENT_ID = "content_id";
    public static final String KEY_DOWNLOAD_REQUEST = "download_request";
    public static final String KEY_FOREGROUND = "foreground";
    public static final String KEY_REQUIREMENTS = "requirements";
    public static final String KEY_STOP_REASON = "stop_reason";
    private static final String TAG = "DownloadService";
    private static final HashMap<Class<? extends DownloadService>, DownloadManagerHelper> downloadManagerListeners = new HashMap<>();
    @StringRes
    private final int channelDescriptionResourceId;
    @Nullable
    private final String channelId;
    @StringRes
    private final int channelNameResourceId;
    /* access modifiers changed from: private */
    public DownloadManager downloadManager;
    @Nullable
    private final ForegroundNotificationUpdater foregroundNotificationUpdater;
    private boolean isDestroyed;
    private int lastStartId;
    private boolean startedInForeground;
    private boolean taskRemoved;

    /* access modifiers changed from: protected */
    public abstract DownloadManager getDownloadManager();

    /* access modifiers changed from: protected */
    public abstract Notification getForegroundNotification(List<Download> list);

    /* access modifiers changed from: protected */
    @Nullable
    public abstract Scheduler getScheduler();

    /* access modifiers changed from: protected */
    public void onDownloadChanged(Download download) {
    }

    /* access modifiers changed from: protected */
    public void onDownloadRemoved(Download download) {
    }

    protected DownloadService(int i) {
        this(i, 1000);
    }

    protected DownloadService(int i, long j) {
        this(i, j, (String) null, 0, 0);
    }

    @Deprecated
    protected DownloadService(int i, long j, @Nullable String str, @StringRes int i2) {
        this(i, j, str, i2, 0);
    }

    protected DownloadService(int i, long j, @Nullable String str, @StringRes int i2, @StringRes int i3) {
        if (i == 0) {
            this.foregroundNotificationUpdater = null;
            this.channelId = null;
            this.channelNameResourceId = 0;
            this.channelDescriptionResourceId = 0;
            return;
        }
        this.foregroundNotificationUpdater = new ForegroundNotificationUpdater(i, j);
        this.channelId = str;
        this.channelNameResourceId = i2;
        this.channelDescriptionResourceId = i3;
    }

    public static Intent buildAddDownloadIntent(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z) {
        return buildAddDownloadIntent(context, cls, downloadRequest, 0, z);
    }

    public static Intent buildAddDownloadIntent(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i, boolean z) {
        return getIntent(context, cls, ACTION_ADD_DOWNLOAD, z).putExtra(KEY_DOWNLOAD_REQUEST, downloadRequest).putExtra(KEY_STOP_REASON, i);
    }

    public static Intent buildRemoveDownloadIntent(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        return getIntent(context, cls, ACTION_REMOVE_DOWNLOAD, z).putExtra(KEY_CONTENT_ID, str);
    }

    public static Intent buildRemoveAllDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return getIntent(context, cls, ACTION_REMOVE_ALL_DOWNLOADS, z);
    }

    public static Intent buildResumeDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return getIntent(context, cls, ACTION_RESUME_DOWNLOADS, z);
    }

    public static Intent buildPauseDownloadsIntent(Context context, Class<? extends DownloadService> cls, boolean z) {
        return getIntent(context, cls, ACTION_PAUSE_DOWNLOADS, z);
    }

    public static Intent buildSetStopReasonIntent(Context context, Class<? extends DownloadService> cls, @Nullable String str, int i, boolean z) {
        return getIntent(context, cls, ACTION_SET_STOP_REASON, z).putExtra(KEY_CONTENT_ID, str).putExtra(KEY_STOP_REASON, i);
    }

    public static Intent buildSetRequirementsIntent(Context context, Class<? extends DownloadService> cls, Requirements requirements, boolean z) {
        return getIntent(context, cls, ACTION_SET_REQUIREMENTS, z).putExtra(KEY_REQUIREMENTS, requirements);
    }

    public static void sendAddDownload(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z) {
        startService(context, buildAddDownloadIntent(context, cls, downloadRequest, z), z);
    }

    public static void sendAddDownload(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i, boolean z) {
        startService(context, buildAddDownloadIntent(context, cls, downloadRequest, i, z), z);
    }

    public static void sendRemoveDownload(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        startService(context, buildRemoveDownloadIntent(context, cls, str, z), z);
    }

    public static void sendRemoveAllDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        startService(context, buildRemoveAllDownloadsIntent(context, cls, z), z);
    }

    public static void sendResumeDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        startService(context, buildResumeDownloadsIntent(context, cls, z), z);
    }

    public static void sendPauseDownloads(Context context, Class<? extends DownloadService> cls, boolean z) {
        startService(context, buildPauseDownloadsIntent(context, cls, z), z);
    }

    public static void sendSetStopReason(Context context, Class<? extends DownloadService> cls, @Nullable String str, int i, boolean z) {
        startService(context, buildSetStopReasonIntent(context, cls, str, i, z), z);
    }

    public static void sendSetRequirements(Context context, Class<? extends DownloadService> cls, Requirements requirements, boolean z) {
        startService(context, buildSetRequirementsIntent(context, cls, requirements, z), z);
    }

    public static void start(Context context, Class<? extends DownloadService> cls) {
        context.startService(getIntent(context, cls, ACTION_INIT));
    }

    public static void startForeground(Context context, Class<? extends DownloadService> cls) {
        Util.startForegroundService(context, getIntent(context, cls, ACTION_INIT, true));
    }

    public void onCreate() {
        String str = this.channelId;
        if (str != null) {
            NotificationUtil.createNotificationChannel(this, str, this.channelNameResourceId, this.channelDescriptionResourceId, 2);
        }
        Class<?> cls = getClass();
        DownloadManagerHelper downloadManagerHelper = downloadManagerListeners.get(cls);
        if (downloadManagerHelper == null) {
            DownloadManager downloadManager2 = getDownloadManager();
            downloadManager2.resumeDownloads();
            downloadManagerHelper = new DownloadManagerHelper(getApplicationContext(), downloadManager2, getScheduler(), cls);
            downloadManagerListeners.put(cls, downloadManagerHelper);
        }
        this.downloadManager = downloadManagerHelper.downloadManager;
        downloadManagerHelper.attachService(this);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int onStartCommand(android.content.Intent r7, int r8, int r9) {
        /*
            r6 = this;
            r6.lastStartId = r9
            r8 = 0
            r6.taskRemoved = r8
            java.lang.String r9 = "com.google.android.exoplayer.downloadService.action.RESTART"
            r0 = 0
            r1 = 1
            if (r7 == 0) goto L_0x002d
            java.lang.String r0 = r7.getAction()
            boolean r2 = r6.startedInForeground
            java.lang.String r3 = "foreground"
            boolean r3 = r7.getBooleanExtra(r3, r8)
            if (r3 != 0) goto L_0x0022
            boolean r3 = r9.equals(r0)
            if (r3 == 0) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r3 = 0
            goto L_0x0023
        L_0x0022:
            r3 = 1
        L_0x0023:
            r2 = r2 | r3
            r6.startedInForeground = r2
            java.lang.String r2 = "content_id"
            java.lang.String r2 = r7.getStringExtra(r2)
            goto L_0x002e
        L_0x002d:
            r2 = r0
        L_0x002e:
            java.lang.String r3 = "com.google.android.exoplayer.downloadService.action.INIT"
            if (r0 != 0) goto L_0x0033
            r0 = r3
        L_0x0033:
            r4 = -1
            int r5 = r0.hashCode()
            switch(r5) {
                case -1931239035: goto L_0x0089;
                case -932047176: goto L_0x007f;
                case -871181424: goto L_0x0077;
                case -650547439: goto L_0x006d;
                case -119057172: goto L_0x0062;
                case 191112771: goto L_0x0058;
                case 671523141: goto L_0x004e;
                case 1015676687: goto L_0x0046;
                case 1547520644: goto L_0x003c;
                default: goto L_0x003b;
            }
        L_0x003b:
            goto L_0x0093
        L_0x003c:
            java.lang.String r9 = "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD"
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L_0x0093
            r9 = 3
            goto L_0x0094
        L_0x0046:
            boolean r9 = r0.equals(r3)
            if (r9 == 0) goto L_0x0093
            r9 = 0
            goto L_0x0094
        L_0x004e:
            java.lang.String r9 = "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON"
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L_0x0093
            r9 = 7
            goto L_0x0094
        L_0x0058:
            java.lang.String r9 = "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS"
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L_0x0093
            r9 = 6
            goto L_0x0094
        L_0x0062:
            java.lang.String r9 = "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS"
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L_0x0093
            r9 = 8
            goto L_0x0094
        L_0x006d:
            java.lang.String r9 = "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS"
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L_0x0093
            r9 = 4
            goto L_0x0094
        L_0x0077:
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L_0x0093
            r9 = 1
            goto L_0x0094
        L_0x007f:
            java.lang.String r9 = "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS"
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L_0x0093
            r9 = 5
            goto L_0x0094
        L_0x0089:
            java.lang.String r9 = "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD"
            boolean r9 = r0.equals(r9)
            if (r9 == 0) goto L_0x0093
            r9 = 2
            goto L_0x0094
        L_0x0093:
            r9 = -1
        L_0x0094:
            java.lang.String r3 = "stop_reason"
            java.lang.String r4 = "DownloadService"
            switch(r9) {
                case 0: goto L_0x0116;
                case 1: goto L_0x0116;
                case 2: goto L_0x00fd;
                case 3: goto L_0x00ef;
                case 4: goto L_0x00e9;
                case 5: goto L_0x00e3;
                case 6: goto L_0x00dd;
                case 7: goto L_0x00c7;
                case 8: goto L_0x00b1;
                default: goto L_0x009b;
            }
        L_0x009b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Ignored unrecognized action: "
            r7.append(r8)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            com.google.android.exoplayer2.util.Log.m50e(r4, r7)
            goto L_0x0116
        L_0x00b1:
            java.lang.String r8 = "requirements"
            android.os.Parcelable r7 = r7.getParcelableExtra(r8)
            com.google.android.exoplayer2.scheduler.Requirements r7 = (com.google.android.exoplayer2.scheduler.Requirements) r7
            if (r7 != 0) goto L_0x00c1
            java.lang.String r7 = "Ignored SET_REQUIREMENTS: Missing requirements extra"
            com.google.android.exoplayer2.util.Log.m50e(r4, r7)
            goto L_0x0116
        L_0x00c1:
            com.google.android.exoplayer2.offline.DownloadManager r8 = r6.downloadManager
            r8.setRequirements(r7)
            goto L_0x0116
        L_0x00c7:
            boolean r9 = r7.hasExtra(r3)
            if (r9 != 0) goto L_0x00d3
            java.lang.String r7 = "Ignored SET_STOP_REASON: Missing stop_reason extra"
            com.google.android.exoplayer2.util.Log.m50e(r4, r7)
            goto L_0x0116
        L_0x00d3:
            int r7 = r7.getIntExtra(r3, r8)
            com.google.android.exoplayer2.offline.DownloadManager r8 = r6.downloadManager
            r8.setStopReason(r2, r7)
            goto L_0x0116
        L_0x00dd:
            com.google.android.exoplayer2.offline.DownloadManager r7 = r6.downloadManager
            r7.pauseDownloads()
            goto L_0x0116
        L_0x00e3:
            com.google.android.exoplayer2.offline.DownloadManager r7 = r6.downloadManager
            r7.resumeDownloads()
            goto L_0x0116
        L_0x00e9:
            com.google.android.exoplayer2.offline.DownloadManager r7 = r6.downloadManager
            r7.removeAllDownloads()
            goto L_0x0116
        L_0x00ef:
            if (r2 != 0) goto L_0x00f7
            java.lang.String r7 = "Ignored REMOVE_DOWNLOAD: Missing content_id extra"
            com.google.android.exoplayer2.util.Log.m50e(r4, r7)
            goto L_0x0116
        L_0x00f7:
            com.google.android.exoplayer2.offline.DownloadManager r7 = r6.downloadManager
            r7.removeDownload(r2)
            goto L_0x0116
        L_0x00fd:
            java.lang.String r9 = "download_request"
            android.os.Parcelable r9 = r7.getParcelableExtra(r9)
            com.google.android.exoplayer2.offline.DownloadRequest r9 = (com.google.android.exoplayer2.offline.DownloadRequest) r9
            if (r9 != 0) goto L_0x010d
            java.lang.String r7 = "Ignored ADD_DOWNLOAD: Missing download_request extra"
            com.google.android.exoplayer2.util.Log.m50e(r4, r7)
            goto L_0x0116
        L_0x010d:
            int r7 = r7.getIntExtra(r3, r8)
            com.google.android.exoplayer2.offline.DownloadManager r8 = r6.downloadManager
            r8.addDownload(r9, r7)
        L_0x0116:
            com.google.android.exoplayer2.offline.DownloadManager r7 = r6.downloadManager
            boolean r7 = r7.isIdle()
            if (r7 == 0) goto L_0x0121
            r6.stop()
        L_0x0121:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.offline.DownloadService.onStartCommand(android.content.Intent, int, int):int");
    }

    public void onTaskRemoved(Intent intent) {
        this.taskRemoved = true;
    }

    public void onDestroy() {
        this.isDestroyed = true;
        downloadManagerListeners.get(getClass()).detachService(this, true ^ this.downloadManager.isWaitingForRequirements());
        ForegroundNotificationUpdater foregroundNotificationUpdater2 = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater2 != null) {
            foregroundNotificationUpdater2.stopPeriodicUpdates();
        }
    }

    @Nullable
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: protected */
    public final void invalidateForegroundNotification() {
        ForegroundNotificationUpdater foregroundNotificationUpdater2 = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater2 != null && !this.isDestroyed) {
            foregroundNotificationUpdater2.invalidate();
        }
    }

    /* access modifiers changed from: private */
    public void notifyDownloadChanged(Download download) {
        onDownloadChanged(download);
        if (this.foregroundNotificationUpdater == null) {
            return;
        }
        if (download.state == 2 || download.state == 5 || download.state == 7) {
            this.foregroundNotificationUpdater.startPeriodicUpdates();
        } else {
            this.foregroundNotificationUpdater.invalidate();
        }
    }

    /* access modifiers changed from: private */
    public void notifyDownloadRemoved(Download download) {
        onDownloadRemoved(download);
        ForegroundNotificationUpdater foregroundNotificationUpdater2 = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater2 != null) {
            foregroundNotificationUpdater2.invalidate();
        }
    }

    /* access modifiers changed from: private */
    public void stop() {
        ForegroundNotificationUpdater foregroundNotificationUpdater2 = this.foregroundNotificationUpdater;
        if (foregroundNotificationUpdater2 != null) {
            foregroundNotificationUpdater2.stopPeriodicUpdates();
            if (this.startedInForeground && Util.SDK_INT >= 26) {
                this.foregroundNotificationUpdater.showNotificationIfNotAlready();
            }
        }
        if (Util.SDK_INT >= 28 || !this.taskRemoved) {
            stopSelfResult(this.lastStartId);
        } else {
            stopSelf();
        }
    }

    private static Intent getIntent(Context context, Class<? extends DownloadService> cls, String str, boolean z) {
        return getIntent(context, cls, str).putExtra(KEY_FOREGROUND, z);
    }

    /* access modifiers changed from: private */
    public static Intent getIntent(Context context, Class<? extends DownloadService> cls, String str) {
        return new Intent(context, cls).setAction(str);
    }

    private static void startService(Context context, Intent intent, boolean z) {
        if (z) {
            Util.startForegroundService(context, intent);
        } else {
            context.startService(intent);
        }
    }

    private final class ForegroundNotificationUpdater {
        private final Handler handler = new Handler(Looper.getMainLooper());
        private boolean notificationDisplayed;
        private final int notificationId;
        private boolean periodicUpdatesStarted;
        private final long updateInterval;
        private final Runnable updateRunnable = new Runnable() {
            public final void run() {
                DownloadService.ForegroundNotificationUpdater.this.update();
            }
        };

        public ForegroundNotificationUpdater(int i, long j) {
            this.notificationId = i;
            this.updateInterval = j;
        }

        public void startPeriodicUpdates() {
            this.periodicUpdatesStarted = true;
            update();
        }

        public void stopPeriodicUpdates() {
            this.periodicUpdatesStarted = false;
            this.handler.removeCallbacks(this.updateRunnable);
        }

        public void showNotificationIfNotAlready() {
            if (!this.notificationDisplayed) {
                update();
            }
        }

        public void invalidate() {
            if (this.notificationDisplayed) {
                update();
            }
        }

        /* access modifiers changed from: private */
        public void update() {
            List<Download> currentDownloads = DownloadService.this.downloadManager.getCurrentDownloads();
            DownloadService downloadService = DownloadService.this;
            downloadService.startForeground(this.notificationId, downloadService.getForegroundNotification(currentDownloads));
            this.notificationDisplayed = true;
            if (this.periodicUpdatesStarted) {
                this.handler.removeCallbacks(this.updateRunnable);
                this.handler.postDelayed(this.updateRunnable, this.updateInterval);
            }
        }
    }

    private static final class DownloadManagerHelper implements DownloadManager.Listener {
        private final Context context;
        /* access modifiers changed from: private */
        public final DownloadManager downloadManager;
        @Nullable
        private DownloadService downloadService;
        @Nullable
        private final Scheduler scheduler;
        private final Class<? extends DownloadService> serviceClass;

        public /* synthetic */ void onInitialized(DownloadManager downloadManager2) {
            DownloadManager.Listener.CC.$default$onInitialized(this, downloadManager2);
        }

        private DownloadManagerHelper(Context context2, DownloadManager downloadManager2, @Nullable Scheduler scheduler2, Class<? extends DownloadService> cls) {
            this.context = context2;
            this.downloadManager = downloadManager2;
            this.scheduler = scheduler2;
            this.serviceClass = cls;
            downloadManager2.addListener(this);
            if (scheduler2 != null) {
                Requirements requirements = downloadManager2.getRequirements();
                setSchedulerEnabled(!requirements.checkRequirements(context2), requirements);
            }
        }

        public void attachService(DownloadService downloadService2) {
            Assertions.checkState(this.downloadService == null);
            this.downloadService = downloadService2;
        }

        public void detachService(DownloadService downloadService2, boolean z) {
            Assertions.checkState(this.downloadService == downloadService2);
            this.downloadService = null;
            Scheduler scheduler2 = this.scheduler;
            if (scheduler2 != null && z) {
                scheduler2.cancel();
            }
        }

        public void onDownloadChanged(DownloadManager downloadManager2, Download download) {
            DownloadService downloadService2 = this.downloadService;
            if (downloadService2 != null) {
                downloadService2.notifyDownloadChanged(download);
            }
        }

        public void onDownloadRemoved(DownloadManager downloadManager2, Download download) {
            DownloadService downloadService2 = this.downloadService;
            if (downloadService2 != null) {
                downloadService2.notifyDownloadRemoved(download);
            }
        }

        public final void onIdle(DownloadManager downloadManager2) {
            DownloadService downloadService2 = this.downloadService;
            if (downloadService2 != null) {
                downloadService2.stop();
            }
        }

        public void onRequirementsStateChanged(DownloadManager downloadManager2, Requirements requirements, int i) {
            boolean z = i == 0;
            if (this.downloadService == null && z) {
                try {
                    this.context.startService(DownloadService.getIntent(this.context, this.serviceClass, DownloadService.ACTION_INIT));
                } catch (IllegalStateException unused) {
                    return;
                }
            }
            if (this.scheduler != null) {
                setSchedulerEnabled(true ^ z, requirements);
            }
        }

        private void setSchedulerEnabled(boolean z, Requirements requirements) {
            if (!z) {
                this.scheduler.cancel();
                return;
            }
            if (!this.scheduler.schedule(requirements, this.context.getPackageName(), DownloadService.ACTION_RESTART)) {
                Log.m50e(DownloadService.TAG, "Scheduling downloads failed.");
            }
        }
    }
}
