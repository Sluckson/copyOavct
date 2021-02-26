package p052cz.msebera.android.httpclient.params;

import p052cz.msebera.android.httpclient.annotation.ThreadSafe;

@ThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.params.SyncBasicHttpParams */
public class SyncBasicHttpParams extends BasicHttpParams {
    private static final long serialVersionUID = 5387834869062660642L;

    public synchronized boolean removeParameter(String str) {
        return super.removeParameter(str);
    }

    public synchronized HttpParams setParameter(String str, Object obj) {
        return super.setParameter(str, obj);
    }

    public synchronized Object getParameter(String str) {
        return super.getParameter(str);
    }

    public synchronized boolean isParameterSet(String str) {
        return super.isParameterSet(str);
    }

    public synchronized boolean isParameterSetLocally(String str) {
        return super.isParameterSetLocally(str);
    }

    public synchronized void setParameters(String[] strArr, Object obj) {
        super.setParameters(strArr, obj);
    }

    public synchronized void clear() {
        super.clear();
    }

    public synchronized Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
