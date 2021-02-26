package com.iaai.android.bdt.feature.findVehiclePage.filter;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Regex_ExtensionKt;
import com.iaai.android.bdt.model.filter.FilterValues;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import org.jetbrains.annotations.Nullable;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\r"}, mo66933d2 = {"com/iaai/android/bdt/feature/findVehiclePage/filter/SubFilterActivity$onCreate$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "p0", "Landroid/text/Editable;", "beforeTextChanged", "", "p1", "", "p2", "p3", "onTextChanged", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SubFilterActivity.kt */
public final class SubFilterActivity$onCreate$3 implements TextWatcher {
    final /* synthetic */ SubFilterActivity this$0;

    public void afterTextChanged(@Nullable Editable editable) {
    }

    public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
    }

    SubFilterActivity$onCreate$3(SubFilterActivity subFilterActivity) {
        this.this$0 = subFilterActivity;
    }

    public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence == null || charSequence.length() == 0) {
            SubFilterActivity.access$getSubFilterAdapter$p(this.this$0).setFilterData(this.this$0.filterValues, SubFilterActivity.access$getSelectedRefiner$p(this.this$0));
            SubFilterActivity.access$getSubFilterAdapter$p(this.this$0).notifyDataSetChanged();
            ImageView imageView = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivCancel);
            Intrinsics.checkExpressionValueIsNotNull(imageView, "ivCancel");
            imageView.setVisibility(8);
            return;
        }
        Regex regex = new Regex("\\b" + charSequence + "[a-zA-Z]*\\b", RegexOption.IGNORE_CASE);
        Collection arrayList = new ArrayList();
        for (Object next : this.this$0.filterValues) {
            String valuesId = ((FilterValues) next).getValuesId();
            if (valuesId == null) {
                valuesId = "";
            }
            if (Regex_ExtensionKt.filterSearch(regex, valuesId)) {
                arrayList.add(next);
            }
        }
        ImageView imageView2 = (ImageView) this.this$0._$_findCachedViewById(C2723R.C2726id.ivCancel);
        Intrinsics.checkExpressionValueIsNotNull(imageView2, "ivCancel");
        imageView2.setVisibility(0);
        SubFilterActivity.access$getSubFilterAdapter$p(this.this$0).setFilterData(CollectionsKt.toMutableList((List) arrayList), SubFilterActivity.access$getSelectedRefiner$p(this.this$0));
        SubFilterActivity.access$getSubFilterAdapter$p(this.this$0).notifyDataSetChanged();
    }
}
