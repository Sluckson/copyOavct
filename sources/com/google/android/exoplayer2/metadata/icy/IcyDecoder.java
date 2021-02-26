package com.google.android.exoplayer2.metadata.icy;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataDecoder;
import com.google.android.exoplayer2.metadata.MetadataInputBuffer;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class IcyDecoder implements MetadataDecoder {
    private static final Pattern METADATA_ELEMENT = Pattern.compile("(.+?)='(.*?)';", 32);
    private static final String STREAM_KEY_NAME = "streamtitle";
    private static final String STREAM_KEY_URL = "streamurl";
    private static final String TAG = "IcyDecoder";

    @Nullable
    public Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = metadataInputBuffer.data;
        return decode(Util.fromUtf8Bytes(byteBuffer.array(), 0, byteBuffer.limit()));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    @Nullable
    public Metadata decode(String str) {
        Matcher matcher = METADATA_ELEMENT.matcher(str);
        String str2 = null;
        String str3 = null;
        for (int i = 0; matcher.find(i); i = matcher.end()) {
            String lowerInvariant = Util.toLowerInvariant(matcher.group(1));
            String group = matcher.group(2);
            char c = 65535;
            int hashCode = lowerInvariant.hashCode();
            if (hashCode != -315603473) {
                if (hashCode == 1646559960 && lowerInvariant.equals(STREAM_KEY_NAME)) {
                    c = 0;
                }
            } else if (lowerInvariant.equals(STREAM_KEY_URL)) {
                c = 1;
            }
            if (c == 0) {
                str2 = group;
            } else if (c != 1) {
                Log.m54w(TAG, "Unrecognized ICY tag: " + str2);
            } else {
                str3 = group;
            }
        }
        if (str2 == null && str3 == null) {
            return null;
        }
        return new Metadata(new IcyInfo(str2, str3));
    }
}
