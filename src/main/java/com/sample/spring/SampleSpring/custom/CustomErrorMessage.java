package com.sample.spring.SampleSpring.custom;

public class CustomErrorMessage {

    private String errorMessage;
    private int errorStatus;

    public CustomErrorMessage(String errorMessage, int errorStatus) {
        this.errorMessage = errorMessage;
        this.errorStatus = errorStatus;
    }

    public CustomErrorMessage() {
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(int errorStatus) {
        this.errorStatus = errorStatus;
    }
}
