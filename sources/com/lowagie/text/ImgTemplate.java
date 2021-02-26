package com.lowagie.text;

import com.lowagie.text.pdf.PdfTemplate;
import java.net.URL;

public class ImgTemplate extends Image {
    ImgTemplate(Image image) {
        super(image);
    }

    public ImgTemplate(PdfTemplate pdfTemplate) throws BadElementException {
        super((URL) null);
        if (pdfTemplate == null) {
            throw new BadElementException("The template can not be null.");
        } else if (pdfTemplate.getType() != 3) {
            this.type = 35;
            this.scaledHeight = pdfTemplate.getHeight();
            setTop(this.scaledHeight);
            this.scaledWidth = pdfTemplate.getWidth();
            setRight(this.scaledWidth);
            setTemplateData(pdfTemplate);
            this.plainWidth = getWidth();
            this.plainHeight = getHeight();
        } else {
            throw new BadElementException("A pattern can not be used as a template to create an image.");
        }
    }
}
