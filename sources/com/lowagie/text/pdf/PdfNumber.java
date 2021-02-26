package com.lowagie.text.pdf;

public class PdfNumber extends PdfObject {
    private double value;

    public PdfNumber(String str) {
        super(2);
        try {
            this.value = Double.parseDouble(str.trim());
            setContent(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException(String.valueOf(str) + " is not a valid number - " + e.toString());
        }
    }

    public PdfNumber(int i) {
        super(2);
        this.value = (double) i;
        setContent(String.valueOf(i));
    }

    public PdfNumber(double d) {
        super(2);
        this.value = d;
        setContent(ByteBuffer.formatDouble(d));
    }

    public PdfNumber(float f) {
        this((double) f);
    }

    public int intValue() {
        return (int) this.value;
    }

    public double doubleValue() {
        return this.value;
    }

    public float floatValue() {
        return (float) this.value;
    }

    public void increment() {
        this.value += 1.0d;
        setContent(ByteBuffer.formatDouble(this.value));
    }
}
