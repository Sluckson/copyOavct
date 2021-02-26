package com.iaai.android.old.utils.p016ui;

/* renamed from: com.iaai.android.old.utils.ui.PromptOption */
public class PromptOption<T> {
    public final String label;
    public final T value;

    public PromptOption(T t) {
        this(t.toString(), t);
    }

    public PromptOption(String str, T t) {
        this.label = str;
        this.value = t;
    }

    public String toString() {
        return this.label;
    }
}
