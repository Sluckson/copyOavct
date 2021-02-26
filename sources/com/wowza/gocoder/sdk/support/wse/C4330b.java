package com.wowza.gocoder.sdk.support.wse;

import com.lowagie.text.html.HtmlTags;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig;
import com.wowza.gocoder.sdk.api.configuration.WOWZStreamConfig;
import com.wowza.gocoder.sdk.api.data.WOWZDataEvent;
import com.wowza.gocoder.sdk.api.data.WOWZDataItem;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.data.WOWZDataScope;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.player.WOWZPlayerAPI;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import com.wowza.gocoder.sdk.support.licensing.LicenseManager;

/* renamed from: com.wowza.gocoder.sdk.support.wse.b */
/* compiled from: GoCoderSDK */
public final class C4330b extends C4329a implements WOWZDataEvent.EventListener {

    /* renamed from: h */
    private static final String f4683h = "b";

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59605a(int i) {
        super.mo59605a(i);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59606a(WOWZDataEvent.ResultCallback resultCallback) {
        super.mo59606a(resultCallback);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59607a(WOWZDataScope wOWZDataScope, String str, WOWZDataMap wOWZDataMap, WOWZDataEvent.ResultCallback resultCallback) {
        super.mo59607a(wOWZDataScope, str, wOWZDataMap, resultCallback);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo59608a(String str, WOWZDataEvent.EventListener eventListener) {
        super.mo59608a(str, eventListener);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ int mo59610b() {
        return super.mo59610b();
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo59611b(String str, WOWZDataEvent.EventListener eventListener) {
        super.mo59611b(str, eventListener);
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ WOWZStatus mo59613d() {
        return super.mo59613d();
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ WOWZBroadcastConfig mo59614e() {
        return super.mo59614e();
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ void mo59615f() {
        super.mo59615f();
    }

    public /* bridge */ /* synthetic */ boolean isAudioEnabled() {
        return super.isAudioEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isAudioPaused() {
        return super.isAudioPaused();
    }

    public /* bridge */ /* synthetic */ boolean isVideoEnabled() {
        return super.isVideoEnabled();
    }

    public /* bridge */ /* synthetic */ boolean isVideoPaused() {
        return super.isVideoPaused();
    }

    public /* bridge */ /* synthetic */ void setAudioEnabled(boolean z) {
        super.setAudioEnabled(z);
    }

    public /* bridge */ /* synthetic */ void setAudioPaused(boolean z) {
        super.setAudioPaused(z);
    }

    public /* bridge */ /* synthetic */ void setVideoEnabled(boolean z) {
        super.setVideoEnabled(z);
    }

    public /* bridge */ /* synthetic */ void setVideoPaused(boolean z) {
        super.setVideoPaused(z);
    }

    public C4330b() {
        this.f4675a.mo59640a("onStatus", (WOWZDataEvent.EventListener) this);
    }

    /* renamed from: a */
    public WOWZStatus mo59624a(WOWZStreamConfig wOWZStreamConfig, long j, WOWZPlayerAPI.WZVideoStreamReceiver wZVideoStreamReceiver, WOWZPlayerAPI.WZAudioStreamReceiver wZAudioStreamReceiver) {
        if (!LicenseManager.getInstance().canDoPlayback()) {
            WOWZLog.debug(f4683h, "Does not have a valid license type for playback.");
            this.f4677c.setError(new WOWZError("Invalid license type."));
            this.f4677c.setState(0);
            WOWZLog.error(f4683h, this.f4677c.getLastError());
            return this.f4677c;
        }
        this.f4677c.clearLastError();
        this.f4677c.setState(1);
        this.f4676b.set(wOWZStreamConfig);
        this.f4675a.mo59637a(this.f4676b);
        mo59609a(false);
        if (this.f4675a.mo59630a(1, j, wZVideoStreamReceiver, wZAudioStreamReceiver) == 1) {
            this.f4677c.setError(this.f4675a.mo59635a(true));
            this.f4677c.setState(0);
            WOWZLog.error(f4683h, this.f4677c.getLastError());
        } else {
            mo59609a(true);
            this.f4677c.setState(2);
        }
        return this.f4677c;
    }

    /* renamed from: a */
    public WOWZStatus mo59625a(WOWZPlayerAPI.WZVideoStreamReceiver wZVideoStreamReceiver, WOWZPlayerAPI.WZAudioStreamReceiver wZAudioStreamReceiver) {
        int b;
        int state;
        if (this.f4675a.mo59658h()) {
            this.f4677c.clearLastError();
            this.f4677c.setState(3);
            do {
                b = this.f4675a.mo59644b(wZVideoStreamReceiver, wZAudioStreamReceiver);
                int m = this.f4675a.mo59663m();
                state = this.f4677c.getState();
                if (!(b == 0 && m == 400)) {
                }
            } while (state == 3);
            if (this.f4677c.isStopping()) {
                this.f4677c.clearLastError();
            } else if (b != 0) {
                this.f4677c.setError(this.f4675a.mo59648c());
            }
            this.f4675a.mo59661k();
            mo59609a(false);
            this.f4677c.setState(0);
        }
        return this.f4677c;
    }

    /* renamed from: g */
    public WOWZStatus mo59626g() {
        this.f4677c.setAndWaitForState(4, 0);
        return this.f4677c;
    }

    /* renamed from: h */
    public WOWZDataMap mo59627h() {
        return this.f4675a.mo59664n();
    }

    public WOWZDataMap onWZDataEvent(String str, WOWZDataMap wOWZDataMap) {
        WOWZDataItem wOWZDataItem;
        if (!str.equals("onStatus") || wOWZDataMap == null || !wOWZDataMap.containsKey(HtmlTags.CODE) || (wOWZDataItem = (WOWZDataItem) wOWZDataMap.get(HtmlTags.CODE)) == null || !wOWZDataItem.stringValue().equals("NetStream.Play.UnpublishNotify")) {
            return null;
        }
        this.f4677c.setState(4);
        return null;
    }
}
