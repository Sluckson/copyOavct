package com.google.android.exoplayer2.p009ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C1119C;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.p009ui.TimeBar;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.RepeatModeUtil;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;

/* renamed from: com.google.android.exoplayer2.ui.PlayerControlView */
public class PlayerControlView extends FrameLayout {
    public static final int DEFAULT_FAST_FORWARD_MS = 15000;
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_REWIND_MS = 5000;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    private static final long MAX_POSITION_FOR_SEEK_TO_PREVIOUS = 3000;
    private static final int MAX_UPDATE_INTERVAL_MS = 1000;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    private long[] adGroupTimesMs;
    private final ComponentListener componentListener;
    /* access modifiers changed from: private */
    public ControlDispatcher controlDispatcher;
    private long currentWindowOffset;
    private final TextView durationView;
    private long[] extraAdGroupTimesMs;
    private boolean[] extraPlayedAdGroups;
    /* access modifiers changed from: private */
    public final View fastForwardButton;
    private int fastForwardMs;
    /* access modifiers changed from: private */
    public final StringBuilder formatBuilder;
    /* access modifiers changed from: private */
    public final Formatter formatter;
    private final Runnable hideAction;
    private long hideAtMs;
    private boolean isAttachedToWindow;
    private boolean multiWindowTimeBar;
    /* access modifiers changed from: private */
    public final View nextButton;
    /* access modifiers changed from: private */
    public final View pauseButton;
    private final Timeline.Period period;
    /* access modifiers changed from: private */
    public final View playButton;
    /* access modifiers changed from: private */
    @Nullable
    public PlaybackPreparer playbackPreparer;
    private boolean[] playedAdGroups;
    /* access modifiers changed from: private */
    @Nullable
    public Player player;
    /* access modifiers changed from: private */
    public final TextView positionView;
    /* access modifiers changed from: private */
    public final View previousButton;
    @Nullable
    private ProgressUpdateListener progressUpdateListener;
    private final String repeatAllButtonContentDescription;
    private final Drawable repeatAllButtonDrawable;
    private final String repeatOffButtonContentDescription;
    private final Drawable repeatOffButtonDrawable;
    private final String repeatOneButtonContentDescription;
    private final Drawable repeatOneButtonDrawable;
    /* access modifiers changed from: private */
    public final ImageView repeatToggleButton;
    /* access modifiers changed from: private */
    public int repeatToggleModes;
    /* access modifiers changed from: private */
    public final View rewindButton;
    private int rewindMs;
    /* access modifiers changed from: private */
    public boolean scrubbing;
    private boolean showMultiWindowTimeBar;
    private boolean showShuffleButton;
    private int showTimeoutMs;
    /* access modifiers changed from: private */
    public final View shuffleButton;
    private final TimeBar timeBar;
    private int timeBarMinUpdateIntervalMs;
    private final Runnable updateProgressAction;
    @Nullable
    private VisibilityListener visibilityListener;
    private final View vrButton;
    private final Timeline.Window window;

    /* renamed from: com.google.android.exoplayer2.ui.PlayerControlView$ProgressUpdateListener */
    public interface ProgressUpdateListener {
        void onProgressUpdate(long j, long j2);
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlayerControlView$VisibilityListener */
    public interface VisibilityListener {
        void onVisibilityChange(int i);
    }

    @SuppressLint({"InlinedApi"})
    private static boolean isHandledMediaKey(int i) {
        return i == 90 || i == 89 || i == 85 || i == 126 || i == 127 || i == 87 || i == 88;
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        int i2 = C1247R.C1251layout.exo_player_control_view;
        this.rewindMs = 5000;
        this.fastForwardMs = 15000;
        this.showTimeoutMs = 5000;
        this.repeatToggleModes = 0;
        this.timeBarMinUpdateIntervalMs = 200;
        this.hideAtMs = C1119C.TIME_UNSET;
        this.showShuffleButton = false;
        if (attributeSet2 != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, C1247R.styleable.PlayerControlView, 0, 0);
            try {
                this.rewindMs = obtainStyledAttributes.getInt(C1247R.styleable.PlayerControlView_rewind_increment, this.rewindMs);
                this.fastForwardMs = obtainStyledAttributes.getInt(C1247R.styleable.PlayerControlView_fastforward_increment, this.fastForwardMs);
                this.showTimeoutMs = obtainStyledAttributes.getInt(C1247R.styleable.PlayerControlView_show_timeout, this.showTimeoutMs);
                i2 = obtainStyledAttributes.getResourceId(C1247R.styleable.PlayerControlView_controller_layout_id, i2);
                this.repeatToggleModes = getRepeatToggleModes(obtainStyledAttributes, this.repeatToggleModes);
                this.showShuffleButton = obtainStyledAttributes.getBoolean(C1247R.styleable.PlayerControlView_show_shuffle_button, this.showShuffleButton);
                setTimeBarMinUpdateInterval(obtainStyledAttributes.getInt(C1247R.styleable.PlayerControlView_time_bar_min_update_interval, this.timeBarMinUpdateIntervalMs));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.period = new Timeline.Period();
        this.window = new Timeline.Window();
        this.formatBuilder = new StringBuilder();
        this.formatter = new Formatter(this.formatBuilder, Locale.getDefault());
        this.adGroupTimesMs = new long[0];
        this.playedAdGroups = new boolean[0];
        this.extraAdGroupTimesMs = new long[0];
        this.extraPlayedAdGroups = new boolean[0];
        this.componentListener = new ComponentListener();
        this.controlDispatcher = new DefaultControlDispatcher();
        this.updateProgressAction = new Runnable() {
            public final void run() {
                PlayerControlView.this.updateProgress();
            }
        };
        this.hideAction = new Runnable() {
            public final void run() {
                PlayerControlView.this.hide();
            }
        };
        LayoutInflater.from(context).inflate(i2, this);
        setDescendantFocusability(262144);
        TimeBar timeBar2 = (TimeBar) findViewById(C1247R.C1250id.exo_progress);
        View findViewById = findViewById(C1247R.C1250id.exo_progress_placeholder);
        if (timeBar2 != null) {
            this.timeBar = timeBar2;
        } else if (findViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, (AttributeSet) null, 0, attributeSet2);
            defaultTimeBar.setId(C1247R.C1250id.exo_progress);
            defaultTimeBar.setLayoutParams(findViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
            int indexOfChild = viewGroup.indexOfChild(findViewById);
            viewGroup.removeView(findViewById);
            viewGroup.addView(defaultTimeBar, indexOfChild);
            this.timeBar = defaultTimeBar;
        } else {
            this.timeBar = null;
        }
        this.durationView = (TextView) findViewById(C1247R.C1250id.exo_duration);
        this.positionView = (TextView) findViewById(C1247R.C1250id.exo_position);
        TimeBar timeBar3 = this.timeBar;
        if (timeBar3 != null) {
            timeBar3.addListener(this.componentListener);
        }
        this.playButton = findViewById(C1247R.C1250id.exo_play);
        View view = this.playButton;
        if (view != null) {
            view.setOnClickListener(this.componentListener);
        }
        this.pauseButton = findViewById(C1247R.C1250id.exo_pause);
        View view2 = this.pauseButton;
        if (view2 != null) {
            view2.setOnClickListener(this.componentListener);
        }
        this.previousButton = findViewById(C1247R.C1250id.exo_prev);
        View view3 = this.previousButton;
        if (view3 != null) {
            view3.setOnClickListener(this.componentListener);
        }
        this.nextButton = findViewById(C1247R.C1250id.exo_next);
        View view4 = this.nextButton;
        if (view4 != null) {
            view4.setOnClickListener(this.componentListener);
        }
        this.rewindButton = findViewById(C1247R.C1250id.exo_rew);
        View view5 = this.rewindButton;
        if (view5 != null) {
            view5.setOnClickListener(this.componentListener);
        }
        this.fastForwardButton = findViewById(C1247R.C1250id.exo_ffwd);
        View view6 = this.fastForwardButton;
        if (view6 != null) {
            view6.setOnClickListener(this.componentListener);
        }
        this.repeatToggleButton = (ImageView) findViewById(C1247R.C1250id.exo_repeat_toggle);
        ImageView imageView = this.repeatToggleButton;
        if (imageView != null) {
            imageView.setOnClickListener(this.componentListener);
        }
        this.shuffleButton = findViewById(C1247R.C1250id.exo_shuffle);
        View view7 = this.shuffleButton;
        if (view7 != null) {
            view7.setOnClickListener(this.componentListener);
        }
        this.vrButton = findViewById(C1247R.C1250id.exo_vr);
        setShowVrButton(false);
        Resources resources = context.getResources();
        this.repeatOffButtonDrawable = resources.getDrawable(C1247R.C1249drawable.exo_controls_repeat_off);
        this.repeatOneButtonDrawable = resources.getDrawable(C1247R.C1249drawable.exo_controls_repeat_one);
        this.repeatAllButtonDrawable = resources.getDrawable(C1247R.C1249drawable.exo_controls_repeat_all);
        this.repeatOffButtonContentDescription = resources.getString(C1247R.string.exo_controls_repeat_off_description);
        this.repeatOneButtonContentDescription = resources.getString(C1247R.string.exo_controls_repeat_one_description);
        this.repeatAllButtonContentDescription = resources.getString(C1247R.string.exo_controls_repeat_all_description);
    }

    private static int getRepeatToggleModes(TypedArray typedArray, int i) {
        return typedArray.getInt(C1247R.styleable.PlayerControlView_repeat_toggle_modes, i);
    }

    @Nullable
    public Player getPlayer() {
        return this.player;
    }

    public void setPlayer(@Nullable Player player2) {
        boolean z = true;
        Assertions.checkState(Looper.myLooper() == Looper.getMainLooper());
        if (!(player2 == null || player2.getApplicationLooper() == Looper.getMainLooper())) {
            z = false;
        }
        Assertions.checkArgument(z);
        Player player3 = this.player;
        if (player3 != player2) {
            if (player3 != null) {
                player3.removeListener(this.componentListener);
            }
            this.player = player2;
            if (player2 != null) {
                player2.addListener(this.componentListener);
            }
            updateAll();
        }
    }

    public void setShowMultiWindowTimeBar(boolean z) {
        this.showMultiWindowTimeBar = z;
        updateTimeline();
    }

    public void setExtraAdGroupMarkers(@Nullable long[] jArr, @Nullable boolean[] zArr) {
        boolean z = false;
        if (jArr == null) {
            this.extraAdGroupTimesMs = new long[0];
            this.extraPlayedAdGroups = new boolean[0];
        } else {
            boolean[] zArr2 = (boolean[]) Assertions.checkNotNull(zArr);
            if (jArr.length == zArr2.length) {
                z = true;
            }
            Assertions.checkArgument(z);
            this.extraAdGroupTimesMs = jArr;
            this.extraPlayedAdGroups = zArr2;
        }
        updateTimeline();
    }

    public void setVisibilityListener(VisibilityListener visibilityListener2) {
        this.visibilityListener = visibilityListener2;
    }

    public void setProgressUpdateListener(@Nullable ProgressUpdateListener progressUpdateListener2) {
        this.progressUpdateListener = progressUpdateListener2;
    }

    public void setPlaybackPreparer(@Nullable PlaybackPreparer playbackPreparer2) {
        this.playbackPreparer = playbackPreparer2;
    }

    public void setControlDispatcher(@Nullable ControlDispatcher controlDispatcher2) {
        if (controlDispatcher2 == null) {
            controlDispatcher2 = new DefaultControlDispatcher();
        }
        this.controlDispatcher = controlDispatcher2;
    }

    public void setRewindIncrementMs(int i) {
        this.rewindMs = i;
        updateNavigation();
    }

    public void setFastForwardIncrementMs(int i) {
        this.fastForwardMs = i;
        updateNavigation();
    }

    public int getShowTimeoutMs() {
        return this.showTimeoutMs;
    }

    public void setShowTimeoutMs(int i) {
        this.showTimeoutMs = i;
        if (isVisible()) {
            hideAfterTimeout();
        }
    }

    public int getRepeatToggleModes() {
        return this.repeatToggleModes;
    }

    public void setRepeatToggleModes(int i) {
        this.repeatToggleModes = i;
        Player player2 = this.player;
        if (player2 != null) {
            int repeatMode = player2.getRepeatMode();
            if (i == 0 && repeatMode != 0) {
                this.controlDispatcher.dispatchSetRepeatMode(this.player, 0);
            } else if (i == 1 && repeatMode == 2) {
                this.controlDispatcher.dispatchSetRepeatMode(this.player, 1);
            } else if (i == 2 && repeatMode == 1) {
                this.controlDispatcher.dispatchSetRepeatMode(this.player, 2);
            }
        }
        updateRepeatModeButton();
    }

    public boolean getShowShuffleButton() {
        return this.showShuffleButton;
    }

    public void setShowShuffleButton(boolean z) {
        this.showShuffleButton = z;
        updateShuffleButton();
    }

    public boolean getShowVrButton() {
        View view = this.vrButton;
        return view != null && view.getVisibility() == 0;
    }

    public void setShowVrButton(boolean z) {
        View view = this.vrButton;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.vrButton;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.timeBarMinUpdateIntervalMs = Util.constrainValue(i, 16, 1000);
    }

    public void show() {
        if (!isVisible()) {
            setVisibility(0);
            VisibilityListener visibilityListener2 = this.visibilityListener;
            if (visibilityListener2 != null) {
                visibilityListener2.onVisibilityChange(getVisibility());
            }
            updateAll();
            requestPlayPauseFocus();
        }
        hideAfterTimeout();
    }

    public void hide() {
        if (isVisible()) {
            setVisibility(8);
            VisibilityListener visibilityListener2 = this.visibilityListener;
            if (visibilityListener2 != null) {
                visibilityListener2.onVisibilityChange(getVisibility());
            }
            removeCallbacks(this.updateProgressAction);
            removeCallbacks(this.hideAction);
            this.hideAtMs = C1119C.TIME_UNSET;
        }
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    private void hideAfterTimeout() {
        removeCallbacks(this.hideAction);
        if (this.showTimeoutMs > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int i = this.showTimeoutMs;
            this.hideAtMs = uptimeMillis + ((long) i);
            if (this.isAttachedToWindow) {
                postDelayed(this.hideAction, (long) i);
                return;
            }
            return;
        }
        this.hideAtMs = C1119C.TIME_UNSET;
    }

    private void updateAll() {
        updatePlayPauseButton();
        updateNavigation();
        updateRepeatModeButton();
        updateShuffleButton();
        updateTimeline();
    }

    /* access modifiers changed from: private */
    public void updatePlayPauseButton() {
        boolean z;
        if (isVisible() && this.isAttachedToWindow) {
            boolean isPlaying = isPlaying();
            View view = this.playButton;
            int i = 8;
            boolean z2 = true;
            if (view != null) {
                z = (isPlaying && view.isFocused()) | false;
                this.playButton.setVisibility(isPlaying ? 8 : 0);
            } else {
                z = false;
            }
            View view2 = this.pauseButton;
            if (view2 != null) {
                if (isPlaying || !view2.isFocused()) {
                    z2 = false;
                }
                z |= z2;
                View view3 = this.pauseButton;
                if (isPlaying) {
                    i = 0;
                }
                view3.setVisibility(i);
            }
            if (z) {
                requestPlayPauseFocus();
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateNavigation() {
        /*
            r7 = this;
            boolean r0 = r7.isVisible()
            if (r0 == 0) goto L_0x008b
            boolean r0 = r7.isAttachedToWindow
            if (r0 != 0) goto L_0x000c
            goto L_0x008b
        L_0x000c:
            com.google.android.exoplayer2.Player r0 = r7.player
            r1 = 0
            if (r0 == 0) goto L_0x006c
            com.google.android.exoplayer2.Timeline r0 = r0.getCurrentTimeline()
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x006c
            com.google.android.exoplayer2.Player r2 = r7.player
            boolean r2 = r2.isPlayingAd()
            if (r2 != 0) goto L_0x006c
            com.google.android.exoplayer2.Player r2 = r7.player
            int r2 = r2.getCurrentWindowIndex()
            com.google.android.exoplayer2.Timeline$Window r3 = r7.window
            r0.getWindow(r2, r3)
            com.google.android.exoplayer2.Timeline$Window r0 = r7.window
            boolean r0 = r0.isSeekable
            r2 = 1
            if (r0 != 0) goto L_0x0046
            com.google.android.exoplayer2.Timeline$Window r3 = r7.window
            boolean r3 = r3.isDynamic
            if (r3 == 0) goto L_0x0046
            com.google.android.exoplayer2.Player r3 = r7.player
            boolean r3 = r3.hasPrevious()
            if (r3 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r3 = 0
            goto L_0x0047
        L_0x0046:
            r3 = 1
        L_0x0047:
            if (r0 == 0) goto L_0x004f
            int r4 = r7.rewindMs
            if (r4 <= 0) goto L_0x004f
            r4 = 1
            goto L_0x0050
        L_0x004f:
            r4 = 0
        L_0x0050:
            if (r0 == 0) goto L_0x0058
            int r5 = r7.fastForwardMs
            if (r5 <= 0) goto L_0x0058
            r5 = 1
            goto L_0x0059
        L_0x0058:
            r5 = 0
        L_0x0059:
            com.google.android.exoplayer2.Timeline$Window r6 = r7.window
            boolean r6 = r6.isDynamic
            if (r6 != 0) goto L_0x0067
            com.google.android.exoplayer2.Player r6 = r7.player
            boolean r6 = r6.hasNext()
            if (r6 == 0) goto L_0x0068
        L_0x0067:
            r1 = 1
        L_0x0068:
            r2 = r0
            r0 = r1
            r1 = r3
            goto L_0x0070
        L_0x006c:
            r0 = 0
            r2 = 0
            r4 = 0
            r5 = 0
        L_0x0070:
            android.view.View r3 = r7.previousButton
            r7.setButtonEnabled(r1, r3)
            android.view.View r1 = r7.rewindButton
            r7.setButtonEnabled(r4, r1)
            android.view.View r1 = r7.fastForwardButton
            r7.setButtonEnabled(r5, r1)
            android.view.View r1 = r7.nextButton
            r7.setButtonEnabled(r0, r1)
            com.google.android.exoplayer2.ui.TimeBar r0 = r7.timeBar
            if (r0 == 0) goto L_0x008b
            r0.setEnabled(r2)
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.p009ui.PlayerControlView.updateNavigation():void");
    }

    /* access modifiers changed from: private */
    public void updateRepeatModeButton() {
        ImageView imageView;
        if (isVisible() && this.isAttachedToWindow && (imageView = this.repeatToggleButton) != null) {
            if (this.repeatToggleModes == 0) {
                imageView.setVisibility(8);
            } else if (this.player == null) {
                setButtonEnabled(false, imageView);
            } else {
                setButtonEnabled(true, imageView);
                int repeatMode = this.player.getRepeatMode();
                if (repeatMode == 0) {
                    this.repeatToggleButton.setImageDrawable(this.repeatOffButtonDrawable);
                    this.repeatToggleButton.setContentDescription(this.repeatOffButtonContentDescription);
                } else if (repeatMode == 1) {
                    this.repeatToggleButton.setImageDrawable(this.repeatOneButtonDrawable);
                    this.repeatToggleButton.setContentDescription(this.repeatOneButtonContentDescription);
                } else if (repeatMode == 2) {
                    this.repeatToggleButton.setImageDrawable(this.repeatAllButtonDrawable);
                    this.repeatToggleButton.setContentDescription(this.repeatAllButtonContentDescription);
                }
                this.repeatToggleButton.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateShuffleButton() {
        View view;
        if (isVisible() && this.isAttachedToWindow && (view = this.shuffleButton) != null) {
            if (!this.showShuffleButton) {
                view.setVisibility(8);
                return;
            }
            Player player2 = this.player;
            if (player2 == null) {
                setButtonEnabled(false, view);
                return;
            }
            view.setAlpha(player2.getShuffleModeEnabled() ? 1.0f : 0.3f);
            this.shuffleButton.setEnabled(true);
            this.shuffleButton.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void updateTimeline() {
        long j;
        int i;
        long j2;
        long j3;
        Player player2 = this.player;
        if (player2 != null) {
            boolean z = true;
            this.multiWindowTimeBar = this.showMultiWindowTimeBar && canShowMultiWindowTimeBar(player2.getCurrentTimeline(), this.window);
            long j4 = 0;
            this.currentWindowOffset = 0;
            Timeline currentTimeline = this.player.getCurrentTimeline();
            if (!currentTimeline.isEmpty()) {
                int currentWindowIndex = this.player.getCurrentWindowIndex();
                int i2 = this.multiWindowTimeBar ? 0 : currentWindowIndex;
                int windowCount = this.multiWindowTimeBar ? currentTimeline.getWindowCount() - 1 : currentWindowIndex;
                long j5 = 0;
                i = 0;
                while (true) {
                    if (i2 > windowCount) {
                        break;
                    }
                    if (i2 == currentWindowIndex) {
                        this.currentWindowOffset = C1119C.usToMs(j5);
                    }
                    currentTimeline.getWindow(i2, this.window);
                    long j6 = this.window.durationUs;
                    long j7 = C1119C.TIME_UNSET;
                    if (j6 == C1119C.TIME_UNSET) {
                        Assertions.checkState(this.multiWindowTimeBar ^ z);
                        break;
                    }
                    int i3 = this.window.firstPeriodIndex;
                    while (i3 <= this.window.lastPeriodIndex) {
                        currentTimeline.getPeriod(i3, this.period);
                        int adGroupCount = this.period.getAdGroupCount();
                        int i4 = i;
                        int i5 = 0;
                        while (i5 < adGroupCount) {
                            long adGroupTimeUs = this.period.getAdGroupTimeUs(i5);
                            if (adGroupTimeUs != Long.MIN_VALUE) {
                                j3 = adGroupTimeUs;
                            } else if (this.period.durationUs == j7) {
                                j2 = 0;
                                i5++;
                                j4 = j2;
                                j7 = C1119C.TIME_UNSET;
                            } else {
                                j3 = this.period.durationUs;
                            }
                            long positionInWindowUs = j3 + this.period.getPositionInWindowUs();
                            j2 = 0;
                            if (positionInWindowUs >= 0 && positionInWindowUs <= this.window.durationUs) {
                                long[] jArr = this.adGroupTimesMs;
                                if (i4 == jArr.length) {
                                    int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                    this.adGroupTimesMs = Arrays.copyOf(this.adGroupTimesMs, length);
                                    this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, length);
                                }
                                this.adGroupTimesMs[i4] = C1119C.usToMs(positionInWindowUs + j5);
                                this.playedAdGroups[i4] = this.period.hasPlayedAdGroup(i5);
                                i4++;
                            }
                            i5++;
                            j4 = j2;
                            j7 = C1119C.TIME_UNSET;
                        }
                        long j8 = j4;
                        i3++;
                        i = i4;
                        j7 = C1119C.TIME_UNSET;
                    }
                    j5 += this.window.durationUs;
                    i2++;
                    j4 = j4;
                    z = true;
                }
                j = j5;
            } else {
                j = 0;
                i = 0;
            }
            long usToMs = C1119C.usToMs(j);
            TextView textView = this.durationView;
            if (textView != null) {
                textView.setText(Util.getStringForTime(this.formatBuilder, this.formatter, usToMs));
            }
            TimeBar timeBar2 = this.timeBar;
            if (timeBar2 != null) {
                timeBar2.setDuration(usToMs);
                int length2 = this.extraAdGroupTimesMs.length;
                int i6 = i + length2;
                long[] jArr2 = this.adGroupTimesMs;
                if (i6 > jArr2.length) {
                    this.adGroupTimesMs = Arrays.copyOf(jArr2, i6);
                    this.playedAdGroups = Arrays.copyOf(this.playedAdGroups, i6);
                }
                System.arraycopy(this.extraAdGroupTimesMs, 0, this.adGroupTimesMs, i, length2);
                System.arraycopy(this.extraPlayedAdGroups, 0, this.playedAdGroups, i, length2);
                this.timeBar.setAdGroupTimesMs(this.adGroupTimesMs, this.playedAdGroups, i6);
            }
            updateProgress();
        }
    }

    /* access modifiers changed from: private */
    public void updateProgress() {
        long j;
        if (isVisible() && this.isAttachedToWindow) {
            Player player2 = this.player;
            long j2 = 0;
            if (player2 != null) {
                j2 = this.currentWindowOffset + player2.getContentPosition();
                j = this.currentWindowOffset + this.player.getContentBufferedPosition();
            } else {
                j = 0;
            }
            TextView textView = this.positionView;
            if (textView != null && !this.scrubbing) {
                textView.setText(Util.getStringForTime(this.formatBuilder, this.formatter, j2));
            }
            TimeBar timeBar2 = this.timeBar;
            if (timeBar2 != null) {
                timeBar2.setPosition(j2);
                this.timeBar.setBufferedPosition(j);
            }
            ProgressUpdateListener progressUpdateListener2 = this.progressUpdateListener;
            if (progressUpdateListener2 != null) {
                progressUpdateListener2.onProgressUpdate(j2, j);
            }
            removeCallbacks(this.updateProgressAction);
            Player player3 = this.player;
            int playbackState = player3 == null ? 1 : player3.getPlaybackState();
            long j3 = 1000;
            if (playbackState == 3 && this.player.getPlayWhenReady()) {
                TimeBar timeBar3 = this.timeBar;
                long min = Math.min(timeBar3 != null ? timeBar3.getPreferredUpdateDelay() : 1000, 1000 - (j2 % 1000));
                float f = this.player.getPlaybackParameters().speed;
                if (f > 0.0f) {
                    j3 = (long) (((float) min) / f);
                }
                postDelayed(this.updateProgressAction, Util.constrainValue(j3, (long) this.timeBarMinUpdateIntervalMs, 1000));
            } else if (playbackState != 4 && playbackState != 1) {
                postDelayed(this.updateProgressAction, 1000);
            }
        }
    }

    private void requestPlayPauseFocus() {
        View view;
        View view2;
        boolean isPlaying = isPlaying();
        if (!isPlaying && (view2 = this.playButton) != null) {
            view2.requestFocus();
        } else if (isPlaying && (view = this.pauseButton) != null) {
            view.requestFocus();
        }
    }

    private void setButtonEnabled(boolean z, View view) {
        if (view != null) {
            view.setEnabled(z);
            view.setAlpha(z ? 1.0f : 0.3f);
            view.setVisibility(0);
        }
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
            seekTo(player2, player2.getCurrentPosition() - ((long) this.rewindMs));
        }
    }

    /* access modifiers changed from: private */
    public void fastForward(Player player2) {
        if (player2.isCurrentWindowSeekable() && this.fastForwardMs > 0) {
            seekTo(player2, player2.getCurrentPosition() + ((long) this.fastForwardMs));
        }
    }

    private void seekTo(Player player2, long j) {
        seekTo(player2, player2.getCurrentWindowIndex(), j);
    }

    private boolean seekTo(Player player2, int i, long j) {
        long duration = player2.getDuration();
        if (duration != C1119C.TIME_UNSET) {
            j = Math.min(j, duration);
        }
        return this.controlDispatcher.dispatchSeekTo(player2, i, Math.max(j, 0));
    }

    /* access modifiers changed from: private */
    public void seekToTimeBarPosition(Player player2, long j) {
        int i;
        Timeline currentTimeline = player2.getCurrentTimeline();
        if (this.multiWindowTimeBar && !currentTimeline.isEmpty()) {
            int windowCount = currentTimeline.getWindowCount();
            i = 0;
            while (true) {
                long durationMs = currentTimeline.getWindow(i, this.window).getDurationMs();
                if (j < durationMs) {
                    break;
                } else if (i == windowCount - 1) {
                    j = durationMs;
                    break;
                } else {
                    j -= durationMs;
                    i++;
                }
            }
        } else {
            i = player2.getCurrentWindowIndex();
        }
        if (!seekTo(player2, i, j)) {
            updateProgress();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttachedToWindow = true;
        long j = this.hideAtMs;
        if (j != C1119C.TIME_UNSET) {
            long uptimeMillis = j - SystemClock.uptimeMillis();
            if (uptimeMillis <= 0) {
                hide();
            } else {
                postDelayed(this.hideAction, uptimeMillis);
            }
        } else if (isVisible()) {
            hideAfterTimeout();
        }
        updateAll();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        removeCallbacks(this.updateProgressAction);
        removeCallbacks(this.hideAction);
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.hideAction);
        } else if (motionEvent.getAction() == 1) {
            hideAfterTimeout();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return dispatchMediaKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (this.player == null || !isHandledMediaKey(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() == 0) {
            if (keyCode == 90) {
                fastForward(this.player);
            } else if (keyCode == 89) {
                rewind(this.player);
            } else if (keyEvent.getRepeatCount() == 0) {
                if (keyCode == 85) {
                    ControlDispatcher controlDispatcher2 = this.controlDispatcher;
                    Player player2 = this.player;
                    controlDispatcher2.dispatchSetPlayWhenReady(player2, !player2.getPlayWhenReady());
                } else if (keyCode == 87) {
                    next(this.player);
                } else if (keyCode == 88) {
                    previous(this.player);
                } else if (keyCode == 126) {
                    this.controlDispatcher.dispatchSetPlayWhenReady(this.player, true);
                } else if (keyCode == 127) {
                    this.controlDispatcher.dispatchSetPlayWhenReady(this.player, false);
                }
            }
        }
        return true;
    }

    private boolean isPlaying() {
        Player player2 = this.player;
        if (player2 == null || player2.getPlaybackState() == 4 || this.player.getPlaybackState() == 1 || !this.player.getPlayWhenReady()) {
            return false;
        }
        return true;
    }

    private static boolean canShowMultiWindowTimeBar(Timeline timeline, Timeline.Window window2) {
        if (timeline.getWindowCount() > 100) {
            return false;
        }
        int windowCount = timeline.getWindowCount();
        for (int i = 0; i < windowCount; i++) {
            if (timeline.getWindow(i, window2).durationUs == C1119C.TIME_UNSET) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlayerControlView$ComponentListener */
    private final class ComponentListener implements Player.EventListener, TimeBar.OnScrubListener, View.OnClickListener {
        public /* synthetic */ void onLoadingChanged(boolean z) {
            Player.EventListener.CC.$default$onLoadingChanged(this, z);
        }

        public /* synthetic */ void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            Player.EventListener.CC.$default$onPlaybackParametersChanged(this, playbackParameters);
        }

        public /* synthetic */ void onPlayerError(ExoPlaybackException exoPlaybackException) {
            Player.EventListener.CC.$default$onPlayerError(this, exoPlaybackException);
        }

        public /* synthetic */ void onSeekProcessed() {
            Player.EventListener.CC.$default$onSeekProcessed(this);
        }

        public /* synthetic */ void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            Player.EventListener.CC.$default$onTracksChanged(this, trackGroupArray, trackSelectionArray);
        }

        private ComponentListener() {
        }

        public void onScrubStart(TimeBar timeBar, long j) {
            boolean unused = PlayerControlView.this.scrubbing = true;
            if (PlayerControlView.this.positionView != null) {
                PlayerControlView.this.positionView.setText(Util.getStringForTime(PlayerControlView.this.formatBuilder, PlayerControlView.this.formatter, j));
            }
        }

        public void onScrubMove(TimeBar timeBar, long j) {
            if (PlayerControlView.this.positionView != null) {
                PlayerControlView.this.positionView.setText(Util.getStringForTime(PlayerControlView.this.formatBuilder, PlayerControlView.this.formatter, j));
            }
        }

        public void onScrubStop(TimeBar timeBar, long j, boolean z) {
            boolean unused = PlayerControlView.this.scrubbing = false;
            if (!z && PlayerControlView.this.player != null) {
                PlayerControlView playerControlView = PlayerControlView.this;
                playerControlView.seekToTimeBarPosition(playerControlView.player, j);
            }
        }

        public void onPlayerStateChanged(boolean z, int i) {
            PlayerControlView.this.updatePlayPauseButton();
            PlayerControlView.this.updateProgress();
        }

        public void onRepeatModeChanged(int i) {
            PlayerControlView.this.updateRepeatModeButton();
            PlayerControlView.this.updateNavigation();
        }

        public void onShuffleModeEnabledChanged(boolean z) {
            PlayerControlView.this.updateShuffleButton();
            PlayerControlView.this.updateNavigation();
        }

        public void onPositionDiscontinuity(int i) {
            PlayerControlView.this.updateNavigation();
            PlayerControlView.this.updateTimeline();
        }

        public void onTimelineChanged(Timeline timeline, @Nullable Object obj, int i) {
            PlayerControlView.this.updateNavigation();
            PlayerControlView.this.updateTimeline();
        }

        public void onClick(View view) {
            Player access$500 = PlayerControlView.this.player;
            if (access$500 != null) {
                if (PlayerControlView.this.nextButton == view) {
                    PlayerControlView.this.next(access$500);
                } else if (PlayerControlView.this.previousButton == view) {
                    PlayerControlView.this.previous(access$500);
                } else if (PlayerControlView.this.fastForwardButton == view) {
                    PlayerControlView.this.fastForward(access$500);
                } else if (PlayerControlView.this.rewindButton == view) {
                    PlayerControlView.this.rewind(access$500);
                } else if (PlayerControlView.this.playButton == view) {
                    if (access$500.getPlaybackState() == 1) {
                        if (PlayerControlView.this.playbackPreparer != null) {
                            PlayerControlView.this.playbackPreparer.preparePlayback();
                        }
                    } else if (access$500.getPlaybackState() == 4) {
                        PlayerControlView.this.controlDispatcher.dispatchSeekTo(access$500, access$500.getCurrentWindowIndex(), C1119C.TIME_UNSET);
                    }
                    PlayerControlView.this.controlDispatcher.dispatchSetPlayWhenReady(access$500, true);
                } else if (PlayerControlView.this.pauseButton == view) {
                    PlayerControlView.this.controlDispatcher.dispatchSetPlayWhenReady(access$500, false);
                } else if (PlayerControlView.this.repeatToggleButton == view) {
                    PlayerControlView.this.controlDispatcher.dispatchSetRepeatMode(access$500, RepeatModeUtil.getNextRepeatMode(access$500.getRepeatMode(), PlayerControlView.this.repeatToggleModes));
                } else if (PlayerControlView.this.shuffleButton == view) {
                    PlayerControlView.this.controlDispatcher.dispatchSetShuffleModeEnabled(access$500, !access$500.getShuffleModeEnabled());
                }
            }
        }
    }
}
