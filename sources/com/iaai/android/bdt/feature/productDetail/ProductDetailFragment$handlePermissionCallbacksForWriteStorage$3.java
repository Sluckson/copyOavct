package com.iaai.android.bdt.feature.productDetail;

import android.widget.Toast;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.utils.InternetUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo66933d2 = {"<anonymous>", "", "invoke"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$handlePermissionCallbacksForWriteStorage$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ProductDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductDetailFragment$handlePermissionCallbacksForWriteStorage$3(ProductDetailFragment productDetailFragment) {
        super(0);
        this.this$0 = productDetailFragment;
    }

    public final void invoke() {
        if (!ProductDetailFragment.access$getPermissionHelper$p(this.this$0).hasPermission()) {
            return;
        }
        if (InternetUtil.INSTANCE.isInternetOn()) {
            this.this$0.startDownloadService();
        } else {
            Toast.makeText(this.this$0.getContext(), this.this$0.getString(C2723R.string.lbl_msg_no_internet_connection), 0).show();
        }
    }
}
