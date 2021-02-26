package com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle;

import android.app.Dialog;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(mo66931bv = {1, 0, 3}, mo66932d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo66933d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, mo66934k = 3, mo66935mv = {1, 1, 13})
/* compiled from: FastSearchExpandableAdapter.kt */
final class FastSearchExpandableAdapter$createCustomNumberPicker$4 implements View.OnClickListener {
    final /* synthetic */ NumberPicker $aNumberPicker;
    final /* synthetic */ Dialog $dialogView;
    final /* synthetic */ int $groupPos;
    final /* synthetic */ boolean $isMin;
    final /* synthetic */ Ref.ObjectRef $sliderVal;
    final /* synthetic */ TextView $textView;
    final /* synthetic */ FastSearchExpandableAdapter this$0;

    FastSearchExpandableAdapter$createCustomNumberPicker$4(FastSearchExpandableAdapter fastSearchExpandableAdapter, NumberPicker numberPicker, TextView textView, Ref.ObjectRef objectRef, boolean z, int i, Dialog dialog) {
        this.this$0 = fastSearchExpandableAdapter;
        this.$aNumberPicker = numberPicker;
        this.$textView = textView;
        this.$sliderVal = objectRef;
        this.$isMin = z;
        this.$groupPos = i;
        this.$dialogView = dialog;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onClick(android.view.View r10) {
        /*
            r9 = this;
            android.widget.NumberPicker r10 = r9.$aNumberPicker
            int r10 = r10.getValue()
            int r10 = r10 * 10000
            android.widget.TextView r0 = r9.$textView
            java.lang.String r1 = java.lang.String.valueOf(r10)
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            kotlin.jvm.internal.Ref$ObjectRef r0 = r9.$sliderVal
            boolean r1 = r9.$isMin
            r2 = 0
            if (r1 == 0) goto L_0x002e
            T r1 = r0.element
            r3 = r1
            kotlin.Triple r3 = (kotlin.Triple) r3
            if (r3 == 0) goto L_0x0042
            r4 = 0
            java.lang.Integer r5 = java.lang.Integer.valueOf(r10)
            r6 = 0
            r7 = 5
            r8 = 0
            kotlin.Triple r10 = kotlin.Triple.copy$default(r3, r4, r5, r6, r7, r8)
            goto L_0x0043
        L_0x002e:
            T r1 = r0.element
            r3 = r1
            kotlin.Triple r3 = (kotlin.Triple) r3
            if (r3 == 0) goto L_0x0042
            r4 = 0
            r5 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r10)
            r7 = 3
            r8 = 0
            kotlin.Triple r10 = kotlin.Triple.copy$default(r3, r4, r5, r6, r7, r8)
            goto L_0x0043
        L_0x0042:
            r10 = r2
        L_0x0043:
            r0.element = r10
            com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchExpandableAdapter r10 = r9.this$0
            int r0 = r9.$groupPos
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r3 = r9.$sliderVal
            T r3 = r3.element
            kotlin.Triple r3 = (kotlin.Triple) r3
            if (r3 == 0) goto L_0x005d
            java.lang.Object r3 = r3.getSecond()
            java.lang.Integer r3 = (java.lang.Integer) r3
            goto L_0x005e
        L_0x005d:
            r3 = r2
        L_0x005e:
            r1.append(r3)
            r3 = 45
            r1.append(r3)
            kotlin.jvm.internal.Ref$ObjectRef r3 = r9.$sliderVal
            T r3 = r3.element
            kotlin.Triple r3 = (kotlin.Triple) r3
            if (r3 == 0) goto L_0x0074
            java.lang.Object r2 = r3.getThird()
            java.lang.Integer r2 = (java.lang.Integer) r2
        L_0x0074:
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r10.updateListOnSelectItemForSlider(r0, r1)
            android.app.Dialog r10 = r9.$dialogView
            r10.dismiss()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.iaai.android.bdt.feature.fastSearchFilter.newFindVehicle.FastSearchExpandableAdapter$createCustomNumberPicker$4.onClick(android.view.View):void");
    }
}
