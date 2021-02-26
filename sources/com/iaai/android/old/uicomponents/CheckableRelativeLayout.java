package com.iaai.android.old.uicomponents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.RelativeLayout;
import java.util.ArrayList;
import java.util.List;

public class CheckableRelativeLayout extends RelativeLayout implements Checkable {
    private List<Checkable> checkableViews;
    private boolean isChecked;

    public CheckableRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(attributeSet);
    }

    public CheckableRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public CheckableRelativeLayout(Context context, int i) {
        super(context);
        init((AttributeSet) null);
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
        for (Checkable checked : this.checkableViews) {
            checked.setChecked(z);
        }
    }

    public void toggle() {
        this.isChecked = !this.isChecked;
        for (Checkable checkable : this.checkableViews) {
            checkable.toggle();
        }
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            findCheckableChildren(getChildAt(i));
        }
    }

    private void init(AttributeSet attributeSet) {
        this.isChecked = false;
        this.checkableViews = new ArrayList(5);
    }

    private void findCheckableChildren(View view) {
        if (view instanceof Checkable) {
            this.checkableViews.add((Checkable) view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                findCheckableChildren(viewGroup.getChildAt(i));
            }
        }
    }
}
