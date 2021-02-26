package android.print;

import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PrintDocumentAdapter;
import android.util.Log;
import java.io.File;

public class PdfPrint {
    private static final String TAG = "PdfPrint";
    /* access modifiers changed from: private */
    public OnPDFWriteComplete onPDFWriteComplete;
    private final PrintAttributes printAttributes;

    public interface OnPDFWriteComplete {
        void onPDFCreationDone();
    }

    public PdfPrint(PrintAttributes printAttributes2, OnPDFWriteComplete onPDFWriteComplete2) {
        this.printAttributes = printAttributes2;
        this.onPDFWriteComplete = onPDFWriteComplete2;
    }

    public void print(final PrintDocumentAdapter printDocumentAdapter, final File file, final String str) {
        printDocumentAdapter.onLayout((PrintAttributes) null, this.printAttributes, (CancellationSignal) null, new PrintDocumentAdapter.LayoutResultCallback() {
            public void onLayoutFinished(PrintDocumentInfo printDocumentInfo, boolean z) {
                printDocumentAdapter.onWrite(new PageRange[]{PageRange.ALL_PAGES}, PdfPrint.this.getOutputFile(file, str), new CancellationSignal(), new PrintDocumentAdapter.WriteResultCallback() {
                    public void onWriteFinished(PageRange[] pageRangeArr) {
                        super.onWriteFinished(pageRangeArr);
                        PdfPrint.this.onPDFWriteComplete.onPDFCreationDone();
                    }
                });
            }
        }, (Bundle) null);
    }

    /* access modifiers changed from: private */
    public ParcelFileDescriptor getOutputFile(File file, String str) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        try {
            file2.createNewFile();
            return ParcelFileDescriptor.open(file2, 805306368);
        } catch (Exception e) {
            Log.e(TAG, "Failed to open ParcelFileDescriptor", e);
            return null;
        }
    }
}
