package repack.org.bouncycastle.asn1.x509.qualified;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface RFC3739QCObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_qcs = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.11");
    public static final ASN1ObjectIdentifier id_qcs_pkixQCSyntax_v1 = id_qcs.branch(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
    public static final ASN1ObjectIdentifier id_qcs_pkixQCSyntax_v2 = id_qcs.branch(ExifInterface.GPS_MEASUREMENT_2D);
}
