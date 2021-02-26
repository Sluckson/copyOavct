package com.iaai.android.old.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
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
import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.util.MimeTypes;
import com.iaai.android.C2723R;
import com.lowagie.text.pdf.PdfBoolean;

public class BidLiveFrameworkActivity extends AppCompatActivity {
    TextView LaneHeader;
    String auction_now_url;
    AudioManager audioManager;
    ImageView audioToggel;
    String audio_stream;
    ImageView back_button;
    int counter = 0;
    /* access modifiers changed from: private */
    public AudioManager.OnAudioFocusChangeListener focusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        public void onAudioFocusChange(int i) {
            AudioManager audioManager = (AudioManager) BidLiveFrameworkActivity.this.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (i == -3) {
                BidLiveFrameworkActivity.this.f508mp.setVolume(0.2f, 0.2f);
                Log.d(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE, "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
            } else if (i == -2) {
                if (BidLiveFrameworkActivity.this.isAudioMute) {
                    BidLiveFrameworkActivity.this.f508mp.pause();
                }
                Log.d(ExifInterface.GPS_MEASUREMENT_2D, "AUDIOFOCUS_LOSS_TRANSIENT");
            } else if (i == -1) {
                BidLiveFrameworkActivity.this.f508mp.setVolume(0.0f, 0.0f);
                BidLiveFrameworkActivity.this.audioToggel.setImageDrawable(BidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_off));
                BidLiveFrameworkActivity.this.isAudioMute = true;
                Log.d(ExifInterface.GPS_MEASUREMENT_3D, "AUDIOFOCUS_LOSS");
            } else if (i == 1) {
                Log.d("4-->" + BidLiveFrameworkActivity.this.isAudioMute, "AUDIOFOCUS_GAIN");
                if (!BidLiveFrameworkActivity.this.isAudioMute) {
                    BidLiveFrameworkActivity.this.f508mp.setVolume(1.0f, 1.0f);
                    BidLiveFrameworkActivity.this.f508mp.start();
                    return;
                }
                BidLiveFrameworkActivity.this.f508mp.setVolume(0.0f, 0.0f);
                BidLiveFrameworkActivity.this.audioToggel.setImageDrawable(BidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_off));
            }
        }
    };
    boolean isAudioMute = false;
    boolean isAudioRunning = false;
    String lane_str;
    TextView locationHeader;
    RelativeLayout location_lane_layout;
    String location_str;
    int mDeviceVolume = 0;
    /* access modifiers changed from: private */

    /* renamed from: mp */
    public MediaPlayer f508mp = new MediaPlayer();
    private BroadcastReceiver networkStatusReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            NetworkInfo activeNetworkInfo;
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (intent.getExtras() != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED) {
                BidLiveFrameworkActivity.this.webview.loadUrl(BidLiveFrameworkActivity.this.auction_now_url);
            }
        }
    };
    String newUA = "AndroidApp";
    private BroadcastReceiver volumeButtonChangeReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            int intValue = ((Integer) intent.getExtras().get("android.media.EXTRA_VOLUME_STREAM_VALUE")).intValue();
            if (intValue == 0) {
                BidLiveFrameworkActivity.this.audioToggel.setImageDrawable(BidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_off));
                BidLiveFrameworkActivity.this.isAudioMute = true;
            } else if (intValue > BidLiveFrameworkActivity.this.mDeviceVolume) {
                BidLiveFrameworkActivity.this.audioToggel.setImageDrawable(BidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_on));
                BidLiveFrameworkActivity.this.isAudioMute = false;
            }
            BidLiveFrameworkActivity.this.mDeviceVolume = intValue;
        }
    };
    WebView webview;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.bidframework_activity_main);
        this.back_button = (ImageView) findViewById(C2723R.C2726id.back_button_bid_live);
        this.webview = (WebView) findViewById(C2723R.C2726id.auction_now_webview);
        this.location_lane_layout = (RelativeLayout) findViewById(C2723R.C2726id.location_lane_layout);
        this.locationHeader = (TextView) findViewById(C2723R.C2726id.location_header);
        this.LaneHeader = (TextView) findViewById(C2723R.C2726id.lane_header);
        this.audioToggel = (ImageView) findViewById(C2723R.C2726id.audio_toggle_button);
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
        this.audioToggel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (BidLiveFrameworkActivity.this.isAudioMute) {
                    BidLiveFrameworkActivity.this.audioManager.requestAudioFocus(BidLiveFrameworkActivity.this.focusChangeListener, 3, 1);
                    BidLiveFrameworkActivity.this.audioToggel.setImageDrawable(BidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_on));
                    BidLiveFrameworkActivity.this.f508mp.setVolume(1.0f, 1.0f);
                    if (!BidLiveFrameworkActivity.this.f508mp.isPlaying()) {
                        BidLiveFrameworkActivity.this.f508mp.start();
                    }
                    BidLiveFrameworkActivity.this.isAudioMute = false;
                    return;
                }
                BidLiveFrameworkActivity.this.audioToggel.setImageDrawable(BidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_off));
                BidLiveFrameworkActivity.this.f508mp.setVolume(0.0f, 0.0f);
                BidLiveFrameworkActivity.this.isAudioMute = true;
            }
        });
        this.back_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BidLiveFrameworkActivity.this.onBackPressed();
            }
        });
        this.audioManager = (AudioManager) getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.audioManager.requestAudioFocus(this.focusChangeListener, 3, 1);
    }

    private void temporaryAudioTestingCode() {
        playMediaPlayerAudio("rtsp://lbwowza.trafficmanager.net:1935/vod/mp4:ss.mp4");
        this.locationHeader.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BidLiveFrameworkActivity.this.playMediaPlayerAudio("true");
            }
        });
        this.LaneHeader.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BidLiveFrameworkActivity.this.playMediaPlayerAudio("rtsp://wowzaec2demo.streamlock.net/vod/mp4:BigBuckBunny_115k.mov");
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
        MediaPlayer mediaPlayer = this.f508mp;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        AudioManager audioManager2 = this.audioManager;
        if (audioManager2 != null) {
            audioManager2.abandonAudioFocus(this.focusChangeListener);
        }
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
            BidLiveFrameworkActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    BidLiveFrameworkActivity.this.location_lane_layout.setVisibility(0);
                    BidLiveFrameworkActivity.this.location_str = str;
                    BidLiveFrameworkActivity.this.locationHeader.setText(BidLiveFrameworkActivity.this.location_str);
                    BidLiveFrameworkActivity.this.audio_stream = "";
                    BidLiveFrameworkActivity.this.isAudioMute = false;
                    BidLiveFrameworkActivity.this.stopAudio();
                    BidLiveFrameworkActivity.this.audioToggel.setVisibility(8);
                }
            });
        }

        @JavascriptInterface
        public void postLane(final String str) {
            Log.d("Lane-->", "lane->" + str);
            BidLiveFrameworkActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    BidLiveFrameworkActivity.this.location_lane_layout.setVisibility(0);
                    BidLiveFrameworkActivity.this.lane_str = str;
                    TextView textView = BidLiveFrameworkActivity.this.LaneHeader;
                    textView.setText("Lane " + BidLiveFrameworkActivity.this.lane_str);
                }
            });
        }

        @JavascriptInterface
        public void postCreator(String str) {
            Log.d("flag-->", "flag->" + str);
            BidLiveFrameworkActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                }
            });
        }

        @JavascriptInterface
        public void postAudioStreamName(final String str) {
            Log.d("audio_url-->", "audio_url->" + str);
            BidLiveFrameworkActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    BidLiveFrameworkActivity.this.playMediaPlayerAudio(str);
                }
            });
        }

        @JavascriptInterface
        public void postAudioIsAvaiable(final String str) {
            Log.d("audio_url-->", "audio_url->" + str);
            BidLiveFrameworkActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                    BidLiveFrameworkActivity.this.playMediaPlayerAudio(str);
                }
            });
        }

        @JavascriptInterface
        public void postVideo(String str) {
            Log.d("video_url-->", "video_url->" + str);
            BidLiveFrameworkActivity.this.runOnUiThread(new Runnable() {
                public void run() {
                }
            });
        }

        @JavascriptInterface
        public void postredirecturl(final String str) {
            Log.d("postredirecturl-->", "postredirecturl->" + str);
            if (str != null && str.length() > 0) {
                BidLiveFrameworkActivity bidLiveFrameworkActivity = BidLiveFrameworkActivity.this;
                bidLiveFrameworkActivity.auction_now_url = str;
                bidLiveFrameworkActivity.runOnUiThread(new Runnable() {
                    public void run() {
                        BidLiveFrameworkActivity.this.webview.getSettings().setUserAgentString(BidLiveFrameworkActivity.this.newUA);
                        BidLiveFrameworkActivity.this.webview.loadUrl(str);
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
            this.counter = 0;
            if (str != null && str.equalsIgnoreCase("noaudio")) {
                if (this.f508mp.isPlaying()) {
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
                        if (this.f508mp.isPlaying()) {
                            stopAudio();
                            startAudio(this.audio_stream);
                        } else {
                            startAudio(this.audio_stream);
                        }
                    }
                    this.audioToggel.setVisibility(0);
                } else if (this.f508mp.isPlaying()) {
                    stopAudio();
                    this.audioToggel.setImageDrawable(getResources().getDrawable(C2723R.C2725drawable.audio_off));
                }
            } else if (!this.f508mp.isPlaying() && (str2 = this.audio_stream) != null && str2.length() > 0) {
                startAudio(this.audio_stream);
                this.audioToggel.setVisibility(0);
            }
            this.isAudioRunning = false;
        }
    }

    public void startAudio(String str) {
        try {
            Log.d("startAudio-->", "startAudio->" + str);
            this.f508mp.setDataSource(str);
            this.f508mp.setAudioStreamType(3);
            this.f508mp.prepareAsync();
            this.f508mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                    if (BidLiveFrameworkActivity.this.isAudioMute) {
                        BidLiveFrameworkActivity.this.audioToggel.setImageDrawable(BidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_off));
                        mediaPlayer.setVolume(0.0f, 0.0f);
                        return;
                    }
                    BidLiveFrameworkActivity.this.audioToggel.setImageDrawable(BidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_on));
                    mediaPlayer.setVolume(1.0f, 1.0f);
                }
            });
            this.f508mp.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    Log.d("onError-Audio->", "onErrorAudio->");
                    BidLiveFrameworkActivity.this.f508mp.reset();
                    BidLiveFrameworkActivity bidLiveFrameworkActivity = BidLiveFrameworkActivity.this;
                    bidLiveFrameworkActivity.startAudio(bidLiveFrameworkActivity.audio_stream);
                    return false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void stopAudio() {
        try {
            runOnUiThread(new Runnable() {
                public void run() {
                    BidLiveFrameworkActivity.this.audioToggel.setImageDrawable(BidLiveFrameworkActivity.this.getResources().getDrawable(C2723R.C2725drawable.audio_off));
                }
            });
            this.f508mp.stop();
            this.f508mp.reset();
        } catch (Exception e) {
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
        if (this.f508mp.isPlaying()) {
            stopAudio();
            this.audio_stream = null;
        }
        finish();
    }
}
