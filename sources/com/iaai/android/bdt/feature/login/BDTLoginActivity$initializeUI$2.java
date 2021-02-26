package com.iaai.android.bdt.feature.login;

import android.widget.TextView;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo66933d2 = {"<anonymous>", "", "it", "", "invoke"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: BDTLoginActivity.kt */
final class BDTLoginActivity$initializeUI$2 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ BDTLoginActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BDTLoginActivity$initializeUI$2(BDTLoginActivity bDTLoginActivity) {
        super(1);
        this.this$0 = bDTLoginActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        TextView textView = (TextView) this.this$0._$_findCachedViewById(C2723R.C2726id.tvLogin);
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvLogin");
        textView.setEnabled(this.this$0.hasAllRequiredField());
    }
}
