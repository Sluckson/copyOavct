package com.google.android.exoplayer2.p009ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.support.p000v4.media.session.MediaSessionCompat;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media.app.NotificationCompat;
import com.google.android.exoplayer2.C1119C;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.p009ui.PlayerNotificationManager;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.NotificationUtil;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* renamed from: com.google.android.exoplayer2.ui.PlayerNotificationManager */
public class PlayerNotificationManager {
    private static final String ACTION_DISMISS = "com.google.android.exoplayer.dismiss";
    public static final String ACTION_FAST_FORWARD = "com.google.android.exoplayer.ffwd";
    public static final String ACTION_NEXT = "com.google.android.exoplayer.next";
    public static final String ACTION_PAUSE = "com.google.android.exoplayer.pause";
    public static final String ACTION_PLAY = "com.google.android.exoplayer.play";
    public static final String ACTION_PREVIOUS = "com.google.android.exoplayer.prev";
    public static final String ACTION_REWIND = "com.google.android.exoplayer.rewind";
    public static final String ACTION_STOP = "com.google.android.exoplayer.stop";
    public static final int DEFAULT_FAST_FORWARD_MS = 15000;
    public static final int DEFAULT_REWIND_MS = 5000;
    public static final String EXTRA_INSTANCE_ID = "INSTANCE_ID";
    private static final long MAX_POSITION_FOR_SEEK_TO_PREVIOUS = 3000;
    private static int instanceIdCounter;
    private int badgeIconType;
    @Nullable
    private NotificationCompat.Builder builder;
    @Nullable
    private ArrayList<NotificationCompat.Action> builderActions;
    private final String channelId;
    private int color;
    private boolean colorized;
    private final Context context;
    /* access modifiers changed from: private */
    public ControlDispatcher controlDispatcher;
    /* access modifiers changed from: private */
    public int currentNotificationTag;
    /* access modifiers changed from: private */
    @Nullable
    public final CustomActionReceiver customActionReceiver;
    /* access modifiers changed from: private */
    public final Map<String, NotificationCompat.Action> customActions;
    private int defaults;
    private final PendingIntent dismissPendingIntent;
    private long fastForwardMs;
    /* access modifiers changed from: private */
    public final int instanceId;
    private final IntentFilter intentFilter;
    /* access modifiers changed from: private */
    public boolean isNotificationStarted;
    /* access modifiers changed from: private */
    public int lastPlaybackState;
    /* access modifiers changed from: private */
    public final Handler mainHandler;
    private final MediaDescriptionAdapter mediaDescriptionAdapter;
    @Nullable
    private MediaSessionCompat.Token mediaSessionToken;
    private final NotificationBroadcastReceiver notificationBroadcastReceiver;
    private final int notificationId;
    @Nullable
    private NotificationListener notificationListener;
    private final NotificationManagerCompat notificationManager;
    private final Map<String, NotificationCompat.Action> playbackActions;
    /* access modifiers changed from: private */
    @Nullable
    public PlaybackPreparer playbackPreparer;
    /* access modifiers changed from: private */
    @Nullable
    public Player player;
    private final Player.EventListener playerListener;
    private int priority;
    private long rewindMs;
    @DrawableRes
    private int smallIconResourceId;
    private boolean useChronometer;
    private boolean useNavigationActions;
    private boolean useNavigationActionsInCompactView;
    private boolean usePlayPauseActions;
    private boolean useStopAction;
    private int visibility;
    /* access modifiers changed from: private */
    public boolean wasPlayWhenReady;
    private final Timeline.Window window;

    /* renamed from: com.google.android.exoplayer2.ui.PlayerNotificationManager$CustomActionReceiver */
    public interface CustomActionReceiver {
        Map<String, NotificationCompat.Action> createCustomActions(Context context, int i);

        List<String> getCustomActions(Player player);

        void onCustomAction(Player player, String str, Intent intent);
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlayerNotificationManager$MediaDescriptionAdapter */
    public interface MediaDescriptionAdapter {

        /* renamed from: com.google.android.exoplayer2.ui.PlayerNotificationManager$MediaDescriptionAdapter$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            @Nullable
            public static String $default$getCurrentSubText(MediaDescriptionAdapter mediaDescriptionAdapter, Player player) {
                return null;
            }
        }

        @Nullable
        PendingIntent createCurrentContentIntent(Player player);

        @Nullable
        String getCurrentContentText(Player player);

        String getCurrentContentTitle(Player player);

        @Nullable
        Bitmap getCurrentLargeIcon(Player player, BitmapCallback bitmapCallback);

        @Nullable
        String getCurrentSubText(Player player);
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlayerNotificationManager$NotificationListener */
    public interface NotificationListener {

        /* renamed from: com.google.android.exoplayer2.ui.PlayerNotificationManager$NotificationListener$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            @Deprecated
            public static void $default$onNotificationCancelled(NotificationListener notificationListener, int i) {
            }

            public static void $default$onNotificationCancelled(NotificationListener notificationListener, int i, boolean z) {
            }

            public static void $default$onNotificationPosted(NotificationListener notificationListener, int i, Notification notification, boolean z) {
            }

            @Deprecated
            public static void $default$onNotificationStarted(NotificationListener notificationListener, int i, Notification notification) {
            }
        }

        @Deprecated
        void onNotificationCancelled(int i);

        void onNotificationCancelled(int i, boolean z);

        void onNotificationPosted(int i, Notification notification, boolean z);

        @Deprecated
        void onNotificationStarted(int i, Notification notification);
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.google.android.exoplayer2.ui.PlayerNotificationManager$Priority */
    public @interface Priority {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.google.android.exoplayer2.ui.PlayerNotificationManager$Visibility */
    public @interface Visibility {
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlayerNotificationManager$BitmapCallback */
    public final class BitmapCallback {
        private final int notificationTag;

        private BitmapCallback(int i) {
            this.notificationTag = i;
        }

        public void onBitmap(Bitmap bitmap) {
            if (bitmap != null) {
                PlayerNotificationManager.this.mainHandler.post(new Runnable(bitmap) {
                    private final /* synthetic */ Bitmap f$1;

                    {
                        this.f$1 = r2;
                    }

                    public final void run() {
                        PlayerNotificationManager.BitmapCallback.this.lambda$onBitmap$0$PlayerNotificationManager$BitmapCallback(this.f$1);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onBitmap$0$PlayerNotificationManager$BitmapCallback(Bitmap bitmap) {
            if (PlayerNotificationManager.this.player != null && this.notificationTag == PlayerNotificationManager.this.currentNotificationTag && PlayerNotificationManager.this.isNotificationStarted) {
                Notification unused = PlayerNotificationManager.this.startOrUpdateNotification(bitmap);
            }
        }
    }

    @Deprecated
    public static PlayerNotificationManager createWithNotificationChannel(Context context2, String str, @StringRes int i, int i2, MediaDescriptionAdapter mediaDescriptionAdapter2) {
        return createWithNotificationChannel(context2, str, i, 0, i2, mediaDescriptionAdapter2);
    }

    public static PlayerNotificationManager createWithNotificationChannel(Context context2, String str, @StringRes int i, @StringRes int i2, int i3, MediaDescriptionAdapter mediaDescriptionAdapter2) {
        NotificationUtil.createNotificationChannel(context2, str, i, i2, 2);
        return new PlayerNotificationManager(context2, str, i3, mediaDescriptionAdapter2);
    }

    @Deprecated
    public static PlayerNotificationManager createWithNotificationChannel(Context context2, String str, @StringRes int i, int i2, MediaDescriptionAdapter mediaDescriptionAdapter2, @Nullable NotificationListener notificationListener2) {
        return createWithNotificationChannel(context2, str, i, 0, i2, mediaDescriptionAdapter2, notificationListener2);
    }

    public static PlayerNotificationManager createWithNotificationChannel(Context context2, String str, @StringRes int i, @StringRes int i2, int i3, MediaDescriptionAdapter mediaDescriptionAdapter2, @Nullable NotificationListener notificationListener2) {
        NotificationUtil.createNotificationChannel(context2, str, i, i2, 2);
        return new PlayerNotificationManager(context2, str, i3, mediaDescriptionAdapter2, notificationListener2);
    }

    public PlayerNotificationManager(Context context2, String str, int i, MediaDescriptionAdapter mediaDescriptionAdapter2) {
        this(context2, str, i, mediaDescriptionAdapter2, (NotificationListener) null, (CustomActionReceiver) null);
    }

    public PlayerNotificationManager(Context context2, String str, int i, MediaDescriptionAdapter mediaDescriptionAdapter2, @Nullable NotificationListener notificationListener2) {
        this(context2, str, i, mediaDescriptionAdapter2, notificationListener2, (CustomActionReceiver) null);
    }

    public PlayerNotificationManager(Context context2, String str, int i, MediaDescriptionAdapter mediaDescriptionAdapter2, @Nullable CustomActionReceiver customActionReceiver2) {
        this(context2, str, i, mediaDescriptionAdapter2, (NotificationListener) null, customActionReceiver2);
    }

    public PlayerNotificationManager(Context context2, String str, int i, MediaDescriptionAdapter mediaDescriptionAdapter2, @Nullable NotificationListener notificationListener2, @Nullable CustomActionReceiver customActionReceiver2) {
        Map<String, NotificationCompat.Action> map;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        this.channelId = str;
        this.notificationId = i;
        this.mediaDescriptionAdapter = mediaDescriptionAdapter2;
        this.notificationListener = notificationListener2;
        this.customActionReceiver = customActionReceiver2;
        this.controlDispatcher = new DefaultControlDispatcher();
        this.window = new Timeline.Window();
        int i2 = instanceIdCounter;
        instanceIdCounter = i2 + 1;
        this.instanceId = i2;
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.notificationManager = NotificationManagerCompat.from(applicationContext);
        this.playerListener = new PlayerListener();
        this.notificationBroadcastReceiver = new NotificationBroadcastReceiver();
        this.intentFilter = new IntentFilter();
        this.useNavigationActions = true;
        this.usePlayPauseActions = true;
        this.colorized = true;
        this.useChronometer = true;
        this.color = 0;
        this.smallIconResourceId = C1247R.C1249drawable.exo_notification_small_icon;
        this.defaults = 0;
        this.priority = -1;
        this.fastForwardMs = 15000;
        this.rewindMs = DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS;
        this.badgeIconType = 1;
        this.visibility = 1;
        this.playbackActions = createPlaybackActions(applicationContext, this.instanceId);
        for (String addAction : this.playbackActions.keySet()) {
            this.intentFilter.addAction(addAction);
        }
        if (customActionReceiver2 != null) {
            map = customActionReceiver2.createCustomActions(applicationContext, this.instanceId);
        } else {
            map = Collections.emptyMap();
        }
        this.customActions = map;
        for (String addAction2 : this.customActions.keySet()) {
            this.intentFilter.addAction(addAction2);
        }
        this.dismissPendingIntent = createBroadcastIntent(ACTION_DISMISS, applicationContext, this.instanceId);
        this.intentFilter.addAction(ACTION_DISMISS);
    }

    public final void setPlayer(@Nullable Player player2) {
        boolean z = true;
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        if (!(player2 == null || player2.getApplicationLooper() == Looper.getMainLooper())) {
            z = false;
        }
        Assertions.checkArgument(z);
        Player player3 = this.player;
        if (player3 != player2) {
            if (player3 != null) {
                player3.removeListener(this.playerListener);
                if (player2 == null) {
                    stopNotification(false);
                }
            }
            this.player = player2;
            if (player2 != null) {
                this.wasPlayWhenReady = player2.getPlayWhenReady();
                this.lastPlaybackState = player2.getPlaybackState();
                player2.addListener(this.playerListener);
                startOrUpdateNotification();
            }
        }
    }

    public void setPlaybackPreparer(@Nullable PlaybackPreparer playbackPreparer2) {
        this.playbackPreparer = playbackPreparer2;
    }

    public final void setControlDispatcher(ControlDispatcher controlDispatcher2) {
        if (controlDispatcher2 == null) {
            controlDispatcher2 = new DefaultControlDispatcher();
        }
        this.controlDispatcher = controlDispatcher2;
    }

    @Deprecated
    public final void setNotificationListener(NotificationListener notificationListener2) {
        this.notificationListener = notificationListener2;
    }

    public final void setFastForwardIncrementMs(long j) {
        if (this.fastForwardMs != j) {
            this.fastForwardMs = j;
            invalidate();
        }
    }

    public final void setRewindIncrementMs(long j) {
        if (this.rewindMs != j) {
            this.rewindMs = j;
            invalidate();
        }
    }

    public final void setUseNavigationActions(boolean z) {
        if (this.useNavigationActions != z) {
            this.useNavigationActions = z;
            invalidate();
        }
    }

    public final void setUseNavigationActionsInCompactView(boolean z) {
        if (this.useNavigationActionsInCompactView != z) {
            this.useNavigationActionsInCompactView = z;
            invalidate();
        }
    }

    public final void setUsePlayPauseActions(boolean z) {
        if (this.usePlayPauseActions != z) {
            this.usePlayPauseActions = z;
            invalidate();
        }
    }

    public final void setUseStopAction(boolean z) {
        if (this.useStopAction != z) {
            this.useStopAction = z;
            invalidate();
        }
    }

    public final void setMediaSessionToken(MediaSessionCompat.Token token) {
        if (!Util.areEqual(this.mediaSessionToken, token)) {
            this.mediaSessionToken = token;
            invalidate();
        }
    }

    public final void setBadgeIconType(int i) {
        if (this.badgeIconType != i) {
            if (i == 0 || i == 1 || i == 2) {
                this.badgeIconType = i;
                invalidate();
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public final void setColorized(boolean z) {
        if (this.colorized != z) {
            this.colorized = z;
            invalidate();
        }
    }

    public final void setDefaults(int i) {
        if (this.defaults != i) {
            this.defaults = i;
            invalidate();
        }
    }

    public final void setColor(int i) {
        if (this.color != i) {
            this.color = i;
            invalidate();
        }
    }

    public final void setPriority(int i) {
        if (this.priority != i) {
            if (i == -2 || i == -1 || i == 0 || i == 1 || i == 2) {
                this.priority = i;
                invalidate();
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public final void setSmallIcon(@DrawableRes int i) {
        if (this.smallIconResourceId != i) {
            this.smallIconResourceId = i;
            invalidate();
        }
    }

    public final void setUseChronometer(boolean z) {
        if (this.useChronometer != z) {
            this.useChronometer = z;
            invalidate();
        }
    }

    public final void setVisibility(int i) {
        if (this.visibility != i) {
            if (i == -1 || i == 0 || i == 1) {
                this.visibility = i;
                invalidate();
                return;
            }
            throw new IllegalStateException();
        }
    }

    public void invalidate() {
        if (this.isNotificationStarted && this.player != null) {
            startOrUpdateNotification();
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public Notification startOrUpdateNotification() {
        Assertions.checkNotNull(this.player);
        return startOrUpdateNotification((Bitmap) null);
    }

    /* access modifiers changed from: private */
    @RequiresNonNull({"player"})
    @Nullable
    public Notification startOrUpdateNotification(@Nullable Bitmap bitmap) {
        Player player2 = this.player;
        boolean ongoing = getOngoing(player2);
        this.builder = createNotification(player2, this.builder, ongoing, bitmap);
        NotificationCompat.Builder builder2 = this.builder;
        if (builder2 == null) {
            stopNotification(false);
            return null;
        }
        Notification build = builder2.build();
        this.notificationManager.notify(this.notificationId, build);
        if (!this.isNotificationStarted) {
            this.isNotificationStarted = true;
            this.context.registerReceiver(this.notificationBroadcastReceiver, this.intentFilter);
            NotificationListener notificationListener2 = this.notificationListener;
            if (notificationListener2 != null) {
                notificationListener2.onNotificationStarted(this.notificationId, build);
            }
        }
        NotificationListener notificationListener3 = this.notificationListener;
        if (notificationListener3 != null) {
            notificationListener3.onNotificationPosted(this.notificationId, build, ongoing);
        }
        return build;
    }

    /* access modifiers changed from: private */
    public void stopNotification(boolean z) {
        if (this.isNotificationStarted) {
            this.isNotificationStarted = false;
            this.notificationManager.cancel(this.notificationId);
            this.context.unregisterReceiver(this.notificationBroadcastReceiver);
            NotificationListener notificationListener2 = this.notificationListener;
            if (notificationListener2 != null) {
                notificationListener2.onNotificationCancelled(this.notificationId, z);
                this.notificationListener.onNotificationCancelled(this.notificationId);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Nullable
    public NotificationCompat.Builder createNotification(Player player2, @Nullable NotificationCompat.Builder builder2, boolean z, @Nullable Bitmap bitmap) {
        NotificationCompat.Action action;
        if (player2.getPlaybackState() != 1 || (!player2.getCurrentTimeline().isEmpty() && this.playbackPreparer != null)) {
            List<String> actions = getActions(player2);
            ArrayList<NotificationCompat.Action> arrayList = new ArrayList<>(actions.size());
            for (int i = 0; i < actions.size(); i++) {
                String str = actions.get(i);
                if (this.playbackActions.containsKey(str)) {
                    action = this.playbackActions.get(str);
                } else {
                    action = this.customActions.get(str);
                }
                if (action != null) {
                    arrayList.add(action);
                }
            }
            if (builder2 == null || !arrayList.equals(this.builderActions)) {
                builder2 = new NotificationCompat.Builder(this.context, this.channelId);
                this.builderActions = arrayList;
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    builder2.addAction(arrayList.get(i2));
                }
            }
            NotificationCompat.MediaStyle mediaStyle = new NotificationCompat.MediaStyle();
            MediaSessionCompat.Token token = this.mediaSessionToken;
            if (token != null) {
                mediaStyle.setMediaSession(token);
            }
            mediaStyle.setShowActionsInCompactView(getActionIndicesForCompactView(actions, player2));
            mediaStyle.setShowCancelButton(!z);
            mediaStyle.setCancelButtonIntent(this.dismissPendingIntent);
            builder2.setStyle(mediaStyle);
            builder2.setDeleteIntent(this.dismissPendingIntent);
            builder2.setBadgeIconType(this.badgeIconType).setOngoing(z).setColor(this.color).setColorized(this.colorized).setSmallIcon(this.smallIconResourceId).setVisibility(this.visibility).setPriority(this.priority).setDefaults(this.defaults);
            if (Util.SDK_INT < 21 || !this.useChronometer || player2.isPlayingAd() || player2.isCurrentWindowDynamic() || !player2.getPlayWhenReady() || player2.getPlaybackState() != 3) {
                builder2.setShowWhen(false).setUsesChronometer(false);
            } else {
                builder2.setWhen(System.currentTimeMillis() - player2.getContentPosition()).setShowWhen(true).setUsesChronometer(true);
            }
            builder2.setContentTitle(this.mediaDescriptionAdapter.getCurrentContentTitle(player2));
            builder2.setContentText(this.mediaDescriptionAdapter.getCurrentContentText(player2));
            builder2.setSubText(this.mediaDescriptionAdapter.getCurrentSubText(player2));
            if (bitmap == null) {
                MediaDescriptionAdapter mediaDescriptionAdapter2 = this.mediaDescriptionAdapter;
                int i3 = this.currentNotificationTag + 1;
                this.currentNotificationTag = i3;
                bitmap = mediaDescriptionAdapter2.getCurrentLargeIcon(player2, new BitmapCallback(i3));
            }
            setLargeIcon(builder2, bitmap);
            builder2.setContentIntent(this.mediaDescriptionAdapter.createCurrentContentIntent(player2));
            return builder2;
        }
        this.builderActions = null;
        return null;
    }

    /* access modifiers changed from: protected */
    public List<String> getActions(Player player2) {
        boolean z;
        boolean z2;
        boolean z3;
        Timeline currentTimeline = player2.getCurrentTimeline();
        boolean z4 = false;
        if (currentTimeline.isEmpty() || player2.isPlayingAd()) {
            z3 = false;
            z2 = false;
            z = false;
        } else {
            currentTimeline.getWindow(player2.getCurrentWindowIndex(), this.window);
            z3 = this.window.isSeekable || !this.window.isDynamic || player2.hasPrevious();
            boolean z5 = this.rewindMs > 0;
            z = this.fastForwardMs > 0;
            if (this.window.isDynamic || player2.hasNext()) {
                z4 = true;
            }
            z2 = z4;
            z4 = z5;
        }
        ArrayList arrayList = new ArrayList();
        if (this.useNavigationActions && z3) {
            arrayList.add(ACTION_PREVIOUS);
        }
        if (z4) {
            arrayList.add(ACTION_REWIND);
        }
        if (this.usePlayPauseActions) {
            if (isPlaying(player2)) {
                arrayList.add(ACTION_PAUSE);
            } else {
                arrayList.add(ACTION_PLAY);
            }
        }
        if (z) {
            arrayList.add(ACTION_FAST_FORWARD);
        }
        if (this.useNavigationActions && z2) {
            arrayList.add(ACTION_NEXT);
        }
        CustomActionReceiver customActionReceiver2 = this.customActionReceiver;
        if (customActionReceiver2 != null) {
            arrayList.addAll(customActionReceiver2.getCustomActions(player2));
        }
        if (this.useStopAction) {
            arrayList.add(ACTION_STOP);
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public int[] getActionIndicesForCompactView(List<String> list, Player player2) {
        int i;
        int indexOf = list.indexOf(ACTION_PAUSE);
        int indexOf2 = list.indexOf(ACTION_PLAY);
        int indexOf3 = this.useNavigationActionsInCompactView ? list.indexOf(ACTION_PREVIOUS) : -1;
        int indexOf4 = this.useNavigationActionsInCompactView ? list.indexOf(ACTION_NEXT) : -1;
        int[] iArr = new int[3];
        int i2 = 0;
        if (indexOf3 != -1) {
            iArr[0] = indexOf3;
            i2 = 1;
        }
        boolean playWhenReady = player2.getPlayWhenReady();
        if (indexOf != -1 && playWhenReady) {
            i = i2 + 1;
            iArr[i2] = indexOf;
        } else if (indexOf2 == -1 || playWhenReady) {
            i = i2;
        } else {
            i = i2 + 1;
            iArr[i2] = indexOf2;
        }
        if (indexOf4 != -1) {
            iArr[i] = indexOf4;
            i++;
        }
        return Arrays.copyOf(iArr, i);
    }

    /* access modifiers changed from: protected */
    public boolean getOngoing(Player player2) {
        int playbackState = player2.getPlaybackState();
        return (playbackState == 2 || playbackState == 3) && player2.getPlayWhenReady();
    }

    /* access modifiers changed from: private */
    public void previous(Player player2) {
        Timeline currentTimeline = player2.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && !player2.isPlayingAd()) {
            currentTimeline.getWindow(player2.getCurrentWindowIndex(), this.window);
            int previousWindowIndex = player2.getPreviousWindowIndex();
            if (previousWindowIndex == -1 || (player2.getCurrentPosition() > MAX_POSITION_FOR_SEEK_TO_PREVIOUS && (!this.window.isDynamic || this.window.isSeekable))) {
                seekTo(player2, 0);
            } else {
                seekTo(player2, previousWindowIndex, C1119C.TIME_UNSET);
            }
        }
    }

    /* access modifiers changed from: private */
    public void next(Player player2) {
        Timeline currentTimeline = player2.getCurrentTimeline();
        if (!currentTimeline.isEmpty() && !player2.isPlayingAd()) {
            int currentWindowIndex = player2.getCurrentWindowIndex();
            int nextWindowIndex = player2.getNextWindowIndex();
            if (nextWindowIndex != -1) {
                seekTo(player2, nextWindowIndex, C1119C.TIME_UNSET);
            } else if (currentTimeline.getWindow(currentWindowIndex, this.window).isDynamic) {
                seekTo(player2, currentWindowIndex, C1119C.TIME_UNSET);
            }
        }
    }

    /* access modifiers changed from: private */
    public void rewind(Player player2) {
        if (player2.isCurrentWindowSeekable() && this.rewindMs > 0) {
            seekTo(player2, Math.max(player2.getCurrentPosition() - this.rewindMs, 0));
        }
    }

    /* access modifiers changed from: private */
    public void fastForward(Player player2) {
        if (player2.isCurrentWindowSeekable() && this.fastForwardMs > 0) {
            seekTo(player2, player2.getCurrentPosition() + this.fastForwardMs);
        }
    }

    private void seekTo(Player player2, long j) {
        seekTo(player2, player2.getCurrentWindowIndex(), j);
    }

    private void seekTo(Player player2, int i, long j) {
        long duration = player2.getDuration();
        if (duration != C1119C.TIME_UNSET) {
            j = Math.min(j, duration);
        }
        this.controlDispatcher.dispatchSeekTo(player2, i, Math.max(j, 0));
    }

    private boolean isPlaying(Player player2) {
        if (player2.getPlaybackState() == 4 || player2.getPlaybackState() == 1 || !player2.getPlayWhenReady()) {
            return false;
        }
        return true;
    }

    private static Map<String, NotificationCompat.Action> createPlaybackActions(Context context2, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(ACTION_PLAY, new NotificationCompat.Action(C1247R.C1249drawable.exo_notification_play, (CharSequence) context2.getString(C1247R.string.exo_controls_play_description), createBroadcastIntent(ACTION_PLAY, context2, i)));
        hashMap.put(ACTION_PAUSE, new NotificationCompat.Action(C1247R.C1249drawable.exo_notification_pause, (CharSequence) context2.getString(C1247R.string.exo_controls_pause_description), createBroadcastIntent(ACTION_PAUSE, context2, i)));
        hashMap.put(ACTION_STOP, new NotificationCompat.Action(C1247R.C1249drawable.exo_notification_stop, (CharSequence) context2.getString(C1247R.string.exo_controls_stop_description), createBroadcastIntent(ACTION_STOP, context2, i)));
        hashMap.put(ACTION_REWIND, new NotificationCompat.Action(C1247R.C1249drawable.exo_notification_rewind, (CharSequence) context2.getString(C1247R.string.exo_controls_rewind_description), createBroadcastIntent(ACTION_REWIND, context2, i)));
        hashMap.put(ACTION_FAST_FORWARD, new NotificationCompat.Action(C1247R.C1249drawable.exo_notification_fastforward, (CharSequence) context2.getString(C1247R.string.exo_controls_fastforward_description), createBroadcastIntent(ACTION_FAST_FORWARD, context2, i)));
        hashMap.put(ACTION_PREVIOUS, new NotificationCompat.Action(C1247R.C1249drawable.exo_notification_previous, (CharSequence) context2.getString(C1247R.string.exo_controls_previous_description), createBroadcastIntent(ACTION_PREVIOUS, context2, i)));
        hashMap.put(ACTION_NEXT, new NotificationCompat.Action(C1247R.C1249drawable.exo_notification_next, (CharSequence) context2.getString(C1247R.string.exo_controls_next_description), createBroadcastIntent(ACTION_NEXT, context2, i)));
        return hashMap;
    }

    private static PendingIntent createBroadcastIntent(String str, Context context2, int i) {
        Intent intent = new Intent(str).setPackage(context2.getPackageName());
        intent.putExtra(EXTRA_INSTANCE_ID, i);
        return PendingIntent.getBroadcast(context2, i, intent, 134217728);
    }

    private static void setLargeIcon(NotificationCompat.Builder builder2, @Nullable Bitmap bitmap) {
        builder2.setLargeIcon(bitmap);
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlayerNotificationManager$PlayerListener */
    private class PlayerListener implements Player.EventListener {
        public /* synthetic */ void onLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onLoadingChanged(this, z);
        }

        public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
            Player.EventListener.CC.$default$onPlayerError(this, exoPlaybackException);
        }

        public /* synthetic */ void onSeekProcessed() {
            Player.EventListener.CC.$default$onSeekProcessed(this);
        }

        public /* synthetic */ void onShuffleModeEnabledChanged(boolean z) {
            Player.EventListener.CC.$default$onShuffleModeEnabledChanged(this, z);
        }

        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
        }

        private PlayerListener() {
        }

        public void onPlayerStateChanged(boolean z, int i) {
            if (PlayerNotificationManager.this.wasPlayWhenReady != z || PlayerNotificationManager.this.lastPlaybackState != i) {
                Notification unused = PlayerNotificationManager.this.startOrUpdateNotification();
                boolean unused2 = PlayerNotificationManager.this.wasPlayWhenReady = z;
                int unused3 = PlayerNotificationManager.this.lastPlaybackState = i;
            }
        }

        public void onTimelineChanged(Timeline timeline, @Nullable Object obj, int i) {
            Notification unused = PlayerNotificationManager.this.startOrUpdateNotification();
        }

        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            Notification unused = PlayerNotificationManager.this.startOrUpdateNotification();
        }

        public void onPositionDiscontinuity(int i) {
            Notification unused = PlayerNotificationManager.this.startOrUpdateNotification();
        }

        public void onRepeatModeChanged(int i) {
            Notification unused = PlayerNotificationManager.this.startOrUpdateNotification();
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlayerNotificationManager$NotificationBroadcastReceiver */
    private class NotificationBroadcastReceiver extends BroadcastReceiver {
        private NotificationBroadcastReceiver() {
        }

        public void onReceive(Context context, Intent intent) {
            Player access$100 = PlayerNotificationManager.this.player;
            if (access$100 != null && PlayerNotificationManager.this.isNotificationStarted && intent.getIntExtra(PlayerNotificationManager.EXTRA_INSTANCE_ID, PlayerNotificationManager.this.instanceId) == PlayerNotificationManager.this.instanceId) {
                String action = intent.getAction();
                if (PlayerNotificationManager.ACTION_PLAY.equals(action)) {
                    if (access$100.getPlaybackState() == 1) {
                        if (PlayerNotificationManager.this.playbackPreparer != null) {
                            PlayerNotificationManager.this.playbackPreparer.preparePlayback();
                        }
                    } else if (access$100.getPlaybackState() == 4) {
                        PlayerNotificationManager.this.controlDispatcher.dispatchSeekTo(access$100, access$100.getCurrentWindowIndex(), C1119C.TIME_UNSET);
                    }
                    PlayerNotificationManager.this.controlDispatcher.dispatchSetPlayWhenReady(access$100, true);
                } else if (PlayerNotificationManager.ACTION_PAUSE.equals(action)) {
                    PlayerNotificationManager.this.controlDispatcher.dispatchSetPlayWhenReady(access$100, false);
                } else if (PlayerNotificationManager.ACTION_PREVIOUS.equals(action)) {
                    PlayerNotificationManager.this.previous(access$100);
                } else if (PlayerNotificationManager.ACTION_REWIND.equals(action)) {
                    PlayerNotificationManager.this.rewind(access$100);
                } else if (PlayerNotificationManager.ACTION_FAST_FORWARD.equals(action)) {
                    PlayerNotificationManager.this.fastForward(access$100);
                } else if (PlayerNotificationManager.ACTION_NEXT.equals(action)) {
                    PlayerNotificationManager.this.next(access$100);
                } else if (PlayerNotificationManager.ACTION_STOP.equals(action)) {
                    PlayerNotificationManager.this.controlDispatcher.dispatchStop(access$100, true);
                } else if (PlayerNotificationManager.ACTION_DISMISS.equals(action)) {
                    PlayerNotificationManager.this.stopNotification(true);
                } else if (action != null && PlayerNotificationManager.this.customActionReceiver != null && PlayerNotificationManager.this.customActions.containsKey(action)) {
                    PlayerNotificationManager.this.customActionReceiver.onCustomAction(access$100, action, intent);
                }
            }
        }
    }
}
