package com.iaai.android.old.activities;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.gson.Gson;
import com.google.inject.Inject;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.analytics.IAAAnalytics;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.old.analytics.AnalyticUtils;
import com.iaai.android.old.analytics.classes.AnalyticInfo;
import com.iaai.android.old.managers.AuctionLanesManager;
import com.iaai.android.old.managers.FetchIBidLiveAuctionURLManager;
import com.iaai.android.old.managers.LoginStateChangeEventListener;
import com.iaai.android.old.managers.OnLoginStateChangeEvent;
import com.iaai.android.old.models.AuctionLanes;
import com.iaai.android.old.models.AuctionStatus;
import com.iaai.android.old.models.IBidLiveURL;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.p016ui.ActivityHelper;
import com.iaai.android.old.utils.p016ui.CloseSoftKeyboardEnforcer;
import com.iaai.android.old.widgets.CustomPopupWindow;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.util.ArrayList;
import java.util.Iterator;
import p052cz.msebera.android.httpclient.Header;
import roboguice.event.Observes;
import roboguice.inject.InjectView;

public class IBidLiveActivity extends AbstractActivity {
    String auctionLane;
    ArrayList<AuctionLanes> auctionLanesArrayList;
    @Inject
    AuctionLanesManager auctionLanesManager;
    String branchCode;
    @InjectView(2131296617)
    private ImageButton btn_close_ibid_live;
    @InjectView(2131296638)
    private LinearLayout btn_overflow;
    @Inject
    private CloseSoftKeyboardEnforcer closeSoftKeyboardEnforcer;
    @Inject
    FetchIBidLiveAuctionURLManager fetchIBidLiveAuctionURLManager;
    boolean jsonSuccess;
    /* access modifiers changed from: private */
    public int lastSavedPosition = -1;
    @Inject
    private LoginStateChangeEventListener loginStateChangeEventListener;
    CustomPopupWindow popupWindow;
    ProgressDialog progress;
    @InjectView(2131297953)
    View progressBar;
    /* access modifiers changed from: private */
    public int selectedPositionInList = -1;
    private SessionManager sessionManager;
    boolean visitor;
    @InjectView(2131299148)
    private WebView webView;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2723R.C2728layout.web_view);
        this.sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();
        if (isTablet()) {
            setRequestedOrientation(0);
        }
        this.webView.setWebViewClient(new EmbeddedWebViewClient());
        this.webView.setScrollBarStyle(0);
        this.webView.addJavascriptInterface(new WebAppInterface(this), "Android");
        WebSettings settings = this.webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(2);
        commitIntentData(getIntent());
        this.btn_close_ibid_live.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                IBidLiveActivity.this.finish();
            }
        });
        if (isTablet()) {
            this.btn_overflow.setVisibility(8);
        }
        this.btn_overflow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (IBidLiveActivity.this.jsonSuccess) {
                    Intent intent = new Intent(IBidLiveActivity.this, AuctionLanesList.class);
                    intent.putParcelableArrayListExtra("AuctionLanesList", IBidLiveActivity.this.auctionLanesArrayList);
                    intent.putExtra("POSITION_IN_LIST", IBidLiveActivity.this.selectedPositionInList);
                    IBidLiveActivity.this.startActivityForResult(intent, 1001);
                }
            }
        });
        downloadAuctionLanesData();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        IAAAnalytics.INSTANCE.logScreenName(IAAAnalytics.IAAScreenName.BID_LIVE.getValue(), this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.webView.loadUrl("javascript:unloadWC()");
        WebStorage.getInstance().deleteAllData();
        WebView webView2 = this.webView;
        if (webView2 != null) {
            ViewGroup viewGroup = (ViewGroup) webView2.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.webView);
            }
            this.webView.removeAllViews();
            this.webView.destroy();
        }
        super.onDestroy();
    }

    public class WebAppInterface {
        Context mContext;

        WebAppInterface(Context context) {
            this.mContext = context;
        }

        @JavascriptInterface
        public void closeActivity() {
            IBidLiveActivity.this.finish();
        }
    }

    public void closeActivity() {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        commitIntentData(intent);
    }

    private void handleLoginStateChange(@Observes OnLoginStateChangeEvent onLoginStateChangeEvent) {
        if (!onLoginStateChangeEvent.isLoggedIn) {
            finish();
        }
    }

    private void commitIntentData(Intent intent) {
        String stringExtra = intent.getStringExtra("url");
        this.visitor = intent.getBooleanExtra(Constants.EXTRA_IBIDLIVE_VISITOR, false);
        this.branchCode = intent.getStringExtra(Constants.EXTRA_IBIDLIVE_VISITOR_BRANCHCODE);
        this.auctionLane = intent.getStringExtra(Constants.EXTRA_IBIDLIVE_VISITOR_LANE);
        int parseInt = this.visitor ? 0 : this.sessionManager.getCurrentSessionUserId() != null ? Integer.parseInt(this.sessionManager.getCurrentSessionUserId()) : 0;
        String str = this.branchCode;
        AnalyticUtils.logAnalytics(this, new AnalyticInfo(parseInt, str != null ? Integer.parseInt(str) : 0, 0, 4, System.currentTimeMillis(), this.auctionLane));
        if (isTablet()) {
            this.webView.getSettings().setUserAgentString("Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B334b Safari/531.21.10 ");
            stringExtra = stringExtra.replace("mobileIAA2015", "iaa2016");
            this.webView.getSettings().setLoadWithOverviewMode(true);
        }
        this.webView.loadUrl(stringExtra);
    }

    private class EmbeddedWebViewClient extends WebViewClient {
        private EmbeddedWebViewClient() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.contains("iaabuyerapp/self.close")) {
                IBidLiveActivity.this.closeActivity();
                return true;
            }
            webView.loadUrl(str);
            return true;
        }

        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            IBidLiveActivity.this.progressBar.setVisibility(0);
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            IBidLiveActivity.this.progressBar.setVisibility(8);
        }
    }

    private void buildOverflow(final ArrayList<AuctionLanes> arrayList) {
        this.popupWindow = new CustomPopupWindow(this);
        if (arrayList != null) {
            if (arrayList.size() == 0) {
                for (int i = 0; i < 5; i++) {
                    this.popupWindow.addPopupItemUsingString("", i);
                }
            } else {
                Iterator<AuctionLanes> it = arrayList.iterator();
                while (it.hasNext()) {
                    AuctionLanes next = it.next();
                    CustomPopupWindow customPopupWindow = this.popupWindow;
                    customPopupWindow.addPopupItemUsingString(next.auctionName + " - " + next.auctionLane, Integer.parseInt(next.branchNumber));
                }
            }
        }
        this.popupWindow.setOnPopupItemClickListener(new CustomPopupWindow.OnPopupItemClickListener() {
            public void onItemClick(String str, int i) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    AuctionLanes auctionLanes = (AuctionLanes) it.next();
                    String str2 = auctionLanes.branchNumber;
                    if (str2.equals("" + i)) {
                        IBidLiveActivity.this.progress.show();
                        IBidLiveActivity.this.fetchIBidLiveAuctionURLManager.loadIBidAuctionURLs(new AsyncHttpResponseHandler() {
                            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                                IBidLiveURL iBidLiveURL = (IBidLiveURL) new Gson().fromJson(new String(bArr), IBidLiveURL.class);
                                if (iBidLiveURL.errorMessage == null || iBidLiveURL.errorMessage.length() <= 0) {
                                    IBidLiveActivity.this.loadIBidLiveURLInWebView(iBidLiveURL.url);
                                } else {
                                    IBidLiveActivity.this.showErrorMessage(iBidLiveURL.errorMessage);
                                }
                                IBidLiveActivity.this.progress.dismiss();
                            }

                            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                                ActivityHelper.dismissDialog(IBidLiveActivity.this);
                                IBidLiveActivity.this.progress.dismiss();
                                Toast.makeText(IBidLiveActivity.this.getApplicationContext(), IBidLiveActivity.this.getResources().getString(C2723R.string.msg_network_error), 0).show();
                            }
                        }, auctionLanes.branchNumber, auctionLanes.auctionLane, IBidLiveActivity.this.visitor, IBidLiveActivity.this);
                    }
                }
            }
        });
    }

    private void downloadAuctionLanesData() {
        this.progress = new ProgressDialog(this);
        this.progress.setMessage("Loading...");
        this.progress.setIndeterminate(false);
        this.progress.show();
        this.auctionLanesManager.loadAuctionLanes(new AsyncHttpResponseHandler() {
            public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                IBidLiveActivity.this.auctionLanesArrayList = ((AuctionStatus) new Gson().fromJson(new String(bArr), AuctionStatus.class)).auctionStatus;
                int i2 = 0;
                while (true) {
                    if (i2 >= IBidLiveActivity.this.auctionLanesArrayList.size()) {
                        break;
                    }
                    AuctionLanes auctionLanes = IBidLiveActivity.this.auctionLanesArrayList.get(i2);
                    if (auctionLanes.branchNumber.equals(IBidLiveActivity.this.branchCode) && auctionLanes.auctionLane.equals(IBidLiveActivity.this.auctionLane)) {
                        int unused = IBidLiveActivity.this.lastSavedPosition = i2;
                        int unused2 = IBidLiveActivity.this.selectedPositionInList = i2;
                        break;
                    }
                    i2++;
                }
                IBidLiveActivity iBidLiveActivity = IBidLiveActivity.this;
                iBidLiveActivity.jsonSuccess = true;
                iBidLiveActivity.progress.dismiss();
            }

            public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                ActivityHelper.dismissDialog(this);
                IBidLiveActivity.this.progress.dismiss();
                IBidLiveActivity iBidLiveActivity = IBidLiveActivity.this;
                iBidLiveActivity.jsonSuccess = false;
                Toast.makeText(iBidLiveActivity.getApplicationContext(), IBidLiveActivity.this.getResources().getString(C2723R.string.msg_network_error), 0).show();
            }
        });
    }

    /* access modifiers changed from: private */
    public void loadIBidLiveURLInWebView(String str) {
        if (isTablet()) {
            this.webView.getSettings().setUserAgentString("Mozilla/5.0 (iPad; U; CPU OS 3_2 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B334b Safari/531.21.10 ");
            str = str.replace("mobileIAA2015", "iaa2016");
        }
        String replace = str.replace("&flavor=iaa2012", "");
        this.webView.loadUrl("javascript:unloadWC()");
        this.webView.loadUrl(replace);
    }

    private boolean isTablet() {
        return getResources().getBoolean(C2723R.bool.isTablet);
    }

    /* access modifiers changed from: private */
    public void showErrorMessage(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(str);
        builder.setCancelable(false).setPositiveButton(C2723R.string.lbl_OK_lower, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.create().show();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1001 && intent != null) {
            String stringExtra = intent.getStringExtra("AL_BRANCHNUMBER");
            String stringExtra2 = intent.getStringExtra("AL_AUCTIONLANE");
            final int intExtra = intent.getIntExtra("AL_POSITION_IN_LIST", -1);
            this.fetchIBidLiveAuctionURLManager.loadIBidAuctionURLs(new AsyncHttpResponseHandler() {
                public void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                    IBidLiveURL iBidLiveURL = (IBidLiveURL) new Gson().fromJson(new String(bArr), IBidLiveURL.class);
                    if (iBidLiveURL.errorMessage == null || iBidLiveURL.errorMessage.length() <= 0) {
                        int unused = IBidLiveActivity.this.selectedPositionInList = intExtra;
                        if (IBidLiveActivity.this.lastSavedPosition != IBidLiveActivity.this.selectedPositionInList) {
                            IBidLiveActivity iBidLiveActivity = IBidLiveActivity.this;
                            int unused2 = iBidLiveActivity.lastSavedPosition = iBidLiveActivity.selectedPositionInList;
                            IBidLiveActivity.this.loadIBidLiveURLInWebView(iBidLiveURL.url);
                        }
                    } else {
                        IBidLiveActivity.this.showErrorMessage(iBidLiveURL.errorMessage);
                    }
                    IBidLiveActivity.this.progress.dismiss();
                }

                public void onFailure(int i, Header[] headerArr, byte[] bArr, Throwable th) {
                    ActivityHelper.dismissDialog(IBidLiveActivity.this);
                    IBidLiveActivity.this.progress.dismiss();
                    Toast.makeText(IBidLiveActivity.this.getApplicationContext(), IBidLiveActivity.this.getResources().getString(C2723R.string.msg_network_error), 0).show();
                }
            }, stringExtra, stringExtra2, this.visitor, this);
        }
    }
}
