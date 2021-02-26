package repack.org.bouncycastle.cert.crmf;

import java.io.IOException;
import java.io.OutputStream;
import repack.org.bouncycastle.asn1.cmp.PBMParameter;
import repack.org.bouncycastle.asn1.crmf.PKMACValue;
import repack.org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import repack.org.bouncycastle.operator.MacCalculator;
import repack.org.bouncycastle.util.Arrays;

class PKMACValueVerifier {
    private final PKMACBuilder builder;

    public PKMACValueVerifier(PKMACBuilder pKMACBuilder) {
        this.builder = pKMACBuilder;
    }

    public boolean isValid(PKMACValue pKMACValue, char[] cArr, SubjectPublicKeyInfo subjectPublicKeyInfo) throws CRMFException {
        this.builder.setParameters(PBMParameter.getInstance(pKMACValue.getAlgId().getParameters()));
        MacCalculator build = this.builder.build(cArr);
        OutputStream outputStream = build.getOutputStream();
        try {
            outputStream.write(subjectPublicKeyInfo.getDEREncoded());
            outputStream.close();
            return Arrays.areEqual(build.getMac(), pKMACValue.getValue().getBytes());
        } catch (IOException e) {
            throw new CRMFException("exception encoding mac input: " + e.getMessage(), e);
        }
    }
}
