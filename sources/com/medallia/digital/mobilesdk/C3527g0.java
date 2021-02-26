package com.medallia.digital.mobilesdk;

import android.content.Intent;

/* renamed from: com.medallia.digital.mobilesdk.g0 */
class C3527g0 {

    /* renamed from: a */
    protected static final String f1146a = "com.medallia.digital.mobilesdk.PROPERTY_ID_CHANGE";

    /* renamed from: b */
    protected static final String f1147b = "com.medallia.digital.mobilesdk.PROPERTY_ID_VALUE";

    /* renamed from: c */
    protected static final String f1148c = "com.medallia.digital.mobilesdk.sync_userjourney_action";

    /* renamed from: com.medallia.digital.mobilesdk.g0$a */
    protected class C3528a {

        /* renamed from: b */
        protected static final String f1149b = "com.medallia.digital.mobilesdk.MedalliaFullFormActivity";

        /* renamed from: c */
        protected static final String f1150c = "com.medallia.digital.mobilesdk.MedalliaModalFormActivity";

        /* renamed from: d */
        protected static final String f1151d = "com.medallia.digital.mobilesdk.form_data";

        /* renamed from: e */
        protected static final String f1152e = "com.medallia.digital.mobilesdk.is_show_form";

        /* renamed from: f */
        protected static final String f1153f = "com.medallia.digital.mobilesdk.spinner_delay";

        /* renamed from: g */
        protected static final String f1154g = "com.medallia.digital.mobilesdk.vuln_enabled";

        /* renamed from: h */
        protected static final String f1155h = "com.medallia.digital.mobilesdk.FinishInvitationActivity";

        /* renamed from: i */
        protected static final String f1156i = "com.medallia.digital.mobilesdk.show_invitation_start_time";

        /* renamed from: j */
        protected static final String f1157j = "com.medallia.digital.mobilesdk.inherit_orientation";

        protected C3528a() {
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.g0$b */
    protected static class C3529b {

        /* renamed from: a */
        protected static final String f1159a = "com.medallia.digital.mobilesdk.file_action";

        /* renamed from: b */
        protected static final String f1160b = "com.medallia.digital.mobilesdk.extra_file_path";

        /* renamed from: c */
        protected static final String f1161c = "com.medallia.digital.mobilesdk.extra_IS_DELETED";

        /* renamed from: d */
        protected static final String f1162d = "com.medallia.digital.mobilesdk.extra_files_command";

        /* renamed from: com.medallia.digital.mobilesdk.g0$b$a */
        protected enum C3530a {
            fileDeleted
        }

        protected C3529b() {
        }

        /* renamed from: a */
        protected static void m839a(C3530a aVar, String str, boolean z) {
            Intent intent = new Intent(f1159a);
            intent.putExtra(f1162d, aVar);
            intent.putExtra(f1160b, str);
            intent.putExtra(f1161c, z);
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55541a(intent);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.g0$c */
    protected static class C3531c {

        /* renamed from: a */
        protected static final String f1165a = "com.medallia.digital.mobilesdk.form_action";

        /* renamed from: b */
        protected static final String f1166b = "com.medallia.digital.mobilesdk.feedback_action";

        /* renamed from: c */
        protected static final String f1167c = "com.medallia.digital.mobilesdk.invitation_action";

        /* renamed from: d */
        protected static final String f1168d = "com.medallia.digital.mobilesdk.extra_option";

        /* renamed from: e */
        protected static final String f1169e = "com.medallia.digital.mobilesdk.extra_timestamp";

        /* renamed from: f */
        protected static final String f1170f = "com.medallia.digital.mobilesdk.extra_form_id";

        /* renamed from: g */
        protected static final String f1171g = "com.medallia.digital.mobilesdk.extra_form_view_type";

        /* renamed from: h */
        protected static final String f1172h = "com.medallia.digital.mobilesdk.extra_form_trigger_type";

        /* renamed from: i */
        protected static final String f1173i = "com.medallia.digital.mobilesdk.extra_reason";

        /* renamed from: j */
        protected static final String f1174j = "com.medallia.digital.mobilesdk.extra_form_url";

        /* renamed from: k */
        protected static final String f1175k = "com.medallia.digital.mobilesdk.extra_form_time_to_display";

        /* renamed from: l */
        protected static final String f1176l = "com.medallia.digital.mobilesdk.extra_feedback_payload";

        /* renamed from: m */
        protected static final String f1177m = "com.medallia.digital.mobilesdk.extra_feedback_id";

        /* renamed from: com.medallia.digital.mobilesdk.g0$c$a */
        protected enum C3532a {
            formSubmitted,
            formDismissed,
            formClosed,
            formDisplayed,
            formLinkSelected,
            formBlockedUrl,
            feedbackPayload
        }

        /* renamed from: com.medallia.digital.mobilesdk.g0$c$b */
        protected enum C3533b {
            invitationDisplayed,
            invitationAccepted,
            invitationDeclined,
            invitationDeferred
        }

        protected C3531c() {
        }

        /* renamed from: a */
        protected static void m840a(C3532a aVar, String str, FormTriggerType formTriggerType) {
            m843a(aVar, str, formTriggerType, (FormViewType) null, 0);
        }

        /* renamed from: a */
        protected static void m841a(C3532a aVar, String str, FormTriggerType formTriggerType, long j) {
            m843a(aVar, str, formTriggerType, (FormViewType) null, j);
        }

        /* renamed from: a */
        protected static void m842a(C3532a aVar, String str, FormTriggerType formTriggerType, FormViewType formViewType) {
            m843a(aVar, str, formTriggerType, formViewType, 0);
        }

        /* renamed from: a */
        protected static void m843a(C3532a aVar, String str, FormTriggerType formTriggerType, FormViewType formViewType, long j) {
            m844a(aVar, str, formTriggerType, formViewType, (String) null, j);
        }

        /* renamed from: a */
        protected static void m844a(C3532a aVar, String str, FormTriggerType formTriggerType, FormViewType formViewType, String str2, long j) {
            Intent intent = new Intent(f1165a);
            intent.putExtra(f1168d, aVar);
            intent.putExtra(f1170f, str);
            intent.putExtra(f1172h, formTriggerType);
            intent.putExtra(f1169e, System.currentTimeMillis());
            intent.putExtra(f1175k, j);
            intent.putExtra(f1171g, formViewType);
            if (str2 != null) {
                intent.putExtra(f1174j, str2);
            }
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55541a(intent);
        }

        /* renamed from: a */
        protected static void m845a(C3532a aVar, String str, FormTriggerType formTriggerType, String str2) {
            m844a(aVar, str, formTriggerType, (FormViewType) null, str2, 0);
        }

        /* renamed from: a */
        protected static void m846a(C3532a aVar, String str, FormTriggerType formTriggerType, String str2, String str3) {
            Intent intent = new Intent(f1166b);
            intent.putExtra(f1168d, aVar);
            intent.putExtra(f1170f, str);
            intent.putExtra(f1172h, formTriggerType);
            intent.putExtra(f1169e, System.currentTimeMillis());
            intent.putExtra(f1177m, str2);
            intent.putExtra(f1176l, str3);
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55541a(intent);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.g0$d */
    protected static class C3534d {

        /* renamed from: a */
        protected static final String f1191a = "com.medallia.digital.mobilesdk.intercept_action";

        /* renamed from: b */
        protected static final String f1192b = "com.medallia.digital.mobilesdk.extra_timestamp";

        /* renamed from: c */
        protected static final String f1193c = "com.medallia.digital.mobilesdk.extra_id";

        /* renamed from: d */
        protected static final String f1194d = "com.medallia.digital.mobilesdk.extra_reason";

        /* renamed from: e */
        protected static final String f1195e = "com.medallia.digital.mobilesdk.extra_intercept_command";

        /* renamed from: f */
        protected static final String f1196f = "com.medallia.digital.mobilesdk.extra_engagement_type";

        /* renamed from: g */
        protected static final String f1197g = "com.medallia.digital.mobilesdk.extra_invite_type";

        /* renamed from: com.medallia.digital.mobilesdk.g0$d$a */
        protected enum C3535a {
            interceptDisplayed,
            interceptAccepted,
            interceptDeclined,
            interceptDeferred
        }

        protected C3534d() {
        }

        /* renamed from: a */
        protected static void m847a(C3535a aVar, String str, String str2, MDEngagementType mDEngagementType, C3717s2 s2Var) {
            Intent intent = new Intent(f1191a);
            intent.putExtra(f1195e, aVar);
            intent.putExtra(f1193c, str);
            intent.putExtra(f1192b, System.currentTimeMillis());
            intent.putExtra(f1196f, mDEngagementType);
            intent.putExtra(f1197g, str2);
            if (s2Var != null) {
                intent.putExtra(f1194d, s2Var);
            }
            C3605l3.m1121a(C3595k3.m1060d().mo55513b()).mo55541a(intent);
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.g0$e */
    protected class C3536e {

        /* renamed from: b */
        protected static final int f1203b = 101;

        protected C3536e() {
        }
    }

    /* renamed from: com.medallia.digital.mobilesdk.g0$f */
    protected class C3537f {

        /* renamed from: b */
        protected static final String f1205b = "com.medallia.digital.mobilesdk.SESSION_STARTED";

        /* renamed from: c */
        protected static final String f1206c = "com.medallia.digital.mobilesdk.SESSION_NUMBER_VALUE";

        /* renamed from: d */
        protected static final String f1207d = "com.medallia.digital.mobilesdk.SESSION_ID_VALUE";

        protected C3537f() {
        }
    }

    C3527g0() {
    }
}
