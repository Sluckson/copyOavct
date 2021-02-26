package com.wowza.gocoder.sdk.support.p029a.p034c;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.wowza.gocoder.sdk.api.geometry.WOWZSize;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;

/* renamed from: com.wowza.gocoder.sdk.support.a.c.a */
/* compiled from: GoCoderSDK */
public class C4271a extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a */
    private static final String f4011a = "a";

    /* renamed from: b */
    private Surface f4012b;

    /* renamed from: c */
    private int f4013c;

    /* renamed from: d */
    private WOWZSize f4014d;

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public C4271a(Context context) {
        super(context);
        m3754a();
    }

    /* renamed from: a */
    private void m3754a() {
        this.f4012b = null;
        this.f4013c = 1;
        this.f4014d = new WOWZSize(0, 0);
        getHolder().addCallback(this);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WOWZLog.debug("fdl.WOWZVideoView", "surfaceCreated: " + surfaceHolder.getSurfaceFrame().toString());
        this.f4012b = surfaceHolder.getSurface();
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f4012b = null;
    }

    public Surface getSurface() {
        return this.f4012b;
    }

    public int getScaleMode() {
        return this.f4013c;
    }

    public synchronized void setScaleMode(int i) {
        this.f4013c = i;
    }

    public WOWZSize getVideoFrameSize() {
        return new WOWZSize(this.f4014d);
    }

    public synchronized void setVideoFrameSize(WOWZSize wOWZSize) {
        this.f4014d.set(wOWZSize);
    }

    /* renamed from: a */
    public synchronized void mo59022a(int i, int i2) {
        this.f4014d.set(i, i2);
    }
}
