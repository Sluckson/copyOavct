package repack.org.bouncycastle.asn1.icao;

import java.util.Enumeration;
import repack.org.bouncycastle.asn1.ASN1Encodable;
import repack.org.bouncycastle.asn1.ASN1EncodableVector;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERInteger;
import repack.org.bouncycastle.asn1.DERObject;
import repack.org.bouncycastle.asn1.DERSequence;
import repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public class LDSSecurityObject extends ASN1Encodable implements ICAOObjectIdentifiers {
    public static final int ub_DataGroups = 16;
    private DataGroupHash[] datagroupHash;
    private AlgorithmIdentifier digestAlgorithmIdentifier;
    private DERInteger version;
    private LDSVersionInfo versionInfo;

    public static LDSSecurityObject getInstance(Object obj) {
        if (obj instanceof LDSSecurityObject) {
            return (LDSSecurityObject) obj;
        }
        if (obj != null) {
            return new LDSSecurityObject(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private LDSSecurityObject(ASN1Sequence aSN1Sequence) {
        this.version = new DERInteger(0);
        if (aSN1Sequence == null || aSN1Sequence.size() == 0) {
            throw new IllegalArgumentException("null or empty sequence passed.");
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.version = DERInteger.getInstance(objects.nextElement());
        this.digestAlgorithmIdentifier = AlgorithmIdentifier.getInstance(objects.nextElement());
        ASN1Sequence instance = ASN1Sequence.getInstance(objects.nextElement());
        if (this.version.getValue().intValue() == 1) {
            this.versionInfo = LDSVersionInfo.getInstance(objects.nextElement());
        }
        checkDatagroupHashSeqSize(instance.size());
        this.datagroupHash = new DataGroupHash[instance.size()];
        for (int i = 0; i < instance.size(); i++) {
            this.datagroupHash[i] = DataGroupHash.getInstance(instance.getObjectAt(i));
        }
    }

    public LDSSecurityObject(AlgorithmIdentifier algorithmIdentifier, DataGroupHash[] dataGroupHashArr) {
        this.version = new DERInteger(0);
        this.version = new DERInteger(0);
        this.digestAlgorithmIdentifier = algorithmIdentifier;
        this.datagroupHash = dataGroupHashArr;
        checkDatagroupHashSeqSize(dataGroupHashArr.length);
    }

    public LDSSecurityObject(AlgorithmIdentifier algorithmIdentifier, DataGroupHash[] dataGroupHashArr, LDSVersionInfo lDSVersionInfo) {
        this.version = new DERInteger(0);
        this.version = new DERInteger(1);
        this.digestAlgorithmIdentifier = algorithmIdentifier;
        this.datagroupHash = dataGroupHashArr;
        this.versionInfo = lDSVersionInfo;
        checkDatagroupHashSeqSize(dataGroupHashArr.length);
    }

    private void checkDatagroupHashSeqSize(int i) {
        if (i < 2 || i > 16) {
            throw new IllegalArgumentException("wrong size in DataGroupHashValues : not in (2..16)");
        }
    }

    public int getVersion() {
        return this.version.getValue().intValue();
    }

    public AlgorithmIdentifier getDigestAlgorithmIdentifier() {
        return this.digestAlgorithmIdentifier;
    }

    public DataGroupHash[] getDatagroupHash() {
        return this.datagroupHash;
    }

    public LDSVersionInfo getVersionInfo() {
        return this.versionInfo;
    }

    public DERObject toASN1Object() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.version);
        aSN1EncodableVector.add(this.digestAlgorithmIdentifier);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        int i = 0;
        while (true) {
            DataGroupHash[] dataGroupHashArr = this.datagroupHash;
            if (i >= dataGroupHashArr.length) {
                break;
            }
            aSN1EncodableVector2.add(dataGroupHashArr[i]);
            i++;
        }
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        LDSVersionInfo lDSVersionInfo = this.versionInfo;
        if (lDSVersionInfo != null) {
            aSN1EncodableVector.add(lDSVersionInfo);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
