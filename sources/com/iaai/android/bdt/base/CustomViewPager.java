package com.iaai.android.bdt.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0014¨\u0006\r"}, mo66933d2 = {"Lcom/iaai/android/bdt/base/CustomViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onMeasure", "", "widthMeasureSpec", "", "heightMeasureSpec", "app_productionRelease"}, mo66934k = 1, mo66935mv = {1, 1, 13})
/* compiled from: CustomViewPager.kt */
public final class CustomViewPager extends ViewPager {
    private HashMap _$_findViewCache;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomViewPager(@NotNull @NonNull Context context) {
        super(context);
        Intrinsics.checkParameterIsNotNull(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomViewPager(@NotNull @NonNull Context context, @NotNull @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(attributeSet, "attrs");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        try {
            View childAt = getChildAt(0);
            if (childAt != null) {
                childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
                i2 = View.MeasureSpec.makeMeasureSpec(childAt.getMeasuredHeight(), 1073741824);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        super.onMeasure(i, i2);
    }
}
