package com.iaai.android.bdt.feature.myAccount.toBePaid.saleDocList;

import com.google.android.material.textfield.TextInputLayout;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo66933d2 = {"<anonymous>", "", "it", "", "invoke"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: InsertRepOrAddFragment.kt */
final class InsertRepOrAddFragment$addValidationOnEditText$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ int $editTextType;
    final /* synthetic */ String $errorMessage;
    final /* synthetic */ TextInputLayout $textInputLayout;
    final /* synthetic */ InsertRepOrAddFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InsertRepOrAddFragment$addValidationOnEditText$1(InsertRepOrAddFragment insertRepOrAddFragment, TextInputLayout textInputLayout, String str, int i) {
        super(1);
        this.this$0 = insertRepOrAddFragment;
        this.$textInputLayout = textInputLayout;
        this.$errorMessage = str;
        this.$editTextType = i;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "it");
        if (str.length() == 0) {
            this.$textInputLayout.setErrorEnabled(true);
            this.$textInputLayout.setError(this.$errorMessage);
        } else {
            int i = this.$editTextType;
            if (i == 4) {
                if (str.length() < 5) {
                    this.$textInputLayout.setErrorEnabled(true);
                    this.$textInputLayout.setError(this.this$0.getString(C2723R.string.lbl_error_valid_number, "5"));
                } else {
                    this.$textInputLayout.setErrorEnabled(false);
                }
            } else if (i == 5) {
                if (str.length() < 10) {
                    this.$textInputLayout.setErrorEnabled(true);
                    this.$textInputLayout.setError(this.this$0.getString(C2723R.string.lbl_error_valid_number, "10"));
                } else {
                    this.$textInputLayout.setErrorEnabled(false);
                }
            } else if (str.length() > 64 || str.length() < 2) {
                this.$textInputLayout.setErrorEnabled(true);
                this.$textInputLayout.setError(this.this$0.getString(C2723R.string.lbl_error_valid_characters));
            } else {
                this.$textInputLayout.setErrorEnabled(false);
            }
        }
        this.this$0.updateValidationFlag(this.$editTextType, !this.$textInputLayout.isErrorEnabled());
    }
}
