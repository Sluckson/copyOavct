package com.iaai.android.old.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.util.MimeTypes;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.lowagie.text.pdf.PdfBoolean;
import com.wowza.gocoder.sdk.api.WowzaGoCoder;
import com.wowza.gocoder.sdk.api.logging.WOWZLog;
import com.wowza.gocoder.sdk.api.player.WOWZPlayerConfig;
import com.wowza.gocoder.sdk.api.player.WOWZPlayerView;
import com.wowza.gocoder.sdk.api.status.WOWZStatus;
import com.wowza.gocoder.sdk.api.status.WOWZStatusCallback;

public class WowzaBidLiveFrameworkActivity extends AppCompatActivity {
    public static final String WOWZA_APPLICATION = "live";
    public static final String WOWZA_HOST_ADDRESS = "lbwowza.trafficmanager.net";
    public static final int WOWZA_PORTNUMBER = 1935;
    TextView LaneHeader;
    String auction_now_url;
    AudioManager audioManager;
    ImageView audioToggel;
    String audio_stream;
    ImageView back_button;
    int counter = 0;
    boolean isAudioMute = false;
    boolean isAudioRunning = false;
    boolean isNewAudioURL;
    String lane_str;
    TextView locationHeader;
    RelativeLayout location_lane_layout;
    String location_str;
    int mDeviceVolume = 0;
    int mOldVolume = 0;
    WOWZPlayerView mStreamAudioPlayerView;
    BroadcastReceiver networkStatusReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            NetworkInfo activeNetworkInfo;
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (intent.getExtras() != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                WowzaBidLiveFrameworkActivity.this.webview.loadUrl(WowzaBidLiveFrameworkActivity.this.auction_now_url);
            }
        }
    };
    String newUA = "AndroidApp";
    WowzaGoCoder sGoCoderSDK;
    WOWZStatusCallback statusCallback;
    private BroadcastReceiver volumeButtonChangeReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            int intValue = ((Integer) intent.getExtras().get("android.media.EXTRA_VOLUME_STREAM_VALUE")).intValue();
            if (intValue == 0) {
                WowzaBidLiveFrameworkActivity.this.audioToggel.setImageDrawable(WowzaBidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_off));
                WowzaBidLiveFrameworkActivity.this.isAudioMute = true;
            } else if (intValue > WowzaBidLiveFrameworkActivity.this.mDeviceVolume) {
                WowzaBidLiveFrameworkActivity.this.audioToggel.setImageDrawable(WowzaBidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_on));
                WowzaBidLiveFrameworkActivity wowzaBidLiveFrameworkActivity = WowzaBidLiveFrameworkActivity.this;
                wowzaBidLiveFrameworkActivity.isAudioMute = false;
                wowzaBidLiveFrameworkActivity.mDeviceVolume = intValue * 10;
            }
        }
    };
    boolean wasAudioMute = false;
    boolean wasAudioRunning = false;
    WebView webview;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.bidframework_wowza_activity_main);
        getWindow().addFlags(128);
        this.back_button = (ImageView) findViewById(C2723R.C2726id.back_button_bid_live);
        this.webview = (WebView) findViewById(C2723R.C2726id.auction_now_webview);
        this.location_lane_layout = (RelativeLayout) findViewById(C2723R.C2726id.location_lane_layout);
        this.locationHeader = (TextView) findViewById(C2723R.C2726id.location_header);
        this.LaneHeader = (TextView) findViewById(C2723R.C2726id.lane_header);
        this.audioToggel = (ImageView) findViewById(C2723R.C2726id.audio_toggle_button);
        this.mStreamAudioPlayerView = (WOWZPlayerView) findViewById(C2723R.C2726id.vwAudioStreamPlayer);
        this.counter = 0;
        this.audioToggel.setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.audio_off));
        this.auction_now_url = getIntent().getStringExtra("auction_now_url");
        String str = this.auction_now_url;
        if (str != null && str.length() > 0) {
            this.location_lane_layout.setVisibility(0);
            loadWebView(false);
        }
        registerReceiver(this.networkStatusReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
        registerReceiver(this.volumeButtonChangeReceiver, intentFilter);
        this.statusCallback = new StatusCallback();
        this.audioToggel.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                WowzaBidLiveFrameworkActivity.this.lambda$onCreate$0$WowzaBidLiveFrameworkActivity(view);
            }
        });
        this.back_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WowzaBidLiveFrameworkActivity.this.onBackPressed();
            }
        });
        this.audioManager = (AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.mDeviceVolume = 70;
        this.mOldVolume = 70;
    }

    public /* synthetic */ void lambda$onCreate$0$WowzaBidLiveFrameworkActivity(View view) {
        if (this.isAudioMute) {
            this.audioToggel.setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.audio_on));
            this.mStreamAudioPlayerView.setVolume(this.mOldVolume);
            if (!this.mStreamAudioPlayerView.isPlaying()) {
                playWowzaStream();
            }
            this.isAudioMute = false;
            this.wasAudioMute = false;
            return;
        }
        this.audioToggel.setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.audio_off));
        this.mOldVolume = this.mDeviceVolume;
        this.mStreamAudioPlayerView.setVolume(0);
        this.isAudioMute = true;
    }

    /* access modifiers changed from: private */
    public WOWZPlayerConfig getAudioPlayerConfig(String str) {
        if (this.sGoCoderSDK == null) {
            WOWZLog.LOGGING_ENABLED = true;
            this.sGoCoderSDK = WowzaGoCoder.init(this, getString(C2723R.string.wowza_license_key));
            if (this.sGoCoderSDK == null) {
                WOWZLog.error("Main Activity", WowzaGoCoder.getLastError());
            }
        }
        WOWZPlayerConfig wOWZPlayerConfig = new WOWZPlayerConfig();
        wOWZPlayerConfig.setIsPlayback(true);
        wOWZPlayerConfig.setHostAddress(WOWZA_HOST_ADDRESS);
        wOWZPlayerConfig.setApplicationName("live");
        wOWZPlayerConfig.setStreamName(str);
        wOWZPlayerConfig.setPortNumber(1935);
        wOWZPlayerConfig.setAudioEnabled(true);
        this.mStreamAudioPlayerView.setMaxSecondsOfAudioLatency(1);
        return wOWZPlayerConfig;
    }

    class StatusCallback implements WOWZStatusCallback {
        StatusCallback() {
        }

        public void onWZStatus(WOWZStatus wOWZStatus) {
            final WOWZStatus wOWZStatus2 = new WOWZStatus(wOWZStatus);
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    switch (wOWZStatus2.getState()) {
                        case 0:
                            Log.d("WOWZStatus", "IDLE");
                            WowzaBidLiveFrameworkActivity.this.audioToggel.setImageDrawable(WowzaBidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_off));
                            break;
                        case 1:
                            Log.d("WOWZStatus", "STARTING");
                            break;
                        case 2:
                            Log.d("WOWZStatus", "READY");
                            break;
                        case 3:
                            Log.d("WOWZStatus", "RUNNING");
                            if (!WowzaBidLiveFrameworkActivity.this.wasAudioMute) {
                                WowzaBidLiveFrameworkActivity.this.mStreamAudioPlayerView.setVolume(WowzaBidLiveFrameworkActivity.this.mDeviceVolume);
                                WowzaBidLiveFrameworkActivity.this.audioToggel.setImageDrawable(WowzaBidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_on));
                                break;
                            } else {
                                WowzaBidLiveFrameworkActivity.this.mStreamAudioPlayerView.setVolume(0);
                                WowzaBidLiveFrameworkActivity.this.audioToggel.setImageDrawable(WowzaBidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_off));
                                break;
                            }
                        case 4:
                            Log.d("WOWZStatus", "STOPPING");
                            WowzaBidLiveFrameworkActivity.this.audioToggel.setImageDrawable(WowzaBidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_off));
                            break;
                        case 5:
                            Log.d("WOWZStatus", "PAUSED");
                            WowzaBidLiveFrameworkActivity.this.audioToggel.setImageDrawable(WowzaBidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_off));
                            break;
                        case 6:
                            Log.d("WOWZStatus", "STOPPED");
                            WowzaBidLiveFrameworkActivity.this.audioToggel.setImageDrawable(WowzaBidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_off));
                            break;
                        case 7:
                            Log.d("WOWZStatus", "COMPLETE");
                            if (WowzaBidLiveFrameworkActivity.this.isNewAudioURL) {
                                WowzaBidLiveFrameworkActivity.this.playWowzaStream();
                                WowzaBidLiveFrameworkActivity.this.isNewAudioURL = false;
                            }
                            WowzaBidLiveFrameworkActivity.this.audioToggel.setImageDrawable(WowzaBidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_off));
                            break;
                        case 9:
                            Log.d("WOWZStatus", "SHUTDOWN");
                            break;
                        default:
                            Log.d("WOWZStatus", "" + wOWZStatus2.getState());
                            return;
                    }
                    Log.d("WOWZStatus", "" + wOWZStatus2.getState());
                }
            });
        }

        public void onWZError(WOWZStatus wOWZStatus) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    WowzaBidLiveFrameworkActivity.this.playWowzaStream();
                    WowzaBidLiveFrameworkActivity.this.counter++;
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        String str;
        if (this.wasAudioRunning && (str = this.audio_stream) != null && str.length() > 0) {
            this.wasAudioRunning = false;
            startAudio(this.audio_stream);
        }
        super.onResume();
        IAAAnalytics.INSTANCE.logScreenName(IAAAnalytics.IAAScreenName.BID_LIVE.getValue(), this);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        WOWZPlayerView wOWZPlayerView = this.mStreamAudioPlayerView;
        if (wOWZPlayerView != null && wOWZPlayerView.isPlaying()) {
            this.wasAudioRunning = true;
            if (this.isAudioMute) {
                this.wasAudioMute = true;
            } else {
                this.wasAudioMute = false;
            }
            stopAudio();
        }
        super.onStop();
    }

    public void playWowzaStream() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                WOWZPlayerView wOWZPlayerView = WowzaBidLiveFrameworkActivity.this.mStreamAudioPlayerView;
                WowzaBidLiveFrameworkActivity wowzaBidLiveFrameworkActivity = WowzaBidLiveFrameworkActivity.this;
                wOWZPlayerView.play(wowzaBidLiveFrameworkActivity.getAudioPlayerConfig(wowzaBidLiveFrameworkActivity.audio_stream), WowzaBidLiveFrameworkActivity.this.statusCallback);
            }
        }, 1000);
    }

    private void temporaryAudioTestingCode() {
        playMediaPlayerAudio("london-lane1-qas-audio");
        this.locationHeader.setVisibility(0);
        this.LaneHeader.setVisibility(0);
        this.location_lane_layout.setVisibility(0);
        this.locationHeader.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WowzaBidLiveFrameworkActivity.this.playMediaPlayerAudio(PdfBoolean.FALSE);
            }
        });
        this.LaneHeader.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WowzaBidLiveFrameworkActivity.this.playMediaPlayerAudio("true");
            }
        });
    }

    private void loadWebView(boolean z) {
        WebSettings settings = this.webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheEnabled(false);
        this.webview.addJavascriptInterface(new JsObject(this), "Android");
        settings.setCacheMode(2);
        this.webview.clearHistory();
        this.webview.clearFormData();
        this.webview.clearCache(true);
        this.webview.getSettings().setUserAgentString(this.newUA);
        this.webview.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
                return false;
            }
        });
        this.webview.loadUrl(this.auction_now_url);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.webview.destroy();
        unregisterReceiver(this.networkStatusReceiver);
        unregisterReceiver(this.volumeButtonChangeReceiver);
        stopAudio();
    }

    public class JsObject {
        Context mContext;

        JsObject(Context context) {
            this.mContext = context;
        }

        @JavascriptInterface
        public void postisAuctionStarted(String str) {
            Log.d("postisAuctionStarted-->", "isLiveAuctionStarted->" + str);
        }

        @JavascriptInterface
        public void postLocation(final String str) {
            Log.d("Location-->", "location->" + str);
            WowzaBidLiveFrameworkActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    WowzaBidLiveFrameworkActivity.this.location_lane_layout.setVisibility(0);
                    WowzaBidLiveFrameworkActivity.this.location_str = str;
                    WowzaBidLiveFrameworkActivity.this.locationHeader.setText(WowzaBidLiveFrameworkActivity.this.location_str);
                    WowzaBidLiveFrameworkActivity.this.audio_stream = "";
                    WowzaBidLiveFrameworkActivity.this.isAudioMute = false;
                    WowzaBidLiveFrameworkActivity.this.counter = 0;
                    WowzaBidLiveFrameworkActivity.this.stopAudio();
                    WowzaBidLiveFrameworkActivity.this.audioToggel.setVisibility(8);
                }
            });
        }

        @JavascriptInterface
        public void postLane(final String str) {
            Log.d("Lane-->", "lane->" + str);
            WowzaBidLiveFrameworkActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    WowzaBidLiveFrameworkActivity.this.location_lane_layout.setVisibility(0);
                    WowzaBidLiveFrameworkActivity.this.lane_str = str;
                    TextView textView = WowzaBidLiveFrameworkActivity.this.LaneHeader;
                    textView.setText("Lane " + WowzaBidLiveFrameworkActivity.this.lane_str);
                }
            });
        }

        @JavascriptInterface
        public void postCreator(String str) {
            Log.d("flag-->", "flag->" + str);
            WowzaBidLiveFrameworkActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                }
            });
        }

        @JavascriptInterface
        public void postAudioStreamName(final String str) {
            Log.d("audio_url-->", "audio_url->" + str);
            WowzaBidLiveFrameworkActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    WowzaBidLiveFrameworkActivity.this.playMediaPlayerAudio(str);
                }
            });
        }

        @JavascriptInterface
        public void postAudioIsAvaiable(final String str) {
            Log.d("audio_url-->", "audio_url->" + str);
            WowzaBidLiveFrameworkActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    WowzaBidLiveFrameworkActivity.this.playMediaPlayerAudio(str);
                }
            });
        }

        @JavascriptInterface
        public void postredirecturl(final String str) {
            Log.d("postredirecturl-->", "postredirecturl->" + str);
            if (str != null && str.length() > 0) {
                WowzaBidLiveFrameworkActivity wowzaBidLiveFrameworkActivity = WowzaBidLiveFrameworkActivity.this;
                wowzaBidLiveFrameworkActivity.auction_now_url = str;
                wowzaBidLiveFrameworkActivity.runOnUiThread(new Runnable() {
                    public void run() {
                        WowzaBidLiveFrameworkActivity.this.webview.getSettings().setUserAgentString(WowzaBidLiveFrameworkActivity.this.newUA);
                        WowzaBidLiveFrameworkActivity.this.webview.loadUrl(str);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void playMediaPlayerAudio(String str) {
        String str2;
        if (!this.isAudioRunning) {
            this.isAudioRunning = true;
            Log.d("playMediaPlayerAudio-->", "CallBack->" + str);
            Log.d("playMediaPlayerAudio-->", "after->" + str);
            this.counter = 0;
            if (str != null && str.equalsIgnoreCase("noaudio")) {
                if (this.mStreamAudioPlayerView.isPlaying()) {
                    stopAudio();
                }
                this.audioToggel.setVisibility(4);
            } else if (str == null || !str.equalsIgnoreCase("true")) {
                if (str == null || !str.equalsIgnoreCase(PdfBoolean.FALSE)) {
                    String str3 = this.audio_stream;
                    if (str3 == null) {
                        this.audio_stream = str;
                        startAudio(this.audio_stream);
                    } else if (!str3.equals(str)) {
                        this.audio_stream = str;
                        if (this.mStreamAudioPlayerView.isPlaying()) {
                            stopAudio();
                            startAudio(this.audio_stream);
                        } else {
                            startAudio(this.audio_stream);
                        }
                    }
                    this.audioToggel.setVisibility(0);
                } else if (this.mStreamAudioPlayerView.isPlaying()) {
                    stopAudio();
                    this.audioToggel.setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.audio_off));
                }
            } else if (!this.mStreamAudioPlayerView.isPlaying() && (str2 = this.audio_stream) != null && str2.length() > 0) {
                startAudio(this.audio_stream);
                this.audioToggel.setVisibility(0);
            }
            this.isAudioRunning = false;
        }
    }

    public void startAudio(String str) {
        try {
            playWowzaStream();
        } catch (Exception e) {
            Log.d("startAudio exception-->", e.getMessage());
            e.printStackTrace();
        }
    }

    public void stopAudio() {
        try {
            this.mStreamAudioPlayerView.stop();
        } catch (Exception e) {
            Log.d("Stop Audio-exception->", e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void onBackPressed() {
        sendBroadcast(new Intent().setAction(Constants_MVVM.ACTION_AUCTION_NOW_EXIT));
        if (this.mStreamAudioPlayerView.isPlaying()) {
            stopAudio();
            this.audio_stream = null;
        }
        finish();
    }
}
