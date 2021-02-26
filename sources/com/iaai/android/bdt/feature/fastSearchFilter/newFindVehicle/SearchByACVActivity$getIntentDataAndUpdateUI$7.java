package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.String_ExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\r"}, mo66933d2 = {"com/iaai/android/bdt/feature/fastSearchFilter/newFindVehicle/SearchByACVActivity$getIntentDataAndUpdateUI$7", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchByACVActivity.kt */
public final class SearchByACVActivity$getIntentDataAndUpdateUI$7 implements TextWatcher {
    final /* synthetic */ SearchByACVActivity this$0;

    public void afterTextChanged(@Nullable Editable editable) {
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    SearchByACVActivity$getIntentDataAndUpdateUI$7(SearchByACVActivity searchByACVActivity) {
        this.this$0 = searchByACVActivity;
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivCancel1);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "ivCancel1");
            imageView.setVisibility(8);
            ((EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etStart)).setText("$");
            this.this$0.setSelectFilterEnabled(false);
        } else if (charSequence.length() == 1) {
            ImageView imageView2 = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivCancel1);
            Intrinsics.checkExpressionValueIsNotNull(imageView2, "ivCancel1");
            imageView2.setVisibility(8);
            this.this$0.setSelectFilterEnabled(false);
        } else {
            TextWatcher textWatcher = this;
            ((EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etStart)).removeTextChangedListener(textWatcher);
            ((EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etStart)).setText(Typography.dollar + String_ExtensionKt.getFormattedString(charSequence.subSequence(1, charSequence.length()).toString()));
            EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etStart);
            Intrinsics.checkExpressionValueIsNotNull(editText, "etStart");
            ((EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etStart)).setSelection(editText.getText().length());
            ((EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etStart)).addTextChangedListener(textWatcher);
            ImageView imageView3 = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivCancel1);
            Intrinsics.checkExpressionValueIsNotNull(imageView3, "ivCancel1");
            imageView3.setVisibility(0);
            this.this$0.setSelectFilterEnabled(true);
        }
    }
}
