package com.iaai.android.bdt.feature.productDetail;

import com.iaai.android.bdt.base.BaseActivity;
import com.iaai.android.bdt.extensions.Context_ExtensionKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo66933d2 = {"<anonymous>", "", "it", "", "invoke"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$handlePermissionCallbacksForWriteStorage$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ ProductDetailFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProductDetailFragment$handlePermissionCallbacksForWriteStorage$1(ProductDetailFragment productDetailFragment) {
        super(1);
        this.this$0 = productDetailFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Boolean) obj).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z) {
        if (z) {
            BaseActivity access$getBaseActivity$p = this.this$0.baseActivity;
            if (access$getBaseActivity$p == null) {
                Intrinsics.throwNpe();
            }
            Context_ExtensionKt.showToast(access$getBaseActivity$p, "Please grant permissions from Settings screen");
        }
    }
}
