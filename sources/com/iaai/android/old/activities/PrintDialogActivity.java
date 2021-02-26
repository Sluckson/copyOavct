package com.iaai.android.old.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.zxing.client.android.Intents;
import com.iaai.android.C2723R;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PrintDialogActivity extends Activity {
    private static final String CLOSE_POST_MESSAGE_NAME = "cp-dialog-on-close";
    private static final String CONTENT_TRANSFER_ENCODING = "base64";
    private static final String JS_INTERFACE = "AndroidPrintDialog";
    private static final String PRINT_DIALOG_URL = "https://www.google.com/cloudprint/dialog.html";
    private static final int ZXING_SCAN_REQUEST = 65743;
    private static final String ZXING_URL = "http://zxing.appspot.com";
    Intent cloudPrintIntent;
    private WebView dialogWebView;

    @SuppressLint({"JavascriptInterface"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C2723R.C2728layout.activity_print_dialog);
        this.dialogWebView = (WebView) findViewById(C2723R.C2726id.webview);
        this.cloudPrintIntent = getIntent();
        this.dialogWebView.getSettings().setJavaScriptEnabled(true);
        this.dialogWebView.setWebViewClient(new PrintDialogWebClient());
        this.dialogWebView.addJavascriptInterface(new PrintDialogJavaScriptInterface(), JS_INTERFACE);
        this.dialogWebView.loadUrl(PRINT_DIALOG_URL);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == ZXING_SCAN_REQUEST && i2 == -1) {
            this.dialogWebView.loadUrl(intent.getStringExtra(Intents.Scan.RESULT));
        }
    }

    final class PrintDialogJavaScriptInterface {
        public String getEncoding() {
            return PrintDialogActivity.CONTENT_TRANSFER_ENCODING;
        }

        PrintDialogJavaScriptInterface() {
        }

        public String getType() {
            return PrintDialogActivity.this.cloudPrintIntent.getType();
        }

        public String getTitle() {
            return PrintDialogActivity.this.cloudPrintIntent.getExtras().getString("title");
        }

        public String getContent() {
            try {
                InputStream openInputStream = PrintDialogActivity.this.getContentResolver().openInputStream(PrintDialogActivity.this.cloudPrintIntent.getData());
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[4096];
                for (int read = openInputStream.read(bArr); read >= 0; read = openInputStream.read(bArr)) {
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                openInputStream.close();
                byteArrayOutputStream.flush();
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return "";
            } catch (IOException e2) {
                e2.printStackTrace();
                return "";
            }
        }

        public void onPostMessage(String str) {
            if (str.startsWith(PrintDialogActivity.CLOSE_POST_MESSAGE_NAME)) {
                PrintDialogActivity.this.finish();
            }
        }
    }

    private final class PrintDialogWebClient extends WebViewClient {
        private PrintDialogWebClient() {
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.startsWith(PrintDialogActivity.ZXING_URL)) {
                Intent intent = new Intent(Intents.Scan.ACTION);
                intent.putExtra(Intents.Scan.MODE, Intents.Scan.QR_CODE_MODE);
                try {
                    PrintDialogActivity.this.startActivityForResult(intent, PrintDialogActivity.ZXING_SCAN_REQUEST);
                    return false;
                } catch (ActivityNotFoundException unused) {
                    webView.loadUrl(str);
                    return false;
                }
            } else {
                webView.loadUrl(str);
                return false;
            }
        }

        public void onPageFinished(WebView webView, String str) {
            if (PrintDialogActivity.PRINT_DIALOG_URL.equals(str)) {
                webView.loadUrl("javascript:printDialog.setPrintDocument(printDialog.createPrintDocument(window.AndroidPrintDialog.getType(),window.AndroidPrintDialog.getTitle(),window.AndroidPrintDialog.getContent(),window.AndroidPrintDialog.getEncoding()))");
                webView.loadUrl("javascript:window.addEventListener('message',function(evt){window.AndroidPrintDialog.onPostMessage(evt.data)}, false)");
            }
        }
    }
}
