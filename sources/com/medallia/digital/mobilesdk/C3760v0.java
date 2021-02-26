package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.C3697r0;
import com.medallia.digital.mobilesdk.C3815z4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* renamed from: com.medallia.digital.mobilesdk.v0 */
class C3760v0 extends C3677q1<CustomParameter> {
    protected C3760v0(C3612m0 m0Var) {
        super(m0Var);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo55525a(CustomParameter customParameter) {
        super.mo55525a(customParameter);
        C3490e3.m661b(String.format(Locale.US, "Collectors > set custom params: %s", new Object[]{customParameter.toString()}));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public CollectorContract mo55204c() {
        return C3697r0.C3698a.f1734J;
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public ValueType mo55529g() {
        return ((CustomParameter) mo55504f()).mo54994c() == null ? ValueType.TypeString : ((CustomParameter) mo55504f()).mo54994c() instanceof Integer ? ValueType.TypeInteger : ((CustomParameter) mo55504f()).mo54994c() instanceof Double ? ValueType.TypeDouble : ((CustomParameter) mo55504f()).mo54994c() instanceof Long ? ValueType.TypeLong : ((CustomParameter) mo55504f()).mo54994c() instanceof Boolean ? ValueType.TypeBoolean : ValueType.TypeString;
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public ArrayList<CustomParameter> mo55873j() {
        ArrayList<CustomParameter> customParameterArray = ModelFactory.getInstance().getCustomParameterArray(C3815z4.m2010d().mo55981b(C3815z4.C3816a.CUSTOM_PARAMETERS));
        ArrayList<CustomParameter> arrayList = new ArrayList<>();
        if (customParameterArray == null) {
            return arrayList;
        }
        Iterator<CustomParameter> it = customParameterArray.iterator();
        while (it.hasNext()) {
            CustomParameter next = it.next();
            if (!(next == null || next.mo54990a() == null)) {
                arrayList.add(next.mo54999f());
            }
        }
        return arrayList;
    }
}
