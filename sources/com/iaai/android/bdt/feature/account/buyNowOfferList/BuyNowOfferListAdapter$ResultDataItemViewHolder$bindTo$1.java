package com.iaai.android.bdt.feature.account.buyNowOfferList;

import android.os.CountDownTimer;
import com.iaai.android.bdt.feature.account.buyNowOfferList.BuyNowOfferListAdapter;
import com.iaai.android.bdt.utils.NewDateHelper;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo66933d2 = {"com/iaai/android/bdt/feature/account/buyNowOfferList/BuyNowOfferListAdapter$ResultDataItemViewHolder$bindTo$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: BuyNowOfferListAdapter.kt */
public final class BuyNowOfferListAdapter$ResultDataItemViewHolder$bindTo$1 extends CountDownTimer {
    final /* synthetic */ int $countdownInterval;
    final /* synthetic */ int $position;
    final /* synthetic */ long $timeDiff;
    final /* synthetic */ BuyNowOfferListAdapter.ResultDataItemViewHolder this$0;

    public void onFinish() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BuyNowOfferListAdapter$ResultDataItemViewHolder$bindTo$1(BuyNowOfferListAdapter.ResultDataItemViewHolder resultDataItemViewHolder, int i, long j, int i2, long j2, long j3) {
        super(j2, j3);
        this.this$0 = resultDataItemViewHolder;
        this.$position = i;
        this.$timeDiff = j;
        this.$countdownInterval = i2;
    }

    public void onTick(long j) {
        this.this$0.this$0.mBuyNowCloseTime = NewDateHelper.INSTANCE.getRemainingTimeString(j);
        this.this$0.this$0.notifyItemChanged(this.$position);
    }
}
