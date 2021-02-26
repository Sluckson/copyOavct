package com.google.firebase.dynamiclinks;

import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.dynamiclinks.DynamicLink;

public abstract class FirebaseDynamicLinks {
    public abstract DynamicLink.Builder createDynamicLink();

    public abstract Task<PendingDynamicLinkData> getDynamicLink(@NonNull Intent intent);

    public abstract Task<PendingDynamicLinkData> getDynamicLink(@NonNull Uri uri);

    public static synchronized FirebaseDynamicLinks getInstance() {
        FirebaseDynamicLinks firebaseDynamicLinks;
        synchronized (FirebaseDynamicLinks.class) {
            firebaseDynamicLinks = (FirebaseDynamicLinks) FirebaseApp.getInstance().get(FirebaseDynamicLinks.class);
        }
        return firebaseDynamicLinks;
    }
}
