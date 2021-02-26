package com.lowagie.text.pdf.hyphenation;

import java.util.ArrayList;

public interface PatternConsumer {
    void addClass(String str);

    void addException(String str, ArrayList arrayList);

    void addPattern(String str, String str2);
}
