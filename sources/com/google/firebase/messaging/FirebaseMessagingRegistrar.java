package com.google.firebase.messaging;

import androidx.annotation.Keep;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.TransportFactory;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
@Keep
/* compiled from: com.google.firebase:firebase-messaging@@20.2.1 */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {

    @VisibleForTesting
    /* compiled from: com.google.firebase:firebase-messaging@@20.2.1 */
    public static class zzb implements TransportFactory {
        public final <T> Transport<T> getTransport(String str, Class<T> cls, Transformer<T, byte[]> transformer) {
            return new zza();
        }

        public final <T> Transport<T> getTransport(String str, Class<T> cls, Encoding encoding, Transformer<T, byte[]> transformer) {
            return new zza();
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@20.2.1 */
    private static class zza<T> implements Transport<T> {
        private zza() {
        }

        public final void send(Event<T> event) {
        }

        public final void schedule(Event<T> event, TransportScheduleCallback transportScheduleCallback) {
            transportScheduleCallback.onSchedule((Exception) null);
        }
    }

    @Keep
    public List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.builder(FirebaseMessaging.class).add(Dependency.required(FirebaseApp.class)).add(Dependency.required(FirebaseInstanceId.class)).add(Dependency.required(UserAgentPublisher.class)).add(Dependency.required(HeartBeatInfo.class)).add(Dependency.optional(TransportFactory.class)).add(Dependency.required(FirebaseInstallationsApi.class)).factory(zzn.zza).alwaysEager().build(), LibraryVersionComponent.create("fire-fcm", "20.2.1")});
    }
}
