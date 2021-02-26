package com.lowagie.text.pdf;

import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.lowagie.text.ExceptionConverter;
import harmony.java.awt.Font;
import java.io.File;
import java.util.HashMap;

public class DefaultFontMapper implements FontMapper {
    private HashMap aliases = new HashMap();
    private HashMap mapper = new HashMap();

    public static class BaseFontParameters {
        public boolean cached = true;
        public boolean embedded = true;
        public String encoding = "Cp1252";
        public String fontName;
        public byte[] pfb;
        public byte[] ttfAfm;

        public BaseFontParameters(String str) {
            this.fontName = str;
        }
    }

    public BaseFont awtToPdf(Font font) {
        try {
            BaseFontParameters baseFontParameters = getBaseFontParameters(font.getFontName());
            if (baseFontParameters != null) {
                return BaseFont.createFont(baseFontParameters.fontName, baseFontParameters.encoding, baseFontParameters.embedded, baseFontParameters.cached, baseFontParameters.ttfAfm, baseFontParameters.pfb);
            }
            String name = font.getName();
            String str = "Courier";
            if (!name.equalsIgnoreCase("DialogInput")) {
                if (!name.equalsIgnoreCase("Monospaced")) {
                    if (!name.equalsIgnoreCase(str)) {
                        if (!name.equalsIgnoreCase("Serif")) {
                            if (!name.equalsIgnoreCase("TimesRoman")) {
                                str = font.isItalic() ? font.isBold() ? "Helvetica-BoldOblique" : "Helvetica-Oblique" : font.isBold() ? "Helvetica-Bold" : "Helvetica";
                                return BaseFont.createFont(str, "Cp1252", false);
                            }
                        }
                        str = font.isItalic() ? font.isBold() ? "Times-BoldItalic" : "Times-Italic" : font.isBold() ? "Times-Bold" : "Times-Roman";
                        return BaseFont.createFont(str, "Cp1252", false);
                    }
                }
            }
            if (font.isItalic()) {
                str = font.isBold() ? "Courier-BoldOblique" : "Courier-Oblique";
            } else if (font.isBold()) {
                str = "Courier-Bold";
            }
            return BaseFont.createFont(str, "Cp1252", false);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public Font pdfToAwt(BaseFont baseFont, int i) {
        String[][] fullFontName = baseFont.getFullFontName();
        if (fullFontName.length == 1) {
            return new Font(fullFontName[0][3], 0, i);
        }
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (true) {
            if (i2 >= fullFontName.length) {
                break;
            }
            String[] strArr = fullFontName[i2];
            if (strArr[0].equals(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE) && strArr[1].equals("0")) {
                str2 = strArr[3];
            } else if (strArr[2].equals("1033")) {
                str = strArr[3];
                break;
            }
            i2++;
        }
        if (str == null) {
            str = str2;
        }
        if (str == null) {
            str = fullFontName[0][3];
        }
        return new Font(str, 0, i);
    }

    public void putName(String str, BaseFontParameters baseFontParameters) {
        this.mapper.put(str, baseFontParameters);
    }

    public void putAlias(String str, String str2) {
        this.aliases.put(str, str2);
    }

    public BaseFontParameters getBaseFontParameters(String str) {
        String str2 = (String) this.aliases.get(str);
        if (str2 == null) {
            return (BaseFontParameters) this.mapper.get(str);
        }
        BaseFontParameters baseFontParameters = (BaseFontParameters) this.mapper.get(str2);
        return baseFontParameters == null ? (BaseFontParameters) this.mapper.get(str) : baseFontParameters;
    }

    public void insertNames(Object[] objArr, String str) {
        String str2;
        String[][] strArr = objArr[2];
        int i = 0;
        while (true) {
            if (i >= strArr.length) {
                str2 = null;
                break;
            }
            String[] strArr2 = strArr[i];
            if (strArr2[2].equals("1033")) {
                str2 = strArr2[3];
                break;
            }
            i++;
        }
        if (str2 == null) {
            str2 = strArr[0][3];
        }
        String str3 = str2;
        this.mapper.put(str3, new BaseFontParameters(str));
        for (String[] strArr3 : strArr) {
            this.aliases.put(strArr3[3], str3);
        }
        this.aliases.put(objArr[0], str3);
    }

    public int insertDirectory(String str) {
        File[] listFiles;
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return 0;
        }
        int i = 0;
        for (File file2 : listFiles) {
            String lowerCase = file2.getPath().toLowerCase();
            try {
                if (!lowerCase.endsWith(".ttf")) {
                    if (!lowerCase.endsWith(".otf")) {
                        if (!lowerCase.endsWith(".afm")) {
                            if (lowerCase.endsWith(".ttc")) {
                                String[] enumerateTTCNames = BaseFont.enumerateTTCNames(file2.getPath());
                                for (int i2 = 0; i2 < enumerateTTCNames.length; i2++) {
                                    String str2 = String.valueOf(file2.getPath()) + "," + i2;
                                    insertNames(BaseFont.getAllFontNames(str2, "Cp1252", (byte[]) null), str2);
                                }
                                i++;
                            }
                        }
                    }
                }
                insertNames(BaseFont.getAllFontNames(file2.getPath(), "Cp1252", (byte[]) null), file2.getPath());
                i++;
            } catch (Exception unused) {
            }
        }
        return i;
    }

    public HashMap getMapper() {
        return this.mapper;
    }

    public HashMap getAliases() {
        return this.aliases;
    }
}
