package com.braintreepayments.cardform.utils;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Arrays;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class CardNumberTransformation implements TransformationMethod {
    private static final String FOUR_DOTS = "••••";

    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence.length() < 9) {
            return charSequence;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(FOUR_DOTS);
        sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
        sb.append(charSequence.subSequence(charSequence.length() - 4, charSequence.length()));
        char[] cArr = new char[(charSequence.length() - sb.length())];
        Arrays.fill(cArr, 0);
        sb.insert(0, cArr);
        return sb.toString();
    }
}
