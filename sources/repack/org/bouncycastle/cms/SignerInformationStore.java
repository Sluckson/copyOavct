package repack.org.bouncycastle.cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SignerInformationStore {
    private ArrayList all = new ArrayList();
    private Map table = new HashMap();

    public SignerInformationStore(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            SignerInformation signerInformation = (SignerInformation) it.next();
            SignerId sid = signerInformation.getSID();
            if (this.table.get(sid) == null) {
                this.table.put(sid, signerInformation);
            } else {
                Object obj = this.table.get(sid);
                if (obj instanceof List) {
                    ((List) obj).add(signerInformation);
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(obj);
                    arrayList.add(signerInformation);
                    this.table.put(sid, arrayList);
                }
            }
            this.all = new ArrayList(collection);
        }
    }

    public SignerInformation get(SignerId signerId) {
        Object obj = this.table.get(signerId);
        if (obj instanceof List) {
            return (SignerInformation) ((List) obj).get(0);
        }
        return (SignerInformation) obj;
    }

    public int size() {
        return this.all.size();
    }

    public Collection getSigners() {
        return new ArrayList(this.all);
    }

    public Collection getSigners(SignerId signerId) {
        Object obj = this.table.get(signerId);
        if (obj instanceof List) {
            return new ArrayList((List) obj);
        }
        if (obj != null) {
            return Collections.singletonList(obj);
        }
        return new ArrayList();
    }
}
