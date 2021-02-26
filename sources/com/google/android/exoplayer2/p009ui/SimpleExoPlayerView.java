package com.google.android.exoplayer2.p009ui;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.SimpleExoPlayer;

@Deprecated
/* renamed from: com.google.android.exoplayer2.ui.SimpleExoPlayerView */
public final class SimpleExoPlayerView extends PlayerView {
    public SimpleExoPlayerView(Context context) {
        super(context);
    }

    public SimpleExoPlayerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SimpleExoPlayerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Deprecated
    public static void switchTargetView(@NonNull SimpleExoPlayer simpleExoPlayer, @Nullable SimpleExoPlayerView simpleExoPlayerView, @Nullable SimpleExoPlayerView simpleExoPlayerView2) {
        PlayerView.switchTargetView(simpleExoPlayer, simpleExoPlayerView, simpleExoPlayerView2);
    }
}
