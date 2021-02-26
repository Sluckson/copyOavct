package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, mo66933d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "hasFocus", "", "onFocusChange"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: DeliveryMethodActivity.kt */
final class DeliveryMethodActivity$initializeUI$4 implements View.OnFocusChangeListener {
    final /* synthetic */ DeliveryMethodActivity this$0;

    DeliveryMethodActivity$initializeUI$4(DeliveryMethodActivity deliveryMethodActivity) {
        this.this$0 = deliveryMethodActivity;
    }

    public final void onFocusChange(View view, boolean z) {
        ((EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etAddNotes)).post(new Runnable(this) {
            final /* synthetic */ DeliveryMethodActivity$initializeUI$4 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                Object systemService = this.this$0.this$0.getSystemService("input_method");
                if (systemService != null) {
                    ((InputMethodManager) systemService).showSoftInput((EditText) this.this$0.this$0._$_findCachedViewById(C2723R.C2726id.etAddNotes), 1);
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            }
        });
    }
}
