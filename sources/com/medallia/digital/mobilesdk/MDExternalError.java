package com.medallia.digital.mobilesdk;

public class MDExternalError extends MedalliaDigitalError {

    public enum ExternalError {
        REQUEST_TIMEOUT(10010, "Request Timeout"),
        NO_INTERNET_CONNECTION_AVAILABLE(10011, "No internet connection available"),
        SERVER_COM_ERROR(10012, "Server communication error"),
        UNSPECIFIED_CONFIGURATION_ERROR_13(10013, "Unspecified configuration error"),
        UNSPECIFIED_CONFIGURATION_ERROR_14(10014, "Unspecified configuration error"),
        UNSPECIFIED_CONFIGURATION_ERROR_15(10015, "Unspecified configuration error"),
        UNSPECIFIED_CONFIGURATION_ERROR_16(10016, "Unspecified configuration error"),
        AUTHORIZATION_FAILED(10020, "Authorization failed"),
        API_TOKEN_NOT_VALID(10021, "Api token is not valid"),
        APPLICATION_IS_NULL(10023, "Application is NULL"),
        SDK_NOT_INITIALIZED(10030, "SDK not initialized"),
        SDK_INITIALIZATION_IN_PROGRESS(10031, "SDK initialization in progress"),
        SDK_IS_ALREADY_INITIALIZED(10032, "SDK is already initialized"),
        APP_IS_IN_BG(10033, "App is in BG"),
        SDK_IS_KILLED(10034, "SDK functionality has been turned off"),
        SDK_WAS_STOPPED(10035, "SDK is stopped"),
        FORM_IS_NOT_AVAILABLE(10040, "Form is not available"),
        FORM_NOT_EXISTS_OR_NOT_PUBLISH(10041, "Form does not exist or is not published"),
        FORM_IS_ALREADY_DISPLAYED(10042, "A form is already displayed"),
        FORM_DISPLAY_TIMEOUT(10043, "Form Display Timeout"),
        FORM_INCORRECT_INVITATION_TYPE(10044, "Incorrect form trigger/invite");
        
        /* access modifiers changed from: private */
        public int errorCode;
        /* access modifiers changed from: private */
        public String message;

        private ExternalError(int i, String str) {
            this.errorCode = i;
            this.message = str;
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        /* access modifiers changed from: protected */
        public String getMessage() {
            return this.message;
        }

        public String toString() {
            return getMessage();
        }
    }

    protected MDExternalError(ExternalError externalError) {
        super(externalError.errorCode, externalError.message);
    }
}
