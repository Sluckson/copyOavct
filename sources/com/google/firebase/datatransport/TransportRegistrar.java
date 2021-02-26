package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import java.util.Collections;
import java.util.List;

@Keep
/* compiled from: com.google.firebase:firebase-datatransport@@17.0.5 */
public class TransportRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        return Collections.singletonList(Component.builder(TransportFactory.class).add(Dependency.required(Context.class)).factory(TransportRegistrar$$Lambda$1.lambdaFactory$()).build());
    }
}
