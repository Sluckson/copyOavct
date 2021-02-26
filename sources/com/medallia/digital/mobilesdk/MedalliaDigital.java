package com.medallia.digital.mobilesdk;

import android.app.Activity;
import android.app.Application;
import com.medallia.digital.mobilesdk.C3815z4;
import com.medallia.digital.mobilesdk.MDExternalError;
import java.util.HashMap;

public class MedalliaDigital {
    private static C3786x2 killSwitch = new C3786x2();
    private static C3615m3 medalliaDigitalBrain;

    public static void disableIntercept() {
        if (isSdkStopped()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED).getMessage());
        } else if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
        } else {
            initMedalliaDigitalBrainIfNecessary();
            medalliaDigitalBrain.mo55576a(false);
        }
    }

    public static void enableIntercept() {
        if (isSdkStopped()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED).getMessage());
        } else if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
        } else {
            initMedalliaDigitalBrainIfNecessary();
            medalliaDigitalBrain.mo55576a(true);
        }
    }

    public static void handleNotification(String str, MDResultCallback mDResultCallback) {
        if (isSdkStopped()) {
            MDExternalError mDExternalError = new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED);
            C3490e3.m663c(mDExternalError.getMessage());
            mDResultCallback.onError(mDExternalError);
        } else if (isSdkKilled()) {
            MDExternalError mDExternalError2 = new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED);
            C3490e3.m663c(mDExternalError2.getMessage());
            mDResultCallback.onError(mDExternalError2);
        } else {
            initMedalliaDigitalBrainIfNecessary();
            medalliaDigitalBrain.mo55573a(str, mDResultCallback);
        }
    }

    public static void init(Application application, String str, MDResultCallback mDResultCallback) {
        if (application == null) {
            mDResultCallback.onError(new MDExternalError(MDExternalError.ExternalError.APPLICATION_IS_NULL));
            return;
        }
        if (C3595k3.m1060d().mo55513b() == null) {
            C3595k3.m1058a(application);
            if (isSdkStopped()) {
                mDResultCallback.onError(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED));
                return;
            }
            C3461c3.m562g();
        }
        if (isSdkStopped()) {
            mDResultCallback.onError(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED));
            return;
        }
        C3490e3.m665e("SDK init started");
        initMedalliaDigitalBrainIfNecessary();
        medalliaDigitalBrain.mo55580b(str, mDResultCallback);
    }

    private static void initMedalliaDigitalBrainIfNecessary() {
        if (medalliaDigitalBrain == null) {
            medalliaDigitalBrain = new C3615m3();
        }
    }

    private static boolean isSdkKilled() {
        return killSwitch.mo55921b();
    }

    private static boolean isSdkStopped() {
        return C3815z4.m2010d().mo55979a(C3815z4.C3816a.SDK_STOPPED, false);
    }

    public static void revertStopSDK() {
        if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
            return;
        }
        initMedalliaDigitalBrainIfNecessary();
        medalliaDigitalBrain.mo55583c();
    }

    public static void setActivity(Activity activity) {
        C3490e3.m665e("setActivity was called");
        if (isSdkStopped()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED).getMessage());
        } else if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
        } else {
            initMedalliaDigitalBrainIfNecessary();
            medalliaDigitalBrain.mo55564a(activity);
        }
    }

    public static void setCustomParameter(String str, Object obj) {
        if (isSdkStopped()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED).getMessage());
        } else if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
        } else {
            initMedalliaDigitalBrainIfNecessary();
            medalliaDigitalBrain.mo55574a(str, obj);
        }
    }

    public static void setCustomParameters(HashMap<String, Object> hashMap) {
        if (isSdkStopped()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED).getMessage());
        } else if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
        } else {
            initMedalliaDigitalBrainIfNecessary();
            medalliaDigitalBrain.mo55575a(hashMap);
        }
    }

    public static void setFeedbackListener(MDFeedbackListener mDFeedbackListener) {
        if (isSdkStopped()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED).getMessage());
        } else if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
        } else {
            initMedalliaDigitalBrainIfNecessary();
            medalliaDigitalBrain.mo55565a(mDFeedbackListener);
        }
    }

    @Deprecated
    public static void setFormListener(MDFormListener mDFormListener) {
        if (isSdkStopped()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED).getMessage());
        } else if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
        } else {
            initMedalliaDigitalBrainIfNecessary();
            medalliaDigitalBrain.mo55566a(mDFormListener);
        }
    }

    public static void setFormListener(MDFormListenerV2 mDFormListenerV2) {
        if (isSdkStopped()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED).getMessage());
        } else if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
        } else {
            initMedalliaDigitalBrainIfNecessary();
            medalliaDigitalBrain.mo55567a(mDFormListenerV2);
        }
    }

    @Deprecated
    public static void setInterceptListener(MDInterceptListener mDInterceptListener) {
        if (isSdkStopped()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED).getMessage());
        } else if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
        } else {
            initMedalliaDigitalBrainIfNecessary();
            medalliaDigitalBrain.mo55568a(mDInterceptListener);
        }
    }

    public static void setInterceptV3Listener(MDInterceptV3Listener mDInterceptV3Listener) {
        if (isSdkStopped()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED).getMessage());
        } else if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
        } else {
            initMedalliaDigitalBrainIfNecessary();
            medalliaDigitalBrain.mo55569a(mDInterceptV3Listener);
        }
    }

    @Deprecated
    public static void setInvitationListener(MDInvitationListener mDInvitationListener) {
        if (isSdkStopped()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED).getMessage());
        } else if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
        } else {
            initMedalliaDigitalBrainIfNecessary();
            medalliaDigitalBrain.mo55570a(mDInvitationListener);
        }
    }

    public static void setLogLevel(MDLogLevel mDLogLevel) {
        if (isSdkStopped()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED).getMessage());
        } else if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
        } else {
            initMedalliaDigitalBrainIfNecessary();
            medalliaDigitalBrain.mo55571a(mDLogLevel);
        }
    }

    public static void setSdkFramework(MDSdkFrameworkType mDSdkFrameworkType) {
        C3490e3.m665e("setSdkFramework was called");
        if (isSdkStopped()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED).getMessage());
        } else if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
        } else {
            initMedalliaDigitalBrainIfNecessary();
            medalliaDigitalBrain.mo55572a(mDSdkFrameworkType);
        }
    }

    public static void showForm(String str, MDResultCallback mDResultCallback) {
        MDExternalError mDExternalError;
        C3490e3.m665e("Show form was called");
        if (isSdkStopped()) {
            mDExternalError = new MDExternalError(MDExternalError.ExternalError.SDK_WAS_STOPPED);
        } else if (isSdkKilled()) {
            mDExternalError = new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED);
        } else {
            C3615m3 m3Var = medalliaDigitalBrain;
            if (m3Var != null) {
                m3Var.mo55584c(str, mDResultCallback);
                return;
            } else if (mDResultCallback != null) {
                MDExternalError mDExternalError2 = new MDExternalError(MDExternalError.ExternalError.SDK_NOT_INITIALIZED);
                C3490e3.m663c(mDExternalError2.getMessage());
                mDResultCallback.onError(mDExternalError2);
                return;
            } else {
                return;
            }
        }
        C3490e3.m663c(mDExternalError.getMessage());
        mDResultCallback.onError(mDExternalError);
    }

    public static void stopSDK(boolean z) {
        if (isSdkKilled()) {
            C3490e3.m663c(new MDExternalError(MDExternalError.ExternalError.SDK_IS_KILLED).getMessage());
            return;
        }
        initMedalliaDigitalBrainIfNecessary();
        medalliaDigitalBrain.mo55581b(z);
    }
}
