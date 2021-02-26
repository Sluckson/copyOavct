package com.iaai.android.bdt.feature.productDetail;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.productDetail.partsSection.PartsSectionResponse;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo66933d2 = {"<anonymous>", "", "partsInfo", "", "Lcom/iaai/android/bdt/model/productDetail/partsSection/PartsSectionResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$subscribeToViewModel$9<T> implements Observer<List<? extends PartsSectionResponse>> {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$subscribeToViewModel$9(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onChanged(List<PartsSectionResponse> list) {
        if (list != null && this.this$0.isAdded() && this.this$0.isViewAvalibale) {
            this.this$0.partsList = list;
            this.this$0.loadPartsInfo();
        }
    }
}
