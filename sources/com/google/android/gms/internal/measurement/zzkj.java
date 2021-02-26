package com.google.android.gms.internal.measurement;

import com.lowagie.text.pdf.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
final class zzkj {
    static String zza(zzgm zzgm) {
        zzkm zzkm = new zzkm(zzgm);
        StringBuilder sb = new StringBuilder(zzkm.zza());
        for (int i = 0; i < zzkm.zza(); i++) {
            byte zza = zzkm.zza(i);
            if (zza == 34) {
                sb.append("\\\"");
            } else if (zza == 39) {
                sb.append("\\'");
            } else if (zza != 92) {
                switch (zza) {
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
                        if (zza >= 32 && zza <= 126) {
                            sb.append((char) zza);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((zza >>> 6) & 3) + 48));
                            sb.append((char) (((zza >>> 3) & 7) + 48));
                            sb.append((char) ((zza & 7) + ByteBuffer.ZERO));
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
