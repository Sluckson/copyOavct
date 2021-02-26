package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Parser;
import javax.annotation.concurrent.ThreadSafe;
import p011io.reactivex.Completable;
import p011io.reactivex.Maybe;

@ThreadSafe
public class ProtoStorageClient {
    private final Application application;
    private final String fileName;

    public ProtoStorageClient(Application application2, String str) {
        this.application = application2;
        this.fileName = str;
    }

    public Completable write(AbstractMessageLite abstractMessageLite) {
        return Completable.fromCallable(ProtoStorageClient$$Lambda$1.lambdaFactory$(this, abstractMessageLite));
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object lambda$write$0(com.google.firebase.inappmessaging.internal.ProtoStorageClient r3, com.google.protobuf.AbstractMessageLite r4) throws java.lang.Exception {
        /*
            monitor-enter(r3)
            android.app.Application r0 = r3.application     // Catch:{ all -> 0x001f }
            java.lang.String r1 = r3.fileName     // Catch:{ all -> 0x001f }
            r2 = 0
            java.io.FileOutputStream r0 = r0.openFileOutput(r1, r2)     // Catch:{ all -> 0x001f }
            byte[] r1 = r4.toByteArray()     // Catch:{ Throwable -> 0x0018 }
            r0.write(r1)     // Catch:{ Throwable -> 0x0018 }
            if (r0 == 0) goto L_0x0016
            r0.close()     // Catch:{ all -> 0x001f }
        L_0x0016:
            monitor-exit(r3)     // Catch:{ all -> 0x001f }
            return r4
        L_0x0018:
            r4 = move-exception
            if (r0 == 0) goto L_0x001e
            r0.close()     // Catch:{ Throwable -> 0x001e }
        L_0x001e:
            throw r4     // Catch:{ all -> 0x001f }
        L_0x001f:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x001f }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.internal.ProtoStorageClient.lambda$write$0(com.google.firebase.inappmessaging.internal.ProtoStorageClient, com.google.protobuf.AbstractMessageLite):java.lang.Object");
    }

    public <T extends AbstractMessageLite> Maybe<T> read(Parser<T> parser) {
        return Maybe.fromCallable(ProtoStorageClient$$Lambda$2.lambdaFactory$(this, parser));
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.google.protobuf.AbstractMessageLite lambda$read$1(com.google.firebase.inappmessaging.internal.ProtoStorageClient r2, com.google.protobuf.Parser r3) throws java.lang.Exception {
        /*
            monitor-enter(r2)
            android.app.Application r0 = r2.application     // Catch:{ InvalidProtocolBufferException -> 0x0021, FileNotFoundException -> 0x001f }
            java.lang.String r1 = r2.fileName     // Catch:{ InvalidProtocolBufferException -> 0x0021, FileNotFoundException -> 0x001f }
            java.io.FileInputStream r0 = r0.openFileInput(r1)     // Catch:{ InvalidProtocolBufferException -> 0x0021, FileNotFoundException -> 0x001f }
            java.lang.Object r3 = r3.parseFrom((java.io.InputStream) r0)     // Catch:{ Throwable -> 0x0016 }
            com.google.protobuf.AbstractMessageLite r3 = (com.google.protobuf.AbstractMessageLite) r3     // Catch:{ Throwable -> 0x0016 }
            if (r0 == 0) goto L_0x0014
            r0.close()     // Catch:{ InvalidProtocolBufferException -> 0x0021, FileNotFoundException -> 0x001f }
        L_0x0014:
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            return r3
        L_0x0016:
            r3 = move-exception
            if (r0 == 0) goto L_0x001c
            r0.close()     // Catch:{ Throwable -> 0x001c }
        L_0x001c:
            throw r3     // Catch:{ InvalidProtocolBufferException -> 0x0021, FileNotFoundException -> 0x001f }
        L_0x001d:
            r3 = move-exception
            goto L_0x003d
        L_0x001f:
            r3 = move-exception
            goto L_0x0022
        L_0x0021:
            r3 = move-exception
        L_0x0022:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x001d }
            r0.<init>()     // Catch:{ all -> 0x001d }
            java.lang.String r1 = "Recoverable exception while reading cache: "
            r0.append(r1)     // Catch:{ all -> 0x001d }
            java.lang.String r3 = r3.getMessage()     // Catch:{ all -> 0x001d }
            r0.append(r3)     // Catch:{ all -> 0x001d }
            java.lang.String r3 = r0.toString()     // Catch:{ all -> 0x001d }
            com.google.firebase.inappmessaging.internal.Logging.logi(r3)     // Catch:{ all -> 0x001d }
            r3 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            return r3
        L_0x003d:
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.inappmessaging.internal.ProtoStorageClient.lambda$read$1(com.google.firebase.inappmessaging.internal.ProtoStorageClient, com.google.protobuf.Parser):com.google.protobuf.AbstractMessageLite");
    }
}
