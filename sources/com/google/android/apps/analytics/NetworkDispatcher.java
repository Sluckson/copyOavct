package com.google.android.apps.analytics;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.google.android.apps.analytics.Dispatcher;
import com.google.android.apps.analytics.PipelinedRequester;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Locale;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.ParseException;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.protocol.HTTP;

class NetworkDispatcher implements Dispatcher {
    private static final String GOOGLE_ANALYTICS_HOST_NAME = "www.google-analytics.com";
    private static final int GOOGLE_ANALYTICS_HOST_PORT = 80;
    private static final int MAX_EVENTS_PER_PIPELINE = 30;
    private static final int MAX_GET_LENGTH = 2036;
    private static final int MAX_POST_LENGTH = 8192;
    private static final int MAX_SEQUENTIAL_REQUESTS = 5;
    private static final long MIN_RETRY_INTERVAL = 2;
    private static final String USER_AGENT_TEMPLATE = "%s/%s (Linux; U; Android %s; %s-%s; %s Build/%s)";
    private DispatcherThread dispatcherThread;
    private boolean dryRun;
    /* access modifiers changed from: private */
    public final HttpHost googleAnalyticsHost;
    private final String userAgent;

    private static class DispatcherThread extends HandlerThread {
        /* access modifiers changed from: private */
        public final Dispatcher.Callbacks callbacks;
        /* access modifiers changed from: private */
        public AsyncDispatchTask currentTask;
        volatile Handler handlerExecuteOnDispatcherThread;
        /* access modifiers changed from: private */
        public int lastStatusCode;
        /* access modifiers changed from: private */
        public int maxEventsPerRequest;
        /* access modifiers changed from: private */
        public final NetworkDispatcher parent;
        /* access modifiers changed from: private */
        public final PipelinedRequester pipelinedRequester;
        /* access modifiers changed from: private */
        public final RequesterCallbacks requesterCallBacks;
        /* access modifiers changed from: private */
        public long retryInterval;
        /* access modifiers changed from: private */
        public final String userAgent;

        private class AsyncDispatchTask implements Runnable {
            private final LinkedList<Hit> hits = new LinkedList<>();

            public AsyncDispatchTask(Hit[] hitArr) {
                Collections.addAll(this.hits, hitArr);
            }

            private void dispatchSomePendingHits(boolean z) throws IOException, ParseException, HttpException {
                String str;
                BasicHttpEntityEnclosingRequest basicHttpEntityEnclosingRequest;
                if (GoogleAnalyticsTracker.getInstance().getDebug() && z) {
                    Log.v(GoogleAnalyticsTracker.LOG_TAG, "dispatching hits in dry run mode");
                }
                int i = 0;
                while (i < this.hits.size() && i < DispatcherThread.this.maxEventsPerRequest) {
                    String addQueueTimeParameter = Utils.addQueueTimeParameter(this.hits.get(i).hitString, System.currentTimeMillis());
                    int indexOf = addQueueTimeParameter.indexOf(63);
                    String str2 = "";
                    if (indexOf < 0) {
                        str = addQueueTimeParameter;
                    } else {
                        str = indexOf > 0 ? addQueueTimeParameter.substring(0, indexOf) : str2;
                        if (indexOf < addQueueTimeParameter.length() - 2) {
                            str2 = addQueueTimeParameter.substring(indexOf + 1);
                        }
                    }
                    if (str2.length() < NetworkDispatcher.MAX_GET_LENGTH) {
                        basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("GET", addQueueTimeParameter);
                    } else {
                        basicHttpEntityEnclosingRequest = new BasicHttpEntityEnclosingRequest("POST", "/p" + str);
                        basicHttpEntityEnclosingRequest.addHeader("Content-Length", Integer.toString(str2.length()));
                        basicHttpEntityEnclosingRequest.addHeader("Content-Type", HTTP.PLAIN_TEXT_TYPE);
                        basicHttpEntityEnclosingRequest.setEntity(new StringEntity(str2));
                    }
                    String hostName = DispatcherThread.this.parent.googleAnalyticsHost.getHostName();
                    if (DispatcherThread.this.parent.googleAnalyticsHost.getPort() != 80) {
                        hostName = hostName + ":" + DispatcherThread.this.parent.googleAnalyticsHost.getPort();
                    }
                    basicHttpEntityEnclosingRequest.addHeader("Host", hostName);
                    basicHttpEntityEnclosingRequest.addHeader("User-Agent", DispatcherThread.this.userAgent);
                    if (GoogleAnalyticsTracker.getInstance().getDebug()) {
                        StringBuffer stringBuffer = new StringBuffer();
                        for (Header obj : basicHttpEntityEnclosingRequest.getAllHeaders()) {
                            stringBuffer.append(obj.toString());
                            stringBuffer.append("\n");
                        }
                        stringBuffer.append(basicHttpEntityEnclosingRequest.getRequestLine().toString());
                        stringBuffer.append("\n");
                        Log.i(GoogleAnalyticsTracker.LOG_TAG, stringBuffer.toString());
                    }
                    if (str2.length() > 8192) {
                        Log.w(GoogleAnalyticsTracker.LOG_TAG, "Hit too long (> 8192 bytes)--not sent");
                    } else if (!z) {
                        DispatcherThread.this.pipelinedRequester.addRequest(basicHttpEntityEnclosingRequest);
                        i++;
                    }
                    DispatcherThread.this.requesterCallBacks.requestSent();
                    i++;
                }
                if (!z) {
                    DispatcherThread.this.pipelinedRequester.sendRequests();
                }
            }

            public Hit removeNextHit() {
                return this.hits.poll();
            }

            public void run() {
                String str;
                AsyncDispatchTask unused = DispatcherThread.this.currentTask = this;
                int i = 0;
                while (i < 5 && this.hits.size() > 0) {
                    long j = 0;
                    try {
                        if (DispatcherThread.this.lastStatusCode != 500) {
                            if (DispatcherThread.this.lastStatusCode != 503) {
                                long unused2 = DispatcherThread.this.retryInterval = 2;
                                Thread.sleep(j * 1000);
                                dispatchSomePendingHits(DispatcherThread.this.parent.isDryRun());
                                i++;
                            }
                        }
                        j = (long) (Math.random() * ((double) DispatcherThread.this.retryInterval));
                        if (DispatcherThread.this.retryInterval < 256) {
                            DispatcherThread.access$630(DispatcherThread.this, 2);
                        }
                        Thread.sleep(j * 1000);
                        dispatchSomePendingHits(DispatcherThread.this.parent.isDryRun());
                        i++;
                    } catch (InterruptedException e) {
                        e = e;
                        str = "Couldn't sleep.";
                        Log.w(GoogleAnalyticsTracker.LOG_TAG, str, e);
                        DispatcherThread.this.pipelinedRequester.finishedCurrentRequests();
                        DispatcherThread.this.callbacks.dispatchFinished();
                        AsyncDispatchTask unused3 = DispatcherThread.this.currentTask = null;
                    } catch (IOException e2) {
                        e = e2;
                        str = "Problem with socket or streams.";
                        Log.w(GoogleAnalyticsTracker.LOG_TAG, str, e);
                        DispatcherThread.this.pipelinedRequester.finishedCurrentRequests();
                        DispatcherThread.this.callbacks.dispatchFinished();
                        AsyncDispatchTask unused4 = DispatcherThread.this.currentTask = null;
                    } catch (HttpException e3) {
                        e = e3;
                        str = "Problem with http streams.";
                        Log.w(GoogleAnalyticsTracker.LOG_TAG, str, e);
                        DispatcherThread.this.pipelinedRequester.finishedCurrentRequests();
                        DispatcherThread.this.callbacks.dispatchFinished();
                        AsyncDispatchTask unused5 = DispatcherThread.this.currentTask = null;
                    }
                }
                DispatcherThread.this.pipelinedRequester.finishedCurrentRequests();
                DispatcherThread.this.callbacks.dispatchFinished();
                AsyncDispatchTask unused6 = DispatcherThread.this.currentTask = null;
            }
        }

        private class RequesterCallbacks implements PipelinedRequester.Callbacks {
            private RequesterCallbacks() {
            }

            public void pipelineModeChanged(boolean z) {
                DispatcherThread dispatcherThread;
                int i;
                if (z) {
                    dispatcherThread = DispatcherThread.this;
                    i = 30;
                } else {
                    dispatcherThread = DispatcherThread.this;
                    i = 1;
                }
                int unused = dispatcherThread.maxEventsPerRequest = i;
            }

            public void requestSent() {
                Hit removeNextHit;
                if (DispatcherThread.this.currentTask != null && (removeNextHit = DispatcherThread.this.currentTask.removeNextHit()) != null) {
                    DispatcherThread.this.callbacks.hitDispatched(removeNextHit.hitId);
                }
            }

            public void serverError(int i) {
                int unused = DispatcherThread.this.lastStatusCode = i;
            }
        }

        private DispatcherThread(Dispatcher.Callbacks callbacks2, PipelinedRequester pipelinedRequester2, String str, NetworkDispatcher networkDispatcher) {
            super("DispatcherThread");
            this.maxEventsPerRequest = 30;
            this.currentTask = null;
            this.callbacks = callbacks2;
            this.userAgent = str;
            this.pipelinedRequester = pipelinedRequester2;
            this.requesterCallBacks = new RequesterCallbacks();
            this.pipelinedRequester.installCallbacks(this.requesterCallBacks);
            this.parent = networkDispatcher;
        }

        private DispatcherThread(Dispatcher.Callbacks callbacks2, String str, NetworkDispatcher networkDispatcher) {
            this(callbacks2, new PipelinedRequester(networkDispatcher.googleAnalyticsHost), str, networkDispatcher);
        }

        static /* synthetic */ long access$630(DispatcherThread dispatcherThread, long j) {
            long j2 = dispatcherThread.retryInterval * j;
            dispatcherThread.retryInterval = j2;
            return j2;
        }

        public void dispatchHits(Hit[] hitArr) {
            if (this.handlerExecuteOnDispatcherThread != null) {
                this.handlerExecuteOnDispatcherThread.post(new AsyncDispatchTask(hitArr));
            }
        }

        /* access modifiers changed from: protected */
        public void onLooperPrepared() {
            this.handlerExecuteOnDispatcherThread = new Handler();
        }
    }

    public NetworkDispatcher() {
        this(GoogleAnalyticsTracker.PRODUCT, GoogleAnalyticsTracker.VERSION);
    }

    public NetworkDispatcher(String str, String str2) {
        this(str, str2, GOOGLE_ANALYTICS_HOST_NAME, 80);
    }

    NetworkDispatcher(String str, String str2, String str3, int i) {
        this.dryRun = false;
        this.googleAnalyticsHost = new HttpHost(str3, i);
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[7];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Build.VERSION.RELEASE;
        objArr[3] = locale.getLanguage() != null ? locale.getLanguage().toLowerCase() : "en";
        objArr[4] = locale.getCountry() != null ? locale.getCountry().toLowerCase() : "";
        objArr[5] = Build.MODEL;
        objArr[6] = Build.ID;
        this.userAgent = String.format(USER_AGENT_TEMPLATE, objArr);
    }

    public void dispatchHits(Hit[] hitArr) {
        DispatcherThread dispatcherThread2 = this.dispatcherThread;
        if (dispatcherThread2 != null) {
            dispatcherThread2.dispatchHits(hitArr);
        }
    }

    /* access modifiers changed from: package-private */
    public String getUserAgent() {
        return this.userAgent;
    }

    public void init(Dispatcher.Callbacks callbacks) {
        stop();
        this.dispatcherThread = new DispatcherThread(callbacks, this.userAgent, this);
        this.dispatcherThread.start();
    }

    public void init(Dispatcher.Callbacks callbacks, PipelinedRequester pipelinedRequester, HitStore hitStore) {
        stop();
        this.dispatcherThread = new DispatcherThread(callbacks, pipelinedRequester, this.userAgent, this);
        this.dispatcherThread.start();
    }

    public boolean isDryRun() {
        return this.dryRun;
    }

    public void setDryRun(boolean z) {
        this.dryRun = z;
    }

    public void stop() {
        DispatcherThread dispatcherThread2 = this.dispatcherThread;
        if (dispatcherThread2 != null && dispatcherThread2.getLooper() != null) {
            this.dispatcherThread.getLooper().quit();
            this.dispatcherThread = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void waitForThreadLooper() {
        this.dispatcherThread.getLooper();
        while (this.dispatcherThread.handlerExecuteOnDispatcherThread == null) {
            Thread.yield();
        }
    }
}
