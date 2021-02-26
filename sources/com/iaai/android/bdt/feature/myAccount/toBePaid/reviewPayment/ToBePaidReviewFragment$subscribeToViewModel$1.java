package com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment;

import androidx.lifecycle.Observer;
import com.iaai.android.bdt.model.toBePaid.PayPalCheckOutResponse;
import kotlin.Metadata;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Lcom/iaai/android/bdt/model/toBePaid/PayPalCheckOutResponse;", "kotlin.jvm.PlatformType", "onChanged"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: ToBePaidReviewFragment.kt */
final class ToBePaidReviewFragment$subscribeToViewModel$1<T> implements Observer<PayPalCheckOutResponse> {
    final /* synthetic */ ToBePaidReviewFragment this$0;

    ToBePaidReviewFragment$subscribeToViewModel$1(ToBePaidReviewFragment toBePaidReviewFragment) {
        this.this$0 = toBePaidReviewFragment;
    }

    /* JADX WARNING: type inference failed for: r0v30, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onChanged(com.iaai.android.bdt.model.toBePaid.PayPalCheckOutResponse r12) {
        /*
            r11 = this;
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r0 = r11.this$0
            r1 = 0
            r0.showLoadingIndicator(r1)
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r0 = r11.this$0
            boolean r0 = r0.isAdded()
            if (r0 == 0) goto L_0x01ba
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r0 = r11.this$0
            int r2 = r0.apiCount
            r3 = 1
            int r2 = r2 - r3
            r0.apiCount = r2
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r0 = r11.this$0
            int r0 = r0.apiCount
            r2 = 0
            if (r0 != 0) goto L_0x00c3
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r0 = r11.this$0
            boolean r3 = r0.isAllTransactionFailed()
            r0.isAllFailed = r3
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r0 = r11.this$0
            boolean r0 = r0.isAllFailed
            if (r0 == 0) goto L_0x007a
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment$subscribeToViewModel$1$onAlertButtonClick$1 r0 = new com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment$subscribeToViewModel$1$onAlertButtonClick$1
            r0.<init>(r11)
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r1 = r11.this$0
            com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity r1 = com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment.access$getBdtPaymentActivity$p(r1)
            r2 = r1
            androidx.appcompat.app.AppCompatActivity r2 = (androidx.appcompat.app.AppCompatActivity) r2
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r1 = r11.this$0
            r3 = 2131821635(0x7f110443, float:1.9276019E38)
            java.lang.String r4 = r1.getString(r3)
            java.lang.String r1 = "getString(R.string.lbl_paypal_transaction_error)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r1)
            r5 = 2131821339(0x7f11031b, float:1.9275418E38)
            r6 = 2131821161(0x7f110269, float:1.9275057E38)
            r7 = r0
            com.iaai.android.bdt.extensions.OnAlertButtonClick r7 = (com.iaai.android.bdt.extensions.OnAlertButtonClick) r7
            java.lang.String r3 = "Error"
            android.app.Dialog r0 = com.iaai.android.bdt.extensions.Activity_ExtensionKt.showAlertWithTitle(r2, r3, r4, r5, r6, r7)
            if (r0 == 0) goto L_0x0063
            r0.show()
        L_0x0063:
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            java.lang.String r12 = r0.toJson((java.lang.Object) r12)
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r0 = r11.this$0
            java.lang.String r1 = "responseString"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r12, r1)
            java.lang.String r1 = "200"
            r0.logIAAErrorOnFailure(r12, r1)
            goto L_0x01ba
        L_0x007a:
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            r12.logIAAPaymentEvents()
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragmentDirections$Companion r12 = com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragmentDirections.Companion
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r0 = r11.this$0
            java.util.List r0 = r0.getSelectedItemsList()
            if (r0 == 0) goto L_0x009f
            java.util.Collection r0 = (java.util.Collection) r0
            com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue[] r1 = new com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue[r1]
            java.lang.Object[] r0 = r0.toArray(r1)
            if (r0 == 0) goto L_0x0097
            r2 = r0
            com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue[] r2 = (com.iaai.android.bdt.model.toBePaid.paymentDueList.PaymentDue[]) r2
            goto L_0x009f
        L_0x0097:
            kotlin.TypeCastException r12 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r12.<init>(r0)
            throw r12
        L_0x009f:
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r0 = r11.this$0
            double r0 = r0.getCdfFee()
            float r0 = (float) r0
            androidx.navigation.NavDirections r12 = r12.actionToBePaidReviewFragmentToConfirmationFragment(r2, r0)
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r0 = r11.this$0
            com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity r0 = com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment.access$getBdtPaymentActivity$p(r0)
            android.app.Activity r0 = (android.app.Activity) r0
            r1 = 2131297604(0x7f090544, float:1.8213158E38)
            androidx.navigation.NavController r0 = androidx.navigation.Navigation.findNavController(r0, r1)
            java.lang.String r1 = "Navigation.findNavContro…d.main_nav_host_fragment)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            r0.navigate((androidx.navigation.NavDirections) r12)
            goto L_0x01ba
        L_0x00c3:
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            r12.showLoadingIndicator(r3)
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            int r0 = r12.counter
            int r0 = r0 + r3
            r12.counter = r0
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            com.iaai.android.bdt.feature.login.SessionManager r12 = r12.getSessionManager()
            boolean r12 = r12.isCurrentSessionUserlbsParentIndicator()
            r0 = 1376(0x560, float:1.928E-42)
            java.lang.String r1 = "AppUtils.getDeviceId(bdtPaymentActivity)"
            if (r12 == 0) goto L_0x0166
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            java.util.ArrayList r2 = r12.filterListLBS
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r3 = r11.this$0
            int r3 = r3.counter
            java.lang.Object r2 = r2.get(r3)
            kotlin.Pair r2 = (kotlin.Pair) r2
            java.lang.Object r2 = r2.getFirst()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            r12.currentBuyerId = r2
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            com.iaai.android.bdt.feature.myAccount.toBePaid.ToBePaidViewModel r2 = r12.getViewModel()
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            java.lang.String r3 = r12.getAuthString()
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity r12 = com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment.access$getBdtPaymentActivity$p(r12)
            android.content.Context r12 = (android.content.Context) r12
            java.lang.String r4 = com.iaai.android.old.utils.AppUtils.getDeviceId(r12)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r1)
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            java.lang.String r6 = r12.PAYPAL_API_KEY
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            java.lang.String r7 = r12.CONTENT_TYPE
            java.lang.String r8 = java.lang.String.valueOf(r0)
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            java.util.ArrayList r0 = r12.filterListLBS
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r1 = r11.this$0
            int r1 = r1.counter
            java.lang.Object r0 = r0.get(r1)
            kotlin.Pair r0 = (kotlin.Pair) r0
            java.lang.Object r0 = r0.getFirst()
            java.lang.Integer r0 = (java.lang.Integer) r0
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r1 = r11.this$0
            java.util.ArrayList r1 = r1.filterListLBS
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r5 = r11.this$0
            int r5 = r5.counter
            java.lang.Object r1 = r1.get(r5)
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r1 = r1.getSecond()
            java.util.List r1 = (java.util.List) r1
            com.iaai.android.bdt.model.toBePaid.MakePayPalPaymentRequest r9 = r12.getMakePayPalCheckOutRequestBodyFinal(r0, r1)
            java.lang.String r5 = "android"
            r2.makePayPalCheckOut(r3, r4, r5, r6, r7, r8, r9)
            goto L_0x01ba
        L_0x0166:
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            int r3 = r12.counter
            r12.currentBuyerId = r3
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            com.iaai.android.bdt.feature.myAccount.toBePaid.ToBePaidViewModel r3 = r12.getViewModel()
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            java.lang.String r4 = r12.getAuthString()
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            com.iaai.android.bdt.feature.myAccount.toBePaid.BDTPaymentActivity r12 = com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment.access$getBdtPaymentActivity$p(r12)
            android.content.Context r12 = (android.content.Context) r12
            java.lang.String r5 = com.iaai.android.old.utils.AppUtils.getDeviceId(r12)
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r5, r1)
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            java.lang.String r7 = r12.PAYPAL_API_KEY
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            java.lang.String r8 = r12.CONTENT_TYPE
            java.lang.String r9 = java.lang.String.valueOf(r0)
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r12 = r11.this$0
            java.util.ArrayList r0 = r12.filterListForOtherUsers
            com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment r1 = r11.this$0
            int r1 = r1.counter
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r1 = "filterListForOtherUsers[counter]"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r0, r1)
            java.util.List r0 = (java.util.List) r0
            com.iaai.android.bdt.model.toBePaid.MakePayPalPaymentRequest r10 = r12.getMakePayPalCheckOutRequestBodyFinal(r2, r0)
            java.lang.String r6 = "android"
            r3.makePayPalCheckOut(r4, r5, r6, r7, r8, r9, r10)
        L_0x01ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.myAccount.toBePaid.reviewPayment.ToBePaidReviewFragment$subscribeToViewModel$1.onChanged(com.iaai.android.bdt.model.toBePaid.PayPalCheckOutResponse):void");
    }
}
