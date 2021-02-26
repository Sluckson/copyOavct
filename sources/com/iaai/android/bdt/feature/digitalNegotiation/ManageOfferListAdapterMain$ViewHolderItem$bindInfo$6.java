package com.iaai.android.bdt.feature.digitalNegotiation;

import android.view.View;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListAdapterMain;
import com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferListAdapterMain.kt */
final class ManageOfferListAdapterMain$ViewHolderItem$bindInfo$6 implements View.OnClickListener {
    final /* synthetic */ MobileNegotiationsList $mobileNegotiationsList;
    final /* synthetic */ int $position;
    final /* synthetic */ ManageOfferListAdapterMain.ViewHolderItem this$0;

    ManageOfferListAdapterMain$ViewHolderItem$bindInfo$6(ManageOfferListAdapterMain.ViewHolderItem viewHolderItem, MobileNegotiationsList mobileNegotiationsList, int i) {
        this.this$0 = viewHolderItem;
        this.$mobileNegotiationsList = mobileNegotiationsList;
        this.$position = i;
    }

    public final void onClick(View view) {
        ManageOfferListAdapterMain.CustomManageItemClickListener listener = this.this$0.this$0.getListener();
        Intrinsics.checkExpressionValueIsNotNull(view, "it");
        listener.onManageActionButtonClick(view, this.$mobileNegotiationsList, this.$position, NegotiationActionEnum.RAISE_MY_BID);
    }
}
