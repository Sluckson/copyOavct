package com.lowagie.text.pdf;

import com.lowagie.text.Chunk;
import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.AcroFields;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.security.PrivateKey;
import java.security.cert.CRL;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

public class PdfSignatureAppearance {
    public static final int CERTIFIED_FORM_FILLING = 2;
    public static final int CERTIFIED_FORM_FILLING_AND_ANNOTATIONS = 3;
    public static final int CERTIFIED_NO_CHANGES_ALLOWED = 1;
    private static final float MARGIN = 2.0f;
    public static final int NOT_CERTIFIED = 0;
    public static final PdfName SELF_SIGNED = PdfName.ADOBE_PPKLITE;
    public static final int SignatureRenderDescription = 0;
    public static final int SignatureRenderGraphicAndDescription = 2;
    public static final int SignatureRenderNameAndDescription = 1;
    private static final float TOP_SECTION = 0.3f;
    public static final PdfName VERISIGN_SIGNED = PdfName.VERISIGN_PPKVS;
    public static final PdfName WINCER_SIGNED = PdfName.ADOBE_PPKMS;
    public static final String questionMark = "% DSUnknown\nq\n1 G\n1 g\n0.1 0 0 0.1 9 0 cm\n0 J 0 j 4 M []0 d\n1 i \n0 g\n313 292 m\n313 404 325 453 432 529 c\n478 561 504 597 504 645 c\n504 736 440 760 391 760 c\n286 760 271 681 265 626 c\n265 625 l\n100 625 l\n100 828 253 898 381 898 c\n451 898 679 878 679 650 c\n679 555 628 499 538 435 c\n488 399 467 376 467 292 c\n313 292 l\nh\n308 214 170 -164 re\nf\n0.44 G\n1.2 w\n1 1 0.4 rg\n287 318 m\n287 430 299 479 406 555 c\n451 587 478 623 478 671 c\n478 762 414 786 365 786 c\n260 786 245 707 239 652 c\n239 651 l\n74 651 l\n74 854 227 924 355 924 c\n425 924 653 904 653 676 c\n653 581 602 525 512 461 c\n462 425 441 402 441 318 c\n287 318 l\nh\n282 240 170 -164 re\nB\nQ\n";
    private boolean acro6Layers;
    private PdfTemplate[] app = new PdfTemplate[5];
    private byte[] bout;
    private int boutLen;
    private Certificate[] certChain;
    private int certificationLevel = 0;
    private String contact;
    private CRL[] crlList;
    private PdfDictionary cryptoDictionary;
    private String digestEncryptionAlgorithm;
    private HashMap exclusionLocations;
    private byte[] externalDigest;
    private byte[] externalRSAdata;
    private String fieldName;
    private PdfName filter;
    private PdfTemplate frm;
    private Image image;
    private float imageScale;
    private Font layer2Font;
    private String layer2Text;
    private String layer4Text;
    private String location;
    private boolean newField;
    private OutputStream originalout;
    private int page = 1;
    private Rectangle pageRect;
    private boolean preClosed = false;
    private PrivateKey privKey;
    private String provider;
    private RandomAccessFile raf;
    private int[] range;
    private String reason;
    private Rectangle rect;
    private int render = 0;
    private int runDirection = 1;
    private PdfSigGenericPKCS sigStandard;
    private Calendar signDate;
    private SignatureEvent signatureEvent;
    private Image signatureGraphic = null;
    private ByteBuffer sigout;
    private PdfStamper stamper;
    private File tempFile;
    private PdfStamperImp writer;

    public interface SignatureEvent {
        void getSignatureDictionary(PdfDictionary pdfDictionary);
    }

    PdfSignatureAppearance(PdfStamperImp pdfStamperImp) {
        this.writer = pdfStamperImp;
        this.signDate = new GregorianCalendar();
        this.fieldName = getNewSigName();
    }

    public int getRender() {
        return this.render;
    }

    public void setRender(int i) {
        this.render = i;
    }

    public Image getSignatureGraphic() {
        return this.signatureGraphic;
    }

    public void setSignatureGraphic(Image image2) {
        this.signatureGraphic = image2;
    }

    public void setLayer2Text(String str) {
        this.layer2Text = str;
    }

    public String getLayer2Text() {
        return this.layer2Text;
    }

    public void setLayer4Text(String str) {
        this.layer4Text = str;
    }

    public String getLayer4Text() {
        return this.layer4Text;
    }

    public Rectangle getRect() {
        return this.rect;
    }

    public boolean isInvisible() {
        Rectangle rectangle = this.rect;
        return rectangle == null || rectangle.getWidth() == 0.0f || this.rect.getHeight() == 0.0f;
    }

    public void setCrypto(PrivateKey privateKey, Certificate[] certificateArr, CRL[] crlArr, PdfName pdfName) {
        this.privKey = privateKey;
        this.certChain = certificateArr;
        this.crlList = crlArr;
        this.filter = pdfName;
    }

    public void setVisibleSignature(Rectangle rectangle, int i, String str) {
        if (str != null) {
            if (str.indexOf(46) >= 0) {
                throw new IllegalArgumentException("Field names cannot contain a dot.");
            } else if (this.writer.getAcroFields().getFieldItem(str) == null) {
                this.fieldName = str;
            } else {
                throw new IllegalArgumentException("The field " + str + " already exists.");
            }
        }
        if (i < 1 || i > this.writer.reader.getNumberOfPages()) {
            throw new IllegalArgumentException("Invalid page number: " + i);
        }
        this.pageRect = new Rectangle(rectangle);
        this.pageRect.normalize();
        this.rect = new Rectangle(this.pageRect.getWidth(), this.pageRect.getHeight());
        this.page = i;
        this.newField = true;
    }

    public void setVisibleSignature(String str) {
        AcroFields.Item fieldItem = this.writer.getAcroFields().getFieldItem(str);
        if (fieldItem != null) {
            PdfDictionary merged = fieldItem.getMerged(0);
            if (PdfName.SIG.equals(PdfReader.getPdfObject(merged.get(PdfName.f678FT)))) {
                this.fieldName = str;
                PdfArray asArray = merged.getAsArray(PdfName.RECT);
                this.pageRect = new Rectangle(asArray.getAsNumber(0).floatValue(), asArray.getAsNumber(1).floatValue(), asArray.getAsNumber(2).floatValue(), asArray.getAsNumber(3).floatValue());
                this.pageRect.normalize();
                this.page = fieldItem.getPage(0).intValue();
                int pageRotation = this.writer.reader.getPageRotation(this.page);
                Rectangle pageSizeWithRotation = this.writer.reader.getPageSizeWithRotation(this.page);
                if (pageRotation == 90) {
                    this.pageRect = new Rectangle(this.pageRect.getBottom(), pageSizeWithRotation.getTop() - this.pageRect.getLeft(), this.pageRect.getTop(), pageSizeWithRotation.getTop() - this.pageRect.getRight());
                } else if (pageRotation == 180) {
                    this.pageRect = new Rectangle(pageSizeWithRotation.getRight() - this.pageRect.getLeft(), pageSizeWithRotation.getTop() - this.pageRect.getBottom(), pageSizeWithRotation.getRight() - this.pageRect.getRight(), pageSizeWithRotation.getTop() - this.pageRect.getTop());
                } else if (pageRotation == 270) {
                    this.pageRect = new Rectangle(pageSizeWithRotation.getRight() - this.pageRect.getBottom(), this.pageRect.getLeft(), pageSizeWithRotation.getRight() - this.pageRect.getTop(), this.pageRect.getRight());
                }
                if (pageRotation != 0) {
                    this.pageRect.normalize();
                }
                this.rect = new Rectangle(this.pageRect.getWidth(), this.pageRect.getHeight());
                return;
            }
            throw new IllegalArgumentException("The field " + str + " is not a signature field.");
        }
        throw new IllegalArgumentException("The field " + str + " does not exist.");
    }

    public PdfTemplate getLayer(int i) {
        if (i < 0) {
            return null;
        }
        PdfTemplate[] pdfTemplateArr = this.app;
        if (i >= pdfTemplateArr.length) {
            return null;
        }
        PdfTemplate pdfTemplate = pdfTemplateArr[i];
        if (pdfTemplate != null) {
            return pdfTemplate;
        }
        PdfTemplate pdfTemplate2 = new PdfTemplate(this.writer);
        pdfTemplateArr[i] = pdfTemplate2;
        pdfTemplate2.setBoundingBox(this.rect);
        PdfStamperImp pdfStamperImp = this.writer;
        pdfStamperImp.addDirectTemplateSimple(pdfTemplate2, new PdfName("n" + i));
        return pdfTemplate2;
    }

    public PdfTemplate getTopLayer() {
        if (this.frm == null) {
            this.frm = new PdfTemplate(this.writer);
            this.frm.setBoundingBox(this.rect);
            this.writer.addDirectTemplateSimple(this.frm, new PdfName("FRM"));
        }
        return this.frm;
    }

    public PdfTemplate getAppearance() throws DocumentException {
        float f;
        Font font;
        PdfTemplate pdfTemplate;
        Font font2;
        Rectangle rectangle;
        Rectangle rectangle2;
        if (isInvisible()) {
            PdfTemplate pdfTemplate2 = new PdfTemplate(this.writer);
            pdfTemplate2.setBoundingBox(new Rectangle(0.0f, 0.0f));
            this.writer.addDirectTemplateSimple(pdfTemplate2, (PdfName) null);
            return pdfTemplate2;
        }
        PdfTemplate[] pdfTemplateArr = this.app;
        if (pdfTemplateArr[0] == null) {
            PdfTemplate pdfTemplate3 = new PdfTemplate(this.writer);
            pdfTemplateArr[0] = pdfTemplate3;
            pdfTemplate3.setBoundingBox(new Rectangle(100.0f, 100.0f));
            this.writer.addDirectTemplateSimple(pdfTemplate3, new PdfName("n0"));
            pdfTemplate3.setLiteral("% DSBlank\n");
        }
        PdfTemplate[] pdfTemplateArr2 = this.app;
        if (pdfTemplateArr2[1] == null && !this.acro6Layers) {
            PdfTemplate pdfTemplate4 = new PdfTemplate(this.writer);
            pdfTemplateArr2[1] = pdfTemplate4;
            pdfTemplate4.setBoundingBox(new Rectangle(100.0f, 100.0f));
            this.writer.addDirectTemplateSimple(pdfTemplate4, new PdfName("n1"));
            pdfTemplate4.setLiteral(questionMark);
        }
        if (this.app[2] == null) {
            String str = this.layer2Text;
            if (str == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Digitally signed by ");
                stringBuffer.append(PdfPKCS7.getSubjectFields((X509Certificate) this.certChain[0]).getField("CN"));
                stringBuffer.append(10);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z");
                stringBuffer.append("Date: ");
                stringBuffer.append(simpleDateFormat.format(this.signDate.getTime()));
                if (this.reason != null) {
                    stringBuffer.append(10);
                    stringBuffer.append("Reason: ");
                    stringBuffer.append(this.reason);
                }
                if (this.location != null) {
                    stringBuffer.append(10);
                    stringBuffer.append("Location: ");
                    stringBuffer.append(this.location);
                }
                str = stringBuffer.toString();
            }
            PdfTemplate[] pdfTemplateArr3 = this.app;
            PdfTemplate pdfTemplate5 = new PdfTemplate(this.writer);
            pdfTemplateArr3[2] = pdfTemplate5;
            pdfTemplate5.setBoundingBox(this.rect);
            this.writer.addDirectTemplateSimple(pdfTemplate5, new PdfName("n2"));
            Image image2 = this.image;
            if (image2 != null) {
                float f2 = this.imageScale;
                if (f2 == 0.0f) {
                    pdfTemplate5.addImage(image2, this.rect.getWidth(), 0.0f, 0.0f, this.rect.getHeight(), 0.0f, 0.0f);
                    pdfTemplate = pdfTemplate5;
                } else {
                    pdfTemplate = pdfTemplate5;
                    if (f2 < 0.0f) {
                        f2 = Math.min(this.rect.getWidth() / this.image.getWidth(), this.rect.getHeight() / this.image.getHeight());
                    }
                    float width = this.image.getWidth() * f2;
                    float height = this.image.getHeight() * f2;
                    pdfTemplate.addImage(this.image, width, 0.0f, 0.0f, height, (this.rect.getWidth() - width) / 2.0f, (this.rect.getHeight() - height) / 2.0f);
                }
            } else {
                pdfTemplate = pdfTemplate5;
            }
            Font font3 = this.layer2Font;
            if (font3 == null) {
                font2 = new Font();
            } else {
                font2 = new Font(font3);
            }
            float size = font2.getSize();
            int i = this.render;
            if (i == 1 || (i == 2 && this.signatureGraphic != null)) {
                rectangle2 = new Rectangle(2.0f, 2.0f, (this.rect.getWidth() / 2.0f) - 2.0f, this.rect.getHeight() - 2.0f);
                rectangle = new Rectangle((this.rect.getWidth() / 2.0f) + 1.0f, 2.0f, this.rect.getWidth() - 1.0f, this.rect.getHeight() - 2.0f);
                if (this.rect.getHeight() > this.rect.getWidth()) {
                    rectangle2 = new Rectangle(2.0f, this.rect.getHeight() / 2.0f, this.rect.getWidth() - 2.0f, this.rect.getHeight());
                    rectangle = new Rectangle(2.0f, 2.0f, this.rect.getWidth() - 2.0f, (this.rect.getHeight() / 2.0f) - 2.0f);
                }
            } else {
                rectangle = new Rectangle(2.0f, 2.0f, this.rect.getWidth() - 2.0f, (this.rect.getHeight() * 0.7f) - 2.0f);
                rectangle2 = null;
            }
            int i2 = this.render;
            if (i2 == 1) {
                String field = PdfPKCS7.getSubjectFields((X509Certificate) this.certChain[0]).getField("CN");
                float fitText = fitText(font2, field, new Rectangle(rectangle2.getWidth() - 2.0f, rectangle2.getHeight() - 2.0f), -1.0f, this.runDirection);
                ColumnText columnText = new ColumnText(pdfTemplate);
                columnText.setRunDirection(this.runDirection);
                columnText.setSimpleColumn(new Phrase(field, font2), rectangle2.getLeft(), rectangle2.getBottom(), rectangle2.getRight(), rectangle2.getTop(), fitText, 0);
                columnText.mo52494go();
            } else if (i2 == 2) {
                ColumnText columnText2 = new ColumnText(pdfTemplate);
                columnText2.setRunDirection(this.runDirection);
                columnText2.setSimpleColumn(rectangle2.getLeft(), rectangle2.getBottom(), rectangle2.getRight(), rectangle2.getTop(), 0.0f, 2);
                Image instance = Image.getInstance(this.signatureGraphic);
                instance.scaleToFit(rectangle2.getWidth(), rectangle2.getHeight());
                Paragraph paragraph = new Paragraph();
                paragraph.add(new Chunk(instance, ((rectangle2.getWidth() - instance.getScaledWidth()) / 2.0f) + 0.0f + ((rectangle2.getWidth() - instance.getScaledWidth()) / 2.0f), ((-instance.getScaledHeight()) + 15.0f) - ((rectangle2.getHeight() - instance.getScaledHeight()) / 2.0f), false));
                columnText2.addElement(paragraph);
                columnText2.mo52494go();
            }
            if (size <= 0.0f) {
                size = fitText(font2, str, new Rectangle(rectangle.getWidth(), rectangle.getHeight()), 12.0f, this.runDirection);
            }
            ColumnText columnText3 = new ColumnText(pdfTemplate);
            columnText3.setRunDirection(this.runDirection);
            columnText3.setSimpleColumn(new Phrase(str, font2), rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), size, 0);
            columnText3.mo52494go();
        }
        PdfTemplate[] pdfTemplateArr4 = this.app;
        if (pdfTemplateArr4[3] == null && !this.acro6Layers) {
            PdfTemplate pdfTemplate6 = new PdfTemplate(this.writer);
            pdfTemplateArr4[3] = pdfTemplate6;
            pdfTemplate6.setBoundingBox(new Rectangle(100.0f, 100.0f));
            this.writer.addDirectTemplateSimple(pdfTemplate6, new PdfName("n3"));
            pdfTemplate6.setLiteral("% DSBlank\n");
        }
        PdfTemplate[] pdfTemplateArr5 = this.app;
        if (pdfTemplateArr5[4] == null && !this.acro6Layers) {
            PdfTemplate pdfTemplate7 = new PdfTemplate(this.writer);
            pdfTemplateArr5[4] = pdfTemplate7;
            pdfTemplate7.setBoundingBox(new Rectangle(0.0f, this.rect.getHeight() * 0.7f, this.rect.getRight(), this.rect.getTop()));
            this.writer.addDirectTemplateSimple(pdfTemplate7, new PdfName("n4"));
            Font font4 = this.layer2Font;
            if (font4 == null) {
                font = new Font();
            } else {
                font = new Font(font4);
            }
            font.getSize();
            String str2 = this.layer4Text;
            if (str2 == null) {
                str2 = "Signature Not Verified";
            }
            float fitText2 = fitText(font, str2, new Rectangle(this.rect.getWidth() - 4.0f, (this.rect.getHeight() * TOP_SECTION) - 4.0f), 15.0f, this.runDirection);
            ColumnText columnText4 = new ColumnText(pdfTemplate7);
            columnText4.setRunDirection(this.runDirection);
            columnText4.setSimpleColumn(new Phrase(str2, font), 2.0f, 0.0f, this.rect.getWidth() - 2.0f, this.rect.getHeight() - 2.0f, fitText2, 0);
            columnText4.mo52494go();
        }
        int pageRotation = this.writer.reader.getPageRotation(this.page);
        Rectangle rectangle3 = new Rectangle(this.rect);
        for (int i3 = pageRotation; i3 > 0; i3 -= 90) {
            rectangle3 = rectangle3.rotate();
        }
        if (this.frm == null) {
            this.frm = new PdfTemplate(this.writer);
            this.frm.setBoundingBox(rectangle3);
            this.writer.addDirectTemplateSimple(this.frm, new PdfName("FRM"));
            float min = Math.min(this.rect.getWidth(), this.rect.getHeight()) * 0.9f;
            float width2 = (this.rect.getWidth() - min) / 2.0f;
            float height2 = (this.rect.getHeight() - min) / 2.0f;
            float f3 = min / 100.0f;
            if (pageRotation == 90) {
                this.frm.concatCTM(0.0f, 1.0f, -1.0f, 0.0f, this.rect.getHeight(), 0.0f);
            } else if (pageRotation == 180) {
                this.frm.concatCTM(-1.0f, 0.0f, 0.0f, -1.0f, this.rect.getWidth(), this.rect.getHeight());
            } else if (pageRotation == 270) {
                this.frm.concatCTM(0.0f, -1.0f, 1.0f, 0.0f, 0.0f, this.rect.getWidth());
            }
            this.frm.addTemplate(this.app[0], 0.0f, 0.0f);
            if (!this.acro6Layers) {
                this.frm.addTemplate(this.app[1], f3, 0.0f, 0.0f, f3, width2, height2);
            }
            this.frm.addTemplate(this.app[2], 0.0f, 0.0f);
            if (!this.acro6Layers) {
                this.frm.addTemplate(this.app[3], f3, 0.0f, 0.0f, f3, width2, height2);
                f = 0.0f;
                this.frm.addTemplate(this.app[4], 0.0f, 0.0f);
                PdfTemplate pdfTemplate8 = new PdfTemplate(this.writer);
                pdfTemplate8.setBoundingBox(rectangle3);
                this.writer.addDirectTemplateSimple(pdfTemplate8, (PdfName) null);
                pdfTemplate8.addTemplate(this.frm, f, f);
                return pdfTemplate8;
            }
        }
        f = 0.0f;
        PdfTemplate pdfTemplate82 = new PdfTemplate(this.writer);
        pdfTemplate82.setBoundingBox(rectangle3);
        this.writer.addDirectTemplateSimple(pdfTemplate82, (PdfName) null);
        pdfTemplate82.addTemplate(this.frm, f, f);
        return pdfTemplate82;
    }

    public static float fitText(Font font, String str, Rectangle rectangle, float f, int i) {
        float f2;
        Font font2 = font;
        String str2 = str;
        int i2 = i;
        float f3 = 0.0f;
        if (f <= 0.0f) {
            try {
                char[] charArray = str.toCharArray();
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < charArray.length; i5++) {
                    if (charArray[i5] == 10) {
                        i4++;
                    } else if (charArray[i5] == 13) {
                        i3++;
                    }
                }
                f2 = (Math.abs(rectangle.getHeight()) / ((float) (Math.max(i3, i4) + 1))) - 0.001f;
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        } else {
            f2 = f;
        }
        font2.setSize(f2);
        Phrase phrase = new Phrase(str2, font2);
        ColumnText columnText = new ColumnText((PdfContentByte) null);
        columnText.setSimpleColumn(phrase, rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), f2, 0);
        columnText.setRunDirection(i2);
        if ((columnText.mo52495go(true) & 1) != 0) {
            return f2;
        }
        float f4 = f2;
        for (int i6 = 0; i6 < 50; i6++) {
            f4 = (f3 + f2) / 2.0f;
            ColumnText columnText2 = new ColumnText((PdfContentByte) null);
            font2.setSize(f4);
            columnText2.setSimpleColumn(new Phrase(str2, font2), rectangle.getLeft(), rectangle.getBottom(), rectangle.getRight(), rectangle.getTop(), f4, 0);
            columnText2.setRunDirection(i2);
            if ((columnText2.mo52495go(true) & 1) == 0) {
                f2 = f4;
            } else if (f2 - f3 < f4 * 0.1f) {
                return f4;
            } else {
                f3 = f4;
            }
        }
        return f4;
    }

    public void setExternalDigest(byte[] bArr, byte[] bArr2, String str) {
        this.externalDigest = bArr;
        this.externalRSAdata = bArr2;
        this.digestEncryptionAlgorithm = str;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String str) {
        this.provider = str;
    }

    public PrivateKey getPrivKey() {
        return this.privKey;
    }

    public Certificate[] getCertChain() {
        return this.certChain;
    }

    public CRL[] getCrlList() {
        return this.crlList;
    }

    public PdfName getFilter() {
        return this.filter;
    }

    public boolean isNewField() {
        return this.newField;
    }

    public int getPage() {
        return this.page;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public Rectangle getPageRect() {
        return this.pageRect;
    }

    public Calendar getSignDate() {
        return this.signDate;
    }

    public void setSignDate(Calendar calendar) {
        this.signDate = calendar;
    }

    /* access modifiers changed from: package-private */
    public ByteBuffer getSigout() {
        return this.sigout;
    }

    /* access modifiers changed from: package-private */
    public void setSigout(ByteBuffer byteBuffer) {
        this.sigout = byteBuffer;
    }

    /* access modifiers changed from: package-private */
    public OutputStream getOriginalout() {
        return this.originalout;
    }

    /* access modifiers changed from: package-private */
    public void setOriginalout(OutputStream outputStream) {
        this.originalout = outputStream;
    }

    public File getTempFile() {
        return this.tempFile;
    }

    /* access modifiers changed from: package-private */
    public void setTempFile(File file) {
        this.tempFile = file;
    }

    public String getNewSigName() {
        AcroFields acroFields = this.writer.getAcroFields();
        boolean z = false;
        int i = 0;
        while (!z) {
            i++;
            String str = "Signature" + i;
            if (acroFields.getFieldItem(str) == null) {
                String str2 = String.valueOf(str) + ".";
                Iterator it = acroFields.getFields().keySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((String) it.next()).startsWith(str2)) {
                            z = false;
                            break;
                        }
                    } else {
                        z = true;
                        break;
                    }
                }
            }
        }
        return "Signature" + i;
    }

    public void preClose() throws IOException, DocumentException {
        preClose((HashMap) null);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:88|89|90|91|92|93) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:91:0x0353 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void preClose(java.util.HashMap r10) throws java.io.IOException, com.lowagie.text.DocumentException {
        /*
            r9 = this;
            boolean r0 = r9.preClosed
            if (r0 != 0) goto L_0x03a8
            r0 = 1
            r9.preClosed = r0
            com.lowagie.text.pdf.PdfStamperImp r1 = r9.writer
            com.lowagie.text.pdf.AcroFields r1 = r1.getAcroFields()
            java.lang.String r2 = r9.getFieldName()
            boolean r3 = r9.isInvisible()
            r4 = 0
            if (r3 != 0) goto L_0x0021
            boolean r3 = r9.isNewField()
            if (r3 == 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r3 = 1
            goto L_0x0022
        L_0x0021:
            r3 = 0
        L_0x0022:
            com.lowagie.text.pdf.PdfStamperImp r5 = r9.writer
            com.lowagie.text.pdf.PdfIndirectReference r5 = r5.getPdfIndirectReference()
            com.lowagie.text.pdf.PdfStamperImp r6 = r9.writer
            r7 = 3
            r6.setSigFlags(r7)
            if (r3 == 0) goto L_0x008f
            com.lowagie.text.pdf.AcroFields$Item r1 = r1.getFieldItem(r2)
            com.lowagie.text.pdf.PdfDictionary r1 = r1.getWidget(r4)
            com.lowagie.text.pdf.PdfStamperImp r2 = r9.writer
            r2.markUsed((com.lowagie.text.pdf.PdfObject) r1)
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.f707P
            com.lowagie.text.pdf.PdfStamperImp r3 = r9.writer
            int r6 = r9.getPage()
            com.lowagie.text.pdf.PdfIndirectReference r3 = r3.getPageReference(r6)
            r1.put(r2, r3)
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.f736V
            r1.put(r2, r5)
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.f673F
            com.lowagie.text.pdf.PdfObject r2 = r1.get(r2)
            com.lowagie.text.pdf.PdfObject r2 = com.lowagie.text.pdf.PdfReader.getPdfObjectRelease((com.lowagie.text.pdf.PdfObject) r2)
            if (r2 == 0) goto L_0x006a
            boolean r3 = r2.isNumber()
            if (r3 == 0) goto L_0x006a
            com.lowagie.text.pdf.PdfNumber r2 = (com.lowagie.text.pdf.PdfNumber) r2
            int r2 = r2.intValue()
            goto L_0x006b
        L_0x006a:
            r2 = 0
        L_0x006b:
            r2 = r2 | 128(0x80, float:1.794E-43)
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.f673F
            com.lowagie.text.pdf.PdfNumber r6 = new com.lowagie.text.pdf.PdfNumber
            r6.<init>((int) r2)
            r1.put(r3, r6)
            com.lowagie.text.pdf.PdfDictionary r2 = new com.lowagie.text.pdf.PdfDictionary
            r2.<init>()
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.f696N
            com.lowagie.text.pdf.PdfTemplate r6 = r9.getAppearance()
            com.lowagie.text.pdf.PdfIndirectReference r6 = r6.getIndirectReference()
            r2.put(r3, r6)
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.f644AP
            r1.put(r3, r2)
            goto L_0x00cf
        L_0x008f:
            com.lowagie.text.pdf.PdfStamperImp r1 = r9.writer
            com.lowagie.text.pdf.PdfFormField r1 = com.lowagie.text.pdf.PdfFormField.createSignature(r1)
            r1.setFieldName(r2)
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.f736V
            r1.put(r2, r5)
            r2 = 132(0x84, float:1.85E-43)
            r1.setFlags(r2)
            int r2 = r9.getPage()
            boolean r3 = r9.isInvisible()
            r6 = 0
            if (r3 != 0) goto L_0x00b5
            com.lowagie.text.Rectangle r3 = r9.getPageRect()
            r1.setWidget(r3, r6)
            goto L_0x00be
        L_0x00b5:
            com.lowagie.text.Rectangle r3 = new com.lowagie.text.Rectangle
            r8 = 0
            r3.<init>(r8, r8)
            r1.setWidget(r3, r6)
        L_0x00be:
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfAnnotation.APPEARANCE_NORMAL
            com.lowagie.text.pdf.PdfTemplate r6 = r9.getAppearance()
            r1.setAppearance(r3, r6)
            r1.setPage(r2)
            com.lowagie.text.pdf.PdfStamperImp r3 = r9.writer
            r3.addAnnotation((com.lowagie.text.pdf.PdfAnnotation) r1, (int) r2)
        L_0x00cf:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            r9.exclusionLocations = r1
            com.lowagie.text.pdf.PdfDictionary r1 = r9.cryptoDictionary
            r2 = 80
            if (r1 != 0) goto L_0x01fb
            com.lowagie.text.pdf.PdfName r10 = com.lowagie.text.pdf.PdfName.ADOBE_PPKLITE
            com.lowagie.text.pdf.PdfName r1 = r9.getFilter()
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x00f4
            com.lowagie.text.pdf.PdfSigGenericPKCS$PPKLite r10 = new com.lowagie.text.pdf.PdfSigGenericPKCS$PPKLite
            java.lang.String r1 = r9.getProvider()
            r10.<init>(r1)
            r9.sigStandard = r10
            goto L_0x0123
        L_0x00f4:
            com.lowagie.text.pdf.PdfName r10 = com.lowagie.text.pdf.PdfName.ADOBE_PPKMS
            com.lowagie.text.pdf.PdfName r1 = r9.getFilter()
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x010c
            com.lowagie.text.pdf.PdfSigGenericPKCS$PPKMS r10 = new com.lowagie.text.pdf.PdfSigGenericPKCS$PPKMS
            java.lang.String r1 = r9.getProvider()
            r10.<init>(r1)
            r9.sigStandard = r10
            goto L_0x0123
        L_0x010c:
            com.lowagie.text.pdf.PdfName r10 = com.lowagie.text.pdf.PdfName.VERISIGN_PPKVS
            com.lowagie.text.pdf.PdfName r1 = r9.getFilter()
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L_0x01e3
            com.lowagie.text.pdf.PdfSigGenericPKCS$VeriSign r10 = new com.lowagie.text.pdf.PdfSigGenericPKCS$VeriSign
            java.lang.String r1 = r9.getProvider()
            r10.<init>(r1)
            r9.sigStandard = r10
        L_0x0123:
            com.lowagie.text.pdf.PdfSigGenericPKCS r10 = r9.sigStandard
            byte[] r1 = r9.externalDigest
            byte[] r3 = r9.externalRSAdata
            java.lang.String r6 = r9.digestEncryptionAlgorithm
            r10.setExternalDigest(r1, r3, r6)
            java.lang.String r10 = r9.getReason()
            if (r10 == 0) goto L_0x013d
            com.lowagie.text.pdf.PdfSigGenericPKCS r10 = r9.sigStandard
            java.lang.String r1 = r9.getReason()
            r10.setReason(r1)
        L_0x013d:
            java.lang.String r10 = r9.getLocation()
            if (r10 == 0) goto L_0x014c
            com.lowagie.text.pdf.PdfSigGenericPKCS r10 = r9.sigStandard
            java.lang.String r1 = r9.getLocation()
            r10.setLocation(r1)
        L_0x014c:
            java.lang.String r10 = r9.getContact()
            if (r10 == 0) goto L_0x015b
            com.lowagie.text.pdf.PdfSigGenericPKCS r10 = r9.sigStandard
            java.lang.String r1 = r9.getContact()
            r10.setContact(r1)
        L_0x015b:
            com.lowagie.text.pdf.PdfSigGenericPKCS r10 = r9.sigStandard
            com.lowagie.text.pdf.PdfName r1 = com.lowagie.text.pdf.PdfName.f694M
            com.lowagie.text.pdf.PdfDate r3 = new com.lowagie.text.pdf.PdfDate
            java.util.Calendar r6 = r9.getSignDate()
            r3.<init>(r6)
            r10.put(r1, r3)
            com.lowagie.text.pdf.PdfSigGenericPKCS r10 = r9.sigStandard
            java.security.PrivateKey r1 = r9.getPrivKey()
            java.security.cert.Certificate[] r3 = r9.getCertChain()
            java.security.cert.CRL[] r6 = r9.getCrlList()
            r10.setSignInfo(r1, r3, r6)
            com.lowagie.text.pdf.PdfSigGenericPKCS r10 = r9.sigStandard
            com.lowagie.text.pdf.PdfName r1 = com.lowagie.text.pdf.PdfName.CONTENTS
            com.lowagie.text.pdf.PdfObject r10 = r10.get(r1)
            com.lowagie.text.pdf.PdfString r10 = (com.lowagie.text.pdf.PdfString) r10
            com.lowagie.text.pdf.PdfLiteral r1 = new com.lowagie.text.pdf.PdfLiteral
            java.lang.String r10 = r10.toString()
            int r10 = r10.length()
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.ADOBE_PPKLITE
            com.lowagie.text.pdf.PdfName r6 = r9.getFilter()
            boolean r3 = r3.equals(r6)
            if (r3 == 0) goto L_0x019e
            r3 = 0
            goto L_0x01a0
        L_0x019e:
            r3 = 64
        L_0x01a0:
            int r10 = r10 + r3
            int r10 = r10 * 2
            int r10 = r10 + 2
            r1.<init>((int) r10)
            java.util.HashMap r10 = r9.exclusionLocations
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.CONTENTS
            r10.put(r3, r1)
            com.lowagie.text.pdf.PdfSigGenericPKCS r10 = r9.sigStandard
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.CONTENTS
            r10.put(r3, r1)
            com.lowagie.text.pdf.PdfLiteral r10 = new com.lowagie.text.pdf.PdfLiteral
            r10.<init>((int) r2)
            java.util.HashMap r1 = r9.exclusionLocations
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.BYTERANGE
            r1.put(r2, r10)
            com.lowagie.text.pdf.PdfSigGenericPKCS r1 = r9.sigStandard
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.BYTERANGE
            r1.put(r2, r10)
            int r10 = r9.certificationLevel
            if (r10 <= 0) goto L_0x01d2
            com.lowagie.text.pdf.PdfSigGenericPKCS r10 = r9.sigStandard
            r9.addDocMDP(r10)
        L_0x01d2:
            com.lowagie.text.pdf.PdfSignatureAppearance$SignatureEvent r10 = r9.signatureEvent
            if (r10 == 0) goto L_0x01db
            com.lowagie.text.pdf.PdfSigGenericPKCS r1 = r9.sigStandard
            r10.getSignatureDictionary(r1)
        L_0x01db:
            com.lowagie.text.pdf.PdfStamperImp r10 = r9.writer
            com.lowagie.text.pdf.PdfSigGenericPKCS r1 = r9.sigStandard
            r10.addToBody((com.lowagie.text.pdf.PdfObject) r1, (com.lowagie.text.pdf.PdfIndirectReference) r5, (boolean) r4)
            goto L_0x0235
        L_0x01e3:
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Unknown filter: "
            r0.<init>(r1)
            com.lowagie.text.pdf.PdfName r1 = r9.getFilter()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L_0x01fb:
            com.lowagie.text.pdf.PdfLiteral r1 = new com.lowagie.text.pdf.PdfLiteral
            r1.<init>((int) r2)
            java.util.HashMap r2 = r9.exclusionLocations
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.BYTERANGE
            r2.put(r3, r1)
            com.lowagie.text.pdf.PdfDictionary r2 = r9.cryptoDictionary
            com.lowagie.text.pdf.PdfName r3 = com.lowagie.text.pdf.PdfName.BYTERANGE
            r2.put(r3, r1)
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0216:
            boolean r1 = r10.hasNext()
            if (r1 != 0) goto L_0x0381
            int r10 = r9.certificationLevel
            if (r10 <= 0) goto L_0x0225
            com.lowagie.text.pdf.PdfDictionary r10 = r9.cryptoDictionary
            r9.addDocMDP(r10)
        L_0x0225:
            com.lowagie.text.pdf.PdfSignatureAppearance$SignatureEvent r10 = r9.signatureEvent
            if (r10 == 0) goto L_0x022e
            com.lowagie.text.pdf.PdfDictionary r1 = r9.cryptoDictionary
            r10.getSignatureDictionary(r1)
        L_0x022e:
            com.lowagie.text.pdf.PdfStamperImp r10 = r9.writer
            com.lowagie.text.pdf.PdfDictionary r1 = r9.cryptoDictionary
            r10.addToBody((com.lowagie.text.pdf.PdfObject) r1, (com.lowagie.text.pdf.PdfIndirectReference) r5, (boolean) r4)
        L_0x0235:
            int r10 = r9.certificationLevel
            if (r10 <= 0) goto L_0x025a
            com.lowagie.text.pdf.PdfDictionary r10 = new com.lowagie.text.pdf.PdfDictionary
            r10.<init>()
            com.lowagie.text.pdf.PdfName r1 = new com.lowagie.text.pdf.PdfName
            java.lang.String r2 = "DocMDP"
            r1.<init>((java.lang.String) r2)
            r10.put(r1, r5)
            com.lowagie.text.pdf.PdfStamperImp r1 = r9.writer
            com.lowagie.text.pdf.PdfReader r1 = r1.reader
            com.lowagie.text.pdf.PdfDictionary r1 = r1.getCatalog()
            com.lowagie.text.pdf.PdfName r2 = new com.lowagie.text.pdf.PdfName
            java.lang.String r3 = "Perms"
            r2.<init>((java.lang.String) r3)
            r1.put(r2, r10)
        L_0x025a:
            com.lowagie.text.pdf.PdfStamperImp r10 = r9.writer
            com.lowagie.text.pdf.PdfStamper r1 = r9.stamper
            java.util.HashMap r1 = r1.getMoreInfo()
            r10.close(r1)
            java.util.HashMap r10 = r9.exclusionLocations
            int r10 = r10.size()
            int r10 = r10 * 2
            int[] r10 = new int[r10]
            r9.range = r10
            java.util.HashMap r10 = r9.exclusionLocations
            com.lowagie.text.pdf.PdfName r1 = com.lowagie.text.pdf.PdfName.BYTERANGE
            java.lang.Object r10 = r10.get(r1)
            com.lowagie.text.pdf.PdfLiteral r10 = (com.lowagie.text.pdf.PdfLiteral) r10
            int r1 = r10.getPosition()
            java.util.HashMap r10 = r9.exclusionLocations
            com.lowagie.text.pdf.PdfName r2 = com.lowagie.text.pdf.PdfName.BYTERANGE
            r10.remove(r2)
            java.util.HashMap r10 = r9.exclusionLocations
            java.util.Collection r10 = r10.values()
            java.util.Iterator r2 = r10.iterator()
            r10 = 1
        L_0x0291:
            boolean r3 = r2.hasNext()
            if (r3 != 0) goto L_0x0366
            int[] r10 = r9.range
            int r2 = r10.length
            int r2 = r2 - r0
            java.util.Arrays.sort(r10, r0, r2)
        L_0x029e:
            int[] r10 = r9.range
            int r2 = r10.length
            int r2 = r2 + -2
            if (r7 < r2) goto L_0x0359
            java.io.File r10 = r9.tempFile
            r2 = 93
            r3 = 32
            r5 = 91
            if (r10 != 0) goto L_0x02f8
            com.lowagie.text.pdf.ByteBuffer r10 = r9.sigout
            byte[] r10 = r10.getBuffer()
            r9.bout = r10
            com.lowagie.text.pdf.ByteBuffer r10 = r9.sigout
            int r10 = r10.size()
            r9.boutLen = r10
            int[] r10 = r9.range
            int r6 = r10.length
            int r6 = r6 - r0
            int r0 = r9.boutLen
            int r7 = r10.length
            int r7 = r7 + -2
            r7 = r10[r7]
            int r0 = r0 - r7
            r10[r6] = r0
            com.lowagie.text.pdf.ByteBuffer r6 = new com.lowagie.text.pdf.ByteBuffer
            r6.<init>()
            r6.append((char) r5)
            r10 = 0
        L_0x02d6:
            int[] r0 = r9.range
            int r5 = r0.length
            if (r10 < r5) goto L_0x02ec
            r6.append((char) r2)
            byte[] r10 = r6.getBuffer()
            byte[] r0 = r9.bout
            int r2 = r6.size()
            java.lang.System.arraycopy(r10, r4, r0, r1, r2)
            goto L_0x033e
        L_0x02ec:
            r0 = r0[r10]
            com.lowagie.text.pdf.ByteBuffer r0 = r6.append((int) r0)
            r0.append((char) r3)
            int r10 = r10 + 1
            goto L_0x02d6
        L_0x02f8:
            java.io.RandomAccessFile r6 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x034d }
            java.lang.String r7 = "rw"
            r6.<init>(r10, r7)     // Catch:{ IOException -> 0x034d }
            r9.raf = r6     // Catch:{ IOException -> 0x034d }
            java.io.RandomAccessFile r10 = r9.raf     // Catch:{ IOException -> 0x034d }
            long r6 = r10.length()     // Catch:{ IOException -> 0x034d }
            int r10 = (int) r6     // Catch:{ IOException -> 0x034d }
            int[] r6 = r9.range     // Catch:{ IOException -> 0x034d }
            int[] r7 = r9.range     // Catch:{ IOException -> 0x034d }
            int r7 = r7.length     // Catch:{ IOException -> 0x034d }
            int r7 = r7 - r0
            int[] r0 = r9.range     // Catch:{ IOException -> 0x034d }
            int[] r8 = r9.range     // Catch:{ IOException -> 0x034d }
            int r8 = r8.length     // Catch:{ IOException -> 0x034d }
            int r8 = r8 + -2
            r0 = r0[r8]     // Catch:{ IOException -> 0x034d }
            int r10 = r10 - r0
            r6[r7] = r10     // Catch:{ IOException -> 0x034d }
            com.lowagie.text.pdf.ByteBuffer r10 = new com.lowagie.text.pdf.ByteBuffer     // Catch:{ IOException -> 0x034d }
            r10.<init>()     // Catch:{ IOException -> 0x034d }
            r10.append((char) r5)     // Catch:{ IOException -> 0x034d }
            r0 = 0
        L_0x0323:
            int[] r5 = r9.range     // Catch:{ IOException -> 0x034d }
            int r5 = r5.length     // Catch:{ IOException -> 0x034d }
            if (r0 < r5) goto L_0x033f
            r10.append((char) r2)     // Catch:{ IOException -> 0x034d }
            java.io.RandomAccessFile r0 = r9.raf     // Catch:{ IOException -> 0x034d }
            long r1 = (long) r1     // Catch:{ IOException -> 0x034d }
            r0.seek(r1)     // Catch:{ IOException -> 0x034d }
            java.io.RandomAccessFile r0 = r9.raf     // Catch:{ IOException -> 0x034d }
            byte[] r1 = r10.getBuffer()     // Catch:{ IOException -> 0x034d }
            int r10 = r10.size()     // Catch:{ IOException -> 0x034d }
            r0.write(r1, r4, r10)     // Catch:{ IOException -> 0x034d }
        L_0x033e:
            return
        L_0x033f:
            int[] r5 = r9.range     // Catch:{ IOException -> 0x034d }
            r5 = r5[r0]     // Catch:{ IOException -> 0x034d }
            com.lowagie.text.pdf.ByteBuffer r5 = r10.append((int) r5)     // Catch:{ IOException -> 0x034d }
            r5.append((char) r3)     // Catch:{ IOException -> 0x034d }
            int r0 = r0 + 1
            goto L_0x0323
        L_0x034d:
            r10 = move-exception
            java.io.RandomAccessFile r0 = r9.raf     // Catch:{ Exception -> 0x0353 }
            r0.close()     // Catch:{ Exception -> 0x0353 }
        L_0x0353:
            java.io.File r0 = r9.tempFile     // Catch:{ Exception -> 0x0358 }
            r0.delete()     // Catch:{ Exception -> 0x0358 }
        L_0x0358:
            throw r10
        L_0x0359:
            r2 = r10[r7]
            int r3 = r7 + -1
            r3 = r10[r3]
            int r2 = r2 - r3
            r10[r7] = r2
            int r7 = r7 + 2
            goto L_0x029e
        L_0x0366:
            java.lang.Object r3 = r2.next()
            com.lowagie.text.pdf.PdfLiteral r3 = (com.lowagie.text.pdf.PdfLiteral) r3
            int r5 = r3.getPosition()
            int[] r6 = r9.range
            int r8 = r10 + 1
            r6[r10] = r5
            int r10 = r8 + 1
            int r3 = r3.getPosLength()
            int r3 = r3 + r5
            r6[r8] = r3
            goto L_0x0291
        L_0x0381:
            java.lang.Object r1 = r10.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            com.lowagie.text.pdf.PdfName r2 = (com.lowagie.text.pdf.PdfName) r2
            java.lang.Object r1 = r1.getValue()
            java.lang.Integer r1 = (java.lang.Integer) r1
            com.lowagie.text.pdf.PdfLiteral r3 = new com.lowagie.text.pdf.PdfLiteral
            int r1 = r1.intValue()
            r3.<init>((int) r1)
            java.util.HashMap r1 = r9.exclusionLocations
            r1.put(r2, r3)
            com.lowagie.text.pdf.PdfDictionary r1 = r9.cryptoDictionary
            r1.put(r2, r3)
            goto L_0x0216
        L_0x03a8:
            com.lowagie.text.DocumentException r10 = new com.lowagie.text.DocumentException
            java.lang.String r0 = "Document already pre closed."
            r10.<init>((java.lang.String) r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfSignatureAppearance.preClose(java.util.HashMap):void");
    }

    public void close(PdfDictionary pdfDictionary) throws IOException, DocumentException {
        try {
            if (this.preClosed) {
                ByteBuffer byteBuffer = new ByteBuffer();
                for (PdfName pdfName : pdfDictionary.getKeys()) {
                    PdfObject pdfObject = pdfDictionary.get(pdfName);
                    PdfLiteral pdfLiteral = (PdfLiteral) this.exclusionLocations.get(pdfName);
                    if (pdfLiteral != null) {
                        byteBuffer.reset();
                        pdfObject.toPdf((PdfWriter) null, byteBuffer);
                        if (byteBuffer.size() > pdfLiteral.getPosLength()) {
                            throw new IllegalArgumentException("The key " + pdfName.toString() + " is too big. Is " + byteBuffer.size() + ", reserved " + pdfLiteral.getPosLength());
                        } else if (this.tempFile == null) {
                            System.arraycopy(byteBuffer.getBuffer(), 0, this.bout, pdfLiteral.getPosition(), byteBuffer.size());
                        } else {
                            this.raf.seek((long) pdfLiteral.getPosition());
                            this.raf.write(byteBuffer.getBuffer(), 0, byteBuffer.size());
                        }
                    } else {
                        throw new IllegalArgumentException("The key " + pdfName.toString() + " didn't reserve space in preClose().");
                    }
                }
                if (pdfDictionary.size() == this.exclusionLocations.size()) {
                    if (this.tempFile == null) {
                        this.originalout.write(this.bout, 0, this.boutLen);
                    } else if (this.originalout != null) {
                        this.raf.seek(0);
                        int length = (int) this.raf.length();
                        byte[] bArr = new byte[8192];
                        while (length > 0) {
                            int read = this.raf.read(bArr, 0, Math.min(bArr.length, length));
                            if (read >= 0) {
                                this.originalout.write(bArr, 0, read);
                                length -= read;
                            } else {
                                throw new EOFException("Unexpected EOF");
                            }
                        }
                    }
                } else {
                    throw new IllegalArgumentException("The update dictionary has less keys than required.");
                }
            } else {
                throw new DocumentException("preClose() must be called first.");
            }
        } finally {
            if (this.tempFile != null) {
                try {
                    this.raf.close();
                } catch (Exception unused) {
                }
                if (this.originalout != null) {
                    try {
                        this.tempFile.delete();
                    } catch (Exception unused2) {
                    }
                }
            }
            OutputStream outputStream = this.originalout;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused3) {
                }
            }
        }
    }

    private void addDocMDP(PdfDictionary pdfDictionary) {
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        PdfDictionary pdfDictionary3 = new PdfDictionary();
        pdfDictionary3.put(PdfName.f707P, new PdfNumber(this.certificationLevel));
        pdfDictionary3.put(PdfName.f736V, new PdfName("1.2"));
        pdfDictionary3.put(PdfName.TYPE, PdfName.TRANSFORMPARAMS);
        pdfDictionary2.put(PdfName.TRANSFORMMETHOD, PdfName.DOCMDP);
        pdfDictionary2.put(PdfName.TYPE, PdfName.SIGREF);
        pdfDictionary2.put(PdfName.TRANSFORMPARAMS, pdfDictionary3);
        pdfDictionary2.put(new PdfName("DigestValue"), new PdfString("aa"));
        PdfArray pdfArray = new PdfArray();
        pdfArray.add((PdfObject) new PdfNumber(0));
        pdfArray.add((PdfObject) new PdfNumber(0));
        pdfDictionary2.put(new PdfName("DigestLocation"), pdfArray);
        pdfDictionary2.put(new PdfName("DigestMethod"), new PdfName("MD5"));
        pdfDictionary2.put(PdfName.DATA, this.writer.reader.getTrailer().get(PdfName.ROOT));
        PdfArray pdfArray2 = new PdfArray();
        pdfArray2.add((PdfObject) pdfDictionary2);
        pdfDictionary.put(PdfName.REFERENCE, pdfArray2);
    }

    public InputStream getRangeStream() {
        return new RangeStream(this.raf, this.bout, this.range, (RangeStream) null);
    }

    public PdfDictionary getCryptoDictionary() {
        return this.cryptoDictionary;
    }

    public void setCryptoDictionary(PdfDictionary pdfDictionary) {
        this.cryptoDictionary = pdfDictionary;
    }

    public PdfStamper getStamper() {
        return this.stamper;
    }

    /* access modifiers changed from: package-private */
    public void setStamper(PdfStamper pdfStamper) {
        this.stamper = pdfStamper;
    }

    public boolean isPreClosed() {
        return this.preClosed;
    }

    public PdfSigGenericPKCS getSigStandard() {
        return this.sigStandard;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String str) {
        this.contact = str;
    }

    public Font getLayer2Font() {
        return this.layer2Font;
    }

    public void setLayer2Font(Font font) {
        this.layer2Font = font;
    }

    public boolean isAcro6Layers() {
        return this.acro6Layers;
    }

    public void setAcro6Layers(boolean z) {
        this.acro6Layers = z;
    }

    public void setRunDirection(int i) {
        if (i < 0 || i > 3) {
            throw new RuntimeException("Invalid run direction: " + i);
        }
        this.runDirection = i;
    }

    public int getRunDirection() {
        return this.runDirection;
    }

    public SignatureEvent getSignatureEvent() {
        return this.signatureEvent;
    }

    public void setSignatureEvent(SignatureEvent signatureEvent2) {
        this.signatureEvent = signatureEvent2;
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image2) {
        this.image = image2;
    }

    public float getImageScale() {
        return this.imageScale;
    }

    public void setImageScale(float f) {
        this.imageScale = f;
    }

    private static class RangeStream extends InputStream {

        /* renamed from: b */
        private byte[] f758b;
        private byte[] bout;
        private RandomAccessFile raf;
        private int[] range;
        private int rangePosition;

        private RangeStream(RandomAccessFile randomAccessFile, byte[] bArr, int[] iArr) {
            this.f758b = new byte[1];
            this.rangePosition = 0;
            this.raf = randomAccessFile;
            this.bout = bArr;
            this.range = iArr;
        }

        /* synthetic */ RangeStream(RandomAccessFile randomAccessFile, byte[] bArr, int[] iArr, RangeStream rangeStream) {
            this(randomAccessFile, bArr, iArr);
        }

        public int read() throws IOException {
            if (read(this.f758b) != 1) {
                return -1;
            }
            return this.f758b[0] & 255;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3;
            if (bArr == null) {
                throw new NullPointerException();
            } else if (i < 0 || i > bArr.length || i2 < 0 || (i3 = i + i2) > bArr.length || i3 < 0) {
                throw new IndexOutOfBoundsException();
            } else {
                int i4 = 0;
                if (i2 == 0) {
                    return 0;
                }
                int i5 = this.rangePosition;
                int[] iArr = this.range;
                if (i5 >= iArr[iArr.length - 2] + iArr[iArr.length - 1]) {
                    return -1;
                }
                while (true) {
                    int[] iArr2 = this.range;
                    if (i4 >= iArr2.length) {
                        return -1;
                    }
                    int i6 = iArr2[i4];
                    int i7 = iArr2[i4 + 1] + i6;
                    if (this.rangePosition < i6) {
                        this.rangePosition = i6;
                    }
                    int i8 = this.rangePosition;
                    if (i8 < i6 || i8 >= i7) {
                        i4 += 2;
                    } else {
                        int min = Math.min(i2, i7 - i8);
                        RandomAccessFile randomAccessFile = this.raf;
                        if (randomAccessFile == null) {
                            System.arraycopy(this.bout, this.rangePosition, bArr, i, min);
                        } else {
                            randomAccessFile.seek((long) this.rangePosition);
                            this.raf.readFully(bArr, i, min);
                        }
                        this.rangePosition += min;
                        return min;
                    }
                }
            }
        }
    }

    public int getCertificationLevel() {
        return this.certificationLevel;
    }

    public void setCertificationLevel(int i) {
        this.certificationLevel = i;
    }
}
