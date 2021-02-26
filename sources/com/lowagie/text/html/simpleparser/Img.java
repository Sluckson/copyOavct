package com.lowagie.text.html.simpleparser;

import com.lowagie.text.DocListener;
import com.lowagie.text.Image;
import java.util.HashMap;

public interface Img {
    boolean process(Image image, HashMap hashMap, ChainedProperties chainedProperties, DocListener docListener);
}
