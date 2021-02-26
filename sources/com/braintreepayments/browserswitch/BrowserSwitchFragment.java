package com.braintreepayments.browserswitch;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.exoplayer2.C1119C;
import java.util.List;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public abstract class BrowserSwitchFragment extends Fragment {
    private static final String EXTRA_REQUEST_CODE = "com.braintreepayments.browserswitch.EXTRA_REQUEST_CODE";
    protected Context mContext;
    protected int mRequestCode;

    public abstract void onBrowserSwitchResult(int i, BrowserSwitchResult browserSwitchResult, @Nullable Uri uri);

    public enum BrowserSwitchResult {
        OK,
        CANCELED,
        ERROR;
        
        private String mErrorMessage;

        public String getErrorMessage() {
            return this.mErrorMessage;
        }

        /* access modifiers changed from: private */
        public BrowserSwitchResult setErrorMessage(String str) {
            this.mErrorMessage = str;
            return this;
        }

        public String toString() {
            return name() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getErrorMessage();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (this.mContext == null) {
            this.mContext = getActivity().getApplicationContext();
        }
        if (bundle != null) {
            this.mRequestCode = bundle.getInt(EXTRA_REQUEST_CODE);
        } else {
            this.mRequestCode = Integer.MIN_VALUE;
        }
    }

    public void onResume() {
        super.onResume();
        if (isBrowserSwitching()) {
            Uri returnUri = BrowserSwitchActivity.getReturnUri();
            int i = this.mRequestCode;
            this.mRequestCode = Integer.MIN_VALUE;
            BrowserSwitchActivity.clearReturnUri();
            if (returnUri != null) {
                onBrowserSwitchResult(i, BrowserSwitchResult.OK, returnUri);
            } else {
                onBrowserSwitchResult(i, BrowserSwitchResult.CANCELED, (Uri) null);
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(EXTRA_REQUEST_CODE, this.mRequestCode);
    }

    public String getReturnUrlScheme() {
        return this.mContext.getPackageName().toLowerCase().replace("_", "") + ".browserswitch";
    }

    public void browserSwitch(int i, String str) {
        Intent addFlags = new Intent("android.intent.action.VIEW", Uri.parse(str)).addFlags(C1119C.ENCODING_PCM_MU_LAW);
        ChromeCustomTabs.addChromeCustomTabsExtras(this.mContext, addFlags);
        browserSwitch(i, addFlags);
    }

    public void browserSwitch(int i, Intent intent) {
        if (i == Integer.MIN_VALUE) {
            onBrowserSwitchResult(i, BrowserSwitchResult.ERROR.setErrorMessage("Request code cannot be Integer.MIN_VALUE"), (Uri) null);
        } else if (!isReturnUrlSetup()) {
            onBrowserSwitchResult(i, BrowserSwitchResult.ERROR.setErrorMessage("The return url scheme was not set up, incorrectly set up, or more than one Activity on this device defines the same url scheme in it's Android Manifest. See https://github.com/braintree/browser-switch-android for more information on setting up a return url scheme."), (Uri) null);
        } else if (availableActivities(intent).size() == 0) {
            onBrowserSwitchResult(i, BrowserSwitchResult.ERROR.setErrorMessage(String.format("No installed activities can open this URL: %s", new Object[]{intent.getData().toString()})), (Uri) null);
        } else {
            this.mRequestCode = i;
            this.mContext.startActivity(intent);
        }
    }

    private boolean isBrowserSwitching() {
        return this.mRequestCode != Integer.MIN_VALUE;
    }

    private boolean isReturnUrlSetup() {
        Intent intent = new Intent("android.intent.action.VIEW");
        StringBuilder sb = new StringBuilder();
        sb.append(getReturnUrlScheme());
        sb.append("://");
        return availableActivities(intent.setData(Uri.parse(sb.toString())).addCategory("android.intent.category.DEFAULT").addCategory("android.intent.category.BROWSABLE")).size() == 1;
    }

    private List<ResolveInfo> availableActivities(Intent intent) {
        return this.mContext.getPackageManager().queryIntentActivities(intent, 0);
    }
}
