package com.google.android.exoplayer2.offline;

import androidx.annotation.Nullable;
import java.io.IOException;

public interface DownloadIndex {
    @Nullable
    Download getDownload(String str) throws IOException;

    DownloadCursor getDownloads(int... iArr) throws IOException;
}
