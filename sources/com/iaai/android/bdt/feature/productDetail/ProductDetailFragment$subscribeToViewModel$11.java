package com.iaai.android.bdt.feature.productDetail;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.model.productDetail.biddingInfo.ImageInformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/productDetail/biddingInfo/ImageInformation;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ProductDetailFragment.kt */
final class ProductDetailFragment$subscribeToViewModel$11<T> implements Observer<ImageInformation> {
    final /* synthetic */ ProductDetailFragment this$0;

    ProductDetailFragment$subscribeToViewModel$11(ProductDetailFragment productDetailFragment) {
        this.this$0 = productDetailFragment;
    }

    public final void onChanged(ImageInformation imageInformation) {
        Boolean bool;
        if (this.this$0.isAdded() && this.this$0.isViewAvalibale && imageInformation != null) {
            if (imageInformation.isImage360()) {
                LinearLayout linearLayout = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llImages);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout, "llImages");
                linearLayout.setVisibility(0);
                LinearLayout linearLayout2 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.iv360Image);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout2, "iv360Image");
                linearLayout2.setVisibility(0);
                if (imageInformation.getUndercarriageInd()) {
                    TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tv_360);
                    Intrinsics.checkExpressionValueIsNotNull(textView, "tv_360");
                    textView.setText(this.this$0.getString(C2723R.string.lbl_Undercarriagel));
                }
                this.this$0.image360URL = imageInformation.getImage360Url();
            }
            if (imageInformation.isHDImage()) {
                LinearLayout linearLayout3 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llImages);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout3, "llImages");
                linearLayout3.setVisibility(0);
                LinearLayout linearLayout4 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.ivHdImage);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout4, "ivHdImage");
                linearLayout4.setVisibility(0);
            }
            if (imageInformation.getKeyImage() != null) {
                String keyImage = imageInformation.getKeyImage();
                if (keyImage != null) {
                    bool = Boolean.valueOf(keyImage.length() > 0);
                } else {
                    bool = null;
                }
                if (bool.booleanValue()) {
                    LinearLayout linearLayout5 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llImages);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout5, "llImages");
                    linearLayout5.setVisibility(0);
                    LinearLayout linearLayout6 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.ivKey);
                    Intrinsics.checkExpressionValueIsNotNull(linearLayout6, "ivKey");
                    linearLayout6.setVisibility(0);
                    this.this$0.isKeyImagePresent = true;
                }
            }
            CharSequence engineVideo = imageInformation.getEngineVideo();
            if (!(engineVideo == null || engineVideo.length() == 0)) {
                LinearLayout linearLayout7 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llImages);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout7, "llImages");
                linearLayout7.setVisibility(0);
                LinearLayout linearLayout8 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.ivEngineVideo);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout8, "ivEngineVideo");
                linearLayout8.setVisibility(0);
                this.this$0.isEngineVideoPresent = true;
            }
            if (imageInformation.getTireTread()) {
                LinearLayout linearLayout9 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.llImages);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout9, "llImages");
                linearLayout9.setVisibility(0);
                LinearLayout linearLayout10 = (LinearLayout) this.this$0._$_findCachedViewById(C2723R.C2726id.ivTireTread);
                Intrinsics.checkExpressionValueIsNotNull(linearLayout10, "ivTireTread");
                linearLayout10.setVisibility(0);
            }
            this.this$0.vehicleImages = imageInformation.getImages();
            this.this$0.updateVehicleImageCarousel();
        }
    }
}
