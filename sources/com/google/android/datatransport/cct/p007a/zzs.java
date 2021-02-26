package com.google.android.datatransport.cct.p007a;

import android.util.JsonReader;
import android.util.JsonToken;
import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import java.io.IOException;
import java.io.Reader;

@AutoValue
/* renamed from: com.google.android.datatransport.cct.a.zzs */
public abstract class zzs {
    @NonNull
    public static zzs zza(@NonNull Reader reader) throws IOException {
        JsonReader jsonReader = new JsonReader(reader);
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                if (!jsonReader.nextName().equals("nextRequestWaitMillis")) {
                    jsonReader.skipValue();
                } else if (jsonReader.peek() == JsonToken.STRING) {
                    return new zzl(Long.parseLong(jsonReader.nextString()));
                } else {
                    zzl zzl = new zzl(jsonReader.nextLong());
                    jsonReader.close();
                    return zzl;
                }
            }
            throw new IOException("Response is missing nextRequestWaitMillis field.");
        } finally {
            jsonReader.close();
        }
    }

    public abstract long zza();
}
