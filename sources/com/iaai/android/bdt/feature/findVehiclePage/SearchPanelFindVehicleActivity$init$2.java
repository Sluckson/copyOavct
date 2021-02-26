package com.iaai.android.bdt.feature.findVehiclePage;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageButton;
import com.iaai.android.C2723R;
import com.lowagie.text.html.HtmlTags;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, mo66933d2 = {"com/iaai/android/bdt/feature/findVehiclePage/SearchPanelFindVehicleActivity$init$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: SearchPanelFindVehicleActivity.kt */
public final class SearchPanelFindVehicleActivity$init$2 implements TextWatcher {
    final /* synthetic */ SearchPanelFindVehicleActivity this$0;

    public void afterTextChanged(@NotNull Editable editable) {
        Intrinsics.checkParameterIsNotNull(editable, HtmlTags.f607S);
    }

    public void beforeTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(charSequence, HtmlTags.f607S);
    }

    SearchPanelFindVehicleActivity$init$2(SearchPanelFindVehicleActivity searchPanelFindVehicleActivity) {
        this.this$0 = searchPanelFindVehicleActivity;
    }

    public void onTextChanged(@NotNull CharSequence charSequence, int i, int i2, int i3) {
        Intrinsics.checkParameterIsNotNull(charSequence, HtmlTags.f607S);
        if (charSequence.length() > 2) {
            this.this$0.getSearchInfo((SpannableStringBuilder) charSequence);
        } else {
            SearchPanelFindVehicleActivity.access$getSearchSuggestionsAdapter$p(this.this$0).clearAllData();
            ImageButton imageButton = (ImageButton) this.this$0._$_findCachedViewById(C2723R.C2726id.img_clear_text);
            Intrinsics.checkExpressionValueIsNotNull(imageButton, "img_clear_text");
            imageButton.setVisibility(8);
            ImageButton imageButton2 = (ImageButton) this.this$0._$_findCachedViewById(C2723R.C2726id.img_voice_text);
            Intrinsics.checkExpressionValueIsNotNull(imageButton2, "img_voice_text");
            imageButton2.setVisibility(0);
            View _$_findCachedViewById = this.this$0._$_findCachedViewById(C2723R.C2726id.emptySuggestions);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById, "emptySuggestions");
            _$_findCachedViewById.setVisibility(8);
            this.this$0.initializeRecentlySelected();
        }
        boolean z = true;
        if (charSequence.length() == 0) {
            SearchPanelFindVehicleActivity.access$getSearchSuggestionsAdapter$p(this.this$0).clearAllData();
            ImageButton imageButton3 = (ImageButton) this.this$0._$_findCachedViewById(C2723R.C2726id.img_clear_text);
            Intrinsics.checkExpressionValueIsNotNull(imageButton3, "img_clear_text");
            imageButton3.setVisibility(8);
            ImageButton imageButton4 = (ImageButton) this.this$0._$_findCachedViewById(C2723R.C2726id.img_voice_text);
            Intrinsics.checkExpressionValueIsNotNull(imageButton4, "img_voice_text");
            imageButton4.setVisibility(0);
            View _$_findCachedViewById2 = this.this$0._$_findCachedViewById(C2723R.C2726id.emptySuggestions);
            Intrinsics.checkExpressionValueIsNotNull(_$_findCachedViewById2, "emptySuggestions");
            _$_findCachedViewById2.setVisibility(8);
            this.this$0.initializeRecentlySelected();
            return;
        }
        if (charSequence.length() <= 0) {
            z = false;
        }
        if (z) {
            ImageButton imageButton5 = (ImageButton) this.this$0._$_findCachedViewById(C2723R.C2726id.img_clear_text);
            Intrinsics.checkExpressionValueIsNotNull(imageButton5, "img_clear_text");
            if (imageButton5.getVisibility() == 8) {
                ImageButton imageButton6 = (ImageButton) this.this$0._$_findCachedViewById(C2723R.C2726id.img_clear_text);
                Intrinsics.checkExpressionValueIsNotNull(imageButton6, "img_clear_text");
                imageButton6.setVisibility(0);
                ImageButton imageButton7 = (ImageButton) this.this$0._$_findCachedViewById(C2723R.C2726id.img_voice_text);
                Intrinsics.checkExpressionValueIsNotNull(imageButton7, "img_voice_text");
                imageButton7.setVisibility(8);
            }
        }
    }
}
