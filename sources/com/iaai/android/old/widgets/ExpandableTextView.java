package com.iaai.android.old.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.iaai.android.C2723R;

public class ExpandableTextView extends TextView {
    private static final int DEFAULT_TRIM_LENGTH = 100;
    private static final String ELLIPSIS = "...";
    private TextView.BufferType bufferType;
    private CharSequence originalText;
    /* access modifiers changed from: private */
    public boolean trim;
    private int trimLength;
    private CharSequence trimmedText;

    public ExpandableTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.trim = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2723R.styleable.ExpandableTextView);
        this.trimLength = obtainStyledAttributes.getInt(0, 100);
        obtainStyledAttributes.recycle();
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ExpandableTextView expandableTextView = ExpandableTextView.this;
                boolean unused = expandableTextView.trim = !expandableTextView.trim;
                ExpandableTextView.this.setText();
                ExpandableTextView.this.requestFocusFromTouch();
            }
        });
    }

    /* access modifiers changed from: private */
    public void setText() {
        super.setText(getDisplayableText(), this.bufferType);
    }

    private CharSequence getDisplayableText() {
        return this.trim ? this.trimmedText : this.originalText;
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType2) {
        this.originalText = charSequence;
        this.trimmedText = getTrimmedText(charSequence);
        this.bufferType = bufferType2;
        setText();
    }

    private CharSequence getTrimmedText(CharSequence charSequence) {
        int i;
        CharSequence charSequence2 = this.originalText;
        if (charSequence2 == null || charSequence2.length() <= (i = this.trimLength)) {
            return this.originalText;
        }
        return new SpannableStringBuilder(this.originalText, 0, i + 1).append(ELLIPSIS);
    }

    public CharSequence getOriginalText() {
        return this.originalText;
    }

    public void setTrimLength(int i) {
        this.trimLength = i;
        this.trimmedText = getTrimmedText(this.originalText);
        setText();
    }

    public int getTrimLength() {
        return this.trimLength;
    }
}
