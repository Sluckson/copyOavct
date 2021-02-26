package com.salesforce.marketingcloud.registration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.Size;
import com.salesforce.marketingcloud.MCKeep;
import java.util.Map;
import java.util.Set;

public interface RegistrationManager {
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: a */
    public static final String f3396a = "Android";

    /* renamed from: b */
    public static final int f3397b = 128;

    @MCKeep
    public interface Editor {
        @NonNull
        Editor addTag(@NonNull String str);

        @NonNull
        Editor addTags(@NonNull Iterable<String> iterable);

        @NonNull
        Editor addTags(@NonNull String... strArr);

        @NonNull
        Editor clearAttribute(@NonNull String str);

        @NonNull
        Editor clearAttributes(@NonNull Iterable<String> iterable);

        @NonNull
        Editor clearAttributes(@NonNull String... strArr);

        @NonNull
        Editor clearTags();

        boolean commit();

        @NonNull
        Editor removeTag(@NonNull String str);

        @NonNull
        Editor removeTags(@NonNull Iterable<String> iterable);

        @NonNull
        Editor removeTags(@NonNull String... strArr);

        @NonNull
        Editor setAttribute(@Size(max = 128, min = 1) @NonNull String str, @NonNull String str2);

        @NonNull
        Editor setContactKey(@Size(min = 1) @NonNull String str);

        @NonNull
        Editor setSignedString(@Size(min = 1) @Nullable String str);
    }

    @MCKeep
    public interface RegistrationEventListener {
        void onRegistrationReceived(@NonNull Registration registration);
    }

    @NonNull
    @MCKeep
    Editor edit();

    @NonNull
    @MCKeep
    Map<String, String> getAttributes();

    @Nullable
    @MCKeep
    String getContactKey();

    @NonNull
    @MCKeep
    String getDeviceId();

    @Nullable
    @MCKeep
    String getSignedString();

    @Nullable
    @MCKeep
    String getSystemToken();

    @NonNull
    @MCKeep
    Set<String> getTags();

    @MCKeep
    void registerForRegistrationEvents(@NonNull RegistrationEventListener registrationEventListener);

    @MCKeep
    void unregisterForRegistrationEvents(@NonNull RegistrationEventListener registrationEventListener);
}
