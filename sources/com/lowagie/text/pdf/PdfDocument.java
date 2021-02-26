package com.lowagie.text.pdf;

import com.lowagie.text.Anchor;
import com.lowagie.text.Annotation;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.MarkedObject;
import com.lowagie.text.MarkedSection;
import com.lowagie.text.Meta;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Section;
import com.lowagie.text.SimpleTable;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.collection.PdfCollection;
import com.lowagie.text.pdf.draw.DrawInterface;
import com.lowagie.text.pdf.internal.PdfAnnotationsImp;
import com.lowagie.text.pdf.internal.PdfViewerPreferencesImp;
import harmony.java.awt.Color;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class PdfDocument extends Document {
    protected static final DecimalFormat SIXTEEN_DIGITS = new DecimalFormat("0000000000000000");
    static final String hangingPunctuation = ".,;:'";
    protected PdfDictionary additionalActions;
    protected int alignment = 0;
    protected PdfAction anchorAction = null;
    PdfAnnotationsImp annotationsImp;
    protected HashMap boxSize = new HashMap();
    protected PdfCollection collection;
    protected float currentHeight = 0.0f;
    protected PdfOutline currentOutline;
    protected HashMap documentFileAttachment = new HashMap();
    protected HashMap documentLevelJS = new HashMap();
    protected int duration = -1;
    protected boolean firstPageEvent = true;
    protected PdfContentByte graphics;
    protected float imageEnd = -1.0f;
    protected Image imageWait = null;
    protected Indentation indentation = new Indentation();
    protected PdfInfo info = new PdfInfo();
    protected boolean isSectionTitle = false;
    int jsCounter;
    protected int lastElementType = -1;
    protected float leading = 0.0f;
    protected int leadingCount = 0;
    protected PdfLine line = null;
    protected ArrayList lines = new ArrayList();
    protected TreeMap localDestinations = new TreeMap();
    protected int markPoint;
    protected float nextMarginBottom;
    protected float nextMarginLeft;
    protected float nextMarginRight;
    protected float nextMarginTop;
    protected Rectangle nextPageSize = null;
    protected PdfAction openActionAction;
    protected String openActionName;
    protected PdfDictionary pageAA = null;
    protected boolean pageEmpty = true;
    protected PdfPageLabels pageLabels;
    protected PageResources pageResources;
    protected PdfOutline rootOutline;
    protected boolean strictImageSequence = false;
    protected PdfContentByte text;
    protected int textEmptySize;
    protected HashMap thisBoxSize = new HashMap();
    protected PdfIndirectReference thumb;
    protected PdfTransition transition = null;
    protected PdfViewerPreferencesImp viewerPreferences = new PdfViewerPreferencesImp();
    protected PdfWriter writer;
    protected byte[] xmpMetadata = null;

    public static class Indentation {
        float imageIndentLeft = 0.0f;
        float imageIndentRight = 0.0f;
        float indentBottom = 0.0f;
        float indentLeft = 0.0f;
        float indentRight = 0.0f;
        float indentTop = 0.0f;
        float listIndentLeft = 0.0f;
        float sectionIndentLeft = 0.0f;
        float sectionIndentRight = 0.0f;
    }

    public static class PdfInfo extends PdfDictionary {
        PdfInfo() {
            addProducer();
            addCreationDate();
        }

        PdfInfo(String str, String str2, String str3) {
            this();
            addTitle(str2);
            addSubject(str3);
            addAuthor(str);
        }

        /* access modifiers changed from: package-private */
        public void addTitle(String str) {
            put(PdfName.TITLE, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        /* access modifiers changed from: package-private */
        public void addSubject(String str) {
            put(PdfName.SUBJECT, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        /* access modifiers changed from: package-private */
        public void addKeywords(String str) {
            put(PdfName.KEYWORDS, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        /* access modifiers changed from: package-private */
        public void addAuthor(String str) {
            put(PdfName.AUTHOR, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        /* access modifiers changed from: package-private */
        public void addCreator(String str) {
            put(PdfName.CREATOR, new PdfString(str, PdfObject.TEXT_UNICODE));
        }

        /* access modifiers changed from: package-private */
        public void addProducer() {
            put(PdfName.PRODUCER, new PdfString(PdfDocument.getVersion()));
        }

        /* access modifiers changed from: package-private */
        public void addCreationDate() {
            PdfDate pdfDate = new PdfDate();
            put(PdfName.CREATIONDATE, pdfDate);
            put(PdfName.MODDATE, pdfDate);
        }

        /* access modifiers changed from: package-private */
        public void addkey(String str, String str2) {
            if (!str.equals("Producer") && !str.equals("CreationDate")) {
                put(new PdfName(str), new PdfString(str2, PdfObject.TEXT_UNICODE));
            }
        }
    }

    static class PdfCatalog extends PdfDictionary {
        PdfWriter writer;

        PdfCatalog(PdfIndirectReference pdfIndirectReference, PdfWriter pdfWriter) {
            super(CATALOG);
            this.writer = pdfWriter;
            put(PdfName.PAGES, pdfIndirectReference);
        }

        /* access modifiers changed from: package-private */
        public void addNames(TreeMap treeMap, HashMap hashMap, HashMap hashMap2, PdfWriter pdfWriter) {
            if (!treeMap.isEmpty() || !hashMap.isEmpty() || !hashMap2.isEmpty()) {
                try {
                    PdfDictionary pdfDictionary = new PdfDictionary();
                    if (!treeMap.isEmpty()) {
                        PdfArray pdfArray = new PdfArray();
                        for (Map.Entry entry : treeMap.entrySet()) {
                            String str = (String) entry.getKey();
                            Object[] objArr = (Object[]) entry.getValue();
                            if (objArr[2] != null) {
                                pdfArray.add((PdfObject) new PdfString(str, (String) null));
                                pdfArray.add((PdfObject) (PdfIndirectReference) objArr[1]);
                            }
                        }
                        if (pdfArray.size() > 0) {
                            PdfDictionary pdfDictionary2 = new PdfDictionary();
                            pdfDictionary2.put(PdfName.NAMES, pdfArray);
                            pdfDictionary.put(PdfName.DESTS, pdfWriter.addToBody(pdfDictionary2).getIndirectReference());
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        pdfDictionary.put(PdfName.JAVASCRIPT, pdfWriter.addToBody(PdfNameTree.writeTree(hashMap, pdfWriter)).getIndirectReference());
                    }
                    if (!hashMap2.isEmpty()) {
                        pdfDictionary.put(PdfName.EMBEDDEDFILES, pdfWriter.addToBody(PdfNameTree.writeTree(hashMap2, pdfWriter)).getIndirectReference());
                    }
                    if (pdfDictionary.size() > 0) {
                        put(PdfName.NAMES, pdfWriter.addToBody(pdfDictionary).getIndirectReference());
                    }
                } catch (IOException e) {
                    throw new ExceptionConverter(e);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void setOpenAction(PdfAction pdfAction) {
            put(PdfName.OPENACTION, pdfAction);
        }

        /* access modifiers changed from: package-private */
        public void setAdditionalActions(PdfDictionary pdfDictionary) {
            try {
                put(PdfName.f642AA, this.writer.addToBody(pdfDictionary).getIndirectReference());
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    public PdfDocument() {
        addProducer();
        addCreationDate();
    }

    public void addWriter(PdfWriter pdfWriter) throws DocumentException {
        if (this.writer == null) {
            this.writer = pdfWriter;
            this.annotationsImp = new PdfAnnotationsImp(pdfWriter);
            return;
        }
        throw new DocumentException("You can only add a writer to a PdfDocument once.");
    }

    public float getLeading() {
        return this.leading;
    }

    /* access modifiers changed from: package-private */
    public void setLeading(float f) {
        this.leading = f;
    }

    public boolean add(Element element) throws DocumentException {
        MarkedObject title;
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter != null && pdfWriter.isPaused()) {
            return false;
        }
        try {
            int type = element.type();
            if (type != 22) {
                if (type != 23) {
                    float f = 0.0f;
                    if (type == 29) {
                        if (this.line == null) {
                            carriageReturn();
                        }
                        Annotation annotation = (Annotation) element;
                        Rectangle rectangle = new Rectangle(0.0f, 0.0f);
                        if (this.line != null) {
                            rectangle = new Rectangle(annotation.llx(indentRight() - this.line.widthLeft()), annotation.lly(indentTop() - this.currentHeight), annotation.urx((indentRight() - this.line.widthLeft()) + 20.0f), annotation.ury((indentTop() - this.currentHeight) - 20.0f));
                        }
                        this.annotationsImp.addPlainAnnotation(PdfAnnotationsImp.convertAnnotation(this.writer, annotation, rectangle));
                        this.pageEmpty = false;
                    } else if (type == 30) {
                        this.graphics.rectangle((Rectangle) element);
                        this.pageEmpty = false;
                    } else if (type == 40) {
                        ensureNewLine();
                        flushLines();
                        float write = ((MultiColumnText) element).write(this.writer.getDirectContent(), this, indentTop() - this.currentHeight);
                        this.currentHeight += write;
                        this.text.moveText(0.0f, write * -1.0f);
                        this.pageEmpty = false;
                    } else if (type == 50) {
                        if ((element instanceof MarkedSection) && (title = ((MarkedSection) element).getTitle()) != null) {
                            title.process(this);
                        }
                        ((MarkedObject) element).process(this);
                    } else if (type != 55) {
                        switch (type) {
                            case 0:
                                this.info.addkey(((Meta) element).getName(), ((Meta) element).getContent());
                                break;
                            case 1:
                                this.info.addTitle(((Meta) element).getContent());
                                break;
                            case 2:
                                this.info.addSubject(((Meta) element).getContent());
                                break;
                            case 3:
                                this.info.addKeywords(((Meta) element).getContent());
                                break;
                            case 4:
                                this.info.addAuthor(((Meta) element).getContent());
                                break;
                            case 5:
                                this.info.addProducer();
                                break;
                            case 6:
                                this.info.addCreationDate();
                                break;
                            case 7:
                                this.info.addCreator(((Meta) element).getContent());
                                break;
                            default:
                                switch (type) {
                                    case 10:
                                        if (this.line == null) {
                                            carriageReturn();
                                        }
                                        PdfChunk pdfChunk = new PdfChunk((Chunk) element, this.anchorAction);
                                        while (true) {
                                            PdfChunk add = this.line.add(pdfChunk);
                                            if (add == null) {
                                                this.pageEmpty = false;
                                                if (pdfChunk.isAttribute(Chunk.NEWPAGE)) {
                                                    newPage();
                                                    break;
                                                }
                                            } else {
                                                carriageReturn();
                                                add.trimFirstSpace();
                                                pdfChunk = add;
                                            }
                                        }
                                        break;
                                    case 11:
                                        this.leadingCount++;
                                        this.leading = ((Phrase) element).getLeading();
                                        element.process(this);
                                        this.leadingCount--;
                                        break;
                                    case 12:
                                        this.leadingCount++;
                                        Paragraph paragraph = (Paragraph) element;
                                        addSpacing(paragraph.getSpacingBefore(), this.leading, paragraph.getFont());
                                        this.alignment = paragraph.getAlignment();
                                        this.leading = paragraph.getTotalLeading();
                                        carriageReturn();
                                        if (this.currentHeight + this.line.height() + this.leading > indentTop() - indentBottom()) {
                                            newPage();
                                        }
                                        this.indentation.indentLeft += paragraph.getIndentationLeft();
                                        this.indentation.indentRight += paragraph.getIndentationRight();
                                        carriageReturn();
                                        PdfPageEvent pageEvent = this.writer.getPageEvent();
                                        if (pageEvent != null && !this.isSectionTitle) {
                                            pageEvent.onParagraph(this.writer, this, indentTop() - this.currentHeight);
                                        }
                                        if (paragraph.getKeepTogether()) {
                                            carriageReturn();
                                            PdfPTable pdfPTable = new PdfPTable(1);
                                            pdfPTable.setWidthPercentage(100.0f);
                                            PdfPCell pdfPCell = new PdfPCell();
                                            pdfPCell.addElement(paragraph);
                                            pdfPCell.setBorder(0);
                                            pdfPCell.setPadding(0.0f);
                                            pdfPTable.addCell(pdfPCell);
                                            this.indentation.indentLeft -= paragraph.getIndentationLeft();
                                            this.indentation.indentRight -= paragraph.getIndentationRight();
                                            add((Element) pdfPTable);
                                            this.indentation.indentLeft += paragraph.getIndentationLeft();
                                            this.indentation.indentRight += paragraph.getIndentationRight();
                                        } else {
                                            this.line.setExtraIndent(paragraph.getFirstLineIndent());
                                            element.process(this);
                                            carriageReturn();
                                            addSpacing(paragraph.getSpacingAfter(), paragraph.getTotalLeading(), paragraph.getFont());
                                        }
                                        if (pageEvent != null && !this.isSectionTitle) {
                                            pageEvent.onParagraphEnd(this.writer, this, indentTop() - this.currentHeight);
                                        }
                                        this.alignment = 0;
                                        this.indentation.indentLeft -= paragraph.getIndentationLeft();
                                        this.indentation.indentRight -= paragraph.getIndentationRight();
                                        carriageReturn();
                                        this.leadingCount--;
                                        break;
                                    case 13:
                                    case 16:
                                        Section section = (Section) element;
                                        PdfPageEvent pageEvent2 = this.writer.getPageEvent();
                                        boolean z = section.isNotAddedYet() && section.getTitle() != null;
                                        if (section.isTriggerNewPage()) {
                                            newPage();
                                        }
                                        if (z) {
                                            float indentTop = indentTop() - this.currentHeight;
                                            int rotation = this.pageSize.getRotation();
                                            if (rotation == 90 || rotation == 180) {
                                                indentTop = this.pageSize.getHeight() - indentTop;
                                            }
                                            PdfDestination pdfDestination = new PdfDestination(2, indentTop);
                                            while (this.currentOutline.level() >= section.getDepth()) {
                                                this.currentOutline = this.currentOutline.parent();
                                            }
                                            this.currentOutline = new PdfOutline(this.currentOutline, pdfDestination, section.getBookmarkTitle(), section.isBookmarkOpen());
                                        }
                                        carriageReturn();
                                        this.indentation.sectionIndentLeft += section.getIndentationLeft();
                                        this.indentation.sectionIndentRight += section.getIndentationRight();
                                        if (section.isNotAddedYet() && pageEvent2 != null) {
                                            if (element.type() == 16) {
                                                pageEvent2.onChapter(this.writer, this, indentTop() - this.currentHeight, section.getTitle());
                                            } else {
                                                pageEvent2.onSection(this.writer, this, indentTop() - this.currentHeight, section.getDepth(), section.getTitle());
                                            }
                                        }
                                        if (z) {
                                            this.isSectionTitle = true;
                                            add((Element) section.getTitle());
                                            this.isSectionTitle = false;
                                        }
                                        this.indentation.sectionIndentLeft += section.getIndentation();
                                        element.process(this);
                                        flushLines();
                                        this.indentation.sectionIndentLeft -= section.getIndentationLeft() + section.getIndentation();
                                        this.indentation.sectionIndentRight -= section.getIndentationRight();
                                        if (section.isComplete() && pageEvent2 != null) {
                                            if (element.type() != 16) {
                                                pageEvent2.onSectionEnd(this.writer, this, indentTop() - this.currentHeight);
                                                break;
                                            } else {
                                                pageEvent2.onChapterEnd(this.writer, this, indentTop() - this.currentHeight);
                                                break;
                                            }
                                        }
                                        break;
                                    case 14:
                                        List list = (List) element;
                                        if (list.isAlignindent()) {
                                            list.normalizeIndentation();
                                        }
                                        this.indentation.listIndentLeft += list.getIndentationLeft();
                                        this.indentation.indentRight += list.getIndentationRight();
                                        element.process(this);
                                        this.indentation.listIndentLeft -= list.getIndentationLeft();
                                        this.indentation.indentRight -= list.getIndentationRight();
                                        carriageReturn();
                                        break;
                                    case 15:
                                        this.leadingCount++;
                                        ListItem listItem = (ListItem) element;
                                        addSpacing(listItem.getSpacingBefore(), this.leading, listItem.getFont());
                                        this.alignment = listItem.getAlignment();
                                        this.indentation.listIndentLeft += listItem.getIndentationLeft();
                                        this.indentation.indentRight += listItem.getIndentationRight();
                                        this.leading = listItem.getTotalLeading();
                                        carriageReturn();
                                        this.line.setListItem(listItem);
                                        element.process(this);
                                        addSpacing(listItem.getSpacingAfter(), listItem.getTotalLeading(), listItem.getFont());
                                        if (this.line.hasToBeJustified()) {
                                            this.line.resetAlignment();
                                        }
                                        carriageReturn();
                                        this.indentation.listIndentLeft -= listItem.getIndentationLeft();
                                        this.indentation.indentRight -= listItem.getIndentationRight();
                                        this.leadingCount--;
                                        break;
                                    case 17:
                                        this.leadingCount++;
                                        Anchor anchor = (Anchor) element;
                                        String reference = anchor.getReference();
                                        this.leading = anchor.getLeading();
                                        if (reference != null) {
                                            this.anchorAction = new PdfAction(reference);
                                        }
                                        element.process(this);
                                        this.anchorAction = null;
                                        this.leadingCount--;
                                        break;
                                    default:
                                        switch (type) {
                                            case 32:
                                            case 33:
                                            case 34:
                                            case 35:
                                            case 36:
                                                add((Image) element);
                                                break;
                                            default:
                                                return false;
                                        }
                                }
                        }
                    } else {
                        DrawInterface drawInterface = (DrawInterface) element;
                        PdfContentByte pdfContentByte = this.graphics;
                        float indentLeft = indentLeft();
                        float indentBottom = indentBottom();
                        float indentRight = indentRight();
                        float indentTop2 = indentTop();
                        float indentTop3 = indentTop() - this.currentHeight;
                        if (this.leadingCount > 0) {
                            f = this.leading;
                        }
                        drawInterface.draw(pdfContentByte, indentLeft, indentBottom, indentRight, indentTop2, indentTop3 - f);
                        this.pageEmpty = false;
                    }
                } else {
                    PdfPTable pdfPTable2 = (PdfPTable) element;
                    if (pdfPTable2.size() > pdfPTable2.getHeaderRows()) {
                        ensureNewLine();
                        flushLines();
                        addPTable(pdfPTable2);
                        this.pageEmpty = false;
                        newLine();
                    }
                }
            } else if (element instanceof SimpleTable) {
                PdfPTable createPdfPTable = ((SimpleTable) element).createPdfPTable();
                if (createPdfPTable.size() > createPdfPTable.getHeaderRows()) {
                    ensureNewLine();
                    flushLines();
                    addPTable(createPdfPTable);
                    this.pageEmpty = false;
                }
            } else if (!(element instanceof Table)) {
                return false;
            } else {
                try {
                    PdfPTable createPdfPTable2 = ((Table) element).createPdfPTable();
                    if (createPdfPTable2.size() > createPdfPTable2.getHeaderRows()) {
                        ensureNewLine();
                        flushLines();
                        addPTable(createPdfPTable2);
                        this.pageEmpty = false;
                    }
                } catch (BadElementException unused) {
                    float offset = ((Table) element).getOffset();
                    if (Float.isNaN(offset)) {
                        offset = this.leading;
                    }
                    carriageReturn();
                    this.lines.add(new PdfLine(indentLeft(), indentRight(), this.alignment, offset));
                    this.currentHeight += offset;
                    addPdfTable((Table) element);
                }
            }
            this.lastElementType = element.type();
            return true;
        } catch (Exception e) {
            throw new DocumentException(e);
        }
    }

    public void open() {
        if (!this.open) {
            super.open();
            this.writer.open();
            this.rootOutline = new PdfOutline(this.writer);
            this.currentOutline = this.rootOutline;
        }
        try {
            initPage();
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    public void close() {
        if (!this.close) {
            try {
                boolean z = this.imageWait != null;
                newPage();
                if (this.imageWait != null || z) {
                    newPage();
                }
                if (!this.annotationsImp.hasUnusedAnnotations()) {
                    PdfPageEvent pageEvent = this.writer.getPageEvent();
                    if (pageEvent != null) {
                        pageEvent.onCloseDocument(this.writer, this);
                    }
                    super.close();
                    this.writer.addLocalDestinations(this.localDestinations);
                    calculateOutlineCount();
                    writeOutlines();
                    this.writer.close();
                    return;
                }
                throw new RuntimeException("Not all annotations could be added to the document (the document doesn't have enough pages).");
            } catch (Exception e) {
                throw ExceptionConverter.convertException(e);
            }
        }
    }

    public void setXmpMetadata(byte[] bArr) {
        this.xmpMetadata = bArr;
    }

    public boolean newPage() {
        this.lastElementType = -1;
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || (pdfWriter.getDirectContent().size() == 0 && this.writer.getDirectContentUnder().size() == 0 && (this.pageEmpty || this.writer.isPaused()))) {
            setNewPageSizeAndMargins();
            return false;
        } else if (!this.open || this.close) {
            throw new RuntimeException("The document isn't open.");
        } else {
            PdfPageEvent pageEvent = this.writer.getPageEvent();
            if (pageEvent != null) {
                pageEvent.onEndPage(this.writer, this);
            }
            super.newPage();
            Indentation indentation2 = this.indentation;
            indentation2.imageIndentLeft = 0.0f;
            indentation2.imageIndentRight = 0.0f;
            try {
                flushLines();
                int rotation = this.pageSize.getRotation();
                if (this.writer.isPdfX()) {
                    if (this.thisBoxSize.containsKey("art")) {
                        if (this.thisBoxSize.containsKey("trim")) {
                            throw new PdfXConformanceException("Only one of ArtBox or TrimBox can exist in the page.");
                        }
                    }
                    if (!this.thisBoxSize.containsKey("art") && !this.thisBoxSize.containsKey("trim")) {
                        if (this.thisBoxSize.containsKey("crop")) {
                            this.thisBoxSize.put("trim", this.thisBoxSize.get("crop"));
                        } else {
                            this.thisBoxSize.put("trim", new PdfRectangle(this.pageSize, this.pageSize.getRotation()));
                        }
                    }
                }
                this.pageResources.addDefaultColorDiff(this.writer.getDefaultColorspace());
                if (this.writer.isRgbTransparencyBlending()) {
                    PdfDictionary pdfDictionary = new PdfDictionary();
                    pdfDictionary.put(PdfName.f660CS, PdfName.DEVICERGB);
                    this.pageResources.addDefaultColorDiff(pdfDictionary);
                }
                PdfPage pdfPage = new PdfPage(new PdfRectangle(this.pageSize, rotation), this.thisBoxSize, this.pageResources.getResources(), rotation);
                pdfPage.put(PdfName.TABS, this.writer.getTabs());
                if (this.xmpMetadata != null) {
                    PdfStream pdfStream = new PdfStream(this.xmpMetadata);
                    pdfStream.put(PdfName.TYPE, PdfName.METADATA);
                    pdfStream.put(PdfName.SUBTYPE, PdfName.XML);
                    PdfEncryption encryption = this.writer.getEncryption();
                    if (encryption != null && !encryption.isMetadataEncrypted()) {
                        PdfArray pdfArray = new PdfArray();
                        pdfArray.add((PdfObject) PdfName.CRYPT);
                        pdfStream.put(PdfName.FILTER, pdfArray);
                    }
                    pdfPage.put(PdfName.METADATA, this.writer.addToBody(pdfStream).getIndirectReference());
                }
                if (this.transition != null) {
                    pdfPage.put(PdfName.TRANS, this.transition.getTransitionDictionary());
                    this.transition = null;
                }
                if (this.duration > 0) {
                    pdfPage.put(PdfName.DUR, new PdfNumber(this.duration));
                    this.duration = 0;
                }
                if (this.pageAA != null) {
                    pdfPage.put(PdfName.f642AA, this.writer.addToBody(this.pageAA).getIndirectReference());
                    this.pageAA = null;
                }
                if (this.thumb != null) {
                    pdfPage.put(PdfName.THUMB, this.thumb);
                    this.thumb = null;
                }
                if (this.writer.getUserunit() > 0.0f) {
                    pdfPage.put(PdfName.USERUNIT, new PdfNumber(this.writer.getUserunit()));
                }
                if (this.annotationsImp.hasUnusedAnnotations()) {
                    PdfArray rotateAnnotations = this.annotationsImp.rotateAnnotations(this.writer, this.pageSize);
                    if (rotateAnnotations.size() != 0) {
                        pdfPage.put(PdfName.ANNOTS, rotateAnnotations);
                    }
                }
                if (this.writer.isTagged()) {
                    pdfPage.put(PdfName.STRUCTPARENTS, new PdfNumber(this.writer.getCurrentPageNumber() - 1));
                }
                if (this.text.size() > this.textEmptySize) {
                    this.text.endText();
                } else {
                    this.text = null;
                }
                this.writer.add(pdfPage, new PdfContents(this.writer.getDirectContentUnder(), this.graphics, this.text, this.writer.getDirectContent(), this.pageSize));
                initPage();
                return true;
            } catch (DocumentException e) {
                throw new ExceptionConverter(e);
            } catch (IOException e2) {
                throw new ExceptionConverter(e2);
            }
        }
    }

    public boolean setPageSize(Rectangle rectangle) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter != null && pdfWriter.isPaused()) {
            return false;
        }
        this.nextPageSize = new Rectangle(rectangle);
        return true;
    }

    public boolean setMargins(float f, float f2, float f3, float f4) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter != null && pdfWriter.isPaused()) {
            return false;
        }
        this.nextMarginLeft = f;
        this.nextMarginRight = f2;
        this.nextMarginTop = f3;
        this.nextMarginBottom = f4;
        return true;
    }

    public boolean setMarginMirroring(boolean z) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            return super.setMarginMirroring(z);
        }
        return false;
    }

    public boolean setMarginMirroringTopBottom(boolean z) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            return super.setMarginMirroringTopBottom(z);
        }
        return false;
    }

    public void setPageCount(int i) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            super.setPageCount(i);
        }
    }

    public void resetPageCount() {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            super.resetPageCount();
        }
    }

    public void setHeader(HeaderFooter headerFooter) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            super.setHeader(headerFooter);
        }
    }

    public void resetHeader() {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            super.resetHeader();
        }
    }

    public void setFooter(HeaderFooter headerFooter) {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            super.setFooter(headerFooter);
        }
    }

    public void resetFooter() {
        PdfWriter pdfWriter = this.writer;
        if (pdfWriter == null || !pdfWriter.isPaused()) {
            super.resetFooter();
        }
    }

    /* access modifiers changed from: protected */
    public void initPage() throws DocumentException {
        this.pageN++;
        this.annotationsImp.resetAnnotations();
        this.pageResources = new PageResources();
        this.writer.resetContent();
        this.graphics = new PdfContentByte(this.writer);
        this.text = new PdfContentByte(this.writer);
        this.text.reset();
        this.text.beginText();
        this.textEmptySize = this.text.size();
        this.markPoint = 0;
        setNewPageSizeAndMargins();
        this.imageEnd = -1.0f;
        Indentation indentation2 = this.indentation;
        indentation2.imageIndentRight = 0.0f;
        indentation2.imageIndentLeft = 0.0f;
        indentation2.indentBottom = 0.0f;
        indentation2.indentTop = 0.0f;
        this.currentHeight = 0.0f;
        this.thisBoxSize = new HashMap(this.boxSize);
        if (!(this.pageSize.getBackgroundColor() == null && !this.pageSize.hasBorders() && this.pageSize.getBorderColor() == null)) {
            add((Element) this.pageSize);
        }
        float f = this.leading;
        int i = this.alignment;
        doFooter();
        this.text.moveText(left(), top());
        doHeader();
        this.pageEmpty = true;
        try {
            if (this.imageWait != null) {
                add(this.imageWait);
                this.imageWait = null;
            }
            this.leading = f;
            this.alignment = i;
            carriageReturn();
            PdfPageEvent pageEvent = this.writer.getPageEvent();
            if (pageEvent != null) {
                if (this.firstPageEvent) {
                    pageEvent.onOpenDocument(this.writer, this);
                }
                pageEvent.onStartPage(this.writer, this);
            }
            this.firstPageEvent = false;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    public void newLine() throws DocumentException {
        this.lastElementType = -1;
        carriageReturn();
        ArrayList arrayList = this.lines;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.lines.add(this.line);
            this.currentHeight += this.line.height();
        }
        this.line = new PdfLine(indentLeft(), indentRight(), this.alignment, this.leading);
    }

    /* access modifiers changed from: protected */
    public void carriageReturn() {
        if (this.lines == null) {
            this.lines = new ArrayList();
        }
        PdfLine pdfLine = this.line;
        if (pdfLine != null) {
            if (this.currentHeight + pdfLine.height() + this.leading >= indentTop() - indentBottom()) {
                newPage();
            } else if (this.line.size() > 0) {
                this.currentHeight += this.line.height();
                this.lines.add(this.line);
                this.pageEmpty = false;
            }
        }
        float f = this.imageEnd;
        if (f > -1.0f && this.currentHeight > f) {
            this.imageEnd = -1.0f;
            Indentation indentation2 = this.indentation;
            indentation2.imageIndentRight = 0.0f;
            indentation2.imageIndentLeft = 0.0f;
        }
        this.line = new PdfLine(indentLeft(), indentRight(), this.alignment, this.leading);
    }

    public float getVerticalPosition(boolean z) {
        if (z) {
            ensureNewLine();
        }
        return (top() - this.currentHeight) - this.indentation.indentTop;
    }

    /* access modifiers changed from: protected */
    public void ensureNewLine() {
        try {
            if (this.lastElementType == 11 || this.lastElementType == 10) {
                newLine();
                flushLines();
            }
        } catch (DocumentException e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    public float flushLines() throws DocumentException {
        if (this.lines == null) {
            return 0.0f;
        }
        PdfLine pdfLine = this.line;
        if (pdfLine != null && pdfLine.size() > 0) {
            this.lines.add(this.line);
            this.line = new PdfLine(indentLeft(), indentRight(), this.alignment, this.leading);
        }
        if (this.lines.isEmpty()) {
            return 0.0f;
        }
        Object[] objArr = new Object[2];
        PdfFont pdfFont = null;
        objArr[1] = new Float(0.0f);
        Iterator it = this.lines.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            PdfLine pdfLine2 = (PdfLine) it.next();
            float indentLeft = (pdfLine2.indentLeft() - indentLeft()) + this.indentation.indentLeft + this.indentation.listIndentLeft + this.indentation.sectionIndentLeft;
            this.text.moveText(indentLeft, -pdfLine2.height());
            if (pdfLine2.listSymbol() != null) {
                ColumnText.showTextAligned(this.graphics, 0, new Phrase(pdfLine2.listSymbol()), this.text.getXTLM() - pdfLine2.listIndent(), this.text.getYTLM(), 0.0f);
            }
            objArr[0] = pdfFont;
            writeLineToContent(pdfLine2, this.text, this.graphics, objArr, this.writer.getSpaceCharRatio());
            pdfFont = (PdfFont) objArr[0];
            f += pdfLine2.height();
            this.text.moveText(-indentLeft, 0.0f);
        }
        this.lines = new ArrayList();
        return f;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeLineToContent(com.lowagie.text.pdf.PdfLine r43, com.lowagie.text.pdf.PdfContentByte r44, com.lowagie.text.pdf.PdfContentByte r45, java.lang.Object[] r46, float r47) throws com.lowagie.text.DocumentException {
        /*
            r42 = this;
            r7 = r42
            r8 = r43
            r9 = r44
            r15 = r45
            r14 = 0
            r0 = r46[r14]
            com.lowagie.text.pdf.PdfFont r0 = (com.lowagie.text.pdf.PdfFont) r0
            r13 = 1
            r1 = r46[r13]
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            int r12 = r43.numberOfSpaces()
            int r2 = r43.GetLineLengthUtf32()
            boolean r3 = r43.hasToBeJustified()
            if (r3 == 0) goto L_0x002b
            if (r12 != 0) goto L_0x0028
            if (r2 <= r13) goto L_0x002b
        L_0x0028:
            r18 = 1
            goto L_0x002d
        L_0x002b:
            r18 = 0
        L_0x002d:
            int r3 = r43.getSeparatorCount()
            r11 = 1065353216(0x3f800000, float:1.0)
            r10 = 0
            if (r3 <= 0) goto L_0x0041
            float r2 = r43.widthLeft()
            float r3 = (float) r3
            float r2 = r2 / r3
            r19 = r1
            r4 = r2
            goto L_0x00c4
        L_0x0041:
            if (r18 == 0) goto L_0x00c1
            boolean r3 = r43.isNewlineSplit()
            if (r3 == 0) goto L_0x006f
            float r3 = r43.widthLeft()
            float r4 = (float) r12
            float r4 = r4 * r47
            float r5 = (float) r2
            float r4 = r4 + r5
            float r4 = r4 - r11
            float r4 = r4 * r1
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 < 0) goto L_0x006f
            boolean r2 = r43.isRTL()
            if (r2 == 0) goto L_0x0067
            float r2 = r43.widthLeft()
            float r2 = r2 - r4
            r9.moveText(r2, r10)
        L_0x0067:
            float r2 = r47 * r1
            r5 = r1
            r19 = r5
            r6 = r2
            r4 = 0
            goto L_0x00c6
        L_0x006f:
            float r1 = r43.widthLeft()
            int r3 = r43.size()
            int r3 = r3 - r13
            com.lowagie.text.pdf.PdfChunk r3 = r8.getChunk(r3)
            if (r3 == 0) goto L_0x00af
            java.lang.String r4 = r3.toString()
            int r5 = r4.length()
            if (r5 <= 0) goto L_0x00af
            int r5 = r4.length()
            int r5 = r5 - r13
            char r4 = r4.charAt(r5)
            java.lang.String r5 = ".,;:'"
            int r5 = r5.indexOf(r4)
            if (r5 < 0) goto L_0x00af
            com.lowagie.text.pdf.PdfFont r3 = r3.font()
            float r3 = r3.width((int) r4)
            r4 = 1053609165(0x3ecccccd, float:0.4)
            float r3 = r3 * r4
            float r3 = r3 + r1
            float r1 = r3 - r1
            r41 = r3
            r3 = r1
            r1 = r41
            goto L_0x00b0
        L_0x00af:
            r3 = 0
        L_0x00b0:
            float r4 = (float) r12
            float r4 = r4 * r47
            float r2 = (float) r2
            float r4 = r4 + r2
            float r4 = r4 - r11
            float r1 = r1 / r4
            float r2 = r47 * r1
            r5 = r1
            r19 = r5
            r6 = r2
            r20 = r3
            r4 = 0
            goto L_0x00c8
        L_0x00c1:
            r19 = r1
            r4 = 0
        L_0x00c4:
            r5 = 0
            r6 = 0
        L_0x00c6:
            r20 = 0
        L_0x00c8:
            int r3 = r43.getLastStrokeChunk()
            float r21 = r44.getXTLM()
            float r2 = r44.getYTLM()
            java.util.Iterator r29 = r43.iterator()
            r1 = 2143289344(0x7fc00000, float:NaN)
            r16 = r21
            r1 = 0
            r17 = 0
            r30 = 0
            r31 = 2143289344(0x7fc00000, float:NaN)
        L_0x00e3:
            boolean r22 = r29.hasNext()
            if (r22 != 0) goto L_0x0110
            if (r18 == 0) goto L_0x00f9
            r9.setWordSpacing(r10)
            r9.setCharacterSpacing(r10)
            boolean r1 = r43.isNewlineSplit()
            if (r1 == 0) goto L_0x00f9
            r1 = 0
            goto L_0x00fb
        L_0x00f9:
            r1 = r19
        L_0x00fb:
            if (r30 == 0) goto L_0x0106
            float r2 = r44.getXTLM()
            float r2 = r21 - r2
            r9.moveText(r2, r10)
        L_0x0106:
            r46[r14] = r0
            java.lang.Float r0 = new java.lang.Float
            r0.<init>(r1)
            r46[r13] = r0
            return
        L_0x0110:
            java.lang.Object r22 = r29.next()
            r11 = r22
            com.lowagie.text.pdf.PdfChunk r11 = (com.lowagie.text.pdf.PdfChunk) r11
            harmony.java.awt.Color r10 = r11.color()
            if (r1 > r3) goto L_0x05d1
            if (r18 == 0) goto L_0x0125
            float r22 = r11.getWidthCorrected(r5, r6)
            goto L_0x0129
        L_0x0125:
            float r22 = r11.width()
        L_0x0129:
            boolean r23 = r11.isStroked()
            if (r23 == 0) goto L_0x05ab
            int r13 = r1 + 1
            com.lowagie.text.pdf.PdfChunk r13 = r8.getChunk(r13)
            boolean r23 = r11.isSeparator()
            if (r23 == 0) goto L_0x01c7
            java.lang.String r14 = "SEPARATOR"
            java.lang.Object r14 = r11.getAttribute(r14)
            java.lang.Object[] r14 = (java.lang.Object[]) r14
            r22 = 0
            r23 = r14[r22]
            r22 = r23
            com.lowagie.text.pdf.draw.DrawInterface r22 = (com.lowagie.text.pdf.draw.DrawInterface) r22
            r23 = r0
            r0 = 1
            r14 = r14[r0]
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            com.lowagie.text.pdf.PdfFont r24 = r11.font()
            float r0 = r24.size()
            com.lowagie.text.pdf.PdfFont r24 = r11.font()
            r25 = r1
            com.lowagie.text.pdf.BaseFont r1 = r24.getFont()
            r24 = r3
            r3 = 1
            float r1 = r1.getFontDescriptor(r3, r0)
            com.lowagie.text.pdf.PdfFont r3 = r11.font()
            com.lowagie.text.pdf.BaseFont r3 = r3.getFont()
            r26 = r4
            r4 = 3
            float r0 = r3.getFontDescriptor(r4, r0)
            boolean r3 = r14.booleanValue()
            if (r3 == 0) goto L_0x01a7
            float r3 = r2 + r0
            float r4 = r43.getOriginalWidth()
            float r4 = r21 + r4
            float r14 = r1 - r0
            r1 = r23
            r0 = r22
            r8 = r1
            r32 = r25
            r1 = r45
            r33 = r2
            r2 = r21
            r34 = r24
            r35 = r8
            r8 = r26
            r36 = r5
            r5 = r14
            r14 = r6
            r6 = r33
            r0.draw(r1, r2, r3, r4, r5, r6)
            goto L_0x01c4
        L_0x01a7:
            r36 = r5
            r14 = r6
            r35 = r23
            r34 = r24
            r32 = r25
            r8 = r26
            r6 = r2
            float r3 = r6 + r0
            float r4 = r16 + r8
            float r5 = r1 - r0
            r0 = r22
            r1 = r45
            r2 = r16
            r33 = r6
            r0.draw(r1, r2, r3, r4, r5, r6)
        L_0x01c4:
            r37 = r8
            goto L_0x01d5
        L_0x01c7:
            r35 = r0
            r32 = r1
            r33 = r2
            r34 = r3
            r8 = r4
            r36 = r5
            r14 = r6
            r37 = r22
        L_0x01d5:
            boolean r0 = r11.isTab()
            if (r0 == 0) goto L_0x0237
            java.lang.String r0 = "TAB"
            java.lang.Object r0 = r11.getAttribute(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r1 = 0
            r2 = r0[r1]
            r1 = r2
            com.lowagie.text.pdf.draw.DrawInterface r1 = (com.lowagie.text.pdf.draw.DrawInterface) r1
            r2 = 1
            r3 = r0[r2]
            java.lang.Float r3 = (java.lang.Float) r3
            float r3 = r3.floatValue()
            r4 = 3
            r0 = r0[r4]
            java.lang.Float r0 = (java.lang.Float) r0
            float r0 = r0.floatValue()
            float r17 = r3 + r0
            com.lowagie.text.pdf.PdfFont r0 = r11.font()
            float r0 = r0.size()
            com.lowagie.text.pdf.PdfFont r3 = r11.font()
            com.lowagie.text.pdf.BaseFont r3 = r3.getFont()
            float r3 = r3.getFontDescriptor(r2, r0)
            com.lowagie.text.pdf.PdfFont r2 = r11.font()
            com.lowagie.text.pdf.BaseFont r2 = r2.getFont()
            float r0 = r2.getFontDescriptor(r4, r0)
            int r2 = (r17 > r16 ? 1 : (r17 == r16 ? 0 : -1))
            if (r2 <= 0) goto L_0x0232
            r6 = r33
            float r4 = r6 + r0
            float r5 = r3 - r0
            r0 = r1
            r1 = r45
            r2 = r16
            r3 = r4
            r4 = r17
            r0.draw(r1, r2, r3, r4, r5, r6)
        L_0x0232:
            r38 = r16
            r6 = r17
            goto L_0x023b
        L_0x0237:
            r6 = r16
            r38 = r17
        L_0x023b:
            java.lang.String r0 = "BACKGROUND"
            boolean r1 = r11.isAttribute(r0)
            if (r1 == 0) goto L_0x02bf
            if (r13 == 0) goto L_0x024d
            boolean r1 = r13.isAttribute(r0)
            if (r1 == 0) goto L_0x024d
            r1 = 0
            goto L_0x024f
        L_0x024d:
            r1 = r19
        L_0x024f:
            if (r13 != 0) goto L_0x0253
            float r1 = r1 + r20
        L_0x0253:
            com.lowagie.text.pdf.PdfFont r2 = r11.font()
            float r2 = r2.size()
            com.lowagie.text.pdf.PdfFont r3 = r11.font()
            com.lowagie.text.pdf.BaseFont r3 = r3.getFont()
            r4 = 1
            float r3 = r3.getFontDescriptor(r4, r2)
            com.lowagie.text.pdf.PdfFont r5 = r11.font()
            com.lowagie.text.pdf.BaseFont r5 = r5.getFont()
            r4 = 3
            float r2 = r5.getFontDescriptor(r4, r2)
            java.lang.Object r0 = r11.getAttribute(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r4 = 0
            r5 = r0[r4]
            harmony.java.awt.Color r5 = (harmony.java.awt.Color) r5
            r15.setColorFill(r5)
            r5 = 1
            r0 = r0[r5]
            float[] r0 = (float[]) r0
            r16 = r0[r4]
            float r4 = r6 - r16
            r39 = r8
            r8 = r33
            float r16 = r8 + r2
            r17 = r0[r5]
            float r16 = r16 - r17
            float r17 = r11.getTextRise()
            float r5 = r16 + r17
            float r1 = r37 - r1
            r16 = 0
            r17 = r0[r16]
            float r1 = r1 + r17
            r16 = 2
            r17 = r0[r16]
            float r1 = r1 + r17
            float r3 = r3 - r2
            r2 = 1
            r16 = r0[r2]
            float r3 = r3 + r16
            r2 = 3
            r0 = r0[r2]
            float r3 = r3 + r0
            r15.rectangle(r4, r5, r1, r3)
            r45.fill()
            r0 = 0
            r15.setGrayFill(r0)
            goto L_0x02c3
        L_0x02bf:
            r39 = r8
            r8 = r33
        L_0x02c3:
            java.lang.String r0 = "UNDERLINE"
            boolean r1 = r11.isAttribute(r0)
            r16 = 4
            if (r1 == 0) goto L_0x0350
            if (r13 == 0) goto L_0x02d7
            boolean r1 = r13.isAttribute(r0)
            if (r1 == 0) goto L_0x02d7
            r1 = 0
            goto L_0x02d9
        L_0x02d7:
            r1 = r19
        L_0x02d9:
            if (r13 != 0) goto L_0x02dd
            float r1 = r1 + r20
        L_0x02dd:
            java.lang.Object r0 = r11.getAttribute(r0)
            java.lang.Object[][] r0 = (java.lang.Object[][]) r0
            r2 = 0
        L_0x02e4:
            int r3 = r0.length
            if (r2 < r3) goto L_0x02ed
            r5 = 1065353216(0x3f800000, float:1.0)
            r15.setLineWidth(r5)
            goto L_0x0350
        L_0x02ed:
            r5 = 1065353216(0x3f800000, float:1.0)
            r3 = r0[r2]
            r4 = 0
            r17 = r3[r4]
            r4 = r17
            harmony.java.awt.Color r4 = (harmony.java.awt.Color) r4
            r17 = 1
            r3 = r3[r17]
            float[] r3 = (float[]) r3
            if (r4 != 0) goto L_0x0301
            r4 = r10
        L_0x0301:
            if (r4 == 0) goto L_0x0306
            r15.setColorStroke(r4)
        L_0x0306:
            com.lowagie.text.pdf.PdfFont r17 = r11.font()
            float r17 = r17.size()
            r22 = 0
            r23 = r3[r22]
            r22 = 1
            r24 = r3[r22]
            float r24 = r24 * r17
            float r5 = r23 + r24
            r15.setLineWidth(r5)
            r5 = 2
            r22 = r3[r5]
            r5 = 3
            r23 = r3[r5]
            float r17 = r17 * r23
            float r22 = r22 + r17
            r3 = r3[r16]
            int r3 = (int) r3
            if (r3 == 0) goto L_0x032f
            r15.setLineCap(r3)
        L_0x032f:
            float r5 = r8 + r22
            r15.moveTo(r6, r5)
            float r17 = r6 + r37
            r22 = r0
            float r0 = r17 - r1
            r15.lineTo(r0, r5)
            r45.stroke()
            if (r4 == 0) goto L_0x0345
            r45.resetGrayStroke()
        L_0x0345:
            if (r3 == 0) goto L_0x034b
            r0 = 0
            r15.setLineCap(r0)
        L_0x034b:
            int r2 = r2 + 1
            r0 = r22
            goto L_0x02e4
        L_0x0350:
            java.lang.String r0 = "ACTION"
            boolean r1 = r11.isAttribute(r0)
            if (r1 == 0) goto L_0x0390
            if (r13 == 0) goto L_0x0362
            boolean r1 = r13.isAttribute(r0)
            if (r1 == 0) goto L_0x0362
            r1 = 0
            goto L_0x0364
        L_0x0362:
            r1 = r19
        L_0x0364:
            if (r13 != 0) goto L_0x0368
            float r1 = r1 + r20
        L_0x0368:
            com.lowagie.text.pdf.PdfAnnotation r2 = new com.lowagie.text.pdf.PdfAnnotation
            com.lowagie.text.pdf.PdfWriter r3 = r7.writer
            float r4 = r6 + r37
            float r26 = r4 - r1
            com.lowagie.text.pdf.PdfFont r1 = r11.font()
            float r1 = r1.size()
            float r27 = r8 + r1
            java.lang.Object r0 = r11.getAttribute(r0)
            r28 = r0
            com.lowagie.text.pdf.PdfAction r28 = (com.lowagie.text.pdf.PdfAction) r28
            r22 = r2
            r23 = r3
            r24 = r6
            r25 = r8
            r22.<init>(r23, r24, r25, r26, r27, r28)
            r9.addAnnotation(r2)
        L_0x0390:
            java.lang.String r0 = "REMOTEGOTO"
            boolean r1 = r11.isAttribute(r0)
            if (r1 == 0) goto L_0x0400
            if (r13 == 0) goto L_0x03a2
            boolean r1 = r13.isAttribute(r0)
            if (r1 == 0) goto L_0x03a2
            r1 = 0
            goto L_0x03a4
        L_0x03a2:
            r1 = r19
        L_0x03a4:
            if (r13 != 0) goto L_0x03a8
            float r1 = r1 + r20
        L_0x03a8:
            java.lang.Object r0 = r11.getAttribute(r0)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r2 = 0
            r3 = r0[r2]
            r2 = r3
            java.lang.String r2 = (java.lang.String) r2
            r3 = 1
            r4 = r0[r3]
            boolean r4 = r4 instanceof java.lang.String
            if (r4 == 0) goto L_0x03dd
            r0 = r0[r3]
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
            float r0 = r6 + r37
            float r5 = r0 - r1
            com.lowagie.text.pdf.PdfFont r0 = r11.font()
            float r0 = r0.size()
            float r17 = r8 + r0
            r0 = r42
            r1 = r2
            r2 = r3
            r3 = r6
            r4 = r8
            r22 = 1065353216(0x3f800000, float:1.0)
            r15 = r6
            r6 = r17
            r0.remoteGoto((java.lang.String) r1, (java.lang.String) r2, (float) r3, (float) r4, (float) r5, (float) r6)
            goto L_0x0403
        L_0x03dd:
            r15 = r6
            r22 = 1065353216(0x3f800000, float:1.0)
            r0 = r0[r3]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r3 = r0.intValue()
            float r6 = r15 + r37
            float r5 = r6 - r1
            com.lowagie.text.pdf.PdfFont r0 = r11.font()
            float r0 = r0.size()
            float r6 = r8 + r0
            r0 = r42
            r1 = r2
            r2 = r3
            r3 = r15
            r4 = r8
            r0.remoteGoto((java.lang.String) r1, (int) r2, (float) r3, (float) r4, (float) r5, (float) r6)
            goto L_0x0403
        L_0x0400:
            r15 = r6
            r22 = 1065353216(0x3f800000, float:1.0)
        L_0x0403:
            java.lang.String r0 = "LOCALGOTO"
            boolean r1 = r11.isAttribute(r0)
            if (r1 == 0) goto L_0x0438
            if (r13 == 0) goto L_0x0415
            boolean r1 = r13.isAttribute(r0)
            if (r1 == 0) goto L_0x0415
            r1 = 0
            goto L_0x0417
        L_0x0415:
            r1 = r19
        L_0x0417:
            if (r13 != 0) goto L_0x041b
            float r1 = r1 + r20
        L_0x041b:
            java.lang.Object r0 = r11.getAttribute(r0)
            r2 = r0
            java.lang.String r2 = (java.lang.String) r2
            float r6 = r15 + r37
            float r4 = r6 - r1
            com.lowagie.text.pdf.PdfFont r0 = r11.font()
            float r0 = r0.size()
            float r5 = r8 + r0
            r0 = r42
            r1 = r2
            r2 = r15
            r3 = r8
            r0.localGoto(r1, r2, r3, r4, r5)
        L_0x0438:
            java.lang.String r0 = "LOCALDESTINATION"
            boolean r1 = r11.isAttribute(r0)
            if (r1 == 0) goto L_0x0460
            if (r13 == 0) goto L_0x0446
            boolean r1 = r13.isAttribute(r0)
        L_0x0446:
            java.lang.Object r0 = r11.getAttribute(r0)
            java.lang.String r0 = (java.lang.String) r0
            com.lowagie.text.pdf.PdfDestination r1 = new com.lowagie.text.pdf.PdfDestination
            com.lowagie.text.pdf.PdfFont r2 = r11.font()
            float r2 = r2.size()
            float r2 = r2 + r8
            r3 = 0
            r6 = 0
            r1.<init>(r3, r15, r2, r6)
            r7.localDestination(r0, r1)
            goto L_0x0461
        L_0x0460:
            r6 = 0
        L_0x0461:
            java.lang.String r0 = "GENERICTAG"
            boolean r1 = r11.isAttribute(r0)
            if (r1 == 0) goto L_0x049d
            if (r13 == 0) goto L_0x0473
            boolean r1 = r13.isAttribute(r0)
            if (r1 == 0) goto L_0x0473
            r1 = 0
            goto L_0x0475
        L_0x0473:
            r1 = r19
        L_0x0475:
            if (r13 != 0) goto L_0x0479
            float r1 = r1 + r20
        L_0x0479:
            com.lowagie.text.Rectangle r2 = new com.lowagie.text.Rectangle
            float r3 = r15 + r37
            float r3 = r3 - r1
            com.lowagie.text.pdf.PdfFont r1 = r11.font()
            float r1 = r1.size()
            float r1 = r1 + r8
            r2.<init>(r15, r8, r3, r1)
            com.lowagie.text.pdf.PdfWriter r1 = r7.writer
            com.lowagie.text.pdf.PdfPageEvent r1 = r1.getPageEvent()
            if (r1 == 0) goto L_0x049d
            com.lowagie.text.pdf.PdfWriter r3 = r7.writer
            java.lang.Object r0 = r11.getAttribute(r0)
            java.lang.String r0 = (java.lang.String) r0
            r1.onGenericTag(r3, r7, r2, r0)
        L_0x049d:
            java.lang.String r0 = "PDFANNOTATION"
            boolean r0 = r11.isAttribute(r0)
            if (r0 == 0) goto L_0x04f7
            if (r13 == 0) goto L_0x04b1
            java.lang.String r0 = "PDFANNOTATION"
            boolean r0 = r13.isAttribute(r0)
            if (r0 == 0) goto L_0x04b1
            r0 = 0
            goto L_0x04b3
        L_0x04b1:
            r0 = r19
        L_0x04b3:
            if (r13 != 0) goto L_0x04b7
            float r0 = r0 + r20
        L_0x04b7:
            com.lowagie.text.pdf.PdfFont r1 = r11.font()
            float r1 = r1.size()
            com.lowagie.text.pdf.PdfFont r2 = r11.font()
            com.lowagie.text.pdf.BaseFont r2 = r2.getFont()
            r3 = 1
            float r2 = r2.getFontDescriptor(r3, r1)
            com.lowagie.text.pdf.PdfFont r3 = r11.font()
            com.lowagie.text.pdf.BaseFont r3 = r3.getFont()
            r4 = 3
            float r1 = r3.getFontDescriptor(r4, r1)
            java.lang.String r3 = "PDFANNOTATION"
            java.lang.Object r3 = r11.getAttribute(r3)
            com.lowagie.text.pdf.PdfAnnotation r3 = (com.lowagie.text.pdf.PdfAnnotation) r3
            com.lowagie.text.pdf.PdfAnnotation r3 = com.lowagie.text.pdf.PdfFormField.shallowDuplicate(r3)
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.RECT
            com.lowagie.text.pdf.PdfRectangle r5 = new com.lowagie.text.pdf.PdfRectangle
            float r1 = r1 + r8
            float r13 = r15 + r37
            float r13 = r13 - r0
            float r2 = r2 + r8
            r5.<init>(r15, r1, r13, r2)
            r3.put(r4, r5)
            r9.addAnnotation(r3)
        L_0x04f7:
            java.lang.String r0 = "SKEW"
            java.lang.Object r0 = r11.getAttribute(r0)
            float[] r0 = (float[]) r0
            java.lang.String r1 = "HSCALE"
            java.lang.Object r1 = r11.getAttribute(r1)
            java.lang.Float r1 = (java.lang.Float) r1
            if (r0 != 0) goto L_0x0511
            if (r1 == 0) goto L_0x050c
            goto L_0x0511
        L_0x050c:
            r0 = 1065353216(0x3f800000, float:1.0)
            r17 = 0
            goto L_0x0535
        L_0x0511:
            if (r0 == 0) goto L_0x051c
            r2 = 0
            r3 = r0[r2]
            r2 = 1
            r0 = r0[r2]
            r2 = r3
            r3 = r0
            goto L_0x051e
        L_0x051c:
            r2 = 0
            r3 = 0
        L_0x051e:
            if (r1 == 0) goto L_0x0526
            float r0 = r1.floatValue()
            r13 = r0
            goto L_0x0528
        L_0x0526:
            r13 = 1065353216(0x3f800000, float:1.0)
        L_0x0528:
            r4 = 1065353216(0x3f800000, float:1.0)
            r0 = r44
            r1 = r13
            r5 = r15
            r17 = 0
            r6 = r8
            r0.setTextMatrix(r1, r2, r3, r4, r5, r6)
            r0 = r13
        L_0x0535:
            boolean r1 = r11.isImage()
            if (r1 == 0) goto L_0x0599
            com.lowagie.text.Image r1 = r11.getImage()
            float[] r2 = r1.matrix()
            float r3 = r11.getImageOffsetX()
            float r6 = r15 + r3
            r3 = r2[r16]
            float r6 = r6 - r3
            r2[r16] = r6
            r3 = 5
            float r4 = r11.getImageOffsetY()
            float r4 = r4 + r8
            r5 = 5
            r5 = r2[r5]
            float r4 = r4 - r5
            r2[r3] = r4
            r3 = 0
            r4 = r2[r3]
            r5 = 1
            r13 = r2[r5]
            r6 = 2
            r23 = r2[r6]
            r24 = 3
            r25 = r2[r24]
            r16 = r2[r16]
            r26 = 5
            r2 = r2[r26]
            r3 = r10
            r5 = 0
            r10 = r45
            r47 = r11
            r6 = 1065353216(0x3f800000, float:1.0)
            r11 = r1
            r26 = r12
            r12 = r4
            r4 = 2
            r6 = 1
            r40 = r14
            r4 = 0
            r14 = r23
            r22 = r15
            r15 = r25
            r17 = r2
            r10.addImage(r11, r12, r13, r14, r15, r16, r17)
            float r2 = r22 + r19
            float r1 = r1.getScaledWidth()
            float r2 = r2 + r1
            float r1 = r44.getXTLM()
            float r2 = r2 - r1
            r9.moveText(r2, r5)
            goto L_0x05a7
        L_0x0599:
            r3 = r10
            r47 = r11
            r26 = r12
            r40 = r14
            r22 = r15
            r4 = 0
            r5 = 0
            r6 = 1
            r24 = 3
        L_0x05a7:
            r11 = r0
            r16 = r22
            goto L_0x05c8
        L_0x05ab:
            r35 = r0
            r32 = r1
            r8 = r2
            r34 = r3
            r39 = r4
            r36 = r5
            r40 = r6
            r3 = r10
            r47 = r11
            r26 = r12
            r4 = 0
            r5 = 0
            r6 = 1
            r24 = 3
            r38 = r17
            r37 = r22
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x05c8:
            float r16 = r16 + r37
            int r1 = r32 + 1
            r0 = r16
            r17 = r38
            goto L_0x05ec
        L_0x05d1:
            r35 = r0
            r32 = r1
            r8 = r2
            r34 = r3
            r39 = r4
            r36 = r5
            r40 = r6
            r3 = r10
            r47 = r11
            r26 = r12
            r4 = 0
            r5 = 0
            r6 = 1
            r24 = 3
            r0 = r16
            r11 = 1065353216(0x3f800000, float:1.0)
        L_0x05ec:
            com.lowagie.text.pdf.PdfFont r2 = r47.font()
            r10 = r35
            int r2 = r2.compareTo(r10)
            if (r2 == 0) goto L_0x0608
            com.lowagie.text.pdf.PdfFont r2 = r47.font()
            com.lowagie.text.pdf.BaseFont r10 = r2.getFont()
            float r12 = r2.size()
            r9.setFontAndSize(r10, r12)
            r10 = r2
        L_0x0608:
            java.lang.String r2 = "TEXTRENDERMODE"
            r12 = r47
            java.lang.Object r2 = r12.getAttribute(r2)
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            java.lang.String r14 = "SUBSUPSCRIPT"
            java.lang.Object r14 = r12.getAttribute(r14)
            java.lang.Float r14 = (java.lang.Float) r14
            if (r2 == 0) goto L_0x0655
            r15 = r2[r4]
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            r15 = r15 & 3
            if (r15 == 0) goto L_0x062b
            r9.setTextRenderingMode(r15)
        L_0x062b:
            if (r15 == r6) goto L_0x0635
            r13 = 2
            if (r15 != r13) goto L_0x0631
            goto L_0x0635
        L_0x0631:
            r2 = 0
            r13 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0659
        L_0x0635:
            r13 = r2[r6]
            java.lang.Float r13 = (java.lang.Float) r13
            float r13 = r13.floatValue()
            r16 = 1065353216(0x3f800000, float:1.0)
            int r22 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r22 == 0) goto L_0x0646
            r9.setLineWidth(r13)
        L_0x0646:
            r16 = 2
            r2 = r2[r16]
            harmony.java.awt.Color r2 = (harmony.java.awt.Color) r2
            if (r2 != 0) goto L_0x064f
            r2 = r3
        L_0x064f:
            if (r2 == 0) goto L_0x0659
            r9.setColorStroke(r2)
            goto L_0x0659
        L_0x0655:
            r2 = 0
            r13 = 1065353216(0x3f800000, float:1.0)
            r15 = 0
        L_0x0659:
            if (r14 == 0) goto L_0x0660
            float r14 = r14.floatValue()
            goto L_0x0661
        L_0x0660:
            r14 = 0
        L_0x0661:
            if (r3 == 0) goto L_0x0666
            r9.setColorFill(r3)
        L_0x0666:
            int r16 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r16 == 0) goto L_0x066d
            r9.setTextRise(r14)
        L_0x066d:
            boolean r14 = r12.isImage()
            if (r14 == 0) goto L_0x067b
            r47 = r1
            r4 = r40
            r30 = 1
            goto L_0x075a
        L_0x067b:
            boolean r14 = r12.isHorizontalSeparator()
            r22 = 1148846080(0x447a0000, float:1000.0)
            if (r14 == 0) goto L_0x069c
            com.lowagie.text.pdf.PdfTextArray r14 = new com.lowagie.text.pdf.PdfTextArray
            r14.<init>()
            r6 = r39
            float r5 = -r6
            float r5 = r5 * r22
            com.lowagie.text.pdf.PdfFont r4 = r12.font
            float r4 = r4.size()
            float r5 = r5 / r4
            float r5 = r5 / r11
            r14.add((float) r5)
            r9.showText((com.lowagie.text.pdf.PdfTextArray) r14)
            goto L_0x06bb
        L_0x069c:
            r6 = r39
            boolean r4 = r12.isTab()
            if (r4 == 0) goto L_0x06c3
            com.lowagie.text.pdf.PdfTextArray r4 = new com.lowagie.text.pdf.PdfTextArray
            r4.<init>()
            float r5 = r17 - r0
            float r5 = r5 * r22
            com.lowagie.text.pdf.PdfFont r14 = r12.font
            float r14 = r14.size()
            float r5 = r5 / r14
            float r5 = r5 / r11
            r4.add((float) r5)
            r9.showText((com.lowagie.text.pdf.PdfTextArray) r4)
        L_0x06bb:
            r47 = r1
            r39 = r6
            r4 = r40
            goto L_0x075a
        L_0x06c3:
            if (r18 == 0) goto L_0x0738
            if (r26 <= 0) goto L_0x0738
            boolean r4 = r12.isSpecialEncoding()
            if (r4 == 0) goto L_0x0738
            int r4 = (r11 > r31 ? 1 : (r11 == r31 ? 0 : -1))
            if (r4 == 0) goto L_0x06df
            r4 = r40
            float r5 = r4 / r11
            r9.setWordSpacing(r5)
            float r5 = r36 / r11
            r9.setCharacterSpacing(r5)
            r5 = r11
            goto L_0x06e3
        L_0x06df:
            r4 = r40
            r5 = r31
        L_0x06e3:
            java.lang.String r14 = r12.toString()
            r47 = r1
            r1 = 32
            int r1 = r14.indexOf(r1)
            if (r1 >= 0) goto L_0x06f9
            r9.showText((java.lang.String) r14)
            r23 = r5
            r39 = r6
            goto L_0x0729
        L_0x06f9:
            r23 = r5
            float r5 = -r4
            float r5 = r5 * r22
            r39 = r6
            com.lowagie.text.pdf.PdfFont r6 = r12.font
            float r6 = r6.size()
            float r5 = r5 / r6
            float r5 = r5 / r11
            com.lowagie.text.pdf.PdfTextArray r6 = new com.lowagie.text.pdf.PdfTextArray
            r11 = 0
            java.lang.String r7 = r14.substring(r11, r1)
            r6.<init>(r7)
        L_0x0712:
            r7 = 32
            int r11 = r1 + 1
            int r7 = r14.indexOf(r7, r11)
            if (r7 >= 0) goto L_0x072c
            r6.add((float) r5)
            java.lang.String r1 = r14.substring(r1)
            r6.add((java.lang.String) r1)
            r9.showText((com.lowagie.text.pdf.PdfTextArray) r6)
        L_0x0729:
            r31 = r23
            goto L_0x075a
        L_0x072c:
            r6.add((float) r5)
            java.lang.String r1 = r14.substring(r1, r7)
            r6.add((java.lang.String) r1)
            r1 = r7
            goto L_0x0712
        L_0x0738:
            r47 = r1
            r39 = r6
            r4 = r40
            if (r18 == 0) goto L_0x074f
            int r1 = (r11 > r31 ? 1 : (r11 == r31 ? 0 : -1))
            if (r1 == 0) goto L_0x074f
            float r6 = r4 / r11
            r9.setWordSpacing(r6)
            float r5 = r36 / r11
            r9.setCharacterSpacing(r5)
            goto L_0x0751
        L_0x074f:
            r11 = r31
        L_0x0751:
            java.lang.String r1 = r12.toString()
            r9.showText((java.lang.String) r1)
            r31 = r11
        L_0x075a:
            if (r16 == 0) goto L_0x0761
            r1 = 0
            r9.setTextRise(r1)
            goto L_0x0762
        L_0x0761:
            r1 = 0
        L_0x0762:
            if (r3 == 0) goto L_0x0767
            r44.resetRGBColorFill()
        L_0x0767:
            if (r15 == 0) goto L_0x076e
            r3 = 0
            r9.setTextRenderingMode(r3)
            goto L_0x076f
        L_0x076e:
            r3 = 0
        L_0x076f:
            if (r2 == 0) goto L_0x0774
            r44.resetRGBColorStroke()
        L_0x0774:
            r2 = 1065353216(0x3f800000, float:1.0)
            int r5 = (r13 > r2 ? 1 : (r13 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x077d
            r9.setLineWidth(r2)
        L_0x077d:
            java.lang.String r5 = "SKEW"
            boolean r5 = r12.isAttribute(r5)
            if (r5 != 0) goto L_0x07a7
            java.lang.String r5 = "HSCALE"
            boolean r5 = r12.isAttribute(r5)
            if (r5 == 0) goto L_0x078e
            goto L_0x07a7
        L_0x078e:
            r7 = r42
            r15 = r45
            r1 = r47
            r16 = r0
            r6 = r4
            r2 = r8
            r0 = r10
            r12 = r26
            r3 = r34
            r5 = r36
            r4 = r39
            r10 = 0
            r11 = 1065353216(0x3f800000, float:1.0)
            r13 = 1
            r14 = 0
            goto L_0x07c4
        L_0x07a7:
            r9.setTextMatrix(r0, r8)
            r7 = r42
            r15 = r45
            r1 = r47
            r16 = r0
            r6 = r4
            r2 = r8
            r0 = r10
            r12 = r26
            r3 = r34
            r5 = r36
            r4 = r39
            r10 = 0
            r11 = 1065353216(0x3f800000, float:1.0)
            r13 = 1
            r14 = 0
            r30 = 1
        L_0x07c4:
            r8 = r43
            goto L_0x00e3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfDocument.writeLineToContent(com.lowagie.text.pdf.PdfLine, com.lowagie.text.pdf.PdfContentByte, com.lowagie.text.pdf.PdfContentByte, java.lang.Object[], float):void");
    }

    /* access modifiers changed from: protected */
    public float indentLeft() {
        return left(this.indentation.indentLeft + this.indentation.listIndentLeft + this.indentation.imageIndentLeft + this.indentation.sectionIndentLeft);
    }

    /* access modifiers changed from: protected */
    public float indentRight() {
        return right(this.indentation.indentRight + this.indentation.sectionIndentRight + this.indentation.imageIndentRight);
    }

    /* access modifiers changed from: protected */
    public float indentTop() {
        return top(this.indentation.indentTop);
    }

    /* access modifiers changed from: package-private */
    public float indentBottom() {
        return bottom(this.indentation.indentBottom);
    }

    /* access modifiers changed from: protected */
    public void addSpacing(float f, float f2, Font font) {
        Font font2;
        if (f != 0.0f && !this.pageEmpty && this.currentHeight + this.line.height() + this.leading <= indentTop() - indentBottom()) {
            this.leading = f;
            carriageReturn();
            if (font.isUnderlined() || font.isStrikethru()) {
                font2 = new Font(font);
                font2.setStyle(font2.getStyle() & -5 & -9);
            } else {
                font2 = font;
            }
            new Chunk(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, font2).process(this);
            carriageReturn();
            this.leading = f2;
        }
    }

    /* access modifiers changed from: package-private */
    public PdfInfo getInfo() {
        return this.info;
    }

    /* access modifiers changed from: package-private */
    public PdfCatalog getCatalog(PdfIndirectReference pdfIndirectReference) {
        PdfCatalog pdfCatalog = new PdfCatalog(pdfIndirectReference, this.writer);
        if (this.rootOutline.getKids().size() > 0) {
            pdfCatalog.put(PdfName.PAGEMODE, PdfName.USEOUTLINES);
            pdfCatalog.put(PdfName.OUTLINES, this.rootOutline.indirectReference());
        }
        this.writer.getPdfVersion().addToCatalog(pdfCatalog);
        this.viewerPreferences.addToCatalog(pdfCatalog);
        if (this.pageLabels != null) {
            pdfCatalog.put(PdfName.PAGELABELS, this.pageLabels.getDictionary(this.writer));
        }
        pdfCatalog.addNames(this.localDestinations, getDocumentLevelJS(), this.documentFileAttachment, this.writer);
        String str = this.openActionName;
        if (str != null) {
            pdfCatalog.setOpenAction(getLocalGotoAction(str));
        } else {
            PdfAction pdfAction = this.openActionAction;
            if (pdfAction != null) {
                pdfCatalog.setOpenAction(pdfAction);
            }
        }
        PdfDictionary pdfDictionary = this.additionalActions;
        if (pdfDictionary != null) {
            pdfCatalog.setAdditionalActions(pdfDictionary);
        }
        if (this.collection != null) {
            pdfCatalog.put(PdfName.COLLECTION, this.collection);
        }
        if (this.annotationsImp.hasValidAcroForm()) {
            try {
                pdfCatalog.put(PdfName.ACROFORM, this.writer.addToBody(this.annotationsImp.getAcroForm()).getIndirectReference());
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
        return pdfCatalog;
    }

    /* access modifiers changed from: package-private */
    public void addOutline(PdfOutline pdfOutline, String str) {
        localDestination(str, pdfOutline.getPdfDestination());
    }

    public PdfOutline getRootOutline() {
        return this.rootOutline;
    }

    /* access modifiers changed from: package-private */
    public void calculateOutlineCount() {
        if (this.rootOutline.getKids().size() != 0) {
            traverseOutlineCount(this.rootOutline);
        }
    }

    /* access modifiers changed from: package-private */
    public void traverseOutlineCount(PdfOutline pdfOutline) {
        ArrayList kids = pdfOutline.getKids();
        PdfOutline parent = pdfOutline.parent();
        if (!kids.isEmpty()) {
            for (int i = 0; i < kids.size(); i++) {
                traverseOutlineCount((PdfOutline) kids.get(i));
            }
            if (parent == null) {
                return;
            }
            if (pdfOutline.isOpen()) {
                parent.setCount(pdfOutline.getCount() + parent.getCount() + 1);
                return;
            }
            parent.setCount(parent.getCount() + 1);
            pdfOutline.setCount(-pdfOutline.getCount());
        } else if (parent != null) {
            parent.setCount(parent.getCount() + 1);
        }
    }

    /* access modifiers changed from: package-private */
    public void writeOutlines() throws IOException {
        if (this.rootOutline.getKids().size() != 0) {
            outlineTree(this.rootOutline);
            PdfWriter pdfWriter = this.writer;
            PdfOutline pdfOutline = this.rootOutline;
            pdfWriter.addToBody((PdfObject) pdfOutline, pdfOutline.indirectReference());
        }
    }

    /* access modifiers changed from: package-private */
    public void outlineTree(PdfOutline pdfOutline) throws IOException {
        pdfOutline.setIndirectReference(this.writer.getPdfIndirectReference());
        if (pdfOutline.parent() != null) {
            pdfOutline.put(PdfName.PARENT, pdfOutline.parent().indirectReference());
        }
        ArrayList kids = pdfOutline.getKids();
        int size = kids.size();
        for (int i = 0; i < size; i++) {
            outlineTree((PdfOutline) kids.get(i));
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                ((PdfOutline) kids.get(i2)).put(PdfName.PREV, ((PdfOutline) kids.get(i2 - 1)).indirectReference());
            }
            if (i2 < size - 1) {
                ((PdfOutline) kids.get(i2)).put(PdfName.NEXT, ((PdfOutline) kids.get(i2 + 1)).indirectReference());
            }
        }
        if (size > 0) {
            pdfOutline.put(PdfName.FIRST, ((PdfOutline) kids.get(0)).indirectReference());
            pdfOutline.put(PdfName.LAST, ((PdfOutline) kids.get(size - 1)).indirectReference());
        }
        for (int i3 = 0; i3 < size; i3++) {
            PdfOutline pdfOutline2 = (PdfOutline) kids.get(i3);
            this.writer.addToBody((PdfObject) pdfOutline2, pdfOutline2.indirectReference());
        }
    }

    /* access modifiers changed from: package-private */
    public void setViewerPreferences(int i) {
        this.viewerPreferences.setViewerPreferences(i);
    }

    /* access modifiers changed from: package-private */
    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.viewerPreferences.addViewerPreference(pdfName, pdfObject);
    }

    /* access modifiers changed from: package-private */
    public void setPageLabels(PdfPageLabels pdfPageLabels) {
        this.pageLabels = pdfPageLabels;
    }

    /* access modifiers changed from: package-private */
    public void localGoto(String str, float f, float f2, float f3, float f4) {
        this.annotationsImp.addPlainAnnotation(new PdfAnnotation(this.writer, f, f2, f3, f4, getLocalGotoAction(str)));
    }

    /* access modifiers changed from: package-private */
    public void remoteGoto(String str, String str2, float f, float f2, float f3, float f4) {
        this.annotationsImp.addPlainAnnotation(new PdfAnnotation(this.writer, f, f2, f3, f4, new PdfAction(str, str2)));
    }

    /* access modifiers changed from: package-private */
    public void remoteGoto(String str, int i, float f, float f2, float f3, float f4) {
        addAnnotation(new PdfAnnotation(this.writer, f, f2, f3, f4, new PdfAction(str, i)));
    }

    /* access modifiers changed from: package-private */
    public void setAction(PdfAction pdfAction, float f, float f2, float f3, float f4) {
        addAnnotation(new PdfAnnotation(this.writer, f, f2, f3, f4, pdfAction));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.lowagie.text.pdf.PdfAction} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.Object[]} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.pdf.PdfAction getLocalGotoAction(java.lang.String r5) {
        /*
            r4 = this;
            java.util.TreeMap r0 = r4.localDestinations
            java.lang.Object r0 = r0.get(r5)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            if (r0 != 0) goto L_0x000d
            r0 = 3
            java.lang.Object[] r0 = new java.lang.Object[r0]
        L_0x000d:
            r1 = 0
            r2 = r0[r1]
            if (r2 != 0) goto L_0x0030
            r2 = 1
            r3 = r0[r2]
            if (r3 != 0) goto L_0x001f
            com.lowagie.text.pdf.PdfWriter r3 = r4.writer
            com.lowagie.text.pdf.PdfIndirectReference r3 = r3.getPdfIndirectReference()
            r0[r2] = r3
        L_0x001f:
            com.lowagie.text.pdf.PdfAction r3 = new com.lowagie.text.pdf.PdfAction
            r2 = r0[r2]
            com.lowagie.text.pdf.PdfIndirectReference r2 = (com.lowagie.text.pdf.PdfIndirectReference) r2
            r3.<init>((com.lowagie.text.pdf.PdfIndirectReference) r2)
            r0[r1] = r3
            java.util.TreeMap r1 = r4.localDestinations
            r1.put(r5, r0)
            goto L_0x0035
        L_0x0030:
            r5 = r0[r1]
            r3 = r5
            com.lowagie.text.pdf.PdfAction r3 = (com.lowagie.text.pdf.PdfAction) r3
        L_0x0035:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfDocument.getLocalGotoAction(java.lang.String):com.lowagie.text.pdf.PdfAction");
    }

    /* access modifiers changed from: package-private */
    public boolean localDestination(String str, PdfDestination pdfDestination) {
        Object[] objArr = (Object[]) this.localDestinations.get(str);
        if (objArr == null) {
            objArr = new Object[3];
        }
        if (objArr[2] != null) {
            return false;
        }
        objArr[2] = pdfDestination;
        this.localDestinations.put(str, objArr);
        pdfDestination.addPage(this.writer.getCurrentPage());
        return true;
    }

    /* access modifiers changed from: package-private */
    public void addJavaScript(PdfAction pdfAction) {
        if (pdfAction.get(PdfName.f690JS) != null) {
            try {
                HashMap hashMap = this.documentLevelJS;
                DecimalFormat decimalFormat = SIXTEEN_DIGITS;
                int i = this.jsCounter;
                this.jsCounter = i + 1;
                hashMap.put(decimalFormat.format((long) i), this.writer.addToBody(pdfAction).getIndirectReference());
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            throw new RuntimeException("Only JavaScript actions are allowed.");
        }
    }

    /* access modifiers changed from: package-private */
    public void addJavaScript(String str, PdfAction pdfAction) {
        if (pdfAction.get(PdfName.f690JS) != null) {
            try {
                this.documentLevelJS.put(str, this.writer.addToBody(pdfAction).getIndirectReference());
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            throw new RuntimeException("Only JavaScript actions are allowed.");
        }
    }

    /* access modifiers changed from: package-private */
    public HashMap getDocumentLevelJS() {
        return this.documentLevelJS;
    }

    /* access modifiers changed from: package-private */
    public void addFileAttachment(String str, PdfFileSpecification pdfFileSpecification) throws IOException {
        if (str == null) {
            PdfString pdfString = (PdfString) pdfFileSpecification.get(PdfName.DESC);
            if (pdfString == null) {
                str = "";
            } else {
                str = PdfEncodings.convertToString(pdfString.getBytes(), (String) null);
            }
        }
        pdfFileSpecification.addDescription(str, true);
        if (str.length() == 0) {
            str = "Unnamed";
        }
        String convertToString = PdfEncodings.convertToString(new PdfString(str, PdfObject.TEXT_UNICODE).getBytes(), (String) null);
        int i = 0;
        while (this.documentFileAttachment.containsKey(convertToString)) {
            i++;
            convertToString = PdfEncodings.convertToString(new PdfString(String.valueOf(str) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + i, PdfObject.TEXT_UNICODE).getBytes(), (String) null);
        }
        this.documentFileAttachment.put(convertToString, pdfFileSpecification.getReference());
    }

    /* access modifiers changed from: package-private */
    public HashMap getDocumentFileAttachment() {
        return this.documentFileAttachment;
    }

    /* access modifiers changed from: package-private */
    public void setOpenAction(String str) {
        this.openActionName = str;
        this.openActionAction = null;
    }

    /* access modifiers changed from: package-private */
    public void setOpenAction(PdfAction pdfAction) {
        this.openActionAction = pdfAction;
        this.openActionName = null;
    }

    /* access modifiers changed from: package-private */
    public void addAdditionalAction(PdfName pdfName, PdfAction pdfAction) {
        if (this.additionalActions == null) {
            this.additionalActions = new PdfDictionary();
        }
        if (pdfAction == null) {
            this.additionalActions.remove(pdfName);
        } else {
            this.additionalActions.put(pdfName, pdfAction);
        }
        if (this.additionalActions.size() == 0) {
            this.additionalActions = null;
        }
    }

    public void setCollection(PdfCollection pdfCollection) {
        this.collection = pdfCollection;
    }

    /* access modifiers changed from: package-private */
    public PdfAcroForm getAcroForm() {
        return this.annotationsImp.getAcroForm();
    }

    /* access modifiers changed from: package-private */
    public void setSigFlags(int i) {
        this.annotationsImp.setSigFlags(i);
    }

    /* access modifiers changed from: package-private */
    public void addCalculationOrder(PdfFormField pdfFormField) {
        this.annotationsImp.addCalculationOrder(pdfFormField);
    }

    /* access modifiers changed from: package-private */
    public void addAnnotation(PdfAnnotation pdfAnnotation) {
        this.pageEmpty = false;
        this.annotationsImp.addAnnotation(pdfAnnotation);
    }

    /* access modifiers changed from: package-private */
    public int getMarkPoint() {
        return this.markPoint;
    }

    /* access modifiers changed from: package-private */
    public void incMarkPoint() {
        this.markPoint++;
    }

    /* access modifiers changed from: package-private */
    public void setCropBoxSize(Rectangle rectangle) {
        setBoxSize("crop", rectangle);
    }

    /* access modifiers changed from: package-private */
    public void setBoxSize(String str, Rectangle rectangle) {
        if (rectangle == null) {
            this.boxSize.remove(str);
        } else {
            this.boxSize.put(str, new PdfRectangle(rectangle));
        }
    }

    /* access modifiers changed from: protected */
    public void setNewPageSizeAndMargins() {
        this.pageSize = this.nextPageSize;
        if (!this.marginMirroring || (getPageNumber() & 1) != 0) {
            this.marginLeft = this.nextMarginLeft;
            this.marginRight = this.nextMarginRight;
        } else {
            this.marginRight = this.nextMarginLeft;
            this.marginLeft = this.nextMarginRight;
        }
        if (!this.marginMirroringTopBottom || (getPageNumber() & 1) != 0) {
            this.marginTop = this.nextMarginTop;
            this.marginBottom = this.nextMarginBottom;
            return;
        }
        this.marginTop = this.nextMarginBottom;
        this.marginBottom = this.nextMarginTop;
    }

    /* access modifiers changed from: package-private */
    public Rectangle getBoxSize(String str) {
        PdfRectangle pdfRectangle = (PdfRectangle) this.thisBoxSize.get(str);
        if (pdfRectangle != null) {
            return pdfRectangle.getRectangle();
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void setPageEmpty(boolean z) {
        this.pageEmpty = z;
    }

    /* access modifiers changed from: package-private */
    public void setDuration(int i) {
        if (i > 0) {
            this.duration = i;
        } else {
            this.duration = -1;
        }
    }

    /* access modifiers changed from: package-private */
    public void setTransition(PdfTransition pdfTransition) {
        this.transition = pdfTransition;
    }

    /* access modifiers changed from: package-private */
    public void setPageAction(PdfName pdfName, PdfAction pdfAction) {
        if (this.pageAA == null) {
            this.pageAA = new PdfDictionary();
        }
        this.pageAA.put(pdfName, pdfAction);
    }

    /* access modifiers changed from: package-private */
    public void setThumbnail(Image image) throws PdfException, DocumentException {
        PdfWriter pdfWriter = this.writer;
        this.thumb = pdfWriter.getImageReference(pdfWriter.addDirectImageSimple(image));
    }

    /* access modifiers changed from: package-private */
    public PageResources getPageResources() {
        return this.pageResources;
    }

    /* access modifiers changed from: package-private */
    public boolean isStrictImageSequence() {
        return this.strictImageSequence;
    }

    /* access modifiers changed from: package-private */
    public void setStrictImageSequence(boolean z) {
        this.strictImageSequence = z;
    }

    public void clearTextWrap() {
        float f = this.imageEnd - this.currentHeight;
        PdfLine pdfLine = this.line;
        if (pdfLine != null) {
            f += pdfLine.height();
        }
        if (this.imageEnd > -1.0f && f > 0.0f) {
            carriageReturn();
            this.currentHeight += f;
        }
    }

    /* access modifiers changed from: protected */
    public void add(Image image) throws PdfException, DocumentException {
        float f;
        Image image2 = image;
        if (image.hasAbsoluteY()) {
            this.graphics.addImage(image2);
            this.pageEmpty = false;
            return;
        }
        if (this.currentHeight != 0.0f && (indentTop() - this.currentHeight) - image.getScaledHeight() < indentBottom()) {
            if (this.strictImageSequence || this.imageWait != null) {
                newPage();
                if (this.currentHeight != 0.0f && (indentTop() - this.currentHeight) - image.getScaledHeight() < indentBottom()) {
                    this.imageWait = image2;
                    return;
                }
            } else {
                this.imageWait = image2;
                return;
            }
        }
        this.pageEmpty = false;
        if (image2 == this.imageWait) {
            this.imageWait = null;
        }
        boolean z = (image.getAlignment() & 4) == 4 && (image.getAlignment() & 1) != 1;
        boolean z2 = (image.getAlignment() & 8) == 8;
        float f2 = this.leading;
        float f3 = f2 / 2.0f;
        if (z) {
            f3 += f2;
        }
        float f4 = f3;
        float indentTop = ((indentTop() - this.currentHeight) - image.getScaledHeight()) - f4;
        float[] matrix = image.matrix();
        float indentLeft = indentLeft() - matrix[4];
        if ((image.getAlignment() & 2) == 2) {
            indentLeft = (indentRight() - image.getScaledWidth()) - matrix[4];
        }
        if ((image.getAlignment() & 1) == 1) {
            indentLeft = (indentLeft() + (((indentRight() - indentLeft()) - image.getScaledWidth()) / 2.0f)) - matrix[4];
        }
        if (image.hasAbsoluteX()) {
            indentLeft = image.getAbsoluteX();
        }
        if (z) {
            float f5 = this.imageEnd;
            if (f5 < 0.0f || f5 < this.currentHeight + image.getScaledHeight() + f4) {
                this.imageEnd = this.currentHeight + image.getScaledHeight() + f4;
            }
            if ((image.getAlignment() & 2) == 2) {
                this.indentation.imageIndentRight += image.getScaledWidth() + image.getIndentationLeft();
            } else {
                this.indentation.imageIndentLeft += image.getScaledWidth() + image.getIndentationRight();
            }
        } else if ((image.getAlignment() & 2) == 2) {
            indentLeft -= image.getIndentationRight();
        } else {
            if ((image.getAlignment() & 1) == 1) {
                f = image.getIndentationLeft() - image.getIndentationRight();
            } else {
                f = image.getIndentationLeft();
            }
            indentLeft += f;
        }
        this.graphics.addImage(image, matrix[0], matrix[1], matrix[2], matrix[3], indentLeft, indentTop - matrix[5]);
        if (!z && !z2) {
            this.currentHeight += image.getScaledHeight() + f4;
            flushLines();
            this.text.moveText(0.0f, -(image.getScaledHeight() + f4));
            newLine();
        }
    }

    /* access modifiers changed from: package-private */
    public void addPTable(PdfPTable pdfPTable) throws DocumentException {
        ColumnText columnText = new ColumnText(this.writer.getDirectContent());
        if (pdfPTable.getKeepTogether() && !fitsPage(pdfPTable, 0.0f) && this.currentHeight > 0.0f) {
            newPage();
        }
        if (this.currentHeight > 0.0f) {
            Paragraph paragraph = new Paragraph();
            paragraph.setLeading(0.0f);
            columnText.addElement(paragraph);
        }
        columnText.addElement(pdfPTable);
        boolean isHeadersInEvent = pdfPTable.isHeadersInEvent();
        pdfPTable.setHeadersInEvent(true);
        int i = 0;
        while (true) {
            columnText.setSimpleColumn(indentLeft(), indentBottom(), indentRight(), indentTop() - this.currentHeight);
            if ((columnText.mo52494go() & 1) != 0) {
                this.text.moveText(0.0f, (columnText.getYLine() - indentTop()) + this.currentHeight);
                this.currentHeight = indentTop() - columnText.getYLine();
                break;
            }
            i = indentTop() - this.currentHeight == columnText.getYLine() ? i + 1 : 0;
            if (i == 3) {
                add((Element) new Paragraph("ERROR: Infinite table loop"));
                break;
            }
            newPage();
        }
        pdfPTable.setHeadersInEvent(isHeadersInEvent);
    }

    /* access modifiers changed from: package-private */
    public boolean fitsPage(PdfPTable pdfPTable, float f) {
        if (!pdfPTable.isLockedWidth()) {
            pdfPTable.setTotalWidth(((indentRight() - indentLeft()) * pdfPTable.getWidthPercentage()) / 100.0f);
        }
        ensureNewLine();
        float totalHeight = pdfPTable.getTotalHeight();
        float f2 = 0.0f;
        if (this.currentHeight > 0.0f) {
            f2 = pdfPTable.spacingBefore();
        }
        return totalHeight + f2 <= ((indentTop() - this.currentHeight) - indentBottom()) - f;
    }

    protected static class RenderingContext {
        PdfContentByte cellGraphics = null;
        float lostTableBottom;
        float maxCellBottom;
        float maxCellHeight;
        float oldHeight = -1.0f;
        Map pageMap = new HashMap();
        float pagetop = -1.0f;
        Map rowspanMap;
        public PdfTable table;

        protected RenderingContext() {
        }

        public int consumeRowspan(PdfCell pdfCell) {
            if (pdfCell.rowspan() == 1) {
                return 1;
            }
            Integer num = (Integer) this.rowspanMap.get(pdfCell);
            if (num == null) {
                num = new Integer(pdfCell.rowspan());
            }
            Integer num2 = new Integer(num.intValue() - 1);
            this.rowspanMap.put(pdfCell, num2);
            if (num2.intValue() < 1) {
                return 1;
            }
            return num2.intValue();
        }

        public int currentRowspan(PdfCell pdfCell) {
            Integer num = (Integer) this.rowspanMap.get(pdfCell);
            if (num == null) {
                return pdfCell.rowspan();
            }
            return num.intValue();
        }

        public int cellRendered(PdfCell pdfCell, int i) {
            Integer num;
            Integer num2 = (Integer) this.pageMap.get(pdfCell);
            if (num2 == null) {
                num = new Integer(1);
            } else {
                num = new Integer(num2.intValue() + 1);
            }
            this.pageMap.put(pdfCell, num);
            Integer num3 = new Integer(i);
            Set set = (Set) this.pageMap.get(num3);
            if (set == null) {
                set = new HashSet();
                this.pageMap.put(num3, set);
            }
            set.add(pdfCell);
            return num.intValue();
        }

        public int numCellRendered(PdfCell pdfCell) {
            Integer num = (Integer) this.pageMap.get(pdfCell);
            if (num == null) {
                num = new Integer(0);
            }
            return num.intValue();
        }

        public boolean isCellRenderedOnPage(PdfCell pdfCell, int i) {
            Set set = (Set) this.pageMap.get(new Integer(i));
            if (set != null) {
                return set.contains(pdfCell);
            }
            return false;
        }
    }

    private void addPdfTable(Table table) throws DocumentException {
        float f;
        boolean z;
        flushLines();
        PdfTable pdfTable = new PdfTable(table, indentLeft(), indentRight(), indentTop() - this.currentHeight);
        RenderingContext renderingContext = new RenderingContext();
        renderingContext.pagetop = indentTop();
        renderingContext.oldHeight = this.currentHeight;
        renderingContext.cellGraphics = new PdfContentByte(this.writer);
        renderingContext.rowspanMap = new HashMap();
        renderingContext.table = pdfTable;
        ArrayList headerCells = pdfTable.getHeaderCells();
        ArrayList cells = pdfTable.getCells();
        ArrayList extractRows = extractRows(cells, renderingContext);
        boolean z2 = false;
        boolean z3 = false;
        while (!cells.isEmpty()) {
            renderingContext.lostTableBottom = 0.0f;
            Iterator it = extractRows.iterator();
            boolean z4 = false;
            while (it.hasNext()) {
                ArrayList arrayList = (ArrayList) it.next();
                analyzeRow(extractRows, renderingContext);
                renderCells(renderingContext, arrayList, z4 & pdfTable.hasToFitPageCells());
                if (!mayBeRemoved(arrayList)) {
                    break;
                }
                consumeRowspan(arrayList, renderingContext);
                it.remove();
                z2 = false;
                z4 = true;
            }
            cells.clear();
            HashSet hashSet = new HashSet();
            Iterator it2 = extractRows.iterator();
            while (it2.hasNext()) {
                Iterator it3 = ((ArrayList) it2.next()).iterator();
                while (it3.hasNext()) {
                    PdfCell pdfCell = (PdfCell) it3.next();
                    if (!hashSet.contains(pdfCell)) {
                        cells.add(pdfCell);
                        hashSet.add(pdfCell);
                    }
                }
                z2 = false;
            }
            Rectangle rectangle = new Rectangle(pdfTable);
            rectangle.setBorder(pdfTable.getBorder());
            rectangle.setBorderWidth(pdfTable.getBorderWidth());
            rectangle.setBorderColor(pdfTable.getBorderColor());
            rectangle.setBackgroundColor(pdfTable.getBackgroundColor());
            PdfContentByte directContentUnder = this.writer.getDirectContentUnder();
            directContentUnder.rectangle(rectangle.rectangle(top(), indentBottom()));
            directContentUnder.add(renderingContext.cellGraphics);
            rectangle.setBackgroundColor((Color) null);
            Rectangle rectangle2 = rectangle.rectangle(top(), indentBottom());
            rectangle2.setBorder(pdfTable.getBorder());
            directContentUnder.rectangle(rectangle2);
            renderingContext.cellGraphics = new PdfContentByte((PdfWriter) null);
            if (!extractRows.isEmpty()) {
                this.graphics.setLineWidth(pdfTable.getBorderWidth());
                this.pageEmpty = z2;
                float f2 = renderingContext.lostTableBottom;
                newPage();
                float f3 = this.currentHeight;
                if (f3 > 0.0f) {
                    f = 6.0f;
                    this.currentHeight = f3 + 6.0f;
                    newLine();
                    flushLines();
                    this.indentation.indentTop = this.currentHeight - this.leading;
                    this.currentHeight = 0.0f;
                    z = true;
                } else {
                    flushLines();
                    z = false;
                    f = 0.0f;
                }
                int size = headerCells.size();
                if (size > 0) {
                    float top = ((PdfCell) headerCells.get(z2 ? 1 : 0)).getTop(0.0f);
                    for (int i = 0; i < size; i++) {
                        PdfCell pdfCell2 = (PdfCell) headerCells.get(i);
                        pdfCell2.setTop((indentTop() - top) + pdfCell2.getTop(0.0f));
                        pdfCell2.setBottom((indentTop() - top) + pdfCell2.getBottom(0.0f));
                        renderingContext.pagetop = pdfCell2.getBottom();
                        renderingContext.cellGraphics.rectangle(pdfCell2.rectangle(indentTop(), indentBottom()));
                        Iterator it4 = pdfCell2.getImages(indentTop(), indentBottom()).iterator();
                        while (it4.hasNext()) {
                            this.graphics.addImage((Image) it4.next());
                        }
                        this.lines = pdfCell2.getLines(indentTop(), indentBottom());
                        float top2 = pdfCell2.getTop(indentTop());
                        this.text.moveText(0.0f, top2 - f);
                        this.text.moveText(0.0f, (flushLines() - top2) + f);
                    }
                    this.currentHeight = (indentTop() - renderingContext.pagetop) + pdfTable.cellspacing();
                    this.text.moveText(0.0f, (renderingContext.pagetop - indentTop()) - this.currentHeight);
                } else if (z) {
                    renderingContext.pagetop = indentTop();
                    this.text.moveText(0.0f, -pdfTable.cellspacing());
                }
                renderingContext.oldHeight = this.currentHeight - f;
                int min = Math.min(cells.size(), pdfTable.columns());
                for (int i2 = 0; i2 < min; i2++) {
                    PdfCell pdfCell3 = (PdfCell) cells.get(i2);
                    if (pdfCell3.getTop(-pdfTable.cellspacing()) > renderingContext.lostTableBottom) {
                        float bottom = (renderingContext.pagetop - f2) + pdfCell3.getBottom();
                        float remainingHeight = pdfCell3.remainingHeight();
                        if (bottom > renderingContext.pagetop - remainingHeight) {
                            f2 += bottom - (renderingContext.pagetop - remainingHeight);
                        }
                    }
                }
                int size2 = cells.size();
                pdfTable.setTop(indentTop());
                pdfTable.setBottom((renderingContext.pagetop - f2) + pdfTable.getBottom(pdfTable.cellspacing()));
                for (int i3 = 0; i3 < size2; i3++) {
                    PdfCell pdfCell4 = (PdfCell) cells.get(i3);
                    float bottom2 = (renderingContext.pagetop - f2) + pdfCell4.getBottom();
                    float top3 = (renderingContext.pagetop - f2) + pdfCell4.getTop(-pdfTable.cellspacing());
                    if (top3 > indentTop() - this.currentHeight) {
                        top3 = indentTop() - this.currentHeight;
                    }
                    pdfCell4.setTop(top3);
                    pdfCell4.setBottom(bottom2);
                }
                z2 = false;
                z3 = true;
            }
        }
        float top4 = pdfTable.getTop() - pdfTable.getBottom();
        if (z3) {
            this.currentHeight = top4;
            this.text.moveText(0.0f, -(top4 - (renderingContext.oldHeight * 2.0f)));
        } else {
            this.currentHeight = renderingContext.oldHeight + top4;
            this.text.moveText(0.0f, -top4);
        }
        this.pageEmpty = z2;
    }

    /* access modifiers changed from: protected */
    public void analyzeRow(ArrayList arrayList, RenderingContext renderingContext) {
        renderingContext.maxCellBottom = indentBottom();
        boolean z = false;
        Iterator it = ((ArrayList) arrayList.get(0)).iterator();
        int i = 1;
        while (it.hasNext()) {
            i = Math.max(renderingContext.currentRowspan((PdfCell) it.next()), i);
        }
        int i2 = i + 0;
        if (i2 == arrayList.size()) {
            i2 = arrayList.size() - 1;
        } else {
            z = true;
        }
        if (i2 >= 0 && i2 < arrayList.size()) {
            Iterator it2 = ((ArrayList) arrayList.get(i2)).iterator();
            while (it2.hasNext()) {
                PdfCell pdfCell = (PdfCell) it2.next();
                Rectangle rectangle = pdfCell.rectangle(renderingContext.pagetop, indentBottom());
                if (z) {
                    renderingContext.maxCellBottom = Math.max(renderingContext.maxCellBottom, rectangle.getTop());
                } else if (renderingContext.currentRowspan(pdfCell) == 1) {
                    renderingContext.maxCellBottom = Math.max(renderingContext.maxCellBottom, rectangle.getBottom());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean mayBeRemoved(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            z &= ((PdfCell) it.next()).mayBeRemoved();
        }
        return z;
    }

    /* access modifiers changed from: protected */
    public void consumeRowspan(ArrayList arrayList, RenderingContext renderingContext) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            renderingContext.consumeRowspan((PdfCell) it.next());
        }
    }

    /* access modifiers changed from: protected */
    public ArrayList extractRows(ArrayList arrayList, RenderingContext renderingContext) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        PdfCell pdfCell = null;
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            PdfCell pdfCell2 = (PdfCell) it.next();
            boolean z2 = !it.hasNext();
            boolean z3 = !it.hasNext();
            if (pdfCell != null && pdfCell2.getLeft() <= pdfCell.getLeft()) {
                z2 = true;
                z3 = false;
            }
            if (z3) {
                arrayList3.add(pdfCell2);
                z = true;
            }
            if (z2) {
                if (!arrayList3.isEmpty()) {
                    arrayList2.add(arrayList3);
                }
                arrayList3 = new ArrayList();
            }
            if (!z) {
                arrayList3.add(pdfCell2);
            }
            pdfCell = pdfCell2;
        }
        if (!arrayList3.isEmpty()) {
            arrayList2.add(arrayList3);
        }
        for (int size = arrayList2.size() - 1; size >= 0; size--) {
            ArrayList arrayList4 = (ArrayList) arrayList2.get(size);
            for (int i = 0; i < arrayList4.size(); i++) {
                PdfCell pdfCell3 = (PdfCell) arrayList4.get(i);
                int rowspan = pdfCell3.rowspan();
                for (int i2 = 1; i2 < rowspan; i2++) {
                    int i3 = size + i2;
                    if (arrayList2.size() >= i3) {
                        break;
                    }
                    ArrayList arrayList5 = (ArrayList) arrayList2.get(i3);
                    if (arrayList5.size() > i) {
                        arrayList5.add(i, pdfCell3);
                    }
                }
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: protected */
    public void renderCells(RenderingContext renderingContext, java.util.List list, boolean z) throws DocumentException {
        if (z) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                PdfCell pdfCell = (PdfCell) it.next();
                if (!pdfCell.isHeader() && pdfCell.getBottom() < indentBottom()) {
                    return;
                }
            }
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            PdfCell pdfCell2 = (PdfCell) it2.next();
            if (!renderingContext.isCellRenderedOnPage(pdfCell2, getPageNumber())) {
                this.lines = pdfCell2.getLines(renderingContext.pagetop, indentBottom() - (renderingContext.numCellRendered(pdfCell2) >= 1 ? 1.0f : 0.0f));
                ArrayList arrayList = this.lines;
                if (arrayList != null && !arrayList.isEmpty()) {
                    float top = pdfCell2.getTop(renderingContext.pagetop - renderingContext.oldHeight);
                    this.text.moveText(0.0f, top);
                    float flushLines = flushLines() - top;
                    this.text.moveText(0.0f, flushLines);
                    if (renderingContext.oldHeight + flushLines > this.currentHeight) {
                        this.currentHeight = renderingContext.oldHeight + flushLines;
                    }
                    renderingContext.cellRendered(pdfCell2, getPageNumber());
                }
                float max = Math.max(pdfCell2.getBottom(), indentBottom());
                Rectangle rectangle = renderingContext.table.rectangle(renderingContext.pagetop, indentBottom());
                float max2 = Math.max(rectangle.getBottom(), max);
                Rectangle rectangle2 = pdfCell2.rectangle(rectangle.getTop(), max2);
                if (rectangle2.getHeight() > 0.0f) {
                    renderingContext.lostTableBottom = max2;
                    renderingContext.cellGraphics.rectangle(rectangle2);
                }
                Iterator it3 = pdfCell2.getImages(renderingContext.pagetop, indentBottom()).iterator();
                while (it3.hasNext()) {
                    this.graphics.addImage((Image) it3.next());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public float bottom(Table table) {
        return new PdfTable(table, indentLeft(), indentRight(), indentTop() - this.currentHeight).getBottom();
    }

    /* access modifiers changed from: protected */
    public void doFooter() throws DocumentException {
        if (this.footer != null) {
            float f = this.indentation.indentLeft;
            float f2 = this.indentation.indentRight;
            float f3 = this.indentation.listIndentLeft;
            float f4 = this.indentation.imageIndentLeft;
            float f5 = this.indentation.imageIndentRight;
            Indentation indentation2 = this.indentation;
            indentation2.indentRight = 0.0f;
            indentation2.indentLeft = 0.0f;
            indentation2.listIndentLeft = 0.0f;
            indentation2.imageIndentLeft = 0.0f;
            indentation2.imageIndentRight = 0.0f;
            this.footer.setPageNumber(this.pageN);
            this.leading = this.footer.paragraph().getTotalLeading();
            add((Element) this.footer.paragraph());
            this.indentation.indentBottom = this.currentHeight;
            this.text.moveText(left(), indentBottom());
            flushLines();
            this.text.moveText(-left(), -bottom());
            this.footer.setTop(bottom(this.currentHeight));
            this.footer.setBottom(bottom() - (this.leading * 0.75f));
            this.footer.setLeft(left());
            this.footer.setRight(right());
            this.graphics.rectangle(this.footer);
            Indentation indentation3 = this.indentation;
            indentation3.indentBottom = this.currentHeight + (this.leading * 2.0f);
            this.currentHeight = 0.0f;
            indentation3.indentLeft = f;
            indentation3.indentRight = f2;
            indentation3.listIndentLeft = f3;
            indentation3.imageIndentLeft = f4;
            indentation3.imageIndentRight = f5;
        }
    }

    /* access modifiers changed from: protected */
    public void doHeader() throws DocumentException {
        if (this.header != null) {
            float f = this.indentation.indentLeft;
            float f2 = this.indentation.indentRight;
            float f3 = this.indentation.listIndentLeft;
            float f4 = this.indentation.imageIndentLeft;
            float f5 = this.indentation.imageIndentRight;
            Indentation indentation2 = this.indentation;
            indentation2.indentRight = 0.0f;
            indentation2.indentLeft = 0.0f;
            indentation2.listIndentLeft = 0.0f;
            indentation2.imageIndentLeft = 0.0f;
            indentation2.imageIndentRight = 0.0f;
            this.header.setPageNumber(this.pageN);
            this.leading = this.header.paragraph().getTotalLeading();
            this.text.moveText(0.0f, this.leading);
            add((Element) this.header.paragraph());
            newLine();
            this.indentation.indentTop = this.currentHeight - this.leading;
            this.header.setTop(top() + this.leading);
            this.header.setBottom(indentTop() + ((this.leading * 2.0f) / 3.0f));
            this.header.setLeft(left());
            this.header.setRight(right());
            this.graphics.rectangle(this.header);
            flushLines();
            this.currentHeight = 0.0f;
            Indentation indentation3 = this.indentation;
            indentation3.indentLeft = f;
            indentation3.indentRight = f2;
            indentation3.listIndentLeft = f3;
            indentation3.imageIndentLeft = f4;
            indentation3.imageIndentRight = f5;
        }
    }
}
