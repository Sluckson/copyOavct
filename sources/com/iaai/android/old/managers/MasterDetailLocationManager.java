package com.iaai.android.old.managers;

import android.content.Context;
import android.location.Location;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.utils.Utils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.ResponseHandlerInterface;

public class MasterDetailLocationManager {
    private static AsyncHttpClient client = new AsyncHttpClient();

    @Inject
    private MasterDetailLocationManager(Provider<IaaiApplication> provider) {
    }

    public void getLocationList(boolean z, Context context, String str, Location location, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String locationListUrl = getLocationListUrl(context, str, z);
        if (str.equalsIgnoreCase("latlong") && location != null) {
            locationListUrl = locationListUrl + "&lat=" + location.getLatitude() + "&long=" + location.getLongitude();
        }
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.get(context, locationListUrl, (ResponseHandlerInterface) asyncHttpResponseHandler);
    }

    private String getLocationListUrl(Context context, String str, boolean z) {
        if (z) {
            return context.getString(C2723R.string.base_https_url) + context.getString(C2723R.string.service_path_mdlocation, new Object[]{str, IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE});
        }
        return context.getString(C2723R.string.base_https_url) + context.getString(C2723R.string.service_path_mdlocation, new Object[]{str, "0"});
    }

    public void getLocationDetail(Context context, String str, String str2, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.get(context, context.getString(C2723R.string.base_https_url) + context.getString(C2723R.string.service_path_mdlocation_detail, new Object[]{str, str2}), (ResponseHandlerInterface) asyncHttpResponseHandler);
    }
}
