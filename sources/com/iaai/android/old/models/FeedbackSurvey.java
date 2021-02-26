package com.iaai.android.old.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

public class FeedbackSurvey implements Parcelable {
    public static final Parcelable.Creator<FeedbackSurvey> CREATOR = new Parcelable.Creator<FeedbackSurvey>() {
        public FeedbackSurvey createFromParcel(Parcel parcel) {
            return new FeedbackSurvey(parcel);
        }

        public FeedbackSurvey[] newArray(int i) {
            return new FeedbackSurvey[i];
        }
    };
    @SerializedName("isSurveyActive")
    public String isSurveyActive;
    @SerializedName("surveyURL")
    public String surveyUrl;

    public int describeContents() {
        return 0;
    }

    public FeedbackSurvey() {
    }

    public FeedbackSurvey(Parcel parcel) {
        this.isSurveyActive = parcel.readString();
        this.surveyUrl = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.isSurveyActive);
        parcel.writeString(this.surveyUrl);
    }
}
