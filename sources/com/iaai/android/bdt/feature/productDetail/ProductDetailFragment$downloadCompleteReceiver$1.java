package com.iaai.android.bdt.feature.productDetail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.Toast;
import com.iaai.android.C2723R;
import com.iaai.android.old.utils.IAASharedPreference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo66933d2 = {"com/iaai/android/bdt/feature/productDetail/ProductDetailFragment$downloadCompleteReceiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "contxt", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
public final class ProductDetailFragment$downloadCompleteReceiver$1 extends BroadcastReceiver {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$downloadCompleteReceiver$1(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        if (Intrinsics.areEqual((Object) "android.intent.action.DOWNLOAD_COMPLETE", (Object) intent != null ? intent.getAction() : null)) {
            long longValue = (intent != null ? Long.valueOf(intent.getLongExtra("extra_download_id", 0)) : null).longValue();
            Long lastDownloadID = IAASharedPreference.getLastDownloadID(this.this$0.getContext());
            if (lastDownloadID != null && lastDownloadID.longValue() == longValue) {
                ((ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.vehicleImageDownload)).setImageDrawable(this.this$0.getResources().getDrawable(C2723R.C2725drawable.ic_vehicle_download, (Resources.Theme) null));
                ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.vehicleImageDownload);
                Intrinsics.checkExpressionValueIsNotNull(imageView, "vehicleImageDownload");
                imageView.setClickable(true);
                if (this.this$0.checkDownloadStatus(longValue)) {
                    Toast.makeText(this.this$0.getContext(), this.this$0.getString(C2723R.string.bdt_image_download_successfull), 1).show();
                } else {
                    Toast.makeText(this.this$0.getContext(), this.this$0.getString(C2723R.string.bdt_image_download_fail), 1).show();
                }
            }
        }
    }
}
