package com.wowza.gocoder.sdk.support.p035b;

import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastAPI;
import com.wowza.gocoder.sdk.api.broadcast.WOWZBroadcastConfig;
import com.wowza.gocoder.sdk.api.errors.WOWZError;
import com.wowza.gocoder.sdk.api.errors.WOWZStreamingError;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.sink.WOWZSinkAPI;
import com.wowza.gocoder.sdk.api.status.WOWZState;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* renamed from: com.wowza.gocoder.sdk.support.b.b */
/* compiled from: GoCoderSDK */
public class C4273b {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f4064a = "b";

    /* renamed from: b */
    private static final int f4065b = 1;

    /* renamed from: c */
    private static final int f4066c = 2;

    /* renamed from: d */
    private static final int f4067d = 3;

    /* renamed from: a */
    private static String m3779a(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "(unknown stage)" : "END_BROADCAST" : "START_BROADCAST" : "PREPARE_FOR_BROADCAST";
    }

    /* renamed from: a */
    public static WOWZStatus m3777a(WOWZBroadcastConfig wOWZBroadcastConfig) {
        WOWZStatus wOWZStatus = new WOWZStatus(1);
        ArrayList<WOWZBroadcastAPI.Broadcaster> d = m3782d(wOWZBroadcastConfig);
        ArrayList<WOWZBroadcastAPI.Broadcaster> e = m3783e(wOWZBroadcastConfig);
        WOWZError a = m3776a(1, wOWZBroadcastConfig, d);
        if (a == null) {
            a = m3776a(1, wOWZBroadcastConfig, e);
        }
        if (a == null) {
            wOWZStatus.setState(2);
        } else {
            wOWZStatus.set(0, a);
        }
        return wOWZStatus;
    }

    /* renamed from: b */
    public static WOWZStatus m3780b(WOWZBroadcastConfig wOWZBroadcastConfig) {
        WOWZStatus wOWZStatus = new WOWZStatus(1);
        ArrayList<WOWZBroadcastAPI.Broadcaster> d = m3782d(wOWZBroadcastConfig);
        ArrayList<WOWZBroadcastAPI.Broadcaster> e = m3783e(wOWZBroadcastConfig);
        WOWZError a = m3776a(2, wOWZBroadcastConfig, d);
        if (a == null) {
            WOWZLog.debug("***** [FPS]BroadcastManager " + wOWZBroadcastConfig.getVideoFramerate());
            a = m3776a(2, wOWZBroadcastConfig, e);
        } else {
            wOWZStatus.setError(a);
        }
        if (a == null) {
            wOWZStatus.setState(3);
        } else {
            wOWZStatus.set(0, a);
        }
        return wOWZStatus;
    }

    /* renamed from: d */
    private static ArrayList<WOWZBroadcastAPI.Broadcaster> m3782d(WOWZBroadcastConfig wOWZBroadcastConfig) {
        ArrayList<WOWZBroadcastAPI.Broadcaster> arrayList = new ArrayList<>();
        WOWZSinkAPI.AudioSink[] audioSinks = wOWZBroadcastConfig.getAudioSinks();
        if (wOWZBroadcastConfig.isVideoEnabled()) {
            WOWZSinkAPI.VideoSink[] videoSinks = wOWZBroadcastConfig.getVideoSinks();
            if (videoSinks.length > 0) {
                for (WOWZSinkAPI.VideoSink add : videoSinks) {
                    arrayList.add(add);
                }
            }
        }
        if (wOWZBroadcastConfig.isAudioEnabled() && audioSinks.length > 0) {
            for (int i = 0; i < audioSinks.length; i++) {
                if (!arrayList.contains(audioSinks[i])) {
                    arrayList.add(audioSinks[i]);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    private static ArrayList<WOWZBroadcastAPI.Broadcaster> m3783e(WOWZBroadcastConfig wOWZBroadcastConfig) {
        ArrayList<WOWZBroadcastAPI.Broadcaster> arrayList = new ArrayList<>();
        if (wOWZBroadcastConfig.isVideoEnabled() && wOWZBroadcastConfig.getVideoBroadcaster() != null && !arrayList.contains(wOWZBroadcastConfig.getVideoBroadcaster())) {
            arrayList.add(wOWZBroadcastConfig.getVideoBroadcaster());
        }
        if (wOWZBroadcastConfig.isAudioEnabled() && wOWZBroadcastConfig.getAudioBroadcaster() != null && !arrayList.contains(wOWZBroadcastConfig.getAudioBroadcaster())) {
            arrayList.add(wOWZBroadcastConfig.getAudioBroadcaster());
        }
        return arrayList;
    }

    /* renamed from: c */
    public static WOWZStatus m3781c(WOWZBroadcastConfig wOWZBroadcastConfig) {
        WOWZStatus wOWZStatus = new WOWZStatus(4);
        ArrayList<WOWZBroadcastAPI.Broadcaster> d = m3782d(wOWZBroadcastConfig);
        ArrayList<WOWZBroadcastAPI.Broadcaster> e = m3783e(wOWZBroadcastConfig);
        if (e != null) {
            m3776a(3, wOWZBroadcastConfig, e);
        }
        m3776a(3, wOWZBroadcastConfig, d);
        wOWZStatus.setState(0);
        return wOWZStatus;
    }

    /* renamed from: a */
    private static WOWZError m3776a(final int i, final WOWZBroadcastConfig wOWZBroadcastConfig, ArrayList<WOWZBroadcastAPI.Broadcaster> arrayList) {
        WOWZStreamingError wOWZStreamingError;
        WOWZStatus wOWZStatus;
        String str = f4064a;
        WOWZLog.debug(str, "Broadcast stage: " + m3779a(i));
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(arrayList.size());
        ExecutorCompletionService executorCompletionService = new ExecutorCompletionService(newFixedThreadPool);
        Iterator<WOWZBroadcastAPI.Broadcaster> it = arrayList.iterator();
        while (it.hasNext()) {
            final WOWZBroadcastAPI.Broadcaster next = it.next();
            executorCompletionService.submit(new Callable<WOWZStatus>() {
                /* renamed from: a */
                public WOWZStatus call() throws Exception {
                    int i = i;
                    if (i == 1) {
                        String a = C4273b.f4064a;
                        WOWZLog.debug(a, "Transitioning " + next.getClass().getSimpleName() + " from " + WOWZState.toLabel(0) + " to " + WOWZState.toLabel(2));
                        if (next.getBroadcasterStatus().getState() != 0) {
                            WOWZLog.debug("***** [FPS]BroadcastManager2a " + wOWZBroadcastConfig.getVideoFramerate());
                            String a2 = C4273b.f4064a;
                            WOWZLog.warn(a2, next.getClass().getSimpleName() + " was in an unexpected state. Expected: " + WOWZState.toLabel(0) + ", Actual: " + WOWZState.toLabel(next.getBroadcasterStatus().getState()));
                            return new WOWZStatus(next.getBroadcasterStatus().getState(), new WOWZStreamingError(33));
                        }
                        WOWZLog.debug("***** [FPS]BroadcastManager2b " + wOWZBroadcastConfig.getVideoFramerate());
                        return next.prepareForBroadcast(wOWZBroadcastConfig);
                    } else if (i != 2) {
                        if (i == 3) {
                            if (next.getBroadcasterStatus().getState() == 3 || next.getBroadcasterStatus().getState() == 5 || next.getBroadcasterStatus().getState() == 2) {
                                return next.stopBroadcasting();
                            }
                            String a3 = C4273b.f4064a;
                            WOWZLog.warn(a3, next.getClass().getSimpleName() + " was not running, paused, or ready at broadcast teardown. It was in a " + WOWZState.toLabel(next.getBroadcasterStatus().getState()) + " state");
                        }
                        return null;
                    } else {
                        String a4 = C4273b.f4064a;
                        WOWZLog.debug(a4, "Transitioning " + next.getClass().getSimpleName() + " from " + WOWZState.toLabel(2) + " to " + WOWZState.toLabel(3));
                        if (next.getBroadcasterStatus().getState() != 2) {
                            WOWZLog.debug("***** [FPS]BroadcastManager3a " + wOWZBroadcastConfig.getVideoFramerate());
                            String a5 = C4273b.f4064a;
                            WOWZLog.warn(a5, next.getClass().getSimpleName() + " was in an unexpected state. Expected: " + WOWZState.toLabel(2) + ", Actual: " + WOWZState.toLabel(next.getBroadcasterStatus().getState()));
                            return new WOWZStatus(next.getBroadcasterStatus().getState(), new WOWZStreamingError(33));
                        }
                        WOWZLog.debug("***** [FPS]BroadcastManager3b " + wOWZBroadcastConfig.getVideoFramerate());
                        return next.startBroadcasting();
                    }
                }
            });
        }
        int i2 = 0;
        WOWZError wOWZError = null;
        while (true) {
            if (i2 >= arrayList.size()) {
                break;
            }
            try {
                Future take = executorCompletionService.take();
                if (!(take == null || (wOWZStatus = (WOWZStatus) take.get()) == null || wOWZStatus.getLastError() == null)) {
                    wOWZError = wOWZStatus.getLastError();
                    String str2 = f4064a;
                    WOWZLog.error(str2, "A broadcast component reported the following error during the " + m3779a(i) + " transition\n" + wOWZError.toString());
                    break;
                }
            } catch (ExecutionException e) {
                wOWZStreamingError = new WOWZStreamingError(34);
                WOWZLog.error(f4064a, "An ExecutionException exception occurred waiting on a broadcast component", (Throwable) e);
                wOWZError = wOWZStreamingError;
                i2++;
            } catch (InterruptedException e2) {
                wOWZStreamingError = new WOWZStreamingError(34);
                WOWZLog.error(f4064a, "An InterruptedException exception occurred waiting on a broadcast component", (Throwable) e2);
                wOWZError = wOWZStreamingError;
                i2++;
            }
            i2++;
        }
        newFixedThreadPool.shutdown();
        return wOWZError;
    }
}
