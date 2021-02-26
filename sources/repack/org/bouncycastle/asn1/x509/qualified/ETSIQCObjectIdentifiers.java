package repack.org.bouncycastle.asn1.x509.qualified;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;

public interface ETSIQCObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_etsi_qcs = new ASN1ObjectIdentifier("0.4.0.1862.1");
    public static final ASN1ObjectIdentifier id_etsi_qcs_LimiteValue = id_etsi_qcs.branch(ExifInterface.GPS_MEASUREMENT_2D);
    public static final ASN1ObjectIdentifier id_etsi_qcs_QcCompliance = id_etsi_qcs.branch(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
    public static final ASN1ObjectIdentifier id_etsi_qcs_QcSSCD = id_etsi_qcs.branch("4");
    public static final ASN1ObjectIdentifier id_etsi_qcs_RetentionPeriod = id_etsi_qcs.branch(ExifInterface.GPS_MEASUREMENT_3D);
}
