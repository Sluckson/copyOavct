package com.iaai.android.old.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.iaai.android.C2723R;

public class OneLineCheckableListItem extends RelativeLayout implements Checkable {
    private boolean checked;

    public OneLineCheckableListItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setChecked(boolean z) {
        this.checked = z;
        ((ImageView) findViewById(C2723R.C2726id.SelectImageView)).setImageResource(z ? C2723R.C2725drawable.ic_toggle_checkbox_checked : C2723R.C2725drawable.ic_toggle_checkbox_blank);
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void toggle() {
        this.checked = !this.checked;
    }
}
