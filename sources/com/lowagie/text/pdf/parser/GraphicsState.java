package com.lowagie.text.pdf.parser;

import com.lowagie.text.pdf.CMapAwareDocumentFont;

public class GraphicsState {
    float characterSpacing;
    Matrix ctm;
    CMapAwareDocumentFont font;
    float fontSize;
    float horizontalScaling;
    boolean knockout;
    float leading;
    int renderMode;
    float rise;
    float wordSpacing;

    public GraphicsState() {
        this.ctm = new Matrix();
        this.characterSpacing = 0.0f;
        this.wordSpacing = 0.0f;
        this.horizontalScaling = 1.0f;
        this.leading = 0.0f;
        this.font = null;
        this.fontSize = 0.0f;
        this.renderMode = 0;
        this.rise = 0.0f;
        this.knockout = true;
    }

    public GraphicsState(GraphicsState graphicsState) {
        this.ctm = graphicsState.ctm;
        this.characterSpacing = graphicsState.characterSpacing;
        this.wordSpacing = graphicsState.wordSpacing;
        this.horizontalScaling = graphicsState.horizontalScaling;
        this.leading = graphicsState.leading;
        this.font = graphicsState.font;
        this.fontSize = graphicsState.fontSize;
        this.renderMode = graphicsState.renderMode;
        this.rise = graphicsState.rise;
        this.knockout = graphicsState.knockout;
    }
}
