package com.iaai.android.old.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.iaai.android.C2723R;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class AdditionalStateReqPDFFragment extends Fragment {
    public static final String ARG_PDF_URL = "pdf_url";
    TextView back_bt;
    WebView webViewTips;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C2723R.C2728layout.additional_pdf_tab_layout, viewGroup, false);
        this.webViewTips = (WebView) inflate.findViewById(C2723R.C2726id.webview);
        this.back_bt = (TextView) inflate.findViewById(C2723R.C2726id.back_bt);
        TextView textView = this.back_bt;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AdditionalStateReqPDFFragment.this.getActivity().getSupportFragmentManager().popBackStackImmediate();
                }
            });
        }
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        String str;
        super.onActivityCreated(bundle);
        WebSettings settings = this.webViewTips.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setPluginState(WebSettings.PluginState.ON);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setAppCacheEnabled(false);
        settings.setCacheMode(2);
        this.webViewTips.clearHistory();
        this.webViewTips.clearFormData();
        this.webViewTips.clearCache(true);
        try {
            str = URLEncoder.encode(getArguments().getString(ARG_PDF_URL), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            str = null;
        }
        this.webViewTips.loadUrl("http://docs.google.com/viewer?url=" + str);
        this.webViewTips.setWebViewClient(new WebViewClient() {
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                return false;
            }
        });
    }
}
