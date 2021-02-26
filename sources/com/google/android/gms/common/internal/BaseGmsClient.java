package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

@KeepForSdk
/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public abstract class BaseGmsClient<T extends IInterface> {
    @KeepForSdk
    public static final int CONNECT_STATE_CONNECTED = 4;
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    @KeepForSdk
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    @KeepForSdk
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private static final Feature[] zzce = new Feature[0];
    private final Context mContext;
    final Handler mHandler;
    private final Object mLock;
    private int zzcf;
    private long zzcg;
    private long zzch;
    private int zzci;
    private long zzcj;
    @VisibleForTesting
    private zzh zzck;
    private final Looper zzcl;
    private final GmsClientSupervisor zzcm;
    private final GoogleApiAvailabilityLight zzcn;
    /* access modifiers changed from: private */
    public final Object zzco;
    /* access modifiers changed from: private */
    @GuardedBy("mServiceBrokerLock")
    public IGmsServiceBroker zzcp;
    @VisibleForTesting
    protected ConnectionProgressReportCallbacks zzcq;
    @GuardedBy("mLock")
    private T zzcr;
    /* access modifiers changed from: private */
    public final ArrayList<zzc<?>> zzcs;
    @GuardedBy("mLock")
    private zzd zzct;
    @GuardedBy("mLock")
    private int zzcu;
    /* access modifiers changed from: private */
    public final BaseConnectionCallbacks zzcv;
    /* access modifiers changed from: private */
    public final BaseOnConnectionFailedListener zzcw;
    private final int zzcx;
    private final String zzcy;
    /* access modifiers changed from: private */
    public ConnectionResult zzcz;
    /* access modifiers changed from: private */
    public boolean zzda;
    private volatile zzc zzdb;
    @VisibleForTesting
    protected AtomicInteger zzdc;

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    public interface BaseConnectionCallbacks {
        @KeepForSdk
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        @KeepForSdk
        void onConnected(@Nullable Bundle bundle);

        @KeepForSdk
        void onConnectionSuspended(int i);
    }

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    public interface BaseOnConnectionFailedListener {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        void onReportServiceBinding(@NonNull ConnectionResult connectionResult);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    protected class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        @KeepForSdk
        public LegacyClientCallbackAdapter() {
        }

        public void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.getRemoteService((IAccountAccessor) null, baseGmsClient.getScopes());
            } else if (BaseGmsClient.this.zzcw != null) {
                BaseGmsClient.this.zzcw.onConnectionFailed(connectionResult);
            }
        }
    }

    @KeepForSdk
    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    public interface SignOutCallbacks {
        @KeepForSdk
        void onSignOutComplete();
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Nullable
    public abstract T createServiceInterface(IBinder iBinder);

    /* access modifiers changed from: protected */
    @KeepForSdk
    public boolean enableLocalFallback() {
        return false;
    }

    @KeepForSdk
    public Account getAccount() {
        return null;
    }

    @KeepForSdk
    public Bundle getConnectionHint() {
        return null;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @Nullable
    public String getLocalStartServiceAction() {
        return null;
    }

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public abstract String getServiceDescriptor();

    /* access modifiers changed from: protected */
    @NonNull
    @KeepForSdk
    public abstract String getStartServiceAction();

    /* access modifiers changed from: protected */
    @KeepForSdk
    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public boolean getUseDynamicLookup() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @KeepForSdk
    public void onSetConnectState(int i, T t) {
    }

    @KeepForSdk
    public boolean providesSignIn() {
        return false;
    }

    @KeepForSdk
    public boolean requiresAccount() {
        return false;
    }

    @KeepForSdk
    public boolean requiresGooglePlayServices() {
        return true;
    }

    @KeepForSdk
    public boolean requiresSignIn() {
        return false;
    }

    @KeepForSdk
    protected BaseGmsClient(Context context, Looper looper, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailabilityLight.getInstance(), i, (BaseConnectionCallbacks) Preconditions.checkNotNull(baseConnectionCallbacks), (BaseOnConnectionFailedListener) Preconditions.checkNotNull(baseOnConnectionFailedListener), str);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    final class zzb extends zzi {
        public zzb(Looper looper) {
            super(looper);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v24, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: android.app.PendingIntent} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void handleMessage(android.os.Message r8) {
            /*
                r7 = this;
                com.google.android.gms.common.internal.BaseGmsClient r0 = com.google.android.gms.common.internal.BaseGmsClient.this
                java.util.concurrent.atomic.AtomicInteger r0 = r0.zzdc
                int r0 = r0.get()
                int r1 = r8.arg1
                if (r0 == r1) goto L_0x0016
                boolean r0 = zzb(r8)
                if (r0 == 0) goto L_0x0015
                zza(r8)
            L_0x0015:
                return
            L_0x0016:
                int r0 = r8.what
                r1 = 4
                r2 = 1
                r3 = 5
                if (r0 == r2) goto L_0x0032
                int r0 = r8.what
                r4 = 7
                if (r0 == r4) goto L_0x0032
                int r0 = r8.what
                if (r0 != r1) goto L_0x002e
                com.google.android.gms.common.internal.BaseGmsClient r0 = com.google.android.gms.common.internal.BaseGmsClient.this
                boolean r0 = r0.enableLocalFallback()
                if (r0 == 0) goto L_0x0032
            L_0x002e:
                int r0 = r8.what
                if (r0 != r3) goto L_0x003e
            L_0x0032:
                com.google.android.gms.common.internal.BaseGmsClient r0 = com.google.android.gms.common.internal.BaseGmsClient.this
                boolean r0 = r0.isConnecting()
                if (r0 != 0) goto L_0x003e
                zza(r8)
                return
            L_0x003e:
                int r0 = r8.what
                r4 = 8
                r5 = 3
                r6 = 0
                if (r0 != r1) goto L_0x0089
                com.google.android.gms.common.internal.BaseGmsClient r0 = com.google.android.gms.common.internal.BaseGmsClient.this
                com.google.android.gms.common.ConnectionResult r1 = new com.google.android.gms.common.ConnectionResult
                int r8 = r8.arg2
                r1.<init>(r8)
                com.google.android.gms.common.ConnectionResult unused = r0.zzcz = r1
                com.google.android.gms.common.internal.BaseGmsClient r8 = com.google.android.gms.common.internal.BaseGmsClient.this
                boolean r8 = r8.zzl()
                if (r8 == 0) goto L_0x0068
                com.google.android.gms.common.internal.BaseGmsClient r8 = com.google.android.gms.common.internal.BaseGmsClient.this
                boolean r8 = r8.zzda
                if (r8 != 0) goto L_0x0068
                com.google.android.gms.common.internal.BaseGmsClient r8 = com.google.android.gms.common.internal.BaseGmsClient.this
                r8.zza((int) r5, null)
                return
            L_0x0068:
                com.google.android.gms.common.internal.BaseGmsClient r8 = com.google.android.gms.common.internal.BaseGmsClient.this
                com.google.android.gms.common.ConnectionResult r8 = r8.zzcz
                if (r8 == 0) goto L_0x0077
                com.google.android.gms.common.internal.BaseGmsClient r8 = com.google.android.gms.common.internal.BaseGmsClient.this
                com.google.android.gms.common.ConnectionResult r8 = r8.zzcz
                goto L_0x007c
            L_0x0077:
                com.google.android.gms.common.ConnectionResult r8 = new com.google.android.gms.common.ConnectionResult
                r8.<init>(r4)
            L_0x007c:
                com.google.android.gms.common.internal.BaseGmsClient r0 = com.google.android.gms.common.internal.BaseGmsClient.this
                com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks r0 = r0.zzcq
                r0.onReportServiceBinding(r8)
                com.google.android.gms.common.internal.BaseGmsClient r0 = com.google.android.gms.common.internal.BaseGmsClient.this
                r0.onConnectionFailed(r8)
                return
            L_0x0089:
                int r0 = r8.what
                if (r0 != r3) goto L_0x00ae
                com.google.android.gms.common.internal.BaseGmsClient r8 = com.google.android.gms.common.internal.BaseGmsClient.this
                com.google.android.gms.common.ConnectionResult r8 = r8.zzcz
                if (r8 == 0) goto L_0x009c
                com.google.android.gms.common.internal.BaseGmsClient r8 = com.google.android.gms.common.internal.BaseGmsClient.this
                com.google.android.gms.common.ConnectionResult r8 = r8.zzcz
                goto L_0x00a1
            L_0x009c:
                com.google.android.gms.common.ConnectionResult r8 = new com.google.android.gms.common.ConnectionResult
                r8.<init>(r4)
            L_0x00a1:
                com.google.android.gms.common.internal.BaseGmsClient r0 = com.google.android.gms.common.internal.BaseGmsClient.this
                com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks r0 = r0.zzcq
                r0.onReportServiceBinding(r8)
                com.google.android.gms.common.internal.BaseGmsClient r0 = com.google.android.gms.common.internal.BaseGmsClient.this
                r0.onConnectionFailed(r8)
                return
            L_0x00ae:
                int r0 = r8.what
                if (r0 != r5) goto L_0x00d1
                java.lang.Object r0 = r8.obj
                boolean r0 = r0 instanceof android.app.PendingIntent
                if (r0 == 0) goto L_0x00bd
                java.lang.Object r0 = r8.obj
                r6 = r0
                android.app.PendingIntent r6 = (android.app.PendingIntent) r6
            L_0x00bd:
                com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult
                int r8 = r8.arg2
                r0.<init>(r8, r6)
                com.google.android.gms.common.internal.BaseGmsClient r8 = com.google.android.gms.common.internal.BaseGmsClient.this
                com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks r8 = r8.zzcq
                r8.onReportServiceBinding(r0)
                com.google.android.gms.common.internal.BaseGmsClient r8 = com.google.android.gms.common.internal.BaseGmsClient.this
                r8.onConnectionFailed(r0)
                return
            L_0x00d1:
                int r0 = r8.what
                r1 = 6
                if (r0 != r1) goto L_0x00fb
                com.google.android.gms.common.internal.BaseGmsClient r0 = com.google.android.gms.common.internal.BaseGmsClient.this
                r0.zza((int) r3, null)
                com.google.android.gms.common.internal.BaseGmsClient r0 = com.google.android.gms.common.internal.BaseGmsClient.this
                com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks r0 = r0.zzcv
                if (r0 == 0) goto L_0x00ee
                com.google.android.gms.common.internal.BaseGmsClient r0 = com.google.android.gms.common.internal.BaseGmsClient.this
                com.google.android.gms.common.internal.BaseGmsClient$BaseConnectionCallbacks r0 = r0.zzcv
                int r1 = r8.arg2
                r0.onConnectionSuspended(r1)
            L_0x00ee:
                com.google.android.gms.common.internal.BaseGmsClient r0 = com.google.android.gms.common.internal.BaseGmsClient.this
                int r8 = r8.arg2
                r0.onConnectionSuspended(r8)
                com.google.android.gms.common.internal.BaseGmsClient r8 = com.google.android.gms.common.internal.BaseGmsClient.this
                boolean unused = r8.zza((int) r3, (int) r2, r6)
                return
            L_0x00fb:
                int r0 = r8.what
                r1 = 2
                if (r0 != r1) goto L_0x010c
                com.google.android.gms.common.internal.BaseGmsClient r0 = com.google.android.gms.common.internal.BaseGmsClient.this
                boolean r0 = r0.isConnected()
                if (r0 != 0) goto L_0x010c
                zza(r8)
                return
            L_0x010c:
                boolean r0 = zzb(r8)
                if (r0 == 0) goto L_0x011a
                java.lang.Object r8 = r8.obj
                com.google.android.gms.common.internal.BaseGmsClient$zzc r8 = (com.google.android.gms.common.internal.BaseGmsClient.zzc) r8
                r8.zzo()
                return
            L_0x011a:
                int r8 = r8.what
                r0 = 45
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>(r0)
                java.lang.String r0 = "Don't know how to handle message: "
                r1.append(r0)
                r1.append(r8)
                java.lang.String r8 = r1.toString()
                java.lang.Exception r0 = new java.lang.Exception
                r0.<init>()
                java.lang.String r1 = "GmsClient"
                android.util.Log.wtf(r1, r8, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.BaseGmsClient.zzb.handleMessage(android.os.Message):void");
        }

        private static void zza(Message message) {
            zzc zzc = (zzc) message.obj;
            zzc.zzn();
            zzc.unregister();
        }

        private static boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 7;
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    protected final class zzg extends zza {
        @BinderThread
        public zzg(int i, @Nullable Bundle bundle) {
            super(i, (Bundle) null);
        }

        /* access modifiers changed from: protected */
        public final void zza(ConnectionResult connectionResult) {
            if (!BaseGmsClient.this.enableLocalFallback() || !BaseGmsClient.this.zzl()) {
                BaseGmsClient.this.zzcq.onReportServiceBinding(connectionResult);
                BaseGmsClient.this.onConnectionFailed(connectionResult);
                return;
            }
            BaseGmsClient.this.zzb(16);
        }

        /* access modifiers changed from: protected */
        public final boolean zzm() {
            BaseGmsClient.this.zzcq.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
            return true;
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    protected abstract class zzc<TListener> {
        private TListener zzdf;
        private boolean zzdg = false;

        public zzc(TListener tlistener) {
            this.zzdf = tlistener;
        }

        /* access modifiers changed from: protected */
        public abstract void zza(TListener tlistener);

        /* access modifiers changed from: protected */
        public abstract void zzn();

        public final void zzo() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.zzdf;
                if (this.zzdg) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    zza(tlistener);
                } catch (RuntimeException e) {
                    zzn();
                    throw e;
                }
            } else {
                zzn();
            }
            synchronized (this) {
                this.zzdg = true;
            }
            unregister();
        }

        public final void unregister() {
            removeListener();
            synchronized (BaseGmsClient.this.zzcs) {
                BaseGmsClient.this.zzcs.remove(this);
            }
        }

        public final void removeListener() {
            synchronized (this) {
                this.zzdf = null;
            }
        }
    }

    @VisibleForTesting
    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    public final class zzd implements ServiceConnection {
        private final int zzdh;

        public zzd(int i) {
            this.zzdh = i;
        }

        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IGmsServiceBroker iGmsServiceBroker;
            if (iBinder == null) {
                BaseGmsClient.this.zzb(16);
                return;
            }
            synchronized (BaseGmsClient.this.zzco) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                if (iBinder == null) {
                    iGmsServiceBroker = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) {
                        iGmsServiceBroker = new IGmsServiceBroker.Stub.zza(iBinder);
                    } else {
                        iGmsServiceBroker = (IGmsServiceBroker) queryLocalInterface;
                    }
                }
                IGmsServiceBroker unused = baseGmsClient.zzcp = iGmsServiceBroker;
            }
            BaseGmsClient.this.zza(0, (Bundle) null, this.zzdh);
        }

        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseGmsClient.this.zzco) {
                IGmsServiceBroker unused = BaseGmsClient.this.zzcp = null;
            }
            BaseGmsClient.this.mHandler.sendMessage(BaseGmsClient.this.mHandler.obtainMessage(6, this.zzdh, 1));
        }
    }

    @VisibleForTesting
    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    public static final class zze extends IGmsCallbacks.zza {
        private final int zzdh;
        private BaseGmsClient zzdi;

        public zze(@NonNull BaseGmsClient baseGmsClient, int i) {
            this.zzdi = baseGmsClient;
            this.zzdh = i;
        }

        @BinderThread
        public final void zza(int i, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @BinderThread
        public final void onPostInitComplete(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            Preconditions.checkNotNull(this.zzdi, "onPostInitComplete can be called only once per call to getRemoteService");
            this.zzdi.onPostInitHandler(i, iBinder, bundle, this.zzdh);
            this.zzdi = null;
        }

        @BinderThread
        public final void zza(int i, @NonNull IBinder iBinder, @NonNull zzc zzc) {
            Preconditions.checkNotNull(this.zzdi, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Preconditions.checkNotNull(zzc);
            this.zzdi.zza(zzc);
            onPostInitComplete(i, iBinder, zzc.zzdl);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    protected final class zzf extends zza {
        private final IBinder zzdj;

        @BinderThread
        public zzf(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.zzdj = iBinder;
        }

        /* access modifiers changed from: protected */
        public final void zza(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.zzcw != null) {
                BaseGmsClient.this.zzcw.onConnectionFailed(connectionResult);
            }
            BaseGmsClient.this.onConnectionFailed(connectionResult);
        }

        /* access modifiers changed from: protected */
        public final boolean zzm() {
            try {
                String interfaceDescriptor = this.zzdj.getInterfaceDescriptor();
                if (!BaseGmsClient.this.getServiceDescriptor().equals(interfaceDescriptor)) {
                    String serviceDescriptor = BaseGmsClient.this.getServiceDescriptor();
                    StringBuilder sb = new StringBuilder(String.valueOf(serviceDescriptor).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(serviceDescriptor);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface createServiceInterface = BaseGmsClient.this.createServiceInterface(this.zzdj);
                if (createServiceInterface == null || (!BaseGmsClient.this.zza(2, 4, createServiceInterface) && !BaseGmsClient.this.zza(3, 4, createServiceInterface))) {
                    return false;
                }
                ConnectionResult unused = BaseGmsClient.this.zzcz = null;
                Bundle connectionHint = BaseGmsClient.this.getConnectionHint();
                if (BaseGmsClient.this.zzcv == null) {
                    return true;
                }
                BaseGmsClient.this.zzcv.onConnected(connectionHint);
                return true;
            } catch (RemoteException unused2) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
    private abstract class zza extends zzc<Boolean> {
        private final int statusCode;
        private final Bundle zzdd;

        @BinderThread
        protected zza(int i, Bundle bundle) {
            super(true);
            this.statusCode = i;
            this.zzdd = bundle;
        }

        /* access modifiers changed from: protected */
        public abstract void zza(ConnectionResult connectionResult);

        /* access modifiers changed from: protected */
        public abstract boolean zzm();

        /* access modifiers changed from: protected */
        public final void zzn() {
        }

        /* JADX WARNING: type inference failed for: r5v11, types: [android.os.Parcelable] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void zza(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                r0 = 1
                r1 = 0
                if (r5 != 0) goto L_0x000c
                com.google.android.gms.common.internal.BaseGmsClient r5 = com.google.android.gms.common.internal.BaseGmsClient.this
                r5.zza((int) r0, null)
                return
            L_0x000c:
                int r5 = r4.statusCode
                if (r5 == 0) goto L_0x0061
                r2 = 10
                if (r5 == r2) goto L_0x0031
                com.google.android.gms.common.internal.BaseGmsClient r5 = com.google.android.gms.common.internal.BaseGmsClient.this
                r5.zza((int) r0, null)
                android.os.Bundle r5 = r4.zzdd
                if (r5 == 0) goto L_0x0026
                java.lang.String r0 = "pendingIntent"
                android.os.Parcelable r5 = r5.getParcelable(r0)
                r1 = r5
                android.app.PendingIntent r1 = (android.app.PendingIntent) r1
            L_0x0026:
                com.google.android.gms.common.ConnectionResult r5 = new com.google.android.gms.common.ConnectionResult
                int r0 = r4.statusCode
                r5.<init>(r0, r1)
                r4.zza((com.google.android.gms.common.ConnectionResult) r5)
                goto L_0x0076
            L_0x0031:
                com.google.android.gms.common.internal.BaseGmsClient r5 = com.google.android.gms.common.internal.BaseGmsClient.this
                r5.zza((int) r0, null)
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                r1 = 3
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r2 = 0
                java.lang.Class r3 = r4.getClass()
                java.lang.String r3 = r3.getSimpleName()
                r1[r2] = r3
                com.google.android.gms.common.internal.BaseGmsClient r2 = com.google.android.gms.common.internal.BaseGmsClient.this
                java.lang.String r2 = r2.getStartServiceAction()
                r1[r0] = r2
                r0 = 2
                com.google.android.gms.common.internal.BaseGmsClient r2 = com.google.android.gms.common.internal.BaseGmsClient.this
                java.lang.String r2 = r2.getServiceDescriptor()
                r1[r0] = r2
                java.lang.String r0 = "A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. "
                java.lang.String r0 = java.lang.String.format(r0, r1)
                r5.<init>(r0)
                throw r5
            L_0x0061:
                boolean r5 = r4.zzm()
                if (r5 != 0) goto L_0x0076
                com.google.android.gms.common.internal.BaseGmsClient r5 = com.google.android.gms.common.internal.BaseGmsClient.this
                r5.zza((int) r0, null)
                com.google.android.gms.common.ConnectionResult r5 = new com.google.android.gms.common.ConnectionResult
                r0 = 8
                r5.<init>(r0, r1)
                r4.zza((com.google.android.gms.common.ConnectionResult) r5)
            L_0x0076:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.BaseGmsClient.zza.zza(java.lang.Object):void");
        }
    }

    @KeepForSdk
    @VisibleForTesting
    protected BaseGmsClient(Context context, Looper looper, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener, String str) {
        this.mLock = new Object();
        this.zzco = new Object();
        this.zzcs = new ArrayList<>();
        this.zzcu = 1;
        this.zzcz = null;
        this.zzda = false;
        this.zzdb = null;
        this.zzdc = new AtomicInteger(0);
        this.mContext = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.zzcl = (Looper) Preconditions.checkNotNull(looper, "Looper must not be null");
        this.zzcm = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzcn = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.mHandler = new zzb(looper);
        this.zzcx = i;
        this.zzcv = baseConnectionCallbacks;
        this.zzcw = baseOnConnectionFailedListener;
        this.zzcy = str;
    }

    @KeepForSdk
    @VisibleForTesting
    protected BaseGmsClient(Context context, Handler handler, GmsClientSupervisor gmsClientSupervisor, GoogleApiAvailabilityLight googleApiAvailabilityLight, int i, BaseConnectionCallbacks baseConnectionCallbacks, BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.mLock = new Object();
        this.zzco = new Object();
        this.zzcs = new ArrayList<>();
        this.zzcu = 1;
        this.zzcz = null;
        this.zzda = false;
        this.zzdb = null;
        this.zzdc = new AtomicInteger(0);
        this.mContext = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.mHandler = (Handler) Preconditions.checkNotNull(handler, "Handler must not be null");
        this.zzcl = handler.getLooper();
        this.zzcm = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzcn = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzcx = i;
        this.zzcv = baseConnectionCallbacks;
        this.zzcw = baseOnConnectionFailedListener;
        this.zzcy = null;
    }

    @Nullable
    private final String zzj() {
        String str = this.zzcy;
        return str == null ? this.mContext.getClass().getName() : str;
    }

    /* access modifiers changed from: private */
    public final void zza(zzc zzc2) {
        this.zzdb = zzc2;
    }

    @KeepForSdk
    @Nullable
    public final Feature[] getAvailableFeatures() {
        zzc zzc2 = this.zzdb;
        if (zzc2 == null) {
            return null;
        }
        return zzc2.zzdm;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    @KeepForSdk
    public void onConnectedLocked(@NonNull T t) {
        this.zzch = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    @KeepForSdk
    public void onConnectionSuspended(int i) {
        this.zzcf = i;
        this.zzcg = System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    @KeepForSdk
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.zzci = connectionResult.getErrorCode();
        this.zzcj = System.currentTimeMillis();
    }

    /* access modifiers changed from: private */
    public final void zza(int i, T t) {
        zzh zzh;
        boolean z = false;
        if ((i == 4) == (t != null)) {
            z = true;
        }
        Preconditions.checkArgument(z);
        synchronized (this.mLock) {
            this.zzcu = i;
            this.zzcr = t;
            onSetConnectState(i, t);
            if (i != 1) {
                if (i == 2 || i == 3) {
                    if (!(this.zzct == null || this.zzck == null)) {
                        String zzt = this.zzck.zzt();
                        String packageName = this.zzck.getPackageName();
                        StringBuilder sb = new StringBuilder(String.valueOf(zzt).length() + 70 + String.valueOf(packageName).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(zzt);
                        sb.append(" on ");
                        sb.append(packageName);
                        Log.e("GmsClient", sb.toString());
                        this.zzcm.zza(this.zzck.zzt(), this.zzck.getPackageName(), this.zzck.zzq(), this.zzct, zzj(), this.zzck.getUseDynamicLookup());
                        this.zzdc.incrementAndGet();
                    }
                    this.zzct = new zzd(this.zzdc.get());
                    if (this.zzcu != 3 || getLocalStartServiceAction() == null) {
                        zzh = new zzh(getStartServicePackage(), getStartServiceAction(), false, GmsClientSupervisor.getDefaultBindFlags(), getUseDynamicLookup());
                    } else {
                        zzh = new zzh(getContext().getPackageName(), getLocalStartServiceAction(), true, GmsClientSupervisor.getDefaultBindFlags(), false);
                    }
                    this.zzck = zzh;
                    if (!this.zzck.getUseDynamicLookup() || getMinApkVersion() >= 17895000) {
                        if (!this.zzcm.zza(new GmsClientSupervisor.zza(this.zzck.zzt(), this.zzck.getPackageName(), this.zzck.zzq(), this.zzck.getUseDynamicLookup()), this.zzct, zzj())) {
                            String zzt2 = this.zzck.zzt();
                            String packageName2 = this.zzck.getPackageName();
                            StringBuilder sb2 = new StringBuilder(String.valueOf(zzt2).length() + 34 + String.valueOf(packageName2).length());
                            sb2.append("unable to connect to service: ");
                            sb2.append(zzt2);
                            sb2.append(" on ");
                            sb2.append(packageName2);
                            Log.e("GmsClient", sb2.toString());
                            zza(16, (Bundle) null, this.zzdc.get());
                        }
                    } else {
                        String valueOf = String.valueOf(this.zzck.zzt());
                        throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                    }
                } else if (i == 4) {
                    onConnectedLocked(t);
                }
            } else if (this.zzct != null) {
                this.zzcm.zza(this.zzck.zzt(), this.zzck.getPackageName(), this.zzck.zzq(), this.zzct, zzj(), this.zzck.getUseDynamicLookup());
                this.zzct = null;
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean zza(int i, int i2, T t) {
        synchronized (this.mLock) {
            if (this.zzcu != i) {
                return false;
            }
            zza(i2, t);
            return true;
        }
    }

    @KeepForSdk
    public void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.zzcn.isGooglePlayServicesAvailable(this.mContext, getMinApkVersion());
        if (isGooglePlayServicesAvailable != 0) {
            zza(1, (IInterface) null);
            triggerNotAvailable(new LegacyClientCallbackAdapter(), isGooglePlayServicesAvailable, (PendingIntent) null);
            return;
        }
        connect(new LegacyClientCallbackAdapter());
    }

    @KeepForSdk
    public void connect(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzcq = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        zza(2, (IInterface) null);
    }

    @KeepForSdk
    public boolean isConnected() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcu == 4;
        }
        return z;
    }

    @KeepForSdk
    public boolean isConnecting() {
        boolean z;
        synchronized (this.mLock) {
            if (this.zzcu != 2) {
                if (this.zzcu != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    private final boolean zzk() {
        boolean z;
        synchronized (this.mLock) {
            z = this.zzcu == 3;
        }
        return z;
    }

    @KeepForSdk
    public void disconnect() {
        this.zzdc.incrementAndGet();
        synchronized (this.zzcs) {
            int size = this.zzcs.size();
            for (int i = 0; i < size; i++) {
                this.zzcs.get(i).removeListener();
            }
            this.zzcs.clear();
        }
        synchronized (this.zzco) {
            this.zzcp = null;
        }
        zza(1, (IInterface) null);
    }

    @KeepForSdk
    public void triggerConnectionSuspended(int i) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(6, this.zzdc.get(), i));
    }

    /* access modifiers changed from: private */
    public final void zzb(int i) {
        int i2;
        if (zzk()) {
            i2 = 5;
            this.zzda = true;
        } else {
            i2 = 4;
        }
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(i2, this.zzdc.get(), 16));
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    @VisibleForTesting
    public void triggerNotAvailable(@NonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks, int i, @Nullable PendingIntent pendingIntent) {
        this.zzcq = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(3, this.zzdc.get(), i, pendingIntent));
    }

    @KeepForSdk
    public final Context getContext() {
        return this.mContext;
    }

    @KeepForSdk
    public final Looper getLooper() {
        return this.zzcl;
    }

    @KeepForSdk
    public Feature[] getApiFeatures() {
        return zzce;
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public void onPostInitHandler(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzf(i, iBinder, bundle)));
    }

    /* access modifiers changed from: protected */
    public final void zza(int i, @Nullable Bundle bundle, int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new zzg(i, (Bundle) null)));
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @KeepForSdk
    public final T getService() throws DeadObjectException {
        T t;
        synchronized (this.mLock) {
            if (this.zzcu != 5) {
                checkConnected();
                Preconditions.checkState(this.zzcr != null, "Client is connected but service is null");
                t = this.zzcr;
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    @WorkerThread
    @KeepForSdk
    public void getRemoteService(IAccountAccessor iAccountAccessor, Set<Scope> set) {
        Bundle getServiceRequestExtraArgs = getGetServiceRequestExtraArgs();
        GetServiceRequest getServiceRequest = new GetServiceRequest(this.zzcx);
        getServiceRequest.zzak = this.mContext.getPackageName();
        getServiceRequest.zzdw = getServiceRequestExtraArgs;
        if (set != null) {
            getServiceRequest.zzdv = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (requiresSignIn()) {
            getServiceRequest.zzdx = getAccount() != null ? getAccount() : new Account("<<default account>>", AccountType.GOOGLE);
            if (iAccountAccessor != null) {
                getServiceRequest.zzdu = iAccountAccessor.asBinder();
            }
        } else if (requiresAccount()) {
            getServiceRequest.zzdx = getAccount();
        }
        getServiceRequest.zzdy = zzce;
        getServiceRequest.zzdz = getApiFeatures();
        try {
            synchronized (this.zzco) {
                if (this.zzcp != null) {
                    this.zzcp.getService(new zze(this, this.zzdc.get()), getServiceRequest);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            triggerConnectionSuspended(1);
        } catch (SecurityException e2) {
            throw e2;
        } catch (RemoteException | RuntimeException e3) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e3);
            onPostInitHandler(8, (IBinder) null, (Bundle) null, this.zzdc.get());
        }
    }

    @KeepForSdk
    public void onUserSignOut(@NonNull SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    @KeepForSdk
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    /* access modifiers changed from: protected */
    @KeepForSdk
    public Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    @KeepForSdk
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.mLock) {
            i = this.zzcu;
            t = this.zzcr;
        }
        synchronized (this.zzco) {
            iGmsServiceBroker = this.zzcp;
        }
        printWriter.append(str).append("mConnectState=");
        if (i == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i == 4) {
            printWriter.print("CONNECTED");
        } else if (i != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append("null");
        } else {
            printWriter.append(getServiceDescriptor()).append("@").append(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println("null");
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzch > 0) {
            PrintWriter append = printWriter.append(str).append("lastConnectedTime=");
            long j = this.zzch;
            String format = simpleDateFormat.format(new Date(j));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j);
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.zzcg > 0) {
            printWriter.append(str).append("lastSuspendedCause=");
            int i2 = this.zzcf;
            if (i2 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i2 != 2) {
                printWriter.append(String.valueOf(i2));
            } else {
                printWriter.append("CAUSE_NETWORK_LOST");
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzcg;
            String format2 = simpleDateFormat.format(new Date(j2));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j2);
            sb2.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.zzcj > 0) {
            printWriter.append(str).append("lastFailedStatus=").append(CommonStatusCodes.getStatusCodeString(this.zzci));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzcj;
            String format3 = simpleDateFormat.format(new Date(j3));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j3);
            sb3.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    @KeepForSdk
    @Nullable
    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzco) {
            if (this.zzcp == null) {
                return null;
            }
            IBinder asBinder = this.zzcp.asBinder();
            return asBinder;
        }
    }

    /* access modifiers changed from: private */
    public final boolean zzl() {
        if (this.zzda || TextUtils.isEmpty(getServiceDescriptor()) || TextUtils.isEmpty(getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @KeepForSdk
    public String getEndpointPackageName() {
        zzh zzh;
        if (isConnected() && (zzh = this.zzck) != null) {
            return zzh.getPackageName();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @KeepForSdk
    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }
}
