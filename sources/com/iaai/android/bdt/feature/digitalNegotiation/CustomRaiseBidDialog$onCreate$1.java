package com.iaai.android.bdt.feature.digitalNegotiation;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, mo66933d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: CustomRaiseBidDialog.kt */
final class CustomRaiseBidDialog$onCreate$1 implements TextView.OnEditorActionListener {
    final /* synthetic */ CustomRaiseBidDialog this$0;

    CustomRaiseBidDialog$onCreate$1(CustomRaiseBidDialog customRaiseBidDialog) {
        this.this$0 = customRaiseBidDialog;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i == 6) {
            EditText editText = (EditText) this.this$0.findViewById(C2723R.C2726id.etRaiseBid);
            Intrinsics.checkExpressionValueIsNotNull(editText, "etRaiseBid");
            String obj = editText.getText().toString();
            CharSequence charSequence = obj;
            int parseInt = !TextUtils.isEmpty(charSequence) ? Integer.parseInt(obj) : 0;
            TextInputLayout textInputLayout = (TextInputLayout) this.this$0.findViewById(C2723R.C2726id.txtRaiseBidLayout);
            Intrinsics.checkExpressionValueIsNotNull(textInputLayout, "txtRaiseBidLayout");
            textInputLayout.setErrorEnabled(false);
            if (TextUtils.isEmpty(charSequence)) {
                String string = this.this$0.getActivity().getResources().getString(C2723R.string.lbl_you_must_enter_value);
                TextInputLayout textInputLayout2 = (TextInputLayout) this.this$0.findViewById(C2723R.C2726id.txtRaiseBidLayout);
                Intrinsics.checkExpressionValueIsNotNull(textInputLayout2, "txtRaiseBidLayout");
                textInputLayout2.setErrorEnabled(true);
                TextInputLayout textInputLayout3 = (TextInputLayout) this.this$0.findViewById(C2723R.C2726id.txtRaiseBidLayout);
                Intrinsics.checkExpressionValueIsNotNull(textInputLayout3, "txtRaiseBidLayout");
                textInputLayout3.setError(string);
            } else if (parseInt % 25 != 0) {
                String string2 = this.this$0.getActivity().getResources().getString(C2723R.string.lbl_bdt_pre_bid_increment_msg);
                TextInputLayout textInputLayout4 = (TextInputLayout) this.this$0.findViewById(C2723R.C2726id.txtRaiseBidLayout);
                Intrinsics.checkExpressionValueIsNotNull(textInputLayout4, "txtRaiseBidLayout");
                textInputLayout4.setErrorEnabled(true);
                TextInputLayout textInputLayout5 = (TextInputLayout) this.this$0.findViewById(C2723R.C2726id.txtRaiseBidLayout);
                Intrinsics.checkExpressionValueIsNotNull(textInputLayout5, "txtRaiseBidLayout");
                textInputLayout5.setError(string2);
            } else {
                long j = (long) parseInt;
                if (j > this.this$0.getSellerOfferAmount()) {
                    Context context = this.this$0.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context, "context");
                    String string3 = context.getResources().getString(C2723R.string.lbl_error_msg_bid_less_than_seller_error);
                    TextInputLayout textInputLayout6 = (TextInputLayout) this.this$0.findViewById(C2723R.C2726id.txtRaiseBidLayout);
                    Intrinsics.checkExpressionValueIsNotNull(textInputLayout6, "txtRaiseBidLayout");
                    textInputLayout6.setErrorEnabled(true);
                    TextInputLayout textInputLayout7 = (TextInputLayout) this.this$0.findViewById(C2723R.C2726id.txtRaiseBidLayout);
                    Intrinsics.checkExpressionValueIsNotNull(textInputLayout7, "txtRaiseBidLayout");
                    textInputLayout7.setError(string3);
                } else if (j == this.this$0.getSellerOfferAmount()) {
                    Context context2 = this.this$0.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context2, "context");
                    Resources resources = context2.getResources();
                    StringBuilder sb = new StringBuilder();
                    sb.append(Typography.dollar);
                    sb.append(this.this$0.getSellerOfferAmount());
                    String string4 = resources.getString(C2723R.string.lbl_your_offer_matches_seller_amount, new Object[]{sb.toString()});
                    TextInputLayout textInputLayout8 = (TextInputLayout) this.this$0.findViewById(C2723R.C2726id.txtRaiseBidLayout);
                    Intrinsics.checkExpressionValueIsNotNull(textInputLayout8, "txtRaiseBidLayout");
                    textInputLayout8.setErrorEnabled(true);
                    TextInputLayout textInputLayout9 = (TextInputLayout) this.this$0.findViewById(C2723R.C2726id.txtRaiseBidLayout);
                    Intrinsics.checkExpressionValueIsNotNull(textInputLayout9, "txtRaiseBidLayout");
                    textInputLayout9.setError(string4);
                } else if (j <= this.this$0.getBuyAmount()) {
                    Context context3 = this.this$0.getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                    String string5 = context3.getResources().getString(C2723R.string.lbl_error_msg_greater_than_current_bid);
                    TextInputLayout textInputLayout10 = (TextInputLayout) this.this$0.findViewById(C2723R.C2726id.txtRaiseBidLayout);
                    Intrinsics.checkExpressionValueIsNotNull(textInputLayout10, "txtRaiseBidLayout");
                    textInputLayout10.setErrorEnabled(true);
                    TextInputLayout textInputLayout11 = (TextInputLayout) this.this$0.findViewById(C2723R.C2726id.txtRaiseBidLayout);
                    Intrinsics.checkExpressionValueIsNotNull(textInputLayout11, "txtRaiseBidLayout");
                    textInputLayout11.setError(string5);
                } else {
                    this.this$0.getListener().getRaisedBid(j);
                    this.this$0.dismiss();
                }
            }
        }
        return false;
    }
}
