package com.lowagie.tools;

import com.lowagie.text.pdf.PdfEncryptor;
import com.lowagie.text.pdf.PdfReader;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;

public class EncryptPdf {
    private static final int INPUT_FILE = 0;
    private static final int MOREINFO = 6;
    private static final int OUTPUT_FILE = 1;
    private static final int OWNER_PASSWORD = 3;
    private static final int PERMISSIONS = 4;
    private static final int STRENGTH = 5;
    private static final int USER_PASSWORD = 2;
    private static final int[] permit = {2052, 8, 16, 32, 256, 512, 1024, 4};

    private static void usage() {
        System.out.println("usage: input_file output_file user_password owner_password permissions 128|40 [new info string pairs]");
        System.out.println("permissions is 8 digit long 0 or 1. Each digit has a particular security function:");
        System.out.println();
        System.out.println("AllowPrinting");
        System.out.println("AllowModifyContents");
        System.out.println("AllowCopy");
        System.out.println("AllowModifyAnnotations");
        System.out.println("AllowFillIn (128 bit only)");
        System.out.println("AllowScreenReaders (128 bit only)");
        System.out.println("AllowAssembly (128 bit only)");
        System.out.println("AllowDegradedPrinting (128 bit only)");
        System.out.println("Example permissions to copy and print would be: 10100000");
    }

    public static void main(String[] strArr) {
        System.out.println("PDF document encryptor");
        if (strArr.length <= 5 || strArr[4].length() != 8) {
            usage();
            return;
        }
        try {
            String str = strArr[4];
            int i = 0;
            for (int i2 = 0; i2 < str.length(); i2++) {
                i |= str.charAt(i2) == '0' ? 0 : permit[i2];
            }
            PrintStream printStream = System.out;
            printStream.println("Reading " + strArr[0]);
            PdfReader pdfReader = new PdfReader(strArr[0]);
            PrintStream printStream2 = System.out;
            printStream2.println("Writing " + strArr[1]);
            HashMap hashMap = new HashMap();
            for (int i3 = 6; i3 < strArr.length - 1; i3 += 2) {
                hashMap.put(strArr[i3], strArr[i3 + 1]);
            }
            PdfEncryptor.encrypt(pdfReader, (OutputStream) new FileOutputStream(strArr[1]), strArr[2].getBytes(), strArr[3].getBytes(), i, strArr[5].equals("128"), hashMap);
            System.out.println("Done.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
