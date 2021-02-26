package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import com.iaai.android.C2723R;
import com.iaai.android.bdt.extensions.Regex_ExtensionKt;
import com.iaai.android.bdt.model.fastSearchFilter2.FacetXX;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.RegexOption;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, mo66933d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "<anonymous parameter 2>", "Landroid/view/KeyEvent;", "onEditorAction"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchMoreFilterActivity.kt */
final class FastSearchMoreFilterActivity$getIntentDataAndUpdateUI$2 implements TextView.OnEditorActionListener {
    final /* synthetic */ FastSearchMoreFilterActivity this$0;

    FastSearchMoreFilterActivity$getIntentDataAndUpdateUI$2(FastSearchMoreFilterActivity fastSearchMoreFilterActivity) {
        this.this$0 = fastSearchMoreFilterActivity;
    }

    public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return false;
        }
        EditText editText = (EditText) this.this$0._$_findCachedViewById(C2723R.C2726id.etSubFilterSearch);
        Intrinsics.checkExpressionValueIsNotNull(editText, "etSubFilterSearch");
        String obj = editText.getText().toString();
        Regex regex = new Regex("\\b" + obj + "[a-zA-Z]*\\b", RegexOption.IGNORE_CASE);
        Collection arrayList = new ArrayList();
        for (Object next : FastSearchMoreFilterActivity.access$getFacetXX$p(this.this$0)) {
            String value = ((FacetXX) next).getValue();
            if (value == null) {
                value = "";
            }
            if (Regex_ExtensionKt.filterSearch(regex, value)) {
                arrayList.add(next);
            }
        }
        FastSearchMoreFilterActivity.access$getFastSearchMoreFilterAdapter$p(this.this$0).facetXXData(CollectionsKt.toMutableList((List) arrayList), this.this$0.facetType, this.this$0.parentPosition);
        FastSearchMoreFilterActivity.access$getFastSearchMoreFilterAdapter$p(this.this$0).notifyDataSetChanged();
        return false;
    }
}
