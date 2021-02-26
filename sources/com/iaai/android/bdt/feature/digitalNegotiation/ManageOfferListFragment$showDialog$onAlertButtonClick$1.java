package com.iaai.android.bdt.feature.digitalNegotiation;

import com.iaai.android.BuildConfig;
import com.iaai.android.bdt.extensions.OnAlertButtonClick;
import com.iaai.android.bdt.feature.digitalNegotiation.ManageOfferListFragment;
import com.iaai.android.bdt.model.digitalNegotiation.ManageOfferSendActionRequestBody;
import com.iaai.android.bdt.model.digitalNegotiation.MobileNegotiationsList;
import com.iaai.android.old.utils.AppUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, mo66933d2 = {"com/iaai/android/bdt/feature/digitalNegotiation/ManageOfferListFragment$showDialog$onAlertButtonClick$1", "Lcom/iaai/android/bdt/extensions/OnAlertButtonClick;", "onCancelClick", "", "onOKClick", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: ManageOfferListFragment.kt */
public final class ManageOfferListFragment$showDialog$onAlertButtonClick$1 implements OnAlertButtonClick {
    final /* synthetic */ NegotiationActionEnum $action;
    final /* synthetic */ MobileNegotiationsList $data;
    final /* synthetic */ Ref.LongRef $raisebidAmount;
    final /* synthetic */ ManageOfferListFragment this$0;

    public void onCancelClick() {
    }

    ManageOfferListFragment$showDialog$onAlertButtonClick$1(ManageOfferListFragment manageOfferListFragment, NegotiationActionEnum negotiationActionEnum, MobileNegotiationsList mobileNegotiationsList, Ref.LongRef longRef) {
        this.this$0 = manageOfferListFragment;
        this.$action = negotiationActionEnum;
        this.$data = mobileNegotiationsList;
        this.$raisebidAmount = longRef;
    }

    public void onOKClick() {
        Long sellerOfferAmount;
        Long bidAmount;
        int i = ManageOfferListFragment.WhenMappings.$EnumSwitchMapping$1[this.$action.ordinal()];
        long j = 0;
        if (i == 1) {
            ManageOfferListFragment manageOfferListFragment = this.this$0;
            NegotiationActionEnum negotiationActionEnum = this.$action;
            MobileNegotiationsList mobileNegotiationsList = this.$data;
            if (!(mobileNegotiationsList == null || (sellerOfferAmount = mobileNegotiationsList.getSellerOfferAmount()) == null)) {
                j = sellerOfferAmount.longValue();
            }
            ManageOfferSendActionRequestBody access$getOfferActionRequestBody = manageOfferListFragment.getOfferActionRequestBody(negotiationActionEnum, mobileNegotiationsList, j);
            ManageOfferListViewModel access$getViewModel$p = ManageOfferListFragment.access$getViewModel$p(this.this$0);
            String authString = this.this$0.getAuthString();
            String deviceId = AppUtils.getDeviceId(ManageOfferListFragment.access$getManageOfferListActivity$p(this.this$0));
            Intrinsics.checkExpressionValueIsNotNull(deviceId, "AppUtils.getDeviceId(manageOfferListActivity)");
            access$getViewModel$p.sendManageOfferAction(authString, deviceId, "android", this.this$0.DN_API_KEY, this.this$0.CONTENT_TYPE, String.valueOf(BuildConfig.VERSION_CODE), access$getOfferActionRequestBody);
        } else if (i == 2) {
            ManageOfferListFragment manageOfferListFragment2 = this.this$0;
            NegotiationActionEnum negotiationActionEnum2 = this.$action;
            MobileNegotiationsList mobileNegotiationsList2 = this.$data;
            if (!(mobileNegotiationsList2 == null || (bidAmount = mobileNegotiationsList2.getBidAmount()) == null)) {
                j = bidAmount.longValue();
            }
            ManageOfferSendActionRequestBody access$getOfferActionRequestBody2 = manageOfferListFragment2.getOfferActionRequestBody(negotiationActionEnum2, mobileNegotiationsList2, j);
            ManageOfferListViewModel access$getViewModel$p2 = ManageOfferListFragment.access$getViewModel$p(this.this$0);
            String authString2 = this.this$0.getAuthString();
            String deviceId2 = AppUtils.getDeviceId(ManageOfferListFragment.access$getManageOfferListActivity$p(this.this$0));
            Intrinsics.checkExpressionValueIsNotNull(deviceId2, "AppUtils.getDeviceId(manageOfferListActivity)");
            access$getViewModel$p2.sendManageOfferAction(authString2, deviceId2, "android", this.this$0.DN_API_KEY, this.this$0.CONTENT_TYPE, String.valueOf(BuildConfig.VERSION_CODE), access$getOfferActionRequestBody2);
        } else if (i == 3) {
            ManageOfferSendActionRequestBody access$getOfferActionRequestBody3 = this.this$0.getOfferActionRequestBody(this.$action, this.$data, this.$raisebidAmount.element);
            ManageOfferListViewModel access$getViewModel$p3 = ManageOfferListFragment.access$getViewModel$p(this.this$0);
            String authString3 = this.this$0.getAuthString();
            String deviceId3 = AppUtils.getDeviceId(ManageOfferListFragment.access$getManageOfferListActivity$p(this.this$0));
            Intrinsics.checkExpressionValueIsNotNull(deviceId3, "AppUtils.getDeviceId(manageOfferListActivity)");
            access$getViewModel$p3.sendManageOfferAction(authString3, deviceId3, "android", this.this$0.DN_API_KEY, this.this$0.CONTENT_TYPE, String.valueOf(BuildConfig.VERSION_CODE), access$getOfferActionRequestBody3);
        }
    }
}
