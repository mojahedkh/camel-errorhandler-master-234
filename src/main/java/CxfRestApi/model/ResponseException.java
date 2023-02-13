package CxfRestApi.model;

import com.google.gson.annotations.SerializedName;

public class ResponseException {
    @SerializedName("responseCode")
    private String mResponseCode;
    @SerializedName("responseMessage")
    private String mResponseMessage;

    @SerializedName("exceptionMessage")
    private  String mExceptionMessage ;

    public String getResponseCode() {
        return mResponseCode;
    }

    public String getResponseMessage() {
        return mResponseMessage;
    }

    public static class Builder {

        private String mResponseCode;
        private String mResponseMessage;

        private  String mExceptionMessage ;


        public ResponseException.Builder withResponseCode(String responseCode) {
            mResponseCode = responseCode;
            return this;
        }

        public ResponseException.Builder withResponseMessage(String responseMessage) {
            mResponseMessage = responseMessage;
            return this;
        }

        public ResponseException.Builder withmExceptionMessage(String responseMessage) {
            mExceptionMessage = responseMessage;
            return this;
        }
        public ResponseException build() {
            ResponseException responseException = new ResponseException();
            responseException.mResponseCode = mResponseCode;
            responseException.mResponseMessage = mResponseMessage;
            responseException.mExceptionMessage = mExceptionMessage;
            return responseException;
        }

    }

    @Override
    public String toString() {
        return "responseException{" +
                "mResponseCode='" + mResponseCode + '\'' +
                ", mResponseMessage='" + mResponseMessage + '\'' +
                '}';
    }
}
