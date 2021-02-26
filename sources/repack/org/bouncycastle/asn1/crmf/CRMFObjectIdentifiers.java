package repack.org.bouncycastle.asn1.crmf;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import repack.org.bouncycastle.asn1.ASN1ObjectIdentifier;
import repack.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;

public interface CRMFObjectIdentifiers {
    public static final ASN1ObjectIdentifier id_ct_encKeyWithID = new ASN1ObjectIdentifier(PKCSObjectIdentifiers.id_ct + ".21");
    public static final ASN1ObjectIdentifier id_pkip = id_pkix.branch("5");
    public static final ASN1ObjectIdentifier id_pkix = new ASN1ObjectIdentifier("1.3.6.1.5.5.7");
    public static final ASN1ObjectIdentifier id_regCtrl = id_pkip.branch(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
    public static final ASN1ObjectIdentifier id_regCtrl_authenticator = id_regCtrl.branch(ExifInterface.GPS_MEASUREMENT_2D);
    public static final ASN1ObjectIdentifier id_regCtrl_pkiArchiveOptions = id_regCtrl.branch("4");
    public static final ASN1ObjectIdentifier id_regCtrl_pkiPublicationInfo = id_regCtrl.branch(ExifInterface.GPS_MEASUREMENT_3D);
    public static final ASN1ObjectIdentifier id_regCtrl_regToken = id_regCtrl.branch(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE);
}
