package com.iaai.android.old.utils;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.iaai.android.old.utils.constants.Constants;
import java.text.NumberFormat;
import roboguice.util.C5058Ln;

public class Validator {
    public static boolean isValidZipCode(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.matches("[0-9]{5}");
    }

    public static class NumberFormatTextWatcher implements TextWatcher {
        private boolean isInAfterTextChanged;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (!this.isInAfterTextChanged) {
                this.isInAfterTextChanged = true;
                try {
                    editable.replace(0, editable.length(), NumberFormat.getInstance(Constants.APP_LOCALE).format((long) Integer.parseInt(editable.toString().replaceAll("\\D", ""))));
                } catch (NumberFormatException unused) {
                    editable.clear();
                }
                this.isInAfterTextChanged = false;
            }
        }
    }

    public static class DecimalFormatTextWatcher implements TextWatcher {
        private boolean isInAfterTextChanged;
        final int noOfDigits;
        final int scale;
        private String textBeforeChanged;

        public DecimalFormatTextWatcher(int i, int i2) {
            this.noOfDigits = i;
            this.scale = i2;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            C5058Ln.m4829d("DecimalFormatTextWatcher.beforeTextChanged s[%s] start[%d] count[%d] after[%d]", charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            this.textBeforeChanged = charSequence.toString();
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            C5058Ln.m4829d("DecimalFormatTextWatcher.onTextChanged s[%s] start[%d] before[%d] count[%d]", charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        }

        public void afterTextChanged(Editable editable) {
            String str;
            if (!this.isInAfterTextChanged) {
                this.isInAfterTextChanged = true;
                String obj = editable.toString();
                C5058Ln.m4829d("DecimalFormatTextWatcher.afterTextChanged rawText[%s]", obj);
                if (!TextUtils.isEmpty(obj)) {
                    int lastIndexOf = obj.lastIndexOf(".");
                    String str2 = "";
                    if (lastIndexOf == -1) {
                        str = obj.replaceAll("\\D", str2);
                    } else {
                        str = obj.substring(0, lastIndexOf).replaceAll("\\D", str2);
                        if (lastIndexOf != obj.length() - 1) {
                            str2 = obj.substring(lastIndexOf + 1).replaceAll("\\D", str2);
                        }
                        if (str2.length() > 2) {
                            str2 = str2.substring(0, 2);
                        }
                    }
                    try {
                        if (str.length() <= this.noOfDigits) {
                            if (str2.length() <= this.scale) {
                                String format = NumberFormat.getInstance(Constants.APP_LOCALE).format((long) Integer.parseInt(str));
                                if (lastIndexOf != -1) {
                                    format = format + "." + str2;
                                }
                                editable.replace(0, editable.length(), format);
                            }
                        }
                        editable.replace(0, editable.length(), this.textBeforeChanged);
                    } catch (NumberFormatException unused) {
                        editable.clear();
                    }
                }
                this.isInAfterTextChanged = false;
            }
        }
    }

    public static class DigitOnlyTextWatcher implements TextWatcher {
        private boolean isInAfterTextChanged;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (!this.isInAfterTextChanged) {
                this.isInAfterTextChanged = true;
                String replaceAll = editable.toString().replaceAll("\\D", "");
                int length = editable.length();
                if (replaceAll.length() != length) {
                    editable.replace(0, length, replaceAll);
                }
                this.isInAfterTextChanged = false;
            }
        }
    }
}
