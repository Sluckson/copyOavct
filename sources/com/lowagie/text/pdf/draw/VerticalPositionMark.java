package com.lowagie.text.pdf.draw;

import com.lowagie.text.Chunk;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.ElementListener;
import com.lowagie.text.pdf.PdfContentByte;
import java.util.ArrayList;

public class VerticalPositionMark implements DrawInterface, Element {
    protected DrawInterface drawInterface = null;
    protected float offset = 0.0f;

    public boolean isContent() {
        return true;
    }

    public boolean isNestable() {
        return false;
    }

    public int type() {
        return 55;
    }

    public VerticalPositionMark() {
    }

    public VerticalPositionMark(DrawInterface drawInterface2, float f) {
        this.drawInterface = drawInterface2;
        this.offset = f;
    }

    public void draw(PdfContentByte pdfContentByte, float f, float f2, float f3, float f4, float f5) {
        DrawInterface drawInterface2 = this.drawInterface;
        if (drawInterface2 != null) {
            drawInterface2.draw(pdfContentByte, f, f2, f3, f4, f5 + this.offset);
        }
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public ArrayList getChunks() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Chunk((DrawInterface) this, true));
        return arrayList;
    }

    public DrawInterface getDrawInterface() {
        return this.drawInterface;
    }

    public void setDrawInterface(DrawInterface drawInterface2) {
        this.drawInterface = drawInterface2;
    }

    public float getOffset() {
        return this.offset;
    }

    public void setOffset(float f) {
        this.offset = f;
    }
}
