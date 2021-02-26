package com.iaai.android.old.uicomponents;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.CheckBox;
import android.widget.Checkable;

public class InertCheckBox extends CheckBox implements Checkable {
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyShortcut(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTrackballEvent(MotionEvent motionEvent) {
        return false;
    }

    public InertCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public InertCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InertCheckBox(Context context) {
        super(context);
    }
}
