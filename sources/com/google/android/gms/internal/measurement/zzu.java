package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
public abstract class zzu extends zzc implements zzv {
    public zzu() {
        super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    public static zzv asInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
        if (queryLocalInterface instanceof zzv) {
            return (zzv) queryLocalInterface;
        }
        return new zzx(iBinder);
    }

    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v9, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v14, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v20, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v26, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v30, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v34, types: [com.google.android.gms.internal.measurement.zzac] */
    /* JADX WARNING: type inference failed for: r3v38, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v42, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v46, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v50, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v55, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v60, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v67, types: [com.google.android.gms.internal.measurement.zzab] */
    /* JADX WARNING: type inference failed for: r3v71, types: [com.google.android.gms.internal.measurement.zzab] */
    /* JADX WARNING: type inference failed for: r3v75, types: [com.google.android.gms.internal.measurement.zzab] */
    /* JADX WARNING: type inference failed for: r3v79, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v84, types: [com.google.android.gms.internal.measurement.zzw] */
    /* JADX WARNING: type inference failed for: r3v88 */
    /* JADX WARNING: type inference failed for: r3v89 */
    /* JADX WARNING: type inference failed for: r3v90 */
    /* JADX WARNING: type inference failed for: r3v91 */
    /* JADX WARNING: type inference failed for: r3v92 */
    /* JADX WARNING: type inference failed for: r3v93 */
    /* JADX WARNING: type inference failed for: r3v94 */
    /* JADX WARNING: type inference failed for: r3v95 */
    /* JADX WARNING: type inference failed for: r3v96 */
    /* JADX WARNING: type inference failed for: r3v97 */
    /* JADX WARNING: type inference failed for: r3v98 */
    /* JADX WARNING: type inference failed for: r3v99 */
    /* JADX WARNING: type inference failed for: r3v100 */
    /* JADX WARNING: type inference failed for: r3v101 */
    /* JADX WARNING: type inference failed for: r3v102 */
    /* JADX WARNING: type inference failed for: r3v103 */
    /* JADX WARNING: type inference failed for: r3v104 */
    /* JADX WARNING: type inference failed for: r3v105 */
    /* JADX WARNING: type inference failed for: r3v106 */
    /* JADX WARNING: type inference failed for: r3v107 */
    /* JADX WARNING: type inference failed for: r3v108 */
    /* JADX WARNING: type inference failed for: r3v109 */
    /* JADX WARNING: type inference failed for: r3v110 */
    /* JADX WARNING: type inference failed for: r3v111 */
    /* JADX WARNING: type inference failed for: r3v112 */
    /* JADX WARNING: type inference failed for: r3v113 */
    /* JADX WARNING: type inference failed for: r3v114 */
    /* JADX WARNING: type inference failed for: r3v115 */
    /* JADX WARNING: type inference failed for: r3v116 */
    /* JADX WARNING: type inference failed for: r3v117 */
    /* JADX WARNING: type inference failed for: r3v118 */
    /* JADX WARNING: type inference failed for: r3v119 */
    /* JADX WARNING: type inference failed for: r3v120 */
    /* JADX WARNING: type inference failed for: r3v121 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(int r11, android.os.Parcel r12, android.os.Parcel r13, int r14) throws android.os.RemoteException {
        /*
            r10 = this;
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IEventHandlerProxy"
            java.lang.String r2 = "com.google.android.gms.measurement.api.internal.IBundleReceiver"
            r3 = 0
            switch(r11) {
                case 1: goto L_0x03fe;
                case 2: goto L_0x03dd;
                case 3: goto L_0x03a7;
                case 4: goto L_0x0389;
                case 5: goto L_0x0360;
                case 6: goto L_0x033f;
                case 7: goto L_0x0332;
                case 8: goto L_0x0321;
                case 9: goto L_0x030c;
                case 10: goto L_0x02e7;
                case 11: goto L_0x02da;
                case 12: goto L_0x02d1;
                case 13: goto L_0x02c8;
                case 14: goto L_0x02bf;
                case 15: goto L_0x02a5;
                case 16: goto L_0x0288;
                case 17: goto L_0x026b;
                case 18: goto L_0x024c;
                case 19: goto L_0x022f;
                case 20: goto L_0x0212;
                case 21: goto L_0x01f5;
                case 22: goto L_0x01d8;
                case 23: goto L_0x01cb;
                case 24: goto L_0x01be;
                case 25: goto L_0x01ad;
                case 26: goto L_0x019c;
                case 27: goto L_0x0183;
                case 28: goto L_0x0172;
                case 29: goto L_0x0161;
                case 30: goto L_0x0150;
                case 31: goto L_0x0127;
                case 32: goto L_0x00fe;
                case 33: goto L_0x00d8;
                case 34: goto L_0x00bb;
                case 35: goto L_0x009e;
                case 36: goto L_0x0081;
                case 37: goto L_0x0078;
                case 38: goto L_0x0057;
                case 39: goto L_0x004e;
                case 40: goto L_0x0031;
                case 41: goto L_0x0008;
                case 42: goto L_0x0024;
                case 43: goto L_0x001b;
                case 44: goto L_0x000a;
                default: goto L_0x0008;
            }
        L_0x0008:
            r0 = 0
            return r0
        L_0x000a:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r12.readLong()
            r10.setConsent(r1, r2)
            goto L_0x0415
        L_0x001b:
            long r0 = r12.readLong()
            r10.clearMeasurementEnabled(r0)
            goto L_0x0415
        L_0x0024:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r1)
            android.os.Bundle r0 = (android.os.Bundle) r0
            r10.setDefaultEventParameters(r0)
            goto L_0x0415
        L_0x0031:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0038
            goto L_0x0049
        L_0x0038:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x0044
            r3 = r1
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x0049
        L_0x0044:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x0049:
            r10.isDataCollectionEnabled(r3)
            goto L_0x0415
        L_0x004e:
            boolean r0 = com.google.android.gms.internal.measurement.zzb.zza(r12)
            r10.setDataCollectionEnabled(r0)
            goto L_0x0415
        L_0x0057:
            android.os.IBinder r1 = r12.readStrongBinder()
            if (r1 != 0) goto L_0x005e
            goto L_0x006f
        L_0x005e:
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x006a
            r3 = r2
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x006f
        L_0x006a:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r1)
        L_0x006f:
            int r0 = r12.readInt()
            r10.getTestFlag(r3, r0)
            goto L_0x0415
        L_0x0078:
            java.util.HashMap r0 = com.google.android.gms.internal.measurement.zzb.zzb(r12)
            r10.initForTests(r0)
            goto L_0x0415
        L_0x0081:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0088
            goto L_0x0099
        L_0x0088:
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzab
            if (r2 == 0) goto L_0x0094
            r3 = r1
            com.google.android.gms.internal.measurement.zzab r3 = (com.google.android.gms.internal.measurement.zzab) r3
            goto L_0x0099
        L_0x0094:
            com.google.android.gms.internal.measurement.zzad r3 = new com.google.android.gms.internal.measurement.zzad
            r3.<init>(r0)
        L_0x0099:
            r10.unregisterOnMeasurementEventListener(r3)
            goto L_0x0415
        L_0x009e:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x00a5
            goto L_0x00b6
        L_0x00a5:
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzab
            if (r2 == 0) goto L_0x00b1
            r3 = r1
            com.google.android.gms.internal.measurement.zzab r3 = (com.google.android.gms.internal.measurement.zzab) r3
            goto L_0x00b6
        L_0x00b1:
            com.google.android.gms.internal.measurement.zzad r3 = new com.google.android.gms.internal.measurement.zzad
            r3.<init>(r0)
        L_0x00b6:
            r10.registerOnMeasurementEventListener(r3)
            goto L_0x0415
        L_0x00bb:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x00c2
            goto L_0x00d3
        L_0x00c2:
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzab
            if (r2 == 0) goto L_0x00ce
            r3 = r1
            com.google.android.gms.internal.measurement.zzab r3 = (com.google.android.gms.internal.measurement.zzab) r3
            goto L_0x00d3
        L_0x00ce:
            com.google.android.gms.internal.measurement.zzad r3 = new com.google.android.gms.internal.measurement.zzad
            r3.<init>(r0)
        L_0x00d3:
            r10.setEventInterceptor(r3)
            goto L_0x0415
        L_0x00d8:
            int r1 = r12.readInt()
            java.lang.String r2 = r12.readString()
            android.os.IBinder r3 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            android.os.IBinder r4 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r4)
            android.os.IBinder r0 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            r0 = r10
            r0.logHealthData(r1, r2, r3, r4, r5)
            goto L_0x0415
        L_0x00fe:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            android.os.IBinder r4 = r12.readStrongBinder()
            if (r4 != 0) goto L_0x010d
            goto L_0x011e
        L_0x010d:
            android.os.IInterface r2 = r4.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x0119
            r3 = r2
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x011e
        L_0x0119:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r4)
        L_0x011e:
            long r4 = r12.readLong()
            r10.performAction(r1, r3, r4)
            goto L_0x0415
        L_0x0127:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.IBinder r4 = r12.readStrongBinder()
            if (r4 != 0) goto L_0x0136
            goto L_0x0147
        L_0x0136:
            android.os.IInterface r2 = r4.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x0142
            r3 = r2
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x0147
        L_0x0142:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r4)
        L_0x0147:
            long r4 = r12.readLong()
            r10.onActivitySaveInstanceState(r1, r3, r4)
            goto L_0x0415
        L_0x0150:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityResumed(r1, r2)
            goto L_0x0415
        L_0x0161:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityPaused(r1, r2)
            goto L_0x0415
        L_0x0172:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityDestroyed(r1, r2)
            goto L_0x0415
        L_0x0183:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.Parcelable$Creator r2 = android.os.Bundle.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r2)
            android.os.Bundle r2 = (android.os.Bundle) r2
            long r3 = r12.readLong()
            r10.onActivityCreated(r1, r2, r3)
            goto L_0x0415
        L_0x019c:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityStopped(r1, r2)
            goto L_0x0415
        L_0x01ad:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            long r2 = r12.readLong()
            r10.onActivityStarted(r1, r2)
            goto L_0x0415
        L_0x01be:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            r10.endAdUnitExposure(r1, r2)
            goto L_0x0415
        L_0x01cb:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            r10.beginAdUnitExposure(r1, r2)
            goto L_0x0415
        L_0x01d8:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x01df
            goto L_0x01f0
        L_0x01df:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x01eb
            r3 = r1
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x01f0
        L_0x01eb:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x01f0:
            r10.generateEventId(r3)
            goto L_0x0415
        L_0x01f5:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x01fc
            goto L_0x020d
        L_0x01fc:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x0208
            r3 = r1
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x020d
        L_0x0208:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x020d:
            r10.getGmpAppId(r3)
            goto L_0x0415
        L_0x0212:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0219
            goto L_0x022a
        L_0x0219:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x0225
            r3 = r1
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x022a
        L_0x0225:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x022a:
            r10.getAppInstanceId(r3)
            goto L_0x0415
        L_0x022f:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0236
            goto L_0x0247
        L_0x0236:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x0242
            r3 = r1
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x0247
        L_0x0242:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x0247:
            r10.getCachedAppInstanceId(r3)
            goto L_0x0415
        L_0x024c:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0253
            goto L_0x0266
        L_0x0253:
            java.lang.String r1 = "com.google.android.gms.measurement.api.internal.IStringProvider"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzac
            if (r2 == 0) goto L_0x0261
            r3 = r1
            com.google.android.gms.internal.measurement.zzac r3 = (com.google.android.gms.internal.measurement.zzac) r3
            goto L_0x0266
        L_0x0261:
            com.google.android.gms.internal.measurement.zzaf r3 = new com.google.android.gms.internal.measurement.zzaf
            r3.<init>(r0)
        L_0x0266:
            r10.setInstanceIdProvider(r3)
            goto L_0x0415
        L_0x026b:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0272
            goto L_0x0283
        L_0x0272:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x027e
            r3 = r1
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x0283
        L_0x027e:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x0283:
            r10.getCurrentScreenClass(r3)
            goto L_0x0415
        L_0x0288:
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x028f
            goto L_0x02a0
        L_0x028f:
            android.os.IInterface r1 = r0.queryLocalInterface(r2)
            boolean r2 = r1 instanceof com.google.android.gms.internal.measurement.zzw
            if (r2 == 0) goto L_0x029b
            r3 = r1
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x02a0
        L_0x029b:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x02a0:
            r10.getCurrentScreenName(r3)
            goto L_0x0415
        L_0x02a5:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            java.lang.String r2 = r12.readString()
            java.lang.String r3 = r12.readString()
            long r4 = r12.readLong()
            r0 = r10
            r0.setCurrentScreen(r1, r2, r3, r4)
            goto L_0x0415
        L_0x02bf:
            long r0 = r12.readLong()
            r10.setSessionTimeoutDuration(r0)
            goto L_0x0415
        L_0x02c8:
            long r0 = r12.readLong()
            r10.setMinimumSessionDuration(r0)
            goto L_0x0415
        L_0x02d1:
            long r0 = r12.readLong()
            r10.resetAnalyticsData(r0)
            goto L_0x0415
        L_0x02da:
            boolean r1 = com.google.android.gms.internal.measurement.zzb.zza(r12)
            long r2 = r12.readLong()
            r10.setMeasurementEnabled(r1, r2)
            goto L_0x0415
        L_0x02e7:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x02f6
            goto L_0x0307
        L_0x02f6:
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x0302
            r3 = r2
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x0307
        L_0x0302:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x0307:
            r10.getConditionalUserProperties(r1, r4, r3)
            goto L_0x0415
        L_0x030c:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r3)
            android.os.Bundle r0 = (android.os.Bundle) r0
            r10.clearConditionalUserProperty(r1, r2, r0)
            goto L_0x0415
        L_0x0321:
            android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r1)
            android.os.Bundle r1 = (android.os.Bundle) r1
            long r2 = r12.readLong()
            r10.setConditionalUserProperty(r1, r2)
            goto L_0x0415
        L_0x0332:
            java.lang.String r1 = r12.readString()
            long r2 = r12.readLong()
            r10.setUserId(r1, r2)
            goto L_0x0415
        L_0x033f:
            java.lang.String r1 = r12.readString()
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x034a
            goto L_0x035b
        L_0x034a:
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x0356
            r3 = r2
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x035b
        L_0x0356:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x035b:
            r10.getMaxUserProperties(r1, r3)
            goto L_0x0415
        L_0x0360:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            boolean r5 = com.google.android.gms.internal.measurement.zzb.zza(r12)
            android.os.IBinder r0 = r12.readStrongBinder()
            if (r0 != 0) goto L_0x0373
            goto L_0x0384
        L_0x0373:
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x037f
            r3 = r2
            com.google.android.gms.internal.measurement.zzw r3 = (com.google.android.gms.internal.measurement.zzw) r3
            goto L_0x0384
        L_0x037f:
            com.google.android.gms.internal.measurement.zzy r3 = new com.google.android.gms.internal.measurement.zzy
            r3.<init>(r0)
        L_0x0384:
            r10.getUserProperties(r1, r4, r5, r3)
            goto L_0x0415
        L_0x0389:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.IBinder r3 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r3)
            boolean r4 = com.google.android.gms.internal.measurement.zzb.zza(r12)
            long r5 = r12.readLong()
            r0 = r10
            r0.setUserProperty(r1, r2, r3, r4, r5)
            goto L_0x0415
        L_0x03a7:
            java.lang.String r1 = r12.readString()
            java.lang.String r4 = r12.readString()
            android.os.Parcelable$Creator r5 = android.os.Bundle.CREATOR
            android.os.Parcelable r5 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r5)
            android.os.Bundle r5 = (android.os.Bundle) r5
            android.os.IBinder r6 = r12.readStrongBinder()
            if (r6 != 0) goto L_0x03bf
            r6 = r3
            goto L_0x03d0
        L_0x03bf:
            android.os.IInterface r2 = r6.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.measurement.zzw
            if (r3 == 0) goto L_0x03ca
            com.google.android.gms.internal.measurement.zzw r2 = (com.google.android.gms.internal.measurement.zzw) r2
            goto L_0x03cf
        L_0x03ca:
            com.google.android.gms.internal.measurement.zzy r2 = new com.google.android.gms.internal.measurement.zzy
            r2.<init>(r6)
        L_0x03cf:
            r6 = r2
        L_0x03d0:
            long r8 = r12.readLong()
            r0 = r10
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r8
            r0.logEventAndBundle(r1, r2, r3, r4, r5)
            goto L_0x0415
        L_0x03dd:
            java.lang.String r1 = r12.readString()
            java.lang.String r2 = r12.readString()
            android.os.Parcelable$Creator r3 = android.os.Bundle.CREATOR
            android.os.Parcelable r3 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r3)
            android.os.Bundle r3 = (android.os.Bundle) r3
            boolean r4 = com.google.android.gms.internal.measurement.zzb.zza(r12)
            boolean r5 = com.google.android.gms.internal.measurement.zzb.zza(r12)
            long r6 = r12.readLong()
            r0 = r10
            r0.logEvent(r1, r2, r3, r4, r5, r6)
            goto L_0x0415
        L_0x03fe:
            android.os.IBinder r1 = r12.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            android.os.Parcelable$Creator<com.google.android.gms.internal.measurement.zzae> r2 = com.google.android.gms.internal.measurement.zzae.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.measurement.zzb.zza((android.os.Parcel) r12, r2)
            com.google.android.gms.internal.measurement.zzae r2 = (com.google.android.gms.internal.measurement.zzae) r2
            long r3 = r12.readLong()
            r10.initialize(r1, r2, r3)
        L_0x0415:
            r13.writeNoException()
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzu.zza(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
