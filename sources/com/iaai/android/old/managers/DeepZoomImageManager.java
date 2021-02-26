package com.iaai.android.old.managers;

import android.content.Context;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.utils.Utils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.ResponseHandlerInterface;
import java.io.UnsupportedEncodingException;

public class DeepZoomImageManager {
    private static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;

    @Inject
    public DeepZoomImageManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
    }

    public void getImageURLs(Context context, String str, AsyncHttpResponseHandler asyncHttpResponseHandler) throws UnsupportedEncodingException {
        client.get(context, geURLforImage(context, str), (ResponseHandlerInterface) asyncHttpResponseHandler);
        client.setTimeout(60000);
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.setEnableRedirects(true, true, true);
    }

    private static String geURLforImage(Context context, String str) {
        return "http://vis.iaai.com/" + context.getResources().getString(C2723R.string.deep_zoom_image_url, new Object[]{str});
    }
}
