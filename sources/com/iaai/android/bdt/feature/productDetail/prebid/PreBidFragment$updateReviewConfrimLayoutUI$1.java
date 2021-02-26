package com.iaai.android.bdt.feature.productDetail.prebid;

import android.view.View;
import com.iaai.android.bdt.utils.Utils;
import java.math.BigDecimal;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreBidFragment.kt */
final class PreBidFragment$updateReviewConfrimLayoutUI$1 implements View.OnClickListener {
    final /* synthetic */ PreBidFragment this$0;

    PreBidFragment$updateReviewConfrimLayoutUI$1(PreBidFragment preBidFragment) {
        this.this$0 = preBidFragment;
    }

    public final void onClick(View view) {
        String str;
        BigDecimal bigDecimal = new BigDecimal(this.this$0.minBidInt);
        BigDecimal bigDecimal2 = new BigDecimal(this.this$0.maxBidString);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = {this.this$0.getSessionManager().getCurrentSessionUsername(), this.this$0.getSessionManager().getCurrentSessionPassword()};
        String format = String.format("%s:%s", Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
        if (this.this$0.getSessionManager().getCurrentSessionUserId() != null) {
            str = this.this$0.getSessionManager().getCurrentSessionUserId();
        } else {
            str = this.this$0.getSessionManager().getLastLoginUserId();
        }
        PreBidViewModel access$getViewModel$p = PreBidFragment.access$getViewModel$p(this.this$0);
        String access$getItemId$p = this.this$0.itemId;
        if (str == null) {
            str = "";
        }
        String access$getAuctionId$p = this.this$0.auctionId;
        String language = Utils.getLanguage();
        Intrinsics.checkExpressionValueIsNotNull(language, "Utils.getLanguage()");
        access$getViewModel$p.placePreBid(format, access$getItemId$p, str, access$getAuctionId$p, language, this.this$0.action, bigDecimal2, bigDecimal, this.this$0.isTimedAuction);
    }
}
