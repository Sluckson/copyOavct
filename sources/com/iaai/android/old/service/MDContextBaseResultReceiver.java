package com.iaai.android.old.service;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import android.widget.Toast;
import com.iaai.android.C2723R;
import com.iaai.android.old.utils.constants.Constants;
import com.iaai.android.old.utils.constants.ErrorType;
import com.iaai.android.old.utils.p016ui.IDisposable;
import java.lang.ref.WeakReference;
import roboguice.util.C5058Ln;

public abstract class MDContextBaseResultReceiver<TContext extends Context, TResult> extends ResultReceiver implements IDisposable {
    private WeakReference<TContext> contextRef;
    private WeakReference<Handler> handlerRef;

    /* access modifiers changed from: protected */
    public void beforeResultHandled(TContext tcontext) {
    }

    /* access modifiers changed from: protected */
    public void onInvalidCredential(TContext tcontext) {
    }

    /* access modifiers changed from: protected */
    public void onNetworkError(TContext tcontext, String str) {
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(TContext tcontext) {
    }

    /* access modifiers changed from: protected */
    public void onPreExecute(TContext tcontext) {
    }

    /* access modifiers changed from: protected */
    public abstract void onSuccess(TContext tcontext, TResult tresult);

    public MDContextBaseResultReceiver(TContext tcontext, Handler handler) {
        super(handler);
        this.contextRef = new WeakReference<>(tcontext);
        this.handlerRef = new WeakReference<>(handler);
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i, Bundle bundle) {
        String str;
        Context context = getContext();
        if (context == null) {
            C5058Ln.m4841w("Lost reference to activity, result ignored.", new Object[0]);
            return;
        }
        if (i == 0) {
            onPreExecute(context);
        } else if (i == 1) {
            beforeResultHandled(context);
            Object obj = null;
            if (bundle.containsKey(Constants.EXTRA_RESULT)) {
                obj = bundle.get(Constants.EXTRA_RESULT);
            }
            onSuccess(context, obj);
        } else if (i == 2) {
            beforeResultHandled(context);
            String string = bundle.getString("android.intent.extra.TEXT");
            ErrorType errorType = (ErrorType) bundle.get("errorType");
            if (errorType == null) {
                errorType = ErrorType.GENERAL;
            }
            Object[] objArr = new Object[3];
            objArr[0] = bundle.getString(Constants.EXTRA_COMMAND);
            if (errorType == null) {
                str = "";
            } else {
                str = errorType.toString();
            }
            objArr[1] = str;
            objArr[2] = string;
            C5058Ln.m4832e("Result receiver - Command[%s] ErrorType[%s] Message[%s]", objArr);
            if (ErrorType.LOGIN_REQUIRED.equals(errorType)) {
                onLoginRequired(context);
            } else if (ErrorType.CONNECTION_ERROR.equals(errorType)) {
                onNetworkError(context, string);
            } else if (ErrorType.INVALID_CREDENTIAL.equals(errorType)) {
                onInvalidCredential(context);
            } else {
                onTimeOutError(context, string);
                onError(context, string);
            }
        } else if (i == 3) {
            try {
                beforeResultHandled(context);
                onFailure(context, bundle.getString("android.intent.extra.TEXT"));
            } catch (Throwable th) {
                if (i != 0) {
                    onPostExecute(context);
                }
                throw th;
            }
        }
        if (i != 0) {
            onPostExecute(context);
        }
    }

    public TContext getContext() {
        WeakReference<TContext> weakReference = this.contextRef;
        if (weakReference == null) {
            return null;
        }
        return (Context) weakReference.get();
    }

    public Handler getHandler() {
        WeakReference<Handler> weakReference = this.handlerRef;
        if (weakReference == null) {
            return null;
        }
        return (Handler) weakReference.get();
    }

    /* access modifiers changed from: protected */
    public void onLoginRequired(TContext tcontext) {
        Toast.makeText(tcontext, C2723R.string.msg_login_required_error, 0).show();
    }

    /* access modifiers changed from: protected */
    public void onConnectionError(TContext tcontext, String str) {
        Toast.makeText(tcontext, C2723R.string.msg_network_error, 0).show();
    }

    /* access modifiers changed from: protected */
    public void onFailure(TContext tcontext, String str) {
        C5058Ln.m4841w("Failure is not handled. Message[%s]", str);
    }

    /* access modifiers changed from: protected */
    public void onTimeOutError(TContext tcontext, String str) {
        C5058Ln.m4841w("Error is not handled. Message[%s]", str);
    }

    /* access modifiers changed from: protected */
    public void onError(TContext tcontext, String str) {
        C5058Ln.m4841w("Error is not handled. Message[%s]", str);
    }

    public void dispose() {
        WeakReference<TContext> weakReference = this.contextRef;
        if (weakReference != null) {
            weakReference.clear();
            this.contextRef = null;
        }
        WeakReference<Handler> weakReference2 = this.handlerRef;
        if (weakReference2 != null) {
            weakReference2.clear();
            this.handlerRef = null;
        }
    }
}
