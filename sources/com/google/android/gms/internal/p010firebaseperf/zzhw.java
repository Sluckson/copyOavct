package com.google.android.gms.internal.p010firebaseperf;

import com.lowagie.text.pdf.ByteBuffer;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhw */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzhw {
    static String zzd(zzee zzee) {
        zzhv zzhv = new zzhv(zzee);
        StringBuilder sb = new StringBuilder(zzhv.size());
        for (int i = 0; i < zzhv.size(); i++) {
            byte zzq = zzhv.zzq(i);
            if (zzq == 34) {
                sb.append("\\\"");
            } else if (zzq == 39) {
                sb.append("\\'");
            } else if (zzq != 92) {
                switch (zzq) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (zzq >= 32 && zzq <= 126) {
                            sb.append((char) zzq);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((zzq >>> 6) & 3) + 48));
                            sb.append((char) (((zzq >>> 3) & 7) + 48));
                            sb.append((char) ((zzq & 7) + ByteBuffer.ZERO));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
