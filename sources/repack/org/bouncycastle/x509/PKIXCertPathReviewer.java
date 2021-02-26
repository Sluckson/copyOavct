package repack.org.bouncycastle.x509;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.security.PublicKey;
import java.security.cert.CertPath;
import java.security.cert.CertPathValidatorException;
import java.security.cert.CertificateFactory;
import java.security.cert.PKIXCertPathChecker;
import java.security.cert.PKIXParameters;
import java.security.cert.PolicyNode;
import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509CertSelector;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import javax.security.auth.x500.X500Principal;
import p052cz.msebera.android.httpclient.HttpHost;
import repack.org.bouncycastle.asn1.ASN1InputStream;
import repack.org.bouncycastle.asn1.ASN1Object;
import repack.org.bouncycastle.asn1.ASN1OctetString;
import repack.org.bouncycastle.asn1.ASN1Sequence;
import repack.org.bouncycastle.asn1.DERIA5String;
import repack.org.bouncycastle.asn1.DERObjectIdentifier;
import repack.org.bouncycastle.asn1.DEROctetString;
import repack.org.bouncycastle.asn1.x509.AccessDescription;
import repack.org.bouncycastle.asn1.x509.AuthorityInformationAccess;
import repack.org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import repack.org.bouncycastle.asn1.x509.BasicConstraints;
import repack.org.bouncycastle.asn1.x509.CRLDistPoint;
import repack.org.bouncycastle.asn1.x509.DistributionPoint;
import repack.org.bouncycastle.asn1.x509.DistributionPointName;
import repack.org.bouncycastle.asn1.x509.GeneralName;
import repack.org.bouncycastle.asn1.x509.GeneralNames;
import repack.org.bouncycastle.asn1.x509.GeneralSubtree;
import repack.org.bouncycastle.asn1.x509.NameConstraints;
import repack.org.bouncycastle.asn1.x509.X509Extensions;
import repack.org.bouncycastle.asn1.x509.qualified.MonetaryValue;
import repack.org.bouncycastle.asn1.x509.qualified.QCStatement;
import repack.org.bouncycastle.i18n.ErrorBundle;
import repack.org.bouncycastle.i18n.filter.TrustedInput;
import repack.org.bouncycastle.i18n.filter.UntrustedInput;
import repack.org.bouncycastle.jce.provider.AnnotatedException;
import repack.org.bouncycastle.jce.provider.CertPathValidatorUtilities;
import repack.org.bouncycastle.jce.provider.PKIXNameConstraintValidator;
import repack.org.bouncycastle.jce.provider.PKIXNameConstraintValidatorException;

public class PKIXCertPathReviewer extends CertPathValidatorUtilities {
    private static final String AUTH_INFO_ACCESS = X509Extensions.AuthorityInfoAccess.getId();
    private static final String CRL_DIST_POINTS = X509Extensions.CRLDistributionPoints.getId();
    private static final String QC_STATEMENT = X509Extensions.QCStatements.getId();
    private static final String RESOURCE_NAME = "org.bouncycastle.x509.CertPathReviewerMessages";
    protected CertPath certPath;
    protected List certs;
    protected List[] errors;
    private boolean initialized;

    /* renamed from: n */
    protected int f6299n;
    protected List[] notifications;
    protected PKIXParameters pkixParams;
    protected PolicyNode policyTree;
    protected PublicKey subjectPublicKey;
    protected TrustAnchor trustAnchor;
    protected Date validDate;

    public void init(CertPath certPath2, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        if (!this.initialized) {
            this.initialized = true;
            if (certPath2 != null) {
                this.certPath = certPath2;
                this.certs = certPath2.getCertificates();
                this.f6299n = this.certs.size();
                if (!this.certs.isEmpty()) {
                    this.pkixParams = (PKIXParameters) pKIXParameters.clone();
                    this.validDate = getValidDate(this.pkixParams);
                    this.notifications = null;
                    this.errors = null;
                    this.trustAnchor = null;
                    this.subjectPublicKey = null;
                    this.policyTree = null;
                    return;
                }
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.emptyCertPath"));
            }
            throw new NullPointerException("certPath was null");
        }
        throw new IllegalStateException("object is already initialized!");
    }

    public PKIXCertPathReviewer(CertPath certPath2, PKIXParameters pKIXParameters) throws CertPathReviewerException {
        init(certPath2, pKIXParameters);
    }

    public PKIXCertPathReviewer() {
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getCertPathSize() {
        return this.f6299n;
    }

    public List[] getErrors() {
        doChecks();
        return this.errors;
    }

    public List getErrors(int i) {
        doChecks();
        return this.errors[i + 1];
    }

    public List[] getNotifications() {
        doChecks();
        return this.notifications;
    }

    public List getNotifications(int i) {
        doChecks();
        return this.notifications[i + 1];
    }

    public PolicyNode getPolicyTree() {
        doChecks();
        return this.policyTree;
    }

    public PublicKey getSubjectPublicKey() {
        doChecks();
        return this.subjectPublicKey;
    }

    public TrustAnchor getTrustAnchor() {
        doChecks();
        return this.trustAnchor;
    }

    public boolean isValidCertPath() {
        doChecks();
        int i = 0;
        while (true) {
            List[] listArr = this.errors;
            if (i >= listArr.length) {
                return true;
            }
            if (!listArr[i].isEmpty()) {
                return false;
            }
            i++;
        }
    }

    /* access modifiers changed from: protected */
    public void addNotification(ErrorBundle errorBundle) {
        this.notifications[0].add(errorBundle);
    }

    /* access modifiers changed from: protected */
    public void addNotification(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.f6299n) {
            throw new IndexOutOfBoundsException();
        }
        this.notifications[i + 1].add(errorBundle);
    }

    /* access modifiers changed from: protected */
    public void addError(ErrorBundle errorBundle) {
        this.errors[0].add(errorBundle);
    }

    /* access modifiers changed from: protected */
    public void addError(ErrorBundle errorBundle, int i) {
        if (i < -1 || i >= this.f6299n) {
            throw new IndexOutOfBoundsException();
        }
        this.errors[i + 1].add(errorBundle);
    }

    /* access modifiers changed from: protected */
    public void doChecks() {
        if (!this.initialized) {
            throw new IllegalStateException("Object not initialized. Call init() first.");
        } else if (this.notifications == null) {
            int i = this.f6299n;
            this.notifications = new List[(i + 1)];
            this.errors = new List[(i + 1)];
            int i2 = 0;
            while (true) {
                List[] listArr = this.notifications;
                if (i2 >= listArr.length) {
                    checkSignatures();
                    checkNameConstraints();
                    checkPathLength();
                    checkPolicy();
                    checkCriticalExtensions();
                    return;
                }
                listArr[i2] = new ArrayList();
                this.errors[i2] = new ArrayList();
                i2++;
            }
        }
    }

    private void checkNameConstraints() {
        GeneralName instance;
        PKIXNameConstraintValidator pKIXNameConstraintValidator = new PKIXNameConstraintValidator();
        for (int size = this.certs.size() - 1; size > 0; size--) {
            int i = this.f6299n;
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            if (!isSelfIssued(x509Certificate)) {
                X500Principal subjectPrincipal = getSubjectPrincipal(x509Certificate);
                try {
                    ASN1Sequence aSN1Sequence = (ASN1Sequence) new ASN1InputStream((InputStream) new ByteArrayInputStream(subjectPrincipal.getEncoded())).readObject();
                    pKIXNameConstraintValidator.checkPermittedDN(aSN1Sequence);
                    pKIXNameConstraintValidator.checkExcludedDN(aSN1Sequence);
                    ASN1Sequence aSN1Sequence2 = (ASN1Sequence) getExtensionValue(x509Certificate, SUBJECT_ALTERNATIVE_NAME);
                    if (aSN1Sequence2 != null) {
                        for (int i2 = 0; i2 < aSN1Sequence2.size(); i2++) {
                            instance = GeneralName.getInstance(aSN1Sequence2.getObjectAt(i2));
                            pKIXNameConstraintValidator.checkPermitted(instance);
                            pKIXNameConstraintValidator.checkExcluded(instance);
                        }
                    }
                } catch (AnnotatedException e) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncExtError"), e, this.certPath, size);
                } catch (IOException e2) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.ncSubjectNameError", new Object[]{new UntrustedInput(subjectPrincipal)}), e2, this.certPath, size);
                } catch (PKIXNameConstraintValidatorException e3) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e3, this.certPath, size);
                } catch (PKIXNameConstraintValidatorException e4) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.excludedDN", new Object[]{new UntrustedInput(subjectPrincipal.getName())}), e4, this.certPath, size);
                } catch (AnnotatedException e5) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.subjAltNameExtError"), e5, this.certPath, size);
                } catch (PKIXNameConstraintValidatorException e6) {
                    throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.notPermittedEmail", new Object[]{new UntrustedInput(instance)}), e6, this.certPath, size);
                } catch (CertPathReviewerException e7) {
                    addError(e7.getErrorMessage(), e7.getIndex());
                    return;
                }
            }
            ASN1Sequence aSN1Sequence3 = (ASN1Sequence) getExtensionValue(x509Certificate, NAME_CONSTRAINTS);
            if (aSN1Sequence3 != null) {
                NameConstraints nameConstraints = new NameConstraints(aSN1Sequence3);
                ASN1Sequence permittedSubtrees = nameConstraints.getPermittedSubtrees();
                if (permittedSubtrees != null) {
                    pKIXNameConstraintValidator.intersectPermittedSubtree(permittedSubtrees);
                }
                ASN1Sequence excludedSubtrees = nameConstraints.getExcludedSubtrees();
                if (excludedSubtrees != null) {
                    Enumeration objects = excludedSubtrees.getObjects();
                    while (objects.hasMoreElements()) {
                        pKIXNameConstraintValidator.addExcludedSubtree(GeneralSubtree.getInstance(objects.nextElement()));
                    }
                }
            }
        }
    }

    private void checkPathLength() {
        BasicConstraints basicConstraints;
        BigInteger pathLenConstraint;
        int intValue;
        int i = this.f6299n;
        int i2 = i;
        int i3 = 0;
        for (int size = this.certs.size() - 1; size > 0; size--) {
            int i4 = this.f6299n;
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            if (!isSelfIssued(x509Certificate)) {
                if (i2 <= 0) {
                    addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.pathLenghtExtended"));
                }
                i2--;
                i3++;
            }
            try {
                basicConstraints = BasicConstraints.getInstance(getExtensionValue(x509Certificate, BASIC_CONSTRAINTS));
            } catch (AnnotatedException unused) {
                addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.processLengthConstError"), size);
                basicConstraints = null;
            }
            if (!(basicConstraints == null || (pathLenConstraint = basicConstraints.getPathLenConstraint()) == null || (intValue = pathLenConstraint.intValue()) >= i2)) {
                i2 = intValue;
            }
        }
        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.totalPathLength", new Object[]{new Integer(i3)}));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: java.security.cert.X509Certificate} */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x00c1 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x030e A[LOOP:2: B:107:0x02da->B:119:0x030e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0337 A[LOOP:1: B:104:0x02d0->B:120:0x0337, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x0375  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0394  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x039b  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03f5  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02b4 A[Catch:{ AnnotatedException -> 0x02b9 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkSignatures() {
        /*
            r20 = this;
            r10 = r20
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            r11 = 2
            java.lang.Object[] r1 = new java.lang.Object[r11]
            repack.org.bouncycastle.i18n.filter.TrustedInput r2 = new repack.org.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r3 = r10.validDate
            r2.<init>(r3)
            r12 = 0
            r1[r12] = r2
            repack.org.bouncycastle.i18n.filter.TrustedInput r2 = new repack.org.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r3 = new java.util.Date
            r3.<init>()
            r2.<init>(r3)
            r13 = 1
            r1[r13] = r2
            java.lang.String r14 = "org.bouncycastle.x509.CertPathReviewerMessages"
            java.lang.String r2 = "CertPathReviewer.certPathValidDate"
            r0.<init>((java.lang.String) r14, (java.lang.String) r2, (java.lang.Object[]) r1)
            r10.addNotification(r0)
            java.util.List r0 = r10.certs     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            java.util.List r1 = r10.certs     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            int r1 = r1.size()     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            int r1 = r1 - r13
            java.lang.Object r0 = r0.get(r1)     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            java.security.cert.PKIXParameters r1 = r10.pkixParams     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            java.util.Set r1 = r1.getTrustAnchors()     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            java.util.Collection r1 = r10.getTrustAnchors(r0, r1)     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            int r2 = r1.size()     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            if (r2 <= r13) goto L_0x006a
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            java.lang.String r3 = "CertPathReviewer.conflictingTrustAnchors"
            java.lang.Object[] r4 = new java.lang.Object[r11]     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            java.lang.Integer r5 = new java.lang.Integer     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            int r1 = r1.size()     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            r5.<init>(r1)     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            r4[r12] = r5     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            repack.org.bouncycastle.i18n.filter.UntrustedInput r1 = new repack.org.bouncycastle.i18n.filter.UntrustedInput     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            javax.security.auth.x500.X500Principal r0 = r0.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            r1.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            r4[r13] = r1     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            r2.<init>((java.lang.String) r14, (java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            r10.addError(r2)     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            goto L_0x0098
        L_0x006a:
            boolean r2 = r1.isEmpty()     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            if (r2 == 0) goto L_0x009a
            repack.org.bouncycastle.i18n.ErrorBundle r1 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            java.lang.String r2 = "CertPathReviewer.noTrustAnchorFound"
            java.lang.Object[] r3 = new java.lang.Object[r11]     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            repack.org.bouncycastle.i18n.filter.UntrustedInput r4 = new repack.org.bouncycastle.i18n.filter.UntrustedInput     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            javax.security.auth.x500.X500Principal r0 = r0.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            r4.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            r3[r12] = r4     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            java.lang.Integer r0 = new java.lang.Integer     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            java.security.cert.PKIXParameters r4 = r10.pkixParams     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            java.util.Set r4 = r4.getTrustAnchors()     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            int r4 = r4.size()     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            r0.<init>(r4)     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            r3[r13] = r0     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            r1.<init>((java.lang.String) r14, (java.lang.String) r2, (java.lang.Object[]) r3)     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            r10.addError(r1)     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
        L_0x0098:
            r9 = 0
            goto L_0x00fb
        L_0x009a:
            java.util.Iterator r1 = r1.iterator()     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            java.lang.Object r1 = r1.next()     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            java.security.cert.TrustAnchor r1 = (java.security.cert.TrustAnchor) r1     // Catch:{ CertPathReviewerException -> 0x00f1, Throwable -> 0x00d0 }
            java.security.cert.X509Certificate r2 = r1.getTrustedCert()     // Catch:{ CertPathReviewerException -> 0x00ce, Throwable -> 0x00cc }
            if (r2 == 0) goto L_0x00b3
            java.security.cert.X509Certificate r2 = r1.getTrustedCert()     // Catch:{ CertPathReviewerException -> 0x00ce, Throwable -> 0x00cc }
            java.security.PublicKey r2 = r2.getPublicKey()     // Catch:{ CertPathReviewerException -> 0x00ce, Throwable -> 0x00cc }
            goto L_0x00b7
        L_0x00b3:
            java.security.PublicKey r2 = r1.getCAPublicKey()     // Catch:{ CertPathReviewerException -> 0x00ce, Throwable -> 0x00cc }
        L_0x00b7:
            java.security.cert.PKIXParameters r3 = r10.pkixParams     // Catch:{ SignatureException -> 0x00c1, Exception -> 0x00fa }
            java.lang.String r3 = r3.getSigProvider()     // Catch:{ SignatureException -> 0x00c1, Exception -> 0x00fa }
            repack.org.bouncycastle.jce.provider.CertPathValidatorUtilities.verifyX509Certificate(r0, r2, r3)     // Catch:{ SignatureException -> 0x00c1, Exception -> 0x00fa }
            goto L_0x00fa
        L_0x00c1:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x00ce, Throwable -> 0x00cc }
            java.lang.String r2 = "CertPathReviewer.trustButInvalidCert"
            r0.<init>(r14, r2)     // Catch:{ CertPathReviewerException -> 0x00ce, Throwable -> 0x00cc }
            r10.addError(r0)     // Catch:{ CertPathReviewerException -> 0x00ce, Throwable -> 0x00cc }
            goto L_0x00fa
        L_0x00cc:
            r0 = move-exception
            goto L_0x00d2
        L_0x00ce:
            r0 = move-exception
            goto L_0x00f3
        L_0x00d0:
            r0 = move-exception
            r1 = 0
        L_0x00d2:
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.Object[] r3 = new java.lang.Object[r11]
            repack.org.bouncycastle.i18n.filter.UntrustedInput r4 = new repack.org.bouncycastle.i18n.filter.UntrustedInput
            java.lang.String r5 = r0.getMessage()
            r4.<init>(r5)
            r3[r12] = r4
            repack.org.bouncycastle.i18n.filter.UntrustedInput r4 = new repack.org.bouncycastle.i18n.filter.UntrustedInput
            r4.<init>(r0)
            r3[r13] = r4
            java.lang.String r0 = "CertPathReviewer.unknown"
            r2.<init>((java.lang.String) r14, (java.lang.String) r0, (java.lang.Object[]) r3)
            r10.addError(r2)
            goto L_0x00fa
        L_0x00f1:
            r0 = move-exception
            r1 = 0
        L_0x00f3:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = r0.getErrorMessage()
            r10.addError(r0)
        L_0x00fa:
            r9 = r1
        L_0x00fb:
            r16 = 5
            if (r9 == 0) goto L_0x0143
            java.security.cert.X509Certificate r0 = r9.getTrustedCert()
            if (r0 == 0) goto L_0x010a
            javax.security.auth.x500.X500Principal r1 = getSubjectPrincipal(r0)     // Catch:{ IllegalArgumentException -> 0x0114 }
            goto L_0x012c
        L_0x010a:
            javax.security.auth.x500.X500Principal r1 = new javax.security.auth.x500.X500Principal     // Catch:{ IllegalArgumentException -> 0x0114 }
            java.lang.String r2 = r9.getCAName()     // Catch:{ IllegalArgumentException -> 0x0114 }
            r1.<init>(r2)     // Catch:{ IllegalArgumentException -> 0x0114 }
            goto L_0x012c
        L_0x0114:
            repack.org.bouncycastle.i18n.ErrorBundle r1 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.Object[] r2 = new java.lang.Object[r13]
            repack.org.bouncycastle.i18n.filter.UntrustedInput r3 = new repack.org.bouncycastle.i18n.filter.UntrustedInput
            java.lang.String r4 = r9.getCAName()
            r3.<init>(r4)
            r2[r12] = r3
            java.lang.String r3 = "CertPathReviewer.trustDNInvalid"
            r1.<init>((java.lang.String) r14, (java.lang.String) r3, (java.lang.Object[]) r2)
            r10.addError(r1)
            r1 = 0
        L_0x012c:
            if (r0 == 0) goto L_0x0144
            boolean[] r0 = r0.getKeyUsage()
            if (r0 == 0) goto L_0x0144
            boolean r0 = r0[r16]
            if (r0 != 0) goto L_0x0144
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.trustKeyUsage"
            r0.<init>(r14, r2)
            r10.addNotification(r0)
            goto L_0x0144
        L_0x0143:
            r1 = 0
        L_0x0144:
            if (r9 == 0) goto L_0x016b
            java.security.cert.X509Certificate r0 = r9.getTrustedCert()
            if (r0 == 0) goto L_0x0151
            java.security.PublicKey r2 = r0.getPublicKey()
            goto L_0x0155
        L_0x0151:
            java.security.PublicKey r2 = r9.getCAPublicKey()
        L_0x0155:
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r3 = getAlgorithmIdentifier(r2)     // Catch:{ CertPathValidatorException -> 0x0160 }
            r3.getObjectId()     // Catch:{ CertPathValidatorException -> 0x0160 }
            r3.getParameters()     // Catch:{ CertPathValidatorException -> 0x0160 }
            goto L_0x016d
        L_0x0160:
            repack.org.bouncycastle.i18n.ErrorBundle r3 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r4 = "CertPathReviewer.trustPubKeyError"
            r3.<init>(r14, r4)
            r10.addError(r3)
            goto L_0x016d
        L_0x016b:
            r0 = 0
            r2 = 0
        L_0x016d:
            java.util.List r3 = r10.certs
            int r3 = r3.size()
            int r3 = r3 - r13
            r5 = r0
            r6 = r1
            r7 = r2
            r8 = r3
        L_0x0178:
            if (r8 >= 0) goto L_0x017f
            r10.trustAnchor = r9
            r10.subjectPublicKey = r7
            return
        L_0x017f:
            int r0 = r10.f6299n
            int r4 = r0 - r8
            java.util.List r0 = r10.certs
            java.lang.Object r0 = r0.get(r8)
            r3 = r0
            java.security.cert.X509Certificate r3 = (java.security.cert.X509Certificate) r3
            java.lang.String r1 = "CertPathReviewer.signatureNotVerified"
            r2 = 3
            if (r7 == 0) goto L_0x01bb
            java.security.cert.PKIXParameters r0 = r10.pkixParams     // Catch:{ GeneralSecurityException -> 0x019c }
            java.lang.String r0 = r0.getSigProvider()     // Catch:{ GeneralSecurityException -> 0x019c }
            repack.org.bouncycastle.jce.provider.CertPathValidatorUtilities.verifyX509Certificate(r3, r7, r0)     // Catch:{ GeneralSecurityException -> 0x019c }
            goto L_0x0255
        L_0x019c:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r15 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r17 = r0.getMessage()
            r2[r12] = r17
            r2[r13] = r0
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r2[r11] = r0
            r15.<init>((java.lang.String) r14, (java.lang.String) r1, (java.lang.Object[]) r2)
            r10.addError(r15, r8)
            goto L_0x0255
        L_0x01bb:
            boolean r0 = isSelfIssued(r3)
            if (r0 == 0) goto L_0x01f8
            java.security.PublicKey r0 = r3.getPublicKey()     // Catch:{ GeneralSecurityException -> 0x01da }
            java.security.cert.PKIXParameters r15 = r10.pkixParams     // Catch:{ GeneralSecurityException -> 0x01da }
            java.lang.String r15 = r15.getSigProvider()     // Catch:{ GeneralSecurityException -> 0x01da }
            repack.org.bouncycastle.jce.provider.CertPathValidatorUtilities.verifyX509Certificate(r3, r0, r15)     // Catch:{ GeneralSecurityException -> 0x01da }
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ GeneralSecurityException -> 0x01da }
            java.lang.String r15 = "CertPathReviewer.rootKeyIsValidButNotATrustAnchor"
            r0.<init>(r14, r15)     // Catch:{ GeneralSecurityException -> 0x01da }
            r10.addError(r0, r8)     // Catch:{ GeneralSecurityException -> 0x01da }
            goto L_0x0255
        L_0x01da:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r15 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.String r17 = r0.getMessage()
            r2[r12] = r17
            r2[r13] = r0
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r2[r11] = r0
            r15.<init>((java.lang.String) r14, (java.lang.String) r1, (java.lang.Object[]) r2)
            r10.addError(r15, r8)
            goto L_0x0255
        L_0x01f8:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r1 = "CertPathReviewer.NoIssuerPublicKey"
            r0.<init>(r14, r1)
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r1 = repack.org.bouncycastle.asn1.x509.X509Extensions.AuthorityKeyIdentifier
            java.lang.String r1 = r1.getId()
            byte[] r1 = r3.getExtensionValue(r1)
            if (r1 == 0) goto L_0x0252
            repack.org.bouncycastle.asn1.ASN1Object r1 = repack.org.bouncycastle.x509.extension.X509ExtensionUtil.fromExtensionValue(r1)     // Catch:{ IOException -> 0x0252 }
            repack.org.bouncycastle.asn1.x509.AuthorityKeyIdentifier r1 = repack.org.bouncycastle.asn1.x509.AuthorityKeyIdentifier.getInstance(r1)     // Catch:{ IOException -> 0x0252 }
            repack.org.bouncycastle.asn1.x509.GeneralNames r15 = r1.getAuthorityCertIssuer()     // Catch:{ IOException -> 0x0252 }
            if (r15 == 0) goto L_0x0252
            repack.org.bouncycastle.asn1.x509.GeneralName[] r15 = r15.getNames()     // Catch:{ IOException -> 0x0252 }
            r15 = r15[r12]     // Catch:{ IOException -> 0x0252 }
            java.math.BigInteger r1 = r1.getAuthorityCertSerialNumber()     // Catch:{ IOException -> 0x0252 }
            if (r1 == 0) goto L_0x0252
            r2 = 7
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x0252 }
            repack.org.bouncycastle.i18n.LocaleString r11 = new repack.org.bouncycastle.i18n.LocaleString     // Catch:{ IOException -> 0x0252 }
            java.lang.String r13 = "missingIssuer"
            r11.<init>(r14, r13)     // Catch:{ IOException -> 0x0252 }
            r2[r12] = r11     // Catch:{ IOException -> 0x0252 }
            java.lang.String r11 = " \""
            r13 = 1
            r2[r13] = r11     // Catch:{ IOException -> 0x0252 }
            r11 = 2
            r2[r11] = r15     // Catch:{ IOException -> 0x0252 }
            java.lang.String r11 = "\" "
            r13 = 3
            r2[r13] = r11     // Catch:{ IOException -> 0x0252 }
            r11 = 4
            repack.org.bouncycastle.i18n.LocaleString r13 = new repack.org.bouncycastle.i18n.LocaleString     // Catch:{ IOException -> 0x0252 }
            java.lang.String r15 = "missingSerial"
            r13.<init>(r14, r15)     // Catch:{ IOException -> 0x0252 }
            r2[r11] = r13     // Catch:{ IOException -> 0x0252 }
            java.lang.String r11 = " "
            r2[r16] = r11     // Catch:{ IOException -> 0x0252 }
            r11 = 6
            r2[r11] = r1     // Catch:{ IOException -> 0x0252 }
            r0.setExtraArguments(r2)     // Catch:{ IOException -> 0x0252 }
        L_0x0252:
            r10.addError(r0, r8)
        L_0x0255:
            java.util.Date r0 = r10.validDate     // Catch:{ CertificateNotYetValidException -> 0x0274, CertificateExpiredException -> 0x025b }
            r3.checkValidity(r0)     // Catch:{ CertificateNotYetValidException -> 0x0274, CertificateExpiredException -> 0x025b }
            goto L_0x028c
        L_0x025b:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            repack.org.bouncycastle.i18n.filter.TrustedInput r11 = new repack.org.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r13 = r3.getNotAfter()
            r11.<init>(r13)
            r2[r12] = r11
            java.lang.String r11 = "CertPathReviewer.certificateExpired"
            r0.<init>((java.lang.String) r14, (java.lang.String) r11, (java.lang.Object[]) r2)
            r10.addError(r0, r8)
            goto L_0x028c
        L_0x0274:
            r1 = 1
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.Object[] r2 = new java.lang.Object[r1]
            repack.org.bouncycastle.i18n.filter.TrustedInput r1 = new repack.org.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r11 = r3.getNotBefore()
            r1.<init>(r11)
            r2[r12] = r1
            java.lang.String r1 = "CertPathReviewer.certificateNotYetValid"
            r0.<init>((java.lang.String) r14, (java.lang.String) r1, (java.lang.Object[]) r2)
            r10.addError(r0, r8)
        L_0x028c:
            java.security.cert.PKIXParameters r0 = r10.pkixParams
            boolean r0 = r0.isRevocationEnabled()
            if (r0 == 0) goto L_0x0360
            java.lang.String r0 = CRL_DIST_POINTS     // Catch:{ AnnotatedException -> 0x02a1 }
            repack.org.bouncycastle.asn1.DERObject r0 = getExtensionValue(r3, r0)     // Catch:{ AnnotatedException -> 0x02a1 }
            if (r0 == 0) goto L_0x02ab
            repack.org.bouncycastle.asn1.x509.CRLDistPoint r15 = repack.org.bouncycastle.asn1.x509.CRLDistPoint.getInstance(r0)     // Catch:{ AnnotatedException -> 0x02a1 }
            goto L_0x02ac
        L_0x02a1:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r1 = "CertPathReviewer.crlDistPtExtError"
            r0.<init>(r14, r1)
            r10.addError(r0, r8)
        L_0x02ab:
            r15 = 0
        L_0x02ac:
            java.lang.String r0 = AUTH_INFO_ACCESS     // Catch:{ AnnotatedException -> 0x02b9 }
            repack.org.bouncycastle.asn1.DERObject r0 = getExtensionValue(r3, r0)     // Catch:{ AnnotatedException -> 0x02b9 }
            if (r0 == 0) goto L_0x02c3
            repack.org.bouncycastle.asn1.x509.AuthorityInformationAccess r0 = repack.org.bouncycastle.asn1.x509.AuthorityInformationAccess.getInstance(r0)     // Catch:{ AnnotatedException -> 0x02b9 }
            goto L_0x02c4
        L_0x02b9:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r1 = "CertPathReviewer.crlAuthInfoAccError"
            r0.<init>(r14, r1)
            r10.addError(r0, r8)
        L_0x02c3:
            r0 = 0
        L_0x02c4:
            java.util.Vector r11 = r10.getCRLDistUrls(r15)
            java.util.Vector r0 = r10.getOCSPUrls(r0)
            java.util.Iterator r1 = r11.iterator()
        L_0x02d0:
            boolean r2 = r1.hasNext()
            if (r2 != 0) goto L_0x0337
            java.util.Iterator r2 = r0.iterator()
        L_0x02da:
            boolean r1 = r2.hasNext()
            if (r1 != 0) goto L_0x030e
            java.security.cert.PKIXParameters r2 = r10.pkixParams     // Catch:{ CertPathReviewerException -> 0x02fa }
            java.util.Date r13 = r10.validDate     // Catch:{ CertPathReviewerException -> 0x02fa }
            r1 = r20
            r15 = r3
            r18 = r4
            r4 = r13
            r13 = r6
            r6 = r7
            r17 = r7
            r7 = r11
            r11 = r8
            r8 = r0
            r19 = r9
            r9 = r11
            r1.checkRevocation(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ CertPathReviewerException -> 0x02f8 }
            goto L_0x030b
        L_0x02f8:
            r0 = move-exception
            goto L_0x0304
        L_0x02fa:
            r0 = move-exception
            r15 = r3
            r18 = r4
            r13 = r6
            r17 = r7
            r11 = r8
            r19 = r9
        L_0x0304:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = r0.getErrorMessage()
            r10.addError(r0, r11)
        L_0x030b:
            r3 = r11
            goto L_0x0369
        L_0x030e:
            r15 = r3
            r18 = r4
            r13 = r6
            r17 = r7
            r3 = r8
            r19 = r9
            repack.org.bouncycastle.i18n.ErrorBundle r1 = new repack.org.bouncycastle.i18n.ErrorBundle
            r4 = 1
            java.lang.Object[] r6 = new java.lang.Object[r4]
            repack.org.bouncycastle.i18n.filter.UntrustedUrlInput r7 = new repack.org.bouncycastle.i18n.filter.UntrustedUrlInput
            java.lang.Object r8 = r2.next()
            r7.<init>(r8)
            r6[r12] = r7
            java.lang.String r7 = "CertPathReviewer.ocspLocation"
            r1.<init>((java.lang.String) r14, (java.lang.String) r7, (java.lang.Object[]) r6)
            r10.addNotification(r1, r3)
            r8 = r3
            r6 = r13
            r3 = r15
            r7 = r17
            r4 = r18
            goto L_0x02da
        L_0x0337:
            r15 = r3
            r18 = r4
            r13 = r6
            r17 = r7
            r3 = r8
            r19 = r9
            r4 = 1
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.Object[] r6 = new java.lang.Object[r4]
            repack.org.bouncycastle.i18n.filter.UntrustedUrlInput r4 = new repack.org.bouncycastle.i18n.filter.UntrustedUrlInput
            java.lang.Object r7 = r1.next()
            r4.<init>(r7)
            r6[r12] = r4
            java.lang.String r4 = "CertPathReviewer.crlDistPoint"
            r2.<init>((java.lang.String) r14, (java.lang.String) r4, (java.lang.Object[]) r6)
            r10.addNotification(r2, r3)
            r6 = r13
            r3 = r15
            r7 = r17
            r4 = r18
            goto L_0x02d0
        L_0x0360:
            r15 = r3
            r18 = r4
            r13 = r6
            r17 = r7
            r3 = r8
            r19 = r9
        L_0x0369:
            if (r13 == 0) goto L_0x0394
            javax.security.auth.x500.X500Principal r0 = r15.getIssuerX500Principal()
            boolean r0 = r0.equals(r13)
            if (r0 != 0) goto L_0x0394
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            java.lang.String r4 = r13.getName()
            r2[r12] = r4
            javax.security.auth.x500.X500Principal r4 = r15.getIssuerX500Principal()
            java.lang.String r4 = r4.getName()
            r5 = 1
            r2[r5] = r4
            java.lang.String r4 = "CertPathReviewer.certWrongIssuer"
            r0.<init>((java.lang.String) r14, (java.lang.String) r4, (java.lang.Object[]) r2)
            r10.addError(r0, r3)
            goto L_0x0395
        L_0x0394:
            r1 = 2
        L_0x0395:
            int r0 = r10.f6299n
            r2 = r18
            if (r2 == r0) goto L_0x03f5
            java.lang.String r0 = "CertPathReviewer.noCACert"
            if (r15 == 0) goto L_0x03af
            int r2 = r15.getVersion()
            r4 = 1
            if (r2 != r4) goto L_0x03b0
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle
            r2.<init>(r14, r0)
            r10.addError(r2, r3)
            goto L_0x03b0
        L_0x03af:
            r4 = 1
        L_0x03b0:
            java.lang.String r2 = BASIC_CONSTRAINTS     // Catch:{ AnnotatedException -> 0x03d6 }
            repack.org.bouncycastle.asn1.DERObject r2 = getExtensionValue(r15, r2)     // Catch:{ AnnotatedException -> 0x03d6 }
            repack.org.bouncycastle.asn1.x509.BasicConstraints r2 = repack.org.bouncycastle.asn1.x509.BasicConstraints.getInstance(r2)     // Catch:{ AnnotatedException -> 0x03d6 }
            if (r2 == 0) goto L_0x03cb
            boolean r2 = r2.isCA()     // Catch:{ AnnotatedException -> 0x03d6 }
            if (r2 != 0) goto L_0x03e0
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ AnnotatedException -> 0x03d6 }
            r2.<init>(r14, r0)     // Catch:{ AnnotatedException -> 0x03d6 }
            r10.addError(r2, r3)     // Catch:{ AnnotatedException -> 0x03d6 }
            goto L_0x03e0
        L_0x03cb:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ AnnotatedException -> 0x03d6 }
            java.lang.String r2 = "CertPathReviewer.noBasicConstraints"
            r0.<init>(r14, r2)     // Catch:{ AnnotatedException -> 0x03d6 }
            r10.addError(r0, r3)     // Catch:{ AnnotatedException -> 0x03d6 }
            goto L_0x03e0
        L_0x03d6:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.errorProcesingBC"
            r0.<init>(r14, r2)
            r10.addError(r0, r3)
        L_0x03e0:
            boolean[] r0 = r15.getKeyUsage()
            if (r0 == 0) goto L_0x03f6
            boolean r0 = r0[r16]
            if (r0 != 0) goto L_0x03f6
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.noCertSign"
            r0.<init>(r14, r2)
            r10.addError(r0, r3)
            goto L_0x03f6
        L_0x03f5:
            r4 = 1
        L_0x03f6:
            javax.security.auth.x500.X500Principal r6 = r15.getSubjectX500Principal()
            java.util.List r0 = r10.certs     // Catch:{ CertPathValidatorException -> 0x040b }
            java.security.PublicKey r7 = getNextWorkingKey(r0, r3)     // Catch:{ CertPathValidatorException -> 0x040b }
            repack.org.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = getAlgorithmIdentifier(r7)     // Catch:{ CertPathValidatorException -> 0x040d }
            r0.getObjectId()     // Catch:{ CertPathValidatorException -> 0x040d }
            r0.getParameters()     // Catch:{ CertPathValidatorException -> 0x040d }
            goto L_0x0417
        L_0x040b:
            r7 = r17
        L_0x040d:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.pubKeyError"
            r0.<init>(r14, r2)
            r10.addError(r0, r3)
        L_0x0417:
            int r8 = r3 + -1
            r5 = r15
            r9 = r19
            r11 = 2
            r13 = 1
            goto L_0x0178
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.x509.PKIXCertPathReviewer.checkSignatures():void");
    }

    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v19 */
    /* JADX WARNING: Code restructure failed: missing block: B:319:0x059c, code lost:
        r2 = r2.getValue().intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x05ba, code lost:
        throw new repack.org.bouncycastle.x509.CertPathReviewerException(new repack.org.bouncycastle.i18n.ErrorBundle(RESOURCE_NAME, "CertPathReviewer.policyInhibitExtError"), r1.certPath, r11);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:323:0x05ac */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0275 A[Catch:{ AnnotatedException -> 0x05f1, AnnotatedException -> 0x05ca, AnnotatedException -> 0x05bb, AnnotatedException -> 0x04c0, CertPathValidatorException -> 0x04b1, CertPathValidatorException -> 0x03e6, CertPathValidatorException -> 0x03a3, AnnotatedException -> 0x0206, CertPathReviewerException -> 0x0600 }] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x028e A[Catch:{ AnnotatedException -> 0x05f1, AnnotatedException -> 0x05ca, AnnotatedException -> 0x05bb, AnnotatedException -> 0x04c0, CertPathValidatorException -> 0x04b1, CertPathValidatorException -> 0x03e6, CertPathValidatorException -> 0x03a3, AnnotatedException -> 0x0206, CertPathReviewerException -> 0x0600 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x02c3 A[Catch:{ AnnotatedException -> 0x05f1, AnnotatedException -> 0x05ca, AnnotatedException -> 0x05bb, AnnotatedException -> 0x04c0, CertPathValidatorException -> 0x04b1, CertPathValidatorException -> 0x03e6, CertPathValidatorException -> 0x03a3, AnnotatedException -> 0x0206, CertPathReviewerException -> 0x0600 }] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x02e5 A[Catch:{ AnnotatedException -> 0x05f1, AnnotatedException -> 0x05ca, AnnotatedException -> 0x05bb, AnnotatedException -> 0x04c0, CertPathValidatorException -> 0x04b1, CertPathValidatorException -> 0x03e6, CertPathValidatorException -> 0x03a3, AnnotatedException -> 0x0206, CertPathReviewerException -> 0x0600 }] */
    /* JADX WARNING: Removed duplicated region for block: B:300:0x0551 A[Catch:{ AnnotatedException -> 0x05f1, AnnotatedException -> 0x05ca, AnnotatedException -> 0x05bb, AnnotatedException -> 0x04c0, CertPathValidatorException -> 0x04b1, CertPathValidatorException -> 0x03e6, CertPathValidatorException -> 0x03a3, AnnotatedException -> 0x0206, CertPathReviewerException -> 0x0600 }] */
    /* JADX WARNING: Removed duplicated region for block: B:321:0x05a6  */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x05a9  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void checkPolicy() {
        /*
            r33 = this;
            r1 = r33
            java.lang.String r2 = "CertPathReviewer.policyExtError"
            java.security.cert.PKIXParameters r0 = r1.pkixParams
            java.util.Set r0 = r0.getInitialPolicies()
            int r3 = r1.f6299n
            r4 = 1
            int r3 = r3 + r4
            java.util.ArrayList[] r3 = new java.util.ArrayList[r3]
            r5 = 0
            r6 = 0
        L_0x0012:
            int r7 = r3.length
            if (r6 < r7) goto L_0x060d
            java.util.HashSet r11 = new java.util.HashSet
            r11.<init>()
            java.lang.String r6 = "2.5.29.32.0"
            r11.add(r6)
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r7 = new repack.org.bouncycastle.jce.provider.PKIXPolicyNode
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r10 = 0
            r12 = 0
            java.util.HashSet r13 = new java.util.HashSet
            r13.<init>()
            r15 = 0
            java.lang.String r14 = "2.5.29.32.0"
            r8 = r7
            r8.<init>(r9, r10, r11, r12, r13, r14, r15)
            r8 = r3[r5]
            r8.add(r7)
            java.security.cert.PKIXParameters r8 = r1.pkixParams
            boolean r8 = r8.isExplicitPolicyRequired()
            if (r8 == 0) goto L_0x0043
            r8 = 0
            goto L_0x0046
        L_0x0043:
            int r8 = r1.f6299n
            int r8 = r8 + r4
        L_0x0046:
            java.security.cert.PKIXParameters r9 = r1.pkixParams
            boolean r9 = r9.isAnyPolicyInhibited()
            if (r9 == 0) goto L_0x0050
            r9 = 0
            goto L_0x0053
        L_0x0050:
            int r9 = r1.f6299n
            int r9 = r9 + r4
        L_0x0053:
            java.security.cert.PKIXParameters r10 = r1.pkixParams
            boolean r10 = r10.isPolicyMappingInhibited()
            if (r10 == 0) goto L_0x005d
            r10 = 0
            goto L_0x0060
        L_0x005d:
            int r10 = r1.f6299n
            int r10 = r10 + r4
        L_0x0060:
            java.util.List r11 = r1.certs     // Catch:{ CertPathReviewerException -> 0x0600 }
            int r11 = r11.size()     // Catch:{ CertPathReviewerException -> 0x0600 }
            int r11 = r11 - r4
            r13 = r9
            r14 = r10
            r10 = 0
            r9 = r7
            r7 = 0
        L_0x006c:
            java.lang.String r15 = "CertPathReviewer.policyConstExtError"
            java.lang.String r12 = "org.bouncycastle.x509.CertPathReviewerMessages"
            if (r11 >= 0) goto L_0x0213
            boolean r2 = isSelfIssued(r7)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r2 != 0) goto L_0x007c
            if (r8 <= 0) goto L_0x007c
            int r8 = r8 + -1
        L_0x007c:
            java.lang.String r2 = POLICY_CONSTRAINTS     // Catch:{ AnnotatedException -> 0x0206 }
            repack.org.bouncycastle.asn1.DERObject r2 = getExtensionValue(r7, r2)     // Catch:{ AnnotatedException -> 0x0206 }
            repack.org.bouncycastle.asn1.ASN1Sequence r2 = (repack.org.bouncycastle.asn1.ASN1Sequence) r2     // Catch:{ AnnotatedException -> 0x0206 }
            if (r2 == 0) goto L_0x00ae
            java.util.Enumeration r2 = r2.getObjects()     // Catch:{ AnnotatedException -> 0x0206 }
        L_0x008a:
            boolean r7 = r2.hasMoreElements()     // Catch:{ AnnotatedException -> 0x0206 }
            if (r7 != 0) goto L_0x0091
            goto L_0x00ae
        L_0x0091:
            java.lang.Object r7 = r2.nextElement()     // Catch:{ AnnotatedException -> 0x0206 }
            repack.org.bouncycastle.asn1.ASN1TaggedObject r7 = (repack.org.bouncycastle.asn1.ASN1TaggedObject) r7     // Catch:{ AnnotatedException -> 0x0206 }
            int r13 = r7.getTagNo()     // Catch:{ AnnotatedException -> 0x0206 }
            if (r13 == 0) goto L_0x009e
            goto L_0x008a
        L_0x009e:
            repack.org.bouncycastle.asn1.DERInteger r7 = repack.org.bouncycastle.asn1.DERInteger.getInstance(r7, r5)     // Catch:{ AnnotatedException -> 0x0206 }
            java.math.BigInteger r7 = r7.getValue()     // Catch:{ AnnotatedException -> 0x0206 }
            int r7 = r7.intValue()     // Catch:{ AnnotatedException -> 0x0206 }
            if (r7 != 0) goto L_0x008a
            r8 = 0
            goto L_0x008a
        L_0x00ae:
            java.lang.String r2 = "CertPathReviewer.explicitPolicy"
            if (r9 != 0) goto L_0x00ca
            java.security.cert.PKIXParameters r0 = r1.pkixParams     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r0 = r0.isExplicitPolicyRequired()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r0 != 0) goto L_0x00bd
            r9 = 0
            goto L_0x01a0
        L_0x00bd:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            r0.<init>(r12, r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.<init>(r0, r3, r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x00ca:
            boolean r7 = isAnyPolicy(r0)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r7 == 0) goto L_0x0166
            java.security.cert.PKIXParameters r0 = r1.pkixParams     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r0 = r0.isExplicitPolicyRequired()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r0 == 0) goto L_0x01a0
            boolean r0 = r10.isEmpty()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r0 != 0) goto L_0x0159
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x0600 }
            r0.<init>()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2 = 0
        L_0x00e4:
            int r7 = r3.length     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r2 < r7) goto L_0x0127
            java.util.Iterator r0 = r0.iterator()     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x00eb:
            boolean r2 = r0.hasNext()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r2 != 0) goto L_0x0119
            if (r9 == 0) goto L_0x01a0
            int r0 = r1.f6299n     // Catch:{ CertPathReviewerException -> 0x0600 }
            int r0 = r0 - r4
        L_0x00f6:
            if (r0 >= 0) goto L_0x00fa
            goto L_0x01a0
        L_0x00fa:
            r2 = r3[r0]     // Catch:{ CertPathReviewerException -> 0x0600 }
            r4 = 0
        L_0x00fd:
            int r6 = r2.size()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r4 < r6) goto L_0x0106
            int r0 = r0 + -1
            goto L_0x00f6
        L_0x0106:
            java.lang.Object r6 = r2.get(r4)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r6 = (repack.org.bouncycastle.jce.provider.PKIXPolicyNode) r6     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r7 = r6.hasChildren()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r7 != 0) goto L_0x0116
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r9 = removePolicyNode(r9, r3, r6)     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x0116:
            int r4 = r4 + 1
            goto L_0x00fd
        L_0x0119:
            java.lang.Object r2 = r0.next()     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r2 = (repack.org.bouncycastle.jce.provider.PKIXPolicyNode) r2     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r2 = r2.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r10.contains(r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
            goto L_0x00eb
        L_0x0127:
            r7 = r3[r2]     // Catch:{ CertPathReviewerException -> 0x0600 }
            r11 = 0
        L_0x012a:
            int r13 = r7.size()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r11 < r13) goto L_0x0133
            int r2 = r2 + 1
            goto L_0x00e4
        L_0x0133:
            java.lang.Object r13 = r7.get(r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r13 = (repack.org.bouncycastle.jce.provider.PKIXPolicyNode) r13     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r14 = r13.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r14 = r6.equals(r14)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r14 == 0) goto L_0x0156
            java.util.Iterator r13 = r13.getChildren()     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x0147:
            boolean r14 = r13.hasNext()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r14 != 0) goto L_0x014e
            goto L_0x0156
        L_0x014e:
            java.lang.Object r14 = r13.next()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r0.add(r14)     // Catch:{ CertPathReviewerException -> 0x0600 }
            goto L_0x0147
        L_0x0156:
            int r11 = r11 + 1
            goto L_0x012a
        L_0x0159:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            r0.<init>(r12, r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.<init>(r0, r3, r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x0166:
            java.util.HashSet r2 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.<init>()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r7 = 0
        L_0x016c:
            int r10 = r3.length     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r7 < r10) goto L_0x01c8
            java.util.Iterator r2 = r2.iterator()     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x0173:
            boolean r6 = r2.hasNext()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r6 != 0) goto L_0x01b3
            if (r9 == 0) goto L_0x01a0
            int r0 = r1.f6299n     // Catch:{ CertPathReviewerException -> 0x0600 }
            int r0 = r0 - r4
        L_0x017e:
            if (r0 >= 0) goto L_0x0181
            goto L_0x01a0
        L_0x0181:
            r2 = r3[r0]     // Catch:{ CertPathReviewerException -> 0x0600 }
            r4 = 0
        L_0x0184:
            int r6 = r2.size()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r4 < r6) goto L_0x018d
            int r0 = r0 + -1
            goto L_0x017e
        L_0x018d:
            java.lang.Object r6 = r2.get(r4)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r6 = (repack.org.bouncycastle.jce.provider.PKIXPolicyNode) r6     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r7 = r6.hasChildren()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r7 != 0) goto L_0x019d
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r9 = removePolicyNode(r9, r3, r6)     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x019d:
            int r4 = r4 + 1
            goto L_0x0184
        L_0x01a0:
            if (r8 > 0) goto L_0x060c
            if (r9 == 0) goto L_0x01a6
            goto L_0x060c
        L_0x01a6:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r2 = "CertPathReviewer.invalidPolicy"
            r0.<init>(r12, r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x01b3:
            java.lang.Object r6 = r2.next()     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r6 = (repack.org.bouncycastle.jce.provider.PKIXPolicyNode) r6     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r7 = r6.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r7 = r0.contains(r7)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r7 != 0) goto L_0x0173
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r9 = removePolicyNode(r9, r3, r6)     // Catch:{ CertPathReviewerException -> 0x0600 }
            goto L_0x0173
        L_0x01c8:
            r10 = r3[r7]     // Catch:{ CertPathReviewerException -> 0x0600 }
            r11 = 0
        L_0x01cb:
            int r13 = r10.size()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r11 < r13) goto L_0x01d4
            int r7 = r7 + 1
            goto L_0x016c
        L_0x01d4:
            java.lang.Object r13 = r10.get(r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r13 = (repack.org.bouncycastle.jce.provider.PKIXPolicyNode) r13     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r14 = r13.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r14 = r6.equals(r14)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r14 == 0) goto L_0x0203
            java.util.Iterator r13 = r13.getChildren()     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x01e8:
            boolean r14 = r13.hasNext()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r14 != 0) goto L_0x01ef
            goto L_0x0203
        L_0x01ef:
            java.lang.Object r14 = r13.next()     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r14 = (repack.org.bouncycastle.jce.provider.PKIXPolicyNode) r14     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r15 = r14.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r15 = r6.equals(r15)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r15 != 0) goto L_0x01e8
            r2.add(r14)     // Catch:{ CertPathReviewerException -> 0x0600 }
            goto L_0x01e8
        L_0x0203:
            int r11 = r11 + 1
            goto L_0x01cb
        L_0x0206:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            r0.<init>(r12, r15)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.<init>(r0, r3, r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x0213:
            int r7 = r1.f6299n     // Catch:{ CertPathReviewerException -> 0x0600 }
            int r7 = r7 - r11
            java.util.List r4 = r1.certs     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.Object r4 = r4.get(r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.security.cert.X509Certificate r4 = (java.security.cert.X509Certificate) r4     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r5 = CERTIFICATE_POLICIES     // Catch:{ AnnotatedException -> 0x05f1 }
            repack.org.bouncycastle.asn1.DERObject r5 = getExtensionValue(r4, r5)     // Catch:{ AnnotatedException -> 0x05f1 }
            repack.org.bouncycastle.asn1.ASN1Sequence r5 = (repack.org.bouncycastle.asn1.ASN1Sequence) r5     // Catch:{ AnnotatedException -> 0x05f1 }
            r24 = r15
            java.lang.String r15 = "CertPathReviewer.policyQualifierError"
            if (r5 == 0) goto L_0x03fc
            if (r9 == 0) goto L_0x03fc
            java.util.Enumeration r16 = r5.getObjects()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r25 = r0
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x0600 }
            r0.<init>()     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x0239:
            boolean r17 = r16.hasMoreElements()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r17 != 0) goto L_0x03b1
            if (r10 == 0) goto L_0x026f
            boolean r16 = r10.contains(r6)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r16 == 0) goto L_0x0248
            goto L_0x026f
        L_0x0248:
            java.util.Iterator r10 = r10.iterator()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r26 = r9
            java.util.HashSet r9 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x0600 }
            r9.<init>()     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x0253:
            boolean r16 = r10.hasNext()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r16 != 0) goto L_0x025d
            r27 = r2
            r0 = r9
            goto L_0x0273
        L_0x025d:
            r27 = r2
            java.lang.Object r2 = r10.next()     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r16 = r0.contains(r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r16 == 0) goto L_0x026c
            r9.add(r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x026c:
            r2 = r27
            goto L_0x0253
        L_0x026f:
            r27 = r2
            r26 = r9
        L_0x0273:
            if (r13 > 0) goto L_0x0283
            int r2 = r1.f6299n     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r7 >= r2) goto L_0x0280
            boolean r2 = isSelfIssued(r4)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r2 == 0) goto L_0x0280
            goto L_0x0283
        L_0x0280:
            r28 = r0
            goto L_0x02b9
        L_0x0283:
            java.util.Enumeration r2 = r5.getObjects()     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x0287:
            boolean r9 = r2.hasMoreElements()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r9 != 0) goto L_0x028e
            goto L_0x0280
        L_0x028e:
            java.lang.Object r9 = r2.nextElement()     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.asn1.x509.PolicyInformation r9 = repack.org.bouncycastle.asn1.x509.PolicyInformation.getInstance(r9)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.asn1.DERObjectIdentifier r10 = r9.getPolicyIdentifier()     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r10 = r10.getId()     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r10 = r6.equals(r10)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r10 == 0) goto L_0x0287
            repack.org.bouncycastle.asn1.ASN1Sequence r2 = r9.getPolicyQualifiers()     // Catch:{ CertPathValidatorException -> 0x03a3 }
            java.util.Set r2 = getQualifierSet(r2)     // Catch:{ CertPathValidatorException -> 0x03a3 }
            int r9 = r7 + -1
            r9 = r3[r9]     // Catch:{ CertPathReviewerException -> 0x0600 }
            r28 = r0
            r10 = 0
        L_0x02b3:
            int r0 = r9.size()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r10 < r0) goto L_0x0310
        L_0x02b9:
            int r0 = r7 + -1
        L_0x02bb:
            if (r0 >= 0) goto L_0x02e5
            java.util.Set r0 = r4.getCriticalExtensionOIDs()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r0 == 0) goto L_0x02df
            java.lang.String r2 = CERTIFICATE_POLICIES     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r0 = r0.contains(r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2 = r3[r7]     // Catch:{ CertPathReviewerException -> 0x0600 }
            r9 = 0
        L_0x02cc:
            int r10 = r2.size()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r9 < r10) goto L_0x02d3
            goto L_0x02df
        L_0x02d3:
            java.lang.Object r10 = r2.get(r9)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r10 = (repack.org.bouncycastle.jce.provider.PKIXPolicyNode) r10     // Catch:{ CertPathReviewerException -> 0x0600 }
            r10.setCritical(r0)     // Catch:{ CertPathReviewerException -> 0x0600 }
            int r9 = r9 + 1
            goto L_0x02cc
        L_0x02df:
            r29 = r13
            r10 = r28
            goto L_0x0404
        L_0x02e5:
            r2 = r3[r0]     // Catch:{ CertPathReviewerException -> 0x0600 }
            r29 = r13
            r10 = r26
            r9 = 0
        L_0x02ec:
            int r13 = r2.size()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r9 < r13) goto L_0x02f5
        L_0x02f2:
            r26 = r10
            goto L_0x0308
        L_0x02f5:
            java.lang.Object r13 = r2.get(r9)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r13 = (repack.org.bouncycastle.jce.provider.PKIXPolicyNode) r13     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r16 = r13.hasChildren()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r16 != 0) goto L_0x030d
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r10 = removePolicyNode(r10, r3, r13)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r10 != 0) goto L_0x030d
            goto L_0x02f2
        L_0x0308:
            int r0 = r0 + -1
            r13 = r29
            goto L_0x02bb
        L_0x030d:
            int r9 = r9 + 1
            goto L_0x02ec
        L_0x0310:
            r29 = r13
            java.lang.Object r0 = r9.get(r10)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r0 = (repack.org.bouncycastle.jce.provider.PKIXPolicyNode) r0     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.util.Set r13 = r0.getExpectedPolicies()     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.util.Iterator r13 = r13.iterator()     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x0320:
            boolean r16 = r13.hasNext()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r16 != 0) goto L_0x032b
            int r10 = r10 + 1
            r13 = r29
            goto L_0x02b3
        L_0x032b:
            r30 = r9
            java.lang.Object r9 = r13.next()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r31 = r10
            boolean r10 = r9 instanceof java.lang.String     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r10 == 0) goto L_0x033a
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ CertPathReviewerException -> 0x0600 }
            goto L_0x0344
        L_0x033a:
            boolean r10 = r9 instanceof repack.org.bouncycastle.asn1.DERObjectIdentifier     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r10 == 0) goto L_0x039d
            repack.org.bouncycastle.asn1.DERObjectIdentifier r9 = (repack.org.bouncycastle.asn1.DERObjectIdentifier) r9     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r9 = r9.getId()     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x0344:
            java.util.Iterator r10 = r0.getChildren()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r16 = 0
        L_0x034a:
            boolean r17 = r10.hasNext()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r17 != 0) goto L_0x0383
            if (r16 != 0) goto L_0x039d
            java.util.HashSet r10 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x0600 }
            r10.<init>()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r10.add(r9)     // Catch:{ CertPathReviewerException -> 0x0600 }
            r32 = r13
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r13 = new repack.org.bouncycastle.jce.provider.PKIXPolicyNode     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.util.ArrayList r17 = new java.util.ArrayList     // Catch:{ CertPathReviewerException -> 0x0600 }
            r17.<init>()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r23 = 0
            r16 = r13
            r18 = r7
            r19 = r10
            r20 = r0
            r21 = r2
            r22 = r9
            r16.<init>(r17, r18, r19, r20, r21, r22, r23)     // Catch:{ CertPathReviewerException -> 0x0600 }
            r0.addChild(r13)     // Catch:{ CertPathReviewerException -> 0x0600 }
            r9 = r3[r7]     // Catch:{ CertPathReviewerException -> 0x0600 }
            r9.add(r13)     // Catch:{ CertPathReviewerException -> 0x0600 }
            r9 = r30
            r10 = r31
            r13 = r32
            goto L_0x0320
        L_0x0383:
            r32 = r13
            java.lang.Object r13 = r10.next()     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r13 = (repack.org.bouncycastle.jce.provider.PKIXPolicyNode) r13     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r13 = r13.getValidPolicy()     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r13 = r9.equals(r13)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r13 == 0) goto L_0x039a
            r13 = r32
            r16 = 1
            goto L_0x034a
        L_0x039a:
            r13 = r32
            goto L_0x034a
        L_0x039d:
            r9 = r30
            r10 = r31
            goto L_0x0320
        L_0x03a3:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.<init>(r12, r15)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r3 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x0600 }
            r3.<init>(r2, r0, r4, r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x03b1:
            r27 = r2
            r26 = r9
            r29 = r13
            java.lang.Object r2 = r16.nextElement()     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.asn1.x509.PolicyInformation r2 = repack.org.bouncycastle.asn1.x509.PolicyInformation.getInstance(r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.asn1.DERObjectIdentifier r9 = r2.getPolicyIdentifier()     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r13 = r9.getId()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r0.add(r13)     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r13 = r9.getId()     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r13 = r6.equals(r13)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r13 != 0) goto L_0x03f4
            repack.org.bouncycastle.asn1.ASN1Sequence r2 = r2.getPolicyQualifiers()     // Catch:{ CertPathValidatorException -> 0x03e6 }
            java.util.Set r2 = getQualifierSet(r2)     // Catch:{ CertPathValidatorException -> 0x03e6 }
            boolean r13 = processCertD1i(r7, r3, r9, r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r13 != 0) goto L_0x03f4
            processCertD1ii(r7, r3, r9, r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
            goto L_0x03f4
        L_0x03e6:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.<init>(r12, r15)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r3 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x0600 }
            r3.<init>(r2, r0, r4, r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x03f4:
            r9 = r26
            r2 = r27
            r13 = r29
            goto L_0x0239
        L_0x03fc:
            r25 = r0
            r27 = r2
            r26 = r9
            r29 = r13
        L_0x0404:
            if (r5 != 0) goto L_0x0408
            r26 = 0
        L_0x0408:
            if (r8 > 0) goto L_0x041a
            if (r26 == 0) goto L_0x040d
            goto L_0x041a
        L_0x040d:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r2 = "CertPathReviewer.noValidPolicyTree"
            r0.<init>(r12, r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x041a:
            int r0 = r1.f6299n     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r7 == r0) goto L_0x05da
            java.lang.String r0 = POLICY_MAPPINGS     // Catch:{ AnnotatedException -> 0x05ca }
            repack.org.bouncycastle.asn1.DERObject r0 = getExtensionValue(r4, r0)     // Catch:{ AnnotatedException -> 0x05ca }
            if (r0 == 0) goto L_0x047c
            r2 = r0
            repack.org.bouncycastle.asn1.ASN1Sequence r2 = (repack.org.bouncycastle.asn1.ASN1Sequence) r2     // Catch:{ CertPathReviewerException -> 0x0600 }
            r5 = 0
        L_0x042a:
            int r9 = r2.size()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r5 < r9) goto L_0x0431
            goto L_0x047c
        L_0x0431:
            repack.org.bouncycastle.asn1.DEREncodable r9 = r2.getObjectAt(r5)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.asn1.ASN1Sequence r9 = (repack.org.bouncycastle.asn1.ASN1Sequence) r9     // Catch:{ CertPathReviewerException -> 0x0600 }
            r13 = 0
            repack.org.bouncycastle.asn1.DEREncodable r16 = r9.getObjectAt(r13)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.asn1.DERObjectIdentifier r16 = (repack.org.bouncycastle.asn1.DERObjectIdentifier) r16     // Catch:{ CertPathReviewerException -> 0x0600 }
            r13 = 1
            repack.org.bouncycastle.asn1.DEREncodable r9 = r9.getObjectAt(r13)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.asn1.DERObjectIdentifier r9 = (repack.org.bouncycastle.asn1.DERObjectIdentifier) r9     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r13 = r16.getId()     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r13 = r6.equals(r13)     // Catch:{ CertPathReviewerException -> 0x0600 }
            r16 = r2
            java.lang.String r2 = "CertPathReviewer.invalidPolicyMapping"
            if (r13 != 0) goto L_0x046f
            java.lang.String r9 = r9.getId()     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r9 = r6.equals(r9)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r9 != 0) goto L_0x0462
            int r5 = r5 + 1
            r2 = r16
            goto L_0x042a
        L_0x0462:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            r0.<init>(r12, r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.<init>(r0, r3, r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x046f:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            r0.<init>(r12, r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.<init>(r0, r3, r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x047c:
            if (r0 == 0) goto L_0x052c
            repack.org.bouncycastle.asn1.ASN1Sequence r0 = (repack.org.bouncycastle.asn1.ASN1Sequence) r0     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.<init>()     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.util.HashSet r5 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x0600 }
            r5.<init>()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r9 = 0
        L_0x048b:
            int r13 = r0.size()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r9 < r13) goto L_0x04dc
            java.util.Iterator r0 = r5.iterator()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r5 = r26
        L_0x0497:
            boolean r9 = r0.hasNext()     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r9 != 0) goto L_0x04a3
            r16 = r6
            r13 = r27
            goto L_0x0532
        L_0x04a3:
            java.lang.Object r9 = r0.next()     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r14 <= 0) goto L_0x04d1
            prepareNextCertB1(r7, r3, r9, r2, r4)     // Catch:{ AnnotatedException -> 0x04c0, CertPathValidatorException -> 0x04b1 }
            r13 = r27
            goto L_0x04d9
        L_0x04b1:
            r0 = move-exception
            r2 = r0
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            r0.<init>(r12, r15)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r3 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x0600 }
            r3.<init>(r0, r2, r4, r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x04c0:
            r0 = move-exception
            r2 = r0
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            r13 = r27
            r0.<init>(r12, r13)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r3 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x0600 }
            r3.<init>(r0, r2, r4, r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x04d1:
            r13 = r27
            if (r14 > 0) goto L_0x04d9
            repack.org.bouncycastle.jce.provider.PKIXPolicyNode r5 = prepareNextCertB2(r7, r3, r9, r5)     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x04d9:
            r27 = r13
            goto L_0x0497
        L_0x04dc:
            r13 = r27
            repack.org.bouncycastle.asn1.DEREncodable r16 = r0.getObjectAt(r9)     // Catch:{ CertPathReviewerException -> 0x0600 }
            r17 = r0
            r0 = r16
            repack.org.bouncycastle.asn1.ASN1Sequence r0 = (repack.org.bouncycastle.asn1.ASN1Sequence) r0     // Catch:{ CertPathReviewerException -> 0x0600 }
            r16 = r6
            r6 = 0
            repack.org.bouncycastle.asn1.DEREncodable r18 = r0.getObjectAt(r6)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.asn1.DERObjectIdentifier r18 = (repack.org.bouncycastle.asn1.DERObjectIdentifier) r18     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r6 = r18.getId()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r18 = r7
            r7 = 1
            repack.org.bouncycastle.asn1.DEREncodable r0 = r0.getObjectAt(r7)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.asn1.DERObjectIdentifier r0 = (repack.org.bouncycastle.asn1.DERObjectIdentifier) r0     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r0 = r0.getId()     // Catch:{ CertPathReviewerException -> 0x0600 }
            boolean r7 = r2.containsKey(r6)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r7 != 0) goto L_0x0517
            java.util.HashSet r7 = new java.util.HashSet     // Catch:{ CertPathReviewerException -> 0x0600 }
            r7.<init>()     // Catch:{ CertPathReviewerException -> 0x0600 }
            r7.add(r0)     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.put(r6, r7)     // Catch:{ CertPathReviewerException -> 0x0600 }
            r5.add(r6)     // Catch:{ CertPathReviewerException -> 0x0600 }
            goto L_0x0520
        L_0x0517:
            java.lang.Object r6 = r2.get(r6)     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.util.Set r6 = (java.util.Set) r6     // Catch:{ CertPathReviewerException -> 0x0600 }
            r6.add(r0)     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x0520:
            int r9 = r9 + 1
            r27 = r13
            r6 = r16
            r0 = r17
            r7 = r18
            goto L_0x048b
        L_0x052c:
            r16 = r6
            r13 = r27
            r5 = r26
        L_0x0532:
            boolean r0 = isSelfIssued(r4)     // Catch:{ CertPathReviewerException -> 0x0600 }
            if (r0 != 0) goto L_0x0545
            if (r8 == 0) goto L_0x053c
            int r8 = r8 + -1
        L_0x053c:
            if (r14 == 0) goto L_0x0540
            int r14 = r14 + -1
        L_0x0540:
            if (r29 == 0) goto L_0x0545
            int r0 = r29 + -1
            goto L_0x0547
        L_0x0545:
            r0 = r29
        L_0x0547:
            java.lang.String r2 = POLICY_CONSTRAINTS     // Catch:{ AnnotatedException -> 0x05bb }
            repack.org.bouncycastle.asn1.DERObject r2 = getExtensionValue(r4, r2)     // Catch:{ AnnotatedException -> 0x05bb }
            repack.org.bouncycastle.asn1.ASN1Sequence r2 = (repack.org.bouncycastle.asn1.ASN1Sequence) r2     // Catch:{ AnnotatedException -> 0x05bb }
            if (r2 == 0) goto L_0x0590
            java.util.Enumeration r2 = r2.getObjects()     // Catch:{ AnnotatedException -> 0x05bb }
        L_0x0555:
            boolean r6 = r2.hasMoreElements()     // Catch:{ AnnotatedException -> 0x05bb }
            if (r6 != 0) goto L_0x055c
            goto L_0x0590
        L_0x055c:
            java.lang.Object r6 = r2.nextElement()     // Catch:{ AnnotatedException -> 0x05bb }
            repack.org.bouncycastle.asn1.ASN1TaggedObject r6 = (repack.org.bouncycastle.asn1.ASN1TaggedObject) r6     // Catch:{ AnnotatedException -> 0x05bb }
            int r7 = r6.getTagNo()     // Catch:{ AnnotatedException -> 0x05bb }
            if (r7 == 0) goto L_0x057e
            r9 = 1
            if (r7 == r9) goto L_0x056d
        L_0x056b:
            r7 = 0
            goto L_0x0555
        L_0x056d:
            r7 = 0
            repack.org.bouncycastle.asn1.DERInteger r6 = repack.org.bouncycastle.asn1.DERInteger.getInstance(r6, r7)     // Catch:{ AnnotatedException -> 0x05bb }
            java.math.BigInteger r6 = r6.getValue()     // Catch:{ AnnotatedException -> 0x05bb }
            int r6 = r6.intValue()     // Catch:{ AnnotatedException -> 0x05bb }
            if (r6 >= r14) goto L_0x056b
            r14 = r6
            goto L_0x0555
        L_0x057e:
            r7 = 0
            r9 = 1
            repack.org.bouncycastle.asn1.DERInteger r6 = repack.org.bouncycastle.asn1.DERInteger.getInstance(r6, r7)     // Catch:{ AnnotatedException -> 0x05bb }
            java.math.BigInteger r6 = r6.getValue()     // Catch:{ AnnotatedException -> 0x05bb }
            int r6 = r6.intValue()     // Catch:{ AnnotatedException -> 0x05bb }
            if (r6 >= r8) goto L_0x0555
            r8 = r6
            goto L_0x0555
        L_0x0590:
            r7 = 0
            r9 = 1
            java.lang.String r2 = INHIBIT_ANY_POLICY     // Catch:{ AnnotatedException -> 0x05ac }
            repack.org.bouncycastle.asn1.DERObject r2 = getExtensionValue(r4, r2)     // Catch:{ AnnotatedException -> 0x05ac }
            repack.org.bouncycastle.asn1.DERInteger r2 = (repack.org.bouncycastle.asn1.DERInteger) r2     // Catch:{ AnnotatedException -> 0x05ac }
            if (r2 == 0) goto L_0x05a9
            java.math.BigInteger r2 = r2.getValue()     // Catch:{ AnnotatedException -> 0x05ac }
            int r2 = r2.intValue()     // Catch:{ AnnotatedException -> 0x05ac }
            if (r2 >= r0) goto L_0x05a9
            r29 = r2
            goto L_0x05e2
        L_0x05a9:
            r29 = r0
            goto L_0x05e2
        L_0x05ac:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r2 = "CertPathReviewer.policyInhibitExtError"
            r0.<init>(r12, r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.<init>(r0, r3, r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x05bb:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2 = r24
            r0.<init>(r12, r2)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.security.cert.CertPath r3 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.<init>(r0, r3, r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r2     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x05ca:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.lang.String r3 = "CertPathReviewer.policyMapExtError"
            r2.<init>(r12, r3)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r3 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x0600 }
            r3.<init>(r2, r0, r4, r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x05da:
            r16 = r6
            r13 = r27
            r7 = 0
            r9 = 1
            r5 = r26
        L_0x05e2:
            int r11 = r11 + -1
            r7 = r4
            r9 = r5
            r2 = r13
            r6 = r16
            r0 = r25
            r13 = r29
            r4 = 1
            r5 = 0
            goto L_0x006c
        L_0x05f1:
            r0 = move-exception
            r13 = r2
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x0600 }
            r2.<init>(r12, r13)     // Catch:{ CertPathReviewerException -> 0x0600 }
            repack.org.bouncycastle.x509.CertPathReviewerException r3 = new repack.org.bouncycastle.x509.CertPathReviewerException     // Catch:{ CertPathReviewerException -> 0x0600 }
            java.security.cert.CertPath r4 = r1.certPath     // Catch:{ CertPathReviewerException -> 0x0600 }
            r3.<init>(r2, r0, r4, r11)     // Catch:{ CertPathReviewerException -> 0x0600 }
            throw r3     // Catch:{ CertPathReviewerException -> 0x0600 }
        L_0x0600:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r2 = r0.getErrorMessage()
            int r0 = r0.getIndex()
            r1.addError(r2, r0)
        L_0x060c:
            return
        L_0x060d:
            r25 = r0
            r13 = r2
            r7 = 0
            r9 = 1
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3[r6] = r0
            int r6 = r6 + 1
            r0 = r25
            r4 = 1
            r5 = 0
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.x509.PKIXCertPathReviewer.checkPolicy():void");
    }

    private void checkCriticalExtensions() {
        int size;
        List<PKIXCertPathChecker> certPathCheckers = this.pkixParams.getCertPathCheckers();
        for (PKIXCertPathChecker init : certPathCheckers) {
            try {
                init.init(false);
            } catch (CertPathValidatorException e) {
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.certPathCheckerError", new Object[]{e.getMessage(), e, e.getClass().getName()}), e);
            } catch (CertPathValidatorException e2) {
                throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.criticalExtensionError", new Object[]{e2.getMessage(), e2, e2.getClass().getName()}), e2.getCause(), this.certPath, size);
            } catch (CertPathReviewerException e3) {
                addError(e3.getErrorMessage(), e3.getIndex());
                return;
            }
        }
        size = this.certs.size() - 1;
        while (size >= 0) {
            X509Certificate x509Certificate = (X509Certificate) this.certs.get(size);
            Set<String> criticalExtensionOIDs = x509Certificate.getCriticalExtensionOIDs();
            if (criticalExtensionOIDs != null) {
                if (!criticalExtensionOIDs.isEmpty()) {
                    criticalExtensionOIDs.remove(KEY_USAGE);
                    criticalExtensionOIDs.remove(CERTIFICATE_POLICIES);
                    criticalExtensionOIDs.remove(POLICY_MAPPINGS);
                    criticalExtensionOIDs.remove(INHIBIT_ANY_POLICY);
                    criticalExtensionOIDs.remove(ISSUING_DISTRIBUTION_POINT);
                    criticalExtensionOIDs.remove(DELTA_CRL_INDICATOR);
                    criticalExtensionOIDs.remove(POLICY_CONSTRAINTS);
                    criticalExtensionOIDs.remove(BASIC_CONSTRAINTS);
                    criticalExtensionOIDs.remove(SUBJECT_ALTERNATIVE_NAME);
                    criticalExtensionOIDs.remove(NAME_CONSTRAINTS);
                    if (criticalExtensionOIDs.contains(QC_STATEMENT) && processQcStatements(x509Certificate, size)) {
                        criticalExtensionOIDs.remove(QC_STATEMENT);
                    }
                    for (PKIXCertPathChecker check : certPathCheckers) {
                        check.check(x509Certificate, criticalExtensionOIDs);
                    }
                    if (!criticalExtensionOIDs.isEmpty()) {
                        for (String dERObjectIdentifier : criticalExtensionOIDs) {
                            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.unknownCriticalExt", new Object[]{new DERObjectIdentifier(dERObjectIdentifier)}), size);
                        }
                    }
                }
            }
            size--;
        }
    }

    private boolean processQcStatements(X509Certificate x509Certificate, int i) {
        ErrorBundle errorBundle;
        int i2 = i;
        try {
            ASN1Sequence aSN1Sequence = (ASN1Sequence) getExtensionValue(x509Certificate, QC_STATEMENT);
            boolean z = false;
            for (int i3 = 0; i3 < aSN1Sequence.size(); i3++) {
                QCStatement instance = QCStatement.getInstance(aSN1Sequence.getObjectAt(i3));
                if (QCStatement.id_etsi_qcs_QcCompliance.equals(instance.getStatementId())) {
                    addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcEuCompliance"), i2);
                } else if (!QCStatement.id_qcs_pkixQCSyntax_v1.equals(instance.getStatementId())) {
                    if (QCStatement.id_etsi_qcs_QcSSCD.equals(instance.getStatementId())) {
                        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcSSCD"), i2);
                    } else if (QCStatement.id_etsi_qcs_LimiteValue.equals(instance.getStatementId())) {
                        MonetaryValue instance2 = MonetaryValue.getInstance(instance.getStatementInfo());
                        instance2.getCurrency();
                        double doubleValue = instance2.getAmount().doubleValue() * Math.pow(10.0d, instance2.getExponent().doubleValue());
                        if (instance2.getCurrency().isAlphabetic()) {
                            errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueAlpha", new Object[]{instance2.getCurrency().getAlphabetic(), new TrustedInput(new Double(doubleValue)), instance2});
                        } else {
                            errorBundle = new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcLimitValueNum", new Object[]{new Integer(instance2.getCurrency().getNumeric()), new TrustedInput(new Double(doubleValue)), instance2});
                        }
                        addNotification(errorBundle, i2);
                    } else {
                        addNotification(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcUnknownStatement", new Object[]{instance.getStatementId(), new UntrustedInput(instance)}), i2);
                        z = true;
                    }
                }
            }
            return !z;
        } catch (AnnotatedException unused) {
            addError(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.QcStatementExtError"), i2);
            return false;
        }
    }

    private String IPtoString(byte[] bArr) {
        try {
            return InetAddress.getByAddress(bArr).getHostAddress();
        } catch (Exception unused) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i != bArr.length; i++) {
                stringBuffer.append(Integer.toHexString(bArr[i] & 255));
                stringBuffer.append(' ');
            }
            return stringBuffer.toString();
        }
    }

    /* access modifiers changed from: protected */
    public void checkRevocation(PKIXParameters pKIXParameters, X509Certificate x509Certificate, Date date, X509Certificate x509Certificate2, PublicKey publicKey, Vector vector, Vector vector2, int i) throws CertPathReviewerException {
        checkCRLs(pKIXParameters, x509Certificate, date, x509Certificate2, publicKey, vector, i);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x02d0  */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x02ed  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x02bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void checkCRLs(java.security.cert.PKIXParameters r22, java.security.cert.X509Certificate r23, java.util.Date r24, java.security.cert.X509Certificate r25, java.security.PublicKey r26, java.util.Vector r27, int r28) throws repack.org.bouncycastle.x509.CertPathReviewerException {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            r3 = r23
            r4 = r26
            r5 = r28
            java.lang.String r6 = "CertPathReviewer.distrPtExtError"
            java.lang.String r7 = "CertPathReviewer.crlExtractionError"
            java.lang.String r8 = "CertPathReviewer.crlIssuerException"
            java.lang.String r9 = "org.bouncycastle.x509.CertPathReviewerMessages"
            repack.org.bouncycastle.x509.X509CRLStoreSelector r0 = new repack.org.bouncycastle.x509.X509CRLStoreSelector
            r0.<init>()
            javax.security.auth.x500.X500Principal r10 = getEncodedIssuerPrincipal(r23)     // Catch:{ IOException -> 0x04a1 }
            byte[] r10 = r10.getEncoded()     // Catch:{ IOException -> 0x04a1 }
            r0.addIssuerName(r10)     // Catch:{ IOException -> 0x04a1 }
            r0.setCertificateChecking(r3)
            r10 = 3
            repack.org.bouncycastle.jce.provider.PKIXCRLUtil r14 = CRL_UTIL     // Catch:{ AnnotatedException -> 0x0098 }
            java.util.Set r14 = r14.findCRLs((repack.org.bouncycastle.x509.X509CRLStoreSelector) r0, (java.security.cert.PKIXParameters) r2)     // Catch:{ AnnotatedException -> 0x0098 }
            java.util.Iterator r15 = r14.iterator()     // Catch:{ AnnotatedException -> 0x0098 }
            boolean r14 = r14.isEmpty()     // Catch:{ AnnotatedException -> 0x0098 }
            if (r14 == 0) goto L_0x0093
            repack.org.bouncycastle.jce.provider.PKIXCRLUtil r14 = CRL_UTIL     // Catch:{ AnnotatedException -> 0x0098 }
            repack.org.bouncycastle.x509.X509CRLStoreSelector r11 = new repack.org.bouncycastle.x509.X509CRLStoreSelector     // Catch:{ AnnotatedException -> 0x0098 }
            r11.<init>()     // Catch:{ AnnotatedException -> 0x0098 }
            java.util.Set r11 = r14.findCRLs((repack.org.bouncycastle.x509.X509CRLStoreSelector) r11, (java.security.cert.PKIXParameters) r2)     // Catch:{ AnnotatedException -> 0x0098 }
            java.util.Iterator r11 = r11.iterator()     // Catch:{ AnnotatedException -> 0x0098 }
            java.util.ArrayList r14 = new java.util.ArrayList     // Catch:{ AnnotatedException -> 0x0098 }
            r14.<init>()     // Catch:{ AnnotatedException -> 0x0098 }
        L_0x004a:
            boolean r16 = r11.hasNext()     // Catch:{ AnnotatedException -> 0x0098 }
            if (r16 != 0) goto L_0x0080
            int r11 = r14.size()     // Catch:{ AnnotatedException -> 0x0098 }
            repack.org.bouncycastle.i18n.ErrorBundle r13 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ AnnotatedException -> 0x0098 }
            java.lang.String r12 = "CertPathReviewer.noCrlInCertstore"
            r18 = r15
            java.lang.Object[] r15 = new java.lang.Object[r10]     // Catch:{ AnnotatedException -> 0x0098 }
            repack.org.bouncycastle.i18n.filter.UntrustedInput r10 = new repack.org.bouncycastle.i18n.filter.UntrustedInput     // Catch:{ AnnotatedException -> 0x0098 }
            java.util.Collection r0 = r0.getIssuerNames()     // Catch:{ AnnotatedException -> 0x0098 }
            r10.<init>(r0)     // Catch:{ AnnotatedException -> 0x0098 }
            r17 = 0
            r15[r17] = r10     // Catch:{ AnnotatedException -> 0x0098 }
            repack.org.bouncycastle.i18n.filter.UntrustedInput r0 = new repack.org.bouncycastle.i18n.filter.UntrustedInput     // Catch:{ AnnotatedException -> 0x0098 }
            r0.<init>(r14)     // Catch:{ AnnotatedException -> 0x0098 }
            r10 = 1
            r15[r10] = r0     // Catch:{ AnnotatedException -> 0x0098 }
            java.lang.Integer r0 = new java.lang.Integer     // Catch:{ AnnotatedException -> 0x0098 }
            r0.<init>(r11)     // Catch:{ AnnotatedException -> 0x0098 }
            r10 = 2
            r15[r10] = r0     // Catch:{ AnnotatedException -> 0x0098 }
            r13.<init>((java.lang.String) r9, (java.lang.String) r12, (java.lang.Object[]) r15)     // Catch:{ AnnotatedException -> 0x0098 }
            r1.addNotification(r13, r5)     // Catch:{ AnnotatedException -> 0x0098 }
            goto L_0x0095
        L_0x0080:
            r18 = r15
            java.lang.Object r10 = r11.next()     // Catch:{ AnnotatedException -> 0x0098 }
            java.security.cert.X509CRL r10 = (java.security.cert.X509CRL) r10     // Catch:{ AnnotatedException -> 0x0098 }
            javax.security.auth.x500.X500Principal r10 = r10.getIssuerX500Principal()     // Catch:{ AnnotatedException -> 0x0098 }
            r14.add(r10)     // Catch:{ AnnotatedException -> 0x0098 }
            r15 = r18
            r10 = 3
            goto L_0x004a
        L_0x0093:
            r18 = r15
        L_0x0095:
            r15 = r18
            goto L_0x00ce
        L_0x0098:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r10 = new repack.org.bouncycastle.i18n.ErrorBundle
            r11 = 3
            java.lang.Object[] r12 = new java.lang.Object[r11]
            java.lang.Throwable r11 = r0.getCause()
            java.lang.String r11 = r11.getMessage()
            r13 = 0
            r12[r13] = r11
            java.lang.Throwable r11 = r0.getCause()
            r13 = 1
            r12[r13] = r11
            java.lang.Throwable r0 = r0.getCause()
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r11 = 2
            r12[r11] = r0
            r10.<init>((java.lang.String) r9, (java.lang.String) r7, (java.lang.Object[]) r12)
            r1.addError(r10, r5)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r15 = r0.iterator()
        L_0x00ce:
            r0 = 0
        L_0x00cf:
            boolean r11 = r15.hasNext()
            if (r11 != 0) goto L_0x00d8
            r11 = r0
            r13 = 0
            goto L_0x0141
        L_0x00d8:
            java.lang.Object r0 = r15.next()
            java.security.cert.X509CRL r0 = (java.security.cert.X509CRL) r0
            java.util.Date r11 = r0.getNextUpdate()
            if (r11 == 0) goto L_0x011a
            java.util.Date r11 = new java.util.Date
            r11.<init>()
            java.util.Date r12 = r0.getNextUpdate()
            boolean r11 = r11.before(r12)
            if (r11 == 0) goto L_0x00f4
            goto L_0x011a
        L_0x00f4:
            repack.org.bouncycastle.i18n.ErrorBundle r11 = new repack.org.bouncycastle.i18n.ErrorBundle
            r12 = 2
            java.lang.Object[] r13 = new java.lang.Object[r12]
            repack.org.bouncycastle.i18n.filter.TrustedInput r12 = new repack.org.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r14 = r0.getThisUpdate()
            r12.<init>(r14)
            r14 = 0
            r13[r14] = r12
            repack.org.bouncycastle.i18n.filter.TrustedInput r12 = new repack.org.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r14 = r0.getNextUpdate()
            r12.<init>(r14)
            r14 = 1
            r13[r14] = r12
            java.lang.String r12 = "CertPathReviewer.localInvalidCRL"
            r11.<init>((java.lang.String) r9, (java.lang.String) r12, (java.lang.Object[]) r13)
            r1.addNotification(r11, r5)
            goto L_0x00cf
        L_0x011a:
            repack.org.bouncycastle.i18n.ErrorBundle r11 = new repack.org.bouncycastle.i18n.ErrorBundle
            r12 = 2
            java.lang.Object[] r13 = new java.lang.Object[r12]
            repack.org.bouncycastle.i18n.filter.TrustedInput r12 = new repack.org.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r14 = r0.getThisUpdate()
            r12.<init>(r14)
            r14 = 0
            r13[r14] = r12
            repack.org.bouncycastle.i18n.filter.TrustedInput r12 = new repack.org.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r14 = r0.getNextUpdate()
            r12.<init>(r14)
            r14 = 1
            r13[r14] = r12
            java.lang.String r12 = "CertPathReviewer.localValidCRL"
            r11.<init>((java.lang.String) r9, (java.lang.String) r12, (java.lang.Object[]) r13)
            r1.addNotification(r11, r5)
            r11 = r0
            r13 = 1
        L_0x0141:
            if (r13 != 0) goto L_0x0253
            java.util.Iterator r12 = r27.iterator()
        L_0x0147:
            boolean r0 = r12.hasNext()
            if (r0 != 0) goto L_0x014f
            goto L_0x0255
        L_0x014f:
            java.lang.Object r0 = r12.next()     // Catch:{ CertPathReviewerException -> 0x023f }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ CertPathReviewerException -> 0x023f }
            java.security.cert.X509CRL r14 = r1.getCRL(r0)     // Catch:{ CertPathReviewerException -> 0x023f }
            if (r14 == 0) goto L_0x0231
            javax.security.auth.x500.X500Principal r15 = r23.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x023f }
            javax.security.auth.x500.X500Principal r10 = r14.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x023f }
            boolean r10 = r15.equals(r10)     // Catch:{ CertPathReviewerException -> 0x023f }
            if (r10 != 0) goto L_0x01ae
            repack.org.bouncycastle.i18n.ErrorBundle r10 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x01a7 }
            java.lang.String r15 = "CertPathReviewer.onlineCRLWrongCA"
            r19 = r11
            r27 = r12
            r11 = 3
            java.lang.Object[] r12 = new java.lang.Object[r11]     // Catch:{ CertPathReviewerException -> 0x01a4 }
            repack.org.bouncycastle.i18n.filter.UntrustedInput r11 = new repack.org.bouncycastle.i18n.filter.UntrustedInput     // Catch:{ CertPathReviewerException -> 0x01a4 }
            javax.security.auth.x500.X500Principal r14 = r14.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x01a4 }
            java.lang.String r14 = r14.getName()     // Catch:{ CertPathReviewerException -> 0x01a4 }
            r11.<init>(r14)     // Catch:{ CertPathReviewerException -> 0x01a4 }
            r14 = 0
            r12[r14] = r11     // Catch:{ CertPathReviewerException -> 0x01a4 }
            repack.org.bouncycastle.i18n.filter.UntrustedInput r11 = new repack.org.bouncycastle.i18n.filter.UntrustedInput     // Catch:{ CertPathReviewerException -> 0x01a4 }
            javax.security.auth.x500.X500Principal r14 = r23.getIssuerX500Principal()     // Catch:{ CertPathReviewerException -> 0x01a4 }
            java.lang.String r14 = r14.getName()     // Catch:{ CertPathReviewerException -> 0x01a4 }
            r11.<init>(r14)     // Catch:{ CertPathReviewerException -> 0x01a4 }
            r14 = 1
            r12[r14] = r11     // Catch:{ CertPathReviewerException -> 0x01a4 }
            repack.org.bouncycastle.i18n.filter.UntrustedUrlInput r11 = new repack.org.bouncycastle.i18n.filter.UntrustedUrlInput     // Catch:{ CertPathReviewerException -> 0x01a4 }
            r11.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x01a4 }
            r14 = 2
            r12[r14] = r11     // Catch:{ CertPathReviewerException -> 0x01a4 }
            r10.<init>((java.lang.String) r9, (java.lang.String) r15, (java.lang.Object[]) r12)     // Catch:{ CertPathReviewerException -> 0x01a4 }
            r1.addNotification(r10, r5)     // Catch:{ CertPathReviewerException -> 0x01a4 }
            goto L_0x0235
        L_0x01a4:
            r0 = move-exception
            goto L_0x0246
        L_0x01a7:
            r0 = move-exception
            r19 = r11
            r27 = r12
            goto L_0x0246
        L_0x01ae:
            r19 = r11
            r27 = r12
            java.util.Date r10 = r14.getNextUpdate()     // Catch:{ CertPathReviewerException -> 0x022f }
            if (r10 == 0) goto L_0x01fc
            java.util.Date r10 = new java.util.Date     // Catch:{ CertPathReviewerException -> 0x022f }
            r10.<init>()     // Catch:{ CertPathReviewerException -> 0x022f }
            java.util.Date r11 = r14.getNextUpdate()     // Catch:{ CertPathReviewerException -> 0x022f }
            boolean r10 = r10.before(r11)     // Catch:{ CertPathReviewerException -> 0x022f }
            if (r10 == 0) goto L_0x01c8
            goto L_0x01fc
        L_0x01c8:
            repack.org.bouncycastle.i18n.ErrorBundle r10 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x022f }
            java.lang.String r11 = "CertPathReviewer.onlineInvalidCRL"
            r12 = 3
            java.lang.Object[] r15 = new java.lang.Object[r12]     // Catch:{ CertPathReviewerException -> 0x022f }
            repack.org.bouncycastle.i18n.filter.TrustedInput r12 = new repack.org.bouncycastle.i18n.filter.TrustedInput     // Catch:{ CertPathReviewerException -> 0x022f }
            r20 = r13
            java.util.Date r13 = r14.getThisUpdate()     // Catch:{ CertPathReviewerException -> 0x01f8 }
            r12.<init>(r13)     // Catch:{ CertPathReviewerException -> 0x01f8 }
            r13 = 0
            r15[r13] = r12     // Catch:{ CertPathReviewerException -> 0x01f8 }
            repack.org.bouncycastle.i18n.filter.TrustedInput r12 = new repack.org.bouncycastle.i18n.filter.TrustedInput     // Catch:{ CertPathReviewerException -> 0x01f8 }
            java.util.Date r13 = r14.getNextUpdate()     // Catch:{ CertPathReviewerException -> 0x01f8 }
            r12.<init>(r13)     // Catch:{ CertPathReviewerException -> 0x01f8 }
            r13 = 1
            r15[r13] = r12     // Catch:{ CertPathReviewerException -> 0x01f8 }
            repack.org.bouncycastle.i18n.filter.UntrustedUrlInput r12 = new repack.org.bouncycastle.i18n.filter.UntrustedUrlInput     // Catch:{ CertPathReviewerException -> 0x01f8 }
            r12.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x01f8 }
            r13 = 2
            r15[r13] = r12     // Catch:{ CertPathReviewerException -> 0x01f8 }
            r10.<init>((java.lang.String) r9, (java.lang.String) r11, (java.lang.Object[]) r15)     // Catch:{ CertPathReviewerException -> 0x01f8 }
            r1.addNotification(r10, r5)     // Catch:{ CertPathReviewerException -> 0x01f8 }
            goto L_0x0237
        L_0x01f8:
            r0 = move-exception
            r13 = r20
            goto L_0x0246
        L_0x01fc:
            repack.org.bouncycastle.i18n.ErrorBundle r10 = new repack.org.bouncycastle.i18n.ErrorBundle     // Catch:{ CertPathReviewerException -> 0x022c }
            java.lang.String r11 = "CertPathReviewer.onlineValidCRL"
            r12 = 3
            java.lang.Object[] r13 = new java.lang.Object[r12]     // Catch:{ CertPathReviewerException -> 0x022c }
            repack.org.bouncycastle.i18n.filter.TrustedInput r15 = new repack.org.bouncycastle.i18n.filter.TrustedInput     // Catch:{ CertPathReviewerException -> 0x022c }
            java.util.Date r12 = r14.getThisUpdate()     // Catch:{ CertPathReviewerException -> 0x022c }
            r15.<init>(r12)     // Catch:{ CertPathReviewerException -> 0x022c }
            r12 = 0
            r13[r12] = r15     // Catch:{ CertPathReviewerException -> 0x022c }
            repack.org.bouncycastle.i18n.filter.TrustedInput r12 = new repack.org.bouncycastle.i18n.filter.TrustedInput     // Catch:{ CertPathReviewerException -> 0x022c }
            java.util.Date r15 = r14.getNextUpdate()     // Catch:{ CertPathReviewerException -> 0x022c }
            r12.<init>(r15)     // Catch:{ CertPathReviewerException -> 0x022c }
            r15 = 1
            r13[r15] = r12     // Catch:{ CertPathReviewerException -> 0x022c }
            repack.org.bouncycastle.i18n.filter.UntrustedUrlInput r12 = new repack.org.bouncycastle.i18n.filter.UntrustedUrlInput     // Catch:{ CertPathReviewerException -> 0x022c }
            r12.<init>(r0)     // Catch:{ CertPathReviewerException -> 0x022c }
            r15 = 2
            r13[r15] = r12     // Catch:{ CertPathReviewerException -> 0x022c }
            r10.<init>((java.lang.String) r9, (java.lang.String) r11, (java.lang.Object[]) r13)     // Catch:{ CertPathReviewerException -> 0x022c }
            r1.addNotification(r10, r5)     // Catch:{ CertPathReviewerException -> 0x022c }
            r11 = r14
            r13 = 1
            goto L_0x0255
        L_0x022c:
            r0 = move-exception
            r13 = 1
            goto L_0x0246
        L_0x022f:
            r0 = move-exception
            goto L_0x0244
        L_0x0231:
            r19 = r11
            r27 = r12
        L_0x0235:
            r20 = r13
        L_0x0237:
            r12 = r27
            r11 = r19
            r13 = r20
            goto L_0x0147
        L_0x023f:
            r0 = move-exception
            r19 = r11
            r27 = r12
        L_0x0244:
            r20 = r13
        L_0x0246:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = r0.getErrorMessage()
            r1.addNotification(r0, r5)
            r12 = r27
            r11 = r19
            goto L_0x0147
        L_0x0253:
            r19 = r11
        L_0x0255:
            if (r11 == 0) goto L_0x0491
            r0 = 7
            if (r25 == 0) goto L_0x0276
            boolean[] r10 = r25.getKeyUsage()
            if (r10 == 0) goto L_0x0276
            int r12 = r10.length
            if (r12 < r0) goto L_0x0269
            r12 = 6
            boolean r10 = r10[r12]
            if (r10 == 0) goto L_0x0269
            goto L_0x0276
        L_0x0269:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.noCrlSigningPermited"
            r0.<init>(r9, r2)
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x0276:
            if (r4 == 0) goto L_0x0484
            java.lang.String r10 = "BC"
            r11.verify(r4, r10)     // Catch:{ Exception -> 0x0476 }
            java.math.BigInteger r4 = r23.getSerialNumber()
            java.security.cert.X509CRLEntry r4 = r11.getRevokedCertificate(r4)
            if (r4 == 0) goto L_0x030c
            boolean r10 = r4.hasExtensions()
            if (r10 == 0) goto L_0x02b8
            repack.org.bouncycastle.asn1.ASN1ObjectIdentifier r10 = repack.org.bouncycastle.asn1.x509.X509Extensions.ReasonCode     // Catch:{ AnnotatedException -> 0x02aa }
            java.lang.String r10 = r10.getId()     // Catch:{ AnnotatedException -> 0x02aa }
            repack.org.bouncycastle.asn1.DERObject r10 = getExtensionValue(r4, r10)     // Catch:{ AnnotatedException -> 0x02aa }
            repack.org.bouncycastle.asn1.DEREnumerated r10 = repack.org.bouncycastle.asn1.DEREnumerated.getInstance(r10)     // Catch:{ AnnotatedException -> 0x02aa }
            if (r10 == 0) goto L_0x02b8
            java.lang.String[] r12 = crlReasons
            java.math.BigInteger r10 = r10.getValue()
            int r10 = r10.intValue()
            r10 = r12[r10]
            goto L_0x02b9
        L_0x02aa:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r3 = "CertPathReviewer.crlReasonExtError"
            r2.<init>(r9, r3)
            repack.org.bouncycastle.x509.CertPathReviewerException r3 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x02b8:
            r10 = 0
        L_0x02b9:
            if (r10 != 0) goto L_0x02bf
            java.lang.String[] r10 = crlReasons
            r10 = r10[r0]
        L_0x02bf:
            repack.org.bouncycastle.i18n.LocaleString r0 = new repack.org.bouncycastle.i18n.LocaleString
            r0.<init>(r9, r10)
            java.util.Date r10 = r4.getRevocationDate()
            r12 = r24
            boolean r10 = r12.before(r10)
            if (r10 == 0) goto L_0x02ed
            repack.org.bouncycastle.i18n.ErrorBundle r10 = new repack.org.bouncycastle.i18n.ErrorBundle
            r12 = 2
            java.lang.Object[] r12 = new java.lang.Object[r12]
            repack.org.bouncycastle.i18n.filter.TrustedInput r14 = new repack.org.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r4 = r4.getRevocationDate()
            r14.<init>(r4)
            r15 = 0
            r12[r15] = r14
            r14 = 1
            r12[r14] = r0
            java.lang.String r0 = "CertPathReviewer.revokedAfterValidation"
            r10.<init>((java.lang.String) r9, (java.lang.String) r0, (java.lang.Object[]) r12)
            r1.addNotification(r10, r5)
            goto L_0x0316
        L_0x02ed:
            r12 = 2
            r14 = 1
            r15 = 0
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.Object[] r3 = new java.lang.Object[r12]
            repack.org.bouncycastle.i18n.filter.TrustedInput r5 = new repack.org.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r4 = r4.getRevocationDate()
            r5.<init>(r4)
            r3[r15] = r5
            r3[r14] = r0
            java.lang.String r0 = "CertPathReviewer.certRevoked"
            r2.<init>((java.lang.String) r9, (java.lang.String) r0, (java.lang.Object[]) r3)
            repack.org.bouncycastle.x509.CertPathReviewerException r0 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r0.<init>(r2)
            throw r0
        L_0x030c:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r4 = "CertPathReviewer.notRevoked"
            r0.<init>(r9, r4)
            r1.addNotification(r0, r5)
        L_0x0316:
            java.util.Date r0 = r11.getNextUpdate()
            if (r0 == 0) goto L_0x0346
            java.util.Date r0 = r11.getNextUpdate()
            java.util.Date r4 = new java.util.Date
            r4.<init>()
            boolean r0 = r0.before(r4)
            if (r0 == 0) goto L_0x0346
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            r4 = 1
            java.lang.Object[] r10 = new java.lang.Object[r4]
            repack.org.bouncycastle.i18n.filter.TrustedInput r12 = new repack.org.bouncycastle.i18n.filter.TrustedInput
            java.util.Date r14 = r11.getNextUpdate()
            r12.<init>(r14)
            r17 = 0
            r10[r17] = r12
            java.lang.String r12 = "CertPathReviewer.crlUpdateAvailable"
            r0.<init>((java.lang.String) r9, (java.lang.String) r12, (java.lang.Object[]) r10)
            r1.addNotification(r0, r5)
            goto L_0x0349
        L_0x0346:
            r4 = 1
            r17 = 0
        L_0x0349:
            java.lang.String r0 = ISSUING_DISTRIBUTION_POINT     // Catch:{ AnnotatedException -> 0x046b }
            repack.org.bouncycastle.asn1.DERObject r0 = getExtensionValue(r11, r0)     // Catch:{ AnnotatedException -> 0x046b }
            java.lang.String r5 = DELTA_CRL_INDICATOR     // Catch:{ AnnotatedException -> 0x045e }
            repack.org.bouncycastle.asn1.DERObject r5 = getExtensionValue(r11, r5)     // Catch:{ AnnotatedException -> 0x045e }
            if (r5 == 0) goto L_0x03f4
            repack.org.bouncycastle.x509.X509CRLStoreSelector r10 = new repack.org.bouncycastle.x509.X509CRLStoreSelector
            r10.<init>()
            javax.security.auth.x500.X500Principal r12 = getIssuerPrincipal(r11)     // Catch:{ IOException -> 0x03e8 }
            byte[] r12 = r12.getEncoded()     // Catch:{ IOException -> 0x03e8 }
            r10.addIssuerName(r12)     // Catch:{ IOException -> 0x03e8 }
            repack.org.bouncycastle.asn1.DERInteger r5 = (repack.org.bouncycastle.asn1.DERInteger) r5
            java.math.BigInteger r5 = r5.getPositiveValue()
            r10.setMinCRLNumber(r5)
            java.lang.String r5 = CRL_NUMBER     // Catch:{ AnnotatedException -> 0x03da }
            repack.org.bouncycastle.asn1.DERObject r5 = getExtensionValue(r11, r5)     // Catch:{ AnnotatedException -> 0x03da }
            repack.org.bouncycastle.asn1.DERInteger r5 = (repack.org.bouncycastle.asn1.DERInteger) r5     // Catch:{ AnnotatedException -> 0x03da }
            java.math.BigInteger r5 = r5.getPositiveValue()     // Catch:{ AnnotatedException -> 0x03da }
            r11 = 1
            java.math.BigInteger r8 = java.math.BigInteger.valueOf(r11)     // Catch:{ AnnotatedException -> 0x03da }
            java.math.BigInteger r5 = r5.subtract(r8)     // Catch:{ AnnotatedException -> 0x03da }
            r10.setMaxCRLNumber(r5)     // Catch:{ AnnotatedException -> 0x03da }
            repack.org.bouncycastle.jce.provider.PKIXCRLUtil r5 = CRL_UTIL     // Catch:{ AnnotatedException -> 0x03ce }
            java.util.Set r2 = r5.findCRLs((repack.org.bouncycastle.x509.X509CRLStoreSelector) r10, (java.security.cert.PKIXParameters) r2)     // Catch:{ AnnotatedException -> 0x03ce }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ AnnotatedException -> 0x03ce }
        L_0x0393:
            boolean r5 = r2.hasNext()
            if (r5 != 0) goto L_0x039b
            r4 = 0
            goto L_0x03b2
        L_0x039b:
            java.lang.Object r5 = r2.next()
            java.security.cert.X509CRL r5 = (java.security.cert.X509CRL) r5
            java.lang.String r7 = ISSUING_DISTRIBUTION_POINT     // Catch:{ AnnotatedException -> 0x03c2 }
            repack.org.bouncycastle.asn1.DERObject r5 = getExtensionValue(r5, r7)     // Catch:{ AnnotatedException -> 0x03c2 }
            if (r0 != 0) goto L_0x03ac
            if (r5 != 0) goto L_0x0393
            goto L_0x03b2
        L_0x03ac:
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L_0x0393
        L_0x03b2:
            if (r4 == 0) goto L_0x03b5
            goto L_0x03f4
        L_0x03b5:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.noBaseCRL"
            r0.<init>(r9, r2)
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x03c2:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle
            r2.<init>(r9, r6)
            repack.org.bouncycastle.x509.CertPathReviewerException r3 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x03ce:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle
            r2.<init>(r9, r7)
            repack.org.bouncycastle.x509.CertPathReviewerException r3 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x03da:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r3 = "CertPathReviewer.crlNbrExtError"
            r2.<init>(r9, r3)
            repack.org.bouncycastle.x509.CertPathReviewerException r3 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x03e8:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle
            r2.<init>(r9, r8)
            repack.org.bouncycastle.x509.CertPathReviewerException r3 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x03f4:
            if (r0 == 0) goto L_0x0491
            repack.org.bouncycastle.asn1.x509.IssuingDistributionPoint r0 = repack.org.bouncycastle.asn1.x509.IssuingDistributionPoint.getInstance(r0)
            java.lang.String r2 = BASIC_CONSTRAINTS     // Catch:{ AnnotatedException -> 0x0450 }
            repack.org.bouncycastle.asn1.DERObject r2 = getExtensionValue(r3, r2)     // Catch:{ AnnotatedException -> 0x0450 }
            repack.org.bouncycastle.asn1.x509.BasicConstraints r2 = repack.org.bouncycastle.asn1.x509.BasicConstraints.getInstance(r2)     // Catch:{ AnnotatedException -> 0x0450 }
            boolean r3 = r0.onlyContainsUserCerts()
            if (r3 == 0) goto L_0x0420
            if (r2 == 0) goto L_0x0420
            boolean r3 = r2.isCA()
            if (r3 != 0) goto L_0x0413
            goto L_0x0420
        L_0x0413:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.crlOnlyUserCert"
            r0.<init>(r9, r2)
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x0420:
            boolean r3 = r0.onlyContainsCACerts()
            if (r3 == 0) goto L_0x043c
            if (r2 == 0) goto L_0x042f
            boolean r2 = r2.isCA()
            if (r2 == 0) goto L_0x042f
            goto L_0x043c
        L_0x042f:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.crlOnlyCaCert"
            r0.<init>(r9, r2)
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x043c:
            boolean r0 = r0.onlyContainsAttributeCerts()
            if (r0 != 0) goto L_0x0443
            goto L_0x0491
        L_0x0443:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.crlOnlyAttrCert"
            r0.<init>(r9, r2)
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x0450:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r3 = "CertPathReviewer.crlBCExtError"
            r2.<init>(r9, r3)
            repack.org.bouncycastle.x509.CertPathReviewerException r3 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x045e:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.deltaCrlExtError"
            r0.<init>(r9, r2)
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x046b:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            r0.<init>(r9, r6)
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x0476:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r3 = "CertPathReviewer.crlVerifyFailed"
            r2.<init>(r9, r3)
            repack.org.bouncycastle.x509.CertPathReviewerException r3 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        L_0x0484:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.crlNoIssuerPublicKey"
            r0.<init>(r9, r2)
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x0491:
            if (r13 == 0) goto L_0x0494
            return
        L_0x0494:
            repack.org.bouncycastle.i18n.ErrorBundle r0 = new repack.org.bouncycastle.i18n.ErrorBundle
            java.lang.String r2 = "CertPathReviewer.noValidCrlFound"
            r0.<init>(r9, r2)
            repack.org.bouncycastle.x509.CertPathReviewerException r2 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r2.<init>(r0)
            throw r2
        L_0x04a1:
            r0 = move-exception
            repack.org.bouncycastle.i18n.ErrorBundle r2 = new repack.org.bouncycastle.i18n.ErrorBundle
            r2.<init>(r9, r8)
            repack.org.bouncycastle.x509.CertPathReviewerException r3 = new repack.org.bouncycastle.x509.CertPathReviewerException
            r3.<init>(r2, r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.x509.PKIXCertPathReviewer.checkCRLs(java.security.cert.PKIXParameters, java.security.cert.X509Certificate, java.util.Date, java.security.cert.X509Certificate, java.security.PublicKey, java.util.Vector, int):void");
    }

    /* access modifiers changed from: protected */
    public Vector getCRLDistUrls(CRLDistPoint cRLDistPoint) {
        Vector vector = new Vector();
        if (cRLDistPoint != null) {
            DistributionPoint[] distributionPoints = cRLDistPoint.getDistributionPoints();
            for (DistributionPoint distributionPoint : distributionPoints) {
                DistributionPointName distributionPoint2 = distributionPoint.getDistributionPoint();
                if (distributionPoint2.getType() == 0) {
                    GeneralName[] names = GeneralNames.getInstance(distributionPoint2.getName()).getNames();
                    for (int i = 0; i < names.length; i++) {
                        if (names[i].getTagNo() == 6) {
                            vector.add(((DERIA5String) names[i].getName()).getString());
                        }
                    }
                }
            }
        }
        return vector;
    }

    /* access modifiers changed from: protected */
    public Vector getOCSPUrls(AuthorityInformationAccess authorityInformationAccess) {
        Vector vector = new Vector();
        if (authorityInformationAccess != null) {
            AccessDescription[] accessDescriptions = authorityInformationAccess.getAccessDescriptions();
            for (int i = 0; i < accessDescriptions.length; i++) {
                if (accessDescriptions[i].getAccessMethod().equals(AccessDescription.id_ad_ocsp)) {
                    GeneralName accessLocation = accessDescriptions[i].getAccessLocation();
                    if (accessLocation.getTagNo() == 6) {
                        vector.add(((DERIA5String) accessLocation.getName()).getString());
                    }
                }
            }
        }
        return vector;
    }

    private X509CRL getCRL(String str) throws CertPathReviewerException {
        try {
            URL url = new URL(str);
            if (!url.getProtocol().equals(HttpHost.DEFAULT_SCHEME_NAME)) {
                if (!url.getProtocol().equals("https")) {
                    return null;
                }
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                return (X509CRL) CertificateFactory.getInstance("X.509", "BC").generateCRL(httpURLConnection.getInputStream());
            }
            throw new Exception(httpURLConnection.getResponseMessage());
        } catch (Exception e) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.loadCrlDistPointError", new Object[]{new UntrustedInput(str), e.getMessage(), e, e.getClass().getName()}));
        }
    }

    /* access modifiers changed from: protected */
    public Collection getTrustAnchors(X509Certificate x509Certificate, Set set) throws CertPathReviewerException {
        ArrayList arrayList = new ArrayList();
        Iterator it = set.iterator();
        X509CertSelector x509CertSelector = new X509CertSelector();
        try {
            x509CertSelector.setSubject(getEncodedIssuerPrincipal(x509Certificate).getEncoded());
            byte[] extensionValue = x509Certificate.getExtensionValue(X509Extensions.AuthorityKeyIdentifier.getId());
            if (extensionValue != null) {
                AuthorityKeyIdentifier instance = AuthorityKeyIdentifier.getInstance(ASN1Object.fromByteArray(((ASN1OctetString) ASN1Object.fromByteArray(extensionValue)).getOctets()));
                x509CertSelector.setSerialNumber(instance.getAuthorityCertSerialNumber());
                byte[] keyIdentifier = instance.getKeyIdentifier();
                if (keyIdentifier != null) {
                    x509CertSelector.setSubjectKeyIdentifier(new DEROctetString(keyIdentifier).getEncoded());
                }
            }
            while (it.hasNext()) {
                TrustAnchor trustAnchor2 = (TrustAnchor) it.next();
                if (trustAnchor2.getTrustedCert() != null) {
                    if (x509CertSelector.match(trustAnchor2.getTrustedCert())) {
                        arrayList.add(trustAnchor2);
                    }
                } else if (!(trustAnchor2.getCAName() == null || trustAnchor2.getCAPublicKey() == null || !getEncodedIssuerPrincipal(x509Certificate).equals(new X500Principal(trustAnchor2.getCAName())))) {
                    arrayList.add(trustAnchor2);
                }
            }
            return arrayList;
        } catch (IOException unused) {
            throw new CertPathReviewerException(new ErrorBundle(RESOURCE_NAME, "CertPathReviewer.trustAnchorIssuerError"));
        }
    }
}
