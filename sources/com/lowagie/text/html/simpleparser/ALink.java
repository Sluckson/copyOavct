package com.lowagie.text.html.simpleparser;

import com.lowagie.text.Paragraph;

public interface ALink {
    boolean process(Paragraph paragraph, ChainedProperties chainedProperties);
}
