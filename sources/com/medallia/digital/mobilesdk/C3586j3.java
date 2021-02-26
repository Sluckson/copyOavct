package com.medallia.digital.mobilesdk;

import com.medallia.digital.mobilesdk.MDExternalError;

/* renamed from: com.medallia.digital.mobilesdk.j3 */
class C3586j3 extends C3665p2 {

    /* renamed from: com.medallia.digital.mobilesdk.j3$a */
    enum C3587a {
        API_TOKEN_PARSE_ERROR(2001, MDExternalError.ExternalError.API_TOKEN_NOT_VALID, "Could not parse ApiToken"),
        API_TOKEN_PROPERTY_ID_NO_DATA(2002, MDExternalError.ExternalError.AUTHORIZATION_FAILED, "Property id is missing"),
        API_TOKEN_TOKEN_FIELD_NO_DATA(2003, MDExternalError.ExternalError.AUTHORIZATION_FAILED, "Token data is missing"),
        EMPTY_AUTH_GW(2004, MDExternalError.ExternalError.AUTHORIZATION_FAILED, "Auth url is missing"),
        AUTH_NETWORK_ERROR(2005, MDExternalError.ExternalError.NO_INTERNET_CONNECTION_AVAILABLE, "Authenticate network error"),
        AUTH_TIMEOUT(2006, MDExternalError.ExternalError.REQUEST_TIMEOUT, "Authenticate timeout error"),
        API_TOKEN_EMPTY(2007, MDExternalError.ExternalError.API_TOKEN_NOT_VALID, "Api token is empty"),
        ACCESS_TOKEN_PARSE(2021, MDExternalError.ExternalError.AUTHORIZATION_FAILED, "Could not parse AccessToken"),
        GET_CONFIG_EMPTY_ENDPOINT(2022, MDExternalError.ExternalError.AUTHORIZATION_FAILED, "Get config url is missing"),
        ACCESS_PROPERTY_ID_NO_DATA(2023, MDExternalError.ExternalError.AUTHORIZATION_FAILED, "Property id is missing"),
        CREATION_DATE_NO_DATA(2024, MDExternalError.ExternalError.AUTHORIZATION_FAILED, "Create time is missing"),
        TTL_NO_DATA(2025, MDExternalError.ExternalError.AUTHORIZATION_FAILED, "Ttl is missing"),
        ACCESS_TOKEN_TOKEN_FIELD_NO_DATA(2026, MDExternalError.ExternalError.AUTHORIZATION_FAILED, "Token data is missing"),
        ACCESS_TOKEN_EMPTY(2027, MDExternalError.ExternalError.API_TOKEN_NOT_VALID, "Access token is empty"),
        UUID_EMPTY(2028, (int) null, "UUID is empty"),
        RESOURCE_EMPTY_ENDPOINT(2029, (int) null, "Resource endpoint is missing"),
        GET_CONFIG_ERROR(2041, MDExternalError.ExternalError.SERVER_COM_ERROR, "Get configuration error"),
        CONFIGURATION_TIMEOUT(2042, MDExternalError.ExternalError.REQUEST_TIMEOUT, "Configuration timeout"),
        CONFIGURATION(2043, MDExternalError.ExternalError.SERVER_COM_ERROR, "Could not create configuration"),
        EMPTY_CONFIGURATION(2044, MDExternalError.ExternalError.SERVER_COM_ERROR, "Configuration is empty"),
        LOCAL_CONFIGURATION_IS_NOT_AVAILABLE(2045, MDExternalError.ExternalError.UNSPECIFIED_CONFIGURATION_ERROR_13, "Local configuration file is not available"),
        LOCAL_CONFIGURATION_TS_IS_NOT_AVAILABLE(2046, MDExternalError.ExternalError.UNSPECIFIED_CONFIGURATION_ERROR_14, "Local configuration timestamp is not available"),
        LOCAL_CONFIGURATION_IS_EXPIRED(2047, MDExternalError.ExternalError.UNSPECIFIED_CONFIGURATION_ERROR_15, "Local configuration is expired"),
        REMOTE_CONFIGURATION_AUTH_FAILED(2048, MDExternalError.ExternalError.UNSPECIFIED_CONFIGURATION_ERROR_16, "Remote configuration authentication failed"),
        REMOTE_CONFIGURATION_IS_CORRUPTED(2049, (int) null, "Remote configuration is corrupted or not available"),
        SUBMIT_FEEDBACK_ERROR(2161, (int) null, "Submit feedback error"),
        FEEDBACK_TIMEOUT(2162, MDExternalError.ExternalError.REQUEST_TIMEOUT, "Feedback timeout"),
        FEEDBACK_PARSE_ERROR(2163, (int) null, "Could not parse feedback"),
        SUBMIT_FEEDBACK_EMPTY_ENDPOINT(2164, (int) null, "Empty submit feedback endpoint"),
        EMPTY_FEEDBACK(2165, (int) null, "Feedback contains no data"),
        DESERIALIZE_FEEDBACK(2166, (int) null, "Deserialize Feedback failed"),
        DESERIALIZE_FEEDBACK_PAYLOAD(2167, (int) null, "Deserialize Feedback payload failed"),
        SUBMIT_ANALYTICS_ERROR(2171, (int) null, "Submit analytics error"),
        SUBMIT_ANALYTICS_EMPTY_ENDPOINT(2172, (int) null, "Empty submit analytics endpoint"),
        SUBMIT_ANALYTICS_ABOVE_MAX_SIZE(2173, (int) null, "Analytics elements is above max size element"),
        GET_RESOURCE_ERROR(2181, (int) null, "Get resource failed"),
        GET_RESOURCE_TIMEOUT(2182, MDExternalError.ExternalError.REQUEST_TIMEOUT, "Get resource timeout"),
        NO_INTERNET_CONNECTION_AVAILABLE(2183, MDExternalError.ExternalError.NO_INTERNET_CONNECTION_AVAILABLE, "Internet connection is not available");
        
        /* access modifiers changed from: private */

        /* renamed from: a */
        public int f1362a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f1363b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public MDExternalError.ExternalError f1364c;

        private C3587a(int i, MDExternalError.ExternalError externalError, String str) {
            this.f1362a = i;
            this.f1363b = str;
            this.f1364c = externalError;
        }

        /* renamed from: a */
        public int mo55499a() {
            return this.f1362a;
        }

        /* renamed from: b */
        public String mo55500b() {
            return this.f1363b;
        }

        public String toString() {
            return this.f1363b;
        }
    }

    protected C3586j3(C3587a aVar) {
        super(aVar.f1362a, aVar.f1364c, aVar.f1363b);
    }
}
