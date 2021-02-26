package com.lowagie.text.pdf.internal;

import com.braintreepayments.api.models.BinData;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.ExtendedColor;
import com.lowagie.text.pdf.PatternColor;
import com.lowagie.text.pdf.PdfArray;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfGState;
import com.lowagie.text.pdf.PdfImage;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfObject;
import com.lowagie.text.pdf.PdfString;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.PdfXConformanceException;
import com.lowagie.text.pdf.ShadingColor;
import com.lowagie.text.pdf.SpotColor;
import com.lowagie.text.pdf.interfaces.PdfXConformance;
import harmony.java.awt.Color;

public class PdfXConformanceImp implements PdfXConformance {
    public static final int PDFXKEY_CMYK = 2;
    public static final int PDFXKEY_COLOR = 1;
    public static final int PDFXKEY_FONT = 4;
    public static final int PDFXKEY_GSTATE = 6;
    public static final int PDFXKEY_IMAGE = 5;
    public static final int PDFXKEY_LAYER = 7;
    public static final int PDFXKEY_RGB = 3;
    protected int pdfxConformance = 0;

    public void setPDFXConformance(int i) {
        this.pdfxConformance = i;
    }

    public int getPDFXConformance() {
        return this.pdfxConformance;
    }

    public boolean isPdfX() {
        return this.pdfxConformance != 0;
    }

    public boolean isPdfX1A2001() {
        return this.pdfxConformance == 1;
    }

    public boolean isPdfX32002() {
        return this.pdfxConformance == 2;
    }

    public boolean isPdfA1() {
        int i = this.pdfxConformance;
        return i == 3 || i == 4;
    }

    public boolean isPdfA1A() {
        return this.pdfxConformance == 3;
    }

    public void completeInfoDictionary(PdfDictionary pdfDictionary) {
        if (isPdfX() && !isPdfA1()) {
            if (pdfDictionary.get(PdfName.GTS_PDFXVERSION) == null) {
                if (isPdfX1A2001()) {
                    pdfDictionary.put(PdfName.GTS_PDFXVERSION, new PdfString("PDF/X-1:2001"));
                    pdfDictionary.put(new PdfName("GTS_PDFXConformance"), new PdfString("PDF/X-1a:2001"));
                } else if (isPdfX32002()) {
                    pdfDictionary.put(PdfName.GTS_PDFXVERSION, new PdfString("PDF/X-3:2002"));
                }
            }
            if (pdfDictionary.get(PdfName.TITLE) == null) {
                pdfDictionary.put(PdfName.TITLE, new PdfString("Pdf document"));
            }
            if (pdfDictionary.get(PdfName.CREATOR) == null) {
                pdfDictionary.put(PdfName.CREATOR, new PdfString(BinData.UNKNOWN));
            }
            if (pdfDictionary.get(PdfName.TRAPPED) == null) {
                pdfDictionary.put(PdfName.TRAPPED, new PdfName("False"));
            }
        }
    }

    public void completeExtraCatalog(PdfDictionary pdfDictionary) {
        if (isPdfX() && !isPdfA1() && pdfDictionary.get(PdfName.OUTPUTINTENTS) == null) {
            PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.OUTPUTINTENT);
            pdfDictionary2.put(PdfName.OUTPUTCONDITION, new PdfString("SWOP CGATS TR 001-1995"));
            pdfDictionary2.put(PdfName.OUTPUTCONDITIONIDENTIFIER, new PdfString("CGATS TR 001"));
            pdfDictionary2.put(PdfName.REGISTRYNAME, new PdfString("http://www.color.org"));
            pdfDictionary2.put(PdfName.INFO, new PdfString(""));
            pdfDictionary2.put(PdfName.f719S, PdfName.GTS_PDFX);
            pdfDictionary.put(PdfName.OUTPUTINTENTS, new PdfArray((PdfObject) pdfDictionary2));
        }
    }

    public static void checkPDFXConformance(PdfWriter pdfWriter, int i, Object obj) {
        PdfObject pdfObject;
        if (pdfWriter != null && pdfWriter.isPdfX()) {
            int pDFXConformance = pdfWriter.getPDFXConformance();
            switch (i) {
                case 1:
                    if (pDFXConformance == 1) {
                        if (obj instanceof ExtendedColor) {
                            ExtendedColor extendedColor = (ExtendedColor) obj;
                            int type = extendedColor.getType();
                            if (type == 0) {
                                throw new PdfXConformanceException("Colorspace RGB is not allowed.");
                            } else if (type != 1 && type != 2) {
                                if (type == 3) {
                                    checkPDFXConformance(pdfWriter, 1, ((SpotColor) extendedColor).getPdfSpotColor().getAlternativeCS());
                                    return;
                                } else if (type == 4) {
                                    checkPDFXConformance(pdfWriter, 1, ((PatternColor) extendedColor).getPainter().getDefaultColor());
                                    return;
                                } else if (type == 5) {
                                    checkPDFXConformance(pdfWriter, 1, ((ShadingColor) extendedColor).getPdfShadingPattern().getShading().getColorSpace());
                                    return;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else if (obj instanceof Color) {
                            throw new PdfXConformanceException("Colorspace RGB is not allowed.");
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                case 3:
                    if (pDFXConformance == 1) {
                        throw new PdfXConformanceException("Colorspace RGB is not allowed.");
                    }
                    return;
                case 4:
                    BaseFont baseFont = (BaseFont) obj;
                    if (!baseFont.isEmbedded()) {
                        throw new PdfXConformanceException("All the fonts must be embedded. This one isn't: " + baseFont.getPostscriptFontName());
                    }
                    return;
                case 5:
                    PdfImage pdfImage = (PdfImage) obj;
                    if (pdfImage.get(PdfName.SMASK) != null) {
                        throw new PdfXConformanceException("The /SMask key is not allowed in images.");
                    } else if (pDFXConformance != 1 || (pdfObject = pdfImage.get(PdfName.COLORSPACE)) == null) {
                        return;
                    } else {
                        if (pdfObject.isName()) {
                            if (PdfName.DEVICERGB.equals(pdfObject)) {
                                throw new PdfXConformanceException("Colorspace RGB is not allowed.");
                            }
                            return;
                        } else if (pdfObject.isArray() && PdfName.CALRGB.equals(((PdfArray) pdfObject).getPdfObject(0))) {
                            throw new PdfXConformanceException("Colorspace CalRGB is not allowed.");
                        } else {
                            return;
                        }
                    }
                case 6:
                    PdfDictionary pdfDictionary = (PdfDictionary) obj;
                    PdfObject pdfObject2 = pdfDictionary.get(PdfName.f650BM);
                    if (pdfObject2 == null || PdfGState.BM_NORMAL.equals(pdfObject2) || PdfGState.BM_COMPATIBLE.equals(pdfObject2)) {
                        PdfObject pdfObject3 = pdfDictionary.get(PdfName.f655CA);
                        if (pdfObject3 != null) {
                            double doubleValue = ((PdfNumber) pdfObject3).doubleValue();
                            if (doubleValue != 1.0d) {
                                throw new PdfXConformanceException("Transparency is not allowed: /CA = " + doubleValue);
                            }
                        }
                        PdfObject pdfObject4 = pdfDictionary.get(PdfName.f746ca);
                        if (pdfObject4 != null) {
                            double doubleValue2 = ((PdfNumber) pdfObject4).doubleValue();
                            if (doubleValue2 != 1.0d) {
                                throw new PdfXConformanceException("Transparency is not allowed: /ca = " + doubleValue2);
                            }
                            return;
                        }
                        return;
                    }
                    throw new PdfXConformanceException("Blend mode " + pdfObject2.toString() + " not allowed.");
                case 7:
                    throw new PdfXConformanceException("Layers are not allowed.");
                default:
                    return;
            }
        }
    }
}
