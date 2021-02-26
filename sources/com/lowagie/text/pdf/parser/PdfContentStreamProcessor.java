package com.lowagie.text.pdf.parser;

import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.pdf.CMapAwareDocumentFont;
import com.lowagie.text.pdf.PRIndirectReference;
import com.lowagie.text.pdf.PRTokeniser;
import com.lowagie.text.pdf.PdfArray;
import com.lowagie.text.pdf.PdfContentParser;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfLiteral;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfString;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Stack;

public abstract class PdfContentStreamProcessor {
    /* access modifiers changed from: private */
    public Stack gsStack = new Stack();
    private Map operators;
    /* access modifiers changed from: private */
    public PdfDictionary resources;
    /* access modifiers changed from: private */
    public Matrix textLineMatrix;
    /* access modifiers changed from: private */
    public Matrix textMatrix;

    public abstract void displayText(String str, Matrix matrix);

    public PdfContentStreamProcessor() {
        populateOperators();
        reset();
    }

    private void populateOperators() {
        this.operators = new HashMap();
        this.operators.put("q", new PushGraphicsState((PushGraphicsState) null));
        this.operators.put("Q", new PopGraphicsState((PopGraphicsState) null));
        this.operators.put("cm", new ModifyCurrentTransformationMatrix((ModifyCurrentTransformationMatrix) null));
        this.operators.put("gs", new ProcessGraphicsStateResource((ProcessGraphicsStateResource) null));
        this.operators.put("Tc", new SetTextCharacterSpacing((SetTextCharacterSpacing) null));
        this.operators.put("Tw", new SetTextWordSpacing((SetTextWordSpacing) null));
        this.operators.put("Tz", new SetTextHorizontalScaling((SetTextHorizontalScaling) null));
        this.operators.put("TL", new SetTextLeading((SetTextLeading) null));
        this.operators.put("Tf", new SetTextFont((SetTextFont) null));
        this.operators.put("Tr", new SetTextRenderMode((SetTextRenderMode) null));
        this.operators.put("Ts", new SetTextRise((SetTextRise) null));
        this.operators.put("BT", new BeginText((BeginText) null));
        this.operators.put("ET", new EndText((EndText) null));
        this.operators.put("Td", new TextMoveStartNextLine((TextMoveStartNextLine) null));
        this.operators.put("TD", new TextMoveStartNextLineWithLeading((TextMoveStartNextLineWithLeading) null));
        this.operators.put("Tm", new TextSetTextMatrix((TextSetTextMatrix) null));
        this.operators.put("T*", new TextMoveNextLine((TextMoveNextLine) null));
        this.operators.put("Tj", new ShowText((ShowText) null));
        this.operators.put("'", new MoveNextLineAndShowText((MoveNextLineAndShowText) null));
        this.operators.put("\"", new MoveNextLineAndShowTextWithSpacing((MoveNextLineAndShowTextWithSpacing) null));
        this.operators.put("TJ", new ShowTextArray((ShowTextArray) null));
    }

    public void reset() {
        this.gsStack.removeAllElements();
        this.gsStack.add(new GraphicsState());
        this.textMatrix = null;
        this.textLineMatrix = null;
        this.resources = null;
    }

    /* renamed from: gs */
    public GraphicsState mo54701gs() {
        return (GraphicsState) this.gsStack.peek();
    }

    public Matrix getCurrentTextMatrix() {
        return this.textMatrix;
    }

    public Matrix getCurrentTextLineMatrix() {
        return this.textLineMatrix;
    }

    public void invokeOperator(PdfLiteral pdfLiteral, ArrayList arrayList) {
        ContentOperator contentOperator = (ContentOperator) this.operators.get(pdfLiteral.toString());
        if (contentOperator != null) {
            contentOperator.invoke(this, pdfLiteral, arrayList);
        }
    }

    private String decode(PdfString pdfString) {
        byte[] bytes = pdfString.getBytes();
        return mo54701gs().font.decode(bytes, 0, bytes.length);
    }

    public float getStringWidth(String str, float f) {
        CMapAwareDocumentFont cMapAwareDocumentFont = mo54701gs().font;
        char[] charArray = str.toCharArray();
        float f2 = 0.0f;
        for (int i = 0; i < charArray.length; i++) {
            f2 += ((((((float) cMapAwareDocumentFont.getWidth((int) charArray[i])) / 1000.0f) - (f / 1000.0f)) * mo54701gs().fontSize) + mo54701gs().characterSpacing + (charArray[i] == ' ' ? mo54701gs().wordSpacing : 0.0f)) * mo54701gs().horizontalScaling;
        }
        return f2;
    }

    public void displayPdfString(PdfString pdfString, float f) {
        String decode = decode(pdfString);
        Matrix multiply = new Matrix(getStringWidth(decode, f), 0.0f).multiply(this.textMatrix);
        displayText(decode, multiply);
        this.textMatrix = multiply;
    }

    public void processContent(byte[] bArr, PdfDictionary pdfDictionary) {
        reset();
        this.resources = pdfDictionary;
        try {
            PdfContentParser pdfContentParser = new PdfContentParser(new PRTokeniser(bArr));
            ArrayList arrayList = new ArrayList();
            while (pdfContentParser.parse(arrayList).size() > 0) {
                invokeOperator((PdfLiteral) arrayList.get(arrayList.size() - 1), arrayList);
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private static class ShowTextArray implements ContentOperator {
        private ShowTextArray() {
        }

        /* synthetic */ ShowTextArray(ShowTextArray showTextArray) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            ListIterator listIterator = ((PdfArray) arrayList.get(0)).listIterator();
            while (true) {
                float f = 0.0f;
                while (listIterator.hasNext()) {
                    Object next = listIterator.next();
                    if (next instanceof PdfString) {
                        pdfContentStreamProcessor.displayPdfString((PdfString) next, f);
                    } else {
                        f = ((PdfNumber) next).floatValue();
                    }
                }
                return;
            }
        }
    }

    private static class MoveNextLineAndShowTextWithSpacing implements ContentOperator {
        private MoveNextLineAndShowTextWithSpacing() {
        }

        /* synthetic */ MoveNextLineAndShowTextWithSpacing(MoveNextLineAndShowTextWithSpacing moveNextLineAndShowTextWithSpacing) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(0, (PdfNumber) arrayList.get(0));
            pdfContentStreamProcessor.invokeOperator(new PdfLiteral("Tw"), arrayList2);
            ArrayList arrayList3 = new ArrayList(1);
            arrayList3.add(0, (PdfNumber) arrayList.get(1));
            pdfContentStreamProcessor.invokeOperator(new PdfLiteral("Tc"), arrayList3);
            ArrayList arrayList4 = new ArrayList(1);
            arrayList4.add(0, (PdfString) arrayList.get(2));
            pdfContentStreamProcessor.invokeOperator(new PdfLiteral("'"), arrayList4);
        }
    }

    private static class MoveNextLineAndShowText implements ContentOperator {
        private MoveNextLineAndShowText() {
        }

        /* synthetic */ MoveNextLineAndShowText(MoveNextLineAndShowText moveNextLineAndShowText) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            pdfContentStreamProcessor.invokeOperator(new PdfLiteral("T*"), new ArrayList(0));
            pdfContentStreamProcessor.invokeOperator(new PdfLiteral("Tj"), arrayList);
        }
    }

    private static class ShowText implements ContentOperator {
        private ShowText() {
        }

        /* synthetic */ ShowText(ShowText showText) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            pdfContentStreamProcessor.displayPdfString((PdfString) arrayList.get(0), 0.0f);
        }
    }

    private static class TextMoveNextLine implements ContentOperator {
        private TextMoveNextLine() {
        }

        /* synthetic */ TextMoveNextLine(TextMoveNextLine textMoveNextLine) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            ArrayList arrayList2 = new ArrayList(2);
            arrayList2.add(0, new PdfNumber(0));
            arrayList2.add(1, new PdfNumber(pdfContentStreamProcessor.mo54701gs().leading));
            pdfContentStreamProcessor.invokeOperator(new PdfLiteral("Td"), arrayList2);
        }
    }

    private static class TextSetTextMatrix implements ContentOperator {
        private TextSetTextMatrix() {
        }

        /* synthetic */ TextSetTextMatrix(TextSetTextMatrix textSetTextMatrix) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            pdfContentStreamProcessor.textLineMatrix = new Matrix(((PdfNumber) arrayList.get(0)).floatValue(), ((PdfNumber) arrayList.get(1)).floatValue(), ((PdfNumber) arrayList.get(2)).floatValue(), ((PdfNumber) arrayList.get(3)).floatValue(), ((PdfNumber) arrayList.get(4)).floatValue(), ((PdfNumber) arrayList.get(5)).floatValue());
            pdfContentStreamProcessor.textMatrix = pdfContentStreamProcessor.textLineMatrix;
        }
    }

    private static class TextMoveStartNextLineWithLeading implements ContentOperator {
        private TextMoveStartNextLineWithLeading() {
        }

        /* synthetic */ TextMoveStartNextLineWithLeading(TextMoveStartNextLineWithLeading textMoveStartNextLineWithLeading) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            float floatValue = ((PdfNumber) arrayList.get(1)).floatValue();
            ArrayList arrayList2 = new ArrayList(1);
            arrayList2.add(0, new PdfNumber(-floatValue));
            pdfContentStreamProcessor.invokeOperator(new PdfLiteral("TL"), arrayList2);
            pdfContentStreamProcessor.invokeOperator(new PdfLiteral("Td"), arrayList);
        }
    }

    private static class TextMoveStartNextLine implements ContentOperator {
        private TextMoveStartNextLine() {
        }

        /* synthetic */ TextMoveStartNextLine(TextMoveStartNextLine textMoveStartNextLine) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            pdfContentStreamProcessor.textMatrix = new Matrix(((PdfNumber) arrayList.get(0)).floatValue(), ((PdfNumber) arrayList.get(1)).floatValue()).multiply(pdfContentStreamProcessor.textLineMatrix);
            pdfContentStreamProcessor.textLineMatrix = pdfContentStreamProcessor.textMatrix;
        }
    }

    private static class SetTextFont implements ContentOperator {
        private SetTextFont() {
        }

        /* synthetic */ SetTextFont(SetTextFont setTextFont) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            float floatValue = ((PdfNumber) arrayList.get(1)).floatValue();
            pdfContentStreamProcessor.mo54701gs().font = new CMapAwareDocumentFont((PRIndirectReference) pdfContentStreamProcessor.resources.getAsDict(PdfName.FONT).get((PdfName) arrayList.get(0)));
            pdfContentStreamProcessor.mo54701gs().fontSize = floatValue;
        }
    }

    private static class SetTextRenderMode implements ContentOperator {
        private SetTextRenderMode() {
        }

        /* synthetic */ SetTextRenderMode(SetTextRenderMode setTextRenderMode) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            pdfContentStreamProcessor.mo54701gs().renderMode = ((PdfNumber) arrayList.get(0)).intValue();
        }
    }

    private static class SetTextRise implements ContentOperator {
        private SetTextRise() {
        }

        /* synthetic */ SetTextRise(SetTextRise setTextRise) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            pdfContentStreamProcessor.mo54701gs().rise = ((PdfNumber) arrayList.get(0)).floatValue();
        }
    }

    private static class SetTextLeading implements ContentOperator {
        private SetTextLeading() {
        }

        /* synthetic */ SetTextLeading(SetTextLeading setTextLeading) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            pdfContentStreamProcessor.mo54701gs().leading = ((PdfNumber) arrayList.get(0)).floatValue();
        }
    }

    private static class SetTextHorizontalScaling implements ContentOperator {
        private SetTextHorizontalScaling() {
        }

        /* synthetic */ SetTextHorizontalScaling(SetTextHorizontalScaling setTextHorizontalScaling) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            pdfContentStreamProcessor.mo54701gs().horizontalScaling = ((PdfNumber) arrayList.get(0)).floatValue();
        }
    }

    private static class SetTextCharacterSpacing implements ContentOperator {
        private SetTextCharacterSpacing() {
        }

        /* synthetic */ SetTextCharacterSpacing(SetTextCharacterSpacing setTextCharacterSpacing) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            pdfContentStreamProcessor.mo54701gs().characterSpacing = ((PdfNumber) arrayList.get(0)).floatValue();
        }
    }

    private static class SetTextWordSpacing implements ContentOperator {
        private SetTextWordSpacing() {
        }

        /* synthetic */ SetTextWordSpacing(SetTextWordSpacing setTextWordSpacing) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            pdfContentStreamProcessor.mo54701gs().wordSpacing = ((PdfNumber) arrayList.get(0)).floatValue();
        }
    }

    private static class ProcessGraphicsStateResource implements ContentOperator {
        private ProcessGraphicsStateResource() {
        }

        /* synthetic */ ProcessGraphicsStateResource(ProcessGraphicsStateResource processGraphicsStateResource) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            PdfName pdfName = (PdfName) arrayList.get(0);
            PdfDictionary asDict = pdfContentStreamProcessor.resources.getAsDict(PdfName.EXTGSTATE);
            if (asDict != null) {
                PdfDictionary asDict2 = asDict.getAsDict(pdfName);
                if (asDict2 != null) {
                    PdfArray asArray = asDict2.getAsArray(PdfName.FONT);
                    if (asArray != null) {
                        CMapAwareDocumentFont cMapAwareDocumentFont = new CMapAwareDocumentFont((PRIndirectReference) asArray.getPdfObject(0));
                        float floatValue = asArray.getAsNumber(1).floatValue();
                        pdfContentStreamProcessor.mo54701gs().font = cMapAwareDocumentFont;
                        pdfContentStreamProcessor.mo54701gs().fontSize = floatValue;
                        return;
                    }
                    return;
                }
                throw new IllegalArgumentException(pdfName + " is an unknown graphics state dictionary");
            }
            throw new IllegalArgumentException("Resources do not contain ExtGState entry. Unable to process operator " + pdfLiteral);
        }
    }

    private static class PushGraphicsState implements ContentOperator {
        private PushGraphicsState() {
        }

        /* synthetic */ PushGraphicsState(PushGraphicsState pushGraphicsState) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            pdfContentStreamProcessor.gsStack.push(new GraphicsState((GraphicsState) pdfContentStreamProcessor.gsStack.peek()));
        }
    }

    private static class ModifyCurrentTransformationMatrix implements ContentOperator {
        private ModifyCurrentTransformationMatrix() {
        }

        /* synthetic */ ModifyCurrentTransformationMatrix(ModifyCurrentTransformationMatrix modifyCurrentTransformationMatrix) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            Matrix matrix = new Matrix(((PdfNumber) arrayList.get(0)).floatValue(), ((PdfNumber) arrayList.get(1)).floatValue(), ((PdfNumber) arrayList.get(2)).floatValue(), ((PdfNumber) arrayList.get(3)).floatValue(), ((PdfNumber) arrayList.get(4)).floatValue(), ((PdfNumber) arrayList.get(5)).floatValue());
            GraphicsState graphicsState = (GraphicsState) pdfContentStreamProcessor.gsStack.peek();
            graphicsState.ctm = graphicsState.ctm.multiply(matrix);
        }
    }

    private static class PopGraphicsState implements ContentOperator {
        private PopGraphicsState() {
        }

        /* synthetic */ PopGraphicsState(PopGraphicsState popGraphicsState) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            pdfContentStreamProcessor.gsStack.pop();
        }
    }

    private static class BeginText implements ContentOperator {
        private BeginText() {
        }

        /* synthetic */ BeginText(BeginText beginText) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            pdfContentStreamProcessor.textMatrix = new Matrix();
            pdfContentStreamProcessor.textLineMatrix = pdfContentStreamProcessor.textMatrix;
        }
    }

    private static class EndText implements ContentOperator {
        private EndText() {
        }

        /* synthetic */ EndText(EndText endText) {
            this();
        }

        public void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList) {
            pdfContentStreamProcessor.textMatrix = null;
            pdfContentStreamProcessor.textLineMatrix = null;
        }
    }
}
