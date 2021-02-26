package com.iaai.android.old.utils.http;

import android.os.Parcelable;
import android.text.TextUtils;
import com.google.inject.Singleton;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Utils;
import com.iaai.android.old.analytics.classes.ReferenceInfo;
import com.iaai.android.old.models.LoginResponse;
import com.iaai.android.old.utils.CryptographicUtils;
import com.iaai.android.old.utils.IAAException;
import com.iaai.android.old.utils.JsonSerializer;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.constants.ErrorType;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.codehaus.jackson.type.TypeReference;
import roboguice.inject.InjectResource;
import roboguice.util.C5058Ln;

@Singleton
public class RestClient {
    private static final String HEADER_AUTHORIZATION = "Authorization";
    @InjectResource(2131820625)
    String baseHttpUrl;
    @InjectResource(2131820622)
    String baseHttpsUrl;
    int retry_counter;
    private SessionManager sessionManager;
    @InjectResource(2131822170)
    String urlLoginService;

    public LoginResponse login(String str, String str2) {
        Request request;
        String str3 = this.baseHttpsUrl + this.urlLoginService;
        C5058Ln.m4829d("Logging in - url[%s]", str3);
        if (!TextUtils.isEmpty(str)) {
            request = new Request.Builder().url(str3).addHeader("Authorization", String.format("%s:%s", new Object[]{str, str2})).addHeader("User-Agent", Utils.getUserAgent()).build();
        } else {
            request = new Request.Builder().url(str3).addHeader("User-Agent", Utils.getUserAgent()).build();
        }
        return (LoginResponse) executeRequest(request, LoginResponse.class, str, str2, "");
    }

    public <T> T execute(String str, Class<? extends T> cls, boolean z) throws Exception {
        return execute(str, (Parcelable) null, cls, z);
    }

    public <T> T execute(String str, Parcelable parcelable, Class<? extends T> cls, boolean z) throws Exception {
        Request request;
        SessionManager sessionManager2 = IaaiApplication.getInstance().getComponent().sessionManager();
        if (!z || sessionManager2.isLoggedIn()) {
            String str2 = (z ? this.baseHttpsUrl : this.baseHttpUrl) + str;
            C5058Ln.m4829d("url[%s]", str2);
            if (parcelable != null) {
                RequestBody create = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JsonSerializer.serialize(parcelable));
                if (!z) {
                    request = new Request.Builder().url(str2).addHeader("User-Agent", Utils.getUserAgent()).post(create).build();
                } else if (str.contains(Constants.VEHICLE_DETAILS) || str.contains(Constants.NEW_VEHICLE_DETAILS) || str.contains(Constants.VEHICLE_SEARCH)) {
                    request = new Request.Builder().url(str2).addHeader("Authorization", String.format("%s:%s", new Object[]{sessionManager2.getCurrentSessionUsername(), sessionManager2.getCurrentSessionPassword()})).addHeader("Signature", getEncryptionSignature()).addHeader("User-Agent", Utils.getUserAgent()).post(create).build();
                } else {
                    request = new Request.Builder().url(str2).addHeader("Authorization", String.format("%s:%s", new Object[]{sessionManager2.getCurrentSessionUsername(), sessionManager2.getCurrentSessionPassword()})).addHeader("User-Agent", Utils.getUserAgent()).post(create).build();
                }
            } else if (z) {
                if (str.contains(Constants.VEHICLE_DETAILS) || str.contains(Constants.NEW_VEHICLE_DETAILS) || str.contains(Constants.VEHICLE_SEARCH)) {
                    request = new Request.Builder().url(str2).addHeader("Authorization", String.format("%s:%s", new Object[]{sessionManager2.getCurrentSessionUsername(), sessionManager2.getCurrentSessionPassword()})).addHeader("Signature", getEncryptionSignature()).addHeader("User-Agent", Utils.getUserAgent()).build();
                } else {
                    request = new Request.Builder().url(str2).addHeader("Authorization", String.format("%s:%s", new Object[]{sessionManager2.getCurrentSessionUsername(), sessionManager2.getCurrentSessionPassword()})).addHeader("User-Agent", Utils.getUserAgent()).build();
                }
            } else if (str.contains(Constants.VEHICLE_DETAILS) || str.contains(Constants.NEW_VEHICLE_DETAILS) || str.contains(Constants.VEHICLE_SEARCH)) {
                request = new Request.Builder().url(str2).addHeader("Signature", getEncryptionSignature()).addHeader("User-Agent", Utils.getUserAgent()).build();
            } else {
                request = new Request.Builder().url(str2).addHeader("User-Agent", Utils.getUserAgent()).build();
            }
            Request request2 = request;
            if (!z) {
                return executeRequest(request2, cls, (String) null, (String) null, str);
            }
            return executeRequest(request2, cls, sessionManager2.getCurrentSessionUsername(), sessionManager2.getCurrentSessionPassword(), str);
        }
        throw new IAAException(ErrorType.LOGIN_REQUIRED, String.format("Login required for restful call. URL[%s]", new Object[]{str}));
    }

    public static String GetUTCdatetimeAsString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.DATE_PATTERN_DATE_TIMEZONE_OFFER, Locale.ENGLISH);
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

    private <T> T executeRequest(Request request, Class<? extends T> cls, String str, String str2, String str3) {
        T t;
        boolean z = !TextUtils.isEmpty(str);
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setFollowRedirects(true);
        if (str3.contains(Constants.VEHICLE_DETAILS) || str3.contains(Constants.NEW_VEHICLE_DETAILS)) {
            okHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);
            okHttpClient.setReadTimeout(30, TimeUnit.SECONDS);
        } else {
            okHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);
            okHttpClient.setReadTimeout(30, TimeUnit.SECONDS);
        }
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            int code = response.code();
            if (code == 401) {
                if (z) {
                    throw new IAAException(ErrorType.INVALID_CREDENTIAL, String.format("Web Service Call Error HttpCode[%d]. Invalid Credential - method[%s] uri[%s]", new Object[]{Integer.valueOf(code), request.method(), request.uri()}));
                }
                throw new IAAException(ErrorType.LOGIN_REQUIRED, String.format("Web Service Call Error HttpCode[%d]. Require Authentication - method[%s] uri[%s]", new Object[]{Integer.valueOf(code), request.method(), request.uri()}));
            } else if (code != 403) {
                if (code == 400 || code == 500 || code == 404) {
                    this.retry_counter++;
                    if (this.retry_counter < 4) {
                        executeRequest(request, cls, str, str2, str3);
                    } else {
                        this.retry_counter = 0;
                        throw new IAAException(ErrorType.SERVER_ERROR, "Web Service Call Error. HttpCode[" + code + "]");
                    }
                } else if (code != 200) {
                    throw new IAAException(ErrorType.SERVER_ERROR, "Web Service Call Error. HttpCode[" + code + "]");
                }
                InputStream byteStream = response.body().byteStream();
                if (String.class.isAssignableFrom(cls)) {
                    t = JsonSerializer.slurp(byteStream);
                    C5058Ln.m4829d("Response String - %s", t);
                } else {
                    t = JsonSerializer.deserialize(byteStream, cls);
                }
                if (response != null) {
                    try {
                        response.body().close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                C5058Ln.m4829d("returning response", new Object[0]);
                return t;
            } else {
                throw new IAAException(ErrorType.INSUFFICIENT_PERMISSIONS, String.format("Web Service Call Error HttpCode[%d]. Insufficient permissions - method[%s] uri[%s]", new Object[]{Integer.valueOf(code), request.method(), request.uri()}));
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            C5058Ln.m4833e(e2);
            throw new IAAException(ErrorType.CONNECTION_ERROR);
        } catch (Throwable th) {
            if (response != null) {
                try {
                    response.body().close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    public <T> List<T> executeAnalytics(String str, Parcelable parcelable, Class<? extends T> cls, boolean z, TypeReference<List<ReferenceInfo>> typeReference) throws Exception {
        Request request;
        SessionManager sessionManager2 = IaaiApplication.getInstance().getComponent().sessionManager();
        if (!z || sessionManager2.isLoggedIn()) {
            String str2 = (z ? this.baseHttpsUrl : this.baseHttpUrl) + str;
            C5058Ln.m4829d("executeAnalytics url[%s]", str2);
            if (parcelable != null) {
                RequestBody create = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), JsonSerializer.serialize(parcelable));
                if (z) {
                    request = new Request.Builder().url(str2).addHeader("Authorization", String.format("%s:%s", new Object[]{sessionManager2.getCurrentSessionUsername(), sessionManager2.getCurrentSessionPassword()})).addHeader("User-Agent", Utils.getUserAgent()).post(create).build();
                } else {
                    request = new Request.Builder().url(str2).post(create).addHeader("User-Agent", Utils.getUserAgent()).build();
                }
            } else if (z) {
                request = new Request.Builder().url(str2).addHeader("Authorization", String.format("%s:%s", new Object[]{sessionManager2.getCurrentSessionUsername(), sessionManager2.getCurrentSessionPassword()})).addHeader("User-Agent", Utils.getUserAgent()).build();
            } else {
                request = new Request.Builder().url(str2).addHeader("User-Agent", Utils.getUserAgent()).build();
            }
            Request request2 = request;
            if (!z) {
                return executeRequestAnalytics(request2, cls, (String) null, (String) null, typeReference);
            }
            return executeRequestAnalytics(request2, cls, sessionManager2.getCurrentSessionUsername(), sessionManager2.getCurrentSessionPassword(), typeReference);
        }
        throw new IAAException(ErrorType.LOGIN_REQUIRED, String.format("Login required for restful call. URL[%s]", new Object[]{str}));
    }

    private <T> List<T> executeRequestAnalytics(Request request, Class<? extends T> cls, String str, String str2, TypeReference typeReference) {
        boolean z = !TextUtils.isEmpty(str);
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setFollowRedirects(true);
        okHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);
        okHttpClient.setReadTimeout(30, TimeUnit.SECONDS);
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            int code = response.code();
            if (code == 401) {
                if (z) {
                    throw new IAAException(ErrorType.INVALID_CREDENTIAL, String.format("Web Service Call Error HttpCode[%d]. Invalid Credential - method[%s] uri[%s]", new Object[]{Integer.valueOf(code), request.method(), request.uri()}));
                }
                throw new IAAException(ErrorType.LOGIN_REQUIRED, String.format("Web Service Call Error HttpCode[%d]. Require Authentication - method[%s] uri[%s]", new Object[]{Integer.valueOf(code), request.method(), request.uri()}));
            } else if (code != 403) {
                if (code == 400 || code == 500 || code == 404) {
                    this.retry_counter++;
                    if (this.retry_counter < 4) {
                        executeRequestAnalytics(request, cls, str, str2, typeReference);
                    } else {
                        this.retry_counter = 0;
                        throw new IAAException(ErrorType.SERVER_ERROR, "Web Service Call Error. HttpCode[" + code + "]");
                    }
                } else if (code != 200) {
                    throw new IAAException(ErrorType.SERVER_ERROR, "Web Service Call Error. HttpCode[" + code + "]");
                }
                List<T> deserializeList = JsonSerializer.deserializeList(response.body().byteStream(), typeReference);
                if (response != null) {
                    try {
                        response.body().close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                C5058Ln.m4829d("Analytics returning response", new Object[0]);
                return deserializeList;
            } else {
                throw new IAAException(ErrorType.INSUFFICIENT_PERMISSIONS, String.format("Web Service Call Error HttpCode[%d]. Insufficient permissions - method[%s] uri[%s]", new Object[]{Integer.valueOf(code), request.method(), request.uri()}));
            }
        } catch (IOException e2) {
            C5058Ln.m4833e(e2);
            throw new IAAException(ErrorType.CONNECTION_ERROR);
        } catch (Throwable th) {
            if (response != null) {
                try {
                    response.body().close();
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }
}
