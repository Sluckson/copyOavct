package com.iaai.android.bdt.feature.productDetail;

import android.app.DownloadManager;
import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import androidx.annotation.Nullable;
import com.iaai.android.bdt.utils.Constants_MVVM;
import com.iaai.android.old.utils.IAASharedPreference;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0014J@\u0010\u0007\u001a\u00020\u00042\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000b2\u0006\u0010\r\u001a\u00020\nH\u0002¨\u0006\u000e"}, mo66933d2 = {"Lcom/iaai/android/bdt/feature/productDetail/DownloadVehicleImageService;", "Landroid/app/IntentService;", "()V", "onHandleIntent", "", "intent", "Landroid/content/Intent;", "startDownload", "downloadPath", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "destinationPath", "downloadImageName", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: DownloadVehicleImageService.kt */
public final class DownloadVehicleImageService extends IntentService {
    public DownloadVehicleImageService() {
        super("DownloadVehicleImageService");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(@NotNull @Nullable Intent intent) {
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(Constants_MVVM.EXTRA_DOWNLOAD_PATH);
        ArrayList<String> stringArrayListExtra2 = intent.getStringArrayListExtra(Constants_MVVM.EXTRA_DESTINATION_PATH);
        String stringExtra = intent.getStringExtra(Constants_MVVM.EXTRA_DOWNLOAD_IMAGE_NAME);
        Intrinsics.checkExpressionValueIsNotNull(stringArrayListExtra, "downloadPath");
        Intrinsics.checkExpressionValueIsNotNull(stringArrayListExtra2, "destinationPath");
        Intrinsics.checkExpressionValueIsNotNull(stringExtra, "downloadImageName");
        startDownload(stringArrayListExtra, stringArrayListExtra2, stringExtra);
    }

    private final void startDownload(ArrayList<String> arrayList, ArrayList<String> arrayList2, String str) {
        int i = 0;
        for (Object next : arrayList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse((String) next));
            request.allowScanningByMediaScanner();
            request.setAllowedNetworkTypes(3);
            request.setNotificationVisibility(1);
            request.setTitle(str);
            request.setVisibleInDownloadsUi(true);
            String str2 = Environment.DIRECTORY_PICTURES;
            request.setDestinationInExternalPublicDir(str2, "vehicle_" + i2 + ".jpeg");
            Object systemService = getSystemService("download");
            if (systemService != null) {
                long enqueue = ((DownloadManager) systemService).enqueue(request);
                if (arrayList.size() - 1 == i) {
                    IAASharedPreference.setLastDownloadID(this, enqueue);
                }
                i = i2;
            } else {
                throw new TypeCastException("null cannot be cast to non-null type android.app.DownloadManager");
            }
        }
    }
}
