package com.iaai.android.old.managers;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.iaai.android.C2723R;
import com.iaai.android.IaaiApplication;
import com.iaai.android.bdt.feature.login.SessionManager;
import com.iaai.android.bdt.utils.Utils;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class FeedbackSurveyManager {
    private static AsyncHttpClient client = new AsyncHttpClient();
    final IaaiApplication application;
    private SessionManager sessionManager = IaaiApplication.getInstance().getComponent().sessionManager();

    @Inject
    private FeedbackSurveyManager(Provider<IaaiApplication> provider) {
        this.application = provider.get();
    }

    public void loadFeedbackSurvey(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        this.sessionManager.getCurrentSessionUsername() + ":" + this.sessionManager.getCurrentSessionPassword();
        client.addHeader("User-Agent", Utils.getUserAgent());
        client.get(this.application.getResources().getString(C2723R.string.base_https_url) + this.application.getResources().getString(C2723R.string.service_feedback_survey), asyncHttpResponseHandler);
    }
}
