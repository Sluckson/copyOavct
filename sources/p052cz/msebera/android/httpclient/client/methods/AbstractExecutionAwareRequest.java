package p052cz.msebera.android.httpclient.client.methods;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.client.utils.CloneUtils;
import p052cz.msebera.android.httpclient.concurrent.Cancellable;
import p052cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import p052cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import p052cz.msebera.android.httpclient.message.AbstractHttpMessage;
import p052cz.msebera.android.httpclient.message.HeaderGroup;
import p052cz.msebera.android.httpclient.params.HttpParams;

/* renamed from: cz.msebera.android.httpclient.client.methods.AbstractExecutionAwareRequest */
public abstract class AbstractExecutionAwareRequest extends AbstractHttpMessage implements HttpExecutionAware, AbortableHttpRequest, Cloneable, HttpRequest {
    private final AtomicBoolean aborted = new AtomicBoolean(false);
    private final AtomicReference<Cancellable> cancellableRef = new AtomicReference<>((Object) null);

    protected AbstractExecutionAwareRequest() {
    }

    @Deprecated
    public void setConnectionRequest(final ClientConnectionRequest clientConnectionRequest) {
        setCancellable(new Cancellable() {
            public boolean cancel() {
                clientConnectionRequest.abortRequest();
                return true;
            }
        });
    }

    @Deprecated
    public void setReleaseTrigger(final ConnectionReleaseTrigger connectionReleaseTrigger) {
        setCancellable(new Cancellable() {
            public boolean cancel() {
                try {
                    connectionReleaseTrigger.abortConnection();
                    return true;
                } catch (IOException unused) {
                    return false;
                }
            }
        });
    }

    public void abort() {
        Cancellable andSet;
        if (this.aborted.compareAndSet(false, true) && (andSet = this.cancellableRef.getAndSet((Object) null)) != null) {
            andSet.cancel();
        }
    }

    public boolean isAborted() {
        return this.aborted.get();
    }

    public void setCancellable(Cancellable cancellable) {
        if (!this.aborted.get()) {
            this.cancellableRef.set(cancellable);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        AbstractExecutionAwareRequest abstractExecutionAwareRequest = (AbstractExecutionAwareRequest) super.clone();
        abstractExecutionAwareRequest.headergroup = (HeaderGroup) CloneUtils.cloneObject(this.headergroup);
        abstractExecutionAwareRequest.params = (HttpParams) CloneUtils.cloneObject(this.params);
        return abstractExecutionAwareRequest;
    }

    public void completed() {
        this.cancellableRef.set((Object) null);
    }

    public void reset() {
        Cancellable andSet = this.cancellableRef.getAndSet((Object) null);
        if (andSet != null) {
            andSet.cancel();
        }
        this.aborted.set(false);
    }
}
