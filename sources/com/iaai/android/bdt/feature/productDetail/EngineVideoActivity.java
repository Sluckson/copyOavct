package com.iaai.android.bdt.feature.productDetail;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.p009ui.PlayerView;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSourceFactory;
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.google.android.exoplayer2.util.Util;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.utils.Constants_MVVM;
import java.io.File;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 42\u00020\u00012\u00020\u0002:\u00014B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0012\u0010\r\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\tH\u0014J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\tH\u0014J\u0012\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u001eH\u0016J\b\u0010#\u001a\u00020\tH\u0014J\b\u0010$\u001a\u00020\tH\u0016J\u0010\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\u0013H\u0016J$\u0010'\u001a\u00020\t2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010 \u001a\u00020\u001eH\u0016J\u001c\u0010,\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010.2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\tH\u0002J\b\u00102\u001a\u00020\tH\u0002J\b\u00103\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/EngineVideoActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/exoplayer2/Player$EventListener;", "()V", "engineVideoUrl", "", "player", "Lcom/google/android/exoplayer2/SimpleExoPlayer;", "buildMediaSource", "", "mUri", "Landroid/net/Uri;", "initializePlayer", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLoadingChanged", "isLoading", "", "onPause", "onPlaybackParametersChanged", "playbackParameters", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "error", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "playWhenReady", "playbackState", "", "onPositionDiscontinuity", "reason", "onRepeatModeChanged", "repeatMode", "onRestart", "onSeekProcessed", "onShuffleModeEnabledChanged", "shuffleModeEnabled", "onTimelineChanged", "timeline", "Lcom/google/android/exoplayer2/Timeline;", "manifest", "", "onTracksChanged", "trackGroups", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "trackSelections", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "pausePlayer", "releasePlayer", "resumePlayer", "Companion", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: EngineVideoActivity.kt */
public final class EngineVideoActivity extends AppCompatActivity implements Player.EventListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long MAX_PREVIEW_CACHE_SIZE_IN_BYTES = 20971520;
    /* access modifiers changed from: private */
    @Nullable
    public static Cache cache;
    private HashMap _$_findViewCache;
    private String engineVideoUrl = "";
    private SimpleExoPlayer player;

    @JvmStatic
    @NotNull
    public static final String getUserAgent(@NotNull Context context) {
        return Companion.getUserAgent(context);
    }

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

    public void onLoadingChanged(boolean z) {
    }

    public void onPlaybackParametersChanged(@Nullable PlaybackParameters playbackParameters) {
    }

    public void onPlayerError(@Nullable ExoPlaybackException exoPlaybackException) {
    }

    public void onPositionDiscontinuity(int i) {
    }

    public void onRepeatModeChanged(int i) {
    }

    public void onSeekProcessed() {
    }

    public void onShuffleModeEnabledChanged(boolean z) {
    }

    public void onTimelineChanged(@Nullable Timeline timeline, @Nullable Object obj, int i) {
    }

    public void onTracksChanged(@Nullable TrackGroupArray trackGroupArray, @Nullable TrackSelectionArray trackSelectionArray) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView((int) C2723R.C2728layout.activity_engine_video);
        String stringExtra = getIntent().getStringExtra(Constants_MVVM.EXTRA_ENGINE_VIDEO_URL);
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "intent.getStringExtra(Co…M.EXTRA_ENGINE_VIDEO_URL)");
        this.engineVideoUrl = stringExtra;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.hide();
        }
        if (cache == null) {
            cache = new SimpleCache(new File(getCacheDir(), "media"), new LeastRecentlyUsedCacheEvictor(MAX_PREVIEW_CACHE_SIZE_IN_BYTES));
        }
        initializePlayer();
        ((ImageButton) _$_findCachedViewById(C2723R.C2726id.ibEngineVideoClose)).setOnClickListener(new EngineVideoActivity$onCreate$1(this));
    }

    private final void initializePlayer() {
        if (this.player == null) {
            this.player = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector());
            SimpleExoPlayer simpleExoPlayer = this.player;
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setVolume(1.0f);
            }
            Uri parse = Uri.parse(this.engineVideoUrl);
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(engineVideoUrl)");
            buildMediaSource(parse);
            PlayerView playerView = (PlayerView) _$_findCachedViewById(C2723R.C2726id.pvEngineVideo);
            Intrinsics.checkExpressionValueIsNotNull(playerView, "pvEngineVideo");
            playerView.setPlayer(this.player);
        }
    }

    private final void buildMediaSource(Uri uri) {
        DataSource.Factory factory;
        Cache cache2 = cache;
        if (cache2 != null) {
            factory = new CacheDataSourceFactory(cache2, new DefaultHttpDataSourceFactory(Companion.getUserAgent(this)));
        } else {
            Context context = this;
            factory = new DefaultDataSourceFactory(context, Companion.getUserAgent(context));
        }
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.addListener(this);
        }
        ExtractorMediaSource createMediaSource = new ExtractorMediaSource.Factory(factory).createMediaSource(uri);
        SimpleExoPlayer simpleExoPlayer2 = this.player;
        if (simpleExoPlayer2 != null) {
            simpleExoPlayer2.prepare(createMediaSource);
        }
        SimpleExoPlayer simpleExoPlayer3 = this.player;
        if (simpleExoPlayer3 != null) {
            simpleExoPlayer3.setPlayWhenReady(true);
        }
    }

    private final void releasePlayer() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            if (simpleExoPlayer != null) {
                simpleExoPlayer.release();
            }
            this.player = null;
        }
    }

    private final void pausePlayer() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setPlayWhenReady(false);
            }
            SimpleExoPlayer simpleExoPlayer2 = this.player;
            if (simpleExoPlayer2 != null) {
                simpleExoPlayer2.getPlaybackState();
            }
        }
    }

    private final void resumePlayer() {
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            if (simpleExoPlayer != null) {
                simpleExoPlayer.setPlayWhenReady(true);
            }
            SimpleExoPlayer simpleExoPlayer2 = this.player;
            if (simpleExoPlayer2 != null) {
                simpleExoPlayer2.getPlaybackState();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        pausePlayer();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        resumePlayer();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        releasePlayer();
    }

    public void onPlayerStateChanged(boolean z, int i) {
        if (i == 2) {
            ProgressBar progressBar = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbEngineVideo);
            Intrinsics.checkExpressionValueIsNotNull(progressBar, "pbEngineVideo");
            progressBar.setVisibility(0);
        } else if (i == 3) {
            ProgressBar progressBar2 = (ProgressBar) _$_findCachedViewById(C2723R.C2726id.pbEngineVideo);
            Intrinsics.checkExpressionValueIsNotNull(progressBar2, "pbEngineVideo");
            progressBar2.setVisibility(8);
        }
    }

    @Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/EngineVideoActivity$Companion;", "", "()V", "MAX_PREVIEW_CACHE_SIZE_IN_BYTES", "", "cache", "Lcom/google/android/exoplayer2/upstream/cache/Cache;", "getCache", "()Lcom/google/android/exoplayer2/upstream/cache/Cache;", "setCache", "(Lcom/google/android/exoplayer2/upstream/cache/Cache;)V", "getUserAgent", "", "context", "Landroid/content/Context;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
    /* compiled from: EngineVideoActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final Cache getCache() {
            return EngineVideoActivity.cache;
        }

        public final void setCache(@Nullable Cache cache) {
            EngineVideoActivity.cache = cache;
        }

        @JvmStatic
        @NotNull
        public final String getUserAgent(@NotNull Context context) {
            Intrinsics.checkParameterIsNotNull(context, "context");
            PackageManager packageManager = context.getPackageManager();
            String userAgent = Util.getUserAgent(context, packageManager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(packageManager).toString());
            Intrinsics.checkExpressionValueIsNotNull(userAgent, "Util.getUserAgent(context, appName)");
            return userAgent;
        }
    }
}
