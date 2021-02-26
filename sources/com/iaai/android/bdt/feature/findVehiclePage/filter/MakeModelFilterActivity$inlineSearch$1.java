package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.iaai.android.C2723R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\r"}, mo66933d2 = {"com/iaai/android/bdt/feature/findVehiclePage/filter/MakeModelFilterActivity$inlineSearch$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: MakeModelFilterActivity.kt */
public final class MakeModelFilterActivity$inlineSearch$1 implements TextWatcher {
    final /* synthetic */ MakeModelFilterActivity this$0;

    public void afterTextChanged(@Nullable Editable editable) {
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    MakeModelFilterActivity$inlineSearch$1(MakeModelFilterActivity makeModelFilterActivity) {
        this.this$0 = makeModelFilterActivity;
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            MakeModelFilterActivity.access$getMakeModelFilterAdapter$p(this.this$0).setFilterData(this.this$0.filterMakeModelValues);
            MakeModelFilterActivity.access$getMakeModelFilterAdapter$p(this.this$0).notifyDataSetChanged();
            ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivMakeModelCancel);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "ivMakeModelCancel");
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivMakeModelCancel);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "ivMakeModelCancel");
        imageView2.setVisibility(0);
        if (charSequence != null) {
            this.this$0.getSearchInfo((SpannableStringBuilder) charSequence);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.text.SpannableStringBuilder");
    }
}
