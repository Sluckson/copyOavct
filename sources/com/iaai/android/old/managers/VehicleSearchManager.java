package com.iaai.android.old.managers;

import android.content.Context;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.utils.CryptographicUtils;
import com.iaai.android.old.utils.constants.Constants;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import p052cz.msebera.android.httpclient.entity.ByteArrayEntity;

public class VehicleSearchManager {
    private static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;

    @Inject
    private VehicleSearchManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
        client.addHeader("User-Agent", Utils.getUserAgent());
    }

    public void getVehiclesSearchResult(Context context, String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        ByteArrayEntity byteArrayEntity;
        String str2 = this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_path_vehicle_search);
        try {
            byteArrayEntity = new ByteArrayEntity(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            byteArrayEntity = null;
        }
        client.addHeader("Signature", getEncryptionSignature());
        client.post(context, str2, byteArrayEntity, "application/json", asyncHttpResponseHandler);
        client.setTimeout(60000);
    }

    public void getSearchResultRefiner(Context context, String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        ByteArrayEntity byteArrayEntity;
        String str2 = this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_path_search_refiners);
        try {
            byteArrayEntity = new ByteArrayEntity(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            byteArrayEntity = null;
        }
        client.post(context, str2, byteArrayEntity, "application/json", asyncHttpResponseHandler);
        client.setTimeout(30000);
    }

    public void getPopularCategories(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String string = this.application.getResources().getString(C2723R.string.service_path_get_popular_category_refiners);
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + string, asyncHttpResponseHandler);
        client.setTimeout(60000);
        client.setEnableRedirects(true, true, true);
    }

    public void getPageSize(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String string = this.application.getResources().getString(C2723R.string.service_path_get_page_size);
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + string, asyncHttpResponseHandler);
        client.setTimeout(60000);
        client.setEnableRedirects(true, true, true);
    }

    public static String GetUTCdatetimeAsString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIMEZONE_OFFER);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }

    private String getEncryptionSignature() {
        try {
            return new CryptographicUtils().encrypt(GetUTCdatetimeAsString(), "IAAIBeatles$229");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return "";
        } catch (NoSuchPaddingException e4) {
            e4.printStackTrace();
            return "";
        } catch (InvalidAlgorithmParameterException e5) {
            e5.printStackTrace();
            return "";
        } catch (IllegalBlockSizeException e6) {
            e6.printStackTrace();
            return "";
        } catch (BadPaddingException e7) {
            e7.printStackTrace();
            return "";
        }
    }

    public void getAdditionalRefiner(Context context, String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        ByteArrayEntity byteArrayEntity;
        String str2 = this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_path_additional_refiner);
        try {
            byteArrayEntity = new ByteArrayEntity(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            byteArrayEntity = null;
        }
        client.post(context, str2, byteArrayEntity, "application/json", asyncHttpResponseHandler);
        client.setTimeout(30000);
    }

    public void getDefaultRefiner(Context context, String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        ByteArrayEntity byteArrayEntity;
        String str2 = this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_path_default_refiners);
        try {
            byteArrayEntity = new ByteArrayEntity(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            byteArrayEntity = null;
        }
        client.post(context, str2, byteArrayEntity, "application/json", asyncHttpResponseHandler);
        client.setTimeout(30000);
    }

    public void getDefaultAuctions(Context context, String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        ByteArrayEntity byteArrayEntity;
        String str2 = this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_path_default_auctions);
        try {
            byteArrayEntity = new ByteArrayEntity(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            byteArrayEntity = null;
        }
        client.post(context, str2, byteArrayEntity, "application/json", asyncHttpResponseHandler);
        client.setTimeout(30000);
    }

    public void getLatLongBasedOnZIPCode(String str, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        String string = this.application.getResources().getString(C2723R.string.new_service_path_vehicle_search_lat_long_based_zipcode, new Object[]{str});
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + string, asyncHttpResponseHandler);
    }
}
