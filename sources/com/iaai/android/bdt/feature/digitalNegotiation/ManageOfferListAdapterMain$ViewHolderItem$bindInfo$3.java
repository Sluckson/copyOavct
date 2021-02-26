package com.iaai.android.bdt.feature.digitalNegotiation;

import android.os.CountDownTimer;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain;
import com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList;
import com.iaai.android.bdt.utils.NewDateHelper;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo66933d2 = {"com/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListAdapterMain$ViewHolderItem$bindInfo$3", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferListAdapterMain.kt */
public final class ManageOfferListAdapterMain$ViewHolderItem$bindInfo$3 extends CountDownTimer {
    final /* synthetic */ int $countdownInterval;
    final /* synthetic */ MobileNegotiationsList $mobileNegotiationsList;
    final /* synthetic */ int $position;
    final /* synthetic */ long $timeDiff;
    final /* synthetic */ ManageOfferListAdapterMain.ViewHolderItem this$0;

    public void onFinish() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ManageOfferListAdapterMain$ViewHolderItem$bindInfo$3(ManageOfferListAdapterMain.ViewHolderItem viewHolderItem, MobileNegotiationsList mobileNegotiationsList, int i, long j, int i2, long j2, long j3) {
        super(j2, j3);
        this.this$0 = viewHolderItem;
        this.$mobileNegotiationsList = mobileNegotiationsList;
        this.$position = i;
        this.$timeDiff = j;
        this.$countdownInterval = i2;
    }

    public void onTick(long j) {
        this.$mobileNegotiationsList.setRemainingTime(NewDateHelper.INSTANCE.getRemainingTimeString(j));
        this.this$0.this$0.notifyItemChanged(this.$position);
    }
}
