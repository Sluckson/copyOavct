package com.iaai.android.bdt.feature.account.watchlist;

import android.text.InputFilter;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0007\u001a\n \u0002*\u0004\u0018\u00010\b0\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\n¢\u0006\u0002\b\u000b"}, mo66933d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "src", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "Landroid/text/Spanned;", "<anonymous parameter 4>", "<anonymous parameter 5>", "filter"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: PreSaleListFragment.kt */
final class PreSaleListFragment$onActivityCreated$2 implements InputFilter {
    final /* synthetic */ Regex $pattern;

    PreSaleListFragment$onActivityCreated$2(Regex regex) {
        this.$pattern = regex;
    }

    public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (Intrinsics.areEqual((Object) charSequence, (Object) "")) {
            return charSequence;
        }
        if (this.$pattern.matches(charSequence.toString())) {
            return charSequence;
        }
        return "";
    }
}
