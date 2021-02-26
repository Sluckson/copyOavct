package com.wowza.gocoder.sdk.api.broadcast;

import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.api.configuration.WOWZStreamConfig;
import com.wowza.gocoder.sdk.api.data.WOWZDataMap;
import com.wowza.gocoder.sdk.api.errors.WOWZStreamingError;
import com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI;
import com.wowza.gocoder.sdk.support.p037d.C4280a;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: GoCoderSDK */
public class WOWZBroadcastConfig extends WOWZStreamConfig {

    /* renamed from: a */
    private ArrayList<WOWZSinkAPI.VideoSink> f3566a;

    /* renamed from: b */
    private ArrayList<WOWZSinkAPI.AudioSink> f3567b;

    /* renamed from: c */
    private WOWZBroadcastAPI.BroadcastErrorCallback f3568c;

    /* renamed from: d */
    private C4280a f3569d;
    protected WOWZBroadcastAPI.AudioBroadcaster mAudioBroadcaster;
    protected int mOrientationBehavior;
    protected WOWZBroadcastAPI.VideoBroadcaster mVideoBroadcaster;
    protected WOWZMediaConfig mVideoSourceConfig;

    public WOWZBroadcastConfig() {
        this.mVideoBroadcaster = null;
        this.mAudioBroadcaster = null;
        this.f3566a = new ArrayList<>();
        this.f3567b = new ArrayList<>();
        this.f3568c = null;
        this.f3569d = null;
        this.mVideoSourceConfig = new WOWZMediaConfig();
        this.mOrientationBehavior = 3;
    }

    public WOWZBroadcastConfig(WOWZBroadcastConfig wOWZBroadcastConfig) {
        this();
        set(wOWZBroadcastConfig);
    }

    public WOWZBroadcastConfig(WOWZMediaConfig wOWZMediaConfig) {
        this();
        set(wOWZMediaConfig);
    }

    public void set(WOWZBroadcastConfig wOWZBroadcastConfig) {
        if (wOWZBroadcastConfig != null) {
            super.set((WOWZStreamConfig) wOWZBroadcastConfig);
            this.mVideoBroadcaster = wOWZBroadcastConfig.getVideoBroadcaster();
            this.mAudioBroadcaster = wOWZBroadcastConfig.getAudioBroadcaster();
            this.f3568c = wOWZBroadcastConfig.getErrorCallback();
            this.f3569d = wOWZBroadcastConfig.f3569d;
            this.f3566a.clear();
            Iterator<WOWZSinkAPI.VideoSink> it = wOWZBroadcastConfig.f3566a.iterator();
            while (it.hasNext()) {
                this.f3566a.add(it.next());
            }
            this.f3567b.clear();
            Iterator<WOWZSinkAPI.AudioSink> it2 = wOWZBroadcastConfig.f3567b.iterator();
            while (it2.hasNext()) {
                this.f3567b.add(it2.next());
            }
            this.mVideoSourceConfig.set(wOWZBroadcastConfig.getVideoSourceConfig());
            this.mOrientationBehavior = wOWZBroadcastConfig.getOrientationBehavior();
        }
    }

    public void set(WOWZMediaConfig wOWZMediaConfig) {
        if (wOWZMediaConfig != null) {
            super.set(wOWZMediaConfig);
        }
    }

    public WOWZBroadcastAPI.VideoBroadcaster getVideoBroadcaster() {
        return this.mVideoBroadcaster;
    }

    public void setVideoBroadcaster(WOWZBroadcastAPI.VideoBroadcaster videoBroadcaster) {
        this.mVideoBroadcaster = videoBroadcaster;
    }

    public WOWZBroadcastAPI.AudioBroadcaster getAudioBroadcaster() {
        return this.mAudioBroadcaster;
    }

    public void setAudioBroadcaster(WOWZBroadcastAPI.AudioBroadcaster audioBroadcaster) {
        this.mAudioBroadcaster = audioBroadcaster;
    }

    public WOWZSinkAPI.VideoSink[] getVideoSinks() {
        ArrayList<WOWZSinkAPI.VideoSink> arrayList = this.f3566a;
        return (WOWZSinkAPI.VideoSink[]) arrayList.toArray(new WOWZSinkAPI.VideoSink[arrayList.size()]);
    }

    public WOWZSinkAPI.AudioSink[] getAudioSinks() {
        ArrayList<WOWZSinkAPI.AudioSink> arrayList = this.f3567b;
        return (WOWZSinkAPI.AudioSink[]) arrayList.toArray(new WOWZSinkAPI.AudioSink[arrayList.size()]);
    }

    public WOWZBroadcastAPI.BroadcastErrorCallback getErrorCallback() {
        return this.f3568c;
    }

    /* access modifiers changed from: protected */
    public void setErrorCallback(WOWZBroadcastAPI.BroadcastErrorCallback broadcastErrorCallback) {
        this.f3568c = broadcastErrorCallback;
    }

    public C4280a getStreamingMonitor() {
        return this.f3569d;
    }

    /* access modifiers changed from: protected */
    public void setStreamingMonitor(C4280a aVar) {
        this.f3569d = aVar;
    }

    public WOWZMediaConfig getVideoSourceConfig() {
        return this.mVideoSourceConfig;
    }

    public void setVideoSourceConfig(WOWZMediaConfig wOWZMediaConfig) {
        this.mVideoSourceConfig.set(wOWZMediaConfig);
    }

    public void setOrientationBehavior(int i) {
        this.mOrientationBehavior = i;
    }

    public int getOrientationBehavior() {
        return this.mOrientationBehavior;
    }

    public WOWZStreamingError validateForBroadcast() {
        int i;
        if (!this.mVideoEnabled || getVideoBroadcaster() != null) {
            i = (!this.mAudioEnabled || getAudioBroadcaster() != null) ? 0 : 18;
        } else {
            i = 17;
        }
        return i == 0 ? super.validateForBroadcast() : new WOWZStreamingError(i);
    }

    public void registerVideoSink(WOWZSinkAPI.VideoSink videoSink) {
        if (!this.f3566a.contains(videoSink)) {
            this.f3566a.add(0, videoSink);
        }
    }

    public void unregisterVideoSink(WOWZSinkAPI.VideoSink videoSink) {
        if (this.f3566a.contains(videoSink)) {
            this.f3566a.remove(videoSink);
        }
    }

    public void registerAudioSink(WOWZSinkAPI.AudioSink audioSink) {
        if (!this.f3567b.contains(audioSink)) {
            this.f3567b.add(0, audioSink);
        }
    }

    public void unregisterAudioSink(WOWZSinkAPI.AudioSink audioSink) {
        if (this.f3567b.contains(audioSink)) {
            this.f3567b.remove(audioSink);
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.toString());
        StringBuilder sb = new StringBuilder();
        sb.append("\n\nVideo broadcaster (class) : ");
        WOWZBroadcastAPI.VideoBroadcaster videoBroadcaster = this.mVideoBroadcaster;
        String str = "null";
        sb.append(videoBroadcaster == null ? str : videoBroadcaster.getClass().getSimpleName());
        stringBuffer.append(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\nAudio broadcaster (class) : ");
        WOWZBroadcastAPI.AudioBroadcaster audioBroadcaster = this.mAudioBroadcaster;
        if (audioBroadcaster != null) {
            str = audioBroadcaster.getClass().getSimpleName();
        }
        sb2.append(str);
        stringBuffer.append(sb2.toString());
        Iterator<WOWZSinkAPI.VideoSink> it = this.f3566a.iterator();
        while (it.hasNext()) {
            stringBuffer.append("\nVideo sink (class)       : " + it.next().getClass().getSimpleName());
        }
        Iterator<WOWZSinkAPI.AudioSink> it2 = this.f3567b.iterator();
        while (it2.hasNext()) {
            stringBuffer.append("\nAudio sink (class)       : " + it2.next().getClass().getSimpleName());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("\nBroadcast orientation    : ");
        int i = this.mOrientationBehavior;
        sb3.append(i == 2 ? "portrait" : i == 1 ? "landscape" : "same as source");
        stringBuffer.append(sb3.toString());
        stringBuffer.append("\nVideo source config :\n");
        stringBuffer.append(this.mVideoSourceConfig.toString());
        return stringBuffer.toString();
    }

    public WOWZDataMap toDataMap(WOWZDataMap wOWZDataMap) {
        super.toDataMap(wOWZDataMap);
        int i = this.mOrientationBehavior;
        wOWZDataMap.put("broadcastOrientationBehavior", i == 2 ? "alwaysPortrait" : i == 1 ? "alwaysLandscape" : "sameAsSource");
        return wOWZDataMap;
    }
}
