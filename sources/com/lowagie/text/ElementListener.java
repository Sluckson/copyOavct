package com.lowagie.text;

import java.util.EventListener;

public interface ElementListener extends EventListener {
    boolean add(Element element) throws DocumentException;
}
