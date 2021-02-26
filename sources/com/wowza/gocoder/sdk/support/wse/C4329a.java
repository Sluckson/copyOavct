package com.wowza.gocoder.sdk.support.wse;

import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig;
import com.wowza.gocoder.sdk.api.data.WOWZDataEvent;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.data.WOWZDataScope;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.wowza.gocoder.sdk.support.wse.a */
/* compiled from: GoCoderSDK */
abstract class C4329a {

    /* renamed from: h */
    private static final String f4674h = "a";

    /* renamed from: a */
    protected C4332d f4675a = new C4332d();

    /* renamed from: b */
    protected WOWZBroadcastConfig f4676b = new WOWZBroadcastConfig();

    /* renamed from: c */
    protected WOWZStatus f4677c = new WOWZStatus(0);

    /* renamed from: d */
    protected boolean f4678d = true;

    /* renamed from: e */
    protected boolean f4679e = false;

    /* renamed from: f */
    protected boolean f4680f = true;

    /* renamed from: g */
    protected boolean f4681g = false;

    /* renamed from: i */
    private final AtomicBoolean f4682i = new AtomicBoolean(false);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C4332d mo59604a() {
        return this.f4675a;
    }

    /* renamed from: a */
    public void mo59605a(int i) {
        this.f4675a.mo59636a(i);
    }

    /* renamed from: b */
    public int mo59610b() {
        return this.f4675a.mo59628a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo59612c() {
        return this.f4682i.get();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo59609a(boolean z) {
        this.f4682i.set(z);
    }

    /* renamed from: d */
    public WOWZStatus mo59613d() {
        return this.f4677c;
    }

    public boolean isVideoEnabled() {
        return this.f4678d;
    }

    public void setVideoEnabled(boolean z) {
        this.f4678d = z;
    }

    public boolean isVideoPaused() {
        return this.f4679e;
    }

    public void setVideoPaused(boolean z) {
        this.f4679e = z;
    }

    public boolean isAudioEnabled() {
        return this.f4680f;
    }

    public void setAudioEnabled(boolean z) {
        this.f4680f = z;
    }

    public boolean isAudioPaused() {
        return this.f4681g;
    }

    public void setAudioPaused(boolean z) {
        this.f4681g = z;
    }

    /* renamed from: e */
    public WOWZBroadcastConfig mo59614e() {
        return this.f4676b;
    }

    /* renamed from: a */
    public void mo59607a(WOWZDataScope wOWZDataScope, String str, WOWZDataMap wOWZDataMap, WOWZDataEvent.ResultCallback resultCallback) {
        if (mo59612c()) {
            this.f4675a.mo59639a(wOWZDataScope, str, wOWZDataMap, resultCallback);
        } else {
            WOWZLog.error(f4674h, "Attempt to send a client data event before the publish session is active");
        }
    }

    /* renamed from: a */
    public void mo59608a(String str, WOWZDataEvent.EventListener eventListener) {
        this.f4675a.mo59640a(str, eventListener);
    }

    /* renamed from: b */
    public void mo59611b(String str, WOWZDataEvent.EventListener eventListener) {
        this.f4675a.mo59646b(str, eventListener);
    }

    /* renamed from: f */
    public void mo59615f() {
        this.f4675a.mo59677y();
    }

    /* renamed from: a */
    public void mo59606a(WOWZDataEvent.ResultCallback resultCallback) {
        this.f4675a.mo59638a(resultCallback);
    }
}
